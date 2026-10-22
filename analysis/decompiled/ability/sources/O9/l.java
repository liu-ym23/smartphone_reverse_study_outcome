package O9;

import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes4.dex */
public final class l implements m {

    /* renamed from: a, reason: collision with root package name */
    public final k f1051a;
    public m b;

    public l(k kVar) {
        this.f1051a = kVar;
    }

    @Override // O9.m
    public final boolean a(SSLSocket sSLSocket) {
        return this.f1051a.a(sSLSocket);
    }

    @Override // O9.m
    public final boolean b() {
        return true;
    }

    @Override // O9.m
    public final String c(SSLSocket sSLSocket) {
        m mVarG = g(sSLSocket);
        if (mVarG != null) {
            return mVarG.c(sSLSocket);
        }
        return null;
    }

    @Override // O9.m
    public final X509TrustManager d(SSLSocketFactory sSLSocketFactory) {
        return null;
    }

    @Override // O9.m
    public final boolean e(SSLSocketFactory sSLSocketFactory) {
        return false;
    }

    @Override // O9.m
    public final void f(SSLSocket sSLSocket, String str, List list) {
        m mVarG = g(sSLSocket);
        if (mVarG != null) {
            mVarG.f(sSLSocket, str, list);
        }
    }

    public final synchronized m g(SSLSocket sSLSocket) {
        try {
            if (this.b == null && this.f1051a.a(sSLSocket)) {
                this.b = this.f1051a.b(sSLSocket);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.b;
    }
}
