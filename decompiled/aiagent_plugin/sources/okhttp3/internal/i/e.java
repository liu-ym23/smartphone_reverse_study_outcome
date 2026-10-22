package okhttp3.internal.i;

import com.bytedance.security.zenmobile.io.SensitiveType;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import okhttp3.aa;

/* JADX INFO: compiled from: Jdk8WithJettyBootPlatform.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class e extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f40134a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Method f40135c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Method f40136d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Method f40137e;
    private final Class<?> f;
    private final Class<?> g;

    /* JADX INFO: compiled from: Jdk8WithJettyBootPlatform.kt */
    private static final class a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<String> f40138a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f40139b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f40140c;

        public a(List<String> r3) {
            List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            o.e(r4, "protocols");
            this.f40138a = r4;
        }

        public final boolean a() {
            return this.f40139b;
        }

        public final String b() {
            return this.f40140c;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object r8, Method r9, Object[] r10) {
            o.e(r8, "proxy");
            o.e(r9, "method");
            if (r10 != null) goto L5;
            r10 = new Object[0];
        L5:
            String r0 = r9.getName();
            Class<?> r1 = r9.getReturnType();
            if (o.a(r0, "supports") == false) goto L12;
            if (o.a(Boolean.TYPE, r1) == false) goto L12;
            return true;
        L12:
            if (o.a(r0, "unsupported") == false) goto L18;
            if (o.a(Void.TYPE, r1) == false) goto L18;
            this.f40139b = true;
            return null;
        L18:
            if (o.a(r0, "protocols") == false) goto L27;
            if (r10.length != 0) goto L22;
            boolean r2 = true;
        L23:
            if (r2 == false) goto L27;
            return this.f40138a;
        L22:
            r2 = false;
        L27:
            if (o.a(r0, "selectProtocol") == true) goto L31;
            if (o.a(r0, "select") == true) goto L31;
        L48:
            if (o.a(r0, "protocolSelected") == true) goto L52;
            if (o.a(r0, "selected") == true) goto L52;
        L56:
            return r9.invoke(this, Arrays.copyOf(r10, r10.length));
        L52:
            if (r10.length != 1) goto L56;
            Object r11 = r10[0];
            o.a(r11, "null cannot be cast to non-null type kotlin.String");
            this.f40140c = (String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.aiagent.plugin");
            return null;
        L31:
            if (o.a(String.class, r1) == false) goto L48;
            if (r10.length != 1) goto L48;
            if (ZeusTransformUtils.instanceOf(r10[0], List.class) == false) goto L48;
            Object r12 = r10[0];
            o.a(r12, "null cannot be cast to non-null type kotlin.collections.List<*>");
            List r13 = (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.aiagent.plugin");
            int r14 = r13.size();
            if (r14 < 0) goto L45;
            int r3 = 0;
        L39:
            Object r4 = r13.get(r3);
            o.a(r4, "null cannot be cast to non-null type kotlin.String");
            String r5 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin");
            if (this.f40138a.contains(r5) == true) goto L41;
            if (r3 == r14) goto L45;
            r3 = r3 + 1;
            goto L39
        L41:
            this.f40140c = r5;
            return r5;
        L45:
            String r15 = (String) ZeusTransformUtils.preCheckCast(this.f40138a.get(0), String.class, "com.obric.aiagent.plugin");
            this.f40140c = r15;
            return r15;
        }
    }

    /* JADX INFO: compiled from: Jdk8WithJettyBootPlatform.kt */
    public static final class b {
        public /* synthetic */ b(d.h.b.h r1) {
            this();
        }

        private b() {
        }

        public final h a() {
            String r11 = System.getProperty("java.specification.version", SensitiveType.UNKNOWN);
            o.c(r11, "jvmVersion");     // Catch: NumberFormatException -> L10
            if (Integer.parseInt(r11) < 9) goto L13;
            return null;
        L13:
            Class<?> r2 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);     // Catch: Throwable -> L9
            Class<?> r3 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);     // Catch: Throwable -> L9
            Class<?> r9 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);     // Catch: Throwable -> L9
            Class<?> r10 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);     // Catch: Throwable -> L9
            Method r12 = r2.getMethod("put", new Class[]{SSLSocket.class, r3});     // Catch: Throwable -> L9
            Method r7 = r2.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{SSLSocket.class});     // Catch: Throwable -> L9
            Method r8 = r2.getMethod("remove", new Class[]{SSLSocket.class});     // Catch: Throwable -> L9
            o.c(r12, "putMethod");     // Catch: Throwable -> L9
            o.c(r7, "getMethod");     // Catch: Throwable -> L9
            o.c(r8, "removeMethod");     // Catch: Throwable -> L9
            o.c(r9, "clientProviderClass");     // Catch: Throwable -> L9
            o.c(r10, "serverProviderClass");     // Catch: Throwable -> L9
            return (h) ZeusTransformUtils.preCheckCast(new e(r12, r7, r8, r9, r10), h.class, "com.obric.aiagent.plugin");
        L9:
            return null;
        }
    }

    static {
        f40134a = new b(null);
    }

    public e(Method r2, Method r3, Method r4, Class<?> r5, Class<?> r6) {
        o.e(r2, "putMethod");
        o.e(r3, "getMethod");
        o.e(r4, "removeMethod");
        o.e(r5, "clientProviderClass");
        o.e(r6, "serverProviderClass");
        this.f40135c = r2;
        this.f40136d = r3;
        this.f40137e = r4;
        this.f = r5;
        this.g = r6;
    }

    @Override // okhttp3.internal.i.h
    public void a(SSLSocket r8, String r9, List<? extends aa> r10) {
        List<? extends aa> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        o.e(r8, "sslSocket");
        o.e(r11, "protocols");
        List<String> r12 = h.f40147b.a(r11);
        Object r13 = Proxy.newProxyInstance(h.class.getClassLoader(), new Class[]{this.f, this.g}, (InvocationHandler) ZeusTransformUtils.preCheckCast(new a(r12), InvocationHandler.class, "com.obric.aiagent.plugin"));     // Catch: IllegalAccessException -> L5 InvocationTargetException -> L8
        this.f40135c.invoke(null, new Object[]{r8, r13});     // Catch: IllegalAccessException -> L5 InvocationTargetException -> L8
        return;
    L5:
        e = move-exception;
        throw new AssertionError("failed to set ALPN", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L8:
        e = move-exception;
        throw new AssertionError("failed to set ALPN", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    @Override // okhttp3.internal.i.h
    public void b(SSLSocket r6) {
        o.e(r6, "sslSocket");
        this.f40137e.invoke(null, new Object[]{r6});     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L8
        return;
    L8:
        e = move-exception;
        throw new AssertionError("failed to remove ALPN", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L5:
        e = move-exception;
        throw new AssertionError("failed to remove ALPN", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    @Override // okhttp3.internal.i.h
    public String a(SSLSocket r9) {
        o.e(r9, "sslSocket");
        InvocationHandler r2 = Proxy.getInvocationHandler(this.f40136d.invoke(null, new Object[]{r9}));     // Catch: IllegalAccessException -> L14 InvocationTargetException -> L17
        o.a(r2, "null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");     // Catch: IllegalAccessException -> L14 InvocationTargetException -> L17
        a r3 = (a) ZeusTransformUtils.preCheckCast(r2, a.class, "com.obric.aiagent.plugin");     // Catch: IllegalAccessException -> L14 InvocationTargetException -> L17
        if (r3.a() == true) goto L10;
        if (r3.b() != null) goto L10;
        h.a((h) ZeusTransformUtils.preCheckCast(this, h.class, "com.obric.aiagent.plugin"), "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", 0, null, 6, null);     // Catch: IllegalAccessException -> L14 InvocationTargetException -> L17
        return null;
    L10:
        if (r3.a() == false) goto L13;
        return null;
    L13:
        return r3.b();
    L14:
        e = move-exception;
        throw new AssertionError("failed to get ALPN selected protocol", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L17:
        e = move-exception;
        throw new AssertionError("failed to get ALPN selected protocol", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }
}
