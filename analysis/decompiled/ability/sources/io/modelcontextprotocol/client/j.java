package io.modelcontextprotocol.client;

import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.Predicate;

/* loaded from: classes2.dex */
public final /* synthetic */ class j implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4639a;

    public /* synthetic */ j(int i) {
        this.f4639a = i;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        McpSchema.Tool tool = (McpSchema.Tool) obj;
        switch (this.f4639a) {
            case 0:
                return McpAsyncClient.lambda$listToolsInternal$33(tool);
            default:
                return McpAsyncClient.lambda$new$14(tool);
        }
    }
}
