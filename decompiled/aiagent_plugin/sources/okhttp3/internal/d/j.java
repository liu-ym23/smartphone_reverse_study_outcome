package okhttp3.internal.d;

import com.bytedance.security.zenmobile.io.SensitiveType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.af;
import okhttp3.r;
import okhttp3.v;

/* JADX INFO: compiled from: RouteSelector.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f39907a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final okhttp3.a f39908b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h f39909c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final okhttp3.e f39910d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final r f39911e;
    private List<? extends Proxy> f;
    private int g;
    private List<? extends InetSocketAddress> h;
    private final List<af> i;

    /* JADX INFO: compiled from: RouteSelector.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final String a(InetSocketAddress r1) {
            o.e(r1, "<this>");
            InetAddress r0 = r1.getAddress();
            if (r0 != null) goto L6;
            String r2 = r1.getHostName();
            o.c(r2, "hostName");
            return r2;
        L6:
            String r3 = r0.getHostAddress();
            o.c(r3, "address.hostAddress");
            return r3;
        }
    }

    /* JADX INFO: compiled from: RouteSelector.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<af> f39912a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f39913b;

        public b(List<af> r3) {
            List<af> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            o.e(r4, "routes");
            this.f39912a = r4;
        }

        public final List<af> a() {
            return this.f39912a;
        }

        public final boolean b() {
            if (this.f39913b >= this.f39912a.size()) goto L5;
            return true;
        L5:
            return false;
        }

        public final af c() {
            if (b() == false) goto L7;
            List<af> r0 = this.f39912a;
            int r1 = this.f39913b;
            this.f39913b = r1 + 1;
            return (af) ZeusTransformUtils.preCheckCast(r0.get(r1), af.class, "com.obric.aiagent.plugin");
        L7:
            throw new NoSuchElementException();
        }
    }

    static {
        f39907a = new a(null);
    }

    public j(okhttp3.a r3, h r4, okhttp3.e r5, r r6) {
        okhttp3.e r7 = (okhttp3.e) ZeusTransformUtils.wrapperContextForParams(r5, okhttp3.e.class, "com.obric.aiagent.plugin");
        o.e(r3, SensitiveType.ADDRESS);
        o.e(r4, "routeDatabase");
        o.e(r7, "call");
        o.e(r6, "eventListener");
        this.f39908b = r3;
        this.f39909c = r4;
        this.f39910d = r7;
        this.f39911e = r6;
        this.f = p.b();
        this.h = p.b();
        this.i = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        a(r3.i(), r3.g());
    }

    public final boolean a() {
        if (c() == false) goto L5;
        return true;
    L5:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.i, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == true) goto L10;
        return false;
    L10:
        return true;
    }

    public final b b() {
        if (a() == false) goto L22;
        List r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    L6:
        if (c() == false) goto L17;
        Proxy r1 = d();
        Iterator<? extends InetSocketAddress> r3 = this.h.iterator();
    L9:
        if (r3.hasNext() == false) goto L15;
        af r5 = new af(this.f39908b, r1, (InetSocketAddress) ZeusTransformUtils.preCheckCast(r3.next(), InetSocketAddress.class, "com.obric.aiagent.plugin"));
        if (this.f39909c.c(r5) == true) goto L12;
        ((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin")).add(r5);
        goto L9
    L12:
        ((Collection) ZeusTransformUtils.preCheckCast(this.i, Collection.class, "com.obric.aiagent.plugin")).add(r5);
        goto L9
    L15:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L6;
    L17:
        if (r0.isEmpty() == false) goto L20;
        p.a((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(this.i, Iterable.class, "com.obric.aiagent.plugin"));
        this.i.clear();
    L20:
        return new b(r0);
    L22:
        throw new NoSuchElementException();
    }

    private static final List<Proxy> a(Proxy r2, v r3, j r4) {
        if (r2 != null) goto L4;
        URI r5 = r3.f();
        if (r5.getHost() == null) goto L8;
        List<Proxy> r6 = r4.f39908b.h().select(r5);
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L12;
    L15:
        boolean r8 = true;
    L16:
        if (r8 == true) goto L18;
        o.c(r6, "proxiesOrNull");
        return okhttp3.internal.c.b(r6);
    L18:
        return okhttp3.internal.c.a(new Proxy[]{Proxy.NO_PROXY});
    L12:
        if (r7.isEmpty() == true) goto L15;
        r8 = false;
        goto L16
    L8:
        return okhttp3.internal.c.a(new Proxy[]{Proxy.NO_PROXY});
    L4:
        return p.a(r2);
    }

    private final void a(v r3, Proxy r4) {
        this.f39911e.proxySelectStart(this.f39910d, r3);
        List<Proxy> r5 = a(r4, r3, this);
        this.f = r5;
        this.g = 0;
        this.f39911e.proxySelectEnd(this.f39910d, r3, r5);
    }

    private final boolean c() {
        if (this.g >= this.f.size()) goto L5;
        return true;
    L5:
        return false;
    }

    private final Proxy d() {
        if (c() == false) goto L7;
        List<? extends Proxy> r0 = this.f;
        int r1 = this.g;
        this.g = r1 + 1;
        Proxy r2 = (Proxy) ZeusTransformUtils.preCheckCast(r0.get(r1), Proxy.class, "com.obric.aiagent.plugin");
        a(r2);
        return r2;
    L7:
        throw new SocketException("No route to " + this.f39908b.i().b() + "; exhausted proxy configurations: " + this.f);
    }

    private final void a(Proxy r8) {
        List<? extends InetSocketAddress> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        this.h = r0;
        if (r8.type() != Proxy.Type.DIRECT) goto L5;
    L12:
        String r3 = this.f39908b.i().b();
        int r1 = this.f39908b.i().c();
    L13:
        boolean r4 = false;
        if (1 <= r1) goto L16;
    L18:
        if (r4 == false) goto L36;
        if (r8.type() != Proxy.Type.SOCKS) goto L23;
        ((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin")).add(InetSocketAddress.createUnresolved(r3, r1));
        return;
    L23:
        if (okhttp3.internal.c.b(r3) == false) goto L25;
        List<InetAddress> r7 = p.a(InetAddress.getByName(r3));
    L28:
        Iterator<InetAddress> r9 = r7.iterator();
    L30:
        if (r9.hasNext() == false) goto L38;
        ((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin")).add(new InetSocketAddress((InetAddress) ZeusTransformUtils.preCheckCast(r9.next(), InetAddress.class, "com.obric.aiagent.plugin"), r1));
        goto L30
    L38:
        return;
    L25:
        this.f39911e.dnsStart(this.f39910d, r3);
        List<InetAddress> r10 = this.f39908b.a().lookup(r3);
        if (r10.isEmpty() == true) goto L34;
        this.f39911e.dnsEnd(this.f39910d, r3, r10);
        r7 = r10;
        goto L28
    L34:
        throw new UnknownHostException(this.f39908b.a() + " returned no addresses for " + r3);
    L36:
        throw new SocketException("No route to " + r3 + ':' + r1 + "; port is out of range");
    L16:
        if (r1 >= 65536) goto L18;
        r4 = true;
        goto L18
    L5:
        if (r8.type() == Proxy.Type.SOCKS) goto L12;
        SocketAddress r2 = r8.address();
        if (ZeusTransformUtils.instanceOf(r2, InetSocketAddress.class) == false) goto L11;
        a r5 = f39907a;
        o.c(r2, "proxyAddress");
        r3 = r5.a((InetSocketAddress) ZeusTransformUtils.preCheckCast(r2, InetSocketAddress.class, "com.obric.aiagent.plugin"));
        r1 = ((InetSocketAddress) ZeusTransformUtils.preCheckCast(r2, InetSocketAddress.class, "com.obric.aiagent.plugin")).getPort();
        goto L13
    L11:
        throw new IllegalArgumentException(("Proxy.address() is not an InetSocketAddress: " + r2.getClass()).toString());
    }
}
