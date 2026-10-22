package com.obric.autoaction.app.launcherpage.module.datasource;

import com.obric.autogui.common.api.logging.Loog;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.obric.capabilitykit.common.intent.SystemAutoActionParams;
import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.ConditionTaskAction;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.ShortcutTask;
import com.obric.eventkit.task.model.ShortcutTaskAction;
import com.obric.eventkit.task.model.TimerTaskAction;
import com.obric.eventkit.task.model.TimerTaskV2;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.k;

/* JADX INFO: compiled from: TaskWrapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {
    public static final String a(f r4) {
        o.e(r4, "<this>");
        if (ZeusTransformUtils.instanceOf(r4, f.c.class) == true) goto L31;
        SystemAutoActionParams r3 = null;
        if (ZeusTransformUtils.instanceOf(r4, f.a.class) == false) goto L20;
        ConditionTaskAction r5 = (ConditionTaskAction) ZeusTransformUtils.preCheckCast(p.l(((f.a) ZeusTransformUtils.preCheckCast(r4, f.a.class, "com.obric.aiagent.plugin")).b().getActions()), ConditionTaskAction.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L10;
        IntentParams r6 = r5.getParams();
    L12:
        if (ZeusTransformUtils.instanceOf(r6, SystemAutoActionParams.class) == false) goto L14;
        r3 = (SystemAutoActionParams) ZeusTransformUtils.preCheckCast(r6, SystemAutoActionParams.class, "com.obric.aiagent.plugin");
    L14:
        if (r3 == null) goto L34;
        String r7 = r3.getInstruction();
        if (r7 != null) goto L35;
        return "";
    L35:
        return r7;
    L34:
        return "";
    L10:
        r6 = null;
        goto L12
    L20:
        if (ZeusTransformUtils.instanceOf(r4, f.b.class) == false) goto L33;
        ShortcutTaskAction r8 = (ShortcutTaskAction) ZeusTransformUtils.preCheckCast(p.l(((f.b) ZeusTransformUtils.preCheckCast(r4, f.b.class, "com.obric.aiagent.plugin")).b().getActions()), ShortcutTaskAction.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L24;
        IntentParams r9 = r8.getParams();
    L26:
        if (ZeusTransformUtils.instanceOf(r9, SystemAutoActionParams.class) == false) goto L28;
        r3 = (SystemAutoActionParams) ZeusTransformUtils.preCheckCast(r9, SystemAutoActionParams.class, "com.obric.aiagent.plugin");
    L28:
        if (r3 == null) goto L36;
        r7 = r3.getInstruction();
        if (r7 != null) goto L35;
        return "";
    L36:
        return "";
    L24:
        r9 = null;
        goto L26
    L33:
        throw new k();
    L31:
        return ((TimerTaskAction) ZeusTransformUtils.preCheckCast(com.obric.autoaction.app.launcherpage.utils.d.f24472a.a().fromJson(((f.c) ZeusTransformUtils.preCheckCast(r4, f.c.class, "com.obric.aiagent.plugin")).b().getAction(), TimerTaskAction.class), TimerTaskAction.class, "com.obric.aiagent.plugin")).getQuery();
    }

    public static final f a(EventTask r5) {
        o.e(r5, "<this>");
        int r0 = r5.getType();
        if (r0 == 1) goto L29;
        if (r0 == 2) goto L20;
        if (r0 == 3) goto L11;
        Loog.INSTANCE.e("TaskWrapper", "unknow type of event task");
        return null;
    L11:
        if (ZeusTransformUtils.instanceOf(r5, ShortcutTask.class) == false) goto L13;
        ShortcutTask r6 = (ShortcutTask) ZeusTransformUtils.preCheckCast(r5, ShortcutTask.class, "com.obric.aiagent.plugin");
    L14:
        if (r6 != null) goto L18;
        Loog.INSTANCE.e("TaskWrapper", "shortcut type cast failed ");
        return null;
    L18:
        return (f) ZeusTransformUtils.preCheckCast(new f.b(r6), f.class, "com.obric.aiagent.plugin");
    L13:
        r6 = null;
        goto L14
    L20:
        if (ZeusTransformUtils.instanceOf(r5, ConditionTask.class) == false) goto L22;
        ConditionTask r7 = (ConditionTask) ZeusTransformUtils.preCheckCast(r5, ConditionTask.class, "com.obric.aiagent.plugin");
    L23:
        if (r7 != null) goto L27;
        Loog.INSTANCE.e("TaskWrapper", "condition type cast failed ");
        return null;
    L27:
        return (f) ZeusTransformUtils.preCheckCast(new f.a(r7), f.class, "com.obric.aiagent.plugin");
    L22:
        r7 = null;
        goto L23
    L29:
        if (ZeusTransformUtils.instanceOf(r5, TimerTaskV2.class) == false) goto L31;
        TimerTaskV2 r8 = (TimerTaskV2) ZeusTransformUtils.preCheckCast(r5, TimerTaskV2.class, "com.obric.aiagent.plugin");
    L32:
        if (r8 != null) goto L36;
        Loog.INSTANCE.e("TaskWrapper", "timertask type cast failed ");
        return null;
    L36:
        return (f) ZeusTransformUtils.preCheckCast(new f.c(r8), f.class, "com.obric.aiagent.plugin");
    L31:
        r8 = null;
        goto L32
    }
}
