package com.android.server.camera;

import android.R;
import android.companion.virtualcamera.SensorOrientation;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.hardware.CameraExtensionSessionStats;
import android.hardware.CameraFeatureCombinationStats;
import android.hardware.CameraSessionStats;
import android.hardware.CameraStreamStats;
import android.hardware.ICameraService;
import android.hardware.ICameraServiceProxy;
import android.hardware.devicestate.DeviceStateManager;
import android.hardware.usb.UsbDevice;
import android.hidl.manager.V1_0.IServiceManager;
import android.media.AudioManager;
import android.nfc.NfcAdapter;
import android.nfc.NfcManager;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerExecutor;
import android.os.IBinder;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.os.ServiceDebugInfo;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.UEventObserver;
import android.os.UserManager;
import android.provider.Settings;
import android.stats.camera.nano.CameraProtos;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Log;
import android.util.Range;
import android.util.Slog;
import android.view.IDisplayWindowListener;
import android.view.WindowManagerGlobal;
import com.android.framework.protobuf.nano.MessageNano;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.LocalServices;
import com.android.server.ServiceThread;
import com.android.server.SystemServerInitThreadPool$$ExternalSyntheticLambda0;
import com.android.server.SystemService;
import com.android.server.am.StackTracesDumpHelper;
import com.android.server.wm.WindowManagerInternal;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class CameraServiceProxy extends SystemService implements Handler.Callback, IBinder.DeathRecipient {
    private static final String[] AIDL_INTERFACE_PREFIXES_OF_INTEREST = null;
    private static final String CAMERA_CRC_ERROR_KEY = "DRIVER";
    private static final String CAMERA_CRC_ERROR_UEVENT = "DEVPATH=/devices/platform/soc/soc:qcom,cam-sensorcrc";
    private static final String CAMERA_SERVICE_BINDER_NAME = "media.camera";
    public static final String CAMERA_SERVICE_PROXY_BINDER_NAME = "media.camera.proxy";
    private static final boolean DEBUG = false;
    public static final List<String> HIDL_INTERFACES_OF_INTEREST = null;
    private static final float MAX_PREVIEW_FPS = 60.0f;
    private static final int MAX_STREAM_STATISTICS = 5;
    private static final int MAX_USAGE_HISTORY = 20;
    private static final float MIN_PREVIEW_FPS = 30.0f;
    private static final int MSG_NOTIFY_DEVICE_STATE = 2;
    private static final int MSG_SWITCH_USER = 1;
    private static final String[] NATIVE_SERVICES_OF_INTEREST = null;
    private static final String NFC_NOTIFICATION_PROP = "ro.camera.notify_nfc";
    public static final long OVERRIDE_CAMERA_RESIZABLE_AND_SDK_CHECK = 191513214;
    public static final long OVERRIDE_CAMERA_ROTATE_AND_CROP_DEFAULTS = 189229956;
    private static final int RETRY_DELAY_TIME = 20;
    private static final int RETRY_TIMES = 60;
    private static final String TAG = "CameraService_proxy";
    private static final IBinder nfcInterfaceToken = null;
    private final ArrayMap<String, CameraUsageEvent> mActiveCameraUsage;
    private final List<CameraEvent> mCameraEventHistory;
    private final ICameraServiceProxy.Stub mCameraServiceProxy;
    private ICameraService mCameraServiceRaw;
    private CameraUEventObserver mCameraUEventObserver;
    private final Context mContext;
    private int mDeviceState;
    private final DisplayWindowListener mDisplayWindowListener;
    private Set<Integer> mEnabledCameraUsers;
    private final DeviceStateManager.FoldStateListener mFoldStateListener;
    private final Handler mHandler;
    private final ServiceThread mHandlerThread;
    private final BroadcastReceiver mIntentReceiver;
    private int mLastReportedDeviceState;
    private int mLastUser;
    private final Object mLock;
    private ScheduledThreadPoolExecutor mLogWriterService;
    private final boolean mNotifyNfc;
    private UserManager mUserManager;

    private interface CameraEvent {
        void logSelf();
    }

    private static class CameraFeatureCombinationQueryEvent implements CameraEvent {
        private CameraFeatureCombinationStats mFeatureCombinationStats;

        CameraFeatureCombinationQueryEvent(CameraFeatureCombinationStats featureCombinationStats) {
            this.mFeatureCombinationStats = featureCombinationStats;
        }

        @Override // com.android.server.camera.CameraServiceProxy.CameraEvent
        public void logSelf() {
            switch(this.mFeatureCombinationStats.mStatus) {
                case 0: goto L7;
                case 3: goto L6;
                case 10: goto L5;
                default: goto L4;
            };
        L4:
            int statusCode = -1;
        L9:
            if (statusCode != (-1)) goto L12;
            Slog.w(CameraServiceProxy.TAG, "Unknown feature combination query status code: " + this.mFeatureCombinationStats.mStatus);
            return;
        L12:
            FrameworkStatsLog.write(900, this.mFeatureCombinationStats.mUid, this.mFeatureCombinationStats.mCameraId, this.mFeatureCombinationStats.mQueryType, this.mFeatureCombinationStats.mFeatureCombination, statusCode);
            return;
        L5:
            statusCode = 10;
            goto L9
        L6:
            statusCode = 3;
            goto L9
        L7:
            statusCode = 0;
            goto L9
        }
    }

    private class CameraUEventObserver extends UEventObserver {
        private static final String TAG = "CameraUEventObserver";
        final /* synthetic */ CameraServiceProxy this$0;

        /* synthetic */ CameraUEventObserver(CameraServiceProxy r1, CameraServiceProxyIA r2) {
            this(r1);
        }

        private CameraUEventObserver(CameraServiceProxy r1) {
            this.this$0 = r1;
        }

        public void onUEvent(UEventObserver.UEvent event) {
            String crcErrorValue = event.get(CameraServiceProxy.CAMERA_CRC_ERROR_KEY);     // Catch: Exception -> L11
            if (crcErrorValue != null) goto L6;
            return;
        L6:
            if ("0".equals(crcErrorValue) == true) goto L19;
            Slog.w(TAG, "Camera CRC error detected: " + crcErrorValue);     // Catch: Exception -> L11
            if (crcErrorValue.equals("zte,cameracrc") == false) goto L20;
            handleCameraCrcError(crcErrorValue);     // Catch: Exception -> L11
            return;
        L20:
            return;
        L19:
            return;
        L11:
            e = move-exception;
            Slog.e(TAG, "Exception processing camera CRC uevent", e);
        }

        private void handleCameraCrcError(String errorCode) {
            Slog.i(TAG, "Handling camera CRC error with code: " + errorCode);
            ContentResolver res = CameraServiceProxy.m2849$$Nest$fgetmContext(this.this$0).getContentResolver();
            long token1 = Binder.clearCallingIdentity();
            Settings.Global.putInt(res, "modem_coex_camera_crc_error", 1);
            Binder.restoreCallingIdentity(token1);
        }
    }

    private static class CameraUsageEvent implements CameraEvent {
        public final int mAPILevel;
        public final int mAction;
        public final int mCameraFacing;
        public final String mCameraId;
        public final String mClientName;
        private boolean mCompleted;
        public boolean mDeviceError;
        private long mDurationOrStartTimeMs;
        public CameraExtensionSessionStats mExtSessionStats;
        public int mInternalReconfigure;
        public final boolean mIsNdk;
        public final int mLatencyMs;
        public final long mLogId;
        public Range<Integer> mMostRequestedFpsRange;
        public final int mOperatingMode;
        public long mRequestCount;
        public long mResultErrorCount;
        public final int mSessionIndex;
        public List<CameraStreamStats> mStreamStats;
        public boolean mUsedUltraWide;
        public boolean mUsedZoomOverride;
        public String mUserTag;
        public int mVideoStabilizationMode;

        CameraUsageEvent(String cameraId, int facing, String clientName, int apiLevel, boolean isNdk, int action, int latencyMs, int operatingMode, boolean deviceError, long logId, int sessionIdx) {
            this.mExtSessionStats = null;
            this.mCameraId = cameraId;
            this.mCameraFacing = facing;
            this.mClientName = clientName;
            this.mAPILevel = apiLevel;
            this.mDurationOrStartTimeMs = SystemClock.elapsedRealtime();
            this.mCompleted = false;
            this.mIsNdk = isNdk;
            this.mAction = action;
            this.mLatencyMs = latencyMs;
            this.mOperatingMode = operatingMode;
            this.mDeviceError = deviceError;
            this.mLogId = logId;
            this.mSessionIndex = sessionIdx;
            this.mMostRequestedFpsRange = new Range(0, 0);
        }

        public void markCompleted(int internalReconfigure, long requestCount, long resultErrorCount, boolean deviceError, List<CameraStreamStats> streamStats, String userTag, int videoStabilizationMode, boolean usedUltraWide, boolean usedZoomOverride, Range<Integer> mostRequestedFpsRange, CameraExtensionSessionStats extStats) {
            if (this.mCompleted == false) goto L5;
            return;
        L5:
            this.mCompleted = true;
            this.mDurationOrStartTimeMs = SystemClock.elapsedRealtime() - this.mDurationOrStartTimeMs;
            this.mInternalReconfigure = internalReconfigure;
            this.mRequestCount = requestCount;
            this.mResultErrorCount = resultErrorCount;
            this.mDeviceError = deviceError;
            this.mStreamStats = streamStats;
            this.mUserTag = userTag;
            this.mVideoStabilizationMode = videoStabilizationMode;
            this.mUsedUltraWide = usedUltraWide;
            this.mUsedZoomOverride = usedZoomOverride;
            this.mExtSessionStats = extStats;
            this.mMostRequestedFpsRange = mostRequestedFpsRange;
        }

        public long getDuration() {
            if (this.mCompleted == true) goto L7;
            return 0;
        L7:
            return this.mDurationOrStartTimeMs;
        }

        @Override // com.android.server.camera.CameraServiceProxy.CameraEvent
        public void logSelf() {
            switch(this.mCameraFacing) {
                case 0: goto L7;
                case 1: goto L6;
                case 2: goto L5;
                default: goto L4;
            };
        L4:
            Slog.w(CameraServiceProxy.TAG, "Unknown camera facing: " + this.mCameraFacing);
            int facing = 0;
        L8:
            int extensionType = -1;
            if (this.mExtSessionStats != null) goto L11;
            int extensionType2 = -1;
            boolean extensionIsAdvanced = false;
            int extensionCaptureFormat = 0;
        L20:
            int streamCount = 0;
            if (this.mStreamStats == null) goto L23;
            streamCount = this.mStreamStats.size();
        L23:
            CameraProtos.CameraStreamProto[] streamProtos = new CameraProtos.CameraStreamProto[5];
            int i = 0;
        L24:
            if (i >= 5) goto L29;
            streamProtos[i] = new CameraProtos.CameraStreamProto();
            if (i >= streamCount) goto L28;
            CameraStreamStats streamStats = this.mStreamStats.get(i);
            streamProtos[i].width = streamStats.getWidth();
            streamProtos[i].height = streamStats.getHeight();
            streamProtos[i].format = streamStats.getFormat();
            streamProtos[i].dataSpace = streamStats.getDataSpace();
            streamProtos[i].usage = streamStats.getUsage();
            streamProtos[i].requestCount = streamStats.getRequestCount();
            streamProtos[i].errorCount = streamStats.getErrorCount();
            streamProtos[i].firstCaptureLatencyMillis = streamStats.getStartLatencyMs();
            streamProtos[i].maxHalBuffers = streamStats.getMaxHalBuffers();
            streamProtos[i].maxAppBuffers = streamStats.getMaxAppBuffers();
            streamProtos[i].histogramType = streamStats.getHistogramType();
            streamProtos[i].histogramBins = streamStats.getHistogramBins();
            streamProtos[i].histogramCounts = streamStats.getHistogramCounts();
            streamProtos[i].dynamicRangeProfile = streamStats.getDynamicRangeProfile();
            streamProtos[i].streamUseCase = streamStats.getStreamUseCase();
            streamProtos[i].colorSpace = streamStats.getColorSpace();
        L28:
            i = i + 1;
            goto L24
        L29:
            FrameworkStatsLog.write(FrameworkStatsLog.CAMERA_ACTION_EVENT, getDuration(), this.mAPILevel, this.mClientName, facing, this.mCameraId, this.mAction, this.mIsNdk, this.mLatencyMs, this.mOperatingMode, this.mInternalReconfigure, this.mRequestCount, this.mResultErrorCount, this.mDeviceError, streamCount, MessageNano.toByteArray(streamProtos[0]), MessageNano.toByteArray(streamProtos[1]), MessageNano.toByteArray(streamProtos[2]), MessageNano.toByteArray(streamProtos[3]), MessageNano.toByteArray(streamProtos[4]), this.mUserTag, this.mVideoStabilizationMode, this.mLogId, this.mSessionIndex, extensionType2, extensionIsAdvanced, this.mUsedUltraWide, this.mUsedZoomOverride, ((Integer) this.mMostRequestedFpsRange.getLower()).intValue(), ((Integer) this.mMostRequestedFpsRange.getUpper()).intValue(), extensionCaptureFormat);
            return;
        L11:
            switch(this.mExtSessionStats.type) {
                case 0: goto L17;
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                default: goto L12;
            };
        L12:
            Slog.w(CameraServiceProxy.TAG, "Unknown extension type: " + this.mExtSessionStats.type);
        L18:
            boolean extensionIsAdvanced2 = this.mExtSessionStats.isAdvanced;
            int extensionCaptureFormat2 = this.mExtSessionStats.captureFormat;
            extensionType2 = extensionType;
            extensionIsAdvanced = extensionIsAdvanced2;
            extensionCaptureFormat = extensionCaptureFormat2;
            goto L20
        L13:
            extensionType = 4;
            goto L18
        L14:
            extensionType = 3;
            goto L18
        L15:
            extensionType = 2;
            goto L18
        L16:
            extensionType = 1;
            goto L18
        L17:
            extensionType = 0;
            goto L18
        L5:
            facing = 3;
            goto L8
        L6:
            facing = 2;
            goto L8
        L7:
            facing = 1;
            goto L8
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface DeviceStateFlags {
    }

    private final class DisplayWindowListener extends IDisplayWindowListener.Stub {
        final /* synthetic */ CameraServiceProxy this$0;

        /* synthetic */ DisplayWindowListener(CameraServiceProxy r1, CameraServiceProxyIA r2) {
            this(r1);
        }

        private DisplayWindowListener(CameraServiceProxy r1) {
            this.this$0 = r1;
        }

        public void onDisplayConfigurationChanged(int displayId, Configuration newConfig) {
            ICameraService cs = CameraServiceProxy.m2853$$Nest$mgetCameraServiceRawLocked(this.this$0);
            if (cs != null) goto L10;
            return;
        L10:
            cs.notifyDisplayConfigurationChange();     // Catch: RemoteException -> L7
            return;
        L7:
            e = move-exception;
            Slog.w(CameraServiceProxy.TAG, "Could not notify cameraserver, remote exception: " + e);
        }

        public void onDisplayAdded(int displayId) {
        }

        public void onDisplayRemoved(int displayId) {
        }

        public void onFixedRotationStarted(int displayId, int newRotation) {
        }

        public void onFixedRotationFinished(int displayId) {
        }

        public void onKeepClearAreasChanged(int displayId, List<Rect> restricted, List<Rect> unrestricted) {
        }

        public void onDesktopModeEligibleChanged(int displayId) {
        }
    }

    private class EventWriterTask implements Runnable {
        private static final long WRITER_SLEEP_MS = 100;
        private List<CameraEvent> mEventList;

        EventWriterTask(CameraServiceProxy r1, List<CameraEvent> eventList) {
            this.mEventList = eventList;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mEventList == null) goto L21;
            Iterator<CameraEvent> r0 = this.mEventList.iterator();
        L6:
            if (r0.hasNext() == false) goto L13;
            CameraEvent event = r0.next();
            event.logSelf();
            Thread.sleep(WRITER_SLEEP_MS);     // Catch: InterruptedException -> L10
            goto L6
        L13:
            this.mEventList.clear();
            return;
        }
    }

    public static final class TaskInfo {
        public int displayId;
        public int frontTaskId;
        public boolean isFixedOrientationLandscape;
        public boolean isFixedOrientationPortrait;
        public boolean isResizeable;
        public int userId;

        public TaskInfo() {
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$5G_IkwUKgH-F5subAPhsf_avzH0, reason: not valid java name */
    public static /* synthetic */ void m2848$r8$lambda$5G_IkwUKgHF5subAPhsf_avzH0(CameraServiceProxy r0, Boolean r1) {
        r0.lambda$new$0(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m2849$$Nest$fgetmContext(CameraServiceProxy r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEnabledCameraUsers, reason: not valid java name */
    static /* bridge */ /* synthetic */ Set m2850$$Nest$fgetmEnabledCameraUsers(CameraServiceProxy r0) {
        return r0.mEnabledCameraUsers;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLastUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m2851$$Nest$fgetmLastUser(CameraServiceProxy r0) {
        return r0.mLastUser;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m2852$$Nest$fgetmLock(CameraServiceProxy r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetCameraServiceRawLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ ICameraService m2853$$Nest$mgetCameraServiceRawLocked(CameraServiceProxy r0) {
        return r0.getCameraServiceRawLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyDeviceStateWithRetries, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2854$$Nest$mnotifyDeviceStateWithRetries(CameraServiceProxy r0, int r1) {
        r0.notifyDeviceStateWithRetries(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifySwitchWithRetries, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2855$$Nest$mnotifySwitchWithRetries(CameraServiceProxy r0, int r1) {
        r0.notifySwitchWithRetries(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyUsbDeviceHotplugLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2856$$Nest$mnotifyUsbDeviceHotplugLocked(CameraServiceProxy r0, UsbDevice r1, boolean r2) {
        return r0.notifyUsbDeviceHotplugLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mswitchUserLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2857$$Nest$mswitchUserLocked(CameraServiceProxy r0, int r1) {
        r0.switchUserLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateActivityCount, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2858$$Nest$mupdateActivityCount(CameraServiceProxy r0, CameraSessionStats r1) {
        r0.updateActivityCount(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateFeatureCombinationQuery, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2859$$Nest$mupdateFeatureCombinationQuery(CameraServiceProxy r0, CameraFeatureCombinationStats r1) {
        r0.updateFeatureCombinationQuery(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smcameraFacingToString, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m2860$$Nest$smcameraFacingToString(int r0) {
        return cameraFacingToString(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smcameraStateToString, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m2861$$Nest$smcameraStateToString(int r0) {
        return cameraStateToString(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smdumpStackTraces, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2862$$Nest$smdumpStackTraces(int r0, boolean r1) {
        dumpStackTraces(r0, r1);
    }

    static {
        nfcInterfaceToken = new Binder();
        NATIVE_SERVICES_OF_INTEREST = new String[]{"/system/bin/cameraserver"};
        AIDL_INTERFACE_PREFIXES_OF_INTEREST = new String[]{"android.hardware.camera.provider.ICameraProvider/"};
        HIDL_INTERFACES_OF_INTEREST = Arrays.asList(new String[]{"android.hardware.camera.provider@2.4::ICameraProvider"});
    }

    private static boolean isMOrBelow(Context ctx, String packageName) {
        if (ctx.getPackageManager().getPackageInfo(packageName, 0).applicationInfo.targetSdkVersion > 23) goto L13;
        return true;
    L13:
        return false;
    L9:
        Slog.e(TAG, "Package name not found!");
        return false;
    }

    public static int getCropRotateScale(Context ctx, String packageName, TaskInfo taskInfo, int displayRotation, int lensFacing, boolean ignoreResizableAndSdkCheck) {
        if (taskInfo != null) goto L6;
        return 0;
    L6:
        if (ctx.getResources().getBoolean(R.bool.config_knownNetworksEnabledForService) == false) goto L10;
        Slog.v(TAG, "Disable Rotate and Crop to avoid conflicts with WM force rotation treatment.");
        return 0;
    L10:
        if (lensFacing == 0) goto L14;
        if (lensFacing == 1) goto L14;
        Log.v(TAG, "lensFacing=" + lensFacing + ". Crop-rotate-scale is disabled.");
        return 0;
    L14:
        if (ignoreResizableAndSdkCheck == true) goto L22;
        if (isMOrBelow(ctx, packageName) == true) goto L22;
        if (taskInfo.isResizeable == false) goto L22;
        Slog.v(TAG, "The activity is N or above and claims to support resizeable-activity. Crop-rotate-scale is disabled.");
        return 0;
    L22:
        if (taskInfo.isFixedOrientationPortrait == false) goto L24;
    L27:
        switch(displayRotation) {
            case 0: goto L33;
            case 1: goto L32;
            case 2: goto L31;
            case 3: goto L30;
            default: goto L28;
        };
    L28:
        Log.e(TAG, "Unsupported display rotation: " + displayRotation);
        return 0;
    L30:
        int rotationDegree = SensorOrientation.ORIENTATION_270;
    L34:
        Slog.v(TAG, "Display.getRotation()=" + rotationDegree + " isFixedOrientationPortrait=" + taskInfo.isFixedOrientationPortrait + " isFixedOrientationLandscape=" + taskInfo.isFixedOrientationLandscape);
        if (rotationDegree != 0) goto L37;
        return 0;
    L37:
        if (lensFacing != 0) goto L39;
        rotationDegree = 360 - rotationDegree;
    L39:
        switch(rotationDegree) {
            case 90: goto L45;
            case 180: goto L43;
            case 270: goto L41;
            default: goto L40;
        };
    L40:
        return 0;
    L41:
        return 3;
    L43:
        return 2;
    L45:
        return 1;
    L31:
        rotationDegree = 180;
        goto L34
    L32:
        rotationDegree = 90;
        goto L34
    L33:
        rotationDegree = 0;
        goto L34
    L24:
        if (taskInfo.isFixedOrientationLandscape == true) goto L27;
        Log.v(TAG, "Non-fixed orientation activity. Crop-rotate-scale is disabled.");
        return 0;
    }

    public CameraServiceProxy(Context context) {
        super(context);
        this.mLock = new Object();
        this.mActiveCameraUsage = new ArrayMap();
        this.mCameraEventHistory = new ArrayList();
        this.mLogWriterService = new ScheduledThreadPoolExecutor(1);
        this.mDisplayWindowListener = new DisplayWindowListener(this, null);
        this.mIntentReceiver = new AnonymousClass1(this);
        this.mCameraServiceProxy = new AnonymousClass2(this);
        this.mContext = context;
        boolean r4 = false;
        this.mHandlerThread = new ServiceThread(TAG, -4, false);
        this.mHandlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper(), this);
        if (SystemProperties.getInt(NFC_NOTIFICATION_PROP, 0) <= 0) goto L5;
        r4 = true;
    L5:
        this.mNotifyNfc = r4;
        this.mLogWriterService.setKeepAliveTime(1, TimeUnit.SECONDS);
        this.mLogWriterService.allowCoreThreadTimeOut(true);
        this.mFoldStateListener = new DeviceStateManager.FoldStateListener(this.mContext, new CameraServiceProxy$$ExternalSyntheticLambda0(this));
        initCameraUeventObserver();
    }

    private /* synthetic */ void lambda$new$0(Boolean folded) {
        if (folded.booleanValue() == false) goto L5;
        setDeviceStateFlags(4);
        return;
    L5:
        clearDeviceStateFlags(4);
    }

    private void initCameraUeventObserver() {
        if (this.mCameraUEventObserver != null) goto L12;
        this.mCameraUEventObserver = new CameraUEventObserver(this, null);
        this.mCameraUEventObserver.startObserving(CAMERA_CRC_ERROR_UEVENT);     // Catch: Exception -> L7
        Slog.i(TAG, "Started observing camera CRC error uevents");     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        Slog.e(TAG, "Failed to start camera CRC error uevent observer", e);
        return;
    }

    private void stopCameraUeventObserver() {
        if (this.mCameraUEventObserver == null) goto L11;
        this.mCameraUEventObserver.stopObserving();     // Catch: Exception -> L6
        Slog.i(TAG, "Stopped observing camera CRC error uevents");     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        Slog.e(TAG, "Failed to stop camera CRC error uevent observer", e);
        return;
    }

    private void setDeviceStateFlags(int deviceStateFlags) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mHandler.removeMessages(2);     // Catch: Throwable -> L7
        this.mDeviceState |= deviceStateFlags;     // Catch: Throwable -> L7
        if (this.mDeviceState == this.mLastReportedDeviceState) goto L9;
        notifyDeviceStateWithRetriesLocked(60);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void clearDeviceStateFlags(int deviceStateFlags) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mHandler.removeMessages(2);     // Catch: Throwable -> L7
        this.mDeviceState &= ~deviceStateFlags;     // Catch: Throwable -> L7
        if (this.mDeviceState == this.mLastReportedDeviceState) goto L9;
        notifyDeviceStateWithRetriesLocked(60);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg) {
        switch(msg.what) {
            case 1: goto L6;
            case 2: goto L5;
            default: goto L4;
        };
    L4:
        Slog.e(TAG, "CameraServiceProxy error, invalid message: " + msg.what);
        return true;
    L5:
        notifyDeviceStateWithRetries(msg.arg1);
        return true;
    L6:
        notifySwitchWithRetries(msg.arg1);
        return true;
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        this.mUserManager = UserManager.get(this.mContext);
        if (this.mUserManager == null) goto L7;
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.USER_ADDED");
        filter.addAction("android.intent.action.USER_REMOVED");
        filter.addAction("android.intent.action.USER_INFO_CHANGED");
        filter.addAction("android.intent.action.MANAGED_PROFILE_ADDED");
        filter.addAction("android.intent.action.MANAGED_PROFILE_REMOVED");
        filter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
        filter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
        this.mContext.registerReceiver(this.mIntentReceiver, filter);
        publishBinderService(CAMERA_SERVICE_PROXY_BINDER_NAME, this.mCameraServiceProxy);
        publishLocalService(CameraServiceProxy.class, this);
        return;
    L7:
        throw new IllegalStateException("UserManagerService must start before CameraServiceProxy!");
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase != 1000) goto L19;
        CameraStatsJobService.schedule(this.mContext);
        int[] displayIds = WindowManagerGlobal.getWindowManagerService().registerDisplayWindowListener(this.mDisplayWindowListener);     // Catch: RemoteException -> L10
        int i = 0;
    L7:
        if (i >= displayIds.length) goto L14;
        this.mDisplayWindowListener.onDisplayAdded(displayIds[i]);     // Catch: RemoteException -> L10
        i = i + 1;
    L14:
        ((DeviceStateManager) this.mContext.getSystemService(DeviceStateManager.class)).registerCallback(new HandlerExecutor(this.mHandler), this.mFoldStateListener);
        return;
    L13:
        Log.e(TAG, "Failed to register display window listener!");
        goto L14
    }

    @Override // com.android.server.SystemService
    public void onUserStarting(SystemService.TargetUser user) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mEnabledCameraUsers != null) goto L9;
        switchUserLocked(user.getUserIdentifier());     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    @Override // com.android.server.SystemService
    public void onUserSwitching(SystemService.TargetUser from, SystemService.TargetUser to) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        switchUserLocked(to.getUserIdentifier());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void onShutdown() {
        stopCameraUeventObserver();
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mCameraServiceRaw = null;     // Catch: Throwable -> L9
        boolean wasEmpty = this.mActiveCameraUsage.isEmpty();     // Catch: Throwable -> L9
        this.mActiveCameraUsage.clear();     // Catch: Throwable -> L9
        if (this.mNotifyNfc == false) goto L11;
        if (wasEmpty == true) goto L11;
        notifyNfcService(true);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    int getUsageEventCount() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mCameraEventHistory.size();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void dumpCameraEvents() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Collections.shuffle(this.mCameraEventHistory);     // Catch: Throwable -> L13
        this.mLogWriterService.execute(new EventWriterTask(this, new ArrayList(this.mCameraEventHistory)));     // Catch: Throwable -> L13
        this.mCameraEventHistory.clear();     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        long ident = Binder.clearCallingIdentity();
        CameraStatsJobService.schedule(this.mContext);     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(ident);
        return;
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L13:
        th = move-exception;
        throw th;
    }

    private ICameraService getCameraServiceRawLocked() {
        if (this.mCameraServiceRaw != null) goto L14;
        IBinder cameraServiceBinder = getBinderService(CAMERA_SERVICE_BINDER_NAME);
        if (cameraServiceBinder != null) goto L15;
        return null;
    L15:
        cameraServiceBinder.linkToDeath(this, 0);     // Catch: RemoteException -> L10
        this.mCameraServiceRaw = ICameraService.Stub.asInterface(cameraServiceBinder);
    L11:
        Slog.w(TAG, "Could not link to death of native camera service");
        return null;
    L14:
        return this.mCameraServiceRaw;
    }

    private void switchUserLocked(int userHandle) {
        Set<Integer> currentUserHandles = getEnabledUserHandles(userHandle);
        this.mLastUser = userHandle;
        if (this.mEnabledCameraUsers != null) goto L5;
    L6:
        this.mEnabledCameraUsers = currentUserHandles;
        notifySwitchWithRetriesLocked(60);
        return;
    L5:
        if (this.mEnabledCameraUsers.equals(currentUserHandles) == false) goto L6;
    }

    private boolean isAutomotive() {
        return this.mContext.getPackageManager().hasSystemFeature("android.hardware.type.automotive");
    }

    private Set<Integer> getEnabledUserHandles(int currentUserHandle) {
        int[] userProfiles = this.mUserManager.getEnabledProfileIds(currentUserHandle);
        Set<Integer> handles = new ArraySet(userProfiles.length);
        int r2 = userProfiles.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L6;
        int id = userProfiles[r4];
        handles.add(Integer.valueOf(id));
        r4 = r4 + 1;
        goto L3
    L6:
        if (UserManager.isHeadlessSystemUserMode() == true) goto L8;
    L10:
        return handles;
    L8:
        if (isAutomotive() == false) goto L10;
        handles.add(0);
        goto L10
    }

    private void notifySwitchWithRetries(int retries) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        notifySwitchWithRetriesLocked(retries);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void notifySwitchWithRetriesLocked(int retries) {
        if (this.mEnabledCameraUsers != null) goto L6;
        return;
    L6:
        if (notifyCameraserverLocked(1, this.mEnabledCameraUsers) == false) goto L8;
        retries = 0;
    L8:
        if (retries > 0) goto L10;
        return;
    L10:
        Slog.i(TAG, "Could not notify camera service of user switch, retrying...");
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, retries - 1, 0, null), 20);
    }

    private boolean notifyCameraserverLocked(int eventType, Set<Integer> updatedUserHandles) {
        ICameraService cameraService = getCameraServiceRawLocked();
        if (cameraService != null) goto L12;
        Slog.w(TAG, "Could not notify cameraserver, camera service not available.");
        return false;
    L12:
        this.mCameraServiceRaw.notifySystemEvent(eventType, toArray(updatedUserHandles));     // Catch: RemoteException -> L9
        return true;
    L9:
        e = move-exception;
        Slog.w(TAG, "Could not notify cameraserver, remote exception: " + e);
        return false;
    }

    private void notifyDeviceStateWithRetries(int retries) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        notifyDeviceStateWithRetriesLocked(retries);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void notifyDeviceStateWithRetriesLocked(int retries) {
        if (notifyDeviceStateChangeLocked(this.mDeviceState) == false) goto L5;
        return;
    L5:
        if (retries > 0) goto L7;
        return;
    L7:
        Slog.i(TAG, "Could not notify camera service of device state change, retrying...");
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2, retries - 1, 0, null), 20);
    }

    private boolean notifyDeviceStateChangeLocked(int deviceState) {
        ICameraService cameraService = getCameraServiceRawLocked();
        if (cameraService != null) goto L12;
        Slog.w(TAG, "Could not notify cameraserver, camera service not available.");
        return false;
    L12:
        this.mCameraServiceRaw.notifyDeviceStateChange(deviceState);     // Catch: RemoteException -> L9
        this.mLastReportedDeviceState = deviceState;
        return true;
    L9:
        e = move-exception;
        Slog.w(TAG, "Could not notify cameraserver, remote exception: " + e);
        return false;
    }

    private boolean notifyUsbDeviceHotplugLocked(UsbDevice device, boolean attached) {
        if (device.getHasVideoCapture() == false) goto L18;
        ICameraService cameraService = getCameraServiceRawLocked();
        if (cameraService != null) goto L8;
        Slog.w(TAG, "Could not notify cameraserver, camera service not available.");
        return false;
    L8:
        if (attached == false) goto L10;
        int eventType = 2;
    L19:
        this.mCameraServiceRaw.notifySystemEvent(eventType, new int[]{device.getDeviceId()});     // Catch: RemoteException -> L15
        return true;
    L15:
        e = move-exception;
        Slog.w(TAG, "Could not notify cameraserver, remote exception: " + e);
        return false;
    L10:
        eventType = 3;
        goto L19
    L18:
        return false;
    }

    private float getMinFps(CameraSessionStats cameraState) {
        float maxFps = cameraState.getMaxPreviewFps();
        return Math.max(Math.min(maxFps, 60.0f), MIN_PREVIEW_FPS);
    }

    /* JADX WARN: Not initialized variable reg: 44, insn: 0x0252: MOVE (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r44 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('facing' int)]), block:B:85:0x0252 */
    private void updateActivityCount(CameraSessionStats cameraState) {
        String cameraId = cameraState.getCameraId();
        int newCameraState = cameraState.getNewCameraState();
        int facing = cameraState.getFacing();
        String clientName = cameraState.getClientName();
        int apiLevel = cameraState.getApiLevel();
        boolean isNdk = cameraState.isNdk();
        int sessionType = cameraState.getSessionType();
        int internalReconfigureCount = cameraState.getInternalReconfigureCount();
        int latencyMs = cameraState.getLatencyMs();
        long requestCount = cameraState.getRequestCount();
        long resultErrorCount = cameraState.getResultErrorCount();
        boolean deviceError = cameraState.getDeviceErrorFlag();
        List<CameraStreamStats> streamStats = cameraState.getStreamStats();
        String userTag = cameraState.getUserTag();
        int videoStabilizationMode = cameraState.getVideoStabilizationMode();
        boolean usedUltraWide = cameraState.getUsedUltraWide();
        boolean usedZoomOverride = cameraState.getUsedZoomOverride();
        long logId = cameraState.getLogId();
        int sessionIdx = cameraState.getSessionIndex();
        CameraExtensionSessionStats extSessionStats = cameraState.getExtensionSessionStats();
        Range<Integer> mostRequestedFpsRange = cameraState.getMostRequestedFpsRange();
        Object r2 = this.mLock;
        monitor-enter(r2);
        boolean wasEmpty = this.mActiveCameraUsage.isEmpty();     // Catch: Throwable -> L52
        switch(newCameraState) {
            case 0: goto L93;
            case 1: goto L54;
            case 2: goto L7;
            case 3: goto L7;
            default: goto L6;
        };     // Catch: Throwable -> L52
    L6:
        Object r41 = r2;
    L109:
        boolean isEmpty = this.mActiveCameraUsage.isEmpty();     // Catch: Throwable -> L42
        if (this.mNotifyNfc == false) goto L113;
        if (wasEmpty == isEmpty) goto L113;
        notifyNfcService(isEmpty);     // Catch: Throwable -> L42
    L113:
        monitor-exit(r41);     // Catch: Throwable -> L42
        return;
    L7:
        CameraUsageEvent doneEvent = this.mActiveCameraUsage.remove(cameraId);     // Catch: Throwable -> L52
        if (doneEvent != null) goto L130;
        String cameraId2 = cameraId;
        CameraUsageEvent doneEvent2 = doneEvent;
        int facing2 = facing;
    L33:
        if (newCameraState == 3) goto L141;
        r41 = r2;
    L49:
        if (this.mCameraEventHistory.size() <= 20) goto L109;
        dumpCameraEvents();     // Catch: Throwable -> L42
        goto L109
    L141:
        r41 = r2;
        String cameraId3 = cameraId2;
        CameraUsageEvent closeEvent = new CameraUsageEvent(cameraId3, facing2, clientName, apiLevel, isNdk, 2, latencyMs, sessionType, deviceError, logId, sessionIdx);     // Catch: Throwable -> L42
        this.mCameraEventHistory.add(closeEvent);     // Catch: Throwable -> L42
        if (cameraId3.equals("0") == true) goto L44;
        if (cameraId3.equals("4") == false) goto L49;
    L44:
        ContentResolver res = this.mContext.getContentResolver();     // Catch: Throwable -> L42
        long token1 = Binder.clearCallingIdentity();     // Catch: Throwable -> L42
        Settings.Global.putInt(res, "modem_coex_camera_rear_open_state", 0);     // Catch: Throwable -> L42
        Binder.restoreCallingIdentity(token1);     // Catch: Throwable -> L42
    L45:
        th = th;
        r41 = r2;
    L117:
        monitor-exit(r41);     // Catch: Throwable -> L42
        throw th;
    L130:
        doneEvent.markCompleted(internalReconfigureCount, requestCount, resultErrorCount, deviceError, streamStats, userTag, videoStabilizationMode, usedUltraWide, usedZoomOverride, mostRequestedFpsRange, extSessionStats);     // Catch: Throwable -> L29
        doneEvent2 = doneEvent;
        cameraId2 = cameraId;
        this.mCameraEventHistory.add(doneEvent2);     // Catch: Throwable -> L27
        deviceError = false;
        int i = 0;
    L14:
        facing2 = facing;
    L21:
        th = th;
        r41 = r2;
        goto L117
    L16:
        if (i >= this.mActiveCameraUsage.size()) goto L23;
        if (this.mActiveCameraUsage.valueAt(i).mClientName.equals(clientName) == true) goto L19;
        i = i + 1;     // Catch: Throwable -> L21
        facing = facing2;
        goto L14
    L19:
        int i2 = 1;
    L24:
        if (i2 != 0) goto L33;
        WindowManagerInternal wmi = (WindowManagerInternal) LocalServices.getService(WindowManagerInternal.class);     // Catch: Throwable -> L21
        wmi.removeRefreshRateRangeForPackage(clientName);     // Catch: Throwable -> L21
        goto L33
    L23:
        i2 = 0;
    L27:
        th = th;
        r41 = r2;
    L29:
        th = th;
        r41 = r2;
        goto L117
    L54:
        r41 = r2;
        int i3 = 0;
    L139:
    L88:
        th = th;
        goto L117
    L56:
        if (i3 >= this.mActiveCameraUsage.size()) goto L61;
        if (this.mActiveCameraUsage.valueAt(i3).mClientName.equals(clientName) == true) goto L59;
        i3 = i3 + 1;
        goto L139
    L59:
        boolean alreadyActivePackage = true;
    L62:
        if (alreadyActivePackage == false) goto L119;
        String cameraId4 = cameraId;
    L128:
        String cameraId5 = cameraId4;
        CameraUsageEvent newEvent = new CameraUsageEvent(cameraId5, facing, clientName, apiLevel, isNdk, 3, latencyMs, sessionType, deviceError, logId, sessionIdx);     // Catch: Throwable -> L88
        CameraUsageEvent oldEvent = this.mActiveCameraUsage.put(cameraId5, newEvent);     // Catch: Throwable -> L88
        if (oldEvent == null) goto L109;
        StringBuilder r3 = new StringBuilder();     // Catch: Throwable -> L88
        r3.append("Camera ");     // Catch: Throwable -> L84
        r3.append(cameraId5);     // Catch: Throwable -> L84
        r3.append(" was already marked as active");     // Catch: Throwable -> L84
        Slog.w(TAG, r3.toString());     // Catch: Throwable -> L84
        oldEvent.markCompleted(0, 0, 0, false, streamStats, "", -1, false, false, new Range(0, 0), new CameraExtensionSessionStats());     // Catch: Throwable -> L86
        this.mCameraEventHistory.add(oldEvent);     // Catch: Throwable -> L84
    L86:
        th = th;
    L91:
        th = th;
        goto L117
    L119:
        WindowManagerInternal wmi2 = (WindowManagerInternal) LocalServices.getService(WindowManagerInternal.class);     // Catch: Throwable -> L69
        float minFps = getMinFps(cameraState);     // Catch: Throwable -> L69
        cameraId4 = cameraId;
        wmi2.addRefreshRateRangeForPackage(clientName, minFps, 60.0f);     // Catch: Throwable -> L67
    L67:
        th = th;
    L69:
        th = th;
        goto L117
    L61:
        alreadyActivePackage = false;
        goto L62
    L93:
        r41 = r2;
        AudioManager audioManager = (AudioManager) getContext().getSystemService(AudioManager.class);     // Catch: Throwable -> L115
        if (audioManager == null) goto L102;
        if (facing != 0) goto L99;
        String facingStr = "back";
    L100:
        String facingParameter = "cameraFacing=" + facingStr;     // Catch: Throwable -> L84
        audioManager.setParameters(facingParameter);     // Catch: Throwable -> L84
        goto L102
    L99:
        facingStr = "front";
    L102:
        if (cameraId.equals("0") == false) goto L104;
    L105:
        ContentResolver res2 = this.mContext.getContentResolver();     // Catch: Throwable -> L115
        long token2 = Binder.clearCallingIdentity();     // Catch: Throwable -> L115
        Settings.Global.putInt(res2, "modem_coex_camera_rear_open_state", 1);     // Catch: Throwable -> L115
        Binder.restoreCallingIdentity(token2);     // Catch: Throwable -> L115
    L106:
        CameraUsageEvent openEvent = new CameraUsageEvent(cameraId, facing, clientName, apiLevel, isNdk, 1, latencyMs, sessionType, deviceError, logId, sessionIdx);     // Catch: Throwable -> L42
        this.mCameraEventHistory.add(openEvent);     // Catch: Throwable -> L42
        goto L109
    L104:
        if (cameraId.equals("4") == false) goto L106;
    L115:
        th = th;
    L84:
        th = th;
    L52:
        th = th;
        r41 = r2;
    L42:
        th = th;
        goto L117
    }

    private void updateFeatureCombinationQuery(CameraFeatureCombinationStats featureCombStats) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        CameraFeatureCombinationQueryEvent e = new CameraFeatureCombinationQueryEvent(featureCombStats);     // Catch: Throwable -> L7
        this.mCameraEventHistory.add(e);     // Catch: Throwable -> L7
        if (this.mCameraEventHistory.size() <= 20) goto L9;
        dumpCameraEvents();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void notifyNfcService(boolean enablePolling) {
        NfcManager nfcManager = (NfcManager) this.mContext.getSystemService(NfcManager.class);
        if (nfcManager != null) goto L6;
        Slog.w(TAG, "Could not connect to NFC service to notify it of camera state");
        return;
    L6:
        NfcAdapter nfcAdapter = nfcManager.getDefaultAdapter();
        if (nfcAdapter != null) goto L10;
        Slog.w(TAG, "Could not connect to NFC service to notify it of camera state");
        return;
    L10:
        nfcAdapter.setReaderModePollingEnabled(enablePolling);
    }

    private static int[] toArray(Collection<Integer> c) {
        int len = c.size();
        int[] ret = new int[len];
        int idx = 0;
        Iterator<Integer> r3 = c.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        Integer i = r3.next();
        ret[idx] = i.intValue();
        idx = idx + 1;
        goto L4
    L6:
        return ret;
    }

    private static String cameraStateToString(int newCameraState) {
        switch(newCameraState) {
            case 0: goto L11;
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L5;
            default: goto L3;
        };
    L3:
        return "CAMERA_STATE_UNKNOWN";
    L5:
        return "CAMERA_STATE_CLOSED";
    L7:
        return "CAMERA_STATE_IDLE";
    L9:
        return "CAMERA_STATE_ACTIVE";
    L11:
        return "CAMERA_STATE_OPEN";
    }

    private static String cameraFacingToString(int cameraFacing) {
        switch(cameraFacing) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L3;
        };
    L3:
        return "CAMERA_FACING_UNKNOWN";
    L5:
        return "CAMERA_FACING_EXTERNAL";
    L7:
        return "CAMERA_FACING_FRONT";
    L9:
        return "CAMERA_FACING_BACK";
    }

    private static String cameraHistogramTypeToString(int cameraHistogramType) {
        switch(cameraHistogramType) {
            case 1: goto L5;
            default: goto L3;
        };
    L3:
        return "HISTOGRAM_TYPE_UNKNOWN";
    L5:
        return "HISTOGRAM_TYPE_CAPTURE_LATENCY";
    }

    private static String cameraFeatureCombinationTypeToString(int featureCombinationType) {
        switch(featureCombinationType) {
            case 0: goto L7;
            case 1: goto L5;
            default: goto L3;
        };
    L3:
        return "FEATURE_COMBINATION_TYPE_UNKNOWN";
    L5:
        return "QUERY_SESSION_CHARACTERISTICS";
    L7:
        return "QUERY_FEATURE_COMBINATION";
    }

    private static String cameraFeatureCombinationToString(long featureCombination) {
        StringBuilder combinationStr = new StringBuilder("{");
        if ((1 & featureCombination) == 0) goto L6;
        combinationStr.append("60fps ");
    L6:
        if ((2 & featureCombination) == 0) goto L9;
        combinationStr.append("stabilization ");
    L9:
        if ((4 & featureCombination) == 0) goto L12;
        combinationStr.append("hlg10 ");
    L12:
        if ((8 & featureCombination) == 0) goto L15;
        combinationStr.append("jpeg ");
    L15:
        if ((16 & featureCombination) == 0) goto L18;
        combinationStr.append("jpeg_r ");
    L18:
        if ((32 & featureCombination) == 0) goto L20;
        combinationStr.append("4k ");
    L20:
        combinationStr.append("}");
        return combinationStr.toString();
    }

    private static void addHidlInterfacesOfInterest(Set<Integer> pids) {
        IServiceManager serviceManager = IServiceManager.getService();     // Catch: RemoteException -> L12
        ArrayList<IServiceManager.InstanceDebugInfo> dump = serviceManager.debugDump();     // Catch: RemoteException -> L12
        Iterator<IServiceManager.InstanceDebugInfo> r2 = dump.iterator();     // Catch: RemoteException -> L12
    L4:
        if (r2.hasNext() == false) goto L28;
        IServiceManager.InstanceDebugInfo info = r2.next();     // Catch: RemoteException -> L12
        if (info.pid == (-1)) goto L4;
        if (HIDL_INTERFACES_OF_INTEREST.contains(info.interfaceName) == false) goto L4;
        pids.add(Integer.valueOf(info.pid));     // Catch: RemoteException -> L12
        goto L4
    L28:
        return;
    L12:
        e = move-exception;
        Slog.w(TAG, "Remote exception while querying HIDL service manager", e);
    }

    private static boolean matchesAidlInterfacePrefixes(String[] interfacePrefixes, String interfaceName) {
        int r0 = interfacePrefixes.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        String prefix = interfacePrefixes[r2];
        if (interfaceName.startsWith(prefix) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private static void addAidlInterfacesOfInterest(Set<Integer> pids) {
        ServiceDebugInfo[] infos = ServiceManager.getServiceDebugInfo();
        if (infos != null) goto L5;
        return;
    L5:
        int r1 = infos.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L11;
        ServiceDebugInfo info = infos[r2];
        if (matchesAidlInterfacePrefixes(AIDL_INTERFACE_PREFIXES_OF_INTEREST, info.name) == false) goto L10;
        pids.add(Integer.valueOf(info.debugPid));
    L10:
        r2 = r2 + 1;
        goto L6
    }

    private static Set<Integer> getRelevantNativePids() {
        HashSet<Integer> pids = new HashSet();
        addHidlInterfacesOfInterest(pids);
        addAidlInterfacesOfInterest(pids);
        int[] nativePids = Process.getPidsForCommands(NATIVE_SERVICES_OF_INTEREST);
        if (nativePids == null) goto L8;
        int r2 = nativePids.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L8;
        int i = nativePids[r3];
        pids.add(Integer.valueOf(i));
        r3 = r3 + 1;
    L8:
        return pids;
    }

    private static void dumpStackTraces(int pid, boolean isNativePid) {
        ArrayList<Integer> dalvikPids = new ArrayList();
        ArrayList<Integer> nativePids = new ArrayList();
        if (isNativePid == false) goto L5;
        nativePids.add(Integer.valueOf(pid));
    L6:
        nativePids.addAll(getRelevantNativePids());
        StackTracesDumpHelper.dumpStackTraces(dalvikPids, null, null, CompletableFuture.completedFuture(nativePids), null, null, null, null, new SystemServerInitThreadPool$$ExternalSyntheticLambda0(), null);
        return;
    L5:
        dalvikPids.add(Integer.valueOf(pid));
        goto L6
    }
}
