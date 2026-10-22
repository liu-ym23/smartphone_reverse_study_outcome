package com.stepos.stepclaw.edge.intercept.model;

import a8.b;
import b5.e;
import b5.f;
import b8.h;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.bridge.spi.ConfigIpcContract;
import java.util.List;
import k4.r;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;
import kotlinx.serialization.json.internal.ReaderJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0087\b\u0018\u0000 T2\u00020\u0001:\u0002UTBÁ\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0016\u0010\u0017B·\u0001\b\u0010\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u0016\u0010\u001bJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001dJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010!\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\u001dJ\u0012\u0010\"\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\"\u0010\u001dJ\u0012\u0010#\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b#\u0010\u001dJ\u0012\u0010$\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b$\u0010\u001dJ\u0012\u0010%\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b%\u0010\u001dJ\u0018\u0010&\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b&\u0010'J\u0012\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b(\u0010 J\u0012\u0010)\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b)\u0010*J\u0012\u0010+\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b+\u0010*J\u0012\u0010,\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b,\u0010\u001dJ\u0012\u0010-\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b-\u0010\u001dJ\u0012\u0010.\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b.\u0010\u001dJÊ\u0001\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b/\u00100J\u0010\u00101\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b1\u0010\u001dJ\u0010\u00102\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b2\u00103J\u001a\u00106\u001a\u0002052\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b6\u00107J'\u0010@\u001a\u00020=2\u0006\u00108\u001a\u00020\u00002\u0006\u0010:\u001a\u0002092\u0006\u0010<\u001a\u00020;H\u0001¢\u0006\u0004\b>\u0010?R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010A\u001a\u0004\bB\u0010\u001dR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010A\u001a\u0004\bC\u0010\u001dR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010D\u001a\u0004\bE\u0010 R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010A\u001a\u0004\bF\u0010\u001dR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010A\u001a\u0004\bG\u0010\u001dR\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010A\u001a\u0004\bH\u0010\u001dR\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010A\u001a\u0004\bI\u0010\u001dR\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010A\u001a\u0004\bJ\u0010\u001dR\u001f\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\u000e\u0010K\u001a\u0004\bL\u0010'R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u000f\u0010D\u001a\u0004\bM\u0010 R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010N\u001a\u0004\bO\u0010*R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b\u0012\u0010N\u001a\u0004\bP\u0010*R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010A\u001a\u0004\bQ\u0010\u001dR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010A\u001a\u0004\bR\u0010\u001dR\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010A\u001a\u0004\bS\u0010\u001d¨\u0006V"}, d2 = {"Lcom/stepos/stepclaw/edge/intercept/model/LlmInputRequest;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "runId", "llmRequestId", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "requestSeq", "sessionKey", ConfigIpcContract.KEY_MODEL, ConfigIpcContract.KEY_PROVIDER, "systemPrompt", "prompt", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/edge/intercept/model/MessageItem;", "historyMessages", "imagesCount", "Lkotlinx/serialization/json/JsonElement;", "finalRequestPayload", "requestEnvelope", "agentId", "agentName", "traceId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Lkotlinx/serialization/json/JsonElement;Lkotlinx/serialization/json/JsonElement;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Lkotlinx/serialization/json/JsonElement;Lkotlinx/serialization/json/JsonElement;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "component1", "()Ljava/lang/String;", "component2", "component3", "()Ljava/lang/Integer;", "component4", "component5", "component6", "component7", "component8", "component9", "()Ljava/util/List;", "component10", "component11", "()Lkotlinx/serialization/json/JsonElement;", "component12", "component13", "component14", "component15", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Lkotlinx/serialization/json/JsonElement;Lkotlinx/serialization/json/JsonElement;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/stepclaw/edge/intercept/model/LlmInputRequest;", "toString", "hashCode", "()I", "other", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "equals", "(Ljava/lang/Object;)Z", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lb5/a0;", "write$Self$step_edge_release", "(Lcom/stepos/stepclaw/edge/intercept/model/LlmInputRequest;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ljava/lang/String;", "getRunId", "getLlmRequestId", "Ljava/lang/Integer;", "getRequestSeq", "getSessionKey", "getModel", "getProvider", "getSystemPrompt", "getPrompt", "Ljava/util/List;", "getHistoryMessages", "getImagesCount", "Lkotlinx/serialization/json/JsonElement;", "getFinalRequestPayload", "getRequestEnvelope", "getAgentId", "getAgentName", "getTraceId", "Companion", "$serializer", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
/* loaded from: classes.dex */
public final /* data */ class LlmInputRequest {
    private final String agentId;
    private final String agentName;
    private final JsonElement finalRequestPayload;
    private final List<MessageItem> historyMessages;
    private final Integer imagesCount;
    private final String llmRequestId;
    private final String model;
    private final String prompt;
    private final String provider;
    private final JsonElement requestEnvelope;
    private final Integer requestSeq;
    private final String runId;
    private final String sessionKey;
    private final String systemPrompt;
    private final String traceId;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final e[] $childSerializers = {null, null, null, null, null, null, null, null, h.w(f.f889a, new r(16)), null, null, null, null, null, null};

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/stepos/stepclaw/edge/intercept/model/LlmInputRequest$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stepos/stepclaw/edge/intercept/model/LlmInputRequest;", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final KSerializer<LlmInputRequest> serializer() {
            return LlmInputRequest$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public LlmInputRequest() {
        this((String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, (Integer) null, (JsonElement) null, (JsonElement) null, (String) null, (String) null, (String) null, 32767, (i) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(MessageItem$$serializer.INSTANCE);
    }

    public static final /* synthetic */ void write$Self$step_edge_release(LlmInputRequest self, CompositeEncoder output, SerialDescriptor serialDesc) {
        e[] eVarArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.runId != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.runId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.llmRequestId != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.llmRequestId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.requestSeq != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.requestSeq);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.sessionKey != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.sessionKey);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.model != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.model);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.provider != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.provider);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.systemPrompt != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.systemPrompt);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.prompt != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.prompt);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.historyMessages != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, (SerializationStrategy) eVarArr[8].getValue(), self.historyMessages);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.imagesCount != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, IntSerializer.INSTANCE, self.imagesCount);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.finalRequestPayload != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, JsonElementSerializer.INSTANCE, self.finalRequestPayload);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.requestEnvelope != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, JsonElementSerializer.INSTANCE, self.requestEnvelope);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.agentId != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.agentId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.agentName != null) {
            output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.agentName);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 14) && self.traceId == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 14, StringSerializer.INSTANCE, self.traceId);
    }

    /* renamed from: component1, reason: from getter */
    public final String getRunId() {
        return this.runId;
    }

    /* renamed from: component10, reason: from getter */
    public final Integer getImagesCount() {
        return this.imagesCount;
    }

    /* renamed from: component11, reason: from getter */
    public final JsonElement getFinalRequestPayload() {
        return this.finalRequestPayload;
    }

    /* renamed from: component12, reason: from getter */
    public final JsonElement getRequestEnvelope() {
        return this.requestEnvelope;
    }

    /* renamed from: component13, reason: from getter */
    public final String getAgentId() {
        return this.agentId;
    }

    /* renamed from: component14, reason: from getter */
    public final String getAgentName() {
        return this.agentName;
    }

    /* renamed from: component15, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getLlmRequestId() {
        return this.llmRequestId;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getRequestSeq() {
        return this.requestSeq;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSessionKey() {
        return this.sessionKey;
    }

    /* renamed from: component5, reason: from getter */
    public final String getModel() {
        return this.model;
    }

    /* renamed from: component6, reason: from getter */
    public final String getProvider() {
        return this.provider;
    }

    /* renamed from: component7, reason: from getter */
    public final String getSystemPrompt() {
        return this.systemPrompt;
    }

    /* renamed from: component8, reason: from getter */
    public final String getPrompt() {
        return this.prompt;
    }

    public final List<MessageItem> component9() {
        return this.historyMessages;
    }

    public final LlmInputRequest copy(String runId, String llmRequestId, Integer requestSeq, String sessionKey, String model, String provider, String systemPrompt, String prompt, List<MessageItem> historyMessages, Integer imagesCount, JsonElement finalRequestPayload, JsonElement requestEnvelope, String agentId, String agentName, String traceId) {
        return new LlmInputRequest(runId, llmRequestId, requestSeq, sessionKey, model, provider, systemPrompt, prompt, historyMessages, imagesCount, finalRequestPayload, requestEnvelope, agentId, agentName, traceId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LlmInputRequest)) {
            return false;
        }
        LlmInputRequest llmInputRequest = (LlmInputRequest) other;
        return p.a(this.runId, llmInputRequest.runId) && p.a(this.llmRequestId, llmInputRequest.llmRequestId) && p.a(this.requestSeq, llmInputRequest.requestSeq) && p.a(this.sessionKey, llmInputRequest.sessionKey) && p.a(this.model, llmInputRequest.model) && p.a(this.provider, llmInputRequest.provider) && p.a(this.systemPrompt, llmInputRequest.systemPrompt) && p.a(this.prompt, llmInputRequest.prompt) && p.a(this.historyMessages, llmInputRequest.historyMessages) && p.a(this.imagesCount, llmInputRequest.imagesCount) && p.a(this.finalRequestPayload, llmInputRequest.finalRequestPayload) && p.a(this.requestEnvelope, llmInputRequest.requestEnvelope) && p.a(this.agentId, llmInputRequest.agentId) && p.a(this.agentName, llmInputRequest.agentName) && p.a(this.traceId, llmInputRequest.traceId);
    }

    public final String getAgentId() {
        return this.agentId;
    }

    public final String getAgentName() {
        return this.agentName;
    }

    public final JsonElement getFinalRequestPayload() {
        return this.finalRequestPayload;
    }

    public final List<MessageItem> getHistoryMessages() {
        return this.historyMessages;
    }

    public final Integer getImagesCount() {
        return this.imagesCount;
    }

    public final String getLlmRequestId() {
        return this.llmRequestId;
    }

    public final String getModel() {
        return this.model;
    }

    public final String getPrompt() {
        return this.prompt;
    }

    public final String getProvider() {
        return this.provider;
    }

    public final JsonElement getRequestEnvelope() {
        return this.requestEnvelope;
    }

    public final Integer getRequestSeq() {
        return this.requestSeq;
    }

    public final String getRunId() {
        return this.runId;
    }

    public final String getSessionKey() {
        return this.sessionKey;
    }

    public final String getSystemPrompt() {
        return this.systemPrompt;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public int hashCode() {
        String str = this.runId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.llmRequestId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.requestSeq;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.sessionKey;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.model;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.provider;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.systemPrompt;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.prompt;
        int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        List<MessageItem> list = this.historyMessages;
        int iHashCode9 = (iHashCode8 + (list == null ? 0 : list.hashCode())) * 31;
        Integer num2 = this.imagesCount;
        int iHashCode10 = (iHashCode9 + (num2 == null ? 0 : num2.hashCode())) * 31;
        JsonElement jsonElement = this.finalRequestPayload;
        int iHashCode11 = (iHashCode10 + (jsonElement == null ? 0 : jsonElement.hashCode())) * 31;
        JsonElement jsonElement2 = this.requestEnvelope;
        int iHashCode12 = (iHashCode11 + (jsonElement2 == null ? 0 : jsonElement2.hashCode())) * 31;
        String str8 = this.agentId;
        int iHashCode13 = (iHashCode12 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.agentName;
        int iHashCode14 = (iHashCode13 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.traceId;
        return iHashCode14 + (str10 != null ? str10.hashCode() : 0);
    }

    public String toString() {
        String str = this.runId;
        String str2 = this.llmRequestId;
        Integer num = this.requestSeq;
        String str3 = this.sessionKey;
        String str4 = this.model;
        String str5 = this.provider;
        String str6 = this.systemPrompt;
        String str7 = this.prompt;
        List<MessageItem> list = this.historyMessages;
        Integer num2 = this.imagesCount;
        JsonElement jsonElement = this.finalRequestPayload;
        JsonElement jsonElement2 = this.requestEnvelope;
        String str8 = this.agentId;
        String str9 = this.agentName;
        String str10 = this.traceId;
        StringBuilder sbV = b.v("LlmInputRequest(runId=", str, ", llmRequestId=", str2, ", requestSeq=");
        sbV.append(num);
        sbV.append(", sessionKey=");
        sbV.append(str3);
        sbV.append(", model=");
        b.A(sbV, str4, ", provider=", str5, ", systemPrompt=");
        b.A(sbV, str6, ", prompt=", str7, ", historyMessages=");
        sbV.append(list);
        sbV.append(", imagesCount=");
        sbV.append(num2);
        sbV.append(", finalRequestPayload=");
        sbV.append(jsonElement);
        sbV.append(", requestEnvelope=");
        sbV.append(jsonElement2);
        sbV.append(", agentId=");
        b.A(sbV, str8, ", agentName=", str9, ", traceId=");
        return m0.f.f(sbV, str10, ")");
    }

    public /* synthetic */ LlmInputRequest(int i8, String str, String str2, Integer num, String str3, String str4, String str5, String str6, String str7, List list, Integer num2, JsonElement jsonElement, JsonElement jsonElement2, String str8, String str9, String str10, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i8 & 1) == 0) {
            this.runId = null;
        } else {
            this.runId = str;
        }
        if ((i8 & 2) == 0) {
            this.llmRequestId = null;
        } else {
            this.llmRequestId = str2;
        }
        if ((i8 & 4) == 0) {
            this.requestSeq = null;
        } else {
            this.requestSeq = num;
        }
        if ((i8 & 8) == 0) {
            this.sessionKey = null;
        } else {
            this.sessionKey = str3;
        }
        if ((i8 & 16) == 0) {
            this.model = null;
        } else {
            this.model = str4;
        }
        if ((i8 & 32) == 0) {
            this.provider = null;
        } else {
            this.provider = str5;
        }
        if ((i8 & 64) == 0) {
            this.systemPrompt = null;
        } else {
            this.systemPrompt = str6;
        }
        if ((i8 & 128) == 0) {
            this.prompt = null;
        } else {
            this.prompt = str7;
        }
        if ((i8 & 256) == 0) {
            this.historyMessages = null;
        } else {
            this.historyMessages = list;
        }
        if ((i8 & 512) == 0) {
            this.imagesCount = null;
        } else {
            this.imagesCount = num2;
        }
        if ((i8 & 1024) == 0) {
            this.finalRequestPayload = null;
        } else {
            this.finalRequestPayload = jsonElement;
        }
        if ((i8 & 2048) == 0) {
            this.requestEnvelope = null;
        } else {
            this.requestEnvelope = jsonElement2;
        }
        if ((i8 & 4096) == 0) {
            this.agentId = null;
        } else {
            this.agentId = str8;
        }
        if ((i8 & 8192) == 0) {
            this.agentName = null;
        } else {
            this.agentName = str9;
        }
        if ((i8 & ReaderJsonLexerKt.BATCH_SIZE) == 0) {
            this.traceId = null;
        } else {
            this.traceId = str10;
        }
    }

    public LlmInputRequest(String str, String str2, Integer num, String str3, String str4, String str5, String str6, String str7, List<MessageItem> list, Integer num2, JsonElement jsonElement, JsonElement jsonElement2, String str8, String str9, String str10) {
        this.runId = str;
        this.llmRequestId = str2;
        this.requestSeq = num;
        this.sessionKey = str3;
        this.model = str4;
        this.provider = str5;
        this.systemPrompt = str6;
        this.prompt = str7;
        this.historyMessages = list;
        this.imagesCount = num2;
        this.finalRequestPayload = jsonElement;
        this.requestEnvelope = jsonElement2;
        this.agentId = str8;
        this.agentName = str9;
        this.traceId = str10;
    }

    public /* synthetic */ LlmInputRequest(String str, String str2, Integer num, String str3, String str4, String str5, String str6, String str7, List list, Integer num2, JsonElement jsonElement, JsonElement jsonElement2, String str8, String str9, String str10, int i8, i iVar) {
        this((i8 & 1) != 0 ? null : str, (i8 & 2) != 0 ? null : str2, (i8 & 4) != 0 ? null : num, (i8 & 8) != 0 ? null : str3, (i8 & 16) != 0 ? null : str4, (i8 & 32) != 0 ? null : str5, (i8 & 64) != 0 ? null : str6, (i8 & 128) != 0 ? null : str7, (i8 & 256) != 0 ? null : list, (i8 & 512) != 0 ? null : num2, (i8 & 1024) != 0 ? null : jsonElement, (i8 & 2048) != 0 ? null : jsonElement2, (i8 & 4096) != 0 ? null : str8, (i8 & 8192) != 0 ? null : str9, (i8 & ReaderJsonLexerKt.BATCH_SIZE) != 0 ? null : str10);
    }
}
