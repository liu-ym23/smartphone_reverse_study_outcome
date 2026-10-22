package com.bytedance.safetyguard.lxc.internal.d;

import com.bytedance.common.wschannel.WsConstants;
import com.obric.capabilitykit.common.UiType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: ProxyWriter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class x implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f10273a = null;
    private static final Set<com.bytedance.safetyguard.lxc.internal.c.h> p = null;
    private static final Set<com.bytedance.safetyguard.lxc.internal.c.h> q = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final OutputStream f10274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f10275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f10276d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d.h.a.m<Long, Integer, d.x> f10277e;
    private final d.h.a.q<Integer, Long, Integer, d.x> f;
    private final s g;
    private final Object h;
    private final ArrayDeque<b> i;
    private final Map<Integer, c> j;
    private final ArrayDeque<Integer> k;
    private e l;
    private Throwable m;
    private long n;
    private final Thread o;

    /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.d.x$1, reason: invalid class name */
    /* JADX INFO: compiled from: ProxyWriter.kt */
    static final class AnonymousClass1 extends d.h.b.p implements d.h.a.m<Long, Integer, d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f10278a = null;

        static {
            f10278a = new AnonymousClass1();
        }

        AnonymousClass1() {
            super(2);
        }

        public final void a(long r1, int r3) {
        }

        @Override // d.h.a.m
        public /* synthetic */ d.x invoke(Long r5, Integer r6) {
            a(((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")).longValue(), ((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.aiagent.plugin")).intValue());
            return d.x.f38692a;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.d.x$2, reason: invalid class name */
    /* JADX INFO: compiled from: ProxyWriter.kt */
    static final class AnonymousClass2 extends d.h.b.p implements d.h.a.q<Integer, Long, Integer, d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AnonymousClass2 f10279a = null;

        static {
            f10279a = new AnonymousClass2();
        }

        AnonymousClass2() {
            super(3);
        }

        public final void a(int r1, long r2, int r4) {
        }

        @Override // d.h.a.q
        public /* synthetic */ d.x invoke(Integer r5, Long r6, Integer r7) {
            a(((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.aiagent.plugin")).longValue(), ((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.aiagent.plugin")).intValue());
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: ProxyWriter.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final int a(int r1) {
            return Math.max(1, Math.min(1048576, r1 / 4));
        }
    }

    /* JADX INFO: compiled from: ProxyWriter.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.bytedance.safetyguard.lxc.internal.c.h f10280a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f10281b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f10282c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final byte[] f10283d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f10284e;
        private final CompletableFuture<d.x> f;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (this.f10280a == r6.f10280a) goto L12;
            return false;
        L12:
            if (this.f10281b == r6.f10281b) goto L15;
            return false;
        L15:
            if (this.f10282c == r6.f10282c) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(this.f10283d, r6.f10283d) == true) goto L21;
            return false;
        L21:
            if (this.f10284e == r6.f10284e) goto L24;
            return false;
        L24:
            if (d.h.b.o.a(this.f, r6.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            int r0 = ((((((((this.f10280a.hashCode() * 31) + Integer.hashCode(this.f10281b)) * 31) + Integer.hashCode(this.f10282c)) * 31) + Arrays.hashCode(this.f10283d)) * 31) + Boolean.hashCode(this.f10284e)) * 31;
            CompletableFuture<d.x> r2 = this.f;
            if (r2 != null) goto L5;
            int r3 = 0;
        L7:
            return r0 + r3;
        L5:
            r3 = r2.hashCode();
            goto L7
        }

        public String toString() {
            return "QueuedFrame(type=" + this.f10280a + ", streamId=" + this.f10281b + ", payloadBytes=" + this.f10282c + ", encoded=" + Arrays.toString(this.f10283d) + ", streamOrdered=" + this.f10284e + ", commit=" + this.f + ')';
        }

        public b(com.bytedance.safetyguard.lxc.internal.c.h r2, int r3, int r4, byte[] r5, boolean r6, CompletableFuture<d.x> r7) {
            d.h.b.o.e(r2, "type");
            d.h.b.o.e(r5, "encoded");
            this.f10280a = r2;
            this.f10281b = r3;
            this.f10282c = r4;
            this.f10283d = r5;
            this.f10284e = r6;
            this.f = r7;
        }

        public final com.bytedance.safetyguard.lxc.internal.c.h getType() {
            return this.f10280a;
        }

        public final int a() {
            return this.f10281b;
        }

        public final int b() {
            return this.f10282c;
        }

        public final byte[] c() {
            return this.f10283d;
        }

        public final boolean d() {
            return this.f10284e;
        }

        public final CompletableFuture<d.x> e() {
            return this.f;
        }
    }

    /* JADX INFO: compiled from: ProxyWriter.kt */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ArrayDeque<b> f10285a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f10286b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f10287c;

        public c() {
            this.f10285a = new ArrayDeque();
        }

        public final ArrayDeque<b> a() {
            return this.f10285a;
        }

        public final void a(long r1) {
            this.f10286b = r1;
        }

        public final long b() {
            return this.f10286b;
        }

        public final void a(boolean r1) {
            this.f10287c = r1;
        }

        public final boolean c() {
            return this.f10287c;
        }
    }

    /* JADX INFO: compiled from: ProxyWriter.kt */
    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10288a = null;

        static {
            int[] r0 = new int[com.bytedance.safetyguard.lxc.internal.c.h.values().length];
            r0[com.bytedance.safetyguard.lxc.internal.c.h.g.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L27:
            r0[com.bytedance.safetyguard.lxc.internal.c.h.h.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L43:
            r0[com.bytedance.safetyguard.lxc.internal.c.h.i.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L31:
            r0[com.bytedance.safetyguard.lxc.internal.c.h.f9834c.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L35:
            r0[com.bytedance.safetyguard.lxc.internal.c.h.f.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L25:
            r0[com.bytedance.safetyguard.lxc.internal.c.h.k.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L37:
            r0[com.bytedance.safetyguard.lxc.internal.c.h.j.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
        L39:
            r0[com.bytedance.safetyguard.lxc.internal.c.h.f9835d.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
        L29:
            r0[com.bytedance.safetyguard.lxc.internal.c.h.f9833b.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
        L33:
            r0[com.bytedance.safetyguard.lxc.internal.c.h.f9836e.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
        L13:
            f10288a = r0;
        }
    }

    /* JADX INFO: compiled from: ProxyWriter.kt */
    private static final enum e extends Enum<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f10289a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f10290b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final e f10291c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final e f10292d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ e[] f10293e = null;
        private static final /* synthetic */ d.d.a f = null;

        private static final /* synthetic */ e[] a() {
            return new e[]{f10289a, f10290b, f10291c, f10292d};
        }

        public static e valueOf(String r2) {
            return (e) ZeusTransformUtils.preCheckCast(Enum.valueOf(e.class, r2), e.class, "com.obric.aiagent.plugin");
        }

        public static e[] values() {
            return (e[]) ZeusTransformUtils.preCheckCast(f10293e.clone(), e[].class, "com.obric.aiagent.plugin");
        }

        private e(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f10289a = new e("OPEN", 0);
            f10290b = new e("CLOSING", 1);
            f10291c = new e("FAILED", 2);
            f10292d = new e("CLOSED", 3);
            e[] r0 = a();
            f10293e = r0;
            f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: lambda$SO2BVLJ-AZUDfSd2CdIdeqdKmDI, reason: not valid java name */
    public static /* synthetic */ void m43lambda$SO2BVLJAZUDfSd2CdIdeqdKmDI(x r0) {
        r0.b();
    }

    public x(OutputStream r3, int r4, int r5, d.h.a.m<? super Long, ? super Integer, d.x> r6, d.h.a.q<? super Integer, ? super Long, ? super Integer, d.x> r7, s r8) {
        d.h.a.m<Long, Integer, d.x> r9 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.h.a.q<Integer, Long, Integer, d.x> r10 = (d.h.a.q) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.q.class, "com.obric.aiagent.plugin");
        s r11 = (s) ZeusTransformUtils.wrapperContextForParams(r8, s.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "output");
        d.h.b.o.e(r9, "onPendingBytesExceeded");
        d.h.b.o.e(r10, "onStreamPendingBytesExceeded");
        d.h.b.o.e(r11, "logger");
        this.f10274b = r3;
        this.f10275c = r4;
        this.f10276d = r5;
        this.f10277e = r9;
        this.f = r10;
        this.g = r11;
        boolean r12 = false;
        if (r4 <= 0) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == false) goto L15;
        if (r5 <= 0) goto L9;
        r12 = true;
    L9:
        if (r12 == false) goto L13;
        this.h = new Object();
        this.i = new ArrayDeque();
        this.j = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        this.k = new ArrayDeque();
        this.l = e.f10289a;
        Thread r14 = new Thread(new $$Lambda$x$SO2BVLJAZUDfSd2CdIdeqdKmDI(this), "SafetyGuardLxcProxyWriter");
        r14.setDaemon(true);
        r14.start();
        this.o = r14;
        return;
    L13:
        throw new IllegalArgumentException("maxPendingBytesPerStream must be positive".toString());
    L15:
        throw new IllegalArgumentException("maxPendingBytes must be positive".toString());
    L5:
        r13 = false;
        goto L6
    }

    public /* synthetic */ x(OutputStream r8, int r9, int r10, d.h.a.m r11, d.h.a.q r12, s r13, int r14, d.h.b.h r15) {
        d.h.a.m r0 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r11, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.h.a.q r2 = (d.h.a.q) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.q.class, "com.obric.aiagent.plugin");
        s r3 = (s) ZeusTransformUtils.wrapperContextForParams(r13, s.class, "com.obric.aiagent.plugin");
        if ((r14 & 2) == 0) goto L5;
        int r4 = UiType.FLAG_APPLET_CARD;
    L7:
        if ((r14 & 4) == 0) goto L9;
        int r5 = f10273a.a(r4);
    L11:
        if ((r14 & 8) == 0) goto L14;
        r0 = (d.h.a.m) ZeusTransformUtils.preCheckCast(AnonymousClass1.f10278a, d.h.a.m.class, "com.obric.aiagent.plugin");
    L14:
        if ((r14 & 16) == 0) goto L17;
        r2 = (d.h.a.q) ZeusTransformUtils.preCheckCast(AnonymousClass2.f10279a, d.h.a.q.class, "com.obric.aiagent.plugin");
    L17:
        if ((r14 & 32) == 0) goto L19;
        r3 = (s) ZeusTransformUtils.preCheckCast(l.f10244a, s.class, "com.obric.aiagent.plugin");
    L19:
        this(r8, r4, r5, r0, r2, r3);
        return;
    L9:
        r5 = r10;
        goto L11
    L5:
        r4 = r9;
        goto L7
    }

    public final void a(com.bytedance.safetyguard.lxc.internal.c.f r3) {
        d.h.b.o.e(r3, "frame");
        switch(d.f10288a[r3.getType().ordinal()]) {
            case 1: goto L8;
            case 2: goto L8;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L7;
            case 6: goto L7;
            case 7: goto L7;
            case 8: goto L7;
            case 9: goto L6;
            case 10: goto L6;
            default: goto L11;
        };
    L7:
        b(r3);
        return;
    L8:
        e(r3);
        return;
    L11:
        return;
    L6:
        throw new com.bytedance.safetyguard.lxc.internal.c.k("Writer cannot send gateway-owned frame type: " + r3.getType(), null, 2, null);
    }

    public final void b(com.bytedance.safetyguard.lxc.internal.c.f r4) {
        d.h.b.o.e(r4, "frame");
        if (q.contains(r4.getType()) == false) goto L13;
        byte[] r0 = com.bytedance.safetyguard.lxc.internal.c.g.f9831a.a(r4);
        Object r2 = this.h;
        monitor-enter(r2);
        e();     // Catch: Throwable -> L9
        a(r4, r0, null);     // Catch: Throwable -> L9
        d.x r3 = d.x.f38692a;     // Catch: Throwable -> L9
        monitor-exit(r2);
        return;
    L9:
        th = move-exception;
        throw th;
    L13:
        throw new com.bytedance.safetyguard.lxc.internal.c.k("Frame must not use immediate queue: " + r4.getType(), null, 2, null);
    }

    public final void c(com.bytedance.safetyguard.lxc.internal.c.f r4) {
        d.h.b.o.e(r4, "frame");
        if (r4.getType() != com.bytedance.safetyguard.lxc.internal.c.h.f9834c) goto L29;
        if (r4.a() != 0) goto L29;
        byte[] r0 = com.bytedance.safetyguard.lxc.internal.c.g.f9831a.a(r4);
        CompletableFuture<d.x> r1 = new CompletableFuture();
        Object r2 = this.h;     // Catch: Exception -> L25
        monitor-enter(r2);     // Catch: Exception -> L25
        e();     // Catch: Throwable -> L22
        a(r4, r0, r1);     // Catch: Throwable -> L22
        d.x r3 = d.x.f38692a;     // Catch: Throwable -> L22
        monitor-exit(r2);     // Catch: Exception -> L25
        r1.get();     // Catch: ExecutionException -> L13 InterruptedException -> L19
        return;
    L19:
        e = move-exception;
        Thread.currentThread().interrupt();
        throw new y("Interrupted while committing HELLO_ACK", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L13:
        e = move-exception;
        Throwable r5 = e.getCause();
        if (r5 != null) goto L18;
        r5 = (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin");
    L18:
        throw new y("HELLO_ACK commit failed", r5);
    L22:
        th = move-exception;
        throw th;     // Catch: Exception -> L25
    L25:
        e = move-exception;
        throw new y("HELLO_ACK could not be queued", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L29:
        throw new com.bytedance.safetyguard.lxc.internal.c.k("Commit barrier requires HELLO_ACK on stream 0", null, 2, null);
    }

    public final boolean d(com.bytedance.safetyguard.lxc.internal.c.f r6) {
        d.h.b.o.e(r6, "frame");
        if (q.contains(r6.getType()) == false) goto L19;
        byte[] r0 = com.bytedance.safetyguard.lxc.internal.c.g.f9831a.a(r6);
        Object r2 = this.h;
        monitor-enter(r2);
        f();     // Catch: Throwable -> L15
        if (this.l != e.f10289a) goto L9;
        a(r6, r0, null);     // Catch: Throwable -> L15
        monitor-exit(r2);
        return true;
    L9:
        monitor-exit(r2);
        return false;
    L15:
        th = move-exception;
        throw th;
    L19:
        throw new com.bytedance.safetyguard.lxc.internal.c.k("Frame must not use immediate queue: " + r6.getType(), null, 2, null);
    }

    private final void a(com.bytedance.safetyguard.lxc.internal.c.f r10, byte[] r11, CompletableFuture<d.x> r12) {
        b(r11.length);
        this.i.addLast(new b(r10.getType(), r10.a(), r10.c().length, r11, false, r12));
        this.h.notifyAll();
    }

    public final void e(com.bytedance.safetyguard.lxc.internal.c.f r12) {
        d.h.b.o.e(r12, "frame");
        if (p.contains(r12.getType()) == false) goto L28;
        if (r12.a() <= 0) goto L26;
        byte[] r5 = com.bytedance.safetyguard.lxc.internal.c.g.f9831a.a(r12);
        Object r0 = this.h;
        monitor-enter(r0);
        e();     // Catch: Throwable -> L22
        Map<Integer, c> r1 = this.j;     // Catch: Throwable -> L22
        Integer r2 = Integer.valueOf(r12.a());     // Catch: Throwable -> L22
        c r3 = r1.get(r2);     // Catch: Throwable -> L22
        if (r3 != null) goto L11;
        r3 = new c();     // Catch: Throwable -> L22
        r1.put(r2, r3);     // Catch: Throwable -> L22
    L11:
        c r8 = (c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        b(r5.length);     // Catch: Throwable -> L22
        a(r12.a(), r8, r5.length);     // Catch: Throwable -> L19
        r8.a().addLast(new b(r12.getType(), r12.a(), r12.c().length, r5, true, null));     // Catch: Throwable -> L22
        if (r8.c() == true) goto L16;
        r8.a(true);     // Catch: Throwable -> L22
        this.k.addLast(Integer.valueOf(r12.a()));     // Catch: Throwable -> L22
    L16:
        this.h.notifyAll();     // Catch: Throwable -> L22
        d.x r11 = d.x.f38692a;     // Catch: Throwable -> L22
        monitor-exit(r0);
        return;
    L19:
        th = move-exception;
        this.n -= (long) r5.length;     // Catch: Throwable -> L22
        this.h.notifyAll();     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    L26:
        throw new com.bytedance.safetyguard.lxc.internal.c.k("Stream-ordered frame requires non-zero streamId", null, 2, null);
    L28:
        throw new com.bytedance.safetyguard.lxc.internal.c.k("Frame must not use stream-ordered queue: " + r12.getType(), null, 2, null);
    }

    public final void f(com.bytedance.safetyguard.lxc.internal.c.f r3) {
        d.h.b.o.e(r3, "frame");
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L5
        ((x) ZeusTransformUtils.preCheckCast(this, x.class, "com.obric.aiagent.plugin")).a(r3);     // Catch: Throwable -> L5
        d.n.f(d.x.f38692a);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        d.n.a r4 = d.n.f38560a;
        d.n.f(d.o.a(th));
    }

    public final void a(int r9, int r10) {
        if (r10 <= 0) goto L6;
        com.bytedance.safetyguard.lxc.internal.c.h r1 = com.bytedance.safetyguard.lxc.internal.c.h.k;
        byte[] r4 = ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN).putInt(r10).array();
        d.h.b.o.c(r4, "array(...)");
        b(new com.bytedance.safetyguard.lxc.internal.c.f(r1, r9, 0, r4, 4, null));
        return;
    L6:
        throw new com.bytedance.safetyguard.lxc.internal.c.k("WINDOW_UPDATE delta must be positive", null, 2, null);
    }

    public final void a(int r10) {
        Object r0 = this.h;
        monitor-enter(r0);
        Iterator<b> r1 = this.i.iterator();     // Catch: Throwable -> L20
        d.h.b.o.c(r1, "iterator(...)");     // Catch: Throwable -> L20
    L6:
        if (r1.hasNext() == false) goto L10;
        b r2 = (b) ZeusTransformUtils.preCheckCast(r1.next(), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        if (r2.a() != r10) goto L6;
        r1.remove();     // Catch: Throwable -> L20
        this.n -= (long) r2.c().length;     // Catch: Throwable -> L20
        goto L6
    L10:
        c r11 = (c) ZeusTransformUtils.preCheckCast(this.j.remove(Integer.valueOf(r10)), c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        if (r11 == null) goto L17;
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r11.a(), Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L20
        long r4 = 0;
    L14:
        if (r3.hasNext() == false) goto L16;
        r4 = r4 + ((long) ((b) ZeusTransformUtils.preCheckCast(r3.next(), b.class, "com.obric.aiagent.plugin")).c().length);     // Catch: Throwable -> L20
        goto L14
    L16:
        this.n -= r4;     // Catch: Throwable -> L20
        r11.a(0);     // Catch: Throwable -> L20
        r11.a().clear();     // Catch: Throwable -> L20
        r11.a(false);     // Catch: Throwable -> L20
    L17:
        this.h.notifyAll();     // Catch: Throwable -> L20
        d.x r9 = d.x.f38692a;     // Catch: Throwable -> L20
        monitor-exit(r0);
        return;
    L20:
        th = move-exception;
        throw th;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a(WsConstants.EXIT_DELAY_TIME);
    }

    public final void a(long r8) {
        Object r0 = this.h;
        monitor-enter(r0);
    L36:
        th = move-exception;
        throw th;
    L5:
        if (this.l != e.f10292d) goto L9;
        monitor-exit(r0);
        return;
    L9:
        if (this.l != e.f10289a) goto L11;
        this.l = e.f10290b;     // Catch: Throwable -> L36
        this.h.notifyAll();     // Catch: Throwable -> L36
    L11:
        long r1 = System.nanoTime() + TimeUnit.MILLISECONDS.toNanos(r8);     // Catch: Throwable -> L36
    L13:
        if (this.n <= 0) goto L19;
        if (this.m != null) goto L19;
        long r3 = r1 - System.nanoTime();     // Catch: Throwable -> L36
        if (r3 <= 0) goto L19;
        TimeUnit.NANOSECONDS.timedWait(this.h, r3);     // Catch: Throwable -> L36
    L19:
        this.l = e.f10292d;     // Catch: Throwable -> L36
        h();     // Catch: Throwable -> L36
        this.h.notifyAll();     // Catch: Throwable -> L36
        d.x r2 = d.x.f38692a;     // Catch: Throwable -> L36
        monitor-exit(r0);
        d.n.a r4 = d.n.f38560a;     // Catch: Throwable -> L23
        ((x) ZeusTransformUtils.preCheckCast(this, x.class, "com.obric.aiagent.plugin")).f10274b.close();     // Catch: Throwable -> L23
        Object r5 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L23
    L25:
        Throwable r6 = d.n.c(r5);
        if (r6 == null) goto L29;
        a(r6);
    L29:
        if (b(r8) == true) goto L31;
        a((Throwable) ZeusTransformUtils.preCheckCast(new IOException("Proxy writer termination timeout"), Throwable.class, "com.obric.aiagent.plugin"));
    L31:
        Throwable r7 = this.m;
        if (r7 != null) goto L35;
        return;
    L35:
        throw new IOException("Proxy writer failed", r7);
    L23:
        th = move-exception;
        d.n.a r9 = d.n.f38560a;
        r5 = d.n.f(d.o.a(th));
        goto L25
    }

    public final void a() {
        Object r0 = this.h;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (this.l != e.f10292d) goto L8;
        monitor-exit(r0);
        return;
    L8:
        this.l = e.f10292d;     // Catch: Throwable -> L18
        h();     // Catch: Throwable -> L18
        this.h.notifyAll();     // Catch: Throwable -> L18
        d.x r1 = d.x.f38692a;     // Catch: Throwable -> L18
        monitor-exit(r0);
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L12
        ((x) ZeusTransformUtils.preCheckCast(this, x.class, "com.obric.aiagent.plugin")).f10274b.close();     // Catch: Throwable -> L12
        Object r3 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L12
    L14:
        Throwable r4 = d.n.c(r3);
        if (r4 == null) goto L25;
        a(r4);
        return;
    L25:
        return;
    L12:
        th = move-exception;
        d.n.a r5 = d.n.f38560a;
        r3 = d.n.f(d.o.a(th));
        goto L14
    }

    public final boolean b(long r2) {
        this.o.join(r2);
        return !this.o.isAlive();
    }

    private final void b() {
    L2:
        boolean r0 = c();
        b r1 = d();
        if (r1 != null) goto L4;
        if (r0 == true) goto L2;
        Object r2 = this.h;
        monitor-enter(r2);
        if (this.l == e.f10292d) goto L10;
        if (g() == true) goto L15;
        this.h.wait(100);     // Catch: Throwable -> L18
    L15:
        d.x r3 = d.x.f38692a;     // Catch: Throwable -> L18
        monitor-exit(r2);
        goto L2
    L10:
        monitor-exit(r2);
        return;
    L18:
        th = move-exception;
        throw th;
    L4:
        a(r1);
        goto L2
    }

    private final boolean c() {
        int r0 = 0;
        boolean r1 = false;
    L4:
        if (r0 >= 64) goto L15;
        Object r2 = this.h;
        monitor-enter(r2);
        b r3 = (b) ZeusTransformUtils.preCheckCast(this.i.pollFirst(), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        monitor-exit(r2);
        if (r3 == null) goto L10;
        d.h.b.o.a(r3);
        a(r3);
        r0 = r0 + 1;
        r1 = true;
        goto L4
    L10:
        return r1;
    L12:
        th = move-exception;
        throw th;
    L15:
        return r1;
    }

    private final b d() {
        Object r0 = this.h;
        monitor-enter(r0);
    L26:
    L23:
        th = move-exception;
        throw th;
    L5:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.k, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L21;
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(this.k.removeFirst(), Integer.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L23
        c r2 = (c) ZeusTransformUtils.preCheckCast(this.j.get(r1), c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L23
        if (r2 == null) goto L26;
        b r3 = (b) ZeusTransformUtils.preCheckCast(r2.a().pollFirst(), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L23
        if (r3 != null) goto L15;
        r2.a(false);     // Catch: Throwable -> L23
        if (r2.b() != 0) goto L26;
        this.j.remove(r1);     // Catch: Throwable -> L23
        goto L26
    L15:
        if (r2.a().isEmpty() == false) goto L17;
        r2.a(false);     // Catch: Throwable -> L23
    L18:
        monitor-exit(r0);
        return r3;
    L17:
        this.k.addLast(r1);     // Catch: Throwable -> L23
        goto L18
    L21:
        monitor-exit(r0);
        return null;
    }

    private final void a(b r6) {
        Object r0 = this.h;
        monitor-enter(r0);
    L31:
        th = move-exception;
        throw th;
    L5:
        if (this.l != e.f10292d) goto L7;
        Throwable r1 = (Throwable) ZeusTransformUtils.preCheckCast(new IOException("Proxy writer was closed before commit"), Throwable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L31
    L11:
        monitor-exit(r0);
        if (r1 == null) goto L37;
        CompletableFuture<d.x> r2 = r6.e();
        if (r2 == null) goto L16;
        r2.completeExceptionally(r1);
    L16:
        b(r6);
        return;
    L37:
        this.f10274b.write(r6.c());     // Catch: Throwable -> L22
        this.f10274b.flush();     // Catch: Throwable -> L22
        CompletableFuture<d.x> r3 = r6.e();     // Catch: Throwable -> L22
        if (r3 == null) goto L21;
        r3.complete(d.x.f38692a);     // Catch: Throwable -> L22
    L21:
        b(r6);
        return;
    L22:
        th = move-exception;
        this.g.b("ProxyWriter", "component=proxy_writer event=frame_write_failed outcome=failed frameType=" + r6.getType() + " streamId=" + r6.a() + " requestBytes=" + r6.b(), th);     // Catch: Throwable -> L28
        a(th);     // Catch: Throwable -> L28
        CompletableFuture<d.x> r4 = r6.e();     // Catch: Throwable -> L28
        if (r4 == null) goto L21;
        r4.completeExceptionally(th);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        b(r6);
        throw th;
    L7:
        r1 = this.m;     // Catch: Throwable -> L31
        if (r1 != null) goto L11;
        r1 = null;
        goto L11
    }

    private final void b(b r7) {
        Object r0 = this.h;
        monitor-enter(r0);
        this.n -= (long) r7.c().length;     // Catch: Throwable -> L18
        if (r7.d() == false) goto L15;
        c r1 = (c) ZeusTransformUtils.preCheckCast(this.j.get(Integer.valueOf(r7.a())), c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        if (r1 == null) goto L15;
        r1.a(r1.b() - ((long) r7.c().length));     // Catch: Throwable -> L18
        if (r1.b() > 0) goto L15;
        if (r1.a().isEmpty() == false) goto L15;
        if (r1.c() == true) goto L15;
        this.j.remove(Integer.valueOf(r7.a()));     // Catch: Throwable -> L18
    L15:
        this.h.notifyAll();     // Catch: Throwable -> L18
        d.x r6 = d.x.f38692a;     // Catch: Throwable -> L18
        monitor-exit(r0);
        return;
    L18:
        th = move-exception;
        throw th;
    }

    private final void a(Throwable r3) {
        Object r0 = this.h;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.m != null) goto L8;
        this.m = r3;     // Catch: Throwable -> L13
    L8:
        if (this.l == e.f10292d) goto L10;
        this.l = e.f10291c;     // Catch: Throwable -> L13
    L10:
        this.h.notifyAll();     // Catch: Throwable -> L13
        d.x r2 = d.x.f38692a;     // Catch: Throwable -> L13
        monitor-exit(r0);
    }

    private final void e() {
        f();
        if (this.l != e.f10289a) goto L6;
        return;
    L6:
        throw new com.bytedance.safetyguard.lxc.internal.c.k("Proxy writer is not open: " + this.l, null, 2, null);
    }

    private final void f() {
        Throwable r2 = this.m;
        if (r2 != null) goto L6;
        return;
    L6:
        throw new com.bytedance.safetyguard.lxc.internal.c.k("Proxy writer failed", r2);
    }

    private final void b(int r7) {
        long r0 = this.n;
        long r2 = ((long) r7) + r0;
        if (r2 > this.f10275c) goto L6;
        this.n = r2;
        return;
    L6:
        this.f10277e.invoke(Long.valueOf(r0), Integer.valueOf(r7));
        throw new com.bytedance.safetyguard.lxc.internal.c.k("Pending writer bytes exceeded: pending=" + this.n + ", requested=" + r7 + ", max=" + this.f10275c, null, 2, null);
    }

    private final void a(int r5, c r6, int r7) {
        long r0 = r6.b() + ((long) r7);
        if (r0 > this.f10276d) goto L6;
        r6.a(r0);
        return;
    L6:
        this.f.invoke(Integer.valueOf(r5), Long.valueOf(r6.b()), Integer.valueOf(r7));
        throw new com.bytedance.safetyguard.lxc.internal.c.k("Pending stream writer bytes exceeded: streamId=" + r5 + ", pending=" + r6.b() + ", requested=" + r7 + ", max=" + this.f10276d, null, 2, null);
    }

    private final boolean g() {
        if (this.n > 0) goto L19;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.i, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == true) goto L19;
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(this.j.values(), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == true) goto L9;
    L11:
        Iterator r6 = r5.iterator();
    L13:
        if (r6.hasNext() == false) goto L10;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(((c) ZeusTransformUtils.preCheckCast(r6.next(), c.class, "com.obric.aiagent.plugin")).a(), Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L13;
        boolean r7 = true;
    L17:
        if (r7 == true) goto L19;
        return false;
    L10:
        r7 = false;
        goto L17
    L9:
        if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L11;
    L19:
        return true;
    }

    private final void h() {
        IOException r0 = new IOException("Proxy writer discarded queued frames");
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(this.i, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        CompletableFuture<d.x> r2 = ((b) ZeusTransformUtils.preCheckCast(r1.next(), b.class, "com.obric.aiagent.plugin")).e();
        if (r2 == null) goto L4;
        r2.completeExceptionally((Throwable) ZeusTransformUtils.preCheckCast(r0, Throwable.class, "com.obric.aiagent.plugin"));
        goto L4
    L8:
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.j.values(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L10:
        if (r3.hasNext() == false) goto L17;
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(((c) ZeusTransformUtils.preCheckCast(r3.next(), c.class, "com.obric.aiagent.plugin")).a(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L13:
        if (r4.hasNext() == false) goto L10;
        CompletableFuture<d.x> r5 = ((b) ZeusTransformUtils.preCheckCast(r4.next(), b.class, "com.obric.aiagent.plugin")).e();
        if (r5 == null) goto L13;
        r5.completeExceptionally((Throwable) ZeusTransformUtils.preCheckCast(r0, Throwable.class, "com.obric.aiagent.plugin"));
        goto L13
    L17:
        this.i.clear();
        this.j.clear();
        this.k.clear();
        this.n = 0;
    }

    static {
        f10273a = new a(null);
        p = ax.a(new com.bytedance.safetyguard.lxc.internal.c.h[]{com.bytedance.safetyguard.lxc.internal.c.h.g, com.bytedance.safetyguard.lxc.internal.c.h.h, com.bytedance.safetyguard.lxc.internal.c.h.i});
        q = ax.a(new com.bytedance.safetyguard.lxc.internal.c.h[]{com.bytedance.safetyguard.lxc.internal.c.h.f9834c, com.bytedance.safetyguard.lxc.internal.c.h.f, com.bytedance.safetyguard.lxc.internal.c.h.k, com.bytedance.safetyguard.lxc.internal.c.h.j, com.bytedance.safetyguard.lxc.internal.c.h.f9835d});
    }
}
