package F4;

import C4.C0271a;
import C4.H;
import C4.InterfaceC0275e;
import C4.s;
import C4.w;
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

/* loaded from: classes.dex */
final class j {

    /* renamed from: a, reason: collision with root package name */
    private final C0271a f1813a;

    /* renamed from: b, reason: collision with root package name */
    private final h f1814b;

    /* renamed from: c, reason: collision with root package name */
    private final InterfaceC0275e f1815c;

    /* renamed from: d, reason: collision with root package name */
    private final s f1816d;

    /* renamed from: e, reason: collision with root package name */
    private List<Proxy> f1817e;

    /* renamed from: f, reason: collision with root package name */
    private int f1818f;

    /* renamed from: g, reason: collision with root package name */
    private List<InetSocketAddress> f1819g;

    /* renamed from: h, reason: collision with root package name */
    private final List<H> f1820h;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final List<H> f1821a;

        /* renamed from: b, reason: collision with root package name */
        private int f1822b = 0;

        a(List<H> list) {
            this.f1821a = list;
        }

        public List<H> a() {
            return new ArrayList(this.f1821a);
        }

        public boolean b() {
            return this.f1822b < this.f1821a.size();
        }

        public H c() {
            if (!b()) {
                throw new NoSuchElementException();
            }
            List<H> list = this.f1821a;
            int i5 = this.f1822b;
            this.f1822b = i5 + 1;
            return list.get(i5);
        }
    }

    j(C0271a c0271a, h hVar, InterfaceC0275e interfaceC0275e, s sVar) {
        List list = Collections.EMPTY_LIST;
        this.f1817e = list;
        this.f1819g = list;
        this.f1820h = new ArrayList();
        this.f1813a = c0271a;
        this.f1814b = hVar;
        this.f1815c = interfaceC0275e;
        this.f1816d = sVar;
        g(c0271a.l(), c0271a.g());
    }

    static String a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        return address == null ? inetSocketAddress.getHostName() : address.getHostAddress();
    }

    private boolean c() {
        return this.f1818f < this.f1817e.size();
    }

    private Proxy e() throws SocketException, UnknownHostException {
        if (c()) {
            List<Proxy> list = this.f1817e;
            int i5 = this.f1818f;
            this.f1818f = i5 + 1;
            Proxy proxy = list.get(i5);
            f(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f1813a.l().m() + "; exhausted proxy configurations: " + this.f1817e);
    }

    private void f(Proxy proxy) throws SocketException, UnknownHostException {
        String strM;
        int iY;
        this.f1819g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            strM = this.f1813a.l().m();
            iY = this.f1813a.l().y();
        } else {
            SocketAddress socketAddressAddress = proxy.address();
            if (!(socketAddressAddress instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
            strM = a(inetSocketAddress);
            iY = inetSocketAddress.getPort();
        }
        if (iY < 1 || iY > 65535) {
            throw new SocketException("No route to " + strM + ":" + iY + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            this.f1819g.add(InetSocketAddress.createUnresolved(strM, iY));
            return;
        }
        this.f1816d.k(this.f1815c, strM);
        List<InetAddress> listA = this.f1813a.c().a(strM);
        if (listA.isEmpty()) {
            throw new UnknownHostException(this.f1813a.c() + " returned no addresses for " + strM);
        }
        this.f1816d.j(this.f1815c, strM, listA);
        int size = listA.size();
        for (int i5 = 0; i5 < size; i5++) {
            this.f1819g.add(new InetSocketAddress(listA.get(i5), iY));
        }
    }

    private void g(w wVar, Proxy proxy) {
        if (proxy != null) {
            this.f1817e = Collections.singletonList(proxy);
        } else {
            List<Proxy> listSelect = this.f1813a.i().select(wVar.E());
            this.f1817e = (listSelect == null || listSelect.isEmpty()) ? D4.e.u(Proxy.NO_PROXY) : D4.e.t(listSelect);
        }
        this.f1818f = 0;
    }

    public boolean b() {
        return c() || !this.f1820h.isEmpty();
    }

    public a d() throws SocketException, UnknownHostException {
        if (!b()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (c()) {
            Proxy proxyE = e();
            int size = this.f1819g.size();
            for (int i5 = 0; i5 < size; i5++) {
                H h5 = new H(this.f1813a, proxyE, this.f1819g.get(i5));
                if (this.f1814b.c(h5)) {
                    this.f1820h.add(h5);
                } else {
                    arrayList.add(h5);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(this.f1820h);
            this.f1820h.clear();
        }
        return new a(arrayList);
    }
}
