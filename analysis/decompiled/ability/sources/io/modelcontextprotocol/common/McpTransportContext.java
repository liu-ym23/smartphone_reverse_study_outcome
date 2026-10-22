package io.modelcontextprotocol.common;

import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public interface McpTransportContext {
    public static final McpTransportContext EMPTY = new DefaultMcpTransportContext(Collections.EMPTY_MAP);
    public static final String KEY = "MCP_TRANSPORT_CONTEXT";

    static McpTransportContext create(Map<String, Object> map) {
        return new DefaultMcpTransportContext(map);
    }

    Object get(String str);
}
