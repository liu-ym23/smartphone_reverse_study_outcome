package O9;

import j9.t;
import javax.net.ssl.SSLSocket;

/* loaded from: classes4.dex */
public final class e implements k {
    @Override // O9.k
    public final boolean a(SSLSocket sSLSocket) {
        return t.e0(sSLSocket.getClass().getName(), "com.google.android.gms.org.conscrypt.", false);
    }

    @Override // O9.k
    public final m b(SSLSocket sSLSocket) {
        Class<?> cls = sSLSocket.getClass();
        Class<?> superclass = cls;
        while (!superclass.getSimpleName().equals("OpenSSLSocketImpl")) {
            superclass = superclass.getSuperclass();
            if (superclass == null) {
                throw new AssertionError(B7.a.i(cls, "No OpenSSLSocketImpl superclass of socket of type "));
            }
        }
        return new f(superclass);
    }
}
