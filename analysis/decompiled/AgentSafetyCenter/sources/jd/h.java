package jd;

import id.n;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h implements m {

    /* renamed from: a, reason: collision with root package name */
    public static final g f6788a = new g();

    @Override // jd.m
    public final boolean a(SSLSocket sSLSocket) {
        return false;
    }

    @Override // jd.m
    public final boolean b() {
        boolean z10 = id.d.f5949b;
        return id.d.f5949b;
    }

    @Override // jd.m
    public final String c(SSLSocket sSLSocket) {
        String applicationProtocol = ((BCSSLSocket) sSLSocket).getApplicationProtocol();
        if (applicationProtocol == null ? true : applicationProtocol.equals("")) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // jd.m
    public final X509TrustManager d(SSLSocketFactory sSLSocketFactory) {
        return null;
    }

    @Override // jd.m
    public final boolean e(SSLSocketFactory sSLSocketFactory) {
        return false;
    }

    @Override // jd.m
    public final void f(SSLSocket sSLSocket, String str, List list) {
        if (a(sSLSocket)) {
            BCSSLSocket bCSSLSocket = (BCSSLSocket) sSLSocket;
            BCSSLParameters parameters = bCSSLSocket.getParameters();
            n.Companion.getClass();
            parameters.setApplicationProtocols((String[]) id.m.a(list).toArray(new String[0]));
            bCSSLSocket.setParameters(parameters);
        }
    }
}
