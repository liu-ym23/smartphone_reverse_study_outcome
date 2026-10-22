package com.stepos.stepclaw.edge.intercept.model;

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
import kotlinx.serialization.json.JsonElementSerializer;
import kotlinx.serialization.json.JsonNames;
import kotlinx.serialization.json.JsonNull;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0087\b\u0018\u0000 ;2\u00020\u0001:\u0002<;Be\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rBk\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\f\u0010\u0012J'\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001dJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u001dJ\u0012\u0010 \u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u001dJ\u0012\u0010!\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\u001dJ\u0010\u0010\"\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\"\u0010#J\u0012\u0010$\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b$\u0010\u001dJ\u0012\u0010%\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b%\u0010\u001dJn\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b(\u0010\u001dJ\u0010\u0010)\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b)\u0010*J\u001a\u0010-\u001a\u00020,2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b-\u0010.R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010/\u001a\u0004\b0\u0010\u001dR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010/\u001a\u0004\b1\u0010\u001dR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010/\u001a\u0004\b2\u0010\u001dR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010/\u001a\u0004\b3\u0010\u001dR\"\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0007\u0010/\u0012\u0004\b5\u00106\u001a\u0004\b4\u0010\u001dR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u00107\u001a\u0004\b8\u0010#R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010/\u001a\u0004\b9\u0010\u001dR\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010/\u001a\u0004\b:\u0010\u001d¨\u0006="}, d2 = {"Lcom/stepos/stepclaw/edge/intercept/model/BeforeToolCallRequest;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "sessionId", "sessionKey", "toolName", "runId", "toolCallId", "Lkotlinx/serialization/json/JsonElement;", "params", "timestamp", "traceId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Ljava/lang/String;Ljava/lang/String;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lb5/a0;", "write$Self$step_edge_release", "(Lcom/stepos/stepclaw/edge/intercept/model/BeforeToolCallRequest;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "()Lkotlinx/serialization/json/JsonElement;", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/stepclaw/edge/intercept/model/BeforeToolCallRequest;", "toString", "hashCode", "()I", "other", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSessionId", "getSessionKey", "getToolName", "getRunId", "getToolCallId", "getToolCallId$annotations", "()V", "Lkotlinx/serialization/json/JsonElement;", "getParams", "getTimestamp", "getTraceId", "Companion", "$serializer", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
/* loaded from: classes.dex */
public final /* data */ class BeforeToolCallRequest {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final JsonElement params;
    private final String runId;
    private final String sessionId;
    private final String sessionKey;
    private final String timestamp;
    private final String toolCallId;
    private final String toolName;
    private final String traceId;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/stepos/stepclaw/edge/intercept/model/BeforeToolCallRequest$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stepos/stepclaw/edge/intercept/model/BeforeToolCallRequest;", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final KSerializer<BeforeToolCallRequest> serializer() {
            return BeforeToolCallRequest$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public BeforeToolCallRequest() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (JsonElement) null, (String) null, (String) null, 255, (i) null);
    }

    public static /* synthetic */ BeforeToolCallRequest copy$default(BeforeToolCallRequest beforeToolCallRequest, String str, String str2, String str3, String str4, String str5, JsonElement jsonElement, String str6, String str7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = beforeToolCallRequest.sessionId;
        }
        if ((i8 & 2) != 0) {
            str2 = beforeToolCallRequest.sessionKey;
        }
        if ((i8 & 4) != 0) {
            str3 = beforeToolCallRequest.toolName;
        }
        if ((i8 & 8) != 0) {
            str4 = beforeToolCallRequest.runId;
        }
        if ((i8 & 16) != 0) {
            str5 = beforeToolCallRequest.toolCallId;
        }
        if ((i8 & 32) != 0) {
            jsonElement = beforeToolCallRequest.params;
        }
        if ((i8 & 64) != 0) {
            str6 = beforeToolCallRequest.timestamp;
        }
        if ((i8 & 128) != 0) {
            str7 = beforeToolCallRequest.traceId;
        }
        String str8 = str6;
        String str9 = str7;
        String str10 = str5;
        JsonElement jsonElement2 = jsonElement;
        return beforeToolCallRequest.copy(str, str2, str3, str4, str10, jsonElement2, str8, str9);
    }

    public static final /* synthetic */ void write$Self$step_edge_release(BeforeToolCallRequest self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.sessionId != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.sessionId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.sessionKey != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.sessionKey);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.toolName != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.toolName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.runId != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.runId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.toolCallId != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.toolCallId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !p.a(self.params, JsonNull.INSTANCE)) {
            output.encodeSerializableElement(serialDesc, 5, JsonElementSerializer.INSTANCE, self.params);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.timestamp != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.timestamp);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 7) && self.traceId == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.traceId);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSessionKey() {
        return this.sessionKey;
    }

    /* renamed from: component3, reason: from getter */
    public final String getToolName() {
        return this.toolName;
    }

    /* renamed from: component4, reason: from getter */
    public final String getRunId() {
        return this.runId;
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
    public final String getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: component8, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    public final BeforeToolCallRequest copy(String sessionId, String sessionKey, String toolName, String runId, String toolCallId, JsonElement params, String timestamp, String traceId) {
        p.e(params, "params");
        return new BeforeToolCallRequest(sessionId, sessionKey, toolName, runId, toolCallId, params, timestamp, traceId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BeforeToolCallRequest)) {
            return false;
        }
        BeforeToolCallRequest beforeToolCallRequest = (BeforeToolCallRequest) other;
        return p.a(this.sessionId, beforeToolCallRequest.sessionId) && p.a(this.sessionKey, beforeToolCallRequest.sessionKey) && p.a(this.toolName, beforeToolCallRequest.toolName) && p.a(this.runId, beforeToolCallRequest.runId) && p.a(this.toolCallId, beforeToolCallRequest.toolCallId) && p.a(this.params, beforeToolCallRequest.params) && p.a(this.timestamp, beforeToolCallRequest.timestamp) && p.a(this.traceId, beforeToolCallRequest.traceId);
    }

    public final JsonElement getParams() {
        return this.params;
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
        String str3 = this.toolName;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.runId;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.toolCallId;
        int iHashCode5 = (this.params.hashCode() + ((iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31)) * 31;
        String str6 = this.timestamp;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.traceId;
        return iHashCode6 + (str7 != null ? str7.hashCode() : 0);
    }

    public String toString() {
        String str = this.sessionId;
        String str2 = this.sessionKey;
        String str3 = this.toolName;
        String str4 = this.runId;
        String str5 = this.toolCallId;
        JsonElement jsonElement = this.params;
        String str6 = this.timestamp;
        String str7 = this.traceId;
        StringBuilder sbV = b.v("BeforeToolCallRequest(sessionId=", str, ", sessionKey=", str2, ", toolName=");
        b.A(sbV, str3, ", runId=", str4, ", toolCallId=");
        sbV.append(str5);
        sbV.append(", params=");
        sbV.append(jsonElement);
        sbV.append(", timestamp=");
        sbV.append(str6);
        sbV.append(", traceId=");
        sbV.append(str7);
        sbV.append(")");
        return sbV.toString();
    }

    public /* synthetic */ BeforeToolCallRequest(int i8, String str, String str2, String str3, String str4, String str5, JsonElement jsonElement, String str6, String str7, SerializationConstructorMarker serializationConstructorMarker) {
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
            this.toolName = null;
        } else {
            this.toolName = str3;
        }
        if ((i8 & 8) == 0) {
            this.runId = null;
        } else {
            this.runId = str4;
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
            this.timestamp = null;
        } else {
            this.timestamp = str6;
        }
        if ((i8 & 128) == 0) {
            this.traceId = null;
        } else {
            this.traceId = str7;
        }
    }

    public BeforeToolCallRequest(String str, String str2, String str3, String str4, String str5, JsonElement params, String str6, String str7) {
        p.e(params, "params");
        this.sessionId = str;
        this.sessionKey = str2;
        this.toolName = str3;
        this.runId = str4;
        this.toolCallId = str5;
        this.params = params;
        this.timestamp = str6;
        this.traceId = str7;
    }

    public /* synthetic */ BeforeToolCallRequest(String str, String str2, String str3, String str4, String str5, JsonElement jsonElement, String str6, String str7, int i8, i iVar) {
        this((i8 & 1) != 0 ? null : str, (i8 & 2) != 0 ? null : str2, (i8 & 4) != 0 ? null : str3, (i8 & 8) != 0 ? null : str4, (i8 & 16) != 0 ? null : str5, (i8 & 32) != 0 ? JsonNull.INSTANCE : jsonElement, (i8 & 64) != 0 ? null : str6, (i8 & 128) != 0 ? null : str7);
    }

    @SerialName("toolCallId")
    @JsonNames(names = {"tool_call_id"})
    public static /* synthetic */ void getToolCallId$annotations() {
    }
}
