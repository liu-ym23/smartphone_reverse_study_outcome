package v3;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f14672c;

    /* renamed from: f, reason: collision with root package name */
    public int f14673f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ z f14674g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l(z zVar, nb.c cVar, int i) {
        super(2, cVar);
        this.f14672c = i;
        this.f14674g = zVar;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f14672c) {
            case 0:
                return new l(this.f14674g, cVar, 0);
            case 1:
                return new l(this.f14674g, cVar, 1);
            default:
                return new l(this.f14674g, cVar, 2);
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f14672c) {
        }
        return ((l) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0049, code lost:
    
        if (r10 == r1) goto L22;
     */
    @Override // pb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            r9 = this;
            int r0 = r9.f14672c
            jb.v r1 = jb.v.f6774a
            r2 = -1
            r3 = 2
            r4 = 0
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            v3.z r6 = r9.f14674g
            r7 = 1
            switch(r0) {
                case 0: goto La5;
                case 1: goto L59;
                default: goto Lf;
            }
        Lf:
            androidx.room.k r0 = r6.f14758l
            ob.a r1 = ob.a.f9351c
            int r8 = r9.f14673f
            if (r8 == 0) goto L29
            if (r8 == r7) goto L23
            if (r8 != r3) goto L1f
            id.c.I(r10)
            goto L4d
        L1f:
            od.f.e(r5)
            goto L58
        L23:
            id.c.I(r10)     // Catch: java.lang.Throwable -> L27
            goto L42
        L27:
            r9 = move-exception
            goto L51
        L29:
            id.c.I(r10)
            v3.q0 r10 = r0.b()
            boolean r10 = r10 instanceof v3.j0
            if (r10 == 0) goto L39
            v3.q0 r4 = r0.b()
            goto L58
        L39:
            r9.f14673f = r7     // Catch: java.lang.Throwable -> L27
            java.lang.Object r10 = r6.h(r9)     // Catch: java.lang.Throwable -> L27
            if (r10 != r1) goto L42
            goto L4b
        L42:
            r9.f14673f = r3
            r10 = 0
            java.lang.Object r10 = v3.z.e(r6, r10, r9)
            if (r10 != r1) goto L4d
        L4b:
            r4 = r1
            goto L58
        L4d:
            r4 = r10
            v3.q0 r4 = (v3.q0) r4
            goto L58
        L51:
            v3.l0 r4 = new v3.l0
            r4.<init>(r2)
            r4.f14675b = r9
        L58:
            return r4
        L59:
            ob.a r0 = ob.a.f9351c
            int r8 = r9.f14673f
            if (r8 == 0) goto L70
            if (r8 == r7) goto L6c
            if (r8 != r3) goto L67
            id.c.I(r10)
            goto La4
        L67:
            od.f.e(r5)
            r1 = r4
            goto La4
        L6c:
            id.c.I(r10)
            goto L86
        L70:
            id.c.I(r10)
            p5.i r10 = r6.f14759m
            r9.f14673f = r7
            java.lang.Object r10 = r10.f9731f
            kc.l r10 = (kc.l) r10
            java.lang.Object r10 = r10.s(r9)
            if (r10 != r0) goto L82
            goto L83
        L82:
            r10 = r1
        L83:
            if (r10 != r0) goto L86
            goto La3
        L86:
            v3.p0 r10 = r6.g()
            l5.j r10 = r10.f14703c
            nc.g r10 = nc.k0.d(r10, r2)
            e9.u r2 = new e9.u
            r4 = 6
            r2.<init>(r4)
            r2.f3726f = r6
            java.lang.invoke.VarHandle.storeStoreFence()
            r9.f14673f = r3
            java.lang.Object r9 = r10.collect(r2, r9)
            if (r9 != r0) goto La4
        La3:
            r1 = r0
        La4:
            return r1
        La5:
            ob.a r0 = ob.a.f9351c
            int r2 = r9.f14673f
            if (r2 == 0) goto Lb6
            if (r2 != r7) goto Lb1
            id.c.I(r10)
            goto Lc2
        Lb1:
            od.f.e(r5)
            r1 = r4
            goto Lc2
        Lb6:
            id.c.I(r10)
            r9.f14673f = r7
            java.lang.Object r9 = v3.z.d(r6, r9)
            if (r9 != r0) goto Lc2
            r1 = r0
        Lc2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: v3.l.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
