package io.modelcontextprotocol.kotlin.sdk;

import io.modelcontextprotocol.kotlin.sdk.shared.ProtocolKt;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import qb.AbstractC5171a;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0000*\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0013\u0010\u0002\u001a\u00020\u0007*\u00020\u0006H\u0000¢\u0006\u0004\b\u0002\u0010\b\u001a\u0013\u0010\u0004\u001a\u00020\u0006*\u00020\u0007H\u0000¢\u0006\u0004\b\u0004\u0010\t\"\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\f\"\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0014\u0010\u0012\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\f\"\u001a\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u0012\u0004\b\u0016\u0010\u0017*\n\u0010\u0019\"\u00020\u00182\u00020\u0018*\n\u0010\u001a\"\u00020\n2\u00020\n¨\u0006\u001b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/Request;", "Lio/modelcontextprotocol/kotlin/sdk/JSONRPCRequest;", "toJSON", "(Lio/modelcontextprotocol/kotlin/sdk/Request;)Lio/modelcontextprotocol/kotlin/sdk/JSONRPCRequest;", "fromJSON", "(Lio/modelcontextprotocol/kotlin/sdk/JSONRPCRequest;)Lio/modelcontextprotocol/kotlin/sdk/Request;", "Lio/modelcontextprotocol/kotlin/sdk/Notification;", "Lio/modelcontextprotocol/kotlin/sdk/JSONRPCNotification;", "(Lio/modelcontextprotocol/kotlin/sdk/Notification;)Lio/modelcontextprotocol/kotlin/sdk/JSONRPCNotification;", "(Lio/modelcontextprotocol/kotlin/sdk/JSONRPCNotification;)Lio/modelcontextprotocol/kotlin/sdk/Notification;", "", "LATEST_PROTOCOL_VERSION", "Ljava/lang/String;", "", "SUPPORTED_PROTOCOL_VERSIONS", "[Ljava/lang/String;", "getSUPPORTED_PROTOCOL_VERSIONS", "()[Ljava/lang/String;", "JSONRPC_VERSION", "Lkotlin/concurrent/atomics/AtomicLong;", "REQUEST_MESSAGE_ID", "Ljava/util/concurrent/atomic/AtomicLong;", "getREQUEST_MESSAGE_ID$annotations", "()V", "Lio/modelcontextprotocol/kotlin/sdk/RequestId;", "ProgressToken", "Cursor", "kotlin-sdk"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TypesKt {
    public static final String JSONRPC_VERSION = "2.0";
    public static final String LATEST_PROTOCOL_VERSION = "2024-11-05";
    private static final String[] SUPPORTED_PROTOCOL_VERSIONS = {"2024-11-05", "2024-10-07"};
    private static final AtomicLong REQUEST_MESSAGE_ID = new AtomicLong(0);

    public static final Request fromJSON(JSONRPCRequest jSONRPCRequest) {
        kotlin.jvm.internal.p.i(jSONRPCRequest, "<this>");
        qb.D d10 = new qb.D(kotlin.collections.a.s(qb.j.j(jSONRPCRequest.getParams()), Y8.j.a("method", qb.j.c(jSONRPCRequest.getMethod()))));
        return (Request) ProtocolKt.getMcpJson().b(Types_utilKt.selectRequestDeserializer(jSONRPCRequest.getMethod()), d10);
    }

    private static /* synthetic */ void getREQUEST_MESSAGE_ID$annotations() {
    }

    public static final String[] getSUPPORTED_PROTOCOL_VERSIONS() {
        return SUPPORTED_PROTOCOL_VERSIONS;
    }

    public static final JSONRPCRequest toJSON(Request request) {
        kotlin.jvm.internal.p.i(request, "<this>");
        AbstractC5171a mcpJson = ProtocolKt.getMcpJson();
        mcpJson.getSerializersModule();
        return new JSONRPCRequest((RequestId) null, request.getMethod().getValue(), new qb.D(kotlin.collections.a.o(qb.j.j(mcpJson.d(Request.INSTANCE.serializer(), request)), "method")), "2.0", 1, (kotlin.jvm.internal.i) null);
    }

    public static final Notification fromJSON(JSONRPCNotification jSONRPCNotification) {
        kotlin.jvm.internal.p.i(jSONRPCNotification, "<this>");
        qb.D d10 = new qb.D(kotlin.collections.a.s(qb.j.j(jSONRPCNotification.getParams()), Y8.j.a("method", qb.j.c(jSONRPCNotification.getMethod()))));
        AbstractC5171a mcpJson = ProtocolKt.getMcpJson();
        mcpJson.getSerializersModule();
        return (Notification) mcpJson.b(Notification.INSTANCE.serializer(), d10);
    }

    public static final JSONRPCNotification toJSON(Notification notification) {
        kotlin.jvm.internal.p.i(notification, "<this>");
        AbstractC5171a mcpJson = ProtocolKt.getMcpJson();
        mcpJson.getSerializersModule();
        return new JSONRPCNotification(notification.getMethod().getValue(), new qb.D(kotlin.collections.a.o(qb.j.j(mcpJson.d(Notification.INSTANCE.serializer(), notification)), "method")), (String) null, 4, (kotlin.jvm.internal.i) null);
    }
}
