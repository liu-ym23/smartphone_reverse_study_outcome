package io.modelcontextprotocol.server;

import io.modelcontextprotocol.server.McpServer;
import io.modelcontextprotocol.server.McpServerFeatures;
import io.modelcontextprotocol.server.McpStatelessServerFeatures;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.Predicate;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class o implements Predicate {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6284c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ String f6285f;

    public /* synthetic */ o(int i) {
        this.f6284c = i;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        int i = this.f6284c;
        String str = this.f6285f;
        switch (i) {
            case 0:
                return McpAsyncServer.lambda$removeTool$14(str, (McpServerFeatures.AsyncToolSpecification) obj);
            case 1:
                return McpAsyncServer.lambda$completionCompleteRequestHandler$39(str, (McpSchema.PromptArgument) obj);
            case 2:
                return McpServer.AsyncSpecification.lambda$assertNoDuplicateTool$0(str, (McpServerFeatures.AsyncToolSpecification) obj);
            case 3:
                return McpServer.StatelessAsyncSpecification.lambda$assertNoDuplicateTool$0(str, (McpStatelessServerFeatures.AsyncToolSpecification) obj);
            case 4:
                return McpServer.StatelessSyncSpecification.lambda$assertNoDuplicateTool$0(str, (McpStatelessServerFeatures.SyncToolSpecification) obj);
            case 5:
                return McpServer.SyncSpecification.lambda$assertNoDuplicateTool$0(str, (McpServerFeatures.SyncToolSpecification) obj);
            case 6:
                return McpStatelessAsyncServer.lambda$completionCompleteRequestHandler$28(str, (McpSchema.PromptArgument) obj);
            default:
                return McpStatelessAsyncServer.lambda$removeTool$6(str, (McpStatelessServerFeatures.AsyncToolSpecification) obj);
        }
    }
}
