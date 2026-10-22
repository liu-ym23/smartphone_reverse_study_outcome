package com.stepos.ability.service;

import C7.r;
import J7.c;
import S7.n;
import android.os.Bundle;
import com.stepos.ability.api.task.executor.ITaskExecutor;
import com.stepos.ability.bean.InternalTask;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "com.stepos.ability.service.AgentService$binder$1$updateTask$2", f = "AgentService.kt", l = {159}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
public final class AgentService$binder$1$updateTask$2 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f3266a;
    public final /* synthetic */ InternalTask b;
    public final /* synthetic */ AgentService c;
    public final /* synthetic */ String d;
    public final /* synthetic */ Bundle e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentService$binder$1$updateTask$2(InternalTask internalTask, AgentService agentService, String str, Bundle bundle, H7.c cVar) {
        super(2, cVar);
        this.b = internalTask;
        this.c = agentService;
        this.d = str;
        this.e = bundle;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new AgentService$binder$1$updateTask$2(this.b, this.c, this.d, this.e, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((AgentService$binder$1$updateTask$2) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f3266a;
        if (i == 0) {
            kotlin.b.b(obj);
            StringBuilder sb = new StringBuilder("updateTask:");
            InternalTask internalTask = this.b;
            sb.append(internalTask);
            P3.c.b("AgentService", sb.toString());
            ITaskExecutor taskExecutor = this.c.getTaskExecutor();
            int taskType = internalTask.getTask().getTaskType();
            this.f3266a = 1;
            if (taskExecutor.updateTask(this.d, taskType, this.e, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
        }
        return r.f317a;
    }
}
