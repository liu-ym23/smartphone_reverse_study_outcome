package jb;

import java.util.List;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
public final class l implements m {

    /* renamed from: a, reason: collision with root package name */
    public final k f5439a;

    /* renamed from: b, reason: collision with root package name */
    public m f5440b;

    public l(k kVar) {
        this.f5439a = kVar;
    }

    @Override // jb.m
    public final boolean a(SSLSocket sSLSocket) {
        return this.f5439a.a(sSLSocket);
    }

    @Override // jb.m
    public final String b(SSLSocket sSLSocket) {
        m mVarE = e(sSLSocket);
        if (mVarE != null) {
            return mVarE.b(sSLSocket);
        }
        return null;
    }

    @Override // jb.m
    public final boolean c() {
        return true;
    }

    @Override // jb.m
    public final void d(SSLSocket sSLSocket, String str, List list) {
        q7.k.e(list, "protocols");
        m mVarE = e(sSLSocket);
        if (mVarE != null) {
            mVarE.d(sSLSocket, str, list);
        }
    }

    public final synchronized m e(SSLSocket sSLSocket) {
        try {
            if (this.f5440b == null && this.f5439a.a(sSLSocket)) {
                this.f5440b = this.f5439a.b(sSLSocket);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f5440b;
    }
}
