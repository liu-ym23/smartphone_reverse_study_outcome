package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.room.AbstractC0351g;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import i1.AbstractC0619a;

/* loaded from: classes.dex */
public final class zzm extends zza implements zzo {
    public zzm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
    }

    @Override // com.google.android.gms.internal.maps.zzo
    public final boolean zzA() throws RemoteException {
        Parcel parcelZzH = zzH(23, zza());
        boolean zE = AbstractC0619a.e(parcelZzH);
        parcelZzH.recycle();
        return zE;
    }

    @Override // com.google.android.gms.internal.maps.zzo
    public final boolean zzB() throws RemoteException {
        Parcel parcelZzH = zzH(16, zza());
        boolean zE = AbstractC0619a.e(parcelZzH);
        parcelZzH.recycle();
        return zE;
    }

    @Override // com.google.android.gms.internal.maps.zzo
    public final float zzd() throws RemoteException {
        Parcel parcelZzH = zzH(12, zza());
        float f4 = parcelZzH.readFloat();
        parcelZzH.recycle();
        return f4;
    }

    @Override // com.google.android.gms.internal.maps.zzo
    public final float zze() throws RemoteException {
        Parcel parcelZzH = zzH(8, zza());
        float f4 = parcelZzH.readFloat();
        parcelZzH.recycle();
        return f4;
    }

    @Override // com.google.android.gms.internal.maps.zzo
    public final float zzf() throws RemoteException {
        Parcel parcelZzH = zzH(18, zza());
        float f4 = parcelZzH.readFloat();
        parcelZzH.recycle();
        return f4;
    }

    @Override // com.google.android.gms.internal.maps.zzo
    public final float zzg() throws RemoteException {
        Parcel parcelZzH = zzH(7, zza());
        float f4 = parcelZzH.readFloat();
        parcelZzH.recycle();
        return f4;
    }

    @Override // com.google.android.gms.internal.maps.zzo
    public final float zzh() throws RemoteException {
        Parcel parcelZzH = zzH(14, zza());
        float f4 = parcelZzH.readFloat();
        parcelZzH.recycle();
        return f4;
    }

    @Override // com.google.android.gms.internal.maps.zzo
    public final int zzi() throws RemoteException {
        Parcel parcelZzH = zzH(20, zza());
        int i4 = parcelZzH.readInt();
        parcelZzH.recycle();
        return i4;
    }

    @Override // com.google.android.gms.internal.maps.zzo
    public final IObjectWrapper zzj() throws RemoteException {
        return AbstractC0351g.g(zzH(25, zza()));
    }

    @Override // com.google.android.gms.internal.maps.zzo
    public final LatLng zzk() throws RemoteException {
        Parcel parcelZzH = zzH(4, zza());
        LatLng latLng = (LatLng) AbstractC0619a.a(parcelZzH, LatLng.CREATOR);
        parcelZzH.recycle();
        return latLng;
    }

    @Override // com.google.android.gms.internal.maps.zzo
    public final LatLngBounds zzl() throws RemoteException {
        Parcel parcelZzH = zzH(10, zza());
        LatLngBounds latLngBounds = (LatLngBounds) AbstractC0619a.a(parcelZzH, LatLngBounds.CREATOR);
        parcelZzH.recycle();
        return latLngBounds;
    }

    @Override // com.google.android.gms.internal.maps.zzo
    public final String zzm() throws RemoteException {
        Parcel parcelZzH = zzH(2, zza());
        String string = parcelZzH.readString();
        parcelZzH.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.maps.zzo
    public final void zzn() throws RemoteException {
        zzc(1, zza());
    }

    @Override // com.google.android.gms.internal.maps.zzo
    public final void zzo(float f4) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeFloat(f4);
        zzc(11, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzo
    public final void zzp(boolean z4) throws RemoteException {
        Parcel parcelZza = zza();
        ClassLoader classLoader = AbstractC0619a.f13018a;
        parcelZza.writeInt(z4 ? 1 : 0);
        zzc(22, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzo
    public final void zzq(float f4) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeFloat(f4);
        zzc(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzo
    public final void zzr(float f4, float f5) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeFloat(f4);
        parcelZza.writeFloat(f5);
        zzc(6, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzo
    public final void zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0619a.d(parcelZza, iObjectWrapper);
        zzc(21, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzo
    public final void zzt(LatLng latLng) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0619a.c(parcelZza, latLng);
        zzc(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzo
    public final void zzu(LatLngBounds latLngBounds) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0619a.c(parcelZza, latLngBounds);
        zzc(9, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzo
    public final void zzv(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0619a.d(parcelZza, iObjectWrapper);
        zzc(24, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzo
    public final void zzw(float f4) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeFloat(f4);
        zzc(17, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzo
    public final void zzx(boolean z4) throws RemoteException {
        Parcel parcelZza = zza();
        ClassLoader classLoader = AbstractC0619a.f13018a;
        parcelZza.writeInt(z4 ? 1 : 0);
        zzc(15, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzo
    public final void zzy(float f4) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeFloat(f4);
        zzc(13, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzo
    public final boolean zzz(zzo zzoVar) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0619a.d(parcelZza, zzoVar);
        Parcel parcelZzH = zzH(19, parcelZza);
        boolean zE = AbstractC0619a.e(parcelZzH);
        parcelZzH.recycle();
        return zE;
    }
}
