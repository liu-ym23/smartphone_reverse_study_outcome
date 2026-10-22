package com.bytedance.android.live.saas.middleware.fresco;

import android.app.ActivityManager;
import android.app.Application;
import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.bytedance.common.utility.concurrent.SimpleThreadFactory;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import com.facebook.imagepipeline.core.ExecutorSupplier;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.core.PriorityThreadFactory;
import com.optimize.statistics.FrescoTraceListener;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0017H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/fresco/DefaultConfig;", "", "()V", "MAX_CACHE_ENTRIES", "", "MAX_CACHE_ENTRY_SIZE", "MAX_EVICTION_QUEUE_ENTRIES", "MAX_EVICTION_QUEUE_SIZE", "assignExecutorThreadFactory", "", "executor", "Ljava/util/concurrent/Executor;", "priorityThreadFactoryWrapper", "Lcom/facebook/imagepipeline/core/PriorityThreadFactory;", "simpleThreadFactory", "Lcom/bytedance/common/utility/concurrent/SimpleThreadFactory;", "assignFrescoException", "config", "Lcom/facebook/imagepipeline/core/ImagePipelineConfig;", "getDefaultExecutorSupplier", "Lcom/facebook/imagepipeline/core/ExecutorSupplier;", "getMaxCache", "applicationContext", "Landroid/app/Application;", "getMemoryCache", "Lcom/facebook/imagepipeline/cache/MemoryCacheParams;", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class DefaultConfig {
    public static final DefaultConfig INSTANCE = null;
    public static final int MAX_CACHE_ENTRIES = 256;
    public static final int MAX_CACHE_ENTRY_SIZE = Integer.MAX_VALUE;
    public static final int MAX_EVICTION_QUEUE_ENTRIES = Integer.MAX_VALUE;
    public static final int MAX_EVICTION_QUEUE_SIZE = Integer.MAX_VALUE;

    private DefaultConfig() {
    }

    static {
        INSTANCE = new DefaultConfig();
    }

    public final ExecutorSupplier getDefaultExecutorSupplier() {
        return new AnonymousClass1();
    }

    @JvmStatic
    public static final void assignFrescoException(ImagePipelineConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        ExecutorSupplier r101 = r100.getExecutorSupplier();
        final DefaultConfig$assignFrescoException$uncaughtExceptionHandler$1 r102 = DefaultConfig$assignFrescoException$uncaughtExceptionHandler$1.INSTANCE;
        final int r103 = 10;
        PriorityThreadFactory r104 = new DefaultConfig$assignFrescoException$priorityThreadFactoryWrapper$1(r102, r103);
        final String r105 = FrescoTraceListener.ALOGTAG;
        SimpleThreadFactory r106 = new DefaultConfig$assignFrescoException$simpleThreadFactory$1(r102, r105);
        if (r101 == null) goto L6;
        DefaultConfig r107 = INSTANCE;
        r107.assignExecutorThreadFactory(r101.forLocalStorageRead(), r104, r106);
        r107.assignExecutorThreadFactory(r101.forDecode(), r104, r106);
        r107.assignExecutorThreadFactory(r101.forBackgroundTasks(), r104, r106);
        r107.assignExecutorThreadFactory(r101.forLightweightBackgroundTasks(), r104, r106);
        return;
    }

    @JvmStatic
    public static final int getMaxCache(Application r100) {
        Intrinsics.checkNotNullParameter(r100, "applicationContext");
        Object r101 = r100.getSystemService("activity");
        if (r101 == null) goto L13;
        ActivityManager r102 = (ActivityManager) r101;
        Intrinsics.checkNotNull(r102);
        int r103 = RangesKt.coerceAtMost(r102.getMemoryClass() * 1048576, Integer.MAX_VALUE);
        if (r103 >= 33554432) goto L8;
        return 4194304;
    L8:
        if (r103 >= 67108864) goto L11;
        return BmLocated.ALIGN_LEFT_BOTTOM;
    L11:
        return r103 / 8;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
    }

    @JvmStatic
    public static final MemoryCacheParams getMemoryCache(Application r100) {
        Intrinsics.checkNotNullParameter(r100, "applicationContext");
        return new MemoryCacheParams(getMaxCache(r100), 256, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    private final void assignExecutorThreadFactory(Executor r100, PriorityThreadFactory r101, SimpleThreadFactory r102) {
        if (ThreadPoolExecutor.class.isInstance(r100) == true) goto L5;
        return;
    L5:
        if (r100 == null) goto L15;
        ThreadPoolExecutor r103 = (ThreadPoolExecutor) r100;
        ThreadFactory r104 = r101;
        if (PriorityThreadFactory.class.isInstance(r103.getThreadFactory()) == true) goto L10;
        r104 = r102;
    L10:
        if (r104 != null) goto L12;
        return;
    L12:
        r103.setThreadFactory(r104);
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type java.util.concurrent.ThreadPoolExecutor");
    }
}
