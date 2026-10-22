package io.modelcontextprotocol.spec;

import io.modelcontextprotocol.spec.McpStreamableServerSession;
import java.util.function.Supplier;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements Supplier {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6364c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ McpStreamableServerSession.McpStreamableServerSessionStream f6365f;

    public /* synthetic */ g(int i) {
        this.f6364c = i;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int i = this.f6364c;
        McpStreamableServerSession.McpStreamableServerSessionStream mcpStreamableServerSessionStream = this.f6365f;
        switch (i) {
            case 0:
                return mcpStreamableServerSessionStream.lambda$new$0();
            default:
                return mcpStreamableServerSessionStream.lambda$closeGracefully$6();
        }
    }
}
