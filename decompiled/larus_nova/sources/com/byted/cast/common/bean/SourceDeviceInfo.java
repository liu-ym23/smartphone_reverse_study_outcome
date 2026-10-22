package com.byted.cast.common.bean;

import com.byted.cast.common.api.DisPlayType;
import java.util.Arrays;

/* JADX INFO: loaded from: classes39.dex */
public class SourceDeviceInfo extends DeviceInfo {
    public String browseId;
    public String clientId;
    public DisPlayType[] codecsDetection;
    public String wsUrl;

    @Override // com.byted.cast.common.bean.DeviceInfo
    public String toString() {
        return "SourceDeviceInfo{codecsDetection=" + Arrays.toString(this.codecsDetection) + ", ping=" + this.ping + ", supportGetDeviceInfo=" + this.supportGetDeviceInfo + ", bdlinkCmdVersion=" + this.bdlinkCmdVersion + ", isSupportSubscriber=" + this.isSupportSubscriber + ", name='" + this.name + "', platform='" + this.platform + "', version='" + this.version + "', osVersion='" + this.osVersion + "', deviceModel='" + this.deviceModel + "', deviceBrand='" + this.deviceBrand + "', appId='" + this.appId + "', appName='" + this.appName + "', appVersion='" + this.appVersion + "', userId='" + this.userId + "', deviceId='" + this.deviceId + "', sessionId='" + this.sessionId + "', connectId='" + this.connectId + "', privateChannel='" + this.privateChannel + "', data='" + this.data + "', bitmap=" + this.bitmap + ", encryptVersion='" + this.encryptVersion + "', preSharedKey='" + this.preSharedKey + "', packageName='" + this.packageName + "'}";
    }

    public SourceDeviceInfo() {
    }

    public SourceDeviceInfo(SourceDeviceInfo r100) {
        this.ping = r100.ping;
        this.supportGetDeviceInfo = r100.supportGetDeviceInfo;
        this.bdlinkCmdVersion = r100.bdlinkCmdVersion;
        this.isSupportSubscriber = r100.isSupportSubscriber;
        this.name = r100.name;
        this.platform = r100.platform;
        this.version = r100.version;
        this.osVersion = r100.osVersion;
        this.deviceModel = r100.deviceModel;
        this.deviceBrand = r100.deviceBrand;
        this.appId = r100.appId;
        this.appName = r100.appName;
        this.appVersion = r100.appVersion;
        this.userId = r100.userId;
        this.deviceId = r100.deviceId;
        this.sessionId = r100.sessionId;
        this.connectId = r100.connectId;
        this.privateChannel = r100.privateChannel;
        this.data = r100.data;
        this.bitmap = r100.bitmap;
        this.encryptVersion = r100.encryptVersion;
        this.preSharedKey = r100.preSharedKey;
        this.copyright = r100.copyright;
        this.packageName = r100.packageName;
        this.browseId = r100.browseId;
        this.clientId = r100.clientId;
        this.wsUrl = r100.wsUrl;
        DisPlayType[] r101 = r100.codecsDetection;
        if (r101 == null) goto L5;
        DisPlayType[] r102 = (DisPlayType[]) Arrays.copyOf(r101, r101.length);
    L6:
        this.codecsDetection = r102;
        return;
    L5:
        r102 = null;
        goto L6
    }
}
