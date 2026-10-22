package com.zyql.agentguard.collector;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.b;
import s.f;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new android.support.v4.os.a(10);

    /* renamed from: c, reason: collision with root package name */
    public String f2917c;

    /* renamed from: f, reason: collision with root package name */
    public int f2918f;

    /* renamed from: g, reason: collision with root package name */
    public String f2919g;

    /* renamed from: h, reason: collision with root package name */
    public String f2920h;
    public String i;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f2917c.equals(aVar.f2917c) && this.f2918f == aVar.f2918f && k.a(this.f2919g, aVar.f2919g) && k.a(this.f2920h, aVar.f2920h) && k.a(this.i, aVar.i);
    }

    public final int hashCode() {
        int iB = f.b(this.f2918f, this.f2917c.hashCode() * 31, 31);
        String str = this.f2919g;
        int iHashCode = (iB + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f2920h;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.i;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        String str = this.f2917c;
        int i = this.f2918f;
        String str2 = this.f2919g;
        String str3 = this.f2920h;
        String str4 = this.i;
        StringBuilder sb2 = new StringBuilder("CollectStatus(requestId=");
        sb2.append(str);
        sb2.append(", state=");
        sb2.append(i);
        sb2.append(", bundleId=");
        b.u(sb2, str2, ", sha256=", str3, ", error=");
        return b.n(sb2, str4, ")");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeString(this.f2917c);
        parcel.writeInt(this.f2918f);
        parcel.writeString(this.f2919g);
        parcel.writeString(this.f2920h);
        parcel.writeString(this.i);
    }
}
