package com.amap.api.mapcore.util;

/* JADX INFO: loaded from: classes28.dex */
public final enum n3 extends Enum<n3> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n3 f27630a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n3 f27631b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final n3 f27632c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ n3[] f27633d = null;

    static {
        n3 r100 = new n3("unknown", 0);
        f27630a = r100;
        n3 r101 = new n3("marker_default", 1);
        f27631b = r101;
        n3 r102 = new n3("marker_gps_no_sharing", 2);
        f27632c = r102;
        f27633d = new n3[]{r100, r101, r102};
    }

    public static n3[] values() {
        return (n3[]) f27633d.clone();
    }

    public static n3 valueOf(String r100) {
        return (n3) r27.a.a(n3.class, r100);
    }

    private n3(String r100, int r101) {
        super(r100, r101);
    }
}
