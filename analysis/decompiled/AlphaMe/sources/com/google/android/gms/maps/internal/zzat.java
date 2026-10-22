package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import i1.AbstractC0619a;

/* loaded from: classes.dex */
public abstract class zzat extends com.google.android.gms.internal.maps.zzb implements zzau {
    public zzat() {
        super("com.google.android.gms.maps.internal.IOnMarkerClickListener");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    public final boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        if (i4 != 1) {
            return false;
        }
        com.google.android.gms.internal.maps.zzaa zzaaVarZzb = com.google.android.gms.internal.maps.zzz.zzb(parcel.readStrongBinder());
        AbstractC0619a.b(parcel);
        boolean zZzb = zzb(zzaaVarZzb);
        parcel2.writeNoException();
        parcel2.writeInt(zZzb ? 1 : 0);
        return true;
    }
}
