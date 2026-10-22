package android.os;

import android.os.incremental.IncrementalFileSystemControlParcel;
import java.io.FileDescriptor;

/* JADX INFO: loaded from: classes.dex */
public interface IVold extends IInterface {
    public static final int FSTRIM_FLAG_DEEP_TRIM = 1;
    public static final int MOUNT_FLAG_PRIMARY = 1;
    public static final int MOUNT_FLAG_VISIBLE_FOR_READ = 2;
    public static final int MOUNT_FLAG_VISIBLE_FOR_WRITE = 4;
    public static final int PARTITION_TYPE_MIXED = 2;
    public static final int PARTITION_TYPE_PRIVATE = 1;
    public static final int PARTITION_TYPE_PUBLIC = 0;
    public static final int REMOUNT_MODE_ANDROID_WRITABLE = 4;
    public static final int REMOUNT_MODE_DEFAULT = 1;
    public static final int REMOUNT_MODE_INSTALLER = 2;
    public static final int REMOUNT_MODE_NONE = 0;
    public static final int REMOUNT_MODE_PASS_THROUGH = 3;
    public static final int STORAGE_FLAG_CE = 2;
    public static final int STORAGE_FLAG_DE = 1;
    public static final int VOLUME_STATE_BAD_REMOVAL = 8;
    public static final int VOLUME_STATE_CHECKING = 1;
    public static final int VOLUME_STATE_EJECTING = 5;
    public static final int VOLUME_STATE_FORMATTING = 4;
    public static final int VOLUME_STATE_MOUNTED = 2;
    public static final int VOLUME_STATE_MOUNTED_READ_ONLY = 3;
    public static final int VOLUME_STATE_REMOVED = 7;
    public static final int VOLUME_STATE_UNMOUNTABLE = 6;
    public static final int VOLUME_STATE_UNMOUNTED = 0;
    public static final int VOLUME_TYPE_ASEC = 3;
    public static final int VOLUME_TYPE_EMULATED = 2;
    public static final int VOLUME_TYPE_OBB = 4;
    public static final int VOLUME_TYPE_PRIVATE = 1;
    public static final int VOLUME_TYPE_PUBLIC = 0;
    public static final int VOLUME_TYPE_STUB = 5;

    public static class Default implements IVold {
        public Default() {
        }

        @Override // android.os.IVold
        public void setListener(IVoldListener listener) throws RemoteException {
        }

        @Override // android.os.IVold
        public void abortFuse() throws RemoteException {
        }

        @Override // android.os.IVold
        public void monitor() throws RemoteException {
        }

        @Override // android.os.IVold
        public void reset() throws RemoteException {
        }

        @Override // android.os.IVold
        public void shutdown() throws RemoteException {
        }

        @Override // android.os.IVold
        public void onUserAdded(int userId, int userSerial, int sharesStorageWithUserId) throws RemoteException {
        }

        @Override // android.os.IVold
        public void onUserRemoved(int userId) throws RemoteException {
        }

        @Override // android.os.IVold
        public void onUserStarted(int userId) throws RemoteException {
        }

        @Override // android.os.IVold
        public void onUserStopped(int userId) throws RemoteException {
        }

        @Override // android.os.IVold
        public void addAppIds(String[] packageNames, int[] appIds) throws RemoteException {
        }

        @Override // android.os.IVold
        public void addSandboxIds(int[] appIds, String[] sandboxIds) throws RemoteException {
        }

        @Override // android.os.IVold
        public void onSecureKeyguardStateChanged(boolean isShowing) throws RemoteException {
        }

        @Override // android.os.IVold
        public void partition(String diskId, int partitionType, int ratio) throws RemoteException {
        }

        @Override // android.os.IVold
        public void forgetPartition(String partGuid, String fsUuid) throws RemoteException {
        }

        @Override // android.os.IVold
        public void mount(String volId, int mountFlags, int mountUserId, IVoldMountCallback callback) throws RemoteException {
        }

        @Override // android.os.IVold
        public void unmount(String volId) throws RemoteException {
        }

        @Override // android.os.IVold
        public void format(String volId, String fsType) throws RemoteException {
        }

        @Override // android.os.IVold
        public void benchmark(String volId, IVoldTaskListener listener) throws RemoteException {
        }

        @Override // android.os.IVold
        public void moveStorage(String fromVolId, String toVolId, IVoldTaskListener listener) throws RemoteException {
        }

        @Override // android.os.IVold
        public void remountUid(int uid, int remountMode) throws RemoteException {
        }

        @Override // android.os.IVold
        public void remountAppStorageDirs(int uid, int pid, String[] packageNames) throws RemoteException {
        }

        @Override // android.os.IVold
        public void unmountAppStorageDirs(int uid, int pid, String[] packageNames) throws RemoteException {
        }

        @Override // android.os.IVold
        public void setupAppDir(String path, int appUid) throws RemoteException {
        }

        @Override // android.os.IVold
        public void fixupAppDir(String path, int appUid) throws RemoteException {
        }

        @Override // android.os.IVold
        public void ensureAppDirsCreated(String[] paths, int appUid) throws RemoteException {
        }

        @Override // android.os.IVold
        public String createObb(String sourcePath, int ownerGid) throws RemoteException {
            return null;
        }

        @Override // android.os.IVold
        public void destroyObb(String volId) throws RemoteException {
        }

        @Override // android.os.IVold
        public void fstrim(int fstrimFlags, IVoldTaskListener listener) throws RemoteException {
        }

        @Override // android.os.IVold
        public void runIdleMaint(boolean needGC, IVoldTaskListener listener) throws RemoteException {
        }

        @Override // android.os.IVold
        public void abortIdleMaint(IVoldTaskListener listener) throws RemoteException {
        }

        @Override // android.os.IVold
        public int getStorageLifeTime() throws RemoteException {
            return 0;
        }

        @Override // android.os.IVold
        public void setGCUrgentPace(int neededSegments, int minSegmentThreshold, float dirtyReclaimRate, float reclaimWeight, int gcPeriod, int minGCSleepTime, int targetDirtyRatio) throws RemoteException {
        }

        @Override // android.os.IVold
        public void refreshLatestWrite() throws RemoteException {
        }

        @Override // android.os.IVold
        public int getWriteAmount() throws RemoteException {
            return 0;
        }

        @Override // android.os.IVold
        public FileDescriptor mountAppFuse(int uid, int mountId) throws RemoteException {
            return null;
        }

        @Override // android.os.IVold
        public void unmountAppFuse(int uid, int mountId) throws RemoteException {
        }

        @Override // android.os.IVold
        public void fbeEnable() throws RemoteException {
        }

        @Override // android.os.IVold
        public void initUser0() throws RemoteException {
        }

        @Override // android.os.IVold
        public void mountFstab(String blkDevice, String mountPoint, boolean isZoned, String[] userDevices) throws RemoteException {
        }

        @Override // android.os.IVold
        public void encryptFstab(String blkDevice, String mountPoint, boolean shouldFormat, String fsType, boolean isZoned, String[] userDevices, boolean[] deviceAliased, long length) throws RemoteException {
        }

        @Override // android.os.IVold
        public void setStorageBindingSeed(byte[] seed) throws RemoteException {
        }

        @Override // android.os.IVold
        public void createUserStorageKeys(int userId, boolean ephemeral) throws RemoteException {
        }

        @Override // android.os.IVold
        public void destroyUserStorageKeys(int userId) throws RemoteException {
        }

        @Override // android.os.IVold
        public void setCeStorageProtection(int userId, byte[] secret) throws RemoteException {
        }

        @Override // android.os.IVold
        public int[] getUnlockedUsers() throws RemoteException {
            return null;
        }

