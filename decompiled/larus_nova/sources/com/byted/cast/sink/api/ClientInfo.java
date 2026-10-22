package com.byted.cast.sink.api;

/* JADX INFO: loaded from: classes43.dex */
public class ClientInfo {
    public static final int TYPE_SINK = 102;
    public static final int TYPE_SOURCE = 101;
    public String clientID;
    public String icon;

    /* JADX INFO: renamed from: ip, reason: collision with root package name */
    public String f33826ip;
    public int mirrorSourceType;
    public String name;
    public int sourceType;

    public ClientInfo() {
        this.mirrorSourceType = 101;
    }

    public String toString() {
        return "ClientInfo{clientID='" + this.clientID + "', name='" + this.name + "', ip=" + this.f33826ip + "', icon='" + this.icon + "', sourceType=" + this.sourceType + ", mirrorSourceType=" + this.mirrorSourceType + '}';
    }
}
