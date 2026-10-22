package com.obric.autogui.agents.b;

import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.a.k;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.account.IAutoActionAccountApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.o;

/* JADX INFO: compiled from: LoggedOnJudge.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements com.obric.autogui.agents.c {

    /* JADX INFO: compiled from: LoggedOnJudge.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f26827a = null;

        static {
            int[] r0 = new int[IAutoActionAccountApi.LoggedOnType.values().length];
            r0[IAutoActionAccountApi.LoggedOnType.DOUBAO_NOT_LOGGED_ON.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[IAutoActionAccountApi.LoggedOnType.DOUBAO_LOGGED_ON_STATE_NOT_SPECIFIED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[IAutoActionAccountApi.LoggedOnType.SYSTEM_NOT_LOGGED_ON.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f26827a = r0;
        }
    }

    /* JADX INFO: compiled from: LoggedOnJudge.kt */
    @d.c.b.a.f(b = "LoggedOnJudge.kt", c = {28}, d = "judgePredCondition", e = "com.obric.autogui.agents.predjudge.LoggedOnJudge")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f26828a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f26829b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f26830c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f26831d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f26832e;

        b(d r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f26831d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f26830c = r3;
            this.f26832e |= Integer.MIN_VALUE;
            return this.f26831d.a(null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public d() {
    }

    @Override // com.obric.autogui.agents.c
    public void a(com.obric.autogui.session.a r1) {
        com.obric.autogui.agents.c.a.a(this, r1);
    }

    @Override // com.obric.autogui.agents.c
    public Object a(com.obric.autogui.session.a r5, k r6, com.obric.autogui.agents.a.d r7, d.c.d<? super com.obric.autogui.agents.a.b> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, b.class) == false) goto L7;
        b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.aiagent.plugin");
        if ((r10.f26832e & Integer.MIN_VALUE) == 0) goto L7;
        r10.f26832e -= Integer.MIN_VALUE;
    L8:
        Object r11 = r10.f26830c;
        Object r0 = d.c.a.b.a();
        int r1 = r10.f26832e;
        if (r1 == 0) goto L14;
        if (r1 != 1) goto L13;
        r5 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r10.f26829b, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        d this = (d) ZeusTransformUtils.preCheckCast(r10.f26828a, d.class, "com.obric.aiagent.plugin");
        o.a(r11);
    L17:
        IAutoActionAccountApi.LoggedOnCheckResult r12 = (IAutoActionAccountApi.LoggedOnCheckResult) ZeusTransformUtils.preCheckCast(r11, IAutoActionAccountApi.LoggedOnCheckResult.class, "com.obric.aiagent.plugin");
        if (r12 != null) goto L20;
    L23:
        if (r12 == null) goto L25;
        IAutoActionAccountApi.LoggedOnType r13 = r12.getType();
    L26:
        if (r13 != null) goto L28;
        int r14 = -1;
    L30:
        if (r14 == 1) goto L42;
        if (r14 == 2) goto L40;
        if (r14 == 3) goto L38;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "fetched userInfoAcq = " + r12 + ", abort task.");
        return new com.obric.autogui.agents.a.b(com.obric.autogui.agents.a.e.f26136b, ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_cannot_start_system_login_status_cannot_fetch, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_cannot_start_system_login_status_cannot_fetch")), 104003);
    L38:
        return new com.obric.autogui.agents.a.b(com.obric.autogui.agents.a.e.f26136b, ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_cannot_start_system_login_logged_out, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_cannot_start_system_login_logged_out")), 104003);
    L40:
        return new com.obric.autogui.agents.a.b(com.obric.autogui.agents.a.e.f26136b, ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_cannot_start_doubao_login_state_not_specified, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_cannot_start_doubao_login_state_not_specified")), 104003);
    L42:
        return new com.obric.autogui.agents.a.b(com.obric.autogui.agents.a.e.f26136b, ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_cannot_start_doubao_login_logged_out, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_cannot_start_doubao_login_logged_out")), 104003);
    L28:
        r14 = a.f26827a[r13.ordinal()];
        goto L30
    L25:
        r13 = null;
        goto L26
    L20:
        if (r12.getType() != IAutoActionAccountApi.LoggedOnType.LOGGED_ON) goto L23;
        return com.obric.autogui.agents.a.b.f26124a.a();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r11);
        IAutoActionAccountApi r15 = AOPlatformTools.INSTANCE.account();
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        r10.f26828a = this;
        r10.f26829b = r5;
        r10.f26832e = 1;
        r11 = r15.checkLoggedOn(r2, r10);
        if (r11 != r0) goto L17;
        return r0;
    L7:
        r10 = new b(this, r9);
        goto L8
    }
}