        @Override // android.os.IVold
        public void unlockCeStorage(int userId, byte[] secret) throws RemoteException {
        }

        @Override // android.os.IVold
        public void lockCeStorage(int userId) throws RemoteException {
        }

        @Override // android.os.IVold
        public void prepareUserStorage(String uuid, int userId, int storageFlags) throws RemoteException {
        }

        @Override // android.os.IVold
        public void destroyUserStorage(String uuid, int userId, int storageFlags) throws RemoteException {
        }

        @Override // android.os.IVold
        public void prepareSandboxForApp(String packageName, int appId, String sandboxId, int userId) throws RemoteException {
        }

        @Override // android.os.IVold
        public void destroySandboxForApp(String packageName, String sandboxId, int userId) throws RemoteException {
        }

        @Override // android.os.IVold
        public void startCheckpoint(int retry) throws RemoteException {
        }

        @Override // android.os.IVold
        public boolean needsCheckpoint() throws RemoteException {
            return false;
        }

        @Override // android.os.IVold
        public boolean needsRollback() throws RemoteException {
            return false;
        }

        @Override // android.os.IVold
        public boolean isCheckpointing() throws RemoteException {
            return false;
        }

        @Override // android.os.IVold
        public void abortChanges(String device, boolean retry) throws RemoteException {
        }

        @Override // android.os.IVold
        public void commitChanges() throws RemoteException {
        }

        @Override // android.os.IVold
        public void prepareCheckpoint() throws RemoteException {
        }

        @Override // android.os.IVold
        public void restoreCheckpoint(String device) throws RemoteException {
        }

        @Override // android.os.IVold
        public void restoreCheckpointPart(String device, int count) throws RemoteException {
        }

        @Override // android.os.IVold
        public void markBootAttempt() throws RemoteException {
        }

        @Override // android.os.IVold
        public boolean supportsCheckpoint() throws RemoteException {
            return false;
        }

        @Override // android.os.IVold
        public boolean supportsBlockCheckpoint() throws RemoteException {
            return false;
        }

        @Override // android.os.IVold
        public boolean supportsFileCheckpoint() throws RemoteException {
            return false;
        }

        @Override // android.os.IVold
        public void resetCheckpoint() throws RemoteException {
        }

        @Override // android.os.IVold
        public void earlyBootEnded() throws RemoteException {
        }

        @Override // android.os.IVold
        public String createStubVolume(String sourcePath, String mountPath, String fsType, String fsUuid, String fsLabel, int flags) throws RemoteException {
            return null;
        }

        @Override // android.os.IVold
        public void destroyStubVolume(String volId) throws RemoteException {
        }

        @Override // android.os.IVold
        public FileDescriptor openAppFuseFile(int uid, int mountId, int fileId, int flags) throws RemoteException {
            return null;
        }

        @Override // android.os.IVold
        public boolean incFsEnabled() throws RemoteException {
            return false;
        }

        @Override // android.os.IVold
        public IncrementalFileSystemControlParcel mountIncFs(String backingPath, String targetDir, int flags, String sysfsName) throws RemoteException {
            return null;
        }

        @Override // android.os.IVold
        public void unmountIncFs(String dir) throws RemoteException {
        }

        @Override // android.os.IVold
        public void setIncFsMountOptions(IncrementalFileSystemControlParcel control, boolean enableReadLogs, boolean enableReadTimeouts, String sysfsName) throws RemoteException {
        }

        @Override // android.os.IVold
        public void bindMount(String sourceDir, String targetDir) throws RemoteException {
        }

        @Override // android.os.IVold
        public void destroyDsuMetadataKey(String dsuSlot) throws RemoteException {
        }

        @Override // android.os.IVold
        public long getStorageSize() throws RemoteException {
            return 0;
        }

        @Override // android.os.IVold
        public int getStorageRemainingLifetime() throws RemoteException {
            return 0;
        }

        @Override // android.os.IVold
        public int getWriteBoosterBufferSize() throws RemoteException {
            return 0;
        }

        @Override // android.os.IVold
        public int getWriteBoosterBufferAvailablePercent() throws RemoteException {
            return 0;
        }

        @Override // android.os.IVold
        public boolean setWriteBoosterBufferFlush(boolean enable) throws RemoteException {
            return false;
        }

        @Override // android.os.IVold
        public boolean setWriteBoosterBufferOn(boolean enable) throws RemoteException {
            return false;
        }

        @Override // android.os.IVold
        public int getWriteBoosterLifeTimeEstimate() throws RemoteException {
            return 0;
        }

        @Override // android.os.IVold
        public void serviceKeyInit(int serviceId, int userId, int uid, byte[] secret) throws RemoteException {
        }

        @Override // android.os.IVold
        public void serviceKeyDelete(int serviceId, int userId) throws RemoteException {
        }

        @Override // android.os.IVold
        public void serviceLockStorage(int serviceId, int userId) throws RemoteException {
        }

        @Override // android.os.IVold
        public void serviceUnlockStorage(int serviceId, int userId, byte[] secret) throws RemoteException {
        }

