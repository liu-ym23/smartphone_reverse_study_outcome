package v9;

/* loaded from: classes.dex */
public final class w0 extends m {

    /* renamed from: g, reason: collision with root package name */
    public final String f10600g;

    public w0(String str) {
        this.f10600g = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void Q0(int r9) {
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
        throw new UnsupportedOperationException("Method not decompiled: v9.w0.Q0(int):void");
    }

    @Override // v9.m, v9.v
    /* renamed from: G0 */
    public final v J0(w9.g gVar) {
        if (gVar != null) {
            return this;
        }
        Q0(3);
        throw null;
    }

    @Override // v9.z, v9.z0
    public final /* bridge */ /* synthetic */ z0 I0(boolean z4) {
        I0(z4);
        throw null;
    }

    @Override // v9.m, v9.z0
    public final z0 J0(w9.g gVar) {
        if (gVar != null) {
            return this;
        }
        Q0(3);
        throw null;
    }

    @Override // v9.z, v9.z0
    public final /* bridge */ /* synthetic */ z0 K0(i0 i0Var) {
        K0(i0Var);
        throw null;
    }

    @Override // v9.z
    /* renamed from: L0 */
    public final z I0(boolean z4) {
        throw new IllegalStateException(this.f10600g);
    }

    @Override // v9.z
    /* renamed from: M0 */
    public final z K0(i0 i0Var) {
        if (i0Var != null) {
            throw new IllegalStateException(this.f10600g);
        }
        Q0(0);
        throw null;
    }

    @Override // v9.m
    public final z N0() {
        throw new IllegalStateException(this.f10600g);
    }

    @Override // v9.m
    /* renamed from: O0 */
    public final z G0(w9.g gVar) {
        if (gVar != null) {
            return this;
        }
        Q0(3);
        throw null;
    }

    @Override // v9.m
    public final m P0(z zVar) {
        throw new IllegalStateException(this.f10600g);
    }

    @Override // v9.z
    public final String toString() {
        String str = this.f10600g;
        if (str != null) {
            return str;
        }
        Q0(1);
        throw null;
    }
}
