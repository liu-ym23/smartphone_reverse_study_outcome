package okhttp3.internal.platform;

import java.lang.reflect.Method;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes4.dex */
final class Jdk9Platform extends Platform {
    final Method getProtocolMethod;
    final Method setProtocolMethod;

    public Jdk9Platform(Method r10, Method r11) {
        this.setProtocolMethod = r10;
        this.getProtocolMethod = r11;
    }

    public static Jdk9Platform buildIfSupported() {
        return new Jdk9Platform(SSLParameters.class.getMethod("setApplicationProtocols", new Class[]{String[].class}), SSLSocket.class.getMethod("getApplicationProtocol", null));
    L5:
        return null;
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(SSLSocket r10, String r11, List<Protocol> r12) {
        SSLParameters r13 = r10.getSSLParameters();     // Catch: Throwable -> L4
        List<String> r14 = Platform.alpnProtocolNames(r12);     // Catch: Throwable -> L4
        this.setProtocolMethod.invoke(r13, new Object[]{r14.toArray(new String[r14.size()])});     // Catch: Throwable -> L4
        r10.setSSLParameters(r13);     // Catch: Throwable -> L4
        return;
    L4:
        e = move-exception;
        throw Util.assertionError("unable to set ssl parameters", e);
    }

    @Override // okhttp3.internal.platform.Platform
    @Nullable
    public String getSelectedProtocol(SSLSocket r10) {
        String r11 = (String) this.getProtocolMethod.invoke(r10, null);     // Catch: Throwable -> L8
        if (r11 == null) goto L10;
        if (r11.equals("") == true) goto L10;
        return r11;
    L10:
        return null;
    L8:
        e = move-exception;
        throw Util.assertionError("unable to get selected protocols", e);
    }

    @Override // okhttp3.internal.platform.Platform
    public X509TrustManager trustManager(SSLSocketFactory r10) {
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 9+");
    }
}
