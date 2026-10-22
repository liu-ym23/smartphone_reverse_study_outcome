package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.Tile;
import i1.AbstractC0619a;

/* loaded from: classes.dex */
public abstract class zzal extends zzb implements zzam {
    public zzal() {
        super("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
    }

    public static zzam zzc(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
        return iInterfaceQueryLocalInterface instanceof zzam ? (zzam) iInterfaceQueryLocalInterface : new zzak(iBinder);
    }

    @Override // com.google.android.gms.internal.maps.zzb
    public final boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        if (i4 != 1) {
            return false;
        }
        int i6 = parcel.readInt();
        int i7 = parcel.readInt();
        int i8 = parcel.readInt();
        AbstractC0619a.b(parcel);
        Tile tileZzb = zzb(i6, i7, i8);
        parcel2.writeNoException();
        if (tileZzb == null) {
            parcel2.writeInt(0);
        } else {
            parcel2.writeInt(1);
            tileZzb.writeToParcel(parcel2, 1);
        }
        return true;
    }
}
