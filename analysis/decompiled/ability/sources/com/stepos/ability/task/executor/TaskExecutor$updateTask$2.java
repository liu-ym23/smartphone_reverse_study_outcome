package com.stepos.ability.task.executor;

import C7.r;
import S7.n;
import android.os.Bundle;
import com.stepos.ability.api.task.executor.ITaskExecutor;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import m9.InterfaceC1733z;

@J7.c(c = "com.stepos.ability.task.executor.TaskExecutor$updateTask$2", f = "TaskExecutor.kt", l = {69}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class TaskExecutor$updateTask$2 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f3295a;
    public final /* synthetic */ f b;
    public final /* synthetic */ int c;
    public final /* synthetic */ String d;
    public final /* synthetic */ Bundle e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskExecutor$updateTask$2(f fVar, int i, String str, Bundle bundle, H7.c cVar) {
        super(2, cVar);
        this.b = fVar;
        this.c = i;
        this.d = str;
        this.e = bundle;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new TaskExecutor$updateTask$2(this.b, this.c, this.d, this.e, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((TaskExecutor$updateTask$2) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f3295a;
        if (i == 0) {
            kotlin.b.b(obj);
            f fVar = this.b;
            int i6 = this.c;
            ITaskExecutor iTaskExecutorB = fVar.b(i6);
            if (iTaskExecutorB != null) {
                this.f3295a = 1;
                if (iTaskExecutorB.updateTask(this.d, i6, this.e, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                String msg = "updateTask: no executor for taskType=" + i6;
                k.f(msg, "msg");
                P3.c.f1086a.invoke(5, "Ability_".concat("TaskExecutor"), msg, null);
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
