package com.obric.autogui.vdplayer.adapter.orchestrator.a.a;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.agent.model.EndStepParams;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.h.a.m;
import d.o;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: TerminatedEventHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends com.obric.autogui.vdplayer.adapter.orchestrator.a.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BizStatus f31664a;

    /* JADX INFO: compiled from: TerminatedEventHandler.kt */
    @d.c.b.a.f(b = "TerminatedEventHandler.kt", c = {78}, d = "invokeSuspend", e = "com.obric.autogui.vdplayer.adapter.orchestrator.handler.impl.TerminatedEventHandler$onBizStatusChanged$2")
    static final class a extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f31665a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IAutoActionAgentEventListener.SessionInfo f31666b;

        a(IAutoActionAgentEventListener.SessionInfo r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31666b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f31666b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f31665a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L11:
            com.obric.autogui.vdplayer.adapter.orchestrator.b.f31668a.c(this.f31666b.getSessionKey());
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31665a = 1;
            if (ax.a(10000, r7) != r0) goto L11;
            return r0;
        }
    }

    public static /* synthetic */ com.obric.autogui.vdplayer.api.a.b lambda$soT1wLpntzOWr0gDXsWc6iryYG0(BizStatus.StatusChangedReasonStruct r0, Bitmap r1, com.obric.autogui.vdplayer.api.a.b r2) {
        return a(r0, r1, r2);
    }

    public g() {
        this.f31664a = BizStatus.TERMINATED;
    }

    @Override // com.obric.autogui.vdplayer.adapter.orchestrator.a.a
    public BizStatus a() {
        return this.f31664a;
    }

    @Override // com.obric.autogui.vdplayer.adapter.orchestrator.a.a.a, com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onBizStatusChanged(IAutoActionAgentEventListener.SessionInfo r17, BizStatus r18, BizStatus r19, int r20, final BizStatus.StatusChangedReasonStruct r21, Bundle r22) {
        d.h.b.o.e(r17, "sessionInfo");
        d.h.b.o.e(r18, "oldStatus");
        d.h.b.o.e(r19, "status");
        d.h.b.o.e(r21, "reasonDetails");
        if (r22 == null) goto L5;
        final Bitmap r6 = (Bitmap) ZeusTransformUtils.preCheckCast(r22.getParcelable("termination_screenshot"), Bitmap.class, "com.obric.aiagent.plugin");
    L6:
        c(new $$Lambda$g$soT1wLpntzOWr0gDXsWc6iryYG0(r21, r6));
        if (r21.getReason() != 0) goto L13;
        Object r2 = r21.getObj();
        if (ZeusTransformUtils.instanceOf(r2, EndStepParams.class) == false) goto L11;
        a((com.obric.autogui.vdplayer.api.a.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.vdplayer.api.a.a.d(((EndStepParams) ZeusTransformUtils.preCheckCast(r2, EndStepParams.class, "com.obric.aiagent.plugin")).getModelSuccess(), false, ((EndStepParams) ZeusTransformUtils.preCheckCast(r2, EndStepParams.class, "com.obric.aiagent.plugin")).getAction(), ((EndStepParams) ZeusTransformUtils.preCheckCast(r2, EndStepParams.class, "com.obric.aiagent.plugin")).getOpenApp(), false, null, 48, null), com.obric.autogui.vdplayer.api.a.a.class, "com.obric.aiagent.plugin"));
    L27:
        i.a(an.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.a(), d.c.g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new a(r17, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L11:
        a((com.obric.autogui.vdplayer.api.a.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.vdplayer.api.a.a.d(true, false, null, false, false, null, 60, null), com.obric.autogui.vdplayer.api.a.a.class, "com.obric.aiagent.plugin"));
        goto L27
    L13:
        if (d.h.b.o.a(r21.getExtra().get("o_block_decision_source"), "1") == false) goto L15;
        String r13 = "security_normal";
    L17:
        if (r20 != 1101) goto L19;
        boolean r10 = true;
    L20:
        String r3 = r21.getMsg();
        if (r3 != null) goto L23;
        r3 = "";
    L23:
        if (r22 == null) goto L25;
        boolean r11 = r22.getBoolean("open_app", false);
    L26:
        a((com.obric.autogui.vdplayer.api.a.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.vdplayer.api.a.a.d(false, r10, r3, r11, false, r13, 16, null), com.obric.autogui.vdplayer.api.a.a.class, "com.obric.aiagent.plugin"));
        goto L27
    L25:
        r11 = false;
        goto L26
    L19:
        r10 = false;
        goto L20
    L15:
        r13 = null;
        goto L17
    L5:
        r6 = null;
        goto L6
    }

    private static final com.obric.autogui.vdplayer.api.a.b a(BizStatus.StatusChangedReasonStruct r7, Bitmap r8, com.obric.autogui.vdplayer.api.a.b r9) {
        d.h.b.o.e(r9, "$this$updateAgentContext");
        if (r8 != null) goto L6;
        r8 = r9.d();
    L6:
        return com.obric.autogui.vdplayer.api.a.b.a(r9, null, r7, null, r8, 5, null);
    }
}
