package android.os;

import android.os.IStepOSSpaceOptListener;

/* loaded from: classes.dex */
public interface IStepOSInstall extends IInterface {
    public static final String DESCRIPTOR = "android.os.IStepOSInstall";

    void appCompress(String[] strArr, int i, IStepOSSpaceOptListener iStepOSSpaceOptListener) throws RemoteException;

    void cancelTask() throws RemoteException;

    void copyDataFiles(String str, String str2) throws RemoteException;

    void copyFiles(String str, String str2) throws RemoteException;

    int copyFilesRestore(String str, String str2) throws RemoteException;

    int copyFilesStaged(String str, String str2, int i) throws RemoteException;

    boolean createDirectory(String str) throws RemoteException;

    boolean deleteFile(String str) throws RemoteException;

    long getCurrentRecoveredSize() throws RemoteException;

    long getTotalSize(String str) throws RemoteException;

    void interruptCopyAndRestore() throws RemoteException;

    boolean isFileRealyExists(String str) throws RemoteException;

    void linkRepeatedFiles(String[] strArr, IStepOSSpaceOptListener iStepOSSpaceOptListener) throws RemoteException;

    int linkRepeatedFilesByCow(String str, String str2) throws RemoteException;

    int markFileByCow(int i, String str) throws RemoteException;

    boolean moveFile(String str, String str2) throws RemoteException;

    void removeRf(String str) throws RemoteException;

    boolean renameFiles(String str, String str2) throws RemoteException;

    void resetPauseIno() throws RemoteException;

    boolean restoreAndroidDataOwner(String str, int i) throws RemoteException;

    void startCaptureLog(String str) throws RemoteException;

    void startScan(IStepOSSpaceOptListener iStepOSSpaceOptListener) throws RemoteException;

    void startScanApps(String[] strArr, int i, IStepOSSpaceOptListener iStepOSSpaceOptListener) throws RemoteException;

    void stopCaptureLog() throws RemoteException;

    public static class Default implements IStepOSInstall {
        @Override // android.os.IStepOSInstall
        public void copyFiles(String srcPath, String targetPath) throws RemoteException {
        }

        @Override // android.os.IStepOSInstall
        public int copyFilesStaged(String srcPath, String targetPath, int singleCopyMb) throws RemoteException {
            return 0;
        }

        @Override // android.os.IStepOSInstall
        public int copyFilesRestore(String srcPath, String targetPath) throws RemoteException {
            return 0;
        }

        @Override // android.os.IStepOSInstall
        public void interruptCopyAndRestore() throws RemoteException {
        }

        @Override // android.os.IStepOSInstall
        public void resetPauseIno() throws RemoteException {
        }

        @Override // android.os.IStepOSInstall
        public long getCurrentRecoveredSize() throws RemoteException {
            return 0L;
        }

        @Override // android.os.IStepOSInstall
        public long getTotalSize(String srcPath) throws RemoteException {
            return 0L;
        }

        @Override // android.os.IStepOSInstall
        public void removeRf(String packageName) throws RemoteException {
        }

        @Override // android.os.IStepOSInstall
        public void startCaptureLog(String srcPath) throws RemoteException {
        }

        @Override // android.os.IStepOSInstall
        public void stopCaptureLog() throws RemoteException {
        }

        @Override // android.os.IStepOSInstall
        public boolean restoreAndroidDataOwner(String path, int uid) throws RemoteException {
            return false;
        }

        @Override // android.os.IStepOSInstall
        public void copyDataFiles(String srcPath, String targetPath) throws RemoteException {
        }

        @Override // android.os.IStepOSInstall
        public boolean createDirectory(String path) throws RemoteException {
            return false;
        }

        @Override // android.os.IStepOSInstall
        public boolean renameFiles(String srcPath, String targetPath) throws RemoteException {
            return false;
        }

        @Override // android.os.IStepOSInstall
        public boolean isFileRealyExists(String filePath) throws RemoteException {
            return false;
        }

        @Override // android.os.IStepOSInstall
        public boolean moveFile(String srcPath, String targetPath) throws RemoteException {
            return false;
        }

        @Override // android.os.IStepOSInstall
        public boolean deleteFile(String filePath) throws RemoteException {
            return false;
        }

        @Override // android.os.IStepOSInstall
        public void startScan(IStepOSSpaceOptListener listener) throws RemoteException {
        }

        @Override // android.os.IStepOSInstall
        public void linkRepeatedFiles(String[] ids, IStepOSSpaceOptListener listener) throws RemoteException {
        }

