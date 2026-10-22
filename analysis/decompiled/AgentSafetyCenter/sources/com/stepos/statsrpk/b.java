package com.stepos.statsrpk;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new android.support.v4.os.a(9);

    /* renamed from: c, reason: collision with root package name */
    public String f2848c;

    /* renamed from: f, reason: collision with root package name */
    public String f2849f;

    /* renamed from: g, reason: collision with root package name */
    public int f2850g;

    /* renamed from: h, reason: collision with root package name */
    public String f2851h;
    public String i;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("[");
        sb2.append(this.f2848c);
        sb2.append(",");
        sb2.append(this.f2849f);
        sb2.append(",");
        sb2.append(this.f2850g);
        sb2.append(",");
        sb2.append(this.f2851h);
        sb2.append(",");
        return androidx.activity.b.n(sb2, this.i, "]");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2848c);
        parcel.writeString(this.f2849f);
        parcel.writeInt(this.f2850g);
        parcel.writeString(this.f2851h);
        parcel.writeString(this.i);
    }
}
