package com.stepos.stepclaw.edge.intercept.handlers;

import b5.a0;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.base.util.ALog;
import com.stepos.stepclaw.edge.intercept.model.HookResponseJson;
import com.stepos.stepclaw.edge.intercept.model.SubagentDeliveryTargetRequest;
import com.stepos.stepclaw.edge.intercept.model.SubagentDeliveryTargetResponse;
import com.stepos.stepclaw.edge.intercept.model.SubagentEndedRequest;
import com.stepos.stepclaw.edge.intercept.model.SubagentSpawnedRequest;
import com.stepos.stepclaw.edge.intercept.model.SubagentSpawningRequest;
import com.stepos.stepclaw.gateway.d;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import m0.f;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\u000b"}, d2 = {"Lcom/stepos/stepclaw/edge/intercept/handlers/SubagentHookHandler;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "handleSubagentSpawning", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "body", "handleSubagentDeliveryTarget", "handleSubagentSpawned", "handleSubagentEnded", "Companion", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SubagentHookHandler {
    private static final String TAG = "SubagentHookHandler";
    private static final Json json = JsonKt.Json$default(null, new d(29), 1, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 json$lambda$0(JsonBuilder Json) {
        p.e(Json, "$this$Json");
        Json.setIgnoreUnknownKeys(true);
        Json.setEncodeDefaults(true);
        return a0.f883a;
    }

    public final String handleSubagentDeliveryTarget(String body) {
        p.e(body, "body");
        try {
            Json json2 = json;
            json2.getSerializersModule();
            SubagentDeliveryTargetRequest subagentDeliveryTargetRequest = (SubagentDeliveryTargetRequest) json2.decodeFromString(SubagentDeliveryTargetRequest.INSTANCE.serializer(), body);
            ALog.d$default(TAG, "subagent_delivery_target: sessionId=" + subagentDeliveryTargetRequest.getSessionId() + " originalTarget=" + subagentDeliveryTargetRequest.getOriginalTarget(), null, 4, null);
            SubagentDeliveryTargetResponse.Companion companion = SubagentDeliveryTargetResponse.INSTANCE;
            return json2.encodeToString(companion.serializer(), companion.empty());
        } catch (Exception e9) {
            f.l("subagent_delivery_target error: ", e9.getMessage(), TAG, e9);
            Json json3 = json;
            SubagentDeliveryTargetResponse.Companion companion2 = SubagentDeliveryTargetResponse.INSTANCE;
            return json3.encodeToString(companion2.serializer(), companion2.empty());
        }
    }

    public final String handleSubagentEnded(String body) {
        p.e(body, "body");
        try {
            Json json2 = json;
            json2.getSerializersModule();
            SubagentEndedRequest subagentEndedRequest = (SubagentEndedRequest) json2.decodeFromString(SubagentEndedRequest.INSTANCE.serializer(), body);
            ALog.d$default(TAG, "subagent_ended: sessionId=" + subagentEndedRequest.getSessionId() + " parentSessionId=" + subagentEndedRequest.getParentSessionId(), null, 4, null);
            return HookResponseJson.INSTANCE.accepted();
        } catch (Exception e9) {
            f.l("subagent_ended error: ", e9.getMessage(), TAG, e9);
            HookResponseJson hookResponseJson = HookResponseJson.INSTANCE;
            String message = e9.getMessage();
            if (message == null) {
                message = "Unknown error";
            }
            return hookResponseJson.error(message);
        }
    }

    public final String handleSubagentSpawned(String body) {
        p.e(body, "body");
        try {
            Json json2 = json;
            json2.getSerializersModule();
            SubagentSpawnedRequest subagentSpawnedRequest = (SubagentSpawnedRequest) json2.decodeFromString(SubagentSpawnedRequest.INSTANCE.serializer(), body);
            ALog.d$default(TAG, "subagent_spawned: parentSessionId=" + subagentSpawnedRequest.getParentSessionId() + " subagentSessionId=" + subagentSpawnedRequest.getSubagentSessionId(), null, 4, null);
            return HookResponseJson.INSTANCE.accepted();
        } catch (Exception e9) {
            f.l("subagent_spawned error: ", e9.getMessage(), TAG, e9);
            HookResponseJson hookResponseJson = HookResponseJson.INSTANCE;
            String message = e9.getMessage();
            if (message == null) {
                message = "Unknown error";
            }
            return hookResponseJson.error(message);
        }
    }

    public final String handleSubagentSpawning(String body) {
        p.e(body, "body");
        try {
            Json json2 = json;
            json2.getSerializersModule();
            SubagentSpawningRequest subagentSpawningRequest = (SubagentSpawningRequest) json2.decodeFromString(SubagentSpawningRequest.INSTANCE.serializer(), body);
            ALog.d$default(TAG, "subagent_spawning: parentSessionId=" + subagentSpawningRequest.getParentSessionId(), null, 4, null);
            Map<String, String> subagentConfig = subagentSpawningRequest.getSubagentConfig();
            if (subagentConfig != null) {
                ALog.i$default(TAG, "Subagent config: " + subagentConfig, null, 4, null);
            }
            return HookResponseJson.INSTANCE.accepted();
        } catch (Exception e9) {
            f.l("subagent_spawning error: ", e9.getMessage(), TAG, e9);
            HookResponseJson hookResponseJson = HookResponseJson.INSTANCE;
            String message = e9.getMessage();
            if (message == null) {
                message = "Unknown error";
            }
            return hookResponseJson.error(message);
        }
    }
}
