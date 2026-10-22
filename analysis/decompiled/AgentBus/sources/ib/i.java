package ib;

import ab.u;
import d7.t;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
public final class i extends m {

    /* renamed from: c, reason: collision with root package name */
    public final Method f5041c;

    /* renamed from: d, reason: collision with root package name */
    public final Method f5042d;

    /* renamed from: e, reason: collision with root package name */
    public final Method f5043e;

    /* renamed from: f, reason: collision with root package name */
    public final Class f5044f;

    /* renamed from: g, reason: collision with root package name */
    public final Class f5045g;

    public i(Method method, Method method2, Method method3, Class cls, Class cls2) {
        this.f5041c = method;
        this.f5042d = method2;
        this.f5043e = method3;
        this.f5044f = cls;
        this.f5045g = cls2;
    }

    @Override // ib.m
    public final void a(SSLSocket sSLSocket) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            this.f5043e.invoke(null, sSLSocket);
        } catch (IllegalAccessException e10) {
            throw new AssertionError("failed to remove ALPN", e10);
        } catch (InvocationTargetException e11) {
            throw new AssertionError("failed to remove ALPN", e11);
        }
    }

    @Override // ib.m
    public final void d(SSLSocket sSLSocket, String str, List list) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        q7.k.e(list, "protocols");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((u) obj) != u.HTTP_1_0) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(t.A0(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((u) it.next()).f655f);
        }
        try {
            this.f5041c.invoke(null, sSLSocket, Proxy.newProxyInstance(m.class.getClassLoader(), new Class[]{this.f5044f, this.f5045g}, new h(arrayList2)));
        } catch (IllegalAccessException e10) {
            throw new AssertionError("failed to set ALPN", e10);
        } catch (InvocationTargetException e11) {
            throw new AssertionError("failed to set ALPN", e11);
        }
    }

    @Override // ib.m
    public final String e(SSLSocket sSLSocket) throws IllegalArgumentException {
        try {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(this.f5042d.invoke(null, sSLSocket));
            q7.k.c(invocationHandler, "null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");
            h hVar = (h) invocationHandler;
            boolean z4 = hVar.f5039b;
            if (!z4 && hVar.f5040c == null) {
                m.g(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", null);
                return null;
            }
            if (z4) {
                return null;
            }
            return hVar.f5040c;
        } catch (IllegalAccessException e10) {
            throw new AssertionError("failed to get ALPN selected protocol", e10);
        } catch (InvocationTargetException e11) {
            throw new AssertionError("failed to get ALPN selected protocol", e11);
        }
    }
}
