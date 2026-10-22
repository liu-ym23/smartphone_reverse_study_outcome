package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.poisearch.Business;
import com.amap.api.services.poisearch.IndoorDataV2;
import com.amap.api.services.poisearch.Photo;
import com.amap.api.services.poisearch.PoiNavi;
import com.amap.api.services.poisearch.SubPoiItemV2;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class PoiItemV2 implements Parcelable {
    public static final Parcelable.Creator<PoiItemV2> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f17372a;

    /* renamed from: b, reason: collision with root package name */
    private String f17373b;

    /* renamed from: c, reason: collision with root package name */
    private String f17374c;

    /* renamed from: d, reason: collision with root package name */
    private String f17375d;

    /* renamed from: e, reason: collision with root package name */
    private final LatLonPoint f17376e;

    /* renamed from: f, reason: collision with root package name */
    private final String f17377f;

    /* renamed from: g, reason: collision with root package name */
    private final String f17378g;

    /* renamed from: h, reason: collision with root package name */
    private String f17379h;

    /* renamed from: i, reason: collision with root package name */
    private String f17380i;

    /* renamed from: j, reason: collision with root package name */
    private String f17381j;

    /* renamed from: k, reason: collision with root package name */
    private String f17382k;

    /* renamed from: l, reason: collision with root package name */
    private String f17383l;

    /* renamed from: m, reason: collision with root package name */
    private List<SubPoiItemV2> f17384m;

    /* renamed from: n, reason: collision with root package name */
    private Business f17385n;

    /* renamed from: o, reason: collision with root package name */
    private IndoorDataV2 f17386o;

    /* renamed from: p, reason: collision with root package name */
    private PoiNavi f17387p;

    /* renamed from: q, reason: collision with root package name */
    private List<Photo> f17388q;

    public static class a implements Parcelable.Creator<PoiItemV2> {
        @Override // android.os.Parcelable.Creator
        public PoiItemV2 createFromParcel(Parcel parcel) {
            return new PoiItemV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public PoiItemV2[] newArray(int i10) {
            return new PoiItemV2[i10];
        }
    }

    public PoiItemV2(String str, LatLonPoint latLonPoint, String str2, String str3) {
        this.f17375d = "";
        this.f17384m = new ArrayList();
        this.f17388q = new ArrayList();
        this.f17372a = str;
        this.f17376e = latLonPoint;
        this.f17377f = str2;
        this.f17378g = str3;
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
        PoiItemV2 poiItemV2 = (PoiItemV2) obj;
        String str = this.f17372a;
        if (str == null) {
            if (poiItemV2.f17372a != null) {
                return false;
            }
        } else if (!str.equals(poiItemV2.f17372a)) {
            return false;
        }
        return true;
    }

    public String getAdCode() {
        return this.f17373b;
    }

    public String getAdName() {
        return this.f17382k;
    }

    public Business getBusiness() {
        return this.f17385n;
    }

    public String getCityCode() {
        return this.f17374c;
    }

    public String getCityName() {
        return this.f17381j;
    }

    public IndoorDataV2 getIndoorData() {
        return this.f17386o;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f17376e;
    }

    public List<Photo> getPhotos() {
        return this.f17388q;
    }

    public String getPoiId() {
        return this.f17372a;
    }

    public PoiNavi getPoiNavi() {
        return this.f17387p;
    }

    public String getProvinceCode() {
        return this.f17383l;
    }

    public String getProvinceName() {
        return this.f17380i;
    }

    public String getSnippet() {
        return this.f17378g;
    }

    public List<SubPoiItemV2> getSubPois() {
        return this.f17384m;
    }

    public String getTitle() {
        return this.f17377f;
    }

    public String getTypeCode() {
        return this.f17379h;
    }

    public String getTypeDes() {
        return this.f17375d;
    }

    public int hashCode() {
        String str = this.f17372a;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public void setAdCode(String str) {
        this.f17373b = str;
    }

    public void setAdName(String str) {
        this.f17382k = str;
    }

    public void setBusiness(Business business) {
        this.f17385n = business;
    }

    public void setCityCode(String str) {
        this.f17374c = str;
    }

    public void setCityName(String str) {
        this.f17381j = str;
    }

    public void setIndoorData(IndoorDataV2 indoorDataV2) {
        this.f17386o = indoorDataV2;
    }

    public void setPhotos(List<Photo> list) {
        this.f17388q = list;
    }

    public void setPoiNavi(PoiNavi poiNavi) {
        this.f17387p = poiNavi;
    }

    public void setProvinceCode(String str) {
        this.f17383l = str;
    }

    public void setProvinceName(String str) {
        this.f17380i = str;
    }

    public void setSubPois(List<SubPoiItemV2> list) {
        this.f17384m = list;
    }

    public void setTypeCode(String str) {
        this.f17379h = str;
    }

    public void setTypeDes(String str) {
        this.f17375d = str;
    }

    public String toString() {
        return this.f17377f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17372a);
        parcel.writeString(this.f17373b);
        parcel.writeString(this.f17375d);
        parcel.writeValue(this.f17376e);
        parcel.writeString(this.f17377f);
        parcel.writeString(this.f17378g);
        parcel.writeString(this.f17374c);
        parcel.writeString(this.f17380i);
        parcel.writeString(this.f17381j);
        parcel.writeString(this.f17382k);
        parcel.writeString(this.f17383l);
        parcel.writeString(this.f17379h);
        parcel.writeList(this.f17384m);
        parcel.writeValue(this.f17385n);
        parcel.writeValue(this.f17386o);
        parcel.writeValue(this.f17387p);
        parcel.writeTypedList(this.f17388q);
    }

    public PoiItemV2(Parcel parcel) {
        this.f17375d = "";
        this.f17384m = new ArrayList();
        this.f17388q = new ArrayList();
        this.f17372a = parcel.readString();
        this.f17373b = parcel.readString();
        this.f17375d = parcel.readString();
        this.f17376e = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f17377f = parcel.readString();
        this.f17378g = parcel.readString();
        this.f17374c = parcel.readString();
        this.f17380i = parcel.readString();
        this.f17381j = parcel.readString();
        this.f17382k = parcel.readString();
        this.f17383l = parcel.readString();
        this.f17379h = parcel.readString();
        this.f17384m = parcel.readArrayList(SubPoiItemV2.class.getClassLoader());
        this.f17385n = (Business) parcel.readValue(Business.class.getClassLoader());
        this.f17386o = (IndoorDataV2) parcel.readValue(IndoorDataV2.class.getClassLoader());
        this.f17387p = (PoiNavi) parcel.readValue(PoiNavi.class.getClassLoader());
        this.f17388q = parcel.createTypedArrayList(Photo.CREATOR);
    }
}
