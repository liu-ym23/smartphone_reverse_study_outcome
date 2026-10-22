package io.modelcontextprotocol.client;

import io.modelcontextprotocol.client.LifecycleInitializer;
import io.modelcontextprotocol.client.McpClientFeatures;
import io.modelcontextprotocol.json.TypeRef;
import io.modelcontextprotocol.json.schema.JsonSchemaValidator;
import io.modelcontextprotocol.spec.McpClientSession;
import io.modelcontextprotocol.spec.McpClientTransport;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.util.Assert;
import io.modelcontextprotocol.util.Utils;
import java.lang.invoke.VarHandle;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Stream;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.context.ContextView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class McpAsyncClient {
    private final McpSchema.ClientCapabilities clientCapabilities;
    private final McpSchema.Implementation clientInfo;
    private Function<McpSchema.ElicitRequest, Mono<McpSchema.ElicitResult>> elicitationHandler;
    private final boolean enableCallToolSchemaCaching;
    private final LifecycleInitializer initializer;
    private final JsonSchemaValidator jsonSchemaValidator;
    private final ConcurrentHashMap<String, McpSchema.Root> roots;
    private Function<McpSchema.CreateMessageRequest, Mono<McpSchema.CreateMessageResult>> samplingHandler;
    private final ConcurrentHashMap<String, Map<String, Object>> toolsOutputSchemaCache;
    private final McpClientTransport transport;
    private static final rd.b logger = rd.d.b(McpAsyncClient.class);
    private static final TypeRef<Void> VOID_TYPE_REFERENCE = new TypeRef<Void>() { // from class: io.modelcontextprotocol.client.McpAsyncClient.1
    };
    public static final TypeRef<Object> OBJECT_TYPE_REF = new TypeRef<Object>() { // from class: io.modelcontextprotocol.client.McpAsyncClient.2
    };
    public static final TypeRef<McpSchema.PaginatedRequest> PAGINATED_REQUEST_TYPE_REF = new TypeRef<McpSchema.PaginatedRequest>() { // from class: io.modelcontextprotocol.client.McpAsyncClient.3
    };
    public static final TypeRef<McpSchema.InitializeResult> INITIALIZE_RESULT_TYPE_REF = new TypeRef<McpSchema.InitializeResult>() { // from class: io.modelcontextprotocol.client.McpAsyncClient.4
    };
    public static final TypeRef<McpSchema.CreateMessageRequest> CREATE_MESSAGE_REQUEST_TYPE_REF = new TypeRef<McpSchema.CreateMessageRequest>() { // from class: io.modelcontextprotocol.client.McpAsyncClient.5
    };
    public static final TypeRef<McpSchema.LoggingMessageNotification> LOGGING_MESSAGE_NOTIFICATION_TYPE_REF = new TypeRef<McpSchema.LoggingMessageNotification>() { // from class: io.modelcontextprotocol.client.McpAsyncClient.6
    };
    public static final TypeRef<McpSchema.ProgressNotification> PROGRESS_NOTIFICATION_TYPE_REF = new TypeRef<McpSchema.ProgressNotification>() { // from class: io.modelcontextprotocol.client.McpAsyncClient.7
    };
    private static final TypeRef<McpSchema.CallToolResult> CALL_TOOL_RESULT_TYPE_REF = new TypeRef<McpSchema.CallToolResult>() { // from class: io.modelcontextprotocol.client.McpAsyncClient.9
    };
    private static final TypeRef<McpSchema.ListToolsResult> LIST_TOOLS_RESULT_TYPE_REF = new TypeRef<McpSchema.ListToolsResult>() { // from class: io.modelcontextprotocol.client.McpAsyncClient.10
    };
    private static final TypeRef<McpSchema.ListResourcesResult> LIST_RESOURCES_RESULT_TYPE_REF = new TypeRef<McpSchema.ListResourcesResult>() { // from class: io.modelcontextprotocol.client.McpAsyncClient.11
    };
    private static final TypeRef<McpSchema.ReadResourceResult> READ_RESOURCE_RESULT_TYPE_REF = new TypeRef<McpSchema.ReadResourceResult>() { // from class: io.modelcontextprotocol.client.McpAsyncClient.12
    };
    private static final TypeRef<McpSchema.ListResourceTemplatesResult> LIST_RESOURCE_TEMPLATES_RESULT_TYPE_REF = new TypeRef<McpSchema.ListResourceTemplatesResult>() { // from class: io.modelcontextprotocol.client.McpAsyncClient.13
    };
    private static final TypeRef<McpSchema.ListPromptsResult> LIST_PROMPTS_RESULT_TYPE_REF = new TypeRef<McpSchema.ListPromptsResult>() { // from class: io.modelcontextprotocol.client.McpAsyncClient.15
    };
    private static final TypeRef<McpSchema.GetPromptResult> GET_PROMPT_RESULT_TYPE_REF = new TypeRef<McpSchema.GetPromptResult>() { // from class: io.modelcontextprotocol.client.McpAsyncClient.16
    };
    private static final TypeRef<McpSchema.CompleteResult> COMPLETION_COMPLETE_RESULT_TYPE_REF = new TypeRef<McpSchema.CompleteResult>() { // from class: io.modelcontextprotocol.client.McpAsyncClient.17
    };

    public McpAsyncClient(McpClientTransport mcpClientTransport, Duration duration, Duration duration2, JsonSchemaValidator jsonSchemaValidator, McpClientFeatures.Async async) {
        Assert.notNull(mcpClientTransport, "Transport must not be null");
        Assert.notNull(duration, "Request timeout must not be null");
        Assert.notNull(duration2, "Initialization timeout must not be null");
        McpSchema.Implementation implementationClientInfo = async.clientInfo();
        this.clientInfo = implementationClientInfo;
        McpSchema.ClientCapabilities clientCapabilities = async.clientCapabilities();
        this.clientCapabilities = clientCapabilities;
        this.transport = mcpClientTransport;
        this.roots = new ConcurrentHashMap<>(async.roots());
        this.jsonSchemaValidator = jsonSchemaValidator;
        this.toolsOutputSchemaCache = new ConcurrentHashMap<>();
        this.enableCallToolSchemaCaching = async.enableCallToolSchemaCaching();
        HashMap map = new HashMap();
        map.put(McpSchema.METHOD_PING, new p());
        if (clientCapabilities.roots() != null) {
            map.put(McpSchema.METHOD_ROOTS_LIST, rootsListRequestHandler());
        }
        if (clientCapabilities.sampling() != null) {
            if (async.samplingHandler() == null) {
                g5.f.s("Sampling handler must not be null when client capabilities include sampling");
                throw null;
            }
            this.samplingHandler = async.samplingHandler();
            map.put(McpSchema.METHOD_SAMPLING_CREATE_MESSAGE, samplingCreateMessageHandler());
        }
        if (clientCapabilities.elicitation() != null) {
            if (async.elicitationHandler() == null) {
                g5.f.s("Elicitation handler must not be null when client capabilities include elicitation");
                throw null;
            }
            this.elicitationHandler = async.elicitationHandler();
            map.put(McpSchema.METHOD_ELICITATION_CREATE, elicitationCreateHandler());
        }
        HashMap map2 = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new d(7));
        if (!Utils.isEmpty(async.toolsChangeConsumers())) {
            arrayList.addAll(async.toolsChangeConsumers());
        }
        map2.put(McpSchema.METHOD_NOTIFICATION_TOOLS_LIST_CHANGED, asyncToolsChangeNotificationHandler(arrayList));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new d(8));
        if (!Utils.isEmpty(async.resourcesChangeConsumers())) {
            arrayList2.addAll(async.resourcesChangeConsumers());
        }
        map2.put(McpSchema.METHOD_NOTIFICATION_RESOURCES_LIST_CHANGED, asyncResourcesChangeNotificationHandler(arrayList2));
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(new d(9));
        if (!Utils.isEmpty(async.resourcesUpdateConsumers())) {
            arrayList3.addAll(async.resourcesUpdateConsumers());
        }
        map2.put(McpSchema.METHOD_NOTIFICATION_RESOURCES_UPDATED, asyncResourcesUpdatedNotificationHandler(arrayList3));
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(new d(10));
        if (!Utils.isEmpty(async.promptsChangeConsumers())) {
            arrayList4.addAll(async.promptsChangeConsumers());
        }
        map2.put(McpSchema.METHOD_NOTIFICATION_PROMPTS_LIST_CHANGED, asyncPromptsChangeNotificationHandler(arrayList4));
        ArrayList arrayList5 = new ArrayList();
        arrayList5.add(new d(11));
        if (!Utils.isEmpty(async.loggingConsumers())) {
            arrayList5.addAll(async.loggingConsumers());
        }
        map2.put(McpSchema.METHOD_NOTIFICATION_MESSAGE, asyncLoggingNotificationHandler(arrayList5));
        ArrayList arrayList6 = new ArrayList();
        arrayList6.add(new d(12));
        if (!Utils.isEmpty(async.progressConsumers())) {
            arrayList6.addAll(async.progressConsumers());
        }
        map2.put(McpSchema.METHOD_NOTIFICATION_PROGRESS, asyncProgressNotificationHandler(arrayList6));
        int i = 0;
        q qVar = new q(i);
        qVar.f6140b = this;
        VarHandle.storeStoreFence();
        List<String> listProtocolVersions = mcpClientTransport.protocolVersions();
        r rVar = new r(i);
        rVar.f6142b = duration;
        rVar.f6143c = mcpClientTransport;
        rVar.f6144d = map;
        rVar.f6145e = map2;
        VarHandle.storeStoreFence();
        LifecycleInitializer lifecycleInitializer = new LifecycleInitializer(clientCapabilities, implementationClientInfo, listProtocolVersions, duration2, rVar, qVar);
        this.initializer = lifecycleInitializer;
        b bVar = new b(1);
        bVar.f6111f = lifecycleInitializer;
        VarHandle.storeStoreFence();
        mcpClientTransport.setExceptionHandler(bVar);
    }

    private McpClientSession.NotificationHandler asyncLoggingNotificationHandler(List<Function<McpSchema.LoggingMessageNotification, Mono<Void>>> list) {
        l lVar = new l(3);
        lVar.f6130b = this;
        lVar.f6131c = list;
        VarHandle.storeStoreFence();
        return lVar;
    }

    private McpClientSession.NotificationHandler asyncProgressNotificationHandler(List<Function<McpSchema.ProgressNotification, Mono<Void>>> list) {
        l lVar = new l(5);
        lVar.f6130b = this;
        lVar.f6131c = list;
        VarHandle.storeStoreFence();
        return lVar;
    }

    private McpClientSession.NotificationHandler asyncPromptsChangeNotificationHandler(List<Function<List<McpSchema.Prompt>, Mono<Void>>> list) {
        l lVar = new l(1);
        lVar.f6130b = this;
        lVar.f6131c = list;
        VarHandle.storeStoreFence();
        return lVar;
    }

    private McpClientSession.NotificationHandler asyncResourcesChangeNotificationHandler(List<Function<List<McpSchema.Resource>, Mono<Void>>> list) {
        l lVar = new l(0);
        lVar.f6130b = this;
        lVar.f6131c = list;
        VarHandle.storeStoreFence();
        return lVar;
    }

    private McpClientSession.NotificationHandler asyncResourcesUpdatedNotificationHandler(List<Function<List<McpSchema.ResourceContents>, Mono<Void>>> list) {
        l lVar = new l(2);
        lVar.f6130b = this;
        lVar.f6131c = list;
        VarHandle.storeStoreFence();
        return lVar;
    }

    private McpClientSession.NotificationHandler asyncToolsChangeNotificationHandler(List<Function<List<McpSchema.Tool>, Mono<Void>>> list) {
        l lVar = new l(4);
        lVar.f6130b = this;
        lVar.f6131c = list;
        VarHandle.storeStoreFence();
        return lVar;
    }

    private McpClientSession.RequestHandler<McpSchema.ElicitResult> elicitationCreateHandler() {
        t tVar = new t(0);
        tVar.f6147b = this;
        VarHandle.storeStoreFence();
        return tVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ qd.c lambda$asyncLoggingNotificationHandler$68(McpSchema.LoggingMessageNotification loggingMessageNotification, Function function) {
        return (qd.c) function.apply(loggingMessageNotification);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$asyncLoggingNotificationHandler$69(List list, Object obj) {
        McpSchema.LoggingMessageNotification loggingMessageNotification = (McpSchema.LoggingMessageNotification) this.transport.unmarshalFrom(obj, LOGGING_MESSAGE_NOTIFICATION_TYPE_REF);
        Flux fluxFromIterable = Flux.fromIterable(list);
        c cVar = new c(9);
        cVar.f6113b = loggingMessageNotification;
        VarHandle.storeStoreFence();
        return fluxFromIterable.flatMap(cVar).then();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ qd.c lambda$asyncProgressNotificationHandler$71(McpSchema.ProgressNotification progressNotification, Function function) {
        return (qd.c) function.apply(progressNotification);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$asyncProgressNotificationHandler$72(List list, Object obj) {
        McpSchema.ProgressNotification progressNotification = (McpSchema.ProgressNotification) this.transport.unmarshalFrom(obj, PROGRESS_NOTIFICATION_TYPE_REF);
        Flux fluxFromIterable = Flux.fromIterable(list);
        c cVar = new c(11);
        cVar.f6113b = progressNotification;
        VarHandle.storeStoreFence();
        return fluxFromIterable.flatMap(cVar).then();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ qd.c lambda$asyncPromptsChangeNotificationHandler$64(McpSchema.ListPromptsResult listPromptsResult, Function function) {
        return (qd.c) function.apply(listPromptsResult.prompts());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ qd.c lambda$asyncPromptsChangeNotificationHandler$65(Throwable th) {
        logger.error("Error handling prompts list change notification", th);
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$asyncPromptsChangeNotificationHandler$66(List list, McpSchema.ListPromptsResult listPromptsResult) {
        Flux fluxFromIterable = Flux.fromIterable(list);
        c cVar = new c(12);
        cVar.f6113b = listPromptsResult;
        VarHandle.storeStoreFence();
        return fluxFromIterable.flatMap(cVar).onErrorResume(new d(14)).then();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$asyncPromptsChangeNotificationHandler$67(List list, Object obj) {
        Mono<McpSchema.ListPromptsResult> monoListPrompts = listPrompts();
        g gVar = new g(3);
        gVar.f6122b = list;
        VarHandle.storeStoreFence();
        return monoListPrompts.flatMap(gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ qd.c lambda$asyncResourcesChangeNotificationHandler$51(McpSchema.ListResourcesResult listResourcesResult, Function function) {
        return (qd.c) function.apply(listResourcesResult.resources());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ qd.c lambda$asyncResourcesChangeNotificationHandler$52(Throwable th) {
        logger.error("Error handling resources list change notification", th);
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$asyncResourcesChangeNotificationHandler$53(List list, McpSchema.ListResourcesResult listResourcesResult) {
        Flux fluxFromIterable = Flux.fromIterable(list);
        c cVar = new c(13);
        cVar.f6113b = listResourcesResult;
        VarHandle.storeStoreFence();
        return fluxFromIterable.flatMap(cVar).onErrorResume(new d(16)).then();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$asyncResourcesChangeNotificationHandler$54(List list, Object obj) {
        Mono<McpSchema.ListResourcesResult> monoListResources = listResources();
        g gVar = new g(0);
        gVar.f6122b = list;
        VarHandle.storeStoreFence();
        return monoListResources.flatMap(gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ qd.c lambda$asyncResourcesUpdatedNotificationHandler$55(McpSchema.ReadResourceResult readResourceResult, Function function) {
        return (qd.c) function.apply(readResourceResult.contents());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ qd.c lambda$asyncResourcesUpdatedNotificationHandler$56(Throwable th) {
        logger.error("Error handling resource update notification", th);
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$asyncResourcesUpdatedNotificationHandler$57(List list, McpSchema.ReadResourceResult readResourceResult) {
        Flux fluxFromIterable = Flux.fromIterable(list);
        c cVar = new c(10);
        cVar.f6113b = readResourceResult;
        VarHandle.storeStoreFence();
        return fluxFromIterable.flatMap(cVar).onErrorResume(new d(6)).then();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$asyncResourcesUpdatedNotificationHandler$58(List list, Object obj) {
        Mono<McpSchema.ReadResourceResult> resource = readResource(new McpSchema.ReadResourceRequest(((McpSchema.ResourcesUpdatedNotification) this.transport.unmarshalFrom(obj, new TypeRef<McpSchema.ResourcesUpdatedNotification>() { // from class: io.modelcontextprotocol.client.McpAsyncClient.14
        })).uri()));
        g gVar = new g(2);
        gVar.f6122b = list;
        VarHandle.storeStoreFence();
        return resource.flatMap(gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ qd.c lambda$asyncToolsChangeNotificationHandler$36(McpSchema.ListToolsResult listToolsResult, Function function) {
        return (qd.c) function.apply(listToolsResult.tools());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ qd.c lambda$asyncToolsChangeNotificationHandler$37(Throwable th) {
        logger.error("Error handling tools list change notification", th);
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$asyncToolsChangeNotificationHandler$38(List list, McpSchema.ListToolsResult listToolsResult) {
        Flux fluxFromIterable = Flux.fromIterable(list);
        c cVar = new c(8);
        cVar.f6113b = listToolsResult;
        VarHandle.storeStoreFence();
        return fluxFromIterable.flatMap(cVar).onErrorResume(new d(4)).then();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$asyncToolsChangeNotificationHandler$39(List list, Object obj) {
        Mono<McpSchema.ListToolsResult> monoListTools = listTools();
        g gVar = new g(1);
        gVar.f6122b = list;
        VarHandle.storeStoreFence();
        return monoListTools.flatMap(gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$callTool$27(McpSchema.CallToolRequest callToolRequest, McpSchema.CallToolResult callToolResult) {
        return Mono.just(validateToolResult(callToolRequest.name(), callToolResult));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$callTool$28(McpSchema.CallToolRequest callToolRequest, LifecycleInitializer.Initialization initialization) {
        if (initialization.initializeResult().capabilities().tools() == null) {
            return androidx.activity.b.q("Server does not provide tools capability");
        }
        Mono monoSendRequest = initialization.mcpSession().sendRequest(McpSchema.METHOD_TOOLS_CALL, callToolRequest, CALL_TOOL_RESULT_TYPE_REF);
        n nVar = new n(1);
        nVar.f6135b = this;
        nVar.f6136c = callToolRequest;
        VarHandle.storeStoreFence();
        return monoSendRequest.flatMap(nVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$closeGracefully$20() {
        return this.initializer.closeGracefully().then(this.transport.closeGracefully());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$completeCompletion$73(McpSchema.CompleteRequest completeRequest, LifecycleInitializer.Initialization initialization) {
        return initialization.mcpSession().sendRequest(McpSchema.METHOD_COMPLETION_COMPLETE, completeRequest, COMPLETION_COMPLETE_RESULT_TYPE_REF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$elicitationCreateHandler$26(Object obj) {
        return this.elicitationHandler.apply((McpSchema.ElicitRequest) this.transport.unmarshalFrom(obj, new TypeRef<McpSchema.ElicitRequest>() { // from class: io.modelcontextprotocol.client.McpAsyncClient.8
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$getPrompt$63(McpSchema.GetPromptRequest getPromptRequest, LifecycleInitializer.Initialization initialization) {
        return initialization.mcpSession().sendRequest(McpSchema.METHOD_PROMPT_GET, getPromptRequest, GET_PROMPT_RESULT_TYPE_REF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$initialize$21(LifecycleInitializer.Initialization initialization) {
        return Mono.just(initialization.initializeResult());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ qd.c lambda$listPrompts$59(McpSchema.ListPromptsResult listPromptsResult) {
        return listPromptsResult.nextCursor() != null ? listPrompts(listPromptsResult.nextCursor()) : Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ McpSchema.ListPromptsResult lambda$listPrompts$60(McpSchema.ListPromptsResult listPromptsResult, McpSchema.ListPromptsResult listPromptsResult2) {
        listPromptsResult.prompts().addAll(listPromptsResult2.prompts());
        return listPromptsResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ McpSchema.ListPromptsResult lambda$listPrompts$61(McpSchema.ListPromptsResult listPromptsResult) {
        return new McpSchema.ListPromptsResult(Collections.unmodifiableList(listPromptsResult.prompts()), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$listPrompts$62(String str, LifecycleInitializer.Initialization initialization) {
        return initialization.mcpSession().sendRequest(McpSchema.METHOD_PROMPT_LIST, new McpSchema.PaginatedRequest(str), LIST_PROMPTS_RESULT_TYPE_REF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ qd.c lambda$listResourceTemplates$45(McpSchema.ListResourceTemplatesResult listResourceTemplatesResult) {
        return listResourceTemplatesResult.nextCursor() != null ? listResourceTemplates(listResourceTemplatesResult.nextCursor()) : Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ McpSchema.ListResourceTemplatesResult lambda$listResourceTemplates$46(McpSchema.ListResourceTemplatesResult listResourceTemplatesResult, McpSchema.ListResourceTemplatesResult listResourceTemplatesResult2) {
        listResourceTemplatesResult.resourceTemplates().addAll(listResourceTemplatesResult2.resourceTemplates());
        return listResourceTemplatesResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ McpSchema.ListResourceTemplatesResult lambda$listResourceTemplates$47(McpSchema.ListResourceTemplatesResult listResourceTemplatesResult) {
        return new McpSchema.ListResourceTemplatesResult(Collections.unmodifiableList(listResourceTemplatesResult.resourceTemplates()), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$listResourceTemplates$48(String str, LifecycleInitializer.Initialization initialization) {
        return initialization.initializeResult().capabilities().resources() == null ? androidx.activity.b.q("Server does not provide the resources capability") : initialization.mcpSession().sendRequest(McpSchema.METHOD_RESOURCES_TEMPLATES_LIST, new McpSchema.PaginatedRequest(str), LIST_RESOURCE_TEMPLATES_RESULT_TYPE_REF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ qd.c lambda$listResources$40(McpSchema.ListResourcesResult listResourcesResult) {
        return listResourcesResult.nextCursor() != null ? listResources(listResourcesResult.nextCursor()) : Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ McpSchema.ListResourcesResult lambda$listResources$41(McpSchema.ListResourcesResult listResourcesResult, McpSchema.ListResourcesResult listResourcesResult2) {
        listResourcesResult.resources().addAll(listResourcesResult2.resources());
        return listResourcesResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ McpSchema.ListResourcesResult lambda$listResources$42(McpSchema.ListResourcesResult listResourcesResult) {
        return new McpSchema.ListResourcesResult(Collections.unmodifiableList(listResourcesResult.resources()), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$listResources$43(String str, LifecycleInitializer.Initialization initialization) {
        return initialization.initializeResult().capabilities().resources() == null ? androidx.activity.b.q("Server does not provide the resources capability") : initialization.mcpSession().sendRequest(McpSchema.METHOD_RESOURCES_LIST, new McpSchema.PaginatedRequest(str), LIST_RESOURCES_RESULT_TYPE_REF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ qd.c lambda$listTools$29(McpSchema.ListToolsResult listToolsResult) {
        String strNextCursor = listToolsResult.nextCursor();
        return (strNextCursor == null || strNextCursor.isEmpty()) ? Mono.empty() : listTools(strNextCursor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ McpSchema.ListToolsResult lambda$listTools$30(McpSchema.ListToolsResult listToolsResult, McpSchema.ListToolsResult listToolsResult2) {
        listToolsResult.tools().addAll(listToolsResult2.tools());
        return listToolsResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ McpSchema.ListToolsResult lambda$listTools$31(McpSchema.ListToolsResult listToolsResult) {
        return new McpSchema.ListToolsResult(Collections.unmodifiableList(listToolsResult.tools()), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$listToolsInternal$33(McpSchema.Tool tool) {
        return tool.outputSchema() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$listToolsInternal$34(McpSchema.Tool tool) {
        this.toolsOutputSchemaCache.put(tool.name(), tool.outputSchema());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$listToolsInternal$35(McpSchema.ListToolsResult listToolsResult) {
        if (!this.enableCallToolSchemaCaching || listToolsResult.tools() == null) {
            return;
        }
        int i = 0;
        Stream<McpSchema.Tool> streamFilter = listToolsResult.tools().stream().filter(new j(i));
        k kVar = new k(i);
        kVar.f6128f = this;
        VarHandle.storeStoreFence();
        streamFilter.forEach(kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$new$0(Object obj) {
        logger.h(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME), "Received ping: {}");
        return Mono.just(Collections.EMPTY_MAP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$1(List list) {
        logger.h(list, "Tools changed: {}");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$new$10(McpSchema.LoggingMessageNotification loggingMessageNotification) {
        o oVar = new o(1);
        oVar.f6138f = loggingMessageNotification;
        VarHandle.storeStoreFence();
        return Mono.fromRunnable(oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$11(McpSchema.ProgressNotification progressNotification) {
        logger.h(progressNotification, "Progress: {}");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$new$12(McpSchema.ProgressNotification progressNotification) {
        o oVar = new o(0);
        oVar.f6138f = progressNotification;
        VarHandle.storeStoreFence();
        return Mono.fromRunnable(oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$13(McpSchema.Tool tool) {
        logger.a("Tool {} schema: {}", tool.name(), tool.outputSchema());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$new$14(McpSchema.Tool tool) {
        return tool.outputSchema() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$15(McpSchema.Tool tool) {
        this.toolsOutputSchemaCache.put(tool.name(), tool.outputSchema());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$16(McpSchema.ListToolsResult listToolsResult) {
        listToolsResult.tools().forEach(new s());
        if (!this.enableCallToolSchemaCaching || listToolsResult.tools() == null) {
            return;
        }
        int i = 1;
        Stream<McpSchema.Tool> streamFilter = listToolsResult.tools().stream().filter(new j(i));
        k kVar = new k(i);
        kVar.f6128f = this;
        VarHandle.storeStoreFence();
        streamFilter.forEach(kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$new$17(LifecycleInitializer.Initialization initialization) {
        if (initialization.initializeResult().capabilities().tools() == null || !this.enableCallToolSchemaCaching) {
            return Mono.empty();
        }
        Mono<McpSchema.ListToolsResult> monoLambda$listTools$32 = lambda$listTools$32(initialization, McpSchema.FIRST_PAGE);
        k kVar = new k(3);
        kVar.f6128f = this;
        VarHandle.storeStoreFence();
        return monoLambda$listTools$32.doOnNext(kVar).then();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ qd.c lambda$new$18(ContextView contextView, Mono mono) {
        return mono.contextWrite(contextView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ McpClientSession lambda$new$19(Duration duration, McpClientTransport mcpClientTransport, Map map, Map map2, ContextView contextView) {
        c cVar = new c(14);
        cVar.f6113b = contextView;
        VarHandle.storeStoreFence();
        return new McpClientSession(duration, mcpClientTransport, map, map2, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$new$2(List list) {
        h hVar = new h(1);
        hVar.f6124f = list;
        VarHandle.storeStoreFence();
        return Mono.fromRunnable(hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$3(List list) {
        logger.h(list, "Resources changed: {}");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$new$4(List list) {
        h hVar = new h(3);
        hVar.f6124f = list;
        VarHandle.storeStoreFence();
        return Mono.fromRunnable(hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$5(List list) {
        logger.h(list, "Resources updated: {}");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$new$6(List list) {
        h hVar = new h(0);
        hVar.f6124f = list;
        VarHandle.storeStoreFence();
        return Mono.fromRunnable(hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$7(List list) {
        logger.h(list, "Prompts changed: {}");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$new$8(List list) {
        h hVar = new h(2);
        hVar.f6124f = list;
        VarHandle.storeStoreFence();
        return Mono.fromRunnable(hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$9(McpSchema.LoggingMessageNotification loggingMessageNotification) {
        logger.h(loggingMessageNotification, "Logging: {}");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$ping$22(LifecycleInitializer.Initialization initialization) {
        return initialization.mcpSession().sendRequest(McpSchema.METHOD_PING, null, OBJECT_TYPE_REF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$readResource$44(McpSchema.ReadResourceRequest readResourceRequest, LifecycleInitializer.Initialization initialization) {
        return initialization.initializeResult().capabilities().resources() == null ? androidx.activity.b.q("Server does not provide the resources capability") : initialization.mcpSession().sendRequest(McpSchema.METHOD_RESOURCES_READ, readResourceRequest, READ_RESOURCE_RESULT_TYPE_REF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$rootsListChangedNotification$23(LifecycleInitializer.Initialization initialization) {
        return initialization.mcpSession().sendNotification(McpSchema.METHOD_NOTIFICATION_ROOTS_LIST_CHANGED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$rootsListRequestHandler$24(Object obj) {
        return Mono.just(new McpSchema.ListRootsResult(this.roots.values().stream().toList()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$samplingCreateMessageHandler$25(Object obj) {
        return this.samplingHandler.apply((McpSchema.CreateMessageRequest) this.transport.unmarshalFrom(obj, CREATE_MESSAGE_REQUEST_TYPE_REF));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$setLoggingLevel$70(McpSchema.LoggingLevel loggingLevel, LifecycleInitializer.Initialization initialization) {
        if (initialization.initializeResult().capabilities().logging() == null) {
            return androidx.activity.b.q("Server's Logging capabilities are not enabled!");
        }
        return initialization.mcpSession().sendRequest(McpSchema.METHOD_LOGGING_SET_LEVEL, new McpSchema.SetLevelRequest(loggingLevel), OBJECT_TYPE_REF).then();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$subscribeResource$49(McpSchema.SubscribeRequest subscribeRequest, LifecycleInitializer.Initialization initialization) {
        return initialization.mcpSession().sendRequest(McpSchema.METHOD_RESOURCES_SUBSCRIBE, subscribeRequest, VOID_TYPE_REFERENCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$unsubscribeResource$50(McpSchema.UnsubscribeRequest unsubscribeRequest, LifecycleInitializer.Initialization initialization) {
        return initialization.mcpSession().sendRequest(McpSchema.METHOD_RESOURCES_UNSUBSCRIBE, unsubscribeRequest, VOID_TYPE_REFERENCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listToolsInternal, reason: merged with bridge method [inline-methods] */
    public Mono<McpSchema.ListToolsResult> lambda$listTools$32(LifecycleInitializer.Initialization initialization, String str) {
        if (initialization.initializeResult().capabilities().tools() == null) {
            return androidx.activity.b.q("Server does not provide tools capability");
        }
        Mono monoSendRequest = initialization.mcpSession().sendRequest(McpSchema.METHOD_TOOLS_LIST, new McpSchema.PaginatedRequest(str), LIST_TOOLS_RESULT_TYPE_REF);
        k kVar = new k(2);
        kVar.f6128f = this;
        VarHandle.storeStoreFence();
        return monoSendRequest.doOnNext(kVar);
    }

    private McpClientSession.RequestHandler<McpSchema.ListRootsResult> rootsListRequestHandler() {
        t tVar = new t(1);
        tVar.f6147b = this;
        VarHandle.storeStoreFence();
        return tVar;
    }

    private McpClientSession.RequestHandler<McpSchema.CreateMessageResult> samplingCreateMessageHandler() {
        t tVar = new t(2);
        tVar.f6147b = this;
        VarHandle.storeStoreFence();
        return tVar;
    }

    private McpSchema.CallToolResult validateToolResult(String str, McpSchema.CallToolResult callToolResult) {
        if (!this.enableCallToolSchemaCaching || callToolResult == null || callToolResult.isError() == Boolean.TRUE) {
            return callToolResult;
        }
        Map<String, Object> map = this.toolsOutputSchemaCache.get(str);
        if (map == null) {
            logger.b(callToolResult.structuredContent(), "Calling a tool with no outputSchema is not expected to return result with structured content, but got: {}");
            return callToolResult;
        }
        JsonSchemaValidator.ValidationResponse validationResponseValidate = this.jsonSchemaValidator.validate(map, callToolResult.structuredContent());
        if (validationResponseValidate.valid()) {
            return callToolResult;
        }
        logger.b(validationResponseValidate.errorMessage(), "Tool call result validation failed: {}");
        g5.f.s(w2.c.b("Tool call result validation failed: ", validationResponseValidate.errorMessage()));
        return null;
    }

    public Mono<Void> addRoot(McpSchema.Root root) {
        if (root == null) {
            return Mono.error(new IllegalArgumentException("Root must not be null"));
        }
        if (this.clientCapabilities.roots() == null) {
            return androidx.activity.b.q("Client must be configured with roots capabilities");
        }
        if (this.roots.containsKey(root.uri())) {
            return Mono.error(new IllegalStateException(k0.a.C("Root with uri '", root.uri(), "' already exists")));
        }
        this.roots.put(root.uri(), root);
        rd.b bVar = logger;
        bVar.h(root, "Added root: {}");
        if (this.clientCapabilities.roots().listChanged().booleanValue()) {
            if (isInitialized()) {
                return rootsListChangedNotification();
            }
            bVar.warn("Client is not initialized, ignore sending a roots list changed notification");
        }
        return Mono.empty();
    }

    public Mono<McpSchema.CallToolResult> callTool(McpSchema.CallToolRequest callToolRequest) {
        LifecycleInitializer lifecycleInitializer = this.initializer;
        n nVar = new n(0);
        nVar.f6135b = this;
        nVar.f6136c = callToolRequest;
        VarHandle.storeStoreFence();
        return lifecycleInitializer.withInitialization("calling tool", nVar);
    }

    public void close() {
        this.initializer.close();
        this.transport.lambda$closeGracefully$1();
    }

    public Mono<Void> closeGracefully() {
        e eVar = new e(1);
        eVar.f6116f = this;
        VarHandle.storeStoreFence();
        return Mono.defer(eVar);
    }

    public Mono<McpSchema.CompleteResult> completeCompletion(McpSchema.CompleteRequest completeRequest) {
        LifecycleInitializer lifecycleInitializer = this.initializer;
        c cVar = new c(2);
        cVar.f6113b = completeRequest;
        VarHandle.storeStoreFence();
        return lifecycleInitializer.withInitialization("complete completions", cVar);
    }

    public McpSchema.ClientCapabilities getClientCapabilities() {
        return this.clientCapabilities;
    }

    public McpSchema.Implementation getClientInfo() {
        return this.clientInfo;
    }

    public McpSchema.InitializeResult getCurrentInitializationResult() {
        return this.initializer.currentInitializationResult();
    }

    public Mono<McpSchema.GetPromptResult> getPrompt(McpSchema.GetPromptRequest getPromptRequest) {
        LifecycleInitializer lifecycleInitializer = this.initializer;
        c cVar = new c(4);
        cVar.f6113b = getPromptRequest;
        VarHandle.storeStoreFence();
        return lifecycleInitializer.withInitialization("getting prompts", cVar);
    }

    public McpSchema.ServerCapabilities getServerCapabilities() {
        McpSchema.InitializeResult initializeResultCurrentInitializationResult = this.initializer.currentInitializationResult();
        if (initializeResultCurrentInitializationResult != null) {
            return initializeResultCurrentInitializationResult.capabilities();
        }
        return null;
    }

    public McpSchema.Implementation getServerInfo() {
        McpSchema.InitializeResult initializeResultCurrentInitializationResult = this.initializer.currentInitializationResult();
        if (initializeResultCurrentInitializationResult != null) {
            return initializeResultCurrentInitializationResult.serverInfo();
        }
        return null;
    }

    public String getServerInstructions() {
        McpSchema.InitializeResult initializeResultCurrentInitializationResult = this.initializer.currentInitializationResult();
        if (initializeResultCurrentInitializationResult != null) {
            return initializeResultCurrentInitializationResult.instructions();
        }
        return null;
    }

    public Mono<McpSchema.InitializeResult> initialize() {
        return this.initializer.withInitialization("by explicit API call", new d(3));
    }

    public boolean isInitialized() {
        return this.initializer.isInitialized();
    }

    public Mono<McpSchema.ListPromptsResult> listPrompts() {
        Mono<McpSchema.ListPromptsResult> monoListPrompts = listPrompts(McpSchema.FIRST_PAGE);
        q qVar = new q(1);
        qVar.f6140b = this;
        VarHandle.storeStoreFence();
        return monoListPrompts.expand(qVar).reduce(new McpSchema.ListPromptsResult(new ArrayList(), null), new i(0)).map(new d(5));
    }

    public Mono<McpSchema.ListResourceTemplatesResult> listResourceTemplates() {
        Mono<McpSchema.ListResourceTemplatesResult> monoListResourceTemplates = listResourceTemplates(McpSchema.FIRST_PAGE);
        q qVar = new q(3);
        qVar.f6140b = this;
        VarHandle.storeStoreFence();
        return monoListResourceTemplates.expand(qVar).reduce(new McpSchema.ListResourceTemplatesResult(new ArrayList(), null), new i(2)).map(new d(15));
    }

    public Mono<McpSchema.ListResourcesResult> listResources() {
        Mono<McpSchema.ListResourcesResult> monoListResources = listResources(McpSchema.FIRST_PAGE);
        q qVar = new q(4);
        qVar.f6140b = this;
        VarHandle.storeStoreFence();
        return monoListResources.expand(qVar).reduce(new McpSchema.ListResourcesResult(new ArrayList(), null), new i(3)).map(new d(17));
    }

    public Mono<McpSchema.ListToolsResult> listTools() {
        Mono<McpSchema.ListToolsResult> monoListTools = listTools(McpSchema.FIRST_PAGE);
        q qVar = new q(2);
        qVar.f6140b = this;
        VarHandle.storeStoreFence();
        return monoListTools.expand(qVar).reduce(new McpSchema.ListToolsResult(new ArrayList(), null), new i(1)).map(new d(13));
    }

    public Mono<Object> ping() {
        return this.initializer.withInitialization("pinging the server", new d(1));
    }

    public Mono<McpSchema.ReadResourceResult> readResource(McpSchema.ReadResourceRequest readResourceRequest) {
        LifecycleInitializer lifecycleInitializer = this.initializer;
        c cVar = new c(7);
        cVar.f6113b = readResourceRequest;
        VarHandle.storeStoreFence();
        return lifecycleInitializer.withInitialization("reading resources", cVar);
    }

    public Mono<Void> removeRoot(String str) {
        if (str == null) {
            return Mono.error(new IllegalArgumentException("Root uri must not be null"));
        }
        if (this.clientCapabilities.roots() == null) {
            return androidx.activity.b.q("Client must be configured with roots capabilities");
        }
        if (this.roots.remove(str) == null) {
            return Mono.error(new IllegalStateException(k0.a.C("Root with uri '", str, "' not found")));
        }
        rd.b bVar = logger;
        bVar.h(str, "Removed Root: {}");
        if (this.clientCapabilities.roots().listChanged().booleanValue()) {
            if (isInitialized()) {
                return rootsListChangedNotification();
            }
            bVar.warn("Client is not initialized, ignore sending a roots list changed notification");
        }
        return Mono.empty();
    }

    public Mono<Void> rootsListChangedNotification() {
        return this.initializer.withInitialization("sending roots list changed notification", new d(2));
    }

    public Mono<Void> setLoggingLevel(McpSchema.LoggingLevel loggingLevel) {
        if (loggingLevel == null) {
            return Mono.error(new IllegalArgumentException("Logging level must not be null"));
        }
        LifecycleInitializer lifecycleInitializer = this.initializer;
        c cVar = new c(6);
        cVar.f6113b = loggingLevel;
        VarHandle.storeStoreFence();
        return lifecycleInitializer.withInitialization("setting logging level", cVar);
    }

    public void setProtocolVersions(List<String> list) {
        this.initializer.setProtocolVersions(list);
    }

    public Mono<Void> subscribeResource(McpSchema.SubscribeRequest subscribeRequest) {
        LifecycleInitializer lifecycleInitializer = this.initializer;
        c cVar = new c(3);
        cVar.f6113b = subscribeRequest;
        VarHandle.storeStoreFence();
        return lifecycleInitializer.withInitialization("subscribing to resources", cVar);
    }

    public Mono<Void> unsubscribeResource(McpSchema.UnsubscribeRequest unsubscribeRequest) {
        LifecycleInitializer lifecycleInitializer = this.initializer;
        c cVar = new c(5);
        cVar.f6113b = unsubscribeRequest;
        VarHandle.storeStoreFence();
        return lifecycleInitializer.withInitialization("unsubscribing from resources", cVar);
    }

    public Mono<McpSchema.ReadResourceResult> readResource(McpSchema.Resource resource) {
        return readResource(new McpSchema.ReadResourceRequest(resource.uri()));
    }

    public Mono<McpSchema.ListPromptsResult> listPrompts(String str) {
        LifecycleInitializer lifecycleInitializer = this.initializer;
        m mVar = new m(0);
        mVar.f6133b = str;
        VarHandle.storeStoreFence();
        return lifecycleInitializer.withInitialization("listing prompts", mVar);
    }

    public Mono<McpSchema.ListResourceTemplatesResult> listResourceTemplates(String str) {
        LifecycleInitializer lifecycleInitializer = this.initializer;
        m mVar = new m(1);
        mVar.f6133b = str;
        VarHandle.storeStoreFence();
        return lifecycleInitializer.withInitialization("listing resource templates", mVar);
    }

    public Mono<McpSchema.ListResourcesResult> listResources(String str) {
        LifecycleInitializer lifecycleInitializer = this.initializer;
        m mVar = new m(2);
        mVar.f6133b = str;
        VarHandle.storeStoreFence();
        return lifecycleInitializer.withInitialization("listing resources", mVar);
    }

    public Mono<McpSchema.ListToolsResult> listTools(String str) {
        LifecycleInitializer lifecycleInitializer = this.initializer;
        a aVar = new a(2);
        aVar.f6108b = this;
        aVar.f6109c = str;
        VarHandle.storeStoreFence();
        return lifecycleInitializer.withInitialization("listing tools", aVar);
    }
}
