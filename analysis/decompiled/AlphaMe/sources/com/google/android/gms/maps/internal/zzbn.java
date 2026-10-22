package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import i1.AbstractC0619a;

/* loaded from: classes.dex */
public abstract class zzbn extends com.google.android.gms.internal.maps.zzb implements zzbo {
    public zzbn() {
        super("com.google.android.gms.maps.internal.IOnStreetViewPanoramaClickListener");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    public final boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        if (i4 != 1) {
            return false;
        }
        StreetViewPanoramaOrientation streetViewPanoramaOrientation = (StreetViewPanoramaOrientation) AbstractC0619a.a(parcel, StreetViewPanoramaOrientation.CREATOR);
        AbstractC0619a.b(parcel);
        zzb(streetViewPanoramaOrientation);
        parcel2.writeNoException();
        return true;
    }
}
