package okhttp3.internal.platform;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes5.dex */
class JdkWithJettyBootPlatform extends Platform {
    private final Class<?> clientProviderClass;
    private final Method getMethod;
    private final Method putMethod;
    private final Method removeMethod;
    private final Class<?> serverProviderClass;

    private static class JettyNegoProvider implements InvocationHandler {
        private final List<String> protocols;
        String selected;
        boolean unsupported;

        JettyNegoProvider(List<String> r1) {
            this.protocols = r1;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object r6, Method r7, Object[] r8) throws Throwable {
            String r9 = r7.getName();
            Class<?> r0 = r7.getReturnType();
            if (r8 != null) goto L6;
            r8 = Util.EMPTY_STRING_ARRAY;
        L6:
            if (r9.equals("supports") == false) goto L12;
            if (Boolean.TYPE != r0) goto L12;
            return true;
        L12:
            if (r9.equals("unsupported") == false) goto L18;
            if (Void.TYPE != r0) goto L18;
            this.unsupported = true;
            return null;
        L18:
            if (r9.equals("protocols") == false) goto L24;
            if (r8.length != 0) goto L24;
            return this.protocols;
        L24:
            if (r9.equals("selectProtocol") == true) goto L28;
            if (r9.equals("select") == true) goto L28;
        L43:
            if (r9.equals("protocolSelected") == true) goto L47;
            if (r9.equals("selected") == true) goto L47;
        L51:
            return r7.invoke(this, r8);
        L47:
            if (r8.length != 1) goto L51;
            this.selected = (String) r8[0];
            return null;
        L28:
            if (String.class != r0) goto L43;
            if (r8.length != 1) goto L43;
            Object r1 = r8[0];
            if ((r1 instanceof List) == false) goto L43;
            List r2 = (List) r1;
            int r10 = r2.size();
            int r11 = 0;
        L34:
            if (r11 >= r10) goto L40;
            if (this.protocols.contains(r2.get(r11)) == true) goto L37;
            r11 = r11 + 1;
            goto L34
        L37:
            String r12 = (String) r2.get(r11);
            this.selected = r12;
            return r12;
        L40:
            String r13 = this.protocols.get(0);
            this.selected = r13;
            return r13;
        }
    }

    JdkWithJettyBootPlatform(Method r1, Method r2, Method r3, Class<?> r4, Class<?> r5) {
        this.putMethod = r1;
        this.getMethod = r2;
        this.removeMethod = r3;
        this.clientProviderClass = r4;
        this.serverProviderClass = r5;
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(SSLSocket r6, String r7, List<Protocol> r8) {
        List<String> r9 = alpnProtocolNames(r8);
        Object r10 = Proxy.newProxyInstance(Platform.class.getClassLoader(), new Class[]{this.clientProviderClass, this.serverProviderClass}, new JettyNegoProvider(r9));     // Catch: Throwable -> L5
        this.putMethod.invoke(null, new Object[]{r6, r10});     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        throw Util.assertionError("unable to set alpn", e);
    }

    @Override // okhttp3.internal.platform.Platform
    public void afterHandshake(SSLSocket r3) {
        this.removeMethod.invoke(null, new Object[]{r3});     // Catch: Throwable -> L4
        return;
    L4:
        e = move-exception;
        throw Util.assertionError("unable to remove alpn", e);
    }

    @Override // okhttp3.internal.platform.Platform
    @Nullable
    public String getSelectedProtocol(SSLSocket r3) {
        JettyNegoProvider r2 = (JettyNegoProvider) Proxy.getInvocationHandler(this.getMethod.invoke(null, new Object[]{r3}));     // Catch: Throwable -> L13
        if (r2.unsupported == true) goto L9;
        if (r2.selected != null) goto L9;
        Platform.get().log(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", null);     // Catch: Throwable -> L13
        return null;
    L9:
        if (r2.unsupported == false) goto L12;
        return null;
    L12:
        return r2.selected;
    L13:
        e = move-exception;
        throw Util.assertionError("unable to get selected protocol", e);
    }

    public static Platform buildIfSupported() {
        Class<?> r0 = Class.forName("org.eclipse.jetty.alpn.ALPN");     // Catch: Throwable -> L4
        Class<?> r1 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");     // Catch: Throwable -> L4
        Class<?> r7 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider");     // Catch: Throwable -> L4
        Class<?> r8 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider");     // Catch: Throwable -> L4
        return new JdkWithJettyBootPlatform(r0.getMethod("put", new Class[]{SSLSocket.class, r1}), r0.getMethod("get", new Class[]{SSLSocket.class}), r0.getMethod("remove", new Class[]{SSLSocket.class}), r7, r8);
    L4:
        return null;
    }
}
