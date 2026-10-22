package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.Tile;
import i1.AbstractC0619a;

/* loaded from: classes.dex */
public final class zzak extends zza implements zzam {
    public zzak(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.ITileProviderDelegate");
    }

    @Override // com.google.android.gms.internal.maps.zzam
    public final Tile zzb(int i4, int i5, int i6) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i4);
        parcelZza.writeInt(i5);
        parcelZza.writeInt(i6);
        Parcel parcelZzH = zzH(1, parcelZza);
        Tile tile = (Tile) AbstractC0619a.a(parcelZzH, Tile.CREATOR);
        parcelZzH.recycle();
        return tile;
    }
}
