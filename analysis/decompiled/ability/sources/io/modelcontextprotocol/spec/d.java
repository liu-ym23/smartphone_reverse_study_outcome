package io.modelcontextprotocol.spec;

import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.Function;

/* loaded from: classes3.dex */
public final /* synthetic */ class d implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4742a;
    public final /* synthetic */ McpSchema.JSONRPCRequest b;

    public /* synthetic */ d(McpSchema.JSONRPCRequest jSONRPCRequest, int i) {
        this.f4742a = i;
        this.b = jSONRPCRequest;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f4742a;
        McpSchema.JSONRPCRequest jSONRPCRequest = this.b;
        switch (i) {
            case 0:
                return McpClientSession.lambda$handleIncomingRequest$5(jSONRPCRequest, obj);
            case 1:
                return McpClientSession.lambda$handle$2(jSONRPCRequest, (Throwable) obj);
            case 2:
                return McpServerSession.lambda$handleIncomingRequest$8(jSONRPCRequest, obj);
            case 3:
                return McpServerSession.lambda$handleIncomingRequest$9(jSONRPCRequest, (Throwable) obj);
            case 4:
                return McpStreamableServerSession.lambda$responseStream$3(jSONRPCRequest, obj);
            default:
                return McpStreamableServerSession.lambda$responseStream$4(jSONRPCRequest, (Throwable) obj);
        }
    }
}
