package com.google.android.gms.internal.maps;

import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.room.AbstractC0351g;
import com.google.android.gms.dynamic.IObjectWrapper;
import i1.AbstractC0619a;

/* loaded from: classes.dex */
public final class zzg extends zza implements zzi {
    public zzg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
    }

    @Override // com.google.android.gms.internal.maps.zzi
    public final IObjectWrapper zzd() throws RemoteException {
        return AbstractC0351g.g(zzH(4, zza()));
    }

    @Override // com.google.android.gms.internal.maps.zzi
    public final IObjectWrapper zze(float f4) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeFloat(f4);
        return AbstractC0351g.g(zzH(5, parcelZza));
    }

    @Override // com.google.android.gms.internal.maps.zzi
    public final IObjectWrapper zzf(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        return AbstractC0351g.g(zzH(2, parcelZza));
    }

    @Override // com.google.android.gms.internal.maps.zzi
    public final IObjectWrapper zzg(Bitmap bitmap) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0619a.c(parcelZza, bitmap);
        return AbstractC0351g.g(zzH(6, parcelZza));
    }

    @Override // com.google.android.gms.internal.maps.zzi
    public final IObjectWrapper zzh(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        return AbstractC0351g.g(zzH(3, parcelZza));
    }

    @Override // com.google.android.gms.internal.maps.zzi
    public final IObjectWrapper zzi(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        return AbstractC0351g.g(zzH(7, parcelZza));
    }

    @Override // com.google.android.gms.internal.maps.zzi
    public final IObjectWrapper zzj(int i4) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i4);
        return AbstractC0351g.g(zzH(1, parcelZza));
    }
}
