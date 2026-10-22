package com.stepos.secureservice.policy;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.stepos.secureservice.policy.IPolicyBindCallback;

/* loaded from: classes.dex */
public interface IPolicyBindService extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.secureservice.policy.IPolicyBindService";

    public static class Default implements IPolicyBindService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.secureservice.policy.IPolicyBindService
        public void getPrivateConfig(IPolicyBindCallback iPolicyBindCallback, String str, int i10, String str2) throws RemoteException {
        }

        @Override // com.stepos.secureservice.policy.IPolicyBindService
        public void getPublicConfig(IPolicyBindCallback iPolicyBindCallback, String str, int i10) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IPolicyBindService {
        static final int TRANSACTION_getPrivateConfig = 2;
        static final int TRANSACTION_getPublicConfig = 1;

        public static class Proxy implements IPolicyBindService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IPolicyBindService.DESCRIPTOR;
            }

            @Override // com.stepos.secureservice.policy.IPolicyBindService
            public void getPrivateConfig(IPolicyBindCallback iPolicyBindCallback, String str, int i10, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IPolicyBindService.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iPolicyBindCallback);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.secureservice.policy.IPolicyBindService
            public void getPublicConfig(IPolicyBindCallback iPolicyBindCallback, String str, int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IPolicyBindService.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iPolicyBindCallback);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IPolicyBindService.DESCRIPTOR);
        }

        public static IPolicyBindService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IPolicyBindService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IPolicyBindService)) ? new Proxy(iBinder) : (IPolicyBindService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(IPolicyBindService.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(IPolicyBindService.DESCRIPTOR);
                return true;
            }
            if (i10 == 1) {
                getPublicConfig(IPolicyBindCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
            } else {
                if (i10 != 2) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                getPrivateConfig(IPolicyBindCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
            }
            return true;
        }
    }

    void getPrivateConfig(IPolicyBindCallback iPolicyBindCallback, String str, int i10, String str2) throws RemoteException;

    void getPublicConfig(IPolicyBindCallback iPolicyBindCallback, String str, int i10) throws RemoteException;
}
