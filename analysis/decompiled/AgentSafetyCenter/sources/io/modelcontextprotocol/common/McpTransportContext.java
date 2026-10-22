package io.modelcontextprotocol.common;

import java.util.Collections;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface McpTransportContext {
    public static final McpTransportContext EMPTY = new DefaultMcpTransportContext(Collections.EMPTY_MAP);
    public static final String KEY = "MCP_TRANSPORT_CONTEXT";

    static McpTransportContext create(Map<String, Object> map) {
        return new DefaultMcpTransportContext(map);
    }

    Object get(String str);
}
