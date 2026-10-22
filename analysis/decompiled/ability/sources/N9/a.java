package N9;

import D7.q;
import android.net.http.X509TrustManagerExtensions;
import android.security.NetworkSecurityPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes4.dex */
public final class a extends m {
    public static final boolean b;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f1015a;

    static {
        m.Companion.getClass();
        b = l.c();
    }

    public a() {
        m.Companion.getClass();
        ArrayList arrayListJ0 = q.j0(new O9.m[]{l.c() ? new O9.a() : null, new O9.l(O9.f.f), new O9.l(O9.j.f1050a), new O9.l(O9.h.f1049a)});
        ArrayList arrayList = new ArrayList();
        Iterator it = arrayListJ0.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (((O9.m) next).b()) {
                arrayList.add(next);
            }
        }
        this.f1015a = arrayList;
    }

    @Override // N9.m
    public final S9.c buildCertificateChainCleaner(X509TrustManager trustManager) {
        X509TrustManagerExtensions x509TrustManagerExtensions;
        kotlin.jvm.internal.k.f(trustManager, "trustManager");
        try {
            x509TrustManagerExtensions = new X509TrustManagerExtensions(trustManager);
        } catch (IllegalArgumentException unused) {
            x509TrustManagerExtensions = null;
        }
        O9.b bVar = x509TrustManagerExtensions != null ? new O9.b(trustManager, x509TrustManagerExtensions) : null;
        return bVar != null ? bVar : super.buildCertificateChainCleaner(trustManager);
    }

    @Override // N9.m
    public final void configureTlsExtensions(SSLSocket sslSocket, String str, List protocols) {
        Object next;
        kotlin.jvm.internal.k.f(sslSocket, "sslSocket");
        kotlin.jvm.internal.k.f(protocols, "protocols");
        Iterator it = this.f1015a.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((O9.m) next).a(sslSocket)) {
                    break;
                }
            }
        }
        O9.m mVar = (O9.m) next;
        if (mVar != null) {
            mVar.f(sslSocket, str, protocols);
        }
    }

    @Override // N9.m
    public final String getSelectedProtocol(SSLSocket sslSocket) {
        Object next;
        kotlin.jvm.internal.k.f(sslSocket, "sslSocket");
        Iterator it = this.f1015a.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((O9.m) next).a(sslSocket)) {
                break;
            }
        }
        O9.m mVar = (O9.m) next;
        if (mVar != null) {
            return mVar.c(sslSocket);
        }
        return null;
    }

    @Override // N9.m
    public final boolean isCleartextTrafficPermitted(String hostname) {
        kotlin.jvm.internal.k.f(hostname, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(hostname);
    }

    @Override // N9.m
    public final X509TrustManager trustManager(SSLSocketFactory sslSocketFactory) {
        Object next;
        kotlin.jvm.internal.k.f(sslSocketFactory, "sslSocketFactory");
        Iterator it = this.f1015a.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((O9.m) next).e(sslSocketFactory)) {
                break;
            }
        }
        O9.m mVar = (O9.m) next;
        if (mVar != null) {
            return mVar.d(sslSocketFactory);
        }
        return null;
    }
}
