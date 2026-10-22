package io.ktor.client.engine.cio;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0013\u0010\b\"\u0004\b\u0014\u0010\nR\"\u0010\u0015\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\"\u0010\u0018\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\"\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u001c\u0010\b\"\u0004\b\u001d\u0010\nR*\u0010 \u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e8\u0006@GX\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lio/ktor/client/engine/cio/EndpointConfig;", "", "<init>", "()V", "", "maxConnectionsPerRoute", "I", "getMaxConnectionsPerRoute", "()I", "setMaxConnectionsPerRoute", "(I)V", "", "keepAliveTime", "J", "getKeepAliveTime", "()J", "setKeepAliveTime", "(J)V", "pipelineMaxSize", "getPipelineMaxSize", "setPipelineMaxSize", "connectTimeout", "getConnectTimeout", "setConnectTimeout", "socketTimeout", "getSocketTimeout", "setSocketTimeout", "connectAttempts", "getConnectAttempts", "setConnectAttempts", "", UxipConstants.f30680s, "allowHalfClose", "Z", "getAllowHalfClose", "()Z", "setAllowHalfClose", "(Z)V", "ktor-client-cio"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EndpointConfig {
    private boolean allowHalfClose;
    private int maxConnectionsPerRoute = 100;
    private long keepAliveTime = 5000;
    private int pipelineMaxSize = 20;
    private long connectTimeout = 5000;
    private long socketTimeout = Long.MAX_VALUE;
    private int connectAttempts = 1;

    public final boolean getAllowHalfClose() {
        return this.allowHalfClose;
    }

    public final int getConnectAttempts() {
        return this.connectAttempts;
    }

    public final long getConnectTimeout() {
        return this.connectTimeout;
    }

    public final long getKeepAliveTime() {
        return this.keepAliveTime;
    }

    public final int getMaxConnectionsPerRoute() {
        return this.maxConnectionsPerRoute;
    }

    public final int getPipelineMaxSize() {
        return this.pipelineMaxSize;
    }

    public final long getSocketTimeout() {
        return this.socketTimeout;
    }

    public final void setAllowHalfClose(boolean z10) {
        this.allowHalfClose = z10;
    }

    public final void setConnectAttempts(int i10) {
        this.connectAttempts = i10;
    }

    public final void setConnectTimeout(long j10) {
        this.connectTimeout = j10;
    }

    public final void setKeepAliveTime(long j10) {
        this.keepAliveTime = j10;
    }

    public final void setMaxConnectionsPerRoute(int i10) {
        this.maxConnectionsPerRoute = i10;
    }

    public final void setPipelineMaxSize(int i10) {
        this.pipelineMaxSize = i10;
    }

    public final void setSocketTimeout(long j10) {
        this.socketTimeout = j10;
    }
}
