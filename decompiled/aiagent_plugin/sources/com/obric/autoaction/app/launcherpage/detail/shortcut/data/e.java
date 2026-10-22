package com.obric.autoaction.app.launcherpage.detail.shortcut.data;

import android.text.Spannable;
import com.obric.agent.omnimodel.IOmniModelService;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.obric.capabilitykit.common.intent.SystemAutoActionParams;
import com.obric.eventkit.task.model.ShortcutTask;
import com.obric.eventkit.task.model.ShortcutTaskAction;
import com.obric.eventkit.task.model.ShortcutTaskSpec;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: ShortcutConverterUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static /* synthetic */ String a(ShortcutTask r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        return a(r0, r1);
    }

    public static final String a(ShortcutTask r3, String r4) {
        o.e(r3, "<this>");
        ShortcutTaskAction r5 = (ShortcutTaskAction) ZeusTransformUtils.preCheckCast(p.l(r3.getActions()), ShortcutTaskAction.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L5;
        IntentParams r6 = r5.getParams();
    L7:
        if (ZeusTransformUtils.instanceOf(r6, SystemAutoActionParams.class) == false) goto L9;
        SystemAutoActionParams r7 = (SystemAutoActionParams) ZeusTransformUtils.preCheckCast(r6, SystemAutoActionParams.class, "com.obric.aiagent.plugin");
    L10:
        if (r7 == null) goto L12;
        String r8 = r7.getInstruction();
    L13:
        if (r8 != null) goto L16;
        r8 = "";
    L16:
        if (o.a(r4, "enter_from_discovery_add_instruct") == true) goto L21;
        if (r4 == null) goto L20;
        return r8;
    L20:
        return com.obric.autoaction.app.launcherpage.discovery.util.b.a(com.obric.autoaction.app.launcherpage.discovery.util.b.f23658a, r8, null, 2, null).a().toString();
    L21:
        return com.obric.autoaction.app.launcherpage.discovery.util.b.a(com.obric.autoaction.app.launcherpage.discovery.util.b.f23658a, r8, null, 2, null).a().toString();
    L12:
        r8 = null;
        goto L13
    L9:
        r7 = null;
        goto L10
    L5:
        r6 = null;
        goto L7
    }

    public static final Spannable b(ShortcutTask r3, String r4) {
        o.e(r3, "<this>");
        ShortcutTaskAction r5 = (ShortcutTaskAction) ZeusTransformUtils.preCheckCast(p.l(r3.getActions()), ShortcutTaskAction.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L5;
        IntentParams r6 = r5.getParams();
    L7:
        if (ZeusTransformUtils.instanceOf(r6, SystemAutoActionParams.class) == false) goto L9;
        SystemAutoActionParams r7 = (SystemAutoActionParams) ZeusTransformUtils.preCheckCast(r6, SystemAutoActionParams.class, "com.obric.aiagent.plugin");
    L10:
        if (r7 == null) goto L12;
        String r8 = r7.getInstruction();
    L13:
        if (r8 != null) goto L16;
        r8 = "";
    L16:
        if (o.a(r4, "enter_from_discovery_add_instruct") == true) goto L18;
        return null;
    L18:
        return com.obric.autoaction.app.launcherpage.discovery.util.b.a(com.obric.autoaction.app.launcherpage.discovery.util.b.f23658a, r8, null, 2, null).a();
    L12:
        r8 = null;
        goto L13
    L9:
        r7 = null;
        goto L10
    L5:
        r6 = null;
        goto L7
    }

    public static final String a(ShortcutTaskSpec r3) {
        o.e(r3, "<this>");
        List<ShortcutTaskAction> r4 = r3.getActions();
        String r1 = null;
        if (r4 == null) goto L7;
        ShortcutTaskAction r5 = (ShortcutTaskAction) ZeusTransformUtils.preCheckCast(p.l(r4), ShortcutTaskAction.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L7;
        IntentParams r6 = r5.getParams();
    L9:
        if (ZeusTransformUtils.instanceOf(r6, SystemAutoActionParams.class) == false) goto L11;
        SystemAutoActionParams r7 = (SystemAutoActionParams) ZeusTransformUtils.preCheckCast(r6, SystemAutoActionParams.class, "com.obric.aiagent.plugin");
    L12:
        if (r7 == null) goto L14;
        r1 = r7.getInstruction();
    L14:
        if (r1 != null) goto L17;
        return "";
    L17:
        return r1;
    L11:
        r7 = null;
    L7:
        r6 = null;
        goto L9
    }

    public static /* synthetic */ ShortcutTask a(ShortcutTask r0, String r1, String r2, boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.getShortInstruct();
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.isShortInstructEnable();
    L12:
        return a(r0, r1, r2, r3);
    }

    public static final ShortcutTask a(ShortcutTask r14, String r15, String r16, boolean r17) {
        o.e(r14, "<this>");
        if (r15 == null) goto L5;
        List<ShortcutTaskAction> r0 = p.a(new ShortcutTaskAction("System_AutoAction", (IntentParams) ZeusTransformUtils.preCheckCast(new SystemAutoActionParams(r15, null, null, null, null, null, null, null, 254, null), IntentParams.class, "com.obric.aiagent.plugin")));
    L6:
        ShortcutTask r1 = ShortcutTask.copy$default(r14, null, null, null, null, null, null, r16, r17, r0, 63, null);
        r1.setTaskMode(r14.getTaskMode());
        r1.setTaskKnowledge(r14.getTaskKnowledge());
        r1.setTemplateId(r14.getTemplateId());
        r1.setOmniModel(r14.getOmniModel());
        r1.setExt(r14.getExt());
        return r1;
    L5:
        r0 = r14.getActions();
        goto L6
    }

    public static final ShortcutTaskSpec a(ShortcutTask r13) {
        o.e(r13, "<this>");
        return new ShortcutTaskSpec(r13.getName(), Integer.valueOf(r13.getTaskMode()), r13.getTaskKnowledge(), r13.getTemplateId(), r13.getOmniModel(), r13.getTaskStatus(), r13.getEnableStatus(), r13.getExt(), r13.getShortInstruct(), Boolean.valueOf(r13.isShortInstructEnable()), r13.getActions());
    }

    public static /* synthetic */ ShortcutTask a(String r0, int r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L6;
        r1 = 1;
    L6:
        return a(r0, r1);
    }

    public static final ShortcutTask a(String r14, int r15) {
        o.e(r14, "action");
        ShortcutTask r16 = new ShortcutTask(null, null, null, null, null, null, null, false, p.a(new ShortcutTaskAction("System_AutoAction", (IntentParams) ZeusTransformUtils.preCheckCast(new SystemAutoActionParams(r14, null, null, null, null, null, null, null, 254, null), IntentParams.class, "com.obric.aiagent.plugin"))), 32, null);
        r16.setTaskMode(r15);
        r16.setOmniModel(IOmniModelService.Companion.a().eventTaskDefaultDisplayModel());
        return r16;
    }
}
