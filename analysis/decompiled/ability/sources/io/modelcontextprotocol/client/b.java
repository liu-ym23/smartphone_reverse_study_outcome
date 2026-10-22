package io.modelcontextprotocol.client;

import io.modelcontextprotocol.client.LifecycleInitializer;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class b implements Consumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4631a;
    public final /* synthetic */ Object b;

    public /* synthetic */ b(Object obj, int i) {
        this.f4631a = i;
        this.b = obj;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.f4631a;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                int i6 = LifecycleInitializer.f4629a;
                ((LifecycleInitializer.DefaultInitialization) obj2).complete((McpSchema.InitializeResult) obj);
                break;
            default:
                ((LifecycleInitializer) obj2).handleException((Throwable) obj);
                break;
        }
    }
}
