package com.baidu.mapapi.search.weather;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class WeatherLifeIndexes implements Parcelable {
    public static final Parcelable.Creator<WeatherLifeIndexes> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f7575a;

    /* renamed from: b, reason: collision with root package name */
    private String f7576b;

    /* renamed from: c, reason: collision with root package name */
    private String f7577c;

    public static class a implements Parcelable.Creator<WeatherLifeIndexes> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WeatherLifeIndexes createFromParcel(Parcel parcel) {
            return new WeatherLifeIndexes(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WeatherLifeIndexes[] newArray(int i4) {
            return new WeatherLifeIndexes[i4];
        }
    }

    public WeatherLifeIndexes() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBrief() {
        return this.f7576b;
    }

    public String getDetail() {
        return this.f7577c;
    }

    public String getName() {
        return this.f7575a;
    }

    public void setBrief(String str) {
        this.f7576b = str;
    }

    public void setDetail(String str) {
        this.f7577c = str;
    }

    public void setName(String str) {
        this.f7575a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(getName());
        parcel.writeString(getBrief());
        parcel.writeString(getDetail());
    }

    public WeatherLifeIndexes(Parcel parcel) {
        setName(parcel.readString());
        setBrief(parcel.readString());
        setDetail(parcel.readString());
    }
}
