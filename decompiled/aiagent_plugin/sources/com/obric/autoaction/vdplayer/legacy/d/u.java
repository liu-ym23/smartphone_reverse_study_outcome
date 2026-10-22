package com.obric.autoaction.vdplayer.legacy.d;

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
public final class u extends com.obric.autoaction.vdplayer.legacy.b.d<s, r, q> {
    private static final String TAG = "VDPlayerViewModel";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f25968a = null;
    private static d.m<String, s> q;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autoaction.vdplayer.legacy.a.a.g f25969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.autoaction.vdplayer.legacy.a.a.f f25970c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.obric.autoaction.vdplayer.legacy.a.a.b f25971d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.obric.autoaction.vdplayer.legacy.a.a.a f25972e;
    private final com.obric.autoaction.vdplayer.legacy.a.a.c f;
    private final com.obric.autoaction.vdplayer.legacy.a.a.d g;
    private final com.obric.autoaction.vdplayer.legacy.a.a.h h;
    private final com.obric.autoaction.vdplayer.legacy.a.b.a i;
    private final com.obric.autoaction.vdplayer.legacy.a.b.b j;
    private final com.obric.autoaction.vdplayer.legacy.a.a.e k;
    private com.obric.autoaction.vdplayer.legacy.d.a.a l;
    private com.obric.autoaction.vdplayer.legacy.d.a.a m;
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
        public static final /* synthetic */ int[] f25973a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f25974b = null;

