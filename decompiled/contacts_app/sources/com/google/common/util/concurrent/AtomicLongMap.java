package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public final class AtomicLongMap<K> {
    private transient Map<K, Long> asMap;
    private final ConcurrentHashMap<K, AtomicLong> map;

    private AtomicLongMap(ConcurrentHashMap<K, AtomicLong> r1) {
        this.map = (ConcurrentHashMap) Preconditions.checkNotNull(r1);
    }

    public static <K> AtomicLongMap<K> create() {
        return new AtomicLongMap(new ConcurrentHashMap());
    }

    public static <K> AtomicLongMap<K> create(Map<? extends K, ? extends Long> r1) {
        AtomicLongMap<K> r0 = create();
        r0.putAll(r1);
        return r0;
    }

    public long get(K r1) {
        AtomicLong r0 = this.map.get(r1);
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.get();
    }

    public long incrementAndGet(K r3) {
        return addAndGet(r3, 1);
    }

    public long decrementAndGet(K r3) {
        return addAndGet(r3, -1);
    }

    public long addAndGet(K r6, long r7) {
    L2:
        AtomicLong r0 = this.map.get(r6);
        if (r0 != null) goto L7;
        r0 = this.map.putIfAbsent(r6, new AtomicLong(r7));
        if (r0 != null) goto L7;
        return r7;
    L7:
        long r1 = r0.get();
        if (r1 == 0) goto L10;
        long r3 = r1 + r7;
        if (r0.compareAndSet(r1, r3) == false) goto L7;
        return r3;
    L10:
        if (this.map.replace(r6, r0, new AtomicLong(r7)) == false) goto L2;
        return r7;
    }

    public long getAndIncrement(K r3) {
        return getAndAdd(r3, 1);
    }

    public long getAndDecrement(K r3) {
        return getAndAdd(r3, -1);
    }

    public long getAndAdd(K r8, long r9) {
    L2:
        AtomicLong r0 = this.map.get(r8);
        if (r0 != null) goto L7;
        r0 = this.map.putIfAbsent(r8, new AtomicLong(r9));
        if (r0 != null) goto L7;
        return 0;
    L7:
        long r3 = r0.get();
        if (r3 == 0) goto L10;
        if (r0.compareAndSet(r3, r3 + r9) == false) goto L7;
        return r3;
    L10:
        if (this.map.replace(r8, r0, new AtomicLong(r9)) == false) goto L2;
        return 0;
    }

    public long put(K r7, long r8) {
    L2:
        AtomicLong r0 = this.map.get(r7);
        if (r0 != null) goto L7;
        r0 = this.map.putIfAbsent(r7, new AtomicLong(r8));
        if (r0 != null) goto L7;
        return 0;
    L7:
        long r3 = r0.get();
        if (r3 == 0) goto L10;
        if (r0.compareAndSet(r3, r8) == false) goto L7;
        return r3;
    L10:
        if (this.map.replace(r7, r0, new AtomicLong(r8)) == false) goto L2;
        return 0;
    }

    public void putAll(Map<? extends K, ? extends Long> r5) {
        Iterator<Map.Entry<? extends K, ? extends Long>> r6 = r5.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        Map.Entry<? extends K, ? extends Long> r0 = r6.next();
        put(r0.getKey(), r0.getValue().longValue());
        goto L4
    }

    public long remove(K r7) {
        AtomicLong r0 = this.map.get(r7);
        if (r0 != null) goto L5;
        return 0;
    L5:
        long r3 = r0.get();
        if (r3 == 0) goto L9;
        if (r0.compareAndSet(r3, 0) == false) goto L5;
    L9:
        this.map.remove(r7, r0);
        return r3;
    }

    public void removeAllZeros() {
        Iterator<K> r0 = this.map.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        K r1 = r0.next();
        AtomicLong r2 = this.map.get(r1);
        if (r2 == null) goto L4;
        if (r2.get() != 0) goto L4;
        this.map.remove(r1, r2);
        goto L4
    }

    public long sum() {
        Iterator<AtomicLong> r4 = this.map.values().iterator();
        long r0 = 0;
    L4:
        if (r4.hasNext() == false) goto L6;
        r0 = r0 + r4.next().get();
        goto L4
    L6:
        return r0;
    }

    public Map<K, Long> asMap() {
        Map<K, Long> r0 = this.asMap;
        if (r0 != null) goto L6;
        Map<K, Long> r1 = createAsMap();
        this.asMap = r1;
        return r1;
    L6:
        return r0;
    }

    private Map<K, Long> createAsMap() {
        return Collections.unmodifiableMap(Maps.transformValues(this.map, new AnonymousClass1(this)));
    }

    public boolean containsKey(Object r1) {
        return this.map.containsKey(r1);
    }

    public int size() {
        return this.map.size();
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public void clear() {
        this.map.clear();
    }

    public String toString() {
        return this.map.toString();
    }

    long putIfAbsent(K r7, long r8) {
    L2:
        AtomicLong r0 = this.map.get(r7);
        if (r0 != null) goto L7;
        r0 = this.map.putIfAbsent(r7, new AtomicLong(r8));
        if (r0 != null) goto L7;
        return 0;
    L7:
        long r3 = r0.get();
        if (r3 != 0) goto L12;
        if (this.map.replace(r7, r0, new AtomicLong(r8)) == false) goto L2;
        return 0;
    L12:
        return r3;
    }

    boolean replace(K r5, long r6, long r8) {
        if (r6 == 0) goto L5;
        AtomicLong r4 = this.map.get(r5);
        if (r4 != null) goto L12;
        return false;
    L12:
        return r4.compareAndSet(r6, r8);
    L5:
        if (putIfAbsent(r5, r8) != 0) goto L13;
        return true;
    L13:
        return false;
    }

    boolean remove(K r6, long r7) {
        AtomicLong r0 = this.map.get(r6);
        if (r0 != null) goto L5;
        return false;
    L5:
        long r2 = r0.get();
        if (r2 == r7) goto L9;
        return false;
    L9:
        if (r2 != 0) goto L11;
    L14:
        this.map.remove(r6, r0);
        return true;
    L11:
        if (r0.compareAndSet(r2, 0) == true) goto L14;
        return false;
    }
}
