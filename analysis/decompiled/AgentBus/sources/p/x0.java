package p;

/* loaded from: classes.dex */
public final class x0 extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public long f8207f;

    /* renamed from: g, reason: collision with root package name */
    public int f8208g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ long f8209h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ y0 f8210i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x0(y0 y0Var, g7.d dVar) {
        super(2, dVar);
        this.f8210i = y0Var;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        x0 x0Var = new x0(this.f8210i, dVar);
        x0Var.f8209h = ((d2.p) obj).f2801a;
        return x0Var;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        long j2 = ((d2.p) obj).f2801a;
        x0 x0Var = new x0(this.f8210i, (g7.d) obj2);
        x0Var.f8209h = j2;
        return x0Var.invokeSuspend(c7.r.f1986a);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006f  */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            r14 = this;
            h7.a r0 = h7.a.f4212f
            int r1 = r14.f8208g
            r2 = 3
            r3 = 2
            r4 = 1
            p.y0 r5 = r14.f8210i
            if (r1 == 0) goto L2f
            if (r1 == r4) goto L29
            if (r1 == r3) goto L21
            if (r1 != r2) goto L19
            long r0 = r14.f8207f
            long r2 = r14.f8209h
            w7.e0.N(r15)
            goto L71
        L19:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L21:
            long r3 = r14.f8207f
            long r6 = r14.f8209h
            w7.e0.N(r15)
            goto L57
        L29:
            long r6 = r14.f8209h
            w7.e0.N(r15)
            goto L41
        L2f:
            w7.e0.N(r15)
            long r6 = r14.f8209h
            i5.f r15 = r5.f8221f
            r14.f8209h = r6
            r14.f8208g = r4
            java.lang.Object r15 = r15.D(r6, r14)
            if (r15 != r0) goto L41
            goto L6e
        L41:
            d2.p r15 = (d2.p) r15
            long r8 = r15.f2801a
            long r8 = d2.p.d(r6, r8)
            r14.f8209h = r6
            r14.f8207f = r8
            r14.f8208g = r3
            java.lang.Object r15 = r5.b(r8, r14)
            if (r15 != r0) goto L56
            goto L6e
        L56:
            r3 = r8
        L57:
            d2.p r15 = (d2.p) r15
            long r11 = r15.f2801a
            i5.f r8 = r5.f8221f
            long r9 = d2.p.d(r3, r11)
            r14.f8209h = r6
            r14.f8207f = r11
            r14.f8208g = r2
            r13 = r14
            java.lang.Object r15 = r8.C(r9, r11, r13)
            if (r15 != r0) goto L6f
        L6e:
            return r0
        L6f:
            r2 = r6
            r0 = r11
        L71:
            d2.p r15 = (d2.p) r15
            long r14 = r15.f2801a
            long r14 = d2.p.d(r0, r14)
            long r14 = d2.p.d(r2, r14)
            d2.p r0 = new d2.p
            r0.<init>(r14)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p.x0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
