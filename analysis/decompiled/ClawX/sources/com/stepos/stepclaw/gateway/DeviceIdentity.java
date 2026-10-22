package com.stepos.stepclaw.gateway;

import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0002.-B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tBA\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\b\u0010\u000eJ'\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0019J\u0010\u0010\u001c\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ8\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b \u0010\u0019J\u0010\u0010!\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010%\u001a\u00020$2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b%\u0010&R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010'\u001a\u0004\b(\u0010\u0019R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010'\u001a\u0004\b)\u0010\u0019R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010'\u001a\u0004\b*\u0010\u0019R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010+\u001a\u0004\b,\u0010\u001d¨\u0006/"}, d2 = {"Lcom/stepos/stepclaw/gateway/DeviceIdentity;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "deviceId", "publicKeyRawBase64", "privateKeyPkcs8Base64", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "createdAtMs", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lb5/a0;", "write$Self$step_runtime_release", "(Lcom/stepos/stepclaw/gateway/DeviceIdentity;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "()J", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)Lcom/stepos/stepclaw/gateway/DeviceIdentity;", "toString", "hashCode", "()I", "other", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDeviceId", "getPublicKeyRawBase64", "getPrivateKeyPkcs8Base64", "J", "getCreatedAtMs", "Companion", "$serializer", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
/* loaded from: classes.dex */
public final /* data */ class DeviceIdentity {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long createdAtMs;
    private final String deviceId;
    private final String privateKeyPkcs8Base64;
    private final String publicKeyRawBase64;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/stepos/stepclaw/gateway/DeviceIdentity$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stepos/stepclaw/gateway/DeviceIdentity;", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final KSerializer<DeviceIdentity> serializer() {
            return DeviceIdentity$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ DeviceIdentity(int i8, String str, String str2, String str3, long j4, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i8 & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i8, 15, DeviceIdentity$$serializer.INSTANCE.getDescriptor());
        }
        this.deviceId = str;
        this.publicKeyRawBase64 = str2;
        this.privateKeyPkcs8Base64 = str3;
        this.createdAtMs = j4;
    }

    public static /* synthetic */ DeviceIdentity copy$default(DeviceIdentity deviceIdentity, String str, String str2, String str3, long j4, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = deviceIdentity.deviceId;
        }
        if ((i8 & 2) != 0) {
            str2 = deviceIdentity.publicKeyRawBase64;
        }
        if ((i8 & 4) != 0) {
            str3 = deviceIdentity.privateKeyPkcs8Base64;
        }
        if ((i8 & 8) != 0) {
            j4 = deviceIdentity.createdAtMs;
        }
        String str4 = str3;
        return deviceIdentity.copy(str, str2, str4, j4);
    }

    public static final /* synthetic */ void write$Self$step_runtime_release(DeviceIdentity self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.deviceId);
        output.encodeStringElement(serialDesc, 1, self.publicKeyRawBase64);
        output.encodeStringElement(serialDesc, 2, self.privateKeyPkcs8Base64);
        output.encodeLongElement(serialDesc, 3, self.createdAtMs);
    }

    /* renamed from: component1, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPublicKeyRawBase64() {
        return this.publicKeyRawBase64;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPrivateKeyPkcs8Base64() {
        return this.privateKeyPkcs8Base64;
    }

    /* renamed from: component4, reason: from getter */
    public final long getCreatedAtMs() {
        return this.createdAtMs;
    }

    public final DeviceIdentity copy(String deviceId, String publicKeyRawBase64, String privateKeyPkcs8Base64, long createdAtMs) {
        p.e(deviceId, "deviceId");
        p.e(publicKeyRawBase64, "publicKeyRawBase64");
        p.e(privateKeyPkcs8Base64, "privateKeyPkcs8Base64");
        return new DeviceIdentity(deviceId, publicKeyRawBase64, privateKeyPkcs8Base64, createdAtMs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeviceIdentity)) {
            return false;
        }
        DeviceIdentity deviceIdentity = (DeviceIdentity) other;
        return p.a(this.deviceId, deviceIdentity.deviceId) && p.a(this.publicKeyRawBase64, deviceIdentity.publicKeyRawBase64) && p.a(this.privateKeyPkcs8Base64, deviceIdentity.privateKeyPkcs8Base64) && this.createdAtMs == deviceIdentity.createdAtMs;
    }

    public final long getCreatedAtMs() {
        return this.createdAtMs;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getPrivateKeyPkcs8Base64() {
        return this.privateKeyPkcs8Base64;
    }

    public final String getPublicKeyRawBase64() {
        return this.publicKeyRawBase64;
    }

    public int hashCode() {
        return Long.hashCode(this.createdAtMs) + a8.b.f(a8.b.f(this.deviceId.hashCode() * 31, 31, this.publicKeyRawBase64), 31, this.privateKeyPkcs8Base64);
    }

    public String toString() {
        String str = this.deviceId;
        String str2 = this.publicKeyRawBase64;
        String str3 = this.privateKeyPkcs8Base64;
        long j4 = this.createdAtMs;
        StringBuilder sbV = a8.b.v("DeviceIdentity(deviceId=", str, ", publicKeyRawBase64=", str2, ", privateKeyPkcs8Base64=");
        sbV.append(str3);
        sbV.append(", createdAtMs=");
        sbV.append(j4);
        sbV.append(")");
        return sbV.toString();
    }

    public DeviceIdentity(String deviceId, String publicKeyRawBase64, String privateKeyPkcs8Base64, long j4) {
        p.e(deviceId, "deviceId");
        p.e(publicKeyRawBase64, "publicKeyRawBase64");
        p.e(privateKeyPkcs8Base64, "privateKeyPkcs8Base64");
        this.deviceId = deviceId;
        this.publicKeyRawBase64 = publicKeyRawBase64;
        this.privateKeyPkcs8Base64 = privateKeyPkcs8Base64;
        this.createdAtMs = j4;
    }
}
