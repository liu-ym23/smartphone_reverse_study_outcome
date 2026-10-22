package com.obric.download.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes4.dex */
public interface INotificationClickCallback extends IInterface {

    public static abstract class a extends Binder implements INotificationClickCallback {
        public a() {
            attachInterface(this, "com.obric.download.aidl.INotificationClickCallback");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            if (r10 != 1) goto L5;
            r11.enforceInterface("com.obric.download.aidl.INotificationClickCallback");
            onNotificationClicked(r11.readInt());
            r12.writeNoException();
            return true;
        L5:
            if (r10 != 1598968902) goto L7;
            r12.writeString("com.obric.download.aidl.INotificationClickCallback");
            return true;
        L7:
            return super.onTransact(r10, r11, r12, r13);
        }
    }

    void onNotificationClicked(int r10) throws RemoteException;
}
