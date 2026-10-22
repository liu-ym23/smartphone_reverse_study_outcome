package N9;

import j9.t;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes4.dex */
public final class i extends m {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f1022a;

    static {
        String property = System.getProperty("java.specification.version");
        Integer numF0 = property != null ? t.f0(property) : null;
        boolean z10 = false;
        if (numF0 == null) {
            try {
                SSLSocket.class.getMethod("getApplicationProtocol", null);
                z10 = true;
            } catch (NoSuchMethodException unused) {
            }
        } else if (numF0.intValue() >= 9) {
            z10 = true;
        }
        f1022a = z10;
    }

    @Override // N9.m
    public final void configureTlsExtensions(SSLSocket sslSocket, String str, List protocols) {
        kotlin.jvm.internal.k.f(sslSocket, "sslSocket");
        kotlin.jvm.internal.k.f(protocols, "protocols");
        SSLParameters sSLParameters = sslSocket.getSSLParameters();
        m.Companion.getClass();
        sSLParameters.setApplicationProtocols((String[]) l.a(protocols).toArray(new String[0]));
        sslSocket.setSSLParameters(sSLParameters);
    }

    @Override // N9.m
    public final String getSelectedProtocol(SSLSocket sslSocket) {
        kotlin.jvm.internal.k.f(sslSocket, "sslSocket");
        try {
            String applicationProtocol = sslSocket.getApplicationProtocol();
            if (applicationProtocol == null ? true : applicationProtocol.equals("")) {
                return null;
            }
            return applicationProtocol;
        } catch (UnsupportedOperationException unused) {
            return null;
        }
    }

    @Override // N9.m
    public final X509TrustManager trustManager(SSLSocketFactory sslSocketFactory) {
        kotlin.jvm.internal.k.f(sslSocketFactory, "sslSocketFactory");
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 9+");
    }
}
