package com.obric.autogui.session.d;

import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.computercontrol.CCLifecycleListener;
import com.obric.autogui.common.api.presentation.AOUserInterfaceTools;
import com.obric.autogui.common.api.presentation.AutoActionUIContext;
import com.obric.autogui.common.api.presentation.GlobalUIContext;
import com.obric.autogui.common.api.presentation.IAutoActionPresentationApi;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.obric.autogui.common.api.space.DisplayOperatingSpace;
import com.obric.autogui.common.api.space.IOperatingSpaceManager;
import com.obric.autogui.common.api.space.OperatingSpaceManager;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.n;
import d.o;
import d.x;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: VDSpacePreloader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m extends com.obric.autogui.session.d.a<com.obric.autogui.common.e> {
    private static final String TAG = "VDSpacePreloader";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f30933b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.autogui.session.a f30934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.obric.autogui.session.d.g<AOOperatingSpace> f30935d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f30936e;
    private final com.obric.autogui.session.d.c<com.obric.autogui.common.e> f;

    /* JADX INFO: compiled from: VDSpacePreloader.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: VDSpacePreloader.kt */
    @d.c.b.a.f(b = "VDSpacePreloader.kt", c = {121}, d = "destroyInvalidActiveSpaceBeforeCreate", e = "com.obric.autogui.session.preload.VDSpacePreloader")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f30937a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f30938b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ m f30939c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f30940d;

        b(m r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30939c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f30938b = r3;
            this.f30940d |= Integer.MIN_VALUE;
            return m.b(this.f30939c, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: VDSpacePreloader.kt */
    @d.c.b.a.f(b = "VDSpacePreloader.kt", c = {189}, d = "destroySpace", e = "com.obric.autogui.session.preload.VDSpacePreloader")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f30941a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ m f30942b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f30943c;

        c(m r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30942b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f30941a = r3;
            this.f30943c |= Integer.MIN_VALUE;
            return m.a(this.f30942b, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: VDSpacePreloader.kt */
    @d.c.b.a.f(b = "VDSpacePreloader.kt", c = {152}, d = "invokeSuspend", e = "com.obric.autogui.session.preload.VDSpacePreloader$destroySpaceIfOwned$1")
    static final class d extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super n<? extends x>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f30944a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ m f30945b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AOOperatingSpace f30946c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f30947d;

        d(m r3, AOOperatingSpace r4, d.c.d<? super d> r5) {
            AOOperatingSpace r6 = (AOOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r4, AOOperatingSpace.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30945b = r3;
            this.f30946c = r6;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super n<x>> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            d r0 = new d(this.f30945b, this.f30946c, r6);
            r0.f30947d = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super n<? extends x>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f30944a;
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            o.a(r5);     // Catch: Throwable -> L15
        L13:
            Object r6 = n.f(x.f38692a);     // Catch: Throwable -> L15
        L17:
            AOOperatingSpace r4 = this.f30946c;
            Throwable r2 = n.c(r6);
            if (r2 == null) goto L21;
            Loog.INSTANCE.e(m.TAG, "destroy space on dispose failed, spaceId=" + r4.getSpaceId(), r2);
        L21:
            return n.g(r6);
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            o.a(r5);
            am r7 = (am) ZeusTransformUtils.preCheckCast(this.f30947d, am.class, "com.obric.aiagent.plugin");
            m r8 = this.f30945b;
            AOOperatingSpace r3 = this.f30946c;
            n.a r9 = n.f38560a;     // Catch: Throwable -> L15
            this.f30944a = 1;     // Catch: Throwable -> L15
            if (m.a(r8, r3, this) != r0) goto L13;
            return r0;
        L15:
            th = move-exception;
            n.a r10 = n.f38560a;
            r6 = n.f(o.a(th));
            goto L17
        }
    }

    /* JADX INFO: compiled from: VDSpacePreloader.kt */
    @d.c.b.a.f(b = "VDSpacePreloader.kt", c = {62}, d = MonitorConstants.CONNECT_TYPE_GET, e = "com.obric.autogui.session.preload.VDSpacePreloader")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f30948a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f30949b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ m f30950c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f30951d;

        e(m r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30950c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f30949b = r3;
            this.f30951d |= Integer.MIN_VALUE;
            return this.f30950c.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: VDSpacePreloader.kt */
    @d.c.b.a.f(b = "VDSpacePreloader.kt", c = {197}, d = "invokeSuspend", e = "com.obric.autogui.session.preload.VDSpacePreloader$observeVDVisible$1")
    static final class f extends d.c.b.a.l implements d.h.a.b<d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f30952a;

        /* JADX INFO: compiled from: SafeCollector.common.kt */
        public static final class a implements kotlinx.coroutines.b.h<IAutoActionPresentationApi.PlayerVisibility> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.b.h f30954a;

            /* JADX INFO: renamed from: com.obric.autogui.session.d.m$f$a$1, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            public static final class AnonymousClass1<T> implements kotlinx.coroutines.b.i {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ kotlinx.coroutines.b.i f30955a;

                /* JADX INFO: renamed from: com.obric.autogui.session.d.m$f$a$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @d.c.b.a.f(b = "VDSpacePreloader.kt", c = {219}, d = "emit", e = "com.obric.autogui.session.preload.VDSpacePreloader$observeVDVisible$1$invokeSuspend$$inlined$map$1$2")
                public static final class C08431 extends d.c.b.a.d {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f30956a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f30957b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    final /* synthetic */ AnonymousClass1 f30958c;

                    public C08431(AnonymousClass1 r3, d.c.d r4) {
                        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                        this.f30958c = r3;
                        super(r5);
                    }

                    @Override // d.c.b.a.a
                    public final Object invokeSuspend(Object r3) {
                        this.f30956a = r3;
                        this.f30957b |= Integer.MIN_VALUE;
                        return this.f30958c.emit(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
                    }
                }

                public AnonymousClass1(kotlinx.coroutines.b.i r3) {
                    this.f30955a = (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
                }

                @Override // kotlinx.coroutines.b.i
                public final Object emit(Object r6, d.c.d r7) {
                    d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                    if (ZeusTransformUtils.instanceOf(r8, C08431.class) == false) goto L7;
                    C08431 r0 = (C08431) ZeusTransformUtils.preCheckCast(r8, C08431.class, "com.obric.aiagent.plugin");
                    if ((r0.f30957b & Integer.MIN_VALUE) == 0) goto L7;
                    r0.f30957b -= Integer.MIN_VALUE;
                L8:
                    Object r9 = r0.f30956a;
                    Object r2 = d.c.a.b.a();
                    int r3 = r0.f30957b;
                    if (r3 == 0) goto L14;
                    if (r3 != 1) goto L13;
                    o.a(r9);
                L18:
                    return x.f38692a;
                L13:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L14:
                    o.a(r9);
                    kotlinx.coroutines.b.i r5 = this.f30955a;
                    d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
                    IAutoActionPresentationApi.PlayerVisibility r11 = ((GlobalUIContext) ZeusTransformUtils.preCheckCast(r6, GlobalUIContext.class, "com.obric.aiagent.plugin")).getPlayer().getVisible();
                    r0.f30957b = 1;
                    if (r5.emit(r11, r0) != r2) goto L18;
                    return r2;
                L7:
                    r0 = new C08431(this, r8);
                    goto L8
                }
            }

            public a(kotlinx.coroutines.b.h r3) {
                this.f30954a = (kotlinx.coroutines.b.h) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
            }

            @Override // kotlinx.coroutines.b.h
            public Object collect(kotlinx.coroutines.b.i<? super IAutoActionPresentationApi.PlayerVisibility> r3, d.c.d r4) {
                kotlinx.coroutines.b.i r5 = (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
                d.c.d<? super x> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                Object r2 = this.f30954a.collect((kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin"), r6);
                if (r2 != d.c.a.b.a()) goto L6;
                return r2;
            L6:
                return x.f38692a;
            }
        }

        f(d.c.d<? super f> r3) {
            super(1, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(d.c.d<? super x> r3) {
            return ((f) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f30952a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            kotlinx.coroutines.b.h r7 = kotlinx.coroutines.b.j.b((kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(new a((kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(AutoActionUIContext.INSTANCE.getState(), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin")), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin"));
            kotlinx.coroutines.b.i r2 = (kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(AnonymousClass1.f30953a, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
            d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30952a = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: VDSpacePreloader.kt */
    @d.c.b.a.f(b = "VDSpacePreloader.kt", c = {74, 79}, d = "performCreateSpace", e = "com.obric.autogui.session.preload.VDSpacePreloader")
    static final class g extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f30959a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f30960b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ m f30961c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f30962d;

        g(m r3, d.c.d<? super g> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30961c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f30960b = r3;
            this.f30962d |= Integer.MIN_VALUE;
            return m.a(this.f30961c, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: VDSpacePreloader.kt */
    /* synthetic */ class h extends d.h.b.l implements d.h.a.b<d.c.d<? super com.obric.autogui.common.e>, Object> {
        h(Object r8) {
            super(1, r8, m.class, "performCreateSpace", "performCreateSpace(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        public final Object a(d.c.d<? super com.obric.autogui.common.e> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return m.a((m) ZeusTransformUtils.preCheckCast(this.receiver, m.class, "com.obric.aiagent.plugin"), r4);
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super com.obric.autogui.common.e> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: VDSpacePreloader.kt */
    /* synthetic */ class i extends d.h.b.l implements d.h.a.b<com.obric.autogui.common.e, x> {
        i(Object r8) {
            super(1, r8, m.class, "destroySpaceIfOwned", "destroySpaceIfOwned(Lcom/obric/autogui/common/StatusMessage;)V", 0);
        }

        public final void a(com.obric.autogui.common.e r3) {
            d.h.b.o.e(r3, "p0");
            m.a((m) ZeusTransformUtils.preCheckCast(this.receiver, m.class, "com.obric.aiagent.plugin"), r3);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.autogui.common.e r3) {
            a((com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }
    }

    static {
        f30933b = new a(null);
    }

    /* JADX INFO: renamed from: lambda$g9ta8mp-lklo1HFHW6pa4gzN2sI, reason: not valid java name */
    public static /* synthetic */ boolean m890lambda$g9ta8mplklo1HFHW6pa4gzN2sI() {
        return l();
    }

    public static /* synthetic */ com.obric.autogui.common.e lambda$lplI9Qu9HPYUn1DB7EljJPaxjCE() {
        return k();
    }

    public static final /* synthetic */ Object a(m r2, AOOperatingSpace r3, d.c.d r4) {
        return r2.a((AOOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r3, AOOperatingSpace.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(m r2, d.c.d r3) {
        return r2.b((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(m r0, com.obric.autogui.common.e r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ Object b(m r2, d.c.d r3) {
        return r2.c((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public m(com.obric.autogui.session.a r10) {
        d.h.b.o.e(r10, SensitiveType.SESSION);
        super(null, 1, null);
        this.f30934c = r10;
        this.f30935d = new com.obric.autogui.session.d.g();
        this.f30936e = new AtomicBoolean(false);
        d.m.e r11 = (d.m.e) ZeusTransformUtils.preCheckCast(new h(this), d.m.e.class, "com.obric.aiagent.plugin");
        d.m.e r0 = (d.m.e) ZeusTransformUtils.preCheckCast(new i(this), d.m.e.class, "com.obric.aiagent.plugin");
        this.f = new com.obric.autogui.session.d.c(TAG, (d.h.a.b) ZeusTransformUtils.preCheckCast(r11, d.h.a.b.class, "com.obric.aiagent.plugin"), $$Lambda$m$lplI9Qu9HPYUn1DB7EljJPaxjCE.INSTANCE, $$Lambda$m$g9ta8mplklo1HFHW6pa4gzN2sI.INSTANCE, (d.h.a.b) ZeusTransformUtils.preCheckCast(r0, d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.session.d.a
    public com.obric.autogui.session.d.c<com.obric.autogui.common.e> a() {
        return this.f;
    }

    private static final boolean l() {
        return com.obric.autogui.common.a.d.f28974a.q();
    }

    private static final com.obric.autogui.common.e k() {
        return com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_operating_space_creation_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_operating_space_creation_failed"), null, 2, null);
    }

    public final void f() {
        this.f30936e.set(true);
    }

    public final boolean g() {
        if (this.f30936e.get() == true) goto L14;
        AOOperatingSpace r4 = (AOOperatingSpace) ZeusTransformUtils.preCheckCast(this.f30935d.a(), AOOperatingSpace.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L7;
    L9:
        boolean r5 = false;
    L10:
        if (r5 == false) goto L13;
        return true;
    L13:
        return false;
    L7:
        if (r4.isValid() == true) goto L9;
        r5 = true;
        goto L10
    L14:
        return true;
    }

    @Override // com.obric.autogui.session.d.a
    public Object a(d.c.d<? super com.obric.autogui.common.e> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, e.class) == false) goto L7;
        e r0 = (e) ZeusTransformUtils.preCheckCast(r7, e.class, "com.obric.aiagent.plugin");
        if ((r0.f30951d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f30951d -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.f30949b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f30951d;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        m this = (m) ZeusTransformUtils.preCheckCast(r0.f30948a, m.class, "com.obric.aiagent.plugin");
        o.a(r8);
    L21:
        com.obric.autogui.common.e r9 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r8, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
        if (this.g() == true) goto L24;
        return r9;
    L24:
        return (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(this.a().c().invoke(), com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r8);
        if (g() == true) goto L17;
        r0.f30948a = this;
        r0.f30951d = 1;
        r8 = super.a(r0);
        if (r8 != r2) goto L21;
        return r2;
    L17:
        return a().c().invoke();
    L7:
        r0 = new e(this, r7);
        goto L8
    }

    private final Object b(d.c.d<? super com.obric.autogui.common.e> r13) {
        d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, g.class) == false) goto L7;
        g r1 = (g) ZeusTransformUtils.preCheckCast(r14, g.class, "com.obric.aiagent.plugin");
        if ((r1.f30962d & Integer.MIN_VALUE) == 0) goto L7;
        r1.f30962d -= Integer.MIN_VALUE;
    L8:
        Object r15 = r1.f30960b;
        Object r3 = d.c.a.b.a();
        int r4 = r1.f30962d;
        boolean r8 = true;
        if (r4 == 0) goto L22;
        if (r4 == 1) goto L21;
        if (r4 != 2) goto L20;
        m this = (m) ZeusTransformUtils.preCheckCast(r1.f30959a, m.class, "com.obric.aiagent.plugin");
        o.a(r15);     // Catch: Exception -> L15 CancellationException -> L17
    L36:
        IOperatingSpaceManager.OpSpaceCreationResult r16 = (IOperatingSpaceManager.OpSpaceCreationResult) ZeusTransformUtils.preCheckCast(r15, IOperatingSpaceManager.OpSpaceCreationResult.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L15 CancellationException -> L17
        AOOperatingSpace r0 = r16.getSpace();
        if (r16.getStatus() != IOperatingSpaceManager.OpSpaceCreationResult.Status.Success) goto L43;
        if (r0 == null) goto L43;
        this.f30935d.a(r0);
        this.f30934c.a(r0);
        this.b(com.obric.autogui.common.e.f29014b.a());
        return com.obric.autogui.common.e.f29014b.a();
    L43:
        Loog r12 = Loog.INSTANCE;
        StringBuilder r17 = new StringBuilder().append("Failed to create Space, status=").append(r16.getStatus()).append(", hasSpace=");
        if (r0 != null) goto L47;
        r8 = false;
    L47:
        r12.e(TAG, r17.append(r8).toString());
        return com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_operating_space_creation_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_operating_space_creation_failed"), null, 2, null);
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L21:
        this = (m) ZeusTransformUtils.preCheckCast(r1.f30959a, m.class, "com.obric.aiagent.plugin");
        o.a(r15);
    L30:
        if (this.g() == true) goto L32;
        OperatingSpaceManager r18 = OperatingSpaceManager.INSTANCE;     // Catch: Exception -> L15 CancellationException -> L17
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f30934c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L15 CancellationException -> L17
        CCLifecycleListener r5 = (CCLifecycleListener) ZeusTransformUtils.preCheckCast(this.f30934c.o(), CCLifecycleListener.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L15 CancellationException -> L17
        r1.f30959a = this;     // Catch: Exception -> L15 CancellationException -> L17
        r1.f30962d = 2;     // Catch: Exception -> L15 CancellationException -> L17
        r15 = r18.createSpace(r2, r5, r1);     // Catch: Exception -> L15 CancellationException -> L17
        if (r15 != r3) goto L36;
        return r3;
    L32:
        return this.a().c().invoke();
    L22:
        o.a(r15);
        if (g() == true) goto L25;
        r1.f30959a = this;
        r1.f30962d = 1;
        if (c(r1) != r3) goto L30;
        return r3;
    L25:
        return a().c().invoke();
    L17:
        e = move-exception;
        throw e;
    L15:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "Failed to create Space. e=" + e, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_operating_space_creation_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_operating_space_creation_failed"), null, 2, null);
    L7:
        r1 = new g(this, r14);
        goto L8
    }

    private final Object c(d.c.d<? super x> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r11, b.class, "com.obric.aiagent.plugin");
        if ((r0.f30940d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f30940d -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.f30938b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f30940d;
        if (r3 == 0) goto L20;
        if (r3 != 1) goto L19;
        AOOperatingSpace r9 = (AOOperatingSpace) ZeusTransformUtils.preCheckCast(r0.f30937a, AOOperatingSpace.class, "com.obric.aiagent.plugin");
        o.a(r12);     // Catch: Exception -> L14 CancellationException -> L16
    L38:
    L36:
        return x.f38692a;
    L14:
        Exception e2 = e;
    L34:
        Loog.INSTANCE.e(TAG, "destroy invalid active space before create failed, spaceId=" + r9.getSpaceId(), (Throwable) ZeusTransformUtils.preCheckCast(e2, Throwable.class, "com.obric.aiagent.plugin"));
        goto L36
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        o.a(r12);
        AOOperatingSpace r13 = OperatingSpaceManager.INSTANCE.getActiveSpace();
        if (r13 != null) goto L25;
        return x.f38692a;
    L25:
        if (r13.isValid() == true) goto L27;
        Loog.INSTANCE.w(TAG, "destroy invalid active space before create, spaceId=" + r13.getSpaceId());
        OperatingSpaceManager r4 = OperatingSpaceManager.INSTANCE;     // Catch: CancellationException -> L16 Exception -> L32
        Context r14 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f30934c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: CancellationException -> L16 Exception -> L32
        r0.f30937a = r13;     // Catch: CancellationException -> L16 Exception -> L32
        r0.f30940d = 1;     // Catch: CancellationException -> L16 Exception -> L32
        if (r4.destroySpace(r14, r13, r0) != r2) goto L38;
        return r2;
    L32:
        e = move-exception;
        e2 = e;
        r9 = r13;
        goto L34
    L27:
        return x.f38692a;
    L16:
        e = move-exception;
        throw e;
    L7:
        r0 = new b(this, r11);
        goto L8
    }

    private final void a(com.obric.autogui.common.e r5) {
        if (r5.g() == true) goto L5;
        return;
    L5:
        AOOperatingSpace r6 = OperatingSpaceManager.INSTANCE.getActiveSpace();
        com.obric.autogui.session.d.g.a<AOOperatingSpace> r0 = this.f30935d.b(r6);
        if (r0 != null) goto L8;
        return;
    L8:
        AOOperatingSpace r1 = (AOOperatingSpace) ZeusTransformUtils.preCheckCast(r0.a(), AOOperatingSpace.class, "com.obric.aiagent.plugin");
        String r2 = null;
        if (r0.b() == true) goto L15;
        Loog r4 = Loog.INSTANCE;
        StringBuilder r3 = new StringBuilder().append("skip destroy space on dispose, activeSpaceId=");
        if (r6 == null) goto L13;
        r2 = r6.getSpaceId();
    L13:
        r4.i(TAG, r3.append(r2).append(", ownedSpaceId=").append(r1.getSpaceId()).append(", reason=OwnershipChanged").toString());
        return;
    L15:
        AOThreadingTools.INSTANCE.launchIO((d.h.a.m) ZeusTransformUtils.preCheckCast(new d(this, r1, null), d.h.a.m.class, "com.obric.aiagent.plugin"));
    }

    private final void b(com.obric.autogui.common.e r7) {
        if (r7.g() == false) goto L10;
        com.obric.autogui.util.f.f31548a.a();
        com.obric.autogui.util.f r8 = com.obric.autogui.util.f.f31548a;
        AOOperatingSpace r1 = (AOOperatingSpace) ZeusTransformUtils.preCheckCast(this.f30935d.a(), AOOperatingSpace.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L8;
        String r2 = r1.getSpaceId();
        if (r2 == null) goto L8;
    L9:
        r8.a(r2);
        j();
        com.obric.autogui.util.c.f31500a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f30934c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        return;
    L8:
        r2 = "";
        goto L9
    L10:
        AOUserInterfaceTools.showAppToast$default(AOUserInterfaceTools.INSTANCE, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f30934c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.string.agent_operating_space_creation_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_operating_space_creation_failed"), false, 4, null);
    }

    private final Object a(AOOperatingSpace r6, d.c.d<? super x> r7) {
        AOOperatingSpace r8 = (AOOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r6, AOOperatingSpace.class, "com.obric.aiagent.plugin");
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, c.class) == false) goto L7;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r9, c.class, "com.obric.aiagent.plugin");
        if ((r0.f30943c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f30943c -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.f30941a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f30943c;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        o.a(r10);
    L17:
        com.obric.autogui.util.f.f31548a.b();
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r10);
        OperatingSpaceManager r11 = OperatingSpaceManager.INSTANCE;
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f30934c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        r0.f30943c = 1;
        if (r11.destroySpace(r5, r8, r0) != r2) goto L17;
        return r2;
    L7:
        r0 = new c(this, r9);
        goto L8
    }

    private final void j() {
        this.f30934c.m().a().launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new f(null), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    public final DisplayOperatingSpace h() {
        AOOperatingSpace r0 = this.f30935d.a();
        if (ZeusTransformUtils.instanceOf(r0, DisplayOperatingSpace.class) == false) goto L5;
        DisplayOperatingSpace r1 = (DisplayOperatingSpace) ZeusTransformUtils.preCheckCast(r0, DisplayOperatingSpace.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 != null) goto L8;
        return null;
    L8:
        AOOperatingSpace r2 = OperatingSpaceManager.INSTANCE.getActiveSpace();
        boolean r3 = r1.isValid();
        boolean r7 = this.f30936e.get();
        if (r2 != r1) goto L14;
        if (r3 == false) goto L14;
        if (r7 == true) goto L14;
        return r1;
    L14:
        Loog r4 = Loog.INSTANCE;
        StringBuilder r5 = new StringBuilder().append("preloaded display is no longer active, activeSpaceId=");
        if (r2 == null) goto L17;
        String r6 = r2.getSpaceId();
    L18:
        r4.e(TAG, r5.append(r6).append(", ownedSpaceId=").append(r1.getSpaceId()).append(", ownedValid=").append(r3).append(", invalidated=").append(r7).toString());
        return null;
    L17:
        r6 = null;
        goto L18
    L5:
        r1 = null;
        goto L6
    }

    public final AOOperatingSpace i() {
        AOOperatingSpace r2 = (AOOperatingSpace) ZeusTransformUtils.preCheckCast(this.f30935d.a(), AOOperatingSpace.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L6;
        return null;
    L6:
        if (OperatingSpaceManager.INSTANCE.getActiveSpace() != r2) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return r2;
    L12:
        return null;
    L8:
        r1 = false;
        goto L9
    }
}
