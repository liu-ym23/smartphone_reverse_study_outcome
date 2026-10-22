package v9;

/* loaded from: classes.dex */
public abstract class b extends f {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(u9.n nVar) {
        super(nVar);
        if (nVar != null) {
        } else {
            k(0);
            throw null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void k(int r9) {
        /*
            r0 = 4
            r1 = 3
            r2 = 1
            if (r9 == r2) goto Lc
            if (r9 == r1) goto Lc
            if (r9 == r0) goto Lc
            java.lang.String r3 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            goto Le
        Lc:
            java.lang.String r3 = "@NotNull method %s.%s must not return null"
        Le:
            r4 = 2
            if (r9 == r2) goto L17
            if (r9 == r1) goto L17
            if (r9 == r0) goto L17
            r5 = r1
            goto L18
        L17:
            r5 = r4
        L18:
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r6 = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor"
            r7 = 0
            if (r9 == r2) goto L2f
            if (r9 == r4) goto L2a
            if (r9 == r1) goto L2f
            if (r9 == r0) goto L2f
            java.lang.String r8 = "storageManager"
            r5[r7] = r8
            goto L31
        L2a:
            java.lang.String r8 = "classifier"
            r5[r7] = r8
            goto L31
        L2f:
            r5[r7] = r6
        L31:
            if (r9 == r2) goto L3f
            if (r9 == r1) goto L3a
            if (r9 == r0) goto L3a
            r5[r2] = r6
            goto L43
        L3a:
            java.lang.String r6 = "getAdditionalNeighboursInSupertypeGraph"
            r5[r2] = r6
            goto L43
        L3f:
            java.lang.String r6 = "getBuiltIns"
            r5[r2] = r6
        L43:
            if (r9 == r2) goto L54
            if (r9 == r4) goto L50
            if (r9 == r1) goto L54
            if (r9 == r0) goto L54
            java.lang.String r6 = "<init>"
            r5[r4] = r6
            goto L54
        L50:
            java.lang.String r6 = "isSameClassifier"
            r5[r4] = r6
        L54:
            java.lang.String r3 = java.lang.String.format(r3, r5)
            if (r9 == r2) goto L64
            if (r9 == r1) goto L64
            if (r9 == r0) goto L64
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r9.<init>(r3)
            goto L69
        L64:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            r9.<init>(r3)
        L69:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: v9.b.k(int):void");
    }

    @Override // v9.f
    public final v f() {
        f8.e eVarC = c();
        if (eVarC == null) {
            c8.h.a(107);
            throw null;
        }
        e9.f fVar = c8.h.f1999e;
        if (c8.h.b(eVarC, c8.m.f2027a) || c8.h.b(eVarC, c8.m.f2029b)) {
            return null;
        }
        return n().e();
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0051, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0072 A[RETURN] */
    @Override // v9.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean i(f8.g r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof f8.e
            r1 = 0
            if (r0 == 0) goto L73
            f8.e r4 = r4.c()
            java.lang.String r0 = "first"
            q7.k.e(r4, r0)
            e9.f r0 = r4.getName()
            e9.f r2 = r5.getName()
            boolean r0 = q7.k.a(r0, r2)
            r2 = 1
            if (r0 != 0) goto L1f
        L1d:
            r4 = r1
            goto L70
        L1f:
            f8.j r4 = r4.p()
            f8.j r5 = r5.p()
        L27:
            if (r4 == 0) goto L51
            if (r5 == 0) goto L51
            boolean r0 = r4 instanceof f8.z
            if (r0 == 0) goto L32
            boolean r4 = r5 instanceof f8.z
            goto L70
        L32:
            boolean r0 = r5 instanceof f8.z
            if (r0 == 0) goto L37
            goto L1d
        L37:
            boolean r0 = r4 instanceof f8.e0
            if (r0 == 0) goto L53
            boolean r0 = r5 instanceof f8.e0
            if (r0 == 0) goto L1d
            f8.e0 r4 = (f8.e0) r4
            i8.c0 r4 = (i8.c0) r4
            e9.c r4 = r4.f4758j
            f8.e0 r5 = (f8.e0) r5
            i8.c0 r5 = (i8.c0) r5
            e9.c r5 = r5.f4758j
            boolean r4 = q7.k.a(r4, r5)
            if (r4 == 0) goto L1d
        L51:
            r4 = r2
            goto L70
        L53:
            boolean r0 = r5 instanceof f8.e0
            if (r0 == 0) goto L58
            goto L1d
        L58:
            e9.f r0 = r4.getName()
            e9.f r3 = r5.getName()
            boolean r0 = q7.k.a(r0, r3)
            if (r0 != 0) goto L67
            goto L1d
        L67:
            f8.j r4 = r4.p()
            f8.j r5 = r5.p()
            goto L27
        L70:
            if (r4 == 0) goto L73
            return r2
        L73:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: v9.b.i(f8.g):boolean");
    }

    @Override // v9.m0
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public abstract f8.e c();

    @Override // v9.m0
    public final c8.h n() {
        c8.h hVarE = l9.d.e(c());
        if (hVarE != null) {
            return hVarE;
        }
        k(1);
        throw null;
    }
}
