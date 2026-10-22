package okhttp3.internal.i.a;

import android.net.ssl.SSLSockets;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.aa;

/* JADX INFO: compiled from: Android10SocketAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class a implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1084a f40094a = null;

    /* JADX INFO: renamed from: okhttp3.internal.i.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Android10SocketAdapter.kt */
    public static final class C1084a {
        public /* synthetic */ C1084a(d.h.b.h r1) {
            this();
        }

        private C1084a() {
        }

        public final k a() {
            if (b() == true) goto L7;
            return null;
        L7:
            return (k) ZeusTransformUtils.preCheckCast(new a(), k.class, "com.obric.aiagent.plugin");
        }

        public final boolean b() {
            if (okhttp3.internal.i.h.f40147b.b() == true) goto L5;
        L7:
            return false;
        L5:
            if (Build.VERSION.SDK_INT < 29) goto L7;
            return true;
        }
    }

    static {
        f40094a = new C1084a(null);
    }

    public a() {
    }

    @Override // okhttp3.internal.i.a.k
    public X509TrustManager a(SSLSocketFactory r1) {
        return k.a.a(this, r1);
    }

    @Override // okhttp3.internal.i.a.k
    public boolean b(SSLSocketFactory r1) {
        return k.a.b(this, r1);
    }

    @Override // okhttp3.internal.i.a.k
    public boolean a(SSLSocket r1) {
        o.e(r1, "sslSocket");
        return SSLSockets.isSupportedSocket(r1);
    }

    @Override // okhttp3.internal.i.a.k
    public boolean a() {
        return f40094a.b();
    }

    @Override // okhttp3.internal.i.a.k
    public String b(SSLSocket r1) {
        o.e(r1, "sslSocket");
        String r0 = r1.getApplicationProtocol();
        if (r0 != null) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L9;
        return null;
    L9:
        return r0;
    L5:
        r2 = o.a(r0, "");
        goto L6
    }

    @Override // okhttp3.internal.i.a.k
    public void a(SSLSocket r2, String r3, List<? extends aa> r4) {
        List<? extends aa> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        o.e(r2, "sslSocket");
        o.e(r1, "protocols");
        SSLSockets.setUseSessionTickets(r2, true);     // Catch: IllegalArgumentException -> L5
        SSLParameters r5 = r2.getSSLParameters();     // Catch: IllegalArgumentException -> L5
        r5.setApplicationProtocols((String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(okhttp3.internal.i.h.f40147b.a(r1), Collection.class, "com.obric.aiagent.plugin")).toArray(new String[0]), String[].class, "com.obric.aiagent.plugin"));     // Catch: IllegalArgumentException -> L5
        r2.setSSLParameters(r5);     // Catch: IllegalArgumentException -> L5
        return;
    L5:
        e = move-exception;
        throw new IOException("Android internal error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }
}
