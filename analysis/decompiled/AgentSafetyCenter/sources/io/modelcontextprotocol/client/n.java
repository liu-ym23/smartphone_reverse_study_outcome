package io.modelcontextprotocol.client;

import io.modelcontextprotocol.client.LifecycleInitializer;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.Function;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class n implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6134a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ McpAsyncClient f6135b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ McpSchema.CallToolRequest f6136c;

    public /* synthetic */ n(int i) {
        this.f6134a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f6134a) {
            case 0:
                return this.f6135b.lambda$callTool$28(this.f6136c, (LifecycleInitializer.Initialization) obj);
            default:
                return this.f6135b.lambda$callTool$27(this.f6136c, (McpSchema.CallToolResult) obj);
        }
    }
}
