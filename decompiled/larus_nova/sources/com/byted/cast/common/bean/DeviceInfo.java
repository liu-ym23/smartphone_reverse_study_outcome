package com.byted.cast.common.bean;

/* JADX INFO: loaded from: classes39.dex */
public class DeviceInfo {
    public String appId;
    public String appName;
    public String appVersion;
    public int bdlinkCmdVersion;
    public long bitmap;
    public String connectId;
    public String copyright;
    public String data;
    public String deviceBrand;
    public String deviceId;
    public String deviceModel;
    public String encryptVersion;
    public boolean isSupportSubscriber;
    public String name;
    public String osVersion;
    public String packageName;
    public int ping;
    public String platform;
    public String preSharedKey;
    public String privateChannel;
    public String sessionId;
    public boolean supportGetDeviceInfo;
    public String userId;
    public String version;

    public boolean supportPing() {
        if (this.ping == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public String toString() {
        return "DeviceInfo{name='" + this.name + "', privateChannel='" + this.privateChannel + "', version='" + this.version + "', data='" + this.data + "', platform='" + this.platform + "', ping=" + this.ping + ", supportGetDeviceInfo=" + this.supportGetDeviceInfo + ", appName='" + this.appName + "', deviceModel='" + this.deviceModel + "', deviceBrand='" + this.deviceBrand + "', appId='" + this.appId + "', userId='" + this.userId + "', deviceId='" + this.deviceId + "', sessionId='" + this.sessionId + "', connectId='" + this.connectId + "', osVersion='" + this.osVersion + "', appVersion='" + this.appVersion + "', bdlinkCmdVersion=" + this.bdlinkCmdVersion + ", copyright=" + this.copyright + ", isSupportSubscriber=" + this.isSupportSubscriber + ", packageName=" + this.packageName + '}';
    }

    public DeviceInfo() {
        this.isSupportSubscriber = false;
        this.connectId = "";
    }
}
