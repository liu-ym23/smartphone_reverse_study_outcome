package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.Volatile;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;

/* JADX INFO: loaded from: classes4.dex */
public final class l extends CoroutineDispatcher implements Delay {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f21606h = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CoroutineDispatcher f21607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f21608d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Delay f21609e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p f21610f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f21611g;

    @Volatile
    private volatile int runningWorkers;

    public final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Runnable f21612a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l f21613b;

        public a(l r10, Runnable r11) {
            this.f21613b = r10;
            this.f21612a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            int r10 = 0;
        L16:
            this.f21612a.run();     // Catch: Throwable -> L5
        L7:
            Runnable r11 = l.f(this.f21613b);
            if (r11 == null) goto L9;
            this.f21612a = r11;
            r10 = r10 + 1;
            if (r10 < 16) goto L16;
            if (l.e(this.f21613b).c(this.f21613b) == false) goto L16;
            l.e(this.f21613b).a(this.f21613b, this);
            return;
        L9:
            return;
        L5:
            th = move-exception;
            kotlinx.coroutines.a0.a(EmptyCoroutineContext.INSTANCE, th);
            goto L7
        }
    }

    static {
        f21606h = AtomicIntegerFieldUpdater.newUpdater(l.class, "runningWorkers");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(CoroutineDispatcher r10, int r11) {
        this.f21607c = r10;
        this.f21608d = r11;
        if ((r10 instanceof Delay) == false) goto L5;
        Delay r12 = (Delay) r10;
    L6:
        if (r12 != null) goto L8;
        r12 = kotlinx.coroutines.g0.a();
    L8:
        this.f21609e = r12;
        this.f21610f = new p(false);
        this.f21611g = new Object();
        return;
    L5:
        r12 = null;
        goto L6
    }

    public static final /* synthetic */ CoroutineDispatcher e(l r10) {
        return r10.f21607c;
    }

    public static final /* synthetic */ Runnable f(l r10) {
        return r10.g();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void a(CoroutineContext r10, Runnable r11) {
        this.f21610f.a(r11);
        if (f21606h.get(this) < this.f21608d) goto L5;
        return;
    L5:
        if (h() == false) goto L12;
        Runnable r12 = g();
        if (r12 == null) goto L13;
        a r13 = new a(this, r12);
        this.f21607c.a(this, r13);
        return;
    L13:
        return;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void b(CoroutineContext r10, Runnable r11) {
        this.f21610f.a(r11);
        if (f21606h.get(this) < this.f21608d) goto L5;
        return;
    L5:
        if (h() == false) goto L12;
        Runnable r12 = g();
        if (r12 == null) goto L13;
        a r13 = new a(this, r12);
        this.f21607c.b(this, r13);
        return;
    L13:
        return;
    }

    @Override // kotlinx.coroutines.Delay
    public Object delay(long r10, Continuation r11) {
        return this.f21609e.delay(r10, r11);
    }

    public final Runnable g() {
    L2:
        Runnable r10 = (Runnable) this.f21610f.d();
        if (r10 != null) goto L17;
        Object r11 = this.f21611g;
        monitor-enter(r11);
        AtomicIntegerFieldUpdater r12 = f21606h;     // Catch: Throwable -> L14
        r12.decrementAndGet(this);     // Catch: Throwable -> L14
        if (this.f21610f.c() == 0) goto L8;
        r12.incrementAndGet(this);     // Catch: Throwable -> L14
        monitor-exit(r11);
        goto L2
    L8:
        monitor-exit(r11);
        return null;
    L14:
        th = move-exception;
        throw th;
    L17:
        return r10;
    }

    public final boolean h() {
        Object r10 = this.f21611g;
        monitor-enter(r10);
        AtomicIntegerFieldUpdater r11 = f21606h;     // Catch: Throwable -> L13
        if (r11.get(this) < this.f21608d) goto L9;
        monitor-exit(r10);
        return false;
    L9:
        r11.incrementAndGet(this);     // Catch: Throwable -> L13
        monitor-exit(r10);
        return true;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // kotlinx.coroutines.Delay
    public DisposableHandle invokeOnTimeout(long r10, Runnable r11, CoroutineContext r12) {
        return this.f21609e.invokeOnTimeout(r10, r11, r12);
    }

    @Override // kotlinx.coroutines.Delay
    public void scheduleResumeAfterDelay(long r10, CancellableContinuation r11) {
        this.f21609e.scheduleResumeAfterDelay(r10, r11);
    }
}
