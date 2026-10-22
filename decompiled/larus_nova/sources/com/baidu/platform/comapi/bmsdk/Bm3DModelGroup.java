package com.baidu.platform.comapi.bmsdk;

/* JADX INFO: loaded from: classes39.dex */
public class Bm3DModelGroup extends BmDrawItem {
    private static native boolean nativeAddNode3D(long r100, double[] r101, int r102);

    private static native boolean nativeClear3DNode(long r100);

    private static native long nativeCreate();

    private static native boolean nativeLoad(long r100, String r101, int r102);

    private static native boolean nativeSetLightBreathLevel(long r100, int r101, int r102);

    private static native boolean nativeSetLightEnable(long r100, int r101);

    private static native boolean nativeSetScaleByLevel(long r100, boolean r101);

    private Bm3DModelGroup() {
        super(21, nativeCreate());
    }
}
