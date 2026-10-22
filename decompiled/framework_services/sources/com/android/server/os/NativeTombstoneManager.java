package com.android.server.os;

import android.app.ApplicationExitInfo;
import android.app.IParcelFileDescriptorRetriever;
import android.content.Context;
import android.content.IntentFilter;
import android.os.FileObserver;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.os.UserHandle;
import android.system.ErrnoException;
import android.system.Os;
import android.system.StructStat;
import android.util.Slog;
import android.util.SparseArray;
import android.util.proto.ProtoInputStream;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.BootReceiver;
import com.android.server.ServiceThread;
import com.android.server.job.controllers.JobStatus;
import com.android.server.pm.Settings;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.locks.ReentrantLock;
import libcore.io.IoUtils;
import org.tukaani.xz.LZMA2Options;

/* JADX INFO: loaded from: classes2.dex */
public final class NativeTombstoneManager {
    private static final String TAG = null;
    private static final File TOMBSTONE_DIR = null;
    private final Context mContext;
    private final Handler mHandler;
    private final Object mLock;
    private final ReentrantLock mTmpFileLock;
    private final SparseArray<TombstoneFile> mTombstones;
    private final TombstoneWatcher mWatcher;

    static class TombstoneFile {
        int mAppId;
        String mCrashReason;
        final ParcelFileDescriptor mPfd;
        int mPid;
        String mProcessName;
        boolean mPurged;
        final IParcelFileDescriptorRetriever mRetriever;
        long mTimestampMs;
        int mUid;
        int mUserId;

        class ParcelFileDescriptorRetriever extends IParcelFileDescriptorRetriever.Stub {
            final /* synthetic */ TombstoneFile this$0;

            ParcelFileDescriptorRetriever(TombstoneFile this$0) {
                this.this$0 = this$0;
            }

            public ParcelFileDescriptor getPfd() {
                if (this.this$0.mPurged == false) goto L10;
                return null;
            L10:
                String path = "/proc/self/fd/" + this.this$0.mPfd.getFd();     // Catch: FileNotFoundException -> L7
                ParcelFileDescriptor pfd = ParcelFileDescriptor.open(new File(path), 268435456);     // Catch: FileNotFoundException -> L7
                return pfd;
            L7:
                ex = move-exception;
                Slog.e(NativeTombstoneManager.m6445$$Nest$sfgetTAG(), "failed to reopen file descriptor as read-only", ex);
                return null;
            }
        }

        TombstoneFile(ParcelFileDescriptor pfd) {
            this.mPurged = false;
            this.mRetriever = new ParcelFileDescriptorRetriever(this);
            this.mPfd = pfd;
        }

        public boolean matches(Optional<Integer> userId, Optional<Integer> appId) {
            if (this.mPurged == false) goto L6;
            return false;
        L6:
            if (userId.isPresent() == false) goto L11;
            if (userId.get().intValue() == this.mUserId) goto L11;
            return false;
        L11:
            if (appId.isPresent() == true) goto L13;
            return true;
        L13:
            if (appId.get().intValue() == this.mAppId) goto L17;
            return false;
        L17:
            return true;
        }

        public boolean matches(ApplicationExitInfo exitInfo) {
            if (exitInfo.getReason() == 5) goto L6;
            return false;
        L6:
            if (exitInfo.getPid() == this.mPid) goto L9;
            return false;
        L9:
            if (exitInfo.getRealUid() == this.mUid) goto L12;
            return false;
        L12:
            if (Math.abs(exitInfo.getTimestamp() - this.mTimestampMs) <= JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY) goto L14;
            return false;
        L14:
            return true;
        }

        public String getProcessName() {
            return this.mProcessName;
        }

        public void dispose() {
            IoUtils.closeQuietly(this.mPfd);
        }

        public void purge() {
            if (this.mPurged == true) goto L12;
            Os.ftruncate(this.mPfd.getFileDescriptor(), 0);     // Catch: ErrnoException -> L6
        L8:
            this.mPurged = true;
            return;
        L6:
            ex = move-exception;
            Slog.e(NativeTombstoneManager.m6445$$Nest$sfgetTAG(), "Failed to truncate tombstone", ex);
            goto L8
        }

