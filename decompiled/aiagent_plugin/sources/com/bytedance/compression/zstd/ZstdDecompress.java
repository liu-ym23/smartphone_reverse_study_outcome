package com.bytedance.compression.zstd;

/* JADX INFO: loaded from: classes.dex */
public class ZstdDecompress {
    private static native long decompressedSize0(byte[] r0, int r1, int r2);

    static native int loadDictDecompress(long r0, byte[] r2, int r3);

    static native int loadFastDictDecompress(long r0, ZstdDictDecompress r2);

    public ZstdDecompress() {
    }

    static {
        com.bytedance.compression.zstd.a.a.a();
    }

    public static byte[] decompress(byte[] r4) {
        long r0 = decompressedSize(r4);
        if (r0 > 2147483647L) goto L7;
        return decompress(r4, (int) r0);
    L7:
        throw new e(Zstd.errGeneric(), "original size is greater than MAX_INT");
    }

    public static byte[] decompress(byte[] r1, int r2) {
        ZstdDecompressCtx r0 = new ZstdDecompressCtx();
        byte[] r3 = r0.decompress(r1, r2);     // Catch: Throwable -> L6
        r0.close();
        return r3;
    L6:
        th = move-exception;
        r0.close();
        throw th;
    }

    public static byte[] decompress(byte[] r4, ZstdDictDecompress r5) {
        long r0 = decompressedSize(r4);
        if (r0 > 2147483647L) goto L7;
        return decompress(r4, r5, (int) r0);
    L7:
        throw new e(Zstd.errGeneric(), "original size is greater than MAX_INT");
    }

    public static byte[] decompress(byte[] r1, ZstdDictDecompress r2, int r3) {
        ZstdDecompressCtx r0 = new ZstdDecompressCtx();
        r0.loadDict(r2);     // Catch: Throwable -> L6
        byte[] r4 = r0.decompress(r1, r3);     // Catch: Throwable -> L6
        r0.close();
        return r4;
    L6:
        th = move-exception;
        r0.close();
        throw th;
    }

    public static byte[] decompress(byte[] r4, byte[] r5) {
        long r0 = decompressedSize(r4);
        if (r0 > 2147483647L) goto L7;
        return decompress(r4, r5, (int) r0);
    L7:
        throw new e(Zstd.errGeneric(), "original size is greater than MAX_INT");
    }

    public static byte[] decompress(byte[] r1, byte[] r2, int r3) {
        ZstdDecompressCtx r0 = new ZstdDecompressCtx();
        r0.loadDict(r2);     // Catch: Throwable -> L6
        byte[] r4 = r0.decompress(r1, r3);     // Catch: Throwable -> L6
        r0.close();
        return r4;
    L6:
        th = move-exception;
        r0.close();
        throw th;
    }

    public static long decompressedSize(byte[] r2, int r3, int r4) {
        if (r3 >= r2.length) goto L11;
        int r0 = r3 + r4;
        if (r0 > r2.length) goto L9;
        return decompressedSize0(r2, r3, r4);
    L9:
        throw new ArrayIndexOutOfBoundsException(r0);
    L11:
        throw new ArrayIndexOutOfBoundsException(r3);
    }

    public static long decompressedSize(byte[] r1, int r2) {
        return decompressedSize(r1, r2, r1.length - r2);
    }

    public static long decompressedSize(byte[] r2) {
        return decompressedSize(r2, 0);
    }
}
