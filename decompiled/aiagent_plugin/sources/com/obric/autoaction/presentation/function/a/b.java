package com.obric.autoaction.presentation.function.a;

import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.h;
import d.o;
import d.x;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: BaseAutoResumeJob.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b implements com.obric.autoaction.presentation.function.a.c {
    private static final String TAG = "AutoResume";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f24924a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f24925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f24926c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f24927d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AOThreadingTools.SingleThreadCoroutineScopeWrapper f24928e;
    private final AtomicBoolean f;
    private ca g;

    /* JADX INFO: compiled from: BaseAutoResumeJob.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: com.obric.autoaction.presentation.function.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BaseAutoResumeJob.kt */
    @f(b = "BaseAutoResumeJob.kt", c = {112}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.function.autoresume.BaseAutoResumeJob$callResumeFunction$1")
    static final class C0581b extends l implements d.h.a.b<d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24929a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f24930b;

        C0581b(b r3, d.c.d<? super C0581b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24930b = r3;
            super(1, r5);
        }

        public final Object a(d.c.d<? super x> r3) {
            return ((C0581b) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), C0581b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C0581b(this.f24930b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24929a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            b r6 = this.f24930b;
            d.c.d<? super x> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24929a = 1;
            if (r6.a(r2) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: BaseAutoResumeJob.kt */
    @f(b = "BaseAutoResumeJob.kt", c = {96}, d = "runCountdown", e = "com.obric.autoaction.presentation.function.autoresume.BaseAutoResumeJob")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f24931a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f24932b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f24933c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f24934d;

        c(b r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24933c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f24932b = r3;
            this.f24934d |= Integer.MIN_VALUE;
            return b.a(this.f24933c, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: BaseAutoResumeJob.kt */
    @f(b = "BaseAutoResumeJob.kt", c = {59}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.function.autoresume.BaseAutoResumeJob$start$job$1")
    static final class d extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24935a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f24936b;

        d(b r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24936b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f24936b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24935a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            b r6 = this.f24936b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24935a = 1;
            if (b.a(r6, r2) != r0) goto L12;
            return r0;
        }
    }

    static {
        f24924a = new a(null);
    }

    public abstract Object a(d.c.d<? super x> r1);

    public b(String r2, long r3) {
        d.h.b.o.e(r2, "name");
        this.f24925b = r2;
        this.f24926c = r3;
        this.f24928e = com.obric.autoaction.e.d.f24682a.a();
        this.f = new AtomicBoolean(false);
    }

    public static final /* synthetic */ Object a(b r2, d.c.d r3) {
        return r2.b((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autoaction.presentation.function.a.c
    public long a() {
        if (this.f24927d == 0) goto L5;
        long r0 = AOSystemTools.INSTANCE.nowTimeMillis() - this.f24927d;
        long r4 = this.f24926c;
        if (r0 < r4) goto L10;
        return 0;
    L10:
        return r4 - r0;
    L5:
        return this.f24926c;
    }

    @Override // com.obric.autoaction.presentation.function.a.c
    public void b() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.f24927d == 0) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.f24927d = AOSystemTools.INSTANCE.nowTimeMillis();     // Catch: Throwable -> L12
        x r0 = x.f38692a;     // Catch: Throwable -> L12
        monitor-exit(this);
        ca r1 = i.a(this.f24928e.getCoroutineScope(), null, null, (m) ZeusTransformUtils.preCheckCast(new d(this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        this.g = r1;
        Loog.INSTANCE.d(TAG, " - [" + this.f24925b + "] started resuming job: " + r1.hashCode());
    }

    @Override // com.obric.autoaction.presentation.function.a.c
    public void c() {
        monitor-enter(this);
        ca r0 = this.g;     // Catch: Throwable -> L9
        if (r0 == null) goto L6;
        ca.a.a(r0, null, 1, null);     // Catch: Throwable -> L9
        Loog.INSTANCE.d(TAG, " - [" + this.f24925b + "] stopped resuming job: " + r0.hashCode());     // Catch: Throwable -> L9
    L6:
        f();     // Catch: Throwable -> L9
        x r1 = x.f38692a;     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.autoaction.presentation.function.a.c
    public void d() {
        if (e() == false) goto L5;
        c();
    L5:
        g();
    }

    public boolean e() {
        ca r2 = this.g;
        if (r2 == null) goto L8;
        if (r2.b() != true) goto L8;
        return true;
    L8:
        return false;
    }

    private final void f() {
        this.g = null;
        this.f24927d = 0;
        com.obric.autoaction.presentation.function.a.a.f24922a.b(getClass());
    }

    private final Object b(d.c.d<? super x> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, c.class) == false) goto L7;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r8, c.class, "com.obric.aiagent.plugin");
        if ((r0.f24934d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f24934d -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.f24932b;
        Object r1 = d.c.a.b.a();
        int r2 = r0.f24934d;
        if (r2 == 0) goto L16;
        if (r2 != 1) goto L15;
        b this = (b) ZeusTransformUtils.preCheckCast(r0.f24931a, b.class, "com.obric.aiagent.plugin");
        o.a(r9);     // Catch: Throwable -> L28 CancellationException -> L36
    L20:
        this.g();     // Catch: Throwable -> L28 CancellationException -> L36
        monitor-enter(this);
        this.f();     // Catch: Throwable -> L25
        x r10 = x.f38692a;     // Catch: Throwable -> L25
    L23:
        monitor-exit(this);
        return x.f38692a;
    L25:
        th = move-exception;
        throw th;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        o.a(r9);
        AOThreadingTools r11 = AOThreadingTools.INSTANCE;     // Catch: Throwable -> L28 CancellationException -> L36
        long r4 = this.f24926c;     // Catch: Throwable -> L28 CancellationException -> L36
        r0.f24931a = this;     // Catch: Throwable -> L28 CancellationException -> L36
        r0.f24934d = 1;     // Catch: Throwable -> L28 CancellationException -> L36
        if (r11.delayForMillis(r4, r0) != r1) goto L20;
        return r1;
    L45:
        th = move-exception;
        monitor-enter(this);
        this.f();     // Catch: Throwable -> L50
        x r3 = x.f38692a;     // Catch: Throwable -> L50
        throw th;
    L50:
        th = move-exception;
        throw th;
    L28:
        th = move-exception;
        Loog.INSTANCE.e(TAG, " - [" + this.f24925b + "] unexpected exception: " + th, th);     // Catch: Throwable -> L45
        monitor-enter(this);
        this.f();     // Catch: Throwable -> L33
        x r12 = x.f38692a;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        throw th;
    L36:
        Loog.INSTANCE.i(TAG, " - [" + this.f24925b + "] cancelled awaiting. remaining: " + this.a() + "ms");     // Catch: Throwable -> L45
        monitor-enter(this);
        this.f();     // Catch: Throwable -> L42
        x r13 = x.f38692a;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        throw th;
    L7:
        r0 = new c(this, r8);
        goto L8
    }

    private final void g() {
        if (this.f.compareAndSet(false, true) == false) goto L5;
        this.f24928e.launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new C0581b(this, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        Loog.INSTANCE.w(TAG, " - [" + this.f24925b + "] resume function already called.");
    }
}
