package io.modelcontextprotocol.client;

import java.util.function.Supplier;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements Supplier {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6115c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f6116f;

    public /* synthetic */ e(int i) {
        this.f6115c = i;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int i = this.f6115c;
        Object obj = this.f6116f;
        switch (i) {
            case 0:
                return ((LifecycleInitializer) obj).lambda$closeGracefully$7();
            default:
                return ((McpAsyncClient) obj).lambda$closeGracefully$20();
        }
    }
}
