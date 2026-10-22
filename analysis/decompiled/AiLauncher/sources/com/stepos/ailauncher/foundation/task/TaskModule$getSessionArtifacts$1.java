package com.stepos.ailauncher.foundation.task;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.foundation.task.TaskModule", f = "TaskModule.kt", l = {141}, m = "getSessionArtifacts", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskModule$getSessionArtifacts$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TaskModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskModule$getSessionArtifacts$1(TaskModule taskModule, InterfaceC4014c<? super TaskModule$getSessionArtifacts$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = taskModule;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(null, this);
    }
}
