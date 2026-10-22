package com.android.server.display;

import android.R;
import android.app.ObricActivityManager;
import android.content.Context;
import android.hardware.devicestate.DeviceState;
import android.hardware.devicestate.DeviceStateManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.IndentingPrintWriter;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.DisplayAddress;
import android.view.DisplayInfo;
import com.android.internal.foldables.FoldGracePeriodProvider;
import com.android.internal.hidden_from_bootclasspath.android.hardware.devicestate.feature.flags.FeatureFlags;
import com.android.internal.hidden_from_bootclasspath.android.hardware.devicestate.feature.flags.FeatureFlagsImpl;
import com.android.server.LocalServices;
import com.android.server.display.feature.DisplayManagerFlags;
import com.android.server.display.layout.DisplayIdProducer;
import com.android.server.display.layout.Layout;
import com.android.server.display.mode.SyntheticModeManager;
import com.android.server.display.utils.DebugUtils;
import com.android.server.policy.WindowManagerPolicy;
import com.android.server.timezonedetector.ServiceConfigAccessor;
import com.android.server.usb.descriptors.UsbTerminalTypes;
import com.android.server.utils.FoldSettingProvider;
import com.obric.server.display.ObricAutoActionDisplayStateReporter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
class LogicalDisplayMapper implements DisplayDeviceRepository.Listener {
    private static final boolean DEBUG = false;
    public static final int DISPLAY_GROUP_EVENT_ADDED = 1;
    public static final int DISPLAY_GROUP_EVENT_CHANGED = 2;
    public static final int DISPLAY_GROUP_EVENT_REMOVED = 3;
    public static final int LOGICAL_DISPLAY_EVENT_ADDED = 1;
    public static final int LOGICAL_DISPLAY_EVENT_BASE = 0;
    public static final int LOGICAL_DISPLAY_EVENT_BASIC_CHANGED = 2;
    public static final int LOGICAL_DISPLAY_EVENT_COMMITTED_STATE_CHANGED = 2048;
    public static final int LOGICAL_DISPLAY_EVENT_CONNECTED = 128;
    public static final int LOGICAL_DISPLAY_EVENT_DEVICE_STATE_TRANSITION = 32;
    public static final int LOGICAL_DISPLAY_EVENT_DISCONNECTED = 256;
    public static final int LOGICAL_DISPLAY_EVENT_FRAME_RATE_OVERRIDES_CHANGED = 16;
    public static final int LOGICAL_DISPLAY_EVENT_HDR_SDR_RATIO_CHANGED = 64;
    public static final int LOGICAL_DISPLAY_EVENT_REFRESH_RATE_CHANGED = 512;
    public static final int LOGICAL_DISPLAY_EVENT_REMOVED = 4;
    public static final int LOGICAL_DISPLAY_EVENT_STATE_CHANGED = 1024;
    public static final int LOGICAL_DISPLAY_EVENT_SWAPPED = 8;
    private static final int MSG_TRANSITION_TO_PENDING_DEVICE_STATE = 1;
    private static final String TAG = "LogicalDisplayMapper";
    private static final int TIMEOUT_STATE_TRANSITION_MILLIS = 500;
    private static final int UPDATE_STATE_NEW = 0;
    private static final int UPDATE_STATE_TRANSITION = 1;
    private static final int UPDATE_STATE_UPDATED = 2;
    private static int sNextNonDefaultDisplayId;
    private boolean mBootCompleted;
    private Layout mCurrentLayout;
    private final SparseIntArray mDeviceDisplayGroupIds;
    private DeviceState mDeviceState;
    private final FeatureFlags mDeviceStateManagerFlags;
    private DeviceState mDeviceStateToBeAppliedAfterBoot;
    private final DeviceStateToLayoutMap mDeviceStateToLayoutMap;
    private final SparseBooleanArray mDeviceStatesOnWhichToSelectiveSleep;
    private final SparseBooleanArray mDeviceStatesOnWhichToWakeUp;
    private final DisplayDeviceRepository mDisplayDeviceRepo;
    private final ArrayMap<String, Integer> mDisplayGroupIdsByName;
    private final SparseArray<DisplayGroup> mDisplayGroups;
    private final SparseIntArray mDisplayGroupsToUpdate;
    private final SparseBooleanArray mDisplaysEnabledCache;
    private final DisplayManagerFlags mFlags;
    private final FoldGracePeriodProvider mFoldGracePeriodProvider;
    private final FoldSettingProvider mFoldSettingProvider;
    private final LogicalDisplayMapperHandler mHandler;
    private final DisplayIdProducer mIdProducer;
    private boolean mInteractive;
    private final Listener mListener;
    private final SparseArray<LogicalDisplay> mLogicalDisplays;
    private final SparseIntArray mLogicalDisplaysToUpdate;
    private int mNextBuiltInDisplayId;
    private int mNextNonDefaultGroupId;
    private DeviceState mPendingDeviceState;
    private final PowerManager mPowerManager;
    private final boolean mSingleDisplayDemoMode;
    private final boolean mSupportsConcurrentInternalDisplays;
    private final DisplayManagerService.SyncRoot mSyncRoot;
    private final SyntheticModeManager mSyntheticModeManager;
    private final DisplayInfo mTempDisplayInfo;
    private final DisplayInfo mTempNonOverrideDisplayInfo;
    private final SparseIntArray mUpdatedDisplayGroups;
    private final SparseIntArray mUpdatedLogicalDisplays;
    private final ArrayMap<String, Integer> mVirtualDeviceDisplayMapping;
    private WindowManagerPolicy mWindowManagerPolicy;

    public interface Listener {
        void onDisplayGroupEventLocked(int r1, int r2);

        void onLogicalDisplayEventLocked(LogicalDisplay r1, int r2);

        void onTraversalRequested();
    }

    private class LogicalDisplayMapperHandler extends Handler {
        final /* synthetic */ LogicalDisplayMapper this$0;

