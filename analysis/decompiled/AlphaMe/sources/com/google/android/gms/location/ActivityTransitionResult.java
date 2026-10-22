package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.k;
import com.stepos.statsrpk.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import t0.J;

@SafeParcelable.Class(creator = "ActivityTransitionResultCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public class ActivityTransitionResult extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<ActivityTransitionResult> CREATOR = new k(21);

    /* renamed from: a, reason: collision with root package name */
    public final List f10020a;

    /* renamed from: b, reason: collision with root package name */
    public final Bundle f10021b;

    public ActivityTransitionResult(ArrayList arrayList, Bundle bundle) {
        this.f10021b = null;
        c.m(arrayList, "transitionEvents list can't be null.");
        if (!arrayList.isEmpty()) {
            for (int i4 = 1; i4 < arrayList.size(); i4++) {
                if (((ActivityTransitionEvent) arrayList.get(i4)).f10014c < ((ActivityTransitionEvent) arrayList.get(i4 - 1)).f10014c) {
                    throw new IllegalArgumentException();
                }
            }
        }
        this.f10020a = Collections.unmodifiableList(arrayList);
        this.f10021b = bundle;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f10020a.equals(((ActivityTransitionResult) obj).f10020a);
    }

    public final int hashCode() {
        return this.f10020a.hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        c.l(parcel);
        int iZ = J.Z(parcel, 20293);
        J.W(parcel, 1, this.f10020a);
        J.P(parcel, 2, this.f10021b);
        J.b0(parcel, iZ);
    }
}
