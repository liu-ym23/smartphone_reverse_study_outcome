package com.stepos.statsapp.v3.lib.plugin;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface IVccOfflineStatsCallback extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsCallback";

    void onRealBulkInsertEvents(String str, List list);

    void onRealInsertEvent(String str, long j10);

    void onRealInsertH5Event(String str, long j10);

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static abstract class Stub extends Binder implements IVccOfflineStatsCallback {
        static final int TRANSACTION_onRealBulkInsertEvents = 2;
        static final int TRANSACTION_onRealInsertEvent = 1;
        static final int TRANSACTION_onRealInsertH5Event = 3;

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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
            public void onRealBulkInsertEvents(String str, List list) {
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
            public void onRealInsertEvent(String str, long j10) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVccOfflineStatsCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeLong(j10);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsCallback
            public void onRealInsertH5Event(String str, long j10) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVccOfflineStatsCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeLong(j10);
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

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i3) {
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
                    return super.onTransact(i, parcel, parcel2, i3);
                }
                onRealInsertH5Event(parcel.readString(), parcel.readLong());
                parcel2.writeNoException();
            }
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class Default implements IVccOfflineStatsCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsCallback
        public void onRealBulkInsertEvents(String str, List list) {
        }

        @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsCallback
        public void onRealInsertEvent(String str, long j10) {
        }

        @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsCallback
        public void onRealInsertH5Event(String str, long j10) {
        }
    }
}
