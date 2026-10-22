package com.stepos.stepclaw.edge.intercept.model;

import a8.b;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.provider.contract.OperationResult;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;
import kotlinx.serialization.json.JsonNull;
import m0.f;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u0000 02\u00020\u0001:\u000210BA\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nBM\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000fJ'\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001aJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001aJ\u0010\u0010\u001d\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u001aJJ\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\"\u0010\u001aJ\u0010\u0010#\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b#\u0010$J\u001a\u0010'\u001a\u00020&2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b'\u0010(R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010)\u001a\u0004\b*\u0010\u001aR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010)\u001a\u0004\b+\u0010\u001aR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010)\u001a\u0004\b,\u0010\u001aR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010-\u001a\u0004\b.\u0010\u001eR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010)\u001a\u0004\b/\u0010\u001a¨\u00062"}, d2 = {"Lcom/stepos/stepclaw/edge/intercept/model/ToolResultPersistRequest;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "sessionId", "toolName", "result", "Lkotlinx/serialization/json/JsonElement;", OperationResult.EXTRA_MESSAGE, "traceId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Ljava/lang/String;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lb5/a0;", "write$Self$step_edge_release", "(Lcom/stepos/stepclaw/edge/intercept/model/ToolResultPersistRequest;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "()Lkotlinx/serialization/json/JsonElement;", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Ljava/lang/String;)Lcom/stepos/stepclaw/edge/intercept/model/ToolResultPersistRequest;", "toString", "hashCode", "()I", "other", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSessionId", "getToolName", "getResult", "Lkotlinx/serialization/json/JsonElement;", "getMessage", "getTraceId", "Companion", "$serializer", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
/* loaded from: classes.dex */
public final /* data */ class ToolResultPersistRequest {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final JsonElement message;
    private final String result;
    private final String sessionId;
    private final String toolName;
    private final String traceId;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/stepos/stepclaw/edge/intercept/model/ToolResultPersistRequest$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stepos/stepclaw/edge/intercept/model/ToolResultPersistRequest;", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final KSerializer<ToolResultPersistRequest> serializer() {
            return ToolResultPersistRequest$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public ToolResultPersistRequest() {
        this((String) null, (String) null, (String) null, (JsonElement) null, (String) null, 31, (i) null);
    }

    public static /* synthetic */ ToolResultPersistRequest copy$default(ToolResultPersistRequest toolResultPersistRequest, String str, String str2, String str3, JsonElement jsonElement, String str4, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = toolResultPersistRequest.sessionId;
        }
        if ((i8 & 2) != 0) {
            str2 = toolResultPersistRequest.toolName;
        }
        if ((i8 & 4) != 0) {
            str3 = toolResultPersistRequest.result;
        }
        if ((i8 & 8) != 0) {
            jsonElement = toolResultPersistRequest.message;
        }
        if ((i8 & 16) != 0) {
            str4 = toolResultPersistRequest.traceId;
        }
        String str5 = str4;
        String str6 = str3;
        return toolResultPersistRequest.copy(str, str2, str6, jsonElement, str5);
    }

    public static final /* synthetic */ void write$Self$step_edge_release(ToolResultPersistRequest self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.sessionId != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.sessionId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.toolName != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.toolName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.result != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.result);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !p.a(self.message, JsonNull.INSTANCE)) {
            output.encodeSerializableElement(serialDesc, 3, JsonElementSerializer.INSTANCE, self.message);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.traceId == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.traceId);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getToolName() {
        return this.toolName;
    }

    /* renamed from: component3, reason: from getter */
    public final String getResult() {
        return this.result;
    }

    /* renamed from: component4, reason: from getter */
    public final JsonElement getMessage() {
        return this.message;
    }

    /* renamed from: component5, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    public final ToolResultPersistRequest copy(String sessionId, String toolName, String result, JsonElement message, String traceId) {
        p.e(message, "message");
        return new ToolResultPersistRequest(sessionId, toolName, result, message, traceId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToolResultPersistRequest)) {
            return false;
        }
        ToolResultPersistRequest toolResultPersistRequest = (ToolResultPersistRequest) other;
        return p.a(this.sessionId, toolResultPersistRequest.sessionId) && p.a(this.toolName, toolResultPersistRequest.toolName) && p.a(this.result, toolResultPersistRequest.result) && p.a(this.message, toolResultPersistRequest.message) && p.a(this.traceId, toolResultPersistRequest.traceId);
    }

    public final JsonElement getMessage() {
        return this.message;
    }

    public final String getResult() {
        return this.result;
    }

    public final String getSessionId() {
        return this.sessionId;
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
        String str2 = this.toolName;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.result;
        int iHashCode3 = (this.message.hashCode() + ((iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31)) * 31;
        String str4 = this.traceId;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        String str = this.sessionId;
        String str2 = this.toolName;
        String str3 = this.result;
        JsonElement jsonElement = this.message;
        String str4 = this.traceId;
        StringBuilder sbV = b.v("ToolResultPersistRequest(sessionId=", str, ", toolName=", str2, ", result=");
        sbV.append(str3);
        sbV.append(", message=");
        sbV.append(jsonElement);
        sbV.append(", traceId=");
        return f.f(sbV, str4, ")");
    }

    public /* synthetic */ ToolResultPersistRequest(int i8, String str, String str2, String str3, JsonElement jsonElement, String str4, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i8 & 1) == 0) {
            this.sessionId = null;
        } else {
            this.sessionId = str;
        }
        if ((i8 & 2) == 0) {
            this.toolName = null;
        } else {
            this.toolName = str2;
        }
        if ((i8 & 4) == 0) {
            this.result = null;
        } else {
            this.result = str3;
        }
        if ((i8 & 8) == 0) {
            this.message = JsonNull.INSTANCE;
        } else {
            this.message = jsonElement;
        }
        if ((i8 & 16) == 0) {
            this.traceId = null;
        } else {
            this.traceId = str4;
        }
    }

    public ToolResultPersistRequest(String str, String str2, String str3, JsonElement message, String str4) {
        p.e(message, "message");
        this.sessionId = str;
        this.toolName = str2;
        this.result = str3;
        this.message = message;
        this.traceId = str4;
    }

    public /* synthetic */ ToolResultPersistRequest(String str, String str2, String str3, JsonElement jsonElement, String str4, int i8, i iVar) {
        this((i8 & 1) != 0 ? null : str, (i8 & 2) != 0 ? null : str2, (i8 & 4) != 0 ? null : str3, (i8 & 8) != 0 ? JsonNull.INSTANCE : jsonElement, (i8 & 16) != 0 ? null : str4);
    }
}
