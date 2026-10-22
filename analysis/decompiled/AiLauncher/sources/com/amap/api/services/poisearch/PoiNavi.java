package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: classes.dex */
public class PoiNavi implements Parcelable {
    public static final Parcelable.Creator<PoiNavi> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f17533a;

    /* renamed from: b, reason: collision with root package name */
    private LatLonPoint f17534b;

    /* renamed from: c, reason: collision with root package name */
    private LatLonPoint f17535c;

    /* renamed from: d, reason: collision with root package name */
    private String f17536d;

    public static class a implements Parcelable.Creator<PoiNavi> {
        @Override // android.os.Parcelable.Creator
        public PoiNavi createFromParcel(Parcel parcel) {
            return new PoiNavi(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PoiNavi[] newArray(int i10) {
            return null;
        }
    }

    public PoiNavi() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getEnter() {
        return this.f17534b;
    }

    public LatLonPoint getExit() {
        return this.f17535c;
    }

    public String getGridCode() {
        return this.f17536d;
    }

    public String getNaviPoiID() {
        return this.f17533a;
    }

    public void setEnter(LatLonPoint latLonPoint) {
        this.f17534b = latLonPoint;
    }

    public void setExit(LatLonPoint latLonPoint) {
        this.f17535c = latLonPoint;
    }

    public void setGridCode(String str) {
        this.f17536d = str;
    }

    public void setNaviPoiID(String str) {
        this.f17533a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17533a);
        parcel.writeValue(this.f17534b);
        parcel.writeValue(this.f17535c);
        parcel.writeString(this.f17536d);
    }

    public PoiNavi(String str, LatLonPoint latLonPoint, LatLonPoint latLonPoint2, String str2) {
        this.f17533a = str;
        this.f17534b = latLonPoint;
        this.f17535c = latLonPoint2;
        this.f17536d = str2;
    }

    public PoiNavi(Parcel parcel) {
        this.f17533a = parcel.readString();
        this.f17534b = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f17535c = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f17536d = parcel.readString();
    }
}
