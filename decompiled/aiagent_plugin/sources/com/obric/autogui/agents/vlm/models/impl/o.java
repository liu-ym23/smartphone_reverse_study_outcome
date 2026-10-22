package com.obric.autogui.agents.vlm.models.impl;

import android.app.Activity;
import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.agents.vlm.models.omni.r;
import com.obric.autogui.common.api.agent.AutoActionAgent;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.strategy.IAutoActionPlatformStrategyApi;
import com.obric.autogui.common.api.platform.strategy.SensitiveOperation;
import com.obric.autogui.common.api.presentation.IAutoActionPresentationApi;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;

/* JADX INFO: compiled from: StandardModelUnsolicitedAppListCheckingStep.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o extends h implements com.obric.autogui.agents.vlm.models.a.e {
    private static final String TAG = "StdMod/AppListChk";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f27975d = null;

    /* JADX INFO: compiled from: StandardModelUnsolicitedAppListCheckingStep.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: StandardModelUnsolicitedAppListCheckingStep.kt */
    @d.c.b.a.f(b = "StandardModelUnsolicitedAppListCheckingStep.kt", c = {87}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.StandardModelUnsolicitedAppListCheckingStep$onBeforeCallUser$1")
    static final class b extends d.c.b.a.l implements d.h.a.b<d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f27976a;

        b(d.c.d<? super b> r3) {
            super(1, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(d.c.d<? super x> r3) {
            return ((b) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f27976a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            AutoActionAgent r6 = AutoActionAgent.INSTANCE;
            d.c.d<? super com.obric.autogui.common.e> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27976a = 1;
            if (r6.exitCallUser(r2) != r0) goto L12;
            return r0;
        }
    }

    static {
        f27975d = new a(null);
    }

    /* JADX INFO: renamed from: lambda$0oquaOBDXVhW7Iog66frBz-jJGI, reason: not valid java name */
    public static /* synthetic */ x m764lambda$0oquaOBDXVhW7Iog66frBzjJGI(o r0, r r1) {
        return a(r0, r1);
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.h, com.obric.autogui.agents.vlm.models.impl.e, com.obric.autogui.agents.vlm.models.impl.g, com.obric.autogui.agents.vlm.models.a.d
    public boolean h() {
        return false;
    }

    public o() {
    }

    public final o a(com.obric.autogui.agents.vlm.b.C0677b r3) {
        d.h.b.o.e(r3, SensitiveType.SESSION);
        b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        return this;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.h, com.obric.autogui.agents.vlm.models.impl.e, com.obric.autogui.agents.vlm.models.impl.g
    public Object a(com.obric.autogui.session.a r3, d.c.d<? super com.obric.autogui.operator.g> r4) {
        d.c.d<? super com.obric.autogui.operator.g> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        r3.a(new $$Lambda$o$0oquaOBDXVhW7Iog66frBzjJGI(this));
        return super.a(r3, r5);
    }

    private static final x a(o r2, r r3) {
        d.h.b.o.e(r3, "it");
        String r0 = r2.E();
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r4 = r2.F();
        if (r4 == null) goto L9;
        r1 = r4;
    L9:
        r3.b(r0, d.a.p.a(r1));
        return x.f38692a;
    }

    private final void b(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        j(r5.getString(ZeusTransformUtils.mapRes(R.string.std_model_need_app_list, WsChannelMultiProcessSharedProvider.STRING_TYPE, "std_model_need_app_list")));
        k(r5.getString(ZeusTransformUtils.mapRes(R.string.std_model_need_app_list_action, WsChannelMultiProcessSharedProvider.STRING_TYPE, "std_model_need_app_list_action")));
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.h
    public boolean G() {
        com.obric.autogui.session.a r7 = com.obric.autogui.session.c.f30777a.b();
        if (r7 != null) goto L5;
        return false;
    L5:
        IAutoActionPlatformStrategyApi r1 = AOPlatformTools.INSTANCE.platformStrategy();
        String r2 = null;
        if (r1 == null) goto L8;
        IAutoActionPlatformStrategyApi.SensitiveOpStrategy r3 = r1.checkSensitiveOp((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), SensitiveOperation.ACCESS_FOR_FULL_APP_LIST);
    L10:
        if (r3 != null) goto L12;
    L16:
        Loog r8 = Loog.INSTANCE;
        StringBuilder r5 = new StringBuilder().append(" - [AppList] not allowed to get app list right now (r=");
        if (r3 == null) goto L19;
        r2 = r3.getReason();
    L19:
        r8.w(TAG, r5.append(r2).append(").").toString());
        Loog.INSTANCE.i(TAG, " - [AppListChecking] applying for AppList-setting page.");
        IAutoActionPresentationApi r9 = (IAutoActionPresentationApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionPresentationApi.class), IAutoActionPresentationApi.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L24;
        Activity r10 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getCurrentShowingPlayer(), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L24;
        Context r11 = (Context) ZeusTransformUtils.preCheckCast(r10, Context.class, "com.obric.aiagent.plugin");
    L25:
        AOPlatformTools.INSTANCE.platformStrategy().applyForSensitiveOp(r11, SensitiveOperation.ACCESS_FOR_FULL_APP_LIST);
        return false;
    L24:
        r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        goto L25
    L12:
        if (r3.isAllowed() == false) goto L16;
        Loog.INSTANCE.i(TAG, " - [AppList] allowed to get app list right now.");
        r7.c(true);
        AOPlatformTools.INSTANCE.packages().invalidateCache();
        com.obric.autogui.agents.vlm.models.impl.applist.black.g.f27362a.b();
        r7.h().launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new b(null), d.h.a.b.class, "com.obric.aiagent.plugin"));
        return false;
    L8:
        r3 = null;
        goto L10
    }
}
