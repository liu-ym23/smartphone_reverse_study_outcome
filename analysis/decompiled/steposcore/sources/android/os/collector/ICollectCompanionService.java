package android.os.collector;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface ICollectCompanionService extends IInterface {
    public static final String DESCRIPTOR = "android.os.collector.ICollectCompanionService";

    void collectdReady() throws RemoteException;

    void setPullingAlarm(long j) throws RemoteException;

    public static class Default implements ICollectCompanionService {
        @Override // android.os.collector.ICollectCompanionService
        public void collectdReady() throws RemoteException {
        }

        @Override // android.os.collector.ICollectCompanionService
        public void setPullingAlarm(long nextPullTimeMs) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ICollectCompanionService {
        static final int TRANSACTION_collectdReady = 1;
        static final int TRANSACTION_setPullingAlarm = 2;

        public Stub() {
            attachInterface(this, ICollectCompanionService.DESCRIPTOR);
        }

        public static ICollectCompanionService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(ICollectCompanionService.DESCRIPTOR);
            if (iin != null && (iin instanceof ICollectCompanionService)) {
                return (ICollectCompanionService) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static String getDefaultTransactionName(int transactionCode) {
            switch (transactionCode) {
                case 1:
                    return "collectdReady";
                case 2:
                    return "setPullingAlarm";
                default:
                    return null;
            }
        }

        public String getTransactionName(int transactionCode) {
            return getDefaultTransactionName(transactionCode);
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code >= 1 && code <= 16777215) {
                data.enforceInterface(ICollectCompanionService.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(ICollectCompanionService.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    collectdReady();
                    return true;
                case 2:
                    long _arg0 = data.readLong();
                    setPullingAlarm(_arg0);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements ICollectCompanionService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ICollectCompanionService.DESCRIPTOR;
            }

            @Override // android.os.collector.ICollectCompanionService
            public void collectdReady() throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ICollectCompanionService.DESCRIPTOR);
                    this.mRemote.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.os.collector.ICollectCompanionService
            public void setPullingAlarm(long nextPullTimeMs) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ICollectCompanionService.DESCRIPTOR);
                    _data.writeLong(nextPullTimeMs);
                    this.mRemote.transact(2, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 1;
        }
    }
}
