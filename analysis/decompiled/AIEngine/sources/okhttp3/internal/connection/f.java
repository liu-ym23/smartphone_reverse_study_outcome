package okhttp3.internal.connection;

import ad.u;
import androidx.datastore.preferences.protobuf.b1;
import bd.l;
import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import javax.net.ssl.SSLSocketFactory;
import kotlin.collections.builders.ListBuilder;
import kotlin.text.Regex;
import mb.k;
import mb.q;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.f;
import okhttp3.h;
import okhttp3.internal.connection.h;
import okhttp3.internal.connection.i;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f implements h {

    /* renamed from: a, reason: collision with root package name */
    public final dd.e f11069a;

    /* renamed from: b, reason: collision with root package name */
    public final e f11070b;

    /* renamed from: c, reason: collision with root package name */
    public final int f11071c;

    /* renamed from: d, reason: collision with root package name */
    public final int f11072d;

    /* renamed from: e, reason: collision with root package name */
    public final int f11073e;

    /* renamed from: f, reason: collision with root package name */
    public final int f11074f;

    /* renamed from: g, reason: collision with root package name */
    public final int f11075g;
    public final boolean h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f11076i;

    /* renamed from: j, reason: collision with root package name */
    public final okhttp3.a f11077j;

    /* renamed from: k, reason: collision with root package name */
    public final stepos.support.v7.app.palette.b f11078k;

    /* renamed from: l, reason: collision with root package name */
    public final ed.c f11079l;

    /* renamed from: m, reason: collision with root package name */
    public i.a f11080m;

    /* renamed from: n, reason: collision with root package name */
    public i f11081n;

    /* renamed from: o, reason: collision with root package name */
    public u f11082o;

    /* renamed from: p, reason: collision with root package name */
    public final k<h.b> f11083p;

    public f(dd.e taskRunner, e connectionPool, int i10, int i11, int i12, int i13, int i14, boolean z, boolean z3, okhttp3.a address, stepos.support.v7.app.palette.b routeDatabase, ed.c connectionUser) {
        kotlin.jvm.internal.g.f(taskRunner, "taskRunner");
        kotlin.jvm.internal.g.f(connectionPool, "connectionPool");
        kotlin.jvm.internal.g.f(address, "address");
        kotlin.jvm.internal.g.f(routeDatabase, "routeDatabase");
        kotlin.jvm.internal.g.f(connectionUser, "connectionUser");
        this.f11069a = taskRunner;
        this.f11070b = connectionPool;
        this.f11071c = i10;
        this.f11072d = i11;
        this.f11073e = i12;
        this.f11074f = i13;
        this.f11075g = i14;
        this.h = z;
        this.f11076i = z3;
        this.f11077j = address;
        this.f11078k = routeDatabase;
        this.f11079l = connectionUser;
        this.f11083p = new k<>();
    }

    @Override // okhttp3.internal.connection.h
    public final okhttp3.a a() {
        return this.f11077j;
    }

    @Override // okhttp3.internal.connection.h
    public final k<h.b> b() {
        return this.f11083p;
    }

    @Override // okhttp3.internal.connection.h
    public final h.b c() throws IOException {
        Socket socketP;
        boolean z;
        g gVar;
        ed.g gVarS = this.f11079l.s();
        if (gVarS == null) {
            gVar = null;
        } else {
            boolean zH = gVarS.h(this.f11079l.h());
            synchronized (gVarS) {
                try {
                    if (!zH) {
                        z = !gVarS.f8660n;
                        gVarS.f8660n = true;
                        socketP = this.f11079l.p();
                    } else if (gVarS.f8660n || !d(gVarS.f8651d.f176a.h)) {
                        socketP = this.f11079l.p();
                        z = false;
                    } else {
                        z = false;
                        socketP = null;
                    }
                } finally {
                }
            }
            if (this.f11079l.s() == null) {
                if (socketP != null) {
                    l.c(socketP);
                }
                this.f11079l.i(gVarS);
                this.f11079l.g(gVarS);
                if (socketP != null) {
                    this.f11079l.m(gVarS);
                } else if (z) {
                    this.f11079l.v(gVarS);
                }
                gVar = null;
            } else {
                if (socketP != null) {
                    throw new IllegalStateException("Check failed.");
                }
                gVar = new g(gVarS);
            }
        }
        if (gVar != null) {
            return gVar;
        }
        g gVarH = h(null, null);
        if (gVarH != null) {
            return gVarH;
        }
        if (!this.f11083p.isEmpty()) {
            return this.f11083p.removeFirst();
        }
        ConnectPlan connectPlanF = f();
        g gVarH2 = h(connectPlanF, connectPlanF.f11013l);
        return gVarH2 != null ? gVarH2 : connectPlanF;
    }

    @Override // okhttp3.internal.connection.h
    public final boolean d(okhttp3.g url) {
        kotlin.jvm.internal.g.f(url, "url");
        okhttp3.g gVar = this.f11077j.h;
        return url.f10981e == gVar.f10981e && kotlin.jvm.internal.g.b(url.f10980d, gVar.f10980d);
    }

    @Override // okhttp3.internal.connection.h
    public final boolean e(ed.g gVar) {
        i iVar;
        u uVar;
        if (this.f11083p.isEmpty() && this.f11082o == null) {
            if (gVar != null) {
                synchronized (gVar) {
                    uVar = null;
                    if (gVar.f8662p == 0 && gVar.f8660n && l.a(gVar.f8651d.f176a.h, this.f11077j.h)) {
                        uVar = gVar.f8651d;
                    }
                }
                if (uVar != null) {
                    this.f11082o = uVar;
                    return true;
                }
            }
            i.a aVar = this.f11080m;
            if ((aVar == null || aVar.f11096b >= aVar.f11095a.size()) && (iVar = this.f11081n) != null) {
                return iVar.a();
            }
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r2v25, types: [java.lang.Object, java.util.List] */
    public final ConnectPlan f() throws IOException {
        String hostname;
        int port;
        List<? extends InetAddress> listI;
        boolean zContains;
        u uVar = this.f11082o;
        if (uVar != null) {
            this.f11082o = null;
            return g(uVar, null);
        }
        i.a aVar = this.f11080m;
        if (aVar != null && aVar.f11096b < aVar.f11095a.size()) {
            int i10 = aVar.f11096b;
            ArrayList arrayList = aVar.f11095a;
            if (i10 >= arrayList.size()) {
                throw new NoSuchElementException();
            }
            int i11 = aVar.f11096b;
            aVar.f11096b = i11 + 1;
            return g((u) arrayList.get(i11), null);
        }
        i iVar = this.f11081n;
        if (iVar == null) {
            iVar = new i(this.f11077j, this.f11078k, this.f11079l, this.f11076i);
            this.f11081n = iVar;
        }
        if (!iVar.a()) {
            throw new IOException("exhausted all routes");
        }
        if (!iVar.a()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList2 = new ArrayList();
        while (iVar.f11093f < iVar.f11092e.size()) {
            okhttp3.a aVar2 = iVar.f11088a;
            if (iVar.f11093f >= iVar.f11092e.size()) {
                throw new SocketException("No route to " + aVar2.h.f10980d + "; exhausted proxy configurations: " + iVar.f11092e);
            }
            List<? extends Proxy> list = iVar.f11092e;
            int i12 = iVar.f11093f;
            iVar.f11093f = i12 + 1;
            Proxy proxy = list.get(i12);
            ed.c cVar = iVar.f11090c;
            ArrayList arrayList3 = new ArrayList();
            iVar.f11094g = arrayList3;
            if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
                okhttp3.g gVar = aVar2.h;
                hostname = gVar.f10980d;
                port = gVar.f10981e;
            } else {
                SocketAddress socketAddressAddress = proxy.address();
                if (!(socketAddressAddress instanceof InetSocketAddress)) {
                    throw new IllegalArgumentException(("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass()).toString());
                }
                InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
                InetAddress address = inetSocketAddress.getAddress();
                if (address == null) {
                    hostname = inetSocketAddress.getHostName();
                    kotlin.jvm.internal.g.e(hostname, "getHostName(...)");
                } else {
                    hostname = address.getHostAddress();
                    kotlin.jvm.internal.g.e(hostname, "getHostAddress(...)");
                }
                port = inetSocketAddress.getPort();
            }
            if (1 > port || port >= 65536) {
                throw new SocketException("No route to " + hostname + ':' + port + "; port is out of range");
            }
            if (proxy.type() == Proxy.Type.SOCKS) {
                arrayList3.add(InetSocketAddress.createUnresolved(hostname, port));
            } else {
                Regex regex = bd.c.f3218a;
                kotlin.jvm.internal.g.f(hostname, "<this>");
                if (bd.c.f3218a.c(hostname)) {
                    listI = b1.P(InetAddress.getByName(hostname));
                } else {
                    cVar.k(hostname);
                    aVar2.f10923a.getClass();
                    kotlin.jvm.internal.g.f(hostname, "hostname");
                    try {
                        InetAddress[] allByName = InetAddress.getAllByName(hostname);
                        kotlin.jvm.internal.g.e(allByName, "getAllByName(...)");
                        List<? extends InetAddress> listQ0 = mb.l.q0(allByName);
                        if (listQ0.isEmpty()) {
                            throw new UnknownHostException(aVar2.f10923a + " returned no addresses for " + hostname);
                        }
                        cVar.c(hostname, listQ0);
                        listI = listQ0;
                    } catch (NullPointerException e10) {
                        UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of ".concat(hostname));
                        unknownHostException.initCause(e10);
                        throw unknownHostException;
                    }
                }
                if (iVar.f11091d && listI.size() >= 2) {
                    ArrayList arrayList4 = new ArrayList();
                    ArrayList arrayList5 = new ArrayList();
                    for (Object obj : listI) {
                        if (((InetAddress) obj) instanceof Inet6Address) {
                            arrayList4.add(obj);
                        } else {
                            arrayList5.add(obj);
                        }
                    }
                    if (!arrayList4.isEmpty() && !arrayList5.isEmpty()) {
                        byte[] bArr = bd.i.f3230a;
                        Iterator it = arrayList4.iterator();
                        Iterator it2 = arrayList5.iterator();
                        ListBuilder listBuilderY = b1.y();
                        while (true) {
                            if (!it.hasNext() && !it2.hasNext()) {
                                break;
                            }
                            if (it.hasNext()) {
                                listBuilderY.add(it.next());
                            }
                            if (it2.hasNext()) {
                                listBuilderY.add(it2.next());
                            }
                        }
                        listI = b1.i(listBuilderY);
                    }
                }
                Iterator<? extends InetAddress> it3 = listI.iterator();
                while (it3.hasNext()) {
                    arrayList3.add(new InetSocketAddress(it3.next(), port));
                }
            }
            Iterator it4 = iVar.f11094g.iterator();
            while (it4.hasNext()) {
                u uVar2 = new u(iVar.f11088a, proxy, (InetSocketAddress) it4.next());
                stepos.support.v7.app.palette.b bVar = iVar.f11089b;
                synchronized (bVar) {
                    zContains = ((LinkedHashSet) bVar.h).contains(uVar2);
                }
                if (zContains) {
                    iVar.h.add(uVar2);
                } else {
                    arrayList2.add(uVar2);
                }
            }
            if (!arrayList2.isEmpty()) {
                break;
            }
        }
        if (arrayList2.isEmpty()) {
            q.g0(arrayList2, iVar.h);
            iVar.h.clear();
        }
        i.a aVar3 = new i.a(arrayList2);
        this.f11080m = aVar3;
        if (this.f11079l.isCanceled()) {
            throw new IOException("Canceled");
        }
        if (aVar3.f11096b >= arrayList2.size()) {
            throw new NoSuchElementException();
        }
        int i13 = aVar3.f11096b;
        aVar3.f11096b = i13 + 1;
        return g((u) arrayList2.get(i13), arrayList2);
    }

    public final ConnectPlan g(u route, ArrayList arrayList) throws UnknownServiceException {
        kotlin.jvm.internal.g.f(route, "route");
        okhttp3.a aVar = route.f176a;
        SSLSocketFactory sSLSocketFactory = aVar.f10925c;
        List<Protocol> list = aVar.f10930i;
        okhttp3.g url = aVar.h;
        if (sSLSocketFactory == null) {
            if (!aVar.f10931j.contains(okhttp3.e.h)) {
                throw new UnknownServiceException("CLEARTEXT communication not enabled for client");
            }
            String str = url.f10980d;
            kd.h.Companion.getClass();
            if (!kd.h.platform.isCleartextTrafficPermitted(str)) {
                throw new UnknownServiceException(a0.a.k("CLEARTEXT communication to ", str, " not permitted by network security policy"));
            }
        } else if (list.contains(Protocol.f10883j)) {
            throw new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS");
        }
        okhttp3.h hVar = null;
        if (route.f177b.type() == Proxy.Type.HTTP && (aVar.f10925c != null || list.contains(Protocol.f10883j))) {
            h.a aVar2 = new h.a();
            kotlin.jvm.internal.g.f(url, "url");
            aVar2.f10998a = url;
            aVar2.c("CONNECT", null);
            aVar2.b("Host", l.k(url, true));
            aVar2.b("Proxy-Connection", "Keep-Alive");
            aVar2.b("User-Agent", "okhttp/5.0.0-alpha.14");
            hVar = new okhttp3.h(aVar2);
            Response.Builder builder = new Response.Builder();
            builder.f10901a = hVar;
            builder.f10902b = Protocol.f10881d;
            builder.f10903c = 407;
            builder.f10904d = "Preemptive Authenticate";
            builder.f10910k = -1L;
            builder.f10911l = -1L;
            f.a aVar3 = builder.f10906f;
            aVar3.getClass();
            bd.b.b("Proxy-Authenticate");
            bd.b.c("OkHttp-Preemptive", "Proxy-Authenticate");
            aVar3.c("Proxy-Authenticate");
            bd.b.a(aVar3, "Proxy-Authenticate", "OkHttp-Preemptive");
            aVar.f10928f.a(route, builder.a());
        }
        return new ConnectPlan(this.f11069a, this.f11070b, this.f11071c, this.f11072d, this.f11073e, this.f11074f, this.f11075g, this.h, this.f11079l, this, route, arrayList, 0, hVar, -1, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004c A[Catch: all -> 0x004a, TryCatch #0 {all -> 0x004a, blocks: (B:14:0x003f, B:22:0x004c, B:25:0x0053), top: B:51:0x003f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final okhttp3.internal.connection.g h(okhttp3.internal.connection.ConnectPlan r11, java.util.List<ad.u> r12) {
        /*
            r10 = this;
            okhttp3.internal.connection.e r0 = r10.f11070b
            ed.c r1 = r10.f11079l
            boolean r1 = r1.h()
            okhttp3.a r2 = r10.f11077j
            ed.c r3 = r10.f11079l
            r4 = 0
            r5 = 1
            if (r11 == 0) goto L18
            boolean r6 = r11.isReady()
            if (r6 == 0) goto L18
            r6 = r5
            goto L19
        L18:
            r6 = r4
        L19:
            r0.getClass()
            java.lang.String r7 = "address"
            kotlin.jvm.internal.g.f(r2, r7)
            java.lang.String r7 = "connectionUser"
            kotlin.jvm.internal.g.f(r3, r7)
            java.util.concurrent.ConcurrentLinkedQueue<ed.g> r0 = r0.h
            java.util.Iterator r0 = r0.iterator()
        L2c:
            boolean r7 = r0.hasNext()
            r8 = 0
            if (r7 == 0) goto L74
            java.lang.Object r7 = r0.next()
            ed.g r7 = (ed.g) r7
            kotlin.jvm.internal.g.c(r7)
            monitor-enter(r7)
            if (r6 == 0) goto L4c
            okhttp3.internal.http2.Http2Connection r9 = r7.f8659m     // Catch: java.lang.Throwable -> L4a
            if (r9 == 0) goto L45
            r9 = r5
            goto L46
        L45:
            r9 = r4
        L46:
            if (r9 != 0) goto L4c
        L48:
            r9 = r4
            goto L57
        L4a:
            r10 = move-exception
            goto L72
        L4c:
            boolean r9 = r7.g(r2, r12)     // Catch: java.lang.Throwable -> L4a
            if (r9 != 0) goto L53
            goto L48
        L53:
            r3.u(r7)     // Catch: java.lang.Throwable -> L4a
            r9 = r5
        L57:
            monitor-exit(r7)
            if (r9 == 0) goto L2c
            boolean r9 = r7.h(r1)
            if (r9 == 0) goto L61
            goto L75
        L61:
            monitor-enter(r7)
            r7.f8660n = r5     // Catch: java.lang.Throwable -> L6f
            java.net.Socket r8 = r3.p()     // Catch: java.lang.Throwable -> L6f
            monitor-exit(r7)
            if (r8 == 0) goto L2c
            bd.l.c(r8)
            goto L2c
        L6f:
            r10 = move-exception
            monitor-exit(r7)
            throw r10
        L72:
            monitor-exit(r7)
            throw r10
        L74:
            r7 = r8
        L75:
            if (r7 != 0) goto L78
            return r8
        L78:
            if (r11 == 0) goto L85
            ad.u r12 = r11.f11012k
            r10.f11082o = r12
            java.net.Socket r11 = r11.f11019s
            if (r11 == 0) goto L85
            bd.l.c(r11)
        L85:
            ed.c r11 = r10.f11079l
            r11.f(r7)
            ed.c r10 = r10.f11079l
            r10.r(r7)
            okhttp3.internal.connection.g r10 = new okhttp3.internal.connection.g
            r10.<init>(r7)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.f.h(okhttp3.internal.connection.ConnectPlan, java.util.List):okhttp3.internal.connection.g");
    }

    @Override // okhttp3.internal.connection.h
    public final boolean isCanceled() {
        return this.f11079l.isCanceled();
    }
}
