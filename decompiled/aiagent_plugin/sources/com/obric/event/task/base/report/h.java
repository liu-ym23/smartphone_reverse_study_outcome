package com.obric.event.task.base.report;

import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import org.json.JSONObject;

/* JADX INFO: compiled from: DiscoveryMonitor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f32778a = null;

    static {
        f32778a = new h();
    }

    private h() {
    }

    public final void a() {
        AOBizTracking r8 = AOBizTracking.INSTANCE;
        if (r8 == null) goto L6;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default((IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(r8, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin"), "oauto_discovery_instruction_request_start", new JSONObject(), false, false, null, 28, null);
        return;
    }

    public final void a(long r9, long r11, boolean r13) {
        if (r11 < r9) goto L5;
        long r12 = r11 - r9;
    L6:
        AOBizTracking r8 = AOBizTracking.INSTANCE;
        if (r8 == null) goto L10;
        IAutoActionTrackingApi r0 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(r8, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r2 = new JSONObject();
        r2.put("duration", r12);
        r2.put("is_error", r13);
        x r10 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r0, "oauto_discovery_instruction_request_duration", r2, false, false, null, 28, null);
        return;
    L10:
        return;
    L5:
        r12 = 0;
        goto L6
    }

    public final void a(int r9, String r10, String r11) {
        d.h.b.o.e(r10, "msg");
        d.h.b.o.e(r11, "logId");
        AOBizTracking r8 = AOBizTracking.INSTANCE;
        if (r8 == null) goto L6;
        IAutoActionTrackingApi r0 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(r8, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r2 = new JSONObject();
        r2.put("error_code", r9);
        r2.put("error_msg", r10);
        r2.put("log_id", r11);
        x r12 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r0, "oauto_discovery_instruction_request_error", r2, false, false, null, 28, null);
        return;
    }

    public final void a(int r9, String r10) {
        AOBizTracking r8 = AOBizTracking.INSTANCE;
        if (r8 == null) goto L6;
        IAutoActionTrackingApi r0 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(r8, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r2 = new JSONObject();
        r2.put("error_code", r9);
        r2.put("error_msg", r10);
        x r11 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r0, "oauto_discovery_instruction_request_error", r2, false, false, null, 28, null);
        return;
    }

    public final void a(String r9, Exception r10) {
        d.h.b.o.e(r9, "rawData");
        d.h.b.o.e(r10, "e");
        AOBizTracking r8 = AOBizTracking.INSTANCE;
        if (r8 == null) goto L6;
        IAutoActionTrackingApi r0 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(r8, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r2 = new JSONObject();
        r2.put("raw_data", r9);
        r2.put("error_msg", r10.getMessage());
        x r11 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r0, "oauto_discovery_instruction_parse_error", r2, false, false, null, 28, null);
        return;
    }

    public final void a(g r9) {
        d.h.b.o.e(r9, "item");
        AOBizTracking r8 = AOBizTracking.INSTANCE;
        if (r8 == null) goto L6;
        IAutoActionTrackingApi r0 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(r8, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r2 = new JSONObject();
        r2.put("template_id", r9.a());
        r2.put("template_query", r9.b());
        r2.put("instruction_type", r9.c());
        r2.put("execute_type", r9.d());
        r2.put("short_command", r9.e());
        x r10 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r0, "oauto_discovery_instruction_item_add", r2, false, false, null, 28, null);
        return;
    }
}
