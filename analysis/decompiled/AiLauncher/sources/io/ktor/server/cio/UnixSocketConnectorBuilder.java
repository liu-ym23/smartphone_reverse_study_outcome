package io.ktor.server.cio;

import io.ktor.server.engine.ConnectorType;
import io.ktor.server.engine.EngineConnectorBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\u00020\u00058\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/ktor/server/cio/UnixSocketConnectorBuilder;", "Lio/ktor/server/engine/EngineConnectorBuilder;", "Lio/ktor/server/cio/UnixSocketConnectorConfig;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "socketPath", "Ljava/lang/String;", "getSocketPath", "setSocketPath", "(Ljava/lang/String;)V", "ktor-server-cio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UnixSocketConnectorBuilder extends EngineConnectorBuilder implements UnixSocketConnectorConfig {
    private String socketPath;

    public UnixSocketConnectorBuilder() {
        super(ConnectorType.INSTANCE.getUNIX());
        this.socketPath = "/tmp/ktor.sock";
    }

    @Override // io.ktor.server.cio.UnixSocketConnectorConfig
    public String getSocketPath() {
        return this.socketPath;
    }

    public void setSocketPath(String str) {
        p.i(str, "<set-?>");
        this.socketPath = str;
    }

    @Override // io.ktor.server.engine.EngineConnectorBuilder
    public String toString() {
        return getType().getName() + ' ' + getSocketPath();
    }
}
