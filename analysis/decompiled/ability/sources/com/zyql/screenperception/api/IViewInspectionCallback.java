package com.zyql.screenperception.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public interface IViewInspectionCallback extends IInterface {
    public static final String DESCRIPTOR = "com.zyql.screenperception.api.IViewInspectionCallback";

    public static class Default implements IViewInspectionCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.zyql.screenperception.api.IViewInspectionCallback
        public void onError(int i, String str) throws RemoteException {
        }

        @Override // com.zyql.screenperception.api.IViewInspectionCallback
        public void onEventReceived(String str) throws RemoteException {
        }

        @Override // com.zyql.screenperception.api.IViewInspectionCallback
        public void onViewDetailsSuccess(String str) throws RemoteException {
        }

        @Override // com.zyql.screenperception.api.IViewInspectionCallback
        public void onViewTreeSuccess(String str) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IViewInspectionCallback {
        static final int TRANSACTION_onError = 4;
        static final int TRANSACTION_onEventReceived = 3;
        static final int TRANSACTION_onViewDetailsSuccess = 2;
        static final int TRANSACTION_onViewTreeSuccess = 1;

        public static class Proxy implements IViewInspectionCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IViewInspectionCallback.DESCRIPTOR;
            }

            @Override // com.zyql.screenperception.api.IViewInspectionCallback
            public void onError(int i, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IViewInspectionCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.screenperception.api.IViewInspectionCallback
            public void onEventReceived(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IViewInspectionCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.screenperception.api.IViewInspectionCallback
            public void onViewDetailsSuccess(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IViewInspectionCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.screenperception.api.IViewInspectionCallback
            public void onViewTreeSuccess(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IViewInspectionCallback.DESCRIPTOR);
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
            attachInterface(this, IViewInspectionCallback.DESCRIPTOR);
        }

        public static IViewInspectionCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IViewInspectionCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IViewInspectionCallback)) ? new Proxy(iBinder) : (IViewInspectionCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i6) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IViewInspectionCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IViewInspectionCallback.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                onViewTreeSuccess(parcel.readString());
                parcel2.writeNoException();
            } else if (i == 2) {
                onViewDetailsSuccess(parcel.readString());
                parcel2.writeNoException();
            } else if (i == 3) {
                onEventReceived(parcel.readString());
                parcel2.writeNoException();
            } else {
                if (i != 4) {
                    return super.onTransact(i, parcel, parcel2, i6);
                }
                onError(parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
            }
            return true;
        }
    }

    void onError(int i, String str) throws RemoteException;

    void onEventReceived(String str) throws RemoteException;

    void onViewDetailsSuccess(String str) throws RemoteException;

    void onViewTreeSuccess(String str) throws RemoteException;
}
