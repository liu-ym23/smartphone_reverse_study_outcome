package com.android.server.appop;

import android.app.AppOpsManager;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.LongSparseArray;
import android.util.Pools;
import android.util.Slog;
import com.android.internal.util.function.pooled.PooledLambda;
import com.bytedance.security.behaviorrecord.BDAppBehaviorRecordManager;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes.dex */
final class AttributedOp {
    private LongSparseArray<AppOpsManager.NoteOpEvent> mAccessEvents;
    private BDAppBehaviorRecordManager mAppBehaviorRecordManager;
    private final AppOpsService mAppOpsService;
    ArrayMap<IBinder, InProgressStartOpEvent> mInProgressEvents;
    ArrayMap<IBinder, InProgressStartOpEvent> mPausedInProgressEvents;
    private LongSparseArray<AppOpsManager.NoteOpEvent> mRejectEvents;
    public final AppOpsService.Op parent;
    public final String persistentDeviceId;
    public final String tag;

    static final class InProgressStartOpEvent implements IBinder.DeathRecipient {
        private int mAttributionChainId;
        private int mAttributionFlags;
        private String mAttributionTag;
        private IBinder mClientId;
        private int mFlags;
        int mNumUnfinishedStarts;
        private Runnable mOnDeath;
        private AppOpsManager.OpEventProxyInfo mProxy;
        private long mStartElapsedTime;
        private long mStartTime;
        private int mUidState;
        private int mVirtualDeviceId;

        InProgressStartOpEvent(long startTime, long startElapsedTime, IBinder clientId, int virtualDeviceId, String attributionTag, Runnable onDeath, int uidState, AppOpsManager.OpEventProxyInfo proxy, int flags, int attributionFlags, int attributionChainId) throws RemoteException {
            this.mStartTime = startTime;
            this.mStartElapsedTime = startElapsedTime;
            this.mClientId = clientId;
            this.mVirtualDeviceId = virtualDeviceId;
            this.mAttributionTag = attributionTag;
            this.mOnDeath = onDeath;
            this.mUidState = uidState;
            this.mProxy = proxy;
            this.mFlags = flags;
            this.mAttributionFlags = attributionFlags;
            this.mAttributionChainId = attributionChainId;
            clientId.linkToDeath(this, 0);
        }

        public void finish() {
            this.mClientId.unlinkToDeath(this, 0);     // Catch: NoSuchElementException -> L4
            return;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            this.mOnDeath.run();
        }

        public void reinit(long startTime, long startElapsedTime, IBinder clientId, String attributionTag, int virtualDeviceId, Runnable onDeath, int uidState, int flags, AppOpsManager.OpEventProxyInfo proxy, int attributionFlags, int attributionChainId, Pools.Pool<AppOpsManager.OpEventProxyInfo> proxyPool) throws RemoteException {
            this.mStartTime = startTime;
            this.mStartElapsedTime = startElapsedTime;
            this.mClientId = clientId;
            this.mAttributionTag = attributionTag;
            this.mOnDeath = onDeath;
            this.mVirtualDeviceId = virtualDeviceId;
            this.mUidState = uidState;
            this.mFlags = flags;
            if (this.mProxy == null) goto L5;
            proxyPool.release(this.mProxy);
        L5:
            this.mProxy = proxy;
            this.mAttributionFlags = attributionFlags;
            this.mAttributionChainId = attributionChainId;
            clientId.linkToDeath(this, 0);
        }

        public long getStartTime() {
            return this.mStartTime;
        }

        public long getStartElapsedTime() {
            return this.mStartElapsedTime;
        }

        public IBinder getClientId() {
            return this.mClientId;
        }

        public int getUidState() {
            return this.mUidState;
        }

        public AppOpsManager.OpEventProxyInfo getProxy() {
            return this.mProxy;
        }

        public int getFlags() {
            return this.mFlags;
        }

        public int getAttributionFlags() {
            return this.mAttributionFlags;
        }

        public int getAttributionChainId() {
            return this.mAttributionChainId;
        }

        public int getVirtualDeviceId() {
            return this.mVirtualDeviceId;
        }

        public void setStartTime(long startTime) {
            this.mStartTime = startTime;
        }

        public void setStartElapsedTime(long startElapsedTime) {
            this.mStartElapsedTime = startElapsedTime;
        }
    }

