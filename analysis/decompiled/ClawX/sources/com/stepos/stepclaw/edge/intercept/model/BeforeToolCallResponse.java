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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import m0.f;
import org.json.JSONObject;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0087\b\u0018\u0000 /2\u00020\u0001:\u0002/0BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nBM\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000fJ'\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001aJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001aJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u001aJL\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\"\u0010\u001aJ\u0010\u0010#\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b#\u0010$J\u001a\u0010&\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b&\u0010'R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010(\u001a\u0004\b)\u0010\u001aR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010(\u001a\u0004\b*\u0010\u001aR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010(\u001a\u0004\b+\u0010\u001aR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010,\u001a\u0004\b-\u0010\u001eR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010(\u001a\u0004\b.\u0010\u001a¨\u00061"}, d2 = {"Lcom/stepos/stepclaw/edge/intercept/model/BeforeToolCallResponse;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "decision", "reason", "params", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "block", "blockReason", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lb5/a0;", "write$Self$step_edge_release", "(Lcom/stepos/stepclaw/edge/intercept/model/BeforeToolCallResponse;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "()Ljava/lang/Boolean;", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/stepos/stepclaw/edge/intercept/model/BeforeToolCallResponse;", "toString", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDecision", "getReason", "getParams", "Ljava/lang/Boolean;", "getBlock", "getBlockReason", "Companion", "$serializer", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
/* loaded from: classes.dex */
public final /* data */ class BeforeToolCallResponse {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Boolean block;
    private final String blockReason;
    private final String decision;
    private final String params;
    private final String reason;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/stepclaw/edge/intercept/model/BeforeToolCallResponse$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "allow", "Lcom/stepos/stepclaw/edge/intercept/model/BeforeToolCallResponse;", "deny", "reason", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "modify", "params", "Lorg/json/JSONObject;", "block", "serializer", "Lkotlinx/serialization/KSerializer;", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final BeforeToolCallResponse allow() {
            return new BeforeToolCallResponse("allow", (String) null, (String) null, (Boolean) null, (String) null, 30, (i) null);
        }

        public final BeforeToolCallResponse block(String reason) {
            p.e(reason, "reason");
            return new BeforeToolCallResponse((String) null, (String) null, (String) null, Boolean.TRUE, reason, 7, (i) null);
        }

        public final BeforeToolCallResponse deny(String reason) {
            p.e(reason, "reason");
            return new BeforeToolCallResponse("deny", reason, (String) null, (Boolean) null, (String) null, 28, (i) null);
        }

        public final BeforeToolCallResponse modify(JSONObject params) {
            p.e(params, "params");
            return new BeforeToolCallResponse("modify", (String) null, params.toString(), (Boolean) null, (String) null, 26, (i) null);
        }

        public final KSerializer<BeforeToolCallResponse> serializer() {
            return BeforeToolCallResponse$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public BeforeToolCallResponse() {
        this((String) null, (String) null, (String) null, (Boolean) null, (String) null, 31, (i) null);
    }

    public static /* synthetic */ BeforeToolCallResponse copy$default(BeforeToolCallResponse beforeToolCallResponse, String str, String str2, String str3, Boolean bool, String str4, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = beforeToolCallResponse.decision;
        }
        if ((i8 & 2) != 0) {
            str2 = beforeToolCallResponse.reason;
        }
        if ((i8 & 4) != 0) {
            str3 = beforeToolCallResponse.params;
        }
        if ((i8 & 8) != 0) {
            bool = beforeToolCallResponse.block;
        }
        if ((i8 & 16) != 0) {
            str4 = beforeToolCallResponse.blockReason;
        }
        String str5 = str4;
        String str6 = str3;
        return beforeToolCallResponse.copy(str, str2, str6, bool, str5);
    }

    public static final /* synthetic */ void write$Self$step_edge_release(BeforeToolCallResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.decision != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.decision);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.reason != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.reason);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.params != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.params);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.block != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, BooleanSerializer.INSTANCE, self.block);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.blockReason == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.blockReason);
    }

    /* renamed from: component1, reason: from getter */
    public final String getDecision() {
        return this.decision;
    }

    /* renamed from: component2, reason: from getter */
    public final String getReason() {
        return this.reason;
    }

    /* renamed from: component3, reason: from getter */
    public final String getParams() {
        return this.params;
    }

    /* renamed from: component4, reason: from getter */
    public final Boolean getBlock() {
        return this.block;
    }

    /* renamed from: component5, reason: from getter */
    public final String getBlockReason() {
        return this.blockReason;
    }

    public final BeforeToolCallResponse copy(String decision, String reason, String params, Boolean block, String blockReason) {
        return new BeforeToolCallResponse(decision, reason, params, block, blockReason);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BeforeToolCallResponse)) {
            return false;
        }
        BeforeToolCallResponse beforeToolCallResponse = (BeforeToolCallResponse) other;
        return p.a(this.decision, beforeToolCallResponse.decision) && p.a(this.reason, beforeToolCallResponse.reason) && p.a(this.params, beforeToolCallResponse.params) && p.a(this.block, beforeToolCallResponse.block) && p.a(this.blockReason, beforeToolCallResponse.blockReason);
    }

    public final Boolean getBlock() {
        return this.block;
    }

    public final String getBlockReason() {
        return this.blockReason;
    }

    public final String getDecision() {
        return this.decision;
    }

    public final String getParams() {
        return this.params;
    }

    public final String getReason() {
        return this.reason;
    }

    public int hashCode() {
        String str = this.decision;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.reason;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.params;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool = this.block;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str4 = this.blockReason;
        return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        String str = this.decision;
        String str2 = this.reason;
        String str3 = this.params;
        Boolean bool = this.block;
        String str4 = this.blockReason;
        StringBuilder sbV = b.v("BeforeToolCallResponse(decision=", str, ", reason=", str2, ", params=");
        sbV.append(str3);
        sbV.append(", block=");
        sbV.append(bool);
        sbV.append(", blockReason=");
        return f.f(sbV, str4, ")");
    }

    public /* synthetic */ BeforeToolCallResponse(int i8, String str, String str2, String str3, Boolean bool, String str4, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i8 & 1) == 0) {
            this.decision = null;
        } else {
            this.decision = str;
        }
        if ((i8 & 2) == 0) {
            this.reason = null;
        } else {
            this.reason = str2;
        }
        if ((i8 & 4) == 0) {
            this.params = null;
        } else {
            this.params = str3;
        }
        if ((i8 & 8) == 0) {
            this.block = null;
        } else {
            this.block = bool;
        }
        if ((i8 & 16) == 0) {
            this.blockReason = null;
        } else {
            this.blockReason = str4;
        }
    }

    public BeforeToolCallResponse(String str, String str2, String str3, Boolean bool, String str4) {
        this.decision = str;
        this.reason = str2;
        this.params = str3;
        this.block = bool;
        this.blockReason = str4;
    }

    public /* synthetic */ BeforeToolCallResponse(String str, String str2, String str3, Boolean bool, String str4, int i8, i iVar) {
        this((i8 & 1) != 0 ? null : str, (i8 & 2) != 0 ? null : str2, (i8 & 4) != 0 ? null : str3, (i8 & 8) != 0 ? null : bool, (i8 & 16) != 0 ? null : str4);
    }
}
