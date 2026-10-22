package com.android.server.display;

import android.R;
import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.AppOpsManager;
import android.app.backup.BackupManager;
import android.app.compat.CompatChanges;
import android.companion.virtual.IVirtualDevice;
import android.companion.virtual.VirtualDeviceManager;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ParceledListSlice;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.ContentObserver;
import android.graphics.ColorSpace;
import android.graphics.Point;
import android.gui.IDisplayProcessListener;
import android.hardware.OverlayProperties;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.devicestate.DeviceState;
import android.hardware.devicestate.DeviceStateManager;
import android.hardware.devicestate.DeviceStateManagerInternal;
import android.hardware.display.AmbientBrightnessDayStats;
import android.hardware.display.BrightnessChangeEvent;
import android.hardware.display.BrightnessConfiguration;
import android.hardware.display.BrightnessInfo;
import android.hardware.display.Curve;
import android.hardware.display.DisplayManagerGlobal;
import android.hardware.display.DisplayManagerInternal;
import android.hardware.display.DisplayManagerInternalSmtEx;
import android.hardware.display.DisplayTopology;
import android.hardware.display.DisplayTopologyGraph;
import android.hardware.display.DisplayViewport;
import android.hardware.display.DisplayedContentSample;
import android.hardware.display.DisplayedContentSamplingAttributes;
import android.hardware.display.ExtDisplayManagerInternal;
import android.hardware.display.HdrConversionMode;
import android.hardware.display.IDisplayManager;
import android.hardware.display.IDisplayManagerCallback;
import android.hardware.display.IDisplayManagerExt;
import android.hardware.display.IVirtualDisplayCallback;
import android.hardware.display.VirtualDisplayConfig;
import android.hardware.display.WifiDisplayStatus;
import android.hardware.graphics.common.DisplayDecorationSupport;
import android.hardware.input.HostUsiVersion;
import android.media.projection.IMediaProjection;
import android.media.projection.IMediaProjectionManager;
import android.net.Uri;
import android.os.Binder;
import android.os.FrozenObjectException;
import android.os.Handler;
import android.os.HandlerExecutor;
import android.os.IBinder;
import android.os.IThermalService;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.PermissionEnforcer;
import android.os.Process;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ServiceManager;
import android.os.ShellCallback;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.Trace;
import android.os.UserHandle;
import android.os.UserManager;
import android.pico.utils.ExtImplFactory;
import android.provider.DeviceConfig;
import android.provider.DeviceConfigInterface;
import android.provider.Settings;
import android.sysprop.DisplayProperties;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.EventLog;
import android.util.IndentingPrintWriter;
import android.util.IntArray;
import android.util.MathUtils;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Spline;
import android.view.ContentRecordingSession;
import android.view.Display;
import android.view.DisplayEventReceiver;
import android.view.DisplayInfo;
import android.view.Surface;
import android.view.SurfaceControl;
import android.window.DisplayWindowPolicyController;
import android.window.ScreenCapture;
import com.android.internal.display.BrightnessSynchronizer;
import com.android.internal.foldables.FoldGracePeriodProvider;
import com.android.internal.foldables.FoldLockSettingAvailabilityProvider;
import com.android.internal.os.BackgroundThread;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.SettingsWrapper;
import com.android.server.AnimationThread;
import com.android.server.BinaryTransparencyService$Digest$$ExternalSyntheticRecord1;
import com.android.server.DisplayThread;
import com.android.server.LocalServices;
import com.android.server.SysOptBridge;
import com.android.server.SystemService;
import com.android.server.UiThread;
import com.android.server.companion.virtual.VirtualDeviceManagerInternal;
import com.android.server.display.config.SensorData;
import com.android.server.display.feature.DeviceConfigParameterProvider;
import com.android.server.display.feature.DisplayManagerFlags;
import com.android.server.display.mode.DisplayModeDirector;
import com.android.server.display.notifications.DisplayNotificationManager;
import com.android.server.display.plugin.PluginManager;
import com.android.server.display.utils.DebugUtils;
import com.android.server.display.utils.SensorUtils;
import com.android.server.input.InputManagerInternal;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.utils.FoldSettingProvider;
import com.android.server.wm.SurfaceAnimationThread;
import com.android.server.wm.WindowManagerInternal;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public final class DisplayManagerService extends SystemService {
    private static final boolean DEBUG = false;
    static final long DISPLAY_MODE_RETURNS_PHYSICAL_REFRESH_RATE = 170503758;
    private static final int[] EMPTY_ARRAY = null;
    private static final String FORCE_WIFI_DISPLAY_ENABLE = "persist.debug.wfd.enable";
    private static final HdrConversionMode HDR_CONVERSION_MODE_UNSUPPORTED = null;
    private static final int MSG_DELIVER_DISPLAY_EVENT = 3;
    private static final int MSG_DELIVER_DISPLAY_EVENT_FRAME_RATE_OVERRIDE = 7;
    private static final int MSG_DELIVER_DISPLAY_GROUP_EVENT = 8;
    private static final int MSG_DISPATCH_PENDING_PROCESS_EVENTS = 10;
    private static final int MSG_LOAD_BRIGHTNESS_CONFIGURATIONS = 6;
    private static final int MSG_RECEIVED_DEVICE_STATE = 9;
    private static final int MSG_REGISTER_ADDITIONAL_DISPLAY_ADAPTERS = 2;
    private static final int MSG_REGISTER_DEFAULT_DISPLAY_ADAPTERS = 1;
    private static final int MSG_REQUEST_TRAVERSAL = 4;
    private static final int MSG_UPDATE_VIEWPORT = 5;
    private static final String PROP_DEFAULT_DISPLAY_TOP_INSET = "persist.sys.displayinset.top";
    private static final String SURFACE_COMPOSER_AIDL_INTERFACE = "android.gui.ISurfaceComposer";
    private static final int SURFACE_COMPOSER_TRANSACTION_ADD_DISPLAY_PROCESS_LISTENER = 69;
    private static final String SURFACE_FLINGER_AIDL_SERVICE = "SurfaceFlingerAIDL";
    private static final String TAG = "DisplayManagerService";
    private static final float THRESHOLD_FOR_REFRESH_RATES_DIVISORS = 9.0E-4f;
    private static final long WAIT_FOR_DEFAULT_DISPLAY_TIMEOUT = 10000;
    private ActivityManagerInternal mActivityManagerInternal;
    private boolean mAreUserDisabledHdrTypesAllowed;
    private boolean mBootCompleted;
    private final BrightnessSynchronizer mBrightnessSynchronizer;
    private BrightnessTracker mBrightnessTracker;
    private final SparseArray<SparseArray<CallbackRecord>> mCallbackRecordByPidByUid;
    private final SparseArray<CallbackRecord> mCallbacks;
    private int mComposerServiceProcessId;
    private final DeviceConfigParameterProvider mConfigParameterProvider;
    final Context mContext;
    private int mCurrentUserId;
    private final int mDefaultDisplayDefaultColorMode;
    private int mDefaultDisplayTopInset;
    private final int mDefaultHdrConversionMode;
    private DeviceStateManagerInternal mDeviceStateManager;
    private final SparseArray<IntArray> mDisplayAccessUIDs;
    private final ArrayList<DisplayAdapter> mDisplayAdapters;
    private final DisplayBlanker mDisplayBlanker;
    private final SparseArray<BrightnessPair> mDisplayBrightnesses;
    private final DisplayModeDirector.DisplayDeviceConfigProvider mDisplayDeviceConfigProvider;
    private final DisplayDeviceRepository mDisplayDeviceRepo;
    private final CopyOnWriteArrayList<DisplayManagerInternal.DisplayGroupListener> mDisplayGroupListeners;
    private final DisplayModeDirector mDisplayModeDirector;
    private final DisplayNotificationManager mDisplayNotificationManager;
    private DisplayManagerInternal.DisplayPowerCallbacks mDisplayPowerCallbacks;
    final SparseArray<DisplayPowerController> mDisplayPowerControllers;
    private final IDisplayProcessListener mDisplayProcessListener;
    private final SparseIntArray mDisplayStates;
    private final DisplayTopologyCoordinator mDisplayTopologyCoordinator;
    private final CopyOnWriteArrayList<DisplayManagerInternal.DisplayTransactionListener> mDisplayTransactionListeners;
    final SparseArray<Pair<IVirtualDevice, DisplayWindowPolicyController>> mDisplayWindowPolicyControllers;
    private boolean mDumpInProgress;
    private IExtDisplayManagerService mExt;
    private final ExternalDisplayPolicy mExternalDisplayPolicy;
    private final ExternalDisplayStatsService mExternalDisplayStatsService;
    private final boolean mExtraDisplayEventLogging;
    private final String mExtraDisplayLoggingPackageName;
    private final DisplayManagerFlags mFlags;
    private final DisplayManagerHandler mHandler;
    private final HandlerExecutor mHandlerExecutor;
    private HdrConversionMode mHdrConversionMode;
    private final HighBrightnessModeMetadataMapper mHighBrightnessModeMetadataMapper;
    private final BroadcastReceiver mIdleModeReceiver;
    private final Injector mInjector;
    private InputManagerInternal mInputManagerInternal;
    private boolean mIsDocked;
    private boolean mIsDreaming;
    private volatile boolean mIsHdrOutputControlEnabled;
    final LogicalDisplayMapper mLogicalDisplayMapper;
    private int mMaxImportanceForRRCallbacks;
    private boolean mMinimalPostProcessingAllowed;
    private final Curve mMinimumBrightnessCurve;
    private final Spline mMinimumBrightnessSpline;
    private boolean mMirrorBuiltInDisplay;
    private final OverlayProperties mOverlayProperties;
    private final SparseArray<SparseArray<PendingCallback>> mPendingCallbackSelfLocked;
    private boolean mPendingTraversal;
    final PersistentDataStore mPersistentDataStore;
    private final PluginManager mPluginManager;
    private Handler mPowerHandler;
    private IMediaProjectionManager mProjectionService;
    private final BroadcastReceiver mResolutionRestoreReceiver;
    public boolean mSafeMode;
    private SensorManager mSensorManager;
    private SettingsObserver mSettingsObserver;
    private boolean mShouldDisableHdrConversion;
    private SmallAreaDetectionController mSmallAreaDetectionController;
    private DisplayManagerServiceSmtEx mSmtEx;
    private Point mStableDisplaySize;
    private int[] mSupportedHdrOutputTypes;
    private int mSurfaceFlingerProcessId;
    private final SyncRoot mSyncDump;
    final SyncRoot mSyncRoot;
    private int mSystemPreferredHdrOutputType;
    private boolean mSystemReady;
    private final ArrayList<CallbackRecord> mTempCallbacks;
    private final ArrayList<DisplayViewport> mTempViewports;
    private final Handler mUiHandler;
    private final UidImportanceListener mUidImportanceListener;
    private int[] mUserDisabledHdrTypes;
    private Display.Mode mUserPreferredMode;
    private final ArrayList<DisplayViewport> mViewports;
    private VirtualDisplayAdapter mVirtualDisplayAdapter;
    private final ColorSpace mWideColorSpace;
    private WifiDisplayAdapter mWifiDisplayAdapter;
    private int mWifiDisplayScanRequestCount;
    private WindowManagerInternal mWindowManagerInternal;

    final class BinderService extends IDisplayManager.Stub {
        final /* synthetic */ DisplayManagerService this$0;

        /* JADX INFO: renamed from: $r8$lambda$TgC-usWJ4qMLycF_DVusMjG7Z5s, reason: not valid java name */
        public static /* synthetic */ void m3732$r8$lambda$TgCusWJ4qMLycF_DVusMjG7Z5s(BinderService r0, BrightnessConfiguration r1, int r2, String r3, LogicalDisplay r4) {
            r0.lambda$setBrightnessConfigurationForUser$0(r1, r2, r3, r4);
        }

        BinderService(DisplayManagerService this$0) {
            this.this$0 = this$0;
            super(PermissionEnforcer.fromContext(this$0.getContext()));
        }

        public DisplayInfo getDisplayInfo(int displayId) {
            int callingUid = Binder.getCallingUid();
            long token = Binder.clearCallingIdentity();
            DisplayInfo r3 = DisplayManagerService.m3675$$Nest$mgetDisplayInfoInternal(this.this$0, displayId, callingUid);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return r3;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public int[] getDisplayIds(boolean includeDisabled) {
            int callingUid = Binder.getCallingUid();
            long token = Binder.clearCallingIdentity();
            SyncRoot r3 = this.this$0.mSyncRoot;     // Catch: Throwable -> L12
            monitor-enter(r3);     // Catch: Throwable -> L12
            int[] r4 = this.this$0.mLogicalDisplayMapper.getDisplayIdsLocked(callingUid, includeDisabled);     // Catch: Throwable -> L9
            monitor-exit(r3);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(token);
            return r4;
        L9:
            th = move-exception;
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public boolean isUidPresentOnDisplay(int uid, int displayId) {
            long token = Binder.clearCallingIdentity();
            boolean r2 = DisplayManagerService.m3697$$Nest$misUidPresentOnDisplayInternal(this.this$0, uid, displayId);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public Point getStableDisplaySize() {
            long token = Binder.clearCallingIdentity();
            Point r2 = DisplayManagerService.m3679$$Nest$mgetStableDisplaySizeInternal(this.this$0);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public void registerCallback(IDisplayManagerCallback callback) {
            registerCallbackWithEventMask(callback, 71);
        }

        public void registerCallbackWithEventMask(IDisplayManagerCallback callback, long internalEventFlagsMask) {
            if (callback == null) goto L19;
            int callingPid = Binder.getCallingPid();
            int callingUid = Binder.getCallingUid();
            if ((32 & internalEventFlagsMask) == 0) goto L6;
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_DISPLAYS", "Permission required to get signals about connection events.");
        L6:
            long token = Binder.clearCallingIdentity();
            DisplayManagerService.m3702$$Nest$mregisterCallbackInternal(this.this$0, callback, callingPid, callingUid, internalEventFlagsMask);     // Catch: Throwable -> L12
            Binder.restoreCallingIdentity(token);
            return;
        L12:
            th = move-exception;
            Throwable r9 = th;
        L16:
            Binder.restoreCallingIdentity(token);
            throw r9;
        L14:
            th = move-exception;
            r9 = th;
            goto L16
        L19:
            throw new IllegalArgumentException("listener must not be null");
        }

        public void startWifiDisplayScan() {
            startWifiDisplayScan_enforcePermission();
            int callingPid = Binder.getCallingPid();
            long token = Binder.clearCallingIdentity();
            DisplayManagerService.m3722$$Nest$mstartWifiDisplayScanInternal(this.this$0, callingPid);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public void stopWifiDisplayScan() {
            stopWifiDisplayScan_enforcePermission();
            int callingPid = Binder.getCallingPid();
            long token = Binder.clearCallingIdentity();
            DisplayManagerService.m3723$$Nest$mstopWifiDisplayScanInternal(this.this$0, callingPid);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public void connectWifiDisplay(String address) {
            connectWifiDisplay_enforcePermission();
            if (address == null) goto L12;
            long token = Binder.clearCallingIdentity();
            DisplayManagerService.m3663$$Nest$mconnectWifiDisplayInternal(this.this$0, address);     // Catch: Throwable -> L8
            Binder.restoreCallingIdentity(token);
            return;
        L8:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        L12:
            throw new IllegalArgumentException("address must not be null");
        }

        public void disconnectWifiDisplay() {
            long token = Binder.clearCallingIdentity();
            DisplayManagerService.m3667$$Nest$mdisconnectWifiDisplayInternal(this.this$0);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public void renameWifiDisplay(String address, String alias) {
            renameWifiDisplay_enforcePermission();
            if (address == null) goto L12;
            long token = Binder.clearCallingIdentity();
            DisplayManagerService.m3706$$Nest$mrenameWifiDisplayInternal(this.this$0, address, alias);     // Catch: Throwable -> L8
            Binder.restoreCallingIdentity(token);
            return;
        L8:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        L12:
            throw new IllegalArgumentException("address must not be null");
        }

        public void forgetWifiDisplay(String address) {
            forgetWifiDisplay_enforcePermission();
            if (address == null) goto L12;
            long token = Binder.clearCallingIdentity();
            DisplayManagerService.m3671$$Nest$mforgetWifiDisplayInternal(this.this$0, address);     // Catch: Throwable -> L8
            Binder.restoreCallingIdentity(token);
            return;
        L8:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        L12:
            throw new IllegalArgumentException("address must not be null");
        }

        public void pauseWifiDisplay() {
            pauseWifiDisplay_enforcePermission();
            long token = Binder.clearCallingIdentity();
            DisplayManagerService.m3700$$Nest$mpauseWifiDisplayInternal(this.this$0);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public void resumeWifiDisplay() {
            resumeWifiDisplay_enforcePermission();
            long token = Binder.clearCallingIdentity();
            DisplayManagerService.m3711$$Nest$mresumeWifiDisplayInternal(this.this$0);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public WifiDisplayStatus getWifiDisplayStatus() {
            long token = Binder.clearCallingIdentity();
            WifiDisplayStatus r2 = DisplayManagerService.m3682$$Nest$mgetWifiDisplayStatusInternal(this.this$0);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public void setUserDisabledHdrTypes(int[] userDisabledFormats) {
            setUserDisabledHdrTypes_enforcePermission();
            long token = Binder.clearCallingIdentity();
            this.this$0.setUserDisabledHdrTypesInternal(userDisabledFormats);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public void overrideHdrTypes(int displayId, int[] modes) {
            SyncRoot r0 = this.this$0.mSyncRoot;
            monitor-enter(r0);
            IBinder displayToken = getDisplayToken(displayId);     // Catch: Throwable -> L9
            if (displayToken == null) goto L12;
            monitor-exit(r0);     // Catch: Throwable -> L9
            DisplayControl.overrideHdrTypes(displayToken, modes);
            return;
        L12:
            throw new IllegalArgumentException("Invalid display: " + displayId);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
        }

        public void setAreUserDisabledHdrTypesAllowed(boolean areUserDisabledHdrTypesAllowed) {
            setAreUserDisabledHdrTypesAllowed_enforcePermission();
            long token = Binder.clearCallingIdentity();
            this.this$0.setAreUserDisabledHdrTypesAllowedInternal(areUserDisabledHdrTypesAllowed);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public boolean areUserDisabledHdrTypesAllowed() {
            SyncRoot r0 = this.this$0.mSyncRoot;
            monitor-enter(r0);
            boolean r1 = DisplayManagerService.m3623$$Nest$fgetmAreUserDisabledHdrTypesAllowed(this.this$0);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public int[] getUserDisabledHdrTypes() {
            SyncRoot r0 = this.this$0.mSyncRoot;
            monitor-enter(r0);
            int[] r1 = DisplayManagerService.m3651$$Nest$fgetmUserDisabledHdrTypes(this.this$0);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public void requestColorMode(int displayId, int colorMode) {
            requestColorMode_enforcePermission();
            long token = Binder.clearCallingIdentity();
            DisplayManagerService.m3707$$Nest$mrequestColorModeInternal(this.this$0, displayId, colorMode);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public int createVirtualDisplay(VirtualDisplayConfig virtualDisplayConfig, IVirtualDisplayCallback callback, IMediaProjection projection, String packageName) {
            return DisplayManagerService.m3664$$Nest$mcreateVirtualDisplayInternal(this.this$0, virtualDisplayConfig, callback, projection, null, null, packageName);
        }

        public void resizeVirtualDisplay(IVirtualDisplayCallback callback, int width, int height, int densityDpi) {
            if (width <= 0) goto L13;
            if (height <= 0) goto L13;
            if (densityDpi <= 0) goto L13;
            long token = Binder.clearCallingIdentity();
            DisplayManagerService.m3709$$Nest$mresizeVirtualDisplayInternal(this.this$0, callback.asBinder(), width, height, densityDpi);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(token);
            return;
        L9:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        L13:
            throw new IllegalArgumentException("width, height, and densityDpi must be greater than 0");
        }

        public void setVirtualDisplaySurface(IVirtualDisplayCallback callback, Surface surface) {
            if (surface != null) goto L4;
        L8:
            long token = Binder.clearCallingIdentity();
            DisplayManagerService.m3721$$Nest$msetVirtualDisplaySurfaceInternal(this.this$0, callback.asBinder(), surface);     // Catch: Throwable -> L12
            Binder.restoreCallingIdentity(token);
            return;
        L12:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        L4:
            if (surface.isSingleBuffered() == false) goto L8;
            throw new IllegalArgumentException("Surface can't be single-buffered");
        }

        public void releaseVirtualDisplay(IVirtualDisplayCallback callback) {
            long token = Binder.clearCallingIdentity();
            DisplayManagerService.m3705$$Nest$mreleaseVirtualDisplayInternal(this.this$0, callback.asBinder());     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public void setVirtualDisplayRotation(IVirtualDisplayCallback callback, int rotation) {
            long token = Binder.clearCallingIdentity();
            DisplayManagerService.m3720$$Nest$msetVirtualDisplayRotationInternal(this.this$0, callback.asBinder(), rotation);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
            if (DumpUtils.checkDumpPermission(this.this$0.mContext, DisplayManagerService.TAG, pw) == true) goto L5;
            return;
        L5:
            long token = Binder.clearCallingIdentity();
            DisplayManagerService.m3669$$Nest$mdumpInternal(this.this$0, fd, pw, args);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(token);
            return;
        L9:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public ParceledListSlice<BrightnessChangeEvent> getBrightnessEvents(String callingPackage) {
            getBrightnessEvents_enforcePermission();
            int callingUid = Binder.getCallingUid();
            AppOpsManager appOpsManager = (AppOpsManager) this.this$0.mContext.getSystemService(AppOpsManager.class);
            int mode = appOpsManager.noteOp(43, callingUid, callingPackage);
            boolean hasUsageStats = true;
            if (mode == 3) goto L5;
            if (mode == 0) goto L12;
            hasUsageStats = false;
        L12:
            int userId = UserHandle.getUserId(callingUid);
            long token = Binder.clearCallingIdentity();
            SyncRoot r8 = this.this$0.mSyncRoot;     // Catch: Throwable -> L22
            monitor-enter(r8);     // Catch: Throwable -> L22
            ParceledListSlice<BrightnessChangeEvent> r5 = this.this$0.mDisplayPowerControllers.get(0).getBrightnessEvents(userId, hasUsageStats);     // Catch: Throwable -> L19
            monitor-exit(r8);     // Catch: Throwable -> L19
            Binder.restoreCallingIdentity(token);
            return r5;
        L19:
            th = move-exception;
            throw th;     // Catch: Throwable -> L22
        L22:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        L5:
            if (this.this$0.mContext.checkCallingPermission("android.permission.PACKAGE_USAGE_STATS") == 0) goto L12;
            hasUsageStats = false;
            goto L12
        }

        public ParceledListSlice<AmbientBrightnessDayStats> getAmbientBrightnessStats() {
            getAmbientBrightnessStats_enforcePermission();
            int callingUid = Binder.getCallingUid();
            int userId = UserHandle.getUserId(callingUid);
            long token = Binder.clearCallingIdentity();
            SyncRoot r4 = this.this$0.mSyncRoot;     // Catch: Throwable -> L12
            monitor-enter(r4);     // Catch: Throwable -> L12
            ParceledListSlice<AmbientBrightnessDayStats> r5 = this.this$0.mDisplayPowerControllers.get(0).getAmbientBrightnessStats(userId);     // Catch: Throwable -> L9
            monitor-exit(r4);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(token);
            return r5;
        L9:
            th = move-exception;
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public void setBrightnessConfigurationForUser(final BrightnessConfiguration c, final int userId, final String packageName) {
            setBrightnessConfigurationForUser_enforcePermission();
            if (userId == UserHandle.getCallingUserId()) goto L5;
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS", "Permission required to change the display brightness configuration of another user");
        L5:
            long token = Binder.clearCallingIdentity();
            SyncRoot r2 = this.this$0.mSyncRoot;     // Catch: Throwable -> L15
            monitor-enter(r2);     // Catch: Throwable -> L15
            this.this$0.mLogicalDisplayMapper.forEachLocked(new DisplayManagerService$BinderService$$ExternalSyntheticLambda0(this, c, userId, packageName));     // Catch: Throwable -> L12
            monitor-exit(r2);     // Catch: Throwable -> L12
            Binder.restoreCallingIdentity(token);
            return;
        L12:
            th = move-exception;
            throw th;     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        private /* synthetic */ void lambda$setBrightnessConfigurationForUser$0(BrightnessConfiguration c, int userId, String packageName, LogicalDisplay logicalDisplay) {
            if (logicalDisplay.getDisplayInfoLocked().type == 1) goto L5;
            return;
        L5:
            DisplayDevice displayDevice = logicalDisplay.getPrimaryDisplayDeviceLocked();
            DisplayManagerService.m3716$$Nest$msetBrightnessConfigurationForDisplayInternal(this.this$0, c, displayDevice.getUniqueId(), userId, packageName);
        }

        public void setBrightnessConfigurationForDisplay(BrightnessConfiguration c, String uniqueId, int userId, String packageName) {
            setBrightnessConfigurationForDisplay_enforcePermission();
            if (userId == UserHandle.getCallingUserId()) goto L5;
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS", "Permission required to change the display brightness configuration of another user");
        L5:
            long token = Binder.clearCallingIdentity();
            DisplayManagerService.m3716$$Nest$msetBrightnessConfigurationForDisplayInternal(this.this$0, c, uniqueId, userId, packageName);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(token);
            return;
        L9:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public BrightnessConfiguration getBrightnessConfigurationForDisplay(String uniqueId, int userId) {
            getBrightnessConfigurationForDisplay_enforcePermission();
            if (userId == UserHandle.getCallingUserId()) goto L5;
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS", "Permission required to read the display brightness configuration of another user");
        L5:
            long token = Binder.clearCallingIdentity();
            int userSerial = DisplayManagerService.m3681$$Nest$mgetUserManager(this.this$0).getUserSerialNumber(userId);
            SyncRoot r3 = this.this$0.mSyncRoot;     // Catch: Throwable -> L20
            monitor-enter(r3);     // Catch: Throwable -> L20
            BrightnessConfiguration config = DisplayManagerService.m3672$$Nest$mgetBrightnessConfigForDisplayWithPdsFallbackLocked(this.this$0, uniqueId, userSerial);     // Catch: Throwable -> L13
            if (config != null) goto L15;
            DisplayPowerController dpc = DisplayManagerService.m3677$$Nest$mgetDpcFromUniqueIdLocked(this.this$0, uniqueId);     // Catch: Throwable -> L13
            if (dpc == null) goto L15;
            config = dpc.getDefaultBrightnessConfiguration();     // Catch: Throwable -> L13
        L15:
            monitor-exit(r3);     // Catch: Throwable -> L13
            Binder.restoreCallingIdentity(token);
            return config;
        L13:
            th = move-exception;
            throw th;     // Catch: Throwable -> L20
        L20:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public BrightnessConfiguration getBrightnessConfigurationForUser(int userId) {
            SyncRoot r0 = this.this$0.mSyncRoot;
            monitor-enter(r0);
            DisplayDevice displayDevice = this.this$0.mLogicalDisplayMapper.getDisplayLocked(0).getPrimaryDisplayDeviceLocked();     // Catch: Throwable -> L8
            String uniqueId = displayDevice.getUniqueId();     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return getBrightnessConfigurationForDisplay(uniqueId, userId);
        L8:
            th = move-exception;
            throw th;
        }

        public BrightnessConfiguration getDefaultBrightnessConfiguration() {
            getDefaultBrightnessConfiguration_enforcePermission();
            long token = Binder.clearCallingIdentity();
            SyncRoot r2 = this.this$0.mSyncRoot;     // Catch: Throwable -> L12
            monitor-enter(r2);     // Catch: Throwable -> L12
            BrightnessConfiguration r3 = this.this$0.mDisplayPowerControllers.get(0).getDefaultBrightnessConfiguration();     // Catch: Throwable -> L9
            monitor-exit(r2);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(token);
            return r3;
        L9:
            th = move-exception;
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public BrightnessInfo getBrightnessInfo(int displayId) {
            getBrightnessInfo_enforcePermission();
            long token = Binder.clearCallingIdentity();
            SyncRoot r2 = this.this$0.mSyncRoot;     // Catch: Throwable -> L27
            monitor-enter(r2);     // Catch: Throwable -> L27
            LogicalDisplay display = this.this$0.mLogicalDisplayMapper.getDisplayLocked(displayId, false);     // Catch: Throwable -> L16
            if (display == null) goto L22;
            if (display.isEnabledLocked() == false) goto L22;
            DisplayPowerController dpc = this.this$0.mDisplayPowerControllers.get(displayId);     // Catch: Throwable -> L16
            if (dpc == null) goto L19;
            BrightnessInfo r4 = dpc.getBrightnessInfo();     // Catch: Throwable -> L16
            monitor-exit(r2);     // Catch: Throwable -> L16
            Binder.restoreCallingIdentity(token);
            return r4;
        L19:
            monitor-exit(r2);     // Catch: Throwable -> L16
            Binder.restoreCallingIdentity(token);
            return null;
        L22:
            monitor-exit(r2);     // Catch: Throwable -> L16
            Binder.restoreCallingIdentity(token);
            return null;
        L16:
            th = move-exception;
            throw th;     // Catch: Throwable -> L27
        L27:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public boolean isMinimalPostProcessingRequested(int displayId) {
            SyncRoot r0 = this.this$0.mSyncRoot;
            monitor-enter(r0);
            boolean r1 = this.this$0.mLogicalDisplayMapper.getDisplayLocked(displayId).getRequestedMinimalPostProcessingLocked();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public void setTemporaryBrightness(int displayId, float brightness) {
            setTemporaryBrightness_enforcePermission();
            float brightness2 = DisplayManagerService.m3636$$Nest$fgetmExt(this.this$0).setTemporaryBrightness(displayId, brightness);
            long token = Binder.clearCallingIdentity();
            SyncRoot r2 = this.this$0.mSyncRoot;     // Catch: Throwable -> L12
            monitor-enter(r2);     // Catch: Throwable -> L12
            Settings.System.putFloat(this.this$0.mContext.getContentResolver(), "screen_brightness_temp", brightness2);     // Catch: Throwable -> L9
            this.this$0.mDisplayPowerControllers.get(displayId).setTemporaryBrightness(brightness2);     // Catch: Throwable -> L9
            monitor-exit(r2);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(token);
            return;
        L9:
            th = move-exception;
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public void setBrightness(int displayId, float brightness) {
            setBrightness_enforcePermission();
            if (Float.isNaN(brightness) == false) goto L6;
            Slog.w(DisplayManagerService.TAG, "Attempted to set invalid brightness: " + brightness);
            return;
        L6:
            DisplayManagerService.m3636$$Nest$fgetmExt(this.this$0).setBrightness(displayId, brightness);
            MathUtils.constrain(brightness, 0.0f, 1.0f);
            long token = Binder.clearCallingIdentity();
            SyncRoot r2 = this.this$0.mSyncRoot;     // Catch: Throwable -> L20
            monitor-enter(r2);     // Catch: Throwable -> L20
            DisplayPowerController dpc = this.this$0.mDisplayPowerControllers.get(displayId);     // Catch: Throwable -> L12
            if (dpc == null) goto L14;
            dpc.setBrightness(brightness);     // Catch: Throwable -> L12
        L14:
            this.this$0.mPersistentDataStore.saveIfNeeded();     // Catch: Throwable -> L12
            monitor-exit(r2);     // Catch: Throwable -> L12
            Binder.restoreCallingIdentity(token);
            return;
        L12:
            th = move-exception;
            throw th;     // Catch: Throwable -> L20
        L20:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public float getBrightness(int displayId) {
            getBrightness_enforcePermission();
            float brightness = Float.NaN;
            long token = Binder.clearCallingIdentity();
            SyncRoot r3 = this.this$0.mSyncRoot;     // Catch: Throwable -> L15
            monitor-enter(r3);     // Catch: Throwable -> L15
            DisplayPowerController dpc = this.this$0.mDisplayPowerControllers.get(displayId);     // Catch: Throwable -> L8
            if (dpc == null) goto L10;
            brightness = dpc.getScreenBrightnessSetting();     // Catch: Throwable -> L8
        L10:
            monitor-exit(r3);     // Catch: Throwable -> L8
            Binder.restoreCallingIdentity(token);
            return brightness;
        L8:
            th = move-exception;
            throw th;     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public void setTemporaryAutoBrightnessAdjustment(float adjustment) {
            setTemporaryAutoBrightnessAdjustment_enforcePermission();
            DisplayManagerService.m3636$$Nest$fgetmExt(this.this$0).setTemporaryAutoBrightnessAdjustment(adjustment);
            long token = Binder.clearCallingIdentity();
            SyncRoot r2 = this.this$0.mSyncRoot;     // Catch: Throwable -> L12
            monitor-enter(r2);     // Catch: Throwable -> L12
            this.this$0.mDisplayPowerControllers.get(0).setTemporaryAutoBrightnessAdjustment(adjustment);     // Catch: Throwable -> L9
            monitor-exit(r2);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(token);
            return;
        L9:
            th = move-exception;
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
            new DisplayManagerShellCommand(this.this$0, DisplayManagerService.m3639$$Nest$fgetmFlags(this.this$0)).exec(this, in, out, err, args, callback, resultReceiver);
        }

        public Curve getMinimumBrightnessCurve() {
            long token = Binder.clearCallingIdentity();
            Curve r2 = this.this$0.getMinimumBrightnessCurveInternal();     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public int getPreferredWideGamutColorSpaceId() {
            long token = Binder.clearCallingIdentity();
            int r2 = this.this$0.getPreferredWideGamutColorSpaceIdInternal();     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public void setUserPreferredDisplayMode(int displayId, Display.Mode mode) {
            setUserPreferredDisplayMode_enforcePermission();
            long token = Binder.clearCallingIdentity();
            this.this$0.setUserPreferredDisplayModeInternal(displayId, mode);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public Display.Mode getUserPreferredDisplayMode(int displayId) {
            long token = Binder.clearCallingIdentity();
            Display.Mode r2 = this.this$0.getUserPreferredDisplayModeInternal(displayId);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public Display.Mode getSystemPreferredDisplayMode(int displayId) {
            long token = Binder.clearCallingIdentity();
            Display.Mode r2 = this.this$0.getSystemPreferredDisplayModeInternal(displayId);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public void setHdrConversionMode(HdrConversionMode hdrConversionMode) {
            setHdrConversionMode_enforcePermission();
            if (DisplayManagerService.m3644$$Nest$fgetmIsHdrOutputControlEnabled(this.this$0) == true) goto L5;
            return;
        L5:
            long token = Binder.clearCallingIdentity();
            this.this$0.setHdrConversionModeInternal(hdrConversionMode);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(token);
            return;
        L9:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public HdrConversionMode getHdrConversionModeSetting() {
            if (DisplayManagerService.m3644$$Nest$fgetmIsHdrOutputControlEnabled(this.this$0) == false) goto L5;
            long token = Binder.clearCallingIdentity();
            HdrConversionMode r2 = this.this$0.getHdrConversionModeSettingInternal();     // Catch: Throwable -> L10
            Binder.restoreCallingIdentity(token);
            return r2;
        L10:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        L5:
            return DisplayManagerService.m3730$$Nest$sfgetHDR_CONVERSION_MODE_UNSUPPORTED();
        }

        public HdrConversionMode getHdrConversionMode() {
            if (DisplayManagerService.m3644$$Nest$fgetmIsHdrOutputControlEnabled(this.this$0) == false) goto L5;
            long token = Binder.clearCallingIdentity();
            HdrConversionMode r2 = this.this$0.getHdrConversionModeInternal();     // Catch: Throwable -> L10
            Binder.restoreCallingIdentity(token);
            return r2;
        L10:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        L5:
            return DisplayManagerService.m3730$$Nest$sfgetHDR_CONVERSION_MODE_UNSUPPORTED();
        }

        public int[] getSupportedHdrOutputTypes() {
            if (DisplayManagerService.m3644$$Nest$fgetmIsHdrOutputControlEnabled(this.this$0) == false) goto L5;
            long token = Binder.clearCallingIdentity();
            int[] r2 = DisplayManagerService.m3680$$Nest$mgetSupportedHdrOutputTypesInternal(this.this$0);     // Catch: Throwable -> L10
            Binder.restoreCallingIdentity(token);
            return r2;
        L10:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        L5:
            return DisplayManagerService.m3729$$Nest$sfgetEMPTY_ARRAY();
        }

        public void setShouldAlwaysRespectAppRequestedMode(boolean enabled) {
            setShouldAlwaysRespectAppRequestedMode_enforcePermission();
            long token = Binder.clearCallingIdentity();
            this.this$0.setShouldAlwaysRespectAppRequestedModeInternal(enabled);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public boolean shouldAlwaysRespectAppRequestedMode() {
            shouldAlwaysRespectAppRequestedMode_enforcePermission();
            long token = Binder.clearCallingIdentity();
            boolean r2 = this.this$0.shouldAlwaysRespectAppRequestedModeInternal();     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public void setRefreshRateSwitchingType(int newValue) {
            setRefreshRateSwitchingType_enforcePermission();
            long token = Binder.clearCallingIdentity();
            this.this$0.setRefreshRateSwitchingTypeInternal(newValue);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public int getRefreshRateSwitchingType() {
            long token = Binder.clearCallingIdentity();
            int r2 = this.this$0.getRefreshRateSwitchingTypeInternal();     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public DisplayDecorationSupport getDisplayDecorationSupport(int displayId) {
            long token = Binder.clearCallingIdentity();
            DisplayDecorationSupport r2 = DisplayManagerService.m3674$$Nest$mgetDisplayDecorationSupportInternal(this.this$0, displayId);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public void setDisplayIdToMirror(IBinder token, int displayId) {
            SyncRoot r0 = this.this$0.mSyncRoot;
            monitor-enter(r0);
            LogicalDisplay display = this.this$0.mLogicalDisplayMapper.getDisplayLocked(displayId);     // Catch: Throwable -> L11
            if (DisplayManagerService.m3653$$Nest$fgetmVirtualDisplayAdapter(this.this$0) == null) goto L13;
            VirtualDisplayAdapter r2 = DisplayManagerService.m3653$$Nest$fgetmVirtualDisplayAdapter(this.this$0);     // Catch: Throwable -> L11
            if (display != null) goto L9;
            int r3 = -1;
        L10:
            r2.setDisplayIdToMirror(token, r3);     // Catch: Throwable -> L11
            goto L13
        L9:
            r3 = displayId;
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        }

        public OverlayProperties getOverlaySupport() {
            long token = Binder.clearCallingIdentity();
            OverlayProperties r2 = this.this$0.getOverlaySupportInternal();     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public IBinder getDisplayToken(int displayId) {
            return DisplayManagerService.m3676$$Nest$mgetDisplayTokenInternal(this.this$0, displayId);
        }

        public void enableConnectedDisplay(int displayId) {
            enableConnectedDisplay_enforcePermission();
            this.this$0.enableConnectedDisplay(displayId, true);
        }

        public void disableConnectedDisplay(int displayId) {
            disableConnectedDisplay_enforcePermission();
            this.this$0.enableConnectedDisplay(displayId, false);
        }

        public boolean requestDisplayPower(int displayId, int state) {
            requestDisplayPower_enforcePermission();
            return this.this$0.requestDisplayPower(displayId, state);
        }

        public void requestDisplayModes(IBinder token, int displayId, int[] modeIds) {
            requestDisplayModes_enforcePermission();
            DisplayManagerService.m3631$$Nest$fgetmDisplayModeDirector(this.this$0).requestDisplayModes(token, displayId, modeIds);
        }

        public float getHighestHdrSdrRatio(int displayId) {
            DisplayDeviceConfig ddc = DisplayManagerService.m3628$$Nest$fgetmDisplayDeviceConfigProvider(this.this$0).getDisplayDeviceConfig(displayId);
            if (ddc == null) goto L10;
            if (ddc.getHdrBrightnessData() != null) goto L11;
            return 1.0f;
        L11:
            return ddc.getHdrBrightnessData().highestHdrSdrRatio;
        L10:
            throw new IllegalArgumentException("Display ID does not have a config: " + displayId);
        }

        public void resetDisplayPowerMode() {
            this.this$0.getSmtEx().resetDisplayPowerMode();
        }

        public void setDisplayPowerMode(int mode) {
            this.this$0.getSmtEx().setDisplayPowerMode(mode);
        }

        public float[] getDozeBrightnessSensorValueToBrightness(int displayId) {
            getDozeBrightnessSensorValueToBrightness_enforcePermission();
            DisplayDeviceConfig ddc = DisplayManagerService.m3628$$Nest$fgetmDisplayDeviceConfigProvider(this.this$0).getDisplayDeviceConfig(displayId);
            if (ddc == null) goto L7;
            return ddc.getDozeBrightnessSensorValueToBrightness();
        L7:
            throw new IllegalArgumentException("Display ID does not have a config: " + displayId);
        }

        public float getDefaultDozeBrightness(int displayId) {
            getDefaultDozeBrightness_enforcePermission();
            DisplayDeviceConfig ddc = DisplayManagerService.m3628$$Nest$fgetmDisplayDeviceConfigProvider(this.this$0).getDisplayDeviceConfig(displayId);
            if (ddc == null) goto L7;
            return ddc.getDefaultDozeBrightness();
        L7:
            throw new IllegalArgumentException("Display ID does not have a config for doze-default: " + displayId);
        }

        public DisplayTopology getDisplayTopology() {
            getDisplayTopology_enforcePermission();
            if (DisplayManagerService.m3635$$Nest$fgetmDisplayTopologyCoordinator(this.this$0) != null) goto L7;
            return null;
        L7:
            return DisplayManagerService.m3635$$Nest$fgetmDisplayTopologyCoordinator(this.this$0).getTopology();
        }

        public void setDisplayTopology(DisplayTopology topology) {
            setDisplayTopology_enforcePermission();
            if (DisplayManagerService.m3635$$Nest$fgetmDisplayTopologyCoordinator(this.this$0) == null) goto L6;
            DisplayManagerService.m3635$$Nest$fgetmDisplayTopologyCoordinator(this.this$0).setTopology(topology);
            return;
        }

        public IDisplayManagerExt getIExt() {
            return this.this$0.getIExt();
        }
    }

    private static class BrightnessPair {
        public float brightness;
        public float sdrBrightness;

        BrightnessPair(float brightness, float sdrBrightness) {
            this.brightness = brightness;
            this.sdrBrightness = sdrBrightness;
        }
    }

    private final class CallbackRecord implements IBinder.DeathRecipient, IBinder.FrozenStateChangeCallback {
        DisplayManagerServiceSmtBase.CallbackRecordSmtEx callbackRecordSmtEx;
        private boolean mAlive;
        private boolean mCached;
        private final IDisplayManagerCallback mCallback;
        private boolean mFrozen;
        private AtomicLong mInternalEventFlagsMask;
        private final String mPackageName;
        private ArrayList<Event> mPendingDisplayEvents;
        private DisplayTopology mPendingTopology;
        public final int mPid;
        DisplayManagerServiceSmtBase.CallbackRecordSmtEx mSmtEx;
        public final int mUid;
        public boolean mWifiDisplayScanRequested;
        final /* synthetic */ DisplayManagerService this$0;

        private static final class Event extends Record {
            private final int displayId;
            private final int event;

            private /* synthetic */ boolean $record$equals(Object r3) {
                if ((r3 instanceof Event) == false) goto L10;
                Event r4 = (Event) r3;
                if (this.displayId == r4.displayId) goto L7;
                return false;
            L7:
                if (this.event != r4.event) goto L13;
                return true;
            L13:
                return false;
            L10:
                return false;
            }

            private /* synthetic */ Object[] $record$getFieldsAsObjects() {
                return new Object[]{Integer.valueOf(this.displayId), Integer.valueOf(this.event)};
            }

            /* JADX INFO: renamed from: -$$Nest$fgetdisplayId, reason: not valid java name */
            static /* bridge */ /* synthetic */ int m3735$$Nest$fgetdisplayId(Event r0) {
                return r0.displayId;
            }

            /* JADX INFO: renamed from: -$$Nest$fgetevent, reason: not valid java name */
            static /* bridge */ /* synthetic */ int m3736$$Nest$fgetevent(Event r0) {
                return r0.event;
            }

            /* synthetic */ Event(int r1, int r2, DisplayManagerServiceIA r3) {
                this(r1, r2);
            }

            private Event(int displayId, int event) {
                this.displayId = displayId;
                this.event = event;
            }

            public int displayId() {
                return this.displayId;
            }

            @Override // java.lang.Record
            public final boolean equals(Object o) {
                return $record$equals(o);
            }

            public int event() {
                return this.event;
            }

            @Override // java.lang.Record
            public final int hashCode() {
                return DisplayManagerService$CallbackRecord$Event$$ExternalSyntheticRecord0.m(this.displayId, this.event);
            }

            @Override // java.lang.Record
            public final String toString() {
                return BinaryTransparencyService$Digest$$ExternalSyntheticRecord1.m($record$getFieldsAsObjects(), Event.class, "displayId;event");
            }
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmPackageName, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m3733$$Nest$fgetmPackageName(CallbackRecord r0) {
            return r0.mPackageName;
        }

        /* JADX INFO: renamed from: -$$Nest$mdump, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m3734$$Nest$mdump(CallbackRecord r0) {
            return r0.dump();
        }

        public DisplayManagerServiceSmtBase.CallbackRecordSmtEx getCallbackRecordSmtEx() {
            return this.callbackRecordSmtEx;
        }

        CallbackRecord(DisplayManagerService r5, int pid, int uid, IDisplayManagerCallback callback, long internalEventFlagsMask) {
            this.this$0 = r5;
            this.mPid = pid;
            this.mUid = uid;
            this.mCallback = callback;
            this.mInternalEventFlagsMask = new AtomicLong(internalEventFlagsMask);
            this.mCached = false;
            this.mFrozen = false;
            this.mAlive = true;
            if (DisplayManagerService.m3731$$Nest$smdeferDisplayEventsWhenFrozen() == true) goto L19;
        L13:
            String[] packageNames = r5.mContext.getPackageManager().getPackagesForUid(uid);
            if (packageNames != null) goto L16;
            String r0 = null;
        L17:
            this.mPackageName = r0;
            this.callbackRecordSmtEx = new DisplayManagerServiceSmtBase.CallbackRecordSmtEx(uid, this.mCallback);
            return;
        L16:
            r0 = packageNames[0];
            goto L17
        L19:
            callback.asBinder().addFrozenStateChangeCallback(this);     // Catch: RemoteException -> L6 UnsupportedOperationException -> L8
        L6:
            e = move-exception;
            throw new RuntimeException(e);
        L12:
            Slog.v(DisplayManagerService.TAG, "FrozenStateChangeCallback not supported for pid " + this.mPid);
            goto L13
        }

        public boolean shouldReceiveRefreshRateWithChangeUpdate(int event) {
            if (DisplayManagerService.m3639$$Nest$fgetmFlags(this.this$0).isRefreshRateEventForForegroundAppsEnabled() == true) goto L5;
        L15:
            return true;
        L5:
            if (event != 8) goto L15;
            if (DisplayManagerService.m3622$$Nest$fgetmActivityManagerInternal(this.this$0) == null) goto L15;
            int procState = DisplayManagerService.m3622$$Nest$fgetmActivityManagerInternal(this.this$0).getUidProcessState(this.mUid);
            int importance = ActivityManager.RunningAppProcessInfo.procStateToImportance(procState);
            if (importance > DisplayManagerService.m3645$$Nest$fgetmMaxImportanceForRRCallbacks(this.this$0)) goto L11;
            return true;
        L11:
            if (this.mUid <= 1000) goto L17;
            return false;
        L17:
            return true;
        }

        public void updateEventFlagsMask(long internalEventFlag) {
            this.mInternalEventFlagsMask.set(internalEventFlag);
        }

        private boolean isReadyLocked() {
            if (this.mCached == false) goto L5;
        L7:
            return false;
        L5:
            if (this.mFrozen == true) goto L7;
            return true;
        }

        private boolean hasPendingAndIsReadyLocked() {
            if (this.mPendingDisplayEvents != null) goto L5;
        L7:
            boolean pendingDisplayEvents = false;
        L9:
            if (this.mPendingTopology == null) goto L11;
            boolean pendingTopology = true;
        L13:
            if (isReadyLocked() == false) goto L20;
            if (pendingDisplayEvents == true) goto L17;
            if (pendingTopology == true) goto L17;
            return false;
        L17:
            if (this.mAlive == true) goto L19;
            return false;
        L19:
            return true;
        L20:
            return false;
        L11:
            pendingTopology = false;
            goto L13
        L5:
            if (this.mPendingDisplayEvents.isEmpty() == true) goto L7;
            pendingDisplayEvents = true;
            goto L9
        }

        private boolean setFrozen(boolean frozen) {
            IDisplayManagerCallback r0 = this.mCallback;
            monitor-enter(r0);
            this.mFrozen = frozen;     // Catch: Throwable -> L7
            boolean r1 = hasPendingAndIsReadyLocked();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean setCached(boolean cached) {
            IDisplayManagerCallback r0 = this.mCallback;
            monitor-enter(r0);
            this.mCached = cached;     // Catch: Throwable -> L7
            boolean r1 = hasPendingAndIsReadyLocked();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            IDisplayManagerCallback r0 = this.mCallback;
            monitor-enter(r0);
            this.mAlive = false;     // Catch: Throwable -> L17
            monitor-exit(r0);     // Catch: Throwable -> L17
            if (DisplayManagerService.m3728$$Nest$sfgetDEBUG() == false) goto L10;
        L11:
            Slog.d(DisplayManagerService.TAG, "Display listener for pid " + this.mPid + " died.");
        L13:
            if (Trace.isTagEnabled(131072) == false) goto L15;
            Trace.instant(131072, "displayManagerBinderDied#mPid=" + this.mPid);
        L15:
            DisplayManagerService.m3699$$Nest$monCallbackDied(this.this$0, this);
            return;
        L10:
            if (DisplayManagerService.m3670$$Nest$mextraLogging(this.this$0, this.mPackageName) == false) goto L13;
        L17:
            th = move-exception;
            throw th;
        }

        public void onFrozenStateChanged(IBinder who, int state) {
            if (state != 0) goto L4;
            boolean r0 = true;
        L6:
            if (setFrozen(r0) == false) goto L9;
            Message msg = DisplayManagerService.m3640$$Nest$fgetmHandler(this.this$0).obtainMessage(10, this);
            DisplayManagerService.m3640$$Nest$fgetmHandler(this.this$0).sendMessage(msg);
            return;
        L9:
            return;
        L4:
            r0 = false;
            goto L6
        }

        public boolean notifyDisplayEventAsync(int displayId, int event) {
            if (shouldSendDisplayEvent(event) == true) goto L12;
            if (DisplayManagerService.m3670$$Nest$mextraLogging(this.this$0, this.mPackageName) == false) goto L8;
            Slog.i(DisplayManagerService.TAG, "Not sending displayEvent: " + event + " due to mask:" + this.mInternalEventFlagsMask);
        L8:
            if (Trace.isTagEnabled(131072) == false) goto L10;
            Trace.instant(131072, "notifyDisplayEventAsync#notSendingEvent=" + event + ",mInternalEventFlagsMask=" + this.mInternalEventFlagsMask);
        L10:
            return true;
        L12:
            if (DisplayManagerService.m3731$$Nest$smdeferDisplayEventsWhenFrozen() == false) goto L32;
            IDisplayManagerCallback r0 = this.mCallback;
            monitor-enter(r0);
        L22:
            th = move-exception;
            throw th;
        L16:
            if (isReadyLocked() == true) goto L18;
        L26:
            addDisplayEvent(displayId, event);     // Catch: Throwable -> L22
            monitor-exit(r0);     // Catch: Throwable -> L22
            return true;
        L18:
            if (this.mPendingDisplayEvents != null) goto L20;
        L24:
            monitor-exit(r0);     // Catch: Throwable -> L22
            goto L32
        L20:
            if (this.mPendingDisplayEvents.isEmpty() == true) goto L24;
        L32:
            if (shouldReceiveRefreshRateWithChangeUpdate(event) == true) goto L48;
            return true;
        L48:
        L37:
            ex = move-exception;
            Slog.w(DisplayManagerService.TAG, "Failed to notify process " + this.mPid + " that displays changed, assuming it died.", ex);
            binderDied();
            return false;
        L35:
            if (SysOptBridge.getFactory().getFreezeController().isPidFrozen(this.mPid) == false) goto L41;
            getCallbackRecordSmtEx().notifyDisplayPendingEvent(this.mPid, displayId, event);     // Catch: RemoteException -> L37 FrozenObjectException -> L39
        L42:
            return true;
        L41:
            transmitDisplayEvent(displayId, event);     // Catch: RemoteException -> L37 FrozenObjectException -> L39
            goto L42
        L45:
            getCallbackRecordSmtEx().notifyDisplayPendingEvent(this.mPid, displayId, event);
            return true;
        }

        private void transmitDisplayEvent(int displayId, int event) throws RemoteException {
            this.mCallback.onDisplayEvent(displayId, event);
        }

        private boolean shouldSendDisplayEvent(int event) {
            long mask = this.mInternalEventFlagsMask.get();
            switch(event) {
                case 1: goto L39;
                case 2: goto L35;
                case 3: goto L31;
                case 4: goto L27;
                case 5: goto L23;
                case 6: goto L19;
                case 7: goto L19;
                case 8: goto L15;
                case 9: goto L11;
                case 10: goto L7;
                default: goto L4;
            };
        L4:
            Slog.e(DisplayManagerService.TAG, "Unknown display event " + event);
            return true;
        L7:
            if ((512 & mask) != 0) goto L9;
            return false;
        L9:
            return true;
        L11:
            if ((128 & mask) != 0) goto L13;
            return false;
        L13:
            return true;
        L15:
            if ((64 & mask) != 0) goto L17;
            return false;
        L17:
            return true;
        L19:
            if ((32 & mask) != 0) goto L21;
            return false;
        L21:
            return true;
        L23:
            if ((16 & mask) != 0) goto L25;
            return false;
        L25:
            return true;
        L27:
            if ((8 & mask) != 0) goto L29;
            return false;
        L29:
            return true;
        L31:
            if ((4 & mask) != 0) goto L33;
            return false;
        L33:
            return true;
        L35:
            if ((2 & mask) != 0) goto L37;
            return false;
        L37:
            return true;
        L39:
            if ((1 & mask) != 0) goto L41;
            return false;
        L41:
            return true;
        }

        public DisplayManagerServiceSmtBase.CallbackRecordSmtEx getSmtEx() {
            return this.mSmtEx;
        }

        private void addDisplayEvent(int displayId, int event) {
            if (this.mPendingDisplayEvents != null) goto L6;
            this.mPendingDisplayEvents = new ArrayList();
        L6:
            if (this.mPendingDisplayEvents.isEmpty() == true) goto L15;
            Event last = this.mPendingDisplayEvents.get(this.mPendingDisplayEvents.size() - 1);
            if (Event.m3735$$Nest$fgetdisplayId(last) != displayId) goto L15;
            if (Event.m3736$$Nest$fgetevent(last) != event) goto L15;
            if (DisplayManagerService.m3728$$Nest$sfgetDEBUG() == false) goto L17;
            Slog.d(DisplayManagerService.TAG, "Ignore redundant display event " + displayId + SliceClientPermissions.SliceAuthority.DELIMITER + event + " to " + this.mUid + SliceClientPermissions.SliceAuthority.DELIMITER + this.mPid);
            return;
        L17:
            return;
        L15:
            this.mPendingDisplayEvents.add(new Event(displayId, event, null));
        }

        boolean notifyTopologyUpdateAsync(DisplayTopology topology) {
            if ((this.mInternalEventFlagsMask.get() & 256) != 0) goto L12;
            if (DisplayManagerService.m3670$$Nest$mextraLogging(this.this$0, this.mPackageName) == false) goto L8;
            Slog.i(DisplayManagerService.TAG, "Not sending topology update: " + topology + " due to mask: " + this.mInternalEventFlagsMask);
        L8:
            if (Trace.isTagEnabled(131072) == false) goto L10;
            Trace.instant(131072, "notifyTopologyUpdateAsync#notSendingUpdate=" + topology + ",mInternalEventFlagsMask=" + this.mInternalEventFlagsMask);
        L10:
            return true;
        L12:
            if (DisplayManagerService.m3731$$Nest$smdeferDisplayEventsWhenFrozen() == false) goto L27;
            IDisplayManagerCallback r0 = this.mCallback;
            monitor-enter(r0);
        L20:
            th = move-exception;
            throw th;
        L16:
            if (isReadyLocked() == true) goto L22;
            this.mPendingTopology = topology;     // Catch: Throwable -> L20
            monitor-exit(r0);     // Catch: Throwable -> L20
            return true;
        L22:
            monitor-exit(r0);     // Catch: Throwable -> L20
        L27:
            return transmitTopologyUpdate(topology);
        }

        private boolean transmitTopologyUpdate(DisplayTopology topology) {
            this.mCallback.onTopologyChanged(topology);     // Catch: RemoteException -> L5
            return true;
        L5:
            ex = move-exception;
            Slog.w(DisplayManagerService.TAG, "Failed to notify process " + this.mPid + " that display topology changed, assuming it died.", ex);
            binderDied();
            return false;
        }

        public boolean dispatchPending() {
            Event[] pendingDisplayEvents = null;
            IDisplayManagerCallback r1 = this.mCallback;
            monitor-enter(r1);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.mAlive == true) goto L11;
            monitor-exit(r1);     // Catch: Throwable -> L8
            return true;
        L11:
            if (isReadyLocked() == true) goto L15;
            monitor-exit(r1);     // Catch: Throwable -> L8
            return false;
        L15:
            if (this.mPendingDisplayEvents != null) goto L17;
        L19:
            DisplayTopology pendingTopology = this.mPendingTopology;     // Catch: Throwable -> L8
            this.mPendingTopology = null;     // Catch: Throwable -> L8
            monitor-exit(r1);     // Catch: Throwable -> L8
            if (pendingDisplayEvents == null) goto L35;
            int i = 0;
        L46:
        L28:
            ex = move-exception;
            Slog.w(DisplayManagerService.TAG, "Failed to notify process " + this.mPid + ", assuming it died.", ex);
            binderDied();
            return false;
        L24:
            if (i >= pendingDisplayEvents.length) goto L35;
            Event displayEvent = pendingDisplayEvents[i];     // Catch: RemoteException -> L28
            if (DisplayManagerService.m3728$$Nest$sfgetDEBUG() == false) goto L31;
            Slog.d(DisplayManagerService.TAG, "Send pending display event #" + i + " " + Event.m3735$$Nest$fgetdisplayId(displayEvent) + SliceClientPermissions.SliceAuthority.DELIMITER + Event.m3736$$Nest$fgetevent(displayEvent) + " to " + this.mUid + SliceClientPermissions.SliceAuthority.DELIMITER + this.mPid);     // Catch: RemoteException -> L28
        L31:
            if (shouldReceiveRefreshRateWithChangeUpdate(Event.m3736$$Nest$fgetevent(displayEvent)) == false) goto L34;
            transmitDisplayEvent(Event.m3735$$Nest$fgetdisplayId(displayEvent), Event.m3736$$Nest$fgetevent(displayEvent));     // Catch: RemoteException -> L28
        L34:
            i = i + 1;     // Catch: RemoteException -> L28
        L35:
            if (pendingTopology != null) goto L37;
        L43:
            return true;
        L37:
            if (DisplayManagerService.m3728$$Nest$sfgetDEBUG() == false) goto L39;
            Slog.d(DisplayManagerService.TAG, "Send pending topology: " + pendingTopology + " to " + this.mUid + SliceClientPermissions.SliceAuthority.DELIMITER + this.mPid);     // Catch: RemoteException -> L28
        L39:
            this.mCallback.onTopologyChanged(pendingTopology);     // Catch: RemoteException -> L28
            goto L43
        L17:
            if (this.mPendingDisplayEvents.isEmpty() == true) goto L19;
            pendingDisplayEvents = (Event[]) this.mPendingDisplayEvents.toArray(new Event[this.mPendingDisplayEvents.size()]);     // Catch: Throwable -> L8
            this.mPendingDisplayEvents.clear();     // Catch: Throwable -> L8
            goto L19
        }

        private String dump() {
            if (DisplayManagerService.m3731$$Nest$smdeferDisplayEventsWhenFrozen() == false) goto L20;
            IDisplayManagerCallback r2 = this.mCallback;
            monitor-enter(r2);
            Integer r4 = Integer.valueOf(this.mPid);     // Catch: Throwable -> L16
            Integer r5 = Integer.valueOf(this.mUid);     // Catch: Throwable -> L16
            Boolean r6 = Boolean.valueOf(this.mWifiDisplayScanRequested);     // Catch: Throwable -> L16
            Boolean r7 = Boolean.valueOf(this.mCached);     // Catch: Throwable -> L16
            Boolean r8 = Boolean.valueOf(this.mFrozen);     // Catch: Throwable -> L16
            boolean r9 = false;
            if (this.mPendingDisplayEvents != null) goto L9;
            int r3 = 0;
        L10:
            Integer r10 = Integer.valueOf(r3);     // Catch: Throwable -> L16
            if (this.mPendingTopology == null) goto L13;
            r9 = true;
        L13:
            String r0 = TextUtils.formatSimple("mPid=%d mUid=%d mWifiDisplayScanRequested=%s cached=%s frozen=%s pendingDisplayEvents=%d pendingTopology=%b", new Object[]{r4, r5, r6, r7, r8, r10, Boolean.valueOf(r9)});     // Catch: Throwable -> L16
            monitor-exit(r2);     // Catch: Throwable -> L16
            return r0;
        L9:
            r3 = this.mPendingDisplayEvents.size();     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            throw th;
        L20:
            return TextUtils.formatSimple("mPid=%d mUid=%d mWifiDisplayScanRequested=%s", new Object[]{Integer.valueOf(this.mPid), Integer.valueOf(this.mUid), Boolean.valueOf(this.mWifiDisplayScanRequested)});
        }
    }

    public interface Clock {
        long uptimeMillis();
    }

    class DesiredDisplayModeSpecsObserver implements DisplayModeDirector.DesiredDisplayModeSpecsListener {
        private boolean mChanged;
        private final Consumer<LogicalDisplay> mSpecsChangedConsumer;
        final /* synthetic */ DisplayManagerService this$0;

        public static /* synthetic */ void $r8$lambda$kO7ZAVjumuDiLx2z8mCVaTQeBAM(DesiredDisplayModeSpecsObserver r0, LogicalDisplay r1) {
            r0.lambda$new$0(r1);
        }

        DesiredDisplayModeSpecsObserver(DisplayManagerService this$0) {
            this.this$0 = this$0;
            this.mSpecsChangedConsumer = new DisplayManagerService$DesiredDisplayModeSpecsObserver$$ExternalSyntheticLambda0(this);
            this.mChanged = false;
        }

        private /* synthetic */ void lambda$new$0(LogicalDisplay display) {
            int displayId = display.getDisplayIdLocked();
            DisplayModeDirector.DesiredDisplayModeSpecs desiredDisplayModeSpecs = DisplayManagerService.m3631$$Nest$fgetmDisplayModeDirector(this.this$0).getDesiredDisplayModeSpecs(displayId);
            DisplayModeDirector.DesiredDisplayModeSpecs existingDesiredDisplayModeSpecs = display.getDesiredDisplayModeSpecsLocked();
            if (DisplayManagerService.m3728$$Nest$sfgetDEBUG() == false) goto L6;
            Slog.i(DisplayManagerService.TAG, "Comparing display specs: " + desiredDisplayModeSpecs + ", existing: " + existingDesiredDisplayModeSpecs);
        L6:
            if (desiredDisplayModeSpecs.equals(existingDesiredDisplayModeSpecs) == false) goto L8;
            return;
        L8:
            if (SysOptBridge.getFactory().getDynamicRefreshRateService().shouldInterceptUpdateDisplayModeSpecs(displayId, desiredDisplayModeSpecs) == false) goto L11;
            return;
        L11:
            if (SysOptBridge.getFactory().getDynamicRefreshRateService().isXtsMode() == true) goto L13;
            return;
        L13:
            display.setDesiredDisplayModeSpecsLocked(desiredDisplayModeSpecs);
            this.mChanged = true;
        }

        @Override // com.android.server.display.mode.DisplayModeDirector.DesiredDisplayModeSpecsListener
        public void onDesiredDisplayModeSpecsChanged() {
            SyncRoot r0 = this.this$0.mSyncRoot;
            monitor-enter(r0);
            this.mChanged = false;     // Catch: Throwable -> L8
            this.this$0.mLogicalDisplayMapper.forEachLocked(this.mSpecsChangedConsumer, false);     // Catch: Throwable -> L8
            if (this.mChanged == false) goto L10;
            DisplayManagerService.m3713$$Nest$mscheduleTraversalLocked(this.this$0, false);     // Catch: Throwable -> L8
            this.mChanged = false;     // Catch: Throwable -> L8
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    class DeviceStateListener implements DeviceStateManager.DeviceStateCallback {
        final /* synthetic */ DisplayManagerService this$0;

        DeviceStateListener(DisplayManagerService this$0) {
            this.this$0 = this$0;
        }

        public void onDeviceStateChanged(DeviceState deviceState) {
            SyncRoot r0 = this.this$0.mSyncRoot;
            monitor-enter(r0);
            Message msg = DisplayManagerService.m3640$$Nest$fgetmHandler(this.this$0).obtainMessage(9);     // Catch: Throwable -> L7
            msg.arg1 = deviceState.getIdentifier();     // Catch: Throwable -> L7
            DisplayManagerService.m3640$$Nest$fgetmHandler(this.this$0).sendMessage(msg);     // Catch: Throwable -> L7
            this.this$0.mLogicalDisplayMapper.setDeviceStateLocked(deviceState);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private final class DisplayManagerHandler extends Handler {
        final /* synthetic */ DisplayManagerService this$0;

        public DisplayManagerHandler(DisplayManagerService r2, Looper looper) {
            this.this$0 = r2;
            super(looper, null, true);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 1: goto L40;
                case 2: goto L39;
                case 3: goto L38;
                case 4: goto L37;
                case 5: goto L22;
                case 6: goto L21;
                case 7: goto L8;
                case 8: goto L7;
                case 9: goto L6;
                case 10: goto L5;
                default: goto L58;
            };
        L5:
            DisplayManagerService.m3668$$Nest$mdispatchPendingProcessEvents(this.this$0, msg.obj);
            return;
        L6:
            DisplayManagerService.m3654$$Nest$fgetmWindowManagerInternal(this.this$0).onDisplayManagerReceivedDeviceState(msg.arg1);
            return;
        L7:
            DisplayManagerService.m3666$$Nest$mdeliverDisplayGroupEvent(this.this$0, msg.arg1, msg.arg2);
            return;
        L8:
            SyncRoot r0 = this.this$0.mSyncRoot;
            monitor-enter(r0);
            int displayId = msg.arg1;     // Catch: Throwable -> L14
            LogicalDisplay display = this.this$0.mLogicalDisplayMapper.getDisplayLocked(displayId);     // Catch: Throwable -> L14
            if (display != null) goto L16;
            monitor-exit(r0);     // Catch: Throwable -> L14
        L44:
            return;
        L16:
            ArraySet<Integer> uids = display.getPendingFrameRateOverrideUids();     // Catch: Throwable -> L14
            display.clearPendingFrameRateOverrideUids();     // Catch: Throwable -> L14
            monitor-exit(r0);     // Catch: Throwable -> L14
            DisplayManagerService.m3665$$Nest$mdeliverDisplayEvent(this.this$0, msg.arg1, uids, msg.arg2);
        L14:
            th = move-exception;
            throw th;
        L21:
            DisplayManagerService.m3698$$Nest$mloadBrightnessConfigurations(this.this$0);
            return;
        L22:
            SyncRoot r1 = this.this$0.mSyncRoot;
            monitor-enter(r1);
            boolean changed = !DisplayManagerService.m3650$$Nest$fgetmTempViewports(this.this$0).equals(DisplayManagerService.m3652$$Nest$fgetmViewports(this.this$0));     // Catch: Throwable -> L30
            if (changed == false) goto L32;
            DisplayManagerService.m3650$$Nest$fgetmTempViewports(this.this$0).clear();     // Catch: Throwable -> L30
            Iterator r2 = DisplayManagerService.m3652$$Nest$fgetmViewports(this.this$0).iterator();     // Catch: Throwable -> L30
        L28:
            if (r2.hasNext() == false) goto L32;
            DisplayViewport d = (DisplayViewport) r2.next();     // Catch: Throwable -> L30
            DisplayManagerService.m3650$$Nest$fgetmTempViewports(this.this$0).add(d.makeCopy());     // Catch: Throwable -> L30
        L32:
            monitor-exit(r1);     // Catch: Throwable -> L30
            if (changed == false) goto L53;
            DisplayManagerService.m3641$$Nest$fgetmInputManagerInternal(this.this$0).setDisplayViewports(DisplayManagerService.m3650$$Nest$fgetmTempViewports(this.this$0));
            return;
        L53:
            return;
        L30:
            th = move-exception;
            throw th;
        L37:
            DisplayManagerService.m3654$$Nest$fgetmWindowManagerInternal(this.this$0).requestTraversalFromDisplayManager();
            return;
        L38:
            DisplayManagerService.m3665$$Nest$mdeliverDisplayEvent(this.this$0, msg.arg1, null, msg.arg2);
            return;
        L39:
            DisplayManagerService.m3701$$Nest$mregisterAdditionalDisplayAdapters(this.this$0);
            return;
        L40:
            DisplayManagerService.m3703$$Nest$mregisterDefaultDisplayAdapters(this.this$0);
            return;
        }
    }

    private class ExternalDisplayPolicyInjector implements ExternalDisplayPolicy.Injector {
        final /* synthetic */ DisplayManagerService this$0;

        /* synthetic */ ExternalDisplayPolicyInjector(DisplayManagerService r1, DisplayManagerServiceIA r2) {
            this(r1);
        }

        private ExternalDisplayPolicyInjector(DisplayManagerService r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.display.ExternalDisplayPolicy.Injector
        public void sendExternalDisplayEventLocked(LogicalDisplay display, int event) {
            DisplayManagerService.m3714$$Nest$msendDisplayEventLocked(this.this$0, display, event);
        }

        @Override // com.android.server.display.ExternalDisplayPolicy.Injector
        public IThermalService getThermalService() {
            return IThermalService.Stub.asInterface(ServiceManager.getService("thermalservice"));
        }

        @Override // com.android.server.display.ExternalDisplayPolicy.Injector
        public DisplayManagerFlags getFlags() {
            return DisplayManagerService.m3639$$Nest$fgetmFlags(this.this$0);
        }

        @Override // com.android.server.display.ExternalDisplayPolicy.Injector
        public LogicalDisplayMapper getLogicalDisplayMapper() {
            return this.this$0.mLogicalDisplayMapper;
        }

        @Override // com.android.server.display.ExternalDisplayPolicy.Injector
        public SyncRoot getSyncRoot() {
            return this.this$0.mSyncRoot;
        }

        @Override // com.android.server.display.ExternalDisplayPolicy.Injector
        public DisplayNotificationManager getDisplayNotificationManager() {
            return DisplayManagerService.m3632$$Nest$fgetmDisplayNotificationManager(this.this$0);
        }

        @Override // com.android.server.display.ExternalDisplayPolicy.Injector
        public Handler getHandler() {
            return DisplayManagerService.m3640$$Nest$fgetmHandler(this.this$0);
        }

        @Override // com.android.server.display.ExternalDisplayPolicy.Injector
        public ExternalDisplayStatsService getExternalDisplayStatsService() {
            return DisplayManagerService.m3638$$Nest$fgetmExternalDisplayStatsService(this.this$0);
        }
    }

    static class Injector {
        Injector() {
        }

        VirtualDisplayAdapter getVirtualDisplayAdapter(SyncRoot syncRoot, Context context, Handler handler, DisplayAdapter.Listener displayAdapterListener, DisplayManagerFlags flags) {
            return new VirtualDisplayAdapter(syncRoot, context, handler, displayAdapterListener, flags);
        }

        LocalDisplayAdapter getLocalDisplayAdapter(SyncRoot syncRoot, Context context, Handler handler, DisplayAdapter.Listener displayAdapterListener, DisplayManagerFlags flags, DisplayNotificationManager displayNotificationManager) {
            return new LocalDisplayAdapter(syncRoot, context, handler, displayAdapterListener, flags, displayNotificationManager);
        }

        long getDefaultDisplayDelayTimeout() {
            return 10000;
        }

        int setHdrConversionMode(int conversionMode, int preferredHdrOutputType, int[] allowedHdrOutputTypes) {
            return DisplayControl.setHdrConversionMode(conversionMode, preferredHdrOutputType, allowedHdrOutputTypes);
        }

        int[] getSupportedHdrOutputTypes() {
            return DisplayControl.getSupportedHdrOutputTypes();
        }

        int[] getHdrOutputTypesWithLatency() {
            return DisplayControl.getHdrOutputTypesWithLatency();
        }

        boolean getHdrOutputConversionSupport() {
            return DisplayControl.getHdrOutputConversionSupport();
        }

        IMediaProjectionManager getProjectionService() {
            IBinder b = ServiceManager.getService("media_projection");
            return IMediaProjectionManager.Stub.asInterface(b);
        }

        DisplayManagerFlags getFlags() {
            return new DisplayManagerFlags();
        }

        DisplayPowerController getDisplayPowerController(Context context, DisplayPowerController.Injector injector, DisplayManagerInternal.DisplayPowerCallbacks callbacks, Handler handler, SensorManager sensorManager, DisplayBlanker blanker, LogicalDisplay logicalDisplay, BrightnessTracker brightnessTracker, BrightnessSetting brightnessSetting, Runnable onBrightnessChangeRunnable, HighBrightnessModeMetadata hbmMetadata, boolean bootCompleted, DisplayManagerFlags flags) {
            return new DisplayPowerController(context, injector, callbacks, handler, sensorManager, blanker, logicalDisplay, brightnessTracker, brightnessSetting, onBrightnessChangeRunnable, hbmMetadata, bootCompleted, flags);
        }
    }

    final class LocalService extends DisplayManagerInternal {
        private DisplayManagerServiceSmtEx.LocalServiceSmtEx mInternalSmtEx;
        final /* synthetic */ DisplayManagerService this$0;

        public static /* synthetic */ void $r8$lambda$7A6gWi1htYqOyy6EqSvOFd1fqZM(IntArray r0, LogicalDisplay r1) {
            lambda$getDisplayIds$1(r0, r1);
        }

        public static /* synthetic */ void $r8$lambda$89AgyCQh3snd66tyHFfbP9_BZ4s(LocalService r0, Set r1, IntArray r2, LogicalDisplay r3) {
            r0.lambda$getDisplayGroupIds$0(r1, r2, r3);
        }

        LocalService(DisplayManagerService this$0) {
            this.this$0 = this$0;
            DisplayManagerServiceSmtEx r1 = DisplayManagerService.m3648$$Nest$fgetmSmtEx(this.this$0);
            r1.getClass();
            this.mInternalSmtEx = new DisplayManagerServiceSmtEx.LocalServiceSmtEx(r1);
        }

        public void initPowerManagement(DisplayManagerInternal.DisplayPowerCallbacks callbacks, Handler handler, SensorManager sensorManager) {
            SyncRoot r0 = this.this$0.mSyncRoot;
            monitor-enter(r0);
            DisplayManagerService.m3656$$Nest$fputmDisplayPowerCallbacks(this.this$0, callbacks);     // Catch: Throwable -> L8
            DisplayManagerService.m3660$$Nest$fputmSensorManager(this.this$0, sensorManager);     // Catch: Throwable -> L8
            DisplayManagerService.m3659$$Nest$fputmPowerHandler(this.this$0, handler);     // Catch: Throwable -> L8
            DisplayManagerService.m3696$$Nest$minitializeDisplayPowerControllersLocked(this.this$0);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            DisplayManagerService.m3640$$Nest$fgetmHandler(this.this$0).sendEmptyMessage(6);
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public int createVirtualDisplay(VirtualDisplayConfig config, IVirtualDisplayCallback callback, IVirtualDevice virtualDevice, DisplayWindowPolicyController dwpc, String packageName) {
            return DisplayManagerService.m3664$$Nest$mcreateVirtualDisplayInternal(this.this$0, config, callback, null, virtualDevice, dwpc, packageName);
        }

        public void setScreenBrightnessOverrideFromWindowManager(SparseArray<DisplayManagerInternal.DisplayBrightnessOverrideRequest> brightnessOverrides) {
            SparseArray<DisplayPowerController> dpcs = new SparseArray();
            SyncRoot r1 = this.this$0.mSyncRoot;
            monitor-enter(r1);
            int i = 0;
        L20:
        L8:
            th = move-exception;
            throw th;
        L6:
            if (i >= this.this$0.mDisplayPowerControllers.size()) goto L11;
            dpcs.put(this.this$0.mDisplayPowerControllers.keyAt(i), this.this$0.mDisplayPowerControllers.valueAt(i));     // Catch: Throwable -> L8
            i = i + 1;     // Catch: Throwable -> L8
            goto L20
        L11:
            monitor-exit(r1);     // Catch: Throwable -> L8
            int i2 = 0;
        L14:
            if (i2 >= dpcs.size()) goto L17;
            int displayId = dpcs.keyAt(i2);
            DisplayPowerController dpc = dpcs.valueAt(i2);
            dpc.setBrightnessOverrideRequest(brightnessOverrides.get(displayId));
            i2 = i2 + 1;
            goto L14
        }

        public boolean requestPowerState(int groupId, DisplayManagerInternal.DisplayPowerRequest request, boolean waitForNegativeProximity) {
            SyncRoot r0 = this.this$0.mSyncRoot;
            monitor-enter(r0);
            DisplayGroup displayGroup = this.this$0.mLogicalDisplayMapper.getDisplayGroupLocked(groupId);     // Catch: Throwable -> L9
            if (displayGroup != null) goto L11;
            monitor-exit(r0);     // Catch: Throwable -> L9
            return true;
        L11:
            int size = displayGroup.getSizeLocked();     // Catch: Throwable -> L9
            boolean ready = true;
            int i = 0;
        L12:
            if (i >= size) goto L20;
            int id = displayGroup.getIdLocked(i);     // Catch: Throwable -> L9
            DisplayDevice displayDevice = this.this$0.mLogicalDisplayMapper.getDisplayLocked(id).getPrimaryDisplayDeviceLocked();     // Catch: Throwable -> L9
            int flags = displayDevice.getDisplayDeviceInfoLocked().flags;     // Catch: Throwable -> L9
            if ((flags & 32) != 0) goto L18;
            DisplayPowerController displayPowerController = this.this$0.mDisplayPowerControllers.get(id);     // Catch: Throwable -> L9
            if (displayPowerController == null) goto L18;
            ready = ready & displayPowerController.requestPowerState(request, waitForNegativeProximity);     // Catch: Throwable -> L9
        L18:
            i = i + 1;     // Catch: Throwable -> L9
            goto L12
        L20:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return ready;
        L9:
            th = move-exception;
            throw th;
        }

        public boolean isProximitySensorAvailable(int displayId) {
            SyncRoot r0 = this.this$0.mSyncRoot;
            monitor-enter(r0);
            boolean r1 = this.this$0.mDisplayPowerControllers.get(displayId).isProximitySensorAvailable();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public void registerDisplayGroupListener(DisplayManagerInternal.DisplayGroupListener listener) {
            DisplayManagerService.m3630$$Nest$fgetmDisplayGroupListeners(this.this$0).add(listener);
        }

        public void unregisterDisplayGroupListener(DisplayManagerInternal.DisplayGroupListener listener) {
            DisplayManagerService.m3630$$Nest$fgetmDisplayGroupListeners(this.this$0).remove(listener);
        }

        public ScreenCapture.ScreenshotHardwareBuffer systemScreenshot(int displayId) {
            return DisplayManagerService.m3724$$Nest$msystemScreenshotInternal(this.this$0, displayId);
        }

        public ScreenCapture.ScreenshotHardwareBuffer userScreenshot(int displayId) {
            return DisplayManagerService.m3727$$Nest$muserScreenshotInternal(this.this$0, displayId);
        }

        public DisplayInfo getDisplayInfo(int displayId) {
            return DisplayManagerService.m3675$$Nest$mgetDisplayInfoInternal(this.this$0, displayId, Process.myUid());
        }

        public Set<DisplayInfo> getPossibleDisplayInfo(int displayId) {
            SyncRoot r0 = this.this$0.mSyncRoot;
            monitor-enter(r0);
            Set<DisplayInfo> possibleInfo = new ArraySet();     // Catch: Throwable -> L9
            if (DisplayManagerService.m3627$$Nest$fgetmDeviceStateManager(this.this$0) != null) goto L11;
            Slog.w(DisplayManagerService.TAG, "Can't get supported states since DeviceStateManager not ready");     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return possibleInfo;
        L11:
            int[] supportedStates = DisplayManagerService.m3627$$Nest$fgetmDeviceStateManager(this.this$0).getSupportedStateIdentifiers();     // Catch: Throwable -> L9
            Slog.d(DisplayManagerService.TAG, "supportedStates=" + Arrays.toString(supportedStates));     // Catch: Throwable -> L9
            int r3 = supportedStates.length;     // Catch: Throwable -> L9
            int r4 = 0;
        L12:
            if (r4 >= r3) goto L17;
            int state = supportedStates[r4];     // Catch: Throwable -> L9
            DisplayInfo displayInfo = this.this$0.mLogicalDisplayMapper.getDisplayInfoForStateLocked(state, displayId);     // Catch: Throwable -> L9
            if (displayInfo == null) goto L16;
            possibleInfo.add(displayInfo);     // Catch: Throwable -> L9
        L16:
            r4 = r4 + 1;     // Catch: Throwable -> L9
            goto L12
        L17:
            Slog.d(DisplayManagerService.TAG, "possibleInfos=" + possibleInfo);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return possibleInfo;
        L9:
            th = move-exception;
            throw th;
        }

        public Point getDisplayPosition(int displayId) {
            SyncRoot r0 = this.this$0.mSyncRoot;
            monitor-enter(r0);
            LogicalDisplay display = this.this$0.mLogicalDisplayMapper.getDisplayLocked(displayId);     // Catch: Throwable -> L9
            if (display == null) goto L11;
            Point r2 = display.getDisplayPosition();     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r2;
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return null;
        L9:
            th = move-exception;
            throw th;
        }

        public void registerDisplayTransactionListener(DisplayManagerInternal.DisplayTransactionListener listener) {
            if (listener == null) goto L6;
            DisplayManagerService.m3704$$Nest$mregisterDisplayTransactionListenerInternal(this.this$0, listener);
            return;
        L6:
            throw new IllegalArgumentException("listener must not be null");
        }

        public void unregisterDisplayTransactionListener(DisplayManagerInternal.DisplayTransactionListener listener) {
            if (listener == null) goto L6;
            DisplayManagerService.m3725$$Nest$munregisterDisplayTransactionListenerInternal(this.this$0, listener);
            return;
        L6:
            throw new IllegalArgumentException("listener must not be null");
        }

        public void setDisplayInfoOverrideFromWindowManager(int displayId, DisplayInfo info) {
            this.this$0.setDisplayInfoOverrideFromWindowManagerInternal(displayId, info);
        }

        public void getNonOverrideDisplayInfo(int displayId, DisplayInfo outInfo) {
            DisplayManagerService.m3678$$Nest$mgetNonOverrideDisplayInfoInternal(this.this$0, displayId, outInfo);
        }

        public void performTraversal(SurfaceControl.Transaction t, SparseArray<SurfaceControl.Transaction> displayTransactions) {
            this.this$0.performTraversalInternal(t, displayTransactions);
        }

        public void setDisplayProperties(int displayId, boolean hasContent, float requestedRefreshRate, int requestedMode, float requestedMinRefreshRate, float requestedMaxRefreshRate, boolean requestedMinimalPostProcessing, boolean disableHdrConversion, boolean inTraversal) {
            this.this$0.setDisplayPropertiesInternal(displayId, hasContent, requestedRefreshRate, requestedMode, requestedMinRefreshRate, requestedMaxRefreshRate, requestedMinimalPostProcessing, disableHdrConversion, inTraversal);
        }

        public void setDisplayOffsets(int displayId, int x, int y) {
            DisplayManagerService.m3718$$Nest$msetDisplayOffsetsInternal(this.this$0, displayId, x, y);
        }

        public void setDisplayScalingDisabled(int displayId, boolean disableScaling) {
            DisplayManagerService.m3719$$Nest$msetDisplayScalingDisabledInternal(this.this$0, displayId, disableScaling);
        }

        public void setDisplayAccessUIDs(SparseArray<IntArray> newDisplayAccessUIDs) {
            DisplayManagerService.m3717$$Nest$msetDisplayAccessUIDsInternal(this.this$0, newDisplayAccessUIDs);
        }

        public void persistBrightnessTrackerState() {
            SyncRoot r0 = this.this$0.mSyncRoot;
            monitor-enter(r0);
            this.this$0.mDisplayPowerControllers.get(0).persistBrightnessTrackerState();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void onOverlayChanged() {
            SyncRoot r0 = this.this$0.mSyncRoot;
            monitor-enter(r0);
            DisplayManagerService.m3629$$Nest$fgetmDisplayDeviceRepo(this.this$0).forEachLocked(new DisplayManagerService$LocalService$$ExternalSyntheticLambda2());     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public DisplayedContentSamplingAttributes getDisplayedContentSamplingAttributes(int displayId) {
            return this.this$0.getDisplayedContentSamplingAttributesInternal(displayId);
        }

        public boolean setDisplayedContentSamplingEnabled(int displayId, boolean enable, int componentMask, int maxFrames) {
            return this.this$0.setDisplayedContentSamplingEnabledInternal(displayId, enable, componentMask, maxFrames);
        }

        public DisplayedContentSample getDisplayedContentSample(int displayId, long maxFrames, long timestamp) {
            return this.this$0.getDisplayedContentSampleInternal(displayId, maxFrames, timestamp);
        }

        public void ignoreProximitySensorUntilChanged() {
            this.this$0.mDisplayPowerControllers.get(0).ignoreProximitySensorUntilChanged();
        }

        public int getRefreshRateSwitchingType() {
            return this.this$0.getRefreshRateSwitchingTypeInternal();
        }

        public SurfaceControl.RefreshRateRange getRefreshRateForDisplayAndSensor(int displayId, String sensorName, String sensorType) {
            SyncRoot r0 = this.this$0.mSyncRoot;
            monitor-enter(r0);
            SensorManager sensorManager = DisplayManagerService.m3647$$Nest$fgetmSensorManager(this.this$0);     // Catch: Throwable -> L35
            monitor-exit(r0);     // Catch: Throwable -> L35
            if (sensorManager != null) goto L9;
            return null;
        L9:
            Sensor sensor = SensorUtils.findSensor(sensorManager, sensorType, sensorName, 0);
            if (sensor != null) goto L12;
            return null;
        L12:
            SyncRoot r3 = this.this$0.mSyncRoot;
            monitor-enter(r3);
            LogicalDisplay display = this.this$0.mLogicalDisplayMapper.getDisplayLocked(displayId);     // Catch: Throwable -> L18
            if (display != null) goto L20;
            monitor-exit(r3);     // Catch: Throwable -> L18
            return null;
        L20:
            DisplayDevice device = display.getPrimaryDisplayDeviceLocked();     // Catch: Throwable -> L18
            if (device != null) goto L24;
            monitor-exit(r3);     // Catch: Throwable -> L18
            return null;
        L24:
            DisplayDeviceConfig config = device.getDisplayDeviceConfig();     // Catch: Throwable -> L18
            SensorData sensorData = config.getProximitySensor();     // Catch: Throwable -> L18
            if (sensorData != null) goto L27;
        L31:
            monitor-exit(r3);     // Catch: Throwable -> L18
            return null;
        L27:
            if (sensorData.matches(sensorName, sensorType) == false) goto L31;
            SurfaceControl.RefreshRateRange r1 = new SurfaceControl.RefreshRateRange(sensorData.minRefreshRate, sensorData.maxRefreshRate);     // Catch: Throwable -> L18
            monitor-exit(r3);     // Catch: Throwable -> L18
            return r1;
        L18:
            th = move-exception;
            throw th;
        L35:
            th = move-exception;
            throw th;
        }

        public List<DisplayManagerInternal.RefreshRateLimitation> getRefreshRateLimitations(int displayId) {
            SyncRoot r0 = this.this$0.mSyncRoot;
            monitor-enter(r0);
            DisplayDevice device = DisplayManagerService.m3673$$Nest$mgetDeviceForDisplayLocked(this.this$0, displayId);     // Catch: Throwable -> L9
            if (device != null) goto L11;
            monitor-exit(r0);     // Catch: Throwable -> L9
            return null;
        L11:
            DisplayDeviceConfig config = device.getDisplayDeviceConfig();     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return config.getRefreshRateLimitations();
        L9:
            th = move-exception;
            throw th;
        }

        public void setWindowManagerMirroring(int displayId, boolean isMirroring) {
            SyncRoot r0 = this.this$0.mSyncRoot;
            monitor-enter(r0);
            DisplayDevice device = DisplayManagerService.m3673$$Nest$mgetDeviceForDisplayLocked(this.this$0, displayId);     // Catch: Throwable -> L7
            if (device == null) goto L9;
            device.setWindowManagerMirroringLocked(isMirroring);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public Point getDisplaySurfaceDefaultSize(int displayId) {
            SyncRoot r0 = this.this$0.mSyncRoot;
            monitor-enter(r0);
            DisplayDevice device = DisplayManagerService.m3673$$Nest$mgetDeviceForDisplayLocked(this.this$0, displayId);     // Catch: Throwable -> L9
            if (device != null) goto L11;
            monitor-exit(r0);     // Catch: Throwable -> L9
            return null;
        L11:
            Point r2 = device.getDisplaySurfaceDefaultSizeLocked();     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r2;
        L9:
            th = move-exception;
            throw th;
        }

        public void onEarlyInteractivityChange(boolean interactive) {
            this.this$0.mLogicalDisplayMapper.onEarlyInteractivityChange(interactive);
        }

        public DisplayWindowPolicyController getDisplayWindowPolicyController(int displayId) {
            SyncRoot r0 = this.this$0.mSyncRoot;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.mDisplayWindowPolicyControllers.contains(displayId) == false) goto L11;
            DisplayWindowPolicyController r1 = (DisplayWindowPolicyController) this.this$0.mDisplayWindowPolicyControllers.get(displayId).second;     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r1;
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return null;
        }

        public int getDisplayIdToMirror(int displayId) {
            SyncRoot r0 = this.this$0.mSyncRoot;
            monitor-enter(r0);
            LogicalDisplay display = this.this$0.mLogicalDisplayMapper.getDisplayLocked(displayId);     // Catch: Throwable -> L8
            if (display != null) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return -1;
        L10:
            DisplayDevice displayDevice = display.getPrimaryDisplayDeviceLocked();     // Catch: Throwable -> L8
            boolean ownContent = false;
            if (display.getDevicePositionLocked() != 1) goto L13;
            boolean isRearDisplay = true;
        L15:
            if ((displayDevice.getDisplayDeviceInfoLocked().flags & 128) != 0) goto L17;
            if (isRearDisplay == true) goto L17;
        L18:
            if (ownContent == true) goto L27;
            if (displayDevice.isWindowManagerMirroringLocked() == true) goto L27;
            int displayIdToMirror = displayDevice.getDisplayIdToMirrorLocked();     // Catch: Throwable -> L8
            LogicalDisplay displayToMirror = this.this$0.mLogicalDisplayMapper.getDisplayLocked(displayIdToMirror);     // Catch: Throwable -> L8
            if (displayToMirror != null) goto L25;
            displayIdToMirror = 0;
        L25:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return displayIdToMirror;
        L27:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return -1;
        L17:
            ownContent = true;
            goto L18
        L13:
            isRearDisplay = false;
        L8:
            th = move-exception;
            throw th;
        }

        public SurfaceControl.DisplayPrimaries getDisplayNativePrimaries(int displayId) {
            SyncRoot r0 = this.this$0.mSyncRoot;
            monitor-enter(r0);
            IBinder displayToken = this.this$0.getDisplayToken(displayId);     // Catch: Throwable -> L9
            if (displayToken == null) goto L12;
            monitor-exit(r0);     // Catch: Throwable -> L9
            return SurfaceControl.getDisplayNativePrimaries(displayToken);
        L12:
            throw new IllegalArgumentException("Invalid displayId=" + displayId);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
        }

        public HostUsiVersion getHostUsiVersion(int displayId) {
            SyncRoot r0 = this.this$0.mSyncRoot;
            monitor-enter(r0);
            LogicalDisplay display = this.this$0.mLogicalDisplayMapper.getDisplayLocked(displayId);     // Catch: Throwable -> L9
            if (display != null) goto L11;
            monitor-exit(r0);     // Catch: Throwable -> L9
            return null;
        L11:
            HostUsiVersion r2 = display.getPrimaryDisplayDeviceLocked().getDisplayDeviceConfig().getHostUsiVersion();     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r2;
        L9:
            th = move-exception;
            throw th;
        }

        public DisplayManagerInternal.AmbientLightSensorData getAmbientLightSensorData(int displayId) {
            SyncRoot r0 = this.this$0.mSyncRoot;
            monitor-enter(r0);
            LogicalDisplay display = this.this$0.mLogicalDisplayMapper.getDisplayLocked(displayId);     // Catch: Throwable -> L8
            if (display != null) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return null;
        L10:
            DisplayDevice device = display.getPrimaryDisplayDeviceLocked();     // Catch: Throwable -> L8
            if (device != null) goto L14;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return null;
        L14:
            SensorData data = device.getDisplayDeviceConfig().getAmbientLightSensor();     // Catch: Throwable -> L8
            DisplayManagerInternal.AmbientLightSensorData r4 = new DisplayManagerInternal.AmbientLightSensorData(data.name, data.type);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return r4;
        L8:
            th = move-exception;
            throw th;
        }

        public IntArray getDisplayGroupIds() {
            final Set<Integer> visitedIds = new ArraySet();
            final IntArray displayGroupIds = new IntArray();
            SyncRoot r2 = this.this$0.mSyncRoot;
            monitor-enter(r2);
            this.this$0.mLogicalDisplayMapper.forEachLocked(new DisplayManagerService$LocalService$$ExternalSyntheticLambda0(this, visitedIds, displayGroupIds));     // Catch: Throwable -> L7
            monitor-exit(r2);     // Catch: Throwable -> L7
            return displayGroupIds;
        L7:
            th = move-exception;
            throw th;
        }

        private /* synthetic */ void lambda$getDisplayGroupIds$0(Set visitedIds, IntArray displayGroupIds, LogicalDisplay logicalDisplay) {
            int groupId = this.this$0.mLogicalDisplayMapper.getDisplayGroupIdFromDisplayIdLocked(logicalDisplay.getDisplayIdLocked());
            if (visitedIds.contains(Integer.valueOf(groupId)) == true) goto L6;
            visitedIds.add(Integer.valueOf(groupId));
            displayGroupIds.add(groupId);
            return;
        }

        public int[] getDisplayIdsForGroup(int groupId) {
            SyncRoot r0 = this.this$0.mSyncRoot;
            monitor-enter(r0);
            int[] r1 = this.this$0.mLogicalDisplayMapper.getDisplayIdsForGroupLocked(groupId);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public SparseArray<int[]> getDisplayIdsByGroupsIds() {
            SyncRoot r0 = this.this$0.mSyncRoot;
            monitor-enter(r0);
            SparseArray<int[]> r1 = this.this$0.mLogicalDisplayMapper.getDisplayIdsByGroupIdLocked();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public IntArray getDisplayIds() {
            final IntArray displayIds = new IntArray();
            SyncRoot r1 = this.this$0.mSyncRoot;
            monitor-enter(r1);
            this.this$0.mLogicalDisplayMapper.forEachLocked(new DisplayManagerService$LocalService$$ExternalSyntheticLambda1(displayIds), false);     // Catch: Throwable -> L7
            monitor-exit(r1);     // Catch: Throwable -> L7
            return displayIds;
        L7:
            th = move-exception;
            throw th;
        }

        private static /* synthetic */ void lambda$getDisplayIds$1(IntArray displayIds, LogicalDisplay logicalDisplay) {
            displayIds.add(logicalDisplay.getDisplayIdLocked());
        }

        public int getGroupIdForDisplay(int displayId) {
            SyncRoot r0 = this.this$0.mSyncRoot;
            monitor-enter(r0);
            LogicalDisplay display = this.this$0.mLogicalDisplayMapper.getDisplayLocked(displayId);     // Catch: Throwable -> L9
            if (display != null) goto L11;
            monitor-exit(r0);     // Catch: Throwable -> L9
            return -1;
        L11:
            int r2 = display.getDisplayInfoLocked().displayGroupId;     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r2;
        L9:
            th = move-exception;
            throw th;
        }

        public DisplayManagerInternal.DisplayOffloadSession registerDisplayOffloader(int displayId, DisplayManagerInternal.DisplayOffloader displayOffloader) {
            if (DisplayManagerService.m3639$$Nest$fgetmFlags(this.this$0).isDisplayOffloadEnabled() == true) goto L5;
            return null;
        L5:
            SyncRoot r0 = this.this$0.mSyncRoot;
            monitor-enter(r0);
            LogicalDisplay logicalDisplay = this.this$0.mLogicalDisplayMapper.getDisplayLocked(displayId);     // Catch: Throwable -> L12
            if (logicalDisplay != null) goto L14;
            Slog.w(DisplayManagerService.TAG, "registering DisplayOffloader: LogicalDisplay for displayId=" + displayId + " is not found. No Op.");     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return null;
        L14:
            DisplayPowerController displayPowerController = this.this$0.mDisplayPowerControllers.get(logicalDisplay.getDisplayIdLocked());     // Catch: Throwable -> L12
            if (displayPowerController != null) goto L19;
            Slog.w(DisplayManagerService.TAG, "setting doze state override: DisplayPowerController for displayId=" + displayId + " is unavailable. No Op.");     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return null;
        L19:
            DisplayOffloadSessionImpl session = new DisplayOffloadSessionImpl(displayOffloader, displayPowerController);     // Catch: Throwable -> L12
            logicalDisplay.setDisplayOffloadSessionLocked(session);     // Catch: Throwable -> L12
            displayPowerController.setDisplayOffloadSession(session);     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return session;
        L12:
            th = move-exception;
            throw th;
        }

        public void onPresentation(int displayId, boolean isShown) {
            DisplayManagerService.m3637$$Nest$fgetmExternalDisplayPolicy(this.this$0).onPresentation(displayId, isShown);
        }

        public void stylusGestureStarted(long eventTime) {
            if (DisplayManagerService.m3639$$Nest$fgetmFlags(this.this$0).isBlockAutobrightnessChangesOnStylusUsage() == false) goto L12;
            SyncRoot r0 = this.this$0.mSyncRoot;
            monitor-enter(r0);
            DisplayPowerController displayPowerController = this.this$0.mDisplayPowerControllers.get(0);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            displayPowerController.stylusGestureStarted(eventTime);
            return;
        L9:
            th = move-exception;
            throw th;
        }

        public boolean isDisplayReadyForMirroring(int displayId) {
            return DisplayManagerService.m3637$$Nest$fgetmExternalDisplayPolicy(this.this$0).isDisplayReadyForMirroring(displayId);
        }

        public void onDisplayBelongToTopologyChanged(int displayId, boolean inTopology) {
            if (DisplayManagerService.m3635$$Nest$fgetmDisplayTopologyCoordinator(this.this$0) != null) goto L5;
            return;
        L5:
            if (inTopology == false) goto L11;
            DisplayInfo info = getDisplayInfo(displayId);
            if (info != null) goto L10;
            Slog.w(DisplayManagerService.TAG, "onDisplayBelongToTopologyChanged: cancelled displayId=" + displayId + " info=null");
            return;
        L10:
            DisplayManagerService.m3635$$Nest$fgetmDisplayTopologyCoordinator(this.this$0).onDisplayAdded(info);
            return;
        L11:
            DisplayManagerService.m3635$$Nest$fgetmDisplayTopologyCoordinator(this.this$0).onDisplayRemoved(displayId);
        }

        public void reloadTopologies(int userId) {
            if (userId != DisplayManagerService.m3626$$Nest$fgetmCurrentUserId(this.this$0)) goto L6;
            DisplayManagerService.m3712$$Nest$mscheduleTopologiesReload(this.this$0, DisplayManagerService.m3626$$Nest$fgetmCurrentUserId(this.this$0), false);
            return;
        }

        public DisplayManagerInternalSmtEx getISmtEx() {
            return this.mInternalSmtEx;
        }

        public ExtDisplayManagerInternal getInternalExt() {
            return DisplayManagerService.m3636$$Nest$fgetmExt(this.this$0).getLocalService();
        }
    }

    private final class LogicalDisplayListener implements LogicalDisplayMapper.Listener {
        final /* synthetic */ DisplayManagerService this$0;

        /* synthetic */ LogicalDisplayListener(DisplayManagerService r1, DisplayManagerServiceIA r2) {
            this(r1);
        }

        private LogicalDisplayListener(DisplayManagerService r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.display.LogicalDisplayMapper.Listener
        public void onLogicalDisplayEventLocked(LogicalDisplay display, int event) {
            switch(event) {
                case 1: goto L15;
                case 2: goto L14;
                case 4: goto L13;
                case 8: goto L12;
                case 16: goto L11;
                case 32: goto L10;
                case 64: goto L9;
                case 128: goto L8;
                case 256: goto L7;
                case 512: goto L6;
                case 1024: goto L5;
                case 2048: goto L4;
                default: goto L28;
            };
        L4:
            DisplayManagerService.m3685$$Nest$mhandleLogicalDisplayCommittedStateChangedLocked(this.this$0, display);
            return;
        L5:
            DisplayManagerService.m3693$$Nest$mhandleLogicalDisplayStateChangedLocked(this.this$0, display);
            return;
        L6:
            DisplayManagerService.m3691$$Nest$mhandleLogicalDisplayRefreshRateChangedLocked(this.this$0, display);
            return;
        L7:
            DisplayManagerService.m3688$$Nest$mhandleLogicalDisplayDisconnectedLocked(this.this$0, display);
            return;
        L8:
            DisplayManagerService.m3686$$Nest$mhandleLogicalDisplayConnectedLocked(this.this$0, display);
            return;
        L9:
            DisplayManagerService.m3690$$Nest$mhandleLogicalDisplayHdrSdrRatioChangedLocked(this.this$0, display);
            return;
        L10:
            DisplayManagerService.m3687$$Nest$mhandleLogicalDisplayDeviceStateTransitionLocked(this.this$0, display);
            return;
        L11:
            DisplayManagerService.m3689$$Nest$mhandleLogicalDisplayFrameRateOverridesChangedLocked(this.this$0, display);
            return;
        L12:
            DisplayManagerService.m3694$$Nest$mhandleLogicalDisplaySwappedLocked(this.this$0, display);
            return;
        L13:
            DisplayManagerService.m3692$$Nest$mhandleLogicalDisplayRemovedLocked(this.this$0, display);
            return;
        L14:
            DisplayManagerService.m3684$$Nest$mhandleLogicalDisplayChangedLocked(this.this$0, display);
            return;
        L15:
            DisplayManagerService.m3683$$Nest$mhandleLogicalDisplayAddedLocked(this.this$0, display);
            return;
        }

        @Override // com.android.server.display.LogicalDisplayMapper.Listener
        public void onDisplayGroupEventLocked(int groupId, int event) {
            DisplayManagerService.m3715$$Nest$msendDisplayGroupEvent(this.this$0, groupId, event);
        }

        @Override // com.android.server.display.LogicalDisplayMapper.Listener
        public void onTraversalRequested() {
            SyncRoot r0 = this.this$0.mSyncRoot;
            monitor-enter(r0);
            DisplayManagerService.m3713$$Nest$mscheduleTraversalLocked(this.this$0, false);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private static final class PendingCallback {
        private final CallbackRecord mCallbackRecord;
        private final ArrayList<Pair<Integer, Integer>> mDisplayEvents;

        PendingCallback(CallbackRecord cr, int displayId, int event) {
            this.mCallbackRecord = cr;
            this.mDisplayEvents = new ArrayList();
            this.mDisplayEvents.add(new Pair(Integer.valueOf(displayId), Integer.valueOf(event)));
        }

        public void addDisplayEvent(int displayId, int event) {
            Pair<Integer, Integer> last = this.mDisplayEvents.get(this.mDisplayEvents.size() - 1);
            if (((Integer) last.first).intValue() == displayId) goto L5;
        L10:
            this.mDisplayEvents.add(new Pair(Integer.valueOf(displayId), Integer.valueOf(event)));
            return;
        L5:
            if (((Integer) last.second).intValue() != event) goto L10;
            if (DisplayManagerService.m3728$$Nest$sfgetDEBUG() == false) goto L12;
            Slog.d(DisplayManagerService.TAG, "Ignore redundant display event " + displayId + SliceClientPermissions.SliceAuthority.DELIMITER + event + " to " + this.mCallbackRecord.mUid + SliceClientPermissions.SliceAuthority.DELIMITER + this.mCallbackRecord.mPid);
            return;
        }

        public void sendPendingDisplayEvent() {
            int i = 0;
        L4:
            if (i >= this.mDisplayEvents.size()) goto L12;
            Pair<Integer, Integer> displayEvent = this.mDisplayEvents.get(i);
            if (DisplayManagerService.m3728$$Nest$sfgetDEBUG() == false) goto L9;
            Slog.d(DisplayManagerService.TAG, "Send pending display event #" + i + " " + displayEvent.first + SliceClientPermissions.SliceAuthority.DELIMITER + displayEvent.second + " to " + this.mCallbackRecord.mUid + SliceClientPermissions.SliceAuthority.DELIMITER + this.mCallbackRecord.mPid);
        L9:
            if (this.mCallbackRecord.notifyDisplayEventAsync(((Integer) displayEvent.first).intValue(), ((Integer) displayEvent.second).intValue()) == false) goto L10;
            i = i + 1;
            goto L4
        L10:
            Slog.d(DisplayManagerService.TAG, "Drop pending events for dead process " + this.mCallbackRecord.mPid);
        L12:
            this.mDisplayEvents.clear();
        }
    }

    private class SettingsObserver extends ContentObserver {
        final /* synthetic */ DisplayManagerService this$0;

        SettingsObserver(DisplayManagerService r4) {
            this.this$0 = r4;
            super(DisplayManagerService.m3640$$Nest$fgetmHandler(r4));
            r4.mContext.getContentResolver().registerContentObserver(Settings.Secure.getUriFor("minimal_post_processing_allowed"), false, this);
            if (DisplayManagerService.m3639$$Nest$fgetmFlags(r4).isDisplayContentModeManagementEnabled() == false) goto L6;
            r4.mContext.getContentResolver().registerContentObserver(Settings.Secure.getUriFor("mirror_built_in_display"), false, this, -1);
            return;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri) {
            if (Settings.Secure.getUriFor("minimal_post_processing_allowed").equals(uri) == false) goto L7;
            DisplayManagerService.m3695$$Nest$mhandleMinimalPostProcessingAllowedSettingChange(this.this$0);
            return;
        L7:
            if (Settings.Secure.getUriFor("mirror_built_in_display").equals(uri) == false) goto L19;
            SyncRoot r0 = this.this$0.mSyncRoot;
            monitor-enter(r0);
        L13:
            th = move-exception;
            throw th;
        L11:
            if (DisplayManagerService.m3639$$Nest$fgetmFlags(this.this$0).isDisplayContentModeManagementEnabled() == false) goto L15;
            DisplayManagerService.m3726$$Nest$mupdateMirrorBuiltInDisplaySettingLocked(this.this$0, true);     // Catch: Throwable -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L13
            return;
        }
    }

    public static final class SyncRoot {
        public SyncRoot() {
        }
    }

    private class UidImportanceListener implements ActivityManager.OnUidImportanceListener {
        final /* synthetic */ DisplayManagerService this$0;

        /* synthetic */ UidImportanceListener(DisplayManagerService r1, DisplayManagerServiceIA r2) {
            this(r1);
        }

        private UidImportanceListener(DisplayManagerService r1) {
            this.this$0 = r1;
        }

        public void onUidImportance(int uid, int importance) {
            if (DisplayManagerService.m3731$$Nest$smdeferDisplayEventsWhenFrozen() == false) goto L5;
            onUidImportanceFlagged(uid, importance);
            return;
        L5:
            onUidImportanceUnflagged(uid, importance);
        }

        private void onUidImportanceUnflagged(int uid, int importance) {
            SparseArray r0 = DisplayManagerService.m3646$$Nest$fgetmPendingCallbackSelfLocked(this.this$0);
            monitor-enter(r0);
            if (importance < 1000) goto L12;
            Slog.d(DisplayManagerService.TAG, "Drop pending events for gone uid " + uid);     // Catch: Throwable -> L9
            DisplayManagerService.m3646$$Nest$fgetmPendingCallbackSelfLocked(this.this$0).delete(uid);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L12:
            if (importance < 400) goto L15;
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L15:
            SparseArray<PendingCallback> pendingCallbacks = (SparseArray) DisplayManagerService.m3646$$Nest$fgetmPendingCallbackSelfLocked(this.this$0).get(uid);     // Catch: Throwable -> L9
            if (pendingCallbacks != null) goto L20;
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L20:
            if (DisplayManagerService.m3728$$Nest$sfgetDEBUG() == false) goto L22;
            Slog.d(DisplayManagerService.TAG, "Uid " + uid + " becomes " + importance);     // Catch: Throwable -> L9
        L22:
            int i = 0;
        L24:
            if (i >= pendingCallbacks.size()) goto L29;
            PendingCallback pendingCallback = pendingCallbacks.valueAt(i);     // Catch: Throwable -> L9
            if (pendingCallback == null) goto L28;
            pendingCallback.sendPendingDisplayEvent();     // Catch: Throwable -> L9
        L28:
            i = i + 1;     // Catch: Throwable -> L9
            goto L24
        L29:
            DisplayManagerService.m3646$$Nest$fgetmPendingCallbackSelfLocked(this.this$0).delete(uid);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }

        private void onUidImportanceFlagged(int uid, int importance) {
            if (importance < 400) goto L5;
            boolean cached = true;
        L6:
            List<CallbackRecord> readyCallbackRecords = null;
            SyncRoot r2 = this.this$0.mSyncRoot;
            monitor-enter(r2);
            SparseArray<CallbackRecord> procs = (SparseArray) DisplayManagerService.m3624$$Nest$fgetmCallbackRecordByPidByUid(this.this$0).get(uid);     // Catch: Throwable -> L12
            if (procs != null) goto L14;
            monitor-exit(r2);     // Catch: Throwable -> L12
            return;
        L14:
            if (cached == false) goto L16;
            setCachedLocked(procs);     // Catch: Throwable -> L12
        L17:
            monitor-exit(r2);     // Catch: Throwable -> L12
            if (readyCallbackRecords == null) goto L23;
            int i = 0;
        L21:
            if (i >= readyCallbackRecords.size()) goto L28;
            readyCallbackRecords.get(i).dispatchPending();
            i = i + 1;
            goto L21
        L28:
            return;
        L23:
            return;
        L16:
            readyCallbackRecords = setUncachedLocked(procs);     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        L5:
            cached = false;
            goto L6
        }

        private void setCachedLocked(SparseArray<CallbackRecord> procs) {
            int i = 0;
        L4:
            if (i >= procs.size()) goto L10;
            CallbackRecord cb = procs.valueAt(i);
            if (cb == null) goto L8;
            cb.setCached(true);
        L8:
            i = i + 1;
            goto L4
        }

        private List<CallbackRecord> setUncachedLocked(SparseArray<CallbackRecord> procs) {
            ArrayList<CallbackRecord> ready = null;
            int i = 0;
        L4:
            if (i >= procs.size()) goto L14;
            CallbackRecord cb = procs.valueAt(i);
            if (cb == null) goto L12;
            if (cb.setCached(false) == false) goto L12;
            if (ready != null) goto L11;
            ready = new ArrayList();
        L11:
            ready.add(cb);
        L12:
            i = i + 1;
            goto L4
        L14:
            return ready;
        }
    }

    public static /* synthetic */ boolean $r8$lambda$0fXX8iUX_rY84S1y1UduidrCOrU(DisplayManagerService r0) {
        return r0.isExtendedDisplayAllowed();
    }

    public static /* synthetic */ void $r8$lambda$1SrkwfatqESyJ_JWb6ssCgzMA7I(DisplayManagerService r0, Pair r1) {
        r0.lambda$new$1(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$6Gij3N-B-SUZcArdH0FboFrxccI, reason: not valid java name */
    public static /* synthetic */ void m3614$r8$lambda$6Gij3NBSUZcArdH0FboFrxccI(DisplayManagerService r0, IVirtualDevice r1, int r2) {
        r0.lambda$releaseDisplayAndEmitEvent$12(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$71CSgDqj86QmptsnexgnPo5V9g4(DisplayManagerService r0, LogicalDisplay r1) {
        r0.lambda$setHdrConversionModeInternal$14(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$7OQbYtqG6Tk2ldzHqpLicX-mmjA, reason: not valid java name */
    public static /* synthetic */ void m3615$r8$lambda$7OQbYtqG6Tk2ldzHqpLicXmmjA(DisplayManagerService r0, LogicalDisplay r1) {
        r0.lambda$addDisplayPowerControllerLocked$20(r1);
    }

    public static /* synthetic */ void $r8$lambda$7tf03ubRkuiB1CrexudQIua9rcw(DisplayManagerService r0, LogicalDisplay r1) {
        r0.configurePreferredDisplayModeLocked(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$C8ulw1ylB17r_uD8s-LLxamy8DE, reason: not valid java name */
    public static /* synthetic */ DisplayPowerController m3616$r8$lambda$C8ulw1ylB17r_uD8sLLxamy8DE(DisplayManagerService r0, LogicalDisplay r1) {
        return r0.addDisplayPowerControllerLocked(r1);
    }

    public static /* synthetic */ void $r8$lambda$HAv8n8VFs_kzMCFZ3UWEaPTkowM(DisplayManagerService r0, SparseArray r1, SurfaceControl.Transaction r2, LogicalDisplay r3) {
        r0.lambda$performTraversalLocked$17(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$S-0lZ3Ovw_PpPtGNFvpJrEaatkA, reason: not valid java name */
    public static /* synthetic */ void m3617$r8$lambda$S0lZ3Ovw_PpPtGNFvpJrEaatkA(DisplayManagerService r0, boolean r1, LogicalDisplay r2) {
        r0.lambda$updateMirrorBuiltInDisplaySettingLocked$5(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$SNMIAZ1ahEM7dHu9MfA8VePVi1g(DisplayManagerService r0, int r1, LogicalDisplay r2) {
        r0.lambda$setupLogicalDisplay$11(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$YAUq67kGOGHfANFkWxGTkaN2nAE(DisplayManagerService r0, int[] r1, LogicalDisplay r2) {
        r0.lambda$setUserDisabledHdrTypesInternal$9(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$Z9ZL2XiZg52uSVZn7zV5DNQqPwQ(PrintWriter r0, IndentingPrintWriter r1, DisplayDevice r2) {
        lambda$dumpInternal$19(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$a2m5VLQI08hu-HH-XdGHX48kqrY, reason: not valid java name */
    public static /* synthetic */ void m3618$r8$lambda$a2m5VLQI08huHHXdGHX48kqrY(DisplayManagerService r0, int r1, boolean r2) {
        r0.lambda$scheduleTopologiesReload$4(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$btg3TT_pnQb_grtqfGxiyMM3vGE(DisplayManagerService r0, DeviceConfig.Properties r1) {
        r0.lambda$systemReady$3(r1);
    }

    public static /* synthetic */ void $r8$lambda$cgUZZdTIWEYm2EQf5qvR2AVS1w0(DisplayManagerService r0, LogicalDisplay r1) {
        r0.lambda$updateUserDisabledHdrTypesFromSettingsLocked$6(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$frT8zKQw5t96b-f10Yc_5-FXzSc, reason: not valid java name */
    public static /* synthetic */ DisplayDeviceConfig m3619$r8$lambda$frT8zKQw5t96bf10Yc_5FXzSc(DisplayManagerService r0, int r1) {
        return r0.lambda$new$0(r1);
    }

    public static /* synthetic */ void $r8$lambda$hBTUT3UDB_2sPbaklyw00FsU4Mc(Display.Mode r0, DisplayDevice r1) {
        lambda$storeModeInGlobalSettingsLocked$13(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$jmqWT4-7zs5HqXmY8s4L_0qCl7A, reason: not valid java name */
    public static /* synthetic */ void m3620$r8$lambda$jmqWT47zs5HqXmY8s4L_0qCl7A(DisplayManagerService r0, int[] r1, LogicalDisplay r2) {
        r0.lambda$setAreUserDisabledHdrTypesAllowedInternal$10(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$qmGxA-8o6dAHD3gta4dRl2HTFh0, reason: not valid java name */
    public static /* synthetic */ void m3621$r8$lambda$qmGxA8o6dAHD3gta4dRl2HTFh0(DisplayManagerService r0, LogicalDisplay r1) {
        r0.lambda$setHdrConversionModeInternal$15(r1);
    }

    public static /* synthetic */ void $r8$lambda$rWPa9Gty44mMztfIyVoWpUh707s(DisplayManagerService r0, boolean r1, int r2, int r3, LogicalDisplay r4) {
        r0.lambda$onUserSwitching$2(r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$t3UiRTtymD3hz1236N9Etgy1YHk(DisplayManagerService r0, int r1, LogicalDisplay r2) {
        r0.lambda$loadBrightnessConfigurations$16(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$u9WbOobfozSt4rW76oGp4girVhQ(DisplayManagerService r0, LogicalDisplay r1) {
        r0.lambda$updateUserPreferredDisplayModeSettingsLocked$8(r1);
    }

    public static /* synthetic */ void $r8$lambda$xWVqvP37BqO86Qrr9Moldbym6Lg(Display.Mode r0, DisplayDevice r1) {
        lambda$updateUserPreferredDisplayModeSettingsLocked$7(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$z6YviaqX8IUb3XD_3tVFt7oPWNo(DisplayManagerService r0, LogicalDisplay r1) {
        r0.lambda$resetBrightnessConfigurations$18(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActivityManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityManagerInternal m3622$$Nest$fgetmActivityManagerInternal(DisplayManagerService r0) {
        return r0.mActivityManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAreUserDisabledHdrTypesAllowed, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3623$$Nest$fgetmAreUserDisabledHdrTypesAllowed(DisplayManagerService r0) {
        return r0.mAreUserDisabledHdrTypesAllowed;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCallbackRecordByPidByUid, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m3624$$Nest$fgetmCallbackRecordByPidByUid(DisplayManagerService r0) {
        return r0.mCallbackRecordByPidByUid;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmComposerServiceProcessId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m3625$$Nest$fgetmComposerServiceProcessId(DisplayManagerService r0) {
        return r0.mComposerServiceProcessId;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCurrentUserId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m3626$$Nest$fgetmCurrentUserId(DisplayManagerService r0) {
        return r0.mCurrentUserId;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDeviceStateManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ DeviceStateManagerInternal m3627$$Nest$fgetmDeviceStateManager(DisplayManagerService r0) {
        return r0.mDeviceStateManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDisplayDeviceConfigProvider, reason: not valid java name */
    static /* bridge */ /* synthetic */ DisplayModeDirector.DisplayDeviceConfigProvider m3628$$Nest$fgetmDisplayDeviceConfigProvider(DisplayManagerService r0) {
        return r0.mDisplayDeviceConfigProvider;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDisplayDeviceRepo, reason: not valid java name */
    static /* bridge */ /* synthetic */ DisplayDeviceRepository m3629$$Nest$fgetmDisplayDeviceRepo(DisplayManagerService r0) {
        return r0.mDisplayDeviceRepo;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDisplayGroupListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ CopyOnWriteArrayList m3630$$Nest$fgetmDisplayGroupListeners(DisplayManagerService r0) {
        return r0.mDisplayGroupListeners;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDisplayModeDirector, reason: not valid java name */
    static /* bridge */ /* synthetic */ DisplayModeDirector m3631$$Nest$fgetmDisplayModeDirector(DisplayManagerService r0) {
        return r0.mDisplayModeDirector;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDisplayNotificationManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ DisplayNotificationManager m3632$$Nest$fgetmDisplayNotificationManager(DisplayManagerService r0) {
        return r0.mDisplayNotificationManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDisplayPowerCallbacks, reason: not valid java name */
    static /* bridge */ /* synthetic */ DisplayManagerInternal.DisplayPowerCallbacks m3633$$Nest$fgetmDisplayPowerCallbacks(DisplayManagerService r0) {
        return r0.mDisplayPowerCallbacks;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDisplayStates, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseIntArray m3634$$Nest$fgetmDisplayStates(DisplayManagerService r0) {
        return r0.mDisplayStates;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDisplayTopologyCoordinator, reason: not valid java name */
    static /* bridge */ /* synthetic */ DisplayTopologyCoordinator m3635$$Nest$fgetmDisplayTopologyCoordinator(DisplayManagerService r0) {
        return r0.mDisplayTopologyCoordinator;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmExt, reason: not valid java name */
    static /* bridge */ /* synthetic */ IExtDisplayManagerService m3636$$Nest$fgetmExt(DisplayManagerService r0) {
        return r0.mExt;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmExternalDisplayPolicy, reason: not valid java name */
    static /* bridge */ /* synthetic */ ExternalDisplayPolicy m3637$$Nest$fgetmExternalDisplayPolicy(DisplayManagerService r0) {
        return r0.mExternalDisplayPolicy;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmExternalDisplayStatsService, reason: not valid java name */
    static /* bridge */ /* synthetic */ ExternalDisplayStatsService m3638$$Nest$fgetmExternalDisplayStatsService(DisplayManagerService r0) {
        return r0.mExternalDisplayStatsService;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFlags, reason: not valid java name */
    static /* bridge */ /* synthetic */ DisplayManagerFlags m3639$$Nest$fgetmFlags(DisplayManagerService r0) {
        return r0.mFlags;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ DisplayManagerHandler m3640$$Nest$fgetmHandler(DisplayManagerService r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInputManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ InputManagerInternal m3641$$Nest$fgetmInputManagerInternal(DisplayManagerService r0) {
        return r0.mInputManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsDocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3642$$Nest$fgetmIsDocked(DisplayManagerService r0) {
        return r0.mIsDocked;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsDreaming, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3643$$Nest$fgetmIsDreaming(DisplayManagerService r0) {
        return r0.mIsDreaming;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsHdrOutputControlEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3644$$Nest$fgetmIsHdrOutputControlEnabled(DisplayManagerService r0) {
        return r0.mIsHdrOutputControlEnabled;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMaxImportanceForRRCallbacks, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m3645$$Nest$fgetmMaxImportanceForRRCallbacks(DisplayManagerService r0) {
        return r0.mMaxImportanceForRRCallbacks;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPendingCallbackSelfLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m3646$$Nest$fgetmPendingCallbackSelfLocked(DisplayManagerService r0) {
        return r0.mPendingCallbackSelfLocked;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSensorManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ SensorManager m3647$$Nest$fgetmSensorManager(DisplayManagerService r0) {
        return r0.mSensorManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSmtEx, reason: not valid java name */
    static /* bridge */ /* synthetic */ DisplayManagerServiceSmtEx m3648$$Nest$fgetmSmtEx(DisplayManagerService r0) {
        return r0.mSmtEx;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSurfaceFlingerProcessId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m3649$$Nest$fgetmSurfaceFlingerProcessId(DisplayManagerService r0) {
        return r0.mSurfaceFlingerProcessId;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTempViewports, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m3650$$Nest$fgetmTempViewports(DisplayManagerService r0) {
        return r0.mTempViewports;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserDisabledHdrTypes, reason: not valid java name */
    static /* bridge */ /* synthetic */ int[] m3651$$Nest$fgetmUserDisabledHdrTypes(DisplayManagerService r0) {
        return r0.mUserDisabledHdrTypes;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmViewports, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m3652$$Nest$fgetmViewports(DisplayManagerService r0) {
        return r0.mViewports;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVirtualDisplayAdapter, reason: not valid java name */
    static /* bridge */ /* synthetic */ VirtualDisplayAdapter m3653$$Nest$fgetmVirtualDisplayAdapter(DisplayManagerService r0) {
        return r0.mVirtualDisplayAdapter;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWindowManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ WindowManagerInternal m3654$$Nest$fgetmWindowManagerInternal(DisplayManagerService r0) {
        return r0.mWindowManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmComposerServiceProcessId, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3655$$Nest$fputmComposerServiceProcessId(DisplayManagerService r0, int r1) {
        r0.mComposerServiceProcessId = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmDisplayPowerCallbacks, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3656$$Nest$fputmDisplayPowerCallbacks(DisplayManagerService r0, DisplayManagerInternal.DisplayPowerCallbacks r1) {
        r0.mDisplayPowerCallbacks = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsDocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3657$$Nest$fputmIsDocked(DisplayManagerService r0, boolean r1) {
        r0.mIsDocked = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsDreaming, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3658$$Nest$fputmIsDreaming(DisplayManagerService r0, boolean r1) {
        r0.mIsDreaming = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmPowerHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3659$$Nest$fputmPowerHandler(DisplayManagerService r0, Handler r1) {
        r0.mPowerHandler = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmSensorManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3660$$Nest$fputmSensorManager(DisplayManagerService r0, SensorManager r1) {
        r0.mSensorManager = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmSurfaceFlingerProcessId, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3661$$Nest$fputmSurfaceFlingerProcessId(DisplayManagerService r0, int r1) {
        r0.mSurfaceFlingerProcessId = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$maddDisplayProcessesToMemPoolSession, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3662$$Nest$maddDisplayProcessesToMemPoolSession(DisplayManagerService r0, int r1, int r2) {
        r0.addDisplayProcessesToMemPoolSession(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mconnectWifiDisplayInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3663$$Nest$mconnectWifiDisplayInternal(DisplayManagerService r0, String r1) {
        r0.connectWifiDisplayInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mcreateVirtualDisplayInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m3664$$Nest$mcreateVirtualDisplayInternal(DisplayManagerService r0, VirtualDisplayConfig r1, IVirtualDisplayCallback r2, IMediaProjection r3, IVirtualDevice r4, DisplayWindowPolicyController r5, String r6) {
        return r0.createVirtualDisplayInternal(r1, r2, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: -$$Nest$mdeliverDisplayEvent, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3665$$Nest$mdeliverDisplayEvent(DisplayManagerService r0, int r1, ArraySet r2, int r3) {
        r0.deliverDisplayEvent(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mdeliverDisplayGroupEvent, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3666$$Nest$mdeliverDisplayGroupEvent(DisplayManagerService r0, int r1, int r2) {
        r0.deliverDisplayGroupEvent(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mdisconnectWifiDisplayInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3667$$Nest$mdisconnectWifiDisplayInternal(DisplayManagerService r0) {
        r0.disconnectWifiDisplayInternal();
    }

    /* JADX INFO: renamed from: -$$Nest$mdispatchPendingProcessEvents, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3668$$Nest$mdispatchPendingProcessEvents(DisplayManagerService r0, Object r1) {
        r0.dispatchPendingProcessEvents(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mdumpInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3669$$Nest$mdumpInternal(DisplayManagerService r0, FileDescriptor r1, PrintWriter r2, String[] r3) {
        r0.dumpInternal(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mextraLogging, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3670$$Nest$mextraLogging(DisplayManagerService r0, String r1) {
        return r0.extraLogging(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mforgetWifiDisplayInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3671$$Nest$mforgetWifiDisplayInternal(DisplayManagerService r0, String r1) {
        r0.forgetWifiDisplayInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetBrightnessConfigForDisplayWithPdsFallbackLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ BrightnessConfiguration m3672$$Nest$mgetBrightnessConfigForDisplayWithPdsFallbackLocked(DisplayManagerService r0, String r1, int r2) {
        return r0.getBrightnessConfigForDisplayWithPdsFallbackLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetDeviceForDisplayLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ DisplayDevice m3673$$Nest$mgetDeviceForDisplayLocked(DisplayManagerService r0, int r1) {
        return r0.getDeviceForDisplayLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetDisplayDecorationSupportInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ DisplayDecorationSupport m3674$$Nest$mgetDisplayDecorationSupportInternal(DisplayManagerService r0, int r1) {
        return r0.getDisplayDecorationSupportInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetDisplayInfoInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ DisplayInfo m3675$$Nest$mgetDisplayInfoInternal(DisplayManagerService r0, int r1, int r2) {
        return r0.getDisplayInfoInternal(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetDisplayTokenInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ IBinder m3676$$Nest$mgetDisplayTokenInternal(DisplayManagerService r0, int r1) {
        return r0.getDisplayTokenInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetDpcFromUniqueIdLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ DisplayPowerController m3677$$Nest$mgetDpcFromUniqueIdLocked(DisplayManagerService r0, String r1) {
        return r0.getDpcFromUniqueIdLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetNonOverrideDisplayInfoInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3678$$Nest$mgetNonOverrideDisplayInfoInternal(DisplayManagerService r0, int r1, DisplayInfo r2) {
        r0.getNonOverrideDisplayInfoInternal(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetStableDisplaySizeInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ Point m3679$$Nest$mgetStableDisplaySizeInternal(DisplayManagerService r0) {
        return r0.getStableDisplaySizeInternal();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetSupportedHdrOutputTypesInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ int[] m3680$$Nest$mgetSupportedHdrOutputTypesInternal(DisplayManagerService r0) {
        return r0.getSupportedHdrOutputTypesInternal();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetUserManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ UserManager m3681$$Nest$mgetUserManager(DisplayManagerService r0) {
        return r0.getUserManager();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetWifiDisplayStatusInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ WifiDisplayStatus m3682$$Nest$mgetWifiDisplayStatusInternal(DisplayManagerService r0) {
        return r0.getWifiDisplayStatusInternal();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleLogicalDisplayAddedLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3683$$Nest$mhandleLogicalDisplayAddedLocked(DisplayManagerService r0, LogicalDisplay r1) {
        r0.handleLogicalDisplayAddedLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleLogicalDisplayChangedLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3684$$Nest$mhandleLogicalDisplayChangedLocked(DisplayManagerService r0, LogicalDisplay r1) {
        r0.handleLogicalDisplayChangedLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleLogicalDisplayCommittedStateChangedLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3685$$Nest$mhandleLogicalDisplayCommittedStateChangedLocked(DisplayManagerService r0, LogicalDisplay r1) {
        r0.handleLogicalDisplayCommittedStateChangedLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleLogicalDisplayConnectedLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3686$$Nest$mhandleLogicalDisplayConnectedLocked(DisplayManagerService r0, LogicalDisplay r1) {
        r0.handleLogicalDisplayConnectedLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleLogicalDisplayDeviceStateTransitionLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3687$$Nest$mhandleLogicalDisplayDeviceStateTransitionLocked(DisplayManagerService r0, LogicalDisplay r1) {
        r0.handleLogicalDisplayDeviceStateTransitionLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleLogicalDisplayDisconnectedLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3688$$Nest$mhandleLogicalDisplayDisconnectedLocked(DisplayManagerService r0, LogicalDisplay r1) {
        r0.handleLogicalDisplayDisconnectedLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleLogicalDisplayFrameRateOverridesChangedLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3689$$Nest$mhandleLogicalDisplayFrameRateOverridesChangedLocked(DisplayManagerService r0, LogicalDisplay r1) {
        r0.handleLogicalDisplayFrameRateOverridesChangedLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleLogicalDisplayHdrSdrRatioChangedLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3690$$Nest$mhandleLogicalDisplayHdrSdrRatioChangedLocked(DisplayManagerService r0, LogicalDisplay r1) {
        r0.handleLogicalDisplayHdrSdrRatioChangedLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleLogicalDisplayRefreshRateChangedLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3691$$Nest$mhandleLogicalDisplayRefreshRateChangedLocked(DisplayManagerService r0, LogicalDisplay r1) {
        r0.handleLogicalDisplayRefreshRateChangedLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleLogicalDisplayRemovedLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3692$$Nest$mhandleLogicalDisplayRemovedLocked(DisplayManagerService r0, LogicalDisplay r1) {
        r0.handleLogicalDisplayRemovedLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleLogicalDisplayStateChangedLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3693$$Nest$mhandleLogicalDisplayStateChangedLocked(DisplayManagerService r0, LogicalDisplay r1) {
        r0.handleLogicalDisplayStateChangedLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleLogicalDisplaySwappedLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3694$$Nest$mhandleLogicalDisplaySwappedLocked(DisplayManagerService r0, LogicalDisplay r1) {
        r0.handleLogicalDisplaySwappedLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleMinimalPostProcessingAllowedSettingChange, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3695$$Nest$mhandleMinimalPostProcessingAllowedSettingChange(DisplayManagerService r0) {
        r0.handleMinimalPostProcessingAllowedSettingChange();
    }

    /* JADX INFO: renamed from: -$$Nest$minitializeDisplayPowerControllersLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3696$$Nest$minitializeDisplayPowerControllersLocked(DisplayManagerService r0) {
        r0.initializeDisplayPowerControllersLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$misUidPresentOnDisplayInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3697$$Nest$misUidPresentOnDisplayInternal(DisplayManagerService r0, int r1, int r2) {
        return r0.isUidPresentOnDisplayInternal(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mloadBrightnessConfigurations, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3698$$Nest$mloadBrightnessConfigurations(DisplayManagerService r0) {
        r0.loadBrightnessConfigurations();
    }

    /* JADX INFO: renamed from: -$$Nest$monCallbackDied, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3699$$Nest$monCallbackDied(DisplayManagerService r0, CallbackRecord r1) {
        r0.onCallbackDied(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mpauseWifiDisplayInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3700$$Nest$mpauseWifiDisplayInternal(DisplayManagerService r0) {
        r0.pauseWifiDisplayInternal();
    }

    /* JADX INFO: renamed from: -$$Nest$mregisterAdditionalDisplayAdapters, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3701$$Nest$mregisterAdditionalDisplayAdapters(DisplayManagerService r0) {
        r0.registerAdditionalDisplayAdapters();
    }

    /* JADX INFO: renamed from: -$$Nest$mregisterCallbackInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3702$$Nest$mregisterCallbackInternal(DisplayManagerService r0, IDisplayManagerCallback r1, int r2, int r3, long r4) {
        r0.registerCallbackInternal(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mregisterDefaultDisplayAdapters, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3703$$Nest$mregisterDefaultDisplayAdapters(DisplayManagerService r0) {
        r0.registerDefaultDisplayAdapters();
    }

    /* JADX INFO: renamed from: -$$Nest$mregisterDisplayTransactionListenerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3704$$Nest$mregisterDisplayTransactionListenerInternal(DisplayManagerService r0, DisplayManagerInternal.DisplayTransactionListener r1) {
        r0.registerDisplayTransactionListenerInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mreleaseVirtualDisplayInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3705$$Nest$mreleaseVirtualDisplayInternal(DisplayManagerService r0, IBinder r1) {
        r0.releaseVirtualDisplayInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mrenameWifiDisplayInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3706$$Nest$mrenameWifiDisplayInternal(DisplayManagerService r0, String r1, String r2) {
        r0.renameWifiDisplayInternal(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mrequestColorModeInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3707$$Nest$mrequestColorModeInternal(DisplayManagerService r0, int r1, int r2) {
        r0.requestColorModeInternal(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mrequestDisplayStateInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3708$$Nest$mrequestDisplayStateInternal(DisplayManagerService r0, int r1, int r2, float r3, float r4, int r5) {
        r0.requestDisplayStateInternal(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$mresizeVirtualDisplayInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3709$$Nest$mresizeVirtualDisplayInternal(DisplayManagerService r0, IBinder r1, int r2, int r3, int r4) {
        r0.resizeVirtualDisplayInternal(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mrestoreResolutionFromBackup, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3710$$Nest$mrestoreResolutionFromBackup(DisplayManagerService r0) {
        r0.restoreResolutionFromBackup();
    }

    /* JADX INFO: renamed from: -$$Nest$mresumeWifiDisplayInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3711$$Nest$mresumeWifiDisplayInternal(DisplayManagerService r0) {
        r0.resumeWifiDisplayInternal();
    }

    /* JADX INFO: renamed from: -$$Nest$mscheduleTopologiesReload, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3712$$Nest$mscheduleTopologiesReload(DisplayManagerService r0, int r1, boolean r2) {
        r0.scheduleTopologiesReload(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mscheduleTraversalLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3713$$Nest$mscheduleTraversalLocked(DisplayManagerService r0, boolean r1) {
        r0.scheduleTraversalLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msendDisplayEventLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3714$$Nest$msendDisplayEventLocked(DisplayManagerService r0, LogicalDisplay r1, int r2) {
        r0.sendDisplayEventLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$msendDisplayGroupEvent, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3715$$Nest$msendDisplayGroupEvent(DisplayManagerService r0, int r1, int r2) {
        r0.sendDisplayGroupEvent(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$msetBrightnessConfigurationForDisplayInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3716$$Nest$msetBrightnessConfigurationForDisplayInternal(DisplayManagerService r0, BrightnessConfiguration r1, String r2, int r3, String r4) {
        r0.setBrightnessConfigurationForDisplayInternal(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$msetDisplayAccessUIDsInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3717$$Nest$msetDisplayAccessUIDsInternal(DisplayManagerService r0, SparseArray r1) {
        r0.setDisplayAccessUIDsInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetDisplayOffsetsInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3718$$Nest$msetDisplayOffsetsInternal(DisplayManagerService r0, int r1, int r2, int r3) {
        r0.setDisplayOffsetsInternal(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$msetDisplayScalingDisabledInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3719$$Nest$msetDisplayScalingDisabledInternal(DisplayManagerService r0, int r1, boolean r2) {
        r0.setDisplayScalingDisabledInternal(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$msetVirtualDisplayRotationInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3720$$Nest$msetVirtualDisplayRotationInternal(DisplayManagerService r0, IBinder r1, int r2) {
        r0.setVirtualDisplayRotationInternal(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$msetVirtualDisplaySurfaceInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3721$$Nest$msetVirtualDisplaySurfaceInternal(DisplayManagerService r0, IBinder r1, Surface r2) {
        r0.setVirtualDisplaySurfaceInternal(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mstartWifiDisplayScanInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3722$$Nest$mstartWifiDisplayScanInternal(DisplayManagerService r0, int r1) {
        r0.startWifiDisplayScanInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mstopWifiDisplayScanInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3723$$Nest$mstopWifiDisplayScanInternal(DisplayManagerService r0, int r1) {
        r0.stopWifiDisplayScanInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msystemScreenshotInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ ScreenCapture.ScreenshotHardwareBuffer m3724$$Nest$msystemScreenshotInternal(DisplayManagerService r0, int r1) {
        return r0.systemScreenshotInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$munregisterDisplayTransactionListenerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3725$$Nest$munregisterDisplayTransactionListenerInternal(DisplayManagerService r0, DisplayManagerInternal.DisplayTransactionListener r1) {
        r0.unregisterDisplayTransactionListenerInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateMirrorBuiltInDisplaySettingLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3726$$Nest$mupdateMirrorBuiltInDisplaySettingLocked(DisplayManagerService r0, boolean r1) {
        r0.updateMirrorBuiltInDisplaySettingLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$muserScreenshotInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ ScreenCapture.ScreenshotHardwareBuffer m3727$$Nest$muserScreenshotInternal(DisplayManagerService r0, int r1) {
        return r0.userScreenshotInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3728$$Nest$sfgetDEBUG() {
        return DEBUG;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetEMPTY_ARRAY, reason: not valid java name */
    static /* bridge */ /* synthetic */ int[] m3729$$Nest$sfgetEMPTY_ARRAY() {
        return EMPTY_ARRAY;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetHDR_CONVERSION_MODE_UNSUPPORTED, reason: not valid java name */
    static /* bridge */ /* synthetic */ HdrConversionMode m3730$$Nest$sfgetHDR_CONVERSION_MODE_UNSUPPORTED() {
        return HDR_CONVERSION_MODE_UNSUPPORTED;
    }

    /* JADX INFO: renamed from: -$$Nest$smdeferDisplayEventsWhenFrozen, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3731$$Nest$smdeferDisplayEventsWhenFrozen() {
        return deferDisplayEventsWhenFrozen();
    }

    static {
        DEBUG = DebugUtils.isDebuggable(TAG);
        EMPTY_ARRAY = new int[0];
        HDR_CONVERSION_MODE_UNSUPPORTED = new HdrConversionMode(0);
    }

    private /* synthetic */ DisplayDeviceConfig lambda$new$0(int displayId) {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        DisplayDevice device = getDeviceForDisplayLocked(displayId);     // Catch: Throwable -> L9
        if (device != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L11:
        DisplayDeviceConfig r2 = device.getDisplayDeviceConfig();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    public DisplayManagerService(Context context) {
        this(context, new Injector());
    }

    DisplayManagerService(Context context, Injector injector) {
        super(context);
        DisplayManagerServiceIA r3 = null;
        this.mUidImportanceListener = new UidImportanceListener(this, r3);
        this.mDisplayProcessListener = new AnonymousClass1(this);
        this.mUserDisabledHdrTypes = new int[0];
        this.mAreUserDisabledHdrTypesAllowed = true;
        this.mSurfaceFlingerProcessId = -1;
        this.mComposerServiceProcessId = -1;
        this.mHdrConversionMode = null;
        this.mShouldDisableHdrConversion = false;
        this.mSystemPreferredHdrOutputType = -1;
        this.mSyncRoot = new SyncRoot();
        this.mCallbacks = new SparseArray();
        this.mCallbackRecordByPidByUid = new SparseArray();
        this.mDisplayWindowPolicyControllers = new SparseArray();
        this.mHighBrightnessModeMetadataMapper = new HighBrightnessModeMetadataMapper();
        this.mDisplayAdapters = new ArrayList();
        this.mDisplayTransactionListeners = new CopyOnWriteArrayList();
        this.mDisplayGroupListeners = new CopyOnWriteArrayList();
        this.mDisplayPowerControllers = new SparseArray();
        this.mMaxImportanceForRRCallbacks = 200;
        this.mDisplayBlanker = new AnonymousClass2(this);
        this.mDisplayStates = new SparseIntArray();
        this.mDisplayBrightnesses = new SparseArray();
        this.mStableDisplaySize = new Point();
        this.mViewports = new ArrayList();
        this.mPersistentDataStore = new PersistentDataStore();
        this.mTempCallbacks = new ArrayList();
        this.mPendingCallbackSelfLocked = new SparseArray();
        this.mTempViewports = new ArrayList();
        this.mDisplayAccessUIDs = new SparseArray();
        this.mBootCompleted = false;
        this.mIdleModeReceiver = new AnonymousClass3(this);
        this.mResolutionRestoreReceiver = new AnonymousClass4(this);
        this.mDisplayDeviceConfigProvider = new DisplayManagerService$$ExternalSyntheticLambda15(this);
        this.mSyncDump = new SyncRoot();
        this.mSmtEx = new DisplayManagerServiceSmtEx(this);
        this.mExt = (IExtDisplayManagerService) ExtImplFactory.getImpl(IExtDisplayManagerService.class, new Object[]{this});
        FoldSettingProvider foldSettingProvider = new FoldSettingProvider(context, new SettingsWrapper(), new FoldLockSettingAvailabilityProvider(context.getResources()));
        Looper displayThreadLooper = DisplayThread.get().getLooper();
        this.mInjector = injector;
        this.mContext = context;
        this.mFlags = injector.getFlags();
        this.mHandler = new DisplayManagerHandler(this, displayThreadLooper);
        this.mHandlerExecutor = new HandlerExecutor(this.mHandler);
        this.mUiHandler = UiThread.getHandler();
        this.mDisplayDeviceRepo = new DisplayDeviceRepository(this.mSyncRoot, this.mPersistentDataStore);
        this.mLogicalDisplayMapper = new LogicalDisplayMapper(this.mContext, foldSettingProvider, new FoldGracePeriodProvider(), this.mDisplayDeviceRepo, new LogicalDisplayListener(this, r3), this.mSyncRoot, this.mHandler, this.mFlags);
        this.mDisplayModeDirector = new DisplayModeDirector(context, this.mHandler, this.mFlags, this.mDisplayDeviceConfigProvider);
        this.mBrightnessSynchronizer = new BrightnessSynchronizer(this.mContext, displayThreadLooper, this.mFlags.isBrightnessIntRangeUserPerceptionEnabled());
        Resources resources = this.mContext.getResources();
        this.mDefaultDisplayDefaultColorMode = this.mContext.getResources().getInteger(R.integer.config_defaultNotificationLedOn);
        this.mDefaultDisplayTopInset = SystemProperties.getInt(PROP_DEFAULT_DISPLAY_TOP_INSET, -1);
        if (this.mContext.getResources().getBoolean(R.bool.config_enableGeolocationTimeZoneDetection) == false) goto L5;
        int r5 = 1;
    L6:
        this.mDefaultHdrConversionMode = r5;
        float[] lux = getFloatArray(resources.obtainTypedArray(R.array.config_primaryCredentialProviderService));
        float[] nits = getFloatArray(resources.obtainTypedArray(R.array.config_priorityOnlyDndExemptPackages));
        this.mMinimumBrightnessCurve = new Curve(lux, nits);
        this.mMinimumBrightnessSpline = Spline.createSpline(lux, nits);
        this.mCurrentUserId = 0;
        ColorSpace[] colorSpaces = SurfaceControl.getCompositionColorSpaces();
        this.mWideColorSpace = colorSpaces[1];
        this.mOverlayProperties = SurfaceControl.getOverlaySupport();
        this.mSystemReady = false;
        this.mDumpInProgress = false;
        this.mConfigParameterProvider = new DeviceConfigParameterProvider(DeviceConfigInterface.REAL);
        this.mExtraDisplayLoggingPackageName = (String) DisplayProperties.debug_vri_package().orElse(null);
        this.mExtraDisplayEventLogging = !TextUtils.isEmpty(this.mExtraDisplayLoggingPackageName);
        this.mExternalDisplayStatsService = new ExternalDisplayStatsService(this.mContext, this.mHandler, new DisplayManagerService$$ExternalSyntheticLambda16(this));
        this.mDisplayNotificationManager = new DisplayNotificationManager(this.mFlags, this.mContext, this.mExternalDisplayStatsService);
        this.mExternalDisplayPolicy = new ExternalDisplayPolicy(new ExternalDisplayPolicyInjector(this, r3));
        if (this.mFlags.isDisplayTopologyEnabled() == false) goto L9;
        final BackupManager backupManager = new BackupManager(this.mContext);
        Consumer<Pair<DisplayTopology, DisplayTopologyGraph>> topologyChangedCallback = new DisplayManagerService$$ExternalSyntheticLambda17(this);
        this.mDisplayTopologyCoordinator = new DisplayTopologyCoordinator(new DisplayManagerService$$ExternalSyntheticLambda16(this), topologyChangedCallback, new HandlerExecutor(this.mHandler), this.mSyncRoot, new DisplayManagerService$$ExternalSyntheticLambda18(backupManager));
    L10:
        this.mPluginManager = new PluginManager(this.mContext, this.mFlags);
        this.mSmtEx.init(this.mContext, this.mHandler);
        SysOptBridge.getFactory().getDynamicRefreshRateOpt().init(this.mContext, this.mHandler, this.mSyncRoot, this.mLogicalDisplayMapper, this.mDisplayModeDirector);
        return;
    L9:
        this.mDisplayTopologyCoordinator = null;
        goto L10
    L5:
        r5 = 2;
        goto L6
    }

    private /* synthetic */ void lambda$new$1(Pair update) {
        DisplayTopologyGraph graph = (DisplayTopologyGraph) update.second;
        if (this.mInputManagerInternal == null) goto L6;
        if (graph == null) goto L6;
        this.mInputManagerInternal.setDisplayTopology(graph);
    L6:
        deliverTopologyUpdate((DisplayTopology) update.first);
    }

    public void setupSchedulerPolicies() {
        Process.setThreadGroupAndCpuset(DisplayThread.get().getThreadId(), 5);
        Process.setThreadGroupAndCpuset(AnimationThread.get().getThreadId(), 5);
        Process.setThreadGroupAndCpuset(SurfaceAnimationThread.get().getThreadId(), 5);
        Process.setUIFirstSchedEventTrack(Process.myPid(), DisplayThread.get().getThreadId(), 2, "system_server", false, 0);
        SysOptBridge.getFactory().getSvpCgroupManager().addSvpBackgroundCgroupThread(Process.myPid(), DisplayThread.get().getThreadId());
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        this.mPersistentDataStore.loadIfNeeded();     // Catch: Throwable -> L8
        loadStableDisplayValuesLocked();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mHandler.sendEmptyMessage(1);
        DisplayManagerGlobal.invalidateLocalDisplayInfoCaches();
        publishBinderService("display", new BinderService(this), true, 1);
        publishLocalService(DisplayManagerInternal.class, new LocalService(this));
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase != 100) goto L30;
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        long timeout = SystemClock.uptimeMillis() + this.mInjector.getDefaultDisplayDelayTimeout();     // Catch: Throwable -> L14
    L8:
        if (this.mLogicalDisplayMapper.getDisplayLocked(0) == null) goto L16;
        if (this.mVirtualDisplayAdapter == null) goto L16;
        monitor-exit(r0);     // Catch: Throwable -> L14
    L45:
        this.mExt.onBootPhase(phase);
        return;
    L16:
        long delay = timeout - SystemClock.uptimeMillis();     // Catch: Throwable -> L14
        if (delay <= 0) goto L26;
        if (DEBUG == false) goto L48;
        Slog.d(TAG, "waitForDefaultDisplay: waiting, timeout=" + delay);     // Catch: Throwable -> L14
    L48:
        this.mSyncRoot.wait(delay);     // Catch: Throwable -> L14 InterruptedException -> L23
        goto L8
    L26:
        throw new RuntimeException("Timeout waiting for default display to be initialized. DefaultDisplay=" + this.mLogicalDisplayMapper.getDisplayLocked(0) + ", mVirtualDisplayAdapter=" + this.mVirtualDisplayAdapter);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    L30:
        if (phase != 1000) goto L45;
        SyncRoot r1 = this.mSyncRoot;
        monitor-enter(r1);
        this.mBootCompleted = true;     // Catch: Throwable -> L38
        int i = 0;
    L36:
        if (i >= this.mDisplayPowerControllers.size()) goto L41;
        this.mDisplayPowerControllers.valueAt(i).onBootCompleted();     // Catch: Throwable -> L38
        i = i + 1;     // Catch: Throwable -> L38
        goto L36
    L41:
        monitor-exit(r1);     // Catch: Throwable -> L38
        this.mDisplayModeDirector.onBootCompleted();
        this.mLogicalDisplayMapper.onBootCompleted();
        this.mDisplayNotificationManager.onBootCompleted();
        this.mExternalDisplayPolicy.onBootCompleted();
        this.mPluginManager.onBootCompleted();
    L38:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.SystemService
    public void onUserUnlocked(SystemService.TargetUser to) {
        scheduleTopologiesReload(to.getUserIdentifier(), true);
    }

    @Override // com.android.server.SystemService
    public void onUserSwitching(SystemService.TargetUser from, SystemService.TargetUser to) {
        final int newUserId = to.getUserIdentifier();
        final int userSerial = getUserManager().getUserSerialNumber(newUserId);
        SyncRoot r2 = this.mSyncRoot;
        monitor-enter(r2);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mCurrentUserId == newUserId) goto L7;
        final boolean userSwitching = true;
    L8:
        if (userSwitching == false) goto L12;
        this.mCurrentUserId = newUserId;     // Catch: Throwable -> L10
    L12:
        this.mDisplayModeDirector.onSwitchUser();     // Catch: Throwable -> L10
        this.mLogicalDisplayMapper.forEachLocked(new DisplayManagerService$$ExternalSyntheticLambda23(this, userSwitching, userSerial, newUserId));     // Catch: Throwable -> L10
        handleMinimalPostProcessingAllowedSettingChange();     // Catch: Throwable -> L10
        if (this.mFlags.isDisplayContentModeManagementEnabled() == false) goto L15;
        updateMirrorBuiltInDisplaySettingLocked(true);     // Catch: Throwable -> L10
    L15:
        UserManager userManager = getUserManager();     // Catch: Throwable -> L10
        if (userManager != null) goto L18;
    L20:
        monitor-exit(r2);     // Catch: Throwable -> L10
        return;
    L18:
        if (userManager.isUserUnlockingOrUnlocked(this.mCurrentUserId) == false) goto L20;
        scheduleTopologiesReload(this.mCurrentUserId, true);     // Catch: Throwable -> L10
        goto L20
    L7:
        userSwitching = false;
        goto L8
    }

    private /* synthetic */ void lambda$onUserSwitching$2(boolean userSwitching, int userSerial, int newUserId, LogicalDisplay logicalDisplay) {
        if (logicalDisplay.getDisplayInfoLocked().type == 1) goto L5;
        return;
    L5:
        DisplayPowerController dpc = this.mDisplayPowerControllers.get(logicalDisplay.getDisplayIdLocked());
        if (dpc != null) goto L8;
        return;
    L8:
        if (userSwitching == false) goto L10;
        BrightnessConfiguration config = getBrightnessConfigForDisplayWithPdsFallbackLocked(logicalDisplay.getPrimaryDisplayDeviceLocked().getUniqueId(), userSerial);
        dpc.setBrightnessConfiguration(config, true);
    L10:
        DisplayDevice device = logicalDisplay.getPrimaryDisplayDeviceLocked();
        if (device != null) goto L13;
        float newBrightness = Float.NaN;
    L15:
        if (Float.isNaN(newBrightness) == false) goto L17;
        newBrightness = logicalDisplay.getDisplayInfoLocked().brightnessDefault;
    L17:
        dpc.onSwitchUser(newUserId, userSerial, newBrightness);
        return;
    L13:
        newBrightness = this.mPersistentDataStore.getBrightness(device, userSerial);
        goto L15
    }

    public void windowManagerAndInputReady() {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        this.mWindowManagerInternal = (WindowManagerInternal) LocalServices.getService(WindowManagerInternal.class);     // Catch: Throwable -> L7
        this.mInputManagerInternal = (InputManagerInternal) LocalServices.getService(InputManagerInternal.class);     // Catch: Throwable -> L7
        this.mActivityManagerInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);     // Catch: Throwable -> L7
        ActivityManager activityManager = (ActivityManager) this.mContext.getSystemService(ActivityManager.class);     // Catch: Throwable -> L7
        activityManager.addOnUidImportanceListener(this.mUidImportanceListener, 400);     // Catch: Throwable -> L7
        this.mDeviceStateManager = (DeviceStateManagerInternal) LocalServices.getService(DeviceStateManagerInternal.class);     // Catch: Throwable -> L7
        ((DeviceStateManager) this.mContext.getSystemService(DeviceStateManager.class)).registerCallback(this.mHandlerExecutor, new DeviceStateListener(this));     // Catch: Throwable -> L7
        this.mLogicalDisplayMapper.onWindowManagerReady();     // Catch: Throwable -> L7
        scheduleTraversalLocked(false);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void systemReady(boolean safeMode) {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        this.mSafeMode = safeMode;     // Catch: Throwable -> L7
        this.mSystemReady = true;     // Catch: Throwable -> L7
        this.mIsHdrOutputControlEnabled = this.mConfigParameterProvider.isHdrOutputControlFeatureEnabled();     // Catch: Throwable -> L7
        this.mConfigParameterProvider.addOnPropertiesChangedListener(BackgroundThread.getExecutor(), new DisplayManagerService$$ExternalSyntheticLambda13(this));     // Catch: Throwable -> L7
        recordTopInsetLocked(this.mLogicalDisplayMapper.getDisplayLocked(0));     // Catch: Throwable -> L7
        updateMinimalPostProcessingAllowedSettingLocked();     // Catch: Throwable -> L7
        updateUserDisabledHdrTypesFromSettingsLocked();     // Catch: Throwable -> L7
        updateUserPreferredDisplayModeSettingsLocked();     // Catch: Throwable -> L7
        if (this.mIsHdrOutputControlEnabled == false) goto L10;
        updateHdrConversionModeSettingsLocked();     // Catch: Throwable -> L7
    L10:
        if (this.mFlags.isDisplayContentModeManagementEnabled() == false) goto L12;
        updateMirrorBuiltInDisplaySettingLocked(false);     // Catch: Throwable -> L7
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L7
        this.mDisplayModeDirector.setDesiredDisplayModeSpecsListener(new DesiredDisplayModeSpecsObserver(this));
        this.mDisplayModeDirector.start(this.mSensorManager);
        this.mHandler.sendEmptyMessage(2);
        this.mSettingsObserver = new SettingsObserver(this);
        this.mBrightnessSynchronizer.startSynchronizing();
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.DREAMING_STARTED");
        filter.addAction("android.intent.action.DREAMING_STOPPED");
        filter.addAction("android.intent.action.DOCK_EVENT");
        this.mContext.registerReceiver(this.mIdleModeReceiver, filter);
        if (this.mFlags.isResolutionBackupRestoreEnabled() == false) goto L17;
        IntentFilter restoreFilter = new IntentFilter("android.os.action.SETTING_RESTORED");
        this.mContext.registerReceiver(this.mResolutionRestoreReceiver, restoreFilter);
    L17:
        if (this.mFlags.isSmallAreaDetectionEnabled() == false) goto L19;
        SmallAreaDetectionController r1 = SmallAreaDetectionController.create(this.mContext);
    L20:
        this.mSmallAreaDetectionController = r1;
        registerDisplayProcessListener();
        scheduleTopologiesReload(this.mCurrentUserId, false);
        return;
    L19:
        r1 = null;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$systemReady$3(DeviceConfig.Properties properties) {
        this.mIsHdrOutputControlEnabled = this.mConfigParameterProvider.isHdrOutputControlFeatureEnabled();
    }

    void setDisplayState(int displayId, int state) {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        this.mDisplayStates.setValueAt(displayId, state);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    Handler getDisplayHandler() {
        return this.mHandler;
    }

    DisplayDeviceRepository getDisplayDeviceRepository() {
        return this.mDisplayDeviceRepo;
    }

    LogicalDisplayMapper getLogicalDisplayMapper() {
        return this.mLogicalDisplayMapper;
    }

    boolean isMinimalPostProcessingAllowed() {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        boolean r1 = this.mMinimalPostProcessingAllowed;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void setMinimalPostProcessingAllowed(boolean allowed) {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        this.mMinimalPostProcessingAllowed = allowed;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    ContentObserver getSettingsObserver() {
        return this.mSettingsObserver;
    }

    boolean shouldMirrorBuiltInDisplay() {
        return this.mMirrorBuiltInDisplay;
    }

    DisplayNotificationManager getDisplayNotificationManager() {
        return this.mDisplayNotificationManager;
    }

    private void registerDisplayProcessListener() {
        IBinder surfaceComposer = Binder.allowBlocking(ServiceManager.waitForService(SURFACE_FLINGER_AIDL_SERVICE));
        if (surfaceComposer != null) goto L6;
        Slog.e(TAG, "SurfaceFlingerAIDL service is unavailable");
        return;
    L6:
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(SURFACE_COMPOSER_AIDL_INTERFACE);     // Catch: Throwable -> L12 RemoteException -> L14
        data.writeStrongInterface(this.mDisplayProcessListener);     // Catch: Throwable -> L12 RemoteException -> L14
        if (surfaceComposer.transact(69, data, reply, 0) == true) goto L16;
        Slog.e(TAG, "Failed to transact display process listener registration");     // Catch: Throwable -> L12 RemoteException -> L14
        reply.recycle();
        data.recycle();
        return;
    L16:
        reply.readException();     // Catch: Throwable -> L12 RemoteException -> L14
    L17:
        reply.recycle();
        data.recycle();
        return;
    L14:
        e = move-exception;
        Slog.e(TAG, "Failed to register display process listener", e);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        reply.recycle();
        data.recycle();
        throw th;
    }

    private void addDisplayProcessesToMemPoolSession(int surfaceFlingerPid, int composerPid) {
        if (surfaceFlingerPid > 0) goto L7;
        if (composerPid > 0) goto L7;
        Slog.w(TAG, "Skip display mem pool session: sf=" + surfaceFlingerPid + " composer=" + composerPid);
        return;
    L7:
        int sessionId = Process.createMemPoolSessionGrp();
        if (sessionId >= 0) goto L11;
        Slog.w(TAG, "CreateMemPoolSessionGrp failed: sessionId=" + sessionId);
        return;
    L11:
        addDisplayProcessToSession(sessionId, surfaceFlingerPid, "sf");
        addDisplayProcessToSession(sessionId, composerPid, "composer");
    }

    private void addDisplayProcessToSession(int sessionId, int pid, String processName) {
        if (pid > 0) goto L6;
        Slog.w(TAG, "Skip adding " + processName + " to display mem pool session: pid=" + pid);
        return;
    L6:
        int result = Process.addProcToSession(sessionId, pid);
        if (result >= 0) goto L10;
        Slog.w(TAG, "AddProcToSession failed: sessionId=" + sessionId + " " + processName + "Pid=" + pid + " ret=" + result);
        return;
    }

    private void scheduleTopologiesReload(final int userId, final boolean isUserSwitching) {
        if (this.mDisplayTopologyCoordinator == null) goto L6;
        BackgroundThread.getHandler().post(new DisplayManagerService$$ExternalSyntheticLambda24(this, userId, isUserSwitching));
        return;
    }

    private /* synthetic */ void lambda$scheduleTopologiesReload$4(int userId, boolean isUserSwitching) {
        this.mDisplayTopologyCoordinator.reloadTopologies(userId, isUserSwitching);
    }

    private void loadStableDisplayValuesLocked() {
        Point size = this.mPersistentDataStore.getStableDisplaySize();
        if (size.x > 0) goto L5;
    L7:
        Resources res = this.mContext.getResources();
        int width = res.getInteger(R.integer.config_vibrationWaveformRampStepDuration);
        int height = res.getInteger(R.integer.config_vibrationWaveformRampDownDuration);
        if (width <= 0) goto L13;
        if (height <= 0) goto L14;
        setStableDisplaySizeLocked(width, height);
        return;
    L14:
        return;
    L13:
        return;
    L5:
        if (size.y <= 0) goto L7;
        this.mStableDisplaySize.set(size.x, size.y);
    }

    private Point getStableDisplaySizeInternal() {
        Point r = new Point();
        SyncRoot r1 = this.mSyncRoot;
        monitor-enter(r1);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mStableDisplaySize.x > 0) goto L7;
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L9
        return r;
    L7:
        if (this.mStableDisplaySize.y <= 0) goto L11;
        r.set(this.mStableDisplaySize.x, this.mStableDisplaySize.y);     // Catch: Throwable -> L9
        goto L11
    }

    private void registerDisplayTransactionListenerInternal(DisplayManagerInternal.DisplayTransactionListener listener) {
        this.mDisplayTransactionListeners.add(listener);
    }

    private void unregisterDisplayTransactionListenerInternal(DisplayManagerInternal.DisplayTransactionListener listener) {
        this.mDisplayTransactionListeners.remove(listener);
    }

    void setDisplayInfoOverrideFromWindowManagerInternal(int displayId, DisplayInfo info) {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        LogicalDisplay display = this.mLogicalDisplayMapper.getDisplayLocked(displayId);     // Catch: Throwable -> L9
        if (display != null) goto L7;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L7:
        if (display.setDisplayInfoOverrideFromWindowManagerLocked(info) == false) goto L11;
        handleLogicalDisplayChangedLocked(display);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private void getNonOverrideDisplayInfoInternal(int displayId, DisplayInfo outInfo) {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        LogicalDisplay display = this.mLogicalDisplayMapper.getDisplayLocked(displayId);     // Catch: Throwable -> L7
        if (display == null) goto L9;
        display.getNonOverrideDisplayInfoLocked(outInfo);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void performTraversalInternal(SurfaceControl.Transaction t, SparseArray<SurfaceControl.Transaction> displayTransactions) {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mPendingTraversal == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mPendingTraversal = false;     // Catch: Throwable -> L8
        performTraversalLocked(t, displayTransactions);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        Iterator<DisplayManagerInternal.DisplayTransactionListener> r1 = this.mDisplayTransactionListeners.iterator();
    L14:
        if (r1.hasNext() == false) goto L16;
        DisplayManagerInternal.DisplayTransactionListener listener = r1.next();
        listener.onDisplayTransaction(t);
        goto L14
    }

    private float clampBrightness(int displayState, float brightnessState) {
        if (displayState != 1) goto L6;
        return -1.0f;
    L6:
        if (brightnessState == (-1.0f)) goto L11;
        if (brightnessState >= 0.0f) goto L11;
        return Float.NaN;
    L11:
        if (brightnessState <= 1.0f) goto L16;
        return 1.0f;
    L16:
        return brightnessState;
    }

    private void requestDisplayStateInternal(int displayId, int state, float brightnessState, float sdrBrightnessState) {
        requestDisplayStateInternal(displayId, state, brightnessState, sdrBrightnessState, -1);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:72:0x011a -> B:73:0x011b). Please report as a decompilation issue!!! */
    private void requestDisplayStateInternal(int displayId, int state, float brightnessState, float sdrBrightnessState, int aodLevel) {
        if (state != 0) goto L4;
        int state2 = 2;
    L5:
        float brightnessState2 = clampBrightness(state2, brightnessState);
        float sdrBrightnessState2 = clampBrightness(state2, sdrBrightnessState);
        SyncRoot r11 = this.mSyncRoot;
        monitor-enter(r11);
        int index = this.mDisplayStates.indexOfKey(displayId);     // Catch: Throwable -> L66
        if (index >= 0) goto L75;
    L16:
        if (index >= 0) goto L18;
        BrightnessPair brightnessPair = null;
    L19:
        if (index >= 0) goto L21;
    L27:
        if (aodLevel < 0) goto L69;
        if (index < 0) goto L69;
    L32:
        if (Trace.isTagEnabled(131072) == false) goto L34;
        String traceMessage = Display.stateToString(state2) + ", brightness=" + brightnessState2 + ", sdrBrightness=" + sdrBrightnessState2;     // Catch: Throwable -> L14
        Trace.asyncTraceForTrackBegin(131072, "requestDisplayStateInternal:" + displayId, traceMessage, displayId);     // Catch: Throwable -> L14
    L34:
        this.mDisplayStates.setValueAt(index, state2);     // Catch: Throwable -> L66
        brightnessPair.brightness = brightnessState2;     // Catch: Throwable -> L66
        brightnessPair.sdrBrightness = sdrBrightnessState2;     // Catch: Throwable -> L66
        LogicalDisplay display = this.mLogicalDisplayMapper.getDisplayLocked(displayId);     // Catch: Throwable -> L66
        if (display.isEnabledLocked() == false) goto L37;
    L40:
        Runnable runnable = updateDisplayStateLocked(display.getPrimaryDisplayDeviceLocked());     // Catch: Throwable -> L66
        if (Trace.isTagEnabled(131072) == false) goto L43;
        Trace.asyncTraceForTrackEnd(131072, "requestDisplayStateInternal:" + displayId, displayId);     // Catch: Throwable -> L14
    L43:
        monitor-exit(r11);     // Catch: Throwable -> L66
        if (runnable == null) goto L46;
        runnable.run();
    L46:
        boolean request = false;
        if (aodLevel < 0) goto L60;
        if (runnable != null) goto L60;
        SyncRoot r12 = this.mSyncRoot;
        monitor-enter(r12);
        LogicalDisplay display2 = this.mLogicalDisplayMapper.getDisplayLocked(displayId);     // Catch: Throwable -> L54
        if (display2 == null) goto L56;
        DisplayDevice device = display2.getPrimaryDisplayDeviceLocked();     // Catch: Throwable -> L54
        request = device instanceof LocalDisplayAdapter.LocalDisplayDevice;     // Catch: Throwable -> L54
    L56:
        monitor-exit(r12);     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        throw th;
    L60:
        if (runnable != null) goto L64;
        if (request == true) goto L64;
        return;
    L64:
        this.mExt.requestDisplayStateInternal(displayId, state2, brightnessState2, sdrBrightnessState2, aodLevel);
        return;
    L37:
        if (state2 == 1) goto L40;
        monitor-exit(r11);     // Catch: Throwable -> L14
        return;
    L69:
        monitor-exit(r11);     // Catch: Throwable -> L71
        return;
    L21:
        if (this.mDisplayStates.valueAt(index) != state2) goto L32;
        if (brightnessPair.brightness != brightnessState2) goto L32;
        if (brightnessPair.sdrBrightness != sdrBrightnessState2) goto L32;
    L18:
        brightnessPair = this.mDisplayBrightnesses.valueAt(index);     // Catch: Throwable -> L66
        goto L19
    L75:
    L14:
        th = move-exception;
        Throwable r13 = th;
    L73:
        monitor-exit(r11);     // Catch: Throwable -> L71
        throw r13;
    L10:
        if (this.mDisplayStates.valueAt(index) == 2) goto L16;
        if (state2 != 2) goto L16;
        SysOptBridge.getFactory().getApplicationFreezer().notifyPowerOn();     // Catch: Throwable -> L14
    L66:
        th = move-exception;
        r13 = th;
    L71:
        th = move-exception;
        r13 = th;
        goto L73
    L4:
        state2 = state;
        goto L5
    }

    private void dispatchPendingProcessEvents(Object cb) {
        if ((cb instanceof CallbackRecord) == false) goto L5;
        CallbackRecord callback = (CallbackRecord) cb;
        callback.dispatchPending();
        return;
    L5:
        Slog.wtf(TAG, "not a callback: " + cb);
    }

    private void handleMinimalPostProcessingAllowedSettingChange() {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        updateMinimalPostProcessingAllowedSettingLocked();     // Catch: Throwable -> L7
        scheduleTraversalLocked(false);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void updateMinimalPostProcessingAllowedSettingLocked() {
        boolean r2 = true;
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "minimal_post_processing_allowed", 1, -2) != 0) goto L6;
        r2 = false;
    L6:
        setMinimalPostProcessingAllowed(r2);
    }

    private void updateMirrorBuiltInDisplaySettingLocked(final boolean shouldSendDisplayChangeEvent) {
        ContentResolver resolver = this.mContext.getContentResolver();
        boolean mirrorBuiltInDisplay = false;
        if (Settings.Secure.getIntForUser(resolver, "mirror_built_in_display", 0, -2) == 0) goto L6;
        mirrorBuiltInDisplay = true;
    L6:
        if (this.mMirrorBuiltInDisplay != mirrorBuiltInDisplay) goto L8;
        return;
    L8:
        this.mMirrorBuiltInDisplay = mirrorBuiltInDisplay;
        if (this.mFlags.isDisplayContentModeManagementEnabled() == false) goto L12;
        this.mLogicalDisplayMapper.forEachLocked(new DisplayManagerService$$ExternalSyntheticLambda9(this, shouldSendDisplayChangeEvent));
        return;
    }

    private /* synthetic */ void lambda$updateMirrorBuiltInDisplaySettingLocked$5(boolean shouldSendDisplayChangeEvent, LogicalDisplay logicalDisplay) {
        updateCanHostTasksIfNeededLocked(logicalDisplay, shouldSendDisplayChangeEvent);
    }

    private void restoreResolutionFromBackup() {
        int savedMode = Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "screen_resolution_mode", 0, -2);
        if (savedMode != 0) goto L5;
        return;
    L5:
        SyncRoot r1 = this.mSyncRoot;
        monitor-enter(r1);
        LogicalDisplay display = this.mLogicalDisplayMapper.getDisplayLocked(0);     // Catch: Throwable -> L15
        if (display != null) goto L10;
        DisplayDevice device = null;
    L11:
        if (device != null) goto L17;
        Slog.w(TAG, "No default display device present to restore resolution mode");     // Catch: Throwable -> L15
        monitor-exit(r1);     // Catch: Throwable -> L15
        return;
    L17:
        Point[] supportedRes = device.getSupportedResolutionsLocked();     // Catch: Throwable -> L15
        if (supportedRes.length != 2) goto L20;
        int index = 1;
        if (savedMode != 1) goto L27;
        index = 0;
    L27:
        Point res = supportedRes[index];     // Catch: Throwable -> L15
        Display.Mode newMode = new Display.Mode(res.x, res.y, 0.0f);     // Catch: Throwable -> L15
        Slog.i(TAG, "Restoring resolution from backup: (" + savedMode + ") " + res.x + "x" + res.y);     // Catch: Throwable -> L15
        setUserPreferredDisplayModeInternal(0, newMode);     // Catch: Throwable -> L15
        monitor-exit(r1);     // Catch: Throwable -> L15
        return;
    L20:
        if (DEBUG == false) goto L22;
        Slog.d(TAG, "Skipping resolution restore - " + supportedRes.length);     // Catch: Throwable -> L15
    L22:
        monitor-exit(r1);     // Catch: Throwable -> L15
        return;
    L10:
        device = display.getPrimaryDisplayDeviceLocked();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    private void updateUserDisabledHdrTypesFromSettingsLocked() {
        boolean r2 = true;
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "are_user_disabled_hdr_formats_allowed", 1) != 0) goto L6;
        r2 = false;
    L6:
        this.mAreUserDisabledHdrTypesAllowed = r2;
        String userDisabledHdrTypes = Settings.Global.getString(this.mContext.getContentResolver(), "user_disabled_hdr_formats");
        if (userDisabledHdrTypes != null) goto L21;
        clearUserDisabledHdrTypesLocked();
        return;
    L21:
        String[] userDisabledHdrTypeStrings = TextUtils.split(userDisabledHdrTypes, ",");     // Catch: NumberFormatException -> L12
        this.mUserDisabledHdrTypes = new int[userDisabledHdrTypeStrings.length];     // Catch: NumberFormatException -> L12
        int i = 0;
    L10:
        if (i >= userDisabledHdrTypeStrings.length) goto L15;
        this.mUserDisabledHdrTypes[i] = Integer.parseInt(userDisabledHdrTypeStrings[i]);     // Catch: NumberFormatException -> L12
        i = i + 1;     // Catch: NumberFormatException -> L12
        goto L10
    L15:
        if (this.mAreUserDisabledHdrTypesAllowed == true) goto L25;
        this.mLogicalDisplayMapper.forEachLocked(new DisplayManagerService$$ExternalSyntheticLambda21(this));     // Catch: NumberFormatException -> L12
        return;
    L25:
        return;
    L12:
        e = move-exception;
        Slog.e(TAG, "Failed to parse USER_DISABLED_HDR_FORMATS. Clearing the setting.", e);
        clearUserDisabledHdrTypesLocked();
    }

    private /* synthetic */ void lambda$updateUserDisabledHdrTypesFromSettingsLocked$6(LogicalDisplay display) {
        display.setUserDisabledHdrTypes(this.mUserDisabledHdrTypes);
        handleLogicalDisplayChangedLocked(display);
    }

    private void clearUserDisabledHdrTypesLocked() {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        this.mUserDisabledHdrTypes = new int[0];     // Catch: Throwable -> L8
        Settings.Global.putString(this.mContext.getContentResolver(), "user_disabled_hdr_formats", "");     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void updateUserPreferredDisplayModeSettingsLocked() {
        float refreshRate = Settings.Global.getFloat(this.mContext.getContentResolver(), "user_preferred_refresh_rate", 0.0f);
        int height = Settings.Global.getInt(this.mContext.getContentResolver(), "user_preferred_resolution_height", -1);
        int width = Settings.Global.getInt(this.mContext.getContentResolver(), "user_preferred_resolution_width", -1);
        final Display.Mode mode = new Display.Mode(width, height, refreshRate);
        if (isResolutionAndRefreshRateValid(mode) == false) goto L5;
        Display.Mode r4 = mode;
    L6:
        this.mUserPreferredMode = r4;
        if (this.mUserPreferredMode == null) goto L9;
        this.mDisplayDeviceRepo.forEachLocked(new DisplayManagerService$$ExternalSyntheticLambda6(mode));
    L10:
        this.mLogicalDisplayMapper.forEachLocked(new DisplayManagerService$$ExternalSyntheticLambda8(this));
        return;
    L9:
        this.mLogicalDisplayMapper.forEachLocked(new DisplayManagerService$$ExternalSyntheticLambda7(this));
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    private static /* synthetic */ void lambda$updateUserPreferredDisplayModeSettingsLocked$7(Display.Mode mode, DisplayDevice device) {
        device.setUserPreferredDisplayModeLocked(mode);
    }

    private /* synthetic */ void lambda$updateUserPreferredDisplayModeSettingsLocked$8(LogicalDisplay display) {
        if (display.getDisplayIdLocked() != 0) goto L6;
        getExt().configDefaultDisplayResolutionIfNeeded();
        return;
    }

    private DisplayInfo getDisplayInfoForFrameRateOverride(DisplayEventReceiver.FrameRateOverride[] frameRateOverrides, DisplayInfo info, int callingUid) {
        float frameRateHz = info.renderFrameRate;
        int r4 = frameRateOverrides.length;
        int r6 = 0;
    L4:
        if (r6 >= r4) goto L10;
        DisplayEventReceiver.FrameRateOverride frameRateOverride = frameRateOverrides[r6];
        if (frameRateOverride.uid == callingUid) goto L7;
        r6 = r6 + 1;
        goto L4
    L7:
        frameRateHz = frameRateOverride.frameRateHz;
    L10:
        if (frameRateHz != 0.0f) goto L13;
        return info;
    L13:
        if (callingUid >= 10000) goto L15;
    L18:
        boolean displayModeReturnsPhysicalRefreshRate = true;
    L19:
        Display.Mode currentMode = info.getMode();
        float vsyncRate = currentMode.getVsyncRate();
        float numPeriods = vsyncRate / frameRateHz;
        float numPeriodsRound = Math.round(numPeriods);
        if (Math.abs(numPeriods - numPeriodsRound) <= THRESHOLD_FOR_REFRESH_RATES_DIVISORS) goto L22;
        return info;
    L22:
        float frameRateHz2 = vsyncRate / numPeriodsRound;
        DisplayInfo overriddenInfo = new DisplayInfo();
        overriddenInfo.copyFrom(info);
        Display.Mode[] r13 = info.supportedModes;
        int r14 = r13.length;
        int r15 = 0;
    L23:
        if (r15 >= r14) goto L39;
        Display.Mode mode = r13[r15];
        if (mode.equalsExceptRefreshRate(currentMode) == false) goto L38;
        if (mode.getRefreshRate() < (frameRateHz2 - THRESHOLD_FOR_REFRESH_RATES_DIVISORS)) goto L38;
        if (mode.getRefreshRate() > (frameRateHz2 + THRESHOLD_FOR_REFRESH_RATES_DIVISORS)) goto L38;
        if (DEBUG == false) goto L34;
        Slog.d(TAG, "found matching modeId " + mode.getModeId());
    L34:
        overriddenInfo.refreshRateOverride = mode.getRefreshRate();
        if (displayModeReturnsPhysicalRefreshRate == true) goto L37;
        overriddenInfo.modeId = mode.getModeId();
    L37:
        return overriddenInfo;
    L38:
        r15 = r15 + 1;
        goto L23
    L39:
        overriddenInfo.refreshRateOverride = frameRateHz2;
        if (displayModeReturnsPhysicalRefreshRate == true) goto L42;
        overriddenInfo.supportedModes = (Display.Mode[]) Arrays.copyOf(info.supportedModes, info.supportedModes.length + 1);
        overriddenInfo.supportedModes[overriddenInfo.supportedModes.length - 1] = new Display.Mode(255, currentMode.getPhysicalWidth(), currentMode.getPhysicalHeight(), overriddenInfo.refreshRateOverride, currentMode.getVsyncRate(), new float[0], currentMode.getSupportedHdrTypes());
        overriddenInfo.modeId = overriddenInfo.supportedModes[overriddenInfo.supportedModes.length - 1].getModeId();
    L42:
        return overriddenInfo;
    L15:
        if (CompatChanges.isChangeEnabled(DISPLAY_MODE_RETURNS_PHYSICAL_REFRESH_RATE, callingUid) == true) goto L18;
        displayModeReturnsPhysicalRefreshRate = false;
        goto L19
    }

    private DisplayInfo getDisplayInfoInternal(int displayId, int callingUid) {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        LogicalDisplay display = this.mLogicalDisplayMapper.getDisplayLocked(displayId);     // Catch: Throwable -> L12
        if (display == null) goto L16;
        DisplayInfo info = getDisplayInfoForFrameRateOverride(display.getFrameRateOverrides(), display.getDisplayInfoLocked(), callingUid);     // Catch: Throwable -> L12
        if (info.hasAccess(callingUid) == false) goto L9;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return info;
    L9:
        if (isUidPresentOnDisplayInternal(callingUid, displayId) == true) goto L14;
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return null;
    L16:
        if (displayId != 0) goto L18;
        Slog.e(TAG, "Default display is null for info request from uid " + callingUid);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    private void registerCallbackInternal(IDisplayManagerCallback callback, int callingPid, int callingUid, long internalEventFlagsMask) {
        SyncRoot r1 = this.mSyncRoot;
        monitor-enter(r1);
        CallbackRecord record = this.mCallbacks.get(callingPid);     // Catch: Throwable -> L28
        if (record != null) goto L33;
        CallbackRecord record2 = new CallbackRecord(this, callingPid, callingUid, callback, internalEventFlagsMask);     // Catch: Throwable -> L20
        IBinder binder = callback.asBinder();     // Catch: Throwable -> L20 RemoteException -> L25
        binder.linkToDeath(record2, 0);     // Catch: Throwable -> L20 RemoteException -> L25
        this.mCallbacks.put(callingPid, record2);     // Catch: Throwable -> L20
        if (deferDisplayEventsWhenFrozen() == false) goto L23;
        SparseArray<CallbackRecord> uidPeers = this.mCallbackRecordByPidByUid.get(record2.mUid);     // Catch: Throwable -> L20
        if (uidPeers != null) goto L22;
        uidPeers = new SparseArray();     // Catch: Throwable -> L20
        this.mCallbackRecordByPidByUid.put(record2.mUid, uidPeers);     // Catch: Throwable -> L20
    L22:
        uidPeers.put(record2.mPid, record2);     // Catch: Throwable -> L20
    L23:
        monitor-exit(r1);     // Catch: Throwable -> L20
        return;
    L25:
        ex = move-exception;
        throw new RuntimeException(ex);     // Catch: Throwable -> L20
    L33:
        record.updateEventFlagsMask(internalEventFlagsMask);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = th;
    L30:
        monitor-exit(r1);     // Catch: Throwable -> L20
        throw th;
    L20:
        th = th;
    L28:
        th = th;
        goto L30
    }

    private void onCallbackDied(CallbackRecord record) {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        this.mCallbacks.remove(record.mPid);     // Catch: Throwable -> L11
        if (deferDisplayEventsWhenFrozen() == false) goto L13;
        SparseArray<CallbackRecord> uidPeers = this.mCallbackRecordByPidByUid.get(record.mUid);     // Catch: Throwable -> L11
        if (uidPeers == null) goto L13;
        uidPeers.remove(record.mPid);     // Catch: Throwable -> L11
        if (uidPeers.size() != 0) goto L13;
        this.mCallbackRecordByPidByUid.remove(record.mUid);     // Catch: Throwable -> L11
    L13:
        stopWifiDisplayScanLocked(record);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private void startWifiDisplayScanInternal(int callingPid) {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        CallbackRecord record = this.mCallbacks.get(callingPid);     // Catch: Throwable -> L9
        if (record == null) goto L12;
        startWifiDisplayScanLocked(record);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L12:
        throw new IllegalStateException("The calling process has not registered an IDisplayManagerCallback.");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private void startWifiDisplayScanLocked(CallbackRecord record) {
        if (record.mWifiDisplayScanRequested == true) goto L10;
        record.mWifiDisplayScanRequested = true;
        int r0 = this.mWifiDisplayScanRequestCount;
        this.mWifiDisplayScanRequestCount = r0 + 1;
        if (r0 == 0) goto L7;
        return;
    L7:
        if (this.mWifiDisplayAdapter == null) goto L12;
        this.mWifiDisplayAdapter.requestStartScanLocked();
        return;
    L12:
        return;
    }

    private void stopWifiDisplayScanInternal(int callingPid) {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        CallbackRecord record = this.mCallbacks.get(callingPid);     // Catch: Throwable -> L9
        if (record == null) goto L12;
        stopWifiDisplayScanLocked(record);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L12:
        throw new IllegalStateException("The calling process has not registered an IDisplayManagerCallback.");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private void stopWifiDisplayScanLocked(CallbackRecord record) {
        if (record.mWifiDisplayScanRequested == false) goto L13;
        record.mWifiDisplayScanRequested = false;
        int r1 = this.mWifiDisplayScanRequestCount - 1;
        this.mWifiDisplayScanRequestCount = r1;
        if (r1 != 0) goto L10;
        if (this.mWifiDisplayAdapter == null) goto L14;
        this.mWifiDisplayAdapter.requestStopScanLocked();
        return;
    L14:
        return;
    L10:
        if (this.mWifiDisplayScanRequestCount >= 0) goto L16;
        Slog.wtf(TAG, "mWifiDisplayScanRequestCount became negative: " + this.mWifiDisplayScanRequestCount);
        this.mWifiDisplayScanRequestCount = 0;
        return;
    L16:
        return;
    }

    private void connectWifiDisplayInternal(String address) {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mWifiDisplayAdapter == null) goto L9;
        this.mWifiDisplayAdapter.requestConnectLocked(address);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    private void pauseWifiDisplayInternal() {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mWifiDisplayAdapter == null) goto L9;
        this.mWifiDisplayAdapter.requestPauseLocked();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    private void resumeWifiDisplayInternal() {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mWifiDisplayAdapter == null) goto L9;
        this.mWifiDisplayAdapter.requestResumeLocked();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    private void disconnectWifiDisplayInternal() {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mWifiDisplayAdapter == null) goto L9;
        this.mWifiDisplayAdapter.requestDisconnectLocked();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    private void renameWifiDisplayInternal(String address, String alias) {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mWifiDisplayAdapter == null) goto L9;
        this.mWifiDisplayAdapter.requestRenameLocked(address, alias);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    private void forgetWifiDisplayInternal(String address) {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mWifiDisplayAdapter == null) goto L9;
        this.mWifiDisplayAdapter.requestForgetLocked(address);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    private WifiDisplayStatus getWifiDisplayStatusInternal() {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mWifiDisplayAdapter == null) goto L11;
        WifiDisplayStatus r1 = this.mWifiDisplayAdapter.getWifiDisplayStatusLocked();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L11:
        WifiDisplayStatus r2 = new WifiDisplayStatus();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    }

    void setUserDisabledHdrTypesInternal(final int[] userDisabledHdrTypes) {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        if (userDisabledHdrTypes != null) goto L11;
        Slog.e(TAG, "Null is not an expected argument to setUserDisabledHdrTypesInternal");     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L11:
        if (isSubsetOf(Display.HdrCapabilities.HDR_TYPES, userDisabledHdrTypes) == true) goto L15;
        Slog.e(TAG, "userDisabledHdrTypes contains unexpected types");     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L15:
        Arrays.sort(userDisabledHdrTypes);     // Catch: Throwable -> L8
        if (Arrays.equals(this.mUserDisabledHdrTypes, userDisabledHdrTypes) == false) goto L19;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L19:
        String userDisabledFormatsString = "";
        if (userDisabledHdrTypes.length == 0) goto L22;
        userDisabledFormatsString = TextUtils.join(",", Arrays.stream(userDisabledHdrTypes).boxed().toArray());     // Catch: Throwable -> L8
    L22:
        Settings.Global.putString(this.mContext.getContentResolver(), "user_disabled_hdr_formats", userDisabledFormatsString);     // Catch: Throwable -> L8
        this.mUserDisabledHdrTypes = userDisabledHdrTypes;     // Catch: Throwable -> L8
        if (this.mAreUserDisabledHdrTypesAllowed == true) goto L25;
        this.mLogicalDisplayMapper.forEachLocked(new DisplayManagerService$$ExternalSyntheticLambda5(this, userDisabledHdrTypes));     // Catch: Throwable -> L8
    L25:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$setUserDisabledHdrTypesInternal$9(int[] userDisabledHdrTypes, LogicalDisplay display) {
        display.setUserDisabledHdrTypes(userDisabledHdrTypes);
        handleLogicalDisplayChangedLocked(display);
    }

    private boolean isSubsetOf(int[] sortedSuperset, int[] subset) {
        int r0 = subset.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        int i = subset[r2];
        if (Arrays.binarySearch(sortedSuperset, i) < 0) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    void setAreUserDisabledHdrTypesAllowedInternal(boolean areUserDisabledHdrTypesAllowed) {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mAreUserDisabledHdrTypesAllowed != areUserDisabledHdrTypesAllowed) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mAreUserDisabledHdrTypesAllowed = areUserDisabledHdrTypesAllowed;     // Catch: Throwable -> L8
        ContentResolver r1 = this.mContext.getContentResolver();     // Catch: Throwable -> L8
        if (areUserDisabledHdrTypesAllowed == false) goto L13;
        int r4 = 1;
    L14:
        Settings.Global.putInt(r1, "are_user_disabled_hdr_formats_allowed", r4);     // Catch: Throwable -> L8
        if (this.mUserDisabledHdrTypes.length != 0) goto L18;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L18:
        int[] userDisabledHdrTypes = new int[0];     // Catch: Throwable -> L8
        if (this.mAreUserDisabledHdrTypesAllowed == true) goto L21;
        userDisabledHdrTypes = this.mUserDisabledHdrTypes;     // Catch: Throwable -> L8
    L21:
        final int[] finalUserDisabledHdrTypes = userDisabledHdrTypes;
        this.mLogicalDisplayMapper.forEachLocked(new DisplayManagerService$$ExternalSyntheticLambda22(this, finalUserDisabledHdrTypes));     // Catch: Throwable -> L8
        if (getHdrConversionModeInternal().getConversionMode() != 2) goto L24;
        setHdrConversionModeInternal(new HdrConversionMode(2));     // Catch: Throwable -> L8
    L24:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L13:
        r4 = 0;
        goto L14
    }

    private /* synthetic */ void lambda$setAreUserDisabledHdrTypesAllowedInternal$10(int[] finalUserDisabledHdrTypes, LogicalDisplay display) {
        display.setUserDisabledHdrTypes(finalUserDisabledHdrTypes);
        handleLogicalDisplayChangedLocked(display);
    }

    private void requestColorModeInternal(int displayId, int colorMode) {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        LogicalDisplay display = this.mLogicalDisplayMapper.getDisplayLocked(displayId);     // Catch: Throwable -> L9
        if (display != null) goto L7;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L7:
        if (display.getRequestedColorModeLocked() == colorMode) goto L11;
        display.setRequestedColorModeLocked(colorMode);     // Catch: Throwable -> L9
        scheduleTraversalLocked(false);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private boolean validatePackageName(int uid, String packageName) {
        if (uid != 0) goto L6;
        return true;
    L6:
        if (packageName == null) goto L16;
        String[] packageNames = this.mContext.getPackageManager().getPackagesForUid(uid);
        if (packageNames == null) goto L16;
        int r3 = packageNames.length;
        int r4 = 0;
    L11:
        if (r4 >= r3) goto L16;
        String n = packageNames[r4];
        if (n.equals(packageName) == true) goto L14;
        r4 = r4 + 1;
        goto L11
    L14:
        return true;
    L16:
        return false;
    }

    private boolean hasVideoOutputPermission(String func) {
        if (checkCallingPermission("android.permission.CAPTURE_VIDEO_OUTPUT", func) == false) goto L5;
    L8:
        return true;
    L5:
        if (hasSecureVideoOutputPermission(func) == true) goto L8;
        return false;
    }

    private boolean hasSecureVideoOutputPermission(String func) {
        return checkCallingPermission("android.permission.CAPTURE_SECURE_VIDEO_OUTPUT", func);
    }

    private boolean canCreateMirrorDisplays(IVirtualDevice virtualDevice) {
        if (virtualDevice != null) goto L11;
        return false;
    L11:
        if (virtualDevice.canCreateMirrorDisplays() == false) goto L13;
        return true;
    L13:
        return false;
    L7:
        e = move-exception;
        Slog.e(TAG, "Unable to query virtual device for permissions", e);
        return false;
    }

    private boolean canProjectVideo(IMediaProjection projection) {
        if (projection != null) goto L10;
        return false;
    L10:
        return projection.canProjectVideo();
    L7:
        e = move-exception;
        Slog.e(TAG, "Unable to query projection service for permissions", e);
        return false;
    }

    private boolean canProjectSecureVideo(IMediaProjection projection) {
        if (projection != null) goto L10;
        return false;
    L10:
        return projection.canProjectSecureVideo();
    L7:
        e = move-exception;
        Slog.e(TAG, "Unable to query projection service for permissions", e);
        return false;
    }

    private boolean checkCallingPermission(String permission, String func) {
        if (this.mContext.checkCallingPermission(permission) != 0) goto L6;
        return true;
    L6:
        String msg = "Permission Denial: " + func + " from pid=" + Binder.getCallingPid() + ", uid=" + Binder.getCallingUid() + " requires " + permission;
        Slog.w(TAG, msg);
        return false;
    }

    private int createVirtualDisplayInternal(VirtualDisplayConfig virtualDisplayConfig, IVirtualDisplayCallback callback, IMediaProjection projection, IVirtualDevice virtualDevice, DisplayWindowPolicyController dwpc, String packageName) {
        int callingUid = Binder.getCallingUid();
        if (validatePackageName(callingUid, packageName) == false) goto L247;
        if (callback == null) goto L245;
        if (virtualDisplayConfig == null) goto L243;
        Surface surface = virtualDisplayConfig.getSurface();
        int flags = virtualDisplayConfig.getFlags();
        if (virtualDevice == null) goto L20;
        VirtualDeviceManager vdm = (VirtualDeviceManager) this.mContext.getSystemService(VirtualDeviceManager.class);
        if (vdm == null) goto L20;
        if (vdm.isValidVirtualDeviceId(virtualDevice.getDeviceId()) == false) goto L16;
        VirtualDeviceManagerInternal localVdm = (VirtualDeviceManagerInternal) getLocalService(VirtualDeviceManagerInternal.class);
        if (localVdm == null) goto L20;
        flags = flags | localVdm.getBaseVirtualDisplayFlags(virtualDevice);
        goto L20
    L16:
        throw new SecurityException("Invalid virtual device");     // Catch: RemoteException -> L17
    L19:
        throw new SecurityException("Unable to validate virtual device");
    L20:
        if (surface == null) goto L27;
        if (surface.isSingleBuffered() == false) goto L27;
        throw new IllegalArgumentException("Surface can't be single-buffered");
    L27:
        if ((flags & 1) == 0) goto L37;
        if ((flags & 8) != 0) goto L32;
        Slog.d(TAG, "Public virtual displays are auto mirror by default, hence adding VIRTUAL_DISPLAY_FLAG_AUTO_MIRROR.");
        flags = flags | 16;
    L32:
        if ((flags & 32) == 0) goto L37;
        throw new IllegalArgumentException("Public display must not be marked as SHOW_WHEN_LOCKED_INSECURE");
    L37:
        if ((flags & 8) == 0) goto L42;
        if ((flags & 16) == 0) goto L42;
        Slog.d(TAG, "Own content displays cannot auto mirror other displays, hence ignoring VIRTUAL_DISPLAY_FLAG_AUTO_MIRROR.");
        flags = flags & (-17);
    L42:
        if ((flags & 16) == 0) goto L47;
        if ((flags & 2048) == 0) goto L47;
        Slog.d(TAG, "Auto mirror displays must be in the default display group, hence ignoring VIRTUAL_DISPLAY_FLAG_OWN_DISPLAY_GROUP.");
        flags = flags & (-2049);
    L47:
        if ((flags & 2048) == 0) goto L49;
    L54:
        boolean waitForPermissionConsent = false;
        long firstToken = Binder.clearCallingIdentity();
        if (projection != null) goto L256;
        boolean waitForPermissionConsent2 = false;
    L76:
        Binder.restoreCallingIdentity(firstToken);
        if (callingUid != 1000) goto L79;
    L89:
        if (callingUid != 1000) goto L91;
    L99:
        if (callingUid != 1000) goto L101;
    L107:
        if (virtualDevice != null) goto L109;
    L113:
        if (callingUid == 1000) goto L122;
        if ((flags & 2048) == 0) goto L122;
        if (checkCallingPermission("android.permission.ADD_TRUSTED_DISPLAY", "createVirtualDisplay()") == true) goto L122;
        throw new SecurityException("Requires ADD_TRUSTED_DISPLAY permission to create a virtual display which is not in the default DisplayGroup.");
    L122:
        if ((flags & 4096) == 0) goto L129;
        if ((flags & 2048) != 0) goto L129;
        if ((32768 & flags) != 0) goto L129;
        Slog.d(TAG, "Always unlocked displays cannot be in the default display group, hence ignoring flag VIRTUAL_DISPLAY_FLAG_ALWAYS_UNLOCKED.");
        flags = flags & (-4097);
    L129:
        if ((flags & 4096) == 0) goto L137;
        if (callingUid == 1000) goto L137;
        if (checkCallingPermission("android.permission.ADD_ALWAYS_UNLOCKED_DISPLAY", "createVirtualDisplay()") == true) goto L137;
        throw new SecurityException("Requires ADD_ALWAYS_UNLOCKED_DISPLAY permission to create an always unlocked virtual display.");
    L137:
        if ((flags & 16384) == 0) goto L142;
        if ((flags & 1024) != 0) goto L142;
        Slog.d(TAG, "Untrusted displays cannot have own focus, hence ignoring flag VIRTUAL_DISPLAY_FLAG_OWN_FOCUS.");
        flags = flags & (-16385);
    L142:
        if ((65536 & flags) == 0) goto L147;
        if ((flags & 16384) != 0) goto L147;
        Slog.d(TAG, "Virtual displays that cannot steal top focus must have their own  focus, hence ignoring flag VIRTUAL_DISPLAY_FLAG_STEAL_TOP_FOCUS_DISABLED.");
        flags = flags & (-65537);
    L147:
        if ((flags & 512) != 0) goto L149;
    L151:
        int flags2 = flags;
    L153:
        if ((flags2 & 1536) == 512) goto L155;
    L159:
        long secondToken = Binder.clearCallingIdentity();
        String displayUniqueId = VirtualDisplayAdapter.generateDisplayUniqueId(packageName, callingUid, virtualDisplayConfig);     // Catch: Throwable -> L165
        boolean shouldClearDisplayWindowSettings = false;
        if (virtualDisplayConfig.isHomeSupported() == false) goto L175;
        if ((flags2 & 1024) != 0) goto L168;
        Slog.w(TAG, "Display created with home support but lacks VIRTUAL_DISPLAY_FLAG_TRUSTED, ignoring the home support request.");     // Catch: Throwable -> L165
        goto L175
    L168:
        if ((flags2 & 16) == 0) goto L257;
        Slog.w(TAG, "Display created with home support but has VIRTUAL_DISPLAY_FLAG_AUTO_MIRROR, ignoring the home support request.");     // Catch: Throwable -> L165
        goto L175
    L257:
        this.mWindowManagerInternal.setHomeSupportedOnDisplay(displayUniqueId, 5, true);     // Catch: Throwable -> L172
        shouldClearDisplayWindowSettings = true;
    L172:
        th = th;
    L240:
        Binder.restoreCallingIdentity(secondToken);
        throw th;
    L175:
        if (virtualDisplayConfig.isIgnoreActivitySizeRestrictions() == true) goto L177;
        boolean r3 = true;
        int r8 = 5;
    L181:
        boolean shouldClearDisplayWindowSettings2 = shouldClearDisplayWindowSettings;
    L182:
        SyncRoot r2 = this.mSyncRoot;     // Catch: Throwable -> L172
        monitor-enter(r2);     // Catch: Throwable -> L172
        boolean r19 = r3;
        int r0 = r8;
        int displayId = createVirtualDisplayLocked(callback, projection, callingUid, packageName, displayUniqueId, virtualDevice, dwpc, surface, flags2, virtualDisplayConfig);     // Catch: Throwable -> L190
        if (displayId == (-1)) goto L192;
        if (virtualDevice == null) goto L192;
        if (dwpc == null) goto L192;
        this.mDisplayWindowPolicyControllers.put(displayId, Pair.create(virtualDevice, dwpc));     // Catch: Throwable -> L190
        Slog.d(TAG, "Virtual Display: successfully created virtual display");     // Catch: Throwable -> L190
    L192:
        monitor-exit(r2);     // Catch: Throwable -> L190
        if (displayId != (-1)) goto L196;
        if (shouldClearDisplayWindowSettings2 == false) goto L196;
        this.mWindowManagerInternal.clearDisplaySettings(displayUniqueId, r0);     // Catch: Throwable -> L165
    L196:
        ContentRecordingSession session = null;
        if (projection != null) goto L248;
    L212:
        if (projection != null) goto L217;
        if ((flags2 & 16) != 0) goto L217;
        boolean shouldMirror = false;
    L218:
        if (shouldMirror == false) goto L236;
        if (displayId == (-1)) goto L236;
        if (session == null) goto L236;
        session.setVirtualDisplayId(displayId);     // Catch: Throwable -> L165
        session.setWaitingForConsent(waitForPermissionConsent2);     // Catch: Throwable -> L165
    L227:
        e = move-exception;
        Slog.e(TAG, "Unable to tell MediaProjectionManagerService to set the content recording session", e);     // Catch: Throwable -> L165
        Binder.restoreCallingIdentity(secondToken);
        return displayId;
    L223:
        if (getProjectionService().setContentRecordingSession(session, projection) == true) goto L229;
        Slog.w(TAG, "Content Recording: failed to start mirroring - releasing virtual display " + displayId);     // Catch: Throwable -> L165 RemoteException -> L227
        releaseVirtualDisplayInternal(callback.asBinder());     // Catch: Throwable -> L165 RemoteException -> L227
        Binder.restoreCallingIdentity(secondToken);
        return -1;
    L229:
        if (projection == null) goto L232;
        Slog.d(TAG, "Content Recording: notifying MediaProjection of successful VirtualDisplay creation.");     // Catch: Throwable -> L165 RemoteException -> L227
        projection.notifyVirtualDisplayCreated(displayId);     // Catch: Throwable -> L165 RemoteException -> L227
    L232:
        Slog.d(TAG, "Virtual Display: successfully set up virtual display " + displayId);     // Catch: Throwable -> L165
    L236:
        Binder.restoreCallingIdentity(secondToken);
        return displayId;
    L217:
        shouldMirror = r19;
        goto L218
    L248:
    L205:
        e = move-exception;
        Slog.e(TAG, "Unable to retrieve the projection's launch cookie", e);     // Catch: Throwable -> L165
        goto L212
    L199:
        if (projection.getLaunchCookie() != null) goto L201;
        IBinder taskWindowContainerToken = null;
    L202:
        int taskId = projection.getTaskId();     // Catch: Throwable -> L165 RemoteException -> L205
        if (taskWindowContainerToken != null) goto L208;
        session = ContentRecordingSession.createDisplaySession(virtualDisplayConfig.getDisplayIdToMirror());     // Catch: Throwable -> L165 RemoteException -> L205
        goto L212
    L208:
        session = ContentRecordingSession.createTaskSession(taskWindowContainerToken, taskId);     // Catch: Throwable -> L165 RemoteException -> L205
        goto L212
    L201:
        taskWindowContainerToken = projection.getLaunchCookie().binder;     // Catch: Throwable -> L165 RemoteException -> L205
        goto L202
    L190:
        th = move-exception;
        throw th;     // Catch: Throwable -> L165
    L177:
        if ((flags2 & 1024) != 0) goto L179;
        Slog.w(TAG, "Display created to ignore activity size restrictions, but lacks VIRTUAL_DISPLAY_FLAG_TRUSTED, ignoring the request.");     // Catch: Throwable -> L172
        r3 = true;
        r8 = 5;
        goto L181
    L179:
        r3 = true;
        r8 = 5;
        this.mWindowManagerInternal.setIgnoreActivitySizeRestrictionsOnDisplay(displayUniqueId, 5, true);     // Catch: Throwable -> L172
        shouldClearDisplayWindowSettings2 = true;
    L165:
        th = th;
        goto L240
    L155:
        if (checkCallingPermission("android.permission.INTERNAL_SYSTEM_WINDOW", "createVirtualDisplay()") == true) goto L159;
        throw new SecurityException("Requires INTERNAL_SYSTEM_WINDOW permission");
    L149:
        if ((flags & 1024) != 0) goto L151;
        Slog.d(TAG, "Untrusted displays cannot show system decorations, hence ignoring flag VIRTUAL_DISPLAY_FLAG_SHOULD_SHOW_SYSTEM_DECORATIONS.");
        flags2 = flags & (-513);
        goto L153
    L109:
        if ((flags & 16) == 0) goto L113;
        if ((flags & 2) == 0) goto L113;
        Slog.d(TAG, "Mirror displays created by a virtual device cannot show presentations, hence ignoring flag VIRTUAL_DISPLAY_FLAG_PRESENTATION.");
        flags = flags & (-3);
        goto L113
    L101:
        if ((flags & 1024) == 0) goto L107;
        if (checkCallingPermission("android.permission.ADD_TRUSTED_DISPLAY", "createVirtualDisplay()") == true) goto L107;
        EventLog.writeEvent(1397638484, new Object[]{"162627132", Integer.valueOf(callingUid), "Attempt to create a trusted display without holding permission!"});
        throw new SecurityException("Requires ADD_TRUSTED_DISPLAY permission to create a trusted virtual display.");
    L91:
        if ((flags & 4) == 0) goto L99;
        if (canProjectSecureVideo(projection) == true) goto L99;
        if (hasSecureVideoOutputPermission("createVirtualDisplayInternal") == true) goto L99;
        throw new SecurityException("Requires CAPTURE_SECURE_VIDEO_OUTPUT or an appropriate MediaProjection token to create a secure virtual display.");
    L79:
        if ((flags & 16) == 0) goto L89;
        if (canProjectVideo(projection) == true) goto L89;
        if (canCreateMirrorDisplays(virtualDevice) == true) goto L89;
        if (hasVideoOutputPermission("createVirtualDisplayInternal") == true) goto L89;
        throw new SecurityException("Requires ADD_MIRROR_DISPLAY, CAPTURE_VIDEO_OUTPUT or CAPTURE_SECURE_VIDEO_OUTPUT permission, or an appropriate MediaProjection token in order to create a screen sharing virtual display. In order to create a virtual display that does not perform screen sharing (mirroring), please use the flag VIRTUAL_DISPLAY_FLAG_OWN_CONTENT_ONLY.");
    L256:
    L65:
        e = move-exception;
        throw new SecurityException("Unable to validate media projection or flags", e);     // Catch: Throwable -> L63
    L57:
        if (getProjectionService().isCurrentProjection(projection) == false) goto L69;
        if ("cn.nubia.gamehighlights".equals(packageName) == false) goto L61;
    L67:
        flags = projection.applyVirtualDisplayFlags(flags);     // Catch: Throwable -> L63 RemoteException -> L65
        waitForPermissionConsent2 = waitForPermissionConsent;
        goto L76
    L61:
        if (projection.isValid() == true) goto L67;
        Slog.w(TAG, "Reusing token: create virtual display for app reusing token");     // Catch: Throwable -> L63 RemoteException -> L65
        getProjectionService().requestConsentForInvalidProjection(projection);     // Catch: Throwable -> L63 RemoteException -> L65
        waitForPermissionConsent = true;
        goto L67
    L69:
        throw new SecurityException("Cannot create VirtualDisplay with non-current MediaProjection");     // Catch: Throwable -> L63 RemoteException -> L65
    L63:
        th = move-exception;
        Binder.restoreCallingIdentity(firstToken);
        throw th;
    L49:
        if ((flags & 16) != 0) goto L54;
        if ((flags & 1024) != 1024) goto L54;
        if (virtualDevice == null) goto L54;
        Slog.d(TAG, "Own content displays owned by virtual devices are put in that device's display group, hence adding VIRTUAL_DISPLAY_FLAG_DEVICE_DISPLAY_GROUP.");
        flags = flags | 32768;
        goto L54
    L243:
        throw new IllegalArgumentException("virtualDisplayConfig must not be null");
    L245:
        throw new IllegalArgumentException("appToken must not be null");
    L247:
        throw new SecurityException("packageName must match the calling uid");
    }

    private int createVirtualDisplayLocked(IVirtualDisplayCallback callback, IMediaProjection projection, int callingUid, String packageName, String uniqueId, IVirtualDevice virtualDevice, DisplayWindowPolicyController dwpc, Surface surface, int flags, VirtualDisplayConfig virtualDisplayConfig) {
        if (this.mVirtualDisplayAdapter != null) goto L6;
        Slog.w(TAG, "Rejecting request to create private virtual display because the virtual display adapter is not available.");
        return -1;
    L6:
        Slog.d(TAG, "Virtual Display: creating DisplayDevice with VirtualDisplayAdapter");
        DisplayDevice device = this.mVirtualDisplayAdapter.createVirtualDisplayLocked(callback, projection, callingUid, packageName, uniqueId, surface, flags, virtualDisplayConfig);
        if (device != null) goto L11;
        Slog.w(TAG, "Virtual Display: VirtualDisplayAdapter failed to create DisplayDevice");
        return -1;
    L11:
        if ((flags & 32768) == 0) goto L18;
        if (virtualDevice != null) goto L27;
        Slog.i(TAG, "Display created with VIRTUAL_DISPLAY_FLAG_DEVICE_DISPLAY_GROUP set, but no virtual device. The display will not be added to a device display group.");
        goto L18
    L27:
        int virtualDeviceId = virtualDevice.getDeviceId();     // Catch: RemoteException -> L15
        this.mLogicalDisplayMapper.associateDisplayDeviceWithVirtualDevice(device, virtualDeviceId);     // Catch: RemoteException -> L15
    L15:
        e = move-exception;
        e.rethrowFromSystemServer();
    L18:
        this.mDisplayDeviceRepo.onDisplayDeviceEvent(device, 1);
        LogicalDisplay display = this.mLogicalDisplayMapper.getDisplayLocked(device);
        if (display == null) goto L25;
        if (virtualDevice == null) goto L24;
        VirtualDeviceManagerInternal vdm = (VirtualDeviceManagerInternal) getLocalService(VirtualDeviceManagerInternal.class);
        vdm.onVirtualDisplayCreated(virtualDevice, display.getDisplayIdLocked(), callback, dwpc);
    L24:
        return display.getDisplayIdLocked();
    L25:
        Slog.w(TAG, "Rejecting request to create virtual display because the logical display was not created.");
        this.mVirtualDisplayAdapter.releaseVirtualDisplayLocked(callback.asBinder());
        this.mDisplayDeviceRepo.onDisplayDeviceEvent(device, 3);
        return -1;
    }

    private void resizeVirtualDisplayInternal(IBinder appToken, int width, int height, int densityDpi) {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mVirtualDisplayAdapter != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mVirtualDisplayAdapter.resizeVirtualDisplayLocked(appToken, width, height, densityDpi);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    private void setVirtualDisplaySurfaceInternal(IBinder appToken, Surface surface) {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mVirtualDisplayAdapter != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mVirtualDisplayAdapter.setVirtualDisplaySurfaceLocked(appToken, surface);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    private void releaseVirtualDisplayInternal(IBinder appToken) {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mVirtualDisplayAdapter != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        DisplayDevice device = this.mVirtualDisplayAdapter.releaseVirtualDisplayLocked(appToken);     // Catch: Throwable -> L8
        Slog.d(TAG, "Virtual Display: Display Device released");     // Catch: Throwable -> L8
        if (device == null) goto L13;
        this.mDisplayDeviceRepo.onDisplayDeviceEvent(device, 3);     // Catch: Throwable -> L8
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    private void setVirtualDisplayRotationInternal(IBinder appToken, int rotation) {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mVirtualDisplayAdapter != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        DisplayDevice device = this.mVirtualDisplayAdapter.getDisplayDevice(appToken);     // Catch: Throwable -> L8
        if (device != null) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L14:
        LogicalDisplay display = this.mLogicalDisplayMapper.getDisplayLocked(device);     // Catch: Throwable -> L8
        if (display != null) goto L18;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L18:
        int displayId = display.getDisplayIdLocked();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mWindowManagerInternal.setNonDefaultDisplayRotation(displayId, rotation, "Virtual Display");
    }

    private void registerDefaultDisplayAdapters() {
        SyncRoot r1 = this.mSyncRoot;
        monitor-enter(r1);
        registerDisplayAdapterLocked(this.mInjector.getLocalDisplayAdapter(this.mSyncRoot, this.mContext, this.mHandler, this.mDisplayDeviceRepo, this.mFlags, this.mDisplayNotificationManager));     // Catch: Throwable -> L7
        this.mVirtualDisplayAdapter = this.mInjector.getVirtualDisplayAdapter(this.mSyncRoot, this.mContext, this.mHandler, this.mDisplayDeviceRepo, this.mFlags);     // Catch: Throwable -> L7
        if (this.mVirtualDisplayAdapter == null) goto L9;
        registerDisplayAdapterLocked(this.mVirtualDisplayAdapter);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void registerAdditionalDisplayAdapters() {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (shouldRegisterNonEssentialDisplayAdaptersLocked() == false) goto L9;
        registerOverlayDisplayAdapterLocked();     // Catch: Throwable -> L7
        registerWifiDisplayAdapterLocked();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    private void registerOverlayDisplayAdapterLocked() {
        registerDisplayAdapterLocked(new OverlayDisplayAdapter(this.mSyncRoot, this.mContext, this.mHandler, this.mDisplayDeviceRepo, this.mUiHandler, this.mFlags));
    }

    private void registerWifiDisplayAdapterLocked() {
        if (this.mContext.getResources().getBoolean(R.bool.config_enable_iwlan_handover_policy) == false) goto L5;
    L6:
        this.mWifiDisplayAdapter = new WifiDisplayAdapter(this.mSyncRoot, this.mContext, this.mHandler, this.mDisplayDeviceRepo, this.mPersistentDataStore, this.mFlags);
        registerDisplayAdapterLocked(this.mWifiDisplayAdapter);
        return;
    L5:
        if (SystemProperties.getInt(FORCE_WIFI_DISPLAY_ENABLE, -1) == 1) goto L6;
    }

    private boolean shouldRegisterNonEssentialDisplayAdaptersLocked() {
        return !this.mSafeMode;
    }

    private void registerDisplayAdapterLocked(DisplayAdapter adapter) {
        this.mDisplayAdapters.add(adapter);
        adapter.registerLocked();
    }

    private void handleLogicalDisplayDisconnectedLocked(LogicalDisplay display) {
        releaseDisplayAndEmitEvent(display, 7);
        this.mExternalDisplayPolicy.handleLogicalDisplayDisconnectedLocked(display);
    }

    private void setupLogicalDisplay(LogicalDisplay display) {
        DisplayDevice device = display.getPrimaryDisplayDeviceLocked();
        final int displayId = display.getDisplayIdLocked();
        if (displayId != 0) goto L5;
        boolean isDefault = true;
    L6:
        configureColorModeLocked(display, device);
        if (this.mAreUserDisabledHdrTypesAllowed == true) goto L9;
        display.setUserDisabledHdrTypes(this.mUserDisabledHdrTypes);
    L9:
        if (isDefault == false) goto L12;
        notifyDefaultDisplayDeviceUpdated(display);
        recordStableDisplayStatsIfNeededLocked(display);
        recordTopInsetLocked(display);
    L12:
        if (this.mUserPreferredMode == null) goto L14;
        device.setUserPreferredDisplayModeLocked(this.mUserPreferredMode);
    L15:
        if (isDefault == false) goto L17;
        getExt().configDefaultDisplayResolutionIfNeeded();
    L17:
        DisplayPowerController dpc = addDisplayPowerControllerLocked(display);
        if (dpc == null) goto L20;
        int leadDisplayId = display.getLeadDisplayIdLocked();
        updateDisplayPowerControllerLeaderLocked(dpc, leadDisplayId);
        this.mLogicalDisplayMapper.forEachLocked(new DisplayManagerService$$ExternalSyntheticLambda4(this, displayId));
    L20:
        this.mDisplayStates.append(displayId, 2);
        float brightnessDefault = display.getDisplayInfoLocked().brightnessDefault;
        this.mDisplayBrightnesses.append(displayId, new BrightnessPair(brightnessDefault, brightnessDefault));
        if (this.mFlags.isDisplayContentModeManagementEnabled() == false) goto L23;
        updateCanHostTasksIfNeededLocked(display, false);
    L23:
        DisplayManagerGlobal.invalidateLocalDisplayInfoCaches();
        return;
    L14:
        configurePreferredDisplayModeLocked(display);
        goto L15
    L5:
        isDefault = false;
        goto L6
    }

    private /* synthetic */ void lambda$setupLogicalDisplay$11(int displayId, LogicalDisplay d) {
        if (d.getLeadDisplayIdLocked() != displayId) goto L8;
        DisplayPowerController followerDpc = this.mDisplayPowerControllers.get(d.getDisplayIdLocked());
        if (followerDpc == null) goto L9;
        updateDisplayPowerControllerLeaderLocked(followerDpc, displayId);
        return;
    L9:
        return;
    }

    private void updateLogicalDisplayState(LogicalDisplay display) {
        Runnable work = updateDisplayStateLocked(display.getPrimaryDisplayDeviceLocked());
        if (work == null) goto L5;
        work.run();
    L5:
        scheduleTraversalLocked(false);
    }

    private void handleLogicalDisplayConnectedLocked(LogicalDisplay display) {
        setupLogicalDisplay(display);
        if (ExternalDisplayPolicy.isExternalDisplayLocked(display) == false) goto L5;
        this.mExternalDisplayPolicy.handleExternalDisplayConnectedLocked(display);
    L6:
        updateLogicalDisplayState(display);
        return;
    L5:
        sendDisplayEventLocked(display, 6);
        goto L6
    }

    private boolean isExtendedDisplayAllowed() {
        if (this.mFlags.isDisplayContentModeManagementEnabled() == false) goto L13;
        return true;
    L13:
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "force_desktop_mode_on_external_displays", 0) == 0) goto L10;
        return true;
    L10:
        return false;
    L12:
        return false;
    }

    private void handleLogicalDisplayAddedLocked(LogicalDisplay display) {
        int displayId = display.getDisplayIdLocked();
        if (displayId != 0) goto L5;
        boolean isDefault = true;
    L6:
        if (isDefault == false) goto L8;
        this.mSyncRoot.notifyAll();
    L8:
        sendDisplayEventIfEnabledLocked(display, 1);
        updateLogicalDisplayState(display);
        this.mExternalDisplayPolicy.handleLogicalDisplayAddedLocked(display);
        if (this.mFlags.isApplyDisplayChangedDuringDisplayAddedEnabled() == false) goto L12;
        applyDisplayChangedLocked(display);
    L12:
        if (this.mDisplayTopologyCoordinator != null) goto L14;
        return;
    L14:
        if (display.getDisplayIdLocked() != 0) goto L18;
        this.mDisplayTopologyCoordinator.onDisplayAdded(display.getDisplayInfoLocked());
        return;
    L18:
        return;
    L5:
        isDefault = false;
        goto L6
    }

    private void handleLogicalDisplayChangedLocked(LogicalDisplay display) {
        updateViewportPowerStateLocked(display);
        int displayId = display.getDisplayIdLocked();
        if (displayId != 0) goto L5;
        recordTopInsetLocked(display);
    L5:
        sendDisplayEventIfEnabledLocked(display, 2);
        applyDisplayChangedLocked(display);
        if (this.mDisplayTopologyCoordinator == null) goto L9;
        this.mDisplayTopologyCoordinator.onDisplayChanged(display.getDisplayInfoLocked());
        return;
    }

    private void applyDisplayChangedLocked(LogicalDisplay display) {
        int displayId = display.getDisplayIdLocked();
        scheduleTraversalLocked(false);
        this.mPersistentDataStore.saveIfNeeded();
        DisplayPowerController dpc = this.mDisplayPowerControllers.get(displayId);
        if (dpc == null) goto L6;
        int leadDisplayId = display.getLeadDisplayIdLocked();
        updateDisplayPowerControllerLeaderLocked(dpc, leadDisplayId);
        HighBrightnessModeMetadata hbmMetadata = this.mHighBrightnessModeMetadataMapper.getHighBrightnessModeMetadataLocked(display);
        dpc.onDisplayChanged(hbmMetadata, leadDisplayId);
        return;
    }

    private void updateDisplayPowerControllerLeaderLocked(DisplayPowerController dpc, int leadDisplayId) {
        if (dpc.getLeadDisplayId() != leadDisplayId) goto L5;
        return;
    L5:
        int prevLeaderId = dpc.getLeadDisplayId();
        if (prevLeaderId == (-1)) goto L10;
        DisplayPowerController prevLeader = this.mDisplayPowerControllers.get(prevLeaderId);
        if (prevLeader == null) goto L10;
        prevLeader.removeDisplayBrightnessFollower(dpc);
    L10:
        if (leadDisplayId == (-1)) goto L15;
        DisplayPowerController newLeader = this.mDisplayPowerControllers.get(leadDisplayId);
        if (newLeader == null) goto L16;
        newLeader.addDisplayBrightnessFollower(dpc);
        return;
    L16:
        return;
    }

    private void handleLogicalDisplayFrameRateOverridesChangedLocked(LogicalDisplay display) {
        int displayId = display.getDisplayIdLocked();
        sendDisplayEventFrameRateOverrideLocked(displayId);
        scheduleTraversalLocked(false);
    }

    private void handleLogicalDisplayRemovedLocked(LogicalDisplay display) {
        if (display.isValidLocked() == false) goto L5;
        updateViewportPowerStateLocked(display);
    L5:
        sendDisplayEventLocked(display, 3);
        if (display.isValidLocked() == false) goto L9;
        applyDisplayChangedLocked(display);
    L9:
        if (this.mDisplayTopologyCoordinator == null) goto L11;
        this.mDisplayTopologyCoordinator.onDisplayRemoved(display.getDisplayIdLocked());
    L11:
        Slog.i(TAG, "Logical display removed: " + display.getDisplayIdLocked());
    }

    private void releaseDisplayAndEmitEvent(LogicalDisplay display, int event) {
        final int displayId = display.getDisplayIdLocked();
        DisplayPowerController dpc = (DisplayPowerController) this.mDisplayPowerControllers.removeReturnOld(displayId);
        if (dpc == null) goto L5;
        updateDisplayPowerControllerLeaderLocked(dpc, -1);
        dpc.stop();
    L5:
        this.mDisplayStates.delete(displayId);
        this.mDisplayBrightnesses.delete(displayId);
        DisplayManagerGlobal.invalidateLocalDisplayInfoCaches();
        if (this.mDisplayWindowPolicyControllers.contains(displayId) == false) goto L10;
        final IVirtualDevice virtualDevice = (IVirtualDevice) ((Pair) this.mDisplayWindowPolicyControllers.removeReturnOld(displayId)).first;
        if (virtualDevice == null) goto L10;
        this.mHandler.post(new DisplayManagerService$$ExternalSyntheticLambda11(this, virtualDevice, displayId));
    L10:
        sendDisplayEventLocked(display, event);
        scheduleTraversalLocked(false);
    }

    private /* synthetic */ void lambda$releaseDisplayAndEmitEvent$12(IVirtualDevice virtualDevice, int displayId) {
        ((VirtualDeviceManagerInternal) getLocalService(VirtualDeviceManagerInternal.class)).onVirtualDisplayRemoved(virtualDevice, displayId);
    }

    private void handleLogicalDisplaySwappedLocked(LogicalDisplay display) {
        handleLogicalDisplayChangedLocked(display);
        int displayId = display.getDisplayIdLocked();
        if (displayId != 0) goto L5;
        notifyDefaultDisplayDeviceUpdated(display);
    L5:
        this.mHandler.sendEmptyMessage(6);
    }

    private void handleLogicalDisplayHdrSdrRatioChangedLocked(LogicalDisplay display) {
        sendDisplayEventIfEnabledLocked(display, 5);
    }

    private void handleLogicalDisplayRefreshRateChangedLocked(LogicalDisplay display) {
        sendDisplayEventIfEnabledLocked(display, 8);
    }

    private void handleLogicalDisplayStateChangedLocked(LogicalDisplay display) {
        sendDisplayEventIfEnabledLocked(display, 9);
    }

    private void handleLogicalDisplayCommittedStateChangedLocked(LogicalDisplay display) {
        sendDisplayEventIfEnabledLocked(display, 10);
    }

    private void notifyDefaultDisplayDeviceUpdated(LogicalDisplay display) {
        this.mDisplayModeDirector.defaultDisplayDeviceUpdated(display.getPrimaryDisplayDeviceLocked().mDisplayDeviceConfig);
    }

    private void handleLogicalDisplayDeviceStateTransitionLocked(LogicalDisplay display) {
        int displayId = display.getDisplayIdLocked();
        DisplayPowerController dpc = this.mDisplayPowerControllers.get(displayId);
        if (dpc == null) goto L6;
        int leadDisplayId = display.getLeadDisplayIdLocked();
        updateDisplayPowerControllerLeaderLocked(dpc, leadDisplayId);
        HighBrightnessModeMetadata hbmMetadata = this.mHighBrightnessModeMetadataMapper.getHighBrightnessModeMetadataLocked(display);
        dpc.onDisplayChanged(hbmMetadata, leadDisplayId);
        return;
    }

    private Runnable updateDisplayStateLocked(DisplayDevice device) {
        DisplayDeviceInfo info = device.getDisplayDeviceInfoLocked();
        if ((info.flags & 32) != 0) goto L11;
        LogicalDisplay display = this.mLogicalDisplayMapper.getDisplayLocked(device);
        if (display != null) goto L7;
        return null;
    L7:
        int displayId = display.getDisplayIdLocked();
        int state = this.mDisplayStates.get(displayId);
        if (state == 0) goto L11;
        BrightnessPair brightnessPair = this.mDisplayBrightnesses.get(displayId);
        return device.requestDisplayStateLocked(state, brightnessPair.brightness, brightnessPair.sdrBrightness, display.getDisplayOffloadSessionLocked());
    L11:
        return null;
    }

    private void configureColorModeLocked(LogicalDisplay display, DisplayDevice device) {
        if (display.getPrimaryDisplayDeviceLocked() != device) goto L12;
        int colorMode = this.mPersistentDataStore.getColorMode(device);
        if (colorMode == (-1)) goto L7;
    L10:
        display.setRequestedColorModeLocked(colorMode);
        return;
    L7:
        if (display.getDisplayIdLocked() != 0) goto L9;
        colorMode = this.mDefaultDisplayDefaultColorMode;
        goto L10
    L9:
        colorMode = 0;
        goto L10
    }

    private void configurePreferredDisplayModeLocked(LogicalDisplay display) {
        DisplayDevice device = display.getPrimaryDisplayDeviceLocked();
        Point userPreferredResolution = this.mPersistentDataStore.getUserPreferredResolution(device);
        float refreshRate = this.mPersistentDataStore.getUserPreferredRefreshRate(device);
        if (userPreferredResolution == null) goto L5;
    L7:
        Display.Mode.Builder modeBuilder = new Display.Mode.Builder();
        if (userPreferredResolution == null) goto L11;
        modeBuilder.setResolution(userPreferredResolution.x, userPreferredResolution.y);
    L11:
        if (Float.isNaN(refreshRate) == true) goto L13;
        modeBuilder.setRefreshRate(refreshRate);
    L13:
        device.setUserPreferredDisplayModeLocked(modeBuilder.build());
        return;
    L5:
        if (Float.isNaN(refreshRate) == false) goto L7;
    }

    private void storeHdrConversionModeLocked(HdrConversionMode hdrConversionMode) {
        Settings.Global.putInt(this.mContext.getContentResolver(), "hdr_conversion_mode", hdrConversionMode.getConversionMode());
        if (hdrConversionMode.getConversionMode() != 3) goto L5;
        int preferredHdrOutputType = hdrConversionMode.getPreferredHdrOutputType();
    L6:
        Settings.Global.putInt(this.mContext.getContentResolver(), "hdr_force_conversion_type", preferredHdrOutputType);
        return;
    L5:
        preferredHdrOutputType = -1;
        goto L6
    }

    void updateHdrConversionModeSettingsLocked() {
        int conversionMode = Settings.Global.getInt(this.mContext.getContentResolver(), "hdr_conversion_mode", this.mDefaultHdrConversionMode);
        if (conversionMode != 3) goto L5;
        int preferredHdrOutputType = Settings.Global.getInt(this.mContext.getContentResolver(), "hdr_force_conversion_type", 1);
    L6:
        this.mHdrConversionMode = new HdrConversionMode(conversionMode, preferredHdrOutputType);
        setHdrConversionModeInternal(this.mHdrConversionMode);
        return;
    L5:
        preferredHdrOutputType = -1;
        goto L6
    }

    private void recordStableDisplayStatsIfNeededLocked(LogicalDisplay d) {
        if (this.mStableDisplaySize.x <= 0) goto L5;
        return;
    L5:
        if (this.mStableDisplaySize.y > 0) goto L9;
        DisplayInfo info = d.getDisplayInfoLocked();
        setStableDisplaySizeLocked(info.getNaturalWidth(), info.getNaturalHeight());
        return;
    }

    private void updateCanHostTasksIfNeededLocked(LogicalDisplay display, boolean shouldSendDisplayChangeEvent) {
        if (display.setCanHostTasksLocked(!this.mMirrorBuiltInDisplay) == false) goto L7;
        if (shouldSendDisplayChangeEvent == false) goto L8;
        sendDisplayEventIfEnabledLocked(display, 2);
        return;
    L8:
        return;
    }

    private void recordTopInsetLocked(LogicalDisplay d) {
        if (this.mSystemReady == false) goto L11;
        if (d == null) goto L12;
        int topInset = d.getInsets().top;
        if (topInset != this.mDefaultDisplayTopInset) goto L9;
        return;
    L9:
        this.mDefaultDisplayTopInset = topInset;
        SystemProperties.set(PROP_DEFAULT_DISPLAY_TOP_INSET, Integer.toString(topInset));
        return;
    L12:
        return;
    }

    private void setStableDisplaySizeLocked(int width, int height) {
        this.mStableDisplaySize = new Point(width, height);
        this.mPersistentDataStore.setStableDisplaySize(this.mStableDisplaySize);     // Catch: Throwable -> L6
        this.mPersistentDataStore.saveIfNeeded();
        return;
    L6:
        th = move-exception;
        this.mPersistentDataStore.saveIfNeeded();
        throw th;
    }

    Curve getMinimumBrightnessCurveInternal() {
        return this.mMinimumBrightnessCurve;
    }

    int getPreferredWideGamutColorSpaceIdInternal() {
        return this.mWideColorSpace.getId();
    }

    OverlayProperties getOverlaySupportInternal() {
        return this.mOverlayProperties;
    }

    void setUserPreferredDisplayModeInternal(int displayId, Display.Mode mode) {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        if (mode == null) goto L14;
    L12:
        th = move-exception;
        throw th;
    L7:
        if (isResolutionAndRefreshRateValid(mode) == true) goto L14;
        if (displayId != (-1)) goto L14;
        throw new IllegalArgumentException("width, height and refresh rate of mode should be greater than 0 when setting the global user preferred display mode.");     // Catch: Throwable -> L12
    L14:
        if (mode != null) goto L16;
        int resolutionHeight = -1;
    L18:
        if (mode != null) goto L20;
        int resolutionWidth = -1;
    L22:
        if (mode != null) goto L24;
        float refreshRate = 0.0f;
    L25:
        storeModeInPersistentDataStoreLocked(displayId, resolutionWidth, resolutionHeight, refreshRate);     // Catch: Throwable -> L12
        if (displayId == (-1)) goto L28;
        setUserPreferredModeForDisplayLocked(displayId, mode);     // Catch: Throwable -> L12
    L29:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L28:
        this.mUserPreferredMode = mode;     // Catch: Throwable -> L12
        storeModeInGlobalSettingsLocked(resolutionWidth, resolutionHeight, refreshRate, mode);     // Catch: Throwable -> L12
        goto L29
    L24:
        refreshRate = mode.getRefreshRate();     // Catch: Throwable -> L12
        goto L25
    L20:
        resolutionWidth = mode.getPhysicalWidth();     // Catch: Throwable -> L12
        goto L22
    L16:
        resolutionHeight = mode.getPhysicalHeight();     // Catch: Throwable -> L12
        goto L18
    }

    private void storeModeInPersistentDataStoreLocked(int displayId, int resolutionWidth, int resolutionHeight, float refreshRate) {
        DisplayDevice displayDevice = getDeviceForDisplayLocked(displayId);
        if (displayDevice != null) goto L11;
        return;
    L11:
        this.mPersistentDataStore.setUserPreferredResolution(displayDevice, resolutionWidth, resolutionHeight);     // Catch: Throwable -> L8
        this.mPersistentDataStore.setUserPreferredRefreshRate(displayDevice, refreshRate);     // Catch: Throwable -> L8
        this.mPersistentDataStore.saveIfNeeded();
        return;
    L8:
        th = move-exception;
        this.mPersistentDataStore.saveIfNeeded();
        throw th;
    }

    private void setUserPreferredModeForDisplayLocked(int displayId, Display.Mode mode) {
        DisplayDevice displayDevice = getDeviceForDisplayLocked(displayId);
        if (displayDevice != null) goto L6;
        return;
    L6:
        if (this.mFlags.isResolutionBackupRestoreEnabled() == false) goto L18;
        if (displayId != 0) goto L18;
        Point[] resolutions = displayDevice.getSupportedResolutionsLocked();
        int resolutionMode = 2;
        if (resolutions.length != 2) goto L18;
        Point newMode = new Point(mode.getPhysicalWidth(), mode.getPhysicalHeight());
        if (newMode.equals(resolutions[0]) == false) goto L14;
        resolutionMode = 1;
    L17:
        Settings.Secure.putIntForUser(this.mContext.getContentResolver(), "screen_resolution_mode", resolutionMode, -2);
        goto L18
    L14:
        if (newMode.equals(resolutions[1]) == true) goto L17;
        resolutionMode = 0;
    L18:
        displayDevice.setUserPreferredDisplayModeLocked(mode);
    }

    private void storeModeInGlobalSettingsLocked(int resolutionWidth, int resolutionHeight, float refreshRate, final Display.Mode mode) {
        Settings.Global.putFloat(this.mContext.getContentResolver(), "user_preferred_refresh_rate", refreshRate);
        Settings.Global.putInt(this.mContext.getContentResolver(), "user_preferred_resolution_height", resolutionHeight);
        Settings.Global.putInt(this.mContext.getContentResolver(), "user_preferred_resolution_width", resolutionWidth);
        this.mDisplayDeviceRepo.forEachLocked(new DisplayManagerService$$ExternalSyntheticLambda1(mode));
    }

    private static /* synthetic */ void lambda$storeModeInGlobalSettingsLocked$13(Display.Mode mode, DisplayDevice device) {
        device.setUserPreferredDisplayModeLocked(mode);
    }

    int[] getEnabledHdrOutputTypesLocked() {
        if (this.mAreUserDisabledHdrTypesAllowed == true) goto L5;
        IntArray enabledHdrOutputTypesArray = new IntArray();
        int[] r1 = getSupportedHdrOutputTypesInternal();
        int r2 = r1.length;
        int r4 = 0;
    L7:
        if (r4 >= r2) goto L19;
        int type = r1[r4];
        boolean isEnabled = true;
        int[] r7 = this.mUserDisabledHdrTypes;
        int r8 = r7.length;
        int r9 = 0;
    L10:
        if (r9 >= r8) goto L15;
        int disabledType = r7[r9];
        if (type == disabledType) goto L13;
        r9 = r9 + 1;
        goto L10
    L13:
        isEnabled = false;
    L15:
        if (isEnabled == false) goto L17;
        enabledHdrOutputTypesArray.add(type);
    L17:
        r4 = r4 + 1;
        goto L7
    L19:
        return enabledHdrOutputTypesArray.toArray();
    L5:
        return getSupportedHdrOutputTypesInternal();
    }

    int[] getEnabledHdrOutputTypes() {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        int[] r1 = getEnabledHdrOutputTypesLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean hdrConversionIntroducesLatencyLocked() {
        HdrConversionMode mode = getHdrConversionModeSettingInternal();
        if (mode.getConversionMode() != 2) goto L5;
        int preferredHdrOutputType = this.mSystemPreferredHdrOutputType;
    L7:
        if (preferredHdrOutputType == (-1)) goto L10;
        int[] hdrTypesWithLatency = this.mInjector.getHdrOutputTypesWithLatency();
        return ArrayUtils.contains(hdrTypesWithLatency, preferredHdrOutputType);
    L10:
        return false;
    L5:
        preferredHdrOutputType = mode.getPreferredHdrOutputType();
        goto L7
    }

    Display.Mode getUserPreferredDisplayModeInternal(int displayId) {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        if (displayId != (-1)) goto L11;
        Display.Mode r1 = this.mUserPreferredMode;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L11:
        DisplayDevice displayDevice = getDeviceForDisplayLocked(displayId);     // Catch: Throwable -> L9
        if (displayDevice != null) goto L16;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L16:
        Display.Mode r2 = displayDevice.getUserPreferredDisplayModeLocked();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    Display.Mode getSystemPreferredDisplayModeInternal(int displayId) {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        DisplayDevice device = getDeviceForDisplayLocked(displayId);     // Catch: Throwable -> L9
        if (device != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L11:
        Display.Mode r2 = device.getSystemPreferredDisplayModeLocked();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    void setHdrConversionModeInternal(HdrConversionMode hdrConversionMode) {
        if (this.mInjector.getHdrOutputConversionSupport() == true) goto L5;
        return;
    L5:
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (hdrConversionMode.getConversionMode() == 2) goto L10;
    L16:
        this.mHdrConversionMode = hdrConversionMode;     // Catch: Throwable -> L14
        storeHdrConversionModeLocked(this.mHdrConversionMode);     // Catch: Throwable -> L14
        int[] enabledHdrOutputTypes = null;
        if (hdrConversionMode.getConversionMode() != 2) goto L19;
        enabledHdrOutputTypes = getEnabledHdrOutputTypesLocked();     // Catch: Throwable -> L14
    L19:
        int conversionMode = hdrConversionMode.getConversionMode();     // Catch: Throwable -> L14
        int preferredHdrType = hdrConversionMode.getPreferredHdrOutputType();     // Catch: Throwable -> L14
        if (this.mShouldDisableHdrConversion == false) goto L23;
        conversionMode = 1;
        preferredHdrType = -1;
        enabledHdrOutputTypes = null;
    L27:
        this.mSystemPreferredHdrOutputType = this.mInjector.setHdrConversionMode(conversionMode, preferredHdrType, enabledHdrOutputTypes);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L23:
        if (conversionMode != 3) goto L26;
        if (preferredHdrType != (-1)) goto L26;
        conversionMode = 1;
        this.mLogicalDisplayMapper.forEachLocked(new DisplayManagerService$$ExternalSyntheticLambda2(this));     // Catch: Throwable -> L14
    L26:
        this.mLogicalDisplayMapper.forEachLocked(new DisplayManagerService$$ExternalSyntheticLambda3(this));     // Catch: Throwable -> L14
        goto L27
    L10:
        if (hdrConversionMode.getPreferredHdrOutputType() == (-1)) goto L16;
        throw new IllegalArgumentException("preferredHdrOutputType must not be set if the conversion mode is HDR_CONVERSION_SYSTEM");     // Catch: Throwable -> L14
    }

    private /* synthetic */ void lambda$setHdrConversionModeInternal$14(LogicalDisplay logicalDisplay) {
        if (logicalDisplay.setIsForceSdr(true) == false) goto L6;
        handleLogicalDisplayChangedLocked(logicalDisplay);
        return;
    }

    private /* synthetic */ void lambda$setHdrConversionModeInternal$15(LogicalDisplay logicalDisplay) {
        if (logicalDisplay.setIsForceSdr(false) == false) goto L6;
        handleLogicalDisplayChangedLocked(logicalDisplay);
        return;
    }

    HdrConversionMode getHdrConversionModeSettingInternal() {
        if (this.mInjector.getHdrOutputConversionSupport() == false) goto L5;
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (this.mHdrConversionMode == null) goto L15;
        HdrConversionMode r1 = this.mHdrConversionMode;     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r1;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return new HdrConversionMode(this.mDefaultHdrConversionMode);
    L5:
        return HDR_CONVERSION_MODE_UNSUPPORTED;
    }

    HdrConversionMode getHdrConversionModeInternal() {
        if (this.mInjector.getHdrOutputConversionSupport() == false) goto L5;
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L9:
        if (this.mShouldDisableHdrConversion == false) goto L13;
        HdrConversionMode mode = new HdrConversionMode(1);     // Catch: Throwable -> L11
    L15:
        if (mode != null) goto L22;
        if (this.mDefaultHdrConversionMode != 1) goto L22;
        HdrConversionMode r3 = new HdrConversionMode(1);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r3;
    L22:
        if (mode != null) goto L24;
    L28:
        HdrConversionMode r4 = new HdrConversionMode(2, this.mSystemPreferredHdrOutputType);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r4;
    L24:
        if (mode.getConversionMode() == 2) goto L28;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return mode;
    L13:
        mode = this.mHdrConversionMode;     // Catch: Throwable -> L11
        goto L15
    L5:
        return HDR_CONVERSION_MODE_UNSUPPORTED;
    }

    private int[] getSupportedHdrOutputTypesInternal() {
        if (this.mSupportedHdrOutputTypes != null) goto L6;
        this.mSupportedHdrOutputTypes = this.mInjector.getSupportedHdrOutputTypes();
    L6:
        return this.mSupportedHdrOutputTypes;
    }

    void setShouldAlwaysRespectAppRequestedModeInternal(boolean enabled) {
        this.mDisplayModeDirector.setShouldAlwaysRespectAppRequestedMode(enabled);
    }

    boolean shouldAlwaysRespectAppRequestedModeInternal() {
        return this.mDisplayModeDirector.shouldAlwaysRespectAppRequestedMode();
    }

    void setRefreshRateSwitchingTypeInternal(int newValue) {
        this.mDisplayModeDirector.setModeSwitchingType(newValue);
    }

    int getRefreshRateSwitchingTypeInternal() {
        return this.mDisplayModeDirector.getModeSwitchingType();
    }

    private DisplayDecorationSupport getDisplayDecorationSupportInternal(int displayId) {
        IBinder displayToken = getDisplayToken(displayId);
        if (displayToken != null) goto L7;
        return null;
    L7:
        return SurfaceControl.getDisplayDecorationSupport(displayToken);
    }

    private void setBrightnessConfigurationForDisplayInternal(BrightnessConfiguration c, String uniqueId, int userId, String packageName) {
        validateBrightnessConfiguration(c);
        int userSerial = getUserManager().getUserSerialNumber(userId);
        SyncRoot r1 = this.mSyncRoot;
        monitor-enter(r1);
        DisplayDevice displayDevice = this.mDisplayDeviceRepo.getByUniqueIdLocked(uniqueId);     // Catch: Throwable -> L17
        if (displayDevice != null) goto L12;
        this.mPersistentDataStore.saveIfNeeded();     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L12:
        if (this.mLogicalDisplayMapper.getDisplayLocked(displayDevice) != null) goto L14;
    L19:
        this.mPersistentDataStore.setBrightnessConfigurationForDisplayLocked(c, displayDevice, userSerial, packageName);     // Catch: Throwable -> L17
        this.mPersistentDataStore.saveIfNeeded();     // Catch: Throwable -> L9
        if (userId == this.mCurrentUserId) goto L24;
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L24:
        DisplayPowerController dpc = getDpcFromUniqueIdLocked(uniqueId);     // Catch: Throwable -> L9
        if (dpc == null) goto L27;
        dpc.setBrightnessConfiguration(c, true);     // Catch: Throwable -> L9
    L27:
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L14:
        if (this.mLogicalDisplayMapper.getDisplayLocked(displayDevice).getDisplayInfoLocked().type != 1) goto L19;
        if (c == null) goto L19;
        FrameworkStatsLog.write(FrameworkStatsLog.BRIGHTNESS_CONFIGURATION_UPDATED, (float[]) c.getCurve().first, (float[]) c.getCurve().second, uniqueId);     // Catch: Throwable -> L17
    L9:
        th = move-exception;
        throw th;
    L17:
        th = move-exception;
        this.mPersistentDataStore.saveIfNeeded();     // Catch: Throwable -> L9
        throw th;     // Catch: Throwable -> L9
    }

    private DisplayPowerController getDpcFromUniqueIdLocked(String uniqueId) {
        DisplayDevice displayDevice = this.mDisplayDeviceRepo.getByUniqueIdLocked(uniqueId);
        LogicalDisplay logicalDisplay = this.mLogicalDisplayMapper.getDisplayLocked(displayDevice);
        if (logicalDisplay == null) goto L6;
        int displayId = logicalDisplay.getDisplayIdLocked();
        return this.mDisplayPowerControllers.get(displayId);
    L6:
        return null;
    }

    void validateBrightnessConfiguration(BrightnessConfiguration config) {
        if (config != null) goto L5;
        return;
    L5:
        if (isBrightnessConfigurationTooDark(config) == true) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("brightness curve is too dark");
    }

    private boolean isBrightnessConfigurationTooDark(BrightnessConfiguration config) {
        Pair<float[], float[]> curve = config.getCurve();
        float[] lux = (float[]) curve.first;
        float[] nits = (float[]) curve.second;
        int i = 0;
    L4:
        if (i >= lux.length) goto L10;
        if (nits[i] < this.mMinimumBrightnessSpline.interpolate(lux[i])) goto L7;
        i = i + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    private void loadBrightnessConfigurations() {
        final int userSerial = getUserManager().getUserSerialNumber(this.mContext.getUserId());
        SyncRoot r1 = this.mSyncRoot;
        monitor-enter(r1);
        this.mLogicalDisplayMapper.forEachLocked(new DisplayManagerService$$ExternalSyntheticLambda10(this, userSerial));     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$loadBrightnessConfigurations$16(int userSerial, LogicalDisplay logicalDisplay) {
        String uniqueId = logicalDisplay.getPrimaryDisplayDeviceLocked().getUniqueId();
        BrightnessConfiguration config = getBrightnessConfigForDisplayWithPdsFallbackLocked(uniqueId, userSerial);
        if (config == null) goto L8;
        DisplayPowerController dpc = this.mDisplayPowerControllers.get(logicalDisplay.getDisplayIdLocked());
        if (dpc == null) goto L9;
        dpc.setBrightnessConfiguration(config, false);
        return;
    L9:
        return;
    }

    private void performTraversalLocked(final SurfaceControl.Transaction t, final SparseArray<SurfaceControl.Transaction> displayTransactions) {
        clearViewportsLocked();
        this.mLogicalDisplayMapper.forEachLocked(new DisplayManagerService$$ExternalSyntheticLambda20(this, displayTransactions, t));
        if (this.mInputManagerInternal == null) goto L6;
        this.mHandler.sendEmptyMessage(5);
        return;
    }

    private /* synthetic */ void lambda$performTraversalLocked$17(SparseArray displayTransactions, SurfaceControl.Transaction t, LogicalDisplay display) {
        DisplayDevice device = display.getPrimaryDisplayDeviceLocked();
        SurfaceControl.Transaction displayTransaction = (SurfaceControl.Transaction) displayTransactions.get(display.getDisplayIdLocked(), t);
        if (device == null) goto L6;
        configureDisplayLocked(displayTransaction, device);
        return;
    }

    void setDisplayPropertiesInternal(int displayId, boolean hasContent, float requestedRefreshRate, int requestedModeId, float requestedMinRefreshRate, float requestedMaxRefreshRate, boolean preferMinimalPostProcessing, boolean disableHdrConversion, boolean inTraversal) {
        SyncRoot r8 = this.mSyncRoot;
        monitor-enter(r8);
        LogicalDisplay display = this.mLogicalDisplayMapper.getDisplayLocked(displayId);     // Catch: Throwable -> L8
        if (display != null) goto L11;
        monitor-exit(r8);     // Catch: Throwable -> L8
        return;
    L11:
        if (display.hasContentLocked() != hasContent) goto L13;
        boolean shouldScheduleTraversal = false;
    L17:
        this.mDisplayModeDirector.getAppRequestObserver().setAppRequest(displayId, requestedModeId, requestedRefreshRate, requestedMinRefreshRate, requestedMaxRefreshRate);     // Catch: Throwable -> L8
        boolean r2 = false;
        if (isMinimalPostProcessingAllowed() == false) goto L21;
        if (preferMinimalPostProcessing == false) goto L21;
        boolean mppRequest = true;
    L22:
        if (mppRequest == true) goto L24;
    L26:
        boolean disableHdrConversionForLatency = false;
    L28:
        if (display.getRequestedMinimalPostProcessingLocked() == mppRequest) goto L30;
        display.setRequestedMinimalPostProcessingLocked(mppRequest);     // Catch: Throwable -> L8
        shouldScheduleTraversal = true;
    L30:
        if (shouldScheduleTraversal == false) goto L33;
        scheduleTraversalLocked(inTraversal);     // Catch: Throwable -> L8
    L33:
        if (this.mHdrConversionMode != null) goto L36;
        monitor-exit(r8);     // Catch: Throwable -> L8
        return;
    L36:
        boolean previousShouldDisableHdrConversion = this.mShouldDisableHdrConversion;     // Catch: Throwable -> L8
        if (disableHdrConversion == true) goto L39;
        if (disableHdrConversionForLatency == true) goto L39;
    L40:
        this.mShouldDisableHdrConversion = r2;     // Catch: Throwable -> L8
        if (previousShouldDisableHdrConversion == this.mShouldDisableHdrConversion) goto L43;
        setHdrConversionModeInternal(this.mHdrConversionMode);     // Catch: Throwable -> L8
        handleLogicalDisplayChangedLocked(display);     // Catch: Throwable -> L8
    L43:
        monitor-exit(r8);     // Catch: Throwable -> L8
        return;
    L39:
        r2 = true;
        goto L40
    L24:
        if (hdrConversionIntroducesLatencyLocked() == false) goto L26;
        disableHdrConversionForLatency = true;
    L21:
        mppRequest = false;
        goto L22
    L13:
        if (DEBUG == false) goto L15;
        Slog.d(TAG, "Display " + displayId + " hasContent flag changed: hasContent=" + hasContent + ", inTraversal=" + inTraversal);     // Catch: Throwable -> L8
    L15:
        display.setHasContentLocked(hasContent);     // Catch: Throwable -> L8
        shouldScheduleTraversal = true;
    L8:
        th = move-exception;
        throw th;
    }

    private void setDisplayOffsetsInternal(int displayId, int x, int y) {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        LogicalDisplay display = this.mLogicalDisplayMapper.getDisplayLocked(displayId);     // Catch: Throwable -> L8
        if (display != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L11:
        if (display.getDisplayOffsetXLocked() != x) goto L15;
        if (display.getDisplayOffsetYLocked() != y) goto L15;
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L15:
        if (DEBUG == false) goto L17;
        Slog.d(TAG, "Display " + displayId + " burn-in offset set to (" + x + ", " + y + ")");     // Catch: Throwable -> L8
    L17:
        display.setDisplayOffsetsLocked(x, y);     // Catch: Throwable -> L8
        scheduleTraversalLocked(false);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    private void setDisplayScalingDisabledInternal(int displayId, boolean disable) {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        LogicalDisplay display = this.mLogicalDisplayMapper.getDisplayLocked(displayId);     // Catch: Throwable -> L8
        if (display != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L11:
        if (display.isDisplayScalingDisabled() != disable) goto L13;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L13:
        if (DEBUG == false) goto L15;
        Slog.d(TAG, "Display " + displayId + " content scaling disabled = " + disable);     // Catch: Throwable -> L8
    L15:
        display.setDisplayScalingDisabledLocked(disable);     // Catch: Throwable -> L8
        scheduleTraversalLocked(false);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    private void setDisplayAccessUIDsInternal(SparseArray<IntArray> newDisplayAccessUIDs) {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        this.mDisplayAccessUIDs.clear();     // Catch: Throwable -> L7
        int i = newDisplayAccessUIDs.size() - 1;     // Catch: Throwable -> L7
    L5:
        if (i < 0) goto L10;
        this.mDisplayAccessUIDs.append(newDisplayAccessUIDs.keyAt(i), newDisplayAccessUIDs.valueAt(i));     // Catch: Throwable -> L7
        i = i - 1;     // Catch: Throwable -> L7
        goto L5
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean isUidPresentOnDisplayInternal(int uid, int displayId) {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        IntArray displayUIDs = this.mDisplayAccessUIDs.get(displayId);     // Catch: Throwable -> L9
        if (displayUIDs != null) goto L7;
    L11:
        boolean r2 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L7:
        if (displayUIDs.indexOf(uid) == (-1)) goto L11;
        r2 = true;
    L9:
        th = move-exception;
        throw th;
    }

    private IBinder getDisplayTokenInternal(int displayId) {
        return getDisplayToken(displayId);
    }

    protected IBinder getDisplayToken(int displayId) {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        LogicalDisplay display = this.mLogicalDisplayMapper.getDisplayLocked(displayId);     // Catch: Throwable -> L11
        if (display == null) goto L13;
        DisplayDevice device = display.getPrimaryDisplayDeviceLocked();     // Catch: Throwable -> L11
        if (device == null) goto L13;
        IBinder r3 = device.getDisplayTokenLocked();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r3;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return null;
    L11:
        th = move-exception;
        throw th;
    }

    private ScreenCapture.ScreenshotHardwareBuffer systemScreenshotInternal(int displayId) {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        IBinder token = getDisplayToken(displayId);     // Catch: Throwable -> L8
        if (token != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return null;
    L10:
        LogicalDisplay logicalDisplay = this.mLogicalDisplayMapper.getDisplayLocked(displayId);     // Catch: Throwable -> L8
        if (logicalDisplay != null) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return null;
    L14:
        DisplayInfo displayInfo = logicalDisplay.getDisplayInfoLocked();     // Catch: Throwable -> L8
        ScreenCapture.DisplayCaptureArgs captureArgs = new ScreenCapture.DisplayCaptureArgs.Builder(token).setSize(displayInfo.getNaturalWidth(), displayInfo.getNaturalHeight()).setCaptureSecureLayers(true).setAllowProtected(true).build();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return ScreenCapture.captureDisplay(captureArgs);
    L8:
        th = move-exception;
        throw th;
    }

    private ScreenCapture.ScreenshotHardwareBuffer userScreenshotInternal(int displayId) {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        IBinder token = getDisplayToken(displayId);     // Catch: Throwable -> L9
        if (token != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L11:
        ScreenCapture.DisplayCaptureArgs captureArgs = new ScreenCapture.DisplayCaptureArgs.Builder(token).build();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return ScreenCapture.captureDisplay(captureArgs);
    L9:
        th = move-exception;
        throw th;
    }

    DisplayedContentSamplingAttributes getDisplayedContentSamplingAttributesInternal(int displayId) {
        IBinder token = getDisplayToken(displayId);
        if (token != null) goto L7;
        return null;
    L7:
        return SurfaceControl.getDisplayedContentSamplingAttributes(token);
    }

    boolean setDisplayedContentSamplingEnabledInternal(int displayId, boolean enable, int componentMask, int maxFrames) {
        IBinder token = getDisplayToken(displayId);
        if (token != null) goto L7;
        return false;
    L7:
        return SurfaceControl.setDisplayedContentSamplingEnabled(token, enable, componentMask, maxFrames);
    }

    DisplayedContentSample getDisplayedContentSampleInternal(int displayId, long maxFrames, long timestamp) {
        IBinder token = getDisplayToken(displayId);
        if (token != null) goto L7;
        return null;
    L7:
        return SurfaceControl.getDisplayedContentSample(token, maxFrames, timestamp);
    }

    void resetBrightnessConfigurations() {
        this.mPersistentDataStore.setBrightnessConfigurationForUser(null, this.mContext.getUserId(), this.mContext.getPackageName());
        this.mLogicalDisplayMapper.forEachLocked(new DisplayManagerService$$ExternalSyntheticLambda19(this));
    }

    private /* synthetic */ void lambda$resetBrightnessConfigurations$18(LogicalDisplay logicalDisplay) {
        if (logicalDisplay.getDisplayInfoLocked().type == 1) goto L5;
        return;
    L5:
        String uniqueId = logicalDisplay.getPrimaryDisplayDeviceLocked().getUniqueId();
        setBrightnessConfigurationForDisplayInternal(null, uniqueId, this.mContext.getUserId(), this.mContext.getPackageName());
    }

    void setAutoBrightnessLoggingEnabled(boolean enabled) {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        DisplayPowerController displayPowerController = this.mDisplayPowerControllers.get(0);     // Catch: Throwable -> L7
        if (displayPowerController == null) goto L9;
        displayPowerController.setAutoBrightnessLoggingEnabled(enabled);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void setDisplayWhiteBalanceLoggingEnabled(boolean enabled) {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        DisplayPowerController displayPowerController = this.mDisplayPowerControllers.get(0);     // Catch: Throwable -> L7
        if (displayPowerController == null) goto L9;
        displayPowerController.setDisplayWhiteBalanceLoggingEnabled(enabled);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void setDisplayModeDirectorLoggingEnabled(boolean enabled) {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        this.mDisplayModeDirector.setLoggingEnabled(enabled);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    Display.Mode getActiveDisplayModeAtStart(int displayId) {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        DisplayDevice device = getDeviceForDisplayLocked(displayId);     // Catch: Throwable -> L9
        if (device != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L11:
        Display.Mode r2 = device.getActiveDisplayModeAtStartLocked();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    void setAmbientColorTemperatureOverride(float cct) {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        DisplayPowerController displayPowerController = this.mDisplayPowerControllers.get(0);     // Catch: Throwable -> L7
        if (displayPowerController == null) goto L9;
        displayPowerController.setAmbientColorTemperatureOverride(cct);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void setDockedAndIdleEnabled(boolean enabled, int displayId) {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        DisplayPowerController displayPowerController = this.mDisplayPowerControllers.get(displayId);     // Catch: Throwable -> L10
        if (displayPowerController == null) goto L12;
        if (enabled == false) goto L8;
        int r2 = 1;
    L9:
        displayPowerController.setAutomaticScreenBrightnessMode(r2);     // Catch: Throwable -> L10
        goto L12
    L8:
        r2 = 0;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void clearViewportsLocked() {
        this.mViewports.clear();
    }

    private Optional<Integer> getViewportType(DisplayDeviceInfo info) {
        switch(info.touch) {
            case 1: goto L17;
            case 2: goto L15;
            case 3: goto L6;
            default: goto L10;
        };
    L6:
        if (TextUtils.isEmpty(info.uniqueId) == true) goto L10;
        return Optional.of(3);
    L15:
        return Optional.of(2);
    L17:
        return Optional.of(1);
    L10:
        if (DEBUG == false) goto L13;
        Slog.w(TAG, "Display " + info + " does not support input device matching.");
    L13:
        return Optional.empty();
    }

    private void configureDisplayLocked(SurfaceControl.Transaction t, DisplayDevice device) {
        DisplayDeviceInfo info = device.getDisplayDeviceInfoLocked();
        LogicalDisplay display = this.mLogicalDisplayMapper.getDisplayLocked(device);
        if (display != null) goto L6;
        Slog.w(TAG, "Missing logical display to use for physical display device: " + device.getDisplayDeviceInfoLocked());
        return;
    L6:
        boolean r3 = true;
        if (info.state == 1) goto L10;
        r3 = false;
    L10:
        display.configureDisplayLocked(t, device, r3);
        Optional<Integer> viewportType = getViewportType(info);
        if (viewportType.isPresent() == false) goto L14;
        populateViewportLocked(viewportType.get().intValue(), display.getDisplayIdLocked(), device, info);
        return;
    }

    private DisplayViewport getViewportLocked(int viewportType, String uniqueId) {
        if (viewportType != 1) goto L5;
    L10:
        int count = this.mViewports.size();
        int i = 0;
    L11:
        if (i >= count) goto L18;
        DisplayViewport viewport = this.mViewports.get(i);
        if (viewport.type != viewportType) goto L17;
        if (uniqueId.equals(viewport.uniqueId) == false) goto L17;
        return viewport;
    L17:
        i = i + 1;
        goto L11
    L18:
        DisplayViewport viewport2 = new DisplayViewport();
        viewport2.type = viewportType;
        viewport2.uniqueId = uniqueId;
        this.mViewports.add(viewport2);
        return viewport2;
    L5:
        if (viewportType == 2) goto L10;
        if (viewportType == 3) goto L10;
        Slog.wtf(TAG, "Cannot call getViewportByTypeLocked for type " + DisplayViewport.typeToString(viewportType));
        return null;
    }

    private void populateViewportLocked(int viewportType, int displayId, DisplayDevice device, DisplayDeviceInfo info) {
        DisplayViewport viewport = getViewportLocked(viewportType, info.uniqueId);
        device.populateViewportLocked(viewport);
        viewport.valid = true;
        viewport.displayId = displayId;
        viewport.isActive = Display.isActiveState(info.state);
    }

    private void updateViewportPowerStateLocked(LogicalDisplay display) {
        DisplayDevice device = display.getPrimaryDisplayDeviceLocked();
        DisplayDeviceInfo info = device.getDisplayDeviceInfoLocked();
        Optional<Integer> viewportType = getViewportType(info);
        if (viewportType.isPresent() == false) goto L24;
        Iterator<DisplayViewport> r3 = this.mViewports.iterator();
    L6:
        if (r3.hasNext() == false) goto L14;
        DisplayViewport d = r3.next();
        if (d.type != viewportType.get().intValue()) goto L6;
        if (info.uniqueId.equals(d.uniqueId) == false) goto L6;
        d.isActive = Display.isActiveState(info.state);
        goto L6
    L14:
        if (this.mInputManagerInternal == null) goto L25;
        this.mHandler.sendEmptyMessage(5);
        return;
    L25:
        return;
    }

    private void sendDisplayEventIfEnabledLocked(LogicalDisplay display, int event) {
        boolean displayIsEnabled = display.isEnabledLocked();
        if (Trace.isTagEnabled(131072) == false) goto L5;
        Trace.instant(131072, "sendDisplayEventLocked#event=" + event + ",displayEnabled=" + displayIsEnabled);
    L5:
        if (displayIsEnabled == false) goto L8;
        sendDisplayEventLocked(display, event);
        return;
    L8:
        if (this.mExtraDisplayEventLogging == false) goto L12;
        Slog.i(TAG, "Not Sending Display Event; display is not enabled: " + display);
        return;
    }

    private void sendDisplayEventLocked(LogicalDisplay display, int event) {
        int displayId = display.getDisplayIdLocked();
        Message msg = this.mHandler.obtainMessage(3, displayId, event);
        if (this.mExtraDisplayEventLogging == false) goto L5;
        Slog.i(TAG, "Deliver Display Event on Handler: " + event);
    L5:
        this.mHandler.sendMessage(msg);
    }

    private void sendDisplayGroupEvent(int groupId, int event) {
        Message msg = this.mHandler.obtainMessage(8, groupId, event);
        this.mHandler.sendMessage(msg);
    }

    private void sendDisplayEventFrameRateOverrideLocked(int displayId) {
        if (this.mFlags.isFramerateOverrideTriggersRrCallbacksEnabled() == false) goto L5;
        int event = 8;
    L6:
        Message msg = this.mHandler.obtainMessage(7, displayId, event);
        this.mHandler.sendMessage(msg);
        return;
    L5:
        event = 2;
        goto L6
    }

    private void scheduleTraversalLocked(boolean inTraversal) {
        if (this.mPendingTraversal == false) goto L5;
        return;
    L5:
        if (this.mWindowManagerInternal == null) goto L11;
        this.mPendingTraversal = true;
        if (inTraversal == true) goto L12;
        this.mHandler.sendEmptyMessage(4);
        return;
    L12:
        return;
    }

    private boolean isUidCached(int uid) {
        if (this.mActivityManagerInternal != null) goto L5;
    L11:
        return false;
    L5:
        if (uid < 10000) goto L11;
        int procState = this.mActivityManagerInternal.getUidProcessState(uid);
        int importance = ActivityManager.RunningAppProcessInfo.procStateToImportance(procState);
        if (importance < 400) goto L12;
        return true;
    L12:
        return false;
    }

    private void deliverDisplayEvent(int displayId, ArraySet<Integer> uids, int event) {
        if (DEBUG == false) goto L5;
    L6:
        StringBuilder r1 = new StringBuilder();
        r1.append("Delivering display event: displayId=");
        r1.append(displayId);
        r1.append(", event=");
        r1.append(event);
        if (uids == null) goto L9;
        String r2 = ", uids=" + uids;
    L10:
        r1.append(r2);
        Slog.d(TAG, r1.toString());
    L12:
        if (Trace.isTagEnabled(131072) == false) goto L18;
        StringBuilder r3 = new StringBuilder();
        r3.append("deliverDisplayEvent#event=");
        r3.append(event);
        r3.append(",displayId=");
        r3.append(displayId);
        if (uids == null) goto L16;
        String r4 = ", uids=" + uids;
    L17:
        r3.append(r4);
        Trace.instant(131072, r3.toString());
        goto L18
    L16:
        r4 = "";
    L18:
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        int count = this.mCallbacks.size();     // Catch: Throwable -> L26
        this.mTempCallbacks.clear();     // Catch: Throwable -> L26
        int i = 0;
    L21:
        if (i >= count) goto L31;
        if (uids == null) goto L28;
        if (uids.contains(Integer.valueOf(this.mCallbacks.valueAt(i).mUid)) == true) goto L28;
    L29:
        i = i + 1;     // Catch: Throwable -> L26
    L28:
        this.mTempCallbacks.add(this.mCallbacks.valueAt(i));     // Catch: Throwable -> L26
        goto L29
    L31:
        monitor-exit(r0);     // Catch: Throwable -> L26
        int i2 = 0;
    L34:
        if (i2 >= this.mTempCallbacks.size()) goto L40;
        CallbackRecord callbackRecord = this.mTempCallbacks.get(i2);
        if (deferDisplayEventsWhenFrozen() == false) goto L38;
        deliverEventFlagged(callbackRecord, displayId, event);
    L39:
        i2 = i2 + 1;
        goto L34
    L38:
        deliverEventUnflagged(callbackRecord, displayId, event);
        goto L39
    L40:
        this.mTempCallbacks.clear();
        return;
    L26:
        th = move-exception;
        throw th;
    L9:
        r2 = "";
        goto L10
    L5:
        if (this.mExtraDisplayEventLogging == false) goto L12;
        goto L6
    }

    private void deliverEventUnflagged(CallbackRecord callbackRecord, int displayId, int event) {
        int uid = callbackRecord.mUid;
        int pid = callbackRecord.mPid;
        if (isUidCached(uid) == false) goto L21;
        SparseArray<SparseArray<PendingCallback>> r2 = this.mPendingCallbackSelfLocked;
        monitor-enter(r2);
        SparseArray<PendingCallback> pendingCallbacks = this.mPendingCallbackSelfLocked.get(uid);     // Catch: Throwable -> L9
        if (extraLogging(CallbackRecord.m3733$$Nest$fgetmPackageName(callbackRecord)) == false) goto L11;
        Slog.i(TAG, "Uid is cached: " + uid + ", pendingCallbacks: " + pendingCallbacks);     // Catch: Throwable -> L9
    L11:
        if (pendingCallbacks != null) goto L13;
        pendingCallbacks = new SparseArray();     // Catch: Throwable -> L9
        this.mPendingCallbackSelfLocked.put(uid, pendingCallbacks);     // Catch: Throwable -> L9
    L13:
        PendingCallback pendingCallback = pendingCallbacks.get(pid);     // Catch: Throwable -> L9
        if (pendingCallback != null) goto L16;
        pendingCallbacks.put(pid, new PendingCallback(callbackRecord, displayId, event));     // Catch: Throwable -> L9
    L17:
        monitor-exit(r2);     // Catch: Throwable -> L9
        return;
    L16:
        pendingCallback.addDisplayEvent(displayId, event);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L21:
        callbackRecord.notifyDisplayEventAsync(displayId, event);
    }

    private void deliverEventFlagged(CallbackRecord callbackRecord, int displayId, int event) {
        callbackRecord.notifyDisplayEventAsync(displayId, event);
    }

    private void deliverTopologyUpdate(DisplayTopology topology) {
        if (DEBUG == false) goto L6;
        Slog.d(TAG, "Delivering topology update: " + topology);
    L6:
        if (Trace.isTagEnabled(131072) == false) goto L8;
        Trace.instant(131072, "deliverTopologyUpdate");
    L8:
        List<CallbackRecord> callbacks = new ArrayList();
        SyncRoot r1 = this.mSyncRoot;
        monitor-enter(r1);
        int i = 0;
    L25:
    L14:
        th = move-exception;
        throw th;
    L12:
        if (i >= this.mCallbacks.size()) goto L17;
        callbacks.add(this.mCallbacks.valueAt(i));     // Catch: Throwable -> L14
        i = i + 1;     // Catch: Throwable -> L14
        goto L25
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L14
        Iterator<CallbackRecord> r2 = callbacks.iterator();
    L20:
        if (r2.hasNext() == false) goto L22;
        CallbackRecord callback = r2.next();
        callback.notifyTopologyUpdateAsync(topology);
        goto L20
    }

    private boolean extraLogging(String packageName) {
        if (this.mExtraDisplayEventLogging == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mExtraDisplayLoggingPackageName.equals(packageName) == false) goto L7;
        return true;
    }

    private void deliverDisplayGroupEvent(int groupId, int event) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "Delivering display group event: groupId=" + groupId + ", event=" + event);
    L5:
        switch(event) {
            case 1: goto L16;
            case 2: goto L11;
            case 3: goto L7;
            default: goto L21;
        };
    L7:
        Iterator<DisplayManagerInternal.DisplayGroupListener> r0 = this.mDisplayGroupListeners.iterator();
    L9:
        if (r0.hasNext() == false) goto L25;
        DisplayManagerInternal.DisplayGroupListener listener = r0.next();
        listener.onDisplayGroupRemoved(groupId);
        goto L9
    L25:
        return;
    L11:
        Iterator<DisplayManagerInternal.DisplayGroupListener> r1 = this.mDisplayGroupListeners.iterator();
    L13:
        if (r1.hasNext() == false) goto L26;
        DisplayManagerInternal.DisplayGroupListener listener2 = r1.next();
        listener2.onDisplayGroupChanged(groupId);
        goto L13
    L26:
        return;
    L16:
        Iterator<DisplayManagerInternal.DisplayGroupListener> r2 = this.mDisplayGroupListeners.iterator();
    L18:
        if (r2.hasNext() == false) goto L27;
        DisplayManagerInternal.DisplayGroupListener listener3 = r2.next();
        listener3.onDisplayGroupAdded(groupId);
        goto L18
    L27:
        return;
    }

    private IMediaProjectionManager getProjectionService() {
        if (this.mProjectionService != null) goto L6;
        this.mProjectionService = this.mInjector.getProjectionService();
    L6:
        return this.mProjectionService;
    }

    private UserManager getUserManager() {
        return (UserManager) this.mContext.getSystemService(UserManager.class);
    }

    private void dumpInternal(FileDescriptor fd, final PrintWriter pw, String[] args) {
        boolean ret = this.mExt.dump(fd, pw, args);
        if (ret == false) goto L5;
        return;
    L5:
        SyncRoot r6 = this.mSyncDump;
        monitor-enter(r6);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (this.mDumpInProgress == false) goto L14;
        pw.println("One dump is in service already.");     // Catch: Throwable -> L12
        monitor-exit(r6);     // Catch: Throwable -> L12
        return;
    L14:
        this.mDumpInProgress = true;     // Catch: Throwable -> L12
        monitor-exit(r6);     // Catch: Throwable -> L12
        pw.println("DISPLAY MANAGER (dumpsys display)");
        SparseArray<DisplayPowerController> displayPowerControllersLocal = new SparseArray();
        final PrintWriter r0 = new IndentingPrintWriter(pw, "    ");
        r0.increaseIndent();
        SyncRoot r9 = this.mSyncRoot;
        monitor-enter(r9);
        BrightnessTracker brightnessTrackerLocal = this.mBrightnessTracker;     // Catch: Throwable -> L21
        int displayPowerControllerCount = this.mDisplayPowerControllers.size();     // Catch: Throwable -> L21
        int i = 0;
    L19:
        if (i >= displayPowerControllerCount) goto L23;
        displayPowerControllersLocal.put(this.mDisplayPowerControllers.keyAt(i), this.mDisplayPowerControllers.valueAt(i));     // Catch: Throwable -> L21
        i = i + 1;     // Catch: Throwable -> L21
        goto L19
    L23:
        pw.println("  mSafeMode=" + this.mSafeMode);     // Catch: Throwable -> L21
        pw.println("  mPendingTraversal=" + this.mPendingTraversal);     // Catch: Throwable -> L21
        pw.println("  mViewports=" + this.mViewports);     // Catch: Throwable -> L21
        pw.println("  mDefaultDisplayDefaultColorMode=" + this.mDefaultDisplayDefaultColorMode);     // Catch: Throwable -> L21
        pw.println("  mWifiDisplayScanRequestCount=" + this.mWifiDisplayScanRequestCount);     // Catch: Throwable -> L21
        pw.println("  mStableDisplaySize=" + this.mStableDisplaySize);     // Catch: Throwable -> L21
        pw.println("  mMinimumBrightnessCurve=" + this.mMinimumBrightnessCurve);     // Catch: Throwable -> L21
        pw.println("  mMaxImportanceForRRCallbacks=" + this.mMaxImportanceForRRCallbacks);     // Catch: Throwable -> L21
        if (this.mUserPreferredMode == null) goto L26;
        pw.println(" mUserPreferredMode=" + this.mUserPreferredMode);     // Catch: Throwable -> L21
    L26:
        pw.println();     // Catch: Throwable -> L21
        if (this.mAreUserDisabledHdrTypesAllowed == true) goto L32;
        pw.println("  mUserDisabledHdrTypes: size=" + this.mUserDisabledHdrTypes.length);     // Catch: Throwable -> L21
        int[] r1 = this.mUserDisabledHdrTypes;     // Catch: Throwable -> L21
        int r12 = r1.length;     // Catch: Throwable -> L21
        int r13 = 0;
    L29:
        if (r13 >= r12) goto L32;
        int type = r1[r13];     // Catch: Throwable -> L21
        pw.println("  " + type);     // Catch: Throwable -> L21
        r13 = r13 + 1;     // Catch: Throwable -> L21
    L32:
        if (this.mHdrConversionMode == null) goto L34;
        pw.println("  mHdrConversionMode=" + this.mHdrConversionMode);     // Catch: Throwable -> L21
    L34:
        pw.println();     // Catch: Throwable -> L21
        int displayStateCount = this.mDisplayStates.size();     // Catch: Throwable -> L21
        pw.println("Display States: size=" + displayStateCount);     // Catch: Throwable -> L21
        pw.println("---------------------");     // Catch: Throwable -> L21
        int i2 = 0;
    L35:
        if (i2 >= displayStateCount) goto L37;
        int displayId = this.mDisplayStates.keyAt(i2);     // Catch: Throwable -> L21
        int displayState = this.mDisplayStates.valueAt(i2);     // Catch: Throwable -> L21
        BrightnessPair brightnessPair = this.mDisplayBrightnesses.valueAt(i2);     // Catch: Throwable -> L21
        StringBuilder r15 = new StringBuilder();     // Catch: Throwable -> L21
        r15.append("  Display Id=");     // Catch: Throwable -> L21
        r15.append(displayId);     // Catch: Throwable -> L21
        pw.println(r15.toString());     // Catch: Throwable -> L21
        pw.println("  Display State=" + Display.stateToString(displayState));     // Catch: Throwable -> L21
        pw.println("  Display Brightness=" + brightnessPair.brightness);     // Catch: Throwable -> L21
        pw.println("  Display SdrBrightness=" + brightnessPair.sdrBrightness);     // Catch: Throwable -> L21
        i2 = i2 + 1;     // Catch: Throwable -> L21
        displayStateCount = displayStateCount;
        goto L35
    L37:
        pw.println();     // Catch: Throwable -> L21
        pw.println("Display Adapters: size=" + this.mDisplayAdapters.size());     // Catch: Throwable -> L21
        pw.println("------------------------");     // Catch: Throwable -> L21
        Iterator<DisplayAdapter> r2 = this.mDisplayAdapters.iterator();     // Catch: Throwable -> L21
    L39:
        if (r2.hasNext() == false) goto L41;
        DisplayAdapter adapter = r2.next();     // Catch: Throwable -> L21
        pw.println("  " + adapter.getName());     // Catch: Throwable -> L21
        adapter.dumpLocked(r0);     // Catch: Throwable -> L21
        goto L39
    L41:
        pw.println();     // Catch: Throwable -> L21
        pw.println("Display Devices: size=" + this.mDisplayDeviceRepo.sizeLocked());     // Catch: Throwable -> L21
        pw.println("-----------------------");     // Catch: Throwable -> L21
        this.mDisplayDeviceRepo.forEachLocked(new DisplayManagerService$$ExternalSyntheticLambda14(pw, r0));     // Catch: Throwable -> L21
        pw.println();     // Catch: Throwable -> L21
        this.mLogicalDisplayMapper.dumpLocked(pw);     // Catch: Throwable -> L21
        int callbackCount = this.mCallbacks.size();     // Catch: Throwable -> L21
        pw.println();     // Catch: Throwable -> L21
        pw.println("Callbacks: size=" + callbackCount);     // Catch: Throwable -> L21
        pw.println("-----------------");     // Catch: Throwable -> L21
        int i3 = 0;
    L42:
        if (i3 >= callbackCount) goto L44;
        pw.println("  " + i3 + ": " + CallbackRecord.m3734$$Nest$mdump(this.mCallbacks.valueAt(i3)));     // Catch: Throwable -> L21
        i3 = i3 + 1;     // Catch: Throwable -> L21
        goto L42
    L44:
        pw.println();     // Catch: Throwable -> L21
        this.mPersistentDataStore.dump(pw);     // Catch: Throwable -> L21
        int displayWindowPolicyControllerCount = this.mDisplayWindowPolicyControllers.size();     // Catch: Throwable -> L21
        pw.println();     // Catch: Throwable -> L21
        pw.println("Display Window Policy Controllers: size=" + displayWindowPolicyControllerCount);     // Catch: Throwable -> L21
        int i4 = 0;
    L45:
        if (i4 >= displayWindowPolicyControllerCount) goto L48;
        pw.print("Display " + this.mDisplayWindowPolicyControllers.keyAt(i4) + ":");     // Catch: Throwable -> L21
        ((DisplayWindowPolicyController) this.mDisplayWindowPolicyControllers.valueAt(i4).second).dump("  ", pw);     // Catch: Throwable -> L21
        i4 = i4 + 1;     // Catch: Throwable -> L21
        goto L45
    L48:
        monitor-exit(r9);     // Catch: Throwable -> L21
        pw.println();
        pw.println("Display Power Controllers: size=" + displayPowerControllerCount);
        int i5 = 0;
    L50:
        if (i5 >= displayPowerControllerCount) goto L53;
        displayPowerControllersLocal.valueAt(i5).dump(pw);
        i5 = i5 + 1;
        goto L50
    L53:
        if (brightnessTrackerLocal == null) goto L55;
        pw.println();
        brightnessTrackerLocal.dump(pw);
    L55:
        pw.println();
        this.mDisplayModeDirector.dump(pw);
        pw.println();
        this.mBrightnessSynchronizer.dump(pw);
        if (this.mSmallAreaDetectionController == null) goto L58;
        pw.println();
        this.mSmallAreaDetectionController.dump(pw);
    L58:
        SyncRoot r11 = this.mSyncDump;
        monitor-enter(r11);
        this.mDumpInProgress = false;     // Catch: Throwable -> L68
        monitor-exit(r11);     // Catch: Throwable -> L68
        if (this.mDisplayTopologyCoordinator == null) goto L66;
        pw.println();
        this.mDisplayTopologyCoordinator.dump(pw);
    L66:
        pw.println();
        this.mPluginManager.dump(r0);
        pw.println();
        this.mFlags.dump(pw);
        return;
    L68:
        th = move-exception;
        throw th;
    L21:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$dumpInternal$19(PrintWriter pw, IndentingPrintWriter ipw, DisplayDevice device) {
        pw.println("  " + device.getDisplayDeviceInfoLocked());
        device.dumpLocked(ipw);
    }

    private static float[] getFloatArray(TypedArray array) {
        int length = array.length();
        float[] floatArray = new float[length];
        int i = 0;
    L3:
        if (i >= length) goto L5;
        floatArray[i] = array.getFloat(i, Float.NaN);
        i = i + 1;
        goto L3
    L5:
        array.recycle();
        return floatArray;
    }

    private static boolean isResolutionAndRefreshRateValid(Display.Mode mode) {
        if (mode.getPhysicalWidth() > 0) goto L5;
    L9:
        return false;
    L5:
        if (mode.getPhysicalHeight() <= 0) goto L9;
        if (mode.getRefreshRate() <= 0.0f) goto L9;
        return true;
    }

    void enableConnectedDisplay(int displayId, boolean enabled) {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        LogicalDisplay logicalDisplay = this.mLogicalDisplayMapper.getDisplayLocked(displayId);     // Catch: Throwable -> L7
        if (logicalDisplay != null) goto L10;
        Slog.w(TAG, "enableConnectedDisplay: Can not find displayId=" + displayId);     // Catch: Throwable -> L7
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L10:
        if (ExternalDisplayPolicy.isExternalDisplayLocked(logicalDisplay) == false) goto L12;
        this.mExternalDisplayPolicy.setExternalDisplayEnabledLocked(logicalDisplay, enabled);     // Catch: Throwable -> L7
        goto L13
    L12:
        this.mLogicalDisplayMapper.setDisplayEnabledLocked(logicalDisplay, enabled);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    void overrideMaxImportanceForRRCallbacks(int importance) {
        this.mMaxImportanceForRRCallbacks = importance;
    }

    boolean requestDisplayPower(int displayId, int requestedState) {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        LogicalDisplay display = this.mLogicalDisplayMapper.getDisplayLocked(displayId);     // Catch: Throwable -> L9
        if (display != null) goto L11;
        Slog.w(TAG, "requestDisplayPower: Cannot find the display with displayId=" + displayId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L11:
        int state = requestedState;
        if (state != 0) goto L14;
        state = this.mDisplayStates.get(displayId);     // Catch: Throwable -> L9
    L14:
        BrightnessPair brightnessPair = this.mDisplayBrightnesses.get(displayId);     // Catch: Throwable -> L9
        float brightnessState = brightnessPair.brightness;     // Catch: Throwable -> L9
        if (state != 1) goto L17;
        brightnessState = -1.0f;
    L17:
        Runnable runnable = display.getPrimaryDisplayDeviceLocked().requestDisplayStateLocked(state, brightnessState, brightnessPair.sdrBrightness, display.getDisplayOffloadSessionLocked());     // Catch: Throwable -> L9
        if (runnable != null) goto L22;
        Slog.w(TAG, "requestDisplayPower: Cannot set power state = " + state + " for the display with displayId=" + displayId + ", requestedState=" + requestedState + ": runnable is null");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L22:
        runnable.run();     // Catch: Throwable -> L9
        Slog.i(TAG, "requestDisplayPower(displayId=" + displayId + ", requestedState=" + requestedState + "): state set to " + state);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return true;
    L9:
        th = move-exception;
        throw th;
    }

    DisplayDeviceInfo getDisplayDeviceInfoInternal(int displayId) {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        LogicalDisplay display = this.mLogicalDisplayMapper.getDisplayLocked(displayId);     // Catch: Throwable -> L9
        if (display == null) goto L11;
        DisplayDevice displayDevice = display.getPrimaryDisplayDeviceLocked();     // Catch: Throwable -> L9
        DisplayDeviceInfo r3 = displayDevice.getDisplayDeviceInfoLocked();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L9:
        th = move-exception;
        throw th;
    }

    Surface getVirtualDisplaySurfaceInternal(IBinder appToken) {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mVirtualDisplayAdapter != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L11:
        Surface r1 = this.mVirtualDisplayAdapter.getVirtualDisplaySurfaceLocked(appToken);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    }

    private void initializeDisplayPowerControllersLocked() {
        this.mLogicalDisplayMapper.forEachLocked(new DisplayManagerService$$ExternalSyntheticLambda12(this));
    }

    private DisplayPowerController addDisplayPowerControllerLocked(final LogicalDisplay display) {
        if (this.mPowerHandler != null) goto L6;
        return null;
    L6:
        if (this.mBrightnessTracker == null) goto L8;
    L10:
        int userSerial = getUserManager().getUserSerialNumber(this.mContext.getUserId());
        BrightnessSetting brightnessSetting = new BrightnessSetting(userSerial, this.mPersistentDataStore, display, this.mSyncRoot);
        HighBrightnessModeMetadata hbmMetadata = this.mHighBrightnessModeMetadataMapper.getHighBrightnessModeMetadataLocked(display);
        DisplayPowerController displayPowerController = this.mInjector.getDisplayPowerController(this.mContext, null, this.mDisplayPowerCallbacks, this.mPowerHandler, this.mSensorManager, this.mDisplayBlanker, display, this.mBrightnessTracker, brightnessSetting, new DisplayManagerService$$ExternalSyntheticLambda0(this, display), hbmMetadata, this.mBootCompleted, this.mFlags);
        this.mDisplayPowerControllers.append(display.getDisplayIdLocked(), displayPowerController);
        this.mExt.setHighBrightnessModeData(display);
        return displayPowerController;
    L8:
        if (display.getDisplayIdLocked() != 0) goto L10;
        this.mBrightnessTracker = new BrightnessTracker(this.mContext, null);
        goto L10
    }

    private /* synthetic */ void lambda$addDisplayPowerControllerLocked$20(LogicalDisplay display) {
        handleBrightnessChange(display);
    }

    private void handleBrightnessChange(LogicalDisplay display) {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        sendDisplayEventIfEnabledLocked(display, 4);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private DisplayDevice getDeviceForDisplayLocked(int displayId) {
        LogicalDisplay display = this.mLogicalDisplayMapper.getDisplayLocked(displayId);
        if (display != null) goto L6;
        return null;
    L6:
        return display.getPrimaryDisplayDeviceLocked();
    }

    private BrightnessConfiguration getBrightnessConfigForDisplayWithPdsFallbackLocked(String uniqueId, int userSerial) {
        BrightnessConfiguration config = this.mPersistentDataStore.getBrightnessConfigurationForDisplayLocked(uniqueId, userSerial);
        if (config == null) goto L5;
        return config;
    L5:
        return this.mPersistentDataStore.getBrightnessConfiguration(userSerial);
    }

    void overrideSensorManager(SensorManager sensorManager) {
        SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        this.mSensorManager = sensorManager;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static boolean deferDisplayEventsWhenFrozen() {
        return true;
    }

    public DisplayManagerServiceSmtEx getSmtEx() {
        return this.mSmtEx;
    }

    public IExtDisplayManagerService getExt() {
        return this.mExt;
    }

    public IDisplayManagerExt getIExt() {
        return getExt().getIExt();
    }
}
