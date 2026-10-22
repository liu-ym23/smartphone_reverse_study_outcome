package O9;

import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;

/* loaded from: classes4.dex */
public final class h implements m {

    /* renamed from: a, reason: collision with root package name */
    public static final g f1049a = new g();

    @Override // O9.m
    public final boolean a(SSLSocket sSLSocket) {
        return false;
    }

    @Override // O9.m
    public final boolean b() {
        boolean z10 = N9.c.b;
        return N9.c.b;
    }

    @Override // O9.m
    public final String c(SSLSocket sSLSocket) {
        String applicationProtocol = ((BCSSLSocket) sSLSocket).getApplicationProtocol();
        if (applicationProtocol == null ? true : applicationProtocol.equals("")) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // O9.m
    public final X509TrustManager d(SSLSocketFactory sSLSocketFactory) {
        return null;
    }

    @Override // O9.m
    public final boolean e(SSLSocketFactory sSLSocketFactory) {
        return false;
    }

    @Override // O9.m
    public final void f(SSLSocket sSLSocket, String str, List list) {
        if (a(sSLSocket)) {
            BCSSLSocket bCSSLSocket = (BCSSLSocket) sSLSocket;
            BCSSLParameters parameters = bCSSLSocket.getParameters();
            N9.m.Companion.getClass();
            parameters.setApplicationProtocols((String[]) N9.l.a(list).toArray(new String[0]));
            bCSSLSocket.setParameters(parameters);
        }
    }
}
