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
public final class zzab extends zza implements zzad {
    public zzab(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IPolygonDelegate");
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzA(float f4) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeFloat(f4);
        zzc(13, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final boolean zzB(zzad zzadVar) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0619a.d(parcelZza, zzadVar);
        Parcel parcelZzH = zzH(19, parcelZza);
        boolean zE = AbstractC0619a.e(parcelZzH);
        parcelZzH.recycle();
        return zE;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final boolean zzC() throws RemoteException {
        Parcel parcelZzH = zzH(22, zza());
        boolean zE = AbstractC0619a.e(parcelZzH);
        parcelZzH.recycle();
        return zE;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final boolean zzD() throws RemoteException {
        Parcel parcelZzH = zzH(18, zza());
        boolean zE = AbstractC0619a.e(parcelZzH);
        parcelZzH.recycle();
        return zE;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final boolean zzE() throws RemoteException {
        Parcel parcelZzH = zzH(16, zza());
        boolean zE = AbstractC0619a.e(parcelZzH);
        parcelZzH.recycle();
        return zE;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final float zzd() throws RemoteException {
        Parcel parcelZzH = zzH(8, zza());
        float f4 = parcelZzH.readFloat();
        parcelZzH.recycle();
        return f4;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final float zze() throws RemoteException {
        Parcel parcelZzH = zzH(14, zza());
        float f4 = parcelZzH.readFloat();
        parcelZzH.recycle();
        return f4;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final int zzf() throws RemoteException {
        Parcel parcelZzH = zzH(12, zza());
        int i4 = parcelZzH.readInt();
        parcelZzH.recycle();
        return i4;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final int zzg() throws RemoteException {
        Parcel parcelZzH = zzH(10, zza());
        int i4 = parcelZzH.readInt();
        parcelZzH.recycle();
        return i4;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final int zzh() throws RemoteException {
        Parcel parcelZzH = zzH(24, zza());
        int i4 = parcelZzH.readInt();
        parcelZzH.recycle();
        return i4;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final int zzi() throws RemoteException {
        Parcel parcelZzH = zzH(20, zza());
        int i4 = parcelZzH.readInt();
        parcelZzH.recycle();
        return i4;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final IObjectWrapper zzj() throws RemoteException {
        return AbstractC0351g.g(zzH(28, zza()));
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final String zzk() throws RemoteException {
        Parcel parcelZzH = zzH(2, zza());
        String string = parcelZzH.readString();
        parcelZzH.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final List zzl() throws RemoteException {
        Parcel parcelZzH = zzH(6, zza());
        ArrayList arrayList = parcelZzH.readArrayList(AbstractC0619a.f13018a);
        parcelZzH.recycle();
        return arrayList;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final List zzm() throws RemoteException {
        Parcel parcelZzH = zzH(4, zza());
        ArrayList arrayListCreateTypedArrayList = parcelZzH.createTypedArrayList(LatLng.CREATOR);
        parcelZzH.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final List zzn() throws RemoteException {
        Parcel parcelZzH = zzH(26, zza());
        ArrayList arrayListCreateTypedArrayList = parcelZzH.createTypedArrayList(PatternItem.CREATOR);
        parcelZzH.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzo() throws RemoteException {
        zzc(1, zza());
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzp(boolean z4) throws RemoteException {
        Parcel parcelZza = zza();
        ClassLoader classLoader = AbstractC0619a.f13018a;
        parcelZza.writeInt(z4 ? 1 : 0);
        zzc(21, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzq(int i4) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i4);
        zzc(11, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzr(boolean z4) throws RemoteException {
        Parcel parcelZza = zza();
        ClassLoader classLoader = AbstractC0619a.f13018a;
        parcelZza.writeInt(z4 ? 1 : 0);
        zzc(17, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzs(List list) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeList(list);
        zzc(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzt(List list) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeTypedList(list);
        zzc(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzu(int i4) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i4);
        zzc(9, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzv(int i4) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i4);
        zzc(23, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzw(List list) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeTypedList(list);
        zzc(25, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzx(float f4) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeFloat(f4);
        zzc(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzy(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0619a.d(parcelZza, iObjectWrapper);
        zzc(27, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzz(boolean z4) throws RemoteException {
        Parcel parcelZza = zza();
        ClassLoader classLoader = AbstractC0619a.f13018a;
        parcelZza.writeInt(z4 ? 1 : 0);
        zzc(15, parcelZza);
    }
}
