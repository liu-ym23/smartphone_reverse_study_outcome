package androidx.emoji2.text;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
class ConcurrencyHelpers {
    private static final int FONT_LOAD_TIMEOUT_SECONDS = 15;

    /* JADX INFO: loaded from: classes17.dex */
    public static class Handler28Impl {
        private Handler28Impl() {
        }

        public static Handler createAsync(Looper r100) {
            return Handler.createAsync(r100);
        }
    }

    private ConcurrencyHelpers() {
    }

    public static /* synthetic */ Thread a(String r100, Runnable r101) {
        return lambda$createBackgroundPriorityExecutor$0(r100, r101);
    }

    public static Handler mainHandlerAsync() {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return Handler28Impl.createAsync(Looper.getMainLooper());
    L7:
        return new Handler(Looper.getMainLooper());
    }

    public static Executor convertHandlerToExecutor(final Handler r100) {
        Objects.requireNonNull(r100);
        return new b(r100);
    }

    public static ThreadPoolExecutor createBackgroundPriorityExecutor(final String r100) {
        ThreadFactory r101 = new a(r100);
        PThreadPoolExecutor r102 = new PThreadPoolExecutor(0, 1, 15, TimeUnit.SECONDS, new LinkedBlockingDeque(), r101);
        r102.allowCoreThreadTimeOut(true);
        return r102;
    }

    private static /* synthetic */ Thread lambda$createBackgroundPriorityExecutor$0(String r100, Runnable r101) {
        PthreadThreadV2 r102 = new PthreadThreadV2(r101, r100);
        ThreadMethodProxy.setPriority(r102, 10);
        return r102;
    }
}
