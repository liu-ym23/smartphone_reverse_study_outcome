package com.obric.autoaction.app.launcherpage.detail.base.container;

import com.obric.capabilitykit.common.intent.IntentParams;
import com.obric.capabilitykit.common.intent.SystemAutoActionParams;
import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.ConditionTaskAction;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.ShortcutTask;
import com.obric.eventkit.task.model.ShortcutTaskAction;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DetailModelExtraViewContainer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o {
    public static final /* synthetic */ String a(EventTask r0) {
        return b(r0);
    }

    private static final String b(EventTask r4) {
        String r2 = null;
        if (ZeusTransformUtils.instanceOf(r4, ShortcutTask.class) == false) goto L18;
        ShortcutTaskAction r5 = (ShortcutTaskAction) ZeusTransformUtils.preCheckCast(d.a.p.l(((ShortcutTask) ZeusTransformUtils.preCheckCast(r4, ShortcutTask.class, "com.obric.aiagent.plugin")).getActions()), ShortcutTaskAction.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L7;
        IntentParams r6 = r5.getParams();
    L9:
        if (ZeusTransformUtils.instanceOf(r6, SystemAutoActionParams.class) == false) goto L11;
        SystemAutoActionParams r7 = (SystemAutoActionParams) ZeusTransformUtils.preCheckCast(r6, SystemAutoActionParams.class, "com.obric.aiagent.plugin");
    L12:
        if (r7 == null) goto L14;
        r2 = r7.getInstruction();
    L14:
        if (r2 != null) goto L30;
        return "";
    L30:
        return r2;
    L11:
        r7 = null;
        goto L12
    L7:
        r6 = null;
        goto L9
    L18:
        if (ZeusTransformUtils.instanceOf(r4, ConditionTask.class) == false) goto L31;
        ConditionTaskAction r8 = (ConditionTaskAction) ZeusTransformUtils.preCheckCast(d.a.p.l(((ConditionTask) ZeusTransformUtils.preCheckCast(r4, ConditionTask.class, "com.obric.aiagent.plugin")).getActions()), ConditionTaskAction.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L22;
        IntentParams r9 = r8.getParams();
    L24:
        if (ZeusTransformUtils.instanceOf(r9, SystemAutoActionParams.class) == false) goto L26;
        SystemAutoActionParams r10 = (SystemAutoActionParams) ZeusTransformUtils.preCheckCast(r9, SystemAutoActionParams.class, "com.obric.aiagent.plugin");
    L27:
        if (r10 == null) goto L29;
        r2 = r10.getInstruction();
    L29:
        if (r2 != null) goto L30;
        return "";
    L26:
        r10 = null;
        goto L27
    L22:
        r9 = null;
        goto L24
    L31:
        return "";
    }
}
