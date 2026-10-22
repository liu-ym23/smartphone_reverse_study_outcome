package com.baidu.platform.comapi.bmsdk;

/* loaded from: classes.dex */
public class BmCoordChainHandle extends BmObject {
    public BmCoordChainHandle() {
        super(71, nativeCreate());
    }

    private static native long nativeCreate();

    private static native int[] nativeGetIndexs(long j4);

    private static native double[] nativeGetP0Points(long j4);

    private static native boolean nativeHandle(long j4, double[] dArr, int i4, int i5);

    private static native boolean nativeSetCoordAlgorithm(long j4, int i4);

    private static native boolean nativeSetCoordChainType(long j4, int i4);

    private static native boolean nativeSetThreshold(long j4, double d4);
}
