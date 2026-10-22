package s;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class v0 extends yb.l implements xb.l {

    /* renamed from: f, reason: collision with root package name */
    public static final v0 f11132f;

    /* renamed from: g, reason: collision with root package name */
    public static final v0 f11133g;

    /* renamed from: h, reason: collision with root package name */
    public static final v0 f11134h;
    public static final v0 i;

    /* renamed from: j, reason: collision with root package name */
    public static final v0 f11135j;

    /* renamed from: k, reason: collision with root package name */
    public static final v0 f11136k;

    /* renamed from: l, reason: collision with root package name */
    public static final v0 f11137l;

    /* renamed from: m, reason: collision with root package name */
    public static final v0 f11138m;

    /* renamed from: n, reason: collision with root package name */
    public static final v0 f11139n;

    /* renamed from: o, reason: collision with root package name */
    public static final v0 f11140o;

    /* renamed from: p, reason: collision with root package name */
    public static final v0 f11141p;

    /* renamed from: q, reason: collision with root package name */
    public static final v0 f11142q;

    /* renamed from: r, reason: collision with root package name */
    public static final v0 f11143r;

    /* renamed from: s, reason: collision with root package name */
    public static final v0 f11144s;

    /* renamed from: t, reason: collision with root package name */
    public static final v0 f11145t;

    /* renamed from: u, reason: collision with root package name */
    public static final v0 f11146u;

    /* renamed from: v, reason: collision with root package name */
    public static final v0 f11147v;

    /* renamed from: w, reason: collision with root package name */
    public static final v0 f11148w;

    /* renamed from: x, reason: collision with root package name */
    public static final v0 f11149x;

    /* renamed from: y, reason: collision with root package name */
    public static final v0 f11150y;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f11151c;

    static {
        int i3 = 1;
        f11132f = new v0(i3, 0);
        f11133g = new v0(i3, 1);
        f11134h = new v0(i3, 2);
        i = new v0(i3, 3);
        f11135j = new v0(i3, 4);
        f11136k = new v0(i3, 5);
        f11137l = new v0(i3, 6);
        f11138m = new v0(i3, 7);
        f11139n = new v0(i3, 8);
        f11140o = new v0(i3, 9);
        f11141p = new v0(i3, 10);
        f11142q = new v0(i3, 11);
        f11143r = new v0(i3, 12);
        f11144s = new v0(i3, 13);
        f11145t = new v0(i3, 14);
        f11146u = new v0(i3, 15);
        f11147v = new v0(i3, 16);
        f11148w = new v0(i3, 17);
        f11149x = new v0(i3, 18);
        f11150y = new v0(i3, 19);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ v0(int i3, int i10) {
        super(i3);
        this.f11151c = i10;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        int i3 = this.f11151c;
        jb.v vVar = jb.v.f6774a;
        switch (i3) {
            case 0:
                return vVar;
            case 1:
                ((xb.a) obj).invoke();
                return vVar;
            case 2:
                long j10 = ((o2.g) obj).f9115a;
                return new k(Float.intBitsToFloat((int) (j10 >> 32)), Float.intBitsToFloat((int) (j10 & 4294967295L)));
            case 3:
                k kVar = (k) obj;
                float f5 = kVar.f11036a;
                float f10 = kVar.f11037b;
                long jFloatToRawIntBits = Float.floatToRawIntBits(f5);
                o2.g gVar = new o2.g();
                gVar.f9115a = (Float.floatToRawIntBits(f10) & 4294967295L) | (jFloatToRawIntBits << 32);
                VarHandle.storeStoreFence();
                return gVar;
            case 4:
                return new j(((o2.f) obj).f9114c);
            case 5:
                return o2.f.a(((j) obj).f11034a);
            case 6:
                return new j(((Number) obj).floatValue());
            case 7:
                return Float.valueOf(((j) obj).f11034a);
            case 8:
                long j11 = ((o2.i) obj).f9116a;
                return new k((int) (j11 >> 32), (int) (j11 & 4294967295L));
            case 9:
                k kVar2 = (k) obj;
                return o2.i.a(td.h.c(Math.round(kVar2.f11036a), Math.round(kVar2.f11037b)));
            case 10:
                long j12 = ((o2.k) obj).f9122a;
                return new k((int) (j12 >> 32), (int) (j12 & 4294967295L));
            case 11:
                k kVar3 = (k) obj;
                int iRound = Math.round(kVar3.f11036a);
                if (iRound < 0) {
                    iRound = 0;
                }
                int iRound2 = Math.round(kVar3.f11037b);
                return o2.k.a(ac.a.b(iRound, iRound2 >= 0 ? iRound2 : 0));
            case 12:
                return new j(((Number) obj).intValue());
            case 13:
                return Integer.valueOf((int) ((j) obj).f11034a);
            case 14:
                long j13 = ((c1.b) obj).f2165a;
                return new k(c1.b.e(j13), c1.b.f(j13));
            case 15:
                k kVar4 = (k) obj;
                return c1.b.a(id.k.d(kVar4.f11036a, kVar4.f11037b));
            case 16:
                c1.c cVar = (c1.c) obj;
                return new m(cVar.f2167a, cVar.f2168b, cVar.f2169c, cVar.f2170d);
            case 17:
                m mVar = (m) obj;
                return new c1.c(mVar.f11050a, mVar.f11051b, mVar.f11052c, mVar.f11053d);
            case 18:
                long j14 = ((c1.e) obj).f2179a;
                return new k(c1.e.e(j14), c1.e.c(j14));
            default:
                k kVar5 = (k) obj;
                return c1.e.a(a.a.e(kVar5.f11036a, kVar5.f11037b));
        }
    }
}
