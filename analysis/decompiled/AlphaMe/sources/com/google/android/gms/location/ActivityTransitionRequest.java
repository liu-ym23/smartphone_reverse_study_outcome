package com.google.android.gms.location;

import A.f;
import B0.g;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.room.AbstractC0351g;
import com.airbnb.lottie.h;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.k;
import com.stepos.statsrpk.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import t0.J;

@SafeParcelable.Class(creator = "ActivityTransitionRequestCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public class ActivityTransitionRequest extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<ActivityTransitionRequest> CREATOR = new k(20);

    /* renamed from: e, reason: collision with root package name */
    public static final f f10015e = new f(4);

    /* renamed from: a, reason: collision with root package name */
    public final List f10016a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10017b;

    /* renamed from: c, reason: collision with root package name */
    public final List f10018c;

    /* renamed from: d, reason: collision with root package name */
    public final String f10019d;

    public ActivityTransitionRequest(ArrayList arrayList, String str, ArrayList arrayList2, String str2) {
        c.m(arrayList, "transitions can't be null");
        c.j("transitions can't be empty.", arrayList.size() > 0);
        TreeSet treeSet = new TreeSet(f10015e);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ActivityTransition activityTransition = (ActivityTransition) it.next();
            c.j(String.format("Found duplicated transition: %s.", activityTransition), treeSet.add(activityTransition));
        }
        this.f10016a = Collections.unmodifiableList(arrayList);
        this.f10017b = str;
        this.f10018c = arrayList2 == null ? Collections.emptyList() : Collections.unmodifiableList(arrayList2);
        this.f10019d = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ActivityTransitionRequest activityTransitionRequest = (ActivityTransitionRequest) obj;
            if (h.m(this.f10016a, activityTransitionRequest.f10016a) && h.m(this.f10017b, activityTransitionRequest.f10017b) && h.m(this.f10019d, activityTransitionRequest.f10019d) && h.m(this.f10018c, activityTransitionRequest.f10018c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.f10016a.hashCode() * 31;
        String str = this.f10017b;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        List list = this.f10018c;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.f10019d;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f10016a);
        String strValueOf2 = String.valueOf(this.f10018c);
        StringBuilder sbW = g.w("ActivityTransitionRequest [mTransitions=", strValueOf, ", mTag='");
        AbstractC0351g.C(sbW, this.f10017b, "', mClients=", strValueOf2, ", mAttributionTag=");
        return g.r(sbW, this.f10019d, "]");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        c.l(parcel);
        int iZ = J.Z(parcel, 20293);
        J.W(parcel, 1, this.f10016a);
        J.U(parcel, 2, this.f10017b);
        J.W(parcel, 3, this.f10018c);
        J.U(parcel, 4, this.f10019d);
        J.b0(parcel, iZ);
    }
}
