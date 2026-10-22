package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import i1.AbstractC0619a;

/* loaded from: classes.dex */
public abstract class zzbh extends com.google.android.gms.internal.maps.zzb implements zzbi {
    public zzbh() {
        super("com.google.android.gms.maps.internal.IOnPolylineClickListener");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    public final boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        if (i4 != 1) {
            return false;
        }
        com.google.android.gms.internal.maps.zzag zzagVarZzb = com.google.android.gms.internal.maps.zzaf.zzb(parcel.readStrongBinder());
        AbstractC0619a.b(parcel);
        zzb(zzagVarZzb);
        parcel2.writeNoException();
        return true;
    }
}
