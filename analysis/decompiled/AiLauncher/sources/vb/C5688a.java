package vb;

import La.D;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.auth.AuthScheme;
import java.io.IOException;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.SocketAddress;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import tb.C5528A;
import tb.C5530C;
import tb.C5532E;
import tb.C5534a;
import tb.C5542i;
import tb.C5547n;
import tb.InterfaceC5535b;
import tb.InterfaceC5549p;
import tb.v;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0012\u001a\u00020\u0011*\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lvb/a;", "Ltb/b;", "Ltb/p;", "defaultDns", "<init>", "(Ltb/p;)V", "Ltb/E;", M5.a.CARD_TYPE_ROUTE, "Ltb/C;", UxipConstants.f30685x, "Ltb/A;", "authenticate", "(Ltb/E;Ltb/C;)Ltb/A;", "Ljava/net/Proxy;", "Ltb/v;", "url", "dns", "Ljava/net/InetAddress;", Const.INTENT_KEY_APIKEY, "(Ljava/net/Proxy;Ltb/v;Ltb/p;)Ljava/net/InetAddress;", Const.INTENT_KEY_UMID, "Ltb/p;", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: vb.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5688a implements InterfaceC5535b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5549p defaultDns;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: vb.a$a, reason: collision with other inner class name */
    public static final /* synthetic */ class C0542a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f42873a;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            try {
                iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f42873a = iArr;
        }
    }

    public C5688a(InterfaceC5549p defaultDns) {
        p.i(defaultDns, "defaultDns");
        this.defaultDns = defaultDns;
    }

    public final InetAddress a(Proxy proxy, v vVar, InterfaceC5549p interfaceC5549p) throws IOException {
        Proxy.Type type = proxy.type();
        if ((type == null ? -1 : C0542a.f42873a[type.ordinal()]) == 1) {
            return (InetAddress) F.q0(interfaceC5549p.a(vVar.getHost()));
        }
        SocketAddress socketAddressAddress = proxy.address();
        p.g(socketAddressAddress, "null cannot be cast to non-null type java.net.InetSocketAddress");
        InetAddress address = ((InetSocketAddress) socketAddressAddress).getAddress();
        p.h(address, "getAddress(...)");
        return address;
    }

    @Override // tb.InterfaceC5535b
    public C5528A authenticate(C5532E route, C5530C response) throws IOException {
        Proxy proxy;
        InterfaceC5549p dns;
        PasswordAuthentication passwordAuthenticationRequestPasswordAuthentication;
        C5534a address;
        p.i(response, "response");
        List<C5542i> listL = response.l();
        C5528A request = response.getRequest();
        v url = request.getUrl();
        boolean z10 = response.getCode() == 407;
        if (route == null || (proxy = route.getProxy()) == null) {
            proxy = Proxy.NO_PROXY;
        }
        for (C5542i c5542i : listL) {
            if (D.L(AuthScheme.Basic, c5542i.getScheme(), true)) {
                if (route == null || (address = route.getAddress()) == null || (dns = address.getDns()) == null) {
                    dns = this.defaultDns;
                }
                if (z10) {
                    SocketAddress socketAddressAddress = proxy.address();
                    p.g(socketAddressAddress, "null cannot be cast to non-null type java.net.InetSocketAddress");
                    InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
                    String hostName = inetSocketAddress.getHostName();
                    p.f(proxy);
                    passwordAuthenticationRequestPasswordAuthentication = Authenticator.requestPasswordAuthentication(hostName, a(proxy, url, dns), inetSocketAddress.getPort(), url.getScheme(), c5542i.b(), c5542i.getScheme(), url.v(), Authenticator.RequestorType.PROXY);
                } else {
                    String host = url.getHost();
                    p.f(proxy);
                    passwordAuthenticationRequestPasswordAuthentication = Authenticator.requestPasswordAuthentication(host, a(proxy, url, dns), url.getPort(), url.getScheme(), c5542i.b(), c5542i.getScheme(), url.v(), Authenticator.RequestorType.SERVER);
                }
                if (passwordAuthenticationRequestPasswordAuthentication != null) {
                    String str = z10 ? "Proxy-Authorization" : "Authorization";
                    String userName = passwordAuthenticationRequestPasswordAuthentication.getUserName();
                    p.h(userName, "getUserName(...)");
                    char[] password = passwordAuthenticationRequestPasswordAuthentication.getPassword();
                    p.h(password, "getPassword(...)");
                    return request.i().l(str, C5547n.a(userName, new String(password), c5542i.a())).b();
                }
            }
        }
        return null;
    }

    public /* synthetic */ C5688a(InterfaceC5549p interfaceC5549p, int i10, i iVar) {
        this((i10 & 1) != 0 ? InterfaceC5549p.f42229b : interfaceC5549p);
    }
}
