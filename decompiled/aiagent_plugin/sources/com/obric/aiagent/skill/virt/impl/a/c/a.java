package com.obric.aiagent.skill.virt.impl.a.c;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import com.bytedance.safetyguard.lxc.api.ActionContextToken;
import com.bytedance.safetyguard.lxc.api.ActionEgressResult;
import com.bytedance.safetyguard.lxc.api.ProxyReady;
import com.bytedance.safetyguard.lxc.api.ProxyReadyException;
import com.bytedance.safetyguard.lxc.api.ProxySession;
import com.bytedance.safetyguard.lxc.api.ProxySessionOptions;
import com.bytedance.safetyguard.lxc.api.ProxySessionReadyKt;
import com.bytedance.safetyguard.lxc.api.ProxySessionResult;
import com.bytedance.safetyguard.lxc.api.SafetyGuard;
import com.bytedance.safetyguard.lxc.api.SafetyGuardKt;
import com.bytedance.safetyguard.lxc.api.SafetyGuardProxyRuntime;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.bduploader.BDAbstractUpload;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import java.io.Closeable;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.au;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.co;
import kotlinx.coroutines.cx;
import kotlinx.coroutines.dg;

/* JADX INFO: compiled from: LxcBackend.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements com.obric.aiagent.skill.virt.impl.a.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final C0468a f21922a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.aiagent.skill.virt.impl.a.c.b f21923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.aiagent.skill.virt.impl.c.b f21924c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f21925d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f21926e;
    private final Context f;
    private final am g;
    private final com.obric.aiagent.skill.virt.impl.a.c.c h;
    private final File i;
    private final d.f j;
    private final String k;
    private final com.obric.aiagent.skill.virt.impl.a.b.d l;

    /* JADX INFO: renamed from: com.obric.aiagent.skill.virt.impl.a.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: LxcBackend.kt */
    private static final class C0468a {
        public /* synthetic */ C0468a(d.h.b.h r1) {
            this();
        }

        private C0468a() {
        }
    }

    /* JADX INFO: compiled from: LxcBackend.kt */
    @d.c.b.a.f(b = "LxcBackend.kt", c = {688, 692}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.lxc.LxcBackend$stopAndReconcileSync$2")
    static final class aa extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super com.obric.aiagent.skill.virt.impl.a.c.c.a>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21927a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f21928b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f21929c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ au<com.obric.aiagent.skill.virt.impl.a.c.c.a> f21930d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private /* synthetic */ Object f21931e;

        /* JADX INFO: renamed from: com.obric.aiagent.skill.virt.impl.a.c.a$aa$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: LxcBackend.kt */
        @d.c.b.a.f(b = "LxcBackend.kt", c = {688}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.lxc.LxcBackend$stopAndReconcileSync$2$1$1")
        static final class C0469a extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.n<? extends d.x>>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f21932a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ au<d.n<d.x>> f21933b;

            C0469a(au<d.n<d.x>> r3, d.c.d<? super C0469a> r4) {
                au<d.n<d.x>> r5 = (au) ZeusTransformUtils.wrapperContextForParams(r3, au.class, "com.obric.aiagent.plugin");
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f21933b = r5;
                super(2, r6);
            }

            public final Object a(am r3, d.c.d<? super d.n<d.x>> r4) {
                return ((C0469a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0469a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new C0469a(this.f21933b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super d.n<? extends d.x>> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r5) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f21932a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r5);
            L11:
                return r5;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r5);
                au<d.n<d.x>> r6 = this.f21933b;
                d.c.d<? super d.n<d.x>> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f21932a = 1;
                r5 = r6.a(r2);
                if (r5 != r0) goto L11;
                return r0;
            }
        }

        /* JADX INFO: compiled from: LxcBackend.kt */
        @d.c.b.a.f(b = "LxcBackend.kt", c = {692}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.lxc.LxcBackend$stopAndReconcileSync$2$2$1")
        static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super com.obric.aiagent.skill.virt.impl.a.c.c.a>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f21934a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ au<com.obric.aiagent.skill.virt.impl.a.c.c.a> f21935b;

            b(au<com.obric.aiagent.skill.virt.impl.a.c.c.a> r3, d.c.d<? super b> r4) {
                au<com.obric.aiagent.skill.virt.impl.a.c.c.a> r5 = (au) ZeusTransformUtils.wrapperContextForParams(r3, au.class, "com.obric.aiagent.plugin");
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f21935b = r5;
                super(2, r6);
            }

            public final Object a(am r3, d.c.d<? super com.obric.aiagent.skill.virt.impl.a.c.c.a> r4) {
                return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f21935b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super com.obric.aiagent.skill.virt.impl.a.c.c.a> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r5) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f21934a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r5);
            L11:
                return r5;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r5);
                au<com.obric.aiagent.skill.virt.impl.a.c.c.a> r6 = this.f21935b;
                d.c.d<? super com.obric.aiagent.skill.virt.impl.a.c.c.a> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f21934a = 1;
                r5 = r6.a(r2);
                if (r5 != r0) goto L11;
                return r0;
            }
        }

        /* JADX INFO: compiled from: LxcBackend.kt */
        @d.c.b.a.f(b = "LxcBackend.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.lxc.LxcBackend$stopAndReconcileSync$2$killJob$1")
        static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.n<? extends d.x>>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f21936a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ a f21937b;

            c(a r3, d.c.d<? super c> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f21937b = r3;
                super(2, r5);
            }

            public final Object a(am r3, d.c.d<? super d.n<d.x>> r4) {
                return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f21937b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super d.n<? extends d.x>> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r2) {
                d.c.a.b.a();
                if (this.f21936a != 0) goto L7;
                d.o.a(r2);
                return d.n.g(a.b(this.f21937b).c());
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        aa(a r3, au<com.obric.aiagent.skill.virt.impl.a.c.c.a> r4, d.c.d<? super aa> r5) {
            au<com.obric.aiagent.skill.virt.impl.a.c.c.a> r6 = (au) ZeusTransformUtils.wrapperContextForParams(r4, au.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21929c = r3;
            this.f21930d = r6;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super com.obric.aiagent.skill.virt.impl.a.c.c.a> r4) {
            return ((aa) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), aa.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            aa r0 = new aa(this.f21929c, this.f21930d, r6);
            r0.f21931e = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super com.obric.aiagent.skill.virt.impl.a.c.c.a> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1 */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r15) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21928b;
            if (r1 == 0) goto L15;
            if (r1 == 1) goto L12;
            if (r1 != 2) goto L11;
            d.o.a(r15);     // Catch: Throwable -> L8
        L27:
            Object r14 = d.n.f((com.obric.aiagent.skill.virt.impl.a.c.c.a) ZeusTransformUtils.preCheckCast(r15, com.obric.aiagent.skill.virt.impl.a.c.c.a.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8
        L31:
            if (d.n.b(r14) == false) goto L34;
            return null;
        L34:
            return r14;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            au r2 = (au) ZeusTransformUtils.preCheckCast(this.f21927a, au.class, "com.obric.aiagent.plugin");
            am r8 = (am) ZeusTransformUtils.preCheckCast(this.f21931e, am.class, "com.obric.aiagent.plugin");
            d.o.a(r15);     // Catch: Throwable -> L21
            r1 = r2;
        L19:
            d.n.f((d.n) ZeusTransformUtils.preCheckCast(r15, d.n.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L21
            Object r3 = r1;
        L23:
            ca.a.a((ca) ZeusTransformUtils.preCheckCast(r3, ca.class, "com.obric.aiagent.plugin"), null, 1, null);
            au<com.obric.aiagent.skill.virt.impl.a.c.c.a> r16 = this.f21930d;
            d.n.a r4 = d.n.f38560a;     // Catch: Throwable -> L8
            d.h.a.m r17 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(r16, null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
            this.f21931e = null;     // Catch: Throwable -> L8
            this.f21927a = null;     // Catch: Throwable -> L8
            this.f21928b = 2;     // Catch: Throwable -> L8
            r15 = dg.b(5000, r17, this);     // Catch: Throwable -> L8
            if (r15 != r0) goto L27;
            return r0;
        L15:
            d.o.a(r15);
            am r18 = (am) ZeusTransformUtils.preCheckCast(this.f21931e, am.class, "com.obric.aiagent.plugin");
            au r5 = kotlinx.coroutines.i.b(a.c(this.f21929c), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(this.f21929c, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
            d.n.a r9 = d.n.f38560a;     // Catch: Throwable -> L21
            d.h.a.m r10 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new C0469a(r5, null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
            this.f21931e = r18;     // Catch: Throwable -> L21
            this.f21927a = r5;     // Catch: Throwable -> L21
            this.f21928b = 1;     // Catch: Throwable -> L21
            r15 = dg.b(5000, r10, this);     // Catch: Throwable -> L21
            r1 = r5;
            if (r15 != r0) goto L19;
            return r0;
        L8:
            th = move-exception;
            d.n.a r19 = d.n.f38560a;
            r14 = d.n.f(d.o.a(th));
        L21:
            th = move-exception;
            d.n.a r11 = d.n.f38560a;
            d.n.f(d.o.a(th));
            r3 = r1;
            goto L23
        }
    }

    /* JADX INFO: compiled from: LxcBackend.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d.h.a.b<String, d.x> f21938a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object f21939b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<String> f21940c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f21941d;

        public b(d.h.a.b<? super String, d.x> r3) {
            d.h.a.b<String, d.x> r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r4, "downstream");
            this.f21938a = r4;
            this.f21939b = new Object();
            this.f21940c = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        }

        public final void a(String r4) {
            d.h.b.o.e(r4, MonitorConstants.CHUNK);
            Object r0 = this.f21939b;
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (this.f21941d == false) goto L7;
            this.f21938a.invoke(r4);     // Catch: Throwable -> L11
        L8:
            d.x r3 = d.x.f38692a;     // Catch: Throwable -> L11
            monitor-exit(r0);
            return;
        L7:
            ((Collection) ZeusTransformUtils.preCheckCast(this.f21940c, Collection.class, "com.obric.aiagent.plugin")).add(r4);     // Catch: Throwable -> L11
            goto L8
        }

        public final void a() {
            Object r0 = this.f21939b;
            monitor-enter(r0);
        L15:
            th = move-exception;
            throw th;
        L5:
            if (this.f21941d == false) goto L8;
            monitor-exit(r0);
            return;
        L8:
            Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(this.f21940c, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
            d.h.a.b<String, d.x> r2 = this.f21938a;     // Catch: Throwable -> L15
            Iterator r3 = r1.iterator();     // Catch: Throwable -> L15
        L10:
            if (r3.hasNext() == false) goto L12;
            r2.invoke((String) r3.next());     // Catch: Throwable -> L15
            goto L10
        L12:
            this.f21940c.clear();     // Catch: Throwable -> L15
            this.f21941d = true;     // Catch: Throwable -> L15
            d.x r4 = d.x.f38692a;     // Catch: Throwable -> L15
            monitor-exit(r0);
        }
    }

    /* JADX INFO: compiled from: LxcBackend.kt */
    @d.c.b.a.f(b = "LxcBackend.kt", c = {905}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.lxc.LxcBackend$closeProxySession$2")
    static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f21942a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f21943b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ProxySession f21944c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f21945d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f21946e;
        final /* synthetic */ String f;

        /* JADX INFO: renamed from: com.obric.aiagent.skill.virt.impl.a.c.a$c$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: LxcBackend.kt */
        @d.c.b.a.f(b = "LxcBackend.kt", c = {906}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.lxc.LxcBackend$closeProxySession$2$closed$1")
        static final class C0470a extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Boolean>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f21947a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ ProxySession f21948b;

            C0470a(ProxySession r3, d.c.d<? super C0470a> r4) {
                ProxySession r5 = (ProxySession) ZeusTransformUtils.wrapperContextForParams(r3, ProxySession.class, "com.obric.aiagent.plugin");
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f21948b = r5;
                super(2, r6);
            }

            public final Object a(am r3, d.c.d<? super Boolean> r4) {
                return ((C0470a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0470a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new C0470a(this.f21948b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super Boolean> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r5) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f21947a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r5);
            L12:
                return d.c.b.a.b.a(true);
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r5);
                ProxySession r6 = this.f21948b;
                d.c.d<? super ProxySessionResult> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f21947a = 1;
                if (r6.await(r2) != r0) goto L12;
                return r0;
            }
        }

        c(ProxySession r3, a r4, String r5, String r6, d.c.d<? super c> r7) {
            ProxySession r8 = (ProxySession) ZeusTransformUtils.wrapperContextForParams(r3, ProxySession.class, "com.obric.aiagent.plugin");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21944c = r8;
            this.f21945d = r4;
            this.f21946e = r5;
            this.f = r6;
            super(2, r9);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f21944c, this.f21945d, this.f21946e, this.f, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r17) {
            Object r4 = d.c.a.b.a();
            int r0 = this.f21943b;
            if (r0 == 0) goto L12;
            if (r0 != 1) goto L11;
            long r2 = this.f21942a;
            d.o.a(r17);     // Catch: Throwable -> L8
            Object r1 = r17;
            boolean r12 = true;
        L57:
            Boolean r3 = (Boolean) ZeusTransformUtils.preCheckCast(r1, Boolean.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L32
            if (r3 == null) goto L30;
            boolean r5 = r3.booleanValue();     // Catch: Throwable -> L32
        L31:
            boolean r6 = r5;
        L40:
            if (r6 == true) goto L46;
            if (IAppContext.Companion.isDebug() == false) goto L44;
            ILogDepend.Companion.w("Virt/Proxy", "proxySession await timeout executionId=" + this.f21946e + " lxcSessionId=" + this.f + " proxySessionId=" + this.f21944c.getSessionId());
        L50:
            return d.x.f38692a;
        L44:
            ILogDepend.Companion.w("Virt/Proxy", "proxySession await timeout");
            goto L50
        L46:
            if (IAppContext.Companion.isDebug() == false) goto L48;
            ILogDepend.Companion.i("Virt/Proxy", "proxySession closed executionId=" + this.f21946e + " lxcSessionId=" + this.f + " proxySessionId=" + this.f21944c.getSessionId() + " costMs=" + (System.currentTimeMillis() - r2));
            goto L50
        L48:
            ILogDepend.Companion.i("Virt/Proxy", "proxySession closed costMs=" + (System.currentTimeMillis() - r2));
            goto L50
        L30:
            r5 = false;
        L32:
            th = th;
        L39:
            a.a(this.f21945d, "Virt/Proxy", "proxySession await failed", "proxySession await failed executionId=" + this.f21946e + " lxcSessionId=" + this.f + " proxySessionId=" + this.f21944c.getSessionId(), th);
            r6 = r12;
        L8:
            th = th;
            r12 = true;
            goto L39
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            d.o.a(r17);
            long r10 = System.currentTimeMillis();
            Object r7 = this.f21944c.mo32closed1pmJ48();     // Catch: Throwable -> L17
            a r13 = this.f21945d;     // Catch: Throwable -> L17
            String r14 = this.f21946e;     // Catch: Throwable -> L17
            String r15 = this.f;     // Catch: Throwable -> L17
            ProxySession r16 = this.f21944c;     // Catch: Throwable -> L17
            Throwable r8 = d.n.c(r7);     // Catch: Throwable -> L17
            if (r8 == null) goto L51;
            a.a(r13, "Virt/Proxy", "proxySession close failed", "proxySession close failed executionId=" + r14 + " lxcSessionId=" + r15 + " proxySessionId=" + r16.getSessionId(), r8);     // Catch: Throwable -> L17
        L51:
            d.h.a.m r9 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new C0470a(this.f21944c, null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L36
            d.c.d r11 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L36
            this.f21942a = r10;     // Catch: Throwable -> L36
            r12 = true;
            this.f21943b = 1;     // Catch: Throwable -> L34
            r1 = dg.b(5000, r9, r11);     // Catch: Throwable -> L34
            if (r1 != r4) goto L25;
            return r4;
        L25:
            r2 = r10;
        L34:
            th = th;
        L38:
            r2 = r10;
        L36:
            th = th;
            r12 = true;
        L17:
            th = move-exception;
            a.a(this.f21945d, "Virt/Proxy", "proxySession close failed", "proxySession close failed executionId=" + this.f21946e + " lxcSessionId=" + this.f + " proxySessionId=" + this.f21944c.getSessionId(), th);
            goto L51
        }
    }

    /* JADX INFO: compiled from: LxcBackend.kt */
    @d.c.b.a.f(b = "LxcBackend.kt", c = {456, 464, 479, 480, 509, 515, 493, 509, 515}, d = "executeAsyncProxyAttempt", e = "com.obric.aiagent.skill.virt.impl.backend.lxc.LxcBackend")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21949a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21950b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f21951c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f21952d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f21953e;
        Object f;
        Object g;
        Object h;
        Object i;
        Object j;
        Object k;
        Object l;
        Object m;
        int n;
        /* synthetic */ Object o;
        final /* synthetic */ a p;
        int q;

        d(a r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.p = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            this.o = r10;
            this.q |= Integer.MIN_VALUE;
            return a.a(this.p, null, null, null, null, null, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: LxcBackend.kt */
    /* synthetic */ class e extends d.h.b.l implements d.h.a.b<String, d.x> {
        e(Object r8) {
            super(1, r8, com.obric.aiagent.skill.virt.impl.a.f.class, "emitStdout", "emitStdout(Ljava/lang/String;)V", 0);
        }

        public final void a(String r3) {
            d.h.b.o.e(r3, "p0");
            ((com.obric.aiagent.skill.virt.impl.a.f) ZeusTransformUtils.preCheckCast(this.receiver, com.obric.aiagent.skill.virt.impl.a.f.class, "com.obric.aiagent.plugin")).b(r3);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(String r3) {
            a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: LxcBackend.kt */
    /* synthetic */ class f extends d.h.b.l implements d.h.a.b<String, d.x> {
        f(Object r8) {
            super(1, r8, com.obric.aiagent.skill.virt.impl.a.f.class, "emitStderr", "emitStderr(Ljava/lang/String;)V", 0);
        }

        public final void a(String r3) {
            d.h.b.o.e(r3, "p0");
            ((com.obric.aiagent.skill.virt.impl.a.f) ZeusTransformUtils.preCheckCast(this.receiver, com.obric.aiagent.skill.virt.impl.a.f.class, "com.obric.aiagent.plugin")).c(r3);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(String r3) {
            a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: LxcBackend.kt */
    @d.c.b.a.f(b = "LxcBackend.kt", c = {515}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.lxc.LxcBackend$executeAsyncProxyAttempt$7")
    static final class g extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21954a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<ca> f21955b;

        g(List<? extends ca> r3, d.c.d<? super g> r4) {
            List<ca> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21955b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((g) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new g(this.f21955b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21954a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L12:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(this.f21955b, Collection.class, "com.obric.aiagent.plugin");
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21954a = 1;
            if (kotlinx.coroutines.f.b(r6, r2) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: LxcBackend.kt */
    @d.c.b.a.f(b = "LxcBackend.kt", c = {BDAbstractUpload.KeyIsRetryStatesOption}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.lxc.LxcBackend$executeAsyncProxyAttempt$pipeJobs$1")
    static final class h extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21956a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f21957b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.skill.virt.impl.a.c.c.C0472c f21958c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f21959d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f21960e;

        h(a r3, com.obric.aiagent.skill.virt.impl.a.c.c.C0472c r4, AtomicBoolean r5, b r6, d.c.d<? super h> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21957b = r3;
            this.f21958c = r4;
            this.f21959d = r5;
            this.f21960e = r6;
            super(2, r8);
        }

        /* JADX INFO: renamed from: lambda$y4MKK3tlK55anjAgb4-v5kDSf2o, reason: not valid java name */
        public static /* synthetic */ d.x m380lambda$y4MKK3tlK55anjAgb4v5kDSf2o(AtomicBoolean r0, b r1, String r2) {
            return a(r0, r1, r2);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new h(this.f21957b, this.f21958c, this.f21959d, this.f21960e, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21956a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L12:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            a r8 = this.f21957b;
            ParcelFileDescriptor r2 = this.f21958c.b();
            final AtomicBoolean r3 = this.f21959d;
            final b r4 = this.f21960e;
            d.h.a.b r5 = new $$Lambda$a$h$y4MKK3tlK55anjAgb4v5kDSf2o(r3, r4);
            d.c.d r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21956a = 1;
            if (a.a(r8, r2, r5, r6) != r0) goto L12;
            return r0;
        }

        private static final d.x a(AtomicBoolean r1, b r2, String r3) {
            r1.set(true);
            r2.a(r3);
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: LxcBackend.kt */
    @d.c.b.a.f(b = "LxcBackend.kt", c = {443}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.lxc.LxcBackend$executeAsyncProxyAttempt$pipeJobs$2")
    static final class i extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21961a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f21962b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.skill.virt.impl.a.c.c.C0472c f21963c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f21964d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f21965e;

        i(a r3, com.obric.aiagent.skill.virt.impl.a.c.c.C0472c r4, AtomicBoolean r5, b r6, d.c.d<? super i> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21962b = r3;
            this.f21963c = r4;
            this.f21964d = r5;
            this.f21965e = r6;
            super(2, r8);
        }

        public static /* synthetic */ d.x lambda$s8j0ZgvTocz8oi01QqkkT8WW4Zo(AtomicBoolean r0, b r1, String r2) {
            return a(r0, r1, r2);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((i) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), i.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new i(this.f21962b, this.f21963c, this.f21964d, this.f21965e, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21961a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L12:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            a r8 = this.f21962b;
            ParcelFileDescriptor r2 = this.f21963c.c();
            final AtomicBoolean r3 = this.f21964d;
            final b r4 = this.f21965e;
            d.h.a.b r5 = new $$Lambda$a$i$s8j0ZgvTocz8oi01QqkkT8WW4Zo(r3, r4);
            d.c.d r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21961a = 1;
            if (a.a(r8, r2, r5, r6) != r0) goto L12;
            return r0;
        }

        private static final d.x a(AtomicBoolean r1, b r2, String r3) {
            r1.set(true);
            r2.a(r3);
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: LxcBackend.kt */
    @d.c.b.a.f(b = "LxcBackend.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.lxc.LxcBackend$executeAsyncProxyAttempt$resultJob$1")
    static final class j extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super com.obric.aiagent.skill.virt.impl.a.c.c.a>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21966a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f21967b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.skill.virt.impl.a.c.c.C0472c f21968c;

        j(a r3, com.obric.aiagent.skill.virt.impl.a.c.c.C0472c r4, d.c.d<? super j> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21967b = r3;
            this.f21968c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super com.obric.aiagent.skill.virt.impl.a.c.c.a> r4) {
            return ((j) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), j.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new j(this.f21967b, this.f21968c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super com.obric.aiagent.skill.virt.impl.a.c.c.a> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f21966a != 0) goto L7;
            d.o.a(r2);
            return a.b(this.f21967b).a(this.f21968c.a());
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: LxcBackend.kt */
    /* synthetic */ class k extends d.h.b.l implements d.h.a.b<String, d.x> {
        k(Object r8) {
            super(1, r8, com.obric.aiagent.skill.virt.impl.a.f.class, "emitStderr", "emitStderr(Ljava/lang/String;)V", 0);
        }

        public final void a(String r3) {
            d.h.b.o.e(r3, "p0");
            ((com.obric.aiagent.skill.virt.impl.a.f) ZeusTransformUtils.preCheckCast(this.receiver, com.obric.aiagent.skill.virt.impl.a.f.class, "com.obric.aiagent.plugin")).c(r3);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(String r3) {
            a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: LxcBackend.kt */
    /* synthetic */ class l extends d.h.b.l implements d.h.a.b<String, d.x> {
        l(Object r8) {
            super(1, r8, com.obric.aiagent.skill.virt.impl.a.f.class, "emitStdout", "emitStdout(Ljava/lang/String;)V", 0);
        }

        public final void a(String r3) {
            d.h.b.o.e(r3, "p0");
            ((com.obric.aiagent.skill.virt.impl.a.f) ZeusTransformUtils.preCheckCast(this.receiver, com.obric.aiagent.skill.virt.impl.a.f.class, "com.obric.aiagent.plugin")).b(r3);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(String r3) {
            a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: LxcBackend.kt */
    @d.c.b.a.f(b = "LxcBackend.kt", c = {383}, d = "executeAsyncWithProxy", e = "com.obric.aiagent.skill.virt.impl.backend.lxc.LxcBackend")
    static final class m extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21969a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21970b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f21971c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f21972d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f21973e;
        Object f;
        Object g;
        int h;
        /* synthetic */ Object i;
        final /* synthetic */ a j;
        int k;

        m(a r3, d.c.d<? super m> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.j = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            this.i = r9;
            this.k |= Integer.MIN_VALUE;
            return a.a(this.j, null, null, null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: LxcBackend.kt */
    @d.c.b.a.f(b = "LxcBackend.kt", c = {577}, d = "executeFileCommand", e = "com.obric.aiagent.skill.virt.impl.backend.lxc.LxcBackend")
    static final class n extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21974a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21975b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f21976c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f21977d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f21978e;
        /* synthetic */ Object f;
        final /* synthetic */ a g;
        int h;

        n(a r3, d.c.d<? super n> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f = r3;
            this.h |= Integer.MIN_VALUE;
            return a.a(this.g, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: LxcBackend.kt */
    @d.c.b.a.f(b = "LxcBackend.kt", c = {659, 664, 676}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.lxc.LxcBackend$executeSyncInternal$2")
    static final class o extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super com.obric.aiagent.skill.virt.impl.a.c>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21979a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21980b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f21981c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f21982d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.skill.virt.impl.a.b f21983e;

        /* JADX INFO: renamed from: com.obric.aiagent.skill.virt.impl.a.c.a$o$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: LxcBackend.kt */
        @d.c.b.a.f(b = "LxcBackend.kt", c = {659}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.lxc.LxcBackend$executeSyncInternal$2$finalResult$1")
        static final class C0471a extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super com.obric.aiagent.skill.virt.impl.a.c.c.a>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f21984a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ au<com.obric.aiagent.skill.virt.impl.a.c.c.a> f21985b;

            C0471a(au<com.obric.aiagent.skill.virt.impl.a.c.c.a> r3, d.c.d<? super C0471a> r4) {
                au<com.obric.aiagent.skill.virt.impl.a.c.c.a> r5 = (au) ZeusTransformUtils.wrapperContextForParams(r3, au.class, "com.obric.aiagent.plugin");
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f21985b = r5;
                super(2, r6);
            }

            public final Object a(am r3, d.c.d<? super com.obric.aiagent.skill.virt.impl.a.c.c.a> r4) {
                return ((C0471a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0471a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new C0471a(this.f21985b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super com.obric.aiagent.skill.virt.impl.a.c.c.a> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r5) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f21984a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r5);
            L11:
                return r5;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r5);
                au<com.obric.aiagent.skill.virt.impl.a.c.c.a> r6 = this.f21985b;
                d.c.d<? super com.obric.aiagent.skill.virt.impl.a.c.c.a> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f21984a = 1;
                r5 = r6.a(r2);
                if (r5 != r0) goto L11;
                return r0;
            }
        }

        /* JADX INFO: compiled from: LxcBackend.kt */
        @d.c.b.a.f(b = "LxcBackend.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.lxc.LxcBackend$executeSyncInternal$2$resultJob$1")
        static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super com.obric.aiagent.skill.virt.impl.a.c.c.a>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f21986a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ a f21987b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ com.obric.aiagent.skill.virt.impl.a.b f21988c;

            b(a r3, com.obric.aiagent.skill.virt.impl.a.b r4, d.c.d<? super b> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f21987b = r3;
                this.f21988c = r4;
                super(2, r6);
            }

            public final Object a(am r3, d.c.d<? super com.obric.aiagent.skill.virt.impl.a.c.c.a> r4) {
                return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f21987b, this.f21988c, r5), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super com.obric.aiagent.skill.virt.impl.a.c.c.a> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r4) {
                d.c.a.b.a();
                if (this.f21986a != 0) goto L7;
                d.o.a(r4);
                com.obric.aiagent.skill.virt.impl.a.c.c r5 = a.b(this.f21987b);
                a r0 = this.f21987b;
                return r5.a(a.a(r0, r0.a(this.f21988c.b()), this.f21988c.a()), this.f21988c.c());
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        o(a r3, com.obric.aiagent.skill.virt.impl.a.b r4, d.c.d<? super o> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21982d = r3;
            this.f21983e = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super com.obric.aiagent.skill.virt.impl.a.c> r4) {
            return ((o) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), o.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new o(this.f21982d, this.f21983e, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super com.obric.aiagent.skill.virt.impl.a.c> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Not initialized variable reg: 8, insn: 0x0067: MOVE (r1 I:??[OBJECT, ARRAY]) = (r8 I:??[OBJECT, ARRAY]), block:B:25:0x0067 */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r17) {
            Object r2 = d.c.a.b.a();
            int r0 = this.f21981c;
            if (r0 == 0) goto L28;
            if (r0 == 1) goto L21;
            if (r0 == 2) goto L14;
            if (r0 != 3) goto L8;
            e = (CancellationException) ZeusTransformUtils.preCheckCast(this.f21980b, CancellationException.class, "com.obric.aiagent.plugin");
            au r1 = (au) ZeusTransformUtils.preCheckCast(this.f21979a, au.class, "com.obric.aiagent.plugin");
            d.o.a(r17);     // Catch: Throwable -> L12
        L72:
            throw e;     // Catch: Throwable -> L12
        L12:
            th = th;
        L73:
            ca.a.a((ca) ZeusTransformUtils.preCheckCast(r1, ca.class, "com.obric.aiagent.plugin"), null, 1, null);
            throw th;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            au r4 = (au) ZeusTransformUtils.preCheckCast(this.f21979a, au.class, "com.obric.aiagent.plugin");
            d.o.a(r17);     // Catch: Throwable -> L17 CancellationException -> L19
            Object r3 = r17;
        L44:
            com.obric.aiagent.skill.virt.impl.a.c.c.a r5 = (com.obric.aiagent.skill.virt.impl.a.c.c.a) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.virt.impl.a.c.c.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17 CancellationException -> L19
            if (r5 == null) goto L48;
            String r9 = r5.b();     // Catch: Throwable -> L17 CancellationException -> L19
        L49:
            String r10 = "";
            if (r9 != null) goto L52;
            r9 = "";
        L52:
            if (r5 == null) goto L54;
            String r6 = r5.c();     // Catch: Throwable -> L17 CancellationException -> L19
        L55:
            if (r6 == null) goto L58;
            r10 = r6;
        L58:
            com.obric.aiagent.skill.virt.impl.a.c.b r8 = new com.obric.aiagent.skill.virt.impl.a.c.b(r9, r10);     // Catch: Throwable -> L17 CancellationException -> L19
            ca.a.a((ca) ZeusTransformUtils.preCheckCast(r4, ca.class, "com.obric.aiagent.plugin"), null, 1, null);
            return r8;
        L54:
            r6 = null;
            goto L55
        L48:
            r9 = null;
        L19:
            e = e;
            au r11 = r4;
        L68:
            a r7 = this.f21982d;     // Catch: Throwable -> L24
            d.c.d r12 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
            this.f21979a = r11;     // Catch: Throwable -> L24
            this.f21980b = e;     // Catch: Throwable -> L24
            this.f21981c = 3;     // Catch: Throwable -> L24
            if (a.a(r7, r11, r12) != r2) goto L71;
            return r2;
        L71:
            r1 = r11;
        L17:
            th = th;
            r1 = r4;
            goto L73
        L21:
            r11 = (au) ZeusTransformUtils.preCheckCast(this.f21979a, au.class, "com.obric.aiagent.plugin");
            d.o.a(r17);     // Catch: Throwable -> L24 CancellationException -> L26
            Object r13 = r17;
        L37:
            com.obric.aiagent.skill.virt.impl.a.c.c.a r14 = (com.obric.aiagent.skill.virt.impl.a.c.c.a) ZeusTransformUtils.preCheckCast(r13, com.obric.aiagent.skill.virt.impl.a.c.c.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24 CancellationException -> L26
        L39:
            if (r14 != null) goto L61;
            a r15 = this.f21982d;     // Catch: Throwable -> L24 CancellationException -> L26
            d.c.d r16 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24 CancellationException -> L26
            this.f21979a = r11;     // Catch: Throwable -> L24 CancellationException -> L26
            this.f21981c = 2;     // Catch: Throwable -> L24 CancellationException -> L26
            r3 = a.a(r15, r11, r16);     // Catch: Throwable -> L24 CancellationException -> L26
            if (r3 != r2) goto L43;
            return r2;
        L43:
            r4 = r11;
            goto L44
        L61:
            com.obric.aiagent.skill.virt.impl.a.c.a r18 = new com.obric.aiagent.skill.virt.impl.a.c.a(r14.a(), r14.b(), r14.c());     // Catch: Throwable -> L24 CancellationException -> L26
            ca.a.a((ca) ZeusTransformUtils.preCheckCast(r11, ca.class, "com.obric.aiagent.plugin"), null, 1, null);
            return r18;
        L26:
            e = e;
            goto L68
        L28:
            d.o.a(r17);
            if (a.b(this.f21982d).a() == false) goto L76;
            long r19 = SystemClock.elapsedRealtime();
            au r110 = kotlinx.coroutines.i.b(a.c(this.f21982d), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(this.f21982d, this.f21983e, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
            long r111 = d.l.n.a(this.f21983e.c() - d.l.n.a(SystemClock.elapsedRealtime() - r19, 0), 0);     // Catch: Throwable -> L64 CancellationException -> L66
            if (r111 <= 0) goto L38;
            d.h.a.m r20 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new C0471a(r110, null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L64 CancellationException -> L66
            d.c.d r21 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L64 CancellationException -> L66
            this.f21979a = r110;     // Catch: Throwable -> L64 CancellationException -> L66
            this.f21981c = 1;     // Catch: Throwable -> L64 CancellationException -> L66
            r13 = dg.b(r111, r20, r21);     // Catch: Throwable -> L64 CancellationException -> L66
            if (r13 != r2) goto L36;
            return r2;
        L36:
            r11 = r110;
            goto L37
        L38:
            r14 = null;
            r11 = r110;
        L66:
            e = e;
            r11 = r110;
        L64:
            th = th;
            r1 = r110;
            goto L73
        L76:
            throw new IllegalStateException("VirtService is not available".toString());
        L24:
            th = th;
            r1 = r8;
            goto L73
        }
    }

    /* JADX INFO: compiled from: LxcBackend.kt */
    @d.c.b.a.f(b = "LxcBackend.kt", c = {239}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.lxc.LxcBackend$exportFile$2")
    static final class p extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super com.obric.aiagent.skill.virt.api.d>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21989a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21990b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f21991c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f21992d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f21993e;
        final /* synthetic */ com.obric.aiagent.skill.virt.api.b f;
        final /* synthetic */ com.obric.aiagent.skill.virt.api.c g;

        p(String r3, a r4, com.obric.aiagent.skill.virt.api.b r5, com.obric.aiagent.skill.virt.api.c r6, d.c.d<? super p> r7) {
            com.obric.aiagent.skill.virt.api.c r8 = (com.obric.aiagent.skill.virt.api.c) ZeusTransformUtils.wrapperContextForParams(r6, com.obric.aiagent.skill.virt.api.c.class, "com.obric.aiagent.plugin");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21992d = r3;
            this.f21993e = r4;
            this.f = r5;
            this.g = r8;
            super(2, r9);
        }

        public final Object a(am r3, d.c.d<? super com.obric.aiagent.skill.virt.api.d> r4) {
            return ((p) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), p.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new p(this.f21992d, this.f21993e, this.f, this.g, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super com.obric.aiagent.skill.virt.api.d> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [com.obric.aiagent.skill.virt.impl.a.b.b, int] */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            Object r0 = d.c.a.b.a();
            ?? r1 = this.f21991c;
            boolean r2 = true;
            if (r1 == 0) goto L10;
            if (r1 != 1) goto L9;
            String r3 = (String) ZeusTransformUtils.preCheckCast(this.f21990b, String.class, "com.obric.aiagent.plugin");
            com.obric.aiagent.skill.virt.impl.a.b.b r4 = (com.obric.aiagent.skill.virt.impl.a.b.b) ZeusTransformUtils.preCheckCast(this.f21989a, com.obric.aiagent.skill.virt.impl.a.b.b.class, "com.obric.aiagent.plugin");
            d.o.a(r10);     // Catch: Throwable -> L29
        L15:
            com.obric.aiagent.skill.virt.impl.a.c.a r11 = (com.obric.aiagent.skill.virt.impl.a.c.a) ZeusTransformUtils.preCheckCast(r10, com.obric.aiagent.skill.virt.impl.a.c.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29
            if (r11.c() == 0) goto L19;
            r2 = false;
        L19:
            if (r2 == false) goto L28;
            File r12 = new File(r4.a(), r3);     // Catch: Throwable -> L29
            if (r12.isFile() == false) goto L26;
            File r5 = a.a(this.f21993e).a(this.g, r3, this.f);     // Catch: Throwable -> L29
            a.a(this.f21993e).a(r12, r5);     // Catch: Throwable -> L29
            String r6 = r5.getAbsolutePath();     // Catch: Throwable -> L29
            d.h.b.o.c(r6, "getAbsolutePath(...)");     // Catch: Throwable -> L29
            String r7 = r5.getName();     // Catch: Throwable -> L29
            d.h.b.o.c(r7, "getName(...)");     // Catch: Throwable -> L29
            com.obric.aiagent.skill.virt.api.d r13 = new com.obric.aiagent.skill.virt.api.d(r6, r7, r5.length());     // Catch: Throwable -> L29
            a.a(this.f21993e).a(r4.a());
            return r13;
        L26:
            throw new IllegalStateException(("LXC export staging file missing: " + r12.getAbsolutePath()).toString());     // Catch: Throwable -> L29
        L28:
            throw new IllegalStateException(("LXC export failed exit=" + r11.c() + " stderr=" + d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r11.b(), CharSequence.class, "com.obric.aiagent.plugin")).toString()).toString());     // Catch: Throwable -> L29
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            d.o.a(r10);
            com.obric.aiagent.skill.virt.impl.a.b.d.f21908a.a(this.f21992d, "sourcePath", true);
            r4 = a.a(this.f21993e).a(com.obric.aiagent.skill.virt.impl.a.b.c.f21904b, com.obric.aiagent.skill.virt.impl.a.b.d.f21908a.a());
            String r14 = com.obric.aiagent.skill.virt.impl.a.b.d.f21908a.a(d.o.o.c(this.f21992d, '/', null, 2, null));     // Catch: Throwable -> L29
            String r8 = com.obric.aiagent.skill.virt.impl.a.b.d.f21908a.a(this.f21992d, r4.b(), com.obric.aiagent.skill.virt.impl.a.b.d.f21908a.a(r4.b(), r14), this.f.a());     // Catch: Throwable -> L29
            a r9 = this.f21993e;     // Catch: Throwable -> L29
            d.c.d r15 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29
            this.f21989a = r4;     // Catch: Throwable -> L29
            this.f21990b = r14;     // Catch: Throwable -> L29
            this.f21991c = 1;     // Catch: Throwable -> L29
            Object r16 = a.a(r9, r8, "export_staging_copy", r15);     // Catch: Throwable -> L29
            if (r16 != r0) goto L14;
            return r0;
        L14:
            r3 = r14;
            r10 = r16;
        L29:
            th = move-exception;
            a.a(this.f21993e).a(r1.a());
            throw th;
        }
    }

    /* JADX INFO: compiled from: LxcBackend.kt */
    /* synthetic */ class q extends d.h.b.l implements d.h.a.a<File> {
        q(Object r8) {
            super(0, r8, a.class, "ensureHostNamespaceRoot", "ensureHostNamespaceRoot()Ljava/io/File;", 0);
        }

        public final File a() {
            return a.d((a) ZeusTransformUtils.preCheckCast(this.receiver, a.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.a
        public /* synthetic */ File invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: LxcBackend.kt */
    /* synthetic */ class r extends d.h.b.l implements d.h.a.a<String> {
        r(Object r8) {
            super(0, r8, a.class, "sharedNamespacePath", "sharedNamespacePath()Ljava/lang/String;", 0);
        }

        public final String a() {
            return a.e((a) ZeusTransformUtils.preCheckCast(this.receiver, a.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: LxcBackend.kt */
    /* synthetic */ class s extends d.h.b.l implements d.h.a.b<com.obric.aiagent.skill.virt.impl.a.b.a, d.x> {
        s(Object r8) {
            super(1, r8, a.class, "logHostMove", "logHostMove(Lcom/obric/aiagent/skill/virt/impl/backend/file/HostMoveEvent;)V", 0);
        }

        public final void a(com.obric.aiagent.skill.virt.impl.a.b.a r3) {
            d.h.b.o.e(r3, "p0");
            a.a((a) ZeusTransformUtils.preCheckCast(this.receiver, a.class, "com.obric.aiagent.plugin"), r3);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(com.obric.aiagent.skill.virt.impl.a.b.a r3) {
            a((com.obric.aiagent.skill.virt.impl.a.b.a) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.virt.impl.a.b.a.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: LxcBackend.kt */
    @d.c.b.a.f(b = "LxcBackend.kt", c = {162}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.lxc.LxcBackend$importFile$2")
    static final class t extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super com.obric.aiagent.skill.virt.api.h>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21994a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f21995b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.skill.virt.api.f f21996c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.skill.virt.api.g f21997d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f21998e;

        t(String r3, com.obric.aiagent.skill.virt.api.f r4, com.obric.aiagent.skill.virt.api.g r5, a r6, d.c.d<? super t> r7) {
            com.obric.aiagent.skill.virt.api.g r8 = (com.obric.aiagent.skill.virt.api.g) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.aiagent.skill.virt.api.g.class, "com.obric.aiagent.plugin");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21995b = r3;
            this.f21996c = r4;
            this.f21997d = r8;
            this.f21998e = r6;
            super(2, r9);
        }

        public final Object a(am r3, d.c.d<? super com.obric.aiagent.skill.virt.api.h> r4) {
            return ((t) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), t.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new t(this.f21995b, this.f21996c, this.f21997d, this.f21998e, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super com.obric.aiagent.skill.virt.api.h> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21994a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r8);
        L31:
            return r8;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r8);
            com.obric.aiagent.skill.virt.impl.a.b.d.f21908a.a(this.f21995b, "targetPath", false);
            if (this.f21996c.c() == true) goto L11;
        L15:
            boolean r9 = a.a(this.f21998e).a(this.f21995b);
            if (r9 == true) goto L18;
        L23:
            if (r9 == true) goto L25;
        L28:
            a r10 = this.f21998e;
            com.obric.aiagent.skill.virt.api.g r3 = this.f21997d;
            String r4 = this.f21995b;
            com.obric.aiagent.skill.virt.api.f r5 = this.f21996c;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21994a = 1;
            r8 = a.a(r10, r3, r4, r5, r2);
            if (r8 != r0) goto L31;
            return r0;
        L25:
            if (ZeusTransformUtils.instanceOf(this.f21997d, com.obric.aiagent.skill.virt.api.g.a.class) == false) goto L28;
            return a.a(this.f21998e).a((com.obric.aiagent.skill.virt.api.g.a) ZeusTransformUtils.preCheckCast(this.f21997d, com.obric.aiagent.skill.virt.api.g.a.class, "com.obric.aiagent.plugin"), this.f21995b, this.f21996c);
        L18:
            if (this.f21996c.c() == false) goto L23;
            if (ZeusTransformUtils.instanceOf(this.f21997d, com.obric.aiagent.skill.virt.api.g.b.class) == false) goto L23;
            return a.a(this.f21998e).a((com.obric.aiagent.skill.virt.api.g.b) ZeusTransformUtils.preCheckCast(this.f21997d, com.obric.aiagent.skill.virt.api.g.b.class, "com.obric.aiagent.plugin"), this.f21995b, this.f21996c);
        L11:
            if (ZeusTransformUtils.instanceOf(this.f21997d, com.obric.aiagent.skill.virt.api.g.c.class) == false) goto L15;
            throw new IllegalStateException("moveSource=true is only valid for Host{File,Directory}".toString());
        }
    }

    /* JADX INFO: compiled from: LxcBackend.kt */
    @d.c.b.a.f(b = "LxcBackend.kt", c = {200}, d = "stagedImport", e = "com.obric.aiagent.skill.virt.impl.backend.lxc.LxcBackend")
    static final class u extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21999a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f22000b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f22001c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f22002d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f22003e;
        final /* synthetic */ a f;
        int g;

        u(a r3, d.c.d<? super u> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f22003e = r3;
            this.g |= Integer.MIN_VALUE;
            return a.a(this.f, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: LxcBackend.kt */
    @d.c.b.a.f(b = "LxcBackend.kt", c = {334}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.lxc.LxcBackend$startAsync$2")
    static final class v extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f22004a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f22005b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f22006c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f22007d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f22008e;
        final /* synthetic */ Map<String, String> f;
        final /* synthetic */ String g;
        final /* synthetic */ com.obric.aiagent.skill.virt.impl.a.f h;
        final /* synthetic */ AtomicBoolean i;

        v(a r3, String r4, String r5, String r6, Map<String, String> r7, String r8, com.obric.aiagent.skill.virt.impl.a.f r9, AtomicBoolean r10, d.c.d<? super v> r11) {
            Map<String, String> r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
            d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22005b = r3;
            this.f22006c = r4;
            this.f22007d = r5;
            this.f22008e = r6;
            this.f = r12;
            this.g = r8;
            this.h = r9;
            this.i = r10;
            super(2, r13);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((v) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), v.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r12, d.c.d<?> r13) {
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new v(this.f22005b, this.f22006c, this.f22007d, this.f22008e, this.f, this.g, this.h, this.i, r10), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r14) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f22004a;
            if (r1 == 0) goto L11;
            if (r1 != 1) goto L10;
            d.o.a(r14);     // Catch: Throwable -> L7
        L15:
            com.obric.aiagent.skill.virt.impl.a.c.c.a r15 = (com.obric.aiagent.skill.virt.impl.a.c.c.a) ZeusTransformUtils.preCheckCast(r14, com.obric.aiagent.skill.virt.impl.a.c.c.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
            if (this.i.get() == true) goto L18;
            int r16 = r15.a();     // Catch: Throwable -> L7
        L22:
            this.h.a(new com.obric.aiagent.skill.virt.impl.a.h(r16, null, this.i.get()));     // Catch: Throwable -> L7
        L26:
            return d.x.f38692a;
        L18:
            if (r15.a() != 0) goto L20;
            r16 = ApWakeEvent.ACCELERATING_START;
            goto L22
        L20:
            r16 = r15.a();     // Catch: Throwable -> L7
            goto L22
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            d.o.a(r14);
            String r7 = a.a(this.f22005b, this.f22006c, this.f22007d);     // Catch: Throwable -> L7
            a r5 = this.f22005b;     // Catch: Throwable -> L7
            String r6 = this.f22008e;     // Catch: Throwable -> L7
            Map r8 = a.a(r5, this.f);     // Catch: Throwable -> L7
            String r9 = this.g;     // Catch: Throwable -> L7
            com.obric.aiagent.skill.virt.impl.a.f r10 = this.h;     // Catch: Throwable -> L7
            AtomicBoolean r11 = this.i;     // Catch: Throwable -> L7
            d.c.d r12 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
            this.f22004a = 1;     // Catch: Throwable -> L7
            r14 = a.a(r5, r6, r7, r8, r9, r10, r11, r12);     // Catch: Throwable -> L7
            if (r14 != r0) goto L15;
            return r0;
        L7:
            th = move-exception;
            a.a(this.f22005b, "Virt/Lxc", "LXC shell execution failed", "LXC shell execution failed id=" + this.f22008e, th);
            this.h.a(th);
            goto L26
        }
    }

    /* JADX INFO: compiled from: LxcBackend.kt */
    public static final class w implements com.obric.aiagent.skill.virt.impl.a.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f22009a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f22010b;

        w(AtomicBoolean r1, a r2) {
            this.f22009a = r1;
            this.f22010b = r2;
        }

        @Override // com.obric.aiagent.skill.virt.impl.a.g
        public Object a() {
            this.f22009a.set(true);
            return a.b(this.f22010b).c();
        }

        @Override // com.obric.aiagent.skill.virt.impl.a.g
        public Object b() {
            this.f22009a.set(true);
            return a.b(this.f22010b).c();
        }
    }

    /* JADX INFO: compiled from: LxcBackend.kt */
    @d.c.b.a.f(b = "LxcBackend.kt", c = {767, 771}, d = "startProxySession", e = "com.obric.aiagent.skill.virt.impl.backend.lxc.LxcBackend")
    static final class x extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f22011a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f22012b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f22013c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f22014d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f22015e;
        /* synthetic */ Object f;
        final /* synthetic */ a g;
        int h;

        x(a r3, d.c.d<? super x> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f = r3;
            this.h |= Integer.MIN_VALUE;
            return a.a(this.g, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: LxcBackend.kt */
    @d.c.b.a.f(b = "LxcBackend.kt", c = {768}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.lxc.LxcBackend$startProxySession$2")
    static final class y extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super ProxyReady>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f22016a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ProxySession f22017b;

        y(ProxySession r3, d.c.d<? super y> r4) {
            ProxySession r5 = (ProxySession) ZeusTransformUtils.wrapperContextForParams(r3, ProxySession.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22017b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super ProxyReady> r4) {
            return ((y) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), y.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new y(this.f22017b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super ProxyReady> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f22016a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            ProxySession r6 = this.f22017b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22016a = 1;
            r5 = ProxySessionReadyKt.awaitReady(r6, r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: LxcBackend.kt */
    @d.c.b.a.f(b = "LxcBackend.kt", c = {811}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.lxc.LxcBackend$stopAndReconcileAsync$2")
    static final class z extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super com.obric.aiagent.skill.virt.impl.a.c.c.a>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f22018a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f22019b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f22020c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ au<com.obric.aiagent.skill.virt.impl.a.c.c.a> f22021d;

        /* JADX INFO: renamed from: com.obric.aiagent.skill.virt.impl.a.c.a$z$1, reason: invalid class name */
        /* JADX INFO: compiled from: LxcBackend.kt */
        @d.c.b.a.f(b = "LxcBackend.kt", c = {811}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.lxc.LxcBackend$stopAndReconcileAsync$2$2")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super com.obric.aiagent.skill.virt.impl.a.c.c.a>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f22022a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ au<com.obric.aiagent.skill.virt.impl.a.c.c.a> f22023b;

            AnonymousClass1(au<com.obric.aiagent.skill.virt.impl.a.c.c.a> r3, d.c.d<? super AnonymousClass1> r4) {
                au<com.obric.aiagent.skill.virt.impl.a.c.c.a> r5 = (au) ZeusTransformUtils.wrapperContextForParams(r3, au.class, "com.obric.aiagent.plugin");
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f22023b = r5;
                super(2, r6);
            }

            public final Object a(am r3, d.c.d<? super com.obric.aiagent.skill.virt.impl.a.c.c.a> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f22023b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super com.obric.aiagent.skill.virt.impl.a.c.c.a> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r5) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f22022a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r5);
            L11:
                return r5;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r5);
                au<com.obric.aiagent.skill.virt.impl.a.c.c.a> r6 = this.f22023b;
                d.c.d<? super com.obric.aiagent.skill.virt.impl.a.c.c.a> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f22022a = 1;
                r5 = r6.a(r2);
                if (r5 != r0) goto L11;
                return r0;
            }
        }

        z(a r3, String r4, au<com.obric.aiagent.skill.virt.impl.a.c.c.a> r5, d.c.d<? super z> r6) {
            au<com.obric.aiagent.skill.virt.impl.a.c.c.a> r7 = (au) ZeusTransformUtils.wrapperContextForParams(r5, au.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22019b = r3;
            this.f22020c = r4;
            this.f22021d = r7;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super com.obric.aiagent.skill.virt.impl.a.c.c.a> r4) {
            return ((z) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), z.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new z(this.f22019b, this.f22020c, this.f22021d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super com.obric.aiagent.skill.virt.impl.a.c.c.a> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f22018a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L14:
            return r7;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            Object r8 = a.b(this.f22019b).c();
            a r2 = this.f22019b;
            String r3 = this.f22020c;
            Throwable r9 = d.n.c(r8);
            if (r9 == null) goto L11;
            a.a(r2, "Virt/Lxc", "Failed to kill LXC command after proxy failure", "Failed to kill LXC command after proxy failure id=" + r3, r9);
        L11:
            d.h.a.m r10 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f22021d, null), d.h.a.m.class, "com.obric.aiagent.plugin");
            d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22018a = 1;
            r7 = dg.b(5000, r10, r4);
            if (r7 != r0) goto L14;
            return r0;
        }
    }

    static {
        f21922a = new C0468a(null);
    }

    public static /* synthetic */ SafetyGuardProxyRuntime lambda$HMYApNi9lUV7aVdWekiGCIsnsZ4(a r0) {
        return f(r0);
    }

    public static /* synthetic */ d.x lambda$Ry5tJz5X3nYHETjbtzCsEWN47J8(d.h.a.b r0, String r1, String r2, String r3) {
        return a(r0, r1, r2, r3);
    }

    public static /* synthetic */ d.x lambda$XCz1udCLrbx2x6AwWk06A0vH7yo(d.h.a.b r0, String r1, String r2, String r3) {
        return b(r0, r1, r2, r3);
    }

    public static /* synthetic */ File lambda$d9FYFlKDiW10FanCwK1AwctJ80M(a r0) {
        return g(r0);
    }

    public static /* synthetic */ Throwable lambda$qGgAnc74aFDax32p2LSenW59b4k(Throwable r0) {
        return b(r0);
    }

    /* JADX INFO: renamed from: lambda$scCiH1rrVeVf9x-_7cVpDtMVzX4, reason: not valid java name */
    public static /* synthetic */ d.x m379lambda$scCiH1rrVeVf9x_7cVpDtMVzX4(File r0) {
        return a(r0);
    }

    public a(Context r9, com.obric.aiagent.skill.virt.impl.a.c.b r10, com.obric.aiagent.skill.virt.impl.c.b r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r12, "context");
        d.h.b.o.e(r10, "config");
        d.h.b.o.e(r11, "shellMonitor");
        this.f21923b = r10;
        this.f21924c = r11;
        this.f21925d = 1;
        this.f21926e = "lxc";
        this.f = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r12.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.g = an.a(bd.c().plus((d.c.g) ZeusTransformUtils.preCheckCast(cx.a(null, 1, null), d.c.g.class, "com.obric.aiagent.plugin")));
        this.h = new com.obric.aiagent.skill.virt.impl.a.c.c(r10);
        this.i = new File(r10.e());
        this.j = d.g.a(new $$Lambda$a$HMYApNi9lUV7aVdWekiGCIsnsZ4(this));
        this.k = r10.a();
        this.l = new com.obric.aiagent.skill.virt.impl.a.b.d((d.h.a.a) ZeusTransformUtils.preCheckCast(new q(this), d.h.a.a.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.preCheckCast(new r(this), d.h.a.a.class, "com.obric.aiagent.plugin"), new $$Lambda$a$d9FYFlKDiW10FanCwK1AwctJ80M(this), (d.h.a.b) ZeusTransformUtils.preCheckCast(new s(this), d.h.a.b.class, "com.obric.aiagent.plugin"), $$Lambda$a$scCiH1rrVeVf9x_7cVpDtMVzX4.INSTANCE);
    }

    public static final /* synthetic */ com.obric.aiagent.skill.virt.impl.a.b.d a(a r0) {
        return r0.l;
    }

    public static final /* synthetic */ Object a(a r2, ParcelFileDescriptor r3, d.h.a.b r4, d.c.d r5) {
        return r2.a(r3, (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(a r2, com.obric.aiagent.skill.virt.api.g r3, String r4, com.obric.aiagent.skill.virt.api.f r5, d.c.d r6) {
        return r2.b((com.obric.aiagent.skill.virt.api.g) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.aiagent.skill.virt.api.g.class, "com.obric.aiagent.plugin"), r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(a r2, String r3, String r4, ParcelFileDescriptor r5, d.c.d r6) {
        return r2.a(r3, r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(a r2, String r3, String r4, d.c.d r5) {
        return r2.a(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(a r11, String r12, String r13, Map r14, String r15, com.obric.aiagent.skill.virt.impl.a.f r16, long r17, d.c.d r19) {
        return r11.a(r12, r13, (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.aiagent.plugin"), r15, r16, r17, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(a r10, String r11, String r12, Map r13, String r14, com.obric.aiagent.skill.virt.impl.a.f r15, AtomicBoolean r16, d.c.d r17) {
        return r10.a(r11, r12, (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.aiagent.plugin"), r14, r15, r16, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r17, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(a r2, au r3, d.c.d r4) {
        return r2.a((au) ZeusTransformUtils.wrapperContextForParams(r3, au.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ String a(a r0, String r1, String r2) {
        return r0.a(r1, r2);
    }

    public static final /* synthetic */ Map a(a r2, Map r3) {
        return r2.a((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(a r0, com.obric.aiagent.skill.virt.impl.a.b.a r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ void a(a r0, String r1, String r2, String r3, Throwable r4) {
        r0.a(r1, r2, r3, r4);
    }

    public static final /* synthetic */ com.obric.aiagent.skill.virt.impl.a.c.c b(a r0) {
        return r0.h;
    }

    public static final /* synthetic */ am c(a r0) {
        return r0.g;
    }

    public static final /* synthetic */ File d(a r0) {
        return r0.j();
    }

    public static final /* synthetic */ String e(a r0) {
        return r0.i();
    }

    @Override // com.obric.aiagent.skill.virt.impl.a.k
    public int c() {
        return this.f21925d;
    }

    @Override // com.obric.aiagent.skill.virt.impl.a.k
    public Object a(d.c.d<? super d.x> r2) {
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin");
        return d.x.f38692a;
    }

    @Override // com.obric.aiagent.skill.virt.impl.a.k
    public Object b(d.c.d<? super d.x> r2) {
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin");
        return d.x.f38692a;
    }

    @Override // com.obric.aiagent.skill.virt.impl.a.k
    public String a() {
        return this.f21926e;
    }

    @Override // com.obric.aiagent.skill.virt.impl.a.k
    public com.obric.aiagent.skill.virt.impl.a.a b() {
        return new com.obric.aiagent.skill.virt.impl.a.a(h(), i());
    }

    private final SafetyGuardProxyRuntime e() {
        return (SafetyGuardProxyRuntime) ZeusTransformUtils.preCheckCast(this.j.b(), SafetyGuardProxyRuntime.class, "com.obric.aiagent.plugin");
    }

    private static final SafetyGuardProxyRuntime f(a r2) {
        Context r3 = r2.f;
        d.h.b.o.c(r3, "appContext");
        return SafetyGuard.DefaultImpls.createProxyRuntime$default(SafetyGuardKt.getSafetyGuard(r3), null, 1, null);
    }

    private static final File g(a r2) {
        return new File(r2.f.getCacheDir(), "runtime_exports");
    }

    private static final d.x a(File r4) {
        d.h.b.o.e(r4, "file");
        if (IAppContext.Companion.isDebug() == false) goto L5;
        ILogDepend.Companion.w("Virt/Lxc", "Failed to clean file bridge path: " + r4.getAbsolutePath());
    L7:
        return d.x.f38692a;
    L5:
        ILogDepend.Companion.w("Virt/Lxc", "Failed to clean file bridge path");
        goto L7
    }

    public final boolean d() {
        if (f() == true) goto L5;
    L11:
        return false;
    L5:
        if (this.h.a() == false) goto L11;
        if (this.h.b() == false) goto L11;
        if (g() == false) goto L11;
        return true;
    }

    private final boolean f() {
        com.obric.aiagent.skill.virt.impl.a.c.d r0 = com.obric.aiagent.skill.virt.impl.a.c.d.f22039a;
        Context r1 = this.f;
        d.h.b.o.c(r1, "appContext");
        if (r0.a(r1) == true) goto L8;
        com.obric.aiagent.skill.virt.impl.a.c.d r2 = com.obric.aiagent.skill.virt.impl.a.c.d.f22039a;
        Context r3 = this.f;
        d.h.b.o.c(r3, "appContext");
        if (r2.b(r3) == true) goto L8;
        return false;
    L8:
        return true;
    }

    @Override // com.obric.aiagent.skill.virt.impl.a.k
    public String a(String r4) {
        d.h.b.o.e(r4, "workDir");
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.c(r4, new char[]{'/'}), CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r5) == false) goto L6;
        r5 = h();
    L6:
        return (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.skill.virt.impl.a.k
    public Object a(com.obric.aiagent.skill.virt.api.g r9, String r10, com.obric.aiagent.skill.virt.api.f r11, d.c.d<? super com.obric.aiagent.skill.virt.api.h> r12) {
        com.obric.aiagent.skill.virt.api.g r5 = (com.obric.aiagent.skill.virt.api.g) ZeusTransformUtils.wrapperContextForParams(r9, com.obric.aiagent.skill.virt.api.g.class, "com.obric.aiagent.plugin");
        d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new t(r10, r11, r5, this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r13);
    }

    private final Object b(com.obric.aiagent.skill.virt.api.g r21, String r22, com.obric.aiagent.skill.virt.api.f r23, d.c.d<? super com.obric.aiagent.skill.virt.api.h> r24) {
        a r1 = this;
        String r0 = r22;
        com.obric.aiagent.skill.virt.api.g r2 = (com.obric.aiagent.skill.virt.api.g) ZeusTransformUtils.wrapperContextForParams(r21, com.obric.aiagent.skill.virt.api.g.class, "com.obric.aiagent.plugin");
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r24, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, u.class) == false) goto L7;
        u r4 = (u) ZeusTransformUtils.preCheckCast(r3, u.class, "com.obric.aiagent.plugin");
        if ((r4.g & Integer.MIN_VALUE) == 0) goto L7;
        r4.g -= Integer.MIN_VALUE;
    L8:
        u r10 = r4;
        Object r5 = r10.f22003e;
        Object r11 = d.c.a.b.a();
        int r6 = r10.g;
        if (r6 == 0) goto L18;
        if (r6 != 1) goto L17;
        long r7 = r10.f22002d;
        com.obric.aiagent.skill.virt.impl.a.b.b r8 = (com.obric.aiagent.skill.virt.impl.a.b.b) ZeusTransformUtils.preCheckCast(r10.f22001c, com.obric.aiagent.skill.virt.impl.a.b.b.class, "com.obric.aiagent.plugin");
        String r9 = (String) ZeusTransformUtils.preCheckCast(r10.f22000b, String.class, "com.obric.aiagent.plugin");
        a r12 = (a) ZeusTransformUtils.preCheckCast(r10.f21999a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r5);     // Catch: Throwable -> L14
        r0 = r9;
        r1 = r12;
        boolean r13 = true;
        long r14 = r7;
    L45:
        com.obric.aiagent.skill.virt.impl.a.c.a r15 = (com.obric.aiagent.skill.virt.impl.a.c.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.skill.virt.impl.a.c.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37
        if (r15.c() == 0) goto L31;
        r13 = false;
    L31:
        if (r13 == false) goto L36;
        com.obric.aiagent.skill.virt.api.h r16 = new com.obric.aiagent.skill.virt.api.h(com.obric.aiagent.skill.virt.impl.a.b.d.f21908a.b(r0), r14);     // Catch: Throwable -> L37
        r1.l.a(r8.a());
        return r16;
    L36:
        throw new IllegalStateException(("LXC import failed exit=" + r15.c() + " stderr=" + d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r15.b(), CharSequence.class, "com.obric.aiagent.plugin")).toString()).toString());     // Catch: Throwable -> L37
    L37:
        th = th;
    L41:
        r1.l.a(r8.a());
        throw th;
    L14:
        th = th;
        r1 = r12;
        goto L41
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r5);
        com.obric.aiagent.skill.virt.impl.a.b.b r17 = r1.l.a(com.obric.aiagent.skill.virt.impl.a.b.c.f21903a, com.obric.aiagent.skill.virt.impl.a.b.d.f21908a.a());
        String r18 = r1.l.a(r2, r0);     // Catch: Throwable -> L39
        File r19 = new File(r17.a(), r18);     // Catch: Throwable -> L39
        boolean r20 = ZeusTransformUtils.instanceOf(r2, com.obric.aiagent.skill.virt.api.g.a.class);     // Catch: Throwable -> L39
        long r25 = r1.l.a(r2, r19, r23.c());     // Catch: Throwable -> L39
        String r26 = com.obric.aiagent.skill.virt.impl.a.b.d.f21908a.a(r17.b(), r18);     // Catch: Throwable -> L39
        com.obric.aiagent.skill.virt.impl.a.b.d.a r27 = com.obric.aiagent.skill.virt.impl.a.b.d.f21908a;     // Catch: Throwable -> L39
        boolean r28 = r23.a();     // Catch: Throwable -> L39
        boolean r110 = r23.b();     // Catch: Throwable -> L39
        if (r20 == false) goto L22;
        boolean r111 = true;
    L23:
        r14 = r25;
        String r29 = r27.a(r26, r22, r28, r110, r111, r23.d());     // Catch: Throwable -> L39
        r10.f21999a = r1;     // Catch: Throwable -> L39
        r10.f22000b = r0;     // Catch: Throwable -> L39
        r10.f22001c = r17;     // Catch: Throwable -> L39
        r10.f22002d = r14;     // Catch: Throwable -> L39
        r13 = true;
        r10.g = 1;     // Catch: Throwable -> L39
        r5 = r1.a(r29, "import_staging_move", r10);     // Catch: Throwable -> L39
        if (r5 != r11) goto L26;
        return r11;
    L26:
        r8 = r17;
        goto L45
    L22:
        r111 = false;
    L39:
        th = th;
        r8 = r17;
    L7:
        r4 = new u(r1, r3);
        goto L8
    }

    @Override // com.obric.aiagent.skill.virt.impl.a.k
    public Object a(String r9, com.obric.aiagent.skill.virt.api.c r10, com.obric.aiagent.skill.virt.api.b r11, d.c.d<? super com.obric.aiagent.skill.virt.api.d> r12) {
        com.obric.aiagent.skill.virt.api.c r6 = (com.obric.aiagent.skill.virt.api.c) ZeusTransformUtils.wrapperContextForParams(r10, com.obric.aiagent.skill.virt.api.c.class, "com.obric.aiagent.plugin");
        d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new p(r9, this, r11, r6, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r13);
    }

    @Override // com.obric.aiagent.skill.virt.impl.a.k
    public Object a(final String r20, final String r21, String r22, String r23, Map<String, String> r24, String r25, d.h.a.b<? super com.obric.aiagent.skill.virt.api.r, d.x> r26, d.c.d<? super d.n<com.obric.aiagent.skill.virt.impl.a.f>> r27) {
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r24, Map.class, "com.obric.aiagent.plugin");
        final d.h.a.b r2 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r26, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r27, d.c.d.class, "com.obric.aiagent.plugin");
        if (this.h.a() == true) goto L7;
        d.n.a r0 = d.n.f38560a;
        return d.n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("VirtService is not available"), Throwable.class, "com.obric.aiagent.plugin")));
    L7:
        if (this.h.b() == true) goto L11;
        d.n.a r1 = d.n.f38560a;
        return d.n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("LXC async gateway is not available"), Throwable.class, "com.obric.aiagent.plugin")));
    L11:
        if (g() == true) goto L14;
        d.n.a r4 = d.n.f38560a;
        return d.n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("SafetyGuard proxy runtime is not available"), Throwable.class, "com.obric.aiagent.plugin")));
    L14:
        String r12 = a(r23);
        AtomicBoolean r13 = new AtomicBoolean(false);
        com.obric.aiagent.skill.virt.impl.a.f r14 = new com.obric.aiagent.skill.virt.impl.a.f(r20, r21, r22, (com.obric.aiagent.skill.virt.impl.a.g) ZeusTransformUtils.preCheckCast(new w(r13, this), com.obric.aiagent.skill.virt.impl.a.g.class, "com.obric.aiagent.plugin"), new $$Lambda$a$Ry5tJz5X3nYHETjbtzCsEWN47J8(r2, r21, r20), new $$Lambda$a$XCz1udCLrbx2x6AwWk06A0vH7yo(r2, r21, r20));
        kotlinx.coroutines.i.a(this.g, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new v(this, r12, r22, r20, r11, r25, r14, r13, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        d.n.a r5 = d.n.f38560a;
        return d.n.f(r14);
    }

    private static final d.x a(d.h.a.b r2, String r3, String r4, String r5) {
        d.h.a.b r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, MonitorConstants.CHUNK);
        r6.invoke(new com.obric.aiagent.skill.virt.api.r(r3, r4, com.obric.aiagent.skill.virt.api.s.f21602a, r5));
        return d.x.f38692a;
    }

    private static final d.x b(d.h.a.b r2, String r3, String r4, String r5) {
        d.h.a.b r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, MonitorConstants.CHUNK);
        r6.invoke(new com.obric.aiagent.skill.virt.api.r(r3, r4, com.obric.aiagent.skill.virt.api.s.f21603b, r5));
        return d.x.f38692a;
    }

    private final Object a(String r22, String r23, Map<String, String> r24, String r25, com.obric.aiagent.skill.virt.impl.a.f r26, AtomicBoolean r27, d.c.d<? super com.obric.aiagent.skill.virt.impl.a.c.c.a> r28) {
        Map<String, String> r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r24, Map.class, "com.obric.aiagent.plugin");
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r28, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, m.class) == false) goto L7;
        m r3 = (m) ZeusTransformUtils.preCheckCast(r2, m.class, "com.obric.aiagent.plugin");
        if ((r3.k & Integer.MIN_VALUE) == 0) goto L7;
        r3.k -= Integer.MIN_VALUE;
        a r4 = this;
    L8:
        Object r5 = r3.i;
        Object r6 = d.c.a.b.a();
        int r7 = r3.k;
        if (r7 == 0) goto L20;
        if (r7 != 1) goto L19;
        int r8 = r3.h;
        AtomicBoolean r9 = (AtomicBoolean) ZeusTransformUtils.preCheckCast(r3.g, AtomicBoolean.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.virt.impl.a.f r10 = (com.obric.aiagent.skill.virt.impl.a.f) ZeusTransformUtils.preCheckCast(r3.f, com.obric.aiagent.skill.virt.impl.a.f.class, "com.obric.aiagent.plugin");
        String r11 = (String) ZeusTransformUtils.preCheckCast(r3.f21973e, String.class, "com.obric.aiagent.plugin");
        Map<String, String> r12 = (Map) ZeusTransformUtils.preCheckCast(r3.f21972d, Map.class, "com.obric.aiagent.plugin");
        String r13 = (String) ZeusTransformUtils.preCheckCast(r3.f21971c, String.class, "com.obric.aiagent.plugin");
        String r14 = (String) ZeusTransformUtils.preCheckCast(r3.f21970b, String.class, "com.obric.aiagent.plugin");
        a r1 = (a) ZeusTransformUtils.preCheckCast(r3.f21969a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r5);     // Catch: Throwable -> L14 CancellationException -> L16
    L55:
        return r5;
    L14:
        th = move-exception;
        Throwable r15 = th;
        a r16 = r1;
        m r17 = r3;
        String r18 = r11;
        Map<String, String> r19 = r12;
        String r20 = r13;
        String r21 = r14;
        Object r110 = r6;
        com.obric.aiagent.skill.virt.impl.a.f r29 = r10;
    L36:
        if (r8 == 0) goto L38;
    L42:
        boolean r30 = false;
    L43:
        if (r30 == false) goto L49;
        int r111 = r8 + 1;
        if (IAppContext.Companion.isDebug() == false) goto L47;
        ILogDepend.Companion.w("Virt/Proxy", "Retrying LXC proxy after cold handshake failure executionId=" + r21);
    L48:
        r4 = r16;
    L21:
        if (r111 != 0) goto L23;
        long r31 = 0;
    L24:
        long r112 = r31;
        r17.f21969a = r4;     // Catch: CancellationException -> L16 Throwable -> L33
        r17.f21970b = r21;     // Catch: CancellationException -> L16 Throwable -> L33
        r17.f21971c = r20;     // Catch: CancellationException -> L16 Throwable -> L33
        r17.f21972d = r19;     // Catch: CancellationException -> L16 Throwable -> L33
        r17.f21973e = r18;     // Catch: CancellationException -> L16 Throwable -> L33
        r17.f = r29;     // Catch: CancellationException -> L16 Throwable -> L33
        r17.g = r9;     // Catch: CancellationException -> L16 Throwable -> L33
        r17.h = r111;     // Catch: CancellationException -> L16 Throwable -> L33
        r17.k = 1;     // Catch: CancellationException -> L16 Throwable -> L33
        Object r32 = r110;
        int r113 = r111;
        m r114 = r17;
        Map<String, String> r210 = r19;
        r5 = r4.a(r21, r20, r19, r18, r29, r112, r114);     // Catch: CancellationException -> L16 Throwable -> L31
        if (r5 != r32) goto L55;
        return r32;
    L31:
        th = move-exception;
        r110 = r32;
        r17 = r114;
        r19 = r210;
        r15 = th;
        r16 = r4;
        r8 = r113;
    L33:
        th = move-exception;
        r15 = th;
        r16 = r4;
        r8 = r111;
        goto L36
    L23:
        r31 = 5000;
        goto L24
    L47:
        ILogDepend.Companion.w("Virt/Proxy", "Retrying LXC proxy after cold handshake failure");
        goto L48
    L49:
        throw r15;
    L38:
        if (r9.get() == true) goto L42;
        if (r16.a(r15) == false) goto L42;
        r30 = true;
        goto L43
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        d.o.a(r5);
        r21 = r22;
        r20 = r23;
        r9 = r27;
        r19 = r0;
        r17 = r3;
        r110 = r6;
        r111 = 0;
        r18 = r25;
        r29 = r26;
    L16:
        e = move-exception;
        throw e;
    L7:
        r4 = this;
        r3 = new m(r4, r2);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v17, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v18, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r16v8 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28, types: [T] */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v51 */
    /* JADX WARN: Type inference failed for: r2v53 */
    /* JADX WARN: Type inference failed for: r2v68, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v69 */
    /* JADX WARN: Type inference failed for: r2v70 */
    /* JADX WARN: Type inference failed for: r2v71 */
    /* JADX WARN: Type inference failed for: r2v72, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v73 */
    /* JADX WARN: Type inference failed for: r2v74 */
    /* JADX WARN: Type inference failed for: r2v75, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v80 */
    /* JADX WARN: Type inference failed for: r2v83 */
    /* JADX WARN: Type inference failed for: r2v84 */
    /* JADX WARN: Type inference failed for: r2v85 */
    /* JADX WARN: Type inference failed for: r2v86 */
    /* JADX WARN: Type inference failed for: r2v87 */
    /* JADX WARN: Type inference failed for: r2v88 */
    /* JADX WARN: Type inference failed for: r2v89 */
    /* JADX WARN: Type inference failed for: r2v90 */
    /* JADX WARN: Type inference failed for: r2v92 */
    /* JADX WARN: Type inference failed for: r2v93 */
    /* JADX WARN: Type inference failed for: r2v94 */
    /* JADX WARN: Type inference failed for: r2v95 */
    private final Object a(String r30, String r31, Map<String, String> r32, String r33, com.obric.aiagent.skill.virt.impl.a.f r34, long r35, d.c.d<? super com.obric.aiagent.skill.virt.impl.a.c.c.a> r37) {
        a r7 = this;
        com.obric.aiagent.skill.virt.impl.a.f r8 = r34;
        String r11 = "com.obric.aiagent.plugin";
        Map<String, String> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r32, Map.class, "com.obric.aiagent.plugin");
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r37, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, d.class) == false) goto L7;
        d r3 = (d) ZeusTransformUtils.preCheckCast(r2, d.class, "com.obric.aiagent.plugin");
        if ((r3.q & Integer.MIN_VALUE) == 0) goto L7;
        r3.q -= Integer.MIN_VALUE;
    L8:
        d r12 = r3;
        Object r4 = r12.o;
        Object r13 = d.c.a.b.a();
        switch(r12.q) {
            case 0: goto L43;
            case 1: goto L38;
            case 2: goto L32;
            case 3: goto L26;
            case 4: goto L21;
            case 5: goto L20;
            case 6: goto L19;
            case 7: goto L14;
            case 8: goto L13;
            case 9: goto L12;
            default: goto L11;
        };
    L12:
        int r5 = r12.n;
        Throwable r6 = (Throwable) ZeusTransformUtils.preCheckCast(r12.f21952d, Throwable.class, "com.obric.aiagent.plugin");
        au<com.obric.aiagent.skill.virt.impl.a.c.c.a> r9 = (au) ZeusTransformUtils.preCheckCast(r12.f21951c, au.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.virt.impl.a.c.c.C0472c r10 = (com.obric.aiagent.skill.virt.impl.a.c.c.C0472c) ZeusTransformUtils.preCheckCast(r12.f21950b, com.obric.aiagent.skill.virt.impl.a.c.c.C0472c.class, "com.obric.aiagent.plugin");
        a r0 = (a) ZeusTransformUtils.preCheckCast(r12.f21949a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
        ?? r14 = "com.obric.aiagent.plugin";
        CancellationException r15 = null;
    L173:
        ca.a.a((ca) ZeusTransformUtils.preCheckCast(r9, ca.class, r14), r15, 1, r15);
        r0.a(r10.b());
        r0.a(r10.c());
        if (r5 != 0) goto L220;
        r0.a(r10.d());
        throw r6;
    L220:
        throw r6;
    L13:
        r5 = r12.n;
        r6 = (Throwable) ZeusTransformUtils.preCheckCast(r12.f21953e, Throwable.class, "com.obric.aiagent.plugin");
        r9 = (au) ZeusTransformUtils.preCheckCast(r12.f21952d, au.class, "com.obric.aiagent.plugin");
        List r16 = (List) ZeusTransformUtils.preCheckCast(r12.f21951c, List.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.virt.impl.a.c.c.C0472c r17 = (com.obric.aiagent.skill.virt.impl.a.c.c.C0472c) ZeusTransformUtils.preCheckCast(r12.f21950b, com.obric.aiagent.skill.virt.impl.a.c.c.C0472c.class, "com.obric.aiagent.plugin");
        r0 = (a) ZeusTransformUtils.preCheckCast(r12.f21949a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
        ?? r18 = "com.obric.aiagent.plugin";
        Object r19 = r13;
    L167:
        d.x r20 = d.x.f38692a;
        ?? r21 = r18;
    L169:
        r15 = null;
        d.h.a.m r22 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new g(r16, null), d.h.a.m.class, r21);
        r12.f21949a = r0;
        r12.f21950b = r17;
        r12.f21951c = r9;
        r12.f21952d = r6;
        r12.f21953e = null;
        r12.f = null;
        r12.g = null;
        r12.h = null;
        r12.i = null;
        r12.j = null;
        r12.k = null;
        r12.l = null;
        r12.m = null;
        r12.n = r5;
        r12.q = 9;
        if (dg.b(5000, r22, r12) != r19) goto L172;
        return r19;
    L172:
        r10 = r17;
        r14 = r21;
        goto L173
    L14:
        r5 = r12.n;
        Throwable r23 = (Throwable) ZeusTransformUtils.preCheckCast(r12.i, Throwable.class, "com.obric.aiagent.plugin");
        r9 = (au) ZeusTransformUtils.preCheckCast(r12.h, au.class, "com.obric.aiagent.plugin");
        r16 = (List) ZeusTransformUtils.preCheckCast(r12.g, List.class, "com.obric.aiagent.plugin");
        ActionContextToken r24 = (ActionContextToken) ZeusTransformUtils.preCheckCast(r12.f, ActionContextToken.class, "com.obric.aiagent.plugin");
        d.h.b.z.f r25 = (d.h.b.z.f) ZeusTransformUtils.preCheckCast(r12.f21953e, d.h.b.z.f.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.virt.impl.a.c.c.C0472c r26 = (com.obric.aiagent.skill.virt.impl.a.c.c.C0472c) ZeusTransformUtils.preCheckCast(r12.f21952d, com.obric.aiagent.skill.virt.impl.a.c.c.C0472c.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.virt.impl.a.f r110 = (com.obric.aiagent.skill.virt.impl.a.f) ZeusTransformUtils.preCheckCast(r12.f21951c, com.obric.aiagent.skill.virt.impl.a.f.class, "com.obric.aiagent.plugin");
        String r27 = (String) ZeusTransformUtils.preCheckCast(r12.f21950b, String.class, "com.obric.aiagent.plugin");
        a r111 = (a) ZeusTransformUtils.preCheckCast(r12.f21949a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r4);     // Catch: Throwable -> L17
        ?? r28 = "com.obric.aiagent.plugin";
        com.obric.aiagent.skill.virt.impl.a.f r112 = r110;
        r19 = r13;
    L195:
        throw r23;     // Catch: Throwable -> L153
    L153:
        th = move-exception;
        r6 = th;
        com.obric.aiagent.skill.virt.impl.a.c.c.C0472c r113 = r26;
        r0 = r111;
        ?? r29 = r28;
    L157:
        if (r24 == null) goto L161;
        ProxySession r36 = (ProxySession) ZeusTransformUtils.preCheckCast(r25.f38504a, ProxySession.class, r29);
        if (r36 == null) goto L161;
        r112.a(r0.a(r27, r113.a(), r36, r24));
        d.x r38 = d.x.f38692a;
    L161:
        ProxySession r39 = (ProxySession) ZeusTransformUtils.preCheckCast(r25.f38504a, ProxySession.class, r29);
        if (r39 == null) goto L168;
        String r40 = r113.a();
        r12.f21949a = r0;
        r12.f21950b = r113;
        r12.f21951c = r16;
        r12.f21952d = r9;
        r12.f21953e = r6;
        r12.f = null;
        r12.g = null;
        r12.h = null;
        r12.i = null;
        r12.j = null;
        r12.k = null;
        r12.l = null;
        r12.m = null;
        r12.n = r5;
        r12.q = 8;
        if (r0.a(r27, r40, r39, r12) != r19) goto L166;
        return r19;
    L166:
        r17 = r113;
        r18 = r29;
        goto L167
    L168:
        r17 = r113;
        r21 = r29;
    L17:
        th = move-exception;
        r6 = th;
        r113 = r26;
        r29 = "com.obric.aiagent.plugin";
        r0 = r111;
        r112 = r110;
        r19 = r13;
        goto L157
    L19:
        int r41 = r12.n;
        com.obric.aiagent.skill.virt.impl.a.c.c.a r42 = (com.obric.aiagent.skill.virt.impl.a.c.c.a) ZeusTransformUtils.preCheckCast(r12.f21952d, com.obric.aiagent.skill.virt.impl.a.c.c.a.class, "com.obric.aiagent.plugin");
        au<com.obric.aiagent.skill.virt.impl.a.c.c.a> r43 = (au) ZeusTransformUtils.preCheckCast(r12.f21951c, au.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.virt.impl.a.c.c.C0472c r44 = (com.obric.aiagent.skill.virt.impl.a.c.c.C0472c) ZeusTransformUtils.preCheckCast(r12.f21950b, com.obric.aiagent.skill.virt.impl.a.c.c.C0472c.class, "com.obric.aiagent.plugin");
        a r45 = (a) ZeusTransformUtils.preCheckCast(r12.f21949a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
        String r114 = "com.obric.aiagent.plugin";
        CancellationException r46 = null;
    L115:
        ca.a.a((ca) ZeusTransformUtils.preCheckCast(r43, ca.class, r114), r46, 1, r46);
        r45.a(r44.b());
        r45.a(r44.c());
        if (r41 != 0) goto L118;
        r45.a(r44.d());
    L118:
        return r42;
    L20:
        r41 = r12.n;
        r42 = (com.obric.aiagent.skill.virt.impl.a.c.c.a) ZeusTransformUtils.preCheckCast(r12.f21953e, com.obric.aiagent.skill.virt.impl.a.c.c.a.class, "com.obric.aiagent.plugin");
        r43 = (au) ZeusTransformUtils.preCheckCast(r12.f21952d, au.class, "com.obric.aiagent.plugin");
        List r47 = (List) ZeusTransformUtils.preCheckCast(r12.f21951c, List.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.virt.impl.a.c.c.C0472c r48 = (com.obric.aiagent.skill.virt.impl.a.c.c.C0472c) ZeusTransformUtils.preCheckCast(r12.f21950b, com.obric.aiagent.skill.virt.impl.a.c.c.C0472c.class, "com.obric.aiagent.plugin");
        r45 = (a) ZeusTransformUtils.preCheckCast(r12.f21949a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
        String r115 = "com.obric.aiagent.plugin";
        Object r116 = r13;
    L109:
        d.x r49 = d.x.f38692a;
        com.obric.aiagent.skill.virt.impl.a.c.c.C0472c r50 = r48;
        String r117 = r115;
    L111:
        r46 = null;
        d.h.a.m r51 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new g(r47, null), d.h.a.m.class, r117);
        r12.f21949a = r45;
        r12.f21950b = r50;
        r12.f21951c = r43;
        r12.f21952d = r42;
        r12.f21953e = null;
        r12.f = null;
        r12.g = null;
        r12.h = null;
        r12.i = null;
        r12.j = null;
        r12.k = null;
        r12.n = r41;
        r12.q = 6;
        if (dg.b(5000, r51, r12) != r116) goto L114;
        return r116;
    L114:
        r44 = r50;
        r114 = r117;
        goto L115
    L21:
        int r52 = r12.n;
        com.obric.aiagent.skill.virt.impl.a.c.c.a r53 = (com.obric.aiagent.skill.virt.impl.a.c.c.a) ZeusTransformUtils.preCheckCast(r12.k, com.obric.aiagent.skill.virt.impl.a.c.c.a.class, "com.obric.aiagent.plugin");
        au<com.obric.aiagent.skill.virt.impl.a.c.c.a> r54 = (au) ZeusTransformUtils.preCheckCast(r12.j, au.class, "com.obric.aiagent.plugin");
        List r55 = (List) ZeusTransformUtils.preCheckCast(r12.i, List.class, "com.obric.aiagent.plugin");
        AtomicBoolean r56 = (AtomicBoolean) ZeusTransformUtils.preCheckCast(r12.h, AtomicBoolean.class, "com.obric.aiagent.plugin");
        AtomicBoolean r57 = (AtomicBoolean) ZeusTransformUtils.preCheckCast(r12.g, AtomicBoolean.class, "com.obric.aiagent.plugin");
        ActionContextToken r58 = (ActionContextToken) ZeusTransformUtils.preCheckCast(r12.f, ActionContextToken.class, "com.obric.aiagent.plugin");
        d.h.b.z.f r59 = (d.h.b.z.f) ZeusTransformUtils.preCheckCast(r12.f21953e, d.h.b.z.f.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.virt.impl.a.c.c.C0472c r118 = (com.obric.aiagent.skill.virt.impl.a.c.c.C0472c) ZeusTransformUtils.preCheckCast(r12.f21952d, com.obric.aiagent.skill.virt.impl.a.c.c.C0472c.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.virt.impl.a.f r119 = (com.obric.aiagent.skill.virt.impl.a.f) ZeusTransformUtils.preCheckCast(r12.f21951c, com.obric.aiagent.skill.virt.impl.a.f.class, "com.obric.aiagent.plugin");
        String r60 = (String) ZeusTransformUtils.preCheckCast(r12.f21950b, String.class, "com.obric.aiagent.plugin");
        a r120 = (a) ZeusTransformUtils.preCheckCast(r12.f21949a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r4);     // Catch: Throwable -> L24
        ActionContextToken r61 = r58;
        r8 = r119;
        String r121 = r60;
        int r62 = r52;
        r47 = r55;
        r43 = r54;
        r42 = r53;
        AtomicBoolean r122 = r56;
        Object r63 = r13;
        d.h.b.z.f r123 = r59;
        r50 = r118;
        AtomicBoolean r124 = r57;
        r7 = r120;
        String r125 = "com.obric.aiagent.plugin";
    L193:
        Object r126 = r63;
        int r127 = r62;
        r7.a(r42.b(), r124.get(), (d.h.a.b) ZeusTransformUtils.preCheckCast(new e(r8), d.h.a.b.class, r125));     // Catch: Throwable -> L119
        r7.a(r42.c(), r122.get(), (d.h.a.b) ZeusTransformUtils.preCheckCast(new f(r8), d.h.a.b.class, r125));     // Catch: Throwable -> L119
        if (r61 == null) goto L103;
        ProxySession r64 = (ProxySession) ZeusTransformUtils.preCheckCast(r123.f38504a, ProxySession.class, r125);
        if (r64 == null) goto L103;
        r8.a(r7.a(r121, r50.a(), r64, r61));
        d.x r65 = d.x.f38692a;
    L103:
        ProxySession r66 = (ProxySession) ZeusTransformUtils.preCheckCast(r123.f38504a, ProxySession.class, r125);
        if (r66 == null) goto L110;
        String r67 = r50.a();
        r12.f21949a = r7;
        r12.f21950b = r50;
        r12.f21951c = r47;
        r12.f21952d = r43;
        r12.f21953e = r42;
        r12.f = null;
        r12.g = null;
        r12.h = null;
        r12.i = null;
        r12.j = null;
        r12.k = null;
        r12.n = r127;
        r12.q = 5;
        r116 = r126;
        if (r7.a(r121, r67, r66, r12) != r116) goto L108;
        return r116;
    L108:
        r41 = r127;
        r45 = r7;
        r48 = r50;
        r115 = r125;
        goto L109
    L110:
        r116 = r126;
        r41 = r127;
        r45 = r7;
        r117 = r125;
    L119:
        th = th;
        int r68 = r127;
    L123:
        r19 = r126;
    L126:
        r23 = th;
        r60 = r121;
        r113 = r50;
        ActionContextToken r69 = r61;
        ?? r70 = r125;
        d.h.b.z.f r128 = r123;
        List r210 = r47;
        r9 = r43;
        r55 = r210;
    L201:
        r12.f21949a = r7;     // Catch: Throwable -> L155
        r12.f21950b = r60;     // Catch: Throwable -> L155
        r12.f21951c = r8;     // Catch: Throwable -> L155
        r12.f21952d = r113;     // Catch: Throwable -> L155
        r12.f21953e = r128;     // Catch: Throwable -> L155
        r12.f = r69;     // Catch: Throwable -> L155
        r12.g = r55;     // Catch: Throwable -> L155
        r12.h = r9;     // Catch: Throwable -> L155
        r12.i = r23;     // Catch: Throwable -> L155
        r12.j = null;     // Catch: Throwable -> L155
        r12.k = null;     // Catch: Throwable -> L155
        r12.l = null;     // Catch: Throwable -> L155
        r12.m = null;     // Catch: Throwable -> L155
        r12.n = r68;     // Catch: Throwable -> L155
        r12.q = 7;     // Catch: Throwable -> L155
        if (r7.a(r60, r9, r12) != r19) goto L151;
        return r19;
    L151:
        r112 = r8;
        r25 = r128;
        r111 = r7;
        r24 = r69;
        r26 = r113;
        List r211 = r55;
        r27 = r60;
        r5 = r68;
        r16 = r211;
        r28 = r70;
    L155:
        th = move-exception;
        r6 = th;
        r0 = r7;
        r112 = r8;
        r24 = r69;
        r25 = r128;
        List r212 = r55;
        r27 = r60;
        r5 = r68;
        r16 = r212;
        r29 = r70;
    L121:
        th = th;
        r68 = r62;
    L124:
        th = th;
        r19 = r63;
        r68 = r62;
    L24:
        th = move-exception;
        r68 = r52;
        r7 = r120;
        r9 = r54;
        r128 = r59;
        r23 = th;
        r69 = r58;
        r8 = r119;
        r113 = r118;
    L31:
        r19 = r13;
        r70 = r11;
        goto L201
    L26:
        r68 = r12.n;
        au<com.obric.aiagent.skill.virt.impl.a.c.c.a> r71 = (au) ZeusTransformUtils.preCheckCast(r12.j, au.class, "com.obric.aiagent.plugin");
        List r72 = (List) ZeusTransformUtils.preCheckCast(r12.i, List.class, "com.obric.aiagent.plugin");
        AtomicBoolean r73 = (AtomicBoolean) ZeusTransformUtils.preCheckCast(r12.h, AtomicBoolean.class, "com.obric.aiagent.plugin");
        AtomicBoolean r74 = (AtomicBoolean) ZeusTransformUtils.preCheckCast(r12.g, AtomicBoolean.class, "com.obric.aiagent.plugin");
        ActionContextToken r75 = (ActionContextToken) ZeusTransformUtils.preCheckCast(r12.f, ActionContextToken.class, "com.obric.aiagent.plugin");
        d.h.b.z.f r76 = (d.h.b.z.f) ZeusTransformUtils.preCheckCast(r12.f21953e, d.h.b.z.f.class, "com.obric.aiagent.plugin");
        r50 = (com.obric.aiagent.skill.virt.impl.a.c.c.C0472c) ZeusTransformUtils.preCheckCast(r12.f21952d, com.obric.aiagent.skill.virt.impl.a.c.c.C0472c.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.virt.impl.a.f r129 = (com.obric.aiagent.skill.virt.impl.a.f) ZeusTransformUtils.preCheckCast(r12.f21951c, com.obric.aiagent.skill.virt.impl.a.f.class, "com.obric.aiagent.plugin");
        r121 = (String) ZeusTransformUtils.preCheckCast(r12.f21950b, String.class, "com.obric.aiagent.plugin");
        a r130 = (a) ZeusTransformUtils.preCheckCast(r12.f21949a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r4);     // Catch: Throwable -> L29
        r122 = r73;
        ActionContextToken r77 = r75;
        r7 = r130;
        String r131 = "com.obric.aiagent.plugin";
        r124 = r74;
        r63 = r13;
        r123 = r76;
        r8 = r129;
        Object r78 = r4;
    L206:
        com.obric.aiagent.skill.virt.impl.a.c.c.a r79 = (com.obric.aiagent.skill.virt.impl.a.c.c.a) ZeusTransformUtils.preCheckCast(r78, com.obric.aiagent.skill.virt.impl.a.c.c.a.class, r131);     // Catch: Throwable -> L127
        Collection r80 = (Collection) ZeusTransformUtils.preCheckCast(r72, Collection.class, r131);     // Catch: Throwable -> L127
        r12.f21949a = r7;     // Catch: Throwable -> L127
        r12.f21950b = r121;     // Catch: Throwable -> L127
        r12.f21951c = r8;     // Catch: Throwable -> L127
        r12.f21952d = r50;     // Catch: Throwable -> L127
        r12.f21953e = r123;     // Catch: Throwable -> L127
        r12.f = r77;     // Catch: Throwable -> L127
        r12.g = r124;     // Catch: Throwable -> L127
        r12.h = r122;     // Catch: Throwable -> L127
        r12.i = r72;     // Catch: Throwable -> L127
        r12.j = r71;     // Catch: Throwable -> L127
        r12.k = r79;     // Catch: Throwable -> L127
        r12.n = r68;     // Catch: Throwable -> L127
        r12.q = 4;     // Catch: Throwable -> L127
        if (kotlinx.coroutines.f.b(r80, r12) != r63) goto L93;
        return r63;
    L93:
        r61 = r77;
        r43 = r71;
        r62 = r68;
        r47 = r72;
        r42 = r79;
        r125 = r131;
    L127:
        th = th;
        r19 = r63;
        r68 = r68;
        String r81 = r131;
        r9 = r71;
        r128 = r123;
        r60 = r121;
        r113 = r50;
        r69 = r77;
    L60:
        r55 = r72;
        ?? r82 = r81;
    L37:
        r23 = th;
        r70 = r82;
    L29:
        th = move-exception;
        r55 = r72;
        r68 = r68;
        r23 = th;
        r9 = r71;
        r60 = r121;
        r113 = r50;
        r69 = r75;
        r7 = r130;
        r128 = r76;
        r8 = r129;
        goto L31
    L32:
        r68 = r12.n;
        d.h.b.z.f r83 = (d.h.b.z.f) ZeusTransformUtils.preCheckCast(r12.m, d.h.b.z.f.class, "com.obric.aiagent.plugin");
        au<com.obric.aiagent.skill.virt.impl.a.c.c.a> r84 = (au) ZeusTransformUtils.preCheckCast(r12.l, au.class, "com.obric.aiagent.plugin");
        r55 = (List) ZeusTransformUtils.preCheckCast(r12.k, List.class, "com.obric.aiagent.plugin");
        b r85 = (b) ZeusTransformUtils.preCheckCast(r12.j, b.class, "com.obric.aiagent.plugin");
        b r86 = (b) ZeusTransformUtils.preCheckCast(r12.i, b.class, "com.obric.aiagent.plugin");
        AtomicBoolean r87 = (AtomicBoolean) ZeusTransformUtils.preCheckCast(r12.h, AtomicBoolean.class, "com.obric.aiagent.plugin");
        AtomicBoolean r88 = (AtomicBoolean) ZeusTransformUtils.preCheckCast(r12.g, AtomicBoolean.class, "com.obric.aiagent.plugin");
        d.h.b.z.f r132 = (d.h.b.z.f) ZeusTransformUtils.preCheckCast(r12.f, d.h.b.z.f.class, "com.obric.aiagent.plugin");
        r113 = (com.obric.aiagent.skill.virt.impl.a.c.c.C0472c) ZeusTransformUtils.preCheckCast(r12.f21953e, com.obric.aiagent.skill.virt.impl.a.c.c.C0472c.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.virt.impl.a.f r89 = (com.obric.aiagent.skill.virt.impl.a.f) ZeusTransformUtils.preCheckCast(r12.f21952d, com.obric.aiagent.skill.virt.impl.a.f.class, "com.obric.aiagent.plugin");
        String r90 = (String) ZeusTransformUtils.preCheckCast(r12.f21951c, String.class, "com.obric.aiagent.plugin");
        r60 = (String) ZeusTransformUtils.preCheckCast(r12.f21950b, String.class, "com.obric.aiagent.plugin");
        a r133 = (a) ZeusTransformUtils.preCheckCast(r12.f21949a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r4);     // Catch: Throwable -> L35
        String r91 = r90;
        String r134 = "com.obric.aiagent.plugin";
        r19 = r13;
        b r135 = r86;
        r124 = r88;
        r128 = r132;
        r7 = r133;
        r128 = r83;
        r122 = r87;
        r8 = r89;
        ?? r92 = r4;
    L203:
        r128.f38504a = r92;     // Catch: Throwable -> L131
        r135.a();     // Catch: Throwable -> L131
        r85.a();     // Catch: Throwable -> L131
        if (r91 != null) goto L212;
        String r136 = r134;
        ActionContextToken r93 = null;
    L179:
        r12.f21949a = r7;     // Catch: Throwable -> L129
        r12.f21950b = r60;     // Catch: Throwable -> L129
        r12.f21951c = r8;     // Catch: Throwable -> L129
        r12.f21952d = r113;     // Catch: Throwable -> L129
        r12.f21953e = r128;     // Catch: Throwable -> L129
        r12.f = r93;     // Catch: Throwable -> L129
        r12.g = r124;     // Catch: Throwable -> L129
        r12.h = r122;     // Catch: Throwable -> L129
        r12.i = r55;     // Catch: Throwable -> L129
        r12.j = r84;     // Catch: Throwable -> L129
        r12.k = null;     // Catch: Throwable -> L129
        r12.l = null;     // Catch: Throwable -> L129
        r12.m = null;     // Catch: Throwable -> L129
        r12.n = r68;     // Catch: Throwable -> L129
        r12.q = 3;     // Catch: Throwable -> L129
        Object r94 = r84.a(r12);     // Catch: Throwable -> L129
        r63 = r19;
        if (r94 != r63) goto L89;
        return r63;
    L89:
        r123 = r128;
        r50 = r113;
        r121 = r60;
        r71 = r84;
        r72 = r55;
        r77 = r93;
        r78 = r94;
        r131 = r136;
    L129:
        th = move-exception;
        r19 = r19;
        r68 = r68;
        r9 = r84;
        r23 = th;
        d.h.b.z.f r213 = r128;
        r69 = r93;
        r70 = r136;
        r128 = r213;
        goto L201
    L212:
        String r95 = r113.a();     // Catch: Throwable -> L82
        Object r96 = r128.f38504a;     // Catch: Throwable -> L82
        if (r96 == null) goto L79;
        String r137 = r134;
        r93 = r7.a(r60, r95, (ProxySession) ZeusTransformUtils.preCheckCast(r96, ProxySession.class, r137), r91);     // Catch: Throwable -> L80
        r136 = r137;
        goto L179
    L79:
        throw new IllegalArgumentException("Required value was null.".toString());     // Catch: Throwable -> L80
    L80:
        th = th;
        r68 = r68;
        ?? r97 = r128;
        r19 = r19;
        r9 = r84;
        r128 = r128;
    L147:
        r69 = null;
        r82 = r97;
    L82:
        th = th;
    L133:
        r69 = null;
        r9 = r84;
        r82 = r134;
    L131:
        th = th;
    L35:
        th = th;
        r8 = r89;
        r68 = r68;
        r82 = "com.obric.aiagent.plugin";
        r7 = r133;
        r69 = null;
        r9 = r84;
        r128 = r132;
        r19 = r13;
        goto L37
    L38:
        int r98 = r12.n;
        au<com.obric.aiagent.skill.virt.impl.a.c.c.a> r99 = (au) ZeusTransformUtils.preCheckCast(r12.l, au.class, "com.obric.aiagent.plugin");
        r72 = (List) ZeusTransformUtils.preCheckCast(r12.k, List.class, "com.obric.aiagent.plugin");
        b r100 = (b) ZeusTransformUtils.preCheckCast(r12.j, b.class, "com.obric.aiagent.plugin");
        b r101 = (b) ZeusTransformUtils.preCheckCast(r12.i, b.class, "com.obric.aiagent.plugin");
        AtomicBoolean r102 = (AtomicBoolean) ZeusTransformUtils.preCheckCast(r12.h, AtomicBoolean.class, "com.obric.aiagent.plugin");
        AtomicBoolean r103 = (AtomicBoolean) ZeusTransformUtils.preCheckCast(r12.g, AtomicBoolean.class, "com.obric.aiagent.plugin");
        d.h.b.z.f r138 = (d.h.b.z.f) ZeusTransformUtils.preCheckCast(r12.f, d.h.b.z.f.class, "com.obric.aiagent.plugin");
        r113 = (com.obric.aiagent.skill.virt.impl.a.c.c.C0472c) ZeusTransformUtils.preCheckCast(r12.f21953e, com.obric.aiagent.skill.virt.impl.a.c.c.C0472c.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.virt.impl.a.f r104 = (com.obric.aiagent.skill.virt.impl.a.f) ZeusTransformUtils.preCheckCast(r12.f21952d, com.obric.aiagent.skill.virt.impl.a.f.class, "com.obric.aiagent.plugin");
        String r105 = (String) ZeusTransformUtils.preCheckCast(r12.f21951c, String.class, "com.obric.aiagent.plugin");
        r60 = (String) ZeusTransformUtils.preCheckCast(r12.f21950b, String.class, "com.obric.aiagent.plugin");
        a r139 = (a) ZeusTransformUtils.preCheckCast(r12.f21949a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r4);     // Catch: Throwable -> L41
        au<com.obric.aiagent.skill.virt.impl.a.c.c.a> r106 = r99;
        r91 = r105;
        r8 = r104;
        AtomicBoolean r107 = r102;
        r135 = r101;
        r7 = r139;
        r128 = r138;
        AtomicBoolean r140 = r103;
        r19 = r13;
    L54:
        int r310 = r98;
        AtomicBoolean r214 = r107;
        r85 = r100;
        AtomicBoolean r108 = r214;
    L191:
        ParcelFileDescriptor r109 = r113.d();     // Catch: Throwable -> L144
        if (r109 == null) goto L187;
        String r141 = "com.obric.aiagent.plugin";
        String r142 = r113.a();     // Catch: Throwable -> L136
        r12.f21949a = r7;     // Catch: Throwable -> L136
        r12.f21950b = r60;     // Catch: Throwable -> L136
        r12.f21951c = r91;     // Catch: Throwable -> L136
        r12.f21952d = r8;     // Catch: Throwable -> L136
        r12.f21953e = r113;     // Catch: Throwable -> L136
        r12.f = r128;     // Catch: Throwable -> L136
        r12.g = r140;     // Catch: Throwable -> L136
        r12.h = r108;     // Catch: Throwable -> L136
        r12.i = r135;     // Catch: Throwable -> L136
        r12.j = r85;     // Catch: Throwable -> L136
        r12.k = r72;     // Catch: Throwable -> L136
        r12.l = r106;     // Catch: Throwable -> L136
        r12.m = r128;     // Catch: Throwable -> L136
        au<com.obric.aiagent.skill.virt.impl.a.c.c.a> r143 = r106;
        r12.n = 1;     // Catch: Throwable -> L134
        r12.q = 2;     // Catch: Throwable -> L134
        Object r144 = r7.a(r60, r142, r109, r12);     // Catch: Throwable -> L134
        if (r144 != r19) goto L70;
        return r19;
    L70:
        r19 = r19;
        r124 = r140;
        r128 = r128;
        r68 = 1;
        r122 = r108;
        r55 = r72;
        r84 = r143;
        r92 = r144;
        r134 = r141;
    L134:
        th = th;
    L138:
        r19 = r19;
        r97 = r141;
        r55 = r72;
        r9 = r143;
        r68 = 1;
    L136:
        th = th;
        r143 = r106;
        goto L138
    L187:
        a(r7, r60, "proxy_fd_missing", null, 4, null);     // Catch: Throwable -> L142
        throw new d.d();     // Catch: Throwable -> L142
    L142:
        th = th;
    L146:
        r68 = r310;
        r55 = r72;
        r9 = r106;
        r97 = r11;
    L144:
        th = th;
    L41:
        th = move-exception;
        r55 = r72;
        r8 = r104;
        r70 = "com.obric.aiagent.plugin";
        r7 = r139;
        r69 = null;
        r23 = th;
        r68 = r98;
        r128 = r138;
        r19 = r13;
        r9 = r99;
        goto L201
    L43:
        d.o.a(r4);
        r113 = r7.h.a(r31, r1);
        if (r113 == null) goto L177;
        r128 = new d.h.b.z.f();
        AtomicBoolean r145 = new AtomicBoolean(false);
        AtomicBoolean r146 = new AtomicBoolean(false);
        b r147 = new b((d.h.a.b) ZeusTransformUtils.preCheckCast(new l(r8), d.h.a.b.class, "com.obric.aiagent.plugin"));
        b r148 = new b((d.h.a.b) ZeusTransformUtils.preCheckCast(new k(r8), d.h.a.b.class, "com.obric.aiagent.plugin"));
        r72 = d.a.p.b(new ca[]{kotlinx.coroutines.i.a(r7.g, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new h(this, r113, r145, r147, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null), kotlinx.coroutines.i.a(r7.g, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new i(this, r113, r146, r148, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null)});
        r106 = kotlinx.coroutines.i.b(r7.g, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new j(r7, r113, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        if (r35 > 0) goto L189;
        r19 = r13;
        r91 = r33;
        r135 = r147;
        r60 = r30;
        r140 = r145;
        r108 = r146;
        r85 = r148;
        r310 = 0;
        goto L191
    L189:
        r12.f21949a = r7;     // Catch: Throwable -> L57
        String r149 = r30;
        r12.f21950b = r149;     // Catch: Throwable -> L55
        r91 = r33;
        r12.f21951c = r91;     // Catch: Throwable -> L55
        r12.f21952d = r8;     // Catch: Throwable -> L55
        r12.f21953e = r113;     // Catch: Throwable -> L55
        r12.f = r128;     // Catch: Throwable -> L55
        r12.g = r145;     // Catch: Throwable -> L55
        r107 = r146;
        r12.h = r107;     // Catch: Throwable -> L55
        r135 = r147;
        r12.i = r135;     // Catch: Throwable -> L55
        r12.j = r148;     // Catch: Throwable -> L55
        r12.k = r72;     // Catch: Throwable -> L55
        r12.l = r106;     // Catch: Throwable -> L55
        r12.n = 0;     // Catch: Throwable -> L55
        r12.q = 1;     // Catch: Throwable -> L55
        r19 = r13;
        if (ax.a(r35, r12) != r19) goto L53;
        return r19;
    L53:
        r60 = r149;
        r140 = r145;
        r100 = r148;
        r98 = 0;
    L55:
        th = th;
    L59:
        r19 = r13;
        r9 = r106;
        r60 = r149;
        r81 = "com.obric.aiagent.plugin";
        r68 = 0;
        r69 = null;
    L57:
        th = th;
        r149 = r30;
        goto L59
    L177:
        b(r30);
        throw new d.d();
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r3 = new d(r7, r2);
        goto L8
    }

    private final void a(String r2, boolean r3, d.h.a.b<? super String, d.x> r4) {
        d.h.a.b r1 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L8;
        return;
    L8:
        if (r3 == true) goto L11;
        r1.invoke(r2);
        return;
    L11:
        return;
    L5:
        r5 = false;
        goto L6
    }

    private final String a(String r3, String r4) {
        String r5 = c(r3);
        String r2 = c(h());
        StringBuilder r0 = new StringBuilder();
        r0.append("mkdir -p ").append(r5);
        r0.append(" && cd ").append(r5);
        r0.append(" && export HOME=").append(r2).append("; ");
        r0.append(r4);
        String r6 = r0.toString();
        d.h.b.o.c(r6, "toString(...)");
        if (IAppContext.Companion.isDebug() == false) goto L5;
        ILogDepend.Companion.i("Virt/Lxc", "buildWrappedCommand: finalCommand=" + r6);
    L5:
        return r6;
    }

    private final Map<String, String> a(Map<String, String> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        return ao.a(ao.a(d.s.a("HOME", h())), r4);
    }

    private final Object a(String r26, String r27, d.c.d<? super com.obric.aiagent.skill.virt.impl.a.c.a> r28) {
        a r1 = this;
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r28, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, n.class) == false) goto L7;
        n r3 = (n) ZeusTransformUtils.preCheckCast(r0, n.class, "com.obric.aiagent.plugin");
        if ((r3.h & Integer.MIN_VALUE) == 0) goto L7;
        r3.h -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.f;
        Object r4 = d.c.a.b.a();
        int r5 = r3.h;
        if (r5 == 0) goto L20;
        if (r5 != 1) goto L19;
        int r6 = r3.f21978e;
        long r7 = r3.f21977d;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r3.f21976c, String.class, "com.obric.aiagent.plugin");
        String r9 = (String) ZeusTransformUtils.preCheckCast(r3.f21975b, String.class, "com.obric.aiagent.plugin");
        a r10 = (a) ZeusTransformUtils.preCheckCast(r3.f21974a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r2);     // Catch: Throwable -> L14 CancellationException -> L16
        long r23 = r7;
        String r11 = r8;
        int r12 = r6;
        r1 = r10;
        String r13 = r9;
    L86:
        com.obric.aiagent.skill.virt.impl.a.c r14 = (com.obric.aiagent.skill.virt.impl.a.c) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.skill.virt.impl.a.c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L50 CancellationException -> L52
        com.obric.aiagent.skill.virt.impl.c.b r15 = r1.f21924c;     // Catch: Throwable -> L50 CancellationException -> L52
        if (ZeusTransformUtils.instanceOf(r14, com.obric.aiagent.skill.virt.impl.a.c.a.class) == false) goto L33;
        com.obric.aiagent.skill.virt.impl.c.b.c r16 = (com.obric.aiagent.skill.virt.impl.c.b.c) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.virt.impl.c.b.c.C0477b(((com.obric.aiagent.skill.virt.impl.a.c.a) ZeusTransformUtils.preCheckCast(r14, com.obric.aiagent.skill.virt.impl.a.c.a.class, "com.obric.aiagent.plugin")).c()), com.obric.aiagent.skill.virt.impl.c.b.c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L50 CancellationException -> L52
    L35:
        r15.a(r11, "lxc", r13, r16, true, r23, 0, 0, r14.a().length(), r14.b().length());     // Catch: Throwable -> L50 CancellationException -> L52
    L46:
        e = e;
        r12 = 1;
        long r17 = r23;
        String r18 = r13;
    L73:
        if (r12 != 0) goto L75;
        r1.f21924c.a(r11, "lxc", r18, (com.obric.aiagent.skill.virt.impl.c.b.c) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.virt.impl.c.b.c.a.f22160a, com.obric.aiagent.skill.virt.impl.c.b.c.class, "com.obric.aiagent.plugin"), true, r17, 0, 0, 0, 0);
    L75:
        throw e;
    L44:
        th = th;
        r12 = 1;
        long r19 = r23;
        String r20 = r13;
    L66:
        if (r12 != 0) goto L68;
        r1.f21924c.a(r11, "lxc", r20, (com.obric.aiagent.skill.virt.impl.c.b.c) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.virt.impl.c.b.c.C0478c.f22162a, com.obric.aiagent.skill.virt.impl.c.b.c.class, "com.obric.aiagent.plugin"), false, r19, 0, 0, 0, 0);
    L68:
        throw th;
    L37:
        if (ZeusTransformUtils.instanceOf(r14, com.obric.aiagent.skill.virt.impl.a.c.a.class) == false) goto L39;
        com.obric.aiagent.skill.virt.impl.a.c.a r21 = (com.obric.aiagent.skill.virt.impl.a.c.a) ZeusTransformUtils.preCheckCast(r14, com.obric.aiagent.skill.virt.impl.a.c.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L44 CancellationException -> L46
    L40:
        if (r21 == null) goto L43;
        return r21;
    L43:
        throw new IllegalStateException("LXC file command timed out");     // Catch: Throwable -> L44 CancellationException -> L46
    L39:
        r21 = null;
        goto L40
    L33:
        if (ZeusTransformUtils.instanceOf(r14, com.obric.aiagent.skill.virt.impl.a.c.b.class) == false) goto L49;
        r16 = (com.obric.aiagent.skill.virt.impl.c.b.c) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.virt.impl.c.b.c.d.f22163a, com.obric.aiagent.skill.virt.impl.c.b.c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L50 CancellationException -> L52
        goto L35
    L49:
        throw new d.k();     // Catch: Throwable -> L50 CancellationException -> L52
    L52:
        e = e;
        r18 = r13;
        r17 = r23;
    L50:
        th = th;
        r20 = r13;
        r19 = r23;
        goto L66
    L16:
        e = e;
        r17 = r7;
        r11 = r8;
        r18 = r9;
        r12 = r6;
        r1 = r10;
    L14:
        th = th;
        r19 = r7;
        r11 = r8;
        r20 = r9;
        r12 = r6;
        r1 = r10;
        goto L66
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        d.o.a(r2);
        long r22 = SystemClock.elapsedRealtime();
        r12 = 0;
        com.obric.aiagent.skill.virt.impl.a.b r24 = new com.obric.aiagent.skill.virt.impl.a.b(r26, h(), 60000, r27);     // Catch: Throwable -> L62 CancellationException -> L69
        r3.f21974a = r1;     // Catch: Throwable -> L62 CancellationException -> L69
        String r25 = r26;
        r3.f21975b = r25;     // Catch: Throwable -> L58 CancellationException -> L60
        String r110 = r27;
        r3.f21976c = r110;     // Catch: Throwable -> L54 CancellationException -> L56
        r3.f21977d = r22;     // Catch: Throwable -> L54 CancellationException -> L56
        r3.f21978e = 0;     // Catch: Throwable -> L54 CancellationException -> L56
        r3.h = 1;     // Catch: Throwable -> L54 CancellationException -> L56
        r2 = r1.b(r24, r3);     // Catch: Throwable -> L54 CancellationException -> L56
        if (r2 != r4) goto L28;
        return r4;
    L28:
        r23 = r22;
        r13 = r25;
        r11 = r110;
        goto L86
    L56:
        e = e;
    L72:
        r18 = r25;
        r11 = r110;
        r17 = r22;
    L54:
        th = th;
    L65:
        r20 = r25;
        r11 = r110;
        r19 = r22;
        goto L66
    L60:
        e = e;
    L71:
        r110 = r27;
    L58:
        th = th;
    L64:
        r110 = r27;
        goto L65
    L69:
        e = e;
        r25 = r26;
    L62:
        th = th;
        r25 = r26;
    L7:
        r3 = new n(r1, r0);
        goto L8
    }

    @Override // com.obric.aiagent.skill.virt.impl.a.k
    public Object a(com.obric.aiagent.skill.virt.impl.a.b r3, d.c.d<? super com.obric.aiagent.skill.virt.impl.a.c> r4) {
        return b(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    private final Object b(com.obric.aiagent.skill.virt.impl.a.b r5, d.c.d<? super com.obric.aiagent.skill.virt.impl.a.c> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new o(this, r5, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r7);
    }

    private final Object a(au<com.obric.aiagent.skill.virt.impl.a.c.c.a> r5, d.c.d<? super com.obric.aiagent.skill.virt.impl.a.c.c.a> r6) {
        au r7 = (au) ZeusTransformUtils.wrapperContextForParams(r5, au.class, "com.obric.aiagent.plugin");
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(co.f39209b, d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new aa(this, r7, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r8);
    }

    private final boolean g() {
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L5
        Object r2 = d.n.f(Boolean.valueOf(((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).e().isAvailable()));     // Catch: Throwable -> L5
    L7:
        Throwable r3 = d.n.c(r2);
        if (r3 == null) goto L11;
        a("Virt/Proxy", "proxyRuntime availability check failed", "proxyRuntime availability check failed: " + r3.getClass().getSimpleName(), r3);
    L11:
        if (d.n.b(r2) == false) goto L14;
        r2 = false;
    L14:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L5:
        th = move-exception;
        d.n.a r4 = d.n.f38560a;
        r2 = d.n.f(d.o.a(th));
        goto L7
    }

    private final Void b(String r4) {
        if (IAppContext.Companion.isDebug() == false) goto L5;
        ILogDepend.Companion.e("Virt/Lxc", "LXC async streaming start failed id=" + r4);
    L7:
        throw new IllegalStateException("Shell session failed to start");
    L5:
        ILogDepend.Companion.e("Virt/Lxc", "LXC async streaming start failed");
        goto L7
    }

    static /* synthetic */ Void a(a r0, String r1, String r2, Throwable r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = null;
    L6:
        return r0.a(r1, r2, r3);
    }

    private final Void a(String r4, String r5, Throwable r6) {
        if (IAppContext.Companion.isDebug() == false) goto L5;
        ILogDepend.Companion.e("Virt/Lxc", "LXC proxy start failed id=" + r4 + " reason=" + r5, r6);
    L7:
        throw new IllegalStateException("Shell gateway failed to start", r6);
    L5:
        ILogDepend.Companion.e("Virt/Lxc", "LXC proxy start failed");
        goto L7
    }

    private final Object a(String r19, String r20, ParcelFileDescriptor r21, d.c.d<? super ProxySession> r22) {
        a r1 = this;
        String r2 = r19;
        String r3 = r20;
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r22, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, x.class) == false) goto L7;
        x r6 = (x) ZeusTransformUtils.preCheckCast(r4, x.class, "com.obric.aiagent.plugin");
        if ((r6.h & Integer.MIN_VALUE) == 0) goto L7;
        r6.h -= Integer.MIN_VALUE;
    L8:
        Object r5 = r6.f;
        Object r7 = d.c.a.b.a();
        int r8 = r6.h;
        if (r8 == 0) goto L21;
        if (r8 == 1) goto L15;
        if (r8 != 2) goto L13;
        Throwable r9 = (Throwable) ZeusTransformUtils.preCheckCast(r6.f22013c, Throwable.class, "com.obric.aiagent.plugin");
        r2 = (String) ZeusTransformUtils.preCheckCast(r6.f22012b, String.class, "com.obric.aiagent.plugin");
        a r0 = (a) ZeusTransformUtils.preCheckCast(r6.f22011a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r5);
    L46:
        r0.a(r2, "proxy_ready_failed", r9);
        throw new d.d();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r10 = r6.f22015e;
        ProxySession r11 = (ProxySession) ZeusTransformUtils.preCheckCast(r6.f22014d, ProxySession.class, "com.obric.aiagent.plugin");
        String r12 = (String) ZeusTransformUtils.preCheckCast(r6.f22013c, String.class, "com.obric.aiagent.plugin");
        String r13 = (String) ZeusTransformUtils.preCheckCast(r6.f22012b, String.class, "com.obric.aiagent.plugin");
        a r14 = (a) ZeusTransformUtils.preCheckCast(r6.f22011a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r5);     // Catch: Throwable -> L18
        Object r15 = r5;
        ProxySession r16 = r11;
        r3 = r12;
    L59:
    L39:
        th = th;
    L20:
        r2 = r13;
        r1 = r14;
    L42:
        r6.f22011a = r1;
        r6.f22012b = r2;
        r6.f22013c = th;
        r6.f22014d = null;
        r6.h = 2;
        if (r1.a(r2, r3, r16, r6) != r7) goto L45;
        return r7;
    L45:
        a r17 = r1;
        r9 = th;
        r0 = r17;
        goto L46
    L31:
        if (((ProxyReady) ZeusTransformUtils.preCheckCast(r15, ProxyReady.class, "com.obric.aiagent.plugin")) == null) goto L38;
        if (IAppContext.Companion.isDebug() == false) goto L35;
        ILogDepend.Companion.i("Virt/Proxy", "proxySession started executionId=" + r13 + " lxcSessionId=" + r3 + " proxySessionId=" + r16.getSessionId() + " costMs=" + (System.currentTimeMillis() - r10));
    L36:
        return r16;
    L35:
        ILogDepend.Companion.i("Virt/Proxy", "proxySession started costMs=" + (System.currentTimeMillis() - r10));
        goto L36
    L38:
        throw new IllegalStateException("SafetyGuard proxy ready timeout");     // Catch: Throwable -> L39
    L18:
        th = th;
        r16 = r11;
        r3 = r12;
        goto L20
    L21:
        d.o.a(r5);
        long r18 = System.currentTimeMillis();
        Object r23 = e().mo37startSessiongIAlus(r21, new ProxySessionOptions(r3));     // Catch: Throwable -> L50
        Throwable r24 = d.n.c(r23);
        if (r24 != null) goto L48;
        r16 = (ProxySession) ZeusTransformUtils.preCheckCast(r23, ProxySession.class, "com.obric.aiagent.plugin");
        d.h.a.m r25 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new y(r16, null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L41
        r6.f22011a = r1;     // Catch: Throwable -> L41
        r6.f22012b = r2;     // Catch: Throwable -> L41
        r6.f22013c = r3;     // Catch: Throwable -> L41
        r6.f22014d = r16;     // Catch: Throwable -> L41
        r6.f22015e = r18;     // Catch: Throwable -> L41
        r6.h = 1;     // Catch: Throwable -> L41
        r15 = dg.b(10000, r25, r6);     // Catch: Throwable -> L41
        if (r15 != r7) goto L29;
        return r7;
    L29:
        r13 = r2;
        r14 = r1;
        r10 = r18;
    L41:
        th = th;
        goto L42
    L48:
        r1.a(r2, "proxy_runtime_rejected", r24);
        throw new d.d();
    L50:
        th = move-exception;
        r1.a(r2, "proxy_runtime_threw", th);
        throw new d.d();
    L7:
        r6 = new x(r1, r4);
        goto L8
    }

    private final Object a(String r5, au<com.obric.aiagent.skill.virt.impl.a.c.c.a> r6, d.c.d<? super com.obric.aiagent.skill.virt.impl.a.c.c.a> r7) {
        au r8 = (au) ZeusTransformUtils.wrapperContextForParams(r6, au.class, "com.obric.aiagent.plugin");
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(co.f39209b, d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new z(this, r5, r8, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r9);
    }

    private final ActionContextToken a(String r3, String r4, ProxySession r5, String r6) {
        Object r2 = ((ProxySession) ZeusTransformUtils.wrapperContextForParams(r5, ProxySession.class, "com.obric.aiagent.plugin")).mo31activateActionIoAF18A(r6);
        Throwable r7 = d.n.c(r2);
        if (r7 != null) goto L7;
        return (ActionContextToken) ZeusTransformUtils.preCheckCast(r2, ActionContextToken.class, "com.obric.aiagent.plugin");
    L7:
        if (IAppContext.Companion.isDebug() == false) goto L9;
        ILogDepend.Companion.e("Virt/Proxy", "proxy action activation failed executionId=" + r3 + " lxcSessionId=" + r4, r7);
    L11:
        throw new IllegalStateException("Shell proxy action activation failed", r7);
    L9:
        ILogDepend.Companion.e("Virt/Proxy", "proxy action activation failed");
        goto L11
    }

    private final String a(String r3, String r4, ProxySession r5, ActionContextToken r6) {
        Object r7 = ((ProxySession) ZeusTransformUtils.wrapperContextForParams(r5, ProxySession.class, "com.obric.aiagent.plugin")).mo33finishActionIoAF18A(r6);     // Catch: Throwable -> L9
        Throwable r8 = d.n.c(r7);
        if (r8 == null) goto L14;
        b(r3, r4, r8);
        return null;
    L14:
        return a((ActionEgressResult) ZeusTransformUtils.preCheckCast(r7, ActionEgressResult.class, "com.obric.aiagent.plugin"));
    L9:
        th = move-exception;
        b(r3, r4, th);
        return null;
    }

    private final void b(String r4, String r5, Throwable r6) {
        if (IAppContext.Companion.isDebug() == false) goto L5;
        ILogDepend.Companion.e("Virt/Proxy", "proxy action finish failed executionId=" + r4 + " lxcSessionId=" + r5, r6);
        return;
    L5:
        ILogDepend.Companion.e("Virt/Proxy", "proxy action finish failed");
    }

    private final String a(ActionEgressResult r1) {
        return com.obric.aiagent.skill.virt.impl.a.e.f22042a.a(r1);
    }

    private final Object a(String r9, String r10, ProxySession r11, d.c.d<? super d.x> r12) {
        ProxySession r3 = (ProxySession) ZeusTransformUtils.wrapperContextForParams(r11, ProxySession.class, "com.obric.aiagent.plugin");
        d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        Object r8 = kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(co.f39209b, d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(r3, this, r9, r10, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r13);
        if (r8 != d.c.a.b.a()) goto L6;
        return r8;
    L6:
        return d.x.f38692a;
    }

    private final Object a(ParcelFileDescriptor r7, d.h.a.b<? super String, d.x> r8, d.c.d<? super d.x> r9) {
        d.h.a.b r10 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L5;
        d.n.a r12 = d.n.f38560a;     // Catch: Throwable -> L21
        a r13 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        Closeable r14 = (Closeable) ZeusTransformUtils.preCheckCast(new ParcelFileDescriptor.AutoCloseInputStream(r7), Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        ParcelFileDescriptor.AutoCloseInputStream r0 = (ParcelFileDescriptor.AutoCloseInputStream) ZeusTransformUtils.preCheckCast(r14, ParcelFileDescriptor.AutoCloseInputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        byte[] r1 = new byte[4096];     // Catch: Throwable -> L16
    L9:
        int r2 = r0.read(r1);     // Catch: Throwable -> L16
        if (r2 < 0) goto L13;
        if (r2 == 0) goto L9;
        Charset r4 = StandardCharsets.UTF_8;     // Catch: Throwable -> L16
        d.h.b.o.c(r4, "UTF_8");     // Catch: Throwable -> L16
        r10.invoke(new String(r1, 0, r2, r4));     // Catch: Throwable -> L16
        goto L9
    L13:
        d.x r15 = d.x.f38692a;     // Catch: Throwable -> L16
        d.f.c.a(r14, null);     // Catch: Throwable -> L21
        Object r16 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L21
    L23:
        Throwable r17 = d.n.c(r16);
        if (r17 == null) goto L27;
        a("Virt/Lxc", "Failed to read LXC streaming pipe", "Failed to read LXC streaming pipe", r17);
    L27:
        return d.x.f38692a;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        d.f.c.a(r14, th);     // Catch: Throwable -> L21
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        d.n.a r18 = d.n.f38560a;
        r16 = d.n.f(d.o.a(th));
        goto L23
    L5:
        return d.x.f38692a;
    }

    private final String h() {
        return com.obric.aiagent.skill.virt.impl.a.b.d.f21908a.a("/home/virt", this.k);
    }

    private final String i() {
        return com.obric.aiagent.skill.virt.impl.a.b.d.f21908a.a(this.f21923b.f(), this.k);
    }

    private final File j() {
        File r0 = new File(this.i, this.k);
        if (r0.exists() == true) goto L6;
        r0.mkdirs();
    L6:
        if (r0.isDirectory() == false) goto L9;
        return r0;
    L9:
        throw new IllegalStateException(("LXC share namespace root not available: " + r0.getAbsolutePath()).toString());
    }

    private final String c(String r1) {
        return com.obric.aiagent.skill.virt.impl.a.b.d.f21908a.c(r1);
    }

    private final void a(ParcelFileDescriptor r1) {
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L8
        if (r1 == null) goto L5;
        r1.close();     // Catch: Throwable -> L8
        d.x r2 = d.x.f38692a;     // Catch: Throwable -> L8
    L6:
        d.n.f(r2);     // Catch: Throwable -> L8
        return;
    L5:
        r2 = null;
    L8:
        th = move-exception;
        d.n.a r3 = d.n.f38560a;
        d.n.f(d.o.a(th));
    }

    private final void a(com.obric.aiagent.skill.virt.impl.a.b.a r4) {
        if (IAppContext.Companion.isDebug() == false) goto L6;
        ILogDepend.Companion.i("Virt/Import", "moveSource: what=" + r4.a() + " src=" + r4.b() + " dst=" + r4.c() + " fallback=" + r4.d());
        return;
    L6:
        if (r4.d() == false) goto L8;
        ILogDepend.Companion.w("Virt/Import", "moveSource: using copy fallback");
        return;
    L8:
        ILogDepend.Companion.i("Virt/Import", "moveSource: rename completed");
    }

    private final void a(String r1, String r2, String r3, Throwable r4) {
        if (IAppContext.Companion.isDebug() == false) goto L5;
        ILogDepend.Companion.e(r1, r3, r4);
        return;
    L5:
        ILogDepend.Companion.e(r1, r2);
    }

    private final boolean a(Throwable r3) {
        Iterator r2 = d.n.m.a(r3, $$Lambda$a$qGgAnc74aFDax32p2LSenW59b4k.INSTANCE).a();
    L4:
        if (r2.hasNext() == false) goto L8;
        if (ZeusTransformUtils.instanceOf((Throwable) ZeusTransformUtils.preCheckCast(r2.next(), Throwable.class, "com.obric.aiagent.plugin"), ProxyReadyException.class) == false) goto L4;
        return true;
    L8:
        return false;
    }

    private static final Throwable b(Throwable r1) {
        d.h.b.o.e(r1, "it");
        return r1.getCause();
    }
}
