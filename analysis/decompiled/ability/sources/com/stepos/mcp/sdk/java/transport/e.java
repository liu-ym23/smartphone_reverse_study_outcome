package com.stepos.mcp.sdk.java.transport;

import io.modelcontextprotocol.common.McpTransportContext;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpServerSession;
import io.modelcontextprotocol.spec.McpStreamableServerSession;
import java.util.function.Supplier;

/* loaded from: classes3.dex */
public final /* synthetic */ class e implements Supplier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3836a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public /* synthetic */ e(Object obj, Object obj2, Object obj3, int i) {
        this.f3836a = i;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f3836a) {
            case 0:
                return ((AIDLServerTransportProvider) this.b).lambda$onRequest$2((String) this.c, (String) this.d);
            case 1:
                return ((McpServerSession) this.b).lambda$handleIncomingNotification$12((McpSchema.JSONRPCNotification) this.c, (McpTransportContext) this.d);
            case 2:
                return ((McpServerSession) this.b).lambda$handleIncomingRequest$10((McpSchema.JSONRPCRequest) this.c, (McpTransportContext) this.d);
            default:
                return ((McpStreamableServerSession) this.b).lambda$sendNotification$1((String) this.c, this.d);
        }
    }
}
