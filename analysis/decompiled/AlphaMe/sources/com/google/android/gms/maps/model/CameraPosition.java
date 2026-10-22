package com.google.android.gms.maps.model;

import B0.e;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.stepos.alphame.utils.Property;
import java.util.Arrays;
import t0.J;

@SafeParcelable.Class(creator = "CameraPositionCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class CameraPosition extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<CameraPosition> CREATOR = new c(0);

    /* renamed from: a, reason: collision with root package name */
    public final LatLng f10137a;

    /* renamed from: b, reason: collision with root package name */
    public final float f10138b;

    /* renamed from: c, reason: collision with root package name */
    public final float f10139c;

    /* renamed from: d, reason: collision with root package name */
    public final float f10140d;

    public CameraPosition(LatLng latLng, float f4, float f5, float f6) {
        com.stepos.statsrpk.c.m(latLng, "camera target must not be null.");
        boolean z4 = false;
        if (f5 >= Property.DEFAULT_FLOAT_VALUE && f5 <= 90.0f) {
            z4 = true;
        }
        if (!z4) {
            throw new IllegalArgumentException("Tilt needs to be between 0 and 90 inclusive: " + f5);
        }
        this.f10137a = latLng;
        this.f10138b = f4;
        this.f10139c = f5 + Property.DEFAULT_FLOAT_VALUE;
        this.f10140d = (((double) f6) <= 0.0d ? (f6 % 360.0f) + 360.0f : f6) % 360.0f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraPosition)) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) obj;
        return this.f10137a.equals(cameraPosition.f10137a) && Float.floatToIntBits(this.f10138b) == Float.floatToIntBits(cameraPosition.f10138b) && Float.floatToIntBits(this.f10139c) == Float.floatToIntBits(cameraPosition.f10139c) && Float.floatToIntBits(this.f10140d) == Float.floatToIntBits(cameraPosition.f10140d);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f10137a, Float.valueOf(this.f10138b), Float.valueOf(this.f10139c), Float.valueOf(this.f10140d)});
    }

    public final String toString() {
        e eVar = new e(this);
        eVar.a(this.f10137a, "target");
        eVar.a(Float.valueOf(this.f10138b), "zoom");
        eVar.a(Float.valueOf(this.f10139c), "tilt");
        eVar.a(Float.valueOf(this.f10140d), "bearing");
        return eVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.T(parcel, 2, this.f10137a, i4);
        J.c0(parcel, 3, 4);
        parcel.writeFloat(this.f10138b);
        J.c0(parcel, 4, 4);
        parcel.writeFloat(this.f10139c);
        J.c0(parcel, 5, 4);
        parcel.writeFloat(this.f10140d);
        J.b0(parcel, iZ);
    }
}
