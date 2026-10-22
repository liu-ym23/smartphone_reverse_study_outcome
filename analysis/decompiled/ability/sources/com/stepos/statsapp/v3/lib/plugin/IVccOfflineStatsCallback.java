package com.stepos.statsapp.v3.lib.plugin;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* loaded from: classes3.dex */
public interface IVccOfflineStatsCallback extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsCallback";

    public static class Default implements IVccOfflineStatsCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsCallback
        public void onRealBulkInsertEvents(String str, List list) throws RemoteException {
        }

        @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsCallback
        public void onRealInsertEvent(String str, long j5) throws RemoteException {
        }

        @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsCallback
        public void onRealInsertH5Event(String str, long j5) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IVccOfflineStatsCallback {
        static final int TRANSACTION_onRealBulkInsertEvents = 2;
        static final int TRANSACTION_onRealInsertEvent = 1;
        static final int TRANSACTION_onRealInsertH5Event = 3;

        public static class Proxy implements IVccOfflineStatsCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IVccOfflineStatsCallback.DESCRIPTOR;
            }

            @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsCallback
            public void onRealBulkInsertEvents(String str, List list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVccOfflineStatsCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeList(list);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsCallback
            public void onRealInsertEvent(String str, long j5) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVccOfflineStatsCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeLong(j5);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsCallback
            public void onRealInsertH5Event(String str, long j5) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVccOfflineStatsCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeLong(j5);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IVccOfflineStatsCallback.DESCRIPTOR);
        }

        public static IVccOfflineStatsCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IVccOfflineStatsCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IVccOfflineStatsCallback)) ? new Proxy(iBinder) : (IVccOfflineStatsCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i6) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IVccOfflineStatsCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IVccOfflineStatsCallback.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                onRealInsertEvent(parcel.readString(), parcel.readLong());
                parcel2.writeNoException();
            } else if (i == 2) {
                onRealBulkInsertEvents(parcel.readString(), parcel.readArrayList(getClass().getClassLoader()));
                parcel2.writeNoException();
            } else {
                if (i != 3) {
                    return super.onTransact(i, parcel, parcel2, i6);
                }
                onRealInsertH5Event(parcel.readString(), parcel.readLong());
                parcel2.writeNoException();
            }
            return true;
        }
    }

    void onRealBulkInsertEvents(String str, List list) throws RemoteException;

    void onRealInsertEvent(String str, long j5) throws RemoteException;

    void onRealInsertH5Event(String str, long j5) throws RemoteException;
}
