package stepos.app;

import android.content.ComponentName;
import android.content.pm.ApplicationInfo;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.IStepOSSpaceOptListenerWrapper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.os.RemoteException;
import java.util.List;

/* loaded from: classes.dex */
public interface IStepOSPackageManager extends IInterface {
    public static final String DESCRIPTOR = "stepos.app.IStepOSPackageManager";

    void appCompress(String[] strArr, int i, IStepOSSpaceOptListenerWrapper iStepOSSpaceOptListenerWrapper) throws RemoteException;

    boolean backupData(String str, String str2) throws RemoteException;

    long backupDataGetRecoveredSize() throws RemoteException;

    long backupDataGetTotalSize(String str) throws RemoteException;

    void backupDataInterrupt() throws RemoteException;

    void backupDataRemoveRf(String str) throws RemoteException;

    void backupDataReset() throws RemoteException;

    int backupDataRestore(String str, String str2) throws RemoteException;

    int backupDataStaged(String str, String str2, int i) throws RemoteException;

    void cancelTask() throws RemoteException;

    boolean createDirectory(String str) throws RemoteException;

    boolean deleteFile(String str) throws RemoteException;

    List<ApplicationInfo> getPackageIconStates(List<String> list, int i) throws RemoteException;

    List<String> getStartingRestrictedPackages() throws RemoteException;

    String getStepOSAppCodePath(String str) throws RemoteException;

    List<ApplicationInfo> getSupportsHiddenIconPackages(int i) throws RemoteException;

    List<String> getSwitchablePackagesForCTA() throws RemoteException;

    boolean hidePackageIcon(String str, int i) throws RemoteException;

    boolean isFileRealyExists(String str) throws RemoteException;

    boolean isForceFullForUid(int i) throws RemoteException;

    boolean isSupportsHiddenIcon(String str) throws RemoteException;

    void linkRepeatedFiles(String[] strArr, IStepOSSpaceOptListenerWrapper iStepOSSpaceOptListenerWrapper) throws RemoteException;

    int linkRepeatedFilesByCow(String str, String str2) throws RemoteException;

    int markFileByCow(int i, String str) throws RemoteException;

    boolean moveFile(String str, String str2) throws RemoteException;

    boolean renameFiles(String str, String str2) throws RemoteException;

    boolean restoreAndroidDataOwner(String str, String str2) throws RemoteException;

    boolean restorePackageIcon(String str, int i) throws RemoteException;

    boolean setForceFull(String str, boolean z) throws RemoteException;

    void setInterceptPackage(List<String> list) throws RemoteException;

    void setKeyGuardPackage(String str, boolean z, int i) throws RemoteException;

    String[] setPackagesSuspendedAsUser(String[] strArr, boolean z, PersistableBundle persistableBundle, PersistableBundle persistableBundle2, String str, String str2, int i) throws RemoteException;

    void setkeyguardActivitylist(ComponentName componentName, boolean z) throws RemoteException;

    void startCaptureLog(String str) throws RemoteException;

    void startScan(IStepOSSpaceOptListenerWrapper iStepOSSpaceOptListenerWrapper) throws RemoteException;

    void startScanApps(String[] strArr, int i, IStepOSSpaceOptListenerWrapper iStepOSSpaceOptListenerWrapper) throws RemoteException;

    void stopCaptureLog() throws RemoteException;

    void test() throws RemoteException;

    public static class Default implements IStepOSPackageManager {
        @Override // stepos.app.IStepOSPackageManager
        public void test() throws RemoteException {
        }

        @Override // stepos.app.IStepOSPackageManager
        public int backupDataStaged(String sourceDir, String targetDir, int singleCopyMb) throws RemoteException {
            return 0;
        }

        @Override // stepos.app.IStepOSPackageManager
        public int backupDataRestore(String sourceDir, String targetDir) throws RemoteException {
            return 0;
        }

        @Override // stepos.app.IStepOSPackageManager
        public void backupDataInterrupt() throws RemoteException {
        }

