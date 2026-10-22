package com.byted.cast.common.source;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.byted.cast.common.Constants;
import com.byted.cast.common.bean.DeviceInfo;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public class ServiceInfo implements Parcelable {
    public static final Parcelable.Creator<ServiceInfo> CREATOR = null;
    public int audioSource;
    public boolean bdlinkEnabled;
    public int bitrate;
    public Map browseLeLinkExtras;
    public boolean bytelinkEnabled;
    public String castId;
    public String connectID;
    public String data;
    private int detectFailCount;
    public String deviceID;
    public Map<String, String> deviceParams;
    public String dialServerUrl;
    public int features;
    public int firewall;
    public int fps;
    public int height;

    /* JADX INFO: renamed from: ip, reason: collision with root package name */
    public String f33719ip;
    private boolean isSupportDetect;
    private boolean isSupportPing;
    public boolean isSupportPlayList;
    public int landscape;
    private final ServiceInfoOrigin mOriginFrom;
    private String mPrivateChannel;
    public String manufacture;
    public int micScale;
    public String name;
    public int port;
    public int portInvite;
    public int portMirror;
    public String protocols;
    public String rtc_appId;
    public String rtc_roomId;
    public String rtc_token;
    public String rtc_userId;
    public int serverMode;
    public String serviceIdentifierUDN;
    public int sinkPC;
    public Object smartViewService;
    public int transTypes;
    public String types;
    public int width;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public ServiceInfo deepCopy() {
        ServiceInfo r100 = new ServiceInfo();
        Map<String, String> r101 = this.deviceParams;
        if (r101 == null) goto L5;
        r100.deviceParams.putAll(r101);
    L5:
        r100.browseLeLinkExtras = this.browseLeLinkExtras;
        r100.connectID = this.connectID;
        r100.name = this.name;
        r100.f33719ip = this.f33719ip;
        r100.serviceIdentifierUDN = this.serviceIdentifierUDN;
        r100.manufacture = this.manufacture;
        r100.port = this.port;
        r100.data = this.data;
        r100.bdlinkEnabled = this.bdlinkEnabled;
        r100.portMirror = this.portMirror;
        r100.portInvite = this.portInvite;
        r100.width = this.width;
        r100.height = this.height;
        r100.fps = this.fps;
        r100.features = this.features;
        r100.deviceID = this.deviceID;
        r100.bytelinkEnabled = this.bytelinkEnabled;
        r100.types = this.types;
        r100.protocols = this.protocols;
        r100.isSupportPlayList = this.isSupportPlayList;
        r100.castId = this.castId;
        r100.isSupportPing = this.isSupportPing;
        r100.isSupportDetect = this.isSupportDetect;
        r100.dialServerUrl = this.dialServerUrl;
        r100.smartViewService = this.smartViewService;
        r100.bitrate = this.bitrate;
        r100.micScale = this.micScale;
        r100.audioSource = this.audioSource;
        r100.serverMode = this.serverMode;
        r100.landscape = this.landscape;
        r100.sinkPC = this.sinkPC;
        r100.transTypes = this.transTypes;
        return r100;
    }

    public String toString() {
        return "ServiceInfo{name='" + this.name + "',serviceIdentifierUDN=" + this.serviceIdentifierUDN + "', ip='" + this.f33719ip + "', port=" + this.port + ", bdlinkEnabled=" + this.bdlinkEnabled + ", deviceParams=" + this.deviceParams + ", portMirror=" + this.portMirror + ", portInvite=" + this.portInvite + ", bytelinkEnabled=" + this.bytelinkEnabled + ", types='" + this.types + "', protocols='" + this.protocols + "', data='" + this.data + "', connectID='" + this.connectID + "', width=" + this.width + ", height=" + this.height + ", fps=" + this.fps + ", deviceID=" + this.deviceID + ", features=" + this.features + ", firewall=" + this.firewall + ", manufacture=" + this.manufacture + ", dialServerUrl=" + this.dialServerUrl + ", isSupportPlayList=" + this.isSupportPlayList + ", castId=" + this.castId + ", rtc_appId=" + this.rtc_appId + ", rtc_token=" + this.rtc_token + ", rtc_roomId=" + this.rtc_roomId + ", rtc_userId=" + this.rtc_userId + ", isSupportDetect='" + this.isSupportDetect + "', detectFailCount='" + this.detectFailCount + "', originFrom='" + this.mOriginFrom + "', smartViewService='" + this.smartViewService + "', bitrate='" + this.bitrate + "', micScale='" + this.micScale + "', audioSource='" + this.audioSource + "', serverMode='" + this.serverMode + "', landscape='" + this.landscape + "', sinkPC='" + this.sinkPC + "', transTypes='" + this.transTypes + "'}";
    }

    public ServiceInfo() {
        this.deviceParams = new HashMap();
        this.connectID = "";
        this.data = "";
        this.bdlinkEnabled = true;
        this.portMirror = 0;
        this.portInvite = 0;
        this.bytelinkEnabled = true;
        this.firewall = 0;
        this.protocols = "";
        this.isSupportPlayList = false;
        this.transTypes = 1;
        this.mOriginFrom = new ServiceInfoOrigin();
    }

    public int getDetectFailCount() {
        return this.detectFailCount;
    }

    public ServiceInfoOrigin getOriginFrom() {
        return this.mOriginFrom;
    }

    public String getPrivateChannel() {
        return this.mPrivateChannel;
    }

    public boolean isSupportDetect() {
        return this.isSupportDetect;
    }

    public boolean isSupportPing() {
        return this.isSupportPing;
    }

    public ServiceInfo(Parcel r100) {
        this.deviceParams = new HashMap();
        this.connectID = "";
        this.data = "";
        boolean r101 = true;
        this.bdlinkEnabled = true;
        this.portMirror = 0;
        this.portInvite = 0;
        this.bytelinkEnabled = true;
        this.firewall = 0;
        this.protocols = "";
        this.isSupportPlayList = false;
        this.transTypes = 1;
        this.mOriginFrom = new ServiceInfoOrigin();
        this.connectID = r100.readString();
        this.serviceIdentifierUDN = r100.readString();
        this.name = r100.readString();
        this.f33719ip = r100.readString();
        this.manufacture = r100.readString();
        this.port = r100.readInt();
        this.data = r100.readString();
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.bdlinkEnabled = r102;
        this.portMirror = r100.readInt();
        this.width = r100.readInt();
        this.height = r100.readInt();
        this.fps = r100.readInt();
        this.features = r100.readInt();
        this.deviceID = r100.readString();
        if (r100.readByte() == 0) goto L9;
        boolean r103 = true;
    L10:
        this.bytelinkEnabled = r103;
        this.firewall = r100.readInt();
        this.types = r100.readString();
        this.protocols = r100.readString();
        this.rtc_appId = r100.readString();
        this.rtc_token = r100.readString();
        this.rtc_roomId = r100.readString();
        this.rtc_userId = r100.readString();
        if (r100.readByte() == 0) goto L13;
        boolean r104 = true;
    L14:
        this.isSupportPlayList = r104;
        this.castId = r100.readString();
        if (r100.readByte() == 0) goto L17;
        boolean r105 = true;
    L18:
        this.isSupportDetect = r105;
        if (r100.readByte() != 0) goto L22;
        r101 = false;
    L22:
        this.isSupportPing = r101;
        this.detectFailCount = r100.readInt();
        this.mPrivateChannel = r100.readString();
        this.portInvite = r100.readInt();
        this.bitrate = r100.readInt();
        this.micScale = r100.readInt();
        this.audioSource = r100.readInt();
        this.serverMode = r100.readInt();
        this.landscape = r100.readInt();
        this.sinkPC = r100.readInt();
        return;
    L17:
        r105 = false;
        goto L18
    L13:
        r104 = false;
        goto L14
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    public void append(ServiceInfo r100) {
        this.name = r100.name;
        this.f33719ip = r100.f33719ip;
        this.connectID = r100.connectID;
        int r101 = r100.port;
        if (r101 == (-1)) goto L5;
        this.port = r101;
    L5:
        int r102 = r100.portMirror;
        if (r102 == (-1)) goto L8;
        this.portMirror = r102;
    L8:
        this.types = r100.types;
        this.protocols = r100.protocols;
        this.data = r100.data;
        if (TextUtils.equals(r100.types, "ByteLink") == false) goto L12;
        this.width = r100.width;
        this.height = r100.height;
        this.fps = r100.fps;
        this.firewall = r100.firewall;
        this.features = r100.features;
        this.deviceID = r100.deviceID;
        this.portInvite = r100.portInvite;
        this.bitrate = r100.bitrate;
        this.micScale = r100.micScale;
        this.audioSource = r100.audioSource;
        this.serverMode = r100.serverMode;
        this.landscape = r100.landscape;
        this.sinkPC = r100.sinkPC;
        this.transTypes = r100.transTypes;
    L12:
        if (TextUtils.equals(r100.types, "ChromeCast") == false) goto L15;
        this.connectID = r100.connectID;
    L15:
        if (TextUtils.equals(r100.types, "BDDLNA") == false) goto L17;
        this.manufacture = r100.manufacture;
    L17:
        this.isSupportPlayList = r100.isSupportPlayList;
        this.castId = r100.castId;
        this.smartViewService = r100.smartViewService;
    }

    public void appendBdlinkDeviceInfo(DeviceInfo r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        setSupportDetect(true);
        setSupportPing(r100.supportPing());
        if (TextUtils.isEmpty(this.protocols) == false) goto L8;
        this.protocols = "BDLink,";
    L10:
        this.data = r100.data;
        if (TextUtils.isEmpty(r100.version) == true) goto L13;
        this.deviceParams.put(Constants.SINK_BDLINK_VERSION_KEY, r100.version);
    L13:
        this.deviceParams.put(Constants.SOURCE_BDLINK_HAS_DEVICE_INFO, String.valueOf(true));
        return;
    L8:
        if (this.protocols.contains("BDLink") == true) goto L10;
        this.protocols = "BDLink," + this.protocols;
        goto L10
    }

    public void appendDlnaDeviceInfo(DeviceInfo r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(this.protocols) == false) goto L8;
        this.protocols = "BDDLNA,";
    L11:
        if (TextUtils.isEmpty(r100.data) == true) goto L14;
        this.data = r100.data;
        return;
    L14:
        return;
    L8:
        if (this.protocols.contains("BDDLNA") == true) goto L11;
        this.protocols = "BDDLNA," + this.protocols;
        goto L11
    }

    public void setDetectFailCount(int r100) {
        this.detectFailCount = r100;
    }

    public void setPrivateChannel(String r100) {
        this.mPrivateChannel = r100;
    }

    public void setSupportDetect(boolean r100) {
        this.isSupportDetect = r100;
    }

    public void setSupportPing(boolean r100) {
        this.isSupportPing = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.connectID);
        r100.writeString(this.serviceIdentifierUDN);
        r100.writeString(this.name);
        r100.writeString(this.f33719ip);
        r100.writeString(this.manufacture);
        r100.writeInt(this.port);
        r100.writeString(this.data);
        r100.writeByte(this.bdlinkEnabled ? 1 : 0);
        r100.writeInt(this.portMirror);
        r100.writeInt(this.width);
        r100.writeInt(this.height);
        r100.writeInt(this.fps);
        r100.writeInt(this.features);
        r100.writeString(this.deviceID);
        r100.writeByte(this.bytelinkEnabled ? 1 : 0);
        r100.writeInt(this.firewall);
        r100.writeString(this.types);
        r100.writeString(this.protocols);
        r100.writeString(this.rtc_appId);
        r100.writeString(this.rtc_token);
        r100.writeString(this.rtc_roomId);
        r100.writeString(this.rtc_userId);
        r100.writeByte(this.isSupportPlayList ? 1 : 0);
        r100.writeString(this.castId);
        r100.writeByte(this.isSupportDetect ? 1 : 0);
        r100.writeByte(this.isSupportPing ? 1 : 0);
        r100.writeInt(this.detectFailCount);
        r100.writeString(this.mPrivateChannel);
        r100.writeInt(this.portInvite);
        r100.writeInt(this.bitrate);
        r100.writeInt(this.micScale);
        r100.writeInt(this.audioSource);
        r100.writeInt(this.serverMode);
        r100.writeInt(this.landscape);
        r100.writeInt(this.sinkPC);
    }

    public ServiceInfo(String r100, String r101, int r102, int r103, String r104, String r105) {
        this.deviceParams = new HashMap();
        this.connectID = "";
        this.data = "";
        this.bdlinkEnabled = true;
        this.portMirror = 0;
        this.portInvite = 0;
        this.bytelinkEnabled = true;
        this.firewall = 0;
        this.protocols = "";
        this.isSupportPlayList = false;
        this.transTypes = 1;
        this.mOriginFrom = new ServiceInfoOrigin();
        this.name = r100;
        this.f33719ip = r101;
        this.port = r102;
        this.portMirror = r103;
        this.types = r104;
        this.protocols = r105;
    }

    public ServiceInfo(String r110, String r111, int r112, String r113, int r114, int r115, int r116, int r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, 0);
    }

    public ServiceInfo(String r100, String r101, int r102, String r103, int r104, int r105, int r110, int r111, int r112) {
        this.deviceParams = new HashMap();
        this.connectID = "";
        this.data = "";
        this.bdlinkEnabled = true;
        this.portMirror = 0;
        this.portInvite = 0;
        this.bytelinkEnabled = true;
        this.firewall = 0;
        this.protocols = "";
        this.isSupportPlayList = false;
        this.transTypes = 1;
        this.mOriginFrom = new ServiceInfoOrigin();
        this.name = r100;
        this.f33719ip = r101;
        this.port = r102;
        this.data = r103;
        this.portMirror = r104;
        this.width = r105;
        this.height = r110;
        this.fps = r111;
        this.firewall = r112;
    }

    public ServiceInfo(String r100, String r101, int r102, String r103, int r104, int r105, int r110, int r111, int r112, int r113) {
        this.deviceParams = new HashMap();
        this.connectID = "";
        this.data = "";
        this.bdlinkEnabled = true;
        this.portMirror = 0;
        this.portInvite = 0;
        this.bytelinkEnabled = true;
        this.firewall = 0;
        this.protocols = "";
        this.isSupportPlayList = false;
        this.transTypes = 1;
        this.mOriginFrom = new ServiceInfoOrigin();
        this.name = r100;
        this.f33719ip = r101;
        this.port = r102;
        this.data = r103;
        this.portMirror = r104;
        this.portInvite = r105;
        this.width = r110;
        this.height = r111;
        this.fps = r112;
        this.firewall = r113;
    }

    public ServiceInfo(String r100, String r101, int r102, String r103, int r104, int r105, int r110, int r111, int r112, String r113) {
        this.deviceParams = new HashMap();
        this.connectID = "";
        this.data = "";
        this.bdlinkEnabled = true;
        this.portMirror = 0;
        this.portInvite = 0;
        this.bytelinkEnabled = true;
        this.firewall = 0;
        this.protocols = "";
        this.isSupportPlayList = false;
        this.transTypes = 1;
        this.mOriginFrom = new ServiceInfoOrigin();
        this.name = r100;
        this.f33719ip = r101;
        this.port = r102;
        this.data = r103;
        this.portMirror = r104;
        this.width = r105;
        this.height = r110;
        this.fps = r111;
        this.deviceID = r113;
        this.firewall = r112;
    }
}
