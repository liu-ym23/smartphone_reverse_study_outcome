package com.amap.api.mapcore.util;

import android.os.Build;
import com.bytedance.bdlocation.client.LocationInfoConst;

/* JADX INFO: loaded from: classes28.dex */
public final enum n6 extends Enum<n6> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final n6 f27677f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final n6 f27678g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final n6 f27679h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final n6 f27680i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final n6 f27681j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final n6 f27682k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final n6 f27683l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final n6 f27684m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final n6 f27685n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final n6 f27686o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final n6 f27687p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final n6 f27688q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final n6 f27689r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final /* synthetic */ n6[] f27690s = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f27691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f27692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f27693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f27694d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f27695e;

    static {
        n6 r100 = new n6("MIUI", 0, x5.b("IeGlhb21p"));
        f27677f = r100;
        n6 r101 = new n6("Flyme", 1, x5.b("IbWVpenU"));
        f27678g = r101;
        n6 r102 = new n6("RH", 2, x5.b("IaHVhd2Vp"));
        f27679h = r102;
        n6 r103 = new n6("ColorOS", 3, x5.b("Ib3Bwbw"));
        f27680i = r103;
        n6 r104 = new n6("FuntouchOS", 4, x5.b("Idml2bw"));
        f27681j = r104;
        n6 r105 = new n6("SmartisanOS", 5, x5.b("Mc21hcnRpc2Fu"));
        f27682k = r105;
        n6 r110 = new n6("AmigoOS", 6, x5.b("IYW1pZ28"));
        f27683l = r110;
        n6 r111 = new n6("EUI", 7, x5.b("IbGV0dg"));
        f27684m = r111;
        n6 r112 = new n6("Sense", 8, x5.b("EaHRj"));
        f27685n = r112;
        n6 r113 = new n6("LG", 9, x5.b("EbGdl"));
        f27686o = r113;
        n6 r114 = new n6(LocationInfoConst.GOOGLE, 10, x5.b("IZ29vZ2xl"));
        f27687p = r114;
        n6 r106 = new n6("NubiaUI", 11, x5.b("IbnViaWE"));
        f27688q = r106;
        n6 r107 = new n6("Other", 12, "");
        f27689r = r107;
        f27690s = new n6[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107};
    }

    public static n6[] values() {
        return (n6[]) f27690s.clone();
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "ROM{name='" + name() + "',versionCode=" + this.f27692b + ", versionName='" + this.f27694d + "',ma=" + this.f27691a + "',manufacturer=" + this.f27695e + "'}";
    }

    public final String a() {
        return this.f27691a;
    }

    public final String b() {
        return this.f27693c;
    }

    public static n6 valueOf(String r100) {
        return (n6) r27.a.a(n6.class, r100);
    }

    public final void a(int r100) {
        this.f27692b = r100;
    }

    public final void b(String r100) {
        this.f27694d = r100;
    }

    public final void a(String r100) {
        this.f27693c = r100;
    }

    private n6(String r100, int r101, String r102) {
        super(r100, r101);
        this.f27695e = Build.MANUFACTURER;
        this.f27691a = r102;
    }
}
