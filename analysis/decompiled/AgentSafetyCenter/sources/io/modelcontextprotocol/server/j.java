package io.modelcontextprotocol.server;

import java.util.function.Supplier;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class j implements Supplier {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6276c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ String f6277f;

    public /* synthetic */ j(int i) {
        this.f6276c = i;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int i = this.f6276c;
        String str = this.f6277f;
        switch (i) {
            case 0:
                return McpAsyncServer.lambda$resourcesReadRequestHandler$27(str);
            default:
                return McpStatelessAsyncServer.lambda$resourcesReadRequestHandler$19(str);
        }
    }
}
