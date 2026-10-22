package com.stepos.agentcache.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: classes.dex */
public interface ILogIngestService extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.agentcache.ipc.ILogIngestService";

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

        @Override // com.stepos.agentcache.ipc.ILogIngestService
        public void cacheLog(LogRecordParcel logRecordParcel) {
        }

        @Override // com.stepos.agentcache.ipc.ILogIngestService
        public void cacheLogs(List<LogRecordParcel> list) {
        }
    }

    public static abstract class Stub extends Binder implements ILogIngestService {
        static final int TRANSACTION_cacheEvent = 1;
        static final int TRANSACTION_cacheEvents = 2;
        static final int TRANSACTION_cacheLog = 3;
        static final int TRANSACTION_cacheLogs = 4;

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

            @Override // com.stepos.agentcache.ipc.ILogIngestService
            public void cacheLog(LogRecordParcel logRecordParcel) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ILogIngestService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, logRecordParcel, 0);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.agentcache.ipc.ILogIngestService
            public void cacheLogs(List<LogRecordParcel> list) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ILogIngestService.DESCRIPTOR);
                    _Parcel.writeTypedList(parcelObtain, list, 0);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
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

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i10) {
            if (i2 >= 1 && i2 <= 16777215) {
                parcel.enforceInterface(ILogIngestService.DESCRIPTOR);
            }
            if (i2 == 1598968902) {
                parcel2.writeString(ILogIngestService.DESCRIPTOR);
                return true;
            }
            if (i2 == 1) {
                cacheEvent((LogEventParcel) _Parcel.readTypedObject(parcel, LogEventParcel.CREATOR));
                parcel2.writeNoException();
            } else if (i2 == 2) {
                cacheEvents(parcel.createTypedArrayList(LogEventParcel.CREATOR));
                parcel2.writeNoException();
            } else if (i2 == 3) {
                cacheLog((LogRecordParcel) _Parcel.readTypedObject(parcel, LogRecordParcel.CREATOR));
                parcel2.writeNoException();
            } else {
                if (i2 != 4) {
                    return super.onTransact(i2, parcel, parcel2, i10);
                }
                cacheLogs(parcel.createTypedArrayList(LogRecordParcel.CREATOR));
                parcel2.writeNoException();
            }
            return true;
        }
    }

    public static class _Parcel {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedList(Parcel parcel, List<T> list, int i2) {
            if (list == null) {
                parcel.writeInt(-1);
                return;
            }
            int size = list.size();
            parcel.writeInt(size);
            for (int i10 = 0; i10 < size; i10++) {
                writeTypedObject(parcel, list.get(i10), i2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t2, int i2) {
            if (t2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t2.writeToParcel(parcel, i2);
            }
        }
    }

    void cacheEvent(LogEventParcel logEventParcel);

    void cacheEvents(List<LogEventParcel> list);

    void cacheLog(LogRecordParcel logRecordParcel);

    void cacheLogs(List<LogRecordParcel> list);
}
