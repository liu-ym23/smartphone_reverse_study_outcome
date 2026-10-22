package com.stepos.ability.service;

import C7.r;
import J7.c;
import S7.n;
import com.stepos.ability.api.task.executor.ITaskExecutor;
import j9.m;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "com.stepos.ability.service.AgentService$binder$1$resumeFullScreenOverlay$3", f = "AgentService.kt", l = {352}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
public final class AgentService$binder$1$resumeFullScreenOverlay$3 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f3260a;
    public final /* synthetic */ AgentService b;
    public final /* synthetic */ String c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentService$binder$1$resumeFullScreenOverlay$3(AgentService agentService, String str, H7.c cVar) {
        super(2, cVar);
        this.b = agentService;
        this.c = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new AgentService$binder$1$resumeFullScreenOverlay$3(this.b, this.c, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((AgentService$binder$1$resumeFullScreenOverlay$3) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f3260a;
        if (i == 0) {
            kotlin.b.b(obj);
            ITaskExecutor taskExecutor = this.b.getTaskExecutor();
            String str = null;
            String str2 = this.c;
            if (str2 != null && !m.s0(str2)) {
                str = str2;
            }
            this.f3260a = 1;
            if (taskExecutor.resumeFullScreenOverlay(str, this) == coroutineSingletons) {
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
