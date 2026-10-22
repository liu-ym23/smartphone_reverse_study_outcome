package com.stepos.common.alphame;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
class AlphaMeClientProxy implements IAlphaMeClient {
    private IBinder mRemote;

    public AlphaMeClientProxy(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.mRemote;
    }

    public String getInterfaceDescriptor() {
        return IAlphaMeClient.DESCRIPTOR;
    }

    @Override // com.stepos.common.alphame.IAlphaMeClient
    public void onReceiver(Args args) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            args.writeToParcel(parcelObtain, 0);
            this.mRemote.transact(2, parcelObtain, parcelObtain2, 1);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.stepos.common.alphame.IAlphaMeClient
    public void onResult(Args args) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            args.writeToParcel(parcelObtain, 0);
            this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