        static {
            int[] r0 = new int[com.obric.autoaction.vdplayer.legacy.d.j.values().length];
            r0[com.obric.autoaction.vdplayer.legacy.d.j.f25904a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L20:
            r0[com.obric.autoaction.vdplayer.legacy.d.j.f25905b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L26:
            r0[com.obric.autoaction.vdplayer.legacy.d.j.f25906c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L8:
            f25973a = r0;
            int[] r1 = new int[com.obric.autoaction.vdplayer.legacy.a.a.a.EnumC0631a.values().length];
            r1[com.obric.autoaction.vdplayer.legacy.a.a.a.EnumC0631a.f25650a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L22:
            r1[com.obric.autoaction.vdplayer.legacy.a.a.a.EnumC0631a.f25651b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L28:
            r1[com.obric.autoaction.vdplayer.legacy.a.a.a.EnumC0631a.f25652c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L12:
            f25974b = r1;
        }
    }

    /* JADX INFO: compiled from: VDPlayerViewModel.kt */
    @d.c.b.a.f(b = "VDPlayerViewModel.kt", c = {599, EntityType.NOTE}, d = "exitUserOperating", e = "com.obric.autoaction.vdplayer.legacy.vm.VDPlayerViewModel")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f25975a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f25976b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f25977c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ u f25978d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f25979e;

        c(u r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25978d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f25977c = r3;
            this.f25979e |= Integer.MIN_VALUE;
            return u.a(this.f25978d, false, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: VDPlayerViewModel.kt */
    @d.c.b.a.f(b = "VDPlayerViewModel.kt", c = {488}, d = "handleConfirmEnterCallUser", e = "com.obric.autoaction.vdplayer.legacy.vm.VDPlayerViewModel")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f25980a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f25981b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ u f25982c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f25983d;

        d(u r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25982c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f25981b = r3;
            this.f25983d |= Integer.MIN_VALUE;
            return u.a(this.f25982c, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: VDPlayerViewModel.kt */
    @d.c.b.a.f(b = "VDPlayerViewModel.kt", c = {625}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.legacy.vm.VDPlayerViewModel$handleTaskEnd$1")
    static final class e extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25984a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f25985b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ u f25986c;

        e(boolean r3, u r4, d.c.d<? super e> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25985b = r3;
            this.f25986c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f25985b, this.f25986c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25984a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L11:
            Loog.INSTANCE.i(u.TAG, "open app by model config (delayed) " + this.f25985b);
            if (this.f25985b == false) goto L25;
            u r8 = this.f25986c;
            IAgentSessionManager.a r6 = u.a(this.f25986c);
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
            this.f25984a = 1;
            if (ax.a(300, r13) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: VDPlayerViewModel.kt */
    @d.c.b.a.f(b = "VDPlayerViewModel.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.legacy.vm.VDPlayerViewModel$launchAutoExitCountDown$3$2")
    static final class f extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25987a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ u f25988b;

        f(u r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25988b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f25988b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f25987a != 0) goto L7;
            d.o.a(r2);
            u.c(this.f25988b, false);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: VDPlayerViewModel.kt */
    @d.c.b.a.f(b = "VDPlayerViewModel.kt", c = {551}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.legacy.vm.VDPlayerViewModel$launchCountDownEffect$2$2")
    static final class g extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25989a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ u f25990b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f25991c;

        g(u r3, boolean r4, d.c.d<? super g> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25990b = r3;
            this.f25991c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((g) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new g(this.f25990b, this.f25991c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25989a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            u r7 = this.f25990b;
            boolean r2 = this.f25991c;
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25989a = 1;
            if (u.a(r7, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: VDPlayerViewModel.kt */
    @d.c.b.a.f(b = "VDPlayerViewModel.kt", c = {293}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.legacy.vm.VDPlayerViewModel$logStateOnDebug$1")
    static final class h extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25992a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ u f25993b;

        h(u r3, d.c.d<? super h> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25993b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new h(this.f25993b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25992a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            d.o.a(r6);
        L12:
            throw new d.d();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            ak<s> r7 = this.f25993b.b();
            kotlinx.coroutines.b.i<? super s> r2 = (kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(AnonymousClass1.f25994a, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
            d.c.d<?> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25992a = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: VDPlayerViewModel.kt */
    @d.c.b.a.f(b = "VDPlayerViewModel.kt", c = {280}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.legacy.vm.VDPlayerViewModel$observePanelIdle$1")
    static final class i extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25995a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ u f25996b;

        /* JADX INFO: compiled from: SafeCollector.common.kt */
        public static final class a implements kotlinx.coroutines.b.h<com.obric.autoaction.vdplayer.legacy.d.l> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.b.h f25998a;

            /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.legacy.d.u$i$a$1, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            public static final class AnonymousClass1<T> implements kotlinx.coroutines.b.i {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ kotlinx.coroutines.b.i f25999a;

                /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.legacy.d.u$i$a$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @d.c.b.a.f(b = "VDPlayerViewModel.kt", c = {219}, d = "emit", e = "com.obric.autoaction.vdplayer.legacy.vm.VDPlayerViewModel$observePanelIdle$1$invokeSuspend$$inlined$map$1$2")
                public static final class C06471 extends d.c.b.a.d {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f26000a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f26001b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    final /* synthetic */ AnonymousClass1 f26002c;

                    public C06471(AnonymousClass1 r3, d.c.d r4) {
                        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                        this.f26002c = r3;
                        super(r5);
                    }

                    @Override // d.c.b.a.a
                    public final Object invokeSuspend(Object r3) {
                        this.f26000a = r3;
                        this.f26001b |= Integer.MIN_VALUE;
                        return this.f26002c.emit(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
                    }
                }

                public AnonymousClass1(kotlinx.coroutines.b.i r3) {
                    this.f25999a = (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
                }

                @Override // kotlinx.coroutines.b.i
                public final Object emit(Object r6, d.c.d r7) {
                    d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                    if (ZeusTransformUtils.instanceOf(r8, C06471.class) == false) goto L7;
                    C06471 r0 = (C06471) ZeusTransformUtils.preCheckCast(r8, C06471.class, "com.obric.aiagent.plugin");
                    if ((r0.f26001b & Integer.MIN_VALUE) == 0) goto L7;
                    r0.f26001b -= Integer.MIN_VALUE;
                L8:
                    Object r9 = r0.f26000a;
                    Object r2 = d.c.a.b.a();
                    int r3 = r0.f26001b;
                    if (r3 == 0) goto L14;
                    if (r3 != 1) goto L13;
                    d.o.a(r9);
                L18:
                    return x.f38692a;
                L13:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L14:
                    d.o.a(r9);
                    kotlinx.coroutines.b.i r5 = this.f25999a;
                    d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
                    com.obric.autoaction.vdplayer.legacy.d.l r11 = ((s) ZeusTransformUtils.preCheckCast(r6, s.class, "com.obric.aiagent.plugin")).b().a().a();
                    r0.f26001b = 1;
                    if (r5.emit(r11, r0) != r2) goto L18;
                    return r2;
                L7:
                    r0 = new C06471(this, r8);
                    goto L8
                }
            }

            public a(kotlinx.coroutines.b.h r3) {
                this.f25998a = (kotlinx.coroutines.b.h) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
            }

            @Override // kotlinx.coroutines.b.h
            public Object collect(kotlinx.coroutines.b.i<? super com.obric.autoaction.vdplayer.legacy.d.l> r3, d.c.d r4) {
                kotlinx.coroutines.b.i r5 = (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
                d.c.d<? super x> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                Object r2 = this.f25998a.collect((kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin"), r6);
                if (r2 != d.c.a.b.a()) goto L6;
                return r2;
            L6:
                return x.f38692a;
            }
        }

        i(u r3, d.c.d<? super i> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25996b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((i) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), i.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new i(this.f25996b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25995a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            kotlinx.coroutines.b.h r7 = kotlinx.coroutines.b.j.b((kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(new a((kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(this.f25996b.b(), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin")), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin"));
            final u r4 = this.f25996b;
            kotlinx.coroutines.b.i r2 = (kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r4), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
            d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25995a = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: VDPlayerViewModel.kt */
    @d.c.b.a.f(b = "VDPlayerViewModel.kt", c = {248}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.legacy.vm.VDPlayerViewModel$observeSecureLayer$1")
    static final class j extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f26003a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ u f26004b;

        j(u r3, d.c.d<? super j> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f26004b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((j) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), j.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new j(this.f26004b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f26003a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            kotlinx.coroutines.b.h<Boolean> r7 = u.e(this.f26004b).b();
            final u r3 = this.f26004b;
            kotlinx.coroutines.b.i<? super Boolean> r2 = (kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
            d.c.d<? super x> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f26003a = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: VDPlayerViewModel.kt */
    @d.c.b.a.f(b = "VDPlayerViewModel.kt", c = {256}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.legacy.vm.VDPlayerViewModel$observeUserOperating$1")
    static final class k extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f26006a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ u f26007b;

        /* JADX INFO: compiled from: SafeCollector.common.kt */
        public static final class a implements kotlinx.coroutines.b.h<com.obric.autoaction.vdplayer.legacy.d.o> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.b.h f26010a;

            /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.legacy.d.u$k$a$1, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            public static final class AnonymousClass1<T> implements kotlinx.coroutines.b.i {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ kotlinx.coroutines.b.i f26011a;

                /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.legacy.d.u$k$a$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @d.c.b.a.f(b = "VDPlayerViewModel.kt", c = {219}, d = "emit", e = "com.obric.autoaction.vdplayer.legacy.vm.VDPlayerViewModel$observeUserOperating$1$invokeSuspend$$inlined$map$1$2")
                public static final class C06481 extends d.c.b.a.d {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f26012a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f26013b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    final /* synthetic */ AnonymousClass1 f26014c;

                    public C06481(AnonymousClass1 r3, d.c.d r4) {
                        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                        this.f26014c = r3;
                        super(r5);
                    }

                    @Override // d.c.b.a.a
                    public final Object invokeSuspend(Object r3) {
                        this.f26012a = r3;
                        this.f26013b |= Integer.MIN_VALUE;
                        return this.f26014c.emit(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
                    }
                }

                public AnonymousClass1(kotlinx.coroutines.b.i r3) {
                    this.f26011a = (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
                }

                @Override // kotlinx.coroutines.b.i
                public final Object emit(Object r6, d.c.d r7) {
                    d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                    if (ZeusTransformUtils.instanceOf(r8, C06481.class) == false) goto L7;
                    C06481 r0 = (C06481) ZeusTransformUtils.preCheckCast(r8, C06481.class, "com.obric.aiagent.plugin");
                    if ((r0.f26013b & Integer.MIN_VALUE) == 0) goto L7;
                    r0.f26013b -= Integer.MIN_VALUE;
                L8:
                    Object r9 = r0.f26012a;
                    Object r2 = d.c.a.b.a();
                    int r3 = r0.f26013b;
                    if (r3 == 0) goto L14;
                    if (r3 != 1) goto L13;
                    d.o.a(r9);
                L18:
                    return x.f38692a;
                L13:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L14:
                    d.o.a(r9);
                    kotlinx.coroutines.b.i r5 = this.f26011a;
                    d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
                    com.obric.autoaction.vdplayer.legacy.d.o r11 = ((s) ZeusTransformUtils.preCheckCast(r6, s.class, "com.obric.aiagent.plugin")).e();
                    r0.f26013b = 1;
                    if (r5.emit(r11, r0) != r2) goto L18;
                    return r2;
                L7:
                    r0 = new C06481(this, r8);
                    goto L8
                }
            }

            public a(kotlinx.coroutines.b.h r3) {
                this.f26010a = (kotlinx.coroutines.b.h) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
            }

            @Override // kotlinx.coroutines.b.h
            public Object collect(kotlinx.coroutines.b.i<? super com.obric.autoaction.vdplayer.legacy.d.o> r3, d.c.d r4) {
                kotlinx.coroutines.b.i r5 = (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
                d.c.d<? super x> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                Object r2 = this.f26010a.collect((kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin"), r6);
                if (r2 != d.c.a.b.a()) goto L6;
                return r2;
            L6:
                return x.f38692a;
            }
        }

        k(u r3, d.c.d<? super k> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f26007b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((k) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), k.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new k(this.f26007b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f26006a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            kotlinx.coroutines.b.h r7 = kotlinx.coroutines.b.j.b((kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(new a((kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(this.f26007b.b(), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin")), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin"));
            final u r4 = this.f26007b;
            kotlinx.coroutines.b.i r2 = (kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r4), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
            d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f26006a = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: VDPlayerViewModel.kt */
    @d.c.b.a.f(b = "VDPlayerViewModel.kt", c = {230}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.legacy.vm.VDPlayerViewModel$subscribeToSessionData$1")
    static final class l extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f26015a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ u f26016b;

        /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.legacy.d.u$l$1, reason: invalid class name */
        /* JADX INFO: compiled from: VDPlayerViewModel.kt */
        @d.c.b.a.f(b = "VDPlayerViewModel.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.legacy.vm.VDPlayerViewModel$subscribeToSessionData$1$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<IAgentSessionManager.a, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f26017a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f26018b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ u f26019c;

            AnonymousClass1(u r3, d.c.d<? super AnonymousClass1> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f26019c = r3;
                super(2, r5);
            }

            public static /* synthetic */ s lambda$4oyKpluDpUAFkw5In8T9aZ1x7rc(s r0) {
                return a(r0);
            }

            public final Object a(IAgentSessionManager.a r3, d.c.d<? super x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((IAgentSessionManager.a) ZeusTransformUtils.wrapperContextForParams(r3, IAgentSessionManager.a.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                AnonymousClass1 r0 = new AnonymousClass1(this.f26019c, r5);
                r0.f26018b = r3;
                return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(IAgentSessionManager.a r3, d.c.d<? super x> r4) {
                return a((IAgentSessionManager.a) ZeusTransformUtils.preCheckCast(r3, IAgentSessionManager.a.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r7) {
                d.c.a.b.a();
                if (this.f26017a != 0) goto L29;
                d.o.a(r7);
                IAgentSessionManager.a r8 = (IAgentSessionManager.a) ZeusTransformUtils.preCheckCast(this.f26018b, IAgentSessionManager.a.class, "com.obric.aiagent.plugin");
                if (r8 != null) goto L8;
                Loog.INSTANCE.i(u.TAG, "Active session is null, finishing.");
                u.a(this.f26019c, (q) ZeusTransformUtils.preCheckCast(q.a.f25933a, q.class, "com.obric.aiagent.plugin"));
                return x.f38692a;
            L8:
                IAgentSessionManager.a r2 = u.a(this.f26019c);
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
                u.a(this.f26019c, r8);
                if (r9 == null) goto L27;
                if (d.h.b.o.a(r9, r3) == true) goto L27;
                Loog.INSTANCE.i(u.TAG, "ActiveSession changed: " + r9 + " -> " + r3);
                u.a(this.f26019c, (q) ZeusTransformUtils.preCheckCast(q.g.f25939a, q.class, "com.obric.aiagent.plugin"));
                u.a(this.f26019c, $$Lambda$u$l$1$4oyKpluDpUAFkw5In8T9aZ1x7rc.INSTANCE);
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
        @d.c.b.a.f(b = "VDPlayerViewModel.kt", c = {189}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.legacy.vm.VDPlayerViewModel$subscribeToSessionData$1$invokeSuspend$$inlined$flatMapLatest$1")
        public static final class a extends d.c.b.a.l implements d.h.a.q<kotlinx.coroutines.b.i<? super r>, IAgentSessionManager.a, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f26021a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f26022b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ u f26023c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private /* synthetic */ Object f26024d;

            public a(d.c.d r3, u r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                this.f26023c = r4;
                super(3, r5);
            }

            public final Object a(kotlinx.coroutines.b.i<? super r> r3, IAgentSessionManager.a r4, d.c.d<? super x> r5) {
                kotlinx.coroutines.b.i r6 = (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
                a r0 = new a((d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"), this.f26023c);
                r0.f26024d = r6;
                r0.f26022b = r4;
                return r0.invokeSuspend(x.f38692a);
            }

            @Override // d.h.a.q
            public /* synthetic */ Object invoke(kotlinx.coroutines.b.i<? super r> r3, IAgentSessionManager.a r4, d.c.d<? super x> r5) {
                return a((kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin"), r4, (d.c.d) ZeusTransformUtils.preCheckCast(r5, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r8) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f26021a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r8);
            L12:
                return x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r8);
                kotlinx.coroutines.b.i r9 = (kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(this.f26024d, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
                Object r2 = this.f26022b;
                d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                IAgentSessionManager.a r3 = (IAgentSessionManager.a) ZeusTransformUtils.preCheckCast(r2, IAgentSessionManager.a.class, "com.obric.aiagent.plugin");
                kotlinx.coroutines.b.h r5 = kotlinx.coroutines.b.j.a(new kotlinx.coroutines.b.h[]{kotlinx.coroutines.b.j.b((kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(new b((kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(r3.b(), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin"), this.f26023c), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin")), (kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(new c(r3.a()), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin")});
                d.c.d r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f26021a = 1;
                if (kotlinx.coroutines.b.j.a(r9, r5, r6) != r0) goto L12;
                return r0;
            }
        }

        /* JADX INFO: compiled from: SafeCollector.common.kt */
        public static final class b implements kotlinx.coroutines.b.h<r.g> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.b.h f26025a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ u f26026b;

            /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.legacy.d.u$l$b$1, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            public static final class AnonymousClass1<T> implements kotlinx.coroutines.b.i {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ kotlinx.coroutines.b.i f26027a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ u f26028b;

                /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.legacy.d.u$l$b$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @d.c.b.a.f(b = "VDPlayerViewModel.kt", c = {219}, d = "emit", e = "com.obric.autoaction.vdplayer.legacy.vm.VDPlayerViewModel$subscribeToSessionData$1$invokeSuspend$lambda$2$$inlined$map$1$2")
                public static final class C06491 extends d.c.b.a.d {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f26029a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f26030b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    final /* synthetic */ AnonymousClass1 f26031c;

                    public C06491(AnonymousClass1 r3, d.c.d r4) {
                        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                        this.f26031c = r3;
                        super(r5);
                    }

                    @Override // d.c.b.a.a
                    public final Object invokeSuspend(Object r3) {
                        this.f26029a = r3;
                        this.f26030b |= Integer.MIN_VALUE;
                        return this.f26031c.emit(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
                    }
                }

                public AnonymousClass1(kotlinx.coroutines.b.i r3, u r4) {
                    this.f26027a = (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
                    this.f26028b = r4;
                }

                @Override // kotlinx.coroutines.b.i
                public final Object emit(Object r6, d.c.d r7) {
                    d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                    if (ZeusTransformUtils.instanceOf(r8, C06491.class) == false) goto L7;
                    C06491 r0 = (C06491) ZeusTransformUtils.preCheckCast(r8, C06491.class, "com.obric.aiagent.plugin");
                    if ((r0.f26030b & Integer.MIN_VALUE) == 0) goto L7;
                    r0.f26030b -= Integer.MIN_VALUE;
                L8:
                    Object r9 = r0.f26029a;
                    Object r2 = d.c.a.b.a();
                    int r3 = r0.f26030b;
                    if (r3 == 0) goto L14;
                    if (r3 != 1) goto L13;
                    d.o.a(r9);
                L18:
                    return x.f38692a;
                L13:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L14:
                    d.o.a(r9);
                    kotlinx.coroutines.b.i r10 = this.f26027a;
                    d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
                    r.g r1 = new r.g(u.a(this.f26028b, (com.obric.autogui.vdplayer.api.a.b) ZeusTransformUtils.preCheckCast(r6, com.obric.autogui.vdplayer.api.a.b.class, "com.obric.aiagent.plugin")));
                    r0.f26030b = 1;
                    if (r10.emit(r1, r0) != r2) goto L18;
                    return r2;
                L7:
                    r0 = new C06491(this, r8);
                    goto L8
                }
            }

            public b(kotlinx.coroutines.b.h r3, u r4) {
                this.f26025a = (kotlinx.coroutines.b.h) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
                this.f26026b = r4;
            }

            @Override // kotlinx.coroutines.b.h
            public Object collect(kotlinx.coroutines.b.i<? super r.g> r4, d.c.d r5) {
                kotlinx.coroutines.b.i r6 = (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
                d.c.d<? super x> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                Object r3 = this.f26025a.collect((kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r6, this.f26026b), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin"), r7);
                if (r3 != d.c.a.b.a()) goto L6;
                return r3;
            L6:
                return x.f38692a;
            }
        }

        /* JADX INFO: compiled from: SafeCollector.common.kt */
        public static final class c implements kotlinx.coroutines.b.h<r.f> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.b.h f26032a;

            /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.legacy.d.u$l$c$1, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            public static final class AnonymousClass1<T> implements kotlinx.coroutines.b.i {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ kotlinx.coroutines.b.i f26033a;

                /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.legacy.d.u$l$c$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @d.c.b.a.f(b = "VDPlayerViewModel.kt", c = {219}, d = "emit", e = "com.obric.autoaction.vdplayer.legacy.vm.VDPlayerViewModel$subscribeToSessionData$1$invokeSuspend$lambda$2$$inlined$map$2$2")
                public static final class C06501 extends d.c.b.a.d {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f26034a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f26035b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    final /* synthetic */ AnonymousClass1 f26036c;

                    public C06501(AnonymousClass1 r3, d.c.d r4) {
                        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                        this.f26036c = r3;
                        super(r5);
                    }

                    @Override // d.c.b.a.a
                    public final Object invokeSuspend(Object r3) {
                        this.f26034a = r3;
                        this.f26035b |= Integer.MIN_VALUE;
                        return this.f26036c.emit(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
                    }
                }

                public AnonymousClass1(kotlinx.coroutines.b.i r3) {
                    this.f26033a = (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
                }

                @Override // kotlinx.coroutines.b.i
                public final Object emit(Object r6, d.c.d r7) {
                    d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                    if (ZeusTransformUtils.instanceOf(r8, C06501.class) == false) goto L7;
                    C06501 r0 = (C06501) ZeusTransformUtils.preCheckCast(r8, C06501.class, "com.obric.aiagent.plugin");
                    if ((r0.f26035b & Integer.MIN_VALUE) == 0) goto L7;
                    r0.f26035b -= Integer.MIN_VALUE;
                L8:
                    Object r9 = r0.f26034a;
                    Object r2 = d.c.a.b.a();
                    int r3 = r0.f26035b;
                    if (r3 == 0) goto L14;
                    if (r3 != 1) goto L13;
                    d.o.a(r9);
                L18:
                    return x.f38692a;
                L13:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L14:
                    d.o.a(r9);
                    kotlinx.coroutines.b.i r5 = this.f26033a;
                    d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
                    r.f r11 = new r.f((com.obric.autogui.vdplayer.api.a.a) ZeusTransformUtils.preCheckCast(r6, com.obric.autogui.vdplayer.api.a.a.class, "com.obric.aiagent.plugin"));
                    r0.f26035b = 1;
                    if (r5.emit(r11, r0) != r2) goto L18;
                    return r2;
                L7:
                    r0 = new C06501(this, r8);
                    goto L8
                }
            }

            public c(kotlinx.coroutines.b.h r3) {
                this.f26032a = (kotlinx.coroutines.b.h) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
            }

            @Override // kotlinx.coroutines.b.h
            public Object collect(kotlinx.coroutines.b.i<? super r.f> r3, d.c.d r4) {
                kotlinx.coroutines.b.i r5 = (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
                d.c.d<? super x> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                Object r2 = this.f26032a.collect((kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin"), r6);
                if (r2 != d.c.a.b.a()) goto L6;
                return r2;
            L6:
                return x.f38692a;
            }
        }

        l(u r3, d.c.d<? super l> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f26016b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((l) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), l.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new l(this.f26016b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f26015a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            kotlinx.coroutines.b.h r8 = kotlinx.coroutines.b.j.b(kotlinx.coroutines.b.j.c(kotlinx.coroutines.b.j.c(u.d(this.f26016b).b(), (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f26016b, null), d.h.a.m.class, "com.obric.aiagent.plugin"))), (d.h.a.q) ZeusTransformUtils.preCheckCast(new a(null, this.f26016b), d.h.a.q.class, "com.obric.aiagent.plugin"));
            final u r3 = this.f26016b;
            kotlinx.coroutines.b.i r2 = (kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r3), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
            d.c.d<? super x> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f26015a = 1;
            if (r8.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: VDPlayerViewModel.kt */
    @d.c.b.a.f(b = "VDPlayerViewModel.kt", c = {237}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.legacy.vm.VDPlayerViewModel$subscribeToSessionData$2")
    static final class m extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f26037a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ u f26038b;

        /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.legacy.d.u$m$1, reason: invalid class name */
        /* JADX INFO: compiled from: VDPlayerViewModel.kt */
        static final class AnonymousClass1<T> implements kotlinx.coroutines.b.i {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ u f26039a;

            AnonymousClass1(u r1) {
                this.f26039a = r1;
            }

            public static /* synthetic */ s lambda$9Ix5J7NSUhHVL5Precsc_L9BFw4(boolean r0, s r1) {
                return a(r0, r1);
            }

            @Override // kotlinx.coroutines.b.i
            public /* synthetic */ Object emit(Object r3, d.c.d r4) {
                d.c.d<? super x> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue(), r5);
            }

            private static final s a(boolean r11, s r12) {
                d.h.b.o.e(r12, "$this$setState");
                return s.a(r12, null, com.obric.autoaction.vdplayer.legacy.d.k.a(r12.b(), null, null, null, null, null, r11, 31, null), null, null, false, null, null, 125, null);
            }

            public final Object a(final boolean r3, d.c.d<? super x> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                u.a(this.f26039a, new $$Lambda$u$m$1$9Ix5J7NSUhHVL5Precsc_L9BFw4(r3));
                if (r3 == false) goto L6;
                u.a(this.f26039a, (q) ZeusTransformUtils.preCheckCast(q.c.f25935a, q.class, "com.obric.aiagent.plugin"));
            L6:
                return x.f38692a;
            }
        }

        /* JADX INFO: compiled from: SafeCollector.common.kt */
        public static final class a implements kotlinx.coroutines.b.h<Boolean> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.b.h f26040a;

            /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.legacy.d.u$m$a$1, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            public static final class AnonymousClass1<T> implements kotlinx.coroutines.b.i {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ kotlinx.coroutines.b.i f26041a;

                /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.legacy.d.u$m$a$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @d.c.b.a.f(b = "VDPlayerViewModel.kt", c = {219}, d = "emit", e = "com.obric.autoaction.vdplayer.legacy.vm.VDPlayerViewModel$subscribeToSessionData$2$invokeSuspend$$inlined$map$1$2")
                public static final class C06511 extends d.c.b.a.d {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f26042a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f26043b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    final /* synthetic */ AnonymousClass1 f26044c;

                    public C06511(AnonymousClass1 r3, d.c.d r4) {
                        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                        this.f26044c = r3;
                        super(r5);
                    }

                    @Override // d.c.b.a.a
                    public final Object invokeSuspend(Object r3) {
                        this.f26042a = r3;
                        this.f26043b |= Integer.MIN_VALUE;
                        return this.f26044c.emit(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
                    }
                }

                public AnonymousClass1(kotlinx.coroutines.b.i r3) {
                    this.f26041a = (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
                }

                @Override // kotlinx.coroutines.b.i
                public final Object emit(Object r6, d.c.d r7) {
                    d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                    if (ZeusTransformUtils.instanceOf(r8, C06511.class) == false) goto L7;
                    C06511 r0 = (C06511) ZeusTransformUtils.preCheckCast(r8, C06511.class, "com.obric.aiagent.plugin");
                    if ((r0.f26043b & Integer.MIN_VALUE) == 0) goto L7;
                    r0.f26043b -= Integer.MIN_VALUE;
                L8:
                    Object r9 = r0.f26042a;
                    Object r2 = d.c.a.b.a();
                    int r3 = r0.f26043b;
                    if (r3 == 0) goto L14;
                    if (r3 != 1) goto L13;
                    d.o.a(r9);
                L18:
                    return x.f38692a;
                L13:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L14:
                    d.o.a(r9);
                    kotlinx.coroutines.b.i r5 = this.f26041a;
                    d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
                    Boolean r11 = d.c.b.a.b.a(((GlobalUIContext) ZeusTransformUtils.preCheckCast(r6, GlobalUIContext.class, "com.obric.aiagent.plugin")).getAssistState().getVisible());
                    r0.f26043b = 1;
                    if (r5.emit(r11, r0) != r2) goto L18;
                    return r2;
                L7:
                    r0 = new C06511(this, r8);
                    goto L8
                }
            }

            public a(kotlinx.coroutines.b.h r3) {
                this.f26040a = (kotlinx.coroutines.b.h) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
            }

            @Override // kotlinx.coroutines.b.h
            public Object collect(kotlinx.coroutines.b.i<? super Boolean> r3, d.c.d r4) {
                kotlinx.coroutines.b.i r5 = (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
                d.c.d<? super x> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                Object r2 = this.f26040a.collect((kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin"), r6);
                if (r2 != d.c.a.b.a()) goto L6;
                return r2;
            L6:
                return x.f38692a;
            }
        }

        m(u r3, d.c.d<? super m> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f26038b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((m) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), m.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new m(this.f26038b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f26037a;
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
            kotlinx.coroutines.b.i r2 = (kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f26038b), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
            d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f26037a = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: VDPlayerViewModel.kt */
    @d.c.b.a.f(b = "VDPlayerViewModel.kt", c = {102}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.legacy.vm.VDPlayerViewModel$updateParams$1")
    static final class n extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f26045a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f26046b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ u f26047c;

        n(boolean r3, u r4, d.c.d<? super n> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f26046b = r3;
            this.f26047c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((n) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), n.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new n(this.f26046b, this.f26047c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f26045a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L14:
            if (((s) ZeusTransformUtils.preCheckCast(this.f26047c.b().c(), s.class, "com.obric.aiagent.plugin")).g() == true) goto L19;
            if (((s) ZeusTransformUtils.preCheckCast(this.f26047c.b().c(), s.class, "com.obric.aiagent.plugin")).b().a().a() != com.obric.autoaction.vdplayer.legacy.d.l.f25918e) goto L19;
            this.f26047c.a((com.obric.autoaction.vdplayer.legacy.b.b) ZeusTransformUtils.preCheckCast(r.a.f25944a, com.obric.autoaction.vdplayer.legacy.b.b.class, "com.obric.aiagent.plugin"));
        L19:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            if (this.f26046b == false) goto L19;
            d.c.d r8 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f26045a = 1;
            if (ax.a(1000, r8) != r0) goto L14;
            return r0;
        }
    }

    /* JADX INFO: compiled from: VDPlayerViewModel.kt */
    @d.c.b.a.f(b = "VDPlayerViewModel.kt", c = {111}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.legacy.vm.VDPlayerViewModel$updateParams$2")
    static final class o extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f26048a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f26049b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ u f26050c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f26051d;

        o(boolean r3, u r4, String r5, d.c.d<? super o> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f26049b = r3;
            this.f26050c = r4;
            this.f26051d = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((o) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), o.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new o(this.f26049b, this.f26050c, this.f26051d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f26048a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L14:
            if (((s) ZeusTransformUtils.preCheckCast(this.f26050c.b().c(), s.class, "com.obric.aiagent.plugin")).b().a().a() != com.obric.autoaction.vdplayer.legacy.d.l.f) goto L25;
            IAgentSessionManager.a r8 = u.a(this.f26050c);
            if (r8 == null) goto L22;
            ak<com.obric.autogui.vdplayer.api.a.b> r9 = r8.b();
            if (r9 == null) goto L22;
            com.obric.autogui.vdplayer.api.a.b r10 = (com.obric.autogui.vdplayer.api.a.b) ZeusTransformUtils.preCheckCast(r9.c(), com.obric.autogui.vdplayer.api.a.b.class, "com.obric.aiagent.plugin");
            if (r10 == null) goto L22;
            IAutoActionAgentEventListener.SessionInfo r11 = r10.a();
        L23:
            u.b(this.f26050c).a("Clarify", this.f26051d, r11, u.c(this.f26050c));
        L22:
            r11 = null;
        L25:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            if (this.f26049b == false) goto L25;
            d.c.d r12 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f26048a = 1;
            if (ax.a(1000, r12) != r0) goto L14;
            return r0;
        }
    }

    static {
        f25968a = new a(null);
    }

    public u() {
        this(null, null, null, null, null, null, null, null, null, null, DownloadErrorCode.ERROR_IO, null);
    }

    /* JADX INFO: renamed from: lambda$47H4HHf5rO-hjOqhTDyl9v5jqXw, reason: not valid java name */
    public static /* synthetic */ s m701lambda$47H4HHf5rOhjOqhTDyl9v5jqXw(s r0) {
        return c(r0);
    }

    public static /* synthetic */ s lambda$5zSFuvPI7JqsAbBKWdelarWsNMw(s r0) {
        return g(r0);
    }

    /* JADX INFO: renamed from: lambda$8_AJ_oYS4jRHgybt-feNbuk7-d0, reason: not valid java name */
    public static /* synthetic */ s m702lambda$8_AJ_oYS4jRHgybtfeNbuk7d0(s r0) {
        return d(r0);
    }

    public static /* synthetic */ s lambda$BouXPUzsSWBPL9En_Zc3vZdIhnc(s r0) {
        return e(r0);
    }

    public static /* synthetic */ s lambda$IZPYImLkuGcL56BiRd4u4FhENiQ(com.obric.autoaction.vdplayer.legacy.d.d r0, s r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ s lambda$MHGK60I9ufIHT9sXpseYqupLOJs(long r0, s r2) {
        return a(r0, r2);
    }

    public static /* synthetic */ s lambda$Z9fRuhAH8OtwLMXaCctNZWyU8qw(s r0) {
        return a(r0);
    }

    public static /* synthetic */ x lambda$aeuPadhqp6QFRndBUvLQX2ztH7I(u r0, boolean r1) {
        return d(r0, r1);
    }

    public static /* synthetic */ s lambda$cJBRAjQR5uEAIv47aEg492jogpk(s r0) {
        return b(r0);
    }

    /* JADX INFO: renamed from: lambda$iBxKt-Uy_RhavGbp9muKqTO1rUg, reason: not valid java name */
    public static /* synthetic */ s m703lambda$iBxKtUy_RhavGbp9muKqTO1rUg(long r0, s r2) {
        return b(r0, r2);
    }

    public static /* synthetic */ s lambda$mNo4DlykPVe7TKNFiiesxDhKr6k(r r0, s r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ x lambda$nMEJT1VTYB3aYs952cU1or8NVbc(u r0) {
        return i(r0);
    }

    /* JADX INFO: renamed from: lambda$s3guQVL68nJs-4fwA-nWi-oNEk0, reason: not valid java name */
    public static /* synthetic */ s m704lambda$s3guQVL68nJs4fwAnWioNEk0(com.obric.autogui.vdplayer.api.a.a r0, s r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$uO3L-F8qiiNT2UHxFE9Ad4OY6YU, reason: not valid java name */
    public static /* synthetic */ x m705lambda$uO3LF8qiiNT2UHxFE9Ad4OY6YU(u r0, long r1) {
        return b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$vIwRWpf6-2d6aYQ2EVAvgVmLb2k, reason: not valid java name */
    public static /* synthetic */ x m706lambda$vIwRWpf62d6aYQ2EVAvgVmLb2k(u r0, long r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ s lambda$zAKUmDgcCRCi9CKJTD8ico66eJ4(s r0) {
        return f(r0);
    }

    public static final /* synthetic */ com.obric.autoaction.vdplayer.legacy.d.d a(u r0, com.obric.autogui.vdplayer.api.a.b r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ IAgentSessionManager.a a(u r0) {
        return r0.n;
    }

    public static final /* synthetic */ Object a(u r2, d.c.d r3) {
        return r2.b((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(u r2, boolean r3, d.c.d r4) {
        return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(u r2, q r3) {
        r2.a((com.obric.autoaction.vdplayer.legacy.b.a) ZeusTransformUtils.preCheckCast(r3, com.obric.autoaction.vdplayer.legacy.b.a.class, "com.obric.aiagent.plugin"));
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

    public static final /* synthetic */ com.obric.autoaction.vdplayer.legacy.a.a.f b(u r0) {
        return r0.f25970c;
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

    public static final /* synthetic */ com.obric.autoaction.vdplayer.legacy.a.b.a d(u r0) {
        return r0.i;
    }

    public static final /* synthetic */ com.obric.autoaction.vdplayer.legacy.a.b.b e(u r0) {
        return r0.j;
    }

    public static final /* synthetic */ com.obric.autoaction.vdplayer.legacy.d.a.a f(u r0) {
        return r0.l;
    }

    public static final /* synthetic */ void g(u r0) {
        r0.s();
    }

    public static final /* synthetic */ com.obric.autoaction.vdplayer.legacy.d.a.a h(u r0) {
        return r0.m;
    }

    @Override // com.obric.autoaction.vdplayer.legacy.b.d
    public /* synthetic */ com.obric.autoaction.vdplayer.legacy.b.c a(com.obric.autoaction.vdplayer.legacy.b.c r3, com.obric.autoaction.vdplayer.legacy.b.c r4) {
        com.obric.autoaction.vdplayer.legacy.b.c r5 = (com.obric.autoaction.vdplayer.legacy.b.c) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autoaction.vdplayer.legacy.b.c.class, "com.obric.aiagent.plugin");
        com.obric.autoaction.vdplayer.legacy.b.c r6 = (com.obric.autoaction.vdplayer.legacy.b.c) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.autoaction.vdplayer.legacy.b.c.class, "com.obric.aiagent.plugin");
        return (com.obric.autoaction.vdplayer.legacy.b.c) ZeusTransformUtils.preCheckCast(a((s) ZeusTransformUtils.preCheckCast(r5, s.class, "com.obric.aiagent.plugin"), (s) ZeusTransformUtils.preCheckCast(r6, s.class, "com.obric.aiagent.plugin")), com.obric.autoaction.vdplayer.legacy.b.c.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.vdplayer.legacy.b.d
    public /* synthetic */ Object a(com.obric.autoaction.vdplayer.legacy.b.b r3, d.c.d r4) {
        com.obric.autoaction.vdplayer.legacy.b.b r5 = (com.obric.autoaction.vdplayer.legacy.b.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autoaction.vdplayer.legacy.b.b.class, "com.obric.aiagent.plugin");
        d.c.d<? super x> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        return a((r) ZeusTransformUtils.preCheckCast(r5, r.class, "com.obric.aiagent.plugin"), r6);
    }

    public /* synthetic */ u(com.obric.autoaction.vdplayer.legacy.a.a.g r11, com.obric.autoaction.vdplayer.legacy.a.a.f r12, com.obric.autoaction.vdplayer.legacy.a.a.b r13, com.obric.autoaction.vdplayer.legacy.a.a.a r14, com.obric.autoaction.vdplayer.legacy.a.a.c r15, com.obric.autoaction.vdplayer.legacy.a.a.d r16, com.obric.autoaction.vdplayer.legacy.a.a.h r17, com.obric.autoaction.vdplayer.legacy.a.b.a r18, com.obric.autoaction.vdplayer.legacy.a.b.b r19, com.obric.autoaction.vdplayer.legacy.a.a.e r20, int r21, d.h.b.h r22) {
        if ((r21 & 1) == 0) goto L5;
        com.obric.autoaction.vdplayer.legacy.a.a.g r1 = new com.obric.autoaction.vdplayer.legacy.a.a.g();
    L7:
        if ((r21 & 2) == 0) goto L9;
        com.obric.autoaction.vdplayer.legacy.a.a.f r2 = new com.obric.autoaction.vdplayer.legacy.a.a.f();
    L11:
        if ((r21 & 4) == 0) goto L13;
        com.obric.autoaction.vdplayer.legacy.a.a.b r3 = new com.obric.autoaction.vdplayer.legacy.a.a.b();
    L15:
        if ((r21 & 8) == 0) goto L17;
        com.obric.autoaction.vdplayer.legacy.a.a.a r4 = new com.obric.autoaction.vdplayer.legacy.a.a.a();
    L19:
        if ((r21 & 16) == 0) goto L21;
        com.obric.autoaction.vdplayer.legacy.a.a.c r5 = new com.obric.autoaction.vdplayer.legacy.a.a.c();
    L23:
        if ((r21 & 32) == 0) goto L25;
        com.obric.autoaction.vdplayer.legacy.a.a.d r6 = new com.obric.autoaction.vdplayer.legacy.a.a.d();
    L27:
        if ((r21 & 64) == 0) goto L29;
        com.obric.autoaction.vdplayer.legacy.a.a.h r7 = new com.obric.autoaction.vdplayer.legacy.a.a.h();
    L31:
        if ((r21 & 128) == 0) goto L33;
        com.obric.autoaction.vdplayer.legacy.a.b.a r8 = new com.obric.autoaction.vdplayer.legacy.a.b.a();
    L35:
        if ((r21 & 256) == 0) goto L37;
        com.obric.autoaction.vdplayer.legacy.a.b.b r9 = new com.obric.autoaction.vdplayer.legacy.a.b.b();
    L39:
        if ((r21 & 512) == 0) goto L41;
        com.obric.autoaction.vdplayer.legacy.a.a.e r0 = new com.obric.autoaction.vdplayer.legacy.a.a.e();
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

    public u(com.obric.autoaction.vdplayer.legacy.a.a.g r24, com.obric.autoaction.vdplayer.legacy.a.a.f r25, com.obric.autoaction.vdplayer.legacy.a.a.b r26, com.obric.autoaction.vdplayer.legacy.a.a.a r27, com.obric.autoaction.vdplayer.legacy.a.a.c r28, com.obric.autoaction.vdplayer.legacy.a.a.d r29, com.obric.autoaction.vdplayer.legacy.a.a.h r30, com.obric.autoaction.vdplayer.legacy.a.b.a r31, com.obric.autoaction.vdplayer.legacy.a.b.b r32, com.obric.autoaction.vdplayer.legacy.a.a.e r33) {
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
        d.m<String, s> r11 = q;
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
        super((com.obric.autoaction.vdplayer.legacy.b.c) ZeusTransformUtils.preCheckCast(r12, com.obric.autoaction.vdplayer.legacy.b.c.class, "com.obric.aiagent.plugin"));
        this.f25969b = r24;
        this.f25970c = r25;
        this.f25971d = r26;
        this.f25972e = r27;
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

    public final void a(String r4) {
        this.p = r4;
        if (m() == false) goto L5;
        Loog.INSTANCE.i(TAG, "init " + hashCode());
        g();
        h();
        i();
        j();
        k();
        return;
    L5:
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

    public Object a(final r r6, d.c.d<? super x> r7) {
        d.c.d<? super x> r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (com.obric.autogui.common.b.b.f29001a.a() == false) goto L5;
        Loog.INSTANCE.i(TAG, "handleIntent " + r6);
    L7:
        if (ZeusTransformUtils.instanceOf(r6, r.f.class) == false) goto L10;
        a(((r.f) ZeusTransformUtils.preCheckCast(r6, r.f.class, "com.obric.aiagent.plugin")).a());
    L103:
        return x.f38692a;
    L10:
        if (ZeusTransformUtils.instanceOf(r6, r.g.class) == false) goto L13;
        a(((r.g) ZeusTransformUtils.preCheckCast(r6, r.g.class, "com.obric.aiagent.plugin")).getContext());
        goto L103
    L13:
        if (ZeusTransformUtils.instanceOf(r6, r.h.class) == false) goto L15;
        a(new $$Lambda$u$mNo4DlykPVe7TKNFiiesxDhKr6k(r6));
        goto L103
    L15:
        IAutoActionAgentEventListener.SessionInfo r2 = null;
        if (ZeusTransformUtils.instanceOf(r6, r.n.class) == false) goto L30;
        com.obric.autoaction.vdplayer.legacy.a.a.h r9 = this.h;
        IAgentSessionManager.a r5 = this.n;
        if (r5 == null) goto L24;
        ak<com.obric.autogui.vdplayer.api.a.b> r10 = r5.b();
        if (r10 == null) goto L24;
        com.obric.autogui.vdplayer.api.a.b r11 = (com.obric.autogui.vdplayer.api.a.b) ZeusTransformUtils.preCheckCast(r10.c(), com.obric.autogui.vdplayer.api.a.b.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L24;
        r2 = r11.a();
    L24:
        Object r12 = r9.a(r2, r8);
        if (r12 != d.c.a.b.a()) goto L28;
        return r12;
    L28:
        return x.f38692a;
    L30:
        if (ZeusTransformUtils.instanceOf(r6, r.o.class) == false) goto L37;
        Object r13 = a(r8);
        if (r13 != d.c.a.b.a()) goto L35;
        return r13;
    L35:
        return x.f38692a;
    L37:
        if (ZeusTransformUtils.instanceOf(r6, r.i.class) == false) goto L53;
        if (r() == true) goto L41;
    L44:
        com.obric.autoaction.vdplayer.legacy.a.a.f r14 = this.f25970c;
        String r0 = ((r.i) ZeusTransformUtils.preCheckCast(r6, r.i.class, "com.obric.aiagent.plugin")).getType();
        String r15 = ((r.i) ZeusTransformUtils.preCheckCast(r6, r.i.class, "com.obric.aiagent.plugin")).a();
        IAgentSessionManager.a r3 = this.n;
        if (r3 == null) goto L51;
        ak<com.obric.autogui.vdplayer.api.a.b> r4 = r3.b();
        if (r4 == null) goto L51;
        com.obric.autogui.vdplayer.api.a.b r1 = (com.obric.autogui.vdplayer.api.a.b) ZeusTransformUtils.preCheckCast(r4.c(), com.obric.autogui.vdplayer.api.a.b.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L51;
        r2 = r1.a();
    L51:
        r14.a(r0, r15, r2, this.p);
        goto L103
    L41:
        if (d.h.b.o.a(((r.i) ZeusTransformUtils.preCheckCast(r6, r.i.class, "com.obric.aiagent.plugin")).getType(), "Supplement") == false) goto L44;
        a((com.obric.autoaction.vdplayer.legacy.b.a) ZeusTransformUtils.preCheckCast(new q.j(d.c.b.a.b.a(ZeusTransformUtils.mapRes(R.string.vd_player_doubao_interaction_disabled, WsChannelMultiProcessSharedProvider.STRING_TYPE, "vd_player_doubao_interaction_disabled")), null, 2, null), com.obric.autoaction.vdplayer.legacy.b.a.class, "com.obric.aiagent.plugin"));
        return x.f38692a;
    L53:
        if (ZeusTransformUtils.instanceOf(r6, r.a.class) == false) goto L60;
        Object r16 = b(r8);
        if (r16 != d.c.a.b.a()) goto L58;
        return r16;
    L58:
        return x.f38692a;
    L60:
        if (ZeusTransformUtils.instanceOf(r6, r.c.class) == false) goto L65;
        com.obric.autoaction.vdplayer.legacy.d.a.a r17 = this.l;
        if (r17 == null) goto L103;
        r17.b();
        goto L103
    L65:
        if (ZeusTransformUtils.instanceOf(r6, r.j.class) == false) goto L70;
        com.obric.autoaction.vdplayer.legacy.d.a.a r18 = this.l;
        if (r18 == null) goto L103;
        r18.a();
        goto L103
    L70:
        if (ZeusTransformUtils.instanceOf(r6, r.p.class) == false) goto L73;
        l();
        goto L103
    L73:
        if (ZeusTransformUtils.instanceOf(r6, r.k.class) == false) goto L87;
        com.obric.autoaction.vdplayer.legacy.a.a.g r19 = this.f25969b;
        String r20 = ((r.k) ZeusTransformUtils.preCheckCast(r6, r.k.class, "com.obric.aiagent.plugin")).a();
        IAgentSessionManager.a r21 = this.n;
        if (r21 == null) goto L81;
        ak<com.obric.autogui.vdplayer.api.a.b> r22 = r21.b();
        if (r22 == null) goto L81;
        com.obric.autogui.vdplayer.api.a.b r23 = (com.obric.autogui.vdplayer.api.a.b) ZeusTransformUtils.preCheckCast(r22.c(), com.obric.autogui.vdplayer.api.a.b.class, "com.obric.aiagent.plugin");
        if (r23 == null) goto L81;
        r2 = r23.a();
    L81:
        Object r24 = r19.a(r20, r2, !r(), r8);
        if (r24 != d.c.a.b.a()) goto L85;
        return r24;
    L85:
        return x.f38692a;
    L87:
        if (ZeusTransformUtils.instanceOf(r6, r.b.class) == false) goto L90;
        p();
        goto L103
    L90:
        if (ZeusTransformUtils.instanceOf(r6, r.e.class) == false) goto L93;
        b(((r.e) ZeusTransformUtils.preCheckCast(r6, r.e.class, "com.obric.aiagent.plugin")).a());
        goto L103
    L93:
        if (d.h.b.o.a(r6, r.d.f25947a) == false) goto L96;
        o();
        goto L103
    L96:
        if (d.h.b.o.a(r6, r.l.f25956a) == true) goto L103;
        if (d.h.b.o.a(r6, r.m.f25957a) == false) goto L101;
        a((com.obric.autoaction.vdplayer.legacy.b.a) ZeusTransformUtils.preCheckCast(q.i.f25941a, com.obric.autoaction.vdplayer.legacy.b.a.class, "com.obric.aiagent.plugin"));
        goto L103
    L101:
        throw new d.k();
    L5:
        Loog.INSTANCE.i(TAG, "handleIntent " + r6.getClass().getSimpleName());
        goto L7
    }

    private static final s a(r r10, s r11) {
        d.h.b.o.e(r11, "$this$setState");
        return s.a(r11, null, null, null, null, ((r.h) ZeusTransformUtils.preCheckCast(r10, r.h.class, "com.obric.aiagent.plugin")).a(), null, null, 111, null);
    }

    private final Object a(d.c.d<? super x> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        IAutoActionAgentEventListener.SessionInfo r0 = null;
        if (r() == false) goto L6;
        a((com.obric.autoaction.vdplayer.legacy.b.a) ZeusTransformUtils.preCheckCast(new q.j(d.c.b.a.b.a(ZeusTransformUtils.mapRes(R.string.vd_player_doubao_interaction_disabled, WsChannelMultiProcessSharedProvider.STRING_TYPE, "vd_player_doubao_interaction_disabled")), null, 2, null), com.obric.autoaction.vdplayer.legacy.b.a.class, "com.obric.aiagent.plugin"));
        return x.f38692a;
    L6:
        com.obric.autoaction.vdplayer.legacy.a.a.f r10 = this.f25970c;
        IAgentSessionManager.a r4 = this.n;
        if (r4 == null) goto L13;
        ak<com.obric.autogui.vdplayer.api.a.b> r5 = r4.b();
        if (r5 == null) goto L13;
        com.obric.autogui.vdplayer.api.a.b r1 = (com.obric.autogui.vdplayer.api.a.b) ZeusTransformUtils.preCheckCast(r5.c(), com.obric.autogui.vdplayer.api.a.b.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L13;
        r0 = r1.a();
    L13:
        com.obric.autoaction.vdplayer.legacy.a.a.f.a(r10, null, null, r0, this.p, 3, null);
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
        com.obric.autoaction.vdplayer.legacy.d.j r1 = ((s) ZeusTransformUtils.preCheckCast(b().c(), s.class, "com.obric.aiagent.plugin")).b().c();
        if (d.h.b.o.a(((s) ZeusTransformUtils.preCheckCast(b().c(), s.class, "com.obric.aiagent.plugin")).a(), com.obric.autoaction.vdplayer.legacy.d.n.a.f25924a) == true) goto L5;
    L11:
        if (r0 == false) goto L13;
        a((com.obric.autoaction.vdplayer.legacy.b.b) ZeusTransformUtils.preCheckCast(r.c.f25946a, com.obric.autoaction.vdplayer.legacy.b.b.class, "com.obric.aiagent.plugin"));
        return;
    L13:
        int r2 = b.f25973a[r1.ordinal()];
        if (r2 != 1) goto L16;
        a($$Lambda$u$Z9fRuhAH8OtwLMXaCctNZWyU8qw.INSTANCE);
        return;
    L16:
        if (r2 != 2) goto L18;
        a($$Lambda$u$cJBRAjQR5uEAIv47aEg492jogpk.INSTANCE);
        return;
    L18:
        if (r2 != 3) goto L23;
        if (d.h.b.o.a(((s) ZeusTransformUtils.preCheckCast(b().c(), s.class, "com.obric.aiagent.plugin")).a(), com.obric.autoaction.vdplayer.legacy.d.n.a.f25924a) == true) goto L28;
        a((com.obric.autoaction.vdplayer.legacy.b.a) ZeusTransformUtils.preCheckCast(q.h.f25940a, com.obric.autoaction.vdplayer.legacy.b.a.class, "com.obric.aiagent.plugin"));
        return;
    L28:
        return;
    L23:
        throw new d.k();
    L5:
        if (r1 == com.obric.autoaction.vdplayer.legacy.d.j.f25906c) goto L9;
        if (r1 != com.obric.autoaction.vdplayer.legacy.d.j.f25904a) goto L11;
    L9:
        if (AutoActionConfigs.INSTANCE.getBooleanCfg("vlm.common.enable_operate_panel_outside_click_dismiss", true) == false) goto L11;
        a((com.obric.autoaction.vdplayer.legacy.b.b) ZeusTransformUtils.preCheckCast(new r.e(true), com.obric.autoaction.vdplayer.legacy.b.b.class, "com.obric.aiagent.plugin"));
        goto L11
    }

    private static final s a(s r11) {
        d.h.b.o.e(r11, "$this$setState");
        return s.a(r11, null, com.obric.autoaction.vdplayer.legacy.d.k.a(r11.b(), null, null, com.obric.autoaction.vdplayer.legacy.d.j.f25905b, null, null, false, 59, null), null, null, false, null, null, 125, null);
    }

    private static final s b(s r11) {
        d.h.b.o.e(r11, "$this$setState");
        return s.a(r11, null, com.obric.autoaction.vdplayer.legacy.d.k.a(r11.b(), null, null, com.obric.autoaction.vdplayer.legacy.d.j.f25904a, null, null, false, 59, null), null, null, false, null, null, 125, null);
    }

    private final boolean m() {
        IAgentSessionManager.a r0 = this.i.a();
        if (r0 != null) goto L6;
        a((com.obric.autoaction.vdplayer.legacy.b.a) ZeusTransformUtils.preCheckCast(new q.j(Integer.valueOf(ZeusTransformUtils.mapRes(R.string.obric_vd_no_task, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_vd_no_task")), null, 2, null), com.obric.autoaction.vdplayer.legacy.b.a.class, "com.obric.aiagent.plugin"));
        a((com.obric.autoaction.vdplayer.legacy.b.a) ZeusTransformUtils.preCheckCast(q.a.f25933a, com.obric.autoaction.vdplayer.legacy.b.a.class, "com.obric.aiagent.plugin"));
        return false;
    L6:
        this.n = r0;
        return true;
    }

    private final void a(final com.obric.autogui.vdplayer.api.a.a r3) {
        a(new $$Lambda$u$s3guQVL68nJs4fwAnWioNEk0(r3));
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autogui.vdplayer.api.a.a.c.class) == false) goto L6;
        a((com.obric.autoaction.vdplayer.legacy.b.a) ZeusTransformUtils.preCheckCast(q.c.f25935a, com.obric.autoaction.vdplayer.legacy.b.a.class, "com.obric.aiagent.plugin"));
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autogui.vdplayer.api.a.a.C0870a.class) == false) goto L9;
        a((com.obric.autoaction.vdplayer.legacy.b.a) ZeusTransformUtils.preCheckCast(q.c.f25935a, com.obric.autoaction.vdplayer.legacy.b.a.class, "com.obric.aiagent.plugin"));
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autogui.vdplayer.api.a.a.b.class) == false) goto L12;
        a((com.obric.autoaction.vdplayer.legacy.b.a) ZeusTransformUtils.preCheckCast(q.c.f25935a, com.obric.autoaction.vdplayer.legacy.b.a.class, "com.obric.aiagent.plugin"));
        return;
    L12:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autogui.vdplayer.api.a.a.d.class) == false) goto L15;
        a((com.obric.autogui.vdplayer.api.a.a.d) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.vdplayer.api.a.a.d.class, "com.obric.aiagent.plugin"));
        a((com.obric.autoaction.vdplayer.legacy.b.a) ZeusTransformUtils.preCheckCast(q.c.f25935a, com.obric.autoaction.vdplayer.legacy.b.a.class, "com.obric.aiagent.plugin"));
        return;
    L15:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autogui.vdplayer.api.a.a.f.class) == false) goto L20;
        com.obric.autoaction.vdplayer.legacy.d.a.a r2 = this.l;
        if (r2 == null) goto L27;
        Loog.INSTANCE.i(TAG, "there is a existing count down timer");
        r2.b();
        return;
    L27:
        return;
    L20:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autogui.vdplayer.api.a.a.e.class) == false) goto L23;
        return;
    L23:
        throw new d.k();
    }

    private static final s a(com.obric.autogui.vdplayer.api.a.a r1, s r2) {
        d.h.b.o.e(r2, "$this$setState");
        return p.f25931a.a(r2, r1);
    }

    private final com.obric.autoaction.vdplayer.legacy.d.d a(com.obric.autogui.vdplayer.api.a.b r1) {
        return new com.obric.autoaction.vdplayer.legacy.d.d(r1.c());
    }

    private final void a(final com.obric.autoaction.vdplayer.legacy.d.d r2) {
        a(new $$Lambda$u$IZPYImLkuGcL56BiRd4u4FhENiQ(r2));
    }

    private static final s a(com.obric.autoaction.vdplayer.legacy.d.d r12, s r13) {
        d.h.b.o.e(r13, "$this$setState");
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r12.a(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r14, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r15 = r14.iterator();
    L4:
        if (r15.hasNext() == false) goto L6;
        IAutoActionAgentEventListener.OperatingAppInfo r2 = (IAutoActionAgentEventListener.OperatingAppInfo) ZeusTransformUtils.preCheckCast(r15.next(), IAutoActionAgentEventListener.OperatingAppInfo.class, "com.obric.aiagent.plugin");
        r0.add(new com.obric.autoaction.vdplayer.legacy.d.h(false, r2.getAppLabel().toString(), r2.getPackageName(), 1, null));
        goto L4
    L6:
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        List r6 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Iterator r17 = r16.iterator();
    L8:
        if (r17.hasNext() == false) goto L12;
        com.obric.autoaction.vdplayer.legacy.d.h r1 = (com.obric.autoaction.vdplayer.legacy.d.h) ZeusTransformUtils.preCheckCast(r17.next(), com.obric.autoaction.vdplayer.legacy.d.h.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(d.a.p.n(r6), r1) == true) goto L8;
        r6.add(r1);
        goto L8
    L12:
        com.obric.autoaction.vdplayer.legacy.d.h r18 = (com.obric.autoaction.vdplayer.legacy.d.h) ZeusTransformUtils.preCheckCast(d.a.p.n(r6), com.obric.autoaction.vdplayer.legacy.d.h.class, "com.obric.aiagent.plugin");
        if (r18 == null) goto L16;
        com.obric.autoaction.vdplayer.legacy.d.h r19 = com.obric.autoaction.vdplayer.legacy.d.h.a(r13.c(), false, r18.b(), r18.c(), 1, null);
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
        a((com.obric.autoaction.vdplayer.legacy.b.a) ZeusTransformUtils.preCheckCast(new q.b(r8), com.obric.autoaction.vdplayer.legacy.b.a.class, "com.obric.aiagent.plugin"));
        return;
    L13:
        r8 = null;
        goto L14
    L15:
        a((com.obric.autoaction.vdplayer.legacy.b.a) ZeusTransformUtils.preCheckCast(q.a.f25933a, com.obric.autoaction.vdplayer.legacy.b.a.class, "com.obric.aiagent.plugin"));
    }

    private final IFeedbackApi.a n() {
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

    private final void o() {
        if (r() == false) goto L6;
        a((com.obric.autoaction.vdplayer.legacy.b.a) ZeusTransformUtils.preCheckCast(new q.j(Integer.valueOf(ZeusTransformUtils.mapRes(R.string.vd_player_doubao_interaction_disabled, WsChannelMultiProcessSharedProvider.STRING_TYPE, "vd_player_doubao_interaction_disabled")), null, 2, null), com.obric.autoaction.vdplayer.legacy.b.a.class, "com.obric.aiagent.plugin"));
        return;
    L6:
        IFeedbackApi.a r0 = n();
        if (r0 == null) goto L10;
        a((com.obric.autoaction.vdplayer.legacy.b.a) ZeusTransformUtils.preCheckCast(new q.d(r0), com.obric.autoaction.vdplayer.legacy.b.a.class, "com.obric.aiagent.plugin"));
        return;
    }

    private final void p() {
        if (q() == false) goto L6;
        return;
    L6:
        if (this.f25971d.a() == true) goto L9;
        a((com.obric.autoaction.vdplayer.legacy.b.a) ZeusTransformUtils.preCheckCast(new q.j(Integer.valueOf(ZeusTransformUtils.mapRes(R.string.obric_vd_player_cant_handle_take_over, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_vd_player_cant_handle_take_over")), null, 2, null), com.obric.autoaction.vdplayer.legacy.b.a.class, "com.obric.aiagent.plugin"));
        return;
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
        com.obric.autoaction.vdplayer.legacy.c.b.f25682a.a(r8, r5);
        return;
    L13:
        r3 = null;
    L9:
        r8 = null;
        goto L10
    }

    private final Object b(d.c.d<? super x> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, d.class) == false) goto L7;
        d r0 = (d) ZeusTransformUtils.preCheckCast(r8, d.class, "com.obric.aiagent.plugin");
        if ((r0.f25983d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f25983d -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.f25981b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f25983d;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        u this = (u) ZeusTransformUtils.preCheckCast(r0.f25980a, u.class, "com.obric.aiagent.plugin");
        d.o.a(r9);
    L21:
        int r10 = b.f25974b[((com.obric.autoaction.vdplayer.legacy.a.a.a.EnumC0631a) ZeusTransformUtils.preCheckCast(r9, com.obric.autoaction.vdplayer.legacy.a.a.a.EnumC0631a.class, "com.obric.aiagent.plugin")).ordinal()];
        if (r10 != 1) goto L24;
        this.a($$Lambda$u$47H4HHf5rOhjOqhTDyl9v5jqXw.INSTANCE);
    L33:
        return x.f38692a;
    L24:
        if (r10 != 2) goto L26;
        this.a((com.obric.autoaction.vdplayer.legacy.b.a) ZeusTransformUtils.preCheckCast(new q.j(d.c.b.a.b.a(ZeusTransformUtils.mapRes(R.string.obric_vd_player_cant_handle_take_over, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_vd_player_cant_handle_take_over")), null, 2, null), com.obric.autoaction.vdplayer.legacy.b.a.class, "com.obric.aiagent.plugin"));
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
        com.obric.autoaction.vdplayer.legacy.a.a.a r11 = this.f25972e;
        r0.f25980a = this;
        r0.f25983d = 1;
        r9 = r11.a(r0);
        if (r9 != r2) goto L21;
        return r2;
    L17:
        return x.f38692a;
    L7:
        r0 = new d(this, r8);
        goto L8
    }

    private static final s c(s r11) {
        d.h.b.o.e(r11, "$this$setState");
        return s.a(r11, null, null, null, null, false, com.obric.autoaction.vdplayer.legacy.d.o.f25927b, null, 95, null);
    }

    private final boolean q() {
        if (r() == true) goto L6;
        return false;
    L6:
        a((com.obric.autoaction.vdplayer.legacy.b.a) ZeusTransformUtils.preCheckCast(new q.j(Integer.valueOf(ZeusTransformUtils.mapRes(R.string.vd_player_doubao_takeover_disabled, WsChannelMultiProcessSharedProvider.STRING_TYPE, "vd_player_doubao_takeover_disabled")), null, 2, null), com.obric.autoaction.vdplayer.legacy.b.a.class, "com.obric.aiagent.plugin"));
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

    private final void d(final boolean r14) {
        if (this.l == null) goto L8;
        Loog.INSTANCE.e(TAG, "there is a existing count down timer");
        com.obric.autoaction.vdplayer.legacy.d.a.a r0 = this.l;
        if (r0 == null) goto L7;
        r0.b();
    L7:
        this.l = null;
    L8:
        Loog.INSTANCE.i(TAG, "launch count down timer");
        com.obric.autoaction.vdplayer.legacy.d.a.a r1 = new com.obric.autoaction.vdplayer.legacy.d.a.a(androidx.lifecycle.ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")), new $$Lambda$u$vIwRWpf62d6aYQ2EVAvgVmLb2k(this), new $$Lambda$u$aeuPadhqp6QFRndBUvLQX2ztH7I(this, r14), 0, 0, 24, null);
        this.l = r1;
        if (r1 == null) goto L12;
        r1.a();
        return;
    }

    private static final x a(u r1, final long r2) {
        r1.a(new $$Lambda$u$MHGK60I9ufIHT9sXpseYqupLOJs(r2));
        return x.f38692a;
    }

    private static final s a(long r11, s r13) {
        d.h.b.o.e(r13, "$this$setState");
        return s.a(r13, null, com.obric.autoaction.vdplayer.legacy.d.k.a(r13.b(), null, null, null, Long.valueOf(r11), null, false, 55, null), null, null, false, null, null, 125, null);
    }

    private static final x d(u r9, boolean r10) {
        Loog.INSTANCE.i(TAG, "count down timer finish, exit user operating");
        r9.l = null;
        r9.a($$Lambda$u$8_AJ_oYS4jRHgybtfeNbuk7d0.INSTANCE);
        kotlinx.coroutines.i.a(androidx.lifecycle.ak.a((aj) ZeusTransformUtils.preCheckCast(r9, aj.class, "com.obric.aiagent.plugin")), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new g(r9, r10, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return x.f38692a;
    }

    private static final s d(s r11) {
        d.h.b.o.e(r11, "$this$setState");
        return s.a(r11, null, com.obric.autoaction.vdplayer.legacy.d.k.a(r11.b(), null, null, null, null, null, false, 55, null), null, null, false, null, null, 125, null);
    }

    private final void s() {
        if (this.m == null) goto L9;
        Loog.INSTANCE.e(TAG, "there is a existing auto exit count down timer");
        com.obric.autoaction.vdplayer.legacy.d.a.a r0 = this.m;
        if (r0 == null) goto L7;
        r0.b();
    L7:
        this.m = null;
    L9:
        if (com.obric.autogui.common.a.d.f28974a.K() > 0) goto L12;
        Loog.INSTANCE.i(TAG, "auto exit count down millis is 0, skip");
        a($$Lambda$u$BouXPUzsSWBPL9En_Zc3vZdIhnc.INSTANCE);
        return;
    L12:
        Loog.INSTANCE.i(TAG, "launch auto exit count down timer");
        com.obric.autoaction.vdplayer.legacy.d.a.a r1 = new com.obric.autoaction.vdplayer.legacy.d.a.a(androidx.lifecycle.ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")), new $$Lambda$u$uO3LF8qiiNT2UHxFE9Ad4OY6YU(this), new $$Lambda$u$nMEJT1VTYB3aYs952cU1or8NVbc(this), com.obric.autogui.common.a.d.f28974a.K(), 0, 16, null);
        this.m = r1;
        if (r1 == null) goto L16;
        r1.a();
        return;
    }

    private static final s e(s r11) {
        d.h.b.o.e(r11, "$this$setState");
        return s.a(r11, null, com.obric.autoaction.vdplayer.legacy.d.k.a(r11.b(), null, null, null, null, -1L, false, 47, null), null, null, false, null, null, 125, null);
    }

    private static final x b(u r1, final long r2) {
        r1.a(new $$Lambda$u$iBxKtUy_RhavGbp9muKqTO1rUg(r2));
        return x.f38692a;
    }

    private static final s b(long r11, s r13) {
        d.h.b.o.e(r13, "$this$setState");
        return s.a(r13, null, com.obric.autoaction.vdplayer.legacy.d.k.a(r13.b(), null, null, null, null, Long.valueOf(r11), false, 47, null), null, null, false, null, null, 125, null);
    }

    private static final x i(u r9) {
        Loog.INSTANCE.i(TAG, "count down timer finish, exit user operating");
        r9.m = null;
        r9.a($$Lambda$u$zAKUmDgcCRCi9CKJTD8ico66eJ4.INSTANCE);
        kotlinx.coroutines.i.a(androidx.lifecycle.ak.a((aj) ZeusTransformUtils.preCheckCast(r9, aj.class, "com.obric.aiagent.plugin")), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new f(r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return x.f38692a;
    }

    private static final s f(s r11) {
        d.h.b.o.e(r11, "$this$setState");
        return s.a(r11, null, com.obric.autoaction.vdplayer.legacy.d.k.a(r11.b(), null, null, null, null, null, false, 47, null), null, null, false, null, null, 125, null);
    }

    private final Object a(boolean r8, d.c.d<? super x> r9) {
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, c.class) == false) goto L7;
        c r1 = (c) ZeusTransformUtils.preCheckCast(r10, c.class, "com.obric.aiagent.plugin");
        if ((r1.f25979e & Integer.MIN_VALUE) == 0) goto L7;
        r1.f25979e -= Integer.MIN_VALUE;
    L8:
        Object r11 = r1.f25977c;
        Object r3 = d.c.a.b.a();
        int r4 = r1.f25979e;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        r8 = r1.f25976b;
        u this = (u) ZeusTransformUtils.preCheckCast(r1.f25975a, u.class, "com.obric.aiagent.plugin");
        d.o.a(r11);
    L25:
        boolean r12 = ((Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L26:
        if (r12 == false) goto L28;
        this.a($$Lambda$u$5zSFuvPI7JqsAbBKWdelarWsNMw.INSTANCE);
    L30:
        return x.f38692a;
    L28:
        Loog.INSTANCE.i(TAG, "ExitUserOperating failed, isCallUser=" + r8);
        goto L30
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r8 = r1.f25976b;
        this = (u) ZeusTransformUtils.preCheckCast(r1.f25975a, u.class, "com.obric.aiagent.plugin");
        d.o.a(r11);
    L21:
        r12 = ((Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        goto L26
    L16:
        d.o.a(r11);
        if (r8 == false) goto L22;
        com.obric.autoaction.vdplayer.legacy.a.a.c r13 = this.f;
        r1.f25975a = this;
        r1.f25976b = r8;
        r1.f25979e = 1;
        r11 = r13.a(r1);
        if (r11 != r3) goto L21;
        return r3;
    L22:
        com.obric.autoaction.vdplayer.legacy.a.a.d r14 = this.g;
        r1.f25975a = this;
        r1.f25976b = r8;
        r1.f25979e = 2;
        r11 = r14.a(r1);
        if (r11 != r3) goto L25;
        return r3;
    L7:
        r1 = new c(this, r10);
        goto L8
    }

    private static final s g(s r11) {
        d.h.b.o.e(r11, "$this$setState");
        return s.a(r11, null, null, null, null, false, com.obric.autoaction.vdplayer.legacy.d.o.f25926a, null, 95, null);
    }

    private final void a(com.obric.autogui.vdplayer.api.a.a.d r10) {
        a((com.obric.autoaction.vdplayer.legacy.b.a) ZeusTransformUtils.preCheckCast(q.f.f25938a, com.obric.autoaction.vdplayer.legacy.b.a.class, "com.obric.aiagent.plugin"));
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
        a((com.obric.autoaction.vdplayer.legacy.b.a) ZeusTransformUtils.preCheckCast(q.a.f25933a, com.obric.autoaction.vdplayer.legacy.b.a.class, "com.obric.aiagent.plugin"));
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
        com.obric.autoaction.vdplayer.legacy.a.a.e r0 = this.k;
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
        q = new d.m(r4, b().c());
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
