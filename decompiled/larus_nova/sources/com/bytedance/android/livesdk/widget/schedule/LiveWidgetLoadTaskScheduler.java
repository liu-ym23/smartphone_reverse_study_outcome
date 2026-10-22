package com.bytedance.android.livesdk.widget.schedule;

import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.tetris.task.TaskState;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.config.ht0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class LiveWidgetLoadTaskScheduler implements rv2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f162042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f162043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DataCenter f162044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.livesdk.widget.schedule.e f162045d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.livesdk.widget.schedule.f f162046e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g f162047f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d f162048g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final e f162049h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final f f162050i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f162051j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final WidgetLoadState f162052k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final h80.d<com.bytedance.android.livesdk.widget.schedule.d> f162053l;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f162054a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f162055b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f162056c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f162057d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f162058e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f162059f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f162060g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f162061h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f162062i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f162063j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final boolean f162064k;

        public a(boolean r100) {
            this.f162064k = r100;
        }
    }

    public static final class b implements y70.b<com.bytedance.android.live.core.tetris.task.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ rv2.d f162065a;

        public b(rv2.d r100) {
            this.f162065a = r100;
        }

        @Override // y70.b
        public final void a(y70.a r100) {
            Intrinsics.checkNotNullParameter((com.bytedance.android.live.core.tetris.task.a) r100, "task");
        }

        @Override // y70.b
        public final void b(y70.a r100) {
            Intrinsics.checkNotNullParameter((com.bytedance.android.live.core.tetris.task.a) r100, "task");
            this.f162065a.a();
        }

        @Override // y70.b
        public final void c(y70.a r100) {
            Intrinsics.checkNotNullParameter((com.bytedance.android.live.core.tetris.task.a) r100, "task");
        }

        @Override // y70.b
        public final void d(y70.a r100) {
            Intrinsics.checkNotNullParameter((com.bytedance.android.live.core.tetris.task.a) r100, "task");
            this.f162065a.b();
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveWidgetLoadTaskScheduler f162066a;

        public c(LiveWidgetLoadTaskScheduler r100) {
            this.f162066a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a r100 = this.f162066a.f162043b;     // Catch: Throwable -> L7
            if (r100 == null) goto L5;
            r100.f162062i = System.currentTimeMillis();     // Catch: Throwable -> L7
        L5:
            com.bytedance.android.livesdk.widget.schedule.d r101 = this.f162066a.f162053l.get();     // Catch: Throwable -> L7
            this.f162066a.f162052k.a(r101.f162096a);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveWidgetLoadTaskScheduler f162067a;

        public d(LiveWidgetLoadTaskScheduler r100) {
            this.f162067a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a r100 = this.f162067a.f162043b;     // Catch: Throwable -> L7
            if (r100 == null) goto L5;
            r100.f162056c = System.currentTimeMillis();     // Catch: Throwable -> L7
        L5:
            com.bytedance.android.livesdk.widget.schedule.d r101 = this.f162067a.f162053l.get();     // Catch: Throwable -> L7
            this.f162067a.f162052k.b(r101.f162096a, r101.f162097b);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveWidgetLoadTaskScheduler f162068a;

        public e(LiveWidgetLoadTaskScheduler r100) {
            this.f162068a = r100;
        }

        public final void a() {
            a r100 = this.f162068a.f162043b;
            if (r100 == null) goto L5;
            r100.f162058e = System.currentTimeMillis();
        L5:
            com.bytedance.android.livesdk.widget.schedule.d r101 = this.f162068a.f162053l.get();
            this.f162068a.f162052k.c(r101.f162096a);
            i0.j(c50.b.b(this.f162068a.f162044c), this.f162068a.f162050i, 500);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveWidgetLoadTaskScheduler f162069a;

        public f(LiveWidgetLoadTaskScheduler r100) {
            this.f162069a = r100;
        }

        public final void a() {
            WidgetLoadState r100 = this.f162069a.f162052k;
            if (Intrinsics.areEqual(r100.f162071b.b(), WidgetLoadState.c.e.f162084b) == false) goto L5;
        L8:
            boolean r101 = true;
        L9:
            if (r101 == false) goto L11;
            return;
        L11:
            a r102 = this.f162069a.f162043b;
            if (r102 == null) goto L14;
            r102.f162060g = System.currentTimeMillis();
        L14:
            com.bytedance.android.livesdk.widget.schedule.d r103 = this.f162069a.f162053l.get();
            this.f162069a.f162052k.d(r103.f162096a);
            return;
        L5:
            if (Intrinsics.areEqual(r100.f162071b.b(), WidgetLoadState.c.b.f162082b) == true) goto L8;
            r101 = false;
            goto L9
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // rv2.a
    public final void onDestroy() {
        this.f162043b = null;
        i0.k(c50.b.b(this.f162044c), this.f162048g);
        i0.k(c50.b.b(this.f162044c), this.f162049h);
        i0.k(c50.b.b(this.f162044c), this.f162050i);
        i0.k(c50.b.b(this.f162044c), this.f162051j);
        MainThreadPostUtils.d(this.f162045d.f162085a);
        MainThreadPostUtils.d(this.f162046e.f162085a);
        MainThreadPostUtils.d(this.f162047f.f162085a);
        this.f162044c = null;
    }

    @Override // rv2.a
    public final void E() {
        com.bytedance.android.live.core.tetris.widgets.d.g("LiveWidgetLoadTaskScheduler.onP2WidgetLoaded");
        a r100 = this.f162043b;
        if (r100 == null) goto L5;
        r100.f162061h = System.currentTimeMillis();
    L5:
        this.f162047f.b();
        i0.i(c50.b.b(this.f162044c), this.f162051j);
    }

    @Override // rv2.a
    public final void F() {
        com.bytedance.android.live.core.tetris.widgets.d.g("LiveWidgetLoadTaskScheduler.onAllWidgetLoaded");
        a r100 = this.f162043b;
        if (r100 == null) goto L5;
        r100.f162063j = System.currentTimeMillis();
    L5:
        a r101 = this.f162043b;
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.f162064k == false) goto L10;
        long r102 = r101.f162055b - r101.f162054a;
    L11:
        long r103 = r101.f162057d - r101.f162056c;
        long r104 = r101.f162059f - r101.f162058e;
        long r105 = r101.f162061h - r101.f162060g;
        long r110 = r101.f162063j - r101.f162062i;
        com.bytedance.android.live.core.tetris.widgets.d.g("part_continue interval: " + r102 + ", p0WidgetLoadUseTime: " + r103 + ", p1WidgetLoadUseTime: " + r104 + ", p2WidgetLoadUseTime: " + r105 + ", otherWidgetLoadUseTime: " + r110 + ", p0_p1 start load interval: " + (r101.f162058e - r101.f162056c) + ", p1_p2 start load interval: " + (r101.f162060g - r101.f162058e) + ", p2_other start load interval: " + (r101.f162062i - r101.f162060g));
        boolean r111 = com.bytedance.android.live.core.tetris.widgets.d.d();
        boolean r112 = r101.f162064k;
        if (r112 == false) goto L15;
        if (r111 == false) goto L15;
        JSONObject r113 = new JSONObject();
        JSONObject r114 = new JSONObject();
        r114.put("part_continue_interval", r102);
        r114.put("p0_widget_load_use_time", r103);
        r114.put("p1_widget_load_use_time", r104);
        r114.put("p2_widget_load_use_time", r105);
        r114.put("other_widget_load_use_time", r110);
        r114.put("p0_p1_start_load_interval", r101.f162058e - r101.f162056c);
        r114.put("p1_p2_start_load_interval", r101.f162060g - r101.f162058e);
        r114.put("p2_other_start_load_interval", r101.f162062i - r101.f162060g);
        r114.put("total_widget_load_use_time", r101.f162063j - r101.f162056c);
        LiveTracingMonitor.f("ttlive_widget_load_duration_with_priority", LiveTracingMonitor.EventModule.INTERACTION_OPT, r113, r114, new JSONObject());
        return;
    L15:
        if (r112 == false) goto L17;
        JSONObject r106 = new JSONObject();
        JSONObject r107 = new JSONObject();
        r107.put("part_continue_interval", r102);
        r107.put("total_widget_load_use_time", r101.f162063j - r101.f162056c);
        LiveTracingMonitor.f("ttlive_widget_load_duration_with_only_part_show", LiveTracingMonitor.EventModule.INTERACTION_OPT, r106, r107, new JSONObject());
        return;
    L17:
        JSONObject r108 = new JSONObject();
        JSONObject r109 = new JSONObject();
        r109.put("total_widget_load_use_time", r101.f162063j - r101.f162056c);
        LiveTracingMonitor.f("ttlive_widget_load_duration_with_normal", LiveTracingMonitor.EventModule.INTERACTION_OPT, r108, r109, new JSONObject());
        return;
    L10:
        r102 = 0;
        goto L11
    }

    @Override // rv2.a
    public final void G() {
        com.bytedance.android.live.core.tetris.widgets.d.g("LiveWidgetLoadTaskScheduler.onP1WidgetLoaded");
        a r100 = this.f162043b;
        if (r100 == null) goto L5;
        r100.f162059f = System.currentTimeMillis();
    L5:
        this.f162046e.b();
    }

    @Override // rv2.a
    public final void I() {
        com.bytedance.android.live.core.tetris.widgets.d.g("LiveWidgetLoadTaskScheduler.onPartShow");
        a r100 = new a(true);
        this.f162043b = r100;
        r100.f162054a = System.currentTimeMillis();
        if (ht0.f120403a.getValue().getEnablePreRoomEnter() == false) goto L8;
        a r101 = this.f162043b;
        if (r101 == null) goto L7;
        r101.f162056c = System.currentTimeMillis();
    L7:
        com.bytedance.android.livesdk.widget.schedule.d r102 = this.f162053l.get();
        this.f162052k.b(r102.f162096a, r102.f162097b);
        return;
    L8:
        i0.i(c50.b.b(this.f162044c), this.f162048g);
    }

    @Override // rv2.a
    public final void K() {
        com.bytedance.android.live.core.tetris.widgets.d.g("LiveWidgetLoadTaskScheduler.onContinueShow");
        a r100 = this.f162043b;
        if (r100 == null) goto L5;
        r100.f162055b = System.currentTimeMillis();
    L5:
        com.bytedance.android.livesdk.widget.schedule.d r101 = this.f162053l.get();
        if (this.f162042a == false) goto L8;
        com.bytedance.android.live.core.tetris.widgets.d.g("LiveWidgetLoadTaskScheduler.onContinueShow enableWidgetLoadPriority: true");
        i0.i(c50.b.b(this.f162044c), this.f162049h);
        return;
    L8:
        com.bytedance.android.live.core.tetris.widgets.d.g("LiveWidgetLoadTaskScheduler.onContinueShow enableWidgetLoadPriority: false");
        a r102 = this.f162043b;
        if (r102 == null) goto L11;
        long r103 = System.currentTimeMillis();
        r102.f162058e = r103;
        r102.f162060g = r103;
        r102.f162062i = r103;
    L11:
        this.f162052k.c(r101.f162096a);
        this.f162052k.d(r101.f162096a);
        this.f162052k.a(r101.f162096a);
    }

    @Override // rv2.a
    public final void M() {
        com.bytedance.android.live.core.tetris.widgets.d.g("LiveWidgetLoadTaskScheduler.onDirectCompleteShow");
        this.f162043b = new a(false);
        System.currentTimeMillis();
        com.bytedance.android.livesdk.widget.schedule.d r100 = this.f162053l.get();
        a r101 = this.f162043b;
        if (r101 == null) goto L5;
        long r102 = System.currentTimeMillis();
        r101.f162056c = r102;
        r101.f162058e = r102;
        r101.f162060g = r102;
        r101.f162062i = r102;
    L5:
        WidgetLoadState r103 = this.f162052k;
        Room r104 = r100.f162096a;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "room");
        if (i60.c.f488350a.getValue().booleanValue() == false) goto L8;
        String r105 = c50.b.b(r103.f162070a);
        i0.i(r105, new h(r103, r104));
        i0.i(r105, new i(r103, r104));
        i0.i(r105, new j(r103, r104));
        i0.i(r105, new k(r103, r104));
        return;
    L8:
        r103.b(r104, true);
        r103.c(r104);
        r103.d(r104);
        r103.a(r104);
    }

    @Override // rv2.a
    public final void x() {
        com.bytedance.android.live.core.tetris.widgets.d.g("LiveWidgetLoadTaskScheduler.onP0WidgetLoaded");
        a r100 = this.f162043b;
        if (r100 == null) goto L5;
        r100.f162057d = System.currentTimeMillis();
    L5:
        this.f162045d.b();
    }

    @Override // rv2.a
    public final void N(DataCenter r100) {
        this.f162044c = r100;
    }

    public LiveWidgetLoadTaskScheduler(WidgetLoadState r100, h80.d<com.bytedance.android.livesdk.widget.schedule.d> r101) {
        Intrinsics.checkNotNullParameter(r100, "widgetLoadState");
        Intrinsics.checkNotNullParameter(r101, "interactionRoomSupplier");
        this.f162052k = r100;
        this.f162053l = r101;
        this.f162042a = com.bytedance.android.live.core.tetris.widgets.d.d();
        this.f162045d = new com.bytedance.android.livesdk.widget.schedule.e(LiveWidgetLoadTaskScheduler$p0WidgetLoadTaskScheduler$1.INSTANCE);
        this.f162046e = new com.bytedance.android.livesdk.widget.schedule.f(new LiveWidgetLoadTaskScheduler$p1WidgetLoadTaskScheduler$1(this));
        this.f162047f = new g(LiveWidgetLoadTaskScheduler$p2WidgetLoadTaskScheduler$1.INSTANCE);
        this.f162048g = new d(this);
        this.f162049h = new e(this);
        this.f162050i = new f(this);
        this.f162051j = new c(this);
    }

    @Override // rv2.a
    public final void H(com.bytedance.android.live.core.tetris.task.a r100, rv2.d r101) {
        Intrinsics.checkNotNullParameter(r100, "task");
        Intrinsics.checkNotNullParameter(r101, "widgetVisibilityControl");
        a(this.f162046e, r100, r101);
    }

    @Override // rv2.a
    public final void J(com.bytedance.android.live.core.tetris.task.a r100, rv2.d r101) {
        Intrinsics.checkNotNullParameter(r100, "task");
        Intrinsics.checkNotNullParameter(r101, "widgetVisibilityControl");
        a(this.f162047f, r100, r101);
    }

    @Override // rv2.a
    public final void L(com.bytedance.android.live.core.tetris.task.a r100, rv2.d r101) {
        Intrinsics.checkNotNullParameter(r100, "task");
        Intrinsics.checkNotNullParameter(r101, "widgetVisibilityControl");
        a(this.f162045d, r100, r101);
    }

    public final void a(com.bytedance.android.livesdk.widget.schedule.a r100, com.bytedance.android.live.core.tetris.task.a r101, final rv2.d r102) {
        if (this.f162042a == false) goto L16;
        TaskState.d r103 = r100.f162086b.f65925a.f65902d.b();
        TaskState.d.b r104 = TaskState.d.b.f65919a;
        if (Intrinsics.areEqual(r103, r104) == false) goto L16;
        com.bytedance.android.live.core.tetris.widgets.d.g(r100.f162089e + " schedule task " + r101.f65923b + ' ');
        r102.b();
        Function0<Unit> r105 = new LiveWidgetLoadTaskScheduler$scheduleWidgetLoadTask$1(r102);
        Intrinsics.checkNotNullParameter(r101, "task");
        Intrinsics.checkNotNullParameter(r105, "notify");
        Intrinsics.checkNotNullParameter(r101, "task");
        Intrinsics.checkNotNullParameter(r105, "notify");
        rv2.c r106 = new rv2.c(r105);
        Intrinsics.checkNotNullParameter(r101, "task");
        Intrinsics.checkNotNullParameter(r106, "notify");
        if (Intrinsics.areEqual(r100.f162086b.f65925a.f65902d.b(), r104) == false) goto L18;
        r100.f162087c.put(r101, r106);
        com.bytedance.android.live.core.tetris.task.c r107 = r100.f162086b;
        r107.getClass();
        Intrinsics.checkNotNullParameter(r101, "task");
        if (Intrinsics.areEqual(r107.f65925a.f65902d.b(), r104) == false) goto L12;
        r107.f65926b.put(r101.f65923b, r101);
        return;
    L12:
        if (v.a() == true) goto L15;
        return;
    L15:
        throw new IllegalStateException("TaskGroup's state is not idle".toString());
    L18:
        return;
    L16:
        com.bytedance.android.live.core.tetris.widgets.d.g("direct run task " + r101.f65923b + ' ');
        r101.a(new b(r102));
        StateMachine<TaskState.d, TaskState.a, TaskState.c> r108 = r101.f65922a.f65902d;
        TaskState.a.b r109 = TaskState.a.b.f65904a;
        StateMachine.a r110 = StateMachine.f66079c;
        r108.d(r109, null);
        r101.b(true);
    }
}
