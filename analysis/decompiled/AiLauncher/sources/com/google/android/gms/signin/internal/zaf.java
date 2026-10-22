package com.google.android.gms.signin.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.IAccountAccessor;
import w2.C5717a;

/* loaded from: classes2.dex */
public final class zaf extends com.google.android.gms.internal.base.zaa implements IInterface {
    public zaf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    public final void zae(int i10) throws RemoteException {
        Parcel parcelZaa = zaa();
        parcelZaa.writeInt(i10);
        zac(7, parcelZaa);
    }

    public final void zaf(IAccountAccessor iAccountAccessor, int i10, boolean z10) throws RemoteException {
        Parcel parcelZaa = zaa();
        C5717a.d(parcelZaa, iAccountAccessor);
        parcelZaa.writeInt(i10);
        parcelZaa.writeInt(z10 ? 1 : 0);
        zac(9, parcelZaa);
    }

    public final void zag(zai zaiVar, zae zaeVar) throws RemoteException {
        Parcel parcelZaa = zaa();
        C5717a.c(parcelZaa, zaiVar);
        C5717a.d(parcelZaa, zaeVar);
        zac(12, parcelZaa);
    }
}
