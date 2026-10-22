package com.stepos.common.alphame;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public abstract class AlphaMeClientNative extends Binder implements IAlphaMeClient {
    public AlphaMeClientNative() {
        attachInterface(this, IAlphaMeClient.DESCRIPTOR);
    }

    public static IAlphaMeClient asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IAlphaMeClient iAlphaMeClient = (IAlphaMeClient) iBinder.queryLocalInterface(IAlphaMeClient.DESCRIPTOR);
        return iAlphaMeClient != null ? iAlphaMeClient : new AlphaMeClientProxy(iBinder);
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        if (i4 == 1) {
            onResult(Args.CREATOR.createFromParcel(parcel));
            parcel2.writeNoException();
            return true;
        }
        if (i4 == 2) {
            onReceiver(Args.CREATOR.createFromParcel(parcel));
            parcel2.writeNoException();
            return true;
        }
        if (i4 != 1598968902) {
            return super.onTransact(i4, parcel, parcel2, i5);
        }
        parcel2.writeString(IAlphaMeClient.DESCRIPTOR);
        return true;
    }
}
