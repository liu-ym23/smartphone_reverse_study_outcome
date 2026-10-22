package io.modelcontextprotocol.server;

import io.modelcontextprotocol.server.McpServerFeatures;
import java.util.function.Function;

/* loaded from: classes4.dex */
public final /* synthetic */ class Y implements Function {
    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ((McpServerFeatures.AsyncResourceTemplateSpecification) obj).resourceTemplate();
    }
}
