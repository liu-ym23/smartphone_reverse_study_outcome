package com.obric.aiagent.ipc.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.l.n;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: IPCAnomalyDetector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18646a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f18647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f18648c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f18649d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f18650e;
    private final long f;
    private final ConcurrentHashMap<String, ConcurrentHashMap<String, ConcurrentHashMap<String, b>>> g;
    private final Object h;
    private long i;
    private int j;
    private volatile long k;

    /* JADX INFO: compiled from: IPCAnomalyDetector.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: IPCAnomalyDetector.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f18651a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f18652b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f18653c;

        public b() {
            this(0, 0, false, 7, null);
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
            return false;
        L8:
            b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.aiagent.plugin");
            if (this.f18651a == r10.f18651a) goto L12;
            return false;
        L12:
            if (this.f18652b == r10.f18652b) goto L15;
            return false;
        L15:
            if (this.f18653c == r10.f18653c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Long.hashCode(this.f18651a) * 31) + Integer.hashCode(this.f18652b)) * 31) + Boolean.hashCode(this.f18653c);
        }

        public String toString() {
            return "MethodState(windowIndex=" + this.f18651a + ", windowCount=" + this.f18652b + ", frequentReported=" + this.f18653c + ')';
        }

        public b(long r1, int r3, boolean r4) {
            this.f18651a = r1;
            this.f18652b = r3;
            this.f18653c = r4;
        }

        public /* synthetic */ b(long r2, int r4, boolean r5, int r6, d.h.b.h r7) {
            if ((r6 & 1) == 0) goto L6;
            r2 = Long.MIN_VALUE;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r4 = 0;
        L9:
            if ((r6 & 4) == 0) goto L11;
            r5 = false;
        L11:
            this(r2, r4, r5);
        }

        public final long a() {
            return this.f18651a;
        }

        public final void a(long r1) {
            this.f18651a = r1;
        }

        public final void a(int r1) {
            this.f18652b = r1;
        }

        public final int b() {
            return this.f18652b;
        }

        public final void a(boolean r1) {
            this.f18653c = r1;
        }

        public final boolean c() {
            return this.f18653c;
        }
    }

    static {
        f18646a = new a(null);
    }

    public c(long r4, long r6, int r8, int r9, long r10) {
        this.f18647b = r4;
        this.f18648c = r6;
        this.f18649d = r8;
        this.f18650e = r9;
        this.f = r10;
        this.g = new ConcurrentHashMap();
        this.h = new Object();
        this.i = Long.MIN_VALUE;
        this.k = Long.MIN_VALUE;
        boolean r5 = true;
        if (r4 <= 0) goto L5;
        boolean r3 = true;
    L7:
        if (r3 == false) goto L36;
        if (r6 < 0) goto L11;
        boolean r7 = true;
    L12:
        if (r7 == false) goto L34;
        if (r8 <= 0) goto L15;
        boolean r11 = true;
    L16:
        if (r11 == false) goto L32;
        if (r9 <= 0) goto L19;
        boolean r12 = true;
    L20:
        if (r12 == false) goto L30;
        if (r10 > 0) goto L25;
        r5 = false;
    L25:
        if (r5 == false) goto L28;
        return;
    L28:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L30:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L19:
        r12 = false;
        goto L20
    L32:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L15:
        r11 = false;
        goto L16
    L34:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L11:
        r7 = false;
        goto L12
    L36:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r3 = false;
        goto L7
    }

    public /* synthetic */ c(long r13, long r15, int r17, int r18, long r19, int r21, d.h.b.h r22) {
        if ((r21 & 1) == 0) goto L5;
        long r4 = 60000;
    L7:
        if ((r21 & 16) == 0) goto L9;
        long r10 = 60000;
    L10:
        this(r4, r15, r17, r18, r10);
        return;
    L9:
        r10 = r19;
        goto L10
    L5:
        r4 = r13;
        goto L7
    }

    public final com.obric.aiagent.ipc.utils.b a(String r5, String r6, String r7, long r8, boolean r10, long r11) {
        o.e(r5, "direction");
        o.e(r6, "tag");
        o.e(r7, "method");
        long r0 = r11 / this.f18647b;
        b r9 = a(r5, r6, r7);
        monitor-enter(r9);
    L40:
        th = move-exception;
        throw th;
    L5:
        if (r0 <= r9.a()) goto L8;
        r9.a(r0);     // Catch: Throwable -> L40
        r9.a(0);     // Catch: Throwable -> L40
        r9.a(false);     // Catch: Throwable -> L40
    L8:
        if (r9.b() >= this.f18649d) goto L10;
        r9.a(r9.b() + 1);     // Catch: Throwable -> L40
    L10:
        com.obric.aiagent.ipc.utils.b r12 = null;
        if (r10 == false) goto L14;
        e r13 = e.f18665a;     // Catch: Throwable -> L40
    L17:
        e r14 = e.f18667c;     // Catch: Throwable -> L40
        if (r9.b() >= this.f18649d) goto L20;
    L22:
        boolean r15 = false;
    L23:
        if (r15 == true) goto L26;
        r14 = null;
    L26:
        if (r14 == null) goto L28;
        r9.a(true);     // Catch: Throwable -> L40
    L28:
        if (r13 != null) goto L31;
        if (r14 != null) goto L31;
    L38:
        monitor-exit(r9);
        return r12;
    L31:
        long r16 = r11 / this.f;     // Catch: Throwable -> L40
        if (r16 <= this.k) goto L38;
        List<e> r4 = a(p.e(new e[]{r13, r14}), r16);     // Catch: Throwable -> L40
        if (r4.isEmpty() == true) goto L38;
        r12 = new com.obric.aiagent.ipc.utils.b(r4, r9.b());     // Catch: Throwable -> L40
        goto L38
    L20:
        if (r9.c() == true) goto L22;
        r15 = true;
        goto L23
    L14:
        if (r8 < this.f18648c) goto L16;
        r13 = e.f18666b;     // Catch: Throwable -> L40
        goto L17
    L16:
        r13 = null;
        goto L17
    }

    private final b a(String r12, String r13, String r14) {
        ConcurrentHashMap<String, ConcurrentHashMap<String, b>> r1 = (ConcurrentHashMap) ZeusTransformUtils.preCheckCast(this.g.get(r12), ConcurrentHashMap.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L8;
        c r2 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin");
        ConcurrentHashMap<String, ConcurrentHashMap<String, b>> r3 = new ConcurrentHashMap();
        ConcurrentHashMap<String, ConcurrentHashMap<String, b>> r15 = (ConcurrentHashMap) ZeusTransformUtils.preCheckCast(r2.g.putIfAbsent(r12, r3), ConcurrentHashMap.class, "com.obric.aiagent.plugin");
        if (r15 != null) goto L7;
        r1 = r3;
        goto L8
    L7:
        r1 = r15;
    L8:
        ConcurrentHashMap<String, b> r16 = (ConcurrentHashMap) ZeusTransformUtils.preCheckCast(r1.get(r13), ConcurrentHashMap.class, "com.obric.aiagent.plugin");
        if (r16 != null) goto L14;
        c r17 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin");
        r16 = new ConcurrentHashMap();
        ConcurrentHashMap<String, b> r18 = (ConcurrentHashMap) ZeusTransformUtils.preCheckCast(r1.putIfAbsent(r13, r16), ConcurrentHashMap.class, "com.obric.aiagent.plugin");
        if (r18 == null) goto L14;
        r16 = r18;
    L14:
        b r19 = (b) ZeusTransformUtils.preCheckCast(r16.get(r14), b.class, "com.obric.aiagent.plugin");
        if (r19 != null) goto L21;
        c r11 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin");
        b r110 = new b(0, 0, false, 7, null);
        b r111 = (b) ZeusTransformUtils.preCheckCast(r16.putIfAbsent(r14, r110), b.class, "com.obric.aiagent.plugin");
        if (r111 != null) goto L20;
        return r110;
    L20:
        return r111;
    L21:
        return r19;
    }

    private final List<e> a(List<? extends e> r4, long r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (r5 <= this.k) goto L5;
        Object r0 = this.h;
        monitor-enter(r0);
    L23:
        th = move-exception;
        throw th;
    L9:
        if (r5 > this.k) goto L12;
        List<e> r3 = p.b();     // Catch: Throwable -> L23
    L21:
        monitor-exit(r0);
        return r3;
    L12:
        if (r5 <= this.i) goto L14;
        this.i = r5;     // Catch: Throwable -> L23
        this.j = 0;     // Catch: Throwable -> L23
    L14:
        int r7 = n.c(this.f18650e - this.j, 0);     // Catch: Throwable -> L23
        if (r7 != 0) goto L17;
        r3 = p.b();     // Catch: Throwable -> L23
        goto L21
    L17:
        List<e> r8 = p.c((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin"), r7);     // Catch: Throwable -> L23
        int r9 = this.j + r8.size();     // Catch: Throwable -> L23
        this.j = r9;     // Catch: Throwable -> L23
        if (r9 < this.f18650e) goto L20;
        this.k = this.i;     // Catch: Throwable -> L23
    L20:
        r3 = r8;
        goto L21
    L5:
        return p.b();
    }
}
