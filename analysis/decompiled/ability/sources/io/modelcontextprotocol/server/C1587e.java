package io.modelcontextprotocol.server;

import java.util.function.Supplier;

/* renamed from: io.modelcontextprotocol.server.e, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final /* synthetic */ class C1587e implements Supplier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4705a;
    public final /* synthetic */ McpAsyncServer b;
    public final /* synthetic */ String c;

    public /* synthetic */ C1587e(McpAsyncServer mcpAsyncServer, String str, int i) {
        this.f4705a = i;
        this.b = mcpAsyncServer;
        this.c = str;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f4705a) {
            case 0:
                return this.b.lambda$removeTool$15(this.c);
            case 1:
                return this.b.lambda$removeResource$20(this.c);
            case 2:
                return this.b.lambda$removeResourceTemplate$22(this.c);
            default:
                return this.b.lambda$removePrompt$33(this.c);
        }
    }
}