    static class InProgressStartOpEventPool extends Pools.SimplePool<InProgressStartOpEvent> {
        private OpEventProxyInfoPool mOpEventProxyInfoPool;

        InProgressStartOpEventPool(OpEventProxyInfoPool opEventProxyInfoPool, int maxUnusedPooledObjects) {
            super(maxUnusedPooledObjects);
            this.mOpEventProxyInfoPool = opEventProxyInfoPool;
        }

        InProgressStartOpEvent acquire(long startTime, long elapsedTime, IBinder clientId, String attributionTag, int virtualDeviceId, Runnable onDeath, int proxyUid, String proxyPackageName, String proxyAttributionTag, String proxyDeviceId, int uidState, int flags, int attributionFlags, int attributionChainId) throws RemoteException {
            InProgressStartOpEvent recycled = (InProgressStartOpEvent) acquire();
            if (proxyUid == (-1)) goto L5;
            AppOpsManager.OpEventProxyInfo proxyInfo = this.mOpEventProxyInfoPool.acquire(proxyUid, proxyPackageName, proxyAttributionTag, proxyDeviceId);
            AppOpsManager.OpEventProxyInfo proxyInfo2 = proxyInfo;
        L6:
            if (recycled == null) goto L10;
            recycled.reinit(startTime, elapsedTime, clientId, attributionTag, virtualDeviceId, onDeath, uidState, flags, proxyInfo2, attributionFlags, attributionChainId, this.mOpEventProxyInfoPool);
            return recycled;
        L10:
            return new InProgressStartOpEvent(startTime, elapsedTime, clientId, virtualDeviceId, attributionTag, onDeath, uidState, proxyInfo2, flags, attributionFlags, attributionChainId);
        L5:
            proxyInfo2 = null;
            goto L6
        }
    }

    static class OpEventProxyInfoPool extends Pools.SimplePool<AppOpsManager.OpEventProxyInfo> {
        OpEventProxyInfoPool(int maxUnusedPooledObjects) {
            super(maxUnusedPooledObjects);
        }

        AppOpsManager.OpEventProxyInfo acquire(int uid, String packageName, String attributionTag, String deviceId) {
            AppOpsManager.OpEventProxyInfo recycled = (AppOpsManager.OpEventProxyInfo) acquire();
            if (recycled == null) goto L7;
            recycled.reinit(uid, packageName, attributionTag, deviceId);
            return recycled;
        L7:
            return new AppOpsManager.OpEventProxyInfo(uid, packageName, attributionTag, deviceId);
        }
    }

    AttributedOp(AppOpsService appOpsService, String tag, String persistentDeviceId, AppOpsService.Op parent) {
        this.mAppOpsService = appOpsService;
        this.tag = tag;
        this.persistentDeviceId = persistentDeviceId;
        this.parent = parent;
        this.mAppBehaviorRecordManager = new BDAppBehaviorRecordManager();
    }

    public void accessed(int proxyUid, String proxyPackageName, String proxyAttributionTag, String proxyDeviceId, int uidState, int flags, int accessCount) {
        long accessTime = System.currentTimeMillis();
        accessed(accessTime, -1, proxyUid, proxyPackageName, proxyAttributionTag, proxyDeviceId, uidState, flags);
        long identity = Binder.clearCallingIdentity();
        this.mAppBehaviorRecordManager.recordBehavior(accessTime, this.parent.op, this.parent.packageName, this.parent.uid, uidState, 1);     // Catch: Throwable -> L8
        Binder.restoreCallingIdentity(identity);
        this.mAppOpsService.mHistoricalRegistry.incrementOpAccessedCount(this.parent.op, this.parent.uid, this.parent.packageName, this.persistentDeviceId, this.tag, uidState, flags, accessTime, 0, -1, accessCount);
        return;
    L8:
        th = th;
    L11:
        Binder.restoreCallingIdentity(identity);
        throw th;
    L10:
        th = th;
        goto L11
    }

