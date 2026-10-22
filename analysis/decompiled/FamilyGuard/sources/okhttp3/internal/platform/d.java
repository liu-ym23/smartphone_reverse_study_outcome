package okhttp3.internal.platform;

import C4.B;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
class d extends f {

    /* renamed from: a, reason: collision with root package name */
    private final Method f19095a;

    /* renamed from: b, reason: collision with root package name */
    private final Method f19096b;

    /* renamed from: c, reason: collision with root package name */
    private final Method f19097c;

    /* renamed from: d, reason: collision with root package name */
    private final Class<?> f19098d;

    /* renamed from: e, reason: collision with root package name */
    private final Class<?> f19099e;

    private static class a implements InvocationHandler {

        /* renamed from: a, reason: collision with root package name */
        private final List<String> f19100a;

        /* renamed from: b, reason: collision with root package name */
        boolean f19101b;

        /* renamed from: c, reason: collision with root package name */
        String f19102c;

        a(List<String> list) {
            this.f19100a = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = D4.e.f1207b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f19101b = true;
                return null;
            }
            if (name.equals("protocols") && objArr.length == 0) {
                return this.f19100a;
            }
            if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1) {
                Object obj2 = objArr[0];
                if (obj2 instanceof List) {
                    List list = (List) obj2;
                    int size = list.size();
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = (String) list.get(i5);
                        if (this.f19100a.contains(str)) {
                            this.f19102c = str;
                            return str;
                        }
                    }
                    String str2 = this.f19100a.get(0);
                    this.f19102c = str2;
                    return str2;
                }
            }
            if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                return method.invoke(this, objArr);
            }
            this.f19102c = (String) objArr[0];
            return null;
        }
    }

    d(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f19095a = method;
        this.f19096b = method2;
        this.f19097c = method3;
        this.f19098d = cls;
        this.f19099e = cls2;
    }

    public static f a() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
            return new d(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod("get", SSLSocket.class), cls.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // okhttp3.internal.platform.f
    public void afterHandshake(SSLSocket sSLSocket) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            this.f19097c.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException e6) {
            throw new AssertionError("failed to remove ALPN", e6);
        }
    }

    @Override // okhttp3.internal.platform.f
    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<B> list) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            this.f19095a.invoke(null, sSLSocket, Proxy.newProxyInstance(f.class.getClassLoader(), new Class[]{this.f19098d, this.f19099e}, new a(f.alpnProtocolNames(list))));
        } catch (IllegalAccessException | InvocationTargetException e6) {
            throw new AssertionError("failed to set ALPN", e6);
        }
    }

    @Override // okhttp3.internal.platform.f
    @Nullable
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        try {
            a aVar = (a) Proxy.getInvocationHandler(this.f19096b.invoke(null, sSLSocket));
            boolean z5 = aVar.f19101b;
            if (!z5 && aVar.f19102c == null) {
                f.get().log(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", null);
                return null;
            }
            if (z5) {
                return null;
            }
            return aVar.f19102c;
        } catch (IllegalAccessException | InvocationTargetException e6) {
            throw new AssertionError("failed to get ALPN selected protocol", e6);
        }
    }
}
