package io.modelcontextprotocol.server;

import io.modelcontextprotocol.server.McpServerFeatures;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.util.Assert;
import java.util.List;

/* loaded from: classes3.dex */
public class McpSyncServer {
    private final McpAsyncServer asyncServer;
    private final boolean immediateExecution;

    public McpSyncServer(McpAsyncServer mcpAsyncServer) {
        this(mcpAsyncServer, false);
    }

    public void addPrompt(McpServerFeatures.SyncPromptSpecification syncPromptSpecification) {
        this.asyncServer.addPrompt(McpServerFeatures.AsyncPromptSpecification.fromSync(syncPromptSpecification, this.immediateExecution)).block();
    }

    public void addResource(McpServerFeatures.SyncResourceSpecification syncResourceSpecification) {
        this.asyncServer.addResource(McpServerFeatures.AsyncResourceSpecification.fromSync(syncResourceSpecification, this.immediateExecution)).block();
    }

    public void addResourceTemplate(McpServerFeatures.SyncResourceTemplateSpecification syncResourceTemplateSpecification) {
        this.asyncServer.addResourceTemplate(McpServerFeatures.AsyncResourceTemplateSpecification.fromSync(syncResourceTemplateSpecification, this.immediateExecution)).block();
    }

    public void addTool(McpServerFeatures.SyncToolSpecification syncToolSpecification) {
        this.asyncServer.addTool(McpServerFeatures.AsyncToolSpecification.fromSync(syncToolSpecification, this.immediateExecution)).block();
    }

    public void close() {
        this.asyncServer.close();
    }

    public void closeGracefully() {
        this.asyncServer.closeGracefully().block();
    }

    public McpAsyncServer getAsyncServer() {
        return this.asyncServer;
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

    @Deprecated
    public void loggingNotification(McpSchema.LoggingMessageNotification loggingMessageNotification) {
        this.asyncServer.loggingNotification(loggingMessageNotification).block();
    }

    public void notifyPromptsListChanged() {
        this.asyncServer.notifyPromptsListChanged().block();
    }

    public void notifyResourcesListChanged() {
        this.asyncServer.notifyResourcesListChanged().block();
    }

    public void notifyResourcesUpdated(McpSchema.ResourcesUpdatedNotification resourcesUpdatedNotification) {
        this.asyncServer.notifyResourcesUpdated(resourcesUpdatedNotification).block();
    }

    public void notifyToolsListChanged() {
        this.asyncServer.notifyToolsListChanged().block();
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

    public McpSyncServer(McpAsyncServer mcpAsyncServer, boolean z10) {
        Assert.notNull(mcpAsyncServer, "Async server must not be null");
        this.asyncServer = mcpAsyncServer;
        this.immediateExecution = z10;
    }
}
