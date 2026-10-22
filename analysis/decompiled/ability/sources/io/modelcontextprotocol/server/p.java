package io.modelcontextprotocol.server;

import io.modelcontextprotocol.server.McpServerFeatures;
import java.util.function.Predicate;

/* loaded from: classes3.dex */
public final /* synthetic */ class p implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4715a;
    public final /* synthetic */ McpAsyncServer b;
    public final /* synthetic */ String c;

    public /* synthetic */ p(McpAsyncServer mcpAsyncServer, String str, int i) {
        this.f4715a = i;
        this.b = mcpAsyncServer;
        this.c = str;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f4715a) {
            case 0:
                return this.b.lambda$findResourceTemplateSpecification$31(this.c, (McpServerFeatures.AsyncResourceTemplateSpecification) obj);
            default:
                return this.b.lambda$findResourceSpecification$30(this.c, (McpServerFeatures.AsyncResourceSpecification) obj);
        }
    }
}
