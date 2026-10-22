package com.baidu.mapsdkplatform.comapi.map;

/* JADX INFO: loaded from: classes39.dex */
public final enum r extends Enum<r> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f32196a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r f32197b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ r[] f32198c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f32199d;

    static {
        r r100 = new r("GLSurfaceView", 0, 1);
        f32196a = r100;
        r r101 = new r("TextureView", 1, 2);
        f32197b = r101;
        f32198c = new r[]{r100, r101};
    }

    public static r[] values() {
        return (r[]) f32198c.clone();
    }

    public static r valueOf(String r100) {
        return (r) r27.a.a(r.class, r100);
    }

    private r(String r100, int r101, int r102) {
        super(r100, r101);
        this.f32199d = r102;
    }
}
