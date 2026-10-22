package O9;

import android.net.ssl.SSLSockets;
import java.io.IOException;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes4.dex */
public final class a implements m {
    @Override // O9.m
    public final boolean a(SSLSocket sSLSocket) {
        return SSLSockets.isSupportedSocket(sSLSocket);
    }

    @Override // O9.m
    public final boolean b() {
        N9.m.Companion.getClass();
        return N9.l.c();
    }

    @Override // O9.m
    public final String c(SSLSocket sSLSocket) {
        String applicationProtocol = sSLSocket.getApplicationProtocol();
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
    public final void f(SSLSocket sSLSocket, String str, List list) throws IOException {
        try {
            SSLSockets.setUseSessionTickets(sSLSocket, true);
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            N9.m.Companion.getClass();
            sSLParameters.setApplicationProtocols((String[]) N9.l.a(list).toArray(new String[0]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalArgumentException e) {
            throw new IOException("Android internal error", e);
        }
    }
}
