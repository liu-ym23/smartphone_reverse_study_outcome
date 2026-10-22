package android.os.collector;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.collector.IStepOSDataResultCallback;
import android.os.collector.IStepOSDataSubscriptionCallback;

/* loaded from: classes.dex */
public interface IStepOSDataCollectManager extends IInterface {
    public static final String DESCRIPTOR = "android.os.collector.IStepOSDataCollectManager";

    void addSubscription(int[] iArr, IStepOSDataSubscriptionCallback iStepOSDataSubscriptionCallback) throws RemoteException;

    boolean getData(int i, long j, long j2, IStepOSDataResultCallback iStepOSDataResultCallback) throws RemoteException;

    CollectEventParcel[] getDataByConfig(long j) throws RemoteException;

    void removeSubscription(IStepOSDataSubscriptionCallback iStepOSDataSubscriptionCallback) throws RemoteException;

    public static class Default implements IStepOSDataCollectManager {
        @Override // android.os.collector.IStepOSDataCollectManager
        public boolean getData(int atomId, long from, long duration, IStepOSDataResultCallback callback) throws RemoteException {
            return false;
        }

        @Override // android.os.collector.IStepOSDataCollectManager
        public void addSubscription(int[] atomIds, IStepOSDataSubscriptionCallback callback) throws RemoteException {
        }

        @Override // android.os.collector.IStepOSDataCollectManager
        public void removeSubscription(IStepOSDataSubscriptionCallback callback) throws RemoteException {
        }

        @Override // android.os.collector.IStepOSDataCollectManager
        public CollectEventParcel[] getDataByConfig(long configId) throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IStepOSDataCollectManager {
        static final int TRANSACTION_addSubscription = 2;
        static final int TRANSACTION_getData = 1;
        static final int TRANSACTION_getDataByConfig = 4;
        static final int TRANSACTION_removeSubscription = 3;

        public Stub() {
            attachInterface(this, IStepOSDataCollectManager.DESCRIPTOR);
        }

        public static IStepOSDataCollectManager asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IStepOSDataCollectManager.DESCRIPTOR);
            if (iin != null && (iin instanceof IStepOSDataCollectManager)) {
                return (IStepOSDataCollectManager) iin;
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
                    return "getData";
                case 2:
                    return "addSubscription";
                case 3:
                    return "removeSubscription";
                case 4:
                    return "getDataByConfig";
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
                data.enforceInterface(IStepOSDataCollectManager.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IStepOSDataCollectManager.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    int _arg0 = data.readInt();
                    long _arg1 = data.readLong();
                    long _arg2 = data.readLong();
                    IStepOSDataResultCallback _arg3 = IStepOSDataResultCallback.Stub.asInterface(data.readStrongBinder());
                    boolean _result = getData(_arg0, _arg1, _arg2, _arg3);
                    reply.writeNoException();
                    reply.writeBoolean(_result);
                    return true;
                case 2:
                    int[] _arg02 = data.createIntArray();
                    IStepOSDataSubscriptionCallback _arg12 = IStepOSDataSubscriptionCallback.Stub.asInterface(data.readStrongBinder());
                    addSubscription(_arg02, _arg12);
                    reply.writeNoException();
                    return true;
                case 3:
                    IStepOSDataSubscriptionCallback _arg03 = IStepOSDataSubscriptionCallback.Stub.asInterface(data.readStrongBinder());
                    removeSubscription(_arg03);
                    reply.writeNoException();
                    return true;
                case 4:
                    long _arg04 = data.readLong();
                    CollectEventParcel[] _result2 = getDataByConfig(_arg04);
                    reply.writeNoException();
                    reply.writeTypedArray(_result2, 1);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IStepOSDataCollectManager {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IStepOSDataCollectManager.DESCRIPTOR;
            }

            @Override // android.os.collector.IStepOSDataCollectManager
            public boolean getData(int atomId, long from, long duration, IStepOSDataResultCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDataCollectManager.DESCRIPTOR);
                    _data.writeInt(atomId);
                    _data.writeLong(from);
                    _data.writeLong(duration);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.os.collector.IStepOSDataCollectManager
            public void addSubscription(int[] atomIds, IStepOSDataSubscriptionCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDataCollectManager.DESCRIPTOR);
                    _data.writeIntArray(atomIds);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.os.collector.IStepOSDataCollectManager
            public void removeSubscription(IStepOSDataSubscriptionCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDataCollectManager.DESCRIPTOR);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.os.collector.IStepOSDataCollectManager
            public CollectEventParcel[] getDataByConfig(long configId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDataCollectManager.DESCRIPTOR);
                    _data.writeLong(configId);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                    CollectEventParcel[] _result = (CollectEventParcel[]) _reply.createTypedArray(CollectEventParcel.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 3;
        }
    }
}
