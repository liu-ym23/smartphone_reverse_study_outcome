package com.obric.autogui.common.api;

import android.content.Context;
import com.obric.oui.oswitch.SwitchCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.h.a.m;
import d.o;
import d.x;

/* JADX INFO: compiled from: AOSystemTools.kt */
/* JADX INFO: loaded from: classes3.dex */
@f(b = "AOSystemTools.kt", c = {SwitchCompat.TRACK_ANIMATION_DURATION_ON}, d = "invokeSuspend", e = "com.obric.autogui.common.api.AOAgentRobotsTools$registerAgentAsync$1$registered$1")
final class AOAgentRobotsTools$registerAgentAsync$1$registered$1 extends l implements m<Integer, d<? super Boolean>, Object> {
    final /* synthetic */ String $agentName;
    final /* synthetic */ AOAgentRobotsTools.AgentType $agentType;
    final /* synthetic */ Context $appCtx;
    /* synthetic */ int I$0;
    int label;

    AOAgentRobotsTools$registerAgentAsync$1$registered$1(Context r3, String r4, AOAgentRobotsTools.AgentType r5, d<? super AOAgentRobotsTools$registerAgentAsync$1$registered$1> r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
        this.$appCtx = ZeusTransformUtils.wrapperContext(r7, "com.obric.aiagent.plugin");
        this.$agentName = r4;
        this.$agentType = r5;
        super(2, r8);
    }

    @Override // d.c.b.a.a
    public final d<x> create(Object r5, d<?> r6) {
        d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
        AOAgentRobotsTools$registerAgentAsync$1$registered$1 r0 = new AOAgentRobotsTools$registerAgentAsync$1$registered$1(this.$appCtx, this.$agentName, this.$agentType, r7);
        r0.I$0 = ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")).intValue();
        return (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.aiagent.plugin");
    }

    public final Object invoke(int r3, d<? super Boolean> r4) {
        d<?> r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        return ((AOAgentRobotsTools$registerAgentAsync$1$registered$1) ZeusTransformUtils.preCheckCast(create(Integer.valueOf(r3), r5), AOAgentRobotsTools$registerAgentAsync$1$registered$1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
    }

    @Override // d.h.a.m
    public /* synthetic */ Object invoke(Integer r3, d<? super Boolean> r4) {
        return invoke(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue(), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
    }

    @Override // d.c.b.a.a
    public final Object invokeSuspend(Object r9) {
        Object r0 = b.a();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        o.a(r9);
    L11:
        return r9;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        o.a(r9);
        int r5 = this.I$0;
        AOAgentRobotsTools r2 = AOAgentRobotsTools.INSTANCE;
        Context r10 = this.$appCtx;
        d.h.b.o.a(r10);
        String r3 = this.$agentName;
        AOAgentRobotsTools.AgentType r4 = this.$agentType;
        d r6 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
        this.label = 1;
        r9 = AOAgentRobotsTools.access$registerAgentOnce(r2, r10, r3, r4, r5, r6);
        if (r9 != r0) goto L11;
        return r0;
    }
}
