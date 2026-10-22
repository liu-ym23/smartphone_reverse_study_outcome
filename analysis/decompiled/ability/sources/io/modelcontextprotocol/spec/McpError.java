package io.modelcontextprotocol.spec;

import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.util.Assert;
import java.util.Map;
import java.util.function.Function;

/* loaded from: classes3.dex */
public class McpError extends RuntimeException {
    public static final Function<String, McpError> RESOURCE_NOT_FOUND = new E3.d(20);
    private McpSchema.JSONRPCResponse.JSONRPCError jsonRpcError;

    public static class Builder {
        private final int code;
        private Object data;
        private String message;

        public /* synthetic */ Builder(int i, int i6) {
            this(i);
        }

        public McpError build() {
            Assert.hasText(this.message, "message must not be empty");
            return new McpError(new McpSchema.JSONRPCResponse.JSONRPCError(Integer.valueOf(this.code), this.message, this.data));
        }

        public Builder data(Object obj) {
            this.data = obj;
            return this;
        }

        public Builder message(String str) {
            this.message = str;
            return this;
        }

        private Builder(int i) {
            this.code = i;
        }
    }

    public McpError(McpSchema.JSONRPCResponse.JSONRPCError jSONRPCError) {
        super(jSONRPCError.message());
        this.jsonRpcError = jSONRPCError;
    }

    public static String aggregateExceptionMessages(Throwable th) {
        Assert.notNull(th, "throwable must not be null");
        StringBuilder sb = new StringBuilder();
        while (th != null) {
            if (sb.length() > 0) {
                sb.append("\n  Caused by: ");
            }
            sb.append(th.getClass().getSimpleName());
            if (th.getMessage() != null) {
                sb.append(": ");
                sb.append(th.getMessage());
            }
            if (th.getCause() == th) {
                break;
            }
            th = th.getCause();
        }
        return sb.toString();
    }

    public static Builder builder(int i) {
        return new Builder(i, 0);
    }

    public static Throwable findRootCause(Throwable th) {
        Assert.notNull(th, "throwable must not be null");
        while (th.getCause() != null && th.getCause() != th) {
            th = th.getCause();
        }
        return th;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ McpError lambda$static$0(String str) {
        return new McpError(new McpSchema.JSONRPCResponse.JSONRPCError(Integer.valueOf(McpSchema.ErrorCodes.RESOURCE_NOT_FOUND), "Resource not found", Map.of("uri", str)));
    }

    public McpSchema.JSONRPCResponse.JSONRPCError getJsonRpcError() {
        return this.jsonRpcError;
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        if (this.jsonRpcError != null) {
            sb.append("\n");
            sb.append(this.jsonRpcError.toString());
        }
        return sb.toString();
    }

    @Deprecated
    public McpError(Object obj) {
        super(obj.toString());
    }
}
