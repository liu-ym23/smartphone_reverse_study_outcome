package stepos.app;

import android.app.usage.IStepOSUsageEventListener;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IStepOSActivityManager extends IInterface {
    public static final String DESCRIPTOR = "stepos.app.IStepOSActivityManager";

    void apexRequest(Intent intent) throws RemoteException;

    void endProcessTempKeepAlive(String str, int i) throws RemoteException;

    long[] getProcessCpuTimes(int[] iArr, int[] iArr2) throws RemoteException;

    String getProcessNameByUidAndTid(int i, int i2) throws RemoteException;

    int getVirtualDisplayCgroupTier(int i) throws RemoteException;

    boolean isVirtualDisplayCgroupEnabled() throws RemoteException;

    void registerEventListener(IStepOSUsageEventListener iStepOSUsageEventListener) throws RemoteException;

    void removeEventListener(IStepOSUsageEventListener iStepOSUsageEventListener) throws RemoteException;

    boolean resetVirtualDisplayCgroupTier(int i) throws RemoteException;

    void setApexService(Intent intent) throws RemoteException;

    void setProcessTempKeepAlive(String str, int i, int i2) throws RemoteException;

    boolean setVirtualDisplayCgroupTier(int i, int i2) throws RemoteException;

    void test() throws RemoteException;

    boolean watchDeathForProcess(int i, boolean z, String str) throws RemoteException;

    public static class Default implements IStepOSActivityManager {
        @Override // stepos.app.IStepOSActivityManager
        public void test() throws RemoteException {
        }

        @Override // stepos.app.IStepOSActivityManager
        public void registerEventListener(IStepOSUsageEventListener iUsageEventListener) throws RemoteException {
        }

        @Override // stepos.app.IStepOSActivityManager
        public void removeEventListener(IStepOSUsageEventListener iUsageEventListener) throws RemoteException {
        }

        @Override // stepos.app.IStepOSActivityManager
        public void setApexService(Intent intent) throws RemoteException {
        }

        @Override // stepos.app.IStepOSActivityManager
        public void apexRequest(Intent intent) throws RemoteException {
        }

        @Override // stepos.app.IStepOSActivityManager
        public void setProcessTempKeepAlive(String processName, int keepAliveFlag, int maxTime) throws RemoteException {
        }

        @Override // stepos.app.IStepOSActivityManager
        public void endProcessTempKeepAlive(String processName, int keepAliveFlag) throws RemoteException {
        }

        @Override // stepos.app.IStepOSActivityManager
        public boolean watchDeathForProcess(int pid, boolean needRemove, String packageName) throws RemoteException {
            return false;
        }

        @Override // stepos.app.IStepOSActivityManager
        public boolean setVirtualDisplayCgroupTier(int tier, int displayId) throws RemoteException {
            return false;
        }

        @Override // stepos.app.IStepOSActivityManager
        public boolean resetVirtualDisplayCgroupTier(int displayId) throws RemoteException {
            return false;
        }

        @Override // stepos.app.IStepOSActivityManager
        public boolean isVirtualDisplayCgroupEnabled() throws RemoteException {
            return false;
        }

        @Override // stepos.app.IStepOSActivityManager
        public int getVirtualDisplayCgroupTier(int displayId) throws RemoteException {
            return 0;
        }

        @Override // stepos.app.IStepOSActivityManager
        public String getProcessNameByUidAndTid(int uid, int tid) throws RemoteException {
            return null;
        }

        @Override // stepos.app.IStepOSActivityManager
        public long[] getProcessCpuTimes(int[] pids, int[] uids) throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IStepOSActivityManager {
        static final int TRANSACTION_apexRequest = 5;
        static final int TRANSACTION_endProcessTempKeepAlive = 7;
        static final int TRANSACTION_getProcessCpuTimes = 14;
        static final int TRANSACTION_getProcessNameByUidAndTid = 13;
        static final int TRANSACTION_getVirtualDisplayCgroupTier = 12;
        static final int TRANSACTION_isVirtualDisplayCgroupEnabled = 11;
        static final int TRANSACTION_registerEventListener = 2;
        static final int TRANSACTION_removeEventListener = 3;
        static final int TRANSACTION_resetVirtualDisplayCgroupTier = 10;
        static final int TRANSACTION_setApexService = 4;
        static final int TRANSACTION_setProcessTempKeepAlive = 6;
        static final int TRANSACTION_setVirtualDisplayCgroupTier = 9;
        static final int TRANSACTION_test = 1;
        static final int TRANSACTION_watchDeathForProcess = 8;

        public Stub() {
            attachInterface(this, IStepOSActivityManager.DESCRIPTOR);
        }

        public static IStepOSActivityManager asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IStepOSActivityManager.DESCRIPTOR);
            if (iin != null && (iin instanceof IStepOSActivityManager)) {
                return (IStepOSActivityManager) iin;
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
                    return "test";
                case 2:
                    return "registerEventListener";
                case 3:
                    return "removeEventListener";
                case 4:
                    return "setApexService";
                case 5:
                    return "apexRequest";
                case 6:
                    return "setProcessTempKeepAlive";
                case 7:
                    return "endProcessTempKeepAlive";
                case 8:
                    return "watchDeathForProcess";
                case 9:
                    return "setVirtualDisplayCgroupTier";
                case 10:
                    return "resetVirtualDisplayCgroupTier";
                case 11:
                    return "isVirtualDisplayCgroupEnabled";
                case 12:
                    return "getVirtualDisplayCgroupTier";
                case 13:
                    return "getProcessNameByUidAndTid";
                case 14:
                    return "getProcessCpuTimes";
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
                data.enforceInterface(IStepOSActivityManager.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IStepOSActivityManager.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    test();
                    reply.writeNoException();
                    return true;
                case 2:
                    IStepOSUsageEventListener _arg0 = IStepOSUsageEventListener.Stub.asInterface(data.readStrongBinder());
                    registerEventListener(_arg0);
                    reply.writeNoException();
                    return true;
                case 3:
                    IStepOSUsageEventListener _arg02 = IStepOSUsageEventListener.Stub.asInterface(data.readStrongBinder());
                    removeEventListener(_arg02);
                    reply.writeNoException();
                    return true;
                case 4:
                    Intent _arg03 = (Intent) data.readTypedObject(Intent.CREATOR);
                    setApexService(_arg03);
                    reply.writeNoException();
                    return true;
                case 5:
                    Intent _arg04 = (Intent) data.readTypedObject(Intent.CREATOR);
                    apexRequest(_arg04);
                    reply.writeNoException();
                    return true;
                case 6:
                    String _arg05 = data.readString();
                    int _arg1 = data.readInt();
                    int _arg2 = data.readInt();
                    setProcessTempKeepAlive(_arg05, _arg1, _arg2);
                    reply.writeNoException();
                    return true;
                case 7:
                    String _arg06 = data.readString();
                    int _arg12 = data.readInt();
                    endProcessTempKeepAlive(_arg06, _arg12);
                    reply.writeNoException();
                    return true;
                case 8:
                    int _arg07 = data.readInt();
                    boolean _arg13 = data.readBoolean();
                    String _arg22 = data.readString();
                    boolean _result = watchDeathForProcess(_arg07, _arg13, _arg22);
                    reply.writeNoException();
                    reply.writeBoolean(_result);
                    return true;
                case 9:
                    int _arg08 = data.readInt();
                    int _arg14 = data.readInt();
                    boolean _result2 = setVirtualDisplayCgroupTier(_arg08, _arg14);
                    reply.writeNoException();
                    reply.writeBoolean(_result2);
                    return true;
                case 10:
                    int _arg09 = data.readInt();
                    boolean _result3 = resetVirtualDisplayCgroupTier(_arg09);
                    reply.writeNoException();
                    reply.writeBoolean(_result3);
                    return true;
                case 11:
                    boolean _result4 = isVirtualDisplayCgroupEnabled();
                    reply.writeNoException();
                    reply.writeBoolean(_result4);
                    return true;
                case 12:
                    int _arg010 = data.readInt();
                    int _result5 = getVirtualDisplayCgroupTier(_arg010);
                    reply.writeNoException();
                    reply.writeInt(_result5);
                    return true;
                case 13:
                    int _arg011 = data.readInt();
                    int _arg15 = data.readInt();
                    String _result6 = getProcessNameByUidAndTid(_arg011, _arg15);
                    reply.writeNoException();
                    reply.writeString(_result6);
                    return true;
                case 14:
                    int[] _arg012 = data.createIntArray();
                    int[] _arg16 = data.createIntArray();
                    long[] _result7 = getProcessCpuTimes(_arg012, _arg16);
                    reply.writeNoException();
                    reply.writeLongArray(_result7);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IStepOSActivityManager {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IStepOSActivityManager.DESCRIPTOR;
            }

            @Override // stepos.app.IStepOSActivityManager
            public void test() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSActivityManager.DESCRIPTOR);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSActivityManager
            public void registerEventListener(IStepOSUsageEventListener iUsageEventListener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSActivityManager.DESCRIPTOR);
                    _data.writeStrongInterface(iUsageEventListener);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSActivityManager
            public void removeEventListener(IStepOSUsageEventListener iUsageEventListener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSActivityManager.DESCRIPTOR);
                    _data.writeStrongInterface(iUsageEventListener);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSActivityManager
            public void setApexService(Intent intent) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSActivityManager.DESCRIPTOR);
                    _data.writeTypedObject(intent, 0);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSActivityManager
            public void apexRequest(Intent intent) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSActivityManager.DESCRIPTOR);
                    _data.writeTypedObject(intent, 0);
                    this.mRemote.transact(5, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSActivityManager
            public void setProcessTempKeepAlive(String processName, int keepAliveFlag, int maxTime) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSActivityManager.DESCRIPTOR);
                    _data.writeString(processName);
                    _data.writeInt(keepAliveFlag);
                    _data.writeInt(maxTime);
                    this.mRemote.transact(6, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSActivityManager
            public void endProcessTempKeepAlive(String processName, int keepAliveFlag) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSActivityManager.DESCRIPTOR);
                    _data.writeString(processName);
                    _data.writeInt(keepAliveFlag);
                    this.mRemote.transact(7, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSActivityManager
            public boolean watchDeathForProcess(int pid, boolean needRemove, String packageName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSActivityManager.DESCRIPTOR);
                    _data.writeInt(pid);
                    _data.writeBoolean(needRemove);
                    _data.writeString(packageName);
                    this.mRemote.transact(8, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSActivityManager
            public boolean setVirtualDisplayCgroupTier(int tier, int displayId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSActivityManager.DESCRIPTOR);
                    _data.writeInt(tier);
                    _data.writeInt(displayId);
                    this.mRemote.transact(9, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSActivityManager
            public boolean resetVirtualDisplayCgroupTier(int displayId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSActivityManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    this.mRemote.transact(10, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSActivityManager
            public boolean isVirtualDisplayCgroupEnabled() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSActivityManager.DESCRIPTOR);
                    this.mRemote.transact(11, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSActivityManager
            public int getVirtualDisplayCgroupTier(int displayId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSActivityManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    this.mRemote.transact(12, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSActivityManager
            public String getProcessNameByUidAndTid(int uid, int tid) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSActivityManager.DESCRIPTOR);
                    _data.writeInt(uid);
                    _data.writeInt(tid);
                    this.mRemote.transact(13, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSActivityManager
            public long[] getProcessCpuTimes(int[] pids, int[] uids) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSActivityManager.DESCRIPTOR);
                    _data.writeIntArray(pids);
                    _data.writeIntArray(uids);
                    this.mRemote.transact(14, _data, _reply, 0);
                    _reply.readException();
                    long[] _result = _reply.createLongArray();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 13;
        }
    }
}
