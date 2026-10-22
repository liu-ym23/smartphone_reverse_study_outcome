package com.bytedance.android.livesdk.widget.schedule.v2;

import android.os.Handler;
import com.bytedance.android.live.core.tetris.task.TaskState;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public abstract class AbsLiveWidgetLoadTaskScheduler implements rv2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f162109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f162110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f162111c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f162112d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f162113e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f162114f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public DataCenter f162115g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f162116h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f162117i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f162118j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final a f162119k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f162120l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final a f162121m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f162122n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final a f162123o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f162124p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final a f162125q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final com.bytedance.android.livesdk.widget.schedule.e f162126r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final com.bytedance.android.livesdk.widget.schedule.f f162127s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final com.bytedance.android.livesdk.widget.schedule.g f162128t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final com.bytedance.android.livesdk.widget.schedule.v2.b f162129u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final h80.d<c> f162130v;

    public final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function2<IRoom, Boolean, Unit> f162131a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AbsLiveWidgetLoadTaskScheduler f162132b;

        @Override // java.lang.Runnable
        public final void run() {
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        L16:
            return;
        L3:
            if (this.f162132b.f162129u.S8() == false) goto L11;
            AbsLiveWidgetLoadTaskScheduler r100 = this.f162132b;     // Catch: Throwable -> L8
            if ((!r100.f162114f) == false) goto L15;
            c r101 = r100.f162130v.get();     // Catch: Throwable -> L8
            this.f162131a.invoke(r101.f162134a, Boolean.valueOf(r101.f162135b));     // Catch: Throwable -> L8
            return;
        L15:
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(AbsLiveWidgetLoadTaskScheduler r100, Function2<? super IRoom, ? super Boolean, Unit> r101) {
            Intrinsics.checkNotNullParameter(r101, "action");
            this.f162132b = r100;
            this.f162131a = r101;
        }
    }

    public static final class b implements y70.b<com.bytedance.android.live.core.tetris.task.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ rv2.d f162133a;

        public b(rv2.d r100) {
            this.f162133a = r100;
        }

        @Override // y70.b
        public final void a(y70.a r100) {
            Intrinsics.checkNotNullParameter((com.bytedance.android.live.core.tetris.task.a) r100, "task");
        }

        @Override // y70.b
        public final void b(y70.a r100) {
            Intrinsics.checkNotNullParameter((com.bytedance.android.live.core.tetris.task.a) r100, "task");
            this.f162133a.a();
        }

        @Override // y70.b
        public final void c(y70.a r100) {
            Intrinsics.checkNotNullParameter((com.bytedance.android.live.core.tetris.task.a) r100, "task");
        }

        @Override // y70.b
        public final void d(y70.a r100) {
            Intrinsics.checkNotNullParameter((com.bytedance.android.live.core.tetris.task.a) r100, "task");
            this.f162133a.b();
        }
    }

    @Override // rv2.a
    public void E() {
    }

    @Override // rv2.a
    public void F() {
        this.f162113e = true;
    }

    @Override // rv2.a
    public void G() {
    }

    @Override // rv2.a
    public void I() {
        if (this.f162129u.S8() == true) goto L5;
        return;
    L5:
        if ((!this.f162114f) == false) goto L13;
        c r100 = this.f162130v.get();
        boolean r101 = r100.f162135b;
        this.f162110b = r101;
        if (r101 == false) goto L12;
        this.f162129u.pr(r100.f162134a);
        this.f162111c = true;
        return;
    L12:
        return;
    }

    @Override // rv2.a
    public void K() {
        if (this.f162129u.S8() == true) goto L5;
        return;
    L5:
        if ((!this.f162114f) == false) goto L13;
        c r100 = this.f162130v.get();
        if (this.f162110b == true) goto L10;
        this.f162129u.pr(r100.f162134a);
    L10:
        this.f162111c = true;
        return;
    }

    @Override // rv2.a
    public void M() {
        if (this.f162129u.S8() == true) goto L5;
        return;
    L5:
        if ((!this.f162114f) == false) goto L10;
        this.f162129u.pr(this.f162130v.get().f162134a);
        this.f162111c = true;
        return;
    }

    @Override // rv2.a
    public void onDestroy() {
        if (this.f162114f == false) goto L5;
        return;
    L5:
        this.f162114f = true;
        this.f162115g = null;
        ((Handler) this.f162109a.getValue()).removeCallbacksAndMessages(null);
        i0.k(c50.b.b(this.f162115g), this.f162117i);
        i0.k(c50.b.b(this.f162115g), this.f162119k);
        i0.k(c50.b.b(this.f162115g), this.f162121m);
        i0.k(c50.b.b(this.f162115g), this.f162123o);
        i0.k(c50.b.b(this.f162115g), this.f162125q);
    }

    @Override // rv2.a
    public final void N(DataCenter r100) {
        this.f162115g = r100;
    }

    public AbsLiveWidgetLoadTaskScheduler(com.bytedance.android.livesdk.widget.schedule.v2.b r100, h80.d<c> r101) {
        Intrinsics.checkNotNullParameter(r100, "widgetLoadStep");
        Intrinsics.checkNotNullParameter(r101, "interactionRoomSupplier");
        this.f162129u = r100;
        this.f162130v = r101;
        this.f162109a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, AbsLiveWidgetLoadTaskScheduler$sHandler$2.INSTANCE);
        this.f162110b = true;
        this.f162117i = new a(this, new AbsLiveWidgetLoadTaskScheduler$startLoadP0Task$1(this));
        this.f162119k = new a(this, new AbsLiveWidgetLoadTaskScheduler$startLoadImmediatelyP1Task$1(this));
        this.f162121m = new a(this, new AbsLiveWidgetLoadTaskScheduler$startLoadP1Task$1(this));
        this.f162123o = new a(this, new AbsLiveWidgetLoadTaskScheduler$startLoadP2Task$1(this));
        this.f162125q = new a(this, new AbsLiveWidgetLoadTaskScheduler$startLoadOtherTask$1(this));
        this.f162126r = new com.bytedance.android.livesdk.widget.schedule.e(AbsLiveWidgetLoadTaskScheduler$p0WidgetLoadTaskScheduler$1.INSTANCE);
        this.f162127s = new com.bytedance.android.livesdk.widget.schedule.f(AbsLiveWidgetLoadTaskScheduler$p1WidgetLoadTaskScheduler$1.INSTANCE);
        this.f162128t = new com.bytedance.android.livesdk.widget.schedule.g(AbsLiveWidgetLoadTaskScheduler$p2WidgetLoadTaskScheduler$1.INSTANCE);
    }

    @Override // rv2.a
    public final void H(com.bytedance.android.live.core.tetris.task.a r100, rv2.d r101) {
        Intrinsics.checkNotNullParameter(r100, "task");
        Intrinsics.checkNotNullParameter(r101, "widgetVisibilityControl");
        c(this.f162127s, r100, r101);
    }

    @Override // rv2.a
    public final void J(com.bytedance.android.live.core.tetris.task.a r100, rv2.d r101) {
        Intrinsics.checkNotNullParameter(r100, "task");
        Intrinsics.checkNotNullParameter(r101, "widgetVisibilityControl");
        c(this.f162128t, r100, r101);
    }

    @Override // rv2.a
    public final void L(com.bytedance.android.live.core.tetris.task.a r100, rv2.d r101) {
        Intrinsics.checkNotNullParameter(r100, "task");
        Intrinsics.checkNotNullParameter(r101, "widgetVisibilityControl");
        c(this.f162126r, r100, r101);
    }

    public final void c(com.bytedance.android.livesdk.widget.schedule.a r100, com.bytedance.android.live.core.tetris.task.a r101, rv2.d r102) {
        if ((!this.f162114f) == true) goto L5;
        return;
    L5:
        r101.a(new b(r102));
        StateMachine<TaskState.d, TaskState.a, TaskState.c> r103 = r101.f65922a.f65902d;
        TaskState.a.b r104 = TaskState.a.b.f65904a;
        StateMachine.a r105 = StateMachine.f66079c;
        r103.d(r104, null);
        r101.b(true);
    }
}
