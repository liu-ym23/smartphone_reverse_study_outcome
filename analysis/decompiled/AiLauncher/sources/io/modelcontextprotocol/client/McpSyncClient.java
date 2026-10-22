package io.modelcontextprotocol.client;

import io.modelcontextprotocol.common.McpTransportContext;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.util.Assert;
import java.time.Duration;
import java.util.function.Function;
import java.util.function.Supplier;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

/* loaded from: classes4.dex */
public class McpSyncClient implements AutoCloseable {
    private static final long DEFAULT_CLOSE_TIMEOUT_MS = 10000;
    private static final vc.c logger = vc.e.l(McpSyncClient.class);
    private final Supplier<McpTransportContext> contextProvider;
    private final McpAsyncClient delegate;

    public McpSyncClient(McpAsyncClient mcpAsyncClient, Supplier<McpTransportContext> supplier) {
        Assert.notNull(mcpAsyncClient, "The delegate can not be null");
        Assert.notNull(supplier, "The contextProvider can not be null");
        this.delegate = mcpAsyncClient;
        this.contextProvider = supplier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Context lambda$withProvidedContext$0(Context context) {
        return context.put(McpTransportContext.KEY, this.contextProvider.get());
    }

    private <T> Mono<T> withProvidedContext(Mono<T> mono) {
        return mono.contextWrite(new Function() { // from class: io.modelcontextprotocol.client.c1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f33588a.lambda$withProvidedContext$0((Context) obj);
            }
        });
    }

    public void addRoot(McpSchema.Root root) {
        this.delegate.addRoot(root).block();
    }

    public McpSchema.CallToolResult callTool(McpSchema.CallToolRequest callToolRequest) {
        return (McpSchema.CallToolResult) withProvidedContext(this.delegate.callTool(callToolRequest)).block();
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    public boolean closeGracefully() {
        try {
            this.delegate.closeGracefully().block(Duration.ofMillis(10000L));
            return true;
        } catch (RuntimeException e10) {
            logger.c("Client didn't close within timeout of {} ms.", 10000L, e10);
            return false;
        }
    }

    public McpSchema.CompleteResult completeCompletion(McpSchema.CompleteRequest completeRequest) {
        return (McpSchema.CompleteResult) withProvidedContext(this.delegate.completeCompletion(completeRequest)).block();
    }

    public McpSchema.ClientCapabilities getClientCapabilities() {
        return this.delegate.getClientCapabilities();
    }

    public McpSchema.Implementation getClientInfo() {
        return this.delegate.getClientInfo();
    }

    public McpSchema.InitializeResult getCurrentInitializationResult() {
        return this.delegate.getCurrentInitializationResult();
    }

    public McpSchema.GetPromptResult getPrompt(McpSchema.GetPromptRequest getPromptRequest) {
        return (McpSchema.GetPromptResult) withProvidedContext(this.delegate.getPrompt(getPromptRequest)).block();
    }

    public McpSchema.ServerCapabilities getServerCapabilities() {
        return this.delegate.getServerCapabilities();
    }

    public McpSchema.Implementation getServerInfo() {
        return this.delegate.getServerInfo();
    }

    public String getServerInstructions() {
        return this.delegate.getServerInstructions();
    }

    public McpSchema.InitializeResult initialize() {
        return (McpSchema.InitializeResult) withProvidedContext(this.delegate.initialize()).block();
    }

    public boolean isInitialized() {
        return this.delegate.isInitialized();
    }

    public McpSchema.ListPromptsResult listPrompts() {
        return (McpSchema.ListPromptsResult) withProvidedContext(this.delegate.listPrompts()).block();
    }

    public McpSchema.ListResourceTemplatesResult listResourceTemplates() {
        return (McpSchema.ListResourceTemplatesResult) withProvidedContext(this.delegate.listResourceTemplates()).block();
    }

    public McpSchema.ListResourcesResult listResources() {
        return (McpSchema.ListResourcesResult) withProvidedContext(this.delegate.listResources()).block();
    }

    public McpSchema.ListToolsResult listTools() {
        return (McpSchema.ListToolsResult) withProvidedContext(this.delegate.listTools()).block();
    }

    public Object ping() {
        return withProvidedContext(this.delegate.ping()).block();
    }

    public McpSchema.ReadResourceResult readResource(McpSchema.Resource resource) {
        return (McpSchema.ReadResourceResult) withProvidedContext(this.delegate.readResource(resource)).block();
    }

    public void removeRoot(String str) {
        this.delegate.removeRoot(str).block();
    }

    public void rootsListChangedNotification() {
        withProvidedContext(this.delegate.rootsListChangedNotification()).block();
    }

    public void setLoggingLevel(McpSchema.LoggingLevel loggingLevel) {
        withProvidedContext(this.delegate.setLoggingLevel(loggingLevel)).block();
    }

    public void subscribeResource(McpSchema.SubscribeRequest subscribeRequest) {
        withProvidedContext(this.delegate.subscribeResource(subscribeRequest)).block();
    }

    public void unsubscribeResource(McpSchema.UnsubscribeRequest unsubscribeRequest) {
        withProvidedContext(this.delegate.unsubscribeResource(unsubscribeRequest)).block();
    }

    public McpSchema.ListPromptsResult listPrompts(String str) {
        return (McpSchema.ListPromptsResult) withProvidedContext(this.delegate.listPrompts(str)).block();
    }

    public McpSchema.ListResourceTemplatesResult listResourceTemplates(String str) {
        return (McpSchema.ListResourceTemplatesResult) withProvidedContext(this.delegate.listResourceTemplates(str)).block();
    }

    public McpSchema.ListResourcesResult listResources(String str) {
        return (McpSchema.ListResourcesResult) withProvidedContext(this.delegate.listResources(str)).block();
    }

    public McpSchema.ListToolsResult listTools(String str) {
        return (McpSchema.ListToolsResult) withProvidedContext(this.delegate.listTools(str)).block();
    }

    public McpSchema.ReadResourceResult readResource(McpSchema.ReadResourceRequest readResourceRequest) {
        return (McpSchema.ReadResourceResult) withProvidedContext(this.delegate.readResource(readResourceRequest)).block();
    }
}
