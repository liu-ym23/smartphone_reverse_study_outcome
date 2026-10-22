package com.amap.api.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.entity.region.RegionBean;
import n4a.c4;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
public class AMapLocationClientOption implements Parcelable, Cloneable {
    public static final Parcelable.Creator<AMapLocationClientOption> CREATOR = null;
    public static boolean OPEN_ALWAYS_SCAN_WIFI = false;
    public static long SCAN_WIFI_INTERVAL = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static String f26718a = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f26719d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f26720e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f26721f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static int f26722g = 4;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static AMapLocationProtocol f26723p;
    private boolean A;
    private int B;
    private int C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private float H;
    private AMapLocationPurpose I;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f26724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f26725c;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f26726h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f26727i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f26728j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f26729k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f26730l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f26731m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f26732n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private AMapLocationMode f26733o;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f26734q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f26735r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f26736s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f26737t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f26738u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f26739v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f26740w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private long f26741x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private long f26742y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private GeoLanguage f26743z;

    /* JADX INFO: renamed from: com.amap.api.location.AMapLocationClientOption$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f26744a = null;

        static {
            int[] r100 = new int[AMapLocationPurpose.values().length];
            f26744a = r100;
            r100[AMapLocationPurpose.SignIn.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f26744a[AMapLocationPurpose.Transport.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f26744a[AMapLocationPurpose.Sport.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static final enum AMapLocationMode extends Enum<AMapLocationMode> {
        public static final AMapLocationMode Battery_Saving = null;
        public static final AMapLocationMode Device_Sensors = null;
        public static final AMapLocationMode Hight_Accuracy = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final /* synthetic */ AMapLocationMode[] f26745a = null;

        static {
            AMapLocationMode r100 = new AMapLocationMode("Battery_Saving", 0);
            Battery_Saving = r100;
            AMapLocationMode r101 = new AMapLocationMode("Device_Sensors", 1);
            Device_Sensors = r101;
            AMapLocationMode r102 = new AMapLocationMode("Hight_Accuracy", 2);
            Hight_Accuracy = r102;
            f26745a = new AMapLocationMode[]{r100, r101, r102};
        }

        private AMapLocationMode(String r100, int r101) {
            super(r100, r101);
        }

        public static AMapLocationMode valueOf(String r100) {
            return (AMapLocationMode) a.a(AMapLocationMode.class, r100);
        }

