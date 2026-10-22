package com.stepos.deepbinder.core.tools;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0002\u000b\fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/stepos/deepbinder/core/tools/IPCThreadCaller;", "", AppAgent.CONSTRUCT, "()V", "uiHandler", "Landroid/os/Handler;", "schedulerHandler", "singleThreadExecutor", "Ljava/util/concurrent/ExecutorService;", "threadPoolExecutor", "Ljava/util/concurrent/ThreadPoolExecutor;", "IPCThreadFactory", "Companion", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class IPCThreadCaller {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static volatile IPCThreadCaller instance;
    private final Handler schedulerHandler;
    private final ExecutorService singleThreadExecutor;
    private final ThreadPoolExecutor threadPoolExecutor;
    private final Handler uiHandler;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\tJ'\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015\"\u0004\b\u0000\u0010\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/stepos/deepbinder/core/tools/IPCThreadCaller$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lcom/stepos/deepbinder/core/tools/IPCThreadCaller;", "getImpl", "()Lcom/stepos/deepbinder/core/tools/IPCThreadCaller;", "Landroid/os/Handler;", "getSchedulerHandler", "()Landroid/os/Handler;", "", "isMainThread", "isSingleThread", "Ljava/lang/Runnable;", "runnable", "LC7/r;", "post", "(ZZLjava/lang/Runnable;)V", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/concurrent/Callable;", "callable", "Ljava/util/concurrent/Future;", "submit", "(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;", "instance", "Lcom/stepos/deepbinder/core/tools/IPCThreadCaller;", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private final IPCThreadCaller getImpl() {
            IPCThreadCaller iPCThreadCaller;
            IPCThreadCaller iPCThreadCaller2 = IPCThreadCaller.instance;
            if (iPCThreadCaller2 != null) {
                return iPCThreadCaller2;
            }
            synchronized (this) {
                iPCThreadCaller = IPCThreadCaller.instance;
                if (iPCThreadCaller == null) {
                    iPCThreadCaller = new IPCThreadCaller(null);
                    IPCThreadCaller.instance = iPCThreadCaller;
                }
            }
            return iPCThreadCaller;
        }

        public final Handler getSchedulerHandler() {
            return getImpl().schedulerHandler;
        }

        public final void post(boolean isMainThread, boolean isSingleThread, Runnable runnable) {
            k.f(runnable, "runnable");
            IPCThreadCaller impl = getImpl();
            if (isMainThread) {
                impl.uiHandler.post(runnable);
            } else if (isSingleThread) {
                impl.singleThreadExecutor.execute(runnable);
            } else {
                impl.threadPoolExecutor.execute(runnable);
            }
        }

        public final <T> Future<T> submit(Callable<T> callable) {
            k.f(callable, "callable");
            Future<T> futureSubmit = getImpl().threadPoolExecutor.submit(callable);
            k.e(futureSubmit, "submit(...)");
            return futureSubmit;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/stepos/deepbinder/core/tools/IPCThreadCaller$IPCThreadFactory;", "Ljava/util/concurrent/ThreadFactory;", AppAgent.CONSTRUCT, "()V", "threadCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "newThread", "Ljava/lang/Thread;", "runnable", "Ljava/lang/Runnable;", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class IPCThreadFactory implements ThreadFactory {
        private final AtomicInteger threadCount = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            k.f(runnable, "runnable");
            return new Thread(runnable, B7.a.h(this.threadCount.getAndIncrement(), "DeepBinder Thread:"));
        }
    }

    public /* synthetic */ IPCThreadCaller(e eVar) {
        this();
    }

    public static final Handler getSchedulerHandler() {
        return INSTANCE.getSchedulerHandler();
    }

    public static final void post(boolean z10, boolean z11, Runnable runnable) {
        INSTANCE.post(z10, z11, runnable);
    }

    public static final <T> Future<T> submit(Callable<T> callable) {
        return INSTANCE.submit(callable);
    }

    private IPCThreadCaller() {
        this.uiHandler = new Handler(Looper.getMainLooper());
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        HandlerThread handlerThread = new HandlerThread("DeepBinderHandlerThread");
        handlerThread.start();
        this.schedulerHandler = new Handler(handlerThread.getLooper());
        this.singleThreadExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new IPCThreadFactory());
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(iAvailableProcessors, iAvailableProcessors + 1, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new IPCThreadFactory());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.threadPoolExecutor = threadPoolExecutor;
    }
}
