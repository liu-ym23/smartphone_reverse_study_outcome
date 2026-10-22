package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import i1.AbstractC0619a;

/* loaded from: classes.dex */
public final class zzs extends zza implements zzu {
    public zzs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
    }

    @Override // com.google.android.gms.internal.maps.zzu
    public final int zzd() throws RemoteException {
        Parcel parcelZzH = zzH(5, zza());
        int i4 = parcelZzH.readInt();
        parcelZzH.recycle();
        return i4;
    }

    @Override // com.google.android.gms.internal.maps.zzu
    public final String zze() throws RemoteException {
        Parcel parcelZzH = zzH(1, zza());
        String string = parcelZzH.readString();
        parcelZzH.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.maps.zzu
    public final String zzf() throws RemoteException {
        Parcel parcelZzH = zzH(2, zza());
        String string = parcelZzH.readString();
        parcelZzH.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.maps.zzu
    public final void zzg() throws RemoteException {
        zzc(3, zza());
    }

    @Override // com.google.android.gms.internal.maps.zzu
    public final boolean zzh(zzu zzuVar) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0619a.d(parcelZza, zzuVar);
        Parcel parcelZzH = zzH(4, parcelZza);
        boolean zE = AbstractC0619a.e(parcelZzH);
        parcelZzH.recycle();
        return zE;
    }
}
