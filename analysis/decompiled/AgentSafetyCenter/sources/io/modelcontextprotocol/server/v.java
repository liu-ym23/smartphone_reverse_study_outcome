package io.modelcontextprotocol.server;

import io.modelcontextprotocol.server.McpServerFeatures;
import io.modelcontextprotocol.server.McpStatelessServerFeatures;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.HashMap;
import java.util.function.BiConsumer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class v implements BiConsumer {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6326c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ HashMap f6327f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ boolean f6328g;

    public /* synthetic */ v(int i) {
        this.f6326c = i;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        switch (this.f6326c) {
            case 0:
                McpServerFeatures.Async.lambda$fromSync$0(this.f6327f, this.f6328g, (String) obj, (McpServerFeatures.SyncResourceSpecification) obj2);
                break;
            case 1:
                McpServerFeatures.Async.lambda$fromSync$1(this.f6327f, this.f6328g, (String) obj, (McpServerFeatures.SyncResourceTemplateSpecification) obj2);
                break;
            case 2:
                McpServerFeatures.Async.lambda$fromSync$2(this.f6327f, this.f6328g, (String) obj, (McpServerFeatures.SyncPromptSpecification) obj2);
                break;
            case 3:
                McpServerFeatures.Async.lambda$fromSync$3(this.f6327f, this.f6328g, (McpSchema.CompleteReference) obj, (McpServerFeatures.SyncCompletionSpecification) obj2);
                break;
            case 4:
                McpStatelessServerFeatures.Async.lambda$fromSync$0(this.f6327f, this.f6328g, (String) obj, (McpStatelessServerFeatures.SyncResourceSpecification) obj2);
                break;
            case 5:
                McpStatelessServerFeatures.Async.lambda$fromSync$1(this.f6327f, this.f6328g, (String) obj, (McpStatelessServerFeatures.SyncResourceTemplateSpecification) obj2);
                break;
            case 6:
                McpStatelessServerFeatures.Async.lambda$fromSync$2(this.f6327f, this.f6328g, (String) obj, (McpStatelessServerFeatures.SyncPromptSpecification) obj2);
                break;
            default:
                McpStatelessServerFeatures.Async.lambda$fromSync$3(this.f6327f, this.f6328g, (McpSchema.CompleteReference) obj, (McpStatelessServerFeatures.SyncCompletionSpecification) obj2);
                break;
        }
    }
}
