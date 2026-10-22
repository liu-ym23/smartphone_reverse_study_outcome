package com.baidu.platform.comjni.base.sdkauth;

/* JADX INFO: loaded from: classes39.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f33432a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f33433b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ a[] f33434c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f33435d;

    static {
        a r100 = new a("ParkingSpace", 0, 1);
        f33432a = r100;
        a r101 = new a("WaterMark", 1, 2);
        f33433b = r101;
        f33434c = new a[]{r100, r101};
    }

    public static a[] values() {
        return (a[]) f33434c.clone();
    }

    public int a() {
        return this.f33435d;
    }

    public static a valueOf(String r100) {
        return (a) r27.a.a(a.class, r100);
    }

    private a(String r100, int r101, int r102) {
        super(r100, r101);
        this.f33435d = r102;
    }
}
