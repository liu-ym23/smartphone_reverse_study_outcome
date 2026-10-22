package org.tukaani.xz;

/* JADX INFO: loaded from: classes3.dex */
public class ArrayCache {
    private static volatile ArrayCache defaultCache;
    private static final ArrayCache dummyCache = null;

    static {
        dummyCache = new ArrayCache();
        defaultCache = dummyCache;
    }

    public static ArrayCache getDummyCache() {
        return dummyCache;
    }

    public static ArrayCache getDefaultCache() {
        return defaultCache;
    }

    public static void setDefaultCache(ArrayCache arrayCache) {
        if (arrayCache == null) goto L6;
        defaultCache = arrayCache;
        return;
    L6:
        throw new NullPointerException();
    }

    public ArrayCache() {
    }

    public byte[] getByteArray(int size, boolean fillWithZeros) {
        return new byte[size];
    }

    public void putArray(byte[] array) {
    }

    public int[] getIntArray(int size, boolean fillWithZeros) {
        return new int[size];
    }

    public void putArray(int[] array) {
    }
}
