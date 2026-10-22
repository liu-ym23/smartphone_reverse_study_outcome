package android.permission;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* loaded from: classes.dex */
public interface IStepOSAccessControlManager extends IInterface {
    public static final String DESCRIPTOR = "android.permission.IStepOSAccessControlManager";

    boolean addClassName(String str) throws RemoteException;

    boolean addPackageName(String str) throws RemoteException;

    boolean checkAccessControl(String str) throws RemoteException;

    boolean delClassName(String str) throws RemoteException;

    boolean delPackageName(String str) throws RemoteException;

    List<String> getPackageName() throws RemoteException;

    List<String> getPackageNameWithStatus() throws RemoteException;

    boolean getSwitchStatus() throws RemoteException;

    boolean isAppProtected(String str) throws RemoteException;

    boolean isAppProtected2(String str) throws RemoteException;

    byte isAppUnlocked(String str) throws RemoteException;

    boolean isPopupUnlockingActivity(String str, Intent intent) throws RemoteException;

    boolean resetStatus() throws RemoteException;

    boolean saveAppList() throws RemoteException;

    boolean setSwitchStatus(boolean z) throws RemoteException;

    boolean updateStatus(String str) throws RemoteException;

    public static class Default implements IStepOSAccessControlManager {
        @Override // android.permission.IStepOSAccessControlManager
        public boolean isPopupUnlockingActivity(String szIdentifier, Intent itIntent) throws RemoteException {
            return false;
        }

        @Override // android.permission.IStepOSAccessControlManager
        public boolean isAppProtected(String szPackageName) throws RemoteException {
            return false;
        }

        @Override // android.permission.IStepOSAccessControlManager
        public boolean isAppProtected2(String szPackageName) throws RemoteException {
            return false;
        }

        @Override // android.permission.IStepOSAccessControlManager
        public byte isAppUnlocked(String szPackageName) throws RemoteException {
            return (byte) 0;
        }

        @Override // android.permission.IStepOSAccessControlManager
        public boolean getSwitchStatus() throws RemoteException {
            return false;
        }

        @Override // android.permission.IStepOSAccessControlManager
        public boolean setSwitchStatus(boolean b) throws RemoteException {
            return false;
        }

        @Override // android.permission.IStepOSAccessControlManager
        public boolean saveAppList() throws RemoteException {
            return false;
        }

        @Override // android.permission.IStepOSAccessControlManager
        public boolean updateStatus(String szPackageName) throws RemoteException {
            return false;
        }

        @Override // android.permission.IStepOSAccessControlManager
        public boolean resetStatus() throws RemoteException {
            return false;
        }

        @Override // android.permission.IStepOSAccessControlManager
        public boolean addPackageName(String szPackageName) throws RemoteException {
            return false;
        }

        @Override // android.permission.IStepOSAccessControlManager
        public boolean delPackageName(String szPackageName) throws RemoteException {
            return false;
        }

        @Override // android.permission.IStepOSAccessControlManager
        public boolean addClassName(String szClassName) throws RemoteException {
            return false;
        }

        @Override // android.permission.IStepOSAccessControlManager
        public boolean delClassName(String szClassName) throws RemoteException {
            return false;
        }

        @Override // android.permission.IStepOSAccessControlManager
        public List<String> getPackageName() throws RemoteException {
            return null;
        }

        @Override // android.permission.IStepOSAccessControlManager
        public List<String> getPackageNameWithStatus() throws RemoteException {
            return null;
        }

