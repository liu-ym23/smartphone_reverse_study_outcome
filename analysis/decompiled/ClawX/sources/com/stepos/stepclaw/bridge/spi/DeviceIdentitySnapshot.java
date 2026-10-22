package com.stepos.stepclaw.bridge.spi;

import a8.b;
import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/stepos/stepclaw/bridge/spi/DeviceIdentitySnapshot;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "deviceId", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "publicKeyRawBase64", "privateKeyPkcs8Base64", "createdAtMs", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getDeviceId", "()Ljava/lang/String;", "getPublicKeyRawBase64", "getPrivateKeyPkcs8Base64", "getCreatedAtMs", "()J", "component1", "component2", "component3", "component4", "copy", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", "step-bridge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DeviceIdentitySnapshot {
    private final long createdAtMs;
    private final String deviceId;
    private final String privateKeyPkcs8Base64;
    private final String publicKeyRawBase64;

    public DeviceIdentitySnapshot(String deviceId, String publicKeyRawBase64, String privateKeyPkcs8Base64, long j4) {
        p.e(deviceId, "deviceId");
        p.e(publicKeyRawBase64, "publicKeyRawBase64");
        p.e(privateKeyPkcs8Base64, "privateKeyPkcs8Base64");
        this.deviceId = deviceId;
        this.publicKeyRawBase64 = publicKeyRawBase64;
        this.privateKeyPkcs8Base64 = privateKeyPkcs8Base64;
        this.createdAtMs = j4;
    }

    public static /* synthetic */ DeviceIdentitySnapshot copy$default(DeviceIdentitySnapshot deviceIdentitySnapshot, String str, String str2, String str3, long j4, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = deviceIdentitySnapshot.deviceId;
        }
        if ((i8 & 2) != 0) {
            str2 = deviceIdentitySnapshot.publicKeyRawBase64;
        }
        if ((i8 & 4) != 0) {
            str3 = deviceIdentitySnapshot.privateKeyPkcs8Base64;
        }
        if ((i8 & 8) != 0) {
            j4 = deviceIdentitySnapshot.createdAtMs;
        }
        String str4 = str3;
        return deviceIdentitySnapshot.copy(str, str2, str4, j4);
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

    public final DeviceIdentitySnapshot copy(String deviceId, String publicKeyRawBase64, String privateKeyPkcs8Base64, long createdAtMs) {
        p.e(deviceId, "deviceId");
        p.e(publicKeyRawBase64, "publicKeyRawBase64");
        p.e(privateKeyPkcs8Base64, "privateKeyPkcs8Base64");
        return new DeviceIdentitySnapshot(deviceId, publicKeyRawBase64, privateKeyPkcs8Base64, createdAtMs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeviceIdentitySnapshot)) {
            return false;
        }
        DeviceIdentitySnapshot deviceIdentitySnapshot = (DeviceIdentitySnapshot) other;
        return p.a(this.deviceId, deviceIdentitySnapshot.deviceId) && p.a(this.publicKeyRawBase64, deviceIdentitySnapshot.publicKeyRawBase64) && p.a(this.privateKeyPkcs8Base64, deviceIdentitySnapshot.privateKeyPkcs8Base64) && this.createdAtMs == deviceIdentitySnapshot.createdAtMs;
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
        return Long.hashCode(this.createdAtMs) + b.f(b.f(this.deviceId.hashCode() * 31, 31, this.publicKeyRawBase64), 31, this.privateKeyPkcs8Base64);
    }

    public String toString() {
        String str = this.deviceId;
        String str2 = this.publicKeyRawBase64;
        String str3 = this.privateKeyPkcs8Base64;
        long j4 = this.createdAtMs;
        StringBuilder sbV = b.v("DeviceIdentitySnapshot(deviceId=", str, ", publicKeyRawBase64=", str2, ", privateKeyPkcs8Base64=");
        sbV.append(str3);
        sbV.append(", createdAtMs=");
        sbV.append(j4);
        sbV.append(")");
        return sbV.toString();
    }
}
