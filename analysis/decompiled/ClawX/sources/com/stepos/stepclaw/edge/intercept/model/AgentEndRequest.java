package com.stepos.stepclaw.edge.intercept.model;

import a8.b;
import b5.e;
import b5.f;
import b8.h;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.provider.contract.OperationResult;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\b\u0087\b\u0018\u0000 <2\u00020\u0001:\u0002=<Ba\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000e\u0010\u000fBg\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u000e\u0010\u0014J'\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010 \u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u001fJ\u0018\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b!\u0010\"J\u0012\u0010#\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b#\u0010$J\u0012\u0010%\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b%\u0010\u001fJ\u0012\u0010&\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b&\u0010'J\u0012\u0010(\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b(\u0010\u001fJj\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b+\u0010\u001fJ\u0010\u0010,\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b,\u0010-J\u001a\u0010/\u001a\u00020\b2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b/\u00100R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00101\u001a\u0004\b2\u0010\u001fR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u00101\u001a\u0004\b3\u0010\u001fR\u001f\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u00104\u001a\u0004\b5\u0010\"R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u00106\u001a\u0004\b7\u0010$R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u00101\u001a\u0004\b8\u0010\u001fR\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\f\u00109\u001a\u0004\b:\u0010'R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\r\u00101\u001a\u0004\b;\u0010\u001f¨\u0006>"}, d2 = {"Lcom/stepos/stepclaw/edge/intercept/model/AgentEndRequest;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "sessionId", "sessionKey", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/edge/intercept/model/MessageItem;", "messages", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, OperationResult.EXTRA_SUCCESS, "error", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "durationMs", "traceId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lb5/a0;", "write$Self$step_edge_release", "(Lcom/stepos/stepclaw/edge/intercept/model/AgentEndRequest;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/String;", "component2", "component3", "()Ljava/util/List;", "component4", "()Ljava/lang/Boolean;", "component5", "component6", "()Ljava/lang/Long;", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lcom/stepos/stepclaw/edge/intercept/model/AgentEndRequest;", "toString", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSessionId", "getSessionKey", "Ljava/util/List;", "getMessages", "Ljava/lang/Boolean;", "getSuccess", "getError", "Ljava/lang/Long;", "getDurationMs", "getTraceId", "Companion", "$serializer", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
/* loaded from: classes.dex */
public final /* data */ class AgentEndRequest {
    private final Long durationMs;
    private final String error;
    private final List<MessageItem> messages;
    private final String sessionId;
    private final String sessionKey;
    private final Boolean success;
    private final String traceId;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final e[] $childSerializers = {null, null, h.w(f.f889a, new r(9)), null, null, null, null};

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/stepos/stepclaw/edge/intercept/model/AgentEndRequest$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stepos/stepclaw/edge/intercept/model/AgentEndRequest;", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final KSerializer<AgentEndRequest> serializer() {
            return AgentEndRequest$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public AgentEndRequest() {
        this((String) null, (String) null, (List) null, (Boolean) null, (String) null, (Long) null, (String) null, 127, (i) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(MessageItem$$serializer.INSTANCE);
    }

    public static /* synthetic */ AgentEndRequest copy$default(AgentEndRequest agentEndRequest, String str, String str2, List list, Boolean bool, String str3, Long l3, String str4, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = agentEndRequest.sessionId;
        }
        if ((i8 & 2) != 0) {
            str2 = agentEndRequest.sessionKey;
        }
        if ((i8 & 4) != 0) {
            list = agentEndRequest.messages;
        }
        if ((i8 & 8) != 0) {
            bool = agentEndRequest.success;
        }
        if ((i8 & 16) != 0) {
            str3 = agentEndRequest.error;
        }
        if ((i8 & 32) != 0) {
            l3 = agentEndRequest.durationMs;
        }
        if ((i8 & 64) != 0) {
            str4 = agentEndRequest.traceId;
        }
        Long l6 = l3;
        String str5 = str4;
        String str6 = str3;
        List list2 = list;
        return agentEndRequest.copy(str, str2, list2, bool, str6, l6, str5);
    }

    public static final /* synthetic */ void write$Self$step_edge_release(AgentEndRequest self, CompositeEncoder output, SerialDescriptor serialDesc) {
        e[] eVarArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.sessionId != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.sessionId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.sessionKey != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.sessionKey);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.messages != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, (SerializationStrategy) eVarArr[2].getValue(), self.messages);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.success != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, BooleanSerializer.INSTANCE, self.success);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.error != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.error);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.durationMs != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, LongSerializer.INSTANCE, self.durationMs);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 6) && self.traceId == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.traceId);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSessionKey() {
        return this.sessionKey;
    }

    public final List<MessageItem> component3() {
        return this.messages;
    }

    /* renamed from: component4, reason: from getter */
    public final Boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component5, reason: from getter */
    public final String getError() {
        return this.error;
    }

    /* renamed from: component6, reason: from getter */
    public final Long getDurationMs() {
        return this.durationMs;
    }

    /* renamed from: component7, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    public final AgentEndRequest copy(String sessionId, String sessionKey, List<MessageItem> messages, Boolean success, String error, Long durationMs, String traceId) {
        return new AgentEndRequest(sessionId, sessionKey, messages, success, error, durationMs, traceId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AgentEndRequest)) {
            return false;
        }
        AgentEndRequest agentEndRequest = (AgentEndRequest) other;
        return p.a(this.sessionId, agentEndRequest.sessionId) && p.a(this.sessionKey, agentEndRequest.sessionKey) && p.a(this.messages, agentEndRequest.messages) && p.a(this.success, agentEndRequest.success) && p.a(this.error, agentEndRequest.error) && p.a(this.durationMs, agentEndRequest.durationMs) && p.a(this.traceId, agentEndRequest.traceId);
    }

    public final Long getDurationMs() {
        return this.durationMs;
    }

    public final String getError() {
        return this.error;
    }

    public final List<MessageItem> getMessages() {
        return this.messages;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getSessionKey() {
        return this.sessionKey;
    }

    public final Boolean getSuccess() {
        return this.success;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public int hashCode() {
        String str = this.sessionId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.sessionKey;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<MessageItem> list = this.messages;
        int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        Boolean bool = this.success;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str3 = this.error;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Long l3 = this.durationMs;
        int iHashCode6 = (iHashCode5 + (l3 == null ? 0 : l3.hashCode())) * 31;
        String str4 = this.traceId;
        return iHashCode6 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        String str = this.sessionId;
        String str2 = this.sessionKey;
        List<MessageItem> list = this.messages;
        Boolean bool = this.success;
        String str3 = this.error;
        Long l3 = this.durationMs;
        String str4 = this.traceId;
        StringBuilder sbV = b.v("AgentEndRequest(sessionId=", str, ", sessionKey=", str2, ", messages=");
        sbV.append(list);
        sbV.append(", success=");
        sbV.append(bool);
        sbV.append(", error=");
        sbV.append(str3);
        sbV.append(", durationMs=");
        sbV.append(l3);
        sbV.append(", traceId=");
        return m0.f.f(sbV, str4, ")");
    }

    public /* synthetic */ AgentEndRequest(int i8, String str, String str2, List list, Boolean bool, String str3, Long l3, String str4, SerializationConstructorMarker serializationConstructorMarker) {
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
            this.messages = null;
        } else {
            this.messages = list;
        }
        if ((i8 & 8) == 0) {
            this.success = null;
        } else {
            this.success = bool;
        }
        if ((i8 & 16) == 0) {
            this.error = null;
        } else {
            this.error = str3;
        }
        if ((i8 & 32) == 0) {
            this.durationMs = null;
        } else {
            this.durationMs = l3;
        }
        if ((i8 & 64) == 0) {
            this.traceId = null;
        } else {
            this.traceId = str4;
        }
    }

    public AgentEndRequest(String str, String str2, List<MessageItem> list, Boolean bool, String str3, Long l3, String str4) {
        this.sessionId = str;
        this.sessionKey = str2;
        this.messages = list;
        this.success = bool;
        this.error = str3;
        this.durationMs = l3;
        this.traceId = str4;
    }

    public /* synthetic */ AgentEndRequest(String str, String str2, List list, Boolean bool, String str3, Long l3, String str4, int i8, i iVar) {
        this((i8 & 1) != 0 ? null : str, (i8 & 2) != 0 ? null : str2, (i8 & 4) != 0 ? null : list, (i8 & 8) != 0 ? null : bool, (i8 & 16) != 0 ? null : str3, (i8 & 32) != 0 ? null : l3, (i8 & 64) != 0 ? null : str4);
    }
}
