package com.obric.autogui.agents.vlm.models.impl;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import org.json.JSONObject;

/* JADX INFO: compiled from: StandardModelEndStep.kt */
/* JADX INFO: loaded from: classes3.dex */
public class j extends e implements com.obric.autogui.agents.vlm.models.a.b, com.obric.autogui.operator.j {
    private static final String TAG = "M-Std-Step/E";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f27930c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f27931d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f27932e;
    private boolean g;
    private String h;
    private String i;

    /* JADX INFO: compiled from: StandardModelEndStep.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f27930c = new a(null);
    }

    public static /* synthetic */ x lambda$awSfbXehJ7bPsUsIV21tIQeRtxU(j r0, Bundle r1) {
        return a(r0, r1);
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.g, com.obric.autogui.agents.vlm.models.a.d
    public boolean A() {
        return true;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.e, com.obric.autogui.agents.vlm.models.impl.g
    public Object a(com.obric.autogui.session.a r3, d.c.d<? super com.obric.autogui.operator.g> r4) {
        return a(this, r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.e, com.obric.autogui.agents.vlm.models.impl.g, com.obric.autogui.agents.vlm.models.a.d
    public boolean h() {
        return false;
    }

    public j() {
        this.f27932e = true;
    }

    public final void j(String r1) {
        this.f27931d = r1;
    }

    public final boolean E() {
        return this.f27932e;
    }

    public final void c(boolean r1) {
        this.f27932e = r1;
    }

    public final boolean F() {
        return this.g;
    }

    public final void d(boolean r1) {
        this.g = r1;
    }

    public final void k(String r1) {
        this.h = r1;
    }

    static /* synthetic */ Object a(final j r8, com.obric.autogui.session.a r9, d.c.d<? super com.obric.autogui.operator.g> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (com.obric.autogui.common.b.b.f29001a.a() == false) goto L5;
        Loog.INSTANCE.i(TAG, "[end-of-vlm], reply=" + r8.f27931d + ", thinking=" + r8.i() + " , openApp=" + r8.g);
    L5:
        Loog.INSTANCE.i(TAG, "[end-of-vlm], model-success=" + r8.f27932e);
        IAutoActionTrackingApi r0 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r2 = new JSONObject();
        r2.put("open_app", r8.g);
        r2.put("model_opinion", r8.f27932e);
        r2.put("model_end_reason", r8.h);
        com.obric.autogui.session.c.b.a(r2, r9);
        x r12 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r0, "model_stop", r2, false, false, null, 28, null);
        r9.J().a(new $$Lambda$j$awSfbXehJ7bPsUsIV21tIQeRtxU(r8));
        return new com.obric.autogui.operator.g.d("");
    }

    private static final x a(j r1, Bundle r2) {
        d.h.b.o.e(r2, "$this$withTaskEndReports");
        String r3 = r1.h;
        if (r3 == null) goto L6;
        r2.putString("model_end_reason", r3);
    L6:
        return x.f38692a;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.g, com.obric.autogui.agents.vlm.models.a.d
    public String z() {
        String r0 = this.f27931d;
        if (r0 == null) goto L5;
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r1) == false) goto L10;
        r1 = w();
    L10:
        return (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.aiagent.plugin");
    L5:
        return w();
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.e, com.obric.autogui.agents.vlm.models.a.b
    public String e() {
        String r3 = this.i;
        if (r3 != null) goto L6;
        String r4 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_task_terminated_success, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_terminated_success"));
        d.h.b.o.c(r4, "getString(...)");
        return r4;
    L6:
        return r3;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.e, com.obric.autogui.agents.vlm.models.impl.g, com.obric.autogui.agents.vlm.models.a.d
    public Bundle g() {
        Bundle r0 = super.g();
        if (r0 != null) goto L5;
        r0 = new Bundle();
    L5:
        r0.putBoolean("model_success", this.f27932e);
        r0.putBoolean("open_app", this.g);
        return r0;
    }
}
