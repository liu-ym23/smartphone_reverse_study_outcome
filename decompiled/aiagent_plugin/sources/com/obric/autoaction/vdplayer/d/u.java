package com.obric.autoaction.vdplayer.d;

import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.lifecycle.aj;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.AutoOperateTask;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.configs.AutoActionConfigs;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.presentation.AutoActionUIContext;
import com.obric.autogui.common.api.presentation.GlobalUIContext;
import com.obric.autogui.vdplayer.api.feedback.IFeedbackApi;
import com.obric.autogui.vdplayer.api.orchestrator.IAgentSessionManager;
import com.obric.capabilitykit.entity.app.EntityType;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.b.ak;

/* JADX INFO: compiled from: VDPlayerViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class u extends com.obric.autoaction.vdplayer.c.d<s, r, q> {
    private static final String TAG = "VDPlayerViewModel";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f25565a = null;
    private static final long q = 0;
    private static d.m<String, s> r;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autoaction.vdplayer.b.a.g f25566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.autoaction.vdplayer.b.a.f f25567c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.obric.autoaction.vdplayer.b.a.b f25568d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.obric.autoaction.vdplayer.b.a.a f25569e;
    private final com.obric.autoaction.vdplayer.b.a.c f;
    private final com.obric.autoaction.vdplayer.b.a.d g;
    private final com.obric.autoaction.vdplayer.b.a.h h;
    private final com.obric.autoaction.vdplayer.b.b.a i;
    private final com.obric.autoaction.vdplayer.b.b.b j;
    private final com.obric.autoaction.vdplayer.b.a.e k;
    private com.obric.autoaction.vdplayer.d.a.a l;
    private com.obric.autoaction.vdplayer.d.a.a m;
    private IAgentSessionManager.a n;
    private boolean o;
    private String p;

    /* JADX INFO: compiled from: VDPlayerViewModel.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: VDPlayerViewModel.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25570a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f25571b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f25572c = null;

        static {
            int[] r0 = new int[com.obric.autoaction.vdplayer.d.j.values().length];
            r0[com.obric.autoaction.vdplayer.d.j.f25497a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L29:
            r0[com.obric.autoaction.vdplayer.d.j.f25498b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L37:
            r0[com.obric.autoaction.vdplayer.d.j.f25499c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L8:
            f25570a = r0;
            int[] r1 = new int[com.obric.autoaction.vdplayer.d.l.values().length];
            r1[com.obric.autoaction.vdplayer.d.l.f25511e.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L31:
            r1[com.obric.autoaction.vdplayer.d.l.f.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L11:
            f25571b = r1;
            int[] r2 = new int[com.obric.autoaction.vdplayer.b.a.a.EnumC0606a.values().length];
            r2[com.obric.autoaction.vdplayer.b.a.a.EnumC0606a.f25181a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L33:
            r2[com.obric.autoaction.vdplayer.b.a.a.EnumC0606a.f25182b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L25:
            r2[com.obric.autoaction.vdplayer.b.a.a.EnumC0606a.f25183c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L15:
            f25572c = r2;
        }
    }

    /* JADX INFO: compiled from: VDPlayerViewModel.kt */
    @d.c.b.a.f(b = "VDPlayerViewModel.kt", c = {699, EntityType.ALARM}, d = "exitUserOperating", e = "com.obric.autoaction.vdplayer.vm.VDPlayerViewModel")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f25573a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f25574b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f25575c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ u f25576d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f25577e;

        c(u r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25576d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f25575c = r3;
            this.f25577e |= Integer.MIN_VALUE;
            return u.a(this.f25576d, false, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: VDPlayerViewModel.kt */
    @d.c.b.a.f(b = "VDPlayerViewModel.kt", c = {587}, d = "handleConfirmEnterCallUser", e = "com.obric.autoaction.vdplayer.vm.VDPlayerViewModel")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f25578a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f25579b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ u f25580c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f25581d;

        d(u r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25580c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f25579b = r3;
            this.f25581d |= Integer.MIN_VALUE;
            return u.a(this.f25580c, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: VDPlayerViewModel.kt */
    @d.c.b.a.f(b = "VDPlayerViewModel.kt", c = {725}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.vm.VDPlayerViewModel$handleTaskEnd$1")
    static final class e extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25582a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f25583b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ u f25584c;

        e(boolean r3, u r4, d.c.d<? super e> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25583b = r3;
            this.f25584c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f25583b, this.f25584c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25582a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L11:
            Loog.INSTANCE.i(u.TAG, "open app by model config (delayed) " + this.f25583b);
            if (this.f25583b == false) goto L25;
            u r8 = this.f25584c;
            IAgentSessionManager.a r6 = u.a(this.f25584c);
            if (r6 == null) goto L22;
            ak<com.obric.autogui.vdplayer.api.a.b> r9 = r6.b();
            if (r9 == null) goto L22;
            com.obric.autogui.vdplayer.api.a.b r10 = (com.obric.autogui.vdplayer.api.a.b) ZeusTransformUtils.preCheckCast(r9.c(), com.obric.autogui.vdplayer.api.a.b.class, "com.obric.aiagent.plugin");
            if (r10 == null) goto L22;
            List<IAutoActionAgentEventListener.OperatingAppInfo> r11 = r10.c();
            if (r11 == null) goto L22;
            IAutoActionAgentEventListener.OperatingAppInfo r12 = (IAutoActionAgentEventListener.OperatingAppInfo) ZeusTransformUtils.preCheckCast(d.a.p.n(r11), IAutoActionAgentEventListener.OperatingAppInfo.class, "com.obric.aiagent.plugin");
        L23:
            u.a(r8, (q) ZeusTransformUtils.preCheckCast(new q.b(r12), q.class, "com.obric.aiagent.plugin"));
        L22:
            r12 = null;
        L25:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            d.c.d r13 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25582a = 1;
            if (ax.a(300, r13) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: VDPlayerViewModel.kt */
    @d.c.b.a.f(b = "VDPlayerViewModel.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.vm.VDPlayerViewModel$launchAutoExitCountDown$3$2")
    static final class f extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25585a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ u f25586b;

        f(u r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25586b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f25586b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f25585a != 0) goto L7;
            d.o.a(r2);
            u.c(this.f25586b, false);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: VDPlayerViewModel.kt */
    @d.c.b.a.f(b = "VDPlayerViewModel.kt", c = {651}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.vm.VDPlayerViewModel$launchCountDownEffect$2$2")
    static final class g extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25587a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ u f25588b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f25589c;

        g(u r3, boolean r4, d.c.d<? super g> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25588b = r3;
            this.f25589c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((g) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new g(this.f25588b, this.f25589c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25587a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            u r7 = this.f25588b;
            boolean r2 = this.f25589c;
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25587a = 1;
            if (u.a(r7, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: VDPlayerViewModel.kt */
    @d.c.b.a.f(b = "VDPlayerViewModel.kt", c = {353}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.vm.VDPlayerViewModel$logStateOnDebug$1")
    static final class h extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25590a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ u f25591b;

        h(u r3, d.c.d<? super h> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25591b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new h(this.f25591b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25590a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            d.o.a(r6);
        L12:
            throw new d.d();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            ak<s> r7 = this.f25591b.b();
            kotlinx.coroutines.b.i<? super s> r2 = (kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(AnonymousClass1.f25592a, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
            d.c.d<?> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25590a = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: VDPlayerViewModel.kt */
    @d.c.b.a.f(b = "VDPlayerViewModel.kt", c = {339}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.vm.VDPlayerViewModel$observePanelIdle$1")
    static final class i extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25593a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ u f25594b;

        /* JADX INFO: compiled from: SafeCollector.common.kt */
        public static final class a implements kotlinx.coroutines.b.h<com.obric.autoaction.vdplayer.d.l> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.b.h f25596a;

            /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.d.u$i$a$1, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            public static final class AnonymousClass1<T> implements kotlinx.coroutines.b.i {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ kotlinx.coroutines.b.i f25597a;

                /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.d.u$i$a$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @d.c.b.a.f(b = "VDPlayerViewModel.kt", c = {219}, d = "emit", e = "com.obric.autoaction.vdplayer.vm.VDPlayerViewModel$observePanelIdle$1$invokeSuspend$$inlined$map$1$2")
                public static final class C06261 extends d.c.b.a.d {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f25598a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f25599b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    final /* synthetic */ AnonymousClass1 f25600c;

                    public C06261(AnonymousClass1 r3, d.c.d r4) {
                        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                        this.f25600c = r3;
                        super(r5);
                    }

                    @Override // d.c.b.a.a
                    public final Object invokeSuspend(Object r3) {
                        this.f25598a = r3;
                        this.f25599b |= Integer.MIN_VALUE;
                        return this.f25600c.emit(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
                    }
                }

                public AnonymousClass1(kotlinx.coroutines.b.i r3) {
                    this.f25597a = (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
                }

                @Override // kotlinx.coroutines.b.i
                public final Object emit(Object r6, d.c.d r7) {
                    d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                    if (ZeusTransformUtils.instanceOf(r8, C06261.class) == false) goto L7;
                    C06261 r0 = (C06261) ZeusTransformUtils.preCheckCast(r8, C06261.class, "com.obric.aiagent.plugin");
                    if ((r0.f25599b & Integer.MIN_VALUE) == 0) goto L7;
                    r0.f25599b -= Integer.MIN_VALUE;
                L8:
                    Object r9 = r0.f25598a;
                    Object r2 = d.c.a.b.a();
                    int r3 = r0.f25599b;
                    if (r3 == 0) goto L14;
                    if (r3 != 1) goto L13;
                    d.o.a(r9);
                L18:
                    return x.f38692a;
                L13:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L14:
                    d.o.a(r9);
                    kotlinx.coroutines.b.i r5 = this.f25597a;
                    d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
                    com.obric.autoaction.vdplayer.d.l r11 = ((s) ZeusTransformUtils.preCheckCast(r6, s.class, "com.obric.aiagent.plugin")).b().a().a();
                    r0.f25599b = 1;
                    if (r5.emit(r11, r0) != r2) goto L18;
                    return r2;
                L7:
                    r0 = new C06261(this, r8);
                    goto L8
                }
            }

            public a(kotlinx.coroutines.b.h r3) {
                this.f25596a = (kotlinx.coroutines.b.h) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
            }

            @Override // kotlinx.coroutines.b.h
            public Object collect(kotlinx.coroutines.b.i<? super com.obric.autoaction.vdplayer.d.l> r3, d.c.d r4) {
                kotlinx.coroutines.b.i r5 = (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
                d.c.d<? super x> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                Object r2 = this.f25596a.collect((kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin"), r6);
                if (r2 != d.c.a.b.a()) goto L6;
                return r2;
            L6:
                return x.f38692a;
            }
        }

        i(u r3, d.c.d<? super i> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25594b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((i) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), i.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new i(this.f25594b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25593a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            kotlinx.coroutines.b.h r7 = kotlinx.coroutines.b.j.b((kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(new a((kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(this.f25594b.b(), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin")), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin"));
            final u r4 = this.f25594b;
            kotlinx.coroutines.b.i r2 = (kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r4), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
            d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25593a = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: VDPlayerViewModel.kt */
    @d.c.b.a.f(b = "VDPlayerViewModel.kt", c = {307}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.vm.VDPlayerViewModel$observeSecureLayer$1")
    static final class j extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25601a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ u f25602b;

        j(u r3, d.c.d<? super j> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25602b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((j) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), j.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new j(this.f25602b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25601a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            kotlinx.coroutines.b.h<Boolean> r7 = u.f(this.f25602b).b();
            final u r3 = this.f25602b;
            kotlinx.coroutines.b.i<? super Boolean> r2 = (kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
            d.c.d<? super x> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25601a = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: VDPlayerViewModel.kt */
    @d.c.b.a.f(b = "VDPlayerViewModel.kt", c = {315}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.vm.VDPlayerViewModel$observeUserOperating$1")
    static final class k extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25604a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ u f25605b;

        /* JADX INFO: compiled from: SafeCollector.common.kt */
        public static final class a implements kotlinx.coroutines.b.h<com.obric.autoaction.vdplayer.d.o> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.b.h f25608a;

            /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.d.u$k$a$1, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            public static final class AnonymousClass1<T> implements kotlinx.coroutines.b.i {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ kotlinx.coroutines.b.i f25609a;

                /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.d.u$k$a$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @d.c.b.a.f(b = "VDPlayerViewModel.kt", c = {219}, d = "emit", e = "com.obric.autoaction.vdplayer.vm.VDPlayerViewModel$observeUserOperating$1$invokeSuspend$$inlined$map$1$2")
                public static final class C06271 extends d.c.b.a.d {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f25610a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f25611b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    final /* synthetic */ AnonymousClass1 f25612c;

                    public C06271(AnonymousClass1 r3, d.c.d r4) {
                        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                        this.f25612c = r3;
                        super(r5);
                    }

                    @Override // d.c.b.a.a
                    public final Object invokeSuspend(Object r3) {
                        this.f25610a = r3;
                        this.f25611b |= Integer.MIN_VALUE;
                        return this.f25612c.emit(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
                    }
                }

                public AnonymousClass1(kotlinx.coroutines.b.i r3) {
                    this.f25609a = (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
                }

                @Override // kotlinx.coroutines.b.i
                public final Object emit(Object r6, d.c.d r7) {
                    d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                    if (ZeusTransformUtils.instanceOf(r8, C06271.class) == false) goto L7;
                    C06271 r0 = (C06271) ZeusTransformUtils.preCheckCast(r8, C06271.class, "com.obric.aiagent.plugin");
                    if ((r0.f25611b & Integer.MIN_VALUE) == 0) goto L7;
                    r0.f25611b -= Integer.MIN_VALUE;
                L8:
                    Object r9 = r0.f25610a;
                    Object r2 = d.c.a.b.a();
                    int r3 = r0.f25611b;
                    if (r3 == 0) goto L14;
                    if (r3 != 1) goto L13;
                    d.o.a(r9);
                L18:
                    return x.f38692a;
                L13:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L14:
                    d.o.a(r9);
                    kotlinx.coroutines.b.i r5 = this.f25609a;
                    d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
                    com.obric.autoaction.vdplayer.d.o r11 = ((s) ZeusTransformUtils.preCheckCast(r6, s.class, "com.obric.aiagent.plugin")).e();
                    r0.f25611b = 1;
                    if (r5.emit(r11, r0) != r2) goto L18;
                    return r2;
                L7:
                    r0 = new C06271(this, r8);
                    goto L8
                }
            }

            public a(kotlinx.coroutines.b.h r3) {
                this.f25608a = (kotlinx.coroutines.b.h) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
            }

            @Override // kotlinx.coroutines.b.h
            public Object collect(kotlinx.coroutines.b.i<? super com.obric.autoaction.vdplayer.d.o> r3, d.c.d r4) {
                kotlinx.coroutines.b.i r5 = (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
                d.c.d<? super x> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                Object r2 = this.f25608a.collect((kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin"), r6);
                if (r2 != d.c.a.b.a()) goto L6;
                return r2;
            L6:
                return x.f38692a;
            }
        }

        k(u r3, d.c.d<? super k> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25605b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((k) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), k.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new k(this.f25605b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25604a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            kotlinx.coroutines.b.h r7 = kotlinx.coroutines.b.j.b((kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(new a((kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(this.f25605b.b(), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin")), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin"));
            final u r4 = this.f25605b;
            kotlinx.coroutines.b.i r2 = (kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r4), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
            d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25604a = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: VDPlayerViewModel.kt */
    @d.c.b.a.f(b = "VDPlayerViewModel.kt", c = {289}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.vm.VDPlayerViewModel$subscribeToSessionData$1")
    static final class l extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25613a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ u f25614b;

        /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.d.u$l$1, reason: invalid class name */
        /* JADX INFO: compiled from: VDPlayerViewModel.kt */
        @d.c.b.a.f(b = "VDPlayerViewModel.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.vm.VDPlayerViewModel$subscribeToSessionData$1$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<IAgentSessionManager.a, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f25615a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f25616b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ u f25617c;

            AnonymousClass1(u r3, d.c.d<? super AnonymousClass1> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f25617c = r3;
                super(2, r5);
            }

            public static /* synthetic */ s lambda$sbqXF1M4nOBbfcptJ5N7VVDav1k(s r0) {
                return a(r0);
            }

            public final Object a(IAgentSessionManager.a r3, d.c.d<? super x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((IAgentSessionManager.a) ZeusTransformUtils.wrapperContextForParams(r3, IAgentSessionManager.a.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                AnonymousClass1 r0 = new AnonymousClass1(this.f25617c, r5);
                r0.f25616b = r3;
                return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(IAgentSessionManager.a r3, d.c.d<? super x> r4) {
                return a((IAgentSessionManager.a) ZeusTransformUtils.preCheckCast(r3, IAgentSessionManager.a.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r7) {
                d.c.a.b.a();
                if (this.f25615a != 0) goto L29;
                d.o.a(r7);
                IAgentSessionManager.a r8 = (IAgentSessionManager.a) ZeusTransformUtils.preCheckCast(this.f25616b, IAgentSessionManager.a.class, "com.obric.aiagent.plugin");
                if (r8 != null) goto L8;
                Loog.INSTANCE.i(u.TAG, "Active session is null, finishing.");
                u.a(this.f25617c, (q) ZeusTransformUtils.preCheckCast(q.a.f25526a, q.class, "com.obric.aiagent.plugin"));
                return x.f38692a;
            L8:
                IAgentSessionManager.a r2 = u.a(this.f25617c);
                String r3 = null;
                if (r2 == null) goto L17;
                ak<com.obric.autogui.vdplayer.api.a.b> r4 = r2.b();
                if (r4 == null) goto L17;
                com.obric.autogui.vdplayer.api.a.b r5 = (com.obric.autogui.vdplayer.api.a.b) ZeusTransformUtils.preCheckCast(r4.c(), com.obric.autogui.vdplayer.api.a.b.class, "com.obric.aiagent.plugin");
                if (r5 == null) goto L17;
                IAutoActionAgentEventListener.SessionInfo r6 = r5.a();
                if (r6 == null) goto L17;
                String r9 = r6.getSessionKey();
            L18:
                IAutoActionAgentEventListener.SessionInfo r10 = ((com.obric.autogui.vdplayer.api.a.b) ZeusTransformUtils.preCheckCast(r8.b().c(), com.obric.autogui.vdplayer.api.a.b.class, "com.obric.aiagent.plugin")).a();
                if (r10 == null) goto L21;
                r3 = r10.getSessionKey();
            L21:
                u.a(this.f25617c, r8);
                if (r9 == null) goto L27;
                if (d.h.b.o.a(r9, r3) == true) goto L27;
                Loog.INSTANCE.i(u.TAG, "ActiveSession changed: " + r9 + " -> " + r3);
                u.a(this.f25617c, (q) ZeusTransformUtils.preCheckCast(q.h.f25533a, q.class, "com.obric.aiagent.plugin"));
                u.a(this.f25617c, $$Lambda$u$l$1$sbqXF1M4nOBbfcptJ5N7VVDav1k.INSTANCE);
            L27:
                return x.f38692a;
            L17:
                r9 = null;
                goto L18
            L29:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            private static final s a(s r10) {
                return new s(null, null, null, null, false, null, null, 127, null);
            }
        }

        /* JADX INFO: compiled from: Merge.kt */
        @d.c.b.a.f(b = "VDPlayerViewModel.kt", c = {189}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.vm.VDPlayerViewModel$subscribeToSessionData$1$invokeSuspend$$inlined$flatMapLatest$1")
        public static final class a extends d.c.b.a.l implements d.h.a.q<kotlinx.coroutines.b.i<? super r>, IAgentSessionManager.a, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f25619a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f25620b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ u f25621c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private /* synthetic */ Object f25622d;

            public a(d.c.d r3, u r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                this.f25621c = r4;
                super(3, r5);
            }

            public final Object a(kotlinx.coroutines.b.i<? super r> r3, IAgentSessionManager.a r4, d.c.d<? super x> r5) {
                kotlinx.coroutines.b.i r6 = (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
                a r0 = new a((d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"), this.f25621c);
                r0.f25622d = r6;
                r0.f25620b = r4;
                return r0.invokeSuspend(x.f38692a);
            }

            @Override // d.h.a.q
            public /* synthetic */ Object invoke(kotlinx.coroutines.b.i<? super r> r3, IAgentSessionManager.a r4, d.c.d<? super x> r5) {
                return a((kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin"), r4, (d.c.d) ZeusTransformUtils.preCheckCast(r5, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r8) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f25619a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r8);
            L12:
                return x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r8);
                kotlinx.coroutines.b.i r9 = (kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(this.f25622d, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
                Object r2 = this.f25620b;
                d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                IAgentSessionManager.a r3 = (IAgentSessionManager.a) ZeusTransformUtils.preCheckCast(r2, IAgentSessionManager.a.class, "com.obric.aiagent.plugin");
                kotlinx.coroutines.b.h r5 = kotlinx.coroutines.b.j.a(new kotlinx.coroutines.b.h[]{kotlinx.coroutines.b.j.b((kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(new b((kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(r3.b(), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin"), this.f25621c), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin")), (kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(new c(r3.a()), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin")});
                d.c.d r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f25619a = 1;
                if (kotlinx.coroutines.b.j.a(r9, r5, r6) != r0) goto L12;
                return r0;
            }
        }

        /* JADX INFO: compiled from: SafeCollector.common.kt */
        public static final class b implements kotlinx.coroutines.b.h<r.h> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.b.h f25623a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ u f25624b;

            /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.d.u$l$b$1, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            public static final class AnonymousClass1<T> implements kotlinx.coroutines.b.i {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ kotlinx.coroutines.b.i f25625a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ u f25626b;

                /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.d.u$l$b$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @d.c.b.a.f(b = "VDPlayerViewModel.kt", c = {219}, d = "emit", e = "com.obric.autoaction.vdplayer.vm.VDPlayerViewModel$subscribeToSessionData$1$invokeSuspend$lambda$2$$inlined$map$1$2")
                public static final class C06281 extends d.c.b.a.d {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f25627a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f25628b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    final /* synthetic */ AnonymousClass1 f25629c;

                    public C06281(AnonymousClass1 r3, d.c.d r4) {
                        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                        this.f25629c = r3;
                        super(r5);
                    }

                    @Override // d.c.b.a.a
                    public final Object invokeSuspend(Object r3) {
                        this.f25627a = r3;
                        this.f25628b |= Integer.MIN_VALUE;
                        return this.f25629c.emit(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
                    }
                }

                public AnonymousClass1(kotlinx.coroutines.b.i r3, u r4) {
                    this.f25625a = (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
                    this.f25626b = r4;
                }

                @Override // kotlinx.coroutines.b.i
                public final Object emit(Object r6, d.c.d r7) {
                    d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                    if (ZeusTransformUtils.instanceOf(r8, C06281.class) == false) goto L7;
                    C06281 r0 = (C06281) ZeusTransformUtils.preCheckCast(r8, C06281.class, "com.obric.aiagent.plugin");
                    if ((r0.f25628b & Integer.MIN_VALUE) == 0) goto L7;
                    r0.f25628b -= Integer.MIN_VALUE;
                L8:
                    Object r9 = r0.f25627a;
                    Object r2 = d.c.a.b.a();
                    int r3 = r0.f25628b;
                    if (r3 == 0) goto L14;
                    if (r3 != 1) goto L13;
                    d.o.a(r9);
                L18:
                    return x.f38692a;
                L13:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L14:
                    d.o.a(r9);
                    kotlinx.coroutines.b.i r10 = this.f25625a;
                    d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
                    r.h r1 = new r.h(u.a(this.f25626b, (com.obric.autogui.vdplayer.api.a.b) ZeusTransformUtils.preCheckCast(r6, com.obric.autogui.vdplayer.api.a.b.class, "com.obric.aiagent.plugin")));
                    r0.f25628b = 1;
                    if (r10.emit(r1, r0) != r2) goto L18;
                    return r2;
                L7:
                    r0 = new C06281(this, r8);
                    goto L8
                }
            }

            public b(kotlinx.coroutines.b.h r3, u r4) {
                this.f25623a = (kotlinx.coroutines.b.h) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
                this.f25624b = r4;
            }

            @Override // kotlinx.coroutines.b.h
            public Object collect(kotlinx.coroutines.b.i<? super r.h> r4, d.c.d r5) {
                kotlinx.coroutines.b.i r6 = (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
                d.c.d<? super x> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                Object r3 = this.f25623a.collect((kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r6, this.f25624b), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin"), r7);
                if (r3 != d.c.a.b.a()) goto L6;
                return r3;
            L6:
                return x.f38692a;
            }
        }

        /* JADX INFO: compiled from: SafeCollector.common.kt */
        public static final class c implements kotlinx.coroutines.b.h<r.g> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.b.h f25630a;

            /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.d.u$l$c$1, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            public static final class AnonymousClass1<T> implements kotlinx.coroutines.b.i {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ kotlinx.coroutines.b.i f25631a;

                /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.d.u$l$c$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @d.c.b.a.f(b = "VDPlayerViewModel.kt", c = {219}, d = "emit", e = "com.obric.autoaction.vdplayer.vm.VDPlayerViewModel$subscribeToSessionData$1$invokeSuspend$lambda$2$$inlined$map$2$2")
                public static final class C06291 extends d.c.b.a.d {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f25632a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f25633b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    final /* synthetic */ AnonymousClass1 f25634c;

                    public C06291(AnonymousClass1 r3, d.c.d r4) {
                        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                        this.f25634c = r3;
                        super(r5);
                    }

                    @Override // d.c.b.a.a
                    public final Object invokeSuspend(Object r3) {
                        this.f25632a = r3;
                        this.f25633b |= Integer.MIN_VALUE;
                        return this.f25634c.emit(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
                    }
                }

                public AnonymousClass1(kotlinx.coroutines.b.i r3) {
                    this.f25631a = (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
                }

                @Override // kotlinx.coroutines.b.i
                public final Object emit(Object r6, d.c.d r7) {
                    d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                    if (ZeusTransformUtils.instanceOf(r8, C06291.class) == false) goto L7;
                    C06291 r0 = (C06291) ZeusTransformUtils.preCheckCast(r8, C06291.class, "com.obric.aiagent.plugin");
                    if ((r0.f25633b & Integer.MIN_VALUE) == 0) goto L7;
                    r0.f25633b -= Integer.MIN_VALUE;
                L8:
                    Object r9 = r0.f25632a;
                    Object r2 = d.c.a.b.a();
                    int r3 = r0.f25633b;
                    if (r3 == 0) goto L14;
                    if (r3 != 1) goto L13;
                    d.o.a(r9);
                L18:
                    return x.f38692a;
                L13:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L14:
                    d.o.a(r9);
                    kotlinx.coroutines.b.i r5 = this.f25631a;
                    d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
                    r.g r11 = new r.g((com.obric.autogui.vdplayer.api.a.a) ZeusTransformUtils.preCheckCast(r6, com.obric.autogui.vdplayer.api.a.a.class, "com.obric.aiagent.plugin"));
                    r0.f25633b = 1;
                    if (r5.emit(r11, r0) != r2) goto L18;
                    return r2;
                L7:
                    r0 = new C06291(this, r8);
                    goto L8
                }
            }

            public c(kotlinx.coroutines.b.h r3) {
                this.f25630a = (kotlinx.coroutines.b.h) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
            }

            @Override // kotlinx.coroutines.b.h
            public Object collect(kotlinx.coroutines.b.i<? super r.g> r3, d.c.d r4) {
                kotlinx.coroutines.b.i r5 = (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
                d.c.d<? super x> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                Object r2 = this.f25630a.collect((kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin"), r6);
                if (r2 != d.c.a.b.a()) goto L6;
                return r2;
            L6:
                return x.f38692a;
            }
        }

        l(u r3, d.c.d<? super l> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25614b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((l) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), l.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new l(this.f25614b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25613a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            kotlinx.coroutines.b.h r8 = kotlinx.coroutines.b.j.b(kotlinx.coroutines.b.j.c(kotlinx.coroutines.b.j.c(u.d(this.f25614b).b(), (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f25614b, null), d.h.a.m.class, "com.obric.aiagent.plugin"))), (d.h.a.q) ZeusTransformUtils.preCheckCast(new a(null, this.f25614b), d.h.a.q.class, "com.obric.aiagent.plugin"));
            final u r3 = this.f25614b;
            kotlinx.coroutines.b.i r2 = (kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r3), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
            d.c.d<? super x> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25613a = 1;
            if (r8.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: VDPlayerViewModel.kt */
    @d.c.b.a.f(b = "VDPlayerViewModel.kt", c = {296}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.vm.VDPlayerViewModel$subscribeToSessionData$2")
    static final class m extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25635a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ u f25636b;

        /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.d.u$m$1, reason: invalid class name */
        /* JADX INFO: compiled from: VDPlayerViewModel.kt */
        static final class AnonymousClass1<T> implements kotlinx.coroutines.b.i {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ u f25637a;

            AnonymousClass1(u r1) {
                this.f25637a = r1;
            }

            public static /* synthetic */ s lambda$EEHuxEVUJ857QoY6nJSO4_H_pKA(boolean r0, s r1) {
                return a(r0, r1);
            }

            @Override // kotlinx.coroutines.b.i
            public /* synthetic */ Object emit(Object r3, d.c.d r4) {
                d.c.d<? super x> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue(), r5);
            }

            private static final s a(boolean r11, s r12) {
                d.h.b.o.e(r12, "$this$setState");
                return s.a(r12, null, com.obric.autoaction.vdplayer.d.k.a(r12.b(), null, null, null, null, null, r11, 31, null), null, null, false, null, null, 125, null);
            }

            public final Object a(final boolean r3, d.c.d<? super x> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                u.a(this.f25637a, new $$Lambda$u$m$1$EEHuxEVUJ857QoY6nJSO4_H_pKA(r3));
                if (r3 == false) goto L6;
                u.e(this.f25637a);
            L6:
                return x.f38692a;
            }
        }

        /* JADX INFO: compiled from: SafeCollector.common.kt */
        public static final class a implements kotlinx.coroutines.b.h<Boolean> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.b.h f25638a;

            /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.d.u$m$a$1, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            public static final class AnonymousClass1<T> implements kotlinx.coroutines.b.i {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ kotlinx.coroutines.b.i f25639a;

                /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.d.u$m$a$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @d.c.b.a.f(b = "VDPlayerViewModel.kt", c = {219}, d = "emit", e = "com.obric.autoaction.vdplayer.vm.VDPlayerViewModel$subscribeToSessionData$2$invokeSuspend$$inlined$map$1$2")
                public static final class C06301 extends d.c.b.a.d {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f25640a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f25641b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    final /* synthetic */ AnonymousClass1 f25642c;

                    public C06301(AnonymousClass1 r3, d.c.d r4) {
                        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                        this.f25642c = r3;
                        super(r5);
                    }

                    @Override // d.c.b.a.a
                    public final Object invokeSuspend(Object r3) {
                        this.f25640a = r3;
                        this.f25641b |= Integer.MIN_VALUE;
                        return this.f25642c.emit(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
                    }
                }

                public AnonymousClass1(kotlinx.coroutines.b.i r3) {
                    this.f25639a = (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
                }

                @Override // kotlinx.coroutines.b.i
                public final Object emit(Object r6, d.c.d r7) {
                    d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                    if (ZeusTransformUtils.instanceOf(r8, C06301.class) == false) goto L7;
                    C06301 r0 = (C06301) ZeusTransformUtils.preCheckCast(r8, C06301.class, "com.obric.aiagent.plugin");
                    if ((r0.f25641b & Integer.MIN_VALUE) == 0) goto L7;
                    r0.f25641b -= Integer.MIN_VALUE;
                L8:
                    Object r9 = r0.f25640a;
                    Object r2 = d.c.a.b.a();
                    int r3 = r0.f25641b;
                    if (r3 == 0) goto L14;
                    if (r3 != 1) goto L13;
                    d.o.a(r9);
                L18:
                    return x.f38692a;
                L13:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L14:
                    d.o.a(r9);
                    kotlinx.coroutines.b.i r5 = this.f25639a;
                    d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
                    Boolean r11 = d.c.b.a.b.a(((GlobalUIContext) ZeusTransformUtils.preCheckCast(r6, GlobalUIContext.class, "com.obric.aiagent.plugin")).getAssistState().getVisible());
                    r0.f25641b = 1;
                    if (r5.emit(r11, r0) != r2) goto L18;
                    return r2;
                L7:
                    r0 = new C06301(this, r8);
                    goto L8
                }
            }

            public a(kotlinx.coroutines.b.h r3) {
                this.f25638a = (kotlinx.coroutines.b.h) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
            }

            @Override // kotlinx.coroutines.b.h
            public Object collect(kotlinx.coroutines.b.i<? super Boolean> r3, d.c.d r4) {
                kotlinx.coroutines.b.i r5 = (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
                d.c.d<? super x> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                Object r2 = this.f25638a.collect((kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin"), r6);
                if (r2 != d.c.a.b.a()) goto L6;
                return r2;
            L6:
                return x.f38692a;
            }
        }

        m(u r3, d.c.d<? super m> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25636b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((m) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), m.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new m(this.f25636b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25635a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            kotlinx.coroutines.b.h r7 = kotlinx.coroutines.b.j.b((kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(new a((kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(AutoActionUIContext.INSTANCE.getState(), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin")), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin"));
            kotlinx.coroutines.b.i r2 = (kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f25636b), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
            d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25635a = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: VDPlayerViewModel.kt */
    @d.c.b.a.f(b = "VDPlayerViewModel.kt", c = {126}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.vm.VDPlayerViewModel$updateParams$1")
    static final class n extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25643a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f25644b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ u f25645c;

        n(boolean r3, u r4, d.c.d<? super n> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25644b = r3;
            this.f25645c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((n) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), n.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new n(this.f25644b, this.f25645c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25643a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L14:
            if (((s) ZeusTransformUtils.preCheckCast(this.f25645c.b().c(), s.class, "com.obric.aiagent.plugin")).g() == true) goto L19;
            if (((s) ZeusTransformUtils.preCheckCast(this.f25645c.b().c(), s.class, "com.obric.aiagent.plugin")).b().a().a() != com.obric.autoaction.vdplayer.d.l.f25511e) goto L19;
            this.f25645c.a((com.obric.autoaction.vdplayer.c.b) ZeusTransformUtils.preCheckCast(r.b.f25540a, com.obric.autoaction.vdplayer.c.b.class, "com.obric.aiagent.plugin"));
        L19:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            if (this.f25644b == false) goto L19;
            d.c.d r8 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25643a = 1;
            if (ax.a(1000, r8) != r0) goto L14;
            return r0;
        }
    }

    /* JADX INFO: compiled from: VDPlayerViewModel.kt */
    @d.c.b.a.f(b = "VDPlayerViewModel.kt", c = {135}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.vm.VDPlayerViewModel$updateParams$2")
    static final class o extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25646a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f25647b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ u f25648c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f25649d;

        o(boolean r3, u r4, String r5, d.c.d<? super o> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25647b = r3;
            this.f25648c = r4;
            this.f25649d = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((o) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), o.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new o(this.f25647b, this.f25648c, this.f25649d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25646a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L14:
            if (((s) ZeusTransformUtils.preCheckCast(this.f25648c.b().c(), s.class, "com.obric.aiagent.plugin")).b().a().a() != com.obric.autoaction.vdplayer.d.l.f) goto L25;
            IAgentSessionManager.a r8 = u.a(this.f25648c);
            if (r8 == null) goto L22;
            ak<com.obric.autogui.vdplayer.api.a.b> r9 = r8.b();
            if (r9 == null) goto L22;
            com.obric.autogui.vdplayer.api.a.b r10 = (com.obric.autogui.vdplayer.api.a.b) ZeusTransformUtils.preCheckCast(r9.c(), com.obric.autogui.vdplayer.api.a.b.class, "com.obric.aiagent.plugin");
            if (r10 == null) goto L22;
            IAutoActionAgentEventListener.SessionInfo r11 = r10.a();
        L23:
            u.b(this.f25648c).a("Clarify", this.f25649d, r11, u.c(this.f25648c));
        L22:
            r11 = null;
        L25:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            if (this.f25647b == false) goto L25;
            d.c.d r12 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25646a = 1;
            if (ax.a(1000, r12) != r0) goto L14;
            return r0;
        }
    }

    public u() {
        this(null, null, null, null, null, null, null, null, null, null, DownloadErrorCode.ERROR_IO, null);
    }

    /* JADX INFO: renamed from: lambda$-qi2Ht880Lo6XsZqlEkepAmdPxc, reason: not valid java name */
    public static /* synthetic */ s m681lambda$qi2Ht880Lo6XsZqlEkepAmdPxc(s r0) {
        return d(r0);
    }

    public static /* synthetic */ s lambda$3XNvKRY9qU18Khnvrngh1HKMTJI(long r0, s r2) {
        return a(r0, r2);
    }

    /* JADX INFO: renamed from: lambda$42pl6w-GsRiL8uohXrCOmjpQI3o, reason: not valid java name */
    public static /* synthetic */ s m682lambda$42pl6wGsRiL8uohXrCOmjpQI3o(s r0) {
        return c(r0);
    }

    public static /* synthetic */ x lambda$4dHdYSVpEU0a4_rrDEi3IYLqEVg(u r0, long r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ s lambda$5IMghmE_cTMoH5VvLGsIXlpZVMU(s r0) {
        return b(r0);
    }

    public static /* synthetic */ s lambda$7NPvoUhBSjQUiqFwmreGyeiGz0g(r r0, s r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ s lambda$7_trkEZ4n43G79Ln8zY0CltYRhk(s r0) {
        return e(r0);
    }

    /* JADX INFO: renamed from: lambda$AAb_D5BEzTV397WAg-tJv3od-wQ, reason: not valid java name */
    public static /* synthetic */ x m683lambda$AAb_D5BEzTV397WAgtJv3odwQ(u r0, long r1) {
        return b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$CEz7ewY3Gx686Cdfr-FTR4tetNI, reason: not valid java name */
    public static /* synthetic */ s m684lambda$CEz7ewY3Gx686CdfrFTR4tetNI(s r0) {
        return i(r0);
    }

    /* JADX INFO: renamed from: lambda$E-TAp7faGQ-3721_vuf7b7n3G9M, reason: not valid java name */
    public static /* synthetic */ s m685lambda$ETAp7faGQ3721_vuf7b7n3G9M(s r0) {
        return h(r0);
    }

    public static /* synthetic */ x lambda$HIofWnam67YcgOPOVdmOTOU2byY(u r0) {
        return j(r0);
    }

    /* JADX INFO: renamed from: lambda$LEHTK2mB6-sfWFaZIONqU4n5aus, reason: not valid java name */
    public static /* synthetic */ x m686lambda$LEHTK2mB6sfWFaZIONqU4n5aus(u r0, boolean r1) {
        return d(r0, r1);
    }

    public static /* synthetic */ s lambda$SardrGOGvUjzipmIdBOk7mKVm3E(com.obric.autogui.vdplayer.api.a.a r0, s r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ s lambda$XWjXJIIuzTOa2njejLbCkK6CAD8(s r0) {
        return g(r0);
    }

    public static /* synthetic */ s lambda$jhR6jVRyWGcBBF6IVJulZYc5qX8(com.obric.autoaction.vdplayer.d.d r0, s r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ s lambda$poaE9ULWFUPnvp4dhHJF4I4sCH8(s r0) {
        return f(r0);
    }

    public static /* synthetic */ s lambda$xHUf0GvMCoFSjjSSw7Ucr2jSGYg(long r0, s r2) {
        return b(r0, r2);
    }

    /* JADX INFO: renamed from: lambda$zQt-EDPMqQXv-OePsX289O1aVKc, reason: not valid java name */
    public static /* synthetic */ s m687lambda$zQtEDPMqQXvOePsX289O1aVKc(s r0) {
        return a(r0);
    }

    public static final /* synthetic */ com.obric.autoaction.vdplayer.d.d a(u r0, com.obric.autogui.vdplayer.api.a.b r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ IAgentSessionManager.a a(u r0) {
        return r0.n;
    }

    public static final /* synthetic */ Object a(u r2, d.c.d r3) {
        return r2.d((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(u r2, boolean r3, d.c.d r4) {
        return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(u r0, com.obric.autoaction.vdplayer.d.a.a r1) {
        r0.m = r1;
    }

    public static final /* synthetic */ void a(u r2, q r3) {
        r2.a((com.obric.autoaction.vdplayer.c.a) ZeusTransformUtils.preCheckCast(r3, com.obric.autoaction.vdplayer.c.a.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(u r2, IAgentSessionManager.a r3) {
        r2.n = (IAgentSessionManager.a) ZeusTransformUtils.wrapperContextForParams(r3, IAgentSessionManager.a.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ void a(u r2, d.h.a.b r3) {
        r2.a((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(u r0, boolean r1) {
        r0.c(r1);
    }

    public static final /* synthetic */ com.obric.autoaction.vdplayer.b.a.f b(u r0) {
        return r0.f25567c;
    }

    public static final /* synthetic */ void b(u r0, boolean r1) {
        r0.d(r1);
    }

    public static final /* synthetic */ String c(u r0) {
        return r0.p;
    }

    public static final /* synthetic */ void c(u r0, boolean r1) {
        r0.b(r1);
    }

    public static final /* synthetic */ com.obric.autoaction.vdplayer.b.b.a d(u r0) {
        return r0.i;
    }

    public static final /* synthetic */ void e(u r0) {
        r0.n();
    }

    public static final /* synthetic */ com.obric.autoaction.vdplayer.b.b.b f(u r0) {
        return r0.j;
    }

    public static final /* synthetic */ com.obric.autoaction.vdplayer.d.a.a g(u r0) {
        return r0.l;
    }

    public static final /* synthetic */ void h(u r0) {
        r0.s();
    }

    public static final /* synthetic */ com.obric.autoaction.vdplayer.d.a.a i(u r0) {
        return r0.m;
    }

    @Override // com.obric.autoaction.vdplayer.c.d
    public /* synthetic */ com.obric.autoaction.vdplayer.c.c a(com.obric.autoaction.vdplayer.c.c r3, com.obric.autoaction.vdplayer.c.c r4) {
        com.obric.autoaction.vdplayer.c.c r5 = (com.obric.autoaction.vdplayer.c.c) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autoaction.vdplayer.c.c.class, "com.obric.aiagent.plugin");
        com.obric.autoaction.vdplayer.c.c r6 = (com.obric.autoaction.vdplayer.c.c) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.autoaction.vdplayer.c.c.class, "com.obric.aiagent.plugin");
        return (com.obric.autoaction.vdplayer.c.c) ZeusTransformUtils.preCheckCast(a((s) ZeusTransformUtils.preCheckCast(r5, s.class, "com.obric.aiagent.plugin"), (s) ZeusTransformUtils.preCheckCast(r6, s.class, "com.obric.aiagent.plugin")), com.obric.autoaction.vdplayer.c.c.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.vdplayer.c.d
    public /* synthetic */ Object a(com.obric.autoaction.vdplayer.c.b r3, d.c.d r4) {
        com.obric.autoaction.vdplayer.c.b r5 = (com.obric.autoaction.vdplayer.c.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autoaction.vdplayer.c.b.class, "com.obric.aiagent.plugin");
        d.c.d<? super x> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        return a((r) ZeusTransformUtils.preCheckCast(r5, r.class, "com.obric.aiagent.plugin"), r6);
    }

    public /* synthetic */ u(com.obric.autoaction.vdplayer.b.a.g r11, com.obric.autoaction.vdplayer.b.a.f r12, com.obric.autoaction.vdplayer.b.a.b r13, com.obric.autoaction.vdplayer.b.a.a r14, com.obric.autoaction.vdplayer.b.a.c r15, com.obric.autoaction.vdplayer.b.a.d r16, com.obric.autoaction.vdplayer.b.a.h r17, com.obric.autoaction.vdplayer.b.b.a r18, com.obric.autoaction.vdplayer.b.b.b r19, com.obric.autoaction.vdplayer.b.a.e r20, int r21, d.h.b.h r22) {
        if ((r21 & 1) == 0) goto L5;
        com.obric.autoaction.vdplayer.b.a.g r1 = new com.obric.autoaction.vdplayer.b.a.g();
    L7:
        if ((r21 & 2) == 0) goto L9;
        com.obric.autoaction.vdplayer.b.a.f r2 = new com.obric.autoaction.vdplayer.b.a.f();
    L11:
        if ((r21 & 4) == 0) goto L13;
        com.obric.autoaction.vdplayer.b.a.b r3 = new com.obric.autoaction.vdplayer.b.a.b();
    L15:
        if ((r21 & 8) == 0) goto L17;
        com.obric.autoaction.vdplayer.b.a.a r4 = new com.obric.autoaction.vdplayer.b.a.a();
    L19:
        if ((r21 & 16) == 0) goto L21;
        com.obric.autoaction.vdplayer.b.a.c r5 = new com.obric.autoaction.vdplayer.b.a.c();
    L23:
        if ((r21 & 32) == 0) goto L25;
        com.obric.autoaction.vdplayer.b.a.d r6 = new com.obric.autoaction.vdplayer.b.a.d();
    L27:
        if ((r21 & 64) == 0) goto L29;
        com.obric.autoaction.vdplayer.b.a.h r7 = new com.obric.autoaction.vdplayer.b.a.h();
    L31:
        if ((r21 & 128) == 0) goto L33;
        com.obric.autoaction.vdplayer.b.b.a r8 = new com.obric.autoaction.vdplayer.b.b.a();
    L35:
        if ((r21 & 256) == 0) goto L37;
        com.obric.autoaction.vdplayer.b.b.b r9 = new com.obric.autoaction.vdplayer.b.b.b();
    L39:
        if ((r21 & 512) == 0) goto L41;
        com.obric.autoaction.vdplayer.b.a.e r0 = new com.obric.autoaction.vdplayer.b.a.e();
    L42:
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r0);
        return;
    L41:
        r0 = r20;
        goto L42
    L37:
        r9 = r19;
        goto L39
    L33:
        r8 = r18;
        goto L35
    L29:
        r7 = r17;
        goto L31
    L25:
        r6 = r16;
        goto L27
    L21:
        r5 = r15;
        goto L23
    L17:
        r4 = r14;
        goto L19
    L13:
        r3 = r13;
        goto L15
    L9:
        r2 = r12;
        goto L11
    L5:
        r1 = r11;
        goto L7
    }

    public u(com.obric.autoaction.vdplayer.b.a.g r24, com.obric.autoaction.vdplayer.b.a.f r25, com.obric.autoaction.vdplayer.b.a.b r26, com.obric.autoaction.vdplayer.b.a.a r27, com.obric.autoaction.vdplayer.b.a.c r28, com.obric.autoaction.vdplayer.b.a.d r29, com.obric.autoaction.vdplayer.b.a.h r30, com.obric.autoaction.vdplayer.b.b.a r31, com.obric.autoaction.vdplayer.b.b.b r32, com.obric.autoaction.vdplayer.b.a.e r33) {
        d.h.b.o.e(r24, "selectClarificationOptionUseCase");
        d.h.b.o.e(r25, "openAssistInputUseCase");
        d.h.b.o.e(r26, "enterManualOperateUseCase");
        d.h.b.o.e(r27, "enterCallUserUseCase");
        d.h.b.o.e(r28, "exitCallUserUseCase");
        d.h.b.o.e(r29, "exitManualOPUseCase");
        d.h.b.o.e(r30, "stopTaskUseCase");
        d.h.b.o.e(r31, "activeSessionInfoUseCase");
        d.h.b.o.e(r32, "secureLayerUseCase");
        d.h.b.o.e(r33, "getSnapshotUseCase");
        d.m<String, s> r11 = r;
        if (r11 == null) goto L21;
        String r13 = r11.a();
        IAgentSessionManager.a r14 = r31.a();
        if (r14 == null) goto L13;
        ak<com.obric.autogui.vdplayer.api.a.b> r15 = r14.b();
        if (r15 == null) goto L13;
        com.obric.autogui.vdplayer.api.a.b r16 = (com.obric.autogui.vdplayer.api.a.b) ZeusTransformUtils.preCheckCast(r15.c(), com.obric.autogui.vdplayer.api.a.b.class, "com.obric.aiagent.plugin");
        if (r16 == null) goto L13;
        IAutoActionAgentEventListener.SessionInfo r17 = r16.a();
        if (r17 == null) goto L13;
        String r18 = r17.getSessionKey();
    L15:
        if (d.h.b.o.a(r13, r18) == true) goto L18;
        r11 = null;
    L18:
        if (r11 == null) goto L21;
        s r12 = (s) ZeusTransformUtils.preCheckCast(r11.b(), s.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L21;
    L22:
        super((com.obric.autoaction.vdplayer.c.c) ZeusTransformUtils.preCheckCast(r12, com.obric.autoaction.vdplayer.c.c.class, "com.obric.aiagent.plugin"));
        this.f25566b = r24;
        this.f25567c = r25;
        this.f25568d = r26;
        this.f25569e = r27;
        this.f = r28;
        this.g = r29;
        this.h = r30;
        this.i = r31;
        this.j = r32;
        this.k = r33;
        return;
    L13:
        r18 = null;
    L21:
        r12 = new s(null, null, null, null, false, null, null, 127, null);
        goto L22
    }

    static {
        f25565a = new a(null);
        q = AutoActionConfigs.INSTANCE.getIntCfg("vlm.common.vd_player_manual_op_countdown_millis_ms", 15000);
    }

    public final void a(String r3, boolean r4) {
        this.p = r3;
        if (r4 == false) goto L9;
        if (this.i.a() != null) goto L9;
        Loog.INSTANCE.i(TAG, "No active session found; keep VDPlayerActivity for debug bridge.");
        k();
        return;
    L9:
        if (m() == false) goto L11;
        Loog.INSTANCE.i(TAG, "init " + hashCode());
        g();
        h();
        i();
        j();
        k();
        return;
    L11:
        Loog.INSTANCE.i(TAG, "No active session found; exit;");
    }

    public final void a(boolean r10, boolean r11, String r12) {
        d.h.b.o.e(r12, "sourceFrom");
        kotlinx.coroutines.i.a(androidx.lifecycle.ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new n(r10, this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        kotlinx.coroutines.i.a(androidx.lifecycle.ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new o(r11, this, r12, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void a(boolean r1) {
        this.o = r1;
    }

    public Object a(final r r9, d.c.d<? super x> r10) {
        d.c.d<? super x> r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (com.obric.autogui.common.b.b.f29001a.a() == false) goto L5;
        Loog.INSTANCE.i(TAG, "handleIntent " + r9);
    L7:
        if (ZeusTransformUtils.instanceOf(r9, r.g.class) == false) goto L10;
        a(((r.g) ZeusTransformUtils.preCheckCast(r9, r.g.class, "com.obric.aiagent.plugin")).a());
    L147:
        return x.f38692a;
    L10:
        if (ZeusTransformUtils.instanceOf(r9, r.h.class) == false) goto L13;
        a(((r.h) ZeusTransformUtils.preCheckCast(r9, r.h.class, "com.obric.aiagent.plugin")).getContext());
        goto L147
    L13:
        if (ZeusTransformUtils.instanceOf(r9, r.i.class) == false) goto L15;
        a(new $$Lambda$u$7NPvoUhBSjQUiqFwmreGyeiGz0g(r9));
        goto L147
    L15:
        IAutoActionAgentEventListener.SessionInfo r2 = null;
        if (ZeusTransformUtils.instanceOf(r9, r.p.class) == false) goto L30;
        com.obric.autoaction.vdplayer.b.a.h r12 = this.h;
        IAgentSessionManager.a r8 = this.n;
        if (r8 == null) goto L24;
        ak<com.obric.autogui.vdplayer.api.a.b> r13 = r8.b();
        if (r13 == null) goto L24;
        com.obric.autogui.vdplayer.api.a.b r14 = (com.obric.autogui.vdplayer.api.a.b) ZeusTransformUtils.preCheckCast(r13.c(), com.obric.autogui.vdplayer.api.a.b.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L24;
        r2 = r14.a();
    L24:
        Object r15 = r12.a(r2, r11);
        if (r15 != d.c.a.b.a()) goto L28;
        return r15;
    L28:
        return x.f38692a;
    L30:
        if (ZeusTransformUtils.instanceOf(r9, r.q.class) == false) goto L37;
        Object r16 = a(r11);
        if (r16 != d.c.a.b.a()) goto L35;
        return r16;
    L35:
        return x.f38692a;
    L37:
        if (ZeusTransformUtils.instanceOf(r9, r.j.class) == false) goto L53;
        if (r() == true) goto L41;
    L44:
        com.obric.autoaction.vdplayer.b.a.f r17 = this.f25567c;
        String r0 = ((r.j) ZeusTransformUtils.preCheckCast(r9, r.j.class, "com.obric.aiagent.plugin")).getType();
        String r18 = ((r.j) ZeusTransformUtils.preCheckCast(r9, r.j.class, "com.obric.aiagent.plugin")).a();
        IAgentSessionManager.a r3 = this.n;
        if (r3 == null) goto L51;
        ak<com.obric.autogui.vdplayer.api.a.b> r4 = r3.b();
        if (r4 == null) goto L51;
        com.obric.autogui.vdplayer.api.a.b r1 = (com.obric.autogui.vdplayer.api.a.b) ZeusTransformUtils.preCheckCast(r4.c(), com.obric.autogui.vdplayer.api.a.b.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L51;
        r2 = r1.a();
    L51:
        r17.a(r0, r18, r2, this.p);
        goto L147
    L41:
        if (d.h.b.o.a(((r.j) ZeusTransformUtils.preCheckCast(r9, r.j.class, "com.obric.aiagent.plugin")).getType(), "Supplement") == false) goto L44;
        a((com.obric.autoaction.vdplayer.c.a) ZeusTransformUtils.preCheckCast(new q.l(d.c.b.a.b.a(ZeusTransformUtils.mapRes(R.string.vd_player_doubao_interaction_disabled, WsChannelMultiProcessSharedProvider.STRING_TYPE, "vd_player_doubao_interaction_disabled")), null, 2, null), com.obric.autoaction.vdplayer.c.a.class, "com.obric.aiagent.plugin"));
        return x.f38692a;
    L53:
        if (ZeusTransformUtils.instanceOf(r9, r.b.class) == false) goto L60;
        Object r19 = d(r11);
        if (r19 != d.c.a.b.a()) goto L58;
        return r19;
    L58:
        return x.f38692a;
    L60:
        if (ZeusTransformUtils.instanceOf(r9, r.d.class) == false) goto L65;
        com.obric.autoaction.vdplayer.d.a.a r20 = this.l;
        if (r20 == null) goto L147;
        r20.b();
        goto L147
    L65:
        if (ZeusTransformUtils.instanceOf(r9, r.a.class) == false) goto L72;
        Object r21 = c(r11);
        if (r21 != d.c.a.b.a()) goto L70;
        return r21;
    L70:
        return x.f38692a;
    L72:
        if (ZeusTransformUtils.instanceOf(r9, r.l.class) == false) goto L77;
        com.obric.autoaction.vdplayer.d.a.a r22 = this.l;
        if (r22 == null) goto L147;
        r22.a();
        goto L147
    L77:
        if (ZeusTransformUtils.instanceOf(r9, r.C0625r.class) == false) goto L79;
        l();
        goto L147
    L79:
        boolean r5 = true;
        if (ZeusTransformUtils.instanceOf(r9, r.k.class) == false) goto L113;
        if (q() == false) goto L86;
        return x.f38692a;
    L86:
        if (d.h.b.o.a(((s) ZeusTransformUtils.preCheckCast(b().c(), s.class, "com.obric.aiagent.plugin")).a(), com.obric.autoaction.vdplayer.d.n.a.f25517a) == false) goto L92;
        if (AutoActionConfigs.INSTANCE.getBooleanCfg("vlm.common.enable_operate_panel_outside_click_dismiss", true) == false) goto L92;
        a((com.obric.autoaction.vdplayer.c.b) ZeusTransformUtils.preCheckCast(new r.f(true), com.obric.autoaction.vdplayer.c.b.class, "com.obric.aiagent.plugin"));
        return x.f38692a;
    L92:
        if (this.f25568d.b() == false) goto L95;
        a((com.obric.autoaction.vdplayer.c.a) ZeusTransformUtils.preCheckCast(q.k.f25536a, com.obric.autoaction.vdplayer.c.a.class, "com.obric.aiagent.plugin"));
        goto L147
    L95:
        if (((s) ZeusTransformUtils.preCheckCast(b().c(), s.class, "com.obric.aiagent.plugin")).c().c() == null) goto L97;
        boolean r23 = true;
    L98:
        boolean r6 = d.h.b.o.a(((s) ZeusTransformUtils.preCheckCast(b().c(), s.class, "com.obric.aiagent.plugin")).a(), com.obric.autoaction.vdplayer.d.n.a.f25517a);
        if (((s) ZeusTransformUtils.preCheckCast(b().c(), s.class, "com.obric.aiagent.plugin")).b().a().a() == com.obric.autoaction.vdplayer.d.l.g) goto L102;
        r5 = false;
    L102:
        if (r23 == false) goto L111;
        if (r6 == true) goto L111;
        if (r5 == true) goto L111;
        if (this.f25568d.c() == false) goto L109;
        a((com.obric.autoaction.vdplayer.c.a) ZeusTransformUtils.preCheckCast(q.k.f25536a, com.obric.autoaction.vdplayer.c.a.class, "com.obric.aiagent.plugin"));
        goto L147
    L109:
        a((com.obric.autoaction.vdplayer.c.a) ZeusTransformUtils.preCheckCast(new q.l(d.c.b.a.b.a(ZeusTransformUtils.mapRes(R.string.obric_vd_player_cant_handle_take_over, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_vd_player_cant_handle_take_over")), null, 2, null), com.obric.autoaction.vdplayer.c.a.class, "com.obric.aiagent.plugin"));
    L111:
        return x.f38692a;
    L97:
        r23 = false;
        goto L98
    L113:
        if (ZeusTransformUtils.instanceOf(r9, r.m.class) == false) goto L127;
        com.obric.autoaction.vdplayer.b.a.g r7 = this.f25566b;
        String r24 = ((r.m) ZeusTransformUtils.preCheckCast(r9, r.m.class, "com.obric.aiagent.plugin")).a();
        IAgentSessionManager.a r25 = this.n;
        if (r25 == null) goto L121;
        ak<com.obric.autogui.vdplayer.api.a.b> r26 = r25.b();
        if (r26 == null) goto L121;
        com.obric.autogui.vdplayer.api.a.b r27 = (com.obric.autogui.vdplayer.api.a.b) ZeusTransformUtils.preCheckCast(r26.c(), com.obric.autogui.vdplayer.api.a.b.class, "com.obric.aiagent.plugin");
        if (r27 == null) goto L121;
        r2 = r27.a();
    L121:
        Object r28 = r7.a(r24, r2, !r(), r11);
        if (r28 != d.c.a.b.a()) goto L125;
        return r28;
    L125:
        return x.f38692a;
    L127:
        if (ZeusTransformUtils.instanceOf(r9, r.c.class) == false) goto L134;
        Object r29 = b(r11);
        if (r29 != d.c.a.b.a()) goto L132;
        return r29;
    L132:
        return x.f38692a;
    L134:
        if (ZeusTransformUtils.instanceOf(r9, r.f.class) == false) goto L137;
        b(((r.f) ZeusTransformUtils.preCheckCast(r9, r.f.class, "com.obric.aiagent.plugin")).a());
        goto L147
    L137:
        if (d.h.b.o.a(r9, r.e.f25543a) == false) goto L140;
        p();
        goto L147
    L140:
        if (d.h.b.o.a(r9, r.n.f25553a) == true) goto L147;
        if (d.h.b.o.a(r9, r.o.f25554a) == false) goto L145;
        a((com.obric.autoaction.vdplayer.c.a) ZeusTransformUtils.preCheckCast(q.j.f25535a, com.obric.autoaction.vdplayer.c.a.class, "com.obric.aiagent.plugin"));
        goto L147
    L145:
        throw new d.k();
    L5:
        Loog.INSTANCE.i(TAG, "handleIntent " + r9.getClass().getSimpleName());
        goto L7
    }

    private static final s a(r r10, s r11) {
        d.h.b.o.e(r11, "$this$setState");
        return s.a(r11, null, null, null, null, ((r.i) ZeusTransformUtils.preCheckCast(r10, r.i.class, "com.obric.aiagent.plugin")).a(), null, null, 111, null);
    }

    private final Object a(d.c.d<? super x> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        IAutoActionAgentEventListener.SessionInfo r0 = null;
        if (r() == false) goto L6;
        a((com.obric.autoaction.vdplayer.c.a) ZeusTransformUtils.preCheckCast(new q.l(d.c.b.a.b.a(ZeusTransformUtils.mapRes(R.string.vd_player_doubao_interaction_disabled, WsChannelMultiProcessSharedProvider.STRING_TYPE, "vd_player_doubao_interaction_disabled")), null, 2, null), com.obric.autoaction.vdplayer.c.a.class, "com.obric.aiagent.plugin"));
        return x.f38692a;
    L6:
        com.obric.autoaction.vdplayer.b.a.f r10 = this.f25567c;
        IAgentSessionManager.a r4 = this.n;
        if (r4 == null) goto L13;
        ak<com.obric.autogui.vdplayer.api.a.b> r5 = r4.b();
        if (r5 == null) goto L13;
        com.obric.autogui.vdplayer.api.a.b r1 = (com.obric.autogui.vdplayer.api.a.b) ZeusTransformUtils.preCheckCast(r5.c(), com.obric.autogui.vdplayer.api.a.b.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L13;
        r0 = r1.a();
    L13:
        com.obric.autoaction.vdplayer.b.a.f.a(r10, null, null, r0, this.p, 3, null);
        return x.f38692a;
    }

    private final void g() {
        kotlinx.coroutines.i.a(androidx.lifecycle.ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new l(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        kotlinx.coroutines.i.a(androidx.lifecycle.ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new m(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void h() {
        kotlinx.coroutines.i.a(androidx.lifecycle.ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new j(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void i() {
        kotlinx.coroutines.i.a(androidx.lifecycle.ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new k(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void j() {
        kotlinx.coroutines.i.a(androidx.lifecycle.ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new i(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void k() {
        kotlinx.coroutines.i.a(androidx.lifecycle.ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new h(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void l() {
        boolean r0 = ((s) ZeusTransformUtils.preCheckCast(b().c(), s.class, "com.obric.aiagent.plugin")).g();
        com.obric.autoaction.vdplayer.d.j r1 = ((s) ZeusTransformUtils.preCheckCast(b().c(), s.class, "com.obric.aiagent.plugin")).b().c();
        if (r0 == false) goto L5;
        a((com.obric.autoaction.vdplayer.c.b) ZeusTransformUtils.preCheckCast(r.d.f25542a, com.obric.autoaction.vdplayer.c.b.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        int r2 = b.f25570a[r1.ordinal()];
        if (r2 != 1) goto L8;
        a($$Lambda$u$zQtEDPMqQXvOePsX289O1aVKc.INSTANCE);
        return;
    L8:
        if (r2 != 2) goto L10;
        a($$Lambda$u$5IMghmE_cTMoH5VvLGsIXlpZVMU.INSTANCE);
        return;
    L10:
        if (r2 != 3) goto L15;
        if (d.h.b.o.a(((s) ZeusTransformUtils.preCheckCast(b().c(), s.class, "com.obric.aiagent.plugin")).a(), com.obric.autoaction.vdplayer.d.n.a.f25517a) == true) goto L20;
        a((com.obric.autoaction.vdplayer.c.a) ZeusTransformUtils.preCheckCast(q.i.f25534a, com.obric.autoaction.vdplayer.c.a.class, "com.obric.aiagent.plugin"));
        return;
    L20:
        return;
    L15:
        throw new d.k();
    }

    private static final s a(s r11) {
        d.h.b.o.e(r11, "$this$setState");
        return s.a(r11, null, com.obric.autoaction.vdplayer.d.k.a(r11.b(), null, null, com.obric.autoaction.vdplayer.d.j.f25498b, null, null, false, 59, null), null, null, false, null, null, 125, null);
    }

    private static final s b(s r11) {
        d.h.b.o.e(r11, "$this$setState");
        return s.a(r11, null, com.obric.autoaction.vdplayer.d.k.a(r11.b(), null, null, com.obric.autoaction.vdplayer.d.j.f25497a, null, null, false, 59, null), null, null, false, null, null, 125, null);
    }

    private final boolean m() {
        IAgentSessionManager.a r0 = this.i.a();
        if (r0 != null) goto L6;
        a((com.obric.autoaction.vdplayer.c.a) ZeusTransformUtils.preCheckCast(new q.l(Integer.valueOf(ZeusTransformUtils.mapRes(R.string.obric_vd_no_task, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_vd_no_task")), null, 2, null), com.obric.autoaction.vdplayer.c.a.class, "com.obric.aiagent.plugin"));
        a((com.obric.autoaction.vdplayer.c.a) ZeusTransformUtils.preCheckCast(q.a.f25526a, com.obric.autoaction.vdplayer.c.a.class, "com.obric.aiagent.plugin"));
        return false;
    L6:
        this.n = r0;
        return true;
    }

    private final void a(final com.obric.autogui.vdplayer.api.a.a r3) {
        a(new $$Lambda$u$SardrGOGvUjzipmIdBOk7mKVm3E(r3));
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autogui.vdplayer.api.a.a.c.class) == false) goto L6;
        n();
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autogui.vdplayer.api.a.a.C0870a.class) == false) goto L9;
        n();
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autogui.vdplayer.api.a.a.b.class) == false) goto L12;
        n();
        return;
    L12:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autogui.vdplayer.api.a.a.d.class) == false) goto L15;
        a((com.obric.autogui.vdplayer.api.a.a.d) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.vdplayer.api.a.a.d.class, "com.obric.aiagent.plugin"));
        n();
        return;
    L15:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autogui.vdplayer.api.a.a.f.class) == false) goto L20;
        com.obric.autoaction.vdplayer.d.a.a r2 = this.l;
        if (r2 == null) goto L29;
        Loog.INSTANCE.i(TAG, "there is a existing count down timer");
        r2.b();
        return;
    L29:
        return;
    L20:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autogui.vdplayer.api.a.a.e.class) == false) goto L24;
        n();
        return;
    L24:
        throw new d.k();
    }

    private static final s a(com.obric.autogui.vdplayer.api.a.a r1, s r2) {
        d.h.b.o.e(r2, "$this$setState");
        return p.f25524a.a(r2, r1);
    }

    private final void n() {
        a((com.obric.autoaction.vdplayer.c.a) ZeusTransformUtils.preCheckCast(q.c.f25528a, com.obric.autoaction.vdplayer.c.a.class, "com.obric.aiagent.plugin"));
        a((com.obric.autoaction.vdplayer.c.a) ZeusTransformUtils.preCheckCast(q.d.f25529a, com.obric.autoaction.vdplayer.c.a.class, "com.obric.aiagent.plugin"));
    }

    private final com.obric.autoaction.vdplayer.d.d a(com.obric.autogui.vdplayer.api.a.b r1) {
        return new com.obric.autoaction.vdplayer.d.d(r1.c());
    }

    private final void a(final com.obric.autoaction.vdplayer.d.d r2) {
        a(new $$Lambda$u$jhR6jVRyWGcBBF6IVJulZYc5qX8(r2));
    }

    private static final s a(com.obric.autoaction.vdplayer.d.d r12, s r13) {
        d.h.b.o.e(r13, "$this$setState");
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r12.a(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r14, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r15 = r14.iterator();
    L4:
        if (r15.hasNext() == false) goto L6;
        IAutoActionAgentEventListener.OperatingAppInfo r2 = (IAutoActionAgentEventListener.OperatingAppInfo) ZeusTransformUtils.preCheckCast(r15.next(), IAutoActionAgentEventListener.OperatingAppInfo.class, "com.obric.aiagent.plugin");
        r0.add(new com.obric.autoaction.vdplayer.d.h(false, r2.getAppLabel().toString(), r2.getPackageName(), 1, null));
        goto L4
    L6:
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        List r6 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Iterator r17 = r16.iterator();
    L8:
        if (r17.hasNext() == false) goto L12;
        com.obric.autoaction.vdplayer.d.h r1 = (com.obric.autoaction.vdplayer.d.h) ZeusTransformUtils.preCheckCast(r17.next(), com.obric.autoaction.vdplayer.d.h.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(d.a.p.n(r6), r1) == true) goto L8;
        r6.add(r1);
        goto L8
    L12:
        com.obric.autoaction.vdplayer.d.h r18 = (com.obric.autoaction.vdplayer.d.h) ZeusTransformUtils.preCheckCast(d.a.p.n(r6), com.obric.autoaction.vdplayer.d.h.class, "com.obric.aiagent.plugin");
        if (r18 == null) goto L16;
        com.obric.autoaction.vdplayer.d.h r19 = com.obric.autoaction.vdplayer.d.h.a(r13.c(), false, r18.b(), r18.c(), 1, null);
        if (r19 == null) goto L16;
    L18:
        return s.a(r13, null, null, r19, r6, false, null, null, 115, null);
    L16:
        r19 = r13.c();
        goto L18
    }

    private final void b(boolean r3) {
        if (r3 == false) goto L15;
        IAgentSessionManager.a r4 = this.n;
        if (r4 == null) goto L13;
        ak<com.obric.autogui.vdplayer.api.a.b> r5 = r4.b();
        if (r5 == null) goto L13;
        com.obric.autogui.vdplayer.api.a.b r6 = (com.obric.autogui.vdplayer.api.a.b) ZeusTransformUtils.preCheckCast(r5.c(), com.obric.autogui.vdplayer.api.a.b.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L13;
        List<IAutoActionAgentEventListener.OperatingAppInfo> r7 = r6.c();
        if (r7 == null) goto L13;
        IAutoActionAgentEventListener.OperatingAppInfo r8 = (IAutoActionAgentEventListener.OperatingAppInfo) ZeusTransformUtils.preCheckCast(d.a.p.n(r7), IAutoActionAgentEventListener.OperatingAppInfo.class, "com.obric.aiagent.plugin");
    L14:
        a((com.obric.autoaction.vdplayer.c.a) ZeusTransformUtils.preCheckCast(new q.b(r8), com.obric.autoaction.vdplayer.c.a.class, "com.obric.aiagent.plugin"));
        return;
    L13:
        r8 = null;
        goto L14
    L15:
        a((com.obric.autoaction.vdplayer.c.a) ZeusTransformUtils.preCheckCast(q.a.f25526a, com.obric.autoaction.vdplayer.c.a.class, "com.obric.aiagent.plugin"));
    }

    private final IFeedbackApi.a o() {
        IAgentSessionManager.a r0 = this.n;
        String r2 = null;
        if (r0 == null) goto L9;
        ak<com.obric.autogui.vdplayer.api.a.b> r1 = r0.b();
        if (r1 == null) goto L9;
        com.obric.autogui.vdplayer.api.a.b r3 = (com.obric.autogui.vdplayer.api.a.b) ZeusTransformUtils.preCheckCast(r1.c(), com.obric.autogui.vdplayer.api.a.b.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L9;
        IAutoActionAgentEventListener.SessionInfo r4 = r3.a();
    L10:
        if (r4 == null) goto L12;
        String r5 = r4.getSessionId();
    L13:
        String r6 = String.valueOf(r5);
        if (r4 == null) goto L19;
        String r7 = r4.getSessionKey();
        if (r7 == null) goto L19;
        String r8 = r7;
    L20:
        if (r4 == null) goto L26;
        d.f<File> r9 = r4.getJournalPath();
        if (r9 == null) goto L26;
        File r10 = (File) ZeusTransformUtils.preCheckCast(r9.b(), File.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L26;
        String r11 = r10.getAbsolutePath();
    L27:
        String r12 = String.valueOf(r11);
        IAgentSessionManager.a r13 = this.n;
        if (r13 == null) goto L34;
        ak<com.obric.autogui.vdplayer.api.a.b> r14 = r13.b();
        if (r14 == null) goto L34;
        com.obric.autogui.vdplayer.api.a.b r15 = (com.obric.autogui.vdplayer.api.a.b) ZeusTransformUtils.preCheckCast(r14.c(), com.obric.autogui.vdplayer.api.a.b.class, "com.obric.aiagent.plugin");
        if (r15 == null) goto L34;
        BizStatus.StatusChangedReasonStruct r16 = r15.b();
    L35:
        if (r4 == null) goto L41;
        AutoOperateTask r17 = r4.getTask();
        if (r17 == null) goto L41;
        Map<String, Object> r18 = r17.getInternalExtras();
        if (r18 == null) goto L41;
        Object r19 = r18.get(AutoOperateTask.KEY_EXTRA_EVALUATED_TASK);
    L43:
        if (ZeusTransformUtils.instanceOf(r19, String.class) == false) goto L45;
        String r20 = (String) ZeusTransformUtils.preCheckCast(r19, String.class, "com.obric.aiagent.plugin");
    L46:
        if (r4 == null) goto L50;
        AutoOperateTask r21 = r4.getTask();
        if (r21 == null) goto L50;
        r2 = r21.getUserTask();
    L50:
        if (r20 != null) goto L54;
        if (r2 != null) goto L53;
        String r22 = "";
    L55:
        Loog.INSTANCE.i(TAG, "getFeedbackParams sessionId " + r6 + ", sessionKey " + r8 + ", journalPath " + r12);
        if (r16 == null) goto L58;
        int r110 = r16.getReason();
    L60:
        return new IFeedbackApi.a(r4, r6, r8, r12, r110, r22);
    L58:
        r110 = 0;
        goto L60
    L53:
        r22 = r2;
        goto L55
    L54:
        r22 = r20;
        goto L55
    L45:
        r20 = null;
    L41:
        r19 = null;
    L34:
        r16 = null;
    L26:
        r11 = null;
    L19:
        r8 = "";
        goto L20
    L12:
        r5 = null;
    L9:
        r4 = null;
        goto L10
    }

    private final void p() {
        if (r() == false) goto L6;
        a((com.obric.autoaction.vdplayer.c.a) ZeusTransformUtils.preCheckCast(new q.l(Integer.valueOf(ZeusTransformUtils.mapRes(R.string.vd_player_doubao_interaction_disabled, WsChannelMultiProcessSharedProvider.STRING_TYPE, "vd_player_doubao_interaction_disabled")), null, 2, null), com.obric.autoaction.vdplayer.c.a.class, "com.obric.aiagent.plugin"));
        return;
    L6:
        IFeedbackApi.a r0 = o();
        if (r0 == null) goto L10;
        a((com.obric.autoaction.vdplayer.c.a) ZeusTransformUtils.preCheckCast(new q.e(r0), com.obric.autoaction.vdplayer.c.a.class, "com.obric.aiagent.plugin"));
        return;
    }

    private final Object b(d.c.d<? super x> r5) {
        d.c.d<? super x> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        a((com.obric.autoaction.vdplayer.c.a) ZeusTransformUtils.preCheckCast(q.d.f25529a, com.obric.autoaction.vdplayer.c.a.class, "com.obric.aiagent.plugin"));
        if (q() == false) goto L7;
        return x.f38692a;
    L7:
        if (this.f25568d.b() == false) goto L14;
        Object r4 = d(r6);
        if (r4 != d.c.a.b.a()) goto L12;
        return r4;
    L12:
        return x.f38692a;
    L14:
        if (this.f25568d.a() == true) goto L17;
        a((com.obric.autoaction.vdplayer.c.a) ZeusTransformUtils.preCheckCast(new q.l(d.c.b.a.b.a(ZeusTransformUtils.mapRes(R.string.obric_vd_player_cant_handle_take_over, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_vd_player_cant_handle_take_over")), null, 2, null), com.obric.autoaction.vdplayer.c.a.class, "com.obric.aiagent.plugin"));
    L17:
        return x.f38692a;
    }

    private final void c(boolean r5) {
        IAgentSessionManager.a r4 = this.n;
        String r0 = null;
        if (r4 == null) goto L9;
        ak<com.obric.autogui.vdplayer.api.a.b> r6 = r4.b();
        if (r6 == null) goto L9;
        com.obric.autogui.vdplayer.api.a.b r7 = (com.obric.autogui.vdplayer.api.a.b) ZeusTransformUtils.preCheckCast(r6.c(), com.obric.autogui.vdplayer.api.a.b.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L9;
        IAutoActionAgentEventListener.SessionInfo r8 = r7.a();
    L10:
        Loog r1 = Loog.INSTANCE;
        StringBuilder r2 = new StringBuilder().append("reportTakeOverEvent isModelCallUser=").append(r5).append(", sessionId=");
        if (r8 == null) goto L13;
        String r3 = r8.getSessionId();
    L14:
        StringBuilder r9 = r2.append(r3).append(", toolName=");
        if (r8 == null) goto L17;
        r0 = r8.getToolName();
    L17:
        r1.i(TAG, r9.append(r0).toString());
        com.obric.autoaction.vdplayer.tracking.b.f26072a.a(r8, r5);
        return;
    L13:
        r3 = null;
    L9:
        r8 = null;
        goto L10
    }

    private final Object c(d.c.d<? super x> r5) {
        d.c.d<? super x> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        s r0 = (s) ZeusTransformUtils.preCheckCast(b().c(), s.class, "com.obric.aiagent.plugin");
        if (r0.e() == com.obric.autoaction.vdplayer.d.o.f25519a) goto L9;
        com.obric.autoaction.vdplayer.d.a.a r4 = this.l;
        if (r4 == null) goto L8;
        r4.b();
    L8:
        return x.f38692a;
    L9:
        int r2 = b.f25571b[r0.b().a().a().ordinal()];
        if (r2 != 1) goto L12;
        Object r7 = d(r6);
        if (r7 != d.c.a.b.a()) goto L40;
        return r7;
    L40:
        return x.f38692a;
    L12:
        if (r2 == 2) goto L25;
        int r1 = b.f25570a[r0.b().c().ordinal()];
        if (r1 == 1) goto L24;
        if (r1 != 2) goto L17;
        a($$Lambda$u$qi2Ht880Lo6XsZqlEkepAmdPxc.INSTANCE);
    L35:
        return x.f38692a;
    L17:
        if (r1 != 3) goto L22;
        if (d.h.b.o.a(((s) ZeusTransformUtils.preCheckCast(b().c(), s.class, "com.obric.aiagent.plugin")).a(), com.obric.autoaction.vdplayer.d.n.a.f25517a) == true) goto L35;
        a((com.obric.autoaction.vdplayer.c.a) ZeusTransformUtils.preCheckCast(q.i.f25534a, com.obric.autoaction.vdplayer.c.a.class, "com.obric.aiagent.plugin"));
        goto L35
    L22:
        throw new d.k();
    L24:
        a($$Lambda$u$42pl6wGsRiL8uohXrCOmjpQI3o.INSTANCE);
        goto L35
    L25:
        com.obric.autoaction.vdplayer.b.a.f r8 = this.f25567c;
        IAgentSessionManager.a r3 = this.n;
        if (r3 == null) goto L32;
        ak<com.obric.autogui.vdplayer.api.a.b> r9 = r3.b();
        if (r9 == null) goto L32;
        com.obric.autogui.vdplayer.api.a.b r10 = (com.obric.autogui.vdplayer.api.a.b) ZeusTransformUtils.preCheckCast(r9.c(), com.obric.autogui.vdplayer.api.a.b.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L32;
        IAutoActionAgentEventListener.SessionInfo r11 = r10.a();
    L33:
        r8.a("Clarify", null, r11, this.p);
    L32:
        r11 = null;
        goto L33
    }

    private static final s c(s r11) {
        d.h.b.o.e(r11, "$this$setState");
        return s.a(r11, null, com.obric.autoaction.vdplayer.d.k.a(r11.b(), null, null, com.obric.autoaction.vdplayer.d.j.f25498b, null, null, false, 59, null), null, null, false, null, null, 125, null);
    }

    private static final s d(s r11) {
        d.h.b.o.e(r11, "$this$setState");
        return s.a(r11, null, com.obric.autoaction.vdplayer.d.k.a(r11.b(), null, null, com.obric.autoaction.vdplayer.d.j.f25497a, null, null, false, 59, null), null, null, false, null, null, 125, null);
    }

    private final Object d(d.c.d<? super x> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, d.class) == false) goto L7;
        d r0 = (d) ZeusTransformUtils.preCheckCast(r8, d.class, "com.obric.aiagent.plugin");
        if ((r0.f25581d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f25581d -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.f25579b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f25581d;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        u this = (u) ZeusTransformUtils.preCheckCast(r0.f25578a, u.class, "com.obric.aiagent.plugin");
        d.o.a(r9);
    L21:
        int r10 = b.f25572c[((com.obric.autoaction.vdplayer.b.a.a.EnumC0606a) ZeusTransformUtils.preCheckCast(r9, com.obric.autoaction.vdplayer.b.a.a.EnumC0606a.class, "com.obric.aiagent.plugin")).ordinal()];
        if (r10 != 1) goto L24;
        this.a($$Lambda$u$7_trkEZ4n43G79Ln8zY0CltYRhk.INSTANCE);
    L33:
        return x.f38692a;
    L24:
        if (r10 != 2) goto L26;
        this.a((com.obric.autoaction.vdplayer.c.a) ZeusTransformUtils.preCheckCast(new q.l(d.c.b.a.b.a(ZeusTransformUtils.mapRes(R.string.obric_vd_player_cant_handle_take_over, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_vd_player_cant_handle_take_over")), null, 2, null), com.obric.autoaction.vdplayer.c.a.class, "com.obric.aiagent.plugin"));
        Loog.INSTANCE.i(TAG, "ConfirmEnterCallUser failed");
        goto L33
    L26:
        if (r10 != 3) goto L29;
        Loog.INSTANCE.i(TAG, "ConfirmEnterCallUser failed before call user");
        goto L33
    L29:
        throw new d.k();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r9);
        if (q() == true) goto L17;
        com.obric.autoaction.vdplayer.b.a.a r11 = this.f25569e;
        r0.f25578a = this;
        r0.f25581d = 1;
        r9 = r11.a(r0);
        if (r9 != r2) goto L21;
        return r2;
    L17:
        return x.f38692a;
    L7:
        r0 = new d(this, r8);
        goto L8
    }

    private static final s e(s r11) {
        d.h.b.o.e(r11, "$this$setState");
        return s.a(r11, null, null, null, null, false, com.obric.autoaction.vdplayer.d.o.f25520b, null, 95, null);
    }

    private final boolean q() {
        if (r() == true) goto L6;
        return false;
    L6:
        a((com.obric.autoaction.vdplayer.c.a) ZeusTransformUtils.preCheckCast(new q.l(Integer.valueOf(ZeusTransformUtils.mapRes(R.string.vd_player_doubao_takeover_disabled, WsChannelMultiProcessSharedProvider.STRING_TYPE, "vd_player_doubao_takeover_disabled")), null, 2, null), com.obric.autoaction.vdplayer.c.a.class, "com.obric.aiagent.plugin"));
        return true;
    }

    private final boolean r() {
        if (this.o == false) goto L5;
        return true;
    L5:
        IAgentSessionManager.a r4 = this.n;
        if (r4 == null) goto L27;
        ak<com.obric.autogui.vdplayer.api.a.b> r5 = r4.b();
        if (r5 == null) goto L27;
        com.obric.autogui.vdplayer.api.a.b r6 = (com.obric.autogui.vdplayer.api.a.b) ZeusTransformUtils.preCheckCast(r5.c(), com.obric.autogui.vdplayer.api.a.b.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L27;
        IAutoActionAgentEventListener.SessionInfo r7 = r6.a();
        if (r7 == null) goto L27;
        AutoOperateTask r8 = r7.getTask();
        if (r8 == null) goto L27;
        Bundle r9 = r8.getTaskExtras();
        if (r9 == null) goto L27;
        if (d.h.b.o.a(r9.getString("caller_source"), "ai_proactive") == false) goto L26;
        if (r9.containsKey("allow_user_interaction") == false) goto L26;
        if (r9.getBoolean("allow_user_interaction") == true) goto L26;
        return true;
    L26:
        return false;
    L27:
        return false;
    }

    private final void d(final boolean r12) {
        if (this.l == null) goto L8;
        Loog.INSTANCE.e(TAG, "there is a existing count down timer");
        com.obric.autoaction.vdplayer.d.a.a r0 = this.l;
        if (r0 == null) goto L7;
        r0.b();
    L7:
        this.l = null;
    L8:
        Loog.INSTANCE.i(TAG, "launch count down timer");
        am r2 = androidx.lifecycle.ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin"));
        long r5 = q;
        com.obric.autoaction.vdplayer.d.a.a r1 = new com.obric.autoaction.vdplayer.d.a.a(r2, new $$Lambda$u$4dHdYSVpEU0a4_rrDEi3IYLqEVg(this), new $$Lambda$u$LEHTK2mB6sfWFaZIONqU4n5aus(this, r12), r5, 0, 16, null);
        this.l = r1;
        if (r1 == null) goto L12;
        r1.a();
        return;
    }

    private static final x a(u r1, final long r2) {
        r1.a(new $$Lambda$u$3XNvKRY9qU18Khnvrngh1HKMTJI(r2));
        return x.f38692a;
    }

    private static final s a(long r11, s r13) {
        d.h.b.o.e(r13, "$this$setState");
        return s.a(r13, null, com.obric.autoaction.vdplayer.d.k.a(r13.b(), null, null, null, Long.valueOf(r11), null, false, 55, null), null, null, false, null, null, 125, null);
    }

    private static final x d(u r9, boolean r10) {
        Loog.INSTANCE.i(TAG, "count down timer finish, exit user operating");
        r9.l = null;
        r9.a($$Lambda$u$poaE9ULWFUPnvp4dhHJF4I4sCH8.INSTANCE);
        kotlinx.coroutines.i.a(androidx.lifecycle.ak.a((aj) ZeusTransformUtils.preCheckCast(r9, aj.class, "com.obric.aiagent.plugin")), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new g(r9, r10, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return x.f38692a;
    }

    private static final s f(s r11) {
        d.h.b.o.e(r11, "$this$setState");
        return s.a(r11, null, com.obric.autoaction.vdplayer.d.k.a(r11.b(), null, null, null, null, null, false, 55, null), null, null, false, null, null, 125, null);
    }

    private final void s() {
        if (this.m == null) goto L9;
        Loog.INSTANCE.e(TAG, "there is a existing auto exit count down timer");
        com.obric.autoaction.vdplayer.d.a.a r0 = this.m;
        if (r0 == null) goto L7;
        r0.b();
    L7:
        this.m = null;
    L9:
        if (com.obric.autogui.common.a.d.f28974a.K() > 0) goto L12;
        Loog.INSTANCE.i(TAG, "auto exit count down millis is 0, skip");
        a($$Lambda$u$XWjXJIIuzTOa2njejLbCkK6CAD8.INSTANCE);
        return;
    L12:
        Loog.INSTANCE.i(TAG, "launch auto exit count down timer");
        com.obric.autoaction.vdplayer.d.a.a r1 = new com.obric.autoaction.vdplayer.d.a.a(androidx.lifecycle.ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")), new $$Lambda$u$AAb_D5BEzTV397WAgtJv3odwQ(this), new $$Lambda$u$HIofWnam67YcgOPOVdmOTOU2byY(this), com.obric.autogui.common.a.d.f28974a.K(), 0, 16, null);
        this.m = r1;
        if (r1 == null) goto L16;
        r1.a();
        return;
    }

    private static final s g(s r11) {
        d.h.b.o.e(r11, "$this$setState");
        return s.a(r11, null, com.obric.autoaction.vdplayer.d.k.a(r11.b(), null, null, null, null, -1L, false, 47, null), null, null, false, null, null, 125, null);
    }

    private static final x b(u r1, final long r2) {
        r1.a(new $$Lambda$u$xHUf0GvMCoFSjjSSw7Ucr2jSGYg(r2));
        return x.f38692a;
    }

    private static final s b(long r11, s r13) {
        d.h.b.o.e(r13, "$this$setState");
        return s.a(r13, null, com.obric.autoaction.vdplayer.d.k.a(r13.b(), null, null, null, null, Long.valueOf(r11), false, 47, null), null, null, false, null, null, 125, null);
    }

    private static final x j(u r9) {
        Loog.INSTANCE.i(TAG, "count down timer finish, exit user operating");
        r9.m = null;
        r9.a($$Lambda$u$ETAp7faGQ3721_vuf7b7n3G9M.INSTANCE);
        kotlinx.coroutines.i.a(androidx.lifecycle.ak.a((aj) ZeusTransformUtils.preCheckCast(r9, aj.class, "com.obric.aiagent.plugin")), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new f(r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return x.f38692a;
    }

    private static final s h(s r11) {
        d.h.b.o.e(r11, "$this$setState");
        return s.a(r11, null, com.obric.autoaction.vdplayer.d.k.a(r11.b(), null, null, null, null, null, false, 47, null), null, null, false, null, null, 125, null);
    }

    private final Object a(boolean r8, d.c.d<? super x> r9) {
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, c.class) == false) goto L7;
        c r1 = (c) ZeusTransformUtils.preCheckCast(r10, c.class, "com.obric.aiagent.plugin");
        if ((r1.f25577e & Integer.MIN_VALUE) == 0) goto L7;
        r1.f25577e -= Integer.MIN_VALUE;
    L8:
        Object r11 = r1.f25575c;
        Object r3 = d.c.a.b.a();
        int r4 = r1.f25577e;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        r8 = r1.f25574b;
        u this = (u) ZeusTransformUtils.preCheckCast(r1.f25573a, u.class, "com.obric.aiagent.plugin");
        d.o.a(r11);
    L25:
        boolean r12 = ((Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L26:
        if (r12 == false) goto L28;
        this.a($$Lambda$u$CEz7ewY3Gx686CdfrFTR4tetNI.INSTANCE);
    L30:
        return x.f38692a;
    L28:
        Loog.INSTANCE.i(TAG, "ExitUserOperating failed, isCallUser=" + r8);
        goto L30
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r8 = r1.f25574b;
        this = (u) ZeusTransformUtils.preCheckCast(r1.f25573a, u.class, "com.obric.aiagent.plugin");
        d.o.a(r11);
    L21:
        r12 = ((Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        goto L26
    L16:
        d.o.a(r11);
        if (r8 == false) goto L22;
        com.obric.autoaction.vdplayer.b.a.c r13 = this.f;
        r1.f25573a = this;
        r1.f25574b = r8;
        r1.f25577e = 1;
        r11 = r13.a(r1);
        if (r11 != r3) goto L21;
        return r3;
    L22:
        com.obric.autoaction.vdplayer.b.a.d r14 = this.g;
        r1.f25573a = this;
        r1.f25574b = r8;
        r1.f25577e = 2;
        r11 = r14.a(r1);
        if (r11 != r3) goto L25;
        return r3;
    L7:
        r1 = new c(this, r10);
        goto L8
    }

    private static final s i(s r11) {
        d.h.b.o.e(r11, "$this$setState");
        return s.a(r11, null, null, null, null, false, com.obric.autoaction.vdplayer.d.o.f25519a, null, 95, null);
    }

    private final void a(com.obric.autogui.vdplayer.api.a.a.d r10) {
        a((com.obric.autoaction.vdplayer.c.a) ZeusTransformUtils.preCheckCast(q.g.f25532a, com.obric.autoaction.vdplayer.c.a.class, "com.obric.aiagent.plugin"));
        IAgentSessionManager.a r0 = this.n;
        if (r0 == null) goto L13;
        ak<com.obric.autogui.vdplayer.api.a.b> r1 = r0.b();
        if (r1 == null) goto L13;
        com.obric.autogui.vdplayer.api.a.b r2 = (com.obric.autogui.vdplayer.api.a.b) ZeusTransformUtils.preCheckCast(r1.c(), com.obric.autogui.vdplayer.api.a.b.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L13;
        IAutoActionAgentEventListener.SessionInfo r3 = r2.a();
        if (r3 == null) goto L13;
        AutoOperateTask r4 = r3.getTask();
        if (r4 == null) goto L13;
        Bundle r5 = r4.getTaskExtras();
    L14:
        boolean r11 = r10.d();
        boolean r6 = true;
        if (r5 != null) goto L17;
    L19:
        r6 = false;
    L20:
        if (r6 == false) goto L22;
        Loog.INSTANCE.i(TAG, " exited with `eos_exit_directly` == true");
        a((com.obric.autoaction.vdplayer.c.a) ZeusTransformUtils.preCheckCast(q.a.f25526a, com.obric.autoaction.vdplayer.c.a.class, "com.obric.aiagent.plugin"));
        return;
    L22:
        kotlinx.coroutines.i.a(androidx.lifecycle.ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new e(r11, this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L17:
        if (r5.getBoolean("eos_exit_directly", false) != true) goto L19;
    L13:
        r5 = null;
        goto L14
    }

    public final Bitmap e() {
        com.obric.autoaction.vdplayer.b.a.e r0 = this.k;
        IAgentSessionManager.a r3 = this.n;
        if (r3 == null) goto L9;
        ak<com.obric.autogui.vdplayer.api.a.b> r4 = r3.b();
        if (r4 == null) goto L9;
        com.obric.autogui.vdplayer.api.a.b r5 = (com.obric.autogui.vdplayer.api.a.b) ZeusTransformUtils.preCheckCast(r4.c(), com.obric.autogui.vdplayer.api.a.b.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L9;
        Bitmap r6 = r5.d();
    L11:
        return r0.a(r6);
    L9:
        r6 = null;
        goto L11
    }

    public final String f() {
        IAgentSessionManager.a r2 = this.n;
        if (r2 == null) goto L13;
        ak<com.obric.autogui.vdplayer.api.a.b> r3 = r2.b();
        if (r3 == null) goto L13;
        com.obric.autogui.vdplayer.api.a.b r4 = (com.obric.autogui.vdplayer.api.a.b) ZeusTransformUtils.preCheckCast(r3.c(), com.obric.autogui.vdplayer.api.a.b.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L13;
        IAutoActionAgentEventListener.SessionInfo r5 = r4.a();
        if (r5 == null) goto L13;
        AutoOperateTask r6 = r5.getTask();
        if (r6 == null) goto L13;
        return r6.getUserTask();
    L13:
        return null;
    }

    @Override // androidx.lifecycle.aj
    public void a() {
        super.a();
        IAgentSessionManager.a r0 = this.n;
        if (r0 == null) goto L11;
        ak<com.obric.autogui.vdplayer.api.a.b> r1 = r0.b();
        if (r1 == null) goto L11;
        com.obric.autogui.vdplayer.api.a.b r2 = (com.obric.autogui.vdplayer.api.a.b) ZeusTransformUtils.preCheckCast(r1.c(), com.obric.autogui.vdplayer.api.a.b.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L11;
        IAutoActionAgentEventListener.SessionInfo r3 = r2.a();
        if (r3 == null) goto L11;
        String r4 = r3.getSessionKey();
    L12:
        if (r4 == null) goto L15;
        r = new d.m(r4, b().c());
        return;
    L15:
        return;
    L11:
        r4 = null;
        goto L12
    }

    public s a(s r1, s r2) {
        d.h.b.o.e(r1, "oldState");
        d.h.b.o.e(r2, "state");
        return r2.a(r1);
    }
}
