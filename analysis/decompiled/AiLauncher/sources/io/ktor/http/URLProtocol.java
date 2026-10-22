package io.ktor.http;

import Z8.C1173v;
import Z8.C1174w;
import Z8.Q;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import io.ktor.util.CharsetKt;
import io.ktor.util.TextKt;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 \u001a2\u00060\u0001j\u0002`\u0002:\u0001\u001aB\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ$\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0014\u0010\fJ\u0010\u0010\u0015\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0015\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0017\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u0019\u0010\f¨\u0006\u001b"}, d2 = {"Lio/ktor/http/URLProtocol;", "Ljava/io/Serializable;", "Lio/ktor/utils/io/JvmSerializable;", "", "name", "", "defaultPort", "<init>", "(Ljava/lang/String;I)V", "component1", "()Ljava/lang/String;", "component2", "()I", ChatTracker.CLICK_COPY, "(Ljava/lang/String;I)Lio/ktor/http/URLProtocol;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Ljava/lang/String;", "getName", "I", "getDefaultPort", "Companion", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class URLProtocol implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final URLProtocol HTTP;
    private static final URLProtocol HTTPS;
    private static final URLProtocol SOCKS;
    private static final URLProtocol WS;
    private static final URLProtocol WSS;
    private static final Map<String, URLProtocol> byName;
    private final int defaultPort;
    private final String name;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\fR#\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lio/ktor/http/URLProtocol$Companion;", "", "<init>", "()V", "", "name", "Lio/ktor/http/URLProtocol;", "createOrDefault", "(Ljava/lang/String;)Lio/ktor/http/URLProtocol;", "HTTP", "Lio/ktor/http/URLProtocol;", "getHTTP", "()Lio/ktor/http/URLProtocol;", "HTTPS", "getHTTPS", "WS", "getWS", "WSS", "getWSS", "SOCKS", "getSOCKS", "", "byName", "Ljava/util/Map;", "getByName", "()Ljava/util/Map;", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final URLProtocol createOrDefault(String name) {
            kotlin.jvm.internal.p.i(name, "name");
            String lowerCasePreservingASCIIRules = TextKt.toLowerCasePreservingASCIIRules(name);
            URLProtocol uRLProtocol = URLProtocol.INSTANCE.getByName().get(lowerCasePreservingASCIIRules);
            return uRLProtocol == null ? new URLProtocol(lowerCasePreservingASCIIRules, 0) : uRLProtocol;
        }

        public final Map<String, URLProtocol> getByName() {
            return URLProtocol.byName;
        }

        public final URLProtocol getHTTP() {
            return URLProtocol.HTTP;
        }

        public final URLProtocol getHTTPS() {
            return URLProtocol.HTTPS;
        }

        public final URLProtocol getSOCKS() {
            return URLProtocol.SOCKS;
        }

        public final URLProtocol getWS() {
            return URLProtocol.WS;
        }

        public final URLProtocol getWSS() {
            return URLProtocol.WSS;
        }

        private Companion() {
        }
    }

    static {
        URLProtocol uRLProtocol = new URLProtocol("http", 80);
        HTTP = uRLProtocol;
        URLProtocol uRLProtocol2 = new URLProtocol("https", 443);
        HTTPS = uRLProtocol2;
        URLProtocol uRLProtocol3 = new URLProtocol("ws", 80);
        WS = uRLProtocol3;
        URLProtocol uRLProtocol4 = new URLProtocol("wss", 443);
        WSS = uRLProtocol4;
        URLProtocol uRLProtocol5 = new URLProtocol("socks", 1080);
        SOCKS = uRLProtocol5;
        List listP = C1173v.p(uRLProtocol, uRLProtocol2, uRLProtocol3, uRLProtocol4, uRLProtocol5);
        LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Q.e(C1174w.x(listP, 10)), 16));
        for (Object obj : listP) {
            linkedHashMap.put(((URLProtocol) obj).name, obj);
        }
        byName = linkedHashMap;
    }

    public URLProtocol(String name, int i10) {
        kotlin.jvm.internal.p.i(name, "name");
        this.name = name;
        this.defaultPort = i10;
        for (int i11 = 0; i11 < name.length(); i11++) {
            if (!CharsetKt.isLowerCase(name.charAt(i11))) {
                throw new IllegalArgumentException("All characters should be lower case");
            }
        }
    }

    public static /* synthetic */ URLProtocol copy$default(URLProtocol uRLProtocol, String str, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = uRLProtocol.name;
        }
        if ((i11 & 2) != 0) {
            i10 = uRLProtocol.defaultPort;
        }
        return uRLProtocol.copy(str, i10);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final int getDefaultPort() {
        return this.defaultPort;
    }

    public final URLProtocol copy(String name, int defaultPort) {
        kotlin.jvm.internal.p.i(name, "name");
        return new URLProtocol(name, defaultPort);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof URLProtocol)) {
            return false;
        }
        URLProtocol uRLProtocol = (URLProtocol) other;
        return kotlin.jvm.internal.p.d(this.name, uRLProtocol.name) && this.defaultPort == uRLProtocol.defaultPort;
    }

    public final int getDefaultPort() {
        return this.defaultPort;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + Integer.hashCode(this.defaultPort);
    }

    public String toString() {
        return "URLProtocol(name=" + this.name + ", defaultPort=" + this.defaultPort + ')';
    }
}
