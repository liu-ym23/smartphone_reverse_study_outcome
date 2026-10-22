package io.ktor.server.cio;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J8\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u000fJ\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u001e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001f\u001a\u0004\b \u0010\u0011R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010!\u001a\u0004\b\"\u0010\u0013¨\u0006#"}, d2 = {"Lio/ktor/server/cio/HttpServerSettings;", "", "", "host", "", "port", "", "connectionIdleTimeoutSeconds", "", "reuseAddress", "<init>", "(Ljava/lang/String;IJZ)V", "component1", "()Ljava/lang/String;", "component2", "()I", "component3", "()J", "component4", "()Z", ChatTracker.CLICK_COPY, "(Ljava/lang/String;IJZ)Lio/ktor/server/cio/HttpServerSettings;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Ljava/lang/String;", "getHost", "I", "getPort", "J", "getConnectionIdleTimeoutSeconds", "Z", "getReuseAddress", "ktor-server-cio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class HttpServerSettings {
    private final long connectionIdleTimeoutSeconds;
    private final String host;
    private final int port;
    private final boolean reuseAddress;

    public HttpServerSettings() {
        this(null, 0, 0L, false, 15, null);
    }

    public static /* synthetic */ HttpServerSettings copy$default(HttpServerSettings httpServerSettings, String str, int i10, long j10, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = httpServerSettings.host;
        }
        if ((i11 & 2) != 0) {
            i10 = httpServerSettings.port;
        }
        if ((i11 & 4) != 0) {
            j10 = httpServerSettings.connectionIdleTimeoutSeconds;
        }
        if ((i11 & 8) != 0) {
            z10 = httpServerSettings.reuseAddress;
        }
        boolean z11 = z10;
        return httpServerSettings.copy(str, i10, j10, z11);
    }

    /* renamed from: component1, reason: from getter */
    public final String getHost() {
        return this.host;
    }

    /* renamed from: component2, reason: from getter */
    public final int getPort() {
        return this.port;
    }

    /* renamed from: component3, reason: from getter */
    public final long getConnectionIdleTimeoutSeconds() {
        return this.connectionIdleTimeoutSeconds;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getReuseAddress() {
        return this.reuseAddress;
    }

    public final HttpServerSettings copy(String host, int port, long connectionIdleTimeoutSeconds, boolean reuseAddress) {
        p.i(host, "host");
        return new HttpServerSettings(host, port, connectionIdleTimeoutSeconds, reuseAddress);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HttpServerSettings)) {
            return false;
        }
        HttpServerSettings httpServerSettings = (HttpServerSettings) other;
        return p.d(this.host, httpServerSettings.host) && this.port == httpServerSettings.port && this.connectionIdleTimeoutSeconds == httpServerSettings.connectionIdleTimeoutSeconds && this.reuseAddress == httpServerSettings.reuseAddress;
    }

    public final long getConnectionIdleTimeoutSeconds() {
        return this.connectionIdleTimeoutSeconds;
    }

    public final String getHost() {
        return this.host;
    }

    public final int getPort() {
        return this.port;
    }

    public final boolean getReuseAddress() {
        return this.reuseAddress;
    }

    public int hashCode() {
        return (((((this.host.hashCode() * 31) + Integer.hashCode(this.port)) * 31) + Long.hashCode(this.connectionIdleTimeoutSeconds)) * 31) + Boolean.hashCode(this.reuseAddress);
    }

    public String toString() {
        return "HttpServerSettings(host=" + this.host + ", port=" + this.port + ", connectionIdleTimeoutSeconds=" + this.connectionIdleTimeoutSeconds + ", reuseAddress=" + this.reuseAddress + ')';
    }

    public HttpServerSettings(String host, int i10, long j10, boolean z10) {
        p.i(host, "host");
        this.host = host;
        this.port = i10;
        this.connectionIdleTimeoutSeconds = j10;
        this.reuseAddress = z10;
    }

    public /* synthetic */ HttpServerSettings(String str, int i10, long j10, boolean z10, int i11, i iVar) {
        this((i11 & 1) != 0 ? "0.0.0.0" : str, (i11 & 2) != 0 ? 8080 : i10, (i11 & 4) != 0 ? 45L : j10, (i11 & 8) != 0 ? false : z10);
    }
}
