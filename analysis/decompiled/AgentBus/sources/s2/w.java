package s2;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class w extends i7.i implements p7.k {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f9447f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f9448g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ z f9449h;

    /* renamed from: i, reason: collision with root package name */
    public Object f9450i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f9451j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Serializable f9452k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(q7.v vVar, z zVar, q7.t tVar, g7.d dVar) {
        super(1, dVar);
        this.f9451j = vVar;
        this.f9449h = zVar;
        this.f9452k = tVar;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [i7.i, p7.n] */
    @Override // i7.a
    public final g7.d create(g7.d dVar) {
        switch (this.f9447f) {
            case 0:
                return new w((q7.v) this.f9451j, this.f9449h, (q7.t) this.f9452k, dVar);
            default:
                return new w(this.f9449h, (g7.l) this.f9451j, (p7.n) this.f9452k, dVar);
        }
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        g7.d dVar = (g7.d) obj;
        switch (this.f9447f) {
        }
        return ((w) create(dVar)).invokeSuspend(c7.r.f1986a);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007b  */
    /* JADX WARN: Type inference failed for: r7v2, types: [i7.i, p7.n] */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s2.w.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public w(z zVar, g7.l lVar, p7.n nVar, g7.d dVar) {
        super(1, dVar);
        this.f9449h = zVar;
        this.f9451j = lVar;
        this.f9452k = (i7.i) nVar;
    }
}
