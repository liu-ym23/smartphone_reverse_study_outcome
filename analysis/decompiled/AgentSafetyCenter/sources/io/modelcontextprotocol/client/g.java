package io.modelcontextprotocol.client;

import io.modelcontextprotocol.spec.McpSchema;
import java.util.List;
import java.util.function.Function;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6121a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ List f6122b;

    public /* synthetic */ g(int i) {
        this.f6121a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f6121a;
        List list = this.f6122b;
        switch (i) {
            case 0:
                return McpAsyncClient.lambda$asyncResourcesChangeNotificationHandler$53(list, (McpSchema.ListResourcesResult) obj);
            case 1:
                return McpAsyncClient.lambda$asyncToolsChangeNotificationHandler$38(list, (McpSchema.ListToolsResult) obj);
            case 2:
                return McpAsyncClient.lambda$asyncResourcesUpdatedNotificationHandler$57(list, (McpSchema.ReadResourceResult) obj);
            default:
                return McpAsyncClient.lambda$asyncPromptsChangeNotificationHandler$66(list, (McpSchema.ListPromptsResult) obj);
        }
    }
}
