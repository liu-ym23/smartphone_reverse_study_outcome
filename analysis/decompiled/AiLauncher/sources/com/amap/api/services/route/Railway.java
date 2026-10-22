package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class Railway implements Parcelable {
    public static final Parcelable.Creator<Railway> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f17760a;

    /* renamed from: b, reason: collision with root package name */
    private String f17761b;

    public static class a implements Parcelable.Creator<Railway> {
        @Override // android.os.Parcelable.Creator
        public Railway createFromParcel(Parcel parcel) {
            return new Railway(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Railway[] newArray(int i10) {
            return new Railway[i10];
        }
    }

    public Railway() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getID() {
        return this.f17760a;
    }

    public String getName() {
        return this.f17761b;
    }

    public void setID(String str) {
        this.f17760a = str;
    }

    public void setName(String str) {
        this.f17761b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17760a);
        parcel.writeString(this.f17761b);
    }

    public Railway(Parcel parcel) {
        this.f17760a = parcel.readString();
        this.f17761b = parcel.readString();
    }
}