    public void accessed(long noteTime, long duration, int proxyUid, String proxyPackageName, String proxyAttributionTag, String proxyDeviceId, int uidState, int flags) {
        long key = AppOpsManager.makeKey(uidState, flags);
        if (this.mAccessEvents != null) goto L6;
        this.mAccessEvents = new LongSparseArray(1);
    L6:
        if (proxyUid == (-1)) goto L8;
        AppOpsManager.OpEventProxyInfo proxyInfo = this.mAppOpsService.mOpEventProxyInfoPool.acquire(proxyUid, proxyPackageName, proxyAttributionTag, proxyDeviceId);
        AppOpsManager.OpEventProxyInfo proxyInfo2 = proxyInfo;
    L9:
        AppOpsManager.NoteOpEvent existingEvent = this.mAccessEvents.get(key);
        if (existingEvent == null) goto L12;
        existingEvent.reinit(noteTime, duration, proxyInfo2, this.mAppOpsService.mOpEventProxyInfoPool);
        return;
    L12:
        this.mAccessEvents.put(key, new AppOpsManager.NoteOpEvent(noteTime, duration, proxyInfo2));
        return;
    L8:
        proxyInfo2 = null;
        goto L9
    }

    public void rejected(int uidState, int flags) {
        rejected(System.currentTimeMillis(), uidState, flags);
        long identity = Binder.clearCallingIdentity();
        this.mAppBehaviorRecordManager.recordBehavior(System.currentTimeMillis(), this.parent.op, this.parent.packageName, this.parent.uid, uidState, 2);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        this.mAppOpsService.mHistoricalRegistry.incrementOpRejectedCount(this.parent.op, this.parent.uid, this.parent.packageName, this.tag, uidState, flags);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public void rejected(long noteTime, int uidState, int flags) {
        long key = AppOpsManager.makeKey(uidState, flags);
        if (this.mRejectEvents != null) goto L5;
        this.mRejectEvents = new LongSparseArray(1);
    L5:
        AppOpsManager.NoteOpEvent existingEvent = this.mRejectEvents.get(key);
        if (existingEvent == null) goto L8;
        existingEvent.reinit(noteTime, -1, null, this.mAppOpsService.mOpEventProxyInfoPool);
        return;
    L8:
        this.mRejectEvents.put(key, new AppOpsManager.NoteOpEvent(noteTime, -1, null));
    }

    public void started(IBinder clientId, int virtualDeviceId, int proxyUid, String proxyPackageName, String proxyAttributionTag, String proxyDeviceId, int uidState, int flags, int attributionFlags, int attributionChainId) throws RemoteException {
        startedOrPaused(clientId, virtualDeviceId, proxyUid, proxyPackageName, proxyAttributionTag, proxyDeviceId, uidState, flags, attributionFlags, attributionChainId, false, true);
    }

    private void startedOrPaused(IBinder clientId, int virtualDeviceId, int proxyUid, String proxyPackageName, String proxyAttributionTag, String proxyDeviceId, int uidState, int flags, int attributionFlags, int attributionChainId, boolean triggeredByUidStateChange, boolean isStarted) throws RemoteException {
        if (triggeredByUidStateChange == true) goto L9;
        if (this.parent.isRunning() == true) goto L9;
        if (isStarted == false) goto L9;
        this.mAppOpsService.scheduleOpActiveChangedIfNeededLocked(this.parent.op, this.parent.uid, this.parent.packageName, this.tag, virtualDeviceId, true, attributionFlags, attributionChainId);
    L9:
        if (isStarted == true) goto L11;
    L13:
        if (isStarted == false) goto L15;
    L17:
        if (isStarted == false) goto L19;
        ArrayMap<IBinder, InProgressStartOpEvent> events = this.mInProgressEvents;
    L20:
        long startTime = System.currentTimeMillis();
        InProgressStartOpEvent event = events.get(clientId);
        if (event != null) goto L23;
        ArrayMap<IBinder, InProgressStartOpEvent> events2 = events;
        InProgressStartOpEvent event2 = this.mAppOpsService.mInProgressStartOpEventPool.acquire(startTime, SystemClock.elapsedRealtime(), clientId, this.tag, virtualDeviceId, PooledLambda.obtainRunnable(new AttributedOp$$ExternalSyntheticLambda0(), this, clientId), proxyUid, proxyPackageName, proxyAttributionTag, proxyDeviceId, uidState, flags, attributionFlags, attributionChainId);
        int r8 = uidState;
        events2.put(clientId, event2);
        InProgressStartOpEvent event3 = event2;
        AttributedOp r2 = this;
    L28:
        event3.mNumUnfinishedStarts++;
        if (isStarted == false) goto L37;
        AttributedOp r1 = r2;
        InProgressStartOpEvent event4 = event3;
        r2.mAppOpsService.mHistoricalRegistry.incrementOpAccessedCount(r2.parent.op, r2.parent.uid, r2.parent.packageName, r2.persistentDeviceId, r2.tag, r8, flags, startTime, attributionFlags, attributionChainId, 1);
        long identity = Binder.clearCallingIdentity();
        r1.mAppBehaviorRecordManager.recordBehavior(System.currentTimeMillis(), r1.parent.op, r1.parent.packageName, r1.parent.uid, event4.getUidState(), 1);     // Catch: Throwable -> L33
        Binder.restoreCallingIdentity(identity);
        return;
    L33:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L37:
        return;
    L23:
        r8 = uidState;
        events2 = events;
        if (r8 == event.getUidState()) goto L26;
        r2 = this;
        r2.onUidStateChanged(r8);
    L27:
        event3 = event;
        goto L28
    L26:
        r2 = this;
        goto L27
    L19:
        events = this.mPausedInProgressEvents;
        goto L20
    L15:
        if (this.mPausedInProgressEvents != null) goto L17;
        this.mPausedInProgressEvents = new ArrayMap(1);
        goto L17
    L11:
        if (this.mInProgressEvents != null) goto L13;
        this.mInProgressEvents = new ArrayMap(1);
        goto L17
    }

    public void doForAllInProgressStartOpEvents(Consumer<InProgressStartOpEvent> action) {
        if (isPaused() == false) goto L5;
        ArrayMap<IBinder, InProgressStartOpEvent> events = this.mPausedInProgressEvents;
    L6:
        if (events != null) goto L8;
        return;
    L8:
        int numStartedOps = events.size();
        ArraySet<IBinder> keys = new ArraySet(events.keySet());
        int i = 0;
    L9:
        if (i >= numStartedOps) goto L12;
        action.accept(events.get(keys.valueAt(i)));
        i = i + 1;
        goto L9
    L12:
        return;
    L5:
        events = this.mInProgressEvents;
        goto L6
    }

    public void finished(IBinder clientId) {
        finished(clientId, false);
    }

    private void finished(IBinder clientId, boolean triggeredByUidStateChange) {
        finishOrPause(clientId, triggeredByUidStateChange, false);
    }

    private void finishOrPause(IBinder clientId, boolean triggeredByUidStateChange, boolean isPausing) {
        if (isRunning() == false) goto L5;
        int indexOfToken = this.mInProgressEvents.indexOfKey(clientId);
    L6:
        if (indexOfToken >= 0) goto L9;
        finishPossiblyPaused(clientId, isPausing);
        return;
    L9:
        InProgressStartOpEvent event = this.mInProgressEvents.valueAt(indexOfToken);
        if (isPausing == true) goto L13;
        event.mNumUnfinishedStarts--;
    L13:
        if (event.mNumUnfinishedStarts == 0) goto L15;
        if (isPausing == true) goto L15;
        return;
    L15:
        if (isPausing == true) goto L18;
        event.finish();
        this.mInProgressEvents.removeAt(indexOfToken);
    L18:
        if (this.mAccessEvents != null) goto L21;
        this.mAccessEvents = new LongSparseArray(1);
    L21:
        if (event.getProxy() == null) goto L23;
        AppOpsManager.OpEventProxyInfo r5 = new AppOpsManager.OpEventProxyInfo(event.getProxy());
    L24:
        AppOpsManager.OpEventProxyInfo proxyCopy = r5;
        long accessDurationMillis = SystemClock.elapsedRealtime() - event.getStartElapsedTime();
        AppOpsManager.NoteOpEvent finishedEvent = new AppOpsManager.NoteOpEvent(event.getStartTime(), accessDurationMillis, proxyCopy);
        this.mAccessEvents.put(AppOpsManager.makeKey(event.getUidState(), event.getFlags()), finishedEvent);
        this.mAppOpsService.mHistoricalRegistry.increaseOpAccessDuration(this.parent.op, this.parent.uid, this.parent.packageName, this.persistentDeviceId, this.tag, event.getUidState(), event.getFlags(), finishedEvent.getNoteTime(), finishedEvent.getDuration(), event.getAttributionFlags(), event.getAttributionChainId());
        if (isPausing == true) goto L35;
        this.mAppOpsService.mInProgressStartOpEventPool.release(event);
        if (this.mInProgressEvents.isEmpty() == false) goto L36;
        this.mInProgressEvents = null;
        if (triggeredByUidStateChange == false) goto L31;
        return;
    L31:
        if (this.parent.isRunning() == true) goto L38;
        this.mAppOpsService.scheduleOpActiveChangedIfNeededLocked(this.parent.op, this.parent.uid, this.parent.packageName, this.tag, event.getVirtualDeviceId(), false, event.getAttributionFlags(), event.getAttributionChainId());
        return;
    L38:
        return;
    L36:
        return;
    L35:
        return;
    L23:
        r5 = null;
        goto L24
    L5:
        indexOfToken = -1;
        goto L6
    }

    private void finishPossiblyPaused(IBinder clientId, boolean isPausing) {
        if (isPaused() == true) goto L6;
        Slog.wtf("AppOps", "No ops running or paused");
        return;
    L6:
        int indexOfToken = this.mPausedInProgressEvents.indexOfKey(clientId);
        if (indexOfToken >= 0) goto L10;
        Slog.wtf("AppOps", "No op running or paused for the client");
        return;
    L10:
        if (isPausing == false) goto L12;
        return;
    L12:
        InProgressStartOpEvent event = this.mPausedInProgressEvents.valueAt(indexOfToken);
        event.mNumUnfinishedStarts--;
        if (event.mNumUnfinishedStarts != 0) goto L18;
        this.mPausedInProgressEvents.removeAt(indexOfToken);
        this.mAppOpsService.mInProgressStartOpEventPool.release(event);
        if (this.mPausedInProgressEvents.isEmpty() == false) goto L19;
        this.mPausedInProgressEvents = null;
        return;
    L19:
        return;
    }

    public void createPaused(IBinder clientId, int virtualDeviceId, int proxyUid, String proxyPackageName, String proxyAttributionTag, String proxyDeviceId, int uidState, int flags, int attributionFlags, int attributionChainId) throws RemoteException {
        startedOrPaused(clientId, virtualDeviceId, proxyUid, proxyPackageName, proxyAttributionTag, proxyDeviceId, uidState, flags, attributionFlags, attributionChainId, false, false);
    }

    public void pause() {
        if (isRunning() == true) goto L6;
        return;
    L6:
        if (this.mPausedInProgressEvents != null) goto L8;
        this.mPausedInProgressEvents = new ArrayMap(1);
    L8:
        int i = 0;
    L10:
        if (i >= this.mInProgressEvents.size()) goto L12;
        InProgressStartOpEvent event = this.mInProgressEvents.valueAt(i);
        this.mPausedInProgressEvents.put(event.getClientId(), event);
        finishOrPause(event.getClientId(), false, true);
        this.mAppOpsService.scheduleOpActiveChangedIfNeededLocked(this.parent.op, this.parent.uid, this.parent.packageName, this.tag, event.getVirtualDeviceId(), false, event.getAttributionFlags(), event.getAttributionChainId());
        i = i + 1;
        goto L10
    L12:
        this.mInProgressEvents = null;
    }

    public void resume() {
        if (isPaused() == true) goto L6;
        return;
    L6:
        if (this.mInProgressEvents != null) goto L9;
        this.mInProgressEvents = new ArrayMap(this.mPausedInProgressEvents.size());
    L9:
        if (this.mPausedInProgressEvents.isEmpty() == false) goto L11;
    L13:
        boolean shouldSendActive = false;
    L14:
        long startTime = System.currentTimeMillis();
        int i = 0;
    L16:
        if (i >= this.mPausedInProgressEvents.size()) goto L21;
        InProgressStartOpEvent event = this.mPausedInProgressEvents.valueAt(i);
        this.mInProgressEvents.put(event.getClientId(), event);
        event.setStartElapsedTime(SystemClock.elapsedRealtime());
        event.setStartTime(startTime);
        this.mAppOpsService.mHistoricalRegistry.incrementOpAccessedCount(this.parent.op, this.parent.uid, this.parent.packageName, this.persistentDeviceId, this.tag, event.getUidState(), event.getFlags(), startTime, event.getAttributionFlags(), event.getAttributionChainId(), 1);
        if (shouldSendActive == false) goto L20;
        this.mAppOpsService.scheduleOpActiveChangedIfNeededLocked(this.parent.op, this.parent.uid, this.parent.packageName, this.tag, event.getVirtualDeviceId(), true, event.getAttributionFlags(), event.getAttributionChainId());
    L20:
        this.mAppOpsService.scheduleOpStartedIfNeededLocked(this.parent.op, this.parent.uid, this.parent.packageName, this.tag, event.getVirtualDeviceId(), event.getFlags(), 0, 2, event.getAttributionFlags(), event.getAttributionChainId());
        i = i + 1;
        goto L16
    L21:
        this.mPausedInProgressEvents = null;
        return;
    L11:
        if (this.mInProgressEvents.isEmpty() == false) goto L13;
        shouldSendActive = true;
        goto L14
    }

    void onClientDeath(IBinder clientId) {
        AppOpsService r0 = this.mAppOpsService;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (isPaused() == true) goto L13;
        if (isRunning() == true) goto L13;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L13:
        if (isPaused() == false) goto L15;
        ArrayMap<IBinder, InProgressStartOpEvent> events = this.mPausedInProgressEvents;     // Catch: Throwable -> L10
    L16:
        InProgressStartOpEvent deadEvent = events.get(clientId);     // Catch: Throwable -> L10
        if (deadEvent == null) goto L19;
        deadEvent.mNumUnfinishedStarts = 1;     // Catch: Throwable -> L10
    L19:
        finished(clientId);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L15:
        events = this.mInProgressEvents;     // Catch: Throwable -> L10
        goto L16
    }

    public void onUidStateChanged(int newState) {
        AttributedOp r1 = this;
        if (r1.isPaused() == false) goto L5;
    L7:
        boolean isRunning = r1.isRunning();
        if (isRunning == false) goto L10;
        ArrayMap<IBinder, InProgressStartOpEvent> events = r1.mInProgressEvents;
    L11:
        int i = events.size();
        List<IBinder> binders = new ArrayList(events.keySet());
        int i2 = 0;
        ArrayMap<IBinder, InProgressStartOpEvent> events2 = events;
    L12:
        if (i2 >= i) goto L84;
        InProgressStartOpEvent event = events2.get(binders.get(i2));
        if (event != null) goto L16;
    L81:
        int numInProgressEvents = i;
        int numInProgressEvents2 = i2;
        events2 = events2;
    L82:
        i2 = numInProgressEvents2 + 1;
        i = numInProgressEvents;
        goto L12
    L16:
        if (event.getUidState() == newState) goto L81;
        int eventAttributionFlags = event.getAttributionFlags();
        int eventAttributionChainId = event.getAttributionChainId();
        int numPreviousUnfinishedStarts = event.mNumUnfinishedStarts;     // Catch: RemoteException -> L78
        event.mNumUnfinishedStarts = 1;     // Catch: RemoteException -> L78
        AppOpsManager.OpEventProxyInfo proxy = event.getProxy();     // Catch: RemoteException -> L78
        r1.finished(event.getClientId(), true);     // Catch: RemoteException -> L78
        if (proxy == null) goto L61;
        ArrayMap<IBinder, InProgressStartOpEvent> events3 = events2;
        IBinder r2 = event.getClientId();     // Catch: RemoteException -> L59
        int i3 = i2;
        int i4 = event.getVirtualDeviceId();     // Catch: RemoteException -> L57
        int r4 = proxy.getUid();     // Catch: RemoteException -> L55
        String r5 = proxy.getPackageName();     // Catch: RemoteException -> L53
        String r6 = proxy.getAttributionTag();     // Catch: RemoteException -> L51
        String r7 = proxy.getDeviceId();     // Catch: RemoteException -> L49
        int r9 = event.getFlags();     // Catch: RemoteException -> L47
        int i5 = event.getAttributionFlags();     // Catch: RemoteException -> L45
        ArrayMap<IBinder, InProgressStartOpEvent> events4 = events3;
        numInProgressEvents = i;
        numInProgressEvents2 = i3;
        InProgressStartOpEvent event2 = event;
        r1.startedOrPaused(r2, i4, r4, r5, r6, r7, newState, r9, i5, event.getAttributionChainId(), true, isRunning);     // Catch: RemoteException -> L40
        r1 = this;
    L65:
        if (isRunning == true) goto L97;
        events2 = r1.mPausedInProgressEvents;     // Catch: RemoteException -> L67
    L93:
        InProgressStartOpEvent newEvent = events2.get(binders.get(numInProgressEvents2));     // Catch: RemoteException -> L75
        if (newEvent == null) goto L82;
        newEvent.mNumUnfinishedStarts += numPreviousUnfinishedStarts - 1;     // Catch: RemoteException -> L75
    L80:
        r1.mAppOpsService.scheduleOpActiveChangedIfNeededLocked(r1.parent.op, r1.parent.uid, r1.parent.packageName, r1.tag, event2.getVirtualDeviceId(), false, eventAttributionFlags, eventAttributionChainId);
        goto L82
    L97:
        events2 = r1.mInProgressEvents;     // Catch: RemoteException -> L67
    L42:
        events2 = events4;
    L41:
        r1 = this;
    L44:
        numInProgressEvents = i;
        numInProgressEvents2 = i3;
        event2 = event;
        r1 = this;
        events2 = events3;
    L46:
        event2 = event;
        numInProgressEvents = i;
        numInProgressEvents2 = i3;
        r1 = this;
        events2 = events3;
    L48:
        event2 = event;
        numInProgressEvents = i;
        numInProgressEvents2 = i3;
        r1 = this;
        events2 = events3;
    L50:
        event2 = event;
        numInProgressEvents = i;
        numInProgressEvents2 = i3;
        r1 = this;
        events2 = events3;
    L52:
        event2 = event;
        numInProgressEvents = i;
        numInProgressEvents2 = i3;
        r1 = this;
        events2 = events3;
    L54:
        event2 = event;
        numInProgressEvents = i;
        numInProgressEvents2 = i3;
        r1 = this;
        events2 = events3;
    L56:
        event2 = event;
        numInProgressEvents = i;
        numInProgressEvents2 = i3;
        r1 = this;
        events2 = events3;
    L58:
        event2 = event;
        numInProgressEvents = i;
        numInProgressEvents2 = i3;
        r1 = this;
        events2 = events3;
    L60:
        event2 = event;
        numInProgressEvents = i;
        numInProgressEvents2 = i2;
        r1 = this;
        events2 = events3;
        goto L80
    L61:
        events4 = events2;
        event2 = event;
        numInProgressEvents = i;
        numInProgressEvents2 = i2;
        r1 = this;
        r1.startedOrPaused(event2.getClientId(), event2.getVirtualDeviceId(), -1, null, null, null, newState, event2.getFlags(), event2.getAttributionFlags(), event2.getAttributionChainId(), true, isRunning);     // Catch: RemoteException -> L67
    L79:
        event2 = event;
        numInProgressEvents = i;
        numInProgressEvents2 = i2;
        goto L80
    L84:
        return;
    L10:
        events = r1.mPausedInProgressEvents;
        goto L11
    L5:
        if (r1.isRunning() == true) goto L7;
    }

    private LongSparseArray<AppOpsManager.NoteOpEvent> add(LongSparseArray<AppOpsManager.NoteOpEvent> a, LongSparseArray<AppOpsManager.NoteOpEvent> b) {
        if (a != null) goto L4;
        return b;
    L4:
        if (b != null) goto L6;
        return a;
    L6:
        int numEventsToAdd = b.size();
        int i = 0;
    L7:
        if (i >= numEventsToAdd) goto L15;
        long keyOfEventToAdd = b.keyAt(i);
        AppOpsManager.NoteOpEvent bEvent = b.valueAt(i);
        AppOpsManager.NoteOpEvent aEvent = a.get(keyOfEventToAdd);
        if (aEvent != null) goto L11;
    L12:
        a.put(keyOfEventToAdd, bEvent);
    L13:
        i = i + 1;
        goto L7
    L11:
        if (bEvent.getNoteTime() <= aEvent.getNoteTime()) goto L13;
    L15:
        return a;
    }

    public void add(AttributedOp opToAdd) {
        if (opToAdd.isRunning() == true) goto L7;
        if (opToAdd.isPaused() == true) goto L7;
    L13:
        this.mAccessEvents = add(this.mAccessEvents, opToAdd.mAccessEvents);
        this.mRejectEvents = add(this.mRejectEvents, opToAdd.mRejectEvents);
        return;
    L7:
        if (opToAdd.isRunning() == false) goto L9;
        ArrayMap<IBinder, InProgressStartOpEvent> ignoredEvents = opToAdd.mInProgressEvents;
    L10:
        Slog.w("AppOps", "Ignoring " + ignoredEvents.size() + " app-ops, running: " + opToAdd.isRunning());
        int numInProgressEvents = ignoredEvents.size();
        int i = 0;
    L11:
        if (i >= numInProgressEvents) goto L13;
        InProgressStartOpEvent event = ignoredEvents.valueAt(i);
        event.finish();
        this.mAppOpsService.mInProgressStartOpEventPool.release(event);
        i = i + 1;
        goto L11
    L9:
        ignoredEvents = opToAdd.mPausedInProgressEvents;
        goto L10
    }

    public boolean isRunning() {
        if (this.mInProgressEvents != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mInProgressEvents.isEmpty() == true) goto L7;
        return true;
    }

    public boolean isPaused() {
        if (this.mPausedInProgressEvents != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mPausedInProgressEvents.isEmpty() == true) goto L7;
        return true;
    }

    public boolean hasInProgressEvent(Predicate<InProgressStartOpEvent> predicate) {
        if (isPaused() == false) goto L5;
        ArrayMap<IBinder, InProgressStartOpEvent> events = this.mPausedInProgressEvents;
    L7:
        if (events != null) goto L9;
    L21:
        return false;
    L9:
        if (events.isEmpty() == true) goto L21;
        int i = 0;
    L13:
        if (i >= events.size()) goto L20;
        if (predicate.test(events.valueAt(i)) == true) goto L16;
        i = i + 1;
        goto L13
    L16:
        return true;
    L20:
        return false;
    L5:
        events = this.mInProgressEvents;
        goto L7
    }

    boolean hasAnyTime() {
        if (this.mAccessEvents == null) goto L7;
        if (this.mAccessEvents.size() <= 0) goto L7;
    L10:
        return true;
    L7:
        if (this.mRejectEvents != null) goto L9;
    L11:
        return false;
    L9:
        if (this.mRejectEvents.size() <= 0) goto L11;
        goto L10
    }

    private LongSparseArray<AppOpsManager.NoteOpEvent> deepClone(LongSparseArray<AppOpsManager.NoteOpEvent> original) {
        if (original != null) goto L4;
        return original;
    L4:
        int size = original.size();
        LongSparseArray<AppOpsManager.NoteOpEvent> clone = new LongSparseArray(size);
        int i = 0;
    L5:
        if (i >= size) goto L8;
        clone.put(original.keyAt(i), new AppOpsManager.NoteOpEvent(original.valueAt(i)));
        i = i + 1;
        goto L5
    L8:
        return clone;
    }

    AppOpsManager.AttributedOpEntry createAttributedOpEntryLocked() {
        LongSparseArray<AppOpsManager.NoteOpEvent> accessEvents = deepClone(this.mAccessEvents);
        if (isRunning() == false) goto L10;
        long now = SystemClock.elapsedRealtime();
        int numInProgressEvents = this.mInProgressEvents.size();
        if (accessEvents != null) goto L7;
        accessEvents = new LongSparseArray(numInProgressEvents);
    L7:
        int i = 0;
    L8:
        if (i >= numInProgressEvents) goto L10;
        InProgressStartOpEvent event = this.mInProgressEvents.valueAt(i);
        accessEvents.append(AppOpsManager.makeKey(event.getUidState(), event.getFlags()), new AppOpsManager.NoteOpEvent(event.getStartTime(), Math.max(now - event.getStartElapsedTime(), 0), event.getProxy()));
        i = i + 1;
    L10:
        LongSparseArray<AppOpsManager.NoteOpEvent> rejectEvents = deepClone(this.mRejectEvents);
        return new AppOpsManager.AttributedOpEntry(this.parent.op, isRunning(), accessEvents, rejectEvents);
    }
}
