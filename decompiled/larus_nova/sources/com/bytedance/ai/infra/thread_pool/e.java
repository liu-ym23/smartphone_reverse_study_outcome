package com.bytedance.ai.infra.thread_pool;

import com.bytedance.common.utility.Logger;
import com.bytedance.crash.dumper.Scraps;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class e extends PThreadPoolExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f36610a;

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public final void shutdown() {
        if (this.f36610a == false) goto L6;
        super.shutdown();
        return;
    L6:
        Logger.throwException(new Throwable("Trying to call shutdown() in a persist pool"));
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public final List<Runnable> shutdownNow() {
        if (this.f36610a == true) goto L5;
        Logger.throwException(new Throwable("Trying to call shutdownNow() in a persist pool"));
        return new ArrayList();
    L5:
        return super.shutdownNow();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public final void afterExecute(Runnable r100, Throwable r101) {
        super.afterExecute(r100, r101);
        c5.c.a(r100, r101);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long r100, TimeUnit r101) throws InterruptedException {
        Intrinsics.checkNotNullParameter(r101, Scraps.INNER_UNIT);
        if (this.f36610a == true) goto L5;
        Logger.throwException(new Throwable("Trying to call awaitTermination() in a persist pool"));
        return true;
    L5:
        return super.awaitTermination(r100, r101);
    }

    public e(int r110, int r111, TimeUnit r112, BlockingQueue r113, d r114, c5.b r115) {
        super(r110, r111, 30, r112, r113, r114, r115);
        this.f36610a = true;
        this.f36610a = false;
    }

    public e(int r100, int r101, long r102, TimeUnit r103, BlockingQueue r104, d r105) {
        super(r100, r101, r102, r103, r104, r105);
        this.f36610a = true;
        this.f36610a = false;
    }
}
