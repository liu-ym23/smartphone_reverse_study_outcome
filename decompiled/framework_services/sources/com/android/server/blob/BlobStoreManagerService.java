package com.android.server.blob;

import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.StatsManager;
import android.app.blob.BlobHandle;
import android.app.blob.BlobInfo;
import android.app.blob.IBlobStoreManager;
import android.app.blob.IBlobStoreSession;
import android.app.blob.LeaseInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManagerInternal;
import android.content.pm.PackageStats;
import android.content.res.ResourceId;
import android.content.res.Resources;
import android.os.Binder;
import android.os.Handler;
import android.os.LimitExceededException;
import android.os.ParcelFileDescriptor;
import android.os.ParcelableException;
import android.os.Process;
import android.os.RemoteCallback;
import android.os.SystemClock;
import android.os.UserHandle;
import android.os.UserManager;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.AtomicFile;
import android.util.ExceptionUtils;
import android.util.IndentingPrintWriter;
import android.util.LongSparseArray;
import android.util.Slog;
import android.util.SparseArray;
import android.util.StatsEvent;
import android.util.Xml;
import com.android.internal.os.BackgroundThread;
import com.android.internal.util.CollectionUtils;
import com.android.internal.util.ConcurrentUtils;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.FastXmlSerializer;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.Preconditions;
import com.android.internal.util.XmlUtils;
import com.android.internal.util.function.pooled.PooledLambda;
import com.android.server.LocalManagerRegistry;
import com.android.server.LocalServices;
import com.android.server.ServiceThread;
import com.android.server.SystemService;
import com.android.server.Watchdog;
import com.android.server.am.ProcessList;
import com.android.server.pm.Settings;
import com.android.server.pm.UserManagerInternal;
import com.android.server.usage.StorageStatsManagerLocal;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes.dex */
public class BlobStoreManagerService extends SystemService {
    private final ArraySet<Long> mActiveBlobIds;
    private final Handler mBackgroundHandler;
    private final Object mBlobsLock;
    private final ArrayMap<BlobHandle, BlobMetadata> mBlobsMap;
    private final Context mContext;
    private long mCurrentMaxSessionId;
    private final Handler mHandler;
    private final Injector mInjector;
    private final ArraySet<Long> mKnownBlobIds;
    private PackageManagerInternal mPackageManagerInternal;
    private final Random mRandom;
    private final Runnable mSaveBlobsInfoRunnable;
    private final Runnable mSaveSessionsRunnable;
    private final SessionStateChangeListener mSessionStateChangeListener;
    private final SparseArray<LongSparseArray<BlobStoreSession>> mSessions;
    private StatsPullAtomCallbackImpl mStatsCallbackImpl;
    private StatsManager mStatsManager;

    private class BlobStorageStatsAugmenter implements StorageStatsManagerLocal.StorageStatsAugmenter {
        final /* synthetic */ BlobStoreManagerService this$0;

