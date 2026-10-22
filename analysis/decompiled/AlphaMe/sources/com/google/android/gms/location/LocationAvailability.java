package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.k;
import java.util.Arrays;
import t0.J;

@SafeParcelable.Class(creator = "LocationAvailabilityCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class LocationAvailability extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<LocationAvailability> CREATOR = new k(26);

    /* renamed from: a, reason: collision with root package name */
    public final int f10042a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10043b;

    /* renamed from: c, reason: collision with root package name */
    public final long f10044c;

    /* renamed from: d, reason: collision with root package name */
    public final int f10045d;

    /* renamed from: e, reason: collision with root package name */
    public final zzac[] f10046e;

    public LocationAvailability(int i4, int i5, int i6, long j4, zzac[] zzacVarArr) {
        this.f10045d = i4 < 1000 ? 0 : 1000;
        this.f10042a = i5;
        this.f10043b = i6;
        this.f10044c = j4;
        this.f10046e = zzacVarArr;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof LocationAvailability) {
            LocationAvailability locationAvailability = (LocationAvailability) obj;
            if (this.f10042a == locationAvailability.f10042a && this.f10043b == locationAvailability.f10043b && this.f10044c == locationAvailability.f10044c && this.f10045d == locationAvailability.f10045d && Arrays.equals(this.f10046e, locationAvailability.f10046e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f10045d)});
    }

    public final String toString() {
        return "LocationAvailability[" + (this.f10045d < 1000) + "]";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 1, 4);
        parcel.writeInt(this.f10042a);
        J.c0(parcel, 2, 4);
        parcel.writeInt(this.f10043b);
        J.c0(parcel, 3, 8);
        parcel.writeLong(this.f10044c);
        J.c0(parcel, 4, 4);
        parcel.writeInt(this.f10045d);
        J.V(parcel, 5, this.f10046e, i4);
        int i5 = this.f10045d >= 1000 ? 0 : 1;
        J.c0(parcel, 6, 4);
        parcel.writeInt(i5);
        J.b0(parcel, iZ);
    }
}
