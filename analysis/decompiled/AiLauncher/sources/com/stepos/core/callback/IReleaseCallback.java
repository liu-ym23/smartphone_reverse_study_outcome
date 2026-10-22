package com.stepos.core.callback;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes3.dex */
public interface IReleaseCallback extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.core.callback.IReleaseCallback";

    public static class Default implements IReleaseCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.core.callback.IReleaseCallback
        public void onReleased(String str, int i10, String str2) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IReleaseCallback {
        static final int TRANSACTION_onReleased = 1;

        public static class Proxy implements IReleaseCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IReleaseCallback.DESCRIPTOR;
            }

            @Override // com.stepos.core.callback.IReleaseCallback
            public void onReleased(String str, int i10, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IReleaseCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IReleaseCallback.DESCRIPTOR);
        }

        public static IReleaseCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IReleaseCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IReleaseCallback)) ? new Proxy(iBinder) : (IReleaseCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(IReleaseCallback.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(IReleaseCallback.DESCRIPTOR);
                return true;
            }
            if (i10 != 1) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            onReleased(parcel.readString(), parcel.readInt(), parcel.readString());
            return true;
        }
    }

    void onReleased(String str, int i10, String str2) throws RemoteException;
}
