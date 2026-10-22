package com.baidu.platform.comapi.bmsdk;

/* loaded from: classes.dex */
public class Bm3DModelGroup extends BmDrawItem {
    private Bm3DModelGroup() {
        super(21, nativeCreate());
    }

    private static native boolean nativeAddNode3D(long j4, double[] dArr, int i4);

    private static native boolean nativeClear3DNode(long j4);

    private static native long nativeCreate();

    private static native boolean nativeLoad(long j4, String str, int i4);

    private static native boolean nativeSetLightBreathLevel(long j4, int i4, int i5);

    private static native boolean nativeSetLightEnable(long j4, int i4);

    private static native boolean nativeSetScaleByLevel(long j4, boolean z4);
}
