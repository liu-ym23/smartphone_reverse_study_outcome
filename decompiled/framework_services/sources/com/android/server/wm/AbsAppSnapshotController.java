package com.android.server.wm;

import android.R;
import android.app.ActivityManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.graphics.RecordingCanvas;
import android.graphics.Rect;
import android.graphics.RenderNode;
import android.hardware.HardwareBuffer;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.Trace;
import android.pico.utils.Features;
import android.util.Pair;
import android.util.Slog;
import android.view.InsetsState;
import android.view.SurfaceControl;
import android.view.ThreadedRenderer;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.window.ScreenCapture;
import android.window.SnapshotDrawerUtils;
import android.window.TaskSnapshot;
import com.android.internal.graphics.ColorUtils;
import com.android.server.wm.SnapshotCache;
import com.android.server.wm.WindowContainer;
import com.android.server.wm.utils.InsetUtils;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes3.dex */
abstract class AbsAppSnapshotController<TYPE extends WindowContainer, CACHE extends SnapshotCache<TYPE>> {
    static final int MAX_BACKGROUND_KILLED_INFOS = 0;
    static final int MAX_BACKGROUND_KILLED_INFO_USERS = 0;
    public static long MAX_PERIOD_TO_REMOVE_EXPIRED_INFOS = 0;
    static final int SNAPSHOT_MODE_APP_THEME = 1;
    static final int SNAPSHOT_MODE_NONE = 2;
    static final int SNAPSHOT_MODE_REAL = 0;
    static final String TAG = "WindowManager";
    static final float THEME_SNAPSHOT_MIN_Length = 128.0f;
    public static boolean mFeatureQuickStartingWindowDebug;
    public static boolean mFeatureQuickStartingWindowEnable;
    protected CACHE mCache;
    protected Transition.ChangeInfo mCurrentChangeInfo;
    protected final float mHighResSnapshotScale;
    protected final boolean mIsRunningOnIoT;
    protected final boolean mIsRunningOnTv;
    protected final WindowManagerService mService;
    private boolean mSnapshotEnabled;
    private final HashMap<Integer, HashMap<Integer, AbsAppSnapshotController<TYPE, CACHE>.BackgroundKilledAppInfo>> mUsersBackgroundKilledAppInfos;
    private final HashMap<Integer, TreeSet<Long>> mUsersBackgroundKilledAppTimestamps;

    public class BackgroundKilledAppInfo {
        public TaskSnapshot mSnapshot;
        public int mTaskId;
        public long mTimestamp;
        public int mUId;
        public int mUserId;

        BackgroundKilledAppInfo(AbsAppSnapshotController this$0, TaskSnapshot snapshot, int taskid, int userid, int uid, long timestamp) {
            this.mSnapshot = snapshot;
            this.mTaskId = taskid;
            this.mUserId = userid;
            this.mUId = uid;
            this.mTimestamp = timestamp;
        }
    }

    public static class FetchCacheEntry {
        public TaskSnapshot mSnapshot;
        public int mTaskId;

        FetchCacheEntry(TaskSnapshot snapshot, int taskid) {
            this.mSnapshot = snapshot;
            this.mTaskId = taskid;
        }
    }

    static class SnapshotSupplier implements Supplier<TaskSnapshot> {
        private Consumer<TaskSnapshot> mConsumer;
        private boolean mHasSet;
        private TaskSnapshot mSnapshot;
        private Supplier<TaskSnapshot> mSupplier;

        SnapshotSupplier() {
        }

        @Override // java.util.function.Supplier
        public /* bridge */ /* synthetic */ TaskSnapshot get() {
            return get();
        }

        void setConsumer(Consumer<TaskSnapshot> consumer) {
            this.mConsumer = consumer;
        }

        void setSupplier(Supplier<TaskSnapshot> createSupplier) {
            this.mSupplier = createSupplier;
        }

        void setSnapshot(TaskSnapshot snapshot) {
            this.mSnapshot = snapshot;
        }

