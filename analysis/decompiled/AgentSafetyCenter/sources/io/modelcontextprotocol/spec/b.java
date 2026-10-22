package io.modelcontextprotocol.spec;

import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.Function;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6347a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ McpSchema.JSONRPCRequest f6348b;

    public /* synthetic */ b(int i) {
        this.f6347a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f6347a;
        McpSchema.JSONRPCRequest jSONRPCRequest = this.f6348b;
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
