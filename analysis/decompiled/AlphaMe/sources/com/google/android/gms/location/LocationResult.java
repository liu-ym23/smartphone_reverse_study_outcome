package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.k;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import t0.J;

@SafeParcelable.Class(creator = "LocationResultCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class LocationResult extends AbstractSafeParcelable implements ReflectedParcelable {

    /* renamed from: a, reason: collision with root package name */
    public final List f10063a;

    /* renamed from: b, reason: collision with root package name */
    public static final List f10062b = Collections.emptyList();

    @NonNull
    public static final Parcelable.Creator<LocationResult> CREATOR = new k(28);

    public LocationResult(List list) {
        this.f10063a = list;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof LocationResult) {
            return this.f10063a.equals(((LocationResult) obj).f10063a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f10063a});
    }

    public final String toString() {
        return "LocationResult".concat(String.valueOf(this.f10063a));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.W(parcel, 1, this.f10063a);
        J.b0(parcel, iZ);
    }
}
