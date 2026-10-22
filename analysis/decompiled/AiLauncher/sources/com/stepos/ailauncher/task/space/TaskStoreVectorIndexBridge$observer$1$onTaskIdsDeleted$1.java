package com.stepos.ailauncher.task.space;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.task.space.TaskStoreVectorIndexBridge$observer$1", f = "TaskStoreVectorIndexBridge.kt", l = {28}, m = "onTaskIdsDeleted", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskStoreVectorIndexBridge$observer$1$onTaskIdsDeleted$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TaskStoreVectorIndexBridge$observer$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskStoreVectorIndexBridge$observer$1$onTaskIdsDeleted$1(TaskStoreVectorIndexBridge$observer$1 taskStoreVectorIndexBridge$observer$1, InterfaceC4014c<? super TaskStoreVectorIndexBridge$observer$1$onTaskIdsDeleted$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = taskStoreVectorIndexBridge$observer$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, this);
    }
}