        @Override // stepos.app.IStepOSPackageManager
        public void backupDataReset() throws RemoteException {
        }

        @Override // stepos.app.IStepOSPackageManager
        public long backupDataGetRecoveredSize() throws RemoteException {
            return 0L;
        }

        @Override // stepos.app.IStepOSPackageManager
        public long backupDataGetTotalSize(String sourceDir) throws RemoteException {
            return 0L;
        }

        @Override // stepos.app.IStepOSPackageManager
        public void backupDataRemoveRf(String sourceDir) throws RemoteException {
        }

        @Override // stepos.app.IStepOSPackageManager
        public void startCaptureLog(String sourceDir) throws RemoteException {
        }

        @Override // stepos.app.IStepOSPackageManager
        public void stopCaptureLog() throws RemoteException {
        }

        @Override // stepos.app.IStepOSPackageManager
        public boolean backupData(String sourceDir, String targetDir) throws RemoteException {
            return false;
        }

        @Override // stepos.app.IStepOSPackageManager
        public boolean restoreAndroidDataOwner(String path, String packageName) throws RemoteException {
            return false;
        }

        @Override // stepos.app.IStepOSPackageManager
        public void startScan(IStepOSSpaceOptListenerWrapper listener) throws RemoteException {
        }

        @Override // stepos.app.IStepOSPackageManager
        public void linkRepeatedFiles(String[] ids, IStepOSSpaceOptListenerWrapper listener) throws RemoteException {
        }

        @Override // stepos.app.IStepOSPackageManager
        public void cancelTask() throws RemoteException {
        }

        @Override // stepos.app.IStepOSPackageManager
        public void startScanApps(String[] thirdApps, int days, IStepOSSpaceOptListenerWrapper listener) throws RemoteException {
        }

        @Override // stepos.app.IStepOSPackageManager
        public void appCompress(String[] apps, int days, IStepOSSpaceOptListenerWrapper listener) throws RemoteException {
        }

        @Override // stepos.app.IStepOSPackageManager
        public int linkRepeatedFilesByCow(String path1, String path2) throws RemoteException {
            return 0;
        }

        @Override // stepos.app.IStepOSPackageManager
        public int markFileByCow(int type, String path) throws RemoteException {
            return 0;
        }

        @Override // stepos.app.IStepOSPackageManager
        public boolean createDirectory(String path) throws RemoteException {
            return false;
        }

        @Override // stepos.app.IStepOSPackageManager
        public boolean renameFiles(String srcPath, String targetPath) throws RemoteException {
            return false;
        }

        @Override // stepos.app.IStepOSPackageManager
        public boolean isFileRealyExists(String filePath) throws RemoteException {
            return false;
        }

        @Override // stepos.app.IStepOSPackageManager
        public boolean moveFile(String srcPath, String targetPath) throws RemoteException {
            return false;
        }

        @Override // stepos.app.IStepOSPackageManager
        public boolean deleteFile(String filePath) throws RemoteException {
            return false;
        }

        @Override // stepos.app.IStepOSPackageManager
        public List<String> getStartingRestrictedPackages() throws RemoteException {
            return null;
        }

        @Override // stepos.app.IStepOSPackageManager
        public List<String> getSwitchablePackagesForCTA() throws RemoteException {
            return null;
        }

        @Override // stepos.app.IStepOSPackageManager
        public String getStepOSAppCodePath(String packageName) throws RemoteException {
            return null;
        }

        @Override // stepos.app.IStepOSPackageManager
        public boolean setForceFull(String packageName, boolean forceFull) throws RemoteException {
            return false;
        }

        @Override // stepos.app.IStepOSPackageManager
        public boolean isForceFullForUid(int uid) throws RemoteException {
            return false;
        }

        @Override // stepos.app.IStepOSPackageManager
        public String[] setPackagesSuspendedAsUser(String[] packageNames, boolean suspended, PersistableBundle appExtras, PersistableBundle launcherExtras, String dialogMessage, String callingPackage, int userId) throws RemoteException {
            return null;
        }

