package com.alibaba.fastjson.util;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class IdentityHashMap<K, V> {
    public static final int DEFAULT_SIZE = 8192;
    private final Entry<K, V>[] buckets;
    private final int indexMask;

    public static final class Entry<K, V> {
        public final int hashCode;
        public final K key;
        public final Entry<K, V> next;
        public V value;

        public Entry(K r100, V r101, int r102, Entry<K, V> r103) {
            this.key = r100;
            this.value = r101;
            this.next = r103;
            this.hashCode = r102;
        }
    }

    public IdentityHashMap() {
        this(8192);
    }

    public void clear() {
        Arrays.fill(this.buckets, null);
    }

    public int size() {
        Entry<K, V>[] r100 = this.buckets;
        int r101 = r100.length;
        int r102 = 0;
        int r103 = 0;
    L3:
        if (r102 >= r101) goto L8;
        Entry<K, V> r104 = r100[r102];
    L5:
        if (r104 == null) goto L7;
        r103 = r103 + 1;
        r104 = r104.next;
        goto L5
    L7:
        r102 = r102 + 1;
        goto L3
    L8:
        return r103;
    }

    public IdentityHashMap(int r100) {
        this.indexMask = r100 - 1;
        this.buckets = new Entry[r100];
    }

    public Class findClass(String r100) {
        int r101 = 0;
    L3:
        Entry<K, V>[] r102 = this.buckets;
        if (r101 >= r102.length) goto L17;
        Entry<K, V> r103 = r102[r101];
        if (r103 == null) goto L16;
        Entry<K, V> r104 = r103;
    L9:
        if (r104 == null) goto L16;
        K r105 = r103.key;
        if ((r105 instanceof Class) == false) goto L15;
        Class r106 = (Class) r105;
        if (r106.getName().equals(r100) == false) goto L15;
        return r106;
    L15:
        r104 = r104.next;
    L16:
        r101 = r101 + 1;
        goto L3
    L17:
        return null;
    }

    public final V get(K r100) {
        int r101 = System.identityHashCode(r100) & this.indexMask;
        Entry<K, V> r102 = this.buckets[r101];
    L3:
        if (r102 == null) goto L9;
        if (r100 == r102.key) goto L7;
        r102 = r102.next;
        goto L3
    L7:
        return r102.value;
    L9:
        return null;
    }

    public boolean put(K r100, V r101) {
        int r102 = System.identityHashCode(r100);
        int r103 = this.indexMask & r102;
        Entry<K, V> r104 = this.buckets[r103];
    L3:
        if (r104 == null) goto L9;
        if (r100 == r104.key) goto L6;
        r104 = r104.next;
        goto L3
    L6:
        r104.value = r101;
        return true;
    L9:
        Entry<K, V> r105 = new Entry(r100, r101, r102, this.buckets[r103]);
        this.buckets[r103] = r105;
        return false;
    }
}
