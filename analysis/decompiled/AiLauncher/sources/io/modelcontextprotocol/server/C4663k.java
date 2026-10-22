package io.modelcontextprotocol.server;

import io.modelcontextprotocol.server.McpServerFeatures;
import java.util.function.Function;

/* renamed from: io.modelcontextprotocol.server.k, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final /* synthetic */ class C4663k implements Function {
    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ((McpServerFeatures.AsyncToolSpecification) obj).tool();
    }
}
