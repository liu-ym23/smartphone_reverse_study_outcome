package com.obric.agent.trace.toolmetrics;

import com.bytedance.security.zenmobile.io.SensitiveType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: OmniClientToolTraceCoordinator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f15911a = null;
    private static final d.o.k g = null;
    private static final d.o.k h = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final o f15912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final t f15913c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final q f15914d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final x f15915e;
    private final long f;

    /* JADX INFO: compiled from: OmniClientToolTraceCoordinator.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OmniClientToolTraceCoordinator.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15916a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f15917b = null;

        static {
            int[] r0 = new int[j.values().length];
            r0[j.f15893a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[j.f15894b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L6:
            f15916a = r0;
            int[] r1 = new int[v.values().length];
            r1[v.f15930a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L21:
            r1[v.f15931b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L9:
            f15917b = r1;
        }
    }

    public static /* synthetic */ boolean lambda$0kCGjGlcBSzM2XMZFEBdgTcqExY(p r0, String r1, com.obric.agent.trace.toolmetrics.a r2, long r3) {
        return a(r0, r1, r2, r3);
    }

    public static /* synthetic */ boolean lambda$7PIqiZDpK8NHquzvpw6NTounaXM(n r0, p r1, Map r2, com.obric.agent.trace.toolmetrics.a r3, long r4) {
        return a(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ boolean lambda$zlXdqE8MA0pxcacRbWtEwPBgrbM(j r0, p r1, com.obric.agent.trace.toolmetrics.a r2, long r3) {
        return a(r0, r1, r2, r3);
    }

    public p(o r3, t r4, q r5, x r6, long r7) {
        o r8 = (o) ZeusTransformUtils.wrapperContextForParams(r3, o.class, "com.obric.aiagent.plugin");
        t r9 = (t) ZeusTransformUtils.wrapperContextForParams(r4, t.class, "com.obric.aiagent.plugin");
        q r10 = (q) ZeusTransformUtils.wrapperContextForParams(r5, q.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r8, "clock");
        d.h.b.o.e(r9, "eventSink");
        d.h.b.o.e(r10, "diagnosticSink");
        d.h.b.o.e(r6, "store");
        this.f15912b = r8;
        this.f15913c = r9;
        this.f15914d = r10;
        this.f15915e = r6;
        this.f = r7;
    }

    public /* synthetic */ p(o r5, t r6, q r7, x r8, long r9, int r11, d.h.b.h r12) {
        o r10 = (o) ZeusTransformUtils.wrapperContextForParams(r5, o.class, "com.obric.aiagent.plugin");
        t r13 = (t) ZeusTransformUtils.wrapperContextForParams(r6, t.class, "com.obric.aiagent.plugin");
        q r14 = (q) ZeusTransformUtils.wrapperContextForParams(r7, q.class, "com.obric.aiagent.plugin");
        if ((r11 & 4) == 0) goto L5;
        r14 = (q) ZeusTransformUtils.preCheckCast(com.obric.agent.trace.toolmetrics.b.f15871a, q.class, "com.obric.aiagent.plugin");
    L5:
        q r0 = r14;
        if ((r11 & 8) == 0) goto L8;
        r8 = new x(0, 0, 3, null);
    L8:
        x r1 = r8;
        if ((r11 & 16) == 0) goto L11;
        r9 = 900000;
    L11:
        this(r10, r13, r0, r1, r9);
    }

    public final z a() {
        long r3 = this.f15912b.a();
        com.obric.agent.trace.toolmetrics.a r0 = new com.obric.agent.trace.toolmetrics.a("tool_trace_" + UUID.randomUUID(), r3, this.f + r3);
        com.obric.agent.trace.toolmetrics.a r1 = this.f15915e.a(r0);
        if (r1 == null) goto L6;
        a(r1);
    L6:
        return new z(r0.a());
    }

    public final z a(String r3) {
        d.h.b.o.e(r3, "messageId");
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L6;
        r3 = null;
    L6:
        if (r3 == null) goto L11;
        com.obric.agent.trace.toolmetrics.a r2 = this.f15915e.b(r3);
        if (r2 != null) goto L10;
        return null;
    L10:
        return new z(r2.a());
    L11:
        return null;
    }

    public final void a(z r2, final j r3) {
        d.h.b.o.e(r2, "token");
        d.h.b.o.e(r3, "point");
        a(r2, new $$Lambda$p$zlXdqE8MA0pxcacRbWtEwPBgrbM(r3, this));
    }

    private static final boolean a(j r4, p r5, com.obric.agent.trace.toolmetrics.a r6, long r7) {
        d.h.b.o.e(r6, "state");
        int r8 = b.f15916a[r4.ordinal()];
        if (r8 == 1) goto L16;
        if (r8 != 2) goto L14;
        if (r6.g() == null) goto L10;
        return false;
    L10:
        if (r6.f() != null) goto L12;
        r5.f15914d.a("illegal_transition", r6.a());
    L12:
        r6.d(Long.valueOf(r7));
        r5.a(r6, "core.result_ready");
    L21:
        r6.a(r7);
        return true;
    L14:
        throw new d.k();
    L16:
        if (r6.f() == null) goto L18;
    L23:
        r5.f15914d.a("illegal_transition", r6.a());
        return false;
    L18:
        if (r6.g() != null) goto L23;
        r6.c(Long.valueOf(r7));
        r5.a(r6, "core.dispatch_started");
        goto L21
    }

    public final void a(z r2, final String r3) {
        d.h.b.o.e(r2, "token");
        d.h.b.o.e(r3, "stage");
        a(r2, new $$Lambda$p$0kCGjGlcBSzM2XMZFEBdgTcqExY(this, r3));
    }

    private static final boolean a(p r1, String r2, com.obric.agent.trace.toolmetrics.a r3, long r4) {
        d.h.b.o.e(r3, "state");
        r1.a(r3, r2);
        r3.a(r4);
        return true;
    }

    public final void a(z r5, final n r6) {
        d.h.b.o.e(r5, "token");
        d.h.b.o.e(r6, "appendix");
        u r0 = r6.e();
        final Map<String, Object> r1 = null;
        if (r0 == null) goto L8;
        Map<String, Object> r2 = a(r0);
        if (r2 != null) goto L7;
        ((p) ZeusTransformUtils.preCheckCast(this, p.class, "com.obric.aiagent.plugin")).f15914d.a("fragment_rejected", r5.a());
        goto L8
    L7:
        r1 = r2;
    L8:
        a(r5, new $$Lambda$p$7PIqiZDpK8NHquzvpw6NTounaXM(r6, this, r1));
    }

    private static final boolean a(n r8, p r9, Map r10, com.obric.agent.trace.toolmetrics.a r11, long r12) {
        Map<? extends String, ? extends Object> r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r11, "state");
        d.h.b.z.a r0 = new d.h.b.z.a();
        l r1 = r8.a();
        boolean r3 = false;
        if (r1 != null) goto L5;
    L18:
        k r2 = r8.b();
        if (r2 != null) goto L21;
    L40:
        m r4 = r9.a(r8.c());
        if (r4 != null) goto L43;
    L56:
        m r14 = r9.a(r8.d());
        if (r14 != null) goto L59;
    L72:
        if (r13 == null) goto L80;
        r11.m().putAll(r13);
        if (r0.f38499a == false) goto L76;
    L77:
        r3 = true;
    L78:
        r0.f38499a = r3;
        goto L80
    L76:
        if ((!r13.isEmpty()) == false) goto L78;
    L80:
        if (r0.f38499a == false) goto L83;
        r11.a(r12);
    L83:
        return r0.f38499a;
    L59:
        if (r11.l() == null) goto L61;
        boolean r5 = true;
    L62:
        if (r5 == false) goto L64;
        r9.f15914d.a("duplicate_append_delivery_error", r11.a());
        boolean r15 = false;
    L65:
        if (r15 == false) goto L67;
    L70:
        boolean r16 = true;
    L71:
        r0.f38499a = r16;
        goto L72
    L67:
        if (r0.f38499a == true) goto L70;
        r16 = false;
        goto L71
    L64:
        r11.b(r14);
        r15 = true;
        goto L65
    L61:
        r5 = false;
        goto L62
    L43:
        if (r11.k() == null) goto L45;
        boolean r6 = true;
    L46:
        if (r6 == false) goto L48;
        r9.f15914d.a("duplicate_append_execute_error", r11.a());
        boolean r7 = false;
    L49:
        if (r7 == false) goto L51;
    L54:
        boolean r17 = true;
    L55:
        r0.f38499a = r17;
        goto L56
    L51:
        if (r0.f38499a == true) goto L54;
        r17 = false;
        goto L55
    L48:
        r11.a(r4);
        r7 = true;
        goto L49
    L45:
        r6 = false;
        goto L46
    L21:
        if (r11.e() == null) goto L23;
        boolean r18 = true;
    L24:
        if (r18 == false) goto L26;
        r9.f15914d.a("duplicate_append_correlation", r11.a());
        boolean r19 = false;
    L33:
        if (r19 == false) goto L35;
    L38:
        boolean r20 = true;
    L39:
        r0.f38499a = r20;
        goto L40
    L35:
        if (r0.f38499a == true) goto L38;
        r20 = false;
        goto L39
    L26:
        e r21 = e.f15877a;
        String r22 = r2.c();
        if (r22 != null) goto L29;
        r22 = "";
    L29:
        d r23 = r21.a(r22);
        if (r23 == null) goto L32;
        r11.a(Long.valueOf(r23.a()));
        r11.b(Long.valueOf(r23.b()));
        r11.a(r23.c());
        r11.a(r23.d());
    L32:
        r11.a(r2);
        r9.f15915e.a(r11, r2.c());
        r19 = true;
        goto L33
    L23:
        r18 = false;
        goto L24
    L5:
        if (r11.d() == null) goto L7;
        boolean r24 = true;
    L8:
        if (r24 == false) goto L10;
        r9.f15914d.a("duplicate_append_meta", r11.a());
        boolean r25 = false;
    L11:
        if (r25 == false) goto L13;
    L16:
        boolean r26 = true;
    L17:
        r0.f38499a = r26;
        goto L18
    L13:
        if (r0.f38499a == true) goto L16;
        r26 = false;
        goto L17
    L10:
        r11.a(r9.a(r1));
        r25 = true;
        goto L11
    L7:
        r24 = false;
        goto L8
    }

    public final void a(z r6) {
        d.h.b.o.e(r6, "token");
        com.obric.agent.trace.toolmetrics.a r7 = c(r6);
        if (r7 != null) goto L5;
        return;
    L5:
        long r0 = this.f15912b.a();
        monitor-enter(r7);
    L19:
        th = move-exception;
        throw th;
    L8:
        if (r7.j() == null) goto L13;
        this.f15914d.a("duplicate_terminal", r7.a());     // Catch: Throwable -> L19
        monitor-exit(r7);
        return;
    L13:
        if (r7.g() != null) goto L15;
        this.f15914d.a("illegal_transition", r7.a());     // Catch: Throwable -> L19
    L15:
        r7.e(Long.valueOf(r0));     // Catch: Throwable -> L19
        r7.a(r0);     // Catch: Throwable -> L19
        r7.a(y.f15944a);     // Catch: Throwable -> L19
        w r2 = com.obric.agent.trace.toolmetrics.a.a(r7, null, 1, null);     // Catch: Throwable -> L19
        monitor-exit(r7);
        a(r7, r2, r0);
    }

    public final void b(z r9) {
        d.h.b.o.e(r9, "token");
        a(this, r9, y.f15946c, 0, 4, null);
    }

    public final void b() {
        long r0 = this.f15912b.a();
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(this.f15915e.a(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L11;
        Object r5 = r4.next();
        if (((com.obric.agent.trace.toolmetrics.a) ZeusTransformUtils.preCheckCast(r5, com.obric.agent.trace.toolmetrics.a.class, "com.obric.aiagent.plugin")).c() > r0) goto L8;
        boolean r6 = true;
    L9:
        if (r6 == false) goto L4;
        r3.add(r5);
        goto L4
    L8:
        r6 = false;
        goto L9
    L11:
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L13:
        if (r7.hasNext() == false) goto L15;
        a(new z(((com.obric.agent.trace.toolmetrics.a) ZeusTransformUtils.preCheckCast(r7.next(), com.obric.agent.trace.toolmetrics.a.class, "com.obric.aiagent.plugin")).a()), y.f15945b, r0);
        goto L13
    }

    private final void a(z r4, d.h.a.m<? super com.obric.agent.trace.toolmetrics.a, ? super Long, Boolean> r5) {
        d.h.a.m r6 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.m.class, "com.obric.aiagent.plugin");
        com.obric.agent.trace.toolmetrics.a r7 = c(r4);
        if (r7 != null) goto L5;
        return;
    L5:
        long r0 = this.f15912b.a();
        monitor-enter(r7);
    L15:
        th = move-exception;
        throw th;
    L8:
        if (r7.j() == null) goto L12;
        this.f15914d.a("illegal_transition", r7.a());     // Catch: Throwable -> L15
        monitor-exit(r7);
        return;
    L12:
        ((Boolean) ZeusTransformUtils.preCheckCast(r6.invoke(r7, Long.valueOf(r0)), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();     // Catch: Throwable -> L15
        monitor-exit(r7);
    }

    static /* synthetic */ void a(p r0, z r1, y r2, long r3, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L5;
        r3 = r0.f15912b.a();
    L5:
        r0.a(r1, r2, r3);
    }

    private final void a(z r5, y r6, long r7) {
        com.obric.agent.trace.toolmetrics.a r8 = c(r5);
        if (r8 != null) goto L5;
        return;
    L5:
        monitor-enter(r8);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (r8.j() == null) goto L11;
        this.f15914d.a("duplicate_terminal", r8.a());     // Catch: Throwable -> L15
        monitor-exit(r8);
        return;
    L11:
        r8.a(r7);     // Catch: Throwable -> L15
        r8.a(r6);     // Catch: Throwable -> L15
        w r9 = r8.f(Long.valueOf(d.l.n.a(r7 - r8.n(), 0)));     // Catch: Throwable -> L15
        monitor-exit(r8);
        a(r8, r9, r7);
    }

    private final void a(com.obric.agent.trace.toolmetrics.a r3, w r4, long r5) {
        if (this.f15915e.a(r3.a(), r3) == true) goto L6;
        this.f15914d.a("duplicate_terminal", r3.a());
        return;
    L6:
        this.f15915e.a(r3.a(), r5);
        this.f15913c.a(r4);
    }

    private final void a(com.obric.agent.trace.toolmetrics.a r5) {
        monitor-enter(r5);
        long r0 = d.l.n.a(r5.h() - r5.n(), 0);     // Catch: Throwable -> L7
        r5.a(y.f15947d);     // Catch: Throwable -> L7
        w r1 = r5.f(Long.valueOf(r0));     // Catch: Throwable -> L7
        monitor-exit(r5);
        this.f15914d.a("pending_evicted", r5.a());
        this.f15915e.a(r5.a(), this.f15912b.a());
        this.f15913c.a(r1);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private final com.obric.agent.trace.toolmetrics.a c(z r4) {
        com.obric.agent.trace.toolmetrics.a r0 = this.f15915e.a(r4.a());
        if (r0 != null) goto L9;
        q r1 = this.f15914d;
        if (this.f15915e.c(r4.a()) == false) goto L7;
        String r3 = "duplicate_terminal";
    L8:
        r1.a(r3, r4.a());
        goto L9
    L7:
        r3 = "unknown_trace";
    L9:
        return r0;
    }

    private final Map<String, Object> a(u r9) {
        if (r9.c().size() <= 100) goto L5;
        return null;
    L5:
        String r8 = r9.b();
        Locale r1 = Locale.US;
        d.h.b.o.c(r1, "US");
        String r10 = r8.toLowerCase(r1);
        d.h.b.o.c(r10, "toLowerCase(...)");
        if (g.a((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L8;
        return null;
    L8:
        int r2 = b.f15917b[r9.a().ordinal()];
        boolean r4 = true;
        if (r2 != 1) goto L11;
        String r11 = "common_" + r10 + '_';
    L16:
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r9.c().keySet(), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Collection.class) == true) goto L19;
    L21:
        Iterator r5 = r3.iterator();
    L23:
        if (r5.hasNext() == false) goto L20;
        if ((!h.a((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L23;
        boolean r6 = true;
    L27:
        if (r6 == false) goto L29;
        return null;
    L29:
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r9.c().values(), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, Collection.class) == true) goto L32;
    L34:
        Iterator r12 = r7.iterator();
    L36:
        if (r12.hasNext() == false) goto L33;
        Object r13 = r12.next();
        if (r13 != null) goto L40;
    L46:
        boolean r14 = false;
    L47:
        if (r14 == false) goto L36;
        boolean r15 = true;
    L49:
        if (r15 == false) goto L51;
        return null;
    L51:
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r9.c().values(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r18 = r16.iterator();
    L53:
        if (r18.hasNext() == false) goto L57;
        Object r19 = r18.next();
        if (ZeusTransformUtils.instanceOf(r19, String.class) == false) goto L53;
        r17.add(r19);
        goto L53
    L57:
        Iterable r20 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r20, Collection.class) == true) goto L60;
    L62:
        Iterator r21 = r20.iterator();
    L64:
        if (r21.hasNext() == false) goto L61;
        if (((String) ZeusTransformUtils.preCheckCast(r21.next(), String.class, "com.obric.aiagent.plugin")).length() <= 1024) goto L68;
        boolean r22 = true;
    L69:
        if (r22 == false) goto L64;
    L70:
        if (r4 == false) goto L72;
        return null;
    L72:
        Map<String, Object> r23 = r9.c();
        Map<String, Object> r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(ao.a(r23.size())), Map.class, "com.obric.aiagent.plugin");
        Iterator r24 = ((Iterable) ZeusTransformUtils.preCheckCast(r23.entrySet(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L74:
        if (r24.hasNext() == false) goto L76;
        Object r25 = r24.next();
        r0.put(r11 + ((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r25, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), String.class, "com.obric.aiagent.plugin")), ((Map.Entry) ZeusTransformUtils.preCheckCast(r25, Map.Entry.class, "com.obric.aiagent.plugin")).getValue());
        goto L74
    L76:
        return r0;
    L68:
        r22 = false;
    L61:
        r4 = false;
        goto L70
    L60:
        if (((Collection) ZeusTransformUtils.preCheckCast(r20, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L62;
    L40:
        if (ZeusTransformUtils.instanceOf(r13, String.class) == true) goto L46;
        if (ZeusTransformUtils.instanceOf(r13, Number.class) == true) goto L46;
        if (ZeusTransformUtils.instanceOf(r13, Boolean.class) == true) goto L46;
        r14 = true;
    L33:
        r15 = false;
        goto L49
    L32:
        if (((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L34;
    L20:
        r6 = false;
        goto L27
    L19:
        if (((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L21;
    L11:
        if (r2 != 2) goto L14;
        r11 = "ext_" + r10 + '_';
        goto L16
    L14:
        throw new d.k();
    }

    private final l a(l r6) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r6.a(), CharSequence.class, "com.obric.aiagent.plugin")).toString(), CharSequence.class, "com.obric.aiagent.plugin");
        boolean r0 = d.o.o.d(r5);
        CharSequence r2 = SensitiveType.UNKNOWN;
        if (r0 == false) goto L5;
        r5 = SensitiveType.UNKNOWN;
    L5:
        String r7 = d.o.o.e((String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.aiagent.plugin"), 128);
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r6.b(), CharSequence.class, "com.obric.aiagent.plugin")).toString(), CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r3) == false) goto L8;
        r3 = SensitiveType.UNKNOWN;
    L8:
        String r4 = d.o.o.e((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), 128);
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r6.c(), CharSequence.class, "com.obric.aiagent.plugin")).toString(), CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r8) == true) goto L13;
        r2 = r8;
    L13:
        return new l(r7, r4, d.o.o.e((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin"), 128));
    }

    private final m a(m r2) {
        if (r2 == null) goto L8;
        if (r2.c() == false) goto L8;
        return r2;
    L8:
        return null;
    }

    private final void a(com.obric.agent.trace.toolmetrics.a r1, String r2) {
        r1.b(r2);
        r1.i().append(">").append(r2);
    }

    static {
        f15911a = new a(null);
        g = new d.o.k("[a-z][a-z0-9_]{0,63}");
        h = new d.o.k("[a-z][a-z0-9_]{0,127}");
    }
}
