package androidx.core.provider;

import android.os.Handler;
import android.os.Process;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes17.dex */
class RequestExecutor {

    public static class DefaultThreadFactory implements ThreadFactory {
        private int mPriority;
        private String mThreadName;

        public static class ProcessPriorityThread extends PthreadThreadV2 {
            private final int mPriority;

            @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
            public void run() {
                androidx_core_provider_RequestExecutor$DefaultThreadFactory$ProcessPriorityThread_com_larus_apm_impl_protector_RunnableLancet_run(this);
            }

            public void androidx_core_provider_RequestExecutor$DefaultThreadFactory$ProcessPriorityThread__run$___twin___() {
                Process.setThreadPriority(this.mPriority);
                super.run();
            }

            @Skip({"com.ss.android.ugc.bytex.pthread+"})
            public static void androidx_core_provider_RequestExecutor$DefaultThreadFactory$ProcessPriorityThread_com_larus_apm_impl_protector_RunnableLancet_run(ProcessPriorityThread r100) {
                r100.androidx_core_provider_RequestExecutor$DefaultThreadFactory$ProcessPriorityThread__run$___twin___();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public ProcessPriorityThread(Runnable r100, String r101, int r102) {
                super(r100, r101);
                this.mPriority = r102;
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r100) {
            return new ProcessPriorityThread(r100, this.mThreadName, this.mPriority);
        }

        public DefaultThreadFactory(String r100, int r101) {
            this.mThreadName = r100;
            this.mPriority = r101;
        }
    }

    public static class HandlerExecutor implements Executor {
        private final Handler mHandler;

        public HandlerExecutor(Handler r100) {
            this.mHandler = (Handler) Preconditions.checkNotNull(r100);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r100) {
            if (this.mHandler.post((Runnable) Preconditions.checkNotNull(r100)) == false) goto L6;
            return;
        L6:
            throw new RejectedExecutionException(this.mHandler + " is shutting down");
        }
    }

    public static class ReplyRunnable<T> implements Runnable {
        private Callable<T> mCallable;
        private Consumer<T> mConsumer;
        private Handler mHandler;

        @Override // java.lang.Runnable
        public void run() {
            androidx_core_provider_RequestExecutor$ReplyRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void androidx_core_provider_RequestExecutor$ReplyRunnable__run$___twin___() {
            final T r100 = this.mCallable.call();     // Catch: Exception -> L4
        L5:
            final Consumer<T> r101 = this.mConsumer;
            this.mHandler.post(new AnonymousClass1(this, r101, r100));
            return;
        L4:
            r100 = null;
            goto L5
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void androidx_core_provider_RequestExecutor$ReplyRunnable_com_larus_apm_impl_protector_RunnableLancet_run(ReplyRunnable r100) {
            r100.androidx_core_provider_RequestExecutor$ReplyRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public ReplyRunnable(Handler r100, Callable<T> r101, Consumer<T> r102) {
            this.mCallable = r101;
            this.mConsumer = r102;
            this.mHandler = r100;
        }
    }

    private RequestExecutor() {
    }

    public static Executor createHandlerExecutor(Handler r100) {
        return new HandlerExecutor(r100);
    }

    public static ThreadPoolExecutor createDefaultExecutor(String r100, int r101, int r110) {
        PThreadPoolExecutor r102 = new PThreadPoolExecutor(0, 1, r110, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new DefaultThreadFactory(r100, r101));
        r102.allowCoreThreadTimeOut(true);
        return r102;
    }

    public static <T> void execute(Executor r100, Callable<T> r101, Consumer<T> r102) {
        r100.execute(new ReplyRunnable(CalleeHandler.create(), r101, r102));
    }

    public static <T> T submit(ExecutorService r100, Callable<T> r101, int r102) throws InterruptedException {
        return r100.submit(r101).get(r102, TimeUnit.MILLISECONDS);
    L7:
        e = move-exception;
        throw e;
    L9:
        e = move-exception;
        throw new RuntimeException(e);
    L6:
        throw new InterruptedException("timeout");
    }
}
