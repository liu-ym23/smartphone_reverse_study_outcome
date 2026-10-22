package io.modelcontextprotocol.server;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.modelcontextprotocol.common.McpTransportContext;
import io.modelcontextprotocol.json.McpJsonMapper;
import io.modelcontextprotocol.json.TypeRef;
import io.modelcontextprotocol.json.schema.JsonSchemaValidator;
import io.modelcontextprotocol.server.McpStatelessServerFeatures;
import io.modelcontextprotocol.spec.McpError;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpStatelessServerTransport;
import io.modelcontextprotocol.util.Assert;
import io.modelcontextprotocol.util.DefaultMcpUriTemplateManagerFactory;
import io.modelcontextprotocol.util.McpUriTemplateManagerFactory;
import io.modelcontextprotocol.util.Utils;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/* loaded from: classes4.dex */
public class McpStatelessAsyncServer {
    private final ConcurrentHashMap<McpSchema.CompleteReference, McpStatelessServerFeatures.AsyncCompletionSpecification> completions;
    private final String instructions;
    private final McpJsonMapper jsonMapper;
    private final JsonSchemaValidator jsonSchemaValidator;
    private final McpStatelessServerTransport mcpTransportProvider;
    private final ConcurrentHashMap<String, McpStatelessServerFeatures.AsyncPromptSpecification> prompts;
    private List<String> protocolVersions;
    private final ConcurrentHashMap<String, McpStatelessServerFeatures.AsyncResourceTemplateSpecification> resourceTemplates;
    private final ConcurrentHashMap<String, McpStatelessServerFeatures.AsyncResourceSpecification> resources;
    private final McpSchema.ServerCapabilities serverCapabilities;
    private final McpSchema.Implementation serverInfo;
    private final CopyOnWriteArrayList<McpStatelessServerFeatures.AsyncToolSpecification> tools;
    private McpUriTemplateManagerFactory uriTemplateManagerFactory;
    private static final vc.c logger = vc.e.l(McpStatelessAsyncServer.class);
    private static final Mono<McpSchema.CompleteResult> EMPTY_COMPLETION_RESULT = Mono.just(new McpSchema.CompleteResult(new McpSchema.CompleteResult.CompleteCompletion(Collections.EMPTY_LIST, 0, Boolean.FALSE)));

    public static class StructuredOutputCallToolHandler implements BiFunction<McpTransportContext, McpSchema.CallToolRequest, Mono<McpSchema.CallToolResult>> {
        private final BiFunction<McpTransportContext, McpSchema.CallToolRequest, Mono<McpSchema.CallToolResult>> delegateHandler;
        private final JsonSchemaValidator jsonSchemaValidator;
        private final Map<String, Object> outputSchema;

