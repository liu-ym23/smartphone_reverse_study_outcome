package com.android.server.wm;

import android.R;
import android.app.ActivityManager;
import android.graphics.Rect;
import android.os.Trace;
import android.util.ArraySet;
import android.util.IntArray;
import android.util.Slog;
import android.util.SparseArray;
import android.window.TaskSnapshot;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes3.dex */
class ActivitySnapshotController extends AbsAppSnapshotController<ActivityRecord, ActivitySnapshotCache> {
    private static final boolean DEBUG = false;
    private static final int MAX_PERSIST_SNAPSHOT_COUNT = 20;
    static final String SNAPSHOTS_DIRNAME = "activity_snapshots";
    private static final String TAG = "WindowManager";
    private final ArraySet<ActivityRecord> mOnBackPressedActivities;
    final ArraySet<ActivityRecord> mPendingDeleteActivity;
    final ArraySet<ActivityRecord> mPendingLoadActivity;
    final ArraySet<ActivityRecord> mPendingRemoveActivity;
    private final BaseAppSnapshotPersister.PersistInfoProvider mPersistInfoProvider;
    private final TaskSnapshotPersister mPersister;
    private final ArrayList<UserSavedFile> mSavedFilesInOrder;
    private final AppSnapshotLoader mSnapshotLoader;
    private final SnapshotPersistQueue mSnapshotPersistQueue;
    private final ArrayList<ActivityRecord> mTmpBelowActivities;
    private final ArrayList<WindowContainer> mTmpTransitionParticipants;
    private final SparseArray<SparseArray<UserSavedFile>> mUserSavedFiles;

    class LoadActivitySnapshotItem extends SnapshotPersistQueue.WriteQueueItem {
        private final ActivityRecord[] mActivities;
        private final int mCode;
        final /* synthetic */ ActivitySnapshotController this$0;

        LoadActivitySnapshotItem(ActivitySnapshotController this$0, ActivityRecord[] activities, int code, int userId, BaseAppSnapshotPersister.PersistInfoProvider persistInfoProvider) {
            this.this$0 = this$0;
            super(persistInfoProvider, userId);
            this.mActivities = activities;
            this.mCode = code;
        }

        @Override // com.android.server.wm.SnapshotPersistQueue.WriteQueueItem
        void write() {
            Trace.traceBegin(32, "load_activity_snapshot");     // Catch: Throwable -> L24
            int r5 = 0;
            TaskSnapshot snapshot = ActivitySnapshotController.m9646$$Nest$fgetmSnapshotLoader(this.this$0).loadTask(this.mCode, this.mUserId, false);     // Catch: Throwable -> L24
            if (snapshot != null) goto L7;
            Trace.traceEnd(32);
            return;
        L7:
            Object r3 = this.this$0.mService.getWindowManagerLock();     // Catch: Throwable -> L24
            monitor-enter(r3);     // Catch: Throwable -> L24
        L14:
            th = move-exception;
            throw th;     // Catch: Throwable -> L24
        L10:
            if (this.this$0.hasRecord(this.mActivities[0]) == true) goto L16;
            monitor-exit(r3);     // Catch: Throwable -> L14
            Trace.traceEnd(32);
            return;
        L16:
            ActivityRecord[] r4 = this.mActivities;     // Catch: Throwable -> L14
            int r6 = r4.length;     // Catch: Throwable -> L14
        L17:
            if (r5 >= r6) goto L19;
            ActivityRecord ar = r4[r5];     // Catch: Throwable -> L14
            ((ActivitySnapshotCache) this.this$0.mCache).putSnapshot(ar, snapshot);     // Catch: Throwable -> L14
            r5 = r5 + 1;     // Catch: Throwable -> L14
            goto L17
        L19:
            monitor-exit(r3);     // Catch: Throwable -> L14
            Trace.traceEnd(32);
            return;
        L24:
            th = move-exception;
            Trace.traceEnd(32);
            throw th;
        }

