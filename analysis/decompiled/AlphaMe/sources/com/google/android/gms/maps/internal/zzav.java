package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import i1.AbstractC0619a;

/* loaded from: classes.dex */
public abstract class zzav extends com.google.android.gms.internal.maps.zzb implements zzaw {
    public zzav() {
        super("com.google.android.gms.maps.internal.IOnMarkerDragListener");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    public final boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        if (i4 == 1) {
            com.google.android.gms.internal.maps.zzaa zzaaVarZzb = com.google.android.gms.internal.maps.zzz.zzb(parcel.readStrongBinder());
            AbstractC0619a.b(parcel);
            zzd(zzaaVarZzb);
        } else if (i4 == 2) {
            com.google.android.gms.internal.maps.zzaa zzaaVarZzb2 = com.google.android.gms.internal.maps.zzz.zzb(parcel.readStrongBinder());
            AbstractC0619a.b(parcel);
            zzb(zzaaVarZzb2);
        } else {
            if (i4 != 3) {
                return false;
            }
            com.google.android.gms.internal.maps.zzaa zzaaVarZzb3 = com.google.android.gms.internal.maps.zzz.zzb(parcel.readStrongBinder());
            AbstractC0619a.b(parcel);
            zzc(zzaaVarZzb3);
        }
        parcel2.writeNoException();
        return true;
    }
}