        @Override // android.os.IStepOSInstall
        public void cancelTask() throws RemoteException {
        }

        @Override // android.os.IStepOSInstall
        public void startScanApps(String[] thirdApps, int days, IStepOSSpaceOptListener listener) throws RemoteException {
        }

        @Override // android.os.IStepOSInstall
        public void appCompress(String[] apps, int days, IStepOSSpaceOptListener listener) throws RemoteException {
        }

        @Override // android.os.IStepOSInstall
        public int linkRepeatedFilesByCow(String path1, String path2) throws RemoteException {
            return 0;
        }

        @Override // android.os.IStepOSInstall
        public int markFileByCow(int type, String path) throws RemoteException {
            return 0;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IStepOSInstall {
        static final int TRANSACTION_appCompress = 22;
        static final int TRANSACTION_cancelTask = 20;
        static final int TRANSACTION_copyDataFiles = 12;
        static final int TRANSACTION_copyFiles = 1;
        static final int TRANSACTION_copyFilesRestore = 3;
        static final int TRANSACTION_copyFilesStaged = 2;
        static final int TRANSACTION_createDirectory = 13;
        static final int TRANSACTION_deleteFile = 17;
        static final int TRANSACTION_getCurrentRecoveredSize = 6;
        static final int TRANSACTION_getTotalSize = 7;
        static final int TRANSACTION_interruptCopyAndRestore = 4;
        static final int TRANSACTION_isFileRealyExists = 15;
        static final int TRANSACTION_linkRepeatedFiles = 19;
        static final int TRANSACTION_linkRepeatedFilesByCow = 23;
        static final int TRANSACTION_markFileByCow = 24;
        static final int TRANSACTION_moveFile = 16;
        static final int TRANSACTION_removeRf = 8;
        static final int TRANSACTION_renameFiles = 14;
        static final int TRANSACTION_resetPauseIno = 5;
        static final int TRANSACTION_restoreAndroidDataOwner = 11;
        static final int TRANSACTION_startCaptureLog = 9;
        static final int TRANSACTION_startScan = 18;
        static final int TRANSACTION_startScanApps = 21;
        static final int TRANSACTION_stopCaptureLog = 10;

        public Stub() {
            attachInterface(this, IStepOSInstall.DESCRIPTOR);
        }

        public static IStepOSInstall asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IStepOSInstall.DESCRIPTOR);
            if (iin != null && (iin instanceof IStepOSInstall)) {
                return (IStepOSInstall) iin;
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
                    return "copyFiles";
                case 2:
                    return "copyFilesStaged";
                case 3:
                    return "copyFilesRestore";
                case 4:
                    return "interruptCopyAndRestore";
                case 5:
                    return "resetPauseIno";
                case 6:
                    return "getCurrentRecoveredSize";
                case 7:
                    return "getTotalSize";
                case 8:
                    return "removeRf";
                case 9:
                    return "startCaptureLog";
                case 10:
                    return "stopCaptureLog";
                case 11:
                    return "restoreAndroidDataOwner";
                case 12:
                    return "copyDataFiles";
                case 13:
                    return "createDirectory";
                case 14:
                    return "renameFiles";
                case 15:
                    return "isFileRealyExists";
                case 16:
                    return "moveFile";
                case 17:
                    return "deleteFile";
                case 18:
                    return "startScan";
                case 19:
                    return "linkRepeatedFiles";
                case 20:
                    return "cancelTask";
                case 21:
                    return "startScanApps";
                case 22:
                    return "appCompress";
                case 23:
                    return "linkRepeatedFilesByCow";
                case 24:
                    return "markFileByCow";
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
                data.enforceInterface(IStepOSInstall.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IStepOSInstall.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    String _arg0 = data.readString();
                    String _arg1 = data.readString();
                    copyFiles(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                case 2:
                    String _arg02 = data.readString();
                    String _arg12 = data.readString();
                    int _arg2 = data.readInt();
                    int _result = copyFilesStaged(_arg02, _arg12, _arg2);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case 3:
                    String _arg03 = data.readString();
                    String _arg13 = data.readString();
                    int _result2 = copyFilesRestore(_arg03, _arg13);
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case 4:
                    interruptCopyAndRestore();
                    reply.writeNoException();
                    return true;
                case 5:
                    resetPauseIno();
                    reply.writeNoException();
                    return true;
                case 6:
                    long _result3 = getCurrentRecoveredSize();
                    reply.writeNoException();
                    reply.writeLong(_result3);
                    return true;
                case 7:
                    String _arg04 = data.readString();
                    long _result4 = getTotalSize(_arg04);
                    reply.writeNoException();
                    reply.writeLong(_result4);
                    return true;
                case 8:
                    String _arg05 = data.readString();
                    removeRf(_arg05);
                    reply.writeNoException();
                    return true;
                case 9:
                    String _arg06 = data.readString();
                    startCaptureLog(_arg06);
                    reply.writeNoException();
                    return true;
                case 10:
                    stopCaptureLog();
                    reply.writeNoException();
                    return true;
                case 11:
                    String _arg07 = data.readString();
                    int _arg14 = data.readInt();
                    boolean _result5 = restoreAndroidDataOwner(_arg07, _arg14);
                    reply.writeNoException();
                    reply.writeBoolean(_result5);
                    return true;
                case 12:
                    String _arg08 = data.readString();
                    String _arg15 = data.readString();
                    copyDataFiles(_arg08, _arg15);
                    reply.writeNoException();
                    return true;
                case 13:
                    String _arg09 = data.readString();
                    boolean _result6 = createDirectory(_arg09);
                    reply.writeNoException();
                    reply.writeBoolean(_result6);
                    return true;
                case 14:
                    String _arg010 = data.readString();
                    String _arg16 = data.readString();
                    boolean _result7 = renameFiles(_arg010, _arg16);
                    reply.writeNoException();
                    reply.writeBoolean(_result7);
                    return true;
                case 15:
                    String _arg011 = data.readString();
                    boolean _result8 = isFileRealyExists(_arg011);
                    reply.writeNoException();
                    reply.writeBoolean(_result8);
                    return true;
                case 16:
                    String _arg012 = data.readString();
                    String _arg17 = data.readString();
                    boolean _result9 = moveFile(_arg012, _arg17);
                    reply.writeNoException();
                    reply.writeBoolean(_result9);
                    return true;
                case 17:
                    String _arg013 = data.readString();
                    boolean _result10 = deleteFile(_arg013);
                    reply.writeNoException();
                    reply.writeBoolean(_result10);
                    return true;
                case 18:
                    IStepOSSpaceOptListener _arg014 = IStepOSSpaceOptListener.Stub.asInterface(data.readStrongBinder());
                    startScan(_arg014);
                    reply.writeNoException();
                    return true;
                case 19:
                    String[] _arg015 = data.createStringArray();
                    IStepOSSpaceOptListener _arg18 = IStepOSSpaceOptListener.Stub.asInterface(data.readStrongBinder());
                    linkRepeatedFiles(_arg015, _arg18);
                    reply.writeNoException();
                    return true;
                case 20:
                    cancelTask();
                    reply.writeNoException();
                    return true;
                case 21:
                    String[] _arg016 = data.createStringArray();
                    int _arg19 = data.readInt();
                    IStepOSSpaceOptListener _arg22 = IStepOSSpaceOptListener.Stub.asInterface(data.readStrongBinder());
                    startScanApps(_arg016, _arg19, _arg22);
                    reply.writeNoException();
                    return true;
                case 22:
                    String[] _arg017 = data.createStringArray();
                    int _arg110 = data.readInt();
                    IStepOSSpaceOptListener _arg23 = IStepOSSpaceOptListener.Stub.asInterface(data.readStrongBinder());
                    appCompress(_arg017, _arg110, _arg23);
                    reply.writeNoException();
                    return true;
                case 23:
                    String _arg018 = data.readString();
                    String _arg111 = data.readString();
                    int _result11 = linkRepeatedFilesByCow(_arg018, _arg111);
                    reply.writeNoException();
                    reply.writeInt(_result11);
                    return true;
                case 24:
                    int _arg019 = data.readInt();
                    String _arg112 = data.readString();
                    int _result12 = markFileByCow(_arg019, _arg112);
                    reply.writeNoException();
                    reply.writeInt(_result12);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IStepOSInstall {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IStepOSInstall.DESCRIPTOR;
            }

            @Override // android.os.IStepOSInstall
            public void copyFiles(String srcPath, String targetPath) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSInstall.DESCRIPTOR);
                    _data.writeString(srcPath);
                    _data.writeString(targetPath);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.os.IStepOSInstall
            public int copyFilesStaged(String srcPath, String targetPath, int singleCopyMb) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSInstall.DESCRIPTOR);
                    _data.writeString(srcPath);
                    _data.writeString(targetPath);
                    _data.writeInt(singleCopyMb);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.os.IStepOSInstall
            public int copyFilesRestore(String srcPath, String targetPath) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSInstall.DESCRIPTOR);
                    _data.writeString(srcPath);
                    _data.writeString(targetPath);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.os.IStepOSInstall
            public void interruptCopyAndRestore() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSInstall.DESCRIPTOR);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.os.IStepOSInstall
            public void resetPauseIno() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSInstall.DESCRIPTOR);
                    this.mRemote.transact(5, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.os.IStepOSInstall
            public long getCurrentRecoveredSize() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSInstall.DESCRIPTOR);
                    this.mRemote.transact(6, _data, _reply, 0);
                    _reply.readException();
                    long _result = _reply.readLong();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.os.IStepOSInstall
            public long getTotalSize(String srcPath) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSInstall.DESCRIPTOR);
                    _data.writeString(srcPath);
                    this.mRemote.transact(7, _data, _reply, 0);
                    _reply.readException();
                    long _result = _reply.readLong();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.os.IStepOSInstall
            public void removeRf(String packageName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSInstall.DESCRIPTOR);
                    _data.writeString(packageName);
                    this.mRemote.transact(8, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.os.IStepOSInstall
            public void startCaptureLog(String srcPath) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSInstall.DESCRIPTOR);
                    _data.writeString(srcPath);
                    this.mRemote.transact(9, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.os.IStepOSInstall
            public void stopCaptureLog() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSInstall.DESCRIPTOR);
                    this.mRemote.transact(10, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.os.IStepOSInstall
            public boolean restoreAndroidDataOwner(String path, int uid) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSInstall.DESCRIPTOR);
                    _data.writeString(path);
                    _data.writeInt(uid);
                    this.mRemote.transact(11, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.os.IStepOSInstall
            public void copyDataFiles(String srcPath, String targetPath) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSInstall.DESCRIPTOR);
                    _data.writeString(srcPath);
                    _data.writeString(targetPath);
                    this.mRemote.transact(12, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.os.IStepOSInstall
            public boolean createDirectory(String path) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSInstall.DESCRIPTOR);
                    _data.writeString(path);
                    this.mRemote.transact(13, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.os.IStepOSInstall
            public boolean renameFiles(String srcPath, String targetPath) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSInstall.DESCRIPTOR);
                    _data.writeString(srcPath);
                    _data.writeString(targetPath);
                    this.mRemote.transact(14, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.os.IStepOSInstall
            public boolean isFileRealyExists(String filePath) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSInstall.DESCRIPTOR);
                    _data.writeString(filePath);
                    this.mRemote.transact(15, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.os.IStepOSInstall
            public boolean moveFile(String srcPath, String targetPath) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSInstall.DESCRIPTOR);
                    _data.writeString(srcPath);
                    _data.writeString(targetPath);
                    this.mRemote.transact(16, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.os.IStepOSInstall
            public boolean deleteFile(String filePath) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSInstall.DESCRIPTOR);
                    _data.writeString(filePath);
                    this.mRemote.transact(17, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.os.IStepOSInstall
            public void startScan(IStepOSSpaceOptListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSInstall.DESCRIPTOR);
                    _data.writeStrongInterface(listener);
                    this.mRemote.transact(18, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.os.IStepOSInstall
            public void linkRepeatedFiles(String[] ids, IStepOSSpaceOptListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSInstall.DESCRIPTOR);
                    _data.writeStringArray(ids);
                    _data.writeStrongInterface(listener);
                    this.mRemote.transact(19, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.os.IStepOSInstall
            public void cancelTask() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSInstall.DESCRIPTOR);
                    this.mRemote.transact(20, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.os.IStepOSInstall
            public void startScanApps(String[] thirdApps, int days, IStepOSSpaceOptListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSInstall.DESCRIPTOR);
                    _data.writeStringArray(thirdApps);
                    _data.writeInt(days);
                    _data.writeStrongInterface(listener);
                    this.mRemote.transact(21, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.os.IStepOSInstall
            public void appCompress(String[] apps, int days, IStepOSSpaceOptListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSInstall.DESCRIPTOR);
                    _data.writeStringArray(apps);
                    _data.writeInt(days);
                    _data.writeStrongInterface(listener);
                    this.mRemote.transact(22, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.os.IStepOSInstall
            public int linkRepeatedFilesByCow(String path1, String path2) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSInstall.DESCRIPTOR);
                    _data.writeString(path1);
                    _data.writeString(path2);
                    this.mRemote.transact(23, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.os.IStepOSInstall
            public int markFileByCow(int type, String path) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSInstall.DESCRIPTOR);
                    _data.writeInt(type);
                    _data.writeString(path);
                    this.mRemote.transact(24, _data, _reply, 0);
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
            return 23;
        }
    }
}
