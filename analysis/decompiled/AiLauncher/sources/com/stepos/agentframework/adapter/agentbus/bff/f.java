package com.stepos.agentframework.adapter.agentbus.bff;

import La.D;
import La.H;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.ContentDisposition;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0005\u001a\u00020\u0001*\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\t\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002¢\u0006\u0004\b\t\u0010\n\u001a\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a\u0013\u0010\u0010\u001a\u00020\b*\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/stepos/agentframework/protobuf/e;", "Lorg/json/JSONObject;", Const.INTENT_KEY_UMID, "(Lcom/stepos/agentframework/protobuf/e;)Lorg/json/JSONObject;", "Lcom/stepos/agentframework/protobuf/d;", "c", "(Lcom/stepos/agentframework/protobuf/d;)Lorg/json/JSONObject;", "", "", "e", "(Ljava/util/Map;)Lorg/json/JSONObject;", UxipConstants.f30680s, "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Ljava/lang/Object;", "Lcom/stepos/agentframework/protobuf/g;", "f", "(Lcom/stepos/agentframework/protobuf/g;)Ljava/lang/String;", "protocol_agentbus_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class f {
    public static final Object b(String str) {
        Object objB;
        Object objB2;
        String string = H.D1(str).toString();
        if (D.X(string, Const.STR_MART_JSON_BEGIN, false, 2, null)) {
            try {
                Result.Companion companion = Result.INSTANCE;
                objB = Result.b(new JSONObject(string));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            JSONObject jSONObject = (JSONObject) (Result.g(objB) ? null : objB);
            if (jSONObject != null) {
                return jSONObject;
            }
        } else if (D.X(string, "[", false, 2, null)) {
            try {
                Result.Companion companion3 = Result.INSTANCE;
                objB2 = Result.b(new JSONArray(string));
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                objB2 = Result.b(C4849c.a(th2));
            }
            JSONArray jSONArray = (JSONArray) (Result.g(objB2) ? null : objB2);
            if (jSONArray != null) {
                return jSONArray;
            }
        }
        return str;
    }

    public static final JSONObject c(com.stepos.agentframework.protobuf.d dVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(com.stepos.statsapp.v3.lib.plugin.emitter.local.storage.b.f30737d, dVar.getEventId());
        jSONObject.put("timestamp", dVar.getTimestamp());
        jSONObject.put("eventType", dVar.c().name());
        Map<String, String> metadataMap = dVar.getMetadataMap();
        kotlin.jvm.internal.p.h(metadataMap, "getMetadataMap(...)");
        if (!metadataMap.isEmpty()) {
            Map<String, String> metadataMap2 = dVar.getMetadataMap();
            kotlin.jvm.internal.p.h(metadataMap2, "getMetadataMap(...)");
            jSONObject.put("metadata", e(metadataMap2));
        }
        return jSONObject;
    }

    public static final JSONObject d(com.stepos.agentframework.protobuf.e eVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("frameType", eVar.getFrameType());
        jSONObject.put("msgType", eVar.getMsgType());
        jSONObject.put("msgId", eVar.getMsgId());
        jSONObject.put("module", eVar.getModule());
        jSONObject.put("command", eVar.getCommand());
        Map<String, String> metaMap = eVar.getMetaMap();
        kotlin.jvm.internal.p.h(metaMap, "getMetaMap(...)");
        if (!metaMap.isEmpty()) {
            Map<String, String> metaMap2 = eVar.getMetaMap();
            kotlin.jvm.internal.p.h(metaMap2, "getMetaMap(...)");
            jSONObject.put("meta", e(metaMap2));
        }
        return jSONObject;
    }

    public static final JSONObject e(Map<String, String> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            jSONObject.put(entry.getKey(), b(entry.getValue()));
        }
        return jSONObject;
    }

    public static final String f(com.stepos.agentframework.protobuf.g gVar) {
        Object objB;
        Object objB2;
        Object obj;
        try {
            Result.Companion companion = Result.INSTANCE;
            JSONObject jSONObject = new JSONObject();
            com.stepos.agentframework.protobuf.e eVarD = gVar.d();
            kotlin.jvm.internal.p.h(eVarD, "getHead(...)");
            jSONObject.put("head", d(eVarD));
            try {
                com.stepos.agentframework.protobuf.d dVarE = com.stepos.agentframework.protobuf.d.e(gVar.getBody());
                kotlin.jvm.internal.p.h(dVarE, "parseFrom(...)");
                objB2 = Result.b(c(dVarE));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB2 = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB2);
            if (thE == null) {
                obj = objB2;
            } else {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("parseError", thE.getMessage());
                jSONObject2.put(ContentDisposition.Parameters.Size, gVar.getBody().size());
                obj = jSONObject2;
            }
            jSONObject.put("body", (JSONObject) obj);
            objB = Result.b(jSONObject.toString());
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th2));
        }
        Throwable thE2 = Result.e(objB);
        if (thE2 != null) {
            objB = "toDebugString failed: " + thE2.getMessage();
        }
        return (String) objB;
    }
}
