package io.ktor.server.plugins;

import io.ktor.http.HttpMethod;
import io.ktor.http.RequestConnectionPoint;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.t;
import p9.InterfaceC5063a;
import w9.InterfaceC5752k;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u001c\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\bR+\u0010\u000f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00058V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\u000eR+\u0010\u0013\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00058V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\u000eR+\u0010\u001a\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u00148V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R+\u0010\u001e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00058V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u000b\u001a\u0004\b\u001c\u0010\u0007\"\u0004\b\u001d\u0010\u000eR1\u0010$\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00058V@VX\u0097\u008e\u0002¢\u0006\u0018\n\u0004\b\u001f\u0010\u000b\u0012\u0004\b\"\u0010#\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\u000eR+\u0010(\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00058V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b%\u0010\u000b\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\u000eR+\u0010,\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00058V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b)\u0010\u000b\u001a\u0004\b*\u0010\u0007\"\u0004\b+\u0010\u000eR+\u00100\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00058V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b-\u0010\u000b\u001a\u0004\b.\u0010\u0007\"\u0004\b/\u0010\u000eR1\u00108\u001a\u0002012\u0006\u0010\t\u001a\u0002018V@VX\u0097\u008e\u0002¢\u0006\u0018\n\u0004\b2\u0010\u000b\u0012\u0004\b7\u0010#\u001a\u0004\b3\u00104\"\u0004\b5\u00106R+\u0010<\u001a\u0002012\u0006\u0010\t\u001a\u0002018V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b9\u0010\u000b\u001a\u0004\b:\u00104\"\u0004\b;\u00106R+\u0010@\u001a\u0002012\u0006\u0010\t\u001a\u0002018V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b=\u0010\u000b\u001a\u0004\b>\u00104\"\u0004\b?\u00106R+\u0010D\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00058V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bA\u0010\u000b\u001a\u0004\bB\u0010\u0007\"\u0004\bC\u0010\u000eR+\u0010H\u001a\u0002012\u0006\u0010\t\u001a\u0002018V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bE\u0010\u000b\u001a\u0004\bF\u00104\"\u0004\bG\u00106R+\u0010L\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00058V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bI\u0010\u000b\u001a\u0004\bJ\u0010\u0007\"\u0004\bK\u0010\u000e¨\u0006M"}, d2 = {"Lio/ktor/server/plugins/MutableOriginConnectionPoint;", "Lio/ktor/http/RequestConnectionPoint;", "delegate", "<init>", "(Lio/ktor/http/RequestConnectionPoint;)V", "", "toString", "()Ljava/lang/String;", "Lio/ktor/http/RequestConnectionPoint;", "<set-?>", "version$delegate", "Lio/ktor/server/plugins/AssignableWithDelegate;", "getVersion", "setVersion", "(Ljava/lang/String;)V", "version", "uri$delegate", "getUri", "setUri", "uri", "Lio/ktor/http/HttpMethod;", "method$delegate", "getMethod", "()Lio/ktor/http/HttpMethod;", "setMethod", "(Lio/ktor/http/HttpMethod;)V", "method", "scheme$delegate", "getScheme", "setScheme", "scheme", "host$delegate", "getHost", "setHost", "getHost$annotations", "()V", "host", "localHost$delegate", "getLocalHost", "setLocalHost", "localHost", "serverHost$delegate", "getServerHost", "setServerHost", "serverHost", "localAddress$delegate", "getLocalAddress", "setLocalAddress", "localAddress", "", "port$delegate", "getPort", "()I", "setPort", "(I)V", "getPort$annotations", "port", "localPort$delegate", "getLocalPort", "setLocalPort", "localPort", "serverPort$delegate", "getServerPort", "setServerPort", "serverPort", "remoteHost$delegate", "getRemoteHost", "setRemoteHost", "remoteHost", "remotePort$delegate", "getRemotePort", "setRemotePort", "remotePort", "remoteAddress$delegate", "getRemoteAddress", "setRemoteAddress", "remoteAddress", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MutableOriginConnectionPoint implements RequestConnectionPoint {
    static final /* synthetic */ InterfaceC5752k<Object>[] $$delegatedProperties = {t.f(new MutablePropertyReference1Impl(MutableOriginConnectionPoint.class, "version", "getVersion()Ljava/lang/String;", 0)), t.f(new MutablePropertyReference1Impl(MutableOriginConnectionPoint.class, "uri", "getUri()Ljava/lang/String;", 0)), t.f(new MutablePropertyReference1Impl(MutableOriginConnectionPoint.class, "method", "getMethod()Lio/ktor/http/HttpMethod;", 0)), t.f(new MutablePropertyReference1Impl(MutableOriginConnectionPoint.class, "scheme", "getScheme()Ljava/lang/String;", 0)), t.f(new MutablePropertyReference1Impl(MutableOriginConnectionPoint.class, "host", "getHost()Ljava/lang/String;", 0)), t.f(new MutablePropertyReference1Impl(MutableOriginConnectionPoint.class, "localHost", "getLocalHost()Ljava/lang/String;", 0)), t.f(new MutablePropertyReference1Impl(MutableOriginConnectionPoint.class, "serverHost", "getServerHost()Ljava/lang/String;", 0)), t.f(new MutablePropertyReference1Impl(MutableOriginConnectionPoint.class, "localAddress", "getLocalAddress()Ljava/lang/String;", 0)), t.f(new MutablePropertyReference1Impl(MutableOriginConnectionPoint.class, "port", "getPort()I", 0)), t.f(new MutablePropertyReference1Impl(MutableOriginConnectionPoint.class, "localPort", "getLocalPort()I", 0)), t.f(new MutablePropertyReference1Impl(MutableOriginConnectionPoint.class, "serverPort", "getServerPort()I", 0)), t.f(new MutablePropertyReference1Impl(MutableOriginConnectionPoint.class, "remoteHost", "getRemoteHost()Ljava/lang/String;", 0)), t.f(new MutablePropertyReference1Impl(MutableOriginConnectionPoint.class, "remotePort", "getRemotePort()I", 0)), t.f(new MutablePropertyReference1Impl(MutableOriginConnectionPoint.class, "remoteAddress", "getRemoteAddress()Ljava/lang/String;", 0))};
    private final RequestConnectionPoint delegate;

    /* renamed from: host$delegate, reason: from kotlin metadata */
    private final AssignableWithDelegate host;

    /* renamed from: localAddress$delegate, reason: from kotlin metadata */
    private final AssignableWithDelegate localAddress;

    /* renamed from: localHost$delegate, reason: from kotlin metadata */
    private final AssignableWithDelegate localHost;

    /* renamed from: localPort$delegate, reason: from kotlin metadata */
    private final AssignableWithDelegate localPort;

    /* renamed from: method$delegate, reason: from kotlin metadata */
    private final AssignableWithDelegate method;

    /* renamed from: port$delegate, reason: from kotlin metadata */
    private final AssignableWithDelegate port;

    /* renamed from: remoteAddress$delegate, reason: from kotlin metadata */
    private final AssignableWithDelegate remoteAddress;

    /* renamed from: remoteHost$delegate, reason: from kotlin metadata */
    private final AssignableWithDelegate remoteHost;

    /* renamed from: remotePort$delegate, reason: from kotlin metadata */
    private final AssignableWithDelegate remotePort;

    /* renamed from: scheme$delegate, reason: from kotlin metadata */
    private final AssignableWithDelegate scheme;

    /* renamed from: serverHost$delegate, reason: from kotlin metadata */
    private final AssignableWithDelegate serverHost;

    /* renamed from: serverPort$delegate, reason: from kotlin metadata */
    private final AssignableWithDelegate serverPort;

    /* renamed from: uri$delegate, reason: from kotlin metadata */
    private final AssignableWithDelegate uri;

    /* renamed from: version$delegate, reason: from kotlin metadata */
    private final AssignableWithDelegate version;

    public MutableOriginConnectionPoint(RequestConnectionPoint delegate) {
        p.i(delegate, "delegate");
        this.delegate = delegate;
        this.version = new AssignableWithDelegate(new InterfaceC5063a() { // from class: io.ktor.server.plugins.a
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return MutableOriginConnectionPoint.version_delegate$lambda$0(this.f33427a);
            }
        });
        this.uri = new AssignableWithDelegate(new InterfaceC5063a() { // from class: io.ktor.server.plugins.j
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return MutableOriginConnectionPoint.uri_delegate$lambda$1(this.f33436a);
            }
        });
        this.method = new AssignableWithDelegate(new InterfaceC5063a() { // from class: io.ktor.server.plugins.k
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return MutableOriginConnectionPoint.method_delegate$lambda$2(this.f33437a);
            }
        });
        this.scheme = new AssignableWithDelegate(new InterfaceC5063a() { // from class: io.ktor.server.plugins.l
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return MutableOriginConnectionPoint.scheme_delegate$lambda$3(this.f33438a);
            }
        });
        this.host = new AssignableWithDelegate(new InterfaceC5063a() { // from class: io.ktor.server.plugins.m
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return MutableOriginConnectionPoint.host_delegate$lambda$4(this.f33439a);
            }
        });
        this.localHost = new AssignableWithDelegate(new InterfaceC5063a() { // from class: io.ktor.server.plugins.n
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return MutableOriginConnectionPoint.localHost_delegate$lambda$5(this.f33440a);
            }
        });
        this.serverHost = new AssignableWithDelegate(new InterfaceC5063a() { // from class: io.ktor.server.plugins.b
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return MutableOriginConnectionPoint.serverHost_delegate$lambda$6(this.f33428a);
            }
        });
        this.localAddress = new AssignableWithDelegate(new InterfaceC5063a() { // from class: io.ktor.server.plugins.c
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return MutableOriginConnectionPoint.localAddress_delegate$lambda$7(this.f33429a);
            }
        });
        this.port = new AssignableWithDelegate(new InterfaceC5063a() { // from class: io.ktor.server.plugins.d
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Integer.valueOf(MutableOriginConnectionPoint.port_delegate$lambda$8(this.f33430a));
            }
        });
        this.localPort = new AssignableWithDelegate(new InterfaceC5063a() { // from class: io.ktor.server.plugins.e
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Integer.valueOf(MutableOriginConnectionPoint.localPort_delegate$lambda$9(this.f33431a));
            }
        });
        this.serverPort = new AssignableWithDelegate(new InterfaceC5063a() { // from class: io.ktor.server.plugins.f
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Integer.valueOf(MutableOriginConnectionPoint.serverPort_delegate$lambda$10(this.f33432a));
            }
        });
        this.remoteHost = new AssignableWithDelegate(new InterfaceC5063a() { // from class: io.ktor.server.plugins.g
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return MutableOriginConnectionPoint.remoteHost_delegate$lambda$11(this.f33433a);
            }
        });
        this.remotePort = new AssignableWithDelegate(new InterfaceC5063a() { // from class: io.ktor.server.plugins.h
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Integer.valueOf(MutableOriginConnectionPoint.remotePort_delegate$lambda$12(this.f33434a));
            }
        });
        this.remoteAddress = new AssignableWithDelegate(new InterfaceC5063a() { // from class: io.ktor.server.plugins.i
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return MutableOriginConnectionPoint.remoteAddress_delegate$lambda$13(this.f33435a);
            }
        });
    }

    public static /* synthetic */ void getHost$annotations() {
    }

    public static /* synthetic */ void getPort$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String host_delegate$lambda$4(MutableOriginConnectionPoint mutableOriginConnectionPoint) {
        return mutableOriginConnectionPoint.delegate.getHost();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String localAddress_delegate$lambda$7(MutableOriginConnectionPoint mutableOriginConnectionPoint) {
        return mutableOriginConnectionPoint.delegate.getLocalAddress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String localHost_delegate$lambda$5(MutableOriginConnectionPoint mutableOriginConnectionPoint) {
        return mutableOriginConnectionPoint.delegate.getLocalHost();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int localPort_delegate$lambda$9(MutableOriginConnectionPoint mutableOriginConnectionPoint) {
        return mutableOriginConnectionPoint.delegate.getLocalPort();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HttpMethod method_delegate$lambda$2(MutableOriginConnectionPoint mutableOriginConnectionPoint) {
        return mutableOriginConnectionPoint.delegate.getMethod();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int port_delegate$lambda$8(MutableOriginConnectionPoint mutableOriginConnectionPoint) {
        return mutableOriginConnectionPoint.delegate.getPort();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String remoteAddress_delegate$lambda$13(MutableOriginConnectionPoint mutableOriginConnectionPoint) {
        return mutableOriginConnectionPoint.delegate.getRemoteAddress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String remoteHost_delegate$lambda$11(MutableOriginConnectionPoint mutableOriginConnectionPoint) {
        return mutableOriginConnectionPoint.delegate.getRemoteHost();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int remotePort_delegate$lambda$12(MutableOriginConnectionPoint mutableOriginConnectionPoint) {
        return mutableOriginConnectionPoint.delegate.getRemotePort();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String scheme_delegate$lambda$3(MutableOriginConnectionPoint mutableOriginConnectionPoint) {
        return mutableOriginConnectionPoint.delegate.getScheme();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String serverHost_delegate$lambda$6(MutableOriginConnectionPoint mutableOriginConnectionPoint) {
        return mutableOriginConnectionPoint.delegate.getServerHost();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int serverPort_delegate$lambda$10(MutableOriginConnectionPoint mutableOriginConnectionPoint) {
        return mutableOriginConnectionPoint.delegate.getServerPort();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String uri_delegate$lambda$1(MutableOriginConnectionPoint mutableOriginConnectionPoint) {
        return mutableOriginConnectionPoint.delegate.getUri();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String version_delegate$lambda$0(MutableOriginConnectionPoint mutableOriginConnectionPoint) {
        return mutableOriginConnectionPoint.delegate.getVersion();
    }

    @Override // io.ktor.http.RequestConnectionPoint
    public String getHost() {
        return (String) this.host.getValue(this, $$delegatedProperties[4]);
    }

    @Override // io.ktor.http.RequestConnectionPoint
    public String getLocalAddress() {
        return (String) this.localAddress.getValue(this, $$delegatedProperties[7]);
    }

    @Override // io.ktor.http.RequestConnectionPoint
    public String getLocalHost() {
        return (String) this.localHost.getValue(this, $$delegatedProperties[5]);
    }

    @Override // io.ktor.http.RequestConnectionPoint
    public int getLocalPort() {
        return ((Number) this.localPort.getValue(this, $$delegatedProperties[9])).intValue();
    }

    @Override // io.ktor.http.RequestConnectionPoint
    public HttpMethod getMethod() {
        return (HttpMethod) this.method.getValue(this, $$delegatedProperties[2]);
    }

    @Override // io.ktor.http.RequestConnectionPoint
    public int getPort() {
        return ((Number) this.port.getValue(this, $$delegatedProperties[8])).intValue();
    }

    @Override // io.ktor.http.RequestConnectionPoint
    public String getRemoteAddress() {
        return (String) this.remoteAddress.getValue(this, $$delegatedProperties[13]);
    }

    @Override // io.ktor.http.RequestConnectionPoint
    public String getRemoteHost() {
        return (String) this.remoteHost.getValue(this, $$delegatedProperties[11]);
    }

    @Override // io.ktor.http.RequestConnectionPoint
    public int getRemotePort() {
        return ((Number) this.remotePort.getValue(this, $$delegatedProperties[12])).intValue();
    }

    @Override // io.ktor.http.RequestConnectionPoint
    public String getScheme() {
        return (String) this.scheme.getValue(this, $$delegatedProperties[3]);
    }

    @Override // io.ktor.http.RequestConnectionPoint
    public String getServerHost() {
        return (String) this.serverHost.getValue(this, $$delegatedProperties[6]);
    }

    @Override // io.ktor.http.RequestConnectionPoint
    public int getServerPort() {
        return ((Number) this.serverPort.getValue(this, $$delegatedProperties[10])).intValue();
    }

    @Override // io.ktor.http.RequestConnectionPoint
    public String getUri() {
        return (String) this.uri.getValue(this, $$delegatedProperties[1]);
    }

    @Override // io.ktor.http.RequestConnectionPoint
    public String getVersion() {
        return (String) this.version.getValue(this, $$delegatedProperties[0]);
    }

    public void setHost(String str) {
        p.i(str, "<set-?>");
        this.host.setValue(this, $$delegatedProperties[4], str);
    }

    public void setLocalAddress(String str) {
        p.i(str, "<set-?>");
        this.localAddress.setValue(this, $$delegatedProperties[7], str);
    }

    public void setLocalHost(String str) {
        p.i(str, "<set-?>");
        this.localHost.setValue(this, $$delegatedProperties[5], str);
    }

    public void setLocalPort(int i10) {
        this.localPort.setValue(this, $$delegatedProperties[9], Integer.valueOf(i10));
    }

    public void setMethod(HttpMethod httpMethod) {
        p.i(httpMethod, "<set-?>");
        this.method.setValue(this, $$delegatedProperties[2], httpMethod);
    }

    public void setPort(int i10) {
        this.port.setValue(this, $$delegatedProperties[8], Integer.valueOf(i10));
    }

    public void setRemoteAddress(String str) {
        p.i(str, "<set-?>");
        this.remoteAddress.setValue(this, $$delegatedProperties[13], str);
    }

    public void setRemoteHost(String str) {
        p.i(str, "<set-?>");
        this.remoteHost.setValue(this, $$delegatedProperties[11], str);
    }

    public void setRemotePort(int i10) {
        this.remotePort.setValue(this, $$delegatedProperties[12], Integer.valueOf(i10));
    }

    public void setScheme(String str) {
        p.i(str, "<set-?>");
        this.scheme.setValue(this, $$delegatedProperties[3], str);
    }

    public void setServerHost(String str) {
        p.i(str, "<set-?>");
        this.serverHost.setValue(this, $$delegatedProperties[6], str);
    }

    public void setServerPort(int i10) {
        this.serverPort.setValue(this, $$delegatedProperties[10], Integer.valueOf(i10));
    }

    public void setUri(String str) {
        p.i(str, "<set-?>");
        this.uri.setValue(this, $$delegatedProperties[1], str);
    }

    public void setVersion(String str) {
        p.i(str, "<set-?>");
        this.version.setValue(this, $$delegatedProperties[0], str);
    }

    public String toString() {
        return this.delegate.toString();
    }
}
