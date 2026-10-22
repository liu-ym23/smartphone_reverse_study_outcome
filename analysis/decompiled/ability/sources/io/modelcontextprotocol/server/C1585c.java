package io.modelcontextprotocol.server;

import io.modelcontextprotocol.server.McpServerFeatures;
import io.modelcontextprotocol.server.McpStatelessServerFeatures;
import java.util.function.Predicate;

/* renamed from: io.modelcontextprotocol.server.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final /* synthetic */ class C1585c implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4703a;
    public final /* synthetic */ B7.a b;

    public /* synthetic */ C1585c(B7.a aVar, int i) {
        this.f4703a = i;
        this.b = aVar;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        int i = this.f4703a;
        B7.a aVar = this.b;
        switch (i) {
            case 0:
                return McpAsyncServer.lambda$addTool$11((McpServerFeatures.AsyncToolSpecification) aVar, (McpServerFeatures.AsyncToolSpecification) obj);
            default:
                return McpStatelessAsyncServer.lambda$addTool$4((McpStatelessServerFeatures.AsyncToolSpecification) aVar, (McpStatelessServerFeatures.AsyncToolSpecification) obj);
        }
    }
}
