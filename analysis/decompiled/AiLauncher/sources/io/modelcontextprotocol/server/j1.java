package io.modelcontextprotocol.server;

import io.modelcontextprotocol.server.McpStatelessServerFeatures;
import java.util.function.Function;

/* loaded from: classes4.dex */
public final /* synthetic */ class j1 implements Function {
    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ((McpStatelessServerFeatures.AsyncPromptSpecification) obj).prompt();
    }
}
