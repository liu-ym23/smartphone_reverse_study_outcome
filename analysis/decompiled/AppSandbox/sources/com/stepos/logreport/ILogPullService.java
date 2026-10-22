package com.stepos.logreport;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface ILogPullService extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.logreport.ILogPullService";

    public static class Default implements ILogPullService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.logreport.ILogPullService
        public String queryLogFiles(long j, long j2, String str) throws RemoteException {
            return null;
        }
    }

    String queryLogFiles(long j, long j2, String str) throws RemoteException;

    public static abstract class Stub extends Binder implements ILogPullService {
        static final int TRANSACTION_queryLogFiles = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, ILogPullService.DESCRIPTOR);
        }

        public static ILogPullService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ILogPullService.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof ILogPullService)) {
                return (ILogPullService) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(ILogPullService.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(ILogPullService.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                long j = parcel.readLong();
                long j2 = parcel.readLong();
                String string = parcel.readString();
                parcel.enforceNoDataAvail();
                String strQueryLogFiles = queryLogFiles(j, j2, string);
                parcel2.writeNoException();
                parcel2.writeString(strQueryLogFiles);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements ILogPullService {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ILogPullService.DESCRIPTOR;
            }

            @Override // com.stepos.logreport.ILogPullService
            public String queryLogFiles(long j, long j2, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ILogPullService.DESCRIPTOR);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeLong(j2);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
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
