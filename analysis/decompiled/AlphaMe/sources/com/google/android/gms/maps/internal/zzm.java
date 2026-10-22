package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.CameraPosition;
import i1.AbstractC0619a;

/* loaded from: classes.dex */
public abstract class zzm extends com.google.android.gms.internal.maps.zzb implements zzn {
    public zzm() {
        super("com.google.android.gms.maps.internal.IOnCameraChangeListener");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    public final boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        if (i4 != 1) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) AbstractC0619a.a(parcel, CameraPosition.CREATOR);
        AbstractC0619a.b(parcel);
        zzb(cameraPosition);
        parcel2.writeNoException();
        return true;
    }
}
