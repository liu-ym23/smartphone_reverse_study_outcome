package com.obric.event.task.nlp;

import com.obric.aiagent.applog.IAppLog;
import com.obric.event.task.nlp.api.INaturalLanguageInstructionCreateApi;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import org.json.JSONObject;

/* JADX INFO: compiled from: NaturalLanguageInstructionCreateApiImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class NaturalLanguageInstructionCreateApiImpl implements INaturalLanguageInstructionCreateApi {
    public static final a Companion = null;
    private static final String EVENT_CREATE_TASK_BY_QUERY = "obric_tech_create_task_by_query";
    private static final int MAX_MSG_LENGTH = 256;
    private static final String TAG = "NaturalLanguageInstructionCreateApiImpl";

    /* JADX INFO: compiled from: NaturalLanguageInstructionCreateApiImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public NaturalLanguageInstructionCreateApiImpl() {
    }

    @Override // com.obric.event.task.nlp.api.INaturalLanguageInstructionCreateApi
    public void onOmniTaskEnd(String r7, int r8, String r9) {
        com.obric.event.task.nlp.c.a.C0902a r1 = com.obric.event.task.nlp.c.a.f33013a.a(r7);
        if (r1 != null) goto L36;
        com.obric.event.task.nlp.a.a.f32889a.b(TAG, "onOmniTaskEnd no records, queryId=" + r7);
        return;
    L36:
        JSONObject r3 = new JSONObject();     // Catch: Exception -> L33
        r3.put("query_id", r7);     // Catch: Exception -> L33
        r3.put(MonitorConstants.CODE, r8);     // Catch: Exception -> L33
        String r5 = "";
        if (r9 != null) goto L10;
        r9 = "";
    L10:
        r3.put("msg", limitMsg(r9));     // Catch: Exception -> L33
        com.obric.event.task.nlp.c.a.b r10 = r1.a();     // Catch: Exception -> L33
        String r4 = null;
        if (r10 == null) goto L13;
        String r11 = r10.a();     // Catch: Exception -> L33
    L14:
        if (r11 != null) goto L16;
        r11 = "";
    L16:
        r3.put("create_msg", r11);     // Catch: Exception -> L33
        com.obric.event.task.nlp.c.a.b r12 = r1.b();     // Catch: Exception -> L33
        if (r12 == null) goto L19;
        String r13 = r12.a();     // Catch: Exception -> L33
    L20:
        if (r13 != null) goto L22;
        r13 = "";
    L22:
        r3.put("update_msg", r13);     // Catch: Exception -> L33
        com.obric.event.task.nlp.c.a.b r14 = r1.c();     // Catch: Exception -> L33
        if (r14 == null) goto L25;
        r4 = r14.a();     // Catch: Exception -> L33
    L25:
        if (r4 == null) goto L28;
        r5 = r4;
    L28:
        r3.put("submit_msg", r5);     // Catch: Exception -> L33
        IAppLog r6 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L33
        if (r6 == null) goto L31;
        r6.reportToFlow(EVENT_CREATE_TASK_BY_QUERY, r3);     // Catch: Exception -> L33
    L31:
        com.obric.event.task.nlp.a.a.f32889a.b(TAG, "onOmniTaskEnd report success, queryId=" + r7 + " code=" + r8);     // Catch: Exception -> L33
        return;
    L19:
        r13 = null;
        goto L20
    L13:
        r11 = null;
    L33:
        e = move-exception;
        com.obric.event.task.nlp.a.a.f32889a.b(TAG, "onOmniTaskEnd report error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    private final String limitMsg(String r2) {
        if (r2.length() <= 256) goto L6;
        String r3 = r2.substring(0, 256);
        o.c(r3, "substring(...)");
        return r3;
    L6:
        return r2;
    }
}
