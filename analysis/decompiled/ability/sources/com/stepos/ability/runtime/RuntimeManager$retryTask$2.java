package com.stepos.ability.runtime;

import C7.r;
import J7.c;
import S7.n;
import android.util.Log;
import com.stepos.ability.beaninternal.ability.IAbilityExecuteCallback;
import com.stepos.ability.runtime.model.CoroutinePriorityTask;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;
import stepai.android.llm.base.twoway.FlowType;

@c(c = "com.stepos.ability.runtime.RuntimeManager$retryTask$2", f = "RuntimeManager.kt", l = {}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class RuntimeManager$retryTask$2 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CoroutinePriorityTask f3223a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RuntimeManager$retryTask$2(CoroutinePriorityTask coroutinePriorityTask, H7.c cVar) {
        super(2, cVar);
        this.f3223a = coroutinePriorityTask;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new RuntimeManager$retryTask$2(this.f3223a, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        RuntimeManager$retryTask$2 runtimeManager$retryTask$2 = (RuntimeManager$retryTask$2) create((InterfaceC1733z) obj, (H7.c) obj2);
        r rVar = r.f317a;
        runtimeManager$retryTask$2.invokeSuspend(rVar);
        return rVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutinePriorityTask coroutinePriorityTask = this.f3223a;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        kotlin.b.b(obj);
        try {
            IAbilityExecuteCallback callback = coroutinePriorityTask.getBaseTask().getCallback();
            if (callback != null) {
                callback.onFailure(coroutinePriorityTask.getBaseTask().getTaskCode(), coroutinePriorityTask.getBaseTask().getExtra(), null, "Failed", "Task failed after max retries.");
            }
        } catch (Exception e) {
            Log.e("RuntimeManager", "Callback failed. " + e.getMessage(), e);
        }
        coroutinePriorityTask.getMonitor().onTaskResult(coroutinePriorityTask.getBaseTask().getAbilityId(), coroutinePriorityTask.getBaseTask().getPkgName(), coroutinePriorityTask.getBaseTask().getMethod(), coroutinePriorityTask.getBaseTask().getTaskCode(), coroutinePriorityTask.getBaseTask().getCallerContext(), coroutinePriorityTask.getCreateTime(), System.currentTimeMillis() - coroutinePriorityTask.getCreateTime(), FlowType.FAILED, "Task failed after max retries.");
        coroutinePriorityTask.getOnFinish().invoke();
        return r.f317a;
    }
}
