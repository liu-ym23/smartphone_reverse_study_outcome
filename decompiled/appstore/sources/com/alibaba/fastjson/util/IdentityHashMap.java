package com.alibaba.fastjson.util;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public class IdentityHashMap<V> {
    private final Entry<V>[] buckets;
    private final int indexMask;

    public static final class Entry<V> {
        public final int hashCode;
        public final Type key;
        public final Entry<V> next;
        public V value;

        public Entry(Type r10, V r11, int r12, Entry<V> r13) {
            this.key = r10;
            this.value = r11;
            this.next = r13;
            this.hashCode = r12;
        }
    }

    public IdentityHashMap(int r10) {
        this.indexMask = r10 - 1;
        this.buckets = new Entry[r10];
    }

    public final V get(Type r10) {
        int r11 = System.identityHashCode(r10) & this.indexMask;
        Entry<V> r12 = this.buckets[r11];
    L3:
        if (r12 == null) goto L9;
        if (r10 == r12.key) goto L7;
        r12 = r12.next;
        goto L3
    L7:
        return r12.value;
    L9:
        return null;
    }

    public boolean put(Type r10, V r11) {
        int r12 = System.identityHashCode(r10);
        int r13 = this.indexMask & r12;
        Entry<V> r14 = this.buckets[r13];
    L3:
        if (r14 == null) goto L9;
        if (r10 == r14.key) goto L6;
        r14 = r14.next;
        goto L3
    L6:
        r14.value = r11;
        return true;
    L9:
        Entry<V> r15 = new Entry(r10, r11, r12, this.buckets[r13]);
        this.buckets[r13] = r15;
        return false;
    }
}
