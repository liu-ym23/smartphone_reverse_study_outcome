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
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0002$%B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0005\u0010\u000bJ'\u0010\u0014\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0016J(\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0016J\u0010\u0010\u001b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010!\u001a\u0004\b\"\u0010\u0016R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010!\u001a\u0004\b#\u0010\u0016¨\u0006&"}, d2 = {"Lcom/stepos/stepclaw/edge/intercept/model/BeforeModelResolveResponse;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "modelOverride", "providerOverride", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lb5/a0;", "write$Self$step_edge_release", "(Lcom/stepos/stepclaw/edge/intercept/model/BeforeModelResolveResponse;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/String;", "component2", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/stepclaw/edge/intercept/model/BeforeModelResolveResponse;", "toString", "hashCode", "()I", "other", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getModelOverride", "getProviderOverride", "Companion", "$serializer", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
/* loaded from: classes.dex */
public final /* data */ class BeforeModelResolveResponse {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String modelOverride;
    private final String providerOverride;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/stepclaw/edge/intercept/model/BeforeModelResolveResponse$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "empty", "Lcom/stepos/stepclaw/edge/intercept/model/BeforeModelResolveResponse;", "serializer", "Lkotlinx/serialization/KSerializer;", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final BeforeModelResolveResponse empty() {
            return new BeforeModelResolveResponse((String) null, (String) (0 == true ? 1 : 0), 3, (i) (0 == true ? 1 : 0));
        }

        public final KSerializer<BeforeModelResolveResponse> serializer() {
            return BeforeModelResolveResponse$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BeforeModelResolveResponse() {
        this((String) null, (String) (0 == true ? 1 : 0), 3, (i) (0 == true ? 1 : 0));
    }

    public static /* synthetic */ BeforeModelResolveResponse copy$default(BeforeModelResolveResponse beforeModelResolveResponse, String str, String str2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = beforeModelResolveResponse.modelOverride;
        }
        if ((i8 & 2) != 0) {
            str2 = beforeModelResolveResponse.providerOverride;
        }
        return beforeModelResolveResponse.copy(str, str2);
    }

    public static final /* synthetic */ void write$Self$step_edge_release(BeforeModelResolveResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.modelOverride != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.modelOverride);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 1) && self.providerOverride == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.providerOverride);
    }

    /* renamed from: component1, reason: from getter */
    public final String getModelOverride() {
        return this.modelOverride;
    }

    /* renamed from: component2, reason: from getter */
    public final String getProviderOverride() {
        return this.providerOverride;
    }

    public final BeforeModelResolveResponse copy(String modelOverride, String providerOverride) {
        return new BeforeModelResolveResponse(modelOverride, providerOverride);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BeforeModelResolveResponse)) {
            return false;
        }
        BeforeModelResolveResponse beforeModelResolveResponse = (BeforeModelResolveResponse) other;
        return p.a(this.modelOverride, beforeModelResolveResponse.modelOverride) && p.a(this.providerOverride, beforeModelResolveResponse.providerOverride);
    }

    public final String getModelOverride() {
        return this.modelOverride;
    }

    public final String getProviderOverride() {
        return this.providerOverride;
    }

    public int hashCode() {
        String str = this.modelOverride;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.providerOverride;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return b.q("BeforeModelResolveResponse(modelOverride=", this.modelOverride, ", providerOverride=", this.providerOverride, ")");
    }

    public /* synthetic */ BeforeModelResolveResponse(int i8, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
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
    }

    public BeforeModelResolveResponse(String str, String str2) {
        this.modelOverride = str;
        this.providerOverride = str2;
    }

    public /* synthetic */ BeforeModelResolveResponse(String str, String str2, int i8, i iVar) {
        this((i8 & 1) != 0 ? null : str, (i8 & 2) != 0 ? null : str2);
    }
}
