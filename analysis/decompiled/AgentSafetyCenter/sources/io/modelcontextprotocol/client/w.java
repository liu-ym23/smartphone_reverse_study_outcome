package io.modelcontextprotocol.client;

import io.modelcontextprotocol.client.McpClientFeatures;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.Function;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class w implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6221a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ McpClientFeatures.Sync f6222b;

    public /* synthetic */ w(int i) {
        this.f6221a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f6221a;
        McpClientFeatures.Sync sync = this.f6222b;
        switch (i) {
            case 0:
                return McpClientFeatures.Async.lambda$fromSync$13(sync, (McpSchema.CreateMessageRequest) obj);
            default:
                return McpClientFeatures.Async.lambda$fromSync$15(sync, (McpSchema.ElicitRequest) obj);
        }
    }
}
