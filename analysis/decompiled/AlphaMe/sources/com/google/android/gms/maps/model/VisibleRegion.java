package com.google.android.gms.maps.model;

import B0.e;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import t0.J;

@SafeParcelable.Class(creator = "VisibleRegionCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class VisibleRegion extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<VisibleRegion> CREATOR = new c(2);

    /* renamed from: a, reason: collision with root package name */
    public final LatLng f10242a;

    /* renamed from: b, reason: collision with root package name */
    public final LatLng f10243b;

    /* renamed from: c, reason: collision with root package name */
    public final LatLng f10244c;

    /* renamed from: d, reason: collision with root package name */
    public final LatLng f10245d;

    /* renamed from: e, reason: collision with root package name */
    public final LatLngBounds f10246e;

    public VisibleRegion(LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4, LatLngBounds latLngBounds) {
        this.f10242a = latLng;
        this.f10243b = latLng2;
        this.f10244c = latLng3;
        this.f10245d = latLng4;
        this.f10246e = latLngBounds;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VisibleRegion)) {
            return false;
        }
        VisibleRegion visibleRegion = (VisibleRegion) obj;
        return this.f10242a.equals(visibleRegion.f10242a) && this.f10243b.equals(visibleRegion.f10243b) && this.f10244c.equals(visibleRegion.f10244c) && this.f10245d.equals(visibleRegion.f10245d) && this.f10246e.equals(visibleRegion.f10246e);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f10242a, this.f10243b, this.f10244c, this.f10245d, this.f10246e});
    }

    public final String toString() {
        e eVar = new e(this);
        eVar.a(this.f10242a, "nearLeft");
        eVar.a(this.f10243b, "nearRight");
        eVar.a(this.f10244c, "farLeft");
        eVar.a(this.f10245d, "farRight");
        eVar.a(this.f10246e, "latLngBounds");
        return eVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.T(parcel, 2, this.f10242a, i4);
        J.T(parcel, 3, this.f10243b, i4);
        J.T(parcel, 4, this.f10244c, i4);
        J.T(parcel, 5, this.f10245d, i4);
        J.T(parcel, 6, this.f10246e, i4);
        J.b0(parcel, iZ);
    }
}
