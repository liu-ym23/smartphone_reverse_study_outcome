package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import t0.J;

@SafeParcelable.Class(creator = "LocationReceiverCreator")
/* loaded from: classes.dex */
public final class zzdb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdb> CREATOR = new com.google.android.gms.common.k(3);

    /* renamed from: a, reason: collision with root package name */
    public final int f9982a;

    /* renamed from: b, reason: collision with root package name */
    public final IBinder f9983b;

    /* renamed from: c, reason: collision with root package name */
    public final IBinder f9984c;

    /* renamed from: d, reason: collision with root package name */
    public final PendingIntent f9985d;

    /* renamed from: e, reason: collision with root package name */
    public final String f9986e;

    public zzdb(int i4, IBinder iBinder, IBinder iBinder2, PendingIntent pendingIntent, String str) {
        this.f9982a = i4;
        this.f9983b = iBinder;
        this.f9984c = iBinder2;
        this.f9985d = pendingIntent;
        this.f9986e = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 1, 4);
        parcel.writeInt(this.f9982a);
        J.R(parcel, 2, this.f9983b);
        J.R(parcel, 3, this.f9984c);
        J.T(parcel, 4, this.f9985d, i4);
        J.U(parcel, 6, this.f9986e);
        J.b0(parcel, iZ);
    }
}
