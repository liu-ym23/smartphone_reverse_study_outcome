package io.modelcontextprotocol.server;

import b8.n0;
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
import java.lang.invoke.VarHandle;
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
import java.util.stream.Stream;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
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
    private static final rd.b logger = rd.d.b(McpStatelessAsyncServer.class);
    private static final Mono<McpSchema.CompleteResult> EMPTY_COMPLETION_RESULT = Mono.just(new McpSchema.CompleteResult(new McpSchema.CompleteResult.CompleteCompletion(Collections.EMPTY_LIST, 0, Boolean.FALSE)));

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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
                        McpStatelessAsyncServer.logger.b(callToolResult.structuredContent(), "Tool call with no outputSchema is not expected to have a result with structured content, but got: {}");
                        return callToolResult;
                    }
                } else {
                    if (callToolResult.structuredContent() == null) {
                        McpStatelessAsyncServer.logger.warn("Response missing structured content which is expected when calling tool with non-empty outputSchema");
                        return new McpSchema.CallToolResult("Response missing structured content which is expected when calling tool with non-empty outputSchema", bool);
                    }
                    JsonSchemaValidator.ValidationResponse validationResponseValidate = this.jsonSchemaValidator.validate(this.outputSchema, callToolResult.structuredContent());
                    if (!validationResponseValidate.valid()) {
                        McpStatelessAsyncServer.logger.b(validationResponseValidate.errorMessage(), "Tool call result validation failed: {}");
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
            Mono<McpSchema.CallToolResult> monoApply = this.delegateHandler.apply(mcpTransportContext, callToolRequest);
            t tVar = new t(1);
            tVar.f6291b = this;
            VarHandle.storeStoreFence();
            return monoApply.map(tVar);
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
        map.put(McpSchema.METHOD_PING, new e0());
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
        a0 a0Var = new a0(6);
        a0Var.f6243b = this;
        VarHandle.storeStoreFence();
        return a0Var;
    }

    private McpStatelessRequestHandler<McpSchema.CompleteResult> completionCompleteRequestHandler() {
        a0 a0Var = new a0(0);
        a0Var.f6243b = this;
        VarHandle.storeStoreFence();
        return a0Var;
    }

    private Optional<McpStatelessServerFeatures.AsyncResourceSpecification> findResourceSpecification(String str) {
        Stream<McpStatelessServerFeatures.AsyncResourceSpecification> stream = this.resources.values().stream();
        d0 d0Var = new d0(1);
        d0Var.f6258f = this;
        d0Var.f6259g = str;
        VarHandle.storeStoreFence();
        return stream.filter(d0Var).findFirst();
    }

    private Optional<McpStatelessServerFeatures.AsyncResourceTemplateSpecification> findResourceTemplateSpecification(String str) {
        Stream<McpStatelessServerFeatures.AsyncResourceTemplateSpecification> stream = this.resourceTemplates.values().stream();
        d0 d0Var = new d0(0);
        d0Var.f6258f = this;
        d0Var.f6259g = str;
        VarHandle.storeStoreFence();
        return stream.filter(d0Var).findFirst();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$addPrompt$24(McpStatelessServerFeatures.AsyncPromptSpecification asyncPromptSpecification) {
        if (this.prompts.put(asyncPromptSpecification.prompt().name(), asyncPromptSpecification) != null) {
            logger.b(asyncPromptSpecification.prompt().name(), "Replace existing Prompt with name '{}'");
        } else {
            logger.h(asyncPromptSpecification.prompt().name(), "Added prompt handler: {}");
        }
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$addResource$11(McpStatelessServerFeatures.AsyncResourceSpecification asyncResourceSpecification) {
        if (this.resources.put(asyncResourceSpecification.resource().uri(), asyncResourceSpecification) != null) {
            logger.b(asyncResourceSpecification.resource().uri(), "Replace existing Resource with URI '{}'");
        } else {
            logger.h(asyncResourceSpecification.resource().uri(), "Added resource handler: {}");
        }
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$addResourceTemplate$13(McpStatelessServerFeatures.AsyncResourceTemplateSpecification asyncResourceTemplateSpecification) {
        if (this.resourceTemplates.put(asyncResourceTemplateSpecification.resourceTemplate().uriTemplate(), asyncResourceTemplateSpecification) != null) {
            logger.b(asyncResourceTemplateSpecification.resourceTemplate().uriTemplate(), "Replace existing Resource Template with URI '{}'");
        } else {
            logger.h(asyncResourceTemplateSpecification.resourceTemplate().uriTemplate(), "Added resource template handler: {}");
        }
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$addTool$4(McpStatelessServerFeatures.AsyncToolSpecification asyncToolSpecification, McpStatelessServerFeatures.AsyncToolSpecification asyncToolSpecification2) {
        return asyncToolSpecification2.tool().name().equals(asyncToolSpecification.tool().name());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$addTool$5(McpStatelessServerFeatures.AsyncToolSpecification asyncToolSpecification) {
        CopyOnWriteArrayList<McpStatelessServerFeatures.AsyncToolSpecification> copyOnWriteArrayList = this.tools;
        c cVar = new c(1);
        cVar.f6250f = asyncToolSpecification;
        VarHandle.storeStoreFence();
        if (copyOnWriteArrayList.removeIf(cVar)) {
            logger.b(asyncToolSpecification.tool().name(), "Replace existing Tool with name '{}'");
        }
        this.tools.add(asyncToolSpecification);
        logger.h(asyncToolSpecification.tool().name(), "Added tool handler: {}");
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$asyncInitializeRequestHandler$1(Object obj) {
        McpSchema.InitializeRequest initializeRequest = (McpSchema.InitializeRequest) this.jsonMapper.convertValue(obj, McpSchema.InitializeRequest.class);
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
    public /* synthetic */ Mono lambda$asyncInitializeRequestHandler$2(McpTransportContext mcpTransportContext, Object obj) {
        n0 n0Var = new n0(7);
        n0Var.f1991f = this;
        n0Var.f1992g = obj;
        VarHandle.storeStoreFence();
        return Mono.defer(n0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$completionCompleteRequestHandler$28(String str, McpSchema.PromptArgument promptArgument) {
        return promptArgument.name().equals(str);
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
        String strName = completionParams.argument().name();
        if (strType.equals(McpSchema.PromptReference.TYPE)) {
            McpSchema.CompleteReference completeReferenceRef = completionParams.ref();
            if (completeReferenceRef instanceof McpSchema.PromptReference) {
                McpSchema.PromptReference promptReference = (McpSchema.PromptReference) completeReferenceRef;
                McpStatelessServerFeatures.AsyncPromptSpecification asyncPromptSpecification = this.prompts.get(promptReference.name());
                if (asyncPromptSpecification == null) {
                    return Mono.error(McpError.builder(McpSchema.ErrorCodes.INVALID_PARAMS).message("Prompt not found: " + promptReference.name()).build());
                }
                Stream<McpSchema.PromptArgument> stream = asyncPromptSpecification.prompt().arguments().stream();
                o oVar = new o(6);
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
        return asyncCompletionSpecification == null ? Mono.error(McpError.builder(McpSchema.ErrorCodes.INVALID_PARAMS).message("AsyncCompletionSpecification not found: ".concat(String.valueOf(completionParams.ref()))).build()) : asyncCompletionSpecification.completionHandler().apply(mcpTransportContext, completionParams);
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
    public static /* synthetic */ Mono lambda$new$0(McpTransportContext mcpTransportContext, Object obj) {
        return Mono.just(Collections.EMPTY_MAP);
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
        return Mono.just(new McpSchema.ListPromptsResult(this.prompts.values().stream().map(new a8.b(18)).toList(), null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$removePrompt$25(String str) {
        if (this.prompts.remove(str) != null) {
            logger.h(str, "Removed prompt handler: {}");
            return Mono.empty();
        }
        logger.b(str, "Ignore as a Prompt with name '{}' not found");
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$removeResource$12(String str) {
        if (this.resources.remove(str) != null) {
            logger.h(str, "Removed resource handler: {}");
        } else {
            logger.b(str, "Resource with URI '{}' not found");
        }
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$removeResourceTemplate$14(String str) {
        if (this.resourceTemplates.remove(str) != null) {
            logger.h(str, "Removed resource template: {}");
        } else {
            logger.b(str, "Ignore as a Resource Template with URI '{}' not found");
        }
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$removeTool$6(String str, McpStatelessServerFeatures.AsyncToolSpecification asyncToolSpecification) {
        return asyncToolSpecification.tool().name().equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$removeTool$7(String str) {
        CopyOnWriteArrayList<McpStatelessServerFeatures.AsyncToolSpecification> copyOnWriteArrayList = this.tools;
        o oVar = new o(7);
        oVar.f6285f = str;
        VarHandle.storeStoreFence();
        if (copyOnWriteArrayList.removeIf(oVar)) {
            logger.h(str, "Removed tool handler: {}");
        } else {
            logger.b(str, "Ignore as a Tool with name '{}' not found");
        }
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$resourceTemplateListRequestHandler$16(McpTransportContext mcpTransportContext, Object obj) {
        return Mono.just(new McpSchema.ListResourceTemplatesResult(this.resourceTemplates.values().stream().map(new a8.b(17)).toList(), null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$resourcesListRequestHandler$15(McpTransportContext mcpTransportContext, Object obj) {
        return Mono.just(new McpSchema.ListResourcesResult(this.resources.values().stream().map(new a8.b(19)).toList(), null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$resourcesReadRequestHandler$17(McpTransportContext mcpTransportContext, McpSchema.ReadResourceRequest readResourceRequest, McpStatelessServerFeatures.AsyncResourceSpecification asyncResourceSpecification) {
        return asyncResourceSpecification.readHandler().apply(mcpTransportContext, readResourceRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$resourcesReadRequestHandler$18(McpTransportContext mcpTransportContext, McpSchema.ReadResourceRequest readResourceRequest, McpStatelessServerFeatures.AsyncResourceTemplateSpecification asyncResourceTemplateSpecification) {
        return asyncResourceTemplateSpecification.readHandler().apply(mcpTransportContext, readResourceRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$resourcesReadRequestHandler$19(String str) {
        return Mono.error(McpError.RESOURCE_NOT_FOUND.apply(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$resourcesReadRequestHandler$20(String str, McpTransportContext mcpTransportContext, McpSchema.ReadResourceRequest readResourceRequest) {
        Optional<McpStatelessServerFeatures.AsyncResourceTemplateSpecification> optionalFindResourceTemplateSpecification = findResourceTemplateSpecification(str);
        int i = 1;
        b0 b0Var = new b0(i);
        b0Var.f6247b = mcpTransportContext;
        b0Var.f6248c = readResourceRequest;
        VarHandle.storeStoreFence();
        Optional<U> map = optionalFindResourceTemplateSpecification.map(b0Var);
        j jVar = new j(i);
        jVar.f6277f = str;
        VarHandle.storeStoreFence();
        return (Mono) map.orElseGet(jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$resourcesReadRequestHandler$21(McpTransportContext mcpTransportContext, Object obj) {
        McpSchema.ReadResourceRequest readResourceRequest = (McpSchema.ReadResourceRequest) this.jsonMapper.convertValue(obj, new TypeRef<McpSchema.ReadResourceRequest>() { // from class: io.modelcontextprotocol.server.McpStatelessAsyncServer.2
        });
        String strUri = readResourceRequest.uri();
        Optional<McpStatelessServerFeatures.AsyncResourceSpecification> optionalFindResourceSpecification = findResourceSpecification(strUri);
        b0 b0Var = new b0(0);
        b0Var.f6247b = mcpTransportContext;
        b0Var.f6248c = readResourceRequest;
        VarHandle.storeStoreFence();
        Optional<U> map = optionalFindResourceSpecification.map(b0Var);
        b8.o oVar = new b8.o(3);
        oVar.f1994f = this;
        oVar.f1995g = strUri;
        oVar.f1996h = mcpTransportContext;
        oVar.i = readResourceRequest;
        VarHandle.storeStoreFence();
        return (Mono) map.orElseGet(oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$toolsCallRequestHandler$10(McpTransportContext mcpTransportContext, Object obj) {
        McpSchema.CallToolRequest callToolRequest = (McpSchema.CallToolRequest) this.jsonMapper.convertValue(obj, new TypeRef<McpSchema.CallToolRequest>() { // from class: io.modelcontextprotocol.server.McpStatelessAsyncServer.1
        });
        Stream<McpStatelessServerFeatures.AsyncToolSpecification> stream = this.tools.stream();
        q qVar = new q(1);
        qVar.f6287f = callToolRequest;
        VarHandle.storeStoreFence();
        Optional<McpStatelessServerFeatures.AsyncToolSpecification> optionalFindAny = stream.filter(qVar).findAny();
        if (!optionalFindAny.isEmpty()) {
            return optionalFindAny.get().callHandler().apply(mcpTransportContext, callToolRequest);
        }
        return Mono.error(McpError.builder(McpSchema.ErrorCodes.INVALID_PARAMS).message("Unknown tool: invalid_tool_name").data("Tool not found: " + callToolRequest.name()).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$toolsCallRequestHandler$9(McpSchema.CallToolRequest callToolRequest, McpStatelessServerFeatures.AsyncToolSpecification asyncToolSpecification) {
        return callToolRequest.name().equals(asyncToolSpecification.tool().name());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$toolsListRequestHandler$8(McpTransportContext mcpTransportContext, Object obj) {
        return Mono.just(new McpSchema.ListToolsResult(this.tools.stream().map(new a8.b(16)).toList(), null));
    }

    private McpSchema.CompleteRequest parseCompletionParams(Object obj) {
        McpSchema.CompleteReference resourceReference;
        Map map = (Map) obj;
        Map map2 = (Map) map.get("ref");
        Map map3 = (Map) map.get("argument");
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
        return new McpSchema.CompleteRequest(resourceReference, new McpSchema.CompleteRequest.CompleteArgument((String) map3.get("name"), (String) map3.get("value")));
    }

    private McpStatelessRequestHandler<McpSchema.GetPromptResult> promptsGetRequestHandler() {
        a0 a0Var = new a0(5);
        a0Var.f6243b = this;
        VarHandle.storeStoreFence();
        return a0Var;
    }

    private McpStatelessRequestHandler<McpSchema.ListPromptsResult> promptsListRequestHandler() {
        a0 a0Var = new a0(1);
        a0Var.f6243b = this;
        VarHandle.storeStoreFence();
        return a0Var;
    }

    private McpStatelessRequestHandler<McpSchema.ListResourceTemplatesResult> resourceTemplateListRequestHandler() {
        a0 a0Var = new a0(2);
        a0Var.f6243b = this;
        VarHandle.storeStoreFence();
        return a0Var;
    }

    private McpStatelessRequestHandler<McpSchema.ListResourcesResult> resourcesListRequestHandler() {
        a0 a0Var = new a0(8);
        a0Var.f6243b = this;
        VarHandle.storeStoreFence();
        return a0Var;
    }

    private McpStatelessRequestHandler<McpSchema.ReadResourceResult> resourcesReadRequestHandler() {
        a0 a0Var = new a0(3);
        a0Var.f6243b = this;
        VarHandle.storeStoreFence();
        return a0Var;
    }

    private McpStatelessRequestHandler<McpSchema.CallToolResult> toolsCallRequestHandler() {
        a0 a0Var = new a0(7);
        a0Var.f6243b = this;
        VarHandle.storeStoreFence();
        return a0Var;
    }

    private McpStatelessRequestHandler<McpSchema.ListToolsResult> toolsListRequestHandler() {
        a0 a0Var = new a0(4);
        a0Var.f6243b = this;
        VarHandle.storeStoreFence();
        return a0Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static McpStatelessServerFeatures.AsyncToolSpecification withStructuredOutputHandling(JsonSchemaValidator jsonSchemaValidator, McpStatelessServerFeatures.AsyncToolSpecification asyncToolSpecification) {
        return ((asyncToolSpecification.callHandler() instanceof StructuredOutputCallToolHandler) || asyncToolSpecification.tool().outputSchema() == null) ? asyncToolSpecification : new McpStatelessServerFeatures.AsyncToolSpecification(asyncToolSpecification.tool(), new StructuredOutputCallToolHandler(jsonSchemaValidator, asyncToolSpecification.tool().outputSchema(), asyncToolSpecification.callHandler()));
    }

    public Mono<Void> addPrompt(McpStatelessServerFeatures.AsyncPromptSpecification asyncPromptSpecification) {
        if (asyncPromptSpecification == null) {
            return Mono.error(new IllegalArgumentException("Prompt specification must not be null"));
        }
        if (this.serverCapabilities.prompts() == null) {
            return androidx.activity.b.q("Server must be configured with prompt capabilities");
        }
        n0 n0Var = new n0(8);
        n0Var.f1991f = this;
        n0Var.f1992g = asyncPromptSpecification;
        VarHandle.storeStoreFence();
        return Mono.defer(n0Var);
    }

    public Mono<Void> addResource(McpStatelessServerFeatures.AsyncResourceSpecification asyncResourceSpecification) {
        if (asyncResourceSpecification == null || asyncResourceSpecification.resource() == null) {
            return Mono.error(new IllegalArgumentException("Resource must not be null"));
        }
        if (this.serverCapabilities.resources() == null) {
            return androidx.activity.b.q("Server must be configured with resource capabilities");
        }
        n0 n0Var = new n0(9);
        n0Var.f1991f = this;
        n0Var.f1992g = asyncResourceSpecification;
        VarHandle.storeStoreFence();
        return Mono.defer(n0Var);
    }

    public Mono<Void> addResourceTemplate(McpStatelessServerFeatures.AsyncResourceTemplateSpecification asyncResourceTemplateSpecification) {
        if (this.serverCapabilities.resources() == null) {
            return androidx.activity.b.q("Server must be configured with resource capabilities to allow adding resource templates");
        }
        n0 n0Var = new n0(10);
        n0Var.f1991f = this;
        n0Var.f1992g = asyncResourceTemplateSpecification;
        VarHandle.storeStoreFence();
        return Mono.defer(n0Var);
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
            return androidx.activity.b.q("Server must be configured with tool capabilities");
        }
        McpStatelessServerFeatures.AsyncToolSpecification asyncToolSpecificationWithStructuredOutputHandling = withStructuredOutputHandling(this.jsonSchemaValidator, asyncToolSpecification);
        n0 n0Var = new n0(11);
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
        return Flux.fromIterable(this.prompts.values()).map(new a8.b(18));
    }

    public Flux<McpSchema.ResourceTemplate> listResourceTemplates() {
        return Flux.fromIterable(this.resourceTemplates.values()).map(new a8.b(17));
    }

    public Flux<McpSchema.Resource> listResources() {
        return Flux.fromIterable(this.resources.values()).map(new a8.b(19));
    }

    public Flux<McpSchema.Tool> listTools() {
        return Flux.fromIterable(this.tools).map(new a8.b(16));
    }

    public Mono<Void> removePrompt(String str) {
        if (str == null) {
            return Mono.error(new IllegalArgumentException("Prompt name must not be null"));
        }
        if (this.serverCapabilities.prompts() == null) {
            return androidx.activity.b.q("Server must be configured with prompt capabilities");
        }
        c0 c0Var = new c0(2);
        c0Var.f6252f = this;
        c0Var.f6253g = str;
        VarHandle.storeStoreFence();
        return Mono.defer(c0Var);
    }

    public Mono<Void> removeResource(String str) {
        if (str == null) {
            return Mono.error(new IllegalArgumentException("Resource URI must not be null"));
        }
        if (this.serverCapabilities.resources() == null) {
            return androidx.activity.b.q("Server must be configured with resource capabilities");
        }
        c0 c0Var = new c0(3);
        c0Var.f6252f = this;
        c0Var.f6253g = str;
        VarHandle.storeStoreFence();
        return Mono.defer(c0Var);
    }

    public Mono<Void> removeResourceTemplate(String str) {
        if (this.serverCapabilities.resources() == null) {
            return androidx.activity.b.q("Server must be configured with resource capabilities to allow removing resource templates");
        }
        c0 c0Var = new c0(1);
        c0Var.f6252f = this;
        c0Var.f6253g = str;
        VarHandle.storeStoreFence();
        return Mono.defer(c0Var);
    }

    public Mono<Void> removeTool(String str) {
        if (str == null) {
            return Mono.error(new IllegalArgumentException("Tool name must not be null"));
        }
        if (this.serverCapabilities.tools() == null) {
            return androidx.activity.b.q("Server must be configured with tool capabilities");
        }
        c0 c0Var = new c0(0);
        c0Var.f6252f = this;
        c0Var.f6253g = str;
        VarHandle.storeStoreFence();
        return Mono.defer(c0Var);
    }

    public void setProtocolVersions(List<String> list) {
        this.protocolVersions = list;
    }

    private static List<McpStatelessServerFeatures.AsyncToolSpecification> withStructuredOutputHandling(JsonSchemaValidator jsonSchemaValidator, List<McpStatelessServerFeatures.AsyncToolSpecification> list) {
        if (Utils.isEmpty(list)) {
            return list;
        }
        Stream<McpStatelessServerFeatures.AsyncToolSpecification> stream = list.stream();
        k kVar = new k(1);
        kVar.f6279b = jsonSchemaValidator;
        VarHandle.storeStoreFence();
        return stream.map(kVar).toList();
    }
}
