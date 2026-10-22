package Z2;

/* loaded from: classes2.dex */
public final class X extends Y {

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f2199c;

    public X(Runnable runnable, long j4) {
        super(j4);
        this.f2199c = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2199c.run();
    }

    @Override // Z2.Y
    public final String toString() {
        return super.toString() + this.f2199c;
    }
}
