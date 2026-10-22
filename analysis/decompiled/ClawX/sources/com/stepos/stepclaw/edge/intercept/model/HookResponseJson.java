package com.stepos.stepclaw.edge.intercept.model;

import b5.a0;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.edge.intercept.model.AcceptedResponse;
import com.stepos.stepclaw.provider.contract.OperationResult;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import o3.a;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/stepos/stepclaw/edge/intercept/model/HookResponseJson;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "json", "Lkotlinx/serialization/json/Json;", "getJson", "()Lkotlinx/serialization/json/Json;", "accepted", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "error", OperationResult.EXTRA_MESSAGE, "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class HookResponseJson {
    public static final HookResponseJson INSTANCE = new HookResponseJson();
    private static final Json json = JsonKt.Json$default(null, new a(5), 1, null);

    private HookResponseJson() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 json$lambda$0(JsonBuilder Json) {
        p.e(Json, "$this$Json");
        Json.setIgnoreUnknownKeys(true);
        Json.setEncodeDefaults(true);
        return a0.f883a;
    }

    public final String accepted() {
        Json json2 = json;
        AcceptedResponse.Companion companion = AcceptedResponse.INSTANCE;
        return json2.encodeToString(companion.serializer(), companion.accepted());
    }

    public final String error(String message) {
        p.e(message, "message");
        Json json2 = json;
        AcceptedResponse.Companion companion = AcceptedResponse.INSTANCE;
        return json2.encodeToString(companion.serializer(), companion.error(message));
    }

    public final Json getJson() {
        return json;
    }
}
