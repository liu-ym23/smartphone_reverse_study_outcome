package com.baidu.mapapi.search.geocode;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;

/* loaded from: classes.dex */
public class GeoCodeResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<GeoCodeResult> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private LatLng f7362a;

    /* renamed from: b, reason: collision with root package name */
    private String f7363b;

    /* renamed from: c, reason: collision with root package name */
    private int f7364c;

    /* renamed from: d, reason: collision with root package name */
    private int f7365d;

    /* renamed from: e, reason: collision with root package name */
    private String f7366e;

    public static class a implements Parcelable.Creator<GeoCodeResult> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GeoCodeResult createFromParcel(Parcel parcel) {
            return new GeoCodeResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GeoCodeResult[] newArray(int i4) {
            return new GeoCodeResult[i4];
        }
    }

    public GeoCodeResult() {
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public String getAddress() {
        return this.f7363b;
    }

    public int getConfidence() {
        return this.f7365d;
    }

    public String getLevel() {
        return this.f7366e;
    }

    public LatLng getLocation() {
        return this.f7362a;
    }

    public int getPrecise() {
        return this.f7364c;
    }

    @Deprecated
    public void setAddress(String str) {
        this.f7363b = str;
    }

    public void setConfidence(int i4) {
        this.f7365d = i4;
    }

    public void setLevel(String str) {
        this.f7366e = str;
    }

    public void setLocation(LatLng latLng) {
        this.f7362a = latLng;
    }

    public void setPrecise(int i4) {
        this.f7364c = i4;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("GeoCodeResult: \nlocation = ");
        stringBuffer.append(this.f7362a);
        stringBuffer.append("; precise = ");
        stringBuffer.append(this.f7364c);
        stringBuffer.append("; confidence = ");
        stringBuffer.append(this.f7365d);
        stringBuffer.append("; level = ");
        stringBuffer.append(this.f7366e);
        return stringBuffer.toString();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeValue(this.f7362a);
        parcel.writeString(this.f7363b);
        parcel.writeInt(this.f7364c);
        parcel.writeInt(this.f7365d);
        parcel.writeString(this.f7366e);
    }

    public GeoCodeResult(Parcel parcel) {
        this.f7362a = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.f7363b = parcel.readString();
        this.f7364c = parcel.readInt();
        this.f7365d = parcel.readInt();
        this.f7366e = parcel.readString();
    }
}
