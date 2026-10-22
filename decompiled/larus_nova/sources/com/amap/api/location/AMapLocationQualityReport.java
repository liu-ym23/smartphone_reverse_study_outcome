package com.amap.api.location;

import com.byted.cast.common.bean.State;
import n4a.c4;

/* JADX INFO: loaded from: classes28.dex */
public class AMapLocationQualityReport implements Cloneable {
    public static final int GPS_STATUS_MODE_SAVING = 3;
    public static final int GPS_STATUS_NOGPSPERMISSION = 4;
    public static final int GPS_STATUS_NOGPSPROVIDER = 1;
    public static final int GPS_STATUS_OFF = 2;
    public static final int GPS_STATUS_OK = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    AMapLocationClientOption.AMapLocationMode f26750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f26751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f26752c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f26753d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f26754e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f26755f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f26756g;

    public AMapLocationQualityReport() {
        this.f26751b = false;
        this.f26752c = 2;
        this.f26753d = 0;
        this.f26754e = "UNKNOWN";
        this.f26755f = 0;
        this.f26756g = false;
        this.f26750a = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;
    }

    public AMapLocationQualityReport clone() {
        AMapLocationQualityReport r100 = new AMapLocationQualityReport();
        super.clone();     // Catch: Throwable -> L9
    L12:
        r100.setGpsStatus(this.f26752c);     // Catch: Throwable -> L6
        r100.setGPSSatellites(this.f26753d);     // Catch: Throwable -> L6
        r100.setWifiAble(this.f26751b);     // Catch: Throwable -> L6
        r100.setNetUseTime(this.f26755f);     // Catch: Throwable -> L6
        r100.setNetworkType(this.f26754e);     // Catch: Throwable -> L6
        r100.setLocationMode(this.f26750a);     // Catch: Throwable -> L6
        r100.setInstallHighDangerMockApp(this.f26756g);     // Catch: Throwable -> L6
    L8:
        return r100;
    L6:
        th = move-exception;
        c4.g(th, "AMapLocationQualityReport", "clone");
        goto L8
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8020clone() throws CloneNotSupportedException {
        return clone();
    }

    public String getAdviseMessage() {
        StringBuffer r100 = new StringBuffer();
        AMapLocationClientOption.AMapLocationMode r101 = this.f26750a;
        if (r101 == AMapLocationClientOption.AMapLocationMode.Battery_Saving) goto L25;
        int r102 = this.f26752c;
        if (r102 == 0) goto L20;
        if (r102 != 1) goto L9;
        String r103 = "您的设备没有GPS模块或者GPS模块异常，无法进行GPS定位\n";
    L18:
        r100.append(r103);
        goto L25
    L9:
        if (r102 != 2) goto L11;
        r103 = "您的设备关闭了GPS定位功能，开启GPS定位功能有助于提高定位的精确度\n";
        goto L18
    L11:
        if (r102 == 3) goto L15;
        if (r102 != 4) goto L25;
        r103 = "您的设置禁用了GPS定位权限，开启GPS定位权限有助于提高定位的精确度\n";
        goto L18
    L15:
        r103 = "您的设备当前设置的定位模式不包含GPS定位，选择包含GPS模式的定位模式有助于提高定位的精确度\n";
        goto L18
    L20:
        if (r101 != AMapLocationClientOption.AMapLocationMode.Device_Sensors) goto L25;
        if (this.f26753d >= 4) goto L25;
        r103 = "当前GPS信号弱，位置更新可能会延迟\n";
    L25:
        if (this.f26750a == AMapLocationClientOption.AMapLocationMode.Device_Sensors) goto L37;
        if (State.DISCONNECTED.equals(this.f26754e) == false) goto L31;
        String r104 = "您的设备未连接到网络，无法进行网络定位\n";
    L29:
        r100.append(r104);
    L34:
        if (this.f26751b == true) goto L37;
        r100.append("您的设备WIFI开关已关闭，打开WIFI开关有助于提高定位的成功率\n");
        goto L37
    L31:
        if ("2G".equals(this.f26754e) == false) goto L34;
        r104 = "您的设备网络状态不太好，网络定位可能会有延迟\n";
    L37:
        return r100.toString();
    }

    public int getGPSSatellites() {
        return this.f26753d;
    }

    public int getGPSStatus() {
        return this.f26752c;
    }

    public long getNetUseTime() {
        return this.f26755f;
    }

    public String getNetworkType() {
        return this.f26754e;
    }

    public boolean isInstalledHighDangerMockApp() {
        return this.f26756g;
    }

    public boolean isWifiAble() {
        return this.f26751b;
    }

    public void setGPSSatellites(int r100) {
        this.f26753d = r100;
    }

    public void setGpsStatus(int r100) {
        this.f26752c = r100;
    }

    public void setInstallHighDangerMockApp(boolean r100) {
        this.f26756g = r100;
    }

    public void setLocationMode(AMapLocationClientOption.AMapLocationMode r100) {
        this.f26750a = r100;
    }

    public void setNetUseTime(long r100) {
        this.f26755f = r100;
    }

    public void setNetworkType(String r100) {
        this.f26754e = r100;
    }

    public void setWifiAble(boolean r100) {
        this.f26751b = r100;
    }
}
