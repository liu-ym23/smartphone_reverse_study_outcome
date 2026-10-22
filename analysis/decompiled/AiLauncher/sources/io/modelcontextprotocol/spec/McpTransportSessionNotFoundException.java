package io.modelcontextprotocol.spec;

/* loaded from: classes4.dex */
public class McpTransportSessionNotFoundException extends RuntimeException {
    public McpTransportSessionNotFoundException(String str, Exception exc) {
        super("Session " + str + " not found on the server", exc);
    }

    public McpTransportSessionNotFoundException(String str) {
        super("Session " + str + " not found on the server");
    }
}
