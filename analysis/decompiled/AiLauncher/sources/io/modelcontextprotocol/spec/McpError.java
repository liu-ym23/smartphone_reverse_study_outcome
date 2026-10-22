package io.modelcontextprotocol.spec;

import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.util.Assert;
import java.util.Map;
import java.util.function.Function;

/* loaded from: classes4.dex */
public class McpError extends RuntimeException {
    public static final Function<String, McpError> RESOURCE_NOT_FOUND = new Function() { // from class: io.modelcontextprotocol.spec.w
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return McpError.a((String) obj);
        }
    };
    private McpSchema.JSONRPCResponse.JSONRPCError jsonRpcError;

    public static class Builder {
        private final int code;
        private Object data;
        private String message;

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

        private Builder(int i10) {
            this.code = i10;
        }
    }

    public McpError(McpSchema.JSONRPCResponse.JSONRPCError jSONRPCError) {
        super(jSONRPCError.message());
        this.jsonRpcError = jSONRPCError;
    }

    public static /* synthetic */ McpError a(String str) {
        return new McpError(new McpSchema.JSONRPCResponse.JSONRPCError(Integer.valueOf(McpSchema.ErrorCodes.RESOURCE_NOT_FOUND), "Resource not found", Map.of("uri", str)));
    }

    public static String aggregateExceptionMessages(Throwable th) {
        Assert.notNull(th, "throwable must not be null");
        StringBuilder sb2 = new StringBuilder();
        while (th != null) {
            if (sb2.length() > 0) {
                sb2.append("\n  Caused by: ");
            }
            sb2.append(th.getClass().getSimpleName());
            if (th.getMessage() != null) {
                sb2.append(": ");
                sb2.append(th.getMessage());
            }
            if (th.getCause() == th) {
                break;
            }
            th = th.getCause();
        }
        return sb2.toString();
    }

    public static Builder builder(int i10) {
        return new Builder(i10);
    }

    public static Throwable findRootCause(Throwable th) {
        Assert.notNull(th, "throwable must not be null");
        while (th.getCause() != null && th.getCause() != th) {
            th = th.getCause();
        }
        return th;
    }

    public McpSchema.JSONRPCResponse.JSONRPCError getJsonRpcError() {
        return this.jsonRpcError;
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb2 = new StringBuilder(super.toString());
        if (this.jsonRpcError != null) {
            sb2.append("\n");
            sb2.append(this.jsonRpcError.toString());
        }
        return sb2.toString();
    }

    @Deprecated
    public McpError(Object obj) {
        super(obj.toString());
    }
}
