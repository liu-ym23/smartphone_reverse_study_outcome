package com.bytedance.android.livesdkapi.player;

import com.bytedance.android.live.player.utils.b;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes12.dex */
public class PlayerSingleExecutor implements Executor {
    private static final String TAG = null;
    private Execution mExecution;
    private RejectionHandler mRejectionHandler;
    private ArrayBlockingQueue<Runnable> mTaskQueue;

    /* JADX INFO: renamed from: com.bytedance.android.livesdkapi.player.PlayerSingleExecutor$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private int mCapacity;
        private RejectionHandler mRejectionHandler;
        private String mThreadName;

        public PlayerSingleExecutor build() {
            AnonymousClass1 r100 = null;
            return new PlayerSingleExecutor(this.mCapacity, new SimpleThreadFactory(this.mThreadName, r100), this.mRejectionHandler, r100);
        }

        public Builder() {
        }

        public Builder setCapacity(int r100) {
            this.mCapacity = r100;
            return this;
        }

        public Builder setRejectionHandler(RejectionHandler r100) {
            this.mRejectionHandler = r100;
            return this;
        }

        public Builder setThreadName(String r100) {
            this.mThreadName = r100;
            return this;
        }
    }

    public static class Execution implements Runnable {
        private boolean exit;
        private ArrayBlockingQueue<Runnable> mTaskQueue;

        @Override // java.lang.Runnable
        public void run() {
            com_bytedance_android_livesdkapi_player_PlayerSingleExecutor$Execution_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_bytedance_android_livesdkapi_player_PlayerSingleExecutor$Execution__run$___twin___() {
        L3:
            if (this.exit == true) goto L8;
            this.mTaskQueue.take().run();     // Catch: InterruptedException -> L6
        L6:
            e = move-exception;
            b.d(e.getMessage());
            goto L3
        }

        private Execution(ArrayBlockingQueue<Runnable> r100) {
            this.mTaskQueue = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_bytedance_android_livesdkapi_player_PlayerSingleExecutor$Execution_com_larus_apm_impl_protector_RunnableLancet_run(Execution r100) {
            r100.com_bytedance_android_livesdkapi_player_PlayerSingleExecutor$Execution__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public /* synthetic */ Execution(ArrayBlockingQueue r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public interface RejectionHandler {
        void onRejected();
    }

    public static class SimpleThreadFactory implements ThreadFactory {
        private String threadName;
        private AtomicInteger threadSeq;

        private SimpleThreadFactory(String r100) {
            this.threadSeq = new AtomicInteger();
            this.threadName = r100;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r100) {
            PthreadThreadV2 r101 = new PthreadThreadV2(r100, this.threadName + "-" + this.threadSeq.incrementAndGet());
            if (r101.isDaemon() == false) goto L6;
            r101.setDaemon(false);
        L6:
            if (r101.getPriority() == 1) goto L8;
            ThreadMethodProxy.setPriority(r101, 1);
        L8:
            return r101;
        }

        public /* synthetic */ SimpleThreadFactory(String r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    static {
        TAG = "PlayerSingleExecutor";
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r100) {
        if (this.mTaskQueue.offer(r100) == true) goto L8;
        RejectionHandler r101 = this.mRejectionHandler;
        if (r101 == null) goto L9;
        r101.onRejected();
        return;
    L9:
        return;
    }

    private PlayerSingleExecutor(int r100, ThreadFactory r101, RejectionHandler r102) {
        ArrayBlockingQueue<Runnable> r103 = new ArrayBlockingQueue(r100);
        this.mTaskQueue = r103;
        Execution r104 = new Execution(r103, null);
        this.mExecution = r104;
        ThreadMethodProxy.start(r101.newThread(r104));
        this.mRejectionHandler = r102;
    }

    public /* synthetic */ PlayerSingleExecutor(int r100, ThreadFactory r101, RejectionHandler r102, AnonymousClass1 r103) {
        this(r100, r101, r102);
    }
}
