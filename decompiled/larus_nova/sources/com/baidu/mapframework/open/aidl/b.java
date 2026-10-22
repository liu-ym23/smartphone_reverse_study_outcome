package com.baidu.mapframework.open.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes39.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "com.baidu.mapframework.open.aidl.IOpenClientCallback");
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            if (r100 != 1) goto L5;
            r101.enforceInterface("com.baidu.mapframework.open.aidl.IOpenClientCallback");
            a(r101.readStrongBinder());
            r102.writeNoException();
            return true;
        L5:
            if (r100 != 1598968902) goto L7;
            r102.writeString("com.baidu.mapframework.open.aidl.IOpenClientCallback");
            return true;
        L7:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    void a(IBinder r100) throws RemoteException;
}
