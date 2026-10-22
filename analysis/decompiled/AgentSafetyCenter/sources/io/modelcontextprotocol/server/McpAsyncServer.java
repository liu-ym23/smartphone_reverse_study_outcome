package io.modelcontextprotocol.server;

import b8.n0;
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
import java.lang.invoke.VarHandle;
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
import java.util.stream.Stream;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
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
    private static final rd.b logger = rd.d.b(McpAsyncServer.class);
    private static final Mono<McpSchema.CompleteResult> EMPTY_COMPLETION_RESULT = Mono.just(new McpSchema.CompleteResult(new McpSchema.CompleteResult.CompleteCompletion(Collections.EMPTY_LIST, 0, Boolean.FALSE)));

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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
                        McpAsyncServer.logger.b(callToolResult.structuredContent(), "Tool call with no outputSchema is not expected to have a result with structured content, but got: {}");
                        return callToolResult;
                    }
                } else {
                    if (callToolResult.structuredContent() == null) {
                        McpAsyncServer.logger.warn("Response missing structured content which is expected when calling tool with non-empty outputSchema");
                        return new McpSchema.CallToolResult("Response missing structured content which is expected when calling tool with non-empty outputSchema", bool);
                    }
                    JsonSchemaValidator.ValidationResponse validationResponseValidate = this.jsonSchemaValidator.validate(this.outputSchema, callToolResult.structuredContent());
                    if (!validationResponseValidate.valid()) {
                        McpAsyncServer.logger.b(validationResponseValidate.errorMessage(), "Tool call result validation failed: {}");
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
            Mono<McpSchema.CallToolResult> monoApply = this.delegateCallToolResult.apply(mcpAsyncServerExchange, callToolRequest);
            t tVar = new t(0);
            tVar.f6291b = this;
            VarHandle.storeStoreFence();
            return monoApply.map(tVar);
        }
    }

    public McpAsyncServer(McpServerTransportProvider mcpServerTransportProvider, McpJsonMapper mcpJsonMapper, McpServerFeatures.Async async, Duration duration, McpUriTemplateManagerFactory mcpUriTemplateManagerFactory, JsonSchemaValidator jsonSchemaValidator) {
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
        Map<String, McpRequestHandler<?>> mapPrepareRequestHandlers = prepareRequestHandlers();
        Map<String, McpNotificationHandler> mapPrepareNotificationHandlers = prepareNotificationHandlers(async);
        this.protocolVersions = mcpServerTransportProvider.protocolVersions();
        f fVar = new f();
        fVar.f6263a = this;
        fVar.f6264b = duration;
        fVar.f6265c = mapPrepareRequestHandlers;
        fVar.f6266d = mapPrepareNotificationHandlers;
        VarHandle.storeStoreFence();
        mcpServerTransportProvider.setSessionFactory(fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Mono<McpSchema.InitializeResult> asyncInitializeRequestHandler(McpSchema.InitializeRequest initializeRequest) {
        n0 n0Var = new n0(5);
        n0Var.f1991f = this;
        n0Var.f1992g = initializeRequest;
        VarHandle.storeStoreFence();
        return Mono.defer(n0Var);
    }

    private McpNotificationHandler asyncRootsListChangedNotificationHandler(List<BiFunction<McpAsyncServerExchange, List<McpSchema.Root>, Mono<Void>>> list) {
        r rVar = new r();
        rVar.f6288a = list;
        VarHandle.storeStoreFence();
        return rVar;
    }

    private McpRequestHandler<McpSchema.CompleteResult> completionCompleteRequestHandler() {
        b bVar = new b(8);
        bVar.f6245b = this;
        VarHandle.storeStoreFence();
        return bVar;
    }

    private Optional<McpServerFeatures.AsyncResourceSpecification> findResourceSpecification(String str) {
        Stream<McpServerFeatures.AsyncResourceSpecification> stream = this.resources.values().stream();
        n nVar = new n(1);
        nVar.f6282f = this;
        nVar.f6283g = str;
        VarHandle.storeStoreFence();
        return stream.filter(nVar).findFirst();
    }

    private Optional<McpServerFeatures.AsyncResourceTemplateSpecification> findResourceTemplateSpecification(String str) {
        Stream<McpServerFeatures.AsyncResourceTemplateSpecification> stream = this.resourceTemplates.values().stream();
        n nVar = new n(0);
        nVar.f6282f = this;
        nVar.f6283g = str;
        VarHandle.storeStoreFence();
        return stream.filter(nVar).findFirst();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$addPrompt$32(McpServerFeatures.AsyncPromptSpecification asyncPromptSpecification) {
        if (this.prompts.put(asyncPromptSpecification.prompt().name(), asyncPromptSpecification) != null) {
            logger.b(asyncPromptSpecification.prompt().name(), "Replace existing Prompt with name '{}'");
        } else {
            logger.h(asyncPromptSpecification.prompt().name(), "Added prompt handler: {}");
        }
        return this.serverCapabilities.prompts().listChanged().booleanValue() ? notifyPromptsListChanged() : Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$addResource$19(McpServerFeatures.AsyncResourceSpecification asyncResourceSpecification) {
        if (this.resources.put(asyncResourceSpecification.resource().uri(), asyncResourceSpecification) != null) {
            logger.b(asyncResourceSpecification.resource().uri(), "Replace existing Resource with URI '{}'");
        } else {
            logger.h(asyncResourceSpecification.resource().uri(), "Added resource handler: {}");
        }
        return this.serverCapabilities.resources().listChanged().booleanValue() ? notifyResourcesListChanged() : Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$addResourceTemplate$21(McpServerFeatures.AsyncResourceTemplateSpecification asyncResourceTemplateSpecification) {
        if (this.resourceTemplates.put(asyncResourceTemplateSpecification.resourceTemplate().uriTemplate(), asyncResourceTemplateSpecification) != null) {
            logger.b(asyncResourceTemplateSpecification.resourceTemplate().uriTemplate(), "Replace existing Resource Template with URI '{}'");
        } else {
            logger.h(asyncResourceTemplateSpecification.resourceTemplate().uriTemplate(), "Added resource template handler: {}");
        }
        return this.serverCapabilities.resources().listChanged().booleanValue() ? notifyResourcesListChanged() : Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$addTool$11(McpServerFeatures.AsyncToolSpecification asyncToolSpecification, McpServerFeatures.AsyncToolSpecification asyncToolSpecification2) {
        return asyncToolSpecification2.tool().name().equals(asyncToolSpecification.tool().name());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$addTool$12(McpServerFeatures.AsyncToolSpecification asyncToolSpecification) {
        CopyOnWriteArrayList<McpServerFeatures.AsyncToolSpecification> copyOnWriteArrayList = this.tools;
        c cVar = new c(0);
        cVar.f6250f = asyncToolSpecification;
        VarHandle.storeStoreFence();
        if (copyOnWriteArrayList.removeIf(cVar)) {
            logger.b(asyncToolSpecification.tool().name(), "Replace existing Tool with name '{}'");
        }
        this.tools.add(asyncToolSpecification);
        logger.h(asyncToolSpecification.tool().name(), "Added tool handler: {}");
        return this.serverCapabilities.tools().listChanged().booleanValue() ? notifyToolsListChanged() : Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$asyncInitializeRequestHandler$5(McpSchema.InitializeRequest initializeRequest) {
        rd.b bVar = logger;
        bVar.info("Client initialize request - Protocol: {}, Capabilities: {}, Info: {}", initializeRequest.protocolVersion(), initializeRequest.capabilities(), initializeRequest.clientInfo());
        String strProtocolVersion = this.protocolVersions.get(r1.size() - 1);
        if (this.protocolVersions.contains(initializeRequest.protocolVersion())) {
            strProtocolVersion = initializeRequest.protocolVersion();
        } else {
            bVar.c("Client requested unsupported protocol version: {}, so the server will suggest the {} version instead", initializeRequest.protocolVersion(), strProtocolVersion);
        }
        return Mono.just(new McpSchema.InitializeResult(strProtocolVersion, this.serverCapabilities, this.serverInfo, this.instructions));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$asyncRootsListChangedNotificationHandler$10(List list, McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
        Mono<McpSchema.ListRootsResult> monoListRoots = mcpAsyncServerExchange.listRoots();
        e eVar = new e(1);
        eVar.f6262c = list;
        eVar.f6261b = mcpAsyncServerExchange;
        VarHandle.storeStoreFence();
        return monoListRoots.flatMap(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$asyncRootsListChangedNotificationHandler$6(BiFunction biFunction, McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.ListRootsResult listRootsResult) {
        return (Mono) biFunction.apply(mcpAsyncServerExchange, listRootsResult.roots());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ qd.c lambda$asyncRootsListChangedNotificationHandler$7(McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.ListRootsResult listRootsResult, BiFunction biFunction) {
        i iVar = new i(2);
        iVar.f6274g = biFunction;
        iVar.f6273f = mcpAsyncServerExchange;
        iVar.f6275h = listRootsResult;
        VarHandle.storeStoreFence();
        return Mono.defer(iVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ qd.c lambda$asyncRootsListChangedNotificationHandler$8(Throwable th) {
        logger.error("Error handling roots list change notification", th);
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$asyncRootsListChangedNotificationHandler$9(List list, McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.ListRootsResult listRootsResult) {
        Flux fluxFromIterable = Flux.fromIterable(list);
        e eVar = new e(0);
        eVar.f6261b = mcpAsyncServerExchange;
        eVar.f6262c = listRootsResult;
        VarHandle.storeStoreFence();
        return fluxFromIterable.flatMap(eVar).onErrorResume(new a8.b(10)).then();
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
            return Mono.error(McpError.builder(McpSchema.ErrorCodes.INVALID_PARAMS).message("Completion ref must not be null").build());
        }
        if (completionParams.ref().type() == null) {
            return Mono.error(McpError.builder(McpSchema.ErrorCodes.INVALID_PARAMS).message("Completion ref type must not be null").build());
        }
        String strType = completionParams.ref().type();
        String strName = completionParams.argument().name();
        if (strType.equals(McpSchema.PromptReference.TYPE)) {
            McpSchema.CompleteReference completeReferenceRef = completionParams.ref();
            if (completeReferenceRef instanceof McpSchema.PromptReference) {
                McpSchema.PromptReference promptReference = (McpSchema.PromptReference) completeReferenceRef;
                McpServerFeatures.AsyncPromptSpecification asyncPromptSpecification = this.prompts.get(promptReference.name());
                if (asyncPromptSpecification == null) {
                    return Mono.error(McpError.builder(McpSchema.ErrorCodes.INVALID_PARAMS).message("Prompt not found: " + promptReference.name()).build());
                }
                Stream<McpSchema.PromptArgument> stream = asyncPromptSpecification.prompt().arguments().stream();
                o oVar = new o(1);
                oVar.f6285f = strName;
                VarHandle.storeStoreFence();
                if (!stream.filter(oVar).findFirst().isPresent()) {
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
                        return Mono.error(McpError.builder(McpSchema.ErrorCodes.INVALID_PARAMS).message("Argument not found: " + strName + " in resource template: " + resourceReference.uri()).build());
                    }
                } else if (!this.uriTemplateManagerFactory.create(asyncResourceSpecificationOrElse.resource().uri()).getVariableNames().contains(strName)) {
                    return Mono.error(McpError.builder(McpSchema.ErrorCodes.INVALID_PARAMS).message("Argument not found: " + strName + " in resource: " + resourceReference.uri()).build());
                }
            }
        }
        McpServerFeatures.AsyncCompletionSpecification asyncCompletionSpecification = this.completions.get(completionParams.ref());
        if (asyncCompletionSpecification == null) {
            return Mono.error(McpError.builder(McpSchema.ErrorCodes.INVALID_PARAMS).message("AsyncCompletionSpecification not found: ".concat(String.valueOf(completionParams.ref()))).build());
        }
        i iVar = new i(3);
        iVar.f6274g = asyncCompletionSpecification;
        iVar.f6273f = mcpAsyncServerExchange;
        iVar.f6275h = completionParams;
        VarHandle.storeStoreFence();
        return Mono.defer(iVar);
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
        String string = UUID.randomUUID().toString();
        h hVar = new h(0);
        hVar.f6271b = this;
        VarHandle.storeStoreFence();
        return new McpServerSession(string, duration, mcpServerTransport, hVar, map, map2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$prepareNotificationHandlers$1(McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$prepareNotificationHandlers$2(List list) {
        logger.b(list, "Roots list changed notification, but no consumers provided. Roots list changed: {}");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$prepareNotificationHandlers$3(McpAsyncServerExchange mcpAsyncServerExchange, List list) {
        s sVar = new s();
        sVar.f6289c = list;
        VarHandle.storeStoreFence();
        return Mono.fromRunnable(sVar);
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
        if (asyncPromptSpecification == null) {
            return Mono.error(McpError.builder(McpSchema.ErrorCodes.INVALID_PARAMS).message("Invalid prompt name").data("Prompt not found: " + getPromptRequest.name()).build());
        }
        i iVar = new i(1);
        iVar.f6274g = asyncPromptSpecification;
        iVar.f6273f = mcpAsyncServerExchange;
        iVar.f6275h = getPromptRequest;
        VarHandle.storeStoreFence();
        return Mono.defer(iVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$promptsListRequestHandler$34(McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
        return Mono.just(new McpSchema.ListPromptsResult(this.prompts.values().stream().map(new a8.b(12)).toList(), null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$removePrompt$33(String str) {
        if (this.prompts.remove(str) != null) {
            logger.h(str, "Removed prompt handler: {}");
            return this.serverCapabilities.prompts().listChanged().booleanValue() ? notifyPromptsListChanged() : Mono.empty();
        }
        logger.b(str, "Ignore as a Prompt with name '{}' not found");
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$removeResource$20(String str) {
        if (this.resources.remove(str) != null) {
            logger.h(str, "Removed resource handler: {}");
            return this.serverCapabilities.resources().listChanged().booleanValue() ? notifyResourcesListChanged() : Mono.empty();
        }
        logger.b(str, "Ignore as a Resource with URI '{}' not found");
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$removeResourceTemplate$22(String str) {
        if (this.resourceTemplates.remove(str) != null) {
            logger.h(str, "Removed resource template: {}");
        } else {
            logger.b(str, "Ignore as a Resource Template with URI '{}' not found");
        }
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$removeTool$14(String str, McpServerFeatures.AsyncToolSpecification asyncToolSpecification) {
        return asyncToolSpecification.tool().name().equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$removeTool$15(String str) {
        CopyOnWriteArrayList<McpServerFeatures.AsyncToolSpecification> copyOnWriteArrayList = this.tools;
        o oVar = new o(0);
        oVar.f6285f = str;
        VarHandle.storeStoreFence();
        if (copyOnWriteArrayList.removeIf(oVar)) {
            logger.h(str, "Removed tool handler: {}");
            if (this.serverCapabilities.tools().listChanged().booleanValue()) {
                return notifyToolsListChanged();
            }
        } else {
            logger.b(str, "Ignore as a Tool with name '{}' not found");
        }
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$resourceTemplateListRequestHandler$24(McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
        return Mono.just(new McpSchema.ListResourceTemplatesResult(this.resourceTemplates.values().stream().map(new a8.b(14)).toList(), null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$resourcesListRequestHandler$23(McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
        return Mono.just(new McpSchema.ListResourcesResult(this.resources.values().stream().map(new a8.b(13)).toList(), null));
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
        Optional<McpServerFeatures.AsyncResourceTemplateSpecification> optionalFindResourceTemplateSpecification = findResourceTemplateSpecification(str);
        g gVar = new g(1);
        gVar.f6268b = mcpAsyncServerExchange;
        gVar.f6269c = readResourceRequest;
        VarHandle.storeStoreFence();
        Optional<U> map = optionalFindResourceTemplateSpecification.map(gVar);
        j jVar = new j(0);
        jVar.f6277f = str;
        VarHandle.storeStoreFence();
        return (Mono) map.orElseGet(jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$resourcesReadRequestHandler$29(McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
        McpSchema.ReadResourceRequest readResourceRequest = (McpSchema.ReadResourceRequest) this.jsonMapper.convertValue(obj, new TypeRef<McpSchema.ReadResourceRequest>() { // from class: io.modelcontextprotocol.server.McpAsyncServer.2
        });
        String strUri = readResourceRequest.uri();
        Optional<McpServerFeatures.AsyncResourceSpecification> optionalFindResourceSpecification = findResourceSpecification(strUri);
        g gVar = new g(0);
        gVar.f6268b = mcpAsyncServerExchange;
        gVar.f6269c = readResourceRequest;
        VarHandle.storeStoreFence();
        Optional<U> map = optionalFindResourceSpecification.map(gVar);
        b8.o oVar = new b8.o(2);
        oVar.f1994f = this;
        oVar.f1995g = strUri;
        oVar.f1996h = mcpAsyncServerExchange;
        oVar.i = readResourceRequest;
        VarHandle.storeStoreFence();
        return (Mono) map.orElseGet(oVar);
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
        i iVar = new i(0);
        iVar.f6274g = this;
        iVar.f6275h = obj;
        iVar.f6273f = mcpAsyncServerExchange;
        VarHandle.storeStoreFence();
        return Mono.defer(iVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$toolsCallRequestHandler$17(McpSchema.CallToolRequest callToolRequest, McpServerFeatures.AsyncToolSpecification asyncToolSpecification) {
        return callToolRequest.name().equals(asyncToolSpecification.tool().name());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$toolsCallRequestHandler$18(McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
        McpSchema.CallToolRequest callToolRequest = (McpSchema.CallToolRequest) this.jsonMapper.convertValue(obj, new TypeRef<McpSchema.CallToolRequest>() { // from class: io.modelcontextprotocol.server.McpAsyncServer.1
        });
        Stream<McpServerFeatures.AsyncToolSpecification> stream = this.tools.stream();
        q qVar = new q(0);
        qVar.f6287f = callToolRequest;
        VarHandle.storeStoreFence();
        Optional<McpServerFeatures.AsyncToolSpecification> optionalFindAny = stream.filter(qVar).findAny();
        if (!optionalFindAny.isEmpty()) {
            return optionalFindAny.get().callHandler().apply(mcpAsyncServerExchange, callToolRequest);
        }
        return Mono.error(McpError.builder(McpSchema.ErrorCodes.INVALID_PARAMS).message("Unknown tool: invalid_tool_name").data("Tool not found: " + callToolRequest.name()).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$toolsListRequestHandler$16(McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
        return Mono.just(new McpSchema.ListToolsResult(this.tools.stream().map(new a8.b(11)).toList(), null));
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
                g5.f.s("Invalid ref type: ".concat(str));
                return null;
            }
            resourceReference = new McpSchema.PromptReference(str, (String) map2.get("name"), map2.get("title") != null ? (String) map2.get("title") : null);
        }
        return new McpSchema.CompleteRequest(resourceReference, new McpSchema.CompleteRequest.CompleteArgument((String) map3.get("name"), (String) map3.get("value")), map5, map4 != null ? new McpSchema.CompleteRequest.CompleteContext((Map) map4.get("arguments")) : null);
    }

    private Map<String, McpNotificationHandler> prepareNotificationHandlers(McpServerFeatures.Async async) {
        HashMap map = new HashMap();
        map.put(McpSchema.METHOD_NOTIFICATION_INITIALIZED, new l());
        List<BiFunction<McpAsyncServerExchange, List<McpSchema.Root>, Mono<Void>>> listRootsChangeConsumers = async.rootsChangeConsumers();
        if (Utils.isEmpty(listRootsChangeConsumers)) {
            listRootsChangeConsumers = List.of(new m(0));
        }
        map.put(McpSchema.METHOD_NOTIFICATION_ROOTS_LIST_CHANGED, asyncRootsListChangedNotificationHandler(listRootsChangeConsumers));
        return map;
    }

    private Map<String, McpRequestHandler<?>> prepareRequestHandlers() {
        HashMap map = new HashMap();
        map.put(McpSchema.METHOD_PING, new p());
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
        b bVar = new b(7);
        bVar.f6245b = this;
        VarHandle.storeStoreFence();
        return bVar;
    }

    private McpRequestHandler<McpSchema.ListPromptsResult> promptsListRequestHandler() {
        b bVar = new b(6);
        bVar.f6245b = this;
        VarHandle.storeStoreFence();
        return bVar;
    }

    private McpRequestHandler<McpSchema.ListResourceTemplatesResult> resourceTemplateListRequestHandler() {
        b bVar = new b(0);
        bVar.f6245b = this;
        VarHandle.storeStoreFence();
        return bVar;
    }

    private McpRequestHandler<McpSchema.ListResourcesResult> resourcesListRequestHandler() {
        b bVar = new b(3);
        bVar.f6245b = this;
        VarHandle.storeStoreFence();
        return bVar;
    }

    private McpRequestHandler<McpSchema.ReadResourceResult> resourcesReadRequestHandler() {
        b bVar = new b(2);
        bVar.f6245b = this;
        VarHandle.storeStoreFence();
        return bVar;
    }

    private McpRequestHandler<Object> setLoggerRequestHandler() {
        b bVar = new b(5);
        bVar.f6245b = this;
        VarHandle.storeStoreFence();
        return bVar;
    }

    private McpRequestHandler<McpSchema.CallToolResult> toolsCallRequestHandler() {
        b bVar = new b(4);
        bVar.f6245b = this;
        VarHandle.storeStoreFence();
        return bVar;
    }

    private McpRequestHandler<McpSchema.ListToolsResult> toolsListRequestHandler() {
        b bVar = new b(1);
        bVar.f6245b = this;
        VarHandle.storeStoreFence();
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static McpServerFeatures.AsyncToolSpecification withStructuredOutputHandling(JsonSchemaValidator jsonSchemaValidator, McpServerFeatures.AsyncToolSpecification asyncToolSpecification) {
        return ((asyncToolSpecification.callHandler() instanceof StructuredOutputCallToolHandler) || asyncToolSpecification.tool().outputSchema() == null) ? asyncToolSpecification : McpServerFeatures.AsyncToolSpecification.builder().tool(asyncToolSpecification.tool()).callHandler(new StructuredOutputCallToolHandler(jsonSchemaValidator, asyncToolSpecification.tool().outputSchema(), asyncToolSpecification.callHandler())).build();
    }

    public Mono<Void> addPrompt(McpServerFeatures.AsyncPromptSpecification asyncPromptSpecification) {
        if (asyncPromptSpecification == null) {
            return Mono.error(new IllegalArgumentException("Prompt specification must not be null"));
        }
        if (this.serverCapabilities.prompts() == null) {
            return androidx.activity.b.q("Server must be configured with prompt capabilities");
        }
        n0 n0Var = new n0(4);
        n0Var.f1991f = this;
        n0Var.f1992g = asyncPromptSpecification;
        VarHandle.storeStoreFence();
        return Mono.defer(n0Var);
    }

    public Mono<Void> addResource(McpServerFeatures.AsyncResourceSpecification asyncResourceSpecification) {
        if (asyncResourceSpecification == null || asyncResourceSpecification.resource() == null) {
            return Mono.error(new IllegalArgumentException("Resource must not be null"));
        }
        if (this.serverCapabilities.resources() == null) {
            return androidx.activity.b.q("Server must be configured with resource capabilities to allow adding resources");
        }
        n0 n0Var = new n0(1);
        n0Var.f1991f = this;
        n0Var.f1992g = asyncResourceSpecification;
        VarHandle.storeStoreFence();
        return Mono.defer(n0Var);
    }

    public Mono<Void> addResourceTemplate(McpServerFeatures.AsyncResourceTemplateSpecification asyncResourceTemplateSpecification) {
        if (this.serverCapabilities.resources() == null) {
            return androidx.activity.b.q("Server must be configured with resource capabilities to allow adding resource templates");
        }
        n0 n0Var = new n0(2);
        n0Var.f1991f = this;
        n0Var.f1992g = asyncResourceTemplateSpecification;
        VarHandle.storeStoreFence();
        return Mono.defer(n0Var);
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
            return androidx.activity.b.q("Server must be configured with tool capabilities");
        }
        McpServerFeatures.AsyncToolSpecification asyncToolSpecificationWithStructuredOutputHandling = withStructuredOutputHandling(this.jsonSchemaValidator, asyncToolSpecification);
        n0 n0Var = new n0(3);
        n0Var.f1991f = this;
        n0Var.f1992g = asyncToolSpecificationWithStructuredOutputHandling;
        VarHandle.storeStoreFence();
        return Mono.defer(n0Var);
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
        return Flux.fromIterable(this.prompts.values()).map(new a8.b(12));
    }

    public Flux<McpSchema.ResourceTemplate> listResourceTemplates() {
        return Flux.fromIterable(this.resourceTemplates.values()).map(new a8.b(14));
    }

    public Flux<McpSchema.Resource> listResources() {
        return Flux.fromIterable(this.resources.values()).map(new a8.b(13));
    }

    public Flux<McpSchema.Tool> listTools() {
        return Flux.fromIterable(this.tools).map(new a8.b(11));
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
        if (str == null) {
            return Mono.error(new IllegalArgumentException("Prompt name must not be null"));
        }
        if (this.serverCapabilities.prompts() == null) {
            return androidx.activity.b.q("Server must be configured with prompt capabilities");
        }
        d dVar = new d(3);
        dVar.f6255f = this;
        dVar.f6256g = str;
        VarHandle.storeStoreFence();
        return Mono.defer(dVar);
    }

    public Mono<Void> removeResource(String str) {
        if (str == null) {
            return Mono.error(new IllegalArgumentException("Resource URI must not be null"));
        }
        if (this.serverCapabilities.resources() == null) {
            return androidx.activity.b.q("Server must be configured with resource capabilities to allow removing resources");
        }
        d dVar = new d(1);
        dVar.f6255f = this;
        dVar.f6256g = str;
        VarHandle.storeStoreFence();
        return Mono.defer(dVar);
    }

    public Mono<Void> removeResourceTemplate(String str) {
        if (this.serverCapabilities.resources() == null) {
            return androidx.activity.b.q("Server must be configured with resource capabilities to allow removing resource templates");
        }
        d dVar = new d(2);
        dVar.f6255f = this;
        dVar.f6256g = str;
        VarHandle.storeStoreFence();
        return Mono.defer(dVar);
    }

    public Mono<Void> removeTool(String str) {
        if (str == null) {
            return Mono.error(new IllegalArgumentException("Tool name must not be null"));
        }
        if (this.serverCapabilities.tools() == null) {
            return androidx.activity.b.q("Server must be configured with tool capabilities");
        }
        d dVar = new d(0);
        dVar.f6255f = this;
        dVar.f6256g = str;
        VarHandle.storeStoreFence();
        return Mono.defer(dVar);
    }

    public void setProtocolVersions(List<String> list) {
        this.protocolVersions = list;
    }

    private static List<McpServerFeatures.AsyncToolSpecification> withStructuredOutputHandling(JsonSchemaValidator jsonSchemaValidator, List<McpServerFeatures.AsyncToolSpecification> list) {
        if (Utils.isEmpty(list)) {
            return list;
        }
        Stream<McpServerFeatures.AsyncToolSpecification> stream = list.stream();
        k kVar = new k(0);
        kVar.f6279b = jsonSchemaValidator;
        VarHandle.storeStoreFence();
        return stream.map(kVar).toList();
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
        h hVar = new h(1);
        hVar.f6271b = this;
        VarHandle.storeStoreFence();
        mcpStreamableServerTransportProvider.setSessionFactory(new DefaultMcpStreamableServerSessionFactory(duration, hVar, mapPrepareRequestHandlers, mapPrepareNotificationHandlers));
    }
}
