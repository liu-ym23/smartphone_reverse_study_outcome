package id;

import android.net.http.X509TrustManagerExtensions;
import android.security.NetworkSecurityPolicy;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a extends n {

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f5945b;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f5946a;

    static {
        n.Companion.getClass();
        f5945b = m.c();
    }

    @Override // id.n
    public final md.c buildCertificateChainCleaner(X509TrustManager x509TrustManager) {
        X509TrustManagerExtensions x509TrustManagerExtensions;
        x509TrustManager.getClass();
        jd.b bVar = null;
        try {
            x509TrustManagerExtensions = new X509TrustManagerExtensions(x509TrustManager);
        } catch (IllegalArgumentException unused) {
            x509TrustManagerExtensions = null;
        }
        if (x509TrustManagerExtensions != null) {
            bVar = new jd.b();
            bVar.f6777a = x509TrustManager;
            bVar.f6778b = x509TrustManagerExtensions;
            VarHandle.storeStoreFence();
        }
        return bVar != null ? bVar : super.buildCertificateChainCleaner(x509TrustManager);
    }

    @Override // id.n
    public final void configureTlsExtensions(SSLSocket sSLSocket, String str, List list) {
        Object obj;
        sSLSocket.getClass();
        list.getClass();
        ArrayList arrayList = this.f5946a;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                obj = null;
                break;
            }
            obj = arrayList.get(i);
            i++;
            if (((jd.m) obj).a(sSLSocket)) {
                break;
            }
        }
        jd.m mVar = (jd.m) obj;
        if (mVar != null) {
            mVar.f(sSLSocket, str, list);
        }
    }

    @Override // id.n
    public final String getSelectedProtocol(SSLSocket sSLSocket) {
        Object obj;
        sSLSocket.getClass();
        ArrayList arrayList = this.f5946a;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                obj = null;
                break;
            }
            obj = arrayList.get(i);
            i++;
            if (((jd.m) obj).a(sSLSocket)) {
                break;
            }
        }
        jd.m mVar = (jd.m) obj;
        if (mVar != null) {
            return mVar.c(sSLSocket);
        }
        return null;
    }

    @Override // id.n
    public final boolean isCleartextTrafficPermitted(String str) {
        str.getClass();
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
    }

    @Override // id.n
    public final X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        Object obj;
        sSLSocketFactory.getClass();
        ArrayList arrayList = this.f5946a;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                obj = null;
                break;
            }
            obj = arrayList.get(i);
            i++;
            if (((jd.m) obj).e(sSLSocketFactory)) {
                break;
            }
        }
        jd.m mVar = (jd.m) obj;
        if (mVar != null) {
            return mVar.d(sSLSocketFactory);
        }
        return null;
    }
}
