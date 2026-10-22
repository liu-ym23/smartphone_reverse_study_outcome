package m4;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class g0 extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f6197f;

    /* renamed from: g, reason: collision with root package name */
    public Object f6198g;

    /* renamed from: h, reason: collision with root package name */
    public Serializable f6199h;

    /* renamed from: i, reason: collision with root package name */
    public Serializable f6200i;

    /* renamed from: j, reason: collision with root package name */
    public Object f6201j;

    /* renamed from: k, reason: collision with root package name */
    public int f6202k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f6203l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Serializable f6204m;

    /* renamed from: n, reason: collision with root package name */
    public Object f6205n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Object f6206o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g0(q0 q0Var, a6.w wVar, Object obj, g7.d dVar, int i2) {
        super(2, dVar);
        this.f6197f = i2;
        this.f6203l = q0Var;
        this.f6204m = wVar;
        this.f6206o = obj;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f6197f) {
            case 0:
                return new g0((q0) this.f6203l, (a6.w) this.f6204m, (a6.y) this.f6206o, dVar, 0);
            case 1:
                return new g0((q0) this.f6203l, (a6.w) this.f6204m, (a6.a0) this.f6206o, dVar, 1);
            case 2:
                return new g0((q0) this.f6203l, (a6.w) this.f6204m, (a6.c) this.f6206o, dVar, 2);
            case 3:
                return new g0((q0) this.f6203l, (a6.w) this.f6204m, (String) this.f6206o, dVar, 3);
            default:
                g0 g0Var = new g0((p.s0) this.f6201j, (c1.q) this.f6203l, (p.u) this.f6199h, (g1.y) this.f6200i, (p.t) this.f6204m, (p.t) this.f6205n, (h9.b) this.f6206o, dVar);
                g0Var.f6198g = obj;
                return g0Var;
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        ia.b0 b0Var = (ia.b0) obj;
        g7.d dVar = (g7.d) obj2;
        switch (this.f6197f) {
        }
        return ((g0) create(b0Var, dVar)).invokeSuspend(c7.r.f1986a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x01dc, code lost:
    
        return n7.l.N(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00f9, code lost:
    
        if (r1 != null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x013c, code lost:
    
        if (r1 != null) goto L53;
     */
    /* JADX WARN: Removed duplicated region for block: B:138:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x046c  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x048a  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x048f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x019e  */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.g0.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(p.s0 s0Var, c1.q qVar, p.u uVar, g1.y yVar, p.t tVar, p.t tVar2, h9.b bVar, g7.d dVar) {
        super(2, dVar);
        this.f6197f = 4;
        this.f6201j = s0Var;
        this.f6203l = qVar;
        this.f6199h = uVar;
        this.f6200i = yVar;
        this.f6204m = tVar;
        this.f6205n = tVar2;
        this.f6206o = bVar;
    }
}
