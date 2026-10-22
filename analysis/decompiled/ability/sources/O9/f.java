package O9;

import j9.AbstractC1607a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes4.dex */
public class f implements m {
    public static final e f = new e();

    /* renamed from: a, reason: collision with root package name */
    public final Class f1048a;
    public final Method b;
    public final Method c;
    public final Method d;
    public final Method e;

    public f(Class cls) throws NoSuchMethodException, SecurityException {
        this.f1048a = cls;
        Method declaredMethod = cls.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE);
        kotlin.jvm.internal.k.e(declaredMethod, "sslSocketClass.getDeclar…:class.javaPrimitiveType)");
        this.b = declaredMethod;
        this.c = cls.getMethod("setHostname", String.class);
        this.d = cls.getMethod("getAlpnSelectedProtocol", null);
        this.e = cls.getMethod("setAlpnProtocols", byte[].class);
    }

    @Override // O9.m
    public final boolean a(SSLSocket sSLSocket) {
        return this.f1048a.isInstance(sSLSocket);
    }

    @Override // O9.m
    public final boolean b() {
        int i = N9.b.f1016a;
        return false;
    }

    @Override // O9.m
    public final String c(SSLSocket sSLSocket) {
        if (this.f1048a.isInstance(sSLSocket)) {
            try {
                byte[] bArr = (byte[]) this.d.invoke(sSLSocket, null);
                if (bArr != null) {
                    return new String(bArr, AbstractC1607a.f4778a);
                }
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e6) {
                Throwable cause = e6.getCause();
                if (!(cause instanceof NullPointerException) || !kotlin.jvm.internal.k.b(((NullPointerException) cause).getMessage(), "ssl == null")) {
                    throw new AssertionError(e6);
                }
            }
        }
        return null;
    }

    @Override // O9.m
    public X509TrustManager d(SSLSocketFactory sSLSocketFactory) {
        return null;
    }

    @Override // O9.m
    public boolean e(SSLSocketFactory sSLSocketFactory) {
        return false;
    }

    @Override // O9.m
    public final void f(SSLSocket sSLSocket, String str, List list) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.f1048a.isInstance(sSLSocket)) {
            try {
                this.b.invoke(sSLSocket, Boolean.TRUE);
                if (str != null) {
                    this.c.invoke(sSLSocket, str);
                }
                Method method = this.e;
                N9.m.Companion.getClass();
                method.invoke(sSLSocket, N9.l.b(list));
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e6) {
                throw new AssertionError(e6);
            }
        }
    }
}
