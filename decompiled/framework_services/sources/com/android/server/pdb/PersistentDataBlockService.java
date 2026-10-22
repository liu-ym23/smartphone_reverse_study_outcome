package com.android.server.pdb;

import android.R;
import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.hardware.tv.mediaquality.ParameterName;
import android.os.Binder;
import android.os.Debug;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ShellCallback;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import android.service.persistentdata.IPersistentDataBlockService;
import android.text.TextUtils;
import android.util.Slog;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.Preconditions;
import com.android.server.LocalServices;
import com.android.server.SysDataSyncServiceManager;
import com.android.server.SystemServerInitThreadPool;
import com.android.server.SystemService;
import com.android.server.am.ProcessList;
import com.android.server.job.controllers.JobStatus;
import com.android.server.pm.UserManagerInternal;
import com.android.server.slice.SliceClientPermissions;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HexFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import libcore.io.IoUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class PersistentDataBlockService extends SystemService {
    public static final String BOOTLOADER_LOCK_STATE = "ro.boot.vbmeta.device_state";
    public static final int DIGEST_SIZE_BYTES = 32;
    private static final String FLASH_LOCK_LOCKED = "1";
    private static final String FLASH_LOCK_PROP = "ro.boot.flash.locked";
    private static final String FLASH_LOCK_UNLOCKED = "0";
    static final int FRP_CREDENTIAL_RESERVED_SIZE = 1000;
    private static final String FRP_SECRET_FILE = "/data/system/frp_secret";
    static final byte[] FRP_SECRET_MAGIC = null;
    static final int FRP_SECRET_SIZE = 32;
    private static final String FRP_SECRET_TMP_FILE = "/data/system/frp_secret_tmp";
    private static final String GSI_RUNNING_PROP = "ro.gsid.image_running";
    private static final String GSI_SANDBOX = "/data/gsi_persistent_data";
    static final int HEADER_SIZE = 8;
    public static final int INIT_WAIT_TIMEOUT = 10;
    static final int MAX_DATA_BLOCK_SIZE = 102400;
    static final int MAX_FRP_CREDENTIAL_HANDLE_SIZE = 996;
    static final int MAX_TEST_MODE_DATA_SIZE = 9996;
    private static final int PARTITION_TYPE_MARKER = 428873843;
    private static final String PERSISTENT_DATA_BLOCK_PROP = "ro.frp.pst";
    private static final String TAG = null;
    static final int TEST_MODE_RESERVED_SIZE = 10000;
    public static final String VERIFIED_BOOT_STATE = "ro.boot.verifiedbootstate";
    private int mAllowedUid;
    private long mBlockDeviceSize;
    private final Context mContext;
    private final String mDataBlockFile;
    private boolean mFrpActive;
    private final boolean mFrpEnforced;
    private final String mFrpSecretFile;
    private final String mFrpSecretTmpFile;
    private final CountDownLatch mInitDoneSignal;
    private InternalService mInternalService;
    private final boolean mIsFileBacked;
    private boolean mIsWritable;
    private final Object mLock;
    private final IBinder mService;

    /* JADX INFO: renamed from: com.android.server.pdb.PersistentDataBlockService$2, reason: invalid class name */
    class AnonymousClass2 extends IPersistentDataBlockService.Stub {
        final /* synthetic */ PersistentDataBlockService this$0;

        /* JADX INFO: renamed from: -$$Nest$mprintFrpStatus, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m6488$$Nest$mprintFrpStatus(AnonymousClass2 r0, PrintWriter r1, boolean r2) {
            return r0.printFrpStatus(r1, r2);
        }

        AnonymousClass2(PersistentDataBlockService this$0) {
            this.this$0 = this$0;
        }

        private int printFrpStatus(PrintWriter pw, boolean printSecrets) {
            PersistentDataBlockService.m6476$$Nest$menforceUid(this.this$0, Binder.getCallingUid(), !printSecrets);
            pw.println("FRP state");
            pw.println("=========");
            pw.println("Enforcement enabled: " + PersistentDataBlockService.m6453$$Nest$fgetmFrpEnforced(this.this$0));
            pw.println("FRP state: " + PersistentDataBlockService.m6452$$Nest$fgetmFrpActive(this.this$0));
            printFrpDataFilesContents(pw, printSecrets);
            printFrpSecret(pw, printSecrets);
            if (Binder.getCallingUid() == 2000) goto L5;
            pw.println("OEM unlock state: " + getOemUnlockEnabled());
            pw.println("Bootloader lock state: " + getFlashLockState());
        L5:
            pw.println("Verified boot state: " + getVerifiedBootState());
            pw.println("Has FRP credential handle: " + hasFrpCredentialHandle());
            pw.println("FRP challenge block size: " + getDataBlockSize());
            return 1;
        }

        private void printFrpSecret(PrintWriter pw, boolean printSecret) {
            if (PersistentDataBlockService.m6480$$Nest$mhasFrpSecretMagic(this.this$0) == false) goto L7;
            if (printSecret == false) goto L6;
            pw.println("FRP secret in PDB: " + HexFormat.of().formatHex(this.this$0.readDataBlock(this.this$0.getFrpSecretDataOffset(), 32)));
            return;
        L6:
            pw.println("FRP secret present but omitted.");
            return;
        L7:
            pw.println("FRP magic not found");
        }

        private void printFrpDataFilesContents(PrintWriter pw, boolean printSecrets) {
            printFrpDataFileContents(pw, PersistentDataBlockService.m6454$$Nest$fgetmFrpSecretFile(this.this$0), printSecrets);
            printFrpDataFileContents(pw, PersistentDataBlockService.m6455$$Nest$fgetmFrpSecretTmpFile(this.this$0), printSecrets);
        }

        private void printFrpDataFileContents(PrintWriter pw, String frpSecretFile, boolean printSecret) {
            if (Files.exists(Paths.get(frpSecretFile, new String[0]), new LinkOption[0]) == false) goto L13;
            if (printSecret == true) goto L11;
            pw.println("FRP secret file " + frpSecretFile + " exists, contents omitted.");
            return;
        L11:
            pw.println("FRP secret in " + frpSecretFile + ": " + HexFormat.of().formatHex(Files.readAllBytes(Paths.get(frpSecretFile, new String[0]))));     // Catch: IOException -> L7
            return;
        L7:
            e = move-exception;
            Slog.e(PersistentDataBlockService.m6487$$Nest$sfgetTAG(), "Failed to read " + frpSecretFile, e);
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) throws RemoteException {
            if (PersistentDataBlockService.m6453$$Nest$fgetmFrpEnforced(this.this$0) == true) goto L6;
            super.onShellCommand(in, out, err, args, callback, resultReceiver);
            return;
        L6:
            new AnonymousClass1(this).exec(this, in, out, err, args, callback, resultReceiver);
        }

        public int write(byte[] data) throws RemoteException {
            PersistentDataBlockService.m6475$$Nest$menforceUid(this.this$0, Binder.getCallingUid());
            long maxBlockSize = PersistentDataBlockService.m6466$$Nest$mdoGetMaximumDataBlockSize(this.this$0);
            if (data.length > maxBlockSize) goto L5;
            ByteBuffer headerAndData = ByteBuffer.allocate((data.length + 8) + 32);
            headerAndData.put(new byte[32]);
            headerAndData.putInt(PersistentDataBlockService.PARTITION_TYPE_MARKER);
            headerAndData.putInt(data.length);
            headerAndData.put(data);
            headerAndData.flip();
            Object r3 = PersistentDataBlockService.m6460$$Nest$fgetmLock(this.this$0);
            monitor-enter(r3);
        L12:
            th = move-exception;
            throw th;
        L9:
            if (PersistentDataBlockService.m6459$$Nest$fgetmIsWritable(this.this$0) == true) goto L40;
            monitor-exit(r3);     // Catch: Throwable -> L12
            return -1;
        L40:
            FileChannel channel = PersistentDataBlockService.m6478$$Nest$mgetBlockOutputChannel(this.this$0);     // Catch: Throwable -> L12 IOException -> L24
            channel.write(headerAndData);     // Catch: Throwable -> L26
            channel.force(true);     // Catch: Throwable -> L26
            channel.close();     // Catch: Throwable -> L12 IOException -> L24
            if (PersistentDataBlockService.m6464$$Nest$mcomputeAndWriteDigestLocked(this.this$0) == false) goto L22;
            int r4 = data.length;     // Catch: Throwable -> L12
            monitor-exit(r3);     // Catch: Throwable -> L12
            return r4;
        L22:
            monitor-exit(r3);     // Catch: Throwable -> L12
            return -1;
        L26:
            th = move-exception;
            if (channel != null) goto L41;
        L33:
            throw th;     // Catch: Throwable -> L12 IOException -> L24
        L41:
            channel.close();     // Catch: Throwable -> L30
        L30:
            th = move-exception;
            th.addSuppressed(th);     // Catch: Throwable -> L12 IOException -> L24
        L24:
            e = move-exception;
            Slog.e(PersistentDataBlockService.m6487$$Nest$sfgetTAG(), "failed writing to the persistent data block", e);     // Catch: Throwable -> L12
            return -1;
        L5:
            return (int) (-maxBlockSize);
        }

        public byte[] read() {
            PersistentDataBlockService.m6475$$Nest$menforceUid(this.this$0, Binder.getCallingUid());
            if (PersistentDataBlockService.m6469$$Nest$menforceChecksumValidity(this.this$0) == true) goto L57;
            return new byte[0];
        L57:
            DataInputStream inputStream = new DataInputStream(new FileInputStream(new File(PersistentDataBlockService.m6451$$Nest$fgetmDataBlockFile(this.this$0))));     // Catch: FileNotFoundException -> L52
            Object r3 = PersistentDataBlockService.m6460$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L38 IOException -> L40
            monitor-enter(r3);     // Catch: Throwable -> L38 IOException -> L40
            int totalDataSize = PersistentDataBlockService.m6479$$Nest$mgetTotalDataSizeLocked(this.this$0, inputStream);     // Catch: Throwable -> L19
            if (totalDataSize != 0) goto L21;
            byte[] r1 = new byte[0];     // Catch: Throwable -> L19
            monitor-exit(r3);     // Catch: Throwable -> L19
            inputStream.close();     // Catch: IOException -> L16
        L18:
            return r1;
        L17:
            Slog.e(PersistentDataBlockService.m6487$$Nest$sfgetTAG(), "failed to close OutputStream");
            goto L18
        L21:
            byte[] data = new byte[totalDataSize];     // Catch: Throwable -> L19
            int read = inputStream.read(data, 0, totalDataSize);     // Catch: Throwable -> L19
            if (read >= totalDataSize) goto L30;
            Slog.e(PersistentDataBlockService.m6487$$Nest$sfgetTAG(), "failed to read entire data block. bytes read: " + read + SliceClientPermissions.SliceAuthority.DELIMITER + totalDataSize);     // Catch: Throwable -> L19
            monitor-exit(r3);     // Catch: Throwable -> L19
            inputStream.close();     // Catch: IOException -> L27
        L29:
            return null;
        L28:
            Slog.e(PersistentDataBlockService.m6487$$Nest$sfgetTAG(), "failed to close OutputStream");
            goto L29
        L30:
            monitor-exit(r3);     // Catch: Throwable -> L19
            inputStream.close();     // Catch: IOException -> L33
        L35:
            return data;
        L34:
            Slog.e(PersistentDataBlockService.m6487$$Nest$sfgetTAG(), "failed to close OutputStream");
        L19:
            th = move-exception;
            throw th;     // Catch: Throwable -> L38 IOException -> L40
        L40:
            e = move-exception;
            Slog.e(PersistentDataBlockService.m6487$$Nest$sfgetTAG(), "failed to read data", e);     // Catch: Throwable -> L38
            inputStream.close();     // Catch: IOException -> L44
        L46:
            return null;
        L45:
            Slog.e(PersistentDataBlockService.m6487$$Nest$sfgetTAG(), "failed to close OutputStream");
        L52:
            e = move-exception;
            Slog.e(PersistentDataBlockService.m6487$$Nest$sfgetTAG(), "partition not available?", e);
            return null;
        L38:
            th = move-exception;
            inputStream.close();     // Catch: IOException -> L49
        L51:
            throw th;
        L50:
            Slog.e(PersistentDataBlockService.m6487$$Nest$sfgetTAG(), "failed to close OutputStream");
            goto L51
        }

        public void wipe() {
            PersistentDataBlockService.m6471$$Nest$menforceFactoryResetProtectionInactive(this.this$0);
            PersistentDataBlockService.m6474$$Nest$menforceOemUnlockWritePermission(this.this$0);
            Object r0 = PersistentDataBlockService.m6460$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L6:
            if (PersistentDataBlockService.m6458$$Nest$fgetmIsFileBacked(this.this$0) == true) goto L22;
            int ret = PersistentDataBlockService.m6482$$Nest$mnativeWipe(this.this$0, PersistentDataBlockService.m6451$$Nest$fgetmDataBlockFile(this.this$0));     // Catch: Throwable -> L10
        L15:
            if (ret >= 0) goto L17;
            Slog.e(PersistentDataBlockService.m6487$$Nest$sfgetTAG(), "failed to wipe persistent partition");     // Catch: Throwable -> L10
        L18:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L17:
            PersistentDataBlockService.m6463$$Nest$fputmIsWritable(this.this$0, false);     // Catch: Throwable -> L10
            Slog.i(PersistentDataBlockService.m6487$$Nest$sfgetTAG(), "persistent partition now wiped and unwritable");     // Catch: Throwable -> L10
            goto L18
        L22:
            Files.write(Paths.get(PersistentDataBlockService.m6451$$Nest$fgetmDataBlockFile(this.this$0), new String[0]), new byte[PersistentDataBlockService.MAX_DATA_BLOCK_SIZE], new OpenOption[]{StandardOpenOption.TRUNCATE_EXISTING});     // Catch: Throwable -> L10 IOException -> L12
            ret = 0;
        L13:
            ret = -1;
            goto L15
        }

        public void setOemUnlockEnabled(boolean enabled) throws SecurityException {
            if (ActivityManager.isUserAMonkey() == false) goto L5;
            return;
        L5:
            PersistentDataBlockService.m6474$$Nest$menforceOemUnlockWritePermission(this.this$0);
            PersistentDataBlockService.m6472$$Nest$menforceIsAdmin(this.this$0);
            if (enabled == false) goto L8;
            PersistentDataBlockService.m6477$$Nest$menforceUserRestriction(this.this$0, "no_oem_unlock");
            PersistentDataBlockService.m6477$$Nest$menforceUserRestriction(this.this$0, "no_factory_reset");
        L8:
            Object r0 = PersistentDataBlockService.m6460$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            PersistentDataBlockService.m6468$$Nest$mdoSetOemUnlockEnabledLocked(this.this$0, enabled);     // Catch: Throwable -> L13
            PersistentDataBlockService.m6464$$Nest$mcomputeAndWriteDigestLocked(this.this$0);     // Catch: Throwable -> L13
            monitor-exit(r0);     // Catch: Throwable -> L13
            return;
        L13:
            th = move-exception;
            throw th;
        }

        public boolean getOemUnlockEnabled() {
            PersistentDataBlockService.m6473$$Nest$menforceOemUnlockReadPermission(this.this$0);
            return PersistentDataBlockService.m6467$$Nest$mdoGetOemUnlockEnabled(this.this$0);
        }

        public int getFlashLockState() {
            PersistentDataBlockService.m6473$$Nest$menforceOemUnlockReadPermission(this.this$0);
            String locked = SystemProperties.get(PersistentDataBlockService.FLASH_LOCK_PROP);
            switch(locked.hashCode()) {
                case 48: goto L9;
                case 49: goto L6;
                default: goto L11;
            };
        L11:
            byte r1 = -1;
        L12:
            switch(r1) {
                case 0: goto L15;
                case 1: goto L14;
                default: goto L13;
            };
        L13:
            return -1;
        L14:
            return 0;
        L15:
            return 1;
        L6:
            if (locked.equals(PersistentDataBlockService.FLASH_LOCK_LOCKED) == false) goto L16;
            r1 = 0;
            goto L12
        L16:
            r1 = -1;
            goto L12
        L9:
            if (locked.equals(PersistentDataBlockService.FLASH_LOCK_UNLOCKED) == false) goto L17;
            r1 = 1;
            goto L12
        L17:
            r1 = -1;
            goto L12
        }

        private static String getVerifiedBootState() {
            return SystemProperties.get(PersistentDataBlockService.VERIFIED_BOOT_STATE);
        }

        public int getDataBlockSize() {
            enforcePersistentDataBlockAccess();
            DataInputStream inputStream = new DataInputStream(new FileInputStream(new File(PersistentDataBlockService.m6451$$Nest$fgetmDataBlockFile(this.this$0))));     // Catch: FileNotFoundException -> L21
            Object r2 = PersistentDataBlockService.m6460$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L13 IOException -> L15
            monitor-enter(r2);     // Catch: Throwable -> L13 IOException -> L15
            int r3 = PersistentDataBlockService.m6479$$Nest$mgetTotalDataSizeLocked(this.this$0, inputStream);     // Catch: Throwable -> L10
            monitor-exit(r2);     // Catch: Throwable -> L10
            IoUtils.closeQuietly(inputStream);
            return r3;
        L10:
            th = move-exception;
            throw th;     // Catch: Throwable -> L13 IOException -> L15
        L13:
            th = move-exception;
            IoUtils.closeQuietly(inputStream);
            throw th;
        L16:
            Slog.e(PersistentDataBlockService.m6487$$Nest$sfgetTAG(), "error reading data block size");     // Catch: Throwable -> L13
            IoUtils.closeQuietly(inputStream);
            return 0;
        L22:
            Slog.e(PersistentDataBlockService.m6487$$Nest$sfgetTAG(), "partition not available");
            return 0;
        }

        private void enforcePersistentDataBlockAccess() {
            if (PersistentDataBlockService.m6450$$Nest$fgetmContext(this.this$0).checkCallingPermission("android.permission.ACCESS_PDB_STATE") == 0) goto L6;
            PersistentDataBlockService.m6475$$Nest$menforceUid(this.this$0, Binder.getCallingUid());
            return;
        }

        private void enforceConfigureFrpPermissionOrPersistentDataBlockAccess() {
            if (PersistentDataBlockService.m6453$$Nest$fgetmFrpEnforced(this.this$0) == true) goto L6;
            enforcePersistentDataBlockAccess();
            return;
        L6:
            if (PersistentDataBlockService.m6450$$Nest$fgetmContext(this.this$0).checkCallingOrSelfPermission("android.permission.CONFIGURE_FACTORY_RESET_PROTECTION") != (-1)) goto L10;
            enforcePersistentDataBlockAccess();
            return;
        }

        public long getMaximumDataBlockSize() {
            PersistentDataBlockService.m6475$$Nest$menforceUid(this.this$0, Binder.getCallingUid());
            return PersistentDataBlockService.m6466$$Nest$mdoGetMaximumDataBlockSize(this.this$0);
        }

        public boolean hasFrpCredentialHandle() {
            enforceConfigureFrpPermissionOrPersistentDataBlockAccess();
            if (PersistentDataBlockService.m6457$$Nest$fgetmInternalService(this.this$0).getFrpCredentialHandle() == null) goto L6;
            return true;
        L6:
            return false;
        L8:
            e = move-exception;
            Slog.e(PersistentDataBlockService.m6487$$Nest$sfgetTAG(), "error reading frp handle", e);
            throw new UnsupportedOperationException("cannot read frp credential");
        }

        public String getPersistentDataPackageName() {
            enforcePersistentDataBlockAccess();
            return PersistentDataBlockService.m6450$$Nest$fgetmContext(this.this$0).getString(R.string.config_usbAccessoryUriActivity);
        }

        protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
            if (DumpUtils.checkDumpPermission(PersistentDataBlockService.m6450$$Nest$fgetmContext(this.this$0), PersistentDataBlockService.m6487$$Nest$sfgetTAG(), pw) == true) goto L5;
            return;
        L5:
            pw.println("mDataBlockFile: " + PersistentDataBlockService.m6451$$Nest$fgetmDataBlockFile(this.this$0));
            pw.println("mIsFileBacked: " + PersistentDataBlockService.m6458$$Nest$fgetmIsFileBacked(this.this$0));
            pw.println("mInitDoneSignal: " + PersistentDataBlockService.m6456$$Nest$fgetmInitDoneSignal(this.this$0));
            pw.println("mAllowedUid: " + PersistentDataBlockService.m6448$$Nest$fgetmAllowedUid(this.this$0));
            pw.println("mBlockDeviceSize: " + PersistentDataBlockService.m6449$$Nest$fgetmBlockDeviceSize(this.this$0));
            Object r0 = PersistentDataBlockService.m6460$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            pw.println("mIsWritable: " + PersistentDataBlockService.m6459$$Nest$fgetmIsWritable(this.this$0));     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            printFrpStatus(pw, false);
            return;
        L11:
            th = move-exception;
            throw th;
        }

        public boolean isFactoryResetProtectionActive() {
            return this.this$0.isFrpActive();
        }

        public boolean deactivateFactoryResetProtection(byte[] secret) {
            PersistentDataBlockService.m6470$$Nest$menforceConfigureFrpPermission(this.this$0);
            return PersistentDataBlockService.m6465$$Nest$mdeactivateFrp(this.this$0, secret);
        }

        public boolean setFactoryResetProtectionSecret(byte[] secret) {
            PersistentDataBlockService.m6470$$Nest$menforceConfigureFrpPermission(this.this$0);
            PersistentDataBlockService.m6475$$Nest$menforceUid(this.this$0, Binder.getCallingUid());
            if (secret == null) goto L13;
            if (secret.length != 32) goto L13;
            if (Binder.getCallingUid() != PersistentDataBlockService.m6448$$Nest$fgetmAllowedUid(this.this$0)) goto L10;
            return true;
        L10:
            PersistentDataBlockService.m6483$$Nest$mreportSetFactoryResetProtectionSecretPackage(this.this$0, Binder.getCallingUid());
            PersistentDataBlockService.m6471$$Nest$menforceFactoryResetProtectionInactive(this.this$0);
            return PersistentDataBlockService.m6486$$Nest$mupdateFrpSecret(this.this$0, secret);
        L13:
            throw new IllegalArgumentException("Invalid FRP secret: " + HexFormat.of().formatHex(secret));
        }
    }

    private class InternalService implements PersistentDataBlockManagerInternal {
        final /* synthetic */ PersistentDataBlockService this$0;

        /* JADX INFO: renamed from: -$$Nest$mwriteDataBuffer, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m6489$$Nest$mwriteDataBuffer(InternalService r0, long r1, ByteBuffer r3) {
            return r0.writeDataBuffer(r1, r3);
        }

        /* synthetic */ InternalService(PersistentDataBlockService r1, PersistentDataBlockServiceIA r2) {
            this(r1);
        }

        private InternalService(PersistentDataBlockService r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.pdb.PersistentDataBlockManagerInternal
        public void setFrpCredentialHandle(byte[] handle) {
            writeInternal(handle, this.this$0.getFrpCredentialDataOffset(), PersistentDataBlockService.MAX_FRP_CREDENTIAL_HANDLE_SIZE);
        }

        @Override // com.android.server.pdb.PersistentDataBlockManagerInternal
        public byte[] getFrpCredentialHandle() {
            return readInternal(this.this$0.getFrpCredentialDataOffset(), PersistentDataBlockService.MAX_FRP_CREDENTIAL_HANDLE_SIZE);
        }

        @Override // com.android.server.pdb.PersistentDataBlockManagerInternal
        public void setTestHarnessModeData(byte[] data) {
            writeInternal(data, this.this$0.getTestHarnessModeDataOffset(), PersistentDataBlockService.MAX_TEST_MODE_DATA_SIZE);
        }

        @Override // com.android.server.pdb.PersistentDataBlockManagerInternal
        public byte[] getTestHarnessModeData() {
            byte[] data = readInternal(this.this$0.getTestHarnessModeDataOffset(), PersistentDataBlockService.MAX_TEST_MODE_DATA_SIZE);
            if (data == null) goto L5;
            return data;
        L5:
            return new byte[0];
        }

        @Override // com.android.server.pdb.PersistentDataBlockManagerInternal
        public void clearTestHarnessModeData() {
            int size = Math.min(PersistentDataBlockService.MAX_TEST_MODE_DATA_SIZE, getTestHarnessModeData().length) + 4;
            writeDataBuffer(this.this$0.getTestHarnessModeDataOffset(), ByteBuffer.allocate(size));
        }

        @Override // com.android.server.pdb.PersistentDataBlockManagerInternal
        public int getAllowedUid() {
            return PersistentDataBlockService.m6448$$Nest$fgetmAllowedUid(this.this$0);
        }

        @Override // com.android.server.pdb.PersistentDataBlockManagerInternal
        public boolean deactivateFactoryResetProtectionWithoutSecret() {
            Object r0 = PersistentDataBlockService.m6460$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            PersistentDataBlockService.m6462$$Nest$fputmFrpActive(this.this$0, false);     // Catch: Throwable -> L8
            PersistentDataBlockService.m6485$$Nest$msetOldSettingForBackworkCompatibility(this.this$0, PersistentDataBlockService.m6452$$Nest$fgetmFrpActive(this.this$0));     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return true;
        L8:
            th = move-exception;
            throw th;
        }

        private void writeInternal(byte[] data, long offset, int dataLength) {
            boolean r0 = true;
            int r1 = 0;
            if (data != null) goto L5;
        L8:
            boolean r2 = true;
        L9:
            Preconditions.checkArgument(r2, "data must be null or non-empty");
            if (data != null) goto L12;
        L15:
            Preconditions.checkArgument(r0, "data must not be longer than " + dataLength);
            ByteBuffer dataBuffer = ByteBuffer.allocate(dataLength + 4);
            if (data == null) goto L19;
            r1 = data.length;
        L19:
            dataBuffer.putInt(r1);
            if (data == null) goto L22;
            dataBuffer.put(data);
        L22:
            dataBuffer.flip();
            writeDataBuffer(offset, dataBuffer);
            return;
        L12:
            if (data.length <= dataLength) goto L15;
            r0 = false;
            goto L15
        L5:
            if (data.length > 0) goto L8;
            r2 = false;
            goto L9
        }

        private boolean writeDataBuffer(long offset, ByteBuffer dataBuffer) {
            Object r0 = PersistentDataBlockService.m6460$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (PersistentDataBlockService.m6459$$Nest$fgetmIsWritable(this.this$0) == true) goto L11;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return false;
        L11:
            if (offset == this.this$0.getFrpSecretDataOffset()) goto L13;
        L39:
            FileChannel channel = PersistentDataBlockService.m6478$$Nest$mgetBlockOutputChannel(this.this$0);     // Catch: Throwable -> L8 IOException -> L21
            channel.position(offset);     // Catch: Throwable -> L23
            channel.write(dataBuffer);     // Catch: Throwable -> L23
            channel.force(true);     // Catch: Throwable -> L23
            channel.close();     // Catch: Throwable -> L8 IOException -> L21
            boolean r1 = PersistentDataBlockService.m6464$$Nest$mcomputeAndWriteDigestLocked(this.this$0);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return r1;
        L23:
            th = move-exception;
            if (channel != null) goto L37;
        L30:
            throw th;     // Catch: Throwable -> L8 IOException -> L21
        L37:
            channel.close();     // Catch: Throwable -> L27
        L27:
            th = move-exception;
            th.addSuppressed(th);     // Catch: Throwable -> L8 IOException -> L21
        L21:
            e = move-exception;
            Slog.e(PersistentDataBlockService.m6487$$Nest$sfgetTAG(), "unable to access persistent partition", e);     // Catch: Throwable -> L8
            return false;
        L13:
            if (PersistentDataBlockService.m6481$$Nest$misAllZero(this.this$0, dataBuffer) == true) goto L39;
            PersistentDataBlockService.m6484$$Nest$mreportWriteNonZeroData(this.this$0);     // Catch: Throwable -> L8
            goto L39
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
        /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.AutoCloseable] */
        /* JADX WARN: Type inference failed for: r0v4, types: [java.io.DataInputStream, java.lang.AutoCloseable] */
        private byte[] readInternal(long offset, int maxLength) {
            ?? r0 = PersistentDataBlockService.m6469$$Nest$menforceChecksumValidity(this.this$0);
            if (r0 == 0) goto L33;
            r0 = new DataInputStream(new FileInputStream(new File(PersistentDataBlockService.m6451$$Nest$fgetmDataBlockFile(this.this$0))));     // Catch: FileNotFoundException -> L29
            Object r1 = PersistentDataBlockService.m6460$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L22 IOException -> L24
            monitor-enter(r1);     // Catch: Throwable -> L22 IOException -> L24
            r0.skip(offset);     // Catch: Throwable -> L15
            int length = r0.readInt();     // Catch: Throwable -> L15
            if (length <= 0) goto L17;
            if (length > maxLength) goto L17;
            byte[] bytes = new byte[length];     // Catch: Throwable -> L15
            r0.readFully(bytes);     // Catch: Throwable -> L15
            monitor-exit(r1);     // Catch: Throwable -> L15
            IoUtils.closeQuietly(r0);
            return bytes;
        L17:
            monitor-exit(r1);     // Catch: Throwable -> L15
            IoUtils.closeQuietly(r0);
            return null;
        L15:
            th = move-exception;
            throw th;     // Catch: Throwable -> L22 IOException -> L24
        L24:
            e = move-exception;
            throw new IllegalStateException("persistent partition not readable", e);     // Catch: Throwable -> L22
        L22:
            th = move-exception;
            IoUtils.closeQuietly(r0);
            throw th;
        L31:
            throw new IllegalStateException("persistent partition not available");
        L33:
            throw new IllegalStateException("invalid checksum");
        }

        @Override // com.android.server.pdb.PersistentDataBlockManagerInternal
        public void forceOemUnlockEnabled(boolean enabled) {
            Object r0 = PersistentDataBlockService.m6460$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            PersistentDataBlockService.m6468$$Nest$mdoSetOemUnlockEnabledLocked(this.this$0, enabled);     // Catch: Throwable -> L7
            PersistentDataBlockService.m6464$$Nest$mcomputeAndWriteDigestLocked(this.this$0);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public static /* synthetic */ void $r8$lambda$konnAXJEAnzKBClo_dB4T2g6MZ4(PersistentDataBlockService r0) {
        r0.lambda$onStart$0();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAllowedUid, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m6448$$Nest$fgetmAllowedUid(PersistentDataBlockService r0) {
        return r0.mAllowedUid;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBlockDeviceSize, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m6449$$Nest$fgetmBlockDeviceSize(PersistentDataBlockService r2) {
        return r2.mBlockDeviceSize;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m6450$$Nest$fgetmContext(PersistentDataBlockService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDataBlockFile, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m6451$$Nest$fgetmDataBlockFile(PersistentDataBlockService r0) {
        return r0.mDataBlockFile;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFrpActive, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6452$$Nest$fgetmFrpActive(PersistentDataBlockService r0) {
        return r0.mFrpActive;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFrpEnforced, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6453$$Nest$fgetmFrpEnforced(PersistentDataBlockService r0) {
        return r0.mFrpEnforced;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFrpSecretFile, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m6454$$Nest$fgetmFrpSecretFile(PersistentDataBlockService r0) {
        return r0.mFrpSecretFile;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFrpSecretTmpFile, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m6455$$Nest$fgetmFrpSecretTmpFile(PersistentDataBlockService r0) {
        return r0.mFrpSecretTmpFile;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInitDoneSignal, reason: not valid java name */
    static /* bridge */ /* synthetic */ CountDownLatch m6456$$Nest$fgetmInitDoneSignal(PersistentDataBlockService r0) {
        return r0.mInitDoneSignal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInternalService, reason: not valid java name */
    static /* bridge */ /* synthetic */ InternalService m6457$$Nest$fgetmInternalService(PersistentDataBlockService r0) {
        return r0.mInternalService;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsFileBacked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6458$$Nest$fgetmIsFileBacked(PersistentDataBlockService r0) {
        return r0.mIsFileBacked;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsWritable, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6459$$Nest$fgetmIsWritable(PersistentDataBlockService r0) {
        return r0.mIsWritable;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m6460$$Nest$fgetmLock(PersistentDataBlockService r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmAllowedUid, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6461$$Nest$fputmAllowedUid(PersistentDataBlockService r0, int r1) {
        r0.mAllowedUid = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmFrpActive, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6462$$Nest$fputmFrpActive(PersistentDataBlockService r0, boolean r1) {
        r0.mFrpActive = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsWritable, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6463$$Nest$fputmIsWritable(PersistentDataBlockService r0, boolean r1) {
        r0.mIsWritable = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mcomputeAndWriteDigestLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6464$$Nest$mcomputeAndWriteDigestLocked(PersistentDataBlockService r0) {
        return r0.computeAndWriteDigestLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mdeactivateFrp, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6465$$Nest$mdeactivateFrp(PersistentDataBlockService r0, byte[] r1) {
        return r0.deactivateFrp(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mdoGetMaximumDataBlockSize, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m6466$$Nest$mdoGetMaximumDataBlockSize(PersistentDataBlockService r2) {
        return r2.doGetMaximumDataBlockSize();
    }

    /* JADX INFO: renamed from: -$$Nest$mdoGetOemUnlockEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6467$$Nest$mdoGetOemUnlockEnabled(PersistentDataBlockService r0) {
        return r0.doGetOemUnlockEnabled();
    }

    /* JADX INFO: renamed from: -$$Nest$mdoSetOemUnlockEnabledLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6468$$Nest$mdoSetOemUnlockEnabledLocked(PersistentDataBlockService r0, boolean r1) {
        r0.doSetOemUnlockEnabledLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$menforceChecksumValidity, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6469$$Nest$menforceChecksumValidity(PersistentDataBlockService r0) {
        return r0.enforceChecksumValidity();
    }

    /* JADX INFO: renamed from: -$$Nest$menforceConfigureFrpPermission, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6470$$Nest$menforceConfigureFrpPermission(PersistentDataBlockService r0) {
        r0.enforceConfigureFrpPermission();
    }

    /* JADX INFO: renamed from: -$$Nest$menforceFactoryResetProtectionInactive, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6471$$Nest$menforceFactoryResetProtectionInactive(PersistentDataBlockService r0) {
        r0.enforceFactoryResetProtectionInactive();
    }

    /* JADX INFO: renamed from: -$$Nest$menforceIsAdmin, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6472$$Nest$menforceIsAdmin(PersistentDataBlockService r0) {
        r0.enforceIsAdmin();
    }

    /* JADX INFO: renamed from: -$$Nest$menforceOemUnlockReadPermission, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6473$$Nest$menforceOemUnlockReadPermission(PersistentDataBlockService r0) {
        r0.enforceOemUnlockReadPermission();
    }

    /* JADX INFO: renamed from: -$$Nest$menforceOemUnlockWritePermission, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6474$$Nest$menforceOemUnlockWritePermission(PersistentDataBlockService r0) {
        r0.enforceOemUnlockWritePermission();
    }

    /* JADX INFO: renamed from: -$$Nest$menforceUid, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6475$$Nest$menforceUid(PersistentDataBlockService r0, int r1) {
        r0.enforceUid(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$menforceUid, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6476$$Nest$menforceUid(PersistentDataBlockService r0, int r1, boolean r2) {
        r0.enforceUid(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$menforceUserRestriction, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6477$$Nest$menforceUserRestriction(PersistentDataBlockService r0, String r1) {
        r0.enforceUserRestriction(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetBlockOutputChannel, reason: not valid java name */
    static /* bridge */ /* synthetic */ FileChannel m6478$$Nest$mgetBlockOutputChannel(PersistentDataBlockService r0) {
        return r0.getBlockOutputChannel();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetTotalDataSizeLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m6479$$Nest$mgetTotalDataSizeLocked(PersistentDataBlockService r0, DataInputStream r1) {
        return r0.getTotalDataSizeLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhasFrpSecretMagic, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6480$$Nest$mhasFrpSecretMagic(PersistentDataBlockService r0) {
        return r0.hasFrpSecretMagic();
    }

    /* JADX INFO: renamed from: -$$Nest$misAllZero, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6481$$Nest$misAllZero(PersistentDataBlockService r0, ByteBuffer r1) {
        return r0.isAllZero(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mnativeWipe, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m6482$$Nest$mnativeWipe(PersistentDataBlockService r0, String r1) {
        return r0.nativeWipe(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mreportSetFactoryResetProtectionSecretPackage, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6483$$Nest$mreportSetFactoryResetProtectionSecretPackage(PersistentDataBlockService r0, int r1) {
        r0.reportSetFactoryResetProtectionSecretPackage(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mreportWriteNonZeroData, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6484$$Nest$mreportWriteNonZeroData(PersistentDataBlockService r0) {
        r0.reportWriteNonZeroData();
    }

    /* JADX INFO: renamed from: -$$Nest$msetOldSettingForBackworkCompatibility, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6485$$Nest$msetOldSettingForBackworkCompatibility(PersistentDataBlockService r0, boolean r1) {
        r0.setOldSettingForBackworkCompatibility(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateFrpSecret, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6486$$Nest$mupdateFrpSecret(PersistentDataBlockService r0, byte[] r1) {
        return r0.updateFrpSecret(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m6487$$Nest$sfgetTAG() {
        return TAG;
    }

    private native long nativeGetBlockDeviceSize(String r1);

    private native int nativeWipe(String r1);

    static {
        TAG = PersistentDataBlockService.class.getSimpleName();
        FRP_SECRET_MAGIC = new byte[]{-38, -62, -4, -51, -71, ParameterName.LEVEL_RANGE, 9, -120};
    }

    public PersistentDataBlockService(Context context) {
        super(context);
        this.mLock = new Object();
        this.mInitDoneSignal = new CountDownLatch(1);
        this.mAllowedUid = -1;
        this.mBlockDeviceSize = -1;
        this.mFrpActive = false;
        this.mIsWritable = true;
        this.mService = new AnonymousClass2(this);
        this.mInternalService = new InternalService(this, null);
        this.mContext = context;
        this.mFrpEnforced = true;
        this.mFrpActive = this.mFrpEnforced;
        this.mFrpSecretFile = FRP_SECRET_FILE;
        this.mFrpSecretTmpFile = FRP_SECRET_TMP_FILE;
        if (SystemProperties.getBoolean(GSI_RUNNING_PROP, false) == false) goto L5;
        this.mIsFileBacked = true;
        this.mDataBlockFile = GSI_SANDBOX;
        return;
    L5:
        this.mIsFileBacked = false;
        this.mDataBlockFile = SystemProperties.get(PERSISTENT_DATA_BLOCK_PROP);
    }

    PersistentDataBlockService(Context context, boolean isFileBacked, String dataBlockFile, long blockDeviceSize, boolean frpEnabled, String frpSecretFile, String frpSecretTmpFile) {
        super(context);
        this.mLock = new Object();
        this.mInitDoneSignal = new CountDownLatch(1);
        this.mAllowedUid = -1;
        this.mBlockDeviceSize = -1;
        this.mFrpActive = false;
        this.mIsWritable = true;
        this.mService = new AnonymousClass2(this);
        this.mInternalService = new InternalService(this, null);
        this.mContext = context;
        this.mIsFileBacked = isFileBacked;
        this.mDataBlockFile = dataBlockFile;
        this.mBlockDeviceSize = blockDeviceSize;
        this.mFrpEnforced = frpEnabled;
        this.mFrpActive = this.mFrpEnforced;
        this.mFrpSecretFile = frpSecretFile;
        this.mFrpSecretTmpFile = frpSecretTmpFile;
    }

    private int getAllowedUid() {
        UserManagerInternal umInternal = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        int mainUserId = umInternal.getMainUserId();
        if (mainUserId >= 0) goto L5;
        mainUserId = 0;
    L5:
        String allowedPackage = this.mContext.getResources().getString(R.string.config_usbAccessoryUriActivity);
        if (TextUtils.isEmpty(allowedPackage) == true) goto L14;
        int allowedUid = this.mContext.getPackageManager().getPackageUidAsUser(allowedPackage, 1048576, mainUserId);     // Catch: PackageManager.NameNotFoundException -> L9
        return allowedUid;
    L9:
        e = move-exception;
        Slog.e(TAG, "not able to find package " + allowedPackage, e);
        return -1;
    L14:
        return -1;
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        SystemServerInitThreadPool.submit(new PersistentDataBlockService$$ExternalSyntheticLambda0(this), TAG + ".onStart");
    }

    private /* synthetic */ void lambda$onStart$0() {
        enforceChecksumValidity();
        if (this.mFrpEnforced == false) goto L5;
        automaticallyDeactivateFrpIfPossible();
        setOldSettingForBackworkCompatibility(this.mFrpActive);
    L6:
        publishBinderService("persistent_data_block", this.mService);
        signalInitDone();
        return;
    L5:
        formatIfOemUnlockEnabled();
        goto L6
    }

    void signalInitDone() {
        this.mInitDoneSignal.countDown();
    }

    private void setOldSettingForBackworkCompatibility(boolean isActive) {
        long callingId = Binder.clearCallingIdentity();
        ContentResolver r2 = this.mContext.getContentResolver();     // Catch: Throwable -> L10
        if (isActive == false) goto L6;
        int r4 = 1;
    L7:
        Settings.Global.putInt(r2, "secure_frp_mode", r4);     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(callingId);
        return;
    L6:
        r4 = 0;
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(callingId);
        throw th;
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase != 500) goto L9;
        waitForInitDoneSignal();
        this.mAllowedUid = getAllowedUid();
        LocalServices.addService(PersistentDataBlockManagerInternal.class, this.mInternalService);
        if (this.mAllowedUid != (-1)) goto L9;
        final PackageManagerInternal packageManagerInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        final String mAllowedPackage = this.mContext.getResources().getString(R.string.config_usbAccessoryUriActivity);
        if (packageManagerInternal == null) goto L9;
        packageManagerInternal.getPackageList(new AnonymousClass1(this, mAllowedPackage, packageManagerInternal));
    L9:
        super.onBootPhase(phase);
    }

    private void waitForInitDoneSignal() {
    L8:
        e = move-exception;
        Thread.currentThread().interrupt();
        throw new IllegalStateException("Service " + TAG + " init interrupted", e);
    L4:
        if (this.mInitDoneSignal.await(10, TimeUnit.SECONDS) == false) goto L7;
        return;
    L7:
        throw new IllegalStateException("Service " + TAG + " init timeout");     // Catch: InterruptedException -> L8
    }

    void setAllowedUid(int uid) {
        this.mAllowedUid = uid;
    }

    private void formatIfOemUnlockEnabled() {
        boolean enabled = doGetOemUnlockEnabled();
        if (enabled == false) goto L13;
        Object r1 = this.mLock;
        monitor-enter(r1);
        formatPartitionLocked(true);     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void enforceOemUnlockReadPermission() {
        if (this.mContext.checkCallingOrSelfPermission("android.permission.READ_OEM_UNLOCK_STATE") == (-1)) goto L5;
        return;
    L5:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.OEM_UNLOCK_STATE") == (-1)) goto L8;
        return;
    L8:
        throw new SecurityException("Can't access OEM unlock state. Requires READ_OEM_UNLOCK_STATE or OEM_UNLOCK_STATE permission.");
    }

    private void enforceOemUnlockWritePermission() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.OEM_UNLOCK_STATE", "Can't modify OEM unlock state");
    }

    private void enforceConfigureFrpPermission() {
        if (this.mFrpEnforced == true) goto L5;
        return;
    L5:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.CONFIGURE_FACTORY_RESET_PROTECTION") == (-1)) goto L8;
        return;
    L8:
        throw new SecurityException("Can't configure Factory Reset Protection. Requires CONFIGURE_FACTORY_RESET_PROTECTION");
    }

    private void enforceUid(int callingUid) {
        enforceUid(callingUid, false);
    }

    private void enforceUid(int callingUid, boolean allowShell) {
        if (callingUid == this.mAllowedUid) goto L11;
        if (callingUid != 0) goto L6;
        return;
    L6:
        if (callingUid != 2000) goto L10;
        if (allowShell == false) goto L10;
        return;
    L10:
        throw new SecurityException("Uid " + callingUid + " not allowed to access PDB");
    }

    private void enforceIsAdmin() {
        int userId = UserHandle.getCallingUserId();
        boolean isAdmin = UserManager.get(this.mContext).isUserAdmin(userId);
        if (isAdmin == false) goto L6;
        return;
    L6:
        throw new SecurityException("Only the Admin user is allowed to change OEM unlock state");
    }

    private void enforceUserRestriction(String userRestriction) {
        if (UserManager.get(this.mContext).hasUserRestriction(userRestriction) == true) goto L6;
        return;
    L6:
        throw new SecurityException("OEM unlock is disallowed by user restriction: " + userRestriction);
    }

    private int getTotalDataSizeLocked(DataInputStream inputStream) throws IOException {
        inputStream.skipBytes(32);
        int blockId = inputStream.readInt();
        if (blockId != PARTITION_TYPE_MARKER) goto L5;
        int totalDataSize = inputStream.readInt();
        return totalDataSize;
    L5:
        return 0;
    }

    long getBlockDeviceSize() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mBlockDeviceSize == (-1)) goto L7;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return this.mBlockDeviceSize;
    L7:
        if (this.mIsFileBacked == false) goto L11;
        this.mBlockDeviceSize = 102400;     // Catch: Throwable -> L9
        goto L12
    L11:
        this.mBlockDeviceSize = nativeGetBlockDeviceSize(this.mDataBlockFile);     // Catch: Throwable -> L9
        goto L12
    }

    int getMaximumFrpDataSize() {
        if (this.mFrpEnforced == false) goto L5;
        long frpSecretSize = FRP_SECRET_MAGIC.length + 32;
    L7:
        return (int) (((getTestHarnessModeDataOffset() - 32) - 8) - frpSecretSize);
    L5:
        frpSecretSize = 0;
        goto L7
    }

    long getFrpCredentialDataOffset() {
        return getOemUnlockDataOffset() - 1000;
    }

    long getFrpSecretMagicOffset() {
        return getFrpSecretDataOffset() - ((long) FRP_SECRET_MAGIC.length);
    }

    long getFrpSecretDataOffset() {
        return getTestHarnessModeDataOffset() - 32;
    }

    long getTestHarnessModeDataOffset() {
        return getFrpCredentialDataOffset() - JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY;
    }

    long getOemUnlockDataOffset() {
        return getBlockDeviceSize() - 1;
    }

    private boolean enforceChecksumValidity() {
        byte[] storedDigest = new byte[32];
        Object r1 = this.mLock;
        monitor-enter(r1);
        byte[] digest = computeDigestLocked(storedDigest);     // Catch: Throwable -> L12
        if (digest == null) goto L14;
        if (Arrays.equals(storedDigest, digest) == false) goto L14;
        monitor-exit(r1);     // Catch: Throwable -> L12
        return true;
    L14:
        Slog.i(TAG, "Formatting FRP partition...");     // Catch: Throwable -> L12
        formatPartitionLocked(false);     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        return false;
    L12:
        th = move-exception;
        throw th;
    }

    private FileChannel getBlockOutputChannel() throws IOException {
        enforceFactoryResetProtectionInactive();
        return getBlockOutputChannelIgnoringFrp();
    }

    private FileChannel getBlockOutputChannelIgnoringFrp() throws FileNotFoundException {
        return new RandomAccessFile(this.mDataBlockFile, "rw").getChannel();
    }

    private boolean computeAndWriteDigestLocked() {
        byte[] digest = computeDigestLocked(null);
        if (digest != null) goto L24;
        return false;
    L24:
        FileChannel channel = getBlockOutputChannel();     // Catch: IOException -> L9
        ByteBuffer buf = ByteBuffer.allocate(32);     // Catch: Throwable -> L11
        buf.put(digest);     // Catch: Throwable -> L11
        buf.flip();     // Catch: Throwable -> L11
        channel.write(buf);     // Catch: Throwable -> L11
        channel.force(true);     // Catch: Throwable -> L11
        channel.close();     // Catch: IOException -> L9
        return true;
    L11:
        th = move-exception;
        if (channel != null) goto L25;
    L18:
        throw th;     // Catch: IOException -> L9
    L25:
        channel.close();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L9
    L9:
        e = move-exception;
        Slog.e(TAG, "failed to write block checksum", e);
        return false;
    }

    private byte[] computeDigestLocked(byte[] storedDigest) {
        DataInputStream inputStream = new DataInputStream(new FileInputStream(new File(this.mDataBlockFile)));     // Catch: FileNotFoundException -> L31
        MessageDigest md = MessageDigest.getInstance("SHA-256");     // Catch: NoSuchAlgorithmException -> L28
        if (storedDigest != null) goto L34;
    L14:
        inputStream.skipBytes(32);     // Catch: Throwable -> L10 IOException -> L12
    L15:
        byte[] data = new byte[1024];     // Catch: Throwable -> L10 IOException -> L12
        md.update(data, 0, 32);     // Catch: Throwable -> L10 IOException -> L12
    L16:
        int read = inputStream.read(data);     // Catch: Throwable -> L10 IOException -> L12
        if (read == (-1)) goto L20;
        md.update(data, 0, read);     // Catch: Throwable -> L10 IOException -> L12
        goto L16
    L20:
        IoUtils.closeQuietly(inputStream);
        return md.digest();
    L12:
        e = move-exception;
        Slog.e(TAG, "failed to read partition", e);     // Catch: Throwable -> L10
        IoUtils.closeQuietly(inputStream);
        return null;
    L10:
        th = move-exception;
        IoUtils.closeQuietly(inputStream);
        throw th;
    L34:
        if (storedDigest.length != 32) goto L14;
        inputStream.read(storedDigest);     // Catch: Throwable -> L10 IOException -> L12
    L28:
        e = move-exception;
        Slog.e(TAG, "SHA-256 not supported?", e);
        IoUtils.closeQuietly(inputStream);
        return null;
    L31:
        e = move-exception;
        Slog.e(TAG, "partition not available?", e);
        return null;
    }

    void formatPartitionLocked(boolean setOemUnlockEnabled) {
        FileChannel channel = getBlockOutputChannelIgnoringFrp();     // Catch: IOException -> L17
        ByteBuffer buf = ByteBuffer.allocate(40);     // Catch: Throwable -> L7
        buf.put(new byte[32]);     // Catch: Throwable -> L7
        buf.putInt(PARTITION_TYPE_MARKER);     // Catch: Throwable -> L7
        buf.putInt(0);     // Catch: Throwable -> L7
        buf.flip();     // Catch: Throwable -> L7
        channel.write(buf);     // Catch: Throwable -> L7
        channel.force(true);     // Catch: Throwable -> L7
        int payload_size = ((int) getBlockDeviceSize()) - 40;     // Catch: Throwable -> L7
        if (this.mFrpEnforced == false) goto L9;
        ByteBuffer buf2 = ByteBuffer.allocate(((((payload_size + ProcessList.INVALID_ADJ) - FRP_SECRET_MAGIC.length) - 32) - 1000) - 1);     // Catch: Throwable -> L7
    L10:
        channel.write(buf2);     // Catch: Throwable -> L7
        channel.force(true);     // Catch: Throwable -> L7
        if (this.mFrpEnforced == false) goto L13;
        Slog.i(TAG, "Writing FRP secret magic");     // Catch: Throwable -> L7
        channel.write(ByteBuffer.wrap(FRP_SECRET_MAGIC));     // Catch: Throwable -> L7
        Slog.i(TAG, "Writing default FRP secret");     // Catch: Throwable -> L7
        channel.write(ByteBuffer.allocate(32));     // Catch: Throwable -> L7
        channel.force(true);     // Catch: Throwable -> L7
        this.mFrpActive = false;     // Catch: Throwable -> L7
    L13:
        channel.position(channel.position() + JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY);     // Catch: Throwable -> L7
        channel.write(ByteBuffer.allocate(1000));     // Catch: Throwable -> L7
        channel.force(true);     // Catch: Throwable -> L7
        ByteBuffer buf3 = ByteBuffer.allocate(1000);     // Catch: Throwable -> L7
        buf3.put((byte) 0);     // Catch: Throwable -> L7
        buf3.flip();     // Catch: Throwable -> L7
        channel.write(buf3);     // Catch: Throwable -> L7
        channel.force(true);     // Catch: Throwable -> L7
        channel.close();     // Catch: IOException -> L17
        doSetOemUnlockEnabledLocked(setOemUnlockEnabled);
        computeAndWriteDigestLocked();
        return;
    L9:
        buf2 = ByteBuffer.allocate(((payload_size + ProcessList.INVALID_ADJ) - 1000) - 1);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        if (channel != null) goto L29;
    L25:
        throw th;     // Catch: IOException -> L17
    L29:
        channel.close();     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L17
    L17:
        e = move-exception;
        Slog.e(TAG, "failed to format block", e);
    }

    boolean automaticallyDeactivateFrpIfPossible() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (deactivateFrpWithFileSecret(this.mFrpSecretFile) == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return true;
    L10:
        Slog.w(TAG, "Failed to deactivate with primary secret file, trying backup.");     // Catch: Throwable -> L8
        if (deactivateFrpWithFileSecret(this.mFrpSecretTmpFile) == false) goto L15;
        moveFrpTempFileToPrimary();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return true;
    L15:
        Slog.w(TAG, "Failed to deactivate with backup secret file, trying default secret.");     // Catch: Throwable -> L8
        if (deactivateFrp(new byte[32]) == false) goto L20;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return true;
    L20:
        if (isUpgradingFromPreVRelease() == false) goto L24;
        Slog.w(TAG, "Upgrading from Android 14 or lower, defaulting FRP secret");     // Catch: Throwable -> L8
        writeFrpMagicAndDefaultSecret();     // Catch: Throwable -> L8
        this.mFrpActive = false;     // Catch: Throwable -> L8
        setOldSettingForBackworkCompatibility(this.mFrpActive);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return true;
    L24:
        Slog.e(TAG, "Did not find valid FRP secret, FRP remains active.");     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    }

    private boolean deactivateFrpWithFileSecret(String frpSecretFile) {
        return deactivateFrp(Files.readAllBytes(Paths.get(frpSecretFile, new String[0])));
    L5:
        e = move-exception;
        Slog.i(TAG, "Failed to read FRP secret file: " + frpSecretFile + " " + e.getClass().getSimpleName());
        return false;
    }

    private void moveFrpTempFileToPrimary() {
        Files.move(Paths.get(this.mFrpSecretTmpFile, new String[0]), Paths.get(this.mFrpSecretFile, new String[0]), new CopyOption[]{StandardCopyOption.REPLACE_EXISTING});     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Error moving FRP backup file to primary (ignored)", e);
    }

    boolean isFrpActive() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mFrpActive;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean updateFrpSecret(byte[] secret) {
        Files.write(Paths.get(this.mFrpSecretTmpFile, new String[0]), secret, new OpenOption[]{StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.SYNC});     // Catch: IOException -> L9
        if (InternalService.m6489$$Nest$mwriteDataBuffer(this.mInternalService, getFrpSecretDataOffset(), ByteBuffer.wrap(secret)) == true) goto L7;
        return false;
    L7:
        moveFrpTempFileToPrimary();
        return true;
    L9:
        e = move-exception;
        Slog.e(TAG, "Failed to write FRP secret file", e);
        return false;
    }

    void activateFrp() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mFrpActive = true;     // Catch: Throwable -> L8
        setOldSettingForBackworkCompatibility(this.mFrpActive);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private boolean hasFrpSecretMagic() {
        byte[] frpMagic = readDataBlock(getFrpSecretMagicOffset(), FRP_SECRET_MAGIC.length);
        if (frpMagic != null) goto L7;
        Slog.e(TAG, "Failed to read FRP magic region.");
        return false;
    L7:
        return Arrays.equals(frpMagic, FRP_SECRET_MAGIC);
    }

    private byte[] getFrpSecret() {
        return readDataBlock(getFrpSecretDataOffset(), 32);
    }

    private boolean deactivateFrp(byte[] secret) {
        if (secret != null) goto L5;
    L30:
        Slog.w(TAG, "Attempted to deactivate FRP with a null or incorrectly-sized secret");
        return false;
    L5:
        if (secret.length != 32) goto L30;
        Object r1 = this.mLock;
        monitor-enter(r1);
    L12:
        th = move-exception;
        throw th;
    L10:
        if (hasFrpSecretMagic() == true) goto L14;
        Slog.i(TAG, "No FRP secret magic, system must have been upgraded.");     // Catch: Throwable -> L12
        writeFrpMagicAndDefaultSecret();     // Catch: Throwable -> L12
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L12
        byte[] partitionSecret = getFrpSecret();
        if (partitionSecret != null) goto L18;
    L26:
        Slog.e(TAG, "Failed to read FRP secret from persistent data partition");
        return false;
    L18:
        if (partitionSecret.length != 32) goto L26;
        if (MessageDigest.isEqual(secret, partitionSecret) == false) goto L24;
        this.mFrpActive = false;
        Slog.i(TAG, "FRP secret matched, FRP deactivated.");
        setOldSettingForBackworkCompatibility(this.mFrpActive);
        return true;
    L24:
        Slog.e(TAG, "FRP deactivation failed with secret " + HexFormat.of().formatHex(secret));
        return false;
    }

    private void writeFrpMagicAndDefaultSecret() {
        FileChannel channel = getBlockOutputChannelIgnoringFrp();     // Catch: IOException -> L9
        Object r1 = this.mLock;     // Catch: Throwable -> L14
        monitor-enter(r1);     // Catch: Throwable -> L14
        Slog.i(TAG, "Writing default FRP secret");     // Catch: Throwable -> L11
        channel.position(getFrpSecretDataOffset());     // Catch: Throwable -> L11
        channel.write(ByteBuffer.allocate(32));     // Catch: Throwable -> L11
        channel.force(true);     // Catch: Throwable -> L11
        Slog.i(TAG, "Writing FRP secret magic");     // Catch: Throwable -> L11
        channel.position(getFrpSecretMagicOffset());     // Catch: Throwable -> L11
        channel.write(ByteBuffer.wrap(FRP_SECRET_MAGIC));     // Catch: Throwable -> L11
        channel.force(true);     // Catch: Throwable -> L11
        this.mFrpActive = false;     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        channel.close();     // Catch: IOException -> L9
    L23:
        computeAndWriteDigestLocked();
        return;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        if (channel != null) goto L25;
    L21:
        throw th;     // Catch: IOException -> L9
    L25:
        channel.close();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L9
    L9:
        e = move-exception;
        Slog.e(TAG, "Failed to write FRP magic and default secret", e);
        goto L23
    }

    byte[] readDataBlock(long offset, int length) {
        DataInputStream inputStream = new DataInputStream(new FileInputStream(new File(this.mDataBlockFile)));     // Catch: IOException -> L9
        Object r1 = this.mLock;     // Catch: Throwable -> L14
        monitor-enter(r1);     // Catch: Throwable -> L14
        inputStream.skip(offset);     // Catch: Throwable -> L11
        byte[] bytes = new byte[length];     // Catch: Throwable -> L11
        inputStream.readFully(bytes);     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        inputStream.close();     // Catch: IOException -> L9
        return bytes;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        inputStream.close();     // Catch: Throwable -> L17
    L19:
        throw th;     // Catch: IOException -> L9
    L17:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L9
    L9:
        e = move-exception;
        throw new IllegalStateException("persistent partition not readable", e);
    }

    private void doSetOemUnlockEnabledLocked(boolean enabled) {
        FileChannel channel = getBlockOutputChannel();     // Catch: IOException -> L10
        channel.position(getBlockDeviceSize() - 1);     // Catch: Throwable -> L12
        ByteBuffer data = ByteBuffer.allocate(1);     // Catch: Throwable -> L12
        if (enabled == false) goto L6;
        byte r3 = 1;
    L7:
        data.put(r3);     // Catch: Throwable -> L12
        data.flip();     // Catch: Throwable -> L12
        channel.write(data);     // Catch: Throwable -> L12
        channel.force(true);     // Catch: Throwable -> L12
        channel.close();     // Catch: IOException -> L10
        return;
    L6:
        r3 = 0;
    L12:
        th = move-exception;
        if (channel != null) goto L22;
    L19:
        throw th;     // Catch: IOException -> L10
    L22:
        channel.close();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L10
    L10:
        e = move-exception;
        Slog.e(TAG, "unable to access persistent partition", e);
    }

    private boolean doGetOemUnlockEnabled() {
        DataInputStream inputStream = new DataInputStream(new FileInputStream(new File(this.mDataBlockFile)));     // Catch: FileNotFoundException -> L24
        Object r2 = this.mLock;     // Catch: Throwable -> L16 IOException -> L18
        monitor-enter(r2);     // Catch: Throwable -> L16 IOException -> L18
        inputStream.skip(getBlockDeviceSize() - 1);     // Catch: Throwable -> L13
        if (inputStream.readByte() == 0) goto L9;
        boolean r3 = true;
    L10:
        monitor-exit(r2);     // Catch: Throwable -> L13
        IoUtils.closeQuietly(inputStream);
        return r3;
    L9:
        r3 = false;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16 IOException -> L18
    L16:
        th = move-exception;
        IoUtils.closeQuietly(inputStream);
        throw th;
    L18:
        e = move-exception;
        Slog.e(TAG, "unable to access persistent partition", e);     // Catch: Throwable -> L16
        IoUtils.closeQuietly(inputStream);
        return false;
    L25:
        Slog.e(TAG, "partition not available");
        return false;
    }

    private long doGetMaximumDataBlockSize() {
        if (this.mFrpEnforced == false) goto L5;
        long frpSecretSize = FRP_SECRET_MAGIC.length + 32;
    L6:
        long actualSize = (((((getBlockDeviceSize() - 8) - 32) - JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY) - frpSecretSize) - 1000) - 1;
        if (actualSize <= 102400) goto L9;
        return 102400;
    L9:
        return actualSize;
    L5:
        frpSecretSize = 0;
        goto L6
    }

    IPersistentDataBlockService getInterfaceForTesting() {
        return IPersistentDataBlockService.Stub.asInterface(this.mService);
    }

    PersistentDataBlockManagerInternal getInternalInterfaceForTesting() {
        return this.mInternalService;
    }

    private void enforceFactoryResetProtectionInactive() {
        if (this.mFrpEnforced == true) goto L5;
        return;
    L5:
        if (isFrpActive() == false) goto L10;
        Slog.w(TAG, "Attempt to update PDB was blocked because FRP is active.");
        throw new SecurityException("FRP is active");
    }

    boolean isUpgradingFromPreVRelease() {
        PackageManagerInternal packageManagerInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        if (packageManagerInternal != null) goto L7;
        Slog.e(TAG, "Unable to retrieve PackageManagerInternal");
        return false;
    L7:
        return packageManagerInternal.isUpgradingFromLowerThan(35);
    }

    private void reportSetFactoryResetProtectionSecretPackage(int callingUid) {
        String packageName = getContext().getPackageManager().getNameForUid(callingUid);
        Slog.d(TAG, "reportSetFactoryResetProtectionSecretPackage: callingUid = " + callingUid + " packageName = " + packageName);
        JSONObject event = new JSONObject();
        event.put("packagename", packageName);     // Catch: Exception -> L5
        event.put("callingUid", callingUid);     // Catch: Exception -> L5
        event.put("alloweUid", this.mAllowedUid);     // Catch: Exception -> L5
        event.put("timestamp", SystemClock.uptimeMillis());     // Catch: Exception -> L5
        event.put("trace", Debug.getCallers(10));     // Catch: Exception -> L5
        SysDataSyncServiceManager.onTeaTrackerEvent("os_on_updatesecret", "", event.toString());     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    private void reportWriteNonZeroData() {
        Slog.d(TAG, "reportWriteNonZeroData");
        JSONObject event = new JSONObject();
        event.put("trace", Debug.getCallers(10));     // Catch: Exception -> L5
        event.put("timestamp", SystemClock.uptimeMillis());     // Catch: Exception -> L5
        SysDataSyncServiceManager.onTeaTrackerEvent("os_on_writenonzerodata", "", event.toString());     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    private boolean isAllZero(ByteBuffer buffer) {
        buffer.rewind();
        if (buffer.hasArray() == false) goto L13;
        byte[] array = buffer.array();
        int offset = buffer.arrayOffset();
        int i = offset;
    L6:
        if (i >= (buffer.limit() + offset)) goto L18;
        if (array[i] != 0) goto L9;
        i = i + 1;
        goto L6
    L9:
        return false;
    L18:
        buffer.rewind();
        return true;
    L13:
        if (buffer.hasRemaining() == false) goto L18;
        if (buffer.get() == 0) goto L13;
        buffer.rewind();
        return false;
    }
}
