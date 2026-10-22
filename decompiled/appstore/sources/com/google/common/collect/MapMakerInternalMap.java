package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Equivalence;
import com.google.common.base.Preconditions;
import com.google.common.collect.MapMakerInternalMap.InternalEntry;
import com.google.common.collect.MapMakerInternalMap.Segment;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.google.j2objc.annotations.Weak;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
class MapMakerInternalMap<K, V, E extends InternalEntry<K, V, E>, S extends Segment<K, V, E, S>> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {
    static final long CLEANUP_EXECUTOR_DELAY_SECS = 60;
    static final int CONTAINS_VALUE_RETRIES = 3;
    static final int DRAIN_MAX = 16;
    static final int DRAIN_THRESHOLD = 63;
    static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MAX_SEGMENTS = 65536;
    static final WeakValueReference<Object, Object, DummyInternalEntry> UNSET_WEAK_VALUE_REFERENCE = null;
    private static final long serialVersionUID = 5;
    final int concurrencyLevel;
    final transient InternalEntryHelper<K, V, E, S> entryHelper;

    @MonotonicNonNullDecl
    transient Set<Map.Entry<K, V>> entrySet;
    final Equivalence<Object> keyEquivalence;

    @MonotonicNonNullDecl
    transient Set<K> keySet;
    final transient int segmentMask;
    final transient int segmentShift;
    final transient Segment<K, V, E, S>[] segments;

    @MonotonicNonNullDecl
    transient Collection<V> values;

    public static abstract class AbstractSerializationProxy<K, V> extends ForwardingConcurrentMap<K, V> implements Serializable {
        private static final long serialVersionUID = 3;
        final int concurrencyLevel;
        transient ConcurrentMap<K, V> delegate;
        final Equivalence<Object> keyEquivalence;
        final Strength keyStrength;
        final Equivalence<Object> valueEquivalence;
        final Strength valueStrength;

        public AbstractSerializationProxy(Strength r10, Strength r11, Equivalence<Object> r12, Equivalence<Object> r13, int r14, ConcurrentMap<K, V> r15) {
            this.keyStrength = r10;
            this.valueStrength = r11;
            this.keyEquivalence = r12;
            this.valueEquivalence = r13;
            this.concurrencyLevel = r14;
            this.delegate = r15;
        }

        @Override // com.google.common.collect.ForwardingConcurrentMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        public void readEntries(ObjectInputStream r10) throws IOException, ClassNotFoundException {
        L2:
            Object r11 = r10.readObject();
            if (r11 == null) goto L4;
            Object r12 = r10.readObject();
            this.delegate.put((K) r11, (V) r12);
            goto L2
        }

        public MapMaker readMapMaker(ObjectInputStream r10) throws IOException {
            int r11 = r10.readInt();
            return new MapMaker().initialCapacity(r11).setKeyStrength(this.keyStrength).setValueStrength(this.valueStrength).keyEquivalence(this.keyEquivalence).concurrencyLevel(this.concurrencyLevel);
        }

        public void writeMapTo(ObjectOutputStream r10) throws IOException {
            r10.writeInt(this.delegate.size());
            Iterator<Map.Entry<K, V>> r11 = this.delegate.entrySet().iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            Map.Entry<K, V> r12 = r11.next();
            r10.writeObject(r12.getKey());
            r10.writeObject(r12.getValue());
            goto L4
        L6:
            r10.writeObject(null);
        }

