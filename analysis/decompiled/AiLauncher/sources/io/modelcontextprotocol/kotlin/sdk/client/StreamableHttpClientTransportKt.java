package io.modelcontextprotocol.kotlin.sdk.client;

import j8.C4785k;
import j8.InterfaceC4782h;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\"\u0014\u0010\u0001\u001a\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005\"\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0005\"\u0014\u0010\u0007\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0005¨\u0006\b"}, d2 = {"Lj8/h;", "logger", "Lj8/h;", "", "MCP_SESSION_ID_HEADER", "Ljava/lang/String;", "MCP_PROTOCOL_VERSION_HEADER", "MCP_RESUMPTION_TOKEN_HEADER", "kotlin-sdk"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StreamableHttpClientTransportKt {
    private static final String MCP_PROTOCOL_VERSION_HEADER = "mcp-protocol-version";
    private static final String MCP_RESUMPTION_TOKEN_HEADER = "Last-Event-ID";
    private static final String MCP_SESSION_ID_HEADER = "mcp-session-id";
    private static final InterfaceC4782h logger = C4785k.f34533a.b(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.client.P
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return Y8.t.f7040a;
        }
    });
}
