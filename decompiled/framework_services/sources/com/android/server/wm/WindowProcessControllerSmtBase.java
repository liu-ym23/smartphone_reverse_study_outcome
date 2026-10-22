package com.android.server.wm;

import android.app.IApplicationThread;
import android.content.res.Configuration;
import android.util.Slog;
import android.util.SparseArray;
import com.android.internal.util.function.pooled.PooledLambda;
import com.android.server.SysOptBridge;
import com.android.server.am.IApplicationFreezer;
import com.android.server.am.ProcessRecord;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class WindowProcessControllerSmtBase extends ConfigurationContainerSysEx {
    public static final int COLD_LAUNCH_FOR_UNFREEZE = 1;
    public static final int HOT_LAUNCH_FOR_UNFREEZE = 2;
    private static final String TAG_FREEZE = "AMS.Freeze";
    public static final int UFR_DESTROY_ACTIVITY = 8;
    public static final int UFR_NONE = 0;
    public static final int UFR_RESUME_ACTIVITY = 2;
    public static final int UFR_START_ACTIVITY = 1;
    public static final int UFR_UPDATE_VISIBILITY = 4;
    private final String EMPTY_DES;
    private final int UNMARKED_UID;
    Configuration configuration;
    public boolean freezeFromPrefetch;
    int freezingStat;
    public boolean hasBackgroundActivity;
    public WindowProcessController host;
    public boolean hotLaunchStage;
    public boolean isColdLaunchDone;
    public boolean launchFromPrefetchUnfreeze;
    protected WindowProcessListener listener;
    protected ActivityTaskManagerService mAtm;
    public ActivityTaskManagerServiceSmtBase mAtmsmt;
    private Object mMarkedLock;
    public Configuration mSmtFreeFormConfig;
    public int mTopDisplayType;
    public String nPkg;
    public int nUid;
    SparseArray<ArrayList<FrozenPendingEvent>> pendingEvents;
    public boolean previous;
    public int realPid;
    protected IApplicationThread thread;
    public int unFreezeForLaunchType;
    public int unfreezeReason;

    /* JADX INFO: renamed from: com.android.server.wm.WindowProcessControllerSmtBase$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$android$server$am$IApplicationFreezer$UnfreezeReason = null;

        static {
            $SwitchMap$com$android$server$am$IApplicationFreezer$UnfreezeReason = new int[IApplicationFreezer.UnfreezeReason.values().length];
            $SwitchMap$com$android$server$am$IApplicationFreezer$UnfreezeReason[IApplicationFreezer.UnfreezeReason.NEED_START_ACTIVITY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
        L22:
            $SwitchMap$com$android$server$am$IApplicationFreezer$UnfreezeReason[IApplicationFreezer.UnfreezeReason.NEED_RESUME_ACTIVITY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L18:
            $SwitchMap$com$android$server$am$IApplicationFreezer$UnfreezeReason[IApplicationFreezer.UnfreezeReason.NEED_UPDATE_VISIBILITY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L16:
            $SwitchMap$com$android$server$am$IApplicationFreezer$UnfreezeReason[IApplicationFreezer.UnfreezeReason.NEED_DESTROY_ACTIVITY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
            return;
        }
    }

    public void markNextVrApp(String pkg, int uid) {
        Object r0 = this.mMarkedLock;
        monitor-enter(r0);
        this.nPkg = pkg;     // Catch: Throwable -> L7
        this.nUid = uid;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isAllActivitiesStopped() {
        WindowManagerGlobalLock r0 = this.mAtm.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        Iterator<ActivityRecord> r1 = this.host.mActivities.iterator();     // Catch: Throwable -> L12
    L6:
        if (r1.hasNext() == false) goto L15;
        ActivityRecord ar = r1.next();     // Catch: Throwable -> L12
        if (ar.getActivityRecordSmtEx().isRecordStateAfterStop() == true) goto L6;
        monitor-exit(r0);     // Catch: Throwable -> L12
        WindowManagerService.resetPriorityAfterLockedSection();
        return false;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L12
        WindowManagerService.resetPriorityAfterLockedSection();
        return true;
    L12:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public boolean isMarkToForceStop() {
        boolean ret = false;
        Object r1 = this.mMarkedLock;
        monitor-enter(r1);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.nUid == (-1)) goto L7;
        ret = true;
    L7:
        monitor-exit(r1);     // Catch: Throwable -> L9
        return ret;
    }

    public void clearMarkedNextVrApp() {
        Object r0 = this.mMarkedLock;
        monitor-enter(r0);
        this.nUid = -1;     // Catch: Throwable -> L8
        this.nPkg = "";     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    WindowProcessControllerSmtBase(WindowProcessController _host) {
        super(_host);
        this.freezingStat = 0;
        this.unfreezeReason = 0;
        this.mSmtFreeFormConfig = new Configuration();
        this.hasBackgroundActivity = false;
        this.isColdLaunchDone = false;
        this.launchFromPrefetchUnfreeze = false;
        this.hotLaunchStage = false;
        this.unFreezeForLaunchType = 0;
        this.realPid = -1;
        this.pendingEvents = new SparseArray();
        this.mAtmsmt = null;
        this.UNMARKED_UID = -1;
        this.EMPTY_DES = "";
        this.mMarkedLock = new Object();
        this.nPkg = "";
        this.nUid = -1;
        this.host = _host;
    }

    public void setOriginPid(int pid) {
        if (pid <= 0) goto L5;
        this.realPid = pid;
        return;
    }

    public boolean isContainSpecificActivityRecord(ActivityRecord ar) {
        if (ar != null) goto L5;
    L32:
        return false;
    L5:
        if (this.host == null) goto L32;
        if (this.host.mActivities == null) goto L32;
        if (this.mAtm == null) goto L32;
        if (this.mAtm.mGlobalLock == null) goto L32;
        WindowManagerGlobalLock r1 = this.mAtm.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r1);
        Iterator<ActivityRecord> r2 = this.host.mActivities.iterator();     // Catch: Throwable -> L23
    L17:
        if (r2.hasNext() == false) goto L26;
        ActivityRecord r = r2.next();     // Catch: Throwable -> L23
        if (r.mActivityComponent.equals(ar.mActivityComponent) == false) goto L17;
        monitor-exit(r1);     // Catch: Throwable -> L23
        WindowManagerService.resetPriorityAfterLockedSection();
        return true;
    L26:
        monitor-exit(r1);     // Catch: Throwable -> L23
        WindowManagerService.resetPriorityAfterLockedSection();
        return false;
    L23:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    protected void init(ActivityTaskManagerService atm, WindowProcessListener _listener) {
        this.listener = _listener;
        this.mAtm = atm;
    }

    public void addPendingEventLocked(int pid, FrozenPendingEvent event) {
        this.unfreezeReason |= amToWmUnfreezeReason(event.unfreezeReason);
        SparseArray<ArrayList<FrozenPendingEvent>> r0 = this.pendingEvents;
        monitor-enter(r0);
        int key = composeKey(pid, event);     // Catch: Throwable -> L7
        ArrayList<FrozenPendingEvent> events = this.pendingEvents.get(key);     // Catch: Throwable -> L7
        if (events != null) goto L10;
        events = new ArrayList();     // Catch: Throwable -> L7
        this.pendingEvents.put(key, events);     // Catch: Throwable -> L7
    L10:
        if (event.getType() != 4) goto L12;
        Iterator<FrozenPendingEvent> r3 = events.iterator();     // Catch: Throwable -> L7
    L20:
        if (r3.hasNext() == false) goto L26;
        FrozenPendingEvent fpe = r3.next();     // Catch: Throwable -> L7
        if (fpe.equals(event) == false) goto L20;
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L26:
        events.add(event);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L12:
        if (events.size() != 0) goto L14;
    L15:
        events.clear();     // Catch: Throwable -> L7
        events.add(event);     // Catch: Throwable -> L7
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L14:
        if (events.get(0).equals(event) == true) goto L16;
    L7:
        th = move-exception;
        throw th;
    }

    public static int composeKey(int pid, FrozenPendingEvent event) {
        int caseValue = 0;
        if (event.unfreezeReason != IApplicationFreezer.UnfreezeReason.NEED_START_ACTIVITY) goto L6;
        caseValue = 1;
    L15:
        return (pid * 10) + caseValue;
    L6:
        if (event.unfreezeReason != IApplicationFreezer.UnfreezeReason.NEED_RESUME_ACTIVITY) goto L9;
        caseValue = 2;
        goto L15
    L9:
        if (event.unfreezeReason != IApplicationFreezer.UnfreezeReason.NEED_UPDATE_VISIBILITY) goto L12;
        caseValue = 3;
        goto L15
    L12:
        if (event.unfreezeReason != IApplicationFreezer.UnfreezeReason.NEED_DESTROY_ACTIVITY) goto L15;
        caseValue = 4;
        goto L15
    }

    public void handleFrozenPendingEventsLocked() {
        this.unfreezeReason = 0;
        SparseArray<ArrayList<FrozenPendingEvent>> r0 = this.pendingEvents;
        monitor-enter(r0);
        SparseArray<ArrayList<FrozenPendingEvent>> temp = this.pendingEvents.clone();     // Catch: Throwable -> L20
        this.pendingEvents.clear();     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        int i = 0;
    L8:
        if (i >= temp.size()) goto L19;
        ArrayList<FrozenPendingEvent> events = temp.valueAt(i);
        int j = 0;
    L11:
        if (j >= events.size()) goto L17;
        FrozenPendingEvent event = events.get(j);
        Exception result = event.handle();
        if (event.getType() != 1) goto L16;
        if (result == null) goto L16;
        return;
    L16:
        j = j + 1;
        goto L11
    L17:
        i = i + 1;
        goto L8
    L19:
        return;
    L20:
        th = move-exception;
        throw th;
    }

    private static int amToWmUnfreezeReason(IApplicationFreezer.UnfreezeReason reason) {
        switch(AnonymousClass1.$SwitchMap$com$android$server$am$IApplicationFreezer$UnfreezeReason[reason.ordinal()]) {
            case 1: goto L12;
            case 2: goto L10;
            case 3: goto L8;
            case 4: goto L6;
            default: goto L4;
        };
    L4:
        return 0;
    L6:
        return 8;
    L8:
        return 4;
    L10:
        return 2;
    L12:
        return 1;
    }

    void unFreezeForegroundAppIfNeed(String packageName, int displayId) {
        if (this.freezingStat != 0) goto L6;
        SysOptBridge.getFactory().getFreezeController().unfreezeUidForMutiWin(((ProcessRecord) this.host.mOwner).mUidRecord, IApplicationFreezer.UnfreezeReason.NEED_RESUME_ACTIVITY, ((ProcessRecord) this.host.mOwner).mPid, displayId);
        return;
    }

    void unFreezeProcIfNeedLocked(FrozenPendingEvent event) {
        SysOptBridge.getFactory().getApplicationFreezer().unfreezeForQuickFreeze(this.host.mInfo.packageName, this.host.mUid);
        if (this.listener != null) goto L5;
        return;
    L5:
        if (this.freezingStat == 0) goto L26;
        SparseArray<ArrayList<FrozenPendingEvent>> r1 = this.pendingEvents;
        monitor-enter(r1);
        int size = this.pendingEvents.size();     // Catch: Throwable -> L19
        monitor-exit(r1);     // Catch: Throwable -> L19
        Slog.d(TAG_FREEZE, "unFreezeProcIfNeedLocked event:" + event + " uid:" + this.host.mUid + " realPid:" + this.realPid + " pendingEvents.size:" + size);
        if (size <= 100) goto L17;
        StackTraceElement[] r2 = Thread.currentThread().getStackTrace();
        int r3 = r2.length;
        int r4 = 0;
    L15:
        if (r4 >= r3) goto L17;
        StackTraceElement ele = r2[r4];
        Slog.e(TAG_FREEZE, "ele:" + ele);
        r4 = r4 + 1;
    L17:
        addPendingEventLocked(this.realPid, event);
        this.mAtm.mH.sendMessageAtFrontOfQueue(PooledLambda.obtainMessage(new WindowProcessControllerSmtBase$$ExternalSyntheticLambda0(), this.listener.getSmtEx(), event));
        return;
    L19:
        th = move-exception;
        throw th;
    }

    void canclePrefetch() {
        this.mAtm.mH.sendMessageAtFrontOfQueue(PooledLambda.obtainMessage(new WindowProcessControllerSmtBase$$ExternalSyntheticLambda1(), this.listener.getSmtEx()));
    }

    void setFreezingStat(int stat) {
        this.freezingStat = stat;
        if (stat != 0) goto L8;
        if (this.thread == null) goto L8;
        this.host.setThread(this.thread);
        this.thread = null;
        return;
    L8:
        if (stat == 2) goto L10;
        return;
    L10:
        if (this.host.getThread() == null) goto L15;
        this.thread = this.host.getThread();
        this.host.setThread(null);
        return;
    }

    void finishOtherActivities(ActivityRecord ar) {
        if (ar != null) goto L4;
        return;
    L4:
        int i = this.host.mActivities.size() - 1;
    L5:
        if (i < 0) goto L11;
        ActivityRecord other = this.host.mActivities.get(i);
        if (ar == other) goto L9;
        other.destroyIfPossible("finishOtherActivities");
    L9:
        i = i - 1;
        goto L5
    }

    public boolean hasFocusActivity() {
        WindowManagerGlobalLock r0 = this.mAtm.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        monitor-exit(r0);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
        return false;
    L7:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    boolean isFreezing() {
        if (this.freezingStat == 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean cacheFrozenConfiguration(Configuration config) {
        if (isFreezing() == true) goto L5;
        return false;
    L5:
        if (this.configuration != null) goto L7;
        this.configuration = new Configuration(config);
        return true;
    L7:
        this.configuration.setTo(config);
        return true;
    }

    public long getAppLaunchTime() {
        return this.host.mInfo.getSysEx().mTransitionStartTimeNs;
    }

    void bringProcessToDefaultLocked() {
        if (this.listener != null) goto L5;
        return;
    L5:
        this.mAtm.mH.sendMessage(PooledLambda.obtainMessage(new WindowProcessControllerSmtBase$$ExternalSyntheticLambda2(), this.listener.getSmtEx()));
    }

    public boolean isPreviousVrProcess() {
        if (this.mAtm != null) goto L5;
    L13:
        return false;
    L5:
        if (this.mAtmsmt != null) goto L8;
        this.mAtmsmt = this.mAtm.getSmtEx();
    L8:
        if (this.mAtmsmt == null) goto L13;
        if (this.host != this.mAtmsmt.mPreviousVrProcess) goto L14;
        return true;
    L14:
        return false;
    }

    public boolean isFullScreenApp() {
        if (this.host.getWindowingMode() == 1) goto L7;
        return false;
    L7:
        return true;
    }
}
