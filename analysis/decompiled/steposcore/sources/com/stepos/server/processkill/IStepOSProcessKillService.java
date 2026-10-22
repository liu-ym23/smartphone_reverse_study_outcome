package com.stepos.server.processkill;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IStepOSProcessKillService extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.server.processkill.IStepOSProcessKillService";

    boolean killProcessViaLmkd(int i, int i2, int i3) throws RemoteException;

    boolean killProcessesViaLmkd(int[] iArr, int[] iArr2, int i) throws RemoteException;

    boolean setMemTargetViaLmkd(long j) throws RemoteException;

    public static class Default implements IStepOSProcessKillService {
        @Override // com.stepos.server.processkill.IStepOSProcessKillService
        public boolean killProcessViaLmkd(int pid, int uid, int reasonCode) throws RemoteException {
            return false;
        }

        @Override // com.stepos.server.processkill.IStepOSProcessKillService
        public boolean killProcessesViaLmkd(int[] pids, int[] uids, int reasonCode) throws RemoteException {
            return false;
        }

        @Override // com.stepos.server.processkill.IStepOSProcessKillService
        public boolean setMemTargetViaLmkd(long targetKb) throws RemoteException {
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IStepOSProcessKillService {
        static final int TRANSACTION_killProcessViaLmkd = 1;
        static final int TRANSACTION_killProcessesViaLmkd = 2;
        static final int TRANSACTION_setMemTargetViaLmkd = 3;

        public Stub() {
            attachInterface(this, IStepOSProcessKillService.DESCRIPTOR);
        }

        public static IStepOSProcessKillService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IStepOSProcessKillService.DESCRIPTOR);
            if (iin != null && (iin instanceof IStepOSProcessKillService)) {
                return (IStepOSProcessKillService) iin;
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
                    return "killProcessViaLmkd";
                case 2:
                    return "killProcessesViaLmkd";
                case 3:
                    return "setMemTargetViaLmkd";
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
                data.enforceInterface(IStepOSProcessKillService.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IStepOSProcessKillService.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    int _arg0 = data.readInt();
                    int _arg1 = data.readInt();
                    int _arg2 = data.readInt();
                    boolean _result = killProcessViaLmkd(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    reply.writeBoolean(_result);
                    return true;
                case 2:
                    int[] _arg02 = data.createIntArray();
                    int[] _arg12 = data.createIntArray();
                    int _arg22 = data.readInt();
                    boolean _result2 = killProcessesViaLmkd(_arg02, _arg12, _arg22);
                    reply.writeNoException();
                    reply.writeBoolean(_result2);
                    return true;
                case 3:
                    long _arg03 = data.readLong();
                    boolean _result3 = setMemTargetViaLmkd(_arg03);
                    reply.writeNoException();
                    reply.writeBoolean(_result3);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IStepOSProcessKillService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IStepOSProcessKillService.DESCRIPTOR;
            }

            @Override // com.stepos.server.processkill.IStepOSProcessKillService
            public boolean killProcessViaLmkd(int pid, int uid, int reasonCode) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSProcessKillService.DESCRIPTOR);
                    _data.writeInt(pid);
                    _data.writeInt(uid);
                    _data.writeInt(reasonCode);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.stepos.server.processkill.IStepOSProcessKillService
            public boolean killProcessesViaLmkd(int[] pids, int[] uids, int reasonCode) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSProcessKillService.DESCRIPTOR);
                    _data.writeIntArray(pids);
                    _data.writeIntArray(uids);
                    _data.writeInt(reasonCode);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.stepos.server.processkill.IStepOSProcessKillService
            public boolean setMemTargetViaLmkd(long targetKb) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSProcessKillService.DESCRIPTOR);
                    _data.writeLong(targetKb);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
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
}
