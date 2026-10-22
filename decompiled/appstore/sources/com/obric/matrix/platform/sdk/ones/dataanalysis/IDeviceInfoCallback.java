package com.obric.matrix.platform.sdk.ones.dataanalysis;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes4.dex */
public interface IDeviceInfoCallback extends IInterface {

    public static abstract class a extends Binder implements IDeviceInfoCallback {
        public a() {
            attachInterface(this, "com.obric.matrix.platform.sdk.ones.dataanalysis.IDeviceInfoCallback");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            if (r10 != 1) goto L5;
            r11.enforceInterface("com.obric.matrix.platform.sdk.ones.dataanalysis.IDeviceInfoCallback");
            onDeviceId(r11.readString());
            r12.writeNoException();
            return true;
        L5:
            if (r10 != 2) goto L7;
            r11.enforceInterface("com.obric.matrix.platform.sdk.ones.dataanalysis.IDeviceInfoCallback");
            onInstallId(r11.readString());
            r12.writeNoException();
            return true;
        L7:
            if (r10 != 1598968902) goto L9;
            r12.writeString("com.obric.matrix.platform.sdk.ones.dataanalysis.IDeviceInfoCallback");
            return true;
        L9:
            return super.onTransact(r10, r11, r12, r13);
        }
    }

    void onDeviceId(String r10) throws RemoteException;

    void onInstallId(String r10) throws RemoteException;
}