        static Optional<TombstoneFile> parse(ParcelFileDescriptor pfd) {
            FileInputStream is = new FileInputStream(pfd.getFileDescriptor());
            ProtoInputStream stream = new ProtoInputStream(is);
            String selinuxLabel = "";
            String crashReason = "";
            String crashReason2 = null;
            int uid = 0;
            int uid2 = 0;
        L47:
            int pid = stream.nextField();     // Catch: Throwable -> L19
            String r8 = "";
            if (pid == (-1)) goto L29;
            switch(stream.getFieldNumber()) {
                case 5: goto L27;
                case 7: goto L25;
                case 8: goto L24;
                case 9: goto L22;
                case 15: goto L10;
                default: goto L47;
            };     // Catch: Throwable -> L19 Throwable -> L19
        L10:
            if (crashReason.equals("") == false) goto L47;
            long token = stream.start(2246267895823L);     // Catch: Throwable -> L19 Throwable -> L19
        L14:
            if (stream.nextField() == (-1)) goto L21;
            switch(stream.getFieldNumber()) {
                case 1: goto L18;
                default: goto L14;
            };     // Catch: Throwable -> L19 Throwable -> L19
        L18:
            String crashReason3 = stream.readString(1138166333441L);     // Catch: Throwable -> L19 Throwable -> L19
            crashReason = crashReason3;
        L21:
            stream.end(token);     // Catch: Throwable -> L19 Throwable -> L19
            goto L47
        L22:
            if (crashReason2 != null) goto L47;
            crashReason2 = stream.readString(2237677961225L);     // Catch: Throwable -> L19 Throwable -> L19
            goto L47
        L24:
            selinuxLabel = stream.readString(1138166333448L);     // Catch: Throwable -> L19 Throwable -> L19
            goto L47
        L25:
            uid = stream.readInt(1155346202631L);     // Catch: Throwable -> L19 Throwable -> L19
            goto L47
        L27:
            uid2 = stream.readInt(1155346202629L);     // Catch: Throwable -> L19 Throwable -> L19
            goto L47
        L29:
            if (UserHandle.isApp(uid) == true) goto L31;
            Slog.e(NativeTombstoneManager.m6445$$Nest$sfgetTAG(), "Tombstone's UID (" + uid + ") not an app, ignoring");
        L31:
            long timestampMs = 0;
            StructStat stat = Os.fstat(pfd.getFileDescriptor());     // Catch: ErrnoException -> L34
            timestampMs = (stat.st_atim.tv_sec * 1000) + (stat.st_atim.tv_nsec / 1000000);
        L36:
            int userId = UserHandle.getUserId(uid);
            int appId = UserHandle.getAppId(uid);
            if (selinuxLabel.startsWith("u:r:untrusted_app") == true) goto L39;
            Slog.e(NativeTombstoneManager.m6445$$Nest$sfgetTAG(), "Tombstone has invalid selinux label (" + selinuxLabel + "), ignoring");
        L39:
            TombstoneFile result = new TombstoneFile(pfd);
            result.mUserId = userId;
            result.mAppId = appId;
            result.mPid = uid2;
            result.mUid = uid;
            if (crashReason2 == null) goto L43;
            r8 = crashReason2;
        L43:
            result.mProcessName = r8;
            result.mTimestampMs = timestampMs;
            result.mCrashReason = crashReason;
            return Optional.of(result);
        L34:
            ex = move-exception;
            Slog.e(NativeTombstoneManager.m6445$$Nest$sfgetTAG(), "Failed to get timestamp of tombstone", ex);
        L19:
            ex = move-exception;
            Slog.e(NativeTombstoneManager.m6445$$Nest$sfgetTAG(), "Failed to parse tombstone", ex);
            return Optional.empty();
        }

        public IParcelFileDescriptorRetriever getPfdRetriever() {
            return this.mRetriever;
        }

        public ApplicationExitInfo toAppExitInfo() {
            ApplicationExitInfo info = new ApplicationExitInfo();
            info.setPid(this.mPid);
            info.setRealUid(this.mUid);
            info.setPackageUid(this.mUid);
            info.setDefiningUid(this.mUid);
            info.setProcessName(this.mProcessName);
            info.setReason(5);
            info.setStatus(0);
            info.setImportance(1000);
            info.setPackageName("");
            info.setProcessStateSummary(null);
            info.setPss(0);
            info.setRss(0);
            info.setTimestamp(this.mTimestampMs);
            info.setDescription(this.mCrashReason);
            info.setSubReason(0);
            info.setNativeTombstoneRetriever(this.mRetriever);
            return info;
        }
    }

