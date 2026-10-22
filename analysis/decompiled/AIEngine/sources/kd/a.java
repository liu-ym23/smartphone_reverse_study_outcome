package kd;

import android.annotation.SuppressLint;
import android.net.http.X509TrustManagerExtensions;
import android.security.NetworkSecurityPolicy;
import android.util.CloseGuard;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kd.h;
import ld.i;
import ld.j;
import mb.l;
import okhttp3.Protocol;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a extends h {

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f9962b;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f9963a;

    static {
        h.Companion.getClass();
        f9962b = h.a.c();
    }

    public a() {
        h.Companion.getClass();
        int i10 = 0;
        ArrayList arrayListD0 = l.d0(new j[]{h.a.c() ? new ld.a() : null, new i(ld.f.f10422e), new i(ld.h.f10428a), new i(ld.g.f10427a)});
        ArrayList arrayList = new ArrayList();
        int size = arrayListD0.size();
        while (i10 < size) {
            Object obj = arrayListD0.get(i10);
            i10++;
            if (((j) obj).b()) {
                arrayList.add(obj);
            }
        }
        this.f9963a = arrayList;
    }

    @Override // kd.h
    public final od.c buildCertificateChainCleaner(X509TrustManager trustManager) {
        X509TrustManagerExtensions x509TrustManagerExtensions;
        kotlin.jvm.internal.g.f(trustManager, "trustManager");
        try {
            x509TrustManagerExtensions = new X509TrustManagerExtensions(trustManager);
        } catch (IllegalArgumentException unused) {
            x509TrustManagerExtensions = null;
        }
        ld.b bVar = x509TrustManagerExtensions != null ? new ld.b(trustManager, x509TrustManagerExtensions) : null;
        return bVar != null ? bVar : super.buildCertificateChainCleaner(trustManager);
    }

    @Override // kd.h
    public final void configureTlsExtensions(SSLSocket sslSocket, String str, List<? extends Protocol> protocols) {
        Object obj;
        kotlin.jvm.internal.g.f(sslSocket, "sslSocket");
        kotlin.jvm.internal.g.f(protocols, "protocols");
        ArrayList arrayList = this.f9963a;
        int size = arrayList.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                obj = null;
                break;
            }
            obj = arrayList.get(i10);
            i10++;
            if (((j) obj).a(sslSocket)) {
                break;
            }
        }
        j jVar = (j) obj;
        if (jVar != null) {
            jVar.f(sslSocket, str, protocols);
        }
    }

    @Override // kd.h
    public final String getSelectedProtocol(SSLSocket sslSocket) {
        Object obj;
        kotlin.jvm.internal.g.f(sslSocket, "sslSocket");
        ArrayList arrayList = this.f9963a;
        int size = arrayList.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                obj = null;
                break;
            }
            obj = arrayList.get(i10);
            i10++;
            if (((j) obj).a(sslSocket)) {
                break;
            }
        }
        j jVar = (j) obj;
        if (jVar != null) {
            return jVar.c(sslSocket);
        }
        return null;
    }

    @Override // kd.h
    public final Object getStackTraceForCloseable(String closer) {
        kotlin.jvm.internal.g.f(closer, "closer");
        CloseGuard closeGuard = new CloseGuard();
        closeGuard.open(closer);
        return closeGuard;
    }

    @Override // kd.h
    @SuppressLint({"NewApi"})
    public final boolean isCleartextTrafficPermitted(String hostname) {
        kotlin.jvm.internal.g.f(hostname, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(hostname);
    }

    @Override // kd.h
    public final void logCloseableLeak(String message, Object obj) {
        kotlin.jvm.internal.g.f(message, "message");
        kotlin.jvm.internal.g.d(obj, "null cannot be cast to non-null type android.util.CloseGuard");
        ((CloseGuard) obj).warnIfOpen();
    }

    @Override // kd.h
    public final X509TrustManager trustManager(SSLSocketFactory sslSocketFactory) {
        Object obj;
        kotlin.jvm.internal.g.f(sslSocketFactory, "sslSocketFactory");
        ArrayList arrayList = this.f9963a;
        int size = arrayList.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                obj = null;
                break;
            }
            obj = arrayList.get(i10);
            i10++;
            if (((j) obj).e(sslSocketFactory)) {
                break;
            }
        }
        j jVar = (j) obj;
        if (jVar != null) {
            return jVar.d(sslSocketFactory);
        }
        return null;
    }
}
