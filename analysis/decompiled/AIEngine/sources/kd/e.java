package kd;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kd.h;
import okhttp3.Protocol;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e extends h {

    /* renamed from: a, reason: collision with root package name */
    public final Method f9970a;

    /* renamed from: b, reason: collision with root package name */
    public final Method f9971b;

    /* renamed from: c, reason: collision with root package name */
    public final Method f9972c;

    /* renamed from: d, reason: collision with root package name */
    public final Class<?> f9973d;

    /* renamed from: e, reason: collision with root package name */
    public final Class<?> f9974e;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements InvocationHandler {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f9975a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f9976b;

        /* renamed from: c, reason: collision with root package name */
        public String f9977c;

        public a(ArrayList arrayList) {
            this.f9975a = arrayList;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object proxy, Method method, Object[] objArr) {
            kotlin.jvm.internal.g.f(proxy, "proxy");
            kotlin.jvm.internal.g.f(method, "method");
            if (objArr == null) {
                objArr = new Object[0];
            }
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (kotlin.jvm.internal.g.b(name, "supports") && kotlin.jvm.internal.g.b(Boolean.TYPE, returnType)) {
                return Boolean.TRUE;
            }
            if (kotlin.jvm.internal.g.b(name, "unsupported") && kotlin.jvm.internal.g.b(Void.TYPE, returnType)) {
                this.f9976b = true;
                return null;
            }
            boolean zB = kotlin.jvm.internal.g.b(name, "protocols");
            ArrayList arrayList = this.f9975a;
            if (zB && objArr.length == 0) {
                return arrayList;
            }
            if ((kotlin.jvm.internal.g.b(name, "selectProtocol") || kotlin.jvm.internal.g.b(name, "select")) && String.class.equals(returnType) && objArr.length == 1) {
                Object obj = objArr[0];
                if (obj instanceof List) {
                    List list = (List) obj;
                    int size = list.size();
                    if (size >= 0) {
                        int i10 = 0;
                        while (true) {
                            Object obj2 = list.get(i10);
                            kotlin.jvm.internal.g.d(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj2;
                            if (!arrayList.contains(str)) {
                                if (i10 == size) {
                                    break;
                                }
                                i10++;
                            } else {
                                this.f9977c = str;
                                return str;
                            }
                        }
                    }
                    String str2 = (String) arrayList.get(0);
                    this.f9977c = str2;
                    return str2;
                }
            }
            if ((!kotlin.jvm.internal.g.b(name, "protocolSelected") && !kotlin.jvm.internal.g.b(name, "selected")) || objArr.length != 1) {
                return method.invoke(this, Arrays.copyOf(objArr, objArr.length));
            }
            Object obj3 = objArr[0];
            kotlin.jvm.internal.g.d(obj3, "null cannot be cast to non-null type kotlin.String");
            this.f9977c = (String) obj3;
            return null;
        }
    }

    public e(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f9970a = method;
        this.f9971b = method2;
        this.f9972c = method3;
        this.f9973d = cls;
        this.f9974e = cls2;
    }

    @Override // kd.h
    public final void afterHandshake(SSLSocket sslSocket) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        kotlin.jvm.internal.g.f(sslSocket, "sslSocket");
        try {
            this.f9972c.invoke(null, sslSocket);
        } catch (IllegalAccessException e10) {
            throw new AssertionError("failed to remove ALPN", e10);
        } catch (InvocationTargetException e11) {
            throw new AssertionError("failed to remove ALPN", e11);
        }
    }

    @Override // kd.h
    public final void configureTlsExtensions(SSLSocket sslSocket, String str, List<? extends Protocol> protocols) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        kotlin.jvm.internal.g.f(sslSocket, "sslSocket");
        kotlin.jvm.internal.g.f(protocols, "protocols");
        h.Companion.getClass();
        try {
            this.f9970a.invoke(null, sslSocket, Proxy.newProxyInstance(h.class.getClassLoader(), new Class[]{this.f9973d, this.f9974e}, new a(h.a.a(protocols))));
        } catch (IllegalAccessException e10) {
            throw new AssertionError("failed to set ALPN", e10);
        } catch (InvocationTargetException e11) {
            throw new AssertionError("failed to set ALPN", e11);
        }
    }

    @Override // kd.h
    public final String getSelectedProtocol(SSLSocket sslSocket) throws IllegalArgumentException {
        kotlin.jvm.internal.g.f(sslSocket, "sslSocket");
        try {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(this.f9971b.invoke(null, sslSocket));
            kotlin.jvm.internal.g.d(invocationHandler, "null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");
            a aVar = (a) invocationHandler;
            boolean z = aVar.f9976b;
            if (!z && aVar.f9977c == null) {
                h.log$default(this, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", 0, null, 6, null);
                return null;
            }
            if (z) {
                return null;
            }
            return aVar.f9977c;
        } catch (IllegalAccessException e10) {
            throw new AssertionError("failed to get ALPN selected protocol", e10);
        } catch (InvocationTargetException e11) {
            throw new AssertionError("failed to get ALPN selected protocol", e11);
        }
    }
}
