package com.obric.aiagent.ipc.utils;

import android.os.Bundle;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.ITraceDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.l.n;
import d.m;
import d.s;
import java.util.Iterator;

/* JADX INFO: compiled from: IPCAnomalyTrace.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f18654a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile b f18655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ThreadLocal<Boolean> f18656c = null;

    /* JADX INFO: compiled from: IPCAnomalyTrace.kt */
    private static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f18657a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f18658b = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ a[] f18659d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ d.d.a f18660e = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f18661c;

        private static final /* synthetic */ a[] b() {
            return new a[]{f18657a, f18658b};
        }

        private a(String r1, int r2, String r3) {
            super(r1, r2);
            this.f18661c = r3;
        }

        public final String a() {
            return this.f18661c;
        }

        static {
            f18657a = new a("CALL", 0, "call");
            f18658b = new a("INVOKE", 1, "invoke");
            a[] r0 = b();
            f18659d = r0;
            f18660e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f18659d.clone(), a[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: IPCAnomalyTrace.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f18662a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f18663b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final c f18664c;

        /* JADX INFO: compiled from: IPCAnomalyTrace.kt */
        public static final class a {
            public /* synthetic */ a(d.h.b.h r1) {
                this();
            }

            private a() {
            }

            public final b a(com.obric.aiagent.ipc.utils.a r21) {
                o.e(r21, "config");
                com.obric.aiagent.ipc.utils.a r0 = new com.obric.aiagent.ipc.utils.a(false, 0, 0, 0, 15, null);
                Long r2 = Long.valueOf(r21.b());
                boolean r5 = true;
                if (((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).longValue() < 0) goto L5;
                boolean r3 = true;
            L6:
                Integer r7 = null;
                if (r3 == true) goto L10;
                r2 = null;
            L10:
                if (r2 == null) goto L12;
                long r4 = r2.longValue();
            L13:
                Integer r8 = Integer.valueOf(r21.c());
                if (((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L16;
                boolean r9 = true;
            L17:
                if (r9 == true) goto L20;
                r8 = null;
            L20:
                if (r8 == null) goto L22;
                int r10 = r8.intValue();
            L23:
                int r14 = r10;
                Integer r11 = Integer.valueOf(r21.d());
                if (((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.aiagent.plugin")).intValue() > 0) goto L27;
                r5 = false;
            L27:
                if (r5 == false) goto L29;
                r7 = r11;
            L29:
                if (r7 == null) goto L31;
                int r1 = r7.intValue();
            L33:
                return new b(r21.a(), new c(0, n.b(r4, 9223372036854775L) * 1000, r14, r1, 0, 17, null));
            L31:
                r1 = r0.d();
                goto L33
            L22:
                r10 = r0.c();
                goto L23
            L16:
                r9 = false;
                goto L17
            L12:
                r4 = r0.b();
                goto L13
            L5:
                r3 = false;
                goto L6
            }
        }

        static {
            f18662a = new a(null);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (this.f18663b == r6.f18663b) goto L12;
            return false;
        L12:
            if (o.a(this.f18664c, r6.f18664c) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.f18663b) * 31) + this.f18664c.hashCode();
        }

        public String toString() {
            return "RuntimeConfig(enabled=" + this.f18663b + ", detector=" + this.f18664c + ')';
        }

        public b(boolean r2, c r3) {
            o.e(r3, "detector");
            this.f18663b = r2;
            this.f18664c = r3;
        }

        public final boolean a() {
            return this.f18663b;
        }

        public final c b() {
            return this.f18664c;
        }
    }

    private d() {
    }

    static {
        f18654a = new d();
        f18655b = b.f18662a.a(new com.obric.aiagent.ipc.utils.a(false, 0, 0, 0, 14, null));
        f18656c = new ThreadLocal();
    }

    public final void a(com.obric.aiagent.ipc.utils.a r1) {
        o.e(r1, "config");
        f18655b = b.f18662a.a(r1);
    }

    public final void a(String r13, String r14, long r15, long r17) {
        o.e(r13, "tag");
        o.e(r14, "method");
        a(this, a.f18657a, r13, r14, r15, r17, null, 32, null);
    }

    public final void a(String r11, String r12, g r13, long r14, long r16) {
        o.e(r11, "tag");
        o.e(r12, "method");
        o.e(r13, "e");
        a(a.f18657a, r11, r12, r14, r16, r13);
    }

    public final void b(String r13, String r14, long r15, long r17) {
        o.e(r13, "tag");
        o.e(r14, "method");
        a(this, a.f18658b, r13, r14, r15, r17, null, 32, null);
    }

    public final void b(String r11, String r12, g r13, long r14, long r16) {
        o.e(r11, "tag");
        o.e(r12, "method");
        o.e(r13, "e");
        a(a.f18658b, r11, r12, r14, r16, r13);
    }

    static /* synthetic */ void a(d r10, a r11, String r12, String r13, long r14, long r16, g r18, int r19, Object r20) {
        if ((r19 & 32) == 0) goto L5;
        g r9 = null;
    L6:
        r10.a(r11, r12, r13, r14, r16, r9);
        return;
    L5:
        r9 = r18;
        goto L6
    }

    private final void a(a r17, String r18, String r19, long r20, long r22, g r24) {
        b r0 = f18655b;
        if (r0.a() == true) goto L5;
        return;
    L5:
        if (o.a(f18656c.get(), true) == true) goto L39;
        c r5 = r0.b();     // Catch: Throwable -> L13
        String r6 = r17.a();     // Catch: Throwable -> L13
        if (r24 == null) goto L10;
        boolean r11 = true;
    L11:
        com.obric.aiagent.ipc.utils.b r1 = r5.a(r6, r18, r19, r20, r11, r22 / 1000000);     // Catch: Throwable -> L13
    L15:
        if (r1 != null) goto L17;
        return;
    L17:
        f18656c.set(true);
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r1.a(), Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L23
    L20:
        if (r3.hasNext() == false) goto L25;
        f18654a.a(r17, r18, r19, r20, r24, (e) ZeusTransformUtils.preCheckCast(r3.next(), e.class, "com.obric.aiagent.plugin"), r1.b());     // Catch: Throwable -> L23
    L25:
        f18656c.remove();
        return;
    L23:
        th = move-exception;
        a(th);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        f18656c.remove();
        throw th;
    L10:
        r11 = false;
    L13:
        th = move-exception;
        a(th);
        r1 = null;
        goto L15
    }

    private final void a(a r3, String r4, String r5, long r6, g r8, e r9, int r10) {
        Bundle r7 = androidx.core.os.e.a(new m[]{s.a("ipc_direction", r3.a()), s.a("ipc_tag", r4), s.a("ipc_method", r5), s.a("ipc_anomaly_type", r9.a()), s.a("ipc_cost", Long.valueOf(r6 / 1000))});
        if (r9 != e.f18667c) goto L6;
        r7.putInt("ipc_window_count", r10);
    L6:
        if (r9 != e.f18665a) goto L9;
        if (r8 == null) goto L9;
        r7.putString("ipc_exception", a(r8));
    L9:
        a(r7);
    }

    private final String a(g r3) {
        String r2 = r3.getMessage();
        if (r2 == null) goto L9;
        d.n.j<String> r4 = d.o.o.f((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"));
        if (r4 == null) goto L9;
        String r5 = (String) ZeusTransformUtils.preCheckCast(d.n.m.d(r4), String.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L9;
        String r6 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L10:
        if (r6 != null) goto L12;
        r6 = "";
    L12:
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        if (r7.length() != 0) goto L15;
        boolean r1 = true;
    L16:
        if (r1 == false) goto L18;
        r7 = r3.getClass().getName();
    L18:
        o.c(r7, "ifEmpty(...)");
        return d.o.o.e((String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.aiagent.plugin"), 512);
    L15:
        r1 = false;
    L9:
        r6 = null;
        goto L10
    }

    private final void a(Throwable r3) {
        ILogDepend.Companion.w("IPC-BASE", "IPC anomaly trace failed", r3);     // Catch: Throwable -> L4
        return;
    }

    private final void a(Bundle r2) {
        ITraceDepend.Companion.report("ipc_anomaly", r2);
    }
}
