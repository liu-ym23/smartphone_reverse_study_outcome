package com.amap.api.location;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.amap.api.col.jmsl.C1562i;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.location.support.bean.location.AmapLocation;
import com.amap.location.support.bean.location.AmapLocationNetwork;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.autonavi.aps.amapapi.utils.Utils;
import io.ktor.sse.ServerSentEventKt;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AMapLocation extends Location implements Cloneable, Parcelable {
    public static final String COORD_TYPE_GCJ02 = "GCJ02";
    public static final String COORD_TYPE_WGS84 = "WGS84";
    public static final Parcelable.Creator<AMapLocation> CREATOR = new a();
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

    /* renamed from: A, reason: collision with root package name */
    private int f17106A;

    /* renamed from: B, reason: collision with root package name */
    private boolean f17107B;

    /* renamed from: C, reason: collision with root package name */
    private String f17108C;

    /* renamed from: D, reason: collision with root package name */
    private boolean f17109D;

    /* renamed from: E, reason: collision with root package name */
    private int f17110E;

    /* renamed from: F, reason: collision with root package name */
    private String f17111F;

    /* renamed from: G, reason: collision with root package name */
    private int f17112G;

    /* renamed from: H, reason: collision with root package name */
    private int f17113H;

    /* renamed from: I, reason: collision with root package name */
    private int f17114I;

    /* renamed from: J, reason: collision with root package name */
    private int f17115J;

    /* renamed from: K, reason: collision with root package name */
    private long f17116K;

    /* renamed from: L, reason: collision with root package name */
    private long f17117L;

    /* renamed from: M, reason: collision with root package name */
    private String f17118M;

    /* renamed from: N, reason: collision with root package name */
    private int f17119N;

    /* renamed from: O, reason: collision with root package name */
    private boolean f17120O;

    /* renamed from: P, reason: collision with root package name */
    private int f17121P;

    /* renamed from: Q, reason: collision with root package name */
    private int f17122Q;

    /* renamed from: R, reason: collision with root package name */
    private String f17123R;

    /* renamed from: S, reason: collision with root package name */
    private boolean f17124S;

    /* renamed from: T, reason: collision with root package name */
    private boolean f17125T;

    /* renamed from: U, reason: collision with root package name */
    private int f17126U;

    /* renamed from: V, reason: collision with root package name */
    private String f17127V;

    /* renamed from: W, reason: collision with root package name */
    private HashMap<String, Object> f17128W;

    /* renamed from: X, reason: collision with root package name */
    private boolean f17129X;

    /* renamed from: Y, reason: collision with root package name */
    private String f17130Y;

    /* renamed from: Z, reason: collision with root package name */
    private float f17131Z;

    /* renamed from: a, reason: collision with root package name */
    private String f17132a;

    /* renamed from: a0, reason: collision with root package name */
    private float f17133a0;

    /* renamed from: b, reason: collision with root package name */
    private String f17134b;

    /* renamed from: b0, reason: collision with root package name */
    private float f17135b0;

    /* renamed from: c, reason: collision with root package name */
    private String f17136c;

    /* renamed from: c0, reason: collision with root package name */
    com.amap.api.location.a f17137c0;

    /* renamed from: d, reason: collision with root package name */
    private String f17138d;

    /* renamed from: e, reason: collision with root package name */
    private String f17139e;

    /* renamed from: f, reason: collision with root package name */
    private String f17140f;
    protected String floor;

    /* renamed from: g, reason: collision with root package name */
    private String f17141g;

    /* renamed from: h, reason: collision with root package name */
    private String f17142h;

    /* renamed from: i, reason: collision with root package name */
    private String f17143i;

    /* renamed from: j, reason: collision with root package name */
    private String f17144j;

    /* renamed from: k, reason: collision with root package name */
    private String f17145k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f17146l;

    /* renamed from: m, reason: collision with root package name */
    private int f17147m;
    protected String mPoiid;

    /* renamed from: n, reason: collision with root package name */
    private String f17148n;

    /* renamed from: o, reason: collision with root package name */
    private String f17149o;

    /* renamed from: p, reason: collision with root package name */
    private int f17150p;

    /* renamed from: q, reason: collision with root package name */
    private double f17151q;

    /* renamed from: r, reason: collision with root package name */
    private double f17152r;

    /* renamed from: s, reason: collision with root package name */
    private double f17153s;

    /* renamed from: t, reason: collision with root package name */
    private float f17154t;

    /* renamed from: u, reason: collision with root package name */
    private float f17155u;

    /* renamed from: v, reason: collision with root package name */
    private Bundle f17156v;

    /* renamed from: w, reason: collision with root package name */
    private String f17157w;

    /* renamed from: x, reason: collision with root package name */
    private int f17158x;

    /* renamed from: y, reason: collision with root package name */
    private String f17159y;

    /* renamed from: z, reason: collision with root package name */
    private String f17160z;

    public static class a implements Parcelable.Creator<AMapLocation> {
        @Override // android.os.Parcelable.Creator
        public AMapLocation createFromParcel(Parcel parcel) {
            AMapLocation aMapLocation = new AMapLocation((Location) Location.CREATOR.createFromParcel(parcel));
            aMapLocation.f17139e = parcel.readString();
            aMapLocation.f17140f = parcel.readString();
            aMapLocation.f17159y = parcel.readString();
            aMapLocation.mPoiid = parcel.readString();
            aMapLocation.f17134b = parcel.readString();
            aMapLocation.f17138d = parcel.readString();
            aMapLocation.f17142h = parcel.readString();
            aMapLocation.f17136c = parcel.readString();
            aMapLocation.f17147m = parcel.readInt();
            aMapLocation.f17148n = parcel.readString();
            aMapLocation.floor = parcel.readString();
            aMapLocation.f17160z = parcel.readString();
            aMapLocation.f17109D = parcel.readInt() != 0;
            aMapLocation.f17146l = parcel.readInt() != 0;
            aMapLocation.f17151q = parcel.readDouble();
            aMapLocation.f17149o = parcel.readString();
            aMapLocation.f17150p = parcel.readInt();
            aMapLocation.f17152r = parcel.readDouble();
            aMapLocation.f17107B = parcel.readInt() != 0;
            aMapLocation.f17145k = parcel.readString();
            aMapLocation.f17141g = parcel.readString();
            aMapLocation.f17132a = parcel.readString();
            aMapLocation.f17143i = parcel.readString();
            aMapLocation.f17158x = parcel.readInt();
            aMapLocation.f17106A = parcel.readInt();
            aMapLocation.f17144j = parcel.readString();
            aMapLocation.f17108C = parcel.readString();
            aMapLocation.f17111F = parcel.readString();
            aMapLocation.f17110E = parcel.readInt();
            aMapLocation.f17112G = parcel.readInt();
            aMapLocation.f17113H = parcel.readInt();
            aMapLocation.f17114I = parcel.readInt();
            aMapLocation.f17115J = parcel.readInt();
            aMapLocation.f17116K = parcel.readLong();
            aMapLocation.f17117L = parcel.readLong();
            aMapLocation.f17118M = parcel.readString();
            aMapLocation.f17130Y = parcel.readString();
            aMapLocation.f17129X = parcel.readInt() != 0;
            aMapLocation.f17119N = parcel.readInt();
            aMapLocation.f17120O = parcel.readInt() != 0;
            aMapLocation.f17121P = parcel.readInt();
            aMapLocation.f17122Q = parcel.readInt();
            aMapLocation.f17123R = parcel.readString();
            aMapLocation.f17124S = parcel.readInt() != 0;
            aMapLocation.f17125T = parcel.readInt() != 0;
            aMapLocation.f17126U = parcel.readInt();
            aMapLocation.f17127V = parcel.readString();
            return aMapLocation;
        }

        @Override // android.os.Parcelable.Creator
        public AMapLocation[] newArray(int i10) {
            return new AMapLocation[i10];
        }
    }

    public AMapLocation(String str) {
        super(str);
        this.f17132a = "";
        this.f17134b = "";
        this.f17136c = "";
        this.f17138d = "";
        this.f17139e = "";
        this.f17140f = "";
        this.f17141g = "";
        this.f17142h = "";
        this.f17143i = "";
        this.f17144j = "";
        this.f17145k = "";
        this.f17146l = true;
        this.f17147m = 0;
        this.f17148n = "success";
        this.f17149o = "";
        this.f17150p = 0;
        this.f17151q = 0.0d;
        this.f17152r = 0.0d;
        this.f17153s = 0.0d;
        this.f17154t = 0.0f;
        this.f17155u = 0.0f;
        this.f17156v = null;
        this.f17158x = 0;
        this.f17159y = "";
        this.mPoiid = "";
        this.floor = "";
        this.f17160z = "";
        this.f17106A = -1;
        this.f17107B = false;
        this.f17108C = "";
        this.f17109D = false;
        this.f17110E = -1;
        this.f17111F = "GCJ02";
        this.f17112G = 1;
        this.f17121P = -1;
        this.f17122Q = -1;
        this.f17129X = false;
        this.f17130Y = String.valueOf(AMapLocationClientOption.GeoLanguage.DEFAULT);
        this.f17137c0 = new com.amap.api.location.a();
        this.f17157w = str;
    }

    public synchronized void clearOptAttrs() {
        try {
            HashMap<String, Object> map = this.f17128W;
            if (map != null) {
                map.clear();
            }
        } catch (Exception unused) {
        }
    }

    public synchronized HashMap<String, Object> cloneOptAttrs() {
        HashMap<String, Object> map;
        map = this.f17128W;
        return (map == null || map.size() <= 0) ? null : new HashMap<>(this.f17128W);
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
        return this.f17139e;
    }

    public String getAddress() {
        return this.f17140f;
    }

    @Override // android.location.Location
    public double getAltitude() {
        return this.f17153s;
    }

    public String getAoiName() {
        return this.f17159y;
    }

    @Override // android.location.Location
    public float getBearing() {
        return this.f17155u;
    }

    @Override // android.location.Location
    public float getBearingAccuracyDegrees() {
        return this.f17135b0;
    }

    public String getBuildingId() {
        return this.mPoiid;
    }

    public String getCity() {
        return this.f17134b;
    }

    public String getCityCode() {
        return this.f17138d;
    }

    public int getConScenario() {
        return this.f17113H;
    }

    public int getCoord() {
        return this.f17110E;
    }

    public String getCoordType() {
        return this.f17111F;
    }

    public String getCountry() {
        return this.f17142h;
    }

    public String getDescription() {
        return this.f17108C;
    }

    public int getDiagnosisType() {
        return this.f17119N;
    }

    public String getDistrict() {
        return this.f17136c;
    }

    public int getErrorCode() {
        return this.f17147m;
    }

    public String getErrorInfo() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f17148n);
        if (this.f17147m != 0) {
            sb2.append(" " + C1562i.a("O105493_10") + Const.ERRORCODE_WEB + C1562i.a("O105493_11"));
            sb2.append(Const.STR_MART_COMMA + C1562i.a("O105493_12") + ServerSentEventKt.COLON + this.f17149o);
        }
        return sb2.toString();
    }

    @Override // android.location.Location
    public Bundle getExtras() {
        return this.f17156v;
    }

    public String getFloor() {
        return this.floor;
    }

    public String getFloorName() {
        return this.f17160z;
    }

    public String getGeoLanguage() {
        return this.f17130Y;
    }

    public int getGpsAccuracyStatus() {
        return this.f17106A;
    }

    public int getIod() {
        return this.f17121P;
    }

    public int getIodConfidence() {
        return this.f17122Q;
    }

    @Override // android.location.Location
    public double getLatitude() {
        return this.f17151q;
    }

    public String getLocationDetail() {
        return this.f17149o;
    }

    public com.amap.api.location.a getLocationQualityReport() {
        return this.f17137c0;
    }

    public long getLocationTickTime() {
        return this.f17117L;
    }

    public int getLocationType() {
        return this.f17150p;
    }

    public long getLocationUtcTime() {
        return this.f17116K;
    }

    @Override // android.location.Location
    public double getLongitude() {
        return this.f17152r;
    }

    public synchronized Object getOptAttr(String str) {
        HashMap<String, Object> map = this.f17128W;
        if (map != null && map.get(str) != null) {
            try {
                return this.f17128W.get(str);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public synchronized boolean getOptAttrBoolean(String str, boolean z10) {
        if (has(str)) {
            try {
                Object obj = this.f17128W.get(str);
                if (obj != null) {
                    return Boolean.parseBoolean(obj.toString());
                }
            } catch (Exception unused) {
            }
        }
        return z10;
    }

    public synchronized double getOptAttrDouble(String str, double d10) {
        if (has(str)) {
            try {
                Object obj = this.f17128W.get(str);
                if (obj != null) {
                    return Double.parseDouble(obj.toString());
                }
            } catch (Exception unused) {
            }
        }
        return d10;
    }

    public synchronized float getOptAttrFloat(String str, float f10) {
        if (has(str)) {
            try {
                Object obj = this.f17128W.get(str);
                if (obj != null) {
                    return Float.parseFloat(obj.toString());
                }
            } catch (Exception unused) {
            }
        }
        return f10;
    }

    public synchronized int getOptAttrInt(String str, int i10) {
        if (has(str)) {
            try {
                Object obj = this.f17128W.get(str);
                if (obj != null) {
                    return Integer.parseInt(obj.toString());
                }
            } catch (Exception unused) {
            }
        }
        return i10;
    }

    public synchronized long getOptAttrLong(String str, long j10) {
        if (has(str)) {
            try {
                Object obj = this.f17128W.get(str);
                if (obj != null) {
                    return Long.parseLong(obj.toString());
                }
            } catch (Exception unused) {
            }
        }
        return j10;
    }

    public synchronized String getOptAttrString(String str, String str2) {
        if (has(str)) {
            try {
                return (String) this.f17128W.get(str);
            } catch (Exception unused) {
            }
        }
        return str2;
    }

    public String getOptContent() {
        return this.f17127V;
    }

    public String getPoiName() {
        return this.f17141g;
    }

    public int getPriority() {
        return this.f17126U;
    }

    @Override // android.location.Location
    public String getProvider() {
        return this.f17157w;
    }

    public String getProvince() {
        return this.f17132a;
    }

    public String getRoad() {
        return this.f17143i;
    }

    public int getSatellites() {
        return this.f17158x;
    }

    public String getSemantics() {
        return this.f17123R;
    }

    public String getSource() {
        return this.f17118M;
    }

    @Override // android.location.Location
    public float getSpeed() {
        return this.f17154t;
    }

    @Override // android.location.Location
    public float getSpeedAccuracyMetersPerSecond() {
        return this.f17133a0;
    }

    public String getStreet() {
        return this.f17144j;
    }

    public String getStreetNum() {
        return this.f17145k;
    }

    public int getSubType() {
        return this.f17115J;
    }

    public int getTrustedLevel() {
        return this.f17112G;
    }

    public int getType() {
        return this.f17114I;
    }

    @Override // android.location.Location
    public float getVerticalAccuracyMeters() {
        return this.f17131Z;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x000f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized boolean has(java.lang.String r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.HashMap<java.lang.String, java.lang.Object> r0 = r1.f17128W     // Catch: java.lang.Throwable -> Ld
            if (r0 == 0) goto Lf
            java.lang.Object r2 = r0.get(r2)     // Catch: java.lang.Throwable -> Ld
            if (r2 == 0) goto Lf
            r2 = 1
            goto L10
        Ld:
            r2 = move-exception
            goto L12
        Lf:
            r2 = 0
        L10:
            monitor-exit(r1)
            return r2
        L12:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Ld
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.location.AMapLocation.has(java.lang.String):boolean");
    }

    public boolean isCoorCanUseInMap() {
        return this.f17125T;
    }

    public boolean isDim() {
        return this.f17120O;
    }

    public boolean isFixLastLocation() {
        return this.f17109D;
    }

    @Override // android.location.Location
    public boolean isMock() {
        return this.f17107B;
    }

    public boolean isOffset() {
        return this.f17146l;
    }

    public boolean isReversegeo() {
        return this.f17129X;
    }

    public boolean isSpeedKmh() {
        return this.f17124S;
    }

    public synchronized void putOptAttr(String str, Object obj) {
        try {
            if (this.f17128W == null) {
                this.f17128W = new HashMap<>();
            }
            this.f17128W.put(str, obj);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void removeOptAttr(String str) {
        try {
            HashMap<String, Object> map = this.f17128W;
            if (map != null) {
                map.remove(str);
            }
        } catch (Exception unused) {
        }
    }

    public void setAMapErrorCode(String str, int i10) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int iAmapErrorCode2OpenErrorCode = Utils.amapErrorCode2OpenErrorCode(str, i10);
        this.f17147m = iAmapErrorCode2OpenErrorCode;
        this.f17148n = Utils.getLocErrorInfo(iAmapErrorCode2OpenErrorCode);
    }

    public void setAdCode(String str) {
        this.f17139e = str;
    }

    public void setAddress(String str) {
        this.f17140f = str;
    }

    @Override // android.location.Location
    public void setAltitude(double d10) {
        super.setAltitude(d10);
        this.f17153s = d10;
    }

    public void setAoiName(String str) {
        this.f17159y = str;
    }

    @Override // android.location.Location
    public void setBearing(float f10) {
        super.setBearing(f10);
        while (f10 < 0.0f) {
            f10 += 360.0f;
        }
        while (f10 >= 360.0f) {
            f10 -= 360.0f;
        }
        this.f17155u = f10;
    }

    @Override // android.location.Location
    public void setBearingAccuracyDegrees(float f10) {
        this.f17135b0 = f10;
    }

    public void setBuildingId(String str) {
        this.mPoiid = str;
    }

    public void setCity(String str) {
        this.f17134b = str;
    }

    public void setCityCode(String str) {
        this.f17138d = str;
    }

    public void setConScenario(int i10) {
        this.f17113H = i10;
    }

    public void setCoorCanUseInMap(boolean z10) {
        this.f17125T = z10;
    }

    public void setCoord(int i10) {
        this.f17110E = i10;
    }

    public void setCoordType(String str) {
        this.f17111F = str;
    }

    public void setCountry(String str) {
        this.f17142h = str;
    }

    public void setDescription(String str) {
        this.f17108C = str;
    }

    public void setDiagnosisType(int i10) {
        this.f17119N = i10;
    }

    public void setDim(boolean z10) {
        this.f17120O = z10;
    }

    public void setDistrict(String str) {
        this.f17136c = str;
    }

    public void setErrorCode(int i10) {
        if (this.f17147m != 0) {
            return;
        }
        this.f17148n = Utils.getLocErrorInfo(i10);
        this.f17147m = i10;
    }

    public void setErrorInfo(String str) {
        this.f17148n = str;
    }

    @Override // android.location.Location
    public void setExtras(Bundle bundle) {
        super.setExtras(bundle);
        this.f17156v = bundle == null ? null : new Bundle(bundle);
    }

    public void setFixLastLocation(boolean z10) {
        this.f17109D = z10;
    }

    public void setFloor(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = str.replace("F", "");
            try {
                Integer.parseInt(str);
            } catch (Throwable th) {
                CoreUtil.reportError(th, "AmapLoc", "setFloor");
                str = null;
            }
        }
        this.floor = str;
    }

    public void setFloorName(String str) {
        this.f17160z = str;
    }

    public void setGeoLanguage(String str) {
        this.f17130Y = str;
    }

    public void setGpsAccuracyStatus(int i10) {
        this.f17106A = i10;
    }

    public void setIod(int i10) {
        this.f17121P = i10;
    }

    public void setIodConfidence(int i10) {
        this.f17122Q = i10;
    }

    @Override // android.location.Location
    public void setLatitude(double d10) {
        this.f17151q = d10;
    }

    public void setLocationDetail(String str) {
        this.f17149o = str;
    }

    public void setLocationQualityReport(com.amap.api.location.a aVar) {
        if (aVar == null) {
            return;
        }
        this.f17137c0 = aVar;
    }

    public void setLocationTickTime(long j10) {
        this.f17117L = j10;
    }

    public void setLocationType(int i10) {
        this.f17150p = i10;
    }

    public void setLocationUtcTime(long j10) {
        this.f17116K = j10;
    }

    @Override // android.location.Location
    public void setLongitude(double d10) {
        this.f17152r = d10;
    }

    @Override // android.location.Location
    public void setMock(boolean z10) {
        this.f17107B = z10;
    }

    public void setNumber(String str) {
        this.f17145k = str;
    }

    public void setOffset(boolean z10) {
        this.f17146l = z10;
    }

    public void setOptAttrs(HashMap<String, Object> map) {
        this.f17128W = map;
    }

    public void setOptContent(String str) {
        this.f17127V = str;
    }

    public void setPoiName(String str) {
        this.f17141g = str;
    }

    public void setPriority(int i10) {
        this.f17126U = i10;
    }

    @Override // android.location.Location
    public void setProvider(String str) {
        super.setProvider(str);
        this.f17157w = str;
    }

    public void setProvince(String str) {
        this.f17132a = str;
    }

    public void setReversegeo(boolean z10) {
        this.f17129X = z10;
    }

    public void setRoad(String str) {
        this.f17143i = str;
    }

    public void setSatellites(int i10) {
        this.f17158x = i10;
    }

    public void setSemantics(String str) {
        this.f17123R = str;
    }

    public void setSource(String str) {
        this.f17118M = str;
    }

    @Override // android.location.Location
    public void setSpeed(float f10) {
        super.setSpeed(f10);
        this.f17154t = f10;
    }

    @Override // android.location.Location
    public void setSpeedAccuracyMetersPerSecond(float f10) {
        this.f17133a0 = f10;
    }

    public void setSpeedKmh(boolean z10) {
        this.f17124S = z10;
    }

    public void setStreet(String str) {
        this.f17144j = str;
    }

    public void setSubType(int i10) {
        this.f17115J = i10;
    }

    public void setTrustedLevel(int i10) {
        this.f17112G = i10;
    }

    public void setType(int i10) {
        this.f17114I = i10;
    }

    @Override // android.location.Location
    public void setVerticalAccuracyMeters(float f10) {
        this.f17131Z = f10;
    }

    public JSONObject toJson(int i10) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        return jSONObject;
                    }
                }
                jSONObject.put(Const.JSON_KEY_PROVIDER, getProvider());
                jSONObject.put(Const.JSON_KEY_LON, getLongitude());
                jSONObject.put(Const.JSON_KEY_LAT, getLatitude());
                jSONObject.put(Const.JSON_KEY_ACCURACY, getAccuracy());
                jSONObject.put(Const.JSON_KEY_ISOFFSET, this.f17146l);
                jSONObject.put("isFixLastLocation", this.f17109D);
                jSONObject.put(Const.JSON_KEY_COORD, this.f17110E);
                jSONObject.put("coordType", this.f17111F);
                return jSONObject;
            }
            try {
                jSONObject.put("altitude", getAltitude());
                jSONObject.put(Const.JSON_KEY_SPEED, getSpeed());
                jSONObject.put(Const.JSON_KEY_BEARING, getBearing());
            } catch (Throwable unused) {
            }
            jSONObject.put(Const.JSON_KEY_CITYCODE, this.f17138d);
            jSONObject.put(Const.JSON_KEY_ADCODE, this.f17139e);
            jSONObject.put("country", this.f17142h);
            jSONObject.put("province", this.f17132a);
            jSONObject.put("city", this.f17134b);
            jSONObject.put("district", this.f17136c);
            jSONObject.put(Const.JSON_KEY_ROAD, this.f17143i);
            jSONObject.put(Const.JSON_KEY_STREET, this.f17144j);
            jSONObject.put(Const.JSON_KEY_NUMBER, this.f17145k);
            jSONObject.put(Const.JSON_KEY_POINAME, this.f17141g);
            jSONObject.put("errorCode", this.f17147m);
            jSONObject.put(Const.JSON_KEY_ERRORINFO, this.f17148n);
            jSONObject.put(Const.JSON_KEY_LOCATIONTYPE, this.f17150p);
            jSONObject.put(Const.JSON_KEY_LOCATIONDETAIL, this.f17149o);
            jSONObject.put(Const.JSON_KEY_AOINAME, this.f17159y);
            jSONObject.put(Const.JSON_KEY_ADDRESS, this.f17140f);
            jSONObject.put(Const.JSON_KEY_POIID, this.mPoiid);
            jSONObject.put(Const.JSON_KEY_FLOOR, this.floor);
            jSONObject.put("floorName", this.f17160z);
            jSONObject.put("description", this.f17108C);
            jSONObject.put("time", getTime());
            jSONObject.put(Const.JSON_KEY_PROVIDER, getProvider());
            jSONObject.put(Const.JSON_KEY_LON, getLongitude());
            jSONObject.put(Const.JSON_KEY_LAT, getLatitude());
            jSONObject.put(Const.JSON_KEY_ACCURACY, getAccuracy());
            jSONObject.put(Const.JSON_KEY_ISOFFSET, this.f17146l);
            jSONObject.put("isFixLastLocation", this.f17109D);
            jSONObject.put(Const.JSON_KEY_COORD, this.f17110E);
            jSONObject.put("coordType", this.f17111F);
            return jSONObject;
        } catch (Throwable th) {
            CoreUtil.reportError(th, "AmapLoc", "toStr");
            return null;
        }
    }

    public String toStr() {
        return toStr(1);
    }

    @Override // android.location.Location
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            stringBuffer.append("latitude=" + this.f17151q + Const.STR_MART_WELL);
            stringBuffer.append("longitude=" + this.f17152r + Const.STR_MART_WELL);
            stringBuffer.append("province=" + this.f17132a + Const.STR_MART_WELL);
            stringBuffer.append("coord=" + this.f17110E + Const.STR_MART_WELL);
            stringBuffer.append("coordType=" + this.f17111F + Const.STR_MART_WELL);
            stringBuffer.append("city=" + this.f17134b + Const.STR_MART_WELL);
            stringBuffer.append("district=" + this.f17136c + Const.STR_MART_WELL);
            stringBuffer.append("cityCode=" + this.f17138d + Const.STR_MART_WELL);
            stringBuffer.append("adCode=" + this.f17139e + Const.STR_MART_WELL);
            stringBuffer.append("address=" + this.f17140f + Const.STR_MART_WELL);
            stringBuffer.append("country=" + this.f17142h + Const.STR_MART_WELL);
            stringBuffer.append("road=" + this.f17143i + Const.STR_MART_WELL);
            stringBuffer.append("poiName=" + this.f17141g + Const.STR_MART_WELL);
            stringBuffer.append("street=" + this.f17144j + Const.STR_MART_WELL);
            stringBuffer.append("streetNum=" + this.f17145k + Const.STR_MART_WELL);
            stringBuffer.append("aoiName=" + this.f17159y + Const.STR_MART_WELL);
            stringBuffer.append("poiid=" + this.mPoiid + Const.STR_MART_WELL);
            stringBuffer.append("floor=" + this.floor + Const.STR_MART_WELL);
            stringBuffer.append("floorName=" + this.f17160z + Const.STR_MART_WELL);
            stringBuffer.append("errorCode=" + this.f17147m + Const.STR_MART_WELL);
            stringBuffer.append("errorInfo=" + this.f17148n + Const.STR_MART_WELL);
            stringBuffer.append("locationDetail=" + this.f17149o + Const.STR_MART_WELL);
            stringBuffer.append("description=" + this.f17108C + Const.STR_MART_WELL);
            stringBuffer.append("locationType=" + this.f17150p + Const.STR_MART_WELL);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("conScenario=");
            sb2.append(this.f17113H);
            stringBuffer.append(sb2.toString());
            stringBuffer.append("mType=" + this.f17114I);
            stringBuffer.append("mSubType=" + this.f17115J);
            stringBuffer.append("mLocationUtcTime=" + this.f17116K);
            stringBuffer.append("mLocationTickTime=" + this.f17117L);
            stringBuffer.append("mSource=" + this.f17118M);
            stringBuffer.append("isReversegeo=" + this.f17129X);
            stringBuffer.append("geoLanguage=" + this.f17130Y);
            stringBuffer.append("mDiagnosisType=" + this.f17119N);
            stringBuffer.append("mDim=" + this.f17120O);
            stringBuffer.append("mIod=" + this.f17121P);
            stringBuffer.append("mIodConfidence=" + this.f17122Q);
            stringBuffer.append("mSemantics=" + this.f17123R);
            stringBuffer.append("mSpeedKmh=" + this.f17124S);
            stringBuffer.append("mCoorCanUseInMap=" + this.f17125T);
            stringBuffer.append("mPriority=" + this.f17126U);
            stringBuffer.append("mOptContent=" + this.f17127V);
        } catch (Throwable unused) {
        }
        return stringBuffer.toString();
    }

    @Override // android.location.Location, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        try {
            super.writeToParcel(parcel, i10);
            parcel.writeString(this.f17139e);
            parcel.writeString(this.f17140f);
            parcel.writeString(this.f17159y);
            parcel.writeString(this.mPoiid);
            parcel.writeString(this.f17134b);
            parcel.writeString(this.f17138d);
            parcel.writeString(this.f17142h);
            parcel.writeString(this.f17136c);
            parcel.writeInt(this.f17147m);
            parcel.writeString(this.f17148n);
            parcel.writeString(this.floor);
            parcel.writeString(this.f17160z);
            parcel.writeInt(this.f17109D ? 1 : 0);
            parcel.writeInt(this.f17146l ? 1 : 0);
            parcel.writeDouble(this.f17151q);
            parcel.writeString(this.f17149o);
            parcel.writeInt(this.f17150p);
            parcel.writeDouble(this.f17152r);
            parcel.writeInt(this.f17107B ? 1 : 0);
            parcel.writeString(this.f17145k);
            parcel.writeString(this.f17141g);
            parcel.writeString(this.f17132a);
            parcel.writeString(this.f17143i);
            parcel.writeInt(this.f17158x);
            parcel.writeInt(this.f17106A);
            parcel.writeString(this.f17144j);
            parcel.writeString(this.f17108C);
            parcel.writeString(this.f17111F);
            parcel.writeInt(this.f17110E);
            parcel.writeInt(this.f17112G);
            parcel.writeInt(this.f17113H);
            parcel.writeInt(this.f17114I);
            parcel.writeInt(this.f17115J);
            parcel.writeLong(this.f17116K);
            parcel.writeLong(this.f17117L);
            parcel.writeString(this.f17118M);
            parcel.writeString(this.f17130Y);
            parcel.writeInt(this.f17129X ? 1 : 0);
            parcel.writeInt(this.f17119N);
            parcel.writeInt(this.f17120O ? 1 : 0);
            parcel.writeInt(this.f17121P);
            parcel.writeInt(this.f17122Q);
            parcel.writeString(this.f17123R);
            parcel.writeInt(this.f17124S ? 1 : 0);
            parcel.writeInt(this.f17125T ? 1 : 0);
            parcel.writeInt(this.f17126U);
            parcel.writeString(this.f17127V);
        } catch (Throwable th) {
            CoreUtil.reportError(th, "AMapLocation", "writeToParcel");
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public AMapLocation m9clone() {
        try {
            super.clone();
        } catch (Throwable unused) {
        }
        AMapLocation aMapLocation = new AMapLocation(this);
        try {
            aMapLocation.setLatitude(this.f17151q);
            aMapLocation.setLongitude(this.f17152r);
            aMapLocation.setAdCode(this.f17139e);
            aMapLocation.setAddress(this.f17140f);
            aMapLocation.setAoiName(this.f17159y);
            aMapLocation.setBuildingId(this.mPoiid);
            aMapLocation.setCity(this.f17134b);
            aMapLocation.setCityCode(this.f17138d);
            aMapLocation.setCountry(this.f17142h);
            aMapLocation.setDistrict(this.f17136c);
            aMapLocation.setErrorCode(this.f17147m);
            aMapLocation.setErrorInfo(this.f17148n);
            aMapLocation.setFloor(this.floor);
            aMapLocation.setFloorName(this.f17160z);
            aMapLocation.setFixLastLocation(this.f17109D);
            aMapLocation.setOffset(this.f17146l);
            aMapLocation.setLocationDetail(this.f17149o);
            aMapLocation.setLocationType(this.f17150p);
            aMapLocation.setMock(this.f17107B);
            aMapLocation.setNumber(this.f17145k);
            aMapLocation.setPoiName(this.f17141g);
            aMapLocation.setProvince(this.f17132a);
            aMapLocation.setRoad(this.f17143i);
            aMapLocation.setSatellites(this.f17158x);
            aMapLocation.setGpsAccuracyStatus(this.f17106A);
            aMapLocation.setStreet(this.f17144j);
            aMapLocation.setDescription(this.f17108C);
            aMapLocation.setExtras(getExtras());
            com.amap.api.location.a aVar = this.f17137c0;
            if (aVar != null) {
                aMapLocation.setLocationQualityReport(aVar.clone());
            }
            aMapLocation.setCoord(this.f17110E);
            aMapLocation.setCoordType(this.f17111F);
            aMapLocation.setTrustedLevel(this.f17112G);
            aMapLocation.setConScenario(this.f17113H);
            aMapLocation.setType(this.f17114I);
            aMapLocation.setSubType(this.f17115J);
            aMapLocation.setLocationUtcTime(this.f17116K);
            aMapLocation.setLocationTickTime(this.f17117L);
            aMapLocation.setSource(this.f17118M);
            aMapLocation.setReversegeo(this.f17129X);
            aMapLocation.setGeoLanguage(this.f17130Y);
            aMapLocation.setDiagnosisType(this.f17119N);
            aMapLocation.setDim(this.f17120O);
            aMapLocation.setIod(this.f17121P);
            aMapLocation.setIodConfidence(this.f17122Q);
            aMapLocation.setSemantics(this.f17123R);
            aMapLocation.setSpeedKmh(this.f17124S);
            aMapLocation.setCoorCanUseInMap(this.f17125T);
            aMapLocation.setPriority(this.f17126U);
            aMapLocation.setOptContent(this.f17127V);
            aMapLocation.setOptAttrs(cloneOptAttrs());
        } catch (Throwable th) {
            CoreUtil.reportError(th, "AMapLocation", "clone");
        }
        return aMapLocation;
    }

    public void setCoord(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f17110E = -1;
        } else if (str.equals("0")) {
            this.f17110E = 0;
        } else if (str.equals("1")) {
            this.f17110E = 1;
        } else {
            this.f17110E = -1;
        }
        if (this.f17110E == 0) {
            this.f17111F = "WGS84";
        } else {
            this.f17111F = "GCJ02";
        }
    }

    public void setLocationType(AmapLocation amapLocation) {
        if (amapLocation.E()) {
            this.f17150p = 11;
        }
        if ("gps".equals(amapLocation.u())) {
            this.f17150p = 1;
        }
        if (Const.PROVIDER_INDOOR.equals(amapLocation.u())) {
            this.f17150p = 5;
        }
        if (amapLocation instanceof AmapLocationNetwork) {
            AmapLocationNetwork amapLocationNetwork = (AmapLocationNetwork) amapLocation;
            int iR = amapLocationNetwork.R();
            if (iR == 2) {
                this.f17150p = 2;
                return;
            }
            if (iR == 3) {
                this.f17150p = 4;
                return;
            }
            if (iR == 4 || iR == 5) {
                this.f17150p = 8;
                return;
            }
            if (iR == 1) {
                if ("#-5#-1#1#2#14#24#".contains(Const.STR_MART_WELL + amapLocationNetwork.X() + Const.STR_MART_WELL)) {
                    this.f17150p = 5;
                } else {
                    this.f17150p = 6;
                }
            }
        }
    }

    public String toStr(int i10) {
        JSONObject json;
        try {
            json = toJson(i10);
        } catch (Throwable th) {
            CoreUtil.reportError(th, "AMapLocation", "toStr part2");
            json = null;
        }
        if (json == null) {
            return null;
        }
        return json.toString();
    }

    public AMapLocation(Location location) {
        super(location);
        this.f17132a = "";
        this.f17134b = "";
        this.f17136c = "";
        this.f17138d = "";
        this.f17139e = "";
        this.f17140f = "";
        this.f17141g = "";
        this.f17142h = "";
        this.f17143i = "";
        this.f17144j = "";
        this.f17145k = "";
        this.f17146l = true;
        this.f17147m = 0;
        this.f17148n = "success";
        this.f17149o = "";
        this.f17150p = 0;
        this.f17151q = 0.0d;
        this.f17152r = 0.0d;
        this.f17153s = 0.0d;
        this.f17154t = 0.0f;
        this.f17155u = 0.0f;
        this.f17156v = null;
        this.f17158x = 0;
        this.f17159y = "";
        this.mPoiid = "";
        this.floor = "";
        this.f17160z = "";
        this.f17106A = -1;
        this.f17107B = false;
        this.f17108C = "";
        this.f17109D = false;
        this.f17110E = -1;
        this.f17111F = "GCJ02";
        this.f17112G = 1;
        this.f17121P = -1;
        this.f17122Q = -1;
        this.f17129X = false;
        this.f17130Y = String.valueOf(AMapLocationClientOption.GeoLanguage.DEFAULT);
        this.f17137c0 = new com.amap.api.location.a();
        this.f17151q = location.getLatitude();
        this.f17152r = location.getLongitude();
        this.f17153s = location.getAltitude();
        this.f17155u = location.getBearing();
        this.f17154t = location.getSpeed();
        this.f17157w = location.getProvider();
        this.f17156v = location.getExtras() != null ? new Bundle(location.getExtras()) : null;
    }

    public AMapLocation(AmapLocation amapLocation) {
        super(amapLocation.u());
        this.f17132a = "";
        this.f17134b = "";
        this.f17136c = "";
        this.f17138d = "";
        this.f17139e = "";
        this.f17140f = "";
        this.f17141g = "";
        this.f17142h = "";
        this.f17143i = "";
        this.f17144j = "";
        this.f17145k = "";
        this.f17146l = true;
        this.f17147m = 0;
        this.f17148n = "success";
        this.f17149o = "";
        this.f17150p = 0;
        this.f17151q = 0.0d;
        this.f17152r = 0.0d;
        this.f17153s = 0.0d;
        this.f17154t = 0.0f;
        this.f17155u = 0.0f;
        this.f17156v = null;
        this.f17158x = 0;
        this.f17159y = "";
        this.mPoiid = "";
        this.floor = "";
        this.f17160z = "";
        this.f17106A = -1;
        this.f17107B = false;
        this.f17108C = "";
        this.f17109D = false;
        this.f17110E = -1;
        this.f17111F = "GCJ02";
        this.f17112G = 1;
        this.f17121P = -1;
        this.f17122Q = -1;
        this.f17129X = false;
        this.f17130Y = String.valueOf(AMapLocationClientOption.GeoLanguage.DEFAULT);
        this.f17137c0 = new com.amap.api.location.a();
        setTime(amapLocation.m());
        setLatitude(amapLocation.k());
        setLongitude(amapLocation.n());
        setAltitude(amapLocation.c());
        setSpeed(amapLocation.x());
        setBearing(amapLocation.d());
        setAccuracy(amapLocation.b());
        this.f17131Z = amapLocation.C();
        this.f17133a0 = amapLocation.y();
        this.f17135b0 = amapLocation.e();
        this.f17114I = amapLocation.A();
        this.f17115J = amapLocation.z();
        this.f17116K = amapLocation.m();
        this.f17117L = amapLocation.l();
        this.f17118M = amapLocation.w();
        this.f17119N = amapLocation.f();
        this.f17120O = amapLocation.E();
        this.f17121P = amapLocation.i();
        this.f17122Q = amapLocation.j();
        this.f17123R = amapLocation.v();
        this.f17124S = amapLocation.F();
        this.f17125T = amapLocation.D();
        this.f17126U = amapLocation.t();
        this.f17127V = amapLocation.q();
        this.f17151q = amapLocation.k();
        this.f17152r = amapLocation.n();
        this.f17153s = amapLocation.c();
        this.f17155u = amapLocation.d();
        this.f17154t = amapLocation.x();
        this.f17157w = amapLocation.u();
        this.floor = String.valueOf(amapLocation.g());
        this.f17160z = amapLocation.h();
        this.mPoiid = amapLocation.s();
        this.f17128W = amapLocation.a();
    }

    public AMapLocation(AmapLocationNetwork amapLocationNetwork) {
        this((AmapLocation) amapLocationNetwork);
        this.f17110E = amapLocationNetwork.N();
        this.f17142h = amapLocationNetwork.O();
        this.f17132a = amapLocationNetwork.V();
        this.f17134b = amapLocationNetwork.L();
        this.f17136c = amapLocationNetwork.Q();
        this.f17138d = amapLocationNetwork.M();
        this.f17139e = amapLocationNetwork.G();
        this.f17144j = amapLocationNetwork.Z();
        this.f17145k = amapLocationNetwork.T();
        if (!TextUtils.isEmpty(amapLocationNetwork.U())) {
            this.f17108C = "在" + amapLocationNetwork.U() + "附近";
        }
        this.f17140f = amapLocationNetwork.P();
        this.f17143i = amapLocationNetwork.Y();
        this.f17141g = amapLocationNetwork.U();
        this.f17159y = amapLocationNetwork.H();
    }
}
