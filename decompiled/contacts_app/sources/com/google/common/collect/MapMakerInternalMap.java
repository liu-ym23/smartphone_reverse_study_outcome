package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.base.Preconditions;
import com.google.common.base.Ticker;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
class MapMakerInternalMap<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {
    static final long CLEANUP_EXECUTOR_DELAY_SECS = 60;
    static final int CONTAINS_VALUE_RETRIES = 3;
    static final Queue<? extends Object> DISCARDING_QUEUE = null;
    static final int DRAIN_MAX = 16;
    static final int DRAIN_THRESHOLD = 63;
    static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MAX_SEGMENTS = 65536;
    static final ValueReference<Object, Object> UNSET = null;
    private static final Logger logger = null;
    private static final long serialVersionUID = 5;
    final int concurrencyLevel;
    final transient EntryFactory entryFactory;
    transient Set<Map.Entry<K, V>> entrySet;
    final long expireAfterAccessNanos;
    final long expireAfterWriteNanos;
    final Equivalence<Object> keyEquivalence;
    transient Set<K> keySet;
    final Strength keyStrength;
    final int maximumSize;
    final MapMaker.RemovalListener<K, V> removalListener;
    final Queue<MapMaker.RemovalNotification<K, V>> removalNotificationQueue;
    final transient int segmentMask;
    final transient int segmentShift;
    final transient Segment<K, V>[] segments;
    final Ticker ticker;
    final Equivalence<Object> valueEquivalence;
    final Strength valueStrength;
    transient Collection<V> values;

