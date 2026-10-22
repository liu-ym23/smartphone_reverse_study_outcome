package com.byted.cast.common.sink;

/* JADX INFO: loaded from: classes39.dex */
public class ClientInfo {
    public static final int TYPE_SINK = 102;
    public static final int TYPE_SOURCE = 101;
    public String clientID;
    public String icon;

    /* JADX INFO: renamed from: ip, reason: collision with root package name */
    public String f33715ip;
    public int mirrorSourceType;
    public String name;
    public int port;
    public int sourceType;
    public String state;
    public boolean useCustomizedService;

    public String toString() {
        return "ClientInfo{clientID='" + this.clientID + "', name='" + this.name + "', icon='" + this.icon + "', sourceType=" + this.sourceType + ", mirrorSourceType=" + this.mirrorSourceType + ", ip='" + this.f33715ip + "', port='" + this.port + "', useCustomizedService='" + this.useCustomizedService + "'}";
    }

    public ClientInfo() {
        this.mirrorSourceType = 101;
        this.useCustomizedService = false;
    }
}
