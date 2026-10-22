package okhttp3.internal.connection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Route;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes4.dex */
public final class RouteSelector {
    private final Address address;
    private final Call call;
    private final EventListener eventListener;
    private List<InetSocketAddress> inetSocketAddresses;
    private int nextProxyIndex;
    private final List<Route> postponedRoutes;
    private List<Proxy> proxies;
    private final RouteDatabase routeDatabase;

    public static final class Selection {
        private int nextRouteIndex;
        private final List<Route> routes;

        public Selection(List<Route> r10) {
            this.nextRouteIndex = 0;
            this.routes = r10;
        }

        public List<Route> getAll() {
            return new ArrayList(this.routes);
        }

        public boolean hasNext() {
            if (this.nextRouteIndex >= this.routes.size()) goto L5;
            return true;
        L5:
            return false;
        }

        public Route next() {
            if (hasNext() == false) goto L7;
            List<Route> r10 = this.routes;
            int r11 = this.nextRouteIndex;
            this.nextRouteIndex = r11 + 1;
            return r10.get(r11);
        L7:
            throw new NoSuchElementException();
        }
    }

    public RouteSelector(Address r10, RouteDatabase r11, Call r12, EventListener r13) {
        this.proxies = Collections.emptyList();
        this.inetSocketAddresses = Collections.emptyList();
        this.postponedRoutes = new ArrayList();
        this.address = r10;
        this.routeDatabase = r11;
        this.call = r12;
        this.eventListener = r13;
        resetNextProxy(r10.l(), r10.g());
    }

    public static String getHostString(InetSocketAddress r10) {
        InetAddress r11 = r10.getAddress();
        if (r11 != null) goto L7;
        return r10.getHostName();
    L7:
        return r11.getHostAddress();
    }

    private boolean hasNextProxy() {
        if (this.nextProxyIndex >= this.proxies.size()) goto L5;
        return true;
    L5:
        return false;
    }

    private Proxy nextProxy() throws IOException {
        if (hasNextProxy() == false) goto L7;
        List<Proxy> r10 = this.proxies;
        int r11 = this.nextProxyIndex;
        this.nextProxyIndex = r11 + 1;
        Proxy r12 = r10.get(r11);
        resetNextInetSocketAddress(r12);
        return r12;
    L7:
        throw new SocketException("No route to " + this.address.l().m() + "; exhausted proxy configurations: " + this.proxies);
    }

    private void resetNextInetSocketAddress(Proxy r10) throws IOException {
        this.inetSocketAddresses = new ArrayList();
        if (r10.type() != Proxy.Type.DIRECT) goto L5;
    L12:
        String r11 = this.address.l().m();
        int r12 = this.address.l().z();
    L14:
        if (r12 < 1) goto L29;
        if (r12 > 65535) goto L29;
        if (r10.type() != Proxy.Type.SOCKS) goto L20;
        this.inetSocketAddresses.add(InetSocketAddress.createUnresolved(r11, r12));
        return;
    L20:
        this.eventListener.dnsStart(this.call, r11);
        List<InetAddress> r13 = this.address.c().lookup(r11);
        if (r13.isEmpty() == true) goto L27;
        this.eventListener.dnsEnd(this.call, r11, r13);
        int r14 = r13.size();
        int r15 = 0;
    L23:
        if (r15 >= r14) goto L31;
        this.inetSocketAddresses.add(new InetSocketAddress(r13.get(r15), r12));
        r15 = r15 + 1;
        goto L23
    L31:
        return;
    L27:
        throw new UnknownHostException(this.address.c() + " returned no addresses for " + r11);
    L29:
        throw new SocketException("No route to " + r11 + ":" + r12 + "; port is out of range");
    L5:
        if (r10.type() == Proxy.Type.SOCKS) goto L12;
        SocketAddress r16 = r10.address();
        if ((r16 instanceof InetSocketAddress) == false) goto L11;
        InetSocketAddress r17 = (InetSocketAddress) r16;
        r11 = getHostString(r17);
        r12 = r17.getPort();
        goto L14
    L11:
        throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + r16.getClass());
    }

    private void resetNextProxy(HttpUrl r10, Proxy r11) {
        if (r11 == null) goto L4;
        this.proxies = Collections.singletonList(r11);
    L11:
        this.nextProxyIndex = 0;
        return;
    L4:
        List<Proxy> r12 = this.address.i().select(r10.H());
        if (r12 != null) goto L7;
    L9:
        List<Proxy> r13 = Util.immutableList(new Proxy[]{Proxy.NO_PROXY});
    L10:
        this.proxies = r13;
        goto L11
    L7:
        if (r12.isEmpty() == true) goto L9;
        r13 = Util.immutableList(r12);
        goto L10
    }

    public void connectFailed(Route r10, IOException r11) {
        if (r10.b().type() != Proxy.Type.DIRECT) goto L5;
    L7:
        this.routeDatabase.failed(r10);
        return;
    L5:
        if (this.address.i() == null) goto L7;
        this.address.i().connectFailed(this.address.l().H(), r10.b().address(), r11);
        goto L7
    }

    public boolean hasNext() {
        if (hasNextProxy() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.postponedRoutes.isEmpty() == false) goto L8;
        return false;
    }

    public Selection next() throws IOException {
        if (hasNext() == false) goto L22;
        ArrayList r10 = new ArrayList();
    L6:
        if (hasNextProxy() == false) goto L17;
        Proxy r11 = nextProxy();
        int r12 = this.inetSocketAddresses.size();
        int r13 = 0;
    L8:
        if (r13 >= r12) goto L15;
        Route r14 = new Route(this.address, r11, this.inetSocketAddresses.get(r13));
        if (this.routeDatabase.shouldPostpone(r14) == false) goto L12;
        this.postponedRoutes.add(r14);
    L13:
        r13 = r13 + 1;
        goto L8
    L12:
        r10.add(r14);
        goto L13
    L15:
        if (r10.isEmpty() == true) goto L6;
    L17:
        if (r10.isEmpty() == false) goto L20;
        r10.addAll(this.postponedRoutes);
        this.postponedRoutes.clear();
    L20:
        return new Selection(r10);
    L22:
        throw new NoSuchElementException();
    }
}
