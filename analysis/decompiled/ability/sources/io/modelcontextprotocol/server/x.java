package io.modelcontextprotocol.server;

import io.modelcontextprotocol.server.McpServerFeatures;
import io.modelcontextprotocol.server.McpStatelessServerFeatures;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.HashMap;
import java.util.function.BiConsumer;

/* loaded from: classes3.dex */
public final /* synthetic */ class x implements BiConsumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4736a;
    public final /* synthetic */ HashMap b;
    public final /* synthetic */ boolean c;

    public /* synthetic */ x(HashMap map, boolean z10, int i) {
        this.f4736a = i;
        this.b = map;
        this.c = z10;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        switch (this.f4736a) {
            case 0:
                McpServerFeatures.Async.lambda$fromSync$0(this.b, this.c, (String) obj, (McpServerFeatures.SyncResourceSpecification) obj2);
                break;
            case 1:
                McpServerFeatures.Async.lambda$fromSync$1(this.b, this.c, (String) obj, (McpServerFeatures.SyncResourceTemplateSpecification) obj2);
                break;
            case 2:
                McpServerFeatures.Async.lambda$fromSync$2(this.b, this.c, (String) obj, (McpServerFeatures.SyncPromptSpecification) obj2);
                break;
            case 3:
                McpServerFeatures.Async.lambda$fromSync$3(this.b, this.c, (McpSchema.CompleteReference) obj, (McpServerFeatures.SyncCompletionSpecification) obj2);
                break;
            case 4:
                McpStatelessServerFeatures.Async.lambda$fromSync$0(this.b, this.c, (String) obj, (McpStatelessServerFeatures.SyncResourceSpecification) obj2);
                break;
            case 5:
                McpStatelessServerFeatures.Async.lambda$fromSync$1(this.b, this.c, (String) obj, (McpStatelessServerFeatures.SyncResourceTemplateSpecification) obj2);
                break;
            case 6:
                McpStatelessServerFeatures.Async.lambda$fromSync$2(this.b, this.c, (String) obj, (McpStatelessServerFeatures.SyncPromptSpecification) obj2);
                break;
            default:
                McpStatelessServerFeatures.Async.lambda$fromSync$3(this.b, this.c, (McpSchema.CompleteReference) obj, (McpStatelessServerFeatures.SyncCompletionSpecification) obj2);
                break;
        }
    }
}
