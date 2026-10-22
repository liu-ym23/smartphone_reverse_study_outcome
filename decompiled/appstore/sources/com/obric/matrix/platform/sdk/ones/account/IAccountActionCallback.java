package com.obric.matrix.platform.sdk.ones.account;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes4.dex */
public interface IAccountActionCallback extends IInterface {

    public static abstract class a extends Binder implements IAccountActionCallback {
        public a() {
            attachInterface(this, "com.obric.matrix.platform.sdk.ones.account.IAccountActionCallback");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            if (r10 != 1) goto L5;
            r11.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountActionCallback");
            if (r11.readInt() == 0) goto L13;
            boolean r14 = true;
        L15:
            if (r11.readInt() == 0) goto L17;
            Bundle r15 = (Bundle) Bundle.CREATOR.createFromParcel(r11);
        L18:
            onResult(r14, r15);
            return true;
        L17:
            r15 = null;
            goto L18
        L13:
            r14 = false;
            goto L15
        L5:
            if (r10 != 1598968902) goto L7;
            r12.writeString("com.obric.matrix.platform.sdk.ones.account.IAccountActionCallback");
            return true;
        L7:
            return super.onTransact(r10, r11, r12, r13);
        }
    }

    void onResult(boolean r10, Bundle r11) throws RemoteException;
}
