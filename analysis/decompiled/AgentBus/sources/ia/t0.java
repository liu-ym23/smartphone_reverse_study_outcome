package ia;

/* loaded from: classes.dex */
public final class t0 extends u0 {

    /* renamed from: h, reason: collision with root package name */
    public final Runnable f5002h;

    public t0(long j2, Runnable runnable) {
        super(j2);
        this.f5002h = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5002h.run();
    }

    @Override // ia.u0
    public final String toString() {
        return super.toString() + this.f5002h;
    }
}
