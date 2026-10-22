package com.stepos.stepclaw.edge.intercept.model;

import a8.b;
import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import m0.f;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002('B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007B9\b\u0010\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\fJ'\u0010\u0015\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0017J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0017J4\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0017J\u0010\u0010\u001d\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b!\u0010\"R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010#\u001a\u0004\b$\u0010\u0017R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010#\u001a\u0004\b%\u0010\u0017R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010#\u001a\u0004\b&\u0010\u0017¨\u0006)"}, d2 = {"Lcom/stepos/stepclaw/edge/intercept/model/SubagentSpawnedRequest;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "sessionId", "parentSessionId", "subagentSessionId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lb5/a0;", "write$Self$step_edge_release", "(Lcom/stepos/stepclaw/edge/intercept/model/SubagentSpawnedRequest;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/String;", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/stepclaw/edge/intercept/model/SubagentSpawnedRequest;", "toString", "hashCode", "()I", "other", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSessionId", "getParentSessionId", "getSubagentSessionId", "Companion", "$serializer", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
/* loaded from: classes.dex */
public final /* data */ class SubagentSpawnedRequest {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String parentSessionId;
    private final String sessionId;
    private final String subagentSessionId;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/stepos/stepclaw/edge/intercept/model/SubagentSpawnedRequest$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stepos/stepclaw/edge/intercept/model/SubagentSpawnedRequest;", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final KSerializer<SubagentSpawnedRequest> serializer() {
            return SubagentSpawnedRequest$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public SubagentSpawnedRequest() {
        this((String) null, (String) null, (String) null, 7, (i) null);
    }

    public static /* synthetic */ SubagentSpawnedRequest copy$default(SubagentSpawnedRequest subagentSpawnedRequest, String str, String str2, String str3, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = subagentSpawnedRequest.sessionId;
        }
        if ((i8 & 2) != 0) {
            str2 = subagentSpawnedRequest.parentSessionId;
        }
        if ((i8 & 4) != 0) {
            str3 = subagentSpawnedRequest.subagentSessionId;
        }
        return subagentSpawnedRequest.copy(str, str2, str3);
    }

    public static final /* synthetic */ void write$Self$step_edge_release(SubagentSpawnedRequest self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.sessionId != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.sessionId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.parentSessionId != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.parentSessionId);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.subagentSessionId == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.subagentSessionId);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getParentSessionId() {
        return this.parentSessionId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSubagentSessionId() {
        return this.subagentSessionId;
    }

    public final SubagentSpawnedRequest copy(String sessionId, String parentSessionId, String subagentSessionId) {
        return new SubagentSpawnedRequest(sessionId, parentSessionId, subagentSessionId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubagentSpawnedRequest)) {
            return false;
        }
        SubagentSpawnedRequest subagentSpawnedRequest = (SubagentSpawnedRequest) other;
        return p.a(this.sessionId, subagentSpawnedRequest.sessionId) && p.a(this.parentSessionId, subagentSpawnedRequest.parentSessionId) && p.a(this.subagentSessionId, subagentSpawnedRequest.subagentSessionId);
    }

    public final String getParentSessionId() {
        return this.parentSessionId;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getSubagentSessionId() {
        return this.subagentSessionId;
    }

    public int hashCode() {
        String str = this.sessionId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.parentSessionId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.subagentSessionId;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        String str = this.sessionId;
        String str2 = this.parentSessionId;
        return f.f(b.v("SubagentSpawnedRequest(sessionId=", str, ", parentSessionId=", str2, ", subagentSessionId="), this.subagentSessionId, ")");
    }

    public /* synthetic */ SubagentSpawnedRequest(int i8, String str, String str2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
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
            this.subagentSessionId = null;
        } else {
            this.subagentSessionId = str3;
        }
    }

    public SubagentSpawnedRequest(String str, String str2, String str3) {
        this.sessionId = str;
        this.parentSessionId = str2;
        this.subagentSessionId = str3;
    }

    public /* synthetic */ SubagentSpawnedRequest(String str, String str2, String str3, int i8, i iVar) {
        this((i8 & 1) != 0 ? null : str, (i8 & 2) != 0 ? null : str2, (i8 & 4) != 0 ? null : str3);
    }
}
