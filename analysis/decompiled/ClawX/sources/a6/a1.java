package a6;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class a1 extends b0 {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f131f = 0;

    /* renamed from: c, reason: collision with root package name */
    public long f132c;
    public boolean d;

    /* renamed from: e, reason: collision with root package name */
    public c5.j f133e;

    public final void H(boolean z) {
        long j4 = this.f132c - (z ? 4294967296L : 1L);
        this.f132c = j4;
        if (j4 <= 0 && this.d) {
            shutdown();
        }
    }

    public final void I(q0 q0Var) {
        c5.j jVar = this.f133e;
        if (jVar == null) {
            jVar = new c5.j();
            this.f133e = jVar;
        }
        jVar.addLast(q0Var);
    }

    public abstract Thread J();

    public final void K(boolean z) {
        this.f132c = (z ? 4294967296L : 1L) + this.f132c;
        if (z) {
            return;
        }
        this.d = true;
    }

    public abstract long L();

    public final boolean M() {
        c5.j jVar = this.f133e;
        if (jVar == null) {
            return false;
        }
        q0 q0Var = (q0) (jVar.isEmpty() ? null : jVar.removeFirst());
        if (q0Var == null) {
            return false;
        }
        q0Var.run();
        return true;
    }

    public void N(long j4, x0 x0Var) {
        j0.f182k.S(j4, x0Var);
    }

    public abstract void shutdown();
}
