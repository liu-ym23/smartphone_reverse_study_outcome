package io.modelcontextprotocol.client;

import java.util.function.Supplier;

/* loaded from: classes2.dex */
public final /* synthetic */ class e implements Supplier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4634a;
    public final /* synthetic */ Object b;

    public /* synthetic */ e(Object obj, int i) {
        this.f4634a = i;
        this.b = obj;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int i = this.f4634a;
        Object obj = this.b;
        switch (i) {
            case 0:
                return ((LifecycleInitializer) obj).lambda$closeGracefully$7();
            default:
                return ((McpAsyncClient) obj).lambda$closeGracefully$20();
        }
    }
}
