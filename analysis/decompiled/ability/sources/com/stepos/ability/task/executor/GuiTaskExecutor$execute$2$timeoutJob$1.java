package com.stepos.ability.task.executor;

import C7.r;
import S7.n;
import android.os.RemoteException;
import androidx.core.app.NotificationCompat;
import com.stepos.taskrobot.common.ITaskRobotManger;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import m9.InterfaceC1733z;

@J7.c(c = "com.stepos.ability.task.executor.GuiTaskExecutor$execute$2$timeoutJob$1", f = "GuiTaskExecutor.kt", l = {93}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class GuiTaskExecutor$execute$2$timeoutJob$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f3279a;
    public final /* synthetic */ String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuiTaskExecutor$execute$2$timeoutJob$1(String str, H7.c cVar) {
        super(2, cVar);
        this.b = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new GuiTaskExecutor$execute$2$timeoutJob$1(this.b, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((GuiTaskExecutor$execute$2$timeoutJob$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws RemoteException {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f3279a;
        if (i == 0) {
            kotlin.b.b(obj);
            this.f3279a = 1;
            if (kotlinx.coroutines.a.f(1200000L, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
        }
        P3.c.f1086a.invoke(5, "Ability_".concat("GuiTaskExecutor"), androidx.constraintlayout.core.dsl.a.h("execute: timeout after 1200000 ms, calling stopTask for taskId=", this.b, NotificationCompat.CATEGORY_MESSAGE), null);
        String taskId = this.b;
        k.f(taskId, "taskId");
        ITaskRobotManger iTaskRobotManger = e.f3313j;
        if (iTaskRobotManger != null) {
            iTaskRobotManger.stopTask(taskId);
        }
        return r.f317a;
    }
}
