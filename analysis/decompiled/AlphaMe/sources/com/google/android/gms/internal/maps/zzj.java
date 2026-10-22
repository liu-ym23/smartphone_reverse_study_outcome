package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.room.AbstractC0351g;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import i1.AbstractC0619a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class zzj extends zza implements zzl {
    public zzj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.ICircleDelegate");
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final boolean zzA() throws RemoteException {
        Parcel parcelZzH = zzH(16, zza());
        boolean zE = AbstractC0619a.e(parcelZzH);
        parcelZzH.recycle();
        return zE;
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final double zzd() throws RemoteException {
        Parcel parcelZzH = zzH(6, zza());
        double d4 = parcelZzH.readDouble();
        parcelZzH.recycle();
        return d4;
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final float zze() throws RemoteException {
        Parcel parcelZzH = zzH(8, zza());
        float f4 = parcelZzH.readFloat();
        parcelZzH.recycle();
        return f4;
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final float zzf() throws RemoteException {
        Parcel parcelZzH = zzH(14, zza());
        float f4 = parcelZzH.readFloat();
        parcelZzH.recycle();
        return f4;
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final int zzg() throws RemoteException {
        Parcel parcelZzH = zzH(12, zza());
        int i4 = parcelZzH.readInt();
        parcelZzH.recycle();
        return i4;
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final int zzh() throws RemoteException {
        Parcel parcelZzH = zzH(10, zza());
        int i4 = parcelZzH.readInt();
        parcelZzH.recycle();
        return i4;
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final int zzi() throws RemoteException {
        Parcel parcelZzH = zzH(18, zza());
        int i4 = parcelZzH.readInt();
        parcelZzH.recycle();
        return i4;
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final IObjectWrapper zzj() throws RemoteException {
        return AbstractC0351g.g(zzH(24, zza()));
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final LatLng zzk() throws RemoteException {
        Parcel parcelZzH = zzH(4, zza());
        LatLng latLng = (LatLng) AbstractC0619a.a(parcelZzH, LatLng.CREATOR);
        parcelZzH.recycle();
        return latLng;
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final String zzl() throws RemoteException {
        Parcel parcelZzH = zzH(2, zza());
        String string = parcelZzH.readString();
        parcelZzH.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final List zzm() throws RemoteException {
        Parcel parcelZzH = zzH(22, zza());
        ArrayList arrayListCreateTypedArrayList = parcelZzH.createTypedArrayList(PatternItem.CREATOR);
        parcelZzH.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final void zzn() throws RemoteException {
        zzc(1, zza());
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final void zzo(LatLng latLng) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0619a.c(parcelZza, latLng);
        zzc(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final void zzp(boolean z4) throws RemoteException {
        Parcel parcelZza = zza();
        ClassLoader classLoader = AbstractC0619a.f13018a;
        parcelZza.writeInt(z4 ? 1 : 0);
        zzc(19, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final void zzq(int i4) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i4);
        zzc(11, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final void zzr(double d4) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeDouble(d4);
        zzc(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final void zzs(int i4) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i4);
        zzc(9, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final void zzt(List list) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeTypedList(list);
        zzc(21, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final void zzu(float f4) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeFloat(f4);
        zzc(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final void zzv(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0619a.d(parcelZza, iObjectWrapper);
        zzc(23, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final void zzw(boolean z4) throws RemoteException {
        Parcel parcelZza = zza();
        ClassLoader classLoader = AbstractC0619a.f13018a;
        parcelZza.writeInt(z4 ? 1 : 0);
        zzc(15, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final void zzx(float f4) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeFloat(f4);
        zzc(13, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final boolean zzy(zzl zzlVar) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0619a.d(parcelZza, zzlVar);
        Parcel parcelZzH = zzH(17, parcelZza);
        boolean zE = AbstractC0619a.e(parcelZzH);
        parcelZzH.recycle();
        return zE;
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final boolean zzz() throws RemoteException {
        Parcel parcelZzH = zzH(20, zza());
        boolean zE = AbstractC0619a.e(parcelZzH);
        parcelZzH.recycle();
        return zE;
    }
}
