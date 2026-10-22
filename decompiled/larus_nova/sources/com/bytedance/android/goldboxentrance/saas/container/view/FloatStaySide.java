package com.bytedance.android.goldboxentrance.saas.container.view;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/goldboxentrance/saas/container/view/FloatStaySide;", "", "SideLeft", "SideRight", "SideAuto", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FloatStaySide extends Enum<FloatStaySide> {
    public static final FloatStaySide SideAuto = null;
    public static final FloatStaySide SideLeft = null;
    public static final FloatStaySide SideRight = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FloatStaySide[] f58115a = null;

    static {
        FloatStaySide r100 = new FloatStaySide("SideLeft", 0);
        SideLeft = r100;
        FloatStaySide r101 = new FloatStaySide("SideRight", 1);
        SideRight = r101;
        FloatStaySide r102 = new FloatStaySide("SideAuto", 2);
        SideAuto = r102;
        f58115a = new FloatStaySide[]{r100, r101, r102};
    }

    public static FloatStaySide valueOf(String r100) {
        return (FloatStaySide) a.a(FloatStaySide.class, r100);
    }

    public static FloatStaySide[] values() {
        return (FloatStaySide[]) f58115a.clone();
    }

    public FloatStaySide(String r100, int r101) {
        super(r100, r101);
    }
}
