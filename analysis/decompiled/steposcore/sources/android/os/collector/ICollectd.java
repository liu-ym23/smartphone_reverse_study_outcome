package android.os.collector;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.collector.ICollectPullCallback;
import android.os.collector.ICollectResultCallback;
import android.os.collector.ICollectSubscriptionCallback;

/* loaded from: classes.dex */
public interface ICollectd extends IInterface {
    public static final String DESCRIPTOR = "android.os.collector.ICollectd";

    void addConfiguration(long j, byte[] bArr, int i) throws RemoteException;

    void addSubscription(int[] iArr, ICollectSubscriptionCallback iCollectSubscriptionCallback) throws RemoteException;

    void bootCompleted() throws RemoteException;

    void collectCompanionReady() throws RemoteException;

    void getData(int i, long j, long j2, ICollectResultCallback iCollectResultCallback) throws RemoteException;

    CollectEventParcel[] getDataForAtoms(int[] iArr, long j, long j2) throws RemoteException;

    void informPollAlarmFired() throws RemoteException;

    void registerPullAtomCallback(int i, int i2, long j, long j2, ICollectPullCallback iCollectPullCallback) throws RemoteException;

    void removeConfiguration(long j, int i) throws RemoteException;

    void removeSubscription(ICollectSubscriptionCallback iCollectSubscriptionCallback) throws RemoteException;

    void systemRunning() throws RemoteException;

    public static class Default implements ICollectd {
        @Override // android.os.collector.ICollectd
        public void systemRunning() throws RemoteException {
        }

        @Override // android.os.collector.ICollectd
        public void bootCompleted() throws RemoteException {
        }

        @Override // android.os.collector.ICollectd
        public void registerPullAtomCallback(int uid, int atomTag, long coolDownMillis, long timeoutMillis, ICollectPullCallback pullerCallback) throws RemoteException {
        }

        @Override // android.os.collector.ICollectd
        public void informPollAlarmFired() throws RemoteException {
        }

        @Override // android.os.collector.ICollectd
        public void collectCompanionReady() throws RemoteException {
        }

        @Override // android.os.collector.ICollectd
        public void addConfiguration(long configId, byte[] config, int callingUid) throws RemoteException {
        }

        @Override // android.os.collector.ICollectd
        public void removeConfiguration(long configId, int callingUid) throws RemoteException {
        }

        @Override // android.os.collector.ICollectd
        public void addSubscription(int[] atomIds, ICollectSubscriptionCallback callback) throws RemoteException {
        }

        @Override // android.os.collector.ICollectd
        public void removeSubscription(ICollectSubscriptionCallback callback) throws RemoteException {
        }

        @Override // android.os.collector.ICollectd
        public void getData(int atomId, long from, long duration, ICollectResultCallback callback) throws RemoteException {
        }

