package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.k;
import com.stepos.statsrpk.c;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import t0.J;

@SafeParcelable.Class(creator = "ActivityTransitionCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public class ActivityTransition extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<ActivityTransition> CREATOR = new k(18);

    /* renamed from: a, reason: collision with root package name */
    public final int f10010a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10011b;

    @Retention(RetentionPolicy.SOURCE)
    public @interface SupportedActivityTransition {
    }

    public ActivityTransition(int i4, int i5) {
        this.f10010a = i4;
        this.f10011b = i5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityTransition)) {
            return false;
        }
        ActivityTransition activityTransition = (ActivityTransition) obj;
        return this.f10010a == activityTransition.f10010a && this.f10011b == activityTransition.f10011b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f10010a), Integer.valueOf(this.f10011b)});
    }

    public final String toString() {
        return "ActivityTransition [mActivityType=" + this.f10010a + ", mTransitionType=" + this.f10011b + "]";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        c.l(parcel);
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 1, 4);
        parcel.writeInt(this.f10010a);
        J.c0(parcel, 2, 4);
        parcel.writeInt(this.f10011b);
        J.b0(parcel, iZ);
    }
}
