package jd;

import android.net.ssl.SSLSockets;
import id.n;
import java.io.IOException;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a implements m {
    @Override // jd.m
    public final boolean a(SSLSocket sSLSocket) {
        return SSLSockets.isSupportedSocket(sSLSocket);
    }

    @Override // jd.m
    public final boolean b() {
        n.Companion.getClass();
        return id.m.c();
    }

    @Override // jd.m
    public final String c(SSLSocket sSLSocket) {
        String applicationProtocol = sSLSocket.getApplicationProtocol();
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
    public final void f(SSLSocket sSLSocket, String str, List list) throws IOException {
        try {
            SSLSockets.setUseSessionTickets(sSLSocket, true);
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            n.Companion.getClass();
            sSLParameters.setApplicationProtocols((String[]) id.m.a(list).toArray(new String[0]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalArgumentException e10) {
            throw new IOException("Android internal error", e10);
        }
    }
}
