package id;

import hc.o;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j extends n {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f5962a;

    static {
        String property = System.getProperty("java.specification.version");
        Integer numV = property != null ? o.V(property) : null;
        boolean z10 = false;
        if (numV == null) {
            try {
                SSLSocket.class.getMethod("getApplicationProtocol", null);
                z10 = true;
            } catch (NoSuchMethodException unused) {
            }
        } else if (numV.intValue() >= 9) {
            z10 = true;
        }
        f5962a = z10;
    }

    @Override // id.n
    public final void configureTlsExtensions(SSLSocket sSLSocket, String str, List list) {
        sSLSocket.getClass();
        list.getClass();
        SSLParameters sSLParameters = sSLSocket.getSSLParameters();
        n.Companion.getClass();
        sSLParameters.setApplicationProtocols((String[]) m.a(list).toArray(new String[0]));
        sSLSocket.setSSLParameters(sSLParameters);
    }

    @Override // id.n
    public final String getSelectedProtocol(SSLSocket sSLSocket) {
        sSLSocket.getClass();
        try {
            String applicationProtocol = sSLSocket.getApplicationProtocol();
            if (applicationProtocol == null ? true : applicationProtocol.equals("")) {
                return null;
            }
            return applicationProtocol;
        } catch (UnsupportedOperationException unused) {
            return null;
        }
    }

    @Override // id.n
    public final X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        sSLSocketFactory.getClass();
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 9+");
    }
}
