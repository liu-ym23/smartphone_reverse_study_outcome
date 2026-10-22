package com.bytedance.android.ec.hybrid.data.utils;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class ECHybridHighPriorityThreadPool$EXECUTOR$2 extends Lambda implements Function0<ExecutorService> {
    public static final ECHybridHighPriorityThreadPool$EXECUTOR$2 INSTANCE = null;

    public static final class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f46826a = null;

        static {
            f46826a = new a();
        }

        public a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r100) {
            PthreadThreadV2 r101 = new PthreadThreadV2(r100, "ECHybridHighPriorityThreadPool$EXECUTOR$2$1");
            ThreadMethodProxy.setName(r101, "legou_high_priority_thread");
            return r101;
        }
    }

    static {
        INSTANCE = new ECHybridHighPriorityThreadPool$EXECUTOR$2();
    }

    public ECHybridHighPriorityThreadPool$EXECUTOR$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ExecutorService invoke2() {
        return PThreadExecutorsUtils.newSingleThreadExecutor(a.f46826a);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ExecutorService invoke() {
        return invoke2();
    }
}
