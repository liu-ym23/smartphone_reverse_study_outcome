package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public abstract class zzj extends zzb implements zzk {
    public zzj() {
        super("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
    }

    @Override // com.google.android.gms.internal.location.zzb
    public final boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        if (i4 == 1) {
            zzg zzgVar = (zzg) b.a(parcel, zzg.CREATOR);
            b.b(parcel);
            zzd(zzgVar);
        } else {
            if (i4 != 2) {
                return false;
            }
            zze();
        }
        return true;
    }
}
