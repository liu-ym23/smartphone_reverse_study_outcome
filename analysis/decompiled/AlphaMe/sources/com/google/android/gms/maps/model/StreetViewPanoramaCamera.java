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

@SafeParcelable.Class(creator = "StreetViewPanoramaCameraCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public class StreetViewPanoramaCamera extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<StreetViewPanoramaCamera> CREATOR = new c(15);

    /* renamed from: a, reason: collision with root package name */
    public final float f10215a;

    /* renamed from: b, reason: collision with root package name */
    public final float f10216b;

    /* renamed from: c, reason: collision with root package name */
    public final float f10217c;

    public StreetViewPanoramaCamera(float f4, float f5, float f6) {
        boolean z4 = false;
        if (f5 >= -90.0f && f5 <= 90.0f) {
            z4 = true;
        }
        com.stepos.statsrpk.c.j("Tilt needs to be between -90 and 90 inclusive: " + f5, z4);
        this.f10215a = ((double) f4) <= 0.0d ? 0.0f : f4;
        this.f10216b = Property.DEFAULT_FLOAT_VALUE + f5;
        this.f10217c = (((double) f6) <= 0.0d ? (f6 % 360.0f) + 360.0f : f6) % 360.0f;
        new StreetViewPanoramaOrientation(f5, f6);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaCamera)) {
            return false;
        }
        StreetViewPanoramaCamera streetViewPanoramaCamera = (StreetViewPanoramaCamera) obj;
        return Float.floatToIntBits(this.f10215a) == Float.floatToIntBits(streetViewPanoramaCamera.f10215a) && Float.floatToIntBits(this.f10216b) == Float.floatToIntBits(streetViewPanoramaCamera.f10216b) && Float.floatToIntBits(this.f10217c) == Float.floatToIntBits(streetViewPanoramaCamera.f10217c);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f10215a), Float.valueOf(this.f10216b), Float.valueOf(this.f10217c)});
    }

    public final String toString() {
        e eVar = new e(this);
        eVar.a(Float.valueOf(this.f10215a), "zoom");
        eVar.a(Float.valueOf(this.f10216b), "tilt");
        eVar.a(Float.valueOf(this.f10217c), "bearing");
        return eVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 2, 4);
        parcel.writeFloat(this.f10215a);
        J.c0(parcel, 3, 4);
        parcel.writeFloat(this.f10216b);
        J.c0(parcel, 4, 4);
        parcel.writeFloat(this.f10217c);
        J.b0(parcel, iZ);
    }
}
