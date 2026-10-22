package v4;

/* loaded from: classes.dex */
public final class j extends i7.i implements p7.p {

    /* renamed from: f, reason: collision with root package name */
    public int f10415f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ String f10416g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ String f10417h;

    /* renamed from: i, reason: collision with root package name */
    public /* synthetic */ long f10418i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ k f10419j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(k kVar, g7.d dVar) {
        super(4, dVar);
        this.f10419j = kVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0073  */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws org.json.JSONException {
        /*
            r9 = this;
            h7.a r0 = h7.a.f4212f
            int r1 = r9.f10415f
            r2 = 1
            if (r1 == 0) goto L15
            if (r1 != r2) goto Ld
            w7.e0.N(r10)
            return r10
        Ld:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L15:
            w7.e0.N(r10)
            r10 = r2
            java.lang.String r2 = r9.f10416g
            java.lang.String r3 = r9.f10417h
            long r4 = r9.f10418i
            v4.k r1 = r9.f10419j
            u5.h r6 = r1.f10455u
            java.lang.Object r6 = r6.f10131c
            la.u0 r6 = (la.u0) r6
            java.lang.Object r6 = r6.getValue()
            d5.t r6 = (d5.t) r6
            r7 = -1
            if (r6 != 0) goto L32
            r6 = r7
            goto L3a
        L32:
            int[] r8 = v4.r.$EnumSwitchMapping$0
            int r6 = r6.ordinal()
            r6 = r8[r6]
        L3a:
            r8 = 0
            if (r6 == r7) goto L5a
            if (r6 == r10) goto L49
            r7 = 2
            if (r6 != r7) goto L43
            goto L5a
        L43:
            a4.u r9 = new a4.u
            r9.<init>()
            throw r9
        L49:
            y4.a r1 = r1.f10430e0
            boolean r6 = r1 instanceof y4.t
            if (r6 == 0) goto L52
            y4.t r1 = (y4.t) r1
            goto L53
        L52:
            r1 = r8
        L53:
            if (r1 == 0) goto L58
            o4.t1 r1 = r1.f11664r
            goto L74
        L58:
            r1 = r8
            goto L74
        L5a:
            y4.m r6 = r1.f10434g0
            if (r6 == 0) goto L61
            o4.t1 r6 = r6.f11619r
            goto L62
        L61:
            r6 = r8
        L62:
            if (r6 != 0) goto L73
            y4.a r1 = r1.f10430e0
            boolean r6 = r1 instanceof y4.t
            if (r6 == 0) goto L6d
            y4.t r1 = (y4.t) r1
            goto L6e
        L6d:
            r1 = r8
        L6e:
            if (r1 == 0) goto L58
            o4.t1 r1 = r1.f11664r
            goto L74
        L73:
            r1 = r6
        L74:
            if (r1 == 0) goto L83
            r9.f10416g = r8
            r9.f10415f = r10
            r6 = r9
            java.lang.Object r9 = r1.i(r2, r3, r4, r6)
            if (r9 != r0) goto L82
            return r0
        L82:
            return r9
        L83:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "UNAVAILABLE: no gateway client"
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: v4.j.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // p7.p
    public final Object u(Object obj, Object obj2, Object obj3, Object obj4) {
        long jLongValue = ((Number) obj3).longValue();
        j jVar = new j(this.f10419j, (g7.d) obj4);
        jVar.f10416g = (String) obj;
        jVar.f10417h = (String) obj2;
        jVar.f10418i = jLongValue;
        return jVar.invokeSuspend(c7.r.f1986a);
    }
}
