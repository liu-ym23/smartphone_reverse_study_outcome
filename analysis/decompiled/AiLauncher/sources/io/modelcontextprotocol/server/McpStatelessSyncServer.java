package io.modelcontextprotocol.server;

import io.modelcontextprotocol.server.McpStatelessServerFeatures;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.List;
import reactor.core.publisher.Mono;

/* loaded from: classes4.dex */
public class McpStatelessSyncServer {
    private static final vc.c logger = vc.e.l(McpStatelessSyncServer.class);
    private final McpStatelessAsyncServer asyncServer;
    private final boolean immediateExecution;

    public McpStatelessSyncServer(McpStatelessAsyncServer mcpStatelessAsyncServer, boolean z10) {
        this.asyncServer = mcpStatelessAsyncServer;
        this.immediateExecution = z10;
    }

    public void addPrompt(McpStatelessServerFeatures.SyncPromptSpecification syncPromptSpecification) {
        this.asyncServer.addPrompt(McpStatelessServerFeatures.AsyncPromptSpecification.fromSync(syncPromptSpecification, this.immediateExecution)).block();
    }

    public void addResource(McpStatelessServerFeatures.SyncResourceSpecification syncResourceSpecification) {
        this.asyncServer.addResource(McpStatelessServerFeatures.AsyncResourceSpecification.fromSync(syncResourceSpecification, this.immediateExecution)).block();
    }

    public void addResourceTemplate(McpStatelessServerFeatures.SyncResourceTemplateSpecification syncResourceTemplateSpecification) {
        this.asyncServer.addResourceTemplate(McpStatelessServerFeatures.AsyncResourceTemplateSpecification.fromSync(syncResourceTemplateSpecification, this.immediateExecution)).block();
    }

    public void addTool(McpStatelessServerFeatures.SyncToolSpecification syncToolSpecification) {
        this.asyncServer.addTool(McpStatelessServerFeatures.AsyncToolSpecification.fromSync(syncToolSpecification, this.immediateExecution)).block();
    }

    public void close() {
        this.asyncServer.close();
    }

    public Mono<Void> closeGracefully() {
        return this.asyncServer.closeGracefully();
    }

    public McpSchema.ServerCapabilities getServerCapabilities() {
        return this.asyncServer.getServerCapabilities();
    }

    public McpSchema.Implementation getServerInfo() {
        return this.asyncServer.getServerInfo();
    }

    public List<McpSchema.Prompt> listPrompts() {
        return this.asyncServer.listPrompts().collectList().block();
    }

    public List<McpSchema.ResourceTemplate> listResourceTemplates() {
        return this.asyncServer.listResourceTemplates().collectList().block();
    }

    public List<McpSchema.Resource> listResources() {
        return this.asyncServer.listResources().collectList().block();
    }

    public List<McpSchema.Tool> listTools() {
        return this.asyncServer.listTools().collectList().block();
    }

    public void removePrompt(String str) {
        this.asyncServer.removePrompt(str).block();
    }

    public void removeResource(String str) {
        this.asyncServer.removeResource(str).block();
    }

    public void removeResourceTemplate(String str) {
        this.asyncServer.removeResourceTemplate(str).block();
    }

    public void removeTool(String str) {
        this.asyncServer.removeTool(str).block();
    }

    public void setProtocolVersions(List<String> list) {
        this.asyncServer.setProtocolVersions(list);
    }
}
