package tb;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import kotlin.Metadata;
import okhttp3.Protocol;

@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\t\b&\u0018\u0000 Z2\u00020\u0001:\u0002JNB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ-\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0012H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010\"\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b$\u0010\bJ!\u0010'\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0004\b'\u0010(J1\u0010+\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00132\b\u0010*\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\b+\u0010,J9\u0010/\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00132\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b/\u00100J\u001f\u00103\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00102\u001a\u000201H\u0016¢\u0006\u0004\b3\u00104J\u001f\u00105\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00102\u001a\u000201H\u0016¢\u0006\u0004\b5\u00104J\u0017\u00106\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b6\u0010\bJ\u001f\u00109\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00108\u001a\u000207H\u0016¢\u0006\u0004\b9\u0010:J\u0017\u0010;\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b;\u0010\bJ\u001f\u0010>\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010=\u001a\u00020<H\u0016¢\u0006\u0004\b>\u0010?J\u001f\u0010@\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b@\u0010AJ\u0017\u0010B\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\bB\u0010\bJ\u001f\u0010E\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010D\u001a\u00020CH\u0016¢\u0006\u0004\bE\u0010FJ\u0017\u0010G\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\bG\u0010\bJ\u001f\u0010H\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010=\u001a\u00020<H\u0016¢\u0006\u0004\bH\u0010?J\u001f\u0010I\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\bI\u0010AJ\u0017\u0010J\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\bJ\u0010\bJ\u001f\u0010K\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\bK\u0010AJ\u0017\u0010L\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\bL\u0010\bJ\u001f\u0010M\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010D\u001a\u00020CH\u0016¢\u0006\u0004\bM\u0010FJ\u001f\u0010N\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010D\u001a\u00020CH\u0016¢\u0006\u0004\bN\u0010FJ\u001f\u0010P\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010O\u001a\u00020CH\u0016¢\u0006\u0004\bP\u0010FJ'\u0010T\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020-2\u0006\u0010S\u001a\u00020RH\u0016¢\u0006\u0004\bT\u0010UJ)\u0010X\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010V\u001a\u00020C2\b\u0010W\u001a\u0004\u0018\u000107H\u0016¢\u0006\u0004\bX\u0010Y¨\u0006["}, d2 = {"Ltb/q;", "", "<init>", "()V", "Ltb/e;", "call", "LY8/t;", "e", "(Ltb/e;)V", "Ltb/o;", "dispatcher", "m", "(Ltb/e;Ltb/o;)V", "l", "Ltb/v;", "url", "r", "(Ltb/e;Ltb/v;)V", "", "Ljava/net/Proxy;", "proxies", "q", "(Ltb/e;Ltb/v;Ljava/util/List;)V", "", "domainName", "o", "(Ltb/e;Ljava/lang/String;)V", "Ljava/net/InetAddress;", "inetAddressList", "n", "(Ltb/e;Ljava/lang/String;Ljava/util/List;)V", "Ljava/net/InetSocketAddress;", "inetSocketAddress", "proxy", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ltb/e;Ljava/net/InetSocketAddress;Ljava/net/Proxy;)V", "F", "Lokhttp3/c;", "handshake", ExifInterface.LONGITUDE_EAST, "(Ltb/e;Lokhttp3/c;)V", "Lokhttp3/Protocol;", "protocol", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ltb/e;Ljava/net/InetSocketAddress;Ljava/net/Proxy;Lokhttp3/Protocol;)V", "Ljava/io/IOException;", "ioe", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ltb/e;Ljava/net/InetSocketAddress;Ljava/net/Proxy;Lokhttp3/Protocol;Ljava/io/IOException;)V", "Ltb/j;", "connection", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ltb/e;Ltb/j;)V", "k", "w", "Ltb/A;", "request", "v", "(Ltb/e;Ltb/A;)V", "t", "", "byteCount", "s", "(Ltb/e;J)V", "u", "(Ltb/e;Ljava/io/IOException;)V", "B", "Ltb/C;", UxipConstants.f30685x, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ltb/e;Ltb/C;)V", "y", "x", "z", "c", Const.INTENT_KEY_UMID, "f", "D", Const.INTENT_KEY_PKGNAME, "cachedResponse", Const.INTENT_KEY_APIKEY, "exception", "", "retry", "C", "(Ltb/e;Ljava/io/IOException;Z)V", "networkResponse", "nextRequest", "p", "(Ltb/e;Ltb/C;Ltb/A;)V", "Companion", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: tb.q, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC5550q {
    public static final AbstractC5550q NONE = new a();

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"tb/q$a", "Ltb/q;", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: tb.q$a */
    public static final class a extends AbstractC5550q {
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Ltb/q$c;", "", "Ltb/e;", "call", "Ltb/q;", Const.INTENT_KEY_APIKEY, "(Ltb/e;)Ltb/q;", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: tb.q$c */
    public interface c {
        AbstractC5550q a(InterfaceC5538e call);
    }

    public void A(InterfaceC5538e call, C5530C response) {
        kotlin.jvm.internal.p.i(call, "call");
        kotlin.jvm.internal.p.i(response, "response");
    }

    public void B(InterfaceC5538e call) {
        kotlin.jvm.internal.p.i(call, "call");
    }

    public void C(InterfaceC5538e call, IOException exception, boolean retry) {
        kotlin.jvm.internal.p.i(call, "call");
        kotlin.jvm.internal.p.i(exception, "exception");
    }

    public void D(InterfaceC5538e call, C5530C response) {
        kotlin.jvm.internal.p.i(call, "call");
        kotlin.jvm.internal.p.i(response, "response");
    }

    public void E(InterfaceC5538e call, okhttp3.c handshake) {
        kotlin.jvm.internal.p.i(call, "call");
    }

    public void F(InterfaceC5538e call) {
        kotlin.jvm.internal.p.i(call, "call");
    }

    public void a(InterfaceC5538e call, C5530C cachedResponse) {
        kotlin.jvm.internal.p.i(call, "call");
        kotlin.jvm.internal.p.i(cachedResponse, "cachedResponse");
    }

    public void b(InterfaceC5538e call, C5530C response) {
        kotlin.jvm.internal.p.i(call, "call");
        kotlin.jvm.internal.p.i(response, "response");
    }

    public void c(InterfaceC5538e call) {
        kotlin.jvm.internal.p.i(call, "call");
    }

    public void d(InterfaceC5538e call, IOException ioe) {
        kotlin.jvm.internal.p.i(call, "call");
        kotlin.jvm.internal.p.i(ioe, "ioe");
    }

    public void e(InterfaceC5538e call) {
        kotlin.jvm.internal.p.i(call, "call");
    }

    public void f(InterfaceC5538e call) {
        kotlin.jvm.internal.p.i(call, "call");
    }

    public void g(InterfaceC5538e call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        kotlin.jvm.internal.p.i(call, "call");
        kotlin.jvm.internal.p.i(inetSocketAddress, "inetSocketAddress");
        kotlin.jvm.internal.p.i(proxy, "proxy");
    }

    public void h(InterfaceC5538e call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException ioe) {
        kotlin.jvm.internal.p.i(call, "call");
        kotlin.jvm.internal.p.i(inetSocketAddress, "inetSocketAddress");
        kotlin.jvm.internal.p.i(proxy, "proxy");
        kotlin.jvm.internal.p.i(ioe, "ioe");
    }

    public void i(InterfaceC5538e call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        kotlin.jvm.internal.p.i(call, "call");
        kotlin.jvm.internal.p.i(inetSocketAddress, "inetSocketAddress");
        kotlin.jvm.internal.p.i(proxy, "proxy");
    }

    public void j(InterfaceC5538e call, InterfaceC5543j connection) {
        kotlin.jvm.internal.p.i(call, "call");
        kotlin.jvm.internal.p.i(connection, "connection");
    }

    public void k(InterfaceC5538e call, InterfaceC5543j connection) {
        kotlin.jvm.internal.p.i(call, "call");
        kotlin.jvm.internal.p.i(connection, "connection");
    }

    public void l(InterfaceC5538e call, C5548o dispatcher) {
        kotlin.jvm.internal.p.i(call, "call");
        kotlin.jvm.internal.p.i(dispatcher, "dispatcher");
    }

    public void m(InterfaceC5538e call, C5548o dispatcher) {
        kotlin.jvm.internal.p.i(call, "call");
        kotlin.jvm.internal.p.i(dispatcher, "dispatcher");
    }

    public void n(InterfaceC5538e call, String domainName, List<InetAddress> inetAddressList) {
        kotlin.jvm.internal.p.i(call, "call");
        kotlin.jvm.internal.p.i(domainName, "domainName");
        kotlin.jvm.internal.p.i(inetAddressList, "inetAddressList");
    }

    public void o(InterfaceC5538e call, String domainName) {
        kotlin.jvm.internal.p.i(call, "call");
        kotlin.jvm.internal.p.i(domainName, "domainName");
    }

    public void p(InterfaceC5538e call, C5530C networkResponse, C5528A nextRequest) {
        kotlin.jvm.internal.p.i(call, "call");
        kotlin.jvm.internal.p.i(networkResponse, "networkResponse");
    }

    public void q(InterfaceC5538e call, v url, List<Proxy> proxies) {
        kotlin.jvm.internal.p.i(call, "call");
        kotlin.jvm.internal.p.i(url, "url");
        kotlin.jvm.internal.p.i(proxies, "proxies");
    }

    public void r(InterfaceC5538e call, v url) {
        kotlin.jvm.internal.p.i(call, "call");
        kotlin.jvm.internal.p.i(url, "url");
    }

    public void s(InterfaceC5538e call, long byteCount) {
        kotlin.jvm.internal.p.i(call, "call");
    }

    public void t(InterfaceC5538e call) {
        kotlin.jvm.internal.p.i(call, "call");
    }

    public void u(InterfaceC5538e call, IOException ioe) {
        kotlin.jvm.internal.p.i(call, "call");
        kotlin.jvm.internal.p.i(ioe, "ioe");
    }

    public void v(InterfaceC5538e call, C5528A request) {
        kotlin.jvm.internal.p.i(call, "call");
        kotlin.jvm.internal.p.i(request, "request");
    }

    public void w(InterfaceC5538e call) {
        kotlin.jvm.internal.p.i(call, "call");
    }

    public void x(InterfaceC5538e call, long byteCount) {
        kotlin.jvm.internal.p.i(call, "call");
    }

    public void y(InterfaceC5538e call) {
        kotlin.jvm.internal.p.i(call, "call");
    }

    public void z(InterfaceC5538e call, IOException ioe) {
        kotlin.jvm.internal.p.i(call, "call");
        kotlin.jvm.internal.p.i(ioe, "ioe");
    }
}
