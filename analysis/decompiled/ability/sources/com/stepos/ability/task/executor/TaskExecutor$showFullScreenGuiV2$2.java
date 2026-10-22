package com.stepos.ability.task.executor;

import C7.r;
import S7.n;
import android.os.Bundle;
import com.stepos.ability.api.task.executor.ITaskExecutor;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@J7.c(c = "com.stepos.ability.task.executor.TaskExecutor$showFullScreenGuiV2$2", f = "TaskExecutor.kt", l = {167}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class TaskExecutor$showFullScreenGuiV2$2 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f3290a;
    public final /* synthetic */ f b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Bundle d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskExecutor$showFullScreenGuiV2$2(f fVar, String str, Bundle bundle, H7.c cVar) {
        super(2, cVar);
        this.b = fVar;
        this.c = str;
        this.d = bundle;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new TaskExecutor$showFullScreenGuiV2$2(this.b, this.c, this.d, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((TaskExecutor$showFullScreenGuiV2$2) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f3290a;
        if (i == 0) {
            kotlin.b.b(obj);
            ITaskExecutor iTaskExecutorB = this.b.b(1);
            if (iTaskExecutorB != null) {
                this.f3290a = 1;
                if (iTaskExecutorB.showFullScreenGuiV2(this.c, this.d, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                P3.c.f1086a.invoke(5, "Ability_".concat("TaskExecutor"), "showFullScreenGuiV2: GUI executor missing", null);
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
