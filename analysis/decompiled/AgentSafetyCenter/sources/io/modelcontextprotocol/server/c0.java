package io.modelcontextprotocol.server;

import java.util.function.Supplier;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class c0 implements Supplier {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6251c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ McpStatelessAsyncServer f6252f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ String f6253g;

    public /* synthetic */ c0(int i) {
        this.f6251c = i;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f6251c) {
            case 0:
                return this.f6252f.lambda$removeTool$7(this.f6253g);
            case 1:
                return this.f6252f.lambda$removeResourceTemplate$14(this.f6253g);
            case 2:
                return this.f6252f.lambda$removePrompt$25(this.f6253g);
            default:
                return this.f6252f.lambda$removeResource$12(this.f6253g);
        }
    }
}
