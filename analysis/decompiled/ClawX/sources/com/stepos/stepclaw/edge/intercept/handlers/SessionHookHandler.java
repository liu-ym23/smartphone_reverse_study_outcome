package com.stepos.stepclaw.edge.intercept.handlers;

import b5.a0;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.base.track.ClawReportBridge;
import com.stepos.stepclaw.base.track.ClawReporter;
import com.stepos.stepclaw.base.util.ALog;
import com.stepos.stepclaw.edge.intercept.model.AfterCompactionRequest;
import com.stepos.stepclaw.edge.intercept.model.BeforeCompactionRequest;
import com.stepos.stepclaw.edge.intercept.model.BeforeResetRequest;
import com.stepos.stepclaw.edge.intercept.model.HookResponseJson;
import com.stepos.stepclaw.edge.intercept.model.MessageItem;
import com.stepos.stepclaw.edge.intercept.model.SessionEndRequest;
import com.stepos.stepclaw.edge.intercept.model.SessionStartRequest;
import com.stepos.stepclaw.gateway.d;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import m0.f;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\f"}, d2 = {"Lcom/stepos/stepclaw/edge/intercept/handlers/SessionHookHandler;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "handleSessionStart", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "body", "handleSessionEnd", "handleBeforeReset", "handleBeforeCompaction", "handleAfterCompaction", "Companion", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SessionHookHandler {
    private static final String TAG = "SessionHookHandler";
    private static final Json json = JsonKt.Json$default(null, new d(28), 1, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 json$lambda$0(JsonBuilder Json) {
        p.e(Json, "$this$Json");
        Json.setIgnoreUnknownKeys(true);
        Json.setEncodeDefaults(true);
        return a0.f883a;
    }

    public final String handleAfterCompaction(String body) {
        p.e(body, "body");
        try {
            Json json2 = json;
            json2.getSerializersModule();
            AfterCompactionRequest afterCompactionRequest = (AfterCompactionRequest) json2.decodeFromString(AfterCompactionRequest.INSTANCE.serializer(), body);
            ALog.d$default(TAG, "after_compaction: sessionId=" + afterCompactionRequest.getSessionId(), null, 4, null);
            Integer originalCount = afterCompactionRequest.getOriginalCount();
            int iIntValue = originalCount != null ? originalCount.intValue() : 0;
            Integer compactedCount = afterCompactionRequest.getCompactedCount();
            int iIntValue2 = compactedCount != null ? compactedCount.intValue() : 0;
            if (iIntValue > 0 || iIntValue2 > 0) {
                ALog.i$default(TAG, "Compaction: " + iIntValue + " -> " + iIntValue2 + " messages", null, 4, null);
            }
            return HookResponseJson.INSTANCE.accepted();
        } catch (Exception e9) {
            f.l("after_compaction error: ", e9.getMessage(), TAG, e9);
            HookResponseJson hookResponseJson = HookResponseJson.INSTANCE;
            String message = e9.getMessage();
            if (message == null) {
                message = "Unknown error";
            }
            return hookResponseJson.error(message);
        }
    }

    public final String handleBeforeCompaction(String body) {
        p.e(body, "body");
        try {
            Json json2 = json;
            json2.getSerializersModule();
            BeforeCompactionRequest beforeCompactionRequest = (BeforeCompactionRequest) json2.decodeFromString(BeforeCompactionRequest.INSTANCE.serializer(), body);
            ALog.d$default(TAG, "before_compaction: sessionId=" + beforeCompactionRequest.getSessionId() + " reason=" + beforeCompactionRequest.getCompactionReason(), null, 4, null);
            List<MessageItem> messages = beforeCompactionRequest.getMessages();
            if (messages != null) {
                ALog.i$default(TAG, "Session has " + messages.size() + " messages before compaction", null, 4, null);
            }
            return HookResponseJson.INSTANCE.accepted();
        } catch (Exception e9) {
            f.l("before_compaction error: ", e9.getMessage(), TAG, e9);
            HookResponseJson hookResponseJson = HookResponseJson.INSTANCE;
            String message = e9.getMessage();
            if (message == null) {
                message = "Unknown error";
            }
            return hookResponseJson.error(message);
        }
    }

    public final String handleBeforeReset(String body) {
        p.e(body, "body");
        try {
            Json json2 = json;
            json2.getSerializersModule();
            BeforeResetRequest beforeResetRequest = (BeforeResetRequest) json2.decodeFromString(BeforeResetRequest.INSTANCE.serializer(), body);
            ALog.d$default(TAG, "before_reset: sessionId=" + beforeResetRequest.getSessionId(), null, 4, null);
            List<MessageItem> messages = beforeResetRequest.getMessages();
            if (messages != null) {
                ALog.i$default(TAG, "Session has " + messages.size() + " messages before reset", null, 4, null);
            }
            ClawReporter reporter = ClawReportBridge.INSTANCE.getReporter();
            if (reporter != null) {
                reporter.onSessionReset(beforeResetRequest.getSessionId());
            }
            return HookResponseJson.INSTANCE.accepted();
        } catch (Exception e9) {
            f.l("before_reset error: ", e9.getMessage(), TAG, e9);
            HookResponseJson hookResponseJson = HookResponseJson.INSTANCE;
            String message = e9.getMessage();
            if (message == null) {
                message = "Unknown error";
            }
            return hookResponseJson.error(message);
        }
    }

    public final String handleSessionEnd(String body) {
        p.e(body, "body");
        try {
            Json json2 = json;
            json2.getSerializersModule();
            SessionEndRequest sessionEndRequest = (SessionEndRequest) json2.decodeFromString(SessionEndRequest.INSTANCE.serializer(), body);
            ALog.d$default(TAG, "session_end: sessionId=" + sessionEndRequest.getSessionId(), null, 4, null);
            ClawReporter reporter = ClawReportBridge.INSTANCE.getReporter();
            if (reporter != null) {
                reporter.onSessionReset(sessionEndRequest.getSessionId());
            }
            return HookResponseJson.INSTANCE.accepted();
        } catch (Exception e9) {
            f.l("session_end error: ", e9.getMessage(), TAG, e9);
            HookResponseJson hookResponseJson = HookResponseJson.INSTANCE;
            String message = e9.getMessage();
            if (message == null) {
                message = "Unknown error";
            }
            return hookResponseJson.error(message);
        }
    }

    public final String handleSessionStart(String body) {
        p.e(body, "body");
        try {
            Json json2 = json;
            json2.getSerializersModule();
            SessionStartRequest sessionStartRequest = (SessionStartRequest) json2.decodeFromString(SessionStartRequest.INSTANCE.serializer(), body);
            ALog.d$default(TAG, "session_start: sessionId=" + sessionStartRequest.getSessionId(), null, 4, null);
            Map<String, String> config = sessionStartRequest.getConfig();
            if (config != null) {
                ALog.i$default(TAG, "Session config: " + config, null, 4, null);
            }
            return HookResponseJson.INSTANCE.accepted();
        } catch (Exception e9) {
            f.l("session_start error: ", e9.getMessage(), TAG, e9);
            HookResponseJson hookResponseJson = HookResponseJson.INSTANCE;
            String message = e9.getMessage();
            if (message == null) {
                message = "Unknown error";
            }
            return hookResponseJson.error(message);
        }
    }
}
