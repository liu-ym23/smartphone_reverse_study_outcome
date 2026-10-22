package com.obric.assistant.dm.impl.statemachine.a;

import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.assistant.dm.api.statemachine.core.DMEvent;
import com.obric.assistant.dm.api.statemachine.core.OAutoTaskEvent;
import com.obric.assistant.dm.api.statemachine.core.OAutoTaskState;
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

/* JADX INFO: compiled from: OAutoTaskStateMachine.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends com.obric.assistant.dm.api.statemachine.core.d<OAutoTaskState, OAutoTaskEvent> {
    private static final String TAG = "OAutoTaskStateMachine";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f22555b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ca f22556c;

    /* JADX INFO: compiled from: OAutoTaskStateMachine.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OAutoTaskStateMachine.kt */
    @f(b = "OAutoTaskStateMachine.kt", c = {183}, d = "invokeSuspend", e = "com.obric.assistant.dm.impl.statemachine.core.OAutoTaskStateMachine$startTimeout$1")
    static final class b extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f22557a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f22558b;

        b(d r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22558b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f22558b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f22557a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L11:
            this.f22558b.d();
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            long r3 = com.obric.assistant.dm.api.statemachine.core.a.f22459a.b();
            d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22557a = 1;
            if (ax.a(r3, r7) != r0) goto L11;
            return r0;
        }
    }

    static {
        f22555b = new a(null);
    }

    public static /* synthetic */ OAutoTaskState lambda$CUZWZmV1FJzSsWZAG0ZEyJkDN0Y(OAutoTaskState r0, OAutoTaskEvent r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$KfAurXwushsu0NUdHDj9_RQ-B_M, reason: not valid java name */
    public static /* synthetic */ OAutoTaskState m425lambda$KfAurXwushsu0NUdHDj9_RQB_M(OAutoTaskState r0, OAutoTaskEvent r1) {
        return f(r0, r1);
    }

    public static /* synthetic */ OAutoTaskState lambda$LEUbdnuwpRhKTfopkkCqeRklpn8(OAutoTaskState r0, OAutoTaskEvent r1) {
        return c(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$MxJ1skjZV5ht8AN0-qGsrhAu7lo, reason: not valid java name */
    public static /* synthetic */ OAutoTaskState m426lambda$MxJ1skjZV5ht8AN0qGsrhAu7lo(OAutoTaskState r0, OAutoTaskEvent r1) {
        return d(r0, r1);
    }

    public static /* synthetic */ OAutoTaskState lambda$RmRpzYcXztcFL6Jej9UZSxWAc4U(OAutoTaskState r0, OAutoTaskEvent r1) {
        return g(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$YEcS8oloWRo-f364Gr10sOpTXd4, reason: not valid java name */
    public static /* synthetic */ OAutoTaskState m427lambda$YEcS8oloWRof364Gr10sOpTXd4(OAutoTaskState r0, OAutoTaskEvent r1) {
        return e(r0, r1);
    }

    public static /* synthetic */ OAutoTaskState lambda$vaT_D451DtUV89bMPdRxY3EOUKU(OAutoTaskState r0, OAutoTaskEvent r1) {
        return b(r0, r1);
    }

    @Override // com.obric.assistant.dm.api.statemachine.core.d
    public /* synthetic */ boolean a(DMEvent r3) {
        return a((OAutoTaskEvent) ZeusTransformUtils.preCheckCast(r3, OAutoTaskEvent.class, "com.obric.aiagent.plugin"));
    }

    public d(TaskId r9, String r10, TaskInfo r11) {
        d.h.b.o.e(r9, DBDefinition.TASK_ID);
        d.h.b.o.e(r10, "name");
        d.h.b.o.e(r11, "taskInfo");
        super((State) ZeusTransformUtils.preCheckCast(new OAutoTaskState.Idle(r9, r11, 0, null, 12, null), State.class, "com.obric.aiagent.plugin"), r10);
        f();
    }

    private final void f() {
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(OAutoTaskState.Idle.class, OAutoTaskState.Processing.class, OAutoTaskEvent.StartTask.class, $$Lambda$d$CUZWZmV1FJzSsWZAG0ZEyJkDN0Y.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(OAutoTaskState.Processing.class, OAutoTaskState.Clarify.class, OAutoTaskEvent.TriggerOAutoClarify.class, $$Lambda$d$vaT_D451DtUV89bMPdRxY3EOUKU.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(OAutoTaskState.Clarify.class, OAutoTaskState.Processing.class, OAutoTaskEvent.ReceiveOAutoClarify.class, $$Lambda$d$LEUbdnuwpRhKTfopkkCqeRklpn8.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(OAutoTaskState.Processing.class, OAutoTaskState.Idle.class, OAutoTaskEvent.TaskCompleted.class, $$Lambda$d$MxJ1skjZV5ht8AN0qGsrhAu7lo.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(OAutoTaskState.Clarify.class, OAutoTaskState.Idle.class, OAutoTaskEvent.TaskCompleted.class, $$Lambda$d$YEcS8oloWRof364Gr10sOpTXd4.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(OAutoTaskState.Clarify.class, OAutoTaskState.Idle.class, OAutoTaskEvent.TaskForceCompleted.class, $$Lambda$d$KfAurXwushsu0NUdHDj9_RQB_M.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(OAutoTaskState.Processing.class, OAutoTaskState.Idle.class, OAutoTaskEvent.TaskForceCompleted.class, $$Lambda$d$RmRpzYcXztcFL6Jej9UZSxWAc4U.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
    }

    private static final OAutoTaskState a(OAutoTaskState r10, OAutoTaskEvent r11) {
        d.h.b.o.e(r10, "currentState");
        d.h.b.o.e(r11, "event");
        return (OAutoTaskState) ZeusTransformUtils.preCheckCast(new OAutoTaskState.Processing(((OAutoTaskEvent.StartTask) ZeusTransformUtils.preCheckCast(r11, OAutoTaskEvent.StartTask.class, "com.obric.aiagent.plugin")).getTaskId(), r10.getTaskInfo(), 0, ao.a(r10.getExtra(), ((OAutoTaskEvent.StartTask) ZeusTransformUtils.preCheckCast(r11, OAutoTaskEvent.StartTask.class, "com.obric.aiagent.plugin")).getExtra()), 4, null), OAutoTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final OAutoTaskState b(OAutoTaskState r9, OAutoTaskEvent r10) {
        d.h.b.o.e(r9, "currentState");
        d.h.b.o.e(r10, "event");
        OAutoTaskEvent.TriggerOAutoClarify r0 = (OAutoTaskEvent.TriggerOAutoClarify) ZeusTransformUtils.preCheckCast(r10, OAutoTaskEvent.TriggerOAutoClarify.class, "com.obric.aiagent.plugin");
        OAutoTaskState.Processing r1 = (OAutoTaskState.Processing) ZeusTransformUtils.preCheckCast(r9, OAutoTaskState.Processing.class, "com.obric.aiagent.plugin");
        return (OAutoTaskState) ZeusTransformUtils.preCheckCast(new OAutoTaskState.Clarify(((OAutoTaskState.Processing) ZeusTransformUtils.preCheckCast(r9, OAutoTaskState.Processing.class, "com.obric.aiagent.plugin")).getTaskId(), ((OAutoTaskState.Processing) ZeusTransformUtils.preCheckCast(r9, OAutoTaskState.Processing.class, "com.obric.aiagent.plugin")).getTaskInfo(), 0, ao.a(((OAutoTaskState.Processing) ZeusTransformUtils.preCheckCast(r9, OAutoTaskState.Processing.class, "com.obric.aiagent.plugin")).getExtra(), ((OAutoTaskEvent.TriggerOAutoClarify) ZeusTransformUtils.preCheckCast(r10, OAutoTaskEvent.TriggerOAutoClarify.class, "com.obric.aiagent.plugin")).getExtra()), 4, null), OAutoTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final OAutoTaskState c(OAutoTaskState r9, OAutoTaskEvent r10) {
        d.h.b.o.e(r9, "currentState");
        d.h.b.o.e(r10, "event");
        OAutoTaskEvent.ReceiveOAutoClarify r0 = (OAutoTaskEvent.ReceiveOAutoClarify) ZeusTransformUtils.preCheckCast(r10, OAutoTaskEvent.ReceiveOAutoClarify.class, "com.obric.aiagent.plugin");
        OAutoTaskState.Clarify r1 = (OAutoTaskState.Clarify) ZeusTransformUtils.preCheckCast(r9, OAutoTaskState.Clarify.class, "com.obric.aiagent.plugin");
        return (OAutoTaskState) ZeusTransformUtils.preCheckCast(new OAutoTaskState.Processing(((OAutoTaskState.Clarify) ZeusTransformUtils.preCheckCast(r9, OAutoTaskState.Clarify.class, "com.obric.aiagent.plugin")).getTaskId(), ((OAutoTaskState.Clarify) ZeusTransformUtils.preCheckCast(r9, OAutoTaskState.Clarify.class, "com.obric.aiagent.plugin")).getTaskInfo(), 0, ao.a(((OAutoTaskState.Clarify) ZeusTransformUtils.preCheckCast(r9, OAutoTaskState.Clarify.class, "com.obric.aiagent.plugin")).getExtra(), ((OAutoTaskEvent.ReceiveOAutoClarify) ZeusTransformUtils.preCheckCast(r10, OAutoTaskEvent.ReceiveOAutoClarify.class, "com.obric.aiagent.plugin")).getExtra()), 4, null), OAutoTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final OAutoTaskState d(OAutoTaskState r9, OAutoTaskEvent r10) {
        d.h.b.o.e(r9, "currentState");
        d.h.b.o.e(r10, "event");
        OAutoTaskEvent.TaskCompleted r0 = (OAutoTaskEvent.TaskCompleted) ZeusTransformUtils.preCheckCast(r10, OAutoTaskEvent.TaskCompleted.class, "com.obric.aiagent.plugin");
        OAutoTaskState.Processing r1 = (OAutoTaskState.Processing) ZeusTransformUtils.preCheckCast(r9, OAutoTaskState.Processing.class, "com.obric.aiagent.plugin");
        return (OAutoTaskState) ZeusTransformUtils.preCheckCast(new OAutoTaskState.Idle(((OAutoTaskState.Processing) ZeusTransformUtils.preCheckCast(r9, OAutoTaskState.Processing.class, "com.obric.aiagent.plugin")).getTaskId(), ((OAutoTaskState.Processing) ZeusTransformUtils.preCheckCast(r9, OAutoTaskState.Processing.class, "com.obric.aiagent.plugin")).getTaskInfo(), 0, ao.a(((OAutoTaskState.Processing) ZeusTransformUtils.preCheckCast(r9, OAutoTaskState.Processing.class, "com.obric.aiagent.plugin")).getExtra(), ((OAutoTaskEvent.TaskCompleted) ZeusTransformUtils.preCheckCast(r10, OAutoTaskEvent.TaskCompleted.class, "com.obric.aiagent.plugin")).getExtra()), 4, null), OAutoTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final OAutoTaskState e(OAutoTaskState r9, OAutoTaskEvent r10) {
        d.h.b.o.e(r9, "currentState");
        d.h.b.o.e(r10, "event");
        OAutoTaskEvent.TaskCompleted r0 = (OAutoTaskEvent.TaskCompleted) ZeusTransformUtils.preCheckCast(r10, OAutoTaskEvent.TaskCompleted.class, "com.obric.aiagent.plugin");
        return (OAutoTaskState) ZeusTransformUtils.preCheckCast(new OAutoTaskState.Idle(r9.getTaskId(), r9.getTaskInfo(), 0, ao.a(r9.getExtra(), ((OAutoTaskEvent.TaskCompleted) ZeusTransformUtils.preCheckCast(r10, OAutoTaskEvent.TaskCompleted.class, "com.obric.aiagent.plugin")).getExtra()), 4, null), OAutoTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final OAutoTaskState f(OAutoTaskState r9, OAutoTaskEvent r10) {
        d.h.b.o.e(r9, "currentState");
        d.h.b.o.e(r10, "event");
        OAutoTaskEvent.TaskForceCompleted r0 = (OAutoTaskEvent.TaskForceCompleted) ZeusTransformUtils.preCheckCast(r10, OAutoTaskEvent.TaskForceCompleted.class, "com.obric.aiagent.plugin");
        return (OAutoTaskState) ZeusTransformUtils.preCheckCast(new OAutoTaskState.Idle(r9.getTaskId(), r9.getTaskInfo(), 0, ao.a(r9.getExtra(), ((OAutoTaskEvent.TaskForceCompleted) ZeusTransformUtils.preCheckCast(r10, OAutoTaskEvent.TaskForceCompleted.class, "com.obric.aiagent.plugin")).getExtra()), 4, null), OAutoTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final OAutoTaskState g(OAutoTaskState r9, OAutoTaskEvent r10) {
        d.h.b.o.e(r9, "currentState");
        d.h.b.o.e(r10, "event");
        OAutoTaskEvent.TaskForceCompleted r0 = (OAutoTaskEvent.TaskForceCompleted) ZeusTransformUtils.preCheckCast(r10, OAutoTaskEvent.TaskForceCompleted.class, "com.obric.aiagent.plugin");
        return (OAutoTaskState) ZeusTransformUtils.preCheckCast(new OAutoTaskState.Idle(r9.getTaskId(), r9.getTaskInfo(), 0, ao.a(r9.getExtra(), ((OAutoTaskEvent.TaskForceCompleted) ZeusTransformUtils.preCheckCast(r10, OAutoTaskEvent.TaskForceCompleted.class, "com.obric.aiagent.plugin")).getExtra()), 4, null), OAutoTaskState.class, "com.obric.aiagent.plugin");
    }

    public boolean a(OAutoTaskEvent r4) {
        d.h.b.o.e(r4, "event");
        boolean r5 = super.a((DMEvent) ZeusTransformUtils.preCheckCast(r4, DMEvent.class, "com.obric.aiagent.plugin"));
        ca r0 = this.f22556c;
        if (r0 == null) goto L6;
        ca.a.a(r0, null, 1, null);
    L6:
        if (e() == true) goto L8;
        g();
    L8:
        return r5;
    }

    private final void g() {
        ca r0 = this.f22556c;
        if (r0 == null) goto L5;
        ca.a.a(r0, null, 1, null);
    L5:
        this.f22556c = i.a((am) ZeusTransformUtils.preCheckCast(bs.f39169a, am.class, "com.obric.aiagent.plugin"), (g) ZeusTransformUtils.preCheckCast(bd.b(), g.class, "com.obric.aiagent.plugin"), null, (m) ZeusTransformUtils.preCheckCast(new b(this, null), m.class, "com.obric.aiagent.plugin"), 2, null);
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
        return a((OAutoTaskEvent) ZeusTransformUtils.preCheckCast(new OAutoTaskEvent.StartTask(r6, r7, r0), OAutoTaskEvent.class, "com.obric.aiagent.plugin"));
    }

    public final TaskId c() {
        return ((OAutoTaskState) ZeusTransformUtils.preCheckCast(a(), OAutoTaskState.class, "com.obric.aiagent.plugin")).getTaskId();
    }

    public final void a(TaskId r4) {
        d.h.b.o.e(r4, DBDefinition.TASK_ID);
        a((OAutoTaskEvent) ZeusTransformUtils.preCheckCast(new OAutoTaskEvent.TaskForceCompleted(r4, null, 2, null), OAutoTaskEvent.class, "com.obric.aiagent.plugin"));
    }

    public final void d() {
        TaskId r0 = c();
        if (r0 == null) goto L6;
        a(r0);
        return;
    }

    public final boolean e() {
        return ((OAutoTaskState) ZeusTransformUtils.preCheckCast(a(), OAutoTaskState.class, "com.obric.aiagent.plugin")).isCompletedOrCanceled();
    }
}
