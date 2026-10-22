package com.obric.autogui.agents.a.a;

import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.autogui.agents.a.m.t;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.operator.p;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.n;
import d.x;

/* JADX INFO: compiled from: ActionEffectExecutionHandle.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {
    private static final String TAG = "ActionEffectHandle";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f26255a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autogui.operator.e f26256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.autogui.agents.a.a.a f26257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f26258d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final t f26259e;
    private final com.obric.autogui.agents.a.i.a f;
    private final Object g;
    private b h;
    private boolean i;

    /* JADX INFO: compiled from: ActionEffectExecutionHandle.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: ActionEffectExecutionHandle.kt */
    private interface b {

        /* JADX INFO: compiled from: ActionEffectExecutionHandle.kt */
        public static final class a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f26260a = null;

            static {
                f26260a = new a();
            }

            public boolean equals(Object r3) {
                if (this != r3) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r3, a.class) == true) goto L9;
                return false;
            L9:
                a r2 = (a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin");
                return true;
            }

            public int hashCode() {
                return 731308708;
            }

            public String toString() {
                return "Active";
            }

            private a() {
            }
        }

        /* JADX INFO: renamed from: com.obric.autogui.agents.a.a.g$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ActionEffectExecutionHandle.kt */
        public static final class C0660b implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0660b f26261a = null;

            static {
                f26261a = new C0660b();
            }

            public boolean equals(Object r3) {
                if (this != r3) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r3, C0660b.class) == true) goto L9;
                return false;
            L9:
                C0660b r2 = (C0660b) ZeusTransformUtils.preCheckCast(r3, C0660b.class, "com.obric.aiagent.plugin");
                return true;
            }

            public int hashCode() {
                return 2004940127;
            }

            public String toString() {
                return "Discarded";
            }

            private C0660b() {
            }
        }

        /* JADX INFO: compiled from: ActionEffectExecutionHandle.kt */
        public static final class c implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final f f26262a;

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
                return false;
            L8:
                c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
                if (o.a(this.f26262a, r6.f26262a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f26262a.hashCode();
            }

            public String toString() {
                return "Sealed(input=" + this.f26262a + ')';
            }

            public c(f r2) {
                o.e(r2, "input");
                this.f26262a = r2;
            }

            public final f a() {
                return this.f26262a;
            }
        }
    }

    static {
        f26255a = new a(null);
    }

    public static /* synthetic */ boolean lambda$ImBwBWIge6XzPnEGMgr6CNi68M8(g r0) {
        return a(r0);
    }

    public g(com.obric.autogui.operator.e r2, com.obric.autogui.agents.a.a.a r3, boolean r4, t r5, com.obric.autogui.agents.a.i.a r6) {
        o.e(r2, "step");
        o.e(r3, "attempt");
        o.e(r5, "timingRecorder");
        o.e(r6, "resourceCleanupScheduler");
        this.f26256b = r2;
        this.f26257c = r3;
        this.f26258d = r4;
        this.f26259e = r5;
        this.f = r6;
        this.g = new Object();
        this.h = (b) ZeusTransformUtils.preCheckCast(b.a.f26260a, b.class, "com.obric.aiagent.plugin");
    }

    public final boolean a() {
        return this.f26258d;
    }

    public final t b() {
        return this.f26259e;
    }

    public final String c() {
        return this.f26257c.a();
    }

    public final com.obric.autogui.agents.a.f.a d() {
        return this.f26257c.b();
    }

    public final Boolean e() {
        return this.f26257c.d();
    }

    public final boolean f() {
        return this.f26257c.e();
    }

    public final f a(String r8) {
        o.e(r8, DBHelper.BATTERY_COL_SOURCE);
        Object r0 = this.g;
        monitor-enter(r0);
        b r1 = this.h;     // Catch: Throwable -> L22
        if (ZeusTransformUtils.instanceOf(r1, b.c.class) == false) goto L8;
        f r7 = ((b.c) ZeusTransformUtils.preCheckCast(r1, b.c.class, "com.obric.aiagent.plugin")).a();     // Catch: Throwable -> L22
    L15:
        monitor-exit(r0);
        return r7;
    L8:
        if (o.a(r1, b.C0660b.f26261a) == false) goto L11;
        r7 = null;
        goto L15
    L11:
        if (o.a(r1, b.a.f26260a) == false) goto L21;
        d("seal");     // Catch: Throwable -> L22
        f r2 = this.f26257c.a(r8);     // Catch: Throwable -> L17
        this.h = (b) ZeusTransformUtils.preCheckCast(new b.c(r2), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        e("seal");     // Catch: Throwable -> L17
        Loog.INSTANCE.i(TAG, "[OAutoActionEffect] lifecycle sealed " + com.obric.autogui.agents.a.c.f26286a.a(r2.k()) + ", source=" + r8);     // Catch: Throwable -> L17
        r7 = r2;
        goto L15
    L17:
        th = move-exception;
        this.h = (b) ZeusTransformUtils.preCheckCast(b.C0660b.f26261a, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        e("seal_failed");     // Catch: Throwable -> L22
        Loog.INSTANCE.w(TAG, "[OAutoActionEffect] lifecycle seal failed " + com.obric.autogui.agents.a.c.f26286a.a(d().a(), c()) + ", source=" + r8 + ", error_type=" + com.obric.autogui.agents.a.b.a(th));     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L21:
        throw new d.k();     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    public final boolean b(String r7) {
        o.e(r7, "reason");
        Object r0 = this.g;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (o.a(this.h, b.a.f26260a) == true) goto L7;
        boolean r6 = false;
    L9:
        monitor-exit(r0);
        return r6;
    L7:
        d("discard");     // Catch: Throwable -> L11
        this.h = (b) ZeusTransformUtils.preCheckCast(b.C0660b.f26261a, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        e("discard_" + r7);     // Catch: Throwable -> L11
        Loog.INSTANCE.i(TAG, "[OAutoActionEffect] lifecycle discarded " + com.obric.autogui.agents.a.c.f26286a.a(d().a(), c()) + ", reason=" + r7);     // Catch: Throwable -> L11
        r6 = true;
        goto L9
    }

    public final boolean c(String r10) {
        o.e(r10, DBHelper.BATTERY_COL_SOURCE);
        Object r0 = this.g;
        monitor-enter(r0);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (this.i == false) goto L24;
        boolean r9 = true;
    L19:
        monitor-exit(r0);
        return r9;
    L24:
        n.a r1 = n.f38560a;     // Catch: Throwable -> L9
        Object r2 = n.f(Boolean.valueOf(((g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.aiagent.plugin")).f26257c.h()));     // Catch: Throwable -> L9
    L11:
        Throwable r3 = n.c(r2);     // Catch: Throwable -> L21
        if (r3 == null) goto L15;
        Loog.INSTANCE.w(TAG, "[OAutoActionEffect] lifecycle resource retry failed " + com.obric.autogui.agents.a.c.f26286a.a(d().a(), c()) + ", source=" + r10 + ", error_type=" + com.obric.autogui.agents.a.b.a(r3));     // Catch: Throwable -> L21
    L15:
        if (n.b(r2) == false) goto L17;
        r2 = false;
    L17:
        boolean r11 = ((Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();     // Catch: Throwable -> L21
        this.i = r11;     // Catch: Throwable -> L21
        r9 = r11;
        goto L19
    L9:
        th = move-exception;
        n.a r4 = n.f38560a;     // Catch: Throwable -> L21
        r2 = n.f(d.o.a(th));     // Catch: Throwable -> L21
        goto L11
    }

    private final void d(String r6) {
        n.a r1 = n.f38560a;     // Catch: Throwable -> L5
        g r2 = (g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        r2.f26256b.b((p) ZeusTransformUtils.preCheckCast(r2.f26257c, p.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L5
        Object r0 = n.f(x.f38692a);     // Catch: Throwable -> L5
    L7:
        Throwable r3 = n.c(r0);
        if (r3 == null) goto L13;
        Loog.INSTANCE.w(TAG, "[OAutoActionEffect] lifecycle observer clear failed " + com.obric.autogui.agents.a.c.f26286a.a(d().a(), c()) + ", source=" + r6 + ", error_type=" + com.obric.autogui.agents.a.b.a(r3));
        return;
    L13:
        return;
    L5:
        th = move-exception;
        n.a r4 = n.f38560a;
        r0 = n.f(d.o.a(th));
        goto L7
    }

    private final void e(String r4) {
        if (c(r4) == false) goto L5;
        return;
    L5:
        this.f.a(d().a(), c(), new $$Lambda$g$ImBwBWIge6XzPnEGMgr6CNi68M8(this));
    }

    private static final boolean a(g r1) {
        return r1.c("deferred_cleanup");
    }
}
