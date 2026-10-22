package com.amap.api.fence;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.location.DPoint;
import java.util.List;

/* loaded from: classes.dex */
public class DistrictItem implements Parcelable {
    public static final Parcelable.Creator<DistrictItem> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f17073a;

    /* renamed from: b, reason: collision with root package name */
    private String f17074b;

    /* renamed from: c, reason: collision with root package name */
    private String f17075c;

    /* renamed from: d, reason: collision with root package name */
    private List<DPoint> f17076d;

    public static class a implements Parcelable.Creator<DistrictItem> {
        @Override // android.os.Parcelable.Creator
        public DistrictItem createFromParcel(Parcel parcel) {
            return new DistrictItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public DistrictItem[] newArray(int i10) {
            return new DistrictItem[i10];
        }
    }

    public DistrictItem() {
        this.f17073a = "";
        this.f17074b = null;
        this.f17075c = null;
        this.f17076d = null;
    }

    public static Parcelable.Creator<DistrictItem> getCreator() {
        return CREATOR;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdcode() {
        return this.f17075c;
    }

    public String getCitycode() {
        return this.f17074b;
    }

    public String getDistrictName() {
        return this.f17073a;
    }

    public List<DPoint> getPolyline() {
        return this.f17076d;
    }

    public void setAdcode(String str) {
        this.f17075c = str;
    }

    public void setCitycode(String str) {
        this.f17074b = str;
    }

    public void setDistrictName(String str) {
        this.f17073a = str;
    }

    public void setPolyline(List<DPoint> list) {
        this.f17076d = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17073a);
        parcel.writeString(this.f17074b);
        parcel.writeString(this.f17075c);
        parcel.writeTypedList(this.f17076d);
    }

    public DistrictItem(Parcel parcel) {
        this.f17073a = "";
        this.f17074b = null;
        this.f17075c = null;
        this.f17076d = null;
        this.f17073a = parcel.readString();
        this.f17074b = parcel.readString();
        this.f17075c = parcel.readString();
        this.f17076d = parcel.createTypedArrayList(DPoint.CREATOR);
    }
}
