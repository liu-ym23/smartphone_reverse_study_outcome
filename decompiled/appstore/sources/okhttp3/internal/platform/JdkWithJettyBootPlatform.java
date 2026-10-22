package okhttp3.internal.platform;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes4.dex */
class JdkWithJettyBootPlatform extends Platform {
    private final Class<?> clientProviderClass;
    private final Method getMethod;
    private final Method putMethod;
    private final Method removeMethod;
    private final Class<?> serverProviderClass;

    public static class JettyNegoProvider implements InvocationHandler {
        private final List<String> protocols;
        String selected;
        boolean unsupported;

        public JettyNegoProvider(List<String> r10) {
            this.protocols = r10;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object r10, Method r11, Object[] r12) throws Throwable {
            String r13 = r11.getName();
            Class<?> r14 = r11.getReturnType();
            if (r12 != null) goto L6;
            r12 = Util.EMPTY_STRING_ARRAY;
        L6:
            if (r13.equals("supports") == false) goto L12;
            if (Boolean.TYPE != r14) goto L12;
            return Boolean.TRUE;
        L12:
            if (r13.equals("unsupported") == false) goto L18;
            if (Void.TYPE != r14) goto L18;
            this.unsupported = true;
            return null;
        L18:
            if (r13.equals("protocols") == false) goto L24;
            if (r12.length != 0) goto L24;
            return this.protocols;
        L24:
            if (r13.equals("selectProtocol") == true) goto L28;
            if (r13.equals("select") == true) goto L28;
        L43:
            if (r13.equals("protocolSelected") == true) goto L47;
            if (r13.equals("selected") == true) goto L47;
        L51:
            return r11.invoke(this, r12);
        L47:
            if (r12.length != 1) goto L51;
            this.selected = (String) r12[0];
            return null;
        L28:
            if (String.class != r14) goto L43;
            if (r12.length != 1) goto L43;
            Object r15 = r12[0];
            if ((r15 instanceof List) == false) goto L43;
            List r16 = (List) r15;
            int r17 = r16.size();
            int r18 = 0;
        L34:
            if (r18 >= r17) goto L40;
            if (this.protocols.contains(r16.get(r18)) == true) goto L37;
            r18 = r18 + 1;
            goto L34
        L37:
            String r19 = (String) r16.get(r18);
            this.selected = r19;
            return r19;
        L40:
            String r20 = this.protocols.get(0);
            this.selected = r20;
            return r20;
        }
    }

    public JdkWithJettyBootPlatform(Method r10, Method r11, Method r12, Class<?> r13, Class<?> r14) {
        this.putMethod = r10;
        this.getMethod = r11;
        this.removeMethod = r12;
        this.clientProviderClass = r13;
        this.serverProviderClass = r14;
    }

    public static Platform buildIfSupported() {
        Class<?> r10 = Class.forName("org.eclipse.jetty.alpn.ALPN");     // Catch: Throwable -> L5
        Class<?> r11 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");     // Catch: Throwable -> L5
        return new JdkWithJettyBootPlatform(r10.getMethod("put", new Class[]{SSLSocket.class, r11}), r10.getMethod("get", new Class[]{SSLSocket.class}), r10.getMethod("remove", new Class[]{SSLSocket.class}), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
    L5:
        return null;
    }

    @Override // okhttp3.internal.platform.Platform
    public void afterHandshake(SSLSocket r10) {
        this.removeMethod.invoke(null, new Object[]{r10});     // Catch: Throwable -> L4
        return;
    L4:
        e = move-exception;
        throw Util.assertionError("unable to remove alpn", e);
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(SSLSocket r10, String r11, List<Protocol> r12) {
        List<String> r13 = Platform.alpnProtocolNames(r12);
        Object r14 = Proxy.newProxyInstance(Platform.class.getClassLoader(), new Class[]{this.clientProviderClass, this.serverProviderClass}, new JettyNegoProvider(r13));     // Catch: Throwable -> L5
        this.putMethod.invoke(null, new Object[]{r10, r14});     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        throw Util.assertionError("unable to set alpn", e);
    }

    @Override // okhttp3.internal.platform.Platform
    @Nullable
    public String getSelectedProtocol(SSLSocket r10) {
        JettyNegoProvider r11 = (JettyNegoProvider) Proxy.getInvocationHandler(this.getMethod.invoke(null, new Object[]{r10}));     // Catch: Throwable -> L8
        boolean r12 = r11.unsupported;     // Catch: Throwable -> L8
        if (r12 == false) goto L5;
    L10:
        if (r12 == false) goto L13;
        return null;
    L13:
        return r11.selected;
    L5:
        if (r11.selected != null) goto L10;
        Platform.get().log(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", null);     // Catch: Throwable -> L8
        return null;
    L8:
        e = move-exception;
        throw Util.assertionError("unable to get selected protocol", e);
    }
}
