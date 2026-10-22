package com.stepos.cpuset;

import android.os.Process;
import android.util.Log;
import com.stepos.cpuset.NeoDispatchers;
import com.stepos.cpuset.internal.AiCpuSetBridge;
import h0.e;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import lb.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class NeoDispatchers {
    public static final NeoDispatchers INSTANCE = new NeoDispatchers();
    private static final String TAG = "AIDispatchers";

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class AiThreadFactory implements ThreadFactory {
        private final String dispatcherName;
        private final String namePrefix;
        private final AffinityPolicy policy;
        private final AtomicInteger threadCount;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[AffinityPolicy.values().length];
                try {
                    iArr[AffinityPolicy.POWER_SAVE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[AffinityPolicy.POWER_LOWEST.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public AiThreadFactory(AffinityPolicy policy, String namePrefix, String dispatcherName) {
            g.f(policy, "policy");
            g.f(namePrefix, "namePrefix");
            g.f(dispatcherName, "dispatcherName");
            this.policy = policy;
            this.namePrefix = namePrefix;
            this.dispatcherName = dispatcherName;
            this.threadCount = new AtomicInteger(0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void newThread$lambda$0(AiThreadFactory aiThreadFactory, String str, Runnable runnable) {
            int i10;
            int iMyTid = Process.myTid();
            try {
                int i11 = WhenMappings.$EnumSwitchMapping$0[aiThreadFactory.policy.ordinal()];
                if (i11 == 1) {
                    i10 = 0;
                } else {
                    if (i11 != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    i10 = 10;
                }
                Process.setThreadPriority(iMyTid, i10);
                AiCpuSetBridge aiCpuSetBridge = AiCpuSetBridge.INSTANCE;
                if (aiCpuSetBridge.acquire(iMyTid, aiThreadFactory.policy, aiThreadFactory.dispatcherName)) {
                    Log.d(NeoDispatchers.TAG, "线程 " + str + "(tid=" + iMyTid + ") 成功绑定到策略 " + aiThreadFactory.policy.name());
                } else {
                    Log.w(NeoDispatchers.TAG, "线程 " + str + "(tid=" + iMyTid + ") 绑核失败，将使用系统默认调度");
                }
                runnable.run();
                aiCpuSetBridge.release(iMyTid);
            } catch (Throwable th) {
                try {
                    Log.e(NeoDispatchers.TAG, "线程 " + str + " 执行异常", th);
                } finally {
                    AiCpuSetBridge.INSTANCE.release(iMyTid);
                }
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(final Runnable runnable) {
            g.f(runnable, "runnable");
            int iIncrementAndGet = this.threadCount.incrementAndGet();
            final String str = this.namePrefix + "-" + iIncrementAndGet;
            Thread thread = new Thread(new Runnable() { // from class: com.stepos.cpuset.a
                @Override // java.lang.Runnable
                public final void run() {
                    NeoDispatchers.AiThreadFactory.newThread$lambda$0(this.f7616a, str, runnable);
                }
            });
            thread.setName(str);
            thread.setDaemon(false);
            return thread;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class CPU {
        public static final CPU INSTANCE = new CPU();
        private static final d POWER_SAVE$delegate = kotlin.b.b(new b(0));
        private static final d POWER_LOWEST$delegate = kotlin.b.b(new a9.b(29));

        private CPU() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CoroutineDispatcher POWER_LOWEST_delegate$lambda$1() {
            return NeoDispatchers.INSTANCE.createAiDispatcher(AffinityPolicy.POWER_LOWEST, 2, "AI-CPU-POWER_LOWEST", "CPU.POWER_LOWEST");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CoroutineDispatcher POWER_SAVE_delegate$lambda$0() {
            return NeoDispatchers.INSTANCE.createAiDispatcher(AffinityPolicy.POWER_SAVE, 2, "AI-CPU-POWER_SAVE", "CPU.POWER_SAVE");
        }

        public final CoroutineDispatcher getPOWER_LOWEST() {
            return (CoroutineDispatcher) POWER_LOWEST$delegate.getValue();
        }

        public final CoroutineDispatcher getPOWER_SAVE() {
            return (CoroutineDispatcher) POWER_SAVE$delegate.getValue();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class IO {
        public static final IO INSTANCE = new IO();
        private static final d POWER_SAVE$delegate = kotlin.b.b(new b(1));
        private static final d POWER_LOWEST$delegate = kotlin.b.b(new c(0));

        private IO() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CoroutineDispatcher POWER_LOWEST_delegate$lambda$1() {
            return NeoDispatchers.INSTANCE.createAiDispatcher(AffinityPolicy.POWER_LOWEST, 48, "AI-IO-POWER_LOWEST", "IO.POWER_LOWEST");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CoroutineDispatcher POWER_SAVE_delegate$lambda$0() {
            return NeoDispatchers.INSTANCE.createAiDispatcher(AffinityPolicy.POWER_SAVE, 32, "AI-IO-POWER_SAVE", "IO.POWER_SAVE");
        }

        public final CoroutineDispatcher getPOWER_LOWEST() {
            return (CoroutineDispatcher) POWER_LOWEST$delegate.getValue();
        }

        public final CoroutineDispatcher getPOWER_SAVE() {
            return (CoroutineDispatcher) POWER_SAVE$delegate.getValue();
        }
    }

    private NeoDispatchers() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoroutineDispatcher createAiDispatcher(AffinityPolicy affinityPolicy, int i10, String str, String str2) {
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(i10, new AiThreadFactory(affinityPolicy, str, str2));
        StringBuilder sbF = e.f("创建协程调度器: ", str, ", 线程数: ", i10, ", 策略: ");
        sbF.append(str2);
        Log.i(TAG, sbF.toString());
        g.c(executorServiceNewFixedThreadPool);
        return ExecutorsKt.from(executorServiceNewFixedThreadPool);
    }
}
