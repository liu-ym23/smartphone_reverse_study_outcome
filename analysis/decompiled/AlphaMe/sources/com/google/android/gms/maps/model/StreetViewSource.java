package com.google.android.gms.maps.model;

import B0.g;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import t0.J;

@SafeParcelable.Class(creator = "StreetViewSourceCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class StreetViewSource extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<StreetViewSource> CREATOR = new c(19);

    /* renamed from: b, reason: collision with root package name */
    public static final StreetViewSource f10225b = new StreetViewSource(0);

    /* renamed from: a, reason: collision with root package name */
    public final int f10226a;

    public StreetViewSource(int i4) {
        this.f10226a = i4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StreetViewSource) && this.f10226a == ((StreetViewSource) obj).f10226a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f10226a)});
    }

    public final String toString() {
        int i4 = this.f10226a;
        return "StreetViewSource:".concat(i4 != 0 ? i4 != 1 ? g.j("UNKNOWN(", i4, ")") : "OUTDOOR" : "DEFAULT");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 2, 4);
        parcel.writeInt(this.f10226a);
        J.b0(parcel, iZ);
    }
}
