package jb;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
public class f implements m {

    /* renamed from: f, reason: collision with root package name */
    public static final e f5431f = new e();

    /* renamed from: a, reason: collision with root package name */
    public final Class f5432a;

    /* renamed from: b, reason: collision with root package name */
    public final Method f5433b;

    /* renamed from: c, reason: collision with root package name */
    public final Method f5434c;

    /* renamed from: d, reason: collision with root package name */
    public final Method f5435d;

    /* renamed from: e, reason: collision with root package name */
    public final Method f5436e;

    public f(Class cls) throws NoSuchMethodException, SecurityException {
        this.f5432a = cls;
        Method declaredMethod = cls.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE);
        q7.k.d(declaredMethod, "sslSocketClass.getDeclar…:class.javaPrimitiveType)");
        this.f5433b = declaredMethod;
        this.f5434c = cls.getMethod("setHostname", String.class);
        this.f5435d = cls.getMethod("getAlpnSelectedProtocol", null);
        this.f5436e = cls.getMethod("setAlpnProtocols", byte[].class);
    }

    @Override // jb.m
    public final boolean a(SSLSocket sSLSocket) {
        return this.f5432a.isInstance(sSLSocket);
    }

    @Override // jb.m
    public final String b(SSLSocket sSLSocket) {
        if (this.f5432a.isInstance(sSLSocket)) {
            try {
                byte[] bArr = (byte[]) this.f5435d.invoke(sSLSocket, null);
                if (bArr != null) {
                    return new String(bArr, ga.a.f4005a);
                }
            } catch (IllegalAccessException e10) {
                throw new AssertionError(e10);
            } catch (InvocationTargetException e11) {
                Throwable cause = e11.getCause();
                if (!(cause instanceof NullPointerException) || !q7.k.a(((NullPointerException) cause).getMessage(), "ssl == null")) {
                    throw new AssertionError(e11);
                }
            }
        }
        return null;
    }

    @Override // jb.m
    public final boolean c() {
        int i2 = ib.b.f5032c;
        return false;
    }

    @Override // jb.m
    public final void d(SSLSocket sSLSocket, String str, List list) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        q7.k.e(list, "protocols");
        if (this.f5432a.isInstance(sSLSocket)) {
            try {
                this.f5433b.invoke(sSLSocket, Boolean.TRUE);
                if (str != null) {
                    this.f5434c.invoke(sSLSocket, str);
                }
                Method method = this.f5436e;
                ib.m mVar = ib.m.f5049a;
                method.invoke(sSLSocket, ib.c.q(list));
            } catch (IllegalAccessException e10) {
                throw new AssertionError(e10);
            } catch (InvocationTargetException e11) {
                throw new AssertionError(e11);
            }
        }
    }
}
