package io.modelcontextprotocol.server;

import io.modelcontextprotocol.spec.McpServerSession;
import io.modelcontextprotocol.spec.McpServerTransport;
import java.time.Duration;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class f implements McpServerSession.Factory {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ McpAsyncServer f6263a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Duration f6264b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Map f6265c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Map f6266d;

    @Override // io.modelcontextprotocol.spec.McpServerSession.Factory
    public final McpServerSession create(McpServerTransport mcpServerTransport) {
        return this.f6263a.lambda$new$0(this.f6264b, this.f6265c, this.f6266d, mcpServerTransport);
    }
}
