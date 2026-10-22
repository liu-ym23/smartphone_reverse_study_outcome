package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import i1.AbstractC0619a;

/* loaded from: classes.dex */
public abstract class zzbf extends com.google.android.gms.internal.maps.zzb implements zzbg {
    public zzbf() {
        super("com.google.android.gms.maps.internal.IOnPolygonClickListener");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    public final boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        if (i4 != 1) {
            return false;
        }
        com.google.android.gms.internal.maps.zzad zzadVarZzb = com.google.android.gms.internal.maps.zzac.zzb(parcel.readStrongBinder());
        AbstractC0619a.b(parcel);
        zzb(zzadVarZzb);
        parcel2.writeNoException();
        return true;
    }
}
