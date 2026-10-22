package com.stepos.ailauncher.taskstore.repository;

import Ua.M;
import Y8.t;
import com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)I"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl$setCardHidden$2", f = "TaskInfoCardRepositoryImpl.kt", l = {147}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class TaskInfoCardRepositoryImpl$setCardHidden$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super Integer>, Object> {
    final /* synthetic */ boolean $hidden;
    final /* synthetic */ String $taskId;
    int label;
    final /* synthetic */ TaskInfoCardRepositoryImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskInfoCardRepositoryImpl$setCardHidden$2(TaskInfoCardRepositoryImpl taskInfoCardRepositoryImpl, String str, boolean z10, InterfaceC4014c<? super TaskInfoCardRepositoryImpl$setCardHidden$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = taskInfoCardRepositoryImpl;
        this.$taskId = str;
        this.$hidden = z10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new TaskInfoCardRepositoryImpl$setCardHidden$2(this.this$0, this.$taskId, this.$hidden, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Integer> interfaceC4014c) {
        return ((TaskInfoCardRepositoryImpl$setCardHidden$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
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
        TaskInfoCardDao taskInfoCardDao = this.this$0.dao;
        String str = this.$taskId;
        boolean z10 = this.$hidden;
        this.label = 1;
        Object objS = taskInfoCardDao.s(str, z10, this);
        return objS == objG ? objG : objS;
    }
}
