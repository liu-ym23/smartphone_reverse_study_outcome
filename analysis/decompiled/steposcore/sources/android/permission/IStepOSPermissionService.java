package android.permission;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import java.util.List;

/* loaded from: classes.dex */
public interface IStepOSPermissionService extends IInterface {
    public static final String DESCRIPTOR = "android.permission.IStepOSPermissionService";

    int askOpsOperation(int i, int i2, String str) throws RemoteException;

    void cancelPermissionNotice(int i, String str) throws RemoteException;

    void cancelUninstallPermissionNotice(int i, String str) throws RemoteException;

    int checkPkgForExclusiveDirectory(String str, String str2, String str3) throws RemoteException;

    int checkTopDirAccessPermission(String str, String str2, String str3) throws RemoteException;

    void clearOpsOperation(int i) throws RemoteException;

    void clearPrivPermissions(int i) throws RemoteException;

    void connectSocketService(Message message) throws RemoteException;

    void forceKillProcess(int i) throws RemoteException;

    String getPkgForExclusiveDirectory(String str, String str2, String str3) throws RemoteException;

    List<PrivPermInfo> getPrivPermissions() throws RemoteException;

    int noteIntentOperation(int i, int i2, String str, Intent intent) throws RemoteException;

    int noteIntentPidOperation(int i, int i2, int i3, Intent intent) throws RemoteException;

    void notePermissionNotice(int i, int i2, String str) throws RemoteException;

    void printPermissionTrace(int i, int i2, String str, int i3) throws RemoteException;

    void printPermissionTraceForCtaTest(String str, int i, int i2, String str2, int i3, boolean z) throws RemoteException;

    boolean queryCtaConfig(int i, int i2) throws RemoteException;

    int queryOpAskState(int i, int i2) throws RemoteException;

    void setCtaConfig(int i, int i2, boolean z) throws RemoteException;

    void setOpAskState(int i, int i2, int i3) throws RemoteException;

    void showPermissionNotice(int i, int i2, String str) throws RemoteException;

    void systemReady() throws RemoteException;

    void wirteTopDirAccessPermission(String str, String str2, int i) throws RemoteException;

    void wirteTopDirAccessPermissionDefault(String str, String str2, int i, int i2, int i3) throws RemoteException;

    void writeOpAskState() throws RemoteException;

    public static class Default implements IStepOSPermissionService {
        @Override // android.permission.IStepOSPermissionService
        public int noteIntentOperation(int code, int uid, String packageName, Intent intent) throws RemoteException {
            return 0;
        }

        @Override // android.permission.IStepOSPermissionService
        public int noteIntentPidOperation(int code, int uid, int pid, Intent intent) throws RemoteException {
            return 0;
        }

        @Override // android.permission.IStepOSPermissionService
        public void forceKillProcess(int pid) throws RemoteException {
        }

        @Override // android.permission.IStepOSPermissionService
        public void connectSocketService(Message msg) throws RemoteException {
        }

        @Override // android.permission.IStepOSPermissionService
        public void printPermissionTrace(int uid, int pid, String pkg, int op) throws RemoteException {
        }

        @Override // android.permission.IStepOSPermissionService
        public void printPermissionTraceForCtaTest(String stackTrace, int uid, int pid, String pkg, int op, boolean isOp) throws RemoteException {
        }

        @Override // android.permission.IStepOSPermissionService
        public boolean queryCtaConfig(int uid, int op) throws RemoteException {
            return false;
        }

        @Override // android.permission.IStepOSPermissionService
        public void setCtaConfig(int uid, int op, boolean value) throws RemoteException {
        }

        @Override // android.permission.IStepOSPermissionService
        public int askOpsOperation(int switchCode, int uid, String packageName) throws RemoteException {
            return 0;
        }

        @Override // android.permission.IStepOSPermissionService
        public void clearOpsOperation(int uid) throws RemoteException {
        }

        @Override // android.permission.IStepOSPermissionService
        public int queryOpAskState(int uid, int switchCode) throws RemoteException {
            return 0;
        }

        @Override // android.permission.IStepOSPermissionService
        public void setOpAskState(int uid, int switchCode, int state) throws RemoteException {
        }

        @Override // android.permission.IStepOSPermissionService
        public void writeOpAskState() throws RemoteException {
        }

        @Override // android.permission.IStepOSPermissionService
        public void systemReady() throws RemoteException {
        }

