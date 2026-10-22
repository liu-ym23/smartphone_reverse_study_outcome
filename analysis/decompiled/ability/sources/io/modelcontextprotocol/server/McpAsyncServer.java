package io.modelcontextprotocol.server;

import aa.AbstractC0317d;
import aa.InterfaceC0315b;
import androidx.autofill.HintConstants;
import io.modelcontextprotocol.json.McpJsonMapper;
import io.modelcontextprotocol.json.TypeRef;
import io.modelcontextprotocol.json.schema.JsonSchemaValidator;
import io.modelcontextprotocol.server.McpServerFeatures;
import io.modelcontextprotocol.spec.DefaultMcpStreamableServerSessionFactory;
import io.modelcontextprotocol.spec.McpError;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpServerSession;
import io.modelcontextprotocol.spec.McpServerTransport;
import io.modelcontextprotocol.spec.McpServerTransportProvider;
import io.modelcontextprotocol.spec.McpServerTransportProviderBase;
import io.modelcontextprotocol.spec.McpStreamableServerTransportProvider;
import io.modelcontextprotocol.util.Assert;
import io.modelcontextprotocol.util.DefaultMcpUriTemplateManagerFactory;
import io.modelcontextprotocol.util.McpUriTemplateManagerFactory;
import io.modelcontextprotocol.util.Utils;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.BiFunction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/* loaded from: classes3.dex */
public class McpAsyncServer {
    private final ConcurrentHashMap<McpSchema.CompleteReference, McpServerFeatures.AsyncCompletionSpecification> completions;
    private final String instructions;
    private final McpJsonMapper jsonMapper;
    private final JsonSchemaValidator jsonSchemaValidator;
    private final McpServerTransportProviderBase mcpTransportProvider;
    private McpSchema.LoggingLevel minLoggingLevel;
    private final ConcurrentHashMap<String, McpServerFeatures.AsyncPromptSpecification> prompts;
    private List<String> protocolVersions;
    private final ConcurrentHashMap<String, McpServerFeatures.AsyncResourceTemplateSpecification> resourceTemplates;
    private final ConcurrentHashMap<String, McpServerFeatures.AsyncResourceSpecification> resources;
    private final McpSchema.ServerCapabilities serverCapabilities;
    private final McpSchema.Implementation serverInfo;
    private final CopyOnWriteArrayList<McpServerFeatures.AsyncToolSpecification> tools;
    private McpUriTemplateManagerFactory uriTemplateManagerFactory;
    private static final InterfaceC0315b logger = AbstractC0317d.b(McpAsyncServer.class);
    private static final Mono<McpSchema.CompleteResult> EMPTY_COMPLETION_RESULT = Mono.just(new McpSchema.CompleteResult(new McpSchema.CompleteResult.CompleteCompletion(Collections.EMPTY_LIST, 0, Boolean.FALSE)));

    public static class StructuredOutputCallToolHandler implements BiFunction<McpAsyncServerExchange, McpSchema.CallToolRequest, Mono<McpSchema.CallToolResult>> {
        private final BiFunction<McpAsyncServerExchange, McpSchema.CallToolRequest, Mono<McpSchema.CallToolResult>> delegateCallToolResult;
        private final JsonSchemaValidator jsonSchemaValidator;
        private final Map<String, Object> outputSchema;

        public StructuredOutputCallToolHandler(JsonSchemaValidator jsonSchemaValidator, Map<String, Object> map, BiFunction<McpAsyncServerExchange, McpSchema.CallToolRequest, Mono<McpSchema.CallToolResult>> biFunction) {
            Assert.notNull(jsonSchemaValidator, "JsonSchemaValidator must not be null");
            Assert.notNull(biFunction, "Delegate call tool result handler must not be null");
            this.delegateCallToolResult = biFunction;
            this.outputSchema = map;
            this.jsonSchemaValidator = jsonSchemaValidator;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ McpSchema.CallToolResult lambda$apply$0(McpSchema.CallToolResult callToolResult) {
            Boolean bool = Boolean.TRUE;
            if (!bool.equals(callToolResult.isError())) {
                if (this.outputSchema == null) {
                    if (callToolResult.structuredContent() != null) {
                        McpAsyncServer.logger.h(callToolResult.structuredContent(), "Tool call with no outputSchema is not expected to have a result with structured content, but got: {}");
                        return callToolResult;
                    }
                } else {
                    if (callToolResult.structuredContent() == null) {
                        McpAsyncServer.logger.warn("Response missing structured content which is expected when calling tool with non-empty outputSchema");
                        return new McpSchema.CallToolResult("Response missing structured content which is expected when calling tool with non-empty outputSchema", bool);
                    }
                    JsonSchemaValidator.ValidationResponse validationResponseValidate = this.jsonSchemaValidator.validate(this.outputSchema, callToolResult.structuredContent());
                    if (!validationResponseValidate.valid()) {
                        McpAsyncServer.logger.h(validationResponseValidate.errorMessage(), "Tool call result validation failed: {}");
                        return new McpSchema.CallToolResult(validationResponseValidate.errorMessage(), bool);
                    }
                    if (Utils.isEmpty(callToolResult.content())) {
                        return McpSchema.CallToolResult.builder().content(List.of(new McpSchema.TextContent(validationResponseValidate.jsonStructuredOutput()))).isError(callToolResult.isError()).structuredContent(callToolResult.structuredContent()).build();
                    }
                }
            }
            return callToolResult;
        }

        @Override // java.util.function.BiFunction
        public Mono<McpSchema.CallToolResult> apply(McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.CallToolRequest callToolRequest) {
            return this.delegateCallToolResult.apply(mcpAsyncServerExchange, callToolRequest).map(new v(this, 0));
        }
    }