        LogicalDisplayMapperHandler(LogicalDisplayMapper r2, Looper looper) {
            this.this$0 = r2;
            super(looper, null, true);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 1: goto L5;
                default: goto L15;
            };
        L5:
            DisplayManagerService.SyncRoot r0 = LogicalDisplayMapper.m3850$$Nest$fgetmSyncRoot(this.this$0);
            monitor-enter(r0);
            LogicalDisplayMapper.m3851$$Nest$mfinishStateTransitionLocked(this.this$0, true);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }
    }

    public static /* synthetic */ int $r8$lambda$180v0r73SgWuHOXH9KeuIhm0OfE(boolean r0) {
        return lambda$new$1(r0);
    }

    public static /* synthetic */ int $r8$lambda$CLkgta2MkaptkxpiszN50MW0yV0(boolean r0) {
        return lambda$new$0(r0);
    }

    public static /* synthetic */ void $r8$lambda$N8BYO3VRk9SxOshZBRw21dnZJC8(LogicalDisplayMapper r0) {
        r0.lambda$setDeviceStateLocked$2();
    }

    public static /* synthetic */ void $r8$lambda$ltxpdCphLYKBtSHlpUiAJoWLQCA(LogicalDisplayMapper r0, int r1) {
        r0.lambda$setDeviceStateLocked$3(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSyncRoot, reason: not valid java name */
    static /* bridge */ /* synthetic */ DisplayManagerService.SyncRoot m3850$$Nest$fgetmSyncRoot(LogicalDisplayMapper r0) {
        return r0.mSyncRoot;
    }

    /* JADX INFO: renamed from: -$$Nest$mfinishStateTransitionLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3851$$Nest$mfinishStateTransitionLocked(LogicalDisplayMapper r0, boolean r1) {
        r0.finishStateTransitionLocked(r1);
    }

    static {
        DEBUG = DebugUtils.isDebuggable(TAG);
        sNextNonDefaultDisplayId = 1;
    }

    private static /* synthetic */ int lambda$new$0(boolean isDefault) {
        if (isDefault == false) goto L4;
        return 0;
    L4:
        int r0 = sNextNonDefaultDisplayId;
        sNextNonDefaultDisplayId = r0 + 1;
        return r0;
    }

    LogicalDisplayMapper(Context context, FoldSettingProvider foldSettingProvider, FoldGracePeriodProvider foldGracePeriodProvider, DisplayDeviceRepository repo, Listener listener, DisplayManagerService.SyncRoot syncRoot, Handler handler, DisplayManagerFlags flags) {
        this(context, foldSettingProvider, foldGracePeriodProvider, repo, listener, syncRoot, handler, new DeviceStateToLayoutMap(new LogicalDisplayMapper$$ExternalSyntheticLambda3(), flags), flags, new SyntheticModeManager(flags));
    }

    private static /* synthetic */ int lambda$new$1(boolean isDefault) {
        if (isDefault == false) goto L4;
        return 0;
    L4:
        int r0 = sNextNonDefaultDisplayId;
        sNextNonDefaultDisplayId = r0 + 1;
        return r0;
    }

    LogicalDisplayMapper(Context context, FoldSettingProvider foldSettingProvider, FoldGracePeriodProvider foldGracePeriodProvider, DisplayDeviceRepository repo, Listener listener, DisplayManagerService.SyncRoot syncRoot, Handler handler, DeviceStateToLayoutMap deviceStateToLayoutMap, DisplayManagerFlags flags, SyntheticModeManager syntheticModeManager) {
        this.mTempDisplayInfo = new DisplayInfo();
        this.mTempNonOverrideDisplayInfo = new DisplayInfo();
        this.mLogicalDisplays = new SparseArray();
        this.mNextBuiltInDisplayId = 4096;
        this.mDisplaysEnabledCache = new SparseBooleanArray();
        this.mDisplayGroups = new SparseArray();
        this.mDeviceDisplayGroupIds = new SparseIntArray();
        this.mDisplayGroupIdsByName = new ArrayMap();
        this.mUpdatedLogicalDisplays = new SparseIntArray();
        this.mUpdatedDisplayGroups = new SparseIntArray();
        this.mLogicalDisplaysToUpdate = new SparseIntArray();
        this.mDisplayGroupsToUpdate = new SparseIntArray();
        this.mVirtualDeviceDisplayMapping = new ArrayMap();
        this.mNextNonDefaultGroupId = 1;
        this.mIdProducer = new LogicalDisplayMapper$$ExternalSyntheticLambda2();
        this.mCurrentLayout = null;
        this.mDeviceState = DeviceStateManager.INVALID_DEVICE_STATE;
        this.mPendingDeviceState = DeviceStateManager.INVALID_DEVICE_STATE;
        this.mDeviceStateToBeAppliedAfterBoot = DeviceStateManager.INVALID_DEVICE_STATE;
        this.mBootCompleted = false;
        this.mSyncRoot = syncRoot;
        this.mPowerManager = (PowerManager) context.getSystemService(PowerManager.class);
        this.mInteractive = this.mPowerManager.isInteractive();
        this.mHandler = new LogicalDisplayMapperHandler(this, handler.getLooper());
        this.mDisplayDeviceRepo = repo;
        this.mListener = listener;
        this.mFoldSettingProvider = foldSettingProvider;
        this.mFoldGracePeriodProvider = foldGracePeriodProvider;
        this.mSingleDisplayDemoMode = SystemProperties.getBoolean("persist.demo.singledisplay", false);
        this.mSupportsConcurrentInternalDisplays = context.getResources().getBoolean(R.bool.config_suspendWhenScreenOffDueToProximity);
        this.mDeviceStatesOnWhichToWakeUp = toSparseBooleanArray(context.getResources().getIntArray(R.array.config_displayWhiteBalanceDisplayPrimaries));
        this.mDeviceStatesOnWhichToSelectiveSleep = toSparseBooleanArray(context.getResources().getIntArray(R.array.config_displayWhiteBalanceDisplayNominalWhite));
        this.mDisplayDeviceRepo.addListener(this);
        this.mDeviceStateToLayoutMap = deviceStateToLayoutMap;
        this.mFlags = flags;
        this.mSyntheticModeManager = syntheticModeManager;
        this.mDeviceStateManagerFlags = new FeatureFlagsImpl();
    }

    @Override // com.android.server.display.DisplayDeviceRepository.Listener
    public void onDisplayDeviceEventLocked(DisplayDevice device, int event) {
        switch(event) {
            case 1: goto L10;
            case 2: goto L15;
            case 3: goto L6;
            default: goto L15;
        };
    L15:
        return;
    L6:
        if (DEBUG == false) goto L8;
        Slog.d(TAG, "Display device removed: " + device.getDisplayDeviceInfoLocked());
    L8:
        handleDisplayDeviceRemovedLocked(device);
        updateLogicalDisplaysLocked();
        return;
    L10:
        if (DEBUG == false) goto L12;
        Slog.d(TAG, "Display device added: " + device.getDisplayDeviceInfoLocked());
    L12:
        handleDisplayDeviceAddedLocked(device);
    }

    @Override // com.android.server.display.DisplayDeviceRepository.Listener
    public void onDisplayDeviceChangedLocked(DisplayDevice device, int diff) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "Display device changed: " + device.getDisplayDeviceInfoLocked());
    L5:
        finishStateTransitionLocked(false);
        if (device == null) goto L8;
        DisplayDeviceInfo info = device.getDisplayDeviceInfoLocked();
    L10:
        if ((diff & 2) != 0) goto L12;
    L16:
        updateLogicalDisplaysLocked(diff);
        return;
    L12:
        if (isAutoActionVirtualDisplayStateChange(info) == false) goto L16;
        LogicalDisplay display = getDisplayLocked(device);
        if (display == null) goto L16;
        int displayId = display.getDisplayIdLocked();
        int eventMask = this.mLogicalDisplaysToUpdate.get(displayId, 0);
        this.mLogicalDisplaysToUpdate.put(displayId, eventMask | 2);
        ObricAutoActionDisplayStateReporter.reportForceBasicChanged(displayId, info.state);
        goto L16
    L8:
        info = null;
        goto L10
    }

    private boolean isAutoActionVirtualDisplayStateChange(DisplayDeviceInfo info) {
        if (info != null) goto L4;
    L10:
        return false;
    L4:
        if (info.type != 5) goto L10;
        if ("auto_action".equals(info.name) == false) goto L10;
        if (ObricActivityManager.isAutoAction(info.ownerPackageName) == false) goto L10;
        return true;
    }

    @Override // com.android.server.display.DisplayDeviceRepository.Listener
    public void onTraversalRequested() {
        this.mListener.onTraversalRequested();
    }

    public void onWindowManagerReady() {
        this.mWindowManagerPolicy = (WindowManagerPolicy) LocalServices.getService(WindowManagerPolicy.class);
    }

    public LogicalDisplay getDisplayLocked(int displayId) {
        return getDisplayLocked(displayId, true);
    }

    public LogicalDisplay getDisplayLocked(int displayId, boolean includeDisabled) {
        LogicalDisplay display = this.mLogicalDisplays.get(displayId);
        if (display != null) goto L5;
    L10:
        return display;
    L5:
        if (display.isEnabledLocked() == true) goto L10;
        if (includeDisabled == true) goto L10;
        return null;
    }

    public LogicalDisplay getDisplayLocked(DisplayDevice device) {
        return getDisplayLocked(device, true);
    }

    public LogicalDisplay getDisplayLocked(DisplayDevice device, boolean includeDisabled) {
        if (device != null) goto L5;
        return null;
    L5:
        int count = this.mLogicalDisplays.size();
        int i = 0;
    L6:
        if (i >= count) goto L17;
        LogicalDisplay display = this.mLogicalDisplays.valueAt(i);
        if (display.getPrimaryDisplayDeviceLocked() == device) goto L10;
        i = i + 1;
        goto L6
    L10:
        if (display.isEnabledLocked() == true) goto L14;
        if (includeDisabled == true) goto L14;
        return null;
    L14:
        return display;
    L17:
        return null;
    }

    public int[] getDisplayIdsLocked(int callingUid, boolean includeDisabled) {
        int count = this.mLogicalDisplays.size();
        int[] displayIds = new int[count];
        int n = 0;
        int i = 0;
    L3:
        if (i >= count) goto L12;
        LogicalDisplay display = this.mLogicalDisplays.valueAt(i);
        if (display.isEnabledLocked() == true) goto L7;
        if (includeDisabled == true) goto L7;
    L10:
        i = i + 1;
    L7:
        DisplayInfo info = display.getDisplayInfoLocked();
        if (info.hasAccess(callingUid) == false) goto L10;
        displayIds[n] = this.mLogicalDisplays.keyAt(i);
        n = n + 1;
        goto L10
    L12:
        if (n != count) goto L14;
        return displayIds;
    L14:
        return Arrays.copyOfRange(displayIds, 0, n);
    }

    public int[] getDisplayIdsForGroupLocked(int groupId) {
        DisplayGroup displayGroup = this.mDisplayGroups.get(groupId);
        if (displayGroup != null) goto L7;
        return new int[0];
    L7:
        return displayGroup.getIdsLocked();
    }

    public SparseArray<int[]> getDisplayIdsByGroupIdLocked() {
        SparseArray<int[]> displayIdsByGroupIds = new SparseArray();
        int i = 0;
    L4:
        if (i >= this.mDisplayGroups.size()) goto L7;
        int displayGroupId = this.mDisplayGroups.keyAt(i);
        displayIdsByGroupIds.put(displayGroupId, getDisplayIdsForGroupLocked(displayGroupId));
        i = i + 1;
        goto L4
    L7:
        return displayIdsByGroupIds;
    }

    public void forEachLocked(Consumer<LogicalDisplay> consumer) {
        forEachLocked(consumer, true);
    }

    public void forEachLocked(Consumer<LogicalDisplay> consumer, boolean includeDisabled) {
        int count = this.mLogicalDisplays.size();
        int i = 0;
    L3:
        if (i >= count) goto L10;
        LogicalDisplay display = this.mLogicalDisplays.valueAt(i);
        if (display.isEnabledLocked() == true) goto L7;
        if (includeDisabled == true) goto L7;
    L8:
        i = i + 1;
    L7:
        consumer.accept(display);
        goto L8
    }

    public int getDisplayGroupIdFromDisplayIdLocked(int displayId) {
        LogicalDisplay display = getDisplayLocked(displayId);
        if (display != null) goto L5;
        return -1;
    L5:
        int size = this.mDisplayGroups.size();
        int i = 0;
    L6:
        if (i >= size) goto L13;
        DisplayGroup displayGroup = this.mDisplayGroups.valueAt(i);
        if (displayGroup.containsLocked(display) == true) goto L10;
        i = i + 1;
        goto L6
    L10:
        return this.mDisplayGroups.keyAt(i);
    L13:
        return -1;
    }

    public DisplayGroup getDisplayGroupLocked(int groupId) {
        return this.mDisplayGroups.get(groupId);
    }

    public DisplayInfo getDisplayInfoForStateLocked(int deviceState, int displayId) {
        Layout layout = this.mDeviceStateToLayoutMap.get(deviceState);
        if (layout != null) goto L6;
        Slog.d(TAG, "Cannot get layout for given state:" + deviceState);
        return null;
    L6:
        Layout.Display display = layout.getById(displayId);
        if (display != null) goto L10;
        Slog.d(TAG, "Cannot get display for given layout:" + layout);
        return null;
    L10:
        DisplayDevice device = this.mDisplayDeviceRepo.getByAddressLocked(display.getAddress());
        if (device != null) goto L14;
        Slog.w(TAG, "The display device (" + display.getAddress() + "), is not available for the display state " + this.mDeviceState.getIdentifier());
        return null;
    L14:
        LogicalDisplay logicalDisplay = getDisplayLocked(device, true);
        if (logicalDisplay != null) goto L18;
        Slog.w(TAG, "The logical display associated with address (" + display.getAddress() + "), is not available for the display state " + this.mDeviceState);
        return null;
    L18:
        DisplayInfo displayInfo = new DisplayInfo(logicalDisplay.getDisplayInfoLocked());
        displayInfo.displayId = displayId;
        return displayInfo;
    }

    public void dumpLocked(PrintWriter pw) {
        pw.println("LogicalDisplayMapper:");
        pw.println("---------------------");
        PrintWriter r0 = new IndentingPrintWriter(pw, "  ");
        r0.increaseIndent();
        r0.println("mSingleDisplayDemoMode=" + this.mSingleDisplayDemoMode);
        r0.println("mCurrentLayout=" + this.mCurrentLayout);
        r0.println("mDeviceStatesOnWhichToWakeUp=" + this.mDeviceStatesOnWhichToWakeUp);
        r0.println("mDeviceStatesOnWhichSelectiveSleep=" + this.mDeviceStatesOnWhichToSelectiveSleep);
        r0.println("mInteractive=" + this.mInteractive);
        r0.println("mBootCompleted=" + this.mBootCompleted);
        r0.println();
        r0.println("mDeviceState=" + this.mDeviceState.getIdentifier());
        r0.println("mPendingDeviceState=" + this.mPendingDeviceState.getIdentifier());
        r0.println("mDeviceStateToBeAppliedAfterBoot=" + this.mDeviceStateToBeAppliedAfterBoot.getIdentifier());
        int logicalDisplayCount = this.mLogicalDisplays.size();
        r0.println();
        r0.println("Logical Displays: size=" + logicalDisplayCount);
        int i = 0;
    L4:
        if (i >= logicalDisplayCount) goto L6;
        int displayId = this.mLogicalDisplays.keyAt(i);
        LogicalDisplay display = this.mLogicalDisplays.valueAt(i);
        r0.println("Display " + displayId + ":");
        r0.increaseIndent();
        display.dumpLocked(r0);
        r0.decreaseIndent();
        r0.println();
        i = i + 1;
        goto L4
    L6:
        int displayGroupCount = this.mDisplayGroups.size();
        r0.println();
        r0.println("Display Groups: size=" + displayGroupCount);
        int i2 = 0;
    L7:
        if (i2 >= displayGroupCount) goto L9;
        int groupId = this.mDisplayGroups.keyAt(i2);
        DisplayGroup displayGroup = this.mDisplayGroups.valueAt(i2);
        r0.println("Group " + groupId + ":");
        r0.increaseIndent();
        displayGroup.dumpLocked(r0);
        r0.decreaseIndent();
        r0.println();
        i2 = i2 + 1;
        goto L7
    L9:
        this.mDeviceStateToLayoutMap.dumpLocked(r0);
    }

    void associateDisplayDeviceWithVirtualDevice(DisplayDevice displayDevice, int virtualDeviceUniqueId) {
        this.mVirtualDeviceDisplayMapping.put(displayDevice.getUniqueId(), Integer.valueOf(virtualDeviceUniqueId));
    }

    void setDeviceStateLocked(DeviceState state) {
        if (this.mBootCompleted == false) goto L5;
        resetLayoutLocked(this.mDeviceState.getIdentifier(), state.getIdentifier(), true);
        this.mPendingDeviceState = state;
        this.mDeviceStateToBeAppliedAfterBoot = DeviceStateManager.INVALID_DEVICE_STATE;
        boolean wakeDevice = shouldDeviceBeWoken(this.mPendingDeviceState, this.mDeviceState, this.mInteractive, this.mBootCompleted);
        boolean sleepDevice = shouldDeviceBePutToSleep(this.mPendingDeviceState, this.mDeviceState, this.mInteractive, this.mBootCompleted);
        Slog.i(TAG, "Requesting Transition to state: " + state.getIdentifier() + ", from state=" + this.mDeviceState.getIdentifier() + ", interactive=" + this.mInteractive + ", mBootCompleted=" + this.mBootCompleted + ", wakeDevice=" + wakeDevice + ", sleepDevice=" + sleepDevice);
        if (areAllTransitioningDisplaysOffLocked() == false) goto L16;
        if (wakeDevice == true) goto L16;
        if (sleepDevice == true) goto L16;
        transitionToPendingStateLocked();
        return;
    L16:
        if (DEBUG == false) goto L18;
        Slog.d(TAG, "Postponing transition to state: " + this.mPendingDeviceState.getIdentifier());
    L18:
        updateLogicalDisplaysLocked();
        if (wakeDevice == true) goto L21;
        if (sleepDevice == true) goto L21;
    L29:
        this.mHandler.sendEmptyMessageDelayed(1, 500);
        return;
    L21:
        if (wakeDevice == false) goto L23;
        this.mHandler.post(new LogicalDisplayMapper$$ExternalSyntheticLambda0(this));
        goto L29
    L23:
        if (sleepDevice == false) goto L29;
        if (this.mFoldSettingProvider.shouldSleepOnFold() == false) goto L27;
        final int goToSleepFlag = 0;
    L28:
        this.mHandler.post(new LogicalDisplayMapper$$ExternalSyntheticLambda1(this, goToSleepFlag));
        goto L29
    L27:
        goToSleepFlag = 2;
        goto L28
    L5:
        if (DEBUG == false) goto L7;
        Slog.d(TAG, "Postponing transition to state: " + this.mPendingDeviceState.getIdentifier() + " until boot is completed");
    L7:
        this.mDeviceStateToBeAppliedAfterBoot = state;
    }

    private /* synthetic */ void lambda$setDeviceStateLocked$2() {
        this.mPowerManager.wakeUp(SystemClock.uptimeMillis(), 12, "server.display:unfold");
    }

    private /* synthetic */ void lambda$setDeviceStateLocked$3(int goToSleepFlag) {
        this.mPowerManager.goToSleep(SystemClock.uptimeMillis(), 13, goToSleepFlag);
    }

    void onBootCompleted() {
        DisplayManagerService.SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        this.mBootCompleted = true;     // Catch: Throwable -> L8
        if (this.mDeviceStateToBeAppliedAfterBoot.equals(DeviceStateManager.INVALID_DEVICE_STATE) == true) goto L10;
        setDeviceStateLocked(this.mDeviceStateToBeAppliedAfterBoot);     // Catch: Throwable -> L8
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void onEarlyInteractivityChange(boolean interactive) {
        DisplayManagerService.SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mInteractive == interactive) goto L9;
        this.mInteractive = interactive;     // Catch: Throwable -> L7
        finishStateTransitionLocked(false);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    boolean shouldDeviceBeWoken(DeviceState pendingState, DeviceState currentState, boolean isInteractive, boolean isBootCompleted) {
        if (currentState.hasProperties(new int[]{10}) == false) goto L8;
        if (pendingState.hasProperties(new int[]{10}) == true) goto L8;
        return false;
    L8:
        if (pendingState.hasProperty(14) == true) goto L10;
        return false;
    L10:
        if (currentState.equals(DeviceStateManager.INVALID_DEVICE_STATE) == false) goto L12;
        return false;
    L12:
        if (currentState.hasProperty(14) == true) goto L20;
        if (isInteractive == true) goto L21;
        if (isBootCompleted == false) goto L22;
        return true;
    L22:
        return false;
    L21:
        return false;
    L20:
        return false;
    }

    boolean shouldDeviceBePutToSleep(DeviceState pendingState, DeviceState currentState, boolean isInteractive, boolean isBootCompleted) {
        if (pendingState.hasProperty(13) == true) goto L5;
    L13:
        return false;
    L5:
        if (currentState.equals(DeviceStateManager.INVALID_DEVICE_STATE) == true) goto L13;
        if (currentState.hasProperty(13) == true) goto L13;
        if (isInteractive == false) goto L13;
        if (isBootCompleted == false) goto L13;
        if (this.mFoldSettingProvider.shouldStayAwakeOnFold() == true) goto L13;
        return true;
    }

    private boolean areAllTransitioningDisplaysOffLocked() {
        int count = this.mLogicalDisplays.size();
        int i = 0;
    L4:
        if (i >= count) goto L16;
        LogicalDisplay display = this.mLogicalDisplays.valueAt(i);
        if (display.isInTransitionLocked() == false) goto L14;
        DisplayDevice device = display.getPrimaryDisplayDeviceLocked();
        if (device == null) goto L14;
        DisplayDeviceInfo info = device.getDisplayDeviceInfoLocked();
        if (info.state == 1) goto L14;
        return false;
    L14:
        i = i + 1;
        goto L4
    L16:
        return true;
    }

    private void transitionToPendingStateLocked() {
        resetLayoutLocked(this.mDeviceState.getIdentifier(), this.mPendingDeviceState.getIdentifier(), false);
        this.mDeviceState = this.mPendingDeviceState;
        this.mPendingDeviceState = DeviceStateManager.INVALID_DEVICE_STATE;
        applyLayoutLocked();
        updateLogicalDisplaysLocked();
    }

    private void finishStateTransitionLocked(boolean force) {
        if (this.mPendingDeviceState.equals(DeviceStateManager.INVALID_DEVICE_STATE) == false) goto L5;
        return;
    L5:
        boolean waitingToWakeDevice = shouldDeviceBeWoken(this.mPendingDeviceState, this.mDeviceState, this.mInteractive, this.mBootCompleted);
        boolean isReadyToTransition = false;
        if (shouldDeviceBePutToSleep(this.mPendingDeviceState, this.mDeviceState, this.mInteractive, this.mBootCompleted) == true) goto L8;
    L10:
        boolean waitingToSleepDevice = false;
    L11:
        boolean displaysOff = areAllTransitioningDisplaysOffLocked();
        if (displaysOff == false) goto L16;
        if (waitingToWakeDevice == true) goto L16;
        if (waitingToSleepDevice == true) goto L16;
        isReadyToTransition = true;
    L16:
        if (isReadyToTransition == true) goto L22;
        if (force == true) goto L22;
        if (DEBUG == false) goto L24;
        Slog.d(TAG, "Not yet ready to transition to state=" + this.mPendingDeviceState + " with displays-off=" + displaysOff + ", force=" + force + ", mInteractive=" + this.mInteractive + ", isReady=" + isReadyToTransition);
        return;
    L24:
        return;
    L22:
        transitionToPendingStateLocked();
        this.mHandler.removeMessages(1);
        return;
    L8:
        if (shouldStayAwakeOnFold() == true) goto L10;
        waitingToSleepDevice = true;
        goto L11
    }

    private void handleDisplayDeviceAddedLocked(DisplayDevice device) {
        DisplayDeviceInfo deviceInfo = device.getDisplayDeviceInfoLocked();
        if ((deviceInfo.flags & 1) == 0) goto L5;
        initializeDefaultDisplayDeviceLocked(device);
    L5:
        createNewLogicalDisplayLocked(device, this.mIdProducer.getId(false));
        applyLayoutLocked();
        updateLogicalDisplaysLocked();
    }

    private void handleDisplayDeviceRemovedLocked(DisplayDevice device) {
        Layout layout = this.mDeviceStateToLayoutMap.get(-1);
        Layout.Display layoutDisplay = layout.getById(0);
        if (layoutDisplay != null) goto L5;
        return;
    L5:
        DisplayDeviceInfo deviceInfo = device.getDisplayDeviceInfoLocked();
        this.mVirtualDeviceDisplayMapping.remove(device.getUniqueId());
        if (layoutDisplay.getAddress().equals(deviceInfo.address) == false) goto L20;
        layout.removeDisplayLocked(0);
        int i = 0;
    L9:
        if (i >= this.mLogicalDisplays.size()) goto L26;
        LogicalDisplay nextDisplay = this.mLogicalDisplays.valueAt(i);
        DisplayDevice nextDevice = nextDisplay.getPrimaryDisplayDeviceLocked();
        if (nextDevice == null) goto L19;
        DisplayDeviceInfo nextDeviceInfo = nextDevice.getDisplayDeviceInfoLocked();
        if ((nextDeviceInfo.flags & 1) == 0) goto L19;
        if (nextDeviceInfo.address.equals(deviceInfo.address) == true) goto L19;
        layout.createDefaultDisplayLocked(nextDeviceInfo.address, this.mIdProducer);
        applyLayoutLocked();
        return;
    L19:
        i = i + 1;
        goto L9
    L26:
        return;
    }

    void updateLogicalDisplays() {
        DisplayManagerService.SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        updateLogicalDisplaysLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void updateLogicalDisplaysLocked() {
        updateLogicalDisplaysLocked(-1);
    }

    private void updateLogicalDisplaysLocked(int diff) {
        updateLogicalDisplaysLocked(diff, false);
    }

    private void updateLogicalDisplaysLocked(int diff, boolean isSecondLoop) {
        boolean reloop = false;
        boolean r4 = true;
        int i = this.mLogicalDisplays.size() - 1;
    L4:
        if (i < 0) goto L59;
        int displayId = this.mLogicalDisplays.keyAt(i);
        LogicalDisplay display = this.mLogicalDisplays.valueAt(i);
        assignDisplayGroupLocked(display);
        boolean wasDirty = display.isDirtyLocked();
        this.mTempDisplayInfo.copyFrom(display.getDisplayInfoLocked());
        display.getNonOverrideDisplayInfoLocked(this.mTempNonOverrideDisplayInfo);
        display.updateLocked(this.mDisplayDeviceRepo, this.mSyntheticModeManager);
        DisplayInfo newDisplayInfo = display.getDisplayInfoLocked();
        int updateState = this.mUpdatedLogicalDisplays.get(displayId, 0);
        if (updateState == 0) goto L8;
        boolean wasPreviouslyUpdated = r4;
    L9:
        boolean wasPreviouslyEnabled = this.mDisplaysEnabledCache.get(displayId);
        boolean isCurrentlyEnabled = display.isEnabledLocked();
        int logicalDisplayEventMask = this.mLogicalDisplaysToUpdate.get(displayId, 0);
        boolean hasBasicInfoChanged = this.mTempDisplayInfo.equals(newDisplayInfo, r4) ^ r4;
        if (display.isValidLocked() == true) goto L21;
        DisplayGroup displayGroup = getDisplayGroupLocked(getDisplayGroupIdFromDisplayIdLocked(displayId));
        if (displayGroup == null) goto L14;
        displayGroup.removeDisplayLocked(display);
    L14:
        if (wasPreviouslyUpdated == true) goto L16;
        this.mLogicalDisplays.removeAt(i);
    L20:
        this.mLogicalDisplaysToUpdate.put(displayId, logicalDisplayEventMask);
    L58:
        i = i - 1;
        r4 = true;
        goto L4
    L16:
        if (this.mDisplaysEnabledCache.get(displayId) == false) goto L18;
        reloop = true;
        logicalDisplayEventMask = logicalDisplayEventMask | 4;
        goto L20
    L18:
        this.mUpdatedLogicalDisplays.delete(displayId);
        logicalDisplayEventMask = logicalDisplayEventMask | 256;
        goto L20
    L21:
        if (wasPreviouslyUpdated == true) goto L24;
        reloop = true;
        int logicalDisplayEventMask2 = logicalDisplayEventMask | 128;
    L57:
        this.mLogicalDisplaysToUpdate.put(displayId, logicalDisplayEventMask2);
        this.mUpdatedLogicalDisplays.put(displayId, 2);
        goto L58
    L24:
        if (TextUtils.equals(this.mTempDisplayInfo.uniqueId, newDisplayInfo.uniqueId) == true) goto L26;
        logicalDisplayEventMask2 = logicalDisplayEventMask | 8;
        goto L57
    L26:
        if (wasPreviouslyEnabled == isCurrentlyEnabled) goto L31;
        if (isCurrentlyEnabled == false) goto L29;
        int event = 1;
    L30:
        logicalDisplayEventMask2 = logicalDisplayEventMask | event;
        goto L57
    L29:
        event = 4;
        goto L30
    L31:
        if (wasDirty == true) goto L33;
        if (hasBasicInfoChanged == true) goto L52;
        if (this.mTempDisplayInfo.getRefreshRate() != newDisplayInfo.getRefreshRate()) goto L52;
        if (updateState != 1) goto L44;
        logicalDisplayEventMask2 = logicalDisplayEventMask | 32;
        goto L57
    L44:
        if (display.getPendingFrameRateOverrideUids().isEmpty() == true) goto L46;
        logicalDisplayEventMask2 = logicalDisplayEventMask | 16;
        goto L57
    L46:
        display.getNonOverrideDisplayInfoLocked(this.mTempDisplayInfo);
        boolean reloop2 = reloop;
        if (this.mTempNonOverrideDisplayInfo.equals(this.mTempDisplayInfo, true) == true) goto L49;
        logicalDisplayEventMask = logicalDisplayEventMask | 2;
    L49:
        logicalDisplayEventMask2 = logicalDisplayEventMask | updateAndGetMaskForDisplayPropertyChanges(this.mTempNonOverrideDisplayInfo);
        reloop = reloop2;
    L52:
        if (diff != 16) goto L54;
        logicalDisplayEventMask2 = logicalDisplayEventMask | 64;
        reloop = reloop;
        goto L57
    L54:
        if (hasBasicInfoChanged == false) goto L56;
        logicalDisplayEventMask = logicalDisplayEventMask | 2;
    L56:
        logicalDisplayEventMask2 = logicalDisplayEventMask | updateAndGetMaskForDisplayPropertyChanges(newDisplayInfo);
        reloop = reloop;
        goto L57
    L33:
        if (diff != 16) goto L35;
        logicalDisplayEventMask2 = logicalDisplayEventMask | 64;
        goto L57
    L35:
        logicalDisplayEventMask2 = logicalDisplayEventMask | UsbTerminalTypes.TERMINAL_EXTERN_DIGITAL;
        goto L57
    L8:
        wasPreviouslyUpdated = false;
        goto L9
    L59:
        boolean reloop3 = reloop;
        int i2 = this.mDisplayGroups.size();
    L60:
        i2 = i2 - 1;
        if (i2 < 0) goto L78;
        int groupId = this.mDisplayGroups.keyAt(i2);
        DisplayGroup group = this.mDisplayGroups.valueAt(i2);
        if (this.mUpdatedDisplayGroups.indexOfKey(groupId) <= (-1)) goto L65;
        boolean wasPreviouslyUpdated2 = true;
    L66:
        int changeCount = group.getChangeCountLocked();
        if (group.isEmptyLocked() == false) goto L71;
        this.mUpdatedDisplayGroups.delete(groupId);
        if (wasPreviouslyUpdated2 == false) goto L60;
        this.mDisplayGroupsToUpdate.put(groupId, 3);
        goto L60
    L71:
        if (wasPreviouslyUpdated2 == true) goto L74;
        this.mDisplayGroupsToUpdate.put(groupId, 1);
    L76:
        this.mUpdatedDisplayGroups.put(groupId, changeCount);
        goto L60
    L74:
        if (this.mUpdatedDisplayGroups.get(groupId) == changeCount) goto L76;
        this.mDisplayGroupsToUpdate.put(groupId, 2);
        goto L76
    L65:
        wasPreviouslyUpdated2 = false;
        goto L66
    L78:
        sendUpdatesForDisplaysLocked(32);
        sendUpdatesForGroupsLocked(1);
        sendUpdatesForDisplaysLocked(4);
        sendUpdatesForDisplaysLocked(256);
        sendUpdatesForDisplaysLocked(2);
        sendUpdatesForDisplaysLocked(512);
        sendUpdatesForDisplaysLocked(1024);
        sendUpdatesForDisplaysLocked(2048);
        sendUpdatesForDisplaysLocked(16);
        sendUpdatesForDisplaysLocked(8);
        sendUpdatesForDisplaysLocked(128);
        sendUpdatesForDisplaysLocked(1);
        sendUpdatesForDisplaysLocked(64);
        sendUpdatesForGroupsLocked(2);
        sendUpdatesForGroupsLocked(3);
        this.mLogicalDisplaysToUpdate.clear();
        this.mDisplayGroupsToUpdate.clear();
        if (reloop3 == false) goto L92;
        if (isSecondLoop == false) goto L83;
        Slog.wtf(TAG, "Trying to loop a third time");
        return;
    L83:
        updateLogicalDisplaysLocked(diff, true);
        return;
    }

    int updateAndGetMaskForDisplayPropertyChanges(DisplayInfo newDisplayInfo) {
        int mask = 0;
        if (this.mTempDisplayInfo.getRefreshRate() == newDisplayInfo.getRefreshRate()) goto L6;
        mask = 0 | 512;
    L6:
        if (this.mFlags.isDisplayListenerPerformanceImprovementsEnabled() == false) goto L11;
        if (this.mTempDisplayInfo.state == newDisplayInfo.state) goto L11;
        mask = mask | 1024;
    L11:
        if (this.mFlags.isCommittedStateSeparateEventEnabled() == true) goto L13;
        return mask;
    L13:
        if (this.mTempDisplayInfo.committedState != newDisplayInfo.committedState) goto L15;
        return mask;
    L15:
        return mask | 2048;
    }

    private void sendUpdatesForDisplaysLocked(int logicalDisplayEvent) {
        int i = this.mLogicalDisplaysToUpdate.size() - 1;
    L3:
        if (i < 0) goto L24;
        int logicalDisplayEventMask = this.mLogicalDisplaysToUpdate.valueAt(i);
        if ((logicalDisplayEventMask & logicalDisplayEvent) == 0) goto L22;
        int id = this.mLogicalDisplaysToUpdate.keyAt(i);
        LogicalDisplay display = getDisplayLocked(id);
        if (DEBUG == false) goto L14;
        DisplayDevice device = display.getPrimaryDisplayDeviceLocked();
        if (device != null) goto L12;
        String uniqueId = "null";
    L13:
        Slog.d(TAG, "Sending " + displayEventToString(logicalDisplayEvent) + " for display=" + id + " with device=" + uniqueId);
        goto L14
    L12:
        uniqueId = device.getUniqueId();
    L14:
        if (logicalDisplayEvent != 1) goto L17;
        this.mDisplaysEnabledCache.put(id, true);
    L19:
        this.mListener.onLogicalDisplayEventLocked(display, logicalDisplayEvent);
        if (logicalDisplayEvent != 256) goto L22;
        this.mLogicalDisplays.delete(id);
        goto L22
    L17:
        if (logicalDisplayEvent != 4) goto L19;
        this.mDisplaysEnabledCache.delete(id);
    L22:
        i = i - 1;
        goto L3
    }

    private void sendUpdatesForGroupsLocked(int msg) {
        int i = this.mDisplayGroupsToUpdate.size() - 1;
    L3:
        if (i < 0) goto L14;
        int currMsg = this.mDisplayGroupsToUpdate.valueAt(i);
        if (currMsg != msg) goto L12;
        int id = this.mDisplayGroupsToUpdate.keyAt(i);
        this.mListener.onDisplayGroupEventLocked(id, msg);
        if (msg != 3) goto L12;
        this.mDisplayGroups.delete(id);
        int deviceIndex = this.mDeviceDisplayGroupIds.indexOfValue(id);
        if (deviceIndex < 0) goto L12;
        this.mDeviceDisplayGroupIds.removeAt(deviceIndex);
    L12:
        i = i - 1;
        goto L3
    }

    private void assignDisplayGroupLocked(LogicalDisplay display) {
        if (display.isValidLocked() == true) goto L5;
        return;
    L5:
        DisplayDevice displayDevice = display.getPrimaryDisplayDeviceLocked();
        int displayId = display.getDisplayIdLocked();
        String primaryDisplayUniqueId = displayDevice.getUniqueId();
        Integer linkedDeviceUniqueId = this.mVirtualDeviceDisplayMapping.get(primaryDisplayUniqueId);
        int groupId = getDisplayGroupIdFromDisplayIdLocked(displayId);
        Integer deviceDisplayGroupId = null;
        if (linkedDeviceUniqueId != null) goto L8;
    L10:
        DisplayGroup oldGroup = getDisplayGroupLocked(groupId);
        String groupName = display.getDisplayGroupNameLocked();
        DisplayDeviceInfo displayDeviceInfo = displayDevice.getDisplayDeviceInfoLocked();
        if ((displayDeviceInfo.flags & 16384) == 0) goto L13;
    L16:
        boolean needsOwnDisplayGroup = true;
    L18:
        if (groupId == 0) goto L20;
        boolean hasOwnDisplayGroup = true;
    L21:
        if (needsOwnDisplayGroup == true) goto L24;
        if (linkedDeviceUniqueId == null) goto L24;
        boolean needsDeviceDisplayGroup = true;
    L25:
        if (deviceDisplayGroupId != null) goto L27;
    L29:
        boolean hasDeviceDisplayGroup = false;
    L31:
        if (groupId == (-1)) goto L35;
        if (hasOwnDisplayGroup != needsOwnDisplayGroup) goto L35;
        if (hasDeviceDisplayGroup != needsDeviceDisplayGroup) goto L35;
    L36:
        DisplayGroup newGroup = getDisplayGroupLocked(groupId);
        if (newGroup != null) goto L40;
        newGroup = new DisplayGroup(groupId);
        this.mDisplayGroups.append(groupId, newGroup);
    L40:
        if (oldGroup == newGroup) goto L49;
        if (oldGroup == null) goto L43;
        oldGroup.removeDisplayLocked(display);
    L43:
        newGroup.addDisplayLocked(display);
        display.updateDisplayGroupIdLocked(groupId);
        StringBuilder r2 = new StringBuilder();
        r2.append("Setting new display group ");
        r2.append(groupId);
        r2.append(" for display ");
        r2.append(displayId);
        r2.append(", from previous group: ");
        if (oldGroup == null) goto L46;
        Object r0 = Integer.valueOf(oldGroup.getGroupId());
    L47:
        r2.append(r0);
        Slog.i(TAG, r2.toString());
        return;
    L46:
        r0 = "null";
        goto L47
    L49:
        return;
    L35:
        groupId = assignDisplayGroupIdLocked(needsOwnDisplayGroup, display.getDisplayGroupNameLocked(), needsDeviceDisplayGroup, linkedDeviceUniqueId);
        goto L36
    L27:
        if (groupId != deviceDisplayGroupId.intValue()) goto L29;
        hasDeviceDisplayGroup = true;
    L24:
        needsDeviceDisplayGroup = false;
        goto L25
    L20:
        hasOwnDisplayGroup = false;
        goto L21
    L13:
        if (TextUtils.isEmpty(groupName) == false) goto L16;
        needsOwnDisplayGroup = false;
        goto L18
    L8:
        if (this.mDeviceDisplayGroupIds.indexOfKey(linkedDeviceUniqueId.intValue()) <= 0) goto L10;
        deviceDisplayGroupId = Integer.valueOf(this.mDeviceDisplayGroupIds.get(linkedDeviceUniqueId.intValue()));
        goto L10
    }

    private void resetLayoutLocked(int fromState, int toState, boolean transitionValue) {
        Layout fromLayout = this.mDeviceStateToLayoutMap.get(fromState);
        Layout toLayout = this.mDeviceStateToLayoutMap.get(toState);
        int count = this.mLogicalDisplays.size();
        int i = 0;
    L3:
        if (i >= count) goto L61;
        LogicalDisplay logicalDisplay = this.mLogicalDisplays.valueAt(i);
        int displayId = logicalDisplay.getDisplayIdLocked();
        DisplayDevice device = logicalDisplay.getPrimaryDisplayDeviceLocked();
        if (device != null) goto L7;
        Layout fromLayout2 = fromLayout;
    L59:
        i = i + 1;
        fromLayout = fromLayout2;
        goto L3
    L7:
        DisplayAddress address = device.getDisplayDeviceInfoLocked().address;
        Layout.Display toDisplay = null;
        if (address == null) goto L10;
        Layout.Display fromDisplay = fromLayout.getByAddress(address);
    L11:
        if (address == null) goto L13;
        toDisplay = toLayout.getByAddress(address);
    L13:
        if (fromDisplay != null) goto L15;
        boolean r14 = true;
    L16:
        if (toDisplay != null) goto L18;
        boolean r15 = true;
    L19:
        if (r14 == r15) goto L21;
        boolean displayNotInBothLayouts = true;
    L22:
        if (fromDisplay != null) goto L24;
    L27:
        boolean wasEnabled = true;
    L28:
        if (toDisplay != null) goto L30;
    L33:
        boolean r17 = true;
    L34:
        boolean willBeEnabled = r17;
        if (fromDisplay == null) goto L40;
        if (toDisplay == null) goto L40;
        fromLayout2 = fromLayout;
        if (fromDisplay.getLogicalDisplayId() == toDisplay.getLogicalDisplayId()) goto L41;
        boolean deviceHasNewLogicalDisplayId = true;
    L43:
        if (logicalDisplay.isInTransitionLocked() == true) goto L50;
        boolean willBeEnabled2 = willBeEnabled;
        if (wasEnabled != willBeEnabled2) goto L51;
        if (deviceHasNewLogicalDisplayId == true) goto L51;
        if (displayNotInBothLayouts == true) goto L51;
        boolean isTransitioning = false;
    L52:
        if (isTransitioning == false) goto L59;
        boolean deviceHasNewLogicalDisplayId2 = logicalDisplay.isInTransitionLocked();
        if (transitionValue == deviceHasNewLogicalDisplayId2) goto L57;
        Slog.i(TAG, "Set isInTransition on display " + displayId + ": " + transitionValue);
    L57:
        logicalDisplay.setIsInTransitionLocked(transitionValue);
        this.mUpdatedLogicalDisplays.put(displayId, 1);
    L51:
        isTransitioning = true;
        goto L52
    L50:
        willBeEnabled2 = willBeEnabled;
    L41:
        deviceHasNewLogicalDisplayId = false;
    L40:
        fromLayout2 = fromLayout;
        goto L41
    L30:
        if (toDisplay.isEnabled() == true) goto L33;
        r17 = false;
        goto L34
    L24:
        if (fromDisplay.isEnabled() == true) goto L27;
        wasEnabled = false;
        goto L28
    L21:
        displayNotInBothLayouts = false;
        goto L22
    L18:
        r15 = false;
        goto L19
    L15:
        r14 = false;
        goto L16
    L10:
        fromDisplay = null;
        goto L11
    }

    private void applyLayoutLocked() {
        Layout oldLayout = this.mCurrentLayout;
        this.mCurrentLayout = this.mDeviceStateToLayoutMap.get(this.mDeviceState.getIdentifier());
        Slog.i(TAG, "Applying layout: " + this.mCurrentLayout + ", Previous layout: " + oldLayout);
        int size = this.mCurrentLayout.size();
        int i = 0;
    L3:
        if (i >= size) goto L28;
        Layout.Display displayLayout = this.mCurrentLayout.getAt(i);
        DisplayAddress address = displayLayout.getAddress();
        DisplayDevice device = this.mDisplayDeviceRepo.getByAddressLocked(address);
        if (device != null) goto L7;
        Slog.w(TAG, "applyLayoutLocked: The display device (" + address + "), is not available for the display state " + this.mDeviceState.getIdentifier());
    L26:
        i = i + 1;
        goto L3
    L7:
        int logicalDisplayId = displayLayout.getLogicalDisplayId();
        LogicalDisplay newDisplay = getDisplayLocked(logicalDisplayId);
        boolean newDisplayCreated = false;
        if (newDisplay != null) goto L10;
        newDisplay = createNewLogicalDisplayLocked(null, logicalDisplayId);
        newDisplayCreated = true;
    L10:
        LogicalDisplay oldDisplay = getDisplayLocked(device);
        if (newDisplay == oldDisplay) goto L17;
        if (newDisplayCreated == false) goto L14;
    L16:
        newDisplay.swapDisplaysLocked(oldDisplay);
        goto L17
    L14:
        if (this.mWindowManagerPolicy == null) goto L16;
        this.mWindowManagerPolicy.onDisplaySwitchStart(newDisplay.getDisplayIdLocked());
    L17:
        DisplayDeviceConfig config = device.getDisplayDeviceConfig();
        newDisplay.setDevicePositionLocked(displayLayout.getPosition());
        newDisplay.setLeadDisplayLocked(displayLayout.getLeadDisplayId());
        newDisplay.updateLayoutLimitedRefreshRateLocked(config.getRefreshRange(displayLayout.getRefreshRateZoneId()));
        newDisplay.updateThermalRefreshRateThrottling(config.getThermalRefreshRateThrottlingData(displayLayout.getRefreshRateThermalThrottlingMapId()));
        setEnabledLocked(newDisplay, displayLayout.isEnabled());
        String r13 = "default";
        if (displayLayout.getThermalBrightnessThrottlingMapId() != null) goto L20;
        String r12 = "default";
    L21:
        newDisplay.setThermalBrightnessThrottlingDataIdLocked(r12);
        if (displayLayout.getPowerThrottlingMapId() == null) goto L25;
        r13 = displayLayout.getPowerThrottlingMapId();
    L25:
        newDisplay.setPowerThrottlingDataIdLocked(r13);
        newDisplay.setDisplayGroupNameLocked(displayLayout.getDisplayGroupName());
        goto L26
    L20:
        r12 = displayLayout.getThermalBrightnessThrottlingMapId();
        goto L21
    }

    private LogicalDisplay createNewLogicalDisplayLocked(DisplayDevice device, int displayId) {
        int layerStack = assignLayerStackLocked(displayId);
        LogicalDisplay display = new LogicalDisplay(displayId, layerStack, device, this.mFlags.isPixelAnisotropyCorrectionInLogicalDisplayEnabled(), this.mFlags.isAlwaysRotateDisplayDeviceEnabled(), this.mFlags.isSyncedResolutionSwitchEnabled());
        display.updateLocked(this.mDisplayDeviceRepo, this.mSyntheticModeManager);
        DisplayInfo info = display.getDisplayInfoLocked();
        if (info.type == 1) goto L5;
    L7:
        this.mLogicalDisplays.put(displayId, display);
        return display;
    L5:
        if (this.mDeviceStateToLayoutMap.size() <= 1) goto L7;
        display.setEnabledLocked(false);
        goto L7
    }

    void setEnabledLocked(LogicalDisplay display, boolean isEnabled) {
        int displayId = display.getDisplayIdLocked();
        DisplayInfo info = display.getDisplayInfoLocked();
        if (this.mSingleDisplayDemoMode == false) goto L7;
        boolean disallowSecondaryDisplay = true;
        if (info.type == 1) goto L7;
    L9:
        if (isEnabled == false) goto L13;
        if (disallowSecondaryDisplay == false) goto L13;
        Slog.i(TAG, "Not creating a logical display for a secondary display because single display demo mode is enabled: " + display.getDisplayInfoLocked());
        isEnabled = false;
    L13:
        if (display.isEnabledLocked() == isEnabled) goto L16;
        Slog.i(TAG, "SetEnabled on display " + displayId + ": " + isEnabled);
        display.setEnabledLocked(isEnabled);
        return;
    L16:
        return;
    L7:
        disallowSecondaryDisplay = false;
        goto L9
    }

    private int assignDisplayGroupIdLocked(boolean isOwnDisplayGroup, String displayGroupName, boolean isDeviceDisplayGroup, Integer linkedDeviceUniqueId) {
        if (isDeviceDisplayGroup == false) goto L8;
        if (linkedDeviceUniqueId == null) goto L8;
        int deviceDisplayGroupId = this.mDeviceDisplayGroupIds.get(linkedDeviceUniqueId.intValue());
        if (deviceDisplayGroupId != 0) goto L16;
        int deviceDisplayGroupId2 = this.mNextNonDefaultGroupId;
        this.mNextNonDefaultGroupId = deviceDisplayGroupId2 + 1;
        this.mDeviceDisplayGroupIds.put(linkedDeviceUniqueId.intValue(), deviceDisplayGroupId2);
        return deviceDisplayGroupId2;
    L16:
        return deviceDisplayGroupId;
    L8:
        if (isOwnDisplayGroup == true) goto L11;
        return 0;
    L11:
        Integer displayGroupId = this.mDisplayGroupIdsByName.get(displayGroupName);
        if (displayGroupId != null) goto L15;
        int r1 = this.mNextNonDefaultGroupId;
        this.mNextNonDefaultGroupId = r1 + 1;
        displayGroupId = Integer.valueOf(r1);
        this.mDisplayGroupIdsByName.put(displayGroupName, displayGroupId);
    L15:
        return displayGroupId.intValue();
    }

    private void initializeDefaultDisplayDeviceLocked(DisplayDevice device) {
        Layout layout = this.mDeviceStateToLayoutMap.get(-1);
        if (layout.getById(0) == null) goto L5;
        return;
    L5:
        DisplayDeviceInfo info = device.getDisplayDeviceInfoLocked();
        layout.createDefaultDisplayLocked(info.address, this.mIdProducer);
    }

    private int assignLayerStackLocked(int displayId) {
        return displayId;
    }

    private SparseBooleanArray toSparseBooleanArray(int[] input) {
        SparseBooleanArray retval = new SparseBooleanArray(2);
        int i = 0;
    L3:
        if (input == null) goto L7;
        if (i >= input.length) goto L7;
        retval.put(input[i], true);
        i = i + 1;
    L7:
        return retval;
    }

    private boolean shouldStayAwakeOnFold() {
        if (this.mFoldSettingProvider.shouldStayAwakeOnFold() == false) goto L5;
    L10:
        return true;
    L5:
        if (this.mFoldSettingProvider.shouldSelectiveStayAwakeOnFold() == true) goto L7;
    L9:
        return false;
    L7:
        if (this.mFoldGracePeriodProvider.isEnabled() == false) goto L9;
        goto L9
    }

    private String displayEventToString(int msg) {
        switch(msg) {
            case 1: goto L27;
            case 2: goto L25;
            case 4: goto L23;
            case 8: goto L21;
            case 16: goto L19;
            case 32: goto L17;
            case 64: goto L15;
            case 128: goto L13;
            case 256: goto L11;
            case 512: goto L9;
            case 1024: goto L7;
            case 2048: goto L5;
            default: goto L3;
        };
    L3:
        return null;
    L5:
        return "committed_state_changed";
    L7:
        return "state_changed";
    L9:
        return "refresh_rate_changed";
    L11:
        return "disconnected";
    L13:
        return "connected";
    L15:
        return "hdr_sdr_ratio_changed";
    L17:
        return "transition";
    L19:
        return "framerate_override";
    L21:
        return "swapped";
    L23:
        return "removed";
    L25:
        return "basic_changed";
    L27:
        return "added";
    }

    void setDisplayEnabledLocked(LogicalDisplay display, boolean enabled) {
        boolean isEnabled = display.isEnabledLocked();
        if (isEnabled != enabled) goto L10;
        StringBuilder r1 = new StringBuilder();
        r1.append("Display is already ");
        if (isEnabled == false) goto L7;
        String r2 = ServiceConfigAccessor.PROVIDER_MODE_ENABLED;
    L8:
        r1.append(r2);
        r1.append(": ");
        r1.append(display.getDisplayIdLocked());
        Slog.w(TAG, r1.toString());
        return;
    L7:
        r2 = ServiceConfigAccessor.PROVIDER_MODE_DISABLED;
        goto L8
    L10:
        setEnabledLocked(display, enabled);
        updateLogicalDisplaysLocked();
    }
}
