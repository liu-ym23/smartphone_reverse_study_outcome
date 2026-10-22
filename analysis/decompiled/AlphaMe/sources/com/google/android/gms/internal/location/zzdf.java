package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.zzt;
import com.google.android.gms.location.zzu;
import t0.J;

@SafeParcelable.Class(creator = "LocationRequestUpdateDataCreator")
@SafeParcelable.Reserved({1000})
@Deprecated
/* loaded from: classes.dex */
public final class zzdf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdf> CREATOR = new com.google.android.gms.common.k(5);

    /* renamed from: a, reason: collision with root package name */
    public final int f9988a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdd f9989b;

    /* renamed from: c, reason: collision with root package name */
    public final zzu f9990c;

    /* renamed from: d, reason: collision with root package name */
    public final com.google.android.gms.location.zzr f9991d;

    /* renamed from: e, reason: collision with root package name */
    public final PendingIntent f9992e;

    /* renamed from: f, reason: collision with root package name */
    public final zzk f9993f;

    /* renamed from: g, reason: collision with root package name */
    public final String f9994g;

    public zzdf(int i4, zzdd zzddVar, IBinder iBinder, IBinder iBinder2, PendingIntent pendingIntent, IBinder iBinder3, String str) {
        this.f9988a = i4;
        this.f9989b = zzddVar;
        zzk zziVar = null;
        this.f9990c = iBinder != null ? zzt.zzb(iBinder) : null;
        this.f9992e = pendingIntent;
        this.f9991d = iBinder2 != null ? com.google.android.gms.location.zzq.zzb(iBinder2) : null;
        if (iBinder3 != null) {
            IInterface iInterfaceQueryLocalInterface = iBinder3.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            zziVar = iInterfaceQueryLocalInterface instanceof zzk ? (zzk) iInterfaceQueryLocalInterface : new zzi(iBinder3);
        }
        this.f9993f = zziVar;
        this.f9994g = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 1, 4);
        parcel.writeInt(this.f9988a);
        J.T(parcel, 2, this.f9989b, i4);
        zzu zzuVar = this.f9990c;
        J.R(parcel, 3, zzuVar == null ? null : zzuVar.asBinder());
        J.T(parcel, 4, this.f9992e, i4);
        com.google.android.gms.location.zzr zzrVar = this.f9991d;
        J.R(parcel, 5, zzrVar == null ? null : zzrVar.asBinder());
        zzk zzkVar = this.f9993f;
        J.R(parcel, 6, zzkVar != null ? zzkVar.asBinder() : null);
        J.U(parcel, 8, this.f9994g);
        J.b0(parcel, iZ);
    }
}
