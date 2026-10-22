package com.obric.event.task.base.report;

import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import org.json.JSONObject;

/* JADX INFO: compiled from: KnowledgeMonitor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f32860a = null;

    static {
        f32860a = new k();
    }

    private k() {
    }

    public final void a() {
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default((IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin"), "oauto_knowledge_page_show", new JSONObject(), false, false, null, 28, null);
    }

    public static /* synthetic */ void a(k r0, boolean r1, String r2, boolean r3, Integer r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 8) == 0) goto L8;
        r4 = null;
    L8:
        r0.a(r1, r2, r3, r4);
    }

    public final void a(boolean r11, String r12, boolean r13, Integer r14) {
        IAutoActionTrackingApi r2 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r4 = new JSONObject();
        r4.put("is_success", r11);
        r4.put("error_msg", r12);
        r4.put("is_from_net", r13);
        if (r14 == null) goto L5;
        r4.put("retry_count", ((Number) ZeusTransformUtils.preCheckCast(r14, Number.class, "com.obric.aiagent.plugin")).intValue());
    L5:
        x r10 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r2, "oauto_knowledge_page_edit", r4, false, false, null, 28, null);
    }

    public final void a(int r4, boolean r5, String r6, boolean r7, Integer r8, long r9, long r11) {
        IAutoActionTrackingApi r3 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r0 = new JSONObject();
        r0.put("is_success", r5);
        r0.put("knowledge_status", r4);
        r0.put("error_msg", r6);
        r0.put("is_from_net", r7);
        if (r8 == null) goto L5;
        r0.put("retry_count", ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.aiagent.plugin")).intValue());
    L5:
        r0.put("duration_ms", r9);
        r0.put("all_duration_ms", r11);
        x r10 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r3, "oauto_knowledge_fetch", r0, false, false, null, 28, null);
    }

    public final void a(boolean r9) {
        IAutoActionTrackingApi r0 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r2 = new JSONObject();
        r2.put("is_success", r9);
        x r8 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r0, "oauto_knowledge_page_delete", r2, false, false, null, 28, null);
    }
}
