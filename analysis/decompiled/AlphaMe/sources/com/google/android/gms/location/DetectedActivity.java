package com.google.android.gms.location;

import B0.g;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.k;
import com.stepos.statsrpk.c;
import java.util.Arrays;
import s.AbstractC0831a;
import t0.J;

@SafeParcelable.Class(creator = "DetectedActivityCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public class DetectedActivity extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<DetectedActivity> CREATOR = new k(23);

    /* renamed from: a, reason: collision with root package name */
    public int f10031a;

    /* renamed from: b, reason: collision with root package name */
    public int f10032b;

    public final boolean equals(Object obj) {
        if (obj instanceof DetectedActivity) {
            DetectedActivity detectedActivity = (DetectedActivity) obj;
            if (this.f10031a == detectedActivity.f10031a && this.f10032b == detectedActivity.f10032b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f10031a), Integer.valueOf(this.f10032b)});
    }

    public final String toString() {
        int i4 = this.f10031a;
        if (i4 > 22 || i4 < 0) {
            i4 = 4;
        }
        return AbstractC0831a.d(g.w("DetectedActivity [type=", i4 != 0 ? i4 != 1 ? i4 != 2 ? i4 != 3 ? i4 != 4 ? i4 != 5 ? i4 != 7 ? i4 != 8 ? i4 != 16 ? i4 != 17 ? Integer.toString(i4) : "IN_RAIL_VEHICLE" : "IN_ROAD_VEHICLE" : "RUNNING" : "WALKING" : "TILTING" : "UNKNOWN" : "STILL" : "ON_FOOT" : "ON_BICYCLE" : "IN_VEHICLE", ", confidence="), this.f10032b, "]");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        c.l(parcel);
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 1, 4);
        parcel.writeInt(this.f10031a);
        J.c0(parcel, 2, 4);
        parcel.writeInt(this.f10032b);
        J.b0(parcel, iZ);
    }
}
