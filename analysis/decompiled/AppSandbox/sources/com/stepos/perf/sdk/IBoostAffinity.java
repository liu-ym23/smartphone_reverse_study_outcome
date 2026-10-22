package com.stepos.perf.sdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IBoostAffinity extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.perf.sdk.IBoostAffinity";

    public static class Default implements IBoostAffinity {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.perf.sdk.IBoostAffinity
        public void cancelBoostAffinity(String str, int[] iArr) throws RemoteException {
        }

        @Override // com.stepos.perf.sdk.IBoostAffinity
        public void requestBoostAffinity(String str, long j, int[] iArr) throws RemoteException {
        }
    }

    void cancelBoostAffinity(String str, int[] iArr) throws RemoteException;

    void requestBoostAffinity(String str, long j, int[] iArr) throws RemoteException;

    public static abstract class Stub extends Binder implements IBoostAffinity {
        static final int TRANSACTION_cancelBoostAffinity = 2;
        static final int TRANSACTION_requestBoostAffinity = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IBoostAffinity.DESCRIPTOR);
        }

        public static IBoostAffinity asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IBoostAffinity.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IBoostAffinity)) {
                return (IBoostAffinity) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IBoostAffinity.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IBoostAffinity.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                String string = parcel.readString();
                long j = parcel.readLong();
                int[] iArrCreateIntArray = parcel.createIntArray();
                parcel.enforceNoDataAvail();
                requestBoostAffinity(string, j, iArrCreateIntArray);
            } else if (i == 2) {
                String string2 = parcel.readString();
                int[] iArrCreateIntArray2 = parcel.createIntArray();
                parcel.enforceNoDataAvail();
                cancelBoostAffinity(string2, iArrCreateIntArray2);
            } else {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            return true;
        }

        private static class Proxy implements IBoostAffinity {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IBoostAffinity.DESCRIPTOR;
            }

            @Override // com.stepos.perf.sdk.IBoostAffinity
            public void requestBoostAffinity(String str, long j, int[] iArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                try {
                    parcelObtain.writeInterfaceToken(IBoostAffinity.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeIntArray(iArr);
                    this.mRemote.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.perf.sdk.IBoostAffinity
            public void cancelBoostAffinity(String str, int[] iArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                try {
                    parcelObtain.writeInterfaceToken(IBoostAffinity.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeIntArray(iArr);
                    this.mRemote.transact(2, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }
    }
}
