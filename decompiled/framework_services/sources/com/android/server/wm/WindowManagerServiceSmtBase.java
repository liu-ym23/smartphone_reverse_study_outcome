package com.android.server.wm;

import android.app.SysMonitorFwBridge;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.hardware.display.VirtualDisplay;
import android.os.Parcel;
import android.os.Trace;
import android.resourcemanager.AppStartEventData;
import android.resourcemanager.IEventsOwner;
import android.resourcemanager.IRm;
import android.resourcemanager.Rm;
import android.text.TextUtils;
import android.util.Log;
import android.util.Slog;
import android.view.Display;
import android.view.WindowManagerPolicyConstantsSmtEx;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.LocalServices;
import com.android.server.SysOptBridge;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class WindowManagerServiceSmtBase {
    public static final int MSG_DO_TRANVERSAL = 1002;
    public static final int MSG_ROTATED_ANIM_TIMEOUT = 1004;
    public static final int MSG_UPDATE_REORDER_TASK = 1003;
    protected static final String TAG = "WindowManager";
    protected static int sDH;
    protected static int sDSquare;
    protected static int sDW;
    protected static int sOperatibleSquare;
    private final String PREFETCH_VD_NAME;
    private AppStartEventOwner mAppStartEventOwner;
    HashSet<ApplicationInfo> mApplicationInfosBK;
    private WindowState mCurrentFocusWindow;
    private final HashSet<Integer> mFloatingWindowUids;
    protected boolean mIsStartFromHome;
    LocalServiceSmtBase mLocalServiceSmtEx;
    private HashMap<String, Integer> mPrefetchPkgs;
    private final HashSet<Integer> mTmpFloatingWindowUids;
    protected HashSet<ApplicationInfo> mVisibleApplicationInfos;
    private final Object mVisibleUidLock;
    private HashSet<Integer> mVisibleUids;
    private HashSet<Integer> mVisibleUidsBK;
    ArrayList<WindowManagerPolicyConstantsSmtEx.VisibleWindowChangeListenerSmtEx> mVisibleWindowChangeListeners;
    protected WindowManagerService mWmService;

    class AppStartEventOwner implements IEventsOwner {
        private IRm mRm;

        AppStartEventOwner(WindowManagerServiceSmtBase this$0) {
            this.mRm = null;
            initRm();
        }

        public int obtainEventData(Parcel p, Parcel r) {
            Slog.e("AppStartEventOwner", "obtainEventData. do nothing now!");
            return 0;
        }

        public String getName() {
            return "AppStartEventOwner";
        }

        public void notifyEvent(int uid, int pid, int type, String pkgName) {
            long startTime = System.currentTimeMillis();
            AppStartEventData data = new AppStartEventData(uid, pid, type, pkgName);
            if (this.mRm != null) goto L5;
            initRm();
        L5:
            Parcel out = Parcel.obtain();
            data.writeToParcel(out, 0);     // Catch: Throwable -> L9
            this.mRm.notifyResEventData(FrameworkStatsLog.DIRECTORY_USAGE, out);     // Catch: Throwable -> L9
            out.recycle();
            long endTime = System.currentTimeMillis();
            Slog.i("AppStartEventOwner", "notifyEvent done. uid " + uid + " pid " + pid + " event " + type + " pkg " + pkgName + " timeCost=" + (endTime - startTime) + "ms");
            return;
        L9:
            th = move-exception;
            out.recycle();
            throw th;
        }

        private void initRm() {
            this.mRm = Rm.getInstance();
            this.mRm.connect();
            int[] events = {FrameworkStatsLog.DIRECTORY_USAGE};
            this.mRm.registerResEvents(events, this);
        }
    }

    class LocalServiceSmtBase extends WindowManagerInternalSmtBase {
        final /* synthetic */ WindowManagerServiceSmtBase this$0;

        LocalServiceSmtBase(WindowManagerServiceSmtBase this$0) {
            this.this$0 = this$0;
        }

        @Override // com.android.server.wm.WindowManagerInternalSmtBase
        public void registerVisibleWindowChangeListener(WindowManagerPolicyConstantsSmtEx.VisibleWindowChangeListenerSmtEx listener) {
            WindowManagerGlobalLock r0 = this.this$0.mWmService.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            if (listener == null) goto L16;
            if (this.this$0.mVisibleWindowChangeListeners.contains(listener) == true) goto L14;
            this.this$0.mVisibleWindowChangeListeners.add(listener);     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L14:
            throw new IllegalStateException("registerVisibleWindowChangeListener: trying to register" + listener + " twice.");     // Catch: Throwable -> L11
        L16:
            throw new IllegalArgumentException("registerVisibleWindowChangeListener listener null");     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerInternalSmtBase
        public void unRegisterVisibleWindowChangeListener(WindowManagerPolicyConstantsSmtEx.VisibleWindowChangeListenerSmtEx listener) {
            WindowManagerGlobalLock r0 = this.this$0.mWmService.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
        L10:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L5:
            if (this.this$0.mVisibleWindowChangeListeners.contains(listener) == false) goto L13;
            this.this$0.mVisibleWindowChangeListeners.remove(listener);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L13:
            throw new IllegalStateException("unRegisterVisibleWindowChangeListener: " + listener + "not registered.");     // Catch: Throwable -> L10
        }
    }

    public static /* synthetic */ void $r8$lambda$AMn2cIqDx2KcEkYP33sTm4Jk8Mw(WindowManagerServiceSmtBase r0, ActivityRecord r1) {
        r0.lambda$setAllActivityInvisible$2(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$FH9wql10A8bDlr4NOoSA-XzAALU, reason: not valid java name */
    public static /* synthetic */ void m10457$r8$lambda$FH9wql10A8bDlr4NOoSAXzAALU(WindowState r0) {
        lambda$onDisplayFpsModeChanged$1(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$RAXv3TtrQOsBeWYCIe-OUaucQa0, reason: not valid java name */
    public static /* synthetic */ void m10458$r8$lambda$RAXv3TtrQOsBeWYCIeOUaucQa0(WindowState r0) {
        lambda$forceUpdateAllWindowVisibleTime$0(r0);
    }

    public static /* synthetic */ void $r8$lambda$_le6BZGqcoYK4tQc9lx5rWYXVp0(String r0, Task[] r1, ActivityRecord r2) {
        lambda$checkTaskForPrefetchLocked$3(r0, r1, r2);
    }

    static {
        sDW = -1;
        sDH = -1;
        sDSquare = -1;
        sOperatibleSquare = -1;
    }

    protected WindowManagerServiceSmtBase(WindowManagerService wmService) {
        this.mIsStartFromHome = false;
        this.PREFETCH_VD_NAME = new String("PREFETCH_APP");
        this.mVisibleWindowChangeListeners = new ArrayList();
        this.mVisibleApplicationInfos = new HashSet();
        this.mApplicationInfosBK = new HashSet();
        this.mVisibleUidLock = new Object();
        this.mVisibleUids = new HashSet();
        this.mVisibleUidsBK = new HashSet();
        this.mFloatingWindowUids = new HashSet();
        this.mTmpFloatingWindowUids = new HashSet();
        this.mWmService = wmService;
        this.mPrefetchPkgs = new HashMap();
    }

    void systemReady() {
        this.mAppStartEventOwner = new AppStartEventOwner(this);
    }

    protected void initLocalServices() {
        this.mLocalServiceSmtEx = new LocalServiceSmtBase(this);
        LocalServices.addService(WindowManagerInternalSmtBase.class, this.mLocalServiceSmtEx);
    }

    static boolean isOperatible(WindowState w) {
        Rect r = w.getDisplayFrame();
        if (w.isDisplayed() == true) goto L5;
        return false;
    L5:
        if ((r.width() * r.height()) <= sOperatibleSquare) goto L10;
        return true;
    L10:
        return false;
    }

    void switchApplicationInfos() {
        HashSet<ApplicationInfo> tmp = this.mVisibleApplicationInfos;
        this.mVisibleApplicationInfos = this.mApplicationInfosBK;
        this.mApplicationInfosBK = tmp;
    }

    public HashSet<ApplicationInfo> getApplicationInfos() {
        return this.mVisibleApplicationInfos;
    }

    void saveVisibleUids() {
        Object r0 = this.mVisibleUidLock;
        monitor-enter(r0);
        HashSet<Integer> temp = this.mVisibleUids;     // Catch: Throwable -> L7
        this.mVisibleUids = this.mVisibleUidsBK;     // Catch: Throwable -> L7
        this.mVisibleUidsBK = temp;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void addVisibleUidBk(int uid) {
        this.mVisibleUidsBK.add(Integer.valueOf(uid));
    }

    void clearVisibleUidsBk() {
        this.mVisibleUidsBK.clear();
    }

    public boolean isVisibleUid(int uid) {
        Object r0 = this.mVisibleUidLock;
        monitor-enter(r0);
        boolean r1 = this.mVisibleUids.contains(Integer.valueOf(uid));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public String getVisibleUidsStr() {
        Object r0 = this.mVisibleUidLock;
        monitor-enter(r0);
        String r1 = this.mVisibleUids.toString();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void addFloatingWindowUid(int uid) {
        this.mTmpFloatingWindowUids.add(Integer.valueOf(uid));
    }

    public void saveFloatingWindowUids() {
        HashSet<Integer> r0 = this.mFloatingWindowUids;
        monitor-enter(r0);
        this.mFloatingWindowUids.clear();     // Catch: Throwable -> L7
        this.mFloatingWindowUids.addAll(this.mTmpFloatingWindowUids);     // Catch: Throwable -> L7
        this.mTmpFloatingWindowUids.clear();     // Catch: Throwable -> L7
        SysOptBridge.getFactory().getAppRecordManagerService().updateFloatingWindowUids(this.mFloatingWindowUids);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isFloatingWindowUid(int uid) {
        HashSet<Integer> r0 = this.mFloatingWindowUids;
        monitor-enter(r0);
        boolean r1 = this.mFloatingWindowUids.contains(Integer.valueOf(uid));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void clearStartingWindowFiles() {
    }

    public void dump(PrintWriter pw) {
        pw.print("  mVisibleUidsBK: {");
        Iterator<Integer> r0 = this.mVisibleUidsBK.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Integer uid = r0.next();
        pw.print(uid);
        pw.print(", ");
        goto L4
    L6:
        pw.println(" }");
        pw.print("  mVisibleUids: {");
        Iterator<Integer> r1 = this.mVisibleUids.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        Integer uid2 = r1.next();
        pw.print(uid2);
        pw.print(", ");
        goto L8
    L10:
        pw.println(" }");
    }

    public void updateWindowDisplayFlag(int flag) {
        WindowManagerGlobalLock r0 = this.mWmService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (this.mCurrentFocusWindow != null) goto L7;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L7:
        if (this.mCurrentFocusWindow.mActivityRecord == null) goto L11;
        this.mCurrentFocusWindow.mActivityRecord.info.getSysEx().autoDisplayFlags = flag;     // Catch: Throwable -> L9
        goto L11
    }

    public boolean isPreExitPcMode() {
        return false;
    }

    public void setIsStartFromHome(boolean b) {
        this.mIsStartFromHome = b;
    }

    public void forceUpdateAllWindowVisibleTime(boolean screenOn) {
        WindowManagerGlobalLock r0 = this.mWmService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent displayContent = this.mWmService.getDefaultDisplayContentLocked();     // Catch: Throwable -> L8
        displayContent.forAllWindows(new WindowManagerServiceSmtBase$$ExternalSyntheticLambda0(), true);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private static /* synthetic */ void lambda$forceUpdateAllWindowVisibleTime$0(WindowState w) {
    }

    public void onDisplayFpsModeChanged(int displayMode) {
        WindowManagerGlobalLock r0 = this.mWmService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent displayContent = this.mWmService.getDefaultDisplayContentLocked();     // Catch: Throwable -> L8
        displayContent.forAllWindows(new WindowManagerServiceSmtBase$$ExternalSyntheticLambda3(), true);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private static /* synthetic */ void lambda$onDisplayFpsModeChanged$1(WindowState w) {
    }

    private int initDisplay() {
        int displayFlag = 2 | 1;
        return (((((((displayFlag | 8) | 4096) | 2048) | 64) | 1024) | 4) | 8192) | 128;
    }

    public void notifyStartEventToResManager(int uid, int pid, int type, String packageName) {
        if (this.mAppStartEventOwner != null) goto L6;
        this.mAppStartEventOwner = new AppStartEventOwner(this);
    L6:
        if (this.mAppStartEventOwner != null) goto L9;
        Log.i(TAG, "notifyStartEventToResManager. mAppStartEventOwner == null.");
        return;
    L9:
        this.mAppStartEventOwner.notifyEvent(uid, pid, type, packageName);
    }

    public VirtualDisplay initVirtualDisplay(boolean rotated) {
        Trace.traceBegin(32, "initVirtualDisplay");
        DisplayContent defaultDc = this.mWmService.mRoot.getDefaultDisplay();
        if (rotated == false) goto L6;
        int r0 = defaultDc.mInitialDisplayHeight;
    L5:
        int width = r0;
        if (rotated == false) goto L10;
        int r1 = defaultDc.mInitialDisplayWidth;
    L9:
        int height = r1;
        int density = defaultDc.mInitialDisplayDensity;
        Slog.i(TAG, " initVirtualDisplay. WxH=" + width + "x" + height + " density=" + density);
        int displayFlag = initDisplay();
        VirtualDisplay prefetchDisplay = this.mWmService.mDisplayManager.createVirtualDisplay(this.PREFETCH_VD_NAME, width, height, density, null, displayFlag);
        if (prefetchDisplay != null) goto L39;
    L31:
        StringBuilder r6 = new StringBuilder();
        r6.append("initVirtualDisplay ");
        if (prefetchDisplay == null) goto L34;
        Object r12 = prefetchDisplay.getDisplay();
    L35:
        r6.append(r12);
        Slog.d(TAG, r6.toString());
        Trace.traceEnd(32);
        return prefetchDisplay;
    L34:
        r12 = "fail";
        goto L35
    L39:
        WindowManagerGlobalLock r7 = this.mWmService.mGlobalLock;     // Catch: Exception -> L24
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Exception -> L24
        monitor-enter(r7);     // Catch: Exception -> L24
        DisplayContent defaultDisplay = this.mWmService.mRoot.getDisplayContent(0);     // Catch: Throwable -> L19
        Configuration defaultConfig = defaultDisplay.getConfiguration();     // Catch: Throwable -> L19
        DisplayContent dc = this.mWmService.mRoot.getDisplayContentOrCreate(prefetchDisplay.getDisplay().getDisplayId());     // Catch: Throwable -> L19
        if (dc == null) goto L21;
        if (defaultConfig == null) goto L21;
        dc.updateDisplayOverrideConfigurationLocked(defaultConfig, null, false);     // Catch: Throwable -> L19
    L21:
        monitor-exit(r7);     // Catch: Throwable -> L19
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Exception -> L24
        goto L31
    L19:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Exception -> L24
        throw th;     // Catch: Exception -> L24
    L24:
        e = move-exception;
        Slog.i(TAG, "updateDisplayOverrideConfigurationLocked e=" + e);
        goto L31
    L10:
        r1 = defaultDc.mInitialDisplayHeight;
        goto L9
    L6:
        r0 = defaultDc.mInitialDisplayWidth;
        goto L5
    }

    private void setAllActivityInvisible(Task task) {
        Trace.traceBegin(32, "setAllActivityInvisible task=" + task);
        WindowManagerGlobalLock r0 = this.mWmService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        task.forAllActivities(new WindowManagerServiceSmtBase$$ExternalSyntheticLambda1(this));     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        Trace.traceEnd(32);
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private /* synthetic */ void lambda$setAllActivityInvisible$2(final ActivityRecord r) {
        if (r.isVisible() == false) goto L6;
        r.commitVisibility(false, true);
        r.forAllWindows(new AnonymousClass1(this, r), true);
    L6:
        if (r.isState(ActivityRecord.State.RESUMED) == false) goto L9;
        r.setState(ActivityRecord.State.PAUSING, "preloadDisplayChanged");
        return;
    }

    public int getDefaultDisplayState() {
        return this.mWmService.mRoot.getDefaultDisplay().getDisplay().getState();
    }

    public void addPrefetchPkgAndDisplay(String packageName, int displayId) {
        HashMap<String, Integer> r0 = this.mPrefetchPkgs;
        monitor-enter(r0);
        this.mPrefetchPkgs.put(packageName, Integer.valueOf(displayId));     // Catch: Throwable -> L7
        Slog.d(TAG, "addPrefetchPkgAndDisplay " + packageName + "  displayId=" + displayId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public Task getPrefetchTaskLocked(String packageName) {
        Task res = null;
        Display[] displays = this.mWmService.mDisplayManager.getDisplays();
        int i = 0;
    L4:
        if (i >= displays.length) goto L33;
        DisplayContent displayContent = this.mWmService.mRoot.getDisplayContent(displays[i].getDisplayId());
        if (displayContent == null) goto L7;
        TaskDisplayArea displayArea = displayContent.getDefaultTaskDisplayArea();
        int numRootTasks = displayArea.mChildren.size();
        int j = 0;
    L10:
        if (j >= numRootTasks) goto L31;
        Task task = ((WindowContainer) displayArea.mChildren.get(j)).asTask();
        Intent baseIntent = task.getBaseIntent();
        if (baseIntent == null) goto L30;
        if (SysMonitorFwBridge.getFactory().getPrefetchState().isFromPrefetch(task.prefetchState) == false) goto L30;
        String taskPackageName = baseIntent.getPackage();
        if (TextUtils.isEmpty(taskPackageName) == false) goto L23;
        if (baseIntent.getComponent() == null) goto L23;
        taskPackageName = baseIntent.getComponent().getPackageName();
    L23:
        if (packageName.equals(taskPackageName) == false) goto L30;
        if (res != null) goto L28;
        res = task;
        goto L30
    L28:
        if (task.mTaskId <= res.mTaskId) goto L30;
        res = task;
    L30:
        j = j + 1;
        goto L10
    L31:
        i = i + 1;
        goto L4
    L7:
        Slog.d(TAG, "getPrefetchTask displayContent == null");
        return res;
    L33:
        return res;
    }

    public boolean moveAllTaskToDisplay(String packageName, boolean realStart) {
        String r2 = packageName;
        boolean r3 = realStart;
        int toDisplayId = this.mWmService.mRoot.getDefaultDisplay().getDisplayId();
        Display[] displays = this.mWmService.mDisplayManager.getDisplays();
        Slog.w(TAG, "moveAllTaskToDisplay packageName=" + r2 + ", realStart=" + r3);
        int n = 0;
    L4:
        if (n >= displays.length) goto L85;
        if (displays[n] != null) goto L8;
        int toDisplayId2 = toDisplayId;
    L83:
        n = n + 1;
        r2 = packageName;
        r3 = realStart;
        toDisplayId = toDisplayId2;
        goto L4
    L8:
        if (displays[n].getName().equals(this.PREFETCH_VD_NAME) == true) goto L10;
        toDisplayId2 = toDisplayId;
        goto L83
    L10:
        boolean r0 = false;
        if (r3 == false) goto L13;
    L15:
        int fromDisplayId = displays[n].getDisplayId();
        Trace.traceBegin(32, "moveAllTaskToDisplay");
        WindowManagerGlobalLock r9 = this.mWmService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r9);
        DisplayContent fromDisplayContent = this.mWmService.mRoot.getDisplayContent(fromDisplayId);     // Catch: Throwable -> L66
        DisplayContent toDisplayContent = this.mWmService.mRoot.getDisplayContent(toDisplayId);     // Catch: Throwable -> L66
        if (fromDisplayContent == null) goto L75;
        if (toDisplayContent == null) goto L75;
        TaskDisplayArea fromDisplayArea = fromDisplayContent.getDefaultTaskDisplayArea();     // Catch: Throwable -> L66
        TaskDisplayArea toDisplayArea = toDisplayContent.getDefaultTaskDisplayArea();     // Catch: Throwable -> L66
        int numRootTasks = fromDisplayArea.mChildren.size();     // Catch: Throwable -> L66
        ArrayList<Task> allToMoveTasks = new ArrayList();     // Catch: Throwable -> L66
        long r18 = 32;
        int i = 0;
    L23:
        if (i >= numRootTasks) goto L48;
        Task task = ((WindowContainer) fromDisplayArea.mChildren.get(i)).asTask();     // Catch: Throwable -> L32
        Intent baseIntent = task.getBaseIntent();     // Catch: Throwable -> L32
        if (baseIntent != null) goto L27;
        r0 = r0;
        ArrayList<Task> allToMoveTasks2 = allToMoveTasks;
    L47:
        i = i + 1;
        allToMoveTasks = allToMoveTasks2;
        r0 = r0;
        goto L23
    L27:
        String taskPackageName = baseIntent.getPackage();     // Catch: Throwable -> L32
        if (TextUtils.isEmpty(taskPackageName) == true) goto L30;
    L34:
        String taskPackageName2 = taskPackageName;
    L36:
        if (r2.equals(taskPackageName2) == true) goto L38;
        allToMoveTasks2 = allToMoveTasks;
        goto L47
    L38:
        if (r3 == false) goto L40;
    L45:
        allToMoveTasks2 = allToMoveTasks;
        allToMoveTasks2.add(task);     // Catch: Throwable -> L32
        goto L47
    L40:
        if (task.getResumedActivity() == null) goto L45;
        Trace.traceEnd(32);     // Catch: Throwable -> L32
        monitor-exit(r9);     // Catch: Throwable -> L32
        WindowManagerService.resetPriorityAfterLockedSection();
        return r0;
    L30:
        if (baseIntent.getComponent() == null) goto L34;
        taskPackageName2 = baseIntent.getComponent().getPackageName();     // Catch: Throwable -> L32
    L32:
        th = th;
    L79:
        monitor-exit(r9);     // Catch: Throwable -> L64
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L48:
        boolean r21 = r0;
        ArrayList<Task> allToMoveTasks3 = allToMoveTasks;
        int numRootTasks2 = allToMoveTasks3.size();     // Catch: Throwable -> L66
        int i2 = 0;
    L50:
        if (i2 >= numRootTasks2) goto L71;
        Task task2 = allToMoveTasks3.get(i2);     // Catch: Throwable -> L66
        if (task2 != null) goto L54;
        toDisplayId = toDisplayId;
    L88:
        i2 = i2 + 1;     // Catch: Throwable -> L64
        r3 = realStart;
        allToMoveTasks3 = allToMoveTasks3;
        toDisplayId = toDisplayId;
        r18 = 32;
        r21 = false;
    L64:
        th = th;
        goto L79
    L54:
        task2.reparent(toDisplayArea, r21);     // Catch: Throwable -> L66
        setAllActivityInvisible(task2);     // Catch: Throwable -> L66
        if (r3 == true) goto L57;
        task2.prefetchState |= 2;     // Catch: Throwable -> L32
    L57:
        ActivityRecord topRunning = task2.topRunningActivity();     // Catch: Throwable -> L66
        if (topRunning == null) goto L69;
        if (topRunning.shouldUpdateConfigForDisplayChanged() == false) goto L69;
        Trace.traceBegin(r18, "ensureVisibilityAndConfig");     // Catch: Throwable -> L64
        this.mWmService.mRoot.ensureVisibilityAndConfig(topRunning, topRunning.getDisplayContent(), false);     // Catch: Throwable -> L64
        Trace.traceEnd(32);     // Catch: Throwable -> L64
    L69:
        Slog.d(TAG, "moveAllTaskToDisplay task[" + i2 + "]=" + task2 + ", toDisplayArea=" + toDisplayArea + ", taskRootDisplayId=" + task2.getRootTask().getDisplayId());     // Catch: Throwable -> L64
        goto L88
    L71:
        toDisplayId2 = toDisplayId;
        monitor-exit(r9);     // Catch: Throwable -> L64
        WindowManagerService.resetPriorityAfterLockedSection();
        Trace.traceEnd(32);
    L75:
        Slog.w(TAG, "moveAllTaskToDisplay return for " + fromDisplayContent + " " + toDisplayContent);     // Catch: Throwable -> L64
        Trace.traceEnd(32);     // Catch: Throwable -> L64
        monitor-exit(r9);     // Catch: Throwable -> L64
        WindowManagerService.resetPriorityAfterLockedSection();
        return true;
    L66:
        th = th;
        goto L79
    L13:
        if (displays[n].getState() == 1) goto L15;
        return false;
    L85:
        return true;
    }

    boolean checkTaskForPrefetchLocked(final String packageName) {
        if (packageName != null) goto L5;
        return false;
    L5:
        Display[] displays = this.mWmService.mDisplayManager.getDisplays();
        int n = 0;
    L7:
        if (n >= displays.length) goto L22;
        if (displays[n] == null) goto L21;
        int fromDisplayId = displays[n].getDisplayId();
        DisplayContent fromDisplayContent = this.mWmService.mRoot.getDisplayContent(fromDisplayId);
        if (fromDisplayContent == null) goto L21;
        TaskDisplayArea fromDisplayArea = fromDisplayContent.getDefaultTaskDisplayArea();
        int rootTasks = fromDisplayArea.mChildren.size();
        int i = 0;
    L15:
        if (i >= rootTasks) goto L21;
        Task task = ((WindowContainer) fromDisplayArea.mChildren.get(i)).asTask();
        final Task[] resultHolder = {null};
        task.forAllActivities(new WindowManagerServiceSmtBase$$ExternalSyntheticLambda2(packageName, resultHolder));
        if (resultHolder[0] != null) goto L18;
        i = i + 1;
        goto L15
    L18:
        Slog.i(TAG, "check task before start prefetch: " + resultHolder[0]);
        return true;
    L21:
        n = n + 1;
        goto L7
    L22:
        Slog.i(TAG, "check task before start prefetch: no task found.");
        return false;
    }

    private static /* synthetic */ void lambda$checkTaskForPrefetchLocked$3(String packageName, Task[] resultHolder, ActivityRecord ar) {
        if (ar.info != null) goto L5;
        return;
    L5:
        if (ar.info.applicationInfo != null) goto L7;
        return;
    L7:
        if (packageName.equals(ar.info.applicationInfo.packageName) == false) goto L12;
        resultHolder[0] = ar.getTask();
        return;
    }
}
