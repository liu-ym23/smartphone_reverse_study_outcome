package com.baidu.platform.comapi.bmsdk;

/* JADX INFO: loaded from: classes39.dex */
public final enum d extends Enum<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f32821a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f32822b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f32823c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ d[] f32824d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f32825e;

    static {
        d r100 = new d("NO_SCALE_DPI", 0, 0);
        f32821a = r100;
        d r101 = new d("SCALE_DPI", 1, 1);
        f32822b = r101;
        d r102 = new d("AUTO_SCALE", 2, 2);
        f32823c = r102;
        f32824d = new d[]{r100, r101, r102};
    }

    public static d[] values() {
        return (d[]) f32824d.clone();
    }

    public int a() {
        return this.f32825e;
    }

    public static d valueOf(String r100) {
        return (d) r27.a.a(d.class, r100);
    }

    private d(String r100, int r101, int r102) {
        super(r100, r101);
        this.f32825e = r102;
    }
}
