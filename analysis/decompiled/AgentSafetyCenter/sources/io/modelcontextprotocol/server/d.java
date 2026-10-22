package io.modelcontextprotocol.server;

import java.util.function.Supplier;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements Supplier {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6254c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ McpAsyncServer f6255f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ String f6256g;

    public /* synthetic */ d(int i) {
        this.f6254c = i;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f6254c) {
            case 0:
                return this.f6255f.lambda$removeTool$15(this.f6256g);
            case 1:
                return this.f6255f.lambda$removeResource$20(this.f6256g);
            case 2:
                return this.f6255f.lambda$removeResourceTemplate$22(this.f6256g);
            default:
                return this.f6255f.lambda$removePrompt$33(this.f6256g);
        }
    }
}
