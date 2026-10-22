package jb;

import ga.r;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
public final class e implements k {
    @Override // jb.k
    public final boolean a(SSLSocket sSLSocket) {
        return r.g0(sSLSocket.getClass().getName(), "com.google.android.gms.org.conscrypt.", false);
    }

    @Override // jb.k
    public final m b(SSLSocket sSLSocket) {
        Class<?> cls = sSLSocket.getClass();
        Class<?> superclass = cls;
        while (!superclass.getSimpleName().equals("OpenSSLSocketImpl")) {
            superclass = superclass.getSuperclass();
            if (superclass == null) {
                throw new AssertionError(a1.a.g(cls, "No OpenSSLSocketImpl superclass of socket of type "));
            }
        }
        return new f(superclass);
    }
}
