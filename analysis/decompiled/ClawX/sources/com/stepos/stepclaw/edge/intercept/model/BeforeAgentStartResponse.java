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

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0002*+B7\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bBC\b\u0010\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0007\u0010\rJ'\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0018J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0018J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0018J@\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0018J\u0010\u0010\u001f\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010#\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b#\u0010$R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010%\u001a\u0004\b&\u0010\u0018R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010%\u001a\u0004\b'\u0010\u0018R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010%\u001a\u0004\b(\u0010\u0018R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010%\u001a\u0004\b)\u0010\u0018¨\u0006,"}, d2 = {"Lcom/stepos/stepclaw/edge/intercept/model/BeforeAgentStartResponse;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "modelOverride", "providerOverride", "systemPrompt", "prependContext", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lb5/a0;", "write$Self$step_edge_release", "(Lcom/stepos/stepclaw/edge/intercept/model/BeforeAgentStartResponse;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/stepclaw/edge/intercept/model/BeforeAgentStartResponse;", "toString", "hashCode", "()I", "other", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getModelOverride", "getProviderOverride", "getSystemPrompt", "getPrependContext", "Companion", "$serializer", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
/* loaded from: classes.dex */
public final /* data */ class BeforeAgentStartResponse {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String modelOverride;
    private final String prependContext;
    private final String providerOverride;
    private final String systemPrompt;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/stepclaw/edge/intercept/model/BeforeAgentStartResponse$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "empty", "Lcom/stepos/stepclaw/edge/intercept/model/BeforeAgentStartResponse;", "serializer", "Lkotlinx/serialization/KSerializer;", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final BeforeAgentStartResponse empty() {
            return new BeforeAgentStartResponse((String) null, (String) null, (String) null, (String) null, 15, (i) null);
        }

        public final KSerializer<BeforeAgentStartResponse> serializer() {
            return BeforeAgentStartResponse$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public BeforeAgentStartResponse() {
        this((String) null, (String) null, (String) null, (String) null, 15, (i) null);
    }

    public static /* synthetic */ BeforeAgentStartResponse copy$default(BeforeAgentStartResponse beforeAgentStartResponse, String str, String str2, String str3, String str4, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = beforeAgentStartResponse.modelOverride;
        }
        if ((i8 & 2) != 0) {
            str2 = beforeAgentStartResponse.providerOverride;
        }
        if ((i8 & 4) != 0) {
            str3 = beforeAgentStartResponse.systemPrompt;
        }
        if ((i8 & 8) != 0) {
            str4 = beforeAgentStartResponse.prependContext;
        }
        return beforeAgentStartResponse.copy(str, str2, str3, str4);
    }

    public static final /* synthetic */ void write$Self$step_edge_release(BeforeAgentStartResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.modelOverride != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.modelOverride);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.providerOverride != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.providerOverride);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.systemPrompt != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.systemPrompt);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 3) && self.prependContext == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.prependContext);
    }

    /* renamed from: component1, reason: from getter */
    public final String getModelOverride() {
        return this.modelOverride;
    }

    /* renamed from: component2, reason: from getter */
    public final String getProviderOverride() {
        return this.providerOverride;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSystemPrompt() {
        return this.systemPrompt;
    }

    /* renamed from: component4, reason: from getter */
    public final String getPrependContext() {
        return this.prependContext;
    }

    public final BeforeAgentStartResponse copy(String modelOverride, String providerOverride, String systemPrompt, String prependContext) {
        return new BeforeAgentStartResponse(modelOverride, providerOverride, systemPrompt, prependContext);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BeforeAgentStartResponse)) {
            return false;
        }
        BeforeAgentStartResponse beforeAgentStartResponse = (BeforeAgentStartResponse) other;
        return p.a(this.modelOverride, beforeAgentStartResponse.modelOverride) && p.a(this.providerOverride, beforeAgentStartResponse.providerOverride) && p.a(this.systemPrompt, beforeAgentStartResponse.systemPrompt) && p.a(this.prependContext, beforeAgentStartResponse.prependContext);
    }

    public final String getModelOverride() {
        return this.modelOverride;
    }

    public final String getPrependContext() {
        return this.prependContext;
    }

    public final String getProviderOverride() {
        return this.providerOverride;
    }

    public final String getSystemPrompt() {
        return this.systemPrompt;
    }

    public int hashCode() {
        String str = this.modelOverride;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.providerOverride;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.systemPrompt;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.prependContext;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        String str = this.modelOverride;
        String str2 = this.providerOverride;
        String str3 = this.systemPrompt;
        String str4 = this.prependContext;
        StringBuilder sbV = b.v("BeforeAgentStartResponse(modelOverride=", str, ", providerOverride=", str2, ", systemPrompt=");
        sbV.append(str3);
        sbV.append(", prependContext=");
        sbV.append(str4);
        sbV.append(")");
        return sbV.toString();
    }

    public /* synthetic */ BeforeAgentStartResponse(int i8, String str, String str2, String str3, String str4, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i8 & 1) == 0) {
            this.modelOverride = null;
        } else {
            this.modelOverride = str;
        }
        if ((i8 & 2) == 0) {
            this.providerOverride = null;
        } else {
            this.providerOverride = str2;
        }
        if ((i8 & 4) == 0) {
            this.systemPrompt = null;
        } else {
            this.systemPrompt = str3;
        }
        if ((i8 & 8) == 0) {
            this.prependContext = null;
        } else {
            this.prependContext = str4;
        }
    }

    public BeforeAgentStartResponse(String str, String str2, String str3, String str4) {
        this.modelOverride = str;
        this.providerOverride = str2;
        this.systemPrompt = str3;
        this.prependContext = str4;
    }

    public /* synthetic */ BeforeAgentStartResponse(String str, String str2, String str3, String str4, int i8, i iVar) {
        this((i8 & 1) != 0 ? null : str, (i8 & 2) != 0 ? null : str2, (i8 & 4) != 0 ? null : str3, (i8 & 8) != 0 ? null : str4);
    }
}
