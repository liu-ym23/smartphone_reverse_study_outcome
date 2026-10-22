package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.Volatile;
import kotlinx.coroutines.NotCompleted;

/* JADX INFO: loaded from: classes4.dex */
public abstract class y extends e implements NotCompleted {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f21629d = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f21630c;

    @Volatile
    private volatile int cleanedAndPointers;

    static {
        f21629d = AtomicIntegerFieldUpdater.newUpdater(y.class, "cleanedAndPointers");
    }

    public y(long r10, y r11, int r12) {
        super(r11);
        this.f21630c = r10;
        this.cleanedAndPointers = r12 << 16;
    }

    @Override // kotlinx.coroutines.internal.e
    public boolean h() {
        if (f21629d.get(this) == n()) goto L5;
    L7:
        return false;
    L5:
        if (i() == true) goto L7;
        return true;
    }

    public final boolean m() {
        if (f21629d.addAndGet(this, -65536) == n()) goto L5;
    L7:
        return false;
    L5:
        if (i() == true) goto L7;
        return true;
    }

    public abstract int n();

    public abstract void o(int r10, Throwable r11, CoroutineContext r12);

    public final void p() {
        if (f21629d.incrementAndGet(this) != n()) goto L6;
        k();
        return;
    }

    public final boolean q() {
        AtomicIntegerFieldUpdater r10 = f21629d;
    L3:
        int r11 = r10.get(this);
        if (r11 != n()) goto L10;
        if (i() == true) goto L10;
        return false;
    L10:
        if (r10.compareAndSet(this, r11, 65536 + r11) == false) goto L3;
        return true;
    }
}
