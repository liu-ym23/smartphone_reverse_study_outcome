package nc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p0 extends pb.i implements xb.q {

    /* renamed from: c, reason: collision with root package name */
    public int f8900c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ h f8901f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ int f8902g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ q0 f8903h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p0(q0 q0Var, nb.c cVar) {
        super(3, cVar);
        this.f8903h = q0Var;
    }

    @Override // xb.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        int iIntValue = ((Number) obj2).intValue();
        p0 p0Var = new p0(this.f8903h, (nb.c) obj3);
        p0Var.f8901f = (h) obj;
        p0Var.f8902g = iIntValue;
        return p0Var.invokeSuspend(jb.v.f6774a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0044, code lost:
    
        if (r1.emit(r8, r7) == r0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007c, code lost:
    
        if (r1.emit(r8, r7) != r0) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0061 A[PHI: r1
      0x0061: PHI (r1v3 nc.h) = (r1v2 nc.h), (r1v6 nc.h) binds: [B:25:0x005e, B:13:0x0023] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0071 A[PHI: r1
      0x0071: PHI (r1v4 nc.h) = (r1v3 nc.h), (r1v7 nc.h) binds: [B:28:0x006e, B:12:0x001d] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // pb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            ob.a r0 = ob.a.f9351c
            int r1 = r7.f8900c
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r1 == 0) goto L33
            if (r1 == r6) goto L2f
            if (r1 == r5) goto L29
            if (r1 == r4) goto L23
            if (r1 == r3) goto L1d
            if (r1 != r2) goto L16
            goto L2f
        L16:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r7)
            r7 = 0
            return r7
        L1d:
            nc.h r1 = r7.f8901f
            id.c.I(r8)
            goto L71
        L23:
            nc.h r1 = r7.f8901f
            id.c.I(r8)
            goto L61
        L29:
            nc.h r1 = r7.f8901f
            id.c.I(r8)
            goto L54
        L2f:
            id.c.I(r8)
            goto L7f
        L33:
            id.c.I(r8)
            nc.h r1 = r7.f8901f
            int r8 = r7.f8902g
            if (r8 <= 0) goto L47
            nc.m0 r8 = nc.m0.f8883c
            r7.f8900c = r6
            java.lang.Object r7 = r1.emit(r8, r7)
            if (r7 != r0) goto L7f
            goto L7e
        L47:
            r7.f8901f = r1
            r7.f8900c = r5
            r5 = 0
            java.lang.Object r8 = kc.w.g(r5, r7)
            if (r8 != r0) goto L54
            goto L7e
        L54:
            nc.m0 r8 = nc.m0.f8884f
            r7.f8901f = r1
            r7.f8900c = r4
            java.lang.Object r8 = r1.emit(r8, r7)
            if (r8 != r0) goto L61
            goto L7e
        L61:
            r7.f8901f = r1
            r7.f8900c = r3
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.lang.Object r8 = kc.w.g(r3, r7)
            if (r8 != r0) goto L71
            goto L7e
        L71:
            nc.m0 r8 = nc.m0.f8885g
            r3 = 0
            r7.f8901f = r3
            r7.f8900c = r2
            java.lang.Object r7 = r1.emit(r8, r7)
            if (r7 != r0) goto L7f
        L7e:
            return r0
        L7f:
            jb.v r7 = jb.v.f6774a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: nc.p0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
