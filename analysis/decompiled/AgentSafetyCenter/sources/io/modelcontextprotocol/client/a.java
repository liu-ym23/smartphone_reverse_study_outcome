package io.modelcontextprotocol.client;

import io.modelcontextprotocol.client.LifecycleInitializer;
import io.modelcontextprotocol.spec.McpClientSession;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.Function;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6107a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f6108b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f6109c;

    public /* synthetic */ a(int i) {
        this.f6107a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f6107a) {
            case 0:
                return ((LifecycleInitializer) this.f6108b).lambda$doInitialize$4((McpClientSession) this.f6109c, (McpSchema.InitializeResult) obj);
            case 1:
                return LifecycleInitializer.lambda$doInitialize$5((LifecycleInitializer.DefaultInitialization) this.f6108b, (Function) this.f6109c, (McpSchema.InitializeResult) obj);
            default:
                return ((McpAsyncClient) this.f6108b).lambda$listTools$32((String) this.f6109c, (LifecycleInitializer.Initialization) obj);
        }
    }
}
