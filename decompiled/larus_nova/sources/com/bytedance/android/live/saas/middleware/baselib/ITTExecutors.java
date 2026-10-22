package com.bytedance.android.live.saas.middleware.baselib;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0016\u0010\f\u001a\u0004\u0018\u00010\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/baselib/ITTExecutors;", "", "backgroundThreadPool", "Ljava/util/concurrent/ExecutorService;", "getBackgroundThreadPool", "()Ljava/util/concurrent/ExecutorService;", "cpuThreadPool", "getCpuThreadPool", "ioThreadPool", "getIoThreadPool", "normalThreadPool", "getNormalThreadPool", "scheduledThreadPool", "Ljava/util/concurrent/ScheduledExecutorService;", "getScheduledThreadPool", "()Ljava/util/concurrent/ScheduledExecutorService;", "serialThreadPool", "getSerialThreadPool", "middleware_release"}, k = 1, mv = {1, 4, 3})
public interface ITTExecutors {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static ExecutorService getBackgroundThreadPool(ITTExecutors r100) {
            return null;
        }

        public static ExecutorService getCpuThreadPool(ITTExecutors r100) {
            return null;
        }

        public static ExecutorService getIoThreadPool(ITTExecutors r100) {
            return null;
        }

        public static ExecutorService getNormalThreadPool(ITTExecutors r100) {
            return null;
        }

        public static ScheduledExecutorService getScheduledThreadPool(ITTExecutors r100) {
            return null;
        }

        public static ExecutorService getSerialThreadPool(ITTExecutors r100) {
            return null;
        }
    }

    ExecutorService getBackgroundThreadPool();

    ExecutorService getCpuThreadPool();

    ExecutorService getIoThreadPool();

    ExecutorService getNormalThreadPool();

    ScheduledExecutorService getScheduledThreadPool();

    ExecutorService getSerialThreadPool();
}
