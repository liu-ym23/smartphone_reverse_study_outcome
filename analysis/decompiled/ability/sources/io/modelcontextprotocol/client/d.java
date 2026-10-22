package io.modelcontextprotocol.client;

import io.modelcontextprotocol.client.LifecycleInitializer;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.List;
import java.util.function.Function;

/* loaded from: classes2.dex */
public final /* synthetic */ class d implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4633a;

    public /* synthetic */ d(int i) {
        this.f4633a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f4633a) {
            case 0:
                return LifecycleInitializer.lambda$handleException$0((LifecycleInitializer.Initialization) obj);
            case 1:
                return McpAsyncClient.lambda$ping$22((LifecycleInitializer.Initialization) obj);
            case 2:
                return McpAsyncClient.lambda$rootsListChangedNotification$23((LifecycleInitializer.Initialization) obj);
            case 3:
                return McpAsyncClient.lambda$initialize$21((LifecycleInitializer.Initialization) obj);
            case 4:
                return McpAsyncClient.lambda$asyncToolsChangeNotificationHandler$37((Throwable) obj);
            case 5:
                return McpAsyncClient.lambda$listPrompts$61((McpSchema.ListPromptsResult) obj);
            case 6:
                return McpAsyncClient.lambda$asyncResourcesUpdatedNotificationHandler$56((Throwable) obj);
            case 7:
                return McpAsyncClient.lambda$new$2((List) obj);
            case 8:
                return McpAsyncClient.lambda$new$4((List) obj);
            case 9:
                return McpAsyncClient.lambda$new$6((List) obj);
            case 10:
                return McpAsyncClient.lambda$new$8((List) obj);
            case 11:
                return McpAsyncClient.lambda$new$10((McpSchema.LoggingMessageNotification) obj);
            case 12:
                return McpAsyncClient.lambda$new$12((McpSchema.ProgressNotification) obj);
            case 13:
                return McpAsyncClient.lambda$listTools$31((McpSchema.ListToolsResult) obj);
            case 14:
                return McpAsyncClient.lambda$asyncPromptsChangeNotificationHandler$65((Throwable) obj);
            case 15:
                return McpAsyncClient.lambda$listResourceTemplates$47((McpSchema.ListResourceTemplatesResult) obj);
            case 16:
                return McpAsyncClient.lambda$asyncResourcesChangeNotificationHandler$52((Throwable) obj);
            default:
                return McpAsyncClient.lambda$listResources$42((McpSchema.ListResourcesResult) obj);
        }
    }
}
