package io.modelcontextprotocol.client;

import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.Predicate;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class j implements Predicate {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6126c;

    public /* synthetic */ j(int i) {
        this.f6126c = i;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        McpSchema.Tool tool = (McpSchema.Tool) obj;
        switch (this.f6126c) {
            case 0:
                return McpAsyncClient.lambda$listToolsInternal$33(tool);
            default:
                return McpAsyncClient.lambda$new$14(tool);
        }
    }
}
