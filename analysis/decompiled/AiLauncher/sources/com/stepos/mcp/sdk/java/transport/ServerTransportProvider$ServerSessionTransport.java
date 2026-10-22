package com.stepos.mcp.sdk.java.transport;

import com.stepos.mcp.sdk.IMCPBinderCallback;
import com.stepos.mcp.sdk.IMCPBinderService;
import io.modelcontextprotocol.spec.McpServerTransport;

/* loaded from: classes.dex */
public class ServerTransportProvider$ServerSessionTransport implements McpServerTransport {

    /* renamed from: com.stepos.mcp.sdk.java.transport.ServerTransportProvider$ServerSessionTransport$1, reason: invalid class name */
    public class AnonymousClass1 extends IMCPBinderService.Stub {
        final /* synthetic */ ServerTransportProvider$ServerSessionTransport this$1;

        public AnonymousClass1(ServerTransportProvider$ServerSessionTransport serverTransportProvider$ServerSessionTransport) {
        }

        @Override // com.stepos.mcp.sdk.IMCPBinderService
        public void register(String str, IMCPBinderCallback iMCPBinderCallback) {
        }

        @Override // com.stepos.mcp.sdk.IMCPBinderService
        public void request(String str, String str2) {
        }

        @Override // com.stepos.mcp.sdk.IMCPBinderService
        public void unregister(String str) {
        }
    }
}