        @Override // stepos.app.IStepOSPackageManager
        public boolean hidePackageIcon(String packageName, int userId) throws RemoteException {
            return false;
        }

        @Override // stepos.app.IStepOSPackageManager
        public boolean restorePackageIcon(String packageName, int userId) throws RemoteException {
            return false;
        }

        @Override // stepos.app.IStepOSPackageManager
        public boolean isSupportsHiddenIcon(String packageName) throws RemoteException {
            return false;
        }

        @Override // stepos.app.IStepOSPackageManager
        public List<ApplicationInfo> getPackageIconStates(List<String> packageNames, int userId) throws RemoteException {
            return null;
        }

        @Override // stepos.app.IStepOSPackageManager
        public List<ApplicationInfo> getSupportsHiddenIconPackages(int userId) throws RemoteException {
            return null;
        }

        @Override // stepos.app.IStepOSPackageManager
        public void setInterceptPackage(List<String> packageSet) throws RemoteException {
        }

        @Override // stepos.app.IStepOSPackageManager
        public void setKeyGuardPackage(String pkgname, boolean intercept, int level) throws RemoteException {
        }

        @Override // stepos.app.IStepOSPackageManager
        public void setkeyguardActivitylist(ComponentName component, boolean shouldClear) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IStepOSPackageManager {
        static final int TRANSACTION_appCompress = 17;
        static final int TRANSACTION_backupData = 11;
        static final int TRANSACTION_backupDataGetRecoveredSize = 6;
        static final int TRANSACTION_backupDataGetTotalSize = 7;
        static final int TRANSACTION_backupDataInterrupt = 4;
        static final int TRANSACTION_backupDataRemoveRf = 8;
        static final int TRANSACTION_backupDataReset = 5;
        static final int TRANSACTION_backupDataRestore = 3;
        static final int TRANSACTION_backupDataStaged = 2;
        static final int TRANSACTION_cancelTask = 15;
        static final int TRANSACTION_createDirectory = 20;
        static final int TRANSACTION_deleteFile = 24;
        static final int TRANSACTION_getPackageIconStates = 34;
        static final int TRANSACTION_getStartingRestrictedPackages = 25;
        static final int TRANSACTION_getStepOSAppCodePath = 27;
        static final int TRANSACTION_getSupportsHiddenIconPackages = 35;
        static final int TRANSACTION_getSwitchablePackagesForCTA = 26;
        static final int TRANSACTION_hidePackageIcon = 31;
        static final int TRANSACTION_isFileRealyExists = 22;
        static final int TRANSACTION_isForceFullForUid = 29;
        static final int TRANSACTION_isSupportsHiddenIcon = 33;
        static final int TRANSACTION_linkRepeatedFiles = 14;
        static final int TRANSACTION_linkRepeatedFilesByCow = 18;
        static final int TRANSACTION_markFileByCow = 19;
        static final int TRANSACTION_moveFile = 23;
        static final int TRANSACTION_renameFiles = 21;
        static final int TRANSACTION_restoreAndroidDataOwner = 12;
        static final int TRANSACTION_restorePackageIcon = 32;
        static final int TRANSACTION_setForceFull = 28;
        static final int TRANSACTION_setInterceptPackage = 36;
        static final int TRANSACTION_setKeyGuardPackage = 37;
        static final int TRANSACTION_setPackagesSuspendedAsUser = 30;
        static final int TRANSACTION_setkeyguardActivitylist = 38;
        static final int TRANSACTION_startCaptureLog = 9;
        static final int TRANSACTION_startScan = 13;
        static final int TRANSACTION_startScanApps = 16;
        static final int TRANSACTION_stopCaptureLog = 10;
        static final int TRANSACTION_test = 1;

        public Stub() {
            attachInterface(this, IStepOSPackageManager.DESCRIPTOR);
        }

        public static IStepOSPackageManager asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IStepOSPackageManager.DESCRIPTOR);
            if (iin != null && (iin instanceof IStepOSPackageManager)) {
                return (IStepOSPackageManager) iin;
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
                    return "backupDataStaged";
                case 3:
                    return "backupDataRestore";
                case 4:
                    return "backupDataInterrupt";
                case 5:
                    return "backupDataReset";
                case 6:
                    return "backupDataGetRecoveredSize";
                case 7:
                    return "backupDataGetTotalSize";
                case 8:
                    return "backupDataRemoveRf";
                case 9:
                    return "startCaptureLog";
                case 10:
                    return "stopCaptureLog";
                case 11:
                    return "backupData";
                case 12:
                    return "restoreAndroidDataOwner";
                case 13:
                    return "startScan";
                case 14:
                    return "linkRepeatedFiles";
                case 15:
                    return "cancelTask";
                case 16:
                    return "startScanApps";
                case 17:
                    return "appCompress";
                case 18:
                    return "linkRepeatedFilesByCow";
                case 19:
                    return "markFileByCow";
                case 20:
                    return "createDirectory";
                case 21:
                    return "renameFiles";
                case 22:
                    return "isFileRealyExists";
                case 23:
                    return "moveFile";
                case 24:
                    return "deleteFile";
                case 25:
                    return "getStartingRestrictedPackages";
                case 26:
                    return "getSwitchablePackagesForCTA";
                case 27:
                    return "getStepOSAppCodePath";
                case 28:
                    return "setForceFull";
                case 29:
                    return "isForceFullForUid";
                case 30:
                    return "setPackagesSuspendedAsUser";
                case 31:
                    return "hidePackageIcon";
                case 32:
                    return "restorePackageIcon";
                case 33:
                    return "isSupportsHiddenIcon";
                case 34:
                    return "getPackageIconStates";
                case 35:
                    return "getSupportsHiddenIconPackages";
                case 36:
                    return "setInterceptPackage";
                case 37:
                    return "setKeyGuardPackage";
                case 38:
                    return "setkeyguardActivitylist";
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
                data.enforceInterface(IStepOSPackageManager.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IStepOSPackageManager.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    test();
                    reply.writeNoException();
                    return true;
                case 2:
                    String _arg0 = data.readString();
                    String _arg1 = data.readString();
                    int _arg2 = data.readInt();
                    int _result = backupDataStaged(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case 3:
                    String _arg02 = data.readString();
                    String _arg12 = data.readString();
                    int _result2 = backupDataRestore(_arg02, _arg12);
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case 4:
                    backupDataInterrupt();
                    reply.writeNoException();
                    return true;
                case 5:
                    backupDataReset();
                    reply.writeNoException();
                    return true;
                case 6:
                    long _result3 = backupDataGetRecoveredSize();
                    reply.writeNoException();
                    reply.writeLong(_result3);
                    return true;
                case 7:
                    String _arg03 = data.readString();
                    long _result4 = backupDataGetTotalSize(_arg03);
                    reply.writeNoException();
                    reply.writeLong(_result4);
                    return true;
                case 8:
                    String _arg04 = data.readString();
                    backupDataRemoveRf(_arg04);
                    reply.writeNoException();
                    return true;
                case 9:
                    String _arg05 = data.readString();
                    startCaptureLog(_arg05);
                    reply.writeNoException();
                    return true;
                case 10:
                    stopCaptureLog();
                    reply.writeNoException();
                    return true;
                case 11:
                    String _arg06 = data.readString();
                    String _arg13 = data.readString();
                    boolean _result5 = backupData(_arg06, _arg13);
                    reply.writeNoException();
                    reply.writeBoolean(_result5);
                    return true;
                case 12:
                    String _arg07 = data.readString();
                    String _arg14 = data.readString();
                    boolean _result6 = restoreAndroidDataOwner(_arg07, _arg14);
                    reply.writeNoException();
                    reply.writeBoolean(_result6);
                    return true;
                case 13:
                    IStepOSSpaceOptListenerWrapper _arg08 = IStepOSSpaceOptListenerWrapper.Stub.asInterface(data.readStrongBinder());
                    startScan(_arg08);
                    reply.writeNoException();
                    return true;
                case 14:
                    String[] _arg09 = data.createStringArray();
                    IStepOSSpaceOptListenerWrapper _arg15 = IStepOSSpaceOptListenerWrapper.Stub.asInterface(data.readStrongBinder());
                    linkRepeatedFiles(_arg09, _arg15);
                    reply.writeNoException();
                    return true;
                case 15:
                    cancelTask();
                    reply.writeNoException();
                    return true;
                case 16:
                    String[] _arg010 = data.createStringArray();
                    int _arg16 = data.readInt();
                    IStepOSSpaceOptListenerWrapper _arg22 = IStepOSSpaceOptListenerWrapper.Stub.asInterface(data.readStrongBinder());
                    startScanApps(_arg010, _arg16, _arg22);
                    reply.writeNoException();
                    return true;
                case 17:
                    String[] _arg011 = data.createStringArray();
                    int _arg17 = data.readInt();
                    IStepOSSpaceOptListenerWrapper _arg23 = IStepOSSpaceOptListenerWrapper.Stub.asInterface(data.readStrongBinder());
                    appCompress(_arg011, _arg17, _arg23);
                    reply.writeNoException();
                    return true;
                case 18:
                    String _arg012 = data.readString();
                    String _arg18 = data.readString();
                    int _result7 = linkRepeatedFilesByCow(_arg012, _arg18);
                    reply.writeNoException();
                    reply.writeInt(_result7);
                    return true;
                case 19:
                    int _arg013 = data.readInt();
                    String _arg19 = data.readString();
                    int _result8 = markFileByCow(_arg013, _arg19);
                    reply.writeNoException();
                    reply.writeInt(_result8);
                    return true;
                case 20:
                    String _arg014 = data.readString();
                    boolean _result9 = createDirectory(_arg014);
                    reply.writeNoException();
                    reply.writeBoolean(_result9);
                    return true;
                case 21:
                    String _arg015 = data.readString();
                    String _arg110 = data.readString();
                    boolean _result10 = renameFiles(_arg015, _arg110);
                    reply.writeNoException();
                    reply.writeBoolean(_result10);
                    return true;
                case 22:
                    String _arg016 = data.readString();
                    boolean _result11 = isFileRealyExists(_arg016);
                    reply.writeNoException();
                    reply.writeBoolean(_result11);
                    return true;
                case 23:
                    String _arg017 = data.readString();
                    String _arg111 = data.readString();
                    boolean _result12 = moveFile(_arg017, _arg111);
                    reply.writeNoException();
                    reply.writeBoolean(_result12);
                    return true;
                case 24:
                    String _arg018 = data.readString();
                    boolean _result13 = deleteFile(_arg018);
                    reply.writeNoException();
                    reply.writeBoolean(_result13);
                    return true;
                case 25:
                    List<String> _result14 = getStartingRestrictedPackages();
                    reply.writeNoException();
                    reply.writeStringList(_result14);
                    return true;
                case 26:
                    List<String> _result15 = getSwitchablePackagesForCTA();
                    reply.writeNoException();
                    reply.writeStringList(_result15);
                    return true;
                case 27:
                    String _arg019 = data.readString();
                    String _result16 = getStepOSAppCodePath(_arg019);
                    reply.writeNoException();
                    reply.writeString(_result16);
                    return true;
                case 28:
                    String _arg020 = data.readString();
                    boolean _arg112 = data.readBoolean();
                    boolean _result17 = setForceFull(_arg020, _arg112);
                    reply.writeNoException();
                    reply.writeBoolean(_result17);
                    return true;
                case 29:
                    int _arg021 = data.readInt();
                    boolean _result18 = isForceFullForUid(_arg021);
                    reply.writeNoException();
                    reply.writeBoolean(_result18);
                    return true;
                case 30:
                    String[] _arg022 = data.createStringArray();
                    boolean _arg113 = data.readBoolean();
                    PersistableBundle _arg24 = (PersistableBundle) data.readTypedObject(PersistableBundle.CREATOR);
                    PersistableBundle _arg3 = (PersistableBundle) data.readTypedObject(PersistableBundle.CREATOR);
                    String _arg4 = data.readString();
                    String _arg5 = data.readString();
                    int _arg6 = data.readInt();
                    String[] _result19 = setPackagesSuspendedAsUser(_arg022, _arg113, _arg24, _arg3, _arg4, _arg5, _arg6);
                    reply.writeNoException();
                    reply.writeStringArray(_result19);
                    return true;
                case 31:
                    String _arg023 = data.readString();
                    int _arg114 = data.readInt();
                    boolean _result20 = hidePackageIcon(_arg023, _arg114);
                    reply.writeNoException();
                    reply.writeBoolean(_result20);
                    return true;
                case 32:
                    String _arg024 = data.readString();
                    int _arg115 = data.readInt();
                    boolean _result21 = restorePackageIcon(_arg024, _arg115);
                    reply.writeNoException();
                    reply.writeBoolean(_result21);
                    return true;
                case 33:
                    String _arg025 = data.readString();
                    boolean _result22 = isSupportsHiddenIcon(_arg025);
                    reply.writeNoException();
                    reply.writeBoolean(_result22);
                    return true;
                case 34:
                    List<String> _arg026 = data.createStringArrayList();
                    int _arg116 = data.readInt();
                    List<ApplicationInfo> _result23 = getPackageIconStates(_arg026, _arg116);
                    reply.writeNoException();
                    _Parcel.writeTypedList(reply, _result23, 1);
                    return true;
                case 35:
                    int _arg027 = data.readInt();
                    List<ApplicationInfo> _result24 = getSupportsHiddenIconPackages(_arg027);
                    reply.writeNoException();
                    _Parcel.writeTypedList(reply, _result24, 1);
                    return true;
                case 36:
                    List<String> _arg028 = data.createStringArrayList();
                    setInterceptPackage(_arg028);
                    reply.writeNoException();
                    return true;
                case 37:
                    String _arg029 = data.readString();
                    boolean _arg117 = data.readBoolean();
                    int _arg25 = data.readInt();
                    setKeyGuardPackage(_arg029, _arg117, _arg25);
                    reply.writeNoException();
                    return true;
                case 38:
                    ComponentName _arg030 = (ComponentName) data.readTypedObject(ComponentName.CREATOR);
                    boolean _arg118 = data.readBoolean();
                    setkeyguardActivitylist(_arg030, _arg118);
                    reply.writeNoException();
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IStepOSPackageManager {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IStepOSPackageManager.DESCRIPTOR;
            }

            @Override // stepos.app.IStepOSPackageManager
            public void test() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPackageManager.DESCRIPTOR);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSPackageManager
            public int backupDataStaged(String sourceDir, String targetDir, int singleCopyMb) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPackageManager.DESCRIPTOR);
                    _data.writeString(sourceDir);
                    _data.writeString(targetDir);
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

            @Override // stepos.app.IStepOSPackageManager
            public int backupDataRestore(String sourceDir, String targetDir) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPackageManager.DESCRIPTOR);
                    _data.writeString(sourceDir);
                    _data.writeString(targetDir);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSPackageManager
            public void backupDataInterrupt() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPackageManager.DESCRIPTOR);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSPackageManager
            public void backupDataReset() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPackageManager.DESCRIPTOR);
                    this.mRemote.transact(5, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSPackageManager
            public long backupDataGetRecoveredSize() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPackageManager.DESCRIPTOR);
                    this.mRemote.transact(6, _data, _reply, 0);
                    _reply.readException();
                    long _result = _reply.readLong();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSPackageManager
            public long backupDataGetTotalSize(String sourceDir) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPackageManager.DESCRIPTOR);
                    _data.writeString(sourceDir);
                    this.mRemote.transact(7, _data, _reply, 0);
                    _reply.readException();
                    long _result = _reply.readLong();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSPackageManager
            public void backupDataRemoveRf(String sourceDir) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPackageManager.DESCRIPTOR);
                    _data.writeString(sourceDir);
                    this.mRemote.transact(8, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSPackageManager
            public void startCaptureLog(String sourceDir) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPackageManager.DESCRIPTOR);
                    _data.writeString(sourceDir);
                    this.mRemote.transact(9, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSPackageManager
            public void stopCaptureLog() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPackageManager.DESCRIPTOR);
                    this.mRemote.transact(10, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSPackageManager
            public boolean backupData(String sourceDir, String targetDir) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPackageManager.DESCRIPTOR);
                    _data.writeString(sourceDir);
                    _data.writeString(targetDir);
                    this.mRemote.transact(11, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSPackageManager
            public boolean restoreAndroidDataOwner(String path, String packageName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPackageManager.DESCRIPTOR);
                    _data.writeString(path);
                    _data.writeString(packageName);
                    this.mRemote.transact(12, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSPackageManager
            public void startScan(IStepOSSpaceOptListenerWrapper listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPackageManager.DESCRIPTOR);
                    _data.writeStrongInterface(listener);
                    this.mRemote.transact(13, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSPackageManager
            public void linkRepeatedFiles(String[] ids, IStepOSSpaceOptListenerWrapper listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPackageManager.DESCRIPTOR);
                    _data.writeStringArray(ids);
                    _data.writeStrongInterface(listener);
                    this.mRemote.transact(14, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSPackageManager
            public void cancelTask() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPackageManager.DESCRIPTOR);
                    this.mRemote.transact(15, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSPackageManager
            public void startScanApps(String[] thirdApps, int days, IStepOSSpaceOptListenerWrapper listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPackageManager.DESCRIPTOR);
                    _data.writeStringArray(thirdApps);
                    _data.writeInt(days);
                    _data.writeStrongInterface(listener);
                    this.mRemote.transact(16, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSPackageManager
            public void appCompress(String[] apps, int days, IStepOSSpaceOptListenerWrapper listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPackageManager.DESCRIPTOR);
                    _data.writeStringArray(apps);
                    _data.writeInt(days);
                    _data.writeStrongInterface(listener);
                    this.mRemote.transact(17, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSPackageManager
            public int linkRepeatedFilesByCow(String path1, String path2) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPackageManager.DESCRIPTOR);
                    _data.writeString(path1);
                    _data.writeString(path2);
                    this.mRemote.transact(18, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSPackageManager
            public int markFileByCow(int type, String path) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPackageManager.DESCRIPTOR);
                    _data.writeInt(type);
                    _data.writeString(path);
                    this.mRemote.transact(19, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSPackageManager
            public boolean createDirectory(String path) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPackageManager.DESCRIPTOR);
                    _data.writeString(path);
                    this.mRemote.transact(20, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSPackageManager
            public boolean renameFiles(String srcPath, String targetPath) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPackageManager.DESCRIPTOR);
                    _data.writeString(srcPath);
                    _data.writeString(targetPath);
                    this.mRemote.transact(21, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSPackageManager
            public boolean isFileRealyExists(String filePath) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPackageManager.DESCRIPTOR);
                    _data.writeString(filePath);
                    this.mRemote.transact(22, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSPackageManager
            public boolean moveFile(String srcPath, String targetPath) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPackageManager.DESCRIPTOR);
                    _data.writeString(srcPath);
                    _data.writeString(targetPath);
                    this.mRemote.transact(23, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSPackageManager
            public boolean deleteFile(String filePath) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPackageManager.DESCRIPTOR);
                    _data.writeString(filePath);
                    this.mRemote.transact(24, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSPackageManager
            public List<String> getStartingRestrictedPackages() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPackageManager.DESCRIPTOR);
                    this.mRemote.transact(25, _data, _reply, 0);
                    _reply.readException();
                    List<String> _result = _reply.createStringArrayList();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSPackageManager
            public List<String> getSwitchablePackagesForCTA() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPackageManager.DESCRIPTOR);
                    this.mRemote.transact(26, _data, _reply, 0);
                    _reply.readException();
                    List<String> _result = _reply.createStringArrayList();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSPackageManager
            public String getStepOSAppCodePath(String packageName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPackageManager.DESCRIPTOR);
                    _data.writeString(packageName);
                    this.mRemote.transact(27, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSPackageManager
            public boolean setForceFull(String packageName, boolean forceFull) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPackageManager.DESCRIPTOR);
                    _data.writeString(packageName);
                    _data.writeBoolean(forceFull);
                    this.mRemote.transact(28, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSPackageManager
            public boolean isForceFullForUid(int uid) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPackageManager.DESCRIPTOR);
                    _data.writeInt(uid);
                    this.mRemote.transact(29, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSPackageManager
            public String[] setPackagesSuspendedAsUser(String[] packageNames, boolean suspended, PersistableBundle appExtras, PersistableBundle launcherExtras, String dialogMessage, String callingPackage, int userId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPackageManager.DESCRIPTOR);
                    _data.writeStringArray(packageNames);
                    _data.writeBoolean(suspended);
                    _data.writeTypedObject(appExtras, 0);
                    _data.writeTypedObject(launcherExtras, 0);
                    _data.writeString(dialogMessage);
                    _data.writeString(callingPackage);
                    _data.writeInt(userId);
                    this.mRemote.transact(30, _data, _reply, 0);
                    _reply.readException();
                    String[] _result = _reply.createStringArray();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSPackageManager
            public boolean hidePackageIcon(String packageName, int userId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPackageManager.DESCRIPTOR);
                    _data.writeString(packageName);
                    _data.writeInt(userId);
                    this.mRemote.transact(31, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSPackageManager
            public boolean restorePackageIcon(String packageName, int userId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPackageManager.DESCRIPTOR);
                    _data.writeString(packageName);
                    _data.writeInt(userId);
                    this.mRemote.transact(32, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSPackageManager
            public boolean isSupportsHiddenIcon(String packageName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPackageManager.DESCRIPTOR);
                    _data.writeString(packageName);
                    this.mRemote.transact(33, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSPackageManager
            public List<ApplicationInfo> getPackageIconStates(List<String> packageNames, int userId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPackageManager.DESCRIPTOR);
                    _data.writeStringList(packageNames);
                    _data.writeInt(userId);
                    this.mRemote.transact(34, _data, _reply, 0);
                    _reply.readException();
                    List<ApplicationInfo> _result = _reply.createTypedArrayList(ApplicationInfo.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSPackageManager
            public List<ApplicationInfo> getSupportsHiddenIconPackages(int userId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPackageManager.DESCRIPTOR);
                    _data.writeInt(userId);
                    this.mRemote.transact(35, _data, _reply, 0);
                    _reply.readException();
                    List<ApplicationInfo> _result = _reply.createTypedArrayList(ApplicationInfo.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSPackageManager
            public void setInterceptPackage(List<String> packageSet) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPackageManager.DESCRIPTOR);
                    _data.writeStringList(packageSet);
                    this.mRemote.transact(36, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSPackageManager
            public void setKeyGuardPackage(String pkgname, boolean intercept, int level) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPackageManager.DESCRIPTOR);
                    _data.writeString(pkgname);
                    _data.writeBoolean(intercept);
                    _data.writeInt(level);
                    this.mRemote.transact(37, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSPackageManager
            public void setkeyguardActivitylist(ComponentName component, boolean shouldClear) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPackageManager.DESCRIPTOR);
                    _data.writeTypedObject(component, 0);
                    _data.writeBoolean(shouldClear);
                    this.mRemote.transact(38, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 37;
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
