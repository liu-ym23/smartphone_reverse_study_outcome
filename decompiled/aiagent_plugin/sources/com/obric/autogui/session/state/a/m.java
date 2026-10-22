package com.obric.autogui.session.state.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.agents.vlm.models.omni.ac;
import com.obric.autogui.agents.vlm.models.omni.r;
import com.obric.autogui.agents.vlm.models.omni.w;
import com.obric.autogui.common.api.AOPackagesTools;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.packages.appinfo.AppInfoEntry;
import com.obric.autogui.common.api.virtualdisplay.VDTrackingApp;
import com.obric.autogui.session.functions.impl.vd.VDEventsListenerImpl;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.s;
import d.x;
import java.util.Map;

/* JADX INFO: compiled from: StateUserInterrupted.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m extends com.obric.autogui.session.state.a implements com.obric.autogui.agents.vlm.models.omni.intent.e, c, d {
    private static final String TAG = "S-UserInter";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f31343b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f31344c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f31345d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f31346e;

    /* JADX INFO: compiled from: StateUserInterrupted.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f31343b = new a(null);
    }

    public static /* synthetic */ x lambda$6AMtd76ihxwgD58fjakX82dYhqQ(long r0, Bundle r2) {
        return a(r0, r2);
    }

    /* JADX INFO: renamed from: lambda$VuGvTTRv_cnfqdueCbW0Fe8d-kk, reason: not valid java name */
    public static /* synthetic */ x m901lambda$VuGvTTRv_cnfqdueCbW0Fe8dkk(Map r0, r r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ x lambda$rB2aROKUOOspVgVcF4SVQyhF6GM(r r0) {
        return a(r0);
    }

    public m(com.obric.autogui.session.state.b r9, com.obric.autogui.session.a r10) {
        d.h.b.o.e(r9, "machine");
        d.h.b.o.e(r10, SensitiveType.SESSION);
        super(BizStatus.USER_INTERRUPTED, r10, r9, false, 8, null);
    }

    public final void a(String r1) {
        this.f31344c = r1;
    }

    public final void b(String r1) {
        this.f31345d = r1;
    }

    @Override // com.obric.autogui.session.state.a
    public Object a(com.obric.autogui.session.state.a r9, d.c.d<? super com.obric.autogui.common.e> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, m.class) == true) goto L9;
        k();
        com.obric.autogui.a.a.a.f26091a.a("user-interrupt exited");
        d().a($$Lambda$m$rB2aROKUOOspVgVcF4SVQyhF6GM.INSTANCE);
        if (ZeusTransformUtils.instanceOf(r9, h.class) == false) goto L9;
        com.obric.autogui.session.b.a r12 = d().o();
        if (r12 == null) goto L9;
        r12.b("USER_INTERRUPTED");
    L9:
        this.f31344c = null;
        this.f31345d = null;
        if (this.f31346e == 0) goto L13;
        long r2 = d().D().getLong("user_interrupted_duration", 0);
        long r4 = AOSystemTools.INSTANCE.bootTimeMillis() - this.f31346e;
        this.f31346e = 0;
        final long r3 = r2 + r4;
        d().D().putLong("user_interrupted_duration", r3);
        d().J().a(new $$Lambda$m$6AMtd76ihxwgD58fjakX82dYhqQ(r3));
        Loog.INSTANCE.i(i(), " - [User-Interrupted] this session spent " + r3 + " ms in user-interruption.");
    L13:
        return com.obric.autogui.common.e.f29014b.a();
    }

    private static final x a(r r3) {
        d.h.b.o.e(r3, "omniActionsHolder");
        r.b(r3, "occupy_end", null, 2, null);
        return x.f38692a;
    }

    private static final x a(long r1, Bundle r3) {
        d.h.b.o.e(r3, "$this$withTaskEndReports");
        r3.putLong("user_interrupted_duration", r1);
        return x.f38692a;
    }

    @Override // com.obric.autogui.session.state.a, com.obric.autogui.util.c.a, com.obric.autogui.util.c.b
    public void b(com.obric.autogui.util.c.b r8) {
        com.obric.autogui.util.c.b r9 = (com.obric.autogui.util.c.b) ZeusTransformUtils.wrapperContextForParams(r8, com.obric.autogui.util.c.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "fromState");
        super.b(r9);
        com.obric.autogui.util.h.f31557a.b(d(), "user interrupted");
        j();
        com.obric.autogui.session.b.a r10 = d().o();
        if (r10 == null) goto L5;
        r10.a("USER_INTERRUPTED");
    L5:
        String r11 = d().v();
        if (r11 == null) goto L8;
        Loog.INSTANCE.w(TAG, " - suspended step-generation tracking [step/" + r11 + ']');
    L8:
        com.obric.autogui.b.a.f28928a.onOperatingAppChanged(d().d(), null);
        com.obric.autogui.a.a.a.f26091a.a(d());
        this.f31346e = AOSystemTools.INSTANCE.bootTimeMillis();
        d().b(null);
        com.obric.autogui.agents.b.f26789a.a().b(d());
        d().j();
        if (w.f28887a.a(d().l().getTaskExtras()) == false) goto L12;
        ac r12 = w.a(w.f28887a, 109006, "user_interrupted", null, 4, null);
        com.obric.autogui.session.state.termination.a.a(d().J(), null, r12.a(), null, r12.b(), 5, null);
        return;
    }

    @Override // com.obric.autogui.session.state.a
    public Bundle h() {
        Bundle r0 = super.h();
        if (r0 != null) goto L5;
        r0 = new Bundle();
    L5:
        String r1 = this.f31345d;
        if (r1 != null) goto L8;
    L10:
        return r0;
    L8:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L10;
        r0.putString("interrupt_reason_for_user", this.f31344c);
        r0.putString("interrupt_reason_for_user_specified", r1);
        goto L10
    }

    private final void j() {
        final Map<String, String> r0 = l();
        d().a(new $$Lambda$m$VuGvTTRv_cnfqdueCbW0Fe8dkk(r0));
    }

    private static final x a(Map r2, r r3) {
        Map<String, String> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "omniSession");
        r3.a("occupy_begin", r4);
        return x.f38692a;
    }

    @Override // com.obric.autogui.agents.vlm.models.omni.intent.e
    public IntentResult<Bitmap> a() {
        Loog.INSTANCE.i(TAG, "OccupyTakeOverTrace - notify server on action dispatch while user-interrupted, sessionId=" + d().b());
        j();
        return com.obric.autogui.agents.vlm.models.omni.intent.d.a(com.obric.autogui.agents.vlm.models.omni.intent.c.p, null, 1, null);
    }

    private final void k() {
        com.obric.autogui.agents.a r0 = com.obric.autogui.agents.b.f26789a.a();
        Object r1 = d().a(r0);
        if (ZeusTransformUtils.instanceOf(r1, com.obric.autogui.agents.vlm.b.C0677b.class) == false) goto L5;
        com.obric.autogui.agents.vlm.b.C0677b r2 = (com.obric.autogui.agents.vlm.b.C0677b) ZeusTransformUtils.preCheckCast(r1, com.obric.autogui.agents.vlm.b.C0677b.class, "com.obric.aiagent.plugin");
    L6:
        if (r2 != null) goto L8;
        return;
    L8:
        com.obric.autogui.agents.vlm.b.C0677b.a r3 = r2.o();
        com.obric.autogui.agents.vlm.b.C0677b.a.EnumC0679b r4 = com.obric.autogui.agents.vlm.b.C0677b.a.EnumC0679b.f27123c;
        String r5 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(d().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_stepexec_interrupt_operated, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_stepexec_interrupt_operated"));
        d.h.b.o.c(r5, "getString(...)");
        r3.a(r4, r5);
        return;
    L5:
        r2 = null;
        goto L6
    }

    private final Map<String, String> l() {
        String r1 = m();
        if (r1 == null) goto L7;
        Map<String, String> r2 = ao.a(s.a("occupy_app_name", r1));
        if (r2 == null) goto L7;
        return r2;
    L7:
        return ao.b();
    }

    private final String m() {
        Object r0 = d().F().get("op_openapp_pending_open");
        String r3 = null;
        if (ZeusTransformUtils.instanceOf(r0, VDTrackingApp.class) == false) goto L5;
        VDTrackingApp r1 = (VDTrackingApp) ZeusTransformUtils.preCheckCast(r0, VDTrackingApp.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 == null) goto L8;
        String r2 = r1.getPackageName();
    L9:
        String r4 = c(r2);
        if (r4 == null) goto L16;
        Loog r6 = Loog.INSTANCE;
        StringBuilder r5 = new StringBuilder().append("OccupyTakeOverTrace - [User-Interrupted][OccupyApp] resolved, source=pending_open, package=");
        if (r1 == null) goto L14;
        r3 = r1.getPackageName();
    L14:
        r6.i(TAG, r5.append(r3).append(", appName=").append(r4).toString());
        return r4;
    L16:
        Object r7 = d().F().get(VDEventsListenerImpl.KEY_EXTRA_TRACKING_APP_INFO);
        if (ZeusTransformUtils.instanceOf(r7, IAutoActionAgentEventListener.OperatingAppInfo.class) == false) goto L19;
        IAutoActionAgentEventListener.OperatingAppInfo r8 = (IAutoActionAgentEventListener.OperatingAppInfo) ZeusTransformUtils.preCheckCast(r7, IAutoActionAgentEventListener.OperatingAppInfo.class, "com.obric.aiagent.plugin");
    L20:
        if (r8 == null) goto L28;
        CharSequence r9 = r8.getAppLabel();
        if (r9 == null) goto L28;
        String r10 = r9.toString();
        if (r10 == null) goto L28;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L28;
    L29:
        if (r10 == null) goto L32;
        Loog.INSTANCE.i(TAG, "OccupyTakeOverTrace - [User-Interrupted][OccupyApp] resolved, source=tracking_app_info, appName=" + r10);
        return r10;
    L32:
        Loog.INSTANCE.w(TAG, "OccupyTakeOverTrace - [User-Interrupted][OccupyApp] missing, pendingOpen=" + r1 + ", trackingAppInfo=" + r8);
        return null;
    L28:
        r10 = null;
        goto L29
    L19:
        r8 = null;
        goto L20
    L8:
        r2 = null;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    private final String c(String r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L8;
        r5 = null;
    L8:
        if (r5 == null) goto L25;
        AppInfoEntry r6 = AOPackagesTools.INSTANCE.getAppInfo((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r5);
        if (r6 == null) goto L21;
        CharSequence r7 = r6.getAppLabel();
        if (r7 == null) goto L22;
        String r8 = r7.toString();
        if (r8 != null) goto L17;
        return null;
    L17:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L19;
        return null;
    L19:
        return r8;
    L22:
        return null;
    L21:
        return null;
    L25:
        return null;
    }
}
