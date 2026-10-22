package ib;

import android.net.http.X509TrustManagerExtensions;
import android.security.NetworkSecurityPolicy;
import d7.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import w7.e0;

/* loaded from: classes.dex */
public final class a extends m {

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f5030d = c.D();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f5031c;

    public a() {
        ArrayList arrayListV0 = s.v0(c.D() ? new jb.a() : null, new jb.l(jb.f.f5431f), new jb.l(jb.j.f5438a), new jb.l(jb.h.f5437a));
        ArrayList arrayList = new ArrayList();
        Iterator it = arrayListV0.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (((jb.m) next).c()) {
                arrayList.add(next);
            }
        }
        this.f5031c = arrayList;
    }

    @Override // ib.m
    public final e0 b(X509TrustManager x509TrustManager) {
        X509TrustManagerExtensions x509TrustManagerExtensions;
        try {
            x509TrustManagerExtensions = new X509TrustManagerExtensions(x509TrustManager);
        } catch (IllegalArgumentException unused) {
            x509TrustManagerExtensions = null;
        }
        jb.b bVar = x509TrustManagerExtensions != null ? new jb.b(x509TrustManager, x509TrustManagerExtensions) : null;
        return bVar != null ? bVar : new mb.a(c(x509TrustManager));
    }

    @Override // ib.m
    public final void d(SSLSocket sSLSocket, String str, List list) {
        Object next;
        q7.k.e(list, "protocols");
        Iterator it = this.f5031c.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((jb.m) next).a(sSLSocket)) {
                    break;
                }
            }
        }
        jb.m mVar = (jb.m) next;
        if (mVar != null) {
            mVar.d(sSLSocket, str, list);
        }
    }

    @Override // ib.m
    public final String e(SSLSocket sSLSocket) {
        Object next;
        Iterator it = this.f5031c.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((jb.m) next).a(sSLSocket)) {
                break;
            }
        }
        jb.m mVar = (jb.m) next;
        if (mVar != null) {
            return mVar.b(sSLSocket);
        }
        return null;
    }

    @Override // ib.m
    public final boolean f(String str) {
        q7.k.e(str, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
    }
}
