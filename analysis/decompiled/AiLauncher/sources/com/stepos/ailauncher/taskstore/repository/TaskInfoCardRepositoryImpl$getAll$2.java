package com.stepos.ailauncher.taskstore.repository;

import Ua.M;
import Y8.t;
import com.stepos.ailauncher.taskstore.TaskStoreModule;
import com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;
import z6.C6363a;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "<anonymous>", "(LUa/M;)Ljava/util/List;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl$getAll$2", f = "TaskInfoCardRepositoryImpl.kt", l = {99}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class TaskInfoCardRepositoryImpl$getAll$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super List<? extends TaskInfoCard>>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ TaskInfoCardRepositoryImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskInfoCardRepositoryImpl$getAll$2(TaskInfoCardRepositoryImpl taskInfoCardRepositoryImpl, InterfaceC4014c<? super TaskInfoCardRepositoryImpl$getAll$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = taskInfoCardRepositoryImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new TaskInfoCardRepositoryImpl$getAll$2(this.this$0, interfaceC4014c);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(M m10, InterfaceC4014c<? super List<TaskInfoCard>> interfaceC4014c) {
        return ((TaskInfoCardRepositoryImpl$getAll$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C6363a c6363a;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            C6363a c6363a2 = C6363a.INSTANCE;
            TaskInfoCardDao taskInfoCardDao = this.this$0.dao;
            String strK = TaskStoreModule.INSTANCE.k();
            this.L$0 = c6363a2;
            this.label = 1;
            Object objZ = taskInfoCardDao.z(strK, this);
            if (objZ == objG) {
                return objG;
            }
            obj = objZ;
            c6363a = c6363a2;
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c6363a = (C6363a) this.L$0;
            C4849c.b(obj);
        }
        return c6363a.b((List) obj);
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super List<? extends TaskInfoCard>> interfaceC4014c) {
        return invoke2(m10, (InterfaceC4014c<? super List<TaskInfoCard>>) interfaceC4014c);
    }
}
