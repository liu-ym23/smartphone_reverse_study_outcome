package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import i1.AbstractC0619a;

/* loaded from: classes.dex */
public abstract class zzh extends com.google.android.gms.internal.maps.zzb implements zzi {
    public zzh() {
        super("com.google.android.gms.maps.internal.IInfoWindowAdapter");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    public final boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        if (i4 == 1) {
            com.google.android.gms.internal.maps.zzaa zzaaVarZzb = com.google.android.gms.internal.maps.zzz.zzb(parcel.readStrongBinder());
            AbstractC0619a.b(parcel);
            IObjectWrapper iObjectWrapperZzc = zzc(zzaaVarZzb);
            parcel2.writeNoException();
            AbstractC0619a.d(parcel2, iObjectWrapperZzc);
        } else {
            if (i4 != 2) {
                return false;
            }
            com.google.android.gms.internal.maps.zzaa zzaaVarZzb2 = com.google.android.gms.internal.maps.zzz.zzb(parcel.readStrongBinder());
            AbstractC0619a.b(parcel);
            IObjectWrapper iObjectWrapperZzb = zzb(zzaaVarZzb2);
            parcel2.writeNoException();
            AbstractC0619a.d(parcel2, iObjectWrapperZzb);
        }
        return true;
    }
}
