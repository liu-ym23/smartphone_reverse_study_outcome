package com.stepos.ability.runtime;

import C7.r;
import J7.c;
import S7.n;
import com.stepos.ability.api.ability.monitor.IMonitor;
import com.stepos.ability.beaninternal.ability.FunctionCallResult;
import com.stepos.ability.beaninternal.ability.IAbilityExecuteCallback;
import com.stepos.ability.runtime.model.CoroutinePriorityTask;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import m9.InterfaceC1733z;

@c(c = "com.stepos.ability.runtime.RuntimeManager$launchTask$job$1", f = "RuntimeManager.kt", l = {210, 237}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class RuntimeManager$launchTask$job$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f3217a;
    public final /* synthetic */ CoroutinePriorityTask b;
    public final /* synthetic */ b c;

    @c(c = "com.stepos.ability.runtime.RuntimeManager$launchTask$job$1$1", f = "RuntimeManager.kt", l = {}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.ability.runtime.RuntimeManager$launchTask$job$1$1, reason: invalid class name */
    final class AnonymousClass1 extends SuspendLambda implements n {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FunctionCallResult f3218a;
        public final /* synthetic */ CoroutinePriorityTask b;
        public final /* synthetic */ String c;
        public final /* synthetic */ b d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(FunctionCallResult functionCallResult, CoroutinePriorityTask coroutinePriorityTask, String str, b bVar, H7.c cVar) {
            super(2, cVar);
            this.f3218a = functionCallResult;
            this.b = coroutinePriorityTask;
            this.c = str;
            this.d = bVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c create(Object obj, H7.c cVar) {
            return new AnonymousClass1(this.f3218a, this.b, this.c, this.d, cVar);
        }

        @Override // S7.n
        public final Object invoke(Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = (AnonymousClass1) create((InterfaceC1733z) obj, (H7.c) obj2);
            r rVar = r.f317a;
            anonymousClass1.invokeSuspend(rVar);
            return rVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            kotlin.b.b(obj);
            FunctionCallResult functionCallResult = this.f3218a;
            boolean success = functionCallResult.getSuccess();
            CoroutinePriorityTask coroutinePriorityTask = this.b;
            if (success) {
                IAbilityExecuteCallback callback = coroutinePriorityTask.getBaseTask().getCallback();
                if (callback != null) {
                    callback.onSuccess(coroutinePriorityTask.getBaseTask().getTaskCode(), this.c, coroutinePriorityTask.getBaseTask().getExtra());
                }
            } else {
                IAbilityExecuteCallback callback2 = coroutinePriorityTask.getBaseTask().getCallback();
                if (callback2 != null) {
                    String taskCode = coroutinePriorityTask.getBaseTask().getTaskCode();
                    String extra = coroutinePriorityTask.getBaseTask().getExtra();
                    String strValueOf = String.valueOf(functionCallResult.getErrorCode());
                    String errorMsg = functionCallResult.getErrorMsg();
                    if (errorMsg == null) {
                        errorMsg = "Error";
                    }
                    callback2.onFailure(taskCode, extra, this.c, strValueOf, errorMsg);
                }
            }
            coroutinePriorityTask.getOnFinish().invoke();
            IMonitor iMonitor = this.d.c;
            if (iMonitor != null) {
                iMonitor.onTaskResult(coroutinePriorityTask.getBaseTask().getAbilityId(), coroutinePriorityTask.getBaseTask().getPkgName(), coroutinePriorityTask.getBaseTask().getMethod(), coroutinePriorityTask.getBaseTask().getTaskCode(), coroutinePriorityTask.getBaseTask().getCallerContext(), coroutinePriorityTask.getCreateTime(), System.currentTimeMillis() - coroutinePriorityTask.getCreateTime(), "succeeded", null);
                return r.f317a;
            }
            k.n("monitor");
            throw null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RuntimeManager$launchTask$job$1(CoroutinePriorityTask coroutinePriorityTask, b bVar, H7.c cVar) {
        super(2, cVar);
        this.b = coroutinePriorityTask;
        this.c = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new RuntimeManager$launchTask$job$1(this.b, this.c, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((RuntimeManager$launchTask$job$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x006b, code lost:
    
        if (m9.AbstractC1683A.w(r12, r5, r11) == r0) goto L29;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 285
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.runtime.RuntimeManager$launchTask$job$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
