package com.google.common.cache;

import com.bytedance.librarian.LibrarianImpl;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Equivalence;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Ticker;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;
import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.common.util.concurrent.Uninterruptibles;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.google.j2objc.annotations.Weak;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
class LocalCache<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V> {
    static final int CONTAINS_VALUE_RETRIES = 3;
    static final Queue<?> DISCARDING_QUEUE = null;
    static final int DRAIN_MAX = 16;
    static final int DRAIN_THRESHOLD = 63;
    static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MAX_SEGMENTS = 65536;
    static final ValueReference<Object, Object> UNSET = null;
    static final Logger logger = null;
    final int concurrencyLevel;

    @NullableDecl
    final CacheLoader<? super K, V> defaultLoader;
    final EntryFactory entryFactory;

    @MonotonicNonNullDecl
    Set<Map.Entry<K, V>> entrySet;
    final long expireAfterAccessNanos;
    final long expireAfterWriteNanos;
    final AbstractCache.StatsCounter globalStatsCounter;
    final Equivalence<Object> keyEquivalence;

    @MonotonicNonNullDecl
    Set<K> keySet;
    final Strength keyStrength;
    final long maxWeight;
    final long refreshNanos;
    final RemovalListener<K, V> removalListener;
    final Queue<RemovalNotification<K, V>> removalNotificationQueue;
    final int segmentMask;
    final int segmentShift;
    final Segment<K, V>[] segments;
    final Ticker ticker;
    final Equivalence<Object> valueEquivalence;
    final Strength valueStrength;

    @MonotonicNonNullDecl
    Collection<V> values;
    final Weigher<K, V> weigher;

    public abstract class AbstractCacheSet<T> extends AbstractSet<T> {

        @Weak
        final ConcurrentMap<?, ?> map;
        final /* synthetic */ LocalCache this$0;

