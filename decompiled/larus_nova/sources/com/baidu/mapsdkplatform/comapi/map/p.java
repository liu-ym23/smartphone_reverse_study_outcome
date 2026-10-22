package com.baidu.mapsdkplatform.comapi.map;

/* JADX INFO: loaded from: classes39.dex */
public final enum p extends Enum<p> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f32184a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p f32185b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final p f32186c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ p[] f32187d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f32188e;

    static {
        p r100 = new p("DEFAULT", 0, 1);
        f32184a = r100;
        p r101 = new p("INDOOR", 1, 2);
        f32185b = r101;
        p r102 = new p("STREET", 2, 3);
        f32186c = r102;
        f32187d = new p[]{r100, r101, r102};
    }

    public static p[] values() {
        return (p[]) f32187d.clone();
    }

    public static p valueOf(String r100) {
        return (p) r27.a.a(p.class, r100);
    }

    private p(String r100, int r101, int r102) {
        super(r100, r101);
        this.f32188e = r102;
    }
}
