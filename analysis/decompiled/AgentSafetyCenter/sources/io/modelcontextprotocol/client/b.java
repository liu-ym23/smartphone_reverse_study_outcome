package io.modelcontextprotocol.client;

import io.modelcontextprotocol.client.LifecycleInitializer;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.Consumer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements Consumer {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6110c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f6111f;

    public /* synthetic */ b(int i) {
        this.f6110c = i;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.f6110c;
        Object obj2 = this.f6111f;
        switch (i) {
            case 0:
                int i3 = LifecycleInitializer.f6106a;
                ((LifecycleInitializer.DefaultInitialization) obj2).complete((McpSchema.InitializeResult) obj);
                break;
            default:
                ((LifecycleInitializer) obj2).handleException((Throwable) obj);
                break;
        }
    }
}
