package com.bytedance.android.live.core.gl.primitive;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/core/gl/primitive/RotationOrder;", "", "XYZ", "XZY", "YXZ", "YZX", "ZXY", "ZYX", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum RotationOrder extends Enum<RotationOrder> {
    public static final RotationOrder XYZ = null;
    public static final RotationOrder XZY = null;
    public static final RotationOrder YXZ = null;
    public static final RotationOrder YZX = null;
    public static final RotationOrder ZXY = null;
    public static final RotationOrder ZYX = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RotationOrder[] f64828a = null;

    static {
        RotationOrder r100 = new RotationOrder("XYZ", 0);
        XYZ = r100;
        RotationOrder r101 = new RotationOrder("XZY", 1);
        XZY = r101;
        RotationOrder r102 = new RotationOrder("YXZ", 2);
        YXZ = r102;
        RotationOrder r103 = new RotationOrder("YZX", 3);
        YZX = r103;
        RotationOrder r104 = new RotationOrder("ZXY", 4);
        ZXY = r104;
        RotationOrder r105 = new RotationOrder("ZYX", 5);
        ZYX = r105;
        f64828a = new RotationOrder[]{r100, r101, r102, r103, r104, r105};
    }

    public static RotationOrder valueOf(String r100) {
        return (RotationOrder) r27.a.a(RotationOrder.class, r100);
    }

    public static RotationOrder[] values() {
        return (RotationOrder[]) f64828a.clone();
    }

    public RotationOrder(String r100, int r101) {
        super(r100, r101);
    }
}
