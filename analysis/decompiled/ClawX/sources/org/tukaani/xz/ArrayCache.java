package org.tukaani.xz;

import m0.f;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class ArrayCache {
    private static volatile ArrayCache defaultCache;
    private static final ArrayCache dummyCache;

    static {
        ArrayCache arrayCache = new ArrayCache();
        dummyCache = arrayCache;
        String property = System.getProperty("org.tukaani.xz.ArrayCache");
        if (property == null) {
            property = "Dummy";
        }
        if (property.equals("Basic")) {
            defaultCache = BasicArrayCache.getInstance();
        } else {
            if (!property.equals("Dummy")) {
                throw new Error(f.d("Unsupported value '", property, "' in the system property org.tukaani.xz.ArrayCache. Supported values: Dummy, Basic"));
            }
            defaultCache = arrayCache;
        }
    }

    public static ArrayCache getDefaultCache() {
        return defaultCache;
    }

    public static ArrayCache getDummyCache() {
        return dummyCache;
    }

    public static void setDefaultCache(ArrayCache arrayCache) {
        arrayCache.getClass();
        defaultCache = arrayCache;
    }

    public byte[] getByteArray(int i8, boolean z) {
        return new byte[i8];
    }

    public int[] getIntArray(int i8, boolean z) {
        return new int[i8];
    }

    public void putArray(byte[] bArr) {
    }

    public void putArray(int[] iArr) {
    }
}
