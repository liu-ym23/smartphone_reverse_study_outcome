package com.stepos.statsrpk;

import L.g;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;

/* loaded from: classes3.dex */
public class RpkEvent implements Parcelable {
    public static final Parcelable.Creator<RpkEvent> CREATOR = new g(9);

    /* renamed from: a, reason: collision with root package name */
    public String f3975a;
    public String b;
    public String c;
    public Map d;
    public String e;

    public RpkEvent() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        sb.append(this.f3975a);
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
        parcel.writeString(this.f3975a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeMap(this.d);
        parcel.writeString(this.e);
    }

    public RpkEvent(Parcel parcel) {
        this.f3975a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readHashMap(String.class.getClassLoader());
        this.e = parcel.readString();
    }
}
