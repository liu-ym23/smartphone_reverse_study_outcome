package com.stepos.taskrobot.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes3.dex */
public interface ITaskTakeoverCallback extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.taskrobot.common.ITaskTakeoverCallback";

    public static class Default implements ITaskTakeoverCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.taskrobot.common.ITaskTakeoverCallback
        public void onTakeoverResult(String str, boolean z10) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ITaskTakeoverCallback {
        static final int TRANSACTION_onTakeoverResult = 1;

        public static class Proxy implements ITaskTakeoverCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ITaskTakeoverCallback.DESCRIPTOR;
            }

            @Override // com.stepos.taskrobot.common.ITaskTakeoverCallback
            public void onTakeoverResult(String str, boolean z10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskTakeoverCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ITaskTakeoverCallback.DESCRIPTOR);
        }

        public static ITaskTakeoverCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ITaskTakeoverCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ITaskTakeoverCallback)) ? new Proxy(iBinder) : (ITaskTakeoverCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i6) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(ITaskTakeoverCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(ITaskTakeoverCallback.DESCRIPTOR);
                return true;
            }
            if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i6);
            }
            onTakeoverResult(parcel.readString(), parcel.readInt() != 0);
            parcel2.writeNoException();
            return true;
        }
    }

    void onTakeoverResult(String str, boolean z10) throws RemoteException;
}
