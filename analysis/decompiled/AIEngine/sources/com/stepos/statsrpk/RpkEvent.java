package com.stepos.statsrpk;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class RpkEvent implements Parcelable {
    public static final Parcelable.Creator<RpkEvent> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public String f8045a;

    /* renamed from: b, reason: collision with root package name */
    public String f8046b;

    /* renamed from: c, reason: collision with root package name */
    public String f8047c;

    /* renamed from: d, reason: collision with root package name */
    public Map f8048d;

    /* renamed from: e, reason: collision with root package name */
    public String f8049e;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Parcelable.Creator<RpkEvent> {
        @Override // android.os.Parcelable.Creator
        public final RpkEvent createFromParcel(Parcel parcel) {
            return new RpkEvent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final RpkEvent[] newArray(int i10) {
            return new RpkEvent[i10];
        }
    }

    public RpkEvent() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("[");
        sb2.append(this.f8045a);
        sb2.append(",");
        sb2.append(this.f8046b);
        sb2.append(",");
        sb2.append(this.f8047c);
        sb2.append(",");
        sb2.append(this.f8048d);
        sb2.append(",");
        return ai.onnxruntime.a.o(sb2, this.f8049e, "]");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f8045a);
        parcel.writeString(this.f8046b);
        parcel.writeString(this.f8047c);
        parcel.writeMap(this.f8048d);
        parcel.writeString(this.f8049e);
    }

    public RpkEvent(Parcel parcel) {
        this.f8045a = parcel.readString();
        this.f8046b = parcel.readString();
        this.f8047c = parcel.readString();
        this.f8048d = parcel.readHashMap(String.class.getClassLoader());
        this.f8049e = parcel.readString();
    }
}
