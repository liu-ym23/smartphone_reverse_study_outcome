package ed;

import ad.u;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Proxy;
import java.net.Socket;
import java.util.List;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.internal.connection.ConnectPlan;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface c {
    void a(ad.d dVar, u uVar);

    void b(u uVar);

    void c(String str, List<? extends InetAddress> list);

    void d(okhttp3.g gVar);

    void e(okhttp3.g gVar, List<? extends Proxy> list);

    void f(ad.d dVar);

    void g(g gVar);

    boolean h();

    void i(g gVar);

    boolean isCanceled();

    void j(u uVar, IOException iOException);

    void k(String str);

    void l(Handshake handshake);

    void m(g gVar);

    void n(ConnectPlan connectPlan);

    void o();

    Socket p();

    void q(u uVar);

    void r(g gVar);

    g s();

    void t(u uVar, Protocol protocol);

    void u(g gVar);

    void v(g gVar);

    void w(ConnectPlan connectPlan);
}
