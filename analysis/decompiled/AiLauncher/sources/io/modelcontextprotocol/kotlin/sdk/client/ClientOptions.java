package io.modelcontextprotocol.kotlin.sdk.client;

import io.modelcontextprotocol.kotlin.sdk.ClientCapabilities;
import io.modelcontextprotocol.kotlin.sdk.shared.ProtocolOptions;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/client/ClientOptions;", "Lio/modelcontextprotocol/kotlin/sdk/shared/ProtocolOptions;", "Lio/modelcontextprotocol/kotlin/sdk/ClientCapabilities;", "capabilities", "", "enforceStrictCapabilities", "<init>", "(Lio/modelcontextprotocol/kotlin/sdk/ClientCapabilities;Z)V", "Lio/modelcontextprotocol/kotlin/sdk/ClientCapabilities;", "getCapabilities", "()Lio/modelcontextprotocol/kotlin/sdk/ClientCapabilities;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ClientOptions extends ProtocolOptions {
    private final ClientCapabilities capabilities;

    /* JADX WARN: Multi-variable type inference failed */
    public ClientOptions() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    public final ClientCapabilities getCapabilities() {
        return this.capabilities;
    }

    public /* synthetic */ ClientOptions(ClientCapabilities clientCapabilities, boolean z10, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? new ClientCapabilities((qb.D) null, (qb.D) null, (ClientCapabilities.Roots) null, (qb.D) null, 15, (kotlin.jvm.internal.i) null) : clientCapabilities, (i10 & 2) != 0 ? true : z10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClientOptions(ClientCapabilities capabilities, boolean z10) {
        super(z10, 0L, 2, null);
        kotlin.jvm.internal.p.i(capabilities, "capabilities");
        this.capabilities = capabilities;
    }
}
