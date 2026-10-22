package com.bytedance.compression.zstd;

/* JADX INFO: loaded from: classes.dex */
public class ZstdDictDecompress extends d {
    private long nativePtr;

    private native void free();

    private native void init(byte[] r1, int r2, int r3);

    @Override // com.bytedance.compression.zstd.a, java.io.Closeable, java.lang.AutoCloseable
    public /* bridge */ /* synthetic */ void close() {
        super.close();
    }

    static {
        com.bytedance.compression.zstd.a.a.a();
    }

    public ZstdDictDecompress(byte[] r3) {
        this(r3, 0, r3.length);
    }

    public ZstdDictDecompress(byte[] r3, int r4, int r5) {
        this.nativePtr = 0;
        init(r3, r4, r5);
        if (this.nativePtr == 0) goto L7;
        storeFence();
        return;
    L7:
        throw new IllegalStateException("ZSTD_createDDict failed");
    }

    @Override // com.bytedance.compression.zstd.a
    void doClose() {
        if (this.nativePtr == 0) goto L6;
        free();
        this.nativePtr = 0;
        return;
    }
}
