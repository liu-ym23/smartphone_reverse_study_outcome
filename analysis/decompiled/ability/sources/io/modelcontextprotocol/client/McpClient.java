package io.modelcontextprotocol.client;

import io.modelcontextprotocol.client.McpClientFeatures;
import io.modelcontextprotocol.common.McpTransportContext;
import io.modelcontextprotocol.json.schema.JsonSchemaValidator;
import io.modelcontextprotocol.spec.McpClientTransport;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.util.Assert;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import reactor.core.publisher.Mono;

/* loaded from: classes2.dex */
public interface McpClient {

    public static class AsyncSpec {
        private McpSchema.ClientCapabilities capabilities;
        private McpSchema.Implementation clientInfo;
        private Function<McpSchema.ElicitRequest, Mono<McpSchema.ElicitResult>> elicitationHandler;
        private boolean enableCallToolSchemaCaching;
        private Duration initializationTimeout;
        private JsonSchemaValidator jsonSchemaValidator;
        private final List<Function<McpSchema.LoggingMessageNotification, Mono<Void>>> loggingConsumers;
        private final List<Function<McpSchema.ProgressNotification, Mono<Void>>> progressConsumers;
        private final List<Function<List<McpSchema.Prompt>, Mono<Void>>> promptsChangeConsumers;
        private Duration requestTimeout;
        private final List<Function<List<McpSchema.Resource>, Mono<Void>>> resourcesChangeConsumers;
        private final List<Function<List<McpSchema.ResourceContents>, Mono<Void>>> resourcesUpdateConsumers;
        private final Map<String, McpSchema.Root> roots;
        private Function<McpSchema.CreateMessageRequest, Mono<McpSchema.CreateMessageResult>> samplingHandler;
        private final List<Function<List<McpSchema.Tool>, Mono<Void>>> toolsChangeConsumers;
        private final McpClientTransport transport;

        public /* synthetic */ AsyncSpec(McpClientTransport mcpClientTransport, int i) {
            this(mcpClientTransport);
        }

        public McpAsyncClient build() {
            JsonSchemaValidator jsonSchemaValidator = this.jsonSchemaValidator;
            if (jsonSchemaValidator == null) {
                jsonSchemaValidator = JsonSchemaValidator.getDefault();
            }
            return new McpAsyncClient(this.transport, this.requestTimeout, this.initializationTimeout, jsonSchemaValidator, new McpClientFeatures.Async(this.clientInfo, this.capabilities, this.roots, this.toolsChangeConsumers, this.resourcesChangeConsumers, this.resourcesUpdateConsumers, this.promptsChangeConsumers, this.loggingConsumers, this.progressConsumers, this.samplingHandler, this.elicitationHandler, this.enableCallToolSchemaCaching));
        }

        public AsyncSpec capabilities(McpSchema.ClientCapabilities clientCapabilities) {
            Assert.notNull(clientCapabilities, "Capabilities must not be null");
            this.capabilities = clientCapabilities;
            return this;
        }

        public AsyncSpec clientInfo(McpSchema.Implementation implementation) {
            Assert.notNull(implementation, "Client info must not be null");
            this.clientInfo = implementation;
            return this;
        }

        public AsyncSpec elicitation(Function<McpSchema.ElicitRequest, Mono<McpSchema.ElicitResult>> function) {
            Assert.notNull(function, "Elicitation handler must not be null");
            this.elicitationHandler = function;
            return this;
        }

        public AsyncSpec enableCallToolSchemaCaching(boolean z10) {
            this.enableCallToolSchemaCaching = z10;
            return this;
        }

        public AsyncSpec initializationTimeout(Duration duration) {
            Assert.notNull(duration, "Initialization timeout must not be null");
            this.initializationTimeout = duration;
            return this;
        }

        public AsyncSpec jsonSchemaValidator(JsonSchemaValidator jsonSchemaValidator) {
            Assert.notNull(jsonSchemaValidator, "JsonSchemaValidator must not be null");
            this.jsonSchemaValidator = jsonSchemaValidator;
            return this;
        }

        public AsyncSpec loggingConsumer(Function<McpSchema.LoggingMessageNotification, Mono<Void>> function) {
            Assert.notNull(function, "Logging consumer must not be null");
            this.loggingConsumers.add(function);
            return this;
        }

        public AsyncSpec loggingConsumers(List<Function<McpSchema.LoggingMessageNotification, Mono<Void>>> list) {
            Assert.notNull(list, "Logging consumers must not be null");
            this.loggingConsumers.addAll(list);
            return this;
        }

        public AsyncSpec progressConsumer(Function<McpSchema.ProgressNotification, Mono<Void>> function) {
            Assert.notNull(function, "Progress consumer must not be null");
            this.progressConsumers.add(function);
            return this;
        }

        public AsyncSpec progressConsumers(List<Function<McpSchema.ProgressNotification, Mono<Void>>> list) {
            Assert.notNull(list, "Progress consumers must not be null");
            this.progressConsumers.addAll(list);
            return this;
        }

