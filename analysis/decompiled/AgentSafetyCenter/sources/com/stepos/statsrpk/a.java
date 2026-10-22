package com.stepos.statsrpk;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new android.support.v4.os.a(8);

    /* renamed from: c, reason: collision with root package name */
    public String f2844c;

    /* renamed from: f, reason: collision with root package name */
    public String f2845f;

    /* renamed from: g, reason: collision with root package name */
    public String f2846g;

    /* renamed from: h, reason: collision with root package name */
    public Map f2847h;
    public String i;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("[");
        sb2.append(this.f2844c);
        sb2.append(",");
        sb2.append(this.f2845f);
        sb2.append(",");
        sb2.append(this.f2846g);
        sb2.append(",");
        sb2.append(this.f2847h);
        sb2.append(",");
        return androidx.activity.b.n(sb2, this.i, "]");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2844c);
        parcel.writeString(this.f2845f);
        parcel.writeString(this.f2846g);
        parcel.writeMap(this.f2847h);
        parcel.writeString(this.i);
    }
}
