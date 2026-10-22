package com.obric.autoaction.presentation;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.autoaction.app.launcherpage.LauncherPageActivity;
import com.obric.autoaction.vdplayer.VDPlayerActivity;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.AOThermalManager;
import com.obric.autogui.common.api.agent.AutoActionAgent;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.app.IAutoActionHostResProvider;
import com.obric.autogui.common.api.assistant.LaunchMethodClient;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.display.DisplayAccessor;
import com.obric.autogui.common.api.platform.display.DisplayedAppInfo;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.autogui.common.api.presentation.AOUserInterfaceTools;
import com.obric.autogui.common.api.presentation.AssistRemoteCardUIParams;
import com.obric.autogui.common.api.presentation.IAutoActionPresentationApi;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.obric.autogui.effects.VDPlayerEffectProviderImpl;
import com.obric.eventkit.EventsTaskSdk;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.ShortcutTask;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.l;
import d.h.a.m;
import d.n;
import d.o;
import d.x;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import org.json.JSONObject;

/* JADX INFO: compiled from: AutoActionPresentationApiImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoActionPresentationApiImpl implements IAutoActionPresentationApi {
    public static final a Companion = null;
    private static final String SOURCE_FROM_DYNAMIC_ISLAND = "click_dynamic_island";
    private final d.h.a.b<String, x> testRun;
    private final d.h.a.b<String, x> testRunWithQuery;

    /* JADX INFO: compiled from: AutoActionPresentationApiImpl.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: AutoActionPresentationApiImpl.kt */
    @d.c.b.a.f(b = "AutoActionPresentationApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.AutoActionPresentationApiImpl$enterAssistInputMode$1")
    static final class b extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24749a;

        b(d.c.d<? super b> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f24749a != 0) goto L10;
            o.a(r2);
            SurfaceCardActivity r1 = (SurfaceCardActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(j.f25104a.a(), "com.obric.aiagent.plugin"), SurfaceCardActivity.class, "com.obric.aiagent.plugin");
            if (r1 == null) goto L7;
            r1.animateHideCardLayout();
            return x.f38692a;
        L7:
            return null;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AutoActionPresentationApiImpl.kt */
    @d.c.b.a.f(b = "AutoActionPresentationApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.AutoActionPresentationApiImpl$exitAssistInputMode$1")
    static final class c extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24750a;

        c(d.c.d<? super c> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f24750a != 0) goto L10;
            o.a(r2);
            SurfaceCardActivity r1 = (SurfaceCardActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(j.f25104a.a(), "com.obric.aiagent.plugin"), SurfaceCardActivity.class, "com.obric.aiagent.plugin");
            if (r1 == null) goto L7;
            r1.animateShowCardLayout();
            return x.f38692a;
        L7:
            return null;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AutoActionPresentationApiImpl.kt */
    public static final class d implements IAutoActionPresentationApi.IStreamingReplyDisplayingChannel {

        /* JADX INFO: compiled from: AutoActionPresentationApiImpl.kt */
        @d.c.b.a.f(b = "AutoActionPresentationApiImpl.kt", c = {102}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.AutoActionPresentationApiImpl$openStreamingReplyChannel$1$pushThought$1")
        static final class a extends l implements m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f24751a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f24752b;

            a(String r3, d.c.d<? super a> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f24752b = r3;
                super(2, r5);
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f24752b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r7) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f24751a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                o.a(r7);
            L12:
                return x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                o.a(r7);
                com.obric.autoaction.presentation.c r8 = com.obric.autoaction.presentation.c.f24841a;
                String r2 = this.f24752b;
                d.c.d<? super x> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f24751a = 1;
                if (r8.a(r2, false, r4) != r0) goto L12;
                return r0;
            }
        }

        /* JADX INFO: compiled from: AutoActionPresentationApiImpl.kt */
        @d.c.b.a.f(b = "AutoActionPresentationApiImpl.kt", c = {108}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.AutoActionPresentationApiImpl$openStreamingReplyChannel$1$thoughtEnd$1")
        static final class b extends l implements m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f24753a;

            b(d.c.d<? super b> r3) {
                super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
                return (d.c.d) ZeusTransformUtils.preCheckCast(new b((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f24753a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                o.a(r6);
            L12:
                return x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                o.a(r6);
                com.obric.autoaction.presentation.c r7 = com.obric.autoaction.presentation.c.f24841a;
                d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f24753a = 1;
                if (r7.a(null, true, r3) != r0) goto L12;
                return r0;
            }
        }

        d() {
        }

        @Override // com.obric.autogui.common.api.presentation.IAutoActionPresentationApi.IStreamingReplyDisplayingChannel
        public void pushThought(String r3) {
            d.h.b.o.e(r3, VDPlayerEffectProviderImpl.KEY_THOUGHT);
            AOThreadingTools.INSTANCE.launchUI((m) ZeusTransformUtils.preCheckCast(new a(r3, null), m.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.obric.autogui.common.api.presentation.IAutoActionPresentationApi.IStreamingReplyDisplayingChannel
        public void thoughtEnd() {
            AOThreadingTools.INSTANCE.launchUI((m) ZeusTransformUtils.preCheckCast(new b(null), m.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AutoActionPresentationApiImpl.kt */
    @d.c.b.a.f(b = "AutoActionPresentationApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.AutoActionPresentationApiImpl$testRunInternal$1")
    static final class e extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24754a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AutoActionPresentationApiImpl f24755b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f24756c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f24757d;

        e(AutoActionPresentationApiImpl r3, String r4, d.c.d<? super e> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24755b = r3;
            this.f24756c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            e r0 = new e(this.f24755b, this.f24756c, r6);
            r0.f24757d = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            d.c.a.b.a();
            if (this.f24754a != 0) goto L36;
            o.a(r8);
            am r9 = (am) ZeusTransformUtils.preCheckCast(this.f24757d, am.class, "com.obric.aiagent.plugin");
            String r0 = this.f24756c;
            Object r2 = null;
            n.a r3 = n.f38560a;     // Catch: Throwable -> L20
            List r4 = (List) ZeusTransformUtils.preCheckCast(com.obric.autoaction.app.launcherpage.module.datasource.h.f24228a.a().c(), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
            if (r4 == null) goto L17;
            Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L20
        L9:
            if (r5.hasNext() == false) goto L13;
            Object r6 = r5.next();     // Catch: Throwable -> L20
            if (d.h.b.o.a(((com.obric.autoaction.app.launcherpage.module.datasource.f) ZeusTransformUtils.preCheckCast(r6, com.obric.autoaction.app.launcherpage.module.datasource.f.class, "com.obric.aiagent.plugin")).a().getId(), r0) == false) goto L9;
        L14:
            com.obric.autoaction.app.launcherpage.module.datasource.f r1 = (com.obric.autoaction.app.launcherpage.module.datasource.f) ZeusTransformUtils.preCheckCast(r6, com.obric.autoaction.app.launcherpage.module.datasource.f.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
            if (r1 == null) goto L17;
            String r7 = com.obric.autoaction.app.launcherpage.module.datasource.g.a(r1);     // Catch: Throwable -> L20
        L18:
            Object r10 = n.f(r7);     // Catch: Throwable -> L20
        L22:
            Throwable r11 = n.c(r10);
            if (r11 == null) goto L26;
            Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(r9), "get timer task error", r11);
        L26:
            if (n.b(r10) == true) goto L29;
            r2 = r10;
        L29:
            String r12 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
            if (r12 == null) goto L32;
            this.f24755b.postTestRunTaskWithQuery(r12);
        L34:
            return x.f38692a;
        L32:
            Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(r9), "cannot test run " + this.f24756c);
            goto L34
        L13:
            r6 = null;
        L17:
            r7 = null;
        L20:
            th = move-exception;
            n.a r13 = n.f38560a;
            r10 = n.f(o.a(th));
            goto L22
        L36:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a(null);
    }

    /* JADX INFO: renamed from: lambda$-qfqhPVUpozxYfDNSxVzbmpPXlI, reason: not valid java name */
    public static /* synthetic */ String m583lambda$qfqhPVUpozxYfDNSxVzbmpPXlI(String r0, String r1) {
        return openSharingWebView$lambda$3(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$I_IH4H0_kzjJAtFVkyw3F-9NCQI, reason: not valid java name */
    public static /* synthetic */ String m584lambda$I_IH4H0_kzjJAtFVkyw3F9NCQI(String r0) {
        return openSharingWebView$lambda$0(r0);
    }

    /* JADX INFO: renamed from: lambda$Om7D-d9UFBCuWpkxrQZVLyrBg20, reason: not valid java name */
    public static /* synthetic */ x m585lambda$Om7Dd9UFBCuWpkxrQZVLyrBg20(AutoActionPresentationApiImpl r0, String r1) {
        return testRun$lambda$14(r0, r1);
    }

    public static /* synthetic */ x lambda$dd711e0e5EdcN32gYsyOsaekAsk(String r0) {
        return testRunWithQuery$lambda$13(r0);
    }

    public static /* synthetic */ String lambda$evqmkJufk6ziBs0iRZUETGpqVyM() {
        return openSharingWebView$lambda$1();
    }

    public static /* synthetic */ String lambda$h9KXud9rt1_Ib2uJwRSz8C4Uo1A(String r0, String r1, String r2) {
        return openSharingWebView$lambda$2(r0, r1, r2);
    }

    private static final String openSharingWebView$lambda$1() {
        return "openSharingWebView, failed to parse url";
    }

    public AutoActionPresentationApiImpl() {
        this.testRunWithQuery = com.obric.autogui.util.e.a(1000, $$Lambda$AutoActionPresentationApiImpl$dd711e0e5EdcN32gYsyOsaekAsk.INSTANCE);
        this.testRun = com.obric.autogui.util.e.a(1000, new $$Lambda$AutoActionPresentationApiImpl$Om7Dd9UFBCuWpkxrQZVLyrBg20(this));
    }

    private static final String openSharingWebView$lambda$0(String r2) {
        return "openSharingWebView, failed to parse url: " + r2;
    }

    private static final String openSharingWebView$lambda$2(String r2, String r3, String r4) {
        return "opening web view: url=" + r2 + "; ses=" + r3 + ", sourceFrom=" + r4;
    }

    private static final String openSharingWebView$lambda$3(String r2, String r3) {
        return "opening web view: url=; ses=" + r2 + ", sourceFrom=" + r3;
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoActionPresentationApi
    public IAutoActionPresentationApi.IStreamingReplyDisplayingChannel openStreamingReplyChannel() {
        return (IAutoActionPresentationApi.IStreamingReplyDisplayingChannel) ZeusTransformUtils.preCheckCast(new d(), IAutoActionPresentationApi.IStreamingReplyDisplayingChannel.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoActionPresentationApi
    public void openTaskListPage(Context r10, String r11, String r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r13, "context");
        if (d.h.b.o.a(r12, SOURCE_FROM_DYNAMIC_ISLAND) == false) goto L5;
        LaunchMethodClient.INSTANCE.setLaunchMethod(r13, LaunchMethodClient.LAUNCH_METHOD_DYNAMIC_ISLAND);
    L5:
        Intent r9 = IAutoActionPresentationApi.DefaultImpls.getOpenLauncherPageIntent$default((IAutoActionPresentationApi) ZeusTransformUtils.preCheckCast(this, IAutoActionPresentationApi.class, "com.obric.aiagent.plugin"), r13, null, null, r12, 6, null);
        if (r9 == null) goto L8;
        r9.putExtra("tab_tag", "AutomationTab");
        Bundle r14 = new Bundle();
        r14.putString("key_task_id", r11);
        x r15 = x.f38692a;
        r9.putExtra("tab_args", r14);
    L9:
        ZeusTransformUtils.startActivity(r13, r9, "com.obric.aiagent.plugin");
        return;
    L8:
        r9 = null;
        goto L9
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoActionPresentationApi
    public Intent getOpenLauncherPageIntent(Context r2, String r3, String r4, String r5) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "context");
        Intent r6 = new Intent(r1, LauncherPageActivity.class);
        if (r3 == null) goto L5;
        r6.putExtra("session_key", r3);
    L5:
        if (r4 == null) goto L7;
        r6.putExtra("session_id", r4);
    L7:
        JSONObject r7 = new JSONObject();
        if (r5 == null) goto L10;
        r7.put("enter_method", r5);
    L10:
        x r8 = x.f38692a;
        r6.putExtra("log_extras", r7.toString());
        r6.setFlags(268435456);
        return r6;
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoActionPresentationApi
    public void openPlayer(Context r4, String r5, d.h.a.b<? super Intent, x> r6) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        d.h.a.b r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "context");
        if (d.h.b.o.a(r5, SOURCE_FROM_DYNAMIC_ISLAND) == false) goto L5;
        LaunchMethodClient.INSTANCE.setLaunchMethod(r3, LaunchMethodClient.LAUNCH_METHOD_DYNAMIC_ISLAND);
    L5:
        ActivityOptions r8 = ActivityOptions.makeBasic();
        r8.setLaunchDisplayId(0);
        IAutoActionPresentationApi r1 = (IAutoActionPresentationApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionPresentationApi.class), IAutoActionPresentationApi.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L11;
        Intent r9 = r1.getOpenPlayerIntent(r3, r5);
        if (r9 == null) goto L11;
        if (r7 == null) goto L12;
        r7.invoke(r9);
    L12:
        ZeusTransformUtils.startActivity(r3, r9, r8.toBundle(), "com.obric.aiagent.plugin");
        return;
    L11:
        r9 = null;
        goto L12
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoActionPresentationApi
    public Intent getOpenPlayerIntent(Context r2, String r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "context");
        if (com.obric.autogui.common.a.d.f28974a.g() == false) goto L5;
        Intent r4 = new Intent(r1, VDPlayerActivity.class);
    L6:
        r4.setFlags(268435456);
        if (r3 == null) goto L9;
        r4.putExtra("source_from", r3);
    L9:
        return r4;
    L5:
        r4 = new Intent(r1, SurfaceCardActivity.class);
        goto L6
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoActionPresentationApi
    public void stopFloatingWindowService(Context r3) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "context");
        ZeusTransformUtils.stopService(r2, new Intent(r2, FloatingWindowServiceImpl.class), "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoActionPresentationApi
    public void doActionOnFloatingWindowService(Context r3, String r4, Bundle r5) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "action");
        Intent r6 = new Intent(r2, FloatingWindowServiceImpl.class);
        r6.setAction(r4);
        if (r5 == null) goto L5;
        r6.putExtras(r5);
    L5:
        if (r2 == null) goto L8;
        ZeusTransformUtils.startService(r2, r6, "com.obric.aiagent.plugin");
        return;
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoActionPresentationApi
    public void exitClarifyStateInSurfaceActivity(String r3) {
        d.h.b.o.e(r3, "text");
        SurfaceCardActivity r2 = (SurfaceCardActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(j.f25104a.a(), "com.obric.aiagent.plugin"), SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r2.exitClarifyUI(r3);
        return;
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoActionPresentationApi
    public Activity getCurrentShowingPlayer() {
        return (Activity) ZeusTransformUtils.preCheckCast((SurfaceCardActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(j.f25104a.a(), "com.obric.aiagent.plugin"), SurfaceCardActivity.class, "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoActionPresentationApi
    public IAutoActionPresentationApi.PlayerVisibility getPlayerVisibility(Context r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r11, "context");
        String r0 = AOSystemTools.INSTANCE.getHostAppPackage();
        DisplayAccessor r12 = AOPlatformTools.INSTANCE.display().getMDAccess(r11);
        if (r12 != null) goto L6;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "getPlayerVisibility, failed to get MDAccess");
        return IAutoActionPresentationApi.PlayerVisibility.Invisible;
    L6:
        boolean r3 = true;
        DisplayedAppInfo r13 = (DisplayedAppInfo) ZeusTransformUtils.preCheckCast(p.f((Iterable) ZeusTransformUtils.preCheckCast(r12.getTopDisplayedApps(2, true), Iterable.class, "com.obric.aiagent.plugin")), DisplayedAppInfo.class, "com.obric.aiagent.plugin");
        String r2 = null;
        if (r13 == null) goto L9;
        ComponentName r14 = r13.getTopActivity();
    L10:
        IAutoActionHostResProvider r1 = (IAutoActionHostResProvider) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionHostResProvider.class), IAutoActionHostResProvider.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L13;
        String r5 = SurfaceCardActivity.class.getName();
        d.h.b.o.c(r5, "getName(...)");
        String r6 = r1.getStubActivityName(r5);
    L14:
        if (r1 == null) goto L16;
        String r7 = VDPlayerActivity.class.getName();
        d.h.b.o.c(r7, "getName(...)");
        String r4 = r1.getStubActivityName(r7);
    L17:
        if (r14 == null) goto L19;
        String r8 = r14.getPackageName();
    L21:
        if (d.h.b.o.a(r8, r0) == false) goto L33;
        if (r14 == null) goto L24;
        String r9 = r14.getClassName();
    L26:
        if (nonEmptyEquals(r6, r9) == true) goto L32;
        if (r14 == null) goto L29;
        String r15 = r14.getClassName();
    L31:
        if (nonEmptyEquals(r4, r15) == false) goto L33;
    L29:
        r15 = null;
    L32:
        boolean r16 = true;
    L34:
        Loog r17 = Loog.INSTANCE;
        String r18 = LogUtil.INSTANCE.getCLAZZ_TAG(this);
        StringBuilder r19 = new StringBuilder().append("getPlayerVisibility, playerIsTopActivity=").append(r16).append(" recordedTopActivity=");
        if (r14 == null) goto L37;
        String r20 = r14.getClassName();
    L38:
        r17.d(r18, r19.append(r20).append(", realSurfaceCardActivityName=").append(r6).append(" realVDPlayerActivityName=").append(r4).append(' ').toString());
        if (SurfaceCardActivity.Companion.a() == false) goto L41;
    L44:
        if (r3 == false) goto L46;
        if (r14 == null) goto L49;
        r2 = r14.getPackageName();
    L49:
        boolean r21 = d.h.b.o.a(r2, "com.larus.nova");
        if (r14 == null) goto L56;
        if (r16 == true) goto L56;
        if (r21 == true) goto L56;
        return IAutoActionPresentationApi.PlayerVisibility.Invisible;
    L56:
        return IAutoActionPresentationApi.PlayerVisibility.Visible;
    L46:
        return IAutoActionPresentationApi.PlayerVisibility.Invisible;
    L41:
        if (VDPlayerActivity.Companion.a() == true) goto L44;
        r3 = false;
        goto L44
    L37:
        r20 = null;
        goto L38
    L24:
        r9 = null;
    L33:
        r16 = false;
        goto L34
    L19:
        r8 = null;
        goto L21
    L16:
        r4 = null;
        goto L17
    L13:
        r6 = null;
        goto L14
    L9:
        r14 = null;
        goto L10
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoActionPresentationApi
    public Dialog openGlobalInputDialog(Context r15, Integer r16, String r17, String r18, m<? super String, ? super String, x> r19, m<? super String, ? super String, x> r20, String r21, String r22, String r23, String r24, IAutoActionPresentationApi.MemoryKey r25) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r15, Context.class, "com.obric.aiagent.plugin");
        m<? super String, ? super String, x> r7 = (m) ZeusTransformUtils.wrapperContextForParams(r19, m.class, "com.obric.aiagent.plugin");
        m<? super String, ? super String, x> r8 = (m) ZeusTransformUtils.wrapperContextForParams(r20, m.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "context");
        d.h.b.o.e(r17, DBDefinition.TITLE);
        d.h.b.o.e(r18, "content");
        d.h.b.o.e(r7, "onConfirm");
        d.h.b.o.e(r8, "onDismiss");
        return com.obric.autoaction.presentation.d.f24844a.a(r3, r16, r17, r18, r7, r8, r21, r22, r23, r24, r25);
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoActionPresentationApi
    public void enterAssistInputMode() {
        AOThreadingTools.INSTANCE.launchUI((m) ZeusTransformUtils.preCheckCast(new b(null), m.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoActionPresentationApi
    public void exitAssistInputMode() {
        AOThreadingTools.INSTANCE.launchUI((m) ZeusTransformUtils.preCheckCast(new c(null), m.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoActionPresentationApi
    public void postTestRunTaskWithQuery(String r2) {
        d.h.b.o.e(r2, DownloadConstants.QUERY_KEY);
        this.testRunWithQuery.invoke(r2);
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoActionPresentationApi
    public void postTestRunTask(String r2) {
        d.h.b.o.e(r2, "timerTaskId");
        this.testRun.invoke(r2);
    }

    private static final x testRunWithQuery$lambda$13(String r3) {
        d.h.b.o.e(r3, DownloadConstants.QUERY_KEY);
        EventsTaskSdk.INSTANCE.requestSendMessage("试运行：" + r3, "o_auto_test_run", null);
        return x.f38692a;
    }

    private static final x testRun$lambda$14(AutoActionPresentationApiImpl r1, String r2) {
        d.h.b.o.e(r2, "action");
        r1.testRunInternal(r2);
        return x.f38692a;
    }

    private final void testRunInternal(String r9) {
        if (AutoActionAgent.INSTANCE.hasOngoingTask() == false) goto L5;
        AOUserInterfaceTools.INSTANCE.showAppToast((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.string.agent_task_running_cannot_restart, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_running_cannot_restart"), true);
        return;
    L5:
        kotlinx.coroutines.i.a(an.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new e(this, r9, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoActionPresentationApi
    public void openShortCutDetailsPage(Context r8, String r9, String r10, String r11, AssistRemoteCardUIParams r12) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "ctx");
        com.obric.autoaction.app.launcherpage.detail.shortcut.a r1 = com.obric.autoaction.app.launcherpage.detail.shortcut.a.f23480a;
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L5;
    L8:
        boolean r13 = true;
    L9:
        ShortcutTask r3 = null;
        if (r13 == true) goto L13;
        r3 = com.obric.autoaction.app.launcherpage.detail.shortcut.data.e.a(r11, 0, 2, null);
    L13:
        r1.a(r2, r9, r10, (EventTask) ZeusTransformUtils.preCheckCast(r3, EventTask.class, "com.obric.aiagent.plugin"), r12);
        return;
    L5:
        if (r7.length() == 0) goto L8;
        r13 = false;
        goto L9
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoActionPresentationApi
    public void notifyAssistCardUpdate(AssistRemoteCardUIParams r5) {
        d.h.b.o.e(r5, "doubaoCardUIParams");
        Uri r4 = com.obric.autoaction.presentation.doubao.f.f24886a.a(r5.getSessionKey());
        com.obric.aiagent.assistant_card.provider_core.b.f16338a.a(r4, new JSONObject().put("extra_ui_model", com.obric.autoaction.presentation.doubao.j.f24894a.a().toJson(r5)).put("doubao_message_id", r5.getDoubaoMsgId()));
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoActionPresentationApi
    public void initGui(Context r3) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "context");
        com.obric.autoaction.presentation.input.a.f24956a.a();
        Intent r4 = new Intent(r2, FloatingWindowServiceImpl.class);
        AOThermalManager.INSTANCE.resetThermalState();
        ZeusTransformUtils.startService(r2, r4, "com.obric.aiagent.plugin");
    }

    private final boolean nonEmptyEquals(String r3, String r4) {
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        if (r5 == false) goto L11;
        return false;
    L11:
        if (d.h.b.o.a(r3, r4) == true) goto L13;
        return false;
    L13:
        return true;
    L5:
        if (r2.length() == 0) goto L8;
        r5 = false;
        goto L9
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoActionPresentationApi
    public void openSharingWebView(Context r9, final String r10, final String r11, final String r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r13, "context");
        d.h.b.o.e(r10, "url");
        d.h.b.o.e(r11, ObricMemoryConstants.KEY_SESSION_ID);
        final String r14 = Uri.parse(r10).buildUpon().appendQueryParameter("source_from", r12).build().toString();
        d.h.b.o.c(r14, "toString(...)");
        Loog.INSTANCE.dp(LogUtil.INSTANCE.getCLAZZ_TAG(this), new $$Lambda$AutoActionPresentationApiImpl$h9KXud9rt1_Ib2uJwRSz8C4Uo1A(r14, r11, r12), new $$Lambda$AutoActionPresentationApiImpl$qfqhPVUpozxYfDNSxVzbmpPXlI(r11, r12));
        WebActivity.Companion.a(r13, r14, r11, r12);
        IAutoActionTrackingApi r0 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r2 = new JSONObject();
        r2.put("shared_source", r12);
        r2.put("session_id", r11);
        x r8 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r0, "oauto_open_share_page", r2, false, false, null, 28, null);
        return;
    L6:
        th = move-exception;
        Loog.INSTANCE.ep(LogUtil.INSTANCE.getCLAZZ_TAG(this), new $$Lambda$AutoActionPresentationApiImpl$I_IH4H0_kzjJAtFVkyw3F9NCQI(r10), $$Lambda$AutoActionPresentationApiImpl$evqmkJufk6ziBs0iRZUETGpqVyM.INSTANCE, th);
    }
}
