package l0;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public k f5748a;

    /* renamed from: b, reason: collision with root package name */
    public long f5749b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f5750c;

    /* renamed from: d, reason: collision with root package name */
    public int f5751d;

    public f(long j2, k kVar) {
        int iA;
        int iNumberOfTrailingZeros;
        this.f5748a = kVar;
        this.f5749b = j2;
        c6.d dVar = m.f5772a;
        if (j2 != 0) {
            k kVarD = d();
            long j4 = kVarD.f5767h;
            long[] jArr = kVarD.f5768i;
            if (jArr != null) {
                j2 = jArr[0];
            } else {
                long j10 = kVarD.f5766g;
                if (j10 != 0) {
                    iNumberOfTrailingZeros = Long.numberOfTrailingZeros(j10);
                } else {
                    long j11 = kVarD.f5765f;
                    if (j11 != 0) {
                        j4 += 64;
                        iNumberOfTrailingZeros = Long.numberOfTrailingZeros(j11);
                    }
                }
                j2 = iNumberOfTrailingZeros + j4;
            }
            synchronized (m.f5774c) {
                iA = m.f5777f.a(j2);
            }
        } else {
            iA = -1;
        }
        this.f5751d = iA;
    }

    public static void q(f fVar) {
        m.f5773b.N(fVar);
    }

    public final void a() {
        synchronized (m.f5774c) {
            b();
            p();
        }
    }

    public void b() {
        m.f5775d = m.f5775d.f(g());
    }

    public abstract void c();

    public k d() {
        return this.f5748a;
    }

    public abstract p7.k e();

    public abstract boolean f();

    public long g() {
        return this.f5749b;
    }

    public int h() {
        return 0;
    }

    public abstract p7.k i();

    public final f j() {
        i5.l lVar = m.f5773b;
        f fVar = (f) lVar.z();
        lVar.N(this);
        return fVar;
    }

    public abstract void k();

    public abstract void l();

    public abstract void m();

    public abstract void n(v vVar);

    public final void o() {
        int i2 = this.f5751d;
        if (i2 >= 0) {
            m.u(i2);
            this.f5751d = -1;
        }
    }

    public void p() {
        o();
    }

    public void r(k kVar) {
        this.f5748a = kVar;
    }

    public void s(long j2) {
        this.f5749b = j2;
    }

    public void t(int i2) {
        throw new IllegalStateException("Updating write count is not supported for this snapshot");
    }

    public abstract f u(p7.k kVar);
}
