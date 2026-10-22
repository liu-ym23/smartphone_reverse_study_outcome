package com.bytedance.android.livesdk.widget.schedule;

import com.bytedance.android.live.core.tetris.task.TaskState;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements rv2.a {

    public static final class a implements y70.b<com.bytedance.android.live.core.tetris.task.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ rv2.d f162093a;

        public a(rv2.d r100) {
            this.f162093a = r100;
        }

        @Override // y70.b
        public final void a(y70.a r100) {
            Intrinsics.checkNotNullParameter((com.bytedance.android.live.core.tetris.task.a) r100, "task");
        }

        @Override // y70.b
        public final void b(y70.a r100) {
            Intrinsics.checkNotNullParameter((com.bytedance.android.live.core.tetris.task.a) r100, "task");
            this.f162093a.a();
        }

        @Override // y70.b
        public final void c(y70.a r100) {
            Intrinsics.checkNotNullParameter((com.bytedance.android.live.core.tetris.task.a) r100, "task");
        }

        @Override // y70.b
        public final void d(y70.a r100) {
            Intrinsics.checkNotNullParameter((com.bytedance.android.live.core.tetris.task.a) r100, "task");
            this.f162093a.b();
        }
    }

    public b() {
    }

    @Override // rv2.a
    public final void E() {
    }

    @Override // rv2.a
    public final void F() {
    }

    @Override // rv2.a
    public final void G() {
    }

    @Override // rv2.a
    public final void I() {
    }

    @Override // rv2.a
    public final void K() {
    }

    @Override // rv2.a
    public final void M() {
    }

    @Override // rv2.a
    public final void N(DataCenter r100) {
    }

    @Override // rv2.a
    public final void onDestroy() {
    }

    @Override // rv2.a
    public final void x() {
    }

    public static void a(com.bytedance.android.live.core.tetris.task.a r100, rv2.d r101) {
        com.bytedance.android.live.core.tetris.widgets.d.g("direct run task " + r100.f65923b + ' ');
        r100.a(new a(r101));
        StateMachine<TaskState.d, TaskState.a, TaskState.c> r102 = r100.f65922a.f65902d;
        TaskState.a.b r103 = TaskState.a.b.f65904a;
        StateMachine.a r104 = StateMachine.f66079c;
        r102.d(r103, null);
        r100.b(true);
    }

    @Override // rv2.a
    public final void H(com.bytedance.android.live.core.tetris.task.a r100, rv2.d r101) {
        Intrinsics.checkNotNullParameter(r100, "task");
        Intrinsics.checkNotNullParameter(r101, "widgetVisibilityControl");
        a(r100, r101);
    }

    @Override // rv2.a
    public final void J(com.bytedance.android.live.core.tetris.task.a r100, rv2.d r101) {
        Intrinsics.checkNotNullParameter(r100, "task");
        Intrinsics.checkNotNullParameter(r101, "widgetVisibilityControl");
        a(r100, r101);
    }

    @Override // rv2.a
    public final void L(com.bytedance.android.live.core.tetris.task.a r100, rv2.d r101) {
        Intrinsics.checkNotNullParameter(r100, "task");
        Intrinsics.checkNotNullParameter(r101, "widgetVisibilityControl");
        a(r100, r101);
    }
}
