package X8;

/* loaded from: classes4.dex */
public final class Q extends AbstractC0282m {
    public final String b;

    public Q(String str) {
        this.b = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void E0(int r9) {
        /*
            r0 = 4
            r1 = 1
            if (r9 == r1) goto L9
            if (r9 == r0) goto L9
            java.lang.String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            goto Lb
        L9:
            java.lang.String r2 = "@NotNull method %s.%s must not return null"
        Lb:
            r3 = 3
            r4 = 2
            if (r9 == r1) goto L13
            if (r9 == r0) goto L13
            r5 = r3
            goto L14
        L13:
            r5 = r4
        L14:
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r6 = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType"
            r7 = 0
            if (r9 == r1) goto L30
            if (r9 == r4) goto L2b
            if (r9 == r3) goto L26
            if (r9 == r0) goto L30
            java.lang.String r8 = "newAttributes"
            r5[r7] = r8
            goto L32
        L26:
            java.lang.String r8 = "kotlinTypeRefiner"
            r5[r7] = r8
            goto L32
        L2b:
            java.lang.String r8 = "delegate"
            r5[r7] = r8
            goto L32
        L30:
            r5[r7] = r6
        L32:
            java.lang.String r7 = "refine"
            if (r9 == r1) goto L3e
            if (r9 == r0) goto L3b
            r5[r1] = r6
            goto L42
        L3b:
            r5[r1] = r7
            goto L42
        L3e:
            java.lang.String r6 = "toString"
            r5[r1] = r6
        L42:
            if (r9 == r1) goto L56
            if (r9 == r4) goto L52
            if (r9 == r3) goto L4f
            if (r9 == r0) goto L56
            java.lang.String r3 = "replaceAttributes"
            r5[r4] = r3
            goto L56
        L4f:
            r5[r4] = r7
            goto L56
        L52:
            java.lang.String r3 = "replaceDelegate"
            r5[r4] = r3
        L56:
            java.lang.String r2 = java.lang.String.format(r2, r5)
            if (r9 == r1) goto L64
            if (r9 == r0) goto L64
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r9.<init>(r2)
            goto L69
        L64:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            r9.<init>(r2)
        L69:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: X8.Q.E0(int):void");
    }

    @Override // X8.AbstractC0282m
    /* renamed from: C0 */
    public final A j0(Y8.f fVar) {
        if (fVar != null) {
            return this;
        }
        E0(3);
        throw null;
    }

    @Override // X8.AbstractC0282m
    public final AbstractC0282m D0(A a3) {
        throw new IllegalStateException(this.b);
    }

    @Override // X8.AbstractC0282m, X8.w
    /* renamed from: Y */
    public final w j0(Y8.f fVar) {
        if (fVar != null) {
            return this;
        }
        E0(3);
        throw null;
    }

    @Override // X8.A, X8.U
    public final /* bridge */ /* synthetic */ U f0(boolean z10) {
        f0(z10);
        throw null;
    }

    @Override // X8.AbstractC0282m, X8.U
    public final U j0(Y8.f fVar) {
        if (fVar != null) {
            return this;
        }
        E0(3);
        throw null;
    }

    @Override // X8.A, X8.U
    public final /* bridge */ /* synthetic */ U m0(H h) {
        m0(h);
        throw null;
    }

    @Override // X8.A
    /* renamed from: n0 */
    public final A f0(boolean z10) {
        throw new IllegalStateException(this.b);
    }

    @Override // X8.A
    /* renamed from: s0 */
    public final A m0(H h) {
        if (h != null) {
            throw new IllegalStateException(this.b);
        }
        E0(0);
        throw null;
    }

    @Override // X8.A
    public final String toString() {
        String str = this.b;
        if (str != null) {
            return str;
        }
        E0(1);
        throw null;
    }

    @Override // X8.AbstractC0282m
    public final A y0() {
        throw new IllegalStateException(this.b);
    }
}
