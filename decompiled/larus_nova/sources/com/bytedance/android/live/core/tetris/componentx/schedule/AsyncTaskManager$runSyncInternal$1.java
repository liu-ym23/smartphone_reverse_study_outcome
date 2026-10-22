package com.bytedance.android.live.core.tetris.componentx.schedule;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0082@"}, d2 = {"", "taskName", "Lkotlin/coroutines/Continuation;", "", "continuation", "", "runSyncInternal"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.live.core.tetris.componentx.schedule.AsyncTaskManager", f = "AsyncTaskManager.kt", i = {1, 1, 3, 3, 3, 4, 4}, l = {87, 91, 92, 95, 102}, m = "runSyncInternal", n = {"this", "taskName", "this", "taskName", "task", "this", "taskName"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1"})
public final class AsyncTaskManager$runSyncInternal$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AsyncTaskManager this$0;

    public AsyncTaskManager$runSyncInternal$1(AsyncTaskManager r100, Continuation r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, this);
    }
}
