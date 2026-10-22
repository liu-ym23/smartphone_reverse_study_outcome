package io.modelcontextprotocol.client;

import io.modelcontextprotocol.client.LifecycleInitializer;
import io.modelcontextprotocol.spec.McpClientSession;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.Function;

/* loaded from: classes2.dex */
public final /* synthetic */ class a implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4630a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ a(int i, Object obj, Object obj2) {
        this.f4630a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f4630a) {
            case 0:
                return ((LifecycleInitializer) this.b).lambda$doInitialize$4((McpClientSession) this.c, (McpSchema.InitializeResult) obj);
            case 1:
                return LifecycleInitializer.lambda$doInitialize$5((LifecycleInitializer.DefaultInitialization) this.b, (Function) this.c, (McpSchema.InitializeResult) obj);
            default:
                return ((McpAsyncClient) this.b).lambda$listTools$32((String) this.c, (LifecycleInitializer.Initialization) obj);
        }
    }
}
