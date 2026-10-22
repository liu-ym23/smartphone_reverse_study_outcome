package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.room.AbstractC0351g;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zza;
import h1.AbstractC0588a;

/* loaded from: classes.dex */
public final class zzq extends zza implements IInterface {
    public zzq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    public final int zze() throws RemoteException {
        Parcel parcelZzB = zzB(6, zza());
        int i4 = parcelZzB.readInt();
        parcelZzB.recycle();
        return i4;
    }

    public final int zzf(IObjectWrapper iObjectWrapper, String str, boolean z4) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0588a.d(parcelZza, iObjectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeInt(z4 ? 1 : 0);
        Parcel parcelZzB = zzB(3, parcelZza);
        int i4 = parcelZzB.readInt();
        parcelZzB.recycle();
        return i4;
    }

    public final int zzg(IObjectWrapper iObjectWrapper, String str, boolean z4) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0588a.d(parcelZza, iObjectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeInt(z4 ? 1 : 0);
        Parcel parcelZzB = zzB(5, parcelZza);
        int i4 = parcelZzB.readInt();
        parcelZzB.recycle();
        return i4;
    }

    public final IObjectWrapper zzh(IObjectWrapper iObjectWrapper, String str, int i4) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0588a.d(parcelZza, iObjectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeInt(i4);
        return AbstractC0351g.g(zzB(2, parcelZza));
    }

    public final IObjectWrapper zzi(IObjectWrapper iObjectWrapper, String str, int i4, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0588a.d(parcelZza, iObjectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeInt(i4);
        AbstractC0588a.d(parcelZza, iObjectWrapper2);
        return AbstractC0351g.g(zzB(8, parcelZza));
    }

    public final IObjectWrapper zzj(IObjectWrapper iObjectWrapper, String str, int i4) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0588a.d(parcelZza, iObjectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeInt(i4);
        return AbstractC0351g.g(zzB(4, parcelZza));
    }

    public final IObjectWrapper zzk(IObjectWrapper iObjectWrapper, String str, boolean z4, long j4) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0588a.d(parcelZza, iObjectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeInt(z4 ? 1 : 0);
        parcelZza.writeLong(j4);
        return AbstractC0351g.g(zzB(7, parcelZza));
    }
}
