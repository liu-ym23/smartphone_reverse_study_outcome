package com.stepos.stepclaw.memory.upload;

import a4.b;
import b5.e;
import b5.f;
import b8.h;
import c5.t;
import com.stepos.stepclaw.SecurePrefs;
import java.util.Map;
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
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u0000 02\u00020\u0001:\u000210B;\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nBM\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000fJ'\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001aJ\u001c\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJD\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\"\u0010\u001aJ\u0010\u0010#\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b#\u0010$J\u001a\u0010'\u001a\u00020&2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b'\u0010(R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010)\u001a\u0004\b*\u0010\u001aR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010)\u001a\u0004\b+\u0010\u001aR#\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010,\u001a\u0004\b-\u0010\u001dR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010.\u001a\u0004\b/\u0010\u001f¨\u00062"}, d2 = {"Lcom/stepos/stepclaw/memory/upload/SignatureData;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "uploadUrl", "objectKey", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "formFields", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "expiresIn", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;J)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/Map;JLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lb5/a0;", "write$Self$step_memory_release", "(Lcom/stepos/stepclaw/memory/upload/SignatureData;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/String;", "component2", "component3", "()Ljava/util/Map;", "component4", "()J", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;J)Lcom/stepos/stepclaw/memory/upload/SignatureData;", "toString", "hashCode", "()I", "other", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getUploadUrl", "getObjectKey", "Ljava/util/Map;", "getFormFields", "J", "getExpiresIn", "Companion", "$serializer", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
/* loaded from: classes.dex */
public final /* data */ class SignatureData {
    private final long expiresIn;
    private final Map<String, String> formFields;
    private final String objectKey;
    private final String uploadUrl;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final e[] $childSerializers = {null, null, h.w(f.f889a, new b(26)), null};

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/stepos/stepclaw/memory/upload/SignatureData$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stepos/stepclaw/memory/upload/SignatureData;", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final KSerializer<SignatureData> serializer() {
            return SignatureData$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public SignatureData() {
        this((String) null, (String) null, (Map) null, 0L, 15, (i) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new LinkedHashMapSerializer(stringSerializer, stringSerializer);
    }

    public static /* synthetic */ SignatureData copy$default(SignatureData signatureData, String str, String str2, Map map, long j4, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = signatureData.uploadUrl;
        }
        if ((i8 & 2) != 0) {
            str2 = signatureData.objectKey;
        }
        if ((i8 & 4) != 0) {
            map = signatureData.formFields;
        }
        if ((i8 & 8) != 0) {
            j4 = signatureData.expiresIn;
        }
        Map map2 = map;
        return signatureData.copy(str, str2, map2, j4);
    }

    public static final /* synthetic */ void write$Self$step_memory_release(SignatureData self, CompositeEncoder output, SerialDescriptor serialDesc) {
        e[] eVarArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !p.a(self.uploadUrl, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID)) {
            output.encodeStringElement(serialDesc, 0, self.uploadUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !p.a(self.objectKey, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID)) {
            output.encodeStringElement(serialDesc, 1, self.objectKey);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !p.a(self.formFields, t.f1093a)) {
            output.encodeSerializableElement(serialDesc, 2, (SerializationStrategy) eVarArr[2].getValue(), self.formFields);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 3) && self.expiresIn == 0) {
            return;
        }
        output.encodeLongElement(serialDesc, 3, self.expiresIn);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUploadUrl() {
        return this.uploadUrl;
    }

    /* renamed from: component2, reason: from getter */
    public final String getObjectKey() {
        return this.objectKey;
    }

    public final Map<String, String> component3() {
        return this.formFields;
    }

    /* renamed from: component4, reason: from getter */
    public final long getExpiresIn() {
        return this.expiresIn;
    }

    public final SignatureData copy(String uploadUrl, String objectKey, Map<String, String> formFields, long expiresIn) {
        p.e(uploadUrl, "uploadUrl");
        p.e(objectKey, "objectKey");
        p.e(formFields, "formFields");
        return new SignatureData(uploadUrl, objectKey, formFields, expiresIn);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SignatureData)) {
            return false;
        }
        SignatureData signatureData = (SignatureData) other;
        return p.a(this.uploadUrl, signatureData.uploadUrl) && p.a(this.objectKey, signatureData.objectKey) && p.a(this.formFields, signatureData.formFields) && this.expiresIn == signatureData.expiresIn;
    }

    public final long getExpiresIn() {
        return this.expiresIn;
    }

    public final Map<String, String> getFormFields() {
        return this.formFields;
    }

    public final String getObjectKey() {
        return this.objectKey;
    }

    public final String getUploadUrl() {
        return this.uploadUrl;
    }

    public int hashCode() {
        return Long.hashCode(this.expiresIn) + ((this.formFields.hashCode() + a8.b.f(this.uploadUrl.hashCode() * 31, 31, this.objectKey)) * 31);
    }

    public String toString() {
        String str = this.uploadUrl;
        String str2 = this.objectKey;
        Map<String, String> map = this.formFields;
        long j4 = this.expiresIn;
        StringBuilder sbV = a8.b.v("SignatureData(uploadUrl=", str, ", objectKey=", str2, ", formFields=");
        sbV.append(map);
        sbV.append(", expiresIn=");
        sbV.append(j4);
        sbV.append(")");
        return sbV.toString();
    }

    public /* synthetic */ SignatureData(int i8, String str, String str2, Map map, long j4, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i8 & 1) == 0) {
            this.uploadUrl = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        } else {
            this.uploadUrl = str;
        }
        if ((i8 & 2) == 0) {
            this.objectKey = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        } else {
            this.objectKey = str2;
        }
        if ((i8 & 4) == 0) {
            this.formFields = t.f1093a;
        } else {
            this.formFields = map;
        }
        if ((i8 & 8) == 0) {
            this.expiresIn = 0L;
        } else {
            this.expiresIn = j4;
        }
    }

    public SignatureData(String uploadUrl, String objectKey, Map<String, String> formFields, long j4) {
        p.e(uploadUrl, "uploadUrl");
        p.e(objectKey, "objectKey");
        p.e(formFields, "formFields");
        this.uploadUrl = uploadUrl;
        this.objectKey = objectKey;
        this.formFields = formFields;
        this.expiresIn = j4;
    }

    public /* synthetic */ SignatureData(String str, String str2, Map map, long j4, int i8, i iVar) {
        this((i8 & 1) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str, (i8 & 2) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str2, (i8 & 4) != 0 ? t.f1093a : map, (i8 & 8) != 0 ? 0L : j4);
    }
}
