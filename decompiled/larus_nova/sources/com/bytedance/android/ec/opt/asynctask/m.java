package com.bytedance.android.ec.opt.asynctask;

import com.bytedance.crash.dumper.Scraps;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class m extends PThreadPoolExecutor {
    @Override // java.util.concurrent.ThreadPoolExecutor
    public final void terminated() {
        super.terminated();
        System.out.println("Django: AsyncTaskManager: thread pool is terminated");
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public final void afterExecute(Runnable r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "r");
        super.afterExecute(r100, r101);
        if (r101 == null) goto L5;
        System.out.println("Django: AsyncTaskManager: afterExecute: " + r100 + " is executed: throw: " + r101);
        return;
    L5:
        System.out.println("Django: AsyncTaskManager: afterExecute: " + r100 + " is executed.");
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public final void beforeExecute(Thread r100, Runnable r101) {
        Intrinsics.checkNotNullParameter(r100, "t");
        Intrinsics.checkNotNullParameter(r101, "r");
        super.beforeExecute(r100, r101);
        System.out.println("Django: AsyncTaskManager: beforeExecute: thread: " + r100 + ", " + r100.hashCode() + ", task: " + r101);
    }

    public m(int r110, int r111, TimeUnit r112, BlockingQueue r113, TaskExecutor.b r114, TaskExecutor.c r115) {
        Intrinsics.checkNotNullParameter(r112, Scraps.INNER_UNIT);
        Intrinsics.checkNotNullParameter(r113, "workQueue");
        Intrinsics.checkNotNullParameter(r114, "threadFactory");
        Intrinsics.checkNotNullParameter(r115, "handler");
        super(r110, r111, 60, r112, r113, r114, r115);
    }

    public m(int r100, int r101, long r102, TimeUnit r103, BlockingQueue r104, TaskExecutor.b r105) {
        Intrinsics.checkNotNullParameter(r103, Scraps.INNER_UNIT);
        Intrinsics.checkNotNullParameter(r104, "workQueue");
        Intrinsics.checkNotNullParameter(r105, "threadFactory");
        super(r100, r101, r102, r103, r104, r105);
    }
}
