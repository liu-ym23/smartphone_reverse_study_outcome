package m8;

import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class u extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8501c;

    /* renamed from: f, reason: collision with root package name */
    public int f8502f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ k0 f8503g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ List f8504h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u(k0 k0Var, List list, nb.c cVar, int i) {
        super(2, cVar);
        this.f8501c = i;
        this.f8503g = k0Var;
        this.f8504h = list;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f8501c) {
            case 0:
                return new u(this.f8503g, this.f8504h, cVar, 0);
            default:
                return new u(this.f8503g, this.f8504h, cVar, 1);
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        kc.t tVar = (kc.t) obj;
        nb.c cVar = (nb.c) obj2;
        switch (this.f8501c) {
        }
        return ((u) create(tVar, cVar)).invokeSuspend(jb.v.f6774a);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00a2  */
    @Override // pb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            int r0 = r10.f8501c
            jb.v r1 = jb.v.f6774a
            r2 = 0
            java.util.List r3 = r10.f8504h
            m8.k0 r4 = r10.f8503g
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r6 = 1
            r7 = 0
            switch(r0) {
                case 0: goto L37;
                default: goto L10;
            }
        L10:
            ob.a r0 = ob.a.f9351c
            int r8 = r10.f8502f
            if (r8 == 0) goto L21
            if (r8 != r6) goto L1c
            id.c.I(r11)
            goto L36
        L1c:
            od.f.e(r5)
            r1 = r7
            goto L36
        L21:
            id.c.I(r11)
            rc.e r11 = kc.e0.f7430a
            rc.d r11 = rc.d.f10552f
            m8.u r5 = new m8.u
            r5.<init>(r4, r3, r7, r2)
            r10.f8502f = r6
            java.lang.Object r10 = kc.w.E(r11, r5, r10)
            if (r10 != r0) goto L36
            r1 = r0
        L36:
            return r1
        L37:
            ob.a r0 = ob.a.f9351c
            int r8 = r10.f8502f
            if (r8 == 0) goto L4a
            if (r8 != r6) goto L44
            id.c.I(r11)
            goto Lc4
        L44:
            od.f.e(r5)
            r1 = r7
            goto Lc4
        L4a:
            id.c.I(r11)
            jb.k r11 = r4.f8423g
            java.lang.Object r11 = r11.getValue()
            s8.v3 r11 = (s8.v3) r11
            r10.f8502f = r6
            r11.getClass()
            java.util.ArrayList r4 = new java.util.ArrayList
            r5 = 10
            int r5 = kb.m.m0(r3, r5)
            r4.<init>(r5)
            java.util.Iterator r3 = r3.iterator()
        L69:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L79
            java.lang.Object r5 = r3.next()
            java.lang.String r5 = (java.lang.String) r5
            k0.a.A(r5, r4)
            goto L69
        L79:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            int r5 = r4.size()
            r6 = r2
        L83:
            if (r6 >= r5) goto L98
            java.lang.Object r8 = r4.get(r6)
            int r6 = r6 + 1
            r9 = r8
            java.lang.String r9 = (java.lang.String) r9
            int r9 = r9.length()
            if (r9 <= 0) goto L83
            r3.add(r8)
            goto L83
        L98:
            java.util.Set r3 = kb.l.O0(r3)
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto La4
        La2:
            r10 = r1
            goto Lc1
        La4:
            android.content.Context r4 = r11.f12031a
            r4.getClass()
            x3.b r5 = s8.w3.f12063b
            fc.c[] r6 = s8.w3.f12062a
            r2 = r6[r2]
            stepos.support.v7.app.f r2 = r5.a(r4, r2)
            g9.f0 r4 = new g9.f0
            r5 = 7
            r4.<init>(r11, r3, r7, r5)
            java.lang.Object r10 = t.m0.h(r2, r4, r10)
            ob.a r11 = ob.a.f9351c
            if (r10 != r11) goto La2
        Lc1:
            if (r10 != r0) goto Lc4
            r1 = r0
        Lc4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: m8.u.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
