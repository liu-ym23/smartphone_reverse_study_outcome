package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.room.AbstractC0351g;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.LatLng;
import i1.AbstractC0619a;

/* loaded from: classes.dex */
public final class zzy extends zza implements zzaa {
    public zzy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IMarkerDelegate");
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final void zzA(float f4) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeFloat(f4);
        zzc(27, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final void zzB() throws RemoteException {
        zzc(11, zza());
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final boolean zzC(zzaa zzaaVar) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0619a.d(parcelZza, zzaaVar);
        Parcel parcelZzH = zzH(16, parcelZza);
        boolean zE = AbstractC0619a.e(parcelZzH);
        parcelZzH.recycle();
        return zE;
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final boolean zzD() throws RemoteException {
        Parcel parcelZzH = zzH(10, zza());
        boolean zE = AbstractC0619a.e(parcelZzH);
        parcelZzH.recycle();
        return zE;
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final boolean zzE() throws RemoteException {
        Parcel parcelZzH = zzH(21, zza());
        boolean zE = AbstractC0619a.e(parcelZzH);
        parcelZzH.recycle();
        return zE;
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final boolean zzF() throws RemoteException {
        Parcel parcelZzH = zzH(13, zza());
        boolean zE = AbstractC0619a.e(parcelZzH);
        parcelZzH.recycle();
        return zE;
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final boolean zzG() throws RemoteException {
        Parcel parcelZzH = zzH(15, zza());
        boolean zE = AbstractC0619a.e(parcelZzH);
        parcelZzH.recycle();
        return zE;
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final float zzd() throws RemoteException {
        Parcel parcelZzH = zzH(26, zza());
        float f4 = parcelZzH.readFloat();
        parcelZzH.recycle();
        return f4;
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final float zze() throws RemoteException {
        Parcel parcelZzH = zzH(23, zza());
        float f4 = parcelZzH.readFloat();
        parcelZzH.recycle();
        return f4;
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final float zzf() throws RemoteException {
        Parcel parcelZzH = zzH(28, zza());
        float f4 = parcelZzH.readFloat();
        parcelZzH.recycle();
        return f4;
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final int zzg() throws RemoteException {
        Parcel parcelZzH = zzH(17, zza());
        int i4 = parcelZzH.readInt();
        parcelZzH.recycle();
        return i4;
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final IObjectWrapper zzh() throws RemoteException {
        return AbstractC0351g.g(zzH(30, zza()));
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final LatLng zzi() throws RemoteException {
        Parcel parcelZzH = zzH(4, zza());
        LatLng latLng = (LatLng) AbstractC0619a.a(parcelZzH, LatLng.CREATOR);
        parcelZzH.recycle();
        return latLng;
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final String zzj() throws RemoteException {
        Parcel parcelZzH = zzH(2, zza());
        String string = parcelZzH.readString();
        parcelZzH.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final String zzk() throws RemoteException {
        Parcel parcelZzH = zzH(8, zza());
        String string = parcelZzH.readString();
        parcelZzH.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final String zzl() throws RemoteException {
        Parcel parcelZzH = zzH(6, zza());
        String string = parcelZzH.readString();
        parcelZzH.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final void zzm() throws RemoteException {
        zzc(12, zza());
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final void zzn() throws RemoteException {
        zzc(1, zza());
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final void zzo(float f4) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeFloat(f4);
        zzc(25, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final void zzp(float f4, float f5) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeFloat(f4);
        parcelZza.writeFloat(f5);
        zzc(19, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final void zzq(boolean z4) throws RemoteException {
        Parcel parcelZza = zza();
        ClassLoader classLoader = AbstractC0619a.f13018a;
        parcelZza.writeInt(z4 ? 1 : 0);
        zzc(9, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final void zzr(boolean z4) throws RemoteException {
        Parcel parcelZza = zza();
        ClassLoader classLoader = AbstractC0619a.f13018a;
        parcelZza.writeInt(z4 ? 1 : 0);
        zzc(20, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final void zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0619a.d(parcelZza, iObjectWrapper);
        zzc(18, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final void zzt(float f4, float f5) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeFloat(f4);
        parcelZza.writeFloat(f5);
        zzc(24, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final void zzu(LatLng latLng) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0619a.c(parcelZza, latLng);
        zzc(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final void zzv(float f4) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeFloat(f4);
        zzc(22, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final void zzw(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzc(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final void zzx(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0619a.d(parcelZza, iObjectWrapper);
        zzc(29, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final void zzy(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzc(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final void zzz(boolean z4) throws RemoteException {
        Parcel parcelZza = zza();
        ClassLoader classLoader = AbstractC0619a.f13018a;
        parcelZza.writeInt(z4 ? 1 : 0);
        zzc(14, parcelZza);
    }
}