        @Override // com.google.common.collect.ForwardingConcurrentMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Map delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingConcurrentMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        public ConcurrentMap<K, V> delegate() {
            return this.delegate;
        }
    }

    public static abstract class AbstractStrongKeyEntry<K, V, E extends InternalEntry<K, V, E>> implements InternalEntry<K, V, E> {
        final int hash;
        final K key;

        @NullableDecl
        final E next;

        public AbstractStrongKeyEntry(K r10, int r11, @NullableDecl E r12) {
            this.key = r10;
            this.hash = r11;
            this.next = r12;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public int getHash() {
            return this.hash;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public K getKey() {
            return this.key;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public E getNext() {
            return this.next;
        }
    }

    public static abstract class AbstractWeakKeyEntry<K, V, E extends InternalEntry<K, V, E>> extends WeakReference<K> implements InternalEntry<K, V, E> {
        final int hash;

        @NullableDecl
        final E next;

        public AbstractWeakKeyEntry(ReferenceQueue<K> r10, K r11, int r12, @NullableDecl E r13) {
            super(r11, r10);
            this.hash = r12;
            this.next = r13;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public int getHash() {
            return this.hash;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public K getKey() {
            return get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public E getNext() {
            return this.next;
        }
    }

    public static final class CleanupMapTask implements Runnable {
        final WeakReference<MapMakerInternalMap<?, ?, ?, ?>> mapReference;

        public CleanupMapTask(MapMakerInternalMap<?, ?, ?, ?> r10) {
            this.mapReference = new WeakReference(r10);
        }

        @Override // java.lang.Runnable
        public void run() {
            MapMakerInternalMap<?, ?, ?, ?> r10 = this.mapReference.get();
            if (r10 == null) goto L9;
            Segment<?, ?, E, S>[] r11 = r10.segments;
            int r12 = r11.length;
            int r13 = 0;
        L5:
            if (r13 >= r12) goto L7;
            r11[r13].runCleanup();
            r13 = r13 + 1;
            goto L5
        L7:
            return;
        L9:
            throw new CancellationException();
        }
    }

    public static final class DummyInternalEntry implements InternalEntry<Object, Object, DummyInternalEntry> {
        private DummyInternalEntry() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public int getHash() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public Object getKey() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public /* bridge */ /* synthetic */ InternalEntry getNext() {
            return getNext();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public Object getValue() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public DummyInternalEntry getNext() {
            throw new AssertionError();
        }
    }

    public final class EntryIterator extends MapMakerInternalMap<K, V, E, S>.HashIterator<Map.Entry<K, V>> {
        final /* synthetic */ MapMakerInternalMap this$0;

        public EntryIterator(MapMakerInternalMap r10) {
            this.this$0 = r10;
            super(r10);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.HashIterator, java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.HashIterator, java.util.Iterator
        public Map.Entry<K, V> next() {
            return nextEntry();
        }
    }

    public final class EntrySet extends SafeToArraySet<Map.Entry<K, V>> {
        final /* synthetic */ MapMakerInternalMap this$0;

        public EntrySet(MapMakerInternalMap r10) {
            this.this$0 = r10;
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.this$0.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r10) {
            if ((r10 instanceof Map.Entry) == true) goto L5;
            return false;
        L5:
            Map.Entry r11 = (Map.Entry) r10;
            Object r12 = r11.getKey();
            if (r12 != null) goto L8;
            return false;
        L8:
            Object r13 = this.this$0.get(r12);
            if (r13 != null) goto L11;
            return false;
        L11:
            if (this.this$0.valueEquivalence().equivalent(r11.getValue(), r13) == false) goto L15;
            return true;
        L15:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.this$0.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator(this.this$0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r10) {
            if ((r10 instanceof Map.Entry) == true) goto L5;
            return false;
        L5:
            Map.Entry r11 = (Map.Entry) r10;
            Object r12 = r11.getKey();
            if (r12 != null) goto L8;
            return false;
        L8:
            if (this.this$0.remove(r12, r11.getValue()) == false) goto L12;
            return true;
        L12:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.size();
        }
    }

    public abstract class HashIterator<T> implements Iterator<T> {

        @MonotonicNonNullDecl
        Segment<K, V, E, S> currentSegment;

        @MonotonicNonNullDecl
        AtomicReferenceArray<E> currentTable;

        @NullableDecl
        MapMakerInternalMap<K, V, E, S>.WriteThroughEntry lastReturned;

        @NullableDecl
        E nextEntry;

        @NullableDecl
        MapMakerInternalMap<K, V, E, S>.WriteThroughEntry nextExternal;
        int nextSegmentIndex;
        int nextTableIndex;
        final /* synthetic */ MapMakerInternalMap this$0;

        public HashIterator(MapMakerInternalMap r10) {
            this.this$0 = r10;
            this.nextSegmentIndex = r10.segments.length - 1;
            this.nextTableIndex = -1;
            advance();
        }

        public final void advance() {
            this.nextExternal = null;
            if (nextInChain() == false) goto L6;
            return;
        L6:
            if (nextInTable() == false) goto L8;
            return;
        L8:
            int r10 = this.nextSegmentIndex;
            if (r10 < 0) goto L14;
            Segment<K, V, E, S>[] r11 = this.this$0.segments;
            this.nextSegmentIndex = r10 - 1;
            Segment<K, V, E, S> r12 = r11[r10];
            this.currentSegment = r12;
            if (r12.count == 0) goto L8;
            AtomicReferenceArray<E> r13 = this.currentSegment.table;
            this.currentTable = r13;
            this.nextTableIndex = r13.length() - 1;
            if (nextInTable() == false) goto L8;
            return;
        }

        public boolean advanceTo(E r10) {
            Object r11 = r10.getKey();     // Catch: Throwable -> L7
            Object r12 = this.this$0.getLiveValue(r10);     // Catch: Throwable -> L7
            if (r12 == null) goto L9;
            this.nextExternal = new WriteThroughEntry(this.this$0, r11, r12);     // Catch: Throwable -> L7
            this.currentSegment.postReadCleanup();
            return true;
        L9:
            this.currentSegment.postReadCleanup();
            return false;
        L7:
            th = move-exception;
            this.currentSegment.postReadCleanup();
            throw th;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nextExternal == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public abstract T next();

        public MapMakerInternalMap<K, V, E, S>.WriteThroughEntry nextEntry() {
            MapMakerInternalMap<K, V, E, S>.WriteThroughEntry r10 = this.nextExternal;
            if (r10 == null) goto L7;
            this.lastReturned = r10;
            advance();
            return this.lastReturned;
        L7:
            throw new NoSuchElementException();
        }

        public boolean nextInChain() {
            E r10 = this.nextEntry;
            if (r10 == null) goto L11;
        L4:
            this.nextEntry = (E) r10.getNext();
            E r11 = this.nextEntry;
            if (r11 == null) goto L15;
            if (advanceTo(r11) == true) goto L8;
            r10 = this.nextEntry;
            goto L4
        L8:
            return true;
        L15:
            return false;
        L11:
            return false;
        }

        public boolean nextInTable() {
        L2:
            int r10 = this.nextTableIndex;
            if (r10 < 0) goto L12;
            AtomicReferenceArray<E> r11 = this.currentTable;
            this.nextTableIndex = r10 - 1;
            E r12 = r11.get(r10);
            this.nextEntry = r12;
            if (r12 == null) goto L2;
            if (advanceTo(r12) == true) goto L10;
            if (nextInChain() == false) goto L2;
            return true;
        L10:
            return true;
        L12:
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.lastReturned == null) goto L5;
            boolean r10 = true;
        L6:
            CollectPreconditions.checkRemove(r10);
            this.this$0.remove(this.lastReturned.getKey());
            this.lastReturned = null;
            return;
        L5:
            r10 = false;
            goto L6
        }
    }

    public interface InternalEntry<K, V, E extends InternalEntry<K, V, E>> {
        int getHash();

        K getKey();

        E getNext();

        V getValue();
    }

    public interface InternalEntryHelper<K, V, E extends InternalEntry<K, V, E>, S extends Segment<K, V, E, S>> {
        E copy(S r10, E r11, @NullableDecl E r12);

        Strength keyStrength();

        E newEntry(S r10, K r11, int r12, @NullableDecl E r13);

        S newSegment(MapMakerInternalMap<K, V, E, S> r10, int r11, int r12);

        void setValue(S r10, E r11, V r12);

        Strength valueStrength();
    }

    public final class KeyIterator extends MapMakerInternalMap<K, V, E, S>.HashIterator<K> {
        final /* synthetic */ MapMakerInternalMap this$0;

        public KeyIterator(MapMakerInternalMap r10) {
            this.this$0 = r10;
            super(r10);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.HashIterator, java.util.Iterator
        public K next() {
            return nextEntry().getKey();
        }
    }

    public final class KeySet extends SafeToArraySet<K> {
        final /* synthetic */ MapMakerInternalMap this$0;

        public KeySet(MapMakerInternalMap r10) {
            this.this$0 = r10;
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.this$0.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r10) {
            return this.this$0.containsKey(r10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.this$0.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new KeyIterator(this.this$0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r10) {
            if (this.this$0.remove(r10) == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.size();
        }
    }

    public static abstract class SafeToArraySet<E> extends AbstractSet<E> {
        private SafeToArraySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return MapMakerInternalMap.access$900(this).toArray();
        }

        public /* synthetic */ SafeToArraySet(AnonymousClass1 r10) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] r10) {
            return (T[]) MapMakerInternalMap.access$900(this).toArray(r10);
        }
    }

    public static abstract class Segment<K, V, E extends InternalEntry<K, V, E>, S extends Segment<K, V, E, S>> extends ReentrantLock {
        volatile int count;

        @Weak
        final MapMakerInternalMap<K, V, E, S> map;
        final int maxSegmentSize;
        int modCount;
        final AtomicInteger readCount;

        @MonotonicNonNullDecl
        volatile AtomicReferenceArray<E> table;
        int threshold;

        public Segment(MapMakerInternalMap<K, V, E, S> r10, int r11, int r12) {
            this.readCount = new AtomicInteger();
            this.map = r10;
            this.maxSegmentSize = r12;
            initTable(newEntryArray(r11));
        }

        public static <K, V, E extends InternalEntry<K, V, E>> boolean isCollected(E r10) {
            if (r10.getValue() != null) goto L5;
            return true;
        L5:
            return false;
        }

        public abstract E castForTesting(InternalEntry<K, V, ?> r10);

        public void clear() {
            if (this.count == 0) goto L15;
            lock();
            AtomicReferenceArray<E> r10 = this.table;     // Catch: Throwable -> L9
            int r11 = 0;
        L7:
            if (r11 >= r10.length()) goto L11;
            r10.set(r11, null);     // Catch: Throwable -> L9
            r11 = r11 + 1;     // Catch: Throwable -> L9
            goto L7
        L11:
            maybeClearReferenceQueues();     // Catch: Throwable -> L9
            this.readCount.set(0);     // Catch: Throwable -> L9
            this.modCount++;     // Catch: Throwable -> L9
            this.count = 0;     // Catch: Throwable -> L9
            unlock();
            return;
        L9:
            th = move-exception;
            unlock();
            throw th;
        }

        public <T> void clearReferenceQueue(ReferenceQueue<T> r10) {
        L3:
            if (r10.poll() != null) goto L3;
        }

        @CanIgnoreReturnValue
        public boolean clearValueForTesting(K r10, int r11, WeakValueReference<K, V, ? extends InternalEntry<K, V, ?>> r12) {
            lock();
            AtomicReferenceArray<E> r13 = this.table;     // Catch: Throwable -> L16
            int r14 = (r13.length() - 1) & r11;     // Catch: Throwable -> L16
            E r15 = r13.get(r14);     // Catch: Throwable -> L16
            InternalEntry r16 = r15;
        L5:
            if (r16 == null) goto L22;
            Object r17 = r16.getKey();     // Catch: Throwable -> L16
            if (r16.getHash() != r11) goto L20;
            if (r17 == null) goto L20;
            if (this.map.keyEquivalence.equivalent(r10, r17) == false) goto L20;
            if (((WeakValueEntry) r16).getValueReference() != r12) goto L18;
            r13.set(r14, (E) removeFromChain(r15, r16));     // Catch: Throwable -> L16
            unlock();
            return true;
        L18:
            unlock();
            return false;
        L20:
            r16 = r16.getNext();     // Catch: Throwable -> L16
            goto L5
        L22:
            unlock();
            return false;
        L16:
            th = move-exception;
            unlock();
            throw th;
        }

        public boolean containsKey(Object r10, int r11) {
            boolean r12 = false;
            if (this.count == 0) goto L13;
            InternalEntry r13 = getLiveEntry(r10, r11);     // Catch: Throwable -> L9
            if (r13 == null) goto L11;
            if (r13.getValue() == null) goto L11;
            r12 = true;
        L11:
            postReadCleanup();
            return r12;
        L13:
            postReadCleanup();
            return false;
        L9:
            th = move-exception;
            postReadCleanup();
            throw th;
        }

        @VisibleForTesting
        public boolean containsValue(Object r10) {
        L17:
            th = move-exception;
            postReadCleanup();
            throw th;
        L3:
            if (this.count == 0) goto L20;
            AtomicReferenceArray<E> r11 = this.table;     // Catch: Throwable -> L17
            int r12 = r11.length();     // Catch: Throwable -> L17
            int r13 = 0;
        L5:
            if (r13 >= r12) goto L20;
            E r14 = r11.get(r13);     // Catch: Throwable -> L17
        L7:
            if (r14 == null) goto L19;
            V r15 = getLiveValue(r14);     // Catch: Throwable -> L17
            if (r15 != null) goto L12;
        L15:
            r14 = r14.getNext();     // Catch: Throwable -> L17
            goto L7
        L12:
            if (this.map.valueEquivalence().equivalent(r10, r15) == false) goto L15;
            postReadCleanup();
            return true;
        L19:
            r13 = r13 + 1;
        L20:
            postReadCleanup();
            return false;
        }

        public E copyEntry(E r10, E r11) {
            return (E) this.map.entryHelper.copy(self(), r10, r11);
        }

        public E copyForTesting(InternalEntry<K, V, ?> r10, @NullableDecl InternalEntry<K, V, ?> r11) {
            return (E) this.map.entryHelper.copy(self(), castForTesting(r10), castForTesting(r11));
        }

        @GuardedBy("this")
        public void drainKeyReferenceQueue(ReferenceQueue<K> r10) {
            int r11 = 0;
        L3:
            Reference<? extends K> r12 = r10.poll();
            if (r12 == null) goto L7;
            MapMakerInternalMap<K, V, E, S> r13 = this.map;
            r13.reclaimKey((InternalEntry) r12);
            r11 = r11 + 1;
            if (r11 != 16) goto L3;
            return;
        }

        @GuardedBy("this")
        public void drainValueReferenceQueue(ReferenceQueue<V> r10) {
            int r11 = 0;
        L3:
            Reference<? extends V> r12 = r10.poll();
            if (r12 == null) goto L7;
            MapMakerInternalMap<K, V, E, S> r13 = this.map;
            r13.reclaimValue((WeakValueReference) r12);
            r11 = r11 + 1;
            if (r11 != 16) goto L3;
            return;
        }

        @GuardedBy("this")
        public void expand() {
            AtomicReferenceArray<E> r10 = this.table;
            int r11 = r10.length();
            if (r11 < 1073741824) goto L5;
            return;
        L5:
            int r12 = this.count;
            AtomicReferenceArray<E> r13 = newEntryArray(r11 << 1);
            this.threshold = (r13.length() * 3) / 4;
            int r14 = r13.length() - 1;
            int r15 = 0;
        L6:
            if (r15 >= r11) goto L26;
            E r16 = r10.get(r15);
            if (r16 == null) goto L25;
            InternalEntry r17 = r16.getNext();
            int r18 = r16.getHash() & r14;
            if (r17 != null) goto L12;
            r13.set(r18, r16);
            goto L25
        L12:
            InternalEntry r19 = r16;
        L13:
            if (r17 == null) goto L18;
            int r110 = r17.getHash() & r14;
            if (r110 == r18) goto L17;
            r19 = r17;
            r18 = r110;
        L17:
            r17 = r17.getNext();
            goto L13
        L18:
            r13.set(r18, r19);
        L19:
            if (r16 == r19) goto L25;
            int r20 = r16.getHash() & r14;
            InternalEntry r21 = copyEntry(r16, (InternalEntry) r13.get(r20));
            if (r21 == null) goto L23;
            r13.set(r20, r21);
        L24:
            r16 = r16.getNext();
            goto L19
        L23:
            r12 = r12 - 1;
        L25:
            r15 = r15 + 1;
            goto L6
        L26:
            this.table = r13;
            this.count = r12;
        }

        public V get(Object r10, int r11) {
            InternalEntry r12 = getLiveEntry(r10, r11);     // Catch: Throwable -> L10
            if (r12 != null) goto L6;
            postReadCleanup();
            return null;
        L6:
            V r13 = (V) r12.getValue();
            if (r13 != null) goto L12;
            tryDrainReferenceQueues();     // Catch: Throwable -> L10
        L12:
            postReadCleanup();
            return r13;
        L10:
            th = move-exception;
            postReadCleanup();
            throw th;
        }

        public E getEntry(Object r10, int r11) {
            if (this.count == 0) goto L16;
            E r12 = (E) getFirst(r11);
        L5:
            if (r12 == null) goto L23;
            if (r12.getHash() != r11) goto L15;
            Object r13 = r12.getKey();
            if (r13 != null) goto L13;
            tryDrainReferenceQueues();
            goto L15
        L13:
            if (this.map.keyEquivalence.equivalent(r10, r13) == false) goto L15;
            return r12;
        L15:
            r12 = (E) r12.getNext();
            goto L5
        L23:
            return null;
        L16:
            return null;
        }

        public E getFirst(int r10) {
            AtomicReferenceArray<E> r11 = this.table;
            return r11.get(r10 & (r11.length() - 1));
        }

        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            throw new AssertionError();
        }

        public E getLiveEntry(Object r10, int r11) {
            return (E) getEntry(r10, r11);
        }

        @NullableDecl
        public V getLiveValue(E r10) {
            if (r10.getKey() != null) goto L6;
            tryDrainReferenceQueues();
            return null;
        L6:
            V r11 = (V) r10.getValue();
            if (r11 != null) goto L10;
            tryDrainReferenceQueues();
            return null;
        L10:
            return r11;
        }

        @NullableDecl
        public V getLiveValueForTesting(InternalEntry<K, V, ?> r10) {
            return getLiveValue(castForTesting(r10));
        }

        public ReferenceQueue<V> getValueReferenceQueueForTesting() {
            throw new AssertionError();
        }

        public WeakValueReference<K, V, E> getWeakValueReferenceForTesting(InternalEntry<K, V, ?> r10) {
            throw new AssertionError();
        }

        public void initTable(AtomicReferenceArray<E> r10) {
            int r11 = (r10.length() * 3) / 4;
            this.threshold = r11;
            if (r11 != this.maxSegmentSize) goto L5;
            this.threshold = r11 + 1;
        L5:
            this.table = r10;
        }

        public void maybeClearReferenceQueues() {
        }

        @GuardedBy("this")
        public void maybeDrainReferenceQueues() {
        }

        public AtomicReferenceArray<E> newEntryArray(int r10) {
            return new AtomicReferenceArray(r10);
        }

        public E newEntryForTesting(K r10, int r11, @NullableDecl InternalEntry<K, V, ?> r12) {
            return (E) this.map.entryHelper.newEntry(self(), r10, r11, castForTesting(r12));
        }

        public WeakValueReference<K, V, E> newWeakValueReferenceForTesting(InternalEntry<K, V, ?> r10, V r11) {
            throw new AssertionError();
        }

        public void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) != 0) goto L6;
            runCleanup();
            return;
        }

        @GuardedBy("this")
        public void preWriteCleanup() {
            runLockedCleanup();
        }

        public V put(K r10, int r11, V r12, boolean r13) {
            lock();
            preWriteCleanup();     // Catch: Throwable -> L6
            int r14 = this.count + 1;     // Catch: Throwable -> L6
            if (r14 <= this.threshold) goto L8;
            expand();     // Catch: Throwable -> L6
            r14 = this.count + 1;     // Catch: Throwable -> L6
        L8:
            AtomicReferenceArray<E> r15 = this.table;     // Catch: Throwable -> L6
            int r16 = (r15.length() - 1) & r11;     // Catch: Throwable -> L6
            E r17 = r15.get(r16);     // Catch: Throwable -> L6
            InternalEntry r18 = r17;
        L10:
            if (r18 == null) goto L28;
            Object r19 = r18.getKey();     // Catch: Throwable -> L6
            if (r18.getHash() != r11) goto L27;
            if (r19 == null) goto L27;
            if (this.map.keyEquivalence.equivalent(r10, r19) == false) goto L27;
            V r20 = (V) r18.getValue();
            if (r20 != null) goto L21;
            this.modCount++;     // Catch: Throwable -> L6
            setValue(r18, r12);     // Catch: Throwable -> L6
            this.count = this.count;     // Catch: Throwable -> L6
            unlock();
            return null;
        L21:
            if (r13 == false) goto L24;
            unlock();
            return r20;
        L24:
            this.modCount++;     // Catch: Throwable -> L6
            setValue(r18, r12);     // Catch: Throwable -> L6
            unlock();
            return r20;
        L27:
            r18 = r18.getNext();     // Catch: Throwable -> L6
            goto L10
        L28:
            this.modCount++;     // Catch: Throwable -> L6
            InternalEntry r21 = this.map.entryHelper.newEntry(self(), r10, r11, r17);     // Catch: Throwable -> L6
            setValue(r21, r12);     // Catch: Throwable -> L6
            r15.set(r16, (E) r21);     // Catch: Throwable -> L6
            this.count = r14;     // Catch: Throwable -> L6
            unlock();
            return null;
        L6:
            th = move-exception;
            unlock();
            throw th;
        }

        @CanIgnoreReturnValue
        public boolean reclaimKey(E r10, int r11) {
            lock();
            AtomicReferenceArray<E> r12 = this.table;     // Catch: Throwable -> L9
            int r13 = r11 & (r12.length() - 1);     // Catch: Throwable -> L9
            E r14 = r12.get(r13);     // Catch: Throwable -> L9
            InternalEntry r15 = r14;
        L4:
            if (r15 == null) goto L13;
            if (r15 == r10) goto L6;
            r15 = r15.getNext();     // Catch: Throwable -> L9
            goto L4
        L6:
            this.modCount++;     // Catch: Throwable -> L9
            InternalEntry r16 = removeFromChain(r14, r15);     // Catch: Throwable -> L9
            int r17 = this.count - 1;     // Catch: Throwable -> L9
            r12.set(r13, (E) r16);     // Catch: Throwable -> L9
            this.count = r17;     // Catch: Throwable -> L9
            unlock();
            return true;
        L13:
            unlock();
            return false;
        L9:
            th = move-exception;
            unlock();
            throw th;
        }

        @CanIgnoreReturnValue
        public boolean reclaimValue(K r10, int r11, WeakValueReference<K, V, E> r12) {
            lock();
            AtomicReferenceArray<E> r13 = this.table;     // Catch: Throwable -> L16
            int r14 = (r13.length() - 1) & r11;     // Catch: Throwable -> L16
            E r15 = r13.get(r14);     // Catch: Throwable -> L16
            InternalEntry r16 = r15;
        L5:
            if (r16 == null) goto L22;
            Object r17 = r16.getKey();     // Catch: Throwable -> L16
            if (r16.getHash() != r11) goto L20;
            if (r17 == null) goto L20;
            if (this.map.keyEquivalence.equivalent(r10, r17) == false) goto L20;
            if (((WeakValueEntry) r16).getValueReference() != r12) goto L18;
            this.modCount++;     // Catch: Throwable -> L16
            InternalEntry r18 = removeFromChain(r15, r16);     // Catch: Throwable -> L16
            int r19 = this.count - 1;     // Catch: Throwable -> L16
            r13.set(r14, (E) r18);     // Catch: Throwable -> L16
            this.count = r19;     // Catch: Throwable -> L16
            unlock();
            return true;
        L18:
            unlock();
            return false;
        L20:
            r16 = r16.getNext();     // Catch: Throwable -> L16
            goto L5
        L22:
            unlock();
            return false;
        L16:
            th = move-exception;
            unlock();
            throw th;
        }

        @CanIgnoreReturnValue
        public V remove(Object r10, int r11) {
            lock();
            preWriteCleanup();     // Catch: Throwable -> L19
            AtomicReferenceArray<E> r12 = this.table;     // Catch: Throwable -> L19
            int r13 = (r12.length() - 1) & r11;     // Catch: Throwable -> L19
            E r14 = r12.get(r13);     // Catch: Throwable -> L19
            InternalEntry r15 = r14;
        L5:
            if (r15 == null) goto L25;
            Object r16 = r15.getKey();     // Catch: Throwable -> L19
            if (r15.getHash() != r11) goto L23;
            if (r16 == null) goto L23;
            if (this.map.keyEquivalence.equivalent(r10, r16) == false) goto L23;
            V r17 = (V) r15.getValue();
            if (r17 == null) goto L15;
        L16:
            this.modCount++;     // Catch: Throwable -> L19
            InternalEntry r18 = removeFromChain(r14, r15);     // Catch: Throwable -> L19
            int r19 = this.count - 1;     // Catch: Throwable -> L19
            r12.set(r13, (E) r18);     // Catch: Throwable -> L19
            this.count = r19;     // Catch: Throwable -> L19
            unlock();
            return r17;
        L15:
            if (isCollected(r15) == true) goto L16;
            unlock();
            return null;
        L23:
            r15 = r15.getNext();     // Catch: Throwable -> L19
            goto L5
        L25:
            unlock();
            return null;
        L19:
            th = move-exception;
            unlock();
            throw th;
        }

        @GuardedBy("this")
        public boolean removeEntryForTesting(E r10) {
            int r11 = r10.getHash();
            AtomicReferenceArray<E> r12 = this.table;
            int r13 = r11 & (r12.length() - 1);
            E r14 = r12.get(r13);
            InternalEntry r15 = r14;
        L3:
            if (r15 == null) goto L8;
            if (r15 == r10) goto L5;
            r15 = r15.getNext();
            goto L3
        L5:
            this.modCount++;
            InternalEntry r16 = removeFromChain(r14, r15);
            int r17 = this.count - 1;
            r12.set(r13, (E) r16);
            this.count = r17;
            return true;
        L8:
            return false;
        }

        @GuardedBy("this")
        public E removeFromChain(E r10, E r11) {
            int r12 = this.count;
            E r13 = (E) r11.getNext();
        L3:
            if (r10 == r11) goto L9;
            InternalEntry r14 = copyEntry(r10, r13);
            if (r14 == null) goto L7;
            r13 = (E) r14;
        L8:
            r10 = (E) r10.getNext();
            goto L3
        L7:
            r12 = r12 - 1;
            goto L8
        L9:
            this.count = r12;
            return r13;
        }

        public E removeFromChainForTesting(InternalEntry<K, V, ?> r10, InternalEntry<K, V, ?> r11) {
            return (E) removeFromChain(castForTesting(r10), castForTesting(r11));
        }

        @CanIgnoreReturnValue
        public boolean removeTableEntryForTesting(InternalEntry<K, V, ?> r10) {
            return removeEntryForTesting(castForTesting(r10));
        }

        public boolean replace(K r10, int r11, V r12, V r13) {
            lock();
            preWriteCleanup();     // Catch: Throwable -> L17
            AtomicReferenceArray<E> r14 = this.table;     // Catch: Throwable -> L17
            int r15 = (r14.length() - 1) & r11;     // Catch: Throwable -> L17
            E r16 = r14.get(r15);     // Catch: Throwable -> L17
            InternalEntry r17 = r16;
        L5:
            if (r17 == null) goto L30;
            Object r18 = r17.getKey();     // Catch: Throwable -> L17
            if (r17.getHash() != r11) goto L28;
            if (r18 == null) goto L28;
            if (this.map.keyEquivalence.equivalent(r10, r18) == false) goto L28;
            Object r19 = r17.getValue();     // Catch: Throwable -> L17
            if (r19 != null) goto L22;
            if (isCollected(r17) == false) goto L19;
            this.modCount++;     // Catch: Throwable -> L17
            InternalEntry r20 = removeFromChain(r16, r17);     // Catch: Throwable -> L17
            int r110 = this.count - 1;     // Catch: Throwable -> L17
            r14.set(r15, (E) r20);     // Catch: Throwable -> L17
            this.count = r110;     // Catch: Throwable -> L17
        L19:
            unlock();
            return false;
        L22:
            if (this.map.valueEquivalence().equivalent(r12, r19) == false) goto L26;
            this.modCount++;     // Catch: Throwable -> L17
            setValue(r17, r13);     // Catch: Throwable -> L17
            unlock();
            return true;
        L26:
            unlock();
            return false;
        L28:
            r17 = r17.getNext();     // Catch: Throwable -> L17
            goto L5
        L30:
            unlock();
            return false;
        L17:
            th = move-exception;
            unlock();
            throw th;
        }

        public void runCleanup() {
            runLockedCleanup();
        }

        public void runLockedCleanup() {
            if (tryLock() == true) goto L10;
            return;
        L10:
            maybeDrainReferenceQueues();     // Catch: Throwable -> L6
            this.readCount.set(0);     // Catch: Throwable -> L6
            unlock();
            return;
        L6:
            th = move-exception;
            unlock();
            throw th;
        }

        public abstract S self();

        public void setTableEntryForTesting(int r10, InternalEntry<K, V, ?> r11) {
            this.table.set(r10, (E) castForTesting(r11));
        }

        public void setValue(E r10, V r11) {
            this.map.entryHelper.setValue(self(), r10, r11);
        }

        public void setValueForTesting(InternalEntry<K, V, ?> r10, V r11) {
            this.map.entryHelper.setValue(self(), castForTesting(r10), r11);
        }

        public void setWeakValueReferenceForTesting(InternalEntry<K, V, ?> r10, WeakValueReference<K, V, ? extends InternalEntry<K, V, ?>> r11) {
            throw new AssertionError();
        }

        public void tryDrainReferenceQueues() {
            if (tryLock() == true) goto L10;
            return;
        L10:
            maybeDrainReferenceQueues();     // Catch: Throwable -> L6
            unlock();
            return;
        L6:
            th = move-exception;
            unlock();
            throw th;
        }

        public boolean remove(Object r10, int r11, Object r12) {
            lock();
            preWriteCleanup();     // Catch: Throwable -> L19
            AtomicReferenceArray<E> r13 = this.table;     // Catch: Throwable -> L19
            int r14 = (r13.length() - 1) & r11;     // Catch: Throwable -> L19
            E r15 = r13.get(r14);     // Catch: Throwable -> L19
            InternalEntry r16 = r15;
        L4:
            boolean r17 = false;
            if (r16 == null) goto L25;
            Object r18 = r16.getKey();     // Catch: Throwable -> L19
            if (r16.getHash() != r11) goto L23;
            if (r18 == null) goto L23;
            if (this.map.keyEquivalence.equivalent(r10, r18) == false) goto L23;
            if (this.map.valueEquivalence().equivalent(r12, r16.getValue()) == false) goto L15;
            r17 = true;
        L16:
            this.modCount++;     // Catch: Throwable -> L19
            InternalEntry r19 = removeFromChain(r15, r16);     // Catch: Throwable -> L19
            int r110 = this.count - 1;     // Catch: Throwable -> L19
            r13.set(r14, (E) r19);     // Catch: Throwable -> L19
            this.count = r110;     // Catch: Throwable -> L19
            unlock();
            return r17;
        L15:
            if (isCollected(r16) == true) goto L16;
            unlock();
            return false;
        L23:
            r16 = r16.getNext();     // Catch: Throwable -> L19
            goto L4
        L25:
            unlock();
            return false;
        L19:
            th = move-exception;
            unlock();
            throw th;
        }

        public V replace(K r10, int r11, V r12) {
            lock();
            preWriteCleanup();     // Catch: Throwable -> L17
            AtomicReferenceArray<E> r13 = this.table;     // Catch: Throwable -> L17
            int r14 = (r13.length() - 1) & r11;     // Catch: Throwable -> L17
            E r15 = r13.get(r14);     // Catch: Throwable -> L17
            InternalEntry r16 = r15;
        L5:
            if (r16 == null) goto L26;
            Object r17 = r16.getKey();     // Catch: Throwable -> L17
            if (r16.getHash() != r11) goto L24;
            if (r17 == null) goto L24;
            if (this.map.keyEquivalence.equivalent(r10, r17) == false) goto L24;
            V r18 = (V) r16.getValue();
            if (r18 == null) goto L14;
            this.modCount++;     // Catch: Throwable -> L17
            setValue(r16, r12);     // Catch: Throwable -> L17
            unlock();
            return r18;
        L14:
            if (isCollected(r16) == false) goto L19;
            this.modCount++;     // Catch: Throwable -> L17
            InternalEntry r19 = removeFromChain(r15, r16);     // Catch: Throwable -> L17
            int r20 = this.count - 1;     // Catch: Throwable -> L17
            r13.set(r14, (E) r19);     // Catch: Throwable -> L17
            this.count = r20;     // Catch: Throwable -> L17
        L19:
            unlock();
            return null;
        L24:
            r16 = r16.getNext();     // Catch: Throwable -> L17
            goto L5
        L26:
            unlock();
            return null;
        L17:
            th = move-exception;
            unlock();
            throw th;
        }
    }

    public static final class SerializationProxy<K, V> extends AbstractSerializationProxy<K, V> {
        private static final long serialVersionUID = 3;

        public SerializationProxy(Strength r10, Strength r11, Equivalence<Object> r12, Equivalence<Object> r13, int r14, ConcurrentMap<K, V> r15) {
            super(r10, r11, r12, r13, r14, r15);
        }

        private void readObject(ObjectInputStream r10) throws IOException, ClassNotFoundException {
            r10.defaultReadObject();
            this.delegate = readMapMaker(r10).makeMap();
            readEntries(r10);
        }

        private Object readResolve() {
            return this.delegate;
        }

        private void writeObject(ObjectOutputStream r10) throws IOException {
            r10.defaultWriteObject();
            writeMapTo(r10);
        }
    }

    public static abstract enum Strength extends Enum<Strength> {
        private static final /* synthetic */ Strength[] $VALUES = null;
        public static final Strength STRONG = null;
        public static final Strength WEAK = null;

        static {
            final String r10 = "STRONG";
            final int r11 = 0;
            Strength r12 = new AnonymousClass1(r10, r11);
            STRONG = r12;
            final String r13 = "WEAK";
            final int r14 = 1;
            Strength r15 = new AnonymousClass2(r13, r14);
            WEAK = r15;
            $VALUES = new Strength[]{r12, r15};
        }

        private Strength(String r10, int r11) {
            super(r10, r11);
        }

        public static Strength valueOf(String r10) {
            return (Strength) Enum.valueOf(Strength.class, r10);
        }

        public static Strength[] values() {
            return (Strength[]) $VALUES.clone();
        }

        public abstract Equivalence<Object> defaultEquivalence();

        public /* synthetic */ Strength(String r10, int r11, AnonymousClass1 r12) {
            this(r10, r11);
        }
    }

    public static final class StrongKeyDummyValueEntry<K> extends AbstractStrongKeyEntry<K, MapMaker.Dummy, StrongKeyDummyValueEntry<K>> implements StrongValueEntry<K, MapMaker.Dummy, StrongKeyDummyValueEntry<K>> {

        public static final class Helper<K> implements InternalEntryHelper<K, MapMaker.Dummy, StrongKeyDummyValueEntry<K>, StrongKeyDummyValueSegment<K>> {
            private static final Helper<?> INSTANCE = null;

            static {
                INSTANCE = new Helper();
            }

            public Helper() {
            }

            public static <K> Helper<K> instance() {
                return (Helper<K>) INSTANCE;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ InternalEntry copy(Segment r10, InternalEntry r11, @NullableDecl InternalEntry r12) {
                return copy((StrongKeyDummyValueSegment) r10, (StrongKeyDummyValueEntry) r11, (StrongKeyDummyValueEntry) r12);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength keyStrength() {
                return Strength.STRONG;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ InternalEntry newEntry(Segment r10, Object r11, int r12, @NullableDecl InternalEntry r13) {
                return newEntry((StrongKeyDummyValueSegment) r10, r11, r12, (StrongKeyDummyValueEntry) r13);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ Segment newSegment(MapMakerInternalMap r10, int r11, int r12) {
                return newSegment(r10, r11, r12);
            }

            public void setValue(StrongKeyDummyValueSegment<K> r10, StrongKeyDummyValueEntry<K> r11, MapMaker.Dummy r12) {
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength valueStrength() {
                return Strength.STRONG;
            }

            public StrongKeyDummyValueEntry<K> copy(StrongKeyDummyValueSegment<K> r10, StrongKeyDummyValueEntry<K> r11, @NullableDecl StrongKeyDummyValueEntry<K> r12) {
                return r11.copy(r12);
            }

            public StrongKeyDummyValueEntry<K> newEntry(StrongKeyDummyValueSegment<K> r10, K r11, int r12, @NullableDecl StrongKeyDummyValueEntry<K> r13) {
                return new StrongKeyDummyValueEntry(r11, r12, r13);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public StrongKeyDummyValueSegment<K> newSegment(MapMakerInternalMap<K, MapMaker.Dummy, StrongKeyDummyValueEntry<K>, StrongKeyDummyValueSegment<K>> r10, int r11, int r12) {
                return new StrongKeyDummyValueSegment(r10, r11, r12);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ void setValue(Segment r10, InternalEntry r11, MapMaker.Dummy r12) {
                setValue((StrongKeyDummyValueSegment) r10, (StrongKeyDummyValueEntry) r11, r12);
            }
        }

        public StrongKeyDummyValueEntry(K r10, int r11, @NullableDecl StrongKeyDummyValueEntry<K> r12) {
            super(r10, r11, r12);
        }

        public StrongKeyDummyValueEntry<K> copy(StrongKeyDummyValueEntry<K> r10) {
            return new StrongKeyDummyValueEntry(this.key, this.hash, r10);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public /* bridge */ /* synthetic */ Object getValue() {
            return getValue();
        }

        public void setValue(MapMaker.Dummy r10) {
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public MapMaker.Dummy getValue() {
            return MapMaker.Dummy.VALUE;
        }
    }

    public static final class StrongKeyDummyValueSegment<K> extends Segment<K, MapMaker.Dummy, StrongKeyDummyValueEntry<K>, StrongKeyDummyValueSegment<K>> {
        public StrongKeyDummyValueSegment(MapMakerInternalMap<K, MapMaker.Dummy, StrongKeyDummyValueEntry<K>, StrongKeyDummyValueSegment<K>> r10, int r11, int r12) {
            super(r10, r11, r12);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public /* bridge */ /* synthetic */ InternalEntry castForTesting(InternalEntry r10) {
            return castForTesting(r10);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyDummyValueSegment<K> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyDummyValueEntry<K> castForTesting(InternalEntry<K, MapMaker.Dummy, ?> r10) {
            return (StrongKeyDummyValueEntry) r10;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public /* bridge */ /* synthetic */ Segment self() {
            return self();
        }
    }

    public static final class StrongKeyStrongValueEntry<K, V> extends AbstractStrongKeyEntry<K, V, StrongKeyStrongValueEntry<K, V>> implements StrongValueEntry<K, V, StrongKeyStrongValueEntry<K, V>> {

        @NullableDecl
        private volatile V value;

        public static final class Helper<K, V> implements InternalEntryHelper<K, V, StrongKeyStrongValueEntry<K, V>, StrongKeyStrongValueSegment<K, V>> {
            private static final Helper<?, ?> INSTANCE = null;

            static {
                INSTANCE = new Helper();
            }

            public Helper() {
            }

            public static <K, V> Helper<K, V> instance() {
                return (Helper<K, V>) INSTANCE;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ InternalEntry copy(Segment r10, InternalEntry r11, @NullableDecl InternalEntry r12) {
                return copy((StrongKeyStrongValueSegment) r10, (StrongKeyStrongValueEntry) r11, (StrongKeyStrongValueEntry) r12);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength keyStrength() {
                return Strength.STRONG;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ InternalEntry newEntry(Segment r10, Object r11, int r12, @NullableDecl InternalEntry r13) {
                return newEntry((StrongKeyStrongValueSegment) r10, r11, r12, (StrongKeyStrongValueEntry) r13);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ Segment newSegment(MapMakerInternalMap r10, int r11, int r12) {
                return newSegment(r10, r11, r12);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ void setValue(Segment r10, InternalEntry r11, Object r12) {
                setValue((StrongKeyStrongValueSegment) r10, (StrongKeyStrongValueEntry) r11, r12);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength valueStrength() {
                return Strength.STRONG;
            }

            public StrongKeyStrongValueEntry<K, V> copy(StrongKeyStrongValueSegment<K, V> r10, StrongKeyStrongValueEntry<K, V> r11, @NullableDecl StrongKeyStrongValueEntry<K, V> r12) {
                return r11.copy(r12);
            }

            public StrongKeyStrongValueEntry<K, V> newEntry(StrongKeyStrongValueSegment<K, V> r10, K r11, int r12, @NullableDecl StrongKeyStrongValueEntry<K, V> r13) {
                return new StrongKeyStrongValueEntry(r11, r12, r13);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public StrongKeyStrongValueSegment<K, V> newSegment(MapMakerInternalMap<K, V, StrongKeyStrongValueEntry<K, V>, StrongKeyStrongValueSegment<K, V>> r10, int r11, int r12) {
                return new StrongKeyStrongValueSegment(r10, r11, r12);
            }

            public void setValue(StrongKeyStrongValueSegment<K, V> r10, StrongKeyStrongValueEntry<K, V> r11, V r12) {
                r11.setValue(r12);
            }
        }

        public StrongKeyStrongValueEntry(K r10, int r11, @NullableDecl StrongKeyStrongValueEntry<K, V> r12) {
            super(r10, r11, r12);
            this.value = null;
        }

        public StrongKeyStrongValueEntry<K, V> copy(StrongKeyStrongValueEntry<K, V> r10) {
            StrongKeyStrongValueEntry<K, V> r11 = new StrongKeyStrongValueEntry(this.key, this.hash, r10);
            r11.value = this.value;
            return r11;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        @NullableDecl
        public V getValue() {
            return this.value;
        }

        public void setValue(V r10) {
            this.value = r10;
        }
    }

    public static final class StrongKeyStrongValueSegment<K, V> extends Segment<K, V, StrongKeyStrongValueEntry<K, V>, StrongKeyStrongValueSegment<K, V>> {
        public StrongKeyStrongValueSegment(MapMakerInternalMap<K, V, StrongKeyStrongValueEntry<K, V>, StrongKeyStrongValueSegment<K, V>> r10, int r11, int r12) {
            super(r10, r11, r12);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public /* bridge */ /* synthetic */ InternalEntry castForTesting(InternalEntry r10) {
            return castForTesting(r10);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyStrongValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyStrongValueEntry<K, V> castForTesting(InternalEntry<K, V, ?> r10) {
            return (StrongKeyStrongValueEntry) r10;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public /* bridge */ /* synthetic */ Segment self() {
            return self();
        }
    }

    public static final class StrongKeyWeakValueEntry<K, V> extends AbstractStrongKeyEntry<K, V, StrongKeyWeakValueEntry<K, V>> implements WeakValueEntry<K, V, StrongKeyWeakValueEntry<K, V>> {
        private volatile WeakValueReference<K, V, StrongKeyWeakValueEntry<K, V>> valueReference;

        public static final class Helper<K, V> implements InternalEntryHelper<K, V, StrongKeyWeakValueEntry<K, V>, StrongKeyWeakValueSegment<K, V>> {
            private static final Helper<?, ?> INSTANCE = null;

            static {
                INSTANCE = new Helper();
            }

            public Helper() {
            }

            public static <K, V> Helper<K, V> instance() {
                return (Helper<K, V>) INSTANCE;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ InternalEntry copy(Segment r10, InternalEntry r11, @NullableDecl InternalEntry r12) {
                return copy((StrongKeyWeakValueSegment) r10, (StrongKeyWeakValueEntry) r11, (StrongKeyWeakValueEntry) r12);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength keyStrength() {
                return Strength.STRONG;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ InternalEntry newEntry(Segment r10, Object r11, int r12, @NullableDecl InternalEntry r13) {
                return newEntry((StrongKeyWeakValueSegment) r10, r11, r12, (StrongKeyWeakValueEntry) r13);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ Segment newSegment(MapMakerInternalMap r10, int r11, int r12) {
                return newSegment(r10, r11, r12);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ void setValue(Segment r10, InternalEntry r11, Object r12) {
                setValue((StrongKeyWeakValueSegment) r10, (StrongKeyWeakValueEntry) r11, r12);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength valueStrength() {
                return Strength.WEAK;
            }

            public StrongKeyWeakValueEntry<K, V> copy(StrongKeyWeakValueSegment<K, V> r10, StrongKeyWeakValueEntry<K, V> r11, @NullableDecl StrongKeyWeakValueEntry<K, V> r12) {
                if (Segment.isCollected(r11) == false) goto L7;
                return null;
            L7:
                return r11.copy(StrongKeyWeakValueSegment.access$100(r10), r12);
            }

            public StrongKeyWeakValueEntry<K, V> newEntry(StrongKeyWeakValueSegment<K, V> r10, K r11, int r12, @NullableDecl StrongKeyWeakValueEntry<K, V> r13) {
                return new StrongKeyWeakValueEntry(r11, r12, r13);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public StrongKeyWeakValueSegment<K, V> newSegment(MapMakerInternalMap<K, V, StrongKeyWeakValueEntry<K, V>, StrongKeyWeakValueSegment<K, V>> r10, int r11, int r12) {
                return new StrongKeyWeakValueSegment(r10, r11, r12);
            }

            public void setValue(StrongKeyWeakValueSegment<K, V> r10, StrongKeyWeakValueEntry<K, V> r11, V r12) {
                r11.setValue(r12, StrongKeyWeakValueSegment.access$100(r10));
            }
        }

        public StrongKeyWeakValueEntry(K r10, int r11, @NullableDecl StrongKeyWeakValueEntry<K, V> r12) {
            super(r10, r11, r12);
            this.valueReference = MapMakerInternalMap.unsetWeakValueReference();
        }

        public static /* synthetic */ WeakValueReference access$600(StrongKeyWeakValueEntry r10) {
            return r10.valueReference;
        }

        public static /* synthetic */ WeakValueReference access$602(StrongKeyWeakValueEntry r10, WeakValueReference r11) {
            r10.valueReference = r11;
            return r11;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueEntry
        public void clearValue() {
            this.valueReference.clear();
        }

        public StrongKeyWeakValueEntry<K, V> copy(ReferenceQueue<V> r10, StrongKeyWeakValueEntry<K, V> r11) {
            StrongKeyWeakValueEntry<K, V> r12 = new StrongKeyWeakValueEntry(this.key, this.hash, r11);
            r12.valueReference = this.valueReference.copyFor(r10, r12);
            return r12;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public V getValue() {
            return this.valueReference.get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueEntry
        public WeakValueReference<K, V, StrongKeyWeakValueEntry<K, V>> getValueReference() {
            return this.valueReference;
        }

        public void setValue(V r10, ReferenceQueue<V> r11) {
            WeakValueReference<K, V, StrongKeyWeakValueEntry<K, V>> r12 = this.valueReference;
            this.valueReference = new WeakValueReferenceImpl(r11, r10, this);
            r12.clear();
        }
    }

    public static final class StrongKeyWeakValueSegment<K, V> extends Segment<K, V, StrongKeyWeakValueEntry<K, V>, StrongKeyWeakValueSegment<K, V>> {
        private final ReferenceQueue<V> queueForValues;

        public StrongKeyWeakValueSegment(MapMakerInternalMap<K, V, StrongKeyWeakValueEntry<K, V>, StrongKeyWeakValueSegment<K, V>> r10, int r11, int r12) {
            super(r10, r11, r12);
            this.queueForValues = new ReferenceQueue();
        }

        public static /* synthetic */ ReferenceQueue access$100(StrongKeyWeakValueSegment r10) {
            return r10.queueForValues;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public /* bridge */ /* synthetic */ InternalEntry castForTesting(InternalEntry r10) {
            return castForTesting(r10);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<V> getValueReferenceQueueForTesting() {
            return this.queueForValues;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakValueReference<K, V, StrongKeyWeakValueEntry<K, V>> getWeakValueReferenceForTesting(InternalEntry<K, V, ?> r10) {
            return castForTesting(r10).getValueReference();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainValueReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakValueReference<K, V, StrongKeyWeakValueEntry<K, V>> newWeakValueReferenceForTesting(InternalEntry<K, V, ?> r10, V r11) {
            return new WeakValueReferenceImpl(this.queueForValues, r11, castForTesting(r10));
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyWeakValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void setWeakValueReferenceForTesting(InternalEntry<K, V, ?> r10, WeakValueReference<K, V, ? extends InternalEntry<K, V, ?>> r11) {
            StrongKeyWeakValueEntry<K, V> r12 = castForTesting(r10);
            WeakValueReference r13 = StrongKeyWeakValueEntry.access$600(r12);
            StrongKeyWeakValueEntry.access$602(r12, r11);
            r13.clear();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyWeakValueEntry<K, V> castForTesting(InternalEntry<K, V, ?> r10) {
            return (StrongKeyWeakValueEntry) r10;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public /* bridge */ /* synthetic */ Segment self() {
            return self();
        }
    }

    public interface StrongValueEntry<K, V, E extends InternalEntry<K, V, E>> extends InternalEntry<K, V, E> {
    }

    public final class ValueIterator extends MapMakerInternalMap<K, V, E, S>.HashIterator<V> {
        final /* synthetic */ MapMakerInternalMap this$0;

        public ValueIterator(MapMakerInternalMap r10) {
            this.this$0 = r10;
            super(r10);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.HashIterator, java.util.Iterator
        public V next() {
            return nextEntry().getValue();
        }
    }

    public final class Values extends AbstractCollection<V> {
        final /* synthetic */ MapMakerInternalMap this$0;

        public Values(MapMakerInternalMap r10) {
            this.this$0 = r10;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.this$0.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object r10) {
            return this.this$0.containsValue(r10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.this$0.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new ValueIterator(this.this$0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.this$0.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return MapMakerInternalMap.access$900(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] r10) {
            return (T[]) MapMakerInternalMap.access$900(this).toArray(r10);
        }
    }

    public static final class WeakKeyDummyValueEntry<K> extends AbstractWeakKeyEntry<K, MapMaker.Dummy, WeakKeyDummyValueEntry<K>> implements StrongValueEntry<K, MapMaker.Dummy, WeakKeyDummyValueEntry<K>> {

        public static final class Helper<K> implements InternalEntryHelper<K, MapMaker.Dummy, WeakKeyDummyValueEntry<K>, WeakKeyDummyValueSegment<K>> {
            private static final Helper<?> INSTANCE = null;

            static {
                INSTANCE = new Helper();
            }

            public Helper() {
            }

            public static <K> Helper<K> instance() {
                return (Helper<K>) INSTANCE;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ InternalEntry copy(Segment r10, InternalEntry r11, @NullableDecl InternalEntry r12) {
                return copy((WeakKeyDummyValueSegment) r10, (WeakKeyDummyValueEntry) r11, (WeakKeyDummyValueEntry) r12);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength keyStrength() {
                return Strength.WEAK;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ InternalEntry newEntry(Segment r10, Object r11, int r12, @NullableDecl InternalEntry r13) {
                return newEntry((WeakKeyDummyValueSegment) r10, r11, r12, (WeakKeyDummyValueEntry) r13);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ Segment newSegment(MapMakerInternalMap r10, int r11, int r12) {
                return newSegment(r10, r11, r12);
            }

            public void setValue(WeakKeyDummyValueSegment<K> r10, WeakKeyDummyValueEntry<K> r11, MapMaker.Dummy r12) {
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength valueStrength() {
                return Strength.STRONG;
            }

            public WeakKeyDummyValueEntry<K> copy(WeakKeyDummyValueSegment<K> r10, WeakKeyDummyValueEntry<K> r11, @NullableDecl WeakKeyDummyValueEntry<K> r12) {
                if (r11.getKey() != null) goto L7;
                return null;
            L7:
                return r11.copy(WeakKeyDummyValueSegment.access$200(r10), r12);
            }

            public WeakKeyDummyValueEntry<K> newEntry(WeakKeyDummyValueSegment<K> r10, K r11, int r12, @NullableDecl WeakKeyDummyValueEntry<K> r13) {
                return new WeakKeyDummyValueEntry(WeakKeyDummyValueSegment.access$200(r10), r11, r12, r13);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public WeakKeyDummyValueSegment<K> newSegment(MapMakerInternalMap<K, MapMaker.Dummy, WeakKeyDummyValueEntry<K>, WeakKeyDummyValueSegment<K>> r10, int r11, int r12) {
                return new WeakKeyDummyValueSegment(r10, r11, r12);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ void setValue(Segment r10, InternalEntry r11, MapMaker.Dummy r12) {
                setValue((WeakKeyDummyValueSegment) r10, (WeakKeyDummyValueEntry) r11, r12);
            }
        }

        public WeakKeyDummyValueEntry(ReferenceQueue<K> r10, K r11, int r12, @NullableDecl WeakKeyDummyValueEntry<K> r13) {
            super(r10, r11, r12, r13);
        }

        public WeakKeyDummyValueEntry<K> copy(ReferenceQueue<K> r10, WeakKeyDummyValueEntry<K> r11) {
            return new WeakKeyDummyValueEntry(r10, getKey(), this.hash, r11);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public /* bridge */ /* synthetic */ Object getValue() {
            return getValue();
        }

        public void setValue(MapMaker.Dummy r10) {
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public MapMaker.Dummy getValue() {
            return MapMaker.Dummy.VALUE;
        }
    }

    public static final class WeakKeyDummyValueSegment<K> extends Segment<K, MapMaker.Dummy, WeakKeyDummyValueEntry<K>, WeakKeyDummyValueSegment<K>> {
        private final ReferenceQueue<K> queueForKeys;

        public WeakKeyDummyValueSegment(MapMakerInternalMap<K, MapMaker.Dummy, WeakKeyDummyValueEntry<K>, WeakKeyDummyValueSegment<K>> r10, int r11, int r12) {
            super(r10, r11, r12);
            this.queueForKeys = new ReferenceQueue();
        }

        public static /* synthetic */ ReferenceQueue access$200(WeakKeyDummyValueSegment r10) {
            return r10.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public /* bridge */ /* synthetic */ InternalEntry castForTesting(InternalEntry r10) {
            return castForTesting(r10);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyDummyValueSegment<K> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyDummyValueEntry<K> castForTesting(InternalEntry<K, MapMaker.Dummy, ?> r10) {
            return (WeakKeyDummyValueEntry) r10;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public /* bridge */ /* synthetic */ Segment self() {
            return self();
        }
    }

    public static final class WeakKeyStrongValueEntry<K, V> extends AbstractWeakKeyEntry<K, V, WeakKeyStrongValueEntry<K, V>> implements StrongValueEntry<K, V, WeakKeyStrongValueEntry<K, V>> {

        @NullableDecl
        private volatile V value;

        public static final class Helper<K, V> implements InternalEntryHelper<K, V, WeakKeyStrongValueEntry<K, V>, WeakKeyStrongValueSegment<K, V>> {
            private static final Helper<?, ?> INSTANCE = null;

            static {
                INSTANCE = new Helper();
            }

            public Helper() {
            }

            public static <K, V> Helper<K, V> instance() {
                return (Helper<K, V>) INSTANCE;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ InternalEntry copy(Segment r10, InternalEntry r11, @NullableDecl InternalEntry r12) {
                return copy((WeakKeyStrongValueSegment) r10, (WeakKeyStrongValueEntry) r11, (WeakKeyStrongValueEntry) r12);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength keyStrength() {
                return Strength.WEAK;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ InternalEntry newEntry(Segment r10, Object r11, int r12, @NullableDecl InternalEntry r13) {
                return newEntry((WeakKeyStrongValueSegment) r10, r11, r12, (WeakKeyStrongValueEntry) r13);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ Segment newSegment(MapMakerInternalMap r10, int r11, int r12) {
                return newSegment(r10, r11, r12);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ void setValue(Segment r10, InternalEntry r11, Object r12) {
                setValue((WeakKeyStrongValueSegment) r10, (WeakKeyStrongValueEntry) r11, r12);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength valueStrength() {
                return Strength.STRONG;
            }

            public WeakKeyStrongValueEntry<K, V> copy(WeakKeyStrongValueSegment<K, V> r10, WeakKeyStrongValueEntry<K, V> r11, @NullableDecl WeakKeyStrongValueEntry<K, V> r12) {
                if (r11.getKey() != null) goto L7;
                return null;
            L7:
                return r11.copy(WeakKeyStrongValueSegment.access$300(r10), r12);
            }

            public WeakKeyStrongValueEntry<K, V> newEntry(WeakKeyStrongValueSegment<K, V> r10, K r11, int r12, @NullableDecl WeakKeyStrongValueEntry<K, V> r13) {
                return new WeakKeyStrongValueEntry(WeakKeyStrongValueSegment.access$300(r10), r11, r12, r13);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public WeakKeyStrongValueSegment<K, V> newSegment(MapMakerInternalMap<K, V, WeakKeyStrongValueEntry<K, V>, WeakKeyStrongValueSegment<K, V>> r10, int r11, int r12) {
                return new WeakKeyStrongValueSegment(r10, r11, r12);
            }

            public void setValue(WeakKeyStrongValueSegment<K, V> r10, WeakKeyStrongValueEntry<K, V> r11, V r12) {
                r11.setValue(r12);
            }
        }

        public WeakKeyStrongValueEntry(ReferenceQueue<K> r10, K r11, int r12, @NullableDecl WeakKeyStrongValueEntry<K, V> r13) {
            super(r10, r11, r12, r13);
            this.value = null;
        }

        public WeakKeyStrongValueEntry<K, V> copy(ReferenceQueue<K> r10, WeakKeyStrongValueEntry<K, V> r11) {
            WeakKeyStrongValueEntry<K, V> r12 = new WeakKeyStrongValueEntry(r10, getKey(), this.hash, r11);
            r12.setValue(this.value);
            return r12;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        @NullableDecl
        public V getValue() {
            return this.value;
        }

        public void setValue(V r10) {
            this.value = r10;
        }
    }

    public static final class WeakKeyStrongValueSegment<K, V> extends Segment<K, V, WeakKeyStrongValueEntry<K, V>, WeakKeyStrongValueSegment<K, V>> {
        private final ReferenceQueue<K> queueForKeys;

        public WeakKeyStrongValueSegment(MapMakerInternalMap<K, V, WeakKeyStrongValueEntry<K, V>, WeakKeyStrongValueSegment<K, V>> r10, int r11, int r12) {
            super(r10, r11, r12);
            this.queueForKeys = new ReferenceQueue();
        }

        public static /* synthetic */ ReferenceQueue access$300(WeakKeyStrongValueSegment r10) {
            return r10.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public /* bridge */ /* synthetic */ InternalEntry castForTesting(InternalEntry r10) {
            return castForTesting(r10);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyStrongValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyStrongValueEntry<K, V> castForTesting(InternalEntry<K, V, ?> r10) {
            return (WeakKeyStrongValueEntry) r10;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public /* bridge */ /* synthetic */ Segment self() {
            return self();
        }
    }

    public static final class WeakKeyWeakValueEntry<K, V> extends AbstractWeakKeyEntry<K, V, WeakKeyWeakValueEntry<K, V>> implements WeakValueEntry<K, V, WeakKeyWeakValueEntry<K, V>> {
        private volatile WeakValueReference<K, V, WeakKeyWeakValueEntry<K, V>> valueReference;

        public static final class Helper<K, V> implements InternalEntryHelper<K, V, WeakKeyWeakValueEntry<K, V>, WeakKeyWeakValueSegment<K, V>> {
            private static final Helper<?, ?> INSTANCE = null;

            static {
                INSTANCE = new Helper();
            }

            public Helper() {
            }

            public static <K, V> Helper<K, V> instance() {
                return (Helper<K, V>) INSTANCE;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ InternalEntry copy(Segment r10, InternalEntry r11, @NullableDecl InternalEntry r12) {
                return copy((WeakKeyWeakValueSegment) r10, (WeakKeyWeakValueEntry) r11, (WeakKeyWeakValueEntry) r12);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength keyStrength() {
                return Strength.WEAK;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ InternalEntry newEntry(Segment r10, Object r11, int r12, @NullableDecl InternalEntry r13) {
                return newEntry((WeakKeyWeakValueSegment) r10, r11, r12, (WeakKeyWeakValueEntry) r13);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ Segment newSegment(MapMakerInternalMap r10, int r11, int r12) {
                return newSegment(r10, r11, r12);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ void setValue(Segment r10, InternalEntry r11, Object r12) {
                setValue((WeakKeyWeakValueSegment) r10, (WeakKeyWeakValueEntry) r11, r12);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength valueStrength() {
                return Strength.WEAK;
            }

            public WeakKeyWeakValueEntry<K, V> copy(WeakKeyWeakValueSegment<K, V> r10, WeakKeyWeakValueEntry<K, V> r11, @NullableDecl WeakKeyWeakValueEntry<K, V> r12) {
                if (r11.getKey() != null) goto L6;
                return null;
            L6:
                if (Segment.isCollected(r11) == false) goto L9;
                return null;
            L9:
                return r11.copy(WeakKeyWeakValueSegment.access$400(r10), WeakKeyWeakValueSegment.access$500(r10), r12);
            }

            public WeakKeyWeakValueEntry<K, V> newEntry(WeakKeyWeakValueSegment<K, V> r10, K r11, int r12, @NullableDecl WeakKeyWeakValueEntry<K, V> r13) {
                return new WeakKeyWeakValueEntry(WeakKeyWeakValueSegment.access$400(r10), r11, r12, r13);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public WeakKeyWeakValueSegment<K, V> newSegment(MapMakerInternalMap<K, V, WeakKeyWeakValueEntry<K, V>, WeakKeyWeakValueSegment<K, V>> r10, int r11, int r12) {
                return new WeakKeyWeakValueSegment(r10, r11, r12);
            }

            public void setValue(WeakKeyWeakValueSegment<K, V> r10, WeakKeyWeakValueEntry<K, V> r11, V r12) {
                r11.setValue(r12, WeakKeyWeakValueSegment.access$500(r10));
            }
        }

        public WeakKeyWeakValueEntry(ReferenceQueue<K> r10, K r11, int r12, @NullableDecl WeakKeyWeakValueEntry<K, V> r13) {
            super(r10, r11, r12, r13);
            this.valueReference = MapMakerInternalMap.unsetWeakValueReference();
        }

        public static /* synthetic */ WeakValueReference access$700(WeakKeyWeakValueEntry r10) {
            return r10.valueReference;
        }

        public static /* synthetic */ WeakValueReference access$702(WeakKeyWeakValueEntry r10, WeakValueReference r11) {
            r10.valueReference = r11;
            return r11;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueEntry
        public void clearValue() {
            this.valueReference.clear();
        }

        public WeakKeyWeakValueEntry<K, V> copy(ReferenceQueue<K> r10, ReferenceQueue<V> r11, WeakKeyWeakValueEntry<K, V> r12) {
            WeakKeyWeakValueEntry<K, V> r13 = new WeakKeyWeakValueEntry(r10, getKey(), this.hash, r12);
            r13.valueReference = this.valueReference.copyFor(r11, r13);
            return r13;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public V getValue() {
            return this.valueReference.get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueEntry
        public WeakValueReference<K, V, WeakKeyWeakValueEntry<K, V>> getValueReference() {
            return this.valueReference;
        }

        public void setValue(V r10, ReferenceQueue<V> r11) {
            WeakValueReference<K, V, WeakKeyWeakValueEntry<K, V>> r12 = this.valueReference;
            this.valueReference = new WeakValueReferenceImpl(r11, r10, this);
            r12.clear();
        }
    }

    public static final class WeakKeyWeakValueSegment<K, V> extends Segment<K, V, WeakKeyWeakValueEntry<K, V>, WeakKeyWeakValueSegment<K, V>> {
        private final ReferenceQueue<K> queueForKeys;
        private final ReferenceQueue<V> queueForValues;

        public WeakKeyWeakValueSegment(MapMakerInternalMap<K, V, WeakKeyWeakValueEntry<K, V>, WeakKeyWeakValueSegment<K, V>> r10, int r11, int r12) {
            super(r10, r11, r12);
            this.queueForKeys = new ReferenceQueue();
            this.queueForValues = new ReferenceQueue();
        }

        public static /* synthetic */ ReferenceQueue access$400(WeakKeyWeakValueSegment r10) {
            return r10.queueForKeys;
        }

        public static /* synthetic */ ReferenceQueue access$500(WeakKeyWeakValueSegment r10) {
            return r10.queueForValues;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public /* bridge */ /* synthetic */ InternalEntry castForTesting(InternalEntry r10) {
            return castForTesting(r10);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<V> getValueReferenceQueueForTesting() {
            return this.queueForValues;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakValueReference<K, V, WeakKeyWeakValueEntry<K, V>> getWeakValueReferenceForTesting(InternalEntry<K, V, ?> r10) {
            return castForTesting(r10).getValueReference();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
            drainValueReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakValueReference<K, V, WeakKeyWeakValueEntry<K, V>> newWeakValueReferenceForTesting(InternalEntry<K, V, ?> r10, V r11) {
            return new WeakValueReferenceImpl(this.queueForValues, r11, castForTesting(r10));
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyWeakValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void setWeakValueReferenceForTesting(InternalEntry<K, V, ?> r10, WeakValueReference<K, V, ? extends InternalEntry<K, V, ?>> r11) {
            WeakKeyWeakValueEntry<K, V> r12 = castForTesting(r10);
            WeakValueReference r13 = WeakKeyWeakValueEntry.access$700(r12);
            WeakKeyWeakValueEntry.access$702(r12, r11);
            r13.clear();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyWeakValueEntry<K, V> castForTesting(InternalEntry<K, V, ?> r10) {
            return (WeakKeyWeakValueEntry) r10;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public /* bridge */ /* synthetic */ Segment self() {
            return self();
        }
    }

    public interface WeakValueEntry<K, V, E extends InternalEntry<K, V, E>> extends InternalEntry<K, V, E> {
        void clearValue();

        WeakValueReference<K, V, E> getValueReference();
    }

    public interface WeakValueReference<K, V, E extends InternalEntry<K, V, E>> {
        void clear();

        WeakValueReference<K, V, E> copyFor(ReferenceQueue<V> r10, E r11);

        @NullableDecl
        V get();

        E getEntry();
    }

    public static final class WeakValueReferenceImpl<K, V, E extends InternalEntry<K, V, E>> extends WeakReference<V> implements WeakValueReference<K, V, E> {

        @Weak
        final E entry;

        public WeakValueReferenceImpl(ReferenceQueue<V> r10, V r11, E r12) {
            super(r11, r10);
            this.entry = r12;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        public WeakValueReference<K, V, E> copyFor(ReferenceQueue<V> r10, E r11) {
            return new WeakValueReferenceImpl(r10, get(), r11);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        public E getEntry() {
            return this.entry;
        }
    }

    public final class WriteThroughEntry extends AbstractMapEntry<K, V> {
        final K key;
        final /* synthetic */ MapMakerInternalMap this$0;
        V value;

        public WriteThroughEntry(MapMakerInternalMap r10, K r11, V r12) {
            this.this$0 = r10;
            this.key = r11;
            this.value = r12;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public boolean equals(@NullableDecl Object r10) {
            if ((r10 instanceof Map.Entry) == false) goto L10;
            Map.Entry r11 = (Map.Entry) r10;
            if (this.key.equals(r11.getKey()) == true) goto L7;
            return false;
        L7:
            if (this.value.equals(r11.getValue()) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public int hashCode() {
            int r10 = this.key.hashCode();
            return this.value.hashCode() ^ r10;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V setValue(V r10) {
            V r11 = (V) this.this$0.put(this.key, r10);
            this.value = r10;
            return r11;
        }
    }

    static {
        UNSET_WEAK_VALUE_REFERENCE = new AnonymousClass1();
    }

    private MapMakerInternalMap(MapMaker r10, InternalEntryHelper<K, V, E, S> r11) {
        this.concurrencyLevel = Math.min(r10.getConcurrencyLevel(), 65536);
        this.keyEquivalence = r10.getKeyEquivalence();
        this.entryHelper = r11;
        int r12 = Math.min(r10.getInitialCapacity(), 1073741824);
        int r13 = 0;
        int r14 = 1;
        int r15 = 0;
        int r16 = 1;
    L4:
        if (r16 >= this.concurrencyLevel) goto L6;
        r15 = r15 + 1;
        r16 = r16 << 1;
        goto L4
    L6:
        this.segmentShift = 32 - r15;
        this.segmentMask = r16 - 1;
        this.segments = newSegmentArray(r16);
        int r17 = r12 / r16;
        if ((r16 * r17) >= r12) goto L9;
        r17 = r17 + 1;
    L9:
        if (r14 >= r17) goto L11;
        r14 = r14 << 1;
    L11:
        Segment<K, V, E, S>[] r18 = this.segments;
        if (r13 >= r18.length) goto L14;
        r18[r13] = createSegment(r14, -1);
        r13 = r13 + 1;
        goto L11
    }

    public static /* synthetic */ ArrayList access$900(Collection r10) {
        return toArrayList(r10);
    }

    public static <K, V> MapMakerInternalMap<K, V, ? extends InternalEntry<K, V, ?>, ?> create(MapMaker r10) {
        Strength r11 = r10.getKeyStrength();
        Strength r12 = Strength.STRONG;
        if (r11 != r12) goto L9;
        if (r10.getValueStrength() != r12) goto L9;
        return new MapMakerInternalMap(r10, StrongKeyStrongValueEntry.Helper.instance());
    L9:
        if (r10.getKeyStrength() == r12) goto L11;
    L14:
        Strength r13 = r10.getKeyStrength();
        Strength r14 = Strength.WEAK;
        if (r13 != r14) goto L21;
        if (r10.getValueStrength() != r12) goto L21;
        return new MapMakerInternalMap(r10, WeakKeyStrongValueEntry.Helper.instance());
    L21:
        if (r10.getKeyStrength() != r14) goto L27;
        if (r10.getValueStrength() != r14) goto L27;
        return new MapMakerInternalMap(r10, WeakKeyWeakValueEntry.Helper.instance());
    L27:
        throw new AssertionError();
    L11:
        if (r10.getValueStrength() != Strength.WEAK) goto L14;
        return new MapMakerInternalMap(r10, StrongKeyWeakValueEntry.Helper.instance());
    }

    public static <K> MapMakerInternalMap<K, MapMaker.Dummy, ? extends InternalEntry<K, MapMaker.Dummy, ?>, ?> createWithDummyValues(MapMaker r10) {
        Strength r11 = r10.getKeyStrength();
        Strength r12 = Strength.STRONG;
        if (r11 == r12) goto L5;
    L8:
        Strength r13 = r10.getKeyStrength();
        Strength r14 = Strength.WEAK;
        if (r13 != r14) goto L15;
        if (r10.getValueStrength() != r12) goto L15;
        return new MapMakerInternalMap(r10, WeakKeyDummyValueEntry.Helper.instance());
    L15:
        if (r10.getValueStrength() != r14) goto L19;
        throw new IllegalArgumentException("Map cannot have both weak and dummy values");
    L19:
        throw new AssertionError();
    L5:
        if (r10.getValueStrength() != r12) goto L8;
        return new MapMakerInternalMap(r10, StrongKeyDummyValueEntry.Helper.instance());
    }

    public static int rehash(int r10) {
        int r11 = r10 + ((r10 << 15) ^ (-12931));
        int r12 = r11 ^ (r11 >>> 10);
        int r13 = r12 + (r12 << 3);
        int r14 = r13 ^ (r13 >>> 6);
        int r15 = r14 + ((r14 << 2) + (r14 << 14));
        return r15 ^ (r15 >>> 16);
    }

    private static <E> ArrayList<E> toArrayList(Collection<E> r10) {
        ArrayList<E> r11 = new ArrayList(r10.size());
        Iterators.addAll(r11, r10.iterator());
        return r11;
    }

    public static <K, V, E extends InternalEntry<K, V, E>> WeakValueReference<K, V, E> unsetWeakValueReference() {
        return (WeakValueReference<K, V, E>) UNSET_WEAK_VALUE_REFERENCE;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Segment<K, V, E, S>[] r10 = this.segments;
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10[r12].clear();
        r12 = r12 + 1;
        goto L3
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@NullableDecl Object r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        int r11 = hash(r10);
        return segmentFor(r11).containsKey(r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [int] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [int] */
    /* JADX WARN: Type inference failed for: r13v3 */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@NullableDecl Object r17) {
        boolean r10 = false;
        if (r17 != null) goto L5;
        return false;
    L5:
        Segment<K, V, E, S>[] r11 = this.segments;
        long r12 = -1;
        int r13 = 0;
    L7:
        if (r13 >= 3) goto L29;
        int r14 = r11.length;
        long r15 = 0;
        ?? r16 = r10;
    L9:
        if (r16 >= r14) goto L25;
        Segment<K, V, E, S> r18 = r11[r16];
        int r19 = r18.count;
        AtomicReferenceArray<E> r110 = r18.table;
        ?? r111 = r10;
    L12:
        if (r111 >= r110.length()) goto L23;
        E r112 = r110.get(r111);
    L14:
        if (r112 == null) goto L22;
        V r113 = r18.getLiveValue(r112);
        if (r113 == null) goto L21;
        if (valueEquivalence().equivalent(r17, r113) == false) goto L21;
        return true;
    L21:
        r112 = r112.getNext();
        goto L14
    L22:
        r111 = r111 + 1;
        goto L12
    L23:
        r15 = r15 + ((long) r18.modCount);
        r10 = false;
        r16 = r16 + 1;
        goto L9
    L25:
        if (r15 == r12) goto L26;
        r13 = r13 + 1;
        r12 = r15;
        r10 = false;
        goto L7
    L26:
        return false;
    L29:
        return r10;
    }

    @VisibleForTesting
    public E copyEntry(E r10, E r11) {
        return (E) segmentFor(r10.getHash()).copyEntry(r10, r11);
    }

    public Segment<K, V, E, S> createSegment(int r10, int r11) {
        return this.entryHelper.newSegment(this, r10, r11);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> r10 = this.entrySet;
        if (r10 != null) goto L7;
        EntrySet r11 = new EntrySet(this);
        this.entrySet = r11;
        return r11;
    L7:
        return r10;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(@NullableDecl Object r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        int r11 = hash(r10);
        return segmentFor(r11).get(r10, r11);
    }

    public E getEntry(@NullableDecl Object r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        int r11 = hash(r10);
        return (E) segmentFor(r11).getEntry(r10, r11);
    }

    public V getLiveValue(E r10) {
        if (r10.getKey() != null) goto L7;
        return null;
    L7:
        return (V) r10.getValue();
    }

    public int hash(Object r10) {
        return rehash(this.keyEquivalence.hash(r10));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        Segment<K, V, E, S>[] r10 = this.segments;
        long r11 = 0;
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L10;
        if (r10[r12].count != 0) goto L7;
        r11 = r11 + ((long) r10[r12].modCount);
        r12 = r12 + 1;
        goto L4
    L7:
        return false;
    L10:
        if (r11 == 0) goto L21;
        int r13 = 0;
    L13:
        if (r13 >= r10.length) goto L19;
        if (r10[r13].count != 0) goto L16;
        r11 = r11 - ((long) r10[r13].modCount);
        r13 = r13 + 1;
        goto L13
    L16:
        return false;
    L19:
        if (r11 == 0) goto L27;
        return false;
    L27:
        return true;
    L21:
        return true;
    }

    @VisibleForTesting
    public boolean isLiveForTesting(InternalEntry<K, V, ?> r10) {
        if (segmentFor(r10.getHash()).getLiveValueForTesting(r10) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> r10 = this.keySet;
        if (r10 != null) goto L7;
        KeySet r11 = new KeySet(this);
        this.keySet = r11;
        return r11;
    L7:
        return r10;
    }

    @VisibleForTesting
    public Strength keyStrength() {
        return this.entryHelper.keyStrength();
    }

    public final Segment<K, V, E, S>[] newSegmentArray(int r10) {
        return new Segment[r10];
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    public V put(K r10, V r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        int r12 = hash(r10);
        return segmentFor(r12).put(r10, r12, r11, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> r10) {
        Iterator<Map.Entry<? extends K, ? extends V>> r11 = r10.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry<? extends K, ? extends V> r12 = r11.next();
        put(r12.getKey(), r12.getValue());
        goto L4
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public V putIfAbsent(K r10, V r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        int r12 = hash(r10);
        return segmentFor(r12).put(r10, r12, r11, true);
    }

    public void reclaimKey(E r10) {
        int r11 = r10.getHash();
        segmentFor(r11).reclaimKey(r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void reclaimValue(WeakValueReference<K, V, E> r10) {
        InternalEntry r11 = r10.getEntry();
        int r12 = r11.getHash();
        segmentFor(r12).reclaimValue(r11.getKey(), r12, r10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    public V remove(@NullableDecl Object r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        int r11 = hash(r10);
        return segmentFor(r11).remove(r10, r11);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public boolean replace(K r10, @NullableDecl V r11, V r12) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r12);
        if (r11 != null) goto L6;
        return false;
    L6:
        int r13 = hash(r10);
        return segmentFor(r13).replace(r10, r13, r11, r12);
    }

    public Segment<K, V, E, S> segmentFor(int r10) {
        Segment<K, V, E, S>[] r11 = this.segments;
        int r12 = r10 >>> this.segmentShift;
        return r11[this.segmentMask & r12];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        Segment<K, V, E, S>[] r10 = this.segments;
        long r11 = 0;
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L7;
        r11 = r11 + ((long) r10[r12].count);
        r12 = r12 + 1;
        goto L4
    L7:
        return Ints.saturatedCast(r11);
    }

    @VisibleForTesting
    public Equivalence<Object> valueEquivalence() {
        return this.entryHelper.valueStrength().defaultEquivalence();
    }

    @VisibleForTesting
    public Strength valueStrength() {
        return this.entryHelper.valueStrength();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> r10 = this.values;
        if (r10 != null) goto L7;
        Values r11 = new Values(this);
        this.values = r11;
        return r11;
    L7:
        return r10;
    }

    public Object writeReplace() {
        return new SerializationProxy(this.entryHelper.keyStrength(), this.entryHelper.valueStrength(), this.keyEquivalence, this.entryHelper.valueStrength().defaultEquivalence(), this.concurrencyLevel, this);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public boolean remove(@NullableDecl Object r10, @NullableDecl Object r11) {
        if (r10 == null) goto L7;
        if (r11 == null) goto L9;
        int r12 = hash(r10);
        return segmentFor(r12).remove(r10, r12, r11);
    L9:
        return false;
    L7:
        return false;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public V replace(K r10, V r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        int r12 = hash(r10);
        return segmentFor(r12).replace(r10, r12, r11);
    }
}
