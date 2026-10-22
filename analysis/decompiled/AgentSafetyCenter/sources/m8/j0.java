package m8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j0 extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8406c;

    /* renamed from: f, reason: collision with root package name */
    public int f8407f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ long f8408g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f8409h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0(long j10, o1.h0 h0Var, nb.c cVar) {
        super(2, cVar);
        this.f8406c = 1;
        this.f8408g = j10;
        this.f8409h = h0Var;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f8406c) {
            case 0:
                return new j0((k0) this.f8409h, this.f8408g, cVar, 0);
            case 1:
                return new j0(this.f8408g, (o1.h0) this.f8409h, cVar);
            default:
                return new j0((r2.h) this.f8409h, this.f8408g, cVar, 2);
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        kc.t tVar = (kc.t) obj;
        nb.c cVar = (nb.c) obj2;
        switch (this.f8406c) {
        }
        return ((j0) create(tVar, cVar)).invokeSuspend(jb.v.f6774a);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006e  */
    @Override // pb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            int r0 = r10.f8406c
            switch(r0) {
                case 0: goto L7d;
                case 1: goto L30;
                default: goto L5;
            }
        L5:
            ob.a r0 = ob.a.f9351c
            int r1 = r10.f8407f
            r2 = 1
            if (r1 == 0) goto L19
            if (r1 != r2) goto L12
            id.c.I(r11)
            goto L2d
        L12:
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r10)
            r0 = 0
            goto L2f
        L19:
            id.c.I(r11)
            java.lang.Object r11 = r10.f8409h
            r2.h r11 = (r2.h) r11
            n1.d r11 = r11.f10387c
            r10.f8407f = r2
            long r1 = r10.f8408g
            java.lang.Object r10 = r11.b(r1, r10)
            if (r10 != r0) goto L2d
            goto L2f
        L2d:
            jb.v r0 = jb.v.f6774a
        L2f:
            return r0
        L30:
            ob.a r0 = ob.a.f9351c
            int r1 = r10.f8407f
            r2 = 8
            long r4 = r10.f8408g
            r6 = 2
            r7 = 1
            if (r1 == 0) goto L4f
            if (r1 == r7) goto L4b
            if (r1 != r6) goto L44
            id.c.I(r11)
            goto L66
        L44:
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r10)
            r0 = 0
            goto L7c
        L4b:
            id.c.I(r11)
            goto L5d
        L4f:
            id.c.I(r11)
            long r8 = r4 - r2
            r10.f8407f = r7
            java.lang.Object r11 = kc.w.g(r8, r10)
            if (r11 != r0) goto L5d
            goto L7c
        L5d:
            r10.f8407f = r6
            java.lang.Object r11 = kc.w.g(r2, r10)
            if (r11 != r0) goto L66
            goto L7c
        L66:
            java.lang.Object r10 = r10.f8409h
            o1.h0 r10 = (o1.h0) r10
            kc.g r10 = r10.f9043g
            if (r10 == 0) goto L7a
            o1.l r11 = new o1.l
            r11.<init>(r4)
            jb.h r11 = id.c.l(r11)
            r10.resumeWith(r11)
        L7a:
            jb.v r0 = jb.v.f6774a
        L7c:
            return r0
        L7d:
            ob.a r0 = ob.a.f9351c
            int r1 = r10.f8407f
            r2 = 1
            if (r1 == 0) goto L91
            if (r1 != r2) goto L8a
            id.c.I(r11)
            goto La9
        L8a:
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r10)
        L8f:
            r0 = 0
            goto Lba
        L91:
            id.c.I(r11)
            java.lang.Object r11 = r10.f8409h
            m8.k0 r11 = (m8.k0) r11
            q8.t r3 = r11.u()
            r10.f8407f = r2
            long r4 = r10.f8408g
            r6 = r4
            r8 = r10
            java.lang.Object r11 = r3.c(r4, r6, r8)
            if (r11 != r0) goto La9
            goto Lba
        La9:
            java.util.List r11 = (java.util.List) r11
            java.lang.Object r10 = kb.l.x0(r11)
            q8.i r10 = (q8.i) r10
            if (r10 == 0) goto L8f
            long r10 = r10.f10125e
            java.lang.Long r0 = new java.lang.Long
            r0.<init>(r10)
        Lba:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m8.j0.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j0(Object obj, long j10, nb.c cVar, int i) {
        super(2, cVar);
        this.f8406c = i;
        this.f8409h = obj;
        this.f8408g = j10;
    }
}
