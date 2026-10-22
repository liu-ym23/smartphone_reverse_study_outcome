package io.modelcontextprotocol.client;

import io.modelcontextprotocol.client.McpClientFeatures;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class z implements Callable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6229c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ McpClientFeatures.Sync f6230f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ androidx.activity.b f6231g;

    public /* synthetic */ z(int i) {
        this.f6229c = i;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f6229c) {
            case 0:
                return McpClientFeatures.Async.lambda$fromSync$12(this.f6230f, (McpSchema.CreateMessageRequest) this.f6231g);
            default:
                return McpClientFeatures.Async.lambda$fromSync$14(this.f6230f, (McpSchema.ElicitRequest) this.f6231g);
        }
    }
}
