package com.stepos.common.alphame;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;

/* loaded from: classes.dex */
class AlphaMeProxy implements IAlphaMe {
    private IBinder mRemote;

    public AlphaMeProxy(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    @Override // com.stepos.common.alphame.IAlphaMe
    public void addClient(IBinder iBinder) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeStrongBinder(iBinder);
            this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.mRemote;
    }

    @Override // com.stepos.common.alphame.IAlphaMe
    public void collect(String str, Args args) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeString(str);
            args.writeToParcel(parcelObtain, 0);
            this.mRemote.transact(6, parcelObtain, parcelObtain2, 1);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.stepos.common.alphame.IAlphaMe
    public void exec(IBinder iBinder, String str, Args args, int i4, int i5) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeStrongBinder(iBinder);
            parcelObtain.writeString(str);
            args.writeToParcel(parcelObtain, 0);
            parcelObtain.writeInt(i4);
            parcelObtain.writeInt(i5);
            this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    public String getInterfaceDescriptor() {
        return IAlphaMe.DESCRIPTOR;
    }

    @Override // com.stepos.common.alphame.IAlphaMe
    public void registerActionReceiver(IBinder iBinder, ArrayList<String> arrayList, int i4) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeStrongBinder(iBinder);
            parcelObtain.writeStringList(arrayList);
            parcelObtain.writeInt(i4);
            this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.stepos.common.alphame.IAlphaMe
    public void removeClient(IBinder iBinder) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeStrongBinder(iBinder);
            this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.stepos.common.alphame.IAlphaMe
    public void unregisterActionReceiver(IBinder iBinder, int i4) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeStrongBinder(iBinder);
            parcelObtain.writeInt(i4);
            this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
