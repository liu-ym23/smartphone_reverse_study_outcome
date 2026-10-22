package id;

import java.lang.invoke.VarHandle;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i extends n {

    /* renamed from: a, reason: collision with root package name */
    public Method f5957a;

    /* renamed from: b, reason: collision with root package name */
    public Method f5958b;

    /* renamed from: c, reason: collision with root package name */
    public Method f5959c;

    /* renamed from: d, reason: collision with root package name */
    public Class f5960d;

    /* renamed from: e, reason: collision with root package name */
    public Class f5961e;

    @Override // id.n
    public final void afterHandshake(SSLSocket sSLSocket) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        sSLSocket.getClass();
        try {
            this.f5959c.invoke(null, sSLSocket);
        } catch (IllegalAccessException e10) {
            throw new AssertionError("failed to remove ALPN", e10);
        } catch (InvocationTargetException e11) {
            throw new AssertionError("failed to remove ALPN", e11);
        }
    }

    @Override // id.n
    public final void configureTlsExtensions(SSLSocket sSLSocket, String str, List list) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        sSLSocket.getClass();
        list.getClass();
        n.Companion.getClass();
        ArrayList arrayListA = m.a(list);
        try {
            ClassLoader classLoader = n.class.getClassLoader();
            Class[] clsArr = {this.f5960d, this.f5961e};
            h hVar = new h();
            hVar.f5954a = arrayListA;
            VarHandle.storeStoreFence();
            this.f5957a.invoke(null, sSLSocket, Proxy.newProxyInstance(classLoader, clsArr, hVar));
        } catch (IllegalAccessException e10) {
            throw new AssertionError("failed to set ALPN", e10);
        } catch (InvocationTargetException e11) {
            throw new AssertionError("failed to set ALPN", e11);
        }
    }

    @Override // id.n
    public final String getSelectedProtocol(SSLSocket sSLSocket) throws IllegalArgumentException {
        sSLSocket.getClass();
        try {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(this.f5958b.invoke(null, sSLSocket));
            invocationHandler.getClass();
            h hVar = (h) invocationHandler;
            boolean z10 = hVar.f5955b;
            if (!z10 && hVar.f5956c == null) {
                n.log$default(this, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", 0, null, 6, null);
                return null;
            }
            if (z10) {
                return null;
            }
            return hVar.f5956c;
        } catch (IllegalAccessException e10) {
            throw new AssertionError("failed to get ALPN selected protocol", e10);
        } catch (InvocationTargetException e11) {
            throw new AssertionError("failed to get ALPN selected protocol", e11);
        }
    }
}
