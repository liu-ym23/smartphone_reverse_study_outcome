package com.google.android.gms.maps.model;

import B0.e;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.stepos.alphame.utils.Property;
import java.util.Arrays;
import t0.J;

@SafeParcelable.Class(creator = "StreetViewPanoramaOrientationCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public class StreetViewPanoramaOrientation extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<StreetViewPanoramaOrientation> CREATOR = new c(18);

    /* renamed from: a, reason: collision with root package name */
    public final float f10223a;

    /* renamed from: b, reason: collision with root package name */
    public final float f10224b;

    public StreetViewPanoramaOrientation(float f4, float f5) {
        boolean z4 = false;
        if (f4 >= -90.0f && f4 <= 90.0f) {
            z4 = true;
        }
        com.stepos.statsrpk.c.j("Tilt needs to be between -90 and 90 inclusive: " + f4, z4);
        this.f10223a = f4 + Property.DEFAULT_FLOAT_VALUE;
        this.f10224b = (((double) f5) <= 0.0d ? (f5 % 360.0f) + 360.0f : f5) % 360.0f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaOrientation)) {
            return false;
        }
        StreetViewPanoramaOrientation streetViewPanoramaOrientation = (StreetViewPanoramaOrientation) obj;
        return Float.floatToIntBits(this.f10223a) == Float.floatToIntBits(streetViewPanoramaOrientation.f10223a) && Float.floatToIntBits(this.f10224b) == Float.floatToIntBits(streetViewPanoramaOrientation.f10224b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f10223a), Float.valueOf(this.f10224b)});
    }

    public final String toString() {
        e eVar = new e(this);
        eVar.a(Float.valueOf(this.f10223a), "tilt");
        eVar.a(Float.valueOf(this.f10224b), "bearing");
        return eVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 2, 4);
        parcel.writeFloat(this.f10223a);
        J.c0(parcel, 3, 4);
        parcel.writeFloat(this.f10224b);
        J.b0(parcel, iZ);
    }
}
