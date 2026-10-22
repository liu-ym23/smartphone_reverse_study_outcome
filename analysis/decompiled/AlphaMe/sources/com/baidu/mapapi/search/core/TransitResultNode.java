package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;

/* loaded from: classes.dex */
public class TransitResultNode implements Parcelable {
    public static final Parcelable.Creator<TransitResultNode> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private int f7345a;

    /* renamed from: b, reason: collision with root package name */
    private String f7346b;

    /* renamed from: c, reason: collision with root package name */
    private LatLng f7347c;

    /* renamed from: d, reason: collision with root package name */
    private String f7348d;

    public static class a implements Parcelable.Creator<TransitResultNode> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TransitResultNode createFromParcel(Parcel parcel) {
            return new TransitResultNode(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TransitResultNode[] newArray(int i4) {
            return new TransitResultNode[i4];
        }
    }

    public TransitResultNode(int i4, String str, LatLng latLng, String str2) {
        this.f7345a = i4;
        this.f7346b = str;
        this.f7347c = latLng;
        this.f7348d = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCityId() {
        return this.f7345a;
    }

    public String getCityName() {
        return this.f7346b;
    }

    public LatLng getLocation() {
        return this.f7347c;
    }

    public String getSearchWord() {
        return this.f7348d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f7345a);
        parcel.writeString(this.f7346b);
        parcel.writeValue(this.f7347c);
        parcel.writeString(this.f7348d);
    }

    public TransitResultNode(Parcel parcel) {
        this.f7346b = null;
        this.f7347c = null;
        this.f7348d = null;
        this.f7345a = parcel.readInt();
        this.f7346b = parcel.readString();
        this.f7347c = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.f7348d = parcel.readString();
    }
}
