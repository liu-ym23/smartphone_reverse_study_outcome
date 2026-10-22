package com.bytedance.ai.infra.thread_pool;

import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor;

/* JADX INFO: loaded from: classes43.dex */
public final class c extends PThreadScheduledThreadPoolExecutor {
    public c(d r100) {
        super(1, r100);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public final void afterExecute(Runnable r100, Throwable r101) {
        super.afterExecute(r100, r101);
        c5.c.a(r100, r101);
    }
}
