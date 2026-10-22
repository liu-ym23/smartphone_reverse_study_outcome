package yb;

import Z8.A;
import Z8.C1172u;
import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import tb.C5532E;
import tb.C5534a;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 .2\u00020\u0001:\u0002\u0018\fB)\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\bH\u0086\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eH\u0086\u0002¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0018\u0010\rJ\u000f\u0010\u0019\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u001dR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u001eR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u001fR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010 R\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00130!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\"R\u0016\u0010&\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010%R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020'0!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010\"R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020+0*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010\"¨\u0006/"}, d2 = {"Lyb/u;", "", "Ltb/a;", Const.JSON_KEY_ADDRESS, "Lyb/s;", "routeDatabase", "Lyb/m;", "call", "", "fastFallback", "<init>", "(Ltb/a;Lyb/s;Lyb/m;Z)V", Const.INTENT_KEY_APIKEY, "()Z", "Lyb/u$b;", "c", "()Lyb/u$b;", "Ltb/v;", "url", "Ljava/net/Proxy;", "proxy", "LY8/t;", "f", "(Ltb/v;Ljava/net/Proxy;)V", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_UMID, "()Ljava/net/Proxy;", "e", "(Ljava/net/Proxy;)V", "Ltb/a;", "Lyb/s;", "Lyb/m;", "Z", "", "Ljava/util/List;", "proxies", "", "I", "nextProxyIndex", "Ljava/net/InetSocketAddress;", Const.INTENT_KEY_BACKGROUND_COMMAND, "inetSocketAddresses", "", "Ltb/E;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "postponedRoutes", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: yb.u, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6040u {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final C5534a address;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final C6038s routeDatabase;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final C6032m call;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final boolean fastFallback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public List<? extends Proxy> proxies;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public int nextProxyIndex;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public List<? extends InetSocketAddress> inetSocketAddresses;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final List<C5532E> postponedRoutes;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0015\u0010\b\u001a\u00020\u0005*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lyb/u$a;", "", "<init>", "()V", "Ljava/net/InetSocketAddress;", "", Const.INTENT_KEY_APIKEY, "(Ljava/net/InetSocketAddress;)Ljava/lang/String;", "socketHost", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: yb.u$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final String a(InetSocketAddress inetSocketAddress) {
            kotlin.jvm.internal.p.i(inetSocketAddress, "<this>");
            InetAddress address = inetSocketAddress.getAddress();
            if (address == null) {
                String hostName = inetSocketAddress.getHostName();
                kotlin.jvm.internal.p.h(hostName, "getHostName(...)");
                return hostName;
            }
            String hostAddress = address.getHostAddress();
            kotlin.jvm.internal.p.h(hostAddress, "getHostAddress(...)");
            return hostAddress;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007H\u0086\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0003H\u0086\u0002¢\u0006\u0004\b\n\u0010\u000bR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0010¨\u0006\u0012"}, d2 = {"Lyb/u$b;", "", "", "Ltb/E;", "routes", "<init>", "(Ljava/util/List;)V", "", Const.INTENT_KEY_PKGNAME, "()Z", "c", "()Ltb/E;", Const.INTENT_KEY_APIKEY, "Ljava/util/List;", "()Ljava/util/List;", "", "I", "nextRouteIndex", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: yb.u$b */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final List<C5532E> routes;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public int nextRouteIndex;

        public b(List<C5532E> routes) {
            kotlin.jvm.internal.p.i(routes, "routes");
            this.routes = routes;
        }

        public final List<C5532E> a() {
            return this.routes;
        }

        public final boolean b() {
            return this.nextRouteIndex < this.routes.size();
        }

        public final C5532E c() {
            if (!b()) {
                throw new NoSuchElementException();
            }
            List<C5532E> list = this.routes;
            int i10 = this.nextRouteIndex;
            this.nextRouteIndex = i10 + 1;
            return list.get(i10);
        }
    }

    public C6040u(C5534a address, C6038s routeDatabase, C6032m call, boolean z10) {
        kotlin.jvm.internal.p.i(address, "address");
        kotlin.jvm.internal.p.i(routeDatabase, "routeDatabase");
        kotlin.jvm.internal.p.i(call, "call");
        this.address = address;
        this.routeDatabase = routeDatabase;
        this.call = call;
        this.fastFallback = z10;
        this.proxies = C1173v.m();
        this.inetSocketAddresses = C1173v.m();
        this.postponedRoutes = new ArrayList();
        f(address.getUrl(), address.getProxy());
    }

    public static final List<Proxy> g(Proxy proxy, tb.v vVar, C6040u c6040u) {
        if (proxy != null) {
            return C1172u.e(proxy);
        }
        URI uriU = vVar.u();
        if (uriU.getHost() == null) {
            return ub.q.l(Proxy.NO_PROXY);
        }
        List<Proxy> listSelect = c6040u.address.getProxySelector().select(uriU);
        List<Proxy> list = listSelect;
        return (list == null || list.isEmpty()) ? ub.q.l(Proxy.NO_PROXY) : ub.q.w(listSelect);
    }

    public final boolean a() {
        return b() || !this.postponedRoutes.isEmpty();
    }

    public final boolean b() {
        return this.nextProxyIndex < this.proxies.size();
    }

    public final b c() throws IOException {
        if (!a()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (b()) {
            Proxy proxyD = d();
            Iterator<? extends InetSocketAddress> it = this.inetSocketAddresses.iterator();
            while (it.hasNext()) {
                C5532E c5532e = new C5532E(this.address, proxyD, it.next());
                if (this.routeDatabase.c(c5532e)) {
                    this.postponedRoutes.add(c5532e);
                } else {
                    arrayList.add(c5532e);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            A.E(arrayList, this.postponedRoutes);
            this.postponedRoutes.clear();
        }
        return new b(arrayList);
    }

    public final Proxy d() throws IOException {
        if (b()) {
            List<? extends Proxy> list = this.proxies;
            int i10 = this.nextProxyIndex;
            this.nextProxyIndex = i10 + 1;
            Proxy proxy = list.get(i10);
            e(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.address.getUrl().getHost() + "; exhausted proxy configurations: " + this.proxies);
    }

    public final void e(Proxy proxy) throws IOException {
        String host;
        int port;
        List<InetAddress> listA;
        ArrayList arrayList = new ArrayList();
        this.inetSocketAddresses = arrayList;
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            host = this.address.getUrl().getHost();
            port = this.address.getUrl().getPort();
        } else {
            SocketAddress socketAddressAddress = proxy.address();
            if (!(socketAddressAddress instanceof InetSocketAddress)) {
                throw new IllegalArgumentException(("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass()).toString());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
            host = INSTANCE.a(inetSocketAddress);
            port = inetSocketAddress.getPort();
        }
        if (1 > port || port >= 65536) {
            throw new SocketException("No route to " + host + ':' + port + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            arrayList.add(InetSocketAddress.createUnresolved(host, port));
            return;
        }
        if (ub.l.a(host)) {
            listA = C1172u.e(InetAddress.getByName(host));
        } else {
            this.call.getEventListener().o(this.call, host);
            listA = this.address.getDns().a(host);
            if (listA.isEmpty()) {
                throw new UnknownHostException(this.address.getDns() + " returned no addresses for " + host);
            }
            this.call.getEventListener().n(this.call, host, listA);
        }
        if (this.fastFallback) {
            listA = C6031l.a(listA);
        }
        Iterator<InetAddress> it = listA.iterator();
        while (it.hasNext()) {
            arrayList.add(new InetSocketAddress(it.next(), port));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f(tb.v url, Proxy proxy) {
        this.call.getEventListener().r(this.call, url);
        this.proxies = g(proxy, url, this);
        this.nextProxyIndex = 0;
        this.call.getEventListener().q(this.call, url, this.proxies);
    }
}
