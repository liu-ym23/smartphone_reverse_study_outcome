package com.amap.api.fence;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.DPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class GeoFence implements Parcelable {
    public static final int ADDGEOFENCE_SUCCESS = 0;
    public static final String BUNDLE_KEY_CUSTOMID = "customId";
    public static final String BUNDLE_KEY_FENCE = "fence";
    public static final String BUNDLE_KEY_FENCEID = "fenceid";
    public static final String BUNDLE_KEY_FENCESTATUS = "event";
    public static final String BUNDLE_KEY_LOCERRORCODE = "location_errorcode";
    public static final Parcelable.Creator<GeoFence> CREATOR = null;
    public static final int ERROR_CODE_EXISTS = 17;
    public static final int ERROR_CODE_FAILURE_AUTH = 7;
    public static final int ERROR_CODE_FAILURE_CONNECTION = 4;
    public static final int ERROR_CODE_FAILURE_PARSER = 5;
    public static final int ERROR_CODE_INVALID_PARAMETER = 1;
    public static final int ERROR_CODE_UNKNOWN = 8;
    public static final int ERROR_NO_VALIDFENCE = 16;
    public static final int STATUS_IN = 1;
    public static final int STATUS_LOCFAIL = 4;
    public static final int STATUS_OUT = 2;
    public static final int STATUS_STAYED = 3;
    public static final int STATUS_UNKNOWN = 0;
    public static final int TYPE_AMAPPOI = 2;
    public static final int TYPE_DISTRICT = 3;
    public static final int TYPE_POLYGON = 1;
    public static final int TYPE_ROUND = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f26659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f26660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f26661c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private PendingIntent f26662d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f26663e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private PoiItem f26664f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<DistrictItem> f26665g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<List<DPoint>> f26666h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f26667i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f26668j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f26669k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f26670l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f26671m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private DPoint f26672n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f26673o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f26674p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f26675q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private AMapLocation f26676r;

    static {
        CREATOR = new AnonymousClass1();
    }

    public GeoFence() {
        this.f26662d = null;
        this.f26663e = 0;
        this.f26664f = null;
        this.f26665g = null;
        this.f26667i = 0.0f;
        this.f26668j = -1;
        this.f26669k = 1;
        this.f26670l = 0.0f;
        this.f26671m = 0.0f;
        this.f26672n = null;
        this.f26673o = 0;
        this.f26674p = -1;
        this.f26675q = true;
        this.f26676r = null;
    }

    public GeoFence(Parcel r100) {
        this.f26662d = null;
        boolean r101 = false;
        this.f26663e = 0;
        this.f26664f = null;
        this.f26665g = null;
        this.f26667i = 0.0f;
        this.f26668j = -1;
        this.f26669k = 1;
        this.f26670l = 0.0f;
        this.f26671m = 0.0f;
        this.f26672n = null;
        this.f26673o = 0;
        this.f26674p = -1;
        this.f26675q = true;
        this.f26676r = null;
        this.f26659a = r100.readString();
        this.f26660b = r100.readString();
        this.f26661c = r100.readString();
        this.f26662d = (PendingIntent) r100.readParcelable(PendingIntent.class.getClassLoader());
        this.f26663e = r100.readInt();
        this.f26664f = (PoiItem) r100.readParcelable(PoiItem.class.getClassLoader());
        this.f26665g = r100.createTypedArrayList(DistrictItem.CREATOR);
        this.f26667i = r100.readFloat();
        this.f26668j = r100.readLong();
        this.f26669k = r100.readInt();
        this.f26670l = r100.readFloat();
        this.f26671m = r100.readFloat();
        this.f26672n = (DPoint) r100.readParcelable(DPoint.class.getClassLoader());
        this.f26673o = r100.readInt();
        this.f26674p = r100.readLong();
        int r102 = r100.readInt();
        if (r102 == 0) goto L8;
        this.f26666h = new ArrayList();
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L8;
        this.f26666h.add(r100.createTypedArrayList(DPoint.CREATOR));
        r103 = r103 + 1;
    L8:
        if (r100.readByte() == 0) goto L10;
        r101 = true;
    L10:
        this.f26675q = r101;
        this.f26676r = (AMapLocation) r100.readParcelable(AMapLocation.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof GeoFence) == true) goto L5;
        return false;
    L5:
        GeoFence r101 = (GeoFence) r100;
        if (TextUtils.isEmpty(this.f26660b) == false) goto L11;
        if (TextUtils.isEmpty(r101.f26660b) == true) goto L13;
        return false;
    L13:
        DPoint r102 = this.f26672n;
        if (r102 != null) goto L19;
        if (r101.f26672n == null) goto L22;
        return false;
    L22:
        if (this.f26667i == r101.f26667i) goto L24;
        return false;
    L24:
        List<List<DPoint>> r103 = this.f26666h;
        List<List<DPoint>> r104 = r101.f26666h;
        if (r103 != null) goto L29;
        if (r104 == null) goto L31;
        return false;
    L31:
        return true;
    L29:
        if (r103.equals(r104) == true) goto L33;
        return false;
    L33:
        return true;
    L19:
        if (r102.equals(r101.f26672n) == true) goto L22;
        return false;
    L11:
        if (this.f26660b.equals(r101.f26660b) == true) goto L13;
        return false;
    }

    public int getActivatesAction() {
        return this.f26669k;
    }

    public DPoint getCenter() {
        return this.f26672n;
    }

    public AMapLocation getCurrentLocation() {
        return this.f26676r;
    }

    public String getCustomId() {
        return this.f26660b;
    }

    public List<DistrictItem> getDistrictItemList() {
        return this.f26665g;
    }

    public long getEnterTime() {
        return this.f26674p;
    }

    public long getExpiration() {
        return this.f26668j;
    }

    public String getFenceId() {
        return this.f26659a;
    }

    public float getMaxDis2Center() {
        return this.f26671m;
    }

    public float getMinDis2Center() {
        return this.f26670l;
    }

    public PendingIntent getPendingIntent() {
        return this.f26662d;
    }

    public String getPendingIntentAction() {
        return this.f26661c;
    }

    public PoiItem getPoiItem() {
        return this.f26664f;
    }

    public List<List<DPoint>> getPointList() {
        return this.f26666h;
    }

    public float getRadius() {
        return this.f26667i;
    }

    public int getStatus() {
        return this.f26673o;
    }

    public int getType() {
        return this.f26663e;
    }

    public int hashCode() {
        return ((this.f26660b.hashCode() + this.f26666h.hashCode()) + this.f26672n.hashCode()) + ((int) (this.f26667i * 100.0f));
    }

    public boolean isAble() {
        return this.f26675q;
    }

    public void setAble(boolean r100) {
        this.f26675q = r100;
    }

    public void setActivatesAction(int r100) {
        this.f26669k = r100;
    }

    public void setCenter(DPoint r100) {
        this.f26672n = r100;
    }

    public void setCurrentLocation(AMapLocation r100) {
        this.f26676r = r100.clone();
    }

    public void setCustomId(String r100) {
        this.f26660b = r100;
    }

    public void setDistrictItemList(List<DistrictItem> r100) {
        this.f26665g = r100;
    }

    public void setEnterTime(long r100) {
        this.f26674p = r100;
    }

    public void setFenceId(String r100) {
        this.f26659a = r100;
    }

    public void setMaxDis2Center(float r100) {
        this.f26671m = r100;
    }

    public void setMinDis2Center(float r100) {
        this.f26670l = r100;
    }

    public void setPendingIntent(PendingIntent r100) {
        this.f26662d = r100;
    }

    public void setPendingIntentAction(String r100) {
        this.f26661c = r100;
    }

    public void setPoiItem(PoiItem r100) {
        this.f26664f = r100;
    }

    public void setPointList(List<List<DPoint>> r100) {
        this.f26666h = r100;
    }

    public void setRadius(float r100) {
        this.f26667i = r100;
    }

    public void setStatus(int r100) {
        this.f26673o = r100;
    }

    public void setType(int r100) {
        this.f26663e = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f26659a);
        r100.writeString(this.f26660b);
        r100.writeString(this.f26661c);
        r100.writeParcelable(this.f26662d, r101);
        r100.writeInt(this.f26663e);
        r100.writeParcelable(this.f26664f, r101);
        r100.writeTypedList(this.f26665g);
        r100.writeFloat(this.f26667i);
        r100.writeLong(this.f26668j);
        r100.writeInt(this.f26669k);
        r100.writeFloat(this.f26670l);
        r100.writeFloat(this.f26671m);
        r100.writeParcelable(this.f26672n, r101);
        r100.writeInt(this.f26673o);
        r100.writeLong(this.f26674p);
        List<List<DPoint>> r102 = this.f26666h;
        if (r102 != null) goto L5;
    L10:
        r100.writeByte(this.f26675q ? 1 : 0);
        r100.writeParcelable(this.f26676r, r101);
        return;
    L5:
        if (r102.isEmpty() == true) goto L10;
        r100.writeInt(this.f26666h.size());
        Iterator<List<DPoint>> r103 = this.f26666h.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        r100.writeTypedList(r103.next());
        goto L8
    }

    public void setExpiration(long r100) {
        if (r100 >= 0) goto L7;
        long r101 = -1;
    L5:
        this.f26668j = r101;
        return;
    L7:
        r101 = r100 + SystemClock.elapsedRealtime();
        goto L5
    }
}
