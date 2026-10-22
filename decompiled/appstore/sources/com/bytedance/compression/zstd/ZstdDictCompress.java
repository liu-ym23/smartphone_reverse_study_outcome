package com.bytedance.compression.zstd;

/* JADX INFO: loaded from: classes.dex */
public class ZstdDictCompress extends c {
    private int level;
    private long nativePtr;

    static {
        k4.a.a();
    }

    public ZstdDictCompress(byte[] r10, int r11) {
        this(r10, 0, r10.length, r11);
    }

    private native void free();

    private native void init(byte[] r10, int r11, int r12, int r13);

    @Override // com.bytedance.compression.zstd.a, java.io.Closeable, java.lang.AutoCloseable
    public /* bridge */ /* synthetic */ void close() {
        super.close();
    }

    @Override // com.bytedance.compression.zstd.a
    public void doClose() {
        if (this.nativePtr == 0) goto L6;
        free();
        this.nativePtr = 0;
        return;
    }

    public int level() {
        return this.level;
    }

    public ZstdDictCompress(byte[] r10, int r11, int r12, int r13) {
        this.nativePtr = 0;
        ZstdCompress.defaultCompressionLevel();
        this.level = r13;
        if ((r10.length - r11) < 0) goto L11;
        init(r10, r11, r12, r13);
        if (0 == this.nativePtr) goto L9;
        storeFence();
        return;
    L9:
        throw new IllegalStateException("ZSTD_createCDict failed");
    L11:
        throw new IllegalArgumentException("Dictionary buffer is to short");
    }
}