    public McpAsyncServer(McpServerTransportProvider mcpServerTransportProvider, McpJsonMapper mcpJsonMapper, McpServerFeatures.Async async, final Duration duration, McpUriTemplateManagerFactory mcpUriTemplateManagerFactory, JsonSchemaValidator jsonSchemaValidator) {
        CopyOnWriteArrayList<McpServerFeatures.AsyncToolSpecification> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        this.tools = copyOnWriteArrayList;
        ConcurrentHashMap<String, McpServerFeatures.AsyncResourceSpecification> concurrentHashMap = new ConcurrentHashMap<>();
        this.resources = concurrentHashMap;
        ConcurrentHashMap<String, McpServerFeatures.AsyncResourceTemplateSpecification> concurrentHashMap2 = new ConcurrentHashMap<>();
        this.resourceTemplates = concurrentHashMap2;
        ConcurrentHashMap<String, McpServerFeatures.AsyncPromptSpecification> concurrentHashMap3 = new ConcurrentHashMap<>();
        this.prompts = concurrentHashMap3;
        this.minLoggingLevel = McpSchema.LoggingLevel.DEBUG;
        ConcurrentHashMap<McpSchema.CompleteReference, McpServerFeatures.AsyncCompletionSpecification> concurrentHashMap4 = new ConcurrentHashMap<>();
        this.completions = concurrentHashMap4;
        this.uriTemplateManagerFactory = new DefaultMcpUriTemplateManagerFactory();
        this.mcpTransportProvider = mcpServerTransportProvider;
        this.jsonMapper = mcpJsonMapper;
        this.serverInfo = async.serverInfo();
        this.serverCapabilities = async.serverCapabilities().mutate().logging().build();
        this.instructions = async.instructions();
        copyOnWriteArrayList.addAll(withStructuredOutputHandling(jsonSchemaValidator, async.tools()));
        concurrentHashMap.putAll(async.resources());
        concurrentHashMap2.putAll(async.resourceTemplates());
        concurrentHashMap3.putAll(async.prompts());
        concurrentHashMap4.putAll(async.completions());
        this.uriTemplateManagerFactory = mcpUriTemplateManagerFactory;
        this.jsonSchemaValidator = jsonSchemaValidator;
        final Map<String, McpRequestHandler<?>> mapPrepareRequestHandlers = prepareRequestHandlers();
        final Map<String, McpNotificationHandler> mapPrepareNotificationHandlers = prepareNotificationHandlers(async);
        this.protocolVersions = mcpServerTransportProvider.protocolVersions();
        mcpServerTransportProvider.setSessionFactory(new McpServerSession.Factory() { // from class: io.modelcontextprotocol.server.g
            @Override // io.modelcontextprotocol.spec.McpServerSession.Factory
            public final McpServerSession create(McpServerTransport mcpServerTransport) {
                return this.f4707a.lambda$new$0(duration, mapPrepareRequestHandlers, mapPrepareNotificationHandlers, mcpServerTransport);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Mono<McpSchema.InitializeResult> asyncInitializeRequestHandler(McpSchema.InitializeRequest initializeRequest) {
        return Mono.defer(new C1586d(4, this, initializeRequest));
    }

    private McpNotificationHandler asyncRootsListChangedNotificationHandler(final List<BiFunction<McpAsyncServerExchange, List<McpSchema.Root>, Mono<Void>>> list) {
        return new McpNotificationHandler() { // from class: io.modelcontextprotocol.server.t
            @Override // io.modelcontextprotocol.server.McpNotificationHandler
            public final Mono handle(McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
                return McpAsyncServer.lambda$asyncRootsListChangedNotificationHandler$10(list, mcpAsyncServerExchange, obj);
            }
        };
    }

    private McpRequestHandler<McpSchema.CompleteResult> completionCompleteRequestHandler() {
        return new C1584b(this, 8);
    }

    private Optional<McpServerFeatures.AsyncResourceSpecification> findResourceSpecification(String str) {
        return this.resources.values().stream().filter(new p(this, str, 1)).findFirst();
    }

    private Optional<McpServerFeatures.AsyncResourceTemplateSpecification> findResourceTemplateSpecification(String str) {
        return this.resourceTemplates.values().stream().filter(new p(this, str, 0)).findFirst();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$addPrompt$32(McpServerFeatures.AsyncPromptSpecification asyncPromptSpecification) {
        if (this.prompts.put(asyncPromptSpecification.prompt().name(), asyncPromptSpecification) != null) {
            logger.h(asyncPromptSpecification.prompt().name(), "Replace existing Prompt with name '{}'");
        } else {
            logger.j(asyncPromptSpecification.prompt().name(), "Added prompt handler: {}");
        }
        return this.serverCapabilities.prompts().listChanged().booleanValue() ? notifyPromptsListChanged() : Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$addResource$19(McpServerFeatures.AsyncResourceSpecification asyncResourceSpecification) {
        if (this.resources.put(asyncResourceSpecification.resource().uri(), asyncResourceSpecification) != null) {
            logger.h(asyncResourceSpecification.resource().uri(), "Replace existing Resource with URI '{}'");
        } else {
            logger.j(asyncResourceSpecification.resource().uri(), "Added resource handler: {}");
        }
        return this.serverCapabilities.resources().listChanged().booleanValue() ? notifyResourcesListChanged() : Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$addResourceTemplate$21(McpServerFeatures.AsyncResourceTemplateSpecification asyncResourceTemplateSpecification) {
        if (this.resourceTemplates.put(asyncResourceTemplateSpecification.resourceTemplate().uriTemplate(), asyncResourceTemplateSpecification) != null) {
            logger.h(asyncResourceTemplateSpecification.resourceTemplate().uriTemplate(), "Replace existing Resource Template with URI '{}'");
        } else {
            logger.j(asyncResourceTemplateSpecification.resourceTemplate().uriTemplate(), "Added resource template handler: {}");
        }
        return this.serverCapabilities.resources().listChanged().booleanValue() ? notifyResourcesListChanged() : Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$addTool$11(McpServerFeatures.AsyncToolSpecification asyncToolSpecification, McpServerFeatures.AsyncToolSpecification asyncToolSpecification2) {
        return asyncToolSpecification2.tool().name().equals(asyncToolSpecification.tool().name());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$addTool$12(McpServerFeatures.AsyncToolSpecification asyncToolSpecification) {
        if (this.tools.removeIf(new C1585c(asyncToolSpecification, 0))) {
            logger.h(asyncToolSpecification.tool().name(), "Replace existing Tool with name '{}'");
        }
        this.tools.add(asyncToolSpecification);
        logger.j(asyncToolSpecification.tool().name(), "Added tool handler: {}");
        return this.serverCapabilities.tools().listChanged().booleanValue() ? notifyToolsListChanged() : Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$asyncInitializeRequestHandler$5(McpSchema.InitializeRequest initializeRequest) {
        InterfaceC0315b interfaceC0315b = logger;
        interfaceC0315b.info("Client initialize request - Protocol: {}, Capabilities: {}, Info: {}", initializeRequest.protocolVersion(), initializeRequest.capabilities(), initializeRequest.clientInfo());
        String strProtocolVersion = this.protocolVersions.get(r1.size() - 1);
        if (this.protocolVersions.contains(initializeRequest.protocolVersion())) {
            strProtocolVersion = initializeRequest.protocolVersion();
        } else {
            interfaceC0315b.c("Client requested unsupported protocol version: {}, so the server will suggest the {} version instead", initializeRequest.protocolVersion(), strProtocolVersion);
        }
        return Mono.just(new McpSchema.InitializeResult(strProtocolVersion, this.serverCapabilities, this.serverInfo, this.instructions));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$asyncRootsListChangedNotificationHandler$10(List list, McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
        return mcpAsyncServerExchange.listRoots().flatMap(new C1588f(mcpAsyncServerExchange, list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$asyncRootsListChangedNotificationHandler$6(BiFunction biFunction, McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.ListRootsResult listRootsResult) {
        return (Mono) biFunction.apply(mcpAsyncServerExchange, listRootsResult.roots());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Z9.c lambda$asyncRootsListChangedNotificationHandler$7(McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.ListRootsResult listRootsResult, BiFunction biFunction) {
        return Mono.defer(new j(biFunction, mcpAsyncServerExchange, listRootsResult, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Z9.c lambda$asyncRootsListChangedNotificationHandler$8(Throwable th) {
        logger.error("Error handling roots list change notification", th);
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$asyncRootsListChangedNotificationHandler$9(List list, McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.ListRootsResult listRootsResult) {
        return Flux.fromIterable(list).flatMap(new C1588f(0, mcpAsyncServerExchange, listRootsResult)).onErrorResume(new E3.d(9)).then();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$completionCompleteRequestHandler$39(String str, McpSchema.PromptArgument promptArgument) {
        return promptArgument.name().equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$completionCompleteRequestHandler$40(McpServerFeatures.AsyncCompletionSpecification asyncCompletionSpecification, McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.CompleteRequest completeRequest) {
        return asyncCompletionSpecification.completionHandler().apply(mcpAsyncServerExchange, completeRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$completionCompleteRequestHandler$41(McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
        McpSchema.CompleteRequest completionParams = parseCompletionParams(obj);
        if (completionParams.ref() == null) {
            return Mono.error(McpError.builder(-32602).message("Completion ref must not be null").build());
        }
        if (completionParams.ref().type() == null) {
            return Mono.error(McpError.builder(-32602).message("Completion ref type must not be null").build());
        }
        String strType = completionParams.ref().type();
        String strName = completionParams.argument().name();
        if (strType.equals(McpSchema.PromptReference.TYPE)) {
            McpSchema.CompleteReference completeReferenceRef = completionParams.ref();
            if (completeReferenceRef instanceof McpSchema.PromptReference) {
                McpSchema.PromptReference promptReference = (McpSchema.PromptReference) completeReferenceRef;
                McpServerFeatures.AsyncPromptSpecification asyncPromptSpecification = this.prompts.get(promptReference.name());
                if (asyncPromptSpecification == null) {
                    return Mono.error(McpError.builder(-32602).message("Prompt not found: " + promptReference.name()).build());
                }
                if (!asyncPromptSpecification.prompt().arguments().stream().filter(new q(strName, 1)).findFirst().isPresent()) {
                    logger.c("Argument not found: {} in prompt: {}", strName, promptReference.name());
                    return EMPTY_COMPLETION_RESULT;
                }
            }
        }
        if (strType.equals(McpSchema.ResourceReference.TYPE)) {
            McpSchema.CompleteReference completeReferenceRef2 = completionParams.ref();
            if (completeReferenceRef2 instanceof McpSchema.ResourceReference) {
                McpSchema.ResourceReference resourceReference = (McpSchema.ResourceReference) completeReferenceRef2;
                if (!this.uriTemplateManagerFactory.create(resourceReference.uri()).isUriTemplate(resourceReference.uri())) {
                    return EMPTY_COMPLETION_RESULT;
                }
                McpServerFeatures.AsyncResourceSpecification asyncResourceSpecificationOrElse = findResourceSpecification(resourceReference.uri()).orElse(null);
                if (asyncResourceSpecificationOrElse == null) {
                    McpServerFeatures.AsyncResourceTemplateSpecification asyncResourceTemplateSpecificationOrElse = findResourceTemplateSpecification(resourceReference.uri()).orElse(null);
                    if (asyncResourceTemplateSpecificationOrElse == null) {
                        return Mono.error(McpError.RESOURCE_NOT_FOUND.apply(resourceReference.uri()));
                    }
                    if (!this.uriTemplateManagerFactory.create(asyncResourceTemplateSpecificationOrElse.resourceTemplate().uriTemplate()).getVariableNames().contains(strName)) {
                        return Mono.error(McpError.builder(-32602).message("Argument not found: " + strName + " in resource template: " + resourceReference.uri()).build());
                    }
                } else if (!this.uriTemplateManagerFactory.create(asyncResourceSpecificationOrElse.resource().uri()).getVariableNames().contains(strName)) {
                    return Mono.error(McpError.builder(-32602).message("Argument not found: " + strName + " in resource: " + resourceReference.uri()).build());
                }
            }
        }
        McpServerFeatures.AsyncCompletionSpecification asyncCompletionSpecification = this.completions.get(completionParams.ref());
        return asyncCompletionSpecification == null ? Mono.error(McpError.builder(-32602).message("AsyncCompletionSpecification not found: ".concat(String.valueOf(completionParams.ref()))).build()) : Mono.defer(new j(asyncCompletionSpecification, mcpAsyncServerExchange, completionParams, 3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$findResourceSpecification$30(String str, McpServerFeatures.AsyncResourceSpecification asyncResourceSpecification) {
        return this.uriTemplateManagerFactory.create(asyncResourceSpecification.resource().uri()).matches(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$findResourceTemplateSpecification$31(String str, McpServerFeatures.AsyncResourceTemplateSpecification asyncResourceTemplateSpecification) {
        return this.uriTemplateManagerFactory.create(asyncResourceTemplateSpecification.resourceTemplate().uriTemplate()).matches(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ McpServerSession lambda$new$0(Duration duration, Map map, Map map2, McpServerTransport mcpServerTransport) {
        return new McpServerSession(UUID.randomUUID().toString(), duration, mcpServerTransport, new i(this, 0), map, map2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$prepareNotificationHandlers$1(McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$prepareNotificationHandlers$2(List list) {
        logger.h(list, "Roots list changed notification, but no consumers provided. Roots list changed: {}");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$prepareNotificationHandlers$3(McpAsyncServerExchange mcpAsyncServerExchange, final List list) {
        return Mono.fromRunnable(new Runnable() { // from class: io.modelcontextprotocol.server.u
            @Override // java.lang.Runnable
            public final void run() {
                McpAsyncServer.lambda$prepareNotificationHandlers$2(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$prepareRequestHandlers$4(McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
        return Mono.just(Collections.EMPTY_MAP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$promptsGetRequestHandler$35(McpServerFeatures.AsyncPromptSpecification asyncPromptSpecification, McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.GetPromptRequest getPromptRequest) {
        return asyncPromptSpecification.promptHandler().apply(mcpAsyncServerExchange, getPromptRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$promptsGetRequestHandler$36(McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
        McpSchema.GetPromptRequest getPromptRequest = (McpSchema.GetPromptRequest) this.jsonMapper.convertValue(obj, new TypeRef<McpSchema.GetPromptRequest>() { // from class: io.modelcontextprotocol.server.McpAsyncServer.3
        });
        McpServerFeatures.AsyncPromptSpecification asyncPromptSpecification = this.prompts.get(getPromptRequest.name());
        if (asyncPromptSpecification != null) {
            return Mono.defer(new j(asyncPromptSpecification, mcpAsyncServerExchange, getPromptRequest, 1));
        }
        return Mono.error(McpError.builder(-32602).message("Invalid prompt name").data("Prompt not found: " + getPromptRequest.name()).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$promptsListRequestHandler$34(McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
        return Mono.just(new McpSchema.ListPromptsResult(this.prompts.values().stream().map(new E3.d(11)).toList(), null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$removePrompt$33(String str) {
        if (this.prompts.remove(str) != null) {
            logger.j(str, "Removed prompt handler: {}");
            return this.serverCapabilities.prompts().listChanged().booleanValue() ? notifyPromptsListChanged() : Mono.empty();
        }
        logger.h(str, "Ignore as a Prompt with name '{}' not found");
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$removeResource$20(String str) {
        if (this.resources.remove(str) != null) {
            logger.j(str, "Removed resource handler: {}");
            return this.serverCapabilities.resources().listChanged().booleanValue() ? notifyResourcesListChanged() : Mono.empty();
        }
        logger.h(str, "Ignore as a Resource with URI '{}' not found");
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$removeResourceTemplate$22(String str) {
        if (this.resourceTemplates.remove(str) != null) {
            logger.j(str, "Removed resource template: {}");
        } else {
            logger.h(str, "Ignore as a Resource Template with URI '{}' not found");
        }
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$removeTool$14(String str, McpServerFeatures.AsyncToolSpecification asyncToolSpecification) {
        return asyncToolSpecification.tool().name().equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$removeTool$15(String str) {
        if (this.tools.removeIf(new q(str, 0))) {
            logger.j(str, "Removed tool handler: {}");
            if (this.serverCapabilities.tools().listChanged().booleanValue()) {
                return notifyToolsListChanged();
            }
        } else {
            logger.h(str, "Ignore as a Tool with name '{}' not found");
        }
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$resourceTemplateListRequestHandler$24(McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
        return Mono.just(new McpSchema.ListResourceTemplatesResult(this.resourceTemplates.values().stream().map(new E3.d(13)).toList(), null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$resourcesListRequestHandler$23(McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
        return Mono.just(new McpSchema.ListResourcesResult(this.resources.values().stream().map(new E3.d(12)).toList(), null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$resourcesReadRequestHandler$25(McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.ReadResourceRequest readResourceRequest, McpServerFeatures.AsyncResourceSpecification asyncResourceSpecification) {
        return asyncResourceSpecification.readHandler().apply(mcpAsyncServerExchange, readResourceRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$resourcesReadRequestHandler$26(McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.ReadResourceRequest readResourceRequest, McpServerFeatures.AsyncResourceTemplateSpecification asyncResourceTemplateSpecification) {
        return asyncResourceTemplateSpecification.readHandler().apply(mcpAsyncServerExchange, readResourceRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$resourcesReadRequestHandler$27(String str) {
        return Mono.error(McpError.RESOURCE_NOT_FOUND.apply(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$resourcesReadRequestHandler$28(String str, McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.ReadResourceRequest readResourceRequest) {
        return (Mono) findResourceTemplateSpecification(str).map(new h(mcpAsyncServerExchange, readResourceRequest, 1)).orElseGet(new k(str, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$resourcesReadRequestHandler$29(McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
        McpSchema.ReadResourceRequest readResourceRequest = (McpSchema.ReadResourceRequest) this.jsonMapper.convertValue(obj, new TypeRef<McpSchema.ReadResourceRequest>() { // from class: io.modelcontextprotocol.server.McpAsyncServer.2
        });
        String strUri = readResourceRequest.uri();
        return (Mono) findResourceSpecification(strUri).map(new h(mcpAsyncServerExchange, readResourceRequest, 0)).orElseGet(new m(this, strUri, mcpAsyncServerExchange, readResourceRequest, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$setLoggerRequestHandler$37(Object obj, McpAsyncServerExchange mcpAsyncServerExchange) {
        McpSchema.SetLevelRequest setLevelRequest = (McpSchema.SetLevelRequest) this.jsonMapper.convertValue(obj, new TypeRef<McpSchema.SetLevelRequest>() { // from class: io.modelcontextprotocol.server.McpAsyncServer.4
        });
        mcpAsyncServerExchange.setMinLoggingLevel(setLevelRequest.level());
        this.minLoggingLevel = setLevelRequest.level();
        return Mono.just(Collections.EMPTY_MAP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$setLoggerRequestHandler$38(McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
        return Mono.defer(new j(this, mcpAsyncServerExchange, obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$toolsCallRequestHandler$17(McpSchema.CallToolRequest callToolRequest, McpServerFeatures.AsyncToolSpecification asyncToolSpecification) {
        return callToolRequest.name().equals(asyncToolSpecification.tool().name());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$toolsCallRequestHandler$18(McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
        McpSchema.CallToolRequest callToolRequest = (McpSchema.CallToolRequest) this.jsonMapper.convertValue(obj, new TypeRef<McpSchema.CallToolRequest>() { // from class: io.modelcontextprotocol.server.McpAsyncServer.1
        });
        Optional<McpServerFeatures.AsyncToolSpecification> optionalFindAny = this.tools.stream().filter(new s(callToolRequest, 0)).findAny();
        if (!optionalFindAny.isEmpty()) {
            return optionalFindAny.get().callHandler().apply(mcpAsyncServerExchange, callToolRequest);
        }
        return Mono.error(McpError.builder(-32602).message("Unknown tool: invalid_tool_name").data("Tool not found: " + callToolRequest.name()).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$toolsListRequestHandler$16(McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
        return Mono.just(new McpSchema.ListToolsResult(this.tools.stream().map(new E3.d(10)).toList(), null));
    }

    private McpSchema.CompleteRequest parseCompletionParams(Object obj) {
        McpSchema.CompleteReference resourceReference;
        Map map = (Map) obj;
        Map map2 = (Map) map.get("ref");
        Map map3 = (Map) map.get("argument");
        Map map4 = (Map) map.get("context");
        Map map5 = (Map) map.get("_meta");
        String str = (String) map2.get("type");
        str.getClass();
        if (str.equals(McpSchema.ResourceReference.TYPE)) {
            resourceReference = new McpSchema.ResourceReference(str, (String) map2.get("uri"));
        } else {
            if (!str.equals(McpSchema.PromptReference.TYPE)) {
                throw new IllegalArgumentException("Invalid ref type: ".concat(str));
            }
            resourceReference = new McpSchema.PromptReference(str, (String) map2.get(HintConstants.AUTOFILL_HINT_NAME), map2.get("title") != null ? (String) map2.get("title") : null);
        }
        return new McpSchema.CompleteRequest(resourceReference, new McpSchema.CompleteRequest.CompleteArgument((String) map3.get(HintConstants.AUTOFILL_HINT_NAME), (String) map3.get("value")), map5, map4 != null ? new McpSchema.CompleteRequest.CompleteContext((Map) map4.get("arguments")) : null);
    }

    private Map<String, McpNotificationHandler> prepareNotificationHandlers(McpServerFeatures.Async async) {
        HashMap map = new HashMap();
        map.put(McpSchema.METHOD_NOTIFICATION_INITIALIZED, new n());
        List<BiFunction<McpAsyncServerExchange, List<McpSchema.Root>, Mono<Void>>> listRootsChangeConsumers = async.rootsChangeConsumers();
        if (Utils.isEmpty(listRootsChangeConsumers)) {
            listRootsChangeConsumers = List.of(new o(0));
        }
        map.put(McpSchema.METHOD_NOTIFICATION_ROOTS_LIST_CHANGED, asyncRootsListChangedNotificationHandler(listRootsChangeConsumers));
        return map;
    }

    private Map<String, McpRequestHandler<?>> prepareRequestHandlers() {
        HashMap map = new HashMap();
        map.put(McpSchema.METHOD_PING, new r());
        if (this.serverCapabilities.tools() != null) {
            map.put(McpSchema.METHOD_TOOLS_LIST, toolsListRequestHandler());
            map.put(McpSchema.METHOD_TOOLS_CALL, toolsCallRequestHandler());
        }
        if (this.serverCapabilities.resources() != null) {
            map.put(McpSchema.METHOD_RESOURCES_LIST, resourcesListRequestHandler());
            map.put(McpSchema.METHOD_RESOURCES_READ, resourcesReadRequestHandler());
            map.put(McpSchema.METHOD_RESOURCES_TEMPLATES_LIST, resourceTemplateListRequestHandler());
        }
        if (this.serverCapabilities.prompts() != null) {
            map.put(McpSchema.METHOD_PROMPT_LIST, promptsListRequestHandler());
            map.put(McpSchema.METHOD_PROMPT_GET, promptsGetRequestHandler());
        }
        if (this.serverCapabilities.logging() != null) {
            map.put(McpSchema.METHOD_LOGGING_SET_LEVEL, setLoggerRequestHandler());
        }
        if (this.serverCapabilities.completions() != null) {
            map.put(McpSchema.METHOD_COMPLETION_COMPLETE, completionCompleteRequestHandler());
        }
        return map;
    }

    private McpRequestHandler<McpSchema.GetPromptResult> promptsGetRequestHandler() {
        return new C1584b(this, 7);
    }

    private McpRequestHandler<McpSchema.ListPromptsResult> promptsListRequestHandler() {
        return new C1584b(this, 6);
    }

    private McpRequestHandler<McpSchema.ListResourceTemplatesResult> resourceTemplateListRequestHandler() {
        return new C1584b(this, 0);
    }

    private McpRequestHandler<McpSchema.ListResourcesResult> resourcesListRequestHandler() {
        return new C1584b(this, 3);
    }

    private McpRequestHandler<McpSchema.ReadResourceResult> resourcesReadRequestHandler() {
        return new C1584b(this, 2);
    }

    private McpRequestHandler<Object> setLoggerRequestHandler() {
        return new C1584b(this, 5);
    }

    private McpRequestHandler<McpSchema.CallToolResult> toolsCallRequestHandler() {
        return new C1584b(this, 4);
    }

    private McpRequestHandler<McpSchema.ListToolsResult> toolsListRequestHandler() {
        return new C1584b(this, 1);
    }

    private static List<McpServerFeatures.AsyncToolSpecification> withStructuredOutputHandling(JsonSchemaValidator jsonSchemaValidator, List<McpServerFeatures.AsyncToolSpecification> list) {
        return Utils.isEmpty(list) ? list : list.stream().map(new l(jsonSchemaValidator, 0)).toList();
    }

    public Mono<Void> addPrompt(McpServerFeatures.AsyncPromptSpecification asyncPromptSpecification) {
        return asyncPromptSpecification == null ? Mono.error(new IllegalArgumentException("Prompt specification must not be null")) : this.serverCapabilities.prompts() == null ? com.stepos.statsrpk.service.c.i("Server must be configured with prompt capabilities") : Mono.defer(new C1586d(3, this, asyncPromptSpecification));
    }

    public Mono<Void> addResource(McpServerFeatures.AsyncResourceSpecification asyncResourceSpecification) {
        return (asyncResourceSpecification == null || asyncResourceSpecification.resource() == null) ? Mono.error(new IllegalArgumentException("Resource must not be null")) : this.serverCapabilities.resources() == null ? com.stepos.statsrpk.service.c.i("Server must be configured with resource capabilities to allow adding resources") : Mono.defer(new C1586d(0, this, asyncResourceSpecification));
    }

    public Mono<Void> addResourceTemplate(McpServerFeatures.AsyncResourceTemplateSpecification asyncResourceTemplateSpecification) {
        return this.serverCapabilities.resources() == null ? com.stepos.statsrpk.service.c.i("Server must be configured with resource capabilities to allow adding resource templates") : Mono.defer(new C1586d(1, this, asyncResourceTemplateSpecification));
    }

    public Mono<Void> addTool(McpServerFeatures.AsyncToolSpecification asyncToolSpecification) {
        if (asyncToolSpecification == null) {
            return Mono.error(new IllegalArgumentException("Tool specification must not be null"));
        }
        if (asyncToolSpecification.tool() == null) {
            return Mono.error(new IllegalArgumentException("Tool must not be null"));
        }
        if (asyncToolSpecification.call() == null && asyncToolSpecification.callHandler() == null) {
            return Mono.error(new IllegalArgumentException("Tool call handler must not be null"));
        }
        if (this.serverCapabilities.tools() == null) {
            return com.stepos.statsrpk.service.c.i("Server must be configured with tool capabilities");
        }
        return Mono.defer(new C1586d(2, this, withStructuredOutputHandling(this.jsonSchemaValidator, asyncToolSpecification)));
    }

    public void close() {
        this.mcpTransportProvider.close();
    }

    public Mono<Void> closeGracefully() {
        return this.mcpTransportProvider.closeGracefully();
    }

    public McpSchema.ServerCapabilities getServerCapabilities() {
        return this.serverCapabilities;
    }

    public McpSchema.Implementation getServerInfo() {
        return this.serverInfo;
    }

    public Flux<McpSchema.Prompt> listPrompts() {
        return Flux.fromIterable(this.prompts.values()).map(new E3.d(11));
    }

    public Flux<McpSchema.ResourceTemplate> listResourceTemplates() {
        return Flux.fromIterable(this.resourceTemplates.values()).map(new E3.d(13));
    }

    public Flux<McpSchema.Resource> listResources() {
        return Flux.fromIterable(this.resources.values()).map(new E3.d(12));
    }

    public Flux<McpSchema.Tool> listTools() {
        return Flux.fromIterable(this.tools).map(new E3.d(10));
    }

    @Deprecated
    public Mono<Void> loggingNotification(McpSchema.LoggingMessageNotification loggingMessageNotification) {
        return loggingMessageNotification == null ? Mono.error(new McpError("Logging message must not be null")) : loggingMessageNotification.level().level() < this.minLoggingLevel.level() ? Mono.empty() : this.mcpTransportProvider.notifyClients(McpSchema.METHOD_NOTIFICATION_MESSAGE, loggingMessageNotification);
    }

    public Mono<Void> notifyPromptsListChanged() {
        return this.mcpTransportProvider.notifyClients(McpSchema.METHOD_NOTIFICATION_PROMPTS_LIST_CHANGED, null);
    }

    public Mono<Void> notifyResourcesListChanged() {
        return this.mcpTransportProvider.notifyClients(McpSchema.METHOD_NOTIFICATION_RESOURCES_LIST_CHANGED, null);
    }

    public Mono<Void> notifyResourcesUpdated(McpSchema.ResourcesUpdatedNotification resourcesUpdatedNotification) {
        return this.mcpTransportProvider.notifyClients(McpSchema.METHOD_NOTIFICATION_RESOURCES_UPDATED, resourcesUpdatedNotification);
    }

    public Mono<Void> notifyToolsListChanged() {
        return this.mcpTransportProvider.notifyClients(McpSchema.METHOD_NOTIFICATION_TOOLS_LIST_CHANGED, null);
    }

    public Mono<Void> removePrompt(String str) {
        return str == null ? Mono.error(new IllegalArgumentException("Prompt name must not be null")) : this.serverCapabilities.prompts() == null ? com.stepos.statsrpk.service.c.i("Server must be configured with prompt capabilities") : Mono.defer(new C1587e(this, str, 3));
    }

    public Mono<Void> removeResource(String str) {
        return str == null ? Mono.error(new IllegalArgumentException("Resource URI must not be null")) : this.serverCapabilities.resources() == null ? com.stepos.statsrpk.service.c.i("Server must be configured with resource capabilities to allow removing resources") : Mono.defer(new C1587e(this, str, 1));
    }

    public Mono<Void> removeResourceTemplate(String str) {
        return this.serverCapabilities.resources() == null ? com.stepos.statsrpk.service.c.i("Server must be configured with resource capabilities to allow removing resource templates") : Mono.defer(new C1587e(this, str, 2));
    }

    public Mono<Void> removeTool(String str) {
        return str == null ? Mono.error(new IllegalArgumentException("Tool name must not be null")) : this.serverCapabilities.tools() == null ? com.stepos.statsrpk.service.c.i("Server must be configured with tool capabilities") : Mono.defer(new C1587e(this, str, 0));
    }

    public void setProtocolVersions(List<String> list) {
        this.protocolVersions = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static McpServerFeatures.AsyncToolSpecification withStructuredOutputHandling(JsonSchemaValidator jsonSchemaValidator, McpServerFeatures.AsyncToolSpecification asyncToolSpecification) {
        return ((asyncToolSpecification.callHandler() instanceof StructuredOutputCallToolHandler) || asyncToolSpecification.tool().outputSchema() == null) ? asyncToolSpecification : McpServerFeatures.AsyncToolSpecification.builder().tool(asyncToolSpecification.tool()).callHandler(new StructuredOutputCallToolHandler(jsonSchemaValidator, asyncToolSpecification.tool().outputSchema(), asyncToolSpecification.callHandler())).build();
    }

    public McpAsyncServer(McpStreamableServerTransportProvider mcpStreamableServerTransportProvider, McpJsonMapper mcpJsonMapper, McpServerFeatures.Async async, Duration duration, McpUriTemplateManagerFactory mcpUriTemplateManagerFactory, JsonSchemaValidator jsonSchemaValidator) {
        CopyOnWriteArrayList<McpServerFeatures.AsyncToolSpecification> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        this.tools = copyOnWriteArrayList;
        ConcurrentHashMap<String, McpServerFeatures.AsyncResourceSpecification> concurrentHashMap = new ConcurrentHashMap<>();
        this.resources = concurrentHashMap;
        ConcurrentHashMap<String, McpServerFeatures.AsyncResourceTemplateSpecification> concurrentHashMap2 = new ConcurrentHashMap<>();
        this.resourceTemplates = concurrentHashMap2;
        ConcurrentHashMap<String, McpServerFeatures.AsyncPromptSpecification> concurrentHashMap3 = new ConcurrentHashMap<>();
        this.prompts = concurrentHashMap3;
        this.minLoggingLevel = McpSchema.LoggingLevel.DEBUG;
        ConcurrentHashMap<McpSchema.CompleteReference, McpServerFeatures.AsyncCompletionSpecification> concurrentHashMap4 = new ConcurrentHashMap<>();
        this.completions = concurrentHashMap4;
        this.uriTemplateManagerFactory = new DefaultMcpUriTemplateManagerFactory();
        this.mcpTransportProvider = mcpStreamableServerTransportProvider;
        this.jsonMapper = mcpJsonMapper;
        this.serverInfo = async.serverInfo();
        this.serverCapabilities = async.serverCapabilities().mutate().logging().build();
        this.instructions = async.instructions();
        copyOnWriteArrayList.addAll(withStructuredOutputHandling(jsonSchemaValidator, async.tools()));
        concurrentHashMap.putAll(async.resources());
        concurrentHashMap2.putAll(async.resourceTemplates());
        concurrentHashMap3.putAll(async.prompts());
        concurrentHashMap4.putAll(async.completions());
        this.uriTemplateManagerFactory = mcpUriTemplateManagerFactory;
        this.jsonSchemaValidator = jsonSchemaValidator;
        Map<String, McpRequestHandler<?>> mapPrepareRequestHandlers = prepareRequestHandlers();
        Map<String, McpNotificationHandler> mapPrepareNotificationHandlers = prepareNotificationHandlers(async);
        this.protocolVersions = mcpStreamableServerTransportProvider.protocolVersions();
        mcpStreamableServerTransportProvider.setSessionFactory(new DefaultMcpStreamableServerSessionFactory(duration, new i(this, 1), mapPrepareRequestHandlers, mapPrepareNotificationHandlers));
    }
}
