package com.stepos.ailauncher.taskstore.repository;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl", f = "TaskInfoCardRepositoryImpl.kt", l = {428, 431}, m = "withExistingTaskId", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskInfoCardRepositoryImpl$withExistingTaskId$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TaskInfoCardRepositoryImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskInfoCardRepositoryImpl$withExistingTaskId$1(TaskInfoCardRepositoryImpl taskInfoCardRepositoryImpl, InterfaceC4014c<? super TaskInfoCardRepositoryImpl$withExistingTaskId$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = taskInfoCardRepositoryImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.D(null, this);
    }
}
