package com.stepos.perfcore;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IPerfCoreClient extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.perfcore.IPerfCoreClient";

    public static class Default implements IPerfCoreClient {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.perfcore.IPerfCoreClient
        public void onSupportConfigChange(Bundle bundle) throws RemoteException {
        }
    }

    void onSupportConfigChange(Bundle bundle) throws RemoteException;

    public static abstract class Stub extends Binder implements IPerfCoreClient {
        static final int TRANSACTION_onSupportConfigChange = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IPerfCoreClient.DESCRIPTOR);
        }

        public static IPerfCoreClient asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IPerfCoreClient.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IPerfCoreClient)) {
                return (IPerfCoreClient) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IPerfCoreClient.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IPerfCoreClient.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                Bundle bundle = (Bundle) parcel.readTypedObject(Bundle.CREATOR);
                parcel.enforceNoDataAvail();
                onSupportConfigChange(bundle);
                parcel2.writeNoException();
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements IPerfCoreClient {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IPerfCoreClient.DESCRIPTOR;
            }

            @Override // com.stepos.perfcore.IPerfCoreClient
            public void onSupportConfigChange(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IPerfCoreClient.DESCRIPTOR);
                    parcelObtain.writeTypedObject(bundle, 0);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
