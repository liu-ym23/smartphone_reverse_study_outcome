package com.stepos.ability.runtime;

import C7.r;
import J7.c;
import S7.n;
import com.stepos.ability.api.ability.calltool.CallToolRequest;
import com.stepos.ability.api.ability.calltool.ICallTool;
import com.stepos.ability.commoninternal.AbilityType;
import com.stepos.ability.runtime.model.CoroutinePriorityTask;
import com.stepos.taskrobot.llmapi.stepfun.g;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1733z;
import u9.d;

@c(c = "com.stepos.ability.runtime.RuntimeManager$launchTask$job$1$result$1", f = "RuntimeManager.kt", l = {211}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "Lcom/stepos/ability/beaninternal/ability/FunctionCallResult;", "<anonymous>", "(Lm9/z;)Lcom/stepos/ability/beaninternal/ability/FunctionCallResult;"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class RuntimeManager$launchTask$job$1$result$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f3219a;
    public final /* synthetic */ CoroutinePriorityTask b;

    @c(c = "com.stepos.ability.runtime.RuntimeManager$launchTask$job$1$result$1$1", f = "RuntimeManager.kt", l = {212}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "Lcom/stepos/ability/beaninternal/ability/FunctionCallResult;", "<anonymous>", "(Lm9/z;)Lcom/stepos/ability/beaninternal/ability/FunctionCallResult;"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.ability.runtime.RuntimeManager$launchTask$job$1$result$1$1, reason: invalid class name */
    final class AnonymousClass1 extends SuspendLambda implements n {

        /* renamed from: a, reason: collision with root package name */
        public int f3220a;
        public final /* synthetic */ CoroutinePriorityTask b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(CoroutinePriorityTask coroutinePriorityTask, H7.c cVar) {
            super(2, cVar);
            this.b = coroutinePriorityTask;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c create(Object obj, H7.c cVar) {
            return new AnonymousClass1(this.b, cVar);
        }

        @Override // S7.n
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.f3220a;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
                return obj;
            }
            kotlin.b.b(obj);
            CoroutinePriorityTask coroutinePriorityTask = this.b;
            ICallTool callTool = coroutinePriorityTask.getCallTool();
            CallToolRequest callToolRequest = new CallToolRequest(coroutinePriorityTask.getBaseTask().getAbilityId(), coroutinePriorityTask.getBaseTask().getPkgName(), coroutinePriorityTask.getBaseTask().getMethod(), coroutinePriorityTask.getBaseTask().getMethod(), coroutinePriorityTask.getBaseTask().getParams(), null, coroutinePriorityTask.getTimeoutMs(), coroutinePriorityTask.getBaseTask().getTraceId(), coroutinePriorityTask.getBaseTask().getToolCallId(), null, AbilityType.UNKNOWN, null, 2592, null);
            g gVar = new g(coroutinePriorityTask, 14);
            this.f3220a = 1;
            Object objCall = callTool.call(callToolRequest, gVar, this);
            return objCall == coroutineSingletons ? coroutineSingletons : objCall;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RuntimeManager$launchTask$job$1$result$1(CoroutinePriorityTask coroutinePriorityTask, H7.c cVar) {
        super(2, cVar);
        this.b = coroutinePriorityTask;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new RuntimeManager$launchTask$job$1$result$1(this.b, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((RuntimeManager$launchTask$job$1$result$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f3219a;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            return obj;
        }
        kotlin.b.b(obj);
        d dVar = AbstractC1691I.f5315a;
        u9.c cVar = u9.c.f6743a;
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.b, null);
        this.f3219a = 1;
        Object objW = AbstractC1683A.w(cVar, anonymousClass1, this);
        return objW == coroutineSingletons ? coroutineSingletons : objW;
    }
}
