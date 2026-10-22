package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import i1.AbstractC0619a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class zzp extends zza implements zzr {
    public zzp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final int zzd() throws RemoteException {
        Parcel parcelZzH = zzH(1, zza());
        int i4 = parcelZzH.readInt();
        parcelZzH.recycle();
        return i4;
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final int zze() throws RemoteException {
        Parcel parcelZzH = zzH(2, zza());
        int i4 = parcelZzH.readInt();
        parcelZzH.recycle();
        return i4;
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final int zzf() throws RemoteException {
        Parcel parcelZzH = zzH(6, zza());
        int i4 = parcelZzH.readInt();
        parcelZzH.recycle();
        return i4;
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final List zzg() throws RemoteException {
        Parcel parcelZzH = zzH(3, zza());
        ArrayList<IBinder> arrayListCreateBinderArrayList = parcelZzH.createBinderArrayList();
        parcelZzH.recycle();
        return arrayListCreateBinderArrayList;
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final boolean zzh(zzr zzrVar) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0619a.d(parcelZza, zzrVar);
        Parcel parcelZzH = zzH(5, parcelZza);
        boolean zE = AbstractC0619a.e(parcelZzH);
        parcelZzH.recycle();
        return zE;
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final boolean zzi() throws RemoteException {
        Parcel parcelZzH = zzH(4, zza());
        boolean zE = AbstractC0619a.e(parcelZzH);
        parcelZzH.recycle();
        return zE;
    }
}
