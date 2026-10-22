package com.bytedance.compression.zstd;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class Zstd {
    static {
        k4.a.a();
    }

    public Zstd() {
    }

    public static native long errGeneric();

    public static final byte[] extractArray(ByteBuffer r10) {
        if (r10.hasArray() == false) goto L9;
        if (r10.arrayOffset() != 0) goto L9;
        return r10.array();
    L9:
        throw new IllegalArgumentException("provided ByteBuffer lacks array or has non-zero arrayOffset");
    }

    public static native long getErrorCode(long r10);

    public static native String getErrorName(long r10);

    public static long getFunAddressBySymbol(String r10) {
        long[] r11 = getFunAddressesBySymbols(new String[]{r10});
        if (r11 != null) goto L5;
    L7:
        return 0;
    L5:
        if (r11.length != 1) goto L7;
        return r11[0];
    }

    public static native long[] getFunAddressesBySymbols(String[] r10);

    public static native boolean isError(long r10);
}
