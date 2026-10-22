package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.maps.zzam;
import t0.J;

@SafeParcelable.Class(creator = "TileOverlayOptionsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class TileOverlayOptions extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<TileOverlayOptions> CREATOR = new c(1);

    /* renamed from: a, reason: collision with root package name */
    public zzam f10237a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f10238b;

    /* renamed from: c, reason: collision with root package name */
    public float f10239c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f10240d;

    /* renamed from: e, reason: collision with root package name */
    public float f10241e;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        zzam zzamVar = this.f10237a;
        J.R(parcel, 2, zzamVar == null ? null : zzamVar.asBinder());
        J.c0(parcel, 3, 4);
        parcel.writeInt(this.f10238b ? 1 : 0);
        J.c0(parcel, 4, 4);
        parcel.writeFloat(this.f10239c);
        J.c0(parcel, 5, 4);
        parcel.writeInt(this.f10240d ? 1 : 0);
        J.c0(parcel, 6, 4);
        parcel.writeFloat(this.f10241e);
        J.b0(parcel, iZ);
    }
}
