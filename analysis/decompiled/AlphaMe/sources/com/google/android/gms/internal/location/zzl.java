package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public abstract class zzl extends zzb implements zzm {
    public zzl() {
        super("com.google.android.gms.location.internal.IGeofencerCallbacks");
    }

    @Override // com.google.android.gms.internal.location.zzb
    public final boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        if (i4 == 1) {
            int i6 = parcel.readInt();
            String[] strArrCreateStringArray = parcel.createStringArray();
            b.b(parcel);
            zzb(i6, strArrCreateStringArray);
        } else if (i4 == 2) {
            int i7 = parcel.readInt();
            String[] strArrCreateStringArray2 = parcel.createStringArray();
            b.b(parcel);
            zzd(i7, strArrCreateStringArray2);
        } else {
            if (i4 != 3) {
                return false;
            }
            int i8 = parcel.readInt();
            PendingIntent pendingIntent = (PendingIntent) b.a(parcel, PendingIntent.CREATOR);
            b.b(parcel);
            zzc(i8, pendingIntent);
        }
        return true;
    }
}