        @Override // android.os.IVold
        public void hypeholdIceEnable() throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IVold {
        public static final String DESCRIPTOR = "android.os.IVold";
        static final int TRANSACTION_abortChanges = 56;
        static final int TRANSACTION_abortFuse = 2;
        static final int TRANSACTION_abortIdleMaint = 30;
        static final int TRANSACTION_addAppIds = 10;
        static final int TRANSACTION_addSandboxIds = 11;
        static final int TRANSACTION_benchmark = 18;
        static final int TRANSACTION_bindMount = 74;
        static final int TRANSACTION_commitChanges = 57;
        static final int TRANSACTION_createObb = 26;
        static final int TRANSACTION_createStubVolume = 67;
        static final int TRANSACTION_createUserStorageKeys = 42;
        static final int TRANSACTION_destroyDsuMetadataKey = 75;
        static final int TRANSACTION_destroyObb = 27;
        static final int TRANSACTION_destroySandboxForApp = 51;
        static final int TRANSACTION_destroyStubVolume = 68;
        static final int TRANSACTION_destroyUserStorage = 49;
        static final int TRANSACTION_destroyUserStorageKeys = 43;
        static final int TRANSACTION_earlyBootEnded = 66;
        static final int TRANSACTION_encryptFstab = 40;
        static final int TRANSACTION_ensureAppDirsCreated = 25;
        static final int TRANSACTION_fbeEnable = 37;
        static final int TRANSACTION_fixupAppDir = 24;
        static final int TRANSACTION_forgetPartition = 14;
        static final int TRANSACTION_format = 17;
        static final int TRANSACTION_fstrim = 28;
        static final int TRANSACTION_getStorageLifeTime = 31;
        static final int TRANSACTION_getStorageRemainingLifetime = 77;
        static final int TRANSACTION_getStorageSize = 76;
        static final int TRANSACTION_getUnlockedUsers = 45;
        static final int TRANSACTION_getWriteAmount = 34;
        static final int TRANSACTION_getWriteBoosterBufferAvailablePercent = 79;
        static final int TRANSACTION_getWriteBoosterBufferSize = 78;
        static final int TRANSACTION_getWriteBoosterLifeTimeEstimate = 82;
        static final int TRANSACTION_hypeholdIceEnable = 87;
        static final int TRANSACTION_incFsEnabled = 70;
        static final int TRANSACTION_initUser0 = 38;
        static final int TRANSACTION_isCheckpointing = 55;
        static final int TRANSACTION_lockCeStorage = 47;
        static final int TRANSACTION_markBootAttempt = 61;
        static final int TRANSACTION_monitor = 3;
        static final int TRANSACTION_mount = 15;
        static final int TRANSACTION_mountAppFuse = 35;
        static final int TRANSACTION_mountFstab = 39;
        static final int TRANSACTION_mountIncFs = 71;
        static final int TRANSACTION_moveStorage = 19;
        static final int TRANSACTION_needsCheckpoint = 53;
        static final int TRANSACTION_needsRollback = 54;
        static final int TRANSACTION_onSecureKeyguardStateChanged = 12;
        static final int TRANSACTION_onUserAdded = 6;
        static final int TRANSACTION_onUserRemoved = 7;
        static final int TRANSACTION_onUserStarted = 8;
        static final int TRANSACTION_onUserStopped = 9;
        static final int TRANSACTION_openAppFuseFile = 69;
        static final int TRANSACTION_partition = 13;
        static final int TRANSACTION_prepareCheckpoint = 58;
        static final int TRANSACTION_prepareSandboxForApp = 50;
        static final int TRANSACTION_prepareUserStorage = 48;
        static final int TRANSACTION_refreshLatestWrite = 33;
        static final int TRANSACTION_remountAppStorageDirs = 21;
        static final int TRANSACTION_remountUid = 20;
        static final int TRANSACTION_reset = 4;
        static final int TRANSACTION_resetCheckpoint = 65;
        static final int TRANSACTION_restoreCheckpoint = 59;
        static final int TRANSACTION_restoreCheckpointPart = 60;
        static final int TRANSACTION_runIdleMaint = 29;
        static final int TRANSACTION_serviceKeyDelete = 84;
        static final int TRANSACTION_serviceKeyInit = 83;
        static final int TRANSACTION_serviceLockStorage = 85;
        static final int TRANSACTION_serviceUnlockStorage = 86;
        static final int TRANSACTION_setCeStorageProtection = 44;
        static final int TRANSACTION_setGCUrgentPace = 32;
        static final int TRANSACTION_setIncFsMountOptions = 73;
        static final int TRANSACTION_setListener = 1;
        static final int TRANSACTION_setStorageBindingSeed = 41;
        static final int TRANSACTION_setWriteBoosterBufferFlush = 80;
        static final int TRANSACTION_setWriteBoosterBufferOn = 81;
        static final int TRANSACTION_setupAppDir = 23;
        static final int TRANSACTION_shutdown = 5;
        static final int TRANSACTION_startCheckpoint = 52;
        static final int TRANSACTION_supportsBlockCheckpoint = 63;
        static final int TRANSACTION_supportsCheckpoint = 62;
        static final int TRANSACTION_supportsFileCheckpoint = 64;
        static final int TRANSACTION_unlockCeStorage = 46;
        static final int TRANSACTION_unmount = 16;
        static final int TRANSACTION_unmountAppFuse = 36;
        static final int TRANSACTION_unmountAppStorageDirs = 22;
        static final int TRANSACTION_unmountIncFs = 72;

        private static class Proxy implements IVold {
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

            @Override // android.os.IVold
            public void setListener(IVoldListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeStrongInterface(listener);     // Catch: Throwable -> L6
                this.mRemote.transact(1, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void abortFuse() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(2, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void monitor() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(3, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void reset() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(4, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void shutdown() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(5, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void onUserAdded(int userId, int userSerial, int sharesStorageWithUserId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(userId);     // Catch: Throwable -> L6
                _data.writeInt(userSerial);     // Catch: Throwable -> L6
                _data.writeInt(sharesStorageWithUserId);     // Catch: Throwable -> L6
                this.mRemote.transact(6, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void onUserRemoved(int userId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(userId);     // Catch: Throwable -> L6
                this.mRemote.transact(7, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void onUserStarted(int userId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(userId);     // Catch: Throwable -> L6
                this.mRemote.transact(8, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void onUserStopped(int userId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(userId);     // Catch: Throwable -> L6
                this.mRemote.transact(9, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void addAppIds(String[] packageNames, int[] appIds) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeStringArray(packageNames);     // Catch: Throwable -> L6
                _data.writeIntArray(appIds);     // Catch: Throwable -> L6
                this.mRemote.transact(10, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void addSandboxIds(int[] appIds, String[] sandboxIds) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeIntArray(appIds);     // Catch: Throwable -> L6
                _data.writeStringArray(sandboxIds);     // Catch: Throwable -> L6
                this.mRemote.transact(11, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void onSecureKeyguardStateChanged(boolean isShowing) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeBoolean(isShowing);     // Catch: Throwable -> L6
                this.mRemote.transact(12, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void partition(String diskId, int partitionType, int ratio) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(diskId);     // Catch: Throwable -> L6
                _data.writeInt(partitionType);     // Catch: Throwable -> L6
                _data.writeInt(ratio);     // Catch: Throwable -> L6
                this.mRemote.transact(13, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void forgetPartition(String partGuid, String fsUuid) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(partGuid);     // Catch: Throwable -> L6
                _data.writeString(fsUuid);     // Catch: Throwable -> L6
                this.mRemote.transact(14, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void mount(String volId, int mountFlags, int mountUserId, IVoldMountCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(volId);     // Catch: Throwable -> L6
                _data.writeInt(mountFlags);     // Catch: Throwable -> L6
                _data.writeInt(mountUserId);     // Catch: Throwable -> L6
                _data.writeStrongInterface(callback);     // Catch: Throwable -> L6
                this.mRemote.transact(15, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void unmount(String volId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(volId);     // Catch: Throwable -> L6
                this.mRemote.transact(16, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void format(String volId, String fsType) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(volId);     // Catch: Throwable -> L6
                _data.writeString(fsType);     // Catch: Throwable -> L6
                this.mRemote.transact(17, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void benchmark(String volId, IVoldTaskListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(volId);     // Catch: Throwable -> L6
                _data.writeStrongInterface(listener);     // Catch: Throwable -> L6
                this.mRemote.transact(18, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void moveStorage(String fromVolId, String toVolId, IVoldTaskListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(fromVolId);     // Catch: Throwable -> L6
                _data.writeString(toVolId);     // Catch: Throwable -> L6
                _data.writeStrongInterface(listener);     // Catch: Throwable -> L6
                this.mRemote.transact(19, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void remountUid(int uid, int remountMode) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(uid);     // Catch: Throwable -> L6
                _data.writeInt(remountMode);     // Catch: Throwable -> L6
                this.mRemote.transact(20, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void remountAppStorageDirs(int uid, int pid, String[] packageNames) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(uid);     // Catch: Throwable -> L6
                _data.writeInt(pid);     // Catch: Throwable -> L6
                _data.writeStringArray(packageNames);     // Catch: Throwable -> L6
                this.mRemote.transact(21, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void unmountAppStorageDirs(int uid, int pid, String[] packageNames) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(uid);     // Catch: Throwable -> L6
                _data.writeInt(pid);     // Catch: Throwable -> L6
                _data.writeStringArray(packageNames);     // Catch: Throwable -> L6
                this.mRemote.transact(22, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void setupAppDir(String path, int appUid) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(path);     // Catch: Throwable -> L6
                _data.writeInt(appUid);     // Catch: Throwable -> L6
                this.mRemote.transact(23, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void fixupAppDir(String path, int appUid) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(path);     // Catch: Throwable -> L6
                _data.writeInt(appUid);     // Catch: Throwable -> L6
                this.mRemote.transact(24, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void ensureAppDirsCreated(String[] paths, int appUid) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeStringArray(paths);     // Catch: Throwable -> L6
                _data.writeInt(appUid);     // Catch: Throwable -> L6
                this.mRemote.transact(25, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public String createObb(String sourcePath, int ownerGid) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(sourcePath);     // Catch: Throwable -> L6
                _data.writeInt(ownerGid);     // Catch: Throwable -> L6
                this.mRemote.transact(26, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void destroyObb(String volId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(volId);     // Catch: Throwable -> L6
                this.mRemote.transact(27, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void fstrim(int fstrimFlags, IVoldTaskListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(fstrimFlags);     // Catch: Throwable -> L6
                _data.writeStrongInterface(listener);     // Catch: Throwable -> L6
                this.mRemote.transact(28, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void runIdleMaint(boolean needGC, IVoldTaskListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeBoolean(needGC);     // Catch: Throwable -> L6
                _data.writeStrongInterface(listener);     // Catch: Throwable -> L6
                this.mRemote.transact(29, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void abortIdleMaint(IVoldTaskListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeStrongInterface(listener);     // Catch: Throwable -> L6
                this.mRemote.transact(30, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public int getStorageLifeTime() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(31, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void setGCUrgentPace(int neededSegments, int minSegmentThreshold, float dirtyReclaimRate, float reclaimWeight, int gcPeriod, int minGCSleepTime, int targetDirtyRatio) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(neededSegments);     // Catch: Throwable -> L6
                _data.writeInt(minSegmentThreshold);     // Catch: Throwable -> L6
                _data.writeFloat(dirtyReclaimRate);     // Catch: Throwable -> L6
                _data.writeFloat(reclaimWeight);     // Catch: Throwable -> L6
                _data.writeInt(gcPeriod);     // Catch: Throwable -> L6
                _data.writeInt(minGCSleepTime);     // Catch: Throwable -> L6
                _data.writeInt(targetDirtyRatio);     // Catch: Throwable -> L6
                this.mRemote.transact(32, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void refreshLatestWrite() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(33, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public int getWriteAmount() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(34, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public FileDescriptor mountAppFuse(int uid, int mountId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(uid);     // Catch: Throwable -> L6
                _data.writeInt(mountId);     // Catch: Throwable -> L6
                this.mRemote.transact(35, _data, _reply, 32);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                FileDescriptor _result = _reply.readRawFileDescriptor();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IVold
            public void unmountAppFuse(int uid, int mountId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(uid);     // Catch: Throwable -> L6
                _data.writeInt(mountId);     // Catch: Throwable -> L6
                this.mRemote.transact(36, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void fbeEnable() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(37, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void initUser0() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(38, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void mountFstab(String blkDevice, String mountPoint, boolean isZoned, String[] userDevices) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(blkDevice);     // Catch: Throwable -> L6
                _data.writeString(mountPoint);     // Catch: Throwable -> L6
                _data.writeBoolean(isZoned);     // Catch: Throwable -> L6
                _data.writeStringArray(userDevices);     // Catch: Throwable -> L6
                this.mRemote.transact(39, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void encryptFstab(String blkDevice, String mountPoint, boolean shouldFormat, String fsType, boolean isZoned, String[] userDevices, boolean[] deviceAliased, long length) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(blkDevice);     // Catch: Throwable -> L6
                _data.writeString(mountPoint);     // Catch: Throwable -> L6
                _data.writeBoolean(shouldFormat);     // Catch: Throwable -> L6
                _data.writeString(fsType);     // Catch: Throwable -> L6
                _data.writeBoolean(isZoned);     // Catch: Throwable -> L6
                _data.writeStringArray(userDevices);     // Catch: Throwable -> L6
                _data.writeBooleanArray(deviceAliased);     // Catch: Throwable -> L6
                _data.writeLong(length);     // Catch: Throwable -> L6
                this.mRemote.transact(40, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void setStorageBindingSeed(byte[] seed) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeByteArray(seed);     // Catch: Throwable -> L6
                this.mRemote.transact(41, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void createUserStorageKeys(int userId, boolean ephemeral) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(userId);     // Catch: Throwable -> L6
                _data.writeBoolean(ephemeral);     // Catch: Throwable -> L6
                this.mRemote.transact(42, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void destroyUserStorageKeys(int userId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(userId);     // Catch: Throwable -> L6
                this.mRemote.transact(43, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void setCeStorageProtection(int userId, byte[] secret) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(userId);     // Catch: Throwable -> L6
                _data.writeByteArray(secret);     // Catch: Throwable -> L6
                this.mRemote.transact(44, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public int[] getUnlockedUsers() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(45, _data, _reply, 32);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                int[] _result = _reply.createIntArray();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IVold
            public void unlockCeStorage(int userId, byte[] secret) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(userId);     // Catch: Throwable -> L6
                _data.writeByteArray(secret);     // Catch: Throwable -> L6
                this.mRemote.transact(46, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void lockCeStorage(int userId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(userId);     // Catch: Throwable -> L6
                this.mRemote.transact(47, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void prepareUserStorage(String uuid, int userId, int storageFlags) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(uuid);     // Catch: Throwable -> L6
                _data.writeInt(userId);     // Catch: Throwable -> L6
                _data.writeInt(storageFlags);     // Catch: Throwable -> L6
                this.mRemote.transact(48, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void destroyUserStorage(String uuid, int userId, int storageFlags) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(uuid);     // Catch: Throwable -> L6
                _data.writeInt(userId);     // Catch: Throwable -> L6
                _data.writeInt(storageFlags);     // Catch: Throwable -> L6
                this.mRemote.transact(49, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void prepareSandboxForApp(String packageName, int appId, String sandboxId, int userId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(packageName);     // Catch: Throwable -> L6
                _data.writeInt(appId);     // Catch: Throwable -> L6
                _data.writeString(sandboxId);     // Catch: Throwable -> L6
                _data.writeInt(userId);     // Catch: Throwable -> L6
                this.mRemote.transact(50, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void destroySandboxForApp(String packageName, String sandboxId, int userId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(packageName);     // Catch: Throwable -> L6
                _data.writeString(sandboxId);     // Catch: Throwable -> L6
                _data.writeInt(userId);     // Catch: Throwable -> L6
                this.mRemote.transact(51, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void startCheckpoint(int retry) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(retry);     // Catch: Throwable -> L6
                this.mRemote.transact(52, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public boolean needsCheckpoint() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(53, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public boolean needsRollback() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(54, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public boolean isCheckpointing() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(55, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void abortChanges(String device, boolean retry) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(device);     // Catch: Throwable -> L6
                _data.writeBoolean(retry);     // Catch: Throwable -> L6
                this.mRemote.transact(56, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void commitChanges() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(57, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void prepareCheckpoint() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(58, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void restoreCheckpoint(String device) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(device);     // Catch: Throwable -> L6
                this.mRemote.transact(59, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void restoreCheckpointPart(String device, int count) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(device);     // Catch: Throwable -> L6
                _data.writeInt(count);     // Catch: Throwable -> L6
                this.mRemote.transact(60, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void markBootAttempt() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(61, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public boolean supportsCheckpoint() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(62, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public boolean supportsBlockCheckpoint() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(63, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public boolean supportsFileCheckpoint() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(64, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void resetCheckpoint() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(65, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void earlyBootEnded() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(66, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public String createStubVolume(String sourcePath, String mountPath, String fsType, String fsUuid, String fsLabel, int flags) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(sourcePath);     // Catch: Throwable -> L6
                _data.writeString(mountPath);     // Catch: Throwable -> L6
                _data.writeString(fsType);     // Catch: Throwable -> L6
                _data.writeString(fsUuid);     // Catch: Throwable -> L6
                _data.writeString(fsLabel);     // Catch: Throwable -> L6
                _data.writeInt(flags);     // Catch: Throwable -> L6
                this.mRemote.transact(67, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void destroyStubVolume(String volId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(volId);     // Catch: Throwable -> L6
                this.mRemote.transact(68, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public FileDescriptor openAppFuseFile(int uid, int mountId, int fileId, int flags) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(uid);     // Catch: Throwable -> L6
                _data.writeInt(mountId);     // Catch: Throwable -> L6
                _data.writeInt(fileId);     // Catch: Throwable -> L6
                _data.writeInt(flags);     // Catch: Throwable -> L6
                this.mRemote.transact(69, _data, _reply, 32);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                FileDescriptor _result = _reply.readRawFileDescriptor();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IVold
            public boolean incFsEnabled() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(70, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public IncrementalFileSystemControlParcel mountIncFs(String backingPath, String targetDir, int flags, String sysfsName) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(backingPath);     // Catch: Throwable -> L6
                _data.writeString(targetDir);     // Catch: Throwable -> L6
                _data.writeInt(flags);     // Catch: Throwable -> L6
                _data.writeString(sysfsName);     // Catch: Throwable -> L6
                this.mRemote.transact(71, _data, _reply, 32);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                IncrementalFileSystemControlParcel _result = (IncrementalFileSystemControlParcel) _reply.readTypedObject(IncrementalFileSystemControlParcel.CREATOR);     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IVold
            public void unmountIncFs(String dir) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(dir);     // Catch: Throwable -> L6
                this.mRemote.transact(72, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void setIncFsMountOptions(IncrementalFileSystemControlParcel control, boolean enableReadLogs, boolean enableReadTimeouts, String sysfsName) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeTypedObject(control, 0);     // Catch: Throwable -> L6
                _data.writeBoolean(enableReadLogs);     // Catch: Throwable -> L6
                _data.writeBoolean(enableReadTimeouts);     // Catch: Throwable -> L6
                _data.writeString(sysfsName);     // Catch: Throwable -> L6
                this.mRemote.transact(73, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void bindMount(String sourceDir, String targetDir) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(sourceDir);     // Catch: Throwable -> L6
                _data.writeString(targetDir);     // Catch: Throwable -> L6
                this.mRemote.transact(74, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void destroyDsuMetadataKey(String dsuSlot) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(dsuSlot);     // Catch: Throwable -> L6
                this.mRemote.transact(75, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public long getStorageSize() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(76, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public int getStorageRemainingLifetime() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(77, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public int getWriteBoosterBufferSize() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(78, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public int getWriteBoosterBufferAvailablePercent() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(79, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public boolean setWriteBoosterBufferFlush(boolean enable) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeBoolean(enable);     // Catch: Throwable -> L6
                this.mRemote.transact(80, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public boolean setWriteBoosterBufferOn(boolean enable) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeBoolean(enable);     // Catch: Throwable -> L6
                this.mRemote.transact(81, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public int getWriteBoosterLifeTimeEstimate() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(82, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void serviceKeyInit(int serviceId, int userId, int uid, byte[] secret) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(serviceId);     // Catch: Throwable -> L6
                _data.writeInt(userId);     // Catch: Throwable -> L6
                _data.writeInt(uid);     // Catch: Throwable -> L6
                _data.writeByteArray(secret);     // Catch: Throwable -> L6
                this.mRemote.transact(83, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void serviceKeyDelete(int serviceId, int userId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(serviceId);     // Catch: Throwable -> L6
                _data.writeInt(userId);     // Catch: Throwable -> L6
                this.mRemote.transact(84, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void serviceLockStorage(int serviceId, int userId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(serviceId);     // Catch: Throwable -> L6
                _data.writeInt(userId);     // Catch: Throwable -> L6
                this.mRemote.transact(85, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void serviceUnlockStorage(int serviceId, int userId, byte[] secret) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(serviceId);     // Catch: Throwable -> L6
                _data.writeInt(userId);     // Catch: Throwable -> L6
                _data.writeByteArray(secret);     // Catch: Throwable -> L6
                this.mRemote.transact(86, _data, _reply, 32);     // Catch: Throwable -> L6
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

            @Override // android.os.IVold
            public void hypeholdIceEnable() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.markSensitive();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(87, _data, _reply, 32);     // Catch: Throwable -> L6
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
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IVold asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IVold) == false) goto L12;
            return (IVold) iin;
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
                case 1: goto L100;
                case 2: goto L99;
                case 3: goto L98;
                case 4: goto L97;
                case 5: goto L96;
                case 6: goto L95;
                case 7: goto L94;
                case 8: goto L93;
                case 9: goto L92;
                case 10: goto L91;
                case 11: goto L90;
                case 12: goto L89;
                case 13: goto L88;
                case 14: goto L87;
                case 15: goto L86;
                case 16: goto L85;
                case 17: goto L84;
                case 18: goto L83;
                case 19: goto L82;
                case 20: goto L81;
                case 21: goto L80;
                case 22: goto L79;
                case 23: goto L78;
                case 24: goto L77;
                case 25: goto L76;
                case 26: goto L75;
                case 27: goto L74;
                case 28: goto L73;
                case 29: goto L72;
                case 30: goto L71;
                case 31: goto L70;
                case 32: goto L69;
                case 33: goto L68;
                case 34: goto L67;
                case 35: goto L66;
                case 36: goto L65;
                case 37: goto L64;
                case 38: goto L63;
                case 39: goto L62;
                case 40: goto L61;
                case 41: goto L60;
                case 42: goto L59;
                case 43: goto L58;
                case 44: goto L57;
                case 45: goto L56;
                case 46: goto L55;
                case 47: goto L54;
                case 48: goto L53;
                case 49: goto L52;
                case 50: goto L51;
                case 51: goto L50;
                case 52: goto L49;
                case 53: goto L48;
                case 54: goto L47;
                case 55: goto L46;
                case 56: goto L45;
                case 57: goto L44;
                case 58: goto L43;
                case 59: goto L42;
                case 60: goto L41;
                case 61: goto L40;
                case 62: goto L39;
                case 63: goto L38;
                case 64: goto L37;
                case 65: goto L36;
                case 66: goto L35;
                case 67: goto L34;
                case 68: goto L33;
                case 69: goto L32;
                case 70: goto L31;
                case 71: goto L30;
                case 72: goto L29;
                case 73: goto L28;
                case 74: goto L27;
                case 75: goto L26;
                case 76: goto L25;
                case 77: goto L24;
                case 78: goto L23;
                case 79: goto L22;
                case 80: goto L21;
                case 81: goto L20;
                case 82: goto L19;
                case 83: goto L18;
                case 84: goto L17;
                case 85: goto L16;
                case 86: goto L15;
                case 87: goto L14;
                default: goto L13;
            };
        L14:
            hypeholdIceEnable();
            reply.writeNoException();
        L101:
            return true;
        L15:
            int _arg0 = data.readInt();
            int _arg1 = data.readInt();
            byte[] _arg2 = data.createByteArray();
            data.enforceNoDataAvail();
            serviceUnlockStorage(_arg0, _arg1, _arg2);
            reply.writeNoException();
            goto L101
        L16:
            int _arg3 = data.readInt();
            int _arg4 = data.readInt();
            data.enforceNoDataAvail();
            serviceLockStorage(_arg3, _arg4);
            reply.writeNoException();
            goto L101
        L17:
            int _arg5 = data.readInt();
            int _arg6 = data.readInt();
            data.enforceNoDataAvail();
            serviceKeyDelete(_arg5, _arg6);
            reply.writeNoException();
            goto L101
        L18:
            int _arg7 = data.readInt();
            int _arg8 = data.readInt();
            int _arg9 = data.readInt();
            byte[] _arg10 = data.createByteArray();
            data.enforceNoDataAvail();
            serviceKeyInit(_arg7, _arg8, _arg9, _arg10);
            reply.writeNoException();
            goto L101
        L19:
            int _result = getWriteBoosterLifeTimeEstimate();
            reply.writeNoException();
            reply.writeInt(_result);
            goto L101
        L20:
            boolean _arg11 = data.readBoolean();
            data.enforceNoDataAvail();
            boolean _result2 = setWriteBoosterBufferOn(_arg11);
            reply.writeNoException();
            reply.writeBoolean(_result2);
            goto L101
        L21:
            boolean _arg12 = data.readBoolean();
            data.enforceNoDataAvail();
            boolean _result3 = setWriteBoosterBufferFlush(_arg12);
            reply.writeNoException();
            reply.writeBoolean(_result3);
            goto L101
        L22:
            int _result4 = getWriteBoosterBufferAvailablePercent();
            reply.writeNoException();
            reply.writeInt(_result4);
            goto L101
        L23:
            int _result5 = getWriteBoosterBufferSize();
            reply.writeNoException();
            reply.writeInt(_result5);
            goto L101
        L24:
            int _result6 = getStorageRemainingLifetime();
            reply.writeNoException();
            reply.writeInt(_result6);
            goto L101
        L25:
            long _result7 = getStorageSize();
            reply.writeNoException();
            reply.writeLong(_result7);
            goto L101
        L26:
            String _arg13 = data.readString();
            data.enforceNoDataAvail();
            destroyDsuMetadataKey(_arg13);
            reply.writeNoException();
            goto L101
        L27:
            String _arg14 = data.readString();
            String _arg15 = data.readString();
            data.enforceNoDataAvail();
            bindMount(_arg14, _arg15);
            reply.writeNoException();
            goto L101
        L28:
            IncrementalFileSystemControlParcel _arg16 = (IncrementalFileSystemControlParcel) data.readTypedObject(IncrementalFileSystemControlParcel.CREATOR);
            boolean _arg17 = data.readBoolean();
            boolean _arg18 = data.readBoolean();
            String _arg19 = data.readString();
            data.enforceNoDataAvail();
            setIncFsMountOptions(_arg16, _arg17, _arg18, _arg19);
            reply.writeNoException();
            goto L101
        L29:
            String _arg20 = data.readString();
            data.enforceNoDataAvail();
            unmountIncFs(_arg20);
            reply.writeNoException();
            goto L101
        L30:
            String _arg21 = data.readString();
            String _arg22 = data.readString();
            int _arg23 = data.readInt();
            String _arg24 = data.readString();
            data.enforceNoDataAvail();
            IncrementalFileSystemControlParcel _result8 = mountIncFs(_arg21, _arg22, _arg23, _arg24);
            reply.writeNoException();
            reply.writeTypedObject(_result8, 1);
            goto L101
        L31:
            boolean _result9 = incFsEnabled();
            reply.writeNoException();
            reply.writeBoolean(_result9);
            goto L101
        L32:
            int _arg25 = data.readInt();
            int _arg26 = data.readInt();
            int _arg27 = data.readInt();
            int _arg28 = data.readInt();
            data.enforceNoDataAvail();
            FileDescriptor _result10 = openAppFuseFile(_arg25, _arg26, _arg27, _arg28);
            reply.writeNoException();
            reply.writeRawFileDescriptor(_result10);
            goto L101
        L33:
            String _arg29 = data.readString();
            data.enforceNoDataAvail();
            destroyStubVolume(_arg29);
            reply.writeNoException();
            goto L101
        L34:
            String _arg30 = data.readString();
            String _arg31 = data.readString();
            String _arg32 = data.readString();
            String _arg33 = data.readString();
            String _arg34 = data.readString();
            int _arg35 = data.readInt();
            data.enforceNoDataAvail();
            String _result11 = createStubVolume(_arg30, _arg31, _arg32, _arg33, _arg34, _arg35);
            reply.writeNoException();
            reply.writeString(_result11);
            goto L101
        L35:
            earlyBootEnded();
            reply.writeNoException();
            goto L101
        L36:
            resetCheckpoint();
            reply.writeNoException();
            goto L101
        L37:
            boolean _result12 = supportsFileCheckpoint();
            reply.writeNoException();
            reply.writeBoolean(_result12);
            goto L101
        L38:
            boolean _result13 = supportsBlockCheckpoint();
            reply.writeNoException();
            reply.writeBoolean(_result13);
            goto L101
        L39:
            boolean _result14 = supportsCheckpoint();
            reply.writeNoException();
            reply.writeBoolean(_result14);
            goto L101
        L40:
            markBootAttempt();
            reply.writeNoException();
            goto L101
        L41:
            String _arg36 = data.readString();
            int _arg37 = data.readInt();
            data.enforceNoDataAvail();
            restoreCheckpointPart(_arg36, _arg37);
            reply.writeNoException();
            goto L101
        L42:
            String _arg38 = data.readString();
            data.enforceNoDataAvail();
            restoreCheckpoint(_arg38);
            reply.writeNoException();
            goto L101
        L43:
            prepareCheckpoint();
            reply.writeNoException();
            goto L101
        L44:
            commitChanges();
            reply.writeNoException();
            goto L101
        L45:
            String _arg39 = data.readString();
            boolean _arg40 = data.readBoolean();
            data.enforceNoDataAvail();
            abortChanges(_arg39, _arg40);
            reply.writeNoException();
            goto L101
        L46:
            boolean _result15 = isCheckpointing();
            reply.writeNoException();
            reply.writeBoolean(_result15);
            goto L101
        L47:
            boolean _result16 = needsRollback();
            reply.writeNoException();
            reply.writeBoolean(_result16);
            goto L101
        L48:
            boolean _result17 = needsCheckpoint();
            reply.writeNoException();
            reply.writeBoolean(_result17);
            goto L101
        L49:
            int _arg41 = data.readInt();
            data.enforceNoDataAvail();
            startCheckpoint(_arg41);
            reply.writeNoException();
            goto L101
        L50:
            String _arg42 = data.readString();
            String _arg43 = data.readString();
            int _arg44 = data.readInt();
            data.enforceNoDataAvail();
            destroySandboxForApp(_arg42, _arg43, _arg44);
            reply.writeNoException();
            goto L101
        L51:
            String _arg45 = data.readString();
            int _arg46 = data.readInt();
            String _arg47 = data.readString();
            int _arg48 = data.readInt();
            data.enforceNoDataAvail();
            prepareSandboxForApp(_arg45, _arg46, _arg47, _arg48);
            reply.writeNoException();
            goto L101
        L52:
            String _arg49 = data.readString();
            int _arg50 = data.readInt();
            int _arg51 = data.readInt();
            data.enforceNoDataAvail();
            destroyUserStorage(_arg49, _arg50, _arg51);
            reply.writeNoException();
            goto L101
        L53:
            String _arg52 = data.readString();
            int _arg53 = data.readInt();
            int _arg54 = data.readInt();
            data.enforceNoDataAvail();
            prepareUserStorage(_arg52, _arg53, _arg54);
            reply.writeNoException();
            goto L101
        L54:
            int _arg55 = data.readInt();
            data.enforceNoDataAvail();
            lockCeStorage(_arg55);
            reply.writeNoException();
            goto L101
        L55:
            int _arg56 = data.readInt();
            byte[] _arg57 = data.createByteArray();
            data.enforceNoDataAvail();
            unlockCeStorage(_arg56, _arg57);
            reply.writeNoException();
            goto L101
        L56:
            int[] _result18 = getUnlockedUsers();
            reply.writeNoException();
            reply.writeIntArray(_result18);
            goto L101
        L57:
            int _arg58 = data.readInt();
            byte[] _arg59 = data.createByteArray();
            data.enforceNoDataAvail();
            setCeStorageProtection(_arg58, _arg59);
            reply.writeNoException();
            goto L101
        L58:
            int _arg60 = data.readInt();
            data.enforceNoDataAvail();
            destroyUserStorageKeys(_arg60);
            reply.writeNoException();
            goto L101
        L59:
            int _arg61 = data.readInt();
            boolean _arg62 = data.readBoolean();
            data.enforceNoDataAvail();
            createUserStorageKeys(_arg61, _arg62);
            reply.writeNoException();
            goto L101
        L60:
            byte[] _arg63 = data.createByteArray();
            data.enforceNoDataAvail();
            setStorageBindingSeed(_arg63);
            reply.writeNoException();
            goto L101
        L61:
            String _arg64 = data.readString();
            String _arg65 = data.readString();
            boolean _arg66 = data.readBoolean();
            String _arg67 = data.readString();
            boolean _arg68 = data.readBoolean();
            String[] _arg69 = data.createStringArray();
            boolean[] _arg70 = data.createBooleanArray();
            long _arg71 = data.readLong();
            data.enforceNoDataAvail();
            encryptFstab(_arg64, _arg65, _arg66, _arg67, _arg68, _arg69, _arg70, _arg71);
            reply.writeNoException();
            goto L101
        L62:
            String _arg72 = data.readString();
            String _arg73 = data.readString();
            boolean _arg74 = data.readBoolean();
            String[] _arg75 = data.createStringArray();
            data.enforceNoDataAvail();
            mountFstab(_arg72, _arg73, _arg74, _arg75);
            reply.writeNoException();
            goto L101
        L63:
            initUser0();
            reply.writeNoException();
            goto L101
        L64:
            fbeEnable();
            reply.writeNoException();
            goto L101
        L65:
            int _arg76 = data.readInt();
            int _arg77 = data.readInt();
            data.enforceNoDataAvail();
            unmountAppFuse(_arg76, _arg77);
            reply.writeNoException();
            goto L101
        L66:
            int _arg78 = data.readInt();
            int _arg79 = data.readInt();
            data.enforceNoDataAvail();
            FileDescriptor _result19 = mountAppFuse(_arg78, _arg79);
            reply.writeNoException();
            reply.writeRawFileDescriptor(_result19);
            goto L101
        L67:
            int _result20 = getWriteAmount();
            reply.writeNoException();
            reply.writeInt(_result20);
            goto L101
        L68:
            refreshLatestWrite();
            reply.writeNoException();
            goto L101
        L69:
            int _arg80 = data.readInt();
            int _arg81 = data.readInt();
            float _arg82 = data.readFloat();
            float _arg83 = data.readFloat();
            int _arg84 = data.readInt();
            int _arg85 = data.readInt();
            int _arg86 = data.readInt();
            data.enforceNoDataAvail();
            setGCUrgentPace(_arg80, _arg81, _arg82, _arg83, _arg84, _arg85, _arg86);
            reply.writeNoException();
            goto L101
        L70:
            int _result21 = getStorageLifeTime();
            reply.writeNoException();
            reply.writeInt(_result21);
            goto L101
        L71:
            IVoldTaskListener _arg87 = IVoldTaskListener.Stub.asInterface(data.readStrongBinder());
            data.enforceNoDataAvail();
            abortIdleMaint(_arg87);
            reply.writeNoException();
            goto L101
        L72:
            boolean _arg88 = data.readBoolean();
            IVoldTaskListener _arg89 = IVoldTaskListener.Stub.asInterface(data.readStrongBinder());
            data.enforceNoDataAvail();
            runIdleMaint(_arg88, _arg89);
            reply.writeNoException();
            goto L101
        L73:
            int _arg90 = data.readInt();
            IVoldTaskListener _arg91 = IVoldTaskListener.Stub.asInterface(data.readStrongBinder());
            data.enforceNoDataAvail();
            fstrim(_arg90, _arg91);
            reply.writeNoException();
            goto L101
        L74:
            String _arg92 = data.readString();
            data.enforceNoDataAvail();
            destroyObb(_arg92);
            reply.writeNoException();
            goto L101
        L75:
            String _arg93 = data.readString();
            int _arg94 = data.readInt();
            data.enforceNoDataAvail();
            String _result22 = createObb(_arg93, _arg94);
            reply.writeNoException();
            reply.writeString(_result22);
            goto L101
        L76:
            String[] _arg95 = data.createStringArray();
            int _arg96 = data.readInt();
            data.enforceNoDataAvail();
            ensureAppDirsCreated(_arg95, _arg96);
            reply.writeNoException();
            goto L101
        L77:
            String _arg97 = data.readString();
            int _arg98 = data.readInt();
            data.enforceNoDataAvail();
            fixupAppDir(_arg97, _arg98);
            reply.writeNoException();
            goto L101
        L78:
            String _arg99 = data.readString();
            int _arg100 = data.readInt();
            data.enforceNoDataAvail();
            setupAppDir(_arg99, _arg100);
            reply.writeNoException();
            goto L101
        L79:
            int _arg101 = data.readInt();
            int _arg102 = data.readInt();
            String[] _arg103 = data.createStringArray();
            data.enforceNoDataAvail();
            unmountAppStorageDirs(_arg101, _arg102, _arg103);
            reply.writeNoException();
            goto L101
        L80:
            int _arg104 = data.readInt();
            int _arg105 = data.readInt();
            String[] _arg106 = data.createStringArray();
            data.enforceNoDataAvail();
            remountAppStorageDirs(_arg104, _arg105, _arg106);
            reply.writeNoException();
            goto L101
        L81:
            int _arg107 = data.readInt();
            int _arg108 = data.readInt();
            data.enforceNoDataAvail();
            remountUid(_arg107, _arg108);
            reply.writeNoException();
            goto L101
        L82:
            String _arg109 = data.readString();
            String _arg110 = data.readString();
            IVoldTaskListener _arg111 = IVoldTaskListener.Stub.asInterface(data.readStrongBinder());
            data.enforceNoDataAvail();
            moveStorage(_arg109, _arg110, _arg111);
            reply.writeNoException();
            goto L101
        L83:
            String _arg112 = data.readString();
            IVoldTaskListener _arg113 = IVoldTaskListener.Stub.asInterface(data.readStrongBinder());
            data.enforceNoDataAvail();
            benchmark(_arg112, _arg113);
            reply.writeNoException();
            goto L101
        L84:
            String _arg114 = data.readString();
            String _arg115 = data.readString();
            data.enforceNoDataAvail();
            format(_arg114, _arg115);
            reply.writeNoException();
            goto L101
        L85:
            String _arg116 = data.readString();
            data.enforceNoDataAvail();
            unmount(_arg116);
            reply.writeNoException();
            goto L101
        L86:
            String _arg117 = data.readString();
            int _arg118 = data.readInt();
            int _arg119 = data.readInt();
            IVoldMountCallback _arg120 = IVoldMountCallback.Stub.asInterface(data.readStrongBinder());
            data.enforceNoDataAvail();
            mount(_arg117, _arg118, _arg119, _arg120);
            reply.writeNoException();
            goto L101
        L87:
            String _arg121 = data.readString();
            String _arg122 = data.readString();
            data.enforceNoDataAvail();
            forgetPartition(_arg121, _arg122);
            reply.writeNoException();
            goto L101
        L88:
            String _arg123 = data.readString();
            int _arg124 = data.readInt();
            int _arg125 = data.readInt();
            data.enforceNoDataAvail();
            partition(_arg123, _arg124, _arg125);
            reply.writeNoException();
            goto L101
        L89:
            boolean _arg126 = data.readBoolean();
            data.enforceNoDataAvail();
            onSecureKeyguardStateChanged(_arg126);
            reply.writeNoException();
            goto L101
        L90:
            int[] _arg127 = data.createIntArray();
            String[] _arg128 = data.createStringArray();
            data.enforceNoDataAvail();
            addSandboxIds(_arg127, _arg128);
            reply.writeNoException();
            goto L101
        L91:
            String[] _arg129 = data.createStringArray();
            int[] _arg130 = data.createIntArray();
            data.enforceNoDataAvail();
            addAppIds(_arg129, _arg130);
            reply.writeNoException();
            goto L101
        L92:
            int _arg131 = data.readInt();
            data.enforceNoDataAvail();
            onUserStopped(_arg131);
            reply.writeNoException();
            goto L101
        L93:
            int _arg132 = data.readInt();
            data.enforceNoDataAvail();
            onUserStarted(_arg132);
            reply.writeNoException();
            goto L101
        L94:
            int _arg133 = data.readInt();
            data.enforceNoDataAvail();
            onUserRemoved(_arg133);
            reply.writeNoException();
            goto L101
        L95:
            int _arg134 = data.readInt();
            int _arg135 = data.readInt();
            int _arg136 = data.readInt();
            data.enforceNoDataAvail();
            onUserAdded(_arg134, _arg135, _arg136);
            reply.writeNoException();
            goto L101
        L96:
            shutdown();
            reply.writeNoException();
            goto L101
        L97:
            reset();
            reply.writeNoException();
            goto L101
        L98:
            monitor();
            reply.writeNoException();
            goto L101
        L99:
            abortFuse();
            reply.writeNoException();
            goto L101
        L100:
            IVoldListener _arg137 = IVoldListener.Stub.asInterface(data.readStrongBinder());
            data.enforceNoDataAvail();
            setListener(_arg137);
            reply.writeNoException();
            goto L101
        L13:
            return super.onTransact(code, data, reply, flags);
        }
    }

    void abortChanges(String r1, boolean r2) throws RemoteException;

    void abortFuse() throws RemoteException;

    void abortIdleMaint(IVoldTaskListener r1) throws RemoteException;

    void addAppIds(String[] r1, int[] r2) throws RemoteException;

    void addSandboxIds(int[] r1, String[] r2) throws RemoteException;

    void benchmark(String r1, IVoldTaskListener r2) throws RemoteException;

    void bindMount(String r1, String r2) throws RemoteException;

    void commitChanges() throws RemoteException;

    String createObb(String r1, int r2) throws RemoteException;

    String createStubVolume(String r1, String r2, String r3, String r4, String r5, int r6) throws RemoteException;

    void createUserStorageKeys(int r1, boolean r2) throws RemoteException;

    void destroyDsuMetadataKey(String r1) throws RemoteException;

    void destroyObb(String r1) throws RemoteException;

    void destroySandboxForApp(String r1, String r2, int r3) throws RemoteException;

    void destroyStubVolume(String r1) throws RemoteException;

    void destroyUserStorage(String r1, int r2, int r3) throws RemoteException;

    void destroyUserStorageKeys(int r1) throws RemoteException;

    void earlyBootEnded() throws RemoteException;

    void encryptFstab(String r1, String r2, boolean r3, String r4, boolean r5, String[] r6, boolean[] r7, long r8) throws RemoteException;

    void ensureAppDirsCreated(String[] r1, int r2) throws RemoteException;

    void fbeEnable() throws RemoteException;

    void fixupAppDir(String r1, int r2) throws RemoteException;

    void forgetPartition(String r1, String r2) throws RemoteException;

    void format(String r1, String r2) throws RemoteException;

    void fstrim(int r1, IVoldTaskListener r2) throws RemoteException;

    int getStorageLifeTime() throws RemoteException;

    int getStorageRemainingLifetime() throws RemoteException;

    long getStorageSize() throws RemoteException;

    int[] getUnlockedUsers() throws RemoteException;

    int getWriteAmount() throws RemoteException;

    int getWriteBoosterBufferAvailablePercent() throws RemoteException;

    int getWriteBoosterBufferSize() throws RemoteException;

    int getWriteBoosterLifeTimeEstimate() throws RemoteException;

    void hypeholdIceEnable() throws RemoteException;

    boolean incFsEnabled() throws RemoteException;

    void initUser0() throws RemoteException;

    boolean isCheckpointing() throws RemoteException;

    void lockCeStorage(int r1) throws RemoteException;

    void markBootAttempt() throws RemoteException;

    void monitor() throws RemoteException;

    void mount(String r1, int r2, int r3, IVoldMountCallback r4) throws RemoteException;

    FileDescriptor mountAppFuse(int r1, int r2) throws RemoteException;

    void mountFstab(String r1, String r2, boolean r3, String[] r4) throws RemoteException;

    IncrementalFileSystemControlParcel mountIncFs(String r1, String r2, int r3, String r4) throws RemoteException;

    void moveStorage(String r1, String r2, IVoldTaskListener r3) throws RemoteException;

    boolean needsCheckpoint() throws RemoteException;

    boolean needsRollback() throws RemoteException;

    void onSecureKeyguardStateChanged(boolean r1) throws RemoteException;

    void onUserAdded(int r1, int r2, int r3) throws RemoteException;

    void onUserRemoved(int r1) throws RemoteException;

    void onUserStarted(int r1) throws RemoteException;

    void onUserStopped(int r1) throws RemoteException;

    FileDescriptor openAppFuseFile(int r1, int r2, int r3, int r4) throws RemoteException;

    void partition(String r1, int r2, int r3) throws RemoteException;

    void prepareCheckpoint() throws RemoteException;

    void prepareSandboxForApp(String r1, int r2, String r3, int r4) throws RemoteException;

    void prepareUserStorage(String r1, int r2, int r3) throws RemoteException;

    void refreshLatestWrite() throws RemoteException;

    void remountAppStorageDirs(int r1, int r2, String[] r3) throws RemoteException;

    void remountUid(int r1, int r2) throws RemoteException;

    void reset() throws RemoteException;

    void resetCheckpoint() throws RemoteException;

    void restoreCheckpoint(String r1) throws RemoteException;

    void restoreCheckpointPart(String r1, int r2) throws RemoteException;

    void runIdleMaint(boolean r1, IVoldTaskListener r2) throws RemoteException;

    void serviceKeyDelete(int r1, int r2) throws RemoteException;

    void serviceKeyInit(int r1, int r2, int r3, byte[] r4) throws RemoteException;

    void serviceLockStorage(int r1, int r2) throws RemoteException;

    void serviceUnlockStorage(int r1, int r2, byte[] r3) throws RemoteException;

    void setCeStorageProtection(int r1, byte[] r2) throws RemoteException;

    void setGCUrgentPace(int r1, int r2, float r3, float r4, int r5, int r6, int r7) throws RemoteException;

    void setIncFsMountOptions(IncrementalFileSystemControlParcel r1, boolean r2, boolean r3, String r4) throws RemoteException;

    void setListener(IVoldListener r1) throws RemoteException;

    void setStorageBindingSeed(byte[] r1) throws RemoteException;

    boolean setWriteBoosterBufferFlush(boolean r1) throws RemoteException;

    boolean setWriteBoosterBufferOn(boolean r1) throws RemoteException;

    void setupAppDir(String r1, int r2) throws RemoteException;

    void shutdown() throws RemoteException;

    void startCheckpoint(int r1) throws RemoteException;

    boolean supportsBlockCheckpoint() throws RemoteException;

    boolean supportsCheckpoint() throws RemoteException;

    boolean supportsFileCheckpoint() throws RemoteException;

    void unlockCeStorage(int r1, byte[] r2) throws RemoteException;

    void unmount(String r1) throws RemoteException;

    void unmountAppFuse(int r1, int r2) throws RemoteException;

    void unmountAppStorageDirs(int r1, int r2, String[] r3) throws RemoteException;

    void unmountIncFs(String r1) throws RemoteException;
}
