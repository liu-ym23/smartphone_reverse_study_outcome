package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0019a();

    /* renamed from: a, reason: collision with root package name */
    private int f7358a;

    /* renamed from: b, reason: collision with root package name */
    private int f7359b;

    /* renamed from: com.baidu.mapapi.search.core.a$a, reason: collision with other inner class name */
    public static class C0019a implements Parcelable.Creator<a> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i4) {
            return new a[i4];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }
    }

    public a() {
        this.f7358a = -1;
        this.f7359b = -1;
    }

    public int a() {
        return this.f7358a;
    }

    public int b() {
        return this.f7359b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f7358a);
        parcel.writeInt(this.f7359b);
    }

    public void a(int i4) {
        this.f7358a = i4;
    }

    public void b(int i4) {
        this.f7359b = i4;
    }

    public a(Parcel parcel) {
        this.f7358a = -1;
        this.f7359b = -1;
        this.f7358a = parcel.readInt();
        this.f7359b = parcel.readInt();
    }
}
