package jd;

import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface m {
    boolean a(SSLSocket sSLSocket);

    boolean b();

    String c(SSLSocket sSLSocket);

    X509TrustManager d(SSLSocketFactory sSLSocketFactory);

    boolean e(SSLSocketFactory sSLSocketFactory);

    void f(SSLSocket sSLSocket, String str, List list);
}
