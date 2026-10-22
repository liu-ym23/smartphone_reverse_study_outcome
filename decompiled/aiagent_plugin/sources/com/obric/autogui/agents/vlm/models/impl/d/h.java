package com.obric.autogui.agents.vlm.models.impl.d;

import android.content.Context;
import android.graphics.PointF;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.google.gson.JsonArray;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.agents.vlm.models.impl.i;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.AODeviceSpecificTools;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.assistant.AssistantAbilityHelper;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotResult;
import com.obric.autogui.common.api.platform.strategy.IAutoActionPlatformStrategyApi;
import com.obric.autogui.common.api.platform.strategy.SensitiveOperation;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.ss.bduploader.BDImageUploader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import d.a.p;
import d.h.b.o;
import d.m;
import d.x;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: compiled from: UITarsStepParser.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends f {
    private static final String TAG = "M-Std/Parser/Tars";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f27795b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Set<String> f27796c = null;

    /* JADX INFO: compiled from: UITarsStepParser.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    public h() {
    }

    static {
        f27795b = new a(null);
        f27796c = ax.a(new String[]{"click", "long_press", "type", "swipe", "set_scroll_value", "double_click", "run_script_by_ability"});
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.d.f, com.obric.autogui.agents.vlm.models.impl.d.a
    public com.obric.autogui.common.d<f.b> a(com.obric.autogui.agents.vlm.models.impl.d.C0690d r24, String r25, JsonArray r26) {
        o.e(r24, "inferenceContext");
        o.e(r25, "acType");
        o.e(r26, "acParam");
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r24.a().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        Collection r7 = null;
        String r8 = null;
        r8 = null;
        switch(r25.hashCode()) {
            case -1950471620: goto L25;
            case -779672311: goto L21;
            case 109854522: goto L14;
            case 1546212196: goto L6;
            default: goto L28;
        };
    L6:
        if (r25.equals("open_page") == false) goto L28;
        if (r26.size() == 2) goto L35;
    L12:
        r7 = (Collection) ZeusTransformUtils.preCheckCast(p.a(new com.obric.autogui.operator.e.C0780e(com.obric.autogui.operator.b.EnumC0777b.f29869a, (com.obric.autogui.operator.b.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.operator.a.b.a.a.b(r26.get(0).getAsString(), r8, null, null, null, false, null, BDImageUploader.MessageIsPreHeatResultUsed, null), com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin"))), Collection.class, "com.obric.aiagent.plugin");
        String r3 = r2.getString(ZeusTransformUtils.mapRes(R.string.agent_action_desc_string_opened_page, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_action_desc_string_opened_page"));
    L29:
        if (r7 == null) goto L33;
        return com.obric.autogui.common.d.f29012a.a(new f.b(r7, r3));
    L33:
        return super.a(r24, r25, r26);
    L35:
        r8 = r26.get(1).getAsString();     // Catch: Throwable -> L34
        goto L12
    L14:
        if (r25.equals("swipe") == false) goto L28;
        if (r26.size() == 1) goto L28;
        m<Integer, Integer> r5 = AODeviceSpecificTools.INSTANCE.getScreenDimensions();
        o.a(r5);
        int r9 = ((Number) ZeusTransformUtils.preCheckCast(r5.a(), Number.class, "com.obric.aiagent.plugin")).intValue();
        int r6 = ((Number) ZeusTransformUtils.preCheckCast(r5.b(), Number.class, "com.obric.aiagent.plugin")).intValue();
        JsonArray r10 = r26.get(0).getAsJsonArray();
        JsonArray r11 = r26.get(1).getAsJsonArray();
        float r12 = r9;
        float r13 = r10.get(0).getAsFloat() * r12;
        float r14 = r6;
        float r15 = r10.get(1).getAsFloat() * r14;
        float r16 = r11.get(0).getAsFloat() * r12;
        float r17 = r11.get(1).getAsFloat() * r14;
        r7 = (Collection) ZeusTransformUtils.preCheckCast(p.a(new com.obric.autogui.operator.e.C0780e(com.obric.autogui.operator.b.EnumC0777b.j, (com.obric.autogui.operator.b.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.operator.a.b.e.b(com.obric.autogui.operator.a.b.e.a.f29658a, new PointF(r13, r15), new PointF(r16, r17), a(new PointF(r13, r15), new PointF(r16, r17)), 0, 16, null), com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin"))), Collection.class, "com.obric.aiagent.plugin");
        r3 = r2.getString(ZeusTransformUtils.mapRes(R.string.agent_action_desc_string_swipe, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_action_desc_string_swipe"));
        goto L29
    L21:
        if (r25.equals("take_notes") == false) goto L28;
        r7 = (Collection) ZeusTransformUtils.preCheckCast(p.b(), Collection.class, "com.obric.aiagent.plugin");
        r3 = r2.getString(ZeusTransformUtils.mapRes(R.string.agent_action_desc_string_take_note, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_action_desc_string_take_note"));
        goto L29
    L25:
        if (r25.equals("set_scroll_value") == false) goto L28;
        String r18 = r2.getString(ZeusTransformUtils.mapRes(R.string.agent_action_desc_string_set_scroll_value, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_action_desc_string_set_scroll_value"));
        m<Integer, Integer> r4 = AODeviceSpecificTools.INSTANCE.getScreenDimensions();
        o.a(r4);
        int r19 = ((Number) ZeusTransformUtils.preCheckCast(r4.a(), Number.class, "com.obric.aiagent.plugin")).intValue();
        int r20 = ((Number) ZeusTransformUtils.preCheckCast(r4.b(), Number.class, "com.obric.aiagent.plugin")).intValue();
        JsonArray r21 = r26.get(0).getAsJsonArray();
        float r22 = r21.get(0).getAsFloat() * r19;
        float r23 = r21.get(1).getAsFloat() * r20;
        String r27 = r26.get(1).getAsString();
        com.obric.autogui.operator.b.EnumC0777b r28 = com.obric.autogui.operator.b.EnumC0777b.f29871c;
        m r110 = new m(Float.valueOf(r22), Float.valueOf(r23));
        o.a(r27);
        r7 = (Collection) ZeusTransformUtils.preCheckCast(p.a(new com.obric.autogui.operator.e.C0780e(r28, (com.obric.autogui.operator.b.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.operator.a.b.b.d.b(r110, r27), com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin"))), Collection.class, "com.obric.aiagent.plugin");
        r3 = r18;
    L28:
        r3 = null;
        goto L29
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.d.f
    public List<PointF> a(String r3, JsonArray r4) {
        o.e(r3, "acName");
        o.e(r4, "opParam");
        List<PointF> r0 = super.a(r3, r4);
        if (o.a(r3, "swipe") == true) goto L5;
    L7:
        return r0;
    L5:
        if (r4.size() < 2) goto L7;
        JsonArray r5 = r4.get(1).getAsJsonArray();
        o.a(r5);
        r0.add(b(r5));
        goto L7
    }

    private final long a(PointF r3, PointF r4) {
        return (long) (((float) Math.sqrt(((r3.x - r4.x) * (r3.x - r4.x)) + ((r3.y - r4.y) * (r3.y - r4.y)))) / 1.0f);
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.d.f
    public com.obric.autogui.agents.vlm.models.impl.g a(com.obric.autogui.agents.vlm.models.impl.d.C0690d r6, com.obric.autogui.agents.vlm.models.impl.g r7) {
        o.e(r6, "inferenceContext");
        o.e(r7, "generatedStep");
        com.obric.autogui.agents.vlm.b.C0677b r0 = r6.a();
        com.obric.autogui.agents.vlm.models.c.b r8 = r6.b();
        if (r0.e() == false) goto L8;
        com.obric.autogui.agents.vlm.models.impl.o r1 = a(r0);
        if (r1 == null) goto L8;
        Loog.INSTANCE.i(TAG, "adjust first step, app-list not accessible;");
        return (com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(r1, com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin");
    L8:
        com.obric.autogui.agents.vlm.models.impl.g r2 = a(r0, r8, r7);
        if (r2 == null) goto L13;
        Loog.INSTANCE.i(TAG, "it is a Doubao-Clarify-downcast-to-CallUser step.");
        return r2;
    L13:
        if (ZeusTransformUtils.instanceOf(r7, com.obric.autogui.agents.vlm.models.impl.e.class) == false) goto L15;
        com.obric.autogui.agents.vlm.models.impl.e r3 = (com.obric.autogui.agents.vlm.models.impl.e) ZeusTransformUtils.preCheckCast(r7, com.obric.autogui.agents.vlm.models.impl.e.class, "com.obric.aiagent.plugin");
    L16:
        if (r3 == null) goto L18;
        String r4 = r3.f();
    L20:
        if (o.a(r4, "open_app") == false) goto L24;
        Loog.INSTANCE.d(TAG, " - adjust step: it is an [open_app]; no need to adjust.");
        return null;
    L24:
        return b(r0, r8, r7);
    L18:
        r4 = null;
        goto L20
    L15:
        r3 = null;
        goto L16
    }

    private final com.obric.autogui.agents.vlm.models.impl.o a(com.obric.autogui.agents.vlm.b.C0677b r3) {
        b(r3);
        if (r3.a().x() == true) goto L6;
        Loog.INSTANCE.w(TAG, " - [FirstStep] app-list not accessible; inquiring this with the User.");
        return new com.obric.autogui.agents.vlm.models.impl.o().a(r3);
    L6:
        return null;
    }

    private final void b(com.obric.autogui.agents.vlm.b.C0677b r5) {
        IAutoActionPlatformStrategyApi r4 = AOPlatformTools.INSTANCE.platformStrategy();
        String r0 = null;
        if (r4 == null) goto L5;
        IAutoActionPlatformStrategyApi.SensitiveOpStrategy r6 = r4.checkSensitiveOp((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), SensitiveOperation.ACCESS_FOR_FULL_APP_LIST);
    L6:
        if (r6 != null) goto L8;
    L12:
        Loog r1 = Loog.INSTANCE;
        StringBuilder r2 = new StringBuilder().append(" - [AppList] not allowed to get app list right now (r=");
        if (r6 == null) goto L15;
        r0 = r6.getReason();
    L15:
        r1.w(TAG, r2.append(r0).append(").").toString());
        r5.a().c(false);
        return;
    L8:
        if (r6.isAllowed() == false) goto L12;
        r5.a().c(true);
        return;
    L5:
        r6 = null;
        goto L6
    }

    private final com.obric.autogui.agents.vlm.models.impl.g a(com.obric.autogui.agents.vlm.b.C0677b r4, com.obric.autogui.agents.vlm.models.c.b r5, com.obric.autogui.agents.vlm.models.impl.g r6) {
        if (com.obric.autogui.common.a.d.f28974a.b() == true) goto L6;
        return null;
    L6:
        if (ZeusTransformUtils.instanceOf(r6, i.class) == true) goto L9;
        return null;
    L9:
        if (AssistantAbilityHelper.INSTANCE.isChatPageInVD() == false) goto L12;
        Loog.INSTANCE.e(TAG, " - [doubao-clarify-step] doubao being operated; adjust to a call-user step");
        com.obric.autogui.agents.vlm.models.impl.h r3 = new com.obric.autogui.agents.vlm.models.impl.h();
        r3.j(((i) ZeusTransformUtils.preCheckCast(r6, i.class, "com.obric.aiagent.plugin")).E());
        r3.k(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_action_need_call_user_action, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_action_need_call_user_action")));
        r3.f(r6.i());
        r3.a((com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(r6, com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin"));
        return (com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin");
    L12:
        return null;
    }

    private final com.obric.autogui.agents.vlm.models.impl.g b(com.obric.autogui.agents.vlm.b.C0677b r12, com.obric.autogui.agents.vlm.models.c.b r13, com.obric.autogui.agents.vlm.models.impl.g r14) {
        ScreenshotResult r11 = r13.g();
        com.obric.autogui.agents.vlm.models.impl.g r15 = null;
        if (r11 == null) goto L5;
        ScreenshotResult.Status r16 = r11.getStatus();
    L7:
        if (r16 == ScreenshotResult.Status.ContainsSecure) goto L9;
        return null;
    L9:
        boolean r17 = false;
        if (ZeusTransformUtils.instanceOf(r14, com.obric.autogui.agents.vlm.models.impl.e.class) == false) goto L14;
        String r0 = ((com.obric.autogui.agents.vlm.models.impl.e) ZeusTransformUtils.preCheckCast(r14, com.obric.autogui.agents.vlm.models.impl.e.class, "com.obric.aiagent.plugin")).f();
        if (f27796c.contains(r0) == false) goto L14;
        r17 = true;
        Loog.INSTANCE.i(TAG, " - [secure-screen-step] secure screenshot: needAdjust (action=" + r0 + ')');
    L14:
        Loog.INSTANCE.i(TAG, " - [secure-screen-step] secure screenshot: needAdjust = " + r17);
        if (r17 == false) goto L17;
        Loog.INSTANCE.e(TAG, " - [secure-screen-step] secure screenshot; adjust to a call-user step");
        com.obric.autogui.agents.vlm.models.impl.f r18 = new com.obric.autogui.agents.vlm.models.impl.f();
        String r1 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r12.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_stepexec_adjusted_calluser_action, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_stepexec_adjusted_calluser_action"));
        o.c(r1, "getString(...)");
        String r3 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r12.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_stepexec_adjusted_calluser_thought, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_stepexec_adjusted_calluser_thought"));
        o.c(r3, "getString(...)");
        r18.j(r1);
        r18.f(r3);
        r18.a((com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(r14, com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin"));
        r15 = (com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(r18, com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin");
    L17:
        IAutoActionTrackingApi r4 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r5 = new JSONObject();
        if (ZeusTransformUtils.instanceOf(r14, com.obric.autogui.agents.vlm.models.a.b.class) == false) goto L20;
        r5.put("action_type", ((com.obric.autogui.agents.vlm.models.a.b) ZeusTransformUtils.preCheckCast(r14, com.obric.autogui.agents.vlm.models.a.b.class, "com.obric.aiagent.plugin")).f());
    L20:
        r5.put("need_sensitive_adjust", r17);
        r5.put("model_thought", r14.w());
        com.obric.autogui.session.c.b.a(r5, r12.a());
        x r19 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r4, "sensitive_screenshot", r5, false, false, null, 28, null);
        return r15;
    L5:
        r16 = null;
        goto L7
    }
}
