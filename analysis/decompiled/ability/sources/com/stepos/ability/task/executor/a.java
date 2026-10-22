package com.stepos.ability.task.executor;

import C7.r;
import android.util.Log;
import com.stepos.ability.api.task.executor.ITaskExecutor;
import com.stepos.ability.api.task.listener.ITaskListener;
import com.stepos.ability.bean.InternalTask;
import com.stepos.ability.bean.Task;
import com.stepos.ability.bean.TaskError;
import com.stepos.ability.common.TaskStatus;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.r0;
import s9.C1923c;
import z2.l;

/* loaded from: classes3.dex */
public abstract class a implements ITaskExecutor {

    /* renamed from: a, reason: collision with root package name */
    public final ITaskListener f3309a;
    public final C1923c b;
    public final kotlinx.coroutines.sync.a c;

    public a(ITaskListener taskListener) {
        k.f(taskListener, "taskListener");
        this.f3309a = taskListener;
        r0 r0VarC = AbstractC1683A.c();
        u9.d dVar = AbstractC1691I.f5315a;
        this.b = AbstractC1683A.b(l.H(r0VarC, u9.c.f6743a));
        this.c = new kotlinx.coroutines.sync.a();
    }

    public final void a(TaskStatus status, InternalTask internalTask, TaskError taskError) {
        k.f(status, "status");
        k.f(internalTask, "internalTask");
        Task task = internalTask.getTask();
        task.setStatus(status.f3078a);
        task.setUpdateTime(System.currentTimeMillis());
        if (taskError != null) {
            task.setError(taskError);
        }
        this.f3309a.onTaskEvent(task, true);
    }

    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    public Object cancelFullScreenGUI(Task task, H7.c cVar) {
        Log.d("Ability_", "Base cancelFullScreenGUI " + task);
        return r.f317a;
    }

    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    public Object fullScreenGUI(Task task, H7.c cVar) {
        Log.d("Ability_", "Base fullScreenGUI " + task);
        return r.f317a;
    }

    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    public Object takeOver(Task task, H7.c cVar) {
        Log.d("Ability_", "Base takeOver " + task);
        return r.f317a;
    }

    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    public Object unTakeOver(Task task, H7.c cVar) {
        Log.d("Ability_", "Base unTakeOver " + task);
        return r.f317a;
    }
}
