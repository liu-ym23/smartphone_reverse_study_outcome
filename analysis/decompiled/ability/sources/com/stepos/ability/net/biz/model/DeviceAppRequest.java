package com.stepos.ability.net.biz.model;

import B7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003JA\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/stepos/ability/net/biz/model/DeviceAppRequest;", "", "deviceId", "", "installType", "deviceModel", "osVersion", "apps", "", "Lcom/stepos/ability/net/biz/model/AppItem;", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getDeviceId", "()Ljava/lang/String;", "getInstallType", "getDeviceModel", "getOsVersion", "getApps", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DeviceAppRequest {

    @SerializedName("apps")
    private final List<AppItem> apps;

    @SerializedName("deviceId")
    private final String deviceId;

    @SerializedName("deviceModel")
    private final String deviceModel;

    @SerializedName("installType")
    private final String installType;

    @SerializedName("osVersion")
    private final String osVersion;

    public DeviceAppRequest(String deviceId, String installType, String deviceModel, String osVersion, List<AppItem> apps) {
        k.f(deviceId, "deviceId");
        k.f(installType, "installType");
        k.f(deviceModel, "deviceModel");
        k.f(osVersion, "osVersion");
        k.f(apps, "apps");
        this.deviceId = deviceId;
        this.installType = installType;
        this.deviceModel = deviceModel;
        this.osVersion = osVersion;
        this.apps = apps;
    }

    public static /* synthetic */ DeviceAppRequest copy$default(DeviceAppRequest deviceAppRequest, String str, String str2, String str3, String str4, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deviceAppRequest.deviceId;
        }
        if ((i & 2) != 0) {
            str2 = deviceAppRequest.installType;
        }
        if ((i & 4) != 0) {
            str3 = deviceAppRequest.deviceModel;
        }
        if ((i & 8) != 0) {
            str4 = deviceAppRequest.osVersion;
        }
        if ((i & 16) != 0) {
            list = deviceAppRequest.apps;
        }
        List list2 = list;
        String str5 = str3;
        return deviceAppRequest.copy(str, str2, str5, str4, list2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getInstallType() {
        return this.installType;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDeviceModel() {
        return this.deviceModel;
    }

    /* renamed from: component4, reason: from getter */
    public final String getOsVersion() {
        return this.osVersion;
    }

    public final List<AppItem> component5() {
        return this.apps;
    }

    public final DeviceAppRequest copy(String deviceId, String installType, String deviceModel, String osVersion, List<AppItem> apps) {
        k.f(deviceId, "deviceId");
        k.f(installType, "installType");
        k.f(deviceModel, "deviceModel");
        k.f(osVersion, "osVersion");
        k.f(apps, "apps");
        return new DeviceAppRequest(deviceId, installType, deviceModel, osVersion, apps);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeviceAppRequest)) {
            return false;
        }
        DeviceAppRequest deviceAppRequest = (DeviceAppRequest) other;
        return k.b(this.deviceId, deviceAppRequest.deviceId) && k.b(this.installType, deviceAppRequest.installType) && k.b(this.deviceModel, deviceAppRequest.deviceModel) && k.b(this.osVersion, deviceAppRequest.osVersion) && k.b(this.apps, deviceAppRequest.apps);
    }

    public final List<AppItem> getApps() {
        return this.apps;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getDeviceModel() {
        return this.deviceModel;
    }

    public final String getInstallType() {
        return this.installType;
    }

    public final String getOsVersion() {
        return this.osVersion;
    }

    public int hashCode() {
        return this.apps.hashCode() + a.c(a.c(a.c(this.deviceId.hashCode() * 31, 31, this.installType), 31, this.deviceModel), 31, this.osVersion);
    }

    public String toString() {
        String str = this.deviceId;
        String str2 = this.installType;
        String str3 = this.deviceModel;
        String str4 = this.osVersion;
        List<AppItem> list = this.apps;
        StringBuilder sbW = a.w("DeviceAppRequest(deviceId=", str, ", installType=", str2, ", deviceModel=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str3, ", osVersion=", str4, ", apps=");
        return androidx.appfunctions.metadata.a.q(sbW, list, ")");
    }
}
