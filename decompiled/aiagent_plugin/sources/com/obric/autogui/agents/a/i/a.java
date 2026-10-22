package com.obric.autogui.agents.a.i;

import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.al;
import d.a.p;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.c.g;
import d.h.a.m;
import d.h.b.h;
import d.h.b.o;
import d.l.j;
import d.l.n;
import d.x;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.cx;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: ActionEffectResourceCleanupScheduler.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final String TAG = "ActionEffectResource";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0667a f26509a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final am f26510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<Long> f26511c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConcurrentHashMap<String, b> f26512d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConcurrentHashMap<String, ca> f26513e;
    private final Object f;
    private boolean g;
    private boolean h;

    /* JADX INFO: renamed from: com.obric.autogui.agents.a.i.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActionEffectResourceCleanupScheduler.kt */
    public static final class C0667a {
        public /* synthetic */ C0667a(h r1) {
            this();
        }

        private C0667a() {
        }
    }

    /* JADX INFO: compiled from: ActionEffectResourceCleanupScheduler.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f26514a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f26515b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final d.h.a.a<Boolean> f26516c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Object f26517d;

        public b(String r3, String r4, d.h.a.a<Boolean> r5) {
            d.h.a.a<Boolean> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
            o.e(r3, "action");
            o.e(r4, "attemptId");
            o.e(r6, "release");
            this.f26514a = r3;
            this.f26515b = r4;
            this.f26516c = r6;
            this.f26517d = new Object();
        }

        public final String a() {
            return this.f26514a;
        }

        public final String b() {
            return this.f26515b;
        }

        public final d.h.a.a<Boolean> c() {
            return this.f26516c;
        }

        public final boolean a(d.h.a.a<Boolean> r3) {
            d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
            o.e(r4, "block");
            Object r2 = this.f26517d;
            monitor-enter(r2);
            Object r5 = r4.invoke();     // Catch: Throwable -> L8
            monitor-exit(r2);
            return ((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        L8:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: compiled from: ActionEffectResourceCleanupScheduler.kt */
    @f(b = "ActionEffectResourceCleanupScheduler.kt", c = {132}, d = "invokeSuspend", e = "com.obric.autogui.agents.actioneffect.resource.ActionEffectResourceCleanupScheduler$launchRetry$1$1")
    static final class c extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f26518a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f26519b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f26520c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f26521d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f26522e;
        int f;
        long g;
        int h;
        final /* synthetic */ a i;
        final /* synthetic */ b j;
        final /* synthetic */ String k;

        c(a r3, b r4, String r5, d<? super c> r6) {
            d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
            this.i = r3;
            this.j = r4;
            this.k = r5;
            super(2, r7);
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r4, d<?> r5) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new c(this.i, this.j, this.k, r6), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0091 -> B:22:0x00ab). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00a8 -> B:22:0x00ab). Please report as a decompilation issue!!! */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r19) {
            Object r0 = d.c.a.b.a();
            int r2 = this.h;
            long r3 = 0;
            String r5 = ", source=";
            String r9 = "com.obric.aiagent.plugin";
            if (r2 == 0) goto L10;
            if (r2 != 1) goto L9;
            int r4 = this.f;
            long r10 = this.g;
            int r12 = this.f26522e;
            Iterator r13 = (Iterator) ZeusTransformUtils.preCheckCast(this.f26521d, Iterator.class, "com.obric.aiagent.plugin");
            String r14 = (String) ZeusTransformUtils.preCheckCast(this.f26520c, String.class, "com.obric.aiagent.plugin");
            b r6 = (b) ZeusTransformUtils.preCheckCast(this.f26519b, b.class, "com.obric.aiagent.plugin");
            a r8 = (a) ZeusTransformUtils.preCheckCast(this.f26518a, a.class, "com.obric.aiagent.plugin");
            d.o.a(r19);     // Catch: Throwable -> L36
        L22:
            boolean r15 = a.a(r8, r6);     // Catch: Throwable -> L36
            Loog r7 = Loog.INSTANCE;     // Catch: Throwable -> L36
            Object r18 = r0;
            String r16 = r9;
            int r110 = r12;
            StringBuilder r1 = new StringBuilder().append("[OAutoActionEffect] resource cleanup retry ").append(com.obric.autogui.agents.a.c.f26286a.a(r6.a(), r6.b())).append(r5).append(r14).append(", retry=").append(r4 + 1).append('/').append(a.a(r8).size()).append(", requested_delay_ms=");     // Catch: Throwable -> L36
            String r11 = r5;
            StringBuilder r17 = r1.append(n.a(r10, 0)).append(", released=");     // Catch: Throwable -> L36
            if (r15 == false) goto L25;
            boolean r20 = true;
        L26:
            r7.i(a.TAG, r17.append(r20).toString());     // Catch: Throwable -> L36
            if (r15 == false) goto L31;
            x r21 = x.f38692a;     // Catch: Throwable -> L36
            a.b(this.i).remove(this.j.b());
            return r21;
        L31:
            r0 = r18;
            r3 = 0;
            r9 = r16;
            r5 = r11;
            r4 = r110;
        L13:
            if (r13.hasNext() == false) goto L33;
            Object r111 = r13.next();     // Catch: Throwable -> L36
            r12 = r4 + 1;     // Catch: Throwable -> L36
            if (r4 >= 0) goto L17;
            p.c();     // Catch: Throwable -> L36
        L17:
            r10 = ((Number) ZeusTransformUtils.preCheckCast(r111, Number.class, r9)).longValue();     // Catch: Throwable -> L36
            if (r10 <= r3) goto L22;
            this.f26518a = r8;     // Catch: Throwable -> L36
            this.f26519b = r6;     // Catch: Throwable -> L36
            this.f26520c = r14;     // Catch: Throwable -> L36
            this.f26521d = r13;     // Catch: Throwable -> L36
            this.f26522e = r12;     // Catch: Throwable -> L36
            this.g = r10;     // Catch: Throwable -> L36
            this.f = r4;     // Catch: Throwable -> L36
            this.h = 1;     // Catch: Throwable -> L36
            if (ax.a(r10, this) != r0) goto L22;
            return r0;
        L33:
            Loog.INSTANCE.w(a.TAG, "[OAutoActionEffect] resource cleanup still pending " + com.obric.autogui.agents.a.c.f26286a.a(this.j.a(), this.j.b()) + r5 + this.k + ", retry_count=" + a.a(this.i).size());     // Catch: Throwable -> L36
            a.b(this.i).remove(this.j.b());
            return x.f38692a;
        L25:
            r20 = false;
            goto L26
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            d.o.a(r19);
            Iterable r22 = (Iterable) ZeusTransformUtils.preCheckCast(a.a(this.i), Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L36
            a r23 = this.i;     // Catch: Throwable -> L36
            b r24 = this.j;     // Catch: Throwable -> L36
            String r112 = this.k;     // Catch: Throwable -> L36
            r13 = r22.iterator();     // Catch: Throwable -> L36
            r14 = r112;
            r4 = 0;
            r8 = r23;
            r6 = r24;
        L36:
            th = move-exception;
            a.b(this.i).remove(this.j.b());
            throw th;
        }
    }

    static {
        f26509a = new C0667a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    /* JADX INFO: renamed from: lambda$08k-pPthf_KZwO4ZPNf5esv6mtw, reason: not valid java name */
    public static /* synthetic */ boolean m711lambda$08kpPthf_KZwO4ZPNf5esv6mtw(a r0, b r1) {
        return b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$0wh-b-fbcrRCvSDakIfRT1HB5Kw, reason: not valid java name */
    public static /* synthetic */ boolean m712lambda$0whbfbcrRCvSDakIfRT1HB5Kw(a r0, b r1) {
        return c(r0, r1);
    }

    public static /* synthetic */ ca lambda$2HBipcsjzyMQQydU0MIBYigSSuo(a r0, b r1, String r2, String r3) {
        return a(r0, r1, r2, r3);
    }

    public static /* synthetic */ ca lambda$KD3UvBvIuiIEKLMyXoIcQBHolbk(d.h.a.b r0, Object r1) {
        return a(r0, r1);
    }

    public a(am r3, List<Long> r4) {
        am r5 = (am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin");
        List<Long> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        o.e(r5, "scope");
        o.e(r6, "retryDelaysMs");
        this.f26510b = r5;
        this.f26511c = r6;
        this.f26512d = new ConcurrentHashMap();
        this.f26513e = new ConcurrentHashMap();
        this.f = new Object();
    }

    public static final /* synthetic */ List a(a r0) {
        return r0.f26511c;
    }

    public static final /* synthetic */ boolean a(a r0, b r1) {
        return r0.b(r1);
    }

    public static final /* synthetic */ ConcurrentHashMap b(a r0) {
        return r0.f26513e;
    }

    public /* synthetic */ a(am r5, List r6, int r7, h r8) {
        am r9 = (am) ZeusTransformUtils.wrapperContextForParams(r5, am.class, "com.obric.aiagent.plugin");
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        if ((r7 & 1) == 0) goto L6;
        r9 = an.a(cx.a(null, 1, null).plus((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin")));
    L6:
        if ((r7 & 2) == 0) goto L8;
        r10 = p.b(new Long[]{100L, 500L, 1000L});
    L8:
        this(r9, r10);
    }

    public final void a(String r6, String r7, d.h.a.a<Boolean> r8) {
        d.h.a.a r9 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r6, "action");
        o.e(r7, "attemptId");
        o.e(r9, "release");
        b r0 = new b(r6, r7, r9);
        Object r10 = this.f;
        monitor-enter(r10);
        boolean r2 = true;
        boolean r3 = false;
        if (this.g == false) goto L7;
        r3 = true;
        r2 = false;
    L11:
        monitor-exit(r10);
        if (r3 == false) goto L15;
        a(r0, c(r0), "scheduler_closed");
        return;
    L15:
        if (r2 == true) goto L18;
        Loog.INSTANCE.w(TAG, "[OAutoActionEffect] duplicate resource cleanup ignored " + com.obric.autogui.agents.a.c.f26286a.a(r6, r7));
        return;
    L18:
        Loog.INSTANCE.w(TAG, "[OAutoActionEffect] resource cleanup deferred " + com.obric.autogui.agents.a.c.f26286a.a(r6, r7) + ", pending_count=" + this.f26512d.size());
        a(r0, "initial_failure");
        return;
    L7:
        if (this.f26512d.putIfAbsent(r7, r0) == null) goto L11;
        r2 = false;
    L20:
        th = move-exception;
        throw th;
    }

    public final void a() {
        Object r0 = this.f;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.g == false) goto L7;
        List r1 = p.b();     // Catch: Throwable -> L14
    L8:
        monitor-exit(r0);
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L11:
        if (r2.hasNext() == false) goto L13;
        b r3 = (b) ZeusTransformUtils.preCheckCast(r2.next(), b.class, "com.obric.aiagent.plugin");
        o.a(r3);
        a(r3, "next_step");
        goto L11
    L13:
        return;
    L7:
        Collection<b> r4 = this.f26512d.values();     // Catch: Throwable -> L14
        o.c(r4, "<get-values>(...)");     // Catch: Throwable -> L14
        r1 = p.o((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L14
        goto L8
    }

    public final void b() {
        Object r0 = this.f;
        monitor-enter(r0);
    L55:
        th = move-exception;
        throw th;
    L5:
        if (this.h == false) goto L9;
        monitor-exit(r0);
        return;
    L9:
        this.h = true;     // Catch: Throwable -> L55
        this.g = true;     // Catch: Throwable -> L55
        Collection<b> r2 = this.f26512d.values();     // Catch: Throwable -> L55
        o.c(r2, "<get-values>(...)");     // Catch: Throwable -> L55
        List r3 = p.o((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L55
        monitor-exit(r0);
        an.a(this.f26510b, null, 1, null);     // Catch: Throwable -> L46
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L46
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L15;
    L17:
        Iterator r5 = r4.iterator();     // Catch: Throwable -> L46
        int r6 = 0;
    L19:
        if (r5.hasNext() == false) goto L37;
        b r7 = (b) ZeusTransformUtils.preCheckCast(r5.next(), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L46
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(new j(1, 3), Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L46
        if (ZeusTransformUtils.instanceOf(r8, Collection.class) == true) goto L23;
    L25:
        Iterator r9 = r8.iterator();     // Catch: Throwable -> L46
    L27:
        if (r9.hasNext() == false) goto L31;
        ((al) ZeusTransformUtils.preCheckCast(r9, al.class, "com.obric.aiagent.plugin")).a();     // Catch: Throwable -> L46
        o.a(r7);     // Catch: Throwable -> L46
        if (b(r7) == false) goto L27;
        boolean r10 = true;
    L32:
        o.a(r7);     // Catch: Throwable -> L46
        a(r7, r10, "session_cleanse");     // Catch: Throwable -> L46
        if ((!r10) == false) goto L19;
        r6 = r6 + 1;     // Catch: Throwable -> L46
        if (r6 >= 0) goto L19;
        p.d();     // Catch: Throwable -> L46
    L31:
        r10 = false;
        goto L32
    L23:
        if (((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L25;
    L37:
        this.f26513e.clear();     // Catch: Throwable -> L46
        Loog.INSTANCE.i(TAG, "[OAutoActionEffect] resource cleanup scheduler closed, unresolved_count=" + r6);     // Catch: Throwable -> L46
        Object r1 = this.f;
        monitor-enter(r1);
        this.h = false;     // Catch: Throwable -> L43
        x r11 = x.f38692a;     // Catch: Throwable -> L43
        monitor-exit(r1);
        return;
    L43:
        th = move-exception;
        throw th;
    L15:
        if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L17;
        r6 = 0;
    L46:
        th = move-exception;
        monitor-enter(this.f);
        this.h = false;     // Catch: Throwable -> L52
        x r12 = x.f38692a;     // Catch: Throwable -> L52
        throw th;
    L52:
        th = move-exception;
        throw th;
    }

    private final void a(final b r4, final String r5) {
        if (a(r4) == true) goto L5;
        return;
    L5:
        ConcurrentHashMap<String, ca> r0 = this.f26513e;
        String r1 = r4.b();
        final d.h.a.b r2 = new $$Lambda$a$2HBipcsjzyMQQydU0MIBYigSSuo(this, r4, r5);
        r0.computeIfAbsent(r1, new $$Lambda$a$KD3UvBvIuiIEKLMyXoIcQBHolbk(r2));
    }

    private static final ca a(d.h.a.b r2, Object r3) {
        return (ca) ZeusTransformUtils.preCheckCast(((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin")).invoke(r3), ca.class, "com.obric.aiagent.plugin");
    }

    private static final ca a(a r7, b r8, String r9, String r10) {
        o.e(r10, "it");
        return i.a(r7.f26510b, null, null, (m) ZeusTransformUtils.preCheckCast(new c(r7, r8, r9, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final boolean a(b r3) {
        Object r0 = this.f;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.g == true) goto L9;
        if (this.f26512d.get(r3.b()) != r3) goto L9;
        boolean r2 = true;
    L10:
        monitor-exit(r0);
        return r2;
    L9:
        r2 = false;
        goto L10
    }

    private final boolean b(final b r2) {
        return r2.a(new $$Lambda$a$08kpPthf_KZwO4ZPNf5esv6mtw(this, r2));
    }

    private static final boolean b(a r1, b r2) {
        if (r1.d(r2) == true) goto L6;
        return true;
    L6:
        boolean r0 = r1.f(r2);
        if (r0 == false) goto L9;
        r1.e(r2);
    L9:
        return r0;
    }

    private final boolean c(final b r2) {
        return r2.a(new $$Lambda$a$0whbfbcrRCvSDakIfRT1HB5Kw(this, r2));
    }

    private static final boolean c(a r0, b r1) {
        return r0.f(r1);
    }

    private final boolean d(b r3) {
        Object r0 = this.f;
        monitor-enter(r0);
        if (this.f26512d.get(r3.b()) != r3) goto L7;
        boolean r2 = true;
    L8:
        monitor-exit(r0);
        return r2;
    L7:
        r2 = false;
    L10:
        th = move-exception;
        throw th;
    }

    private final boolean e(b r4) {
        Object r0 = this.f;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.f26512d.get(r4.b()) != r4) goto L8;
        boolean r3 = this.f26512d.remove(r4.b(), r4);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);
        return r3;
    L8:
        r3 = false;
        goto L9
    }

    private final boolean f(b r6) {
        d.h.a.a<Boolean> r5 = r6.c();
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L5
        Object r7 = d.n.f(r5.invoke());     // Catch: Throwable -> L5
    L7:
        Throwable r1 = d.n.c(r7);
        if (r1 == null) goto L11;
        Loog.INSTANCE.w(TAG, "[OAutoActionEffect] resource cleanup attempt failed " + com.obric.autogui.agents.a.c.f26286a.a(r6.a(), r6.b()) + ", error_type=" + com.obric.autogui.agents.a.b.a(r1));
    L11:
        if (d.n.b(r7) == false) goto L14;
        r7 = false;
    L14:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r7, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L5:
        th = move-exception;
        d.n.a r2 = d.n.f38560a;
        r7 = d.n.f(d.o.a(th));
        goto L7
    }

    private final void a(b r3, boolean r4, String r5) {
        String r2 = "[OAutoActionEffect] resource cleanup final " + com.obric.autogui.agents.a.c.f26286a.a(r3.a(), r3.b()) + ", source=" + r5 + ", released=" + r4;
        if (r4 == false) goto L5;
        Loog.INSTANCE.i(TAG, r2);
        return;
    L5:
        Loog.INSTANCE.w(TAG, r2);
    }
}
