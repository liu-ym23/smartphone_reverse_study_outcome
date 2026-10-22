package net.zetetic.database.sqlcipher;

/* loaded from: classes4.dex */
public final class CloseGuard {
    public static final CloseGuard b = new CloseGuard();
    public static volatile Reporter c;

    /* renamed from: a, reason: collision with root package name */
    public Throwable f5378a;

    public static final class DefaultReporter implements Reporter {
    }

    public interface Reporter {
    }

    public final void a() {
        if (this != b) {
            this.f5378a = new Throwable("Explicit termination method 'close' not called");
        }
    }
}
