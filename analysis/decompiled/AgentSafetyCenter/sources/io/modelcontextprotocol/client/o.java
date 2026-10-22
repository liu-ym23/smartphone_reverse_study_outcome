package io.modelcontextprotocol.client;

import io.modelcontextprotocol.spec.McpSchema;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class o implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6137c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ androidx.activity.b f6138f;

    public /* synthetic */ o(int i) {
        this.f6137c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f6137c;
        androidx.activity.b bVar = this.f6138f;
        switch (i) {
            case 0:
                McpAsyncClient.lambda$new$11((McpSchema.ProgressNotification) bVar);
                break;
            default:
                McpAsyncClient.lambda$new$9((McpSchema.LoggingMessageNotification) bVar);
                break;
        }
    }
}
