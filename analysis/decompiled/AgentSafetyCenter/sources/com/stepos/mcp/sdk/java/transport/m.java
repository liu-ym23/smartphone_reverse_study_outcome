package com.stepos.mcp.sdk.java.transport;

import com.stepos.mcp.sdk.java.transport.ServerTransportProvider;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpTransport;
import java.util.function.Supplier;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class m implements Supplier {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2756c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ McpSchema.JSONRPCMessage f2757f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ McpTransport f2758g;

    public /* synthetic */ m(int i) {
        this.f2756c = i;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f2756c) {
            case 0:
                return ((ServerTransportProvider.ServerSessionTransport) this.f2758g).lambda$sendMessage$0(this.f2757f);
            default:
                return ((AndroidClientTransport) this.f2758g).lambda$sendMessage$4(this.f2757f);
        }
    }
}