    static abstract class AbstractReferenceEntry<K, V> implements ReferenceEntry<K, V> {
        AbstractReferenceEntry() {
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ValueReference<K, V> getValueReference() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setValueReference(ValueReference<K, V> r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<K, V> getNext() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public int getHash() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public K getKey() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public long getExpirationTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setExpirationTime(long r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<K, V> getNextExpirable() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setNextExpirable(ReferenceEntry<K, V> r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousExpirable() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setPreviousExpirable(ReferenceEntry<K, V> r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<K, V> getNextEvictable() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setNextEvictable(ReferenceEntry<K, V> r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousEvictable() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setPreviousEvictable(ReferenceEntry<K, V> r1) {
            throw new UnsupportedOperationException();
        }
    }

    static abstract class AbstractSerializationProxy<K, V> extends ForwardingConcurrentMap<K, V> implements Serializable {
        private static final long serialVersionUID = 3;
        final int concurrencyLevel;
        transient ConcurrentMap<K, V> delegate;
        final long expireAfterAccessNanos;
        final long expireAfterWriteNanos;
        final Equivalence<Object> keyEquivalence;
        final Strength keyStrength;
        final int maximumSize;
        final MapMaker.RemovalListener<? super K, ? super V> removalListener;
        final Equivalence<Object> valueEquivalence;
        final Strength valueStrength;

        @Override // com.google.common.collect.ForwardingConcurrentMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingConcurrentMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Map delegate() {
            return delegate();
        }

        AbstractSerializationProxy(Strength r1, Strength r2, Equivalence<Object> r3, Equivalence<Object> r4, long r5, long r7, int r9, int r10, MapMaker.RemovalListener<? super K, ? super V> r11, ConcurrentMap<K, V> r12) {
            this.keyStrength = r1;
            this.valueStrength = r2;
            this.keyEquivalence = r3;
            this.valueEquivalence = r4;
            this.expireAfterWriteNanos = r5;
            this.expireAfterAccessNanos = r7;
            this.maximumSize = r9;
            this.concurrencyLevel = r10;
            this.removalListener = r11;
            this.delegate = r12;
        }

        @Override // com.google.common.collect.ForwardingConcurrentMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        protected ConcurrentMap<K, V> delegate() {
            return this.delegate;
        }

        void writeMapTo(ObjectOutputStream r3) throws IOException {
            r3.writeInt(this.delegate.size());
            Iterator<Map.Entry<K, V>> r2 = this.delegate.entrySet().iterator();
        L4:
            if (r2.hasNext() == false) goto L6;
            Map.Entry<K, V> r0 = r2.next();
            r3.writeObject(r0.getKey());
            r3.writeObject(r0.getValue());
            goto L4
        L6:
            r3.writeObject(null);
        }

        /* JADX WARN: Type inference failed for: r6v2, types: [com.google.common.collect.MapMaker] */
        /* JADX WARN: Type inference failed for: r6v6, types: [com.google.common.collect.MapMaker] */
        MapMaker readMapMaker(ObjectInputStream r6) throws IOException {
            int r7 = r6.readInt();
            ?? r8 = new MapMaker().initialCapacity2(r7).setKeyStrength(this.keyStrength).setValueStrength(this.valueStrength).keyEquivalence2(this.keyEquivalence).concurrencyLevel2(this.concurrencyLevel);
            r8.removalListener(this.removalListener);
            long r0 = this.expireAfterWriteNanos;
            if (r0 <= 0) goto L5;
            r8.expireAfterWrite2(r0, TimeUnit.NANOSECONDS);
        L5:
            long r1 = this.expireAfterAccessNanos;
            if (r1 <= 0) goto L8;
            r8.expireAfterAccess2(r1, TimeUnit.NANOSECONDS);
        L8:
            int r5 = this.maximumSize;
            if (r5 == (-1)) goto L11;
            r8.maximumSize2(r5);
        L11:
            return r8;
        }

        void readEntries(ObjectInputStream r4) throws IOException, ClassNotFoundException {
        L2:
            Object r0 = r4.readObject();
            if (r0 == null) goto L4;
            Object r1 = r4.readObject();
            this.delegate.put((K) r0, (V) r1);
            goto L2
        }
    }

    static final class CleanupMapTask implements Runnable {
        final WeakReference<MapMakerInternalMap<?, ?>> mapReference;

        public CleanupMapTask(MapMakerInternalMap<?, ?> r2) {
            this.mapReference = new WeakReference(r2);
        }

        @Override // java.lang.Runnable
        public void run() {
            MapMakerInternalMap<?, ?> r3 = this.mapReference.get();
            if (r3 == null) goto L9;
            Segment<?, ?>[] r4 = r3.segments;
            int r0 = r4.length;
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L7;
            r4[r1].runCleanup();
            r1 = r1 + 1;
            goto L5
        L7:
            return;
        L9:
            throw new CancellationException();
        }
    }

    static abstract enum EntryFactory extends Enum<EntryFactory> {
        private static final /* synthetic */ EntryFactory[] $VALUES = null;
        static final int EVICTABLE_MASK = 2;
        static final int EXPIRABLE_MASK = 1;
        public static final EntryFactory STRONG = null;
        public static final EntryFactory STRONG_EVICTABLE = null;
        public static final EntryFactory STRONG_EXPIRABLE = null;
        public static final EntryFactory STRONG_EXPIRABLE_EVICTABLE = null;
        public static final EntryFactory WEAK = null;
        public static final EntryFactory WEAK_EVICTABLE = null;
        public static final EntryFactory WEAK_EXPIRABLE = null;
        public static final EntryFactory WEAK_EXPIRABLE_EVICTABLE = null;
        static final EntryFactory[][] factories = null;

        abstract <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> r1, K r2, int r3, @Nullable ReferenceEntry<K, V> r4);

        private EntryFactory(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ EntryFactory(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        public static EntryFactory valueOf(String r1) {
            return (EntryFactory) Enum.valueOf(EntryFactory.class, r1);
        }

        public static EntryFactory[] values() {
            return (EntryFactory[]) $VALUES.clone();
        }

        static {
            final String r1 = "STRONG";
            final int r2 = 0;
            EntryFactory r0 = new AnonymousClass1(r1, r2);
            STRONG = r0;
            final String r3 = "STRONG_EXPIRABLE";
            final int r4 = 1;
            EntryFactory r5 = new AnonymousClass2(r3, r4);
            STRONG_EXPIRABLE = r5;
            final String r6 = "STRONG_EVICTABLE";
            final int r7 = 2;
            EntryFactory r8 = new AnonymousClass3(r6, r7);
            STRONG_EVICTABLE = r8;
            final String r9 = "STRONG_EXPIRABLE_EVICTABLE";
            final int r10 = 3;
            EntryFactory r11 = new AnonymousClass4(r9, r10);
            STRONG_EXPIRABLE_EVICTABLE = r11;
            final String r12 = "WEAK";
            final int r13 = 4;
            EntryFactory r14 = new AnonymousClass5(r12, r13);
            WEAK = r14;
            final String r15 = "WEAK_EXPIRABLE";
            final int r16 = 5;
            EntryFactory r17 = new AnonymousClass6(r15, r16);
            WEAK_EXPIRABLE = r17;
            final String r18 = "WEAK_EVICTABLE";
            final int r19 = 6;
            EntryFactory r110 = new AnonymousClass7(r18, r19);
            WEAK_EVICTABLE = r110;
            final String r111 = "WEAK_EXPIRABLE_EVICTABLE";
            final int r112 = 7;
            EntryFactory r113 = new AnonymousClass8(r111, r112);
            WEAK_EXPIRABLE_EVICTABLE = r113;
            $VALUES = new EntryFactory[]{r0, r5, r8, r11, r14, r17, r110, r113};
            factories = new EntryFactory[][]{new EntryFactory[]{r0, r5, r8, r11}, new EntryFactory[0], new EntryFactory[]{r14, r17, r110, r113}};
        }

        static EntryFactory getFactory(Strength r0, boolean r1, boolean r2) {
            if (r2 == false) goto L4;
            int r3 = 2;
        L5:
            int r4 = (r1 ? 1 : 0) | r3;
            return factories[r0.ordinal()][r4];
        L4:
            r3 = 0;
            goto L5
        }

        <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> r2, ReferenceEntry<K, V> r3, ReferenceEntry<K, V> r4) {
            return newEntry(r2, r3.getKey(), r3.getHash(), r4);
        }

        <K, V> void copyExpirableEntry(ReferenceEntry<K, V> r3, ReferenceEntry<K, V> r4) {
            r4.setExpirationTime(r3.getExpirationTime());
            MapMakerInternalMap.connectExpirables(r3.getPreviousExpirable(), r4);
            MapMakerInternalMap.connectExpirables(r4, r3.getNextExpirable());
            MapMakerInternalMap.nullifyExpirable(r3);
        }

        <K, V> void copyEvictableEntry(ReferenceEntry<K, V> r1, ReferenceEntry<K, V> r2) {
            MapMakerInternalMap.connectEvictables(r1.getPreviousEvictable(), r2);
            MapMakerInternalMap.connectEvictables(r2, r1.getNextEvictable());
            MapMakerInternalMap.nullifyEvictable(r1);
        }
    }

    final class EntryIterator extends MapMakerInternalMap<K, V>.HashIterator<Map.Entry<K, V>> {
        final /* synthetic */ MapMakerInternalMap this$0;

        EntryIterator(MapMakerInternalMap r1) {
            this.this$0 = r1;
            super(r1);
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

    final class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        final /* synthetic */ MapMakerInternalMap this$0;

        EntrySet(MapMakerInternalMap r1) {
            this.this$0 = r1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator(this.this$0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r4) {
            if ((r4 instanceof Map.Entry) == true) goto L5;
            return false;
        L5:
            Map.Entry r5 = (Map.Entry) r4;
            Object r0 = r5.getKey();
            if (r0 != null) goto L8;
            return false;
        L8:
            Object r1 = this.this$0.get(r0);
            if (r1 != null) goto L11;
            return false;
        L11:
            if (this.this$0.valueEquivalence.equivalent(r5.getValue(), r1) == false) goto L15;
            return true;
        L15:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r3) {
            if ((r3 instanceof Map.Entry) == true) goto L5;
            return false;
        L5:
            Map.Entry r4 = (Map.Entry) r3;
            Object r0 = r4.getKey();
            if (r0 != null) goto L8;
            return false;
        L8:
            if (this.this$0.remove(r0, r4.getValue()) == false) goto L12;
            return true;
        L12:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.this$0.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.this$0.clear();
        }
    }

    static final class EvictionQueue<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {
        final ReferenceEntry<K, V> head;

        EvictionQueue() {
            this.head = new AnonymousClass1(this);
        }

        @Override // java.util.Queue
        public /* bridge */ /* synthetic */ boolean offer(Object r1) {
            return offer((ReferenceEntry) r1);
        }

        @Override // java.util.Queue
        public /* bridge */ /* synthetic */ Object peek() {
            return peek();
        }

        @Override // java.util.Queue
        public /* bridge */ /* synthetic */ Object poll() {
            return poll();
        }

        public boolean offer(ReferenceEntry<K, V> r3) {
            MapMakerInternalMap.connectEvictables(r3.getPreviousEvictable(), r3.getNextEvictable());
            MapMakerInternalMap.connectEvictables(this.head.getPreviousEvictable(), r3);
            MapMakerInternalMap.connectEvictables(r3, this.head);
            return true;
        }

        @Override // java.util.Queue
        public ReferenceEntry<K, V> peek() {
            ReferenceEntry<K, V> r0 = this.head.getNextEvictable();
            if (r0 != this.head) goto L6;
            return null;
        L6:
            return r0;
        }

        @Override // java.util.Queue
        public ReferenceEntry<K, V> poll() {
            ReferenceEntry<K, V> r0 = this.head.getNextEvictable();
            if (r0 != this.head) goto L6;
            return null;
        L6:
            remove(r0);
            return r0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object r2) {
            ReferenceEntry r3 = (ReferenceEntry) r2;
            ReferenceEntry<K, V> r1 = r3.getPreviousEvictable();
            ReferenceEntry<K, V> r0 = r3.getNextEvictable();
            MapMakerInternalMap.connectEvictables(r1, r0);
            MapMakerInternalMap.nullifyEvictable(r3);
            if (r0 == NullEntry.INSTANCE) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object r1) {
            if (((ReferenceEntry) r1).getNextEvictable() == NullEntry.INSTANCE) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            if (this.head.getNextEvictable() != this.head) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            ReferenceEntry<K, V> r0 = this.head.getNextEvictable();
            int r1 = 0;
        L4:
            if (r0 == this.head) goto L6;
            r1 = r1 + 1;
            r0 = r0.getNextEvictable();
            goto L4
        L6:
            return r1;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            ReferenceEntry<K, V> r0 = this.head.getNextEvictable();
        L3:
            ReferenceEntry<K, V> r1 = this.head;
            if (r0 == r1) goto L6;
            ReferenceEntry<K, V> r2 = r0.getNextEvictable();
            MapMakerInternalMap.nullifyEvictable(r0);
            r0 = r2;
            goto L3
        L6:
            r1.setNextEvictable(r1);
            ReferenceEntry<K, V> r3 = this.head;
            r3.setPreviousEvictable(r3);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<ReferenceEntry<K, V>> iterator() {
            final ReferenceEntry<K, V> r1 = peek();
            return new AnonymousClass2(this, r1);
        }
    }

    static final class ExpirationQueue<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {
        final ReferenceEntry<K, V> head;

        ExpirationQueue() {
            this.head = new AnonymousClass1(this);
        }

        @Override // java.util.Queue
        public /* bridge */ /* synthetic */ boolean offer(Object r1) {
            return offer((ReferenceEntry) r1);
        }

        @Override // java.util.Queue
        public /* bridge */ /* synthetic */ Object peek() {
            return peek();
        }

        @Override // java.util.Queue
        public /* bridge */ /* synthetic */ Object poll() {
            return poll();
        }

        public boolean offer(ReferenceEntry<K, V> r3) {
            MapMakerInternalMap.connectExpirables(r3.getPreviousExpirable(), r3.getNextExpirable());
            MapMakerInternalMap.connectExpirables(this.head.getPreviousExpirable(), r3);
            MapMakerInternalMap.connectExpirables(r3, this.head);
            return true;
        }

        @Override // java.util.Queue
        public ReferenceEntry<K, V> peek() {
            ReferenceEntry<K, V> r0 = this.head.getNextExpirable();
            if (r0 != this.head) goto L6;
            return null;
        L6:
            return r0;
        }

        @Override // java.util.Queue
        public ReferenceEntry<K, V> poll() {
            ReferenceEntry<K, V> r0 = this.head.getNextExpirable();
            if (r0 != this.head) goto L6;
            return null;
        L6:
            remove(r0);
            return r0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object r2) {
            ReferenceEntry r3 = (ReferenceEntry) r2;
            ReferenceEntry<K, V> r1 = r3.getPreviousExpirable();
            ReferenceEntry<K, V> r0 = r3.getNextExpirable();
            MapMakerInternalMap.connectExpirables(r1, r0);
            MapMakerInternalMap.nullifyExpirable(r3);
            if (r0 == NullEntry.INSTANCE) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object r1) {
            if (((ReferenceEntry) r1).getNextExpirable() == NullEntry.INSTANCE) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            if (this.head.getNextExpirable() != this.head) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            ReferenceEntry<K, V> r0 = this.head.getNextExpirable();
            int r1 = 0;
        L4:
            if (r0 == this.head) goto L6;
            r1 = r1 + 1;
            r0 = r0.getNextExpirable();
            goto L4
        L6:
            return r1;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            ReferenceEntry<K, V> r0 = this.head.getNextExpirable();
        L3:
            ReferenceEntry<K, V> r1 = this.head;
            if (r0 == r1) goto L6;
            ReferenceEntry<K, V> r2 = r0.getNextExpirable();
            MapMakerInternalMap.nullifyExpirable(r0);
            r0 = r2;
            goto L3
        L6:
            r1.setNextExpirable(r1);
            ReferenceEntry<K, V> r3 = this.head;
            r3.setPreviousExpirable(r3);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<ReferenceEntry<K, V>> iterator() {
            final ReferenceEntry<K, V> r1 = peek();
            return new AnonymousClass2(this, r1);
        }
    }

    abstract class HashIterator<E> implements Iterator<E> {
        Segment<K, V> currentSegment;
        AtomicReferenceArray<ReferenceEntry<K, V>> currentTable;
        MapMakerInternalMap<K, V>.WriteThroughEntry lastReturned;
        ReferenceEntry<K, V> nextEntry;
        MapMakerInternalMap<K, V>.WriteThroughEntry nextExternal;
        int nextSegmentIndex;
        int nextTableIndex;
        final /* synthetic */ MapMakerInternalMap this$0;

        @Override // java.util.Iterator
        public abstract E next();

        HashIterator(MapMakerInternalMap r1) {
            this.this$0 = r1;
            this.nextSegmentIndex = r1.segments.length - 1;
            this.nextTableIndex = -1;
            advance();
        }

        final void advance() {
            this.nextExternal = null;
            if (nextInChain() == false) goto L6;
            return;
        L6:
            if (nextInTable() == false) goto L9;
            return;
        L9:
            if (this.nextSegmentIndex < 0) goto L14;
            Segment<K, V>[] r0 = this.this$0.segments;
            int r1 = this.nextSegmentIndex;
            this.nextSegmentIndex = r1 - 1;
            Segment<K, V> r2 = r0[r1];
            this.currentSegment = r2;
            if (r2.count == 0) goto L9;
            AtomicReferenceArray<ReferenceEntry<K, V>> r3 = this.currentSegment.table;
            this.currentTable = r3;
            this.nextTableIndex = r3.length() - 1;
            if (nextInTable() == false) goto L9;
            return;
        }

        boolean nextInChain() {
            ReferenceEntry<K, V> r0 = this.nextEntry;
            if (r0 == null) goto L11;
        L4:
            this.nextEntry = r0.getNext();
            ReferenceEntry<K, V> r1 = this.nextEntry;
            if (r1 == null) goto L15;
            if (advanceTo(r1) == true) goto L8;
            r0 = this.nextEntry;
            goto L4
        L8:
            return true;
        L15:
            return false;
        L11:
            return false;
        }

        boolean nextInTable() {
        L2:
            int r0 = this.nextTableIndex;
            if (r0 < 0) goto L12;
            AtomicReferenceArray<ReferenceEntry<K, V>> r1 = this.currentTable;
            this.nextTableIndex = r0 - 1;
            ReferenceEntry<K, V> r2 = r1.get(r0);
            this.nextEntry = r2;
            if (r2 == null) goto L2;
            if (advanceTo(r2) == true) goto L10;
            if (nextInChain() == false) goto L2;
            return true;
        L10:
            return true;
        L12:
            return false;
        }

        boolean advanceTo(ReferenceEntry<K, V> r4) {
            K r0 = r4.getKey();     // Catch: Throwable -> L9
            Object r5 = this.this$0.getLiveValue(r4);     // Catch: Throwable -> L9
            if (r5 == null) goto L7;
            this.nextExternal = new WriteThroughEntry(this.this$0, r0, r5);     // Catch: Throwable -> L9
            this.currentSegment.postReadCleanup();
            return true;
        L7:
            this.currentSegment.postReadCleanup();
            return false;
        L9:
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

        MapMakerInternalMap<K, V>.WriteThroughEntry nextEntry() {
            MapMakerInternalMap<K, V>.WriteThroughEntry r0 = this.nextExternal;
            if (r0 == null) goto L7;
            this.lastReturned = r0;
            advance();
            return this.lastReturned;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.lastReturned == null) goto L5;
            boolean r0 = true;
        L6:
            CollectPreconditions.checkRemove(r0);
            this.this$0.remove(this.lastReturned.getKey());
            this.lastReturned = null;
            return;
        L5:
            r0 = false;
            goto L6
        }
    }

    final class KeyIterator extends MapMakerInternalMap<K, V>.HashIterator<K> {
        final /* synthetic */ MapMakerInternalMap this$0;

        KeyIterator(MapMakerInternalMap r1) {
            this.this$0 = r1;
            super(r1);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.HashIterator, java.util.Iterator
        public K next() {
            return nextEntry().getKey();
        }
    }

    final class KeySet extends AbstractSet<K> {
        final /* synthetic */ MapMakerInternalMap this$0;

        KeySet(MapMakerInternalMap r1) {
            this.this$0 = r1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new KeyIterator(this.this$0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.this$0.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r1) {
            return this.this$0.containsKey(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r1) {
            if (this.this$0.remove(r1) == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.this$0.clear();
        }
    }

    private static final enum NullEntry extends Enum<NullEntry> implements ReferenceEntry<Object, Object> {
        private static final /* synthetic */ NullEntry[] $VALUES = null;
        public static final NullEntry INSTANCE = null;

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public long getExpirationTime() {
            return 0;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public int getHash() {
            return 0;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public Object getKey() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<Object, Object> getNext() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<Object, Object> getNextEvictable() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<Object, Object> getNextExpirable() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<Object, Object> getPreviousEvictable() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<Object, Object> getPreviousExpirable() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ValueReference<Object, Object> getValueReference() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setExpirationTime(long r1) {
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setNextEvictable(ReferenceEntry<Object, Object> r1) {
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setNextExpirable(ReferenceEntry<Object, Object> r1) {
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setPreviousEvictable(ReferenceEntry<Object, Object> r1) {
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setPreviousExpirable(ReferenceEntry<Object, Object> r1) {
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setValueReference(ValueReference<Object, Object> r1) {
        }

        private NullEntry(String r1, int r2) {
            super(r1, r2);
        }

        public static NullEntry valueOf(String r1) {
            return (NullEntry) Enum.valueOf(NullEntry.class, r1);
        }

        public static NullEntry[] values() {
            return (NullEntry[]) $VALUES.clone();
        }

        static {
            NullEntry r0 = new NullEntry("INSTANCE", 0);
            INSTANCE = r0;
            $VALUES = new NullEntry[]{r0};
        }
    }

    interface ReferenceEntry<K, V> {
        long getExpirationTime();

        int getHash();

        K getKey();

        ReferenceEntry<K, V> getNext();

        ReferenceEntry<K, V> getNextEvictable();

        ReferenceEntry<K, V> getNextExpirable();

        ReferenceEntry<K, V> getPreviousEvictable();

        ReferenceEntry<K, V> getPreviousExpirable();

        ValueReference<K, V> getValueReference();

        void setExpirationTime(long r1);

        void setNextEvictable(ReferenceEntry<K, V> r1);

        void setNextExpirable(ReferenceEntry<K, V> r1);

        void setPreviousEvictable(ReferenceEntry<K, V> r1);

        void setPreviousExpirable(ReferenceEntry<K, V> r1);

        void setValueReference(ValueReference<K, V> r1);
    }

    static class Segment<K, V> extends ReentrantLock {
        volatile int count;
        final Queue<ReferenceEntry<K, V>> evictionQueue;
        final Queue<ReferenceEntry<K, V>> expirationQueue;
        final ReferenceQueue<K> keyReferenceQueue;
        final MapMakerInternalMap<K, V> map;
        final int maxSegmentSize;
        int modCount;
        final AtomicInteger readCount;
        final Queue<ReferenceEntry<K, V>> recencyQueue;
        volatile AtomicReferenceArray<ReferenceEntry<K, V>> table;
        int threshold;
        final ReferenceQueue<V> valueReferenceQueue;

        Segment(MapMakerInternalMap<K, V> r2, int r3, int r4) {
            this.readCount = new AtomicInteger();
            this.map = r2;
            this.maxSegmentSize = r4;
            initTable(newEntryArray(r3));
            ReferenceQueue<V> r5 = null;
            if (r2.usesKeyReferences() == false) goto L5;
            ReferenceQueue<K> r6 = new ReferenceQueue();
        L6:
            this.keyReferenceQueue = r6;
            if (r2.usesValueReferences() == false) goto L9;
            r5 = new ReferenceQueue();
        L9:
            this.valueReferenceQueue = r5;
            if (r2.evictsBySize() == false) goto L12;
        L15:
            Queue<ReferenceEntry<K, V>> r7 = new ConcurrentLinkedQueue();
        L16:
            this.recencyQueue = r7;
            if (r2.evictsBySize() == false) goto L19;
            Queue<ReferenceEntry<K, V>> r8 = new EvictionQueue();
        L20:
            this.evictionQueue = r8;
            if (r2.expires() == false) goto L23;
            Queue<ReferenceEntry<K, V>> r9 = new ExpirationQueue();
        L24:
            this.expirationQueue = r9;
            return;
        L23:
            r9 = MapMakerInternalMap.discardingQueue();
            goto L24
        L19:
            r8 = MapMakerInternalMap.discardingQueue();
            goto L20
        L12:
            if (r2.expiresAfterAccess() == true) goto L15;
            r7 = MapMakerInternalMap.discardingQueue();
            goto L16
        L5:
            r6 = null;
            goto L6
        }

        AtomicReferenceArray<ReferenceEntry<K, V>> newEntryArray(int r1) {
            return new AtomicReferenceArray(r1);
        }

        void initTable(AtomicReferenceArray<ReferenceEntry<K, V>> r3) {
            int r0 = (r3.length() * 3) / 4;
            this.threshold = r0;
            if (r0 != this.maxSegmentSize) goto L5;
            this.threshold = r0 + 1;
        L5:
            this.table = r3;
        }

        ReferenceEntry<K, V> newEntry(K r2, int r3, @Nullable ReferenceEntry<K, V> r4) {
            return this.map.entryFactory.newEntry(this, r2, r3, r4);
        }

        ReferenceEntry<K, V> copyEntry(ReferenceEntry<K, V> r5, ReferenceEntry<K, V> r6) {
            if (r5.getKey() != null) goto L5;
            return null;
        L5:
            ValueReference<K, V> r0 = r5.getValueReference();
            V r2 = r0.get();
            if (r2 == null) goto L8;
        L10:
            ReferenceEntry<K, V> r7 = this.map.entryFactory.copyEntry(this, r5, r6);
            r7.setValueReference(r0.copyFor(this.valueReferenceQueue, r2, r7));
            return r7;
        L8:
            if (r0.isComputingReference() == true) goto L10;
            return null;
        }

        void setValue(ReferenceEntry<K, V> r2, V r3) {
            r2.setValueReference(this.map.valueStrength.referenceValue(this, r2, r3));
            recordWrite(r2);
        }

        void tryDrainReferenceQueues() {
            if (tryLock() == true) goto L10;
            return;
        L10:
            drainReferenceQueues();     // Catch: Throwable -> L6
            unlock();
            return;
        L6:
            th = move-exception;
            unlock();
            throw th;
        }

        void drainReferenceQueues() {
            if (this.map.usesKeyReferences() == false) goto L6;
            drainKeyReferenceQueue();
        L6:
            if (this.map.usesValueReferences() == false) goto L9;
            drainValueReferenceQueue();
            return;
        }

        void drainKeyReferenceQueue() {
            int r0 = 0;
        L3:
            Reference<? extends K> r1 = this.keyReferenceQueue.poll();
            if (r1 == null) goto L7;
            MapMakerInternalMap<K, V> r2 = this.map;
            r2.reclaimKey((ReferenceEntry) r1);
            r0 = r0 + 1;
            if (r0 != 16) goto L3;
            return;
        }

        void drainValueReferenceQueue() {
            int r0 = 0;
        L3:
            Reference<? extends V> r1 = this.valueReferenceQueue.poll();
            if (r1 == null) goto L7;
            MapMakerInternalMap<K, V> r2 = this.map;
            r2.reclaimValue((ValueReference) r1);
            r0 = r0 + 1;
            if (r0 != 16) goto L3;
            return;
        }

        void clearReferenceQueues() {
            if (this.map.usesKeyReferences() == false) goto L6;
            clearKeyReferenceQueue();
        L6:
            if (this.map.usesValueReferences() == false) goto L9;
            clearValueReferenceQueue();
            return;
        }

        void clearKeyReferenceQueue() {
        L3:
            if (this.keyReferenceQueue.poll() != null) goto L3;
        }

        void clearValueReferenceQueue() {
        L3:
            if (this.valueReferenceQueue.poll() != null) goto L3;
        }

        void recordRead(ReferenceEntry<K, V> r3) {
            if (this.map.expiresAfterAccess() == false) goto L5;
            recordExpirationTime(r3, this.map.expireAfterAccessNanos);
        L5:
            this.recencyQueue.add(r3);
        }

        void recordLockedRead(ReferenceEntry<K, V> r3) {
            this.evictionQueue.add(r3);
            if (this.map.expiresAfterAccess() == false) goto L6;
            recordExpirationTime(r3, this.map.expireAfterAccessNanos);
            this.expirationQueue.add(r3);
            return;
        }

        void recordWrite(ReferenceEntry<K, V> r3) {
            drainRecencyQueue();
            this.evictionQueue.add(r3);
            if (this.map.expires() == true) goto L5;
            return;
        L5:
            if (this.map.expiresAfterAccess() == false) goto L7;
            long r0 = this.map.expireAfterAccessNanos;
        L8:
            recordExpirationTime(r3, r0);
            this.expirationQueue.add(r3);
            return;
        L7:
            r0 = this.map.expireAfterWriteNanos;
            goto L8
        }

        void drainRecencyQueue() {
        L2:
            ReferenceEntry<K, V> r0 = this.recencyQueue.poll();
            if (r0 == null) goto L12;
            if (this.evictionQueue.contains(r0) == false) goto L8;
            this.evictionQueue.add(r0);
        L8:
            if (this.map.expiresAfterAccess() == false) goto L2;
            if (this.expirationQueue.contains(r0) == false) goto L2;
            this.expirationQueue.add(r0);
            goto L2
        }

        void recordExpirationTime(ReferenceEntry<K, V> r3, long r4) {
            r3.setExpirationTime(this.map.ticker.read() + r4);
        }

        void tryExpireEntries() {
            if (tryLock() == true) goto L10;
            return;
        L10:
            expireEntries();     // Catch: Throwable -> L6
            unlock();
            return;
        L6:
            th = move-exception;
            unlock();
            throw th;
        }

        void expireEntries() {
            drainRecencyQueue();
            if (this.expirationQueue.isEmpty() == false) goto L5;
            return;
        L5:
            long r0 = this.map.ticker.read();
        L6:
            ReferenceEntry<K, V> r2 = this.expirationQueue.peek();
            if (r2 == null) goto L15;
            if (this.map.isExpired(r2, r0) == false) goto L20;
            if (removeEntry(r2, r2.getHash(), MapMaker.RemovalCause.EXPIRED) == true) goto L6;
            throw new AssertionError();
        L20:
            return;
        }

        void enqueueNotification(ReferenceEntry<K, V> r3, MapMaker.RemovalCause r4) {
            enqueueNotification(r3.getKey(), r3.getHash(), r3.getValueReference().get(), r4);
        }

        void enqueueNotification(@Nullable K r2, int r3, @Nullable V r4, MapMaker.RemovalCause r5) {
            if (this.map.removalNotificationQueue == MapMakerInternalMap.DISCARDING_QUEUE) goto L6;
            MapMaker.RemovalNotification<K, V> r6 = new MapMaker.RemovalNotification(r2, r4, r5);
            this.map.removalNotificationQueue.offer(r6);
            return;
        }

        boolean evictEntries() {
            if (this.map.evictsBySize() == true) goto L5;
            return false;
        L5:
            if (this.count < this.maxSegmentSize) goto L14;
            drainRecencyQueue();
            ReferenceEntry<K, V> r0 = this.evictionQueue.remove();
            if (removeEntry(r0, r0.getHash(), MapMaker.RemovalCause.SIZE) == false) goto L11;
            return true;
        L11:
            throw new AssertionError();
        L14:
            return false;
        }

        ReferenceEntry<K, V> getFirst(int r2) {
            AtomicReferenceArray<ReferenceEntry<K, V>> r1 = this.table;
            return r1.get(r2 & (r1.length() - 1));
        }

        ReferenceEntry<K, V> getEntry(Object r4, int r5) {
            if (this.count == 0) goto L16;
            ReferenceEntry<K, V> r0 = getFirst(r5);
        L5:
            if (r0 == null) goto L23;
            if (r0.getHash() != r5) goto L15;
            K r1 = r0.getKey();
            if (r1 != null) goto L13;
            tryDrainReferenceQueues();
            goto L15
        L13:
            if (this.map.keyEquivalence.equivalent(r4, r1) == false) goto L15;
            return r0;
        L15:
            r0 = r0.getNext();
            goto L5
        L23:
            return null;
        L16:
            return null;
        }

        ReferenceEntry<K, V> getLiveEntry(Object r2, int r3) {
            ReferenceEntry<K, V> r4 = getEntry(r2, r3);
            if (r4 != null) goto L6;
            return null;
        L6:
            if (this.map.expires() == true) goto L8;
        L11:
            return r4;
        L8:
            if (this.map.isExpired(r4) == false) goto L11;
            tryExpireEntries();
            return null;
        }

        V get(Object r1, int r2) {
            ReferenceEntry<K, V> r3 = getLiveEntry(r1, r2);     // Catch: Throwable -> L12
            if (r3 != null) goto L6;
            postReadCleanup();
            return null;
        L6:
            V r4 = r3.getValueReference().get();     // Catch: Throwable -> L12
            if (r4 == null) goto L9;
            recordRead(r3);     // Catch: Throwable -> L12
        L10:
            postReadCleanup();
            return r4;
        L9:
            tryDrainReferenceQueues();     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            postReadCleanup();
            throw th;
        }

        boolean containsKey(Object r3, int r4) {
            boolean r1 = false;
            if (this.count == 0) goto L13;
            ReferenceEntry<K, V> r5 = getLiveEntry(r3, r4);     // Catch: Throwable -> L15
            if (r5 != null) goto L8;
            postReadCleanup();
            return false;
        L8:
            if (r5.getValueReference().get() == null) goto L11;
            r1 = true;
        L11:
            postReadCleanup();
            return r1;
        L13:
            postReadCleanup();
            return false;
        L15:
            th = move-exception;
            postReadCleanup();
            throw th;
        }

        boolean containsValue(Object r8) {
        L20:
            th = move-exception;
            postReadCleanup();
            throw th;
        L3:
            if (this.count == 0) goto L18;
            AtomicReferenceArray<ReferenceEntry<K, V>> r0 = this.table;     // Catch: Throwable -> L20
            int r2 = r0.length();     // Catch: Throwable -> L20
            int r3 = 0;
        L5:
            if (r3 >= r2) goto L18;
            ReferenceEntry<K, V> r4 = r0.get(r3);     // Catch: Throwable -> L20
        L7:
            if (r4 == null) goto L17;
            V r5 = getLiveValue(r4);     // Catch: Throwable -> L20
            if (r5 != null) goto L12;
        L15:
            r4 = r4.getNext();     // Catch: Throwable -> L20
            goto L7
        L12:
            if (this.map.valueEquivalence.equivalent(r8, r5) == false) goto L15;
            postReadCleanup();
            return true;
        L17:
            r3 = r3 + 1;
        L18:
            postReadCleanup();
            return false;
        }

        V put(K r9, int r10, V r11, boolean r12) {
            lock();
            preWriteCleanup();     // Catch: Throwable -> L36
            int r0 = this.count + 1;     // Catch: Throwable -> L36
            if (r0 <= this.threshold) goto L6;
            expand();     // Catch: Throwable -> L36
            r0 = this.count + 1;     // Catch: Throwable -> L36
        L6:
            AtomicReferenceArray<ReferenceEntry<K, V>> r1 = this.table;     // Catch: Throwable -> L36
            int r2 = (r1.length() - 1) & r10;     // Catch: Throwable -> L36
            ReferenceEntry<K, V> r3 = r1.get(r2);     // Catch: Throwable -> L36
            ReferenceEntry<K, V> r4 = r3;
        L8:
            if (r4 == null) goto L31;
            K r6 = r4.getKey();     // Catch: Throwable -> L36
            if (r4.getHash() != r10) goto L30;
            if (r6 == null) goto L30;
            if (this.map.keyEquivalence.equivalent(r9, r6) == false) goto L30;
            ValueReference<K, V> r5 = r4.getValueReference();     // Catch: Throwable -> L36
            V r7 = r5.get();     // Catch: Throwable -> L36
            if (r7 != null) goto L25;
            this.modCount++;     // Catch: Throwable -> L36
            setValue(r4, r11);     // Catch: Throwable -> L36
            if (r5.isComputingReference() == true) goto L20;
            enqueueNotification(r9, r10, r7, MapMaker.RemovalCause.COLLECTED);     // Catch: Throwable -> L36
            r0 = this.count;     // Catch: Throwable -> L36
        L22:
            this.count = r0;     // Catch: Throwable -> L36
        L23:
            unlock();
            postWriteCleanup();
            return null;
        L20:
            if (evictEntries() == false) goto L22;
            r0 = this.count + 1;     // Catch: Throwable -> L36
            goto L22
        L25:
            if (r12 == false) goto L29;
            recordLockedRead(r4);     // Catch: Throwable -> L36
        L27:
            unlock();
            postWriteCleanup();
            return r7;
        L29:
            this.modCount++;     // Catch: Throwable -> L36
            enqueueNotification(r9, r10, r7, MapMaker.RemovalCause.REPLACED);     // Catch: Throwable -> L36
            setValue(r4, r11);     // Catch: Throwable -> L36
        L30:
            r4 = r4.getNext();     // Catch: Throwable -> L36
            goto L8
        L31:
            this.modCount++;     // Catch: Throwable -> L36
            ReferenceEntry<K, V> r13 = newEntry(r9, r10, r3);     // Catch: Throwable -> L36
            setValue(r13, r11);     // Catch: Throwable -> L36
            r1.set(r2, r13);     // Catch: Throwable -> L36
            if (evictEntries() == false) goto L34;
            r0 = this.count + 1;     // Catch: Throwable -> L36
        L34:
            this.count = r0;     // Catch: Throwable -> L36
        L36:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        void expand() {
            AtomicReferenceArray<ReferenceEntry<K, V>> r0 = this.table;
            int r1 = r0.length();
            if (r1 < 1073741824) goto L5;
            return;
        L5:
            int r2 = this.count;
            AtomicReferenceArray<ReferenceEntry<K, V>> r3 = newEntryArray(r1 << 1);
            this.threshold = (r3.length() * 3) / 4;
            int r4 = r3.length() - 1;
            int r5 = 0;
        L6:
            if (r5 >= r1) goto L26;
            ReferenceEntry<K, V> r6 = r0.get(r5);
            if (r6 == null) goto L25;
            ReferenceEntry<K, V> r7 = r6.getNext();
            int r8 = r6.getHash() & r4;
            if (r7 != null) goto L12;
            r3.set(r8, r6);
            goto L25
        L12:
            ReferenceEntry<K, V> r9 = r6;
        L13:
            if (r7 == null) goto L18;
            int r10 = r7.getHash() & r4;
            if (r10 == r8) goto L17;
            r9 = r7;
            r8 = r10;
        L17:
            r7 = r7.getNext();
            goto L13
        L18:
            r3.set(r8, r9);
        L19:
            if (r6 == r9) goto L25;
            int r11 = r6.getHash() & r4;
            ReferenceEntry<K, V> r12 = copyEntry(r6, r3.get(r11));
            if (r12 == null) goto L23;
            r3.set(r11, r12);
        L24:
            r6 = r6.getNext();
            goto L19
        L23:
            removeCollectedEntry(r6);
            r2 = r2 - 1;
        L25:
            r5 = r5 + 1;
            goto L6
        L26:
            this.table = r3;
            this.count = r2;
        }

        boolean replace(K r10, int r11, V r12, V r13) {
            lock();
            preWriteCleanup();     // Catch: Throwable -> L26
            AtomicReferenceArray<ReferenceEntry<K, V>> r0 = this.table;     // Catch: Throwable -> L26
            int r1 = (r0.length() - 1) & r11;     // Catch: Throwable -> L26
            ReferenceEntry<K, V> r3 = r0.get(r1);     // Catch: Throwable -> L26
            ReferenceEntry<K, V> r4 = r3;
        L5:
            if (r4 == null) goto L16;
            K r6 = r4.getKey();     // Catch: Throwable -> L26
            if (r4.getHash() != r11) goto L24;
            if (r6 == null) goto L24;
            if (this.map.keyEquivalence.equivalent(r10, r6) == false) goto L24;
            ValueReference<K, V> r7 = r4.getValueReference();     // Catch: Throwable -> L26
            V r8 = r7.get();     // Catch: Throwable -> L26
            if (r8 != null) goto L19;
            if (isCollected(r7) == false) goto L16;
            this.modCount++;     // Catch: Throwable -> L26
            enqueueNotification(r6, r11, r8, MapMaker.RemovalCause.COLLECTED);     // Catch: Throwable -> L26
            ReferenceEntry<K, V> r14 = removeFromChain(r3, r4);     // Catch: Throwable -> L26
            int r15 = this.count - 1;     // Catch: Throwable -> L26
            r0.set(r1, r14);     // Catch: Throwable -> L26
            this.count = r15;     // Catch: Throwable -> L26
            goto L16
        L19:
            if (this.map.valueEquivalence.equivalent(r12, r8) == false) goto L23;
            this.modCount++;     // Catch: Throwable -> L26
            enqueueNotification(r10, r11, r8, MapMaker.RemovalCause.REPLACED);     // Catch: Throwable -> L26
            setValue(r4, r13);     // Catch: Throwable -> L26
            unlock();
            postWriteCleanup();
            return true;
        L23:
            recordLockedRead(r4);     // Catch: Throwable -> L26
        L24:
            r4 = r4.getNext();     // Catch: Throwable -> L26
        L16:
            unlock();
            postWriteCleanup();
            return false;
        L26:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        V replace(K r9, int r10, V r11) {
            lock();
            preWriteCleanup();     // Catch: Throwable -> L23
            AtomicReferenceArray<ReferenceEntry<K, V>> r0 = this.table;     // Catch: Throwable -> L23
            int r1 = (r0.length() - 1) & r10;     // Catch: Throwable -> L23
            ReferenceEntry<K, V> r2 = r0.get(r1);     // Catch: Throwable -> L23
            ReferenceEntry<K, V> r3 = r2;
        L5:
            if (r3 == null) goto L16;
            K r5 = r3.getKey();     // Catch: Throwable -> L23
            if (r3.getHash() != r10) goto L21;
            if (r5 == null) goto L21;
            if (this.map.keyEquivalence.equivalent(r9, r5) == false) goto L21;
            ValueReference<K, V> r6 = r3.getValueReference();     // Catch: Throwable -> L23
            V r7 = r6.get();     // Catch: Throwable -> L23
            if (r7 == null) goto L14;
            this.modCount++;     // Catch: Throwable -> L23
            enqueueNotification(r9, r10, r7, MapMaker.RemovalCause.REPLACED);     // Catch: Throwable -> L23
            setValue(r3, r11);     // Catch: Throwable -> L23
            unlock();
            postWriteCleanup();
            return r7;
        L14:
            if (isCollected(r6) == false) goto L16;
            this.modCount++;     // Catch: Throwable -> L23
            enqueueNotification(r5, r10, r7, MapMaker.RemovalCause.COLLECTED);     // Catch: Throwable -> L23
            ReferenceEntry<K, V> r12 = removeFromChain(r2, r3);     // Catch: Throwable -> L23
            int r13 = this.count - 1;     // Catch: Throwable -> L23
            r0.set(r1, r12);     // Catch: Throwable -> L23
            this.count = r13;     // Catch: Throwable -> L23
        L21:
            r3 = r3.getNext();     // Catch: Throwable -> L23
        L16:
            unlock();
            postWriteCleanup();
            return null;
        L23:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        V remove(Object r8, int r9) {
            lock();
            preWriteCleanup();     // Catch: Throwable -> L24
            AtomicReferenceArray<ReferenceEntry<K, V>> r0 = this.table;     // Catch: Throwable -> L24
            int r1 = (r0.length() - 1) & r9;     // Catch: Throwable -> L24
            ReferenceEntry<K, V> r2 = r0.get(r1);     // Catch: Throwable -> L24
            ReferenceEntry<K, V> r3 = r2;
        L5:
            if (r3 == null) goto L20;
            K r5 = r3.getKey();     // Catch: Throwable -> L24
            if (r3.getHash() != r9) goto L22;
            if (r5 == null) goto L22;
            if (this.map.keyEquivalence.equivalent(r8, r5) == false) goto L22;
            ValueReference<K, V> r10 = r3.getValueReference();     // Catch: Throwable -> L24
            V r6 = r10.get();     // Catch: Throwable -> L24
            if (r6 == null) goto L15;
            MapMaker.RemovalCause r11 = MapMaker.RemovalCause.EXPLICIT;     // Catch: Throwable -> L24
        L17:
            this.modCount++;     // Catch: Throwable -> L24
            enqueueNotification(r5, r9, r6, r11);     // Catch: Throwable -> L24
            ReferenceEntry<K, V> r12 = removeFromChain(r2, r3);     // Catch: Throwable -> L24
            int r13 = this.count - 1;     // Catch: Throwable -> L24
            r0.set(r1, r12);     // Catch: Throwable -> L24
            this.count = r13;     // Catch: Throwable -> L24
            unlock();
            postWriteCleanup();
            return r6;
        L15:
            if (isCollected(r10) == false) goto L20;
            r11 = MapMaker.RemovalCause.COLLECTED;     // Catch: Throwable -> L24
        L22:
            r3 = r3.getNext();     // Catch: Throwable -> L24
        L20:
            unlock();
            postWriteCleanup();
            return null;
        L24:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        boolean remove(Object r10, int r11, Object r12) {
            lock();
            preWriteCleanup();     // Catch: Throwable -> L27
            AtomicReferenceArray<ReferenceEntry<K, V>> r0 = this.table;     // Catch: Throwable -> L27
            boolean r2 = true;
            int r1 = (r0.length() - 1) & r11;     // Catch: Throwable -> L27
            ReferenceEntry<K, V> r3 = r0.get(r1);     // Catch: Throwable -> L27
            ReferenceEntry<K, V> r4 = r3;
        L5:
            if (r4 == null) goto L23;
            K r6 = r4.getKey();     // Catch: Throwable -> L27
            if (r4.getHash() != r11) goto L25;
            if (r6 == null) goto L25;
            if (this.map.keyEquivalence.equivalent(r10, r6) == false) goto L25;
            ValueReference<K, V> r13 = r4.getValueReference();     // Catch: Throwable -> L27
            V r7 = r13.get();     // Catch: Throwable -> L27
            if (this.map.valueEquivalence.equivalent(r12, r7) == false) goto L15;
            MapMaker.RemovalCause r14 = MapMaker.RemovalCause.EXPLICIT;     // Catch: Throwable -> L27
        L17:
            this.modCount++;     // Catch: Throwable -> L27
            enqueueNotification(r6, r11, r7, r14);     // Catch: Throwable -> L27
            ReferenceEntry<K, V> r15 = removeFromChain(r3, r4);     // Catch: Throwable -> L27
            int r16 = this.count - 1;     // Catch: Throwable -> L27
            r0.set(r1, r15);     // Catch: Throwable -> L27
            this.count = r16;     // Catch: Throwable -> L27
            if (r14 == MapMaker.RemovalCause.EXPLICIT) goto L21;
            r2 = false;
        L21:
            unlock();
            postWriteCleanup();
            return r2;
        L15:
            if (isCollected(r13) == false) goto L23;
            r14 = MapMaker.RemovalCause.COLLECTED;     // Catch: Throwable -> L27
        L25:
            r4 = r4.getNext();     // Catch: Throwable -> L27
        L23:
            unlock();
            postWriteCleanup();
            return false;
        L27:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        void clear() {
            if (this.count == 0) goto L26;
            lock();
            AtomicReferenceArray<ReferenceEntry<K, V>> r0 = this.table;     // Catch: Throwable -> L23
            if (this.map.removalNotificationQueue == MapMakerInternalMap.DISCARDING_QUEUE) goto L17;
            int r1 = 0;
        L9:
            if (r1 >= r0.length()) goto L17;
            ReferenceEntry<K, V> r2 = r0.get(r1);     // Catch: Throwable -> L23
        L11:
            if (r2 == null) goto L16;
            if (r2.getValueReference().isComputingReference() == true) goto L15;
            enqueueNotification(r2, MapMaker.RemovalCause.EXPLICIT);     // Catch: Throwable -> L23
        L15:
            r2 = r2.getNext();     // Catch: Throwable -> L23
            goto L11
        L16:
            r1 = r1 + 1;     // Catch: Throwable -> L23
        L17:
            int r3 = 0;
        L19:
            if (r3 >= r0.length()) goto L21;
            r0.set(r3, null);     // Catch: Throwable -> L23
            r3 = r3 + 1;     // Catch: Throwable -> L23
            goto L19
        L21:
            clearReferenceQueues();     // Catch: Throwable -> L23
            this.evictionQueue.clear();     // Catch: Throwable -> L23
            this.expirationQueue.clear();     // Catch: Throwable -> L23
            this.readCount.set(0);     // Catch: Throwable -> L23
            this.modCount++;     // Catch: Throwable -> L23
            this.count = 0;     // Catch: Throwable -> L23
            unlock();
            postWriteCleanup();
            return;
        L23:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        ReferenceEntry<K, V> removeFromChain(ReferenceEntry<K, V> r4, ReferenceEntry<K, V> r5) {
            this.evictionQueue.remove(r5);
            this.expirationQueue.remove(r5);
            int r0 = this.count;
            ReferenceEntry<K, V> r1 = r5.getNext();
        L3:
            if (r4 == r5) goto L9;
            ReferenceEntry<K, V> r2 = copyEntry(r4, r1);
            if (r2 == null) goto L7;
            r1 = r2;
        L8:
            r4 = r4.getNext();
            goto L3
        L7:
            removeCollectedEntry(r4);
            r0 = r0 - 1;
            goto L8
        L9:
            this.count = r0;
            return r1;
        }

        void removeCollectedEntry(ReferenceEntry<K, V> r2) {
            enqueueNotification(r2, MapMaker.RemovalCause.COLLECTED);
            this.evictionQueue.remove(r2);
            this.expirationQueue.remove(r2);
        }

        boolean reclaimKey(ReferenceEntry<K, V> r8, int r9) {
            lock();
            AtomicReferenceArray<ReferenceEntry<K, V>> r0 = this.table;     // Catch: Throwable -> L13
            int r1 = (r0.length() - 1) & r9;     // Catch: Throwable -> L13
            ReferenceEntry<K, V> r3 = r0.get(r1);     // Catch: Throwable -> L13
            ReferenceEntry<K, V> r4 = r3;
        L4:
            if (r4 == null) goto L11;
            if (r4 == r8) goto L6;
            r4 = r4.getNext();     // Catch: Throwable -> L13
            goto L4
        L6:
            this.modCount++;     // Catch: Throwable -> L13
            enqueueNotification(r4.getKey(), r9, r4.getValueReference().get(), MapMaker.RemovalCause.COLLECTED);     // Catch: Throwable -> L13
            ReferenceEntry<K, V> r10 = removeFromChain(r3, r4);     // Catch: Throwable -> L13
            int r11 = this.count - 1;     // Catch: Throwable -> L13
            r0.set(r1, r10);     // Catch: Throwable -> L13
            this.count = r11;     // Catch: Throwable -> L13
            unlock();
            postWriteCleanup();
            return true;
        L11:
            unlock();
            postWriteCleanup();
            return false;
        L13:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        boolean reclaimValue(K r9, int r10, ValueReference<K, V> r11) {
            lock();
            AtomicReferenceArray<ReferenceEntry<K, V>> r0 = this.table;     // Catch: Throwable -> L28
            int r1 = (r0.length() - 1) & r10;     // Catch: Throwable -> L28
            ReferenceEntry<K, V> r3 = r0.get(r1);     // Catch: Throwable -> L28
            ReferenceEntry<K, V> r4 = r3;
        L5:
            if (r4 == null) goto L24;
            K r6 = r4.getKey();     // Catch: Throwable -> L28
            if (r4.getHash() != r10) goto L22;
            if (r6 == null) goto L22;
            if (this.map.keyEquivalence.equivalent(r9, r6) == false) goto L22;
            if (r4.getValueReference() != r11) goto L18;
            this.modCount++;     // Catch: Throwable -> L28
            enqueueNotification(r9, r10, r11.get(), MapMaker.RemovalCause.COLLECTED);     // Catch: Throwable -> L28
            ReferenceEntry<K, V> r12 = removeFromChain(r3, r4);     // Catch: Throwable -> L28
            int r13 = this.count - 1;     // Catch: Throwable -> L28
            r0.set(r1, r12);     // Catch: Throwable -> L28
            this.count = r13;     // Catch: Throwable -> L28
            unlock();
            if (isHeldByCurrentThread() == true) goto L17;
            postWriteCleanup();
        L17:
            return true;
        L18:
            unlock();
            if (isHeldByCurrentThread() == true) goto L21;
            postWriteCleanup();
        L21:
            return false;
        L22:
            r4 = r4.getNext();     // Catch: Throwable -> L28
            goto L5
        L24:
            unlock();
            if (isHeldByCurrentThread() == true) goto L27;
            postWriteCleanup();
        L27:
            return false;
        L28:
            th = move-exception;
            unlock();
            if (isHeldByCurrentThread() == true) goto L32;
            postWriteCleanup();
        L32:
            throw th;
        }

        boolean clearValue(K r9, int r10, ValueReference<K, V> r11) {
            lock();
            AtomicReferenceArray<ReferenceEntry<K, V>> r0 = this.table;     // Catch: Throwable -> L20
            int r1 = (r0.length() - 1) & r10;     // Catch: Throwable -> L20
            ReferenceEntry<K, V> r3 = r0.get(r1);     // Catch: Throwable -> L20
            ReferenceEntry<K, V> r4 = r3;
        L5:
            if (r4 == null) goto L16;
            K r6 = r4.getKey();     // Catch: Throwable -> L20
            if (r4.getHash() != r10) goto L18;
            if (r6 == null) goto L18;
            if (this.map.keyEquivalence.equivalent(r9, r6) == false) goto L18;
            if (r4.getValueReference() != r11) goto L16;
            r0.set(r1, removeFromChain(r3, r4));     // Catch: Throwable -> L20
            unlock();
            postWriteCleanup();
            return true;
        L18:
            r4 = r4.getNext();     // Catch: Throwable -> L20
        L16:
            unlock();
            postWriteCleanup();
            return false;
        L20:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        boolean removeEntry(ReferenceEntry<K, V> r7, int r8, MapMaker.RemovalCause r9) {
            AtomicReferenceArray<ReferenceEntry<K, V>> r0 = this.table;
            int r1 = (r0.length() - 1) & r8;
            ReferenceEntry<K, V> r3 = r0.get(r1);
            ReferenceEntry<K, V> r4 = r3;
        L3:
            if (r4 == null) goto L8;
            if (r4 == r7) goto L5;
            r4 = r4.getNext();
            goto L3
        L5:
            this.modCount++;
            enqueueNotification(r4.getKey(), r8, r4.getValueReference().get(), r9);
            ReferenceEntry<K, V> r10 = removeFromChain(r3, r4);
            int r11 = this.count - 1;
            r0.set(r1, r10);
            this.count = r11;
            return true;
        L8:
            return false;
        }

        boolean isCollected(ValueReference<K, V> r2) {
            if (r2.isComputingReference() == false) goto L6;
            return false;
        L6:
            if (r2.get() != null) goto L9;
            return true;
        L9:
            return false;
        }

        V getLiveValue(ReferenceEntry<K, V> r4) {
            if (r4.getKey() != null) goto L6;
            tryDrainReferenceQueues();
            return null;
        L6:
            V r0 = r4.getValueReference().get();
            if (r0 != null) goto L11;
            tryDrainReferenceQueues();
            return null;
        L11:
            if (this.map.expires() == true) goto L13;
        L16:
            return r0;
        L13:
            if (this.map.isExpired(r4) == false) goto L16;
            tryExpireEntries();
            return null;
        }

        void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) != 0) goto L6;
            runCleanup();
            return;
        }

        void preWriteCleanup() {
            runLockedCleanup();
        }

        void postWriteCleanup() {
            runUnlockedCleanup();
        }

        void runCleanup() {
            runLockedCleanup();
            runUnlockedCleanup();
        }

        void runLockedCleanup() {
            if (tryLock() == true) goto L10;
            return;
        L10:
            drainReferenceQueues();     // Catch: Throwable -> L6
            expireEntries();     // Catch: Throwable -> L6
            this.readCount.set(0);     // Catch: Throwable -> L6
            unlock();
            return;
        L6:
            th = move-exception;
            unlock();
            throw th;
        }

        void runUnlockedCleanup() {
            if (isHeldByCurrentThread() == true) goto L6;
            this.map.processPendingNotifications();
            return;
        }
    }

    private static final class SerializationProxy<K, V> extends AbstractSerializationProxy<K, V> {
        private static final long serialVersionUID = 3;

        SerializationProxy(Strength r1, Strength r2, Equivalence<Object> r3, Equivalence<Object> r4, long r5, long r7, int r9, int r10, MapMaker.RemovalListener<? super K, ? super V> r11, ConcurrentMap<K, V> r12) {
            super(r1, r2, r3, r4, r5, r7, r9, r10, r11, r12);
        }

        private void writeObject(ObjectOutputStream r1) throws IOException {
            r1.defaultWriteObject();
            writeMapTo(r1);
        }

        private void readObject(ObjectInputStream r2) throws IOException, ClassNotFoundException {
            r2.defaultReadObject();
            this.delegate = readMapMaker(r2).makeMap();
            readEntries(r2);
        }

        private Object readResolve() {
            return this.delegate;
        }
    }

    static class SoftEntry<K, V> extends SoftReference<K> implements ReferenceEntry<K, V> {
        final int hash;
        final ReferenceEntry<K, V> next;
        volatile ValueReference<K, V> valueReference;

        SoftEntry(ReferenceQueue<K> r1, K r2, int r3, @Nullable ReferenceEntry<K, V> r4) {
            super(r2, r1);
            this.valueReference = MapMakerInternalMap.unset();
            this.hash = r3;
            this.next = r4;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public K getKey() {
            return get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public long getExpirationTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setExpirationTime(long r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<K, V> getNextExpirable() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setNextExpirable(ReferenceEntry<K, V> r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousExpirable() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setPreviousExpirable(ReferenceEntry<K, V> r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<K, V> getNextEvictable() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setNextEvictable(ReferenceEntry<K, V> r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousEvictable() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setPreviousEvictable(ReferenceEntry<K, V> r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ValueReference<K, V> getValueReference() {
            return this.valueReference;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setValueReference(ValueReference<K, V> r2) {
            ValueReference<K, V> r0 = this.valueReference;
            this.valueReference = r2;
            r0.clear(r2);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public int getHash() {
            return this.hash;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<K, V> getNext() {
            return this.next;
        }
    }

    static final class SoftEvictableEntry<K, V> extends SoftEntry<K, V> implements ReferenceEntry<K, V> {
        ReferenceEntry<K, V> nextEvictable;
        ReferenceEntry<K, V> previousEvictable;

        SoftEvictableEntry(ReferenceQueue<K> r1, K r2, int r3, @Nullable ReferenceEntry<K, V> r4) {
            super(r1, r2, r3, r4);
            this.nextEvictable = MapMakerInternalMap.nullEntry();
            this.previousEvictable = MapMakerInternalMap.nullEntry();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.SoftEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<K, V> getNextEvictable() {
            return this.nextEvictable;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.SoftEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setNextEvictable(ReferenceEntry<K, V> r1) {
            this.nextEvictable = r1;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.SoftEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousEvictable() {
            return this.previousEvictable;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.SoftEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setPreviousEvictable(ReferenceEntry<K, V> r1) {
            this.previousEvictable = r1;
        }
    }

    static final class SoftExpirableEntry<K, V> extends SoftEntry<K, V> implements ReferenceEntry<K, V> {
        ReferenceEntry<K, V> nextExpirable;
        ReferenceEntry<K, V> previousExpirable;
        volatile long time;

        SoftExpirableEntry(ReferenceQueue<K> r1, K r2, int r3, @Nullable ReferenceEntry<K, V> r4) {
            super(r1, r2, r3, r4);
            this.time = Long.MAX_VALUE;
            this.nextExpirable = MapMakerInternalMap.nullEntry();
            this.previousExpirable = MapMakerInternalMap.nullEntry();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.SoftEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public long getExpirationTime() {
            return this.time;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.SoftEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setExpirationTime(long r1) {
            this.time = r1;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.SoftEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<K, V> getNextExpirable() {
            return this.nextExpirable;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.SoftEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setNextExpirable(ReferenceEntry<K, V> r1) {
            this.nextExpirable = r1;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.SoftEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousExpirable() {
            return this.previousExpirable;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.SoftEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setPreviousExpirable(ReferenceEntry<K, V> r1) {
            this.previousExpirable = r1;
        }
    }

    static final class SoftExpirableEvictableEntry<K, V> extends SoftEntry<K, V> implements ReferenceEntry<K, V> {
        ReferenceEntry<K, V> nextEvictable;
        ReferenceEntry<K, V> nextExpirable;
        ReferenceEntry<K, V> previousEvictable;
        ReferenceEntry<K, V> previousExpirable;
        volatile long time;

        SoftExpirableEvictableEntry(ReferenceQueue<K> r1, K r2, int r3, @Nullable ReferenceEntry<K, V> r4) {
            super(r1, r2, r3, r4);
            this.time = Long.MAX_VALUE;
            this.nextExpirable = MapMakerInternalMap.nullEntry();
            this.previousExpirable = MapMakerInternalMap.nullEntry();
            this.nextEvictable = MapMakerInternalMap.nullEntry();
            this.previousEvictable = MapMakerInternalMap.nullEntry();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.SoftEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public long getExpirationTime() {
            return this.time;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.SoftEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setExpirationTime(long r1) {
            this.time = r1;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.SoftEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<K, V> getNextExpirable() {
            return this.nextExpirable;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.SoftEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setNextExpirable(ReferenceEntry<K, V> r1) {
            this.nextExpirable = r1;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.SoftEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousExpirable() {
            return this.previousExpirable;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.SoftEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setPreviousExpirable(ReferenceEntry<K, V> r1) {
            this.previousExpirable = r1;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.SoftEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<K, V> getNextEvictable() {
            return this.nextEvictable;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.SoftEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setNextEvictable(ReferenceEntry<K, V> r1) {
            this.nextEvictable = r1;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.SoftEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousEvictable() {
            return this.previousEvictable;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.SoftEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setPreviousEvictable(ReferenceEntry<K, V> r1) {
            this.previousEvictable = r1;
        }
    }

    static final class SoftValueReference<K, V> extends SoftReference<V> implements ValueReference<K, V> {
        final ReferenceEntry<K, V> entry;

        @Override // com.google.common.collect.MapMakerInternalMap.ValueReference
        public boolean isComputingReference() {
            return false;
        }

        SoftValueReference(ReferenceQueue<V> r1, V r2, ReferenceEntry<K, V> r3) {
            super(r2, r1);
            this.entry = r3;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ValueReference
        public ReferenceEntry<K, V> getEntry() {
            return this.entry;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ValueReference
        public void clear(ValueReference<K, V> r1) {
            clear();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ValueReference
        public ValueReference<K, V> copyFor(ReferenceQueue<V> r1, V r2, ReferenceEntry<K, V> r3) {
            return new SoftValueReference(r1, r2, r3);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ValueReference
        public V waitForValue() {
            return get();
        }
    }

    static abstract enum Strength extends Enum<Strength> {
        private static final /* synthetic */ Strength[] $VALUES = null;
        public static final Strength SOFT = null;
        public static final Strength STRONG = null;
        public static final Strength WEAK = null;

        abstract Equivalence<Object> defaultEquivalence();

        abstract <K, V> ValueReference<K, V> referenceValue(Segment<K, V> r1, ReferenceEntry<K, V> r2, V r3);

        private Strength(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ Strength(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        public static Strength valueOf(String r1) {
            return (Strength) Enum.valueOf(Strength.class, r1);
        }

        public static Strength[] values() {
            return (Strength[]) $VALUES.clone();
        }

        static {
            final String r1 = "STRONG";
            final int r2 = 0;
            Strength r0 = new AnonymousClass1(r1, r2);
            STRONG = r0;
            final String r3 = "SOFT";
            final int r4 = 1;
            Strength r5 = new AnonymousClass2(r3, r4);
            SOFT = r5;
            final String r6 = "WEAK";
            final int r7 = 2;
            Strength r8 = new AnonymousClass3(r6, r7);
            WEAK = r8;
            $VALUES = new Strength[]{r0, r5, r8};
        }
    }

    static class StrongEntry<K, V> implements ReferenceEntry<K, V> {
        final int hash;
        final K key;
        final ReferenceEntry<K, V> next;
        volatile ValueReference<K, V> valueReference;

        StrongEntry(K r2, int r3, @Nullable ReferenceEntry<K, V> r4) {
            this.valueReference = MapMakerInternalMap.unset();
            this.key = r2;
            this.hash = r3;
            this.next = r4;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public K getKey() {
            return this.key;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public long getExpirationTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setExpirationTime(long r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<K, V> getNextExpirable() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setNextExpirable(ReferenceEntry<K, V> r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousExpirable() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setPreviousExpirable(ReferenceEntry<K, V> r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<K, V> getNextEvictable() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setNextEvictable(ReferenceEntry<K, V> r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousEvictable() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setPreviousEvictable(ReferenceEntry<K, V> r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ValueReference<K, V> getValueReference() {
            return this.valueReference;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setValueReference(ValueReference<K, V> r2) {
            ValueReference<K, V> r0 = this.valueReference;
            this.valueReference = r2;
            r0.clear(r2);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public int getHash() {
            return this.hash;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<K, V> getNext() {
            return this.next;
        }
    }

    static final class StrongEvictableEntry<K, V> extends StrongEntry<K, V> implements ReferenceEntry<K, V> {
        ReferenceEntry<K, V> nextEvictable;
        ReferenceEntry<K, V> previousEvictable;

        StrongEvictableEntry(K r1, int r2, @Nullable ReferenceEntry<K, V> r3) {
            super(r1, r2, r3);
            this.nextEvictable = MapMakerInternalMap.nullEntry();
            this.previousEvictable = MapMakerInternalMap.nullEntry();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.StrongEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<K, V> getNextEvictable() {
            return this.nextEvictable;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.StrongEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setNextEvictable(ReferenceEntry<K, V> r1) {
            this.nextEvictable = r1;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.StrongEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousEvictable() {
            return this.previousEvictable;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.StrongEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setPreviousEvictable(ReferenceEntry<K, V> r1) {
            this.previousEvictable = r1;
        }
    }

    static final class StrongExpirableEntry<K, V> extends StrongEntry<K, V> implements ReferenceEntry<K, V> {
        ReferenceEntry<K, V> nextExpirable;
        ReferenceEntry<K, V> previousExpirable;
        volatile long time;

        StrongExpirableEntry(K r1, int r2, @Nullable ReferenceEntry<K, V> r3) {
            super(r1, r2, r3);
            this.time = Long.MAX_VALUE;
            this.nextExpirable = MapMakerInternalMap.nullEntry();
            this.previousExpirable = MapMakerInternalMap.nullEntry();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.StrongEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public long getExpirationTime() {
            return this.time;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.StrongEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setExpirationTime(long r1) {
            this.time = r1;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.StrongEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<K, V> getNextExpirable() {
            return this.nextExpirable;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.StrongEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setNextExpirable(ReferenceEntry<K, V> r1) {
            this.nextExpirable = r1;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.StrongEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousExpirable() {
            return this.previousExpirable;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.StrongEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setPreviousExpirable(ReferenceEntry<K, V> r1) {
            this.previousExpirable = r1;
        }
    }

    static final class StrongExpirableEvictableEntry<K, V> extends StrongEntry<K, V> implements ReferenceEntry<K, V> {
        ReferenceEntry<K, V> nextEvictable;
        ReferenceEntry<K, V> nextExpirable;
        ReferenceEntry<K, V> previousEvictable;
        ReferenceEntry<K, V> previousExpirable;
        volatile long time;

        StrongExpirableEvictableEntry(K r1, int r2, @Nullable ReferenceEntry<K, V> r3) {
            super(r1, r2, r3);
            this.time = Long.MAX_VALUE;
            this.nextExpirable = MapMakerInternalMap.nullEntry();
            this.previousExpirable = MapMakerInternalMap.nullEntry();
            this.nextEvictable = MapMakerInternalMap.nullEntry();
            this.previousEvictable = MapMakerInternalMap.nullEntry();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.StrongEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public long getExpirationTime() {
            return this.time;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.StrongEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setExpirationTime(long r1) {
            this.time = r1;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.StrongEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<K, V> getNextExpirable() {
            return this.nextExpirable;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.StrongEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setNextExpirable(ReferenceEntry<K, V> r1) {
            this.nextExpirable = r1;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.StrongEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousExpirable() {
            return this.previousExpirable;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.StrongEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setPreviousExpirable(ReferenceEntry<K, V> r1) {
            this.previousExpirable = r1;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.StrongEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<K, V> getNextEvictable() {
            return this.nextEvictable;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.StrongEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setNextEvictable(ReferenceEntry<K, V> r1) {
            this.nextEvictable = r1;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.StrongEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousEvictable() {
            return this.previousEvictable;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.StrongEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setPreviousEvictable(ReferenceEntry<K, V> r1) {
            this.previousEvictable = r1;
        }
    }

    static final class StrongValueReference<K, V> implements ValueReference<K, V> {
        final V referent;

        @Override // com.google.common.collect.MapMakerInternalMap.ValueReference
        public void clear(ValueReference<K, V> r1) {
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ValueReference
        public ValueReference<K, V> copyFor(ReferenceQueue<V> r1, V r2, ReferenceEntry<K, V> r3) {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ValueReference
        public ReferenceEntry<K, V> getEntry() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ValueReference
        public boolean isComputingReference() {
            return false;
        }

        StrongValueReference(V r1) {
            this.referent = r1;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ValueReference
        public V get() {
            return this.referent;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ValueReference
        public V waitForValue() {
            return get();
        }
    }

    final class ValueIterator extends MapMakerInternalMap<K, V>.HashIterator<V> {
        final /* synthetic */ MapMakerInternalMap this$0;

        ValueIterator(MapMakerInternalMap r1) {
            this.this$0 = r1;
            super(r1);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.HashIterator, java.util.Iterator
        public V next() {
            return nextEntry().getValue();
        }
    }

    interface ValueReference<K, V> {
        void clear(@Nullable ValueReference<K, V> r1);

        ValueReference<K, V> copyFor(ReferenceQueue<V> r1, @Nullable V r2, ReferenceEntry<K, V> r3);

        V get();

        ReferenceEntry<K, V> getEntry();

        boolean isComputingReference();

        V waitForValue() throws ExecutionException;
    }

    final class Values extends AbstractCollection<V> {
        final /* synthetic */ MapMakerInternalMap this$0;

        Values(MapMakerInternalMap r1) {
            this.this$0 = r1;
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
        public boolean isEmpty() {
            return this.this$0.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object r1) {
            return this.this$0.containsValue(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.this$0.clear();
        }
    }

    static class WeakEntry<K, V> extends WeakReference<K> implements ReferenceEntry<K, V> {
        final int hash;
        final ReferenceEntry<K, V> next;
        volatile ValueReference<K, V> valueReference;

        WeakEntry(ReferenceQueue<K> r1, K r2, int r3, @Nullable ReferenceEntry<K, V> r4) {
            super(r2, r1);
            this.valueReference = MapMakerInternalMap.unset();
            this.hash = r3;
            this.next = r4;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public K getKey() {
            return (K) get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public long getExpirationTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setExpirationTime(long r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<K, V> getNextExpirable() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setNextExpirable(ReferenceEntry<K, V> r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousExpirable() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setPreviousExpirable(ReferenceEntry<K, V> r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<K, V> getNextEvictable() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setNextEvictable(ReferenceEntry<K, V> r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousEvictable() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setPreviousEvictable(ReferenceEntry<K, V> r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ValueReference<K, V> getValueReference() {
            return this.valueReference;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setValueReference(ValueReference<K, V> r2) {
            ValueReference<K, V> r0 = this.valueReference;
            this.valueReference = r2;
            r0.clear(r2);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public int getHash() {
            return this.hash;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<K, V> getNext() {
            return this.next;
        }
    }

    static final class WeakEvictableEntry<K, V> extends WeakEntry<K, V> implements ReferenceEntry<K, V> {
        ReferenceEntry<K, V> nextEvictable;
        ReferenceEntry<K, V> previousEvictable;

        WeakEvictableEntry(ReferenceQueue<K> r1, K r2, int r3, @Nullable ReferenceEntry<K, V> r4) {
            super(r1, r2, r3, r4);
            this.nextEvictable = MapMakerInternalMap.nullEntry();
            this.previousEvictable = MapMakerInternalMap.nullEntry();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<K, V> getNextEvictable() {
            return this.nextEvictable;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setNextEvictable(ReferenceEntry<K, V> r1) {
            this.nextEvictable = r1;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousEvictable() {
            return this.previousEvictable;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setPreviousEvictable(ReferenceEntry<K, V> r1) {
            this.previousEvictable = r1;
        }
    }

    static final class WeakExpirableEntry<K, V> extends WeakEntry<K, V> implements ReferenceEntry<K, V> {
        ReferenceEntry<K, V> nextExpirable;
        ReferenceEntry<K, V> previousExpirable;
        volatile long time;

        WeakExpirableEntry(ReferenceQueue<K> r1, K r2, int r3, @Nullable ReferenceEntry<K, V> r4) {
            super(r1, r2, r3, r4);
            this.time = Long.MAX_VALUE;
            this.nextExpirable = MapMakerInternalMap.nullEntry();
            this.previousExpirable = MapMakerInternalMap.nullEntry();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public long getExpirationTime() {
            return this.time;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setExpirationTime(long r1) {
            this.time = r1;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<K, V> getNextExpirable() {
            return this.nextExpirable;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setNextExpirable(ReferenceEntry<K, V> r1) {
            this.nextExpirable = r1;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousExpirable() {
            return this.previousExpirable;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setPreviousExpirable(ReferenceEntry<K, V> r1) {
            this.previousExpirable = r1;
        }
    }

    static final class WeakExpirableEvictableEntry<K, V> extends WeakEntry<K, V> implements ReferenceEntry<K, V> {
        ReferenceEntry<K, V> nextEvictable;
        ReferenceEntry<K, V> nextExpirable;
        ReferenceEntry<K, V> previousEvictable;
        ReferenceEntry<K, V> previousExpirable;
        volatile long time;

        WeakExpirableEvictableEntry(ReferenceQueue<K> r1, K r2, int r3, @Nullable ReferenceEntry<K, V> r4) {
            super(r1, r2, r3, r4);
            this.time = Long.MAX_VALUE;
            this.nextExpirable = MapMakerInternalMap.nullEntry();
            this.previousExpirable = MapMakerInternalMap.nullEntry();
            this.nextEvictable = MapMakerInternalMap.nullEntry();
            this.previousEvictable = MapMakerInternalMap.nullEntry();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public long getExpirationTime() {
            return this.time;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setExpirationTime(long r1) {
            this.time = r1;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<K, V> getNextExpirable() {
            return this.nextExpirable;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setNextExpirable(ReferenceEntry<K, V> r1) {
            this.nextExpirable = r1;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousExpirable() {
            return this.previousExpirable;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setPreviousExpirable(ReferenceEntry<K, V> r1) {
            this.previousExpirable = r1;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<K, V> getNextEvictable() {
            return this.nextEvictable;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setNextEvictable(ReferenceEntry<K, V> r1) {
            this.nextEvictable = r1;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousEvictable() {
            return this.previousEvictable;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakEntry, com.google.common.collect.MapMakerInternalMap.ReferenceEntry
        public void setPreviousEvictable(ReferenceEntry<K, V> r1) {
            this.previousEvictable = r1;
        }
    }

    static final class WeakValueReference<K, V> extends WeakReference<V> implements ValueReference<K, V> {
        final ReferenceEntry<K, V> entry;

        @Override // com.google.common.collect.MapMakerInternalMap.ValueReference
        public boolean isComputingReference() {
            return false;
        }

        WeakValueReference(ReferenceQueue<V> r1, V r2, ReferenceEntry<K, V> r3) {
            super(r2, r1);
            this.entry = r3;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ValueReference
        public ReferenceEntry<K, V> getEntry() {
            return this.entry;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ValueReference
        public void clear(ValueReference<K, V> r1) {
            clear();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ValueReference
        public ValueReference<K, V> copyFor(ReferenceQueue<V> r1, V r2, ReferenceEntry<K, V> r3) {
            return new WeakValueReference(r1, r2, r3);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ValueReference
        public V waitForValue() {
            return get();
        }
    }

    final class WriteThroughEntry extends AbstractMapEntry<K, V> {
        final K key;
        final /* synthetic */ MapMakerInternalMap this$0;
        V value;

        WriteThroughEntry(MapMakerInternalMap r1, K r2, V r3) {
            this.this$0 = r1;
            this.key = r2;
            this.value = r3;
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
        public boolean equals(@Nullable Object r4) {
            if ((r4 instanceof Map.Entry) == false) goto L10;
            Map.Entry r5 = (Map.Entry) r4;
            if (this.key.equals(r5.getKey()) == true) goto L7;
            return false;
        L7:
            if (this.value.equals(r5.getValue()) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public int hashCode() {
            int r0 = this.key.hashCode();
            return this.value.hashCode() ^ r0;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V setValue(V r3) {
            V r0 = (V) this.this$0.put(this.key, r3);
            this.value = r3;
            return r0;
        }
    }

    static int rehash(int r2) {
        int r3 = r2 + ((r2 << 15) ^ (-12931));
        int r4 = r3 ^ (r3 >>> 10);
        int r5 = r4 + (r4 << 3);
        int r6 = r5 ^ (r5 >>> 6);
        int r7 = r6 + ((r6 << 2) + (r6 << 14));
        return r7 ^ (r7 >>> 16);
    }

    static {
        logger = Logger.getLogger(MapMakerInternalMap.class.getName());
        UNSET = new AnonymousClass1();
        DISCARDING_QUEUE = new AnonymousClass2();
    }

    MapMakerInternalMap(MapMaker r7) {
        this.concurrencyLevel = Math.min(r7.getConcurrencyLevel(), 65536);
        Strength r0 = r7.getKeyStrength();
        this.keyStrength = r0;
        Strength r1 = r7.getValueStrength();
        this.valueStrength = r1;
        this.keyEquivalence = r7.getKeyEquivalence();
        this.valueEquivalence = r1.defaultEquivalence();
        int r2 = r7.maximumSize;
        this.maximumSize = r2;
        this.expireAfterAccessNanos = r7.getExpireAfterAccessNanos();
        this.expireAfterWriteNanos = r7.getExpireAfterWriteNanos();
        this.entryFactory = EntryFactory.getFactory(r0, expires(), evictsBySize());
        this.ticker = r7.getTicker();
        MapMaker.RemovalListener<K, V> r3 = r7.getRemovalListener();
        this.removalListener = r3;
        if (r3 != GenericMapMaker.NullListener.INSTANCE) goto L5;
        Queue<MapMaker.RemovalNotification<K, V>> r4 = discardingQueue();
    L6:
        this.removalNotificationQueue = r4;
        int r8 = Math.min(r7.getInitialCapacity(), 1073741824);
        if (evictsBySize() == false) goto L9;
        r8 = Math.min(r8, r2);
    L9:
        int r5 = 0;
        int r6 = 0;
        int r9 = 1;
    L11:
        if (r9 >= this.concurrencyLevel) goto L17;
        if (evictsBySize() == false) goto L16;
        if ((r9 * 2) > this.maximumSize) goto L17;
    L16:
        r6 = r6 + 1;
        r9 = r9 << 1;
    L17:
        this.segmentShift = 32 - r6;
        this.segmentMask = r9 - 1;
        this.segments = newSegmentArray(r9);
        int r10 = r8 / r9;
        if ((r10 * r9) >= r8) goto L20;
        r10 = r10 + 1;
    L20:
        int r11 = 1;
    L21:
        if (r11 >= r10) goto L24;
        r11 = r11 << 1;
        goto L21
    L24:
        if (evictsBySize() == false) goto L31;
        int r12 = this.maximumSize;
        int r13 = (r12 / r9) + 1;
        int r14 = r12 % r9;
    L26:
        Segment<K, V>[] r15 = this.segments;
        if (r5 >= r15.length) goto L34;
        if (r5 != r14) goto L30;
        r13 = r13 - 1;
    L30:
        r15[r5] = createSegment(r11, r13);
        r5 = r5 + 1;
        goto L26
    L34:
        return;
    L31:
        Segment<K, V>[] r16 = this.segments;
        if (r5 >= r16.length) goto L44;
        r16[r5] = createSegment(r11, -1);
        r5 = r5 + 1;
        goto L31
    L44:
        return;
    L5:
        r4 = new ConcurrentLinkedQueue();
        goto L6
    }

    boolean evictsBySize() {
        if (this.maximumSize == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    boolean expires() {
        if (expiresAfterWrite() == false) goto L5;
    L8:
        return true;
    L5:
        if (expiresAfterAccess() == true) goto L8;
        return false;
    }

    boolean expiresAfterWrite() {
        if (this.expireAfterWriteNanos <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean expiresAfterAccess() {
        if (this.expireAfterAccessNanos <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean usesKeyReferences() {
        if (this.keyStrength == Strength.STRONG) goto L5;
        return true;
    L5:
        return false;
    }

    boolean usesValueReferences() {
        if (this.valueStrength == Strength.STRONG) goto L5;
        return true;
    L5:
        return false;
    }

    static <K, V> ValueReference<K, V> unset() {
        return (ValueReference<K, V>) UNSET;
    }

    static <K, V> ReferenceEntry<K, V> nullEntry() {
        return NullEntry.INSTANCE;
    }

    static <E> Queue<E> discardingQueue() {
        return (Queue<E>) DISCARDING_QUEUE;
    }

    ReferenceEntry<K, V> newEntry(K r1, int r2, @Nullable ReferenceEntry<K, V> r3) {
        return segmentFor(r2).newEntry(r1, r2, r3);
    }

    ReferenceEntry<K, V> copyEntry(ReferenceEntry<K, V> r2, ReferenceEntry<K, V> r3) {
        return segmentFor(r2.getHash()).copyEntry(r2, r3);
    }

    ValueReference<K, V> newValueReference(ReferenceEntry<K, V> r3, V r4) {
        int r0 = r3.getHash();
        return this.valueStrength.referenceValue(segmentFor(r0), r3, r4);
    }

    int hash(Object r1) {
        return rehash(this.keyEquivalence.hash(r1));
    }

    void reclaimValue(ValueReference<K, V> r3) {
        ReferenceEntry<K, V> r0 = r3.getEntry();
        int r1 = r0.getHash();
        segmentFor(r1).reclaimValue(r0.getKey(), r1, r3);
    }

    void reclaimKey(ReferenceEntry<K, V> r2) {
        int r0 = r2.getHash();
        segmentFor(r0).reclaimKey(r2, r0);
    }

    boolean isLive(ReferenceEntry<K, V> r2) {
        if (segmentFor(r2.getHash()).getLiveValue(r2) == null) goto L5;
        return true;
    L5:
        return false;
    }

    Segment<K, V> segmentFor(int r3) {
        Segment<K, V>[] r0 = this.segments;
        int r4 = r3 >>> this.segmentShift;
        return r0[this.segmentMask & r4];
    }

    Segment<K, V> createSegment(int r2, int r3) {
        return new Segment(this, r2, r3);
    }

    V getLiveValue(ReferenceEntry<K, V> r4) {
        if (r4.getKey() != null) goto L5;
        return null;
    L5:
        V r0 = r4.getValueReference().get();
        if (r0 != null) goto L9;
        return null;
    L9:
        if (expires() == true) goto L11;
    L13:
        return r0;
    L11:
        if (isExpired(r4) == false) goto L13;
        return null;
    }

    boolean isExpired(ReferenceEntry<K, V> r3) {
        return isExpired(r3, this.ticker.read());
    }

    boolean isExpired(ReferenceEntry<K, V> r1, long r2) {
        if ((r2 - r1.getExpirationTime()) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    static <K, V> void connectExpirables(ReferenceEntry<K, V> r0, ReferenceEntry<K, V> r1) {
        r0.setNextExpirable(r1);
        r1.setPreviousExpirable(r0);
    }

    static <K, V> void nullifyExpirable(ReferenceEntry<K, V> r1) {
        ReferenceEntry<K, V> r0 = nullEntry();
        r1.setNextExpirable(r0);
        r1.setPreviousExpirable(r0);
    }

    void processPendingNotifications() {
    L2:
        MapMaker.RemovalNotification<K, V> r0 = this.removalNotificationQueue.poll();
        if (r0 == null) goto L8;
        this.removalListener.onRemoval(r0);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        logger.log(Level.WARNING, "Exception thrown by removal listener", e);
        goto L2
    }

    static <K, V> void connectEvictables(ReferenceEntry<K, V> r0, ReferenceEntry<K, V> r1) {
        r0.setNextEvictable(r1);
        r1.setPreviousEvictable(r0);
    }

    static <K, V> void nullifyEvictable(ReferenceEntry<K, V> r1) {
        ReferenceEntry<K, V> r0 = nullEntry();
        r1.setNextEvictable(r0);
        r1.setPreviousEvictable(r0);
    }

    final Segment<K, V>[] newSegmentArray(int r1) {
        return new Segment[r1];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        Segment<K, V>[] r8 = this.segments;
        long r4 = 0;
        int r3 = 0;
    L4:
        if (r3 >= r8.length) goto L10;
        if (r8[r3].count != 0) goto L7;
        r4 = r4 + ((long) r8[r3].modCount);
        r3 = r3 + 1;
        goto L4
    L7:
        return false;
    L10:
        if (r4 == 0) goto L21;
        int r5 = 0;
    L13:
        if (r5 >= r8.length) goto L19;
        if (r8[r5].count != 0) goto L16;
        r4 = r4 - ((long) r8[r5].modCount);
        r5 = r5 + 1;
        goto L13
    L16:
        return false;
    L19:
        if (r4 == 0) goto L27;
        return false;
    L27:
        return true;
    L21:
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        Segment<K, V>[] r5 = this.segments;
        long r0 = 0;
        int r2 = 0;
    L4:
        if (r2 >= r5.length) goto L7;
        r0 = r0 + ((long) r5[r2].count);
        r2 = r2 + 1;
        goto L4
    L7:
        return Ints.saturatedCast(r0);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(@Nullable Object r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        int r0 = hash(r2);
        return segmentFor(r0).get(r2, r0);
    }

    ReferenceEntry<K, V> getEntry(@Nullable Object r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        int r0 = hash(r2);
        return segmentFor(r0).getEntry(r2, r0);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@Nullable Object r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        int r0 = hash(r2);
        return segmentFor(r0).containsKey(r2, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [int] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [int] */
    /* JADX WARN: Type inference failed for: r13v3 */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@Nullable Object r17) {
        boolean r2 = false;
        if (r17 != null) goto L5;
        return false;
    L5:
        Segment<K, V>[] r3 = this.segments;
        long r4 = -1;
        int r6 = 0;
    L7:
        if (r6 >= 3) goto L29;
        int r7 = r3.length;
        long r8 = 0;
        ?? r10 = r2;
    L9:
        if (r10 >= r7) goto L25;
        Segment<K, V> r11 = r3[r10];
        int r12 = r11.count;
        AtomicReferenceArray<ReferenceEntry<K, V>> r13 = r11.table;
        ?? r14 = r2;
    L12:
        if (r14 >= r13.length()) goto L23;
        ReferenceEntry<K, V> r15 = r13.get(r14);
    L14:
        if (r15 == null) goto L22;
        V r16 = r11.getLiveValue(r15);
        if (r16 == null) goto L21;
        if (this.valueEquivalence.equivalent(r17, r16) == false) goto L21;
        return true;
    L21:
        r15 = r15.getNext();
        goto L14
    L22:
        r14 = r14 + 1;
        goto L12
    L23:
        r8 = r8 + ((long) r11.modCount);
        r2 = false;
        r10 = r10 + 1;
        goto L9
    L25:
        if (r8 == r4) goto L26;
        r6 = r6 + 1;
        r4 = r8;
        r2 = false;
        goto L7
    L26:
        return false;
    L29:
        return r2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K r3, V r4) {
        Preconditions.checkNotNull(r3);
        Preconditions.checkNotNull(r4);
        int r0 = hash(r3);
        return segmentFor(r0).put(r3, r0, r4, false);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K r3, V r4) {
        Preconditions.checkNotNull(r3);
        Preconditions.checkNotNull(r4);
        int r0 = hash(r3);
        return segmentFor(r0).put(r3, r0, r4, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> r3) {
        Iterator<Map.Entry<? extends K, ? extends V>> r4 = r3.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Map.Entry<? extends K, ? extends V> r0 = r4.next();
        put(r0.getKey(), r0.getValue());
        goto L4
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(@Nullable Object r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        int r0 = hash(r2);
        return segmentFor(r0).remove(r2, r0);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(@Nullable Object r2, @Nullable Object r3) {
        if (r2 == null) goto L7;
        if (r3 == null) goto L9;
        int r0 = hash(r2);
        return segmentFor(r0).remove(r2, r0, r3);
    L9:
        return false;
    L7:
        return false;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K r2, @Nullable V r3, V r4) {
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r4);
        if (r3 != null) goto L6;
        return false;
    L6:
        int r0 = hash(r2);
        return segmentFor(r0).replace(r2, r0, r3, r4);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K r2, V r3) {
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r3);
        int r0 = hash(r2);
        return segmentFor(r0).replace(r2, r0, r3);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Segment<K, V>[] r3 = this.segments;
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3[r1].clear();
        r1 = r1 + 1;
        goto L3
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> r0 = this.keySet;
        if (r0 != null) goto L7;
        KeySet r1 = new KeySet(this);
        this.keySet = r1;
        return r1;
    L7:
        return r0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> r0 = this.values;
        if (r0 != null) goto L7;
        Values r1 = new Values(this);
        this.values = r1;
        return r1;
    L7:
        return r0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> r0 = this.entrySet;
        if (r0 != null) goto L7;
        EntrySet r1 = new EntrySet(this);
        this.entrySet = r1;
        return r1;
    L7:
        return r0;
    }

    Object writeReplace() {
        return new SerializationProxy(this.keyStrength, this.valueStrength, this.keyEquivalence, this.valueEquivalence, this.expireAfterWriteNanos, this.expireAfterAccessNanos, this.maximumSize, this.concurrencyLevel, this.removalListener, this);
    }
}
