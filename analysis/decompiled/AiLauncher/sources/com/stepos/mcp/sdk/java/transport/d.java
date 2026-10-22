package com.stepos.mcp.sdk.java.transport;

import io.modelcontextprotocol.spec.McpServerSession;
import java.util.function.Function;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements Function {
    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ((McpServerSession) obj).closeGracefully();
    }
}
