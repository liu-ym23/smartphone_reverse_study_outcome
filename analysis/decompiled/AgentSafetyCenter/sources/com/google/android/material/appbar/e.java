package com.google.android.material.appbar;

import android.os.Parcel;
import android.os.Parcelable;
import u0.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e extends t3.b {
    public static final Parcelable.Creator<e> CREATOR = new p(2);

    /* renamed from: c, reason: collision with root package name */
    public boolean f2338c;

    /* renamed from: f, reason: collision with root package name */
    public boolean f2339f;

    /* renamed from: g, reason: collision with root package name */
    public int f2340g;

    /* renamed from: h, reason: collision with root package name */
    public float f2341h;
    public boolean i;

    public e(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f2338c = parcel.readByte() != 0;
        this.f2339f = parcel.readByte() != 0;
        this.f2340g = parcel.readInt();
        this.f2341h = parcel.readFloat();
        this.i = parcel.readByte() != 0;
    }

    @Override // t3.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeByte(this.f2338c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f2339f ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f2340g);
        parcel.writeFloat(this.f2341h);
        parcel.writeByte(this.i ? (byte) 1 : (byte) 0);
    }
}