        public boolean equals(Object o) {
            if (o != null) goto L5;
        L15:
            return false;
        L5:
            if (getClass() != o.getClass()) goto L15;
            LoadActivitySnapshotItem other = (LoadActivitySnapshotItem) o;
            if (this.mCode == other.mCode) goto L10;
            return false;
        L10:
            if (this.mUserId == other.mUserId) goto L12;
            return false;
        L12:
            if (this.mPersistInfoProvider != other.mPersistInfoProvider) goto L18;
            return true;
        L18:
            return false;
        }

        public String toString() {
            return "LoadActivitySnapshotItem{code=" + this.mCode + ", UserId=" + this.mUserId + "}";
        }
    }

    static class UserSavedFile {
        final IntArray mActivityIds;
        final int mFileId;
        final int mUserId;

        UserSavedFile(int fileId, int userId) {
            this.mActivityIds = new IntArray();
            this.mFileId = fileId;
            this.mUserId = userId;
        }

        boolean contains(int code) {
            return this.mActivityIds.contains(code);
        }

        void remove(int code) {
            int index = this.mActivityIds.indexOf(code);
            if (index < 0) goto L6;
            this.mActivityIds.remove(index);
            return;
        }

        ActivityRecord[] filterExistActivities(ArraySet<ActivityRecord> pendingLoadActivity) {
            ArrayList<ActivityRecord> matchedActivities = null;
            int i = pendingLoadActivity.size() - 1;
        L3:
            if (i < 0) goto L11;
            ActivityRecord ar = pendingLoadActivity.valueAt(i);
            if (contains(ActivitySnapshotController.getSystemHashCode(ar)) == false) goto L9;
            if (matchedActivities != null) goto L8;
            matchedActivities = new ArrayList();
        L8:
            matchedActivities.add(ar);
        L9:
            i = i - 1;
            goto L3
        L11:
            if (matchedActivities != null) goto L13;
            return null;
        L13:
            if (matchedActivities.size() == this.mActivityIds.size()) goto L16;
            return null;
        L16:
            return (ActivityRecord[]) matchedActivities.toArray(new ActivityRecord[0]);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("UserSavedFile{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" fileId=");
            sb.append(Integer.toHexString(this.mFileId));
            sb.append(", activityIds=[");
            int i = this.mActivityIds.size() - 1;
        L3:
            if (i < 0) goto L8;
            sb.append(Integer.toHexString(this.mActivityIds.get(i)));
            if (i <= 0) goto L7;
            sb.append(',');
        L7:
            i = i - 1;
            goto L3
        L8:
            sb.append("]");
            sb.append("}");
            return sb.toString();
        }
    }

