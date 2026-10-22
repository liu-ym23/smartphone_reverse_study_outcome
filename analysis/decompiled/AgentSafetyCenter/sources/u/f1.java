package u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f1 extends pb.h implements xb.p {

    /* renamed from: f, reason: collision with root package name */
    public int f13456f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f13457g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ kc.t f13458h;
    public final /* synthetic */ t.q i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ a2.m f13459j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ i0 f13460k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f1(kc.t tVar, t.q qVar, a2.m mVar, i0 i0Var, nb.c cVar) {
        super(cVar);
        this.f13458h = tVar;
        this.i = qVar;
        this.f13459j = mVar;
        this.f13460k = i0Var;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        f1 f1Var = new f1(this.f13458h, this.i, this.f13459j, this.f13460k, cVar);
        f1Var.f13457g = obj;
        return f1Var;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        return ((f1) create((o1.h0) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0061, code lost:
    
        if (r13 == r0) goto L18;
     */
    @Override // pb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            ob.a r0 = ob.a.f9351c
            int r1 = r12.f13456f
            kc.t r2 = r12.f13458h
            r3 = 3
            r4 = 2
            r5 = 1
            u.i0 r8 = r12.f13460k
            r10 = 0
            if (r1 == 0) goto L25
            if (r1 == r5) goto L1d
            if (r1 != r4) goto L16
            id.c.I(r13)
            goto L64
        L16:
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r12)
            r12 = 0
            return r12
        L1d:
            java.lang.Object r1 = r12.f13457g
            o1.h0 r1 = (o1.h0) r1
            id.c.I(r13)
            goto L41
        L25:
            id.c.I(r13)
            java.lang.Object r13 = r12.f13457g
            r1 = r13
            o1.h0 r1 = (o1.h0) r1
            u.d1 r13 = new u.d1
            r6 = 0
            r13.<init>(r8, r10, r6)
            kc.w.u(r2, r10, r10, r13, r3)
            r12.f13457g = r1
            r12.f13456f = r5
            java.lang.Object r13 = u.l1.c(r1, r12, r3)
            if (r13 != r0) goto L41
            goto L63
        L41:
            r9 = r13
            o1.s r9 = (o1.s) r9
            r9.a()
            u.b0 r13 = u.l1.f13522a
            t.q r7 = r12.i
            if (r7 == r13) goto L57
            androidx.lifecycle.l0 r6 = new androidx.lifecycle.l0
            r11 = 24
            r6.<init>(r7, r8, r9, r10, r11)
            kc.w.u(r2, r10, r10, r6, r3)
        L57:
            r12.f13457g = r10
            r12.f13456f = r4
            o1.k r13 = o1.k.f9060f
            java.lang.Object r13 = u.l1.d(r1, r13, r12)
            if (r13 != r0) goto L64
        L63:
            return r0
        L64:
            o1.s r13 = (o1.s) r13
            if (r13 != 0) goto L72
            u.e1 r12 = new u.e1
            r13 = 0
            r12.<init>(r8, r10, r13)
            kc.w.u(r2, r10, r10, r12, r3)
            goto L89
        L72:
            r13.a()
            u.e1 r0 = new u.e1
            r1 = 1
            r0.<init>(r8, r10, r1)
            kc.w.u(r2, r10, r10, r0, r3)
            long r0 = r13.f9073c
            c1.b r13 = c1.b.a(r0)
            a2.m r12 = r12.f13459j
            r12.invoke(r13)
        L89:
            jb.v r12 = jb.v.f6774a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: u.f1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
