package com.stepos.stepclaw.edge.intercept.model;

import a8.b;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.bridge.spi.ConfigIpcContract;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0087\b\u0018\u0000 J2\u00020\u0001:\u0002KJB\u0097\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013B\u0093\u0001\b\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0012\u0010\u0017J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0019J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0019J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0019J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0019J\u0012\u0010 \u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u0019J\u0012\u0010!\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b!\u0010\"J\u0012\u0010#\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b#\u0010\u0019J\u0012\u0010$\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b$\u0010\u0019J\u0012\u0010%\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b%\u0010\u0019J\u0012\u0010&\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b&\u0010'J \u0001\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b*\u0010\u0019J\u0010\u0010+\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b+\u0010,J\u001a\u0010/\u001a\u00020.2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b/\u00100J'\u00109\u001a\u0002062\u0006\u00101\u001a\u00020\u00002\u0006\u00103\u001a\u0002022\u0006\u00105\u001a\u000204H\u0001¢\u0006\u0004\b7\u00108R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010:\u001a\u0004\b;\u0010\u0019R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010:\u001a\u0004\b<\u0010\u0019R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010:\u001a\u0004\b=\u0010\u0019R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010>\u001a\u0004\b?\u0010\u001dR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010:\u001a\u0004\b@\u0010\u0019R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010:\u001a\u0004\bA\u0010\u0019R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010:\u001a\u0004\bB\u0010\u0019R\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010C\u001a\u0004\bD\u0010\"R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010:\u001a\u0004\bE\u0010\u0019R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010:\u001a\u0004\bF\u0010\u0019R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010:\u001a\u0004\bG\u0010\u0019R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010H\u001a\u0004\bI\u0010'¨\u0006L"}, d2 = {"Lcom/stepos/stepclaw/edge/intercept/model/LlmOutputRequest;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "sessionKey", "runId", "llmRequestId", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "requestSeq", ConfigIpcContract.KEY_PROVIDER, ConfigIpcContract.KEY_MODEL, "response", "Lkotlinx/serialization/json/JsonElement;", "sessionResponse", "agentId", "agentName", "traceId", "Lcom/stepos/stepclaw/edge/intercept/model/LlmUsage;", "usage", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/stepclaw/edge/intercept/model/LlmUsage;)V", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/stepclaw/edge/intercept/model/LlmUsage;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "()Ljava/lang/Integer;", "component5", "component6", "component7", "component8", "()Lkotlinx/serialization/json/JsonElement;", "component9", "component10", "component11", "component12", "()Lcom/stepos/stepclaw/edge/intercept/model/LlmUsage;", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/stepclaw/edge/intercept/model/LlmUsage;)Lcom/stepos/stepclaw/edge/intercept/model/LlmOutputRequest;", "toString", "hashCode", "()I", "other", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "equals", "(Ljava/lang/Object;)Z", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lb5/a0;", "write$Self$step_edge_release", "(Lcom/stepos/stepclaw/edge/intercept/model/LlmOutputRequest;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ljava/lang/String;", "getSessionKey", "getRunId", "getLlmRequestId", "Ljava/lang/Integer;", "getRequestSeq", "getProvider", "getModel", "getResponse", "Lkotlinx/serialization/json/JsonElement;", "getSessionResponse", "getAgentId", "getAgentName", "getTraceId", "Lcom/stepos/stepclaw/edge/intercept/model/LlmUsage;", "getUsage", "Companion", "$serializer", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
/* loaded from: classes.dex */
public final /* data */ class LlmOutputRequest {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String agentId;
    private final String agentName;
    private final String llmRequestId;
    private final String model;
    private final String provider;
    private final Integer requestSeq;
    private final String response;
    private final String runId;
    private final String sessionKey;
    private final JsonElement sessionResponse;
    private final String traceId;
    private final LlmUsage usage;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/stepos/stepclaw/edge/intercept/model/LlmOutputRequest$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stepos/stepclaw/edge/intercept/model/LlmOutputRequest;", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final KSerializer<LlmOutputRequest> serializer() {
            return LlmOutputRequest$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public LlmOutputRequest() {
        this((String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (JsonElement) null, (String) null, (String) null, (String) null, (LlmUsage) null, 4095, (i) null);
    }

    public static /* synthetic */ LlmOutputRequest copy$default(LlmOutputRequest llmOutputRequest, String str, String str2, String str3, Integer num, String str4, String str5, String str6, JsonElement jsonElement, String str7, String str8, String str9, LlmUsage llmUsage, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = llmOutputRequest.sessionKey;
        }
        if ((i8 & 2) != 0) {
            str2 = llmOutputRequest.runId;
        }
        if ((i8 & 4) != 0) {
            str3 = llmOutputRequest.llmRequestId;
        }
        if ((i8 & 8) != 0) {
            num = llmOutputRequest.requestSeq;
        }
        if ((i8 & 16) != 0) {
            str4 = llmOutputRequest.provider;
        }
        if ((i8 & 32) != 0) {
            str5 = llmOutputRequest.model;
        }
        if ((i8 & 64) != 0) {
            str6 = llmOutputRequest.response;
        }
        if ((i8 & 128) != 0) {
            jsonElement = llmOutputRequest.sessionResponse;
        }
        if ((i8 & 256) != 0) {
            str7 = llmOutputRequest.agentId;
        }
        if ((i8 & 512) != 0) {
            str8 = llmOutputRequest.agentName;
        }
        if ((i8 & 1024) != 0) {
            str9 = llmOutputRequest.traceId;
        }
        if ((i8 & 2048) != 0) {
            llmUsage = llmOutputRequest.usage;
        }
        String str10 = str9;
        LlmUsage llmUsage2 = llmUsage;
        String str11 = str7;
        String str12 = str8;
        String str13 = str6;
        JsonElement jsonElement2 = jsonElement;
        String str14 = str4;
        String str15 = str5;
        return llmOutputRequest.copy(str, str2, str3, num, str14, str15, str13, jsonElement2, str11, str12, str10, llmUsage2);
    }

    public static final /* synthetic */ void write$Self$step_edge_release(LlmOutputRequest self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.sessionKey != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.sessionKey);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.runId != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.runId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.llmRequestId != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.llmRequestId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.requestSeq != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, IntSerializer.INSTANCE, self.requestSeq);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.provider != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.provider);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.model != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.model);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.response != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.response);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.sessionResponse != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, JsonElementSerializer.INSTANCE, self.sessionResponse);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.agentId != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.agentId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.agentName != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.agentName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.traceId != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.traceId);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 11) && self.usage == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 11, LlmUsage$$serializer.INSTANCE, self.usage);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSessionKey() {
        return this.sessionKey;
    }

    /* renamed from: component10, reason: from getter */
    public final String getAgentName() {
        return this.agentName;
    }

    /* renamed from: component11, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    /* renamed from: component12, reason: from getter */
    public final LlmUsage getUsage() {
        return this.usage;
    }

    /* renamed from: component2, reason: from getter */
    public final String getRunId() {
        return this.runId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getLlmRequestId() {
        return this.llmRequestId;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getRequestSeq() {
        return this.requestSeq;
    }

    /* renamed from: component5, reason: from getter */
    public final String getProvider() {
        return this.provider;
    }

    /* renamed from: component6, reason: from getter */
    public final String getModel() {
        return this.model;
    }

    /* renamed from: component7, reason: from getter */
    public final String getResponse() {
        return this.response;
    }

    /* renamed from: component8, reason: from getter */
    public final JsonElement getSessionResponse() {
        return this.sessionResponse;
    }

    /* renamed from: component9, reason: from getter */
    public final String getAgentId() {
        return this.agentId;
    }

    public final LlmOutputRequest copy(String sessionKey, String runId, String llmRequestId, Integer requestSeq, String provider, String model, String response, JsonElement sessionResponse, String agentId, String agentName, String traceId, LlmUsage usage) {
        return new LlmOutputRequest(sessionKey, runId, llmRequestId, requestSeq, provider, model, response, sessionResponse, agentId, agentName, traceId, usage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LlmOutputRequest)) {
            return false;
        }
        LlmOutputRequest llmOutputRequest = (LlmOutputRequest) other;
        return p.a(this.sessionKey, llmOutputRequest.sessionKey) && p.a(this.runId, llmOutputRequest.runId) && p.a(this.llmRequestId, llmOutputRequest.llmRequestId) && p.a(this.requestSeq, llmOutputRequest.requestSeq) && p.a(this.provider, llmOutputRequest.provider) && p.a(this.model, llmOutputRequest.model) && p.a(this.response, llmOutputRequest.response) && p.a(this.sessionResponse, llmOutputRequest.sessionResponse) && p.a(this.agentId, llmOutputRequest.agentId) && p.a(this.agentName, llmOutputRequest.agentName) && p.a(this.traceId, llmOutputRequest.traceId) && p.a(this.usage, llmOutputRequest.usage);
    }

    public final String getAgentId() {
        return this.agentId;
    }

    public final String getAgentName() {
        return this.agentName;
    }

    public final String getLlmRequestId() {
        return this.llmRequestId;
    }

    public final String getModel() {
        return this.model;
    }

    public final String getProvider() {
        return this.provider;
    }

    public final Integer getRequestSeq() {
        return this.requestSeq;
    }

    public final String getResponse() {
        return this.response;
    }

    public final String getRunId() {
        return this.runId;
    }

    public final String getSessionKey() {
        return this.sessionKey;
    }

    public final JsonElement getSessionResponse() {
        return this.sessionResponse;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public final LlmUsage getUsage() {
        return this.usage;
    }

    public int hashCode() {
        String str = this.sessionKey;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.runId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.llmRequestId;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.requestSeq;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        String str4 = this.provider;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.model;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.response;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        JsonElement jsonElement = this.sessionResponse;
        int iHashCode8 = (iHashCode7 + (jsonElement == null ? 0 : jsonElement.hashCode())) * 31;
        String str7 = this.agentId;
        int iHashCode9 = (iHashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.agentName;
        int iHashCode10 = (iHashCode9 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.traceId;
        int iHashCode11 = (iHashCode10 + (str9 == null ? 0 : str9.hashCode())) * 31;
        LlmUsage llmUsage = this.usage;
        return iHashCode11 + (llmUsage != null ? llmUsage.hashCode() : 0);
    }

    public String toString() {
        String str = this.sessionKey;
        String str2 = this.runId;
        String str3 = this.llmRequestId;
        Integer num = this.requestSeq;
        String str4 = this.provider;
        String str5 = this.model;
        String str6 = this.response;
        JsonElement jsonElement = this.sessionResponse;
        String str7 = this.agentId;
        String str8 = this.agentName;
        String str9 = this.traceId;
        LlmUsage llmUsage = this.usage;
        StringBuilder sbV = b.v("LlmOutputRequest(sessionKey=", str, ", runId=", str2, ", llmRequestId=");
        sbV.append(str3);
        sbV.append(", requestSeq=");
        sbV.append(num);
        sbV.append(", provider=");
        b.A(sbV, str4, ", model=", str5, ", response=");
        sbV.append(str6);
        sbV.append(", sessionResponse=");
        sbV.append(jsonElement);
        sbV.append(", agentId=");
        b.A(sbV, str7, ", agentName=", str8, ", traceId=");
        sbV.append(str9);
        sbV.append(", usage=");
        sbV.append(llmUsage);
        sbV.append(")");
        return sbV.toString();
    }

    public /* synthetic */ LlmOutputRequest(int i8, String str, String str2, String str3, Integer num, String str4, String str5, String str6, JsonElement jsonElement, String str7, String str8, String str9, LlmUsage llmUsage, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i8 & 1) == 0) {
            this.sessionKey = null;
        } else {
            this.sessionKey = str;
        }
        if ((i8 & 2) == 0) {
            this.runId = null;
        } else {
            this.runId = str2;
        }
        if ((i8 & 4) == 0) {
            this.llmRequestId = null;
        } else {
            this.llmRequestId = str3;
        }
        if ((i8 & 8) == 0) {
            this.requestSeq = null;
        } else {
            this.requestSeq = num;
        }
        if ((i8 & 16) == 0) {
            this.provider = null;
        } else {
            this.provider = str4;
        }
        if ((i8 & 32) == 0) {
            this.model = null;
        } else {
            this.model = str5;
        }
        if ((i8 & 64) == 0) {
            this.response = null;
        } else {
            this.response = str6;
        }
        if ((i8 & 128) == 0) {
            this.sessionResponse = null;
        } else {
            this.sessionResponse = jsonElement;
        }
        if ((i8 & 256) == 0) {
            this.agentId = null;
        } else {
            this.agentId = str7;
        }
        if ((i8 & 512) == 0) {
            this.agentName = null;
        } else {
            this.agentName = str8;
        }
        if ((i8 & 1024) == 0) {
            this.traceId = null;
        } else {
            this.traceId = str9;
        }
        if ((i8 & 2048) == 0) {
            this.usage = null;
        } else {
            this.usage = llmUsage;
        }
    }

    public LlmOutputRequest(String str, String str2, String str3, Integer num, String str4, String str5, String str6, JsonElement jsonElement, String str7, String str8, String str9, LlmUsage llmUsage) {
        this.sessionKey = str;
        this.runId = str2;
        this.llmRequestId = str3;
        this.requestSeq = num;
        this.provider = str4;
        this.model = str5;
        this.response = str6;
        this.sessionResponse = jsonElement;
        this.agentId = str7;
        this.agentName = str8;
        this.traceId = str9;
        this.usage = llmUsage;
    }

    public /* synthetic */ LlmOutputRequest(String str, String str2, String str3, Integer num, String str4, String str5, String str6, JsonElement jsonElement, String str7, String str8, String str9, LlmUsage llmUsage, int i8, i iVar) {
        this((i8 & 1) != 0 ? null : str, (i8 & 2) != 0 ? null : str2, (i8 & 4) != 0 ? null : str3, (i8 & 8) != 0 ? null : num, (i8 & 16) != 0 ? null : str4, (i8 & 32) != 0 ? null : str5, (i8 & 64) != 0 ? null : str6, (i8 & 128) != 0 ? null : jsonElement, (i8 & 256) != 0 ? null : str7, (i8 & 512) != 0 ? null : str8, (i8 & 1024) != 0 ? null : str9, (i8 & 2048) != 0 ? null : llmUsage);
    }
}
