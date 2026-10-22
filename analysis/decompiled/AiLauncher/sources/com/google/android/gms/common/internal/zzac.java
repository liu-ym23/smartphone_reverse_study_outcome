package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zzb;
import x2.C5845a;

/* loaded from: classes2.dex */
public abstract class zzac extends zzb implements IGmsCallbacks {
    public zzac() {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
    }

    @Override // com.google.android.gms.internal.common.zzb
    public final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 == 1) {
            int i12 = parcel.readInt();
            IBinder strongBinder = parcel.readStrongBinder();
            Bundle bundle = (Bundle) C5845a.a(parcel, Bundle.CREATOR);
            C5845a.b(parcel);
            onPostInitComplete(i12, strongBinder, bundle);
        } else if (i10 == 2) {
            int i13 = parcel.readInt();
            Bundle bundle2 = (Bundle) C5845a.a(parcel, Bundle.CREATOR);
            C5845a.b(parcel);
            zzb(i13, bundle2);
        } else {
            if (i10 != 3) {
                return false;
            }
            int i14 = parcel.readInt();
            IBinder strongBinder2 = parcel.readStrongBinder();
            zzk zzkVar = (zzk) C5845a.a(parcel, zzk.CREATOR);
            C5845a.b(parcel);
            zzc(i14, strongBinder2, zzkVar);
        }
        parcel2.writeNoException();
        return true;
    }
}
