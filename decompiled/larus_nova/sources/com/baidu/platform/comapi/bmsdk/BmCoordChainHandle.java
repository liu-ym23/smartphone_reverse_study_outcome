package com.baidu.platform.comapi.bmsdk;

/* JADX INFO: loaded from: classes39.dex */
public class BmCoordChainHandle extends BmObject {
    private static native long nativeCreate();

    private static native int[] nativeGetIndexs(long r100);

    private static native double[] nativeGetP0Points(long r100);

    private static native boolean nativeHandle(long r100, double[] r101, int r102, int r103);

    private static native boolean nativeSetCoordAlgorithm(long r100, int r101);

    private static native boolean nativeSetCoordChainType(long r100, int r101);

    private static native boolean nativeSetThreshold(long r100, double r101);

    public BmCoordChainHandle() {
        super(71, nativeCreate());
    }
}
