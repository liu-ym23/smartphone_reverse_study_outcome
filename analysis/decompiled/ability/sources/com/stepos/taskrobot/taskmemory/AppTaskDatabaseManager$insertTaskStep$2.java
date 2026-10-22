package com.stepos.taskrobot.taskmemory;

import C7.r;
import J7.c;
import S7.n;
import android.app.Application;
import android.util.Log;
import com.stepos.taskrobot.taskmemory.entity.TaskStepEntity;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import m9.InterfaceC1733z;
import s6.C1914a;

@c(c = "com.stepos.taskrobot.taskmemory.AppTaskDatabaseManager$insertTaskStep$2", f = "AppTaskDatabaseManager.kt", l = {}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "", "<anonymous>", "(Lm9/z;)J"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class AppTaskDatabaseManager$insertTaskStep$2 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskStepEntity f4059a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppTaskDatabaseManager$insertTaskStep$2(TaskStepEntity taskStepEntity, H7.c cVar) {
        super(2, cVar);
        this.f4059a = taskStepEntity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new AppTaskDatabaseManager$insertTaskStep$2(this.f4059a, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((AppTaskDatabaseManager$insertTaskStep$2) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        kotlin.b.b(obj);
        C1914a c1914a = AppTaskDatabase.Companion;
        Application application = S0.b.p;
        k.c(application);
        AppTaskDatabase appTaskDatabaseB = c1914a.b(application);
        TaskStepEntity taskStepEntity = this.f4059a;
        String actionId = taskStepEntity.b;
        String taskId = taskStepEntity.c;
        String actionType = taskStepEntity.d;
        String str = taskStepEntity.e;
        String str2 = taskStepEntity.f;
        String str3 = taskStepEntity.g;
        String str4 = taskStepEntity.h;
        String str5 = taskStepEntity.i;
        String str6 = taskStepEntity.f4068j;
        int i = taskStepEntity.k;
        long j5 = taskStepEntity.l;
        Long l = taskStepEntity.m;
        String str7 = taskStepEntity.n;
        long j6 = taskStepEntity.o;
        long j10 = taskStepEntity.p;
        String str8 = taskStepEntity.f4069q;
        k.f(actionId, "actionId");
        k.f(taskId, "taskId");
        k.f(actionType, "actionType");
        long jInsert = appTaskDatabaseB.taskStepDao().insert(new TaskStepEntity(0L, actionId, taskId, actionType, str, str2, str3, str4, str5, str6, i, j5, l, str7, j6, j10, str8));
        a aVar = a.f4061a;
        Log.d("AppTaskDatabaseManager", "insertTaskStep 成功: " + jInsert);
        taskStepEntity.f4067a = jInsert;
        return new Long(jInsert);
    }
}
