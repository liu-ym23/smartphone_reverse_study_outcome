package com.byted.cast.sdk.utils;

import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* JADX INFO: loaded from: classes43.dex */
public final class FourCC {
    public static final int FOURCC_ABGR = 0;
    public static final int FOURCC_I420 = 0;
    public static final int FOURCC_NV12 = 0;
    public static final int FOURCC_NV21 = 0;
    public static final int FOURCC_UNKNOWN = -1;

    public static int makeFourCC(char r100, char r101, char r102, char r103) {
        return ((r100 | (r101 << '\b')) | (r102 << 16)) | (r103 << 24);
    }

    static {
        FOURCC_I420 = makeFourCC('I', '4', '2', '0');
        FOURCC_NV21 = makeFourCC('N', 'V', '2', '1');
        FOURCC_NV12 = makeFourCC('N', 'V', '1', '2');
        FOURCC_ABGR = makeFourCC('A', 'B', 'G', Matrix.MATRIX_TYPE_RANDOM_REGULAR);
    }

    public FourCC() {
    }
}
