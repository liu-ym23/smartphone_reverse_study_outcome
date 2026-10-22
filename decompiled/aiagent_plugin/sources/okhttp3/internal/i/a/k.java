package okhttp3.internal.i.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.aa;

/* JADX INFO: compiled from: SocketAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface k {

    /* JADX INFO: compiled from: SocketAdapter.kt */
    public static final class a {
        public static X509TrustManager a(k r2, SSLSocketFactory r3) {
            k r4 = (k) ZeusTransformUtils.wrapperContextForParams(r2, k.class, "com.obric.aiagent.plugin");
            o.e(r3, "sslSocketFactory");
            return null;
        }

        public static boolean b(k r2, SSLSocketFactory r3) {
            k r4 = (k) ZeusTransformUtils.wrapperContextForParams(r2, k.class, "com.obric.aiagent.plugin");
            o.e(r3, "sslSocketFactory");
            return false;
        }
    }

    X509TrustManager a(SSLSocketFactory r1);

    void a(SSLSocket r1, String r2, List<? extends aa> r3);

    boolean a();

    boolean a(SSLSocket r1);

    String b(SSLSocket r1);

    boolean b(SSLSocketFactory r1);
}
