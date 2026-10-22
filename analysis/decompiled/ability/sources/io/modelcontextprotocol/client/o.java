package io.modelcontextprotocol.client;

import io.modelcontextprotocol.spec.McpSchema;

/* loaded from: classes2.dex */
public final /* synthetic */ class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4644a;
    public final /* synthetic */ B7.a b;

    public /* synthetic */ o(B7.a aVar, int i) {
        this.f4644a = i;
        this.b = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f4644a;
        B7.a aVar = this.b;
        switch (i) {
            case 0:
                McpAsyncClient.lambda$new$11((McpSchema.ProgressNotification) aVar);
                break;
            default:
                McpAsyncClient.lambda$new$9((McpSchema.LoggingMessageNotification) aVar);
                break;
        }
    }
}
