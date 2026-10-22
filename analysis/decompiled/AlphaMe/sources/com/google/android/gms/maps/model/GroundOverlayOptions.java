package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import t0.J;

@SafeParcelable.Class(creator = "GroundOverlayOptionsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class GroundOverlayOptions extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<GroundOverlayOptions> CREATOR = new c(5);

    /* renamed from: a, reason: collision with root package name */
    public a f10155a;

    /* renamed from: b, reason: collision with root package name */
    public LatLng f10156b;

    /* renamed from: c, reason: collision with root package name */
    public float f10157c;

    /* renamed from: d, reason: collision with root package name */
    public float f10158d;

    /* renamed from: e, reason: collision with root package name */
    public LatLngBounds f10159e;

    /* renamed from: f, reason: collision with root package name */
    public float f10160f;

    /* renamed from: g, reason: collision with root package name */
    public float f10161g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f10162h;

    /* renamed from: i, reason: collision with root package name */
    public float f10163i;

    /* renamed from: j, reason: collision with root package name */
    public float f10164j;

    /* renamed from: k, reason: collision with root package name */
    public float f10165k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f10166l;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.R(parcel, 2, this.f10155a.f10247a.asBinder());
        J.T(parcel, 3, this.f10156b, i4);
        J.c0(parcel, 4, 4);
        parcel.writeFloat(this.f10157c);
        J.c0(parcel, 5, 4);
        parcel.writeFloat(this.f10158d);
        J.T(parcel, 6, this.f10159e, i4);
        J.c0(parcel, 7, 4);
        parcel.writeFloat(this.f10160f);
        J.c0(parcel, 8, 4);
        parcel.writeFloat(this.f10161g);
        J.c0(parcel, 9, 4);
        parcel.writeInt(this.f10162h ? 1 : 0);
        J.c0(parcel, 10, 4);
        parcel.writeFloat(this.f10163i);
        J.c0(parcel, 11, 4);
        parcel.writeFloat(this.f10164j);
        J.c0(parcel, 12, 4);
        parcel.writeFloat(this.f10165k);
        J.c0(parcel, 13, 4);
        parcel.writeInt(this.f10166l ? 1 : 0);
        J.b0(parcel, iZ);
    }
}
