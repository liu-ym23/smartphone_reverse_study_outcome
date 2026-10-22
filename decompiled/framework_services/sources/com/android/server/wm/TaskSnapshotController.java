package com.android.server.wm;

import android.R;
import android.app.ActivityManager;
import android.graphics.Rect;
import android.os.Handler;
import android.util.ArraySet;
import android.util.IntArray;
import android.util.Slog;
import android.window.ScreenCapture;
import android.window.TaskSnapshot;
import com.android.server.policy.WindowManagerPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
class TaskSnapshotController extends AbsAppSnapshotController<Task, TaskSnapshotCache> {
    static final String SNAPSHOTS_DIRNAME = "snapshots";
    private final Handler mHandler;
    private final BaseAppSnapshotPersister.PersistInfoProvider mPersistInfoProvider;
    private final TaskSnapshotPersister mPersister;
    private final IntArray mSkipClosingAppSnapshotTasks;
    private final IntArray mSkipSnapshotTasksForSplitExit;
    private final ArraySet<Task> mTmpTasks;

    public static /* synthetic */ void $r8$lambda$6CUUreN27ppWINhjmPyCtnm3wt4(TaskSnapshotController r0, Task r1, TaskSnapshot r2) {
        r0.lambda$getRecordSnapshotSupplier$0(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$JulDjwQKRPlHrjVHGpxThjrowUs(TaskSnapshotController r0, int r1, WindowManagerPolicy.ScreenOffListener r2) {
        r0.lambda$screenTurningOff$3(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$L67RtxFLMlhJoij0ZWdmk1KZRYc(TaskSnapshotController r0, ArrayList r1, Task r2) {
        r0.lambda$prepareShutdown$2(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$b3C0K4ISpZVX0tC6eK87GGIrRm4(TaskSnapshotController r0, Task r1) {
        r0.lambda$snapshotForSleeping$4(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$uAv-iIauQGlbA2jv-klglXShaZs, reason: not valid java name */
    public static /* synthetic */ void m10321$r8$lambda$uAviIauQGlbA2jvklglXShaZs(TaskSnapshotController r0, Task r1, TaskSnapshot r2) {
        r0.lambda$prepareShutdown$1(r1, r2);
    }

    @Override // com.android.server.wm.AbsAppSnapshotController
    protected /* bridge */ /* synthetic */ ActivityRecord findAppTokenForSnapshot(WindowContainer r1) {
        return findAppTokenForSnapshot((Task) r1);
    }

    @Override // com.android.server.wm.AbsAppSnapshotController
    /* bridge */ /* synthetic */ ActivityManager.TaskDescription getTaskDescription(WindowContainer r1) {
        return getTaskDescription((Task) r1);
    }

    @Override // com.android.server.wm.AbsAppSnapshotController
    /* bridge */ /* synthetic */ ActivityRecord getTopActivity(WindowContainer r1) {
        return getTopActivity((Task) r1);
    }

    TaskSnapshotController(WindowManagerService service, SnapshotPersistQueue persistQueue) {
        super(service);
        this.mSkipClosingAppSnapshotTasks = new IntArray();
        this.mSkipSnapshotTasksForSplitExit = new IntArray();
        this.mTmpTasks = new ArraySet();
        this.mHandler = new Handler();
        boolean snapshotEnabled = !service.mContext.getResources().getBoolean(R.bool.config_disableWeaverOnUnsecuredUsers);
        setSnapshotEnabled(snapshotEnabled);
        this.mPersistInfoProvider = createPersistInfoProvider(service, new ActivitySnapshotController$$ExternalSyntheticLambda3());
        this.mPersister = new TaskSnapshotPersister(persistQueue, this.mPersistInfoProvider, shouldDisableSnapshots());
        initialize(new TaskSnapshotCache(new AppSnapshotLoader(this.mPersistInfoProvider)));
    }

    static BaseAppSnapshotPersister.PersistInfoProvider createPersistInfoProvider(WindowManagerService service, BaseAppSnapshotPersister.DirectoryResolver resolver) {
        float highResTaskSnapshotScale = service.mContext.getResources().getFloat(R.dimen.default_magnifier_horizontal_offset);
        float lowResTaskSnapshotScale = service.mContext.getResources().getFloat(R.dimen.dialog_fixed_width_minor);
        if (lowResTaskSnapshotScale < 0.0f) goto L23;
        if (1.0f <= lowResTaskSnapshotScale) goto L23;
        if (highResTaskSnapshotScale <= 0.0f) goto L21;
        if (1.0f < highResTaskSnapshotScale) goto L21;
        if (highResTaskSnapshotScale <= lowResTaskSnapshotScale) goto L19;
        if (lowResTaskSnapshotScale <= 0.0f) goto L15;
        float lowResScaleFactor = lowResTaskSnapshotScale / highResTaskSnapshotScale;
        float lowResScaleFactor2 = lowResScaleFactor;
        boolean enableLowResSnapshots = true;
    L16:
        boolean use16BitFormat = service.mContext.getResources().getBoolean(R.bool.config_useSmsAppService);
        return new BaseAppSnapshotPersister.PersistInfoProvider(resolver, SNAPSHOTS_DIRNAME, enableLowResSnapshots, lowResScaleFactor2, use16BitFormat);
    L15:
        lowResScaleFactor2 = 0.0f;
        enableLowResSnapshots = false;
        goto L16
    L19:
        throw new RuntimeException("High-res scale must be greater than low-res scale");
    L21:
        throw new RuntimeException("High-res scale must be between 0 and 1");
    L23:
        throw new RuntimeException("Low-res scale must be between 0 and 1");
    }

    void addSkipClosingAppSnapshotTasks(Set<Task> tasks) {
        if (shouldDisableSnapshots() == false) goto L5;
        return;
    L5:
        Iterator<Task> r0 = tasks.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        Task task = r0.next();
        this.mSkipClosingAppSnapshotTasks.add(task.mTaskId);
        goto L7
    }

    void addSkipSnapshotTaskForSplitExit(Task task) {
        if (shouldDisableSnapshots() == false) goto L5;
        return;
    L5:
        this.mSkipSnapshotTasksForSplitExit.add(task.mTaskId);
    }

    void clearSkipSnapshotTasksForSplitExit() {
        this.mSkipSnapshotTasksForSplitExit.clear();
    }

    void snapshotTasks(ArraySet<Task> tasks) {
        int i = tasks.size() - 1;
    L3:
        if (i < 0) goto L6;
        recordSnapshot(tasks.valueAt(i));
        i = i - 1;
        goto L3
    }

    void recordSnapshot(Task task, Transition.ChangeInfo changeInfo) {
        this.mCurrentChangeInfo = changeInfo;
        recordSnapshot(task);     // Catch: Throwable -> L6
        this.mCurrentChangeInfo = null;
        return;
    L6:
        th = move-exception;
        this.mCurrentChangeInfo = null;
        throw th;
    }

    void recordSnapshot(Task task) {
        if (this.mSkipSnapshotTasksForSplitExit.indexOf(task.mTaskId) < 0) goto L7;
        Slog.i("WindowManager", "Skip split exit snapshot override, task=" + task);
        return;
    L7:
        if (shouldDisableSnapshots() == false) goto L9;
        return;
    L9:
        final AbsAppSnapshotController.SnapshotSupplier supplier = getRecordSnapshotSupplier(task);
        if (supplier != null) goto L12;
        return;
    L12:
        int mode = getSnapshotMode(task);
        if (mode != 1) goto L15;
        WindowManagerService.H r2 = this.mService.mH;
        supplier.getClass();
        r2.post(new TaskSnapshotController$$ExternalSyntheticLambda1(supplier));
        return;
    L15:
        supplier.handleSnapshot();
    }

    AbsAppSnapshotController.SnapshotSupplier getRecordSnapshotSupplier(final Task task) {
        return recordSnapshotInner(task, true, new TaskSnapshotController$$ExternalSyntheticLambda4(this, task));
    }

    private /* synthetic */ void lambda$getRecordSnapshotSupplier$0(Task task, TaskSnapshot snapshot) {
        if (task.isActivityTypeHome() == true) goto L6;
        this.mPersister.persistSnapshot(task.mTaskId, task.mUserId, snapshot);
        task.onSnapshotChanged(snapshot);
        return;
    }

    TaskSnapshot getSnapshot(int taskId, boolean isLowResolution) {
        return getSnapshot(taskId, false, 0);
    }

    TaskSnapshot getSnapshot(int taskId, boolean isLowResolution, int usage) {
        TaskSnapshotCache r0 = (TaskSnapshotCache) this.mCache;
        if (isLowResolution == true) goto L5;
    L7:
        boolean r1 = false;
    L9:
        return r0.getSnapshot(taskId, r1, usage);
    L5:
        if (this.mPersistInfoProvider.enableLowResSnapshots() == false) goto L7;
        r1 = true;
        goto L9
    }

    TaskSnapshot getSnapshotFromDisk(int taskId, int userId, boolean isLowResolution, int usage) {
        TaskSnapshotCache r0 = (TaskSnapshotCache) this.mCache;
        if (isLowResolution == true) goto L5;
    L7:
        boolean r1 = false;
    L9:
        return r0.getSnapshotFromDisk(taskId, userId, r1, usage);
    L5:
        if (this.mPersistInfoProvider.enableLowResSnapshots() == false) goto L7;
        r1 = true;
        goto L9
    }

    long getSnapshotCaptureTime(int taskId) {
        TaskSnapshot snapshot = ((TaskSnapshotCache) this.mCache).getSnapshot(taskId, false);
        if (snapshot != null) goto L5;
        return -1;
    L5:
        return snapshot.getCaptureTime();
    }

    public void clearSnapshotCache() {
        ((TaskSnapshotCache) this.mCache).clearRunningCache();
    }

    protected ActivityRecord findAppTokenForSnapshot(Task task) {
        return task.getActivity(new TaskSnapshotController$$ExternalSyntheticLambda6());
    }

    @Override // com.android.server.wm.AbsAppSnapshotController
    protected boolean use16BitFormat() {
        return this.mPersistInfoProvider.use16BitFormat();
    }

    private ScreenCapture.ScreenshotHardwareBuffer createImeSnapshot(Task task, int pixelFormat) {
        if (task.getSurfaceControl() == null) goto L5;
        WindowState imeWindow = task.getDisplayContent().mInputMethodWindow;
        if (imeWindow != null) goto L12;
        return null;
    L12:
        if (imeWindow.isVisible() == false) goto L16;
        Rect bounds = imeWindow.getParentFrame();
        bounds.offsetTo(0, 0);
        ScreenCapture.LayerCaptureArgs captureArgs = new ScreenCapture.LayerCaptureArgs.Builder(imeWindow.getSurfaceControl()).setSourceCrop(bounds).setFrameScale(1.0f).setPixelFormat(pixelFormat).setCaptureSecureLayers(true).build();
        ScreenCapture.ScreenshotHardwareBuffer imeBuffer = ScreenCapture.captureLayers(captureArgs);
        return imeBuffer;
    L16:
        return null;
    L5:
        if (WindowManagerDebugConfig.DEBUG_SCREENSHOT == false) goto L17;
        Slog.w("WindowManager", "Failed to take screenshot. No surface control for " + task);
        return null;
    L17:
        return null;
    }

    ScreenCapture.ScreenshotHardwareBuffer snapshotImeFromAttachedTask(Task task) {
        if (checkIfReadyToSnapshot(task) != null) goto L7;
        return null;
    L7:
        if (this.mPersistInfoProvider.use16BitFormat() == false) goto L9;
        int pixelFormat = 4;
    L11:
        return createImeSnapshot(task, pixelFormat);
    L9:
        pixelFormat = 1;
        goto L11
    }

    ActivityRecord getTopActivity(Task source) {
        return source.getTopMostActivity();
    }

    ActivityManager.TaskDescription getTaskDescription(Task source) {
        return source.getTaskDescription();
    }

    @Override // com.android.server.wm.AbsAppSnapshotController
    protected Rect getLetterboxInsets(ActivityRecord topActivity) {
        return topActivity.getLetterboxInsets();
    }

    void getClosingTasksInner(Task task, ArraySet<Task> outClosingTasks) {
        if (isAnimatingByRecents(task) == false) goto L6;
        this.mSkipClosingAppSnapshotTasks.add(task.mTaskId);
    L6:
        if (task.isVisible() == false) goto L8;
        return;
    L8:
        if (this.mSkipClosingAppSnapshotTasks.indexOf(task.mTaskId) >= 0) goto L12;
        outClosingTasks.add(task);
        return;
    }

    void removeAndDeleteSnapshot(int taskId, int userId, int uid) {
        removeBackgroundKilledAppInfo(uid, userId);
        ((TaskSnapshotCache) this.mCache).onIdRemoved(Integer.valueOf(taskId));
        this.mPersister.removeSnapshot(taskId, userId);
    }

    void removeSnapshotCache(int taskId) {
        ((TaskSnapshotCache) this.mCache).removeRunningEntry(Integer.valueOf(taskId));
    }

    void removeObsoleteTaskFiles(ArraySet<Integer> persistentTaskIds, int[] runningUserIds) {
        checkExpiredBackgroundKilledAppInfo();
        this.mPersister.removeObsoleteFiles(persistentTaskIds, runningUserIds);
    }

    void prepareShutdown() {
        final ArrayList<AbsAppSnapshotController.SnapshotSupplier> supplierArrayList = new ArrayList();
        WindowManagerGlobalLock r1 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r1);
        this.mPersister.mSnapshotPersistQueue.setPaused(true);     // Catch: Throwable -> L8
        this.mPersister.mSnapshotPersistQueue.prepareShutdown();     // Catch: Throwable -> L8
        int i = 0;
    L6:
        if (i >= this.mService.mRoot.getChildCount()) goto L11;
        this.mService.mRoot.getChildAt(i).forAllLeafTasks(new TaskSnapshotController$$ExternalSyntheticLambda0(this, supplierArrayList), true);     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L6
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        int i2 = supplierArrayList.size() - 1;
    L13:
        if (i2 < 0) goto L15;
        supplierArrayList.get(i2).handleSnapshot();
        i2 = i2 - 1;
        goto L13
    L15:
        WindowManagerGlobalLock r2 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r2);
        this.mPersister.mSnapshotPersistQueue.setPaused(false);     // Catch: Throwable -> L21
        monitor-exit(r2);     // Catch: Throwable -> L21
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L21:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private /* synthetic */ void lambda$prepareShutdown$2(ArrayList supplierArrayList, final Task task) {
        if (task.isVisible() == true) goto L5;
        return;
    L5:
        if (task.isActivityTypeHome() == true) goto L11;
        AbsAppSnapshotController.SnapshotSupplier supplier = captureSnapshot(task, true);
        if (supplier == null) goto L12;
        supplier.setConsumer(new TaskSnapshotController$$ExternalSyntheticLambda2(this, task));
        supplierArrayList.add(supplier);
        return;
    L12:
        return;
    }

    private /* synthetic */ void lambda$prepareShutdown$1(Task task, TaskSnapshot t) {
        this.mPersister.persistSnapshot(task.mTaskId, task.mUserId, t);
    }

    void waitFlush(long timeout) {
        this.mPersister.mSnapshotPersistQueue.waitFlush(timeout);
    }

    void screenTurningOff(final int displayId, final WindowManagerPolicy.ScreenOffListener listener) {
        if (shouldDisableSnapshots() == false) goto L6;
        listener.onScreenOff();
        return;
    L6:
        this.mHandler.post(new TaskSnapshotController$$ExternalSyntheticLambda5(this, displayId, listener));
    }

    private /* synthetic */ void lambda$screenTurningOff$3(int displayId, WindowManagerPolicy.ScreenOffListener listener) {
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;     // Catch: Throwable -> L9
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L9
        monitor-enter(r0);     // Catch: Throwable -> L9
        snapshotForSleeping(displayId);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L9
        listener.onScreenOff();
        return;
    L11:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L9
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        listener.onScreenOff();
        throw th;
    }

    void snapshotForSleeping(int displayId) {
        if (shouldDisableSnapshots() == false) goto L5;
        return;
    L5:
        if (this.mService.mDisplayEnabled == false) goto L13;
        DisplayContent displayContent = this.mService.mRoot.getDisplayContent(displayId);
        if (displayContent != null) goto L10;
        return;
    L10:
        this.mTmpTasks.clear();
        displayContent.forAllLeafTasks(new TaskSnapshotController$$ExternalSyntheticLambda3(this), true);
        snapshotTasks(this.mTmpTasks);
        return;
    }

    private /* synthetic */ void lambda$snapshotForSleeping$4(Task task) {
        if (task.isActivityTypeHome() == false) goto L6;
        return;
    L6:
        if (task.isVisible() == true) goto L8;
        return;
    L8:
        if (isAnimatingByRecents(task) == true) goto L12;
        this.mTmpTasks.add(task);
        return;
    }
}
