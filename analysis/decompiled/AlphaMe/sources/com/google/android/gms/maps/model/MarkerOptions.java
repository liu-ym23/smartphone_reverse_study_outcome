package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import t0.J;

@SafeParcelable.Class(creator = "MarkerOptionsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class MarkerOptions extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<MarkerOptions> CREATOR = new c(9);

    /* renamed from: a, reason: collision with root package name */
    public LatLng f10172a;

    /* renamed from: b, reason: collision with root package name */
    public String f10173b;

    /* renamed from: c, reason: collision with root package name */
    public String f10174c;

    /* renamed from: d, reason: collision with root package name */
    public a f10175d;

    /* renamed from: e, reason: collision with root package name */
    public float f10176e;

    /* renamed from: f, reason: collision with root package name */
    public float f10177f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f10178g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f10179h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f10180i;

    /* renamed from: j, reason: collision with root package name */
    public float f10181j;

    /* renamed from: k, reason: collision with root package name */
    public float f10182k;

    /* renamed from: l, reason: collision with root package name */
    public float f10183l;

    /* renamed from: m, reason: collision with root package name */
    public float f10184m;

    /* renamed from: n, reason: collision with root package name */
    public float f10185n;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.T(parcel, 2, this.f10172a, i4);
        J.U(parcel, 3, this.f10173b);
        J.U(parcel, 4, this.f10174c);
        a aVar = this.f10175d;
        J.R(parcel, 5, aVar == null ? null : aVar.f10247a.asBinder());
        J.c0(parcel, 6, 4);
        parcel.writeFloat(this.f10176e);
        J.c0(parcel, 7, 4);
        parcel.writeFloat(this.f10177f);
        J.c0(parcel, 8, 4);
        parcel.writeInt(this.f10178g ? 1 : 0);
        J.c0(parcel, 9, 4);
        parcel.writeInt(this.f10179h ? 1 : 0);
        J.c0(parcel, 10, 4);
        parcel.writeInt(this.f10180i ? 1 : 0);
        J.c0(parcel, 11, 4);
        parcel.writeFloat(this.f10181j);
        J.c0(parcel, 12, 4);
        parcel.writeFloat(this.f10182k);
        J.c0(parcel, 13, 4);
        parcel.writeFloat(this.f10183l);
        J.c0(parcel, 14, 4);
        parcel.writeFloat(this.f10184m);
        J.c0(parcel, 15, 4);
        parcel.writeFloat(this.f10185n);
        J.b0(parcel, iZ);
    }
}
