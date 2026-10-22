package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes28.dex */
public class PoiItemExtension implements Parcelable {
    public static final Parcelable.Creator<PoiItemExtension> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f28994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f28995b;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public String getOpentime() {
        return this.f28994a;
    }

    public String getmRating() {
        return this.f28995b;
    }

    public PoiItemExtension(Parcel r100) {
        this.f28994a = r100.readString();
        this.f28995b = r100.readString();
    }

    public PoiItemExtension(String r100, String r101) {
        this.f28994a = r100;
        this.f28995b = r101;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f28994a);
        r100.writeString(this.f28995b);
    }
}
