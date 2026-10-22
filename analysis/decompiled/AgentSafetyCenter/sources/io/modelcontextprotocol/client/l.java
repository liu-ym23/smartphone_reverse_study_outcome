package io.modelcontextprotocol.client;

import io.modelcontextprotocol.spec.McpClientSession;
import java.util.List;
import reactor.core.publisher.Mono;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class l implements McpClientSession.NotificationHandler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6129a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ McpAsyncClient f6130b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ List f6131c;

    public /* synthetic */ l(int i) {
        this.f6129a = i;
    }

    @Override // io.modelcontextprotocol.spec.McpClientSession.NotificationHandler
    public final Mono handle(Object obj) {
        switch (this.f6129a) {
            case 0:
                return this.f6130b.lambda$asyncResourcesChangeNotificationHandler$54(this.f6131c, obj);
            case 1:
                return this.f6130b.lambda$asyncPromptsChangeNotificationHandler$67(this.f6131c, obj);
            case 2:
                return this.f6130b.lambda$asyncResourcesUpdatedNotificationHandler$58(this.f6131c, obj);
            case 3:
                return this.f6130b.lambda$asyncLoggingNotificationHandler$69(this.f6131c, obj);
            case 4:
                return this.f6130b.lambda$asyncToolsChangeNotificationHandler$39(this.f6131c, obj);
            default:
                return this.f6130b.lambda$asyncProgressNotificationHandler$72(this.f6131c, obj);
        }
    }
}
