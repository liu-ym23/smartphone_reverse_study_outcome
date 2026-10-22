package com.stepos.stepclaw.memory.upload;

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

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002,+B'\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tB7\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\b\u0010\rJ'\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ0\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u001aJ\u0010\u0010 \u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b \u0010\u0018J\u001a\u0010#\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b#\u0010$R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010%\u001a\u0004\b&\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010'\u001a\u0004\b(\u0010\u001aR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010)\u001a\u0004\b*\u0010\u001c¨\u0006-"}, d2 = {"Lcom/stepos/stepclaw/memory/upload/SignatureResponse;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "code", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, OperationResult.EXTRA_MESSAGE, "Lcom/stepos/stepclaw/memory/upload/SignatureData;", "data", "<init>", "(ILjava/lang/String;Lcom/stepos/stepclaw/memory/upload/SignatureData;)V", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(IILjava/lang/String;Lcom/stepos/stepclaw/memory/upload/SignatureData;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lb5/a0;", "write$Self$step_memory_release", "(Lcom/stepos/stepclaw/memory/upload/SignatureResponse;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()I", "component2", "()Ljava/lang/String;", "component3", "()Lcom/stepos/stepclaw/memory/upload/SignatureData;", "copy", "(ILjava/lang/String;Lcom/stepos/stepclaw/memory/upload/SignatureData;)Lcom/stepos/stepclaw/memory/upload/SignatureResponse;", "toString", "hashCode", "other", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "equals", "(Ljava/lang/Object;)Z", "I", "getCode", "Ljava/lang/String;", "getMessage", "Lcom/stepos/stepclaw/memory/upload/SignatureData;", "getData", "Companion", "$serializer", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
/* loaded from: classes.dex */
public final /* data */ class SignatureResponse {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int code;
    private final SignatureData data;
    private final String message;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/stepos/stepclaw/memory/upload/SignatureResponse$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stepos/stepclaw/memory/upload/SignatureResponse;", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final KSerializer<SignatureResponse> serializer() {
            return SignatureResponse$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public SignatureResponse() {
        this(0, (String) null, (SignatureData) null, 7, (i) null);
    }

    public static /* synthetic */ SignatureResponse copy$default(SignatureResponse signatureResponse, int i8, String str, SignatureData signatureData, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i8 = signatureResponse.code;
        }
        if ((i9 & 2) != 0) {
            str = signatureResponse.message;
        }
        if ((i9 & 4) != 0) {
            signatureData = signatureResponse.data;
        }
        return signatureResponse.copy(i8, str, signatureData);
    }

    public static final /* synthetic */ void write$Self$step_memory_release(SignatureResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.code != 0) {
            output.encodeIntElement(serialDesc, 0, self.code);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !p.a(self.message, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID)) {
            output.encodeStringElement(serialDesc, 1, self.message);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.data == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 2, SignatureData$$serializer.INSTANCE, self.data);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component3, reason: from getter */
    public final SignatureData getData() {
        return this.data;
    }

    public final SignatureResponse copy(int code, String message, SignatureData data) {
        p.e(message, "message");
        return new SignatureResponse(code, message, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SignatureResponse)) {
            return false;
        }
        SignatureResponse signatureResponse = (SignatureResponse) other;
        return this.code == signatureResponse.code && p.a(this.message, signatureResponse.message) && p.a(this.data, signatureResponse.data);
    }

    public final int getCode() {
        return this.code;
    }

    public final SignatureData getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        int iF = b.f(Integer.hashCode(this.code) * 31, 31, this.message);
        SignatureData signatureData = this.data;
        return iF + (signatureData == null ? 0 : signatureData.hashCode());
    }

    public String toString() {
        return "SignatureResponse(code=" + this.code + ", message=" + this.message + ", data=" + this.data + ")";
    }

    public /* synthetic */ SignatureResponse(int i8, int i9, String str, SignatureData signatureData, SerializationConstructorMarker serializationConstructorMarker) {
        this.code = (i8 & 1) == 0 ? 0 : i9;
        if ((i8 & 2) == 0) {
            this.message = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        } else {
            this.message = str;
        }
        if ((i8 & 4) == 0) {
            this.data = null;
        } else {
            this.data = signatureData;
        }
    }

    public SignatureResponse(int i8, String message, SignatureData signatureData) {
        p.e(message, "message");
        this.code = i8;
        this.message = message;
        this.data = signatureData;
    }

    public /* synthetic */ SignatureResponse(int i8, String str, SignatureData signatureData, int i9, i iVar) {
        this((i9 & 1) != 0 ? 0 : i8, (i9 & 2) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str, (i9 & 4) != 0 ? null : signatureData);
    }
}