        public AsyncSpec promptsChangeConsumer(Function<List<McpSchema.Prompt>, Mono<Void>> function) {
            Assert.notNull(function, "Prompts change consumer must not be null");
            this.promptsChangeConsumers.add(function);
            return this;
        }

        public AsyncSpec requestTimeout(Duration duration) {
            Assert.notNull(duration, "Request timeout must not be null");
            this.requestTimeout = duration;
            return this;
        }

        public AsyncSpec resourcesChangeConsumer(Function<List<McpSchema.Resource>, Mono<Void>> function) {
            Assert.notNull(function, "Resources change consumer must not be null");
            this.resourcesChangeConsumers.add(function);
            return this;
        }

        public AsyncSpec resourcesUpdateConsumer(Function<List<McpSchema.ResourceContents>, Mono<Void>> function) {
            Assert.notNull(function, "Resources update consumer must not be null");
            this.resourcesUpdateConsumers.add(function);
            return this;
        }

        public AsyncSpec roots(List<McpSchema.Root> list) {
            Assert.notNull(list, "Roots must not be null");
            for (McpSchema.Root root : list) {
                this.roots.put(root.uri(), root);
            }
            return this;
        }

        public AsyncSpec sampling(Function<McpSchema.CreateMessageRequest, Mono<McpSchema.CreateMessageResult>> function) {
            Assert.notNull(function, "Sampling handler must not be null");
            this.samplingHandler = function;
            return this;
        }

        public AsyncSpec toolsChangeConsumer(Function<List<McpSchema.Tool>, Mono<Void>> function) {
            Assert.notNull(function, "Tools change consumer must not be null");
            this.toolsChangeConsumers.add(function);
            return this;
        }

        private AsyncSpec(McpClientTransport mcpClientTransport) {
            this.requestTimeout = Duration.ofSeconds(20L);
            this.initializationTimeout = Duration.ofSeconds(20L);
            this.clientInfo = new McpSchema.Implementation("Java SDK MCP Client", "0.15.0");
            this.roots = new HashMap();
            this.toolsChangeConsumers = new ArrayList();
            this.resourcesChangeConsumers = new ArrayList();
            this.resourcesUpdateConsumers = new ArrayList();
            this.promptsChangeConsumers = new ArrayList();
            this.loggingConsumers = new ArrayList();
            this.progressConsumers = new ArrayList();
            this.enableCallToolSchemaCaching = false;
            Assert.notNull(mcpClientTransport, "Transport must not be null");
            this.transport = mcpClientTransport;
        }

        public AsyncSpec roots(McpSchema.Root... rootArr) {
            Assert.notNull(rootArr, "Roots must not be null");
            for (McpSchema.Root root : rootArr) {
                this.roots.put(root.uri(), root);
            }
            return this;
        }
    }

    public static class SyncSpec {
        private McpSchema.ClientCapabilities capabilities;
        private McpSchema.Implementation clientInfo;
        private Supplier<McpTransportContext> contextProvider;
        private Function<McpSchema.ElicitRequest, McpSchema.ElicitResult> elicitationHandler;
        private boolean enableCallToolSchemaCaching;
        private Duration initializationTimeout;
        private JsonSchemaValidator jsonSchemaValidator;
        private final List<Consumer<McpSchema.LoggingMessageNotification>> loggingConsumers;
        private final List<Consumer<McpSchema.ProgressNotification>> progressConsumers;
        private final List<Consumer<List<McpSchema.Prompt>>> promptsChangeConsumers;
        private Duration requestTimeout;
        private final List<Consumer<List<McpSchema.Resource>>> resourcesChangeConsumers;
        private final List<Consumer<List<McpSchema.ResourceContents>>> resourcesUpdateConsumers;
        private final Map<String, McpSchema.Root> roots;
        private Function<McpSchema.CreateMessageRequest, McpSchema.CreateMessageResult> samplingHandler;
        private final List<Consumer<List<McpSchema.Tool>>> toolsChangeConsumers;
        private final McpClientTransport transport;

        public /* synthetic */ SyncSpec(McpClientTransport mcpClientTransport, int i) {
            this(mcpClientTransport);
        }

        public McpSyncClient build() {
            McpClientFeatures.Async asyncFromSync = McpClientFeatures.Async.fromSync(new McpClientFeatures.Sync(this.clientInfo, this.capabilities, this.roots, this.toolsChangeConsumers, this.resourcesChangeConsumers, this.resourcesUpdateConsumers, this.promptsChangeConsumers, this.loggingConsumers, this.progressConsumers, this.samplingHandler, this.elicitationHandler, this.enableCallToolSchemaCaching));
            McpClientTransport mcpClientTransport = this.transport;
            Duration duration = this.requestTimeout;
            Duration duration2 = this.initializationTimeout;
            JsonSchemaValidator jsonSchemaValidator = this.jsonSchemaValidator;
            if (jsonSchemaValidator == null) {
                jsonSchemaValidator = JsonSchemaValidator.getDefault();
            }
            return new McpSyncClient(new McpAsyncClient(mcpClientTransport, duration, duration2, jsonSchemaValidator, asyncFromSync), this.contextProvider);
        }

