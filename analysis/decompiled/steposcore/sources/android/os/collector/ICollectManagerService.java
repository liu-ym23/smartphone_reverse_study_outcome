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
public interface ICollectManagerService extends IInterface {
    public static final String DESCRIPTOR = "android.os.collector.ICollectManagerService";

    void addConfiguration(long j, byte[] bArr, String str) throws RemoteException;

    void addSubscription(int[] iArr, ICollectSubscriptionCallback iCollectSubscriptionCallback) throws RemoteException;

    boolean getData(int i, long j, long j2, ICollectResultCallback iCollectResultCallback) throws RemoteException;

    CollectEventParcel[] getDataForAtoms(int[] iArr, long j, long j2) throws RemoteException;

    boolean isCollectable(int i) throws RemoteException;

    void registerPullAtomCallback(int i, long j, long j2, ICollectPullCallback iCollectPullCallback) throws RemoteException;

    void removeConfiguration(long j, String str) throws RemoteException;

    void removeSubscription(ICollectSubscriptionCallback iCollectSubscriptionCallback) throws RemoteException;

    public static class Default implements ICollectManagerService {
        @Override // android.os.collector.ICollectManagerService
        public void addConfiguration(long configId, byte[] config, String packageName) throws RemoteException {
        }

        @Override // android.os.collector.ICollectManagerService
        public void removeConfiguration(long configId, String packageName) throws RemoteException {
        }

        @Override // android.os.collector.ICollectManagerService
        public void registerPullAtomCallback(int atomTag, long coolDownMillis, long timeoutMillis, ICollectPullCallback callback) throws RemoteException {
        }

        @Override // android.os.collector.ICollectManagerService
        public void addSubscription(int[] atomIds, ICollectSubscriptionCallback callback) throws RemoteException {
        }

        @Override // android.os.collector.ICollectManagerService
        public void removeSubscription(ICollectSubscriptionCallback callback) throws RemoteException {
        }

        @Override // android.os.collector.ICollectManagerService
        public boolean isCollectable(int atomTag) throws RemoteException {
            return false;
        }

        @Override // android.os.collector.ICollectManagerService
        public boolean getData(int atomId, long from, long duration, ICollectResultCallback callback) throws RemoteException {
            return false;
        }

