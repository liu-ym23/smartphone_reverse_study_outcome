package com.stepos.ability.mcpserver.model;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/stepos/ability/mcpserver/model/McpErrorCode;", "", AppAgent.CONSTRUCT, "()V", "PARSE_ERROR", "", "INVALID_REQUEST", "METHOD_NOT_FOUND", "INVALID_PARAMS", "INTERNAL_ERROR", "UNAUTHORIZED", "TOKEN_EXPIRED", "PERMISSION_DENIED", "TOOL_NOT_FOUND", "TIMEOUT", "RATE_LIMITED", "EXECUTION_FAILED", "SERVICE_UNAVAILABLE", "server_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class McpErrorCode {
    public static final int EXECUTION_FAILED = 500;
    public static final McpErrorCode INSTANCE = new McpErrorCode();
    public static final int INTERNAL_ERROR = -32603;
    public static final int INVALID_PARAMS = -32602;
    public static final int INVALID_REQUEST = -32600;
    public static final int METHOD_NOT_FOUND = -32601;
    public static final int PARSE_ERROR = -32700;
    public static final int PERMISSION_DENIED = 403;
    public static final int RATE_LIMITED = 429;
    public static final int SERVICE_UNAVAILABLE = 503;
    public static final int TIMEOUT = 408;
    public static final int TOKEN_EXPIRED = 419;
    public static final int TOOL_NOT_FOUND = 404;
    public static final int UNAUTHORIZED = 401;

    private McpErrorCode() {
    }
}
