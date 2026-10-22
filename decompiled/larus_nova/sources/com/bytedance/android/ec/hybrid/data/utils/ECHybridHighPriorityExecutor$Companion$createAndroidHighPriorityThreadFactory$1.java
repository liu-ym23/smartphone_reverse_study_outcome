package com.bytedance.android.ec.hybrid.data.utils;

import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.log.mall.e;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes44.dex */
public final class ECHybridHighPriorityExecutor$Companion$createAndroidHighPriorityThreadFactory$1 implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f46822a;

    public static final class a implements Thread.UncaughtExceptionHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f46825a = null;

        static {
            f46825a = new a();
        }

        public a() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public final void uncaughtException(Thread r100, Throwable r101) {
            Lazy r102 = ECMallLogUtil.f47441a;
            ECMallLogUtil.b(e.b.f47470b, "ECHybridHighPriorityExecutor, thread = " + r100.getName() + ", e = " + r101);
        }
    }

    public ECHybridHighPriorityExecutor$Companion$createAndroidHighPriorityThreadFactory$1(int r100) {
        this.f46822a = r100;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(final Runnable r100) {
        PthreadThreadV2 r101 = new PthreadThreadV2(new AnonymousClass1(this, r100), "ECHybridHighPriorityExecutor$Companion$createAndroidHighPriorityThreadFactory$1");
        ThreadMethodProxy.setName(r101, "ec-hybrid-high-priority-thread-" + c.f46835b.getAndIncrement());
        r101.setUncaughtExceptionHandler(a.f46825a);
        return r101;
    }
}
