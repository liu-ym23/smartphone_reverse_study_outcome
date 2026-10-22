package io.modelcontextprotocol.spec;

import io.modelcontextprotocol.spec.McpStreamableServerSession;
import java.util.function.Supplier;

/* loaded from: classes3.dex */
public final /* synthetic */ class j implements Supplier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4748a;
    public final /* synthetic */ McpStreamableServerSession.McpStreamableServerSessionStream b;

    public /* synthetic */ j(McpStreamableServerSession.McpStreamableServerSessionStream mcpStreamableServerSessionStream, int i) {
        this.f4748a = i;
        this.b = mcpStreamableServerSessionStream;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int i = this.f4748a;
        McpStreamableServerSession.McpStreamableServerSessionStream mcpStreamableServerSessionStream = this.b;
        switch (i) {
            case 0:
                return mcpStreamableServerSessionStream.lambda$new$0();
            default:
                return mcpStreamableServerSessionStream.lambda$closeGracefully$6();
        }
    }
}
