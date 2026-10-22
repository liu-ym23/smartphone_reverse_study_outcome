package com.stepos.stepclaw.edge.intercept.handlers;

import b5.a0;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.base.track.ClawReportBridge;
import com.stepos.stepclaw.base.track.ClawReporter;
import com.stepos.stepclaw.base.util.ALog;
import com.stepos.stepclaw.edge.intercept.model.HookResponseJson;
import com.stepos.stepclaw.edge.intercept.model.MessageItem;
import com.stepos.stepclaw.edge.intercept.model.MessageReceivedRequest;
import com.stepos.stepclaw.edge.intercept.model.MessageSendingRequest;
import com.stepos.stepclaw.edge.intercept.model.MessageSendingResponse;
import com.stepos.stepclaw.edge.intercept.model.MessageSentRequest;
import com.stepos.stepclaw.gateway.d;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import m0.f;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\n"}, d2 = {"Lcom/stepos/stepclaw/edge/intercept/handlers/MessageHookHandler;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "handleMessageReceived", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "body", "handleMessageSending", "handleMessageSent", "Companion", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MessageHookHandler {
    private static final String TAG = "MessageHookHandler";
    private static final Json json = JsonKt.Json$default(null, new d(27), 1, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 json$lambda$0(JsonBuilder Json) {
        p.e(Json, "$this$Json");
        Json.setIgnoreUnknownKeys(true);
        Json.setEncodeDefaults(true);
        return a0.f883a;
    }

    public final String handleMessageReceived(String body) {
        ClawReporter reporter;
        p.e(body, "body");
        try {
            Json json2 = json;
            json2.getSerializersModule();
            MessageReceivedRequest messageReceivedRequest = (MessageReceivedRequest) json2.decodeFromString(MessageReceivedRequest.INSTANCE.serializer(), body);
            ALog.d$default(TAG, "message_received: sessionId=" + messageReceivedRequest.getSessionId(), null, 4, null);
            MessageItem message = messageReceivedRequest.getMessage();
            if (message != null) {
                ALog.i$default(TAG, "Received message: role=" + message.getRole() + ", content=" + n.Q1(100, message.getContentText()) + "...", null, 4, null);
                if (p.a(message.getRole(), "user") && (reporter = ClawReportBridge.INSTANCE.getReporter()) != null) {
                    reporter.onNewTurn(messageReceivedRequest.getSessionId());
                }
            }
            return HookResponseJson.INSTANCE.accepted();
        } catch (Exception e9) {
            f.l("message_received error: ", e9.getMessage(), TAG, e9);
            HookResponseJson hookResponseJson = HookResponseJson.INSTANCE;
            String message2 = e9.getMessage();
            if (message2 == null) {
                message2 = "Unknown error";
            }
            return hookResponseJson.error(message2);
        }
    }

    public final String handleMessageSending(String body) {
        p.e(body, "body");
        try {
            Json json2 = json;
            json2.getSerializersModule();
            ALog.d$default(TAG, "message_sending: sessionId=" + ((MessageSendingRequest) json2.decodeFromString(MessageSendingRequest.INSTANCE.serializer(), body)).getSessionId(), null, 4, null);
            MessageSendingResponse.Companion companion = MessageSendingResponse.INSTANCE;
            return json2.encodeToString(companion.serializer(), companion.empty());
        } catch (Exception e9) {
            f.l("message_sending error: ", e9.getMessage(), TAG, e9);
            Json json3 = json;
            MessageSendingResponse.Companion companion2 = MessageSendingResponse.INSTANCE;
            return json3.encodeToString(companion2.serializer(), companion2.empty());
        }
    }

    public final String handleMessageSent(String body) {
        p.e(body, "body");
        try {
            Json json2 = json;
            json2.getSerializersModule();
            MessageSentRequest messageSentRequest = (MessageSentRequest) json2.decodeFromString(MessageSentRequest.INSTANCE.serializer(), body);
            ALog.d$default(TAG, "message_sent: sessionId=" + messageSentRequest.getSessionId(), null, 4, null);
            MessageItem message = messageSentRequest.getMessage();
            if (message != null) {
                ALog.i$default(TAG, "Sent message: role=" + message.getRole() + ", content=" + n.Q1(100, message.getContentText()) + "...", null, 4, null);
            }
            return HookResponseJson.INSTANCE.accepted();
        } catch (Exception e9) {
            f.l("message_sent error: ", e9.getMessage(), TAG, e9);
            HookResponseJson hookResponseJson = HookResponseJson.INSTANCE;
            String message2 = e9.getMessage();
            if (message2 == null) {
                message2 = "Unknown error";
            }
            return hookResponseJson.error(message2);
        }
    }
}
