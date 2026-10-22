package od;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a0 implements i0 {

    /* renamed from: c, reason: collision with root package name */
    public final k f9413c;

    /* renamed from: f, reason: collision with root package name */
    public final i f9414f;

    /* renamed from: g, reason: collision with root package name */
    public d0 f9415g;

    /* renamed from: h, reason: collision with root package name */
    public int f9416h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public long f9417j;

    public a0(k kVar) {
        this.f9413c = kVar;
        i iVarA = kVar.a();
        this.f9414f = iVarA;
        d0 d0Var = iVarA.f9453c;
        this.f9415g = d0Var;
        this.f9416h = d0Var != null ? d0Var.f9438b : -1;
    }

    @Override // od.i0
    public final k0 b() {
        return this.f9413c.b();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.i = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001e, code lost:
    
        if (r3 == r5.f9438b) goto L16;
     */
    @Override // od.i0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long l(od.i r9, long r10) {
        /*
            r8 = this;
            r9.getClass()
            r0 = 0
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 < 0) goto L67
            boolean r3 = r8.i
            if (r3 != 0) goto L61
            od.d0 r3 = r8.f9415g
            od.i r4 = r8.f9414f
            if (r3 == 0) goto L29
            od.d0 r5 = r4.f9453c
            if (r3 != r5) goto L21
            int r3 = r8.f9416h
            r5.getClass()
            int r5 = r5.f9438b
            if (r3 != r5) goto L21
            goto L29
        L21:
            java.lang.String r8 = "Peek source is invalid because upstream source was used"
            od.f.e(r8)
        L26:
            r8 = 0
            return r8
        L29:
            if (r2 != 0) goto L2c
            return r0
        L2c:
            long r0 = r8.f9417j
            r2 = 1
            long r0 = r0 + r2
            od.k r2 = r8.f9413c
            boolean r0 = r2.request(r0)
            if (r0 != 0) goto L3c
            r8 = -1
            return r8
        L3c:
            od.d0 r0 = r8.f9415g
            if (r0 != 0) goto L4a
            od.d0 r0 = r4.f9453c
            if (r0 == 0) goto L4a
            r8.f9415g = r0
            int r0 = r0.f9438b
            r8.f9416h = r0
        L4a:
            long r0 = r4.f9454f
            long r2 = r8.f9417j
            long r0 = r0 - r2
            long r6 = java.lang.Math.min(r10, r0)
            od.i r2 = r8.f9414f
            long r4 = r8.f9417j
            r3 = r9
            r2.r(r3, r4, r6)
            long r9 = r8.f9417j
            long r9 = r9 + r6
            r8.f9417j = r9
            return r6
        L61:
            java.lang.String r8 = "closed"
            od.f.e(r8)
            goto L26
        L67:
            java.lang.String r8 = "byteCount < 0: "
            java.lang.String r8 = k0.a.m(r8, r10)
            od.f.c(r8)
            goto L26
        */
        throw new UnsupportedOperationException("Method not decompiled: od.a0.l(od.i, long):long");
    }
}
