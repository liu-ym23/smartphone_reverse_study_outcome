package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class PoiItemExtension implements Parcelable {
    public static final Parcelable.Creator<PoiItemExtension> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f17531a;

    /* renamed from: b, reason: collision with root package name */
    private String f17532b;

    public static class a implements Parcelable.Creator<PoiItemExtension> {
        @Override // android.os.Parcelable.Creator
        public PoiItemExtension createFromParcel(Parcel parcel) {
            return new PoiItemExtension(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public PoiItemExtension[] newArray(int i10) {
            return new PoiItemExtension[i10];
        }
    }

    public PoiItemExtension(String str, String str2) {
        this.f17531a = str;
        this.f17532b = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getOpentime() {
        return this.f17531a;
    }

    public String getmRating() {
        return this.f17532b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17531a);
        parcel.writeString(this.f17532b);
    }

    public PoiItemExtension(Parcel parcel) {
        this.f17531a = parcel.readString();
        this.f17532b = parcel.readString();
    }
}
