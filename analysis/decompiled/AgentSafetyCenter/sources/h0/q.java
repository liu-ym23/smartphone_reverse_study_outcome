package h0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public int f5110c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ s.c f5111f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ float f5112g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ boolean f5113h;
    public final /* synthetic */ v.j i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(s.c cVar, float f5, boolean z10, b1 b1Var, v.j jVar, nb.c cVar2) {
        super(2, cVar2);
        this.f5111f = cVar;
        this.f5112g = f5;
        this.f5113h = z10;
        this.i = jVar;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        return new q(this.f5111f, this.f5112g, this.f5113h, null, this.i, cVar);
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        return ((q) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x00d3 A[RETURN] */
    @Override // pb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 213
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h0.q.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
