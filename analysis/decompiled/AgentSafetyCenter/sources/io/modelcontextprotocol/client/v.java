package io.modelcontextprotocol.client;

import io.modelcontextprotocol.client.McpClientFeatures;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class v implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6219a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Consumer f6220b;

    public /* synthetic */ v(int i) {
        this.f6219a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f6219a;
        Consumer consumer = this.f6220b;
        switch (i) {
            case 0:
                return McpClientFeatures.Async.lambda$fromSync$5(consumer, (List) obj);
            case 1:
                return McpClientFeatures.Async.lambda$fromSync$7(consumer, (List) obj);
            case 2:
                return McpClientFeatures.Async.lambda$fromSync$9(consumer, (McpSchema.LoggingMessageNotification) obj);
            case 3:
                return McpClientFeatures.Async.lambda$fromSync$11(consumer, (McpSchema.ProgressNotification) obj);
            case 4:
                return McpClientFeatures.Async.lambda$fromSync$1(consumer, (List) obj);
            default:
                return McpClientFeatures.Async.lambda$fromSync$3(consumer, (List) obj);
        }
    }
}