        public static /* synthetic */ void $r8$lambda$09GQ4O7CUp7tc8KN9H0XITkaxss(int r0, AtomicLong r1, BlobStoreSession r2) {
            lambda$augmentStatsForUid$2(r0, r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$AOwu0AzGPcvWk6fyNUbjQrOeVWE(UserHandle r0, AtomicLong r1, BlobMetadata r2) {
            lambda$augmentStatsForUser$5(r0, r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$FZLpR04WsIuPsBcEuY83wHm4zNQ(String r0, AtomicLong r1, BlobStoreSession r2) {
            lambda$augmentStatsForPackageForUser$0(r0, r1, r2);
        }

        /* JADX INFO: renamed from: $r8$lambda$PCh5holscxwZgRE7PY3-n1a4Q4E, reason: not valid java name */
        public static /* synthetic */ void m2794$r8$lambda$PCh5holscxwZgRE7PY3n1a4Q4E(String r0, UserHandle r1, boolean r2, AtomicLong r3, BlobMetadata r4) {
            lambda$augmentStatsForPackageForUser$1(r0, r1, r2, r3, r4);
        }

        public static /* synthetic */ void $r8$lambda$YheEsoybaSyuwWNs90pi4C34YYk(AtomicLong r0, BlobStoreSession r1) {
            lambda$augmentStatsForUser$4(r0, r1);
        }

        public static /* synthetic */ void $r8$lambda$eR8bA4NtZDdCgw2kiD3OH7Or04c(int r0, boolean r1, AtomicLong r2, BlobMetadata r3) {
            lambda$augmentStatsForUid$3(r0, r1, r2, r3);
        }

        /* synthetic */ BlobStorageStatsAugmenter(BlobStoreManagerService r1, BlobStoreManagerServiceIA r2) {
            this(r1);
        }

        private BlobStorageStatsAugmenter(BlobStoreManagerService r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.usage.StorageStatsManagerLocal.StorageStatsAugmenter
        public void augmentStatsForPackageForUser(PackageStats stats, final String packageName, final UserHandle userHandle, final boolean callerHasStatsPermission) {
            final AtomicLong blobsDataSize = new AtomicLong(0);
            BlobStoreManagerService.m2779$$Nest$mforEachSessionInUser(this.this$0, new BlobStoreManagerService$BlobStorageStatsAugmenter$$ExternalSyntheticLambda2(packageName, blobsDataSize), userHandle.getIdentifier());
            BlobStoreManagerService.m2778$$Nest$mforEachBlob(this.this$0, new BlobStoreManagerService$BlobStorageStatsAugmenter$$ExternalSyntheticLambda3(packageName, userHandle, callerHasStatsPermission, blobsDataSize));
            stats.dataSize += blobsDataSize.get();
        }

        private static /* synthetic */ void lambda$augmentStatsForPackageForUser$0(String packageName, AtomicLong blobsDataSize, BlobStoreSession session) {
            if (session.getOwnerPackageName().equals(packageName) == false) goto L6;
            blobsDataSize.getAndAdd(session.getSize());
            return;
        }

        private static /* synthetic */ void lambda$augmentStatsForPackageForUser$1(String packageName, UserHandle userHandle, boolean callerHasStatsPermission, AtomicLong blobsDataSize, BlobMetadata blobMetadata) {
            if (blobMetadata.shouldAttributeToLeasee(packageName, userHandle.getIdentifier(), callerHasStatsPermission) == false) goto L6;
            blobsDataSize.getAndAdd(blobMetadata.getSize());
            return;
        }

        @Override // com.android.server.usage.StorageStatsManagerLocal.StorageStatsAugmenter
        public void augmentStatsForUid(PackageStats stats, final int uid, final boolean callerHasStatsPermission) {
            int userId = UserHandle.getUserId(uid);
            final AtomicLong blobsDataSize = new AtomicLong(0);
            BlobStoreManagerService.m2779$$Nest$mforEachSessionInUser(this.this$0, new BlobStoreManagerService$BlobStorageStatsAugmenter$$ExternalSyntheticLambda0(uid, blobsDataSize), userId);
            BlobStoreManagerService.m2778$$Nest$mforEachBlob(this.this$0, new BlobStoreManagerService$BlobStorageStatsAugmenter$$ExternalSyntheticLambda1(uid, callerHasStatsPermission, blobsDataSize));
            stats.dataSize += blobsDataSize.get();
        }

        private static /* synthetic */ void lambda$augmentStatsForUid$2(int uid, AtomicLong blobsDataSize, BlobStoreSession session) {
            if (session.getOwnerUid() != uid) goto L6;
            blobsDataSize.getAndAdd(session.getSize());
            return;
        }

        private static /* synthetic */ void lambda$augmentStatsForUid$3(int uid, boolean callerHasStatsPermission, AtomicLong blobsDataSize, BlobMetadata blobMetadata) {
            if (blobMetadata.shouldAttributeToLeasee(uid, callerHasStatsPermission) == false) goto L6;
            blobsDataSize.getAndAdd(blobMetadata.getSize());
            return;
        }

        @Override // com.android.server.usage.StorageStatsManagerLocal.StorageStatsAugmenter
        public void augmentStatsForUser(PackageStats stats, final UserHandle userHandle) {
            final AtomicLong blobsDataSize = new AtomicLong(0);
            BlobStoreManagerService.m2779$$Nest$mforEachSessionInUser(this.this$0, new BlobStoreManagerService$BlobStorageStatsAugmenter$$ExternalSyntheticLambda4(blobsDataSize), userHandle.getIdentifier());
            BlobStoreManagerService.m2778$$Nest$mforEachBlob(this.this$0, new BlobStoreManagerService$BlobStorageStatsAugmenter$$ExternalSyntheticLambda5(userHandle, blobsDataSize));
            stats.dataSize += blobsDataSize.get();
        }

        private static /* synthetic */ void lambda$augmentStatsForUser$4(AtomicLong blobsDataSize, BlobStoreSession session) {
            blobsDataSize.getAndAdd(session.getSize());
        }

        private static /* synthetic */ void lambda$augmentStatsForUser$5(UserHandle userHandle, AtomicLong blobsDataSize, BlobMetadata blobMetadata) {
            if (blobMetadata.shouldAttributeToUser(userHandle.getIdentifier()) == false) goto L6;
            blobsDataSize.getAndAdd(blobMetadata.getSize());
            return;
        }
    }

    static final class DumpArgs {
        private static final int FLAG_DUMP_BLOBS = 2;
        private static final int FLAG_DUMP_CONFIG = 4;
        private static final int FLAG_DUMP_SESSIONS = 1;
        private boolean mDumpAll;
        private final ArrayList<Long> mDumpBlobIds;
        private boolean mDumpHelp;
        private final ArrayList<String> mDumpPackages;
        private final ArrayList<Integer> mDumpUids;
        private boolean mDumpUnredacted;
        private final ArrayList<Integer> mDumpUserIds;
        private int mSelectedSectionFlags;

        /* JADX INFO: renamed from: -$$Nest$mdumpArgsUsage, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m2795$$Nest$mdumpArgsUsage(DumpArgs r0, IndentingPrintWriter r1) {
            r0.dumpArgsUsage(r1);
        }

        public boolean shouldDumpSession(String packageName, int uid, long blobId) {
            if (CollectionUtils.isEmpty(this.mDumpPackages) == true) goto L8;
            if (this.mDumpPackages.indexOf(packageName) >= 0) goto L8;
            return false;
        L8:
            if (CollectionUtils.isEmpty(this.mDumpUids) == true) goto L13;
            if (this.mDumpUids.indexOf(Integer.valueOf(uid)) >= 0) goto L13;
            return false;
        L13:
            if (CollectionUtils.isEmpty(this.mDumpBlobIds) == false) goto L15;
            return true;
        L15:
            if (this.mDumpBlobIds.indexOf(Long.valueOf(blobId)) >= 0) goto L19;
            return false;
        L19:
            return true;
        }

        public boolean shouldDumpAllSections() {
            if (this.mDumpAll == false) goto L5;
        L8:
            return true;
        L5:
            if (this.mSelectedSectionFlags == 0) goto L8;
            return false;
        }

        public void allowDumpSessions() {
            this.mSelectedSectionFlags |= 1;
        }

        public boolean shouldDumpSessions() {
            if (shouldDumpAllSections() == false) goto L6;
            return true;
        L6:
            if ((this.mSelectedSectionFlags & 1) != 0) goto L10;
            return false;
        L10:
            return true;
        }

        public void allowDumpBlobs() {
            this.mSelectedSectionFlags |= 2;
        }

        public boolean shouldDumpBlobs() {
            if (shouldDumpAllSections() == false) goto L6;
            return true;
        L6:
            if ((this.mSelectedSectionFlags & 2) != 0) goto L10;
            return false;
        L10:
            return true;
        }

        public void allowDumpConfig() {
            this.mSelectedSectionFlags |= 4;
        }

        public boolean shouldDumpConfig() {
            if (shouldDumpAllSections() == false) goto L6;
            return true;
        L6:
            if ((this.mSelectedSectionFlags & 4) != 0) goto L10;
            return false;
        L10:
            return true;
        }

        public boolean shouldDumpBlob(long blobId) {
            if (CollectionUtils.isEmpty(this.mDumpBlobIds) == false) goto L5;
        L8:
            return true;
        L5:
            if (this.mDumpBlobIds.indexOf(Long.valueOf(blobId)) >= 0) goto L8;
            return false;
        }

        public boolean shouldDumpFull() {
            return this.mDumpUnredacted;
        }

        public boolean shouldDumpUser(int userId) {
            if (CollectionUtils.isEmpty(this.mDumpUserIds) == false) goto L5;
        L8:
            return true;
        L5:
            if (this.mDumpUserIds.indexOf(Integer.valueOf(userId)) >= 0) goto L8;
            return false;
        }

        public boolean shouldDumpHelp() {
            return this.mDumpHelp;
        }

        private DumpArgs() {
            this.mDumpPackages = new ArrayList();
            this.mDumpUids = new ArrayList();
            this.mDumpUserIds = new ArrayList();
            this.mDumpBlobIds = new ArrayList();
        }

        public static DumpArgs parse(String[] args) {
            DumpArgs dumpArgs = new DumpArgs();
            if (args != null) goto L5;
            return dumpArgs;
        L5:
            int i = 0;
        L7:
            if (i >= args.length) goto L60;
            String opt = args[i];
            if ("--all".equals(opt) == false) goto L11;
        L57:
            dumpArgs.mDumpAll = true;
        L58:
            i = i + 1;
            goto L7
        L11:
            if ("-a".equals(opt) == true) goto L57;
            if ("--unredacted".equals(opt) == false) goto L16;
        L52:
            int callingUid = Binder.getCallingUid();
            if (callingUid == 2000) goto L55;
            if (callingUid != 0) goto L58;
        L55:
            dumpArgs.mDumpUnredacted = true;
            goto L58
        L16:
            if ("-u".equals(opt) == true) goto L52;
            if ("--sessions".equals(opt) == false) goto L22;
            dumpArgs.allowDumpSessions();
            goto L58
        L22:
            if ("--blobs".equals(opt) == false) goto L25;
            dumpArgs.allowDumpBlobs();
            goto L58
        L25:
            if ("--config".equals(opt) == false) goto L28;
            dumpArgs.allowDumpConfig();
            goto L58
        L28:
            if ("--package".equals(opt) == false) goto L30;
        L51:
            i = i + 1;
            dumpArgs.mDumpPackages.add(getStringArgRequired(args, i, "packageName"));
            goto L58
        L30:
            if ("-p".equals(opt) == true) goto L51;
            if ("--uid".equals(opt) == false) goto L36;
            i = i + 1;
            dumpArgs.mDumpUids.add(Integer.valueOf(getIntArgRequired(args, i, "uid")));
            goto L58
        L36:
            if ("--user".equals(opt) == false) goto L39;
            i = i + 1;
            dumpArgs.mDumpUserIds.add(Integer.valueOf(getIntArgRequired(args, i, "userId")));
            goto L58
        L39:
            if ("--blob".equals(opt) == false) goto L41;
        L50:
            i = i + 1;
            dumpArgs.mDumpBlobIds.add(Long.valueOf(getLongArgRequired(args, i, "blobId")));
            goto L58
        L41:
            if ("-b".equals(opt) == true) goto L50;
            if ("--help".equals(opt) == false) goto L46;
        L49:
            dumpArgs.mDumpHelp = true;
            goto L58
        L46:
            if ("-h".equals(opt) == true) goto L49;
            dumpArgs.mDumpBlobIds.add(Long.valueOf(getLongArgRequired(args, i, "blobId")));
            goto L58
        L60:
            return dumpArgs;
        }

        private static String getStringArgRequired(String[] args, int index, String argName) {
            if (index >= args.length) goto L7;
            return args[index];
        L7:
            throw new IllegalArgumentException("Missing " + argName);
        }

        private static int getIntArgRequired(String[] args, int index, String argName) {
            if (index >= args.length) goto L10;
            int value = Integer.parseInt(args[index]);     // Catch: NumberFormatException -> L6
            return value;
        L8:
            throw new IllegalArgumentException("Invalid " + argName + ": " + args[index]);
        L10:
            throw new IllegalArgumentException("Missing " + argName);
        }

        private static long getLongArgRequired(String[] args, int index, String argName) {
            if (index >= args.length) goto L10;
            long value = Long.parseLong(args[index]);     // Catch: NumberFormatException -> L6
            return value;
        L8:
            throw new IllegalArgumentException("Invalid " + argName + ": " + args[index]);
        L10:
            throw new IllegalArgumentException("Missing " + argName);
        }

        private void dumpArgsUsage(IndentingPrintWriter pw) {
            pw.println("--help | -h");
            printWithIndent(pw, "Dump this help text");
            pw.println("--sessions");
            printWithIndent(pw, "Dump only the sessions info");
            pw.println("--blobs");
            printWithIndent(pw, "Dump only the committed blobs info");
            pw.println("--config");
            printWithIndent(pw, "Dump only the config values");
            pw.println("--package | -p [package-name]");
            printWithIndent(pw, "Dump blobs info associated with the given package");
            pw.println("--uid | -u [uid]");
            printWithIndent(pw, "Dump blobs info associated with the given uid");
            pw.println("--user [user-id]");
            printWithIndent(pw, "Dump blobs info in the given user");
            pw.println("--blob | -b [session-id | blob-id]");
            printWithIndent(pw, "Dump blob info corresponding to the given ID");
            pw.println("--full | -f");
            printWithIndent(pw, "Dump full unredacted blobs data");
        }

        private void printWithIndent(IndentingPrintWriter pw, String str) {
            pw.increaseIndent();
            pw.println(str);
            pw.decreaseIndent();
        }
    }

    static class Injector {
        Injector() {
        }

        public Handler initializeMessageHandler() {
            return BlobStoreManagerService.m2793$$Nest$sminitializeMessageHandler();
        }

        public Handler getBackgroundHandler() {
            return BackgroundThread.getHandler();
        }
    }

    private class LocalService extends BlobStoreManagerInternal {
        final /* synthetic */ BlobStoreManagerService this$0;

        /* synthetic */ LocalService(BlobStoreManagerService r1, BlobStoreManagerServiceIA r2) {
            this(r1);
        }

        private LocalService(BlobStoreManagerService r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.blob.BlobStoreManagerInternal
        public void onIdleMaintenance() {
            this.this$0.runIdleMaintenance();
        }
    }

    private class PackageChangedReceiver extends BroadcastReceiver {
        final /* synthetic */ BlobStoreManagerService this$0;

        /* synthetic */ PackageChangedReceiver(BlobStoreManagerService r1, BlobStoreManagerServiceIA r2) {
            this(r1);
        }

        private PackageChangedReceiver(BlobStoreManagerService r1) {
            this.this$0 = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (BlobStoreConfig.LOGV == false) goto L5;
            Slog.v(BlobStoreConfig.TAG, "Received " + intent);
        L5:
            String action = intent.getAction();
            if (action != null) goto L9;
            return;
        L9:
            switch(action.hashCode()) {
                case 267468725: goto L15;
                case 1580442797: goto L12;
                default: goto L17;
            };
        L17:
            byte r2 = -1;
        L18:
            switch(r2) {
                case 0: goto L20;
                case 1: goto L20;
                default: goto L19;
            };
        L19:
            Slog.wtf(BlobStoreConfig.TAG, "Received unknown intent: " + intent);
            return;
        L20:
            String packageName = intent.getData().getSchemeSpecificPart();
            if (packageName != null) goto L24;
            Slog.wtf(BlobStoreConfig.TAG, "Package name is missing in the intent: " + intent);
            return;
        L24:
            int uid = intent.getIntExtra("android.intent.extra.UID", -1);
            if (uid != (-1)) goto L28;
            Slog.wtf(BlobStoreConfig.TAG, "uid is missing in the intent: " + intent);
            return;
        L28:
            this.this$0.handlePackageRemoved(packageName, uid);
            return;
        L12:
            if (action.equals("android.intent.action.PACKAGE_FULLY_REMOVED") == false) goto L30;
            r2 = 0;
            goto L18
        L30:
            r2 = -1;
            goto L18
        L15:
            if (action.equals("android.intent.action.PACKAGE_DATA_CLEARED") == false) goto L31;
            r2 = 1;
            goto L18
        L31:
            r2 = -1;
            goto L18
        }
    }

    class SessionStateChangeListener {
        final /* synthetic */ BlobStoreManagerService this$0;

        public static /* synthetic */ void $r8$lambda$lKKnpM1TDL2HbFmeEWmmuGryRfs(BlobStoreManagerService r0, BlobStoreSession r1) {
            BlobStoreManagerService.m2785$$Nest$monStateChangedInternal(r0, r1);
        }

        SessionStateChangeListener(BlobStoreManagerService this$0) {
            this.this$0 = this$0;
        }

        public void onStateChanged(BlobStoreSession session) {
            BlobStoreManagerService.m2771$$Nest$fgetmHandler(this.this$0).post(PooledLambda.obtainRunnable(new BlobStoreManagerService$SessionStateChangeListener$$ExternalSyntheticLambda0(), this.this$0, session).recycleOnUse());
        }
    }

    private class StatsPullAtomCallbackImpl implements StatsManager.StatsPullAtomCallback {
        final /* synthetic */ BlobStoreManagerService this$0;

        /* synthetic */ StatsPullAtomCallbackImpl(BlobStoreManagerService r1, BlobStoreManagerServiceIA r2) {
            this(r1);
        }

        private StatsPullAtomCallbackImpl(BlobStoreManagerService r1) {
            this.this$0 = r1;
        }

        public int onPullAtom(int atomTag, List<StatsEvent> data) {
            switch(atomTag) {
                case 10081: goto L6;
                default: goto L4;
            };
        L4:
            throw new UnsupportedOperationException("Unknown tagId=" + atomTag);
        L6:
            return BlobStoreManagerService.m2788$$Nest$mpullBlobData(this.this$0, atomTag, data);
        }
    }

    private class Stub extends IBlobStoreManager.Stub {
        final /* synthetic */ BlobStoreManagerService this$0;

        public static /* synthetic */ void $r8$lambda$anNx8ifZjpYhMeXBQFMPfbsVqww(Stub r0, RemoteCallback r1) {
            r0.lambda$waitForIdle$1(r1);
        }

        public static /* synthetic */ void $r8$lambda$cPSuafR8hU_kGuIwYnyURKkOCF0(Stub r0, RemoteCallback r1) {
            r0.lambda$waitForIdle$0(r1);
        }

        /* synthetic */ Stub(BlobStoreManagerService r1, BlobStoreManagerServiceIA r2) {
            this(r1);
        }

        private Stub(BlobStoreManagerService r1) {
            this.this$0 = r1;
        }

        public long createSession(BlobHandle blobHandle, String packageName) {
            blobHandle.getClass();
            blobHandle.assertIsValid();
            packageName.getClass();
            int callingUid = Binder.getCallingUid();
            BlobStoreManagerService.m2792$$Nest$mverifyCallingPackage(this.this$0, callingUid, packageName);
            if (BlobStoreManagerService.m2784$$Nest$misAllowedBlobStoreAccess(this.this$0, callingUid, packageName) == false) goto L10;
            return BlobStoreManagerService.m2774$$Nest$mcreateSessionInternal(this.this$0, blobHandle, callingUid, packageName);
        L6:
            e = move-exception;
            throw new ParcelableException(e);
        L10:
            throw new SecurityException("Caller not allowed to create session; callingUid=" + callingUid + ", callingPackage=" + packageName);
        }

        public IBlobStoreSession openSession(long sessionId, String packageName) {
            Preconditions.checkArgumentPositive(sessionId, "sessionId must be positive: " + sessionId);
            packageName.getClass();
            int callingUid = Binder.getCallingUid();
            BlobStoreManagerService.m2792$$Nest$mverifyCallingPackage(this.this$0, callingUid, packageName);
            return BlobStoreManagerService.m2787$$Nest$mopenSessionInternal(this.this$0, sessionId, callingUid, packageName);
        }

        public void abandonSession(long sessionId, String packageName) {
            Preconditions.checkArgumentPositive(sessionId, "sessionId must be positive: " + sessionId);
            packageName.getClass();
            int callingUid = Binder.getCallingUid();
            BlobStoreManagerService.m2792$$Nest$mverifyCallingPackage(this.this$0, callingUid, packageName);
            BlobStoreManagerService.m2772$$Nest$mabandonSessionInternal(this.this$0, sessionId, callingUid, packageName);
        }

        public ParcelFileDescriptor openBlob(BlobHandle blobHandle, String packageName) {
            blobHandle.getClass();
            blobHandle.assertIsValid();
            packageName.getClass();
            int callingUid = Binder.getCallingUid();
            BlobStoreManagerService.m2792$$Nest$mverifyCallingPackage(this.this$0, callingUid, packageName);
            if (BlobStoreManagerService.m2784$$Nest$misAllowedBlobStoreAccess(this.this$0, callingUid, packageName) == false) goto L10;
            return BlobStoreManagerService.m2786$$Nest$mopenBlobInternal(this.this$0, blobHandle, callingUid, packageName);
        L6:
            e = move-exception;
            throw ExceptionUtils.wrap(e);
        L10:
            throw new SecurityException("Caller not allowed to open blob; callingUid=" + callingUid + ", callingPackage=" + packageName);
        }

        public void acquireLease(BlobHandle blobHandle, int descriptionResId, CharSequence description, long leaseExpiryTimeMillis, String packageName) {
            blobHandle.getClass();
            blobHandle.assertIsValid();
            if (ResourceId.isValid(descriptionResId) == true) goto L7;
            if (description != null) goto L7;
            boolean r0 = false;
        L8:
            Preconditions.checkArgument(r0, "Description must be valid; descriptionId=" + descriptionResId + ", description=" + description);
            Preconditions.checkArgumentNonnegative(leaseExpiryTimeMillis, "leaseExpiryTimeMillis must not be negative");
            packageName.getClass();
            CharSequence description2 = BlobStoreConfig.getTruncatedLeaseDescription(description);
            int callingUid = Binder.getCallingUid();
            BlobStoreManagerService.m2792$$Nest$mverifyCallingPackage(this.this$0, callingUid, packageName);
            if (BlobStoreManagerService.m2784$$Nest$misAllowedBlobStoreAccess(this.this$0, callingUid, packageName) == false) goto L27;
        L28:
            BlobStoreManagerService.m2773$$Nest$macquireLeaseInternal(this.this$0, blobHandle, descriptionResId, description2, leaseExpiryTimeMillis, callingUid, packageName);     // Catch: LimitExceededException -> L14 Resources.NotFoundException -> L16
            return;
        L16:
            e = move-exception;
            Resources.NotFoundException e = e;
        L25:
            throw new IllegalArgumentException(e);
        L14:
            e = move-exception;
            LimitExceededException e2 = e;
        L21:
            throw new ParcelableException(e2);
        L22:
            e = move-exception;
            e = e;
        L18:
            e = move-exception;
            e2 = e;
            goto L21
        L27:
            throw new SecurityException("Caller not allowed to open blob; callingUid=" + callingUid + ", callingPackage=" + packageName);
        L7:
            r0 = true;
            goto L8
        }

        public void releaseLease(BlobHandle blobHandle, String packageName) {
            blobHandle.getClass();
            blobHandle.assertIsValid();
            packageName.getClass();
            int callingUid = Binder.getCallingUid();
            BlobStoreManagerService.m2792$$Nest$mverifyCallingPackage(this.this$0, callingUid, packageName);
            if (BlobStoreManagerService.m2784$$Nest$misAllowedBlobStoreAccess(this.this$0, callingUid, packageName) == false) goto L7;
            BlobStoreManagerService.m2791$$Nest$mreleaseLeaseInternal(this.this$0, blobHandle, callingUid, packageName);
            return;
        L7:
            throw new SecurityException("Caller not allowed to open blob; callingUid=" + callingUid + ", callingPackage=" + packageName);
        }

        public void releaseAllLeases(String packageName) {
            packageName.getClass();
            int callingUid = Binder.getCallingUid();
            BlobStoreManagerService.m2792$$Nest$mverifyCallingPackage(this.this$0, callingUid, packageName);
            if (BlobStoreManagerService.m2784$$Nest$misAllowedBlobStoreAccess(this.this$0, callingUid, packageName) == false) goto L7;
            BlobStoreManagerService.m2790$$Nest$mreleaseAllLeasesInternal(this.this$0, callingUid, packageName);
            return;
        L7:
            throw new SecurityException("Caller not allowed to open blob; callingUid=" + callingUid + ", callingPackage=" + packageName);
        }

        public long getRemainingLeaseQuotaBytes(String packageName) {
            int callingUid = Binder.getCallingUid();
            BlobStoreManagerService.m2792$$Nest$mverifyCallingPackage(this.this$0, callingUid, packageName);
            return BlobStoreManagerService.m2782$$Nest$mgetRemainingLeaseQuotaBytesInternal(this.this$0, callingUid, packageName);
        }

        public void waitForIdle(final RemoteCallback remoteCallback) {
            remoteCallback.getClass();
            BlobStoreManagerService.m2769$$Nest$fgetmContext(this.this$0).enforceCallingOrSelfPermission("android.permission.DUMP", "Caller is not allowed to call this; caller=" + Binder.getCallingUid());
            BlobStoreManagerService.m2771$$Nest$fgetmHandler(this.this$0).post(new BlobStoreManagerService$Stub$$ExternalSyntheticLambda0(this, remoteCallback));
        }

        private /* synthetic */ void lambda$waitForIdle$1(final RemoteCallback remoteCallback) {
            BlobStoreManagerService.m2767$$Nest$fgetmBackgroundHandler(this.this$0).post(new BlobStoreManagerService$Stub$$ExternalSyntheticLambda1(this, remoteCallback));
        }

        private /* synthetic */ void lambda$waitForIdle$0(final RemoteCallback remoteCallback) {
            Handler r0 = BlobStoreManagerService.m2771$$Nest$fgetmHandler(this.this$0);
            remoteCallback.getClass();
            r0.post(PooledLambda.obtainRunnable(new BlobStoreManagerService$Stub$$ExternalSyntheticLambda2(remoteCallback), null).recycleOnUse());
        }

        public List<BlobInfo> queryBlobsForUser(int userId) {
            verifyCallerIsSystemUid("queryBlobsForUser");
            if (userId != (-2)) goto L5;
            int resolvedUserId = ActivityManager.getCurrentUser();
        L6:
            ActivityManagerInternal amInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
            amInternal.ensureNotSpecialUser(resolvedUserId);
            return BlobStoreManagerService.m2789$$Nest$mqueryBlobsForUserInternal(this.this$0, resolvedUserId);
        L5:
            resolvedUserId = userId;
            goto L6
        }

        public void deleteBlob(long blobId) {
            verifyCallerIsSystemUid("deleteBlob");
            BlobStoreManagerService.m2775$$Nest$mdeleteBlobInternal(this.this$0, blobId);
        }

        public List<BlobHandle> getLeasedBlobs(String packageName) {
            packageName.getClass();
            int callingUid = Binder.getCallingUid();
            BlobStoreManagerService.m2792$$Nest$mverifyCallingPackage(this.this$0, callingUid, packageName);
            return BlobStoreManagerService.m2781$$Nest$mgetLeasedBlobsInternal(this.this$0, callingUid, packageName);
        }

        public LeaseInfo getLeaseInfo(BlobHandle blobHandle, String packageName) {
            blobHandle.getClass();
            blobHandle.assertIsValid();
            packageName.getClass();
            int callingUid = Binder.getCallingUid();
            BlobStoreManagerService.m2792$$Nest$mverifyCallingPackage(this.this$0, callingUid, packageName);
            if (BlobStoreManagerService.m2784$$Nest$misAllowedBlobStoreAccess(this.this$0, callingUid, packageName) == false) goto L7;
            return BlobStoreManagerService.m2780$$Nest$mgetLeaseInfoInternal(this.this$0, blobHandle, callingUid, packageName);
        L7:
            throw new SecurityException("Caller not allowed to open blob; callingUid=" + callingUid + ", callingPackage=" + packageName);
        }

        public void dump(FileDescriptor fd, PrintWriter writer, String[] args) {
            if (DumpUtils.checkDumpAndUsageStatsPermission(BlobStoreManagerService.m2769$$Nest$fgetmContext(this.this$0), BlobStoreConfig.TAG, writer) == true) goto L5;
            return;
        L5:
            DumpArgs dumpArgs = DumpArgs.parse(args);
            IndentingPrintWriter fout = new IndentingPrintWriter(writer, "    ");
            if (dumpArgs.shouldDumpHelp() == false) goto L9;
            writer.println("dumpsys blob_store [options]:");
            fout.increaseIndent();
            DumpArgs.m2795$$Nest$mdumpArgsUsage(dumpArgs, fout);
            fout.decreaseIndent();
            return;
        L9:
            Object r2 = BlobStoreManagerService.m2768$$Nest$fgetmBlobsLock(this.this$0);
            monitor-enter(r2);
        L14:
            th = move-exception;
            throw th;
        L12:
            if (dumpArgs.shouldDumpAllSections() == false) goto L17;
            fout.println("mCurrentMaxSessionId: " + BlobStoreManagerService.m2770$$Nest$fgetmCurrentMaxSessionId(this.this$0));     // Catch: Throwable -> L14
            fout.println();     // Catch: Throwable -> L14
        L17:
            if (dumpArgs.shouldDumpSessions() == false) goto L20;
            BlobStoreManagerService.m2777$$Nest$mdumpSessionsLocked(this.this$0, fout, dumpArgs);     // Catch: Throwable -> L14
            fout.println();     // Catch: Throwable -> L14
        L20:
            if (dumpArgs.shouldDumpBlobs() == false) goto L22;
            BlobStoreManagerService.m2776$$Nest$mdumpBlobsLocked(this.this$0, fout, dumpArgs);     // Catch: Throwable -> L14
            fout.println();     // Catch: Throwable -> L14
        L22:
            monitor-exit(r2);     // Catch: Throwable -> L14
            if (dumpArgs.shouldDumpConfig() == false) goto L31;
            fout.println("BlobStore config:");
            fout.increaseIndent();
            BlobStoreConfig.dump(fout, BlobStoreManagerService.m2769$$Nest$fgetmContext(this.this$0));
            fout.decreaseIndent();
            fout.println();
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int handleShellCommand(ParcelFileDescriptor in, ParcelFileDescriptor out, ParcelFileDescriptor err, String[] args) {
            return new BlobStoreManagerShellCommand(this.this$0).exec(this, in.getFileDescriptor(), out.getFileDescriptor(), err.getFileDescriptor(), args);
        }

        private void verifyCallerIsSystemUid(String operation) {
            if (UserHandle.getCallingAppId() != 1000) goto L8;
            if (((UserManager) BlobStoreManagerService.m2769$$Nest$fgetmContext(this.this$0).getSystemService(UserManager.class)).isUserAdmin(UserHandle.getCallingUserId()) == false) goto L8;
            return;
        L8:
            throw new SecurityException("Only admin user's app with system uidare allowed to call #" + operation);
        }
    }

    private class UserActionReceiver extends BroadcastReceiver {
        final /* synthetic */ BlobStoreManagerService this$0;

        /* synthetic */ UserActionReceiver(BlobStoreManagerService r1, BlobStoreManagerServiceIA r2) {
            this(r1);
        }

        private UserActionReceiver(BlobStoreManagerService r1) {
            this.this$0 = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (BlobStoreConfig.LOGV == false) goto L5;
            Slog.v(BlobStoreConfig.TAG, "Received: " + intent);
        L5:
            String action = intent.getAction();
            if (action != null) goto L9;
            return;
        L9:
            switch(action.hashCode()) {
                case -2061058799: goto L12;
                default: goto L14;
            };
        L14:
            byte r2 = -1;
        L15:
            switch(r2) {
                case 0: goto L17;
                default: goto L16;
            };
        L16:
            Slog.wtf(BlobStoreConfig.TAG, "Received unknown intent: " + intent);
            return;
        L17:
            int userId = intent.getIntExtra("android.intent.extra.user_handle", ProcessList.INVALID_ADJ);
            if (userId != (-10000)) goto L21;
            Slog.wtf(BlobStoreConfig.TAG, "userId is missing in the intent: " + intent);
            return;
        L21:
            BlobStoreManagerService.m2783$$Nest$mhandleUserRemoved(this.this$0, userId);
            return;
        L12:
            if (action.equals("android.intent.action.USER_REMOVED") == false) goto L14;
            r2 = 0;
            goto L15
        }
    }

    public static /* synthetic */ void $r8$lambda$0ytwkglV5A2uuFGSYNb4l2HFKGo(String r0, int r1, AtomicInteger r2, BlobMetadata r3) {
        lambda$getCommittedBlobsCountLocked$1(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$7qG5X1cM3OW5B0qKyeHBOKqvzVk(List r0, int r1, BlobMetadata r2) {
        lambda$pullBlobData$18(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$8Hq5UmRrhCH0PYxgugGERpL62Wg(BlobStoreManagerService r0, BlobStoreSession r1) {
        r0.lambda$onStateChangedInternal$11(r1);
    }

    public static /* synthetic */ void $r8$lambda$9G0mmoAjtGbS_dVBrFj43WVXO8U(int r0, String r1, AtomicInteger r2, BlobStoreSession r3) {
        lambda$getSessionsCountLocked$0(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$9QH9tE2KwJtJCha1PEiQ8hLq24c(String r0, int r1, ArrayList r2, BlobMetadata r3) {
        lambda$getLeasedBlobsInternal$10(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$IwM-S_TyCx8EnxI4FZDzwMKgQwU, reason: not valid java name */
    public static /* synthetic */ boolean m2763$r8$lambda$IwMS_TyCx8EnxI4FZDzwMKgQwU(BlobStoreManagerService r0, ArrayList r1, long r2, BlobStoreSession r4) {
        return r0.lambda$handleIdleMaintenanceLocked$16(r1, r2, r4);
    }

    public static /* synthetic */ boolean $r8$lambda$QObdd50KEuO0Zoabn7qfgcJMiV0(BlobStoreManagerService r0, ArrayList r1, Map.Entry r2) {
        return r0.lambda$handleIdleMaintenanceLocked$15(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$SvGKgtfGPgBTiAOr_MdW4oel9V8(BlobStoreManagerService r0, BlobHandle r1, BlobMetadata r2) {
        r0.lambda$releaseLeaseInternal$4(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$V4gGEvcFKQDxLTFpMr1ToNjkmU4(BlobStoreManagerService r0) {
        r0.writeBlobsInfo();
    }

    public static /* synthetic */ void $r8$lambda$XuNcNGqZ3e2vnpPfBW4YvuY_wkc(int r0, Function r1, ArrayList r2, BlobHandle r3, BlobMetadata r4) {
        lambda$queryBlobsForUserInternal$8(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ boolean $r8$lambda$Z4Qf0KJRFQZWa1_z6xsyOqVW1Bw(BlobStoreManagerService r0, int r1, String r2, long r3, BlobStoreSession r5) {
        return r0.lambda$handlePackageRemoved$12(r1, r2, r3, r5);
    }

    /* JADX INFO: renamed from: $r8$lambda$ZUP_y-X2GBlFrN5kkns8zTbffT8, reason: not valid java name */
    public static /* synthetic */ boolean m2764$r8$lambda$ZUP_yX2GBlFrN5kkns8zTbffT8(BlobStoreManagerService r0, String r1, int r2, Map.Entry r3) {
        return r0.lambda$handlePackageRemoved$13(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$ZYOGhLhMsWlcZJixeCC0iSZ72lI(int r0, Function r1, BlobHandle r2, ArrayList r3, BlobMetadata.Leasee r4) {
        lambda$queryBlobsForUserInternal$7(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ boolean $r8$lambda$_rRZQF5Q94MAvjy2UAgC2t8Uinw(BlobStoreManagerService r0, long r1, Map.Entry r3) {
        return r0.lambda$deleteBlobInternal$9(r1, r3);
    }

    public static /* synthetic */ Resources $r8$lambda$gm1CnRCO28W1lmDyAHqQwKJMtE4(BlobStoreManagerService r0, ArrayMap r1, int r2, String r3) {
        return r0.lambda$queryBlobsForUserInternal$6(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$k9GgOj2cvgCNP5k8CL7l4UvOMME(BlobStoreManagerService r0) {
        r0.writeBlobSessions();
    }

    public static /* synthetic */ void $r8$lambda$mi7kcUe7vgsvZezc6oZVERMDb7M(String r0, int r1, AtomicLong r2, BlobMetadata r3) {
        lambda$getTotalUsageBytesLocked$3(r0, r1, r2, r3);
    }

    public static /* synthetic */ boolean $r8$lambda$o4LaXAIFyINBsGKHHbxGCQPlynU(BlobStoreManagerService r0, int r1, Map.Entry r2) {
        return r0.lambda$handleUserRemoved$14(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$wN11XYtzjJYg6mR2E400kwWZkPk(String r0, int r1, AtomicInteger r2, BlobMetadata r3) {
        lambda$getLeasedBlobsCountLocked$2(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$wrwY1VBDH__VBBHiMEtKME8-U8Q, reason: not valid java name */
    public static /* synthetic */ boolean m2765$r8$lambda$wrwY1VBDH__VBBHiMEtKME8U8Q(BlobStoreManagerService r0, int r1, Map.Entry r2) {
        return r0.lambda$runClearAllBlobs$17(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$yVdFyOHO6D4KeC780-qkWnPYAqg, reason: not valid java name */
    public static /* synthetic */ void m2766$r8$lambda$yVdFyOHO6D4KeC780qkWnPYAqg(String r0, int r1, BlobHandle r2, BlobMetadata r3) {
        lambda$releaseAllLeasesInternal$5(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBackgroundHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m2767$$Nest$fgetmBackgroundHandler(BlobStoreManagerService r0) {
        return r0.mBackgroundHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBlobsLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m2768$$Nest$fgetmBlobsLock(BlobStoreManagerService r0) {
        return r0.mBlobsLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m2769$$Nest$fgetmContext(BlobStoreManagerService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCurrentMaxSessionId, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m2770$$Nest$fgetmCurrentMaxSessionId(BlobStoreManagerService r2) {
        return r2.mCurrentMaxSessionId;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m2771$$Nest$fgetmHandler(BlobStoreManagerService r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$mabandonSessionInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2772$$Nest$mabandonSessionInternal(BlobStoreManagerService r0, long r1, int r3, String r4) {
        r0.abandonSessionInternal(r1, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$macquireLeaseInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2773$$Nest$macquireLeaseInternal(BlobStoreManagerService r0, BlobHandle r1, int r2, CharSequence r3, long r4, int r6, String r7) {
        r0.acquireLeaseInternal(r1, r2, r3, r4, r6, r7);
    }

    /* JADX INFO: renamed from: -$$Nest$mcreateSessionInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m2774$$Nest$mcreateSessionInternal(BlobStoreManagerService r0, BlobHandle r1, int r2, String r3) {
        return r0.createSessionInternal(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mdeleteBlobInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2775$$Nest$mdeleteBlobInternal(BlobStoreManagerService r0, long r1) {
        r0.deleteBlobInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mdumpBlobsLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2776$$Nest$mdumpBlobsLocked(BlobStoreManagerService r0, IndentingPrintWriter r1, DumpArgs r2) {
        r0.dumpBlobsLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mdumpSessionsLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2777$$Nest$mdumpSessionsLocked(BlobStoreManagerService r0, IndentingPrintWriter r1, DumpArgs r2) {
        r0.dumpSessionsLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mforEachBlob, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2778$$Nest$mforEachBlob(BlobStoreManagerService r0, Consumer r1) {
        r0.forEachBlob(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mforEachSessionInUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2779$$Nest$mforEachSessionInUser(BlobStoreManagerService r0, Consumer r1, int r2) {
        r0.forEachSessionInUser(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetLeaseInfoInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ LeaseInfo m2780$$Nest$mgetLeaseInfoInternal(BlobStoreManagerService r0, BlobHandle r1, int r2, String r3) {
        return r0.getLeaseInfoInternal(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetLeasedBlobsInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m2781$$Nest$mgetLeasedBlobsInternal(BlobStoreManagerService r0, int r1, String r2) {
        return r0.getLeasedBlobsInternal(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetRemainingLeaseQuotaBytesInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m2782$$Nest$mgetRemainingLeaseQuotaBytesInternal(BlobStoreManagerService r0, int r1, String r2) {
        return r0.getRemainingLeaseQuotaBytesInternal(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleUserRemoved, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2783$$Nest$mhandleUserRemoved(BlobStoreManagerService r0, int r1) {
        r0.handleUserRemoved(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misAllowedBlobStoreAccess, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2784$$Nest$misAllowedBlobStoreAccess(BlobStoreManagerService r0, int r1, String r2) {
        return r0.isAllowedBlobStoreAccess(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$monStateChangedInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2785$$Nest$monStateChangedInternal(BlobStoreManagerService r0, BlobStoreSession r1) {
        r0.onStateChangedInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mopenBlobInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ ParcelFileDescriptor m2786$$Nest$mopenBlobInternal(BlobStoreManagerService r0, BlobHandle r1, int r2, String r3) {
        return r0.openBlobInternal(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mopenSessionInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ BlobStoreSession m2787$$Nest$mopenSessionInternal(BlobStoreManagerService r0, long r1, int r3, String r4) {
        return r0.openSessionInternal(r1, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mpullBlobData, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m2788$$Nest$mpullBlobData(BlobStoreManagerService r0, int r1, List r2) {
        return r0.pullBlobData(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mqueryBlobsForUserInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m2789$$Nest$mqueryBlobsForUserInternal(BlobStoreManagerService r0, int r1) {
        return r0.queryBlobsForUserInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mreleaseAllLeasesInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2790$$Nest$mreleaseAllLeasesInternal(BlobStoreManagerService r0, int r1, String r2) {
        r0.releaseAllLeasesInternal(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mreleaseLeaseInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2791$$Nest$mreleaseLeaseInternal(BlobStoreManagerService r0, BlobHandle r1, int r2, String r3) {
        r0.releaseLeaseInternal(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mverifyCallingPackage, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2792$$Nest$mverifyCallingPackage(BlobStoreManagerService r0, int r1, String r2) {
        r0.verifyCallingPackage(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$sminitializeMessageHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m2793$$Nest$sminitializeMessageHandler() {
        return initializeMessageHandler();
    }

    public BlobStoreManagerService(Context context) {
        this(context, new Injector());
    }

    BlobStoreManagerService(Context context, Injector injector) {
        super(context);
        this.mBlobsLock = new Object();
        this.mSessions = new SparseArray();
        this.mBlobsMap = new ArrayMap();
        this.mActiveBlobIds = new ArraySet();
        this.mKnownBlobIds = new ArraySet();
        this.mRandom = new SecureRandom();
        this.mSessionStateChangeListener = new SessionStateChangeListener(this);
        this.mStatsCallbackImpl = new StatsPullAtomCallbackImpl(this, null);
        this.mSaveBlobsInfoRunnable = new BlobStoreManagerService$$ExternalSyntheticLambda20(this);
        this.mSaveSessionsRunnable = new BlobStoreManagerService$$ExternalSyntheticLambda21(this);
        this.mContext = context;
        this.mInjector = injector;
        this.mHandler = this.mInjector.initializeMessageHandler();
        this.mBackgroundHandler = this.mInjector.getBackgroundHandler();
    }

    private static Handler initializeMessageHandler() {
        ServiceThread r0 = new ServiceThread(BlobStoreConfig.TAG, 0, true);
        r0.start();
        Handler handler = new Handler(r0.getLooper());
        Watchdog.getInstance().addThread(handler);
        return handler;
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        BlobStoreManagerServiceIA r1 = null;
        publishBinderService("blob_store", new Stub(this, r1));
        LocalServices.addService(BlobStoreManagerInternal.class, new LocalService(this, r1));
        this.mPackageManagerInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        this.mStatsManager = (StatsManager) getContext().getSystemService(StatsManager.class);
        registerReceivers();
        ((StorageStatsManagerLocal) LocalManagerRegistry.getManager(StorageStatsManagerLocal.class)).registerStorageStatsAugmenter(new BlobStorageStatsAugmenter(this, r1), BlobStoreConfig.TAG);
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase != 550) goto L6;
        BlobStoreConfig.initialize(this.mContext);
        return;
    L6:
        if (phase != 600) goto L16;
        Object r0 = this.mBlobsLock;
        monitor-enter(r0);
        SparseArray<SparseArray<String>> allPackages = getAllPackages();     // Catch: Throwable -> L12
        readBlobSessionsLocked(allPackages);     // Catch: Throwable -> L12
        readBlobsInfoLocked(allPackages);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        registerBlobStorePuller();
        return;
    L12:
        th = move-exception;
        throw th;
    L16:
        if (phase != 1000) goto L23;
        BlobStoreIdleJobService.schedule(this.mContext);
        return;
    }

    private long generateNextSessionIdLocked() {
        int n = 0;
    L3:
        long randomLong = this.mRandom.nextLong();
        if (randomLong != Long.MIN_VALUE) goto L6;
        long sessionId = 0;
    L8:
        if (this.mKnownBlobIds.indexOf(Long.valueOf(sessionId)) < 0) goto L10;
    L12:
        int n2 = n + 1;
        if (n >= 32) goto L16;
        n = n2;
        goto L3
    L16:
        throw new IllegalStateException("Failed to allocate session ID");
    L10:
        if (sessionId == 0) goto L12;
        return sessionId;
    L6:
        sessionId = Math.abs(randomLong);
        goto L8
    }

    private void registerReceivers() {
        IntentFilter packageChangedFilter = new IntentFilter();
        packageChangedFilter.addAction("android.intent.action.PACKAGE_FULLY_REMOVED");
        packageChangedFilter.addAction("android.intent.action.PACKAGE_DATA_CLEARED");
        packageChangedFilter.addDataScheme(Settings.ATTR_PACKAGE);
        BlobStoreManagerServiceIA r0 = null;
        this.mContext.registerReceiverAsUser(new PackageChangedReceiver(this, r0), UserHandle.ALL, packageChangedFilter, null, this.mHandler);
        IntentFilter userActionFilter = new IntentFilter();
        userActionFilter.addAction("android.intent.action.USER_REMOVED");
        this.mContext.registerReceiverAsUser(new UserActionReceiver(this, r0), UserHandle.ALL, userActionFilter, null, this.mHandler);
    }

    private LongSparseArray<BlobStoreSession> getUserSessionsLocked(int userId) {
        LongSparseArray<BlobStoreSession> userSessions = this.mSessions.get(userId);
        if (userSessions != null) goto L6;
        LongSparseArray<BlobStoreSession> userSessions2 = new LongSparseArray();
        this.mSessions.put(userId, userSessions2);
        return userSessions2;
    L6:
        return userSessions;
    }

    void addUserSessionsForTest(LongSparseArray<BlobStoreSession> userSessions, int userId) {
        Object r0 = this.mBlobsLock;
        monitor-enter(r0);
        this.mSessions.put(userId, userSessions);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    BlobMetadata getBlobForTest(BlobHandle blobHandle) {
        Object r0 = this.mBlobsLock;
        monitor-enter(r0);
        BlobMetadata r1 = this.mBlobsMap.get(blobHandle);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    int getBlobsCountForTest() {
        Object r0 = this.mBlobsLock;
        monitor-enter(r0);
        int r1 = this.mBlobsMap.size();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void addActiveIdsForTest(long... activeIds) {
        Object r0 = this.mBlobsLock;
        monitor-enter(r0);
        int r1 = activeIds.length;     // Catch: Throwable -> L7
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L9;
        long id = activeIds[r2];     // Catch: Throwable -> L7
        addActiveBlobIdLocked(id);     // Catch: Throwable -> L7
        r2 = r2 + 1;     // Catch: Throwable -> L7
        goto L5
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    Set<Long> getActiveIdsForTest() {
        Object r0 = this.mBlobsLock;
        monitor-enter(r0);
        ArraySet<Long> r1 = this.mActiveBlobIds;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    Set<Long> getKnownIdsForTest() {
        Object r0 = this.mBlobsLock;
        monitor-enter(r0);
        ArraySet<Long> r1 = this.mKnownBlobIds;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void addSessionForUserLocked(BlobStoreSession session, int userId) {
        getUserSessionsLocked(userId).put(session.getSessionId(), session);
        addActiveBlobIdLocked(session.getSessionId());
    }

    void addBlobLocked(BlobMetadata blobMetadata) {
        this.mBlobsMap.put(blobMetadata.getBlobHandle(), blobMetadata);
        addActiveBlobIdLocked(blobMetadata.getBlobId());
    }

    private void addActiveBlobIdLocked(long id) {
        this.mActiveBlobIds.add(Long.valueOf(id));
        this.mKnownBlobIds.add(Long.valueOf(id));
    }

    private int getSessionsCountLocked(final int uid, final String packageName) {
        final AtomicInteger sessionsCount = new AtomicInteger(0);
        forEachSessionInUser(new BlobStoreManagerService$$ExternalSyntheticLambda19(uid, packageName, sessionsCount), UserHandle.getUserId(uid));
        return sessionsCount.get();
    }

    private static /* synthetic */ void lambda$getSessionsCountLocked$0(int uid, String packageName, AtomicInteger sessionsCount, BlobStoreSession session) {
        if (session.getOwnerUid() == uid) goto L5;
        return;
    L5:
        if (session.getOwnerPackageName().equals(packageName) == false) goto L9;
        sessionsCount.getAndIncrement();
        return;
    }

    private long createSessionInternal(BlobHandle blobHandle, int callingUid, String callingPackage) {
        Object r1 = this.mBlobsLock;
        monitor-enter(r1);
        int sessionsCount = getSessionsCountLocked(callingUid, callingPackage);     // Catch: Throwable -> L16
        if (sessionsCount >= BlobStoreConfig.getMaxActiveSessions()) goto L19;
        long sessionId = generateNextSessionIdLocked();     // Catch: Throwable -> L16
        BlobStoreSession session = new BlobStoreSession(this.mContext, sessionId, blobHandle, callingUid, callingPackage, this.mSessionStateChangeListener);     // Catch: Throwable -> L11
        addSessionForUserLocked(session, UserHandle.getUserId(callingUid));     // Catch: Throwable -> L11
        if (BlobStoreConfig.LOGV == false) goto L13;
        Slog.v(BlobStoreConfig.TAG, "Created session for " + blobHandle + "; callingUid=" + callingUid + ", callingPackage=" + callingPackage);     // Catch: Throwable -> L11
    L13:
        writeBlobSessionsAsync();     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return sessionId;
    L19:
        throw new LimitExceededException("Too many active sessions for the caller: " + sessionsCount);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Throwable r13 = th;
    L20:
        monitor-exit(r1);     // Catch: Throwable -> L11
        throw r13;
    L16:
        th = move-exception;
        r13 = th;
        goto L20
    }

    private BlobStoreSession openSessionInternal(long sessionId, int callingUid, String callingPackage) {
        Object r0 = this.mBlobsLock;
        monitor-enter(r0);
        BlobStoreSession session = getUserSessionsLocked(UserHandle.getUserId(callingUid)).get(sessionId);     // Catch: Throwable -> L13
        if (session == null) goto L16;
        if (session.hasAccess(callingUid, callingPackage) == false) goto L16;
        if (session.isFinalized() == true) goto L16;
        monitor-exit(r0);     // Catch: Throwable -> L13
        session.open();
        return session;
    L16:
        throw new SecurityException("Session not found: " + sessionId);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    private void abandonSessionInternal(long sessionId, int callingUid, String callingPackage) {
        Object r0 = this.mBlobsLock;
        monitor-enter(r0);
        BlobStoreSession session = openSessionInternal(sessionId, callingUid, callingPackage);     // Catch: Throwable -> L7
        session.open();     // Catch: Throwable -> L7
        session.abandon();     // Catch: Throwable -> L7
        if (BlobStoreConfig.LOGV == false) goto L9;
        Slog.v(BlobStoreConfig.TAG, "Abandoned session with id " + sessionId + "; callingUid=" + callingUid + ", callingPackage=" + callingPackage);     // Catch: Throwable -> L7
    L9:
        writeBlobSessionsAsync();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private ParcelFileDescriptor openBlobInternal(BlobHandle blobHandle, int callingUid, String callingPackage) throws IOException {
        Object r8 = this.mBlobsLock;
        monitor-enter(r8);
        BlobMetadata blobMetadata = this.mBlobsMap.get(blobHandle);     // Catch: Throwable -> L12
        if (blobMetadata == null) goto L14;
        if (blobMetadata.isAccessAllowedForCaller(callingPackage, callingUid) == false) goto L14;
        FrameworkStatsLog.write(300, callingUid, blobMetadata.getBlobId(), blobMetadata.getSize(), 1);     // Catch: Throwable -> L12
        ParcelFileDescriptor r1 = blobMetadata.openForRead(callingPackage, callingUid);     // Catch: Throwable -> L12
        monitor-exit(r8);     // Catch: Throwable -> L12
        return r1;
    L14:
        if (blobMetadata != null) goto L16;
        FrameworkStatsLog.write(300, callingUid, 0, 0, 2);     // Catch: Throwable -> L12
    L18:
        throw new SecurityException("Caller not allowed to access " + blobHandle + "; callingUid=" + callingUid + ", callingPackage=" + callingPackage);     // Catch: Throwable -> L12
    L16:
        FrameworkStatsLog.write(300, callingUid, blobMetadata.getBlobId(), blobMetadata.getSize(), 3);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    private int getCommittedBlobsCountLocked(final int uid, final String packageName) {
        final AtomicInteger blobsCount = new AtomicInteger(0);
        forEachBlobLocked(new BlobStoreManagerService$$ExternalSyntheticLambda4(packageName, uid, blobsCount));
        return blobsCount.get();
    }

    private static /* synthetic */ void lambda$getCommittedBlobsCountLocked$1(String packageName, int uid, AtomicInteger blobsCount, BlobMetadata blobMetadata) {
        if (blobMetadata.isACommitter(packageName, uid) == false) goto L6;
        blobsCount.getAndIncrement();
        return;
    }

    private int getLeasedBlobsCountLocked(final int uid, final String packageName) {
        final AtomicInteger blobsCount = new AtomicInteger(0);
        forEachBlobLocked(new BlobStoreManagerService$$ExternalSyntheticLambda5(packageName, uid, blobsCount));
        return blobsCount.get();
    }

    private static /* synthetic */ void lambda$getLeasedBlobsCountLocked$2(String packageName, int uid, AtomicInteger blobsCount, BlobMetadata blobMetadata) {
        if (blobMetadata.isALeasee(packageName, uid) == false) goto L6;
        blobsCount.getAndIncrement();
        return;
    }

    private void acquireLeaseInternal(BlobHandle blobHandle, int descriptionResId, CharSequence description, long leaseExpiryTimeMillis, int callingUid, String callingPackage) {
        Object r8 = this.mBlobsLock;
        monitor-enter(r8);
        int leasesCount = getLeasedBlobsCountLocked(callingUid, callingPackage);     // Catch: Throwable -> L15
        if (leasesCount < BlobStoreConfig.getMaxLeasedBlobs()) goto L7;
        FrameworkStatsLog.write(FrameworkStatsLog.BLOB_LEASED, callingUid, 0, 0, 6);     // Catch: Throwable -> L15
        throw new LimitExceededException("Too many leased blobs for the caller: " + leasesCount);     // Catch: Throwable -> L15
    L7:
        if (leaseExpiryTimeMillis == 0) goto L17;
        if (blobHandle.expiryTimeMillis == 0) goto L17;
        if (leaseExpiryTimeMillis <= blobHandle.expiryTimeMillis) goto L17;
        FrameworkStatsLog.write(FrameworkStatsLog.BLOB_LEASED, callingUid, 0, 0, 4);     // Catch: Throwable -> L15
        throw new IllegalArgumentException("Lease expiry cannot be later than blobs expiry time");     // Catch: Throwable -> L15
    L17:
        BlobMetadata blobMetadata = this.mBlobsMap.get(blobHandle);     // Catch: Throwable -> L15
        if (blobMetadata == null) goto L38;
        if (blobMetadata.isAccessAllowedForCaller(callingPackage, callingUid) == false) goto L38;
        if (blobMetadata.getSize() > getRemainingLeaseQuotaBytesInternal(callingUid, callingPackage)) goto L36;
        FrameworkStatsLog.write(FrameworkStatsLog.BLOB_LEASED, callingUid, blobMetadata.getBlobId(), blobMetadata.getSize(), 1);     // Catch: Throwable -> L15
        blobMetadata.addOrReplaceLeasee(callingPackage, callingUid, descriptionResId, description, leaseExpiryTimeMillis);     // Catch: Throwable -> L34
        if (BlobStoreConfig.LOGV == false) goto L31;
        Slog.v(BlobStoreConfig.TAG, "Acquired lease on " + blobHandle + "; callingUid=" + callingUid + ", callingPackage=" + callingPackage);     // Catch: Throwable -> L15
    L31:
        writeBlobsInfoAsync();     // Catch: Throwable -> L15
        monitor-exit(r8);     // Catch: Throwable -> L15
        return;
    L34:
        th = th;
    L51:
        monitor-exit(r8);     // Catch: Throwable -> L15
        throw th;
    L36:
        FrameworkStatsLog.write(FrameworkStatsLog.BLOB_LEASED, callingUid, blobMetadata.getBlobId(), blobMetadata.getSize(), 5);     // Catch: Throwable -> L15
        throw new LimitExceededException("Total amount of data with an active lease is exceeding the max limit");     // Catch: Throwable -> L15
    L38:
        if (blobMetadata != null) goto L55;
        FrameworkStatsLog.write(FrameworkStatsLog.BLOB_LEASED, callingUid, 0, 0, 2);     // Catch: Throwable -> L15
        int r1 = callingUid;
    L46:
        throw new SecurityException("Caller not allowed to access " + blobHandle + "; callingUid=" + r1 + ", callingPackage=" + callingPackage);     // Catch: Throwable -> L15
    L55:
        r1 = callingUid;
        FrameworkStatsLog.write(FrameworkStatsLog.BLOB_LEASED, r1, blobMetadata.getBlobId(), blobMetadata.getSize(), 3);     // Catch: Throwable -> L15
    L47:
        th = th;
    L15:
        th = th;
        goto L51
    }

    long getTotalUsageBytesLocked(final int callingUid, final String callingPackage) {
        final AtomicLong totalBytes = new AtomicLong(0);
        forEachBlobLocked(new BlobStoreManagerService$$ExternalSyntheticLambda0(callingPackage, callingUid, totalBytes));
        return totalBytes.get();
    }

    private static /* synthetic */ void lambda$getTotalUsageBytesLocked$3(String callingPackage, int callingUid, AtomicLong totalBytes, BlobMetadata blobMetadata) {
        if (blobMetadata.isALeasee(callingPackage, callingUid) == false) goto L6;
        totalBytes.getAndAdd(blobMetadata.getSize());
        return;
    }

    private void releaseLeaseInternal(final BlobHandle blobHandle, int callingUid, String callingPackage) {
        Object r0 = this.mBlobsLock;
        monitor-enter(r0);
        final BlobMetadata blobMetadata = this.mBlobsMap.get(blobHandle);     // Catch: Throwable -> L11
        if (blobMetadata == null) goto L20;
        if (blobMetadata.isAccessAllowedForCaller(callingPackage, callingUid) == false) goto L20;
        blobMetadata.removeLeasee(callingPackage, callingUid);     // Catch: Throwable -> L11
        if (BlobStoreConfig.LOGV == false) goto L14;
        Slog.v(BlobStoreConfig.TAG, "Released lease on " + blobHandle + "; callingUid=" + callingUid + ", callingPackage=" + callingPackage);     // Catch: Throwable -> L11
    L14:
        if (blobMetadata.hasValidLeases() == true) goto L16;
        this.mHandler.postDelayed(new BlobStoreManagerService$$ExternalSyntheticLambda14(this, blobHandle, blobMetadata), BlobStoreConfig.getDeletionOnLastLeaseDelayMs());     // Catch: Throwable -> L11
    L16:
        writeBlobsInfoAsync();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L20:
        throw new SecurityException("Caller not allowed to access " + blobHandle + "; callingUid=" + callingUid + ", callingPackage=" + callingPackage);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$releaseLeaseInternal$4(BlobHandle blobHandle, BlobMetadata blobMetadata) {
        Object r0 = this.mBlobsLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (Objects.equals(this.mBlobsMap.get(blobHandle), blobMetadata) == true) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L11:
        if (blobMetadata.shouldBeDeleted(true) == false) goto L13;
        deleteBlobLocked(blobMetadata);     // Catch: Throwable -> L8
        this.mBlobsMap.remove(blobHandle);     // Catch: Throwable -> L8
    L13:
        writeBlobsInfoAsync();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    private void releaseAllLeasesInternal(final int callingUid, final String callingPackage) {
        Object r0 = this.mBlobsLock;
        monitor-enter(r0);
        this.mBlobsMap.forEach(new BlobStoreManagerService$$ExternalSyntheticLambda3(callingPackage, callingUid));     // Catch: Throwable -> L7
        writeBlobsInfoAsync();     // Catch: Throwable -> L7
        if (BlobStoreConfig.LOGV == false) goto L9;
        Slog.v(BlobStoreConfig.TAG, "Release all leases associated with pkg=" + callingPackage + ", uid=" + callingUid);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$releaseAllLeasesInternal$5(String callingPackage, int callingUid, BlobHandle blobHandle, BlobMetadata blobMetadata) {
        blobMetadata.removeLeasee(callingPackage, callingUid);
    }

    private long getRemainingLeaseQuotaBytesInternal(int callingUid, String callingPackage) {
        Object r0 = this.mBlobsLock;
        monitor-enter(r0);
        long remainingQuota = BlobStoreConfig.getAppDataBytesLimit() - getTotalUsageBytesLocked(callingUid, callingPackage);     // Catch: Throwable -> L9
        long r3 = 0;
        if (remainingQuota <= 0) goto L7;
        r3 = remainingQuota;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    private List<BlobInfo> queryBlobsForUserInternal(final int userId) {
        final ArrayList<BlobInfo> blobInfos = new ArrayList();
        Object r1 = this.mBlobsLock;
        monitor-enter(r1);
        final ArrayMap<String, WeakReference<Resources>> resources = new ArrayMap();     // Catch: Throwable -> L7
        final Function<String, Resources> resourcesGetter = new BlobStoreManagerService$$ExternalSyntheticLambda12(this, resources, userId);     // Catch: Throwable -> L7
        forEachBlobLocked(new BlobStoreManagerService$$ExternalSyntheticLambda13(userId, resourcesGetter, blobInfos));     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return blobInfos;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ Resources lambda$queryBlobsForUserInternal$6(ArrayMap resources, int userId, String packageName) {
        WeakReference<Resources> resourcesRef = (WeakReference) resources.get(packageName);
        if (resourcesRef != null) goto L5;
        Resources packageResources = null;
    L6:
        if (packageResources != null) goto L9;
        Resources packageResources2 = BlobStoreUtils.getPackageResources(this.mContext, packageName, userId);
        resources.put(packageName, new WeakReference(packageResources2));
        return packageResources2;
    L9:
        return packageResources;
    L5:
        packageResources = resourcesRef.get();
        goto L6
    }

    private static /* synthetic */ void lambda$queryBlobsForUserInternal$8(final int userId, final Function resourcesGetter, ArrayList blobInfos, final BlobHandle blobHandle, BlobMetadata blobMetadata) {
        if (blobMetadata.hasACommitterOrLeaseeInUser(userId) == true) goto L5;
        return;
    L5:
        final ArrayList<LeaseInfo> leaseInfos = new ArrayList();
        blobMetadata.forEachLeasee(new BlobStoreManagerService$$ExternalSyntheticLambda8(userId, resourcesGetter, blobHandle, leaseInfos));
        blobInfos.add(new BlobInfo(blobMetadata.getBlobId(), blobHandle.getExpiryTimeMillis(), blobHandle.getLabel(), blobMetadata.getSize(), leaseInfos));
    }

    private static /* synthetic */ void lambda$queryBlobsForUserInternal$7(int userId, Function resourcesGetter, BlobHandle blobHandle, ArrayList leaseInfos, BlobMetadata.Leasee leasee) {
        if (leasee.isStillValid() == true) goto L6;
        return;
    L6:
        if (userId == UserHandle.getUserId(leasee.uid)) goto L9;
        return;
    L9:
        if (leasee.descriptionResEntryName != null) goto L11;
        int r0 = 0;
    L12:
        int descriptionResId = r0;
        if (leasee.expiryTimeMillis != 0) goto L16;
        long r1 = blobHandle.getExpiryTimeMillis();
    L15:
        long expiryTimeMs = r1;
        leaseInfos.add(new LeaseInfo(leasee.packageName, expiryTimeMs, descriptionResId, leasee.description));
        return;
    L16:
        r1 = leasee.expiryTimeMillis;
        goto L15
    L11:
        r0 = BlobStoreUtils.getDescriptionResourceId((Resources) resourcesGetter.apply(leasee.packageName), leasee.descriptionResEntryName, leasee.packageName);
        goto L12
    }

    private void deleteBlobInternal(final long blobId) {
        Object r0 = this.mBlobsLock;
        monitor-enter(r0);
        this.mBlobsMap.entrySet().removeIf(new BlobStoreManagerService$$ExternalSyntheticLambda9(this, blobId));     // Catch: Throwable -> L7
        writeBlobsInfoAsync();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ boolean lambda$deleteBlobInternal$9(long blobId, Map.Entry entry) {
        BlobMetadata blobMetadata = (BlobMetadata) entry.getValue();
        if (blobMetadata.getBlobId() != blobId) goto L6;
        deleteBlobLocked(blobMetadata);
        return true;
    L6:
        return false;
    }

    private List<BlobHandle> getLeasedBlobsInternal(final int callingUid, final String callingPackage) {
        final ArrayList<BlobHandle> leasedBlobs = new ArrayList();
        Object r1 = this.mBlobsLock;
        monitor-enter(r1);
        forEachBlobLocked(new BlobStoreManagerService$$ExternalSyntheticLambda2(callingPackage, callingUid, leasedBlobs));     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return leasedBlobs;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$getLeasedBlobsInternal$10(String callingPackage, int callingUid, ArrayList leasedBlobs, BlobMetadata blobMetadata) {
        if (blobMetadata.isALeasee(callingPackage, callingUid) == false) goto L6;
        leasedBlobs.add(blobMetadata.getBlobHandle());
        return;
    }

    private LeaseInfo getLeaseInfoInternal(BlobHandle blobHandle, int callingUid, String callingPackage) {
        Object r0 = this.mBlobsLock;
        monitor-enter(r0);
        BlobMetadata blobMetadata = this.mBlobsMap.get(blobHandle);     // Catch: Throwable -> L11
        if (blobMetadata == null) goto L14;
        if (blobMetadata.isAccessAllowedForCaller(callingPackage, callingUid) == false) goto L14;
        LeaseInfo r2 = blobMetadata.getLeaseInfo(callingPackage, callingUid);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r2;
    L14:
        throw new SecurityException("Caller not allowed to access " + blobHandle + "; callingUid=" + callingUid + ", callingPackage=" + callingPackage);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private void verifyCallingPackage(int callingUid, String callingPackage) {
        if (this.mPackageManagerInternal.getPackageUid(callingPackage, 0, UserHandle.getUserId(callingUid)) != callingUid) goto L6;
        return;
    L6:
        throw new SecurityException("Specified calling package [" + callingPackage + "] does not match the calling uid " + callingUid);
    }

    private void onStateChangedInternal(final BlobStoreSession session) {
        switch(session.getState()) {
            case 2: goto L43;
            case 3: goto L42;
            case 4: goto L5;
            case 5: goto L43;
            default: goto L4;
        };
    L4:
        Slog.wtf(BlobStoreConfig.TAG, "Invalid session state: " + BlobStoreSession.stateToString(session.getState()));
    L51:
        Object r4 = this.mBlobsLock;
        monitor-enter(r4);
        writeBlobSessionsLocked();     // Catch: Throwable -> L55 Exception -> L57
    L55:
        th = move-exception;
        throw th;
    L58:
        monitor-exit(r4);     // Catch: Throwable -> L55
        return;
    L5:
        Object r3 = this.mBlobsLock;
        monitor-enter(r3);
        int committedBlobsCount = getCommittedBlobsCountLocked(session.getOwnerUid(), session.getOwnerPackageName());     // Catch: Throwable -> L12
        if (committedBlobsCount < BlobStoreConfig.getMaxCommittedBlobs()) goto L14;
        Slog.d(BlobStoreConfig.TAG, "Failed to commit: too many committed blobs. count: " + committedBlobsCount + "; blob: " + session);     // Catch: Throwable -> L12
        session.sendCommitCallbackResult(1);     // Catch: Throwable -> L12
        deleteSessionLocked(session);     // Catch: Throwable -> L12
        getUserSessionsLocked(UserHandle.getUserId(session.getOwnerUid())).remove(session.getSessionId());     // Catch: Throwable -> L12
        FrameworkStatsLog.write(FrameworkStatsLog.BLOB_COMMITTED, session.getOwnerUid(), session.getSessionId(), session.getSize(), 4);     // Catch: Throwable -> L12
        monitor-exit(r3);     // Catch: Throwable -> L12
        goto L51
    L14:
        int blobIndex = this.mBlobsMap.indexOfKey(session.getBlobHandle());     // Catch: Throwable -> L12
        if (blobIndex < 0) goto L17;
        BlobMetadata blob = this.mBlobsMap.valueAt(blobIndex);     // Catch: Throwable -> L12
    L18:
        BlobMetadata.Committer existingCommitter = blob.getExistingCommitter(session.getOwnerPackageName(), session.getOwnerUid());     // Catch: Throwable -> L12
        if (existingCommitter != null) goto L21;
        long existingCommitTimeMs = 0;
    L22:
        BlobMetadata.Committer newCommitter = new BlobMetadata.Committer(session.getOwnerPackageName(), session.getOwnerUid(), session.getBlobAccessMode(), BlobStoreConfig.getAdjustedCommitTimeMs(existingCommitTimeMs, System.currentTimeMillis()));     // Catch: Throwable -> L12
        blob.addOrReplaceCommitter(newCommitter);     // Catch: Throwable -> L12
        writeBlobsInfoLocked();     // Catch: Throwable -> L12 Exception -> L25
        FrameworkStatsLog.write(FrameworkStatsLog.BLOB_COMMITTED, session.getOwnerUid(), blob.getBlobId(), blob.getSize(), 1);     // Catch: Throwable -> L12 Exception -> L25
        session.sendCommitCallbackResult(0);     // Catch: Throwable -> L12 Exception -> L25
    L33:
        if (session.getSessionId() == blob.getBlobId()) goto L35;
        deleteSessionLocked(session);     // Catch: Throwable -> L12
    L35:
        getUserSessionsLocked(UserHandle.getUserId(session.getOwnerUid())).remove(session.getSessionId());     // Catch: Throwable -> L12
        if (BlobStoreConfig.LOGV == false) goto L38;
        Slog.v(BlobStoreConfig.TAG, "Successfully committed session " + session);     // Catch: Throwable -> L12
    L38:
        monitor-exit(r3);     // Catch: Throwable -> L12
    L25:
        e = move-exception;
        if (existingCommitter != null) goto L28;
        blob.removeCommitter(newCommitter);     // Catch: Throwable -> L12
    L29:
        Slog.d(BlobStoreConfig.TAG, "Error committing the blob: " + session, e);     // Catch: Throwable -> L12
        FrameworkStatsLog.write(FrameworkStatsLog.BLOB_COMMITTED, session.getOwnerUid(), session.getSessionId(), blob.getSize(), 2);     // Catch: Throwable -> L12
        session.sendCommitCallbackResult(1);     // Catch: Throwable -> L12
        if (session.getSessionId() != blob.getBlobId()) goto L33;
        deleteBlobLocked(blob);     // Catch: Throwable -> L12
        this.mBlobsMap.remove(blob.getBlobHandle());     // Catch: Throwable -> L12
        goto L33
    L28:
        blob.addOrReplaceCommitter(existingCommitter);     // Catch: Throwable -> L12
        goto L29
    L21:
        existingCommitTimeMs = existingCommitter.getCommitTimeMs();     // Catch: Throwable -> L12
        goto L22
    L17:
        BlobMetadata blob2 = new BlobMetadata(this.mContext, session.getSessionId(), session.getBlobHandle());     // Catch: Throwable -> L12
        addBlobLocked(blob2);     // Catch: Throwable -> L12
        blob = blob2;
    L12:
        th = move-exception;
        throw th;
    L42:
        this.mBackgroundHandler.post(new BlobStoreManagerService$$ExternalSyntheticLambda1(this, session));
        goto L51
    L43:
        Object r5 = this.mBlobsLock;
        monitor-enter(r5);
        deleteSessionLocked(session);     // Catch: Throwable -> L48
        getUserSessionsLocked(UserHandle.getUserId(session.getOwnerUid())).remove(session.getSessionId());     // Catch: Throwable -> L48
        if (BlobStoreConfig.LOGV == false) goto L50;
        Slog.v(BlobStoreConfig.TAG, "Session is invalid; deleted " + session);     // Catch: Throwable -> L48
    L50:
        monitor-exit(r5);     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$onStateChangedInternal$11(BlobStoreSession session) {
        session.computeDigest();
        this.mHandler.post(PooledLambda.obtainRunnable(new BlobStoreManagerService$$ExternalSyntheticLambda11(), session).recycleOnUse());
    }

    private void writeBlobSessionsLocked() throws Exception {
        AtomicFile sessionsIndexFile = prepareSessionsIndexFile();
        if (sessionsIndexFile != null) goto L6;
        Slog.wtf(BlobStoreConfig.TAG, "Error creating sessions index file");
        return;
    L6:
        FileOutputStream fos = null;
        fos = sessionsIndexFile.startWrite(SystemClock.uptimeMillis());     // Catch: Exception -> L12
        XmlSerializer out = new FastXmlSerializer();     // Catch: Exception -> L12
        out.setOutput(fos, StandardCharsets.UTF_8.name());     // Catch: Exception -> L12
        out.startDocument(null, true);     // Catch: Exception -> L12
        out.startTag(null, "ss");     // Catch: Exception -> L12
        XmlUtils.writeIntAttribute(out, "v", 6);     // Catch: Exception -> L12
        int i = 0;
        int userCount = this.mSessions.size();     // Catch: Exception -> L12
    L8:
        if (i >= userCount) goto L15;
        LongSparseArray<BlobStoreSession> userSessions = this.mSessions.valueAt(i);     // Catch: Exception -> L12
        int j = 0;
        int sessionsCount = userSessions.size();     // Catch: Exception -> L12
    L10:
        if (j >= sessionsCount) goto L14;
        out.startTag(null, "s");     // Catch: Exception -> L12
        userSessions.valueAt(j).writeToXml(out);     // Catch: Exception -> L12
        out.endTag(null, "s");     // Catch: Exception -> L12
        j = j + 1;     // Catch: Exception -> L12
        goto L10
    L14:
        i = i + 1;     // Catch: Exception -> L12
        goto L8
    L15:
        out.endTag(null, "ss");     // Catch: Exception -> L12
        out.endDocument();     // Catch: Exception -> L12
        sessionsIndexFile.finishWrite(fos);     // Catch: Exception -> L12
        if (BlobStoreConfig.LOGV == false) goto L26;
        Slog.v(BlobStoreConfig.TAG, "Finished persisting sessions data");     // Catch: Exception -> L12
        return;
    L26:
        return;
    L12:
        e = move-exception;
        sessionsIndexFile.failWrite(fos);
        Slog.wtf(BlobStoreConfig.TAG, "Error writing sessions data", e);
        throw e;
    }

    private void readBlobSessionsLocked(SparseArray<SparseArray<String>> allPackages) {
        if (BlobStoreConfig.getBlobStoreRootDir().exists() == true) goto L5;
        return;
    L5:
        AtomicFile sessionsIndexFile = prepareSessionsIndexFile();
        if (sessionsIndexFile != null) goto L10;
        Slog.wtf(BlobStoreConfig.TAG, "Error creating sessions index file");
        return;
    L10:
        if (sessionsIndexFile.exists() == true) goto L13;
        Slog.w(BlobStoreConfig.TAG, "Sessions index file not available: " + sessionsIndexFile.getBaseFile());
        return;
    L13:
        this.mSessions.clear();
        FileInputStream fis = sessionsIndexFile.openRead();     // Catch: Exception -> L27
        XmlPullParser in = Xml.newPullParser();     // Catch: Throwable -> L22
        in.setInput(fis, StandardCharsets.UTF_8.name());     // Catch: Throwable -> L22
        XmlUtils.beginDocument(in, "ss");     // Catch: Throwable -> L22
        int version = XmlUtils.readIntAttribute(in, "v");     // Catch: Throwable -> L22
    L16:
        XmlUtils.nextElement(in);     // Catch: Throwable -> L22
        if (in.getEventType() == 1) goto L19;
        if ("s".equals(in.getName()) == false) goto L16;
        BlobStoreSession session = BlobStoreSession.createFromXml(in, version, this.mContext, this.mSessionStateChangeListener);     // Catch: Throwable -> L22
        if (session == null) goto L16;
        SparseArray<String> userPackages = allPackages.get(UserHandle.getUserId(session.getOwnerUid()));     // Catch: Throwable -> L22
        if (userPackages != null) goto L38;
    L40:
        session.getSessionFile().delete();     // Catch: Throwable -> L22
    L41:
        this.mCurrentMaxSessionId = Math.max(this.mCurrentMaxSessionId, session.getSessionId());     // Catch: Throwable -> L22
        goto L16
    L38:
        if (session.getOwnerPackageName().equals(userPackages.get(session.getOwnerUid())) == false) goto L40;
        addSessionForUserLocked(session, UserHandle.getUserId(session.getOwnerUid()));     // Catch: Throwable -> L22
        goto L41
    L19:
        if (BlobStoreConfig.LOGV == false) goto L24;
        Slog.v(BlobStoreConfig.TAG, "Finished reading sessions data");     // Catch: Throwable -> L22
    L24:
        if (fis == null) goto L65;
        fis.close();     // Catch: Exception -> L27
        return;
    L65:
        return;
    L22:
        th = move-exception;
        if (fis != null) goto L55;
    L49:
        throw th;     // Catch: Exception -> L27
    L55:
        fis.close();     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L27
    L27:
        e = move-exception;
        Slog.wtf(BlobStoreConfig.TAG, "Error reading sessions data", e);
    }

    private void writeBlobsInfoLocked() throws Exception {
        AtomicFile blobsIndexFile = prepareBlobsIndexFile();
        if (blobsIndexFile != null) goto L6;
        Slog.wtf(BlobStoreConfig.TAG, "Error creating blobs index file");
        return;
    L6:
        FileOutputStream fos = null;
        fos = blobsIndexFile.startWrite(SystemClock.uptimeMillis());     // Catch: Exception -> L10
        XmlSerializer out = new FastXmlSerializer();     // Catch: Exception -> L10
        out.setOutput(fos, StandardCharsets.UTF_8.name());     // Catch: Exception -> L10
        out.startDocument(null, true);     // Catch: Exception -> L10
        out.startTag(null, "bs");     // Catch: Exception -> L10
        XmlUtils.writeIntAttribute(out, "v", 6);     // Catch: Exception -> L10
        int i = 0;
        int count = this.mBlobsMap.size();     // Catch: Exception -> L10
    L8:
        if (i >= count) goto L12;
        out.startTag(null, "b");     // Catch: Exception -> L10
        this.mBlobsMap.valueAt(i).writeToXml(out);     // Catch: Exception -> L10
        out.endTag(null, "b");     // Catch: Exception -> L10
        i = i + 1;     // Catch: Exception -> L10
        goto L8
    L12:
        out.endTag(null, "bs");     // Catch: Exception -> L10
        out.endDocument();     // Catch: Exception -> L10
        blobsIndexFile.finishWrite(fos);     // Catch: Exception -> L10
        if (BlobStoreConfig.LOGV == false) goto L22;
        Slog.v(BlobStoreConfig.TAG, "Finished persisting blobs data");     // Catch: Exception -> L10
        return;
    L22:
        return;
    L10:
        e = move-exception;
        blobsIndexFile.failWrite(fos);
        Slog.wtf(BlobStoreConfig.TAG, "Error writing blobs data", e);
        throw e;
    }

    private void readBlobsInfoLocked(SparseArray<SparseArray<String>> allPackages) {
        if (BlobStoreConfig.getBlobStoreRootDir().exists() == true) goto L5;
        return;
    L5:
        AtomicFile blobsIndexFile = prepareBlobsIndexFile();
        if (blobsIndexFile != null) goto L10;
        Slog.wtf(BlobStoreConfig.TAG, "Error creating blobs index file");
        return;
    L10:
        if (blobsIndexFile.exists() == true) goto L13;
        Slog.w(BlobStoreConfig.TAG, "Blobs index file not available: " + blobsIndexFile.getBaseFile());
        return;
    L13:
        this.mBlobsMap.clear();
        FileInputStream fis = blobsIndexFile.openRead();     // Catch: Exception -> L27
        XmlPullParser in = Xml.newPullParser();     // Catch: Throwable -> L22
        in.setInput(fis, StandardCharsets.UTF_8.name());     // Catch: Throwable -> L22
        XmlUtils.beginDocument(in, "bs");     // Catch: Throwable -> L22
        int version = XmlUtils.readIntAttribute(in, "v");     // Catch: Throwable -> L22
    L16:
        XmlUtils.nextElement(in);     // Catch: Throwable -> L22
        if (in.getEventType() == 1) goto L19;
        if ("b".equals(in.getName()) == false) goto L16;
        BlobMetadata blobMetadata = BlobMetadata.createFromXml(in, version, this.mContext);     // Catch: Throwable -> L22
        blobMetadata.removeCommittersFromUnknownPkgs(allPackages);     // Catch: Throwable -> L22
        blobMetadata.removeLeaseesFromUnknownPkgs(allPackages);     // Catch: Throwable -> L22
        this.mCurrentMaxSessionId = Math.max(this.mCurrentMaxSessionId, blobMetadata.getBlobId());     // Catch: Throwable -> L22
        if (version >= 6) goto L34;
        BlobMetadata existingBlobMetadata = this.mBlobsMap.get(blobMetadata.getBlobHandle());     // Catch: Throwable -> L22
        if (existingBlobMetadata == null) goto L37;
        existingBlobMetadata.addCommittersAndLeasees(blobMetadata);     // Catch: Throwable -> L22
        blobMetadata.getBlobFile().delete();     // Catch: Throwable -> L22
        goto L16
    L37:
        addBlobLocked(blobMetadata);     // Catch: Throwable -> L22
        goto L16
    L34:
        addBlobLocked(blobMetadata);     // Catch: Throwable -> L22
        goto L16
    L19:
        if (BlobStoreConfig.LOGV == false) goto L24;
        Slog.v(BlobStoreConfig.TAG, "Finished reading blobs data");     // Catch: Throwable -> L22
    L24:
        if (fis == null) goto L65;
        fis.close();     // Catch: Exception -> L27
        return;
    L65:
        return;
    L22:
        th = move-exception;
        if (fis != null) goto L49;
    L46:
        throw th;     // Catch: Exception -> L27
    L49:
        fis.close();     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L27
    L27:
        e = move-exception;
        Slog.wtf(BlobStoreConfig.TAG, "Error reading blobs data", e);
    }

    private void writeBlobsInfo() {
        Object r0 = this.mBlobsLock;
        monitor-enter(r0);
        writeBlobsInfoLocked();     // Catch: Throwable -> L6 Exception -> L8
    L6:
        th = move-exception;
        throw th;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L6
    }

    private void writeBlobsInfoAsync() {
        if (this.mHandler.hasCallbacks(this.mSaveBlobsInfoRunnable) == true) goto L6;
        this.mHandler.post(this.mSaveBlobsInfoRunnable);
        return;
    }

    private void writeBlobSessions() {
        Object r0 = this.mBlobsLock;
        monitor-enter(r0);
        writeBlobSessionsLocked();     // Catch: Throwable -> L6 Exception -> L8
    L6:
        th = move-exception;
        throw th;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L6
    }

    private void writeBlobSessionsAsync() {
        if (this.mHandler.hasCallbacks(this.mSaveSessionsRunnable) == true) goto L6;
        this.mHandler.post(this.mSaveSessionsRunnable);
        return;
    }

    private SparseArray<SparseArray<String>> getAllPackages() {
        SparseArray<SparseArray<String>> allPackages = new SparseArray();
        int[] allUsers = ((UserManagerInternal) LocalServices.getService(UserManagerInternal.class)).getUserIds();
        int r2 = allUsers.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L8;
        int userId = allUsers[r3];
        SparseArray<String> userPackages = new SparseArray();
        allPackages.put(userId, userPackages);
        List<ApplicationInfo> applicationInfos = this.mPackageManagerInternal.getInstalledApplications(794624, userId, Process.myUid());
        int i = 0;
        int count = applicationInfos.size();
    L5:
        if (i >= count) goto L7;
        ApplicationInfo applicationInfo = applicationInfos.get(i);
        userPackages.put(applicationInfo.uid, applicationInfo.packageName);
        i = i + 1;
        goto L5
    L7:
        r3 = r3 + 1;
        goto L3
    L8:
        return allPackages;
    }

    private AtomicFile prepareSessionsIndexFile() {
        File file = BlobStoreConfig.prepareSessionIndexFile();
        if (file != null) goto L7;
        return null;
    L7:
        return new AtomicFile(file, "session_index");
    }

    private AtomicFile prepareBlobsIndexFile() {
        File file = BlobStoreConfig.prepareBlobsIndexFile();
        if (file != null) goto L7;
        return null;
    L7:
        return new AtomicFile(file, "blobs_index");
    }

    void handlePackageRemoved(final String packageName, final int uid) {
        Object r0 = this.mBlobsLock;
        monitor-enter(r0);
        LongSparseArray<BlobStoreSession> userSessions = getUserSessionsLocked(UserHandle.getUserId(uid));     // Catch: Throwable -> L7
        userSessions.removeIf(new BlobStoreManagerService$$ExternalSyntheticLambda15(this, uid, packageName));     // Catch: Throwable -> L7
        writeBlobSessionsAsync();     // Catch: Throwable -> L7
        this.mBlobsMap.entrySet().removeIf(new BlobStoreManagerService$$ExternalSyntheticLambda16(this, packageName, uid));     // Catch: Throwable -> L7
        writeBlobsInfoAsync();     // Catch: Throwable -> L7
        if (BlobStoreConfig.LOGV == false) goto L9;
        Slog.v(BlobStoreConfig.TAG, "Removed blobs data associated with pkg=" + packageName + ", uid=" + uid);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ boolean lambda$handlePackageRemoved$12(int uid, String packageName, long sessionId, BlobStoreSession blobStoreSession) {
        if (blobStoreSession.getOwnerUid() == uid) goto L5;
        return false;
    L5:
        if (blobStoreSession.getOwnerPackageName().equals(packageName) == false) goto L10;
        deleteSessionLocked(blobStoreSession);
        return true;
    L10:
        return false;
    }

    private /* synthetic */ boolean lambda$handlePackageRemoved$13(String packageName, int uid, Map.Entry entry) {
        BlobMetadata blobMetadata = (BlobMetadata) entry.getValue();
        boolean isACommitter = blobMetadata.isACommitter(packageName, uid);
        if (isACommitter == false) goto L5;
        blobMetadata.removeCommitter(packageName, uid);
    L5:
        blobMetadata.removeLeasee(packageName, uid);
        if (blobMetadata.shouldBeDeleted(isACommitter) == false) goto L9;
        deleteBlobLocked(blobMetadata);
        return true;
    L9:
        return false;
    }

    private void handleUserRemoved(final int userId) {
        Object r0 = this.mBlobsLock;
        monitor-enter(r0);
        LongSparseArray<BlobStoreSession> userSessions = (LongSparseArray) this.mSessions.removeReturnOld(userId);     // Catch: Throwable -> L9
        if (userSessions == null) goto L11;
        int i = 0;
        int count = userSessions.size();     // Catch: Throwable -> L9
    L7:
        if (i >= count) goto L11;
        BlobStoreSession session = userSessions.valueAt(i);     // Catch: Throwable -> L9
        deleteSessionLocked(session);     // Catch: Throwable -> L9
        i = i + 1;     // Catch: Throwable -> L9
    L11:
        this.mBlobsMap.entrySet().removeIf(new BlobStoreManagerService$$ExternalSyntheticLambda6(this, userId));     // Catch: Throwable -> L9
        if (BlobStoreConfig.LOGV == false) goto L14;
        Slog.v(BlobStoreConfig.TAG, "Removed blobs data in user " + userId);     // Catch: Throwable -> L9
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ boolean lambda$handleUserRemoved$14(int userId, Map.Entry entry) {
        BlobMetadata blobMetadata = (BlobMetadata) entry.getValue();
        blobMetadata.removeDataForUser(userId);
        if (blobMetadata.shouldBeDeleted(true) == false) goto L6;
        deleteBlobLocked(blobMetadata);
        return true;
    L6:
        return false;
    }

    void handleIdleMaintenanceLocked() {
        final ArrayList<Long> deletedBlobIds = new ArrayList();
        ArrayList<File> filesToDelete = new ArrayList();
        File blobsDir = BlobStoreConfig.getBlobsDir();
        if (blobsDir.exists() == false) goto L19;
        File[] r3 = blobsDir.listFiles();
        int r5 = r3.length;
        int r6 = 0;
    L5:
        if (r6 >= r5) goto L16;
        File file = r3[r6];
        long id = Long.parseLong(file.getName());     // Catch: NumberFormatException -> L11
        if (this.mActiveBlobIds.indexOf(Long.valueOf(id)) >= 0) goto L15;
        filesToDelete.add(file);     // Catch: NumberFormatException -> L11
        deletedBlobIds.add(Long.valueOf(id));     // Catch: NumberFormatException -> L11
    L15:
        r6 = r6 + 1;
    L11:
        e = move-exception;
        Slog.wtf(BlobStoreConfig.TAG, "Error parsing the file name: " + file, e);
        filesToDelete.add(file);
        goto L15
    L16:
        int i = 0;
        int count = filesToDelete.size();
    L17:
        if (i >= count) goto L19;
        filesToDelete.get(i).delete();
        i = i + 1;
    L19:
        this.mBlobsMap.entrySet().removeIf(new BlobStoreManagerService$$ExternalSyntheticLambda17(this, deletedBlobIds));
        writeBlobsInfoAsync();
        int i2 = 0;
        int userCount = this.mSessions.size();
    L20:
        if (i2 >= userCount) goto L22;
        LongSparseArray<BlobStoreSession> userSessions = this.mSessions.valueAt(i2);
        userSessions.removeIf(new BlobStoreManagerService$$ExternalSyntheticLambda18(this, deletedBlobIds));
        i2 = i2 + 1;
        goto L20
    L22:
        Slog.d(BlobStoreConfig.TAG, "Completed idle maintenance; deleted " + Arrays.toString(deletedBlobIds.toArray()));
        writeBlobSessionsAsync();
    }

    private /* synthetic */ boolean lambda$handleIdleMaintenanceLocked$15(ArrayList deletedBlobIds, Map.Entry entry) {
        BlobMetadata blobMetadata = (BlobMetadata) entry.getValue();
        blobMetadata.removeExpiredLeases();
        if (blobMetadata.shouldBeDeleted(true) == false) goto L6;
        deleteBlobLocked(blobMetadata);
        deletedBlobIds.add(Long.valueOf(blobMetadata.getBlobId()));
        return true;
    L6:
        return false;
    }

    private /* synthetic */ boolean lambda$handleIdleMaintenanceLocked$16(ArrayList deletedBlobIds, long sessionId, BlobStoreSession blobStoreSession) {
        boolean shouldRemove = false;
        if (blobStoreSession.isExpired() == false) goto L6;
        shouldRemove = true;
    L6:
        if (blobStoreSession.getBlobHandle().isExpired() == false) goto L8;
        shouldRemove = true;
    L8:
        if (shouldRemove == false) goto L10;
        deleteSessionLocked(blobStoreSession);
        deletedBlobIds.add(Long.valueOf(blobStoreSession.getSessionId()));
    L10:
        return shouldRemove;
    }

    private void deleteSessionLocked(BlobStoreSession blobStoreSession) {
        blobStoreSession.destroy();
        this.mActiveBlobIds.remove(Long.valueOf(blobStoreSession.getSessionId()));
    }

    private void deleteBlobLocked(BlobMetadata blobMetadata) {
        blobMetadata.destroy();
        this.mActiveBlobIds.remove(Long.valueOf(blobMetadata.getBlobId()));
    }

    void runClearAllSessions(int userId) {
        Object r0 = this.mBlobsLock;
        monitor-enter(r0);
        int i = 0;
        int userCount = this.mSessions.size();     // Catch: Throwable -> L15
    L7:
        if (i >= userCount) goto L19;
        int sessionUserId = this.mSessions.keyAt(i);     // Catch: Throwable -> L15
        if (userId == (-1)) goto L12;
        if (userId == sessionUserId) goto L12;
    L17:
        i = i + 1;     // Catch: Throwable -> L15
    L12:
        LongSparseArray<BlobStoreSession> userSessions = this.mSessions.valueAt(i);     // Catch: Throwable -> L15
        int j = 0;
        int sessionsCount = userSessions.size();     // Catch: Throwable -> L15
    L13:
        if (j >= sessionsCount) goto L17;
        this.mActiveBlobIds.remove(Long.valueOf(userSessions.valueAt(j).getSessionId()));     // Catch: Throwable -> L15
        j = j + 1;     // Catch: Throwable -> L15
        goto L13
    L19:
        if (userId != (-1)) goto L21;
        this.mSessions.clear();     // Catch: Throwable -> L15
    L22:
        writeBlobSessionsAsync();     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L21:
        this.mSessions.remove(userId);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    void runClearAllBlobs(final int userId) {
        Object r0 = this.mBlobsLock;
        monitor-enter(r0);
        this.mBlobsMap.entrySet().removeIf(new BlobStoreManagerService$$ExternalSyntheticLambda7(this, userId));     // Catch: Throwable -> L7
        writeBlobsInfoAsync();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ boolean lambda$runClearAllBlobs$17(int userId, Map.Entry entry) {
        BlobMetadata blobMetadata = (BlobMetadata) entry.getValue();
        if (userId != (-1)) goto L6;
        this.mActiveBlobIds.remove(Long.valueOf(blobMetadata.getBlobId()));
        return true;
    L6:
        blobMetadata.removeDataForUser(userId);
        if (blobMetadata.shouldBeDeleted(false) == false) goto L10;
        this.mActiveBlobIds.remove(Long.valueOf(blobMetadata.getBlobId()));
        return true;
    L10:
        return false;
    }

    void deleteBlob(BlobHandle blobHandle, int userId) {
        Object r0 = this.mBlobsLock;
        monitor-enter(r0);
        BlobMetadata blobMetadata = this.mBlobsMap.get(blobHandle);     // Catch: Throwable -> L8
        if (blobMetadata != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        blobMetadata.removeDataForUser(userId);     // Catch: Throwable -> L8
        if (blobMetadata.shouldBeDeleted(false) == false) goto L13;
        deleteBlobLocked(blobMetadata);     // Catch: Throwable -> L8
        this.mBlobsMap.remove(blobHandle);     // Catch: Throwable -> L8
    L13:
        writeBlobsInfoAsync();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void runIdleMaintenance() {
        Object r0 = this.mBlobsLock;
        monitor-enter(r0);
        handleIdleMaintenanceLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    boolean isBlobAvailable(long blobId, int userId) {
        Object r0 = this.mBlobsLock;
        monitor-enter(r0);
        int i = 0;
        int blobCount = this.mBlobsMap.size();     // Catch: Throwable -> L13
    L6:
        if (i >= blobCount) goto L16;
        BlobMetadata blobMetadata = this.mBlobsMap.valueAt(i);     // Catch: Throwable -> L13
        if (blobMetadata.getBlobId() == blobId) goto L10;
        i = i + 1;     // Catch: Throwable -> L13
        goto L6
    L10:
        boolean r4 = blobMetadata.hasACommitterInUser(userId);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r4;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return false;
    L13:
        th = move-exception;
        throw th;
    }

    private void dumpSessionsLocked(IndentingPrintWriter fout, DumpArgs dumpArgs) {
        int i = 0;
        int userCount = this.mSessions.size();
    L3:
        if (i >= userCount) goto L17;
        int userId = this.mSessions.keyAt(i);
        if (dumpArgs.shouldDumpUser(userId) == false) goto L15;
        LongSparseArray<BlobStoreSession> userSessions = this.mSessions.valueAt(i);
        fout.println("List of sessions in user #" + userId + " (" + userSessions.size() + "):");
        fout.increaseIndent();
        int j = 0;
        int sessionsCount = userSessions.size();
    L8:
        if (j >= sessionsCount) goto L14;
        long sessionId = userSessions.keyAt(j);
        BlobStoreSession session = userSessions.valueAt(j);
        if (dumpArgs.shouldDumpSession(session.getOwnerPackageName(), session.getOwnerUid(), session.getSessionId()) == false) goto L13;
        fout.println("Session #" + sessionId);
        fout.increaseIndent();
        session.dump(fout, dumpArgs);
        fout.decreaseIndent();
    L13:
        j = j + 1;
        goto L8
    L14:
        fout.decreaseIndent();
    L15:
        i = i + 1;
        goto L3
    }

    private void dumpBlobsLocked(IndentingPrintWriter fout, DumpArgs dumpArgs) {
        fout.println("List of blobs (" + this.mBlobsMap.size() + "):");
        fout.increaseIndent();
        int i = 0;
        int blobCount = this.mBlobsMap.size();
    L3:
        if (i >= blobCount) goto L10;
        BlobMetadata blobMetadata = this.mBlobsMap.valueAt(i);
        if (dumpArgs.shouldDumpBlob(blobMetadata.getBlobId()) == false) goto L8;
        fout.println("Blob #" + blobMetadata.getBlobId());
        fout.increaseIndent();
        blobMetadata.dump(fout, dumpArgs);
        fout.decreaseIndent();
    L8:
        i = i + 1;
        goto L3
    L10:
        if (this.mBlobsMap.isEmpty() == false) goto L12;
        fout.println("<empty>");
    L12:
        fout.decreaseIndent();
    }

    private void forEachSessionInUser(Consumer<BlobStoreSession> consumer, int userId) {
        Object r0 = this.mBlobsLock;
        monitor-enter(r0);
        LongSparseArray<BlobStoreSession> userSessions = getUserSessionsLocked(userId);     // Catch: Throwable -> L7
        int i = 0;
        int count = userSessions.size();     // Catch: Throwable -> L7
    L5:
        if (i >= count) goto L10;
        BlobStoreSession session = userSessions.valueAt(i);     // Catch: Throwable -> L7
        consumer.accept(session);     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L5
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void forEachBlob(Consumer<BlobMetadata> consumer) {
        ArrayMap<BlobHandle, BlobMetadata> r0 = this.mBlobsMap;
        monitor-enter(r0);
        forEachBlobLocked(consumer);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void forEachBlobLocked(Consumer<BlobMetadata> consumer) {
        int blobIdx = 0;
        int count = this.mBlobsMap.size();
    L3:
        if (blobIdx >= count) goto L6;
        BlobMetadata blobMetadata = this.mBlobsMap.valueAt(blobIdx);
        consumer.accept(blobMetadata);
        blobIdx = blobIdx + 1;
        goto L3
    }

    private void forEachBlobLocked(BiConsumer<BlobHandle, BlobMetadata> consumer) {
        int blobIdx = 0;
        int count = this.mBlobsMap.size();
    L3:
        if (blobIdx >= count) goto L6;
        BlobHandle blobHandle = this.mBlobsMap.keyAt(blobIdx);
        BlobMetadata blobMetadata = this.mBlobsMap.valueAt(blobIdx);
        consumer.accept(blobHandle, blobMetadata);
        blobIdx = blobIdx + 1;
        goto L3
    }

    private boolean isAllowedBlobStoreAccess(int uid, String packageName) {
        if (Process.isSdkSandboxUid(uid) == false) goto L5;
    L9:
        return false;
    L5:
        if (Process.isIsolated(uid) == true) goto L9;
        if (this.mPackageManagerInternal.isInstantApp(packageName, UserHandle.getUserId(uid)) == true) goto L9;
        return true;
    }

    private void registerBlobStorePuller() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.BLOB_INFO, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    private static /* synthetic */ void lambda$pullBlobData$18(List data, int atomTag, BlobMetadata blobMetadata) {
        data.add(blobMetadata.dumpAsStatsEvent(atomTag));
    }

    private int pullBlobData(final int atomTag, final List<StatsEvent> data) {
        forEachBlob(new BlobStoreManagerService$$ExternalSyntheticLambda10(data, atomTag));
        return 0;
    }
}
