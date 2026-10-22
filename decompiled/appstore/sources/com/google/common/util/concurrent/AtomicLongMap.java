package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public final class AtomicLongMap<K> implements Serializable {

    @MonotonicNonNullDecl
    private transient Map<K, Long> asMap;
    private final ConcurrentHashMap<K, AtomicLong> map;

    private AtomicLongMap(ConcurrentHashMap<K, AtomicLong> r10) {
        this.map = (ConcurrentHashMap) Preconditions.checkNotNull(r10);
    }

    public static <K> AtomicLongMap<K> create() {
        return new AtomicLongMap(new ConcurrentHashMap());
    }

    private Map<K, Long> createAsMap() {
        return Collections.unmodifiableMap(Maps.transformValues(this.map, new AnonymousClass1(this)));
    }

    @CanIgnoreReturnValue
    public long addAndGet(K r10, long r11) {
    L2:
        AtomicLong r12 = this.map.get(r10);
        if (r12 != null) goto L7;
        r12 = this.map.putIfAbsent(r10, new AtomicLong(r11));
        if (r12 != null) goto L7;
        return r11;
    L7:
        long r13 = r12.get();
        if (r13 == 0) goto L10;
        long r14 = r13 + r11;
        if (r12.compareAndSet(r13, r14) == false) goto L7;
        return r14;
    L10:
        if (this.map.replace(r10, r12, new AtomicLong(r11)) == false) goto L2;
        return r11;
    }

    public Map<K, Long> asMap() {
        Map<K, Long> r10 = this.asMap;
        if (r10 != null) goto L6;
        Map<K, Long> r11 = createAsMap();
        this.asMap = r11;
        return r11;
    L6:
        return r10;
    }

    public void clear() {
        this.map.clear();
    }

    public boolean containsKey(Object r10) {
        return this.map.containsKey(r10);
    }

    @CanIgnoreReturnValue
    public long decrementAndGet(K r10) {
        return addAndGet(r10, -1);
    }

    public long get(K r10) {
        AtomicLong r11 = this.map.get(r10);
        if (r11 != null) goto L6;
        return 0;
    L6:
        return r11.get();
    }

    @CanIgnoreReturnValue
    public long getAndAdd(K r10, long r11) {
    L2:
        AtomicLong r12 = this.map.get(r10);
        if (r12 != null) goto L7;
        r12 = this.map.putIfAbsent(r10, new AtomicLong(r11));
        if (r12 != null) goto L7;
        return 0;
    L7:
        long r13 = r12.get();
        if (r13 == 0) goto L10;
        if (r12.compareAndSet(r13, r13 + r11) == false) goto L7;
        return r13;
    L10:
        if (this.map.replace(r10, r12, new AtomicLong(r11)) == false) goto L2;
        return 0;
    }

    @CanIgnoreReturnValue
    public long getAndDecrement(K r10) {
        return getAndAdd(r10, -1);
    }

    @CanIgnoreReturnValue
    public long getAndIncrement(K r10) {
        return getAndAdd(r10, 1);
    }

    @CanIgnoreReturnValue
    public long incrementAndGet(K r10) {
        return addAndGet(r10, 1);
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @CanIgnoreReturnValue
    public long put(K r10, long r11) {
    L2:
        AtomicLong r12 = this.map.get(r10);
        if (r12 != null) goto L7;
        r12 = this.map.putIfAbsent(r10, new AtomicLong(r11));
        if (r12 != null) goto L7;
        return 0;
    L7:
        long r13 = r12.get();
        if (r13 == 0) goto L10;
        if (r12.compareAndSet(r13, r11) == false) goto L7;
        return r13;
    L10:
        if (this.map.replace(r10, r12, new AtomicLong(r11)) == false) goto L2;
        return 0;
    }

    public void putAll(Map<? extends K, ? extends Long> r10) {
        Iterator<Map.Entry<? extends K, ? extends Long>> r11 = r10.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry<? extends K, ? extends Long> r12 = r11.next();
        put(r12.getKey(), r12.getValue().longValue());
        goto L4
    }

    public long putIfAbsent(K r10, long r11) {
    L2:
        AtomicLong r12 = this.map.get(r10);
        if (r12 != null) goto L7;
        r12 = this.map.putIfAbsent(r10, new AtomicLong(r11));
        if (r12 != null) goto L7;
        return 0;
    L7:
        long r13 = r12.get();
        if (r13 != 0) goto L12;
        if (this.map.replace(r10, r12, new AtomicLong(r11)) == false) goto L2;
        return 0;
    L12:
        return r13;
    }

    @CanIgnoreReturnValue
    public long remove(K r10) {
        AtomicLong r11 = this.map.get(r10);
        if (r11 != null) goto L5;
        return 0;
    L5:
        long r12 = r11.get();
        if (r12 == 0) goto L9;
        if (r11.compareAndSet(r12, 0) == false) goto L5;
    L9:
        this.map.remove(r10, r11);
        return r12;
    }

    public void removeAllZeros() {
        Iterator<Map.Entry<K, AtomicLong>> r10 = this.map.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        AtomicLong r11 = r10.next().getValue();
        if (r11 == null) goto L4;
        if (r11.get() != 0) goto L4;
        r10.remove();
        goto L4
    }

    @CanIgnoreReturnValue
    @Beta
    public boolean removeIfZero(K r10) {
        return remove(r10, 0);
    }

    public boolean replace(K r10, long r11, long r12) {
        if (r11 == 0) goto L5;
        AtomicLong r13 = this.map.get(r10);
        if (r13 != null) goto L12;
        return false;
    L12:
        return r13.compareAndSet(r11, r12);
    L5:
        if (putIfAbsent(r10, r12) != 0) goto L13;
        return true;
    L13:
        return false;
    }

    public int size() {
        return this.map.size();
    }

    public long sum() {
        Iterator<AtomicLong> r10 = this.map.values().iterator();
        long r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L6;
        r11 = r11 + r10.next().get();
        goto L4
    L6:
        return r11;
    }

    public String toString() {
        return this.map.toString();
    }

    public static <K> AtomicLongMap<K> create(Map<? extends K, ? extends Long> r10) {
        AtomicLongMap<K> r11 = create();
        r11.putAll(r10);
        return r11;
    }

    public boolean remove(K r10, long r11) {
        AtomicLong r12 = this.map.get(r10);
        if (r12 != null) goto L5;
        return false;
    L5:
        long r13 = r12.get();
        if (r13 == r11) goto L9;
        return false;
    L9:
        if (r13 != 0) goto L11;
    L14:
        this.map.remove(r10, r12);
        return true;
    L11:
        if (r12.compareAndSet(r13, 0) == true) goto L14;
        return false;
    }
}