        @Override // android.permission.IStepOSPermissionService
        public List<PrivPermInfo> getPrivPermissions() throws RemoteException {
            return null;
        }

        @Override // android.permission.IStepOSPermissionService
        public void clearPrivPermissions(int type) throws RemoteException {
        }

        @Override // android.permission.IStepOSPermissionService
        public void showPermissionNotice(int uid, int op, String pkg) throws RemoteException {
        }

        @Override // android.permission.IStepOSPermissionService
        public void notePermissionNotice(int uid, int op, String pkg) throws RemoteException {
        }

        @Override // android.permission.IStepOSPermissionService
        public void cancelPermissionNotice(int op, String pkg) throws RemoteException {
        }

        @Override // android.permission.IStepOSPermissionService
        public void cancelUninstallPermissionNotice(int op, String pkg) throws RemoteException {
        }

        @Override // android.permission.IStepOSPermissionService
        public int checkTopDirAccessPermission(String pkg, String topName, String path) throws RemoteException {
            return 0;
        }

        @Override // android.permission.IStepOSPermissionService
        public void wirteTopDirAccessPermission(String pkg, String topName, int value) throws RemoteException {
        }

        @Override // android.permission.IStepOSPermissionService
        public void wirteTopDirAccessPermissionDefault(String pkg, String topName, int value, int tag, int priority) throws RemoteException {
        }

        @Override // android.permission.IStepOSPermissionService
        public String getPkgForExclusiveDirectory(String callerPkg, String topName, String path) throws RemoteException {
            return null;
        }

