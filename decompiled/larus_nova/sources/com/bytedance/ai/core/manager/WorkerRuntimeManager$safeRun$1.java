package com.bytedance.ai.core.manager;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.core.manager.WorkerRuntimeManager", f = "WorkerRuntimeManager.kt", i = {0}, l = {69}, m = "safeRun", n = {"$this$safeRun"}, s = {"L$0"})
public final class WorkerRuntimeManager$safeRun$1<T> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WorkerRuntimeManager this$0;

    public WorkerRuntimeManager$safeRun$1(WorkerRuntimeManager r100, Continuation<? super WorkerRuntimeManager$safeRun$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        WorkerRuntimeManager r101 = this.this$0;
        int r102 = WorkerRuntimeManager.f36157e;
        return r101.c(null, null, this);
    }
}
