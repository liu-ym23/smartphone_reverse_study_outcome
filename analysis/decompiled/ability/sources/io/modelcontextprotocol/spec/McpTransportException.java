package io.modelcontextprotocol.spec;

/* loaded from: classes3.dex */
public class McpTransportException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public McpTransportException(String str) {
        super(str);
    }

    public McpTransportException(String str, Throwable th) {
        super(str, th);
    }

    public McpTransportException(Throwable th) {
        super(th);
    }

    public McpTransportException(String str, Throwable th, boolean z10, boolean z11) {
        super(str, th, z10, z11);
    }
}
