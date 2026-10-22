package android.permission;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public interface IStepOSHipsService extends IInterface {
    public static final String DESCRIPTOR = "android.permission.IStepOSHipsService";

    int checkIfwRuleByUser(int i, String str, String str2, boolean z) throws RemoteException;

    int getIfwVersion() throws RemoteException;

    boolean getPasswordModeSwitchState() throws RemoteException;

    Map getSecurityMarginItems() throws RemoteException;

    boolean getSecurityMarginSwitchState() throws RemoteException;

    long getSecurityMarginTimeStamp() throws RemoteException;

    int getSecurityMarginVersion() throws RemoteException;

    Map getUsbInstallInfo() throws RemoteException;

    int getUsbInstallSwitchState() throws RemoteException;

    boolean isInPasswordMode() throws RemoteException;

    boolean isInSecurityMargin() throws RemoteException;

    boolean isSecurityKBSwitchOn() throws RemoteException;

    int isStopUsbInstall(String str) throws RemoteException;

    List<String> queryIfwStats(String str, long j, long j2) throws RemoteException;

    void reportIfwEvent(int i, String str, int i2, String str2, int i3, String str3, String str4, String str5, boolean z, boolean z2, int i4, String str6, boolean z3, boolean z4) throws RemoteException;

    void setPasswordModeSwitchState(boolean z) throws RemoteException;

    int setSecurityMarginList(List<String> list) throws RemoteException;

    void setSecurityMarginSwitchState(boolean z) throws RemoteException;

    void setSecurityMarginTimeStamp(long j) throws RemoteException;

    void setUsbInstallItemState(int i, String str, String str2, int i2) throws RemoteException;

    void setUsbInstallSwitchState(boolean z) throws RemoteException;

    void updateIfwRuleByUser(int i, int i2, String str, String str2, boolean z) throws RemoteException;

    public static class Default implements IStepOSHipsService {
        @Override // android.permission.IStepOSHipsService
        public int isStopUsbInstall(String apkPath) throws RemoteException {
            return 0;
        }

        @Override // android.permission.IStepOSHipsService
        public void setUsbInstallSwitchState(boolean isOn) throws RemoteException {
        }

        @Override // android.permission.IStepOSHipsService
        public int getUsbInstallSwitchState() throws RemoteException {
            return 0;
        }

        @Override // android.permission.IStepOSHipsService
        public void setUsbInstallItemState(int type, String pkgName, String apkName, int mode) throws RemoteException {
        }

        @Override // android.permission.IStepOSHipsService
        public Map getUsbInstallInfo() throws RemoteException {
            return null;
        }

        @Override // android.permission.IStepOSHipsService
        public boolean isInPasswordMode() throws RemoteException {
            return false;
        }

        @Override // android.permission.IStepOSHipsService
        public boolean isSecurityKBSwitchOn() throws RemoteException {
            return false;
        }

        @Override // android.permission.IStepOSHipsService
        public void setPasswordModeSwitchState(boolean isOn) throws RemoteException {
        }

        @Override // android.permission.IStepOSHipsService
        public boolean getPasswordModeSwitchState() throws RemoteException {
            return false;
        }

        @Override // android.permission.IStepOSHipsService
        public boolean isInSecurityMargin() throws RemoteException {
            return false;
        }

        @Override // android.permission.IStepOSHipsService
        public void setSecurityMarginSwitchState(boolean isOn) throws RemoteException {
        }

        @Override // android.permission.IStepOSHipsService
        public boolean getSecurityMarginSwitchState() throws RemoteException {
            return false;
        }

        @Override // android.permission.IStepOSHipsService
        public int getSecurityMarginVersion() throws RemoteException {
            return 0;
        }

        @Override // android.permission.IStepOSHipsService
        public void setSecurityMarginTimeStamp(long timeStamp) throws RemoteException {
        }

        @Override // android.permission.IStepOSHipsService
        public long getSecurityMarginTimeStamp() throws RemoteException {
            return 0L;
        }

        @Override // android.permission.IStepOSHipsService
        public int setSecurityMarginList(List<String> list) throws RemoteException {
            return 0;
        }

        @Override // android.permission.IStepOSHipsService
        public Map getSecurityMarginItems() throws RemoteException {
            return null;
        }

        @Override // android.permission.IStepOSHipsService
        public void reportIfwEvent(int type, String caller, int callerUid, String callee, int calleeUid, String action, String component, String providerName, boolean foreground, boolean running, int query, String reason, boolean intercept, boolean custom) throws RemoteException {
        }

        @Override // android.permission.IStepOSHipsService
        public List<String> queryIfwStats(String packageName, long startTime, long endTime) throws RemoteException {
            return null;
        }

        @Override // android.permission.IStepOSHipsService
        public void updateIfwRuleByUser(int type, int mode, String caller, String callee, boolean isFg) throws RemoteException {
        }

        @Override // android.permission.IStepOSHipsService
        public int checkIfwRuleByUser(int type, String sender, String receiver, boolean isFg) throws RemoteException {
            return 0;
        }

        @Override // android.permission.IStepOSHipsService
        public int getIfwVersion() throws RemoteException {
            return 0;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IStepOSHipsService {
        static final int TRANSACTION_checkIfwRuleByUser = 21;
        static final int TRANSACTION_getIfwVersion = 22;
        static final int TRANSACTION_getPasswordModeSwitchState = 9;
        static final int TRANSACTION_getSecurityMarginItems = 17;
        static final int TRANSACTION_getSecurityMarginSwitchState = 12;
        static final int TRANSACTION_getSecurityMarginTimeStamp = 15;
        static final int TRANSACTION_getSecurityMarginVersion = 13;
        static final int TRANSACTION_getUsbInstallInfo = 5;
        static final int TRANSACTION_getUsbInstallSwitchState = 3;
        static final int TRANSACTION_isInPasswordMode = 6;
        static final int TRANSACTION_isInSecurityMargin = 10;
        static final int TRANSACTION_isSecurityKBSwitchOn = 7;
        static final int TRANSACTION_isStopUsbInstall = 1;
        static final int TRANSACTION_queryIfwStats = 19;
        static final int TRANSACTION_reportIfwEvent = 18;
        static final int TRANSACTION_setPasswordModeSwitchState = 8;
        static final int TRANSACTION_setSecurityMarginList = 16;
        static final int TRANSACTION_setSecurityMarginSwitchState = 11;
        static final int TRANSACTION_setSecurityMarginTimeStamp = 14;
        static final int TRANSACTION_setUsbInstallItemState = 4;
        static final int TRANSACTION_setUsbInstallSwitchState = 2;
        static final int TRANSACTION_updateIfwRuleByUser = 20;

        public Stub() {
            attachInterface(this, IStepOSHipsService.DESCRIPTOR);
        }

        public static IStepOSHipsService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IStepOSHipsService.DESCRIPTOR);
            if (iin != null && (iin instanceof IStepOSHipsService)) {
                return (IStepOSHipsService) iin;
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
                    return "isStopUsbInstall";
                case 2:
                    return "setUsbInstallSwitchState";
                case 3:
                    return "getUsbInstallSwitchState";
                case 4:
                    return "setUsbInstallItemState";
                case 5:
                    return "getUsbInstallInfo";
                case 6:
                    return "isInPasswordMode";
                case 7:
                    return "isSecurityKBSwitchOn";
                case 8:
                    return "setPasswordModeSwitchState";
                case 9:
                    return "getPasswordModeSwitchState";
                case 10:
                    return "isInSecurityMargin";
                case 11:
                    return "setSecurityMarginSwitchState";
                case 12:
                    return "getSecurityMarginSwitchState";
                case 13:
                    return "getSecurityMarginVersion";
                case 14:
                    return "setSecurityMarginTimeStamp";
                case 15:
                    return "getSecurityMarginTimeStamp";
                case 16:
                    return "setSecurityMarginList";
                case 17:
                    return "getSecurityMarginItems";
                case 18:
                    return "reportIfwEvent";
                case 19:
                    return "queryIfwStats";
                case 20:
                    return "updateIfwRuleByUser";
                case 21:
                    return "checkIfwRuleByUser";
                case 22:
                    return "getIfwVersion";
                default:
                    return null;
            }
        }

        public String getTransactionName(int transactionCode) {
            return getDefaultTransactionName(transactionCode);
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            Parcel parcel;
            if (code < 1 || code > 16777215) {
                parcel = data;
            } else {
                parcel = data;
                parcel.enforceInterface(IStepOSHipsService.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IStepOSHipsService.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    String _arg0 = data.readString();
                    int _result = isStopUsbInstall(_arg0);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case 2:
                    boolean _arg02 = data.readBoolean();
                    setUsbInstallSwitchState(_arg02);
                    reply.writeNoException();
                    return true;
                case 3:
                    int _result2 = getUsbInstallSwitchState();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case 4:
                    int _arg03 = data.readInt();
                    String _arg1 = data.readString();
                    String _arg2 = data.readString();
                    int _arg3 = data.readInt();
                    setUsbInstallItemState(_arg03, _arg1, _arg2, _arg3);
                    reply.writeNoException();
                    return true;
                case 5:
                    Map _result3 = getUsbInstallInfo();
                    reply.writeNoException();
                    reply.writeMap(_result3);
                    return true;
                case 6:
                    boolean _result4 = isInPasswordMode();
                    reply.writeNoException();
                    reply.writeBoolean(_result4);
                    return true;
                case 7:
                    boolean _result5 = isSecurityKBSwitchOn();
                    reply.writeNoException();
                    reply.writeBoolean(_result5);
                    return true;
                case 8:
                    boolean _arg04 = data.readBoolean();
                    setPasswordModeSwitchState(_arg04);
                    reply.writeNoException();
                    return true;
                case 9:
                    boolean _result6 = getPasswordModeSwitchState();
                    reply.writeNoException();
                    reply.writeBoolean(_result6);
                    return true;
                case 10:
                    boolean _result7 = isInSecurityMargin();
                    reply.writeNoException();
                    reply.writeBoolean(_result7);
                    return true;
                case 11:
                    boolean _arg05 = data.readBoolean();
                    setSecurityMarginSwitchState(_arg05);
                    reply.writeNoException();
                    return true;
                case 12:
                    boolean _result8 = getSecurityMarginSwitchState();
                    reply.writeNoException();
                    reply.writeBoolean(_result8);
                    return true;
                case 13:
                    int _result9 = getSecurityMarginVersion();
                    reply.writeNoException();
                    reply.writeInt(_result9);
                    return true;
                case 14:
                    long _arg06 = data.readLong();
                    setSecurityMarginTimeStamp(_arg06);
                    reply.writeNoException();
                    return true;
                case 15:
                    long _result10 = getSecurityMarginTimeStamp();
                    reply.writeNoException();
                    reply.writeLong(_result10);
                    return true;
                case 16:
                    List<String> _arg07 = data.createStringArrayList();
                    int _result11 = setSecurityMarginList(_arg07);
                    reply.writeNoException();
                    reply.writeInt(_result11);
                    return true;
                case 17:
                    Map _result12 = getSecurityMarginItems();
                    reply.writeNoException();
                    reply.writeMap(_result12);
                    return true;
                case 18:
                    int _arg08 = parcel.readInt();
                    String _arg12 = parcel.readString();
                    int _arg22 = parcel.readInt();
                    String _arg32 = parcel.readString();
                    int _arg4 = parcel.readInt();
                    String _arg5 = parcel.readString();
                    String _arg6 = parcel.readString();
                    String _arg7 = parcel.readString();
                    boolean _arg8 = data.readBoolean();
                    boolean _arg9 = data.readBoolean();
                    int _arg10 = data.readInt();
                    String _arg11 = data.readString();
                    boolean _arg122 = data.readBoolean();
                    boolean _arg13 = data.readBoolean();
                    reportIfwEvent(_arg08, _arg12, _arg22, _arg32, _arg4, _arg5, _arg6, _arg7, _arg8, _arg9, _arg10, _arg11, _arg122, _arg13);
                    reply.writeNoException();
                    return true;
                case 19:
                    String _arg09 = parcel.readString();
                    long _arg14 = parcel.readLong();
                    long _arg23 = parcel.readLong();
                    List<String> _result13 = queryIfwStats(_arg09, _arg14, _arg23);
                    reply.writeNoException();
                    reply.writeStringList(_result13);
                    return true;
                case 20:
                    int _arg010 = parcel.readInt();
                    int _arg15 = parcel.readInt();
                    String _arg24 = parcel.readString();
                    String _arg33 = parcel.readString();
                    boolean _arg42 = parcel.readBoolean();
                    updateIfwRuleByUser(_arg010, _arg15, _arg24, _arg33, _arg42);
                    reply.writeNoException();
                    return true;
                case 21:
                    int _arg011 = parcel.readInt();
                    String _arg16 = parcel.readString();
                    String _arg25 = parcel.readString();
                    boolean _arg34 = parcel.readBoolean();
                    int _result14 = checkIfwRuleByUser(_arg011, _arg16, _arg25, _arg34);
                    reply.writeNoException();
                    reply.writeInt(_result14);
                    return true;
                case 22:
                    int _result15 = getIfwVersion();
                    reply.writeNoException();
                    reply.writeInt(_result15);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IStepOSHipsService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IStepOSHipsService.DESCRIPTOR;
            }

            @Override // android.permission.IStepOSHipsService
            public int isStopUsbInstall(String apkPath) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSHipsService.DESCRIPTOR);
                    _data.writeString(apkPath);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSHipsService
            public void setUsbInstallSwitchState(boolean isOn) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSHipsService.DESCRIPTOR);
                    _data.writeBoolean(isOn);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSHipsService
            public int getUsbInstallSwitchState() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSHipsService.DESCRIPTOR);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSHipsService
            public void setUsbInstallItemState(int type, String pkgName, String apkName, int mode) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSHipsService.DESCRIPTOR);
                    _data.writeInt(type);
                    _data.writeString(pkgName);
                    _data.writeString(apkName);
                    _data.writeInt(mode);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSHipsService
            public Map getUsbInstallInfo() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSHipsService.DESCRIPTOR);
                    this.mRemote.transact(5, _data, _reply, 0);
                    _reply.readException();
                    ClassLoader cl = getClass().getClassLoader();
                    Map _result = _reply.readHashMap(cl);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSHipsService
            public boolean isInPasswordMode() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSHipsService.DESCRIPTOR);
                    this.mRemote.transact(6, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSHipsService
            public boolean isSecurityKBSwitchOn() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSHipsService.DESCRIPTOR);
                    this.mRemote.transact(7, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSHipsService
            public void setPasswordModeSwitchState(boolean isOn) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSHipsService.DESCRIPTOR);
                    _data.writeBoolean(isOn);
                    this.mRemote.transact(8, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSHipsService
            public boolean getPasswordModeSwitchState() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSHipsService.DESCRIPTOR);
                    this.mRemote.transact(9, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSHipsService
            public boolean isInSecurityMargin() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSHipsService.DESCRIPTOR);
                    this.mRemote.transact(10, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSHipsService
            public void setSecurityMarginSwitchState(boolean isOn) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSHipsService.DESCRIPTOR);
                    _data.writeBoolean(isOn);
                    this.mRemote.transact(11, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSHipsService
            public boolean getSecurityMarginSwitchState() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSHipsService.DESCRIPTOR);
                    this.mRemote.transact(12, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSHipsService
            public int getSecurityMarginVersion() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSHipsService.DESCRIPTOR);
                    this.mRemote.transact(13, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSHipsService
            public void setSecurityMarginTimeStamp(long timeStamp) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSHipsService.DESCRIPTOR);
                    _data.writeLong(timeStamp);
                    this.mRemote.transact(14, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSHipsService
            public long getSecurityMarginTimeStamp() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSHipsService.DESCRIPTOR);
                    this.mRemote.transact(15, _data, _reply, 0);
                    _reply.readException();
                    long _result = _reply.readLong();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSHipsService
            public int setSecurityMarginList(List<String> list) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSHipsService.DESCRIPTOR);
                    _data.writeStringList(list);
                    this.mRemote.transact(16, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSHipsService
            public Map getSecurityMarginItems() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSHipsService.DESCRIPTOR);
                    this.mRemote.transact(17, _data, _reply, 0);
                    _reply.readException();
                    ClassLoader cl = getClass().getClassLoader();
                    Map _result = _reply.readHashMap(cl);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSHipsService
            public void reportIfwEvent(int type, String caller, int callerUid, String callee, int calleeUid, String action, String component, String providerName, boolean foreground, boolean running, int query, String reason, boolean intercept, boolean custom) throws Throwable {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSHipsService.DESCRIPTOR);
                    _data.writeInt(type);
                    _data.writeString(caller);
                    try {
                        _data.writeInt(callerUid);
                        try {
                            _data.writeString(callee);
                            try {
                                _data.writeInt(calleeUid);
                                try {
                                    _data.writeString(action);
                                    try {
                                        _data.writeString(component);
                                        try {
                                            _data.writeString(providerName);
                                            try {
                                                _data.writeBoolean(foreground);
                                            } catch (Throwable th) {
                                                th = th;
                                                _reply.recycle();
                                                _data.recycle();
                                                throw th;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            _reply.recycle();
                                            _data.recycle();
                                            throw th;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        _reply.recycle();
                                        _data.recycle();
                                        throw th;
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    _reply.recycle();
                                    _data.recycle();
                                    throw th;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                _reply.recycle();
                                _data.recycle();
                                throw th;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            _reply.recycle();
                            _data.recycle();
                            throw th;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        _reply.recycle();
                        _data.recycle();
                        throw th;
                    }
                    try {
                        _data.writeBoolean(running);
                        try {
                            _data.writeInt(query);
                            try {
                                _data.writeString(reason);
                                try {
                                    _data.writeBoolean(intercept);
                                    _data.writeBoolean(custom);
                                    this.mRemote.transact(18, _data, _reply, 0);
                                    _reply.readException();
                                    _reply.recycle();
                                    _data.recycle();
                                } catch (Throwable th8) {
                                    th = th8;
                                    _reply.recycle();
                                    _data.recycle();
                                    throw th;
                                }
                            } catch (Throwable th9) {
                                th = th9;
                                _reply.recycle();
                                _data.recycle();
                                throw th;
                            }
                        } catch (Throwable th10) {
                            th = th10;
                            _reply.recycle();
                            _data.recycle();
                            throw th;
                        }
                    } catch (Throwable th11) {
                        th = th11;
                        _reply.recycle();
                        _data.recycle();
                        throw th;
                    }
                } catch (Throwable th12) {
                    th = th12;
                }
            }

            @Override // android.permission.IStepOSHipsService
            public List<String> queryIfwStats(String packageName, long startTime, long endTime) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSHipsService.DESCRIPTOR);
                    _data.writeString(packageName);
                    _data.writeLong(startTime);
                    _data.writeLong(endTime);
                    this.mRemote.transact(19, _data, _reply, 0);
                    _reply.readException();
                    List<String> _result = _reply.createStringArrayList();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSHipsService
            public void updateIfwRuleByUser(int type, int mode, String caller, String callee, boolean isFg) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSHipsService.DESCRIPTOR);
                    _data.writeInt(type);
                    _data.writeInt(mode);
                    _data.writeString(caller);
                    _data.writeString(callee);
                    _data.writeBoolean(isFg);
                    this.mRemote.transact(20, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSHipsService
            public int checkIfwRuleByUser(int type, String sender, String receiver, boolean isFg) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSHipsService.DESCRIPTOR);
                    _data.writeInt(type);
                    _data.writeString(sender);
                    _data.writeString(receiver);
                    _data.writeBoolean(isFg);
                    this.mRemote.transact(21, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSHipsService
            public int getIfwVersion() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSHipsService.DESCRIPTOR);
                    this.mRemote.transact(22, _data, _reply, 0);
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
            return 21;
        }
    }
}
