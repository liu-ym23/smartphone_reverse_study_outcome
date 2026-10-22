package jd;

import id.n;
import java.lang.invoke.VarHandle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class f implements m {

    /* renamed from: f, reason: collision with root package name */
    public static final e f6782f;

    /* renamed from: a, reason: collision with root package name */
    public Class f6783a;

    /* renamed from: b, reason: collision with root package name */
    public Method f6784b;

    /* renamed from: c, reason: collision with root package name */
    public Method f6785c;

    /* renamed from: d, reason: collision with root package name */
    public Method f6786d;

    /* renamed from: e, reason: collision with root package name */
    public Method f6787e;

    static {
        e eVar = new e();
        VarHandle.storeStoreFence();
        f6782f = eVar;
    }

    @Override // jd.m
    public final boolean a(SSLSocket sSLSocket) {
        return this.f6783a.isInstance(sSLSocket);
    }

    @Override // jd.m
    public final boolean b() {
        int i = id.b.f5947a;
        return false;
    }

    @Override // jd.m
    public final String c(SSLSocket sSLSocket) {
        if (this.f6783a.isInstance(sSLSocket)) {
            try {
                byte[] bArr = (byte[]) this.f6786d.invoke(sSLSocket, null);
                if (bArr != null) {
                    return new String(bArr, hc.a.f5448a);
                }
            } catch (IllegalAccessException e10) {
                throw new AssertionError(e10);
            } catch (InvocationTargetException e11) {
                Throwable cause = e11.getCause();
                if (!(cause instanceof NullPointerException) || !yb.k.a(((NullPointerException) cause).getMessage(), "ssl == null")) {
                    throw new AssertionError(e11);
                }
            }
        }
        return null;
    }

    @Override // jd.m
    public X509TrustManager d(SSLSocketFactory sSLSocketFactory) {
        return null;
    }

    @Override // jd.m
    public boolean e(SSLSocketFactory sSLSocketFactory) {
        return false;
    }

    @Override // jd.m
    public final void f(SSLSocket sSLSocket, String str, List list) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.f6783a.isInstance(sSLSocket)) {
            try {
                this.f6784b.invoke(sSLSocket, Boolean.TRUE);
                if (str != null) {
                    this.f6785c.invoke(sSLSocket, str);
                }
                Method method = this.f6787e;
                n.Companion.getClass();
                method.invoke(sSLSocket, id.m.b(list));
            } catch (IllegalAccessException e10) {
                throw new AssertionError(e10);
            } catch (InvocationTargetException e11) {
                throw new AssertionError(e11);
            }
        }
    }
}
