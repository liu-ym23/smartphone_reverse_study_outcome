package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import i1.AbstractC0619a;

/* loaded from: classes.dex */
public abstract class zzbj extends com.google.android.gms.internal.maps.zzb implements zzbk {
    public zzbj() {
        super("com.google.android.gms.maps.internal.IOnStreetViewPanoramaCameraChangeListener");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    public final boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        if (i4 != 1) {
            return false;
        }
        StreetViewPanoramaCamera streetViewPanoramaCamera = (StreetViewPanoramaCamera) AbstractC0619a.a(parcel, StreetViewPanoramaCamera.CREATOR);
        AbstractC0619a.b(parcel);
        zzb(streetViewPanoramaCamera);
        parcel2.writeNoException();
        return true;
    }
}
