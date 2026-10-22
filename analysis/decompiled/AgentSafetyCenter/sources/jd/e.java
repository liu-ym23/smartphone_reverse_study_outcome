package jd;

import hc.o;
import java.lang.invoke.VarHandle;
import java.lang.reflect.Method;
import javax.net.ssl.SSLSocket;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e implements k {
    @Override // jd.k
    public final boolean a(SSLSocket sSLSocket) {
        return o.U(sSLSocket.getClass().getName(), "com.google.android.gms.org.conscrypt.", false);
    }

    @Override // jd.k
    public final m b(SSLSocket sSLSocket) throws NoSuchMethodException, SecurityException {
        Class<?> cls = sSLSocket.getClass();
        Class<?> superclass = cls;
        while (!superclass.getSimpleName().equals("OpenSSLSocketImpl")) {
            superclass = superclass.getSuperclass();
            if (superclass == null) {
                throw new AssertionError("No OpenSSLSocketImpl superclass of socket of type " + cls);
            }
        }
        f fVar = new f();
        fVar.f6783a = superclass;
        Method declaredMethod = superclass.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE);
        declaredMethod.getClass();
        fVar.f6784b = declaredMethod;
        fVar.f6785c = superclass.getMethod("setHostname", String.class);
        fVar.f6786d = superclass.getMethod("getAlpnSelectedProtocol", null);
        fVar.f6787e = superclass.getMethod("setAlpnProtocols", byte[].class);
        VarHandle.storeStoreFence();
        return fVar;
    }
}
