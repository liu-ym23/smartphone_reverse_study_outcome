package com.google.android.gms.maps.internal;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import i1.AbstractC0619a;

/* loaded from: classes.dex */
public abstract class zzbu extends com.google.android.gms.internal.maps.zzb implements zzbv {
    public zzbu() {
        super("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    public final boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        if (i4 == 1) {
            Bitmap bitmap = (Bitmap) AbstractC0619a.a(parcel, Bitmap.CREATOR);
            AbstractC0619a.b(parcel);
            zzb(bitmap);
        } else {
            if (i4 != 2) {
                return false;
            }
            IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            AbstractC0619a.b(parcel);
            zzc(iObjectWrapperAsInterface);
        }
        parcel2.writeNoException();
        return true;
    }
}
