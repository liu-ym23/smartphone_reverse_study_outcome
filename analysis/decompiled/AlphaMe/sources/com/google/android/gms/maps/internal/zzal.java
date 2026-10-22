package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import i1.AbstractC0619a;

/* loaded from: classes.dex */
public abstract class zzal extends com.google.android.gms.internal.maps.zzb implements zzam {
    public zzal() {
        super("com.google.android.gms.maps.internal.IOnMapClickListener");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    public final boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        if (i4 != 1) {
            return false;
        }
        LatLng latLng = (LatLng) AbstractC0619a.a(parcel, LatLng.CREATOR);
        AbstractC0619a.b(parcel);
        zzb(latLng);
        parcel2.writeNoException();
        return true;
    }
}
