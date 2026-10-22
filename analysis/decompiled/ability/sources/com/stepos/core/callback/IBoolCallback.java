package com.stepos.core.callback;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes3.dex */
public interface IBoolCallback extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.core.callback.IBoolCallback";

    public static class Default implements IBoolCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.core.callback.IBoolCallback
        public void onResult(boolean z10, String str) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IBoolCallback {
        static final int TRANSACTION_onResult = 1;

        public static class Proxy implements IBoolCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IBoolCallback.DESCRIPTOR;
            }

            @Override // com.stepos.core.callback.IBoolCallback
            public void onResult(boolean z10, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IBoolCallback.DESCRIPTOR);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IBoolCallback.DESCRIPTOR);
        }

        public static IBoolCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IBoolCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IBoolCallback)) ? new Proxy(iBinder) : (IBoolCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i6) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IBoolCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IBoolCallback.DESCRIPTOR);
                return true;
            }
            if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i6);
            }
            onResult(parcel.readInt() != 0, parcel.readString());
            parcel2.writeNoException();
            return true;
        }
    }

    void onResult(boolean z10, String str) throws RemoteException;
}
