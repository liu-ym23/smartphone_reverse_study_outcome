package com.bytedance.android.live.core.tetris.task;

import com.bytedance.android.live.core.utils.StateMachine;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public abstract class a implements y70.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TaskState<a> f65922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f65923b;

    @Override // y70.a
    public final boolean isComplete() {
        return this.f65922a.b();
    }

    @Override // y70.a
    public final String getId() {
        return this.f65923b;
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        this.f65923b = r100;
        this.f65922a = new TaskState();
    }

    public final void a(y70.b<a> r100) {
        Intrinsics.checkNotNullParameter(r100, "taskStateListener");
        TaskState<a> r101 = this.f65922a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(this, "task");
        Intrinsics.checkNotNullParameter(r100, "taskStateListener");
        r101.f65899a = this;
        TaskState.b r102 = new TaskState.b(r100);
        r101.f65900b = r102;
        r102.d(this);
    }

    public final void b(boolean r100) {
        TaskState<a> r101 = this.f65922a;
        if (r100 == false) goto L5;
        StateMachine<TaskState.d, TaskState.a, TaskState.c> r102 = r101.f65902d;
        TaskState.a.c r103 = TaskState.a.c.f65905a;
        StateMachine.a r104 = StateMachine.f66079c;
        r102.d(r103, null);
        return;
    L5:
        StateMachine<TaskState.d, TaskState.a, TaskState.c> r105 = r101.f65902d;
        TaskState.a.C1087a r106 = TaskState.a.C1087a.f65903a;
        StateMachine.a r107 = StateMachine.f66079c;
        r105.d(r106, null);
    }
}
