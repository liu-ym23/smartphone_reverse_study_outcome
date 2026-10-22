package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.poisearch.IndoorData;
import com.amap.api.services.poisearch.Photo;
import com.amap.api.services.poisearch.PoiItemExtension;
import com.amap.api.services.poisearch.SubPoiItem;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class PoiItem implements Parcelable {
    public static final Parcelable.Creator<PoiItem> CREATOR = new a();

    /* renamed from: A, reason: collision with root package name */
    private String f17344A;

    /* renamed from: B, reason: collision with root package name */
    private String f17345B;

    /* renamed from: a, reason: collision with root package name */
    private String f17346a;

    /* renamed from: b, reason: collision with root package name */
    private String f17347b;

    /* renamed from: c, reason: collision with root package name */
    private String f17348c;

    /* renamed from: d, reason: collision with root package name */
    private String f17349d;

    /* renamed from: e, reason: collision with root package name */
    private String f17350e;

    /* renamed from: f, reason: collision with root package name */
    private int f17351f;

    /* renamed from: g, reason: collision with root package name */
    private final LatLonPoint f17352g;

    /* renamed from: h, reason: collision with root package name */
    private final String f17353h;

    /* renamed from: i, reason: collision with root package name */
    private final String f17354i;

    /* renamed from: j, reason: collision with root package name */
    private LatLonPoint f17355j;

    /* renamed from: k, reason: collision with root package name */
    private LatLonPoint f17356k;

    /* renamed from: l, reason: collision with root package name */
    private String f17357l;

    /* renamed from: m, reason: collision with root package name */
    private String f17358m;

    /* renamed from: n, reason: collision with root package name */
    private String f17359n;

    /* renamed from: o, reason: collision with root package name */
    private String f17360o;

    /* renamed from: p, reason: collision with root package name */
    private String f17361p;

    /* renamed from: q, reason: collision with root package name */
    private String f17362q;

    /* renamed from: r, reason: collision with root package name */
    private String f17363r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f17364s;

    /* renamed from: t, reason: collision with root package name */
    private IndoorData f17365t;

    /* renamed from: u, reason: collision with root package name */
    private String f17366u;

    /* renamed from: v, reason: collision with root package name */
    private String f17367v;

    /* renamed from: w, reason: collision with root package name */
    private String f17368w;

    /* renamed from: x, reason: collision with root package name */
    private List<SubPoiItem> f17369x;

    /* renamed from: y, reason: collision with root package name */
    private List<Photo> f17370y;

    /* renamed from: z, reason: collision with root package name */
    private PoiItemExtension f17371z;

    public static class a implements Parcelable.Creator<PoiItem> {
        @Override // android.os.Parcelable.Creator
        public PoiItem createFromParcel(Parcel parcel) {
            return new PoiItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public PoiItem[] newArray(int i10) {
            return new PoiItem[i10];
        }
    }

    public PoiItem(String str, LatLonPoint latLonPoint, String str2, String str3) {
        this.f17350e = "";
        this.f17351f = -1;
        this.f17369x = new ArrayList();
        this.f17370y = new ArrayList();
        this.f17346a = str;
        this.f17352g = latLonPoint;
        this.f17353h = str2;
        this.f17354i = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PoiItem poiItem = (PoiItem) obj;
        String str = this.f17346a;
        if (str == null) {
            if (poiItem.f17346a != null) {
                return false;
            }
        } else if (!str.equals(poiItem.f17346a)) {
            return false;
        }
        return true;
    }

    public String getAdCode() {
        return this.f17348c;
    }

    public String getAdName() {
        return this.f17363r;
    }

    public String getBusinessArea() {
        return this.f17367v;
    }

    public String getCityCode() {
        return this.f17349d;
    }

    public String getCityName() {
        return this.f17362q;
    }

    public String getDirection() {
        return this.f17360o;
    }

    public int getDistance() {
        return this.f17351f;
    }

    public String getEmail() {
        return this.f17359n;
    }

    public LatLonPoint getEnter() {
        return this.f17355j;
    }

    public LatLonPoint getExit() {
        return this.f17356k;
    }

    public IndoorData getIndoorData() {
        return this.f17365t;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f17352g;
    }

    public String getParkingType() {
        return this.f17368w;
    }

    public List<Photo> getPhotos() {
        return this.f17370y;
    }

    public PoiItemExtension getPoiExtension() {
        return this.f17371z;
    }

    public String getPoiId() {
        return this.f17346a;
    }

    public String getPostcode() {
        return this.f17358m;
    }

    public String getProvinceCode() {
        return this.f17366u;
    }

    public String getProvinceName() {
        return this.f17361p;
    }

    public String getShopID() {
        return this.f17345B;
    }

    public String getSnippet() {
        return this.f17354i;
    }

    public List<SubPoiItem> getSubPois() {
        return this.f17369x;
    }

    public String getTel() {
        return this.f17347b;
    }

    public String getTitle() {
        return this.f17353h;
    }

    public String getTypeCode() {
        return this.f17344A;
    }

    public String getTypeDes() {
        return this.f17350e;
    }

    public String getWebsite() {
        return this.f17357l;
    }

    public int hashCode() {
        String str = this.f17346a;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public boolean isIndoorMap() {
        return this.f17364s;
    }

    public void setAdCode(String str) {
        this.f17348c = str;
    }

    public void setAdName(String str) {
        this.f17363r = str;
    }

    public void setBusinessArea(String str) {
        this.f17367v = str;
    }

    public void setCityCode(String str) {
        this.f17349d = str;
    }

    public void setCityName(String str) {
        this.f17362q = str;
    }

    public void setDirection(String str) {
        this.f17360o = str;
    }

    public void setDistance(int i10) {
        this.f17351f = i10;
    }

    public void setEmail(String str) {
        this.f17359n = str;
    }

    public void setEnter(LatLonPoint latLonPoint) {
        this.f17355j = latLonPoint;
    }

    public void setExit(LatLonPoint latLonPoint) {
        this.f17356k = latLonPoint;
    }

    public void setIndoorDate(IndoorData indoorData) {
        this.f17365t = indoorData;
    }

    public void setIndoorMap(boolean z10) {
        this.f17364s = z10;
    }

    public void setParkingType(String str) {
        this.f17368w = str;
    }

    public void setPhotos(List<Photo> list) {
        this.f17370y = list;
    }

    public void setPoiExtension(PoiItemExtension poiItemExtension) {
        this.f17371z = poiItemExtension;
    }

    public void setPostcode(String str) {
        this.f17358m = str;
    }

    public void setProvinceCode(String str) {
        this.f17366u = str;
    }

    public void setProvinceName(String str) {
        this.f17361p = str;
    }

    public void setShopID(String str) {
        this.f17345B = str;
    }

    public void setSubPois(List<SubPoiItem> list) {
        this.f17369x = list;
    }

    public void setTel(String str) {
        this.f17347b = str;
    }

    public void setTypeCode(String str) {
        this.f17344A = str;
    }

    public void setTypeDes(String str) {
        this.f17350e = str;
    }

    public void setWebsite(String str) {
        this.f17357l = str;
    }

    public String toString() {
        return this.f17353h;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17346a);
        parcel.writeString(this.f17348c);
        parcel.writeString(this.f17347b);
        parcel.writeString(this.f17350e);
        parcel.writeInt(this.f17351f);
        parcel.writeValue(this.f17352g);
        parcel.writeString(this.f17353h);
        parcel.writeString(this.f17354i);
        parcel.writeString(this.f17349d);
        parcel.writeValue(this.f17355j);
        parcel.writeValue(this.f17356k);
        parcel.writeString(this.f17357l);
        parcel.writeString(this.f17358m);
        parcel.writeString(this.f17359n);
        parcel.writeBooleanArray(new boolean[]{this.f17364s});
        parcel.writeString(this.f17360o);
        parcel.writeString(this.f17361p);
        parcel.writeString(this.f17362q);
        parcel.writeString(this.f17363r);
        parcel.writeString(this.f17366u);
        parcel.writeString(this.f17367v);
        parcel.writeString(this.f17368w);
        parcel.writeList(this.f17369x);
        parcel.writeValue(this.f17365t);
        parcel.writeTypedList(this.f17370y);
        parcel.writeParcelable(this.f17371z, i10);
        parcel.writeString(this.f17344A);
        parcel.writeString(this.f17345B);
    }

    public PoiItem(Parcel parcel) {
        this.f17350e = "";
        this.f17351f = -1;
        this.f17369x = new ArrayList();
        this.f17370y = new ArrayList();
        this.f17346a = parcel.readString();
        this.f17348c = parcel.readString();
        this.f17347b = parcel.readString();
        this.f17350e = parcel.readString();
        this.f17351f = parcel.readInt();
        this.f17352g = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f17353h = parcel.readString();
        this.f17354i = parcel.readString();
        this.f17349d = parcel.readString();
        this.f17355j = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f17356k = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f17357l = parcel.readString();
        this.f17358m = parcel.readString();
        this.f17359n = parcel.readString();
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.f17364s = zArr[0];
        this.f17360o = parcel.readString();
        this.f17361p = parcel.readString();
        this.f17362q = parcel.readString();
        this.f17363r = parcel.readString();
        this.f17366u = parcel.readString();
        this.f17367v = parcel.readString();
        this.f17368w = parcel.readString();
        this.f17369x = parcel.readArrayList(SubPoiItem.class.getClassLoader());
        this.f17365t = (IndoorData) parcel.readValue(IndoorData.class.getClassLoader());
        this.f17370y = parcel.createTypedArrayList(Photo.CREATOR);
        this.f17371z = (PoiItemExtension) parcel.readParcelable(PoiItemExtension.class.getClassLoader());
        this.f17344A = parcel.readString();
        this.f17345B = parcel.readString();
    }
}
