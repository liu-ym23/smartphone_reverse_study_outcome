package io.modelcontextprotocol.server;

import io.modelcontextprotocol.server.McpStatelessServerFeatures;
import java.util.function.Function;

/* loaded from: classes4.dex */
public final /* synthetic */ class E0 implements Function {
    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ((McpStatelessServerFeatures.AsyncToolSpecification) obj).tool();
    }
}
