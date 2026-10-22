package com.obric.autoaction.vdplayer.legacy.a.a;

import com.obric.autogui.common.api.agent.IAutoActionAgentApi;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.o;
import d.x;

/* JADX INFO: compiled from: StopTaskUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: compiled from: StopTaskUseCase.kt */
    @d.c.b.a.f(b = "StopTaskUseCase.kt", c = {13}, d = "invoke", e = "com.obric.autoaction.vdplayer.legacy.domain.action.StopTaskUseCase")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f25660a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f25661b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ h f25662c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f25663d;

        a(h r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25662c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f25661b = r3;
            this.f25663d |= Integer.MIN_VALUE;
            return this.f25662c.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public h() {
    }

    public final Object a(IAutoActionAgentEventListener.SessionInfo r5, d.c.d<? super x> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, a.class) == false) goto L7;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.aiagent.plugin");
        if ((r0.f25663d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f25663d -= Integer.MIN_VALUE;
    L8:
        Object r4 = r0.f25661b;
        Object r8 = d.c.a.b.a();
        int r2 = r0.f25663d;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        r5 = (IAutoActionAgentEventListener.SessionInfo) ZeusTransformUtils.preCheckCast(r0.f25660a, IAutoActionAgentEventListener.SessionInfo.class, "com.obric.aiagent.plugin");
        o.a(r4);
    L19:
        com.obric.autogui.common.e r9 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r4, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
    L20:
        com.obric.autoaction.vdplayer.legacy.c.b.f25682a.a(r5);
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r4);
        IAutoActionAgentApi r10 = (IAutoActionAgentApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionAgentApi.class), IAutoActionAgentApi.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L20;
        r0.f25660a = r5;
        r0.f25663d = 1;
        r4 = r10.userTerminateQuery(null, r0);
        if (r4 != r8) goto L19;
        return r8;
    L7:
        r0 = new a(this, r7);
        goto L8
    }
}
