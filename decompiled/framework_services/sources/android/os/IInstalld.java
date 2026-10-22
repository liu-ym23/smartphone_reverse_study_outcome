package android.os;

import android.os.storage.CrateMetadata;

/* JADX INFO: loaded from: classes.dex */
public interface IInstalld extends IInterface {
    public static final int FLAG_CLEAR_APP_DATA_KEEP_ART_PROFILES = 131072;
    public static final int FLAG_CLEAR_CACHE_ONLY = 16;
    public static final int FLAG_CLEAR_CODE_CACHE_ONLY = 32;
    public static final int FLAG_FORCE = 8192;
    public static final int FLAG_FREE_CACHE_DEFY_TARGET_FREE_BYTES = 2048;
    public static final int FLAG_FREE_CACHE_NOOP = 1024;
    public static final int FLAG_FREE_CACHE_V2 = 256;
    public static final int FLAG_FREE_CACHE_V2_DEFY_QUOTA = 512;
    public static final int FLAG_STORAGE_CE = 2;
    public static final int FLAG_STORAGE_DE = 1;
    public static final int FLAG_STORAGE_EXTERNAL = 4;
    public static final int FLAG_STORAGE_SDK = 8;
    public static final int FLAG_USE_QUOTA = 4096;

    public static class Default implements IInstalld {
        public Default() {
        }

        @Override // android.os.IInstalld
        public void createUserData(String uuid, int userId, int userSerial, int flags) throws RemoteException {
        }

        @Override // android.os.IInstalld
        public void destroyUserData(String uuid, int userId, int flags) throws RemoteException {
        }

        @Override // android.os.IInstalld
        public void setFirstBoot() throws RemoteException {
        }

        @Override // android.os.IInstalld
        public CreateAppDataResult createAppData(CreateAppDataArgs args) throws RemoteException {
            return null;
        }

        @Override // android.os.IInstalld
        public CreateAppDataResult[] createAppDataBatched(CreateAppDataArgs[] args) throws RemoteException {
            return null;
        }

        @Override // android.os.IInstalld
        public void reconcileSdkData(ReconcileSdkDataArgs args) throws RemoteException {
        }

        @Override // android.os.IInstalld
        public void restoreconAppData(String uuid, String packageName, int userId, int flags, int appId, String seInfo) throws RemoteException {
        }

        @Override // android.os.IInstalld
        public void migrateAppData(String uuid, String packageName, int userId, int flags) throws RemoteException {
        }

        @Override // android.os.IInstalld
        public void clearAppData(String uuid, String packageName, int userId, int flags, long ceDataInode) throws RemoteException {
        }

        @Override // android.os.IInstalld
        public void destroyAppData(String uuid, String packageName, int userId, int flags, long ceDataInode) throws RemoteException {
        }

        @Override // android.os.IInstalld
        public void fixupAppData(String uuid, int flags) throws RemoteException {
        }

        @Override // android.os.IInstalld
        public long[] getAppSize(String uuid, String[] packageNames, int userId, int flags, int appId, long[] ceDataInodes, String[] codePaths) throws RemoteException {
            return null;
        }

        @Override // android.os.IInstalld
        public long[] getUserSize(String uuid, int userId, int flags, int[] appIds) throws RemoteException {
            return null;
        }

        @Override // android.os.IInstalld
        public long[] getExternalSize(String uuid, int userId, int flags, int[] appIds) throws RemoteException {
            return null;
        }

        @Override // android.os.IInstalld
        public CrateMetadata[] getAppCrates(String uuid, String[] packageNames, int userId) throws RemoteException {
            return null;
        }

        @Override // android.os.IInstalld
        public CrateMetadata[] getUserCrates(String uuid, int userId) throws RemoteException {
            return null;
        }

        @Override // android.os.IInstalld
        public void setAppQuota(String uuid, int userId, int appId, long cacheQuota) throws RemoteException {
        }

        @Override // android.os.IInstalld
        public void moveCompleteApp(String fromUuid, String toUuid, String packageName, int appId, String seInfo, int targetSdkVersion, String fromCodePath) throws RemoteException {
        }

        @Override // android.os.IInstalld
        public boolean dexopt(String apkPath, int uid, String packageName, String instructionSet, int dexoptNeeded, String outputPath, int dexFlags, String compilerFilter, String uuid, String sharedLibraries, String seInfo, boolean downgrade, int targetSdkVersion, String profileName, String dexMetadataPath, String compilationReason) throws RemoteException {
            return false;
        }

        @Override // android.os.IInstalld
        public void controlDexOptBlocking(boolean block) throws RemoteException {
        }

        @Override // android.os.IInstalld
        public void rmdex(String codePath, String instructionSet) throws RemoteException {
        }

        @Override // android.os.IInstalld
        public int mergeProfiles(int uid, String packageName, String profileName) throws RemoteException {
            return 0;
        }

        @Override // android.os.IInstalld
        public boolean dumpProfiles(int uid, String packageName, String profileName, String codePath, boolean dumpClassesAndMethods) throws RemoteException {
            return false;
        }

        @Override // android.os.IInstalld
        public boolean copySystemProfile(String systemProfile, int uid, String packageName, String profileName) throws RemoteException {
            return false;
        }

        @Override // android.os.IInstalld
        public void clearAppProfiles(String packageName, String profileName) throws RemoteException {
        }

        @Override // android.os.IInstalld
        public void destroyAppProfiles(String packageName) throws RemoteException {
        }

        @Override // android.os.IInstalld
        public void deleteReferenceProfile(String packageName, String profileName) throws RemoteException {
        }

        @Override // android.os.IInstalld
        public boolean createProfileSnapshot(int appId, String packageName, String profileName, String classpath) throws RemoteException {
            return false;
        }

        @Override // android.os.IInstalld
        public void destroyProfileSnapshot(String packageName, String profileName) throws RemoteException {
        }

        @Override // android.os.IInstalld
        public void rmPackageDir(String packageName, String packageDir) throws RemoteException {
        }

        @Override // android.os.IInstalld
        public void freeCache(String uuid, long targetFreeBytes, int flags) throws RemoteException {
        }

        @Override // android.os.IInstalld
        public void linkNativeLibraryDirectory(String uuid, String packageName, String nativeLibPath32, int userId) throws RemoteException {
        }

        @Override // android.os.IInstalld
        public void createOatDir(String packageName, String oatDir, String instructionSet) throws RemoteException {
        }

        @Override // android.os.IInstalld
        public void linkFile(String packageName, String relativePath, String fromBase, String toBase) throws RemoteException {
        }

        @Override // android.os.IInstalld
        public void moveAb(String packageName, String apkPath, String instructionSet, String outputPath) throws RemoteException {
        }

        @Override // android.os.IInstalld
        public long deleteOdex(String packageName, String apkPath, String instructionSet, String outputPath) throws RemoteException {
            return 0;
        }

        @Override // android.os.IInstalld
        public boolean reconcileSecondaryDexFile(String dexPath, String pkgName, int uid, String[] isas, String volume_uuid, int storage_flag) throws RemoteException {
            return false;
        }

        @Override // android.os.IInstalld
        public byte[] hashSecondaryDexFile(String dexPath, String pkgName, int uid, String volumeUuid, int storageFlag) throws RemoteException {
            return null;
        }

        @Override // android.os.IInstalld
        public void invalidateMounts() throws RemoteException {
        }

        @Override // android.os.IInstalld
        public boolean isQuotaSupported(String uuid) throws RemoteException {
            return false;
        }

