package io.modelcontextprotocol.common;

import io.modelcontextprotocol.util.Assert;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
class DefaultMcpTransportContext implements McpTransportContext {
    private final Map<String, Object> metadata;

    public DefaultMcpTransportContext(Map<String, Object> map) {
        Assert.notNull(map, "The metadata cannot be null");
        this.metadata = map;
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.metadata.equals(((DefaultMcpTransportContext) obj).metadata);
    }

    @Override // io.modelcontextprotocol.common.McpTransportContext
    public Object get(String str) {
        return this.metadata.get(str);
    }

    public int hashCode() {
        return this.metadata.hashCode();
    }
}
