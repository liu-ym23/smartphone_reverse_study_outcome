package ia;

/* loaded from: classes.dex */
public abstract class x0 extends x {

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f5022k = 0;

    /* renamed from: h, reason: collision with root package name */
    public long f5023h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f5024i;

    /* renamed from: j, reason: collision with root package name */
    public d7.m f5025j;

    public final void U(boolean z4) {
        long j2 = this.f5023h - (z4 ? 4294967296L : 1L);
        this.f5023h = j2;
        if (j2 <= 0 && this.f5024i) {
            shutdown();
        }
    }

    public final void V(m0 m0Var) {
        d7.m mVar = this.f5025j;
        if (mVar == null) {
            mVar = new d7.m();
            this.f5025j = mVar;
        }
        mVar.addLast(m0Var);
    }

    public abstract Thread W();

    public final void X(boolean z4) {
        this.f5023h = (z4 ? 4294967296L : 1L) + this.f5023h;
        if (z4) {
            return;
        }
        this.f5024i = true;
    }

    public abstract long Y();

    public final boolean Z() {
        d7.m mVar = this.f5025j;
        if (mVar == null) {
            return false;
        }
        m0 m0Var = (m0) (mVar.isEmpty() ? null : mVar.removeFirst());
        if (m0Var == null) {
            return false;
        }
        m0Var.run();
        return true;
    }

    public void a0(long j2, u0 u0Var) {
        e0.f4949o.f0(j2, u0Var);
    }

    public abstract void shutdown();
}