        public static AMapLocationMode[] values() {
            return (AMapLocationMode[]) f26745a.clone();
        }
    }

    public static final enum AMapLocationProtocol extends Enum<AMapLocationProtocol> {
        public static final AMapLocationProtocol HTTP = null;
        public static final AMapLocationProtocol HTTPS = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final /* synthetic */ AMapLocationProtocol[] f26746b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f26747a;

        static {
            AMapLocationProtocol r100 = new AMapLocationProtocol("HTTP", 0, 0);
            HTTP = r100;
            AMapLocationProtocol r101 = new AMapLocationProtocol("HTTPS", 1, 1);
            HTTPS = r101;
            f26746b = new AMapLocationProtocol[]{r100, r101};
        }

        private AMapLocationProtocol(String r100, int r101, int r102) {
            super(r100, r101);
            this.f26747a = r102;
        }

        public static AMapLocationProtocol valueOf(String r100) {
            return (AMapLocationProtocol) a.a(AMapLocationProtocol.class, r100);
        }

        public static AMapLocationProtocol[] values() {
            return (AMapLocationProtocol[]) f26746b.clone();
        }

        public final int getValue() {
            return this.f26747a;
        }
    }

    public static final enum AMapLocationPurpose extends Enum<AMapLocationPurpose> {
        public static final AMapLocationPurpose SignIn = null;
        public static final AMapLocationPurpose Sport = null;
        public static final AMapLocationPurpose Transport = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final /* synthetic */ AMapLocationPurpose[] f26748a = null;

        static {
            AMapLocationPurpose r100 = new AMapLocationPurpose("SignIn", 0);
            SignIn = r100;
            AMapLocationPurpose r101 = new AMapLocationPurpose("Transport", 1);
            Transport = r101;
            AMapLocationPurpose r102 = new AMapLocationPurpose("Sport", 2);
            Sport = r102;
            f26748a = new AMapLocationPurpose[]{r100, r101, r102};
        }

        private AMapLocationPurpose(String r100, int r101) {
            super(r100, r101);
        }

        public static AMapLocationPurpose valueOf(String r100) {
            return (AMapLocationPurpose) a.a(AMapLocationPurpose.class, r100);
        }

        public static AMapLocationPurpose[] values() {
            return (AMapLocationPurpose[]) f26748a.clone();
        }
    }

    public static final enum GeoLanguage extends Enum<GeoLanguage> {
        public static final GeoLanguage DEFAULT = null;
        public static final GeoLanguage EN = null;
        public static final GeoLanguage ZH = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final /* synthetic */ GeoLanguage[] f26749a = null;

        static {
            GeoLanguage r100 = new GeoLanguage("DEFAULT", 0);
            DEFAULT = r100;
            GeoLanguage r101 = new GeoLanguage("ZH", 1);
            ZH = r101;
            GeoLanguage r102 = new GeoLanguage("EN", 2);
            EN = r102;
            f26749a = new GeoLanguage[]{r100, r101, r102};
        }

        private GeoLanguage(String r100, int r101) {
            super(r100, r101);
        }

        public static GeoLanguage valueOf(String r100) {
            return (GeoLanguage) a.a(GeoLanguage.class, r100);
        }

        public static GeoLanguage[] values() {
            return (GeoLanguage[]) f26749a.clone();
        }
    }

    static {
        f26723p = AMapLocationProtocol.HTTP;
        f26718a = "";
        CREATOR = new AnonymousClass1();
        OPEN_ALWAYS_SCAN_WIFI = true;
        SCAN_WIFI_INTERVAL = 30000;
    }

    public AMapLocationClientOption() {
        this.f26726h = 2000;
        String r100 = c4.f517206a;
        this.f26727i = 30000;
        this.f26728j = false;
        this.f26729k = true;
        this.f26730l = true;
        this.f26731m = true;
        this.f26732n = true;
        this.f26733o = AMapLocationMode.Hight_Accuracy;
        this.f26734q = false;
        this.f26735r = false;
        this.f26736s = true;
        this.f26737t = true;
        this.f26738u = false;
        this.f26739v = false;
        this.f26740w = true;
        this.f26741x = 30000;
        this.f26742y = 30000;
        this.f26743z = GeoLanguage.DEFAULT;
        this.A = false;
        this.B = 1500;
        this.C = RegionBean.DEFAULT_EXPIRE_TIME;
        this.D = false;
        this.E = true;
        this.F = true;
        this.G = true;
        this.H = 0.0f;
        this.I = null;
        this.f26724b = false;
        this.f26725c = null;
    }

    public AMapLocationClientOption(Parcel r110) {
        this.f26726h = 2000;
        String r100 = c4.f517206a;
        this.f26727i = 30000;
        boolean r101 = false;
        this.f26728j = false;
        this.f26729k = true;
        this.f26730l = true;
        this.f26731m = true;
        this.f26732n = true;
        AMapLocationMode r102 = AMapLocationMode.Hight_Accuracy;
        this.f26733o = r102;
        this.f26734q = false;
        this.f26735r = false;
        this.f26736s = true;
        this.f26737t = true;
        this.f26738u = false;
        this.f26739v = false;
        this.f26740w = true;
        this.f26741x = 30000;
        this.f26742y = 30000;
        GeoLanguage r103 = GeoLanguage.DEFAULT;
        this.f26743z = r103;
        this.A = false;
        this.B = 1500;
        this.C = RegionBean.DEFAULT_EXPIRE_TIME;
        this.D = false;
        this.E = true;
        this.F = true;
        this.G = true;
        this.H = 0.0f;
        AMapLocationPurpose r104 = null;
        this.I = null;
        this.f26724b = false;
        this.f26725c = null;
        this.f26726h = r110.readLong();
        this.f26727i = r110.readLong();
        if (r110.readByte() == 0) goto L5;
        boolean r105 = true;
    L6:
        this.f26728j = r105;
        if (r110.readByte() == 0) goto L9;
        boolean r106 = true;
    L10:
        this.f26729k = r106;
        if (r110.readByte() == 0) goto L13;
        boolean r107 = true;
    L14:
        this.f26730l = r107;
        if (r110.readByte() == 0) goto L17;
        boolean r108 = true;
    L18:
        this.f26731m = r108;
        if (r110.readByte() == 0) goto L21;
        boolean r109 = true;
    L22:
        this.f26732n = r109;
        int r111 = r110.readInt();
        if (r111 == (-1)) goto L26;
        r102 = AMapLocationMode.values()[r111];
    L26:
        this.f26733o = r102;
        if (r110.readByte() == 0) goto L29;
        boolean r112 = true;
    L30:
        this.f26734q = r112;
        if (r110.readByte() == 0) goto L33;
        boolean r113 = true;
    L34:
        this.f26735r = r113;
        if (r110.readByte() == 0) goto L37;
        boolean r114 = true;
    L38:
        this.D = r114;
        if (r110.readByte() == 0) goto L41;
        boolean r115 = true;
    L42:
        this.E = r115;
        if (r110.readByte() == 0) goto L45;
        boolean r116 = true;
    L46:
        this.F = r116;
        if (r110.readByte() == 0) goto L49;
        boolean r117 = true;
    L50:
        this.G = r117;
        if (r110.readByte() == 0) goto L53;
        boolean r118 = true;
    L54:
        this.f26736s = r118;
        if (r110.readByte() == 0) goto L57;
        boolean r119 = true;
    L58:
        this.f26737t = r119;
        if (r110.readByte() == 0) goto L61;
        boolean r120 = true;
    L62:
        this.f26738u = r120;
        if (r110.readByte() == 0) goto L65;
        boolean r121 = true;
    L66:
        this.f26739v = r121;
        if (r110.readByte() == 0) goto L69;
        boolean r122 = true;
    L70:
        this.f26740w = r122;
        this.f26741x = r110.readLong();
        int r123 = r110.readInt();
        if (r123 != (-1)) goto L73;
        AMapLocationProtocol r124 = AMapLocationProtocol.HTTP;
    L74:
        f26723p = r124;
        int r125 = r110.readInt();
        if (r125 == (-1)) goto L78;
        r103 = GeoLanguage.values()[r125];
    L78:
        this.f26743z = r103;
        this.H = r110.readFloat();
        int r126 = r110.readInt();
        if (r126 == (-1)) goto L82;
        r104 = AMapLocationPurpose.values()[r126];
    L82:
        this.I = r104;
        if (r110.readByte() == 0) goto L85;
        r101 = true;
    L85:
        OPEN_ALWAYS_SCAN_WIFI = r101;
        this.f26742y = r110.readLong();
        return;
    L73:
        r124 = AMapLocationProtocol.values()[r123];
        goto L74
    L69:
        r122 = false;
        goto L70
    L65:
        r121 = false;
        goto L66
    L61:
        r120 = false;
        goto L62
    L57:
        r119 = false;
        goto L58
    L53:
        r118 = false;
        goto L54
    L49:
        r117 = false;
        goto L50
    L45:
        r116 = false;
        goto L46
    L41:
        r115 = false;
        goto L42
    L37:
        r114 = false;
        goto L38
    L33:
        r113 = false;
        goto L34
    L29:
        r112 = false;
        goto L30
    L21:
        r109 = false;
        goto L22
    L17:
        r108 = false;
        goto L18
    L13:
        r107 = false;
        goto L14
    L9:
        r106 = false;
        goto L10
    L5:
        r105 = false;
        goto L6
    }

    private AMapLocationClientOption a(AMapLocationClientOption r100) {
        this.f26726h = r100.f26726h;
        this.f26728j = r100.f26728j;
        this.f26733o = r100.f26733o;
        this.f26729k = r100.f26729k;
        this.f26734q = r100.f26734q;
        this.f26735r = r100.f26735r;
        this.D = r100.D;
        this.f26730l = r100.f26730l;
        this.f26731m = r100.f26731m;
        this.f26727i = r100.f26727i;
        this.f26736s = r100.f26736s;
        this.f26737t = r100.f26737t;
        this.f26738u = r100.f26738u;
        this.f26739v = r100.isSensorEnable();
        this.f26740w = r100.isWifiScan();
        this.f26741x = r100.f26741x;
        setLocationProtocol(r100.getLocationProtocol());
        this.f26743z = r100.f26743z;
        setDownloadCoordinateConvertLibrary(isDownloadCoordinateConvertLibrary());
        this.H = r100.H;
        this.I = r100.I;
        setOpenAlwaysScanWifi(isOpenAlwaysScanWifi());
        setScanWifiInterval(r100.getScanWifiInterval());
        this.f26742y = r100.f26742y;
        this.C = r100.getCacheTimeOut();
        this.A = r100.getCacheCallBack();
        this.B = r100.getCacheCallBackTime();
        this.E = r100.isSelfStartServiceEnable();
        this.F = r100.isNoLocReqCgiEnable();
        this.G = r100.isSysNetworkLocEnable();
        return this;
    }

    public static String getAPIKEY() {
        return f26718a;
    }

    public static boolean isDownloadCoordinateConvertLibrary() {
        return false;
    }

    public static boolean isOpenAlwaysScanWifi() {
        return OPEN_ALWAYS_SCAN_WIFI;
    }

    public static void setDownloadCoordinateConvertLibrary(boolean r100) {
    }

    public static void setLocationProtocol(AMapLocationProtocol r100) {
        f26723p = r100;
    }

    public static void setOpenAlwaysScanWifi(boolean r100) {
        OPEN_ALWAYS_SCAN_WIFI = r100;
    }

    public static void setScanWifiInterval(long r100) {
        SCAN_WIFI_INTERVAL = r100;
    }

    public AMapLocationClientOption clone() {
        super.clone();     // Catch: Throwable -> L4
    L7:
        return new AMapLocationClientOption().a(this);
    L4:
        th = move-exception;
        th.printStackTrace();
        goto L7
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8019clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean getCacheCallBack() {
        return this.A;
    }

    public int getCacheCallBackTime() {
        return this.B;
    }

    public int getCacheTimeOut() {
        return this.C;
    }

    public float getDeviceModeDistanceFilter() {
        return this.H;
    }

    public GeoLanguage getGeoLanguage() {
        return this.f26743z;
    }

    public long getGpsFirstTimeout() {
        return this.f26742y;
    }

    public long getHttpTimeOut() {
        return this.f26727i;
    }

    public long getInterval() {
        return this.f26726h;
    }

    public long getLastLocationLifeCycle() {
        return this.f26741x;
    }

    public AMapLocationMode getLocationMode() {
        return this.f26733o;
    }

    public AMapLocationProtocol getLocationProtocol() {
        return f26723p;
    }

    public AMapLocationPurpose getLocationPurpose() {
        return this.I;
    }

    public long getScanWifiInterval() {
        return SCAN_WIFI_INTERVAL;
    }

    public boolean isBeidouFirst() {
        return this.D;
    }

    public boolean isGpsFirst() {
        return this.f26735r;
    }

    public boolean isKillProcess() {
        return this.f26734q;
    }

    public boolean isLocationCacheEnable() {
        return this.f26737t;
    }

    public boolean isMockEnable() {
        return this.f26729k;
    }

    public boolean isNeedAddress() {
        return this.f26730l;
    }

    public boolean isNoLocReqCgiEnable() {
        return this.F;
    }

    public boolean isOffset() {
        return this.f26736s;
    }

    public boolean isOnceLocation() {
        return this.f26728j;
    }

    public boolean isOnceLocationLatest() {
        return this.f26738u;
    }

    public boolean isSelfStartServiceEnable() {
        return this.E;
    }

    public boolean isSensorEnable() {
        return this.f26739v;
    }

    public boolean isSysNetworkLocEnable() {
        return this.G;
    }

    public boolean isWifiActiveScan() {
        return this.f26731m;
    }

    public boolean isWifiScan() {
        return this.f26740w;
    }

    public AMapLocationClientOption setBeidouFirst(boolean r100) {
        this.D = r100;
        return this;
    }

    public void setCacheCallBack(boolean r100) {
        this.A = r100;
    }

    public void setCacheCallBackTime(int r100) {
        this.B = r100;
    }

    public void setCacheTimeOut(int r100) {
        this.C = r100;
    }

    public AMapLocationClientOption setDeviceModeDistanceFilter(float r100) {
        if (r100 >= 0.0f) goto L5;
        r100 = 0.0f;
    L5:
        this.H = r100;
        return this;
    }

    public AMapLocationClientOption setGeoLanguage(GeoLanguage r100) {
        this.f26743z = r100;
        return this;
    }

    public AMapLocationClientOption setGpsFirst(boolean r100) {
        this.f26735r = r100;
        return this;
    }

    public AMapLocationClientOption setGpsFirstTimeout(long r100) {
        if (r100 >= 5000) goto L6;
        r100 = 5000;
    L6:
        if (r100 <= 30000) goto L8;
        r100 = 30000;
    L8:
        this.f26742y = r100;
        return this;
    }

    public AMapLocationClientOption setHttpTimeOut(long r100) {
        this.f26727i = r100;
        return this;
    }

    public AMapLocationClientOption setInterval(long r100) {
        if (r100 > 800) goto L5;
        r100 = 800;
    L5:
        this.f26726h = r100;
        return this;
    }

    public AMapLocationClientOption setKillProcess(boolean r100) {
        this.f26734q = r100;
        return this;
    }

    public AMapLocationClientOption setLastLocationLifeCycle(long r100) {
        this.f26741x = r100;
        return this;
    }

    public AMapLocationClientOption setLocationCacheEnable(boolean r100) {
        this.f26737t = r100;
        return this;
    }

    public AMapLocationClientOption setLocationMode(AMapLocationMode r100) {
        this.f26733o = r100;
        return this;
    }

    public AMapLocationClientOption setLocationPurpose(AMapLocationPurpose r100) {
        this.I = r100;
        if (r100 == null) goto L22;
        int r101 = AnonymousClass2.f26744a[r100.ordinal()];
        if (r101 != 1) goto L7;
        this.f26733o = AMapLocationMode.Hight_Accuracy;
        this.f26728j = true;
        this.f26738u = true;
        this.f26735r = false;
        this.D = false;
        this.f26729k = false;
        this.f26740w = true;
        this.E = true;
        this.F = true;
        this.G = true;
        int r102 = f26719d;
        int r103 = f26720e;
        if ((r102 & r103) != 0) goto L22;
        this.f26724b = true;
        f26719d = r102 | r103;
        this.f26725c = "signin";
        goto L22
    L7:
        if (r101 != 2) goto L9;
        int r104 = f26719d;
        int r105 = f26721f;
        if ((r104 & r105) != 0) goto L18;
        this.f26724b = true;
        f26719d = r104 | r105;
        String r106 = NotificationCompat.CATEGORY_TRANSPORT;
    L17:
        this.f26725c = r106;
    L18:
        this.f26733o = AMapLocationMode.Hight_Accuracy;
        this.f26728j = false;
        this.f26738u = false;
        this.f26735r = true;
        this.D = false;
        this.E = true;
        this.F = true;
        this.G = true;
        this.f26729k = false;
        this.f26740w = true;
        goto L22
    L9:
        if (r101 != 3) goto L22;
        int r107 = f26719d;
        int r108 = f26722g;
        if ((r107 & r108) != 0) goto L18;
        this.f26724b = true;
        f26719d = r107 | r108;
        r106 = "sport";
    L22:
        return this;
    }

    public AMapLocationClientOption setMockEnable(boolean r100) {
        this.f26729k = r100;
        return this;
    }

    public AMapLocationClientOption setNeedAddress(boolean r100) {
        this.f26730l = r100;
        return this;
    }

    public void setNoLocReqCgiEnable(boolean r100) {
        this.F = r100;
    }

    public AMapLocationClientOption setOffset(boolean r100) {
        this.f26736s = r100;
        return this;
    }

    public AMapLocationClientOption setOnceLocation(boolean r100) {
        this.f26728j = r100;
        return this;
    }

    public AMapLocationClientOption setOnceLocationLatest(boolean r100) {
        this.f26738u = r100;
        return this;
    }

    public void setSelfStartServiceEnable(boolean r100) {
        this.E = r100;
    }

    public AMapLocationClientOption setSensorEnable(boolean r100) {
        this.f26739v = r100;
        return this;
    }

    public void setSysNetworkLocEnable(boolean r100) {
        this.G = r100;
    }

    public AMapLocationClientOption setWifiActiveScan(boolean r100) {
        this.f26731m = r100;
        this.f26732n = r100;
        return this;
    }

    public AMapLocationClientOption setWifiScan(boolean r100) {
        this.f26740w = r100;
        if (r100 == false) goto L5;
        boolean r101 = this.f26732n;
    L6:
        this.f26731m = r101;
        return this;
    L5:
        r101 = false;
        goto L6
    }

    public String toString() {
        return "interval:" + String.valueOf(this.f26726h) + "#isOnceLocation:" + String.valueOf(this.f26728j) + "#locationMode:" + String.valueOf(this.f26733o) + "#locationProtocol:" + String.valueOf(f26723p) + "#isMockEnable:" + String.valueOf(this.f26729k) + "#isKillProcess:" + String.valueOf(this.f26734q) + "#isGpsFirst:" + String.valueOf(this.f26735r) + "#isBeidouFirst:" + String.valueOf(this.D) + "#isSelfStartServiceEnable:" + String.valueOf(this.E) + "#noLocReqCgiEnable:" + String.valueOf(this.F) + "#sysNetworkLocEnable:" + String.valueOf(this.G) + "#isNeedAddress:" + String.valueOf(this.f26730l) + "#isWifiActiveScan:" + String.valueOf(this.f26731m) + "#wifiScan:" + String.valueOf(this.f26740w) + "#httpTimeOut:" + String.valueOf(this.f26727i) + "#isLocationCacheEnable:" + String.valueOf(this.f26737t) + "#isOnceLocationLatest:" + String.valueOf(this.f26738u) + "#sensorEnable:" + String.valueOf(this.f26739v) + "#geoLanguage:" + String.valueOf(this.f26743z) + "#locationPurpose:" + String.valueOf(this.I) + "#callback:" + String.valueOf(this.A) + "#time:" + String.valueOf(this.B) + "#";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeLong(this.f26726h);
        r100.writeLong(this.f26727i);
        r100.writeByte(this.f26728j ? 1 : 0);
        r100.writeByte(this.f26729k ? 1 : 0);
        r100.writeByte(this.f26730l ? 1 : 0);
        r100.writeByte(this.f26731m ? 1 : 0);
        r100.writeByte(this.f26732n ? 1 : 0);
        AMapLocationMode r102 = this.f26733o;
        int r103 = -1;
        if (r102 != null) goto L5;
        int r104 = -1;
    L6:
        r100.writeInt(r104);
        r100.writeByte(this.f26734q ? 1 : 0);
        r100.writeByte(this.f26735r ? 1 : 0);
        r100.writeByte(this.D ? 1 : 0);
        r100.writeByte(this.E ? 1 : 0);
        r100.writeByte(this.F ? 1 : 0);
        r100.writeByte(this.G ? 1 : 0);
        r100.writeByte(this.f26736s ? 1 : 0);
        r100.writeByte(this.f26737t ? 1 : 0);
        r100.writeByte(this.f26738u ? 1 : 0);
        r100.writeByte(this.f26739v ? 1 : 0);
        r100.writeByte(this.f26740w ? 1 : 0);
        r100.writeLong(this.f26741x);
        if (f26723p != null) goto L9;
        int r105 = -1;
    L10:
        r100.writeInt(r105);
        GeoLanguage r106 = this.f26743z;
        if (r106 != null) goto L13;
        int r107 = -1;
    L14:
        r100.writeInt(r107);
        r100.writeFloat(this.H);
        AMapLocationPurpose r108 = this.I;
        if (r108 == null) goto L18;
        r103 = r108.ordinal();
    L18:
        r100.writeInt(r103);
        r100.writeInt(OPEN_ALWAYS_SCAN_WIFI ? 1 : 0);
        r100.writeLong(this.f26742y);
        return;
    L13:
        r107 = r106.ordinal();
        goto L14
    L9:
        r105 = getLocationProtocol().ordinal();
        goto L10
    L5:
        r104 = r102.ordinal();
        goto L6
    }
}
