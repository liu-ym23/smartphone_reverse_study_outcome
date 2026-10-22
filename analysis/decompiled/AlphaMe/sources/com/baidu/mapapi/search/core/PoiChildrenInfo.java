package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;

/* loaded from: classes.dex */
public class PoiChildrenInfo implements Parcelable {
    public static final Parcelable.Creator<PoiChildrenInfo> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f7284a;

    /* renamed from: b, reason: collision with root package name */
    private String f7285b;

    /* renamed from: c, reason: collision with root package name */
    private String f7286c;

    /* renamed from: d, reason: collision with root package name */
    private String f7287d;

    /* renamed from: e, reason: collision with root package name */
    private LatLng f7288e;

    /* renamed from: f, reason: collision with root package name */
    private String f7289f;

    public static class a implements Parcelable.Creator<PoiChildrenInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PoiChildrenInfo createFromParcel(Parcel parcel) {
            return new PoiChildrenInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PoiChildrenInfo[] newArray(int i4) {
            return new PoiChildrenInfo[i4];
        }
    }

    public PoiChildrenInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.f7289f;
    }

    public LatLng getLocation() {
        return this.f7288e;
    }

    public String getName() {
        return this.f7285b;
    }

    public String getShowName() {
        return this.f7286c;
    }

    public String getTag() {
        return this.f7287d;
    }

    public String getUid() {
        return this.f7284a;
    }

    public void setAddress(String str) {
        this.f7289f = str;
    }

    public void setLocation(LatLng latLng) {
        this.f7288e = latLng;
    }

    public void setName(String str) {
        this.f7285b = str;
    }

    public void setShowName(String str) {
        this.f7286c = str;
    }

    public void setTag(String str) {
        this.f7287d = str;
    }

    public void setUid(String str) {
        this.f7284a = str;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("PoiChildrenInfo: uid = ");
        stringBuffer.append(this.f7284a);
        stringBuffer.append("; name = ");
        stringBuffer.append(this.f7285b);
        stringBuffer.append("; showName = ");
        stringBuffer.append(this.f7286c);
        stringBuffer.append("; tag = ");
        stringBuffer.append(this.f7287d);
        stringBuffer.append("; location = ");
        LatLng latLng = this.f7288e;
        if (latLng != null) {
            stringBuffer.append(latLng.toString());
        } else {
            stringBuffer.append("null");
        }
        stringBuffer.append("; address = ");
        stringBuffer.append(this.f7289f);
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f7284a);
        parcel.writeString(this.f7285b);
        parcel.writeString(this.f7286c);
        parcel.writeString(this.f7287d);
        parcel.writeParcelable(this.f7288e, i4);
        parcel.writeString(this.f7289f);
    }

    public PoiChildrenInfo(Parcel parcel) {
        this.f7284a = parcel.readString();
        this.f7285b = parcel.readString();
        this.f7286c = parcel.readString();
        this.f7287d = parcel.readString();
        this.f7288e = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f7289f = parcel.readString();
    }
}
