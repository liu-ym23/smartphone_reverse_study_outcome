package ob;

/* loaded from: classes.dex */
public final class a0 implements k0 {

    /* renamed from: f, reason: collision with root package name */
    public final j f7946f;

    /* renamed from: g, reason: collision with root package name */
    public final h f7947g;

    /* renamed from: h, reason: collision with root package name */
    public f0 f7948h;

    /* renamed from: i, reason: collision with root package name */
    public int f7949i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f7950j;

    /* renamed from: k, reason: collision with root package name */
    public long f7951k;

    public a0(j jVar) {
        this.f7946f = jVar;
        h hVarC = jVar.c();
        this.f7947g = hVarC;
        f0 f0Var = hVarC.f7992f;
        this.f7948h = f0Var;
        this.f7949i = f0Var != null ? f0Var.f7976b : -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f7950j = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
    
        if (r3 == r5.f7976b) goto L15;
     */
    @Override // ob.k0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long read(ob.h r9, long r10) {
        /*
            r8 = this;
            java.lang.String r0 = "sink"
            q7.k.e(r9, r0)
            r0 = 0
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 < 0) goto L6b
            boolean r3 = r8.f7950j
            if (r3 != 0) goto L63
            ob.f0 r3 = r8.f7948h
            ob.h r4 = r8.f7947g
            if (r3 == 0) goto L2b
            ob.f0 r5 = r4.f7992f
            if (r3 != r5) goto L23
            int r3 = r8.f7949i
            q7.k.b(r5)
            int r5 = r5.f7976b
            if (r3 != r5) goto L23
            goto L2b
        L23:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "Peek source is invalid because upstream source was used"
            r8.<init>(r9)
            throw r8
        L2b:
            if (r2 != 0) goto L2e
            return r0
        L2e:
            long r0 = r8.f7951k
            r2 = 1
            long r0 = r0 + r2
            ob.j r2 = r8.f7946f
            boolean r0 = r2.p(r0)
            if (r0 != 0) goto L3e
            r8 = -1
            return r8
        L3e:
            ob.f0 r0 = r8.f7948h
            if (r0 != 0) goto L4c
            ob.f0 r0 = r4.f7992f
            if (r0 == 0) goto L4c
            r8.f7948h = r0
            int r0 = r0.f7976b
            r8.f7949i = r0
        L4c:
            long r0 = r4.f7993g
            long r2 = r8.f7951k
            long r0 = r0 - r2
            long r6 = java.lang.Math.min(r10, r0)
            ob.h r2 = r8.f7947g
            long r4 = r8.f7951k
            r3 = r9
            r2.d(r3, r4, r6)
            long r9 = r8.f7951k
            long r9 = r9 + r6
            r8.f7951k = r9
            return r6
        L63:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "closed"
            r8.<init>(r9)
            throw r8
        L6b:
            java.lang.String r8 = "byteCount < 0: "
            java.lang.String r8 = a1.a.h(r8, r10)
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r8 = r8.toString()
            r9.<init>(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ob.a0.read(ob.h, long):long");
    }

    @Override // ob.k0
    public final m0 timeout() {
        return this.f7946f.timeout();
    }
}
