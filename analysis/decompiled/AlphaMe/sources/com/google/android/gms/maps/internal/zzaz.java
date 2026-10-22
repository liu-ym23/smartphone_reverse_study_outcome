package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import i1.AbstractC0619a;

/* loaded from: classes.dex */
public abstract class zzaz extends com.google.android.gms.internal.maps.zzb implements zzba {
    public zzaz() {
        super("com.google.android.gms.maps.internal.IOnMyLocationChangeListener");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    public final boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        if (i4 != 1) {
            return false;
        }
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
        AbstractC0619a.b(parcel);
        zzb(iObjectWrapperAsInterface);
        parcel2.writeNoException();
        return true;
    }
}