    class TombstoneWatcher extends FileObserver {
        final /* synthetic */ NativeTombstoneManager this$0;

        public static /* synthetic */ void $r8$lambda$A74hOANgR204PBre_Brq7oIduOU(TombstoneWatcher r0, String r1) {
            r0.lambda$onEvent$0(r1);
        }

        TombstoneWatcher(NativeTombstoneManager this$0) {
            this.this$0 = this$0;
            super(NativeTombstoneManager.m6446$$Nest$sfgetTOMBSTONE_DIR(), FrameworkStatsLog.NON_A11Y_TOOL_SERVICE_WARNING_REPORT);
        }

        @Override // android.os.FileObserver
        public void onEvent(int event, final String path) {
            if (path != null) goto L5;
            Slog.w(NativeTombstoneManager.m6445$$Nest$sfgetTAG(), "path is null at TombstoneWatcher.onEvent()");
            return;
        L5:
            NativeTombstoneManager.m6441$$Nest$fgetmHandler(this.this$0).post(new NativeTombstoneManager$TombstoneWatcher$$ExternalSyntheticLambda0(this, path));
        }

        private /* synthetic */ void lambda$onEvent$0(String path) {
            if (path.endsWith(".tmp") == false) goto L5;
            return;
        L5:
            NativeTombstoneManager.m6442$$Nest$mhandleTombstone(this.this$0, new File(NativeTombstoneManager.m6446$$Nest$sfgetTOMBSTONE_DIR(), path));
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$Ilusb-pdD7HUoXhBE6Lb5KtDR1U, reason: not valid java name */
    public static /* synthetic */ int m6440$r8$lambda$IlusbpdD7HUoXhBE6Lb5KtDR1U(ApplicationExitInfo r0, ApplicationExitInfo r1) {
        return lambda$collectTombstones$2(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$NfLcxdcUQ8MK1DWiCjJAO5FniXE(NativeTombstoneManager r0, Optional r1, Optional r2) {
        r0.lambda$purge$1(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$d5FKVJLhf8wmcpGmXSaNGRF1qVM(NativeTombstoneManager r0, int r1, int r2, int r3, ArrayList r4, int r5, CompletableFuture r6) {
        r0.lambda$collectTombstones$3(r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ void $r8$lambda$gBT9xmTreiWpNj0UDSi2eO2Yau4(NativeTombstoneManager r0) {
        r0.lambda$onSystemReady$0();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m6441$$Nest$fgetmHandler(NativeTombstoneManager r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleTombstone, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6442$$Nest$mhandleTombstone(NativeTombstoneManager r0, File r1) {
        r0.handleTombstone(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mpurgePackage, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6443$$Nest$mpurgePackage(NativeTombstoneManager r0, int r1, boolean r2) {
        r0.purgePackage(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mpurgeUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6444$$Nest$mpurgeUser(NativeTombstoneManager r0, int r1) {
        r0.purgeUser(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m6445$$Nest$sfgetTAG() {
        return TAG;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTOMBSTONE_DIR, reason: not valid java name */
    static /* bridge */ /* synthetic */ File m6446$$Nest$sfgetTOMBSTONE_DIR() {
        return TOMBSTONE_DIR;
    }

    static {
        TAG = NativeTombstoneManager.class.getSimpleName();
        TOMBSTONE_DIR = new File("/data/tombstones");
    }

    NativeTombstoneManager(Context context) {
        this.mTmpFileLock = new ReentrantLock();
        this.mLock = new Object();
        this.mTombstones = new SparseArray();
        this.mContext = context;
        ServiceThread thread = new ServiceThread(TAG + ":tombstoneWatcher", 10, true);
        thread.start();
        this.mHandler = thread.getThreadHandler();
        this.mWatcher = new TombstoneWatcher(this);
    }

    void onSystemReady() {
        registerForUserRemoval();
        registerForPackageRemoval();
        this.mWatcher.startWatching();
        BootReceiver.initDropboxRateLimiter();
        this.mHandler.post(new NativeTombstoneManager$$ExternalSyntheticLambda1(this));
    }

    private /* synthetic */ void lambda$onSystemReady$0() {
        File[] tombstoneFiles = TOMBSTONE_DIR.listFiles();
        int i = 0;
    L3:
        if (tombstoneFiles == null) goto L10;
        if (i >= tombstoneFiles.length) goto L15;
        if (tombstoneFiles[i].isFile() == false) goto L9;
        handleTombstone(tombstoneFiles[i]);
    L9:
        i = i + 1;
        goto L3
    L15:
        return;
    }

    private void handleTombstone(File path) {
        String filename = path.getName();
        if (filename.endsWith(".tmp") == false) goto L12;
        this.mTmpFileLock.lock();
        path.delete();     // Catch: Throwable -> L8
        this.mTmpFileLock.unlock();
        return;
    L8:
        th = move-exception;
        this.mTmpFileLock.unlock();
        throw th;
    L12:
        if (filename.startsWith("tombstone_") == true) goto L14;
        return;
    L14:
        boolean isProtoFile = filename.endsWith(".pb");
        if (isProtoFile == false) goto L17;
        File protoPath = path;
    L18:
        String processName = (String) handleProtoTombstone(protoPath, isProtoFile).map(new NativeTombstoneManager$$ExternalSyntheticLambda2()).orElse("UNKNOWN");
        BootReceiver.addTombstoneToDropBox(this.mContext, path, isProtoFile, processName, this.mTmpFileLock);
        Reference.reachabilityFence(this.mWatcher);
        return;
    L17:
        protoPath = new File(path.getAbsolutePath() + ".pb");
        goto L18
    }

    private Optional<TombstoneFile> handleProtoTombstone(File path, boolean addToList) {
        String filename = path.getName();
        if (filename.endsWith(".pb") == true) goto L6;
        Slog.w(TAG, "unexpected tombstone name: " + path);
        return Optional.empty();
    L6:
        String suffix = filename.substring("tombstone_".length());
        String numberStr = suffix.substring(0, suffix.length() - 3);
        int number = Integer.parseInt(numberStr);     // Catch: NumberFormatException -> L37
        if (number >= 0) goto L10;
    L35:
        Slog.w(TAG, "unexpected tombstone name: " + path);     // Catch: NumberFormatException -> L37
        return Optional.empty();
    L10:
        if (number > 99) goto L35;
        ParcelFileDescriptor pfd = ParcelFileDescriptor.open(path, LZMA2Options.DICT_SIZE_MAX);     // Catch: FileNotFoundException -> L32
        Optional<TombstoneFile> parsedTombstone = TombstoneFile.parse(pfd);
        if (parsedTombstone.isPresent() == true) goto L18;
        IoUtils.closeQuietly(pfd);
        return Optional.empty();
    L18:
        if (addToList == false) goto L31;
        Object r6 = this.mLock;
        monitor-enter(r6);
        TombstoneFile previous = this.mTombstones.get(number);     // Catch: Throwable -> L24
        if (previous == null) goto L26;
        previous.dispose();     // Catch: Throwable -> L24
    L26:
        this.mTombstones.put(number, parsedTombstone.get());     // Catch: Throwable -> L24
        monitor-exit(r6);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    L31:
        return parsedTombstone;
    L32:
        ex = move-exception;
        Slog.w(TAG, "failed to open " + path, ex);
        return Optional.empty();
    L38:
        Slog.w(TAG, "unexpected tombstone name: " + path);
        return Optional.empty();
    }

    public void purge(final Optional<Integer> userId, final Optional<Integer> appId) {
        this.mHandler.post(new NativeTombstoneManager$$ExternalSyntheticLambda4(this, userId, appId));
    }

    private /* synthetic */ void lambda$purge$1(Optional userId, Optional appId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int i = this.mTombstones.size() - 1;     // Catch: Throwable -> L9
    L5:
        if (i < 0) goto L13;
        TombstoneFile tombstone = this.mTombstones.valueAt(i);     // Catch: Throwable -> L9
        if (tombstone.matches(userId, appId) == false) goto L11;
        tombstone.purge();     // Catch: Throwable -> L9
        this.mTombstones.removeAt(i);     // Catch: Throwable -> L9
    L11:
        i = i - 1;     // Catch: Throwable -> L9
        goto L5
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void purgePackage(int uid, boolean allUsers) {
        int appId = UserHandle.getAppId(uid);
        if (allUsers == false) goto L5;
        Optional<Integer> userId = Optional.empty();
    L6:
        purge(userId, Optional.of(Integer.valueOf(appId)));
        return;
    L5:
        userId = Optional.of(Integer.valueOf(UserHandle.getUserId(uid)));
        goto L6
    }

    private void purgeUser(int uid) {
        purge(Optional.of(Integer.valueOf(uid)), Optional.empty());
    }

    private void registerForPackageRemoval() {
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.PACKAGE_FULLY_REMOVED");
        filter.addDataScheme(Settings.ATTR_PACKAGE);
        this.mContext.registerReceiverForAllUsers(new AnonymousClass1(this), filter, null, this.mHandler);
    }

    private void registerForUserRemoval() {
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.USER_REMOVED");
        this.mContext.registerReceiverForAllUsers(new AnonymousClass2(this), filter, null, this.mHandler);
    }

    public void collectTombstones(final ArrayList<ApplicationExitInfo> output, int callingUid, final int pid, final int maxNum) {
        final CompletableFuture<Object> future = new CompletableFuture();
        if (UserHandle.isApp(callingUid) == true) goto L5;
        return;
    L5:
        final int userId = UserHandle.getUserId(callingUid);
        final int appId = UserHandle.getAppId(callingUid);
        this.mHandler.post(new NativeTombstoneManager$$ExternalSyntheticLambda0(this, userId, appId, pid, output, maxNum, future));
        future.get();     // Catch: Throwable -> L8
        return;
    L8:
        ex = move-exception;
        throw new RuntimeException(ex);
    }

    private /* synthetic */ void lambda$collectTombstones$3(int userId, int appId, int pid, ArrayList output, int maxNum, CompletableFuture future) {
        boolean appendedTombstones = false;
        Object r1 = this.mLock;
        monitor-enter(r1);
        int tombstonesSize = this.mTombstones.size();     // Catch: Throwable -> L12
        int i = 0;
    L5:
        if (i >= tombstonesSize) goto L25;
        TombstoneFile tombstone = this.mTombstones.valueAt(i);     // Catch: Throwable -> L12
        if (tombstone.matches(Optional.of(Integer.valueOf(userId)), Optional.of(Integer.valueOf(appId))) == false) goto L23;
        if (pid != 0) goto L10;
    L14:
        int outputSize = output.size();     // Catch: Throwable -> L12
        int j = 0;
    L15:
        if (j >= outputSize) goto L20;
        ApplicationExitInfo exitInfo = (ApplicationExitInfo) output.get(j);     // Catch: Throwable -> L12
        if (tombstone.matches(exitInfo) == true) goto L18;
        j = j + 1;     // Catch: Throwable -> L12
        goto L15
    L18:
        exitInfo.setNativeTombstoneRetriever(tombstone.getPfdRetriever());     // Catch: Throwable -> L12
        goto L23
    L20:
        int j2 = output.size();     // Catch: Throwable -> L12
        if (j2 >= maxNum) goto L23;
        appendedTombstones = true;
        output.add(tombstone.toAppExitInfo());     // Catch: Throwable -> L12
        goto L23
    L10:
        if (tombstone.mPid == pid) goto L14;
    L23:
        i = i + 1;     // Catch: Throwable -> L12
        goto L5
    L25:
        monitor-exit(r1);     // Catch: Throwable -> L12
        if (appendedTombstones == false) goto L28;
        Collections.sort(output, new NativeTombstoneManager$$ExternalSyntheticLambda3());
    L28:
        future.complete(null);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ int lambda$collectTombstones$2(ApplicationExitInfo lhs, ApplicationExitInfo rhs) {
        long diff = rhs.getTimestamp() - lhs.getTimestamp();
        if (diff >= 0) goto L7;
        return -1;
    L7:
        if (diff != 0) goto L10;
        return 0;
    L10:
        return 1;
    }
}
