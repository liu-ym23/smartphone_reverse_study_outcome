package jd;

import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l implements m {

    /* renamed from: a, reason: collision with root package name */
    public k f6790a;

    /* renamed from: b, reason: collision with root package name */
    public m f6791b;

    @Override // jd.m
    public final boolean a(SSLSocket sSLSocket) {
        return this.f6790a.a(sSLSocket);
    }

    @Override // jd.m
    public final boolean b() {
        return true;
    }

    @Override // jd.m
    public final String c(SSLSocket sSLSocket) {
        m mVarG = g(sSLSocket);
        if (mVarG != null) {
            return mVarG.c(sSLSocket);
        }
        return null;
    }

    @Override // jd.m
    public final X509TrustManager d(SSLSocketFactory sSLSocketFactory) {
        return null;
    }

    @Override // jd.m
    public final boolean e(SSLSocketFactory sSLSocketFactory) {
        return false;
    }

    @Override // jd.m
    public final void f(SSLSocket sSLSocket, String str, List list) {
        m mVarG = g(sSLSocket);
        if (mVarG != null) {
            mVarG.f(sSLSocket, str, list);
        }
    }

    public final synchronized m g(SSLSocket sSLSocket) {
        try {
            if (this.f6791b == null && this.f6790a.a(sSLSocket)) {
                this.f6791b = this.f6790a.b(sSLSocket);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f6791b;
    }
}
