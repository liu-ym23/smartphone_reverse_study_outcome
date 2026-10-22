package N9;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* loaded from: classes4.dex */
public final class h extends m {

    /* renamed from: a, reason: collision with root package name */
    public final Method f1021a;
    public final Method b;
    public final Method c;
    public final Class d;
    public final Class e;

    public h(Method method, Method method2, Method method3, Class cls, Class cls2) {
        this.f1021a = method;
        this.b = method2;
        this.c = method3;
        this.d = cls;
        this.e = cls2;
    }

    @Override // N9.m
    public final void afterHandshake(SSLSocket sslSocket) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        kotlin.jvm.internal.k.f(sslSocket, "sslSocket");
        try {
            this.c.invoke(null, sslSocket);
        } catch (IllegalAccessException e) {
            throw new AssertionError("failed to remove ALPN", e);
        } catch (InvocationTargetException e6) {
            throw new AssertionError("failed to remove ALPN", e6);
        }
    }

    @Override // N9.m
    public final void configureTlsExtensions(SSLSocket sslSocket, String str, List protocols) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        kotlin.jvm.internal.k.f(sslSocket, "sslSocket");
        kotlin.jvm.internal.k.f(protocols, "protocols");
        m.Companion.getClass();
        try {
            this.f1021a.invoke(null, sslSocket, Proxy.newProxyInstance(m.class.getClassLoader(), new Class[]{this.d, this.e}, new g(l.a(protocols))));
        } catch (IllegalAccessException e) {
            throw new AssertionError("failed to set ALPN", e);
        } catch (InvocationTargetException e6) {
            throw new AssertionError("failed to set ALPN", e6);
        }
    }

    @Override // N9.m
    public final String getSelectedProtocol(SSLSocket sslSocket) throws IllegalArgumentException {
        kotlin.jvm.internal.k.f(sslSocket, "sslSocket");
        try {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(this.b.invoke(null, sslSocket));
            kotlin.jvm.internal.k.d(invocationHandler, "null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");
            g gVar = (g) invocationHandler;
            boolean z10 = gVar.b;
            if (!z10 && gVar.c == null) {
                m.log$default(this, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", 0, null, 6, null);
                return null;
            }
            if (z10) {
                return null;
            }
            return gVar.c;
        } catch (IllegalAccessException e) {
            throw new AssertionError("failed to get ALPN selected protocol", e);
        } catch (InvocationTargetException e6) {
            throw new AssertionError("failed to get ALPN selected protocol", e6);
        }
    }
}
