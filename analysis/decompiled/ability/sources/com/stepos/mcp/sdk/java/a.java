package com.stepos.mcp.sdk.java;

import com.stepos.mcp.sdk.java.client.AndroidMCPClient;
import com.stepos.mcp.sdk.java.client.IClientDecorator;
import com.stepos.mcp.sdk.java.server.AndroidMCPServer;
import io.modelcontextprotocol.client.McpClient;
import io.modelcontextprotocol.spec.McpClientSession;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpSession;
import io.modelcontextprotocol.util.KeepAliveScheduler;
import java.util.List;
import java.util.function.Consumer;
import reactor.core.publisher.MonoSink;
import u3.e;
import u3.f;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Consumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3831a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a(Object obj, int i) {
        this.f3831a = i;
        this.b = obj;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.f3831a;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                ((AndroidMCPClient) obj2).addDecorator((IClientDecorator) obj);
                break;
            case 1:
                ((IClientDecorator) obj).decorate((McpClient.SyncSpec) obj2);
                break;
            case 2:
                ((McpClientSession) obj2).handle((McpSchema.JSONRPCMessage) obj);
                break;
            case 3:
                ((List) obj2).add((McpSchema.TextContent) obj);
                break;
            case 4:
                ((MonoSink) obj2).error((Throwable) obj);
                break;
            case 5:
                ((KeepAliveScheduler) obj2).lambda$start$2((Long) obj);
                break;
            case 6:
                KeepAliveScheduler.lambda$start$0((McpSession) obj2, (Throwable) obj);
                break;
            case 7:
                ((AndroidMCPServer) obj2).lambda$initTools$1((McpSchema.Tool) obj);
                break;
            default:
                ((f) obj2).a((e) obj);
                break;
        }
    }
}
