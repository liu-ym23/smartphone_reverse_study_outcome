package com.obric.aiagent.executionengine.scheduler.impl.a;

import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.o;
import d.x;
import java.util.List;
import kotlinx.coroutines.a.s;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: AtomicActionExecuteQueue.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f {
    private static final String TAG = "AtomicActionExecuteQueue";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18081a = null;
    private static final List<String> f = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f18082b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f18083c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final kotlinx.coroutines.a.d<com.obric.aiagent.executionengine.scheduler.impl.a.e> f18084d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final kotlinx.coroutines.b.h<com.obric.aiagent.executionengine.scheduler.impl.a.e> f18085e;

    /* JADX INFO: compiled from: AtomicActionExecuteQueue.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final List<String> a() {
            return f.a();
        }
    }

    /* JADX INFO: compiled from: AtomicActionExecuteQueue.kt */
    @d.c.b.a.f(b = "AtomicActionExecuteQueue.kt", c = {44}, d = "enqueue", e = "com.obric.aiagent.executionengine.scheduler.impl.action.AtomicActionExecuteQueue")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18086a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f18087b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ f f18088c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f18089d;

        b(f r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18088c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f18087b = r3;
            this.f18089d |= Integer.MIN_VALUE;
            return this.f18088c.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AtomicActionExecuteQueue.kt */
    @d.c.b.a.f(b = "AtomicActionExecuteQueue.kt", c = {65}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.scheduler.impl.action.AtomicActionExecuteQueue$executeAction$2")
    static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f18090a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ f f18091b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.executionengine.scheduler.impl.a.e f18092c;

        c(f r3, com.obric.aiagent.executionengine.scheduler.impl.a.e r4, d.c.d<? super c> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18091b = r3;
            this.f18092c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f18091b, this.f18092c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f18090a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            f r7 = this.f18091b;
            com.obric.aiagent.executionengine.scheduler.impl.a.e r2 = this.f18092c;
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18090a = 1;
            if (f.a(r7, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AtomicActionExecuteQueue.kt */
    @d.c.b.a.f(b = "AtomicActionExecuteQueue.kt", c = {101, ITaskManager.Stub.TRANSACTION_tryActiveAgent, 76}, d = "executeActionInternal", e = "com.obric.aiagent.executionengine.scheduler.impl.action.AtomicActionExecuteQueue")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18093a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f18094b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f18095c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f18096d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ f f18097e;
        int f;

        d(f r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18097e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f18096d = r3;
            this.f |= Integer.MIN_VALUE;
            return f.a(this.f18097e, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AtomicActionExecuteQueue.kt */
    @d.c.b.a.f(b = "AtomicActionExecuteQueue.kt", c = {50}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.scheduler.impl.action.AtomicActionExecuteQueue$init$1")
    static final class e extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f18098a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ f f18099b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f18100c;

        e(f r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18099b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            e r0 = new e(this.f18099b, r5);
            r0.f18100c = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f18098a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r7);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            final am r8 = (am) ZeusTransformUtils.preCheckCast(this.f18100c, am.class, "com.obric.aiagent.plugin");
            kotlinx.coroutines.b.h r2 = f.a(this.f18099b);
            final f r5 = this.f18099b;
            kotlinx.coroutines.b.i r9 = (kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r8, r5), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
            d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18098a = 1;
            if (r2.collect(r9, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.scheduler.impl.a.f$f, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AtomicActionExecuteQueue.kt */
    @d.c.b.a.f(b = "AtomicActionExecuteQueue.kt", c = {85}, d = "reallyDoAction", e = "com.obric.aiagent.executionengine.scheduler.impl.action.AtomicActionExecuteQueue")
    static final class C0375f extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18106a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f18107b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f18108c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f18109d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ f f18110e;
        int f;

        C0375f(f r3, d.c.d<? super C0375f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18110e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f18109d = r3;
            this.f |= Integer.MIN_VALUE;
            return f.c(this.f18110e, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public f(String r3) {
        d.h.b.o.e(r3, "pkgName");
        this.f18082b = r3;
        this.f18083c = "0x" + Integer.toHexString(hashCode());
        kotlinx.coroutines.a.d<com.obric.aiagent.executionengine.scheduler.impl.a.e> r4 = kotlinx.coroutines.a.g.a(-2, null, null, 6, null);
        this.f18084d = r4;
        this.f18085e = kotlinx.coroutines.b.j.a((s) ZeusTransformUtils.preCheckCast(r4, s.class, "com.obric.aiagent.plugin"));
        b();
    }

    public static final /* synthetic */ Object a(f r2, com.obric.aiagent.executionengine.scheduler.impl.a.e r3, d.c.d r4) {
        return r2.c(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ List a() {
        return f;
    }

    public static final /* synthetic */ kotlinx.coroutines.b.h a(f r0) {
        return r0.f18085e;
    }

    public static final /* synthetic */ Object b(f r2, com.obric.aiagent.executionengine.scheduler.impl.a.e r3, d.c.d r4) {
        return r2.b(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object c(f r2, com.obric.aiagent.executionengine.scheduler.impl.a.e r3, d.c.d r4) {
        return r2.d(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    static {
        f18081a = new a(null);
        f = p.b(new String[]{"System_AutoAction", "PC_GlobalSearchIntent", "PC_CommonGlobalSearch"});
    }

    public final Object a(com.obric.aiagent.executionengine.scheduler.impl.a.e r6, d.c.d<? super x> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r8, b.class, "com.obric.aiagent.plugin");
        if ((r0.f18089d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f18089d -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.f18087b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f18089d;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r6 = (com.obric.aiagent.executionengine.scheduler.impl.a.e) ZeusTransformUtils.preCheckCast(r0.f18086a, com.obric.aiagent.executionengine.scheduler.impl.a.e.class, "com.obric.aiagent.plugin");
        o.a(r9);
    L17:
        ISecureLogDepend.Companion.i(TAG, "enqueue done: action=" + r6);
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r9);
        kotlinx.coroutines.a.d<com.obric.aiagent.executionengine.scheduler.impl.a.e> r5 = this.f18084d;
        r0.f18086a = r6;
        r0.f18089d = 1;
        if (r5.a(r6, r0) != r2) goto L17;
        return r2;
    L7:
        r0 = new b(this, r8);
        goto L8
    }

    private final void b() {
        kotlinx.coroutines.i.a(g.f18111a.b(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new e(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final Object b(com.obric.aiagent.executionengine.scheduler.impl.a.e r5, d.c.d<? super x> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        Object r4 = kotlinx.coroutines.i.a(com.obric.aiagent.executionengine.scheduler.impl.job.d.f18489a.d().a(), (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(this, r5, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r7);
        if (r4 != d.c.a.b.a()) goto L6;
        return r4;
    L6:
        return x.f38692a;
    }

    private final Object c(com.obric.aiagent.executionengine.scheduler.impl.a.e r9, d.c.d<? super x> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, d.class) == false) goto L7;
        d r0 = (d) ZeusTransformUtils.preCheckCast(r11, d.class, "com.obric.aiagent.plugin");
        if ((r0.f & Integer.MIN_VALUE) == 0) goto L7;
        r0.f -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.f18096d;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f;
        if (r3 == 0) goto L22;
        if (r3 == 1) goto L21;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        o.a(r12);
    L42:
        return x.f38692a;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        kotlinx.coroutines.f.a r8 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r0.f18093a, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        o.a(r12);     // Catch: Throwable -> L19
    L31:
        x r13 = x.f38692a;     // Catch: Throwable -> L19
        r8.b(null);
        return x.f38692a;
    L19:
        th = th;
    L36:
        r8.b(null);
        throw th;
    L21:
        kotlinx.coroutines.f.a r14 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r0.f18095c, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        r9 = (com.obric.aiagent.executionengine.scheduler.impl.a.e) ZeusTransformUtils.preCheckCast(r0.f18094b, com.obric.aiagent.executionengine.scheduler.impl.a.e.class, "com.obric.aiagent.plugin");
        f r1 = (f) ZeusTransformUtils.preCheckCast(r0.f18093a, f.class, "com.obric.aiagent.plugin");
        o.a(r12);
        kotlinx.coroutines.f.a r15 = r14;
        f this = r1;
    L43:
        r0.f18093a = r15;     // Catch: Throwable -> L34
        r0.f18094b = null;     // Catch: Throwable -> L34
        r0.f18095c = null;     // Catch: Throwable -> L34
        r0.f = 2;     // Catch: Throwable -> L34
        if (this.d(r9, r0) != r2) goto L30;
        return r2;
    L30:
        r8 = r15;
    L34:
        th = th;
        r8 = r15;
        goto L36
    L22:
        o.a(r12);
        if (r9.m() == false) goto L38;
        r15 = g.f18111a.a();
        r0.f18093a = this;
        r0.f18094b = r9;
        r0.f18095c = r15;
        r0.f = 1;
        if (r15.a(null, r0) != r2) goto L43;
        return r2;
    L38:
        r0.f = 3;
        if (d(r9, r0) != r2) goto L42;
        return r2;
    L7:
        r0 = new d(this, r11);
        goto L8
    }

    private final Object d(com.obric.aiagent.executionengine.scheduler.impl.a.e r10, d.c.d<? super x> r11) {
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, C0375f.class) == false) goto L7;
        C0375f r0 = (C0375f) ZeusTransformUtils.preCheckCast(r12, C0375f.class, "com.obric.aiagent.plugin");
        if ((r0.f & Integer.MIN_VALUE) == 0) goto L7;
        r0.f -= Integer.MIN_VALUE;
    L8:
        Object r13 = r0.f18109d;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        long r9 = r0.f18108c;
        com.obric.aiagent.executionengine.scheduler.impl.a.e r4 = (com.obric.aiagent.executionengine.scheduler.impl.a.e) ZeusTransformUtils.preCheckCast(r0.f18107b, com.obric.aiagent.executionengine.scheduler.impl.a.e.class, "com.obric.aiagent.plugin");
        f r1 = (f) ZeusTransformUtils.preCheckCast(r0.f18106a, f.class, "com.obric.aiagent.plugin");
        o.a(r13);
    L18:
        ISecureLogDepend.Companion.i(TAG, '[' + r1.f18083c + "] really action done! action=" + r4 + ", spent " + (System.currentTimeMillis() - r9) + "ms");
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r13);
        ISecureLogDepend.Companion.i(TAG, '[' + this.f18083c + "] really do action uiLocked=" + g.f18111a.a().a() + ", action=" + r10);
        long r7 = System.currentTimeMillis();
        r0.f18106a = this;
        r0.f18107b = r10;
        r0.f18108c = r7;
        r0.f = 1;
        if (r10.a(r0) != r2) goto L17;
        return r2;
    L17:
        r1 = this;
        r4 = r10;
        r9 = r7;
    L7:
        r0 = new C0375f(this, r12);
        goto L8
    }

    public String toString() {
        return "AtomicActionRunQueue(" + this.f18083c + " packageName=" + this.f18082b + ')';
    }
}
