package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes28.dex */
public class SearchCity implements Parcelable {
    public static final Parcelable.Creator<SearchCity> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f29203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f29204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f29205c;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public SearchCity() {
    }

    public String getSearchCityAdCode() {
        return this.f29205c;
    }

    public String getSearchCityName() {
        return this.f29203a;
    }

    public String getSearchCitycode() {
        return this.f29204b;
    }

    public SearchCity(Parcel r100) {
        this.f29203a = r100.readString();
        this.f29204b = r100.readString();
        this.f29205c = r100.readString();
    }

    public void setSearchCityName(String r100) {
        this.f29203a = r100;
    }

    public void setSearchCitycode(String r100) {
        this.f29204b = r100;
    }

    public void setSearchCityhAdCode(String r100) {
        this.f29205c = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f29203a);
        r100.writeString(this.f29204b);
        r100.writeString(this.f29205c);
    }
}
