package x8;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: k, reason: collision with root package name */
    public static final q f11275k = new q(false, false, false, false, false, new q(false, false, false, false, false, null, false, null, null, 1023), false, null, null, 988);

    /* renamed from: a, reason: collision with root package name */
    public final boolean f11276a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f11277b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f11278c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f11279d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f11280e;

    /* renamed from: f, reason: collision with root package name */
    public final q f11281f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f11282g;

    /* renamed from: h, reason: collision with root package name */
    public final q f11283h;

    /* renamed from: i, reason: collision with root package name */
    public final q f11284i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f11285j;

    public q(boolean z4, boolean z10, boolean z11, boolean z12, boolean z13, q qVar, boolean z14, q qVar2, q qVar3, int i2) {
        z4 = (i2 & 1) != 0 ? true : z4;
        z10 = (i2 & 2) != 0 ? true : z10;
        z11 = (i2 & 4) != 0 ? false : z11;
        z12 = (i2 & 8) != 0 ? false : z12;
        z13 = (i2 & 16) != 0 ? false : z13;
        qVar = (i2 & 32) != 0 ? null : qVar;
        z14 = (i2 & 64) != 0 ? true : z14;
        qVar2 = (i2 & 128) != 0 ? qVar : qVar2;
        qVar3 = (i2 & 256) != 0 ? qVar : qVar3;
        boolean z15 = (i2 & 512) == 0;
        this.f11276a = z4;
        this.f11277b = z10;
        this.f11278c = z11;
        this.f11279d = z12;
        this.f11280e = z13;
        this.f11281f = qVar;
        this.f11282g = z14;
        this.f11283h = qVar2;
        this.f11284i = qVar3;
        this.f11285j = z15;
    }
}
