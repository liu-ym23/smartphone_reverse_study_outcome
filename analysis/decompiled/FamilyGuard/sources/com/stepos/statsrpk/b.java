package com.stepos.statsrpk;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public String f15938a;

    /* renamed from: b, reason: collision with root package name */
    public String f15939b;

    /* renamed from: c, reason: collision with root package name */
    public int f15940c;

    /* renamed from: d, reason: collision with root package name */
    public String f15941d;

    /* renamed from: e, reason: collision with root package name */
    public String f15942e;

    class a implements Parcelable.Creator<b> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i5) {
            return new b[i5];
        }
    }

    public b() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "[" + this.f15938a + "," + this.f15939b + "," + this.f15940c + "," + this.f15941d + "," + this.f15942e + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeString(this.f15938a);
        parcel.writeString(this.f15939b);
        parcel.writeInt(this.f15940c);
        parcel.writeString(this.f15941d);
        parcel.writeString(this.f15942e);
    }

    protected b(Parcel parcel) {
        this.f15938a = parcel.readString();
        this.f15939b = parcel.readString();
        this.f15940c = parcel.readInt();
        this.f15941d = parcel.readString();
        this.f15942e = parcel.readString();
    }
}
