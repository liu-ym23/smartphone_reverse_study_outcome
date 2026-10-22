package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zzb;
import h1.AbstractC0588a;

/* loaded from: classes.dex */
public abstract class zzab extends zzb implements IGmsCallbacks {
    public zzab() {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
    }

    @Override // com.google.android.gms.internal.common.zzb
    public final boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        if (i4 == 1) {
            int i6 = parcel.readInt();
            IBinder strongBinder = parcel.readStrongBinder();
            Bundle bundle = (Bundle) AbstractC0588a.a(parcel, Bundle.CREATOR);
            AbstractC0588a.b(parcel);
            onPostInitComplete(i6, strongBinder, bundle);
        } else if (i4 == 2) {
            int i7 = parcel.readInt();
            Bundle bundle2 = (Bundle) AbstractC0588a.a(parcel, Bundle.CREATOR);
            AbstractC0588a.b(parcel);
            zzb(i7, bundle2);
        } else {
            if (i4 != 3) {
                return false;
            }
            int i8 = parcel.readInt();
            IBinder strongBinder2 = parcel.readStrongBinder();
            zzj zzjVar = (zzj) AbstractC0588a.a(parcel, zzj.CREATOR);
            AbstractC0588a.b(parcel);
            zzc(i8, strongBinder2, zzjVar);
        }
        parcel2.writeNoException();
        return true;
    }
}
