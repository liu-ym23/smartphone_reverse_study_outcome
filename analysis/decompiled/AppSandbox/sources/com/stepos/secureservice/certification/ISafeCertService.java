package com.stepos.secureservice.certification;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.stepos.secureservice.certification.IOAIDCallback;

/* loaded from: classes.dex */
public interface ISafeCertService extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.secureservice.certification.ISafeCertService";

    public static class Default implements ISafeCertService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.secureservice.certification.ISafeCertService
        public void getOAID(IOAIDCallback iOAIDCallback) throws RemoteException {
        }
    }

    void getOAID(IOAIDCallback iOAIDCallback) throws RemoteException;

    public static abstract class Stub extends Binder implements ISafeCertService {
        static final int TRANSACTION_getOAID = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, ISafeCertService.DESCRIPTOR);
        }

        public static ISafeCertService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ISafeCertService.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof ISafeCertService)) {
                return (ISafeCertService) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(ISafeCertService.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(ISafeCertService.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                IOAIDCallback iOAIDCallbackAsInterface = IOAIDCallback.Stub.asInterface(parcel.readStrongBinder());
                parcel.enforceNoDataAvail();
                getOAID(iOAIDCallbackAsInterface);
                parcel2.writeNoException();
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements ISafeCertService {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ISafeCertService.DESCRIPTOR;
            }

            @Override // com.stepos.secureservice.certification.ISafeCertService
            public void getOAID(IOAIDCallback iOAIDCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISafeCertService.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iOAIDCallback);
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
