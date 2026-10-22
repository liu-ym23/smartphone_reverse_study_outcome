package com.byted.cast.common.bean;

import com.byted.cast.common.api.DisPlayType;
import com.ss.android.ttvecamera.TECameraUtils;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class SinkDeviceInfo extends DeviceInfo {
    public String castId;
    public String cpu;
    public String[] formats;
    public int fps;
    public String googleSinkInfo;
    public int height;

    /* JADX INFO: renamed from: ip, reason: collision with root package name */
    public String f33707ip;
    public boolean isSupportPlayList;
    public int port;
    public int portMirror;
    public List<DisPlayType> supportedCodecs;
    public int width;

    @Override // com.byted.cast.common.bean.DeviceInfo
    public String toString() {
        return "SinkDeviceInfo{ip='" + this.f33707ip + "', port=" + this.port + ", googleSinkInfo='" + this.googleSinkInfo + "', portMirror=" + this.portMirror + ", formats=" + Arrays.toString(this.formats) + ", cpu='" + this.cpu + "', width=" + this.width + ", height=" + this.height + ", fps=" + this.fps + ", castId='" + this.castId + "', isSupportPlayList=" + this.isSupportPlayList + ", supportedCodecs=" + this.supportedCodecs + ", name='" + this.name + "', privateChannel='" + this.privateChannel + "', version='" + this.version + "', data='" + this.data + "', platform='" + this.platform + "', ping=" + this.ping + ", supportGetDeviceInfo=" + this.supportGetDeviceInfo + ", appName='" + this.appName + "', deviceModel='" + this.deviceModel + "', deviceBrand='" + this.deviceBrand + "', appId='" + this.appId + "', userId='" + this.userId + "', deviceId='" + this.deviceId + "', sessionId='" + this.sessionId + "', connectId='" + this.connectId + "', osVersion='" + this.osVersion + "', appVersion='" + this.appVersion + "', bdlinkCmdVersion=" + this.bdlinkCmdVersion + '}';
    }

    public SinkDeviceInfo() {
        this.width = TECameraUtils.CAPTURE_NORMAL;
        this.height = 1080;
        this.fps = 60;
    }
}
