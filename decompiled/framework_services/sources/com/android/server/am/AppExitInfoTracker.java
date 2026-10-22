package com.android.server.am;

import android.R;
import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.app.IAppTraceRetriever;
import android.content.IntentFilter;
import android.icu.text.SimpleDateFormat;
import android.os.Binder;
import android.os.FileUtils;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.system.OsConstants;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.AtomicFile;
import android.util.Pair;
import android.util.Pools;
import android.util.Slog;
import android.util.SparseArray;
import android.util.proto.ProtoInputStream;
import android.util.proto.ProtoOutputStream;
import android.util.proto.WireTypeMismatchException;
import com.android.internal.app.ProcessMap;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.function.pooled.PooledLambda;
import com.android.server.IoThread;
import com.android.server.LocalServices;
import com.android.server.ServiceThread;
import com.android.server.SystemServiceManager;
import com.android.server.os.NativeTombstoneManager;
import com.android.server.pm.Settings;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class AppExitInfoTracker {
    static final String APP_EXIT_INFO_FILE = "procexitinfo";
    private static final long APP_EXIT_INFO_PERSIST_INTERVAL = 0;
    private static final long APP_EXIT_INFO_STATSD_LOG_DEBOUNCE = 0;
    private static final int APP_EXIT_RAW_INFO_POOL_SIZE = 8;
    static final String APP_EXIT_STORE_DIR = "procexitstore";
    private static final String APP_TRACE_FILE_SUFFIX = ".gz";
    static final int FOREACH_ACTION_NONE = 0;
    static final int FOREACH_ACTION_REMOVE_ITEM = 1;
    static final int FOREACH_ACTION_STOP_ITERATION = 2;
    private static final String TAG = "ActivityManager";
    final SparseArray<SparseArray<byte[]>> mActiveAppStateSummary;
    final SparseArray<SparseArray<File>> mActiveAppTraces;
    private int mAppExitInfoHistoryListSize;
    AtomicBoolean mAppExitInfoLoaded;
    private Runnable mAppExitInfoPersistTask;
    final AppExitInfoExternalSource mAppExitInfoSourceLmkd;
    final AppExitInfoExternalSource mAppExitInfoSourceZygote;
    final AppTraceRetriever mAppTraceRetriever;
    private final ProcessMap<AppExitInfoContainer> mData;
    final IsolatedUidRecords mIsolatedUidRecords;
    private KillHandler mKillHandler;
    private long mLastAppExitInfoPersistTimestamp;
    final Object mLock;
    File mProcExitInfoFile;
    File mProcExitStoreDir;
    private final Pools.SynchronizedPool<ApplicationExitInfo> mRawRecordsPool;
    private ActivityManagerService mService;
    final ArrayList<ApplicationExitInfo> mTmpInfoList;
    final ArrayList<ApplicationExitInfo> mTmpInfoList2;

    final class AppExitInfoContainer {
        private ArrayList<ApplicationExitInfo> mExitInfos;
        private int mMaxCapacity;
        private int mUid;
        final /* synthetic */ AppExitInfoTracker this$0;

        public static /* synthetic */ int $r8$lambda$ai5g8feGyep_Z1zOuKXjbK4MGH8(ApplicationExitInfo r0, ApplicationExitInfo r1) {
            return lambda$getExitInfosLocked$0(r0, r1);
        }

        /* JADX INFO: renamed from: -$$Nest$fputmUid, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m1298$$Nest$fputmUid(AppExitInfoContainer r0, int r1) {
            r0.mUid = r1;
        }

        AppExitInfoContainer(AppExitInfoTracker this$0, int maxCapacity) {
            this.this$0 = this$0;
            this.mExitInfos = new ArrayList();
            this.mMaxCapacity = maxCapacity;
        }

        void getExitInfosLocked(int filterPid, int maxNum, List<ApplicationExitInfo> results) {
            if (this.mExitInfos.size() != 0) goto L6;
            return;
        L6:
            if (maxNum != 1) goto L23;
            ApplicationExitInfo result = null;
            int i = 0;
            int size = this.mExitInfos.size();
        L8:
            if (i >= size) goto L20;
            ApplicationExitInfo info = this.mExitInfos.get(i);
            if (filterPid > 0) goto L12;
        L14:
            if (result != null) goto L16;
        L17:
            result = info;
        L18:
            i = i + 1;
            goto L8
        L16:
            if (result.getTimestamp() >= info.getTimestamp()) goto L18;
        L12:
            if (info.getPid() == filterPid) goto L14;
        L20:
            if (result == null) goto L49;
            results.add(result);
            return;
        L49:
            return;
        L23:
            this.this$0.mTmpInfoList2.clear();
            if (filterPid > 0) goto L26;
            this.this$0.mTmpInfoList2.addAll(this.mExitInfos);
        L32:
            Collections.sort(this.this$0.mTmpInfoList2, new AppExitInfoTracker$AppExitInfoContainer$$ExternalSyntheticLambda0());
            if (maxNum > 0) goto L36;
            results.addAll(this.this$0.mTmpInfoList2);
            return;
        L36:
            int elementsToRemove = this.this$0.mTmpInfoList2.size() - maxNum;
            int i2 = 0;
        L37:
            if (i2 >= elementsToRemove) goto L39;
            this.this$0.mTmpInfoList2.removeLast();
            i2 = i2 + 1;
            goto L37
        L39:
            results.addAll(this.this$0.mTmpInfoList2);
            return;
        L26:
            int i3 = 0;
            int size2 = this.mExitInfos.size();
        L27:
            if (i3 >= size2) goto L32;
            ApplicationExitInfo info2 = this.mExitInfos.get(i3);
            if (info2.getPid() != filterPid) goto L31;
            this.this$0.mTmpInfoList2.add(info2);
        L31:
            i3 = i3 + 1;
            goto L27
        }

        private static /* synthetic */ int lambda$getExitInfosLocked$0(ApplicationExitInfo a, ApplicationExitInfo b) {
            return Long.compare(b.getTimestamp(), a.getTimestamp());
        }

        void addExitInfoLocked(ApplicationExitInfo info) {
            int uid = info.getPackageUid();
            if (Process.isSdkSandboxUid(info.getRealUid()) == false) goto L5;
            uid = info.getRealUid();
        L5:
            int pid = info.getPid();
            if (info.getProcessStateSummary() != null) goto L9;
            info.setProcessStateSummary((byte[]) AppExitInfoTracker.m1297$$Nest$smfindAndRemoveFromSparse2dArray(this.this$0.mActiveAppStateSummary, uid, pid));
        L9:
            if (info.getTraceFile() != null) goto L11;
            info.setTraceFile((File) AppExitInfoTracker.m1297$$Nest$smfindAndRemoveFromSparse2dArray(this.this$0.mActiveAppTraces, uid, pid));
        L11:
            info.setAppTraceRetriever(this.this$0.mAppTraceRetriever);
            this.mExitInfos.add(info);
            if (this.mExitInfos.size() > this.mMaxCapacity) goto L14;
            return;
        L14:
            ApplicationExitInfo oldest = null;
            int i = 0;
            int size = this.mExitInfos.size();
        L15:
            if (i >= size) goto L22;
            ApplicationExitInfo info2 = this.mExitInfos.get(i);
            if (oldest != null) goto L19;
        L20:
            oldest = info2;
        L21:
            i = i + 1;
            goto L15
        L19:
            if (info2.getTimestamp() >= oldest.getTimestamp()) goto L21;
        L22:
            File traceFile = oldest.getTraceFile();
            if (traceFile == null) goto L25;
            traceFile.delete();
        L25:
            this.mExitInfos.remove(oldest);
        }

        ApplicationExitInfo getLastExitInfoForPid(int pid) {
            this.this$0.mTmpInfoList.clear();
            getExitInfosLocked(pid, 1, this.this$0.mTmpInfoList);
            if (this.this$0.mTmpInfoList.size() != 0) goto L5;
            ApplicationExitInfo info = null;
        L6:
            this.this$0.mTmpInfoList.clear();
            return info;
        L5:
            info = (ApplicationExitInfo) this.this$0.mTmpInfoList.getFirst();
            goto L6
        }

        boolean appendTraceIfNecessaryLocked(int pid, File traceFile) {
            ApplicationExitInfo r = getLastExitInfoForPid(pid);
            if (r == null) goto L6;
            r.setTraceFile(traceFile);
            r.setAppTraceRetriever(this.this$0.mAppTraceRetriever);
            return true;
        L6:
            return false;
        }

        void destroyLocked() {
            int i = 0;
            int size = this.mExitInfos.size();
        L3:
            if (i >= size) goto L9;
            ApplicationExitInfo info = this.mExitInfos.get(i);
            File traceFile = info.getTraceFile();
            if (traceFile == null) goto L7;
            traceFile.delete();
        L7:
            info.setTraceFile(null);
            info.setAppTraceRetriever(null);
            i = i + 1;
            goto L3
        }

        void forEachRecordLocked(Function<ApplicationExitInfo, Integer> callback) {
            if (callback != null) goto L4;
            return;
        L4:
            int i = this.mExitInfos.size() - 1;
        L5:
            if (i < 0) goto L16;
            ApplicationExitInfo info = this.mExitInfos.get(i);
            switch(callback.apply(info).intValue()) {
                case 1: goto L10;
                case 2: goto L9;
                default: goto L14;
            };
        L10:
            File traceFile = info.getTraceFile();
            if (traceFile == null) goto L13;
            traceFile.delete();
        L13:
            this.mExitInfos.remove(info);
            goto L14
        L9:
            return;
        L14:
            i = i - 1;
            goto L5
        }

        void dumpLocked(PrintWriter pw, String prefix, SimpleDateFormat sdf) {
            this.this$0.mTmpInfoList.clear();
            getExitInfosLocked(0, 0, this.this$0.mTmpInfoList);
            int i = 0;
            int size = this.this$0.mTmpInfoList.size();
        L3:
            if (i >= size) goto L5;
            this.this$0.mTmpInfoList.get(i).dump(pw, prefix + "  ", "#" + i, sdf);
            i = i + 1;
            goto L3
        L5:
            this.this$0.mTmpInfoList.clear();
        }

        void writeToProto(ProtoOutputStream proto, long fieldId) {
            long token = proto.start(fieldId);
            proto.write(1120986464257L, this.mUid);
            int i = 0;
            int size = this.mExitInfos.size();
        L3:
            if (i >= size) goto L5;
            this.mExitInfos.get(i).writeToProto(proto, 2246267895810L);
            i = i + 1;
            goto L3
        L5:
            proto.end(token);
        }

        int readFromProto(ProtoInputStream proto, long fieldId) throws IOException, WireTypeMismatchException {
            long token = proto.start(fieldId);
            int next = proto.nextField();
        L4:
            if (next == (-1)) goto L10;
            switch(next) {
                case 1: goto L8;
                case 2: goto L7;
                default: goto L9;
            };
        L7:
            ApplicationExitInfo info = new ApplicationExitInfo();
            info.readFromProto(proto, 2246267895810L);
            this.mExitInfos.add(info);
            goto L9
        L8:
            this.mUid = proto.readInt(1120986464257L);
        L9:
            next = proto.nextField();
            goto L4
        L10:
            proto.end(token);
            return this.mUid;
        }
    }

    final class AppExitInfoExternalSource {
        private static final long APP_EXIT_INFO_FRESHNESS_MS = 300000;
        private final SparseArray<SparseArray<Pair<Long, Object>>> mData;
        private final Integer mPresetReason;
        private BiConsumer<Integer, Integer> mProcDiedListener;
        private final String mTag;
        final /* synthetic */ AppExitInfoTracker this$0;

        public static /* synthetic */ void $r8$lambda$YNqE5oyIePUMpW0I2BEf6coo8g0(BiConsumer r0, int r1, int r2) {
            lambda$onProcDied$0(r0, r1, r2);
        }

        AppExitInfoExternalSource(AppExitInfoTracker this$0, String tag, Integer reason) {
            this.this$0 = this$0;
            this.mData = new SparseArray();
            this.mTag = tag;
            this.mPresetReason = reason;
        }

        private void addLocked(int pid, int uid, Object extra) {
            Integer k = this.this$0.mIsolatedUidRecords.getUidByIsolatedUid(uid);
            if (k == null) goto L5;
            uid = k.intValue();
        L5:
            SparseArray<Pair<Long, Object>> array = this.mData.get(uid);
            if (array != null) goto L8;
            array = new SparseArray();
            this.mData.put(uid, array);
        L8:
            array.put(pid, new Pair(Long.valueOf(System.currentTimeMillis()), extra));
        }

        Pair<Long, Object> remove(int pid, int uid) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            Integer k = this.this$0.mIsolatedUidRecords.getUidByIsolatedUid(uid);     // Catch: Throwable -> L7
            if (k == null) goto L9;
            uid = k.intValue();     // Catch: Throwable -> L7
        L9:
            SparseArray<Pair<Long, Object>> array = this.mData.get(uid);     // Catch: Throwable -> L7
            Pair<Long, Object> r3 = null;
            if (array == null) goto L18;
            Pair<Long, Object> p = array.get(pid);     // Catch: Throwable -> L7
            if (p == null) goto L18;
            array.remove(pid);     // Catch: Throwable -> L7
            if (this.this$0.isFresh(((Long) p.first).longValue()) == false) goto L16;
            r3 = p;
        L16:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L18:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return null;
        L7:
            th = move-exception;
            throw th;
        }

        void removeByUserId(int userId) {
            if (userId != (-2)) goto L5;
            userId = AppExitInfoTracker.m1292$$Nest$fgetmService(this.this$0).mUserController.getCurrentUserId();
        L5:
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            if (userId != (-1)) goto L14;
            this.mData.clear();     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L14:
            int i = this.mData.size() - 1;     // Catch: Throwable -> L12
        L15:
            if (i < 0) goto L21;
            int uid = this.mData.keyAt(i);     // Catch: Throwable -> L12
            if (UserHandle.getUserId(uid) != userId) goto L19;
            this.mData.removeAt(i);     // Catch: Throwable -> L12
        L19:
            i = i - 1;     // Catch: Throwable -> L12
            goto L15
        L21:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            throw th;
        }

        void removeByUidLocked(int uid, boolean allUsers) {
            if (UserHandle.isIsolated(uid) == false) goto L7;
            Integer k = this.this$0.mIsolatedUidRecords.getUidByIsolatedUid(uid);
            if (k == null) goto L7;
            uid = k.intValue();
        L7:
            if (allUsers == false) goto L15;
            int uid2 = UserHandle.getAppId(uid);
            int i = this.mData.size() - 1;
        L9:
            if (i < 0) goto L20;
            if (UserHandle.getAppId(this.mData.keyAt(i)) != uid2) goto L13;
            this.mData.removeAt(i);
        L13:
            i = i - 1;
            goto L9
        L20:
            return;
        L15:
            this.mData.remove(uid);
        }

        void setOnProcDiedListener(BiConsumer<Integer, Integer> listener) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            this.mProcDiedListener = listener;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        void onProcDied(final int pid, final int uid, Integer status, Long rssKb) {
            if (ActivityManagerDebugConfig.DEBUG_PROCESSES == false) goto L6;
            Slog.i(AppExitInfoTracker.TAG, this.mTag + ": proc died: pid=" + pid + " uid=" + uid + ", status=" + status);
        L6:
            if (AppExitInfoTracker.m1292$$Nest$fgetmService(this.this$0) != null) goto L8;
            return;
        L8:
            Object r1 = this.this$0.mLock;
            monitor-enter(r1);
            if (AppExitInfoTracker.m1296$$Nest$mupdateExitInfoIfNecessaryLocked(this.this$0, pid, uid, status, this.mPresetReason, rssKb) == true) goto L19;
            if (rssKb == null) goto L18;
            addLocked(pid, uid, rssKb);     // Catch: Throwable -> L16
            goto L19
        L18:
            addLocked(pid, uid, status);     // Catch: Throwable -> L16
        L19:
            final BiConsumer<Integer, Integer> listener = this.mProcDiedListener;     // Catch: Throwable -> L16
            if (listener == null) goto L22;
            AppExitInfoTracker.m1292$$Nest$fgetmService(this.this$0).mHandler.post(new AppExitInfoTracker$AppExitInfoExternalSource$$ExternalSyntheticLambda0(listener, pid, uid));     // Catch: Throwable -> L16
        L22:
            monitor-exit(r1);     // Catch: Throwable -> L16
            return;
        L16:
            th = move-exception;
            Throwable r9 = th;
        L26:
            monitor-exit(r1);     // Catch: Throwable -> L16
            throw r9;
        L24:
            th = move-exception;
            r9 = th;
            goto L26
        }

        private static /* synthetic */ void lambda$onProcDied$0(BiConsumer listener, int pid, int uid) {
            listener.accept(Integer.valueOf(pid), Integer.valueOf(uid));
        }
    }

    class AppTraceRetriever extends IAppTraceRetriever.Stub {
        final /* synthetic */ AppExitInfoTracker this$0;

        AppTraceRetriever(AppExitInfoTracker this$0) {
            this.this$0 = this$0;
        }

        public ParcelFileDescriptor getTraceFileDescriptor(String packageName, int uid, int pid) {
            AppExitInfoTracker.m1292$$Nest$fgetmService(this.this$0).enforceNotIsolatedCaller("getTraceFileDescriptor");
            if (TextUtils.isEmpty(packageName) == true) goto L35;
            int callingPid = Binder.getCallingPid();
            int callingUid = Binder.getCallingUid();
            int userId = UserHandle.getUserId(uid);
            AppExitInfoTracker.m1292$$Nest$fgetmService(this.this$0).mUserController.handleIncomingUser(callingPid, callingUid, userId, true, 0, "getTraceFileDescriptor", null);
            int filterUid = AppExitInfoTracker.m1292$$Nest$fgetmService(this.this$0).enforceDumpPermissionForPackage(packageName, userId, callingUid, "getTraceFileDescriptor");
            if (filterUid == (-1)) goto L33;
            Object r6 = this.this$0.mLock;
            monitor-enter(r6);
            ApplicationExitInfo info = AppExitInfoTracker.m1294$$Nest$mgetExitInfoLocked(this.this$0, packageName, filterUid, pid);     // Catch: Throwable -> L12
            if (info != null) goto L14;
            monitor-exit(r6);     // Catch: Throwable -> L12
            return null;
        L14:
            File traceFile = info.getTraceFile();     // Catch: Throwable -> L12
            if (traceFile != null) goto L18;
            monitor-exit(r6);     // Catch: Throwable -> L12
            return null;
        L18:
            long identity = Binder.clearCallingIdentity();     // Catch: Throwable -> L12
            ParcelFileDescriptor r0 = ParcelFileDescriptor.open(traceFile, 268435456);     // Catch: Throwable -> L24 FileNotFoundException -> L27
            Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L12
            monitor-exit(r6);     // Catch: Throwable -> L12
            return r0;
        L24:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L12
            throw th;     // Catch: Throwable -> L12
        L28:
            Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L12
            return null;
        L12:
            th = move-exception;
            throw th;
        L33:
            return null;
        L35:
            throw new IllegalArgumentException("Invalid package name");
        }
    }

    final class IsolatedUidRecords {
        private final SparseArray<Integer> mIsolatedUidToUidMap;
        private final SparseArray<ArraySet<Integer>> mUidToIsolatedUidMap;
        final /* synthetic */ AppExitInfoTracker this$0;

        IsolatedUidRecords(AppExitInfoTracker this$0) {
            this.this$0 = this$0;
            this.mUidToIsolatedUidMap = new SparseArray();
            this.mIsolatedUidToUidMap = new SparseArray();
        }

        void addIsolatedUid(int isolatedUid, int uid) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            ArraySet<Integer> set = this.mUidToIsolatedUidMap.get(uid);     // Catch: Throwable -> L7
            if (set != null) goto L9;
            set = new ArraySet();     // Catch: Throwable -> L7
            this.mUidToIsolatedUidMap.put(uid, set);     // Catch: Throwable -> L7
        L9:
            set.add(Integer.valueOf(isolatedUid));     // Catch: Throwable -> L7
            this.mIsolatedUidToUidMap.put(isolatedUid, Integer.valueOf(uid));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        void removeIsolatedUid(int isolatedUid, int uid) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            int index = this.mUidToIsolatedUidMap.indexOfKey(uid);     // Catch: Throwable -> L9
            if (index < 0) goto L11;
            ArraySet<Integer> set = this.mUidToIsolatedUidMap.valueAt(index);     // Catch: Throwable -> L9
            set.remove(Integer.valueOf(isolatedUid));     // Catch: Throwable -> L9
            if (set.isEmpty() == false) goto L11;
            this.mUidToIsolatedUidMap.removeAt(index);     // Catch: Throwable -> L9
        L11:
            this.mIsolatedUidToUidMap.remove(isolatedUid);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }

        Integer getUidByIsolatedUid(int isolatedUid) {
            if (UserHandle.isIsolated(isolatedUid) == false) goto L13;
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            Integer r1 = this.mIsolatedUidToUidMap.get(isolatedUid);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r1;
        L9:
            th = move-exception;
            throw th;
        L13:
            return Integer.valueOf(isolatedUid);
        }

        private void removeAppUidLocked(int uid) {
            ArraySet<Integer> set = this.mUidToIsolatedUidMap.get(uid);
            if (set == null) goto L7;
            int i = set.size() - 1;
        L5:
            if (i < 0) goto L9;
            int isolatedUid = set.removeAt(i).intValue();
            this.mIsolatedUidToUidMap.remove(isolatedUid);
            i = i - 1;
            goto L5
        L9:
            return;
        }

        void removeAppUid(int uid, boolean allUsers) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            if (allUsers == false) goto L14;
            int uid2 = UserHandle.getAppId(uid);     // Catch: Throwable -> L10
            int i = this.mUidToIsolatedUidMap.size() - 1;     // Catch: Throwable -> L10
        L6:
            if (i < 0) goto L15;
            int u = this.mUidToIsolatedUidMap.keyAt(i);     // Catch: Throwable -> L10
            if (uid2 != UserHandle.getAppId(u)) goto L12;
            removeAppUidLocked(u);     // Catch: Throwable -> L10
        L12:
            this.mUidToIsolatedUidMap.removeAt(i);     // Catch: Throwable -> L10
            i = i - 1;     // Catch: Throwable -> L10
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L14:
            removeAppUidLocked(uid);     // Catch: Throwable -> L10
            this.mUidToIsolatedUidMap.remove(uid);     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }

        int removeIsolatedUidLocked(int isolatedUid) {
            if (UserHandle.isIsolated(isolatedUid) == true) goto L5;
            return isolatedUid;
        L5:
            int uid = this.mIsolatedUidToUidMap.get(isolatedUid, -1).intValue();
            if (uid != (-1)) goto L8;
            return isolatedUid;
        L8:
            this.mIsolatedUidToUidMap.remove(isolatedUid);
            ArraySet<Integer> set = this.mUidToIsolatedUidMap.get(uid);
            if (set == null) goto L11;
            set.remove(Integer.valueOf(isolatedUid));
        L11:
            return uid;
        }

        void removeByUserId(int userId) {
            if (userId != (-2)) goto L5;
            userId = AppExitInfoTracker.m1292$$Nest$fgetmService(this.this$0).mUserController.getCurrentUserId();
        L5:
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            if (userId != (-1)) goto L14;
            this.mIsolatedUidToUidMap.clear();     // Catch: Throwable -> L12
            this.mUidToIsolatedUidMap.clear();     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L14:
            int i = this.mIsolatedUidToUidMap.size() - 1;     // Catch: Throwable -> L12
        L15:
            if (i < 0) goto L21;
            this.mIsolatedUidToUidMap.keyAt(i);     // Catch: Throwable -> L12
            int uid = this.mIsolatedUidToUidMap.valueAt(i).intValue();     // Catch: Throwable -> L12
            if (UserHandle.getUserId(uid) != userId) goto L19;
            this.mIsolatedUidToUidMap.removeAt(i);     // Catch: Throwable -> L12
            this.mUidToIsolatedUidMap.remove(uid);     // Catch: Throwable -> L12
        L19:
            i = i - 1;     // Catch: Throwable -> L12
            goto L15
        L21:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            throw th;
        }
    }

    final class KillHandler extends Handler {
        static final int MSG_APP_KILL = 4104;
        static final int MSG_APP_RECOVERABLE_CRASH = 4106;
        static final int MSG_CHILD_PROC_DIED = 4102;
        static final int MSG_LMKD_PROC_KILLED = 4101;
        static final int MSG_PROC_DIED = 4103;
        static final int MSG_STATSD_LOG = 4105;
        final /* synthetic */ AppExitInfoTracker this$0;

        KillHandler(AppExitInfoTracker this$0, Looper looper) {
            this.this$0 = this$0;
            super(looper, null, true);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 4101: goto L38;
                case 4102: goto L37;
                case 4103: goto L29;
                case 4104: goto L21;
                case 4105: goto L13;
                case 4106: goto L5;
                default: goto L4;
            };
        L4:
            super.handleMessage(msg);
            return;
        L5:
            ApplicationExitInfo raw = (ApplicationExitInfo) msg.obj;
            Object r1 = this.this$0.mLock;
            monitor-enter(r1);
            AppExitInfoTracker.m1293$$Nest$maddExitInfoLocked(this.this$0, raw);     // Catch: Throwable -> L10
            monitor-exit(r1);     // Catch: Throwable -> L10
            this.this$0.recycleRawRecord(raw);
            return;
        L10:
            th = move-exception;
            throw th;
        L13:
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            AppExitInfoTracker.m1295$$Nest$mperformLogToStatsdLocked(this.this$0, (ApplicationExitInfo) msg.obj);     // Catch: Throwable -> L18
            monitor-exit(r0);     // Catch: Throwable -> L18
            return;
        L18:
            th = move-exception;
            throw th;
        L21:
            ApplicationExitInfo raw2 = (ApplicationExitInfo) msg.obj;
            Object r2 = this.this$0.mLock;
            monitor-enter(r2);
            this.this$0.handleNoteAppKillLocked(raw2);     // Catch: Throwable -> L26
            monitor-exit(r2);     // Catch: Throwable -> L26
            this.this$0.recycleRawRecord(raw2);
            return;
        L26:
            th = move-exception;
            throw th;
        L29:
            ApplicationExitInfo raw3 = (ApplicationExitInfo) msg.obj;
            Object r3 = this.this$0.mLock;
            monitor-enter(r3);
            this.this$0.handleNoteProcessDiedLocked(raw3);     // Catch: Throwable -> L34
            monitor-exit(r3);     // Catch: Throwable -> L34
            this.this$0.recycleRawRecord(raw3);
            return;
        L34:
            th = move-exception;
            throw th;
        L37:
            this.this$0.mAppExitInfoSourceZygote.onProcDied(msg.arg1, msg.arg2, (Integer) msg.obj, null);
            return;
        L38:
            this.this$0.mAppExitInfoSourceLmkd.onProcDied(msg.arg1, msg.arg2, null, (Long) msg.obj);
        }
    }

    interface LmkdKillListener {
        void onLmkdKillOccurred(int r1, int r2);
    }

    public static /* synthetic */ Integer $r8$lambda$79m5azk2tK6LcZ3Yl1NAv9TePfo(int r0, int r1, List r2, String r3, SparseArray r4) {
        return lambda$getExitInfo$3(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$C-42QRtlcPZF8LMuQWWEP8-FpiE, reason: not valid java name */
    public static /* synthetic */ boolean m1290$r8$lambda$C42QRtlcPZF8LMuQWWEP8FpiE(int r0, Integer r1) {
        return lambda$removeByUserIdLocked$7(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$DeyBgliE0co2LFb6l0tew15W3tI(LmkdKillListener r0, Integer r1, Integer r2) {
        lambda$setLmkdKillListener$1(r0, r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$FobXridV8bJbSJwLZ01HIoNqLBM(int r0, Integer r1) {
        return lambda$removeByUserIdLocked$8(r0, r1);
    }

    public static /* synthetic */ Integer $r8$lambda$OWHcomjhuh9GSg33DvNTU9an5Wo(int r0, String r1, SparseArray r2) {
        return lambda$removeByUserIdLocked$10(r0, r1, r2);
    }

    public static /* synthetic */ Integer $r8$lambda$PBal3LhXhlJzkyZGQhM9r0rLIVk(ArraySet r0, ApplicationExitInfo r1) {
        return lambda$pruneAnrTracesIfNecessaryLocked$13(r0, r1);
    }

    public static /* synthetic */ int $r8$lambda$TPzc1BYfBz6DIcGfSaFuUE6sNrk(ApplicationExitInfo r0, ApplicationExitInfo r1) {
        return lambda$getExitInfo$4(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$cLz4iUeWqZoK0EW5TZSsc7S3PCk(ArraySet r0, File r1) {
        lambda$pruneAnrTracesIfNecessaryLocked$15(r0, r1);
    }

    public static /* synthetic */ Integer $r8$lambda$e9BXcnIkbk10cETntxBOeT7VHoQ(AppExitInfoTracker r0, int r1, int r2, boolean[] r3, Integer r4, Integer r5, Long r6, String r7, SparseArray r8) {
        return r0.lambda$updateExitInfoIfNecessaryLocked$2(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* synthetic */ void $r8$lambda$fsNqCm83thaKw9uks7YUEatBS_E(File r0) {
        lambda$handleLogAnrTrace$11(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$h-8YP32HtmCPcUbOWTowipwKDNc, reason: not valid java name */
    public static /* synthetic */ void m1291$r8$lambda$h8YP32HtmCPcUbOWTowipwKDNc(AppExitInfoTracker r0) {
        r0.lambda$onSystemReady$0();
    }

    public static /* synthetic */ void $r8$lambda$jYTNDCvJr3W8Cm9aBB_O8XuX3BY(File r0) {
        lambda$removeByUserIdLocked$9(r0);
    }

    public static /* synthetic */ Integer $r8$lambda$s0EKUBJJZeJwfK4O5JO_62l6adE(ArraySet r0, String r1, SparseArray r2) {
        return lambda$pruneAnrTracesIfNecessaryLocked$14(r0, r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$ssiqOZh4VOBkBnURlK4Jng8PzkI(ArraySet r0, File r1) {
        return lambda$pruneAnrTracesIfNecessaryLocked$12(r0, r1);
    }

    public static /* synthetic */ Integer $r8$lambda$suhVvBtvtWr_A5EY9keo_d8eTdU(ProtoOutputStream r0, String r1, SparseArray r2) {
        return lambda$persistProcessExitInfo$5(r0, r1, r2);
    }

    public static /* synthetic */ Integer $r8$lambda$u1Wh6UXS6IHKkHcVHzIA5WClufo(AppExitInfoTracker r0, PrintWriter r1, SimpleDateFormat r2, String r3, SparseArray r4) {
        return r0.lambda$dumpHistoryProcessExitInfo$6(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmService, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityManagerService m1292$$Nest$fgetmService(AppExitInfoTracker r0) {
        return r0.mService;
    }

    /* JADX INFO: renamed from: -$$Nest$maddExitInfoLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ ApplicationExitInfo m1293$$Nest$maddExitInfoLocked(AppExitInfoTracker r0, ApplicationExitInfo r1) {
        return r0.addExitInfoLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetExitInfoLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ ApplicationExitInfo m1294$$Nest$mgetExitInfoLocked(AppExitInfoTracker r0, String r1, int r2, int r3) {
        return r0.getExitInfoLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mperformLogToStatsdLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1295$$Nest$mperformLogToStatsdLocked(AppExitInfoTracker r0, ApplicationExitInfo r1) {
        r0.performLogToStatsdLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateExitInfoIfNecessaryLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m1296$$Nest$mupdateExitInfoIfNecessaryLocked(AppExitInfoTracker r0, int r1, int r2, Integer r3, Integer r4, Long r5) {
        return r0.updateExitInfoIfNecessaryLocked(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$smfindAndRemoveFromSparse2dArray, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m1297$$Nest$smfindAndRemoveFromSparse2dArray(SparseArray r0, int r1, int r2) {
        return findAndRemoveFromSparse2dArray(r0, r1, r2);
    }

    static {
        APP_EXIT_INFO_PERSIST_INTERVAL = TimeUnit.MINUTES.toMillis(30);
        APP_EXIT_INFO_STATSD_LOG_DEBOUNCE = TimeUnit.SECONDS.toMillis(15);
    }

    AppExitInfoTracker() {
        this.mLock = new Object();
        this.mAppExitInfoPersistTask = null;
        this.mLastAppExitInfoPersistTimestamp = 0;
        this.mAppExitInfoLoaded = new AtomicBoolean();
        this.mTmpInfoList = new ArrayList();
        this.mTmpInfoList2 = new ArrayList();
        this.mIsolatedUidRecords = new IsolatedUidRecords(this);
        this.mAppExitInfoSourceZygote = new AppExitInfoExternalSource(this, "zygote", null);
        this.mAppExitInfoSourceLmkd = new AppExitInfoExternalSource(this, "lmkd", 3);
        this.mActiveAppStateSummary = new SparseArray();
        this.mActiveAppTraces = new SparseArray();
        this.mAppTraceRetriever = new AppTraceRetriever(this);
        this.mData = new ProcessMap();
        this.mRawRecordsPool = new Pools.SynchronizedPool(8);
    }

    void init(ActivityManagerService service) {
        this.mService = service;
        ServiceThread thread = new ServiceThread("ActivityManager:killHandler", 10, true);
        thread.start();
        this.mKillHandler = new KillHandler(this, thread.getLooper());
        this.mProcExitStoreDir = new File(SystemServiceManager.ensureSystemDir(), APP_EXIT_STORE_DIR);
        if (FileUtils.createDir(this.mProcExitStoreDir) == true) goto L6;
        Slog.e(TAG, "Unable to create " + this.mProcExitStoreDir);
        return;
    L6:
        this.mProcExitInfoFile = new File(this.mProcExitStoreDir, APP_EXIT_INFO_FILE);
        this.mAppExitInfoHistoryListSize = service.mContext.getResources().getInteger(R.integer.config_attentionMaximumExtension);
    }

    void onSystemReady() {
        registerForUserRemoval();
        registerForPackageRemoval();
        IoThread.getHandler().post(new AppExitInfoTracker$$ExternalSyntheticLambda0(this));
    }

    private /* synthetic */ void lambda$onSystemReady$0() {
        SystemProperties.set("persist.sys.lmk.reportkills", Boolean.toString(SystemProperties.getBoolean("sys.lmk.reportkills", false)));
        loadExistingProcessExitInfo();
    }

    void scheduleNoteProcessDied(ProcessRecord app) {
        if (app != null) goto L4;
        return;
    L4:
        if (app.info != null) goto L7;
        return;
    L7:
        if (this.mAppExitInfoLoaded.get() == true) goto L9;
        return;
    L9:
        this.mKillHandler.obtainMessage(4103, obtainRawRecord(app, System.currentTimeMillis())).sendToTarget();
    }

    void scheduleNoteAppKill(ProcessRecord app, int reason, int subReason, String msg) {
        if (this.mAppExitInfoLoaded.get() == true) goto L5;
        return;
    L5:
        if (app != null) goto L7;
        return;
    L7:
        if (app.info == null) goto L12;
        ApplicationExitInfo raw = obtainRawRecord(app, System.currentTimeMillis());
        raw.setReason(reason);
        raw.setSubReason(subReason);
        raw.setDescription(msg);
        this.mKillHandler.obtainMessage(4104, raw).sendToTarget();
        return;
    }

    void scheduleNoteAppRecoverableCrash(ProcessRecord app) {
        if (this.mAppExitInfoLoaded.get() == false) goto L10;
        if (app != null) goto L6;
        return;
    L6:
        if (app.info == null) goto L12;
        ApplicationExitInfo raw = obtainRawRecord(app, System.currentTimeMillis());
        raw.setReason(5);
        raw.setSubReason(0);
        raw.setDescription("recoverable_crash");
        this.mKillHandler.obtainMessage(4106, raw).sendToTarget();
        return;
    L12:
        return;
    }

    void scheduleNoteAppKill(int pid, int uid, int reason, int subReason, String msg) {
        if (this.mAppExitInfoLoaded.get() == true) goto L5;
        return;
    L5:
        ActivityManagerService.PidMap r0 = this.mService.mPidsSelfLocked;
        monitor-enter(r0);
        ProcessRecord app = this.mService.mPidsSelfLocked.get(pid);     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        if (app == null) goto L11;
        scheduleNoteAppKill(app, reason, subReason, msg);
        return;
    L11:
        if (ActivityManagerDebugConfig.DEBUG_PROCESSES == false) goto L20;
        Slog.w(TAG, "Skipping saving the kill reason for pid " + pid + "(uid=" + uid + ") since its process record is not found");
        return;
    L20:
        return;
    L15:
        th = move-exception;
        throw th;
    }

    void setLmkdKillListener(final LmkdKillListener listener) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mAppExitInfoSourceLmkd.setOnProcDiedListener(new AppExitInfoTracker$$ExternalSyntheticLambda1(listener));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$setLmkdKillListener$1(LmkdKillListener listener, Integer pid, Integer uid) {
        listener.onLmkdKillOccurred(pid.intValue(), uid.intValue());
    }

    void scheduleNoteLmkdProcKilled(int pid, int uid, int rssKb) {
        this.mKillHandler.obtainMessage(4101, pid, uid, Long.valueOf(rssKb)).sendToTarget();
    }

    private void scheduleChildProcDied(int pid, int uid, int status) {
        this.mKillHandler.obtainMessage(4102, pid, uid, Integer.valueOf(status)).sendToTarget();
    }

    void handleZygoteSigChld(int pid, int uid, int status) {
        if (ActivityManagerDebugConfig.DEBUG_PROCESSES == false) goto L5;
        Slog.i(TAG, "Got SIGCHLD from zygote: pid=" + pid + ", uid=" + uid + ", status=" + Integer.toHexString(status));
    L5:
        ActivityManagerService.PidMap r1 = this.mService.mPidsSelfLocked;
        monitor-enter(r1);
        ProcessRecord app = this.mService.mPidsSelfLocked.get(pid);     // Catch: Throwable -> L21
        monitor-exit(r1);     // Catch: Throwable -> L21
        ActivityManagerService r2 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r2);
        if (app != null) goto L26;
    L15:
        monitor-exit(r2);     // Catch: Throwable -> L13
        ActivityManagerService.resetPriorityAfterLockedSection();
        scheduleChildProcDied(pid, uid, status);
        return;
    L13:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    L26:
        app.sendSigChldTime = Process.getCpuClocks();     // Catch: Throwable -> L13
    L21:
        th = move-exception;
        throw th;
    }

    void handleNoteProcessDiedLocked(ApplicationExitInfo raw) {
        if (raw != null) goto L4;
        return;
    L4:
        if (ActivityManagerDebugConfig.DEBUG_PROCESSES == false) goto L6;
        Slog.i(TAG, "Update process exit info for " + raw.getPackageName() + "(" + raw.getPid() + "/u" + raw.getRealUid() + ")");
    L6:
        ApplicationExitInfo info = getExitInfoLocked(raw.getPackageName(), raw.getPackageUid(), raw.getPid());
        Pair<Long, Object> zygote = this.mAppExitInfoSourceZygote.remove(raw.getPid(), raw.getRealUid());
        Pair<Long, Object> lmkd = this.mAppExitInfoSourceLmkd.remove(raw.getPid(), raw.getRealUid());
        this.mIsolatedUidRecords.removeIsolatedUidLocked(raw.getRealUid());
        if (info != null) goto L10;
        info = addExitInfoLocked(raw);
    L10:
        if (lmkd == null) goto L12;
        updateExistingExitInfoRecordLocked(info, null, 3, (Long) lmkd.second);
        return;
    L12:
        if (zygote == null) goto L14;
        updateExistingExitInfoRecordLocked(info, (Integer) zygote.second, null, null);
        return;
    L14:
        scheduleLogToStatsdLocked(info, false);
    }

    private boolean preventExitInfoUpdate(ApplicationExitInfo exitInfo) {
        switch(exitInfo.getReason()) {
            case 4: goto L6;
            case 5: goto L6;
            case 6: goto L6;
            default: goto L4;
        };
    L4:
        return false;
    L6:
        return true;
    }

    void handleNoteAppKillLocked(ApplicationExitInfo raw) {
        ApplicationExitInfo info = getExitInfoLocked(raw.getPackageName(), raw.getPackageUid(), raw.getPid());
        if (info != null) goto L5;
    L8:
        info = addExitInfoLocked(raw);
    L9:
        scheduleLogToStatsdLocked(info, true);
        return;
    L5:
        if (preventExitInfoUpdate(info) == true) goto L8;
        info.setReason(raw.getReason());
        info.setSubReason(raw.getSubReason());
        info.setStatus(0);
        info.setTimestamp(System.currentTimeMillis());
        info.setDescription(raw.getDescription());
        goto L9
    }

    private ApplicationExitInfo addExitInfoLocked(ApplicationExitInfo raw) {
        if (this.mAppExitInfoLoaded.get() == true) goto L6;
        Slog.w(TAG, "Skipping saving the exit info due to ongoing loading from storage");
        return null;
    L6:
        ApplicationExitInfo info = new ApplicationExitInfo(raw);
        String[] packages = raw.getPackageList();
        int uid = raw.getRealUid();
        if (UserHandle.isIsolated(uid) == false) goto L11;
        Integer k = this.mIsolatedUidRecords.getUidByIsolatedUid(uid);
        if (k == null) goto L11;
        uid = k.intValue();
    L11:
        int i = 0;
    L13:
        if (i >= packages.length) goto L16;
        addExitInfoInnerLocked(packages[i], uid, info);
        i = i + 1;
        goto L13
    L16:
        if (Process.isSdkSandboxUid(uid) == false) goto L21;
        int i2 = 0;
    L19:
        if (i2 >= packages.length) goto L21;
        addExitInfoInnerLocked(packages[i2], raw.getPackageUid(), info);
        i2 = i2 + 1;
    L21:
        schedulePersistProcessExitInfo(false);
        return info;
    }

    private void updateExistingExitInfoRecordLocked(ApplicationExitInfo info, Integer status, Integer reason, Long rssKb) {
        if (info != null) goto L4;
        return;
    L4:
        if (isFresh(info.getTimestamp()) == false) goto L28;
        boolean immediateLog = false;
        if (status != null) goto L9;
    L19:
        if (reason == null) goto L23;
        info.setReason(reason.intValue());
        if (reason.intValue() != 3) goto L23;
        immediateLog = true;
    L23:
        if (rssKb == null) goto L25;
        info.setRss(rssKb.longValue());
    L25:
        scheduleLogToStatsdLocked(info, immediateLog);
        return;
    L9:
        if (OsConstants.WIFEXITED(status.intValue()) == false) goto L12;
        info.setReason(1);
        info.setStatus(OsConstants.WEXITSTATUS(status.intValue()));
        immediateLog = true;
        goto L19
    L12:
        if (OsConstants.WIFSIGNALED(status.intValue()) == false) goto L19;
        if (info.getReason() != 0) goto L17;
        info.setReason(2);
        info.setStatus(OsConstants.WTERMSIG(status.intValue()));
        goto L19
    L17:
        if (info.getReason() != 5) goto L19;
        info.setStatus(OsConstants.WTERMSIG(status.intValue()));
        immediateLog = true;
        goto L19
    }

    private boolean updateExitInfoIfNecessaryLocked(final int pid, int uid, final Integer status, final Integer reason, final Long rssKb) {
        Integer k = this.mIsolatedUidRecords.getUidByIsolatedUid(uid);
        if (k == null) goto L5;
        uid = k.intValue();
    L5:
        final int targetUid = uid;
        final boolean[] isModified = {false};
        forEachPackageLocked(new AppExitInfoTracker$$ExternalSyntheticLambda7(this, targetUid, pid, isModified, status, reason, rssKb));
        this.mTmpInfoList.clear();
        return isModified[0];
    }

    private /* synthetic */ Integer lambda$updateExitInfoIfNecessaryLocked$2(int targetUid, int pid, boolean[] isModified, Integer status, Integer reason, Long rssKb, String packageName, SparseArray records) {
        AppExitInfoContainer container = (AppExitInfoContainer) records.get(targetUid);
        if (container != null) goto L5;
        return 0;
    L5:
        this.mTmpInfoList.clear();
        container.getExitInfosLocked(pid, 0, this.mTmpInfoList);
        if (this.mTmpInfoList.size() != 0) goto L8;
        return 0;
    L8:
        int i = 0;
        int size = this.mTmpInfoList.size();
    L9:
        if (i >= size) goto L16;
        ApplicationExitInfo info = this.mTmpInfoList.get(i);
        if (info.getRealUid() == targetUid) goto L13;
        i = i + 1;
        goto L9
    L13:
        isModified[0] = true;
        updateExistingExitInfoRecordLocked(info, status, reason, rssKb);
        return 2;
    L16:
        return 0;
    }

    void getExitInfo(String packageName, final int filterUid, final int filterPid, int maxNum, final List<ApplicationExitInfo> results) {
        long identity = Binder.clearCallingIdentity();
        Object r2 = this.mLock;     // Catch: Throwable -> L29
        monitor-enter(r2);     // Catch: Throwable -> L29
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L6:
        if (TextUtils.isEmpty(packageName) == true) goto L15;
        AppExitInfoContainer container = (AppExitInfoContainer) this.mData.get(packageName, filterUid);     // Catch: Throwable -> L10
        if (container == null) goto L12;
        container.getExitInfosLocked(filterPid, maxNum, results);     // Catch: Throwable -> L10
    L12:
        monitor-exit(r2);     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(identity);
        return;
    L15:
        forEachPackageLocked(new AppExitInfoTracker$$ExternalSyntheticLambda16(filterUid, filterPid, results));     // Catch: Throwable -> L10
        Collections.sort(results, new AppExitInfoTracker$$ExternalSyntheticLambda17());     // Catch: Throwable -> L10
        if (maxNum > 0) goto L20;
        monitor-exit(r2);     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(identity);
        return;
    L20:
        int elementsToRemove = results.size() - maxNum;     // Catch: Throwable -> L10
        int i = 0;
    L21:
        if (i >= elementsToRemove) goto L24;
        results.removeLast();     // Catch: Throwable -> L10
        i = i + 1;     // Catch: Throwable -> L10
        goto L21
    L24:
        monitor-exit(r2);     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(identity);
        return;
    L29:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    private static /* synthetic */ Integer lambda$getExitInfo$3(int filterUid, int filterPid, List results, String name, SparseArray records) {
        AppExitInfoContainer container = (AppExitInfoContainer) records.get(filterUid);
        if (container == null) goto L6;
        container.getExitInfosLocked(filterPid, 0, results);
    L6:
        return 0;
    }

    private static /* synthetic */ int lambda$getExitInfo$4(ApplicationExitInfo a, ApplicationExitInfo b) {
        return Long.compare(b.getTimestamp(), a.getTimestamp());
    }

    private ApplicationExitInfo getExitInfoLocked(String packageName, int filterUid, int filterPid) {
        this.mTmpInfoList.clear();
        getExitInfo(packageName, filterUid, filterPid, 1, this.mTmpInfoList);
        if (this.mTmpInfoList.size() <= 0) goto L5;
        ApplicationExitInfo info = (ApplicationExitInfo) this.mTmpInfoList.getFirst();
    L6:
        this.mTmpInfoList.clear();
        return info;
    L5:
        info = null;
        goto L6
    }

    void onUserRemoved(int userId) {
        this.mAppExitInfoSourceZygote.removeByUserId(userId);
        this.mAppExitInfoSourceLmkd.removeByUserId(userId);
        this.mIsolatedUidRecords.removeByUserId(userId);
        Object r0 = this.mLock;
        monitor-enter(r0);
        removeByUserIdLocked(userId);     // Catch: Throwable -> L7
        schedulePersistProcessExitInfo(true);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void onPackageRemoved(String packageName, int uid, boolean allUsers) {
        if (packageName == null) goto L18;
        boolean removeUid = TextUtils.isEmpty(this.mService.mPackageManagerInt.getNameForUid(uid));
        Object r1 = this.mLock;
        monitor-enter(r1);
        if (removeUid == true) goto L19;
    L10:
        if (allUsers == false) goto L12;
        int r2 = -1;
    L13:
        removePackageLocked(packageName, uid, removeUid, r2);     // Catch: Throwable -> L7
        schedulePersistProcessExitInfo(true);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    L12:
        r2 = UserHandle.getUserId(uid);     // Catch: Throwable -> L7
        goto L13
    L19:
        this.mAppExitInfoSourceZygote.removeByUidLocked(uid, allUsers);     // Catch: Throwable -> L7
        this.mAppExitInfoSourceLmkd.removeByUidLocked(uid, allUsers);     // Catch: Throwable -> L7
        this.mIsolatedUidRecords.removeAppUid(uid, allUsers);     // Catch: Throwable -> L7
        goto L10
    }

    private void registerForUserRemoval() {
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.USER_REMOVED");
        this.mService.mContext.registerReceiverForAllUsers(new AnonymousClass1(this), filter, null, this.mKillHandler);
    }

    private void registerForPackageRemoval() {
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.PACKAGE_REMOVED");
        filter.addDataScheme(Settings.ATTR_PACKAGE);
        this.mService.mContext.registerReceiverForAllUsers(new AnonymousClass2(this), filter, null, this.mKillHandler);
    }

    void loadExistingProcessExitInfo() {
        if (this.mProcExitInfoFile.canRead() == true) goto L6;
        this.mAppExitInfoLoaded.set(true);
        return;
    L6:
        FileInputStream fin = null;
        AtomicFile af = new AtomicFile(this.mProcExitInfoFile);     // Catch: Throwable -> L13 Exception -> L15
        fin = af.openRead();     // Catch: Throwable -> L13 Exception -> L15
        ProtoInputStream proto = new ProtoInputStream(fin);     // Catch: Throwable -> L13 Exception -> L15
        int next = proto.nextField();     // Catch: Throwable -> L13 Exception -> L15
    L9:
        if (next == (-1)) goto L28;
        switch(next) {
            case 1: goto L17;
            case 2: goto L12;
            default: goto L23;
        };     // Catch: Throwable -> L13 Exception -> L15
    L12:
        loadPackagesFromProto(proto, next);     // Catch: Throwable -> L13 Exception -> L15
        goto L23
    L17:
        Object r5 = this.mLock;     // Catch: Throwable -> L13 Exception -> L15
        monitor-enter(r5);     // Catch: Throwable -> L13 Exception -> L15
        this.mLastAppExitInfoPersistTimestamp = proto.readLong(1112396529665L);     // Catch: Throwable -> L24
        monitor-exit(r5);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13 Exception -> L15
    L23:
        next = proto.nextField();     // Catch: Throwable -> L13 Exception -> L15
        goto L9
    L28:
        if (fin == null) goto L41;
        fin.close();     // Catch: IOException -> L31
    L41:
        Object r3 = this.mLock;
        monitor-enter(r3);
        pruneAnrTracesIfNecessaryLocked();     // Catch: Throwable -> L46
        this.mAppExitInfoLoaded.set(true);     // Catch: Throwable -> L46
        monitor-exit(r3);     // Catch: Throwable -> L46
        return;
    L46:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        if (fin != null) goto L61;
    L53:
        throw th;
    L61:
        fin.close();     // Catch: IOException -> L52
    L15:
        e = move-exception;
        Slog.w(TAG, "Error in loading historical app exit info from persistent storage: " + e);     // Catch: Throwable -> L13
        if (fin == null) goto L41;
        fin.close();     // Catch: IOException -> L39
        goto L41
    }

    private void loadPackagesFromProto(ProtoInputStream proto, long fieldId) throws IOException, WireTypeMismatchException {
        long token = proto.start(fieldId);
        String pkgName = "";
        int next = proto.nextField();
    L4:
        if (next == (-1)) goto L17;
        switch(next) {
            case 1: goto L15;
            case 2: goto L7;
            default: goto L16;
        };
    L7:
        AppExitInfoContainer container = new AppExitInfoContainer(this, this.mAppExitInfoHistoryListSize);
        int uid = container.readFromProto(proto, 2246267895810L);
        Object r6 = this.mLock;
        monitor-enter(r6);
        this.mData.put(pkgName, uid, container);     // Catch: Throwable -> L12
        monitor-exit(r6);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L15:
        pkgName = proto.readString(1138166333441L);
    L16:
        next = proto.nextField();
        goto L4
    L17:
        proto.end(token);
    }

    void persistProcessExitInfo() {
        AtomicFile af = new AtomicFile(this.mProcExitInfoFile);
        FileOutputStream out = null;
        long now = System.currentTimeMillis();
        out = af.startWrite();     // Catch: IOException -> L9
        final ProtoOutputStream proto = new ProtoOutputStream(out);     // Catch: IOException -> L9
        proto.write(1112396529665L, now);     // Catch: IOException -> L9
        Object r5 = this.mLock;     // Catch: IOException -> L9
        monitor-enter(r5);     // Catch: IOException -> L9
        forEachPackageLocked(new AppExitInfoTracker$$ExternalSyntheticLambda11(proto));     // Catch: Throwable -> L11
        this.mLastAppExitInfoPersistTimestamp = now;     // Catch: Throwable -> L11
        monitor-exit(r5);     // Catch: Throwable -> L11
        proto.flush();     // Catch: IOException -> L9
        af.finishWrite(out);     // Catch: IOException -> L9
    L15:
        Object r4 = this.mLock;
        monitor-enter(r4);
        this.mAppExitInfoPersistTask = null;     // Catch: Throwable -> L21
        monitor-exit(r4);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        throw th;
    L11:
        th = move-exception;
        throw th;     // Catch: IOException -> L9
    L9:
        e = move-exception;
        Slog.w(TAG, "Unable to write historical app exit info into persistent storage: " + e);
        af.failWrite(out);
        goto L15
    }

    private static /* synthetic */ Integer lambda$persistProcessExitInfo$5(ProtoOutputStream proto, String packageName, SparseArray records) {
        long token = proto.start(2246267895810L);
        proto.write(1138166333441L, packageName);
        int uidArraySize = records.size();
        int j = 0;
    L3:
        if (j >= uidArraySize) goto L5;
        ((AppExitInfoContainer) records.valueAt(j)).writeToProto(proto, 2246267895810L);
        j = j + 1;
        goto L3
    L5:
        proto.end(token);
        return 0;
    }

    void schedulePersistProcessExitInfo(boolean immediately) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mAppExitInfoPersistTask == null) goto L8;
        if (immediately == true) goto L8;
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L8:
        if (this.mAppExitInfoPersistTask == null) goto L12;
        IoThread.getHandler().removeCallbacks(this.mAppExitInfoPersistTask);     // Catch: Throwable -> L10
    L12:
        this.mAppExitInfoPersistTask = new AppExitInfoTracker$$ExternalSyntheticLambda2(this);     // Catch: Throwable -> L10
        Handler r1 = IoThread.getHandler();     // Catch: Throwable -> L10
        Runnable r2 = this.mAppExitInfoPersistTask;     // Catch: Throwable -> L10
        if (immediately == false) goto L15;
        long r3 = 0;
    L16:
        r1.postDelayed(r2, r3);     // Catch: Throwable -> L10
        goto L17
    L15:
        r3 = APP_EXIT_INFO_PERSIST_INTERVAL;     // Catch: Throwable -> L10
        goto L16
    }

    void clearProcessExitInfo(boolean removeFile) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mAppExitInfoPersistTask == null) goto L9;
        IoThread.getHandler().removeCallbacks(this.mAppExitInfoPersistTask);     // Catch: Throwable -> L7
        this.mAppExitInfoPersistTask = null;     // Catch: Throwable -> L7
    L9:
        if (removeFile == true) goto L11;
    L13:
        this.mData.getMap().clear();     // Catch: Throwable -> L7
        this.mActiveAppStateSummary.clear();     // Catch: Throwable -> L7
        this.mActiveAppTraces.clear();     // Catch: Throwable -> L7
        pruneAnrTracesIfNecessaryLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L11:
        if (this.mProcExitInfoFile == null) goto L13;
        this.mProcExitInfoFile.delete();     // Catch: Throwable -> L7
        goto L13
    }

    void clearHistoryProcessExitInfo(String packageName, int userId) {
        NativeTombstoneManager tombstoneService = (NativeTombstoneManager) LocalServices.getService(NativeTombstoneManager.class);
        Optional<Integer> appId = Optional.empty();
        if (TextUtils.isEmpty(packageName) == false) goto L12;
        Object r2 = this.mLock;
        monitor-enter(r2);
        removeByUserIdLocked(userId);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
    L16:
        tombstoneService.purge(Optional.of(Integer.valueOf(userId)), appId);
        schedulePersistProcessExitInfo(true);
        return;
    L9:
        th = move-exception;
        throw th;
    L12:
        int uid = this.mService.mPackageManagerInt.getPackageUid(packageName, 131072, userId);
        appId = Optional.of(Integer.valueOf(UserHandle.getAppId(uid)));
        Object r4 = this.mLock;
        monitor-enter(r4);
        removePackageLocked(packageName, uid, true, userId);     // Catch: Throwable -> L18
        monitor-exit(r4);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    void dumpHistoryProcessExitInfo(final PrintWriter pw, String packageName) {
        pw.println("ACTIVITY MANAGER PROCESS EXIT INFO (dumpsys activity exit-info)");
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Object r1 = this.mLock;
        monitor-enter(r1);
        pw.println("Last Timestamp of Persistence Into Persistent Storage: " + sdf.format(new Date(this.mLastAppExitInfoPersistTimestamp)));     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(packageName) == true) goto L24;
        SparseArray<AppExitInfoContainer> array = (SparseArray) this.mData.getMap().get(packageName);     // Catch: Throwable -> L17
        if (array == null) goto L20;
        dumpHistoryProcessExitInfoLocked(pw, "  ", packageName, array, sdf);     // Catch: Throwable -> L15
    L20:
        monitor-exit(r1);     // Catch: Throwable -> L15
        return;
    L24:
        forEachPackageLocked(new AppExitInfoTracker$$ExternalSyntheticLambda15(this, pw, sdf));     // Catch: Throwable -> L8
    L8:
        th = th;
    L22:
        monitor-exit(r1);     // Catch: Throwable -> L15
        throw th;
    L15:
        th = th;
    L17:
        th = th;
        goto L22
    }

    private /* synthetic */ Integer lambda$dumpHistoryProcessExitInfo$6(PrintWriter pw, SimpleDateFormat sdf, String name, SparseArray records) {
        dumpHistoryProcessExitInfoLocked(pw, "  ", name, records, sdf);
        return 0;
    }

    private void dumpHistoryProcessExitInfoLocked(PrintWriter pw, String prefix, String packageName, SparseArray<AppExitInfoContainer> array, SimpleDateFormat sdf) {
        pw.println(prefix + "package: " + packageName);
        int size = array.size();
        int i = 0;
    L3:
        if (i >= size) goto L6;
        pw.println(prefix + "  Historical Process Exit for uid=" + array.keyAt(i));
        array.valueAt(i).dumpLocked(pw, prefix + "    ", sdf);
        i = i + 1;
        goto L3
    }

    private void addExitInfoInnerLocked(String packageName, int uid, ApplicationExitInfo info) {
        AppExitInfoContainer container = (AppExitInfoContainer) this.mData.get(packageName, uid);
        if (container != null) goto L12;
        container = new AppExitInfoContainer(this, this.mAppExitInfoHistoryListSize);
        if (UserHandle.isIsolated(info.getRealUid()) == false) goto L10;
        Integer k = this.mIsolatedUidRecords.getUidByIsolatedUid(info.getRealUid());
        if (k == null) goto L11;
        AppExitInfoContainer.m1298$$Nest$fputmUid(container, k.intValue());
    L11:
        this.mData.put(packageName, uid, container);
        goto L12
    L10:
        AppExitInfoContainer.m1298$$Nest$fputmUid(container, info.getRealUid());
    L12:
        container.addExitInfoLocked(info);
    }

    private void scheduleLogToStatsdLocked(ApplicationExitInfo info, boolean immediate) {
        if (info.isLoggedInStatsd() == false) goto L6;
        return;
    L6:
        if (immediate == false) goto L9;
        this.mKillHandler.removeMessages(4105, info);
        performLogToStatsdLocked(info);
        return;
    L9:
        if (this.mKillHandler.hasMessages(4105, info) == true) goto L13;
        this.mKillHandler.sendMessageDelayed(this.mKillHandler.obtainMessage(4105, info), APP_EXIT_INFO_STATSD_LOG_DEBOUNCE);
        return;
    }

    private void performLogToStatsdLocked(ApplicationExitInfo info) {
        if (info.isLoggedInStatsd() == false) goto L5;
        return;
    L5:
        info.setLoggedInStatsd(true);
        String pkgName = info.getPackageName();
        String processName = info.getProcessName();
        if (TextUtils.equals(pkgName, processName) == false) goto L8;
        String processName2 = null;
    L14:
        FrameworkStatsLog.write(FrameworkStatsLog.APP_PROCESS_DIED, info.getPackageUid(), processName2, info.getReason(), info.getSubReason(), info.getImportance(), (int) info.getPss(), (int) info.getRss(), info.hasForegroundServices());
        return;
    L8:
        if (processName == null) goto L13;
        if (pkgName == null) goto L13;
        if (processName.startsWith(pkgName) == false) goto L13;
        processName2 = processName.substring(pkgName.length());
    L13:
        processName2 = processName;
        goto L14
    }

    private void forEachPackageLocked(BiFunction<String, SparseArray<AppExitInfoContainer>, Integer> callback) {
        if (callback == null) goto L14;
        ArrayMap<String, SparseArray<AppExitInfoContainer>> map = this.mData.getMap();
        int i = map.size() - 1;
    L4:
        if (i < 0) goto L20;
        switch(callback.apply(map.keyAt(i), map.valueAt(i)).intValue()) {
            case 1: goto L9;
            case 2: goto L8;
            default: goto L13;
        };
    L8:
        i = 0;
        goto L13
    L9:
        SparseArray<AppExitInfoContainer> records = map.valueAt(i);
        int j = records.size() - 1;
    L10:
        if (j < 0) goto L12;
        records.valueAt(j).destroyLocked();
        j = j - 1;
        goto L10
    L12:
        map.removeAt(i);
    L13:
        i = i - 1;
        goto L4
    L20:
        return;
    }

    private void removePackageLocked(String packageName, int uid, boolean removeUid, int userId) {
        if (removeUid == false) goto L9;
        this.mActiveAppStateSummary.remove(uid);
        int idx = this.mActiveAppTraces.indexOfKey(uid);
        if (idx < 0) goto L9;
        SparseArray<File> array = this.mActiveAppTraces.valueAt(idx);
        int i = array.size() - 1;
    L6:
        if (i < 0) goto L8;
        array.valueAt(i).delete();
        i = i - 1;
        goto L6
    L8:
        this.mActiveAppTraces.removeAt(idx);
    L9:
        ArrayMap<String, SparseArray<AppExitInfoContainer>> map = this.mData.getMap();
        SparseArray<AppExitInfoContainer> array2 = map.get(packageName);
        if (array2 != null) goto L13;
        return;
    L13:
        if (userId != (-1)) goto L18;
        int i2 = array2.size() - 1;
    L15:
        if (i2 < 0) goto L17;
        array2.valueAt(i2).destroyLocked();
        i2 = i2 - 1;
        goto L15
    L17:
        this.mData.getMap().remove(packageName);
        return;
    L18:
        int i3 = array2.size() - 1;
    L19:
        if (i3 < 0) goto L24;
        if (UserHandle.getUserId(array2.keyAt(i3)) == userId) goto L22;
        i3 = i3 - 1;
        goto L19
    L22:
        array2.valueAt(i3).destroyLocked();
        array2.removeAt(i3);
    L24:
        int i4 = array2.size();
        if (i4 != 0) goto L33;
        map.remove(packageName);
        return;
    }

    private void removeByUserIdLocked(final int userId) {
        if (userId != (-1)) goto L6;
        this.mData.getMap().clear();
        this.mActiveAppStateSummary.clear();
        this.mActiveAppTraces.clear();
        pruneAnrTracesIfNecessaryLocked();
        return;
    L6:
        removeFromSparse2dArray(this.mActiveAppStateSummary, new AppExitInfoTracker$$ExternalSyntheticLambda3(userId), null, null);
        removeFromSparse2dArray(this.mActiveAppTraces, new AppExitInfoTracker$$ExternalSyntheticLambda4(userId), null, new AppExitInfoTracker$$ExternalSyntheticLambda5());
        forEachPackageLocked(new AppExitInfoTracker$$ExternalSyntheticLambda6(userId));
    }

    private static /* synthetic */ boolean lambda$removeByUserIdLocked$7(int userId, Integer v) {
        if (UserHandle.getUserId(v.intValue()) != userId) goto L5;
        return true;
    L5:
        return false;
    }

    private static /* synthetic */ boolean lambda$removeByUserIdLocked$8(int userId, Integer v) {
        if (UserHandle.getUserId(v.intValue()) != userId) goto L5;
        return true;
    L5:
        return false;
    }

    private static /* synthetic */ void lambda$removeByUserIdLocked$9(File v) {
        v.delete();
    }

    private static /* synthetic */ Integer lambda$removeByUserIdLocked$10(int userId, String packageName, SparseArray records) {
        int r1 = 1;
        int i = records.size() - 1;
    L3:
        if (i < 0) goto L8;
        if (UserHandle.getUserId(records.keyAt(i)) == userId) goto L6;
        i = i - 1;
        goto L3
    L6:
        ((AppExitInfoContainer) records.valueAt(i)).destroyLocked();
        records.removeAt(i);
    L8:
        int i2 = records.size();
        if (i2 == 0) goto L13;
        r1 = 0;
    L13:
        return Integer.valueOf(r1);
    }

    ApplicationExitInfo obtainRawRecord(ProcessRecord app, long timestamp) {
        ApplicationExitInfo info = (ApplicationExitInfo) this.mRawRecordsPool.acquire();
        if (info != null) goto L5;
        info = new ApplicationExitInfo();
    L5:
        ActivityManagerGlobalLock r1 = this.mService.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r1);
    L10:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    L8:
        if (app.getHostingRecord() == null) goto L12;
        int definingUid = app.getHostingRecord().getDefiningUid();     // Catch: Throwable -> L10
    L13:
        info.setPid(app.getPid());     // Catch: Throwable -> L10
        info.setRealUid(app.uid);     // Catch: Throwable -> L10
        info.setPackageUid(app.info.uid);     // Catch: Throwable -> L10
        if (definingUid <= 0) goto L16;
        int r4 = definingUid;
    L17:
        info.setDefiningUid(r4);     // Catch: Throwable -> L10
        info.setProcessName(app.processName);     // Catch: Throwable -> L10
        info.setConnectionGroup(app.mServices.getConnectionGroup());     // Catch: Throwable -> L10
        info.setPackageName(app.info.packageName);     // Catch: Throwable -> L10
        info.setPackageList(app.getPackageList());     // Catch: Throwable -> L10
        info.setReason(0);     // Catch: Throwable -> L10
        info.setSubReason(0);     // Catch: Throwable -> L10
        info.setStatus(0);     // Catch: Throwable -> L10
        info.setImportance(ActivityManager.RunningAppProcessInfo.procStateToImportance(app.mState.getReportedProcState()));     // Catch: Throwable -> L10
        info.setPss(app.mProfile.getLastPss());     // Catch: Throwable -> L10
        info.setRss(app.mProfile.getLastRss());     // Catch: Throwable -> L10
        info.setTimestamp(timestamp);     // Catch: Throwable -> L10
        info.setHasForegroundServices(app.mServices.hasReportedForegroundServices());     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        return info;
    L16:
        r4 = app.info.uid;     // Catch: Throwable -> L10
        goto L17
    L12:
        definingUid = 0;
        goto L13
    }

    void recycleRawRecord(ApplicationExitInfo info) {
        info.setProcessName(null);
        info.setDescription(null);
        info.setPackageList(null);
        this.mRawRecordsPool.release(info);
    }

    void setProcessStateSummary(int uid, int pid, byte[] data) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        Integer k = this.mIsolatedUidRecords.getUidByIsolatedUid(uid);     // Catch: Throwable -> L20
        if (k != null) goto L26;
        int uid2 = uid;
    L32:
        putToSparse2dArray(this.mActiveAppStateSummary, uid2, pid, data, new AppExitInfoTracker$$ExternalSyntheticLambda8(), null);     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L16
        return;
    L16:
        th = th;
    L28:
        monitor-exit(r1);     // Catch: Throwable -> L24
        throw th;
    L24:
        th = th;
    L18:
        th = th;
        goto L28
    L26:
        uid2 = k.intValue();     // Catch: Throwable -> L8
    L8:
        th = th;
    L20:
        th = th;
        goto L28
    }

    byte[] getProcessStateSummary(int uid, int pid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Integer k = this.mIsolatedUidRecords.getUidByIsolatedUid(uid);     // Catch: Throwable -> L7
        if (k == null) goto L9;
        uid = k.intValue();     // Catch: Throwable -> L7
    L9:
        int index = this.mActiveAppStateSummary.indexOfKey(uid);     // Catch: Throwable -> L7
        if (index >= 0) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L7
        return null;
    L14:
        byte[] r3 = this.mActiveAppStateSummary.valueAt(index).get(pid);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    void scheduleLogAnrTrace(int pid, int uid, String[] packageList, File traceFile, long startOff, long endOff) {
        this.mKillHandler.sendMessage(PooledLambda.obtainMessage(new AppExitInfoTracker$$ExternalSyntheticLambda10(this), Integer.valueOf(pid), Integer.valueOf(uid), packageList, traceFile, Long.valueOf(startOff), Long.valueOf(endOff)));
    }

    void handleLogAnrTrace(int pid, int uid, String[] packageList, File traceFile, long startOff, long endOff) {
        if (traceFile.exists() == false) goto L60;
        if (ArrayUtils.isEmpty(packageList) == true) goto L73;
        long size = traceFile.length();
        long length = endOff - startOff;
        if (startOff >= size) goto L58;
        if (endOff > size) goto L58;
        if (length <= 0) goto L72;
        File outFile = new File(this.mProcExitStoreDir, traceFile.getName() + ".gz");
        if (copyToGzFile(traceFile, outFile, startOff, length) == false) goto L56;
        Object r11 = this.mLock;
        monitor-enter(r11);
        int r2 = uid;
        Integer k = this.mIsolatedUidRecords.getUidByIsolatedUid(r2);     // Catch: Throwable -> L24
        if (k == null) goto L26;
        int uid2 = k.intValue();     // Catch: Throwable -> L24
    L28:
        if (ActivityManagerDebugConfig.DEBUG_PROCESSES == false) goto L32;
        Slog.i(TAG, "Stored ANR traces of " + pid + "/u" + uid2 + " in " + outFile);     // Catch: Throwable -> L30
    L32:
        int i = 0;
        boolean pending = true;
    L34:
        if (i >= packageList.length) goto L42;
        AppExitInfoContainer container = (AppExitInfoContainer) this.mData.get(packageList[i], uid2);     // Catch: Throwable -> L30
        if (container == null) goto L40;
        if (container.appendTraceIfNecessaryLocked(pid, outFile) == false) goto L40;
        pending = false;
    L40:
        i = i + 1;     // Catch: Throwable -> L30
        goto L34
    L42:
        if (pending == true) goto L64;
    L49:
        monitor-exit(r11);     // Catch: Throwable -> L30
        return;
    L64:
        putToSparse2dArray(this.mActiveAppTraces, uid2, pid, outFile, new AppExitInfoTracker$$ExternalSyntheticLambda8(), new AppExitInfoTracker$$ExternalSyntheticLambda18());     // Catch: Throwable -> L47
    L47:
        th = th;
    L53:
        monitor-exit(r11);     // Catch: Throwable -> L30
        throw th;
    L26:
        uid2 = r2;
    L24:
        th = th;
    L30:
        th = th;
    L51:
        th = th;
        r2 = uid;
        goto L53
    L56:
        return;
    L72:
        return;
    L58:
        return;
    L73:
        return;
    }

    private static /* synthetic */ void lambda$handleLogAnrTrace$11(File v) {
        v.delete();
    }

    private static boolean copyToGzFile(File inFile, File outFile, long start, long length) {
        long remaining = length;
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(inFile));     // Catch: IOException -> L24
        GZIPOutputStream out = new GZIPOutputStream(new BufferedOutputStream(new FileOutputStream(outFile)));     // Catch: Throwable -> L26
        byte[] buffer = new byte[8192];     // Catch: Throwable -> L14
        in.skip(start);     // Catch: Throwable -> L14
    L8:
        if (remaining <= 0) goto L16;
        int t = in.read(buffer, 0, (int) Math.min(buffer.length, remaining));     // Catch: Throwable -> L14
        if (t < 0) goto L16;
        out.write(buffer, 0, t);     // Catch: Throwable -> L14
        remaining = remaining - ((long) t);
        goto L8
    L16:
        out.close();     // Catch: Throwable -> L26
        in.close();     // Catch: IOException -> L24
        if (remaining == 0) goto L21;
        return false;
    L21:
        if (outFile.exists() == false) goto L53;
        return true;
    L53:
        return false;
    L14:
        th = move-exception;
        out.close();     // Catch: Throwable -> L30
    L32:
        throw th;     // Catch: Throwable -> L26
    L30:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        in.close();     // Catch: Throwable -> L35
    L37:
        throw th;     // Catch: IOException -> L24
    L35:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L24
    L24:
        e = move-exception;
        if (ActivityManagerDebugConfig.DEBUG_PROCESSES == false) goto L41;
        Slog.e(TAG, "Error in copying ANR trace from " + inFile + " to " + outFile, e);
    L41:
        return false;
    }

    private void pruneAnrTracesIfNecessaryLocked() {
        final ArraySet<String> allFiles = new ArraySet();
        File[] files = this.mProcExitStoreDir.listFiles(new AppExitInfoTracker$$ExternalSyntheticLambda12(allFiles));
        if (ArrayUtils.isEmpty(files) == false) goto L5;
        return;
    L5:
        forEachPackageLocked(new AppExitInfoTracker$$ExternalSyntheticLambda13(allFiles));
        forEachSparse2dArray(this.mActiveAppTraces, new AppExitInfoTracker$$ExternalSyntheticLambda14(allFiles));
        int i = allFiles.size() - 1;
    L6:
        if (i < 0) goto L9;
        new File(this.mProcExitStoreDir, allFiles.valueAt(i)).delete();
        i = i - 1;
        goto L6
    }

    private static /* synthetic */ boolean lambda$pruneAnrTracesIfNecessaryLocked$12(ArraySet allFiles, File f) {
        String name = f.getName();
        if (name.startsWith("anr_") == true) goto L5;
    L7:
        boolean trace = false;
    L9:
        if (trace == false) goto L11;
        allFiles.add(name);
    L11:
        return trace;
    L5:
        if (name.endsWith(".gz") == false) goto L7;
        trace = true;
        goto L9
    }

    private static /* synthetic */ Integer lambda$pruneAnrTracesIfNecessaryLocked$14(final ArraySet allFiles, String name, SparseArray records) {
        int i = records.size() - 1;
    L3:
        if (i < 0) goto L6;
        AppExitInfoContainer container = (AppExitInfoContainer) records.valueAt(i);
        container.forEachRecordLocked(new AppExitInfoTracker$$ExternalSyntheticLambda9(allFiles));
        i = i - 1;
        goto L3
    L6:
        return 0;
    }

    private static /* synthetic */ Integer lambda$pruneAnrTracesIfNecessaryLocked$13(ArraySet allFiles, ApplicationExitInfo info) {
        File traceFile = info.getTraceFile();
        if (traceFile == null) goto L6;
        allFiles.remove(traceFile.getName());
    L6:
        return 0;
    }

    private static /* synthetic */ void lambda$pruneAnrTracesIfNecessaryLocked$15(ArraySet allFiles, File v) {
        allFiles.remove(v.getName());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T extends SparseArray<U>, U> void putToSparse2dArray(SparseArray<T> array, int outerKey, int innerKey, U value, Supplier<T> newInstance, Consumer<U> r8) {
        int idx = array.indexOfKey(outerKey);
        if (idx >= 0) goto L5;
        T innerArray = newInstance.get();
        T innerArray2 = innerArray;
        array.put(outerKey, innerArray2);
    L6:
        int idx2 = innerArray2.indexOfKey(innerKey);
        if (idx2 < 0) goto L11;
        if (r8 == 0) goto L10;
        r8.accept(innerArray2.valueAt(idx2));
    L10:
        innerArray2.setValueAt(idx2, value);
        return;
    L11:
        innerArray2.put(innerKey, value);
        return;
    L5:
        T innerArray3 = array.valueAt(idx);
        innerArray2 = innerArray3;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T extends SparseArray<U>, U> void forEachSparse2dArray(SparseArray<T> array, Consumer<U> r5) {
        if (r5 == 0) goto L12;
        int i = array.size() - 1;
    L4:
        if (i < 0) goto L16;
        T innerArray = array.valueAt(i);
        if (innerArray == null) goto L11;
        int j = innerArray.size() - 1;
    L9:
        if (j < 0) goto L11;
        r5.accept(innerArray.valueAt(j));
        j = j - 1;
    L11:
        i = i - 1;
        goto L4
    L16:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T extends SparseArray<U>, U> void removeFromSparse2dArray(SparseArray<T> array, Predicate<Integer> outerPredicate, Predicate<Integer> innerPredicate, Consumer<U> r7) {
        int i = array.size() - 1;
    L3:
        if (i < 0) goto L24;
        if (outerPredicate != null) goto L6;
    L7:
        T innerArray = array.valueAt(i);
        if (innerArray == null) goto L22;
        int j = innerArray.size() - 1;
    L11:
        if (j < 0) goto L19;
        if (innerPredicate != null) goto L14;
    L15:
        if (r7 == 0) goto L17;
        r7.accept(innerArray.valueAt(j));
    L17:
        innerArray.removeAt(j);
    L18:
        j = j - 1;
        goto L11
    L14:
        if (innerPredicate.test(Integer.valueOf(innerArray.keyAt(j))) == false) goto L18;
    L19:
        int j2 = innerArray.size();
        if (j2 != 0) goto L22;
        array.removeAt(i);
    L22:
        i = i - 1;
        goto L3
    L6:
        if (outerPredicate.test(Integer.valueOf(array.keyAt(i))) == false) goto L22;
    }

    private static <T extends SparseArray<U>, U> U findAndRemoveFromSparse2dArray(SparseArray<T> r5, int r6, int r7) {
        int r0 = r5.indexOfKey(r6);
        if (r0 < 0) goto L13;
        T r2 = r5.valueAt(r0);
        if (r2 != null) goto L7;
        return null;
    L7:
        int r3 = r2.indexOfKey(r7);
        if (r3 < 0) goto L13;
        U r1 = (U) r2.valueAt(r3);
        r2.removeAt(r3);
        if (r2.size() != 0) goto L12;
        r5.removeAt(r0);
    L12:
        return r1;
    L13:
        return null;
    }

    boolean isFresh(long timestamp) {
        long now = System.currentTimeMillis();
        if ((300000 + timestamp) < now) goto L5;
        return true;
    L5:
        return false;
    }
}