    public static /* synthetic */ boolean $r8$lambda$UFtlSz8H01SEaT5oyvUlsyj6zTk(Task r0, int r1, TaskFragment r2) {
        return lambda$getActivityBelow$0(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$skAS2XdAF4jBY4e2YOQOtEL1n6A(ActivitySnapshotController r0, ActivityRecord r1) {
        r0.lambda$adjustSavedFileOrder$2(r1);
    }

    public static /* synthetic */ void $r8$lambda$vu49lpFwkreDTHjGOPW9Eij0xec(ActivitySnapshotController r0, boolean r1, ArrayList r2, TaskFragment r3) {
        r0.lambda$getActivityBelow$1(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSnapshotLoader, reason: not valid java name */
    static /* bridge */ /* synthetic */ AppSnapshotLoader m9646$$Nest$fgetmSnapshotLoader(ActivitySnapshotController r0) {
        return r0.mSnapshotLoader;
    }

    @Override // com.android.server.wm.AbsAppSnapshotController
    protected /* bridge */ /* synthetic */ ActivityRecord findAppTokenForSnapshot(WindowContainer r1) {
        return findAppTokenForSnapshot((ActivityRecord) r1);
    }

    @Override // com.android.server.wm.AbsAppSnapshotController
    /* bridge */ /* synthetic */ ActivityManager.TaskDescription getTaskDescription(WindowContainer r1) {
        return getTaskDescription((ActivityRecord) r1);
    }

    @Override // com.android.server.wm.AbsAppSnapshotController
    /* bridge */ /* synthetic */ ActivityRecord getTopActivity(WindowContainer r1) {
        return getTopActivity((ActivityRecord) r1);
    }

    ActivitySnapshotController(WindowManagerService service, SnapshotPersistQueue persistQueue) {
        super(service);
        this.mPendingRemoveActivity = new ArraySet();
        this.mPendingDeleteActivity = new ArraySet();
        this.mPendingLoadActivity = new ArraySet();
        this.mOnBackPressedActivities = new ArraySet();
        this.mTmpBelowActivities = new ArrayList();
        this.mTmpTransitionParticipants = new ArrayList();
        this.mUserSavedFiles = new SparseArray();
        this.mSavedFilesInOrder = new ArrayList();
        if (service.mContext.getResources().getBoolean(R.bool.config_disableWeaverOnUnsecuredUsers) == false) goto L5;
    L7:
        boolean snapshotEnabled = false;
    L8:
        setSnapshotEnabled(snapshotEnabled);
        this.mSnapshotPersistQueue = persistQueue;
        this.mPersistInfoProvider = createPersistInfoProvider(service);
        this.mPersister = new TaskSnapshotPersister(persistQueue, this.mPersistInfoProvider, shouldDisableSnapshots());
        this.mSnapshotLoader = new AppSnapshotLoader(this.mPersistInfoProvider);
        initialize(new ActivitySnapshotCache());
        return;
    L5:
        if (ActivityManager.isLowRamDeviceStatic() == true) goto L7;
        snapshotEnabled = true;
        goto L8
    }

    BaseAppSnapshotPersister.PersistInfoProvider createPersistInfoProvider(WindowManagerService service) {
        return createPersistInfoProvider(service, new ActivitySnapshotController$$ExternalSyntheticLambda3());
    }

    @Override // com.android.server.wm.AbsAppSnapshotController
    protected float initSnapshotScale() {
        float config = this.mService.mContext.getResources().getFloat(R.dimen.docked_stack_minimize_thickness);
        return Math.max(Math.min(config, 1.0f), 0.1f);
    }

    static BaseAppSnapshotPersister.PersistInfoProvider createPersistInfoProvider(WindowManagerService service, BaseAppSnapshotPersister.DirectoryResolver resolver) {
        boolean use16BitFormat = service.mContext.getResources().getBoolean(R.bool.config_useSmsAppService);
        return new BaseAppSnapshotPersister.PersistInfoProvider(resolver, SNAPSHOTS_DIRNAME, false, 0.0f, use16BitFormat);
    }

    TaskSnapshot getSnapshot(ActivityRecord[] activities) {
        if (activities.length != 0) goto L5;
        return null;
    L5:
        UserSavedFile tmpUsf = findSavedFile(activities[0]);
        if (tmpUsf != null) goto L8;
    L18:
        return null;
    L8:
        if (tmpUsf.mActivityIds.size() != activities.length) goto L18;
        int fileId = 0;
        int i = activities.length - 1;
    L11:
        if (i < 0) goto L13;
        fileId = fileId ^ getSystemHashCode(activities[i]);
        i = i - 1;
        goto L11
    L13:
        int i2 = tmpUsf.mFileId;
        if (i2 == fileId) goto L17;
        return null;
    L17:
        return ((ActivitySnapshotCache) this.mCache).getSnapshotInner(Integer.valueOf(tmpUsf.mActivityIds.get(0)));
    }

    private void cleanUpUserFiles(final int userId) {
        Object r0 = this.mSnapshotPersistQueue.getLock();
        monitor-enter(r0);
        SnapshotPersistQueue r1 = this.mSnapshotPersistQueue;     // Catch: Throwable -> L7
        final BaseAppSnapshotPersister.PersistInfoProvider r3 = this.mPersistInfoProvider;     // Catch: Throwable -> L7
        r1.sendToQueueLocked(new AnonymousClass1(this, r3, userId));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void addOnBackPressedActivity(ActivityRecord ar) {
        if (shouldDisableSnapshots() == false) goto L5;
        return;
    L5:
        this.mOnBackPressedActivities.add(ar);
    }

    void clearOnBackPressedActivities() {
        if (shouldDisableSnapshots() == false) goto L5;
        return;
    L5:
        this.mOnBackPressedActivities.clear();
    }

    void beginSnapshotProcess() {
        if (shouldDisableSnapshots() == false) goto L5;
        return;
    L5:
        resetTmpFields();
    }

    void endSnapshotProcess() {
        if (shouldDisableSnapshots() == false) goto L5;
        return;
    L5:
        int i = this.mOnBackPressedActivities.size() - 1;
    L6:
        if (i < 0) goto L8;
        handleActivityTransition(this.mOnBackPressedActivities.valueAt(i));
        i = i - 1;
        goto L6
    L8:
        this.mOnBackPressedActivities.clear();
        this.mTmpTransitionParticipants.clear();
        postProcess();
    }

    void resetTmpFields() {
        this.mPendingRemoveActivity.clear();
        this.mPendingDeleteActivity.clear();
        this.mPendingLoadActivity.clear();
    }

    private void postProcess() {
        loadActivitySnapshot();
        int i = this.mPendingRemoveActivity.size() - 1;
    L3:
        if (i < 0) goto L5;
        ActivityRecord ar = this.mPendingRemoveActivity.valueAt(i);
        removeCachedFiles(ar);
        i = i - 1;
        goto L3
    L5:
        int i2 = this.mPendingDeleteActivity.size() - 1;
    L6:
        if (i2 < 0) goto L8;
        ActivityRecord ar2 = this.mPendingDeleteActivity.valueAt(i2);
        removeIfUserSavedFileExist(ar2);
        i2 = i2 - 1;
        goto L6
    L8:
        resetTmpFields();
    }

    void loadActivitySnapshot() {
        if (this.mPendingLoadActivity.isEmpty() == false) goto L5;
        return;
    L5:
        ArraySet<UserSavedFile> loadingFiles = new ArraySet();
        int i = this.mPendingLoadActivity.size() - 1;
    L6:
        if (i < 0) goto L11;
        ActivityRecord ar = this.mPendingLoadActivity.valueAt(i);
        UserSavedFile usf = findSavedFile(ar);
        if (usf == null) goto L10;
        loadingFiles.add(usf);
    L10:
        i = i - 1;
        goto L6
    L11:
        int i2 = loadingFiles.size();
        int i3 = i2 - 1;
    L12:
        if (i3 < 0) goto L22;
        UserSavedFile usf2 = loadingFiles.valueAt(i3);
        ActivityRecord[] activities = usf2.filterExistActivities(this.mPendingLoadActivity);
        if (activities == null) goto L20;
        if (getSnapshot(activities) != null) goto L20;
        loadSnapshotInner(activities, usf2);
    L20:
        i3 = i3 - 1;
        goto L12
    }

    void loadSnapshotInner(ActivityRecord[] activities, UserSavedFile usf) {
        Object r1 = this.mSnapshotPersistQueue.getLock();
        monitor-enter(r1);
        SnapshotPersistQueue r0 = this.mSnapshotPersistQueue;     // Catch: Throwable -> L11
        r0.insertQueueAtFirstLocked(new LoadActivitySnapshotItem(this, activities, usf.mFileId, usf.mUserId, this.mPersistInfoProvider));     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Throwable r9 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r9;
    L11:
        th = move-exception;
        r9 = th;
        goto L13
    }

    void recordSnapshot(ArrayList<ActivityRecord> activity) {
        if (shouldDisableSnapshots() == false) goto L5;
        return;
    L5:
        if (activity.isEmpty() == false) goto L8;
        return;
    L8:
        if (this.mPersister.mSnapshotPersistQueue.peekWriteQueueSize() < 2) goto L10;
    L29:
        Slog.w(TAG, "Skipping recording activity snapshot, too many requests!");
        return;
    L10:
        if (this.mPersister.mSnapshotPersistQueue.peekQueueSize() > 20) goto L29;
        int size = activity.size();
        int[] mixedCode = new int[size];
        if (size != 1) goto L20;
        ActivityRecord singleActivity = activity.get(0);
        TaskSnapshot snapshot = null;
        Supplier<TaskSnapshot> supplier = recordSnapshotInner(singleActivity, false, null);
        if (supplier == null) goto L17;
        snapshot = supplier.get();
    L17:
        if (snapshot == null) goto L33;
        mixedCode[0] = getSystemHashCode(singleActivity);
        addUserSavedFile(singleActivity.mUserId, snapshot, mixedCode);
        return;
    L33:
        return;
    L20:
        Task mainTask = activity.get(0).getTask();
        TaskSnapshot snapshot2 = this.mService.mTaskSnapshotController.snapshot(mainTask, this.mHighResSnapshotScale);
        if (snapshot2 != null) goto L23;
        return;
    L23:
        int i = 0;
    L25:
        if (i >= activity.size()) goto L27;
        ActivityRecord next = activity.get(i);
        ((ActivitySnapshotCache) this.mCache).putSnapshot(next, snapshot2);
        mixedCode[i] = getSystemHashCode(next);
        i = i + 1;
        goto L25
    L27:
        int i2 = mainTask.mUserId;
        addUserSavedFile(i2, snapshot2, mixedCode);
    }

    void notifyAppVisibilityChanged(ActivityRecord ar, boolean visible) {
        if (shouldDisableSnapshots() == false) goto L5;
        return;
    L5:
        Task task = ar.getTask();
        if (task != null) goto L8;
        return;
    L8:
        if (visible == true) goto L11;
        resetTmpFields();
        addBelowActivityIfExist(ar, this.mPendingRemoveActivity, false, "remove-snapshot");
        postProcess();
        return;
    }

    static int getSystemHashCode(ActivityRecord activity) {
        return System.identityHashCode(activity);
    }

    void handleTransitionFinish(ArrayList<WindowContainer> windows) {
        this.mTmpTransitionParticipants.clear();
        this.mTmpTransitionParticipants.addAll(windows);
        int i = this.mTmpTransitionParticipants.size() - 1;
    L3:
        if (i < 0) goto L18;
        WindowContainer next = this.mTmpTransitionParticipants.get(i);
        if (next.asTask() == null) goto L8;
        handleTaskTransition(next.asTask());
    L16:
        i = i - 1;
        goto L3
    L8:
        if (next.asTaskFragment() == null) goto L14;
        TaskFragment tf = next.asTaskFragment();
        ActivityRecord ar = tf.getTopMostActivity();
        if (ar == null) goto L16;
        handleActivityTransition(ar);
        goto L16
    L14:
        if (next.asActivityRecord() == null) goto L16;
        handleActivityTransition(next.asActivityRecord());
        goto L16
    }

    private void handleActivityTransition(ActivityRecord ar) {
        if (shouldDisableSnapshots() == false) goto L6;
        return;
    L6:
        if (ar.isVisibleRequested() == false) goto L8;
        this.mPendingDeleteActivity.add(ar);
        addBelowActivityIfExist(ar, this.mPendingLoadActivity, false, "load-snapshot");
        return;
    L8:
        addBelowActivityIfExist(ar, this.mPendingRemoveActivity, false, "remove-snapshot");
    }

    private void handleTaskTransition(Task task) {
        if (shouldDisableSnapshots() == false) goto L5;
        return;
    L5:
        ActivityRecord topActivity = task.getTopMostActivity();
        if (topActivity != null) goto L9;
        return;
    L9:
        if (task.isVisibleRequested() == false) goto L11;
        addBelowActivityIfExist(topActivity, this.mPendingLoadActivity, true, "load-snapshot");
        adjustSavedFileOrder(task);
        return;
    L11:
        addBelowActivityIfExist(topActivity, this.mPendingRemoveActivity, true, "remove-snapshot");
    }

    private void addBelowActivityIfExist(ActivityRecord currentActivity, ArraySet<ActivityRecord> set, boolean inTransition, String debugMessage) {
        getActivityBelow(currentActivity, inTransition, this.mTmpBelowActivities);
        int i = this.mTmpBelowActivities.size() - 1;
    L3:
        if (i < 0) goto L5;
        set.add(this.mTmpBelowActivities.get(i));
        i = i - 1;
        goto L3
    L5:
        this.mTmpBelowActivities.clear();
    }

    private void getActivityBelow(ActivityRecord currentActivity, final boolean inTransition, final ArrayList<ActivityRecord> result) {
        final Task currentTask = currentActivity.getTask();
        if (currentTask != null) goto L5;
        return;
    L5:
        ActivityRecord initPrev = currentTask.getActivityBelow(currentActivity);
        if (initPrev != null) goto L8;
        return;
    L8:
        TaskFragment currTF = currentActivity.getTaskFragment();
        TaskFragment prevTF = initPrev.getTaskFragment();
        if (currTF != prevTF) goto L11;
    L32:
        if (inTransition == true) goto L34;
    L35:
        result.add(initPrev);
        return;
    L34:
        if (isInParticipant(initPrev, this.mTmpTransitionParticipants) == true) goto L35;
        return;
    L11:
        if (prevTF.asTask() != null) goto L32;
        if (prevTF.hasAdjacentTaskFragment() == false) goto L32;
        if (currTF.isAdjacentTo(prevTF) == false) goto L20;
        getActivityBelow(initPrev, inTransition, result);
        return;
    L20:
        if (currTF.asTask() == null) goto L22;
        final int currentIndex = currentTask.mChildren.indexOf(currentActivity);
    L23:
        boolean hasAdjacentAboveCurrent = prevTF.forOtherAdjacentTaskFragments(new ActivitySnapshotController$$ExternalSyntheticLambda1(currentTask, currentIndex));
        if (hasAdjacentAboveCurrent == false) goto L26;
        return;
    L26:
        if (inTransition == true) goto L28;
    L29:
        result.add(initPrev);
    L30:
        prevTF.forOtherAdjacentTaskFragments(new ActivitySnapshotController$$ExternalSyntheticLambda2(this, inTransition, result));
        return;
    L28:
        if (isInParticipant(initPrev, this.mTmpTransitionParticipants) == false) goto L30;
    L22:
        currentIndex = currentTask.mChildren.indexOf(currTF);
        goto L23
    }

    private static /* synthetic */ boolean lambda$getActivityBelow$0(Task currentTask, int currentIndex, TaskFragment prevAdjacentTF) {
        int prevAdjacentIndex = currentTask.mChildren.indexOf(prevAdjacentTF);
        if (prevAdjacentIndex <= currentIndex) goto L5;
        return true;
    L5:
        return false;
    }

    private /* synthetic */ void lambda$getActivityBelow$1(boolean inTransition, ArrayList result, TaskFragment prevAdjacentTF) {
        ActivityRecord prevAdjacentActivity = prevAdjacentTF.getTopMostActivity();
        if (prevAdjacentActivity == null) goto L9;
        if (inTransition == true) goto L6;
    L7:
        result.add(prevAdjacentActivity);
        return;
    L6:
        if (isInParticipant(prevAdjacentActivity, this.mTmpTransitionParticipants) == true) goto L7;
        return;
    }

    static boolean isInParticipant(ActivityRecord ar, ArrayList<WindowContainer> transitionParticipants) {
        int i = transitionParticipants.size() - 1;
    L3:
        if (i < 0) goto L11;
        WindowContainer wc = transitionParticipants.get(i);
        if (ar == wc) goto L10;
        if (ar.isDescendantOf(wc) == true) goto L10;
        i = i - 1;
    L10:
        return true;
    L11:
        return false;
    }

    private void adjustSavedFileOrder(Task nextTopTask) {
        nextTopTask.forAllActivities(new ActivitySnapshotController$$ExternalSyntheticLambda0(this), false);
    }

    private /* synthetic */ void lambda$adjustSavedFileOrder$2(ActivityRecord ar) {
        UserSavedFile usf = findSavedFile(ar);
        if (usf == null) goto L6;
        this.mSavedFilesInOrder.remove(usf);
        this.mSavedFilesInOrder.add(usf);
        return;
    }

    @Override // com.android.server.wm.AbsAppSnapshotController
    void onAppRemoved(ActivityRecord activity) {
        if (shouldDisableSnapshots() == false) goto L5;
        return;
    L5:
        removeIfUserSavedFileExist(activity);
    }

    @Override // com.android.server.wm.AbsAppSnapshotController
    void onAppDied(ActivityRecord activity) {
        if (shouldDisableSnapshots() == false) goto L5;
        return;
    L5:
        removeIfUserSavedFileExist(activity);
    }

    ActivityRecord getTopActivity(ActivityRecord activity) {
        return activity;
    }

    ActivityManager.TaskDescription getTaskDescription(ActivityRecord object) {
        return object.taskDescription;
    }

    protected ActivityRecord findAppTokenForSnapshot(ActivityRecord activity) {
        if (activity != null) goto L6;
        return null;
    L6:
        if (activity.canCaptureSnapshot() == true) goto L8;
        return null;
    L8:
        return activity;
    }

    @Override // com.android.server.wm.AbsAppSnapshotController
    protected boolean use16BitFormat() {
        return this.mPersistInfoProvider.use16BitFormat();
    }

    @Override // com.android.server.wm.AbsAppSnapshotController
    protected Rect getLetterboxInsets(ActivityRecord topActivity) {
        return Letterbox.EMPTY_RECT;
    }

    private SparseArray<UserSavedFile> getUserFiles(int userId) {
        if (this.mUserSavedFiles.get(userId) != null) goto L6;
        this.mUserSavedFiles.put(userId, new SparseArray());
        cleanUpUserFiles(userId);
    L6:
        return this.mUserSavedFiles.get(userId);
    }

    UserSavedFile findSavedFile(ActivityRecord ar) {
        int code = getSystemHashCode(ar);
        return findSavedFile(ar.mUserId, code);
    }

    UserSavedFile findSavedFile(int userId, int code) {
        SparseArray<UserSavedFile> usfs = getUserFiles(userId);
        return usfs.get(code);
    }

    private void removeCachedFiles(ActivityRecord ar) {
        UserSavedFile usf = findSavedFile(ar);
        if (usf == null) goto L7;
        int i = usf.mActivityIds.size() - 1;
    L5:
        if (i < 0) goto L9;
        int activityId = usf.mActivityIds.get(i);
        ((ActivitySnapshotCache) this.mCache).onIdRemoved(Integer.valueOf(activityId));
        i = i - 1;
        goto L5
    L9:
        return;
    }

    private void removeIfUserSavedFileExist(ActivityRecord ar) {
        UserSavedFile usf = findSavedFile(ar);
        if (usf == null) goto L10;
        SparseArray<UserSavedFile> usfs = getUserFiles(ar.mUserId);
        int i = usf.mActivityIds.size() - 1;
    L5:
        if (i < 0) goto L7;
        int activityId = usf.mActivityIds.get(i);
        usf.remove(activityId);
        ((ActivitySnapshotCache) this.mCache).onIdRemoved(Integer.valueOf(activityId));
        usfs.remove(activityId);
        i = i - 1;
        goto L5
    L7:
        this.mSavedFilesInOrder.remove(usf);
        this.mPersister.removeSnapshot(usf.mFileId, ar.mUserId);
        return;
    }

    boolean hasRecord(ActivityRecord ar) {
        if (findSavedFile(ar) == null) goto L5;
        return true;
    L5:
        return false;
    }

    void addUserSavedFile(int userId, TaskSnapshot snapshot, int[] code) {
        UserSavedFile savedFile = findSavedFile(userId, code[0]);
        if (savedFile == null) goto L6;
        Slog.w(TAG, "Duplicate request for recording activity snapshot " + savedFile);
        return;
    L6:
        int fileId = 0;
        int i = code.length - 1;
    L7:
        if (i < 0) goto L9;
        fileId = fileId ^ code[i];
        i = i - 1;
        goto L7
    L9:
        UserSavedFile usf = new UserSavedFile(fileId, userId);
        SparseArray<UserSavedFile> usfs = getUserFiles(userId);
        int i2 = code.length - 1;
    L10:
        if (i2 < 0) goto L12;
        usfs.put(code[i2], usf);
        i2 = i2 - 1;
        goto L10
    L12:
        usf.mActivityIds.addAll(code);
        this.mSavedFilesInOrder.add(usf);
        this.mPersister.persistSnapshot(fileId, userId, snapshot);
        if (this.mSavedFilesInOrder.size() <= 40) goto L18;
        purgeSavedFile();
        return;
    }

    private void purgeSavedFile() {
        int savedFileCount = this.mSavedFilesInOrder.size();
        int removeCount = savedFileCount - 20;
        if (removeCount >= 1) goto L5;
        return;
    L5:
        ArrayList<UserSavedFile> removeTargets = new ArrayList();
        int i = removeCount - 1;
    L6:
        if (i < 0) goto L11;
        UserSavedFile usf = this.mSavedFilesInOrder.remove(i);
        SparseArray<UserSavedFile> files = this.mUserSavedFiles.get(usf.mUserId);
        int j = usf.mActivityIds.size() - 1;
    L8:
        if (j < 0) goto L10;
        ((ActivitySnapshotCache) this.mCache).removeRunningEntry(Integer.valueOf(usf.mActivityIds.get(j)));
        files.remove(usf.mActivityIds.get(j));
        j = j - 1;
        goto L8
    L10:
        removeTargets.add(usf);
        i = i - 1;
        goto L6
    L11:
        int i2 = removeTargets.size();
        int i3 = i2 - 1;
    L12:
        if (i3 < 0) goto L15;
        UserSavedFile usf2 = removeTargets.get(i3);
        this.mPersister.removeSnapshot(usf2.mFileId, usf2.mUserId);
        i3 = i3 - 1;
        goto L12
    }

    @Override // com.android.server.wm.AbsAppSnapshotController
    void dump(PrintWriter pw, String prefix) {
        super.dump(pw, prefix);
        String doublePrefix = prefix + "  ";
        String triplePrefix = doublePrefix + "  ";
        int i = this.mUserSavedFiles.size() - 1;
    L3:
        if (i < 0) goto L12;
        SparseArray<UserSavedFile> usfs = this.mUserSavedFiles.valueAt(i);
        pw.println(doublePrefix + "UserSavedFile userId=" + this.mUserSavedFiles.keyAt(i));
        ArraySet<UserSavedFile> sets = new ArraySet();
        int j = usfs.size() + (-1);
    L5:
        if (j < 0) goto L7;
        sets.add(usfs.valueAt(j));
        j = j - 1;
        goto L5
    L7:
        int j2 = sets.size();
        int j3 = j2 - 1;
    L8:
        if (j3 < 0) goto L10;
        pw.println(triplePrefix + "SavedFile=" + sets.valueAt(j3));
        j3 = j3 + (-1);
        goto L8
    L10:
        i = i - 1;
        goto L3
    }
}
