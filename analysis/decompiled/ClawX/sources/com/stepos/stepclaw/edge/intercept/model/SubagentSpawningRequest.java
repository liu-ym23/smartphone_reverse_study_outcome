package com.stepos.stepclaw.edge.intercept.model;

import a8.b;
import b5.e;
import b5.f;
import b8.h;
import com.stepos.stepclaw.SecurePrefs;
import java.util.Map;
import k4.r;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u0000 02\u00020\u0001:\u000210BO\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nBY\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000fJ'\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001aJ\u001e\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001aJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u001aJX\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\"\u0010\u001aJ\u0010\u0010#\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b#\u0010$J\u001a\u0010'\u001a\u00020&2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b'\u0010(R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010)\u001a\u0004\b*\u0010\u001aR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010)\u001a\u0004\b+\u0010\u001aR%\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010,\u001a\u0004\b-\u0010\u001dR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010)\u001a\u0004\b.\u0010\u001aR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010)\u001a\u0004\b/\u0010\u001a¨\u00062"}, d2 = {"Lcom/stepos/stepclaw/edge/intercept/model/SubagentSpawningRequest;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "sessionId", "parentSessionId", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "subagentConfig", "outputText", "traceId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lb5/a0;", "write$Self$step_edge_release", "(Lcom/stepos/stepclaw/edge/intercept/model/SubagentSpawningRequest;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/String;", "component2", "component3", "()Ljava/util/Map;", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/stepclaw/edge/intercept/model/SubagentSpawningRequest;", "toString", "hashCode", "()I", "other", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSessionId", "getParentSessionId", "Ljava/util/Map;", "getSubagentConfig", "getOutputText", "getTraceId", "Companion", "$serializer", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
/* loaded from: classes.dex */
public final /* data */ class SubagentSpawningRequest {
    private final String outputText;
    private final String parentSessionId;
    private final String sessionId;
    private final Map<String, String> subagentConfig;
    private final String traceId;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final e[] $childSerializers = {null, null, h.w(f.f889a, new r(19)), null, null};

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/stepos/stepclaw/edge/intercept/model/SubagentSpawningRequest$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stepos/stepclaw/edge/intercept/model/SubagentSpawningRequest;", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final KSerializer<SubagentSpawningRequest> serializer() {
            return SubagentSpawningRequest$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public SubagentSpawningRequest() {
        this((String) null, (String) null, (Map) null, (String) null, (String) null, 31, (i) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new LinkedHashMapSerializer(stringSerializer, stringSerializer);
    }

    public static /* synthetic */ SubagentSpawningRequest copy$default(SubagentSpawningRequest subagentSpawningRequest, String str, String str2, Map map, String str3, String str4, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = subagentSpawningRequest.sessionId;
        }
        if ((i8 & 2) != 0) {
            str2 = subagentSpawningRequest.parentSessionId;
        }
        if ((i8 & 4) != 0) {
            map = subagentSpawningRequest.subagentConfig;
        }
        if ((i8 & 8) != 0) {
            str3 = subagentSpawningRequest.outputText;
        }
        if ((i8 & 16) != 0) {
            str4 = subagentSpawningRequest.traceId;
        }
        String str5 = str4;
        Map map2 = map;
        return subagentSpawningRequest.copy(str, str2, map2, str3, str5);
    }

    public static final /* synthetic */ void write$Self$step_edge_release(SubagentSpawningRequest self, CompositeEncoder output, SerialDescriptor serialDesc) {
        e[] eVarArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.sessionId != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.sessionId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.parentSessionId != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.parentSessionId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.subagentConfig != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, (SerializationStrategy) eVarArr[2].getValue(), self.subagentConfig);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.outputText != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.outputText);
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
    public final String getParentSessionId() {
        return this.parentSessionId;
    }

    public final Map<String, String> component3() {
        return this.subagentConfig;
    }

    /* renamed from: component4, reason: from getter */
    public final String getOutputText() {
        return this.outputText;
    }

    /* renamed from: component5, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    public final SubagentSpawningRequest copy(String sessionId, String parentSessionId, Map<String, String> subagentConfig, String outputText, String traceId) {
        return new SubagentSpawningRequest(sessionId, parentSessionId, subagentConfig, outputText, traceId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubagentSpawningRequest)) {
            return false;
        }
        SubagentSpawningRequest subagentSpawningRequest = (SubagentSpawningRequest) other;
        return p.a(this.sessionId, subagentSpawningRequest.sessionId) && p.a(this.parentSessionId, subagentSpawningRequest.parentSessionId) && p.a(this.subagentConfig, subagentSpawningRequest.subagentConfig) && p.a(this.outputText, subagentSpawningRequest.outputText) && p.a(this.traceId, subagentSpawningRequest.traceId);
    }

    public final String getOutputText() {
        return this.outputText;
    }

    public final String getParentSessionId() {
        return this.parentSessionId;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final Map<String, String> getSubagentConfig() {
        return this.subagentConfig;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public int hashCode() {
        String str = this.sessionId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.parentSessionId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Map<String, String> map = this.subagentConfig;
        int iHashCode3 = (iHashCode2 + (map == null ? 0 : map.hashCode())) * 31;
        String str3 = this.outputText;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.traceId;
        return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        String str = this.sessionId;
        String str2 = this.parentSessionId;
        Map<String, String> map = this.subagentConfig;
        String str3 = this.outputText;
        String str4 = this.traceId;
        StringBuilder sbV = b.v("SubagentSpawningRequest(sessionId=", str, ", parentSessionId=", str2, ", subagentConfig=");
        sbV.append(map);
        sbV.append(", outputText=");
        sbV.append(str3);
        sbV.append(", traceId=");
        return m0.f.f(sbV, str4, ")");
    }

    public /* synthetic */ SubagentSpawningRequest(int i8, String str, String str2, Map map, String str3, String str4, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i8 & 1) == 0) {
            this.sessionId = null;
        } else {
            this.sessionId = str;
        }
        if ((i8 & 2) == 0) {
            this.parentSessionId = null;
        } else {
            this.parentSessionId = str2;
        }
        if ((i8 & 4) == 0) {
            this.subagentConfig = null;
        } else {
            this.subagentConfig = map;
        }
        if ((i8 & 8) == 0) {
            this.outputText = null;
        } else {
            this.outputText = str3;
        }
        if ((i8 & 16) == 0) {
            this.traceId = null;
        } else {
            this.traceId = str4;
        }
    }

    public SubagentSpawningRequest(String str, String str2, Map<String, String> map, String str3, String str4) {
        this.sessionId = str;
        this.parentSessionId = str2;
        this.subagentConfig = map;
        this.outputText = str3;
        this.traceId = str4;
    }

    public /* synthetic */ SubagentSpawningRequest(String str, String str2, Map map, String str3, String str4, int i8, i iVar) {
        this((i8 & 1) != 0 ? null : str, (i8 & 2) != 0 ? null : str2, (i8 & 4) != 0 ? null : map, (i8 & 8) != 0 ? null : str3, (i8 & 16) != 0 ? null : str4);
    }
}