        public AbstractCacheSet(LocalCache r10, ConcurrentMap<?, ?> r11) {
            this.this$0 = r10;
            this.map = r11;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.map.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.map.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.map.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return LocalCache.access$200(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <E> E[] toArray(E[] r10) {
            return (E[]) LocalCache.access$200(this).toArray(r10);
        }
    }

    public static abstract class AbstractReferenceEntry<K, V> implements ReferenceEntry<K, V> {
        public AbstractReferenceEntry() {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public int getHash() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public K getKey() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNext() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ValueReference<K, V> getValueReference() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setAccessTime(long r10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry<K, V> r10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry<K, V> r10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry<K, V> r10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry<K, V> r10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setValueReference(ValueReference<K, V> r10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setWriteTime(long r10) {
            throw new UnsupportedOperationException();
        }
    }

    public static final class AccessQueue<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {
        final ReferenceEntry<K, V> head;

        public AccessQueue() {
            this.head = new AnonymousClass1(this);
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            ReferenceEntry<K, V> r10 = this.head.getNextInAccessQueue();
        L3:
            ReferenceEntry<K, V> r11 = this.head;
            if (r10 == r11) goto L6;
            ReferenceEntry<K, V> r12 = r10.getNextInAccessQueue();
            LocalCache.nullifyAccessOrder(r10);
            r10 = r12;
            goto L3
        L6:
            r11.setNextInAccessQueue(r11);
            ReferenceEntry<K, V> r13 = this.head;
            r13.setPreviousInAccessQueue(r13);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object r10) {
            if (((ReferenceEntry) r10).getNextInAccessQueue() == NullEntry.INSTANCE) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            if (this.head.getNextInAccessQueue() != this.head) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<ReferenceEntry<K, V>> iterator() {
            final ReferenceEntry<K, V> r10 = peek();
            return new AnonymousClass2(this, r10);
        }

        @Override // java.util.Queue
        public /* bridge */ /* synthetic */ boolean offer(Object r10) {
            return offer((ReferenceEntry) r10);
        }

        @Override // java.util.Queue
        public /* bridge */ /* synthetic */ Object peek() {
            return peek();
        }

        @Override // java.util.Queue
        public /* bridge */ /* synthetic */ Object poll() {
            return poll();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object r10) {
            ReferenceEntry r11 = (ReferenceEntry) r10;
            ReferenceEntry<K, V> r12 = r11.getPreviousInAccessQueue();
            ReferenceEntry<K, V> r13 = r11.getNextInAccessQueue();
            LocalCache.connectAccessOrder(r12, r13);
            LocalCache.nullifyAccessOrder(r11);
            if (r13 == NullEntry.INSTANCE) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            ReferenceEntry<K, V> r10 = this.head.getNextInAccessQueue();
            int r11 = 0;
        L4:
            if (r10 == this.head) goto L6;
            r11 = r11 + 1;
            r10 = r10.getNextInAccessQueue();
            goto L4
        L6:
            return r11;
        }

        public boolean offer(ReferenceEntry<K, V> r10) {
            LocalCache.connectAccessOrder(r10.getPreviousInAccessQueue(), r10.getNextInAccessQueue());
            LocalCache.connectAccessOrder(this.head.getPreviousInAccessQueue(), r10);
            LocalCache.connectAccessOrder(r10, this.head);
            return true;
        }

        @Override // java.util.Queue
        public ReferenceEntry<K, V> peek() {
            ReferenceEntry<K, V> r10 = this.head.getNextInAccessQueue();
            if (r10 != this.head) goto L6;
            return null;
        L6:
            return r10;
        }

        @Override // java.util.Queue
        public ReferenceEntry<K, V> poll() {
            ReferenceEntry<K, V> r10 = this.head.getNextInAccessQueue();
            if (r10 != this.head) goto L6;
            return null;
        L6:
            remove(r10);
            return r10;
        }
    }

    public static abstract enum EntryFactory extends Enum<EntryFactory> {
        private static final /* synthetic */ EntryFactory[] $VALUES = null;
        static final int ACCESS_MASK = 1;
        public static final EntryFactory STRONG = null;
        public static final EntryFactory STRONG_ACCESS = null;
        public static final EntryFactory STRONG_ACCESS_WRITE = null;
        public static final EntryFactory STRONG_WRITE = null;
        public static final EntryFactory WEAK = null;
        public static final EntryFactory WEAK_ACCESS = null;
        public static final EntryFactory WEAK_ACCESS_WRITE = null;
        static final int WEAK_MASK = 4;
        public static final EntryFactory WEAK_WRITE = null;
        static final int WRITE_MASK = 2;
        static final EntryFactory[] factories = null;

        static {
            final String r10 = "STRONG";
            final int r11 = 0;
            EntryFactory r12 = new AnonymousClass1(r10, r11);
            STRONG = r12;
            final String r13 = "STRONG_ACCESS";
            final int r14 = 1;
            EntryFactory r15 = new AnonymousClass2(r13, r14);
            STRONG_ACCESS = r15;
            final String r16 = "STRONG_WRITE";
            final int r17 = 2;
            EntryFactory r18 = new AnonymousClass3(r16, r17);
            STRONG_WRITE = r18;
            final String r19 = "STRONG_ACCESS_WRITE";
            final int r20 = 3;
            EntryFactory r21 = new AnonymousClass4(r19, r20);
            STRONG_ACCESS_WRITE = r21;
            final String r22 = "WEAK";
            final int r110 = 4;
            EntryFactory r23 = new AnonymousClass5(r22, r110);
            WEAK = r23;
            final String r111 = "WEAK_ACCESS";
            final int r112 = 5;
            EntryFactory r24 = new AnonymousClass6(r111, r112);
            WEAK_ACCESS = r24;
            final String r113 = "WEAK_WRITE";
            final int r114 = 6;
            EntryFactory r115 = new AnonymousClass7(r113, r114);
            WEAK_WRITE = r115;
            final String r116 = "WEAK_ACCESS_WRITE";
            final int r117 = 7;
            EntryFactory r118 = new AnonymousClass8(r116, r117);
            WEAK_ACCESS_WRITE = r118;
            $VALUES = new EntryFactory[]{r12, r15, r18, r21, r23, r24, r115, r118};
            factories = new EntryFactory[]{r12, r15, r18, r21, r23, r24, r115, r118};
        }

        private EntryFactory(String r10, int r11) {
            super(r10, r11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static EntryFactory getFactory(Strength r10, boolean r11, boolean r12) {
            int r13 = 0;
            if (r10 != Strength.WEAK) goto L5;
            char r14 = 4;
        L6:
            boolean r15 = r14 | (r11 ? 1 : 0);
            if (r12 == false) goto L10;
            r13 = 2;
        L10:
            return factories[(r15 ? 1 : 0) | r13];
        L5:
            r14 = 0;
            goto L6
        }

        public static EntryFactory valueOf(String r10) {
            return (EntryFactory) Enum.valueOf(EntryFactory.class, r10);
        }

        public static EntryFactory[] values() {
            return (EntryFactory[]) $VALUES.clone();
        }

        public <K, V> void copyAccessEntry(ReferenceEntry<K, V> r10, ReferenceEntry<K, V> r11) {
            r11.setAccessTime(r10.getAccessTime());
            LocalCache.connectAccessOrder(r10.getPreviousInAccessQueue(), r11);
            LocalCache.connectAccessOrder(r11, r10.getNextInAccessQueue());
            LocalCache.nullifyAccessOrder(r10);
        }

        public <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> r10, ReferenceEntry<K, V> r11, ReferenceEntry<K, V> r12) {
            return newEntry(r10, r11.getKey(), r11.getHash(), r12);
        }

        public <K, V> void copyWriteEntry(ReferenceEntry<K, V> r10, ReferenceEntry<K, V> r11) {
            r11.setWriteTime(r10.getWriteTime());
            LocalCache.connectWriteOrder(r10.getPreviousInWriteQueue(), r11);
            LocalCache.connectWriteOrder(r11, r10.getNextInWriteQueue());
            LocalCache.nullifyWriteOrder(r10);
        }

        public abstract <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> r10, K r11, int r12, @NullableDecl ReferenceEntry<K, V> r13);

        public /* synthetic */ EntryFactory(String r10, int r11, AnonymousClass1 r12) {
            this(r10, r11);
        }
    }

    public final class EntryIterator extends LocalCache<K, V>.HashIterator<Map.Entry<K, V>> {
        final /* synthetic */ LocalCache this$0;

        public EntryIterator(LocalCache r10) {
            this.this$0 = r10;
            super(r10);
        }

        @Override // com.google.common.cache.LocalCache.HashIterator, java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        @Override // com.google.common.cache.LocalCache.HashIterator, java.util.Iterator
        public Map.Entry<K, V> next() {
            return nextEntry();
        }
    }

    public final class EntrySet extends LocalCache<K, V>.AbstractCacheSet<Map.Entry<K, V>> {
        final /* synthetic */ LocalCache this$0;

        public EntrySet(LocalCache r10, ConcurrentMap<?, ?> r11) {
            this.this$0 = r10;
            super(r10, r11);
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
            if (this.this$0.valueEquivalence.equivalent(r11.getValue(), r13) == false) goto L15;
            return true;
        L15:
            return false;
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
    }

    public abstract class HashIterator<T> implements Iterator<T> {

        @MonotonicNonNullDecl
        Segment<K, V> currentSegment;

        @MonotonicNonNullDecl
        AtomicReferenceArray<ReferenceEntry<K, V>> currentTable;

        @NullableDecl
        LocalCache<K, V>.WriteThroughEntry lastReturned;

        @NullableDecl
        ReferenceEntry<K, V> nextEntry;

        @NullableDecl
        LocalCache<K, V>.WriteThroughEntry nextExternal;
        int nextSegmentIndex;
        int nextTableIndex;
        final /* synthetic */ LocalCache this$0;

        public HashIterator(LocalCache r10) {
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
            Segment<K, V>[] r11 = this.this$0.segments;
            this.nextSegmentIndex = r10 - 1;
            Segment<K, V> r12 = r11[r10];
            this.currentSegment = r12;
            if (r12.count == 0) goto L8;
            AtomicReferenceArray<ReferenceEntry<K, V>> r13 = this.currentSegment.table;
            this.currentTable = r13;
            this.nextTableIndex = r13.length() - 1;
            if (nextInTable() == false) goto L8;
            return;
        }

        public boolean advanceTo(ReferenceEntry<K, V> r10) {
            long r11 = this.this$0.ticker.read();     // Catch: Throwable -> L7
            K r12 = r10.getKey();     // Catch: Throwable -> L7
            Object r13 = this.this$0.getLiveValue(r10, r11);     // Catch: Throwable -> L7
            if (r13 == null) goto L9;
            this.nextExternal = new WriteThroughEntry(this.this$0, r12, r13);     // Catch: Throwable -> L7
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

        public LocalCache<K, V>.WriteThroughEntry nextEntry() {
            LocalCache<K, V>.WriteThroughEntry r10 = this.nextExternal;
            if (r10 == null) goto L7;
            this.lastReturned = r10;
            advance();
            return this.lastReturned;
        L7:
            throw new NoSuchElementException();
        }

        public boolean nextInChain() {
            ReferenceEntry<K, V> r10 = this.nextEntry;
            if (r10 == null) goto L11;
        L4:
            this.nextEntry = r10.getNext();
            ReferenceEntry<K, V> r11 = this.nextEntry;
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
            AtomicReferenceArray<ReferenceEntry<K, V>> r11 = this.currentTable;
            this.nextTableIndex = r10 - 1;
            ReferenceEntry<K, V> r12 = r11.get(r10);
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
            Preconditions.checkState(r10);
            this.this$0.remove(this.lastReturned.getKey());
            this.lastReturned = null;
            return;
        L5:
            r10 = false;
            goto L6
        }
    }

    public final class KeyIterator extends LocalCache<K, V>.HashIterator<K> {
        final /* synthetic */ LocalCache this$0;

        public KeyIterator(LocalCache r10) {
            this.this$0 = r10;
            super(r10);
        }

        @Override // com.google.common.cache.LocalCache.HashIterator, java.util.Iterator
        public K next() {
            return nextEntry().getKey();
        }
    }

    public final class KeySet extends LocalCache<K, V>.AbstractCacheSet<K> {
        final /* synthetic */ LocalCache this$0;

        public KeySet(LocalCache r10, ConcurrentMap<?, ?> r11) {
            this.this$0 = r10;
            super(r10, r11);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r10) {
            return this.map.containsKey(r10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new KeyIterator(this.this$0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r10) {
            if (this.map.remove(r10) == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class LoadingSerializationProxy<K, V> extends ManualSerializationProxy<K, V> implements LoadingCache<K, V>, Serializable {
        private static final long serialVersionUID = 1;

        @MonotonicNonNullDecl
        transient LoadingCache<K, V> autoDelegate;

        public LoadingSerializationProxy(LocalCache<K, V> r10) {
            super(r10);
        }

        private void readObject(ObjectInputStream r10) throws IOException, ClassNotFoundException {
            r10.defaultReadObject();
            this.autoDelegate = (LoadingCache<K, V>) recreateCacheBuilder().build(this.loader);
        }

        private Object readResolve() {
            return this.autoDelegate;
        }

        @Override // com.google.common.cache.LoadingCache, com.google.common.base.Function
        public final V apply(K r10) {
            return this.autoDelegate.apply(r10);
        }

        @Override // com.google.common.cache.LoadingCache
        public V get(K r10) throws ExecutionException {
            return this.autoDelegate.get(r10);
        }

        @Override // com.google.common.cache.LoadingCache
        public ImmutableMap<K, V> getAll(Iterable<? extends K> r10) throws ExecutionException {
            return this.autoDelegate.getAll(r10);
        }

        @Override // com.google.common.cache.LoadingCache
        public V getUnchecked(K r10) {
            return this.autoDelegate.getUnchecked(r10);
        }

        @Override // com.google.common.cache.LoadingCache
        public void refresh(K r10) {
            this.autoDelegate.refresh(r10);
        }
    }

    public static class LoadingValueReference<K, V> implements ValueReference<K, V> {
        final SettableFuture<V> futureValue;
        volatile ValueReference<K, V> oldValue;
        final Stopwatch stopwatch;

        public LoadingValueReference() {
            this(LocalCache.unset());
        }

        private ListenableFuture<V> fullyFailedFuture(Throwable r10) {
            return Futures.immediateFailedFuture(r10);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference<K, V> copyFor(ReferenceQueue<V> r10, @NullableDecl V r11, ReferenceEntry<K, V> r12) {
            return this;
        }

        public long elapsedNanos() {
            return this.stopwatch.elapsed(TimeUnit.NANOSECONDS);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V get() {
            return this.oldValue.get();
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ReferenceEntry<K, V> getEntry() {
            return null;
        }

        public ValueReference<K, V> getOldValue() {
            return this.oldValue;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return this.oldValue.getWeight();
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return this.oldValue.isActive();
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return true;
        }

        public ListenableFuture<V> loadFuture(K r10, CacheLoader<? super K, V> r11) {
            this.stopwatch.start();     // Catch: Throwable -> L7
            V r12 = this.oldValue.get();     // Catch: Throwable -> L7
            if (r12 != null) goto L11;
            V r13 = r11.load(r10);     // Catch: Throwable -> L7
            if (set(r13) == false) goto L10;
            return this.futureValue;
        L10:
            return Futures.immediateFuture(r13);
        L11:
            ListenableFuture<V> r14 = r11.reload(r10, r12);     // Catch: Throwable -> L7
            if (r14 != null) goto L16;
            return Futures.immediateFuture(null);
        L16:
            return Futures.transform(r14, new AnonymousClass1(this), MoreExecutors.directExecutor());
        L7:
            th = move-exception;
            if (setException(th) == false) goto L20;
            ListenableFuture<V> r15 = this.futureValue;
        L22:
            if ((th instanceof InterruptedException) == false) goto L24;
            Thread.currentThread().interrupt();
        L24:
            return r15;
        L20:
            r15 = fullyFailedFuture(th);
            goto L22
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void notifyNewValue(@NullableDecl V r10) {
            if (r10 == null) goto L4;
            set(r10);
            return;
        L4:
            this.oldValue = LocalCache.unset();
        }

        public boolean set(@NullableDecl V r10) {
            return this.futureValue.set(r10);
        }

        public boolean setException(Throwable r10) {
            return this.futureValue.setException(r10);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V waitForValue() throws ExecutionException {
            return (V) Uninterruptibles.getUninterruptibly(this.futureValue);
        }

        public LoadingValueReference(ValueReference<K, V> r10) {
            this.futureValue = SettableFuture.create();
            this.stopwatch = Stopwatch.createUnstarted();
            this.oldValue = r10;
        }
    }

    public static class LocalLoadingCache<K, V> extends LocalManualCache<K, V> implements LoadingCache<K, V> {
        private static final long serialVersionUID = 1;

        public LocalLoadingCache(CacheBuilder<? super K, ? super V> r10, CacheLoader<? super K, V> r11) {
            super(new LocalCache(r10, (CacheLoader) Preconditions.checkNotNull(r11)), null);
        }

        @Override // com.google.common.cache.LoadingCache, com.google.common.base.Function
        public final V apply(K r10) {
            return getUnchecked(r10);
        }

        @Override // com.google.common.cache.LoadingCache
        public V get(K r10) throws ExecutionException {
            return this.localCache.getOrLoad(r10);
        }

        @Override // com.google.common.cache.LoadingCache
        public ImmutableMap<K, V> getAll(Iterable<? extends K> r10) throws ExecutionException {
            return this.localCache.getAll(r10);
        }

        @Override // com.google.common.cache.LoadingCache
        public V getUnchecked(K r10) {
            return get(r10);
        L4:
            e = move-exception;
            throw new UncheckedExecutionException(e.getCause());
        }

        @Override // com.google.common.cache.LoadingCache
        public void refresh(K r10) {
            this.localCache.refresh(r10);
        }

        @Override // com.google.common.cache.LocalCache.LocalManualCache
        public Object writeReplace() {
            return new LoadingSerializationProxy(this.localCache);
        }
    }

    public static class LocalManualCache<K, V> implements Cache<K, V>, Serializable {
        private static final long serialVersionUID = 1;
        final LocalCache<K, V> localCache;

        public /* synthetic */ LocalManualCache(LocalCache r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // com.google.common.cache.Cache
        public ConcurrentMap<K, V> asMap() {
            return this.localCache;
        }

        @Override // com.google.common.cache.Cache
        public void cleanUp() {
            this.localCache.cleanUp();
        }

        @Override // com.google.common.cache.Cache
        public V get(K r10, final Callable<? extends V> r11) throws ExecutionException {
            Preconditions.checkNotNull(r11);
            return this.localCache.get(r10, new AnonymousClass1(this, r11));
        }

        @Override // com.google.common.cache.Cache
        public ImmutableMap<K, V> getAllPresent(Iterable<?> r10) {
            return this.localCache.getAllPresent(r10);
        }

        @Override // com.google.common.cache.Cache
        @NullableDecl
        public V getIfPresent(Object r10) {
            return this.localCache.getIfPresent(r10);
        }

        @Override // com.google.common.cache.Cache
        public void invalidate(Object r10) {
            Preconditions.checkNotNull(r10);
            this.localCache.remove(r10);
        }

        @Override // com.google.common.cache.Cache
        public void invalidateAll(Iterable<?> r10) {
            this.localCache.invalidateAll(r10);
        }

        @Override // com.google.common.cache.Cache
        public void put(K r10, V r11) {
            this.localCache.put(r10, r11);
        }

        @Override // com.google.common.cache.Cache
        public void putAll(Map<? extends K, ? extends V> r10) {
            this.localCache.putAll(r10);
        }

        @Override // com.google.common.cache.Cache
        public long size() {
            return this.localCache.longSize();
        }

        @Override // com.google.common.cache.Cache
        public CacheStats stats() {
            AbstractCache.SimpleStatsCounter r10 = new AbstractCache.SimpleStatsCounter();
            r10.incrementBy(this.localCache.globalStatsCounter);
            Segment<K, V>[] r11 = this.localCache.segments;
            int r12 = r11.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L6;
            r10.incrementBy(r11[r13].statsCounter);
            r13 = r13 + 1;
            goto L3
        L6:
            return r10.snapshot();
        }

        public Object writeReplace() {
            return new ManualSerializationProxy(this.localCache);
        }

        public LocalManualCache(CacheBuilder<? super K, ? super V> r10) {
            this(new LocalCache(r10, null));
        }

        @Override // com.google.common.cache.Cache
        public void invalidateAll() {
            this.localCache.clear();
        }

        private LocalManualCache(LocalCache<K, V> r10) {
            this.localCache = r10;
        }
    }

    public static class ManualSerializationProxy<K, V> extends ForwardingCache<K, V> implements Serializable {
        private static final long serialVersionUID = 1;
        final int concurrencyLevel;

        @MonotonicNonNullDecl
        transient Cache<K, V> delegate;
        final long expireAfterAccessNanos;
        final long expireAfterWriteNanos;
        final Equivalence<Object> keyEquivalence;
        final Strength keyStrength;
        final CacheLoader<? super K, V> loader;
        final long maxWeight;
        final RemovalListener<? super K, ? super V> removalListener;

        @NullableDecl
        final Ticker ticker;
        final Equivalence<Object> valueEquivalence;
        final Strength valueStrength;
        final Weigher<K, V> weigher;

        public ManualSerializationProxy(LocalCache<K, V> r17) {
            this(r17.keyStrength, r17.valueStrength, r17.keyEquivalence, r17.valueEquivalence, r17.expireAfterWriteNanos, r17.expireAfterAccessNanos, r17.maxWeight, r17.weigher, r17.concurrencyLevel, r17.removalListener, r17.ticker, r17.defaultLoader);
        }

        private void readObject(ObjectInputStream r10) throws IOException, ClassNotFoundException {
            r10.defaultReadObject();
            this.delegate = (Cache<K, V>) recreateCacheBuilder().build();
        }

        private Object readResolve() {
            return this.delegate;
        }

        @Override // com.google.common.cache.ForwardingCache, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        public CacheBuilder<K, V> recreateCacheBuilder() {
            CacheBuilder<K, V> r10 = (CacheBuilder<K, V>) CacheBuilder.newBuilder().setKeyStrength(this.keyStrength).setValueStrength(this.valueStrength).keyEquivalence(this.keyEquivalence).valueEquivalence(this.valueEquivalence).concurrencyLevel(this.concurrencyLevel).removalListener(this.removalListener);
            r10.strictParsing = false;
            long r11 = this.expireAfterWriteNanos;
            if (r11 <= 0) goto L5;
            r10.expireAfterWrite(r11, TimeUnit.NANOSECONDS);
        L5:
            long r12 = this.expireAfterAccessNanos;
            if (r12 <= 0) goto L8;
            r10.expireAfterAccess(r12, TimeUnit.NANOSECONDS);
        L8:
            Weigher r13 = this.weigher;
            if (r13 == CacheBuilder.OneWeigher.INSTANCE) goto L13;
            r10.weigher(r13);
            long r14 = this.maxWeight;
            if (r14 == (-1)) goto L16;
            r10.maximumWeight(r14);
        L16:
            Ticker r15 = this.ticker;
            if (r15 == null) goto L19;
            r10.ticker(r15);
        L19:
            return r10;
        L13:
            long r16 = this.maxWeight;
            if (r16 == (-1)) goto L16;
            r10.maximumSize(r16);
            goto L16
        }

        private ManualSerializationProxy(Strength r10, Strength r11, Equivalence<Object> r12, Equivalence<Object> r13, long r14, long r15, long r16, Weigher<K, V> r17, int r18, RemovalListener<? super K, ? super V> r19, Ticker r110, CacheLoader<? super K, V> r111) {
            this.keyStrength = r10;
            this.valueStrength = r11;
            this.keyEquivalence = r12;
            this.valueEquivalence = r13;
            this.expireAfterWriteNanos = r14;
            this.expireAfterAccessNanos = r15;
            this.maxWeight = r16;
            this.weigher = r17;
            this.concurrencyLevel = r18;
            this.removalListener = r19;
            if (r110 != Ticker.systemTicker()) goto L5;
        L6:
            r110 = null;
        L7:
            this.ticker = r110;
            this.loader = r111;
            return;
        L5:
            if (r110 != CacheBuilder.NULL_TICKER) goto L7;
            goto L6
        }

        @Override // com.google.common.cache.ForwardingCache, com.google.common.collect.ForwardingObject
        public Cache<K, V> delegate() {
            return this.delegate;
        }
    }

    public static final enum NullEntry extends Enum<NullEntry> implements ReferenceEntry<Object, Object> {
        private static final /* synthetic */ NullEntry[] $VALUES = null;
        public static final NullEntry INSTANCE = null;

        static {
            NullEntry r10 = new NullEntry("INSTANCE", 0);
            INSTANCE = r10;
            $VALUES = new NullEntry[]{r10};
        }

        private NullEntry(String r10, int r11) {
            super(r10, r11);
        }

        public static NullEntry valueOf(String r10) {
            return (NullEntry) Enum.valueOf(NullEntry.class, r10);
        }

        public static NullEntry[] values() {
            return (NullEntry[]) $VALUES.clone();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            return 0;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public int getHash() {
            return 0;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public Object getKey() {
            return null;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> getNext() {
            return null;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> getNextInAccessQueue() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> getNextInWriteQueue() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> getPreviousInAccessQueue() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> getPreviousInWriteQueue() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ValueReference<Object, Object> getValueReference() {
            return null;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            return 0;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setAccessTime(long r10) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry<Object, Object> r10) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry<Object, Object> r10) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry<Object, Object> r10) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry<Object, Object> r10) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setValueReference(ValueReference<Object, Object> r10) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setWriteTime(long r10) {
        }
    }

    public static class Segment<K, V> extends ReentrantLock {

        @GuardedBy("this")
        final Queue<ReferenceEntry<K, V>> accessQueue;
        volatile int count;

        @NullableDecl
        final ReferenceQueue<K> keyReferenceQueue;

        @Weak
        final LocalCache<K, V> map;
        final long maxSegmentWeight;
        int modCount;
        final AtomicInteger readCount;
        final Queue<ReferenceEntry<K, V>> recencyQueue;
        final AbstractCache.StatsCounter statsCounter;

        @MonotonicNonNullDecl
        volatile AtomicReferenceArray<ReferenceEntry<K, V>> table;
        int threshold;

        @GuardedBy("this")
        long totalWeight;

        @NullableDecl
        final ReferenceQueue<V> valueReferenceQueue;

        @GuardedBy("this")
        final Queue<ReferenceEntry<K, V>> writeQueue;

        public Segment(LocalCache<K, V> r10, int r11, long r12, AbstractCache.StatsCounter r13) {
            this.readCount = new AtomicInteger();
            this.map = r10;
            this.maxSegmentWeight = r12;
            this.statsCounter = (AbstractCache.StatsCounter) Preconditions.checkNotNull(r13);
            initTable(newEntryArray(r11));
            ReferenceQueue<V> r14 = null;
            if (r10.usesKeyReferences() == false) goto L5;
            ReferenceQueue<K> r15 = new ReferenceQueue();
        L6:
            this.keyReferenceQueue = r15;
            if (r10.usesValueReferences() == false) goto L9;
            r14 = new ReferenceQueue();
        L9:
            this.valueReferenceQueue = r14;
            if (r10.usesAccessQueue() == false) goto L12;
            Queue<ReferenceEntry<K, V>> r16 = new ConcurrentLinkedQueue();
        L13:
            this.recencyQueue = r16;
            if (r10.usesWriteQueue() == false) goto L16;
            Queue<ReferenceEntry<K, V>> r17 = new WriteQueue();
        L17:
            this.writeQueue = r17;
            if (r10.usesAccessQueue() == false) goto L20;
            Queue<ReferenceEntry<K, V>> r18 = new AccessQueue();
        L21:
            this.accessQueue = r18;
            return;
        L20:
            r18 = LocalCache.discardingQueue();
            goto L21
        L16:
            r17 = LocalCache.discardingQueue();
            goto L17
        L12:
            r16 = LocalCache.discardingQueue();
            goto L13
        L5:
            r15 = null;
            goto L6
        }

        public void cleanUp() {
            runLockedCleanup(this.map.ticker.read());
            runUnlockedCleanup();
        }

        public void clear() {
            if (this.count == 0) goto L32;
            lock();
            preWriteCleanup(this.map.ticker.read());     // Catch: Throwable -> L18
            AtomicReferenceArray<ReferenceEntry<K, V>> r10 = this.table;     // Catch: Throwable -> L18
            int r11 = 0;
        L7:
            if (r11 >= r10.length()) goto L24;
            ReferenceEntry<K, V> r12 = r10.get(r11);     // Catch: Throwable -> L18
        L9:
            if (r12 == null) goto L23;
            if (r12.getValueReference().isActive() == false) goto L22;
            K r13 = r12.getKey();     // Catch: Throwable -> L18
            V r14 = r12.getValueReference().get();     // Catch: Throwable -> L18
            if (r13 == null) goto L20;
            if (r14 == null) goto L20;
            RemovalCause r15 = RemovalCause.EXPLICIT;     // Catch: Throwable -> L18
        L21:
            enqueueNotification(r13, r12.getHash(), r14, r12.getValueReference().getWeight(), r15);     // Catch: Throwable -> L18
        L20:
            r15 = RemovalCause.COLLECTED;     // Catch: Throwable -> L18
        L22:
            r12 = r12.getNext();     // Catch: Throwable -> L18
            goto L9
        L23:
            r11 = r11 + 1;     // Catch: Throwable -> L18
            goto L7
        L24:
            int r16 = 0;
        L26:
            if (r16 >= r10.length()) goto L28;
            r10.set(r16, null);     // Catch: Throwable -> L18
            r16 = r16 + 1;     // Catch: Throwable -> L18
            goto L26
        L28:
            clearReferenceQueues();     // Catch: Throwable -> L18
            this.writeQueue.clear();     // Catch: Throwable -> L18
            this.accessQueue.clear();     // Catch: Throwable -> L18
            this.readCount.set(0);     // Catch: Throwable -> L18
            this.modCount++;     // Catch: Throwable -> L18
            this.count = 0;     // Catch: Throwable -> L18
            unlock();
            postWriteCleanup();
            return;
        L18:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        public void clearKeyReferenceQueue() {
        L3:
            if (this.keyReferenceQueue.poll() != null) goto L3;
        }

        public void clearReferenceQueues() {
            if (this.map.usesKeyReferences() == false) goto L6;
            clearKeyReferenceQueue();
        L6:
            if (this.map.usesValueReferences() == false) goto L9;
            clearValueReferenceQueue();
            return;
        }

        public void clearValueReferenceQueue() {
        L3:
            if (this.valueReferenceQueue.poll() != null) goto L3;
        }

        public boolean containsKey(Object r10, int r11) {
            boolean r12 = false;
            if (this.count == 0) goto L15;
            ReferenceEntry<K, V> r13 = getLiveEntry(r10, r11, this.map.ticker.read());     // Catch: Throwable -> L13
            if (r13 != null) goto L8;
            postReadCleanup();
            return false;
        L8:
            if (r13.getValueReference().get() == null) goto L11;
            r12 = true;
        L11:
            postReadCleanup();
            return r12;
        L15:
            postReadCleanup();
            return false;
        L13:
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
            long r11 = this.map.ticker.read();     // Catch: Throwable -> L17
            AtomicReferenceArray<ReferenceEntry<K, V>> r12 = this.table;     // Catch: Throwable -> L17
            int r13 = r12.length();     // Catch: Throwable -> L17
            int r14 = 0;
        L5:
            if (r14 >= r13) goto L20;
            ReferenceEntry<K, V> r15 = r12.get(r14);     // Catch: Throwable -> L17
        L7:
            if (r15 == null) goto L19;
            V r16 = getLiveValue(r15, r11);     // Catch: Throwable -> L17
            if (r16 != null) goto L12;
        L15:
            r15 = r15.getNext();     // Catch: Throwable -> L17
            goto L7
        L12:
            if (this.map.valueEquivalence.equivalent(r10, r16) == false) goto L15;
            postReadCleanup();
            return true;
        L19:
            r14 = r14 + 1;
        L20:
            postReadCleanup();
            return false;
        }

        @GuardedBy("this")
        public ReferenceEntry<K, V> copyEntry(ReferenceEntry<K, V> r10, ReferenceEntry<K, V> r11) {
            if (r10.getKey() != null) goto L5;
            return null;
        L5:
            ValueReference<K, V> r12 = r10.getValueReference();
            V r13 = r12.get();
            if (r13 == null) goto L8;
        L10:
            ReferenceEntry<K, V> r14 = this.map.entryFactory.copyEntry(this, r10, r11);
            r14.setValueReference(r12.copyFor(this.valueReferenceQueue, r13, r14));
            return r14;
        L8:
            if (r12.isActive() == false) goto L10;
            return null;
        }

        @GuardedBy("this")
        public void drainKeyReferenceQueue() {
            int r10 = 0;
        L3:
            Reference<? extends K> r11 = this.keyReferenceQueue.poll();
            if (r11 == null) goto L7;
            LocalCache<K, V> r12 = this.map;
            r12.reclaimKey((ReferenceEntry) r11);
            r10 = r10 + 1;
            if (r10 != 16) goto L3;
            return;
        }

        @GuardedBy("this")
        public void drainRecencyQueue() {
        L2:
            ReferenceEntry<K, V> r10 = this.recencyQueue.poll();
            if (r10 == null) goto L7;
            if (this.accessQueue.contains(r10) == false) goto L2;
            this.accessQueue.add(r10);
            goto L2
        }

        @GuardedBy("this")
        public void drainReferenceQueues() {
            if (this.map.usesKeyReferences() == false) goto L6;
            drainKeyReferenceQueue();
        L6:
            if (this.map.usesValueReferences() == false) goto L9;
            drainValueReferenceQueue();
            return;
        }

        @GuardedBy("this")
        public void drainValueReferenceQueue() {
            int r10 = 0;
        L3:
            Reference<? extends V> r11 = this.valueReferenceQueue.poll();
            if (r11 == null) goto L7;
            LocalCache<K, V> r12 = this.map;
            r12.reclaimValue((ValueReference) r11);
            r10 = r10 + 1;
            if (r10 != 16) goto L3;
            return;
        }

        @GuardedBy("this")
        public void enqueueNotification(@NullableDecl K r10, int r11, @NullableDecl V r12, int r13, RemovalCause r14) {
            this.totalWeight -= (long) r13;
            if (r14.wasEvicted() == false) goto L6;
            this.statsCounter.recordEviction();
        L6:
            if (this.map.removalNotificationQueue == LocalCache.DISCARDING_QUEUE) goto L9;
            this.map.removalNotificationQueue.offer(RemovalNotification.create(r10, r12, r14));
            return;
        }

        @GuardedBy("this")
        public void evictEntries(ReferenceEntry<K, V> r10) {
            if (this.map.evictsBySize() == true) goto L5;
            return;
        L5:
            drainRecencyQueue();
            if (r10.getValueReference().getWeight() <= this.maxSegmentWeight) goto L13;
            if (removeEntry(r10, r10.getHash(), RemovalCause.SIZE) == true) goto L13;
            throw new AssertionError();
        L13:
            if (this.totalWeight <= this.maxSegmentWeight) goto L19;
            ReferenceEntry<K, V> r11 = getNextEvictable();
            if (removeEntry(r11, r11.getHash(), RemovalCause.SIZE) == true) goto L13;
            throw new AssertionError();
        }

        @GuardedBy("this")
        public void expand() {
            AtomicReferenceArray<ReferenceEntry<K, V>> r10 = this.table;
            int r11 = r10.length();
            if (r11 < 1073741824) goto L5;
            return;
        L5:
            int r12 = this.count;
            AtomicReferenceArray<ReferenceEntry<K, V>> r13 = newEntryArray(r11 << 1);
            this.threshold = (r13.length() * 3) / 4;
            int r14 = r13.length() - 1;
            int r15 = 0;
        L6:
            if (r15 >= r11) goto L26;
            ReferenceEntry<K, V> r16 = r10.get(r15);
            if (r16 == null) goto L25;
            ReferenceEntry<K, V> r17 = r16.getNext();
            int r18 = r16.getHash() & r14;
            if (r17 != null) goto L12;
            r13.set(r18, r16);
            goto L25
        L12:
            ReferenceEntry<K, V> r19 = r16;
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
            ReferenceEntry<K, V> r21 = copyEntry(r16, r13.get(r20));
            if (r21 == null) goto L23;
            r13.set(r20, r21);
        L24:
            r16 = r16.getNext();
            goto L19
        L23:
            removeCollectedEntry(r16);
            r12 = r12 - 1;
        L25:
            r15 = r15 + 1;
            goto L6
        L26:
            this.table = r13;
            this.count = r12;
        }

        @GuardedBy("this")
        public void expireEntries(long r10) {
            drainRecencyQueue();
        L3:
            ReferenceEntry<K, V> r11 = this.writeQueue.peek();
            if (r11 == null) goto L12;
            if (this.map.isExpired(r11, r10) == false) goto L12;
            if (removeEntry(r11, r11.getHash(), RemovalCause.EXPIRED) == true) goto L3;
            throw new AssertionError();
        L12:
            ReferenceEntry<K, V> r12 = this.accessQueue.peek();
            if (r12 == null) goto L21;
            if (this.map.isExpired(r12, r10) == false) goto L31;
            if (removeEntry(r12, r12.getHash(), RemovalCause.EXPIRED) == true) goto L12;
            throw new AssertionError();
        L31:
            return;
        }

        public V get(K r10, int r11, CacheLoader<? super K, V> r12) throws ExecutionException {
            Preconditions.checkNotNull(r10);
            Preconditions.checkNotNull(r12);
        L14:
            e = move-exception;
            Throwable r13 = e.getCause();     // Catch: Throwable -> L12
            if ((r13 instanceof Error) == true) goto L32;
            if ((r13 instanceof RuntimeException) == true) goto L29;
            throw e;     // Catch: Throwable -> L12
        L29:
            throw new UncheckedExecutionException(r13);     // Catch: Throwable -> L12
        L32:
            throw new ExecutionError((Error) r13);     // Catch: Throwable -> L12
        L4:
            if (this.count == 0) goto L21;
            ReferenceEntry<K, V> r14 = getEntry(r10, r11);     // Catch: Throwable -> L12 ExecutionException -> L14
            if (r14 == null) goto L21;
            long r15 = this.map.ticker.read();     // Catch: Throwable -> L12 ExecutionException -> L14
            V r16 = getLiveValue(r14, r15);     // Catch: Throwable -> L12 ExecutionException -> L14
            if (r16 == null) goto L16;
            recordRead(r14, r15);     // Catch: Throwable -> L12 ExecutionException -> L14
            this.statsCounter.recordHits(1);     // Catch: Throwable -> L12 ExecutionException -> L14
            V r17 = scheduleRefresh(r14, r10, r11, r16, r15, r12);     // Catch: Throwable -> L12 ExecutionException -> L14
            postReadCleanup();
            return r17;
        L16:
            ValueReference<K, V> r18 = r14.getValueReference();     // Catch: Throwable -> L12 ExecutionException -> L14
            if (r18.isLoading() == false) goto L21;
            V r19 = waitForLoadingValue(r14, r10, r18);     // Catch: Throwable -> L12 ExecutionException -> L14
            postReadCleanup();
            return r19;
        L21:
            V r110 = lockedGetOrLoad(r10, r11, r12);     // Catch: Throwable -> L12 ExecutionException -> L14
            postReadCleanup();
            return r110;
        L12:
            th = move-exception;
            postReadCleanup();
            throw th;
        }

        public V getAndRecordStats(K r10, int r11, LoadingValueReference<K, V> r12, ListenableFuture<V> r13) throws ExecutionException {
            V r14 = (V) Uninterruptibles.getUninterruptibly(r13);
            if (r14 == null) goto L9;
            this.statsCounter.recordLoadSuccess(r12.elapsedNanos());     // Catch: Throwable -> L6
            storeLoadedValue(r10, r11, r12, r14);     // Catch: Throwable -> L6
            return r14;
        L9:
            throw new CacheLoader.InvalidCacheLoadException("CacheLoader returned null for key " + r10 + LibrarianImpl.Constants.DOT);     // Catch: Throwable -> L6
        L6:
            th = th;
        L12:
            if (r14 != null) goto L14;
            this.statsCounter.recordLoadException(r12.elapsedNanos());
            removeLoadingValue(r10, r11, r12);
        L14:
            throw th;
        L10:
            th = th;
            r14 = null;
            goto L12
        }

        @NullableDecl
        public ReferenceEntry<K, V> getEntry(Object r10, int r11) {
            ReferenceEntry<K, V> r12 = getFirst(r11);
        L3:
            if (r12 == null) goto L14;
            if (r12.getHash() != r11) goto L13;
            K r13 = r12.getKey();
            if (r13 != null) goto L11;
            tryDrainReferenceQueues();
            goto L13
        L11:
            if (this.map.keyEquivalence.equivalent(r10, r13) == false) goto L13;
            return r12;
        L13:
            r12 = r12.getNext();
            goto L3
        L14:
            return null;
        }

        public ReferenceEntry<K, V> getFirst(int r10) {
            AtomicReferenceArray<ReferenceEntry<K, V>> r11 = this.table;
            return r11.get(r10 & (r11.length() - 1));
        }

        @NullableDecl
        public ReferenceEntry<K, V> getLiveEntry(Object r10, int r11, long r12) {
            ReferenceEntry<K, V> r13 = getEntry(r10, r11);
            if (r13 != null) goto L6;
            return null;
        L6:
            if (this.map.isExpired(r13, r12) == false) goto L9;
            tryExpireEntries(r12);
            return null;
        L9:
            return r13;
        }

        public V getLiveValue(ReferenceEntry<K, V> r10, long r11) {
            if (r10.getKey() != null) goto L6;
            tryDrainReferenceQueues();
            return null;
        L6:
            V r12 = r10.getValueReference().get();
            if (r12 != null) goto L11;
            tryDrainReferenceQueues();
            return null;
        L11:
            if (this.map.isExpired(r10, r11) == false) goto L14;
            tryExpireEntries(r11);
            return null;
        L14:
            return r12;
        }

        @GuardedBy("this")
        public ReferenceEntry<K, V> getNextEvictable() {
            Iterator<ReferenceEntry<K, V>> r10 = this.accessQueue.iterator();
        L4:
            if (r10.hasNext() == false) goto L9;
            ReferenceEntry<K, V> r11 = r10.next();
            if (r11.getValueReference().getWeight() <= 0) goto L4;
            return r11;
        L9:
            throw new AssertionError();
        }

        public void initTable(AtomicReferenceArray<ReferenceEntry<K, V>> r10) {
            this.threshold = (r10.length() * 3) / 4;
            if (this.map.customWeigher() == true) goto L7;
            int r11 = this.threshold;
            if (r11 != this.maxSegmentWeight) goto L7;
            this.threshold = r11 + 1;
        L7:
            this.table = r10;
        }

        @NullableDecl
        public LoadingValueReference<K, V> insertLoadingValueReference(K r10, int r11, boolean r12) {
            lock();
            long r13 = this.map.ticker.read();     // Catch: Throwable -> L16
            preWriteCleanup(r13);     // Catch: Throwable -> L16
            AtomicReferenceArray<ReferenceEntry<K, V>> r14 = this.table;     // Catch: Throwable -> L16
            int r15 = (r14.length() - 1) & r11;     // Catch: Throwable -> L16
            ReferenceEntry<K, V> r16 = (ReferenceEntry) r14.get(r15);     // Catch: Throwable -> L16
            ReferenceEntry r17 = r16;
        L4:
            if (r17 == null) goto L24;
            Object r18 = r17.getKey();     // Catch: Throwable -> L16
            if (r17.getHash() != r11) goto L23;
            if (r18 == null) goto L23;
            if (this.map.keyEquivalence.equivalent(r10, r18) == false) goto L23;
            ValueReference<K, V> r19 = r17.getValueReference();     // Catch: Throwable -> L16
            if (r19.isLoading() == true) goto L21;
            if (r12 == true) goto L14;
        L18:
            this.modCount++;     // Catch: Throwable -> L16
            LoadingValueReference<K, V> r110 = new LoadingValueReference(r19);     // Catch: Throwable -> L16
            r17.setValueReference(r110);     // Catch: Throwable -> L16
            unlock();
            postWriteCleanup();
            return r110;
        L14:
            if ((r13 - r17.getWriteTime()) >= this.map.refreshNanos) goto L18;
        L21:
            unlock();
            postWriteCleanup();
            return null;
        L23:
            r17 = r17.getNext();     // Catch: Throwable -> L16
            goto L4
        L24:
            this.modCount++;     // Catch: Throwable -> L16
            LoadingValueReference<K, V> r111 = new LoadingValueReference();     // Catch: Throwable -> L16
            ReferenceEntry<K, V> r20 = newEntry(r10, r11, r16);     // Catch: Throwable -> L16
            r20.setValueReference(r111);     // Catch: Throwable -> L16
            r14.set(r15, r20);     // Catch: Throwable -> L16
            unlock();
            postWriteCleanup();
            return r111;
        L16:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        public ListenableFuture<V> loadAsync(final K r10, final int r11, final LoadingValueReference<K, V> r12, CacheLoader<? super K, V> r13) {
            final ListenableFuture<V> r14 = r12.loadFuture(r10, r13);
            r14.addListener(new AnonymousClass1(this, r10, r11, r12, r14), MoreExecutors.directExecutor());
            return r14;
        }

        public V loadSync(K r10, int r11, LoadingValueReference<K, V> r12, CacheLoader<? super K, V> r13) throws ExecutionException {
            return getAndRecordStats(r10, r11, r12, r12.loadFuture(r10, r13));
        }

        public V lockedGetOrLoad(K r18, int r19, CacheLoader<? super K, V> r20) throws ExecutionException {
            lock();
            long r10 = this.map.ticker.read();     // Catch: Throwable -> L18
            preWriteCleanup(r10);     // Catch: Throwable -> L18
            int r11 = this.count - 1;     // Catch: Throwable -> L18
            AtomicReferenceArray<ReferenceEntry<K, V>> r12 = this.table;     // Catch: Throwable -> L18
            int r13 = r19 & (r12.length() - 1);     // Catch: Throwable -> L18
            ReferenceEntry<K, V> r14 = r12.get(r13);     // Catch: Throwable -> L18
            ReferenceEntry<K, V> r15 = r14;
        L4:
            LoadingValueReference<K, V> r16 = null;
            if (r15 == null) goto L28;
            K r17 = r15.getKey();     // Catch: Throwable -> L18
            if (r15.getHash() != r19) goto L27;
            if (r17 == null) goto L27;
            if (this.map.keyEquivalence.equivalent(r18, r17) == false) goto L27;
            ValueReference<K, V> r110 = r15.getValueReference();     // Catch: Throwable -> L18
            if (r110.isLoading() == false) goto L15;
            boolean r21 = false;
        L14:
            ValueReference<K, V> r22 = r110;
        L29:
            if (r21 == false) goto L34;
            r16 = new LoadingValueReference();     // Catch: Throwable -> L18
            if (r15 != null) goto L33;
            r15 = newEntry(r18, r19, r14);     // Catch: Throwable -> L18
            r15.setValueReference(r16);     // Catch: Throwable -> L18
            r12.set(r13, r15);     // Catch: Throwable -> L18
            goto L34
        L33:
            r15.setValueReference(r16);     // Catch: Throwable -> L18
        L34:
            unlock();
            postWriteCleanup();
            if (r21 == false) goto L49;
            monitor-enter(r15);     // Catch: Throwable -> L45
            V r23 = loadSync(r18, r19, r16, r20);     // Catch: Throwable -> L42
            monitor-exit(r15);     // Catch: Throwable -> L42
            this.statsCounter.recordMisses(1);
            return r23;
        L42:
            th = move-exception;
            throw th;     // Catch: Throwable -> L45
        L45:
            th = move-exception;
            this.statsCounter.recordMisses(1);
            throw th;
        L49:
            return waitForLoadingValue(r15, r18, r22);
        L15:
            V r24 = r110.get();     // Catch: Throwable -> L18
            if (r24 != null) goto L21;
            enqueueNotification(r17, r19, r24, r110.getWeight(), RemovalCause.COLLECTED);     // Catch: Throwable -> L18
        L23:
            this.writeQueue.remove(r15);     // Catch: Throwable -> L18
            this.accessQueue.remove(r15);     // Catch: Throwable -> L18
            this.count = r11;     // Catch: Throwable -> L18
            r21 = true;
            goto L14
        L21:
            if (this.map.isExpired(r15, r10) == false) goto L24;
            enqueueNotification(r17, r19, r24, r110.getWeight(), RemovalCause.EXPIRED);     // Catch: Throwable -> L18
            goto L23
        L24:
            recordLockedRead(r15, r10);     // Catch: Throwable -> L18
            this.statsCounter.recordHits(1);     // Catch: Throwable -> L18
            unlock();
            postWriteCleanup();
            return r24;
        L27:
            r15 = r15.getNext();     // Catch: Throwable -> L18
            goto L4
        L28:
            r21 = true;
            r22 = null;
        L18:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @GuardedBy("this")
        public ReferenceEntry<K, V> newEntry(K r10, int r11, @NullableDecl ReferenceEntry<K, V> r12) {
            return this.map.entryFactory.newEntry(this, Preconditions.checkNotNull(r10), r11, r12);
        }

        public AtomicReferenceArray<ReferenceEntry<K, V>> newEntryArray(int r10) {
            return new AtomicReferenceArray(r10);
        }

        public void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) != 0) goto L6;
            cleanUp();
            return;
        }

        public void postWriteCleanup() {
            runUnlockedCleanup();
        }

        @GuardedBy("this")
        public void preWriteCleanup(long r10) {
            runLockedCleanup(r10);
        }

        @NullableDecl
        public V put(K r15, int r16, V r17, boolean r18) {
            lock();
            long r10 = this.map.ticker.read();     // Catch: Throwable -> L6
            preWriteCleanup(r10);     // Catch: Throwable -> L6
            if ((this.count + 1) <= this.threshold) goto L8;
            expand();     // Catch: Throwable -> L6
        L8:
            AtomicReferenceArray<ReferenceEntry<K, V>> r11 = this.table;     // Catch: Throwable -> L6
            int r12 = r16 & (r11.length() - 1);     // Catch: Throwable -> L6
            ReferenceEntry<K, V> r13 = r11.get(r12);     // Catch: Throwable -> L6
            ReferenceEntry<K, V> r14 = r13;
        L10:
            if (r14 == null) goto L31;
            K r19 = r14.getKey();     // Catch: Throwable -> L6
            if (r14.getHash() != r16) goto L30;
            if (r19 == null) goto L30;
            if (this.map.keyEquivalence.equivalent(r15, r19) == false) goto L30;
            ValueReference<K, V> r20 = r14.getValueReference();     // Catch: Throwable -> L6
            V r110 = r20.get();     // Catch: Throwable -> L6
            if (r110 != null) goto L25;
            this.modCount++;     // Catch: Throwable -> L6
            if (r20.isActive() == false) goto L21;
            enqueueNotification(r15, r16, r110, r20.getWeight(), RemovalCause.COLLECTED);     // Catch: Throwable -> L6
            setValue(r14, r15, r17, r10);     // Catch: Throwable -> L6
            int r21 = this.count;     // Catch: Throwable -> L6
        L22:
            this.count = r21;     // Catch: Throwable -> L6
            evictEntries(r14);     // Catch: Throwable -> L6
        L23:
            unlock();
            postWriteCleanup();
            return null;
        L21:
            setValue(r14, r15, r17, r10);     // Catch: Throwable -> L6
            r21 = this.count + 1;     // Catch: Throwable -> L6
            goto L22
        L25:
            if (r18 == false) goto L29;
            recordLockedRead(r14, r10);     // Catch: Throwable -> L6
        L27:
            unlock();
            postWriteCleanup();
            return r110;
        L29:
            this.modCount++;     // Catch: Throwable -> L6
            enqueueNotification(r15, r16, r110, r20.getWeight(), RemovalCause.REPLACED);     // Catch: Throwable -> L6
            setValue(r14, r15, r17, r10);     // Catch: Throwable -> L6
            evictEntries(r14);     // Catch: Throwable -> L6
        L30:
            r14 = r14.getNext();     // Catch: Throwable -> L6
            goto L10
        L31:
            this.modCount++;     // Catch: Throwable -> L6
            ReferenceEntry<K, V> r111 = newEntry(r15, r16, r13);     // Catch: Throwable -> L6
            setValue(r111, r15, r17, r10);     // Catch: Throwable -> L6
            r11.set(r12, r111);     // Catch: Throwable -> L6
            this.count++;     // Catch: Throwable -> L6
            evictEntries(r111);     // Catch: Throwable -> L6
        L6:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        public boolean reclaimKey(ReferenceEntry<K, V> r13, int r14) {
            lock();
            AtomicReferenceArray<ReferenceEntry<K, V>> r10 = this.table;     // Catch: Throwable -> L9
            int r11 = (r10.length() - 1) & r14;     // Catch: Throwable -> L9
            ReferenceEntry<K, V> r12 = r10.get(r11);     // Catch: Throwable -> L9
            ReferenceEntry<K, V> r15 = r12;
        L4:
            if (r15 == null) goto L13;
            if (r15 == r13) goto L6;
            r15 = r15.getNext();     // Catch: Throwable -> L9
            goto L4
        L6:
            this.modCount++;     // Catch: Throwable -> L9
            ReferenceEntry<K, V> r16 = removeValueFromChain(r12, r15, r15.getKey(), r14, r15.getValueReference().get(), r15.getValueReference(), RemovalCause.COLLECTED);     // Catch: Throwable -> L9
            int r17 = this.count - 1;     // Catch: Throwable -> L9
            r10.set(r11, r16);     // Catch: Throwable -> L9
            this.count = r17;     // Catch: Throwable -> L9
            unlock();
            postWriteCleanup();
            return true;
        L13:
            unlock();
            postWriteCleanup();
            return false;
        L9:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        public boolean reclaimValue(K r13, int r14, ValueReference<K, V> r15) {
            lock();
            AtomicReferenceArray<ReferenceEntry<K, V>> r10 = this.table;     // Catch: Throwable -> L18
            int r11 = (r10.length() - 1) & r14;     // Catch: Throwable -> L18
            ReferenceEntry<K, V> r12 = r10.get(r11);     // Catch: Throwable -> L18
            ReferenceEntry<K, V> r16 = r12;
        L5:
            if (r16 == null) goto L26;
            K r17 = r16.getKey();     // Catch: Throwable -> L18
            if (r16.getHash() != r14) goto L24;
            if (r17 == null) goto L24;
            if (this.map.keyEquivalence.equivalent(r13, r17) == false) goto L24;
            if (r16.getValueReference() != r15) goto L20;
            this.modCount++;     // Catch: Throwable -> L18
            ReferenceEntry<K, V> r18 = removeValueFromChain(r12, r16, r17, r14, r15.get(), r15, RemovalCause.COLLECTED);     // Catch: Throwable -> L18
            int r19 = this.count - 1;     // Catch: Throwable -> L18
            r10.set(r11, r18);     // Catch: Throwable -> L18
            this.count = r19;     // Catch: Throwable -> L18
            unlock();
            if (isHeldByCurrentThread() == true) goto L17;
            postWriteCleanup();
        L17:
            return true;
        L20:
            unlock();
            if (isHeldByCurrentThread() == true) goto L23;
            postWriteCleanup();
        L23:
            return false;
        L24:
            r16 = r16.getNext();     // Catch: Throwable -> L18
            goto L5
        L26:
            unlock();
            if (isHeldByCurrentThread() == true) goto L29;
            postWriteCleanup();
        L29:
            return false;
        L18:
            th = move-exception;
            unlock();
            if (isHeldByCurrentThread() == true) goto L33;
            postWriteCleanup();
        L33:
            throw th;
        }

        @GuardedBy("this")
        public void recordLockedRead(ReferenceEntry<K, V> r10, long r11) {
            if (this.map.recordsAccess() == false) goto L5;
            r10.setAccessTime(r11);
        L5:
            this.accessQueue.add(r10);
        }

        public void recordRead(ReferenceEntry<K, V> r10, long r11) {
            if (this.map.recordsAccess() == false) goto L5;
            r10.setAccessTime(r11);
        L5:
            this.recencyQueue.add(r10);
        }

        @GuardedBy("this")
        public void recordWrite(ReferenceEntry<K, V> r10, int r11, long r12) {
            drainRecencyQueue();
            this.totalWeight += (long) r11;
            if (this.map.recordsAccess() == false) goto L6;
            r10.setAccessTime(r12);
        L6:
            if (this.map.recordsWrite() == false) goto L8;
            r10.setWriteTime(r12);
        L8:
            this.accessQueue.add(r10);
            this.writeQueue.add(r10);
        }

        @NullableDecl
        public V refresh(K r10, int r11, CacheLoader<? super K, V> r12, boolean r13) {
            LoadingValueReference<K, V> r14 = insertLoadingValueReference(r10, r11, r13);
            if (r14 != null) goto L5;
            return null;
        L5:
            ListenableFuture<V> r15 = loadAsync(r10, r11, r14, r12);
            if (r15.isDone() == true) goto L11;
        L9:
            return null;
        L11:
            return (V) Uninterruptibles.getUninterruptibly(r15);
        }

        @NullableDecl
        public V remove(Object r12, int r13) {
            lock();
            preWriteCleanup(this.map.ticker.read());     // Catch: Throwable -> L15
            AtomicReferenceArray<ReferenceEntry<K, V>> r10 = this.table;     // Catch: Throwable -> L15
            int r11 = (r10.length() - 1) & r13;     // Catch: Throwable -> L15
            ReferenceEntry<K, V> r14 = r10.get(r11);     // Catch: Throwable -> L15
            ReferenceEntry<K, V> r15 = r14;
        L5:
            if (r15 == null) goto L23;
            K r16 = r15.getKey();     // Catch: Throwable -> L15
            if (r15.getHash() != r13) goto L25;
            if (r16 == null) goto L25;
            if (this.map.keyEquivalence.equivalent(r12, r16) == false) goto L25;
            ValueReference<K, V> r17 = r15.getValueReference();     // Catch: Throwable -> L15
            V r18 = r17.get();     // Catch: Throwable -> L15
            if (r18 == null) goto L18;
            RemovalCause r19 = RemovalCause.EXPLICIT;     // Catch: Throwable -> L15
        L14:
            RemovalCause r110 = r19;
            this.modCount++;     // Catch: Throwable -> L15
            ReferenceEntry<K, V> r111 = removeValueFromChain(r14, r15, r16, r13, r18, r17, r110);     // Catch: Throwable -> L15
            int r20 = this.count - 1;     // Catch: Throwable -> L15
            r10.set(r11, r111);     // Catch: Throwable -> L15
            this.count = r20;     // Catch: Throwable -> L15
            unlock();
            postWriteCleanup();
            return r18;
        L18:
            if (r17.isActive() == false) goto L23;
            r19 = RemovalCause.COLLECTED;     // Catch: Throwable -> L15
        L25:
            r15 = r15.getNext();     // Catch: Throwable -> L15
        L23:
            unlock();
            postWriteCleanup();
            return null;
        L15:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        @GuardedBy("this")
        public void removeCollectedEntry(ReferenceEntry<K, V> r10) {
            enqueueNotification(r10.getKey(), r10.getHash(), r10.getValueReference().get(), r10.getValueReference().getWeight(), RemovalCause.COLLECTED);
            this.writeQueue.remove(r10);
            this.accessQueue.remove(r10);
        }

        @VisibleForTesting
        @GuardedBy("this")
        public boolean removeEntry(ReferenceEntry<K, V> r13, int r14, RemovalCause r15) {
            AtomicReferenceArray<ReferenceEntry<K, V>> r10 = this.table;
            int r11 = (r10.length() - 1) & r14;
            ReferenceEntry<K, V> r12 = r10.get(r11);
            ReferenceEntry<K, V> r16 = r12;
        L3:
            if (r16 == null) goto L8;
            if (r16 == r13) goto L5;
            r16 = r16.getNext();
            goto L3
        L5:
            this.modCount++;
            ReferenceEntry<K, V> r17 = removeValueFromChain(r12, r16, r16.getKey(), r14, r16.getValueReference().get(), r16.getValueReference(), r15);
            int r18 = this.count - 1;
            r10.set(r11, r17);
            this.count = r18;
            return true;
        L8:
            return false;
        }

        @NullableDecl
        @GuardedBy("this")
        public ReferenceEntry<K, V> removeEntryFromChain(ReferenceEntry<K, V> r10, ReferenceEntry<K, V> r11) {
            int r12 = this.count;
            ReferenceEntry<K, V> r13 = r11.getNext();
        L3:
            if (r10 == r11) goto L9;
            ReferenceEntry<K, V> r14 = copyEntry(r10, r13);
            if (r14 == null) goto L7;
            r13 = r14;
        L8:
            r10 = r10.getNext();
            goto L3
        L7:
            removeCollectedEntry(r10);
            r12 = r12 - 1;
            goto L8
        L9:
            this.count = r12;
            return r13;
        }

        public boolean removeLoadingValue(K r10, int r11, LoadingValueReference<K, V> r12) {
            lock();
            AtomicReferenceArray<ReferenceEntry<K, V>> r13 = this.table;     // Catch: Throwable -> L16
            int r14 = (r13.length() - 1) & r11;     // Catch: Throwable -> L16
            ReferenceEntry<K, V> r15 = r13.get(r14);     // Catch: Throwable -> L16
            ReferenceEntry<K, V> r16 = r15;
        L5:
            if (r16 == null) goto L21;
            K r17 = r16.getKey();     // Catch: Throwable -> L16
            if (r16.getHash() != r11) goto L23;
            if (r17 == null) goto L23;
            if (this.map.keyEquivalence.equivalent(r10, r17) == false) goto L23;
            if (r16.getValueReference() != r12) goto L21;
            if (r12.isActive() == false) goto L18;
            r16.setValueReference(r12.getOldValue());     // Catch: Throwable -> L16
        L19:
            unlock();
            postWriteCleanup();
            return true;
        L18:
            r13.set(r14, removeEntryFromChain(r15, r16));     // Catch: Throwable -> L16
        L23:
            r16 = r16.getNext();     // Catch: Throwable -> L16
        L21:
            unlock();
            postWriteCleanup();
            return false;
        L16:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        @NullableDecl
        @GuardedBy("this")
        public ReferenceEntry<K, V> removeValueFromChain(ReferenceEntry<K, V> r10, ReferenceEntry<K, V> r11, @NullableDecl K r12, int r13, V r14, ValueReference<K, V> r15, RemovalCause r16) {
            enqueueNotification(r12, r13, r14, r15.getWeight(), r16);
            this.writeQueue.remove(r11);
            this.accessQueue.remove(r11);
            if (r15.isLoading() == false) goto L7;
            r15.notifyNewValue(null);
            return r10;
        L7:
            return removeEntryFromChain(r10, r11);
        }

        public boolean replace(K r18, int r19, V r20, V r21) {
            lock();
            long r10 = this.map.ticker.read();     // Catch: Throwable -> L17
            preWriteCleanup(r10);     // Catch: Throwable -> L17
            AtomicReferenceArray<ReferenceEntry<K, V>> r11 = this.table;     // Catch: Throwable -> L17
            int r12 = r19 & (r11.length() - 1);     // Catch: Throwable -> L17
            ReferenceEntry<K, V> r13 = r11.get(r12);     // Catch: Throwable -> L17
            ReferenceEntry<K, V> r14 = r13;
        L5:
            if (r14 == null) goto L19;
            K r15 = r14.getKey();     // Catch: Throwable -> L17
            if (r14.getHash() != r19) goto L29;
            if (r15 == null) goto L29;
            if (this.map.keyEquivalence.equivalent(r18, r15) == false) goto L29;
            ValueReference<K, V> r16 = r14.getValueReference();     // Catch: Throwable -> L17
            V r17 = r16.get();     // Catch: Throwable -> L17
            if (r17 != null) goto L22;
            if (r16.isActive() == false) goto L19;
            this.modCount++;     // Catch: Throwable -> L17
            ReferenceEntry<K, V> r22 = removeValueFromChain(r13, r14, r15, r19, r17, r16, RemovalCause.COLLECTED);     // Catch: Throwable -> L17
            int r23 = this.count - 1;     // Catch: Throwable -> L17
            r11.set(r12, r22);     // Catch: Throwable -> L17
            this.count = r23;     // Catch: Throwable -> L17
            goto L19
        L22:
            if (this.map.valueEquivalence.equivalent(r20, r17) == false) goto L26;
            this.modCount++;     // Catch: Throwable -> L17
            enqueueNotification(r18, r19, r17, r16.getWeight(), RemovalCause.REPLACED);     // Catch: Throwable -> L17
            setValue(r14, r18, r21, r10);     // Catch: Throwable -> L17
            evictEntries(r14);     // Catch: Throwable -> L17
            unlock();
            postWriteCleanup();
            return true;
        L26:
            recordLockedRead(r14, r10);     // Catch: Throwable -> L17
        L29:
            r14 = r14.getNext();     // Catch: Throwable -> L17
        L19:
            unlock();
            postWriteCleanup();
            return false;
        L17:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        public void runLockedCleanup(long r10) {
            if (tryLock() == true) goto L10;
            return;
        L10:
            drainReferenceQueues();     // Catch: Throwable -> L6
            expireEntries(r10);     // Catch: Throwable -> L6
            this.readCount.set(0);     // Catch: Throwable -> L6
            unlock();
            return;
        L6:
            th = move-exception;
            unlock();
            throw th;
        }

        public void runUnlockedCleanup() {
            if (isHeldByCurrentThread() == true) goto L6;
            this.map.processPendingNotifications();
            return;
        }

        public V scheduleRefresh(ReferenceEntry<K, V> r10, K r11, int r12, V r13, long r14, CacheLoader<? super K, V> r15) {
            if (this.map.refreshes() == true) goto L5;
        L11:
            return r13;
        L5:
            if ((r14 - r10.getWriteTime()) <= this.map.refreshNanos) goto L11;
            if (r10.getValueReference().isLoading() == true) goto L11;
            V r16 = refresh(r11, r12, r15, true);
            if (r16 == null) goto L11;
            return r16;
        }

        @GuardedBy("this")
        public void setValue(ReferenceEntry<K, V> r10, K r11, V r12, long r13) {
            ValueReference<K, V> r14 = r10.getValueReference();
            int r15 = this.map.weigher.weigh(r11, r12);
            if (r15 < 0) goto L5;
            boolean r16 = true;
        L6:
            Preconditions.checkState(r16, "Weights must be non-negative");
            r10.setValueReference(this.map.valueStrength.referenceValue(this, r10, r12, r15));
            recordWrite(r10, r15, r13);
            r14.notifyNewValue(r12);
            return;
        L5:
            r16 = false;
            goto L6
        }

        public boolean storeLoadedValue(K r16, int r17, LoadingValueReference<K, V> r18, V r19) {
            lock();
            long r10 = this.map.ticker.read();     // Catch: Throwable -> L7
            preWriteCleanup(r10);     // Catch: Throwable -> L7
            int r11 = this.count + 1;     // Catch: Throwable -> L7
            if (r11 <= this.threshold) goto L6;
            expand();     // Catch: Throwable -> L7
            r11 = this.count + 1;     // Catch: Throwable -> L7
        L6:
            int r12 = r11;
            AtomicReferenceArray<ReferenceEntry<K, V>> r13 = this.table;     // Catch: Throwable -> L7
            int r14 = r17 & (r13.length() - 1);     // Catch: Throwable -> L7
            ReferenceEntry<K, V> r15 = r13.get(r14);     // Catch: Throwable -> L7
            ReferenceEntry<K, V> r110 = r15;
        L10:
            if (r110 == null) goto L37;
            K r20 = r110.getKey();     // Catch: Throwable -> L7
            if (r110.getHash() != r17) goto L36;
            if (r20 == null) goto L36;
            if (this.map.keyEquivalence.equivalent(r16, r20) == false) goto L36;
            ValueReference<K, V> r21 = r110.getValueReference();     // Catch: Throwable -> L7
            V r22 = r21.get();     // Catch: Throwable -> L7
            if (r18 == r21) goto L25;
            if (r22 == null) goto L20;
        L22:
            enqueueNotification(r16, r17, r19, 0, RemovalCause.REPLACED);     // Catch: Throwable -> L7
            unlock();
            postWriteCleanup();
            return false;
        L20:
            if (r21 == LocalCache.UNSET) goto L22;
        L25:
            this.modCount++;     // Catch: Throwable -> L7
            if (r18.isActive() == false) goto L32;
            if (r22 != null) goto L30;
            RemovalCause r23 = RemovalCause.COLLECTED;     // Catch: Throwable -> L7
        L31:
            enqueueNotification(r16, r17, r22, r18.getWeight(), r23);     // Catch: Throwable -> L7
            r12 = r12 - 1;     // Catch: Throwable -> L7
            goto L32
        L30:
            r23 = RemovalCause.REPLACED;     // Catch: Throwable -> L7
        L32:
            setValue(r110, r16, r19, r10);     // Catch: Throwable -> L7
            this.count = r12;     // Catch: Throwable -> L7
            evictEntries(r110);     // Catch: Throwable -> L7
        L33:
            unlock();
            postWriteCleanup();
            return true;
        L36:
            r110 = r110.getNext();     // Catch: Throwable -> L7
            goto L10
        L37:
            this.modCount++;     // Catch: Throwable -> L7
            ReferenceEntry<K, V> r111 = newEntry(r16, r17, r15);     // Catch: Throwable -> L7
            setValue(r111, r16, r19, r10);     // Catch: Throwable -> L7
            r13.set(r14, r111);     // Catch: Throwable -> L7
            this.count = r12;     // Catch: Throwable -> L7
            evictEntries(r111);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        public void tryDrainReferenceQueues() {
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

        public void tryExpireEntries(long r10) {
            if (tryLock() == true) goto L10;
            return;
        L10:
            expireEntries(r10);     // Catch: Throwable -> L6
            unlock();
            return;
        L6:
            th = move-exception;
            unlock();
            throw th;
        }

        public V waitForLoadingValue(ReferenceEntry<K, V> r10, K r11, ValueReference<K, V> r12) throws ExecutionException {
            if (r12.isLoading() == false) goto L17;
            Preconditions.checkState(!Thread.holdsLock(r10), "Recursive load of: %s", r11);
            V r13 = r12.waitForValue();     // Catch: Throwable -> L10
            if (r13 == null) goto L13;
            recordRead(r10, this.map.ticker.read());     // Catch: Throwable -> L10
            this.statsCounter.recordMisses(1);
            return r13;
        L13:
            throw new CacheLoader.InvalidCacheLoadException("CacheLoader returned null for key " + r11 + LibrarianImpl.Constants.DOT);     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            this.statsCounter.recordMisses(1);
            throw th;
        L17:
            throw new AssertionError();
        }

        @NullableDecl
        public V get(Object r11, int r12) {
        L13:
            th = move-exception;
            postReadCleanup();
            throw th;
        L3:
            if (this.count == 0) goto L16;
            long r10 = this.map.ticker.read();     // Catch: Throwable -> L13
            ReferenceEntry<K, V> r13 = getLiveEntry(r11, r12, r10);     // Catch: Throwable -> L13
            if (r13 != null) goto L8;
            postReadCleanup();
            return null;
        L8:
            V r14 = r13.getValueReference().get();     // Catch: Throwable -> L13
            if (r14 == null) goto L15;
            recordRead(r13, r10);     // Catch: Throwable -> L13
            V r15 = scheduleRefresh(r13, r13.getKey(), r12, r14, r10, this.map.defaultLoader);     // Catch: Throwable -> L13
            postReadCleanup();
            return r15;
        L15:
            tryDrainReferenceQueues();     // Catch: Throwable -> L13
        L16:
            postReadCleanup();
            return null;
        }

        public boolean remove(Object r13, int r14, Object r15) {
            lock();
            preWriteCleanup(this.map.ticker.read());     // Catch: Throwable -> L14
            AtomicReferenceArray<ReferenceEntry<K, V>> r10 = this.table;     // Catch: Throwable -> L14
            boolean r11 = true;
            int r12 = (r10.length() - 1) & r14;     // Catch: Throwable -> L14
            ReferenceEntry<K, V> r16 = r10.get(r12);     // Catch: Throwable -> L14
            ReferenceEntry<K, V> r17 = r16;
        L5:
            if (r17 == null) goto L26;
            K r18 = r17.getKey();     // Catch: Throwable -> L14
            if (r17.getHash() != r14) goto L28;
            if (r18 == null) goto L28;
            if (this.map.keyEquivalence.equivalent(r13, r18) == false) goto L28;
            ValueReference<K, V> r19 = r17.getValueReference();     // Catch: Throwable -> L14
            V r20 = r19.get();     // Catch: Throwable -> L14
            if (this.map.valueEquivalence.equivalent(r15, r20) == false) goto L16;
            RemovalCause r110 = RemovalCause.EXPLICIT;     // Catch: Throwable -> L14
        L20:
            this.modCount++;     // Catch: Throwable -> L14
            ReferenceEntry<K, V> r111 = removeValueFromChain(r16, r17, r18, r14, r20, r19, r110);     // Catch: Throwable -> L14
            int r112 = this.count - 1;     // Catch: Throwable -> L14
            r10.set(r12, r111);     // Catch: Throwable -> L14
            this.count = r112;     // Catch: Throwable -> L14
            if (r110 == RemovalCause.EXPLICIT) goto L24;
            r11 = false;
        L24:
            unlock();
            postWriteCleanup();
            return r11;
        L16:
            if (r20 != null) goto L26;
            if (r19.isActive() == false) goto L26;
            r110 = RemovalCause.COLLECTED;     // Catch: Throwable -> L14
        L28:
            r17 = r17.getNext();     // Catch: Throwable -> L14
        L26:
            unlock();
            postWriteCleanup();
            return false;
        L14:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        @NullableDecl
        public V replace(K r18, int r19, V r20) {
            lock();
            long r10 = this.map.ticker.read();     // Catch: Throwable -> L17
            preWriteCleanup(r10);     // Catch: Throwable -> L17
            AtomicReferenceArray<ReferenceEntry<K, V>> r11 = this.table;     // Catch: Throwable -> L17
            int r12 = r19 & (r11.length() - 1);     // Catch: Throwable -> L17
            ReferenceEntry<K, V> r13 = r11.get(r12);     // Catch: Throwable -> L17
            ReferenceEntry<K, V> r14 = r13;
        L5:
            if (r14 == null) goto L19;
            K r15 = r14.getKey();     // Catch: Throwable -> L17
            if (r14.getHash() != r19) goto L25;
            if (r15 == null) goto L25;
            if (this.map.keyEquivalence.equivalent(r18, r15) == false) goto L25;
            ValueReference<K, V> r16 = r14.getValueReference();     // Catch: Throwable -> L17
            V r17 = r16.get();     // Catch: Throwable -> L17
            if (r17 == null) goto L14;
            this.modCount++;     // Catch: Throwable -> L17
            enqueueNotification(r18, r19, r17, r16.getWeight(), RemovalCause.REPLACED);     // Catch: Throwable -> L17
            setValue(r14, r18, r20, r10);     // Catch: Throwable -> L17
            evictEntries(r14);     // Catch: Throwable -> L17
            unlock();
            postWriteCleanup();
            return r17;
        L14:
            if (r16.isActive() == false) goto L19;
            this.modCount++;     // Catch: Throwable -> L17
            ReferenceEntry<K, V> r21 = removeValueFromChain(r13, r14, r15, r19, r17, r16, RemovalCause.COLLECTED);     // Catch: Throwable -> L17
            int r22 = this.count - 1;     // Catch: Throwable -> L17
            r11.set(r12, r21);     // Catch: Throwable -> L17
            this.count = r22;     // Catch: Throwable -> L17
        L25:
            r14 = r14.getNext();     // Catch: Throwable -> L17
        L19:
            unlock();
            postWriteCleanup();
            return null;
        L17:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }
    }

    public static class SoftValueReference<K, V> extends SoftReference<V> implements ValueReference<K, V> {
        final ReferenceEntry<K, V> entry;

        public SoftValueReference(ReferenceQueue<V> r10, V r11, ReferenceEntry<K, V> r12) {
            super(r11, r10);
            this.entry = r12;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference<K, V> copyFor(ReferenceQueue<V> r10, V r11, ReferenceEntry<K, V> r12) {
            return new SoftValueReference(r10, r11, r12);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ReferenceEntry<K, V> getEntry() {
            return this.entry;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void notifyNewValue(V r10) {
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V waitForValue() {
            return get();
        }
    }

    public static abstract enum Strength extends Enum<Strength> {
        private static final /* synthetic */ Strength[] $VALUES = null;
        public static final Strength SOFT = null;
        public static final Strength STRONG = null;
        public static final Strength WEAK = null;

        static {
            final String r10 = "STRONG";
            final int r11 = 0;
            Strength r12 = new AnonymousClass1(r10, r11);
            STRONG = r12;
            final String r13 = "SOFT";
            final int r14 = 1;
            Strength r15 = new AnonymousClass2(r13, r14);
            SOFT = r15;
            final String r16 = "WEAK";
            final int r17 = 2;
            Strength r18 = new AnonymousClass3(r16, r17);
            WEAK = r18;
            $VALUES = new Strength[]{r12, r15, r18};
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

        public abstract <K, V> ValueReference<K, V> referenceValue(Segment<K, V> r10, ReferenceEntry<K, V> r11, V r12, int r13);

        public /* synthetic */ Strength(String r10, int r11, AnonymousClass1 r12) {
            this(r10, r11);
        }
    }

    public static final class StrongAccessEntry<K, V> extends StrongEntry<K, V> {
        volatile long accessTime;
        ReferenceEntry<K, V> nextAccess;
        ReferenceEntry<K, V> previousAccess;

        public StrongAccessEntry(K r10, int r11, @NullableDecl ReferenceEntry<K, V> r12) {
            super(r10, r11, r12);
            this.accessTime = Long.MAX_VALUE;
            this.nextAccess = LocalCache.nullEntry();
            this.previousAccess = LocalCache.nullEntry();
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            return this.accessTime;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.nextAccess;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.previousAccess;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setAccessTime(long r10) {
            this.accessTime = r10;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry<K, V> r10) {
            this.nextAccess = r10;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry<K, V> r10) {
            this.previousAccess = r10;
        }
    }

    public static final class StrongAccessWriteEntry<K, V> extends StrongEntry<K, V> {
        volatile long accessTime;
        ReferenceEntry<K, V> nextAccess;
        ReferenceEntry<K, V> nextWrite;
        ReferenceEntry<K, V> previousAccess;
        ReferenceEntry<K, V> previousWrite;
        volatile long writeTime;

        public StrongAccessWriteEntry(K r10, int r11, @NullableDecl ReferenceEntry<K, V> r12) {
            super(r10, r11, r12);
            this.accessTime = Long.MAX_VALUE;
            this.nextAccess = LocalCache.nullEntry();
            this.previousAccess = LocalCache.nullEntry();
            this.writeTime = Long.MAX_VALUE;
            this.nextWrite = LocalCache.nullEntry();
            this.previousWrite = LocalCache.nullEntry();
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            return this.accessTime;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.nextAccess;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.nextWrite;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.previousAccess;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.previousWrite;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            return this.writeTime;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setAccessTime(long r10) {
            this.accessTime = r10;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry<K, V> r10) {
            this.nextAccess = r10;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry<K, V> r10) {
            this.nextWrite = r10;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry<K, V> r10) {
            this.previousAccess = r10;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry<K, V> r10) {
            this.previousWrite = r10;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setWriteTime(long r10) {
            this.writeTime = r10;
        }
    }

    public static class StrongEntry<K, V> extends AbstractReferenceEntry<K, V> {
        final int hash;
        final K key;

        @NullableDecl
        final ReferenceEntry<K, V> next;
        volatile ValueReference<K, V> valueReference;

        public StrongEntry(K r10, int r11, @NullableDecl ReferenceEntry<K, V> r12) {
            this.valueReference = LocalCache.unset();
            this.key = r10;
            this.hash = r11;
            this.next = r12;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public int getHash() {
            return this.hash;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public K getKey() {
            return this.key;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNext() {
            return this.next;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ValueReference<K, V> getValueReference() {
            return this.valueReference;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setValueReference(ValueReference<K, V> r10) {
            this.valueReference = r10;
        }
    }

    public static class StrongValueReference<K, V> implements ValueReference<K, V> {
        final V referent;

        public StrongValueReference(V r10) {
            this.referent = r10;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference<K, V> copyFor(ReferenceQueue<V> r10, V r11, ReferenceEntry<K, V> r12) {
            return this;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V get() {
            return this.referent;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ReferenceEntry<K, V> getEntry() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void notifyNewValue(V r10) {
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V waitForValue() {
            return get();
        }
    }

    public static final class StrongWriteEntry<K, V> extends StrongEntry<K, V> {
        ReferenceEntry<K, V> nextWrite;
        ReferenceEntry<K, V> previousWrite;
        volatile long writeTime;

        public StrongWriteEntry(K r10, int r11, @NullableDecl ReferenceEntry<K, V> r12) {
            super(r10, r11, r12);
            this.writeTime = Long.MAX_VALUE;
            this.nextWrite = LocalCache.nullEntry();
            this.previousWrite = LocalCache.nullEntry();
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.nextWrite;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.previousWrite;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            return this.writeTime;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry<K, V> r10) {
            this.nextWrite = r10;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry<K, V> r10) {
            this.previousWrite = r10;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setWriteTime(long r10) {
            this.writeTime = r10;
        }
    }

    public final class ValueIterator extends LocalCache<K, V>.HashIterator<V> {
        final /* synthetic */ LocalCache this$0;

        public ValueIterator(LocalCache r10) {
            this.this$0 = r10;
            super(r10);
        }

        @Override // com.google.common.cache.LocalCache.HashIterator, java.util.Iterator
        public V next() {
            return nextEntry().getValue();
        }
    }

    public interface ValueReference<K, V> {
        ValueReference<K, V> copyFor(ReferenceQueue<V> r10, @NullableDecl V r11, ReferenceEntry<K, V> r12);

        @NullableDecl
        V get();

        @NullableDecl
        ReferenceEntry<K, V> getEntry();

        int getWeight();

        boolean isActive();

        boolean isLoading();

        void notifyNewValue(@NullableDecl V r10);

        V waitForValue() throws ExecutionException;
    }

    public final class Values extends AbstractCollection<V> {
        private final ConcurrentMap<?, ?> map;
        final /* synthetic */ LocalCache this$0;

        public Values(LocalCache r10, ConcurrentMap<?, ?> r11) {
            this.this$0 = r10;
            this.map = r11;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.map.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object r10) {
            return this.map.containsValue(r10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.map.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new ValueIterator(this.this$0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.map.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return LocalCache.access$200(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <E> E[] toArray(E[] r10) {
            return (E[]) LocalCache.access$200(this).toArray(r10);
        }
    }

    public static final class WeakAccessEntry<K, V> extends WeakEntry<K, V> {
        volatile long accessTime;
        ReferenceEntry<K, V> nextAccess;
        ReferenceEntry<K, V> previousAccess;

        public WeakAccessEntry(ReferenceQueue<K> r10, K r11, int r12, @NullableDecl ReferenceEntry<K, V> r13) {
            super(r10, r11, r12, r13);
            this.accessTime = Long.MAX_VALUE;
            this.nextAccess = LocalCache.nullEntry();
            this.previousAccess = LocalCache.nullEntry();
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            return this.accessTime;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.nextAccess;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.previousAccess;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setAccessTime(long r10) {
            this.accessTime = r10;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry<K, V> r10) {
            this.nextAccess = r10;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry<K, V> r10) {
            this.previousAccess = r10;
        }
    }

    public static final class WeakAccessWriteEntry<K, V> extends WeakEntry<K, V> {
        volatile long accessTime;
        ReferenceEntry<K, V> nextAccess;
        ReferenceEntry<K, V> nextWrite;
        ReferenceEntry<K, V> previousAccess;
        ReferenceEntry<K, V> previousWrite;
        volatile long writeTime;

        public WeakAccessWriteEntry(ReferenceQueue<K> r10, K r11, int r12, @NullableDecl ReferenceEntry<K, V> r13) {
            super(r10, r11, r12, r13);
            this.accessTime = Long.MAX_VALUE;
            this.nextAccess = LocalCache.nullEntry();
            this.previousAccess = LocalCache.nullEntry();
            this.writeTime = Long.MAX_VALUE;
            this.nextWrite = LocalCache.nullEntry();
            this.previousWrite = LocalCache.nullEntry();
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            return this.accessTime;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.nextAccess;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.nextWrite;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.previousAccess;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.previousWrite;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            return this.writeTime;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setAccessTime(long r10) {
            this.accessTime = r10;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry<K, V> r10) {
            this.nextAccess = r10;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry<K, V> r10) {
            this.nextWrite = r10;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry<K, V> r10) {
            this.previousAccess = r10;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry<K, V> r10) {
            this.previousWrite = r10;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setWriteTime(long r10) {
            this.writeTime = r10;
        }
    }

    public static class WeakEntry<K, V> extends WeakReference<K> implements ReferenceEntry<K, V> {
        final int hash;

        @NullableDecl
        final ReferenceEntry<K, V> next;
        volatile ValueReference<K, V> valueReference;

        public WeakEntry(ReferenceQueue<K> r10, K r11, int r12, @NullableDecl ReferenceEntry<K, V> r13) {
            super(r11, r10);
            this.valueReference = LocalCache.unset();
            this.hash = r12;
            this.next = r13;
        }

        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public int getHash() {
            return this.hash;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public K getKey() {
            return get();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNext() {
            return this.next;
        }

        public ReferenceEntry<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ValueReference<K, V> getValueReference() {
            return this.valueReference;
        }

        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        public void setAccessTime(long r10) {
            throw new UnsupportedOperationException();
        }

        public void setNextInAccessQueue(ReferenceEntry<K, V> r10) {
            throw new UnsupportedOperationException();
        }

        public void setNextInWriteQueue(ReferenceEntry<K, V> r10) {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInAccessQueue(ReferenceEntry<K, V> r10) {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInWriteQueue(ReferenceEntry<K, V> r10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setValueReference(ValueReference<K, V> r10) {
            this.valueReference = r10;
        }

        public void setWriteTime(long r10) {
            throw new UnsupportedOperationException();
        }
    }

    public static class WeakValueReference<K, V> extends WeakReference<V> implements ValueReference<K, V> {
        final ReferenceEntry<K, V> entry;

        public WeakValueReference(ReferenceQueue<V> r10, V r11, ReferenceEntry<K, V> r12) {
            super(r11, r10);
            this.entry = r12;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference<K, V> copyFor(ReferenceQueue<V> r10, V r11, ReferenceEntry<K, V> r12) {
            return new WeakValueReference(r10, r11, r12);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ReferenceEntry<K, V> getEntry() {
            return this.entry;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void notifyNewValue(V r10) {
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V waitForValue() {
            return get();
        }
    }

    public static final class WeakWriteEntry<K, V> extends WeakEntry<K, V> {
        ReferenceEntry<K, V> nextWrite;
        ReferenceEntry<K, V> previousWrite;
        volatile long writeTime;

        public WeakWriteEntry(ReferenceQueue<K> r10, K r11, int r12, @NullableDecl ReferenceEntry<K, V> r13) {
            super(r10, r11, r12, r13);
            this.writeTime = Long.MAX_VALUE;
            this.nextWrite = LocalCache.nullEntry();
            this.previousWrite = LocalCache.nullEntry();
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.nextWrite;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.previousWrite;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            return this.writeTime;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry<K, V> r10) {
            this.nextWrite = r10;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry<K, V> r10) {
            this.previousWrite = r10;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setWriteTime(long r10) {
            this.writeTime = r10;
        }
    }

    public static final class WeightedSoftValueReference<K, V> extends SoftValueReference<K, V> {
        final int weight;

        public WeightedSoftValueReference(ReferenceQueue<V> r10, V r11, ReferenceEntry<K, V> r12, int r13) {
            super(r10, r11, r12);
            this.weight = r13;
        }

        @Override // com.google.common.cache.LocalCache.SoftValueReference, com.google.common.cache.LocalCache.ValueReference
        public ValueReference<K, V> copyFor(ReferenceQueue<V> r10, V r11, ReferenceEntry<K, V> r12) {
            return new WeightedSoftValueReference(r10, r11, r12, this.weight);
        }

        @Override // com.google.common.cache.LocalCache.SoftValueReference, com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return this.weight;
        }
    }

    public static final class WeightedStrongValueReference<K, V> extends StrongValueReference<K, V> {
        final int weight;

        public WeightedStrongValueReference(V r10, int r11) {
            super(r10);
            this.weight = r11;
        }

        @Override // com.google.common.cache.LocalCache.StrongValueReference, com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return this.weight;
        }
    }

    public static final class WeightedWeakValueReference<K, V> extends WeakValueReference<K, V> {
        final int weight;

        public WeightedWeakValueReference(ReferenceQueue<V> r10, V r11, ReferenceEntry<K, V> r12, int r13) {
            super(r10, r11, r12);
            this.weight = r13;
        }

        @Override // com.google.common.cache.LocalCache.WeakValueReference, com.google.common.cache.LocalCache.ValueReference
        public ValueReference<K, V> copyFor(ReferenceQueue<V> r10, V r11, ReferenceEntry<K, V> r12) {
            return new WeightedWeakValueReference(r10, r11, r12, this.weight);
        }

        @Override // com.google.common.cache.LocalCache.WeakValueReference, com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return this.weight;
        }
    }

    public static final class WriteQueue<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {
        final ReferenceEntry<K, V> head;

        public WriteQueue() {
            this.head = new AnonymousClass1(this);
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            ReferenceEntry<K, V> r10 = this.head.getNextInWriteQueue();
        L3:
            ReferenceEntry<K, V> r11 = this.head;
            if (r10 == r11) goto L6;
            ReferenceEntry<K, V> r12 = r10.getNextInWriteQueue();
            LocalCache.nullifyWriteOrder(r10);
            r10 = r12;
            goto L3
        L6:
            r11.setNextInWriteQueue(r11);
            ReferenceEntry<K, V> r13 = this.head;
            r13.setPreviousInWriteQueue(r13);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object r10) {
            if (((ReferenceEntry) r10).getNextInWriteQueue() == NullEntry.INSTANCE) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            if (this.head.getNextInWriteQueue() != this.head) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<ReferenceEntry<K, V>> iterator() {
            final ReferenceEntry<K, V> r10 = peek();
            return new AnonymousClass2(this, r10);
        }

        @Override // java.util.Queue
        public /* bridge */ /* synthetic */ boolean offer(Object r10) {
            return offer((ReferenceEntry) r10);
        }

        @Override // java.util.Queue
        public /* bridge */ /* synthetic */ Object peek() {
            return peek();
        }

        @Override // java.util.Queue
        public /* bridge */ /* synthetic */ Object poll() {
            return poll();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object r10) {
            ReferenceEntry r11 = (ReferenceEntry) r10;
            ReferenceEntry<K, V> r12 = r11.getPreviousInWriteQueue();
            ReferenceEntry<K, V> r13 = r11.getNextInWriteQueue();
            LocalCache.connectWriteOrder(r12, r13);
            LocalCache.nullifyWriteOrder(r11);
            if (r13 == NullEntry.INSTANCE) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            ReferenceEntry<K, V> r10 = this.head.getNextInWriteQueue();
            int r11 = 0;
        L4:
            if (r10 == this.head) goto L6;
            r11 = r11 + 1;
            r10 = r10.getNextInWriteQueue();
            goto L4
        L6:
            return r11;
        }

        public boolean offer(ReferenceEntry<K, V> r10) {
            LocalCache.connectWriteOrder(r10.getPreviousInWriteQueue(), r10.getNextInWriteQueue());
            LocalCache.connectWriteOrder(this.head.getPreviousInWriteQueue(), r10);
            LocalCache.connectWriteOrder(r10, this.head);
            return true;
        }

        @Override // java.util.Queue
        public ReferenceEntry<K, V> peek() {
            ReferenceEntry<K, V> r10 = this.head.getNextInWriteQueue();
            if (r10 != this.head) goto L6;
            return null;
        L6:
            return r10;
        }

        @Override // java.util.Queue
        public ReferenceEntry<K, V> poll() {
            ReferenceEntry<K, V> r10 = this.head.getNextInWriteQueue();
            if (r10 != this.head) goto L6;
            return null;
        L6:
            remove(r10);
            return r10;
        }
    }

    public final class WriteThroughEntry implements Map.Entry<K, V> {
        final K key;
        final /* synthetic */ LocalCache this$0;
        V value;

        public WriteThroughEntry(LocalCache r10, K r11, V r12) {
            this.this$0 = r10;
            this.key = r11;
            this.value = r12;
        }

        @Override // java.util.Map.Entry
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

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int r10 = this.key.hashCode();
            return this.value.hashCode() ^ r10;
        }

        @Override // java.util.Map.Entry
        public V setValue(V r10) {
            V r11 = (V) this.this$0.put(this.key, r10);
            this.value = r10;
            return r11;
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    static {
        logger = Logger.getLogger(LocalCache.class.getName());
        UNSET = new AnonymousClass1();
        DISCARDING_QUEUE = new AnonymousClass2();
    }

    public LocalCache(CacheBuilder<? super K, ? super V> r12, @NullableDecl CacheLoader<? super K, V> r13) {
        this.concurrencyLevel = Math.min(r12.getConcurrencyLevel(), 65536);
        Strength r10 = r12.getKeyStrength();
        this.keyStrength = r10;
        this.valueStrength = r12.getValueStrength();
        this.keyEquivalence = r12.getKeyEquivalence();
        this.valueEquivalence = r12.getValueEquivalence();
        long r11 = r12.getMaximumWeight();
        this.maxWeight = r11;
        this.weigher = (Weigher<K, V>) r12.getWeigher();
        this.expireAfterAccessNanos = r12.getExpireAfterAccessNanos();
        this.expireAfterWriteNanos = r12.getExpireAfterWriteNanos();
        this.refreshNanos = r12.getRefreshNanos();
        CacheBuilder.NullListener r14 = (RemovalListener<K, V>) r12.getRemovalListener();
        this.removalListener = r14;
        if (r14 != CacheBuilder.NullListener.INSTANCE) goto L5;
        Queue<RemovalNotification<K, V>> r15 = discardingQueue();
    L6:
        this.removalNotificationQueue = r15;
        this.ticker = r12.getTicker(recordsTime());
        this.entryFactory = EntryFactory.getFactory(r10, usesAccessEntries(), usesWriteEntries());
        this.globalStatsCounter = r12.getStatsCounterSupplier().get();
        this.defaultLoader = r13;
        int r16 = Math.min(r12.getInitialCapacity(), 1073741824);
        if (evictsBySize() == true) goto L9;
    L11:
        int r17 = 0;
        int r18 = 1;
        int r19 = 0;
        int r20 = 1;
    L13:
        if (r20 >= this.concurrencyLevel) goto L19;
        if (evictsBySize() == false) goto L18;
        if ((r20 * 20) > this.maxWeight) goto L19;
    L18:
        r19 = r19 + 1;
        r20 = r20 << 1;
    L19:
        this.segmentShift = 32 - r19;
        this.segmentMask = r20 - 1;
        this.segments = newSegmentArray(r20);
        int r21 = r16 / r20;
        if ((r21 * r20) >= r16) goto L22;
        r21 = r21 + 1;
    L22:
        if (r18 >= r21) goto L25;
        r18 = r18 << 1;
        goto L22
    L25:
        if (evictsBySize() == false) goto L33;
        long r22 = this.maxWeight;
        long r23 = r20;
        long r24 = (r22 / r23) + 1;
        long r25 = r22 % r23;
    L27:
        Segment<K, V>[] r110 = this.segments;
        if (r17 >= r110.length) goto L36;
        if (r17 != r25) goto L32;
        r24 = r24 - 1;
    L32:
        r110[r17] = createSegment(r18, r24, r12.getStatsCounterSupplier().get());
        r17 = r17 + 1;
        goto L27
    L36:
        return;
    L33:
        Segment<K, V>[] r111 = this.segments;
        if (r17 >= r111.length) goto L47;
        r111[r17] = createSegment(r18, -1, r12.getStatsCounterSupplier().get());
        r17 = r17 + 1;
        goto L33
    L47:
        return;
    L9:
        if (customWeigher() == true) goto L11;
        r16 = (int) Math.min(r16, r11);
        goto L11
    L5:
        r15 = new ConcurrentLinkedQueue();
        goto L6
    }

    public static /* synthetic */ ArrayList access$200(Collection r10) {
        return toArrayList(r10);
    }

    public static <K, V> void connectAccessOrder(ReferenceEntry<K, V> r10, ReferenceEntry<K, V> r11) {
        r10.setNextInAccessQueue(r11);
        r11.setPreviousInAccessQueue(r10);
    }

    public static <K, V> void connectWriteOrder(ReferenceEntry<K, V> r10, ReferenceEntry<K, V> r11) {
        r10.setNextInWriteQueue(r11);
        r11.setPreviousInWriteQueue(r10);
    }

    public static <E> Queue<E> discardingQueue() {
        return (Queue<E>) DISCARDING_QUEUE;
    }

    public static <K, V> ReferenceEntry<K, V> nullEntry() {
        return NullEntry.INSTANCE;
    }

    public static <K, V> void nullifyAccessOrder(ReferenceEntry<K, V> r10) {
        ReferenceEntry<K, V> r11 = nullEntry();
        r10.setNextInAccessQueue(r11);
        r10.setPreviousInAccessQueue(r11);
    }

    public static <K, V> void nullifyWriteOrder(ReferenceEntry<K, V> r10) {
        ReferenceEntry<K, V> r11 = nullEntry();
        r10.setNextInWriteQueue(r11);
        r10.setPreviousInWriteQueue(r11);
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

    public static <K, V> ValueReference<K, V> unset() {
        return (ValueReference<K, V>) UNSET;
    }

    public void cleanUp() {
        Segment<K, V>[] r10 = this.segments;
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10[r12].cleanUp();
        r12 = r12 + 1;
        goto L3
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Segment<K, V>[] r10 = this.segments;
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
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [int] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [int] */
    /* JADX WARN: Type inference failed for: r15v3 */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@NullableDecl Object r20) {
        boolean r10 = false;
        if (r20 != null) goto L5;
        return false;
    L5:
        long r11 = this.ticker.read();
        Segment<K, V>[] r12 = this.segments;
        long r13 = -1;
        int r14 = 0;
    L7:
        if (r14 >= 3) goto L29;
        int r15 = r12.length;
        long r16 = 0;
        ?? r17 = r10;
    L9:
        if (r17 >= r15) goto L24;
        Segment<K, V> r18 = r12[r17];
        int r19 = r18.count;
        AtomicReferenceArray<ReferenceEntry<K, V>> r110 = r18.table;
        ?? r111 = r10;
    L12:
        if (r111 >= r110.length()) goto L23;
        ReferenceEntry<K, V> r21 = r110.get(r111);
    L14:
        if (r21 == null) goto L22;
        Segment<K, V>[] r112 = r12;
        V r22 = r18.getLiveValue(r21, r11);
        long r113 = r11;
        if (r22 == null) goto L21;
        if (this.valueEquivalence.equivalent(r20, r22) == false) goto L21;
        return true;
    L21:
        r21 = r21.getNext();
        r12 = r112;
        r11 = r113;
        goto L14
    L22:
        r111 = r111 + 1;
        goto L12
    L23:
        r16 = r16 + ((long) r18.modCount);
        r11 = r11;
        r10 = false;
        r17 = r17 + 1;
        goto L9
    L24:
        long r114 = r11;
        Segment<K, V>[] r115 = r12;
        if (r16 == r13) goto L26;
        r14 = r14 + 1;
        r13 = r16;
        r12 = r115;
        r11 = r114;
        r10 = false;
        goto L7
    L26:
        return false;
    L29:
        return r10;
    }

    @VisibleForTesting
    public ReferenceEntry<K, V> copyEntry(ReferenceEntry<K, V> r10, ReferenceEntry<K, V> r11) {
        return segmentFor(r10.getHash()).copyEntry(r10, r11);
    }

    public Segment<K, V> createSegment(int r10, long r11, AbstractCache.StatsCounter r12) {
        return new Segment(this, r10, r11, r12);
    }

    public boolean customWeigher() {
        if (this.weigher == CacheBuilder.OneWeigher.INSTANCE) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @GwtIncompatible
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> r10 = this.entrySet;
        if (r10 != null) goto L7;
        EntrySet r11 = new EntrySet(this, this);
        this.entrySet = r11;
        return r11;
    L7:
        return r10;
    }

    public boolean evictsBySize() {
        if (this.maxWeight < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean expires() {
        if (expiresAfterWrite() == false) goto L5;
    L8:
        return true;
    L5:
        if (expiresAfterAccess() == true) goto L8;
        return false;
    }

    public boolean expiresAfterAccess() {
        if (this.expireAfterAccessNanos <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean expiresAfterWrite() {
        if (this.expireAfterWriteNanos <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @NullableDecl
    public V get(@NullableDecl Object r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        int r11 = hash(r10);
        return segmentFor(r11).get(r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImmutableMap<K, V> getAll(Iterable<? extends K> r10) throws ExecutionException {
        LinkedHashMap r11 = Maps.newLinkedHashMap();
        LinkedHashSet r12 = Sets.newLinkedHashSet();
        Iterator<? extends K> r13 = r10.iterator();
        int r14 = 0;
        int r15 = 0;
    L4:
        if (r13.hasNext() == false) goto L32;
        K r16 = r13.next();
        Object r17 = get(r16);
        if (r11.containsKey(r16) == true) goto L4;
        r11.put(r16, r17);
        if (r17 == null) goto L9;
        r14 = r14 + 1;
        goto L4
    L9:
        r15 = r15 + 1;
        r12.add(r16);
        goto L4
    L32:
    L19:
        th = move-exception;
        this.globalStatsCounter.recordHits(r14);
        this.globalStatsCounter.recordMisses(r15);
        throw th;
    L12:
        if (r12.isEmpty() == false) goto L33;
    L27:
        ImmutableMap<K, V> r18 = ImmutableMap.copyOf(r11);     // Catch: Throwable -> L19
        this.globalStatsCounter.recordHits(r14);
        this.globalStatsCounter.recordMisses(r15);
        return r18;
    L33:
        Map r19 = loadAll(r12, this.defaultLoader);     // Catch: Throwable -> L19 CacheLoader.UnsupportedLoadingOperationException -> L23
        Iterator r20 = r12.iterator();     // Catch: Throwable -> L19 CacheLoader.UnsupportedLoadingOperationException -> L23
    L15:
        if (r20.hasNext() == false) goto L27;
        Object r21 = r20.next();     // Catch: Throwable -> L19 CacheLoader.UnsupportedLoadingOperationException -> L23
        Object r22 = r19.get(r21);     // Catch: Throwable -> L19 CacheLoader.UnsupportedLoadingOperationException -> L23
        if (r22 == null) goto L22;
        r11.put(r21, r22);     // Catch: Throwable -> L19 CacheLoader.UnsupportedLoadingOperationException -> L23
        goto L15
    L22:
        throw new CacheLoader.InvalidCacheLoadException("loadAll failed to return a value for " + r21);     // Catch: Throwable -> L19 CacheLoader.UnsupportedLoadingOperationException -> L23
    L23:
        Iterator r23 = r12.iterator();     // Catch: Throwable -> L19
    L25:
        if (r23.hasNext() == false) goto L27;
        Object r24 = r23.next();     // Catch: Throwable -> L19
        r15 = r15 - 1;     // Catch: Throwable -> L19
        r11.put(r24, get(r24, this.defaultLoader));     // Catch: Throwable -> L19
        goto L25
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImmutableMap<K, V> getAllPresent(Iterable<?> r10) {
        LinkedHashMap r11 = Maps.newLinkedHashMap();
        Iterator<?> r12 = r10.iterator();
        int r13 = 0;
        int r14 = 0;
    L4:
        if (r12.hasNext() == false) goto L9;
        Object r15 = r12.next();
        V r16 = get(r15);
        if (r16 == null) goto L7;
        r11.put(r15, r16);
        r13 = r13 + 1;
        goto L4
    L7:
        r14 = r14 + 1;
        goto L4
    L9:
        this.globalStatsCounter.recordHits(r13);
        this.globalStatsCounter.recordMisses(r14);
        return ImmutableMap.copyOf(r11);
    }

    public ReferenceEntry<K, V> getEntry(@NullableDecl Object r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        int r11 = hash(r10);
        return segmentFor(r11).getEntry(r10, r11);
    }

    @NullableDecl
    public V getIfPresent(Object r10) {
        int r11 = hash(Preconditions.checkNotNull(r10));
        V r12 = segmentFor(r11).get(r10, r11);
        if (r12 != null) goto L5;
        this.globalStatsCounter.recordMisses(1);
    L6:
        return r12;
    L5:
        this.globalStatsCounter.recordHits(1);
        goto L6
    }

    @NullableDecl
    public V getLiveValue(ReferenceEntry<K, V> r10, long r11) {
        if (r10.getKey() != null) goto L5;
        return null;
    L5:
        V r12 = r10.getValueReference().get();
        if (r12 != null) goto L9;
        return null;
    L9:
        if (isExpired(r10, r11) == false) goto L11;
        return null;
    L11:
        return r12;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @NullableDecl
    public V getOrDefault(@NullableDecl Object r10, @NullableDecl V r11) {
        V r12 = get(r10);
        if (r12 != null) goto L5;
        return r11;
    L5:
        return r12;
    }

    public V getOrLoad(K r10) throws ExecutionException {
        return get(r10, this.defaultLoader);
    }

    public int hash(@NullableDecl Object r10) {
        return rehash(this.keyEquivalence.hash(r10));
    }

    public void invalidateAll(Iterable<?> r10) {
        Iterator<?> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        remove(r11.next());
        goto L4
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        Segment<K, V>[] r10 = this.segments;
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

    public boolean isExpired(ReferenceEntry<K, V> r10, long r11) {
        Preconditions.checkNotNull(r10);
        if (expiresAfterAccess() == false) goto L8;
        if ((r11 - r10.getAccessTime()) < this.expireAfterAccessNanos) goto L8;
        return true;
    L8:
        if (expiresAfterWrite() == true) goto L10;
        return false;
    L10:
        if ((r11 - r10.getWriteTime()) < this.expireAfterWriteNanos) goto L14;
        return true;
    L14:
        return false;
    }

    @VisibleForTesting
    public boolean isLive(ReferenceEntry<K, V> r10, long r11) {
        if (segmentFor(r10.getHash()).getLiveValue(r10, r11) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> r10 = this.keySet;
        if (r10 != null) goto L7;
        KeySet r11 = new KeySet(this, this);
        this.keySet = r11;
        return r11;
    L7:
        return r10;
    }

    @NullableDecl
    public Map<K, V> loadAll(Set<? extends K> r10, CacheLoader<? super K, V> r11) throws ExecutionException {
        Preconditions.checkNotNull(r11);
        Preconditions.checkNotNull(r10);
        Stopwatch r12 = Stopwatch.createStarted();
        boolean r13 = true;
        boolean r14 = false;
        Map<? super K, V> r15 = r11.loadAll(r10);     // Catch: Throwable -> L21 Error -> L23 Exception -> L26 RuntimeException -> L29 InterruptedException -> L32 CacheLoader.UnsupportedLoadingOperationException -> L35
        if (r15 == null) goto L19;
        r12.stop();
        Iterator<Map.Entry<K, V>> r16 = r15.entrySet().iterator();
    L7:
        if (r16.hasNext() == false) goto L14;
        Map.Entry<K, V> r17 = r16.next();
        K r18 = r17.getKey();
        V r19 = r17.getValue();
        if (r18 == null) goto L13;
        if (r19 == null) goto L13;
        put(r18, r19);
    L13:
        r14 = true;
        goto L7
    L14:
        if (r14 == true) goto L17;
        this.globalStatsCounter.recordLoadSuccess(r12.elapsed(TimeUnit.NANOSECONDS));
        return r15;
    L17:
        this.globalStatsCounter.recordLoadException(r12.elapsed(TimeUnit.NANOSECONDS));
        throw new CacheLoader.InvalidCacheLoadException(r11 + " returned null keys or values from loadAll");
    L19:
        this.globalStatsCounter.recordLoadException(r12.elapsed(TimeUnit.NANOSECONDS));
        throw new CacheLoader.InvalidCacheLoadException(r11 + " returned null map from loadAll");
    L21:
        th = th;
        r13 = false;
    L38:
        if (r13 == true) goto L40;
        this.globalStatsCounter.recordLoadException(r12.elapsed(TimeUnit.NANOSECONDS));
    L40:
        throw th;
    L35:
        e = move-exception;
        throw e;     // Catch: Throwable -> L37
    L37:
        th = th;
    L26:
        e = move-exception;
        throw new ExecutionException(e);     // Catch: Throwable -> L21
    L23:
        e = move-exception;
        throw new ExecutionError(e);     // Catch: Throwable -> L21
    L32:
        e = move-exception;
        Thread.currentThread().interrupt();     // Catch: Throwable -> L21
        throw new ExecutionException(e);     // Catch: Throwable -> L21
    L29:
        e = move-exception;
        throw new UncheckedExecutionException(e);     // Catch: Throwable -> L21
    }

    public long longSize() {
        Segment<K, V>[] r10 = this.segments;
        long r11 = 0;
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L6;
        r11 = r11 + ((long) Math.max(0, r10[r12].count));
        r12 = r12 + 1;
        goto L4
    L6:
        return r11;
    }

    @VisibleForTesting
    public ReferenceEntry<K, V> newEntry(K r10, int r11, @NullableDecl ReferenceEntry<K, V> r12) {
        Segment<K, V> r13 = segmentFor(r11);
        r13.lock();
        ReferenceEntry<K, V> r14 = r13.newEntry(r10, r11, r12);     // Catch: Throwable -> L6
        r13.unlock();
        return r14;
    L6:
        th = move-exception;
        r13.unlock();
        throw th;
    }

    public final Segment<K, V>[] newSegmentArray(int r10) {
        return new Segment[r10];
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @VisibleForTesting
    public ValueReference<K, V> newValueReference(ReferenceEntry<K, V> r10, V r11, int r12) {
        int r13 = r10.getHash();
        return this.valueStrength.referenceValue(segmentFor(r13), r10, Preconditions.checkNotNull(r11), r12);
    }

    public void processPendingNotifications() {
    L2:
        RemovalNotification<K, V> r10 = this.removalNotificationQueue.poll();
        if (r10 == null) goto L8;
        this.removalListener.onRemoval(r10);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        logger.log(Level.WARNING, "Exception thrown by removal listener", th);
        goto L2
    }

    @Override // java.util.AbstractMap, java.util.Map
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
    public V putIfAbsent(K r10, V r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        int r12 = hash(r10);
        return segmentFor(r12).put(r10, r12, r11, true);
    }

    public void reclaimKey(ReferenceEntry<K, V> r10) {
        int r11 = r10.getHash();
        segmentFor(r11).reclaimKey(r10, r11);
    }

    public void reclaimValue(ValueReference<K, V> r10) {
        ReferenceEntry<K, V> r11 = r10.getEntry();
        int r12 = r11.getHash();
        segmentFor(r12).reclaimValue(r11.getKey(), r12, r10);
    }

    public boolean recordsAccess() {
        return expiresAfterAccess();
    }

    public boolean recordsTime() {
        if (recordsWrite() == false) goto L5;
    L8:
        return true;
    L5:
        if (recordsAccess() == true) goto L8;
        return false;
    }

    public boolean recordsWrite() {
        if (expiresAfterWrite() == false) goto L5;
    L8:
        return true;
    L5:
        if (refreshes() == true) goto L8;
        return false;
    }

    public void refresh(K r10) {
        int r11 = hash(Preconditions.checkNotNull(r10));
        segmentFor(r11).refresh(r10, r11, this.defaultLoader, false);
    }

    public boolean refreshes() {
        if (this.refreshNanos <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(@NullableDecl Object r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        int r11 = hash(r10);
        return segmentFor(r11).remove(r10, r11);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K r10, @NullableDecl V r11, V r12) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r12);
        if (r11 != null) goto L6;
        return false;
    L6:
        int r13 = hash(r10);
        return segmentFor(r13).replace(r10, r13, r11, r12);
    }

    public Segment<K, V> segmentFor(int r10) {
        Segment<K, V>[] r11 = this.segments;
        int r12 = r10 >>> this.segmentShift;
        return r11[this.segmentMask & r12];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return Ints.saturatedCast(longSize());
    }

    public boolean usesAccessEntries() {
        if (usesAccessQueue() == false) goto L5;
    L8:
        return true;
    L5:
        if (recordsAccess() == true) goto L8;
        return false;
    }

    public boolean usesAccessQueue() {
        if (expiresAfterAccess() == false) goto L5;
    L8:
        return true;
    L5:
        if (evictsBySize() == true) goto L8;
        return false;
    }

    public boolean usesKeyReferences() {
        if (this.keyStrength == Strength.STRONG) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean usesValueReferences() {
        if (this.valueStrength == Strength.STRONG) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean usesWriteEntries() {
        if (usesWriteQueue() == false) goto L5;
    L8:
        return true;
    L5:
        if (recordsWrite() == true) goto L8;
        return false;
    }

    public boolean usesWriteQueue() {
        return expiresAfterWrite();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> r10 = this.values;
        if (r10 != null) goto L7;
        Values r11 = new Values(this, this);
        this.values = r11;
        return r11;
    L7:
        return r10;
    }

    public V get(K r10, CacheLoader<? super K, V> r11) throws ExecutionException {
        int r12 = hash(Preconditions.checkNotNull(r10));
        return segmentFor(r12).get(r10, r12, r11);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
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
    public V replace(K r10, V r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        int r12 = hash(r10);
        return segmentFor(r12).replace(r10, r12, r11);
    }
}
