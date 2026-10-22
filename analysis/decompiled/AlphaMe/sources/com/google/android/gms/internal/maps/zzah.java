package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import i1.AbstractC0619a;

/* loaded from: classes.dex */
public final class zzah extends zza implements zzaj {
    public zzah(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final float zzd() throws RemoteException {
        Parcel parcelZzH = zzH(13, zza());
        float f4 = parcelZzH.readFloat();
        parcelZzH.recycle();
        return f4;
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final float zze() throws RemoteException {
        Parcel parcelZzH = zzH(5, zza());
        float f4 = parcelZzH.readFloat();
        parcelZzH.recycle();
        return f4;
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final int zzf() throws RemoteException {
        Parcel parcelZzH = zzH(9, zza());
        int i4 = parcelZzH.readInt();
        parcelZzH.recycle();
        return i4;
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final String zzg() throws RemoteException {
        Parcel parcelZzH = zzH(3, zza());
        String string = parcelZzH.readString();
        parcelZzH.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final void zzh() throws RemoteException {
        zzc(2, zza());
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final void zzi() throws RemoteException {
        zzc(1, zza());
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final void zzj(boolean z4) throws RemoteException {
        Parcel parcelZza = zza();
        ClassLoader classLoader = AbstractC0619a.f13018a;
        parcelZza.writeInt(z4 ? 1 : 0);
        zzc(10, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final void zzk(float f4) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeFloat(f4);
        zzc(12, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final void zzl(boolean z4) throws RemoteException {
        Parcel parcelZza = zza();
        ClassLoader classLoader = AbstractC0619a.f13018a;
        parcelZza.writeInt(z4 ? 1 : 0);
        zzc(6, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final void zzm(float f4) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeFloat(f4);
        zzc(4, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final boolean zzn(zzaj zzajVar) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0619a.d(parcelZza, zzajVar);
        Parcel parcelZzH = zzH(8, parcelZza);
        boolean zE = AbstractC0619a.e(parcelZzH);
        parcelZzH.recycle();
        return zE;
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final boolean zzo() throws RemoteException {
        Parcel parcelZzH = zzH(11, zza());
        boolean zE = AbstractC0619a.e(parcelZzH);
        parcelZzH.recycle();
        return zE;
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final boolean zzp() throws RemoteException {
        Parcel parcelZzH = zzH(7, zza());
        boolean zE = AbstractC0619a.e(parcelZzH);
        parcelZzH.recycle();
        return zE;
    }
}
