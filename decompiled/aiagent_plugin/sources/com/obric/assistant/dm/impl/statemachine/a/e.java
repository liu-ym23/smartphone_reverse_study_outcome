package com.obric.assistant.dm.impl.statemachine.a;

import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.assistant.dm.api.statemachine.core.DMEvent;
import com.obric.assistant.dm.api.statemachine.core.SimpleTaskEvent;
import com.obric.assistant.dm.api.statemachine.core.SimpleTaskState;
import com.obric.assistant.dm.api.statemachine.core.State;
import com.obric.assistant.dm.api.statemachine.core.TaskId;
import com.obric.assistant.dm.api.statemachine.core.TaskInfo;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.g;
import d.h.a.m;
import d.h.b.h;
import d.o;
import d.x;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.bs;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: SimpleTaskStateMachine.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends com.obric.assistant.dm.api.statemachine.core.d<SimpleTaskState, SimpleTaskEvent> {
    private static final String TAG = "SimpleTaskStateMachine";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f22559b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ca f22560c;

    /* JADX INFO: compiled from: SimpleTaskStateMachine.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: SimpleTaskStateMachine.kt */
    @f(b = "SimpleTaskStateMachine.kt", c = {134}, d = "invokeSuspend", e = "com.obric.assistant.dm.impl.statemachine.core.SimpleTaskStateMachine$startTimeout$1")
    static final class b extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f22561a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f22562b;

        b(e r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22562b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f22562b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f22561a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L11:
            this.f22562b.e();
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            long r3 = com.obric.assistant.dm.api.statemachine.core.a.f22459a.c();
            d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22561a = 1;
            if (ax.a(r3, r7) != r0) goto L11;
            return r0;
        }
    }

    static {
        f22559b = new a(null);
    }

    public static /* synthetic */ SimpleTaskState lambda$WamWd5ltJiCOumhZ_flKC5m6mWg(SimpleTaskState r0, SimpleTaskEvent r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ SimpleTaskState lambda$yDGrQws9wggAOWfCnczk1KM5Tws(SimpleTaskState r0, SimpleTaskEvent r1) {
        return b(r0, r1);
    }

    @Override // com.obric.assistant.dm.api.statemachine.core.d
    public /* synthetic */ boolean a(DMEvent r3) {
        return a((SimpleTaskEvent) ZeusTransformUtils.preCheckCast(r3, SimpleTaskEvent.class, "com.obric.aiagent.plugin"));
    }

    public e(TaskId r9, String r10, TaskInfo r11) {
        d.h.b.o.e(r9, DBDefinition.TASK_ID);
        d.h.b.o.e(r10, "name");
        d.h.b.o.e(r11, "taskInfo");
        super((State) ZeusTransformUtils.preCheckCast(new SimpleTaskState.Idle(r9, r11, 0, null, 12, null), State.class, "com.obric.aiagent.plugin"), r10);
        f();
    }

    private final void f() {
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(SimpleTaskState.Idle.class, SimpleTaskState.Processing.class, SimpleTaskEvent.StartTask.class, $$Lambda$e$WamWd5ltJiCOumhZ_flKC5m6mWg.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(SimpleTaskState.Processing.class, SimpleTaskState.Idle.class, SimpleTaskEvent.TaskCompleted.class, $$Lambda$e$yDGrQws9wggAOWfCnczk1KM5Tws.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
    }

    private static final SimpleTaskState a(SimpleTaskState r10, SimpleTaskEvent r11) {
        d.h.b.o.e(r10, "currentState");
        d.h.b.o.e(r11, "event");
        return (SimpleTaskState) ZeusTransformUtils.preCheckCast(new SimpleTaskState.Processing(((SimpleTaskEvent.StartTask) ZeusTransformUtils.preCheckCast(r11, SimpleTaskEvent.StartTask.class, "com.obric.aiagent.plugin")).getTaskId(), r10.getTaskInfo(), 0, ao.a(r10.getExtra(), ((SimpleTaskEvent.StartTask) ZeusTransformUtils.preCheckCast(r11, SimpleTaskEvent.StartTask.class, "com.obric.aiagent.plugin")).getExtra()), 4, null), SimpleTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final SimpleTaskState b(SimpleTaskState r8, SimpleTaskEvent r9) {
        d.h.b.o.e(r8, "currentState");
        d.h.b.o.e(r9, "event");
        return (SimpleTaskState) ZeusTransformUtils.preCheckCast(new SimpleTaskState.Idle(r8.getTaskId(), r8.getTaskInfo(), 0, ao.a(r8.getExtra(), r9.getExtra()), 4, null), SimpleTaskState.class, "com.obric.aiagent.plugin");
    }

    public final boolean a(TaskId r6, TaskInfo r7) {
        d.h.b.o.e(r6, DBDefinition.TASK_ID);
        d.h.b.o.e(r7, "taskInfo");
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        IMMessage r1 = r7.getMessage();
        if (r1 == null) goto L14;
        Map<String, String> r2 = r1.getExt();
        if (r2 == null) goto L14;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.get("o_event_task"), String.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L14;
        com.obric.eventkit.task.model.a r4 = (com.obric.eventkit.task.model.a) ZeusTransformUtils.preCheckCast(com.obric.capabilitykit.common.a.a().fromJson(r3, com.obric.eventkit.task.model.a.class), com.obric.eventkit.task.model.a.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L11;
        Integer r5 = r4.g();
    L12:
        r0.put("o_task_src", String.valueOf(r5));
        goto L14
    L11:
        r5 = null;
    L14:
        return a((SimpleTaskEvent) ZeusTransformUtils.preCheckCast(new SimpleTaskEvent.StartTask(r6, r7, r0), SimpleTaskEvent.class, "com.obric.aiagent.plugin"));
    }

    public final boolean a(TaskId r4) {
        d.h.b.o.e(r4, DBDefinition.TASK_ID);
        return a((SimpleTaskEvent) ZeusTransformUtils.preCheckCast(new SimpleTaskEvent.TaskCompleted(r4, null, 2, null), SimpleTaskEvent.class, "com.obric.aiagent.plugin"));
    }

    public final TaskId c() {
        return ((SimpleTaskState) ZeusTransformUtils.preCheckCast(a(), SimpleTaskState.class, "com.obric.aiagent.plugin")).getTaskId();
    }

    public final boolean d() {
        return ((SimpleTaskState) ZeusTransformUtils.preCheckCast(a(), SimpleTaskState.class, "com.obric.aiagent.plugin")).isCompletedOrCanceled();
    }

    public boolean a(SimpleTaskEvent r4) {
        d.h.b.o.e(r4, "event");
        boolean r5 = super.a((DMEvent) ZeusTransformUtils.preCheckCast(r4, DMEvent.class, "com.obric.aiagent.plugin"));
        ca r0 = this.f22560c;
        if (r0 == null) goto L6;
        ca.a.a(r0, null, 1, null);
    L6:
        if (d() == true) goto L8;
        g();
    L8:
        return r5;
    }

    private final void g() {
        ca r0 = this.f22560c;
        if (r0 == null) goto L5;
        ca.a.a(r0, null, 1, null);
    L5:
        this.f22560c = i.a((am) ZeusTransformUtils.preCheckCast(bs.f39169a, am.class, "com.obric.aiagent.plugin"), (g) ZeusTransformUtils.preCheckCast(bd.b(), g.class, "com.obric.aiagent.plugin"), null, (m) ZeusTransformUtils.preCheckCast(new b(this, null), m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    public final void e() {
        TaskId r0 = c();
        if (r0 == null) goto L6;
        a(r0);
        return;
    }
}
