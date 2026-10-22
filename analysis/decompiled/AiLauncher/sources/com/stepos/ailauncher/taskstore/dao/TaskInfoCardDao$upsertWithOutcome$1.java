package com.stepos.ailauncher.taskstore.dao;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao", f = "TaskInfoCardDao.kt", l = {95}, m = "upsertWithOutcome$suspendImpl", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskInfoCardDao$upsertWithOutcome$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TaskInfoCardDao this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskInfoCardDao$upsertWithOutcome$1(TaskInfoCardDao taskInfoCardDao, InterfaceC4014c<? super TaskInfoCardDao$upsertWithOutcome$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = taskInfoCardDao;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return TaskInfoCardDao.p(this.this$0, null, this);
    }
}
