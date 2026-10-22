package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.airbnb.lottie.h;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.k;
import com.stepos.statsrpk.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import t0.J;

@SafeParcelable.Class(creator = "SleepSegmentRequestCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public class SleepSegmentRequest extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<SleepSegmentRequest> CREATOR = new k(14);

    /* renamed from: a, reason: collision with root package name */
    public final List f10089a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10090b;

    public SleepSegmentRequest(int i4, ArrayList arrayList) {
        this.f10089a = arrayList;
        this.f10090b = i4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SleepSegmentRequest)) {
            return false;
        }
        SleepSegmentRequest sleepSegmentRequest = (SleepSegmentRequest) obj;
        return h.m(this.f10089a, sleepSegmentRequest.f10089a) && this.f10090b == sleepSegmentRequest.f10090b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f10089a, Integer.valueOf(this.f10090b)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        c.l(parcel);
        int iZ = J.Z(parcel, 20293);
        J.W(parcel, 1, this.f10089a);
        J.c0(parcel, 2, 4);
        parcel.writeInt(this.f10090b);
        J.b0(parcel, iZ);
    }
}
