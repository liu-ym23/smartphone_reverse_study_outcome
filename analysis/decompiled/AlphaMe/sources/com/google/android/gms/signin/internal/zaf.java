package com.google.android.gms.signin.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.IAccountAccessor;
import g1.AbstractC0573a;

/* loaded from: classes.dex */
public final class zaf extends com.google.android.gms.internal.base.zaa implements IInterface {
    public zaf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    public final void zae(int i4) throws RemoteException {
        Parcel parcelZaa = zaa();
        parcelZaa.writeInt(i4);
        zac(7, parcelZaa);
    }

    public final void zaf(IAccountAccessor iAccountAccessor, int i4, boolean z4) throws RemoteException {
        Parcel parcelZaa = zaa();
        AbstractC0573a.d(parcelZaa, iAccountAccessor);
        parcelZaa.writeInt(i4);
        parcelZaa.writeInt(z4 ? 1 : 0);
        zac(9, parcelZaa);
    }

    public final void zag(zai zaiVar, zae zaeVar) throws RemoteException {
        Parcel parcelZaa = zaa();
        AbstractC0573a.c(parcelZaa, zaiVar);
        AbstractC0573a.d(parcelZaa, zaeVar);
        zac(12, parcelZaa);
    }
}
