package io.modelcontextprotocol.client;

import io.modelcontextprotocol.client.LifecycleInitializer;
import java.util.function.Function;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class m implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6132a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ String f6133b;

    public /* synthetic */ m(int i) {
        this.f6132a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f6132a;
        String str = this.f6133b;
        LifecycleInitializer.Initialization initialization = (LifecycleInitializer.Initialization) obj;
        switch (i) {
            case 0:
                return McpAsyncClient.lambda$listPrompts$62(str, initialization);
            case 1:
                return McpAsyncClient.lambda$listResourceTemplates$48(str, initialization);
            default:
                return McpAsyncClient.lambda$listResources$43(str, initialization);
        }
    }
}
