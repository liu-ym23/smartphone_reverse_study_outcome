package y8;

import com.bytedanceos.common.utils.ReflectTool;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SSLSocketFactory f26148a;

    public static synchronized SSLSocketFactory a(String r10) {
        monitor-enter(e.class);
        SSLSocketFactory r11 = f26148a;     // Catch: Throwable -> L10
        if (r11 == null) goto L28;
        monitor-exit(e.class);
        return r11;
    L28:
        SSLContext r12 = SSLContext.getInstance(r10);     // Catch: Throwable -> L10 KeyManagementException -> L12 NoSuchAlgorithmException -> L14
        r12.init(null, new TrustManager[]{ReflectTool.getTrustManagerInstance()}, new SecureRandom());     // Catch: Throwable -> L10 KeyManagementException -> L12 NoSuchAlgorithmException -> L14
        f26148a = r12.getSocketFactory();     // Catch: Throwable -> L10 KeyManagementException -> L12 NoSuchAlgorithmException -> L14
    L19:
        if (f26148a != null) goto L21;
        f26148a = (SSLSocketFactory) SSLSocketFactory.getDefault();     // Catch: Throwable -> L10
    L21:
        SSLSocketFactory r13 = f26148a;     // Catch: Throwable -> L10
        monitor-exit(e.class);
        return r13;
    L14:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L10
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }
}
