package com.stepos.stepclaw.gateway;

import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003Ja\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006%"}, d2 = {"Lcom/stepos/stepclaw/gateway/GatewayClientInfo;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "id", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "displayName", "version", "platform", "mode", "instanceId", "deviceFamily", "modelIdentifier", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getDisplayName", "getVersion", "getPlatform", "getMode", "getInstanceId", "getDeviceFamily", "getModelIdentifier", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class GatewayClientInfo {
    private final String deviceFamily;
    private final String displayName;
    private final String id;
    private final String instanceId;
    private final String mode;
    private final String modelIdentifier;
    private final String platform;
    private final String version;

    public GatewayClientInfo(String id, String str, String version, String platform, String mode, String str2, String str3, String str4) {
        p.e(id, "id");
        p.e(version, "version");
        p.e(platform, "platform");
        p.e(mode, "mode");
        this.id = id;
        this.displayName = str;
        this.version = version;
        this.platform = platform;
        this.mode = mode;
        this.instanceId = str2;
        this.deviceFamily = str3;
        this.modelIdentifier = str4;
    }

    public static /* synthetic */ GatewayClientInfo copy$default(GatewayClientInfo gatewayClientInfo, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = gatewayClientInfo.id;
        }
        if ((i8 & 2) != 0) {
            str2 = gatewayClientInfo.displayName;
        }
        if ((i8 & 4) != 0) {
            str3 = gatewayClientInfo.version;
        }
        if ((i8 & 8) != 0) {
            str4 = gatewayClientInfo.platform;
        }
        if ((i8 & 16) != 0) {
            str5 = gatewayClientInfo.mode;
        }
        if ((i8 & 32) != 0) {
            str6 = gatewayClientInfo.instanceId;
        }
        if ((i8 & 64) != 0) {
            str7 = gatewayClientInfo.deviceFamily;
        }
        if ((i8 & 128) != 0) {
            str8 = gatewayClientInfo.modelIdentifier;
        }
        String str9 = str7;
        String str10 = str8;
        String str11 = str5;
        String str12 = str6;
        return gatewayClientInfo.copy(str, str2, str3, str4, str11, str12, str9, str10);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* renamed from: component3, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* renamed from: component4, reason: from getter */
    public final String getPlatform() {
        return this.platform;
    }

    /* renamed from: component5, reason: from getter */
    public final String getMode() {
        return this.mode;
    }

    /* renamed from: component6, reason: from getter */
    public final String getInstanceId() {
        return this.instanceId;
    }

    /* renamed from: component7, reason: from getter */
    public final String getDeviceFamily() {
        return this.deviceFamily;
    }

    /* renamed from: component8, reason: from getter */
    public final String getModelIdentifier() {
        return this.modelIdentifier;
    }

    public final GatewayClientInfo copy(String id, String displayName, String version, String platform, String mode, String instanceId, String deviceFamily, String modelIdentifier) {
        p.e(id, "id");
        p.e(version, "version");
        p.e(platform, "platform");
        p.e(mode, "mode");
        return new GatewayClientInfo(id, displayName, version, platform, mode, instanceId, deviceFamily, modelIdentifier);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GatewayClientInfo)) {
            return false;
        }
        GatewayClientInfo gatewayClientInfo = (GatewayClientInfo) other;
        return p.a(this.id, gatewayClientInfo.id) && p.a(this.displayName, gatewayClientInfo.displayName) && p.a(this.version, gatewayClientInfo.version) && p.a(this.platform, gatewayClientInfo.platform) && p.a(this.mode, gatewayClientInfo.mode) && p.a(this.instanceId, gatewayClientInfo.instanceId) && p.a(this.deviceFamily, gatewayClientInfo.deviceFamily) && p.a(this.modelIdentifier, gatewayClientInfo.modelIdentifier);
    }

    public final String getDeviceFamily() {
        return this.deviceFamily;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getId() {
        return this.id;
    }

    public final String getInstanceId() {
        return this.instanceId;
    }

    public final String getMode() {
        return this.mode;
    }

    public final String getModelIdentifier() {
        return this.modelIdentifier;
    }

    public final String getPlatform() {
        return this.platform;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        int iHashCode = this.id.hashCode() * 31;
        String str = this.displayName;
        int iF = a8.b.f(a8.b.f(a8.b.f((iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31, this.version), 31, this.platform), 31, this.mode);
        String str2 = this.instanceId;
        int iHashCode2 = (iF + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.deviceFamily;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.modelIdentifier;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        String str = this.id;
        String str2 = this.displayName;
        String str3 = this.version;
        String str4 = this.platform;
        String str5 = this.mode;
        String str6 = this.instanceId;
        String str7 = this.deviceFamily;
        String str8 = this.modelIdentifier;
        StringBuilder sbV = a8.b.v("GatewayClientInfo(id=", str, ", displayName=", str2, ", version=");
        a8.b.A(sbV, str3, ", platform=", str4, ", mode=");
        a8.b.A(sbV, str5, ", instanceId=", str6, ", deviceFamily=");
        sbV.append(str7);
        sbV.append(", modelIdentifier=");
        sbV.append(str8);
        sbV.append(")");
        return sbV.toString();
    }
}
