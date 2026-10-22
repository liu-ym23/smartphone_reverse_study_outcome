package com.obric.autogui.session.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.IntentSender;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.agents.vlm.models.impl.applist.black.g;
import com.obric.autogui.agents.vlm.models.omni.r;
import com.obric.autogui.common.api.agent.AutoActionAgent;
import com.obric.autogui.common.api.agent.IAutoActionAgentApi;
import com.obric.autogui.common.api.agent.blacklist.AppBlackListEvent;
import com.obric.autogui.common.api.agent.blacklist.AppBlackListEventHolder;
import com.obric.autogui.common.api.agent.blacklist.AppBlackListState;
import com.obric.autogui.common.api.agent.model.CallUserFunctionParams;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.computercontrol.CCActionResult;
import com.obric.autogui.common.api.platform.computercontrol.CCApplicationAccessResult;
import com.obric.autogui.common.api.platform.computercontrol.CCApplicationAccessState;
import com.obric.autogui.common.api.platform.computercontrol.CCDataResult;
import com.obric.autogui.common.api.platform.computercontrol.CCLifecycleListener;
import com.obric.autogui.common.api.platform.computercontrol.CCSessionAccessor;
import com.obric.autogui.common.api.platform.computercontrol.CCSessionState;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.obric.autogui.common.api.space.OperatingSpaceManager;
import com.obric.autogui.common.api.space.cc.CCSpace;
import com.obric.autogui.session.state.a.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.l;
import d.h.b.h;
import d.h.b.o;
import d.k;
import d.x;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: CCBizLifecycleHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements CCLifecycleListener {
    private static final String TAG = "CCBizLifecycle";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0835a f30744a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autogui.session.a f30745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f30746c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f30747d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicReference<CCSessionAccessor> f30748e;
    private final AtomicReference<String> f;
    private final AtomicReference<CCApplicationAccessState> g;
    private final AtomicReference<String> h;
    private final com.obric.autogui.session.b.d i;

    /* JADX INFO: renamed from: com.obric.autogui.session.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CCBizLifecycleHandler.kt */
    public static final class C0835a {
        public /* synthetic */ C0835a(h r1) {
            this();
        }

        private C0835a() {
        }

        public final a a(com.obric.autogui.session.a r1) {
            o.e(r1, SensitiveType.SESSION);
            if (com.obric.autogui.common.a.c.f28972a.a().c() == true) goto L7;
            return null;
        L7:
            return new a(r1);
        }
    }

    /* JADX INFO: compiled from: CCBizLifecycleHandler.kt */
    @d.c.b.a.f(b = "CCBizLifecycleHandler.kt", c = {728}, d = "invokeSuspend", e = "com.obric.autogui.session.lifecycle.CCBizLifecycleHandler$onApplicationAccessChanged$1")
    static final class b extends l implements d.h.a.b<d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f30749a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f30750b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ CCSessionAccessor f30751c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f30752d;

        b(a r3, CCSessionAccessor r4, String r5, d.c.d<? super b> r6) {
            CCSessionAccessor r7 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r4, CCSessionAccessor.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30750b = r3;
            this.f30751c = r7;
            this.f30752d = r5;
            super(1, r8);
        }

        public final Object a(d.c.d<? super x> r3) {
            return ((b) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f30750b, this.f30751c, this.f30752d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f30749a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            a r8 = this.f30750b;
            CCSessionAccessor r2 = this.f30751c;
            String r3 = this.f30752d;
            d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30749a = 1;
            if (a.a(r8, r2, r3, "FRAMEWORK_CALLBACK", r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: CCBizLifecycleHandler.kt */
    @d.c.b.a.f(b = "CCBizLifecycleHandler.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.session.lifecycle.CCBizLifecycleHandler$onStateChanged$1")
    static final class c extends l implements d.h.a.b<d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f30753a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f30754b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ CCSessionAccessor f30755c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ CCSessionState f30756d;

        c(a r3, CCSessionAccessor r4, CCSessionState r5, d.c.d<? super c> r6) {
            CCSessionAccessor r7 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r4, CCSessionAccessor.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30754b = r3;
            this.f30755c = r7;
            this.f30756d = r5;
            super(1, r8);
        }

        public final Object a(d.c.d<? super x> r3) {
            return ((c) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f30754b, this.f30755c, this.f30756d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            d.c.a.b.a();
            if (this.f30753a != 0) goto L7;
            d.o.a(r4);
            a.a(this.f30754b, this.f30755c, (CCSessionState.Closed) ZeusTransformUtils.preCheckCast(this.f30756d, CCSessionState.Closed.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: CCBizLifecycleHandler.kt */
    @d.c.b.a.f(b = "CCBizLifecycleHandler.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.session.lifecycle.CCBizLifecycleHandler$onUserTakeoverExited$1")
    static final class d extends l implements d.h.a.b<d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f30757a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f30758b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f30759c;

        d(a r3, String r4, d.c.d<? super d> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30758b = r3;
            this.f30759c = r4;
            super(1, r6);
        }

        public final Object a(d.c.d<? super x> r3) {
            return ((d) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f30758b, this.f30759c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f30757a != 0) goto L7;
            d.o.a(r2);
            a.a(this.f30758b, this.f30759c);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: CCBizLifecycleHandler.kt */
    @d.c.b.a.f(b = "CCBizLifecycleHandler.kt", c = {197, 227}, d = "invokeSuspend", e = "com.obric.autogui.session.lifecycle.CCBizLifecycleHandler$requestBlockedApplicationAccessIfAllowed$1")
    static final class e extends l implements d.h.a.b<d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f30760a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f30761b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f30762c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ CCSessionAccessor f30763d;

        e(a r3, String r4, CCSessionAccessor r5, d.c.d<? super e> r6) {
            CCSessionAccessor r7 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r5, CCSessionAccessor.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30761b = r3;
            this.f30762c = r4;
            this.f30763d = r7;
            super(1, r8);
        }

        public final Object a(d.c.d<? super x> r3) {
            return ((e) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f30761b, this.f30762c, this.f30763d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f30760a;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            d.o.a(r10);
        L41:
            return x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            d.o.a(r10);
        L13:
            AppBlackListState r11 = (AppBlackListState) ZeusTransformUtils.preCheckCast(r10, AppBlackListState.class, "com.obric.aiagent.plugin");
            Object r8 = null;
            if (o.a(a.b(this.f30761b).get(), this.f30762c) == true) goto L21;
            Loog r12 = Loog.INSTANCE;
            StringBuilder r2 = new StringBuilder().append("event=access_and_mock_call_user_skipped origin=PUSH sessionKey=").append(a.c(this.f30761b)).append(" ccDisplayId=");
            CCSessionAccessor r3 = this.f30763d;
            if (r3 == null) goto L18;
            r8 = d.c.b.a.b.a(r3.getDisplayId());
        L18:
            r12.i("CCAppAccess", r2.append(r8).append(" packageName=").append(this.f30762c).append(" reason=StaleRequest").toString());
            return x.f38692a;
        L21:
            if (com.obric.autogui.session.b.b.a(r11) == false) goto L27;
            Loog r4 = Loog.INSTANCE;
            StringBuilder r5 = new StringBuilder().append("event=access_and_mock_call_user_skipped origin=PUSH sessionKey=").append(a.c(this.f30761b)).append(" ccDisplayId=");
            CCSessionAccessor r6 = this.f30763d;
            if (r6 == null) goto L25;
            r8 = d.c.b.a.b.a(r6.getDisplayId());
        L25:
            r4.i("CCAppAccess", r5.append(r8).append(" packageName=").append(this.f30762c).append(" reason=AppBlackList blackListState=").append(r11).toString());
            return x.f38692a;
        L27:
            CCApplicationAccessResult r13 = a.a(this.f30761b, this.f30763d, this.f30762c);
            AtomicReference r7 = a.d(this.f30761b);
            if (r13 == null) goto L30;
            CCApplicationAccessState r9 = r13.getState();
        L31:
            r7.set(r9);
            if (r13 == null) goto L35;
            r8 = r13.getState();
        L35:
            if (r8 != CCApplicationAccessState.DeniedBlacklist) goto L39;
            a r14 = this.f30761b;
            CCSessionAccessor r15 = this.f30763d;
            String r16 = this.f30762c;
            d.c.d r17 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30760a = 2;
            if (a.a(r14, r15, r16, "PUSH_SYNC", r17) != r0) goto L41;
            return r0;
        L39:
            a.e(this.f30761b);
            goto L41
        L30:
            r9 = null;
            goto L31
        L10:
            d.o.a(r10);
            g r18 = g.f27362a;
            Context r19 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a.a(this.f30761b).getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            String r20 = this.f30762c;
            d.c.d<? super AppBlackListState> r21 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30760a = 1;
            r10 = r18.a(r19, r20, r21);
            if (r10 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: compiled from: CCBizLifecycleHandler.kt */
    @d.c.b.a.f(b = "CCBizLifecycleHandler.kt", c = {499}, d = "invokeSuspend", e = "com.obric.autogui.session.lifecycle.CCBizLifecycleHandler$requestBlockedCallUser$2")
    static final class f extends l implements d.h.a.b<d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f30764a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f30765b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f30766c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f30767d;

        f(a r3, String r4, String r5, d.c.d<? super f> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30765b = r3;
            this.f30766c = r4;
            this.f30767d = r5;
            super(1, r7);
        }

        /* JADX INFO: renamed from: lambda$DBpwbbqOzK0FmjAURleLqQ-vh6w, reason: not valid java name */
        public static /* synthetic */ x m882lambda$DBpwbbqOzK0FmjAURleLqQvh6w(String r0, String r1, com.obric.autogui.session.functions.impl.b r2) {
            return a(r0, r1, r2);
        }

        public final Object a(d.c.d<? super x> r3) {
            return ((f) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f30765b, this.f30766c, this.f30767d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r20) {
            Object r1 = d.c.a.b.a();
            int r2 = this.f30764a;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            d.o.a(r20);
            Object r3 = r20;
        L11:
            com.obric.autogui.common.e r4 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
            Loog.INSTANCE.i("CCAppAccess", "event=mock_call_user_attach_scheduled sessionKey=" + a.c(this.f30765b) + " result=" + r4);
            if (r4.g() == true) goto L15;
            com.obric.autogui.session.b.e.a(com.obric.autogui.session.b.e.f30776a, "fallback_call_user", "AttachRejected", a.a(this.f30765b), (CCSessionAccessor) ZeusTransformUtils.preCheckCast(a.f(this.f30765b).get(), CCSessionAccessor.class, "com.obric.aiagent.plugin"), null, null, null, null, null, null, null, 2032, null);
        L15:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r20);
            com.obric.autogui.session.functions.c r5 = a.a(this.f30765b).n();
            final String r6 = this.f30766c;
            final String r7 = this.f30767d;
            d.h.a.b r8 = new $$Lambda$a$f$DBpwbbqOzK0FmjAURleLqQvh6w(r6, r7);
            d.c.d<? super com.obric.autogui.common.e> r9 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30764a = 1;
            r3 = r5.a(com.obric.autogui.session.functions.impl.b.class, r8, r9);
            if (r3 != r1) goto L11;
            return r1;
        }

        private static final x a(String r9, String r10, com.obric.autogui.session.functions.impl.b r11) {
            r11.a(new CallUserFunctionParams(false, r9, r10, "cc_application_access", null, 16, null));
            return x.f38692a;
        }
    }

    static {
        f30744a = new C0835a(null);
    }

    public static /* synthetic */ x lambda$WHup1gi5Upgo8yRMN0R_heHaG9I(String r0, String r1, r r2) {
        return a(r0, r1, r2);
    }

    public a(com.obric.autogui.session.a r2) {
        o.e(r2, "aoSession");
        this.f30745b = r2;
        this.f30746c = new AtomicBoolean(false);
        this.f30747d = new AtomicBoolean(false);
        this.f30748e = new AtomicReference(null);
        this.f = new AtomicReference(null);
        this.g = new AtomicReference(null);
        this.h = new AtomicReference(null);
        this.i = new com.obric.autogui.session.b.d();
    }

    public static final /* synthetic */ CCApplicationAccessResult a(a r2, CCSessionAccessor r3, String r4) {
        return r2.b((CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin"), r4);
    }

    public static final /* synthetic */ com.obric.autogui.session.a a(a r0) {
        return r0.f30745b;
    }

    public static final /* synthetic */ Object a(a r2, CCSessionAccessor r3, String r4, String r5, d.c.d r6) {
        return r2.a((CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin"), r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(a r2, CCSessionAccessor r3, CCSessionState.Closed r4) {
        r2.a((CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin"), r4);
    }

    public static final /* synthetic */ void a(a r0, String r1) {
        r0.c(r1);
    }

    public static final /* synthetic */ AtomicReference b(a r0) {
        return r0.f;
    }

    public static final /* synthetic */ String c(a r0) {
        return r0.a();
    }

    public static final /* synthetic */ AtomicReference d(a r0) {
        return r0.g;
    }

    public static final /* synthetic */ void e(a r0) {
        r0.c();
    }

    public static final /* synthetic */ AtomicReference f(a r0) {
        return r0.f30748e;
    }

    private final String a() {
        return this.f30745b.a();
    }

    private final String b() {
        return this.f30745b.b();
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.CCLifecycleListener
    public void onStateChanged(CCSessionAccessor r16, CCSessionState r17) {
        CCSessionAccessor r4 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r16, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r17, "state");
        if (r4 == null) goto L5;
        this.f30748e.set(r4);
    L5:
        Loog r1 = Loog.INSTANCE;
        StringBuilder r3 = new StringBuilder().append("ComputerControl lifecycle changed: sessionKey=").append(a()).append(", sessionId=").append(b()).append(", ccDisplayId=");
        if (r4 == null) goto L8;
        Integer r7 = Integer.valueOf(r4.getDisplayId());
    L9:
        r1.i(TAG, r3.append(r7).append(", state=").append(a(r17)).toString());
        if (ZeusTransformUtils.instanceOf(r17, CCSessionState.Blocked.class) == false) goto L18;
        a(r4, true);
        if (((CCSessionState.Blocked) ZeusTransformUtils.preCheckCast(r17, CCSessionState.Blocked.class, "com.obric.aiagent.plugin")).getReason() != 2) goto L15;
        a(r4, ((CCSessionState.Blocked) ZeusTransformUtils.preCheckCast(r17, CCSessionState.Blocked.class, "com.obric.aiagent.plugin")).getPackageName());
        return;
    L15:
        if (((CCSessionState.Blocked) ZeusTransformUtils.preCheckCast(r17, CCSessionState.Blocked.class, "com.obric.aiagent.plugin")).getReason() == 3) goto L28;
        com.obric.autogui.session.b.e.a(com.obric.autogui.session.b.e.f30776a, "session_lifecycle", "UnexpectedBlockedReason", this.f30745b, r4, r17, null, null, null, null, null, null, 2016, null);
        return;
    L28:
        return;
    L18:
        if (o.a(r17, CCSessionState.Active.INSTANCE) == false) goto L21;
        a(r4, false);
        this.f30746c.set(false);
        this.f.set(null);
        this.g.set(null);
        this.h.set(null);
        return;
    L21:
        if (ZeusTransformUtils.instanceOf(r17, CCSessionState.Closed.class) == false) goto L24;
        this.f30745b.m().a().launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new c(this, r4, r17, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
        return;
    L24:
        if (ZeusTransformUtils.instanceOf(r17, CCSessionState.CreationFailed.class) == false) goto L32;
        com.obric.autogui.session.b.e.a(com.obric.autogui.session.b.e.f30776a, "session_lifecycle", "CreationFailed", this.f30745b, r4, r17, null, null, null, null, null, null, 2016, null);
        return;
    L32:
        return;
    L8:
        r7 = null;
        goto L9
    }

    private final void a(CCSessionAccessor r25, CCSessionState.Closed r26) {
        CCSessionAccessor r1 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r25, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.state.termination.a r4 = this.f30745b.J();
        com.obric.autogui.session.state.a r3 = this.f30745b.m().e();
        com.obric.autogui.session.b.d r5 = this.i;
        if (r1 == null) goto L5;
        boolean r8 = true;
    L6:
        Integer r9 = r26.getReason();
        if (com.obric.autogui.session.c.f30777a.b() != this.f30745b) goto L9;
        boolean r10 = true;
    L11:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autogui.session.state.a.c.class) == false) goto L13;
    L16:
        boolean r11 = true;
    L17:
        com.obric.autogui.session.b.c r6 = r5.a(r8, r9, r10, r11, r4.e());
        Integer r17 = null;
        if (r6 != com.obric.autogui.session.b.c.g) goto L20;
        com.obric.autogui.common.e.a r7 = com.obric.autogui.common.e.f29014b;
        String r12 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f30745b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.std_model_cc_session_closed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "std_model_cc_session_closed"));
        o.c(r12, "getString(...)");
        com.obric.autogui.common.e r18 = com.obric.autogui.session.state.termination.a.a(r4, r7.c(r12), 107002, null, null, 12, null);
        this.f30745b.k().i();
        com.obric.autogui.session.b.e.a(com.obric.autogui.session.b.e.f30776a, "session_lifecycle", "UnexpectedClosed", this.f30745b, r1, (CCSessionState) ZeusTransformUtils.preCheckCast(r26, CCSessionState.class, "com.obric.aiagent.plugin"), null, null, null, null, null, null, 2016, null);
        Loog r13 = Loog.INSTANCE;
        StringBuilder r0 = new StringBuilder().append("event=cc_session_closed_termination_result sessionKey=").append(a()).append(" ccDisplayId=");
        if (r1 == null) goto L30;
        r17 = Integer.valueOf(r1.getDisplayId());
    L30:
        r13.i(TAG, r0.append(r17).append(" closeReason=").append(r26.getReason()).append(" accepted=").append(r18.g()).toString());
        return;
    L20:
        if (r6.a() == false) goto L22;
        this.f30745b.k().i();
    L22:
        Loog r2 = Loog.INSTANCE;
        StringBuilder r14 = new StringBuilder().append("event=cc_session_closed_termination_skipped sessionKey=").append(a()).append(" ccDisplayId=");
        if (r1 == null) goto L25;
        r17 = Integer.valueOf(r1.getDisplayId());
    L25:
        r2.i(TAG, r14.append(r17).append(" closeReason=").append(r26.getReason()).append(" aoState=").append(r3.b()).append(" reason=").append(r6).toString());
        return;
    L13:
        if (ZeusTransformUtils.instanceOf(r3, j.class) == true) goto L16;
        r11 = false;
        goto L17
    L9:
        r10 = false;
        goto L11
    L5:
        r8 = false;
        goto L6
    }

    private final void a(CCSessionAccessor r5, String r6) {
        CCSessionAccessor r7 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r5, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        b(r7, r6);
        c();
        return;
    L12:
        String r8 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        Integer r2 = null;
        if (o.a((String) ZeusTransformUtils.preCheckCast(this.f.getAndSet(r8), String.class, "com.obric.aiagent.plugin"), r8) == false) goto L19;
        Loog r3 = Loog.INSTANCE;
        StringBuilder r4 = new StringBuilder().append("event=access_and_mock_call_user_skipped origin=PUSH sessionKey=").append(a()).append(" ccDisplayId=");
        if (r7 == null) goto L17;
        r2 = Integer.valueOf(r7.getDisplayId());
    L17:
        r3.i("CCAppAccess", r4.append(r2).append(" packageName=").append(r8).append(" reason=AlreadyHandling").toString());
        return;
    L19:
        this.g.set(null);
        this.h.set(null);
        this.f30745b.h().launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new e(this, r8, r7, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        if (d.o.o.d(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    public final void a(String r17) {
        o.e(r17, "takeoverSource");
        CCSessionAccessor r4 = (CCSessionAccessor) ZeusTransformUtils.preCheckCast(this.f30748e.get(), CCSessionAccessor.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L6;
        Loog.INSTANCE.w("CCAppAccess", "event=takeover_enter_notify_blocked_skipped sessionKey=" + a() + " takeoverSource=" + r17 + " reason=MissingCCSession");
        return;
    L6:
        CCSessionState r7 = r4.getState();
        if (o.a(r7, CCSessionState.Active.INSTANCE) == true) goto L10;
        Loog.INSTANCE.i("CCAppAccess", "event=takeover_enter_notify_blocked_skipped sessionKey=" + a() + " ccDisplayId=" + r4.getDisplayId() + " takeoverSource=" + r17 + " reason=SessionNotActive frameworkSessionState=" + a(r7));
        return;
    L10:
        Loog.INSTANCE.i("CCAppAccess", "event=takeover_enter_notify_blocked_start sessionKey=" + a() + " ccDisplayId=" + r4.getDisplayId() + " takeoverSource=" + r17 + " frameworkSessionState=" + a(r7));
        CCActionResult r1 = AOPlatformTools.INSTANCE.computerControl().notifyBlocked(r4);
        if (o.a(r1, CCActionResult.Success.INSTANCE) == false) goto L14;
        Loog.INSTANCE.i("CCAppAccess", "event=takeover_enter_notify_blocked_sync_result sessionKey=" + a() + " ccDisplayId=" + r4.getDisplayId() + " takeoverSource=" + r17 + " result=Success frameworkSessionState=" + a(r4.getState()));
        return;
    L14:
        if (ZeusTransformUtils.instanceOf(r1, CCActionResult.Failed.class) == false) goto L18;
        Loog.INSTANCE.e("CCAppAccess", "event=takeover_enter_notify_blocked_sync_result sessionKey=" + a() + " ccDisplayId=" + r4.getDisplayId() + " takeoverSource=" + r17 + " result=Failed reason=" + ((CCActionResult.Failed) ZeusTransformUtils.preCheckCast(r1, CCActionResult.Failed.class, "com.obric.aiagent.plugin")).getReason() + " frameworkSessionState=" + a(r4.getState()), ((CCActionResult.Failed) ZeusTransformUtils.preCheckCast(r1, CCActionResult.Failed.class, "com.obric.aiagent.plugin")).getThrowable());
        com.obric.autogui.session.b.e.a(com.obric.autogui.session.b.e.f30776a, "takeover_notify_blocked", ((CCActionResult.Failed) ZeusTransformUtils.preCheckCast(r1, CCActionResult.Failed.class, "com.obric.aiagent.plugin")).getReason().name(), this.f30745b, r4, null, r17, null, null, null, null, ((CCActionResult.Failed) ZeusTransformUtils.preCheckCast(r1, CCActionResult.Failed.class, "com.obric.aiagent.plugin")).getThrowable(), 976, null);
        return;
    L18:
        throw new k();
    }

    public final void b(String r4) {
        o.e(r4, "takeoverSource");
        this.f30745b.m().a().launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new d(this, r4, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi] */
    /* JADX WARN: Type inference failed for: r14v1, types: [com.obric.autogui.common.api.platform.computercontrol.CCSessionAccessor] */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r16v0, types: [com.obric.autogui.common.api.platform.computercontrol.CCSessionAccessor] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.obric.autogui.session.b.a] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r24v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r25v0, types: [com.obric.autogui.session.b.a] */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    private final void c(String r26) {
        ?? r1 = this;
        String r15 = r26;
        ?? r14 = (CCSessionAccessor) ZeusTransformUtils.preCheckCast(r1.f30748e.get(), CCSessionAccessor.class, "com.obric.aiagent.plugin");
        Object r13 = " takeoverSource=";
        String r12 = "CCAppAccess";
        if (r14 != 0) goto L6;
        Loog.INSTANCE.w("CCAppAccess", "event=takeover_exit_unblock_request_skipped sessionKey=" + a() + " takeoverSource=" + r15 + " reason=MissingCCSession");
        return;
    L6:
        CCSessionState r2 = r14.getState();
        String r11 = " ccDisplayId=";
        if (ZeusTransformUtils.instanceOf(r2, CCSessionState.Blocked.class) == true) goto L11;
        Loog.INSTANCE.i("CCAppAccess", "event=takeover_exit_unblock_request_skipped sessionKey=" + a() + " ccDisplayId=" + r14.getDisplayId() + " takeoverSource=" + r15 + " reason=SessionNotBlocked frameworkSessionState=" + r1.a(r2));
        return;
    L11:
        if (r1.g.get() != CCApplicationAccessState.DeniedBlacklist) goto L14;
        Loog.INSTANCE.i("CCAppAccess", "event=takeover_exit_unblock_request_skipped sessionKey=" + a() + " ccDisplayId=" + r14.getDisplayId() + " takeoverSource=" + r15 + " reason=AccessDeniedBlacklist frameworkSessionState=" + r1.a(r2));
        return;
    L14:
        String r10 = " frameworkSessionState=";
        Loog.INSTANCE.i("CCAppAccess", "event=takeover_exit_unblock_request_start sessionKey=" + a() + " ccDisplayId=" + r14.getDisplayId() + " takeoverSource=" + r15 + " frameworkSessionState=" + r1.a(r2));
        CCActionResult r0 = AOPlatformTools.INSTANCE.computerControl().requestUnblock(r14);     // Catch: Throwable -> L28
        if (o.a(r0, CCActionResult.Success.INSTANCE) == false) goto L32;
        Loog.INSTANCE.i("CCAppAccess", "event=takeover_exit_unblock_sync_result sessionKey=" + a() + " ccDisplayId=" + r14.getDisplayId() + " takeoverSource=" + r15 + " result=Success frameworkSessionState=" + r1.a(r14.getState()));     // Catch: Throwable -> L28
        r13 = r13;
        r14 = r14;
    L33:
        return;
    L32:
        if (ZeusTransformUtils.instanceOf(r0, CCActionResult.Failed.class) == false) goto L25;
        Loog.INSTANCE.e("CCAppAccess", "event=takeover_exit_unblock_sync_result sessionKey=" + a() + " ccDisplayId=" + r14.getDisplayId() + " takeoverSource=" + r15 + " result=Failed reason=" + ((CCActionResult.Failed) ZeusTransformUtils.preCheckCast(r0, CCActionResult.Failed.class, "com.obric.aiagent.plugin")).getReason() + " frameworkSessionState=" + r1.a(r14.getState()), ((CCActionResult.Failed) ZeusTransformUtils.preCheckCast(r0, CCActionResult.Failed.class, "com.obric.aiagent.plugin")).getThrowable());     // Catch: Throwable -> L28
        r1.a(r14, r15, "SyncFailed/" + ((CCActionResult.Failed) ZeusTransformUtils.preCheckCast(r0, CCActionResult.Failed.class, "com.obric.aiagent.plugin")).getReason());     // Catch: Throwable -> L28
        com.obric.autogui.session.b.e r3 = com.obric.autogui.session.b.e.f30776a;     // Catch: Throwable -> L28
        String r5 = ((CCActionResult.Failed) ZeusTransformUtils.preCheckCast(r0, CCActionResult.Failed.class, "com.obric.aiagent.plugin")).getReason().name();     // Catch: Throwable -> L28
        com.obric.autogui.session.a r6 = r1.f30745b;     // Catch: Throwable -> L28
        r10 = null;
        r11 = null;
        r12 = null;
        Throwable r16 = ((CCActionResult.Failed) ZeusTransformUtils.preCheckCast(r0, CCActionResult.Failed.class, "com.obric.aiagent.plugin")).getThrowable();     // Catch: Throwable -> L28
        r14 = 976(0x3d0, float:1.368E-42);
        r15 = null;
        com.obric.autogui.session.b.e.a(r3, "takeover_request_unblock", r5, r6, r14, null, r26, null, null, null, null, r16, 976, null);     // Catch: Throwable -> L26
        r13 = r16;
        goto L33
    L25:
        throw new k();     // Catch: Throwable -> L26
    L26:
        th = th;
    L30:
        Throwable r17 = th;
        Loog.INSTANCE.e(r23, "event=takeover_exit_unblock_exception sessionKey=" + a() + r22 + r16.getDisplayId() + r24 + r1 + r21 + a(r16.getState()), r17);
        a(r16, r1, "Exception/" + r17.getClass().getSimpleName());
        com.obric.autogui.session.b.e.a(com.obric.autogui.session.b.e.f30776a, "takeover_request_unblock", "Exception", this.f30745b, r16, null, r26, null, null, null, null, r17, 976, null);
        return;
    L28:
        th = th;
        String r21 = r10;
        String r22 = r11;
        String r23 = r12;
        ?? r24 = r13;
        ?? r18 = r14;
        r1 = r15;
        goto L30
    }

    private final void a(CCSessionAccessor r10, String r11, String r12) {
        CCSessionAccessor r13 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r10, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        CCSessionState r0 = r13.getState();
        if (ZeusTransformUtils.instanceOf(r0, CCSessionState.Blocked.class) == true) goto L6;
        Loog.INSTANCE.i("CCAppAccess", "event=takeover_exit_unblock_fallback_call_user_skipped sessionKey=" + a() + " ccDisplayId=" + r13.getDisplayId() + " takeoverSource=" + r11 + " failureReason=" + r12 + " reason=SessionNotBlocked frameworkSessionState=" + a(r0));
        return;
    L6:
        Loog.INSTANCE.i("CCAppAccess", "event=takeover_exit_unblock_fallback_call_user_requested sessionKey=" + a() + " ccDisplayId=" + r13.getDisplayId() + " takeoverSource=" + r11 + " failureReason=" + r12 + " previousRequestCleared=" + this.f30746c.getAndSet(false) + " frameworkSessionState=" + a(r0));
        c();
    }

    private final void a(CCSessionAccessor r5, boolean r6) {
        CCSessionAccessor r7 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r5, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        if (r6 == false) goto L5;
    L7:
        AOOperatingSpace r0 = OperatingSpaceManager.INSTANCE.getActiveSpace();
        Integer r3 = null;
        if (ZeusTransformUtils.instanceOf(r0, CCSpace.class) == false) goto L10;
        CCSpace r1 = (CCSpace) ZeusTransformUtils.preCheckCast(r0, CCSpace.class, "com.obric.aiagent.plugin");
    L11:
        if (r1 != null) goto L13;
    L17:
        Loog r2 = Loog.INSTANCE;
        StringBuilder r4 = new StringBuilder().append("event=screenshot_policy_update_skipped sessionKey=").append(a()).append(" ccDisplayId=");
        if (r7 == null) goto L20;
        r3 = Integer.valueOf(r7.getDisplayId());
    L20:
        r2.w("CCAppAccess", r4.append(r3).append(" blocked=").append(r6).append(" reason=ActiveSpaceMismatch").toString());
        return;
    L13:
        if (r1.getSessionAccessor() != r7) goto L17;
        r1.setScreenshotBlockedByBusiness(r6);
        this.f30747d.set(r6);
        return;
    L10:
        r1 = null;
        goto L11
    L5:
        if (this.f30747d.get() == true) goto L7;
    }

    private final void c() {
        if (this.f30745b.n().b(com.obric.autogui.session.functions.impl.a.a.class) == false) goto L7;
        Loog.INSTANCE.i("CCAppAccess", "event=mock_call_user_skipped sessionKey=" + a() + " reason=AlreadyManualOperating");
        return;
    L7:
        if (this.f30746c.compareAndSet(false, true) == true) goto L10;
        Loog.INSTANCE.i("CCAppAccess", "event=mock_call_user_skipped sessionKey=" + a() + " reason=AlreadyRequested");
        return;
    L10:
        final String r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f30745b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.std_model_dpc_perm_call_user_thought_generic, WsChannelMultiProcessSharedProvider.STRING_TYPE, "std_model_dpc_perm_call_user_thought_generic"));
        o.c(r0, "getString(...)");
        final String r4 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f30745b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.std_model_dpc_perm_call_user_action, WsChannelMultiProcessSharedProvider.STRING_TYPE, "std_model_dpc_perm_call_user_action"));
        o.c(r4, "getString(...)");
        this.f30745b.a(new $$Lambda$a$WHup1gi5Upgo8yRMN0R_heHaG9I(r0, r4));
        Loog.INSTANCE.i("CCAppAccess", "event=mock_call_user_requested sessionKey=" + a());
        this.f30745b.h().launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new f(this, r4, r0, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    private static final x a(String r1, String r2, r r3) {
        o.e(r3, "it");
        r3.b(r1, p.a(r2));
        return x.f38692a;
    }

    private final CCApplicationAccessResult b(CCSessionAccessor r25, String r26) {
        CCSessionAccessor r14 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r25, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L22;
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r26, CharSequence.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == true) goto L22;
        Loog.INSTANCE.i("CCAppAccess", "event=access_request_start origin=PUSH sessionKey=" + a() + " ccDisplayId=" + r14.getDisplayId() + " packageName=" + r26 + " reasonTag=blocked");
        CCDataResult<CCApplicationAccessResult> r3 = AOPlatformTools.INSTANCE.computerControl().requestApplicationAccess(r14, r26);
        if (ZeusTransformUtils.instanceOf(r3, CCDataResult.Success.class) == false) goto L17;
        Loog.INSTANCE.i("CCAppAccess", "event=access_sync_result origin=PUSH sessionKey=" + a() + " ccDisplayId=" + r14.getDisplayId() + " packageName=" + r26 + " state=" + ((CCApplicationAccessResult) ZeusTransformUtils.preCheckCast(((CCDataResult.Success) ZeusTransformUtils.preCheckCast(r3, CCDataResult.Success.class, "com.obric.aiagent.plugin")).getData(), CCApplicationAccessResult.class, "com.obric.aiagent.plugin")).getState() + " rawValue=" + ((CCApplicationAccessResult) ZeusTransformUtils.preCheckCast(((CCDataResult.Success) ZeusTransformUtils.preCheckCast(r3, CCDataResult.Success.class, "com.obric.aiagent.plugin")).getData(), CCApplicationAccessResult.class, "com.obric.aiagent.plugin")).getRawValue());
        return (CCApplicationAccessResult) ZeusTransformUtils.preCheckCast(((CCDataResult.Success) ZeusTransformUtils.preCheckCast(r3, CCDataResult.Success.class, "com.obric.aiagent.plugin")).getData(), CCApplicationAccessResult.class, "com.obric.aiagent.plugin");
    L17:
        if (ZeusTransformUtils.instanceOf(r3, CCDataResult.Failed.class) == false) goto L21;
        Loog.INSTANCE.e("CCAppAccess", "event=access_request_failed origin=PUSH sessionKey=" + a() + " ccDisplayId=" + r14.getDisplayId() + " packageName=" + r26 + " reason=" + ((CCDataResult.Failed) ZeusTransformUtils.preCheckCast(r3, CCDataResult.Failed.class, "com.obric.aiagent.plugin")).getReason(), ((CCDataResult.Failed) ZeusTransformUtils.preCheckCast(r3, CCDataResult.Failed.class, "com.obric.aiagent.plugin")).getThrowable());
        com.obric.autogui.session.b.e.a(com.obric.autogui.session.b.e.f30776a, "application_access_request", ((CCDataResult.Failed) ZeusTransformUtils.preCheckCast(r3, CCDataResult.Failed.class, "com.obric.aiagent.plugin")).getReason().name(), this.f30745b, r14, null, "PUSH", null, r26, null, null, ((CCDataResult.Failed) ZeusTransformUtils.preCheckCast(r3, CCDataResult.Failed.class, "com.obric.aiagent.plugin")).getThrowable(), 848, null);
        return null;
    L21:
        throw new k();
    L7:
        if (d.o.o.d(r1) == true) goto L10;
        r2 = false;
    L22:
        com.obric.autogui.session.b.e r4 = com.obric.autogui.session.b.e.f30776a;
        if (r14 != null) goto L25;
        String r5 = "MissingCCSession";
    L26:
        com.obric.autogui.session.b.e.a(r4, "application_access_request", r5, this.f30745b, r14, null, "PUSH", null, r26, null, null, null, 1872, null);
        Loog r6 = Loog.INSTANCE;
        StringBuilder r0 = new StringBuilder().append("event=access_request_skipped origin=PUSH sessionKey=").append(a()).append(" ccDisplayId=");
        if (r14 == null) goto L29;
        Integer r7 = Integer.valueOf(r14.getDisplayId());
    L30:
        r6.w("CCAppAccess", r0.append(r7).append(" packageName=").append(r26).append(" reason=MissingCallbackArgument").toString());
        return null;
    L29:
        r7 = null;
        goto L30
    L25:
        r5 = "MissingPackageName";
        goto L26
    }

    private final Object a(CCSessionAccessor r21, String r22, String r23, d.c.d<? super x> r24) {
        CCSessionAccessor r3 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r21, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        d.c.d<? super x> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r24, d.c.d.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
    L23:
        Loog r4 = Loog.INSTANCE;
        StringBuilder r0 = new StringBuilder().append("event=system_blacklist_clarify_skipped sessionKey=").append(a()).append(" ccDisplayId=");
        if (r3 == null) goto L26;
        Integer r6 = d.c.b.a.b.a(r3.getDisplayId());
    L27:
        r4.w("CCAppAccess", r0.append(r6).append(" packageName=").append(r22).append(" origin=").append(r23).append(" reason=MissingCallbackArgument").toString());
        return x.f38692a;
    L26:
        r6 = null;
        goto L27
    L5:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r22, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L23;
        com.obric.autogui.session.state.termination.a r11 = this.f30745b.J();
        if (r11.e() == false) goto L10;
    L21:
        Loog.INSTANCE.i("CCAppAccess", "event=system_blacklist_clarify_skipped sessionKey=" + a() + " ccDisplayId=" + r3.getDisplayId() + " packageName=" + r22 + " origin=" + r23 + " reason=SessionTerminating");
        return x.f38692a;
    L10:
        if (r11.d() == true) goto L21;
        String r1 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r22, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (o.a(this.h.getAndSet(r1), r1) == false) goto L16;
        Loog.INSTANCE.i("CCAppAccess", "event=system_blacklist_clarify_skipped sessionKey=" + a() + " ccDisplayId=" + r3.getDisplayId() + " packageName=" + r1 + " origin=" + r23 + " reason=AlreadyScheduled");
        return x.f38692a;
    L16:
        int r7 = this.f30745b.N().get();
        AppBlackListEventHolder.INSTANCE.setBlackListEvent(new AppBlackListEvent(new ComponentName(r1, "ComputerControlSystemBlacklist"), AppBlackListState.SoftBlackList, r7, 0, false, 24, null));
        Loog.INSTANCE.i("CCAppAccess", "event=system_blacklist_clarify_scheduled sessionKey=" + a() + " ccDisplayId=" + r3.getDisplayId() + " packageName=" + r1 + " origin=" + r23 + " eventLoop=" + r7);
        com.obric.autogui.session.c.f30777a.b(this.f30745b);
        Object r2 = this.f30745b.n().a(r5);
        if (r2 != d.c.a.b.a()) goto L20;
        return r2;
    L20:
        return x.f38692a;
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.CCLifecycleListener
    public void onApplicationAccessPending(CCSessionAccessor r19, IntentSender r20) {
        CCSessionAccessor r8 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r19, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r8, SensitiveType.SESSION);
        o.e(r20, "intentSender");
        Loog.INSTANCE.i("CCAppAccess", "event=access_pending_delivered origin=FRAMEWORK sessionKey=" + a() + " sessionId=" + b() + " ccDisplayId=" + r8.getDisplayId() + " sessionState=" + a(r8.getState()) + " intentSender=" + r20);
        CCActionResult r1 = AOPlatformTools.INSTANCE.computerControl().launchApplicationAccessConsent((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r20);
        if (o.a(r1, CCActionResult.Success.INSTANCE) == false) goto L6;
        Loog.INSTANCE.i("CCAppAccess", "event=access_ui_launch_dispatched sessionKey=" + a() + " ccDisplayId=" + r8.getDisplayId());
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r1, CCActionResult.Failed.class) == false) goto L10;
        Loog.INSTANCE.e("CCAppAccess", "event=access_ui_launch_dispatch_failed sessionKey=" + a() + " ccDisplayId=" + r8.getDisplayId() + " reason=" + ((CCActionResult.Failed) ZeusTransformUtils.preCheckCast(r1, CCActionResult.Failed.class, "com.obric.aiagent.plugin")).getReason(), ((CCActionResult.Failed) ZeusTransformUtils.preCheckCast(r1, CCActionResult.Failed.class, "com.obric.aiagent.plugin")).getThrowable());
        com.obric.autogui.session.b.e.a(com.obric.autogui.session.b.e.f30776a, "application_access_ui", ((CCActionResult.Failed) ZeusTransformUtils.preCheckCast(r1, CCActionResult.Failed.class, "com.obric.aiagent.plugin")).getReason().name(), this.f30745b, r8, null, "FRAMEWORK", null, null, null, null, ((CCActionResult.Failed) ZeusTransformUtils.preCheckCast(r1, CCActionResult.Failed.class, "com.obric.aiagent.plugin")).getThrowable(), 976, null);
        return;
    L10:
        throw new k();
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.CCLifecycleListener
    public void onApplicationAccessChanged(CCSessionAccessor r25, String r26, CCApplicationAccessResult r27) {
        CCSessionAccessor r13 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r25, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r13, SensitiveType.SESSION);
        o.e(r26, "packageName");
        o.e(r27, "result");
        Loog.INSTANCE.i("CCAppAccess", "event=access_changed origin=FRAMEWORK sessionKey=" + a() + " sessionId=" + b() + " ccDisplayId=" + r13.getDisplayId() + " packageName=" + r26 + " state=" + r27.getState() + " rawValue=" + r27.getRawValue());
        this.g.set(r27.getState());
        if (r27.getState() == CCApplicationAccessState.Pending) goto L8;
        if (this.f30745b.E().a("computer_control_apply_app_permission") == false) goto L8;
        Loog.INSTANCE.i("CCAppAccess", "event=client_risky_operation_changed origin=FRAMEWORK sessionKey=" + a() + " packageName=" + r26 + " active=false state=" + r27.getState());
    L8:
        if (r27.getState() != CCApplicationAccessState.Denied) goto L12;
        c(r13, r26);
        return;
    L12:
        if (r27.getState() != CCApplicationAccessState.DeniedBlacklist) goto L16;
        this.f30745b.h().launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new b(this, r13, r26, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
        return;
    L16:
        if (r27.getState() != CCApplicationAccessState.Unknown) goto L20;
        com.obric.autogui.session.b.e.a(com.obric.autogui.session.b.e.f30776a, "application_access_callback", "UnknownAccessState", this.f30745b, r13, null, "FRAMEWORK", null, r26, r27.getState(), Integer.valueOf(r27.getRawValue()), null, 1104, null);
    L20:
        if (r27.getState() == CCApplicationAccessState.Granted) goto L22;
        return;
    L22:
        Loog.INSTANCE.i("CCAppAccess", "event=access_granted_launch_start origin=FRAMEWORK sessionKey=" + a() + " ccDisplayId=" + r13.getDisplayId() + " packageName=" + r26);
        CCActionResult r1 = AOPlatformTools.INSTANCE.computerControl().launchApplication(r13, r26);
        if (o.a(r1, CCActionResult.Success.INSTANCE) == false) goto L26;
        Loog.INSTANCE.i("CCAppAccess", "event=access_granted_launch_success origin=FRAMEWORK sessionKey=" + a() + " ccDisplayId=" + r13.getDisplayId() + " packageName=" + r26);
        return;
    L26:
        if (ZeusTransformUtils.instanceOf(r1, CCActionResult.Failed.class) == false) goto L30;
        Loog.INSTANCE.e("CCAppAccess", "event=access_granted_launch_failed origin=FRAMEWORK sessionKey=" + a() + " ccDisplayId=" + r13.getDisplayId() + " packageName=" + r26 + " reason=" + ((CCActionResult.Failed) ZeusTransformUtils.preCheckCast(r1, CCActionResult.Failed.class, r14)).getReason(), ((CCActionResult.Failed) ZeusTransformUtils.preCheckCast(r1, CCActionResult.Failed.class, r14)).getThrowable());
        com.obric.autogui.session.b.e.a(com.obric.autogui.session.b.e.f30776a, "application_launch", ((CCActionResult.Failed) ZeusTransformUtils.preCheckCast(r1, CCActionResult.Failed.class, r14)).getReason().name(), this.f30745b, r13, null, "FRAMEWORK", "launchApplication", r26, r27.getState(), Integer.valueOf(r27.getRawValue()), ((CCActionResult.Failed) ZeusTransformUtils.preCheckCast(r1, CCActionResult.Failed.class, "com.obric.aiagent.plugin")).getThrowable(), 16, null);
        return;
    L30:
        throw new k();
    }

    private final void c(CCSessionAccessor r20, String r21) {
        CCSessionAccessor r4 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r20, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        CCSessionState r1 = r4.getState();
        if (ZeusTransformUtils.instanceOf(r1, CCSessionState.Blocked.class) == true) goto L6;
        Loog.INSTANCE.i("CCAppAccess", "event=access_denied_termination_skipped origin=FRAMEWORK sessionKey=" + a() + " ccDisplayId=" + r4.getDisplayId() + " packageName=" + r21 + " reason=SessionNotBlocked frameworkSessionState=" + a(r1));
        return;
    L6:
        Loog.INSTANCE.i("CCAppAccess", "event=access_denied_termination_start origin=FRAMEWORK sessionKey=" + a() + " ccDisplayId=" + r4.getDisplayId() + " packageName=" + r21 + " frameworkSessionState=" + a(r1));
        IAutoActionAgentApi r11 = (IAutoActionAgentApi) ZeusTransformUtils.preCheckCast(AutoActionAgent.INSTANCE, IAutoActionAgentApi.class, "com.obric.aiagent.plugin");
        String r12 = a();
        String r13 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f30745b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.std_model_cc_app_access_denied, WsChannelMultiProcessSharedProvider.STRING_TYPE, "std_model_cc_app_access_denied"));
        o.c(r13, "getString(...)");
        com.obric.autogui.common.e r2 = IAutoActionAgentApi.DefaultImpls.systemTerminateQuery$default(r11, r12, r13, 106004, null, null, 24, null);
        Loog r3 = Loog.INSTANCE;
        StringBuilder r5 = new StringBuilder().append("event=access_denied_termination_result origin=FRAMEWORK sessionKey=").append(a()).append(" ccDisplayId=").append(r4.getDisplayId()).append(" packageName=").append(r21).append(" result=");
        if (r2.g() == false) goto L9;
        String r6 = "Success";
    L10:
        r3.i("CCAppAccess", r5.append(r6).append(" frameworkSessionState=").append(a(r4.getState())).toString());
        if (r2.g() == true) goto L14;
        com.obric.autogui.session.b.e.a(com.obric.autogui.session.b.e.f30776a, "task_termination", "TerminateRejected", this.f30745b, r4, null, "FRAMEWORK", null, r21, CCApplicationAccessState.Denied, null, null, 1616, null);
        return;
    L14:
        return;
    L9:
        r6 = "Failed";
        goto L10
    }

    private final String a(CCSessionState r4) {
        if (o.a(r4, CCSessionState.Requesting.INSTANCE) == false) goto L6;
        return "Requesting";
    L6:
        if (o.a(r4, CCSessionState.Created.INSTANCE) == false) goto L9;
        return "Created";
    L9:
        if (o.a(r4, CCSessionState.Active.INSTANCE) == false) goto L12;
        return "Active";
    L12:
        if (ZeusTransformUtils.instanceOf(r4, CCSessionState.Blocked.class) == false) goto L15;
        return "Blocked(reason=" + ((CCSessionState.Blocked) ZeusTransformUtils.preCheckCast(r4, CCSessionState.Blocked.class, "com.obric.aiagent.plugin")).getReason() + ", packageName=" + ((CCSessionState.Blocked) ZeusTransformUtils.preCheckCast(r4, CCSessionState.Blocked.class, "com.obric.aiagent.plugin")).getPackageName() + ')';
    L15:
        if (ZeusTransformUtils.instanceOf(r4, CCSessionState.Closed.class) == false) goto L18;
        return "Closed(reason=" + ((CCSessionState.Closed) ZeusTransformUtils.preCheckCast(r4, CCSessionState.Closed.class, "com.obric.aiagent.plugin")).getReason() + ')';
    L18:
        if (ZeusTransformUtils.instanceOf(r4, CCSessionState.CreationFailed.class) == false) goto L22;
        return "CreationFailed(errorCode=" + ((CCSessionState.CreationFailed) ZeusTransformUtils.preCheckCast(r4, CCSessionState.CreationFailed.class, "com.obric.aiagent.plugin")).getErrorCode() + ')';
    L22:
        throw new k();
    }
}
