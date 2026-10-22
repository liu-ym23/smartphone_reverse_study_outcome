package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.jvm.Volatile;

/* JADX INFO: loaded from: classes4.dex */
public final class q extends w {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f21657c = null;

    @Volatile
    private volatile int _resumed;

    static {
        f21657c = AtomicIntegerFieldUpdater.newUpdater(q.class, "_resumed");
    }

    public q(Continuation r10, Throwable r11, boolean r12) {
        if (r11 != null) goto L4;
        r11 = new CancellationException("Continuation " + r10 + " was cancelled normally");
    L4:
        super(r11, r12);
        this._resumed = 0;
    }

    public final boolean c() {
        return f21657c.compareAndSet(this, 0, 1);
    }
}
