package com.stepos.stepclaw.edge.intercept.model;

import a.a;
import a8.b;
import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonElementSerializer;
import kotlinx.serialization.json.JsonNames;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0087\b\u0018\u0000 C2\u00020\u0001:\u0002DCB{\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000e\u0010\u000fB\u007f\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u000e\u0010\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0016J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0016J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0016J\u0010\u0010\u001b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001cJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0016J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0016J\u0012\u0010 \u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u0016J\u0084\u0001\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b#\u0010\u0016J\u0010\u0010$\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b$\u0010%J\u001a\u0010(\u001a\u00020'2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b(\u0010)J'\u00102\u001a\u00020/2\u0006\u0010*\u001a\u00020\u00002\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-H\u0001¢\u0006\u0004\b0\u00101R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00103\u001a\u0004\b4\u0010\u0016R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u00103\u001a\u0004\b5\u0010\u0016R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u00103\u001a\u0004\b6\u0010\u0016R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u00103\u001a\u0004\b7\u0010\u0016R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0007\u00103\u0012\u0004\b9\u0010:\u001a\u0004\b8\u0010\u0016R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010;\u001a\u0004\b<\u0010\u001cR\u0017\u0010\n\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\n\u0010;\u001a\u0004\b=\u0010\u001cR\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u00103\u001a\u0004\b>\u0010\u0016R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u00103\u001a\u0004\b?\u0010\u0016R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\r\u00103\u001a\u0004\b@\u0010\u0016R\u0013\u0010B\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\bA\u0010\u0016¨\u0006E"}, d2 = {"Lcom/stepos/stepclaw/edge/intercept/model/AfterToolCallRequest;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "sessionId", "sessionKey", "runId", "toolName", "toolCallId", "Lkotlinx/serialization/json/JsonElement;", "params", "result", "error", "timestamp", "traceId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Lkotlinx/serialization/json/JsonElement;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Lkotlinx/serialization/json/JsonElement;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "()Lkotlinx/serialization/json/JsonElement;", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Lkotlinx/serialization/json/JsonElement;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/stepclaw/edge/intercept/model/AfterToolCallRequest;", "toString", "hashCode", "()I", "other", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "equals", "(Ljava/lang/Object;)Z", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lb5/a0;", "write$Self$step_edge_release", "(Lcom/stepos/stepclaw/edge/intercept/model/AfterToolCallRequest;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ljava/lang/String;", "getSessionId", "getSessionKey", "getRunId", "getToolName", "getToolCallId", "getToolCallId$annotations", "()V", "Lkotlinx/serialization/json/JsonElement;", "getParams", "getResult", "getError", "getTimestamp", "getTraceId", "getResultText", "resultText", "Companion", "$serializer", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
/* loaded from: classes.dex */
public final /* data */ class AfterToolCallRequest {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String error;
    private final JsonElement params;
    private final JsonElement result;
    private final String runId;
    private final String sessionId;
    private final String sessionKey;
    private final String timestamp;
    private final String toolCallId;
    private final String toolName;
    private final String traceId;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/stepos/stepclaw/edge/intercept/model/AfterToolCallRequest$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stepos/stepclaw/edge/intercept/model/AfterToolCallRequest;", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final KSerializer<AfterToolCallRequest> serializer() {
            return AfterToolCallRequest$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public AfterToolCallRequest() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (JsonElement) null, (JsonElement) null, (String) null, (String) null, (String) null, 1023, (i) null);
    }

    public static /* synthetic */ AfterToolCallRequest copy$default(AfterToolCallRequest afterToolCallRequest, String str, String str2, String str3, String str4, String str5, JsonElement jsonElement, JsonElement jsonElement2, String str6, String str7, String str8, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = afterToolCallRequest.sessionId;
        }
        if ((i8 & 2) != 0) {
            str2 = afterToolCallRequest.sessionKey;
        }
        if ((i8 & 4) != 0) {
            str3 = afterToolCallRequest.runId;
        }
        if ((i8 & 8) != 0) {
            str4 = afterToolCallRequest.toolName;
        }
        if ((i8 & 16) != 0) {
            str5 = afterToolCallRequest.toolCallId;
        }
        if ((i8 & 32) != 0) {
            jsonElement = afterToolCallRequest.params;
        }
        if ((i8 & 64) != 0) {
            jsonElement2 = afterToolCallRequest.result;
        }
        if ((i8 & 128) != 0) {
            str6 = afterToolCallRequest.error;
        }
        if ((i8 & 256) != 0) {
            str7 = afterToolCallRequest.timestamp;
        }
        if ((i8 & 512) != 0) {
            str8 = afterToolCallRequest.traceId;
        }
        String str9 = str7;
        String str10 = str8;
        JsonElement jsonElement3 = jsonElement2;
        String str11 = str6;
        String str12 = str5;
        JsonElement jsonElement4 = jsonElement;
        return afterToolCallRequest.copy(str, str2, str3, str4, str12, jsonElement4, jsonElement3, str11, str9, str10);
    }

    public static final /* synthetic */ void write$Self$step_edge_release(AfterToolCallRequest self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.sessionId != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.sessionId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.sessionKey != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.sessionKey);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.runId != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.runId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.toolName != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.toolName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.toolCallId != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.toolCallId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !p.a(self.params, JsonNull.INSTANCE)) {
            output.encodeSerializableElement(serialDesc, 5, JsonElementSerializer.INSTANCE, self.params);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || !p.a(self.result, JsonNull.INSTANCE)) {
            output.encodeSerializableElement(serialDesc, 6, JsonElementSerializer.INSTANCE, self.result);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.error != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.error);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.timestamp != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.timestamp);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 9) && self.traceId == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.traceId);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: component10, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSessionKey() {
        return this.sessionKey;
    }

    /* renamed from: component3, reason: from getter */
    public final String getRunId() {
        return this.runId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getToolName() {
        return this.toolName;
    }

    /* renamed from: component5, reason: from getter */
    public final String getToolCallId() {
        return this.toolCallId;
    }

    /* renamed from: component6, reason: from getter */
    public final JsonElement getParams() {
        return this.params;
    }

    /* renamed from: component7, reason: from getter */
    public final JsonElement getResult() {
        return this.result;
    }

    /* renamed from: component8, reason: from getter */
    public final String getError() {
        return this.error;
    }

    /* renamed from: component9, reason: from getter */
    public final String getTimestamp() {
        return this.timestamp;
    }

    public final AfterToolCallRequest copy(String sessionId, String sessionKey, String runId, String toolName, String toolCallId, JsonElement params, JsonElement result, String error, String timestamp, String traceId) {
        p.e(params, "params");
        p.e(result, "result");
        return new AfterToolCallRequest(sessionId, sessionKey, runId, toolName, toolCallId, params, result, error, timestamp, traceId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AfterToolCallRequest)) {
            return false;
        }
        AfterToolCallRequest afterToolCallRequest = (AfterToolCallRequest) other;
        return p.a(this.sessionId, afterToolCallRequest.sessionId) && p.a(this.sessionKey, afterToolCallRequest.sessionKey) && p.a(this.runId, afterToolCallRequest.runId) && p.a(this.toolName, afterToolCallRequest.toolName) && p.a(this.toolCallId, afterToolCallRequest.toolCallId) && p.a(this.params, afterToolCallRequest.params) && p.a(this.result, afterToolCallRequest.result) && p.a(this.error, afterToolCallRequest.error) && p.a(this.timestamp, afterToolCallRequest.timestamp) && p.a(this.traceId, afterToolCallRequest.traceId);
    }

    public final String getError() {
        return this.error;
    }

    public final JsonElement getParams() {
        return this.params;
    }

    public final JsonElement getResult() {
        return this.result;
    }

    public final String getResultText() {
        Object objO;
        if (p.a(this.result, JsonNull.INSTANCE) || p.a(this.result.toString(), AbstractJsonLexerKt.NULL)) {
            return null;
        }
        try {
            objO = JsonElementKt.getJsonPrimitive(this.result).getContent();
        } catch (Throwable th) {
            objO = a.o(th);
        }
        if (b5.i.a(objO) != null) {
            objO = this.result.toString();
        }
        return (String) objO;
    }

    public final String getRunId() {
        return this.runId;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getSessionKey() {
        return this.sessionKey;
    }

    public final String getTimestamp() {
        return this.timestamp;
    }

    public final String getToolCallId() {
        return this.toolCallId;
    }

    public final String getToolName() {
        return this.toolName;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public int hashCode() {
        String str = this.sessionId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.sessionKey;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.runId;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.toolName;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.toolCallId;
        int iHashCode5 = (this.result.hashCode() + ((this.params.hashCode() + ((iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31)) * 31)) * 31;
        String str6 = this.error;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.timestamp;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.traceId;
        return iHashCode7 + (str8 != null ? str8.hashCode() : 0);
    }

    public String toString() {
        String str = this.sessionId;
        String str2 = this.sessionKey;
        String str3 = this.runId;
        String str4 = this.toolName;
        String str5 = this.toolCallId;
        JsonElement jsonElement = this.params;
        JsonElement jsonElement2 = this.result;
        String str6 = this.error;
        String str7 = this.timestamp;
        String str8 = this.traceId;
        StringBuilder sbV = b.v("AfterToolCallRequest(sessionId=", str, ", sessionKey=", str2, ", runId=");
        b.A(sbV, str3, ", toolName=", str4, ", toolCallId=");
        sbV.append(str5);
        sbV.append(", params=");
        sbV.append(jsonElement);
        sbV.append(", result=");
        sbV.append(jsonElement2);
        sbV.append(", error=");
        sbV.append(str6);
        sbV.append(", timestamp=");
        sbV.append(str7);
        sbV.append(", traceId=");
        sbV.append(str8);
        sbV.append(")");
        return sbV.toString();
    }

    public /* synthetic */ AfterToolCallRequest(int i8, String str, String str2, String str3, String str4, String str5, JsonElement jsonElement, JsonElement jsonElement2, String str6, String str7, String str8, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i8 & 1) == 0) {
            this.sessionId = null;
        } else {
            this.sessionId = str;
        }
        if ((i8 & 2) == 0) {
            this.sessionKey = null;
        } else {
            this.sessionKey = str2;
        }
        if ((i8 & 4) == 0) {
            this.runId = null;
        } else {
            this.runId = str3;
        }
        if ((i8 & 8) == 0) {
            this.toolName = null;
        } else {
            this.toolName = str4;
        }
        if ((i8 & 16) == 0) {
            this.toolCallId = null;
        } else {
            this.toolCallId = str5;
        }
        if ((i8 & 32) == 0) {
            this.params = JsonNull.INSTANCE;
        } else {
            this.params = jsonElement;
        }
        if ((i8 & 64) == 0) {
            this.result = JsonNull.INSTANCE;
        } else {
            this.result = jsonElement2;
        }
        if ((i8 & 128) == 0) {
            this.error = null;
        } else {
            this.error = str6;
        }
        if ((i8 & 256) == 0) {
            this.timestamp = null;
        } else {
            this.timestamp = str7;
        }
        if ((i8 & 512) == 0) {
            this.traceId = null;
        } else {
            this.traceId = str8;
        }
    }

    public AfterToolCallRequest(String str, String str2, String str3, String str4, String str5, JsonElement params, JsonElement result, String str6, String str7, String str8) {
        p.e(params, "params");
        p.e(result, "result");
        this.sessionId = str;
        this.sessionKey = str2;
        this.runId = str3;
        this.toolName = str4;
        this.toolCallId = str5;
        this.params = params;
        this.result = result;
        this.error = str6;
        this.timestamp = str7;
        this.traceId = str8;
    }

    public /* synthetic */ AfterToolCallRequest(String str, String str2, String str3, String str4, String str5, JsonElement jsonElement, JsonElement jsonElement2, String str6, String str7, String str8, int i8, i iVar) {
        this((i8 & 1) != 0 ? null : str, (i8 & 2) != 0 ? null : str2, (i8 & 4) != 0 ? null : str3, (i8 & 8) != 0 ? null : str4, (i8 & 16) != 0 ? null : str5, (i8 & 32) != 0 ? JsonNull.INSTANCE : jsonElement, (i8 & 64) != 0 ? JsonNull.INSTANCE : jsonElement2, (i8 & 128) != 0 ? null : str6, (i8 & 256) != 0 ? null : str7, (i8 & 512) != 0 ? null : str8);
    }

    @SerialName("toolCallId")
    @JsonNames(names = {"tool_call_id"})
    public static /* synthetic */ void getToolCallId$annotations() {
    }
}
