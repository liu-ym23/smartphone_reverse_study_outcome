package com.obric.autogui.session.d;

import android.os.SystemClock;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.n;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.cx;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;

/* JADX INFO: compiled from: AsyncResource.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a<T> {
    private static final String TAG = "AsyncResource";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0839a f30862a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final am f30863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f30864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b<? extends T> f30865d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ca f30866e;

    /* JADX INFO: renamed from: com.obric.autogui.session.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AsyncResource.kt */
    public static final class C0839a {
        public /* synthetic */ C0839a(d.h.b.h r1) {
            this();
        }

        private C0839a() {
        }
    }

    /* JADX INFO: compiled from: AsyncResource.kt */
    private static abstract class b<T> {

        /* JADX INFO: renamed from: com.obric.autogui.session.d.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AsyncResource.kt */
        public static final class C0840a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0840a f30867a = null;

            static {
                f30867a = new C0840a();
            }

            private C0840a() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: com.obric.autogui.session.d.a$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AsyncResource.kt */
        public static final class C0841b<T> extends b<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final w<T> f30868a;

            public C0841b(w<T> r3) {
                w<T> r4 = (w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.aiagent.plugin");
                o.e(r4, "deferred");
                super(null);
                this.f30868a = r4;
            }

            public final w<T> a() {
                return this.f30868a;
            }
        }

        /* JADX INFO: compiled from: AsyncResource.kt */
        public static final class c<T> extends b<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final T f30869a;

            public c(T r2) {
                super(null);
                this.f30869a = r2;
            }

            public final T a() {
                return this.f30869a;
            }
        }

        /* JADX INFO: compiled from: AsyncResource.kt */
        public static final class d extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f30870a = null;

            static {
                f30870a = new d();
            }

            private d() {
                super(null);
            }
        }

        public /* synthetic */ b(d.h.b.h r1) {
            this();
        }

        private b() {
        }
    }

    /* JADX INFO: compiled from: AsyncResource.kt */
    @d.c.b.a.f(b = "AsyncResource.kt", c = {159}, d = "get$suspendImpl", e = "com.obric.autogui.session.preload.AsyncResource")
    static final class c<T> extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f30871a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f30872b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f30873c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a<T> f30874d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f30875e;

        c(a<T> r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30874d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f30873c = r3;
            this.f30875e |= Integer.MIN_VALUE;
            return a.a(this.f30874d, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AsyncResource.kt */
    @d.c.b.a.f(b = "AsyncResource.kt", c = {91}, d = "invokeSuspend", e = "com.obric.autogui.session.preload.AsyncResource$start$1")
    static final class d extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f30876a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f30877b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a<T> f30878c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ b.C0841b<T> f30879d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private /* synthetic */ Object f30880e;

        d(a<T> r3, b.C0841b<T> r4, d.c.d<? super d> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30878c = r3;
            this.f30879d = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            d r0 = new d(this.f30878c, this.f30879d, r6);
            r0.f30880e = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f30877b;
            if (r1 == 0) goto L12;
            if (r1 != 1) goto L11;
            long r2 = this.f30876a;
            d.o.a(r10);     // Catch: Throwable -> L8
        L17:
            Object r11 = n.f(r10);     // Catch: Throwable -> L8
        L22:
            a<T> r3 = this.f30878c;
            Throwable r4 = n.c(r11);
            if (r4 == null) goto L25;
            Loog.INSTANCE.e(a.TAG, r3.a().a() + " fetch failed: " + r4);
        L25:
            Object r5 = null;
            if (n.b(r11) == false) goto L28;
            r11 = null;
        L28:
            Object r6 = a.a(this.f30878c);
            a<T> r7 = this.f30878c;
            b.C0841b<T> r8 = this.f30879d;
            monitor-enter(r6);
        L41:
            th = move-exception;
            throw th;
        L31:
            if (a.b(r7) != r8) goto L33;
            a.a(r7, (b) ZeusTransformUtils.preCheckCast(new b.c(r11), b.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L41
            r8.a().a(r11);     // Catch: Throwable -> L41
        L35:
            monitor-exit(r6);
            Loog.INSTANCE.i(a.TAG, "fetchingResource " + this.f30878c.a().a() + " cost " + (SystemClock.elapsedRealtime() - r2));
            if (r5 == null) goto L40;
            a.a(this.f30878c, r5);
        L40:
            return x.f38692a;
        L33:
            r8.a().a(null);     // Catch: Throwable -> L41
            r5 = r11;
        L8:
            th = th;
        L21:
            n.a r9 = n.f38560a;
            r11 = n.f(d.o.a(th));
            goto L22
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            d.o.a(r10);
            am r12 = (am) ZeusTransformUtils.preCheckCast(this.f30880e, am.class, "com.obric.aiagent.plugin");
            long r13 = SystemClock.elapsedRealtime();
            a<T> r14 = this.f30878c;
            n.a r15 = n.f38560a;     // Catch: Throwable -> L19
            d.h.a.b<d.c.d<? super T>, Object> r16 = r14.a().b();     // Catch: Throwable -> L19
            this.f30876a = r13;     // Catch: Throwable -> L19
            this.f30877b = 1;     // Catch: Throwable -> L19
            r10 = r16.invoke(this);     // Catch: Throwable -> L19
            if (r10 != r0) goto L16;
            return r0;
        L16:
            r2 = r13;
        L19:
            th = th;
            r2 = r13;
            goto L21
        }
    }

    static {
        f30862a = new C0839a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ x lambda$HjWMwGIgmCoBQoacnxDGaf_Zb2I() {
        return g();
    }

    public abstract com.obric.autogui.session.d.c<T> a();

    public Object a(d.c.d<? super T> r3) {
        return a(this, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public a(am r3) {
        am r4 = (am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin");
        o.e(r4, "scope");
        this.f30863b = r4;
        this.f30864c = new Object();
        this.f30865d = (b) ZeusTransformUtils.preCheckCast(b.C0840a.f30867a, b.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ Object a(a r0) {
        return r0.f30864c;
    }

    public static final /* synthetic */ void a(a r0, b r1) {
        r0.f30865d = r1;
    }

    public static final /* synthetic */ void a(a r0, Object r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ b b(a r0) {
        return r0.f30865d;
    }

    public /* synthetic */ a(am r2, int r3, d.h.b.h r4) {
        am r5 = (am) ZeusTransformUtils.wrapperContextForParams(r2, am.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = an.a(cx.a(null, 1, null).plus((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin")));
    L5:
        this(r5);
    }

    public final void b() {
        Object r0 = this.f30864c;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (ZeusTransformUtils.instanceOf(this.f30865d, b.C0840a.class) == true) goto L7;
        monitor-exit(r0);
        return;
    L7:
        if (((Boolean) ZeusTransformUtils.preCheckCast(a().d().invoke(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L12;
        this.f30865d = (b) ZeusTransformUtils.preCheckCast(new b.c(null), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        monitor-exit(r0);
        return;
    L12:
        b.C0841b r3 = new b.C0841b(y.a(null, 1, null));     // Catch: Throwable -> L18
        this.f30865d = (b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        monitor-exit(r0);
        this.f30866e = kotlinx.coroutines.i.a(this.f30863b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new d(this, r3, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public static /* synthetic */ void a(a r2, d.h.a.a r3, int r4, Object r5) {
        d.h.a.a<x> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L10;
        if ((r4 & 1) == 0) goto L7;
        r6 = $$Lambda$a$HjWMwGIgmCoBQoacnxDGaf_Zb2I.INSTANCE;
    L7:
        r2.a(r6);
        return;
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: restart");
    }

    private static final x g() {
        return x.f38692a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(d.h.a.a<x> r7) {
        d.h.a.a r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r8, "before");
        Object r0 = this.f30864c;
        monitor-enter(r0);
        b<? extends T> r1 = this.f30865d;     // Catch: Throwable -> L32
        ca r2 = this.f30866e;     // Catch: Throwable -> L32
        Object r3 = null;
        if (r2 == null) goto L7;
        ca.a.a(r2, null, 1, null);     // Catch: Throwable -> L32
    L7:
        this.f30866e = null;     // Catch: Throwable -> L32
        this.f30865d = (b) ZeusTransformUtils.preCheckCast(b.C0840a.f30867a, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L32
        if (ZeusTransformUtils.instanceOf(r1, b.c.class) == false) goto L11;
        r3 = ((b.c) ZeusTransformUtils.preCheckCast(r1, b.c.class, "com.obric.aiagent.plugin")).a();     // Catch: Throwable -> L32
    L20:
        monitor-exit(r0);
        if (r3 == null) goto L35;
        a(r3);
    L35:
        n.a r4 = n.f38560a;     // Catch: Throwable -> L25
        a r5 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        r8.invoke();     // Catch: Throwable -> L25
        Object r9 = n.f(x.f38692a);     // Catch: Throwable -> L25
    L27:
        Throwable r10 = n.c(r9);
        if (r10 == null) goto L30;
        Loog.INSTANCE.e(TAG, a().a() + " restart.before failed: " + r10);
    L30:
        b();
        return;
    L25:
        th = move-exception;
        n.a r6 = n.f38560a;
        r9 = n.f(d.o.a(th));
        goto L27
    L11:
        if (ZeusTransformUtils.instanceOf(r1, b.C0841b.class) == false) goto L14;
        ((b.C0841b) ZeusTransformUtils.preCheckCast(r1, b.C0841b.class, "com.obric.aiagent.plugin")).a().a(null);     // Catch: Throwable -> L32
        goto L20
    L14:
        if (o.a(r1, b.C0840a.f30867a) == true) goto L20;
        if (o.a(r1, b.d.f30870a) == true) goto L20;
        throw new d.k();     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c() {
        Object r0 = this.f30864c;
        monitor-enter(r0);
        b<? extends T> r1 = this.f30865d;     // Catch: Throwable -> L28
        if (ZeusTransformUtils.instanceOf(r1, b.d.class) == false) goto L8;
        monitor-exit(r0);
        return;
    L8:
        ca r2 = this.f30866e;     // Catch: Throwable -> L28
        Object r3 = null;
        if (r2 == null) goto L11;
        ca.a.a(r2, null, 1, null);     // Catch: Throwable -> L28
    L11:
        this.f30866e = null;     // Catch: Throwable -> L28
        this.f30865d = (b) ZeusTransformUtils.preCheckCast(b.d.f30870a, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
        if (ZeusTransformUtils.instanceOf(r1, b.c.class) == false) goto L15;
        r3 = ((b.c) ZeusTransformUtils.preCheckCast(r1, b.c.class, "com.obric.aiagent.plugin")).a();     // Catch: Throwable -> L28
    L24:
        monitor-exit(r0);
        if (r3 == null) goto L32;
        a(r3);
        return;
    L32:
        return;
    L15:
        if (ZeusTransformUtils.instanceOf(r1, b.C0841b.class) == false) goto L18;
        ((b.C0841b) ZeusTransformUtils.preCheckCast(r1, b.C0841b.class, "com.obric.aiagent.plugin")).a().a(null);     // Catch: Throwable -> L28
        goto L24
    L18:
        if (o.a(r1, b.C0840a.f30867a) == true) goto L24;
        if (o.a(r1, b.d.f30870a) == true) goto L24;
        throw new d.k();     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ <T> Object a(a<T> r7, d.c.d<? super T> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, c.class) == false) goto L7;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r9, c.class, "com.obric.aiagent.plugin");
        if ((r0.f30875e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f30875e -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.f30873c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f30875e;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        long r4 = r0.f30872b;
        r7 = (a) ZeusTransformUtils.preCheckCast(r0.f30871a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r10);
    L18:
        if (r10 != null) goto L20;
        r10 = r7.a().c().invoke();
    L20:
        Loog.INSTANCE.i(TAG, "awaitingResource " + r7.a().a() + " cost " + (SystemClock.elapsedRealtime() - r4));
        return r10;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r10);
        long r5 = SystemClock.elapsedRealtime();
        r0.f30871a = r7;
        r0.f30872b = r5;
        r0.f30875e = 1;
        r10 = r7.b(r0);
        if (r10 != r2) goto L17;
        return r2;
    L17:
        r4 = r5;
    L7:
        r0 = new c(r7, r9);
        goto L8
    }

    public final boolean d() {
        return ZeusTransformUtils.instanceOf(f(), b.c.class);
    }

    public final boolean e() {
        if (f() != b.d.f30870a) goto L5;
        return true;
    L5:
        return false;
    }

    private final Object b(d.c.d<? super T> r4) {
        d.c.d<? super T> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
    L3:
        b<T> r0 = f();
        if (ZeusTransformUtils.instanceOf(r0, b.c.class) == true) goto L6;
        if (ZeusTransformUtils.instanceOf(r0, b.d.class) == true) goto L9;
        if (ZeusTransformUtils.instanceOf(r0, b.C0841b.class) == true) goto L14;
        if (o.a(r0, b.C0840a.f30867a) == false) goto L19;
        b();
        goto L3
    L19:
        throw new d.k();
    L14:
        return ((b.C0841b) ZeusTransformUtils.preCheckCast(r0, b.C0841b.class, "com.obric.aiagent.plugin")).a().a(r5);
    L9:
        return null;
    L6:
        return ((b.c) ZeusTransformUtils.preCheckCast(r0, b.c.class, "com.obric.aiagent.plugin")).a();
    }

    private final b<T> f() {
        Object r0 = this.f30864c;
        monitor-enter(r0);
        b<? extends T> r1 = this.f30865d;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private final void a(T r3) {
        n.a r0 = n.f38560a;     // Catch: Throwable -> L4
        ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).a().e().invoke(r3);     // Catch: Throwable -> L4
        Object r4 = n.f(x.f38692a);     // Catch: Throwable -> L4
    L6:
        Throwable r5 = n.c(r4);
        if (r5 == null) goto L12;
        Loog.INSTANCE.e(TAG, a().a() + " onRelease failed: " + r5);
        return;
    L12:
        return;
    L4:
        th = move-exception;
        n.a r1 = n.f38560a;
        r4 = n.f(d.o.a(th));
        goto L6
    }
}
