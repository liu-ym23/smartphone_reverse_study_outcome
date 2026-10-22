package io.modelcontextprotocol.client;

import aa.AbstractC0317d;
import aa.InterfaceC0315b;
import io.modelcontextprotocol.client.LifecycleInitializer;
import io.modelcontextprotocol.client.McpClientFeatures;
import io.modelcontextprotocol.json.TypeRef;
import io.modelcontextprotocol.json.schema.JsonSchemaValidator;
import io.modelcontextprotocol.spec.McpClientSession;
import io.modelcontextprotocol.spec.McpClientTransport;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.util.Assert;
import io.modelcontextprotocol.util.Utils;
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
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.context.ContextView;

/* loaded from: classes2.dex */
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
    private static final InterfaceC0315b logger = AbstractC0317d.b(McpAsyncClient.class);
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
                throw new IllegalArgumentException("Sampling handler must not be null when client capabilities include sampling");
            }
            this.samplingHandler = async.samplingHandler();
            map.put(McpSchema.METHOD_SAMPLING_CREATE_MESSAGE, samplingCreateMessageHandler());
        }
        if (clientCapabilities.elicitation() != null) {
            if (async.elicitationHandler() == null) {
                throw new IllegalArgumentException("Elicitation handler must not be null when client capabilities include elicitation");
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
        LifecycleInitializer lifecycleInitializer = new LifecycleInitializer(clientCapabilities, implementationClientInfo, mcpClientTransport.protocolVersions(), duration2, new r(duration, mcpClientTransport, map, map2, 0), new q(this, 0));
        this.initializer = lifecycleInitializer;
        mcpClientTransport.setExceptionHandler(new b(lifecycleInitializer, 1));
    }

    private McpClientSession.NotificationHandler asyncLoggingNotificationHandler(List<Function<McpSchema.LoggingMessageNotification, Mono<Void>>> list) {
        return new l(this, list, 3);
    }

    private McpClientSession.NotificationHandler asyncProgressNotificationHandler(List<Function<McpSchema.ProgressNotification, Mono<Void>>> list) {
        return new l(this, list, 5);
    }

    private McpClientSession.NotificationHandler asyncPromptsChangeNotificationHandler(List<Function<List<McpSchema.Prompt>, Mono<Void>>> list) {
        return new l(this, list, 1);
    }

    private McpClientSession.NotificationHandler asyncResourcesChangeNotificationHandler(List<Function<List<McpSchema.Resource>, Mono<Void>>> list) {
        return new l(this, list, 0);
    }

    private McpClientSession.NotificationHandler asyncResourcesUpdatedNotificationHandler(List<Function<List<McpSchema.ResourceContents>, Mono<Void>>> list) {
        return new l(this, list, 2);
    }

    private McpClientSession.NotificationHandler asyncToolsChangeNotificationHandler(List<Function<List<McpSchema.Tool>, Mono<Void>>> list) {
        return new l(this, list, 4);
    }

    private McpClientSession.RequestHandler<McpSchema.ElicitResult> elicitationCreateHandler() {
        return new t(this, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Z9.c lambda$asyncLoggingNotificationHandler$68(McpSchema.LoggingMessageNotification loggingMessageNotification, Function function) {
        return (Z9.c) function.apply(loggingMessageNotification);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$asyncLoggingNotificationHandler$69(List list, Object obj) {
        return Flux.fromIterable(list).flatMap(new c((McpSchema.LoggingMessageNotification) this.transport.unmarshalFrom(obj, LOGGING_MESSAGE_NOTIFICATION_TYPE_REF), 9)).then();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Z9.c lambda$asyncProgressNotificationHandler$71(McpSchema.ProgressNotification progressNotification, Function function) {
        return (Z9.c) function.apply(progressNotification);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$asyncProgressNotificationHandler$72(List list, Object obj) {
        return Flux.fromIterable(list).flatMap(new c((McpSchema.ProgressNotification) this.transport.unmarshalFrom(obj, PROGRESS_NOTIFICATION_TYPE_REF), 11)).then();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Z9.c lambda$asyncPromptsChangeNotificationHandler$64(McpSchema.ListPromptsResult listPromptsResult, Function function) {
        return (Z9.c) function.apply(listPromptsResult.prompts());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Z9.c lambda$asyncPromptsChangeNotificationHandler$65(Throwable th) {
        logger.error("Error handling prompts list change notification", th);
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$asyncPromptsChangeNotificationHandler$66(List list, McpSchema.ListPromptsResult listPromptsResult) {
        return Flux.fromIterable(list).flatMap(new c(listPromptsResult, 12)).onErrorResume(new d(14)).then();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$asyncPromptsChangeNotificationHandler$67(List list, Object obj) {
        return listPrompts().flatMap(new g(list, 3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Z9.c lambda$asyncResourcesChangeNotificationHandler$51(McpSchema.ListResourcesResult listResourcesResult, Function function) {
        return (Z9.c) function.apply(listResourcesResult.resources());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Z9.c lambda$asyncResourcesChangeNotificationHandler$52(Throwable th) {
        logger.error("Error handling resources list change notification", th);
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$asyncResourcesChangeNotificationHandler$53(List list, McpSchema.ListResourcesResult listResourcesResult) {
        return Flux.fromIterable(list).flatMap(new c(listResourcesResult, 13)).onErrorResume(new d(16)).then();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$asyncResourcesChangeNotificationHandler$54(List list, Object obj) {
        return listResources().flatMap(new g(list, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Z9.c lambda$asyncResourcesUpdatedNotificationHandler$55(McpSchema.ReadResourceResult readResourceResult, Function function) {
        return (Z9.c) function.apply(readResourceResult.contents());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Z9.c lambda$asyncResourcesUpdatedNotificationHandler$56(Throwable th) {
        logger.error("Error handling resource update notification", th);
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$asyncResourcesUpdatedNotificationHandler$57(List list, McpSchema.ReadResourceResult readResourceResult) {
        return Flux.fromIterable(list).flatMap(new c(readResourceResult, 10)).onErrorResume(new d(6)).then();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$asyncResourcesUpdatedNotificationHandler$58(List list, Object obj) {
        return readResource(new McpSchema.ReadResourceRequest(((McpSchema.ResourcesUpdatedNotification) this.transport.unmarshalFrom(obj, new TypeRef<McpSchema.ResourcesUpdatedNotification>() { // from class: io.modelcontextprotocol.client.McpAsyncClient.14
        })).uri())).flatMap(new g(list, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Z9.c lambda$asyncToolsChangeNotificationHandler$36(McpSchema.ListToolsResult listToolsResult, Function function) {
        return (Z9.c) function.apply(listToolsResult.tools());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Z9.c lambda$asyncToolsChangeNotificationHandler$37(Throwable th) {
        logger.error("Error handling tools list change notification", th);
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$asyncToolsChangeNotificationHandler$38(List list, McpSchema.ListToolsResult listToolsResult) {
        return Flux.fromIterable(list).flatMap(new c(listToolsResult, 8)).onErrorResume(new d(4)).then();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$asyncToolsChangeNotificationHandler$39(List list, Object obj) {
        return listTools().flatMap(new g(list, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$callTool$27(McpSchema.CallToolRequest callToolRequest, McpSchema.CallToolResult callToolResult) {
        return Mono.just(validateToolResult(callToolRequest.name(), callToolResult));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$callTool$28(McpSchema.CallToolRequest callToolRequest, LifecycleInitializer.Initialization initialization) {
        return initialization.initializeResult().capabilities().tools() == null ? com.stepos.statsrpk.service.c.i("Server does not provide tools capability") : initialization.mcpSession().sendRequest(McpSchema.METHOD_TOOLS_CALL, callToolRequest, CALL_TOOL_RESULT_TYPE_REF).flatMap(new n(this, callToolRequest, 1));
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
    public /* synthetic */ Z9.c lambda$listPrompts$59(McpSchema.ListPromptsResult listPromptsResult) {
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
    public /* synthetic */ Z9.c lambda$listResourceTemplates$45(McpSchema.ListResourceTemplatesResult listResourceTemplatesResult) {
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
        return initialization.initializeResult().capabilities().resources() == null ? com.stepos.statsrpk.service.c.i("Server does not provide the resources capability") : initialization.mcpSession().sendRequest(McpSchema.METHOD_RESOURCES_TEMPLATES_LIST, new McpSchema.PaginatedRequest(str), LIST_RESOURCE_TEMPLATES_RESULT_TYPE_REF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Z9.c lambda$listResources$40(McpSchema.ListResourcesResult listResourcesResult) {
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
        return initialization.initializeResult().capabilities().resources() == null ? com.stepos.statsrpk.service.c.i("Server does not provide the resources capability") : initialization.mcpSession().sendRequest(McpSchema.METHOD_RESOURCES_LIST, new McpSchema.PaginatedRequest(str), LIST_RESOURCES_RESULT_TYPE_REF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Z9.c lambda$listTools$29(McpSchema.ListToolsResult listToolsResult) {
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
        listToolsResult.tools().stream().filter(new j(i)).forEach(new k(this, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$new$0(Object obj) {
        logger.j(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME), "Received ping: {}");
        return Mono.just(Collections.EMPTY_MAP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$1(List list) {
        logger.j(list, "Tools changed: {}");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$new$10(McpSchema.LoggingMessageNotification loggingMessageNotification) {
        return Mono.fromRunnable(new o(loggingMessageNotification, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$11(McpSchema.ProgressNotification progressNotification) {
        logger.j(progressNotification, "Progress: {}");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$new$12(McpSchema.ProgressNotification progressNotification) {
        return Mono.fromRunnable(new o(progressNotification, 0));
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
        listToolsResult.tools().stream().filter(new j(i)).forEach(new k(this, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$new$17(LifecycleInitializer.Initialization initialization) {
        return (initialization.initializeResult().capabilities().tools() == null || !this.enableCallToolSchemaCaching) ? Mono.empty() : lambda$listTools$32(initialization, McpSchema.FIRST_PAGE).doOnNext(new k(this, 3)).then();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Z9.c lambda$new$18(ContextView contextView, Mono mono) {
        return mono.contextWrite(contextView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ McpClientSession lambda$new$19(Duration duration, McpClientTransport mcpClientTransport, Map map, Map map2, ContextView contextView) {
        return new McpClientSession(duration, mcpClientTransport, map, map2, new c(contextView, 14));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$new$2(List list) {
        return Mono.fromRunnable(new h(list, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$3(List list) {
        logger.j(list, "Resources changed: {}");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$new$4(List list) {
        return Mono.fromRunnable(new h(list, 3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$5(List list) {
        logger.j(list, "Resources updated: {}");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$new$6(List list) {
        return Mono.fromRunnable(new h(list, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$7(List list) {
        logger.j(list, "Prompts changed: {}");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$new$8(List list) {
        return Mono.fromRunnable(new h(list, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$9(McpSchema.LoggingMessageNotification loggingMessageNotification) {
        logger.j(loggingMessageNotification, "Logging: {}");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$ping$22(LifecycleInitializer.Initialization initialization) {
        return initialization.mcpSession().sendRequest(McpSchema.METHOD_PING, null, OBJECT_TYPE_REF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$readResource$44(McpSchema.ReadResourceRequest readResourceRequest, LifecycleInitializer.Initialization initialization) {
        return initialization.initializeResult().capabilities().resources() == null ? com.stepos.statsrpk.service.c.i("Server does not provide the resources capability") : initialization.mcpSession().sendRequest(McpSchema.METHOD_RESOURCES_READ, readResourceRequest, READ_RESOURCE_RESULT_TYPE_REF);
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
            return com.stepos.statsrpk.service.c.i("Server's Logging capabilities are not enabled!");
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
        return initialization.initializeResult().capabilities().tools() == null ? com.stepos.statsrpk.service.c.i("Server does not provide tools capability") : initialization.mcpSession().sendRequest(McpSchema.METHOD_TOOLS_LIST, new McpSchema.PaginatedRequest(str), LIST_TOOLS_RESULT_TYPE_REF).doOnNext(new k(this, 2));
    }

    private McpClientSession.RequestHandler<McpSchema.ListRootsResult> rootsListRequestHandler() {
        return new t(this, 1);
    }

    private McpClientSession.RequestHandler<McpSchema.CreateMessageResult> samplingCreateMessageHandler() {
        return new t(this, 2);
    }

    private McpSchema.CallToolResult validateToolResult(String str, McpSchema.CallToolResult callToolResult) {
        if (!this.enableCallToolSchemaCaching || callToolResult == null || callToolResult.isError() == Boolean.TRUE) {
            return callToolResult;
        }
        Map<String, Object> map = this.toolsOutputSchemaCache.get(str);
        if (map == null) {
            logger.h(callToolResult.structuredContent(), "Calling a tool with no outputSchema is not expected to return result with structured content, but got: {}");
            return callToolResult;
        }
        JsonSchemaValidator.ValidationResponse validationResponseValidate = this.jsonSchemaValidator.validate(map, callToolResult.structuredContent());
        if (validationResponseValidate.valid()) {
            return callToolResult;
        }
        logger.h(validationResponseValidate.errorMessage(), "Tool call result validation failed: {}");
        throw new IllegalArgumentException(B7.a.k("Tool call result validation failed: ", validationResponseValidate.errorMessage()));
    }

    public Mono<Void> addRoot(McpSchema.Root root) {
        if (root == null) {
            return Mono.error(new IllegalArgumentException("Root must not be null"));
        }
        if (this.clientCapabilities.roots() == null) {
            return com.stepos.statsrpk.service.c.i("Client must be configured with roots capabilities");
        }
        if (this.roots.containsKey(root.uri())) {
            return Mono.error(new IllegalStateException(B7.a.m("Root with uri '", root.uri(), "' already exists")));
        }
        this.roots.put(root.uri(), root);
        InterfaceC0315b interfaceC0315b = logger;
        interfaceC0315b.j(root, "Added root: {}");
        if (this.clientCapabilities.roots().listChanged().booleanValue()) {
            if (isInitialized()) {
                return rootsListChangedNotification();
            }
            interfaceC0315b.warn("Client is not initialized, ignore sending a roots list changed notification");
        }
        return Mono.empty();
    }

    public Mono<McpSchema.CallToolResult> callTool(McpSchema.CallToolRequest callToolRequest) {
        return this.initializer.withInitialization("calling tool", new n(this, callToolRequest, 0));
    }

    public void close() {
        this.initializer.close();
        this.transport.lambda$closeGracefully$1();
    }

    public Mono<Void> closeGracefully() {
        return Mono.defer(new e(this, 1));
    }

    public Mono<McpSchema.CompleteResult> completeCompletion(McpSchema.CompleteRequest completeRequest) {
        return this.initializer.withInitialization("complete completions", new c(completeRequest, 2));
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
        return this.initializer.withInitialization("getting prompts", new c(getPromptRequest, 4));
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
        return listPrompts(McpSchema.FIRST_PAGE).expand(new q(this, 1)).reduce(new McpSchema.ListPromptsResult(new ArrayList(), null), new i(0)).map(new d(5));
    }

    public Mono<McpSchema.ListResourceTemplatesResult> listResourceTemplates() {
        return listResourceTemplates(McpSchema.FIRST_PAGE).expand(new q(this, 3)).reduce(new McpSchema.ListResourceTemplatesResult(new ArrayList(), null), new i(2)).map(new d(15));
    }

    public Mono<McpSchema.ListResourcesResult> listResources() {
        return listResources(McpSchema.FIRST_PAGE).expand(new q(this, 4)).reduce(new McpSchema.ListResourcesResult(new ArrayList(), null), new i(3)).map(new d(17));
    }

    public Mono<McpSchema.ListToolsResult> listTools() {
        return listTools(McpSchema.FIRST_PAGE).expand(new q(this, 2)).reduce(new McpSchema.ListToolsResult(new ArrayList(), null), new i(1)).map(new d(13));
    }

    public Mono<Object> ping() {
        return this.initializer.withInitialization("pinging the server", new d(1));
    }

    public Mono<McpSchema.ReadResourceResult> readResource(McpSchema.Resource resource) {
        return readResource(new McpSchema.ReadResourceRequest(resource.uri()));
    }

    public Mono<Void> removeRoot(String str) {
        if (str == null) {
            return Mono.error(new IllegalArgumentException("Root uri must not be null"));
        }
        if (this.clientCapabilities.roots() == null) {
            return com.stepos.statsrpk.service.c.i("Client must be configured with roots capabilities");
        }
        if (this.roots.remove(str) == null) {
            return Mono.error(new IllegalStateException(B7.a.m("Root with uri '", str, "' not found")));
        }
        InterfaceC0315b interfaceC0315b = logger;
        interfaceC0315b.j(str, "Removed Root: {}");
        if (this.clientCapabilities.roots().listChanged().booleanValue()) {
            if (isInitialized()) {
                return rootsListChangedNotification();
            }
            interfaceC0315b.warn("Client is not initialized, ignore sending a roots list changed notification");
        }
        return Mono.empty();
    }

    public Mono<Void> rootsListChangedNotification() {
        return this.initializer.withInitialization("sending roots list changed notification", new d(2));
    }

    public Mono<Void> setLoggingLevel(McpSchema.LoggingLevel loggingLevel) {
        return loggingLevel == null ? Mono.error(new IllegalArgumentException("Logging level must not be null")) : this.initializer.withInitialization("setting logging level", new c(loggingLevel, 6));
    }

    public void setProtocolVersions(List<String> list) {
        this.initializer.setProtocolVersions(list);
    }

    public Mono<Void> subscribeResource(McpSchema.SubscribeRequest subscribeRequest) {
        return this.initializer.withInitialization("subscribing to resources", new c(subscribeRequest, 3));
    }

    public Mono<Void> unsubscribeResource(McpSchema.UnsubscribeRequest unsubscribeRequest) {
        return this.initializer.withInitialization("unsubscribing from resources", new c(unsubscribeRequest, 5));
    }

    public Mono<McpSchema.ReadResourceResult> readResource(McpSchema.ReadResourceRequest readResourceRequest) {
        return this.initializer.withInitialization("reading resources", new c(readResourceRequest, 7));
    }

    public Mono<McpSchema.ListToolsResult> listTools(String str) {
        return this.initializer.withInitialization("listing tools", new a(2, this, str));
    }

    public Mono<McpSchema.ListPromptsResult> listPrompts(String str) {
        return this.initializer.withInitialization("listing prompts", new m(str, 0));
    }

    public Mono<McpSchema.ListResourceTemplatesResult> listResourceTemplates(String str) {
        return this.initializer.withInitialization("listing resource templates", new m(str, 1));
    }

    public Mono<McpSchema.ListResourcesResult> listResources(String str) {
        return this.initializer.withInitialization("listing resources", new m(str, 2));
    }
}
