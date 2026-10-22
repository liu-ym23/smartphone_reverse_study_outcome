package com.android.server.content;

import android.accounts.Account;
import android.accounts.AccountManagerInternal;
import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.AppGlobals;
import android.app.AppOpsManager;
import android.app.compat.CompatChanges;
import android.app.job.JobInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IContentService;
import android.content.ISyncStatusObserver;
import android.content.IntentFilter;
import android.content.PeriodicSync;
import android.content.SyncAdapterType;
import android.content.SyncInfo;
import android.content.SyncRequest;
import android.content.SyncStatusInfo;
import android.content.pm.ProviderInfo;
import android.database.IContentObserver;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.FactoryTest;
import android.os.FrozenObjectException;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ShellCallback;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Log;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.android.internal.os.BackgroundThread;
import com.android.internal.os.BinderDeathDispatcher;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.IndentingPrintWriter;
import com.android.server.LocalServices;
import com.android.server.SystemService;
import com.android.server.pm.Settings;
import com.android.server.pm.permission.LegacyPermissionManagerInternal;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.wm.ActivityTaskManagerInternal;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class ContentService extends IContentService.Stub {
    public static final long ACCOUNT_ACCESS_CHECK_CHANGE_ID = 201794303;
    public static final long AUTHORITY_ACCESS_CHECK_CHANGE_ID = 207133734;
    private static final long BACKGROUND_OBSERVER_DELAY = 10000;
    static final boolean DEBUG = false;
    static final String TAG = "ContentService";
    private static final int TOO_MANY_OBSERVERS_THRESHOLD = 1000;
    private static final BinderDeathDispatcher<IContentObserver> sObserverDeathDispatcher = null;
    private static final ArraySet<Integer> sObserverLeakDetectedUid = null;
    private final AccountManagerInternal mAccountManagerInternal;
    private final SparseArray<ArrayMap<String, ArrayMap<Pair<String, Uri>, Bundle>>> mCache;
    private BroadcastReceiver mCacheReceiver;
    private Context mContext;
    private boolean mFactoryTest;
    private final ObserverNode mRootNode;
    private SyncManager mSyncManager;
    private final Object mSyncManagerLock;

    public static class Lifecycle extends SystemService {
        private ContentService mService;

        public Lifecycle(Context context) {
            super(context);
        }

        @Override // com.android.server.SystemService
        public void onStart() {
            boolean factoryTest = true;
            if (FactoryTest.getMode() == 1) goto L6;
            factoryTest = false;
        L6:
            this.mService = new ContentService(getContext(), factoryTest);
            publishBinderService(ActivityTaskManagerInternal.ASSIST_KEY_CONTENT, this.mService);
        }

        @Override // com.android.server.SystemService
        public void onBootPhase(int phase) {
            this.mService.onBootPhase(phase);
        }

        @Override // com.android.server.SystemService
        public void onUserStarting(SystemService.TargetUser user) {
            this.mService.onStartUser(user.getUserIdentifier());
        }

        @Override // com.android.server.SystemService
        public void onUserUnlocking(SystemService.TargetUser user) {
            this.mService.onUnlockUser(user.getUserIdentifier());
        }

        @Override // com.android.server.SystemService
        public void onUserStopping(SystemService.TargetUser user) {
            this.mService.onStopUser(user.getUserIdentifier());
        }

        @Override // com.android.server.SystemService
        public void onUserStopped(SystemService.TargetUser user) {
            SparseArray r0 = ContentService.m3140$$Nest$fgetmCache(this.mService);
            monitor-enter(r0);
            ContentService.m3140$$Nest$fgetmCache(this.mService).remove(user.getUserIdentifier());     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public static class ObserverCollector {
        private final ArrayMap<Key, List<Uri>> collected;

        private static class Key {
            final int flags;
            final IContentObserver observer;
            final boolean selfChange;
            final int uid;
            final int userId;

            Key(IContentObserver observer, int uid, boolean selfChange, int flags, int userId) {
                this.observer = observer;
                this.uid = uid;
                this.selfChange = selfChange;
                this.flags = flags;
                this.userId = userId;
            }

            public boolean equals(Object o) {
                if ((o instanceof Key) == true) goto L5;
                return false;
            L5:
                Key other = (Key) o;
                if (Objects.equals(this.observer, other.observer) == true) goto L8;
                return false;
            L8:
                if (this.uid == other.uid) goto L10;
                return false;
            L10:
                if (this.selfChange == other.selfChange) goto L12;
                return false;
            L12:
                if (this.flags == other.flags) goto L14;
                return false;
            L14:
                if (this.userId != other.userId) goto L21;
                return true;
            L21:
                return false;
            }

            public int hashCode() {
                return Objects.hash(new Object[]{this.observer, Integer.valueOf(this.uid), Boolean.valueOf(this.selfChange), Integer.valueOf(this.flags), Integer.valueOf(this.userId)});
            }
        }

        public static /* synthetic */ void $r8$lambda$Enmwrm6HznBNY378PKC1kmqC6_o(Key r0, List r1) {
            lambda$dispatch$0(r0, r1);
        }

        public ObserverCollector() {
            this.collected = new ArrayMap();
        }

        public void collect(IContentObserver observer, int uid, boolean selfChange, Uri uri, int flags, int userId) {
            Key key = new Key(observer, uid, selfChange, flags, userId);
            List<Uri> value = this.collected.get(key);
            if (value != null) goto L5;
            value = new ArrayList();
            this.collected.put(key, value);
        L5:
            value.add(uri);
        }

        public void dispatch() {
            int i = 0;
        L4:
            if (i >= this.collected.size()) goto L17;
            final Key key = this.collected.keyAt(i);
            final List<Uri> value = this.collected.valueAt(i);
            Runnable task = new ContentService$ObserverCollector$$ExternalSyntheticLambda0(key, value);
            if ((key.flags & 32768) == 0) goto L8;
            boolean noDelay = true;
        L9:
            int procState = ((ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class)).getUidProcessState(key.uid);
            if (procState <= 6) goto L14;
            if (noDelay == true) goto L14;
            BackgroundThread.getHandler().postDelayed(task, 10000);
        L15:
            i = i + 1;
        L14:
            task.run();
            goto L15
        L8:
            noDelay = false;
            goto L9
        }

        private static /* synthetic */ void lambda$dispatch$0(Key key, List value) {
            key.observer.onChangeEtc(key.selfChange, (Uri[]) value.toArray(new Uri[value.size()]), key.flags, key.userId);     // Catch: RemoteException -> L4 FrozenObjectException -> L6
            return;
        L12:
            return;
        }
    }

    public static final class ObserverNode {
        private ArrayList<ObserverNode> mChildren;
        private String mName;
        private ArrayList<ObserverEntry> mObservers;

        private class ObserverEntry implements IBinder.DeathRecipient {
            public final boolean notifyForDescendants;
            public final IContentObserver observer;
            private final Object observersLock;
            public final int pid;
            final /* synthetic */ ObserverNode this$0;
            public final int uid;
            private final int userHandle;

            /* JADX INFO: renamed from: -$$Nest$fgetuserHandle, reason: not valid java name */
            static /* bridge */ /* synthetic */ int m3144$$Nest$fgetuserHandle(ObserverEntry r0) {
                return r0.userHandle;
            }

            public ObserverEntry(ObserverNode r6, IContentObserver o, boolean n, Object observersLock, int _uid, int _pid, int _userHandle, Uri uri) {
                this.this$0 = r6;
                this.observersLock = observersLock;
                this.observer = o;
                this.uid = _uid;
                this.pid = _pid;
                this.userHandle = _userHandle;
                this.notifyForDescendants = n;
                int entries = ContentService.m3142$$Nest$sfgetsObserverDeathDispatcher().linkToDeath(this.observer, this);
                if (entries != (-1)) goto L6;
                binderDied();
                return;
            L6:
                if (entries != 1000) goto L28;
                ArraySet r0 = ContentService.m3143$$Nest$sfgetsObserverLeakDetectedUid();
                monitor-enter(r0);
                boolean alreadyDetected = ContentService.m3143$$Nest$sfgetsObserverLeakDetectedUid().contains(Integer.valueOf(this.uid));     // Catch: Throwable -> L12
                if (alreadyDetected == true) goto L14;
                ContentService.m3143$$Nest$sfgetsObserverLeakDetectedUid().add(Integer.valueOf(this.uid));     // Catch: Throwable -> L12
            L14:
                monitor-exit(r0);     // Catch: Throwable -> L12
                if (alreadyDetected == true) goto L29;
                String caller = null;
                caller = (String) ArrayUtils.firstOrNull(AppGlobals.getPackageManager().getPackagesForUid(this.uid));     // Catch: RemoteException -> L19
            L20:
                Slog.wtf(ContentService.TAG, "Observer registered too many times. Leak? cpid=" + this.pid + " cuid=" + this.uid + " cpkg=" + caller + " url=" + uri);
                return;
            L29:
                return;
            L12:
                th = move-exception;
                throw th;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                Object r0 = this.observersLock;
                monitor-enter(r0);
                this.this$0.removeObserverLocked(this.observer);     // Catch: Throwable -> L7
                monitor-exit(r0);     // Catch: Throwable -> L7
                return;
            L7:
                th = move-exception;
                throw th;
            }

            public void dumpLocked(FileDescriptor fd, PrintWriter pw, String[] args, String name, String prefix, SparseIntArray pidCounts) {
                pidCounts.put(this.pid, pidCounts.get(this.pid) + 1);
                pw.print(prefix);
                pw.print(name);
                pw.print(": pid=");
                pw.print(this.pid);
                pw.print(" uid=");
                pw.print(this.uid);
                pw.print(" user=");
                pw.print(this.userHandle);
                pw.print(" target=");
                if (this.observer == null) goto L5;
                IBinder r0 = this.observer.asBinder();
            L6:
                pw.println(Integer.toHexString(System.identityHashCode(r0)));
                return;
            L5:
                r0 = null;
                goto L6
            }
        }

        public ObserverNode(String name) {
            this.mChildren = new ArrayList();
            this.mObservers = new ArrayList();
            this.mName = name;
        }

        public void dumpLocked(FileDescriptor fd, PrintWriter pw, String[] args, String name, String prefix, int[] counts, SparseIntArray pidCounts) {
            String innerName = null;
            if (this.mObservers.size() <= 0) goto L14;
            if ("".equals(name) == false) goto L7;
            String innerName2 = this.mName;
            String innerName3 = innerName2;
        L8:
            int i = 0;
        L10:
            if (i >= this.mObservers.size()) goto L12;
            counts[1] = counts[1] + 1;
            this.mObservers.get(i).dumpLocked(fd, pw, args, innerName3, prefix, pidCounts);
            i = i + 1;
            goto L10
        L12:
            innerName = innerName3;
            goto L14
        L7:
            String innerName4 = name + SliceClientPermissions.SliceAuthority.DELIMITER + this.mName;
            innerName3 = innerName4;
        L14:
            if (this.mChildren.size() <= 0) goto L29;
            if (innerName == null) goto L17;
            String innerName5 = innerName;
        L21:
            int i2 = 0;
        L23:
            if (i2 >= this.mChildren.size()) goto L26;
            counts[0] = counts[0] + 1;
            this.mChildren.get(i2).dumpLocked(fd, pw, args, innerName5, prefix, counts, pidCounts);
            i2 = i2 + 1;
            goto L23
        L26:
            return;
        L17:
            if ("".equals(name) == false) goto L19;
            String innerName6 = this.mName;
            innerName5 = innerName6;
            goto L21
        L19:
            String innerName7 = name + SliceClientPermissions.SliceAuthority.DELIMITER + this.mName;
            innerName5 = innerName7;
            goto L21
        }

        public static String getUriSegment(Uri uri, int index) {
            if (uri == null) goto L8;
            if (index != 0) goto L7;
            return uri.getAuthority();
        L7:
            return uri.getPathSegments().get(index - 1);
        L8:
            return null;
        }

        public static int countUriSegments(Uri uri) {
            if (uri != null) goto L6;
            return 0;
        L6:
            return uri.getPathSegments().size() + 1;
        }

        public void addObserverLocked(Uri uri, IContentObserver observer, boolean notifyForDescendants, Object observersLock, int uid, int pid, int userHandle) {
            addObserverLocked(uri, 0, observer, notifyForDescendants, observersLock, uid, pid, userHandle);
        }

        private void addObserverLocked(Uri uri, int index, IContentObserver observer, boolean notifyForDescendants, Object observersLock, int uid, int pid, int userHandle) {
            if (index != countUriSegments(uri)) goto L6;
            this.mObservers.add(new ObserverEntry(this, observer, notifyForDescendants, observersLock, uid, pid, userHandle, uri));
            return;
        L6:
            String segment = getUriSegment(uri, index);
            if (segment == null) goto L18;
            int N = this.mChildren.size();
            int i = 0;
        L9:
            if (i >= N) goto L15;
            ObserverNode node = this.mChildren.get(i);
            if (node.mName.equals(segment) == true) goto L12;
            i = i + 1;
            goto L9
        L12:
            node.addObserverLocked(uri, index + 1, observer, notifyForDescendants, observersLock, uid, pid, userHandle);
            return;
        L15:
            ObserverNode node2 = new ObserverNode(segment);
            this.mChildren.add(node2);
            node2.addObserverLocked(uri, index + 1, observer, notifyForDescendants, observersLock, uid, pid, userHandle);
            return;
        L18:
            throw new IllegalArgumentException("Invalid Uri (" + uri + ") used for observer");
        }

        public boolean removeObserverLocked(IContentObserver observer) {
            int size = this.mChildren.size();
            int i = 0;
        L4:
            if (i >= size) goto L9;
            boolean empty = this.mChildren.get(i).removeObserverLocked(observer);
            if (empty == false) goto L8;
            this.mChildren.remove(i);
            i = i - 1;
            size = size - 1;
        L8:
            i = i + 1;
            goto L4
        L9:
            IBinder observerBinder = observer.asBinder();
            int size2 = this.mObservers.size();
            int i2 = 0;
        L10:
            if (i2 >= size2) goto L16;
            ObserverEntry entry = this.mObservers.get(i2);
            if (entry.observer.asBinder() == observerBinder) goto L13;
            i2 = i2 + 1;
            goto L10
        L13:
            this.mObservers.remove(i2);
            ContentService.m3142$$Nest$sfgetsObserverDeathDispatcher().unlinkToDeath(observer, entry);
        L16:
            if (this.mChildren.size() == 0) goto L18;
            return false;
        L18:
            if (this.mObservers.size() != 0) goto L27;
            return true;
        L27:
            return false;
        }

        private void collectMyObserversLocked(Uri uri, boolean leaf, IContentObserver observer, boolean observerWantsSelfNotifications, int flags, int targetUserHandle, ObserverCollector collector) {
            int N = this.mObservers.size();
            if (observer != null) goto L5;
            IBinder r0 = null;
        L6:
            IBinder observerBinder = r0;
            int i = 0;
        L7:
            if (i >= N) goto L34;
            ObserverEntry entry = this.mObservers.get(i);
            if (entry.observer.asBinder() != observerBinder) goto L12;
            boolean r1 = true;
        L11:
            boolean selfChange = r1;
            if (selfChange == false) goto L17;
            if (observerWantsSelfNotifications == true) goto L17;
        L32:
            i = i + 1;
        L17:
            if (targetUserHandle != (-1)) goto L19;
        L22:
            if (leaf == false) goto L29;
            if ((flags & 2) != 0) goto L26;
        L31:
            collector.collect(entry.observer, entry.uid, selfChange, uri, flags, targetUserHandle);
            goto L32
        L26:
            if (entry.notifyForDescendants == false) goto L31;
        L29:
            if (entry.notifyForDescendants == true) goto L31;
        L19:
            if (ObserverEntry.m3144$$Nest$fgetuserHandle(entry) == (-1)) goto L22;
            if (targetUserHandle != ObserverEntry.m3144$$Nest$fgetuserHandle(entry)) goto L32;
        L12:
            r1 = false;
            goto L11
        L34:
            return;
        L5:
            r0 = observer.asBinder();
            goto L6
        }

        public void collectObserversLocked(Uri uri, int index, IContentObserver observer, boolean observerWantsSelfNotifications, int flags, int targetUserHandle, ObserverCollector collector) {
            collectObserversLocked(uri, countUriSegments(uri), index, observer, observerWantsSelfNotifications, flags, targetUserHandle, collector);
        }

        public void collectObserversLocked(Uri uri, int segmentCount, int index, IContentObserver observer, boolean observerWantsSelfNotifications, int flags, int targetUserHandle, ObserverCollector collector) {
            int r8 = segmentCount;
            String segment = null;
            if (index < r8) goto L5;
            collectMyObserversLocked(uri, true, observer, observerWantsSelfNotifications, flags, targetUserHandle, collector);
        L7:
            int N = this.mChildren.size();
            int i = 0;
        L8:
            if (i >= N) goto L17;
            ObserverNode node = this.mChildren.get(i);
            if (segment != null) goto L12;
        L13:
            node.collectObserversLocked(uri, r8, index + 1, observer, observerWantsSelfNotifications, flags, targetUserHandle, collector);
            if (segment == null) goto L16;
            return;
        L16:
            i = i + 1;
            r8 = segmentCount;
            goto L8
        L12:
            if (node.mName.equals(segment) == false) goto L16;
        L17:
            return;
        L5:
            if (index >= r8) goto L7;
            segment = getUriSegment(uri, index);
            collectMyObserversLocked(uri, false, observer, observerWantsSelfNotifications, flags, targetUserHandle, collector);
            goto L7
        }
    }

    public static /* synthetic */ boolean $r8$lambda$AjFPVUPaMmwlWLE_QdM3Oj2y3xo(ContentService r0, int r1, int r2, SyncInfo r3) {
        return r0.lambda$getCurrentSyncsAsUser$1(r1, r2, r3);
    }

    public static /* synthetic */ String[] $r8$lambda$tRDtME3FEONNmxLTGpqbA3aw8SU(ContentService r0, String r1, int r2) {
        return r0.lambda$new$0(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCache, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m3140$$Nest$fgetmCache(ContentService r0) {
        return r0.mCache;
    }

    /* JADX INFO: renamed from: -$$Nest$minvalidateCacheLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3141$$Nest$minvalidateCacheLocked(ContentService r0, int r1, String r2, Uri r3) {
        r0.invalidateCacheLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetsObserverDeathDispatcher, reason: not valid java name */
    static /* bridge */ /* synthetic */ BinderDeathDispatcher m3142$$Nest$sfgetsObserverDeathDispatcher() {
        return sObserverDeathDispatcher;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetsObserverLeakDetectedUid, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArraySet m3143$$Nest$sfgetsObserverLeakDetectedUid() {
        return sObserverLeakDetectedUid;
    }

    static {
        sObserverDeathDispatcher = new BinderDeathDispatcher();
        sObserverLeakDetectedUid = new ArraySet(0);
    }

    private SyncManager getSyncManager() {
        Object r0 = this.mSyncManagerLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mSyncManager != null) goto L9;
        this.mSyncManager = new SyncManager(this.mContext, this.mFactoryTest);     // Catch: Throwable -> L7
    L9:
        SyncManager r1 = this.mSyncManager;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    }

    void onStartUser(int userHandle) {
        if (this.mSyncManager == null) goto L6;
        this.mSyncManager.onStartUser(userHandle);
        return;
    }

    void onUnlockUser(int userHandle) {
        if (this.mSyncManager == null) goto L6;
        this.mSyncManager.onUnlockUser(userHandle);
        return;
    }

    void onStopUser(int userHandle) {
        if (this.mSyncManager == null) goto L6;
        this.mSyncManager.onStopUser(userHandle);
        return;
    }

    protected synchronized void dump(FileDescriptor fd, PrintWriter pw_, String[] args) {
        monitor-enter(this);
    L50:
        th = move-exception;
        throw th;
    L5:
        if (DumpUtils.checkDumpAndUsageStatsPermission(this.mContext, TAG, pw_) == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        PrintWriter r0 = new IndentingPrintWriter(pw_, "  ");     // Catch: Throwable -> L50
        boolean dumpAll = ArrayUtils.contains(args, "-a");     // Catch: Throwable -> L50
        long identityToken = IContentService.Stub.clearCallingIdentity();     // Catch: Throwable -> L50
    L13:
        th = move-exception;
        IContentService.Stub.restoreCallingIdentity(identityToken);     // Catch: Throwable -> L50
        throw th;     // Catch: Throwable -> L50
    L11:
        if (this.mSyncManager != null) goto L15;
        r0.println("SyncManager not available yet");     // Catch: Throwable -> L13
    L16:
        r0.println();     // Catch: Throwable -> L13
        r0.println("Observer tree:");     // Catch: Throwable -> L13
        ObserverNode r13 = this.mRootNode;     // Catch: Throwable -> L13
        monitor-enter(r13);     // Catch: Throwable -> L13
        int[] counts = new int[2];     // Catch: Throwable -> L23
        final SparseIntArray pidCounts = new SparseIntArray();     // Catch: Throwable -> L23
        this.mRootNode.dumpLocked(fd, r0, args, "", "  ", counts, pidCounts);     // Catch: Throwable -> L23
        r0.println();     // Catch: Throwable -> L23
        ArrayList<Integer> sorted = new ArrayList();     // Catch: Throwable -> L23
        int i = 0;
    L21:
        if (i >= pidCounts.size()) goto L25;
        sorted.add(Integer.valueOf(pidCounts.keyAt(i)));     // Catch: Throwable -> L23
        i = i + 1;     // Catch: Throwable -> L23
        goto L21
    L25:
        Collections.sort(sorted, new AnonymousClass2(this, pidCounts));     // Catch: Throwable -> L23
        int i2 = 0;
    L27:
        if (i2 >= sorted.size()) goto L29;
        int pid = sorted.get(i2).intValue();     // Catch: Throwable -> L23
        r0.print("  pid ");     // Catch: Throwable -> L23
        r0.print(pid);     // Catch: Throwable -> L23
        r0.print(": ");     // Catch: Throwable -> L23
        r0.print(pidCounts.get(pid));     // Catch: Throwable -> L23
        r0.println(" observers");     // Catch: Throwable -> L23
        i2 = i2 + 1;     // Catch: Throwable -> L23
        goto L27
    L29:
        r0.println();     // Catch: Throwable -> L23
        r0.increaseIndent();     // Catch: Throwable -> L23
        r0.print("Total number of nodes: ");     // Catch: Throwable -> L23
        r0.println(counts[0]);     // Catch: Throwable -> L23
        r0.print("Total number of observers: ");     // Catch: Throwable -> L23
        r0.println(counts[1]);     // Catch: Throwable -> L23
        sObserverDeathDispatcher.dump(r0);     // Catch: Throwable -> L23
        r0.decreaseIndent();     // Catch: Throwable -> L23
        monitor-exit(r13);     // Catch: Throwable -> L23
        ArraySet<Integer> r3 = sObserverLeakDetectedUid;     // Catch: Throwable -> L13
        monitor-enter(r3);     // Catch: Throwable -> L13
        r0.println();     // Catch: Throwable -> L55
        r0.print("Observer leaking UIDs: ");     // Catch: Throwable -> L55
        r0.println(sObserverLeakDetectedUid.toString());     // Catch: Throwable -> L55
        monitor-exit(r3);     // Catch: Throwable -> L55
        SparseArray<ArrayMap<String, ArrayMap<Pair<String, Uri>, Bundle>>> r4 = this.mCache;     // Catch: Throwable -> L13
        monitor-enter(r4);     // Catch: Throwable -> L13
        r0.println();     // Catch: Throwable -> L52
        r0.println("Cached content:");     // Catch: Throwable -> L52
        r0.increaseIndent();     // Catch: Throwable -> L52
        int i3 = 0;
    L39:
        if (i3 >= this.mCache.size()) goto L45;
        r0.println("User " + this.mCache.keyAt(i3) + ":");     // Catch: Throwable -> L42
        r0.increaseIndent();     // Catch: Throwable -> L42
        r0.println(this.mCache.valueAt(i3));     // Catch: Throwable -> L42
        r0.decreaseIndent();     // Catch: Throwable -> L42
        i3 = i3 + 1;
        goto L39
    L45:
        r0.decreaseIndent();     // Catch: Throwable -> L52
        monitor-exit(r4);     // Catch: Throwable -> L52
        IContentService.Stub.restoreCallingIdentity(identityToken);     // Catch: Throwable -> L50
        monitor-exit(this);
        return;
    L52:
        th = th;
    L53:
        monitor-exit(r4);     // Catch: Throwable -> L42
        throw th;     // Catch: Throwable -> L13
    L42:
        th = th;
        goto L53
    L55:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L15:
        this.mSyncManager.dump(fd, r0, dumpAll);     // Catch: Throwable -> L13
        goto L16
    }

    ContentService(Context context, boolean factoryTest) {
        this.mRootNode = new ObserverNode("");
        this.mSyncManager = null;
        this.mSyncManagerLock = new Object();
        this.mCache = new SparseArray();
        this.mCacheReceiver = new AnonymousClass1(this);
        this.mContext = context;
        this.mFactoryTest = factoryTest;
        LegacyPermissionManagerInternal permissionManagerInternal = (LegacyPermissionManagerInternal) LocalServices.getService(LegacyPermissionManagerInternal.class);
        permissionManagerInternal.setSyncAdapterPackagesProvider(new ContentService$$ExternalSyntheticLambda0(this));
        IntentFilter packageFilter = new IntentFilter();
        packageFilter.addAction("android.intent.action.PACKAGE_ADDED");
        packageFilter.addAction("android.intent.action.PACKAGE_CHANGED");
        packageFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        packageFilter.addAction("android.intent.action.PACKAGE_DATA_CLEARED");
        packageFilter.addDataScheme(Settings.ATTR_PACKAGE);
        this.mContext.registerReceiverAsUser(this.mCacheReceiver, UserHandle.ALL, packageFilter, null, null);
        IntentFilter localeFilter = new IntentFilter();
        localeFilter.addAction("android.intent.action.LOCALE_CHANGED");
        this.mContext.registerReceiverAsUser(this.mCacheReceiver, UserHandle.ALL, localeFilter, null, null);
        this.mAccountManagerInternal = (AccountManagerInternal) LocalServices.getService(AccountManagerInternal.class);
    }

    private /* synthetic */ String[] lambda$new$0(String authority, int userId) {
        return getSyncAdapterPackagesForAuthorityAsUser(authority, userId);
    }

    void onBootPhase(int phase) {
        switch(phase) {
            case 550: goto L4;
            default: goto L6;
        };
    L4:
        getSyncManager();
    L6:
        if (this.mSyncManager == null) goto L9;
        this.mSyncManager.onBootPhase(phase);
        return;
    }

    public void registerContentObserver(Uri uri, boolean notifyForDescendants, IContentObserver observer, int userHandle, int targetSdkVersion) {
        if (observer == null) goto L36;
        if (uri == null) goto L36;
        int uid = Binder.getCallingUid();
        int pid = Binder.getCallingPid();
        int userHandle2 = handleIncomingUser(uri, pid, uid, 1, true, userHandle);
        String msg = ((ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class)).checkContentProviderAccess(uri.getAuthority(), userHandle2);
        if (msg != null) goto L7;
    L15:
        ObserverNode r8 = this.mRootNode;
        monitor-enter(r8);
        this.mRootNode.addObserverLocked(uri, observer, notifyForDescendants, this.mRootNode, uid, pid, userHandle2);     // Catch: Throwable -> L27
        monitor-exit(r8);     // Catch: Throwable -> L25
        return;
    L27:
        th = move-exception;
        Throwable r11 = th;
    L33:
        monitor-exit(r8);     // Catch: Throwable -> L25
        throw r11;
    L29:
        th = move-exception;
        r11 = th;
    L31:
        th = move-exception;
        r11 = th;
    L25:
        th = move-exception;
        r11 = th;
        goto L33
    L7:
        if (targetSdkVersion >= 26) goto L14;
        if (msg.startsWith("Failed to find provider") == true) goto L15;
        Log.w(TAG, "Ignoring content changes for " + uri + " from " + uid + ": " + msg);
        return;
    L14:
        throw new SecurityException(msg);
    L36:
        throw new IllegalArgumentException("You must pass a valid uri and observer");
    }

    public void registerContentObserver(Uri uri, boolean notifyForDescendants, IContentObserver observer) {
        registerContentObserver(uri, notifyForDescendants, observer, UserHandle.getCallingUserId(), 10000);
    }

    public void unregisterContentObserver(IContentObserver observer) {
        if (observer == null) goto L12;
        ObserverNode r0 = this.mRootNode;
        monitor-enter(r0);
        this.mRootNode.removeObserverLocked(observer);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    L12:
        throw new IllegalArgumentException("You must pass a valid observer");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:? -> B:26:0x00bc). Please report as a decompilation issue!!! */
    public void notifyChange(Uri[] r28, IContentObserver r29, boolean r30, int r31, int r32, int r33, String r34) {
        int r12 = Binder.getCallingUid();
        int r16 = Binder.getCallingPid();
        int r11 = UserHandle.getCallingUserId();
        ObserverCollector r0 = new ObserverCollector();
        ArrayMap r9 = new ArrayMap();
        int r1 = r28.length;
        int r10 = 0;
    L3:
        if (r10 >= r1) goto L34;
        Uri r2 = r28[r10];
        int r5 = handleIncomingUser(r2, r16, r12, 2, true, r32);
        Pair r3 = Pair.create(r2.getAuthority(), Integer.valueOf(r5));
        if (r9.containsKey(r3) == true) goto L19;
        String r4 = ((ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class)).checkContentProviderAccess(r2.getAuthority(), r5);
        if (r4 == null) goto L17;
        if (r33 >= 26) goto L15;
        if (r4.startsWith("Failed to find provider") == true) goto L17;
        Log.w(TAG, "Ignoring notify for " + r2 + " from " + r12 + ": " + r4);
        Object r6 = r4;
    L70:
        r10 = r10 + 1;     // Catch: Throwable -> L26
    L26:
        th = th;
        r6 = r6;
    L32:
        monitor-exit(r6);     // Catch: Throwable -> L26
        throw th;
    L15:
        throw new SecurityException(r4);
    L17:
        r9.put(r3, getProviderPackageName(r2, r5));
    L19:
        ObserverNode r7 = this.mRootNode;
        monitor-enter(r7);
        this.mRootNode.collectObserversLocked(r2, ObserverNode.countUriSegments(r2), 0, r29, r30, r31, r5, r0);     // Catch: Throwable -> L28
        r6 = r7;
        monitor-exit(r7);     // Catch: Throwable -> L26
    L28:
        th = th;
        r6 = r7;
    L30:
        th = th;
        r6 = r7;
        goto L32
    L34:
        long r8 = IContentService.Stub.clearCallingIdentity();
        r0.dispatch();     // Catch: Throwable -> L45
        SyncManager r13 = getSyncManager();     // Catch: Throwable -> L45
        int r14 = 0;
    L37:
        if (r14 >= r9.size()) goto L62;
        String r15 = (String) ((Pair) r9.keyAt(r14)).first;     // Catch: Throwable -> L45
        int r17 = ((Integer) ((Pair) r9.keyAt(r14)).second).intValue();     // Catch: Throwable -> L45
        String r18 = (String) r9.valueAt(r14);     // Catch: Throwable -> L45
        if ((r31 & 1) == 0) goto L47;
        ArrayMap r19 = r9;
        SyncManager r20 = r13;
        ArrayMap r21 = r19;
        long r110 = r8;
        String r22 = r18;
        r20.scheduleLocalSync(null, r11, r12, r15, getSyncExemptionForCaller(r12), r12, r16, r34);     // Catch: Throwable -> L43
    L48:
        SparseArray<ArrayMap<String, ArrayMap<Pair<String, Uri>, Bundle>>> r23 = this.mCache;     // Catch: Throwable -> L43
        monitor-enter(r23);     // Catch: Throwable -> L43
        int r24 = r28.length;     // Catch: Throwable -> L55
        int r111 = 0;
    L51:
        if (r111 >= r24) goto L58;
        Uri r112 = r28[r111];     // Catch: Throwable -> L55
        if (Objects.equals(r112.getAuthority(), r15) == false) goto L57;
        invalidateCacheLocked(r17, r22, r112);     // Catch: Throwable -> L55
    L57:
        r111 = r111 + 1;     // Catch: Throwable -> L55
        goto L51
    L58:
        monitor-exit(r23);     // Catch: Throwable -> L55
        r14 = r14 + 1;     // Catch: Throwable -> L55
        SyncManager r25 = r20;
        r9 = r21;
        r13 = r25;
        r8 = r110;
        goto L37
    L55:
        th = move-exception;
        throw th;     // Catch: Throwable -> L43
    L43:
        th = th;
    L64:
        Binder.restoreCallingIdentity(r110);
        throw th;
    L47:
        ArrayMap r113 = r9;
        r20 = r13;
        r21 = r113;
        r110 = r8;
        r22 = r18;
        goto L48
    L62:
        Binder.restoreCallingIdentity(r8);
        return;
    L45:
        th = th;
        r110 = r8;
        goto L64
    }

    private int checkUriPermission(Uri uri, int pid, int uid, int modeFlags, int userHandle) {
        return ActivityManager.getService().checkUriPermission(uri, pid, uid, modeFlags, userHandle, null);
    L16:
        return -1;
    L10:
        return -1;
    }

    public void requestSync(Account account, String authority, Bundle extras, String callingPackage) {
        Bundle.setDefusable(extras, true);
        ContentResolver.validateSyncExtrasBundle(extras);
        int userId = UserHandle.getCallingUserId();
        int callingUid = Binder.getCallingUid();
        int callingPid = Binder.getCallingPid();
        if (hasAccountAccess(true, account, callingUid) == true) goto L6;
        return;
    L6:
        if (hasAuthorityAccess(authority, callingUid, userId) == true) goto L8;
        return;
    L8:
        validateExtras(callingUid, extras);
        int syncExemption = getSyncExemptionAndCleanUpExtrasForCaller(callingUid, extras);
        long identityToken = IContentService.Stub.clearCallingIdentity();
        getSyncManager().scheduleSync(account, userId, callingUid, authority, extras, -2, syncExemption, callingUid, callingPid, callingPackage);     // Catch: Throwable -> L12
        IContentService.Stub.restoreCallingIdentity(identityToken);
        return;
    L12:
        th = move-exception;
        IContentService.Stub.restoreCallingIdentity(identityToken);
        throw th;
    }

    public void sync(SyncRequest request, String callingPackage) {
        syncAsUser(request, UserHandle.getCallingUserId(), callingPackage);
    }

    private long clampPeriod(long period) {
        long minPeriod = JobInfo.getMinPeriodMillis() / 1000;
        if (period >= minPeriod) goto L6;
        Slog.w(TAG, "Requested poll frequency of " + period + " seconds being rounded up to " + minPeriod + "s.");
        return minPeriod;
    L6:
        return period;
    }

    public void syncAsUser(SyncRequest request, int userId, String callingPackage) {
        enforceCrossUserPermission(userId, "no permission to request sync as user: " + userId);
        int callingUid = Binder.getCallingUid();
        int callingPid = Binder.getCallingPid();
        if (hasAccountAccess(true, request.getAccount(), callingUid) == true) goto L6;
        return;
    L6:
        if (hasAuthorityAccess(request.getProvider(), callingUid, userId) == true) goto L8;
        return;
    L8:
        Bundle extras = request.getBundle();
        validateExtras(callingUid, extras);
        int syncExemption = getSyncExemptionAndCleanUpExtrasForCaller(callingUid, extras);
        long identityToken = IContentService.Stub.clearCallingIdentity();
        long flextime = request.getSyncFlexTime();     // Catch: Throwable -> L16
        long runAtTime = request.getSyncRunTime();     // Catch: Throwable -> L16
        if (request.isPeriodic() == false) goto L20;
        this.mContext.enforceCallingOrSelfPermission("android.permission.WRITE_SYNC_SETTINGS", "no permission to write the sync settings");     // Catch: Throwable -> L16
        SyncStorageEngine.EndPoint info = new SyncStorageEngine.EndPoint(request.getAccount(), request.getProvider(), userId);     // Catch: Throwable -> L16
        getSyncManager().updateOrAddPeriodicSync(info, clampPeriod(runAtTime), flextime, extras);     // Catch: Throwable -> L14
    L21:
        IContentService.Stub.restoreCallingIdentity(identityToken);
        return;
    L20:
        getSyncManager().scheduleSync(request.getAccount(), userId, callingUid, request.getProvider(), extras, -2, syncExemption, callingUid, callingPid, callingPackage);     // Catch: Throwable -> L16
    L14:
        th = th;
    L23:
        IContentService.Stub.restoreCallingIdentity(identityToken);
        throw th;
    L16:
        th = th;
        goto L23
    }

    public void cancelSync(Account account, String authority, ComponentName cname) {
        cancelSyncAsUser(account, authority, cname, UserHandle.getCallingUserId());
    }

    public void cancelSyncAsUser(Account account, String authority, ComponentName cname, int userId) {
        if (authority != null) goto L4;
    L8:
        enforceCrossUserPermission(userId, "no permission to modify the sync settings for user " + userId);
        if (cname == null) goto L12;
        Slog.e(TAG, "cname not null.");
        return;
    L12:
        long identityToken = IContentService.Stub.clearCallingIdentity();
        SyncStorageEngine.EndPoint info = new SyncStorageEngine.EndPoint(account, authority, userId);     // Catch: Throwable -> L16
        getSyncManager().clearScheduledSyncOperations(info);     // Catch: Throwable -> L16
        getSyncManager().cancelActiveSync(info, null, "API");     // Catch: Throwable -> L16
        IContentService.Stub.restoreCallingIdentity(identityToken);
        return;
    L16:
        th = move-exception;
        IContentService.Stub.restoreCallingIdentity(identityToken);
        throw th;
    L4:
        if (authority.length() != 0) goto L8;
        throw new IllegalArgumentException("Authority must be non-empty");
    }

    public void cancelRequest(SyncRequest request) {
        if (request.isPeriodic() == false) goto L5;
        this.mContext.enforceCallingOrSelfPermission("android.permission.WRITE_SYNC_SETTINGS", "no permission to write the sync settings");
    L5:
        int callingUid = Binder.getCallingUid();
        Bundle extras = new Bundle(request.getBundle());
        validateExtras(callingUid, extras);
        int userId = UserHandle.getCallingUserId();
        long identityToken = IContentService.Stub.clearCallingIdentity();
        Account account = request.getAccount();     // Catch: Throwable -> L9
        String provider = request.getProvider();     // Catch: Throwable -> L9
        SyncStorageEngine.EndPoint info = new SyncStorageEngine.EndPoint(account, provider, userId);     // Catch: Throwable -> L9
        if (request.isPeriodic() == false) goto L11;
        getSyncManager().removePeriodicSync(info, extras, "cancelRequest() by uid=" + callingUid);     // Catch: Throwable -> L9
    L11:
        getSyncManager().cancelScheduledSyncOperation(info, extras);     // Catch: Throwable -> L9
        getSyncManager().cancelActiveSync(info, extras, "API");     // Catch: Throwable -> L9
        IContentService.Stub.restoreCallingIdentity(identityToken);
        return;
    L9:
        th = move-exception;
        IContentService.Stub.restoreCallingIdentity(identityToken);
        throw th;
    }

    public SyncAdapterType[] getSyncAdapterTypes() {
        return getSyncAdapterTypesAsUser(UserHandle.getCallingUserId());
    }

    public SyncAdapterType[] getSyncAdapterTypesAsUser(int userId) {
        enforceCrossUserPermission(userId, "no permission to read sync settings for user " + userId);
        int callingUid = Binder.getCallingUid();
        long identityToken = IContentService.Stub.clearCallingIdentity();
        SyncAdapterType[] r3 = getSyncManager().getSyncAdapterTypes(callingUid, userId);     // Catch: Throwable -> L6
        IContentService.Stub.restoreCallingIdentity(identityToken);
        return r3;
    L6:
        th = move-exception;
        IContentService.Stub.restoreCallingIdentity(identityToken);
        throw th;
    }

    public String[] getSyncAdapterPackagesForAuthorityAsUser(String authority, int userId) {
        enforceCrossUserPermission(userId, "no permission to read sync settings for user " + userId);
        int callingUid = Binder.getCallingUid();
        long identityToken = IContentService.Stub.clearCallingIdentity();
        String[] r3 = getSyncManager().getSyncAdapterPackagesForAuthorityAsUser(authority, callingUid, userId);     // Catch: Throwable -> L6
        IContentService.Stub.restoreCallingIdentity(identityToken);
        return r3;
    L6:
        th = move-exception;
        IContentService.Stub.restoreCallingIdentity(identityToken);
        throw th;
    }

    public String getSyncAdapterPackageAsUser(String accountType, String authority, int userId) {
        enforceCrossUserPermission(userId, "no permission to read sync settings for user " + userId);
        int callingUid = Binder.getCallingUid();
        long identityToken = IContentService.Stub.clearCallingIdentity();
        String r3 = getSyncManager().getSyncAdapterPackageAsUser(accountType, authority, callingUid, userId);     // Catch: Throwable -> L6
        IContentService.Stub.restoreCallingIdentity(identityToken);
        return r3;
    L6:
        th = move-exception;
        IContentService.Stub.restoreCallingIdentity(identityToken);
        throw th;
    }

    public boolean getSyncAutomatically(Account account, String providerName) {
        return getSyncAutomaticallyAsUser(account, providerName, UserHandle.getCallingUserId());
    }

    public boolean getSyncAutomaticallyAsUser(Account account, String providerName, int userId) {
        enforceCrossUserPermission(userId, "no permission to read the sync settings for user " + userId);
        this.mContext.enforceCallingOrSelfPermission("android.permission.READ_SYNC_SETTINGS", "no permission to read the sync settings");
        int callingUid = Binder.getCallingUid();
        if (hasAccountAccess(true, account, callingUid) == true) goto L6;
        return false;
    L6:
        if (hasAuthorityAccess(providerName, callingUid, userId) == true) goto L8;
        return false;
    L8:
        long identityToken = IContentService.Stub.clearCallingIdentity();
        boolean r3 = getSyncManager().getSyncStorageEngine().getSyncAutomatically(account, userId, providerName);     // Catch: Throwable -> L12
        IContentService.Stub.restoreCallingIdentity(identityToken);
        return r3;
    L12:
        th = move-exception;
        IContentService.Stub.restoreCallingIdentity(identityToken);
        throw th;
    }

    public void setSyncAutomatically(Account account, String providerName, boolean sync) {
        setSyncAutomaticallyAsUser(account, providerName, sync, UserHandle.getCallingUserId());
    }

    public void setSyncAutomaticallyAsUser(Account account, String providerName, boolean sync, int userId) {
        if (TextUtils.isEmpty(providerName) == true) goto L23;
        this.mContext.enforceCallingOrSelfPermission("android.permission.WRITE_SYNC_SETTINGS", "no permission to write the sync settings");
        enforceCrossUserPermission(userId, "no permission to modify the sync settings for user " + userId);
        int callingUid = Binder.getCallingUid();
        int callingPid = Binder.getCallingPid();
        if (hasAccountAccess(true, account, callingUid) == true) goto L8;
        return;
    L8:
        if (hasAuthorityAccess(providerName, callingUid, userId) == true) goto L10;
        return;
    L10:
        int syncExemptionFlag = getSyncExemptionForCaller(callingUid);
        long identityToken = IContentService.Stub.clearCallingIdentity();
        getSyncManager().getSyncStorageEngine().setSyncAutomatically(account, userId, providerName, sync, syncExemptionFlag, callingUid, callingPid);     // Catch: Throwable -> L16
        IContentService.Stub.restoreCallingIdentity(identityToken);
        return;
    L16:
        th = move-exception;
        Throwable r12 = th;
    L20:
        IContentService.Stub.restoreCallingIdentity(identityToken);
        throw r12;
    L18:
        th = move-exception;
        r12 = th;
        goto L20
    L23:
        throw new IllegalArgumentException("Authority must be non-empty");
    }

    public void addPeriodicSync(Account account, String authority, Bundle extras, long pollFrequency) {
        Bundle.setDefusable(extras, true);
        if (account == null) goto L27;
        if (TextUtils.isEmpty(authority) == true) goto L25;
        this.mContext.enforceCallingOrSelfPermission("android.permission.WRITE_SYNC_SETTINGS", "no permission to write the sync settings");
        int callingUid = Binder.getCallingUid();
        int userId = UserHandle.getCallingUserId();
        if (hasAccountAccess(true, account, callingUid) == true) goto L10;
        return;
    L10:
        if (hasAuthorityAccess(authority, callingUid, userId) == true) goto L12;
        return;
    L12:
        validateExtras(callingUid, extras);
        long pollFrequency2 = clampPeriod(pollFrequency);
        long defaultFlex = SyncStorageEngine.calculateDefaultFlexTime(pollFrequency2);
        long identityToken = IContentService.Stub.clearCallingIdentity();
        SyncStorageEngine.EndPoint info = new SyncStorageEngine.EndPoint(account, authority, userId);     // Catch: Throwable -> L20
        getSyncManager().updateOrAddPeriodicSync(info, pollFrequency2, defaultFlex, extras);     // Catch: Throwable -> L18
        IContentService.Stub.restoreCallingIdentity(identityToken);
        return;
    L18:
        th = move-exception;
        Throwable r13 = th;
    L22:
        IContentService.Stub.restoreCallingIdentity(identityToken);
        throw r13;
    L20:
        th = move-exception;
        r13 = th;
        goto L22
    L25:
        throw new IllegalArgumentException("Authority must not be empty.");
    L27:
        throw new IllegalArgumentException("Account must not be null");
    }

    public void removePeriodicSync(Account account, String authority, Bundle extras) {
        Bundle.setDefusable(extras, true);
        if (account == null) goto L22;
        if (TextUtils.isEmpty(authority) == true) goto L20;
        this.mContext.enforceCallingOrSelfPermission("android.permission.WRITE_SYNC_SETTINGS", "no permission to write the sync settings");
        int callingUid = Binder.getCallingUid();
        int userId = UserHandle.getCallingUserId();
        if (hasAccountAccess(true, account, callingUid) == true) goto L10;
        return;
    L10:
        if (hasAuthorityAccess(authority, callingUid, userId) == true) goto L12;
        return;
    L12:
        validateExtras(callingUid, extras);
        long identityToken = IContentService.Stub.clearCallingIdentity();
        getSyncManager().removePeriodicSync(new SyncStorageEngine.EndPoint(account, authority, userId), extras, "removePeriodicSync() by uid=" + callingUid);     // Catch: Throwable -> L16
        IContentService.Stub.restoreCallingIdentity(identityToken);
        return;
    L16:
        th = move-exception;
        IContentService.Stub.restoreCallingIdentity(identityToken);
        throw th;
    L20:
        throw new IllegalArgumentException("Authority must not be empty");
    L22:
        throw new IllegalArgumentException("Account must not be null");
    }

    public List<PeriodicSync> getPeriodicSyncs(Account account, String providerName, ComponentName cname) {
        if (account == null) goto L23;
        if (TextUtils.isEmpty(providerName) == true) goto L21;
        this.mContext.enforceCallingOrSelfPermission("android.permission.READ_SYNC_SETTINGS", "no permission to read the sync settings");
        int callingUid = Binder.getCallingUid();
        int userId = UserHandle.getCallingUserId();
        if (hasAccountAccess(true, account, callingUid) == true) goto L10;
        return new ArrayList();
    L10:
        if (hasAuthorityAccess(providerName, callingUid, userId) == false) goto L12;
        long identityToken = IContentService.Stub.clearCallingIdentity();
        List<PeriodicSync> r4 = getSyncManager().getPeriodicSyncs(new SyncStorageEngine.EndPoint(account, providerName, userId));     // Catch: Throwable -> L17
        IContentService.Stub.restoreCallingIdentity(identityToken);
        return r4;
    L17:
        th = move-exception;
        IContentService.Stub.restoreCallingIdentity(identityToken);
        throw th;
    L12:
        return new ArrayList();
    L21:
        throw new IllegalArgumentException("Authority must not be empty");
    L23:
        throw new IllegalArgumentException("Account must not be null");
    }

    public int getIsSyncable(Account account, String providerName) {
        return getIsSyncableAsUser(account, providerName, UserHandle.getCallingUserId());
    }

    public int getIsSyncableAsUser(Account account, String providerName, int userId) {
        enforceCrossUserPermission(userId, "no permission to read the sync settings for user " + userId);
        this.mContext.enforceCallingOrSelfPermission("android.permission.READ_SYNC_SETTINGS", "no permission to read the sync settings");
        int callingUid = Binder.getCallingUid();
        if (hasAccountAccess(true, account, callingUid) == true) goto L6;
        return 0;
    L6:
        if (hasAuthorityAccess(providerName, callingUid, userId) == true) goto L8;
        return 0;
    L8:
        long identityToken = IContentService.Stub.clearCallingIdentity();
        int r11 = getSyncManager().computeSyncable(account, userId, providerName, false, false);     // Catch: Throwable -> L14
        IContentService.Stub.restoreCallingIdentity(identityToken);
        return r11;
    L14:
        th = move-exception;
        Throwable r12 = th;
    L18:
        IContentService.Stub.restoreCallingIdentity(identityToken);
        throw r12;
    L16:
        th = move-exception;
        r12 = th;
        goto L18
    }

    public void setIsSyncable(Account account, String providerName, int syncable) {
        setIsSyncableAsUser(account, providerName, syncable, UserHandle.getCallingUserId());
    }

    public void setIsSyncableAsUser(Account account, String providerName, int syncable, int userId) {
        if (TextUtils.isEmpty(providerName) == true) goto L23;
        enforceCrossUserPermission(userId, "no permission to set the sync settings for user " + userId);
        this.mContext.enforceCallingOrSelfPermission("android.permission.WRITE_SYNC_SETTINGS", "no permission to write the sync settings");
        int syncable2 = normalizeSyncable(syncable);
        int callingUid = Binder.getCallingUid();
        int callingPid = Binder.getCallingPid();
        if (hasAccountAccess(true, account, callingUid) == true) goto L8;
        return;
    L8:
        if (hasAuthorityAccess(providerName, callingUid, userId) == true) goto L10;
        return;
    L10:
        long identityToken = IContentService.Stub.clearCallingIdentity();
        getSyncManager().getSyncStorageEngine().setIsSyncable(account, userId, providerName, syncable2, callingUid, callingPid);     // Catch: Throwable -> L16
        IContentService.Stub.restoreCallingIdentity(identityToken);
        return;
    L16:
        th = move-exception;
        Throwable r11 = th;
    L20:
        IContentService.Stub.restoreCallingIdentity(identityToken);
        throw r11;
    L18:
        th = move-exception;
        r11 = th;
        goto L20
    L23:
        throw new IllegalArgumentException("Authority must not be empty");
    }

    public boolean getMasterSyncAutomatically() {
        return getMasterSyncAutomaticallyAsUser(UserHandle.getCallingUserId());
    }

    public boolean getMasterSyncAutomaticallyAsUser(int userId) {
        enforceCrossUserPermission(userId, "no permission to read the sync settings for user " + userId);
        this.mContext.enforceCallingOrSelfPermission("android.permission.READ_SYNC_SETTINGS", "no permission to read the sync settings");
        long identityToken = IContentService.Stub.clearCallingIdentity();
        boolean r2 = getSyncManager().getSyncStorageEngine().getMasterSyncAutomatically(userId);     // Catch: Throwable -> L6
        IContentService.Stub.restoreCallingIdentity(identityToken);
        return r2;
    L6:
        th = move-exception;
        IContentService.Stub.restoreCallingIdentity(identityToken);
        throw th;
    }

    public void setMasterSyncAutomatically(boolean flag) {
        setMasterSyncAutomaticallyAsUser(flag, UserHandle.getCallingUserId());
    }

    public void setMasterSyncAutomaticallyAsUser(boolean flag, int userId) {
        enforceCrossUserPermission(userId, "no permission to set the sync status for user " + userId);
        this.mContext.enforceCallingOrSelfPermission("android.permission.WRITE_SYNC_SETTINGS", "no permission to write the sync settings");
        int callingUid = Binder.getCallingUid();
        int callingPid = Binder.getCallingPid();
        long identityToken = IContentService.Stub.clearCallingIdentity();
        getSyncManager().getSyncStorageEngine().setMasterSyncAutomatically(flag, userId, getSyncExemptionForCaller(callingUid), callingUid, callingPid);     // Catch: Throwable -> L8
        IContentService.Stub.restoreCallingIdentity(identityToken);
        return;
    L8:
        th = move-exception;
        Throwable r10 = th;
    L12:
        IContentService.Stub.restoreCallingIdentity(identityToken);
        throw r10;
    L10:
        th = move-exception;
        r10 = th;
        goto L12
    }

    public boolean isSyncActive(Account account, String authority, ComponentName cname) {
        isSyncActive_enforcePermission();
        int callingUid = Binder.getCallingUid();
        int userId = UserHandle.getCallingUserId();
        if (hasAccountAccess(true, account, callingUid) == true) goto L6;
        return false;
    L6:
        if (hasAuthorityAccess(authority, callingUid, userId) == true) goto L8;
        return false;
    L8:
        long identityToken = IContentService.Stub.clearCallingIdentity();
        boolean r4 = getSyncManager().getSyncStorageEngine().isSyncActive(new SyncStorageEngine.EndPoint(account, authority, userId));     // Catch: Throwable -> L12
        IContentService.Stub.restoreCallingIdentity(identityToken);
        return r4;
    L12:
        th = move-exception;
        IContentService.Stub.restoreCallingIdentity(identityToken);
        throw th;
    }

    public List<SyncInfo> getCurrentSyncs() {
        return getCurrentSyncsAsUser(UserHandle.getCallingUserId());
    }

    public List<SyncInfo> getCurrentSyncsAsUser(final int userId) {
        enforceCrossUserPermission(userId, "no permission to read the sync settings for user " + userId);
        this.mContext.enforceCallingOrSelfPermission("android.permission.READ_SYNC_STATS", "no permission to read the sync stats");
        if (this.mContext.checkCallingOrSelfPermission("android.permission.GET_ACCOUNTS") != 0) goto L5;
        boolean canAccessAccounts = true;
    L6:
        final int callingUid = Binder.getCallingUid();
        long identityToken = IContentService.Stub.clearCallingIdentity();
        List<SyncInfo> results = getSyncManager().getSyncStorageEngine().getCurrentSyncsCopy(userId, canAccessAccounts);     // Catch: Throwable -> L10
        IContentService.Stub.restoreCallingIdentity(identityToken);
        results.removeIf(new ContentService$$ExternalSyntheticLambda1(this, callingUid, userId));
        return results;
    L10:
        th = move-exception;
        IContentService.Stub.restoreCallingIdentity(identityToken);
        throw th;
    L5:
        canAccessAccounts = false;
        goto L6
    }

    private /* synthetic */ boolean lambda$getCurrentSyncsAsUser$1(int callingUid, int userId, SyncInfo i) {
        return !hasAuthorityAccess(i.authority, callingUid, userId);
    }

    public SyncStatusInfo getSyncStatus(Account account, String authority, ComponentName cname) {
        return getSyncStatusAsUser(account, authority, cname, UserHandle.getCallingUserId());
    }

    public SyncStatusInfo getSyncStatusAsUser(Account account, String authority, ComponentName cname, int userId) {
        if (TextUtils.isEmpty(authority) == true) goto L23;
        enforceCrossUserPermission(userId, "no permission to read the sync stats for user " + userId);
        this.mContext.enforceCallingOrSelfPermission("android.permission.READ_SYNC_STATS", "no permission to read the sync stats");
        int callingUid = Binder.getCallingUid();
        if (hasAccountAccess(true, account, callingUid) == true) goto L8;
        return null;
    L8:
        if (hasAuthorityAccess(authority, callingUid, userId) == true) goto L10;
        return null;
    L10:
        long identityToken = IContentService.Stub.clearCallingIdentity();
        if (account == null) goto L19;
        if (authority == null) goto L19;
        SyncStorageEngine.EndPoint info = new SyncStorageEngine.EndPoint(account, authority, userId);     // Catch: Throwable -> L16
        SyncStatusInfo r4 = getSyncManager().getSyncStorageEngine().getStatusByAuthority(info);     // Catch: Throwable -> L16
        IContentService.Stub.restoreCallingIdentity(identityToken);
        return r4;
    L19:
        throw new IllegalArgumentException("Must call sync status with valid authority");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        IContentService.Stub.restoreCallingIdentity(identityToken);
        throw th;
    L23:
        throw new IllegalArgumentException("Authority must not be empty");
    }

    public boolean isSyncPending(Account account, String authority, ComponentName cname) {
        return isSyncPendingAsUser(account, authority, cname, UserHandle.getCallingUserId());
    }

    public boolean isSyncPendingAsUser(Account account, String authority, ComponentName cname, int userId) {
        isSyncPendingAsUser_enforcePermission();
        enforceCrossUserPermission(userId, "no permission to retrieve the sync settings for user " + userId);
        int callingUid = Binder.getCallingUid();
        if (hasAccountAccess(true, account, callingUid) == true) goto L6;
        return false;
    L6:
        if (hasAuthorityAccess(authority, callingUid, userId) == true) goto L8;
        return false;
    L8:
        long identityToken = IContentService.Stub.clearCallingIdentity();
        if (account == null) goto L17;
        if (authority == null) goto L17;
        SyncStorageEngine.EndPoint info = new SyncStorageEngine.EndPoint(account, authority, userId);     // Catch: Throwable -> L14
        boolean r4 = getSyncManager().getSyncStorageEngine().isSyncPending(info);     // Catch: Throwable -> L14
        IContentService.Stub.restoreCallingIdentity(identityToken);
        return r4;
    L17:
        throw new IllegalArgumentException("Invalid authority specified");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        IContentService.Stub.restoreCallingIdentity(identityToken);
        throw th;
    }

    public void addStatusChangeListener(int mask, ISyncStatusObserver callback) {
        int callingUid = Binder.getCallingUid();
        long identityToken = IContentService.Stub.clearCallingIdentity();
        if (callback != null) goto L11;
    L9:
        IContentService.Stub.restoreCallingIdentity(identityToken);
        return;
    L11:
        getSyncManager().getSyncStorageEngine().addStatusChangeListener(mask, callingUid, callback);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        IContentService.Stub.restoreCallingIdentity(identityToken);
        throw th;
    }

    public void removeStatusChangeListener(ISyncStatusObserver callback) {
        long identityToken = IContentService.Stub.clearCallingIdentity();
        if (callback != null) goto L11;
    L9:
        IContentService.Stub.restoreCallingIdentity(identityToken);
        return;
    L11:
        getSyncManager().getSyncStorageEngine().removeStatusChangeListener(callback);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        IContentService.Stub.restoreCallingIdentity(identityToken);
        throw th;
    }

    private String getProviderPackageName(Uri uri, int userId) {
        ProviderInfo pi = this.mContext.getPackageManager().resolveContentProviderAsUser(uri.getAuthority(), 0, userId);
        if (pi != null) goto L7;
        return null;
    L7:
        return pi.packageName;
    }

    private ArrayMap<Pair<String, Uri>, Bundle> findOrCreateCacheLocked(int userId, String providerPackageName) {
        ArrayMap<String, ArrayMap<Pair<String, Uri>, Bundle>> userCache = this.mCache.get(userId);
        if (userCache != null) goto L5;
        userCache = new ArrayMap();
        this.mCache.put(userId, userCache);
    L5:
        ArrayMap<Pair<String, Uri>, Bundle> packageCache = userCache.get(providerPackageName);
        if (packageCache != null) goto L9;
        ArrayMap<Pair<String, Uri>, Bundle> packageCache2 = new ArrayMap();
        userCache.put(providerPackageName, packageCache2);
        return packageCache2;
    L9:
        return packageCache;
    }

    private void invalidateCacheLocked(int userId, String providerPackageName, Uri uri) {
        ArrayMap<String, ArrayMap<Pair<String, Uri>, Bundle>> userCache = this.mCache.get(userId);
        if (userCache != null) goto L5;
        return;
    L5:
        ArrayMap<Pair<String, Uri>, Bundle> packageCache = userCache.get(providerPackageName);
        if (packageCache != null) goto L8;
        return;
    L8:
        if (uri == null) goto L20;
        int i = 0;
    L11:
        if (i >= packageCache.size()) goto L29;
        Pair<String, Uri> key = packageCache.keyAt(i);
        if (key.second == null) goto L17;
        if (((Uri) key.second).toString().startsWith(uri.toString()) == false) goto L17;
        packageCache.removeAt(i);
    L17:
        i = i + 1;
        goto L11
    L29:
        return;
    L20:
        packageCache.clear();
    }

    public void putCache(String packageName, Uri key, Bundle value, int userId) {
        Bundle.setDefusable(value, true);
        enforceNonFullCrossUserPermission(userId, TAG);
        this.mContext.enforceCallingOrSelfPermission("android.permission.CACHE_CONTENT", TAG);
        ((AppOpsManager) this.mContext.getSystemService(AppOpsManager.class)).checkPackage(Binder.getCallingUid(), packageName);
        String providerPackageName = getProviderPackageName(key, userId);
        Pair<String, Uri> fullKey = Pair.create(packageName, key);
        SparseArray<ArrayMap<String, ArrayMap<Pair<String, Uri>, Bundle>>> r2 = this.mCache;
        monitor-enter(r2);
        ArrayMap<Pair<String, Uri>, Bundle> cache = findOrCreateCacheLocked(userId, providerPackageName);     // Catch: Throwable -> L7
        if (value == null) goto L9;
        cache.put(fullKey, value);     // Catch: Throwable -> L7
    L10:
        monitor-exit(r2);     // Catch: Throwable -> L7
        return;
    L9:
        cache.remove(fullKey);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public Bundle getCache(String packageName, Uri key, int userId) {
        enforceNonFullCrossUserPermission(userId, TAG);
        this.mContext.enforceCallingOrSelfPermission("android.permission.CACHE_CONTENT", TAG);
        ((AppOpsManager) this.mContext.getSystemService(AppOpsManager.class)).checkPackage(Binder.getCallingUid(), packageName);
        String providerPackageName = getProviderPackageName(key, userId);
        Pair<String, Uri> fullKey = Pair.create(packageName, key);
        SparseArray<ArrayMap<String, ArrayMap<Pair<String, Uri>, Bundle>>> r2 = this.mCache;
        monitor-enter(r2);
        ArrayMap<Pair<String, Uri>, Bundle> cache = findOrCreateCacheLocked(userId, providerPackageName);     // Catch: Throwable -> L7
        Bundle r4 = cache.get(fullKey);     // Catch: Throwable -> L7
        monitor-exit(r2);     // Catch: Throwable -> L7
        return r4;
    L7:
        th = move-exception;
        throw th;
    }

    private int handleIncomingUser(Uri uri, int pid, int uid, int modeFlags, boolean allowNonFull, int userId) {
        if (userId != (-2)) goto L5;
        int userId2 = ActivityManager.getCurrentUser();
    L6:
        String permissions = "android.permission.INTERACT_ACROSS_USERS_FULL";
        if (userId2 != (-1)) goto L9;
        this.mContext.enforceCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS_FULL", "No access to " + uri);
    L28:
        return userId2;
    L9:
        if (userId2 < 0) goto L30;
        if (userId2 == UserHandle.getCallingUserId()) goto L28;
        if (checkUriPermission(uri, pid, uid, modeFlags, userId2) == 0) goto L28;
        boolean allow = false;
        if (this.mContext.checkCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS_FULL") != 0) goto L17;
        allow = true;
    L21:
        if (allow == true) goto L28;
        if (allowNonFull == false) goto L26;
        permissions = "android.permission.INTERACT_ACROSS_USERS_FULL or android.permission.INTERACT_ACROSS_USERS";
    L26:
        throw new SecurityException("No access to " + uri + ": neither user " + uid + " nor current process has " + permissions);
    L17:
        if (allowNonFull == false) goto L21;
        if (this.mContext.checkCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS") != 0) goto L21;
        allow = true;
        goto L21
    L30:
        throw new IllegalArgumentException("Invalid user: " + userId2);
    L5:
        userId2 = userId;
        goto L6
    }

    private void enforceCrossUserPermission(int userHandle, String message) {
        int callingUser = UserHandle.getCallingUserId();
        if (callingUser == userHandle) goto L6;
        this.mContext.enforceCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS_FULL", message);
        return;
    }

    private void enforceNonFullCrossUserPermission(int userHandle, String message) {
        int callingUser = UserHandle.getCallingUserId();
        if (callingUser != userHandle) goto L5;
        return;
    L5:
        int interactAcrossUsersState = this.mContext.checkCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS");
        if (interactAcrossUsersState != 0) goto L8;
        return;
    L8:
        this.mContext.enforceCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS_FULL", message);
    }

    private boolean hasAccountAccess(boolean checkCompatFlag, Account account, int uid) {
        if (account != null) goto L6;
        return true;
    L6:
        if (checkCompatFlag == true) goto L8;
    L10:
        long identityToken = IContentService.Stub.clearCallingIdentity();
        boolean r2 = this.mAccountManagerInternal.hasAccountAccess(account, uid);     // Catch: Throwable -> L14
        IContentService.Stub.restoreCallingIdentity(identityToken);
        return r2;
    L14:
        th = move-exception;
        IContentService.Stub.restoreCallingIdentity(identityToken);
        throw th;
    L8:
        if (CompatChanges.isChangeEnabled(ACCOUNT_ACCESS_CHECK_CHANGE_ID, uid) == true) goto L10;
        return true;
    }

    private boolean hasAuthorityAccess(String authority, int uid, int userId) {
        if (TextUtils.isEmpty(authority) == false) goto L6;
        return true;
    L6:
        if (CompatChanges.isChangeEnabled(AUTHORITY_ACCESS_CHECK_CHANGE_ID, uid) == true) goto L8;
        return true;
    L8:
        String[] syncAdapterPackages = getSyncAdapterPackagesForAuthorityAsUser(authority, userId);
        return true ^ ArrayUtils.isEmpty(syncAdapterPackages);
    }

    private static int normalizeSyncable(int syncable) {
        if (syncable <= 0) goto L5;
        return 1;
    L5:
        if (syncable != 0) goto L8;
        return 0;
    L8:
        return -2;
    }

    private void validateExtras(int callingUid, Bundle extras) {
        if (extras.containsKey("v_exemption") == false) goto L8;
        switch(callingUid) {
            case 0: goto L9;
            case 1000: goto L9;
            case 2000: goto L9;
            default: goto L5;
        };
    L5:
        Log.w(TAG, "Invalid extras specified. requestsync -f/-F needs to run on 'adb shell'");
        throw new SecurityException("Invalid extras specified.");
    L9:
        return;
    }

    private int getSyncExemptionForCaller(int callingUid) {
        return getSyncExemptionAndCleanUpExtrasForCaller(callingUid, null);
    }

    private int getSyncExemptionAndCleanUpExtrasForCaller(int callingUid, Bundle extras) {
        if (extras == null) goto L6;
        int exemption = extras.getInt("v_exemption", -1);
        extras.remove("v_exemption");
        if (exemption == (-1)) goto L6;
        return exemption;
    L6:
        ActivityManagerInternal ami = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        if (ami != null) goto L9;
        return 0;
    L9:
        int procState = ami.getUidProcessState(callingUid);
        boolean isUidActive = ami.isUidActive(callingUid);
        if (procState > 2) goto L12;
    L21:
        return 2;
    L12:
        if (procState == 3) goto L21;
        if (procState <= 6) goto L19;
        if (isUidActive == true) goto L19;
        return 0;
    L19:
        FrameworkStatsLog.write(FrameworkStatsLog.SYNC_EXEMPTION_OCCURRED, callingUid, getProcStateForStatsd(procState), isUidActive, getRestrictionLevelForStatsd(ami.getRestrictionLevel(callingUid)));
        return 1;
    }

    private int getProcStateForStatsd(int procState) {
        switch(procState) {
            case -1: goto L43;
            case 0: goto L41;
            case 1: goto L39;
            case 2: goto L37;
            case 3: goto L35;
            case 4: goto L33;
            case 5: goto L31;
            case 6: goto L29;
            case 7: goto L27;
            case 8: goto L25;
            case 9: goto L23;
            case 10: goto L21;
            case 11: goto L19;
            case 12: goto L17;
            case 13: goto L15;
            case 14: goto L4;
            case 15: goto L13;
            case 16: goto L11;
            case 17: goto L9;
            case 18: goto L7;
            case 19: goto L5;
            default: goto L4;
        };
    L4:
        return 0;
    L5:
        return 20;
    L7:
        return 19;
    L9:
        return 18;
    L11:
        return 17;
    L13:
        return 16;
    L15:
        return 14;
    L17:
        return 13;
    L19:
        return 12;
    L21:
        return 11;
    L23:
        return 10;
    L25:
        return 9;
    L27:
        return 8;
    L29:
        return 7;
    L31:
        return 6;
    L33:
        return 5;
    L35:
        return 4;
    L37:
        return 3;
    L39:
        return 2;
    L41:
        return 1;
    L43:
        return 0;
    }

    private int getRestrictionLevelForStatsd(int level) {
        switch(level) {
            case 0: goto L17;
            case 10: goto L15;
            case 20: goto L13;
            case 30: goto L11;
            case 40: goto L9;
            case 50: goto L7;
            case 60: goto L5;
            default: goto L4;
        };
    L4:
        return 0;
    L5:
        return 6;
    L7:
        return 5;
    L9:
        return 4;
    L11:
        return 3;
    L13:
        return 2;
    L15:
        return 1;
    L17:
        return 0;
    }

    private void enforceShell(String method) {
        int callingUid = Binder.getCallingUid();
        if (callingUid == 2000) goto L8;
        if (callingUid != 0) goto L7;
        return;
    L7:
        throw new SecurityException("Non-shell user attempted to call " + method);
    }

    public void resetTodayStats() {
        enforceShell("resetTodayStats");
        if (this.mSyncManager == null) goto L10;
        long token = Binder.clearCallingIdentity();
        this.mSyncManager.resetTodayStats();     // Catch: Throwable -> L7
        Binder.restoreCallingIdentity(token);
        return;
    L7:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public void onDbCorruption(String tag, String message, String stacktrace) {
        Slog.e(tag, message);
        Slog.e(tag, "at " + stacktrace);
        Slog.wtf(tag, message);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
        new ContentShellCommand(this).exec(this, in, out, err, args, callback, resultReceiver);
    }
}
