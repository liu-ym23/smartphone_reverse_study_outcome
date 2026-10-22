package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import i1.AbstractC0619a;

/* loaded from: classes.dex */
public abstract class zzbr extends com.google.android.gms.internal.maps.zzb implements zzbs {
    public zzbr() {
        super("com.google.android.gms.maps.internal.IOnStreetViewPanoramaReadyCallback");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    public final boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        IStreetViewPanoramaDelegate zzbwVar;
        if (i4 != 1) {
            return false;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        if (strongBinder == null) {
            zzbwVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            zzbwVar = iInterfaceQueryLocalInterface instanceof IStreetViewPanoramaDelegate ? (IStreetViewPanoramaDelegate) iInterfaceQueryLocalInterface : new zzbw(strongBinder);
        }
        AbstractC0619a.b(parcel);
        zzb(zzbwVar);
        parcel2.writeNoException();
        return true;
    }
}
