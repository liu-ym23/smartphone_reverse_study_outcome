package e1;

import b8.z;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final float[] f3342a;

    /* renamed from: b, reason: collision with root package name */
    public static final float[] f3343b;

    /* renamed from: c, reason: collision with root package name */
    public static final r f3344c;

    /* renamed from: d, reason: collision with root package name */
    public static final r f3345d;

    /* renamed from: e, reason: collision with root package name */
    public static final q f3346e;

    /* renamed from: f, reason: collision with root package name */
    public static final q f3347f;

    /* renamed from: g, reason: collision with root package name */
    public static final q f3348g;

    /* renamed from: h, reason: collision with root package name */
    public static final q f3349h;
    public static final q i;

    /* renamed from: j, reason: collision with root package name */
    public static final q f3350j;

    /* renamed from: k, reason: collision with root package name */
    public static final q f3351k;

    /* renamed from: l, reason: collision with root package name */
    public static final q f3352l;

    /* renamed from: m, reason: collision with root package name */
    public static final q f3353m;

    /* renamed from: n, reason: collision with root package name */
    public static final q f3354n;

    /* renamed from: o, reason: collision with root package name */
    public static final q f3355o;

    /* renamed from: p, reason: collision with root package name */
    public static final q f3356p;

    /* renamed from: q, reason: collision with root package name */
    public static final q f3357q;

    /* renamed from: r, reason: collision with root package name */
    public static final q f3358r;

    /* renamed from: s, reason: collision with root package name */
    public static final k f3359s;

    /* renamed from: t, reason: collision with root package name */
    public static final k f3360t;

    /* renamed from: u, reason: collision with root package name */
    public static final q f3361u;

    /* renamed from: v, reason: collision with root package name */
    public static final q f3362v;

    /* renamed from: w, reason: collision with root package name */
    public static final q f3363w;

    /* renamed from: x, reason: collision with root package name */
    public static final l f3364x;

    /* renamed from: y, reason: collision with root package name */
    public static final c[] f3365y;

    static {
        float[] fArr = {0.64f, 0.33f, 0.3f, 0.6f, 0.15f, 0.06f};
        f3342a = fArr;
        float[] fArr2 = {0.67f, 0.33f, 0.21f, 0.71f, 0.14f, 0.08f};
        f3343b = fArr2;
        float[] fArr3 = {0.708f, 0.292f, 0.17f, 0.797f, 0.131f, 0.046f};
        r rVar = new r(2.4d, 0.9478672985781991d, 0.05213270142180095d, 0.07739938080495357d, 0.04045d);
        r rVar2 = new r(2.2d, 0.9478672985781991d, 0.05213270142180095d, 0.07739938080495357d, 0.04045d);
        r rVar3 = new r(-3.0d, 2.0d, 2.0d, 5.591816309728916d, 0.28466892d, 0.55991073d, -0.685490157d);
        f3344c = rVar3;
        r rVar4 = new r(-2.0d, -1.555223d, 1.860454d, 0.012683313515655966d, 18.8515625d, -18.6875d, 6.277394636015326d);
        f3345d = rVar4;
        s sVar = j.f3377d;
        q qVar = new q("sRGB IEC61966-2.1", fArr, sVar, rVar, 0);
        f3346e = qVar;
        q qVar2 = new q("sRGB IEC61966-2.1 (Linear)", fArr, sVar, 1.0d, 0.0f, 1.0f, 1);
        f3347f = qVar2;
        q qVar3 = new q("scRGB-nl IEC 61966-2-2:2003", fArr, sVar, null, new z(21), new z(22), -0.799f, 2.399f, rVar, 2);
        f3348g = qVar3;
        q qVar4 = new q("scRGB IEC 61966-2-2:2003", fArr, sVar, 1.0d, -0.5f, 7.499f, 3);
        f3349h = qVar4;
        q qVar5 = new q("Rec. ITU-R BT.709-5", new float[]{0.64f, 0.33f, 0.3f, 0.6f, 0.15f, 0.06f}, sVar, new r(2.2222222222222223d, 0.9099181073703367d, 0.09008189262966333d, 0.2222222222222222d, 0.081d), 4);
        i = qVar5;
        q qVar6 = new q("Rec. ITU-R BT.2020-1", new float[]{0.708f, 0.292f, 0.17f, 0.797f, 0.131f, 0.046f}, sVar, new r(2.2222222222222223d, 0.9096697898662786d, 0.09033021013372146d, 0.2222222222222222d, 0.08145d), 5);
        f3350j = qVar6;
        q qVar7 = new q("SMPTE RP 431-2-2007 DCI (P3)", new float[]{0.68f, 0.32f, 0.265f, 0.69f, 0.15f, 0.06f}, new s(0.314f, 0.351f), 2.6d, 0.0f, 1.0f, 6);
        f3351k = qVar7;
        q qVar8 = new q("Display P3", new float[]{0.68f, 0.32f, 0.265f, 0.69f, 0.15f, 0.06f}, sVar, rVar, 7);
        f3352l = qVar8;
        q qVar9 = new q("NTSC (1953)", fArr2, j.f3374a, new r(2.2222222222222223d, 0.9099181073703367d, 0.09008189262966333d, 0.2222222222222222d, 0.081d), 8);
        f3353m = qVar9;
        q qVar10 = new q("SMPTE-C RGB", new float[]{0.63f, 0.34f, 0.31f, 0.595f, 0.155f, 0.07f}, sVar, new r(2.2222222222222223d, 0.9099181073703367d, 0.09008189262966333d, 0.2222222222222222d, 0.081d), 9);
        f3354n = qVar10;
        q qVar11 = new q("Adobe RGB (1998)", new float[]{0.64f, 0.33f, 0.21f, 0.71f, 0.15f, 0.06f}, sVar, 2.2d, 0.0f, 1.0f, 10);
        f3355o = qVar11;
        q qVar12 = new q("ROMM RGB ISO 22028-2:2013", new float[]{0.7347f, 0.2653f, 0.1596f, 0.8404f, 0.0366f, 1.0E-4f}, j.f3375b, new r(1.8d, 1.0d, 0.0d, 0.0625d, 0.031248d), 11);
        f3356p = qVar12;
        s sVar2 = j.f3376c;
        q qVar13 = new q("SMPTE ST 2065-1:2012 ACES", new float[]{0.7347f, 0.2653f, 0.0f, 1.0f, 1.0E-4f, -0.077f}, sVar2, 1.0d, -65504.0f, 65504.0f, 12);
        f3357q = qVar13;
        q qVar14 = new q("Academy S-2014-004 ACEScg", new float[]{0.713f, 0.293f, 0.165f, 0.83f, 0.128f, 0.044f}, sVar2, 1.0d, -65504.0f, 65504.0f, 13);
        f3358r = qVar14;
        k kVar = new k(14, 1, b.f3335b, "Generic XYZ");
        f3359s = kVar;
        long j10 = b.f3336c;
        k kVar2 = new k(15, 0, j10, "Generic L*a*b*");
        f3360t = kVar2;
        q qVar15 = new q("None", fArr, sVar, rVar2, 16);
        f3361u = qVar15;
        q qVar16 = new q("Hybrid Log Gamma encoding", fArr3, sVar, null, new z(23), new z(24), 0.0f, 1.0f, rVar3, 17);
        f3362v = qVar16;
        q qVar17 = new q("Perceptual Quantizer encoding", fArr3, sVar, null, new z(25), new z(26), 0.0f, 1.0f, rVar4, 18);
        f3363w = qVar17;
        l lVar = new l("Oklab", j10, 19);
        f3364x = lVar;
        f3365y = new c[]{qVar, qVar2, qVar3, qVar4, qVar5, qVar6, qVar7, qVar8, qVar9, qVar10, qVar11, qVar12, qVar13, qVar14, kVar, kVar2, qVar15, qVar16, qVar17, lVar};
    }

    public static double a(r rVar, double d7) {
        double d10 = d7 < 0.0d ? -1.0d : 1.0d;
        double d11 = d7 * d10;
        double d12 = rVar.f3407b;
        double d13 = rVar.f3408c;
        double d14 = rVar.f3409d;
        double d15 = rVar.f3410e;
        double d16 = rVar.f3411f;
        double d17 = d12 * d11;
        return (rVar.f3412g + 1.0d) * d10 * (d17 <= 1.0d ? Math.pow(d17, d13) : Math.exp((d11 - d16) * d14) + d15);
    }

    public static double b(r rVar, double d7) {
        double d10 = d7 < 0.0d ? -1.0d : 1.0d;
        double d11 = 1.0d / rVar.f3407b;
        double d12 = 1.0d / rVar.f3408c;
        double d13 = 1.0d / rVar.f3409d;
        double d14 = rVar.f3410e;
        double d15 = rVar.f3411f;
        double d16 = (d7 * d10) / (rVar.f3412g + 1.0d);
        return d10 * (d16 <= 1.0d ? Math.pow(d16, d12) * d11 : (Math.log(d16 - d14) * d13) + d15);
    }

    public static double c(r rVar, double d7) {
        double d10 = d7 < 0.0d ? -1.0d : 1.0d;
        double d11 = d7 * d10;
        double d12 = rVar.f3407b;
        double d13 = rVar.f3409d;
        double dPow = (Math.pow(d11, d13) * rVar.f3408c) + d12;
        return Math.pow((dPow >= 0.0d ? dPow : 0.0d) / ((Math.pow(d11, d13) * rVar.f3411f) + rVar.f3410e), rVar.f3412g) * d10;
    }

    public static double d(r rVar, double d7) {
        double d10 = d7 < 0.0d ? -1.0d : 1.0d;
        double d11 = d7 * d10;
        double d12 = -rVar.f3407b;
        double d13 = rVar.f3410e;
        double d14 = 1.0d / rVar.f3412g;
        return Math.pow(Math.max((Math.pow(d11, d14) * d13) + d12, 0.0d) / ((Math.pow(d11, d14) * (-rVar.f3411f)) + rVar.f3408c), 1.0d / rVar.f3409d) * d10;
    }
}
