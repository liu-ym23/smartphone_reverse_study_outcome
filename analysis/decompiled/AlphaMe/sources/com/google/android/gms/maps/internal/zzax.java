package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import i1.AbstractC0619a;

/* loaded from: classes.dex */
public abstract class zzax extends com.google.android.gms.internal.maps.zzb implements zzay {
    public zzax() {
        super("com.google.android.gms.maps.internal.IOnMyLocationButtonClickListener");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    public final boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        if (i4 != 1) {
            return false;
        }
        boolean zZzb = zzb();
        parcel2.writeNoException();
        ClassLoader classLoader = AbstractC0619a.f13018a;
        parcel2.writeInt(zZzb ? 1 : 0);
        return true;
    }
}
