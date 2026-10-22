package kotlinx.coroutines;

/* JADX INFO: loaded from: classes4.dex */
public abstract class q0 extends CoroutineDispatcher {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f21658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f21659d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public kotlin.collections.i f21660e;

    public q0() {
    }

    public static /* synthetic */ void f(q0 r10, boolean r11, int r12, Object r13) {
        if (r13 != null) goto L9;
        if ((r12 & 1) == 0) goto L6;
        r11 = false;
    L6:
        r10.e(r11);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
    }

    public static /* synthetic */ void k(q0 r10, boolean r11, int r12, Object r13) {
        if (r13 != null) goto L9;
        if ((r12 & 1) == 0) goto L6;
        r11 = false;
    L6:
        r10.j(r11);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
    }

    public final void e(boolean r10) {
        long r11 = this.f21658c - g(r10);
        this.f21658c = r11;
        if (r11 <= 0) goto L6;
        return;
    L6:
        if (this.f21659d == false) goto L9;
        shutdown();
        return;
    }

    public final long g(boolean r10) {
        if (r10 == false) goto L4;
        return 4294967296L;
    L4:
        return 1;
    }

    public final void h(j0 r10) {
        kotlin.collections.i r11 = this.f21660e;
        if (r11 != null) goto L5;
        r11 = new kotlin.collections.i();
        this.f21660e = r11;
    L5:
        r11.addLast(r10);
    }

    public long i() {
        kotlin.collections.i r10 = this.f21660e;
        if (r10 != null) goto L6;
        return Long.MAX_VALUE;
    L6:
        if (r10.isEmpty() == true) goto L10;
        return 0;
    L10:
        return Long.MAX_VALUE;
    }

    public final void j(boolean r10) {
        this.f21658c += g(r10);
        if (r10 == true) goto L6;
        this.f21659d = true;
        return;
    }

    public final boolean l() {
        if (this.f21658c >= g(true)) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean m() {
        kotlin.collections.i r10 = this.f21660e;
        if (r10 != null) goto L7;
        return true;
    L7:
        return r10.isEmpty();
    }

    public abstract long n();

    public final boolean o() {
        kotlin.collections.i r10 = this.f21660e;
        if (r10 != null) goto L5;
        return false;
    L5:
        j0 r11 = (j0) r10.j();
        if (r11 != null) goto L8;
        return false;
    L8:
        r11.run();
        return true;
    }

    public boolean p() {
        return false;
    }

    public abstract void shutdown();
}
