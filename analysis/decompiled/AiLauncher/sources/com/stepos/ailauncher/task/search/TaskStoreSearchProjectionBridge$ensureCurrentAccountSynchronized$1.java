package com.stepos.ailauncher.task.search;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.task.search.TaskStoreSearchProjectionBridge", f = "TaskStoreSearchProjectionBridge.kt", l = {113, 72, 77}, m = "ensureCurrentAccountSynchronized$task_release", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskStoreSearchProjectionBridge$ensureCurrentAccountSynchronized$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TaskStoreSearchProjectionBridge this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskStoreSearchProjectionBridge$ensureCurrentAccountSynchronized$1(TaskStoreSearchProjectionBridge taskStoreSearchProjectionBridge, InterfaceC4014c<? super TaskStoreSearchProjectionBridge$ensureCurrentAccountSynchronized$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = taskStoreSearchProjectionBridge;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(this);
    }
}
