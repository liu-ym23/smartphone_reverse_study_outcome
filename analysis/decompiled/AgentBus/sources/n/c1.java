package n;

/* loaded from: classes.dex */
public final class c1 extends q7.m implements p7.k {

    /* renamed from: h, reason: collision with root package name */
    public static final c1 f6568h;

    /* renamed from: i, reason: collision with root package name */
    public static final c1 f6569i;

    /* renamed from: j, reason: collision with root package name */
    public static final c1 f6570j;

    /* renamed from: k, reason: collision with root package name */
    public static final c1 f6571k;

    /* renamed from: l, reason: collision with root package name */
    public static final c1 f6572l;

    /* renamed from: m, reason: collision with root package name */
    public static final c1 f6573m;

    /* renamed from: n, reason: collision with root package name */
    public static final c1 f6574n;

    /* renamed from: o, reason: collision with root package name */
    public static final c1 f6575o;

    /* renamed from: p, reason: collision with root package name */
    public static final c1 f6576p;

    /* renamed from: q, reason: collision with root package name */
    public static final c1 f6577q;

    /* renamed from: r, reason: collision with root package name */
    public static final c1 f6578r;

    /* renamed from: s, reason: collision with root package name */
    public static final c1 f6579s;

    /* renamed from: t, reason: collision with root package name */
    public static final c1 f6580t;

    /* renamed from: u, reason: collision with root package name */
    public static final c1 f6581u;

    /* renamed from: v, reason: collision with root package name */
    public static final c1 f6582v;

    /* renamed from: w, reason: collision with root package name */
    public static final c1 f6583w;

    /* renamed from: x, reason: collision with root package name */
    public static final c1 f6584x;

    /* renamed from: y, reason: collision with root package name */
    public static final c1 f6585y;

    /* renamed from: z, reason: collision with root package name */
    public static final c1 f6586z;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f6587g;

    static {
        int i2 = 1;
        f6568h = new c1(i2, 0);
        f6569i = new c1(i2, 1);
        f6570j = new c1(i2, 2);
        f6571k = new c1(i2, 3);
        f6572l = new c1(i2, 4);
        f6573m = new c1(i2, 5);
        f6574n = new c1(i2, 6);
        f6575o = new c1(i2, 7);
        f6576p = new c1(i2, 8);
        f6577q = new c1(i2, 9);
        f6578r = new c1(i2, 10);
        f6579s = new c1(i2, 11);
        f6580t = new c1(i2, 12);
        f6581u = new c1(i2, 13);
        f6582v = new c1(i2, 14);
        f6583w = new c1(i2, 15);
        f6584x = new c1(i2, 16);
        f6585y = new c1(i2, 17);
        f6586z = new c1(i2, 18);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c1(int i2, int i10) {
        super(i2);
        this.f6587g = i10;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        switch (this.f6587g) {
            case 0:
                ((p7.a) obj).c();
                return c7.r.f1986a;
            case 1:
                long j2 = ((d2.g) obj).f2785a;
                return new k(Float.intBitsToFloat((int) (j2 >> 32)), Float.intBitsToFloat((int) (j2 & 4294967295L)));
            case 2:
                float f10 = ((k) obj).f6640a;
                return new d2.g((Float.floatToRawIntBits(r5.f6641b) & 4294967295L) | (Float.floatToRawIntBits(f10) << 32));
            case 3:
                return new j(((d2.f) obj).f2784f);
            case 4:
                return new d2.f(((j) obj).f6639a);
            case 5:
                return new j(((Number) obj).floatValue());
            case 6:
                return Float.valueOf(((j) obj).f6639a);
            case 7:
                long j4 = ((d2.i) obj).f2786a;
                return new k((int) (j4 >> 32), (int) (j4 & 4294967295L));
            case 8:
                k kVar = (k) obj;
                return new d2.i(a.a.c(Math.round(kVar.f6640a), Math.round(kVar.f6641b)));
            case 9:
                long j10 = ((d2.k) obj).f2792a;
                return new k((int) (j10 >> 32), (int) (j10 & 4294967295L));
            case 10:
                k kVar2 = (k) obj;
                int iRound = Math.round(kVar2.f6640a);
                if (iRound < 0) {
                    iRound = 0;
                }
                int iRound2 = Math.round(kVar2.f6641b);
                return new d2.k(ib.k.a(iRound, iRound2 >= 0 ? iRound2 : 0));
            case 11:
                return new j(((Number) obj).intValue());
            case 12:
                return Integer.valueOf((int) ((j) obj).f6639a);
            case 13:
                long j11 = ((t0.b) obj).f9654a;
                return new k(t0.b.d(j11), t0.b.e(j11));
            case com.google.protobuf.y0.EDITION_FIELD_NUMBER /* 14 */:
                k kVar3 = (k) obj;
                return new t0.b(n7.b.b(kVar3.f6640a, kVar3.f6641b));
            case com.google.protobuf.x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                t0.c cVar = (t0.c) obj;
                return new m(cVar.f9656a, cVar.f9657b, cVar.f9658c, cVar.f9659d);
            case 16:
                m mVar = (m) obj;
                return new t0.c(mVar.f6655a, mVar.f6656b, mVar.f6657c, mVar.f6658d);
            case 17:
                long j12 = ((t0.e) obj).f9668a;
                return new k(t0.e.d(j12), t0.e.b(j12));
            default:
                k kVar4 = (k) obj;
                return new t0.e(nb.i.e(kVar4.f6640a, kVar4.f6641b));
        }
    }
}
