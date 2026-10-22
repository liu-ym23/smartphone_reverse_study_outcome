package com.bytedance.compression.zstd;

/* JADX INFO: loaded from: classes.dex */
public class ZstdCompress {
    static {
        k4.a.a();
    }

    public ZstdCompress() {
    }

    public static byte[] compress(byte[] r10) throws ZstdException {
        return compress(r10, defaultCompressionLevel());
    }

    public static native long compressBound(long r10);

    public static native int defaultCompressionLevel();

    public static native int loadDictCompress(long r10, byte[] r11, int r12);

    public static native int loadFastDictCompress(long r10, ZstdDictCompress r11);

    public static native int maxCompressionLevel();

    public static native int minCompressionLevel();

    public static native int setCompressionChecksums(long r10, boolean r11);

    public static native int setCompressionLevel(long r10, int r11);

    public static native int setCompressionLong(long r10, int r11);

    public static native int setCompressionWorkers(long r10, int r11);

    public static byte[] compress(byte[] r10, int r11) throws ZstdException {
        ZstdCompressCtx r12 = new ZstdCompressCtx();
        r12.setLevel(r11);     // Catch: Throwable -> L6
        byte[] r13 = r12.compress(r10);     // Catch: Throwable -> L6
        r12.close();
        return r13;
    L6:
        th = move-exception;
        r12.close();
        throw th;
    }

    public static byte[] compress(byte[] r10, ZstdDictCompress r11) throws ZstdException {
        ZstdCompressCtx r12 = new ZstdCompressCtx();
        r12.loadDict(r11);     // Catch: Throwable -> L6
        r12.setLevel(r11.level());     // Catch: Throwable -> L6
        byte[] r13 = r12.compress(r10);     // Catch: Throwable -> L6
        r12.close();
        return r13;
    L6:
        th = move-exception;
        r12.close();
        throw th;
    }

    public static byte[] compress(byte[] r10, byte[] r11, int r12) throws ZstdException {
        ZstdCompressCtx r13 = new ZstdCompressCtx();
        r13.loadDict(r11);     // Catch: Throwable -> L6
        r13.setLevel(r12);     // Catch: Throwable -> L6
        byte[] r14 = r13.compress(r10);     // Catch: Throwable -> L6
        r13.close();
        return r14;
    L6:
        th = move-exception;
        r13.close();
        throw th;
    }
}
