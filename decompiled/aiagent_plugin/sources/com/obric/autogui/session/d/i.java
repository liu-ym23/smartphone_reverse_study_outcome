package com.obric.autogui.session.d;

import android.content.Context;
import android.os.SystemClock;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.autogui.common.AutoOperateTask;
import com.obric.autogui.common.api.agent.AutoActionAgent;
import com.obric.autogui.common.api.agent.IAutoActionAgentApi;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.n;
import d.x;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: PendingAutoSessionManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i {
    private static final String TAG = "PendingAutoSessionMan";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f30907a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicReference<b> f30908b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicReference<AOThreadingTools.LaunchedJob> f30909c = null;

    /* JADX INFO: compiled from: PendingAutoSessionManager.kt */
    public static abstract class a {

        /* JADX INFO: renamed from: com.obric.autogui.session.d.i$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: PendingAutoSessionManager.kt */
        public static final class C0842a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final com.obric.autogui.session.a f30910a;

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, C0842a.class) == true) goto L8;
                return false;
            L8:
                C0842a r6 = (C0842a) ZeusTransformUtils.preCheckCast(r5, C0842a.class, "com.obric.aiagent.plugin");
                if (o.a(this.f30910a, r6.f30910a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f30910a.hashCode();
            }

            public String toString() {
                return "Created(session=" + this.f30910a + ')';
            }

            public C0842a(com.obric.autogui.session.a r2) {
                o.e(r2, SensitiveType.SESSION);
                super(null);
                this.f30910a = r2;
            }

            public final com.obric.autogui.session.a a() {
                return this.f30910a;
            }
        }

        /* JADX INFO: compiled from: PendingAutoSessionManager.kt */
        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f30911a = null;

            static {
                f30911a = new b();
            }

            public boolean equals(Object r3) {
                if (this != r3) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r3, b.class) == true) goto L9;
                return false;
            L9:
                b r2 = (b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.aiagent.plugin");
                return true;
            }

            public int hashCode() {
                return -921595587;
            }

            public String toString() {
                return "Disabled";
            }

            private b() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: PendingAutoSessionManager.kt */
        public static final class c extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f30912a;

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
                return false;
            L8:
                c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
                if (o.a(this.f30912a, r6.f30912a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f30912a.hashCode();
            }

            public String toString() {
                return "Failed(reason=" + this.f30912a + ')';
            }

            public c(String r2) {
                o.e(r2, "reason");
                super(null);
                this.f30912a = r2;
            }

            public final String a() {
                return this.f30912a;
            }
        }

        /* JADX INFO: compiled from: PendingAutoSessionManager.kt */
        public static final class d extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final com.obric.autogui.session.a f30913a;

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
                return false;
            L8:
                d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
                if (o.a(this.f30913a, r6.f30913a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f30913a.hashCode();
            }

            public String toString() {
                return "Reused(session=" + this.f30913a + ')';
            }

            public d(com.obric.autogui.session.a r2) {
                o.e(r2, SensitiveType.SESSION);
                super(null);
                this.f30913a = r2;
            }

            public final com.obric.autogui.session.a a() {
                return this.f30913a;
            }
        }

        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: PendingAutoSessionManager.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.autogui.session.a f30914a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f30915b;

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, b.class) == true) goto L8;
            return false;
        L8:
            b r8 = (b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f30914a, r8.f30914a) == true) goto L12;
            return false;
        L12:
            if (this.f30915b == r8.f30915b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f30914a.hashCode() * 31) + Long.hashCode(this.f30915b);
        }

        public String toString() {
            return "PendingEntry(session=" + this.f30914a + ", createdAtElapsed=" + this.f30915b + ')';
        }

        public b(com.obric.autogui.session.a r2, long r3) {
            o.e(r2, SensitiveType.SESSION);
            this.f30914a = r2;
            this.f30915b = r3;
        }

        public final com.obric.autogui.session.a a() {
            return this.f30914a;
        }

        public final long b() {
            return this.f30915b;
        }
    }

    /* JADX INFO: compiled from: PendingAutoSessionManager.kt */
    @d.c.b.a.f(b = "PendingAutoSessionManager.kt", c = {116}, d = "invokeSuspend", e = "com.obric.autogui.session.preload.PendingAutoSessionManager$rescheduleExpiry$1")
    static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f30916a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f30917b;

        c(b r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30917b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f30917b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f30916a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L11:
            b r8 = (b) ZeusTransformUtils.preCheckCast(i.c().get(), b.class, "com.obric.aiagent.plugin");
            if (r8 != this.f30917b) goto L17;
            if (i.c().compareAndSet(r8, null) == false) goto L17;
            Loog.INSTANCE.i(i.TAG, "[pending] expired key=" + this.f30917b.a().a() + ", age=" + (SystemClock.elapsedRealtime() - this.f30917b.b()) + "ms");
            i.a(i.f30907a, this.f30917b.a(), "expire");
        L17:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            AOThreadingTools r9 = AOThreadingTools.INSTANCE;
            long r4 = com.obric.autogui.common.a.d.f28974a.r();
            d.c.d<? super x> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30916a = 1;
            if (r9.delayForMillis(r4, r2) != r0) goto L11;
            return r0;
        }
    }

    private i() {
    }

    public static final /* synthetic */ void a(i r0, com.obric.autogui.session.a r1, String r2) {
        r0.b(r1, r2);
    }

    public static final /* synthetic */ AtomicReference c() {
        return f30908b;
    }

    static {
        f30907a = new i();
        f30908b = new AtomicReference(null);
        f30909c = new AtomicReference(null);
    }

    public final a a() {
        if (com.obric.autogui.common.a.d.f28974a.q() == true) goto L7;
        a("ensure_disabled");
        Loog.INSTANCE.i(TAG, "[pending] skipped: feature disabled");
        return (a) ZeusTransformUtils.preCheckCast(a.b.f30911a, a.class, "com.obric.aiagent.plugin");
    L7:
        if (AutoActionAgent.INSTANCE.hasOngoingTask() == false) goto L10;
        Loog.INSTANCE.i(TAG, "skip preCreateSession because already running a session");
        return (a) ZeusTransformUtils.preCheckCast(a.b.f30911a, a.class, "com.obric.aiagent.plugin");
    L10:
        IAutoActionAgentApi.IMPL.initLib();
        b r0 = (b) ZeusTransformUtils.preCheckCast(f30908b.get(), b.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L33;
        f30907a.a(r0);
        Loog.INSTANCE.i(TAG, "[pending] reuse existing session key=" + r0.a().a());
        return (a) ZeusTransformUtils.preCheckCast(new a.d(r0.a()), a.class, "com.obric.aiagent.plugin");
    L33:
        n.a r1 = n.f38560a;     // Catch: Throwable -> L16
        Object r2 = n.f(com.obric.autogui.b.b.f28935a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ((i) ZeusTransformUtils.preCheckCast(this, i.class, "com.obric.aiagent.plugin")).d()));     // Catch: Throwable -> L16
    L18:
        Throwable r3 = n.c(r2);
        if (r3 == null) goto L22;
        Loog.INSTANCE.e(TAG, "[pending] create failed", r3);
    L22:
        if (n.b(r2) == false) goto L24;
        r2 = null;
    L24:
        com.obric.autogui.session.a r4 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r2, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L27;
        b r5 = new b(r4, SystemClock.elapsedRealtime());
        b r6 = (b) ZeusTransformUtils.preCheckCast(f30908b.getAndSet(r5), b.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L31;
        b(r6.a(), "replace");
    L31:
        a(r5);
        Loog.INSTANCE.i(TAG, "[pending] created session key=" + r4.a());
        return (a) ZeusTransformUtils.preCheckCast(new a.C0842a(r4), a.class, "com.obric.aiagent.plugin");
    L27:
        return (a) ZeusTransformUtils.preCheckCast(new a.c("create pending session failed"), a.class, "com.obric.aiagent.plugin");
    L16:
        th = move-exception;
        n.a r7 = n.f38560a;
        r2 = n.f(d.o.a(th));
        goto L18
    }

    public final com.obric.autogui.session.a b() {
        if (com.obric.autogui.common.a.d.f28974a.q() == true) goto L6;
        a("consume_disabled");
        Loog.INSTANCE.i(TAG, "[pending] consume skipped: feature disabled");
        return null;
    L6:
        b r0 = (b) ZeusTransformUtils.preCheckCast(f30908b.getAndSet(null), b.class, "com.obric.aiagent.plugin");
        AOThreadingTools.LaunchedJob r3 = (AOThreadingTools.LaunchedJob) ZeusTransformUtils.preCheckCast(f30909c.getAndSet(null), AOThreadingTools.LaunchedJob.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L9;
        r3.cancel();
    L9:
        if (r0 != null) goto L13;
        Loog.INSTANCE.i(TAG, "[pending] consume miss");
        return null;
    L13:
        if (r0.a().k().j() == false) goto L16;
        Loog.INSTANCE.w(TAG, "[pending] discard invalid preloaded space key=" + r0.a().a());
        b(r0.a(), "invalid_preloaded_space");
        return null;
    L16:
        Loog.INSTANCE.i(TAG, "[pending] consume hit key=" + r0.a().a() + ", age=" + (SystemClock.elapsedRealtime() - r0.b()) + "ms");
        return r0.a();
    }

    public final void a(com.obric.autogui.session.a r2, String r3) {
        o.e(r2, SensitiveType.SESSION);
        o.e(r3, "reason");
        b(r2, r3);
    }

    private final AutoOperateTask d() {
        AutoOperateTask r1 = new AutoOperateTask();
        r1.setUserTask("");
        r1.setLaunchOrigin(36);
        return r1;
    }

    private final void a(b r4) {
        AOThreadingTools.LaunchedJob r3 = (AOThreadingTools.LaunchedJob) ZeusTransformUtils.preCheckCast(f30909c.getAndSet(AOThreadingTools.INSTANCE.launchIOJob((d.h.a.m) ZeusTransformUtils.preCheckCast(new c(r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"))), AOThreadingTools.LaunchedJob.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L6;
        r3.cancel();
        return;
    }

    private final void a(String r4) {
        AOThreadingTools.LaunchedJob r3 = (AOThreadingTools.LaunchedJob) ZeusTransformUtils.preCheckCast(f30909c.getAndSet(null), AOThreadingTools.LaunchedJob.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L5;
        r3.cancel();
    L5:
        b r5 = (b) ZeusTransformUtils.preCheckCast(f30908b.getAndSet(null), b.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L9;
        Loog.INSTANCE.i(TAG, "[pending] clear existing session key=" + r5.a().a() + ", reason=" + r4);
        f30907a.b(r5.a(), r4);
        return;
    }

    private final void b(com.obric.autogui.session.a r6, String r7) {
        Loog.INSTANCE.i(TAG, "[pending] cleanup key=" + r6.a() + ", reason=" + r7);
        n.a r2 = n.f38560a;     // Catch: Throwable -> L5
        i r3 = (i) ZeusTransformUtils.preCheckCast(this, i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        r6.c("pending_" + r7);     // Catch: Throwable -> L5
        n.f(x.f38692a);     // Catch: Throwable -> L5
    L20:
        n.a r8 = n.f38560a;     // Catch: Throwable -> L9
        i r9 = (i) ZeusTransformUtils.preCheckCast(this, i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        r6.P();     // Catch: Throwable -> L9
        n.f(x.f38692a);     // Catch: Throwable -> L9
    L18:
        n.a r10 = n.f38560a;     // Catch: Throwable -> L13
        i r5 = (i) ZeusTransformUtils.preCheckCast(this, i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        r6.Q();     // Catch: Throwable -> L13
        n.f(x.f38692a);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        n.a r11 = n.f38560a;
        n.f(d.o.a(th));
        return;
    L9:
        th = move-exception;
        n.a r4 = n.f38560a;
        n.f(d.o.a(th));
    L5:
        th = move-exception;
        n.a r12 = n.f38560a;
        n.f(d.o.a(th));
        goto L20
    }
}
