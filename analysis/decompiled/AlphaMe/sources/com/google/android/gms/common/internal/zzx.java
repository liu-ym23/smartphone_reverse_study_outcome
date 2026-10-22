package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.room.AbstractC0351g;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zza;

/* loaded from: classes.dex */
public final class zzx extends zza implements zzz {
    public zzx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    @Override // com.google.android.gms.common.internal.zzz
    public final int zzc() throws RemoteException {
        Parcel parcelZzB = zzB(2, zza());
        int i4 = parcelZzB.readInt();
        parcelZzB.recycle();
        return i4;
    }

    @Override // com.google.android.gms.common.internal.zzz
    public final IObjectWrapper zzd() throws RemoteException {
        return AbstractC0351g.g(zzB(1, zza()));
    }
}
