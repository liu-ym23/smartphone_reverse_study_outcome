package com.baidu.mapapi.search.weather;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class WeatherSearchAlerts implements Parcelable {
    public static final Parcelable.Creator<WeatherSearchAlerts> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f7585a;

    /* renamed from: b, reason: collision with root package name */
    private String f7586b;

    /* renamed from: c, reason: collision with root package name */
    private String f7587c;

    /* renamed from: d, reason: collision with root package name */
    private String f7588d;

    public static class a implements Parcelable.Creator<WeatherSearchAlerts> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WeatherSearchAlerts createFromParcel(Parcel parcel) {
            return new WeatherSearchAlerts(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WeatherSearchAlerts[] newArray(int i4) {
            return new WeatherSearchAlerts[i4];
        }
    }

    public WeatherSearchAlerts() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDesc() {
        return this.f7588d;
    }

    public String getLevel() {
        return this.f7586b;
    }

    public String getTitle() {
        return this.f7587c;
    }

    public String getType() {
        return this.f7585a;
    }

    public void setDesc(String str) {
        this.f7588d = str;
    }

    public void setLevel(String str) {
        this.f7586b = str;
    }

    public void setTitle(String str) {
        this.f7587c = str;
    }

    public void setType(String str) {
        this.f7585a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f7585a);
        parcel.writeString(this.f7586b);
        parcel.writeString(this.f7587c);
        parcel.writeString(this.f7588d);
    }

    public WeatherSearchAlerts(Parcel parcel) {
        this.f7585a = parcel.readString();
        this.f7586b = parcel.readString();
        this.f7587c = parcel.readString();
        this.f7588d = parcel.readString();
    }
}
