package h0;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a0 extends yb.l implements xb.a {

    /* renamed from: f, reason: collision with root package name */
    public static final a0 f4904f;

    /* renamed from: g, reason: collision with root package name */
    public static final a0 f4905g;

    /* renamed from: h, reason: collision with root package name */
    public static final a0 f4906h;
    public static final a0 i;

    /* renamed from: j, reason: collision with root package name */
    public static final a0 f4907j;

    /* renamed from: k, reason: collision with root package name */
    public static final a0 f4908k;

    /* renamed from: l, reason: collision with root package name */
    public static final a0 f4909l;

    /* renamed from: m, reason: collision with root package name */
    public static final a0 f4910m;

    /* renamed from: n, reason: collision with root package name */
    public static final a0 f4911n;

    /* renamed from: o, reason: collision with root package name */
    public static final a0 f4912o;

    /* renamed from: p, reason: collision with root package name */
    public static final a0 f4913p;

    /* renamed from: q, reason: collision with root package name */
    public static final a0 f4914q;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4915c;

    static {
        int i3 = 0;
        f4904f = new a0(i3, 0);
        f4905g = new a0(i3, 1);
        f4906h = new a0(i3, 2);
        i = new a0(i3, 3);
        f4907j = new a0(i3, 4);
        f4908k = new a0(i3, 5);
        f4909l = new a0(i3, 6);
        f4910m = new a0(i3, 7);
        f4911n = new a0(i3, 8);
        f4912o = new a0(i3, 9);
        f4913p = new a0(i3, 10);
        f4914q = new a0(i3, 11);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a0(int i3, int i10) {
        super(i3);
        this.f4915c = i10;
    }

    @Override // xb.a
    public final Object invoke() {
        switch (this.f4915c) {
            case 0:
                return b0.f(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -1, 15);
            case 1:
                return Boolean.TRUE;
            case 2:
                return d1.p.a(d1.p.f3019b);
            case 3:
                return Boolean.TRUE;
            case 4:
                return o2.f.a(48);
            case 5:
                return Boolean.FALSE;
            case 6:
                long j10 = d1.p.f3024g;
                a1 a1Var = new a1();
                a1Var.f4916a = j10;
                VarHandle.storeStoreFence();
                return a1Var;
            case 7:
                return Boolean.FALSE;
            case 8:
                a0.d dVar = k1.f5043a;
                a0.d dVar2 = k1.f5044b;
                a0.d dVar3 = k1.f5045c;
                a0.d dVar4 = k1.f5046d;
                a0.d dVar5 = k1.f5047e;
                l1 l1Var = new l1();
                l1Var.f5054a = dVar;
                l1Var.f5055b = dVar2;
                l1Var.f5056c = dVar3;
                l1Var.f5057d = dVar4;
                l1Var.f5058e = dVar5;
                VarHandle.storeStoreFence();
                return l1Var;
            case 9:
                return o2.f.a(0);
            case 10:
                return j0.p.f6535a;
            default:
                return new v1(null, 32767);
        }
    }
}
