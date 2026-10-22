package com.obric.autoaction.presentation.doubao;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.AOPackagesTools;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.agent.AutoActionAgent;
import com.obric.autogui.common.api.agent.IAutoActionAgentApi;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.presentation.AOUserInterfaceTools;
import com.obric.autogui.common.api.presentation.IAutoActionPresentationApi;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.o;
import d.x;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: AssistRemoteCardActionHandlers.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f24860a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, String> f24861b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f24862c;

    /* JADX INFO: compiled from: AssistRemoteCardActionHandlers.kt */
    @d.c.b.a.f(b = "AssistRemoteCardActionHandlers.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.doubao.AssistRemoteCardActionHandlers$openReportWindow$1")
    static final class a extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24863a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f24864b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f24865c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f24866d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f24867e;

        a(String r3, String r4, String r5, int r6, d.c.d<? super a> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24864b = r3;
            this.f24865c = r4;
            this.f24866d = r5;
            this.f24867e = r6;
            super(2, r8);
        }

        public static /* synthetic */ x lambda$J_59gqX5UivHTRPgjL0m3IKaY0s(boolean r0) {
            return a(r0);
        }

        /* JADX INFO: renamed from: lambda$_9EdSj_-uUg08T5Aypz7ITyZu0g, reason: not valid java name */
        public static /* synthetic */ x m616lambda$_9EdSj_uUg08T5Aypz7ITyZu0g() {
            return a();
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f24864b, this.f24865c, this.f24866d, this.f24867e, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            d.c.a.b.a();
            if (this.f24863a != 0) goto L14;
            o.a(r10);
            Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            if (this.f24864b == null) goto L7;
            String r11 = AutoActionAgent.INSTANCE.calcJournalAbsoluteDir(this.f24865c, this.f24864b);
        L8:
            String r5 = r11;
            b r0 = b.f24860a;
            String r2 = this.f24865c;
            String r12 = this.f24864b;
            if (r12 != null) goto L11;
            r12 = "doubao_session_key_not_uploaded";
        L11:
            b.a(r0, r1, r2, r12, this.f24866d, r5, this.f24867e, $$Lambda$b$a$_9EdSj_uUg08T5Aypz7ITyZu0g.INSTANCE, $$Lambda$b$a$J_59gqX5UivHTRPgjL0m3IKaY0s.INSTANCE);
            return x.f38692a;
        L7:
            r11 = null;
            goto L8
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        private static final x a() {
            return x.f38692a;
        }

        private static final x a(boolean r0) {
            return x.f38692a;
        }
    }

    /* JADX INFO: renamed from: com.obric.autoaction.presentation.doubao.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AssistRemoteCardActionHandlers.kt */
    @d.c.b.a.f(b = "AssistRemoteCardActionHandlers.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.doubao.AssistRemoteCardActionHandlers$openReportWindow$2")
    static final class C0578b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24868a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.autoaction.userreport.a f24869b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.h.a.a<x> f24870c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d.h.a.b<Boolean, x> f24871d;

        C0578b(com.obric.autoaction.userreport.a r3, d.h.a.a<x> r4, d.h.a.b<? super Boolean, x> r5, d.c.d<? super C0578b> r6) {
            d.h.a.a<x> r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.h.a.b<Boolean, x> r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24869b = r3;
            this.f24870c = r7;
            this.f24871d = r8;
            super(2, r9);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((C0578b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0578b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C0578b(this.f24869b, this.f24870c, this.f24871d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f24868a != 0) goto L7;
            o.a(r2);
            this.f24869b.a(this.f24870c, this.f24871d);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AssistRemoteCardActionHandlers.kt */
    @d.c.b.a.f(b = "AssistRemoteCardActionHandlers.kt", c = {45}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.doubao.AssistRemoteCardActionHandlers$openSharePage$1")
    static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24872a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f24873b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f24874c;

        c(String r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24873b = r3;
            super(2, r5);
        }

        private static final String a() {
            return "[Share-from-Assistant] url=  (fetched-anew)";
        }

        public static /* synthetic */ String lambda$bPzxW_ahNeLYSmCwd1TSLwf2UJA() {
            return a();
        }

        /* JADX INFO: renamed from: lambda$cP5hAWNVkUP0ObmwBjWv-OTF258, reason: not valid java name */
        public static /* synthetic */ String m617lambda$cP5hAWNVkUP0ObmwBjWvOTF258(String r0) {
            return a(r0);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            c r0 = new c(this.f24873b, r5);
            r0.f24874c = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24872a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            am r2 = (am) ZeusTransformUtils.preCheckCast(this.f24874c, am.class, "com.obric.aiagent.plugin");
            o.a(r12);
        L12:
            IAutoActionAgentApi.SessionShareInfo r13 = (IAutoActionAgentApi.SessionShareInfo) ZeusTransformUtils.preCheckCast(r12, IAutoActionAgentApi.SessionShareInfo.class, "com.obric.aiagent.plugin");
            if (r13 == null) goto L15;
            final String r14 = r13.getShareUrl();
        L16:
            if (r14 != null) goto L19;
            return x.f38692a;
        L19:
            if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L21;
            AOUserInterfaceTools.showAppToast$default(AOUserInterfaceTools.INSTANCE, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.string.obric_assist_card_share_not_supported_task, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_assist_card_share_not_supported_task"), false, 4, null);
            return x.f38692a;
        L21:
            Loog.INSTANCE.ip(LogUtil.INSTANCE.getCLAZZ_TAG(r2), new $$Lambda$b$c$cP5hAWNVkUP0ObmwBjWvOTF258(r14), $$Lambda$b$c$bPzxW_ahNeLYSmCwd1TSLwf2UJA.INSTANCE);
            b.a().put(this.f24873b, r14);
            IAutoActionPresentationApi r3 = (IAutoActionPresentationApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionPresentationApi.class), IAutoActionPresentationApi.class, "com.obric.aiagent.plugin");
            if (r3 == null) goto L27;
            r3.openSharingWebView((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r14, this.f24873b, "assistant_card_button");
            return x.f38692a;
        L27:
            return null;
        L15:
            r14 = null;
            goto L16
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r12);
            am r15 = (am) ZeusTransformUtils.preCheckCast(this.f24874c, am.class, "com.obric.aiagent.plugin");
            AOUserInterfaceTools.INSTANCE.showAppToast((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.string.obric_assist_card_share_please_wait, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_assist_card_share_please_wait"), true);
            AutoActionAgent r4 = AutoActionAgent.INSTANCE;
            String r5 = this.f24873b;
            d.c.d<? super IAutoActionAgentApi.SessionShareInfo> r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24874c = r15;
            this.f24872a = 1;
            Object r7 = r4.fetchSessionShareUrl(r5, r6);
            if (r7 != r0) goto L11;
            return r0;
        L11:
            r2 = r15;
            r12 = r7;
            goto L12
        }

        private static final String a(String r2) {
            return "[Share-from-Assistant] url=" + r2 + " (fetched-anew)";
        }
    }

    private static final String b() {
        return "[Share-from-Assistant] url=  ";
    }

    /* JADX INFO: renamed from: lambda$MhAM6y-S63Pmum48A6fjdjITaRA, reason: not valid java name */
    public static /* synthetic */ String m614lambda$MhAM6yS63Pmum48A6fjdjITaRA() {
        return b();
    }

    /* JADX INFO: renamed from: lambda$VlxxsYW9K-ceqlvSjM-e9bOJ4TE, reason: not valid java name */
    public static /* synthetic */ String m615lambda$VlxxsYW9KceqlvSjMe9bOJ4TE(String r0) {
        return c(r0);
    }

    private b() {
    }

    public static final /* synthetic */ Map a() {
        return f24861b;
    }

    public static final /* synthetic */ void a(b r11, Context r12, String r13, String r14, String r15, String r16, int r17, d.h.a.a r18, d.h.a.b r19) {
        r11.a((Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin"), r13, r14, r15, r16, r17, (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r18, d.h.a.a.class, "com.obric.aiagent.plugin"), (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r19, d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    static {
        f24860a = new b();
        f24861b = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    public final void a(String r6) {
        d.h.b.o.e(r6, "forSessionId");
        final String r0 = (String) ZeusTransformUtils.preCheckCast(f24861b.get(r6), String.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(r0, "") == true) goto L10;
        if (r0 != null) goto L6;
        AOThreadingTools.INSTANCE.launchUI((d.h.a.m) ZeusTransformUtils.preCheckCast(new c(r6, null), d.h.a.m.class, "com.obric.aiagent.plugin"));
        return;
    L6:
        Loog.INSTANCE.ip(LogUtil.INSTANCE.getCLAZZ_TAG(this), new $$Lambda$b$VlxxsYW9KceqlvSjMe9bOJ4TE(r0), $$Lambda$b$MhAM6yS63Pmum48A6fjdjITaRA.INSTANCE);
        IAutoActionPresentationApi r5 = (IAutoActionPresentationApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionPresentationApi.class), IAutoActionPresentationApi.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L12;
        r5.openSharingWebView((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r0, r6, "assistant_card_button");
        return;
    L12:
        return;
    }

    private static final String c(String r2) {
        return "[Share-from-Assistant] url=" + r2;
    }

    public final void b(String r9) {
        d.h.b.o.e(r9, "appPackage");
        if (AOPackagesTools.INSTANCE.openAppOnMainDisplay((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r9) == true) goto L6;
        AOUserInterfaceTools.showAppToast$default(AOUserInterfaceTools.INSTANCE, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.string.obric_assist_card_cannot_open_app, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_assist_card_cannot_open_app"), false, 4, null);
        return;
    }

    public final void a(String r8, String r9, String r10, int r11) {
        d.h.b.o.e(r9, "forSessionId");
        d.h.b.o.e(r10, DownloadConstants.QUERY_KEY);
        AOThreadingTools.INSTANCE.launchIO((d.h.a.m) ZeusTransformUtils.preCheckCast(new a(r8, r9, r10, r11, null), d.h.a.m.class, "com.obric.aiagent.plugin"));
    }

    private final void a(Context r8, String r9, String r10, String r11, String r12, int r13, d.h.a.a<x> r14, d.h.a.b<? super Boolean, x> r15) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        d.h.a.a r16 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r14, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.b r17 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r15, d.h.a.b.class, "com.obric.aiagent.plugin");
        com.obric.autoaction.userreport.a r18 = new com.obric.autoaction.userreport.a(r7);
        r18.a(new com.obric.autoaction.userreport.a.C0604a(r9, r10, r12, r13, r11));
        AOThreadingTools.INSTANCE.launchUI((d.h.a.m) ZeusTransformUtils.preCheckCast(new C0578b(r18, r16, r17, null), d.h.a.m.class, "com.obric.aiagent.plugin"));
    }

    public static /* synthetic */ void a(b r0, String r1, long r2, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r2 = -1;
    L8:
        r0.a(r1, r2);
    }

    public final void a(String r12, long r13) {
        if (AutoActionAgent.INSTANCE.hasOngoingTask() == true) goto L5;
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        Bundle r11 = null;
        if (r13 == (-1)) goto L15;
        r11 = new Bundle();
        r11.putLong("doubao_message_id", r13);
    L15:
        com.obric.autogui.util.ui.a.a(com.obric.autogui.util.ui.a.f31573a, r1, r12, null, null, null, false, 35, r11, 28, null);
        return;
    L5:
        if (f24862c <= 0) goto L10;
        long r14 = AOSystemTools.INSTANCE.nowTimeMillis() - f24862c;
        if (r14 >= WsConstants.EXIT_DELAY_TIME) goto L10;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "relaunch task failed - too frequent! it's only " + r14 + " before last request.");
        return;
    L10:
        f24862c = AOSystemTools.INSTANCE.nowTimeMillis();
        AOUserInterfaceTools.INSTANCE.showAppToast((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.string.obric_assist_card_agent_task_running_cannot_restart, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_assist_card_agent_task_running_cannot_restart"), true);
    }
}
