package io.modelcontextprotocol.client;

import io.modelcontextprotocol.spec.McpClientSession;
import java.util.List;
import reactor.core.publisher.Mono;

/* loaded from: classes2.dex */
public final /* synthetic */ class l implements McpClientSession.NotificationHandler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4641a;
    public final /* synthetic */ McpAsyncClient b;
    public final /* synthetic */ List c;

    public /* synthetic */ l(McpAsyncClient mcpAsyncClient, List list, int i) {
        this.f4641a = i;
        this.b = mcpAsyncClient;
        this.c = list;
    }

    @Override // io.modelcontextprotocol.spec.McpClientSession.NotificationHandler
    public final Mono handle(Object obj) {
        switch (this.f4641a) {
            case 0:
                return this.b.lambda$asyncResourcesChangeNotificationHandler$54(this.c, obj);
            case 1:
                return this.b.lambda$asyncPromptsChangeNotificationHandler$67(this.c, obj);
            case 2:
                return this.b.lambda$asyncResourcesUpdatedNotificationHandler$58(this.c, obj);
            case 3:
                return this.b.lambda$asyncLoggingNotificationHandler$69(this.c, obj);
            case 4:
                return this.b.lambda$asyncToolsChangeNotificationHandler$39(this.c, obj);
            default:
                return this.b.lambda$asyncProgressNotificationHandler$72(this.c, obj);
        }
    }
}
