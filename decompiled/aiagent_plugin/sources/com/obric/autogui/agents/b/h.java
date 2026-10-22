package com.obric.autogui.agents.b;

import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.a.k;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.AOThermalManager;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.thermal.IAutoActionThermalStateApi;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import org.json.JSONObject;

/* JADX INFO: compiled from: ThermalJudge.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h implements com.obric.autogui.agents.c {
    private static final String TAG = "ThermalJudge";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f26840a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f26841b;

    /* JADX INFO: compiled from: ThermalJudge.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f26840a = new a(null);
    }

    public h(com.obric.autogui.session.a r2) {
        o.e(r2, SensitiveType.SESSION);
    }

    @Override // com.obric.autogui.agents.c
    public void a(com.obric.autogui.session.a r1) {
        com.obric.autogui.agents.c.a.a(this, r1);
    }

    @Override // com.obric.autogui.agents.c
    public Object a(com.obric.autogui.session.a r2, k r3, com.obric.autogui.agents.a.d r4, d.c.d<? super com.obric.autogui.agents.a.b> r5) {
        return a(r2, r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    private final boolean a(k r5) {
        if (com.obric.autogui.common.a.d.f28974a.l() == true) goto L6;
        Loog.INSTANCE.d(TAG, " - [thermal] thermalJudge is disabled by settings.");
        return false;
    L6:
        int r4 = ((Number) ZeusTransformUtils.preCheckCast(r5.h().d(), Number.class, "com.obric.aiagent.plugin")).intValue();
        if (r4 != 1) goto L9;
    L11:
        Loog.INSTANCE.d(TAG, " - [thermal] thermalJudge is disabled for eval/test mode (type=" + r4 + ").");
        return false;
    L9:
        if (r4 == 2) goto L11;
        return true;
    }

    private final Object a(com.obric.autogui.session.a r13, k r14, d.c.d<? super com.obric.autogui.agents.a.b> r15) {
        d.c.d r16 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
        if (a(r14) == true) goto L6;
        Loog.INSTANCE.d(TAG, " - [thermal] thermalJudge is disabled; proceed anyway.");
        return com.obric.autogui.agents.a.b.f26124a.a();
    L6:
        IAutoActionThermalStateApi.ThermalLevelState r17 = AOThermalManager.INSTANCE.getThermalLevelState();
        if (r17 == null) goto L20;
        int r2 = ((Number) ZeusTransformUtils.preCheckCast(r14.i().d(), Number.class, "com.obric.aiagent.plugin")).intValue();
        int r18 = ((Number) ZeusTransformUtils.preCheckCast(r14.j().d(), Number.class, "com.obric.aiagent.plugin")).intValue();
        Loog.INSTANCE.i(TAG, " - [thermal] state before prediction: " + r17);
        Loog.INSTANCE.i(TAG, " - [thermal] cfg.maxTolerable: " + r2 + ", cfg.maxTolerableTime: " + r18);
        if (r17.getLevel().ordinal() > r2) goto L11;
        this.f26841b = 0;
        goto L20
    L11:
        if (this.f26841b != 0) goto L13;
        this.f26841b = r17.getEnteredTimestampMillis();
    L13:
        long r3 = AOSystemTools.INSTANCE.nowTimeMillis() - this.f26841b;
        if (r3 < r18) goto L17;
        Loog.INSTANCE.e(TAG, " - [thermal] abort! temperature is too high: " + r17);
        Loog.INSTANCE.e(TAG, " - [thermal] timeOverheated=" + r3);
        IAutoActionTrackingApi r4 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r6 = new JSONObject();
        r6.put("at_level", r17.getLevel().name());
        r6.put("time_overheated", r3);
        com.obric.autogui.session.c.b.a(r6, r13);
        x r12 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r4, "vlm_overheated", r6, false, false, null, 28, null);
        return new com.obric.autogui.agents.a.b(com.obric.autogui.agents.a.e.f26136b, ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_task_early_term_thermal_state_too_high, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_early_term_thermal_state_too_high")), 104002);
    L17:
        Loog.INSTANCE.i(TAG, " - [thermal] temperature is within maxTolerable: " + r17);
    L20:
        return com.obric.autogui.agents.a.b.f26124a.a();
    }
}
