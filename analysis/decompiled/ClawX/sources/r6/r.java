package r6;

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
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.internal.platform.Platform;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class r implements v {

    /* renamed from: a, reason: collision with root package name */
    public final q6.d f5193a;

    /* renamed from: b, reason: collision with root package name */
    public final q f5194b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5195c;
    public final int d;

    /* renamed from: e, reason: collision with root package name */
    public final int f5196e;

    /* renamed from: f, reason: collision with root package name */
    public final int f5197f;

    /* renamed from: g, reason: collision with root package name */
    public final int f5198g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f5199h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f5200i;

    /* renamed from: j, reason: collision with root package name */
    public final n6.a f5201j;

    /* renamed from: k, reason: collision with root package name */
    public final androidx.emoji2.text.m f5202k;

    /* renamed from: l, reason: collision with root package name */
    public final o f5203l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f5204m;

    /* renamed from: n, reason: collision with root package name */
    public b0.j f5205n;

    /* renamed from: o, reason: collision with root package name */
    public w f5206o;

    /* renamed from: p, reason: collision with root package name */
    public n6.x f5207p;

    /* renamed from: q, reason: collision with root package name */
    public final c5.j f5208q;

    public r(q6.d taskRunner, q connectionPool, int i8, int i9, int i10, int i11, int i12, boolean z, boolean z2, n6.a aVar, androidx.emoji2.text.m routeDatabase, o oVar, n6.s sVar) {
        kotlin.jvm.internal.p.e(taskRunner, "taskRunner");
        kotlin.jvm.internal.p.e(connectionPool, "connectionPool");
        kotlin.jvm.internal.p.e(routeDatabase, "routeDatabase");
        this.f5193a = taskRunner;
        this.f5194b = connectionPool;
        this.f5195c = i8;
        this.d = i9;
        this.f5196e = i10;
        this.f5197f = i11;
        this.f5198g = i12;
        this.f5199h = z;
        this.f5200i = z2;
        this.f5201j = aVar;
        this.f5202k = routeDatabase;
        this.f5203l = oVar;
        this.f5204m = !kotlin.jvm.internal.p.a(sVar.f4129b, "GET");
        this.f5208q = new c5.j();
    }

    public final boolean a(p pVar) {
        w wVar;
        n6.x xVar;
        if (this.f5208q.isEmpty() && this.f5207p == null) {
            if (pVar != null) {
                synchronized (pVar) {
                    xVar = null;
                    if (pVar.f5184m == 0 && pVar.f5182k && o6.f.a(pVar.f5175c.f4163a.f3992h, this.f5201j.f3992h)) {
                        xVar = pVar.f5175c;
                    }
                }
                if (xVar != null) {
                    this.f5207p = xVar;
                    return true;
                }
            }
            b0.j jVar = this.f5205n;
            if ((jVar == null || jVar.f832a >= ((ArrayList) jVar.f833b).size()) && (wVar = this.f5206o) != null) {
                return wVar.a();
            }
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r3v33, types: [java.lang.Object, java.util.List] */
    public final u b() throws IOException {
        Socket socketI;
        s sVar;
        c cVarC;
        String hostAddress;
        int port;
        List listE;
        boolean zContains;
        p pVar = this.f5203l.f5163h;
        if (pVar == null) {
            sVar = null;
        } else {
            boolean zH = pVar.h(this.f5204m);
            synchronized (pVar) {
                try {
                    if (zH) {
                        socketI = (pVar.f5182k || !e(pVar.f5175c.f4163a.f3992h)) ? this.f5203l.i() : null;
                    } else {
                        pVar.f5182k = true;
                        socketI = this.f5203l.i();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.f5203l.f5163h == null) {
                if (socketI != null) {
                    o6.f.c(socketI);
                }
                sVar = null;
            } else {
                if (socketI != null) {
                    throw new IllegalStateException("Check failed.");
                }
                sVar = new s(pVar);
            }
        }
        if (sVar != null) {
            return sVar;
        }
        s sVarD = d(null, null);
        if (sVarD != null) {
            return sVarD;
        }
        if (!this.f5208q.isEmpty()) {
            return (u) this.f5208q.removeFirst();
        }
        n6.x xVar = this.f5207p;
        if (xVar != null) {
            this.f5207p = null;
            cVarC = c(xVar, null);
        } else {
            b0.j jVar = this.f5205n;
            if (jVar == null || jVar.f832a >= ((ArrayList) jVar.f833b).size()) {
                w wVar = this.f5206o;
                if (wVar == null) {
                    wVar = new w(this.f5201j, this.f5202k, this.f5203l, this.f5200i);
                    this.f5206o = wVar;
                }
                if (!wVar.a()) {
                    throw new IOException("exhausted all routes");
                }
                if (!wVar.a()) {
                    throw new NoSuchElementException();
                }
                ArrayList arrayList = new ArrayList();
                while (wVar.f5216e < wVar.d.size()) {
                    n6.a aVar = wVar.f5213a;
                    if (wVar.f5216e >= wVar.d.size()) {
                        throw new SocketException("No route to " + aVar.f3992h.d + "; exhausted proxy configurations: " + wVar.d);
                    }
                    List list = wVar.d;
                    int i8 = wVar.f5216e;
                    wVar.f5216e = i8 + 1;
                    Proxy proxy = (Proxy) list.get(i8);
                    ArrayList arrayList2 = new ArrayList();
                    wVar.f5217f = arrayList2;
                    if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
                        n6.m mVar = aVar.f3992h;
                        hostAddress = mVar.d;
                        port = mVar.f4066e;
                    } else {
                        SocketAddress socketAddressAddress = proxy.address();
                        if (!(socketAddressAddress instanceof InetSocketAddress)) {
                            throw new IllegalArgumentException(("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass()).toString());
                        }
                        InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
                        InetAddress address = inetSocketAddress.getAddress();
                        if (address == null) {
                            hostAddress = inetSocketAddress.getHostName();
                            kotlin.jvm.internal.p.d(hostAddress, "getHostName(...)");
                        } else {
                            hostAddress = address.getHostAddress();
                            kotlin.jvm.internal.p.d(hostAddress, "getHostAddress(...)");
                        }
                        port = inetSocketAddress.getPort();
                    }
                    if (1 > port || port >= 65536) {
                        throw new SocketException("No route to " + hostAddress + AbstractJsonLexerKt.COLON + port + "; port is out of range");
                    }
                    if (proxy.type() == Proxy.Type.SOCKS) {
                        arrayList2.add(InetSocketAddress.createUnresolved(hostAddress, port));
                    } else {
                        x5.l lVar = o6.c.f4326a;
                        kotlin.jvm.internal.p.e(hostAddress, "<this>");
                        if (o6.c.f4326a.e(hostAddress)) {
                            listE = a.a.S(InetAddress.getByName(hostAddress));
                        } else {
                            aVar.f3986a.getClass();
                            try {
                                InetAddress[] allByName = InetAddress.getAllByName(hostAddress);
                                kotlin.jvm.internal.p.d(allByName, "getAllByName(...)");
                                List listJ0 = c5.l.j0(allByName);
                                if (listJ0.isEmpty()) {
                                    throw new UnknownHostException(aVar.f3986a + " returned no addresses for " + hostAddress);
                                }
                                listE = listJ0;
                            } catch (NullPointerException e9) {
                                UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of ".concat(hostAddress));
                                unknownHostException.initCause(e9);
                                throw unknownHostException;
                            }
                        }
                        if (wVar.f5215c && listE.size() >= 2) {
                            ArrayList arrayList3 = new ArrayList();
                            ArrayList arrayList4 = new ArrayList();
                            for (Object obj : listE) {
                                if (((InetAddress) obj) instanceof Inet6Address) {
                                    arrayList3.add(obj);
                                } else {
                                    arrayList4.add(obj);
                                }
                            }
                            if (!arrayList3.isEmpty() && !arrayList4.isEmpty()) {
                                byte[] bArr = o6.d.f4327a;
                                Iterator it = arrayList3.iterator();
                                Iterator it2 = arrayList4.iterator();
                                d5.c cVarP = a.a.p();
                                while (true) {
                                    if (!it.hasNext() && !it2.hasNext()) {
                                        break;
                                    }
                                    if (it.hasNext()) {
                                        cVarP.add(it.next());
                                    }
                                    if (it2.hasNext()) {
                                        cVarP.add(it2.next());
                                    }
                                }
                                listE = a.a.e(cVarP);
                            }
                        }
                        Iterator it3 = listE.iterator();
                        while (it3.hasNext()) {
                            arrayList2.add(new InetSocketAddress((InetAddress) it3.next(), port));
                        }
                    }
                    Iterator it4 = wVar.f5217f.iterator();
                    while (it4.hasNext()) {
                        n6.x xVar2 = new n6.x(wVar.f5213a, proxy, (InetSocketAddress) it4.next());
                        androidx.emoji2.text.m mVar2 = wVar.f5214b;
                        synchronized (mVar2) {
                            zContains = ((LinkedHashSet) mVar2.f621a).contains(xVar2);
                        }
                        if (zContains) {
                            wVar.f5218g.add(xVar2);
                        } else {
                            arrayList.add(xVar2);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        break;
                    }
                }
                if (arrayList.isEmpty()) {
                    c5.m.p0(arrayList, wVar.f5218g);
                    wVar.f5218g.clear();
                }
                b0.j jVar2 = new b0.j(arrayList, 4);
                this.f5205n = jVar2;
                if (this.f5203l.f5171q) {
                    throw new IOException("Canceled");
                }
                if (jVar2.f832a >= arrayList.size()) {
                    throw new NoSuchElementException();
                }
                int i9 = jVar2.f832a;
                jVar2.f832a = i9 + 1;
                cVarC = c((n6.x) arrayList.get(i9), arrayList);
            } else {
                int i10 = jVar.f832a;
                ArrayList arrayList5 = (ArrayList) jVar.f833b;
                if (i10 >= arrayList5.size()) {
                    throw new NoSuchElementException();
                }
                int i11 = jVar.f832a;
                jVar.f832a = i11 + 1;
                cVarC = c((n6.x) arrayList5.get(i11), null);
            }
        }
        s sVarD2 = d(cVarC, cVarC.f5117l);
        return sVarD2 != null ? sVarD2 : cVarC;
    }

    public final c c(n6.x route, ArrayList arrayList) throws UnknownServiceException {
        n6.s sVar;
        kotlin.jvm.internal.p.e(route, "route");
        n6.a aVar = route.f4163a;
        List list = aVar.f3993i;
        n6.m url = aVar.f3992h;
        SSLSocketFactory sSLSocketFactory = aVar.f3988c;
        if (sSLSocketFactory == null) {
            if (!aVar.f3994j.contains(n6.h.f4033f)) {
                throw new UnknownServiceException("CLEARTEXT communication not enabled for client");
            }
            String str = url.d;
            if (!Platform.INSTANCE.get().isCleartextTrafficPermitted(str)) {
                throw new UnknownServiceException(m0.f.d("CLEARTEXT communication to ", str, " not permitted by network security policy"));
            }
        } else if (list.contains(n6.r.f4123g)) {
            throw new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS");
        }
        if (route.f4164b.type() == Proxy.Type.HTTP && (sSLSocketFactory != null || list.contains(n6.r.f4123g))) {
            a1.w wVar = new a1.w(8);
            kotlin.jvm.internal.p.e(url, "url");
            wVar.f75b = url;
            wVar.i("CONNECT");
            wVar.h("Host", o6.f.i(url, true));
            wVar.h("Proxy-Connection", "Keep-Alive");
            wVar.h("User-Agent", "okhttp/5.3.2");
            n6.s sVar2 = new n6.s(wVar);
            n6.v body = n6.w.f4162a;
            androidx.fragment.app.l lVar = new androidx.fragment.app.l(1);
            n6.b bVar = n6.r.f4119b;
            k4.v.T("Proxy-Authenticate");
            k4.v.U("OkHttp-Preemptive", "Proxy-Authenticate");
            lVar.c("Proxy-Authenticate");
            k4.v.p(lVar, "Proxy-Authenticate", "OkHttp-Preemptive");
            lVar.a();
            kotlin.jvm.internal.p.e(body, "body");
            aVar.f3990f.getClass();
            sVar = sVar2;
        } else {
            sVar = null;
        }
        return new c(this.f5193a, this.f5194b, this.f5195c, this.d, this.f5196e, this.f5197f, this.f5198g, this.f5199h, this.f5203l, this, route, arrayList, sVar, -1, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0043 A[Catch: all -> 0x0041, TryCatch #0 {all -> 0x0041, blocks: (B:14:0x0036, B:22:0x0043, B:25:0x004a), top: B:51:0x0036 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final r6.s d(r6.c r11, java.util.List r12) throws java.io.IOException {
        /*
            r10 = this;
            r6.q r0 = r10.f5194b
            boolean r1 = r10.f5204m
            n6.a r2 = r10.f5201j
            r6.o r3 = r10.f5203l
            r4 = 0
            r5 = 1
            if (r11 == 0) goto L14
            boolean r6 = r11.isReady()
            if (r6 == 0) goto L14
            r6 = r5
            goto L15
        L14:
            r6 = r4
        L15:
            r0.getClass()
            java.util.concurrent.ConcurrentLinkedQueue r0 = r0.d
            java.util.Iterator r0 = r0.iterator()
            java.lang.String r7 = "iterator(...)"
            kotlin.jvm.internal.p.d(r0, r7)
        L23:
            boolean r7 = r0.hasNext()
            r8 = 0
            if (r7 == 0) goto L6b
            java.lang.Object r7 = r0.next()
            r6.p r7 = (r6.p) r7
            kotlin.jvm.internal.p.b(r7)
            monitor-enter(r7)
            if (r6 == 0) goto L43
            u6.n r9 = r7.f5181j     // Catch: java.lang.Throwable -> L41
            if (r9 == 0) goto L3c
            r9 = r5
            goto L3d
        L3c:
            r9 = r4
        L3d:
            if (r9 != 0) goto L43
        L3f:
            r9 = r4
            goto L4e
        L41:
            r10 = move-exception
            goto L69
        L43:
            boolean r9 = r7.f(r2, r12)     // Catch: java.lang.Throwable -> L41
            if (r9 != 0) goto L4a
            goto L3f
        L4a:
            r3.b(r7)     // Catch: java.lang.Throwable -> L41
            r9 = r5
        L4e:
            monitor-exit(r7)
            if (r9 == 0) goto L23
            boolean r9 = r7.h(r1)
            if (r9 == 0) goto L58
            goto L6c
        L58:
            monitor-enter(r7)
            r7.f5182k = r5     // Catch: java.lang.Throwable -> L66
            java.net.Socket r8 = r3.i()     // Catch: java.lang.Throwable -> L66
            monitor-exit(r7)
            if (r8 == 0) goto L23
            o6.f.c(r8)
            goto L23
        L66:
            r10 = move-exception
            monitor-exit(r7)
            throw r10
        L69:
            monitor-exit(r7)
            throw r10
        L6b:
            r7 = r8
        L6c:
            if (r7 != 0) goto L6f
            return r8
        L6f:
            if (r11 == 0) goto L7c
            n6.x r12 = r11.f5116k
            r10.f5207p = r12
            java.net.Socket r10 = r11.f5123r
            if (r10 == 0) goto L7c
            o6.f.c(r10)
        L7c:
            r6.s r10 = new r6.s
            r10.<init>(r7)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: r6.r.d(r6.c, java.util.List):r6.s");
    }

    public final boolean e(n6.m url) {
        kotlin.jvm.internal.p.e(url, "url");
        n6.m mVar = this.f5201j.f3992h;
        return url.f4066e == mVar.f4066e && kotlin.jvm.internal.p.a(url.d, mVar.d);
    }
}
