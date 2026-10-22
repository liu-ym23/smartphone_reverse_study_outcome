package com.stepos.statsrpk;

import B0.g;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;

/* loaded from: classes.dex */
public class RpkEvent implements Parcelable {
    public static final Parcelable.Creator<RpkEvent> CREATOR = new com.google.android.material.internal.f(6);

    /* renamed from: a, reason: collision with root package name */
    public String f12344a;

    /* renamed from: b, reason: collision with root package name */
    public String f12345b;

    /* renamed from: c, reason: collision with root package name */
    public String f12346c;

    /* renamed from: d, reason: collision with root package name */
    public Map f12347d;

    /* renamed from: e, reason: collision with root package name */
    public String f12348e;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        sb.append(this.f12344a);
        sb.append(",");
        sb.append(this.f12345b);
        sb.append(",");
        sb.append(this.f12346c);
        sb.append(",");
        sb.append(this.f12347d);
        sb.append(",");
        return g.r(sb, this.f12348e, "]");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f12344a);
        parcel.writeString(this.f12345b);
        parcel.writeString(this.f12346c);
        parcel.writeMap(this.f12347d);
        parcel.writeString(this.f12348e);
    }
}
