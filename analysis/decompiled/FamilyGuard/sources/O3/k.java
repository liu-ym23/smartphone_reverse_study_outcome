package O3;

/* loaded from: classes.dex */
public final class k extends a implements Runnable {
    public k(Runnable runnable) {
        super(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4349b = Thread.currentThread();
        try {
            this.f4348a.run();
            this.f4349b = null;
        } catch (Throwable th) {
            this.f4349b = null;
            lazySet(a.f4346c);
            S3.a.r(th);
        }
    }
}
