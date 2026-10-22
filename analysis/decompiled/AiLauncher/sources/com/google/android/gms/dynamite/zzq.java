package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zza;
import x2.C5845a;

/* loaded from: classes2.dex */
public final class zzq extends zza implements IInterface {
    public zzq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    public final int zze() throws RemoteException {
        Parcel parcelZzB = zzB(6, zza());
        int i10 = parcelZzB.readInt();
        parcelZzB.recycle();
        return i10;
    }

    public final int zzf(IObjectWrapper iObjectWrapper, String str, boolean z10) throws RemoteException {
        Parcel parcelZza = zza();
        C5845a.e(parcelZza, iObjectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeInt(z10 ? 1 : 0);
        Parcel parcelZzB = zzB(3, parcelZza);
        int i10 = parcelZzB.readInt();
        parcelZzB.recycle();
        return i10;
    }

    public final int zzg(IObjectWrapper iObjectWrapper, String str, boolean z10) throws RemoteException {
        Parcel parcelZza = zza();
        C5845a.e(parcelZza, iObjectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeInt(z10 ? 1 : 0);
        Parcel parcelZzB = zzB(5, parcelZza);
        int i10 = parcelZzB.readInt();
        parcelZzB.recycle();
        return i10;
    }

    public final IObjectWrapper zzh(IObjectWrapper iObjectWrapper, String str, int i10) throws RemoteException {
        Parcel parcelZza = zza();
        C5845a.e(parcelZza, iObjectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeInt(i10);
        Parcel parcelZzB = zzB(2, parcelZza);
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return iObjectWrapperAsInterface;
    }

    public final IObjectWrapper zzi(IObjectWrapper iObjectWrapper, String str, int i10, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel parcelZza = zza();
        C5845a.e(parcelZza, iObjectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeInt(i10);
        C5845a.e(parcelZza, iObjectWrapper2);
        Parcel parcelZzB = zzB(8, parcelZza);
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return iObjectWrapperAsInterface;
    }

    public final IObjectWrapper zzj(IObjectWrapper iObjectWrapper, String str, int i10) throws RemoteException {
        Parcel parcelZza = zza();
        C5845a.e(parcelZza, iObjectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeInt(i10);
        Parcel parcelZzB = zzB(4, parcelZza);
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return iObjectWrapperAsInterface;
    }

    public final IObjectWrapper zzk(IObjectWrapper iObjectWrapper, String str, boolean z10, long j10) throws RemoteException {
        Parcel parcelZza = zza();
        C5845a.e(parcelZza, iObjectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeInt(z10 ? 1 : 0);
        parcelZza.writeLong(j10);
        Parcel parcelZzB = zzB(7, parcelZza);
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return iObjectWrapperAsInterface;
    }
}