        void handleSnapshot() {
            if (this.mHasSet == false) goto L5;
            return;
        L5:
            this.mHasSet = true;
            if (this.mSnapshot != null) goto L13;
            if (this.mSupplier == null) goto L10;
            TaskSnapshot r0 = this.mSupplier.get();
        L11:
            this.mSnapshot = r0;
            goto L13
        L10:
            r0 = null;
        L13:
            if (this.mConsumer != null) goto L15;
            return;
        L15:
            if (this.mSnapshot == null) goto L19;
            this.mConsumer.accept(this.mSnapshot);
            return;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.function.Supplier
        public TaskSnapshot get() {
            handleSnapshot();
            return this.mSnapshot;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$9lPJ2o9QEm-SsCOn95NbpJpCRPo, reason: not valid java name */
    public static /* synthetic */ void m9585$r8$lambda$9lPJ2o9QEmSsCOn95NbpJpCRPo(AbsAppSnapshotController r0, WindowContainer r1, Consumer r2, TaskSnapshot r3) {
        r0.lambda$recordSnapshotInner$0(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$rUA7BKb_tu-qRrpgQfCNvHbszzk, reason: not valid java name */
    public static /* synthetic */ TaskSnapshot m9586$r8$lambda$rUA7BKb_tuqRrpgQfCNvHbszzk(RenderNode r0, int r1, int r2, TaskSnapshot.Builder r3) {
        return lambda$drawAppThemeSnapshot$1(r0, r1, r2, r3);
    }

    protected abstract ActivityRecord findAppTokenForSnapshot(TYPE r1);

    protected abstract Rect getLetterboxInsets(ActivityRecord r1);

    abstract ActivityManager.TaskDescription getTaskDescription(TYPE r1);

    abstract ActivityRecord getTopActivity(TYPE r1);

    protected abstract boolean use16BitFormat();

    static {
        MAX_PERIOD_TO_REMOVE_EXPIRED_INFOS = SystemProperties.getLong("debug.perf.quick_starting_window_expired", 600000);
        mFeatureQuickStartingWindowEnable = SystemProperties.getBoolean("debug.perf.quick_starting_window", true);
        mFeatureQuickStartingWindowDebug = SystemProperties.getBoolean("debug.perf.quick_starting_window_debug", false);
        MAX_BACKGROUND_KILLED_INFO_USERS = SystemProperties.getInt("debug.perf.quick_starting_window_max_user", 2);
        MAX_BACKGROUND_KILLED_INFOS = SystemProperties.getInt("debug.perf.quick_starting_window_max_info", 10);
    }

    AbsAppSnapshotController(WindowManagerService service) {
        this.mUsersBackgroundKilledAppInfos = new HashMap();
        this.mUsersBackgroundKilledAppTimestamps = new HashMap();
        this.mService = service;
        this.mIsRunningOnTv = this.mService.mContext.getPackageManager().hasSystemFeature("android.software.leanback");
        this.mIsRunningOnIoT = this.mService.mContext.getPackageManager().hasSystemFeature("android.hardware.type.embedded");
        this.mHighResSnapshotScale = initSnapshotScale();
    }

    protected float initSnapshotScale() {
        float config = this.mService.mContext.getResources().getFloat(R.dimen.default_magnifier_horizontal_offset);
        return Math.max(Math.min(config, 1.0f), 0.1f);
    }

    protected void initialize(CACHE cache) {
        this.mCache = cache;
    }

    void setSnapshotReleaser(Consumer<HardwareBuffer> releaser) {
        this.mCache.setSafeSnapshotReleaser(releaser);
    }

    void setSnapshotEnabled(boolean enabled) {
        this.mSnapshotEnabled = enabled;
    }

    boolean shouldDisableSnapshots() {
        if (this.mIsRunningOnTv == false) goto L5;
    L10:
        return true;
    L5:
        if (this.mIsRunningOnIoT == true) goto L10;
        if (this.mSnapshotEnabled == false) goto L10;
        return false;
    }

    SnapshotSupplier captureSnapshot(TYPE source, boolean allowAppTheme) {
        SnapshotSupplier supplier = new SnapshotSupplier();
        switch(getSnapshotMode(source)) {
            case 0: goto L9;
            case 1: goto L5;
            default: goto L10;
        };
    L5:
        Trace.traceBegin(32, "drawAppThemeSnapshot");
        if (allowAppTheme == false) goto L8;
        supplier.setSupplier(drawAppThemeSnapshot(source));
    L8:
        Trace.traceEnd(32);
        goto L10
    L9:
        supplier.setSnapshot(snapshot(source));
    L10:
        return supplier;
    }

    final SnapshotSupplier recordSnapshotInner(final TYPE source, boolean allowAppTheme, final Consumer<TaskSnapshot> inLockConsumer) {
        if (shouldDisableSnapshots() == false) goto L6;
        return null;
    L6:
        SnapshotSupplier supplier = captureSnapshot(source, allowAppTheme);
        supplier.setConsumer(new AbsAppSnapshotController$$ExternalSyntheticLambda0(this, source, inLockConsumer));
        return supplier;
    }

    private /* synthetic */ void lambda$recordSnapshotInner$0(WindowContainer source, Consumer inLockConsumer, TaskSnapshot t) {
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (source.isAttached() == true) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L11:
        this.mCache.putSnapshot(source, t);     // Catch: Throwable -> L9
        if (inLockConsumer == null) goto L14;
        inLockConsumer.accept(t);     // Catch: Throwable -> L9
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
    }

    int getSnapshotMode(TYPE source) {
        int type = source.getActivityType();
        if (type != 3) goto L5;
    L17:
        return 2;
    L5:
        if (type == 5) goto L17;
        if (type != 2) goto L10;
        return 0;
    L10:
        ActivityRecord topChild = getTopActivity(source);
        if (topChild != null) goto L13;
    L16:
        return 0;
    L13:
        if (topChild.shouldUseAppThemeSnapshot() == false) goto L16;
        return 1;
    }

    TaskSnapshot snapshot(TYPE source) {
        return snapshot(source, this.mHighResSnapshotScale);
    }

    TaskSnapshot snapshot(TYPE source, float scale) {
        TaskSnapshot.Builder builder = new TaskSnapshot.Builder();
        Rect crop = prepareTaskSnapshot(source, builder);
        if (crop != null) goto L5;
        return null;
    L5:
        Trace.traceBegin(32, "createSnapshot");
        ScreenCapture.ScreenshotHardwareBuffer screenshotBuffer = createSnapshot(source, scale, crop, builder);
        Trace.traceEnd(32);
        if (screenshotBuffer != null) goto L8;
        return null;
    L8:
        builder.setCaptureTime(SystemClock.elapsedRealtimeNanos());
        builder.setSnapshot(screenshotBuffer.getHardwareBuffer());
        builder.setColorSpace(screenshotBuffer.getColorSpace());
        TaskSnapshot snapshot = builder.build();
        return validateSnapshot(snapshot);
    }

    private static TaskSnapshot validateSnapshot(TaskSnapshot snapshot) {
        HardwareBuffer buffer = snapshot.getHardwareBuffer();
        if (buffer.getWidth() != 0) goto L5;
    L8:
        buffer.close();
        Slog.e(TAG, "Invalid snapshot dimensions " + buffer.getWidth() + "x" + buffer.getHeight());
        return null;
    L5:
        if (buffer.getHeight() == 0) goto L8;
        return snapshot;
    }

    ScreenCapture.ScreenshotHardwareBuffer createSnapshot(TYPE source, float scaleFraction, Rect crop, TaskSnapshot.Builder builder) {
        if (source.getSurfaceControl() == null) goto L5;
        WindowState imeWindow = source.getDisplayContent().mInputMethodWindow;
        boolean r2 = true;
        if (imeWindow != null) goto L11;
    L15:
        boolean excludeIme = false;
    L16:
        WindowState navWindow = source.getDisplayContent().getDisplayPolicy().getNavigationBar();
        if (navWindow == null) goto L19;
        boolean excludeNavBar = true;
    L20:
        if (excludeIme == false) goto L23;
        if (excludeNavBar == false) goto L23;
        SurfaceControl[] excludeLayers = {imeWindow.getSurfaceControl(), navWindow.getSurfaceControl()};
    L33:
        if (Features.FEAT_QUICK_WIN == true) goto L35;
    L37:
        if (excludeIme == true) goto L42;
        if (imeWindow == null) goto L42;
        if (imeWindow.isVisible() == false) goto L42;
    L43:
        builder.setHasImeSurface(r2);
        ScreenCapture.ScreenshotHardwareBuffer screenshotBuffer = ScreenCapture.captureLayersExcluding(source.getSurfaceControl(), crop, scaleFraction, builder.getPixelFormat(), excludeLayers);
        if (screenshotBuffer != null) goto L46;
        HardwareBuffer buffer = null;
    L48:
        if (isInvalidHardwareBuffer(buffer) == false) goto L50;
        return null;
    L50:
        return screenshotBuffer;
    L46:
        buffer = screenshotBuffer.getHardwareBuffer();
    L42:
        r2 = false;
        goto L43
    L35:
        if (source.inFreeformWindowingMode() == false) goto L37;
        excludeLayers = source.getDisplayContent().mWmService.getExt().handleQuickWinSnapshot(excludeLayers);
    L23:
        if (excludeIme == true) goto L27;
        if (excludeNavBar == true) goto L27;
        excludeLayers = new SurfaceControl[0];
    L27:
        excludeLayers = new SurfaceControl[1];
        if (excludeIme == false) goto L30;
        SurfaceControl r8 = imeWindow.getSurfaceControl();
    L31:
        excludeLayers[0] = r8;
        goto L33
    L30:
        r8 = navWindow.getSurfaceControl();
        goto L31
    L19:
        excludeNavBar = false;
        goto L20
    L11:
        if (imeWindow.getSurfaceControl() == null) goto L15;
        if (source.getDisplayContent().shouldImeAttachedToApp() == true) goto L15;
        excludeIme = true;
        goto L16
    L5:
        if (WindowManagerDebugConfig.DEBUG_SCREENSHOT == false) goto L7;
        Slog.w(TAG, "Failed to take screenshot. No surface control for " + source);
    L7:
        return null;
    }

    static boolean isInvalidHardwareBuffer(HardwareBuffer buffer) {
        if (buffer != null) goto L5;
        return true;
    L5:
        if (buffer.isClosed() == false) goto L7;
        return true;
    L7:
        if (buffer.getWidth() > 1) goto L9;
        return true;
    L9:
        if (buffer.getHeight() <= 1) goto L17;
        return false;
    L17:
        return true;
    }

    Rect prepareTaskSnapshot(TYPE source, TaskSnapshot.Builder builder) {
        Pair<ActivityRecord, WindowState> result = checkIfReadyToSnapshot(source);
        if (result != null) goto L6;
        return null;
    L6:
        ActivityRecord activity = (ActivityRecord) result.first;
        WindowState mainWindow = (WindowState) result.second;
        Rect contentInsets = getSystemBarInsets(mainWindow.getFrame(), mainWindow.getInsetsStateWithVisibilityOverride());
        Rect letterboxInsets = getLetterboxInsets(activity);
        InsetUtils.addInsets(contentInsets, letterboxInsets);
        builder.setIsRealSnapshot(true);
        builder.setId(System.currentTimeMillis());
        builder.setContentInsets(contentInsets);
        builder.setLetterboxInsets(letterboxInsets);
        if (mainWindow.mAttrs.format == (-1)) goto L9;
        boolean isWindowTranslucent = true;
    L10:
        boolean isShowWallpaper = mainWindow.hasWallpaper();
        int pixelFormat = builder.getPixelFormat();
        if (pixelFormat != 0) goto L22;
        if (use16BitFormat() == true) goto L15;
    L19:
        int r12 = 1;
    L20:
        pixelFormat = r12;
        goto L22
    L15:
        if (activity.fillsParent() == false) goto L19;
        if (isWindowTranslucent == false) goto L18;
        if (isShowWallpaper == true) goto L19;
    L18:
        r12 = 4;
    L22:
        if (PixelFormat.formatHasAlpha(pixelFormat) == true) goto L24;
    L27:
        boolean isTranslucent = false;
    L28:
        builder.setTopActivityComponent(activity.mActivityComponent);
        builder.setPixelFormat(pixelFormat);
        builder.setIsTranslucent(isTranslucent);
        builder.setWindowingMode(source.getWindowingMode());
        builder.setAppearance(mainWindow.mAttrs.insetsFlags.appearance);
        builder.setUiMode(activity.getConfiguration().uiMode);
        Configuration taskConfig = activity.getTask().getConfiguration();
        int displayRotation = taskConfig.windowConfiguration.getDisplayRotation();
        Rect outCrop = new Rect();
        Point taskSize = new Point();
        Transition.ChangeInfo changeInfo = this.mCurrentChangeInfo;
        if (changeInfo != null) goto L31;
    L37:
        Point taskSize2 = taskSize;
        Configuration srcConfig = source.getConfiguration();
        outCrop.set(srcConfig.windowConfiguration.getBounds());
        Rect taskBounds = taskConfig.windowConfiguration.getBounds();
        taskSize2.set(taskBounds.width(), taskBounds.height());
        builder.setRotation(displayRotation);
        builder.setOrientation(srcConfig.orientation);
    L38:
        outCrop.offsetTo(0, 0);
        builder.setTaskSize(taskSize2);
        return outCrop;
    L31:
        if (changeInfo.mRotation == displayRotation) goto L37;
        outCrop.set(changeInfo.mAbsoluteBounds);
        taskSize2 = taskSize;
        taskSize2.set(changeInfo.mAbsoluteBounds.right, changeInfo.mAbsoluteBounds.bottom);
        builder.setRotation(changeInfo.mRotation);
        if (changeInfo.mAbsoluteBounds.height() < changeInfo.mAbsoluteBounds.width()) goto L35;
        int r0 = 1;
    L36:
        builder.setOrientation(r0);
        goto L38
    L35:
        r0 = 2;
        goto L36
    L24:
        if (activity.fillsParent() == false) goto L26;
        if (isWindowTranslucent == false) goto L27;
    L26:
        isTranslucent = true;
        goto L28
    L9:
        isWindowTranslucent = false;
        goto L10
    }

    Pair<ActivityRecord, WindowState> checkIfReadyToSnapshot(TYPE source) {
        if (this.mService.mPolicy.isScreenOn() == false) goto L5;
        ActivityRecord activity = findAppTokenForSnapshot(source);
        if (activity == null) goto L11;
        WindowState mainWindow = activity.findMainWindow();
        if (mainWindow != null) goto L19;
        Slog.w(TAG, "Failed to take screenshot. No main window for " + source);
        return null;
    L19:
        if (activity.hasFixedRotationTransform() == false) goto L25;
        if (WindowManagerDebugConfig.DEBUG_SCREENSHOT == false) goto L23;
        Slog.i(TAG, "Skip taking screenshot. App has fixed rotation " + activity);
    L23:
        return null;
    L25:
        return new Pair(activity, mainWindow);
    L11:
        if (WindowManagerDebugConfig.DEBUG_SCREENSHOT == false) goto L13;
        Slog.w(TAG, "Failed to take screenshot. No visible windows for " + source);
    L13:
        return null;
    L5:
        if (WindowManagerDebugConfig.DEBUG_SCREENSHOT == false) goto L7;
        Slog.i(TAG, "Attempted to take screenshot while display was off.");
    L7:
        return null;
    }

    private Supplier<TaskSnapshot> drawAppThemeSnapshot(TYPE source) {
        ActivityRecord topActivity = getTopActivity(source);
        if (topActivity != null) goto L5;
        return null;
    L5:
        WindowState mainWindow = topActivity.findMainWindow();
        if (mainWindow != null) goto L8;
        return null;
    L8:
        ActivityManager.TaskDescription taskDescription = getTaskDescription(source);
        int color = ColorUtils.setAlphaComponent(taskDescription.getBackgroundColor(), 255);
        WindowManager.LayoutParams attrs = mainWindow.mAttrs;
        Rect taskBounds = source.getBounds();
        InsetsState insetsState = mainWindow.getInsetsStateWithVisibilityOverride();
        Rect systemBarInsets = getSystemBarInsets(mainWindow.getFrame(), insetsState);
        int taskWidth = taskBounds.width();
        int taskHeight = taskBounds.height();
        float scale = this.mHighResSnapshotScale;
        SnapshotDrawerUtils.SystemBarBackgroundPainter decorPainter = new SnapshotDrawerUtils.SystemBarBackgroundPainter(attrs.flags, attrs.privateFlags, attrs.insetsFlags.appearance, taskDescription, scale, mainWindow.getRequestedVisibleTypes());
        final int width = (int) (taskWidth * scale);
        final int height = (int) (taskHeight * scale);
        final RenderNode node = RenderNode.create("SnapshotController", null);
        node.setLeftTopRightBottom(0, 0, width, height);
        node.setClipToBounds(false);
        RecordingCanvas c = node.start(width, height);
        c.drawColor(color);
        decorPainter.setInsets(systemBarInsets);
        decorPainter.drawDecors(c, null);
        node.end(c);
        Rect contentInsets = new Rect(systemBarInsets);
        Rect letterboxInsets = getLetterboxInsets(topActivity);
        InsetUtils.addInsets(contentInsets, letterboxInsets);
        final TaskSnapshot.Builder builder = new TaskSnapshot.Builder();
        builder.setIsRealSnapshot(false);
        builder.setId(System.currentTimeMillis());
        builder.setContentInsets(contentInsets);
        builder.setLetterboxInsets(letterboxInsets);
        builder.setTopActivityComponent(topActivity.mActivityComponent);
        builder.setIsTranslucent(false);
        builder.setWindowingMode(source.getWindowingMode());
        builder.setAppearance(attrs.insetsFlags.appearance);
        builder.setUiMode(topActivity.getConfiguration().uiMode);
        builder.setRotation(mainWindow.getWindowConfiguration().getRotation());
        builder.setOrientation(mainWindow.getConfiguration().orientation);
        builder.setTaskSize(new Point(taskWidth, taskHeight));
        builder.setCaptureTime(SystemClock.elapsedRealtimeNanos());
        return new AbsAppSnapshotController$$ExternalSyntheticLambda1(node, width, height, builder);
    }

    private static /* synthetic */ TaskSnapshot lambda$drawAppThemeSnapshot$1(RenderNode node, int width, int height, TaskSnapshot.Builder builder) {
        Trace.traceBegin(32, "drawAppThemeSnapshot_acquire");     // Catch: Throwable -> L10
        Bitmap hwBitmap = ThreadedRenderer.createHardwareBitmap(node, width, height);     // Catch: Throwable -> L10
        if (hwBitmap != null) goto L7;
        Trace.traceEnd(32);
        return null;
    L7:
        builder.setSnapshot(hwBitmap.getHardwareBuffer());     // Catch: Throwable -> L10
        builder.setColorSpace(hwBitmap.getColorSpace());     // Catch: Throwable -> L10
        TaskSnapshot r3 = validateSnapshot(builder.build());     // Catch: Throwable -> L10
        Trace.traceEnd(32);
        return r3;
    L10:
        th = move-exception;
        Trace.traceEnd(32);
        throw th;
    }

    static Rect getSystemBarInsets(Rect frame, InsetsState state) {
        return state.calculateInsets(frame, WindowInsets.Type.systemBars(), false).toRect();
    }

    void onAppRemoved(ActivityRecord activity) {
        this.mCache.onAppRemoved(activity);
    }

    private void showBackgroundKilledAppInfos(HashMap<Integer, AbsAppSnapshotController<TYPE, CACHE>.BackgroundKilledAppInfo> backgroundKilledAppInfos, String prefix) {
        StringBuilder builder = new StringBuilder();
        builder.append(prefix + " size: " + backgroundKilledAppInfos.size() + " ");
        Iterator<Map.Entry<Integer, AbsAppSnapshotController<TYPE, CACHE>.BackgroundKilledAppInfo>> r1 = backgroundKilledAppInfos.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Map.Entry<Integer, AbsAppSnapshotController<TYPE, CACHE>.BackgroundKilledAppInfo> tmp = r1.next();
        int tmpuid = tmp.getKey().intValue();
        AbsAppSnapshotController<TYPE, CACHE>.BackgroundKilledAppInfo tmpinfo = tmp.getValue();
        builder.append("[uid:" + tmpuid + " tskid:" + tmpinfo.mTaskId + " timestamp:" + tmpinfo.mTimestamp + "] ");
        goto L4
    L6:
        String infostr = builder.toString();
        Slog.e(TAG, infostr);
    }

    private void showBackgroundKilledAppTimestamps(TreeSet<Long> backgroundKilledAppTimestamps, String prefix) {
        StringBuilder builder = new StringBuilder();
        builder.append(prefix + " size: " + backgroundKilledAppTimestamps.size() + " ");
        Iterator<Long> r1 = backgroundKilledAppTimestamps.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Long timestamp = r1.next();
        builder.append("[" + timestamp + "] ");
        goto L4
    L6:
        String infostr = builder.toString();
        Slog.e(TAG, infostr);
    }

    public void saveBackgroundKilledAppInfo(ActivityRecord activity) {
        if (mFeatureQuickStartingWindowEnable != true) goto L41;
        boolean isBackgroundKill = isUserPerceivedBackgroundKill(activity);
        if (activity == null) goto L45;
        if (isBackgroundKill != true) goto L45;
        FetchCacheEntry entry = this.mCache.onAppRemovedAndFetch(activity);
        if (entry == null) goto L38;
        int uid = activity.getUid();
        HashMap<Integer, HashMap<Integer, AbsAppSnapshotController<TYPE, CACHE>.BackgroundKilledAppInfo>> r11 = this.mUsersBackgroundKilledAppInfos;
        monitor-enter(r11);
        HashMap<Integer, AbsAppSnapshotController<TYPE, CACHE>.BackgroundKilledAppInfo> r0 = this.mUsersBackgroundKilledAppInfos.get(Integer.valueOf(activity.mUserId));     // Catch: Throwable -> L16
        if (r0 == null) goto L14;
    L18:
        if (r0 == null) goto L33;
        if (r0.size() >= MAX_BACKGROUND_KILLED_INFOS) goto L28;
        long now = System.currentTimeMillis();     // Catch: Throwable -> L16
        Integer r12 = Integer.valueOf(uid);     // Catch: Throwable -> L16
        AbsAppSnapshotController<TYPE, CACHE> r4 = this;
        r0.put(r12, new BackgroundKilledAppInfo(r4, entry.mSnapshot, entry.mTaskId, activity.mUserId, uid, now));     // Catch: Throwable -> L26
        TreeSet<Long> userTimestamps = r4.mUsersBackgroundKilledAppTimestamps.get(Integer.valueOf(activity.mUserId));     // Catch: Throwable -> L26
        if (userTimestamps == null) goto L30;
        userTimestamps.add(Long.valueOf(now));     // Catch: Throwable -> L26
    L30:
        if (mFeatureQuickStartingWindowDebug == false) goto L33;
        showBackgroundKilledAppInfos(r0, "infos_after_put:");     // Catch: Throwable -> L26
        showBackgroundKilledAppTimestamps(r4.mUsersBackgroundKilledAppTimestamps.get(Integer.valueOf(activity.mUserId)), "timestamps_atfer_put");     // Catch: Throwable -> L26
        goto L33
    L28:
        r4 = this;
    L33:
        monitor-exit(r11);     // Catch: Throwable -> L26
        goto L38
    L14:
        if (this.mUsersBackgroundKilledAppInfos.size() >= MAX_BACKGROUND_KILLED_INFO_USERS) goto L18;
        r0 = new HashMap();     // Catch: Throwable -> L16
        this.mUsersBackgroundKilledAppInfos.put(Integer.valueOf(activity.mUserId), r0);     // Catch: Throwable -> L16
        TreeSet<Long> timestamps = new TreeSet();     // Catch: Throwable -> L16
        this.mUsersBackgroundKilledAppTimestamps.put(Integer.valueOf(activity.mUserId), timestamps);     // Catch: Throwable -> L16
    L26:
        th = th;
    L35:
        monitor-exit(r11);     // Catch: Throwable -> L26
        throw th;
    L16:
        th = th;
    L38:
        activity.resetCurrentReportedProcState();
        return;
    L45:
        return;
    }

    public boolean hasBackgroundKilledAppInfo(int uid, int userid) {
        HashMap<Integer, HashMap<Integer, AbsAppSnapshotController<TYPE, CACHE>.BackgroundKilledAppInfo>> r0 = this.mUsersBackgroundKilledAppInfos;
        monitor-enter(r0);
        HashMap<Integer, AbsAppSnapshotController<TYPE, CACHE>.BackgroundKilledAppInfo> backgroundKilledAppInfos = this.mUsersBackgroundKilledAppInfos.get(Integer.valueOf(userid));     // Catch: Throwable -> L11
        if (backgroundKilledAppInfos == null) goto L13;
        AbsAppSnapshotController<TYPE, CACHE>.BackgroundKilledAppInfo info = backgroundKilledAppInfos.get(Integer.valueOf(uid));     // Catch: Throwable -> L11
        if (info == null) goto L13;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return true;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return false;
    L11:
        th = move-exception;
        throw th;
    }

    public AbsAppSnapshotController<TYPE, CACHE>.BackgroundKilledAppInfo getBackgroundKilledAppInfo(int uid, int userid) {
        HashMap<Integer, HashMap<Integer, AbsAppSnapshotController<TYPE, CACHE>.BackgroundKilledAppInfo>> r0 = this.mUsersBackgroundKilledAppInfos;
        monitor-enter(r0);
        HashMap<Integer, AbsAppSnapshotController<TYPE, CACHE>.BackgroundKilledAppInfo> backgroundKilledAppInfos = this.mUsersBackgroundKilledAppInfos.get(Integer.valueOf(userid));     // Catch: Throwable -> L9
        if (backgroundKilledAppInfos == null) goto L11;
        AbsAppSnapshotController<TYPE, CACHE>.BackgroundKilledAppInfo info = backgroundKilledAppInfos.get(Integer.valueOf(uid));     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return info;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L9:
        th = move-exception;
        throw th;
    }

    public TaskSnapshot getBackgroundKilledAppSnapshot(int uid, int userid) {
        HashMap<Integer, HashMap<Integer, AbsAppSnapshotController<TYPE, CACHE>.BackgroundKilledAppInfo>> r0 = this.mUsersBackgroundKilledAppInfos;
        monitor-enter(r0);
        HashMap<Integer, AbsAppSnapshotController<TYPE, CACHE>.BackgroundKilledAppInfo> backgroundKilledAppInfos = this.mUsersBackgroundKilledAppInfos.get(Integer.valueOf(userid));     // Catch: Throwable -> L11
        if (backgroundKilledAppInfos == null) goto L13;
        AbsAppSnapshotController<TYPE, CACHE>.BackgroundKilledAppInfo info = backgroundKilledAppInfos.get(Integer.valueOf(uid));     // Catch: Throwable -> L11
        if (info == null) goto L13;
        TaskSnapshot r3 = info.mSnapshot;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r3;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return null;
    L11:
        th = move-exception;
        throw th;
    }

    public void removeBackgroundKilledAppInfo(int uid, int userid) {
        HashMap<Integer, HashMap<Integer, AbsAppSnapshotController<TYPE, CACHE>.BackgroundKilledAppInfo>> r0 = this.mUsersBackgroundKilledAppInfos;
        monitor-enter(r0);
        HashMap<Integer, AbsAppSnapshotController<TYPE, CACHE>.BackgroundKilledAppInfo> r1 = this.mUsersBackgroundKilledAppInfos.get(Integer.valueOf(userid));     // Catch: Throwable -> L10
        if (r1 == null) goto L15;
        AbsAppSnapshotController<TYPE, CACHE>.BackgroundKilledAppInfo info = r1.remove(Integer.valueOf(uid));     // Catch: Throwable -> L10
        TreeSet<Long> userTimestamps = this.mUsersBackgroundKilledAppTimestamps.get(Integer.valueOf(userid));     // Catch: Throwable -> L10
        if (userTimestamps == null) goto L13;
        if (info == null) goto L13;
        userTimestamps.remove(Long.valueOf(info.mTimestamp));     // Catch: Throwable -> L10
    L13:
        if (mFeatureQuickStartingWindowDebug == false) goto L15;
        showBackgroundKilledAppInfos(r1, "infos_after_remove:");     // Catch: Throwable -> L10
        showBackgroundKilledAppTimestamps(userTimestamps, "timestamps_after_remove: ");     // Catch: Throwable -> L10
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void checkExpiredBackgroundKilledAppInfo() {
        long now = System.currentTimeMillis();
        HashMap<Integer, HashMap<Integer, AbsAppSnapshotController<TYPE, CACHE>.BackgroundKilledAppInfo>> r2 = this.mUsersBackgroundKilledAppInfos;
        monitor-enter(r2);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.mUsersBackgroundKilledAppTimestamps == null) goto L21;
        Iterator<Map.Entry<Integer, TreeSet<Long>>> r3 = this.mUsersBackgroundKilledAppTimestamps.entrySet().iterator();     // Catch: Throwable -> L15
    L8:
        if (r3.hasNext() == false) goto L21;
        Map.Entry<Integer, TreeSet<Long>> entry = r3.next();     // Catch: Throwable -> L15
        int userid = entry.getKey().intValue();     // Catch: Throwable -> L15
        TreeSet<Long> userTimestamps = entry.getValue();     // Catch: Throwable -> L15
        long curMinTimestamp = 0;
        if (userTimestamps == null) goto L18;
        if (userTimestamps.isEmpty() == true) goto L8;
        curMinTimestamp = userTimestamps.first().longValue();     // Catch: Throwable -> L15
    L18:
        if ((now - curMinTimestamp) < MAX_PERIOD_TO_REMOVE_EXPIRED_INFOS) goto L8;
        removeExpiredBackgroundKilledAppInfoLocked(now, userid);     // Catch: Throwable -> L15
    L21:
        monitor-exit(r2);     // Catch: Throwable -> L15
    }

    public void removeExpiredBackgroundKilledAppInfoLocked(long now, int userid) {
        HashMap<Integer, AbsAppSnapshotController<TYPE, CACHE>.BackgroundKilledAppInfo> r0 = this.mUsersBackgroundKilledAppInfos.get(Integer.valueOf(userid));
        TreeSet<Long> userTimestamps = this.mUsersBackgroundKilledAppTimestamps.get(Integer.valueOf(userid));
        if (r0 == null) goto L17;
        if (userTimestamps == null) goto L24;
        Iterator<Map.Entry<Integer, AbsAppSnapshotController<TYPE, CACHE>.BackgroundKilledAppInfo>> iterator = r0.entrySet().iterator();
    L8:
        if (iterator.hasNext() == false) goto L14;
        Map.Entry<Integer, AbsAppSnapshotController<TYPE, CACHE>.BackgroundKilledAppInfo> entry = iterator.next();
        long timestamp = entry.getValue().mTimestamp;
        if ((now - timestamp) < MAX_PERIOD_TO_REMOVE_EXPIRED_INFOS) goto L8;
        iterator.remove();
        userTimestamps.remove(Long.valueOf(timestamp));
        goto L8
    L14:
        if (mFeatureQuickStartingWindowDebug == false) goto L23;
        showBackgroundKilledAppInfos(r0, "infos_after_expired: userid: " + userid);
        showBackgroundKilledAppTimestamps(userTimestamps, "timestamps_after_expired: ");
        return;
    L23:
        return;
    L24:
        return;
    }

    private boolean isUserPerceivedBackgroundKill(ActivityRecord activity) {
        if (activity != null) goto L6;
        return false;
    L6:
        if (activity.isVisible() == false) goto L8;
    L11:
        boolean visible = true;
    L12:
        if (visible == false) goto L14;
        return false;
    L14:
        return true;
    L8:
        if (activity.isVisibleRequested() == true) goto L11;
        visible = false;
        goto L12
    }

    void onAppDied(ActivityRecord activity) {
        saveBackgroundKilledAppInfo(activity);
        this.mCache.onAppDied(activity);
    }

    boolean isAnimatingByRecents(Task task) {
        return task.isAnimatingByRecents();
    }

    void dump(PrintWriter pw, String prefix) {
        pw.println(prefix + "mHighResSnapshotScale=" + this.mHighResSnapshotScale);
        pw.println(prefix + "mSnapshotEnabled=" + this.mSnapshotEnabled);
        this.mCache.dump(pw, prefix);
    }
}
