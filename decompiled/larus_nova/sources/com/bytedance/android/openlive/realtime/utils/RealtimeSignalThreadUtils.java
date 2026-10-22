package com.bytedance.android.openlive.realtime.utils;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/openlive/realtime/utils/RealtimeSignalThreadUtils;", "", "()V", "realTimeSignalThreadPool", "Ljava/util/concurrent/ExecutorService;", "getRealTimeSignalThreadPool", "()Ljava/util/concurrent/ExecutorService;", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class RealtimeSignalThreadUtils {
    public static final RealtimeSignalThreadUtils INSTANCE = null;
    private static final ExecutorService realTimeSignalThreadPool = null;

    private RealtimeSignalThreadUtils() {
    }

    static {
        INSTANCE = new RealtimeSignalThreadUtils();
        realTimeSignalThreadPool = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("RealtimeSignalThreadUtils"));
    }

    public final ExecutorService getRealTimeSignalThreadPool() {
        return realTimeSignalThreadPool;
    }
}
