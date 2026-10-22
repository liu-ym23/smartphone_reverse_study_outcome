package com.stepos.net;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import java.util.List;

/* loaded from: classes.dex */
public interface IStepOSNetworkBoostService extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.net.IStepOSNetworkBoostService";

    int destroySocketsByPids(int[] iArr) throws RemoteException;

    int destroyTcpUdpSocketsByOwnerUids(int[] iArr) throws RemoteException;

    List<StepOSSockEntry> querySocketsByPids(int[] iArr) throws RemoteException;

    public static class Default implements IStepOSNetworkBoostService {
        @Override // com.stepos.net.IStepOSNetworkBoostService
        public int destroyTcpUdpSocketsByOwnerUids(int[] ownerUids) throws RemoteException {
            return 0;
        }

        @Override // com.stepos.net.IStepOSNetworkBoostService
        public int destroySocketsByPids(int[] pids) throws RemoteException {
            return 0;
        }

        @Override // com.stepos.net.IStepOSNetworkBoostService
        public List<StepOSSockEntry> querySocketsByPids(int[] pids) throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IStepOSNetworkBoostService {
        static final int TRANSACTION_destroySocketsByPids = 2;
        static final int TRANSACTION_destroyTcpUdpSocketsByOwnerUids = 1;
        static final int TRANSACTION_querySocketsByPids = 3;

        public Stub() {
            attachInterface(this, IStepOSNetworkBoostService.DESCRIPTOR);
        }

        public static IStepOSNetworkBoostService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IStepOSNetworkBoostService.DESCRIPTOR);
            if (iin != null && (iin instanceof IStepOSNetworkBoostService)) {
                return (IStepOSNetworkBoostService) iin;
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
                    return "destroyTcpUdpSocketsByOwnerUids";
                case 2:
                    return "destroySocketsByPids";
                case 3:
                    return "querySocketsByPids";
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
                data.enforceInterface(IStepOSNetworkBoostService.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IStepOSNetworkBoostService.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    int[] _arg0 = data.createIntArray();
                    int _result = destroyTcpUdpSocketsByOwnerUids(_arg0);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case 2:
                    int[] _arg02 = data.createIntArray();
                    int _result2 = destroySocketsByPids(_arg02);
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case 3:
                    int[] _arg03 = data.createIntArray();
                    List<StepOSSockEntry> _result3 = querySocketsByPids(_arg03);
                    reply.writeNoException();
                    _Parcel.writeTypedList(reply, _result3, 1);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IStepOSNetworkBoostService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IStepOSNetworkBoostService.DESCRIPTOR;
            }

            @Override // com.stepos.net.IStepOSNetworkBoostService
            public int destroyTcpUdpSocketsByOwnerUids(int[] ownerUids) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSNetworkBoostService.DESCRIPTOR);
                    _data.writeIntArray(ownerUids);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.stepos.net.IStepOSNetworkBoostService
            public int destroySocketsByPids(int[] pids) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSNetworkBoostService.DESCRIPTOR);
                    _data.writeIntArray(pids);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.stepos.net.IStepOSNetworkBoostService
            public List<StepOSSockEntry> querySocketsByPids(int[] pids) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSNetworkBoostService.DESCRIPTOR);
                    _data.writeIntArray(pids);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                    List<StepOSSockEntry> _result = _reply.createTypedArrayList(StepOSSockEntry.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 2;
        }
    }

    public static class _Parcel {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedList(Parcel parcel, List<T> value, int parcelableFlags) {
            if (value == null) {
                parcel.writeInt(-1);
                return;
            }
            int N = value.size();
            parcel.writeInt(N);
            for (int i = 0; i < N; i++) {
                parcel.writeTypedObject(value.get(i), parcelableFlags);
            }
        }
    }
}
