package com.amap.api.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.utils.CoreUtil;

/* loaded from: classes.dex */
public class AMapLocationClientOption implements Cloneable, Parcelable {

    /* renamed from: H, reason: collision with root package name */
    private static int f17161H;

    /* renamed from: A, reason: collision with root package name */
    private boolean f17163A;

    /* renamed from: B, reason: collision with root package name */
    private boolean f17164B;

    /* renamed from: C, reason: collision with root package name */
    private String f17165C;

    /* renamed from: D, reason: collision with root package name */
    private float f17166D;

    /* renamed from: E, reason: collision with root package name */
    private AMapLocationPurpose f17167E;

    /* renamed from: F, reason: collision with root package name */
    boolean f17168F;

    /* renamed from: G, reason: collision with root package name */
    String f17169G;

    /* renamed from: a, reason: collision with root package name */
    private long f17170a;

    /* renamed from: b, reason: collision with root package name */
    private long f17171b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f17172c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f17173d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f17174e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f17175f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f17176g;

    /* renamed from: h, reason: collision with root package name */
    private AMapLocationMode f17177h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f17178i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f17179j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f17180k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f17181l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f17182m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f17183n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f17184o;

    /* renamed from: p, reason: collision with root package name */
    private long f17185p;

    /* renamed from: q, reason: collision with root package name */
    private long f17186q;

    /* renamed from: r, reason: collision with root package name */
    private GeoLanguage f17187r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f17188s;

    /* renamed from: t, reason: collision with root package name */
    private int f17189t;

    /* renamed from: u, reason: collision with root package name */
    private int f17190u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f17191v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f17192w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f17193x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f17194y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f17195z;

    /* renamed from: I, reason: collision with root package name */
    private static AMapLocationProtocol f17162I = AMapLocationProtocol.HTTP;
    public static String APIKEY = "";
    public static final Parcelable.Creator<AMapLocationClientOption> CREATOR = new a();
    public static boolean OPEN_ALWAYS_SCAN_WIFI = true;
    public static long SCAN_WIFI_INTERVAL = 30000;

    public enum AMapLocationMode {
        Battery_Saving,
        Device_Sensors,
        Hight_Accuracy
    }

    public enum AMapLocationProtocol {
        HTTP(0),
        HTTPS(1);


        /* renamed from: a, reason: collision with root package name */
        private int f17198a;

        AMapLocationProtocol(int i10) {
            this.f17198a = i10;
        }

        public int getValue() {
            return this.f17198a;
        }
    }

    public enum AMapLocationPurpose {
        SignIn,
        Transport,
        Sport
    }

    public enum GeoLanguage {
        DEFAULT(-1),
        ZH(0),
        ZH_HK(1),
        EN(2),
        ES(3),
        PT(4),
        FR(5),
        DE(6),
        TH(7),
        JA(8),
        KO(9),
        AR(10),
        TR(11),
        HE(12),
        IT(13),
        RU(14),
        MS(15),
        ID(16),
        VI(17),
        PL(18),
        CS(19),
        UK(20),
        AZ(21);


        /* renamed from: a, reason: collision with root package name */
        private final int f17201a;

        GeoLanguage(int i10) {
            this.f17201a = i10;
        }

        public int getLangType() {
            return this.f17201a;
        }
    }

