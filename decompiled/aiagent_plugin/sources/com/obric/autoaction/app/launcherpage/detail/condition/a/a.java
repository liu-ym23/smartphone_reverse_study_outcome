package com.obric.autoaction.app.launcherpage.detail.condition.a;

import android.text.Spannable;
import com.obric.agent.omnimodel.IOmniModelService;
import com.obric.autoaction.app.launcherpage.discovery.util.b;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.obric.capabilitykit.common.intent.SystemAutoActionParams;
import com.obric.eventkit.task.model.ConditionGroup;
import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.ConditionTaskAction;
import com.obric.eventkit.task.model.ConditionTaskSpec;
import com.obric.eventkit.task.model.PeriodicPolicy;
import com.obric.eventkit.task.model.TaskKnowledge;
import com.obric.eventkit.task.model.TriggerControlPolicy;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ConverterUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static /* synthetic */ String a(ConditionTask r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        return a(r0, r1);
    }

    public static final String a(ConditionTask r3, String r4) {
        o.e(r3, "<this>");
        ConditionTaskAction r5 = (ConditionTaskAction) ZeusTransformUtils.preCheckCast(p.l(r3.getActions()), ConditionTaskAction.class, "com.obric.aiagent.plugin");
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
        return b.a(b.f23658a, r8, null, 2, null).a().toString();
    L21:
        return b.a(b.f23658a, r8, null, 2, null).a().toString();
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

    public static final Spannable b(ConditionTask r3, String r4) {
        o.e(r3, "<this>");
        ConditionTaskAction r5 = (ConditionTaskAction) ZeusTransformUtils.preCheckCast(p.l(r3.getActions()), ConditionTaskAction.class, "com.obric.aiagent.plugin");
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
        return b.a(b.f23658a, r8, null, 2, null).a();
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

    public static /* synthetic */ ConditionTaskSpec a(ConditionTask r0, Integer r1, PeriodicPolicy r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return a(r0, r1, r2);
    }

    public static final ConditionTaskSpec a(ConditionTask r16, Integer r17, PeriodicPolicy r18) {
        o.e(r16, "<this>");
        Loog.INSTANCE.d("ConverterUtils", "toConditionTaskSpec(draft), enableStatus: " + r17);
        String r4 = r16.getName();
        Integer r5 = Integer.valueOf(r16.getTaskMode());
        TaskKnowledge r6 = r16.getTaskKnowledge();
        String r7 = r16.getTemplateId();
        String r8 = r16.getOmniModel();
        Integer r9 = r16.getTaskStatus();
        Map<String, String> r11 = r16.getExt();
        List<ConditionTaskAction> r12 = r16.getActions();
        ConditionGroup r13 = r16.getConditions();
        if (r18 != null) goto L5;
        PeriodicPolicy r14 = r16.getPeriodicPolicy();
    L7:
        return new ConditionTaskSpec(r4, r5, r6, r7, r8, r9, r17, r11, r12, r13, r14, r16.getTriggerControlPolicy());
    L5:
        r14 = r18;
        goto L7
    }

    public static /* synthetic */ ConditionTask a(ConditionTask r0, String r1, ConditionGroup r2, PeriodicPolicy r3, TriggerControlPolicy r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.getConditions();
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.getPeriodicPolicy();
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.getTriggerControlPolicy();
    L15:
        return a(r0, r1, r2, r3, r4);
    }

    public static final ConditionTask a(ConditionTask r27, String r28, ConditionGroup r29, PeriodicPolicy r30, TriggerControlPolicy r31) {
        o.e(r27, "<this>");
        o.e(r29, "conditions");
        o.e(r30, "periodicPolicy");
        if (r28 == null) goto L5;
        List<ConditionTaskAction> r0 = p.a(new ConditionTaskAction("System_AutoAction", (IntentParams) ZeusTransformUtils.preCheckCast(new SystemAutoActionParams(r28, null, null, null, null, null, null, null, 254, null), IntentParams.class, "com.obric.aiagent.plugin")));
    L6:
        ConditionTask r1 = ConditionTask.copy$default(r27, null, null, null, null, null, null, r0, r29, r30, r31, 0, DownloadErrorCode.ERROR_DOWNLOAD_INFO_NULL, null);
        r1.setTaskMode(r27.getTaskMode());
        r1.setTaskKnowledge(r27.getTaskKnowledge());
        r1.setTemplateId(r27.getTemplateId());
        r1.setOmniModel(r27.getOmniModel());
        return r1;
    L5:
        r0 = r27.getActions();
        goto L6
    }

    public static final String a(ConditionTaskSpec r3) {
        o.e(r3, "<this>");
        List<ConditionTaskAction> r4 = r3.getActions();
        String r1 = null;
        if (r4 == null) goto L7;
        ConditionTaskAction r5 = (ConditionTaskAction) ZeusTransformUtils.preCheckCast(p.l(r4), ConditionTaskAction.class, "com.obric.aiagent.plugin");
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

    public static final ConditionTask a(String r34, ConditionTask r35) {
        o.e(r34, DownloadConstants.QUERY_KEY);
        if (r35 == null) goto L5;
        String r13 = r35.getId();
    L6:
        if (r35 == null) goto L8;
        String r14 = r35.getName();
    L9:
        if (r35 == null) goto L11;
        Integer r15 = r35.getTaskStatus();
    L12:
        if (r35 == null) goto L14;
        Integer r16 = r35.getEnableStatus();
    L15:
        if (r35 == null) goto L17;
        Long r17 = r35.getCreateTime();
    L18:
        if (r35 == null) goto L20;
        Map<String, String> r18 = r35.getExt();
    L21:
        Integer r19 = r15;
        List r8 = p.a(new ConditionTaskAction("System_AutoAction", (IntentParams) ZeusTransformUtils.preCheckCast(new SystemAutoActionParams(r34, null, null, null, null, null, null, null, 254, null), IntentParams.class, "com.obric.aiagent.plugin")));
        if (r35 == null) goto L25;
        ConditionGroup r1 = r35.getConditions();
        if (r1 == null) goto L25;
    L26:
        ConditionGroup r9 = r1;
        if (r35 == null) goto L30;
        PeriodicPolicy r2 = r35.getPeriodicPolicy();
        if (r2 == null) goto L30;
    L31:
        PeriodicPolicy r10 = r2;
        if (r35 == null) goto L35;
        TriggerControlPolicy r3 = r35.getTriggerControlPolicy();
        if (r3 == null) goto L35;
    L36:
        String r4 = r13;
        String r5 = r14;
        Integer r6 = r16;
        Long r7 = r17;
        Map<String, String> r11 = r18;
        ConditionTask r0 = new ConditionTask(r4, r5, r19, r6, r7, r11, r8, r9, r10, r3, 0, 1024, null);
        if (r35 == null) goto L39;
        int r12 = r35.getTaskMode();
    L40:
        r0.setTaskMode(r12);
        if (r35 == null) goto L44;
        String r20 = r35.getOmniModel();
        if (r20 == null) goto L44;
    L45:
        r0.setOmniModel(r20);
        if (r35 == null) goto L48;
        r0.setTaskKnowledge(r35.getTaskKnowledge());
        r0.setTemplateId(r35.getTemplateId());
    L48:
        return r0;
    L44:
        r20 = IOmniModelService.Companion.a().eventTaskDefaultDisplayModel();
        goto L45
    L39:
        r12 = 1;
    L35:
        r3 = new TriggerControlPolicy(null, null, 3, null);
    L30:
        r2 = new PeriodicPolicy(true, null, 0, null, false, false, null, false, null, 510, null);
    L25:
        r1 = new ConditionGroup("or", new ArrayList());
        goto L26
    L20:
        r18 = null;
        goto L21
    L17:
        r17 = null;
        goto L18
    L14:
        r16 = null;
        goto L15
    L11:
        r15 = null;
        goto L12
    L8:
        r14 = null;
        goto L9
    L5:
        r13 = null;
        goto L6
    }
}
