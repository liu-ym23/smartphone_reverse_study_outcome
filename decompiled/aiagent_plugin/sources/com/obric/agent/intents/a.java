package com.obric.agent.intents;

import com.obric.agent.omnimodel.IOmniModelService;
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.obric.capabilitykit.common.intent.SystemAutoActionParams;
import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.ConditionTaskAction;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.ShortcutTask;
import com.obric.eventkit.task.model.ShortcutTaskAction;
import com.obric.eventkit.task.model.TaskKnowledge;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;

/* JADX INFO: compiled from: EventTaskIntentUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14662a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f14663b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f14664c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f14665d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f14666e = null;
    private static final String f = null;
    private static final String g = null;
    private static final String h = null;
    private static final String i = null;

    private a() {
    }

    static {
        f14662a = new a();
        f14663b = "QueryTaskLog_";
        f14664c = "draft";
        f14665d = "update";
        f14666e = "submit";
        f = "get_info";
        g = "old_eca_id";
        h = "event_task_data";
        i = "o_event_task";
    }

    public final String a() {
        return i;
    }

    public final com.obric.eventkit.task.model.a a(EventTask r25) {
        o.e(r25, "task");
        TaskKnowledge r1 = r25.getTaskKnowledge();
        if (r1 != null) goto L5;
        r1 = new TaskKnowledge(false, null, null, 0, true, null, 32, null);
    L5:
        TaskKnowledge r18 = r1;
        int r12 = r25.getType();
        String r13 = r25.getId();
        Integer r16 = Integer.valueOf(r25.getTaskMode());
        String r2 = r25.getOmniModel();
        if (r2 != null) goto L8;
        r2 = IOmniModelService.Companion.a().defaultDisplayModel();
    L8:
        com.obric.eventkit.task.model.a r3 = new com.obric.eventkit.task.model.a(r12, r13, null, null, r16, r2, r18, null, false, r25.getExt(), ApWakeEvent.OTHER_START, null);
        int r4 = r25.getType();
        if (r4 != 2) goto L11;
        ConditionTaskAction r0 = (ConditionTaskAction) ZeusTransformUtils.preCheckCast(p.l(((ConditionTask) ZeusTransformUtils.preCheckCast(r25, ConditionTask.class, "com.obric.aiagent.plugin")).getActions()), ConditionTaskAction.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L21;
    L23:
        return r3;
    L21:
        if (ZeusTransformUtils.instanceOf(r0.getParams(), SystemAutoActionParams.class) == false) goto L23;
        IntentParams r5 = r0.getParams();
        o.a(r5, "null cannot be cast to non-null type com.obric.capabilitykit.common.intent.SystemAutoActionParams");
        r3.b(((SystemAutoActionParams) ZeusTransformUtils.preCheckCast(r5, SystemAutoActionParams.class, "com.obric.aiagent.plugin")).getInstruction());
        goto L23
    L11:
        if (r4 != 3) goto L23;
        ShortcutTask r6 = (ShortcutTask) ZeusTransformUtils.preCheckCast(r25, ShortcutTask.class, "com.obric.aiagent.plugin");
        r3.c(r6.getShortInstruct());
        ShortcutTaskAction r7 = (ShortcutTaskAction) ZeusTransformUtils.preCheckCast(p.l(r6.getActions()), ShortcutTaskAction.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L23;
        if (ZeusTransformUtils.instanceOf(r7.getParams(), SystemAutoActionParams.class) == false) goto L23;
        IntentParams r8 = r7.getParams();
        o.a(r8, "null cannot be cast to non-null type com.obric.capabilitykit.common.intent.SystemAutoActionParams");
        r3.b(((SystemAutoActionParams) ZeusTransformUtils.preCheckCast(r8, SystemAutoActionParams.class, "com.obric.aiagent.plugin")).getInstruction());
        goto L23
    }
}
