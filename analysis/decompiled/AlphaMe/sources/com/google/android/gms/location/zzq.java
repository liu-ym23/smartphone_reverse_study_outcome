package com.google.android.gms.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.location.b;

/* loaded from: classes.dex */
public abstract class zzq extends com.google.android.gms.internal.location.zzb implements zzr {
    public zzq() {
        super("com.google.android.gms.location.ILocationCallback");
    }

    public static zzr zzb(IBinder iBinder) {
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
        return iInterfaceQueryLocalInterface instanceof zzr ? (zzr) iInterfaceQueryLocalInterface : new zzp(iBinder);
    }

    @Override // com.google.android.gms.internal.location.zzb
    public final boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        if (i4 == 1) {
            LocationResult locationResult = (LocationResult) b.a(parcel, LocationResult.CREATOR);
            b.b(parcel);
            zze(locationResult);
        } else if (i4 == 2) {
            LocationAvailability locationAvailability = (LocationAvailability) b.a(parcel, LocationAvailability.CREATOR);
            b.b(parcel);
            zzd(locationAvailability);
        } else {
            if (i4 != 3) {
                return false;
            }
            zzf();
        }
        return true;
    }
}
