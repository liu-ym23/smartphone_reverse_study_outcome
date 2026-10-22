package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import t0.J;

@SafeParcelable.Class(creator = "StyleSpanCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class StyleSpan extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<StyleSpan> CREATOR = new c(21);

    /* renamed from: a, reason: collision with root package name */
    public final StrokeStyle f10232a;

    /* renamed from: b, reason: collision with root package name */
    public final double f10233b;

    public StyleSpan(StrokeStyle strokeStyle, double d4) {
        if (d4 <= 0.0d) {
            throw new IllegalArgumentException("A style must be applied to some segments on a polyline.");
        }
        this.f10232a = strokeStyle;
        this.f10233b = d4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.T(parcel, 2, this.f10232a, i4);
        J.c0(parcel, 3, 8);
        parcel.writeDouble(this.f10233b);
        J.b0(parcel, iZ);
    }
}
