package io.modelcontextprotocol.spec;

/* loaded from: classes3.dex */
public class McpTransportSessionNotFoundException extends RuntimeException {
    public McpTransportSessionNotFoundException(String str, Exception exc) {
        super(B7.a.m("Session ", str, " not found on the server"), exc);
    }

    public McpTransportSessionNotFoundException(String str) {
        super(B7.a.m("Session ", str, " not found on the server"));
    }
}
