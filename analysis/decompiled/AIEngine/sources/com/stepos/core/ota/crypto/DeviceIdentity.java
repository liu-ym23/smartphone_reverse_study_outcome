package com.stepos.core.ota.crypto;

import ai.onnxruntime.a;
import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DeviceIdentity {
    private final String deviceAppId;
    private final String deviceId;
    private final String fingerprint;

    public DeviceIdentity(String deviceAppId, String deviceId, String fingerprint) {
        g.f(deviceAppId, "deviceAppId");
        g.f(deviceId, "deviceId");
        g.f(fingerprint, "fingerprint");
        this.deviceAppId = deviceAppId;
        this.deviceId = deviceId;
        this.fingerprint = fingerprint;
    }

    public static /* synthetic */ DeviceIdentity copy$default(DeviceIdentity deviceIdentity, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = deviceIdentity.deviceAppId;
        }
        if ((i10 & 2) != 0) {
            str2 = deviceIdentity.deviceId;
        }
        if ((i10 & 4) != 0) {
            str3 = deviceIdentity.fingerprint;
        }
        return deviceIdentity.copy(str, str2, str3);
    }

    public final String component1() {
        return this.deviceAppId;
    }

    public final String component2() {
        return this.deviceId;
    }

    public final String component3() {
        return this.fingerprint;
    }

    public final DeviceIdentity copy(String deviceAppId, String deviceId, String fingerprint) {
        g.f(deviceAppId, "deviceAppId");
        g.f(deviceId, "deviceId");
        g.f(fingerprint, "fingerprint");
        return new DeviceIdentity(deviceAppId, deviceId, fingerprint);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceIdentity)) {
            return false;
        }
        DeviceIdentity deviceIdentity = (DeviceIdentity) obj;
        return g.b(this.deviceAppId, deviceIdentity.deviceAppId) && g.b(this.deviceId, deviceIdentity.deviceId) && g.b(this.fingerprint, deviceIdentity.fingerprint);
    }

    public final String getDeviceAppId() {
        return this.deviceAppId;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getFingerprint() {
        return this.fingerprint;
    }

    public int hashCode() {
        return this.fingerprint.hashCode() + d.a(this.deviceAppId.hashCode() * 31, 31, this.deviceId);
    }

    public String toString() {
        String str = this.deviceAppId;
        String str2 = this.deviceId;
        return a.o(a.s("DeviceIdentity(deviceAppId=", str, ", deviceId=", str2, ", fingerprint="), this.fingerprint, ")");
    }
}
