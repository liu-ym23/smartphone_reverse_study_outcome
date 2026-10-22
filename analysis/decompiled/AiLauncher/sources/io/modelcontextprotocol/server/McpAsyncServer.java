package io.modelcontextprotocol.server;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
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
import io.modelcontextprotocol.spec.McpStreamableServerSession;
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
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/* loaded from: classes4.dex */
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
    private static final vc.c logger = vc.e.l(McpAsyncServer.class);
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
                        McpAsyncServer.logger.j("Tool call with no outputSchema is not expected to have a result with structured content, but got: {}", callToolResult.structuredContent());
                        return callToolResult;
                    }
                } else {
                    if (callToolResult.structuredContent() == null) {
                        McpAsyncServer.logger.warn("Response missing structured content which is expected when calling tool with non-empty outputSchema");
                        return new McpSchema.CallToolResult("Response missing structured content which is expected when calling tool with non-empty outputSchema", bool);
                    }
                    JsonSchemaValidator.ValidationResponse validationResponseValidate = this.jsonSchemaValidator.validate(this.outputSchema, callToolResult.structuredContent());
                    if (!validationResponseValidate.valid()) {
                        McpAsyncServer.logger.j("Tool call result validation failed: {}", validationResponseValidate.errorMessage());
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
            return this.delegateCallToolResult.apply(mcpAsyncServerExchange, callToolRequest).map(new Function() { // from class: io.modelcontextprotocol.server.Z
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.f33932a.lambda$apply$0((McpSchema.CallToolResult) obj);
                }
            });
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
        mcpServerTransportProvider.setSessionFactory(new McpServerSession.Factory() { // from class: io.modelcontextprotocol.server.l
            @Override // io.modelcontextprotocol.spec.McpServerSession.Factory
            public final McpServerSession create(McpServerTransport mcpServerTransport) {
                return this.f33971a.lambda$new$0(duration, mapPrepareRequestHandlers, mapPrepareNotificationHandlers, mcpServerTransport);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Mono<McpSchema.InitializeResult> asyncInitializeRequestHandler(final McpSchema.InitializeRequest initializeRequest) {
        return Mono.defer(new Supplier() { // from class: io.modelcontextprotocol.server.O
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f33902a.lambda$asyncInitializeRequestHandler$5(initializeRequest);
            }
        });
    }

    private McpNotificationHandler asyncRootsListChangedNotificationHandler(final List<BiFunction<McpAsyncServerExchange, List<McpSchema.Root>, Mono<Void>>> list) {
        return new McpNotificationHandler() { // from class: io.modelcontextprotocol.server.T
            @Override // io.modelcontextprotocol.server.McpNotificationHandler
            public final Mono handle(McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
                return mcpAsyncServerExchange.listRoots().flatMap(new Function() { // from class: io.modelcontextprotocol.server.o
                    @Override // java.util.function.Function
                    public final Object apply(Object obj2) {
                        return Flux.fromIterable(list).flatMap(new Function() { // from class: io.modelcontextprotocol.server.i
                            @Override // java.util.function.Function
                            public final Object apply(Object obj3) {
                                return Mono.defer(new Supplier() { // from class: io.modelcontextprotocol.server.V
                                    @Override // java.util.function.Supplier
                                    public final Object get() {
                                        return McpAsyncServer.f(biFunction, mcpAsyncServerExchange, listRootsResult);
                                    }
                                });
                            }
                        }).onErrorResume(new Function() { // from class: io.modelcontextprotocol.server.j
                            @Override // java.util.function.Function
                            public final Object apply(Object obj3) {
                                return McpAsyncServer.m((Throwable) obj3);
                            }
                        }).then();
                    }
                });
            }
        };
    }

    private McpRequestHandler<McpSchema.CompleteResult> completionCompleteRequestHandler() {
        return new McpRequestHandler() { // from class: io.modelcontextprotocol.server.H
            @Override // io.modelcontextprotocol.server.McpRequestHandler
            public final Mono handle(McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
                return this.f33878a.lambda$completionCompleteRequestHandler$41(mcpAsyncServerExchange, obj);
            }
        };
    }

    public static /* synthetic */ Mono f(BiFunction biFunction, McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.ListRootsResult listRootsResult) {
        return (Mono) biFunction.apply(mcpAsyncServerExchange, listRootsResult.roots());
    }

    private Optional<McpServerFeatures.AsyncResourceSpecification> findResourceSpecification(final String str) {
        return this.resources.values().stream().filter(new Predicate() { // from class: io.modelcontextprotocol.server.N
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return this.f33898a.lambda$findResourceSpecification$30(str, (McpServerFeatures.AsyncResourceSpecification) obj);
            }
        }).findFirst();
    }

    private Optional<McpServerFeatures.AsyncResourceTemplateSpecification> findResourceTemplateSpecification(final String str) {
        return this.resourceTemplates.values().stream().filter(new Predicate() { // from class: io.modelcontextprotocol.server.I
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return this.f33880a.lambda$findResourceTemplateSpecification$31(str, (McpServerFeatures.AsyncResourceTemplateSpecification) obj);
            }
        }).findFirst();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$addPrompt$32(McpServerFeatures.AsyncPromptSpecification asyncPromptSpecification) {
        if (this.prompts.put(asyncPromptSpecification.prompt().name(), asyncPromptSpecification) != null) {
            logger.j("Replace existing Prompt with name '{}'", asyncPromptSpecification.prompt().name());
        } else {
            logger.t("Added prompt handler: {}", asyncPromptSpecification.prompt().name());
        }
        return this.serverCapabilities.prompts().listChanged().booleanValue() ? notifyPromptsListChanged() : Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$addResource$19(McpServerFeatures.AsyncResourceSpecification asyncResourceSpecification) {
        if (this.resources.put(asyncResourceSpecification.resource().uri(), asyncResourceSpecification) != null) {
            logger.j("Replace existing Resource with URI '{}'", asyncResourceSpecification.resource().uri());
        } else {
            logger.t("Added resource handler: {}", asyncResourceSpecification.resource().uri());
        }
        return this.serverCapabilities.resources().listChanged().booleanValue() ? notifyResourcesListChanged() : Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$addResourceTemplate$21(McpServerFeatures.AsyncResourceTemplateSpecification asyncResourceTemplateSpecification) {
        if (this.resourceTemplates.put(asyncResourceTemplateSpecification.resourceTemplate().uriTemplate(), asyncResourceTemplateSpecification) != null) {
            logger.j("Replace existing Resource Template with URI '{}'", asyncResourceTemplateSpecification.resourceTemplate().uriTemplate());
        } else {
            logger.t("Added resource template handler: {}", asyncResourceTemplateSpecification.resourceTemplate().uriTemplate());
        }
        return this.serverCapabilities.resources().listChanged().booleanValue() ? notifyResourcesListChanged() : Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$addTool$12(final McpServerFeatures.AsyncToolSpecification asyncToolSpecification) {
        if (this.tools.removeIf(new Predicate() { // from class: io.modelcontextprotocol.server.d
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((McpServerFeatures.AsyncToolSpecification) obj).tool().name().equals(asyncToolSpecification.tool().name());
            }
        })) {
            logger.j("Replace existing Tool with name '{}'", asyncToolSpecification.tool().name());
        }
        this.tools.add(asyncToolSpecification);
        logger.t("Added tool handler: {}", asyncToolSpecification.tool().name());
        return this.serverCapabilities.tools().listChanged().booleanValue() ? notifyToolsListChanged() : Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$asyncInitializeRequestHandler$5(McpSchema.InitializeRequest initializeRequest) {
        vc.c cVar = logger;
        cVar.info("Client initialize request - Protocol: {}, Capabilities: {}, Info: {}", initializeRequest.protocolVersion(), initializeRequest.capabilities(), initializeRequest.clientInfo());
        String strProtocolVersion = this.protocolVersions.get(r1.size() - 1);
        if (this.protocolVersions.contains(initializeRequest.protocolVersion())) {
            strProtocolVersion = initializeRequest.protocolVersion();
        } else {
            cVar.c("Client requested unsupported protocol version: {}, so the server will suggest the {} version instead", initializeRequest.protocolVersion(), strProtocolVersion);
        }
        return Mono.just(new McpSchema.InitializeResult(strProtocolVersion, this.serverCapabilities, this.serverInfo, this.instructions));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$completionCompleteRequestHandler$41(final McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
        final McpSchema.CompleteRequest completionParams = parseCompletionParams(obj);
        if (completionParams.ref() == null) {
            return Mono.error(McpError.builder(McpSchema.ErrorCodes.INVALID_PARAMS).message("Completion ref must not be null").build());
        }
        if (completionParams.ref().type() == null) {
            return Mono.error(McpError.builder(McpSchema.ErrorCodes.INVALID_PARAMS).message("Completion ref type must not be null").build());
        }
        String strType = completionParams.ref().type();
        final String strName = completionParams.argument().name();
        if (strType.equals("ref/prompt")) {
            McpSchema.CompleteReference completeReferenceRef = completionParams.ref();
            if (completeReferenceRef instanceof McpSchema.PromptReference) {
                McpSchema.PromptReference promptReference = (McpSchema.PromptReference) completeReferenceRef;
                McpServerFeatures.AsyncPromptSpecification asyncPromptSpecification = this.prompts.get(promptReference.name());
                if (asyncPromptSpecification == null) {
                    return Mono.error(McpError.builder(McpSchema.ErrorCodes.INVALID_PARAMS).message("Prompt not found: " + promptReference.name()).build());
                }
                if (!asyncPromptSpecification.prompt().arguments().stream().filter(new Predicate() { // from class: io.modelcontextprotocol.server.W
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj2) {
                        return ((McpSchema.PromptArgument) obj2).name().equals(strName);
                    }
                }).findFirst().isPresent()) {
                    logger.c("Argument not found: {} in prompt: {}", strName, promptReference.name());
                    return EMPTY_COMPLETION_RESULT;
                }
            }
        }
        if (strType.equals("ref/resource")) {
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
        final McpServerFeatures.AsyncCompletionSpecification asyncCompletionSpecification = this.completions.get(completionParams.ref());
        if (asyncCompletionSpecification != null) {
            return Mono.defer(new Supplier() { // from class: io.modelcontextprotocol.server.X
                @Override // java.util.function.Supplier
                public final Object get() {
                    return asyncCompletionSpecification.completionHandler().apply(mcpAsyncServerExchange, completionParams);
                }
            });
        }
        return Mono.error(McpError.builder(McpSchema.ErrorCodes.INVALID_PARAMS).message("AsyncCompletionSpecification not found: " + String.valueOf(completionParams.ref())).build());
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
        return new McpServerSession(UUID.randomUUID().toString(), duration, mcpServerTransport, new McpInitRequestHandler() { // from class: io.modelcontextprotocol.server.q
            @Override // io.modelcontextprotocol.server.McpInitRequestHandler
            public final Mono handle(McpSchema.InitializeRequest initializeRequest) {
                return this.f33996a.asyncInitializeRequestHandler(initializeRequest);
            }
        }, map, map2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$promptsGetRequestHandler$36(final McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
        final McpSchema.GetPromptRequest getPromptRequest = (McpSchema.GetPromptRequest) this.jsonMapper.convertValue(obj, new TypeRef<McpSchema.GetPromptRequest>() { // from class: io.modelcontextprotocol.server.McpAsyncServer.3
        });
        final McpServerFeatures.AsyncPromptSpecification asyncPromptSpecification = this.prompts.get(getPromptRequest.name());
        if (asyncPromptSpecification != null) {
            return Mono.defer(new Supplier() { // from class: io.modelcontextprotocol.server.C
                @Override // java.util.function.Supplier
                public final Object get() {
                    return asyncPromptSpecification.promptHandler().apply(mcpAsyncServerExchange, getPromptRequest);
                }
            });
        }
        return Mono.error(McpError.builder(McpSchema.ErrorCodes.INVALID_PARAMS).message("Invalid prompt name").data("Prompt not found: " + getPromptRequest.name()).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$promptsListRequestHandler$34(McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
        return Mono.just(new McpSchema.ListPromptsResult(this.prompts.values().stream().map(new C4673p()).toList(), null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$removePrompt$33(String str) {
        if (this.prompts.remove(str) != null) {
            logger.t("Removed prompt handler: {}", str);
            return this.serverCapabilities.prompts().listChanged().booleanValue() ? notifyPromptsListChanged() : Mono.empty();
        }
        logger.j("Ignore as a Prompt with name '{}' not found", str);
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$removeResource$20(String str) {
        if (this.resources.remove(str) != null) {
            logger.t("Removed resource handler: {}", str);
            return this.serverCapabilities.resources().listChanged().booleanValue() ? notifyResourcesListChanged() : Mono.empty();
        }
        logger.j("Ignore as a Resource with URI '{}' not found", str);
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$removeResourceTemplate$22(String str) {
        if (this.resourceTemplates.remove(str) != null) {
            logger.t("Removed resource template: {}", str);
        } else {
            logger.j("Ignore as a Resource Template with URI '{}' not found", str);
        }
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$removeTool$15(final String str) {
        if (this.tools.removeIf(new Predicate() { // from class: io.modelcontextprotocol.server.J
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((McpServerFeatures.AsyncToolSpecification) obj).tool().name().equals(str);
            }
        })) {
            logger.t("Removed tool handler: {}", str);
            if (this.serverCapabilities.tools().listChanged().booleanValue()) {
                return notifyToolsListChanged();
            }
        } else {
            logger.j("Ignore as a Tool with name '{}' not found", str);
        }
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$resourceTemplateListRequestHandler$24(McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
        return Mono.just(new McpSchema.ListResourceTemplatesResult(this.resourceTemplates.values().stream().map(new Y()).toList(), null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$resourcesListRequestHandler$23(McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
        return Mono.just(new McpSchema.ListResourcesResult(this.resources.values().stream().map(new G()).toList(), null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$resourcesReadRequestHandler$28(final String str, final McpAsyncServerExchange mcpAsyncServerExchange, final McpSchema.ReadResourceRequest readResourceRequest) {
        return (Mono) findResourceTemplateSpecification(str).map(new Function() { // from class: io.modelcontextprotocol.server.u
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((McpServerFeatures.AsyncResourceTemplateSpecification) obj).readHandler().apply(mcpAsyncServerExchange, readResourceRequest);
            }
        }).orElseGet(new Supplier() { // from class: io.modelcontextprotocol.server.v
            @Override // java.util.function.Supplier
            public final Object get() {
                return Mono.error(McpError.RESOURCE_NOT_FOUND.apply(str));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$resourcesReadRequestHandler$29(final McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
        final McpSchema.ReadResourceRequest readResourceRequest = (McpSchema.ReadResourceRequest) this.jsonMapper.convertValue(obj, new TypeRef<McpSchema.ReadResourceRequest>() { // from class: io.modelcontextprotocol.server.McpAsyncServer.2
        });
        final String strUri = readResourceRequest.uri();
        return (Mono) findResourceSpecification(strUri).map(new Function() { // from class: io.modelcontextprotocol.server.n
            @Override // java.util.function.Function
            public final Object apply(Object obj2) {
                return ((McpServerFeatures.AsyncResourceSpecification) obj2).readHandler().apply(mcpAsyncServerExchange, readResourceRequest);
            }
        }).orElseGet(new Supplier() { // from class: io.modelcontextprotocol.server.y
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f34088a.lambda$resourcesReadRequestHandler$28(strUri, mcpAsyncServerExchange, readResourceRequest);
            }
        });
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
    public /* synthetic */ Mono lambda$setLoggerRequestHandler$38(final McpAsyncServerExchange mcpAsyncServerExchange, final Object obj) {
        return Mono.defer(new Supplier() { // from class: io.modelcontextprotocol.server.r
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f34001a.lambda$setLoggerRequestHandler$37(obj, mcpAsyncServerExchange);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$toolsCallRequestHandler$18(McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
        final McpSchema.CallToolRequest callToolRequest = (McpSchema.CallToolRequest) this.jsonMapper.convertValue(obj, new TypeRef<McpSchema.CallToolRequest>() { // from class: io.modelcontextprotocol.server.McpAsyncServer.1
        });
        Optional<McpServerFeatures.AsyncToolSpecification> optionalFindAny = this.tools.stream().filter(new Predicate() { // from class: io.modelcontextprotocol.server.Q
            @Override // java.util.function.Predicate
            public final boolean test(Object obj2) {
                return callToolRequest.name().equals(((McpServerFeatures.AsyncToolSpecification) obj2).tool().name());
            }
        }).findAny();
        if (!optionalFindAny.isEmpty()) {
            return optionalFindAny.get().callHandler().apply(mcpAsyncServerExchange, callToolRequest);
        }
        return Mono.error(McpError.builder(McpSchema.ErrorCodes.INVALID_PARAMS).message("Unknown tool: invalid_tool_name").data("Tool not found: " + callToolRequest.name()).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$toolsListRequestHandler$16(McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
        return Mono.just(new McpSchema.ListToolsResult(this.tools.stream().map(new C4663k()).toList(), null));
    }

    public static /* synthetic */ qc.b m(Throwable th) {
        logger.error("Error handling roots list change notification", th);
        return Mono.empty();
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
        if (str.equals("ref/resource")) {
            resourceReference = new McpSchema.ResourceReference(str, (String) map2.get("uri"));
        } else {
            if (!str.equals("ref/prompt")) {
                throw new IllegalArgumentException("Invalid ref type: " + str);
            }
            resourceReference = new McpSchema.PromptReference(str, (String) map2.get("name"), map2.get("title") != null ? (String) map2.get("title") : null);
        }
        return new McpSchema.CompleteRequest(resourceReference, new McpSchema.CompleteRequest.CompleteArgument((String) map3.get("name"), (String) map3.get(UxipConstants.f30680s)), map5, map4 != null ? new McpSchema.CompleteRequest.CompleteContext((Map) map4.get("arguments")) : null);
    }

    private Map<String, McpNotificationHandler> prepareNotificationHandlers(McpServerFeatures.Async async) {
        HashMap map = new HashMap();
        map.put(McpSchema.METHOD_NOTIFICATION_INITIALIZED, new McpNotificationHandler() { // from class: io.modelcontextprotocol.server.E
            @Override // io.modelcontextprotocol.server.McpNotificationHandler
            public final Mono handle(McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
                return Mono.empty();
            }
        });
        List<BiFunction<McpAsyncServerExchange, List<McpSchema.Root>, Mono<Void>>> listRootsChangeConsumers = async.rootsChangeConsumers();
        if (Utils.isEmpty(listRootsChangeConsumers)) {
            listRootsChangeConsumers = List.of(new BiFunction() { // from class: io.modelcontextprotocol.server.F
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return Mono.fromRunnable(new Runnable() { // from class: io.modelcontextprotocol.server.U
                        @Override // java.lang.Runnable
                        public final void run() {
                            McpAsyncServer.logger.j("Roots list changed notification, but no consumers provided. Roots list changed: {}", list);
                        }
                    });
                }
            });
        }
        map.put(McpSchema.METHOD_NOTIFICATION_ROOTS_LIST_CHANGED, asyncRootsListChangedNotificationHandler(listRootsChangeConsumers));
        return map;
    }

    private Map<String, McpRequestHandler<?>> prepareRequestHandlers() {
        HashMap map = new HashMap();
        map.put(McpSchema.METHOD_PING, new McpRequestHandler() { // from class: io.modelcontextprotocol.server.P
            @Override // io.modelcontextprotocol.server.McpRequestHandler
            public final Mono handle(McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
                return Mono.just(Collections.EMPTY_MAP);
            }
        });
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
        return new McpRequestHandler() { // from class: io.modelcontextprotocol.server.D
            @Override // io.modelcontextprotocol.server.McpRequestHandler
            public final Mono handle(McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
                return this.f33874a.lambda$promptsGetRequestHandler$36(mcpAsyncServerExchange, obj);
            }
        };
    }

    private McpRequestHandler<McpSchema.ListPromptsResult> promptsListRequestHandler() {
        return new McpRequestHandler() { // from class: io.modelcontextprotocol.server.A
            @Override // io.modelcontextprotocol.server.McpRequestHandler
            public final Mono handle(McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
                return this.f33856a.lambda$promptsListRequestHandler$34(mcpAsyncServerExchange, obj);
            }
        };
    }

    private McpRequestHandler<McpSchema.ListResourceTemplatesResult> resourceTemplateListRequestHandler() {
        return new McpRequestHandler() { // from class: io.modelcontextprotocol.server.c
            @Override // io.modelcontextprotocol.server.McpRequestHandler
            public final Mono handle(McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
                return this.f33942a.lambda$resourceTemplateListRequestHandler$24(mcpAsyncServerExchange, obj);
            }
        };
    }

    private McpRequestHandler<McpSchema.ListResourcesResult> resourcesListRequestHandler() {
        return new McpRequestHandler() { // from class: io.modelcontextprotocol.server.s
            @Override // io.modelcontextprotocol.server.McpRequestHandler
            public final Mono handle(McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
                return this.f34007a.lambda$resourcesListRequestHandler$23(mcpAsyncServerExchange, obj);
            }
        };
    }

    private McpRequestHandler<McpSchema.ReadResourceResult> resourcesReadRequestHandler() {
        return new McpRequestHandler() { // from class: io.modelcontextprotocol.server.f
            @Override // io.modelcontextprotocol.server.McpRequestHandler
            public final Mono handle(McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
                return this.f33951a.lambda$resourcesReadRequestHandler$29(mcpAsyncServerExchange, obj);
            }
        };
    }

    private McpRequestHandler<Object> setLoggerRequestHandler() {
        return new McpRequestHandler() { // from class: io.modelcontextprotocol.server.z
            @Override // io.modelcontextprotocol.server.McpRequestHandler
            public final Mono handle(McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
                return this.f34095a.lambda$setLoggerRequestHandler$38(mcpAsyncServerExchange, obj);
            }
        };
    }

    private McpRequestHandler<McpSchema.CallToolResult> toolsCallRequestHandler() {
        return new McpRequestHandler() { // from class: io.modelcontextprotocol.server.x
            @Override // io.modelcontextprotocol.server.McpRequestHandler
            public final Mono handle(McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
                return this.f34083a.lambda$toolsCallRequestHandler$18(mcpAsyncServerExchange, obj);
            }
        };
    }

    private McpRequestHandler<McpSchema.ListToolsResult> toolsListRequestHandler() {
        return new McpRequestHandler() { // from class: io.modelcontextprotocol.server.e
            @Override // io.modelcontextprotocol.server.McpRequestHandler
            public final Mono handle(McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
                return this.f33948a.lambda$toolsListRequestHandler$16(mcpAsyncServerExchange, obj);
            }
        };
    }

    private static List<McpServerFeatures.AsyncToolSpecification> withStructuredOutputHandling(final JsonSchemaValidator jsonSchemaValidator, List<McpServerFeatures.AsyncToolSpecification> list) {
        return Utils.isEmpty(list) ? list : list.stream().map(new Function() { // from class: io.modelcontextprotocol.server.w
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return McpAsyncServer.withStructuredOutputHandling(jsonSchemaValidator, (McpServerFeatures.AsyncToolSpecification) obj);
            }
        }).toList();
    }

    public Mono<Void> addPrompt(final McpServerFeatures.AsyncPromptSpecification asyncPromptSpecification) {
        return asyncPromptSpecification == null ? Mono.error(new IllegalArgumentException("Prompt specification must not be null")) : this.serverCapabilities.prompts() == null ? Mono.error(new IllegalStateException("Server must be configured with prompt capabilities")) : Mono.defer(new Supplier() { // from class: io.modelcontextprotocol.server.L
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f33892a.lambda$addPrompt$32(asyncPromptSpecification);
            }
        });
    }

    public Mono<Void> addResource(final McpServerFeatures.AsyncResourceSpecification asyncResourceSpecification) {
        return (asyncResourceSpecification == null || asyncResourceSpecification.resource() == null) ? Mono.error(new IllegalArgumentException("Resource must not be null")) : this.serverCapabilities.resources() == null ? Mono.error(new IllegalStateException("Server must be configured with resource capabilities to allow adding resources")) : Mono.defer(new Supplier() { // from class: io.modelcontextprotocol.server.g
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f33954a.lambda$addResource$19(asyncResourceSpecification);
            }
        });
    }

    public Mono<Void> addResourceTemplate(final McpServerFeatures.AsyncResourceTemplateSpecification asyncResourceTemplateSpecification) {
        return this.serverCapabilities.resources() == null ? Mono.error(new IllegalStateException("Server must be configured with resource capabilities to allow adding resource templates")) : Mono.defer(new Supplier() { // from class: io.modelcontextprotocol.server.m
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f33978a.lambda$addResourceTemplate$21(asyncResourceTemplateSpecification);
            }
        });
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
            return Mono.error(new IllegalStateException("Server must be configured with tool capabilities"));
        }
        final McpServerFeatures.AsyncToolSpecification asyncToolSpecificationWithStructuredOutputHandling = withStructuredOutputHandling(this.jsonSchemaValidator, asyncToolSpecification);
        return Mono.defer(new Supplier() { // from class: io.modelcontextprotocol.server.K
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f33886a.lambda$addTool$12(asyncToolSpecificationWithStructuredOutputHandling);
            }
        });
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
        return Flux.fromIterable(this.prompts.values()).map(new C4673p());
    }

    public Flux<McpSchema.ResourceTemplate> listResourceTemplates() {
        return Flux.fromIterable(this.resourceTemplates.values()).map(new Y());
    }

    public Flux<McpSchema.Resource> listResources() {
        return Flux.fromIterable(this.resources.values()).map(new G());
    }

    public Flux<McpSchema.Tool> listTools() {
        return Flux.fromIterable(this.tools).map(new C4663k());
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

    public Mono<Void> removePrompt(final String str) {
        return str == null ? Mono.error(new IllegalArgumentException("Prompt name must not be null")) : this.serverCapabilities.prompts() == null ? Mono.error(new IllegalStateException("Server must be configured with prompt capabilities")) : Mono.defer(new Supplier() { // from class: io.modelcontextprotocol.server.S
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f33910a.lambda$removePrompt$33(str);
            }
        });
    }

    public Mono<Void> removeResource(final String str) {
        return str == null ? Mono.error(new IllegalArgumentException("Resource URI must not be null")) : this.serverCapabilities.resources() == null ? Mono.error(new IllegalStateException("Server must be configured with resource capabilities to allow removing resources")) : Mono.defer(new Supplier() { // from class: io.modelcontextprotocol.server.B
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f33863a.lambda$removeResource$20(str);
            }
        });
    }

    public Mono<Void> removeResourceTemplate(final String str) {
        return this.serverCapabilities.resources() == null ? Mono.error(new IllegalStateException("Server must be configured with resource capabilities to allow removing resource templates")) : Mono.defer(new Supplier() { // from class: io.modelcontextprotocol.server.M
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f33894a.lambda$removeResourceTemplate$22(str);
            }
        });
    }

    public Mono<Void> removeTool(final String str) {
        return str == null ? Mono.error(new IllegalArgumentException("Tool name must not be null")) : this.serverCapabilities.tools() == null ? Mono.error(new IllegalStateException("Server must be configured with tool capabilities")) : Mono.defer(new Supplier() { // from class: io.modelcontextprotocol.server.h
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f33958a.lambda$removeTool$15(str);
            }
        });
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
        mcpStreamableServerTransportProvider.setSessionFactory(new DefaultMcpStreamableServerSessionFactory(duration, new McpStreamableServerSession.InitRequestHandler() { // from class: io.modelcontextprotocol.server.t
            @Override // io.modelcontextprotocol.spec.McpStreamableServerSession.InitRequestHandler
            public final Mono handle(McpSchema.InitializeRequest initializeRequest) {
                return this.f34013a.asyncInitializeRequestHandler(initializeRequest);
            }
        }, mapPrepareRequestHandlers, mapPrepareNotificationHandlers));
    }
}
