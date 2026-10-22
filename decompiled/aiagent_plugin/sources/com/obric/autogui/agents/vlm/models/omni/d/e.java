package com.obric.autogui.agents.vlm.models.omni.d;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.autogui.agents.vlm.models.omni.intent.g;
import com.obric.autogui.agents.vlm.models.omni.intent.j;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.capabilitykit.common.Ext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.n;
import d.x;
import org.json.JSONObject;

/* JADX INFO: compiled from: OmniToolExecutionTrackingReporter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    private static final String TAG = "OmniToolStartReporter";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f28334a = null;

    static {
        f28334a = new e();
    }

    private e() {
    }

    public final void a(g r12, String r13) {
        o.e(r12, Ext.KEY_REQUEST);
        String r2 = r12.b();
        Long r3 = r12.a();
        String r4 = r12.g();
        String r5 = r12.h();
        String r6 = r12.i();
        String r7 = r12.j();
        j r14 = r12.c();
        if (r14 == null) goto L6;
        String r15 = r14.a();
        if (r15 == null) goto L6;
    L7:
        a(r2, r3, r4, r5, r6, r7, r15, false, r13);
        return;
    L6:
        r15 = "multi_action";
        goto L7
    }

    public final void a(String r12, Long r13, String r14, String r15) {
        o.e(r12, ObricMemoryConstants.KEY_SESSION_ID);
        a(r12, r13, "gui_init", "gui_init", "gui_init", r14, "gui_init", true, r15);
    }

    private final void a(String r22, Long r23, String r24, String r25, String r26, String r27, String r28, boolean r29, String r30) {
        String r12 = "";
        n.a r13 = n.f38560a;     // Catch: Throwable -> L18
        e r14 = (e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        IAutoActionTrackingApi r15 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        JSONObject r16 = new JSONObject();     // Catch: Throwable -> L18
        r16.put("session_id", r22);     // Catch: Throwable -> L18
        if (r27 == null) goto L7;
        r16.put("instruction_id", r27);     // Catch: Throwable -> L18
    L7:
        if (r23 == null) goto L9;
        String r11 = r23.toString();     // Catch: Throwable -> L18
    L10:
        if (r11 != null) goto L12;
        r11 = "";
    L12:
        r16.put("doubao_message_id", r11);     // Catch: Throwable -> L18
        r16.put("tool_id", r24);     // Catch: Throwable -> L18
        r16.put("tool_name", r25);     // Catch: Throwable -> L18
        r16.put("instruction_type", r26);     // Catch: Throwable -> L18
        r16.put("action_type", r28);     // Catch: Throwable -> L18
        r16.put("is_gui_init", r29);     // Catch: Throwable -> L18
        f.a(r16, r30);     // Catch: Throwable -> L18
        x r0 = x.f38692a;     // Catch: Throwable -> L18
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r15, "obric_omni_tool_do_action_start", r16, false, false, null, 16, null);     // Catch: Throwable -> L18
        Loog r1 = Loog.INSTANCE;     // Catch: Throwable -> L18
        StringBuilder r17 = new StringBuilder().append("工具开始执行埋点已提交 sessionId=").append(r22).append(" toolId=").append(r24).append(" actionType=").append(r28).append(" isGuiInit=").append(r29).append(" logId=");     // Catch: Throwable -> L18
        if (r30 != null) goto L15;
        String r18 = "";
    L16:
        r1.i(TAG, r17.append(r18).toString());     // Catch: Throwable -> L18
        Object r2 = n.f(x.f38692a);     // Catch: Throwable -> L18
    L20:
        Throwable r3 = n.c(r2);
        if (r3 == null) goto L30;
        Loog r19 = Loog.INSTANCE;
        StringBuilder r4 = new StringBuilder().append("工具开始执行埋点失败 sessionId=").append(r22).append(" toolId=").append(r24).append(" actionType=").append(r28).append(" isGuiInit=").append(r29).append(" logId=");
        if (r30 == null) goto L26;
        r12 = r30;
    L26:
        r19.w(TAG, r4.append(r12).append(" errorType=").append(r3.getClass().getSimpleName()).toString());
        return;
    L30:
        return;
    L15:
        r18 = r30;
        goto L16
    L9:
        r11 = null;
    L18:
        th = move-exception;
        n.a r110 = n.f38560a;
        r2 = n.f(d.o.a(th));
        goto L20
    }
}
