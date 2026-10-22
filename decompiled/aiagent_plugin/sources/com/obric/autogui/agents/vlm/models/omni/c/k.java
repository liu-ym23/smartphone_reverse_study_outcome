package com.obric.autogui.agents.vlm.models.omni.c;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.capabilitykit.common.Ext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.ce;
import org.json.JSONObject;

/* JADX INFO: compiled from: AppPrewarmTelemetry.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f28285a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f28286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final JSONObject f28287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f28288d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f28289e;
    private r.c f;
    private com.obric.autogui.agents.vlm.models.omni.intent.g g;
    private Long h;
    private boolean i;

    /* JADX INFO: compiled from: AppPrewarmTelemetry.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f28285a = new a(null);
    }

    public k(String r3, String r4) {
        d.h.b.o.e(r3, ObricMemoryConstants.KEY_SESSION_ID);
        this.f28286b = new Object();
        JSONObject r0 = new JSONObject();
        r0.put("session_id", r3);
        if (r4 != null) goto L5;
    L10:
        this.f28287c = r0;
        return;
    L5:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L8;
        r4 = null;
    L8:
        if (r4 == null) goto L10;
        r0.put("inner_log_id", r4);
        goto L10
    }

    public final void a(String r3) {
        d.h.b.o.e(r3, "sessionKey");
        Object r0 = this.f28286b;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.i == false) goto L7;
    L9:
        x r2 = x.f38692a;     // Catch: Throwable -> L12
        monitor-exit(r0);
        return;
    L7:
        if (this.g != null) goto L9;
        this.f28288d = r3;     // Catch: Throwable -> L12
        goto L9
    }

    public final void a(f r5, long r6) {
        d.h.b.o.e(r5, "result");
        Object r0 = this.f28286b;
        monitor-enter(r0);
    L28:
        th = move-exception;
        throw th;
    L5:
        if (this.i == false) goto L7;
    L26:
        monitor-exit(r0);
        return;
    L7:
        if (this.g != null) goto L26;
        this.f28289e = true;     // Catch: Throwable -> L28
        String r2 = null;
        if (ZeusTransformUtils.instanceOf(r5, f.b.class) == false) goto L12;
        f.b r7 = (f.b) ZeusTransformUtils.preCheckCast(r5, f.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
    L13:
        if (r7 == null) goto L17;
        List<b> r8 = r7.a();     // Catch: Throwable -> L28
        if (r8 == null) goto L17;
        b r9 = (b) ZeusTransformUtils.preCheckCast(d.a.p.l(r8), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
    L18:
        JSONObject r1 = this.f28287c;     // Catch: Throwable -> L28
        if (r9 == null) goto L21;
        r2 = r9.a();     // Catch: Throwable -> L28
    L21:
        if (r2 != null) goto L23;
        r2 = "";
    L23:
        r1.put("predicted_package", r2);     // Catch: Throwable -> L28
        this.f28287c.put("prediction_duration_ms", r6);     // Catch: Throwable -> L28
        monitor-exit(r0);
        return;
    L17:
        r9 = null;
        goto L18
    L12:
        r7 = null;
        goto L13
    }

    public final void a(com.obric.autogui.agents.vlm.models.omni.intent.g r10, long r11) {
        d.h.b.o.e(r10, Ext.KEY_REQUEST);
        Object r0 = this.f28286b;
        monitor-enter(r0);
    L41:
        th = move-exception;
        throw th;
    L5:
        if (this.g == null) goto L7;
    L39:
        monitor-exit(r0);
        return;
    L7:
        if (this.i == true) goto L39;
        this.g = r10;     // Catch: Throwable -> L41
        r.c r1 = this.f;     // Catch: Throwable -> L41
        boolean r2 = false;
        JSONObject r4 = null;
        if (r1 != null) goto L12;
    L17:
        r1 = null;
    L18:
        if (r1 == null) goto L25;
        Long r12 = Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(Long.valueOf(r11 - r1.c()), Number.class, "com.obric.aiagent.plugin")).longValue());     // Catch: Throwable -> L41
        if (((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.aiagent.plugin")).longValue() < 0) goto L23;
        r2 = true;
    L23:
        if (Boolean.valueOf(r2).booleanValue() == false) goto L25;
    L26:
        this.h = r12;     // Catch: Throwable -> L41
        this.f28287c.put("first_tool_id", r10.g());     // Catch: Throwable -> L41
        if (this.f28289e == true) goto L29;
        r4 = b(this, "prediction_interrupted", null, 2, null);     // Catch: Throwable -> L41
    L36:
        monitor-exit(r0);
        a(r4);
        return;
    L29:
        if (r1 != null) goto L32;
        r4 = b(this, "prewarm_not_ready", null, 2, null);     // Catch: Throwable -> L41
        goto L36
    L32:
        if (com.obric.autogui.agents.vlm.models.omni.intent.b.a(r10) == 1) goto L34;
    L35:
        r4 = b("first_action_not_open_app", i.f28265c);     // Catch: Throwable -> L41
        goto L36
    L34:
        if (d.h.b.o.a(com.obric.autogui.agents.vlm.models.omni.intent.b.b(r10), "open_app") == true) goto L36;
    L25:
        r12 = null;
        goto L26
    L12:
        if (r1.c() > r11) goto L14;
        boolean r5 = true;
    L15:
        if (r5 == false) goto L17;
    L14:
        r5 = false;
        goto L15
    }

    public final void a(com.obric.autogui.agents.vlm.models.omni.intent.g r8, String r9, com.obric.autogui.operator.g r10) {
        com.obric.autogui.operator.g r11 = (com.obric.autogui.operator.g) ZeusTransformUtils.wrapperContextForParams(r10, com.obric.autogui.operator.g.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r11, "result");
        if (r11.b() == com.obric.autogui.operator.g.c.f29925d) goto L6;
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r11, com.obric.autogui.operator.m.class) == false) goto L8;
        com.obric.autogui.operator.m r12 = (com.obric.autogui.operator.m) ZeusTransformUtils.preCheckCast(r11, com.obric.autogui.operator.m.class, "com.obric.aiagent.plugin");
    L9:
        if (r12 == null) goto L11;
        com.obric.autogui.operator.c r13 = r12.h();
    L13:
        if (ZeusTransformUtils.instanceOf(r13, com.obric.autogui.operator.a.b.a.a.c.class) == false) goto L15;
        com.obric.autogui.operator.a.b.a.a.c r14 = (com.obric.autogui.operator.a.b.a.a.c) ZeusTransformUtils.preCheckCast(r13, com.obric.autogui.operator.a.b.a.a.c.class, "com.obric.aiagent.plugin");
    L16:
        if (r14 != null) goto L18;
        return;
    L18:
        com.obric.autogui.operator.a.b.a.c r15 = r14.f();
        Object r0 = this.f28286b;     // Catch: Exception -> L75 CancellationException -> L78
        monitor-enter(r0);     // Catch: Exception -> L75 CancellationException -> L78
    L72:
        th = move-exception;
        throw th;     // Catch: Exception -> L75 CancellationException -> L78
    L22:
        if (this.i == true) goto L70;
        if (r8 == null) goto L70;
        if (this.g != r8) goto L70;
        CharSequence r16 = (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L72
        boolean r2 = false;
        if (r16 != null) goto L29;
    L32:
        boolean r17 = true;
    L33:
        if (r17 == true) goto L70;
        if (d.h.b.o.a(this.f28288d, r9) == false) goto L70;
        String r18 = r15.d();     // Catch: Throwable -> L72
        if (r18 == null) goto L40;
        String r19 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.aiagent.plugin")).toString();     // Catch: Throwable -> L72
    L41:
        if (r19 != null) goto L44;
        r19 = "";
    L44:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L46;
        boolean r20 = true;
    L47:
        if (r20 == false) goto L55;
        r.c r21 = this.f;     // Catch: Throwable -> L72
        if (r21 == null) goto L51;
        String r22 = r21.a();     // Catch: Throwable -> L72
    L53:
        if (d.h.b.o.a(r19, r22) == false) goto L55;
        boolean r23 = true;
    L56:
        JSONObject r4 = this.f28287c;     // Catch: Throwable -> L72
        r4.put("actual_package", r19);     // Catch: Throwable -> L72
        r4.put("formal_open_result", r15.a().b());     // Catch: Throwable -> L72
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L60;
        r2 = true;
    L60:
        if (r2 == false) goto L62;
        JSONObject r24 = b(this, "open_app_failed", null, 2, null);     // Catch: Throwable -> L72
    L68:
        monitor-exit(r0);     // Catch: Exception -> L75 CancellationException -> L78
        a(r24);     // Catch: Exception -> L75 CancellationException -> L78
        return;
    L62:
        if (r23 == true) goto L65;
        r24 = b("package_mismatch", i.f28265c);     // Catch: Throwable -> L72
        goto L68
    L65:
        if (r15.a().c() == false) goto L67;
        r24 = b("matched_first_open_app", i.f28263a);     // Catch: Throwable -> L72
        goto L68
    L67:
        r24 = b(this, "open_app_failed", null, 2, null);     // Catch: Throwable -> L72
        goto L68
    L51:
        r22 = null;
    L55:
        r23 = false;
        goto L56
    L46:
        r20 = false;
        goto L47
    L40:
        r19 = null;
        goto L41
    L29:
        if (d.o.o.d(r16) == true) goto L32;
        r17 = false;
    L70:
        monitor-exit(r0);     // Catch: Exception -> L75 CancellationException -> L78
        return;
    L78:
        e = move-exception;
        throw e;
    L75:
        e = move-exception;
        Loog.INSTANCE.w("AppPrewarm", "OpenApp result observation failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return;
    L15:
        r14 = null;
        goto L16
    L11:
        r13 = null;
        goto L13
    L8:
        r12 = null;
        goto L9
    }

    public final void a(com.obric.autogui.agents.vlm.models.omni.intent.g r4) {
        d.h.b.o.e(r4, Ext.KEY_REQUEST);
        Object r0 = this.f28286b;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.g == r4) goto L8;
        monitor-exit(r0);
        return;
    L8:
        JSONObject r5 = b(this, "open_app_not_executed", null, 2, null);     // Catch: Throwable -> L12
        monitor-exit(r0);
        a(r5);
    }

    public static /* synthetic */ void a(k r0, String r1, i r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = i.f28264b;
    L5:
        r0.a(r1, r2);
    }

    public final void a(String r2, i r3) {
        d.h.b.o.e(r2, "reason");
        d.h.b.o.e(r3, "outcome");
        Object r0 = this.f28286b;
        monitor-enter(r0);
        JSONObject r4 = b(r2, r3);     // Catch: Throwable -> L8
        monitor-exit(r0);
        a(r4);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ JSONObject b(k r0, String r1, i r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = i.f28264b;
    L6:
        return r0.b(r1, r2);
    }

    private final JSONObject b(String r4, i r5) {
        if (this.i == false) goto L6;
        return null;
    L6:
        this.i = true;
        JSONObject r0 = new JSONObject(this.f28287c.toString());
        r0.put("outcome", r5.a());
        r0.put("reason", r4);
        if (r5 != i.f28263a) goto L11;
        Long r3 = this.h;
        if (r3 == null) goto L11;
        r0.put("prewarm_lead_ms", ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).longValue());
    L11:
        return r0;
    }

    private final void a(JSONObject r11) {
        if (r11 != null) goto L11;
        return;
    L11:
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default((IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin"), "oauto_omni_first_app_prewarm", r11, false, false, null, 16, null);     // Catch: Exception -> L7
    L9:
        Loog.INSTANCE.i("AppPrewarm", "result=" + r11.optString("outcome") + " reason=" + r11.optString("reason") + " sessionId=" + r11.optString("session_id"));
        return;
    L7:
        e = move-exception;
        Loog.INSTANCE.e("AppPrewarm", "prewarm result reporting failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        goto L9
    }

    public final Object a(r.c r6, d.c.d<? super x> r7) {
        d.c.g r8 = ((d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin")).getContext();
        Object r0 = this.f28286b;
        monitor-enter(r0);
        ce.b(r8);     // Catch: Throwable -> L16
        if (this.i == false) goto L7;
    L13:
        x r5 = x.f38692a;     // Catch: Throwable -> L16
        monitor-exit(r0);
        return r5;
    L7:
        if (this.g != null) goto L13;
        this.f = r6;     // Catch: Throwable -> L16
        this.f28287c.put("process_ready_duration_ms", r6.c() - r6.b());     // Catch: Throwable -> L16
        monitor-exit(r0);
        return x.f38692a;
    L16:
        th = move-exception;
        throw th;
    }

    public final Object a(String r3, d.c.d<? super x> r4) {
        d.c.g r5 = ((d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")).getContext();
        Object r0 = this.f28286b;
        monitor-enter(r0);
        ce.b(r5);     // Catch: Throwable -> L16
        if (this.i == false) goto L7;
    L13:
        x r2 = x.f38692a;     // Catch: Throwable -> L16
        monitor-exit(r0);
        return r2;
    L7:
        if (this.g != null) goto L13;
        JSONObject r6 = b(this, r3, null, 2, null);     // Catch: Throwable -> L16
        monitor-exit(r0);
        a(r6);
        return x.f38692a;
    L16:
        th = move-exception;
        throw th;
    }
}
