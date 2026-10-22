package org.tukaani.xz;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class ResettableArrayCache extends ArrayCache {
    private final ArrayCache arrayCache;
    private final List<byte[]> byteArrays;
    private final List<int[]> intArrays;

    public ResettableArrayCache(ArrayCache arrayCache) {
        this.arrayCache = arrayCache;
        if (arrayCache == ArrayCache.getDummyCache()) {
            this.byteArrays = null;
            this.intArrays = null;
        } else {
            this.byteArrays = new ArrayList();
            this.intArrays = new ArrayList();
        }
    }

    @Override // org.tukaani.xz.ArrayCache
    public byte[] getByteArray(int i8, boolean z) {
        byte[] byteArray = this.arrayCache.getByteArray(i8, z);
        List<byte[]> list = this.byteArrays;
        if (list == null) {
            return byteArray;
        }
        synchronized (list) {
            this.byteArrays.add(byteArray);
        }
        return byteArray;
    }

    @Override // org.tukaani.xz.ArrayCache
    public int[] getIntArray(int i8, boolean z) {
        int[] intArray = this.arrayCache.getIntArray(i8, z);
        List<int[]> list = this.intArrays;
        if (list == null) {
            return intArray;
        }
        synchronized (list) {
            this.intArrays.add(intArray);
        }
        return intArray;
    }

    @Override // org.tukaani.xz.ArrayCache
    public void putArray(byte[] bArr) {
        List<byte[]> list = this.byteArrays;
        if (list != null) {
            synchronized (list) {
                try {
                    int iLastIndexOf = this.byteArrays.lastIndexOf(bArr);
                    if (iLastIndexOf != -1) {
                        this.byteArrays.remove(iLastIndexOf);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.arrayCache.putArray(bArr);
        }
    }

    public void reset() {
        List<byte[]> list = this.byteArrays;
        if (list != null) {
            synchronized (list) {
                try {
                    for (int size = this.byteArrays.size() - 1; size >= 0; size--) {
                        this.arrayCache.putArray(this.byteArrays.get(size));
                    }
                    this.byteArrays.clear();
                } finally {
                }
            }
            synchronized (this.intArrays) {
                try {
                    for (int size2 = this.intArrays.size() - 1; size2 >= 0; size2--) {
                        this.arrayCache.putArray(this.intArrays.get(size2));
                    }
                    this.intArrays.clear();
                } finally {
                }
            }
        }
    }

    @Override // org.tukaani.xz.ArrayCache
    public void putArray(int[] iArr) {
        List<int[]> list = this.intArrays;
        if (list != null) {
            synchronized (list) {
                try {
                    int iLastIndexOf = this.intArrays.lastIndexOf(iArr);
                    if (iLastIndexOf != -1) {
                        this.intArrays.remove(iLastIndexOf);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.arrayCache.putArray(iArr);
        }
    }
}
