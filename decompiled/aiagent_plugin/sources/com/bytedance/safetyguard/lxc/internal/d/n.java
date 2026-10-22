package com.bytedance.safetyguard.lxc.internal.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PinnedAddressConnector.kt */
/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f10249a = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f10250d = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final v f10251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.h.a.a<Long> f10252c;

    /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.d.n$1, reason: invalid class name */
    /* JADX INFO: compiled from: PinnedAddressConnector.kt */
    /* synthetic */ class AnonymousClass1 extends d.h.b.l implements d.h.a.a<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f10253a = null;

        static {
            f10253a = new AnonymousClass1();
        }

        AnonymousClass1() {
            super(0, System.class, "nanoTime", "nanoTime()J", 0);
        }

        public final Long a() {
            return Long.valueOf(System.nanoTime());
        }

        @Override // d.h.a.a
        public /* synthetic */ Long invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: PinnedAddressConnector.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public n(v r3, d.h.a.a<Long> r4) {
        v r5 = (v) ZeusTransformUtils.wrapperContextForParams(r3, v.class, "com.obric.aiagent.plugin");
        d.h.a.a<Long> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "socketFactory");
        d.h.b.o.e(r6, "nanoTime");
        this.f10251b = r5;
        this.f10252c = r6;
    }

    public /* synthetic */ n(v r2, d.h.a.a r3, int r4, d.h.b.h r5) {
        v r6 = (v) ZeusTransformUtils.wrapperContextForParams(r2, v.class, "com.obric.aiagent.plugin");
        d.h.a.a r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = (v) ZeusTransformUtils.preCheckCast(g.f10231a, v.class, "com.obric.aiagent.plugin");
    L6:
        if ((r4 & 2) == 0) goto L8;
        r7 = (d.h.a.a) ZeusTransformUtils.preCheckCast(AnonymousClass1.f10253a, d.h.a.a.class, "com.obric.aiagent.plugin");
    L8:
        this(r6, r7);
    }

    public final Socket a(com.bytedance.safetyguard.lxc.internal.b.q r11, int r12, d.h.a.b<? super Socket, d.x> r13) {
        d.h.a.b r14 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r13, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r11, "target");
        d.h.b.o.e(r14, "onSocketCreated");
        if (r12 <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L38;
        long r3 = ((Number) ZeusTransformUtils.preCheckCast(this.f10252c.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue() + TimeUnit.MILLISECONDS.toNanos(r12);
        Exception e2 = null;
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r11.b(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L9:
        if (r5.hasNext() == false) goto L29;
        InetAddress r6 = (InetAddress) ZeusTransformUtils.preCheckCast(r5.next(), InetAddress.class, "com.obric.aiagent.plugin");
        int r7 = a(r3);
        if (r7 <= 0) goto L27;
        Socket r4 = this.f10251b.a();     // Catch: Exception -> L24
        r14.invoke(r4);     // Catch: Exception -> L15
        r4.setTcpNoDelay(true);     // Catch: Exception -> L15
        r4.connect((SocketAddress) ZeusTransformUtils.preCheckCast(new InetSocketAddress(r6, r11.a()), SocketAddress.class, "com.obric.aiagent.plugin"), r7);     // Catch: Exception -> L15
        return r4;
    L15:
        e = move-exception;
        d.n.a r8 = d.n.f38560a;     // Catch: Throwable -> L18
        r4.close();     // Catch: Throwable -> L18
        d.n.f(d.x.f38692a);     // Catch: Throwable -> L18
    L21:
        if (ZeusTransformUtils.instanceOf(e, o.class) == true) goto L23;
        e2 = e;
        goto L9
    L23:
        throw e;
    L18:
        th = move-exception;
        d.n.a r9 = d.n.f38560a;
        d.n.f(d.o.a(th));
    L24:
        e2 = e;
        goto L9
    L27:
        throw a(r12, e2);
    L29:
        if (a(r3) <= 0) goto L36;
        if (e2 == null) goto L32;
        Object r10 = ZeusTransformUtils.preCheckCast(e2, Throwable.class, "com.obric.aiagent.plugin");
    L34:
        throw ((Throwable) r10);
    L32:
        r10 = ZeusTransformUtils.preCheckCast(new ConnectException("No resolved address could be connected"), Throwable.class, "com.obric.aiagent.plugin");
        goto L34
    L36:
        throw a(r12, e2);
    L38:
        throw new IllegalArgumentException("Connect timeout must be positive".toString());
    L5:
        r2 = false;
        goto L6
    }

    private final int a(long r5) {
        long r6 = r5 - ((Number) ZeusTransformUtils.preCheckCast(this.f10252c.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue();
        if (r6 > 0) goto L6;
        return 0;
    L6:
        long r0 = f10250d;
        return (int) d.l.n.b(((r6 + r0) - 1) / r0, 2147483647L);
    }

    private final SocketTimeoutException a(int r3, Exception r4) {
        SocketTimeoutException r2 = new SocketTimeoutException("Timed out connecting resolved target after " + r3 + " ms");
        if (r4 == null) goto L5;
        r2.initCause((Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.aiagent.plugin"));
    L5:
        return r2;
    }

    static {
        f10249a = new a(null);
        f10250d = TimeUnit.MILLISECONDS.toNanos(1);
    }
}
