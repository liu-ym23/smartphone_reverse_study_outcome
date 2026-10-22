package O9;

import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes4.dex */
public interface m {
    boolean a(SSLSocket sSLSocket);

    boolean b();

    String c(SSLSocket sSLSocket);

    X509TrustManager d(SSLSocketFactory sSLSocketFactory);

    boolean e(SSLSocketFactory sSLSocketFactory);

    void f(SSLSocket sSLSocket, String str, List list);
}
