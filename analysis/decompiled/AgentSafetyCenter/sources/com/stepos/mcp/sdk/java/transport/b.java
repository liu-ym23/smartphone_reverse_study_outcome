package com.stepos.mcp.sdk.java.transport;

import io.modelcontextprotocol.spec.McpServerSession;
import java.util.function.Function;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements Function {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ String f2734a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f2735b;

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return AIDLServerTransportProvider.lambda$notifyClients$1(this.f2734a, this.f2735b, (McpServerSession) obj);
    }
}
