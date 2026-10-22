package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.k;
import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.statsrpk.c;
import java.util.Arrays;
import t0.J;

@SafeParcelable.Class(creator = "ActivityTransitionEventCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public class ActivityTransitionEvent extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<ActivityTransitionEvent> CREATOR = new k(19);

    /* renamed from: a, reason: collision with root package name */
    public final int f10012a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10013b;

    /* renamed from: c, reason: collision with root package name */
    public final long f10014c;

    public ActivityTransitionEvent(int i4, int i5, long j4) {
        boolean z4 = false;
        if (i5 >= 0 && i5 <= 1) {
            z4 = true;
        }
        c.j("Transition type " + i5 + " is not valid.", z4);
        this.f10012a = i4;
        this.f10013b = i5;
        this.f10014c = j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityTransitionEvent)) {
            return false;
        }
        ActivityTransitionEvent activityTransitionEvent = (ActivityTransitionEvent) obj;
        return this.f10012a == activityTransitionEvent.f10012a && this.f10013b == activityTransitionEvent.f10013b && this.f10014c == activityTransitionEvent.f10014c;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f10012a), Integer.valueOf(this.f10013b), Long.valueOf(this.f10014c)});
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ActivityType " + this.f10012a);
        sb.append(AwarenessDataItem.PERMISSION_SPLITTER);
        sb.append("TransitionType " + this.f10013b);
        sb.append(AwarenessDataItem.PERMISSION_SPLITTER);
        sb.append("ElapsedRealTimeNanos " + this.f10014c);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        c.l(parcel);
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 1, 4);
        parcel.writeInt(this.f10012a);
        J.c0(parcel, 2, 4);
        parcel.writeInt(this.f10013b);
        J.c0(parcel, 3, 8);
        parcel.writeLong(this.f10014c);
        J.b0(parcel, iZ);
    }
}
