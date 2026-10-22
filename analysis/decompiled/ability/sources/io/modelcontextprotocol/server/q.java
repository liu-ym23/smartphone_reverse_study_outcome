package io.modelcontextprotocol.server;

import io.modelcontextprotocol.server.McpServer;
import io.modelcontextprotocol.server.McpServerFeatures;
import io.modelcontextprotocol.server.McpStatelessServerFeatures;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.Predicate;

/* loaded from: classes3.dex */
public final /* synthetic */ class q implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4716a;
    public final /* synthetic */ String b;

    public /* synthetic */ q(String str, int i) {
        this.f4716a = i;
        this.b = str;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        int i = this.f4716a;
        String str = this.b;
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
