package com.bytedance.android.live.core.tetris.task;

import com.bytedance.android.live.core.utils.StateMachine;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements y70.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TaskState<c> f65925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, a> f65926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f65927c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f65928d;

    @Override // y70.a
    public final boolean isComplete() {
        return this.f65925a.b();
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator<Map.Entry<String, a>> r100 = this.f65926b.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        Map.Entry<String, a> r101 = r100.next();
        r101.getValue().a(this.f65927c);
        StateMachine<TaskState.d, TaskState.a, TaskState.c> r102 = r101.getValue().f65922a.f65902d;
        TaskState.a.b r103 = TaskState.a.b.f65904a;
        StateMachine.a r104 = StateMachine.f66079c;
        r102.d(r103, null);
        goto L4
    }

    @Override // y70.a
    public final String getId() {
        return this.f65928d;
    }

    public static final void a(c r100) {
        HashMap<String, a> r101 = r100.f65926b;
        if (r101.isEmpty() == true) goto L11;
        Iterator<Map.Entry<String, a>> r102 = r101.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        if (r102.next().getValue().isComplete() == true) goto L7;
        boolean r103 = false;
    L12:
        if (r103 == false) goto L18;
        StateMachine<TaskState.d, TaskState.a, TaskState.c> r104 = r100.f65925a.f65902d;
        TaskState.a.c r105 = TaskState.a.c.f65905a;
        StateMachine.a r106 = StateMachine.f66079c;
        r104.d(r105, null);
        return;
    L18:
        return;
    L11:
        r103 = true;
        goto L12
    }

    public c(String r100, com.bytedance.android.livesdk.widget.schedule.a.b r101) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "taskStateListener");
        this.f65928d = r100;
        TaskState<c> r102 = new TaskState();
        this.f65925a = r102;
        Intrinsics.checkNotNullParameter(this, "task");
        Intrinsics.checkNotNullParameter(r101, "taskStateListener");
        r102.f65899a = this;
        TaskState.b r103 = new TaskState.b(r101);
        r102.f65900b = r103;
        r103.d(this);
        this.f65926b = new HashMap();
        this.f65927c = new b(this);
    }
}
