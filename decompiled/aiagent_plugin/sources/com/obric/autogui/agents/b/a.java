package com.obric.autogui.agents.b;

import android.content.ComponentName;
import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.a.k;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.display.DisplayedAppInfo;
import com.obric.autogui.common.api.virtualdisplay.AutoActionVirtualDisplay;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.n;
import d.o;
import kotlinx.coroutines.ax;

/* JADX INFO: compiled from: CCApplicationAccessUiReadyJudge.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements com.obric.autogui.agents.c {
    private static final String TAG = "CCAccessUiJudge";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final C0673a f26797a = null;

    /* JADX INFO: renamed from: com.obric.autogui.agents.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CCApplicationAccessUiReadyJudge.kt */
    private static final class C0673a {
        public /* synthetic */ C0673a(d.h.b.h r1) {
            this();
        }

        private C0673a() {
        }
    }

    /* JADX INFO: compiled from: CCApplicationAccessUiReadyJudge.kt */
    @d.c.b.a.f(b = "CCApplicationAccessUiReadyJudge.kt", c = {129}, d = "judgePredCondition", e = "com.obric.autogui.agents.predjudge.CCApplicationAccessUiReadyJudge")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f26798a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f26799b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f26800c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f26801d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f26802e;
        /* synthetic */ Object f;
        final /* synthetic */ a g;
        int h;

        b(a r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f = r3;
            this.h |= Integer.MIN_VALUE;
            return this.g.a(null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f26797a = new C0673a(null);
    }

    public a() {
    }

    @Override // com.obric.autogui.agents.c
    public void a(com.obric.autogui.session.a r1) {
        com.obric.autogui.agents.c.a.a(this, r1);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x01fd -> B:49:0x0200). Please report as a decompilation issue!!! */
    @Override // com.obric.autogui.agents.c
    public Object a(com.obric.autogui.session.a r28, k r29, com.obric.autogui.agents.a.d r30, d.c.d<? super com.obric.autogui.agents.a.b> r31) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r31, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, b.class) == false) goto L7;
        b r3 = (b) ZeusTransformUtils.preCheckCast(r0, b.class, "com.obric.aiagent.plugin");
        if ((r3.h & Integer.MIN_VALUE) == 0) goto L7;
        r3.h -= Integer.MIN_VALUE;
        a r4 = this;
    L8:
        Object r1 = r3.f;
        Object r5 = d.c.a.b.a();
        int r6 = r3.h;
        int r8 = 1;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        int r7 = r3.f26802e;
        long r11 = r3.f26801d;
        com.obric.autogui.agents.a.d r9 = (com.obric.autogui.agents.a.d) ZeusTransformUtils.preCheckCast(r3.f26800c, com.obric.autogui.agents.a.d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.a r13 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r3.f26799b, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        a r14 = (a) ZeusTransformUtils.preCheckCast(r3.f26798a, a.class, "com.obric.aiagent.plugin");
        o.a(r1);
        int r15 = 1;
        b r10 = r3;
        com.obric.autogui.session.a r12 = r13;
        long r16 = r11;
        Object r17 = r5;
        com.obric.autogui.agents.a.d r18 = r9;
        int r19 = r7;
        r4 = r14;
    L49:
        r8 = r15;
    L20:
        if (com.obric.autogui.agents.b.b.a(r12) == false) goto L50;
        Object r110 = null;
        n.a r2 = n.f38560a;     // Catch: Throwable -> L28
        a r20 = (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
        DisplayedAppInfo r21 = AutoActionVirtualDisplay.INSTANCE.fetchVdTopAppInfo();     // Catch: Throwable -> L28
        if (r21 == null) goto L25;
        ComponentName r22 = r21.getTopActivity();     // Catch: Throwable -> L28
    L26:
        Object r23 = n.f(r22);     // Catch: Throwable -> L28
    L31:
        if (n.b(r23) == true) goto L34;
        r110 = r23;
    L34:
        ComponentName r24 = (ComponentName) ZeusTransformUtils.preCheckCast(r110, ComponentName.class, "com.obric.aiagent.plugin");
        if (com.obric.autogui.agents.b.b.a(r24) == false) goto L37;
        int r111 = r19 + r8;
    L39:
        if (r111 < 2) goto L42;
        Loog.INSTANCE.i(TAG, "event=access_ui_ready sessionKey=" + r12.a() + " stepId=" + r18.b() + " topComponent=" + r24 + " elapsedMs=" + (AOSystemTools.INSTANCE.nowTimeMillis() - r16));
        return com.obric.autogui.agents.a.b.f26124a.a();
    L42:
        int r112 = r111;
        long r113 = AOSystemTools.INSTANCE.nowTimeMillis() - r16;
        if (r113 < 5000) goto L46;
        Loog.INSTANCE.e(TAG, "event=access_ui_wait_timeout sessionKey=" + r12.a() + " stepId=" + r18.b() + " topComponent=" + r24 + " elapsedMs=" + r113);
        com.obric.autogui.session.b.e.a(com.obric.autogui.session.b.e.f30776a, "application_access_ui", "UiReadyTimeout", r12, null, null, "PULL", "waitForAccessUi", null, null, null, null, 1944, null);
        return new com.obric.autogui.agents.a.b(com.obric.autogui.agents.a.e.f26136b, ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r12.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_internal_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_internal_error")), 0, 4, null);
    L46:
        r10.f26798a = r4;
        r10.f26799b = r12;
        r10.f26800c = r18;
        r10.f26801d = r16;
        r19 = r112;
        r10.f26802e = r19;
        r15 = 1;
        r10.h = 1;
        if (ax.a(50, r10) != r17) goto L49;
        return r17;
    L37:
        r111 = 0;
        goto L39
    L25:
        r22 = null;
    L28:
        th = move-exception;
        n.a r114 = n.f38560a;
        r23 = n.f(o.a(th));
        goto L31
    L50:
        Loog.INSTANCE.i(TAG, "event=access_ui_wait_cancelled sessionKey=" + r12.a() + " stepId=" + r18.b() + " reason=AccessStateChanged");
        return com.obric.autogui.agents.a.b.f26124a.a();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r1);
        if (com.obric.autogui.agents.b.b.a(r28) == false) goto L17;
        long r115 = AOSystemTools.INSTANCE.nowTimeMillis();
        Loog.INSTANCE.i(TAG, "event=access_ui_wait_start sessionKey=" + r28.a() + " stepId=" + r30.b());
        r10 = r3;
        r16 = r115;
        r19 = 0;
        r12 = r28;
        r17 = r5;
        r18 = r30;
        goto L20
    L17:
        return com.obric.autogui.agents.a.b.f26124a.a();
    L7:
        r4 = this;
        r3 = new b(r4, r0);
        goto L8
    }
}
