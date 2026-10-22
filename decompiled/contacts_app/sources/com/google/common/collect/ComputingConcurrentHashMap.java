package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReferenceArray;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
class ComputingConcurrentHashMap<K, V> extends MapMakerInternalMap<K, V> {
    private static final long serialVersionUID = 4;
    final Function<? super K, ? extends V> computingFunction;

    private static final class ComputationExceptionReference<K, V> implements MapMakerInternalMap.ValueReference<K, V> {
        final Throwable t;

        @Override // com.google.common.collect.MapMakerInternalMap.ValueReference
        public void clear(MapMakerInternalMap.ValueReference<K, V> r1) {
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ValueReference
        public MapMakerInternalMap.ValueReference<K, V> copyFor(ReferenceQueue<V> r1, V r2, MapMakerInternalMap.ReferenceEntry<K, V> r3) {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ValueReference
        public V get() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ValueReference
        public MapMakerInternalMap.ReferenceEntry<K, V> getEntry() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ValueReference
        public boolean isComputingReference() {
            return false;
        }

        ComputationExceptionReference(Throwable r1) {
            this.t = r1;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ValueReference
        public V waitForValue() throws ExecutionException {
            throw new ExecutionException(this.t);
        }
    }

    private static final class ComputedReference<K, V> implements MapMakerInternalMap.ValueReference<K, V> {
        final V value;

        @Override // com.google.common.collect.MapMakerInternalMap.ValueReference
        public void clear(MapMakerInternalMap.ValueReference<K, V> r1) {
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ValueReference
        public MapMakerInternalMap.ValueReference<K, V> copyFor(ReferenceQueue<V> r1, V r2, MapMakerInternalMap.ReferenceEntry<K, V> r3) {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ValueReference
        public MapMakerInternalMap.ReferenceEntry<K, V> getEntry() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ValueReference
        public boolean isComputingReference() {
            return false;
        }

        ComputedReference(@Nullable V r1) {
            this.value = r1;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ValueReference
        public V get() {
            return this.value;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ValueReference
        public V waitForValue() {
            return get();
        }
    }

    static final class ComputingSegment<K, V> extends MapMakerInternalMap.Segment<K, V> {
        ComputingSegment(MapMakerInternalMap<K, V> r1, int r2, int r3) {
            super(r1, r2, r3);
        }

        V getOrCompute(K r11, int r12, Function<? super K, ? extends V> r13) throws ExecutionException {
        L66:
            MapMakerInternalMap.ReferenceEntry<K, V> r0 = getEntry(r11, r12);     // Catch: Throwable -> L63
            if (r0 == null) goto L9;
            V r1 = getLiveValue(r0);     // Catch: Throwable -> L63
            if (r1 == null) goto L9;
            recordRead(r0);     // Catch: Throwable -> L63
            postReadCleanup();
            return r1;
        L9:
            boolean r2 = false;
            if (r0 != null) goto L12;
        L13:
            lock();     // Catch: Throwable -> L63
            preWriteCleanup();     // Catch: Throwable -> L60
            int r3 = this.count - 1;     // Catch: Throwable -> L60
            AtomicReferenceArray<MapMakerInternalMap.ReferenceEntry<K, V>> r4 = this.table;     // Catch: Throwable -> L60
            int r5 = (r4.length() - 1) & r12;     // Catch: Throwable -> L60
            MapMakerInternalMap.ReferenceEntry<K, V> r6 = r4.get(r5);     // Catch: Throwable -> L60
            MapMakerInternalMap.ReferenceEntry<K, V> r7 = r6;
        L15:
            if (r7 == null) goto L38;
            K r8 = r7.getKey();     // Catch: Throwable -> L60
            if (r7.getHash() != r12) goto L37;
            if (r8 == null) goto L37;
            if (this.map.keyEquivalence.equivalent(r11, r8) == false) goto L37;
            if (r7.getValueReference().isComputingReference() == false) goto L24;
            boolean r9 = false;
        L39:
            if (r9 == false) goto L45;
            ComputingValueReference<K, V> r10 = new ComputingValueReference(r13);     // Catch: Throwable -> L60
            if (r7 != null) goto L43;
            MapMakerInternalMap.ReferenceEntry<K, V> r14 = newEntry(r11, r12, r6);     // Catch: Throwable -> L60
            r14.setValueReference(r10);     // Catch: Throwable -> L60
            r4.set(r5, r14);     // Catch: Throwable -> L60
            r7 = r14;
        L46:
            unlock();     // Catch: Throwable -> L63
            postWriteCleanup();     // Catch: Throwable -> L63
            if (r9 == true) goto L48;
            r0 = r7;
        L53:
            if (Thread.holdsLock(r0) == true) goto L55;
            r2 = true;
        L55:
            Preconditions.checkState(r2, "Recursive computation");     // Catch: Throwable -> L63
            V r15 = r0.getValueReference().waitForValue();     // Catch: Throwable -> L63
            if (r15 == null) goto L66;
            recordRead(r0);     // Catch: Throwable -> L63
            postReadCleanup();
            return r15;
        L48:
            V r16 = compute(r11, r12, r7, r10);     // Catch: Throwable -> L63
            postReadCleanup();
            return r16;
        L43:
            r7.setValueReference(r10);     // Catch: Throwable -> L60
            goto L46
        L45:
            r10 = null;
            goto L46
        L24:
            V r17 = r7.getValueReference().get();     // Catch: Throwable -> L60
            if (r17 != null) goto L28;
            enqueueNotification(r8, r12, r17, MapMaker.RemovalCause.COLLECTED);     // Catch: Throwable -> L60
        L32:
            this.evictionQueue.remove(r7);     // Catch: Throwable -> L60
            this.expirationQueue.remove(r7);     // Catch: Throwable -> L60
            this.count = r3;     // Catch: Throwable -> L60
            goto L38
        L28:
            if (this.map.expires() == false) goto L33;
            if (this.map.isExpired(r7) == false) goto L33;
            enqueueNotification(r8, r12, r17, MapMaker.RemovalCause.EXPIRED);     // Catch: Throwable -> L60
        L33:
            recordLockedRead(r7);     // Catch: Throwable -> L60
            unlock();     // Catch: Throwable -> L63
            postWriteCleanup();     // Catch: Throwable -> L63
            postReadCleanup();
            return r17;
        L37:
            r7 = r7.getNext();     // Catch: Throwable -> L60
        L38:
            r9 = true;
        L60:
            th = move-exception;
            unlock();     // Catch: Throwable -> L63
            postWriteCleanup();     // Catch: Throwable -> L63
            throw th;     // Catch: Throwable -> L63
        L12:
            if (r0.getValueReference().isComputingReference() == true) goto L53;
        L63:
            th = move-exception;
            postReadCleanup();
            throw th;
        }

        V compute(K r7, int r8, MapMakerInternalMap.ReferenceEntry<K, V> r9, ComputingValueReference<K, V> r10) throws ExecutionException {
            System.nanoTime();
            monitor-enter(r9);     // Catch: Throwable -> L25
            V r0 = r10.compute(r7, r8);     // Catch: Throwable -> L17
            long r3 = System.nanoTime();     // Catch: Throwable -> L17
            monitor-exit(r9);     // Catch: Throwable -> L23
            if (r0 == null) goto L12;
            if (put(r7, r8, r0, true) == null) goto L12;
            enqueueNotification(r7, r8, r0, MapMaker.RemovalCause.REPLACED);     // Catch: Throwable -> L21
        L12:
            if (r3 != 0) goto L14;
            System.nanoTime();
        L14:
            if (r0 != null) goto L16;
            clearValue(r7, r8, r10);
        L16:
            return r0;
        L17:
            th = th;
        L19:
            monitor-exit(r9);     // Catch: Throwable -> L23
            throw th;     // Catch: Throwable -> L21
        L23:
            th = th;
        L25:
            th = th;
        L28:
            if (0 != 0) goto L30;
            System.nanoTime();
        L30:
            if (0 != 0) goto L32;
            clearValue(r7, r8, r10);
        L32:
            throw th;
        L21:
            th = th;
            goto L28
        }
    }

    static final class ComputingSerializationProxy<K, V> extends MapMakerInternalMap.AbstractSerializationProxy<K, V> {
        private static final long serialVersionUID = 4;
        final Function<? super K, ? extends V> computingFunction;

        ComputingSerializationProxy(MapMakerInternalMap.Strength r1, MapMakerInternalMap.Strength r2, Equivalence<Object> r3, Equivalence<Object> r4, long r5, long r7, int r9, int r10, MapMaker.RemovalListener<? super K, ? super V> r11, ConcurrentMap<K, V> r12, Function<? super K, ? extends V> r13) {
            super(r1, r2, r3, r4, r5, r7, r9, r10, r11, r12);
            this.computingFunction = r13;
        }

        private void writeObject(ObjectOutputStream r1) throws IOException {
            r1.defaultWriteObject();
            writeMapTo(r1);
        }

        private void readObject(ObjectInputStream r3) throws IOException, ClassNotFoundException {
            r3.defaultReadObject();
            this.delegate = readMapMaker(r3).makeComputingMap(this.computingFunction);
            readEntries(r3);
        }

        Object readResolve() {
            return this.delegate;
        }
    }

    private static final class ComputingValueReference<K, V> implements MapMakerInternalMap.ValueReference<K, V> {
        volatile MapMakerInternalMap.ValueReference<K, V> computedReference;
        final Function<? super K, ? extends V> computingFunction;

        @Override // com.google.common.collect.MapMakerInternalMap.ValueReference
        public MapMakerInternalMap.ValueReference<K, V> copyFor(ReferenceQueue<V> r1, @Nullable V r2, MapMakerInternalMap.ReferenceEntry<K, V> r3) {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ValueReference
        public V get() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ValueReference
        public MapMakerInternalMap.ReferenceEntry<K, V> getEntry() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ValueReference
        public boolean isComputingReference() {
            return true;
        }

        public ComputingValueReference(Function<? super K, ? extends V> r2) {
            this.computedReference = MapMakerInternalMap.unset();
            this.computingFunction = r2;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ValueReference
        public V waitForValue() throws ExecutionException {
            if (this.computedReference != MapMakerInternalMap.UNSET) goto L25;
            boolean r0 = false;
            monitor-enter(this);     // Catch: Throwable -> L20
            boolean r1 = false;
        L26:
        L15:
            th = move-exception;
            throw th;     // Catch: Throwable -> L18
        L18:
            th = th;
            r0 = r1;
        L21:
            if (r0 == false) goto L23;
            Thread.currentThread().interrupt();
        L23:
            throw th;
        L8:
            if (this.computedReference != MapMakerInternalMap.UNSET) goto L12;
            wait();     // Catch: InterruptedException -> L11 Throwable -> L15
        L11:
            r1 = true;
            goto L26
        L12:
            monitor-exit(this);     // Catch: Throwable -> L15
            if (r1 == false) goto L25;
            Thread.currentThread().interrupt();
        L20:
            th = th;
        L25:
            return this.computedReference.waitForValue();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.ValueReference
        public void clear(MapMakerInternalMap.ValueReference<K, V> r1) {
            setValueReference(r1);
        }

        V compute(K r1, int r2) throws ExecutionException {
            V r3 = this.computingFunction.apply(r1);     // Catch: Throwable -> L5
            setValueReference(new ComputedReference(r3));
            return r3;
        L5:
            th = move-exception;
            setValueReference(new ComputationExceptionReference(th));
            throw new ExecutionException(th);
        }

        void setValueReference(MapMakerInternalMap.ValueReference<K, V> r3) {
            monitor-enter(this);
        L8:
            th = move-exception;
            throw th;
        L4:
            if (this.computedReference != MapMakerInternalMap.UNSET) goto L6;
            this.computedReference = r3;     // Catch: Throwable -> L8
            notifyAll();     // Catch: Throwable -> L8
        L6:
            monitor-exit(this);     // Catch: Throwable -> L8
        }
    }

    @Override // com.google.common.collect.MapMakerInternalMap
    /* bridge */ /* synthetic */ MapMakerInternalMap.Segment segmentFor(int r1) {
        return segmentFor(r1);
    }

    ComputingConcurrentHashMap(MapMaker r1, Function<? super K, ? extends V> r2) {
        super(r1);
        this.computingFunction = (Function) Preconditions.checkNotNull(r2);
    }

    @Override // com.google.common.collect.MapMakerInternalMap
    MapMakerInternalMap.Segment<K, V> createSegment(int r2, int r3) {
        return new ComputingSegment(this, r2, r3);
    }

    @Override // com.google.common.collect.MapMakerInternalMap
    ComputingSegment<K, V> segmentFor(int r1) {
        return (ComputingSegment) super.segmentFor(r1);
    }

    V getOrCompute(K r3) throws ExecutionException {
        int r0 = hash(Preconditions.checkNotNull(r3));
        return segmentFor(r0).getOrCompute(r3, r0, this.computingFunction);
    }

    @Override // com.google.common.collect.MapMakerInternalMap
    Object writeReplace() {
        return new ComputingSerializationProxy(this.keyStrength, this.valueStrength, this.keyEquivalence, this.valueEquivalence, this.expireAfterWriteNanos, this.expireAfterAccessNanos, this.maximumSize, this.concurrencyLevel, this.removalListener, this, this.computingFunction);
    }
}
