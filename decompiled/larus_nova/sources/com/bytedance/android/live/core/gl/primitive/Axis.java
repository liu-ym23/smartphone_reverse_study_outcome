package com.bytedance.android.live.core.gl.primitive;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/core/gl/primitive/Axis;", "", "X", "Y", "Z", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum Axis extends Enum<Axis> {
    public static final Axis X = null;
    public static final Axis Y = null;
    public static final Axis Z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Axis[] f64827a = null;

    static {
        Axis r100 = new Axis("X", 0);
        X = r100;
        Axis r101 = new Axis("Y", 1);
        Y = r101;
        Axis r102 = new Axis("Z", 2);
        Z = r102;
        f64827a = new Axis[]{r100, r101, r102};
    }

    public static Axis valueOf(String r100) {
        return (Axis) r27.a.a(Axis.class, r100);
    }

    public static Axis[] values() {
        return (Axis[]) f64827a.clone();
    }

    public Axis(String r100, int r101) {
        super(r100, r101);
    }
}
