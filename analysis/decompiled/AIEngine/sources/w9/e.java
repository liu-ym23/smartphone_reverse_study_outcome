package w9;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: e, reason: collision with root package name */
    public static final a f13612e = new a();

    /* renamed from: f, reason: collision with root package name */
    public static volatile e f13613f;

    /* renamed from: a, reason: collision with root package name */
    public final Handler f13614a = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    public final Handler f13615b;

    /* renamed from: c, reason: collision with root package name */
    public final ThreadPoolExecutor f13616c;

    /* renamed from: d, reason: collision with root package name */
    public final ThreadPoolExecutor f13617d;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
        public final e a() {
            e eVar;
            e eVar2 = e.f13613f;
            if (eVar2 != null) {
                return eVar2;
            }
            synchronized (this) {
                eVar = e.f13613f;
                if (eVar == null) {
                    eVar = new e();
                    e.f13613f = eVar;
                }
            }
            return eVar;
        }

        public final void b(Runnable runnable, boolean z, boolean z3) {
            e eVarA = a();
            if (z) {
                eVarA.f13614a.post(runnable);
            } else if (z3) {
                eVarA.f13616c.execute(runnable);
            } else {
                eVarA.f13617d.execute(runnable);
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicInteger f13618a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            kotlin.jvm.internal.g.f(runnable, "runnable");
            return new Thread(runnable, ai.onnxruntime.providers.a.a(this.f13618a.getAndIncrement(), "DeepBinder Thread:"));
        }
    }

    public e() {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        HandlerThread handlerThread = new HandlerThread("DeepBinderHandlerThread");
        handlerThread.start();
        this.f13615b = new Handler(handlerThread.getLooper());
        this.f13616c = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new b());
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(iAvailableProcessors, iAvailableProcessors + 1, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f13617d = threadPoolExecutor;
    }
}
