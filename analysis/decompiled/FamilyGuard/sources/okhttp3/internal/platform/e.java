package okhttp3.internal.platform;

import C4.B;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
final class e extends f {

    /* renamed from: a, reason: collision with root package name */
    final Method f19103a;

    /* renamed from: b, reason: collision with root package name */
    final Method f19104b;

    e(Method method, Method method2) {
        this.f19103a = method;
        this.f19104b = method2;
    }

    public static e a() {
        try {
            return new e(SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", null));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // okhttp3.internal.platform.f
    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<B> list) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> listAlpnProtocolNames = f.alpnProtocolNames(list);
            this.f19103a.invoke(sSLParameters, listAlpnProtocolNames.toArray(new String[listAlpnProtocolNames.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e6) {
            throw new AssertionError("failed to set SSL parameters", e6);
        }
    }

    @Override // okhttp3.internal.platform.f
    @Nullable
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        try {
            String str = (String) this.f19104b.invoke(sSLSocket, null);
            if (str != null) {
                if (!str.equals(BuildConfig.FLAVOR)) {
                    return str;
                }
            }
            return null;
        } catch (IllegalAccessException e6) {
            throw new AssertionError("failed to get ALPN selected protocol", e6);
        } catch (InvocationTargetException e7) {
            if (e7.getCause() instanceof UnsupportedOperationException) {
                return null;
            }
            throw new AssertionError("failed to get ALPN selected protocol", e7);
        }
    }

    @Override // okhttp3.internal.platform.f
    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 9+");
    }
}
