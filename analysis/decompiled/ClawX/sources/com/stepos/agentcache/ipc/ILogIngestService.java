package com.stepos.agentcache.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public interface ILogIngestService extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.agentcache.ipc.ILogIngestService";

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    public static class _Parcel {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedList(Parcel parcel, List<T> list, int i8) {
            if (list == null) {
                parcel.writeInt(-1);
                return;
            }
            int size = list.size();
            parcel.writeInt(size);
            for (int i9 = 0; i9 < size; i9++) {
                writeTypedObject(parcel, list.get(i9), i8);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t8, int i8) {
            if (t8 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t8.writeToParcel(parcel, i8);
            }
        }
    }

    void cacheEvent(LogEventParcel logEventParcel);

    void cacheEvents(List<LogEventParcel> list);

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    public static abstract class Stub extends Binder implements ILogIngestService {
        static final int TRANSACTION_cacheEvent = 1;
        static final int TRANSACTION_cacheEvents = 2;

        /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
        public static class Proxy implements ILogIngestService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.stepos.agentcache.ipc.ILogIngestService
            public void cacheEvent(LogEventParcel logEventParcel) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ILogIngestService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, logEventParcel, 0);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.agentcache.ipc.ILogIngestService
            public void cacheEvents(List<LogEventParcel> list) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ILogIngestService.DESCRIPTOR);
                    _Parcel.writeTypedList(parcelObtain, list, 0);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return ILogIngestService.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, ILogIngestService.DESCRIPTOR);
        }

        public static ILogIngestService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ILogIngestService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ILogIngestService)) ? new Proxy(iBinder) : (ILogIngestService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i8, Parcel parcel, Parcel parcel2, int i9) {
            if (i8 >= 1 && i8 <= 16777215) {
                parcel.enforceInterface(ILogIngestService.DESCRIPTOR);
            }
            if (i8 == 1598968902) {
                parcel2.writeString(ILogIngestService.DESCRIPTOR);
                return true;
            }
            if (i8 == 1) {
                cacheEvent((LogEventParcel) _Parcel.readTypedObject(parcel, LogEventParcel.CREATOR));
                parcel2.writeNoException();
                return true;
            }
            if (i8 != 2) {
                return super.onTransact(i8, parcel, parcel2, i9);
            }
            cacheEvents(parcel.createTypedArrayList(LogEventParcel.CREATOR));
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    public static class Default implements ILogIngestService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.agentcache.ipc.ILogIngestService
        public void cacheEvent(LogEventParcel logEventParcel) {
        }

        @Override // com.stepos.agentcache.ipc.ILogIngestService
        public void cacheEvents(List<LogEventParcel> list) {
        }
    }
}
