package s8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class u0 extends pb.h implements xb.p {

    /* renamed from: f, reason: collision with root package name */
    public o1.s f11989f;

    /* renamed from: g, reason: collision with root package name */
    public yb.s f11990g;

    /* renamed from: h, reason: collision with root package name */
    public b1 f11991h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f11992j;

    /* renamed from: k, reason: collision with root package name */
    public int f11993k;

    /* renamed from: l, reason: collision with root package name */
    public /* synthetic */ Object f11994l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ xb.l f11995m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ float f11996n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ xb.l f11997o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ float f11998p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ float f11999q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ int f12000r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ xb.l f12001s;

    /* renamed from: t, reason: collision with root package name */
    public final /* synthetic */ xb.l f12002t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u0(xb.l lVar, float f5, xb.l lVar2, float f10, float f11, int i, xb.l lVar3, xb.l lVar4, nb.c cVar) {
        super(cVar);
        this.f11995m = lVar;
        this.f11996n = f5;
        this.f11997o = lVar2;
        this.f11998p = f10;
        this.f11999q = f11;
        this.f12000r = i;
        this.f12001s = lVar3;
        this.f12002t = lVar4;
    }

    public static final void a(xb.l lVar, yb.s sVar, xb.l lVar2, float f5, float f10, int i, float f11) {
        int iQ = p5.f.q((int) (p5.f.p(f11, 0.0f, f5) / f10), 0, i - 1);
        if (((Boolean) lVar.invoke(Integer.valueOf(iQ))).booleanValue() && iQ != sVar.f16096c) {
            sVar.f16096c = iQ;
            lVar2.invoke(Integer.valueOf(iQ));
        }
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        u0 u0Var = new u0(this.f11995m, this.f11996n, this.f11997o, this.f11998p, this.f11999q, this.f12000r, this.f12001s, this.f12002t, cVar);
        u0Var.f11994l = obj;
        return u0Var;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        return ((u0) create((o1.h0) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0040, code lost:
    
        if (r3 == r2) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0097, code lost:
    
        if (r11 != r2) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0099, code lost:
    
        return r2;
     */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0097 -> B:7:0x0025). Please report as a decompilation issue!!! */
    @Override // pb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r24) {
        /*
            Method dump skipped, instructions count: 399
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s8.u0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
