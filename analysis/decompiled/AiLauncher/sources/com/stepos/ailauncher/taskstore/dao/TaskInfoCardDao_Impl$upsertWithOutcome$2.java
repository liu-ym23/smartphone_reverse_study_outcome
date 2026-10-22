package com.stepos.ailauncher.taskstore.dao;

import com.stepos.ailauncher.taskstore.entity.TaskInfoCardEntity;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/stepos/ailauncher/taskstore/dao/TaskInfoCardUpsertOutcome;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao_Impl$upsertWithOutcome$2", f = "TaskInfoCardDao_Impl.kt", l = {416}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class TaskInfoCardDao_Impl$upsertWithOutcome$2 extends SuspendLambda implements InterfaceC5074l<InterfaceC4014c<? super TaskInfoCardUpsertOutcome>, Object> {
    final /* synthetic */ TaskInfoCardEntity $card;
    int label;
    final /* synthetic */ TaskInfoCardDao_Impl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskInfoCardDao_Impl$upsertWithOutcome$2(TaskInfoCardDao_Impl taskInfoCardDao_Impl, TaskInfoCardEntity taskInfoCardEntity, InterfaceC4014c<? super TaskInfoCardDao_Impl$upsertWithOutcome$2> interfaceC4014c) {
        super(1, interfaceC4014c);
        this.this$0 = taskInfoCardDao_Impl;
        this.$card = taskInfoCardEntity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(InterfaceC4014c<?> interfaceC4014c) {
        return new TaskInfoCardDao_Impl$upsertWithOutcome$2(this.this$0, this.$card, interfaceC4014c);
    }

    @Override // p9.InterfaceC5074l
    public final Object invoke(InterfaceC4014c<? super TaskInfoCardUpsertOutcome> interfaceC4014c) {
        return ((TaskInfoCardDao_Impl$upsertWithOutcome$2) create(interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        TaskInfoCardDao_Impl taskInfoCardDao_Impl = this.this$0;
        TaskInfoCardEntity taskInfoCardEntity = this.$card;
        this.label = 1;
        Object objR = super/*com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao*/.r(taskInfoCardEntity, this);
        return objR == objG ? objG : objR;
    }
}
