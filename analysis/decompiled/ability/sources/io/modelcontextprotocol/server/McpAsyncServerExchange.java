package io.modelcontextprotocol.server;

import io.modelcontextprotocol.common.McpTransportContext;
import io.modelcontextprotocol.json.TypeRef;
import io.modelcontextprotocol.spec.McpError;
import io.modelcontextprotocol.spec.McpLoggableSession;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpSession;
import io.modelcontextprotocol.util.Assert;
import java.util.ArrayList;
import java.util.Collections;
import reactor.core.publisher.Mono;

/* loaded from: classes3.dex */
public class McpAsyncServerExchange {
    private final McpSchema.ClientCapabilities clientCapabilities;
    private final McpSchema.Implementation clientInfo;
    private final McpLoggableSession session;
    private final String sessionId;
    private final McpTransportContext transportContext;
    private static final TypeRef<McpSchema.CreateMessageResult> CREATE_MESSAGE_RESULT_TYPE_REF = new TypeRef<McpSchema.CreateMessageResult>() { // from class: io.modelcontextprotocol.server.McpAsyncServerExchange.1
    };
    private static final TypeRef<McpSchema.ListRootsResult> LIST_ROOTS_RESULT_TYPE_REF = new TypeRef<McpSchema.ListRootsResult>() { // from class: io.modelcontextprotocol.server.McpAsyncServerExchange.2
    };
    private static final TypeRef<McpSchema.ElicitResult> ELICITATION_RESULT_TYPE_REF = new TypeRef<McpSchema.ElicitResult>() { // from class: io.modelcontextprotocol.server.McpAsyncServerExchange.3
    };
    public static final TypeRef<Object> OBJECT_TYPE_REF = new TypeRef<Object>() { // from class: io.modelcontextprotocol.server.McpAsyncServerExchange.4
    };

    @Deprecated
    public McpAsyncServerExchange(McpSession mcpSession, McpSchema.ClientCapabilities clientCapabilities, McpSchema.Implementation implementation) {
        this.sessionId = null;
        if (!(mcpSession instanceof McpLoggableSession)) {
            throw new IllegalArgumentException("Expecting session to be a McpLoggableSession instance");
        }
        this.session = (McpLoggableSession) mcpSession;
        this.clientCapabilities = clientCapabilities;
        this.clientInfo = implementation;
        this.transportContext = McpTransportContext.EMPTY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Z9.c lambda$listRoots$0(McpSchema.ListRootsResult listRootsResult) {
        return listRootsResult.nextCursor() != null ? listRoots(listRootsResult.nextCursor()) : Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ McpSchema.ListRootsResult lambda$listRoots$1(McpSchema.ListRootsResult listRootsResult, McpSchema.ListRootsResult listRootsResult2) {
        listRootsResult.roots().addAll(listRootsResult2.roots());
        return listRootsResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ McpSchema.ListRootsResult lambda$listRoots$2(McpSchema.ListRootsResult listRootsResult) {
        return new McpSchema.ListRootsResult(Collections.unmodifiableList(listRootsResult.roots()), listRootsResult.nextCursor());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$loggingNotification$3(McpSchema.LoggingMessageNotification loggingMessageNotification) {
        return this.session.isNotificationForLevelAllowed(loggingMessageNotification.level()) ? this.session.sendNotification(McpSchema.METHOD_NOTIFICATION_MESSAGE, loggingMessageNotification) : Mono.empty();
    }

    public Mono<McpSchema.ElicitResult> createElicitation(McpSchema.ElicitRequest elicitRequest) {
        McpSchema.ClientCapabilities clientCapabilities = this.clientCapabilities;
        return clientCapabilities == null ? Mono.error(new McpError("Client must be initialized. Call the initialize method first!")) : clientCapabilities.elicitation() == null ? Mono.error(new McpError("Client must be configured with elicitation capabilities")) : this.session.sendRequest(McpSchema.METHOD_ELICITATION_CREATE, elicitRequest, ELICITATION_RESULT_TYPE_REF);
    }

    public Mono<McpSchema.CreateMessageResult> createMessage(McpSchema.CreateMessageRequest createMessageRequest) {
        McpSchema.ClientCapabilities clientCapabilities = this.clientCapabilities;
        return clientCapabilities == null ? Mono.error(new McpError("Client must be initialized. Call the initialize method first!")) : clientCapabilities.sampling() == null ? Mono.error(new McpError("Client must be configured with sampling capabilities")) : this.session.sendRequest(McpSchema.METHOD_SAMPLING_CREATE_MESSAGE, createMessageRequest, CREATE_MESSAGE_RESULT_TYPE_REF);
    }

    public McpSchema.ClientCapabilities getClientCapabilities() {
        return this.clientCapabilities;
    }

    public McpSchema.Implementation getClientInfo() {
        return this.clientInfo;
    }

    public Mono<McpSchema.ListRootsResult> listRoots() {
        return listRoots(McpSchema.FIRST_PAGE).expand(new v(this, 2)).reduce(new McpSchema.ListRootsResult(new ArrayList(), null), new o(1)).map(new E3.d(14));
    }

    public Mono<Void> loggingNotification(McpSchema.LoggingMessageNotification loggingMessageNotification) {
        return loggingMessageNotification == null ? Mono.error(new McpError("Logging message must not be null")) : Mono.defer(new C1586d(5, this, loggingMessageNotification));
    }

    public Mono<Object> ping() {
        return this.session.sendRequest(McpSchema.METHOD_PING, null, OBJECT_TYPE_REF);
    }

    public Mono<Void> progressNotification(McpSchema.ProgressNotification progressNotification) {
        return progressNotification == null ? Mono.error(new McpError("Progress notification must not be null")) : this.session.sendNotification(McpSchema.METHOD_NOTIFICATION_PROGRESS, progressNotification);
    }

    public String sessionId() {
        return this.sessionId;
    }

    public void setMinLoggingLevel(McpSchema.LoggingLevel loggingLevel) {
        Assert.notNull(loggingLevel, "minLoggingLevel must not be null");
        this.session.setMinLoggingLevel(loggingLevel);
    }

    public McpTransportContext transportContext() {
        return this.transportContext;
    }

    public Mono<McpSchema.ListRootsResult> listRoots(String str) {
        return this.session.sendRequest(McpSchema.METHOD_ROOTS_LIST, new McpSchema.PaginatedRequest(str), LIST_ROOTS_RESULT_TYPE_REF);
    }

    public McpAsyncServerExchange(String str, McpLoggableSession mcpLoggableSession, McpSchema.ClientCapabilities clientCapabilities, McpSchema.Implementation implementation, McpTransportContext mcpTransportContext) {
        this.sessionId = str;
        this.session = mcpLoggableSession;
        this.clientCapabilities = clientCapabilities;
        this.clientInfo = implementation;
        this.transportContext = mcpTransportContext;
    }
}
