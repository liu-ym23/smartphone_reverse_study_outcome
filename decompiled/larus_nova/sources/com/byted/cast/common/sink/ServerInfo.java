package com.byted.cast.common.sink;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public class ServerInfo {
    public static final int DEFAULT_SERVICE_ID = 0;
    public static final int ERROR_BIND_SERVICE = 10000;
    public static final int ERROR_INVALID_MAC = 20000;
    public static final int ERROR_PERMISSION_REQUEST_FAILED = -2002;
    public static final int ERROR_PORT_FAILED = 30000;
    public static final int EXTRA_PORT_BYTE_LINK_AUDIO = 800;
    public static final int EXTRA_PORT_BYTE_LINK_FP_AUDIO = 200;
    public static final int EXTRA_PORT_BYTE_LINK_FP_MIRROR = 100;
    public static final int EXTRA_PORT_BYTE_LINK_MIRROR = 400;
    public static final int SERVER_IDLE = 0;
    public static final int SERVER_STARTED = 2;
    public static final int SERVER_STARTING = 1;
    public static final int SERVER_STOPPING = 3;
    public String aliasName;
    public int cloudPreemptModel;
    public String deviceName;
    public int displayMode;
    public String flvUrl;
    public int forceResetMirrorPlayer;
    public String httpPlayUrl;
    public String httpUrl;
    public int language;
    public int localPreemptModel;
    public int maxFps;
    public long netDelay;
    public String networkName;
    public int playerType;
    public String portInfo;
    public String protocols;
    public int remotePort;
    public int remotePortBDLINK;
    public int remotePortMirror;
    public String resolution;
    public String rtmpUrl;
    public int serverPort;
    public int serviceStatus;
    public boolean showFps;
    public int surfaceType;

    public String toString() {
        return "ServiceInfo{serviceStatus='" + this.serviceStatus + "', deviceName='" + this.deviceName + "', aliasName=" + this.aliasName + ", networkName=" + this.networkName + ", remotePort='" + this.remotePort + "', remotePortMirror='" + this.remotePortMirror + "', remotePortBDLINK='" + this.remotePortBDLINK + "', protocols=" + this.protocols + ", serverPort=" + this.serverPort + ", resolution=" + this.resolution + ", portInfo='" + this.portInfo + "'}";
    }

    public ServerInfo() {
        this.remotePortMirror = -1;
        this.remotePortBDLINK = -1;
        this.protocols = "";
        this.portInfo = "";
        this.forceResetMirrorPlayer = 0;
        this.netDelay = -1;
        this.rtmpUrl = "";
        this.flvUrl = "";
        this.httpUrl = "";
        this.httpPlayUrl = "";
    }

    public void appendPortInfo(Map<String, CallbackServerInfo> r100) {
        Iterator<Map.Entry<String, CallbackServerInfo>> r101 = r100.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        Map.Entry<String, CallbackServerInfo> r102 = r101.next();
        if (r102.getKey().equals("ByteLink") == false) goto L9;
        this.protocols = this.protocols.concat("ByteLink,");
        this.remotePortMirror = r102.getValue().serverInfo.serverPort;
    L9:
        if (r102.getKey().equals("BDLink") == false) goto L4;
        this.protocols = this.protocols.concat("BDLink,");
        this.remotePortBDLINK = r102.getValue().serverInfo.serverPort;
        goto L4
    }

    public ServerInfo(String r100, String r101, int r102) {
        this.remotePortMirror = -1;
        this.remotePortBDLINK = -1;
        this.protocols = "";
        this.portInfo = "";
        this.forceResetMirrorPlayer = 0;
        this.netDelay = -1;
        this.rtmpUrl = "";
        this.flvUrl = "";
        this.httpUrl = "";
        this.httpPlayUrl = "";
        this.deviceName = r100;
        this.aliasName = r101;
        this.serverPort = r102;
    }
}
