package ed;

import ad.u;
import bd.l;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Proxy;
import java.net.Socket;
import java.util.LinkedHashSet;
import java.util.List;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.internal.connection.ConnectPlan;
import okhttp3.internal.connection.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a implements c {

    /* renamed from: a, reason: collision with root package name */
    public final okhttp3.internal.connection.d f8629a;

    /* renamed from: b, reason: collision with root package name */
    public final ad.e f8630b;

    /* renamed from: c, reason: collision with root package name */
    public final fd.f f8631c;

    public a(okhttp3.internal.connection.d dVar, ad.e eVar, fd.f fVar) {
        this.f8629a = dVar;
        this.f8630b = eVar;
        this.f8631c = fVar;
    }

    @Override // ed.c
    public final void a(ad.d connection, u route) {
        kotlin.jvm.internal.g.f(connection, "connection");
        kotlin.jvm.internal.g.f(route, "route");
        this.f8630b.getClass();
        okhttp3.internal.connection.d call = this.f8629a;
        kotlin.jvm.internal.g.f(call, "call");
    }

    @Override // ed.c
    public final void b(u route) {
        kotlin.jvm.internal.g.f(route, "route");
        okhttp3.internal.connection.d call = this.f8629a;
        call.f11044e.connectStart(call, route.f178c, route.f177b);
        this.f8630b.getClass();
        kotlin.jvm.internal.g.f(call, "call");
    }

    @Override // ed.c
    public final void c(String str, List<? extends InetAddress> list) {
        okhttp3.internal.connection.d dVar = this.f8629a;
        dVar.f11044e.dnsEnd(dVar, str, list);
    }

    @Override // ed.c
    public final void d(okhttp3.g url) {
        kotlin.jvm.internal.g.f(url, "url");
        okhttp3.internal.connection.d dVar = this.f8629a;
        dVar.f11044e.proxySelectStart(dVar, url);
    }

    @Override // ed.c
    public final void e(okhttp3.g url, List<? extends Proxy> list) {
        kotlin.jvm.internal.g.f(url, "url");
        okhttp3.internal.connection.d dVar = this.f8629a;
        dVar.f11044e.proxySelectEnd(dVar, url, list);
    }

    @Override // ed.c
    public final void f(ad.d connection) {
        kotlin.jvm.internal.g.f(connection, "connection");
        okhttp3.internal.connection.d dVar = this.f8629a;
        dVar.f11044e.connectionAcquired(dVar, connection);
    }

    @Override // ed.c
    public final void g(g gVar) {
        gVar.f8658l.getClass();
    }

    @Override // ed.c
    public final boolean h() {
        return !kotlin.jvm.internal.g.b(this.f8631c.f8839e.f10993b, "GET");
    }

    @Override // ed.c
    public final void i(g gVar) {
        okhttp3.internal.connection.d dVar = this.f8629a;
        dVar.f11044e.connectionReleased(dVar, gVar);
    }

    @Override // ed.c
    public final boolean isCanceled() {
        return this.f8629a.f11053s;
    }

    @Override // ed.c
    public final void j(u route, IOException iOException) {
        kotlin.jvm.internal.g.f(route, "route");
        okhttp3.internal.connection.d dVar = this.f8629a;
        dVar.f11044e.connectFailed(dVar, route.f178c, route.f177b, null, iOException);
    }

    @Override // ed.c
    public final void k(String str) {
        okhttp3.internal.connection.d dVar = this.f8629a;
        dVar.f11044e.dnsStart(dVar, str);
    }

    @Override // ed.c
    public final void l(Handshake handshake) {
        okhttp3.internal.connection.d dVar = this.f8629a;
        dVar.f11044e.secureConnectEnd(dVar, handshake);
    }

    @Override // ed.c
    public final void m(g gVar) {
        gVar.f8658l.getClass();
    }

    @Override // ed.c
    public final void n(ConnectPlan connectPlan) {
        this.f8629a.f11055u.remove(connectPlan);
    }

    @Override // ed.c
    public final void o() {
        okhttp3.internal.connection.d dVar = this.f8629a;
        dVar.f11044e.secureConnectStart(dVar);
    }

    @Override // ed.c
    public final Socket p() {
        return this.f8629a.i();
    }

    @Override // ed.c
    public final void q(u route) {
        kotlin.jvm.internal.g.f(route, "route");
        stepos.support.v7.app.palette.b bVar = this.f8629a.f11040a.C;
        synchronized (bVar) {
            ((LinkedHashSet) bVar.h).remove(route);
        }
    }

    @Override // ed.c
    public final void r(g connection) {
        kotlin.jvm.internal.g.f(connection, "connection");
        connection.f8658l.getClass();
        okhttp3.internal.connection.d call = this.f8629a;
        kotlin.jvm.internal.g.f(call, "call");
    }

    @Override // ed.c
    public final g s() {
        return this.f8629a.f11048m;
    }

    @Override // ed.c
    public final void t(u route, Protocol protocol) {
        kotlin.jvm.internal.g.f(route, "route");
        okhttp3.internal.connection.d dVar = this.f8629a;
        dVar.f11044e.connectEnd(dVar, route.f178c, route.f177b, protocol);
    }

    @Override // ed.c
    public final void u(g connection) {
        kotlin.jvm.internal.g.f(connection, "connection");
        okhttp3.f fVar = l.f3237a;
        okhttp3.internal.connection.d dVar = this.f8629a;
        if (dVar.f11048m != null) {
            throw new IllegalStateException("Check failed.");
        }
        dVar.f11048m = connection;
        connection.f8665t.add(new d.b(dVar, dVar.f11046k));
    }

    @Override // ed.c
    public final void v(g gVar) {
        gVar.f8658l.getClass();
    }

    @Override // ed.c
    public final void w(ConnectPlan connectPlan) {
        this.f8629a.f11055u.add(connectPlan);
    }
}
