package io.modelcontextprotocol.server;

import java.util.function.Supplier;

/* loaded from: classes3.dex */
public final /* synthetic */ class k implements Supplier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4711a;
    public final /* synthetic */ String b;

    public /* synthetic */ k(String str, int i) {
        this.f4711a = i;
        this.b = str;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int i = this.f4711a;
        String str = this.b;
        switch (i) {
            case 0:
                return McpAsyncServer.lambda$resourcesReadRequestHandler$27(str);
            default:
                return McpStatelessAsyncServer.lambda$resourcesReadRequestHandler$19(str);
        }
    }
}
