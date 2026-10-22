package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.zzo;
import com.google.android.gms.common.zzq;
import com.google.android.gms.common.zzs;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zza;
import x2.C5845a;

/* loaded from: classes2.dex */
public final class zzae extends zza implements zzag {
    public zzae(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override // com.google.android.gms.common.internal.zzag
    public final zzq zze(zzo zzoVar) throws RemoteException {
        Parcel parcelZza = zza();
        C5845a.c(parcelZza, zzoVar);
        Parcel parcelZzB = zzB(6, parcelZza);
        zzq zzqVar = (zzq) C5845a.a(parcelZzB, zzq.CREATOR);
        parcelZzB.recycle();
        return zzqVar;
    }

    @Override // com.google.android.gms.common.internal.zzag
    public final zzq zzf(zzo zzoVar) throws RemoteException {
        Parcel parcelZza = zza();
        C5845a.c(parcelZza, zzoVar);
        Parcel parcelZzB = zzB(8, parcelZza);
        zzq zzqVar = (zzq) C5845a.a(parcelZzB, zzq.CREATOR);
        parcelZzB.recycle();
        return zzqVar;
    }

    @Override // com.google.android.gms.common.internal.zzag
    public final boolean zzg() throws RemoteException {
        Parcel parcelZzB = zzB(9, zza());
        boolean zF = C5845a.f(parcelZzB);
        parcelZzB.recycle();
        return zF;
    }

    @Override // com.google.android.gms.common.internal.zzag
    public final boolean zzh(zzs zzsVar, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        C5845a.c(parcelZza, zzsVar);
        C5845a.e(parcelZza, iObjectWrapper);
        Parcel parcelZzB = zzB(5, parcelZza);
        boolean zF = C5845a.f(parcelZzB);
        parcelZzB.recycle();
        return zF;
    }

    @Override // com.google.android.gms.common.internal.zzag
    public final boolean zzi() throws RemoteException {
        Parcel parcelZzB = zzB(7, zza());
        boolean zF = C5845a.f(parcelZzB);
        parcelZzB.recycle();
        return zF;
    }
}
