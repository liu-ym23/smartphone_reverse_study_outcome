package t;

import Ua.C1071n0;
import Ua.L0;
import android.os.Handler;
import android.os.Looper;
import com.autonavi.aps.amapapi.config.Const;
import java.util.concurrent.Executor;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001f\u001a\u00020\u001b8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u0015R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\n0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0017\u0010&\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b \u0010\u0017R\u0014\u0010(\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010\u0018R\"\u0010,\u001a\u00020\u00028\u0006@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0011\u001a\u0004\b#\u0010\u0013\"\u0004\b*\u0010+¨\u0006-"}, d2 = {"Lt/y0;", "", "LUa/M;", "scope", "Ljava/util/concurrent/Executor;", "backgroundExecutor", "LUa/I;", "backgroundDispatcher", "<init>", "(LUa/M;Ljava/util/concurrent/Executor;LUa/I;)V", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Z", "LY8/t;", "c", "()V", Const.INTENT_KEY_APIKEY, "LUa/M;", Const.INTENT_KEY_UMID, "()LUa/M;", Const.INTENT_KEY_PKGNAME, "Ljava/util/concurrent/Executor;", "getBackgroundExecutor", "()Ljava/util/concurrent/Executor;", "LUa/I;", "getBackgroundDispatcher", "()LUa/I;", "Landroid/os/Handler;", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "mainHandler", "e", "sequentialExecutorDelegate", "Ljava/lang/ThreadLocal;", "f", "Ljava/lang/ThreadLocal;", "isSequentialThread", "sequentialExecutor", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "sequentialDispatcher", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "setSequentialScope", "(LUa/M;)V", "sequentialScope", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class y0 {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Ua.M scope;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Executor backgroundExecutor;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Ua.I backgroundDispatcher;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Handler mainHandler;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Executor sequentialExecutorDelegate;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final ThreadLocal<Boolean> isSequentialThread;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final Executor sequentialExecutor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final Ua.I sequentialDispatcher;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public Ua.M sequentialScope;

    public y0(Ua.M scope, Executor backgroundExecutor, Ua.I backgroundDispatcher) {
        kotlin.jvm.internal.p.i(scope, "scope");
        kotlin.jvm.internal.p.i(backgroundExecutor, "backgroundExecutor");
        kotlin.jvm.internal.p.i(backgroundDispatcher, "backgroundDispatcher");
        this.scope = scope;
        this.backgroundExecutor = backgroundExecutor;
        this.backgroundDispatcher = backgroundDispatcher;
        this.mainHandler = new Handler(Looper.getMainLooper());
        Executor executorF = N.a.f(backgroundExecutor);
        kotlin.jvm.internal.p.h(executorF, "newSequentialExecutor(...)");
        this.sequentialExecutorDelegate = executorF;
        this.isSequentialThread = new ThreadLocal<>();
        Executor executor = new Executor() { // from class: t.w0
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                y0.h(this.f41958a, runnable);
            }
        };
        this.sequentialExecutor = executor;
        Ua.I iB = C1071n0.b(executor);
        this.sequentialDispatcher = iB;
        this.sequentialScope = kotlinx.coroutines.d.a(scope.getCoroutineContext().plus(L0.b(null, 1, null)).plus(iB));
    }

    public static final void h(final y0 y0Var, final Runnable runnable) {
        y0Var.sequentialExecutorDelegate.execute(new Runnable() { // from class: t.x0
            @Override // java.lang.Runnable
            public final void run() {
                y0.i(this.f41959a, runnable);
            }
        });
    }

    public static final void i(y0 y0Var, Runnable runnable) {
        y0Var.isSequentialThread.set(Boolean.TRUE);
        try {
            runnable.run();
        } finally {
            y0Var.isSequentialThread.remove();
        }
    }

    public final void c() {
        if (g()) {
            return;
        }
        throw new IllegalStateException(("Thread check failed: This method must be called from the UseCaseThreads sequential scope. Current thread: " + Thread.currentThread().getName()).toString());
    }

    /* renamed from: d, reason: from getter */
    public final Ua.M getScope() {
        return this.scope;
    }

    /* renamed from: e, reason: from getter */
    public final Executor getSequentialExecutor() {
        return this.sequentialExecutor;
    }

    /* renamed from: f, reason: from getter */
    public final Ua.M getSequentialScope() {
        return this.sequentialScope;
    }

    public final boolean g() {
        return kotlin.jvm.internal.p.d(this.isSequentialThread.get(), Boolean.TRUE);
    }
}
