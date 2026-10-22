package com.stepos.statsrpk;

import B0.g;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class RpkInfo implements Parcelable {
    public static final Parcelable.Creator<RpkInfo> CREATOR = new com.google.android.material.internal.f(7);

    /* renamed from: a, reason: collision with root package name */
    public String f12349a;

    /* renamed from: b, reason: collision with root package name */
    public String f12350b;

    /* renamed from: c, reason: collision with root package name */
    public int f12351c;

    /* renamed from: d, reason: collision with root package name */
    public String f12352d;

    /* renamed from: e, reason: collision with root package name */
    public String f12353e;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        sb.append(this.f12349a);
        sb.append(",");
        sb.append(this.f12350b);
        sb.append(",");
        sb.append(this.f12351c);
        sb.append(",");
        sb.append(this.f12352d);
        sb.append(",");
        return g.r(sb, this.f12353e, "]");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f12349a);
        parcel.writeString(this.f12350b);
        parcel.writeInt(this.f12351c);
        parcel.writeString(this.f12352d);
        parcel.writeString(this.f12353e);
    }
}
