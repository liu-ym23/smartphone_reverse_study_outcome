package io.ktor.server.engine;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\b\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lio/ktor/server/engine/EngineConnectorBuilder;", "Lio/ktor/server/engine/EngineConnectorConfig;", "Lio/ktor/server/engine/ConnectorType;", "type", "<init>", "(Lio/ktor/server/engine/ConnectorType;)V", "", "toString", "()Ljava/lang/String;", "Lio/ktor/server/engine/ConnectorType;", "getType", "()Lio/ktor/server/engine/ConnectorType;", "host", "Ljava/lang/String;", "getHost", "setHost", "(Ljava/lang/String;)V", "", "port", "I", "getPort", "()I", "setPort", "(I)V", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public class EngineConnectorBuilder implements EngineConnectorConfig {
    private String host;
    private int port;
    private final ConnectorType type;

    /* JADX WARN: Multi-variable type inference failed */
    public EngineConnectorBuilder() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // io.ktor.server.engine.EngineConnectorConfig
    public String getHost() {
        return this.host;
    }

    @Override // io.ktor.server.engine.EngineConnectorConfig
    public int getPort() {
        return this.port;
    }

    @Override // io.ktor.server.engine.EngineConnectorConfig
    public ConnectorType getType() {
        return this.type;
    }

    public void setHost(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.host = str;
    }

    public void setPort(int i10) {
        this.port = i10;
    }

    public String toString() {
        return getType().getName() + ' ' + getHost() + ':' + getPort();
    }

    public EngineConnectorBuilder(ConnectorType type) {
        kotlin.jvm.internal.p.i(type, "type");
        this.type = type;
        this.host = "0.0.0.0";
        this.port = 80;
    }

    public /* synthetic */ EngineConnectorBuilder(ConnectorType connectorType, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? ConnectorType.INSTANCE.getHTTP() : connectorType);
    }
}