        @Override // android.permission.IStepOSPermissionService
        public int checkPkgForExclusiveDirectory(String callerPkg, String topName, String path) throws RemoteException {
            return 0;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IStepOSPermissionService {
        static final int TRANSACTION_askOpsOperation = 9;
        static final int TRANSACTION_cancelPermissionNotice = 19;
        static final int TRANSACTION_cancelUninstallPermissionNotice = 20;
        static final int TRANSACTION_checkPkgForExclusiveDirectory = 25;
        static final int TRANSACTION_checkTopDirAccessPermission = 21;
        static final int TRANSACTION_clearOpsOperation = 10;
        static final int TRANSACTION_clearPrivPermissions = 16;
        static final int TRANSACTION_connectSocketService = 4;
        static final int TRANSACTION_forceKillProcess = 3;
        static final int TRANSACTION_getPkgForExclusiveDirectory = 24;
        static final int TRANSACTION_getPrivPermissions = 15;
        static final int TRANSACTION_noteIntentOperation = 1;
        static final int TRANSACTION_noteIntentPidOperation = 2;
        static final int TRANSACTION_notePermissionNotice = 18;
        static final int TRANSACTION_printPermissionTrace = 5;
        static final int TRANSACTION_printPermissionTraceForCtaTest = 6;
        static final int TRANSACTION_queryCtaConfig = 7;
        static final int TRANSACTION_queryOpAskState = 11;
        static final int TRANSACTION_setCtaConfig = 8;
        static final int TRANSACTION_setOpAskState = 12;
        static final int TRANSACTION_showPermissionNotice = 17;
        static final int TRANSACTION_systemReady = 14;
        static final int TRANSACTION_wirteTopDirAccessPermission = 22;
        static final int TRANSACTION_wirteTopDirAccessPermissionDefault = 23;
        static final int TRANSACTION_writeOpAskState = 13;

        public Stub() {
            attachInterface(this, IStepOSPermissionService.DESCRIPTOR);
        }

        public static IStepOSPermissionService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IStepOSPermissionService.DESCRIPTOR);
            if (iin != null && (iin instanceof IStepOSPermissionService)) {
                return (IStepOSPermissionService) iin;
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
                    return "noteIntentOperation";
                case 2:
                    return "noteIntentPidOperation";
                case 3:
                    return "forceKillProcess";
                case 4:
                    return "connectSocketService";
                case 5:
                    return "printPermissionTrace";
                case 6:
                    return "printPermissionTraceForCtaTest";
                case 7:
                    return "queryCtaConfig";
                case 8:
                    return "setCtaConfig";
                case 9:
                    return "askOpsOperation";
                case 10:
                    return "clearOpsOperation";
                case 11:
                    return "queryOpAskState";
                case 12:
                    return "setOpAskState";
                case 13:
                    return "writeOpAskState";
                case 14:
                    return "systemReady";
                case 15:
                    return "getPrivPermissions";
                case 16:
                    return "clearPrivPermissions";
                case 17:
                    return "showPermissionNotice";
                case 18:
                    return "notePermissionNotice";
                case 19:
                    return "cancelPermissionNotice";
                case 20:
                    return "cancelUninstallPermissionNotice";
                case 21:
                    return "checkTopDirAccessPermission";
                case 22:
                    return "wirteTopDirAccessPermission";
                case 23:
                    return "wirteTopDirAccessPermissionDefault";
                case 24:
                    return "getPkgForExclusiveDirectory";
                case 25:
                    return "checkPkgForExclusiveDirectory";
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
                data.enforceInterface(IStepOSPermissionService.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IStepOSPermissionService.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    int _arg0 = data.readInt();
                    int _arg1 = data.readInt();
                    String _arg2 = data.readString();
                    Intent _arg3 = (Intent) data.readTypedObject(Intent.CREATOR);
                    int _result = noteIntentOperation(_arg0, _arg1, _arg2, _arg3);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case 2:
                    int _arg02 = data.readInt();
                    int _arg12 = data.readInt();
                    int _arg22 = data.readInt();
                    Intent _arg32 = (Intent) data.readTypedObject(Intent.CREATOR);
                    int _result2 = noteIntentPidOperation(_arg02, _arg12, _arg22, _arg32);
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case 3:
                    int _arg03 = data.readInt();
                    forceKillProcess(_arg03);
                    reply.writeNoException();
                    return true;
                case 4:
                    Message _arg04 = (Message) data.readTypedObject(Message.CREATOR);
                    connectSocketService(_arg04);
                    reply.writeNoException();
                    return true;
                case 5:
                    int _arg05 = data.readInt();
                    int _arg13 = data.readInt();
                    String _arg23 = data.readString();
                    int _arg33 = data.readInt();
                    printPermissionTrace(_arg05, _arg13, _arg23, _arg33);
                    reply.writeNoException();
                    return true;
                case 6:
                    String _arg06 = data.readString();
                    int _arg14 = data.readInt();
                    int _arg24 = data.readInt();
                    String _arg34 = data.readString();
                    int _arg4 = data.readInt();
                    boolean _arg5 = data.readBoolean();
                    printPermissionTraceForCtaTest(_arg06, _arg14, _arg24, _arg34, _arg4, _arg5);
                    reply.writeNoException();
                    return true;
                case 7:
                    int _arg07 = data.readInt();
                    int _arg15 = data.readInt();
                    boolean _result3 = queryCtaConfig(_arg07, _arg15);
                    reply.writeNoException();
                    reply.writeBoolean(_result3);
                    return true;
                case 8:
                    int _arg08 = data.readInt();
                    int _arg16 = data.readInt();
                    boolean _arg25 = data.readBoolean();
                    setCtaConfig(_arg08, _arg16, _arg25);
                    reply.writeNoException();
                    return true;
                case 9:
                    int _arg09 = data.readInt();
                    int _arg17 = data.readInt();
                    String _arg26 = data.readString();
                    int _result4 = askOpsOperation(_arg09, _arg17, _arg26);
                    reply.writeNoException();
                    reply.writeInt(_result4);
                    return true;
                case 10:
                    int _arg010 = data.readInt();
                    clearOpsOperation(_arg010);
                    reply.writeNoException();
                    return true;
                case 11:
                    int _arg011 = data.readInt();
                    int _arg18 = data.readInt();
                    int _result5 = queryOpAskState(_arg011, _arg18);
                    reply.writeNoException();
                    reply.writeInt(_result5);
                    return true;
                case 12:
                    int _arg012 = data.readInt();
                    int _arg19 = data.readInt();
                    int _arg27 = data.readInt();
                    setOpAskState(_arg012, _arg19, _arg27);
                    reply.writeNoException();
                    return true;
                case 13:
                    writeOpAskState();
                    reply.writeNoException();
                    return true;
                case 14:
                    systemReady();
                    reply.writeNoException();
                    return true;
                case 15:
                    List<PrivPermInfo> _result6 = getPrivPermissions();
                    reply.writeNoException();
                    _Parcel.writeTypedList(reply, _result6, 1);
                    return true;
                case 16:
                    int _arg013 = data.readInt();
                    clearPrivPermissions(_arg013);
                    reply.writeNoException();
                    return true;
                case 17:
                    int _arg014 = data.readInt();
                    int _arg110 = data.readInt();
                    String _arg28 = data.readString();
                    showPermissionNotice(_arg014, _arg110, _arg28);
                    reply.writeNoException();
                    return true;
                case 18:
                    int _arg015 = data.readInt();
                    int _arg111 = data.readInt();
                    String _arg29 = data.readString();
                    notePermissionNotice(_arg015, _arg111, _arg29);
                    reply.writeNoException();
                    return true;
                case 19:
                    int _arg016 = data.readInt();
                    String _arg112 = data.readString();
                    cancelPermissionNotice(_arg016, _arg112);
                    reply.writeNoException();
                    return true;
                case 20:
                    int _arg017 = data.readInt();
                    String _arg113 = data.readString();
                    cancelUninstallPermissionNotice(_arg017, _arg113);
                    reply.writeNoException();
                    return true;
                case 21:
                    String _arg018 = data.readString();
                    String _arg114 = data.readString();
                    String _arg210 = data.readString();
                    int _result7 = checkTopDirAccessPermission(_arg018, _arg114, _arg210);
                    reply.writeNoException();
                    reply.writeInt(_result7);
                    return true;
                case 22:
                    String _arg019 = data.readString();
                    String _arg115 = data.readString();
                    int _arg211 = data.readInt();
                    wirteTopDirAccessPermission(_arg019, _arg115, _arg211);
                    reply.writeNoException();
                    return true;
                case 23:
                    String _arg020 = data.readString();
                    String _arg116 = data.readString();
                    int _arg212 = data.readInt();
                    int _arg35 = data.readInt();
                    int _arg42 = data.readInt();
                    wirteTopDirAccessPermissionDefault(_arg020, _arg116, _arg212, _arg35, _arg42);
                    reply.writeNoException();
                    return true;
                case 24:
                    String _arg021 = data.readString();
                    String _arg117 = data.readString();
                    String _arg213 = data.readString();
                    String _result8 = getPkgForExclusiveDirectory(_arg021, _arg117, _arg213);
                    reply.writeNoException();
                    reply.writeString(_result8);
                    return true;
                case 25:
                    String _arg022 = data.readString();
                    String _arg118 = data.readString();
                    String _arg214 = data.readString();
                    int _result9 = checkPkgForExclusiveDirectory(_arg022, _arg118, _arg214);
                    reply.writeNoException();
                    reply.writeInt(_result9);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IStepOSPermissionService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IStepOSPermissionService.DESCRIPTOR;
            }

            @Override // android.permission.IStepOSPermissionService
            public int noteIntentOperation(int code, int uid, String packageName, Intent intent) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPermissionService.DESCRIPTOR);
                    _data.writeInt(code);
                    _data.writeInt(uid);
                    _data.writeString(packageName);
                    _data.writeTypedObject(intent, 0);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSPermissionService
            public int noteIntentPidOperation(int code, int uid, int pid, Intent intent) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPermissionService.DESCRIPTOR);
                    _data.writeInt(code);
                    _data.writeInt(uid);
                    _data.writeInt(pid);
                    _data.writeTypedObject(intent, 0);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSPermissionService
            public void forceKillProcess(int pid) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPermissionService.DESCRIPTOR);
                    _data.writeInt(pid);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSPermissionService
            public void connectSocketService(Message msg) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPermissionService.DESCRIPTOR);
                    _data.writeTypedObject(msg, 0);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSPermissionService
            public void printPermissionTrace(int uid, int pid, String pkg, int op) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPermissionService.DESCRIPTOR);
                    _data.writeInt(uid);
                    _data.writeInt(pid);
                    _data.writeString(pkg);
                    _data.writeInt(op);
                    this.mRemote.transact(5, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSPermissionService
            public void printPermissionTraceForCtaTest(String stackTrace, int uid, int pid, String pkg, int op, boolean isOp) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPermissionService.DESCRIPTOR);
                    _data.writeString(stackTrace);
                    _data.writeInt(uid);
                    _data.writeInt(pid);
                    _data.writeString(pkg);
                    _data.writeInt(op);
                    _data.writeBoolean(isOp);
                    this.mRemote.transact(6, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSPermissionService
            public boolean queryCtaConfig(int uid, int op) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPermissionService.DESCRIPTOR);
                    _data.writeInt(uid);
                    _data.writeInt(op);
                    this.mRemote.transact(7, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSPermissionService
            public void setCtaConfig(int uid, int op, boolean value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPermissionService.DESCRIPTOR);
                    _data.writeInt(uid);
                    _data.writeInt(op);
                    _data.writeBoolean(value);
                    this.mRemote.transact(8, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSPermissionService
            public int askOpsOperation(int switchCode, int uid, String packageName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPermissionService.DESCRIPTOR);
                    _data.writeInt(switchCode);
                    _data.writeInt(uid);
                    _data.writeString(packageName);
                    this.mRemote.transact(9, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSPermissionService
            public void clearOpsOperation(int uid) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPermissionService.DESCRIPTOR);
                    _data.writeInt(uid);
                    this.mRemote.transact(10, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSPermissionService
            public int queryOpAskState(int uid, int switchCode) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPermissionService.DESCRIPTOR);
                    _data.writeInt(uid);
                    _data.writeInt(switchCode);
                    this.mRemote.transact(11, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSPermissionService
            public void setOpAskState(int uid, int switchCode, int state) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPermissionService.DESCRIPTOR);
                    _data.writeInt(uid);
                    _data.writeInt(switchCode);
                    _data.writeInt(state);
                    this.mRemote.transact(12, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSPermissionService
            public void writeOpAskState() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPermissionService.DESCRIPTOR);
                    this.mRemote.transact(13, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSPermissionService
            public void systemReady() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPermissionService.DESCRIPTOR);
                    this.mRemote.transact(14, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSPermissionService
            public List<PrivPermInfo> getPrivPermissions() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPermissionService.DESCRIPTOR);
                    this.mRemote.transact(15, _data, _reply, 0);
                    _reply.readException();
                    List<PrivPermInfo> _result = _reply.createTypedArrayList(PrivPermInfo.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSPermissionService
            public void clearPrivPermissions(int type) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPermissionService.DESCRIPTOR);
                    _data.writeInt(type);
                    this.mRemote.transact(16, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSPermissionService
            public void showPermissionNotice(int uid, int op, String pkg) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPermissionService.DESCRIPTOR);
                    _data.writeInt(uid);
                    _data.writeInt(op);
                    _data.writeString(pkg);
                    this.mRemote.transact(17, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSPermissionService
            public void notePermissionNotice(int uid, int op, String pkg) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPermissionService.DESCRIPTOR);
                    _data.writeInt(uid);
                    _data.writeInt(op);
                    _data.writeString(pkg);
                    this.mRemote.transact(18, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSPermissionService
            public void cancelPermissionNotice(int op, String pkg) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPermissionService.DESCRIPTOR);
                    _data.writeInt(op);
                    _data.writeString(pkg);
                    this.mRemote.transact(19, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSPermissionService
            public void cancelUninstallPermissionNotice(int op, String pkg) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPermissionService.DESCRIPTOR);
                    _data.writeInt(op);
                    _data.writeString(pkg);
                    this.mRemote.transact(20, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSPermissionService
            public int checkTopDirAccessPermission(String pkg, String topName, String path) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPermissionService.DESCRIPTOR);
                    _data.writeString(pkg);
                    _data.writeString(topName);
                    _data.writeString(path);
                    this.mRemote.transact(21, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSPermissionService
            public void wirteTopDirAccessPermission(String pkg, String topName, int value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPermissionService.DESCRIPTOR);
                    _data.writeString(pkg);
                    _data.writeString(topName);
                    _data.writeInt(value);
                    this.mRemote.transact(22, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSPermissionService
            public void wirteTopDirAccessPermissionDefault(String pkg, String topName, int value, int tag, int priority) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPermissionService.DESCRIPTOR);
                    _data.writeString(pkg);
                    _data.writeString(topName);
                    _data.writeInt(value);
                    _data.writeInt(tag);
                    _data.writeInt(priority);
                    this.mRemote.transact(23, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSPermissionService
            public String getPkgForExclusiveDirectory(String callerPkg, String topName, String path) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPermissionService.DESCRIPTOR);
                    _data.writeString(callerPkg);
                    _data.writeString(topName);
                    _data.writeString(path);
                    this.mRemote.transact(24, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSPermissionService
            public int checkPkgForExclusiveDirectory(String callerPkg, String topName, String path) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPermissionService.DESCRIPTOR);
                    _data.writeString(callerPkg);
                    _data.writeString(topName);
                    _data.writeString(path);
                    this.mRemote.transact(25, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 24;
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
