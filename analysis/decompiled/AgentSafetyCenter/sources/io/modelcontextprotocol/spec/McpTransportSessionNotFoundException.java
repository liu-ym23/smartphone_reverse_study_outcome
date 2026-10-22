package io.modelcontextprotocol.spec;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class McpTransportSessionNotFoundException extends RuntimeException {
    public McpTransportSessionNotFoundException(String str, Exception exc) {
        super(k0.a.C("Session ", str, " not found on the server"), exc);
    }

    public McpTransportSessionNotFoundException(String str) {
        super(k0.a.C("Session ", str, " not found on the server"));
    }
}
