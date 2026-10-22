package m8;

import u.z0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8367c = 0;

    /* renamed from: f, reason: collision with root package name */
    public long f8368f;

    /* renamed from: g, reason: collision with root package name */
    public int f8369g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ long f8370h;
    public final /* synthetic */ Object i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(k0 k0Var, long j10, long j11, nb.c cVar) {
        super(2, cVar);
        this.i = k0Var;
        this.f8368f = j10;
        this.f8370h = j11;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f8367c) {
            case 0:
                return new h((k0) this.i, this.f8368f, this.f8370h, cVar);
            default:
                h hVar = new h((z0) this.i, cVar);
                hVar.f8370h = ((o2.p) obj).f9131a;
                return hVar;
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f8367c) {
            case 0:
                return ((h) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
            default:
                return ((h) create(o2.p.a(((o2.p) obj).f9131a), (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    @Override // pb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            int r0 = r11.f8367c
            switch(r0) {
                case 0: goto L8d;
                default: goto L5;
            }
        L5:
            java.lang.Object r0 = r11.i
            u.z0 r0 = (u.z0) r0
            ob.a r6 = ob.a.f9351c
            int r1 = r11.f8369g
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L3a
            if (r1 == r4) goto L33
            if (r1 == r3) goto L2a
            if (r1 != r2) goto L23
            long r0 = r11.f8368f
            long r2 = r11.f8370h
            id.c.I(r12)
            r7 = r2
            r3 = r0
            r0 = r12
            goto L7c
        L23:
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r0)
            r6 = 0
            goto L8c
        L2a:
            long r3 = r11.f8368f
            long r7 = r11.f8370h
            id.c.I(r12)
            r1 = r12
            goto L62
        L33:
            long r7 = r11.f8370h
            id.c.I(r12)
            r1 = r12
            goto L4c
        L3a:
            id.c.I(r12)
            long r7 = r11.f8370h
            n1.d r1 = r0.f13629f
            r11.f8370h = r7
            r11.f8369g = r4
            java.lang.Object r1 = r1.b(r7, r11)
            if (r1 != r6) goto L4c
            goto L8c
        L4c:
            o2.p r1 = (o2.p) r1
            long r9 = r1.f9131a
            long r9 = o2.p.e(r7, r9)
            r11.f8370h = r7
            r11.f8368f = r9
            r11.f8369g = r3
            java.lang.Object r1 = r0.b(r9, r11)
            if (r1 != r6) goto L61
            goto L8c
        L61:
            r3 = r9
        L62:
            o2.p r1 = (o2.p) r1
            long r9 = r1.f9131a
            n1.d r0 = r0.f13629f
            long r3 = o2.p.e(r3, r9)
            r11.f8370h = r7
            r11.f8368f = r9
            r11.f8369g = r2
            r5 = r11
            r1 = r3
            r3 = r9
            java.lang.Object r0 = r0.a(r1, r3, r5)
            if (r0 != r6) goto L7c
            goto L8c
        L7c:
            o2.p r0 = (o2.p) r0
            long r0 = r0.f9131a
            long r0 = o2.p.e(r3, r0)
            long r0 = o2.p.e(r7, r0)
            o2.p r6 = o2.p.a(r0)
        L8c:
            return r6
        L8d:
            ob.a r6 = ob.a.f9351c
            int r0 = r11.f8369g
            r1 = 1
            if (r0 == 0) goto La2
            if (r0 != r1) goto L9b
            id.c.I(r12)
            r0 = r12
            goto Lbd
        L9b:
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r0)
            r0 = 0
            goto Lbd
        La2:
            id.c.I(r12)
            java.lang.Object r0 = r11.i
            m8.k0 r0 = (m8.k0) r0
            q8.t r0 = r0.u()
            long r2 = r11.f8368f
            r7 = r2
            long r3 = r11.f8370h
            r11.f8369g = r1
            r5 = r11
            r1 = r7
            java.lang.Object r0 = r0.c(r1, r3, r5)
            if (r0 != r6) goto Lbd
            r0 = r6
        Lbd:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m8.h.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(z0 z0Var, nb.c cVar) {
        super(2, cVar);
        this.i = z0Var;
    }
}
