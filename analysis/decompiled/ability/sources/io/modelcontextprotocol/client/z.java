package io.modelcontextprotocol.client;

import io.modelcontextprotocol.client.McpClientFeatures;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final /* synthetic */ class z implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4686a;
    public final /* synthetic */ McpClientFeatures.Sync b;
    public final /* synthetic */ B7.a c;

    public /* synthetic */ z(McpClientFeatures.Sync sync, B7.a aVar, int i) {
        this.f4686a = i;
        this.b = sync;
        this.c = aVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f4686a) {
            case 0:
                return McpClientFeatures.Async.lambda$fromSync$12(this.b, (McpSchema.CreateMessageRequest) this.c);
            default:
                return McpClientFeatures.Async.lambda$fromSync$14(this.b, (McpSchema.ElicitRequest) this.c);
        }
    }
}
