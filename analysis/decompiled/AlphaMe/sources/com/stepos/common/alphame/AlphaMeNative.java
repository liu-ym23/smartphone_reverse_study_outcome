package com.stepos.common.alphame;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class AlphaMeNative extends Binder implements IAlphaMe {
    public AlphaMeNative() {
        attachInterface(this, IAlphaMe.DESCRIPTOR);
    }

    public static IAlphaMe asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IAlphaMe iAlphaMe = (IAlphaMe) iBinder.queryLocalInterface(IAlphaMe.DESCRIPTOR);
        return iAlphaMe != null ? iAlphaMe : new AlphaMeProxy(iBinder);
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        if (i4 == 1598968902) {
            parcel2.writeString(IAlphaMe.DESCRIPTOR);
            return true;
        }
        switch (i4) {
            case 1:
                addClient(parcel.readStrongBinder());
                parcel2.writeNoException();
                return true;
            case 2:
                removeClient(parcel.readStrongBinder());
                parcel2.writeNoException();
                return true;
            case 3:
                IBinder strongBinder = parcel.readStrongBinder();
                ArrayList<String> arrayList = new ArrayList<>();
                parcel.readStringList(arrayList);
                registerActionReceiver(strongBinder, arrayList, parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 4:
                unregisterActionReceiver(parcel.readStrongBinder(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 5:
                exec(parcel.readStrongBinder(), parcel.readString(), Args.CREATOR.createFromParcel(parcel), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 6:
                collect(parcel.readString(), Args.CREATOR.createFromParcel(parcel));
                parcel2.writeNoException();
                return true;
            default:
                return super.onTransact(i4, parcel, parcel2, i5);
        }
    }
}