        @Override // android.os.collector.ICollectManagerService
        public CollectEventParcel[] getDataForAtoms(int[] atomIds, long from, long duration) throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ICollectManagerService {
        static final int TRANSACTION_addConfiguration = 1;
        static final int TRANSACTION_addSubscription = 4;
        static final int TRANSACTION_getData = 7;
        static final int TRANSACTION_getDataForAtoms = 8;
        static final int TRANSACTION_isCollectable = 6;
        static final int TRANSACTION_registerPullAtomCallback = 3;
        static final int TRANSACTION_removeConfiguration = 2;
        static final int TRANSACTION_removeSubscription = 5;

        public Stub() {
            attachInterface(this, ICollectManagerService.DESCRIPTOR);
        }

        public static ICollectManagerService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(ICollectManagerService.DESCRIPTOR);
            if (iin != null && (iin instanceof ICollectManagerService)) {
                return (ICollectManagerService) iin;
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
                    return "addConfiguration";
                case 2:
                    return "removeConfiguration";
                case 3:
                    return "registerPullAtomCallback";
                case 4:
                    return "addSubscription";
                case 5:
                    return "removeSubscription";
                case 6:
                    return "isCollectable";
                case 7:
                    return "getData";
                case 8:
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
                data.enforceInterface(ICollectManagerService.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(ICollectManagerService.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    long _arg0 = data.readLong();
                    byte[] _arg1 = data.createByteArray();
                    String _arg2 = data.readString();
                    addConfiguration(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    return true;
                case 2:
                    long _arg02 = data.readLong();
                    String _arg12 = data.readString();
                    removeConfiguration(_arg02, _arg12);
                    reply.writeNoException();
                    return true;
                case 3:
                    int _arg03 = data.readInt();
                    long _arg13 = data.readLong();
                    long _arg22 = data.readLong();
                    ICollectPullCallback _arg3 = ICollectPullCallback.Stub.asInterface(data.readStrongBinder());
                    registerPullAtomCallback(_arg03, _arg13, _arg22, _arg3);
                    return true;
                case 4:
                    int[] _arg04 = data.createIntArray();
                    ICollectSubscriptionCallback _arg14 = ICollectSubscriptionCallback.Stub.asInterface(data.readStrongBinder());
                    addSubscription(_arg04, _arg14);
                    return true;
                case 5:
                    ICollectSubscriptionCallback _arg05 = ICollectSubscriptionCallback.Stub.asInterface(data.readStrongBinder());
                    removeSubscription(_arg05);
                    return true;
                case 6:
                    int _arg06 = data.readInt();
                    boolean _result = isCollectable(_arg06);
                    reply.writeNoException();
                    reply.writeBoolean(_result);
                    return true;
                case 7:
                    int _arg07 = data.readInt();
                    long _arg15 = data.readLong();
                    long _arg23 = data.readLong();
                    ICollectResultCallback _arg32 = ICollectResultCallback.Stub.asInterface(data.readStrongBinder());
                    boolean _result2 = getData(_arg07, _arg15, _arg23, _arg32);
                    reply.writeNoException();
                    reply.writeBoolean(_result2);
                    return true;
                case 8:
                    int[] _arg08 = data.createIntArray();
                    long _arg16 = data.readLong();
                    long _arg24 = data.readLong();
                    CollectEventParcel[] _result3 = getDataForAtoms(_arg08, _arg16, _arg24);
                    reply.writeNoException();
                    reply.writeTypedArray(_result3, 1);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements ICollectManagerService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ICollectManagerService.DESCRIPTOR;
            }

            @Override // android.os.collector.ICollectManagerService
            public void addConfiguration(long configId, byte[] config, String packageName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ICollectManagerService.DESCRIPTOR);
                    _data.writeLong(configId);
                    _data.writeByteArray(config);
                    _data.writeString(packageName);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.os.collector.ICollectManagerService
            public void removeConfiguration(long configId, String packageName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ICollectManagerService.DESCRIPTOR);
                    _data.writeLong(configId);
                    _data.writeString(packageName);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.os.collector.ICollectManagerService
            public void registerPullAtomCallback(int atomTag, long coolDownMillis, long timeoutMillis, ICollectPullCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ICollectManagerService.DESCRIPTOR);
                    _data.writeInt(atomTag);
                    _data.writeLong(coolDownMillis);
                    _data.writeLong(timeoutMillis);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(3, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.os.collector.ICollectManagerService
            public void addSubscription(int[] atomIds, ICollectSubscriptionCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ICollectManagerService.DESCRIPTOR);
                    _data.writeIntArray(atomIds);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(4, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.os.collector.ICollectManagerService
            public void removeSubscription(ICollectSubscriptionCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ICollectManagerService.DESCRIPTOR);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(5, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.os.collector.ICollectManagerService
            public boolean isCollectable(int atomTag) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ICollectManagerService.DESCRIPTOR);
                    _data.writeInt(atomTag);
                    this.mRemote.transact(6, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.os.collector.ICollectManagerService
            public boolean getData(int atomId, long from, long duration, ICollectResultCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ICollectManagerService.DESCRIPTOR);
                    _data.writeInt(atomId);
                    _data.writeLong(from);
                    _data.writeLong(duration);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(7, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.os.collector.ICollectManagerService
            public CollectEventParcel[] getDataForAtoms(int[] atomIds, long from, long duration) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ICollectManagerService.DESCRIPTOR);
                    _data.writeIntArray(atomIds);
                    _data.writeLong(from);
                    _data.writeLong(duration);
                    this.mRemote.transact(8, _data, _reply, 0);
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
            return 7;
        }
    }
}
