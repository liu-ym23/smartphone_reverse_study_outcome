package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.PointOfInterest;
import i1.AbstractC0619a;

/* loaded from: classes.dex */
public abstract class zzbd extends com.google.android.gms.internal.maps.zzb implements zzbe {
    public zzbd() {
        super("com.google.android.gms.maps.internal.IOnPoiClickListener");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    public final boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        if (i4 != 1) {
            return false;
        }
        PointOfInterest pointOfInterest = (PointOfInterest) AbstractC0619a.a(parcel, PointOfInterest.CREATOR);
        AbstractC0619a.b(parcel);
        zzb(pointOfInterest);
        parcel2.writeNoException();
        return true;
    }
}
