package com.obric.event.task.nlp.intent;

import com.obric.agent.omnimodel.IOmniModelService;
import com.obric.aiagent.applog.IAppLog;
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.SystemAutoActionParams;
import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.ConditionTaskAction;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.ShortcutTask;
import com.obric.eventkit.task.model.ShortcutTaskAction;
import com.obric.eventkit.task.model.TaskKnowledge;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import org.json.JSONObject;

/* JADX INFO: compiled from: EventTaskIntentUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f33039a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f33040b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f33041c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f33042d = null;

    private a() {
    }

    static {
        f33039a = new a();
        f33040b = "old_eca_id";
        f33041c = "event_task_data";
        f33042d = "o_event_task";
    }

    public final String a() {
        return f33040b;
    }

    public final String b() {
        return f33041c;
    }

    public final String c() {
        return f33042d;
    }

    public final IntentResult<Empty> a(int r14, String r15) {
        o.e(r15, "errMsg");
        IntentResult<Empty> r13 = new IntentResult(r14, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_NO_CONNECTION, null);
        r13.setRet(r14);
        r13.setDetails(r15);
        return r13;
    }

    public final IntentResult<Empty> a(String r14) {
        o.e(r14, "msg");
        IntentResult<Empty> r13 = new IntentResult(0, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_NO_CONNECTION, null);
        r13.setRet(0);
        r13.setDetails(r14);
        return r13;
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
        IOmniModelService.c r5 = IOmniModelService.Companion.a().getEntryByDisplayModel(r3.e());
        r3.d(IOmniModelService.Companion.a().toExtValue(r5));
        return r3;
    L21:
        if (ZeusTransformUtils.instanceOf(r0.getParams(), SystemAutoActionParams.class) == false) goto L23;
        IntentParams r6 = r0.getParams();
        o.a(r6, "null cannot be cast to non-null type com.obric.capabilitykit.common.intent.SystemAutoActionParams");
        r3.b(((SystemAutoActionParams) ZeusTransformUtils.preCheckCast(r6, SystemAutoActionParams.class, "com.obric.aiagent.plugin")).getInstruction());
        goto L23
    L11:
        if (r4 != 3) goto L23;
        ShortcutTask r7 = (ShortcutTask) ZeusTransformUtils.preCheckCast(r25, ShortcutTask.class, "com.obric.aiagent.plugin");
        r3.c(r7.getShortInstruct());
        ShortcutTaskAction r8 = (ShortcutTaskAction) ZeusTransformUtils.preCheckCast(p.l(r7.getActions()), ShortcutTaskAction.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L23;
        if (ZeusTransformUtils.instanceOf(r8.getParams(), SystemAutoActionParams.class) == false) goto L23;
        IntentParams r9 = r8.getParams();
        o.a(r9, "null cannot be cast to non-null type com.obric.capabilitykit.common.intent.SystemAutoActionParams");
        r3.b(((SystemAutoActionParams) ZeusTransformUtils.preCheckCast(r9, SystemAutoActionParams.class, "com.obric.aiagent.plugin")).getInstruction());
        goto L23
    }

    public static /* synthetic */ void a(a r0, String r1, int r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = "obric_create_task_from_query";
    L5:
        r0.a(r1, r2, r3, r4);
    }

    public final void a(String r3, int r4, String r5, String r6) {
        o.e(r3, "step");
        o.e(r5, "errMsg");
        o.e(r6, "eventName");
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L7
        r1.put("step", r3);     // Catch: Exception -> L7
        r1.put(MonitorConstants.CODE, r4);     // Catch: Exception -> L7
        r1.put("errMsg", r5);     // Catch: Exception -> L7
        IAppLog r2 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L7
        if (r2 == null) goto L10;
        r2.reportToFlow(r6, r1);     // Catch: Exception -> L7
        return;
    L10:
        return;
    }

    public final void a(String r9, String r10, int r11, String r12) {
        o.e(r10, "step");
        o.e(r12, "errMsg");
        a(this, r10, r11, r12, null, 8, null);
        com.obric.event.task.nlp.c.a.f33013a.a(r9, r10, r11, r12);
    }
}
