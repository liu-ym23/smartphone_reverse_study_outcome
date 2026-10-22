package io.modelcontextprotocol.client;

import io.modelcontextprotocol.spec.McpSchema;
import java.util.List;
import java.util.function.Function;

/* loaded from: classes2.dex */
public final /* synthetic */ class g implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4636a;
    public final /* synthetic */ List b;

    public /* synthetic */ g(List list, int i) {
        this.f4636a = i;
        this.b = list;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f4636a;
        List list = this.b;
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
