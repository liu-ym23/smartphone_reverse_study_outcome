package com.stepos.statsrpk;

import L.g;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class RpkInfo implements Parcelable {
    public static final Parcelable.Creator<RpkInfo> CREATOR = new g(10);

    /* renamed from: a, reason: collision with root package name */
    public String f3976a;
    public String b;
    public int c;
    public String d;
    public String e;

    public RpkInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        sb.append(this.f3976a);
        sb.append(",");
        sb.append(this.b);
        sb.append(",");
        sb.append(this.c);
        sb.append(",");
        sb.append(this.d);
        sb.append(",");
        return B7.a.q(sb, this.e, "]");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3976a);
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
    }

    public RpkInfo(Parcel parcel) {
        this.f3976a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readInt();
        this.d = parcel.readString();
        this.e = parcel.readString();
    }
}
