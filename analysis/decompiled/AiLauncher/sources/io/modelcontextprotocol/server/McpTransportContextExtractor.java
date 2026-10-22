package io.modelcontextprotocol.server;

import io.modelcontextprotocol.common.McpTransportContext;

/* loaded from: classes4.dex */
public interface McpTransportContextExtractor<T> {
    McpTransportContext extract(T t10);
}
