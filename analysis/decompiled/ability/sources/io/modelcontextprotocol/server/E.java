package io.modelcontextprotocol.server;

import java.util.function.Supplier;

/* loaded from: classes3.dex */
public final /* synthetic */ class E implements Supplier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4699a;
    public final /* synthetic */ McpStatelessAsyncServer b;
    public final /* synthetic */ String c;

    public /* synthetic */ E(McpStatelessAsyncServer mcpStatelessAsyncServer, String str, int i) {
        this.f4699a = i;
        this.b = mcpStatelessAsyncServer;
        this.c = str;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f4699a) {
            case 0:
                return this.b.lambda$removeTool$7(this.c);
            case 1:
                return this.b.lambda$removeResourceTemplate$14(this.c);
            case 2:
                return this.b.lambda$removePrompt$25(this.c);
            default:
                return this.b.lambda$removeResource$12(this.c);
        }
    }
}
