package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;
import t0.J;

@SafeParcelable.Class(creator = "CircleOptionsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class CircleOptions extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<CircleOptions> CREATOR = new c(4);

    /* renamed from: a, reason: collision with root package name */
    public LatLng f10144a;

    /* renamed from: b, reason: collision with root package name */
    public double f10145b;

    /* renamed from: c, reason: collision with root package name */
    public float f10146c;

    /* renamed from: d, reason: collision with root package name */
    public int f10147d;

    /* renamed from: e, reason: collision with root package name */
    public int f10148e;

    /* renamed from: f, reason: collision with root package name */
    public float f10149f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f10150g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f10151h;

    /* renamed from: i, reason: collision with root package name */
    public List f10152i;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.T(parcel, 2, this.f10144a, i4);
        J.c0(parcel, 3, 8);
        parcel.writeDouble(this.f10145b);
        J.c0(parcel, 4, 4);
        parcel.writeFloat(this.f10146c);
        J.c0(parcel, 5, 4);
        parcel.writeInt(this.f10147d);
        J.c0(parcel, 6, 4);
        parcel.writeInt(this.f10148e);
        J.c0(parcel, 7, 4);
        parcel.writeFloat(this.f10149f);
        J.c0(parcel, 8, 4);
        parcel.writeInt(this.f10150g ? 1 : 0);
        J.c0(parcel, 9, 4);
        parcel.writeInt(this.f10151h ? 1 : 0);
        J.W(parcel, 10, this.f10152i);
        J.b0(parcel, iZ);
    }
}
