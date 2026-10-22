package okhttp3.internal.i;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.aa;

/* JADX INFO: compiled from: Jdk9Platform.kt */
/* JADX INFO: loaded from: classes5.dex */
public class f extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f40141a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final boolean f40142c = false;

    /* JADX INFO: compiled from: Jdk9Platform.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final boolean a() {
            return f.c();
        }

        public final f b() {
            if (a() == true) goto L7;
            return null;
        L7:
            return new f();
        }
    }

    public f() {
    }

    public static final /* synthetic */ boolean c() {
        return f40142c;
    }

    @Override // okhttp3.internal.i.h
    public void a(SSLSocket r2, String r3, List<aa> r4) {
        List<? extends aa> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        o.e(r2, "sslSocket");
        o.e(r1, "protocols");
        SSLParameters r5 = r2.getSSLParameters();
        r5.setApplicationProtocols((String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(h.f40147b.a(r1), Collection.class, "com.obric.aiagent.plugin")).toArray(new String[0]), String[].class, "com.obric.aiagent.plugin"));
        r2.setSSLParameters(r5);
    }

    @Override // okhttp3.internal.i.h
    public String a(SSLSocket r2) {
        o.e(r2, "sslSocket");
        String r3 = r2.getApplicationProtocol();     // Catch: UnsupportedOperationException -> L11
        if (r3 != null) goto L6;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L10;
        return null;
    L10:
        return r3;
    L6:
        r0 = o.a(r3, "");     // Catch: UnsupportedOperationException -> L11
    L15:
        return null;
    }

    @Override // okhttp3.internal.i.h
    public X509TrustManager a(SSLSocketFactory r1) {
        o.e(r1, "sslSocketFactory");
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 9+");
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Integer r1 = null;
        f40141a = new a(0 == true ? 1 : 0);
        String r0 = System.getProperty("java.specification.version");
        if (r0 == null) goto L5;
        r1 = d.o.o.d(r0);
    L5:
        boolean r2 = true;
        if (r1 != null) goto L8;
        SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]);     // Catch: NoSuchMethodException -> L14
    L12:
        f40142c = r2;
        return;
    L10:
        r2 = false;
        goto L12
    L8:
        if (r1.intValue() < 9) goto L10;
        goto L10
    }
}