        @Override // android.os.collector.ICollectd
        public CollectEventParcel[] getDataForAtoms(int[] atomIds, long from, long duration) throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ICollectd {
        static final int TRANSACTION_addConfiguration = 6;
        static final int TRANSACTION_addSubscription = 8;
        static final int TRANSACTION_bootCompleted = 2;
        static final int TRANSACTION_collectCompanionReady = 5;
        static final int TRANSACTION_getData = 10;
        static final int TRANSACTION_getDataForAtoms = 11;
        static final int TRANSACTION_informPollAlarmFired = 4;
        static final int TRANSACTION_registerPullAtomCallback = 3;
        static final int TRANSACTION_removeConfiguration = 7;
        static final int TRANSACTION_removeSubscription = 9;
        static final int TRANSACTION_systemRunning = 1;

        public Stub() {
            attachInterface(this, ICollectd.DESCRIPTOR);
        }

        public static ICollectd asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(ICollectd.DESCRIPTOR);
            if (iin != null && (iin instanceof ICollectd)) {
                return (ICollectd) iin;
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
                    return "systemRunning";
                case 2:
                    return "bootCompleted";
                case 3:
                    return "registerPullAtomCallback";
                case 4:
                    return "informPollAlarmFired";
                case 5:
                    return "collectCompanionReady";
                case 6:
                    return "addConfiguration";
                case 7:
                    return "removeConfiguration";
                case 8:
                    return "addSubscription";
                case 9:
                    return "removeSubscription";
                case 10:
                    return "getData";
                case 11:
                    return "getDataForAtoms";
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
                data.enforceInterface(ICollectd.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(ICollectd.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    systemRunning();
                    return true;
                case 2:
                    bootCompleted();
                    return true;
                case 3:
                    int _arg0 = data.readInt();
                    int _arg1 = data.readInt();
                    long _arg2 = data.readLong();
                    long _arg3 = data.readLong();
                    ICollectPullCallback _arg4 = ICollectPullCallback.Stub.asInterface(data.readStrongBinder());
                    registerPullAtomCallback(_arg0, _arg1, _arg2, _arg3, _arg4);
                    return true;
                case 4:
                    informPollAlarmFired();
                    reply.writeNoException();
                    return true;
                case 5:
                    collectCompanionReady();
                    reply.writeNoException();
                    return true;
                case 6:
                    long _arg02 = data.readLong();
                    byte[] _arg12 = data.createByteArray();
                    int _arg22 = data.readInt();
                    addConfiguration(_arg02, _arg12, _arg22);
                    reply.writeNoException();
                    return true;
                case 7:
                    long _arg03 = data.readLong();
                    int _arg13 = data.readInt();
                    removeConfiguration(_arg03, _arg13);
                    reply.writeNoException();
                    return true;
                case 8:
                    int[] _arg04 = data.createIntArray();
                    ICollectSubscriptionCallback _arg14 = ICollectSubscriptionCallback.Stub.asInterface(data.readStrongBinder());
                    addSubscription(_arg04, _arg14);
                    return true;
                case 9:
                    ICollectSubscriptionCallback _arg05 = ICollectSubscriptionCallback.Stub.asInterface(data.readStrongBinder());
                    removeSubscription(_arg05);
                    return true;
                case 10:
                    int _arg06 = data.readInt();
                    long _arg15 = data.readLong();
                    long _arg23 = data.readLong();
                    ICollectResultCallback _arg32 = ICollectResultCallback.Stub.asInterface(data.readStrongBinder());
                    getData(_arg06, _arg15, _arg23, _arg32);
                    reply.writeNoException();
                    return true;
                case 11:
                    int[] _arg07 = data.createIntArray();
                    long _arg16 = data.readLong();
                    long _arg24 = data.readLong();
                    CollectEventParcel[] _result = getDataForAtoms(_arg07, _arg16, _arg24);
                    reply.writeNoException();
                    reply.writeTypedArray(_result, 1);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements ICollectd {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ICollectd.DESCRIPTOR;
            }

            @Override // android.os.collector.ICollectd
            public void systemRunning() throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ICollectd.DESCRIPTOR);
                    this.mRemote.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.os.collector.ICollectd
            public void bootCompleted() throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ICollectd.DESCRIPTOR);
                    this.mRemote.transact(2, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.os.collector.ICollectd
            public void registerPullAtomCallback(int uid, int atomTag, long coolDownMillis, long timeoutMillis, ICollectPullCallback pullerCallback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ICollectd.DESCRIPTOR);
                    _data.writeInt(uid);
                    _data.writeInt(atomTag);
                    _data.writeLong(coolDownMillis);
                    _data.writeLong(timeoutMillis);
                    _data.writeStrongInterface(pullerCallback);
                    this.mRemote.transact(3, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.os.collector.ICollectd
            public void informPollAlarmFired() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ICollectd.DESCRIPTOR);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.os.collector.ICollectd
            public void collectCompanionReady() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ICollectd.DESCRIPTOR);
                    this.mRemote.transact(5, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.os.collector.ICollectd
            public void addConfiguration(long configId, byte[] config, int callingUid) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ICollectd.DESCRIPTOR);
                    _data.writeLong(configId);
                    _data.writeByteArray(config);
                    _data.writeInt(callingUid);
                    this.mRemote.transact(6, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.os.collector.ICollectd
            public void removeConfiguration(long configId, int callingUid) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ICollectd.DESCRIPTOR);
                    _data.writeLong(configId);
                    _data.writeInt(callingUid);
                    this.mRemote.transact(7, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.os.collector.ICollectd
            public void addSubscription(int[] atomIds, ICollectSubscriptionCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ICollectd.DESCRIPTOR);
                    _data.writeIntArray(atomIds);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(8, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.os.collector.ICollectd
            public void removeSubscription(ICollectSubscriptionCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ICollectd.DESCRIPTOR);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(9, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.os.collector.ICollectd
            public void getData(int atomId, long from, long duration, ICollectResultCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ICollectd.DESCRIPTOR);
                    _data.writeInt(atomId);
                    _data.writeLong(from);
                    _data.writeLong(duration);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(10, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.os.collector.ICollectd
            public CollectEventParcel[] getDataForAtoms(int[] atomIds, long from, long duration) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ICollectd.DESCRIPTOR);
                    _data.writeIntArray(atomIds);
                    _data.writeLong(from);
                    _data.writeLong(duration);
                    this.mRemote.transact(11, _data, _reply, 0);
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
            return 10;
        }
    }
}
