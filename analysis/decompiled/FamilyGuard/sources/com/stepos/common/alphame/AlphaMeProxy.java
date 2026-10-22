package com.stepos.common.alphame;

import android.os.IBinder;
import android.os.Parcel;
import java.util.ArrayList;

/* loaded from: classes.dex */
class AlphaMeProxy implements IAlphaMe {
    private IBinder mRemote;

    public AlphaMeProxy(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    @Override // com.stepos.common.alphame.IAlphaMe
    public void addClient(IBinder iBinder) {
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
    public void collect(String str, a aVar) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeString(str);
            aVar.writeToParcel(parcelObtain, 0);
            this.mRemote.transact(6, parcelObtain, parcelObtain2, 1);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.stepos.common.alphame.IAlphaMe
    public void exec(IBinder iBinder, String str, a aVar, int i5, int i6) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeStrongBinder(iBinder);
            parcelObtain.writeString(str);
            aVar.writeToParcel(parcelObtain, 0);
            parcelObtain.writeInt(i5);
            parcelObtain.writeInt(i6);
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
    public void registerActionReceiver(IBinder iBinder, ArrayList<String> arrayList, int i5) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeStrongBinder(iBinder);
            parcelObtain.writeStringList(arrayList);
            parcelObtain.writeInt(i5);
            this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.stepos.common.alphame.IAlphaMe
    public void removeClient(IBinder iBinder) {
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
    public void unregisterActionReceiver(IBinder iBinder, int i5) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeStrongBinder(iBinder);
            parcelObtain.writeInt(i5);
            this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
