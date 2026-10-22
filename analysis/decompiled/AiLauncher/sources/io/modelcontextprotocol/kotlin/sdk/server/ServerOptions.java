package io.modelcontextprotocol.kotlin.sdk.server;

import io.modelcontextprotocol.kotlin.sdk.ServerCapabilities;
import io.modelcontextprotocol.kotlin.sdk.shared.ProtocolOptions;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/server/ServerOptions;", "Lio/modelcontextprotocol/kotlin/sdk/shared/ProtocolOptions;", "Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities;", "capabilities", "", "enforceStrictCapabilities", "<init>", "(Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities;Z)V", "Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities;", "getCapabilities", "()Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ServerOptions extends ProtocolOptions {
    private final ServerCapabilities capabilities;

    public /* synthetic */ ServerOptions(ServerCapabilities serverCapabilities, boolean z10, int i10, kotlin.jvm.internal.i iVar) {
        this(serverCapabilities, (i10 & 2) != 0 ? true : z10);
    }

    public final ServerCapabilities getCapabilities() {
        return this.capabilities;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerOptions(ServerCapabilities capabilities, boolean z10) {
        super(z10, 0L, 2, null);
        kotlin.jvm.internal.p.i(capabilities, "capabilities");
        this.capabilities = capabilities;
    }
}
