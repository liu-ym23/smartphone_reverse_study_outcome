package com.amap.api.fence;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.DPoint;
import com.autonavi.aps.amapapi.utils.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class GeoFence implements Parcelable {
    public static final int ADDGEOFENCE_SUCCESS = 0;
    public static final String BUNDLE_KEY_CUSTOMID = "customId";
    public static final String BUNDLE_KEY_FENCE = "fence";
    public static final String BUNDLE_KEY_FENCEID = "fenceid";
    public static final String BUNDLE_KEY_FENCESTATUS = "event";
    public static final String BUNDLE_KEY_LOCERRORCODE = "location_errorcode";
    public static final Parcelable.Creator<GeoFence> CREATOR = new a();
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

    /* renamed from: a, reason: collision with root package name */
    private String f17077a;

    /* renamed from: b, reason: collision with root package name */
    private String f17078b;

    /* renamed from: c, reason: collision with root package name */
    private String f17079c;

    /* renamed from: d, reason: collision with root package name */
    private PendingIntent f17080d;

    /* renamed from: e, reason: collision with root package name */
    private int f17081e;

    /* renamed from: f, reason: collision with root package name */
    private PoiItem f17082f;

    /* renamed from: g, reason: collision with root package name */
    private List<DistrictItem> f17083g;

    /* renamed from: h, reason: collision with root package name */
    private List<List<DPoint>> f17084h;

    /* renamed from: i, reason: collision with root package name */
    private float f17085i;

    /* renamed from: j, reason: collision with root package name */
    private long f17086j;

    /* renamed from: k, reason: collision with root package name */
    private int f17087k;

    /* renamed from: l, reason: collision with root package name */
    private float f17088l;

    /* renamed from: m, reason: collision with root package name */
    private float f17089m;

    /* renamed from: n, reason: collision with root package name */
    private DPoint f17090n;

    /* renamed from: o, reason: collision with root package name */
    private int f17091o;

    /* renamed from: p, reason: collision with root package name */
    private long f17092p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f17093q;

    /* renamed from: r, reason: collision with root package name */
    private AMapLocation f17094r;

    public static class a implements Parcelable.Creator<GeoFence> {
        @Override // android.os.Parcelable.Creator
        public GeoFence createFromParcel(Parcel parcel) {
            return new GeoFence(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public GeoFence[] newArray(int i10) {
            return new GeoFence[i10];
        }
    }

    public GeoFence() {
        this.f17080d = null;
        this.f17081e = 0;
        this.f17082f = null;
        this.f17083g = null;
        this.f17085i = 0.0f;
        this.f17086j = -1L;
        this.f17087k = 1;
        this.f17088l = 0.0f;
        this.f17089m = 0.0f;
        this.f17090n = null;
        this.f17091o = 0;
        this.f17092p = -1L;
        this.f17093q = true;
        this.f17094r = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GeoFence)) {
            return false;
        }
        GeoFence geoFence = (GeoFence) obj;
        if (TextUtils.isEmpty(this.f17078b)) {
            if (!TextUtils.isEmpty(geoFence.f17078b)) {
                return false;
            }
        } else if (!this.f17078b.equals(geoFence.f17078b)) {
            return false;
        }
        DPoint dPoint = this.f17090n;
        if (dPoint == null) {
            if (geoFence.f17090n != null) {
                return false;
            }
        } else if (!dPoint.equals(geoFence.f17090n)) {
            return false;
        }
        if (this.f17085i != geoFence.f17085i) {
            return false;
        }
        List<List<DPoint>> list = this.f17084h;
        return list == null ? geoFence.f17084h == null : list.equals(geoFence.f17084h);
    }

    public int getActivatesAction() {
        return this.f17087k;
    }

    public DPoint getCenter() {
        return this.f17090n;
    }

    public AMapLocation getCurrentLocation() {
        return this.f17094r;
    }

    public String getCustomId() {
        return this.f17078b;
    }

    public List<DistrictItem> getDistrictItemList() {
        return this.f17083g;
    }

    public long getEnterTime() {
        return this.f17092p;
    }

    public long getExpiration() {
        return this.f17086j;
    }

    public String getFenceId() {
        return this.f17077a;
    }

    public float getMaxDis2Center() {
        return this.f17089m;
    }

    public float getMinDis2Center() {
        return this.f17088l;
    }

    public PendingIntent getPendingIntent() {
        return this.f17080d;
    }

    public String getPendingIntentAction() {
        return this.f17079c;
    }

    public PoiItem getPoiItem() {
        return this.f17082f;
    }

    public List<List<DPoint>> getPointList() {
        return this.f17084h;
    }

    public float getRadius() {
        return this.f17085i;
    }

    public int getStatus() {
        return this.f17091o;
    }

    public int getType() {
        return this.f17081e;
    }

    public int hashCode() {
        return this.f17078b.hashCode() + this.f17084h.hashCode() + this.f17090n.hashCode() + ((int) (this.f17085i * 100.0f));
    }

    public boolean isAble() {
        return this.f17093q;
    }

    public void setAble(boolean z10) {
        this.f17093q = z10;
    }

    public void setActivatesAction(int i10) {
        this.f17087k = i10;
    }

    public void setCenter(DPoint dPoint) {
        this.f17090n = dPoint;
    }

    public void setCurrentLocation(AMapLocation aMapLocation) {
        this.f17094r = aMapLocation.m9clone();
    }

    public void setCustomId(String str) {
        this.f17078b = str;
    }

    public void setDistrictItemList(List<DistrictItem> list) {
        this.f17083g = list;
    }

    public void setEnterTime(long j10) {
        this.f17092p = j10;
    }

    public void setExpiration(long j10) {
        if (j10 < 0) {
            this.f17086j = -1L;
        } else {
            this.f17086j = j10 + Utils.getTimeBoot();
        }
    }

    public void setFenceId(String str) {
        this.f17077a = str;
    }

    public void setMaxDis2Center(float f10) {
        this.f17089m = f10;
    }

    public void setMinDis2Center(float f10) {
        this.f17088l = f10;
    }

    public void setPendingIntent(PendingIntent pendingIntent) {
        this.f17080d = pendingIntent;
    }

    public void setPendingIntentAction(String str) {
        this.f17079c = str;
    }

    public void setPoiItem(PoiItem poiItem) {
        this.f17082f = poiItem;
    }

    public void setPointList(List<List<DPoint>> list) {
        this.f17084h = list;
    }

    public void setRadius(float f10) {
        this.f17085i = f10;
    }

    public void setStatus(int i10) {
        this.f17091o = i10;
    }

    public void setType(int i10) {
        this.f17081e = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17077a);
        parcel.writeString(this.f17078b);
        parcel.writeString(this.f17079c);
        parcel.writeParcelable(this.f17080d, i10);
        parcel.writeInt(this.f17081e);
        parcel.writeParcelable(this.f17082f, i10);
        parcel.writeTypedList(this.f17083g);
        parcel.writeFloat(this.f17085i);
        parcel.writeLong(this.f17086j);
        parcel.writeInt(this.f17087k);
        parcel.writeFloat(this.f17088l);
        parcel.writeFloat(this.f17089m);
        parcel.writeParcelable(this.f17090n, i10);
        parcel.writeInt(this.f17091o);
        parcel.writeLong(this.f17092p);
        List<List<DPoint>> list = this.f17084h;
        if (list != null && !list.isEmpty()) {
            parcel.writeInt(this.f17084h.size());
            Iterator<List<DPoint>> it = this.f17084h.iterator();
            while (it.hasNext()) {
                parcel.writeTypedList(it.next());
            }
        }
        parcel.writeByte(this.f17093q ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.f17094r, i10);
    }

    public GeoFence(Parcel parcel) {
        this.f17080d = null;
        this.f17081e = 0;
        this.f17082f = null;
        this.f17083g = null;
        this.f17085i = 0.0f;
        this.f17086j = -1L;
        this.f17087k = 1;
        this.f17088l = 0.0f;
        this.f17089m = 0.0f;
        this.f17090n = null;
        this.f17091o = 0;
        this.f17092p = -1L;
        this.f17093q = true;
        this.f17094r = null;
        this.f17077a = parcel.readString();
        this.f17078b = parcel.readString();
        this.f17079c = parcel.readString();
        this.f17080d = (PendingIntent) parcel.readParcelable(PendingIntent.class.getClassLoader());
        this.f17081e = parcel.readInt();
        this.f17082f = (PoiItem) parcel.readParcelable(PoiItem.class.getClassLoader());
        this.f17083g = parcel.createTypedArrayList(DistrictItem.CREATOR);
        this.f17085i = parcel.readFloat();
        this.f17086j = parcel.readLong();
        this.f17087k = parcel.readInt();
        this.f17088l = parcel.readFloat();
        this.f17089m = parcel.readFloat();
        this.f17090n = (DPoint) parcel.readParcelable(DPoint.class.getClassLoader());
        this.f17091o = parcel.readInt();
        this.f17092p = parcel.readLong();
        int i10 = parcel.readInt();
        if (i10 != 0) {
            this.f17084h = new ArrayList();
            for (int i11 = 0; i11 < i10; i11++) {
                this.f17084h.add(parcel.createTypedArrayList(DPoint.CREATOR));
            }
        }
        this.f17093q = parcel.readByte() != 0;
        this.f17094r = (AMapLocation) parcel.readParcelable(AMapLocation.class.getClassLoader());
    }
}
