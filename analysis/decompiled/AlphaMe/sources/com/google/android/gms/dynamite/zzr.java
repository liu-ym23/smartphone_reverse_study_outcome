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
public final class zzr extends zza implements IInterface {
    public zzr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    public final IObjectWrapper zze(IObjectWrapper iObjectWrapper, String str, int i4, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0588a.d(parcelZza, iObjectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeInt(i4);
        AbstractC0588a.d(parcelZza, iObjectWrapper2);
        return AbstractC0351g.g(zzB(2, parcelZza));
    }

    public final IObjectWrapper zzf(IObjectWrapper iObjectWrapper, String str, int i4, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0588a.d(parcelZza, iObjectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeInt(i4);
        AbstractC0588a.d(parcelZza, iObjectWrapper2);
        return AbstractC0351g.g(zzB(3, parcelZza));
    }
}
