package io.modelcontextprotocol.server;

import io.modelcontextprotocol.server.McpStatelessServerFeatures;
import java.util.function.Predicate;

/* loaded from: classes3.dex */
public final /* synthetic */ class F implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4700a;
    public final /* synthetic */ McpStatelessAsyncServer b;
    public final /* synthetic */ String c;

    public /* synthetic */ F(McpStatelessAsyncServer mcpStatelessAsyncServer, String str, int i) {
        this.f4700a = i;
        this.b = mcpStatelessAsyncServer;
        this.c = str;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f4700a) {
            case 0:
                return this.b.lambda$findResourceTemplateSpecification$23(this.c, (McpStatelessServerFeatures.AsyncResourceTemplateSpecification) obj);
            default:
                return this.b.lambda$findResourceSpecification$22(this.c, (McpStatelessServerFeatures.AsyncResourceSpecification) obj);
        }
    }
}
