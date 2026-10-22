package com.stepos.mcp.sdk.java.transport;

import io.modelcontextprotocol.common.McpTransportContext;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpServerSession;
import io.modelcontextprotocol.spec.McpStreamableServerSession;
import java.util.function.Supplier;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements Supplier {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2740c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f2741f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f2742g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f2743h;

    public /* synthetic */ e(int i) {
        this.f2740c = i;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f2740c) {
            case 0:
                return ((AIDLServerTransportProvider) this.f2741f).lambda$onRequest$2((String) this.f2742g, (String) this.f2743h);
            case 1:
                return ((McpServerSession) this.f2741f).lambda$handleIncomingNotification$12((McpSchema.JSONRPCNotification) this.f2742g, (McpTransportContext) this.f2743h);
            case 2:
                return ((McpServerSession) this.f2741f).lambda$handleIncomingRequest$10((McpSchema.JSONRPCRequest) this.f2742g, (McpTransportContext) this.f2743h);
            default:
                return ((McpStreamableServerSession) this.f2741f).lambda$sendNotification$1((String) this.f2742g, this.f2743h);
        }
    }
}
