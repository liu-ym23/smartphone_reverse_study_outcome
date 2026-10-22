package com.obric.autogui.session.state;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.google.gson.JsonObject;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.AutoOperateTask;
import com.obric.autogui.common.api.agent.IAutoActionAgentApi;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.agent.model.CallUserFunctionParams;
import com.obric.autogui.common.api.agent.model.EndStepParams;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.presentation.AOUserInterfaceTools;
import com.obric.autogui.common.api.presentation.api.IAssistInputHost;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.obric.autogui.common.api.virtualdisplay.VDTrackingApp;
import com.obric.autogui.session.functions.impl.vd.VDEventsListenerImpl;
import com.obric.autogui.session.state.holderfile.ISessionFinalizer;
import com.obric.autogui.session.state.holderfile.SHF;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.h.a.m;
import d.h.b.ae;
import d.n;
import d.o;
import d.s;
import d.x;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: AutoActionAgentImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoActionAgentImpl implements IAutoActionAgentApi {
    public static final a Companion = null;
    public static final String KEY_EXTRA_FOLLOWING_QUESTION = "ag_following_question";
    public static final String KEY_EXTRA_FOLLOWING_SESSION_INFO = "ag_following_session_info";
    private static final String TAG = "AA-AgentImpl";
    private final Map<String, Class<? extends com.obric.autogui.session.functions.a>> mFunctionImplClassMap;
    private final Object mInitLock;
    private com.obric.autogui.b mLibAutoGUI;

    /* JADX INFO: compiled from: AutoActionAgentImpl.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: AutoActionAgentImpl.kt */
    @d.c.b.a.f(b = "AutoActionAgentImpl.kt", c = {511}, d = "invokeSuspend", e = "com.obric.autogui.session.state.AutoActionAgentImpl$cleanDanglingTask$1$1")
    static final class b extends d.c.b.a.l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f31164a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f31165b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f31166c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ SHF f31167d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private /* synthetic */ Object f31168e;

        b(SHF r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31167d = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            b r0 = new b(this.f31167d, r5);
            r0.f31168e = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0084 -> B:19:0x0087). Please report as a decompilation issue!!! */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f31166c;
            if (r1 == 0) goto L12;
            if (r1 != 1) goto L11;
            Iterator r2 = (Iterator) ZeusTransformUtils.preCheckCast(this.f31165b, Iterator.class, "com.obric.aiagent.plugin");
            SHF r4 = (SHF) ZeusTransformUtils.preCheckCast(this.f31164a, SHF.class, "com.obric.aiagent.plugin");
            am r5 = (am) ZeusTransformUtils.preCheckCast(this.f31168e, am.class, "com.obric.aiagent.plugin");
            o.a(r10);     // Catch: Throwable -> L8
        L19:
            Object r11 = n.f(d.c.b.a.b.a(((Boolean) ZeusTransformUtils.preCheckCast(r10, Boolean.class, "com.obric.aiagent.plugin")).booleanValue()));     // Catch: Throwable -> L8
        L22:
            Throwable r12 = n.c(r11);
            if (r12 == null) goto L14;
            Loog.INSTANCE.e("SessionFinalizer", "Finalization failed", r12);
        L14:
            if (r2.hasNext() == false) goto L26;
            ISessionFinalizer r13 = (ISessionFinalizer) ZeusTransformUtils.preCheckCast(r2.next(), ISessionFinalizer.class, "com.obric.aiagent.plugin");
            n.a r6 = n.f38560a;     // Catch: Throwable -> L8
            this.f31168e = r5;     // Catch: Throwable -> L8
            this.f31164a = r4;     // Catch: Throwable -> L8
            this.f31165b = r2;     // Catch: Throwable -> L8
            this.f31166c = 1;     // Catch: Throwable -> L8
            r10 = r13.doFinalize(r4, this);     // Catch: Throwable -> L8
            if (r10 != r0) goto L19;
            return r0;
        L26:
            return x.f38692a;
        L8:
            th = move-exception;
            n.a r7 = n.f38560a;
            r11 = n.f(o.a(th));
            goto L22
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            o.a(r10);
            am r14 = (am) ZeusTransformUtils.preCheckCast(this.f31168e, am.class, "com.obric.aiagent.plugin");
            Set r3 = ServiceManager.get().getServices(ISessionFinalizer.class);
            d.h.b.o.c(r3, "getServices(...)");
            Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin");
            r4 = this.f31167d;
            r2 = r8.iterator();
            r5 = r14;
            goto L14
        }
    }

    /* JADX INFO: compiled from: AutoActionAgentImpl.kt */
    @d.c.b.a.f(b = "AutoActionAgentImpl.kt", c = {228}, d = "exitApplyAddition", e = "com.obric.autogui.session.state.AutoActionAgentImpl")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f31169a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f31170b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f31171c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f31172d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ AutoActionAgentImpl f31173e;
        int f;

        c(AutoActionAgentImpl r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31173e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f31172d = r3;
            this.f |= Integer.MIN_VALUE;
            return this.f31173e.exitApplyAddition(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AutoActionAgentImpl.kt */
    @d.c.b.a.f(b = "AutoActionAgentImpl.kt", c = {232}, d = "invokeSuspend", e = "com.obric.autogui.session.state.AutoActionAgentImpl$exitApplyAddition$2")
    static final class d extends d.c.b.a.l implements d.h.a.b<d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f31174a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AutoActionAgentImpl f31175b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f31176c;

        d(AutoActionAgentImpl r3, String r4, d.c.d<? super d> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31175b = r3;
            this.f31176c = r4;
            super(1, r6);
        }

        public final Object a(d.c.d<? super x> r3) {
            return ((d) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f31175b, this.f31176c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f31174a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            AutoActionAgentImpl r7 = this.f31175b;
            String r2 = this.f31176c;
            d.c.d<? super com.obric.autogui.common.e> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31174a = 1;
            if (r7.exitUserAddition(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AutoActionAgentImpl.kt */
    @d.c.b.a.f(b = "AutoActionAgentImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.session.state.AutoActionAgentImpl$exitUserAddition$2")
    static final class e extends d.c.b.a.l implements m<com.obric.autogui.session.functions.impl.d, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f31177a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f31178b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f31179c;

        e(String r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31178b = r3;
            super(2, r5);
        }

        public final Object a(com.obric.autogui.session.functions.impl.d r3, d.c.d<? super x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            e r0 = new e(this.f31178b, r5);
            r0.f31179c = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(com.obric.autogui.session.functions.impl.d r3, d.c.d<? super x> r4) {
            return a((com.obric.autogui.session.functions.impl.d) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.session.functions.impl.d.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f31177a != 0) goto L7;
            o.a(r3);
            ((com.obric.autogui.session.functions.impl.d) ZeusTransformUtils.preCheckCast(this.f31179c, com.obric.autogui.session.functions.impl.d.class, "com.obric.aiagent.plugin")).a(this.f31178b);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AutoActionAgentImpl.kt */
    @d.c.b.a.f(b = "AutoActionAgentImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.session.state.AutoActionAgentImpl$exitUserClarify$2")
    static final class f extends d.c.b.a.l implements m<com.obric.autogui.session.functions.impl.c, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f31180a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f31181b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f31182c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f31183d;

        f(String r3, String r4, d.c.d<? super f> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31181b = r3;
            this.f31182c = r4;
            super(2, r6);
        }

        public final Object a(com.obric.autogui.session.functions.impl.c r3, d.c.d<? super x> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            f r0 = new f(this.f31181b, this.f31182c, r6);
            r0.f31183d = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(com.obric.autogui.session.functions.impl.c r3, d.c.d<? super x> r4) {
            return a((com.obric.autogui.session.functions.impl.c) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.session.functions.impl.c.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f31180a != 0) goto L10;
            o.a(r3);
            com.obric.autogui.session.functions.impl.c r4 = (com.obric.autogui.session.functions.impl.c) ZeusTransformUtils.preCheckCast(this.f31183d, com.obric.autogui.session.functions.impl.c.class, "com.obric.aiagent.plugin");
            r4.a(this.f31181b);
            ConcurrentHashMap<String, Object> r5 = r4.e();
            String r2 = this.f31182c;
            if (r2 != null) goto L7;
            r2 = DownloadSettingKeys.BugFix.DEFAULT;
        L7:
            r5.put("clarify_method", r2);
            return x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AutoActionAgentImpl.kt */
    @d.c.b.a.f(b = "AutoActionAgentImpl.kt", c = {395}, d = "fetchSessionShareUrl", e = "com.obric.autogui.session.state.AutoActionAgentImpl")
    static final class g extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f31184a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f31185b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AutoActionAgentImpl f31186c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f31187d;

        g(AutoActionAgentImpl r3, d.c.d<? super g> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31186c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f31185b = r3;
            this.f31187d |= Integer.MIN_VALUE;
            return this.f31186c.fetchSessionShareUrl(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AutoActionAgentImpl.kt */
    @d.c.b.a.f(b = "AutoActionAgentImpl.kt", c = {410}, d = "fetchSessionShareUrlInternal", e = "com.obric.autogui.session.state.AutoActionAgentImpl")
    static final class h extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f31188a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f31189b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AutoActionAgentImpl f31190c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f31191d;

        h(AutoActionAgentImpl r3, d.c.d<? super h> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31190c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f31189b = r3;
            this.f31191d |= Integer.MIN_VALUE;
            return AutoActionAgentImpl.access$fetchSessionShareUrlInternal(this.f31190c, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AutoActionAgentImpl.kt */
    @d.c.b.a.f(b = "AutoActionAgentImpl.kt", c = {447}, d = "getShareUrlFromRemote", e = "com.obric.autogui.session.state.AutoActionAgentImpl")
    static final class i extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f31192a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f31193b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AutoActionAgentImpl f31194c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f31195d;

        i(AutoActionAgentImpl r3, d.c.d<? super i> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31194c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f31193b = r3;
            this.f31195d |= Integer.MIN_VALUE;
            return AutoActionAgentImpl.access$getShareUrlFromRemote(this.f31194c, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AutoActionAgentImpl.kt */
    @d.c.b.a.f(b = "AutoActionAgentImpl.kt", c = {162}, d = "postUserQuery", e = "com.obric.autogui.session.state.AutoActionAgentImpl")
    static final class j extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f31196a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f31197b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f31198c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ AutoActionAgentImpl f31199d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f31200e;

        j(AutoActionAgentImpl r3, d.c.d<? super j> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31199d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.f31198c = r7;
            this.f31200e |= Integer.MIN_VALUE;
            return this.f31199d.postUserQuery(null, false, null, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AutoActionAgentImpl.kt */
    @d.c.b.a.f(b = "AutoActionAgentImpl.kt", c = {572}, d = "invokeSuspend", e = "com.obric.autogui.session.state.AutoActionAgentImpl$startFunction$2")
    static final class k extends d.c.b.a.l implements m<am, d.c.d<? super com.obric.autogui.common.e>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f31201a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f31202b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.session.a f31203c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Class<? extends com.obric.autogui.session.functions.a> f31204d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private /* synthetic */ Object f31205e;

        k(String r3, com.obric.autogui.session.a r4, Class<? extends com.obric.autogui.session.functions.a> r5, d.c.d<? super k> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31202b = r3;
            this.f31203c = r4;
            this.f31204d = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super com.obric.autogui.common.e> r4) {
            return ((k) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), k.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r5, d.c.d<?> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            k r0 = new k(this.f31202b, this.f31203c, this.f31204d, r7);
            r0.f31205e = r5;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super com.obric.autogui.common.e> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f31201a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r7);
        L11:
            return r7;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            Loog.INSTANCE.i(LogUtil.INSTANCE.getCLAZZ_TAG((am) ZeusTransformUtils.preCheckCast(this.f31205e, am.class, "com.obric.aiagent.plugin")), "start function " + this.f31202b);
            com.obric.autogui.session.functions.c r8 = this.f31203c.n();
            Class<? extends com.obric.autogui.session.functions.a> r2 = this.f31204d;
            d.c.d<? super com.obric.autogui.common.e> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31201a = 1;
            r7 = r8.a(r2, r3);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AutoActionAgentImpl.kt */
    @d.c.b.a.f(b = "AutoActionAgentImpl.kt", c = {591}, d = "invokeSuspend", e = "com.obric.autogui.session.state.AutoActionAgentImpl$stopFunction$2")
    static final class l extends d.c.b.a.l implements m<am, d.c.d<? super com.obric.autogui.common.e>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f31206a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f31207b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.session.a f31208c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Class<? extends com.obric.autogui.session.functions.a> f31209d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private /* synthetic */ Object f31210e;

        l(String r3, com.obric.autogui.session.a r4, Class<? extends com.obric.autogui.session.functions.a> r5, d.c.d<? super l> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31207b = r3;
            this.f31208c = r4;
            this.f31209d = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super com.obric.autogui.common.e> r4) {
            return ((l) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), l.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r5, d.c.d<?> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            l r0 = new l(this.f31207b, this.f31208c, this.f31209d, r7);
            r0.f31210e = r5;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super com.obric.autogui.common.e> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f31206a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r7);
        L11:
            return r7;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            Loog.INSTANCE.i(LogUtil.INSTANCE.getCLAZZ_TAG((am) ZeusTransformUtils.preCheckCast(this.f31210e, am.class, "com.obric.aiagent.plugin")), "stop function " + this.f31207b);
            com.obric.autogui.session.functions.c r8 = this.f31208c.n();
            Class<? extends com.obric.autogui.session.functions.a> r2 = this.f31209d;
            d.c.d<? super com.obric.autogui.common.e> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31206a = 1;
            r7 = r8.b(r2, r3);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ x lambda$064G1BCc59pOPg7_3XMdWZqXKQ8(Context r0, SHF r1, File r2) {
        return cleanDanglingTask$lambda$9(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$skMBIeezIFVTDzBkUi5e3NeGpxY(File r0, SHF r1) {
        cleanDanglingTask$lambda$9$lambda$8(r0, r1);
    }

    public AutoActionAgentImpl() {
        this.mInitLock = new Object();
        this.mFunctionImplClassMap = ao.a(new d.m[]{s.a("CallUser", com.obric.autogui.session.functions.impl.b.class), s.a("Clarify", com.obric.autogui.session.functions.impl.c.class), s.a("ManualOperating", com.obric.autogui.session.functions.impl.a.a.class)});
    }

    public static final /* synthetic */ Object access$fetchSessionShareUrlInternal(AutoActionAgentImpl r2, String r3, d.c.d r4) {
        return r2.fetchSessionShareUrlInternal(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object access$getShareUrlFromRemote(AutoActionAgentImpl r2, String r3, d.c.d r4) {
        return r2.getShareUrlFromRemote(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public void initLib() {
        maybeInitLib();
    }

    private final com.obric.autogui.b maybeInitLib() {
        Object r0 = this.mInitLock;
        monitor-enter(r0);
        com.obric.autogui.b r1 = this.mLibAutoGUI;     // Catch: Throwable -> L11
        if (r1 == null) goto L8;
        monitor-exit(r0);
        return r1;
    L8:
        com.obric.autogui.a r2 = new com.obric.autogui.a();     // Catch: Throwable -> L11
        this.mLibAutoGUI = (com.obric.autogui.b) ZeusTransformUtils.preCheckCast(r2, com.obric.autogui.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        com.obric.autogui.b r4 = (com.obric.autogui.b) ZeusTransformUtils.preCheckCast(r2, com.obric.autogui.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        monitor-exit(r0);
        return r4;
    L11:
        th = move-exception;
        throw th;
    }

    public final com.obric.autogui.b getLib() {
        return this.mLibAutoGUI;
    }

    static /* synthetic */ com.obric.autogui.common.d generateAutoTask$default(AutoActionAgentImpl r0, String r1, boolean r2, Bundle r3, int r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L6;
        r4 = 1;
    L6:
        return r0.generateAutoTask(r1, r2, r3, r4);
    }

    private final com.obric.autogui.common.d<AutoOperateTask> generateAutoTask(String r10, boolean r11, Bundle r12, int r13) {
        AutoOperateTask r0 = new AutoOperateTask();
        if (r11 == false) goto L25;
        IAutoActionAgentEventListener.SessionInfo r14 = com.obric.autogui.session.c.f30777a.c();
        if (r14 != null) goto L8;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "cannot generate auto task (followingLastQuery); no last task found.");
        return com.obric.autogui.common.d.f29012a.a(ZeusTransformUtils.mapRes(R.string.agent_task_not_started_cannot_follow, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_not_started_cannot_follow"));
    L8:
        String r3 = r14.getTask().getUserTask();
        if (r3 != null) goto L13;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "cannot generate auto task (followingLastQuery); last task is not a user-task.");
        return com.obric.autogui.common.d.f29012a.a(ZeusTransformUtils.mapRes(R.string.agent_task_not_started_cannot_follow, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_not_started_cannot_follow"));
    L13:
        if (r14.getSessionId() != null) goto L16;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "cannot generate auto task (followingLastQuery); last task has no sessionId.");
        return com.obric.autogui.common.d.f29012a.a(ZeusTransformUtils.mapRes(R.string.agent_task_not_started_cannot_follow, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_not_started_cannot_follow"));
    L16:
        Object r1 = r14.getTask().getInternalExtras().get(KEY_EXTRA_FOLLOWING_QUESTION);
        if (ae.e(r1) == false) goto L19;
        List r2 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");
    L21:
        if (r2 == null) goto L23;
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(this), " - following: " + r10 + ", which was followedQuery also, sesId=" + r14.getSessionId());
        r2.add(r10);
    L24:
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(this), " - following: " + r2 + ", sesId=" + r14.getSessionId());
        r0.setUserTask(r3);
        Map<String, Object> r9 = r0.getInternalExtras();
        r9.put(KEY_EXTRA_FOLLOWING_SESSION_INFO, r14);
        r9.put(KEY_EXTRA_FOLLOWING_QUESTION, r2);
    L26:
        r0.setTaskExtras(r12);
        r0.setLaunchOrigin(r13);
        return com.obric.autogui.common.d.f29012a.a(r0);
    L23:
        r2 = p.c(new String[]{r10});
        goto L24
    L19:
        r2 = null;
        goto L21
    L25:
        r0.setUserTask(r10);
        goto L26
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public Object postUserQuery(String r8, boolean r9, Bundle r10, int r11, d.c.d<? super com.obric.autogui.common.e> r12) {
        d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r13, j.class) == false) goto L7;
        j r0 = (j) ZeusTransformUtils.preCheckCast(r13, j.class, "com.obric.aiagent.plugin");
        if ((r0.f31200e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f31200e -= Integer.MIN_VALUE;
    L8:
        Object r14 = r0.f31198c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f31200e;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(r0.f31197b, Context.class, "com.obric.aiagent.plugin");
        AutoActionAgentImpl r15 = (AutoActionAgentImpl) ZeusTransformUtils.preCheckCast(r0.f31196a, AutoActionAgentImpl.class, "com.obric.aiagent.plugin");
        o.a(r14);
    L21:
        com.obric.autogui.common.e r16 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r14, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
        if (r16.g() == true) goto L24;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(r15), "failed to post user query: " + r16 + " (" + r16.a(r7) + ')');
    L24:
        return r16;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r14);
        Context r17 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        com.obric.autogui.b r4 = maybeInitLib();
        r4.a(new com.obric.autogui.b.C0722b(r17));
        com.obric.autogui.common.d<AutoOperateTask> r18 = generateAutoTask(r8, r9, r10, r11);
        if (r18.g() == true) goto L17;
        return r18;
    L17:
        AutoOperateTask r19 = r18.a();
        d.h.b.o.a(r19);
        AutoOperateTask r20 = (AutoOperateTask) ZeusTransformUtils.preCheckCast(r19, AutoOperateTask.class, "com.obric.aiagent.plugin");
        r0.f31196a = this;
        r0.f31197b = r17;
        r0.f31200e = 1;
        Object r21 = r4.a(r20, r0);
        if (r21 != r2) goto L20;
        return r2;
    L20:
        r15 = this;
        r7 = r17;
        r14 = r21;
    L7:
        r0 = new j(this, r13);
        goto L8
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public Object userTerminateQuery(String r3, d.c.d<? super com.obric.autogui.common.e> r4) {
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.b r6 = this.mLibAutoGUI;
        if (r6 != null) goto L7;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "cannot terminate query; libautogui is not initialized.");
        return com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_task_not_started_cannot_terminate, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_not_started_cannot_terminate"), null, 2, null);
    L7:
        return r6.a(r3);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public com.obric.autogui.common.e systemTerminateQuery(String r6, String r7, int r8, EndStepParams r9, Map<String, String> r10) {
        Map<String, ? extends Object> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "message");
        d.h.b.o.e(r11, "ext");
        com.obric.autogui.session.a r0 = com.obric.autogui.session.c.f30777a.b();
        if (r0 != null) goto L6;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "cannot enter user-addition; no ongoing session.");
        return com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_task_not_started_cannot_terminate, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_not_started_cannot_terminate"), null, 2, null);
    L6:
        if (r6 != null) goto L8;
    L11:
        r0.J().a(com.obric.autogui.common.e.f29014b.c(r7), r8, r9, r11);
        return com.obric.autogui.common.e.f29014b.a();
    L8:
        if (d.h.b.o.a(r6, r0.a()) == true) goto L11;
        return com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_task_not_started_cannot_terminate, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_not_started_cannot_terminate"), null, 2, null);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public Object enterUserAddition(d.c.d<? super com.obric.autogui.common.e> r3) {
        d.c.d<? super com.obric.autogui.common.e> r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.a r0 = com.obric.autogui.session.c.f30777a.b();
        if (r0 != null) goto L7;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "cannot enter user-addition; no ongoing session.");
        return com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_task_not_started_cannot_user_addition, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_not_started_cannot_user_addition"), null, 2, null);
    L7:
        return r0.n().a(com.obric.autogui.session.functions.impl.d.class, r4);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public Object exitApplyAddition(String r7, d.c.d<? super x> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, c.class) == false) goto L7;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r9, c.class, "com.obric.aiagent.plugin");
        if ((r0.f & Integer.MIN_VALUE) == 0) goto L7;
        r0.f -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.f31172d;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        com.obric.autogui.session.a r6 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r0.f31171c, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        r7 = (String) ZeusTransformUtils.preCheckCast(r0.f31170b, String.class, "com.obric.aiagent.plugin");
        AutoActionAgentImpl r1 = (AutoActionAgentImpl) ZeusTransformUtils.preCheckCast(r0.f31169a, AutoActionAgentImpl.class, "com.obric.aiagent.plugin");
        o.a(r10);
        com.obric.autogui.session.a r11 = r6;
        AutoActionAgentImpl this = r1;
    L23:
        r11.m().a().launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new d(this, r7, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r10);
        r11 = com.obric.autogui.session.c.f30777a.b();
        if (r11 != null) goto L19;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "cannot enter user-addition; no ongoing session.");
        return x.f38692a;
    L19:
        if (r11.n().a(com.obric.autogui.session.functions.impl.d.class) != null) goto L23;
        r0.f31169a = this;
        r0.f31170b = r7;
        r0.f31171c = r11;
        r0.f = 1;
        if (enterUserAddition(r0) != r2) goto L23;
        return r2;
    L7:
        r0 = new c(this, r9);
        goto L8
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public Object exitUserAddition(String r5, d.c.d<? super com.obric.autogui.common.e> r6) {
        d.c.d<? super com.obric.autogui.common.e> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.a r0 = com.obric.autogui.session.c.f30777a.b();
        if (r0 != null) goto L7;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "cannot exit user-addition; no ongoing session.");
        return com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_task_not_started_cannot_user_addition, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_not_started_cannot_user_addition"), null, 2, null);
    L7:
        return r0.n().a(com.obric.autogui.session.functions.impl.d.class, (m) ZeusTransformUtils.preCheckCast(new e(r5, null), m.class, "com.obric.aiagent.plugin"), r7);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public Object exitUserClarify(String r5, String r6, d.c.d<? super com.obric.autogui.common.e> r7) {
        d.c.d<? super com.obric.autogui.common.e> r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.a r0 = com.obric.autogui.session.c.f30777a.b();
        if (r0 != null) goto L6;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "cannot exit user-clarify; no ongoing session.");
        return com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_task_not_started_cannot_user_addition, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_not_started_cannot_user_addition"), null, 2, null);
    L6:
        IAssistInputHost r4 = (IAssistInputHost) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAssistInputHost.class), IAssistInputHost.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L10;
        r4.closeInput();
    L10:
        return r0.n().a(com.obric.autogui.session.functions.impl.c.class, (m) ZeusTransformUtils.preCheckCast(new f(r5, r6, null), m.class, "com.obric.aiagent.plugin"), r8);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public Object intentReply(String r5, d.c.d<? super x> r6) {
        d.c.d<? super x> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.a r0 = com.obric.autogui.session.c.f30777a.b();
        if (r0 != null) goto L7;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "cannot exit user-clarify; no ongoing session.");
        return x.f38692a;
    L7:
        if (((com.obric.autogui.session.functions.impl.c) ZeusTransformUtils.preCheckCast(r0.n().a(com.obric.autogui.session.functions.impl.c.class), com.obric.autogui.session.functions.impl.c.class, "com.obric.aiagent.plugin")) == null) goto L13;
        Object r4 = exitUserClarify(r5, "intent_reply", r7);
        if (r4 != d.c.a.b.a()) goto L12;
        return r4;
    L12:
        return x.f38692a;
    L13:
        com.obric.autogui.session.functions.impl.b r1 = (com.obric.autogui.session.functions.impl.b) ZeusTransformUtils.preCheckCast(r0.n().a(com.obric.autogui.session.functions.impl.b.class), com.obric.autogui.session.functions.impl.b.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L31;
        CallUserFunctionParams r2 = r1.f();
        boolean r3 = true;
        if (r2 != null) goto L18;
    L20:
        r3 = false;
    L21:
        if (r3 == false) goto L27;
        if (r5 != null) goto L24;
        r5 = "";
    L24:
        Object r8 = exitApplyAddition(r5, r7);
        if (r8 != d.c.a.b.a()) goto L29;
        return r8;
    L29:
        return x.f38692a;
    L27:
        Loog.INSTANCE.e(TAG, "can not addition on a not support step");
        goto L29
    L18:
        if (r2.getSupportsUserAddition() != true) goto L20;
    L31:
        return x.f38692a;
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public boolean beforeCallUser() {
        com.obric.autogui.session.a r0 = com.obric.autogui.session.c.f30777a.b();
        if (r0 != null) goto L6;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "cannot enter call-user; no ongoing session.");
        return false;
    L6:
        com.obric.autogui.session.functions.impl.b r1 = (com.obric.autogui.session.functions.impl.b) ZeusTransformUtils.preCheckCast(r0.n().a(com.obric.autogui.session.functions.impl.b.class), com.obric.autogui.session.functions.impl.b.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L11;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "cannot enter call-user; no attached call-user function.");
        return false;
    L11:
        return r1.g();
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public Object enterCallUser(d.c.d<? super com.obric.autogui.common.e> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.a r8 = com.obric.autogui.session.c.f30777a.b();
        if (r8 != null) goto L6;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "cannot enter call-user; no ongoing session.");
        return com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_task_not_started_cannot_call_user, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_not_started_cannot_call_user"), null, 2, null);
    L6:
        com.obric.autogui.session.functions.impl.b r9 = (com.obric.autogui.session.functions.impl.b) ZeusTransformUtils.preCheckCast(r8.n().a(com.obric.autogui.session.functions.impl.b.class), com.obric.autogui.session.functions.impl.b.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L10;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "cannot enter call-user; no attached call-user function.");
        return com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_cannot_call_user_not_entered, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_cannot_call_user_not_entered"), null, 2, null);
    L10:
        r9.e();
        return com.obric.autogui.common.e.f29014b.a();
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public Object exitCallUser(d.c.d<? super com.obric.autogui.common.e> r3) {
        d.c.d<? super com.obric.autogui.common.e> r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.a r0 = com.obric.autogui.session.c.f30777a.b();
        if (r0 != null) goto L7;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "cannot exit call-user; no ongoing session.");
        return com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_task_not_started_cannot_call_user, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_not_started_cannot_call_user"), null, 2, null);
    L7:
        return r0.n().b(com.obric.autogui.session.functions.impl.b.class, r4);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public String getOnGoingSessionKey() {
        com.obric.autogui.session.a r0 = com.obric.autogui.session.c.f30777a.b();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public boolean hasOngoingTask() {
        return com.obric.autogui.session.c.f30777a.a();
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public boolean isOngoingSessionActive() {
        com.obric.autogui.session.a r0 = com.obric.autogui.session.c.f30777a.b();
        if (r0 != null) goto L7;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "cannot check ongoing session active -- no ongoing session.");
        return false;
    L7:
        return r0.L();
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public boolean isOngoingSessionPaused() {
        com.obric.autogui.session.a r2 = com.obric.autogui.session.c.f30777a.b();
        if (r2 != null) goto L7;
        Loog.INSTANCE.e(TAG, "isOngoingSessionPaused -- no ongoing session.");
        return false;
    L7:
        return r2.M();
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public Object fetchSessionShareUrl(String r7, d.c.d<? super IAutoActionAgentApi.SessionShareInfo> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, g.class) == false) goto L7;
        g r0 = (g) ZeusTransformUtils.preCheckCast(r9, g.class, "com.obric.aiagent.plugin");
        if ((r0.f31187d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f31187d -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.f31185b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f31187d;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r0.f31184a, String.class, "com.obric.aiagent.plugin");
        o.a(r10);
    L28:
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.aiagent.plugin");
        if (r11 != null) goto L32;
        return null;
    L32:
        return new IAutoActionAgentApi.SessionShareInfo(r6, r11);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r10);
        if (r7 != null) goto L24;
        IAutoActionAgentEventListener.SessionInfo r12 = com.obric.autogui.session.c.f30777a.c();
        if (r12 != null) goto L20;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "cannot get last session share url -- no last session.");
        return null;
    L20:
        r7 = r12.getSessionId();
        if (r7 != null) goto L24;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "cannot get last session share url -- last session has no sessionId.");
        return null;
    L24:
        r0.f31184a = r7;
        r0.f31187d = 1;
        r10 = fetchSessionShareUrlInternal(r7, r0);
        if (r10 != r2) goto L27;
        return r2;
    L27:
        r6 = r7;
    L7:
        r0 = new g(this, r9);
        goto L8
    }

    private final Object fetchSessionShareUrlInternal(String r12, d.c.d<? super String> r13) {
        d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, h.class) == false) goto L7;
        h r0 = (h) ZeusTransformUtils.preCheckCast(r14, h.class, "com.obric.aiagent.plugin");
        if ((r0.f31191d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f31191d -= Integer.MIN_VALUE;
    L8:
        Object r15 = r0.f31189b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f31191d;
        boolean r5 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        AutoActionAgentImpl this = (AutoActionAgentImpl) ZeusTransformUtils.preCheckCast(r0.f31188a, AutoActionAgentImpl.class, "com.obric.aiagent.plugin");
        o.a(r15);
    L20:
        com.obric.autogui.common.d r16 = (com.obric.autogui.common.d) ZeusTransformUtils.preCheckCast(r15, com.obric.autogui.common.d.class, "com.obric.aiagent.plugin");
        if (r16.g() == true) goto L24;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "cannot get share url -- remote request failed.");
        AOUserInterfaceTools.showAppToast$default(AOUserInterfaceTools.INSTANCE, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.string.agent_task_share_url_fetch_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_share_url_fetch_failed"), false, 4, null);
        return null;
    L24:
        String r17 = (String) ZeusTransformUtils.preCheckCast(r16.a(), String.class, "com.obric.aiagent.plugin");
        CharSequence r18 = (CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.aiagent.plugin");
        if (r18 != null) goto L27;
    L30:
        if (r5 == false) goto L33;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "cannot get share url -- remote response is empty.");
        return "";
    L33:
        return r17;
    L27:
        if (d.o.o.d(r18) == true) goto L30;
        r5 = false;
        goto L30
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r15);
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L17;
        return null;
    L17:
        r0.f31188a = this;
        r0.f31191d = 1;
        r15 = getShareUrlFromRemote(r12, r0);
        if (r15 != r2) goto L20;
        return r2;
    L7:
        r0 = new h(this, r14);
        goto L8
    }

    private final Object getShareUrlFromRemote(String r14, d.c.d<? super com.obric.autogui.common.d<String>> r15) {
        d.c.d r16 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r16, i.class) == false) goto L7;
        i r3 = (i) ZeusTransformUtils.preCheckCast(r16, i.class, "com.obric.aiagent.plugin");
        if ((r3.f31195d & Integer.MIN_VALUE) == 0) goto L7;
        r3.f31195d -= Integer.MIN_VALUE;
    L8:
        Object r17 = r3.f31193b;
        Object r5 = d.c.a.b.a();
        int r6 = r3.f31195d;
        if (r6 == 0) goto L16;
        if (r6 != 1) goto L15;
        AutoActionAgentImpl this = (AutoActionAgentImpl) ZeusTransformUtils.preCheckCast(r3.f31192a, AutoActionAgentImpl.class, "com.obric.aiagent.plugin");
        o.a(r17);     // Catch: Throwable -> L32
    L23:
        com.obric.autogui.tools.api.net.a.InterfaceC0861a r18 = (com.obric.autogui.tools.api.net.a.InterfaceC0861a) ZeusTransformUtils.preCheckCast(r17, com.obric.autogui.tools.api.net.a.InterfaceC0861a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L32
        if (r18.a() == true) goto L27;
        com.obric.autogui.tools.api.net.b r19 = r18.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L32
        r19.b();     // Catch: Throwable -> L32
        Loog.INSTANCE.e(TAG, "getShareUrlFromRemote failed: " + r19.getType());     // Catch: Throwable -> L32
        return com.obric.autogui.common.d.f29012a.a("getShareUrlFromRemote failed: " + r19.getType());
    L27:
        String r110 = (String) ZeusTransformUtils.preCheckCast(r18.c(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L32
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(this), "getShareUrl, response: " + r18 + ", payload: " + r110);     // Catch: Throwable -> L32
        JsonObject r111 = (JsonObject) ZeusTransformUtils.preCheckCast(com.obric.autogui.util.b.f31495a.a().fromJson(r110, JsonObject.class), JsonObject.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L32
        int r112 = r111.get(MonitorConstants.CODE).getAsInt();     // Catch: Throwable -> L32
        String r0 = r111.get("msg").getAsString();     // Catch: Throwable -> L32
        String r1 = r111.get("log_id").getAsString();     // Catch: Throwable -> L32
        String r113 = r111.getAsJsonObject("data").get("share_url").getAsString();     // Catch: Throwable -> L32
        if (r112 == 0) goto L37;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "getShareUrl, request failed: " + r112 + ", " + r0 + ", " + r1);     // Catch: Throwable -> L32
        return com.obric.autogui.common.d.f29012a.a("getShareUrl, request failed: " + r112 + ", " + r0 + ", " + r1);
    L37:
        return com.obric.autogui.common.d.f29012a.a(r113);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        o.a(r17);
        String r114 = com.obric.autogui.a.a.f26086a.c();
        com.obric.autogui.tools.api.net.a r7 = com.obric.autogui.tools.a.a.f31480a.a();
        if (r7 != null) goto L20;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "getShareUrl, client is null");
        return com.obric.autogui.common.d.f29012a.a("getShareUrl, network client is null");
    L20:
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(this), "getShareUrl, full url: " + r114 + "?session_id=" + r14);     // Catch: Throwable -> L32
        String r115 = r114 + "?session_id=" + r14;     // Catch: Throwable -> L32
        Map<String, String> r116 = ao.b();     // Catch: Throwable -> L32
        r3.f31192a = this;     // Catch: Throwable -> L32
        r3.f31195d = 1;     // Catch: Throwable -> L32
        r17 = r7.a(r115, r116, 60000, r3);     // Catch: Throwable -> L32
        if (r17 != r5) goto L23;
        return r5;
    L32:
        th = move-exception;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "getShareUrl, request failed: " + th);
        return com.obric.autogui.common.d.f29012a.a("getShareUrl, request failed: " + th);
    L7:
        r3 = new i(this, r16);
        goto L8
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public com.obric.autogui.common.d<IAutoActionAgentEventListener.AgentStepInfo> getActiveStepInfo() {
        com.obric.autogui.session.a r0 = com.obric.autogui.session.c.f30777a.b();
        if (r0 != null) goto L6;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "etActiveStepInfo() failed -- no ongoing session.");
        return com.obric.autogui.common.d.f29012a.a(ZeusTransformUtils.mapRes(R.string.agent_internal_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_internal_error"));
    L6:
        com.obric.autogui.common.d.a r3 = com.obric.autogui.common.d.f29012a;
        com.obric.autogui.operator.e r1 = r0.r();
        if (r1 == null) goto L9;
        IAutoActionAgentEventListener.AgentStepInfo r2 = r1.T();
    L11:
        return r3.a(r2);
    L9:
        r2 = null;
        goto L11
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public com.obric.autogui.common.d<IAutoActionAgentEventListener.SessionInfo> getOngoingSessionInfo() {
        com.obric.autogui.session.a r0 = com.obric.autogui.session.c.f30777a.b();
        if (r0 != null) goto L7;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "getOngoingSessionInfo() failed -- no ongoing session.");
        return com.obric.autogui.common.d.f29012a.a(ZeusTransformUtils.mapRes(R.string.agent_internal_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_internal_error"));
    L7:
        return com.obric.autogui.common.d.f29012a.a(r0.d());
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public void cleanDanglingTask() {
        final Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.state.holderfile.a.f31409a.a(new $$Lambda$AutoActionAgentImpl$064G1BCc59pOPg7_3XMdWZqXKQ8(r2));
    }

    private static final x cleanDanglingTask$lambda$9(Context r11, final SHF r12, final File r13) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r12, "shf");
        d.h.b.o.e(r13, "file");
        AOThreadingTools.INSTANCE.launchIO((m) ZeusTransformUtils.preCheckCast(new b(r12, null), m.class, "com.obric.aiagent.plugin"));
        new com.obric.autogui.session.state.termination.b(r3, r12.getSessionId(), r12.getSessionKey(), r12.getSessionOrigin(), null, null, r12.getDeviceId(), r12.getAttestationString()).a(new $$Lambda$AutoActionAgentImpl$skMBIeezIFVTDzBkUi5e3NeGpxY(r13, r12));
        Loog.INSTANCE.i(TAG, "finalising dangling task: " + r12.getSessionId() + ", " + r12.getSessionKey());
        return x.f38692a;
    }

    private static final void cleanDanglingTask$lambda$9$lambda$8(File r4, SHF r5) {
        r4.delete();     // Catch: Throwable -> L5
        Loog.INSTANCE.i(TAG, " - dangling-task cleansing: successfully deleted SHF for " + r5.getSessionId());     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Loog.INSTANCE.e(TAG, " - dangling-task cleansing: failed to delete dangling SHF file: " + r4.getAbsolutePath(), th);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public com.obric.autogui.common.d<VDTrackingApp> getTrackingApp() {
        com.obric.autogui.session.a r0 = com.obric.autogui.session.c.f30777a.b();
        if (r0 != null) goto L7;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "getTrackingApp() failed -- no ongoing session.");
        return com.obric.autogui.common.d.f29012a.a(ZeusTransformUtils.mapRes(R.string.agent_internal_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_internal_error"));
    L7:
        return com.obric.autogui.common.d.f29012a.a(VDEventsListenerImpl.Companion.a(r0));
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public Object startFunction(String r9, d.c.d<? super com.obric.autogui.common.e> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.a r0 = com.obric.autogui.session.c.f30777a.b();
        if (r0 != null) goto L6;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "cannot start function " + r9 + "; no ongoing session.");
        return com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_internal_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_internal_error"), null, 2, null);
    L6:
        Class r6 = (Class) ZeusTransformUtils.preCheckCast(this.mFunctionImplClassMap.get(r9), Class.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L11;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "cannot find function " + r9 + "'s impl class.");
        return com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_internal_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_internal_error"), null, 2, null);
    L11:
        return AOThreadingTools.INSTANCE.runIn((AOThreadingTools.AOThreadLauncher) ZeusTransformUtils.preCheckCast(r0.h(), AOThreadingTools.AOThreadLauncher.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(new k(r9, r0, r6, null), m.class, "com.obric.aiagent.plugin"), r11);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public Object stopFunction(String r9, d.c.d<? super com.obric.autogui.common.e> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.a r0 = com.obric.autogui.session.c.f30777a.b();
        if (r0 != null) goto L6;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "cannot stop function " + r9 + "; no ongoing session.");
        return com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_internal_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_internal_error"), null, 2, null);
    L6:
        Class r6 = (Class) ZeusTransformUtils.preCheckCast(this.mFunctionImplClassMap.get(r9), Class.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L11;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "cannot find function " + r9 + "'s impl class.");
        return com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_internal_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_internal_error"), null, 2, null);
    L11:
        return AOThreadingTools.INSTANCE.runIn((AOThreadingTools.AOThreadLauncher) ZeusTransformUtils.preCheckCast(r0.h(), AOThreadingTools.AOThreadLauncher.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(new l(r9, r0, r6, null), m.class, "com.obric.aiagent.plugin"), r11);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public String calcJournalAbsoluteDir(String r2) {
        d.h.b.o.e(r2, "sessionKey");
        File r1 = com.obric.autogui.session.a.c.f30720a.b(r2);
        if (r1.exists() == false) goto L5;
        String r3 = r1.getAbsolutePath();
        d.h.b.o.a(r3);
        return r3;
    L5:
        String r4 = com.obric.autogui.session.a.c.f30720a.a(r2).getAbsolutePath();
        d.h.b.o.a(r4);
        return r4;
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public String calcJournalAbsoluteDir(String r2, String r3) {
        d.h.b.o.e(r3, "sessionKey");
        File r1 = com.obric.autogui.session.a.c.f30720a.b(r2, r3);
        if (r1.exists() == false) goto L5;
        String r4 = r1.getAbsolutePath();
        d.h.b.o.a(r4);
        return r4;
    L5:
        String r5 = com.obric.autogui.session.a.c.f30720a.a(r2, r3).getAbsolutePath();
        d.h.b.o.a(r5);
        return r5;
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public void stopPredicting() {
        com.obric.autogui.session.a r0 = com.obric.autogui.session.c.f30777a.b();
        if (r0 != null) goto L6;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "cannot abandon unfetched steps; no ongoing session.");
        return;
    L6:
        com.obric.autogui.agents.b.f26789a.a().b(r0);
    }
}
