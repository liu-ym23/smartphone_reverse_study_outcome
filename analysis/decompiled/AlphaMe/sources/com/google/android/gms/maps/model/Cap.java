package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.NonNull;
import com.airbnb.lottie.h;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.stepos.alphame.utils.Property;
import java.util.Arrays;
import s.AbstractC0831a;
import t0.J;

@SafeParcelable.Class(creator = "CapCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public class Cap extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<Cap> CREATOR = new c(3);

    /* renamed from: a, reason: collision with root package name */
    public final int f10141a;

    /* renamed from: b, reason: collision with root package name */
    public final a f10142b;

    /* renamed from: c, reason: collision with root package name */
    public final Float f10143c;

    public Cap(int i4, a aVar, Float f4) {
        boolean z4 = f4 != null && f4.floatValue() > Property.DEFAULT_FLOAT_VALUE;
        if (i4 == 3) {
            z = aVar != null && z4;
            i4 = 3;
        }
        com.stepos.statsrpk.c.j("Invalid Cap: type=" + i4 + " bitmapDescriptor=" + aVar + " bitmapRefWidth=" + f4, z);
        this.f10141a = i4;
        this.f10142b = aVar;
        this.f10143c = f4;
    }

    public final Cap N() {
        int i4 = this.f10141a;
        if (i4 == 0) {
            return new ButtCap();
        }
        if (i4 == 1) {
            return new SquareCap(1, null, null);
        }
        if (i4 == 2) {
            return new RoundCap(2, null, null);
        }
        if (i4 != 3) {
            Log.w("Cap", "Unknown Cap type: " + i4);
            return this;
        }
        a aVar = this.f10142b;
        com.stepos.statsrpk.c.n("bitmapDescriptor must not be null", aVar != null);
        Float f4 = this.f10143c;
        com.stepos.statsrpk.c.n("bitmapRefWidth must not be null", f4 != null);
        return new CustomCap(aVar, f4.floatValue());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cap)) {
            return false;
        }
        Cap cap = (Cap) obj;
        return this.f10141a == cap.f10141a && h.m(this.f10142b, cap.f10142b) && h.m(this.f10143c, cap.f10143c);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f10141a), this.f10142b, this.f10143c});
    }

    public String toString() {
        return AbstractC0831a.d(new StringBuilder("[Cap: type="), this.f10141a, "]");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 2, 4);
        parcel.writeInt(this.f10141a);
        a aVar = this.f10142b;
        J.R(parcel, 3, aVar == null ? null : aVar.f10247a.asBinder());
        J.Q(parcel, 4, this.f10143c);
        J.b0(parcel, iZ);
    }
}
