package com.stepos.mcp.sdk.java;

import io.modelcontextprotocol.spec.McpSchema;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class DiscoveryResult {
    private final Map<String, ServerExt> exts;
    private final Map<String, List<McpSchema.Tool>> tools;

    public DiscoveryResult(Map<String, List<McpSchema.Tool>> map, Map<String, ServerExt> map2) {
        this.tools = map;
        this.exts = map2;
    }

    public Map<String, ServerExt> getExts() {
        return this.exts;
    }

    public Map<String, List<McpSchema.Tool>> getTools() {
        return this.tools;
    }
}
