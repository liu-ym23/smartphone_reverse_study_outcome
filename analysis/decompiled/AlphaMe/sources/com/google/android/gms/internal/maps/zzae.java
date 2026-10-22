package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.room.AbstractC0351g;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.Cap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import com.google.android.gms.maps.model.StyleSpan;
import i1.AbstractC0619a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class zzae extends zza implements zzag {
    public zzae(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IPolylineDelegate");
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final void zzA(boolean z4) throws RemoteException {
        Parcel parcelZza = zza();
        ClassLoader classLoader = AbstractC0619a.f13018a;
        parcelZza.writeInt(z4 ? 1 : 0);
        zzc(11, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final void zzB(float f4) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeFloat(f4);
        zzc(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final void zzC(float f4) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeFloat(f4);
        zzc(9, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final boolean zzD(zzag zzagVar) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0619a.d(parcelZza, zzagVar);
        Parcel parcelZzH = zzH(15, parcelZza);
        boolean zE = AbstractC0619a.e(parcelZzH);
        parcelZzH.recycle();
        return zE;
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final boolean zzE() throws RemoteException {
        Parcel parcelZzH = zzH(18, zza());
        boolean zE = AbstractC0619a.e(parcelZzH);
        parcelZzH.recycle();
        return zE;
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final boolean zzF() throws RemoteException {
        Parcel parcelZzH = zzH(14, zza());
        boolean zE = AbstractC0619a.e(parcelZzH);
        parcelZzH.recycle();
        return zE;
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final boolean zzG() throws RemoteException {
        Parcel parcelZzH = zzH(12, zza());
        boolean zE = AbstractC0619a.e(parcelZzH);
        parcelZzH.recycle();
        return zE;
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final float zzd() throws RemoteException {
        Parcel parcelZzH = zzH(6, zza());
        float f4 = parcelZzH.readFloat();
        parcelZzH.recycle();
        return f4;
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final float zze() throws RemoteException {
        Parcel parcelZzH = zzH(10, zza());
        float f4 = parcelZzH.readFloat();
        parcelZzH.recycle();
        return f4;
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final int zzf() throws RemoteException {
        Parcel parcelZzH = zzH(8, zza());
        int i4 = parcelZzH.readInt();
        parcelZzH.recycle();
        return i4;
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final int zzg() throws RemoteException {
        Parcel parcelZzH = zzH(24, zza());
        int i4 = parcelZzH.readInt();
        parcelZzH.recycle();
        return i4;
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final int zzh() throws RemoteException {
        Parcel parcelZzH = zzH(16, zza());
        int i4 = parcelZzH.readInt();
        parcelZzH.recycle();
        return i4;
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final IObjectWrapper zzi() throws RemoteException {
        return AbstractC0351g.g(zzH(28, zza()));
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final Cap zzj() throws RemoteException {
        Parcel parcelZzH = zzH(22, zza());
        Cap cap = (Cap) AbstractC0619a.a(parcelZzH, Cap.CREATOR);
        parcelZzH.recycle();
        return cap;
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final Cap zzk() throws RemoteException {
        Parcel parcelZzH = zzH(20, zza());
        Cap cap = (Cap) AbstractC0619a.a(parcelZzH, Cap.CREATOR);
        parcelZzH.recycle();
        return cap;
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final String zzl() throws RemoteException {
        Parcel parcelZzH = zzH(2, zza());
        String string = parcelZzH.readString();
        parcelZzH.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final List zzm() throws RemoteException {
        Parcel parcelZzH = zzH(26, zza());
        ArrayList arrayListCreateTypedArrayList = parcelZzH.createTypedArrayList(PatternItem.CREATOR);
        parcelZzH.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final List zzn() throws RemoteException {
        Parcel parcelZzH = zzH(4, zza());
        ArrayList arrayListCreateTypedArrayList = parcelZzH.createTypedArrayList(LatLng.CREATOR);
        parcelZzH.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final List zzo() throws RemoteException {
        Parcel parcelZzH = zzH(30, zza());
        ArrayList arrayListCreateTypedArrayList = parcelZzH.createTypedArrayList(StyleSpan.CREATOR);
        parcelZzH.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final void zzp() throws RemoteException {
        zzc(1, zza());
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final void zzq(boolean z4) throws RemoteException {
        Parcel parcelZza = zza();
        ClassLoader classLoader = AbstractC0619a.f13018a;
        parcelZza.writeInt(z4 ? 1 : 0);
        zzc(17, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final void zzr(int i4) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i4);
        zzc(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final void zzs(Cap cap) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0619a.c(parcelZza, cap);
        zzc(21, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final void zzt(boolean z4) throws RemoteException {
        Parcel parcelZza = zza();
        ClassLoader classLoader = AbstractC0619a.f13018a;
        parcelZza.writeInt(z4 ? 1 : 0);
        zzc(13, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final void zzu(int i4) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i4);
        zzc(23, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final void zzv(List list) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeTypedList(list);
        zzc(25, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final void zzw(List list) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeTypedList(list);
        zzc(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final void zzx(List list) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeTypedList(list);
        zzc(29, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final void zzy(Cap cap) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0619a.c(parcelZza, cap);
        zzc(19, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final void zzz(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0619a.d(parcelZza, iObjectWrapper);
        zzc(27, parcelZza);
    }
}
