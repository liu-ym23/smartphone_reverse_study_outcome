package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.room.AbstractC0351g;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.base.zaa;
import g1.AbstractC0573a;

/* loaded from: classes.dex */
public final class zam extends zaa implements IInterface {
    public zam(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ISignInButtonCreator");
    }

    public final IObjectWrapper zae(IObjectWrapper iObjectWrapper, zax zaxVar) throws RemoteException {
        Parcel parcelZaa = zaa();
        AbstractC0573a.d(parcelZaa, iObjectWrapper);
        AbstractC0573a.c(parcelZaa, zaxVar);
        return AbstractC0351g.g(zab(2, parcelZaa));
    }
}
