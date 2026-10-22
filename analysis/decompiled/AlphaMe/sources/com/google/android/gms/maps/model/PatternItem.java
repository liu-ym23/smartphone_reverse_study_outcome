package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.airbnb.lottie.h;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.stepos.alphame.utils.Property;
import java.util.Arrays;
import t0.J;

@SafeParcelable.Class(creator = "PatternItemCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public class PatternItem extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<PatternItem> CREATOR = new c(10);

    /* renamed from: a, reason: collision with root package name */
    public final int f10186a;

    /* renamed from: b, reason: collision with root package name */
    public final Float f10187b;

    public PatternItem(int i4, Float f4) {
        boolean z4 = true;
        if (i4 != 1 && (f4 == null || f4.floatValue() < Property.DEFAULT_FLOAT_VALUE)) {
            z4 = false;
        }
        com.stepos.statsrpk.c.j("Invalid PatternItem: type=" + i4 + " length=" + f4, z4);
        this.f10186a = i4;
        this.f10187b = f4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PatternItem)) {
            return false;
        }
        PatternItem patternItem = (PatternItem) obj;
        return this.f10186a == patternItem.f10186a && h.m(this.f10187b, patternItem.f10187b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f10186a), this.f10187b});
    }

    public String toString() {
        return "[PatternItem: type=" + this.f10186a + " length=" + this.f10187b + "]";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 2, 4);
        parcel.writeInt(this.f10186a);
        J.Q(parcel, 3, this.f10187b);
        J.b0(parcel, iZ);
    }
}
