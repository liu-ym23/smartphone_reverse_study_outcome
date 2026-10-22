package u0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public k f13652a;

    /* renamed from: b, reason: collision with root package name */
    public long f13653b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f13654c;

    /* renamed from: d, reason: collision with root package name */
    public int f13655d;

    public f(long j10, k kVar) {
        int iA;
        int iNumberOfTrailingZeros;
        this.f13652a = kVar;
        this.f13653b = j10;
        t0.d dVar = m.f13674a;
        if (j10 != 0) {
            k kVarD = d();
            long j11 = kVarD.f13669g;
            long[] jArr = kVarD.f13670h;
            if (jArr != null) {
                j10 = jArr[0];
            } else {
                long j12 = kVarD.f13668f;
                if (j12 != 0) {
                    iNumberOfTrailingZeros = Long.numberOfTrailingZeros(j12);
                } else {
                    long j13 = kVarD.f13667c;
                    if (j13 != 0) {
                        j11 += 64;
                        iNumberOfTrailingZeros = Long.numberOfTrailingZeros(j13);
                    }
                }
                j10 = iNumberOfTrailingZeros + j11;
            }
            synchronized (m.f13676c) {
                iA = m.f13679f.a(j10);
            }
        } else {
            iA = -1;
        }
        this.f13655d = iA;
    }

    public static void q(f fVar) {
        m.f13675b.N(fVar);
    }

    public final void a() {
        synchronized (m.f13676c) {
            b();
            p();
        }
    }

    public void b() {
        m.f13677d = m.f13677d.b(g());
    }

    public abstract void c();

    public k d() {
        return this.f13652a;
    }

    public abstract xb.l e();

    public abstract boolean f();

    public long g() {
        return this.f13653b;
    }

    public int h() {
        return 0;
    }

    public abstract xb.l i();

    public final f j() {
        p5.m mVar = m.f13675b;
        f fVar = (f) mVar.w();
        mVar.N(this);
        return fVar;
    }

    public abstract void k();

    public abstract void l();

    public abstract void m();

    public abstract void n(v vVar);

    public final void o() {
        int i = this.f13655d;
        if (i >= 0) {
            m.u(i);
            this.f13655d = -1;
        }
    }

    public void p() {
        o();
    }

    public void r(k kVar) {
        this.f13652a = kVar;
    }

    public void s(long j10) {
        this.f13653b = j10;
    }

    public void t(int i) {
        throw new IllegalStateException("Updating write count is not supported for this snapshot");
    }

    public abstract f u(xb.l lVar);
}
