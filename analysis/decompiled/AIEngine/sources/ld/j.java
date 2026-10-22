package ld;

import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface j {
    boolean a(SSLSocket sSLSocket);

    boolean b();

    String c(SSLSocket sSLSocket);

    default X509TrustManager d(SSLSocketFactory sSLSocketFactory) {
        return null;
    }

    default boolean e(SSLSocketFactory sSLSocketFactory) {
        return false;
    }

    void f(SSLSocket sSLSocket, String str, List<? extends Protocol> list);
}
