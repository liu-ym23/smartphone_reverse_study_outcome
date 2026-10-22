package com.stepos.stepclaw.edge.intercept.handlers;

import b5.a0;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.base.util.ALog;
import com.stepos.stepclaw.edge.intercept.model.GatewayStartRequest;
import com.stepos.stepclaw.edge.intercept.model.GatewayStopRequest;
import com.stepos.stepclaw.edge.intercept.model.HookResponseJson;
import com.stepos.stepclaw.gateway.d;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import m0.f;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\t"}, d2 = {"Lcom/stepos/stepclaw/edge/intercept/handlers/GatewayHookHandler;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "handleGatewayStart", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "body", "handleGatewayStop", "Companion", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GatewayHookHandler {
    private static final String TAG = "GatewayHookHandler";
    private static final Json json = JsonKt.Json$default(null, new d(26), 1, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 json$lambda$0(JsonBuilder Json) {
        p.e(Json, "$this$Json");
        Json.setIgnoreUnknownKeys(true);
        Json.setEncodeDefaults(true);
        return a0.f883a;
    }

    public final String handleGatewayStart(String body) {
        p.e(body, "body");
        try {
            Json json2 = json;
            json2.getSerializersModule();
            GatewayStartRequest gatewayStartRequest = (GatewayStartRequest) json2.decodeFromString(GatewayStartRequest.INSTANCE.serializer(), body);
            ALog.d$default(TAG, "gateway_start: gatewayId=" + gatewayStartRequest.getSessionId(), null, 4, null);
            Map<String, String> config = gatewayStartRequest.getConfig();
            if (config != null) {
                ALog.i$default(TAG, "Gateway config: " + config, null, 4, null);
            }
            return HookResponseJson.INSTANCE.accepted();
        } catch (Exception e9) {
            f.l("gateway_start error: ", e9.getMessage(), TAG, e9);
            HookResponseJson hookResponseJson = HookResponseJson.INSTANCE;
            String message = e9.getMessage();
            if (message == null) {
                message = "Unknown error";
            }
            return hookResponseJson.error(message);
        }
    }

    public final String handleGatewayStop(String body) {
        p.e(body, "body");
        try {
            Json json2 = json;
            json2.getSerializersModule();
            ALog.d$default(TAG, "gateway_stop: gatewayId=" + ((GatewayStopRequest) json2.decodeFromString(GatewayStopRequest.INSTANCE.serializer(), body)).getSessionId(), null, 4, null);
            return HookResponseJson.INSTANCE.accepted();
        } catch (Exception e9) {
            f.l("gateway_stop error: ", e9.getMessage(), TAG, e9);
            HookResponseJson hookResponseJson = HookResponseJson.INSTANCE;
            String message = e9.getMessage();
            if (message == null) {
                message = "Unknown error";
            }
            return hookResponseJson.error(message);
        }
    }
}
