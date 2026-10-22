package com.stepos.taskrobot.taskmemory;

import C7.r;
import J7.c;
import S7.n;
import android.util.Log;
import com.stepos.taskrobot.taskmemory.entity.TaskEntity;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import m9.C1718k;
import m9.InterfaceC1733z;
import s6.C1915b;

@c(c = "com.stepos.taskrobot.taskmemory.AppTaskDatabaseManager$insertTask$4$1", f = "AppTaskDatabaseManager.kt", l = {}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class AppTaskDatabaseManager$insertTask$4$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskEntity f4057a;
    public final /* synthetic */ AppTaskDatabase b;
    public final /* synthetic */ C1718k c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppTaskDatabaseManager$insertTask$4$1(TaskEntity taskEntity, AppTaskDatabase appTaskDatabase, C1718k c1718k, H7.c cVar) {
        super(2, cVar);
        this.f4057a = taskEntity;
        this.b = appTaskDatabase;
        this.c = c1718k;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new AppTaskDatabaseManager$insertTask$4$1(this.f4057a, this.b, this.c, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        AppTaskDatabaseManager$insertTask$4$1 appTaskDatabaseManager$insertTask$4$1 = (AppTaskDatabaseManager$insertTask$4$1) create((InterfaceC1733z) obj, (H7.c) obj2);
        r rVar = r.f317a;
        appTaskDatabaseManager$insertTask$4$1.invokeSuspend(rVar);
        return rVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        kotlin.b.b(obj);
        TaskEntity taskEntity = this.f4057a;
        String taskId = taskEntity.b;
        long j5 = taskEntity.c;
        String taskName = taskEntity.d;
        String taskDesc = taskEntity.e;
        String str = taskEntity.f;
        String str2 = taskEntity.g;
        long j6 = taskEntity.h;
        Long l = taskEntity.i;
        Long l5 = taskEntity.f4066j;
        String str3 = taskEntity.k;
        k.f(taskId, "taskId");
        k.f(taskName, "taskName");
        k.f(taskDesc, "taskDesc");
        long jInsert = this.b.taskDao().insert(new TaskEntity(0L, taskId, j5, taskName, taskDesc, str, str2, j6, l, l5, str3));
        a aVar = a.f4061a;
        Log.d("AppTaskDatabaseManager", "insertTask " + jInsert);
        C1718k c1718k = this.c;
        if (c1718k.isActive()) {
            c1718k.e(C1915b.f5988a, new Long(jInsert));
        }
        return r.f317a;
    }
}