        @Override // android.permission.IStepOSAccessControlManager
        public boolean checkAccessControl(String szPackageName) throws RemoteException {
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IStepOSAccessControlManager {
        static final int TRANSACTION_addClassName = 12;
        static final int TRANSACTION_addPackageName = 10;
        static final int TRANSACTION_checkAccessControl = 16;
        static final int TRANSACTION_delClassName = 13;
        static final int TRANSACTION_delPackageName = 11;
        static final int TRANSACTION_getPackageName = 14;
        static final int TRANSACTION_getPackageNameWithStatus = 15;
        static final int TRANSACTION_getSwitchStatus = 5;
        static final int TRANSACTION_isAppProtected = 2;
        static final int TRANSACTION_isAppProtected2 = 3;
        static final int TRANSACTION_isAppUnlocked = 4;
        static final int TRANSACTION_isPopupUnlockingActivity = 1;
        static final int TRANSACTION_resetStatus = 9;
        static final int TRANSACTION_saveAppList = 7;
        static final int TRANSACTION_setSwitchStatus = 6;
        static final int TRANSACTION_updateStatus = 8;

        public Stub() {
            attachInterface(this, IStepOSAccessControlManager.DESCRIPTOR);
        }

        public static IStepOSAccessControlManager asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IStepOSAccessControlManager.DESCRIPTOR);
            if (iin != null && (iin instanceof IStepOSAccessControlManager)) {
                return (IStepOSAccessControlManager) iin;
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
                    return "isPopupUnlockingActivity";
                case 2:
                    return "isAppProtected";
                case 3:
                    return "isAppProtected2";
                case 4:
                    return "isAppUnlocked";
                case 5:
                    return "getSwitchStatus";
                case 6:
                    return "setSwitchStatus";
                case 7:
                    return "saveAppList";
                case 8:
                    return "updateStatus";
                case 9:
                    return "resetStatus";
                case 10:
                    return "addPackageName";
                case 11:
                    return "delPackageName";
                case 12:
                    return "addClassName";
                case 13:
                    return "delClassName";
                case 14:
                    return "getPackageName";
                case 15:
                    return "getPackageNameWithStatus";
                case 16:
                    return "checkAccessControl";
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
                data.enforceInterface(IStepOSAccessControlManager.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IStepOSAccessControlManager.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    String _arg0 = data.readString();
                    Intent _arg1 = (Intent) data.readTypedObject(Intent.CREATOR);
                    boolean _result = isPopupUnlockingActivity(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeBoolean(_result);
                    return true;
                case 2:
                    String _arg02 = data.readString();
                    boolean _result2 = isAppProtected(_arg02);
                    reply.writeNoException();
                    reply.writeBoolean(_result2);
                    return true;
                case 3:
                    String _arg03 = data.readString();
                    boolean _result3 = isAppProtected2(_arg03);
                    reply.writeNoException();
                    reply.writeBoolean(_result3);
                    return true;
                case 4:
                    String _arg04 = data.readString();
                    byte _result4 = isAppUnlocked(_arg04);
                    reply.writeNoException();
                    reply.writeByte(_result4);
                    return true;
                case 5:
                    boolean _result5 = getSwitchStatus();
                    reply.writeNoException();
                    reply.writeBoolean(_result5);
                    return true;
                case 6:
                    boolean _arg05 = data.readBoolean();
                    boolean _result6 = setSwitchStatus(_arg05);
                    reply.writeNoException();
                    reply.writeBoolean(_result6);
                    return true;
                case 7:
                    boolean _result7 = saveAppList();
                    reply.writeNoException();
                    reply.writeBoolean(_result7);
                    return true;
                case 8:
                    String _arg06 = data.readString();
                    boolean _result8 = updateStatus(_arg06);
                    reply.writeNoException();
                    reply.writeBoolean(_result8);
                    return true;
                case 9:
                    boolean _result9 = resetStatus();
                    reply.writeNoException();
                    reply.writeBoolean(_result9);
                    return true;
                case 10:
                    String _arg07 = data.readString();
                    boolean _result10 = addPackageName(_arg07);
                    reply.writeNoException();
                    reply.writeBoolean(_result10);
                    return true;
                case 11:
                    String _arg08 = data.readString();
                    boolean _result11 = delPackageName(_arg08);
                    reply.writeNoException();
                    reply.writeBoolean(_result11);
                    return true;
                case 12:
                    String _arg09 = data.readString();
                    boolean _result12 = addClassName(_arg09);
                    reply.writeNoException();
                    reply.writeBoolean(_result12);
                    return true;
                case 13:
                    String _arg010 = data.readString();
                    boolean _result13 = delClassName(_arg010);
                    reply.writeNoException();
                    reply.writeBoolean(_result13);
                    return true;
                case 14:
                    List<String> _result14 = getPackageName();
                    reply.writeNoException();
                    reply.writeStringList(_result14);
                    return true;
                case 15:
                    List<String> _result15 = getPackageNameWithStatus();
                    reply.writeNoException();
                    reply.writeStringList(_result15);
                    return true;
                case 16:
                    String _arg011 = data.readString();
                    boolean _result16 = checkAccessControl(_arg011);
                    reply.writeNoException();
                    reply.writeBoolean(_result16);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IStepOSAccessControlManager {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IStepOSAccessControlManager.DESCRIPTOR;
            }

            @Override // android.permission.IStepOSAccessControlManager
            public boolean isPopupUnlockingActivity(String szIdentifier, Intent itIntent) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSAccessControlManager.DESCRIPTOR);
                    _data.writeString(szIdentifier);
                    _data.writeTypedObject(itIntent, 0);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSAccessControlManager
            public boolean isAppProtected(String szPackageName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSAccessControlManager.DESCRIPTOR);
                    _data.writeString(szPackageName);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSAccessControlManager
            public boolean isAppProtected2(String szPackageName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSAccessControlManager.DESCRIPTOR);
                    _data.writeString(szPackageName);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSAccessControlManager
            public byte isAppUnlocked(String szPackageName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSAccessControlManager.DESCRIPTOR);
                    _data.writeString(szPackageName);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                    byte _result = _reply.readByte();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSAccessControlManager
            public boolean getSwitchStatus() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSAccessControlManager.DESCRIPTOR);
                    this.mRemote.transact(5, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSAccessControlManager
            public boolean setSwitchStatus(boolean b) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSAccessControlManager.DESCRIPTOR);
                    _data.writeBoolean(b);
                    this.mRemote.transact(6, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSAccessControlManager
            public boolean saveAppList() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSAccessControlManager.DESCRIPTOR);
                    this.mRemote.transact(7, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSAccessControlManager
            public boolean updateStatus(String szPackageName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSAccessControlManager.DESCRIPTOR);
                    _data.writeString(szPackageName);
                    this.mRemote.transact(8, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSAccessControlManager
            public boolean resetStatus() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSAccessControlManager.DESCRIPTOR);
                    this.mRemote.transact(9, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSAccessControlManager
            public boolean addPackageName(String szPackageName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSAccessControlManager.DESCRIPTOR);
                    _data.writeString(szPackageName);
                    this.mRemote.transact(10, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSAccessControlManager
            public boolean delPackageName(String szPackageName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSAccessControlManager.DESCRIPTOR);
                    _data.writeString(szPackageName);
                    this.mRemote.transact(11, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSAccessControlManager
            public boolean addClassName(String szClassName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSAccessControlManager.DESCRIPTOR);
                    _data.writeString(szClassName);
                    this.mRemote.transact(12, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSAccessControlManager
            public boolean delClassName(String szClassName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSAccessControlManager.DESCRIPTOR);
                    _data.writeString(szClassName);
                    this.mRemote.transact(13, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSAccessControlManager
            public List<String> getPackageName() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSAccessControlManager.DESCRIPTOR);
                    this.mRemote.transact(14, _data, _reply, 0);
                    _reply.readException();
                    List<String> _result = _reply.createStringArrayList();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSAccessControlManager
            public List<String> getPackageNameWithStatus() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSAccessControlManager.DESCRIPTOR);
                    this.mRemote.transact(15, _data, _reply, 0);
                    _reply.readException();
                    List<String> _result = _reply.createStringArrayList();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.permission.IStepOSAccessControlManager
            public boolean checkAccessControl(String szPackageName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSAccessControlManager.DESCRIPTOR);
                    _data.writeString(szPackageName);
                    this.mRemote.transact(16, _data, _reply, 0);
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
            return 15;
        }
    }
}
