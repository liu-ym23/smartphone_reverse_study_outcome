package io.modelcontextprotocol.kotlin.sdk;

import Z8.C1172u;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.ame.sdk.SkillStoreKt;
import io.modelcontextprotocol.kotlin.sdk.CallToolResult;
import io.modelcontextprotocol.kotlin.sdk.LoggingMessageNotification;
import io.modelcontextprotocol.kotlin.sdk.Method;
import j8.C4785k;
import j8.InterfaceC4782h;
import kotlin.Metadata;
import lb.InterfaceC4883a;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000Z\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001f\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0007\u0010\u0005\u001a\u001f\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a\u001f\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u000e\u0010\u0005\u001a\u001f\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0010\u0010\f\u001a\u001f\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010\f\u001a\u001f\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0014\u0010\f\u001a#\u0010\u001a\u001a\u00020\u0019*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u001b\u001a#\u0010\u001c\u001a\u00020\u0019*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001c\u0010\u001b\"\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f\"\u001a\u0010 \u001a\u00020\u00178\u0000X\u0080\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#¨\u0006$"}, d2 = {"", "method", "Llb/a;", "Lio/modelcontextprotocol/kotlin/sdk/Request;", "selectRequestDeserializer", "(Ljava/lang/String;)Llb/a;", "Lio/modelcontextprotocol/kotlin/sdk/ClientRequest;", "selectClientRequestDeserializer", "Lqb/i;", "element", "Lio/modelcontextprotocol/kotlin/sdk/ClientNotification;", "selectClientNotificationDeserializer", "(Lqb/i;)Llb/a;", "Lio/modelcontextprotocol/kotlin/sdk/ServerRequest;", "selectServerRequestDeserializer", "Lio/modelcontextprotocol/kotlin/sdk/ServerNotification;", "selectServerNotificationDeserializer", "Lio/modelcontextprotocol/kotlin/sdk/ServerResult;", "selectServerResultDeserializer", "Lio/modelcontextprotocol/kotlin/sdk/ClientResult;", "selectClientResultDeserializer", "Lio/modelcontextprotocol/kotlin/sdk/CallToolResult$Companion;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "Lqb/D;", "meta", "Lio/modelcontextprotocol/kotlin/sdk/CallToolResult;", "ok", "(Lio/modelcontextprotocol/kotlin/sdk/CallToolResult$Companion;Ljava/lang/String;Lqb/D;)Lio/modelcontextprotocol/kotlin/sdk/CallToolResult;", "error", "Lj8/h;", "logger", "Lj8/h;", "EmptyJsonObject", "Lqb/D;", "getEmptyJsonObject", "()Lqb/D;", "kotlin-sdk"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Types_utilKt {
    private static final InterfaceC4782h logger = C4785k.f34533a.b(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.N
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return Y8.t.f7040a;
        }
    });
    private static final qb.D EmptyJsonObject = new qb.D(kotlin.collections.a.i());

    public static final CallToolResult error(CallToolResult.Companion companion, String content, qb.D meta) {
        kotlin.jvm.internal.p.i(companion, "<this>");
        kotlin.jvm.internal.p.i(content, "content");
        kotlin.jvm.internal.p.i(meta, "meta");
        return new CallToolResult(C1172u.e(new TextContent(content)), (qb.D) null, Boolean.TRUE, meta, 2, (kotlin.jvm.internal.i) null);
    }

    public static /* synthetic */ CallToolResult error$default(CallToolResult.Companion companion, String str, qb.D d10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            d10 = EmptyJsonObject;
        }
        return error(companion, str, d10);
    }

    public static final qb.D getEmptyJsonObject() {
        return EmptyJsonObject;
    }

    public static final CallToolResult ok(CallToolResult.Companion companion, String content, qb.D meta) {
        kotlin.jvm.internal.p.i(companion, "<this>");
        kotlin.jvm.internal.p.i(content, "content");
        kotlin.jvm.internal.p.i(meta, "meta");
        return new CallToolResult(C1172u.e(new TextContent(content)), (qb.D) null, Boolean.FALSE, meta, 2, (kotlin.jvm.internal.i) null);
    }

    public static /* synthetic */ CallToolResult ok$default(CallToolResult.Companion companion, String str, qb.D d10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            d10 = EmptyJsonObject;
        }
        return ok(companion, str, d10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC4883a<ClientNotification> selectClientNotificationDeserializer(qb.i iVar) {
        String strB = qb.j.k((qb.i) kotlin.collections.a.j(qb.j.j(iVar), "method")).getCom.stepos.ame.sdk.SkillStoreKt.SKILL_DOC_TYPE_CONTENT java.lang.String();
        if (kotlin.jvm.internal.p.d(strB, Method.Defined.NotificationsCancelled.getValue())) {
            return CancelledNotification.INSTANCE.serializer();
        }
        if (kotlin.jvm.internal.p.d(strB, Method.Defined.NotificationsProgress.getValue())) {
            return ProgressNotification.INSTANCE.serializer();
        }
        if (kotlin.jvm.internal.p.d(strB, Method.Defined.NotificationsInitialized.getValue())) {
            return InitializedNotification.INSTANCE.serializer();
        }
        if (kotlin.jvm.internal.p.d(strB, Method.Defined.NotificationsRootsListChanged.getValue())) {
            return RootsListChangedNotification.INSTANCE.serializer();
        }
        return null;
    }

    public static final InterfaceC4883a<ClientRequest> selectClientRequestDeserializer(String method) {
        kotlin.jvm.internal.p.i(method, "method");
        if (kotlin.jvm.internal.p.d(method, Method.Defined.Ping.getValue())) {
            return PingRequest.INSTANCE.serializer();
        }
        if (kotlin.jvm.internal.p.d(method, Method.Defined.Initialize.getValue())) {
            return InitializeRequest.INSTANCE.serializer();
        }
        if (kotlin.jvm.internal.p.d(method, Method.Defined.CompletionComplete.getValue())) {
            return CompleteRequest.INSTANCE.serializer();
        }
        if (kotlin.jvm.internal.p.d(method, Method.Defined.LoggingSetLevel.getValue())) {
            return LoggingMessageNotification.SetLevelRequest.INSTANCE.serializer();
        }
        if (kotlin.jvm.internal.p.d(method, Method.Defined.PromptsGet.getValue())) {
            return GetPromptRequest.INSTANCE.serializer();
        }
        if (kotlin.jvm.internal.p.d(method, Method.Defined.PromptsList.getValue())) {
            return ListPromptsRequest.INSTANCE.serializer();
        }
        if (kotlin.jvm.internal.p.d(method, Method.Defined.ResourcesList.getValue())) {
            return ListResourcesRequest.INSTANCE.serializer();
        }
        if (kotlin.jvm.internal.p.d(method, Method.Defined.ResourcesTemplatesList.getValue())) {
            return ListResourceTemplatesRequest.INSTANCE.serializer();
        }
        if (kotlin.jvm.internal.p.d(method, Method.Defined.ResourcesRead.getValue())) {
            return ReadResourceRequest.INSTANCE.serializer();
        }
        if (kotlin.jvm.internal.p.d(method, Method.Defined.ResourcesSubscribe.getValue())) {
            return SubscribeRequest.INSTANCE.serializer();
        }
        if (kotlin.jvm.internal.p.d(method, Method.Defined.ResourcesUnsubscribe.getValue())) {
            return UnsubscribeRequest.INSTANCE.serializer();
        }
        if (kotlin.jvm.internal.p.d(method, Method.Defined.ToolsCall.getValue())) {
            return CallToolRequest.INSTANCE.serializer();
        }
        if (kotlin.jvm.internal.p.d(method, Method.Defined.ToolsList.getValue())) {
            return ListToolsRequest.INSTANCE.serializer();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC4883a<ClientResult> selectClientResultDeserializer(qb.i iVar) {
        qb.D dJ = qb.j.j(iVar);
        if (dJ.containsKey(AlgorithmUpdateBundle.KEY_SUFFIX_MODEL)) {
            return CreateMessageResult.INSTANCE.serializer();
        }
        if (dJ.containsKey("roots")) {
            return ListRootsResult.INSTANCE.serializer();
        }
        return null;
    }

    public static final InterfaceC4883a<Request> selectRequestDeserializer(String method) {
        kotlin.jvm.internal.p.i(method, "method");
        InterfaceC4883a<ClientRequest> interfaceC4883aSelectClientRequestDeserializer = selectClientRequestDeserializer(method);
        if (interfaceC4883aSelectClientRequestDeserializer != null) {
            return interfaceC4883aSelectClientRequestDeserializer;
        }
        InterfaceC4883a<ServerRequest> interfaceC4883aSelectServerRequestDeserializer = selectServerRequestDeserializer(method);
        return interfaceC4883aSelectServerRequestDeserializer != null ? interfaceC4883aSelectServerRequestDeserializer : CustomRequest.INSTANCE.serializer();
    }

    public static final InterfaceC4883a<ServerNotification> selectServerNotificationDeserializer(qb.i element) {
        kotlin.jvm.internal.p.i(element, "element");
        String strB = qb.j.k((qb.i) kotlin.collections.a.j(qb.j.j(element), "method")).getCom.stepos.ame.sdk.SkillStoreKt.SKILL_DOC_TYPE_CONTENT java.lang.String();
        if (kotlin.jvm.internal.p.d(strB, Method.Defined.NotificationsCancelled.getValue())) {
            return CancelledNotification.INSTANCE.serializer();
        }
        if (kotlin.jvm.internal.p.d(strB, Method.Defined.NotificationsProgress.getValue())) {
            return ProgressNotification.INSTANCE.serializer();
        }
        if (kotlin.jvm.internal.p.d(strB, Method.Defined.NotificationsMessage.getValue())) {
            return LoggingMessageNotification.INSTANCE.serializer();
        }
        if (kotlin.jvm.internal.p.d(strB, Method.Defined.NotificationsResourcesUpdated.getValue())) {
            return ResourceUpdatedNotification.INSTANCE.serializer();
        }
        if (kotlin.jvm.internal.p.d(strB, Method.Defined.NotificationsResourcesListChanged.getValue())) {
            return ResourceListChangedNotification.INSTANCE.serializer();
        }
        if (kotlin.jvm.internal.p.d(strB, Method.Defined.ToolsList.getValue())) {
            return ToolListChangedNotification.INSTANCE.serializer();
        }
        if (kotlin.jvm.internal.p.d(strB, Method.Defined.PromptsList.getValue())) {
            return PromptListChangedNotification.INSTANCE.serializer();
        }
        return null;
    }

    public static final InterfaceC4883a<ServerRequest> selectServerRequestDeserializer(String method) {
        kotlin.jvm.internal.p.i(method, "method");
        if (kotlin.jvm.internal.p.d(method, Method.Defined.Ping.getValue())) {
            return PingRequest.INSTANCE.serializer();
        }
        if (kotlin.jvm.internal.p.d(method, Method.Defined.SamplingCreateMessage.getValue())) {
            return CreateMessageRequest.INSTANCE.serializer();
        }
        if (kotlin.jvm.internal.p.d(method, Method.Defined.RootsList.getValue())) {
            return ListRootsRequest.INSTANCE.serializer();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC4883a<ServerResult> selectServerResultDeserializer(qb.i iVar) {
        qb.D dJ = qb.j.j(iVar);
        if (dJ.containsKey("tools")) {
            return ListToolsResult.INSTANCE.serializer();
        }
        if (dJ.containsKey("resources")) {
            return ListResourcesResult.INSTANCE.serializer();
        }
        if (dJ.containsKey("resourceTemplates")) {
            return ListResourceTemplatesResult.INSTANCE.serializer();
        }
        if (dJ.containsKey("prompts")) {
            return ListPromptsResult.INSTANCE.serializer();
        }
        if (dJ.containsKey("capabilities")) {
            return InitializeResult.INSTANCE.serializer();
        }
        if (dJ.containsKey("description")) {
            return GetPromptResult.INSTANCE.serializer();
        }
        if (dJ.containsKey("completion")) {
            return CompleteResult.INSTANCE.serializer();
        }
        if (dJ.containsKey("toolResult")) {
            return CompatibilityCallToolResult.INSTANCE.serializer();
        }
        if (dJ.containsKey("contents")) {
            return ReadResourceResult.INSTANCE.serializer();
        }
        if (dJ.containsKey(SkillStoreKt.SKILL_DOC_TYPE_CONTENT)) {
            return CallToolResult.INSTANCE.serializer();
        }
        return null;
    }
}
