package kc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class j0 extends p {
    public static final /* synthetic */ int i = 0;

    /* renamed from: f, reason: collision with root package name */
    public long f7444f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f7445g;

    /* renamed from: h, reason: collision with root package name */
    public kb.j f7446h;

    public final void Q(boolean z10) {
        long j10 = this.f7444f - (z10 ? 4294967296L : 1L);
        this.f7444f = j10;
        if (j10 <= 0 && this.f7445g) {
            shutdown();
        }
    }

    public final void R(c0 c0Var) {
        kb.j jVar = this.f7446h;
        if (jVar == null) {
            jVar = new kb.j();
            this.f7446h = jVar;
        }
        jVar.addLast(c0Var);
    }

    public final void S(boolean z10) {
        this.f7444f = (z10 ? 4294967296L : 1L) + this.f7444f;
        if (z10) {
            return;
        }
        this.f7445g = true;
    }

    public abstract long T();

    public final boolean U() {
        kb.j jVar = this.f7446h;
        if (jVar == null) {
            return false;
        }
        c0 c0Var = (c0) (jVar.isEmpty() ? null : jVar.removeFirst());
        if (c0Var == null) {
            return false;
        }
        c0Var.run();
        return true;
    }

    public abstract void shutdown();
}
