package com.google.android.gms.maps.model;

import B0.e;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.stepos.alphame.suggest.AppSuggestStorable;
import java.util.Arrays;
import t0.J;

@SafeParcelable.Class(creator = "StreetViewPanoramaLocationCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public class StreetViewPanoramaLocation extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<StreetViewPanoramaLocation> CREATOR = new c(17);

    /* renamed from: a, reason: collision with root package name */
    public final StreetViewPanoramaLink[] f10220a;

    /* renamed from: b, reason: collision with root package name */
    public final LatLng f10221b;

    /* renamed from: c, reason: collision with root package name */
    public final String f10222c;

    public StreetViewPanoramaLocation(StreetViewPanoramaLink[] streetViewPanoramaLinkArr, LatLng latLng, String str) {
        this.f10220a = streetViewPanoramaLinkArr;
        this.f10221b = latLng;
        this.f10222c = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaLocation)) {
            return false;
        }
        StreetViewPanoramaLocation streetViewPanoramaLocation = (StreetViewPanoramaLocation) obj;
        return this.f10222c.equals(streetViewPanoramaLocation.f10222c) && this.f10221b.equals(streetViewPanoramaLocation.f10221b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f10221b, this.f10222c});
    }

    public final String toString() {
        e eVar = new e(this);
        eVar.a(this.f10222c, "panoId");
        eVar.a(this.f10221b.toString(), AppSuggestStorable.COLUMN_POSITION);
        return eVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.V(parcel, 2, this.f10220a, i4);
        J.T(parcel, 3, this.f10221b, i4);
        J.U(parcel, 4, this.f10222c);
        J.b0(parcel, iZ);
    }
}
