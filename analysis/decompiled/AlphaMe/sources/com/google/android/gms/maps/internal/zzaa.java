package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import i1.AbstractC0619a;

/* loaded from: classes.dex */
public abstract class zzaa extends com.google.android.gms.internal.maps.zzb implements zzab {
    public zzaa() {
        super("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    public final boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        if (i4 == 1) {
            zzb();
        } else {
            if (i4 != 2) {
                return false;
            }
            com.google.android.gms.internal.maps.zzr zzrVarZzb = com.google.android.gms.internal.maps.zzq.zzb(parcel.readStrongBinder());
            AbstractC0619a.b(parcel);
            zzc(zzrVarZzb);
        }
        parcel2.writeNoException();
        return true;
    }
}
