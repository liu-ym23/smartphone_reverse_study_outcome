package com.stepos.ailauncher.task.detail;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.task.detail.TaskDetailActivity", f = "TaskDetailActivity.kt", l = {305}, m = "queryVersionGroup", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskDetailActivity$queryVersionGroup$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TaskDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskDetailActivity$queryVersionGroup$1(TaskDetailActivity taskDetailActivity, InterfaceC4014c<? super TaskDetailActivity$queryVersionGroup$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = taskDetailActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.I2(null, this);
    }
}
