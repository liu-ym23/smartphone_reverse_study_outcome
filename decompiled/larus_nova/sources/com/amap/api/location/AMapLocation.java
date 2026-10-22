package com.amap.api.location;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.amap.api.services.district.DistrictSearchQuery;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.ttvecamera.TECameraSettings;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import n4a.c4;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class AMapLocation extends Location implements Parcelable, Cloneable {
    public static final String COORD_TYPE_GCJ02 = "GCJ02";
    public static final String COORD_TYPE_WGS84 = "WGS84";
    public static final Parcelable.Creator<AMapLocation> CREATOR = null;
    public static final int ERROR_CODE_AIRPLANEMODE_WIFIOFF = 18;
    public static final int ERROR_CODE_FAILURE_AUTH = 7;
    public static final int ERROR_CODE_FAILURE_CELL = 11;
    public static final int ERROR_CODE_FAILURE_COARSE_LOCATION = 20;
    public static final int ERROR_CODE_FAILURE_CONNECTION = 4;
    public static final int ERROR_CODE_FAILURE_INIT = 9;
    public static final int ERROR_CODE_FAILURE_LOCATION = 6;
    public static final int ERROR_CODE_FAILURE_LOCATION_PARAMETER = 3;
    public static final int ERROR_CODE_FAILURE_LOCATION_PERMISSION = 12;
    public static final int ERROR_CODE_FAILURE_NOENOUGHSATELLITES = 14;
    public static final int ERROR_CODE_FAILURE_NOWIFIANDAP = 13;
    public static final int ERROR_CODE_FAILURE_PARSER = 5;
    public static final int ERROR_CODE_FAILURE_SIMULATION_LOCATION = 15;
    public static final int ERROR_CODE_FAILURE_WIFI_INFO = 2;
    public static final int ERROR_CODE_INVALID_PARAMETER = 1;
    public static final int ERROR_CODE_NOCGI_WIFIOFF = 19;
    public static final int ERROR_CODE_NO_COMPENSATION_CACHE = 33;
    public static final int ERROR_CODE_SERVICE_FAIL = 10;
    public static final int ERROR_CODE_UNKNOWN = 8;
    public static final int GPS_ACCURACY_BAD = 0;
    public static final int GPS_ACCURACY_GOOD = 1;
    public static final int GPS_ACCURACY_UNKNOWN = -1;
    public static final String LBS_REAL_LOCATION_TYPE = "realLocationType";
    public static final int LOCATION_COMPENSATION = 10;
    public static final int LOCATION_SUCCESS = 0;
    public static final int LOCATION_TYPE_AMAP = 7;
    public static final int LOCATION_TYPE_CELL = 6;
    public static final int LOCATION_TYPE_COARSE_LOCATION = 11;
    public static final int LOCATION_TYPE_FAST = 3;
    public static final int LOCATION_TYPE_FIX_CACHE = 4;
    public static final int LOCATION_TYPE_GPS = 1;
    public static final int LOCATION_TYPE_LAST_LOCATION_CACHE = 9;
    public static final int LOCATION_TYPE_NETWORK = 12;
    public static final int LOCATION_TYPE_OFFLINE = 8;
    public static final int LOCATION_TYPE_SAME_REQ = 2;
    public static final int LOCATION_TYPE_WIFI = 5;
    public static final int TRUSTED_LEVEL_BAD = 4;
    public static final int TRUSTED_LEVEL_HIGH = 1;
    public static final int TRUSTED_LEVEL_LOW = 3;
    public static final int TRUSTED_LEVEL_NORMAL = 2;
    private int A;
    private String B;
    private int C;
    private boolean D;
    private String E;
    private boolean F;
    private String G;
    private int H;
    private int I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f26690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected String f26691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    AMapLocationQualityReport f26692c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f26693d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f26694e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f26695f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f26696g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f26697h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f26698i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f26699j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f26700k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f26701l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f26702m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f26703n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f26704o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f26705p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f26706q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f26707r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f26708s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private double f26709t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private double f26710u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private double f26711v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f26712w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f26713x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Bundle f26714y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private String f26715z;

    static {
        CREATOR = new AnonymousClass1();
    }

    public AMapLocation(Location r100) {
        super(r100);
        this.f26693d = "";
        this.f26694e = "";
        this.f26695f = "";
        this.f26696g = "";
        this.f26697h = "";
        this.f26698i = "";
        this.f26699j = "";
        this.f26700k = "";
        this.f26701l = "";
        this.f26702m = "";
        this.f26703n = "";
        this.f26704o = true;
        this.f26705p = 0;
        this.f26706q = "success";
        this.f26707r = "";
        this.f26708s = 0;
        this.f26709t = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f26710u = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f26711v = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f26712w = 0.0f;
        this.f26713x = 0.0f;
        Bundle r101 = null;
        this.f26714y = null;
        this.A = 0;
        this.B = "";
        this.C = -1;
        this.D = false;
        this.E = "";
        this.F = false;
        this.f26690a = "";
        this.f26691b = "";
        this.f26692c = new AMapLocationQualityReport();
        this.G = COORD_TYPE_GCJ02;
        this.H = 1;
        this.f26709t = r100.getLatitude();
        this.f26710u = r100.getLongitude();
        this.f26711v = r100.getAltitude();
        this.f26713x = r100.getBearing();
        this.f26712w = r100.getSpeed();
        this.f26715z = r100.getProvider();
        if (r100.getExtras() == null) goto L6;
        r101 = new Bundle(r100.getExtras());
    L6:
        this.f26714y = r101;
    }

    public AMapLocation(String r100) {
        super(r100);
        this.f26693d = "";
        this.f26694e = "";
        this.f26695f = "";
        this.f26696g = "";
        this.f26697h = "";
        this.f26698i = "";
        this.f26699j = "";
        this.f26700k = "";
        this.f26701l = "";
        this.f26702m = "";
        this.f26703n = "";
        this.f26704o = true;
        this.f26705p = 0;
        this.f26706q = "success";
        this.f26707r = "";
        this.f26708s = 0;
        this.f26709t = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f26710u = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f26711v = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f26712w = 0.0f;
        this.f26713x = 0.0f;
        this.f26714y = null;
        this.A = 0;
        this.B = "";
        this.C = -1;
        this.D = false;
        this.E = "";
        this.F = false;
        this.f26690a = "";
        this.f26691b = "";
        this.f26692c = new AMapLocationQualityReport();
        this.G = COORD_TYPE_GCJ02;
        this.H = 1;
        this.f26715z = r100;
    }

    public static /* synthetic */ double a(AMapLocation r100, double r101) {
        r100.f26709t = r101;
        return r101;
    }

    public static /* synthetic */ int a(AMapLocation r100, int r101) {
        r100.f26705p = r101;
        return r101;
    }

    public static /* synthetic */ String a(AMapLocation r100, String r101) {
        r100.f26697h = r101;
        return r101;
    }

    public static /* synthetic */ boolean a(AMapLocation r100, boolean r101) {
        r100.F = r101;
        return r101;
    }

    public static /* synthetic */ double b(AMapLocation r100, double r101) {
        r100.f26710u = r101;
        return r101;
    }

    public static /* synthetic */ int b(AMapLocation r100, int r101) {
        r100.f26708s = r101;
        return r101;
    }

    public static /* synthetic */ String b(AMapLocation r100, String r101) {
        r100.f26698i = r101;
        return r101;
    }

    public static /* synthetic */ boolean b(AMapLocation r100, boolean r101) {
        r100.f26704o = r101;
        return r101;
    }

    public static /* synthetic */ int c(AMapLocation r100, int r101) {
        r100.A = r101;
        return r101;
    }

    public static /* synthetic */ String c(AMapLocation r100, String r101) {
        r100.B = r101;
        return r101;
    }

    public static /* synthetic */ boolean c(AMapLocation r100, boolean r101) {
        r100.D = r101;
        return r101;
    }

    public static /* synthetic */ int d(AMapLocation r100, int r101) {
        r100.C = r101;
        return r101;
    }

    public static /* synthetic */ String d(AMapLocation r100, String r101) {
        r100.f26694e = r101;
        return r101;
    }

    public static /* synthetic */ int e(AMapLocation r100, int r101) {
        r100.H = r101;
        return r101;
    }

    public static /* synthetic */ String e(AMapLocation r100, String r101) {
        r100.f26696g = r101;
        return r101;
    }

    public static /* synthetic */ int f(AMapLocation r100, int r101) {
        r100.I = r101;
        return r101;
    }

    public static /* synthetic */ String f(AMapLocation r100, String r101) {
        r100.f26700k = r101;
        return r101;
    }

    public static /* synthetic */ String g(AMapLocation r100, String r101) {
        r100.f26695f = r101;
        return r101;
    }

    public static /* synthetic */ String h(AMapLocation r100, String r101) {
        r100.f26706q = r101;
        return r101;
    }

    public static /* synthetic */ String i(AMapLocation r100, String r101) {
        r100.f26707r = r101;
        return r101;
    }

    public static /* synthetic */ String j(AMapLocation r100, String r101) {
        r100.f26703n = r101;
        return r101;
    }

    public static /* synthetic */ String k(AMapLocation r100, String r101) {
        r100.f26699j = r101;
        return r101;
    }

    public static /* synthetic */ String l(AMapLocation r100, String r101) {
        r100.f26693d = r101;
        return r101;
    }

    public static /* synthetic */ String m(AMapLocation r100, String r101) {
        r100.f26701l = r101;
        return r101;
    }

    public static /* synthetic */ String n(AMapLocation r100, String r101) {
        r100.f26702m = r101;
        return r101;
    }

    public static /* synthetic */ String o(AMapLocation r100, String r101) {
        r100.E = r101;
        return r101;
    }

    public static /* synthetic */ String p(AMapLocation r100, String r101) {
        r100.G = r101;
        return r101;
    }

    public AMapLocation clone() {
        super.clone();     // Catch: Throwable -> L12
    L3:
        AMapLocation r100 = new AMapLocation(this);
        r100.setLatitude(this.f26709t);     // Catch: Throwable -> L9
        r100.setLongitude(this.f26710u);     // Catch: Throwable -> L9
        r100.setAdCode(this.f26697h);     // Catch: Throwable -> L9
        r100.setAddress(this.f26698i);     // Catch: Throwable -> L9
        r100.setAoiName(this.B);     // Catch: Throwable -> L9
        r100.setBuildingId(this.f26690a);     // Catch: Throwable -> L9
        r100.setCity(this.f26694e);     // Catch: Throwable -> L9
        r100.setCityCode(this.f26696g);     // Catch: Throwable -> L9
        r100.setCountry(this.f26700k);     // Catch: Throwable -> L9
        r100.setDistrict(this.f26695f);     // Catch: Throwable -> L9
        r100.setErrorCode(this.f26705p);     // Catch: Throwable -> L9
        r100.setErrorInfo(this.f26706q);     // Catch: Throwable -> L9
        r100.setFloor(this.f26691b);     // Catch: Throwable -> L9
        r100.setFixLastLocation(this.F);     // Catch: Throwable -> L9
        r100.setOffset(this.f26704o);     // Catch: Throwable -> L9
        r100.setLocationDetail(this.f26707r);     // Catch: Throwable -> L9
        r100.setLocationType(this.f26708s);     // Catch: Throwable -> L9
        r100.setMock(this.D);     // Catch: Throwable -> L9
        r100.setNumber(this.f26703n);     // Catch: Throwable -> L9
        r100.setPoiName(this.f26699j);     // Catch: Throwable -> L9
        r100.setProvince(this.f26693d);     // Catch: Throwable -> L9
        r100.setRoad(this.f26701l);     // Catch: Throwable -> L9
        r100.setSatellites(this.A);     // Catch: Throwable -> L9
        r100.setGpsAccuracyStatus(this.C);     // Catch: Throwable -> L9
        r100.setStreet(this.f26702m);     // Catch: Throwable -> L9
        r100.setDescription(this.E);     // Catch: Throwable -> L9
        r100.setExtras(getExtras());     // Catch: Throwable -> L9
        AMapLocationQualityReport r101 = this.f26692c;     // Catch: Throwable -> L9
        if (r101 == null) goto L7;
        r100.setLocationQualityReport(r101.clone());     // Catch: Throwable -> L9
    L7:
        r100.setCoordType(this.G);     // Catch: Throwable -> L9
        r100.setTrustedLevel(this.H);     // Catch: Throwable -> L9
        r100.setConScenario(this.I);     // Catch: Throwable -> L9
    L11:
        return r100;
    L9:
        th = move-exception;
        c4.g(th, "AMapLocation", "clone");
        goto L11
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8018clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // android.location.Location, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.location.Location
    public float getAccuracy() {
        return super.getAccuracy();
    }

    public String getAdCode() {
        return this.f26697h;
    }

    public String getAddress() {
        return this.f26698i;
    }

    @Override // android.location.Location
    public double getAltitude() {
        return this.f26711v;
    }

    public String getAoiName() {
        return this.B;
    }

    @Override // android.location.Location
    public float getBearing() {
        return this.f26713x;
    }

    public String getBuildingId() {
        return this.f26690a;
    }

    public String getCity() {
        return this.f26694e;
    }

    public String getCityCode() {
        return this.f26696g;
    }

    public int getConScenario() {
        return this.I;
    }

    public String getCoordType() {
        return this.G;
    }

    public String getCountry() {
        return this.f26700k;
    }

    public String getDescription() {
        return this.E;
    }

    public String getDistrict() {
        return this.f26695f;
    }

    public int getErrorCode() {
        return this.f26705p;
    }

    public String getErrorInfo() {
        StringBuilder r100 = new StringBuilder();
        r100.append(this.f26706q);
        if (this.f26705p == 0) goto L6;
        r100.append(" 请到http://lbs.amap.com/api/android-location-sdk/guide/utilities/errorcode/查看错误码说明");
        r100.append(",错误详细信息:" + this.f26707r);
    L6:
        return r100.toString();
    }

    @Override // android.location.Location
    public Bundle getExtras() {
        return this.f26714y;
    }

    public String getFloor() {
        return this.f26691b;
    }

    public int getGpsAccuracyStatus() {
        return this.C;
    }

    @Override // android.location.Location
    public double getLatitude() {
        return this.f26709t;
    }

    public String getLocationDetail() {
        return this.f26707r;
    }

    public AMapLocationQualityReport getLocationQualityReport() {
        return this.f26692c;
    }

    public int getLocationType() {
        return this.f26708s;
    }

    @Override // android.location.Location
    public double getLongitude() {
        return this.f26710u;
    }

    public String getPoiName() {
        return this.f26699j;
    }

    @Override // android.location.Location
    public String getProvider() {
        return this.f26715z;
    }

    public String getProvince() {
        return this.f26693d;
    }

    public String getRoad() {
        return this.f26701l;
    }

    public int getSatellites() {
        return this.A;
    }

    @Override // android.location.Location
    public float getSpeed() {
        return this.f26712w;
    }

    public String getStreet() {
        return this.f26702m;
    }

    public String getStreetNum() {
        return this.f26703n;
    }

    public int getTrustedLevel() {
        return this.H;
    }

    public boolean isFixLastLocation() {
        return this.F;
    }

    @Override // android.location.Location
    public boolean isMock() {
        return this.D;
    }

    public boolean isOffset() {
        return this.f26704o;
    }

    public void setAdCode(String r100) {
        this.f26697h = r100;
    }

    public void setAddress(String r100) {
        this.f26698i = r100;
    }

    @Override // android.location.Location
    public void setAltitude(double r100) {
        super.setAltitude(r100);
        this.f26711v = r100;
    }

    public void setAoiName(String r100) {
        this.B = r100;
    }

    @Override // android.location.Location
    public void setBearing(float r100) {
        super.setBearing(r100);
    L4:
        if (r100 >= 0.0f) goto L7;
        r100 = r100 + 360.0f;
    L7:
        if (r100 < 360.0f) goto L9;
        r100 = r100 - 360.0f;
        goto L7
    L9:
        this.f26713x = r100;
    }

    public void setBuildingId(String r100) {
        this.f26690a = r100;
    }

    public void setCity(String r100) {
        this.f26694e = r100;
    }

    public void setCityCode(String r100) {
        this.f26696g = r100;
    }

    public void setConScenario(int r100) {
        this.I = r100;
    }

    public void setCoordType(String r100) {
        this.G = r100;
    }

    public void setCountry(String r100) {
        this.f26700k = r100;
    }

    public void setDescription(String r100) {
        this.E = r100;
    }

    public void setDistrict(String r100) {
        this.f26695f = r100;
    }

    public void setErrorCode(int r100) {
        if (this.f26705p == 0) goto L6;
        return;
    L6:
        if (r100 == 33) goto L29;
        switch(r100) {
            case 0: goto L24;
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L18;
            case 7: goto L17;
            case 8: goto L28;
            case 9: goto L16;
            case 10: goto L15;
            case 11: goto L14;
            case 12: goto L13;
            case 13: goto L12;
            case 14: goto L11;
            case 15: goto L10;
            default: goto L8;
        };
    L8:
        switch(r100) {
            case 18: goto L27;
            case 19: goto L26;
            case 20: goto L25;
            default: goto L28;
        };
    L25:
        String r101 = "模糊定位失败，具体可查看错误信息/详细信息描述";
    L30:
        this.f26706q = r101;
        this.f26705p = r100;
        return;
    L26:
        r101 = "定位失败，没有检查到SIM卡，并且关闭了WIFI开关，请打开WIFI开关或者插入SIM卡";
        goto L30
    L27:
        r101 = "定位失败，飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关";
        goto L30
    L10:
        r101 = "当前返回位置为模拟软件返回，请关闭模拟软件，或者在option中设置允许模拟";
        goto L30
    L11:
        r101 = "GPS 定位失败，由于设备当前 GPS 状态差,建议持设备到相对开阔的露天场所再次尝试";
        goto L30
    L12:
        r101 = "网络定位失败，请检查设备是否插入sim卡，是否开启移动网络或开启了wifi模块";
        goto L30
    L13:
        r101 = "缺少定位权限";
        goto L30
    L14:
        r101 = "错误的基站信息，请检查是否插入SIM卡";
        goto L30
    L15:
        r101 = "定位服务启动失败";
        goto L30
    L16:
        r101 = "初始化异常";
        goto L30
    L17:
        r101 = "KEY错误";
        goto L30
    L18:
        r101 = "定位结果错误";
        goto L30
    L19:
        r101 = "解析数据异常";
        goto L30
    L20:
        r101 = "网络连接异常";
        goto L30
    L21:
        r101 = "请求参数获取出现异常";
        goto L30
    L22:
        r101 = "WIFI信息不足";
        goto L30
    L23:
        r101 = "重要参数为空";
        goto L30
    L24:
        r101 = "success";
    L28:
        r101 = "其他错误";
        goto L30
    L29:
        r101 = "补偿定位失败，未命中缓存";
        goto L30
    }

    public void setErrorInfo(String r100) {
        this.f26706q = r100;
    }

    @Override // android.location.Location
    public void setExtras(Bundle r100) {
        super.setExtras(r100);
        if (r100 != null) goto L5;
        Bundle r101 = null;
    L6:
        this.f26714y = r101;
        return;
    L5:
        r101 = new Bundle(r100);
        goto L6
    }

    public void setFixLastLocation(boolean r100) {
        this.F = r100;
    }

    public void setFloor(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L9;
        r100 = r100.replace(FaceService.girlLabel, "");
        CastIntegerProtector.parseInt(r100);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        c4.g(th, "AmapLoc", "setFloor");
        r100 = null;
    L9:
        this.f26691b = r100;
    }

    public void setGpsAccuracyStatus(int r100) {
        this.C = r100;
    }

    @Override // android.location.Location
    public void setLatitude(double r100) {
        this.f26709t = r100;
    }

    public void setLocationDetail(String r100) {
        this.f26707r = r100;
    }

    public void setLocationQualityReport(AMapLocationQualityReport r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f26692c = r100;
    }

    public void setLocationType(int r100) {
        this.f26708s = r100;
    }

    @Override // android.location.Location
    public void setLongitude(double r100) {
        this.f26710u = r100;
    }

    @Override // android.location.Location
    public void setMock(boolean r100) {
        this.D = r100;
    }

    public void setNumber(String r100) {
        this.f26703n = r100;
    }

    public void setOffset(boolean r100) {
        this.f26704o = r100;
    }

    public void setPoiName(String r100) {
        this.f26699j = r100;
    }

    @Override // android.location.Location
    public void setProvider(String r100) {
        super.setProvider(r100);
        this.f26715z = r100;
    }

    public void setProvince(String r100) {
        this.f26693d = r100;
    }

    public void setRoad(String r100) {
        this.f26701l = r100;
    }

    public void setSatellites(int r100) {
        this.A = r100;
    }

    @Override // android.location.Location
    public void setSpeed(float r100) {
        super.setSpeed(r100);
        this.f26712w = r100;
    }

    public void setStreet(String r100) {
        this.f26702m = r100;
    }

    public void setTrustedLevel(int r100) {
        this.H = r100;
    }

    public JSONObject toJson(int r100) {
        JSONObject r101 = new JSONObject();     // Catch: Throwable -> L15
        if (r100 != 1) goto L6;
        r101.put("altitude", getAltitude());     // Catch: Throwable -> L18
        r101.put("speed", getSpeed());     // Catch: Throwable -> L18
        r101.put("bearing", getBearing());     // Catch: Throwable -> L18
    L11:
        r101.put("citycode", this.f26696g);     // Catch: Throwable -> L15
        r101.put("adcode", this.f26697h);     // Catch: Throwable -> L15
        r101.put(DistrictSearchQuery.KEYWORDS_COUNTRY, this.f26700k);     // Catch: Throwable -> L15
        r101.put("province", this.f26693d);     // Catch: Throwable -> L15
        r101.put("city", this.f26694e);     // Catch: Throwable -> L15
        r101.put(DistrictSearchQuery.KEYWORDS_DISTRICT, this.f26695f);     // Catch: Throwable -> L15
        r101.put("road", this.f26701l);     // Catch: Throwable -> L15
        r101.put("street", this.f26702m);     // Catch: Throwable -> L15
        r101.put("number", this.f26703n);     // Catch: Throwable -> L15
        r101.put(MapBundleKey.MapObjKey.OBJ_SS_POINAME, this.f26699j);     // Catch: Throwable -> L15
        r101.put("errorCode", this.f26705p);     // Catch: Throwable -> L15
        r101.put("errorInfo", this.f26706q);     // Catch: Throwable -> L15
        r101.put("locationType", this.f26708s);     // Catch: Throwable -> L15
        r101.put("locationDetail", this.f26707r);     // Catch: Throwable -> L15
        r101.put("aoiname", this.B);     // Catch: Throwable -> L15
        r101.put("address", this.f26698i);     // Catch: Throwable -> L15
        r101.put("poiid", this.f26690a);     // Catch: Throwable -> L15
        r101.put("floor", this.f26691b);     // Catch: Throwable -> L15
        r101.put("description", this.E);     // Catch: Throwable -> L15
    L12:
        r101.put("time", getTime());     // Catch: Throwable -> L15
    L13:
        r101.put(ShortVideoSegments.KEY_PROP_PROVIDER, getProvider());     // Catch: Throwable -> L15
        r101.put("lon", getLongitude());     // Catch: Throwable -> L15
        r101.put("lat", getLatitude());     // Catch: Throwable -> L15
        r101.put(LocationMonitorConst.ACCURACY, getAccuracy());     // Catch: Throwable -> L15
        r101.put("isOffset", this.f26704o);     // Catch: Throwable -> L15
        r101.put("isFixLastLocation", this.F);     // Catch: Throwable -> L15
        r101.put("coordType", this.G);     // Catch: Throwable -> L15
        return r101;
    L6:
        if (r100 == 2) goto L12;
        if (r100 == 3) goto L13;
        return r101;
    L15:
        th = move-exception;
        c4.g(th, "AmapLoc", "toStr");
        return null;
    }

    public String toStr() {
        return toStr(1);
    }

    public String toStr(int r100) {
        JSONObject r101 = toJson(r100);     // Catch: Throwable -> L5
    L7:
        if (r101 != null) goto L10;
        return null;
    L10:
        return r101.toString();
    L5:
        th = move-exception;
        c4.g(th, "AMapLocation", "toStr part2");
        r101 = null;
        goto L7
    }

    @Override // android.location.Location
    public String toString() {
        StringBuffer r100 = new StringBuffer();
        r100.append("latitude=" + this.f26709t + "#");     // Catch: Throwable -> L6
        r100.append("longitude=" + this.f26710u + "#");     // Catch: Throwable -> L6
        r100.append("province=" + this.f26693d + "#");     // Catch: Throwable -> L6
        r100.append("coordType=" + this.G + "#");     // Catch: Throwable -> L6
        r100.append("city=" + this.f26694e + "#");     // Catch: Throwable -> L6
        r100.append("district=" + this.f26695f + "#");     // Catch: Throwable -> L6
        r100.append("cityCode=" + this.f26696g + "#");     // Catch: Throwable -> L6
        r100.append("adCode=" + this.f26697h + "#");     // Catch: Throwable -> L6
        r100.append("address=" + this.f26698i + "#");     // Catch: Throwable -> L6
        r100.append("country=" + this.f26700k + "#");     // Catch: Throwable -> L6
        r100.append("road=" + this.f26701l + "#");     // Catch: Throwable -> L6
        r100.append("poiName=" + this.f26699j + "#");     // Catch: Throwable -> L6
        r100.append("street=" + this.f26702m + "#");     // Catch: Throwable -> L6
        r100.append("streetNum=" + this.f26703n + "#");     // Catch: Throwable -> L6
        r100.append("aoiName=" + this.B + "#");     // Catch: Throwable -> L6
        r100.append("poiid=" + this.f26690a + "#");     // Catch: Throwable -> L6
        r100.append("floor=" + this.f26691b + "#");     // Catch: Throwable -> L6
        r100.append(TECameraSettings.PictureCallback.ERROR_CODE_SPLIT_REGEX + this.f26705p + "#");     // Catch: Throwable -> L6
        r100.append("errorInfo=" + this.f26706q + "#");     // Catch: Throwable -> L6
        r100.append("locationDetail=" + this.f26707r + "#");     // Catch: Throwable -> L6
        r100.append("description=" + this.E + "#");     // Catch: Throwable -> L6
        r100.append("locationType=" + this.f26708s + "#");     // Catch: Throwable -> L6
        StringBuilder r101 = new StringBuilder("conScenario=");     // Catch: Throwable -> L6
        r101.append(this.I);     // Catch: Throwable -> L6
        r100.append(r101.toString());     // Catch: Throwable -> L6
    L5:
        return r100.toString();
    }

    @Override // android.location.Location, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);     // Catch: Throwable -> L16
        r100.writeString(this.f26697h);     // Catch: Throwable -> L16
        r100.writeString(this.f26698i);     // Catch: Throwable -> L16
        r100.writeString(this.B);     // Catch: Throwable -> L16
        r100.writeString(this.f26690a);     // Catch: Throwable -> L16
        r100.writeString(this.f26694e);     // Catch: Throwable -> L16
        r100.writeString(this.f26696g);     // Catch: Throwable -> L16
        r100.writeString(this.f26700k);     // Catch: Throwable -> L16
        r100.writeString(this.f26695f);     // Catch: Throwable -> L16
        r100.writeInt(this.f26705p);     // Catch: Throwable -> L16
        r100.writeString(this.f26706q);     // Catch: Throwable -> L16
        r100.writeString(this.f26691b);     // Catch: Throwable -> L16
        int r102 = 1;
        if (this.F == false) goto L5;
        int r103 = 1;
    L6:
        r100.writeInt(r103);     // Catch: Throwable -> L16
        if (this.f26704o == false) goto L9;
        int r104 = 1;
    L10:
        r100.writeInt(r104);     // Catch: Throwable -> L16
        r100.writeDouble(this.f26709t);     // Catch: Throwable -> L16
        r100.writeString(this.f26707r);     // Catch: Throwable -> L16
        r100.writeInt(this.f26708s);     // Catch: Throwable -> L16
        r100.writeDouble(this.f26710u);     // Catch: Throwable -> L16
        if (this.D == true) goto L14;
        r102 = 0;
    L14:
        r100.writeInt(r102);     // Catch: Throwable -> L16
        r100.writeString(this.f26703n);     // Catch: Throwable -> L16
        r100.writeString(this.f26699j);     // Catch: Throwable -> L16
        r100.writeString(this.f26693d);     // Catch: Throwable -> L16
        r100.writeString(this.f26701l);     // Catch: Throwable -> L16
        r100.writeInt(this.A);     // Catch: Throwable -> L16
        r100.writeInt(this.C);     // Catch: Throwable -> L16
        r100.writeString(this.f26702m);     // Catch: Throwable -> L16
        r100.writeString(this.E);     // Catch: Throwable -> L16
        r100.writeString(this.G);     // Catch: Throwable -> L16
        r100.writeInt(this.H);     // Catch: Throwable -> L16
        r100.writeInt(this.I);     // Catch: Throwable -> L16
        return;
    L9:
        r104 = 0;
        goto L10
    L5:
        r103 = 0;
    L16:
        th = move-exception;
        c4.g(th, "AMapLocation", "writeToParcel");
    }
}