        @Override // android.os.IInstalld
        public boolean prepareAppProfile(String packageName, int userId, int appId, String profileName, String codePath, String dexMetadata) throws RemoteException {
            return false;
        }

        @Override // android.os.IInstalld
        public long snapshotAppData(String uuid, String packageName, int userId, int snapshotId, int storageFlags) throws RemoteException {
            return 0;
        }

        @Override // android.os.IInstalld
        public void restoreAppDataSnapshot(String uuid, String packageName, int appId, String seInfo, int user, int snapshotId, int storageflags) throws RemoteException {
        }

        @Override // android.os.IInstalld
        public void destroyAppDataSnapshot(String uuid, String packageName, int userId, long ceSnapshotInode, int snapshotId, int storageFlags) throws RemoteException {
        }

        @Override // android.os.IInstalld
        public void destroyCeSnapshotsNotSpecified(String uuid, int userId, int[] retainSnapshotIds) throws RemoteException {
        }

        @Override // android.os.IInstalld
        public int do6939Service(String[] cmdAndArgs) throws RemoteException {
            return 0;
        }

        @Override // android.os.IInstalld
        public String getPackageFilesInfo(String packageName) throws RemoteException {
            return null;
        }

        @Override // android.os.IInstalld
        public void preLoadAppData(int uid, int startType, String component, int launchedFromPid, int launchedFromUid) throws RemoteException {
        }

        @Override // android.os.IInstalld
        public void tryMountDataMirror(String volumeUuid) throws RemoteException {
        }

        @Override // android.os.IInstalld
        public void onPrivateVolumeRemoved(String volumeUuid) throws RemoteException {
        }

        @Override // android.os.IInstalld
        public void migrateLegacyObbData() throws RemoteException {
        }

        @Override // android.os.IInstalld
        public void cleanupInvalidPackageDirs(String uuid, int userId, int flags) throws RemoteException {
        }

        @Override // android.os.IInstalld
        public int getOdexVisibility(String packageName, String apkPath, String instructionSet, String outputPath) throws RemoteException {
            return 0;
        }

        @Override // android.os.IInstalld
        public IFsveritySetupAuthToken createFsveritySetupAuthToken(ParcelFileDescriptor authFd, int uid) throws RemoteException {
            return null;
        }

        @Override // android.os.IInstalld
        public int enableFsverity(IFsveritySetupAuthToken authToken, String filePath, String packageName) throws RemoteException {
            return 0;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public interface IFsveritySetupAuthToken extends IInterface {
        public static final String DESCRIPTOR = "android.os.IInstalld.IFsveritySetupAuthToken";

        public static class Default implements IFsveritySetupAuthToken {
            public Default() {
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return null;
            }
        }

        public static abstract class Stub extends Binder implements IFsveritySetupAuthToken {

            private static class Proxy implements IFsveritySetupAuthToken {
                private IBinder mRemote;

                Proxy(IBinder remote) {
                    this.mRemote = remote;
                }

                @Override // android.os.IInterface
                public IBinder asBinder() {
                    return this.mRemote;
                }

                public String getInterfaceDescriptor() {
                    return IFsveritySetupAuthToken.DESCRIPTOR;
                }
            }

            public Stub() {
                attachInterface(this, IFsveritySetupAuthToken.DESCRIPTOR);
            }

            public static IFsveritySetupAuthToken asInterface(IBinder obj) {
                if (obj != null) goto L5;
                return null;
            L5:
                IInterface iin = obj.queryLocalInterface(IFsveritySetupAuthToken.DESCRIPTOR);
                if (iin == null) goto L12;
                if ((iin instanceof IFsveritySetupAuthToken) == false) goto L12;
                return (IFsveritySetupAuthToken) iin;
            L12:
                return new Proxy(obj);
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this;
            }

            @Override // android.os.Binder
            public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
                if (code != 1598968902) goto L7;
                reply.writeString(IFsveritySetupAuthToken.DESCRIPTOR);
                return true;
            L7:
                return super.onTransact(code, data, reply, flags);
            }
        }
    }

    public static abstract class Stub extends Binder implements IInstalld {
        public static final String DESCRIPTOR = "android.os.IInstalld";
        static final int TRANSACTION_cleanupInvalidPackageDirs = 52;
        static final int TRANSACTION_clearAppData = 9;
        static final int TRANSACTION_clearAppProfiles = 25;
        static final int TRANSACTION_controlDexOptBlocking = 20;
        static final int TRANSACTION_copySystemProfile = 24;
        static final int TRANSACTION_createAppData = 4;
        static final int TRANSACTION_createAppDataBatched = 5;
        static final int TRANSACTION_createFsveritySetupAuthToken = 54;
        static final int TRANSACTION_createOatDir = 33;
        static final int TRANSACTION_createProfileSnapshot = 28;
        static final int TRANSACTION_createUserData = 1;
        static final int TRANSACTION_deleteOdex = 36;
        static final int TRANSACTION_deleteReferenceProfile = 27;
        static final int TRANSACTION_destroyAppData = 10;
        static final int TRANSACTION_destroyAppDataSnapshot = 44;
        static final int TRANSACTION_destroyAppProfiles = 26;
        static final int TRANSACTION_destroyCeSnapshotsNotSpecified = 45;
        static final int TRANSACTION_destroyProfileSnapshot = 29;
        static final int TRANSACTION_destroyUserData = 2;
        static final int TRANSACTION_dexopt = 19;
        static final int TRANSACTION_do6939Service = 46;
        static final int TRANSACTION_dumpProfiles = 23;
        static final int TRANSACTION_enableFsverity = 55;
        static final int TRANSACTION_fixupAppData = 11;
        static final int TRANSACTION_freeCache = 31;
        static final int TRANSACTION_getAppCrates = 15;
        static final int TRANSACTION_getAppSize = 12;
        static final int TRANSACTION_getExternalSize = 14;
        static final int TRANSACTION_getOdexVisibility = 53;
        static final int TRANSACTION_getPackageFilesInfo = 47;
        static final int TRANSACTION_getUserCrates = 16;
        static final int TRANSACTION_getUserSize = 13;
        static final int TRANSACTION_hashSecondaryDexFile = 38;
        static final int TRANSACTION_invalidateMounts = 39;
        static final int TRANSACTION_isQuotaSupported = 40;
        static final int TRANSACTION_linkFile = 34;
        static final int TRANSACTION_linkNativeLibraryDirectory = 32;
        static final int TRANSACTION_mergeProfiles = 22;
        static final int TRANSACTION_migrateAppData = 8;
        static final int TRANSACTION_migrateLegacyObbData = 51;
        static final int TRANSACTION_moveAb = 35;
        static final int TRANSACTION_moveCompleteApp = 18;
        static final int TRANSACTION_onPrivateVolumeRemoved = 50;
        static final int TRANSACTION_preLoadAppData = 48;
        static final int TRANSACTION_prepareAppProfile = 41;
        static final int TRANSACTION_reconcileSdkData = 6;
        static final int TRANSACTION_reconcileSecondaryDexFile = 37;
        static final int TRANSACTION_restoreAppDataSnapshot = 43;
        static final int TRANSACTION_restoreconAppData = 7;
        static final int TRANSACTION_rmPackageDir = 30;
        static final int TRANSACTION_rmdex = 21;
        static final int TRANSACTION_setAppQuota = 17;
        static final int TRANSACTION_setFirstBoot = 3;
        static final int TRANSACTION_snapshotAppData = 42;
        static final int TRANSACTION_tryMountDataMirror = 49;

