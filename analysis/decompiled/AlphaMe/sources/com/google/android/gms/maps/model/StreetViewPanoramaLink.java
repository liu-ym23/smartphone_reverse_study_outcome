package com.google.android.gms.maps.model;

import B0.e;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import t0.J;

@SafeParcelable.Class(creator = "StreetViewPanoramaLinkCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public class StreetViewPanoramaLink extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<StreetViewPanoramaLink> CREATOR = new c(16);

    /* renamed from: a, reason: collision with root package name */
    public final String f10218a;

    /* renamed from: b, reason: collision with root package name */
    public final float f10219b;

    public StreetViewPanoramaLink(String str, float f4) {
        this.f10218a = str;
        this.f10219b = (((double) f4) <= 0.0d ? (f4 % 360.0f) + 360.0f : f4) % 360.0f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaLink)) {
            return false;
        }
        StreetViewPanoramaLink streetViewPanoramaLink = (StreetViewPanoramaLink) obj;
        return this.f10218a.equals(streetViewPanoramaLink.f10218a) && Float.floatToIntBits(this.f10219b) == Float.floatToIntBits(streetViewPanoramaLink.f10219b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f10218a, Float.valueOf(this.f10219b)});
    }

    public final String toString() {
        e eVar = new e(this);
        eVar.a(this.f10218a, "panoId");
        eVar.a(Float.valueOf(this.f10219b), "bearing");
        return eVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.U(parcel, 2, this.f10218a);
        J.c0(parcel, 3, 4);
        parcel.writeFloat(this.f10219b);
        J.b0(parcel, iZ);
    }
}
