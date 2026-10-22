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

@SafeParcelable.Class(creator = "SleepClassifyEventCreator")
/* loaded from: classes.dex */
public class SleepClassifyEvent extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<SleepClassifyEvent> CREATOR = new k(12);

    /* renamed from: a, reason: collision with root package name */
    public final int f10075a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10076b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10077c;

    /* renamed from: d, reason: collision with root package name */
    public final int f10078d;

    /* renamed from: e, reason: collision with root package name */
    public final int f10079e;

    /* renamed from: f, reason: collision with root package name */
    public final int f10080f;

    /* renamed from: g, reason: collision with root package name */
    public final int f10081g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f10082h;

    /* renamed from: i, reason: collision with root package name */
    public final int f10083i;

    public SleepClassifyEvent(int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, boolean z4) {
        this.f10075a = i4;
        this.f10076b = i5;
        this.f10077c = i6;
        this.f10078d = i7;
        this.f10079e = i8;
        this.f10080f = i9;
        this.f10081g = i10;
        this.f10082h = z4;
        this.f10083i = i11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SleepClassifyEvent)) {
            return false;
        }
        SleepClassifyEvent sleepClassifyEvent = (SleepClassifyEvent) obj;
        return this.f10075a == sleepClassifyEvent.f10075a && this.f10076b == sleepClassifyEvent.f10076b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f10075a), Integer.valueOf(this.f10076b)});
    }

    public final String toString() {
        return this.f10075a + " Conf:" + this.f10076b + " Motion:" + this.f10077c + " Light:" + this.f10078d;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        c.l(parcel);
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 1, 4);
        parcel.writeInt(this.f10075a);
        J.c0(parcel, 2, 4);
        parcel.writeInt(this.f10076b);
        J.c0(parcel, 3, 4);
        parcel.writeInt(this.f10077c);
        J.c0(parcel, 4, 4);
        parcel.writeInt(this.f10078d);
        J.c0(parcel, 5, 4);
        parcel.writeInt(this.f10079e);
        J.c0(parcel, 6, 4);
        parcel.writeInt(this.f10080f);
        J.c0(parcel, 7, 4);
        parcel.writeInt(this.f10081g);
        J.c0(parcel, 8, 4);
        parcel.writeInt(this.f10082h ? 1 : 0);
        J.c0(parcel, 9, 4);
        parcel.writeInt(this.f10083i);
        J.b0(parcel, iZ);
    }
}
