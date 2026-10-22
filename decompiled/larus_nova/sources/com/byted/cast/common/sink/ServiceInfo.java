package com.byted.cast.common.sink;

import com.byted.cast.common.StringUtil;

/* JADX INFO: loaded from: classes39.dex */
public class ServiceInfo {
    public String bdlinkVersion;
    public String bytelinkVersion;
    public String data;
    public String deviceID;
    public boolean enableVideoNativeDecode;
    public int features;
    public int fps;
    public int height;

    /* JADX INFO: renamed from: ip, reason: collision with root package name */
    public String f33716ip;
    public String ipv6;
    public String name;
    public int port;
    public int portMirror;
    public String protocols;
    public String types;
    public int width;

    public String toString() {
        return "ServiceInfo{name='" + this.name + "', ip='" + StringUtil.base64(this.f33716ip) + "', port=" + this.port + ", data=" + this.data + ", enableVideoNativeDecode=" + this.enableVideoNativeDecode + ", portMirror=" + this.portMirror + ", width=" + this.width + ", height=" + this.height + ", fps=" + this.fps + ", features=" + this.features + ", deviceID=" + this.deviceID + ", bytelinkVersion=" + this.bytelinkVersion + ", bdlinkVersion=" + this.bdlinkVersion + ", types='" + this.types + "', protocols=" + this.protocols + '}';
    }

    public ServiceInfo() {
        this.f33716ip = "";
        this.data = "";
        this.ipv6 = "";
        this.deviceID = "";
        this.bytelinkVersion = "";
        this.bdlinkVersion = "";
        this.types = "";
        this.protocols = "";
    }
}
