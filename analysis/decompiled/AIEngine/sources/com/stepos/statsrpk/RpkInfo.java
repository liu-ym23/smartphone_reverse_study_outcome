package com.stepos.statsrpk;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class RpkInfo implements Parcelable {
    public static final Parcelable.Creator<RpkInfo> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public String f8050a;

    /* renamed from: b, reason: collision with root package name */
    public String f8051b;

    /* renamed from: c, reason: collision with root package name */
    public int f8052c;

    /* renamed from: d, reason: collision with root package name */
    public String f8053d;

    /* renamed from: e, reason: collision with root package name */
    public String f8054e;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Parcelable.Creator<RpkInfo> {
        @Override // android.os.Parcelable.Creator
        public final RpkInfo createFromParcel(Parcel parcel) {
            return new RpkInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final RpkInfo[] newArray(int i10) {
            return new RpkInfo[i10];
        }
    }

    public RpkInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("[");
        sb2.append(this.f8050a);
        sb2.append(",");
        sb2.append(this.f8051b);
        sb2.append(",");
        sb2.append(this.f8052c);
        sb2.append(",");
        sb2.append(this.f8053d);
        sb2.append(",");
        return ai.onnxruntime.a.o(sb2, this.f8054e, "]");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f8050a);
        parcel.writeString(this.f8051b);
        parcel.writeInt(this.f8052c);
        parcel.writeString(this.f8053d);
        parcel.writeString(this.f8054e);
    }

    public RpkInfo(Parcel parcel) {
        this.f8050a = parcel.readString();
        this.f8051b = parcel.readString();
        this.f8052c = parcel.readInt();
        this.f8053d = parcel.readString();
        this.f8054e = parcel.readString();
    }
}
