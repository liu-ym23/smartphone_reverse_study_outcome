package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.k;
import com.stepos.statsrpk.c;
import java.util.Arrays;
import t0.J;

@SafeParcelable.Class(creator = "SleepSegmentEventCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public class SleepSegmentEvent extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<SleepSegmentEvent> CREATOR = new k(13);

    /* renamed from: a, reason: collision with root package name */
    public final long f10084a;

    /* renamed from: b, reason: collision with root package name */
    public final long f10085b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10086c;

    /* renamed from: d, reason: collision with root package name */
    public final int f10087d;

    /* renamed from: e, reason: collision with root package name */
    public final int f10088e;

    public SleepSegmentEvent(long j4, long j5, int i4, int i5, int i6) {
        c.j("endTimeMillis must be greater than or equal to startTimeMillis", j4 <= j5);
        this.f10084a = j4;
        this.f10085b = j5;
        this.f10086c = i4;
        this.f10087d = i5;
        this.f10088e = i6;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof SleepSegmentEvent) {
            SleepSegmentEvent sleepSegmentEvent = (SleepSegmentEvent) obj;
            if (this.f10084a == sleepSegmentEvent.f10084a && this.f10085b == sleepSegmentEvent.f10085b && this.f10086c == sleepSegmentEvent.f10086c && this.f10087d == sleepSegmentEvent.f10087d && this.f10088e == sleepSegmentEvent.f10088e) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f10084a), Long.valueOf(this.f10085b), Integer.valueOf(this.f10086c)});
    }

    public final String toString() {
        return "startMillis=" + this.f10084a + ", endMillis=" + this.f10085b + ", status=" + this.f10086c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        c.l(parcel);
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 1, 8);
        parcel.writeLong(this.f10084a);
        J.c0(parcel, 2, 8);
        parcel.writeLong(this.f10085b);
        J.c0(parcel, 3, 4);
        parcel.writeInt(this.f10086c);
        J.c0(parcel, 4, 4);
        parcel.writeInt(this.f10087d);
        J.c0(parcel, 5, 4);
        parcel.writeInt(this.f10088e);
        J.b0(parcel, iZ);
    }
}
