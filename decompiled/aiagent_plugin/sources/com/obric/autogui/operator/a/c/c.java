package com.obric.autogui.operator.a.c;

import com.obric.autogui.common.AutoOperateTask;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.autogui.operator.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.h.b.o;
import d.x;
import org.json.JSONObject;

/* JADX INFO: compiled from: StandardPreCheck.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e f29817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f29818b;

    @Override // com.obric.autogui.operator.a.c.a
    public Object a(String r3, e r4, com.obric.autogui.operator.b.a r5, d<? super com.obric.autogui.common.e> r6) {
        return a(this, r3, r4, (com.obric.autogui.operator.b.a) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin"));
    }

    public c() {
    }

    @Override // com.obric.autogui.operator.a.c.a
    public Object a(d<? super Boolean> r3) {
        return a.C0768a.a(this, (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin"));
    }

    public final String b() {
        String r0 = this.f29818b;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    @Override // com.obric.autogui.operator.a.c.a
    public void a(e r2) {
        o.e(r2, "step");
        a.C0768a.a(this, r2);
        this.f29817a = r2;
    }

    @Override // com.obric.autogui.operator.a.c.a
    public void b(e r2) {
        o.e(r2, "step");
        a.C0768a.b(this, r2);
        this.f29817a = null;
        this.f29818b = null;
    }

    static /* synthetic */ Object a(c r1, String r2, e r3, com.obric.autogui.operator.b.a r4, d<? super com.obric.autogui.common.e> r5) {
        com.obric.autogui.operator.b.a r6 = (com.obric.autogui.operator.b.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin");
        d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        r1.f29818b = r2;
        return com.obric.autogui.common.e.f29014b.a();
    }

    public final void a(String r10, String r11) {
        o.e(r10, "exceptionType");
        o.e(r11, "debugInfo");
        IAutoActionTrackingApi r1 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r3 = new JSONObject();
        com.obric.autogui.session.a r0 = com.obric.autogui.session.c.f30777a.b();
        Integer r2 = null;
        if (r0 == null) goto L5;
        String r4 = r0.b();
    L6:
        r3.put("session_id", r4);
        if (r0 == null) goto L9;
        String r5 = r0.a();
    L10:
        r3.put("session_key", r5);
        if (r0 == null) goto L15;
        AutoOperateTask r6 = r0.l();
        if (r6 == null) goto L15;
        Integer r7 = Integer.valueOf(r6.getLaunchOrigin());
    L16:
        r3.put("session_origin", r7);
        e r8 = this.f29817a;
        if (r8 == null) goto L19;
        String r9 = r8.W();
    L20:
        r3.put("step_id", r9);
        if (r0 == null) goto L23;
        r2 = Integer.valueOf(r0.u());
    L23:
        r3.put("step_index", r2);
        r3.put("action_type", b());
        r3.put("check_method", a());
        r3.put("exception_type", r10);
        r3.put("debug_info", r11);
        x r12 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r1, "client_precheck_intercept_case", r3, false, false, null, 28, null);
        return;
    L19:
        r9 = null;
    L15:
        r7 = null;
        goto L16
    L9:
        r5 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }
}
