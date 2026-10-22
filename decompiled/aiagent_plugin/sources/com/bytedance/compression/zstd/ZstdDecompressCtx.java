package com.bytedance.compression.zstd;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ZstdDecompressCtx extends a {
    private ZstdDictDecompress decompression_dict;
    private long nativePtr;

    private native long decompressByteArray0(byte[] r1, int r2, int r3, byte[] r4, int r5, int r6);

    private native void free();

    private native void init();

    private native long loadDDict0(byte[] r1);

    private native long loadDDictFast0(ZstdDictDecompress r1);

    private native long reset0();

    @Override // com.bytedance.compression.zstd.a, java.io.Closeable, java.lang.AutoCloseable
    public /* bridge */ /* synthetic */ void close() {
        super.close();
    }

    static {
        com.bytedance.compression.zstd.a.a.a();
    }

    public ZstdDecompressCtx() {
        this.nativePtr = 0;
        this.decompression_dict = null;
        init();
        if (0 == this.nativePtr) goto L7;
        storeFence();
        return;
    L7:
        throw new IllegalStateException("ZSTD_createDeCompressCtx failed");
    }

    @Override // com.bytedance.compression.zstd.a
    void doClose() {
        if (this.nativePtr == 0) goto L6;
        free();
        this.nativePtr = 0;
        return;
    }

    public ZstdDecompressCtx loadDict(ZstdDictDecompress r5) {
        if (this.nativePtr == 0) goto L16;
        acquireSharedLock();
        r5.acquireSharedLock();
        long r0 = loadDDictFast0(r5);     // Catch: Throwable -> L12
        if (Zstd.isError(r0) == true) goto L11;
        this.decompression_dict = r5;     // Catch: Throwable -> L12
        r5.releaseSharedLock();
        releaseSharedLock();
        return this;
    L11:
        throw new e(r0);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        r5.releaseSharedLock();
        releaseSharedLock();
        throw th;
    L16:
        throw new IllegalStateException("Decompression context is closed");
    }

    public ZstdDecompressCtx loadDict(byte[] r5) {
        if (this.nativePtr == 0) goto L16;
        acquireSharedLock();
        long r0 = loadDDict0(r5);     // Catch: Throwable -> L12
        if (Zstd.isError(r0) == true) goto L11;
        this.decompression_dict = null;     // Catch: Throwable -> L12
        releaseSharedLock();
        return this;
    L11:
        throw new e(r0);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        releaseSharedLock();
        throw th;
    L16:
        throw new IllegalStateException("Compression context is closed");
    }

    public void reset() {
        ensureOpen();
        long r0 = reset0();
        if (Zstd.isError(r0) == true) goto L6;
        return;
    L6:
        throw new e(r0);
    }

    private void ensureOpen() {
        if (this.nativePtr == 0) goto L6;
        return;
    L6:
        throw new IllegalStateException("Decompression context is closed");
    }

    public int decompressByteArray(byte[] r5, int r6, int r7, byte[] r8, int r9, int r10) {
        if (this.nativePtr == 0) goto L19;
        acquireSharedLock();
        long r11 = decompressByteArray0(r5, r6, r7, r8, r9, r10);     // Catch: Throwable -> L15
        if (Zstd.isError(r11) == true) goto L14;
        if (r11 > 2147483647L) goto L12;
        int r12 = (int) r11;
        releaseSharedLock();
        return r12;
    L12:
        throw new e(Zstd.errGeneric(), "Output size is greater than MAX_INT");     // Catch: Throwable -> L15
    L14:
        throw new e(r11);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        releaseSharedLock();
        throw th;
    L19:
        throw new IllegalStateException("Decompression context is closed");
    }

    public int decompress(byte[] r8, byte[] r9) {
        return decompressByteArray(r8, 0, r8.length, r9, 0, r9.length);
    }

    public byte[] decompress(byte[] r2, int r3) {
        byte[] r0 = new byte[r3];
        int r1 = decompress(r0, r2);
        if (r1 != r3) goto L5;
        return r0;
    L5:
        return Arrays.copyOfRange(r0, 0, r1);
    }
}
