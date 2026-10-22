package com.obric.autogui.session.state.termination;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.configs.AutoActionConfigs;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.device.AODeviceInfo;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.obric.autogui.tools.api.net.IAutoActionNetStatusApi;
import com.obric.oui.orecyclerview.widget.ItemTouchHelper;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.bduploader.BDAbstractUpload;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.m;
import d.h.b.o;
import d.h.b.z;
import d.x;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlinx.coroutines.am;
import org.json.JSONObject;
import os.teatracker.IBdInstall;

/* JADX INFO: compiled from: SessionFinalizer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static final String TAG = "Ses-Fin";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f31431a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f31432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f31433c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f31434d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f31435e;
    private final c f;
    private final com.obric.autogui.session.state.holderfile.a g;
    private final String h;
    private final String i;
    private final String j;
    private long k;
    private ConnectivityManager.NetworkCallback l;
    private int m;
    private boolean n;
    private boolean o;
    private boolean p;

    /* JADX INFO: compiled from: SessionFinalizer.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final b a(com.obric.autogui.session.a r13) {
            o.e(r13, SensitiveType.SESSION);
            Object r12 = r13.a(com.obric.autogui.agents.a.EnumC0655a.f26120b);
            com.obric.autogui.agents.vlm.models.b r2 = null;
            if (ZeusTransformUtils.instanceOf(r12, com.obric.autogui.agents.vlm.b.C0677b.class) == false) goto L5;
            com.obric.autogui.agents.vlm.b.C0677b r14 = (com.obric.autogui.agents.vlm.b.C0677b) ZeusTransformUtils.preCheckCast(r12, com.obric.autogui.agents.vlm.b.C0677b.class, "com.obric.aiagent.plugin");
        L6:
            if (r14 == null) goto L8;
            com.obric.autogui.agents.vlm.models.c r15 = r14.d();
        L10:
            if (ZeusTransformUtils.instanceOf(r15, com.obric.autogui.agents.vlm.models.impl.d.class) == false) goto L12;
            com.obric.autogui.agents.vlm.models.impl.d r16 = (com.obric.autogui.agents.vlm.models.impl.d) ZeusTransformUtils.preCheckCast(r15, com.obric.autogui.agents.vlm.models.impl.d.class, "com.obric.aiagent.plugin");
        L13:
            if (r16 == null) goto L15;
            r2 = r16.c();
        L15:
            Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            String r5 = r13.b();
            String r6 = r13.a();
            int r7 = r13.l().getLaunchOrigin();
            if (r2 == null) goto L18;
            int r0 = r2.ordinal();
        L20:
            return new b(r4, r5, r6, r7, new c(r0, r13.q()), r13.m().b(), r13.R().a(), null);
        L18:
            r0 = com.obric.autogui.agents.vlm.models.b.f27278b.ordinal();
            goto L20
        L12:
            r16 = null;
            goto L13
        L8:
            r15 = null;
            goto L10
        L5:
            r14 = null;
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.session.state.termination.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SessionFinalizer.kt */
    public interface InterfaceC0860b {
        void onFinalizeDone();
    }

    /* JADX INFO: compiled from: SessionFinalizer.kt */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f31436a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Set<IAutoActionAgentEventListener.OperatingAppInfo> f31437b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (this.f31436a == r6.f31436a) goto L12;
            return false;
        L12:
            if (o.a(this.f31437b, r6.f31437b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = Integer.hashCode(this.f31436a) * 31;
            Set<IAutoActionAgentEventListener.OperatingAppInfo> r1 = this.f31437b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "ThingsToUpload(modelType=" + this.f31436a + ", operatedAppSet=" + this.f31437b + ')';
        }

        public c(int r3, Set<IAutoActionAgentEventListener.OperatingAppInfo> r4) {
            Set<IAutoActionAgentEventListener.OperatingAppInfo> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin");
            this.f31436a = r3;
            this.f31437b = r5;
        }

        public final int a() {
            return this.f31436a;
        }

        public final Set<IAutoActionAgentEventListener.OperatingAppInfo> b() {
            return this.f31437b;
        }
    }

    /* JADX INFO: compiled from: SessionFinalizer.kt */
    @d.c.b.a.f(b = "SessionFinalizer.kt", c = {190, 210, 223}, d = "doFinalize", e = "com.obric.autogui.session.state.termination.SessionFinalizer")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f31438a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f31439b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f31440c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f31441d;

        d(b r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31440c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f31439b = r3;
            this.f31441d |= Integer.MIN_VALUE;
            return b.a(this.f31440c, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SessionFinalizer.kt */
    @d.c.b.a.f(b = "SessionFinalizer.kt", c = {298, 332}, d = "doUploadRelatedAppInfo", e = "com.obric.autogui.session.state.termination.SessionFinalizer")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f31442a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f31443b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f31444c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f31445d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f31446e;
        Object f;
        /* synthetic */ Object g;
        final /* synthetic */ b h;
        int i;

        e(b r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.h = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.g = r3;
            this.i |= Integer.MIN_VALUE;
            return b.c(this.h, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SessionFinalizer.kt */
    @d.c.b.a.f(b = "SessionFinalizer.kt", c = {378}, d = "finishRemoteSession", e = "com.obric.autogui.session.state.termination.SessionFinalizer")
    static final class f extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f31447a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f31448b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f31449c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f31450d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f31451e;

        f(b r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31450d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f31449c = r3;
            this.f31451e |= Integer.MIN_VALUE;
            return b.d(this.f31450d, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SessionFinalizer.kt */
    @d.c.b.a.f(b = "SessionFinalizer.kt", c = {379}, d = "invokeSuspend", e = "com.obric.autogui.session.state.termination.SessionFinalizer$finishRemoteSession$2")
    static final class g extends d.c.b.a.l implements d.h.a.b<d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f31452a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f31453b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ z.a f31454c;

        g(b r3, z.a r4, d.c.d<? super g> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31453b = r3;
            this.f31454c = r4;
            super(1, r6);
        }

        public final Object a(d.c.d<? super Boolean> r3) {
            return ((g) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new g(this.f31453b, this.f31454c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super Boolean> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f31452a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            com.obric.autogui.common.e r7 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r6, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
            this.f31454c.f38499a = r7.g();
            return d.c.b.a.b.a(!r7.g());
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            b r8 = this.f31453b;
            String r2 = r8.a();
            d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31452a = 1;
            r6 = b.a(r8, r2, r4);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: SessionFinalizer.kt */
    @d.c.b.a.f(b = "SessionFinalizer.kt", c = {BDAbstractUpload.KeyIsSDKMaxRetryTimeout}, d = "finishSession", e = "com.obric.autogui.session.state.termination.SessionFinalizer")
    static final class h extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f31455a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f31456b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f31457c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f31458d;

        h(b r3, d.c.d<? super h> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31457c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f31456b = r3;
            this.f31458d |= Integer.MIN_VALUE;
            return b.a(this.f31457c, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SessionFinalizer.kt */
    @d.c.b.a.f(b = "SessionFinalizer.kt", c = {129}, d = "runFinalizeRound", e = "com.obric.autogui.session.state.termination.SessionFinalizer")
    static final class i extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f31459a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f31460b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f31461c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f31462d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f31463e;

        i(b r3, d.c.d<? super i> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31462d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f31461c = r3;
            this.f31463e |= Integer.MIN_VALUE;
            return b.a(this.f31462d, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SessionFinalizer.kt */
    @d.c.b.a.f(b = "SessionFinalizer.kt", c = {112}, d = "invokeSuspend", e = "com.obric.autogui.session.state.termination.SessionFinalizer$scheduleFinalize$1")
    static final class j extends d.c.b.a.l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f31464a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f31465b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ InterfaceC0860b f31466c;

        /* JADX INFO: renamed from: com.obric.autogui.session.state.termination.b$j$1, reason: invalid class name */
        /* JADX INFO: compiled from: SessionFinalizer.kt */
        @d.c.b.a.f(b = "SessionFinalizer.kt", c = {117}, d = "invokeSuspend", e = "com.obric.autogui.session.state.termination.SessionFinalizer$scheduleFinalize$1$3")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.b<d.c.d<? super Boolean>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f31467a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ b f31468b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ InterfaceC0860b f31469c;

            AnonymousClass1(b r3, InterfaceC0860b r4, d.c.d<? super AnonymousClass1> r5) {
                InterfaceC0860b r6 = (InterfaceC0860b) ZeusTransformUtils.wrapperContextForParams(r4, InterfaceC0860b.class, "com.obric.aiagent.plugin");
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f31468b = r3;
                this.f31469c = r6;
                super(1, r7);
            }

            public final Object a(d.c.d<? super Boolean> r3) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f31468b, this.f31469c, r5), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.b
            public /* synthetic */ Object invoke(d.c.d<? super Boolean> r3) {
                return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f31467a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r6);
            L11:
                return r6;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r6);
                b r7 = this.f31468b;
                InterfaceC0860b r2 = this.f31469c;
                d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f31467a = 1;
                r6 = b.a(r7, r2, r3);
                if (r6 != r0) goto L11;
                return r0;
            }
        }

        j(b r3, InterfaceC0860b r4, d.c.d<? super j> r5) {
            InterfaceC0860b r6 = (InterfaceC0860b) ZeusTransformUtils.wrapperContextForParams(r4, InterfaceC0860b.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31465b = r3;
            this.f31466c = r6;
            super(2, r7);
        }

        private static final String a() {
            return "Finalization timed out (max await: 60mins)";
        }

        private static final String b() {
            return "Finalization retrial done.";
        }

        public static /* synthetic */ String lambda$_EY92E2nqYjtZQKbXgB_S_2lS60(b r0) {
            return b(r0);
        }

        public static /* synthetic */ String lambda$bpN3ukCMZQwUG3lq9l_Rp4yLQBM() {
            return b();
        }

        public static /* synthetic */ String lambda$tGmTGxWsVh3dBOSruSyyCZcpVLA() {
            return a();
        }

        public static /* synthetic */ String lambda$uEOHyB9VlpfKD6Kk7tetgjD7fqg(b r0) {
            return a(r0);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((j) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), j.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new j(this.f31465b, this.f31466c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f31464a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r12);
        L15:
            Loog r13 = Loog.INSTANCE;
            final b r11 = this.f31465b;
            r13.dp(b.TAG, new $$Lambda$b$j$_EY92E2nqYjtZQKbXgB_S_2lS60(r11), $$Lambda$b$j$bpN3ukCMZQwUG3lq9l_Rp4yLQBM.INSTANCE);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r12);
            if ((System.currentTimeMillis() - b.a(this.f31465b)) <= DownloadConstants.HOUR) goto L12;
            Loog r14 = Loog.INSTANCE;
            final b r15 = this.f31465b;
            r14.ep(b.TAG, new $$Lambda$b$j$uEOHyB9VlpfKD6Kk7tetgjD7fqg(r15), $$Lambda$b$j$tGmTGxWsVh3dBOSruSyyCZcpVLA.INSTANCE);
            return x.f38692a;
        L12:
            com.obric.autogui.util.a r16 = com.obric.autogui.util.a.f31488a;
            String r4 = b.b(this.f31465b) + "-SchFinalise";
            d.h.a.b<? super d.c.d<? super Boolean>, ? extends Object> r8 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f31465b, this.f31466c, null), d.h.a.b.class, "com.obric.aiagent.plugin");
            d.c.d<? super x> r9 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31464a = 1;
            if (r16.a(r4, 5, 10000, r8, r9) != r0) goto L15;
            return r0;
        }

        private static final String a(b r1) {
            return b.b(r1) + " Finalization timed out (max await: 60mins)";
        }

        private static final String b(b r1) {
            return b.b(r1) + " Finalization retrial done.";
        }
    }

    /* JADX INFO: compiled from: SessionFinalizer.kt */
    @d.c.b.a.f(b = "SessionFinalizer.kt", c = {247}, d = "uploadRelatedAppInfo", e = "com.obric.autogui.session.state.termination.SessionFinalizer")
    static final class k extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f31470a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f31471b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f31472c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f31473d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f31474e;

        k(b r3, d.c.d<? super k> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31473d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f31472c = r3;
            this.f31474e |= Integer.MIN_VALUE;
            return b.b(this.f31473d, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SessionFinalizer.kt */
    @d.c.b.a.f(b = "SessionFinalizer.kt", c = {ItemTouchHelper.a.DEFAULT_SWIPE_ANIMATION_DURATION}, d = "invokeSuspend", e = "com.obric.autogui.session.state.termination.SessionFinalizer$uploadRelatedAppInfo$2")
    static final class l extends d.c.b.a.l implements d.h.a.b<d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f31475a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f31476b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f31477c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f31478d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ z.a f31479e;
        final /* synthetic */ b f;

        l(z.a r3, b r4, d.c.d<? super l> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31479e = r3;
            this.f = r4;
            super(1, r6);
        }

        public static /* synthetic */ String lambda$PhUYCHq1oDJVQ8a5e9gzlJeMnWY(b r0, z.f r1, long r2) {
            return a(r0, r1, r2);
        }

        public static /* synthetic */ String lambda$n7ToaaLy83pRZeqTKjAgFqvufr8(long r0) {
            return a(r0);
        }

        public final Object a(d.c.d<? super Boolean> r3) {
            return ((l) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), l.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new l(this.f31479e, this.f, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super Boolean> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f31478d;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            long r2 = this.f31477c;
            z.f r4 = (z.f) ZeusTransformUtils.preCheckCast(this.f31476b, z.f.class, "com.obric.aiagent.plugin");
            final z.f r5 = (z.f) ZeusTransformUtils.preCheckCast(this.f31475a, z.f.class, "com.obric.aiagent.plugin");
            d.o.a(r9);
            T r10 = r9;
        L12:
            r4.f38504a = r10;
            final long r6 = System.currentTimeMillis() - r2;
            Loog r11 = Loog.INSTANCE;
            final b r3 = this.f;
            r11.dp(b.TAG, new $$Lambda$b$l$PhUYCHq1oDJVQ8a5e9gzlJeMnWY(r3, r5, r6), new $$Lambda$b$l$n7ToaaLy83pRZeqTKjAgFqvufr8(r6));
            this.f31479e.f38499a = ((com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r5.f38504a, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin")).g();
            return d.c.b.a.b.a(!((com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r5.f38504a, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin")).g());
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r9);
            r4 = new z.f();
            b r12 = this.f;
            long r7 = System.currentTimeMillis();
            this.f31475a = r4;
            this.f31476b = r4;
            this.f31477c = r7;
            this.f31478d = 1;
            Object r13 = b.c(r12, this);
            if (r13 != r0) goto L11;
            return r0;
        L11:
            r2 = r7;
            r5 = r4;
            r10 = r13;
            goto L12
        }

        private static final String a(b r1, z.f r2, long r3) {
            return b.b(r1) + " uploadRelatedAppInfo, result: " + r2.f38504a + ", time: " + r3;
        }

        private static final String a(long r2) {
            return "uploadRelatedAppInfo, time: " + r2;
        }
    }

    static {
        f31431a = new a(null);
    }

    private static final String b() {
        return "session cleanse failed on FinishRemoteSession";
    }

    private static final String c() {
        return "session cleanse failed on UploadRelatedAppInfo";
    }

    private static final String d() {
        return "session cleanse done";
    }

    private static final String e() {
        return "doUploadRelatedAppInfo, no apps to upload";
    }

    private static final String f() {
        return "doUploadRelatedAppInfo, appIcon is null";
    }

    private static final String g() {
        return "uploadRelatedAppInfo, one app info prepared";
    }

    private static final String h() {
        return "uploadRelatedAppInfo, request prepared";
    }

    private static final String i() {
        return "uploadRelatedAppInfo, client is null";
    }

    private static final String j() {
        return "uploadRelatedAppInfo, response ok";
    }

    private static final String k() {
        return "uploadRelatedAppInfo, request failed";
    }

    private static final String l() {
        return "uploadRelatedAppInfo, request failed";
    }

    /* JADX INFO: renamed from: lambda$-TNNqeQZ8omkrTre7sI-QBudZhg, reason: not valid java name */
    public static /* synthetic */ String m904lambda$TNNqeQZ8omkrTre7sIQBudZhg(b r0, JsonObject r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ String lambda$0sWDAIKJiTnlC88GdXaaWVg1g6Y(b r0, Throwable r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$21-xU4nRmp8eQFVE604N6YieEvs, reason: not valid java name */
    public static /* synthetic */ String m905lambda$21xU4nRmp8eQFVE604N6YieEvs(b r0, z.a r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ String lambda$2UGEBk6pBbOroDlhUCrHv0siUGo(b r0) {
        return e(r0);
    }

    public static /* synthetic */ String lambda$3L8o9e_s8kM_nCy7We37E6vtGMc() {
        return n();
    }

    /* JADX INFO: renamed from: lambda$749-c2nbjGhrWTDY3Hc86HVVtJM, reason: not valid java name */
    public static /* synthetic */ String m906lambda$749c2nbjGhrWTDY3Hc86HVVtJM(b r0) {
        return i(r0);
    }

    /* JADX INFO: renamed from: lambda$8-oaIjD0XO5F2msoxOXZOyiqmTM, reason: not valid java name */
    public static /* synthetic */ String m907lambda$8oaIjD0XO5F2msoxOXZOyiqmTM() {
        return b();
    }

    public static /* synthetic */ String lambda$8S1dOyKosWHT5f8l6xE1CTkimkE() {
        return c();
    }

    public static /* synthetic */ String lambda$CQKsjksc1VUMfOuGJKH7XFUY3QI(b r0) {
        return c(r0);
    }

    public static /* synthetic */ String lambda$FOwedcCRSw8bdUQ7wjES6NakpMs(b r0, int r1, String r2, String r3) {
        return a(r0, r1, r2, r3);
    }

    public static /* synthetic */ String lambda$GNLoOnRxgiDyCX750jpuZXF4D7E() {
        return h();
    }

    /* JADX INFO: renamed from: lambda$GR7873E-ExFH9x7C2T-sL8jiNK8, reason: not valid java name */
    public static /* synthetic */ String m908lambda$GR7873EExFH9x7C2TsL8jiNK8() {
        return p();
    }

    public static /* synthetic */ String lambda$GuuMDPJc_2EMfQui7rqkuJHQSzk() {
        return d();
    }

    public static /* synthetic */ String lambda$HOCvcVyo4ovtqO9_RUDdHFIRvqE(b r0, int r1, String r2, String r3) {
        return b(r0, r1, r2, r3);
    }

    public static /* synthetic */ String lambda$HXBZ2QZvybpKjVOMYitaXpI2hgA(z.a r0) {
        return a(r0);
    }

    public static /* synthetic */ String lambda$JkBiaLEAZPnZOwxhnahpYAAyuh4(b r0) {
        return h(r0);
    }

    /* JADX INFO: renamed from: lambda$JoSaOo2PNI-k1uFBRv9pJgA7FDc, reason: not valid java name */
    public static /* synthetic */ String m909lambda$JoSaOo2PNIk1uFBRv9pJgA7FDc(b r0, Set r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$M0TutLR-z-cQSBfHzKoFMGYsNcM, reason: not valid java name */
    public static /* synthetic */ String m910lambda$M0TutLRzcQSBfHzKoFMGYsNcM(b r0) {
        return l(r0);
    }

    public static /* synthetic */ String lambda$Mrf9ShOwKEyKtJLY0YZ3jF9g07Y() {
        return q();
    }

    public static /* synthetic */ String lambda$OHY4wPatyr50PJdO_xz1FBtvXgI(b r0, Throwable r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ String lambda$PCRqUQHRjp6TV4IPyDsfdRuHzHk(b r0) {
        return j(r0);
    }

    public static /* synthetic */ String lambda$PCrbdRLpcNycs99YgvLiqgIpugA(b r0, com.obric.autogui.tools.api.net.a.InterfaceC0861a r1, String r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ String lambda$QXGDQ3BWg5LdU4hOtPyGzAPthdM() {
        return i();
    }

    public static /* synthetic */ String lambda$S9Xl9vkELOQ3RfKXF69fi9YA8BQ() {
        return m();
    }

    public static /* synthetic */ String lambda$SGWIAwrRgankb6jEKudYTZB7V2c() {
        return l();
    }

    /* JADX INFO: renamed from: lambda$VVCjmljcZM-t_p_OQIK1haI6DF4, reason: not valid java name */
    public static /* synthetic */ String m911lambda$VVCjmljcZMt_p_OQIK1haI6DF4(b r0) {
        return k(r0);
    }

    public static /* synthetic */ String lambda$a3i7jFVq3AXQbeTCior2a5E5hcU() {
        return g();
    }

    public static /* synthetic */ String lambda$bamdn4UKZKXEdfY9sG0oMOrwn2k(b r0, IAutoActionAgentEventListener.OperatingAppInfo r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ String lambda$bmdSN9360cm12KfFfGvmpUGwZtE() {
        return e();
    }

    /* JADX INFO: renamed from: lambda$c2PWbFBm499Tp7P-2ptLni3Ca-w, reason: not valid java name */
    public static /* synthetic */ String m912lambda$c2PWbFBm499Tp7P2ptLni3Caw() {
        return k();
    }

    public static /* synthetic */ String lambda$dS93rQp5tuLnJqWLv2QFOlVCqZ8(b r0, String r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$eC4U3xruwN-UAw652278SaKfOiQ, reason: not valid java name */
    public static /* synthetic */ String m913lambda$eC4U3xruwNUAw652278SaKfOiQ(b r0) {
        return d(r0);
    }

    public static /* synthetic */ String lambda$gT1iRHsIBE6gMR9LxUZbaeFH28U(b r0, JsonObject r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ String lambda$jZ7NKumqRp4YnnWSoddZAKbQAso() {
        return f();
    }

    public static /* synthetic */ String lambda$lAknBe5Xff_7Ni4liIfIj15PiuY(b r0) {
        return m(r0);
    }

    public static /* synthetic */ String lambda$lHmnk3Kp6tSiA6_42GtTvT6Ty3c(b r0) {
        return g(r0);
    }

    public static /* synthetic */ String lambda$lfUpnEXgXauLLQfzQmhMqUsCayc(b r0) {
        return f(r0);
    }

    /* JADX INFO: renamed from: lambda$pGhyLIuW6BR2i28NtCr25f-WF-E, reason: not valid java name */
    public static /* synthetic */ String m914lambda$pGhyLIuW6BR2i28NtCr25fWFE(b r0, com.obric.autogui.tools.api.net.a.InterfaceC0861a r1, String r2) {
        return b(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$wbqQXJe4P8f-rLjlU82qRzL39Uw, reason: not valid java name */
    public static /* synthetic */ String m915lambda$wbqQXJe4P8frLjlU82qRzL39Uw() {
        return o();
    }

    /* JADX INFO: renamed from: lambda$yRqUXTv-Syqcsfn0flXGtsm4P2I, reason: not valid java name */
    public static /* synthetic */ String m916lambda$yRqUXTvSyqcsfn0flXGtsm4P2I() {
        return j();
    }

    private static final String m() {
        return "finishSession";
    }

    private static final String n() {
        return "finishSession, client is null";
    }

    private static final String o() {
        return "finishSession, response ok";
    }

    private static final String p() {
        return "finishSession, request failed";
    }

    private static final String q() {
        return "finishSession, request failed";
    }

    public b(Context r3, String r4, String r5, int r6, c r7, com.obric.autogui.session.state.holderfile.a r8, String r9, String r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r11, "context");
        o.e(r4, ObricMemoryConstants.KEY_SESSION_ID);
        o.e(r5, "sessionKey");
        this.f31432b = ZeusTransformUtils.wrapperContext(r11, "com.obric.aiagent.plugin");
        this.f31433c = r4;
        this.f31434d = r5;
        this.f31435e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = "[S." + r5 + '.' + r4 + ']';
    }

    public static final /* synthetic */ long a(b r2) {
        return r2.k;
    }

    public static final /* synthetic */ Object a(b r2, InterfaceC0860b r3, d.c.d r4) {
        return r2.a((InterfaceC0860b) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0860b.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(b r2, d.c.d r3) {
        return r2.a((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(b r2, String r3, d.c.d r4) {
        return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(b r0, ConnectivityManager.NetworkCallback r1) {
        r0.l = r1;
    }

    public static final /* synthetic */ Object b(b r2, d.c.d r3) {
        return r2.b((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ String b(b r0) {
        return r0.j;
    }

    public static final /* synthetic */ Object c(b r2, d.c.d r3) {
        return r2.c((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object d(b r2, d.c.d r3) {
        return r2.d((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public final Context getContext() {
        return this.f31432b;
    }

    public final String a() {
        return this.f31433c;
    }

    public static /* synthetic */ void a(b r1, InterfaceC0860b r2, int r3, Object r4) {
        InterfaceC0860b r5 = (InterfaceC0860b) ZeusTransformUtils.wrapperContextForParams(r2, InterfaceC0860b.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = null;
    L5:
        r1.a(r5);
    }

    public final void a(InterfaceC0860b r7) {
        InterfaceC0860b r8 = (InterfaceC0860b) ZeusTransformUtils.wrapperContextForParams(r7, InterfaceC0860b.class, "com.obric.aiagent.plugin");
        if (this.k != 0) goto L5;
        this.k = System.currentTimeMillis();
    L5:
        AOThreadingTools.INSTANCE.launchIO((m) ZeusTransformUtils.preCheckCast(new j(this, r8, null), m.class, "com.obric.aiagent.plugin"));
    }

    private final Object a(InterfaceC0860b r7, d.c.d<? super Boolean> r8) {
        InterfaceC0860b r9 = (InterfaceC0860b) ZeusTransformUtils.wrapperContextForParams(r7, InterfaceC0860b.class, "com.obric.aiagent.plugin");
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, i.class) == false) goto L7;
        i r0 = (i) ZeusTransformUtils.preCheckCast(r10, i.class, "com.obric.aiagent.plugin");
        if ((r0.f31463e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f31463e -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.f31461c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f31463e;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r9 = (InterfaceC0860b) ZeusTransformUtils.preCheckCast(r0.f31460b, InterfaceC0860b.class, "com.obric.aiagent.plugin");
        final b this = (b) ZeusTransformUtils.preCheckCast(r0.f31459a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r11);
    L18:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L30;
        Loog.INSTANCE.ep(TAG, new $$Lambda$b$CQKsjksc1VUMfOuGJKH7XFUY3QI(this), new $$Lambda$b$eC4U3xruwNUAw652278SaKfOiQ(this));
        IAutoActionNetStatusApi r12 = (IAutoActionNetStatusApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionNetStatusApi.class), IAutoActionNetStatusApi.class, "com.obric.aiagent.plugin");
        if (r12 != null) goto L22;
    L24:
        boolean r13 = false;
    L25:
        if (r13 == false) goto L29;
        Loog.INSTANCE.dp(TAG, new $$Lambda$b$2UGEBk6pBbOroDlhUCrHv0siUGo(this));
        Loog.INSTANCE.w(TAG, "Retry after network changes");
        this.b(r9);
        return d.c.b.a.b.a(false);
    L29:
        return d.c.b.a.b.a(true);
    L22:
        if (r12.isInternetConnected(this.f31432b) == true) goto L24;
        r13 = true;
        goto L25
    L30:
        if (r9 == null) goto L33;
        r9.onFinalizeDone();
    L33:
        return d.c.b.a.b.a(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r11);
        r0.f31459a = this;
        r0.f31460b = r9;
        r0.f31463e = 1;
        r11 = a(r0);
        if (r11 != r2) goto L18;
        return r2;
    L7:
        r0 = new i(this, r10);
        goto L8
    }

    private static final String c(b r2) {
        return "(ses/" + r2.f31434d + ") session cleanse failed (round=" + r2.m + "/5).";
    }

    private static final String d(b r2) {
        return "session cleanse failed (round=" + r2.m + "/5).";
    }

    private static final String e(b r2) {
        return " - (ses/" + r2.f31434d + ") it is likely that the network error caused this failure. Retry after network changes.";
    }

    private final void b(InterfaceC0860b r5) {
        InterfaceC0860b r6 = (InterfaceC0860b) ZeusTransformUtils.wrapperContextForParams(r5, InterfaceC0860b.class, "com.obric.aiagent.plugin");
        Object r0 = this.f31432b.getSystemService("connectivity");
        o.a(r0, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager r1 = (ConnectivityManager) ZeusTransformUtils.preCheckCast(r0, ConnectivityManager.class, "com.obric.aiagent.plugin");
        NetworkRequest r2 = new NetworkRequest.Builder().build();
        ConnectivityManager.NetworkCallback r7 = (ConnectivityManager.NetworkCallback) ZeusTransformUtils.preCheckCast(new SessionFinalizer$registerNetworkCallback$1(r1, this, r6), ConnectivityManager.NetworkCallback.class, "com.obric.aiagent.plugin");
        this.l = r7;
        if (r7 == null) goto L6;
        r1.registerNetworkCallback(r2, r7);
        return;
    }

    private final Object a(d.c.d<? super Boolean> r13) {
        d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, d.class) == false) goto L7;
        d r1 = (d) ZeusTransformUtils.preCheckCast(r14, d.class, "com.obric.aiagent.plugin");
        if ((r1.f31441d & Integer.MIN_VALUE) == 0) goto L7;
        r1.f31441d -= Integer.MIN_VALUE;
    L8:
        Object r15 = r1.f31439b;
        Object r3 = d.c.a.b.a();
        int r4 = r1.f31441d;
        if (r4 == 0) goto L18;
        if (r4 == 1) goto L17;
        if (r4 == 2) goto L16;
        if (r4 != 3) goto L15;
        final b this = (b) ZeusTransformUtils.preCheckCast(r1.f31438a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r15);
    L42:
        if (this.p == true) goto L45;
        Loog.INSTANCE.ep(TAG, new $$Lambda$b$749c2nbjGhrWTDY3Hc86HVVtJM(this), $$Lambda$b$8S1dOyKosWHT5f8l6xE1CTkimkE.INSTANCE);
        return d.c.b.a.b.a(false);
    L45:
        Loog.INSTANCE.ip(TAG, new $$Lambda$b$PCRqUQHRjp6TV4IPyDsfdRuHzHk(this), $$Lambda$b$GuuMDPJc_2EMfQui7rqkuJHQSzk.INSTANCE);
        return d.c.b.a.b.a(true);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        this = (b) ZeusTransformUtils.preCheckCast(r1.f31438a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r15);
    L32:
        if (this.p == true) goto L35;
        Loog.INSTANCE.ep(TAG, new $$Lambda$b$JkBiaLEAZPnZOwxhnahpYAAyuh4(this), $$Lambda$b$8oaIjD0XO5F2msoxOXZOyiqmTM.INSTANCE);
        return d.c.b.a.b.a(false);
    L35:
        com.obric.autogui.session.state.holderfile.a r16 = this.g;
        if (r16 == null) goto L38;
        r16.delete();
    L38:
        r1.f31438a = this;
        r1.f31441d = 3;
        if (this.b(r1) != r3) goto L42;
        return r3;
    L17:
        this = (b) ZeusTransformUtils.preCheckCast(r1.f31438a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r15);
    L23:
        com.obric.autogui.session.a.a.f30711a.a(com.obric.autogui.session.a.c.f30720a.a(), AutoActionConfigs.INSTANCE.getLongCfg("agent.local_journal_size", 83886080));
        com.obric.autogui.session.a.a.f30711a.a();
        this.n = true;
    L25:
        if (this.f31435e == 36) goto L27;
        r1.f31438a = this;
        r1.f31441d = 2;
        if (this.d(r1) != r3) goto L32;
        return r3;
    L27:
        return d.c.b.a.b.a(true);
    L18:
        d.o.a(r15);
        this.m++;
        Loog.INSTANCE.ip(TAG, new $$Lambda$b$lfUpnEXgXauLLQfzQmhMqUsCayc(this), new $$Lambda$b$lHmnk3Kp6tSiA6_42GtTvT6Ty3c(this));
        if (this.n == true) goto L25;
        com.obric.autogui.session.a.a r17 = com.obric.autogui.session.a.a.f30711a;
        r1.f31438a = this;
        r1.f31441d = 1;
        if (r17.a(r1) != r3) goto L23;
        return r3;
    L7:
        r1 = new d(this, r14);
        goto L8
    }

    private static final String f(b r2) {
        return "(ses/" + r2.f31434d + ") session cleanse in progress (round=" + r2.m + "/5).";
    }

    private static final String g(b r2) {
        return "session cleanse in progress (round=" + r2.m + "/5).";
    }

    private static final String h(b r2) {
        return "(ses/" + r2.f31434d + ") session cleanse failed on `FinishRemoteSession`.";
    }

    private static final String i(b r2) {
        return "(ses/" + r2.f31434d + ") session cleanse failed on `UploadRelatedAppInfo`.";
    }

    private static final String j(b r2) {
        return "(ses/" + r2.f31434d + ") session cleanse done.";
    }

    private final Object b(d.c.d<? super Boolean> r12) {
        d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r13, k.class) == false) goto L7;
        k r0 = (k) ZeusTransformUtils.preCheckCast(r13, k.class, "com.obric.aiagent.plugin");
        if ((r0.f31474e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f31474e -= Integer.MIN_VALUE;
    L8:
        k r8 = r0;
        Object r14 = r8.f31472c;
        Object r1 = d.c.a.b.a();
        int r2 = r8.f31474e;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        z.a r11 = (z.a) ZeusTransformUtils.preCheckCast(r8.f31471b, z.a.class, "com.obric.aiagent.plugin");
        b r3 = (b) ZeusTransformUtils.preCheckCast(r8.f31470a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r14);
        z.a r15 = r11;
        b this = r3;
    L17:
        this.o = r15.f38499a;
        return d.c.b.a.b.a(r15.f38499a);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r14);
        r15 = new z.a();
        com.obric.autogui.util.a r4 = com.obric.autogui.util.a.f31488a;
        String r5 = this.j + " uploadRelatedAppInfo";
        d.h.a.b<? super d.c.d<? super Boolean>, ? extends Object> r6 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new l(r15, this, null), d.h.a.b.class, "com.obric.aiagent.plugin");
        r8.f31470a = this;
        r8.f31471b = r15;
        r8.f31474e = 1;
        if (r4.a(r5, 3, 100, r6, r8) != r1) goto L17;
        return r1;
    L7:
        r0 = new k(this, r13);
        goto L8
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.obric.autogui.session.state.termination.b, java.lang.Class<com.obric.autogui.session.state.termination.b>] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x0153 -> B:61:0x01d2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0186 -> B:82:0x018d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x01a6 -> B:60:0x01ce). Please report as a decompilation issue!!! */
    private final Object c(d.c.d<? super com.obric.autogui.common.e> r19) {
        final ?? r3 = b.class;
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, e.class) == false) goto L7;
        e r6 = (e) ZeusTransformUtils.preCheckCast(r4, e.class, "com.obric.aiagent.plugin");
        if ((r6.i & Integer.MIN_VALUE) == 0) goto L7;
        r6.i -= Integer.MIN_VALUE;
    L8:
        Object r5 = r6.g;
        Object r7 = d.c.a.b.a();
        int r8 = r6.i;
        if (r8 == 0) goto L24;
        if (r8 == 1) goto L19;
        if (r8 != 2) goto L18;
        final b r9 = (b) ZeusTransformUtils.preCheckCast(r6.f31442a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r5);     // Catch: Throwable -> L15
    L69:
        final com.obric.autogui.tools.api.net.a.InterfaceC0861a r0 = (com.obric.autogui.tools.api.net.a.InterfaceC0861a) ZeusTransformUtils.preCheckCast(r5, com.obric.autogui.tools.api.net.a.InterfaceC0861a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        if (r0.a() == true) goto L73;
        com.obric.autogui.tools.api.net.b r1 = r0.a(r9.f31432b);     // Catch: Throwable -> L15
        r1.b();     // Catch: Throwable -> L15
        Loog.INSTANCE.e(TAG, "getShareUrlFromRemote failed: " + r1.getType());     // Catch: Throwable -> L15
        return com.obric.autogui.common.e.f29014b.b("getShareUrlFromRemote failed: " + r1.getType());
    L73:
        final String r2 = (String) ZeusTransformUtils.preCheckCast(r0.c(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        Loog.INSTANCE.dp(TAG, new $$Lambda$b$PCrbdRLpcNycs99YgvLiqgIpugA(r9, r0, r2), $$Lambda$b$yRqUXTvSyqcsfn0flXGtsm4P2I.INSTANCE);     // Catch: Throwable -> L15
        JsonObject r10 = (JsonObject) ZeusTransformUtils.preCheckCast(com.obric.autogui.util.b.f31495a.a().fromJson(r2, JsonObject.class), JsonObject.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        final int r11 = r10.get(MonitorConstants.CODE).getAsInt();     // Catch: Throwable -> L15
        final String r12 = r10.get("msg").getAsString();     // Catch: Throwable -> L15
        final String r13 = r10.get("log_id").getAsString();     // Catch: Throwable -> L15
        if (r11 == 0) goto L90;
        Loog.INSTANCE.ep(TAG, new $$Lambda$b$FOwedcCRSw8bdUQ7wjES6NakpMs(r9, r11, r12, r13), $$Lambda$b$c2PWbFBm499Tp7P2ptLni3Caw.INSTANCE);     // Catch: Throwable -> L15
        return com.obric.autogui.common.e.f29014b.b("uploadRelatedAppInfo, request failed: " + r11 + ", " + r12 + ", " + r13);
    L90:
        return com.obric.autogui.common.e.f29014b.a();
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        JsonObject r14 = (JsonObject) ZeusTransformUtils.preCheckCast(r6.f, JsonObject.class, "com.obric.aiagent.plugin");
        JsonObject r15 = (JsonObject) ZeusTransformUtils.preCheckCast(r6.f31446e, JsonObject.class, "com.obric.aiagent.plugin");
        IAutoActionAgentEventListener.OperatingAppInfo r16 = (IAutoActionAgentEventListener.OperatingAppInfo) ZeusTransformUtils.preCheckCast(r6.f31445d, IAutoActionAgentEventListener.OperatingAppInfo.class, "com.obric.aiagent.plugin");
        Iterator r17 = (Iterator) ZeusTransformUtils.preCheckCast(r6.f31444c, Iterator.class, "com.obric.aiagent.plugin");
        JsonArray r18 = (JsonArray) ZeusTransformUtils.preCheckCast(r6.f31443b, JsonArray.class, "com.obric.aiagent.plugin");
        r9 = (b) ZeusTransformUtils.preCheckCast(r6.f31442a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r5);     // Catch: Throwable -> L22
        IAutoActionAgentEventListener.OperatingAppInfo r110 = r16;
        JsonObject r111 = r15;
        JsonArray r112 = r18;
        Iterator r113 = r17;
        JsonObject r114 = r14;
    L82:
        String r20 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L52
        JsonObject r21 = r111;
    L60:
        final JsonObject r22 = r21;
        JsonObject r23 = r114;
        Iterator r115 = r113;
        JsonArray r116 = r112;
    L61:
        r23.addProperty("logo_url", r20);
        r116.add((JsonElement) ZeusTransformUtils.preCheckCast(r22, JsonElement.class, "com.obric.aiagent.plugin"));
        Loog.INSTANCE.dp(TAG, new $$Lambda$b$TNNqeQZ8omkrTre7sIQBudZhg(r9, r22), $$Lambda$b$a3i7jFVq3AXQbeTCior2a5E5hcU.INSTANCE);
    L40:
        if (r115.hasNext() == false) goto L62;
        final IAutoActionAgentEventListener.OperatingAppInfo r117 = (IAutoActionAgentEventListener.OperatingAppInfo) ZeusTransformUtils.preCheckCast(r115.next(), IAutoActionAgentEventListener.OperatingAppInfo.class, "com.obric.aiagent.plugin");
        r23 = new JsonObject();
        r23.addProperty("package_name", r117.getPackageName());
        r23.addProperty(IBdInstall.PARAM_APP_NAME, r117.getAppLabel().toString());
        if (r117.getAppIcon() != null) goto L87;
        Loog.INSTANCE.ip(TAG, new $$Lambda$b$bamdn4UKZKXEdfY9sG0oMOrwn2k(r9, r117), $$Lambda$b$jZ7NKumqRp4YnnWSoddZAKbQAso.INSTANCE);
        r22 = r23;
        r20 = "";
        goto L61
    L87:
        com.obric.autogui.imagex.b r24 = com.obric.autogui.imagex.b.f29105a;     // Catch: Throwable -> L56
        Context r25 = r9.f31432b;     // Catch: Throwable -> L56
        Drawable r118 = r117.getAppIcon();     // Catch: Throwable -> L56
        o.a(r118);     // Catch: Throwable -> L56
        r6.f31442a = r9;     // Catch: Throwable -> L56
        r6.f31443b = r116;     // Catch: Throwable -> L56
        r6.f31444c = r115;     // Catch: Throwable -> L56
        r6.f31445d = r117;     // Catch: Throwable -> L56
        r6.f31446e = r23;     // Catch: Throwable -> L56
        r6.f = r23;     // Catch: Throwable -> L56
        JsonObject r119 = r23;
        r6.i = 1;     // Catch: Throwable -> L54
        r5 = r24.a(r25, r118, r6);     // Catch: Throwable -> L54
        if (r5 != r7) goto L49;
        return r7;
    L49:
        r112 = r116;
        r110 = r117;
        r111 = r119;
        r113 = r115;
        r114 = r111;
    L54:
        Throwable th = th;
    L58:
        r112 = r116;
        r110 = r117;
        r111 = r119;
        r113 = r115;
        r114 = r111;
    L59:
        Loog.INSTANCE.e(TAG, r9.j + " doUploadRelatedAppInfo, uploadImage failed for app:" + r110.getPackageName(), th);
        r20 = "";
        r21 = r111;
        r6 = r6;
    L56:
        th = th;
        r119 = r23;
        goto L58
    L62:
        final JsonObject r26 = new JsonObject();
        r26.addProperty("session_id", r9.f31433c);
        r26.add("app_info", (JsonElement) ZeusTransformUtils.preCheckCast(r116, JsonElement.class, "com.obric.aiagent.plugin"));
        Loog.INSTANCE.dp(TAG, new $$Lambda$b$gT1iRHsIBE6gMR9LxUZbaeFH28U(r9, r26), $$Lambda$b$GNLoOnRxgiDyCX750jpuZXF4D7E.INSTANCE);
        String r27 = com.obric.autogui.a.a.f26086a.b();
        com.obric.autogui.tools.api.net.a r28 = com.obric.autogui.tools.a.a.f31480a.a();
        if (r28 != null) goto L66;
        Loog.INSTANCE.ep(TAG, new $$Lambda$b$M0TutLRzcQSBfHzKoFMGYsNcM(r9), $$Lambda$b$QXGDQ3BWg5LdU4hOtPyGzAPthdM.INSTANCE);
        return com.obric.autogui.common.e.f29014b.b("uploadRelatedAppInfo, network client is null");
    L66:
        String r29 = r26.toString();     // Catch: Throwable -> L15
        o.c(r29, "toString(...)");     // Catch: Throwable -> L15
        r6.f31442a = r9;     // Catch: Throwable -> L15
        r6.f31443b = null;     // Catch: Throwable -> L15
        r6.f31444c = null;     // Catch: Throwable -> L15
        r6.f31445d = null;     // Catch: Throwable -> L15
        r6.f31446e = null;     // Catch: Throwable -> L15
        r6.f = null;     // Catch: Throwable -> L15
        r6.i = 2;     // Catch: Throwable -> L15
        r5 = r28.a(r27, r29, 60000, r6);     // Catch: Throwable -> L15
        if (r5 != r7) goto L69;
        return r7;
    L52:
        th = th;
    L22:
        th = th;
        r110 = r16;
        r111 = r15;
        r112 = r18;
        r113 = r17;
        r114 = r14;
        goto L59
    L24:
        d.o.a(r5);
        c r30 = this.f;
        if (r30 != null) goto L28;
        Loog.INSTANCE.dp(TAG, new $$Lambda$b$VVCjmljcZMt_p_OQIK1haI6DF4(this));
        Loog.INSTANCE.w(TAG, "doUploadRelatedAppInfo, thingsToUpload is null, no need to upload");
        return com.obric.autogui.common.d.f29012a.a(com.obric.autogui.common.e.f29014b);
    L28:
        final Set<IAutoActionAgentEventListener.OperatingAppInfo> r31 = r30.b();
        Collection r32 = (Collection) ZeusTransformUtils.preCheckCast(r31, Collection.class, "com.obric.aiagent.plugin");
        if (r32 != null) goto L31;
    L34:
        boolean r33 = true;
    L35:
        if (r33 == false) goto L38;
        Loog.INSTANCE.ip(TAG, new $$Lambda$b$JoSaOo2PNIk1uFBRv9pJgA7FDc(this, r31), $$Lambda$b$bmdSN9360cm12KfFfGvmpUGwZtE.INSTANCE);
        return com.obric.autogui.common.d.f29012a.a(com.obric.autogui.common.e.f29014b);
    L38:
        JsonArray r34 = new JsonArray();
        r115 = ((Iterable) ZeusTransformUtils.preCheckCast(r31, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        r116 = r34;
        r9 = this;
        goto L40
    L31:
        if (r32.isEmpty() == true) goto L34;
        r33 = false;
    L15:
        th = move-exception;
        Loog.INSTANCE.ep(TAG, new $$Lambda$b$0sWDAIKJiTnlC88GdXaaWVg1g6Y(r3, th), $$Lambda$b$SGWIAwrRgankb6jEKudYTZB7V2c.INSTANCE);
        return com.obric.autogui.common.e.f29014b.b("uploadRelatedAppInfo, request failed: " + th);
    L7:
        r6 = new e(this, r4);
        goto L8
    }

    private static final String k(b r1) {
        return r1.j + " doUploadRelatedAppInfo, thingsToUpload is null, no need to upload";
    }

    private static final String a(b r2, Set r3) {
        return r2.j + " doUploadRelatedAppInfo, apps = " + ((Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin")) + ", no need to upload";
    }

    private static final String a(b r1, IAutoActionAgentEventListener.OperatingAppInfo r2) {
        return r1.j + " doUploadRelatedAppInfo, appIcon is null for app:" + r2.getPackageName();
    }

    private static final String a(b r1, JsonObject r2) {
        return r1.j + " uploadRelatedAppInfo, info: " + r2;
    }

    private static final String b(b r1, JsonObject r2) {
        return r1.j + " uploadRelatedAppInfo, requestBody: " + r2;
    }

    private static final String l(b r1) {
        return r1.j + " uploadRelatedAppInfo, client is null";
    }

    private static final String a(b r2, com.obric.autogui.tools.api.net.a.InterfaceC0861a r3, String r4) {
        return r2.j + " uploadRelatedAppInfo, response: " + ((com.obric.autogui.tools.api.net.a.InterfaceC0861a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autogui.tools.api.net.a.InterfaceC0861a.class, "com.obric.aiagent.plugin")) + ", payload: " + r4;
    }

    private static final String a(b r1, int r2, String r3, String r4) {
        return r1.j + " uploadRelatedAppInfo, request failed: " + r2 + ", " + r3 + ", " + r4;
    }

    private static final String a(b r1, Throwable r2) {
        return r1.j + " uploadRelatedAppInfo, request failed: " + r2;
    }

    private final Object d(d.c.d<? super Boolean> r11) {
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, f.class) == false) goto L7;
        f r0 = (f) ZeusTransformUtils.preCheckCast(r12, f.class, "com.obric.aiagent.plugin");
        if ((r0.f31451e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f31451e -= Integer.MIN_VALUE;
    L8:
        f r8 = r0;
        Object r13 = r8.f31449c;
        Object r1 = d.c.a.b.a();
        int r2 = r8.f31451e;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        z.a r10 = (z.a) ZeusTransformUtils.preCheckCast(r8.f31448b, z.a.class, "com.obric.aiagent.plugin");
        b r3 = (b) ZeusTransformUtils.preCheckCast(r8.f31447a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r13);
        final z.a r14 = r10;
        final b this = r3;
    L17:
        Loog.INSTANCE.dp(TAG, new $$Lambda$b$21xU4nRmp8eQFVE604N6YieEvs(this, r14), new $$Lambda$b$HXBZ2QZvybpKjVOMYitaXpI2hgA(r14));
        this.p = r14.f38499a;
        return d.c.b.a.b.a(r14.f38499a);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r13);
        r14 = new z.a();
        com.obric.autogui.util.a r4 = com.obric.autogui.util.a.f31488a;
        d.h.a.b<? super d.c.d<? super Boolean>, ? extends Object> r7 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new g(this, r14, null), d.h.a.b.class, "com.obric.aiagent.plugin");
        r8.f31447a = this;
        r8.f31448b = r14;
        r8.f31451e = 1;
        if (r4.a("finishRemoteSession", 3, 100, r7, r8) != r1) goto L17;
        return r1;
    L7:
        r0 = new f(this, r12);
        goto L8
    }

    private static final String a(b r2, z.a r3) {
        return r2.j + " finishRemoteSession - done (ok=" + r3.f38499a + "), id: " + r2.f31433c;
    }

    private static final String a(z.a r2) {
        return "finishRemoteSession - done (ok=" + r2.f38499a + ')';
    }

    private final Object a(final String r12, d.c.d<? super com.obric.autogui.common.e> r13) {
        d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, h.class) == false) goto L7;
        h r2 = (h) ZeusTransformUtils.preCheckCast(r14, h.class, "com.obric.aiagent.plugin");
        if ((r2.f31458d & Integer.MIN_VALUE) == 0) goto L7;
        r2.f31458d -= Integer.MIN_VALUE;
    L8:
        Object r15 = r2.f31456b;
        Object r4 = d.c.a.b.a();
        int r5 = r2.f31458d;
        if (r5 == 0) goto L18;
        if (r5 != 1) goto L17;
        final b this = (b) ZeusTransformUtils.preCheckCast(r2.f31455a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r15);     // Catch: Throwable -> L14
    L35:
        final com.obric.autogui.tools.api.net.a.InterfaceC0861a r16 = (com.obric.autogui.tools.api.net.a.InterfaceC0861a) ZeusTransformUtils.preCheckCast(r15, com.obric.autogui.tools.api.net.a.InterfaceC0861a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        if (r16.a() == true) goto L39;
        com.obric.autogui.tools.api.net.b r17 = r16.a(this.f31432b);     // Catch: Throwable -> L14
        r17.b();     // Catch: Throwable -> L14
        Loog.INSTANCE.e(TAG, "finishSession failed: " + r17.getType());     // Catch: Throwable -> L14
        return com.obric.autogui.common.e.f29014b.b("finishSession failed: " + r17.getType());
    L39:
        final String r18 = (String) ZeusTransformUtils.preCheckCast(r16.c(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        Loog.INSTANCE.dp(TAG, new $$Lambda$b$pGhyLIuW6BR2i28NtCr25fWFE(this, r16, r18), $$Lambda$b$wbqQXJe4P8frLjlU82qRzL39Uw.INSTANCE);     // Catch: Throwable -> L14
        JsonObject r19 = (JsonObject) ZeusTransformUtils.preCheckCast(com.obric.autogui.util.b.f31495a.a().fromJson(r18, JsonObject.class), JsonObject.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        final int r110 = r19.get(MonitorConstants.CODE).getAsInt();     // Catch: Throwable -> L14
        final String r1 = r19.get("msg").getAsString();     // Catch: Throwable -> L14
        final String r111 = r19.get("log_id").getAsString();     // Catch: Throwable -> L14
        if (r110 == 0) goto L48;
        Loog.INSTANCE.ep(TAG, new $$Lambda$b$HOCvcVyo4ovtqO9_RUDdHFIRvqE(this, r110, r1, r111), $$Lambda$b$GR7873EExFH9x7C2TsL8jiNK8.INSTANCE);     // Catch: Throwable -> L14
        return com.obric.autogui.common.e.f29014b.b("finishSession, request failed: " + r110 + ", " + r1 + ", " + r111);
    L48:
        return com.obric.autogui.common.e.f29014b.a();
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r15);
        Loog.INSTANCE.dp(TAG, new $$Lambda$b$dS93rQp5tuLnJqWLv2QFOlVCqZ8(this, r12), $$Lambda$b$S9Xl9vkELOQ3RfKXF69fi9YA8BQ.INSTANCE);
        c r112 = this.f;
        if (r112 == null) goto L21;
        Integer r113 = d.c.b.a.b.a(r112.a());
    L22:
        if (r113 != null) goto L24;
        com.obric.autogui.agents.vlm.models.b r114 = com.obric.autogui.agents.vlm.models.b.f27277a.a(((Number) ZeusTransformUtils.preCheckCast(com.obric.autogui.common.a.m.f28999a.a(this.f31432b).e().d(), Number.class, "com.obric.aiagent.plugin")).intValue());
        Loog.INSTANCE.d(TAG, " - Finalizer's `model_name` not configured; using current modelName: " + r114.a());
        String r115 = r114.a();
    L25:
        JSONObject r6 = new JSONObject();
        r6.put("session_id", r12);
        r6.put("session_origin", this.f31435e);
        r6.put("request_type", com.obric.autogui.a.a.c.f26110d.a());
        r6.put("model_name", r115);
        String r116 = this.h;
        if (r116 != null) goto L28;
        r116 = AODeviceInfo.INSTANCE.getRpDid();
    L28:
        r6.put("device_id", r116);
        r6.put("att_string", this.i);
        r6.put(WsConstants.KEY_APP_VERSION, AOHostAppTools.INSTANCE.getAppVersionCode());
        String r117 = com.obric.autogui.a.a.f26086a.a();
        com.obric.autogui.tools.api.net.a r118 = com.obric.autogui.tools.a.a.f31480a.a();
        if (r118 != null) goto L32;
        Loog.INSTANCE.ep(TAG, new $$Lambda$b$lAknBe5Xff_7Ni4liIfIj15PiuY(this), $$Lambda$b$3L8o9e_s8kM_nCy7We37E6vtGMc.INSTANCE);
        return com.obric.autogui.common.e.f29014b.b("finishSession, network client is null");
    L32:
        String r7 = r6.toString();     // Catch: Throwable -> L14
        o.c(r7, "toString(...)");     // Catch: Throwable -> L14
        r2.f31455a = this;     // Catch: Throwable -> L14
        r2.f31458d = 1;     // Catch: Throwable -> L14
        r15 = r118.a(r117, r7, 60000, r2);     // Catch: Throwable -> L14
        if (r15 != r4) goto L35;
        return r4;
    L24:
        r115 = com.obric.autogui.agents.vlm.models.b.f27277a.a(r113.intValue()).a();
        goto L25
    L21:
        r113 = null;
    L14:
        th = move-exception;
        Loog.INSTANCE.ep(TAG, new $$Lambda$b$OHY4wPatyr50PJdO_xz1FBtvXgI(this, th), $$Lambda$b$Mrf9ShOwKEyKtJLY0YZ3jF9g07Y.INSTANCE);
        return com.obric.autogui.common.e.f29014b.b("finishSession, request failed: " + th);
    L7:
        r2 = new h(this, r14);
        goto L8
    }

    private static final String a(b r1, String r2) {
        return r1.j + " finishSession, id: " + r2;
    }

    private static final String m(b r1) {
        return r1.j + " finishSession, client is null";
    }

    private static final String b(b r2, com.obric.autogui.tools.api.net.a.InterfaceC0861a r3, String r4) {
        return r2.j + " finishSession, response: " + ((com.obric.autogui.tools.api.net.a.InterfaceC0861a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autogui.tools.api.net.a.InterfaceC0861a.class, "com.obric.aiagent.plugin")) + ", payload: " + r4;
    }

    private static final String b(b r1, int r2, String r3, String r4) {
        return r1.j + " finishSession, request failed: " + r2 + ", " + r3 + ", " + r4;
    }

    private static final String b(b r1, Throwable r2) {
        return r1.j + " finishSession, request failed: " + r2;
    }
}
