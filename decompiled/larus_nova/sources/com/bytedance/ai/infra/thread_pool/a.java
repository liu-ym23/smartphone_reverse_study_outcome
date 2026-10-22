package com.bytedance.ai.infra.thread_pool;

import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes43.dex */
public final class a extends CoroutineDispatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f36599a;

    public a(ExecutorService r100) {
        Intrinsics.checkNotNullParameter(r100, "executor");
        this.f36599a = r100;
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement, kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return super.plus(r100);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext r100, Runnable r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "block");
        this.f36599a.execute(r101);     // Catch: RejectedExecutionException -> L5
        return;
    }
}
