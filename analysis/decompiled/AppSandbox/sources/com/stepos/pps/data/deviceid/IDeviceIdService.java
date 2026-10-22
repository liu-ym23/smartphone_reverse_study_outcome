package com.stepos.pps.data.deviceid;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IDeviceIdService extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.pps.data.deviceid.IDeviceIdService";

    public static class Default implements IDeviceIdService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.pps.data.deviceid.IDeviceIdService
        public String getDsid() throws RemoteException {
            return null;
        }

        @Override // com.stepos.pps.data.deviceid.IDeviceIdService
        public String getOaid() throws RemoteException {
            return null;
        }
    }

    String getDsid() throws RemoteException;

    String getOaid() throws RemoteException;

    public static abstract class Stub extends Binder implements IDeviceIdService {
        static final int TRANSACTION_getDsid = 2;
        static final int TRANSACTION_getOaid = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IDeviceIdService.DESCRIPTOR);
        }

        public static IDeviceIdService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IDeviceIdService.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IDeviceIdService)) {
                return (IDeviceIdService) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IDeviceIdService.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IDeviceIdService.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                String oaid = getOaid();
                parcel2.writeNoException();
                parcel2.writeString(oaid);
            } else if (i == 2) {
                String dsid = getDsid();
                parcel2.writeNoException();
                parcel2.writeString(dsid);
            } else {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            return true;
        }

        private static class Proxy implements IDeviceIdService {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IDeviceIdService.DESCRIPTOR;
            }

            @Override // com.stepos.pps.data.deviceid.IDeviceIdService
            public String getOaid() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDeviceIdService.DESCRIPTOR);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.pps.data.deviceid.IDeviceIdService
            public String getDsid() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDeviceIdService.DESCRIPTOR);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
