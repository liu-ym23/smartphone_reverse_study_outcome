package com.bytedance.safetyguard.lxc.internal.d;

import com.bytedance.safetyguard.lxc.api.ActionContextToken;
import com.bytedance.safetyguard.lxc.api.ActionEgressResult;
import com.bytedance.safetyguard.lxc.api.ActionEgressStatus;
import com.bytedance.safetyguard.lxc.api.AttemptedOutboundTarget;
import com.bytedance.safetyguard.lxc.api.OutboundTarget;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: ActionInterceptionController.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b f10082a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final s f10083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f10084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f10085d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f10086e;
    private f f;

    /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActionInterceptionController.kt */
    private interface InterfaceC0227a {

        /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.d.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ActionInterceptionController.kt */
        public static final class C0228a implements InterfaceC0227a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f10087a;

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, C0228a.class) == true) goto L8;
                return false;
            L8:
                C0228a r6 = (C0228a) ZeusTransformUtils.preCheckCast(r5, C0228a.class, "com.obric.aiagent.plugin");
                if (d.h.b.o.a(this.f10087a, r6.f10087a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f10087a.hashCode();
            }

            public String toString() {
                return "Failure(code=" + this.f10087a + ')';
            }

            public C0228a(String r2) {
                d.h.b.o.e(r2, MonitorConstants.CODE);
                this.f10087a = r2;
            }

            public final String a() {
                return this.f10087a;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.d.a$a$b */
        /* JADX INFO: compiled from: ActionInterceptionController.kt */
        public static final class b implements InterfaceC0227a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final ActionContextToken f10088a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final ActionEgressStatus f10089b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final long f10090c;

            public boolean equals(Object r7) {
                if (this != r7) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r7, b.class) == true) goto L8;
                return false;
            L8:
                b r8 = (b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.aiagent.plugin");
                if (d.h.b.o.a(this.f10088a, r8.f10088a) == true) goto L12;
                return false;
            L12:
                if (this.f10089b == r8.f10089b) goto L15;
                return false;
            L15:
                if (this.f10090c == r8.f10090c) goto L17;
                return false;
            L17:
                return true;
            }

            public int hashCode() {
                return (((this.f10088a.hashCode() * 31) + this.f10089b.hashCode()) * 31) + Long.hashCode(this.f10090c);
            }

            public String toString() {
                return "Success(token=" + this.f10088a + ", status=" + this.f10089b + ", sequence=" + this.f10090c + ')';
            }

            public b(ActionContextToken r2, ActionEgressStatus r3, long r4) {
                d.h.b.o.e(r2, "token");
                d.h.b.o.e(r3, "status");
                this.f10088a = r2;
                this.f10089b = r3;
                this.f10090c = r4;
            }

            public final ActionContextToken a() {
                return this.f10088a;
            }

            public final ActionEgressStatus b() {
                return this.f10089b;
            }

            public final long c() {
                return this.f10090c;
            }
        }
    }

    /* JADX INFO: compiled from: ActionInterceptionController.kt */
    private static final class b {
        public /* synthetic */ b(d.h.b.h r1) {
            this();
        }

        public final long a(long r3) {
            if (r3 != Long.MAX_VALUE) goto L6;
            return r3;
        L6:
            return r3 + 1;
        }

        private b() {
        }
    }

    /* JADX INFO: compiled from: ActionInterceptionController.kt */
    private interface c {

        /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.d.a$c$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ActionInterceptionController.kt */
        public static final class C0229a implements c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f10091a;

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, C0229a.class) == true) goto L8;
                return false;
            L8:
                C0229a r6 = (C0229a) ZeusTransformUtils.preCheckCast(r5, C0229a.class, "com.obric.aiagent.plugin");
                if (d.h.b.o.a(this.f10091a, r6.f10091a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f10091a.hashCode();
            }

            public String toString() {
                return "Failure(code=" + this.f10091a + ')';
            }

            public C0229a(String r2) {
                d.h.b.o.e(r2, MonitorConstants.CODE);
                this.f10091a = r2;
            }

            public final String a() {
                return this.f10091a;
            }
        }

        /* JADX INFO: compiled from: ActionInterceptionController.kt */
        public static final class b implements c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final ActionEgressResult f10092a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final long f10093b;

            public boolean equals(Object r7) {
                if (this != r7) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r7, b.class) == true) goto L8;
                return false;
            L8:
                b r8 = (b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.aiagent.plugin");
                if (d.h.b.o.a(this.f10092a, r8.f10092a) == true) goto L12;
                return false;
            L12:
                if (this.f10093b == r8.f10093b) goto L14;
                return false;
            L14:
                return true;
            }

            public int hashCode() {
                return (this.f10092a.hashCode() * 31) + Long.hashCode(this.f10093b);
            }

            public String toString() {
                return "Success(result=" + this.f10092a + ", sequence=" + this.f10093b + ')';
            }

            public b(ActionEgressResult r2, long r3) {
                d.h.b.o.e(r2, "result");
                this.f10092a = r2;
                this.f10093b = r3;
            }

            public final ActionEgressResult a() {
                return this.f10092a;
            }

            public final long b() {
                return this.f10093b;
            }
        }
    }

    /* JADX INFO: compiled from: ActionInterceptionController.kt */
    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f10094a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ActionEgressStatus f10095b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f10096c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f10097d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f10098e;

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, d.class) == true) goto L8;
            return false;
        L8:
            d r10 = (d) ZeusTransformUtils.preCheckCast(r9, d.class, "com.obric.aiagent.plugin");
            if (this.f10094a == r10.f10094a) goto L12;
            return false;
        L12:
            if (this.f10095b == r10.f10095b) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f10096c, r10.f10096c) == true) goto L18;
            return false;
        L18:
            if (this.f10097d == r10.f10097d) goto L21;
            return false;
        L21:
            if (this.f10098e == r10.f10098e) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            return (((((((Long.hashCode(this.f10094a) * 31) + this.f10095b.hashCode()) * 31) + this.f10096c.hashCode()) * 31) + Long.hashCode(this.f10097d)) * 31) + Boolean.hashCode(this.f10098e);
        }

        public String toString() {
            return "OpenAudit(sequence=" + this.f10094a + ", status=" + this.f10095b + ", targetRef=" + this.f10096c + ", count=" + this.f10097d + ", allowed=" + this.f10098e + ')';
        }

        public d(long r2, ActionEgressStatus r4, String r5, long r6, boolean r8) {
            d.h.b.o.e(r4, "status");
            d.h.b.o.e(r5, "targetRef");
            this.f10094a = r2;
            this.f10095b = r4;
            this.f10096c = r5;
            this.f10097d = r6;
            this.f10098e = r8;
        }

        public final long a() {
            return this.f10094a;
        }

        public final ActionEgressStatus b() {
            return this.f10095b;
        }

        public final String c() {
            return this.f10096c;
        }

        public final long d() {
            return this.f10097d;
        }

        public final boolean e() {
            return this.f10098e;
        }
    }

    /* JADX INFO: compiled from: ActionInterceptionController.kt */
    private static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ae f10099a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d f10100b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
            return false;
        L8:
            e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f10099a, r6.f10099a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f10100b, r6.f10100b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = this.f10099a.hashCode() * 31;
            d r1 = this.f10100b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "OpenOutcome(decision=" + this.f10099a + ", audit=" + this.f10100b + ')';
        }

        public e(ae r3, d r4) {
            ae r5 = (ae) ZeusTransformUtils.wrapperContextForParams(r3, ae.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r5, "decision");
            this.f10099a = r5;
            this.f10100b = r4;
        }

        public final ae a() {
            return this.f10099a;
        }

        public final d b() {
            return this.f10100b;
        }
    }

    /* JADX INFO: compiled from: ActionInterceptionController.kt */
    private interface f {

        /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.d.a$f$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ActionInterceptionController.kt */
        public static final class C0230a implements f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f10101a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final ActionContextToken f10102b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final m f10103c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final LinkedHashMap<OutboundTarget, Long> f10104d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private long f10105e;

            public C0230a(String r2, ActionContextToken r3, m r4) {
                d.h.b.o.e(r2, "ownerId");
                d.h.b.o.e(r3, "token");
                d.h.b.o.e(r4, "context");
                this.f10101a = r2;
                this.f10102b = r3;
                this.f10103c = r4;
                this.f10104d = new LinkedHashMap();
            }

            public final String a() {
                return this.f10101a;
            }

            public final ActionContextToken b() {
                return this.f10102b;
            }

            public final m getContext() {
                return this.f10103c;
            }

            public final long a(OutboundTarget r6) {
                d.h.b.o.e(r6, "target");
                Long r0 = (Long) ZeusTransformUtils.preCheckCast(this.f10104d.get(r6), Long.class, "com.obric.aiagent.plugin");
                if (r0 == null) goto L7;
                long r1 = a.c().a(r0.longValue());
                Long r3 = Long.valueOf(r1);
                ((Map) ZeusTransformUtils.preCheckCast(this.f10104d, Map.class, "com.obric.aiagent.plugin")).put(r6, r3);
                return r1;
            L7:
                if (this.f10104d.size() >= 512) goto L10;
                ((Map) ZeusTransformUtils.preCheckCast(this.f10104d, Map.class, "com.obric.aiagent.plugin")).put(r6, 1L);
                return 1;
            L10:
                long r2 = a.c().a(this.f10105e);
                this.f10105e = r2;
                return r2;
            }

            public final ActionEgressResult c() {
                ActionEgressStatus r2 = this.f10103c.a();
                List r0 = d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(this.f10103c.b(), Iterable.class, "com.obric.aiagent.plugin"));
                List r4 = d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(this.f10103c.c(), Iterable.class, "com.obric.aiagent.plugin"));
                List r5 = d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(this.f10103c.d(), Iterable.class, "com.obric.aiagent.plugin"));
                Map r1 = (Map) ZeusTransformUtils.preCheckCast(this.f10104d, Map.class, "com.obric.aiagent.plugin");
                Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r1.size()), Collection.class, "com.obric.aiagent.plugin");
                Iterator r3 = r1.entrySet().iterator();
            L4:
                if (r3.hasNext() == false) goto L6;
                Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.aiagent.plugin");
                r6.add(new AttemptedOutboundTarget((OutboundTarget) ZeusTransformUtils.preCheckCast(r7.getKey(), OutboundTarget.class, "com.obric.aiagent.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r7.getValue(), Number.class, "com.obric.aiagent.plugin")).longValue()));
                goto L4
            L6:
                List r8 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin");
                long r9 = this.f10105e;
                if (r9 <= 0) goto L9;
                boolean r12 = true;
            L11:
                return new ActionEgressResult(r2, r0, r4, r5, r8, r12, r9);
            L9:
                r12 = false;
                goto L11
            }
        }

        /* JADX INFO: compiled from: ActionInterceptionController.kt */
        public static final class b implements f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f10106a = null;

            static {
                f10106a = new b();
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
                return -616100848;
            }

            public String toString() {
                return "Closed";
            }

            private b() {
            }
        }

        /* JADX INFO: compiled from: ActionInterceptionController.kt */
        public static final class c implements f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f10107a = null;

            static {
                f10107a = new c();
            }

            public boolean equals(Object r3) {
                if (this != r3) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r3, c.class) == true) goto L9;
                return false;
            L9:
                c r2 = (c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.aiagent.plugin");
                return true;
            }

            public int hashCode() {
                return -550190216;
            }

            public String toString() {
                return "Idle";
            }

            private c() {
            }
        }

        /* JADX INFO: compiled from: ActionInterceptionController.kt */
        public static final class d implements f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f10108a = null;

            static {
                f10108a = new d();
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
                return 1644991137;
            }

            public String toString() {
                return "OrphanedBlocked";
            }

            private d() {
            }
        }
    }

    /* JADX INFO: compiled from: ActionInterceptionController.kt */
    public /* synthetic */ class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10109a = null;

        static {
            int[] r0 = new int[ActionEgressStatus.values().length];
            r0[ActionEgressStatus.ALLOWED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ActionEgressStatus.CLARIFICATION_REQUIRED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ActionEgressStatus.ACCESS_DENIED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f10109a = r0;
        }
    }

    static {
        f10082a = new b(null);
    }

    public a(s r3, String r4) {
        s r5 = (s) ZeusTransformUtils.wrapperContextForParams(r3, s.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "logger");
        d.h.b.o.e(r4, "sessionInstanceId");
        this.f10083b = r5;
        this.f10084c = r4;
        this.f10085d = new Object();
        this.f = (f) ZeusTransformUtils.preCheckCast(f.c.f10107a, f.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ b c() {
        return f10082a;
    }

    public /* synthetic */ a(s r2, String r3, int r4, d.h.b.h r5) {
        s r6 = (s) ZeusTransformUtils.wrapperContextForParams(r2, s.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = UUID.randomUUID().toString();
        d.h.b.o.c(r3, "toString(...)");
    L5:
        this(r6, r3);
    }

    public final Object a(String r6, String r7) {
        d.h.b.o.e(r6, "ownerId");
        d.h.b.o.e(r7, "outboundSensitiveDataJson");
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L42;
        Object r0 = this.f10085d;
        monitor-enter(r0);
        String r1 = d();     // Catch: Throwable -> L38
        monitor-exit(r0);
        if (r1 != null) goto L10;
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L13
        a r3 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        Object r8 = d.n.f(com.bytedance.safetyguard.lxc.internal.d.b.f10175a.a(r7));     // Catch: Throwable -> L13
    L16:
        if (d.n.c(r8) != null) goto L37;
        m r9 = (m) ZeusTransformUtils.preCheckCast(r8, m.class, "com.obric.aiagent.plugin");
        Object r4 = this.f10085d;
        monitor-enter(r4);
        String r5 = d();     // Catch: Throwable -> L33
        if (r5 == null) goto L22;
        InterfaceC0227a r10 = (InterfaceC0227a) ZeusTransformUtils.preCheckCast(new InterfaceC0227a.C0228a(r5), InterfaceC0227a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L33
    L23:
        monitor-exit(r4);
        if (ZeusTransformUtils.instanceOf(r10, InterfaceC0227a.C0228a.class) == false) goto L28;
        return b(((InterfaceC0227a.C0228a) ZeusTransformUtils.preCheckCast(r10, InterfaceC0227a.C0228a.class, "com.obric.aiagent.plugin")).a());
    L28:
        if (ZeusTransformUtils.instanceOf(r10, InterfaceC0227a.b.class) == false) goto L32;
        this.f10083b.b("ActionInterception", "component=action_interception event=action_activated outcome=success sessionRef=" + this.f10083b.a(this.f10084c) + " activationSequence=" + ((InterfaceC0227a.b) ZeusTransformUtils.preCheckCast(r10, InterfaceC0227a.b.class, "com.obric.aiagent.plugin")).c() + " status=" + ((InterfaceC0227a.b) ZeusTransformUtils.preCheckCast(r10, InterfaceC0227a.b.class, "com.obric.aiagent.plugin")).b());
        d.n.a r11 = d.n.f38560a;
        return d.n.f(((InterfaceC0227a.b) ZeusTransformUtils.preCheckCast(r10, InterfaceC0227a.b.class, "com.obric.aiagent.plugin")).a());
    L32:
        throw new d.k();
    L22:
        this.f10086e = f10082a.a(this.f10086e);     // Catch: Throwable -> L33
        ActionContextToken r12 = new ActionContextToken(this.f10084c, this.f10086e);     // Catch: Throwable -> L33
        this.f = (f) ZeusTransformUtils.preCheckCast(new f.C0230a(r6, r12, r9), f.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L33
        r10 = (InterfaceC0227a) ZeusTransformUtils.preCheckCast(new InterfaceC0227a.b(r12, r9.a(), this.f10086e), InterfaceC0227a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        throw th;
    L37:
        return b("INVALID_PAYLOAD");
    L13:
        th = move-exception;
        d.n.a r13 = d.n.f38560a;
        r8 = d.n.f(d.o.a(th));
        goto L16
    L10:
        return b(r1);
    L38:
        th = move-exception;
        throw th;
    L42:
        throw new IllegalArgumentException("Action owner must not be blank".toString());
    }

    public final ae a(OutboundTarget r17) {
        d.h.b.o.e(r17, "target");
        Object r2 = this.f10085d;
        monitor-enter(r2);
        f r3 = this.f;     // Catch: Throwable -> L44
        if (d.h.b.o.a(r3, f.c.f10107a) == false) goto L8;
        e r1 = new e((ae) ZeusTransformUtils.preCheckCast(ae.b.f10130a, ae.class, "com.obric.aiagent.plugin"), null);     // Catch: Throwable -> L44
    L28:
        monitor-exit(r2);
        d r4 = r1.b();
        if (r4 == null) goto L41;
        s r0 = this.f10083b;
        StringBuilder r5 = new StringBuilder().append("component=action_interception event=sensitive_egress_");
        if (r4.e() == false) goto L34;
        String r6 = "allowed";
    L35:
        StringBuilder r7 = r5.append(r6).append(" outcome=");
        if (r4.e() == false) goto L38;
        String r8 = "allow";
    L39:
        r0.a("ActionInterception", r7.append(r8).append(" activationSequence=").append(r4.a()).append(" status=").append(r4.b()).append(" targetRef=").append(r4.c()).append(" count=").append(r4.d()).toString());
        goto L41
    L38:
        r8 = "deny";
        goto L39
    L34:
        r6 = "blocked";
    L41:
        return r1.a();
    L8:
        if (d.h.b.o.a(r3, f.d.f10108a) == false) goto L10;
        boolean r9 = true;
    L11:
        if (r9 == false) goto L14;
        r1 = new e((ae) ZeusTransformUtils.preCheckCast(ae.d.f10134a, ae.class, "com.obric.aiagent.plugin"), null);     // Catch: Throwable -> L44
        goto L28
    L14:
        if (ZeusTransformUtils.instanceOf(r3, f.C0230a.class) == false) goto L43;
        long r10 = ((f.C0230a) ZeusTransformUtils.preCheckCast(r3, f.C0230a.class, "com.obric.aiagent.plugin")).a(r17);     // Catch: Throwable -> L44
        int r11 = g.f10109a[((f.C0230a) ZeusTransformUtils.preCheckCast(r3, f.C0230a.class, "com.obric.aiagent.plugin")).getContext().a().ordinal()];     // Catch: Throwable -> L44
        if (r11 != 1) goto L18;
        ae r12 = (ae) ZeusTransformUtils.preCheckCast(new ae.a(((f.C0230a) ZeusTransformUtils.preCheckCast(r3, f.C0230a.class, "com.obric.aiagent.plugin")).getContext().a(), ((f.C0230a) ZeusTransformUtils.preCheckCast(r3, f.C0230a.class, "com.obric.aiagent.plugin")).b().getActivationSequence$safetyguard_runtime_release(), r10), ae.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L44
    L27:
        r1 = new e(r12, new d(((f.C0230a) ZeusTransformUtils.preCheckCast(r3, f.C0230a.class, "com.obric.aiagent.plugin")).b().getActivationSequence$safetyguard_runtime_release(), ((f.C0230a) ZeusTransformUtils.preCheckCast(r3, f.C0230a.class, "com.obric.aiagent.plugin")).getContext().a(), this.f10083b.a(r17.getHost()), r10, ZeusTransformUtils.instanceOf(r12, ae.a.class)));     // Catch: Throwable -> L44
        goto L28
    L18:
        if (r11 != 2) goto L20;
    L24:
        r12 = (ae) ZeusTransformUtils.preCheckCast(new ae.c(((f.C0230a) ZeusTransformUtils.preCheckCast(r3, f.C0230a.class, "com.obric.aiagent.plugin")).getContext().a(), ((f.C0230a) ZeusTransformUtils.preCheckCast(r3, f.C0230a.class, "com.obric.aiagent.plugin")).b().getActivationSequence$safetyguard_runtime_release(), r10), ae.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L44
        goto L27
    L20:
        if (r11 == 3) goto L24;
        throw new d.k();     // Catch: Throwable -> L44
    L43:
        throw new d.k();     // Catch: Throwable -> L44
    L10:
        r9 = d.h.b.o.a(r3, f.b.f10106a);     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        throw th;
    }

    public final Object a(String r5, ActionContextToken r6) {
        d.h.b.o.e(r5, "ownerId");
        d.h.b.o.e(r6, "token");
        Object r0 = this.f10085d;
        monitor-enter(r0);
        f r1 = this.f;     // Catch: Throwable -> L34
        if (d.h.b.o.a(r1, f.b.f10106a) == false) goto L8;
        c r7 = (c) ZeusTransformUtils.preCheckCast(new c.C0229a("SESSION_CLOSED"), c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
    L22:
        monitor-exit(r0);
        if (ZeusTransformUtils.instanceOf(r7, c.C0229a.class) == false) goto L27;
        return b(((c.C0229a) ZeusTransformUtils.preCheckCast(r7, c.C0229a.class, "com.obric.aiagent.plugin")).a());
    L27:
        if (ZeusTransformUtils.instanceOf(r7, c.b.class) == false) goto L31;
        this.f10083b.b("ActionInterception", "component=action_interception event=action_finished outcome=success sessionRef=" + this.f10083b.a(this.f10084c) + " activationSequence=" + ((c.b) ZeusTransformUtils.preCheckCast(r7, c.b.class, "com.obric.aiagent.plugin")).b() + " status=" + ((c.b) ZeusTransformUtils.preCheckCast(r7, c.b.class, "com.obric.aiagent.plugin")).a().getStatus() + " targetCount=" + ((c.b) ZeusTransformUtils.preCheckCast(r7, c.b.class, "com.obric.aiagent.plugin")).a().getAttemptedTargets().size() + " unreportedAttemptCount=" + ((c.b) ZeusTransformUtils.preCheckCast(r7, c.b.class, "com.obric.aiagent.plugin")).a().getUnreportedAttemptCount());
        d.n.a r4 = d.n.f38560a;
        return d.n.f(((c.b) ZeusTransformUtils.preCheckCast(r7, c.b.class, "com.obric.aiagent.plugin")).a());
    L31:
        throw new d.k();
    L8:
        if (d.h.b.o.a(r1, f.c.f10107a) == false) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == false) goto L14;
        r7 = (c) ZeusTransformUtils.preCheckCast(new c.C0229a("NO_ACTIVE_ACTION"), c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
        goto L22
    L14:
        if (ZeusTransformUtils.instanceOf(r1, f.C0230a.class) == false) goto L33;
        if (d.h.b.o.a(((f.C0230a) ZeusTransformUtils.preCheckCast(r1, f.C0230a.class, "com.obric.aiagent.plugin")).a(), r5) == true) goto L19;
        r7 = (c) ZeusTransformUtils.preCheckCast(new c.C0229a("ACTION_OWNER_MISMATCH"), c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
        goto L22
    L19:
        if (a(r6, ((f.C0230a) ZeusTransformUtils.preCheckCast(r1, f.C0230a.class, "com.obric.aiagent.plugin")).b()) == true) goto L21;
        r7 = (c) ZeusTransformUtils.preCheckCast(new c.C0229a("TOKEN_MISMATCH"), c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
        goto L22
    L21:
        ActionEgressResult r8 = ((f.C0230a) ZeusTransformUtils.preCheckCast(r1, f.C0230a.class, "com.obric.aiagent.plugin")).c();     // Catch: Throwable -> L34
        this.f = (f) ZeusTransformUtils.preCheckCast(f.c.f10107a, f.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
        r7 = (c) ZeusTransformUtils.preCheckCast(new c.b(r8, ((f.C0230a) ZeusTransformUtils.preCheckCast(r1, f.C0230a.class, "com.obric.aiagent.plugin")).b().getActivationSequence$safetyguard_runtime_release()), c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
        goto L22
    L33:
        throw new d.k();     // Catch: Throwable -> L34
    L10:
        r2 = d.h.b.o.a(r1, f.d.f10108a);     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        throw th;
    }

    public final ai a() {
        Object r0 = this.f10085d;
        monitor-enter(r0);
        f r1 = this.f;     // Catch: Throwable -> L30
        this.f = (f) ZeusTransformUtils.preCheckCast(f.b.f10106a, f.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
        if (ZeusTransformUtils.instanceOf(r1, f.C0230a.class) == false) goto L8;
        ai r2 = new ai(((f.C0230a) ZeusTransformUtils.preCheckCast(r1, f.C0230a.class, "com.obric.aiagent.plugin")).a(), ((f.C0230a) ZeusTransformUtils.preCheckCast(r1, f.C0230a.class, "com.obric.aiagent.plugin")).b(), ((f.C0230a) ZeusTransformUtils.preCheckCast(r1, f.C0230a.class, "com.obric.aiagent.plugin")).c());     // Catch: Throwable -> L30
    L9:
        monitor-exit(r0);
        s r3 = this.f10083b;
        StringBuilder r4 = new StringBuilder().append("component=action_interception event=action_terminal_snapshot outcome=");
        if (r2 != null) goto L13;
        String r5 = "empty";
    L14:
        StringBuilder r7 = r4.append(r5).append(" sessionRef=").append(this.f10083b.a(this.f10084c)).append(" activationSequence=");
        if (r2 == null) goto L19;
        ActionContextToken r6 = r2.b();
        if (r6 == null) goto L19;
        long r8 = r6.getActivationSequence$safetyguard_runtime_release();
    L20:
        StringBuilder r9 = r7.append(r8).append(" targetCount=");
        if (r2 == null) goto L27;
        ActionEgressResult r10 = r2.c();
        if (r10 == null) goto L27;
        List<AttemptedOutboundTarget> r11 = r10.getAttemptedTargets();
        if (r11 == null) goto L27;
        int r12 = r11.size();
    L28:
        r3.b("ActionInterception", r9.append(r12).toString());
        return r2;
    L27:
        r12 = 0;
    L19:
        r8 = 0;
        goto L20
    L13:
        r5 = "success";
        goto L14
    L8:
        r2 = null;
    L30:
        th = move-exception;
        throw th;
    }

    public final void a(String r11) {
        d.h.b.o.e(r11, "ownerId");
        Object r0 = this.f10085d;
        monitor-enter(r0);
        f r1 = this.f;     // Catch: Throwable -> L18
        Long r3 = null;
        if (ZeusTransformUtils.instanceOf(r1, f.C0230a.class) == false) goto L7;
        f.C0230a r2 = (f.C0230a) ZeusTransformUtils.preCheckCast(r1, f.C0230a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
    L8:
        if (r2 != null) goto L11;
    L14:
        monitor-exit(r0);
        if (r3 == null) goto L23;
        s.a.a(this.f10083b, "ActionInterception", "component=action_interception event=action_owner_detached outcome=fail_closed sessionRef=" + this.f10083b.a(this.f10084c) + " activationSequence=" + r3, null, 4, null);
        return;
    L23:
        return;
    L11:
        if (d.h.b.o.a(r2.a(), r11) == false) goto L14;
        this.f = (f) ZeusTransformUtils.preCheckCast(f.d.f10108a, f.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        r3 = Long.valueOf(r2.b().getActivationSequence$safetyguard_runtime_release());     // Catch: Throwable -> L18
        goto L14
    L7:
        r2 = null;
    L18:
        th = move-exception;
        throw th;
    }

    public final void b() {
        Object r0 = this.f10085d;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (d.h.b.o.a(this.f, f.b.f10106a) == false) goto L7;
        boolean r1 = false;
    L9:
        monitor-exit(r0);
        if (r1 == false) goto L18;
        this.f10083b.b("ActionInterception", "component=action_interception event=action_controller_closed outcome=success sessionRef=" + this.f10083b.a(this.f10084c));
        return;
    L18:
        return;
    L7:
        this.f = (f) ZeusTransformUtils.preCheckCast(f.b.f10106a, f.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        r1 = true;
        goto L9
    }

    private final String d() {
        f r1 = this.f;
        if (d.h.b.o.a(r1, f.b.f10106a) == false) goto L6;
        return "SESSION_CLOSED";
    L6:
        if (ZeusTransformUtils.instanceOf(r1, f.C0230a.class) == false) goto L9;
        return "ACTION_ALREADY_ACTIVE";
    L9:
        if (d.h.b.o.a(r1, f.c.f10107a) == false) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == false) goto L16;
        return null;
    L16:
        throw new d.k();
    L11:
        r2 = d.h.b.o.a(r1, f.d.f10108a);
        goto L12
    }

    private final Object b(String r2) {
        b("lifecycle", r2);
        d.n.a r1 = d.n.f38560a;
        return d.n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException(r2), Throwable.class, "com.obric.aiagent.plugin")));
    }

    private final void b(String r7, String r8) {
        s.a.a(this.f10083b, "ActionInterception", "component=action_interception event=action_lifecycle_failed outcome=failed operation=" + r7 + " reason=" + r8 + " sessionRef=" + this.f10083b.a(this.f10084c), null, 4, null);
    }

    private final boolean a(ActionContextToken r3, ActionContextToken r4) {
        if (d.h.b.o.a(r3.getSessionInstanceId$safetyguard_runtime_release(), r4.getSessionInstanceId$safetyguard_runtime_release()) == true) goto L5;
    L7:
        return false;
    L5:
        if (r3.getActivationSequence$safetyguard_runtime_release() != r4.getActivationSequence$safetyguard_runtime_release()) goto L7;
        return true;
    }
}
