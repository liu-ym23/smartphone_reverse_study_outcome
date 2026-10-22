package com.stepos.statsrpk;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;

/* loaded from: classes.dex */
public class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0197a();

    /* renamed from: a, reason: collision with root package name */
    public String f15933a;

    /* renamed from: b, reason: collision with root package name */
    public String f15934b;

    /* renamed from: c, reason: collision with root package name */
    public String f15935c;

    /* renamed from: d, reason: collision with root package name */
    public Map f15936d;

    /* renamed from: e, reason: collision with root package name */
    public String f15937e;

    /* renamed from: com.stepos.statsrpk.a$a, reason: collision with other inner class name */
    class C0197a implements Parcelable.Creator<a> {
        C0197a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i5) {
            return new a[i5];
        }
    }

    public a() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "[" + this.f15933a + "," + this.f15934b + "," + this.f15935c + "," + this.f15936d + "," + this.f15937e + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeString(this.f15933a);
        parcel.writeString(this.f15934b);
        parcel.writeString(this.f15935c);
        parcel.writeMap(this.f15936d);
        parcel.writeString(this.f15937e);
    }

    protected a(Parcel parcel) {
        this.f15933a = parcel.readString();
        this.f15934b = parcel.readString();
        this.f15935c = parcel.readString();
        this.f15936d = parcel.readHashMap(String.class.getClassLoader());
        this.f15937e = parcel.readString();
    }
}
