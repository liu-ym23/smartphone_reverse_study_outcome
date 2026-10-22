package io.modelcontextprotocol.client;

import io.modelcontextprotocol.client.LifecycleInitializer;
import java.util.function.Function;

/* loaded from: classes2.dex */
public final /* synthetic */ class m implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4642a;
    public final /* synthetic */ String b;

    public /* synthetic */ m(String str, int i) {
        this.f4642a = i;
        this.b = str;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f4642a;
        String str = this.b;
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
