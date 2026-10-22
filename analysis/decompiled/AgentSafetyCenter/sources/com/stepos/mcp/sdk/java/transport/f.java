package com.stepos.mcp.sdk.java.transport;

import com.stepos.mcp.sdk.java.transport.AIDLServerTransportProvider;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpTransport;
import java.util.function.Function;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2744c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ McpTransport f2745f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f2746g;

    public /* synthetic */ f(int i) {
        this.f2744c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2744c) {
            case 0:
                ((AIDLServerTransportProvider.Transport) this.f2745f).lambda$sendMessage$0((McpSchema.JSONRPCMessage) this.f2746g);
                break;
            default:
                ((AndroidClientTransport) this.f2745f).lambda$connect$1((Function) this.f2746g);
                break;
        }
    }
}
