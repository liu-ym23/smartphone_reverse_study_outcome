package io.modelcontextprotocol.client;

import io.modelcontextprotocol.client.LifecycleInitializer;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.Function;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;
import reactor.util.context.ContextView;

/* loaded from: classes2.dex */
public final /* synthetic */ class c implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4632a;
    public final /* synthetic */ Object b;

    public /* synthetic */ c(Object obj, int i) {
        this.f4632a = i;
        this.b = obj;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f4632a;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                return LifecycleInitializer.lambda$doInitialize$6((LifecycleInitializer.DefaultInitialization) obj2, (Throwable) obj);
            case 1:
                return ((LifecycleInitializer) obj2).lambda$withInitialization$1((McpSchema.InitializeResult) obj);
            case 2:
                return McpAsyncClient.lambda$completeCompletion$73((McpSchema.CompleteRequest) obj2, (LifecycleInitializer.Initialization) obj);
            case 3:
                return McpAsyncClient.lambda$subscribeResource$49((McpSchema.SubscribeRequest) obj2, (LifecycleInitializer.Initialization) obj);
            case 4:
                return McpAsyncClient.lambda$getPrompt$63((McpSchema.GetPromptRequest) obj2, (LifecycleInitializer.Initialization) obj);
            case 5:
                return McpAsyncClient.lambda$unsubscribeResource$50((McpSchema.UnsubscribeRequest) obj2, (LifecycleInitializer.Initialization) obj);
            case 6:
                return McpAsyncClient.lambda$setLoggingLevel$70((McpSchema.LoggingLevel) obj2, (LifecycleInitializer.Initialization) obj);
            case 7:
                return McpAsyncClient.lambda$readResource$44((McpSchema.ReadResourceRequest) obj2, (LifecycleInitializer.Initialization) obj);
            case 8:
                return McpAsyncClient.lambda$asyncToolsChangeNotificationHandler$36((McpSchema.ListToolsResult) obj2, (Function) obj);
            case 9:
                return McpAsyncClient.lambda$asyncLoggingNotificationHandler$68((McpSchema.LoggingMessageNotification) obj2, (Function) obj);
            case 10:
                return McpAsyncClient.lambda$asyncResourcesUpdatedNotificationHandler$55((McpSchema.ReadResourceResult) obj2, (Function) obj);
            case 11:
                return McpAsyncClient.lambda$asyncProgressNotificationHandler$71((McpSchema.ProgressNotification) obj2, (Function) obj);
            case 12:
                return McpAsyncClient.lambda$asyncPromptsChangeNotificationHandler$64((McpSchema.ListPromptsResult) obj2, (Function) obj);
            case 13:
                return McpAsyncClient.lambda$asyncResourcesChangeNotificationHandler$51((McpSchema.ListResourcesResult) obj2, (Function) obj);
            case 14:
                return McpAsyncClient.lambda$new$18((ContextView) obj2, (Mono) obj);
            default:
                return ((McpSyncClient) obj2).lambda$withProvidedContext$0((Context) obj);
        }
    }
}
