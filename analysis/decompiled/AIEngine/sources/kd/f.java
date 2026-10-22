package kd;

import gc.n;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kd.h;
import okhttp3.Protocol;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f extends h {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f9978a;

    /* renamed from: b, reason: collision with root package name */
    public static final Integer f9979b;

    static {
        String property = System.getProperty("java.specification.version");
        Integer numC0 = property != null ? n.c0(property) : null;
        f9979b = numC0;
        boolean z = false;
        if (numC0 == null) {
            try {
                SSLSocket.class.getMethod("getApplicationProtocol", null);
                z = true;
            } catch (NoSuchMethodException unused) {
            }
        } else if (numC0.intValue() >= 9) {
            z = true;
        }
        f9978a = z;
    }

    @Override // kd.h
    public final void configureTlsExtensions(SSLSocket sslSocket, String str, List<Protocol> protocols) {
        kotlin.jvm.internal.g.f(sslSocket, "sslSocket");
        kotlin.jvm.internal.g.f(protocols, "protocols");
        SSLParameters sSLParameters = sslSocket.getSSLParameters();
        h.Companion.getClass();
        sSLParameters.setApplicationProtocols((String[]) h.a.a(protocols).toArray(new String[0]));
        sslSocket.setSSLParameters(sSLParameters);
    }

    @Override // kd.h
    public final String getSelectedProtocol(SSLSocket sslSocket) {
        kotlin.jvm.internal.g.f(sslSocket, "sslSocket");
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

    @Override // kd.h
    public final SSLContext newSSLContext() throws NoSuchAlgorithmException {
        SSLContext sSLContext;
        Integer num = f9979b;
        if (num != null && num.intValue() >= 9) {
            SSLContext sSLContext2 = SSLContext.getInstance("TLS");
            kotlin.jvm.internal.g.e(sSLContext2, "getInstance(...)");
            return sSLContext2;
        }
        try {
            sSLContext = SSLContext.getInstance("TLSv1.3");
        } catch (NoSuchAlgorithmException unused) {
            sSLContext = SSLContext.getInstance("TLS");
        }
        kotlin.jvm.internal.g.c(sSLContext);
        return sSLContext;
    }

    @Override // kd.h
    public final X509TrustManager trustManager(SSLSocketFactory sslSocketFactory) {
        kotlin.jvm.internal.g.f(sslSocketFactory, "sslSocketFactory");
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 8 (>= 252) or JDK 9+");
    }
}
