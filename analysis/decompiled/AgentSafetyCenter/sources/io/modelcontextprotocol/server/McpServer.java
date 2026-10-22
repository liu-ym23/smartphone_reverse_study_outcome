package io.modelcontextprotocol.server;

import io.modelcontextprotocol.common.McpTransportContext;
import io.modelcontextprotocol.json.McpJsonMapper;
import io.modelcontextprotocol.json.schema.JsonSchemaValidator;
import io.modelcontextprotocol.server.McpServerFeatures;
import io.modelcontextprotocol.server.McpStatelessServerFeatures;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpServerTransportProvider;
import io.modelcontextprotocol.spec.McpStatelessServerTransport;
import io.modelcontextprotocol.spec.McpStreamableServerTransportProvider;
import io.modelcontextprotocol.util.Assert;
import io.modelcontextprotocol.util.DefaultMcpUriTemplateManagerFactory;
import io.modelcontextprotocol.util.McpUriTemplateManagerFactory;
import java.lang.invoke.VarHandle;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.stream.Stream;
import reactor.core.publisher.Mono;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface McpServer {
    public static final McpSchema.Implementation DEFAULT_SERVER_INFO = new McpSchema.Implementation("Java SDK MCP Server", "0.15.0");

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class StreamableServerAsyncSpecification extends AsyncSpecification<StreamableServerAsyncSpecification> {
        private final McpStreamableServerTransportProvider transportProvider;

        public StreamableServerAsyncSpecification(McpStreamableServerTransportProvider mcpStreamableServerTransportProvider) {
            this.transportProvider = mcpStreamableServerTransportProvider;
        }

        @Override // io.modelcontextprotocol.server.McpServer.AsyncSpecification
        public McpAsyncServer build() {
            McpServerFeatures.Async async = new McpServerFeatures.Async(this.serverInfo, this.serverCapabilities, this.tools, this.resources, this.resourceTemplates, this.prompts, this.completions, this.rootsChangeHandlers, this.instructions);
            JsonSchemaValidator jsonSchemaValidator = this.jsonSchemaValidator;
            if (jsonSchemaValidator == null) {
                jsonSchemaValidator = JsonSchemaValidator.getDefault();
            }
            JsonSchemaValidator jsonSchemaValidator2 = jsonSchemaValidator;
            McpStreamableServerTransportProvider mcpStreamableServerTransportProvider = this.transportProvider;
            McpJsonMapper mcpJsonMapper = this.jsonMapper;
            if (mcpJsonMapper == null) {
                mcpJsonMapper = McpJsonMapper.getDefault();
            }
            return new McpAsyncServer(mcpStreamableServerTransportProvider, mcpJsonMapper, async, this.requestTimeout, this.uriTemplateManagerFactory, jsonSchemaValidator2);
        }
    }

    static AsyncSpecification<?> async(McpServerTransportProvider mcpServerTransportProvider) {
        return new SingleSessionAsyncSpecification(mcpServerTransportProvider, 0);
    }

    static SingleSessionSyncSpecification sync(McpServerTransportProvider mcpServerTransportProvider) {
        return new SingleSessionSyncSpecification(mcpServerTransportProvider, 0);
    }

    static AsyncSpecification<?> async(McpStreamableServerTransportProvider mcpStreamableServerTransportProvider) {
        return new StreamableServerAsyncSpecification(mcpStreamableServerTransportProvider);
    }

    static StreamableSyncSpecification sync(McpStreamableServerTransportProvider mcpStreamableServerTransportProvider) {
        return new StreamableSyncSpecification(mcpStreamableServerTransportProvider, 0);
    }

    static StatelessAsyncSpecification async(McpStatelessServerTransport mcpStatelessServerTransport) {
        return new StatelessAsyncSpecification(mcpStatelessServerTransport);
    }

    static StatelessSyncSpecification sync(McpStatelessServerTransport mcpStatelessServerTransport) {
        return new StatelessSyncSpecification(mcpStatelessServerTransport);
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class SingleSessionAsyncSpecification extends AsyncSpecification<SingleSessionAsyncSpecification> {
        private final McpServerTransportProvider transportProvider;

        private SingleSessionAsyncSpecification(McpServerTransportProvider mcpServerTransportProvider) {
            Assert.notNull(mcpServerTransportProvider, "Transport provider must not be null");
            this.transportProvider = mcpServerTransportProvider;
        }

        @Override // io.modelcontextprotocol.server.McpServer.AsyncSpecification
        public McpAsyncServer build() {
            McpServerFeatures.Async async = new McpServerFeatures.Async(this.serverInfo, this.serverCapabilities, this.tools, this.resources, this.resourceTemplates, this.prompts, this.completions, this.rootsChangeHandlers, this.instructions);
            JsonSchemaValidator jsonSchemaValidator = this.jsonSchemaValidator;
            if (jsonSchemaValidator == null) {
                jsonSchemaValidator = JsonSchemaValidator.getDefault();
            }
            JsonSchemaValidator jsonSchemaValidator2 = jsonSchemaValidator;
            McpServerTransportProvider mcpServerTransportProvider = this.transportProvider;
            McpJsonMapper mcpJsonMapper = this.jsonMapper;
            if (mcpJsonMapper == null) {
                mcpJsonMapper = McpJsonMapper.getDefault();
            }
            return new McpAsyncServer(mcpServerTransportProvider, mcpJsonMapper, async, this.requestTimeout, this.uriTemplateManagerFactory, jsonSchemaValidator2);
        }

        public /* synthetic */ SingleSessionAsyncSpecification(McpServerTransportProvider mcpServerTransportProvider, int i) {
            this(mcpServerTransportProvider);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class SingleSessionSyncSpecification extends SyncSpecification<SingleSessionSyncSpecification> {
        private final McpServerTransportProvider transportProvider;

        private SingleSessionSyncSpecification(McpServerTransportProvider mcpServerTransportProvider) {
            Assert.notNull(mcpServerTransportProvider, "Transport provider must not be null");
            this.transportProvider = mcpServerTransportProvider;
        }

        @Override // io.modelcontextprotocol.server.McpServer.SyncSpecification
        public McpSyncServer build() {
            McpServerFeatures.Async asyncFromSync = McpServerFeatures.Async.fromSync(new McpServerFeatures.Sync(this.serverInfo, this.serverCapabilities, this.tools, this.resources, this.resourceTemplates, this.prompts, this.completions, this.rootsChangeHandlers, this.instructions), this.immediateExecution);
            McpServerTransportProvider mcpServerTransportProvider = this.transportProvider;
            McpJsonMapper mcpJsonMapper = this.jsonMapper;
            if (mcpJsonMapper == null) {
                mcpJsonMapper = McpJsonMapper.getDefault();
            }
            McpJsonMapper mcpJsonMapper2 = mcpJsonMapper;
            Duration duration = this.requestTimeout;
            McpUriTemplateManagerFactory mcpUriTemplateManagerFactory = this.uriTemplateManagerFactory;
            JsonSchemaValidator jsonSchemaValidator = this.jsonSchemaValidator;
            if (jsonSchemaValidator == null) {
                jsonSchemaValidator = JsonSchemaValidator.getDefault();
            }
            return new McpSyncServer(new McpAsyncServer(mcpServerTransportProvider, mcpJsonMapper2, asyncFromSync, duration, mcpUriTemplateManagerFactory, jsonSchemaValidator), this.immediateExecution);
        }

        public /* synthetic */ SingleSessionSyncSpecification(McpServerTransportProvider mcpServerTransportProvider, int i) {
            this(mcpServerTransportProvider);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class StreamableSyncSpecification extends SyncSpecification<StreamableSyncSpecification> {
        private final McpStreamableServerTransportProvider transportProvider;

        private StreamableSyncSpecification(McpStreamableServerTransportProvider mcpStreamableServerTransportProvider) {
            Assert.notNull(mcpStreamableServerTransportProvider, "Transport provider must not be null");
            this.transportProvider = mcpStreamableServerTransportProvider;
        }

        @Override // io.modelcontextprotocol.server.McpServer.SyncSpecification
        public McpSyncServer build() {
            McpServerFeatures.Async asyncFromSync = McpServerFeatures.Async.fromSync(new McpServerFeatures.Sync(this.serverInfo, this.serverCapabilities, this.tools, this.resources, this.resourceTemplates, this.prompts, this.completions, this.rootsChangeHandlers, this.instructions), this.immediateExecution);
            JsonSchemaValidator jsonSchemaValidator = this.jsonSchemaValidator;
            if (jsonSchemaValidator == null) {
                jsonSchemaValidator = JsonSchemaValidator.getDefault();
            }
            JsonSchemaValidator jsonSchemaValidator2 = jsonSchemaValidator;
            McpStreamableServerTransportProvider mcpStreamableServerTransportProvider = this.transportProvider;
            McpJsonMapper mcpJsonMapper = this.jsonMapper;
            if (mcpJsonMapper == null) {
                mcpJsonMapper = McpJsonMapper.getDefault();
            }
            return new McpSyncServer(new McpAsyncServer(mcpStreamableServerTransportProvider, mcpJsonMapper, asyncFromSync, this.requestTimeout, this.uriTemplateManagerFactory, jsonSchemaValidator2), this.immediateExecution);
        }

        public /* synthetic */ StreamableSyncSpecification(McpStreamableServerTransportProvider mcpStreamableServerTransportProvider, int i) {
            this(mcpStreamableServerTransportProvider);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static abstract class AsyncSpecification<S extends AsyncSpecification<S>> {
        String instructions;
        McpJsonMapper jsonMapper;
        JsonSchemaValidator jsonSchemaValidator;
        McpSchema.ServerCapabilities serverCapabilities;
        McpUriTemplateManagerFactory uriTemplateManagerFactory = new DefaultMcpUriTemplateManagerFactory();
        McpSchema.Implementation serverInfo = McpServer.DEFAULT_SERVER_INFO;
        final List<McpServerFeatures.AsyncToolSpecification> tools = new ArrayList();
        final Map<String, McpServerFeatures.AsyncResourceSpecification> resources = new HashMap();
        final Map<String, McpServerFeatures.AsyncResourceTemplateSpecification> resourceTemplates = new HashMap();
        final Map<String, McpServerFeatures.AsyncPromptSpecification> prompts = new HashMap();
        final Map<McpSchema.CompleteReference, McpServerFeatures.AsyncCompletionSpecification> completions = new HashMap();
        final List<BiFunction<McpAsyncServerExchange, List<McpSchema.Root>, Mono<Void>>> rootsChangeHandlers = new ArrayList();
        Duration requestTimeout = Duration.ofHours(10);

        private void assertNoDuplicateTool(String str) {
            Stream<McpServerFeatures.AsyncToolSpecification> stream = this.tools.stream();
            o oVar = new o(2);
            oVar.f6285f = str;
            VarHandle.storeStoreFence();
            if (stream.anyMatch(oVar)) {
                g5.f.s(k0.a.C("Tool with name '", str, "' is already registered."));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$assertNoDuplicateTool$0(String str, McpServerFeatures.AsyncToolSpecification asyncToolSpecification) {
            return asyncToolSpecification.tool().name().equals(str);
        }

        public abstract McpAsyncServer build();

        public AsyncSpecification<S> capabilities(McpSchema.ServerCapabilities serverCapabilities) {
            Assert.notNull(serverCapabilities, "Server capabilities must not be null");
            this.serverCapabilities = serverCapabilities;
            return this;
        }

        public AsyncSpecification<S> completions(List<McpServerFeatures.AsyncCompletionSpecification> list) {
            Assert.notNull(list, "Completions list must not be null");
            for (McpServerFeatures.AsyncCompletionSpecification asyncCompletionSpecification : list) {
                this.completions.put(asyncCompletionSpecification.referenceKey(), asyncCompletionSpecification);
            }
            return this;
        }

        public AsyncSpecification<S> instructions(String str) {
            this.instructions = str;
            return this;
        }

        public AsyncSpecification<S> jsonMapper(McpJsonMapper mcpJsonMapper) {
            Assert.notNull(mcpJsonMapper, "JsonMapper must not be null");
            this.jsonMapper = mcpJsonMapper;
            return this;
        }

        public AsyncSpecification<S> jsonSchemaValidator(JsonSchemaValidator jsonSchemaValidator) {
            Assert.notNull(jsonSchemaValidator, "JsonSchemaValidator must not be null");
            this.jsonSchemaValidator = jsonSchemaValidator;
            return this;
        }

        public AsyncSpecification<S> prompts(List<McpServerFeatures.AsyncPromptSpecification> list) {
            Assert.notNull(list, "Prompts list must not be null");
            for (McpServerFeatures.AsyncPromptSpecification asyncPromptSpecification : list) {
                this.prompts.put(asyncPromptSpecification.prompt().name(), asyncPromptSpecification);
            }
            return this;
        }

        public AsyncSpecification<S> requestTimeout(Duration duration) {
            Assert.notNull(duration, "Request timeout must not be null");
            this.requestTimeout = duration;
            return this;
        }

        public AsyncSpecification<S> resourceTemplates(List<McpServerFeatures.AsyncResourceTemplateSpecification> list) {
            Assert.notNull(list, "Resource templates must not be null");
            for (McpServerFeatures.AsyncResourceTemplateSpecification asyncResourceTemplateSpecification : list) {
                this.resourceTemplates.put(asyncResourceTemplateSpecification.resourceTemplate().uriTemplate(), asyncResourceTemplateSpecification);
            }
            return this;
        }

        public AsyncSpecification<S> resources(List<McpServerFeatures.AsyncResourceSpecification> list) {
            Assert.notNull(list, "Resource handlers list must not be null");
            for (McpServerFeatures.AsyncResourceSpecification asyncResourceSpecification : list) {
                this.resources.put(asyncResourceSpecification.resource().uri(), asyncResourceSpecification);
            }
            return this;
        }

        public AsyncSpecification<S> rootsChangeHandler(BiFunction<McpAsyncServerExchange, List<McpSchema.Root>, Mono<Void>> biFunction) {
            Assert.notNull(biFunction, "Consumer must not be null");
            this.rootsChangeHandlers.add(biFunction);
            return this;
        }

        public AsyncSpecification<S> rootsChangeHandlers(BiFunction<McpAsyncServerExchange, List<McpSchema.Root>, Mono<Void>>... biFunctionArr) {
            Assert.notNull(biFunctionArr, "Handlers list must not be null");
            return rootsChangeHandlers(Arrays.asList(biFunctionArr));
        }

        public AsyncSpecification<S> serverInfo(String str, String str2) {
            Assert.hasText(str, "Name must not be null or empty");
            Assert.hasText(str2, "Version must not be null or empty");
            this.serverInfo = new McpSchema.Implementation(str, str2);
            return this;
        }

        @Deprecated
        public AsyncSpecification<S> tool(McpSchema.Tool tool, BiFunction<McpAsyncServerExchange, Map<String, Object>, Mono<McpSchema.CallToolResult>> biFunction) {
            Assert.notNull(tool, "Tool must not be null");
            Assert.notNull(biFunction, "Handler must not be null");
            assertNoDuplicateTool(tool.name());
            this.tools.add(new McpServerFeatures.AsyncToolSpecification(tool, biFunction));
            return this;
        }

        public AsyncSpecification<S> toolCall(McpSchema.Tool tool, BiFunction<McpAsyncServerExchange, McpSchema.CallToolRequest, Mono<McpSchema.CallToolResult>> biFunction) {
            Assert.notNull(tool, "Tool must not be null");
            Assert.notNull(biFunction, "Handler must not be null");
            assertNoDuplicateTool(tool.name());
            this.tools.add(McpServerFeatures.AsyncToolSpecification.builder().tool(tool).callHandler(biFunction).build());
            return this;
        }

        public AsyncSpecification<S> tools(List<McpServerFeatures.AsyncToolSpecification> list) {
            Assert.notNull(list, "Tool handlers list must not be null");
            for (McpServerFeatures.AsyncToolSpecification asyncToolSpecification : list) {
                assertNoDuplicateTool(asyncToolSpecification.tool().name());
                this.tools.add(asyncToolSpecification);
            }
            return this;
        }

        public AsyncSpecification<S> uriTemplateManagerFactory(McpUriTemplateManagerFactory mcpUriTemplateManagerFactory) {
            Assert.notNull(mcpUriTemplateManagerFactory, "URI template manager factory must not be null");
            this.uriTemplateManagerFactory = mcpUriTemplateManagerFactory;
            return this;
        }

        public AsyncSpecification<S> rootsChangeHandlers(List<BiFunction<McpAsyncServerExchange, List<McpSchema.Root>, Mono<Void>>> list) {
            Assert.notNull(list, "Handlers list must not be null");
            this.rootsChangeHandlers.addAll(list);
            return this;
        }

        public AsyncSpecification<S> serverInfo(McpSchema.Implementation implementation) {
            Assert.notNull(implementation, "Server info must not be null");
            this.serverInfo = implementation;
            return this;
        }

        public AsyncSpecification<S> completions(McpServerFeatures.AsyncCompletionSpecification... asyncCompletionSpecificationArr) {
            Assert.notNull(asyncCompletionSpecificationArr, "Completions list must not be null");
            for (McpServerFeatures.AsyncCompletionSpecification asyncCompletionSpecification : asyncCompletionSpecificationArr) {
                this.completions.put(asyncCompletionSpecification.referenceKey(), asyncCompletionSpecification);
            }
            return this;
        }

        public AsyncSpecification<S> prompts(Map<String, McpServerFeatures.AsyncPromptSpecification> map) {
            Assert.notNull(map, "Prompts map must not be null");
            this.prompts.putAll(map);
            return this;
        }

        public AsyncSpecification<S> resourceTemplates(McpServerFeatures.AsyncResourceTemplateSpecification... asyncResourceTemplateSpecificationArr) {
            Assert.notNull(asyncResourceTemplateSpecificationArr, "Resource templates must not be null");
            for (McpServerFeatures.AsyncResourceTemplateSpecification asyncResourceTemplateSpecification : asyncResourceTemplateSpecificationArr) {
                this.resourceTemplates.put(asyncResourceTemplateSpecification.resourceTemplate().uriTemplate(), asyncResourceTemplateSpecification);
            }
            return this;
        }

        public AsyncSpecification<S> resources(Map<String, McpServerFeatures.AsyncResourceSpecification> map) {
            Assert.notNull(map, "Resource handlers map must not be null");
            this.resources.putAll(map);
            return this;
        }

        public AsyncSpecification<S> prompts(McpServerFeatures.AsyncPromptSpecification... asyncPromptSpecificationArr) {
            Assert.notNull(asyncPromptSpecificationArr, "Prompts list must not be null");
            for (McpServerFeatures.AsyncPromptSpecification asyncPromptSpecification : asyncPromptSpecificationArr) {
                this.prompts.put(asyncPromptSpecification.prompt().name(), asyncPromptSpecification);
            }
            return this;
        }

        public AsyncSpecification<S> resources(McpServerFeatures.AsyncResourceSpecification... asyncResourceSpecificationArr) {
            Assert.notNull(asyncResourceSpecificationArr, "Resource handlers list must not be null");
            for (McpServerFeatures.AsyncResourceSpecification asyncResourceSpecification : asyncResourceSpecificationArr) {
                this.resources.put(asyncResourceSpecification.resource().uri(), asyncResourceSpecification);
            }
            return this;
        }

        public AsyncSpecification<S> tools(McpServerFeatures.AsyncToolSpecification... asyncToolSpecificationArr) {
            Assert.notNull(asyncToolSpecificationArr, "Tool handlers list must not be null");
            for (McpServerFeatures.AsyncToolSpecification asyncToolSpecification : asyncToolSpecificationArr) {
                assertNoDuplicateTool(asyncToolSpecification.tool().name());
                this.tools.add(asyncToolSpecification);
            }
            return this;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static abstract class SyncSpecification<S extends SyncSpecification<S>> {
        String instructions;
        McpJsonMapper jsonMapper;
        JsonSchemaValidator jsonSchemaValidator;
        McpSchema.ServerCapabilities serverCapabilities;
        McpUriTemplateManagerFactory uriTemplateManagerFactory = new DefaultMcpUriTemplateManagerFactory();
        McpSchema.Implementation serverInfo = McpServer.DEFAULT_SERVER_INFO;
        final List<McpServerFeatures.SyncToolSpecification> tools = new ArrayList();
        final Map<String, McpServerFeatures.SyncResourceSpecification> resources = new HashMap();
        final Map<String, McpServerFeatures.SyncResourceTemplateSpecification> resourceTemplates = new HashMap();
        final Map<String, McpServerFeatures.SyncPromptSpecification> prompts = new HashMap();
        final Map<McpSchema.CompleteReference, McpServerFeatures.SyncCompletionSpecification> completions = new HashMap();
        final List<BiConsumer<McpSyncServerExchange, List<McpSchema.Root>>> rootsChangeHandlers = new ArrayList();
        Duration requestTimeout = Duration.ofSeconds(10);
        boolean immediateExecution = false;

        private void assertNoDuplicateTool(String str) {
            Stream<McpServerFeatures.SyncToolSpecification> stream = this.tools.stream();
            o oVar = new o(5);
            oVar.f6285f = str;
            VarHandle.storeStoreFence();
            if (stream.anyMatch(oVar)) {
                g5.f.s(k0.a.C("Tool with name '", str, "' is already registered."));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$assertNoDuplicateTool$0(String str, McpServerFeatures.SyncToolSpecification syncToolSpecification) {
            return syncToolSpecification.tool().name().equals(str);
        }

        public abstract McpSyncServer build();

        public SyncSpecification<S> capabilities(McpSchema.ServerCapabilities serverCapabilities) {
            Assert.notNull(serverCapabilities, "Server capabilities must not be null");
            this.serverCapabilities = serverCapabilities;
            return this;
        }

        public SyncSpecification<S> completions(List<McpServerFeatures.SyncCompletionSpecification> list) {
            Assert.notNull(list, "Completions list must not be null");
            for (McpServerFeatures.SyncCompletionSpecification syncCompletionSpecification : list) {
                this.completions.put(syncCompletionSpecification.referenceKey(), syncCompletionSpecification);
            }
            return this;
        }

        public SyncSpecification<S> immediateExecution(boolean z10) {
            this.immediateExecution = z10;
            return this;
        }

        public SyncSpecification<S> instructions(String str) {
            this.instructions = str;
            return this;
        }

        public SyncSpecification<S> jsonMapper(McpJsonMapper mcpJsonMapper) {
            Assert.notNull(mcpJsonMapper, "JsonMapper must not be null");
            this.jsonMapper = mcpJsonMapper;
            return this;
        }

        public SyncSpecification<S> jsonSchemaValidator(JsonSchemaValidator jsonSchemaValidator) {
            Assert.notNull(jsonSchemaValidator, "JsonSchemaValidator must not be null");
            this.jsonSchemaValidator = jsonSchemaValidator;
            return this;
        }

        public SyncSpecification<S> prompts(List<McpServerFeatures.SyncPromptSpecification> list) {
            Assert.notNull(list, "Prompts list must not be null");
            for (McpServerFeatures.SyncPromptSpecification syncPromptSpecification : list) {
                this.prompts.put(syncPromptSpecification.prompt().name(), syncPromptSpecification);
            }
            return this;
        }

        public SyncSpecification<S> requestTimeout(Duration duration) {
            Assert.notNull(duration, "Request timeout must not be null");
            this.requestTimeout = duration;
            return this;
        }

        public SyncSpecification<S> resourceTemplates(List<McpServerFeatures.SyncResourceTemplateSpecification> list) {
            Assert.notNull(list, "Resource templates must not be null");
            for (McpServerFeatures.SyncResourceTemplateSpecification syncResourceTemplateSpecification : list) {
                this.resourceTemplates.put(syncResourceTemplateSpecification.resourceTemplate().uriTemplate(), syncResourceTemplateSpecification);
            }
            return this;
        }

        public SyncSpecification<S> resources(List<McpServerFeatures.SyncResourceSpecification> list) {
            Assert.notNull(list, "Resource handlers list must not be null");
            for (McpServerFeatures.SyncResourceSpecification syncResourceSpecification : list) {
                this.resources.put(syncResourceSpecification.resource().uri(), syncResourceSpecification);
            }
            return this;
        }

        public SyncSpecification<S> rootsChangeHandler(BiConsumer<McpSyncServerExchange, List<McpSchema.Root>> biConsumer) {
            Assert.notNull(biConsumer, "Consumer must not be null");
            this.rootsChangeHandlers.add(biConsumer);
            return this;
        }

        public SyncSpecification<S> rootsChangeHandlers(BiConsumer<McpSyncServerExchange, List<McpSchema.Root>>... biConsumerArr) {
            Assert.notNull(biConsumerArr, "Handlers list must not be null");
            return rootsChangeHandlers(List.of((Object[]) biConsumerArr));
        }

        public SyncSpecification<S> serverInfo(String str, String str2) {
            Assert.hasText(str, "Name must not be null or empty");
            Assert.hasText(str2, "Version must not be null or empty");
            this.serverInfo = new McpSchema.Implementation(str, str2);
            return this;
        }

        @Deprecated
        public SyncSpecification<S> tool(McpSchema.Tool tool, BiFunction<McpSyncServerExchange, Map<String, Object>, McpSchema.CallToolResult> biFunction) {
            Assert.notNull(tool, "Tool must not be null");
            Assert.notNull(biFunction, "Handler must not be null");
            assertNoDuplicateTool(tool.name());
            this.tools.add(new McpServerFeatures.SyncToolSpecification(tool, biFunction));
            return this;
        }

        public SyncSpecification<S> toolCall(McpSchema.Tool tool, BiFunction<McpSyncServerExchange, McpSchema.CallToolRequest, McpSchema.CallToolResult> biFunction) {
            Assert.notNull(tool, "Tool must not be null");
            Assert.notNull(biFunction, "Handler must not be null");
            assertNoDuplicateTool(tool.name());
            this.tools.add(new McpServerFeatures.SyncToolSpecification(tool, null, biFunction));
            return this;
        }

        public SyncSpecification<S> tools(List<McpServerFeatures.SyncToolSpecification> list) {
            Assert.notNull(list, "Tool handlers list must not be null");
            for (McpServerFeatures.SyncToolSpecification syncToolSpecification : list) {
                assertNoDuplicateTool(syncToolSpecification.tool().name());
                this.tools.add(syncToolSpecification);
            }
            return this;
        }

        public SyncSpecification<S> uriTemplateManagerFactory(McpUriTemplateManagerFactory mcpUriTemplateManagerFactory) {
            Assert.notNull(mcpUriTemplateManagerFactory, "URI template manager factory must not be null");
            this.uriTemplateManagerFactory = mcpUriTemplateManagerFactory;
            return this;
        }

        public SyncSpecification<S> rootsChangeHandlers(List<BiConsumer<McpSyncServerExchange, List<McpSchema.Root>>> list) {
            Assert.notNull(list, "Handlers list must not be null");
            this.rootsChangeHandlers.addAll(list);
            return this;
        }

        public SyncSpecification<S> serverInfo(McpSchema.Implementation implementation) {
            Assert.notNull(implementation, "Server info must not be null");
            this.serverInfo = implementation;
            return this;
        }

        public SyncSpecification<S> completions(McpServerFeatures.SyncCompletionSpecification... syncCompletionSpecificationArr) {
            Assert.notNull(syncCompletionSpecificationArr, "Completions list must not be null");
            for (McpServerFeatures.SyncCompletionSpecification syncCompletionSpecification : syncCompletionSpecificationArr) {
                this.completions.put(syncCompletionSpecification.referenceKey(), syncCompletionSpecification);
            }
            return this;
        }

        public SyncSpecification<S> prompts(Map<String, McpServerFeatures.SyncPromptSpecification> map) {
            Assert.notNull(map, "Prompts map must not be null");
            this.prompts.putAll(map);
            return this;
        }

        public SyncSpecification<S> resourceTemplates(McpServerFeatures.SyncResourceTemplateSpecification... syncResourceTemplateSpecificationArr) {
            Assert.notNull(syncResourceTemplateSpecificationArr, "Resource templates must not be null");
            for (McpServerFeatures.SyncResourceTemplateSpecification syncResourceTemplateSpecification : syncResourceTemplateSpecificationArr) {
                this.resourceTemplates.put(syncResourceTemplateSpecification.resourceTemplate().uriTemplate(), syncResourceTemplateSpecification);
            }
            return this;
        }

        public SyncSpecification<S> resources(Map<String, McpServerFeatures.SyncResourceSpecification> map) {
            Assert.notNull(map, "Resource handlers map must not be null");
            this.resources.putAll(map);
            return this;
        }

        public SyncSpecification<S> prompts(McpServerFeatures.SyncPromptSpecification... syncPromptSpecificationArr) {
            Assert.notNull(syncPromptSpecificationArr, "Prompts list must not be null");
            for (McpServerFeatures.SyncPromptSpecification syncPromptSpecification : syncPromptSpecificationArr) {
                this.prompts.put(syncPromptSpecification.prompt().name(), syncPromptSpecification);
            }
            return this;
        }

        public SyncSpecification<S> resources(McpServerFeatures.SyncResourceSpecification... syncResourceSpecificationArr) {
            Assert.notNull(syncResourceSpecificationArr, "Resource handlers list must not be null");
            for (McpServerFeatures.SyncResourceSpecification syncResourceSpecification : syncResourceSpecificationArr) {
                this.resources.put(syncResourceSpecification.resource().uri(), syncResourceSpecification);
            }
            return this;
        }

        public SyncSpecification<S> tools(McpServerFeatures.SyncToolSpecification... syncToolSpecificationArr) {
            Assert.notNull(syncToolSpecificationArr, "Tool handlers list must not be null");
            for (McpServerFeatures.SyncToolSpecification syncToolSpecification : syncToolSpecificationArr) {
                assertNoDuplicateTool(syncToolSpecification.tool().name());
                this.tools.add(syncToolSpecification);
            }
            return this;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class StatelessAsyncSpecification {
        String instructions;
        McpJsonMapper jsonMapper;
        JsonSchemaValidator jsonSchemaValidator;
        McpSchema.ServerCapabilities serverCapabilities;
        private final McpStatelessServerTransport transport;
        McpUriTemplateManagerFactory uriTemplateManagerFactory = new DefaultMcpUriTemplateManagerFactory();
        McpSchema.Implementation serverInfo = McpServer.DEFAULT_SERVER_INFO;
        final List<McpStatelessServerFeatures.AsyncToolSpecification> tools = new ArrayList();
        final Map<String, McpStatelessServerFeatures.AsyncResourceSpecification> resources = new HashMap();
        final Map<String, McpStatelessServerFeatures.AsyncResourceTemplateSpecification> resourceTemplates = new HashMap();
        final Map<String, McpStatelessServerFeatures.AsyncPromptSpecification> prompts = new HashMap();
        final Map<McpSchema.CompleteReference, McpStatelessServerFeatures.AsyncCompletionSpecification> completions = new HashMap();
        Duration requestTimeout = Duration.ofSeconds(10);

        public StatelessAsyncSpecification(McpStatelessServerTransport mcpStatelessServerTransport) {
            this.transport = mcpStatelessServerTransport;
        }

        private void assertNoDuplicateTool(String str) {
            Stream<McpStatelessServerFeatures.AsyncToolSpecification> stream = this.tools.stream();
            o oVar = new o(3);
            oVar.f6285f = str;
            VarHandle.storeStoreFence();
            if (stream.anyMatch(oVar)) {
                g5.f.s(k0.a.C("Tool with name '", str, "' is already registered."));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$assertNoDuplicateTool$0(String str, McpStatelessServerFeatures.AsyncToolSpecification asyncToolSpecification) {
            return asyncToolSpecification.tool().name().equals(str);
        }

        public McpStatelessAsyncServer build() {
            McpStatelessServerFeatures.Async async = new McpStatelessServerFeatures.Async(this.serverInfo, this.serverCapabilities, this.tools, this.resources, this.resourceTemplates, this.prompts, this.completions, this.instructions);
            McpStatelessServerTransport mcpStatelessServerTransport = this.transport;
            McpJsonMapper mcpJsonMapper = this.jsonMapper;
            if (mcpJsonMapper == null) {
                mcpJsonMapper = McpJsonMapper.getDefault();
            }
            Duration duration = this.requestTimeout;
            McpUriTemplateManagerFactory mcpUriTemplateManagerFactory = this.uriTemplateManagerFactory;
            JsonSchemaValidator jsonSchemaValidator = this.jsonSchemaValidator;
            if (jsonSchemaValidator == null) {
                jsonSchemaValidator = JsonSchemaValidator.getDefault();
            }
            return new McpStatelessAsyncServer(mcpStatelessServerTransport, mcpJsonMapper, async, duration, mcpUriTemplateManagerFactory, jsonSchemaValidator);
        }

        public StatelessAsyncSpecification capabilities(McpSchema.ServerCapabilities serverCapabilities) {
            Assert.notNull(serverCapabilities, "Server capabilities must not be null");
            this.serverCapabilities = serverCapabilities;
            return this;
        }

        public StatelessAsyncSpecification completions(List<McpStatelessServerFeatures.AsyncCompletionSpecification> list) {
            Assert.notNull(list, "Completions list must not be null");
            for (McpStatelessServerFeatures.AsyncCompletionSpecification asyncCompletionSpecification : list) {
                this.completions.put(asyncCompletionSpecification.referenceKey(), asyncCompletionSpecification);
            }
            return this;
        }

        public StatelessAsyncSpecification instructions(String str) {
            this.instructions = str;
            return this;
        }

        public StatelessAsyncSpecification jsonMapper(McpJsonMapper mcpJsonMapper) {
            Assert.notNull(mcpJsonMapper, "JsonMapper must not be null");
            this.jsonMapper = mcpJsonMapper;
            return this;
        }

        public StatelessAsyncSpecification jsonSchemaValidator(JsonSchemaValidator jsonSchemaValidator) {
            Assert.notNull(jsonSchemaValidator, "JsonSchemaValidator must not be null");
            this.jsonSchemaValidator = jsonSchemaValidator;
            return this;
        }

        public StatelessAsyncSpecification prompts(List<McpStatelessServerFeatures.AsyncPromptSpecification> list) {
            Assert.notNull(list, "Prompts list must not be null");
            for (McpStatelessServerFeatures.AsyncPromptSpecification asyncPromptSpecification : list) {
                this.prompts.put(asyncPromptSpecification.prompt().name(), asyncPromptSpecification);
            }
            return this;
        }

        public StatelessAsyncSpecification requestTimeout(Duration duration) {
            Assert.notNull(duration, "Request timeout must not be null");
            this.requestTimeout = duration;
            return this;
        }

        public StatelessAsyncSpecification resourceTemplates(List<McpStatelessServerFeatures.AsyncResourceTemplateSpecification> list) {
            Assert.notNull(list, "Resource templates must not be null");
            for (McpStatelessServerFeatures.AsyncResourceTemplateSpecification asyncResourceTemplateSpecification : list) {
                this.resourceTemplates.put(asyncResourceTemplateSpecification.resourceTemplate().uriTemplate(), asyncResourceTemplateSpecification);
            }
            return this;
        }

        public StatelessAsyncSpecification resources(List<McpStatelessServerFeatures.AsyncResourceSpecification> list) {
            Assert.notNull(list, "Resource handlers list must not be null");
            for (McpStatelessServerFeatures.AsyncResourceSpecification asyncResourceSpecification : list) {
                this.resources.put(asyncResourceSpecification.resource().uri(), asyncResourceSpecification);
            }
            return this;
        }

        public StatelessAsyncSpecification serverInfo(String str, String str2) {
            Assert.hasText(str, "Name must not be null or empty");
            Assert.hasText(str2, "Version must not be null or empty");
            this.serverInfo = new McpSchema.Implementation(str, str2);
            return this;
        }

        public StatelessAsyncSpecification toolCall(McpSchema.Tool tool, BiFunction<McpTransportContext, McpSchema.CallToolRequest, Mono<McpSchema.CallToolResult>> biFunction) {
            Assert.notNull(tool, "Tool must not be null");
            Assert.notNull(biFunction, "Handler must not be null");
            assertNoDuplicateTool(tool.name());
            this.tools.add(new McpStatelessServerFeatures.AsyncToolSpecification(tool, biFunction));
            return this;
        }

        public StatelessAsyncSpecification tools(List<McpStatelessServerFeatures.AsyncToolSpecification> list) {
            Assert.notNull(list, "Tool handlers list must not be null");
            for (McpStatelessServerFeatures.AsyncToolSpecification asyncToolSpecification : list) {
                assertNoDuplicateTool(asyncToolSpecification.tool().name());
                this.tools.add(asyncToolSpecification);
            }
            return this;
        }

        public StatelessAsyncSpecification uriTemplateManagerFactory(McpUriTemplateManagerFactory mcpUriTemplateManagerFactory) {
            Assert.notNull(mcpUriTemplateManagerFactory, "URI template manager factory must not be null");
            this.uriTemplateManagerFactory = mcpUriTemplateManagerFactory;
            return this;
        }

        public StatelessAsyncSpecification serverInfo(McpSchema.Implementation implementation) {
            Assert.notNull(implementation, "Server info must not be null");
            this.serverInfo = implementation;
            return this;
        }

        public StatelessAsyncSpecification completions(McpStatelessServerFeatures.AsyncCompletionSpecification... asyncCompletionSpecificationArr) {
            Assert.notNull(asyncCompletionSpecificationArr, "Completions list must not be null");
            for (McpStatelessServerFeatures.AsyncCompletionSpecification asyncCompletionSpecification : asyncCompletionSpecificationArr) {
                this.completions.put(asyncCompletionSpecification.referenceKey(), asyncCompletionSpecification);
            }
            return this;
        }

        public StatelessAsyncSpecification prompts(Map<String, McpStatelessServerFeatures.AsyncPromptSpecification> map) {
            Assert.notNull(map, "Prompts map must not be null");
            this.prompts.putAll(map);
            return this;
        }

        public StatelessAsyncSpecification resourceTemplates(McpStatelessServerFeatures.AsyncResourceTemplateSpecification... asyncResourceTemplateSpecificationArr) {
            Assert.notNull(asyncResourceTemplateSpecificationArr, "Resource templates must not be null");
            for (McpStatelessServerFeatures.AsyncResourceTemplateSpecification asyncResourceTemplateSpecification : asyncResourceTemplateSpecificationArr) {
                this.resourceTemplates.put(asyncResourceTemplateSpecification.resourceTemplate().uriTemplate(), asyncResourceTemplateSpecification);
            }
            return this;
        }

        public StatelessAsyncSpecification resources(Map<String, McpStatelessServerFeatures.AsyncResourceSpecification> map) {
            Assert.notNull(map, "Resource handlers map must not be null");
            this.resources.putAll(map);
            return this;
        }

        public StatelessAsyncSpecification prompts(McpStatelessServerFeatures.AsyncPromptSpecification... asyncPromptSpecificationArr) {
            Assert.notNull(asyncPromptSpecificationArr, "Prompts list must not be null");
            for (McpStatelessServerFeatures.AsyncPromptSpecification asyncPromptSpecification : asyncPromptSpecificationArr) {
                this.prompts.put(asyncPromptSpecification.prompt().name(), asyncPromptSpecification);
            }
            return this;
        }

        public StatelessAsyncSpecification resources(McpStatelessServerFeatures.AsyncResourceSpecification... asyncResourceSpecificationArr) {
            Assert.notNull(asyncResourceSpecificationArr, "Resource handlers list must not be null");
            for (McpStatelessServerFeatures.AsyncResourceSpecification asyncResourceSpecification : asyncResourceSpecificationArr) {
                this.resources.put(asyncResourceSpecification.resource().uri(), asyncResourceSpecification);
            }
            return this;
        }

        public StatelessAsyncSpecification tools(McpStatelessServerFeatures.AsyncToolSpecification... asyncToolSpecificationArr) {
            Assert.notNull(asyncToolSpecificationArr, "Tool handlers list must not be null");
            for (McpStatelessServerFeatures.AsyncToolSpecification asyncToolSpecification : asyncToolSpecificationArr) {
                assertNoDuplicateTool(asyncToolSpecification.tool().name());
                this.tools.add(asyncToolSpecification);
            }
            return this;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class StatelessSyncSpecification {
        String instructions;
        McpJsonMapper jsonMapper;
        JsonSchemaValidator jsonSchemaValidator;
        McpSchema.ServerCapabilities serverCapabilities;
        private final McpStatelessServerTransport transport;
        boolean immediateExecution = false;
        McpUriTemplateManagerFactory uriTemplateManagerFactory = new DefaultMcpUriTemplateManagerFactory();
        McpSchema.Implementation serverInfo = McpServer.DEFAULT_SERVER_INFO;
        final List<McpStatelessServerFeatures.SyncToolSpecification> tools = new ArrayList();
        final Map<String, McpStatelessServerFeatures.SyncResourceSpecification> resources = new HashMap();
        final Map<String, McpStatelessServerFeatures.SyncResourceTemplateSpecification> resourceTemplates = new HashMap();
        final Map<String, McpStatelessServerFeatures.SyncPromptSpecification> prompts = new HashMap();
        final Map<McpSchema.CompleteReference, McpStatelessServerFeatures.SyncCompletionSpecification> completions = new HashMap();
        Duration requestTimeout = Duration.ofSeconds(10);

        public StatelessSyncSpecification(McpStatelessServerTransport mcpStatelessServerTransport) {
            this.transport = mcpStatelessServerTransport;
        }

        private void assertNoDuplicateTool(String str) {
            Stream<McpStatelessServerFeatures.SyncToolSpecification> stream = this.tools.stream();
            o oVar = new o(4);
            oVar.f6285f = str;
            VarHandle.storeStoreFence();
            if (stream.anyMatch(oVar)) {
                g5.f.s(k0.a.C("Tool with name '", str, "' is already registered."));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$assertNoDuplicateTool$0(String str, McpStatelessServerFeatures.SyncToolSpecification syncToolSpecification) {
            return syncToolSpecification.tool().name().equals(str);
        }

        public McpStatelessSyncServer build() {
            McpStatelessServerFeatures.Async asyncFromSync = McpStatelessServerFeatures.Async.fromSync(new McpStatelessServerFeatures.Sync(this.serverInfo, this.serverCapabilities, this.tools, this.resources, this.resourceTemplates, this.prompts, this.completions, this.instructions), this.immediateExecution);
            McpStatelessServerTransport mcpStatelessServerTransport = this.transport;
            McpJsonMapper mcpJsonMapper = this.jsonMapper;
            if (mcpJsonMapper == null) {
                mcpJsonMapper = McpJsonMapper.getDefault();
            }
            McpJsonMapper mcpJsonMapper2 = mcpJsonMapper;
            Duration duration = this.requestTimeout;
            McpUriTemplateManagerFactory mcpUriTemplateManagerFactory = this.uriTemplateManagerFactory;
            JsonSchemaValidator jsonSchemaValidator = this.jsonSchemaValidator;
            if (jsonSchemaValidator == null) {
                jsonSchemaValidator = JsonSchemaValidator.getDefault();
            }
            return new McpStatelessSyncServer(new McpStatelessAsyncServer(mcpStatelessServerTransport, mcpJsonMapper2, asyncFromSync, duration, mcpUriTemplateManagerFactory, jsonSchemaValidator), this.immediateExecution);
        }

        public StatelessSyncSpecification capabilities(McpSchema.ServerCapabilities serverCapabilities) {
            Assert.notNull(serverCapabilities, "Server capabilities must not be null");
            this.serverCapabilities = serverCapabilities;
            return this;
        }

        public StatelessSyncSpecification completions(List<McpStatelessServerFeatures.SyncCompletionSpecification> list) {
            Assert.notNull(list, "Completions list must not be null");
            for (McpStatelessServerFeatures.SyncCompletionSpecification syncCompletionSpecification : list) {
                this.completions.put(syncCompletionSpecification.referenceKey(), syncCompletionSpecification);
            }
            return this;
        }

        public StatelessSyncSpecification immediateExecution(boolean z10) {
            this.immediateExecution = z10;
            return this;
        }

        public StatelessSyncSpecification instructions(String str) {
            this.instructions = str;
            return this;
        }

        public StatelessSyncSpecification jsonMapper(McpJsonMapper mcpJsonMapper) {
            Assert.notNull(mcpJsonMapper, "JsonMapper must not be null");
            this.jsonMapper = mcpJsonMapper;
            return this;
        }

        public StatelessSyncSpecification jsonSchemaValidator(JsonSchemaValidator jsonSchemaValidator) {
            Assert.notNull(jsonSchemaValidator, "JsonSchemaValidator must not be null");
            this.jsonSchemaValidator = jsonSchemaValidator;
            return this;
        }

        public StatelessSyncSpecification prompts(List<McpStatelessServerFeatures.SyncPromptSpecification> list) {
            Assert.notNull(list, "Prompts list must not be null");
            for (McpStatelessServerFeatures.SyncPromptSpecification syncPromptSpecification : list) {
                this.prompts.put(syncPromptSpecification.prompt().name(), syncPromptSpecification);
            }
            return this;
        }

        public StatelessSyncSpecification requestTimeout(Duration duration) {
            Assert.notNull(duration, "Request timeout must not be null");
            this.requestTimeout = duration;
            return this;
        }

        public StatelessSyncSpecification resourceTemplates(List<McpStatelessServerFeatures.SyncResourceTemplateSpecification> list) {
            Assert.notNull(list, "Resource templates must not be null");
            for (McpStatelessServerFeatures.SyncResourceTemplateSpecification syncResourceTemplateSpecification : list) {
                this.resourceTemplates.put(syncResourceTemplateSpecification.resourceTemplate().uriTemplate(), syncResourceTemplateSpecification);
            }
            return this;
        }

        public StatelessSyncSpecification resources(List<McpStatelessServerFeatures.SyncResourceSpecification> list) {
            Assert.notNull(list, "Resource handlers list must not be null");
            for (McpStatelessServerFeatures.SyncResourceSpecification syncResourceSpecification : list) {
                this.resources.put(syncResourceSpecification.resource().uri(), syncResourceSpecification);
            }
            return this;
        }

        public StatelessSyncSpecification serverInfo(String str, String str2) {
            Assert.hasText(str, "Name must not be null or empty");
            Assert.hasText(str2, "Version must not be null or empty");
            this.serverInfo = new McpSchema.Implementation(str, str2);
            return this;
        }

        public StatelessSyncSpecification toolCall(McpSchema.Tool tool, BiFunction<McpTransportContext, McpSchema.CallToolRequest, McpSchema.CallToolResult> biFunction) {
            Assert.notNull(tool, "Tool must not be null");
            Assert.notNull(biFunction, "Handler must not be null");
            assertNoDuplicateTool(tool.name());
            this.tools.add(new McpStatelessServerFeatures.SyncToolSpecification(tool, biFunction));
            return this;
        }

        public StatelessSyncSpecification tools(List<McpStatelessServerFeatures.SyncToolSpecification> list) {
            Assert.notNull(list, "Tool handlers list must not be null");
            for (McpStatelessServerFeatures.SyncToolSpecification syncToolSpecification : list) {
                assertNoDuplicateTool(syncToolSpecification.tool().name());
                this.tools.add(syncToolSpecification);
            }
            return this;
        }

        public StatelessSyncSpecification uriTemplateManagerFactory(McpUriTemplateManagerFactory mcpUriTemplateManagerFactory) {
            Assert.notNull(mcpUriTemplateManagerFactory, "URI template manager factory must not be null");
            this.uriTemplateManagerFactory = mcpUriTemplateManagerFactory;
            return this;
        }

        public StatelessSyncSpecification serverInfo(McpSchema.Implementation implementation) {
            Assert.notNull(implementation, "Server info must not be null");
            this.serverInfo = implementation;
            return this;
        }

        public StatelessSyncSpecification completions(McpStatelessServerFeatures.SyncCompletionSpecification... syncCompletionSpecificationArr) {
            Assert.notNull(syncCompletionSpecificationArr, "Completions list must not be null");
            for (McpStatelessServerFeatures.SyncCompletionSpecification syncCompletionSpecification : syncCompletionSpecificationArr) {
                this.completions.put(syncCompletionSpecification.referenceKey(), syncCompletionSpecification);
            }
            return this;
        }

        public StatelessSyncSpecification prompts(Map<String, McpStatelessServerFeatures.SyncPromptSpecification> map) {
            Assert.notNull(map, "Prompts map must not be null");
            this.prompts.putAll(map);
            return this;
        }

        public StatelessSyncSpecification resourceTemplates(McpStatelessServerFeatures.SyncResourceTemplateSpecification... syncResourceTemplateSpecificationArr) {
            Assert.notNull(syncResourceTemplateSpecificationArr, "Resource templates must not be null");
            for (McpStatelessServerFeatures.SyncResourceTemplateSpecification syncResourceTemplateSpecification : syncResourceTemplateSpecificationArr) {
                this.resourceTemplates.put(syncResourceTemplateSpecification.resourceTemplate().uriTemplate(), syncResourceTemplateSpecification);
            }
            return this;
        }

        public StatelessSyncSpecification resources(Map<String, McpStatelessServerFeatures.SyncResourceSpecification> map) {
            Assert.notNull(map, "Resource handlers map must not be null");
            this.resources.putAll(map);
            return this;
        }

        public StatelessSyncSpecification prompts(McpStatelessServerFeatures.SyncPromptSpecification... syncPromptSpecificationArr) {
            Assert.notNull(syncPromptSpecificationArr, "Prompts list must not be null");
            for (McpStatelessServerFeatures.SyncPromptSpecification syncPromptSpecification : syncPromptSpecificationArr) {
                this.prompts.put(syncPromptSpecification.prompt().name(), syncPromptSpecification);
            }
            return this;
        }

        public StatelessSyncSpecification resources(McpStatelessServerFeatures.SyncResourceSpecification... syncResourceSpecificationArr) {
            Assert.notNull(syncResourceSpecificationArr, "Resource handlers list must not be null");
            for (McpStatelessServerFeatures.SyncResourceSpecification syncResourceSpecification : syncResourceSpecificationArr) {
                this.resources.put(syncResourceSpecification.resource().uri(), syncResourceSpecification);
            }
            return this;
        }

        public StatelessSyncSpecification tools(McpStatelessServerFeatures.SyncToolSpecification... syncToolSpecificationArr) {
            Assert.notNull(syncToolSpecificationArr, "Tool handlers list must not be null");
            for (McpStatelessServerFeatures.SyncToolSpecification syncToolSpecification : syncToolSpecificationArr) {
                assertNoDuplicateTool(syncToolSpecification.tool().name());
                this.tools.add(syncToolSpecification);
            }
            return this;
        }
    }
}
