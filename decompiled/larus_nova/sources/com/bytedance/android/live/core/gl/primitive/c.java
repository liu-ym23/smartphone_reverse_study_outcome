package com.bytedance.android.live.core.gl.primitive;

/* JADX INFO: loaded from: classes45.dex */
public final /* synthetic */ class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f64833a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f64834b = null;

    static {
        int[] r100 = new int[Axis.values().length];
        f64833a = r100;
        r100[Axis.X.ordinal()] = 1;
        r100[Axis.Y.ordinal()] = 2;
        r100[Axis.Z.ordinal()] = 3;
        int[] r101 = new int[RotationOrder.values().length];
        f64834b = r101;
        r101[RotationOrder.XYZ.ordinal()] = 1;
        r101[RotationOrder.XZY.ordinal()] = 2;
        r101[RotationOrder.YXZ.ordinal()] = 3;
        r101[RotationOrder.YZX.ordinal()] = 4;
        r101[RotationOrder.ZXY.ordinal()] = 5;
        r101[RotationOrder.ZYX.ordinal()] = 6;
    }
}
