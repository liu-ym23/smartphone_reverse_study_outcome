package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import t0.J;

@SafeParcelable.Class(creator = "StrokeStyleCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class StrokeStyle extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<StrokeStyle> CREATOR = new c(20);

    /* renamed from: a, reason: collision with root package name */
    public final float f10227a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10228b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10229c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f10230d;

    /* renamed from: e, reason: collision with root package name */
    public final StampStyle f10231e;

    public StrokeStyle(float f4, int i4, int i5, boolean z4, StampStyle stampStyle) {
        this.f10227a = f4;
        this.f10228b = i4;
        this.f10229c = i5;
        this.f10230d = z4;
        this.f10231e = stampStyle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 2, 4);
        parcel.writeFloat(this.f10227a);
        J.c0(parcel, 3, 4);
        parcel.writeInt(this.f10228b);
        J.c0(parcel, 4, 4);
        parcel.writeInt(this.f10229c);
        J.c0(parcel, 5, 4);
        parcel.writeInt(this.f10230d ? 1 : 0);
        J.T(parcel, 6, this.f10231e, i4);
        J.b0(parcel, iZ);
    }
}