        private static class Proxy implements IInstalld {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // android.os.IInstalld
            public void createUserData(String uuid, int userId, int userSerial, int flags) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(uuid);     // Catch: Throwable -> L6
                _data.writeInt(userId);     // Catch: Throwable -> L6
                _data.writeInt(userSerial);     // Catch: Throwable -> L6
                _data.writeInt(flags);     // Catch: Throwable -> L6
                this.mRemote.transact(1, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public void destroyUserData(String uuid, int userId, int flags) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(uuid);     // Catch: Throwable -> L6
                _data.writeInt(userId);     // Catch: Throwable -> L6
                _data.writeInt(flags);     // Catch: Throwable -> L6
                this.mRemote.transact(2, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public void setFirstBoot() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(3, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public CreateAppDataResult createAppData(CreateAppDataArgs args) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeTypedObject(args, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(4, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                CreateAppDataResult _result = (CreateAppDataResult) _reply.readTypedObject(CreateAppDataResult.CREATOR);     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public CreateAppDataResult[] createAppDataBatched(CreateAppDataArgs[] args) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeTypedArray(args, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(5, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                CreateAppDataResult[] _result = (CreateAppDataResult[]) _reply.createTypedArray(CreateAppDataResult.CREATOR);     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public void reconcileSdkData(ReconcileSdkDataArgs args) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeTypedObject(args, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(6, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public void restoreconAppData(String uuid, String packageName, int userId, int flags, int appId, String seInfo) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(uuid);     // Catch: Throwable -> L6
                _data.writeString(packageName);     // Catch: Throwable -> L6
                _data.writeInt(userId);     // Catch: Throwable -> L6
                _data.writeInt(flags);     // Catch: Throwable -> L6
                _data.writeInt(appId);     // Catch: Throwable -> L6
                _data.writeString(seInfo);     // Catch: Throwable -> L6
                this.mRemote.transact(7, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public void migrateAppData(String uuid, String packageName, int userId, int flags) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(uuid);     // Catch: Throwable -> L6
                _data.writeString(packageName);     // Catch: Throwable -> L6
                _data.writeInt(userId);     // Catch: Throwable -> L6
                _data.writeInt(flags);     // Catch: Throwable -> L6
                this.mRemote.transact(8, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public void clearAppData(String uuid, String packageName, int userId, int flags, long ceDataInode) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(uuid);     // Catch: Throwable -> L6
                _data.writeString(packageName);     // Catch: Throwable -> L6
                _data.writeInt(userId);     // Catch: Throwable -> L6
                _data.writeInt(flags);     // Catch: Throwable -> L6
                _data.writeLong(ceDataInode);     // Catch: Throwable -> L6
                this.mRemote.transact(9, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public void destroyAppData(String uuid, String packageName, int userId, int flags, long ceDataInode) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(uuid);     // Catch: Throwable -> L6
                _data.writeString(packageName);     // Catch: Throwable -> L6
                _data.writeInt(userId);     // Catch: Throwable -> L6
                _data.writeInt(flags);     // Catch: Throwable -> L6
                _data.writeLong(ceDataInode);     // Catch: Throwable -> L6
                this.mRemote.transact(10, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public void fixupAppData(String uuid, int flags) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(uuid);     // Catch: Throwable -> L6
                _data.writeInt(flags);     // Catch: Throwable -> L6
                this.mRemote.transact(11, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public long[] getAppSize(String uuid, String[] packageNames, int userId, int flags, int appId, long[] ceDataInodes, String[] codePaths) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(uuid);     // Catch: Throwable -> L6
                _data.writeStringArray(packageNames);     // Catch: Throwable -> L6
                _data.writeInt(userId);     // Catch: Throwable -> L6
                _data.writeInt(flags);     // Catch: Throwable -> L6
                _data.writeInt(appId);     // Catch: Throwable -> L6
                _data.writeLongArray(ceDataInodes);     // Catch: Throwable -> L6
                _data.writeStringArray(codePaths);     // Catch: Throwable -> L6
                this.mRemote.transact(12, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                long[] _result = _reply.createLongArray();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public long[] getUserSize(String uuid, int userId, int flags, int[] appIds) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(uuid);     // Catch: Throwable -> L6
                _data.writeInt(userId);     // Catch: Throwable -> L6
                _data.writeInt(flags);     // Catch: Throwable -> L6
                _data.writeIntArray(appIds);     // Catch: Throwable -> L6
                this.mRemote.transact(13, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                long[] _result = _reply.createLongArray();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public long[] getExternalSize(String uuid, int userId, int flags, int[] appIds) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(uuid);     // Catch: Throwable -> L6
                _data.writeInt(userId);     // Catch: Throwable -> L6
                _data.writeInt(flags);     // Catch: Throwable -> L6
                _data.writeIntArray(appIds);     // Catch: Throwable -> L6
                this.mRemote.transact(14, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                long[] _result = _reply.createLongArray();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public CrateMetadata[] getAppCrates(String uuid, String[] packageNames, int userId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(uuid);     // Catch: Throwable -> L6
                _data.writeStringArray(packageNames);     // Catch: Throwable -> L6
                _data.writeInt(userId);     // Catch: Throwable -> L6
                this.mRemote.transact(15, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                CrateMetadata[] _result = (CrateMetadata[]) _reply.createTypedArray(CrateMetadata.CREATOR);     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public CrateMetadata[] getUserCrates(String uuid, int userId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(uuid);     // Catch: Throwable -> L6
                _data.writeInt(userId);     // Catch: Throwable -> L6
                this.mRemote.transact(16, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                CrateMetadata[] _result = (CrateMetadata[]) _reply.createTypedArray(CrateMetadata.CREATOR);     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public void setAppQuota(String uuid, int userId, int appId, long cacheQuota) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(uuid);     // Catch: Throwable -> L6
                _data.writeInt(userId);     // Catch: Throwable -> L6
                _data.writeInt(appId);     // Catch: Throwable -> L6
                _data.writeLong(cacheQuota);     // Catch: Throwable -> L6
                this.mRemote.transact(17, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public void moveCompleteApp(String fromUuid, String toUuid, String packageName, int appId, String seInfo, int targetSdkVersion, String fromCodePath) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(fromUuid);     // Catch: Throwable -> L6
                _data.writeString(toUuid);     // Catch: Throwable -> L6
                _data.writeString(packageName);     // Catch: Throwable -> L6
                _data.writeInt(appId);     // Catch: Throwable -> L6
                _data.writeString(seInfo);     // Catch: Throwable -> L6
                _data.writeInt(targetSdkVersion);     // Catch: Throwable -> L6
                _data.writeString(fromCodePath);     // Catch: Throwable -> L6
                this.mRemote.transact(18, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public boolean dexopt(String apkPath, int uid, String packageName, String instructionSet, int dexoptNeeded, String outputPath, int dexFlags, String compilerFilter, String uuid, String sharedLibraries, String seInfo, boolean downgrade, int targetSdkVersion, String profileName, String dexMetadataPath, String compilationReason) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L50
                _data.writeString(apkPath);     // Catch: Throwable -> L50
                _data.writeInt(uid);     // Catch: Throwable -> L50
                _data.writeString(packageName);     // Catch: Throwable -> L48
                _data.writeString(instructionSet);     // Catch: Throwable -> L46
                _data.writeInt(dexoptNeeded);     // Catch: Throwable -> L44
                _data.writeString(outputPath);     // Catch: Throwable -> L42
                _data.writeInt(dexFlags);     // Catch: Throwable -> L40
                _data.writeString(compilerFilter);     // Catch: Throwable -> L38
                _data.writeString(uuid);     // Catch: Throwable -> L36
                _data.writeString(sharedLibraries);     // Catch: Throwable -> L34
                _data.writeString(seInfo);     // Catch: Throwable -> L32
                _data.writeBoolean(downgrade);     // Catch: Throwable -> L30
                _data.writeInt(targetSdkVersion);     // Catch: Throwable -> L28
                _data.writeString(profileName);     // Catch: Throwable -> L28
                _data.writeString(dexMetadataPath);     // Catch: Throwable -> L28
                _data.writeString(compilationReason);     // Catch: Throwable -> L28
                this.mRemote.transact(19, _data, _reply, 0);     // Catch: Throwable -> L28
                _reply.readException();     // Catch: Throwable -> L28
                boolean _result = _reply.readBoolean();     // Catch: Throwable -> L28
                _reply.recycle();
                _data.recycle();
                return _result;
            L28:
                th = th;
            L52:
                _reply.recycle();
                _data.recycle();
                throw th;
            L30:
                th = th;
            L32:
                th = th;
            L34:
                th = th;
            L36:
                th = th;
            L38:
                th = th;
            L40:
                th = th;
            L42:
                th = th;
            L44:
                th = th;
            L46:
                th = th;
            L48:
                th = th;
            L50:
                th = th;
                goto L52
            }

            @Override // android.os.IInstalld
            public void controlDexOptBlocking(boolean block) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeBoolean(block);     // Catch: Throwable -> L6
                this.mRemote.transact(20, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public void rmdex(String codePath, String instructionSet) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(codePath);     // Catch: Throwable -> L6
                _data.writeString(instructionSet);     // Catch: Throwable -> L6
                this.mRemote.transact(21, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public int mergeProfiles(int uid, String packageName, String profileName) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(uid);     // Catch: Throwable -> L6
                _data.writeString(packageName);     // Catch: Throwable -> L6
                _data.writeString(profileName);     // Catch: Throwable -> L6
                this.mRemote.transact(22, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                int _result = _reply.readInt();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public boolean dumpProfiles(int uid, String packageName, String profileName, String codePath, boolean dumpClassesAndMethods) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(uid);     // Catch: Throwable -> L6
                _data.writeString(packageName);     // Catch: Throwable -> L6
                _data.writeString(profileName);     // Catch: Throwable -> L6
                _data.writeString(codePath);     // Catch: Throwable -> L6
                _data.writeBoolean(dumpClassesAndMethods);     // Catch: Throwable -> L6
                this.mRemote.transact(23, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                boolean _result = _reply.readBoolean();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public boolean copySystemProfile(String systemProfile, int uid, String packageName, String profileName) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(systemProfile);     // Catch: Throwable -> L6
                _data.writeInt(uid);     // Catch: Throwable -> L6
                _data.writeString(packageName);     // Catch: Throwable -> L6
                _data.writeString(profileName);     // Catch: Throwable -> L6
                this.mRemote.transact(24, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                boolean _result = _reply.readBoolean();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public void clearAppProfiles(String packageName, String profileName) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(packageName);     // Catch: Throwable -> L6
                _data.writeString(profileName);     // Catch: Throwable -> L6
                this.mRemote.transact(25, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public void destroyAppProfiles(String packageName) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(packageName);     // Catch: Throwable -> L6
                this.mRemote.transact(26, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public void deleteReferenceProfile(String packageName, String profileName) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(packageName);     // Catch: Throwable -> L6
                _data.writeString(profileName);     // Catch: Throwable -> L6
                this.mRemote.transact(27, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public boolean createProfileSnapshot(int appId, String packageName, String profileName, String classpath) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(appId);     // Catch: Throwable -> L6
                _data.writeString(packageName);     // Catch: Throwable -> L6
                _data.writeString(profileName);     // Catch: Throwable -> L6
                _data.writeString(classpath);     // Catch: Throwable -> L6
                this.mRemote.transact(28, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                boolean _result = _reply.readBoolean();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public void destroyProfileSnapshot(String packageName, String profileName) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(packageName);     // Catch: Throwable -> L6
                _data.writeString(profileName);     // Catch: Throwable -> L6
                this.mRemote.transact(29, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public void rmPackageDir(String packageName, String packageDir) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(packageName);     // Catch: Throwable -> L6
                _data.writeString(packageDir);     // Catch: Throwable -> L6
                this.mRemote.transact(30, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public void freeCache(String uuid, long targetFreeBytes, int flags) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(uuid);     // Catch: Throwable -> L6
                _data.writeLong(targetFreeBytes);     // Catch: Throwable -> L6
                _data.writeInt(flags);     // Catch: Throwable -> L6
                this.mRemote.transact(31, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public void linkNativeLibraryDirectory(String uuid, String packageName, String nativeLibPath32, int userId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(uuid);     // Catch: Throwable -> L6
                _data.writeString(packageName);     // Catch: Throwable -> L6
                _data.writeString(nativeLibPath32);     // Catch: Throwable -> L6
                _data.writeInt(userId);     // Catch: Throwable -> L6
                this.mRemote.transact(32, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public void createOatDir(String packageName, String oatDir, String instructionSet) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(packageName);     // Catch: Throwable -> L6
                _data.writeString(oatDir);     // Catch: Throwable -> L6
                _data.writeString(instructionSet);     // Catch: Throwable -> L6
                this.mRemote.transact(33, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public void linkFile(String packageName, String relativePath, String fromBase, String toBase) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(packageName);     // Catch: Throwable -> L6
                _data.writeString(relativePath);     // Catch: Throwable -> L6
                _data.writeString(fromBase);     // Catch: Throwable -> L6
                _data.writeString(toBase);     // Catch: Throwable -> L6
                this.mRemote.transact(34, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public void moveAb(String packageName, String apkPath, String instructionSet, String outputPath) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(packageName);     // Catch: Throwable -> L6
                _data.writeString(apkPath);     // Catch: Throwable -> L6
                _data.writeString(instructionSet);     // Catch: Throwable -> L6
                _data.writeString(outputPath);     // Catch: Throwable -> L6
                this.mRemote.transact(35, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public long deleteOdex(String packageName, String apkPath, String instructionSet, String outputPath) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(packageName);     // Catch: Throwable -> L6
                _data.writeString(apkPath);     // Catch: Throwable -> L6
                _data.writeString(instructionSet);     // Catch: Throwable -> L6
                _data.writeString(outputPath);     // Catch: Throwable -> L6
                this.mRemote.transact(36, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                long _result = _reply.readLong();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public boolean reconcileSecondaryDexFile(String dexPath, String pkgName, int uid, String[] isas, String volume_uuid, int storage_flag) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(dexPath);     // Catch: Throwable -> L6
                _data.writeString(pkgName);     // Catch: Throwable -> L6
                _data.writeInt(uid);     // Catch: Throwable -> L6
                _data.writeStringArray(isas);     // Catch: Throwable -> L6
                _data.writeString(volume_uuid);     // Catch: Throwable -> L6
                _data.writeInt(storage_flag);     // Catch: Throwable -> L6
                this.mRemote.transact(37, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                boolean _result = _reply.readBoolean();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public byte[] hashSecondaryDexFile(String dexPath, String pkgName, int uid, String volumeUuid, int storageFlag) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(dexPath);     // Catch: Throwable -> L6
                _data.writeString(pkgName);     // Catch: Throwable -> L6
                _data.writeInt(uid);     // Catch: Throwable -> L6
                _data.writeString(volumeUuid);     // Catch: Throwable -> L6
                _data.writeInt(storageFlag);     // Catch: Throwable -> L6
                this.mRemote.transact(38, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                byte[] _result = _reply.createByteArray();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public void invalidateMounts() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(39, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public boolean isQuotaSupported(String uuid) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(uuid);     // Catch: Throwable -> L6
                this.mRemote.transact(40, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                boolean _result = _reply.readBoolean();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public boolean prepareAppProfile(String packageName, int userId, int appId, String profileName, String codePath, String dexMetadata) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(packageName);     // Catch: Throwable -> L6
                _data.writeInt(userId);     // Catch: Throwable -> L6
                _data.writeInt(appId);     // Catch: Throwable -> L6
                _data.writeString(profileName);     // Catch: Throwable -> L6
                _data.writeString(codePath);     // Catch: Throwable -> L6
                _data.writeString(dexMetadata);     // Catch: Throwable -> L6
                this.mRemote.transact(41, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                boolean _result = _reply.readBoolean();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public long snapshotAppData(String uuid, String packageName, int userId, int snapshotId, int storageFlags) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(uuid);     // Catch: Throwable -> L6
                _data.writeString(packageName);     // Catch: Throwable -> L6
                _data.writeInt(userId);     // Catch: Throwable -> L6
                _data.writeInt(snapshotId);     // Catch: Throwable -> L6
                _data.writeInt(storageFlags);     // Catch: Throwable -> L6
                this.mRemote.transact(42, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                long _result = _reply.readLong();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public void restoreAppDataSnapshot(String uuid, String packageName, int appId, String seInfo, int user, int snapshotId, int storageflags) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(uuid);     // Catch: Throwable -> L6
                _data.writeString(packageName);     // Catch: Throwable -> L6
                _data.writeInt(appId);     // Catch: Throwable -> L6
                _data.writeString(seInfo);     // Catch: Throwable -> L6
                _data.writeInt(user);     // Catch: Throwable -> L6
                _data.writeInt(snapshotId);     // Catch: Throwable -> L6
                _data.writeInt(storageflags);     // Catch: Throwable -> L6
                this.mRemote.transact(43, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public void destroyAppDataSnapshot(String uuid, String packageName, int userId, long ceSnapshotInode, int snapshotId, int storageFlags) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(uuid);     // Catch: Throwable -> L6
                _data.writeString(packageName);     // Catch: Throwable -> L6
                _data.writeInt(userId);     // Catch: Throwable -> L6
                _data.writeLong(ceSnapshotInode);     // Catch: Throwable -> L6
                _data.writeInt(snapshotId);     // Catch: Throwable -> L6
                _data.writeInt(storageFlags);     // Catch: Throwable -> L6
                this.mRemote.transact(44, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public void destroyCeSnapshotsNotSpecified(String uuid, int userId, int[] retainSnapshotIds) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(uuid);     // Catch: Throwable -> L6
                _data.writeInt(userId);     // Catch: Throwable -> L6
                _data.writeIntArray(retainSnapshotIds);     // Catch: Throwable -> L6
                this.mRemote.transact(45, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public int do6939Service(String[] cmdAndArgs) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeStringArray(cmdAndArgs);     // Catch: Throwable -> L6
                this.mRemote.transact(46, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                int _result = _reply.readInt();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public String getPackageFilesInfo(String packageName) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(packageName);     // Catch: Throwable -> L6
                this.mRemote.transact(47, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                String _result = _reply.readString();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public void preLoadAppData(int uid, int startType, String component, int launchedFromPid, int launchedFromUid) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(uid);     // Catch: Throwable -> L6
                _data.writeInt(startType);     // Catch: Throwable -> L6
                _data.writeString(component);     // Catch: Throwable -> L6
                _data.writeInt(launchedFromPid);     // Catch: Throwable -> L6
                _data.writeInt(launchedFromUid);     // Catch: Throwable -> L6
                this.mRemote.transact(48, _data, null, 1);     // Catch: Throwable -> L6
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public void tryMountDataMirror(String volumeUuid) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(volumeUuid);     // Catch: Throwable -> L6
                this.mRemote.transact(49, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public void onPrivateVolumeRemoved(String volumeUuid) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(volumeUuid);     // Catch: Throwable -> L6
                this.mRemote.transact(50, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public void migrateLegacyObbData() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(51, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public void cleanupInvalidPackageDirs(String uuid, int userId, int flags) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(uuid);     // Catch: Throwable -> L6
                _data.writeInt(userId);     // Catch: Throwable -> L6
                _data.writeInt(flags);     // Catch: Throwable -> L6
                this.mRemote.transact(52, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public int getOdexVisibility(String packageName, String apkPath, String instructionSet, String outputPath) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(packageName);     // Catch: Throwable -> L6
                _data.writeString(apkPath);     // Catch: Throwable -> L6
                _data.writeString(instructionSet);     // Catch: Throwable -> L6
                _data.writeString(outputPath);     // Catch: Throwable -> L6
                this.mRemote.transact(53, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                int _result = _reply.readInt();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public IFsveritySetupAuthToken createFsveritySetupAuthToken(ParcelFileDescriptor authFd, int uid) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeTypedObject(authFd, 0);     // Catch: Throwable -> L6
                _data.writeInt(uid);     // Catch: Throwable -> L6
                this.mRemote.transact(54, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                IFsveritySetupAuthToken _result = IFsveritySetupAuthToken.Stub.asInterface(_reply.readStrongBinder());     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IInstalld
            public int enableFsverity(IFsveritySetupAuthToken authToken, String filePath, String packageName) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeStrongInterface(authToken);     // Catch: Throwable -> L6
                _data.writeString(filePath);     // Catch: Throwable -> L6
                _data.writeString(packageName);     // Catch: Throwable -> L6
                this.mRemote.transact(55, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                int _result = _reply.readInt();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IInstalld asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IInstalld) == false) goto L12;
            return (IInstalld) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code < 1) goto L8;
            if (code > 16777215) goto L8;
            data.enforceInterface(DESCRIPTOR);
        L8:
            if (code != 1598968902) goto L11;
            reply.writeString(DESCRIPTOR);
            return true;
        L11:
            switch(code) {
                case 1: goto L68;
                case 2: goto L67;
                case 3: goto L66;
                case 4: goto L65;
                case 5: goto L64;
                case 6: goto L63;
                case 7: goto L62;
                case 8: goto L61;
                case 9: goto L60;
                case 10: goto L59;
                case 11: goto L58;
                case 12: goto L57;
                case 13: goto L56;
                case 14: goto L55;
                case 15: goto L54;
                case 16: goto L53;
                case 17: goto L52;
                case 18: goto L51;
                case 19: goto L50;
                case 20: goto L49;
                case 21: goto L48;
                case 22: goto L47;
                case 23: goto L46;
                case 24: goto L45;
                case 25: goto L44;
                case 26: goto L43;
                case 27: goto L42;
                case 28: goto L41;
                case 29: goto L40;
                case 30: goto L39;
                case 31: goto L38;
                case 32: goto L37;
                case 33: goto L36;
                case 34: goto L35;
                case 35: goto L34;
                case 36: goto L33;
                case 37: goto L32;
                case 38: goto L31;
                case 39: goto L30;
                case 40: goto L29;
                case 41: goto L28;
                case 42: goto L27;
                case 43: goto L26;
                case 44: goto L25;
                case 45: goto L24;
                case 46: goto L23;
                case 47: goto L22;
                case 48: goto L21;
                case 49: goto L20;
                case 50: goto L19;
                case 51: goto L18;
                case 52: goto L17;
                case 53: goto L16;
                case 54: goto L15;
                case 55: goto L14;
                default: goto L13;
            };
        L14:
            IFsveritySetupAuthToken _arg0 = IFsveritySetupAuthToken.Stub.asInterface(data.readStrongBinder());
            String _arg1 = data.readString();
            String _arg2 = data.readString();
            data.enforceNoDataAvail();
            int _result = enableFsverity(_arg0, _arg1, _arg2);
            reply.writeNoException();
            reply.writeInt(_result);
            return true;
        L15:
            ParcelFileDescriptor _arg3 = (ParcelFileDescriptor) data.readTypedObject(ParcelFileDescriptor.CREATOR);
            int _arg4 = data.readInt();
            data.enforceNoDataAvail();
            IFsveritySetupAuthToken _result2 = createFsveritySetupAuthToken(_arg3, _arg4);
            reply.writeNoException();
            reply.writeStrongInterface(_result2);
            return true;
        L16:
            String _arg5 = data.readString();
            String _arg6 = data.readString();
            String _arg7 = data.readString();
            String _arg8 = data.readString();
            data.enforceNoDataAvail();
            int _result3 = getOdexVisibility(_arg5, _arg6, _arg7, _arg8);
            reply.writeNoException();
            reply.writeInt(_result3);
            return true;
        L17:
            String _arg9 = data.readString();
            int _arg10 = data.readInt();
            int _arg11 = data.readInt();
            data.enforceNoDataAvail();
            cleanupInvalidPackageDirs(_arg9, _arg10, _arg11);
            reply.writeNoException();
            return true;
        L18:
            migrateLegacyObbData();
            reply.writeNoException();
            return true;
        L19:
            String _arg12 = data.readString();
            data.enforceNoDataAvail();
            onPrivateVolumeRemoved(_arg12);
            reply.writeNoException();
            return true;
        L20:
            String _arg13 = data.readString();
            data.enforceNoDataAvail();
            tryMountDataMirror(_arg13);
            reply.writeNoException();
            return true;
        L21:
            int _arg14 = data.readInt();
            int _arg15 = data.readInt();
            String _arg16 = data.readString();
            int _arg17 = data.readInt();
            int _arg18 = data.readInt();
            data.enforceNoDataAvail();
            preLoadAppData(_arg14, _arg15, _arg16, _arg17, _arg18);
            return true;
        L22:
            String _arg19 = data.readString();
            data.enforceNoDataAvail();
            String _result4 = getPackageFilesInfo(_arg19);
            reply.writeNoException();
            reply.writeString(_result4);
            return true;
        L23:
            String[] _arg20 = data.createStringArray();
            data.enforceNoDataAvail();
            int _result5 = do6939Service(_arg20);
            reply.writeNoException();
            reply.writeInt(_result5);
            return true;
        L24:
            String _arg21 = data.readString();
            int _arg22 = data.readInt();
            int[] _arg23 = data.createIntArray();
            data.enforceNoDataAvail();
            destroyCeSnapshotsNotSpecified(_arg21, _arg22, _arg23);
            reply.writeNoException();
            return true;
        L25:
            String _arg24 = data.readString();
            String _arg25 = data.readString();
            int _arg26 = data.readInt();
            long _arg27 = data.readLong();
            int _arg28 = data.readInt();
            int _arg29 = data.readInt();
            data.enforceNoDataAvail();
            destroyAppDataSnapshot(_arg24, _arg25, _arg26, _arg27, _arg28, _arg29);
            reply.writeNoException();
            return true;
        L26:
            String _arg30 = data.readString();
            String _arg31 = data.readString();
            int _arg32 = data.readInt();
            String _arg33 = data.readString();
            int _arg34 = data.readInt();
            int _arg35 = data.readInt();
            int _arg36 = data.readInt();
            data.enforceNoDataAvail();
            restoreAppDataSnapshot(_arg30, _arg31, _arg32, _arg33, _arg34, _arg35, _arg36);
            reply.writeNoException();
            return true;
        L27:
            String _arg37 = data.readString();
            String _arg38 = data.readString();
            int _arg39 = data.readInt();
            int _arg40 = data.readInt();
            int _arg41 = data.readInt();
            data.enforceNoDataAvail();
            long _result6 = snapshotAppData(_arg37, _arg38, _arg39, _arg40, _arg41);
            reply.writeNoException();
            reply.writeLong(_result6);
            return true;
        L28:
            String _arg42 = data.readString();
            int _arg43 = data.readInt();
            int _arg44 = data.readInt();
            String _arg45 = data.readString();
            String _arg46 = data.readString();
            String _arg47 = data.readString();
            data.enforceNoDataAvail();
            boolean _result7 = prepareAppProfile(_arg42, _arg43, _arg44, _arg45, _arg46, _arg47);
            reply.writeNoException();
            reply.writeBoolean(_result7);
            return true;
        L29:
            String _arg48 = data.readString();
            data.enforceNoDataAvail();
            boolean _result8 = isQuotaSupported(_arg48);
            reply.writeNoException();
            reply.writeBoolean(_result8);
            return true;
        L30:
            invalidateMounts();
            reply.writeNoException();
            return true;
        L31:
            String _arg49 = data.readString();
            String _arg50 = data.readString();
            int _arg51 = data.readInt();
            String _arg52 = data.readString();
            int _arg53 = data.readInt();
            data.enforceNoDataAvail();
            byte[] _result9 = hashSecondaryDexFile(_arg49, _arg50, _arg51, _arg52, _arg53);
            reply.writeNoException();
            reply.writeByteArray(_result9);
            return true;
        L32:
            String _arg54 = data.readString();
            String _arg55 = data.readString();
            int _arg56 = data.readInt();
            String[] _arg57 = data.createStringArray();
            String _arg58 = data.readString();
            int _arg59 = data.readInt();
            data.enforceNoDataAvail();
            boolean _result10 = reconcileSecondaryDexFile(_arg54, _arg55, _arg56, _arg57, _arg58, _arg59);
            reply.writeNoException();
            reply.writeBoolean(_result10);
            return true;
        L33:
            String _arg60 = data.readString();
            String _arg61 = data.readString();
            String _arg62 = data.readString();
            String _arg63 = data.readString();
            data.enforceNoDataAvail();
            long _result11 = deleteOdex(_arg60, _arg61, _arg62, _arg63);
            reply.writeNoException();
            reply.writeLong(_result11);
            return true;
        L34:
            String _arg64 = data.readString();
            String _arg65 = data.readString();
            String _arg66 = data.readString();
            String _arg67 = data.readString();
            data.enforceNoDataAvail();
            moveAb(_arg64, _arg65, _arg66, _arg67);
            reply.writeNoException();
            return true;
        L35:
            String _arg68 = data.readString();
            String _arg69 = data.readString();
            String _arg70 = data.readString();
            String _arg71 = data.readString();
            data.enforceNoDataAvail();
            linkFile(_arg68, _arg69, _arg70, _arg71);
            reply.writeNoException();
            return true;
        L36:
            String _arg72 = data.readString();
            String _arg73 = data.readString();
            String _arg74 = data.readString();
            data.enforceNoDataAvail();
            createOatDir(_arg72, _arg73, _arg74);
            reply.writeNoException();
            return true;
        L37:
            String _arg75 = data.readString();
            String _arg76 = data.readString();
            String _arg77 = data.readString();
            int _arg78 = data.readInt();
            data.enforceNoDataAvail();
            linkNativeLibraryDirectory(_arg75, _arg76, _arg77, _arg78);
            reply.writeNoException();
            return true;
        L38:
            String _arg79 = data.readString();
            long _arg80 = data.readLong();
            int _arg81 = data.readInt();
            data.enforceNoDataAvail();
            freeCache(_arg79, _arg80, _arg81);
            reply.writeNoException();
            return true;
        L39:
            String _arg82 = data.readString();
            String _arg83 = data.readString();
            data.enforceNoDataAvail();
            rmPackageDir(_arg82, _arg83);
            reply.writeNoException();
            return true;
        L40:
            String _arg84 = data.readString();
            String _arg85 = data.readString();
            data.enforceNoDataAvail();
            destroyProfileSnapshot(_arg84, _arg85);
            reply.writeNoException();
            return true;
        L41:
            int _arg86 = data.readInt();
            String _arg87 = data.readString();
            String _arg88 = data.readString();
            String _arg89 = data.readString();
            data.enforceNoDataAvail();
            boolean _result12 = createProfileSnapshot(_arg86, _arg87, _arg88, _arg89);
            reply.writeNoException();
            reply.writeBoolean(_result12);
            return true;
        L42:
            String _arg90 = data.readString();
            String _arg91 = data.readString();
            data.enforceNoDataAvail();
            deleteReferenceProfile(_arg90, _arg91);
            reply.writeNoException();
            return true;
        L43:
            String _arg92 = data.readString();
            data.enforceNoDataAvail();
            destroyAppProfiles(_arg92);
            reply.writeNoException();
            return true;
        L44:
            String _arg93 = data.readString();
            String _arg94 = data.readString();
            data.enforceNoDataAvail();
            clearAppProfiles(_arg93, _arg94);
            reply.writeNoException();
            return true;
        L45:
            String _arg95 = data.readString();
            int _arg96 = data.readInt();
            String _arg97 = data.readString();
            String _arg98 = data.readString();
            data.enforceNoDataAvail();
            boolean _result13 = copySystemProfile(_arg95, _arg96, _arg97, _arg98);
            reply.writeNoException();
            reply.writeBoolean(_result13);
            return true;
        L46:
            int _arg99 = data.readInt();
            String _arg100 = data.readString();
            String _arg101 = data.readString();
            String _arg102 = data.readString();
            boolean _arg103 = data.readBoolean();
            data.enforceNoDataAvail();
            boolean _result14 = dumpProfiles(_arg99, _arg100, _arg101, _arg102, _arg103);
            reply.writeNoException();
            reply.writeBoolean(_result14);
            return true;
        L47:
            int _arg104 = data.readInt();
            String _arg105 = data.readString();
            String _arg106 = data.readString();
            data.enforceNoDataAvail();
            int _result15 = mergeProfiles(_arg104, _arg105, _arg106);
            reply.writeNoException();
            reply.writeInt(_result15);
            return true;
        L48:
            String _arg107 = data.readString();
            String _arg108 = data.readString();
            data.enforceNoDataAvail();
            rmdex(_arg107, _arg108);
            reply.writeNoException();
            return true;
        L49:
            boolean _arg109 = data.readBoolean();
            data.enforceNoDataAvail();
            controlDexOptBlocking(_arg109);
            reply.writeNoException();
            return true;
        L50:
            String _arg110 = data.readString();
            int _arg111 = data.readInt();
            String _arg112 = data.readString();
            String _arg113 = data.readString();
            int _arg114 = data.readInt();
            String _arg115 = data.readString();
            int _arg116 = data.readInt();
            String _arg117 = data.readString();
            String _arg118 = data.readString();
            String _arg119 = data.readString();
            String _arg120 = data.readString();
            boolean _arg121 = data.readBoolean();
            int _arg122 = data.readInt();
            String _arg123 = data.readString();
            String _arg124 = data.readString();
            String _arg125 = data.readString();
            data.enforceNoDataAvail();
            boolean _result16 = dexopt(_arg110, _arg111, _arg112, _arg113, _arg114, _arg115, _arg116, _arg117, _arg118, _arg119, _arg120, _arg121, _arg122, _arg123, _arg124, _arg125);
            reply.writeNoException();
            reply.writeBoolean(_result16);
            return true;
        L51:
            String _arg126 = data.readString();
            String _arg127 = data.readString();
            String _arg128 = data.readString();
            int _arg129 = data.readInt();
            String _arg130 = data.readString();
            int _arg131 = data.readInt();
            String _arg132 = data.readString();
            data.enforceNoDataAvail();
            moveCompleteApp(_arg126, _arg127, _arg128, _arg129, _arg130, _arg131, _arg132);
            reply.writeNoException();
            return true;
        L52:
            String _arg133 = data.readString();
            int _arg134 = data.readInt();
            int _arg135 = data.readInt();
            long _arg136 = data.readLong();
            data.enforceNoDataAvail();
            setAppQuota(_arg133, _arg134, _arg135, _arg136);
            reply.writeNoException();
            return true;
        L53:
            String _arg137 = data.readString();
            int _arg138 = data.readInt();
            data.enforceNoDataAvail();
            CrateMetadata[] _result17 = getUserCrates(_arg137, _arg138);
            reply.writeNoException();
            reply.writeTypedArray(_result17, 1);
            return true;
        L54:
            String _arg139 = data.readString();
            String[] _arg140 = data.createStringArray();
            int _arg141 = data.readInt();
            data.enforceNoDataAvail();
            CrateMetadata[] _result18 = getAppCrates(_arg139, _arg140, _arg141);
            reply.writeNoException();
            reply.writeTypedArray(_result18, 1);
            return true;
        L55:
            String _arg142 = data.readString();
            int _arg143 = data.readInt();
            int _arg144 = data.readInt();
            int[] _arg145 = data.createIntArray();
            data.enforceNoDataAvail();
            long[] _result19 = getExternalSize(_arg142, _arg143, _arg144, _arg145);
            reply.writeNoException();
            reply.writeLongArray(_result19);
            return true;
        L56:
            String _arg146 = data.readString();
            int _arg147 = data.readInt();
            int _arg148 = data.readInt();
            int[] _arg149 = data.createIntArray();
            data.enforceNoDataAvail();
            long[] _result20 = getUserSize(_arg146, _arg147, _arg148, _arg149);
            reply.writeNoException();
            reply.writeLongArray(_result20);
            return true;
        L57:
            String _arg150 = data.readString();
            String[] _arg151 = data.createStringArray();
            int _arg152 = data.readInt();
            int _arg153 = data.readInt();
            int _arg154 = data.readInt();
            long[] _arg155 = data.createLongArray();
            String[] _arg156 = data.createStringArray();
            data.enforceNoDataAvail();
            long[] _result21 = getAppSize(_arg150, _arg151, _arg152, _arg153, _arg154, _arg155, _arg156);
            reply.writeNoException();
            reply.writeLongArray(_result21);
            return true;
        L58:
            String _arg157 = data.readString();
            int _arg158 = data.readInt();
            data.enforceNoDataAvail();
            fixupAppData(_arg157, _arg158);
            reply.writeNoException();
            return true;
        L59:
            String _arg159 = data.readString();
            String _arg160 = data.readString();
            int _arg161 = data.readInt();
            int _arg162 = data.readInt();
            long _arg163 = data.readLong();
            data.enforceNoDataAvail();
            destroyAppData(_arg159, _arg160, _arg161, _arg162, _arg163);
            reply.writeNoException();
            return true;
        L60:
            String _arg164 = data.readString();
            String _arg165 = data.readString();
            int _arg166 = data.readInt();
            int _arg167 = data.readInt();
            long _arg168 = data.readLong();
            data.enforceNoDataAvail();
            clearAppData(_arg164, _arg165, _arg166, _arg167, _arg168);
            reply.writeNoException();
            return true;
        L61:
            String _arg169 = data.readString();
            String _arg170 = data.readString();
            int _arg171 = data.readInt();
            int _arg172 = data.readInt();
            data.enforceNoDataAvail();
            migrateAppData(_arg169, _arg170, _arg171, _arg172);
            reply.writeNoException();
            return true;
        L62:
            String _arg173 = data.readString();
            String _arg174 = data.readString();
            int _arg175 = data.readInt();
            int _arg176 = data.readInt();
            int _arg177 = data.readInt();
            String _arg178 = data.readString();
            data.enforceNoDataAvail();
            restoreconAppData(_arg173, _arg174, _arg175, _arg176, _arg177, _arg178);
            reply.writeNoException();
            return true;
        L63:
            ReconcileSdkDataArgs _arg179 = (ReconcileSdkDataArgs) data.readTypedObject(ReconcileSdkDataArgs.CREATOR);
            data.enforceNoDataAvail();
            reconcileSdkData(_arg179);
            reply.writeNoException();
            return true;
        L64:
            CreateAppDataArgs[] _arg180 = (CreateAppDataArgs[]) data.createTypedArray(CreateAppDataArgs.CREATOR);
            data.enforceNoDataAvail();
            CreateAppDataResult[] _result22 = createAppDataBatched(_arg180);
            reply.writeNoException();
            reply.writeTypedArray(_result22, 1);
            return true;
        L65:
            CreateAppDataArgs _arg181 = (CreateAppDataArgs) data.readTypedObject(CreateAppDataArgs.CREATOR);
            data.enforceNoDataAvail();
            CreateAppDataResult _result23 = createAppData(_arg181);
            reply.writeNoException();
            reply.writeTypedObject(_result23, 1);
            return true;
        L66:
            setFirstBoot();
            reply.writeNoException();
            return true;
        L67:
            String _arg182 = data.readString();
            int _arg183 = data.readInt();
            int _arg184 = data.readInt();
            data.enforceNoDataAvail();
            destroyUserData(_arg182, _arg183, _arg184);
            reply.writeNoException();
            return true;
        L68:
            String _arg185 = data.readString();
            int _arg186 = data.readInt();
            int _arg187 = data.readInt();
            int _arg188 = data.readInt();
            data.enforceNoDataAvail();
            createUserData(_arg185, _arg186, _arg187, _arg188);
            reply.writeNoException();
            return true;
        L13:
            return super.onTransact(code, data, reply, flags);
        }
    }

    void cleanupInvalidPackageDirs(String r1, int r2, int r3) throws RemoteException;

    void clearAppData(String r1, String r2, int r3, int r4, long r5) throws RemoteException;

    void clearAppProfiles(String r1, String r2) throws RemoteException;

    void controlDexOptBlocking(boolean r1) throws RemoteException;

    boolean copySystemProfile(String r1, int r2, String r3, String r4) throws RemoteException;

    CreateAppDataResult createAppData(CreateAppDataArgs r1) throws RemoteException;

    CreateAppDataResult[] createAppDataBatched(CreateAppDataArgs[] r1) throws RemoteException;

    IFsveritySetupAuthToken createFsveritySetupAuthToken(ParcelFileDescriptor r1, int r2) throws RemoteException;

    void createOatDir(String r1, String r2, String r3) throws RemoteException;

    boolean createProfileSnapshot(int r1, String r2, String r3, String r4) throws RemoteException;

    void createUserData(String r1, int r2, int r3, int r4) throws RemoteException;

    long deleteOdex(String r1, String r2, String r3, String r4) throws RemoteException;

    void deleteReferenceProfile(String r1, String r2) throws RemoteException;

    void destroyAppData(String r1, String r2, int r3, int r4, long r5) throws RemoteException;

    void destroyAppDataSnapshot(String r1, String r2, int r3, long r4, int r6, int r7) throws RemoteException;

    void destroyAppProfiles(String r1) throws RemoteException;

    void destroyCeSnapshotsNotSpecified(String r1, int r2, int[] r3) throws RemoteException;

    void destroyProfileSnapshot(String r1, String r2) throws RemoteException;

    void destroyUserData(String r1, int r2, int r3) throws RemoteException;

    boolean dexopt(String r1, int r2, String r3, String r4, int r5, String r6, int r7, String r8, String r9, String r10, String r11, boolean r12, int r13, String r14, String r15, String r16) throws RemoteException;

    int do6939Service(String[] r1) throws RemoteException;

    boolean dumpProfiles(int r1, String r2, String r3, String r4, boolean r5) throws RemoteException;

    int enableFsverity(IFsveritySetupAuthToken r1, String r2, String r3) throws RemoteException;

    void fixupAppData(String r1, int r2) throws RemoteException;

    void freeCache(String r1, long r2, int r4) throws RemoteException;

    CrateMetadata[] getAppCrates(String r1, String[] r2, int r3) throws RemoteException;

    long[] getAppSize(String r1, String[] r2, int r3, int r4, int r5, long[] r6, String[] r7) throws RemoteException;

    long[] getExternalSize(String r1, int r2, int r3, int[] r4) throws RemoteException;

    int getOdexVisibility(String r1, String r2, String r3, String r4) throws RemoteException;

    String getPackageFilesInfo(String r1) throws RemoteException;

    CrateMetadata[] getUserCrates(String r1, int r2) throws RemoteException;

    long[] getUserSize(String r1, int r2, int r3, int[] r4) throws RemoteException;

    byte[] hashSecondaryDexFile(String r1, String r2, int r3, String r4, int r5) throws RemoteException;

    void invalidateMounts() throws RemoteException;

    boolean isQuotaSupported(String r1) throws RemoteException;

    void linkFile(String r1, String r2, String r3, String r4) throws RemoteException;

    void linkNativeLibraryDirectory(String r1, String r2, String r3, int r4) throws RemoteException;

    int mergeProfiles(int r1, String r2, String r3) throws RemoteException;

    void migrateAppData(String r1, String r2, int r3, int r4) throws RemoteException;

    void migrateLegacyObbData() throws RemoteException;

    void moveAb(String r1, String r2, String r3, String r4) throws RemoteException;

    void moveCompleteApp(String r1, String r2, String r3, int r4, String r5, int r6, String r7) throws RemoteException;

    void onPrivateVolumeRemoved(String r1) throws RemoteException;

    void preLoadAppData(int r1, int r2, String r3, int r4, int r5) throws RemoteException;

    boolean prepareAppProfile(String r1, int r2, int r3, String r4, String r5, String r6) throws RemoteException;

    void reconcileSdkData(ReconcileSdkDataArgs r1) throws RemoteException;

    boolean reconcileSecondaryDexFile(String r1, String r2, int r3, String[] r4, String r5, int r6) throws RemoteException;

    void restoreAppDataSnapshot(String r1, String r2, int r3, String r4, int r5, int r6, int r7) throws RemoteException;

    void restoreconAppData(String r1, String r2, int r3, int r4, int r5, String r6) throws RemoteException;

    void rmPackageDir(String r1, String r2) throws RemoteException;

    void rmdex(String r1, String r2) throws RemoteException;

    void setAppQuota(String r1, int r2, int r3, long r4) throws RemoteException;

    void setFirstBoot() throws RemoteException;

    long snapshotAppData(String r1, String r2, int r3, int r4, int r5) throws RemoteException;

    void tryMountDataMirror(String r1) throws RemoteException;
}