        public SyncSpec capabilities(McpSchema.ClientCapabilities clientCapabilities) {
            Assert.notNull(clientCapabilities, "Capabilities must not be null");
            this.capabilities = clientCapabilities;
            return this;
        }

        public SyncSpec clientInfo(McpSchema.Implementation implementation) {
            Assert.notNull(implementation, "Client info must not be null");
            this.clientInfo = implementation;
            return this;
        }

        public SyncSpec elicitation(Function<McpSchema.ElicitRequest, McpSchema.ElicitResult> function) {
            Assert.notNull(function, "Elicitation handler must not be null");
            this.elicitationHandler = function;
            return this;
        }

        public SyncSpec enableCallToolSchemaCaching(boolean z10) {
            this.enableCallToolSchemaCaching = z10;
            return this;
        }

        public SyncSpec initializationTimeout(Duration duration) {
            Assert.notNull(duration, "Initialization timeout must not be null");
            this.initializationTimeout = duration;
            return this;
        }

        public SyncSpec jsonSchemaValidator(JsonSchemaValidator jsonSchemaValidator) {
            Assert.notNull(jsonSchemaValidator, "JsonSchemaValidator must not be null");
            this.jsonSchemaValidator = jsonSchemaValidator;
            return this;
        }

        public SyncSpec loggingConsumer(Consumer<McpSchema.LoggingMessageNotification> consumer) {
            Assert.notNull(consumer, "Logging consumer must not be null");
            this.loggingConsumers.add(consumer);
            return this;
        }

        public SyncSpec loggingConsumers(List<Consumer<McpSchema.LoggingMessageNotification>> list) {
            Assert.notNull(list, "Logging consumers must not be null");
            this.loggingConsumers.addAll(list);
            return this;
        }

        public SyncSpec progressConsumer(Consumer<McpSchema.ProgressNotification> consumer) {
            Assert.notNull(consumer, "Progress consumer must not be null");
            this.progressConsumers.add(consumer);
            return this;
        }

        public SyncSpec progressConsumers(List<Consumer<McpSchema.ProgressNotification>> list) {
            Assert.notNull(list, "Progress consumers must not be null");
            this.progressConsumers.addAll(list);
            return this;
        }

        public SyncSpec promptsChangeConsumer(Consumer<List<McpSchema.Prompt>> consumer) {
            Assert.notNull(consumer, "Prompts change consumer must not be null");
            this.promptsChangeConsumers.add(consumer);
            return this;
        }

        public SyncSpec requestTimeout(Duration duration) {
            Assert.notNull(duration, "Request timeout must not be null");
            this.requestTimeout = duration;
            return this;
        }

        public SyncSpec resourcesChangeConsumer(Consumer<List<McpSchema.Resource>> consumer) {
            Assert.notNull(consumer, "Resources change consumer must not be null");
            this.resourcesChangeConsumers.add(consumer);
            return this;
        }

        public SyncSpec roots(List<McpSchema.Root> list) {
            Assert.notNull(list, "Roots must not be null");
            for (McpSchema.Root root : list) {
                this.roots.put(root.uri(), root);
            }
            return this;
        }

        public SyncSpec sampling(Function<McpSchema.CreateMessageRequest, McpSchema.CreateMessageResult> function) {
            Assert.notNull(function, "Sampling handler must not be null");
            this.samplingHandler = function;
            return this;
        }

        public SyncSpec toolsChangeConsumer(Consumer<List<McpSchema.Tool>> consumer) {
            Assert.notNull(consumer, "Tools change consumer must not be null");
            this.toolsChangeConsumers.add(consumer);
            return this;
        }

        public SyncSpec transportContextProvider(Supplier<McpTransportContext> supplier) {
            this.contextProvider = supplier;
            return this;
        }

        private SyncSpec(McpClientTransport mcpClientTransport) {
            this.requestTimeout = Duration.ofSeconds(20L);
            this.initializationTimeout = Duration.ofSeconds(20L);
            this.clientInfo = new McpSchema.Implementation("Java SDK MCP Client", "0.15.0");
            this.roots = new HashMap();
            this.toolsChangeConsumers = new ArrayList();
            this.resourcesChangeConsumers = new ArrayList();
            this.resourcesUpdateConsumers = new ArrayList();
            this.promptsChangeConsumers = new ArrayList();
            this.loggingConsumers = new ArrayList();
            this.progressConsumers = new ArrayList();
            this.contextProvider = new u();
            this.enableCallToolSchemaCaching = false;
            Assert.notNull(mcpClientTransport, "Transport must not be null");
            this.transport = mcpClientTransport;
        }

        public SyncSpec roots(McpSchema.Root... rootArr) {
            Assert.notNull(rootArr, "Roots must not be null");
            for (McpSchema.Root root : rootArr) {
                this.roots.put(root.uri(), root);
            }
            return this;
        }
    }

    static AsyncSpec async(McpClientTransport mcpClientTransport) {
        return new AsyncSpec(mcpClientTransport, 0);
    }

    static SyncSpec sync(McpClientTransport mcpClientTransport) {
        return new SyncSpec(mcpClientTransport, 0);
    }
}