        public StructuredOutputCallToolHandler(JsonSchemaValidator jsonSchemaValidator, Map<String, Object> map, BiFunction<McpTransportContext, McpSchema.CallToolRequest, Mono<McpSchema.CallToolResult>> biFunction) {
            Assert.notNull(jsonSchemaValidator, "JsonSchemaValidator must not be null");
            Assert.notNull(biFunction, "Delegate call tool result handler must not be null");
            this.delegateHandler = biFunction;
            this.outputSchema = map;
            this.jsonSchemaValidator = jsonSchemaValidator;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ McpSchema.CallToolResult lambda$apply$0(McpSchema.CallToolResult callToolResult) {
            Boolean bool = Boolean.TRUE;
            if (!bool.equals(callToolResult.isError())) {
                if (this.outputSchema == null) {
                    if (callToolResult.structuredContent() != null) {
                        McpStatelessAsyncServer.logger.j("Tool call with no outputSchema is not expected to have a result with structured content, but got: {}", callToolResult.structuredContent());
                        return callToolResult;
                    }
                } else {
                    if (callToolResult.structuredContent() == null) {
                        McpStatelessAsyncServer.logger.warn("Response missing structured content which is expected when calling tool with non-empty outputSchema");
                        return new McpSchema.CallToolResult("Response missing structured content which is expected when calling tool with non-empty outputSchema", bool);
                    }
                    JsonSchemaValidator.ValidationResponse validationResponseValidate = this.jsonSchemaValidator.validate(this.outputSchema, callToolResult.structuredContent());
                    if (!validationResponseValidate.valid()) {
                        McpStatelessAsyncServer.logger.j("Tool call result validation failed: {}", validationResponseValidate.errorMessage());
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
        public Mono<McpSchema.CallToolResult> apply(McpTransportContext mcpTransportContext, McpSchema.CallToolRequest callToolRequest) {
            return this.delegateHandler.apply(mcpTransportContext, callToolRequest).map(new Function() { // from class: io.modelcontextprotocol.server.m1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.f33982a.lambda$apply$0((McpSchema.CallToolResult) obj);
                }
            });
        }
    }

    public McpStatelessAsyncServer(McpStatelessServerTransport mcpStatelessServerTransport, McpJsonMapper mcpJsonMapper, McpStatelessServerFeatures.Async async, Duration duration, McpUriTemplateManagerFactory mcpUriTemplateManagerFactory, JsonSchemaValidator jsonSchemaValidator) {
        CopyOnWriteArrayList<McpStatelessServerFeatures.AsyncToolSpecification> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        this.tools = copyOnWriteArrayList;
        ConcurrentHashMap<String, McpStatelessServerFeatures.AsyncResourceTemplateSpecification> concurrentHashMap = new ConcurrentHashMap<>();
        this.resourceTemplates = concurrentHashMap;
        ConcurrentHashMap<String, McpStatelessServerFeatures.AsyncResourceSpecification> concurrentHashMap2 = new ConcurrentHashMap<>();
        this.resources = concurrentHashMap2;
        ConcurrentHashMap<String, McpStatelessServerFeatures.AsyncPromptSpecification> concurrentHashMap3 = new ConcurrentHashMap<>();
        this.prompts = concurrentHashMap3;
        ConcurrentHashMap<McpSchema.CompleteReference, McpStatelessServerFeatures.AsyncCompletionSpecification> concurrentHashMap4 = new ConcurrentHashMap<>();
        this.completions = concurrentHashMap4;
        this.uriTemplateManagerFactory = new DefaultMcpUriTemplateManagerFactory();
        this.mcpTransportProvider = mcpStatelessServerTransport;
        this.jsonMapper = mcpJsonMapper;
        this.serverInfo = async.serverInfo();
        McpSchema.ServerCapabilities serverCapabilities = async.serverCapabilities();
        this.serverCapabilities = serverCapabilities;
        this.instructions = async.instructions();
        copyOnWriteArrayList.addAll(withStructuredOutputHandling(jsonSchemaValidator, async.tools()));
        concurrentHashMap2.putAll(async.resources());
        concurrentHashMap.putAll(async.resourceTemplates());
        concurrentHashMap3.putAll(async.prompts());
        concurrentHashMap4.putAll(async.completions());
        this.uriTemplateManagerFactory = mcpUriTemplateManagerFactory;
        this.jsonSchemaValidator = jsonSchemaValidator;
        HashMap map = new HashMap();
        map.put(McpSchema.METHOD_PING, new McpStatelessRequestHandler() { // from class: io.modelcontextprotocol.server.Y0
            @Override // io.modelcontextprotocol.server.McpStatelessRequestHandler
            public final Mono handle(McpTransportContext mcpTransportContext, Object obj) {
                return Mono.just(Collections.EMPTY_MAP);
            }
        });
        map.put(McpSchema.METHOD_INITIALIZE, asyncInitializeRequestHandler());
        if (serverCapabilities.tools() != null) {
            map.put(McpSchema.METHOD_TOOLS_LIST, toolsListRequestHandler());
            map.put(McpSchema.METHOD_TOOLS_CALL, toolsCallRequestHandler());
        }
        if (serverCapabilities.resources() != null) {
            map.put(McpSchema.METHOD_RESOURCES_LIST, resourcesListRequestHandler());
            map.put(McpSchema.METHOD_RESOURCES_READ, resourcesReadRequestHandler());
            map.put(McpSchema.METHOD_RESOURCES_TEMPLATES_LIST, resourceTemplateListRequestHandler());
        }
        if (serverCapabilities.prompts() != null) {
            map.put(McpSchema.METHOD_PROMPT_LIST, promptsListRequestHandler());
            map.put(McpSchema.METHOD_PROMPT_GET, promptsGetRequestHandler());
        }
        if (serverCapabilities.completions() != null) {
            map.put(McpSchema.METHOD_COMPLETION_COMPLETE, completionCompleteRequestHandler());
        }
        this.protocolVersions = new ArrayList(mcpStatelessServerTransport.protocolVersions());
        mcpStatelessServerTransport.setMcpHandler(new DefaultMcpStatelessServerHandler(map, Collections.EMPTY_MAP));
    }

    private McpStatelessRequestHandler<McpSchema.InitializeResult> asyncInitializeRequestHandler() {
        return new McpStatelessRequestHandler() { // from class: io.modelcontextprotocol.server.d1
            @Override // io.modelcontextprotocol.server.McpStatelessRequestHandler
            public final Mono handle(McpTransportContext mcpTransportContext, Object obj) {
                return this.f33947a.lambda$asyncInitializeRequestHandler$2(mcpTransportContext, obj);
            }
        };
    }

    private McpStatelessRequestHandler<McpSchema.CompleteResult> completionCompleteRequestHandler() {
        return new McpStatelessRequestHandler() { // from class: io.modelcontextprotocol.server.F0
            @Override // io.modelcontextprotocol.server.McpStatelessRequestHandler
            public final Mono handle(McpTransportContext mcpTransportContext, Object obj) {
                return this.f33876a.lambda$completionCompleteRequestHandler$29(mcpTransportContext, obj);
            }
        };
    }

    private Optional<McpStatelessServerFeatures.AsyncResourceSpecification> findResourceSpecification(final String str) {
        return this.resources.values().stream().filter(new Predicate() { // from class: io.modelcontextprotocol.server.Z0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return this.f33933a.lambda$findResourceSpecification$22(str, (McpStatelessServerFeatures.AsyncResourceSpecification) obj);
            }
        }).findFirst();
    }

    private Optional<McpStatelessServerFeatures.AsyncResourceTemplateSpecification> findResourceTemplateSpecification(final String str) {
        return this.resourceTemplates.values().stream().filter(new Predicate() { // from class: io.modelcontextprotocol.server.V0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return this.f33922a.lambda$findResourceTemplateSpecification$23(str, (McpStatelessServerFeatures.AsyncResourceTemplateSpecification) obj);
            }
        }).findFirst();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$addPrompt$24(McpStatelessServerFeatures.AsyncPromptSpecification asyncPromptSpecification) {
        if (this.prompts.put(asyncPromptSpecification.prompt().name(), asyncPromptSpecification) != null) {
            logger.j("Replace existing Prompt with name '{}'", asyncPromptSpecification.prompt().name());
        } else {
            logger.t("Added prompt handler: {}", asyncPromptSpecification.prompt().name());
        }
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$addResource$11(McpStatelessServerFeatures.AsyncResourceSpecification asyncResourceSpecification) {
        if (this.resources.put(asyncResourceSpecification.resource().uri(), asyncResourceSpecification) != null) {
            logger.j("Replace existing Resource with URI '{}'", asyncResourceSpecification.resource().uri());
        } else {
            logger.t("Added resource handler: {}", asyncResourceSpecification.resource().uri());
        }
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$addResourceTemplate$13(McpStatelessServerFeatures.AsyncResourceTemplateSpecification asyncResourceTemplateSpecification) {
        if (this.resourceTemplates.put(asyncResourceTemplateSpecification.resourceTemplate().uriTemplate(), asyncResourceTemplateSpecification) != null) {
            logger.j("Replace existing Resource Template with URI '{}'", asyncResourceTemplateSpecification.resourceTemplate().uriTemplate());
        } else {
            logger.t("Added resource template handler: {}", asyncResourceTemplateSpecification.resourceTemplate().uriTemplate());
        }
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$addTool$5(final McpStatelessServerFeatures.AsyncToolSpecification asyncToolSpecification) {
        if (this.tools.removeIf(new Predicate() { // from class: io.modelcontextprotocol.server.H0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((McpStatelessServerFeatures.AsyncToolSpecification) obj).tool().name().equals(asyncToolSpecification.tool().name());
            }
        })) {
            logger.j("Replace existing Tool with name '{}'", asyncToolSpecification.tool().name());
        }
        this.tools.add(asyncToolSpecification);
        logger.t("Added tool handler: {}", asyncToolSpecification.tool().name());
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$asyncInitializeRequestHandler$1(Object obj) {
        McpSchema.InitializeRequest initializeRequest = (McpSchema.InitializeRequest) this.jsonMapper.convertValue(obj, McpSchema.InitializeRequest.class);
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
    public /* synthetic */ Mono lambda$asyncInitializeRequestHandler$2(McpTransportContext mcpTransportContext, final Object obj) {
        return Mono.defer(new Supplier() { // from class: io.modelcontextprotocol.server.M0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f33896a.lambda$asyncInitializeRequestHandler$1(obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$completionCompleteRequestHandler$29(McpTransportContext mcpTransportContext, Object obj) {
        McpSchema.CompleteRequest completionParams = parseCompletionParams(obj);
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
                McpStatelessServerFeatures.AsyncPromptSpecification asyncPromptSpecification = this.prompts.get(promptReference.name());
                if (asyncPromptSpecification == null) {
                    return Mono.error(McpError.builder(McpSchema.ErrorCodes.INVALID_PARAMS).message("Prompt not found: " + promptReference.name()).build());
                }
                if (!asyncPromptSpecification.prompt().arguments().stream().filter(new Predicate() { // from class: io.modelcontextprotocol.server.R0
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
                McpStatelessServerFeatures.AsyncResourceSpecification asyncResourceSpecificationOrElse = findResourceSpecification(resourceReference.uri()).orElse(null);
                if (asyncResourceSpecificationOrElse == null) {
                    McpStatelessServerFeatures.AsyncResourceTemplateSpecification asyncResourceTemplateSpecificationOrElse = findResourceTemplateSpecification(resourceReference.uri()).orElse(null);
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
        McpStatelessServerFeatures.AsyncCompletionSpecification asyncCompletionSpecification = this.completions.get(completionParams.ref());
        if (asyncCompletionSpecification != null) {
            return asyncCompletionSpecification.completionHandler().apply(mcpTransportContext, completionParams);
        }
        return Mono.error(McpError.builder(McpSchema.ErrorCodes.INVALID_PARAMS).message("AsyncCompletionSpecification not found: " + String.valueOf(completionParams.ref())).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$findResourceSpecification$22(String str, McpStatelessServerFeatures.AsyncResourceSpecification asyncResourceSpecification) {
        return this.uriTemplateManagerFactory.create(asyncResourceSpecification.resource().uri()).matches(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$findResourceTemplateSpecification$23(String str, McpStatelessServerFeatures.AsyncResourceTemplateSpecification asyncResourceTemplateSpecification) {
        return this.uriTemplateManagerFactory.create(asyncResourceTemplateSpecification.resourceTemplate().uriTemplate()).matches(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$promptsGetRequestHandler$27(McpTransportContext mcpTransportContext, Object obj) {
        McpSchema.GetPromptRequest getPromptRequest = (McpSchema.GetPromptRequest) this.jsonMapper.convertValue(obj, new TypeRef<McpSchema.GetPromptRequest>() { // from class: io.modelcontextprotocol.server.McpStatelessAsyncServer.3
        });
        McpStatelessServerFeatures.AsyncPromptSpecification asyncPromptSpecification = this.prompts.get(getPromptRequest.name());
        if (asyncPromptSpecification != null) {
            return asyncPromptSpecification.promptHandler().apply(mcpTransportContext, getPromptRequest);
        }
        return Mono.error(McpError.builder(McpSchema.ErrorCodes.INVALID_PARAMS).message("Invalid prompt name").data("Prompt not found: " + getPromptRequest.name()).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$promptsListRequestHandler$26(McpTransportContext mcpTransportContext, Object obj) {
        return Mono.just(new McpSchema.ListPromptsResult(this.prompts.values().stream().map(new j1()).toList(), null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$removePrompt$25(String str) {
        if (this.prompts.remove(str) != null) {
            logger.t("Removed prompt handler: {}", str);
            return Mono.empty();
        }
        logger.j("Ignore as a Prompt with name '{}' not found", str);
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$removeResource$12(String str) {
        if (this.resources.remove(str) != null) {
            logger.t("Removed resource handler: {}", str);
        } else {
            logger.j("Resource with URI '{}' not found", str);
        }
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$removeResourceTemplate$14(String str) {
        if (this.resourceTemplates.remove(str) != null) {
            logger.t("Removed resource template: {}", str);
        } else {
            logger.j("Ignore as a Resource Template with URI '{}' not found", str);
        }
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$removeTool$7(final String str) {
        if (this.tools.removeIf(new Predicate() { // from class: io.modelcontextprotocol.server.f1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((McpStatelessServerFeatures.AsyncToolSpecification) obj).tool().name().equals(str);
            }
        })) {
            logger.t("Removed tool handler: {}", str);
        } else {
            logger.j("Ignore as a Tool with name '{}' not found", str);
        }
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$resourceTemplateListRequestHandler$16(McpTransportContext mcpTransportContext, Object obj) {
        return Mono.just(new McpSchema.ListResourceTemplatesResult(this.resourceTemplates.values().stream().map(new L0()).toList(), null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$resourcesListRequestHandler$15(McpTransportContext mcpTransportContext, Object obj) {
        return Mono.just(new McpSchema.ListResourcesResult(this.resources.values().stream().map(new k1()).toList(), null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$resourcesReadRequestHandler$20(final String str, final McpTransportContext mcpTransportContext, final McpSchema.ReadResourceRequest readResourceRequest) {
        return (Mono) findResourceTemplateSpecification(str).map(new Function() { // from class: io.modelcontextprotocol.server.S0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((McpStatelessServerFeatures.AsyncResourceTemplateSpecification) obj).readHandler().apply(mcpTransportContext, readResourceRequest);
            }
        }).orElseGet(new Supplier() { // from class: io.modelcontextprotocol.server.T0
            @Override // java.util.function.Supplier
            public final Object get() {
                return Mono.error(McpError.RESOURCE_NOT_FOUND.apply(str));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$resourcesReadRequestHandler$21(final McpTransportContext mcpTransportContext, Object obj) {
        final McpSchema.ReadResourceRequest readResourceRequest = (McpSchema.ReadResourceRequest) this.jsonMapper.convertValue(obj, new TypeRef<McpSchema.ReadResourceRequest>() { // from class: io.modelcontextprotocol.server.McpStatelessAsyncServer.2
        });
        final String strUri = readResourceRequest.uri();
        return (Mono) findResourceSpecification(strUri).map(new Function() { // from class: io.modelcontextprotocol.server.J0
            @Override // java.util.function.Function
            public final Object apply(Object obj2) {
                return ((McpStatelessServerFeatures.AsyncResourceSpecification) obj2).readHandler().apply(mcpTransportContext, readResourceRequest);
            }
        }).orElseGet(new Supplier() { // from class: io.modelcontextprotocol.server.K0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f33888a.lambda$resourcesReadRequestHandler$20(strUri, mcpTransportContext, readResourceRequest);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$toolsCallRequestHandler$10(McpTransportContext mcpTransportContext, Object obj) {
        final McpSchema.CallToolRequest callToolRequest = (McpSchema.CallToolRequest) this.jsonMapper.convertValue(obj, new TypeRef<McpSchema.CallToolRequest>() { // from class: io.modelcontextprotocol.server.McpStatelessAsyncServer.1
        });
        Optional<McpStatelessServerFeatures.AsyncToolSpecification> optionalFindAny = this.tools.stream().filter(new Predicate() { // from class: io.modelcontextprotocol.server.l1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj2) {
                return callToolRequest.name().equals(((McpStatelessServerFeatures.AsyncToolSpecification) obj2).tool().name());
            }
        }).findAny();
        if (!optionalFindAny.isEmpty()) {
            return optionalFindAny.get().callHandler().apply(mcpTransportContext, callToolRequest);
        }
        return Mono.error(McpError.builder(McpSchema.ErrorCodes.INVALID_PARAMS).message("Unknown tool: invalid_tool_name").data("Tool not found: " + callToolRequest.name()).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$toolsListRequestHandler$8(McpTransportContext mcpTransportContext, Object obj) {
        return Mono.just(new McpSchema.ListToolsResult(this.tools.stream().map(new E0()).toList(), null));
    }

    private McpSchema.CompleteRequest parseCompletionParams(Object obj) {
        McpSchema.CompleteReference resourceReference;
        Map map = (Map) obj;
        Map map2 = (Map) map.get("ref");
        Map map3 = (Map) map.get("argument");
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
        return new McpSchema.CompleteRequest(resourceReference, new McpSchema.CompleteRequest.CompleteArgument((String) map3.get("name"), (String) map3.get(UxipConstants.f30680s)));
    }

    private McpStatelessRequestHandler<McpSchema.GetPromptResult> promptsGetRequestHandler() {
        return new McpStatelessRequestHandler() { // from class: io.modelcontextprotocol.server.c1
            @Override // io.modelcontextprotocol.server.McpStatelessRequestHandler
            public final Mono handle(McpTransportContext mcpTransportContext, Object obj) {
                return this.f33943a.lambda$promptsGetRequestHandler$27(mcpTransportContext, obj);
            }
        };
    }

    private McpStatelessRequestHandler<McpSchema.ListPromptsResult> promptsListRequestHandler() {
        return new McpStatelessRequestHandler() { // from class: io.modelcontextprotocol.server.G0
            @Override // io.modelcontextprotocol.server.McpStatelessRequestHandler
            public final Mono handle(McpTransportContext mcpTransportContext, Object obj) {
                return this.f33877a.lambda$promptsListRequestHandler$26(mcpTransportContext, obj);
            }
        };
    }

    private McpStatelessRequestHandler<McpSchema.ListResourceTemplatesResult> resourceTemplateListRequestHandler() {
        return new McpStatelessRequestHandler() { // from class: io.modelcontextprotocol.server.I0
            @Override // io.modelcontextprotocol.server.McpStatelessRequestHandler
            public final Mono handle(McpTransportContext mcpTransportContext, Object obj) {
                return this.f33882a.lambda$resourceTemplateListRequestHandler$16(mcpTransportContext, obj);
            }
        };
    }

    private McpStatelessRequestHandler<McpSchema.ListResourcesResult> resourcesListRequestHandler() {
        return new McpStatelessRequestHandler() { // from class: io.modelcontextprotocol.server.h1
            @Override // io.modelcontextprotocol.server.McpStatelessRequestHandler
            public final Mono handle(McpTransportContext mcpTransportContext, Object obj) {
                return this.f33961a.lambda$resourcesListRequestHandler$15(mcpTransportContext, obj);
            }
        };
    }

    private McpStatelessRequestHandler<McpSchema.ReadResourceResult> resourcesReadRequestHandler() {
        return new McpStatelessRequestHandler() { // from class: io.modelcontextprotocol.server.P0
            @Override // io.modelcontextprotocol.server.McpStatelessRequestHandler
            public final Mono handle(McpTransportContext mcpTransportContext, Object obj) {
                return this.f33906a.lambda$resourcesReadRequestHandler$21(mcpTransportContext, obj);
            }
        };
    }

    private McpStatelessRequestHandler<McpSchema.CallToolResult> toolsCallRequestHandler() {
        return new McpStatelessRequestHandler() { // from class: io.modelcontextprotocol.server.g1
            @Override // io.modelcontextprotocol.server.McpStatelessRequestHandler
            public final Mono handle(McpTransportContext mcpTransportContext, Object obj) {
                return this.f33957a.lambda$toolsCallRequestHandler$10(mcpTransportContext, obj);
            }
        };
    }

    private McpStatelessRequestHandler<McpSchema.ListToolsResult> toolsListRequestHandler() {
        return new McpStatelessRequestHandler() { // from class: io.modelcontextprotocol.server.Q0
            @Override // io.modelcontextprotocol.server.McpStatelessRequestHandler
            public final Mono handle(McpTransportContext mcpTransportContext, Object obj) {
                return this.f33908a.lambda$toolsListRequestHandler$8(mcpTransportContext, obj);
            }
        };
    }

    private static List<McpStatelessServerFeatures.AsyncToolSpecification> withStructuredOutputHandling(final JsonSchemaValidator jsonSchemaValidator, List<McpStatelessServerFeatures.AsyncToolSpecification> list) {
        return Utils.isEmpty(list) ? list : list.stream().map(new Function() { // from class: io.modelcontextprotocol.server.e1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return McpStatelessAsyncServer.withStructuredOutputHandling(jsonSchemaValidator, (McpStatelessServerFeatures.AsyncToolSpecification) obj);
            }
        }).toList();
    }

    public Mono<Void> addPrompt(final McpStatelessServerFeatures.AsyncPromptSpecification asyncPromptSpecification) {
        return asyncPromptSpecification == null ? Mono.error(new IllegalArgumentException("Prompt specification must not be null")) : this.serverCapabilities.prompts() == null ? Mono.error(new IllegalStateException("Server must be configured with prompt capabilities")) : Mono.defer(new Supplier() { // from class: io.modelcontextprotocol.server.O0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f33904a.lambda$addPrompt$24(asyncPromptSpecification);
            }
        });
    }

    public Mono<Void> addResource(final McpStatelessServerFeatures.AsyncResourceSpecification asyncResourceSpecification) {
        return (asyncResourceSpecification == null || asyncResourceSpecification.resource() == null) ? Mono.error(new IllegalArgumentException("Resource must not be null")) : this.serverCapabilities.resources() == null ? Mono.error(new IllegalStateException("Server must be configured with resource capabilities")) : Mono.defer(new Supplier() { // from class: io.modelcontextprotocol.server.W0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f33925a.lambda$addResource$11(asyncResourceSpecification);
            }
        });
    }

    public Mono<Void> addResourceTemplate(final McpStatelessServerFeatures.AsyncResourceTemplateSpecification asyncResourceTemplateSpecification) {
        return this.serverCapabilities.resources() == null ? Mono.error(new IllegalStateException("Server must be configured with resource capabilities to allow adding resource templates")) : Mono.defer(new Supplier() { // from class: io.modelcontextprotocol.server.a1
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f33937a.lambda$addResourceTemplate$13(asyncResourceTemplateSpecification);
            }
        });
    }

    public Mono<Void> addTool(McpStatelessServerFeatures.AsyncToolSpecification asyncToolSpecification) {
        if (asyncToolSpecification == null) {
            return Mono.error(new IllegalArgumentException("Tool specification must not be null"));
        }
        if (asyncToolSpecification.tool() == null) {
            return Mono.error(new IllegalArgumentException("Tool must not be null"));
        }
        if (asyncToolSpecification.callHandler() == null) {
            return Mono.error(new IllegalArgumentException("Tool call handler must not be null"));
        }
        if (this.serverCapabilities.tools() == null) {
            return Mono.error(new IllegalStateException("Server must be configured with tool capabilities"));
        }
        final McpStatelessServerFeatures.AsyncToolSpecification asyncToolSpecificationWithStructuredOutputHandling = withStructuredOutputHandling(this.jsonSchemaValidator, asyncToolSpecification);
        return Mono.defer(new Supplier() { // from class: io.modelcontextprotocol.server.i1
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f33964a.lambda$addTool$5(asyncToolSpecificationWithStructuredOutputHandling);
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
        return Flux.fromIterable(this.prompts.values()).map(new j1());
    }

    public Flux<McpSchema.ResourceTemplate> listResourceTemplates() {
        return Flux.fromIterable(this.resourceTemplates.values()).map(new L0());
    }

    public Flux<McpSchema.Resource> listResources() {
        return Flux.fromIterable(this.resources.values()).map(new k1());
    }

    public Flux<McpSchema.Tool> listTools() {
        return Flux.fromIterable(this.tools).map(new E0());
    }

    public Mono<Void> removePrompt(final String str) {
        return str == null ? Mono.error(new IllegalArgumentException("Prompt name must not be null")) : this.serverCapabilities.prompts() == null ? Mono.error(new IllegalStateException("Server must be configured with prompt capabilities")) : Mono.defer(new Supplier() { // from class: io.modelcontextprotocol.server.X0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f33930a.lambda$removePrompt$25(str);
            }
        });
    }

    public Mono<Void> removeResource(final String str) {
        return str == null ? Mono.error(new IllegalArgumentException("Resource URI must not be null")) : this.serverCapabilities.resources() == null ? Mono.error(new IllegalStateException("Server must be configured with resource capabilities")) : Mono.defer(new Supplier() { // from class: io.modelcontextprotocol.server.b1
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f33940a.lambda$removeResource$12(str);
            }
        });
    }

    public Mono<Void> removeResourceTemplate(final String str) {
        return this.serverCapabilities.resources() == null ? Mono.error(new IllegalStateException("Server must be configured with resource capabilities to allow removing resource templates")) : Mono.defer(new Supplier() { // from class: io.modelcontextprotocol.server.U0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f33917a.lambda$removeResourceTemplate$14(str);
            }
        });
    }

    public Mono<Void> removeTool(final String str) {
        return str == null ? Mono.error(new IllegalArgumentException("Tool name must not be null")) : this.serverCapabilities.tools() == null ? Mono.error(new IllegalStateException("Server must be configured with tool capabilities")) : Mono.defer(new Supplier() { // from class: io.modelcontextprotocol.server.N0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f33900a.lambda$removeTool$7(str);
            }
        });
    }

    public void setProtocolVersions(List<String> list) {
        this.protocolVersions = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static McpStatelessServerFeatures.AsyncToolSpecification withStructuredOutputHandling(JsonSchemaValidator jsonSchemaValidator, McpStatelessServerFeatures.AsyncToolSpecification asyncToolSpecification) {
        return ((asyncToolSpecification.callHandler() instanceof StructuredOutputCallToolHandler) || asyncToolSpecification.tool().outputSchema() == null) ? asyncToolSpecification : new McpStatelessServerFeatures.AsyncToolSpecification(asyncToolSpecification.tool(), new StructuredOutputCallToolHandler(jsonSchemaValidator, asyncToolSpecification.tool().outputSchema(), asyncToolSpecification.callHandler()));
    }
}
