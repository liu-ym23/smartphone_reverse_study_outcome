package com.obric.aiagent.skill.virt.impl.c;

import android.os.SystemClock;
import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.skill.virt.api.VirtReportSink;
import com.obric.aiagent.skill.virt.api.m;
import com.obric.aiagent.skill.virt.api.q;
import com.obric.aiagent.skill.virt.api.t;
import com.obric.aiagent.skill.virt.api.w;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.l;
import d.h.b.o;
import d.k;
import d.l.n;
import d.x;

/* JADX INFO: compiled from: ShellMonitor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f22148a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.h.a.a<VirtReportSink> f22149b;

    /* JADX INFO: renamed from: com.obric.aiagent.skill.virt.impl.c.b$1, reason: invalid class name */
    /* JADX INFO: compiled from: ShellMonitor.kt */
    /* synthetic */ class AnonymousClass1 extends l implements d.h.a.a<VirtReportSink> {
        AnonymousClass1(Object r8) {
            super(0, r8, VirtReportSink.a.class, MonitorConstants.CONNECT_TYPE_GET, "get()Lcom/obric/aiagent/skill/virt/api/VirtReportSink;", 0);
        }

        public final VirtReportSink a() {
            return ((VirtReportSink.a) ZeusTransformUtils.preCheckCast(this.receiver, VirtReportSink.a.class, "com.obric.aiagent.plugin")).a();
        }

        @Override // d.h.a.a
        public /* synthetic */ VirtReportSink invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: ShellMonitor.kt */
    private static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: com.obric.aiagent.skill.virt.impl.c.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ShellMonitor.kt */
    public final class C0476b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f22150a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final q f22151b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f22152c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f22153d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final m f22154e;
        private long f;
        private long g;
        private boolean h;

        /* JADX INFO: renamed from: com.obric.aiagent.skill.virt.impl.c.b$b$a */
        /* JADX INFO: compiled from: ShellMonitor.kt */
        @d.c.b.a.f(b = "ShellMonitor.kt", c = {161}, d = "recordOutputSuspend", e = "com.obric.aiagent.skill.virt.impl.shell.ShellMonitor$Observation")
        static final class a<T> extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f22155a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            long f22156b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            /* synthetic */ Object f22157c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ C0476b f22158d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f22159e;

            a(C0476b r3, d.c.d<? super a> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f22158d = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                this.f22157c = r3;
                this.f22159e |= Integer.MIN_VALUE;
                return this.f22158d.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        public C0476b(b r2, q r3, String r4, String r5, m r6, long r7) {
            o.e(r3, "context");
            o.e(r4, "executionId");
            o.e(r5, "backendType");
            o.e(r6, "commandSummary");
            this.f22150a = r2;
            this.f22151b = r3;
            this.f22152c = r4;
            this.f22153d = r5;
            this.f22154e = r6;
            this.f = r7;
        }

        public final void a() {
            if (this.f != (-1)) goto L6;
            this.f = SystemClock.elapsedRealtime();
            return;
        }

        public final <T> T a(d.h.a.a<? extends T> r9) {
            d.h.a.a r10 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r9, d.h.a.a.class, "com.obric.aiagent.plugin");
            o.e(r10, "block");
            long r0 = SystemClock.elapsedRealtime();
            T r11 = (T) r10.invoke();
            this.g += n.a(SystemClock.elapsedRealtime() - r0, 0);
            return r11;
        L6:
            th = move-exception;
            this.g += n.a(SystemClock.elapsedRealtime() - r0, 0);
            throw th;
        }

        public final <T> Object a(d.h.a.b<? super d.c.d<? super T>, ? extends Object> r10, d.c.d<? super T> r11) {
            d.h.a.b r12 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r10, d.h.a.b.class, "com.obric.aiagent.plugin");
            d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r13, a.class) == false) goto L7;
            a r0 = (a) ZeusTransformUtils.preCheckCast(r13, a.class, "com.obric.aiagent.plugin");
            if ((r0.f22159e & Integer.MIN_VALUE) == 0) goto L7;
            r0.f22159e -= Integer.MIN_VALUE;
        L8:
            Object r14 = r0.f22157c;
            Object r2 = d.c.a.b.a();
            int r3 = r0.f22159e;
            if (r3 == 0) goto L18;
            if (r3 != 1) goto L17;
            long r9 = r0.f22156b;
            C0476b r1 = (C0476b) ZeusTransformUtils.preCheckCast(r0.f22155a, C0476b.class, "com.obric.aiagent.plugin");
            d.o.a(r14);     // Catch: Throwable -> L14
            long r7 = r9;
            C0476b this = r1;
        L22:
            this.g += n.a(SystemClock.elapsedRealtime() - r7, 0);
            return r14;
        L14:
            th = th;
            r7 = r9;
            this = r1;
        L25:
            this.g += n.a(SystemClock.elapsedRealtime() - r7, 0);
            throw th;
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L18:
            d.o.a(r14);
            r7 = SystemClock.elapsedRealtime();
            r0.f22155a = this;     // Catch: Throwable -> L24
            r0.f22156b = r7;     // Catch: Throwable -> L24
            r0.f22159e = 1;     // Catch: Throwable -> L24
            r14 = r12.invoke(r0);     // Catch: Throwable -> L24
            if (r14 != r2) goto L22;
            return r2;
        L24:
            th = th;
        L7:
            r0 = new a(this, r13);
            goto L8
        }

        public final void a(com.obric.aiagent.skill.virt.api.n r12, long r13, long r15) {
            o.e(r12, "result");
            a(b.a(this.f22150a, r12.a().g(), r12.b(), r12.a().f(), r12.a().h()), r12.a().g(), r12.b().name(), r12.a().f(), r12.a().h(), r13, r15);
        }

        public final void a(boolean r11) {
            a("failure", null, null, false, r11, 0, 0);
        }

        private final void a(String r34, Integer r35, String r36, boolean r37, boolean r38, long r39, long r41) {
            if (this.h == false) goto L5;
            return;
        L5:
            this.h = true;
            long r1 = SystemClock.elapsedRealtime();
            long r21 = n.a(r1 - this.f22151b.c(), 0);
            long r3 = this.f;
            if (r3 == (-1)) goto L9;
            r1 = r3;
        L9:
            long r2 = n.a(r1 - this.f22151b.c(), 0, r21);
            long r4 = r21 - r2;
            long r5 = n.a(this.g, 0, r4);
            b.a(this.f22150a, new t(this.f22151b.a(), this.f22151b.b(), this.f22153d, this.f22152c, r34, r35, r36, true, this.f22154e.a(), this.f22154e.b(), this.f22154e.c(), r37, r38, r21, r2, r4 - r5, r5, r39, r41));
        }
    }

    /* JADX INFO: compiled from: ShellMonitor.kt */
    public interface c {

        /* JADX INFO: compiled from: ShellMonitor.kt */
        public static final class a implements c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f22160a = null;

            static {
                f22160a = new a();
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
                return -580672401;
            }

            public String toString() {
                return "Cancelled";
            }

            private a() {
            }
        }

        /* JADX INFO: renamed from: com.obric.aiagent.skill.virt.impl.c.b$c$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ShellMonitor.kt */
        public static final class C0477b implements c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f22161a;

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, C0477b.class) == true) goto L8;
                return false;
            L8:
                C0477b r6 = (C0477b) ZeusTransformUtils.preCheckCast(r5, C0477b.class, "com.obric.aiagent.plugin");
                if (this.f22161a == r6.f22161a) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return Integer.hashCode(this.f22161a);
            }

            public String toString() {
                return "Completed(exitCode=" + this.f22161a + ')';
            }

            public C0477b(int r1) {
                this.f22161a = r1;
            }

            public final int a() {
                return this.f22161a;
            }
        }

        /* JADX INFO: renamed from: com.obric.aiagent.skill.virt.impl.c.b$c$c, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ShellMonitor.kt */
        public static final class C0478c implements c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0478c f22162a = null;

            static {
                f22162a = new C0478c();
            }

            public boolean equals(Object r3) {
                if (this != r3) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r3, C0478c.class) == true) goto L9;
                return false;
            L9:
                C0478c r2 = (C0478c) ZeusTransformUtils.preCheckCast(r3, C0478c.class, "com.obric.aiagent.plugin");
                return true;
            }

            public int hashCode() {
                return 1091313119;
            }

            public String toString() {
                return "Failed";
            }

            private C0478c() {
            }
        }

        /* JADX INFO: compiled from: ShellMonitor.kt */
        public static final class d implements c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f22163a = null;

            static {
                f22163a = new d();
            }

            public boolean equals(Object r3) {
                if (this != r3) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r3, d.class) == true) goto L9;
                return false;
            L9:
                d r2 = (d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin");
                return true;
            }

            public int hashCode() {
                return -1972471367;
            }

            public String toString() {
                return "TimedOut";
            }

            private d() {
            }
        }
    }

    static {
        f22148a = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public b(d.h.a.a<? extends VirtReportSink> r3) {
        d.h.a.a<VirtReportSink> r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r4, "reportSinkProvider");
        this.f22149b = r4;
    }

    public static final /* synthetic */ String a(b r0, Integer r1, com.obric.aiagent.skill.virt.api.o r2, boolean r3, boolean r4) {
        return r0.a(r1, r2, r3, r4);
    }

    public static final /* synthetic */ void a(b r0, t r1) {
        r0.a(r1);
    }

    public /* synthetic */ b(d.h.a.a r2, int r3, h r4) {
        d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = (d.h.a.a) ZeusTransformUtils.preCheckCast(new AnonymousClass1(VirtReportSink.Companion), d.h.a.a.class, "com.obric.aiagent.plugin");
    L5:
        this(r5);
    }

    public final C0476b a(q r10, String r11, String r12, String r13) {
        o.e(r11, "executionId");
        o.e(r12, "backendType");
        o.e(r13, "command");
        if (r10 != null) goto L7;
        return null;
    L7:
        return new C0476b(this, r10, r11, r12, com.obric.aiagent.skill.virt.api.l.f21577a.a(r13), -1);
    }

    public final void a(String r33, String r34, String r35, c r36, boolean r37, long r38, long r40, long r42, long r44, long r46) {
        c r1 = (c) ZeusTransformUtils.wrapperContextForParams(r36, c.class, "com.obric.aiagent.plugin");
        o.e(r33, DBHelper.BATTERY_COL_SCENE);
        o.e(r34, "backendType");
        o.e(r35, "command");
        o.e(r1, "outcome");
        long r18 = n.a(SystemClock.elapsedRealtime() - r38, 0);
        long r20 = n.a(r40, 0, r18);
        long r3 = r18 - r20;
        long r24 = n.a(r42, 0, r3);
        m r0 = com.obric.aiagent.skill.virt.api.l.f21577a.a(r35);
        if (ZeusTransformUtils.instanceOf(r1, c.C0477b.class) == false) goto L5;
        c.C0477b r5 = (c.C0477b) ZeusTransformUtils.preCheckCast(r1, c.C0477b.class, "com.obric.aiagent.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r1, c.C0477b.class) == false) goto L13;
        if (((c.C0477b) ZeusTransformUtils.preCheckCast(r1, c.C0477b.class, "com.obric.aiagent.plugin")).a() != 0) goto L11;
        String r2 = "success";
    L21:
        if (r5 == null) goto L23;
        Integer r10 = Integer.valueOf(r5.a());
    L25:
        if (ZeusTransformUtils.instanceOf(r1, c.C0477b.class) == false) goto L29;
        String r6 = "COMPLETED";
    L27:
        String r11 = r6;
    L37:
        String r13 = r0.a();
        String r14 = r0.b();
        int r4 = r0.c();
        if (ZeusTransformUtils.instanceOf(r1, c.C0477b.class) == false) goto L40;
    L43:
        boolean r16 = true;
    L45:
        if (o.a(r1, c.d.f22163a) == false) goto L47;
    L50:
        boolean r17 = true;
    L51:
        a(new t("primitive", r33, r34, null, r2, r10, r11, r37, r13, r14, r4, r16, r17, r18, r20, r3 - r24, r24, r44, r46, 8, null));
        return;
    L47:
        if (o.a(r1, c.a.f22160a) == true) goto L50;
        r17 = false;
        goto L51
    L40:
        if (o.a(r1, c.d.f22163a) == true) goto L43;
        r16 = false;
        goto L45
    L29:
        if (o.a(r1, c.d.f22163a) == false) goto L32;
        r6 = "HARD_TIMEOUT";
        goto L27
    L32:
        if (o.a(r1, c.a.f22160a) == false) goto L35;
        r6 = "CANCELLED";
        goto L27
    L35:
        if (o.a(r1, c.C0478c.f22162a) == false) goto L54;
        r11 = null;
        goto L37
    L54:
        throw new k();
    L23:
        r10 = null;
    L11:
        r2 = "failure";
        goto L21
    L13:
        if (o.a(r1, c.d.f22163a) == false) goto L16;
        r2 = "timeout";
        goto L21
    L16:
        if (o.a(r1, c.C0478c.f22162a) == true) goto L11;
        if (o.a(r1, c.a.f22160a) == false) goto L56;
        r2 = "cancel";
        goto L21
    L56:
        throw new k();
    L5:
        r5 = null;
        goto L7
    }

    private final void a(t r3) {
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L9
        VirtReportSink r2 = (VirtReportSink) ZeusTransformUtils.preCheckCast(((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin")).f22149b.invoke(), VirtReportSink.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        if (r2 == null) goto L6;
        r2.reportShell(r3);     // Catch: Throwable -> L9
        x r4 = x.f38692a;     // Catch: Throwable -> L9
    L7:
        Object r5 = d.n.f(r4);     // Catch: Throwable -> L9
    L11:
        Throwable r6 = d.n.c(r5);
        if (r6 != null) goto L14;
        return;
    L14:
        if (IAppContext.Companion.isDebug() == false) goto L16;
        ILogDepend.Companion.e("Virt/Monitor", "Virt report sink failed", r6);
        return;
    L16:
        ILogDepend.Companion.w("Virt/Monitor", "Virt report sink failed");
        return;
    L6:
        r4 = null;
    L9:
        th = move-exception;
        d.n.a r7 = d.n.f38560a;
        r5 = d.n.f(d.o.a(th));
        goto L11
    }

    public final boolean a(w r6) {
        o.e(r6, "report");
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L11
        VirtReportSink r5 = (VirtReportSink) ZeusTransformUtils.preCheckCast(((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin")).f22149b.invoke(), VirtReportSink.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        boolean r3 = true;
        if (r5 != null) goto L6;
    L8:
        r3 = false;
    L9:
        Object r7 = d.n.f(Boolean.valueOf(r3));     // Catch: Throwable -> L11
    L13:
        Throwable r8 = d.n.c(r7);
        if (r8 == null) goto L20;
        if (IAppContext.Companion.isDebug() == false) goto L18;
        ILogDepend.Companion.e("Virt/Monitor", "Virt diagnostics report sink failed", r8);
        goto L20
    L18:
        ILogDepend.Companion.w("Virt/Monitor", "Virt diagnostics report sink failed");
    L20:
        if (d.n.b(r7) == false) goto L23;
        r7 = false;
    L23:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r7, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L6:
        if (r5.reportDiagnostics(r6) != true) goto L8;
    L11:
        th = move-exception;
        d.n.a r9 = d.n.f38560a;
        r7 = d.n.f(d.o.a(th));
        goto L13
    }

    private final String a(Integer r1, com.obric.aiagent.skill.virt.api.o r2, boolean r3, boolean r4) {
        if (r4 == false) goto L5;
        return "killed";
    L5:
        if (r2 != com.obric.aiagent.skill.virt.api.o.f21587c) goto L8;
        return "timeout";
    L8:
        if (r2 != com.obric.aiagent.skill.virt.api.o.f21586b) goto L10;
        return "pending";
    L10:
        if (r3 == false) goto L16;
        if (r1 == null) goto L16;
        if (r1.intValue() != 0) goto L16;
        return "success";
    L16:
        return "failure";
    }
}