    public static class a implements Parcelable.Creator<AMapLocationClientOption> {
        @Override // android.os.Parcelable.Creator
        public AMapLocationClientOption createFromParcel(Parcel parcel) {
            return new AMapLocationClientOption(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public AMapLocationClientOption[] newArray(int i10) {
            return new AMapLocationClientOption[i10];
        }
    }

    public AMapLocationClientOption() {
        this.f17170a = 2000L;
        this.f17171b = CoreUtil.iTo;
        this.f17172c = false;
        this.f17173d = true;
        this.f17174e = false;
        this.f17175f = true;
        this.f17176g = true;
        this.f17177h = AMapLocationMode.Hight_Accuracy;
        this.f17178i = false;
        this.f17179j = false;
        this.f17180k = true;
        this.f17181l = true;
        this.f17182m = false;
        this.f17183n = false;
        this.f17184o = true;
        this.f17185p = 30000L;
        this.f17186q = 30000L;
        this.f17187r = GeoLanguage.DEFAULT;
        this.f17188s = false;
        this.f17189t = 1500;
        this.f17190u = 21600000;
        this.f17191v = false;
        this.f17192w = true;
        this.f17193x = true;
        this.f17194y = true;
        this.f17195z = true;
        this.f17163A = true;
        this.f17164B = true;
        this.f17165C = "";
        this.f17166D = 0.0f;
        this.f17167E = null;
        this.f17168F = false;
        this.f17169G = null;
    }

    public static String getAPIKEY() {
        return APIKEY;
    }

    public static boolean isDownloadCoordinateConvertLibrary() {
        return false;
    }

    public static boolean isOpenAlwaysScanWifi() {
        return OPEN_ALWAYS_SCAN_WIFI;
    }

    public static void setDownloadCoordinateConvertLibrary(boolean z10) {
    }

    public static void setLocationProtocol(AMapLocationProtocol aMapLocationProtocol) {
        f17162I = aMapLocationProtocol;
    }

    public static void setOpenAlwaysScanWifi(boolean z10) {
        OPEN_ALWAYS_SCAN_WIFI = z10;
    }

    public static void setScanWifiInterval(long j10) {
        SCAN_WIFI_INTERVAL = j10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAuuid() {
        return this.f17165C;
    }

    public boolean getCacheCallBack() {
        return this.f17188s;
    }

    public int getCacheCallBackTime() {
        return this.f17189t;
    }

    public int getCacheTimeOut() {
        return this.f17190u;
    }

    public float getDeviceModeDistanceFilter() {
        return this.f17166D;
    }

    public GeoLanguage getGeoLanguage() {
        return this.f17187r;
    }

    public long getGpsFirstTimeout() {
        return this.f17186q;
    }

    public long getHttpTimeOut() {
        return this.f17171b;
    }

    public long getInterval() {
        return this.f17170a;
    }

    public long getLastLocationLifeCycle() {
        return this.f17185p;
    }

    public AMapLocationMode getLocationMode() {
        return this.f17177h;
    }

    public AMapLocationProtocol getLocationProtocol() {
        return f17162I;
    }

    public AMapLocationPurpose getLocationPurpose() {
        return this.f17167E;
    }

    public long getScanWifiInterval() {
        return SCAN_WIFI_INTERVAL;
    }

    public boolean isBeidouFirst() {
        return this.f17191v;
    }

    public boolean isGpsFirst() {
        return this.f17179j;
    }

    public boolean isH5LocationFileAccessEnabled() {
        return this.f17164B;
    }

    public boolean isH5LocationJavaScriptEnabled() {
        return this.f17163A;
    }

    public boolean isKillProcess() {
        return this.f17178i;
    }

    public boolean isLBSLocationEnable() {
        return this.f17195z;
    }

    public boolean isLocationCacheEnable() {
        return this.f17181l;
    }

    public boolean isMockEnable() {
        return this.f17173d;
    }

    public boolean isNeedAddress() {
        return this.f17174e;
    }

    public boolean isNoLocReqCgiEnable() {
        return this.f17193x;
    }

    public boolean isOffset() {
        return this.f17180k;
    }

    public boolean isOnceLocation() {
        return this.f17172c;
    }

    public boolean isOnceLocationLatest() {
        return this.f17182m;
    }

    public boolean isSelfStartServiceEnable() {
        return this.f17192w;
    }

    public boolean isSensorEnable() {
        return this.f17183n;
    }

    public boolean isSysNetworkLocEnable() {
        return this.f17194y;
    }

    public boolean isWifiActiveScan() {
        return this.f17175f;
    }

    public boolean isWifiScan() {
        return this.f17184o;
    }

    public void setAuuid(String str) {
        this.f17165C = str;
    }

    public AMapLocationClientOption setBeidouFirst(boolean z10) {
        this.f17191v = z10;
        return this;
    }

    public void setCacheCallBack(boolean z10) {
        this.f17188s = z10;
    }

    public void setCacheCallBackTime(int i10) {
        this.f17189t = i10;
    }

    public void setCacheTimeOut(int i10) {
        this.f17190u = i10;
    }

    public AMapLocationClientOption setDeviceModeDistanceFilter(float f10) {
        if (f10 < 0.0f) {
            f10 = 0.0f;
        }
        this.f17166D = f10;
        return this;
    }

    public AMapLocationClientOption setGeoLanguage(GeoLanguage geoLanguage) {
        this.f17187r = geoLanguage;
        if (geoLanguage != null && geoLanguage.getLangType() >= 0) {
            M1.a.e(geoLanguage.getLangType());
        }
        return this;
    }

    public AMapLocationClientOption setGpsFirst(boolean z10) {
        this.f17179j = z10;
        return this;
    }

    public AMapLocationClientOption setGpsFirstTimeout(long j10) {
        if (j10 < 5000) {
            j10 = 5000;
        }
        if (j10 > 30000) {
            j10 = 30000;
        }
        this.f17186q = j10;
        return this;
    }

    public AMapLocationClientOption setH5LocationFileAccessEnabled(boolean z10) {
        this.f17164B = z10;
        return this;
    }

    public AMapLocationClientOption setH5LocationJavaScriptEnabled(boolean z10) {
        this.f17163A = z10;
        return this;
    }

    public AMapLocationClientOption setHttpTimeOut(long j10) {
        this.f17171b = j10;
        return this;
    }

    public AMapLocationClientOption setInterval(long j10) {
        if (j10 <= 800) {
            j10 = 800;
        }
        this.f17170a = j10;
        return this;
    }

    public AMapLocationClientOption setKillProcess(boolean z10) {
        this.f17178i = z10;
        return this;
    }

    public void setLBSLocationEnable(boolean z10) {
        this.f17195z = z10;
    }

    public AMapLocationClientOption setLastLocationLifeCycle(long j10) {
        this.f17185p = j10;
        return this;
    }

    public AMapLocationClientOption setLocationCacheEnable(boolean z10) {
        this.f17181l = z10;
        return this;
    }

    public AMapLocationClientOption setLocationMode(AMapLocationMode aMapLocationMode) {
        this.f17177h = aMapLocationMode;
        return this;
    }

    public AMapLocationClientOption setLocationPurpose(AMapLocationPurpose aMapLocationPurpose) {
        this.f17167E = aMapLocationPurpose;
        if (aMapLocationPurpose != null) {
            int iOrdinal = aMapLocationPurpose.ordinal();
            if (iOrdinal == 0) {
                this.f17177h = AMapLocationMode.Hight_Accuracy;
                this.f17172c = true;
                this.f17182m = true;
                this.f17173d = false;
                this.f17184o = true;
                this.f17192w = true;
                this.f17193x = true;
                this.f17194y = true;
                int i10 = f17161H;
                if ((i10 & 1) == 0) {
                    this.f17168F = true;
                    f17161H = i10 | 1;
                    this.f17169G = "signin";
                }
            } else {
                if (iOrdinal == 1) {
                    int i11 = f17161H;
                    if ((i11 & 2) == 0) {
                        this.f17168F = true;
                        f17161H = i11 | 2;
                        this.f17169G = "transport";
                    }
                    this.f17177h = AMapLocationMode.Hight_Accuracy;
                    this.f17172c = false;
                    this.f17182m = false;
                    this.f17179j = true;
                    this.f17191v = false;
                    this.f17192w = true;
                    this.f17193x = true;
                    this.f17194y = true;
                    this.f17173d = false;
                    return this;
                }
                if (iOrdinal == 2) {
                    int i12 = f17161H;
                    if ((i12 & 4) == 0) {
                        this.f17168F = true;
                        f17161H = i12 | 4;
                        this.f17169G = "sport";
                    }
                    this.f17177h = AMapLocationMode.Hight_Accuracy;
                    this.f17172c = false;
                    this.f17182m = false;
                    this.f17179j = true;
                    this.f17191v = false;
                    this.f17192w = true;
                    this.f17193x = true;
                    this.f17194y = true;
                    this.f17173d = false;
                    return this;
                }
            }
        }
        return this;
    }

    public AMapLocationClientOption setMockEnable(boolean z10) {
        this.f17173d = z10;
        return this;
    }

    public AMapLocationClientOption setNeedAddress(boolean z10) {
        this.f17174e = z10;
        return this;
    }

    public void setNoLocReqCgiEnable(boolean z10) {
        this.f17193x = z10;
    }

    public AMapLocationClientOption setOffset(boolean z10) {
        this.f17180k = z10;
        return this;
    }

    public AMapLocationClientOption setOnceLocation(boolean z10) {
        this.f17172c = z10;
        return this;
    }

    public AMapLocationClientOption setOnceLocationLatest(boolean z10) {
        this.f17182m = z10;
        return this;
    }

    public void setSelfStartServiceEnable(boolean z10) {
        this.f17192w = z10;
    }

    public AMapLocationClientOption setSensorEnable(boolean z10) {
        this.f17183n = z10;
        return this;
    }

    public void setSysNetworkLocEnable(boolean z10) {
        this.f17194y = z10;
    }

    public AMapLocationClientOption setWifiScan(boolean z10) {
        this.f17184o = z10;
        if (z10) {
            this.f17175f = this.f17176g;
            return this;
        }
        this.f17175f = false;
        return this;
    }

    public String toString() {
        return "interval:" + String.valueOf(this.f17170a) + Const.STR_MART_WELL + "isOnceLocation:" + String.valueOf(this.f17172c) + Const.STR_MART_WELL + "locationMode:" + String.valueOf(this.f17177h) + Const.STR_MART_WELL + "locationProtocol:" + String.valueOf(f17162I) + Const.STR_MART_WELL + "isMockEnable:" + String.valueOf(this.f17173d) + Const.STR_MART_WELL + "isKillProcess:" + String.valueOf(this.f17178i) + Const.STR_MART_WELL + "isGpsFirst:" + String.valueOf(this.f17179j) + Const.STR_MART_WELL + "isBeidouFirst:" + String.valueOf(this.f17191v) + Const.STR_MART_WELL + "isSelfStartServiceEnable:" + String.valueOf(this.f17192w) + Const.STR_MART_WELL + "noLocReqCgiEnable:" + String.valueOf(this.f17193x) + Const.STR_MART_WELL + "sysNetworkLocEnable:" + String.valueOf(this.f17194y) + Const.STR_MART_WELL + "isLBSLocationEnable:" + String.valueOf(this.f17195z) + Const.STR_MART_WELL + "isNeedAddress:" + String.valueOf(this.f17174e) + Const.STR_MART_WELL + "isWifiActiveScan:" + String.valueOf(this.f17175f) + Const.STR_MART_WELL + "wifiScan:" + String.valueOf(this.f17184o) + Const.STR_MART_WELL + "httpTimeOut:" + String.valueOf(this.f17171b) + Const.STR_MART_WELL + "isLocationCacheEnable:" + String.valueOf(this.f17181l) + Const.STR_MART_WELL + "isOnceLocationLatest:" + String.valueOf(this.f17182m) + Const.STR_MART_WELL + "sensorEnable:" + String.valueOf(this.f17183n) + Const.STR_MART_WELL + "geoLanguage:" + String.valueOf(this.f17187r) + Const.STR_MART_WELL + "locationPurpose:" + String.valueOf(this.f17167E) + Const.STR_MART_WELL + "callback:" + String.valueOf(this.f17188s) + Const.STR_MART_WELL + "time:" + String.valueOf(this.f17189t) + Const.STR_MART_WELL + "h5LocationJavaScriptEnabled:" + String.valueOf(this.f17163A) + Const.STR_MART_WELL + "h5LocationFileAccessEnabled:" + String.valueOf(this.f17164B) + Const.STR_MART_WELL + "auuid:" + String.valueOf(this.f17165C) + Const.STR_MART_WELL;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f17170a);
        parcel.writeLong(this.f17171b);
        parcel.writeByte(this.f17172c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f17173d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f17174e ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f17175f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f17176g ? (byte) 1 : (byte) 0);
        AMapLocationMode aMapLocationMode = this.f17177h;
        parcel.writeInt(aMapLocationMode == null ? -1 : aMapLocationMode.ordinal());
        parcel.writeByte(this.f17178i ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f17179j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f17191v ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f17192w ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f17193x ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f17194y ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f17195z ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f17180k ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f17181l ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f17182m ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f17183n ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f17184o ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f17185p);
        parcel.writeInt(f17162I == null ? -1 : getLocationProtocol().ordinal());
        GeoLanguage geoLanguage = this.f17187r;
        parcel.writeInt(geoLanguage == null ? -1 : geoLanguage.ordinal());
        parcel.writeFloat(this.f17166D);
        AMapLocationPurpose aMapLocationPurpose = this.f17167E;
        parcel.writeInt(aMapLocationPurpose != null ? aMapLocationPurpose.ordinal() : -1);
        parcel.writeInt(OPEN_ALWAYS_SCAN_WIFI ? 1 : 0);
        parcel.writeLong(this.f17186q);
        parcel.writeByte(this.f17163A ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f17164B ? (byte) 1 : (byte) 0);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public AMapLocationClientOption m10clone() {
        try {
            super.clone();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
        aMapLocationClientOption.f17170a = this.f17170a;
        aMapLocationClientOption.f17172c = this.f17172c;
        aMapLocationClientOption.f17177h = this.f17177h;
        aMapLocationClientOption.f17173d = this.f17173d;
        aMapLocationClientOption.f17178i = this.f17178i;
        aMapLocationClientOption.f17179j = this.f17179j;
        aMapLocationClientOption.f17174e = this.f17174e;
        aMapLocationClientOption.f17175f = this.f17175f;
        aMapLocationClientOption.f17171b = this.f17171b;
        aMapLocationClientOption.f17180k = this.f17180k;
        aMapLocationClientOption.f17181l = this.f17181l;
        aMapLocationClientOption.f17182m = this.f17182m;
        aMapLocationClientOption.f17183n = isSensorEnable();
        aMapLocationClientOption.f17184o = isWifiScan();
        aMapLocationClientOption.f17185p = this.f17185p;
        setLocationProtocol(getLocationProtocol());
        aMapLocationClientOption.f17187r = this.f17187r;
        setDownloadCoordinateConvertLibrary(isDownloadCoordinateConvertLibrary());
        aMapLocationClientOption.f17166D = this.f17166D;
        aMapLocationClientOption.f17167E = this.f17167E;
        setOpenAlwaysScanWifi(isOpenAlwaysScanWifi());
        setScanWifiInterval(getScanWifiInterval());
        aMapLocationClientOption.f17186q = this.f17186q;
        aMapLocationClientOption.f17190u = getCacheTimeOut();
        aMapLocationClientOption.f17188s = getCacheCallBack();
        aMapLocationClientOption.f17189t = getCacheCallBackTime();
        aMapLocationClientOption.f17192w = isSelfStartServiceEnable();
        aMapLocationClientOption.f17193x = isNoLocReqCgiEnable();
        aMapLocationClientOption.f17194y = isSysNetworkLocEnable();
        aMapLocationClientOption.f17195z = isLBSLocationEnable();
        aMapLocationClientOption.f17163A = this.f17163A;
        aMapLocationClientOption.f17164B = this.f17164B;
        aMapLocationClientOption.f17165C = this.f17165C;
        return aMapLocationClientOption;
    }

    public AMapLocationClientOption(Parcel parcel) {
        this.f17170a = 2000L;
        this.f17171b = CoreUtil.iTo;
        this.f17172c = false;
        this.f17173d = true;
        this.f17174e = false;
        this.f17175f = true;
        this.f17176g = true;
        AMapLocationMode aMapLocationMode = AMapLocationMode.Hight_Accuracy;
        this.f17177h = aMapLocationMode;
        this.f17178i = false;
        this.f17179j = false;
        this.f17180k = true;
        this.f17181l = true;
        this.f17182m = false;
        this.f17183n = false;
        this.f17184o = true;
        this.f17185p = 30000L;
        this.f17186q = 30000L;
        GeoLanguage geoLanguage = GeoLanguage.DEFAULT;
        this.f17187r = geoLanguage;
        this.f17188s = false;
        this.f17189t = 1500;
        this.f17190u = 21600000;
        this.f17191v = false;
        this.f17192w = true;
        this.f17193x = true;
        this.f17194y = true;
        this.f17195z = true;
        this.f17163A = true;
        this.f17164B = true;
        this.f17165C = "";
        this.f17166D = 0.0f;
        this.f17167E = null;
        this.f17168F = false;
        this.f17169G = null;
        this.f17170a = parcel.readLong();
        this.f17171b = parcel.readLong();
        this.f17172c = parcel.readByte() != 0;
        this.f17173d = parcel.readByte() != 0;
        this.f17174e = parcel.readByte() != 0;
        this.f17175f = parcel.readByte() != 0;
        this.f17176g = parcel.readByte() != 0;
        int i10 = parcel.readInt();
        this.f17177h = i10 != -1 ? AMapLocationMode.values()[i10] : aMapLocationMode;
        this.f17178i = parcel.readByte() != 0;
        this.f17179j = parcel.readByte() != 0;
        this.f17191v = parcel.readByte() != 0;
        this.f17192w = parcel.readByte() != 0;
        this.f17193x = parcel.readByte() != 0;
        this.f17194y = parcel.readByte() != 0;
        this.f17195z = parcel.readByte() != 0;
        this.f17180k = parcel.readByte() != 0;
        this.f17181l = parcel.readByte() != 0;
        this.f17182m = parcel.readByte() != 0;
        this.f17183n = parcel.readByte() != 0;
        this.f17184o = parcel.readByte() != 0;
        this.f17185p = parcel.readLong();
        int i11 = parcel.readInt();
        f17162I = i11 == -1 ? AMapLocationProtocol.HTTP : AMapLocationProtocol.values()[i11];
        int i12 = parcel.readInt();
        this.f17187r = i12 != -1 ? GeoLanguage.values()[i12] : geoLanguage;
        this.f17166D = parcel.readFloat();
        int i13 = parcel.readInt();
        this.f17167E = i13 != -1 ? AMapLocationPurpose.values()[i13] : null;
        OPEN_ALWAYS_SCAN_WIFI = parcel.readByte() != 0;
        this.f17186q = parcel.readLong();
        if (parcel.dataAvail() > 0) {
            this.f17163A = parcel.readByte() != 0;
        }
        if (parcel.dataAvail() > 0) {
            this.f17164B = parcel.readByte() != 0;
        }
    }
}
