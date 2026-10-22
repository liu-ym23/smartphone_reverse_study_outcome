package com.google.android.gms.maps.internal;

import android.location.Location;
import android.os.Parcel;
import android.os.RemoteException;
import i1.AbstractC0619a;

/* loaded from: classes.dex */
public abstract class zzbb extends com.google.android.gms.internal.maps.zzb implements zzbc {
    public zzbb() {
        super("com.google.android.gms.maps.internal.IOnMyLocationClickListener");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    public final boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        if (i4 != 1) {
            return false;
        }
        Location location = (Location) AbstractC0619a.a(parcel, Location.CREATOR);
        AbstractC0619a.b(parcel);
        zzb(location);
        parcel2.writeNoException();
        return true;
    }
}
