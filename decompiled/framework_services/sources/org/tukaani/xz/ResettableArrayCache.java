package org.tukaani.xz;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ResettableArrayCache extends ArrayCache {
    private final ArrayCache arrayCache;
    private final List<byte[]> byteArrays;
    private final List<int[]> intArrays;

    public ResettableArrayCache(ArrayCache arrayCache) {
        this.arrayCache = arrayCache;
        if (arrayCache != ArrayCache.getDummyCache()) goto L5;
        this.byteArrays = null;
        this.intArrays = null;
        return;
    L5:
        this.byteArrays = new ArrayList();
        this.intArrays = new ArrayList();
    }

    @Override // org.tukaani.xz.ArrayCache
    public byte[] getByteArray(int size, boolean fillWithZeros) {
        byte[] array = this.arrayCache.getByteArray(size, fillWithZeros);
        if (this.byteArrays == null) goto L12;
        List<byte[]> r1 = this.byteArrays;
        monitor-enter(r1);
        this.byteArrays.add(array);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L12:
        return array;
    }

    @Override // org.tukaani.xz.ArrayCache
    public void putArray(byte[] array) {
        if (this.byteArrays == null) goto L15;
        List<byte[]> r0 = this.byteArrays;
        monitor-enter(r0);
        int i = this.byteArrays.lastIndexOf(array);     // Catch: Throwable -> L9
        if (i == (-1)) goto L11;
        this.byteArrays.remove(i);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        this.arrayCache.putArray(array);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // org.tukaani.xz.ArrayCache
    public int[] getIntArray(int size, boolean fillWithZeros) {
        int[] array = this.arrayCache.getIntArray(size, fillWithZeros);
        if (this.intArrays == null) goto L12;
        List<int[]> r1 = this.intArrays;
        monitor-enter(r1);
        this.intArrays.add(array);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L12:
        return array;
    }

    @Override // org.tukaani.xz.ArrayCache
    public void putArray(int[] array) {
        if (this.intArrays == null) goto L15;
        List<int[]> r0 = this.intArrays;
        monitor-enter(r0);
        int i = this.intArrays.lastIndexOf(array);     // Catch: Throwable -> L9
        if (i == (-1)) goto L11;
        this.intArrays.remove(i);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        this.arrayCache.putArray(array);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void reset() {
        if (this.byteArrays == null) goto L27;
        List<byte[]> r0 = this.byteArrays;
        monitor-enter(r0);
        int i = this.byteArrays.size() - 1;     // Catch: Throwable -> L9
    L7:
        if (i < 0) goto L11;
        this.arrayCache.putArray(this.byteArrays.get(i));     // Catch: Throwable -> L9
        i = i - 1;     // Catch: Throwable -> L9
        goto L7
    L11:
        this.byteArrays.clear();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        List<int[]> r1 = this.intArrays;
        monitor-enter(r1);
        int i2 = this.intArrays.size() - 1;     // Catch: Throwable -> L18
    L16:
        if (i2 < 0) goto L20;
        this.arrayCache.putArray(this.intArrays.get(i2));     // Catch: Throwable -> L18
        i2 = i2 - 1;     // Catch: Throwable -> L18
        goto L16
    L20:
        this.intArrays.clear();     // Catch: Throwable -> L18
        monitor-exit(r1);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    L9:
        th = move-exception;
        throw th;
    }
}
