package u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n1 extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f13531c = 1;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ float f13532f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f13533g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f13534h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n1(float f5, yb.r rVar, j0 j0Var) {
        super(1);
        this.f13532f = f5;
        this.f13533g = rVar;
        this.f13534h = j0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0023 A[PHI: r2
      0x0023: PHI (r2v22 float) = (r2v19 float), (r2v26 float) binds: [B:14:0x0038, B:7:0x0020] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // xb.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invoke(java.lang.Object r10) {
        /*
            r9 = this;
            int r0 = r9.f13531c
            switch(r0) {
                case 0: goto L67;
                default: goto L5;
            }
        L5:
            s.g r10 = (s.g) r10
            java.lang.Object r0 = r9.f13533g
            yb.r r0 = (yb.r) r0
            float r1 = r9.f13532f
            r2 = 0
            int r3 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r3 <= 0) goto L26
            k0.k1 r2 = r10.f11009e
            java.lang.Object r2 = r2.getValue()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            int r3 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r3 <= 0) goto L23
            goto L24
        L23:
            r1 = r2
        L24:
            r2 = r1
            goto L3b
        L26:
            int r3 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r3 >= 0) goto L3b
            k0.k1 r2 = r10.f11009e
            java.lang.Object r2 = r2.getValue()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            int r3 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r3 >= 0) goto L23
            goto L24
        L3b:
            float r1 = r0.f16095c
            float r1 = r2 - r1
            java.lang.Object r9 = r9.f13534h
            u.j0 r9 = (u.j0) r9
            float r9 = r9.a(r1)
            int r9 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r9 != 0) goto L5c
            k0.k1 r9 = r10.f11009e
            java.lang.Object r9 = r9.getValue()
            java.lang.Number r9 = (java.lang.Number) r9
            float r9 = r9.floatValue()
            int r9 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r9 != 0) goto L5c
            goto L5f
        L5c:
            r10.a()
        L5f:
            float r9 = r0.f16095c
            float r9 = r9 + r1
            r0.f16095c = r9
            jb.v r9 = jb.v.f6774a
            return r9
        L67:
            java.lang.Number r10 = (java.lang.Number) r10
            long r0 = r10.longValue()
            java.lang.Object r10 = r9.f13533g
            u.o1 r10 = (u.o1) r10
            long r2 = r10.f13542b
            r4 = -9223372036854775808
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 != 0) goto L7b
            r10.f13542b = r0
        L7b:
            s.j r6 = new s.j
            float r2 = r10.f13545e
            r6.<init>(r2)
            r3 = 0
            float r4 = r9.f13532f
            int r3 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            s.j r7 = u.o1.f13540f
            if (r3 != 0) goto L9a
            s.j1 r3 = r10.f13541a
            s.j r4 = new s.j
            r4.<init>(r2)
            s.j r2 = r10.f13543c
            long r2 = r3.b(r4, r7, r2)
        L98:
            r4 = r2
            goto La6
        L9a:
            long r2 = r10.f13542b
            long r2 = r0 - r2
            float r2 = (float) r2
            float r2 = r2 / r4
            double r2 = (double) r2
            long r2 = ac.a.R(r2)
            goto L98
        La6:
            s.j1 r3 = r10.f13541a
            s.j r8 = r10.f13543c
            s.n r2 = r3.k(r4, r6, r7, r8)
            s.j r2 = (s.j) r2
            float r2 = r2.f11034a
            s.j1 r3 = r10.f13541a
            s.j r8 = r10.f13543c
            s.n r3 = r3.h(r4, r6, r7, r8)
            s.j r3 = (s.j) r3
            r10.f13543c = r3
            r10.f13542b = r0
            float r0 = r10.f13545e
            float r0 = r0 - r2
            r10.f13545e = r2
            java.lang.Object r9 = r9.f13534h
            xb.l r9 = (xb.l) r9
            java.lang.Float r10 = java.lang.Float.valueOf(r0)
            r9.invoke(r10)
            jb.v r9 = jb.v.f6774a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: u.n1.invoke(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n1(o1 o1Var, float f5, xb.l lVar) {
        super(1);
        this.f13533g = o1Var;
        this.f13532f = f5;
        this.f13534h = lVar;
    }
}
