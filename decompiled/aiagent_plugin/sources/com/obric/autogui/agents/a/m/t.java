package com.obric.autogui.agents.a.m;

import com.ss.bduploader.BDImageUploader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: ActionEffectTimingRecorder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f26715a = null;
    private static final AtomicLong q = null;
    private static final AtomicLong r = null;
    private static final d.h.a.a<Long> s = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.h.a.a<Long> f26716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f26717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f26718d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f26719e;
    private final LinkedHashMap<Long, w> f;
    private final List<com.obric.autogui.agents.a.m.b> g;
    private final Map<Long, List<m>> h;
    private final List<p> i;
    private final List<i> j;
    private final List<com.obric.autogui.agents.a.m.e> k;
    private Long l;
    private Long m;
    private g n;
    private v o;
    private boolean p;

    /* JADX INFO: compiled from: ActionEffectTimingRecorder.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class b<T> implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((i) ZeusTransformUtils.preCheckCast(r2, i.class, "com.obric.aiagent.plugin")).a()), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin")).a()), Comparable.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class c<T> implements Comparator {
        public c() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((com.obric.autogui.agents.a.m.e) ZeusTransformUtils.preCheckCast(r2, com.obric.autogui.agents.a.m.e.class, "com.obric.aiagent.plugin")).a()), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((com.obric.autogui.agents.a.m.e) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.agents.a.m.e.class, "com.obric.aiagent.plugin")).a()), Comparable.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class d<T> implements Comparator {
        public d() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((com.obric.autogui.agents.a.m.b) ZeusTransformUtils.preCheckCast(r2, com.obric.autogui.agents.a.m.b.class, "com.obric.aiagent.plugin")).a()), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((com.obric.autogui.agents.a.m.b) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.agents.a.m.b.class, "com.obric.aiagent.plugin")).a()), Comparable.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class e<T> implements Comparator {
        public e() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((p) ZeusTransformUtils.preCheckCast(r2, p.class, "com.obric.aiagent.plugin")).a()), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((p) ZeusTransformUtils.preCheckCast(r3, p.class, "com.obric.aiagent.plugin")).a()), Comparable.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class f<T> implements Comparator {
        public f() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((m) ZeusTransformUtils.preCheckCast(r2, m.class, "com.obric.aiagent.plugin")).a()), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((m) ZeusTransformUtils.preCheckCast(r3, m.class, "com.obric.aiagent.plugin")).a()), Comparable.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public t() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ x lambda$2qL6s6ktBSiWSffli1rzmgXFTBM(t r0, com.obric.autogui.agents.a.m.d r1, s r2, long r3) {
        return a(r0, r1, r2, r3);
    }

    public static /* synthetic */ x lambda$77T8_bMaKfewJ_9SpvTnYgJhFmw(t r0, n r1, l r2, long r3) {
        return a(r0, r1, r2, r3);
    }

    public static /* synthetic */ long lambda$882veddZAi9j0zFLA1rukXC9uJY() {
        return d();
    }

    /* JADX INFO: renamed from: lambda$A-mcrxofylzgkdm1Unj4XQQWE1k, reason: not valid java name */
    public static /* synthetic */ x m714lambda$Amcrxofylzgkdm1Unj4XQQWE1k(t r0, com.obric.autogui.agents.a.m.f r1, s r2, String r3, String r4, String r5, String r6, String r7, long r8) {
        return a(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    /* JADX INFO: renamed from: lambda$H7FukRKQU_4_Cp7p--7Ms2mHHkk, reason: not valid java name */
    public static /* synthetic */ x m715lambda$H7FukRKQU_4_Cp7p7Ms2mHHkk(t r0, j r1, long r2, long r4, long r6, long r8, s r10, long r11) {
        return a(r0, r1, r2, r4, r6, r8, r10, r11);
    }

    public static /* synthetic */ x lambda$ZYc3MIWyllg1wYviTVhioeVoM4Y(t r0, s r1, r r2, long r3) {
        return a(r0, r1, r2, r3);
    }

    public static /* synthetic */ x lambda$lFjJIkE_tqZaZGchpeJqh6DdGWA(t r0, q r1, long r2, s r4, boolean r5, long r6) {
        return a(r0, r1, r2, r4, r5, r6);
    }

    public t(d.h.a.a<Long> r5) {
        d.h.a.a<Long> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "clockMs");
        this.f26716b = r6;
        this.f26717c = q.incrementAndGet();
        this.f26718d = ((Number) ZeusTransformUtils.preCheckCast(r6.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue();
        this.f26719e = new Object();
        this.f = new LinkedHashMap();
        this.g = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        this.h = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        this.i = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        this.j = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        this.k = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    }

    public /* synthetic */ t(d.h.a.a r2, int r3, d.h.b.h r4) {
        d.h.a.a<Long> r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = s;
    L5:
        this(r5);
    }

    static {
        f26715a = new a(null);
        q = new AtomicLong(0);
        r = new AtomicLong(0);
        s = $$Lambda$t$882veddZAi9j0zFLA1rukXC9uJY.INSTANCE;
    }

    private static final long d() {
        return System.nanoTime() / 1000000;
    }

    public final com.obric.autogui.agents.a.m.d a(com.obric.autogui.agents.a.m.a r11) {
        d.h.b.o.e(r11, "phase");
        return (com.obric.autogui.agents.a.m.d) ZeusTransformUtils.preCheckCast(a((w) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.a.m.d(this.f26717c, c(), ((Number) ZeusTransformUtils.preCheckCast(this.f26716b.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue(), r11), w.class, "com.obric.aiagent.plugin")), com.obric.autogui.agents.a.m.d.class, "com.obric.aiagent.plugin");
    }

    public final boolean a(Long r6) {
        boolean r0 = false;
        if (r6 == null) goto L20;
        long r1 = d.l.n.a(r6.longValue(), 0);
        Object r7 = this.f26719e;
        monitor-enter(r7);
    L17:
        th = move-exception;
        throw th;
    L7:
        if (this.o == null) goto L9;
    L15:
        monitor-exit(r7);
        return r0;
    L9:
        if (this.p == true) goto L15;
        if (this.l != null) goto L15;
        this.l = Long.valueOf(r1);     // Catch: Throwable -> L17
        r0 = true;
        goto L15
    L20:
        return false;
    }

    public final boolean a(long r3) {
        long r4 = d.l.n.a(r3, 0);
        Object r0 = this.f26719e;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.o == null) goto L7;
    L13:
        boolean r2 = false;
    L14:
        monitor-exit(r0);
        return r2;
    L7:
        if (this.p == true) goto L13;
        if (this.m != null) goto L13;
        this.m = Long.valueOf(r4);     // Catch: Throwable -> L16
        r2 = true;
        goto L14
    }

    public final boolean a(final com.obric.autogui.agents.a.m.d r3, final s r4) {
        d.h.b.o.e(r3, "token");
        d.h.b.o.e(r4, "finishReason");
        return a((w) ZeusTransformUtils.preCheckCast(r3, w.class, "com.obric.aiagent.plugin"), new $$Lambda$t$2qL6s6ktBSiWSffli1rzmgXFTBM(this, r3, r4));
    }

    private static final x a(t r8, com.obric.autogui.agents.a.m.d r9, s r10, long r11) {
        ((Collection) ZeusTransformUtils.preCheckCast(r8.g, Collection.class, "com.obric.aiagent.plugin")).add(new com.obric.autogui.agents.a.m.b(r9.e(), r9.a(), r11, r10));
        return x.f38692a;
    }

    public final q a(o r13, String r14, Integer r15) {
        d.h.b.o.e(r13, "purpose");
        d.h.b.o.e(r14, "stage");
        return (q) ZeusTransformUtils.preCheckCast(a((w) ZeusTransformUtils.preCheckCast(new q(this.f26717c, c(), ((Number) ZeusTransformUtils.preCheckCast(this.f26716b.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue(), r13, r14, r15), w.class, "com.obric.aiagent.plugin")), q.class, "com.obric.aiagent.plugin");
    }

    public final n a(q r12, k r13) {
        d.h.b.o.e(r12, "snapshot");
        d.h.b.o.e(r13, "capability");
        n r0 = new n(this.f26717c, c(), ((Number) ZeusTransformUtils.preCheckCast(this.f26716b.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue(), r12.e(), r13);
        Object r14 = this.f26719e;
        monitor-enter(r14);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (b((w) ZeusTransformUtils.preCheckCast(r12, w.class, "com.obric.aiagent.plugin")) == false) goto L7;
        ((Map) ZeusTransformUtils.preCheckCast(this.f, Map.class, "com.obric.aiagent.plugin")).put(Long.valueOf(r0.e()), r0);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r14);
        return r0;
    L7:
        r0.g();     // Catch: Throwable -> L10
        goto L8
    }

    public final boolean a(final n r3, final l r4) {
        d.h.b.o.e(r3, "token");
        d.h.b.o.e(r4, "state");
        if (r4 != l.f26681a) goto L5;
    L9:
        boolean r0 = false;
    L10:
        if (r0 == false) goto L14;
        return a((w) ZeusTransformUtils.preCheckCast(r3, w.class, "com.obric.aiagent.plugin"), new $$Lambda$t$77T8_bMaKfewJ_9SpvTnYgJhFmw(this, r3, r4));
    L14:
        throw new IllegalArgumentException(("Executed snapshot capability cannot finish as " + r4).toString());
    L5:
        if (r4 == l.f26682b) goto L9;
        if (r4 == l.f26683c) goto L9;
        r0 = true;
        goto L10
    }

    private static final x a(t r7, n r8, l r9, long r10) {
        Map<Long, List<m>> r11 = r7.h;
        Long r0 = Long.valueOf(r8.a());
        List<m> r1 = r11.get(r0);
        if (r1 != null) goto L5;
        r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        r11.put(r0, r1);
    L5:
        ((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.aiagent.plugin")).add(new m(r8.e(), r8.b(), r9, Long.valueOf(r10)));
        return x.f38692a;
    }

    public final boolean a(q r10, k r11, l r12) {
        d.h.b.o.e(r10, "snapshot");
        d.h.b.o.e(r11, "capability");
        d.h.b.o.e(r12, "state");
        boolean r1 = false;
        if (r12 != l.f26681a) goto L5;
    L10:
        boolean r0 = true;
    L11:
        if (r0 == false) goto L28;
        Object r2 = this.f26719e;
        monitor-enter(r2);
    L24:
        th = move-exception;
        throw th;
    L15:
        if (b((w) ZeusTransformUtils.preCheckCast(r10, w.class, "com.obric.aiagent.plugin")) == false) goto L22;
        Map<Long, List<m>> r3 = this.h;     // Catch: Throwable -> L24
        Long r13 = Long.valueOf(r10.e());     // Catch: Throwable -> L24
        List<m> r4 = r3.get(r13);     // Catch: Throwable -> L24
        if (r4 != null) goto L20;
        r4 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
        r3.put(r13, r4);     // Catch: Throwable -> L24
    L20:
        ((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")).add(new m(c(), r11, r12, null));     // Catch: Throwable -> L24
        r1 = true;
    L22:
        monitor-exit(r2);
        return r1;
    L28:
        throw new IllegalArgumentException("Non-executed snapshot capability must use an explicit non-executed state".toString());
    L5:
        if (r12 == l.f26682b) goto L10;
        if (r12 == l.f26683c) goto L10;
        r0 = false;
        goto L11
    }

    public static /* synthetic */ boolean a(t r6, q r7, long r8, s r10, boolean r11, int r12, Object r13) {
        if ((r12 & 4) == 0) goto L5;
        r10 = s.f26710a;
    L5:
        s r4 = r10;
        if ((r12 & 8) == 0) goto L9;
        r11 = false;
    L9:
        return r6.a(r7, r8, r4, r11);
    }

    public final boolean a(final q r11, final long r12, final s r14, final boolean r15) {
        d.h.b.o.e(r11, "token");
        d.h.b.o.e(r14, "finishReason");
        Object r0 = this.f26719e;
        monitor-enter(r0);
        a(r11.e(), u.a(r14));     // Catch: Throwable -> L7
        boolean r10 = a((w) ZeusTransformUtils.preCheckCast(r11, w.class, "com.obric.aiagent.plugin"), new $$Lambda$t$lFjJIkE_tqZaZGchpeJqh6DdGWA(this, r11, r12, r14, r15));     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    private static final x a(t r17, q r18, long r19, s r21, boolean r22, long r23) {
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(r17.i, Collection.class, "com.obric.aiagent.plugin");
        long r5 = r18.e();
        o r7 = r18.a();
        String r8 = r18.b();
        Integer r9 = r18.c();
        long r12 = d.l.n.a(r19, 0);
        List r0 = (List) ZeusTransformUtils.preCheckCast(r17.h.remove(Long.valueOf(r18.e())), List.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        r0 = d.a.p.b();
    L5:
        r1.add(new p(r5, r7, r8, r9, r23, r12, r21, r22, d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new f(), Comparator.class, "com.obric.aiagent.plugin"))));
        return x.f38692a;
    }

    public final h a() {
        return (h) ZeusTransformUtils.preCheckCast(a((w) ZeusTransformUtils.preCheckCast(new h(this.f26717c, c(), ((Number) ZeusTransformUtils.preCheckCast(this.f26716b.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue()), w.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin");
    }

    public final j a(int r11) {
        boolean r0 = true;
        if (r11 >= 1) goto L6;
        r0 = false;
    L6:
        if (r0 == false) goto L10;
        return (j) ZeusTransformUtils.preCheckCast(a((w) ZeusTransformUtils.preCheckCast(new j(this.f26717c, c(), ((Number) ZeusTransformUtils.preCheckCast(this.f26716b.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue(), r11), w.class, "com.obric.aiagent.plugin")), j.class, "com.obric.aiagent.plugin");
    L10:
        throw new IllegalArgumentException("Round index must start at 1".toString());
    }

    public final boolean a(final j r17, final long r18, final long r20, final long r22, final long r24, final s r26) {
        d.h.b.o.e(r17, "token");
        d.h.b.o.e(r26, "finishReason");
        Object r13 = this.f26719e;
        monitor-enter(r13);
        a(r17.a(), u.a(r26));     // Catch: Throwable -> L7
        boolean r0 = a((w) ZeusTransformUtils.preCheckCast(r17, w.class, "com.obric.aiagent.plugin"), new $$Lambda$t$H7FukRKQU_4_Cp7p7Ms2mHHkk(this, r17, r18, r20, r22, r24, r26));     // Catch: Throwable -> L7
        monitor-exit(r13);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    private static final x a(t r16, j r17, long r18, long r20, long r22, long r24, s r26, long r27) {
        ((Collection) ZeusTransformUtils.preCheckCast(r16.j, Collection.class, "com.obric.aiagent.plugin")).add(new i(r17.e(), r17.a(), r27, d.l.n.a(r18, 0), d.l.n.a(r20, 0), d.l.n.a(r22, 0), d.l.n.a(r24, 0), r26));
        return x.f38692a;
    }

    public final com.obric.autogui.agents.a.m.f a(int r13, String r14) {
        d.h.b.o.e(r14, "detectorName");
        if (r13 < 1) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L14;
        if ((true ^ d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L12;
        return (com.obric.autogui.agents.a.m.f) ZeusTransformUtils.preCheckCast(a((w) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.a.m.f(this.f26717c, c(), ((Number) ZeusTransformUtils.preCheckCast(this.f26716b.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue(), r13, r14), w.class, "com.obric.aiagent.plugin")), com.obric.autogui.agents.a.m.f.class, "com.obric.aiagent.plugin");
    L12:
        throw new IllegalArgumentException("Detector name must not be blank".toString());
    L14:
        throw new IllegalArgumentException("Detector round index must start at 1".toString());
    L5:
        r1 = false;
        goto L6
    }

    public static /* synthetic */ boolean a(t r7, com.obric.autogui.agents.a.m.f r8, s r9, String r10, String r11, String r12, String r13, String r14, int r15, Object r16) {
        if ((r15 & 2) == 0) goto L5;
        s r0 = s.f26710a;
    L6:
        String r2 = null;
        if ((r15 & 4) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r15 & 8) == 0) goto L13;
        String r3 = null;
    L15:
        if ((r15 & 16) == 0) goto L17;
        String r4 = null;
    L19:
        if ((r15 & 32) == 0) goto L21;
        String r5 = null;
    L23:
        if ((r15 & 64) != 0) goto L27;
        r2 = r14;
    L27:
        return r7.a(r8, r0, r1, r3, r4, r5, r2);
    L21:
        r5 = r13;
        goto L23
    L17:
        r4 = r12;
        goto L19
    L13:
        r3 = r11;
        goto L15
    L9:
        r1 = r10;
        goto L11
    L5:
        r0 = r9;
        goto L6
    }

    public final boolean a(final com.obric.autogui.agents.a.m.f r12, final s r13, final String r14, final String r15, final String r16, final String r17, final String r18) {
        d.h.b.o.e(r12, "token");
        d.h.b.o.e(r13, "finishReason");
        return a((w) ZeusTransformUtils.preCheckCast(r12, w.class, "com.obric.aiagent.plugin"), new $$Lambda$t$Amcrxofylzgkdm1Unj4XQQWE1k(this, r12, r13, r14, r15, r16, r17, r18));
    }

    private static final x a(t r15, com.obric.autogui.agents.a.m.f r16, s r17, String r18, String r19, String r20, String r21, String r22, long r23) {
        ((Collection) ZeusTransformUtils.preCheckCast(r15.k, Collection.class, "com.obric.aiagent.plugin")).add(new com.obric.autogui.agents.a.m.e(r16.e(), r16.a(), r16.b(), r23, r17, r18, r19, r20, r21, r22));
        return x.f38692a;
    }

    public static /* synthetic */ boolean a(t r0, h r1, s r2, r r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = s.f26710a;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = null;
    L9:
        return r0.a(r1, r2, r3);
    }

    public final boolean a(h r4, final s r5, final r r6) {
        d.h.b.o.e(r4, "token");
        d.h.b.o.e(r5, "finishReason");
        Object r0 = this.f26719e;
        monitor-enter(r0);
        a(u.a(r5));     // Catch: Throwable -> L7
        boolean r3 = a((w) ZeusTransformUtils.preCheckCast(r4, w.class, "com.obric.aiagent.plugin"), new $$Lambda$t$ZYc3MIWyllg1wYviTVhioeVoM4Y(this, r5, r6));     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    private static final x a(t r0, s r1, r r2, long r3) {
        r0.n = r0.a(r3, r1, r2);
        return x.f38692a;
    }

    public static /* synthetic */ v a(t r0, s r1, r r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.a(r1, r2);
    }

    public final v a(s r16, r r17) {
        d.h.b.o.e(r16, "finishReason");
        Object r13 = this.f26719e;
        monitor-enter(r13);
        v r1 = this.o;     // Catch: Throwable -> L21
        if (r1 != null) goto L19;
        t r14 = (t) ZeusTransformUtils.preCheckCast(this, t.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        r14.p = true;     // Catch: Throwable -> L21
        r14.b(u.a(r16), r17);     // Catch: Throwable -> L21
        if (r17 == null) goto L18;
        g r0 = r14.n;     // Catch: Throwable -> L21
        g r2 = null;
        if (r0 == null) goto L11;
        s r3 = r0.c();     // Catch: Throwable -> L21
    L13:
        if (r3 != s.f26712c) goto L18;
        g r4 = r14.n;     // Catch: Throwable -> L21
        if (r4 == null) goto L17;
        r2 = g.a(r4, 0, 0, null, r17, null, null, 55, null);     // Catch: Throwable -> L21
    L17:
        r14.n = r2;     // Catch: Throwable -> L21
        goto L18
    L11:
        r3 = null;
    L18:
        r1 = r14.a(true, r16, r17, r14.b(r14.f26718d));     // Catch: Throwable -> L21
        r14.o = r1;     // Catch: Throwable -> L21
    L19:
        monitor-exit(r13);
        return r1;
    L21:
        th = move-exception;
        throw th;
    }

    public final v b() {
        Object r0 = this.f26719e;
        monitor-enter(r0);
        v r1 = this.o;     // Catch: Throwable -> L9
        if (r1 != null) goto L7;
        r1 = a(false, null, null, b(this.f26718d));     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);
        return r1;
    L9:
        th = move-exception;
        throw th;
    }

    private final g a(long r16, s r18, r r19) {
        List r13 = d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(this.j, Iterable.class, "com.obric.aiagent.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new b(), Comparator.class, "com.obric.aiagent.plugin"));
        List r14 = d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(this.k, Iterable.class, "com.obric.aiagent.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new c(), Comparator.class, "com.obric.aiagent.plugin"));
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        long r6 = 0;
    L4:
        if (r0.hasNext() == false) goto L7;
        r6 = r6 + d.l.n.a(((i) ZeusTransformUtils.preCheckCast(r0.next(), i.class, "com.obric.aiagent.plugin")).c(), 0);
        goto L4
    L7:
        return new g(d.l.n.a(r16, 0), d.l.n.a(r16 - r6, 0), r18, r19, r13, r14);
    }

    private final v a(boolean r14, s r15, r r16, long r17) {
        return new v(3, r14, d.l.n.a(r17, 0), r15, r16, this.l, this.m, new com.obric.autogui.agents.a.m.c(d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(this.g, Iterable.class, "com.obric.aiagent.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new d(), Comparator.class, "com.obric.aiagent.plugin"))), d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(this.i, Iterable.class, "com.obric.aiagent.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new e(), Comparator.class, "com.obric.aiagent.plugin")), this.n);
    }

    private final <T extends w> T a(T r4) {
        Object r0 = this.f26719e;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.o == null) goto L7;
    L9:
        r4.g();     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);
        return r4;
    L7:
        if (this.p == true) goto L9;
        ((Map) ZeusTransformUtils.preCheckCast(this.f, Map.class, "com.obric.aiagent.plugin")).put(Long.valueOf(r4.e()), r4);     // Catch: Throwable -> L12
        goto L10
    }

    private final boolean a(w r6, d.h.a.b<? super Long, x> r7) {
        d.h.a.b r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.b.class, "com.obric.aiagent.plugin");
        Object r0 = this.f26719e;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (r6.d() == this.f26717c) goto L7;
    L15:
        boolean r5 = false;
    L16:
        monitor-exit(r0);
        return r5;
    L7:
        if (this.f.get(Long.valueOf(r6.e())) != r6) goto L15;
        if (this.o != null) goto L15;
        if (r6.g() == false) goto L15;
        this.f.remove(Long.valueOf(r6.e()));     // Catch: Throwable -> L18
        r8.invoke(Long.valueOf(b(r6.f())));     // Catch: Throwable -> L18
        r5 = true;
        goto L16
    }

    private final boolean b(w r5) {
        if (r5.d() == this.f26717c) goto L5;
    L13:
        return false;
    L5:
        if (r5.h() == true) goto L13;
        if (this.f.get(Long.valueOf(r5.e())) != r5) goto L13;
        if (this.o != null) goto L13;
        if (this.p == true) goto L13;
        return true;
    }

    private final long b(long r3) {
        return d.l.n.a(((Number) ZeusTransformUtils.preCheckCast(this.f26716b.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue() - r3, 0);
    }

    private final long c() {
        return r.incrementAndGet();
    }

    private final void b(s r14, r r15) {
        Object r0 = this.f26719e;
        monitor-enter(r0);
        Collection<w> r1 = this.f.values();     // Catch: Throwable -> L102
        d.h.b.o.c(r1, "<get-values>(...)");     // Catch: Throwable -> L102
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L102
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L102
        Iterator r4 = r2.iterator();     // Catch: Throwable -> L102
    L6:
        if (r4.hasNext() == false) goto L10;
        Object r5 = r4.next();     // Catch: Throwable -> L102
        if (ZeusTransformUtils.instanceOf(r5, n.class) == false) goto L6;
        r3.add(r5);     // Catch: Throwable -> L102
        goto L6
    L10:
        List r6 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L102
        monitor-exit(r0);
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L14:
        if (r7.hasNext() == false) goto L16;
        a((n) ZeusTransformUtils.preCheckCast(r7.next(), n.class, "com.obric.aiagent.plugin"), u.b(r14));
        goto L14
    L16:
        Object r8 = this.f26719e;
        monitor-enter(r8);
        Collection<w> r9 = this.f.values();     // Catch: Throwable -> L99
        d.h.b.o.c(r9, "<get-values>(...)");     // Catch: Throwable -> L99
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L99
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L99
        Iterator r12 = r10.iterator();     // Catch: Throwable -> L99
    L20:
        if (r12.hasNext() == false) goto L24;
        Object r13 = r12.next();     // Catch: Throwable -> L99
        if (ZeusTransformUtils.instanceOf(r13, com.obric.autogui.agents.a.m.f.class) == false) goto L20;
        r11.add(r13);     // Catch: Throwable -> L99
        goto L20
    L24:
        List r16 = (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L99
        monitor-exit(r8);
        Iterator r17 = ((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L28:
        if (r17.hasNext() == false) goto L30;
        a(this, (com.obric.autogui.agents.a.m.f) ZeusTransformUtils.preCheckCast(r17.next(), com.obric.autogui.agents.a.m.f.class, "com.obric.aiagent.plugin"), r14, null, null, null, null, null, BDImageUploader.MessageIsPreHeatResultUsed, null);
        goto L28
    L30:
        Object r18 = this.f26719e;
        monitor-enter(r18);
        Collection<w> r19 = this.f.values();     // Catch: Throwable -> L96
        d.h.b.o.c(r19, "<get-values>(...)");     // Catch: Throwable -> L96
        Iterable r20 = (Iterable) ZeusTransformUtils.preCheckCast(r19, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L96
        Collection r21 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L96
        Iterator r22 = r20.iterator();     // Catch: Throwable -> L96
    L34:
        if (r22.hasNext() == false) goto L38;
        Object r23 = r22.next();     // Catch: Throwable -> L96
        if (ZeusTransformUtils.instanceOf(r23, q.class) == false) goto L34;
        r21.add(r23);     // Catch: Throwable -> L96
        goto L34
    L38:
        List r24 = (List) ZeusTransformUtils.preCheckCast(r21, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L96
        monitor-exit(r18);
        Iterator r25 = ((Iterable) ZeusTransformUtils.preCheckCast(r24, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L42:
        if (r25.hasNext() == false) goto L44;
        a(this, (q) ZeusTransformUtils.preCheckCast(r25.next(), q.class, "com.obric.aiagent.plugin"), 0, r14, false, 8, null);
        goto L42
    L44:
        Object r26 = this.f26719e;
        monitor-enter(r26);
        Collection<w> r27 = this.f.values();     // Catch: Throwable -> L93
        d.h.b.o.c(r27, "<get-values>(...)");     // Catch: Throwable -> L93
        Iterable r28 = (Iterable) ZeusTransformUtils.preCheckCast(r27, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L93
        Collection r29 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L93
        Iterator r30 = r28.iterator();     // Catch: Throwable -> L93
    L48:
        if (r30.hasNext() == false) goto L52;
        Object r31 = r30.next();     // Catch: Throwable -> L93
        if (ZeusTransformUtils.instanceOf(r31, j.class) == false) goto L48;
        r29.add(r31);     // Catch: Throwable -> L93
        goto L48
    L52:
        List r32 = (List) ZeusTransformUtils.preCheckCast(r29, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L93
        monitor-exit(r26);
        Iterator r33 = ((Iterable) ZeusTransformUtils.preCheckCast(r32, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L56:
        if (r33.hasNext() == false) goto L58;
        a((j) ZeusTransformUtils.preCheckCast(r33.next(), j.class, "com.obric.aiagent.plugin"), 0, 0, 0, 0, r14);
        goto L56
    L58:
        Object r34 = this.f26719e;
        monitor-enter(r34);
        Collection<w> r35 = this.f.values();     // Catch: Throwable -> L90
        d.h.b.o.c(r35, "<get-values>(...)");     // Catch: Throwable -> L90
        Iterable r36 = (Iterable) ZeusTransformUtils.preCheckCast(r35, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L90
        Collection r37 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L90
        Iterator r38 = r36.iterator();     // Catch: Throwable -> L90
    L62:
        if (r38.hasNext() == false) goto L66;
        Object r39 = r38.next();     // Catch: Throwable -> L90
        if (ZeusTransformUtils.instanceOf(r39, h.class) == false) goto L62;
        r37.add(r39);     // Catch: Throwable -> L90
        goto L62
    L66:
        List r40 = (List) ZeusTransformUtils.preCheckCast(r37, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L90
        monitor-exit(r34);
        Iterator r41 = ((Iterable) ZeusTransformUtils.preCheckCast(r40, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L70:
        if (r41.hasNext() == false) goto L72;
        a((h) ZeusTransformUtils.preCheckCast(r41.next(), h.class, "com.obric.aiagent.plugin"), r14, r15);
        goto L70
    L72:
        Object r110 = this.f26719e;
        monitor-enter(r110);
        Collection<w> r42 = this.f.values();     // Catch: Throwable -> L87
        d.h.b.o.c(r42, "<get-values>(...)");     // Catch: Throwable -> L87
        Iterable r43 = (Iterable) ZeusTransformUtils.preCheckCast(r42, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L87
        Collection r44 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L87
        Iterator r45 = r43.iterator();     // Catch: Throwable -> L87
    L76:
        if (r45.hasNext() == false) goto L80;
        Object r46 = r45.next();     // Catch: Throwable -> L87
        if (ZeusTransformUtils.instanceOf(r46, com.obric.autogui.agents.a.m.d.class) == false) goto L76;
        r44.add(r46);     // Catch: Throwable -> L87
        goto L76
    L80:
        List r47 = (List) ZeusTransformUtils.preCheckCast(r44, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L87
        monitor-exit(r110);
        Iterator r111 = ((Iterable) ZeusTransformUtils.preCheckCast(r47, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L84:
        if (r111.hasNext() == false) goto L86;
        a((com.obric.autogui.agents.a.m.d) ZeusTransformUtils.preCheckCast(r111.next(), com.obric.autogui.agents.a.m.d.class, "com.obric.aiagent.plugin"), r14);
        goto L84
    L86:
        return;
    L87:
        th = move-exception;
        throw th;
    L90:
        th = move-exception;
        throw th;
    L93:
        th = move-exception;
        throw th;
    L96:
        th = move-exception;
        throw th;
    L99:
        th = move-exception;
        throw th;
    L102:
        th = move-exception;
        throw th;
    }

    private final void a(long r6, s r8) {
        Object r0 = this.f26719e;
        monitor-enter(r0);
        Collection<w> r1 = this.f.values();     // Catch: Throwable -> L26
        d.h.b.o.c(r1, "<get-values>(...)");     // Catch: Throwable -> L26
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        Iterator r4 = r2.iterator();     // Catch: Throwable -> L26
    L6:
        if (r4.hasNext() == false) goto L10;
        Object r5 = r4.next();     // Catch: Throwable -> L26
        if (ZeusTransformUtils.instanceOf(r5, n.class) == false) goto L6;
        r3.add(r5);     // Catch: Throwable -> L26
        goto L6
    L10:
        List r7 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        monitor-exit(r0);
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r11 = r9.iterator();
    L14:
        if (r11.hasNext() == false) goto L21;
        Object r12 = r11.next();
        if (((n) ZeusTransformUtils.preCheckCast(r12, n.class, "com.obric.aiagent.plugin")).a() != r6) goto L18;
        boolean r13 = true;
    L19:
        if (r13 == false) goto L14;
        r10.add(r12);
        goto L14
    L18:
        r13 = false;
        goto L19
    L21:
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L23:
        if (r14.hasNext() == false) goto L25;
        a((n) ZeusTransformUtils.preCheckCast(r14.next(), n.class, "com.obric.aiagent.plugin"), u.b(r8));
        goto L23
    L25:
        return;
    L26:
        th = move-exception;
        throw th;
    }

    private final void a(int r12, s r13) {
        Object r0 = this.f26719e;
        monitor-enter(r0);
        Collection<w> r1 = this.f.values();     // Catch: Throwable -> L26
        d.h.b.o.c(r1, "<get-values>(...)");     // Catch: Throwable -> L26
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        Iterator r4 = r2.iterator();     // Catch: Throwable -> L26
    L6:
        if (r4.hasNext() == false) goto L10;
        Object r5 = r4.next();     // Catch: Throwable -> L26
        if (ZeusTransformUtils.instanceOf(r5, com.obric.autogui.agents.a.m.f.class) == false) goto L6;
        r3.add(r5);     // Catch: Throwable -> L26
        goto L6
    L10:
        List r6 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        monitor-exit(r0);
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r9 = r7.iterator();
    L14:
        if (r9.hasNext() == false) goto L21;
        Object r10 = r9.next();
        if (((com.obric.autogui.agents.a.m.f) ZeusTransformUtils.preCheckCast(r10, com.obric.autogui.agents.a.m.f.class, "com.obric.aiagent.plugin")).a() != r12) goto L18;
        boolean r11 = true;
    L19:
        if (r11 == false) goto L14;
        r8.add(r10);
        goto L14
    L18:
        r11 = false;
        goto L19
    L21:
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L23:
        if (r14.hasNext() == false) goto L25;
        a(this, (com.obric.autogui.agents.a.m.f) ZeusTransformUtils.preCheckCast(r14.next(), com.obric.autogui.agents.a.m.f.class, "com.obric.aiagent.plugin"), r13, null, null, null, null, null, BDImageUploader.MessageIsPreHeatResultUsed, null);
        goto L23
    L25:
        return;
    L26:
        th = move-exception;
        throw th;
    }

    private final void a(s r14) {
        Object r0 = this.f26719e;
        monitor-enter(r0);
        Collection<w> r1 = this.f.values();     // Catch: Throwable -> L34
        d.h.b.o.c(r1, "<get-values>(...)");     // Catch: Throwable -> L34
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
        Iterator r4 = r2.iterator();     // Catch: Throwable -> L34
    L6:
        if (r4.hasNext() == false) goto L10;
        Object r5 = r4.next();     // Catch: Throwable -> L34
        if (ZeusTransformUtils.instanceOf(r5, com.obric.autogui.agents.a.m.f.class) == false) goto L6;
        r3.add(r5);     // Catch: Throwable -> L34
        goto L6
    L10:
        List r6 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
        monitor-exit(r0);
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L14:
        if (r7.hasNext() == false) goto L16;
        a(this, (com.obric.autogui.agents.a.m.f) ZeusTransformUtils.preCheckCast(r7.next(), com.obric.autogui.agents.a.m.f.class, "com.obric.aiagent.plugin"), r14, null, null, null, null, null, BDImageUploader.MessageIsPreHeatResultUsed, null);
        goto L14
    L16:
        Object r8 = this.f26719e;
        monitor-enter(r8);
        Collection<w> r9 = this.f.values();     // Catch: Throwable -> L31
        d.h.b.o.c(r9, "<get-values>(...)");     // Catch: Throwable -> L31
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L31
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L31
        Iterator r12 = r10.iterator();     // Catch: Throwable -> L31
    L20:
        if (r12.hasNext() == false) goto L24;
        Object r13 = r12.next();     // Catch: Throwable -> L31
        if (ZeusTransformUtils.instanceOf(r13, j.class) == false) goto L20;
        r11.add(r13);     // Catch: Throwable -> L31
        goto L20
    L24:
        List r15 = (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L31
        monitor-exit(r8);
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L28:
        if (r16.hasNext() == false) goto L30;
        a((j) ZeusTransformUtils.preCheckCast(r16.next(), j.class, "com.obric.aiagent.plugin"), 0, 0, 0, 0, r14);
        goto L28
    L30:
        return;
    L31:
        th = move-exception;
        throw th;
    L34:
        th = move-exception;
        throw th;
    }
}
