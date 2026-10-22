package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.zzo;
import com.google.android.gms.common.zzq;
import com.google.android.gms.common.zzs;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zza;
import h1.AbstractC0588a;

/* loaded from: classes.dex */
public final class zzad extends zza implements zzaf {
    public zzad(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override // com.google.android.gms.common.internal.zzaf
    public final zzq zze(zzo zzoVar) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0588a.c(parcelZza, zzoVar);
        Parcel parcelZzB = zzB(6, parcelZza);
        zzq zzqVar = (zzq) AbstractC0588a.a(parcelZzB, zzq.CREATOR);
        parcelZzB.recycle();
        return zzqVar;
    }

    @Override // com.google.android.gms.common.internal.zzaf
    public final zzq zzf(zzo zzoVar) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0588a.c(parcelZza, zzoVar);
        Parcel parcelZzB = zzB(8, parcelZza);
        zzq zzqVar = (zzq) AbstractC0588a.a(parcelZzB, zzq.CREATOR);
        parcelZzB.recycle();
        return zzqVar;
    }

    @Override // com.google.android.gms.common.internal.zzaf
    public final boolean zzg() throws RemoteException {
        Parcel parcelZzB = zzB(9, zza());
        boolean zE = AbstractC0588a.e(parcelZzB);
        parcelZzB.recycle();
        return zE;
    }

    @Override // com.google.android.gms.common.internal.zzaf
    public final boolean zzh(zzs zzsVar, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0588a.c(parcelZza, zzsVar);
        AbstractC0588a.d(parcelZza, iObjectWrapper);
        Parcel parcelZzB = zzB(5, parcelZza);
        boolean zE = AbstractC0588a.e(parcelZzB);
        parcelZzB.recycle();
        return zE;
    }

    @Override // com.google.android.gms.common.internal.zzaf
    public final boolean zzi() throws RemoteException {
        Parcel parcelZzB = zzB(7, zza());
        boolean zE = AbstractC0588a.e(parcelZzB);
        parcelZzB.recycle();
        return zE;
    }
}
