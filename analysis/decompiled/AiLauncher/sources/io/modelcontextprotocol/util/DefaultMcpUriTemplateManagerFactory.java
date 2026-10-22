package io.modelcontextprotocol.util;

/* loaded from: classes4.dex */
public class DefaultMcpUriTemplateManagerFactory implements McpUriTemplateManagerFactory {
    @Override // io.modelcontextprotocol.util.McpUriTemplateManagerFactory
    public McpUriTemplateManager create(String str) {
        return new DefaultMcpUriTemplateManager(str);
    }
}
