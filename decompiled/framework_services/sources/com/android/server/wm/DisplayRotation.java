package com.android.server.wm;

import android.R;
import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.pico.utils.ExtImplFactory;
import android.provider.Settings;
import android.util.ArraySet;
import android.util.RotationUtils;
import android.util.Slog;
import android.util.TimeUtils;
import android.util.proto.ProtoOutputStream;
import android.view.Display;
import android.view.DisplayAddress;
import android.view.Surface;
import android.window.TransitionRequestInfo;
import android.window.WindowContainerTransaction;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.server.SysOptBridge;
import com.android.server.UiThread;
import com.android.server.policy.WindowManagerPolicy;
import com.android.server.statusbar.StatusBarManagerInternal;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class DisplayRotation {
    private static final String ACTION_WIFI_DISPLAY_VIDEO = "org.codeaurora.intent.action.WIFI_DISPLAY_VIDEO";
    private static final int ALLOW_ALL_ROTATIONS_DISABLED = 0;
    private static final int ALLOW_ALL_ROTATIONS_ENABLED = 1;
    private static final int ALLOW_ALL_ROTATIONS_UNDEFINED = -1;
    private static final int CAMERA_ROTATION_DISABLED = 0;
    private static final int CAMERA_ROTATION_ENABLED = 1;
    private static final int FOLDING_RECOMPUTE_CONFIG_DELAY_MS = 800;
    private static final int ROTATION_UNDEFINED = -1;
    private static final String TAG = "WindowManager";
    private static final String WIFI_DISPLAY_PERMISSION = "com.qualcomm.permission.wfd.QC_WFD";
    private final boolean isBuiltin;
    public final boolean isDefaultDisplay;
    private int mAllowAllRotations;
    private final boolean mAllowRotationResolver;
    private boolean mAllowSeamlessRotationDespiteNavBarMoving;
    private int mCameraRotationMode;
    private final int mCarDockRotation;
    private final DisplayRotationImmersiveAppCompatPolicy mCompatPolicyForImmersiveApps;
    private final Context mContext;
    private int mCurrentAppOrientation;
    final Runnable mDefaultDisplayRotationChangedCallback;
    private boolean mDefaultFixedToUserRotation;
    private int mDeferredRotationPauseCount;
    private int mDemoHdmiRotation;
    private boolean mDemoHdmiRotationLock;
    private int mDemoRotation;
    private boolean mDemoRotationLock;
    private final int mDeskDockRotation;
    private DeviceStateAutoRotateSettingController mDeviceStateAutoRotateSettingController;
    private final DeviceStateController mDeviceStateController;
    private final DisplayContent mDisplayContent;
    private final DisplayPolicy mDisplayPolicy;
    private final DisplayRotationCoordinator mDisplayRotationCoordinator;
    private final DisplayWindowSettings mDisplayWindowSettings;
    IExtDisplayRotation mExt;
    private int mFixedToUserRotation;
    final FoldController mFoldController;
    int mLandscapeRotation;
    private int mLastOrientation;
    int mLastSensorRotation;
    private final int mLidOpenRotation;
    private final Object mLock;
    private OrientationListener mOrientationListener;
    int mPortraitRotation;
    private int mRotation;
    private int mRotationChoiceShownToUserForConfirmation;
    private final RotationHistory mRotationHistory;
    private final RotationLockHistory mRotationLockHistory;
    int mSeascapeRotation;
    private final WindowManagerService mService;
    private SettingsObserver mSettingsObserver;
    private int mShowRotationSuggestions;
    private final boolean mSupportAutoRotation;
    private final int mUndockedHdmiRotation;
    int mUpsideDownRotation;
    private int mUserRotation;
    private int mUserRotationMode;
    private boolean mWifiDisplayConnected;
    private int mWifiDisplayRotation;
    private final boolean overrideMirroring;

    @Retention(RetentionPolicy.SOURCE)
    private @interface AllowAllRotations {
    }

    class FoldController {
        private final Runnable mActivityBoundsUpdateCallback;
        private final boolean mAllowHalfFoldAutoRotationOverride;
        private DeviceStateController.DeviceState mDeviceState;
        private int mDisplaySwitchRotationBlockTimeMs;
        private int mHalfFoldSavedRotation;
        private int mHingeAngleRotationBlockTimeMs;
        private SensorEventListener mHingeAngleSensorEventListener;
        private boolean mInHalfFoldTransition;
        private final boolean mIsDisplayAlwaysSeparatingHinge;
        private long mLastDisplaySwitchTime;
        private long mLastHingeAngleEventTime;
        private int mMaxHingeAngle;
        private final boolean mPauseAutorotationDuringUnfolding;
        private SensorManager mSensorManager;
        private boolean mShouldDisableRotationSensor;
        private boolean mShouldIgnoreSensorRotation;
        private final Set<Integer> mTabletopRotations;
        final /* synthetic */ DisplayRotation this$0;

        /* JADX INFO: renamed from: com.android.server.wm.DisplayRotation$FoldController$1, reason: invalid class name */
        class AnonymousClass1 implements Runnable {
            final /* synthetic */ FoldController this$1;
            final /* synthetic */ DisplayRotation val$this$0;

            /* JADX INFO: renamed from: $r8$lambda$C6W7vAoGNpW3vWiUHZ-lRgUXqqU, reason: not valid java name */
            public static /* synthetic */ boolean m9978$r8$lambda$C6W7vAoGNpW3vWiUHZlRgUXqqU(Task r0) {
                return lambda$run$0(r0);
            }

            AnonymousClass1(FoldController this$1, DisplayRotation r2) {
                this.this$1 = this$1;
                this.val$this$0 = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (FoldController.m9970$$Nest$fgetmDeviceState(this.this$1) != DeviceStateController.DeviceState.OPEN) goto L5;
            L6:
                Object r0 = DisplayRotation.m9955$$Nest$fgetmLock(this.this$1.this$0);
                monitor-enter(r0);
                Task topFullscreenTask = DisplayRotation.m9953$$Nest$fgetmDisplayContent(this.this$1.this$0).getTask(new DisplayRotation$FoldController$1$$ExternalSyntheticLambda0());     // Catch: Throwable -> L13
                if (topFullscreenTask == null) goto L15;
                ActivityRecord top = topFullscreenTask.topRunningActivity();     // Catch: Throwable -> L13
                if (top == null) goto L15;
                top.recomputeConfiguration();     // Catch: Throwable -> L13
            L15:
                monitor-exit(r0);     // Catch: Throwable -> L13
                return;
            L13:
                th = move-exception;
                throw th;
            L5:
                if (FoldController.m9970$$Nest$fgetmDeviceState(this.this$1) == DeviceStateController.DeviceState.HALF_FOLDED) goto L6;
            }

            private static /* synthetic */ boolean lambda$run$0(Task t) {
                if (t.getWindowingMode() == 1) goto L7;
                return false;
            L7:
                return true;
            }
        }

        /* JADX INFO: renamed from: $r8$lambda$9bgUwXUoqn8GF98MKx-Q46Qwu68, reason: not valid java name */
        public static /* synthetic */ void m9969$r8$lambda$9bgUwXUoqn8GF98MKxQ46Qwu68(FoldController r0) {
            r0.lambda$onHingeAngleChanged$1();
        }

        public static /* synthetic */ void $r8$lambda$ObUw2FMm1SL07uvWjAcUVxeiG3M(FoldController r0) {
            r0.lambda$onPhysicalDisplayChanged$0();
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmDeviceState, reason: not valid java name */
        static /* bridge */ /* synthetic */ DeviceStateController.DeviceState m9970$$Nest$fgetmDeviceState(FoldController r0) {
            return r0.mDeviceState;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmHalfFoldSavedRotation, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m9971$$Nest$fgetmHalfFoldSavedRotation(FoldController r0) {
            return r0.mHalfFoldSavedRotation;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmInHalfFoldTransition, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m9972$$Nest$fgetmInHalfFoldTransition(FoldController r0) {
            return r0.mInHalfFoldTransition;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmLastDisplaySwitchTime, reason: not valid java name */
        static /* bridge */ /* synthetic */ long m9973$$Nest$fgetmLastDisplaySwitchTime(FoldController r2) {
            return r2.mLastDisplaySwitchTime;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmLastHingeAngleEventTime, reason: not valid java name */
        static /* bridge */ /* synthetic */ long m9974$$Nest$fgetmLastHingeAngleEventTime(FoldController r2) {
            return r2.mLastHingeAngleEventTime;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmPauseAutorotationDuringUnfolding, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m9975$$Nest$fgetmPauseAutorotationDuringUnfolding(FoldController r0) {
            return r0.mPauseAutorotationDuringUnfolding;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmShouldDisableRotationSensor, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m9976$$Nest$fgetmShouldDisableRotationSensor(FoldController r0) {
            return r0.mShouldDisableRotationSensor;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmShouldIgnoreSensorRotation, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m9977$$Nest$fgetmShouldIgnoreSensorRotation(FoldController r0) {
            return r0.mShouldIgnoreSensorRotation;
        }

        FoldController(DisplayRotation this$0) {
            this.this$0 = this$0;
            this.mHalfFoldSavedRotation = -1;
            this.mDeviceState = DeviceStateController.DeviceState.UNKNOWN;
            this.mLastHingeAngleEventTime = 0;
            this.mLastDisplaySwitchTime = 0;
            this.mInHalfFoldTransition = false;
            this.mAllowHalfFoldAutoRotationOverride = DisplayRotation.m9952$$Nest$fgetmContext(this$0).getResources().getBoolean(R.bool.euicc_optimize_apdu_sender);
            this.mTabletopRotations = new ArraySet();
            int[] tabletop_rotations = DisplayRotation.m9952$$Nest$fgetmContext(this$0).getResources().getIntArray(R.array.config_displayWhiteBalanceDisplaySteps);
            if (tabletop_rotations == null) goto L18;
            int r3 = tabletop_rotations.length;
            int r4 = 0;
        L6:
            if (r4 >= r3) goto L20;
            int angle = tabletop_rotations[r4];
            switch(angle) {
                case 0: goto L15;
                case 90: goto L14;
                case 180: goto L13;
                case 270: goto L12;
                default: goto L10;
            };
        L12:
            this.mTabletopRotations.add(3);
        L16:
            r4 = r4 + 1;
            goto L6
        L13:
            this.mTabletopRotations.add(2);
            goto L16
        L14:
            this.mTabletopRotations.add(1);
            goto L16
        L15:
            this.mTabletopRotations.add(0);
            goto L16
        L10:
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ORIENTATION_enabled[4] == false) goto L16;
            long protoLogParam0 = angle;
            ProtoLogImpl_798997914.e(WmProtoLogGroups.WM_DEBUG_ORIENTATION, 5325136615007859122L, 1, new Object[]{Long.valueOf(protoLogParam0)});
        L20:
            this.mIsDisplayAlwaysSeparatingHinge = DisplayRotation.m9952$$Nest$fgetmContext(this$0).getResources().getBoolean(R.bool.config_keepDreamingWhenUnplugging);
            this.mActivityBoundsUpdateCallback = new AnonymousClass1(this, this$0);
            this.mPauseAutorotationDuringUnfolding = DisplayRotation.m9952$$Nest$fgetmContext(this$0).getResources().getBoolean(R.bool.ignore_emergency_number_routing_from_db);
            if (this.mPauseAutorotationDuringUnfolding == false) goto L31;
            this.mDisplaySwitchRotationBlockTimeMs = DisplayRotation.m9952$$Nest$fgetmContext(this$0).getResources().getInteger(R.integer.config_previousVibrationsDumpSizeLimit);
            this.mHingeAngleRotationBlockTimeMs = DisplayRotation.m9952$$Nest$fgetmContext(this$0).getResources().getInteger(R.integer.config_progressTimeoutFallbackHome);
            this.mMaxHingeAngle = DisplayRotation.m9952$$Nest$fgetmContext(this$0).getResources().getInteger(R.integer.config_radioScanningTimeout);
            registerSensorManager();
            return;
        L31:
            return;
        L18:
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ORIENTATION_enabled[3] == false) goto L20;
            ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_DEBUG_ORIENTATION, 4616480353797749295L, 0, null);
            goto L20
        }

        private void registerSensorManager() {
            this.mSensorManager = (SensorManager) DisplayRotation.m9952$$Nest$fgetmContext(this.this$0).getSystemService(SensorManager.class);
            if (this.mSensorManager == null) goto L8;
            Sensor hingeAngleSensor = this.mSensorManager.getDefaultSensor(36);
            if (hingeAngleSensor == null) goto L9;
            this.mHingeAngleSensorEventListener = new AnonymousClass2(this);
            this.mSensorManager.registerListener(this.mHingeAngleSensorEventListener, hingeAngleSensor, 0, this.this$0.getHandler());
            return;
        L9:
            return;
        }

        void onDisplayRemoved() {
            if (this.mSensorManager != null) goto L5;
            return;
        L5:
            if (this.mHingeAngleSensorEventListener == null) goto L9;
            this.mSensorManager.unregisterListener(this.mHingeAngleSensorEventListener);
            return;
        }

        boolean isDeviceInPosture(DeviceStateController.DeviceState state, boolean isTabletop) {
            if (state == this.mDeviceState) goto L6;
            return false;
        L6:
            if (this.mDeviceState == DeviceStateController.DeviceState.HALF_FOLDED) goto L8;
            return true;
        L8:
            if (isTabletop == this.mTabletopRotations.contains(Integer.valueOf(DisplayRotation.m9957$$Nest$fgetmRotation(this.this$0)))) goto L10;
            return false;
        L10:
            return true;
        }

        DeviceStateController.DeviceState getFoldState() {
            return this.mDeviceState;
        }

        boolean isSeparatingHinge() {
            if (this.mDeviceState != DeviceStateController.DeviceState.HALF_FOLDED) goto L5;
        L10:
            return true;
        L5:
            if (this.mDeviceState == DeviceStateController.DeviceState.OPEN) goto L7;
        L9:
            return false;
        L7:
            if (this.mIsDisplayAlwaysSeparatingHinge == false) goto L9;
            goto L9
        }

        boolean overrideFrozenRotation() {
            if (this.mAllowHalfFoldAutoRotationOverride == true) goto L5;
        L7:
            return false;
        L5:
            if (this.mDeviceState != DeviceStateController.DeviceState.HALF_FOLDED) goto L7;
            return true;
        }

        boolean shouldRevertOverriddenRotation() {
            if (this.mAllowHalfFoldAutoRotationOverride == true) goto L5;
        L15:
            return false;
        L5:
            if (this.mDeviceState != DeviceStateController.DeviceState.OPEN) goto L15;
            if (this.mShouldIgnoreSensorRotation == true) goto L15;
            if (this.mInHalfFoldTransition == false) goto L15;
            if (DisplayRotation.m9953$$Nest$fgetmDisplayContent(this.this$0).getRotationReversionController().isOverrideActive(2) == false) goto L15;
            if (DisplayRotation.m9960$$Nest$fgetmUserRotationMode(this.this$0) != 1) goto L15;
            return true;
        }

        int revertOverriddenRotation() {
            int savedRotation = this.mHalfFoldSavedRotation;
            this.mHalfFoldSavedRotation = -1;
            DisplayRotation.m9953$$Nest$fgetmDisplayContent(this.this$0).getRotationReversionController().revertOverride(2);
            this.mInHalfFoldTransition = false;
            return savedRotation;
        }

        void foldStateChanged(DeviceStateController.DeviceState newState) {
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ORIENTATION_enabled[1] == false) goto L6;
            long protoLogParam0 = DisplayRotation.m9953$$Nest$fgetmDisplayContent(this.this$0).getDisplayId();
            String protoLogParam1 = String.valueOf(newState.name());
            long protoLogParam2 = this.mHalfFoldSavedRotation;
            long protoLogParam3 = DisplayRotation.m9959$$Nest$fgetmUserRotation(this.this$0);
            long protoLogParam4 = this.this$0.mLastSensorRotation;
            long protoLogParam5 = DisplayRotation.m9954$$Nest$fgetmLastOrientation(this.this$0);
            long protoLogParam6 = DisplayRotation.m9957$$Nest$fgetmRotation(this.this$0);
            ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ORIENTATION, 8852346340572084230L, 5457, new Object[]{Long.valueOf(protoLogParam0), protoLogParam1, Long.valueOf(protoLogParam2), Long.valueOf(protoLogParam3), Long.valueOf(protoLogParam4), Long.valueOf(protoLogParam5), Long.valueOf(protoLogParam6)});
        L6:
            if (this.mDeviceState != DeviceStateController.DeviceState.UNKNOWN) goto L10;
            this.mDeviceState = newState;
            return;
        L10:
            if (newState == DeviceStateController.DeviceState.HALF_FOLDED) goto L12;
        L14:
            this.mInHalfFoldTransition = true;
            this.mDeviceState = newState;
            DisplayRotation.m9958$$Nest$fgetmService(this.this$0).updateRotation(false, false);
        L15:
            UiThread.getHandler().removeCallbacks(this.mActivityBoundsUpdateCallback);
            UiThread.getHandler().postDelayed(this.mActivityBoundsUpdateCallback, 800);
            return;
        L12:
            if (this.mDeviceState == DeviceStateController.DeviceState.HALF_FOLDED) goto L14;
            DisplayRotation.m9953$$Nest$fgetmDisplayContent(this.this$0).getRotationReversionController().beforeOverrideApplied(2);
            this.mHalfFoldSavedRotation = DisplayRotation.m9957$$Nest$fgetmRotation(this.this$0);
            this.mDeviceState = newState;
            DisplayRotation.m9958$$Nest$fgetmService(this.this$0).updateRotation(false, false);
            goto L15
        }

        boolean shouldIgnoreSensorRotation() {
            return this.mShouldIgnoreSensorRotation;
        }

        boolean shouldDisableRotationSensor() {
            return this.mShouldDisableRotationSensor;
        }

        private void updateSensorRotationBlockIfNeeded() {
            long currentTime = this.this$0.uptimeMillis();
            if ((currentTime - this.mLastDisplaySwitchTime) >= this.mDisplaySwitchRotationBlockTimeMs) goto L5;
        L8:
            boolean newShouldIgnoreRotation = true;
        L10:
            if (newShouldIgnoreRotation == this.mShouldIgnoreSensorRotation) goto L18;
            this.mShouldIgnoreSensorRotation = newShouldIgnoreRotation;
            if (this.mShouldIgnoreSensorRotation == false) goto L14;
            return;
        L14:
            if (this.mShouldDisableRotationSensor == false) goto L16;
            this.mShouldDisableRotationSensor = false;
            DisplayRotation.m9967$$Nest$mupdateOrientationListenerLw(this.this$0);
            return;
        L16:
            this.this$0.updateRotationAndSendNewConfigIfChanged();
            return;
        L18:
            return;
        L5:
            if ((currentTime - this.mLastHingeAngleEventTime) < this.mHingeAngleRotationBlockTimeMs) goto L8;
            newShouldIgnoreRotation = false;
            goto L10
        }

        void onPhysicalDisplayChanged() {
            if (this.mPauseAutorotationDuringUnfolding == true) goto L5;
            return;
        L5:
            this.mLastDisplaySwitchTime = this.this$0.uptimeMillis();
            if (this.mDeviceState != DeviceStateController.DeviceState.OPEN) goto L8;
        L11:
            boolean isUnfolding = true;
        L12:
            if (isUnfolding == false) goto L14;
            this.mShouldDisableRotationSensor = true;
            DisplayRotation.m9967$$Nest$mupdateOrientationListenerLw(this.this$0);
        L14:
            updateSensorRotationBlockIfNeeded();
            this.this$0.getHandler().postDelayed(new DisplayRotation$FoldController$$ExternalSyntheticLambda1(this), this.mDisplaySwitchRotationBlockTimeMs);
            return;
        L8:
            if (this.mDeviceState == DeviceStateController.DeviceState.HALF_FOLDED) goto L11;
            isUnfolding = false;
            goto L12
        }

        private /* synthetic */ void lambda$onPhysicalDisplayChanged$0() {
            Object r0 = DisplayRotation.m9955$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            updateSensorRotationBlockIfNeeded();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        void onHingeAngleChanged(float hingeAngle) {
            if (hingeAngle >= this.mMaxHingeAngle) goto L6;
            this.mLastHingeAngleEventTime = this.this$0.uptimeMillis();
            updateSensorRotationBlockIfNeeded();
            this.this$0.getHandler().postDelayed(new DisplayRotation$FoldController$$ExternalSyntheticLambda0(this), this.mHingeAngleRotationBlockTimeMs);
            return;
        }

        private /* synthetic */ void lambda$onHingeAngleChanged$1() {
            Object r0 = DisplayRotation.m9955$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            updateSensorRotationBlockIfNeeded();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private class OrientationListener extends WindowOrientationListener implements Runnable {
        transient boolean mEnabled;
        final /* synthetic */ DisplayRotation this$0;

        OrientationListener(DisplayRotation r1, Context context, Handler handler, int defaultRotation) {
            this.this$0 = r1;
            super(context, handler, defaultRotation);
        }

        @Override // com.android.server.wm.WindowOrientationListener
        public boolean isKeyguardShowingAndNotOccluded() {
            return DisplayRotation.m9958$$Nest$fgetmService(this.this$0).isKeyguardShowingAndNotOccluded();
        }

        @Override // com.android.server.wm.WindowOrientationListener
        public boolean isRotationResolverEnabled() {
            if (DisplayRotation.m9950$$Nest$fgetmAllowRotationResolver(this.this$0) == true) goto L5;
        L11:
            return false;
        L5:
            if (DisplayRotation.m9960$$Nest$fgetmUserRotationMode(this.this$0) != 0) goto L11;
            if (DisplayRotation.m9951$$Nest$fgetmCameraRotationMode(this.this$0) != 1) goto L11;
            if (DisplayRotation.m9958$$Nest$fgetmService(this.this$0).mPowerManager.isPowerSaveMode() == true) goto L11;
            return true;
        }

        @Override // com.android.server.wm.WindowOrientationListener
        public void onProposedRotationChanged(int rotation) {
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ORIENTATION_enabled[1] == false) goto L6;
            long protoLogParam0 = rotation;
            ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ORIENTATION, -8674269704471038429L, 1, new Object[]{Long.valueOf(protoLogParam0)});
        L6:
            if (this.this$0.mExt.onProposedRotationChanged(DisplayRotation.m9952$$Nest$fgetmContext(this.this$0), rotation) == false) goto L8;
            return;
        L8:
            DisplayRotation.m9958$$Nest$fgetmService(this.this$0).mPowerManagerInternal.setPowerBoost(0, 0);
            this.this$0.dispatchProposedRotation(rotation);
            if (DisplayRotation.m9964$$Nest$misRotationChoiceAllowed(this.this$0, rotation) == false) goto L11;
            DisplayRotation.m9961$$Nest$fputmRotationChoiceShownToUserForConfirmation(this.this$0, rotation);
            boolean isValid = DisplayRotation.m9965$$Nest$misValidRotationChoice(this.this$0, rotation);
            DisplayRotation.m9966$$Nest$msendProposedRotationChangeToStatusBarInternal(this.this$0, rotation, isValid);
            return;
        L11:
            DisplayRotation.m9961$$Nest$fputmRotationChoiceShownToUserForConfirmation(this.this$0, -1);
            DisplayRotation.m9958$$Nest$fgetmService(this.this$0).updateRotation(false, false);
        }

        @Override // com.android.server.wm.WindowOrientationListener
        public void enable() {
            this.mEnabled = true;
            getHandler().post(this);
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ORIENTATION_enabled[1] == false) goto L6;
            ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ORIENTATION, 418312772547457152L, 0, null);
            return;
        }

        @Override // com.android.server.wm.WindowOrientationListener
        public void disable() {
            this.mEnabled = false;
            getHandler().post(this);
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ORIENTATION_enabled[1] == false) goto L6;
            ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ORIENTATION, 4641814558273780952L, 0, null);
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mEnabled == false) goto L5;
            super.enable();
            return;
        L5:
            super.disable();
        }
    }

    private static class RotationHistory {
        private static final int MAX_SIZE = 8;
        private static final int NO_FOLD_CONTROLLER = -2;
        final ArrayDeque<Record> mRecords;

        private static class Record {
            final DeviceStateController.DeviceState mDeviceState;
            final String mDisplayRotationCompatPolicySummary;
            final int mFromRotation;
            final int mHalfFoldSavedRotation;
            final boolean mIgnoreOrientationRequest;
            final boolean mInHalfFoldTransition;
            final String mLastOrientationSource;
            final String mNonDefaultRequestingTaskDisplayArea;
            final boolean[] mRotationReversionSlots;
            final int mSensorRotation;
            final int mSourceOrientation;
            final long mTimestamp;
            final int mToRotation;
            final int mUserRotation;
            final int mUserRotationMode;

            Record(DisplayRotation dr, int fromRotation, int toRotation) {
                this.mTimestamp = System.currentTimeMillis();
                this.mFromRotation = fromRotation;
                this.mToRotation = toRotation;
                this.mUserRotation = DisplayRotation.m9959$$Nest$fgetmUserRotation(dr);
                this.mUserRotationMode = DisplayRotation.m9960$$Nest$fgetmUserRotationMode(dr);
                OrientationListener listener = DisplayRotation.m9956$$Nest$fgetmOrientationListener(dr);
                if (listener != null) goto L5;
            L8:
                int r2 = -2;
            L9:
                this.mSensorRotation = r2;
                DisplayContent dc = DisplayRotation.m9953$$Nest$fgetmDisplayContent(dr);
                this.mIgnoreOrientationRequest = dc.getIgnoreOrientationRequest();
                TaskDisplayArea requestingTda = dc.getOrientationRequestingTaskDisplayArea();
                if (requestingTda != null) goto L13;
                String r5 = "none";
            L16:
                this.mNonDefaultRequestingTaskDisplayArea = r5;
                WindowContainer<?> source = dc.getLastOrientationSource();
                if (source == null) goto L23;
                this.mLastOrientationSource = source.toString();
                WindowState w = source.asWindowState();
                if (w == null) goto L21;
                int r6 = w.mAttrs.screenOrientation;
            L22:
                this.mSourceOrientation = r6;
            L25:
                if (dr.mFoldController == null) goto L27;
                this.mHalfFoldSavedRotation = FoldController.m9971$$Nest$fgetmHalfFoldSavedRotation(dr.mFoldController);
                this.mInHalfFoldTransition = FoldController.m9972$$Nest$fgetmInHalfFoldTransition(dr.mFoldController);
                this.mDeviceState = FoldController.m9970$$Nest$fgetmDeviceState(dr.mFoldController);
            L28:
                this.mDisplayRotationCompatPolicySummary = dc.mAppCompatCameraPolicy.getSummaryForDisplayRotationHistoryRecord();
                this.mRotationReversionSlots = DisplayRotation.m9953$$Nest$fgetmDisplayContent(dr).getRotationReversionController().getSlotsCopy();
                return;
            L27:
                this.mHalfFoldSavedRotation = -2;
                this.mInHalfFoldTransition = false;
                this.mDeviceState = DeviceStateController.DeviceState.UNKNOWN;
                goto L28
            L21:
                r6 = source.getOverrideOrientation();
                goto L22
            L23:
                this.mLastOrientationSource = null;
                this.mSourceOrientation = -2;
                goto L25
            L13:
                if (requestingTda == dc.getDefaultTaskDisplayArea()) goto L15;
                r5 = requestingTda.toString();
                goto L16
            L15:
                r5 = null;
                goto L16
            L5:
                if (listener.mEnabled == false) goto L8;
                r2 = dr.mLastSensorRotation;
                goto L9
            }

            void dump(String prefix, PrintWriter pw) {
                pw.println(prefix + TimeUtils.logTimeOfDay(this.mTimestamp) + " " + Surface.rotationToString(this.mFromRotation) + " to " + Surface.rotationToString(this.mToRotation));
                StringBuilder r0 = new StringBuilder();
                r0.append(prefix);
                r0.append("  source=");
                r0.append(this.mLastOrientationSource);
                r0.append(" ");
                r0.append(ActivityInfo.screenOrientationToString(this.mSourceOrientation));
                pw.println(r0.toString());
                pw.println(prefix + "  mode=" + WindowManagerPolicy.userRotationModeToString(this.mUserRotationMode) + " user=" + Surface.rotationToString(this.mUserRotation) + " sensor=" + Surface.rotationToString(this.mSensorRotation));
                if (this.mIgnoreOrientationRequest == false) goto L6;
                pw.println(prefix + "  ignoreRequest=true");
            L6:
                if (this.mNonDefaultRequestingTaskDisplayArea == null) goto L9;
                pw.println(prefix + "  requestingTda=" + this.mNonDefaultRequestingTaskDisplayArea);
            L9:
                if (this.mHalfFoldSavedRotation == (-2)) goto L12;
                pw.println(prefix + " halfFoldSavedRotation=" + this.mHalfFoldSavedRotation + " mInHalfFoldTransition=" + this.mInHalfFoldTransition + " mFoldState=" + this.mDeviceState);
            L12:
                if (this.mDisplayRotationCompatPolicySummary == null) goto L15;
                pw.println(prefix + this.mDisplayRotationCompatPolicySummary);
            L15:
                if (this.mRotationReversionSlots == null) goto L18;
                pw.println(prefix + " reversionSlots= NOSENSOR " + this.mRotationReversionSlots[0] + ", CAMERA " + this.mRotationReversionSlots[1] + " HALF_FOLD " + this.mRotationReversionSlots[2]);
                return;
            }
        }

        /* synthetic */ RotationHistory(DisplayRotationIA r1) {
            this();
        }

        private RotationHistory() {
            this.mRecords = new ArrayDeque(8);
        }

        void addRecord(DisplayRotation dr, int toRotation) {
            if (this.mRecords.size() < 8) goto L5;
            this.mRecords.removeFirst();
        L5:
            int fromRotation = DisplayRotation.m9953$$Nest$fgetmDisplayContent(dr).getWindowConfiguration().getRotation();
            this.mRecords.addLast(new Record(dr, fromRotation, toRotation));
        }
    }

    private static class RotationLockHistory {
        private static final int MAX_SIZE = 8;
        private final ArrayDeque<Record> mRecords;

        private static class Record {
            final String mCaller;
            final long mTimestamp;
            final int mUserRotation;
            final int mUserRotationMode;

            /* synthetic */ Record(int r1, int r2, String r3, DisplayRotationIA r4) {
                this(r1, r2, r3);
            }

            private Record(int userRotationMode, int userRotation, String caller) {
                this.mTimestamp = System.currentTimeMillis();
                this.mUserRotationMode = userRotationMode;
                this.mUserRotation = userRotation;
                this.mCaller = caller;
            }

            void dump(String prefix, PrintWriter pw) {
                pw.println(prefix + TimeUtils.logTimeOfDay(this.mTimestamp) + ": mode=" + WindowManagerPolicy.userRotationModeToString(this.mUserRotationMode) + ", rotation=" + Surface.rotationToString(this.mUserRotation) + ", caller=" + this.mCaller);
            }
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmRecords, reason: not valid java name */
        static /* bridge */ /* synthetic */ ArrayDeque m9979$$Nest$fgetmRecords(RotationLockHistory r0) {
            return r0.mRecords;
        }

        /* synthetic */ RotationLockHistory(DisplayRotationIA r1) {
            this();
        }

        private RotationLockHistory() {
            this.mRecords = new ArrayDeque(8);
        }

        void addRecord(int userRotationMode, int userRotation, String caller) {
            if (this.mRecords.size() < 8) goto L5;
            this.mRecords.removeFirst();
        L5:
            this.mRecords.addLast(new Record(userRotationMode, userRotation, caller, null));
        }
    }

    private class SettingsObserver extends ContentObserver {
        final /* synthetic */ DisplayRotation this$0;

        SettingsObserver(DisplayRotation r1, Handler handler) {
            this.this$0 = r1;
            super(handler);
        }

        void observe() {
            ContentResolver resolver = DisplayRotation.m9952$$Nest$fgetmContext(this.this$0).getContentResolver();
            resolver.registerContentObserver(Settings.Secure.getUriFor("show_rotation_suggestions"), false, this, -1);
            resolver.registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this, -1);
            resolver.registerContentObserver(Settings.System.getUriFor("user_rotation"), false, this, -1);
            resolver.registerContentObserver(Settings.Secure.getUriFor("camera_autorotate"), false, this, -1);
            DisplayRotation.m9968$$Nest$mupdateSettings(this.this$0);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange) {
            if (DisplayRotation.m9968$$Nest$mupdateSettings(this.this$0) == false) goto L6;
            DisplayRotation.m9958$$Nest$fgetmService(this.this$0).updateRotation(false, false);
            return;
        }
    }

    public static /* synthetic */ void $r8$lambda$ChUl1_ejh2U0f8FeCVay5UYuYWg(DisplayRotation r0, int r1, WindowContainerTransaction r2) {
        r0.lambda$startRemoteRotation$0(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAllowRotationResolver, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9950$$Nest$fgetmAllowRotationResolver(DisplayRotation r0) {
        return r0.mAllowRotationResolver;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCameraRotationMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m9951$$Nest$fgetmCameraRotationMode(DisplayRotation r0) {
        return r0.mCameraRotationMode;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m9952$$Nest$fgetmContext(DisplayRotation r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDisplayContent, reason: not valid java name */
    static /* bridge */ /* synthetic */ DisplayContent m9953$$Nest$fgetmDisplayContent(DisplayRotation r0) {
        return r0.mDisplayContent;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLastOrientation, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m9954$$Nest$fgetmLastOrientation(DisplayRotation r0) {
        return r0.mLastOrientation;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m9955$$Nest$fgetmLock(DisplayRotation r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmOrientationListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ OrientationListener m9956$$Nest$fgetmOrientationListener(DisplayRotation r0) {
        return r0.mOrientationListener;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRotation, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m9957$$Nest$fgetmRotation(DisplayRotation r0) {
        return r0.mRotation;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmService, reason: not valid java name */
    static /* bridge */ /* synthetic */ WindowManagerService m9958$$Nest$fgetmService(DisplayRotation r0) {
        return r0.mService;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserRotation, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m9959$$Nest$fgetmUserRotation(DisplayRotation r0) {
        return r0.mUserRotation;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserRotationMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m9960$$Nest$fgetmUserRotationMode(DisplayRotation r0) {
        return r0.mUserRotationMode;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmRotationChoiceShownToUserForConfirmation, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9961$$Nest$fputmRotationChoiceShownToUserForConfirmation(DisplayRotation r0, int r1) {
        r0.mRotationChoiceShownToUserForConfirmation = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmWifiDisplayConnected, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9962$$Nest$fputmWifiDisplayConnected(DisplayRotation r0, boolean r1) {
        r0.mWifiDisplayConnected = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmWifiDisplayRotation, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9963$$Nest$fputmWifiDisplayRotation(DisplayRotation r0, int r1) {
        r0.mWifiDisplayRotation = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$misRotationChoiceAllowed, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9964$$Nest$misRotationChoiceAllowed(DisplayRotation r0, int r1) {
        return r0.isRotationChoiceAllowed(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misValidRotationChoice, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9965$$Nest$misValidRotationChoice(DisplayRotation r0, int r1) {
        return r0.isValidRotationChoice(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msendProposedRotationChangeToStatusBarInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9966$$Nest$msendProposedRotationChangeToStatusBarInternal(DisplayRotation r0, int r1, boolean r2) {
        r0.sendProposedRotationChangeToStatusBarInternal(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateOrientationListenerLw, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9967$$Nest$mupdateOrientationListenerLw(DisplayRotation r0) {
        r0.updateOrientationListenerLw();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateSettings, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9968$$Nest$mupdateSettings(DisplayRotation r0) {
        return r0.updateSettings();
    }

    DisplayRotation(WindowManagerService service, DisplayContent displayContent, DisplayAddress displayAddress, DeviceStateController deviceStateController, DisplayRotationCoordinator displayRotationCoordinator) {
        this(service, displayContent, displayAddress, displayContent.getDisplayPolicy(), service.mDisplayWindowSettings, service.mContext, service.getWindowManagerLock(), deviceStateController, displayRotationCoordinator);
    }

    DisplayRotation(WindowManagerService service, DisplayContent displayContent, DisplayAddress displayAddress, DisplayPolicy displayPolicy, DisplayWindowSettings displayWindowSettings, final Context context, Object lock, DeviceStateController deviceStateController, DisplayRotationCoordinator displayRotationCoordinator) {
        DisplayRotationIA r1 = null;
        this.mRotationHistory = new RotationHistory(r1);
        this.mRotationLockHistory = new RotationLockHistory(r1);
        this.mCurrentAppOrientation = -1;
        this.mLastOrientation = -1;
        this.mLastSensorRotation = -1;
        this.mRotationChoiceShownToUserForConfirmation = -1;
        this.mAllowAllRotations = -1;
        boolean r2 = false;
        this.mUserRotationMode = 0;
        this.mUserRotation = 0;
        this.mCameraRotationMode = 0;
        this.mFixedToUserRotation = 0;
        this.mWifiDisplayConnected = false;
        this.mWifiDisplayRotation = -1;
        this.mExt = (IExtDisplayRotation) ExtImplFactory.getImpl(IExtDisplayRotation.class, new Object[]{this});
        this.mService = service;
        this.mDisplayContent = displayContent;
        this.mDisplayPolicy = displayPolicy;
        this.mDisplayWindowSettings = displayWindowSettings;
        this.mContext = context;
        this.mLock = lock;
        this.mDeviceStateController = deviceStateController;
        this.isDefaultDisplay = displayContent.isDefaultDisplay;
        this.mCompatPolicyForImmersiveApps = initImmersiveAppCompatPolicy(service, displayContent);
        this.mSupportAutoRotation = this.mContext.getResources().getBoolean(R.bool.config_support_disable_satellite_while_enable_in_progress);
        this.mAllowRotationResolver = this.mContext.getResources().getBoolean(R.bool.config_allowRotationResolver);
        this.mLidOpenRotation = readRotation(R.integer.config_lowPowerStandbyNonInteractiveTimeout);
        this.mCarDockRotation = readRotation(R.integer.config_datause_throttle_kbitsps);
        this.mDeskDockRotation = readRotation(R.integer.config_displayWhiteBalanceDisplayNominalWhiteCct);
        this.mUndockedHdmiRotation = readRotation(R.integer.config_wakeUpToLastStateTimeoutMillis);
        int defaultRotation = readDefaultDisplayRotation(displayAddress, displayContent);
        this.mRotation = defaultRotation;
        this.mDisplayRotationCoordinator = displayRotationCoordinator;
        this.overrideMirroring = SystemProperties.getBoolean("vendor.display.override_mirroring_rotation", false);
        if (displayContent.mDisplay.getType() != 1) goto L5;
        r2 = true;
    L5:
        this.isBuiltin = r2;
        if (this.overrideMirroring == false) goto L10;
        if (this.isBuiltin == false) goto L10;
    L11:
        this.mDisplayRotationCoordinator.setDefaultDisplayDefaultRotation(this.mRotation);
    L12:
        this.mDefaultDisplayRotationChangedCallback = new DisplayRotation$$ExternalSyntheticLambda0(this);
        if (DisplayRotationCoordinator.isSecondaryInternalDisplay(displayContent) == false) goto L18;
        if (this.mDeviceStateController.shouldMatchBuiltInDisplayOrientationToReverseDefaultDisplay() == false) goto L18;
        this.mDisplayRotationCoordinator.setDefaultDisplayRotationChangedCallback(displayContent.getDisplayId(), this.mDefaultDisplayRotationChangedCallback);
    L18:
        if (this.overrideMirroring == false) goto L22;
        if (this.isBuiltin == false) goto L22;
    L23:
        Handler uiHandler = UiThread.getHandler();
        this.mOrientationListener = new OrientationListener(this, this.mContext, uiHandler, defaultRotation);
        this.mOrientationListener.setCurrentRotation(this.mRotation);
        this.mSettingsObserver = new SettingsObserver(this, uiHandler);
        this.mSettingsObserver.observe();
        if (this.mSupportAutoRotation == true) goto L26;
    L28:
        this.mFoldController = null;
    L29:
        Thread t = new AnonymousClass1(this, context);
        t.start();
    L32:
        if (this.mFoldController != null) goto L33;
    L33:
        return;
    L26:
        if (isFoldable(this.mContext) == false) goto L28;
        this.mFoldController = new FoldController(this);
    L22:
        if (this.isDefaultDisplay == true) goto L23;
        this.mFoldController = null;
    L10:
        if (this.isDefaultDisplay == false) goto L12;
        goto L11
    }

    private static boolean isFoldable(Context context) {
        if (context.getResources().getIntArray(R.array.config_locationExtraPackageNames).length <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    DisplayRotationImmersiveAppCompatPolicy initImmersiveAppCompatPolicy(WindowManagerService service, DisplayContent displayContent) {
        return DisplayRotationImmersiveAppCompatPolicy.createIfNeeded(service.mAppCompatConfiguration, this, displayContent);
    }

    private int readDefaultDisplayRotation(DisplayAddress displayAddress, DisplayContent displayContent) {
        String syspropValue = "";
        if ((displayAddress instanceof DisplayAddress.Physical) == false) goto L6;
        DisplayAddress.Physical physicalAddress = (DisplayAddress.Physical) displayAddress;
        syspropValue = SystemProperties.get("ro.bootanim.set_orientation_" + physicalAddress.getPhysicalDisplayId(), "");
    L6:
        if ("".equals(syspropValue) == false) goto L11;
        if (displayContent.isDefaultDisplay == false) goto L11;
        syspropValue = SystemProperties.get("ro.bootanim.set_orientation_logical_" + displayContent.getDisplayId(), "");
    L11:
        if (syspropValue.equals("ORIENTATION_90") == false) goto L15;
        return 1;
    L15:
        if (syspropValue.equals("ORIENTATION_180") == false) goto L19;
        return 2;
    L19:
        if (syspropValue.equals("ORIENTATION_270") == false) goto L22;
        return 3;
    L22:
        return 0;
    }

    private int readRotation(int resID) {
        int rotation = this.mContext.getResources().getInteger(resID);     // Catch: Resources.NotFoundException -> L13
        switch(rotation) {
            case 0: goto L11;
            case 90: goto L9;
            case 180: goto L7;
            case 270: goto L5;
            default: goto L18;
        };
    L5:
        return 3;
    L7:
        return 2;
    L9:
        return 1;
    L11:
        return 0;
    L18:
        return -1;
    L14:
        return -1;
    }

    boolean useDefaultSettingsProvider() {
        return this.isDefaultDisplay;
    }

    void updateUserDependentConfiguration(Resources currentUserRes) {
        this.mAllowSeamlessRotationDespiteNavBarMoving = currentUserRes.getBoolean(R.bool.config_allowSeamlessRotationDespiteNavBarMoving);
    }

    void configure(int width, int height) {
        Resources res = this.mContext.getResources();
        boolean r4 = true;
        if (width <= height) goto L8;
        this.mLandscapeRotation = 0;
        this.mSeascapeRotation = 2;
        if (res.getBoolean(R.bool.config_screen_off_udfps_enabled) == false) goto L7;
        this.mPortraitRotation = 1;
        this.mUpsideDownRotation = 3;
    L13:
        if ("portrait".equals(SystemProperties.get("persist.demo.hdmirotation")) == false) goto L15;
        this.mDemoHdmiRotation = this.mPortraitRotation;
    L16:
        this.mDemoHdmiRotationLock = SystemProperties.getBoolean("persist.demo.hdmirotationlock", false);
        if ("portrait".equals(SystemProperties.get("persist.demo.remoterotation")) == false) goto L19;
        this.mDemoRotation = this.mPortraitRotation;
    L20:
        this.mDemoRotationLock = SystemProperties.getBoolean("persist.demo.rotationlock", false);
        boolean isCar = this.mContext.getPackageManager().hasSystemFeature("android.hardware.type.automotive");
        boolean isTv = this.mContext.getPackageManager().hasSystemFeature("android.software.leanback");
        if (isCar == true) goto L31;
        if (isTv == true) goto L31;
        if (this.mService.mIsPc == true) goto L31;
        if (this.mDisplayContent.isPublicSecondaryDisplayWithDesktopModeForceEnabled() == true) goto L31;
        if (this.mDisplayContent.shouldRotateWithContent() == false) goto L31;
    L33:
        r4 = false;
    L34:
        this.mDefaultFixedToUserRotation = r4;
        return;
    L31:
        if ("true".equals(SystemProperties.get("config.override_forced_orient")) == true) goto L33;
    L19:
        this.mDemoRotation = this.mLandscapeRotation;
        goto L20
    L15:
        this.mDemoHdmiRotation = this.mLandscapeRotation;
        goto L16
    L7:
        this.mPortraitRotation = 3;
        this.mUpsideDownRotation = 1;
        goto L13
    L8:
        this.mPortraitRotation = 0;
        this.mUpsideDownRotation = 2;
        if (res.getBoolean(R.bool.config_screen_off_udfps_enabled) == false) goto L11;
        this.mLandscapeRotation = 3;
        this.mSeascapeRotation = 1;
        goto L13
    L11:
        this.mLandscapeRotation = 1;
        this.mSeascapeRotation = 3;
        goto L13
    }

    void applyCurrentRotation(int rotation) {
        this.mRotationHistory.addRecord(this, rotation);
        if (this.mOrientationListener == null) goto L6;
        this.mOrientationListener.setCurrentRotation(rotation);
        return;
    }

    void setRotation(int rotation) {
        this.mRotation = rotation;
    }

    int getRotation() {
        return this.mRotation;
    }

    int getLastOrientation() {
        return this.mLastOrientation;
    }

    boolean updateOrientation(int newOrientation, boolean forceUpdate) {
        if (newOrientation != this.mLastOrientation) goto L6;
        if (forceUpdate == true) goto L6;
        return false;
    L6:
        this.mLastOrientation = newOrientation;
        if (newOrientation == this.mCurrentAppOrientation) goto L12;
        this.mCurrentAppOrientation = newOrientation;
        if (this.isDefaultDisplay == false) goto L17;
        updateOrientationListenerLw();
    L17:
        return updateRotationUnchecked(forceUpdate);
    L12:
        if (this.mCompatPolicyForImmersiveApps == null) goto L17;
        if (this.mCompatPolicyForImmersiveApps.deferOrientationUpdate() == false) goto L17;
        return false;
    }

    boolean updateRotationAndSendNewConfigIfChanged() {
        boolean changed = updateRotationUnchecked(false);
        if (changed == false) goto L5;
        this.mDisplayContent.sendNewConfiguration();
    L5:
        return changed;
    }

    boolean updateRotationUnchecked(boolean forceUpdate) {
        int displayId = this.mDisplayContent.getDisplayId();
        if (forceUpdate == true) goto L25;
        if (this.mDeferredRotationPauseCount <= 0) goto L11;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ORIENTATION_enabled[1] == false) goto L9;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ORIENTATION, -6776561147903919733L, 0, null);
    L9:
        return false;
    L11:
        if (this.mDisplayContent.inTransition() == false) goto L21;
        if (this.mDisplayContent.getDisplayPolicy().isScreenOnFully() == false) goto L21;
        if (this.mDisplayContent.mTransitionController.useShellTransitionsRotation() == true) goto L21;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ORIENTATION_enabled[1] == false) goto L19;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ORIENTATION, 7439675997626642740L, 0, null);
    L19:
        return false;
    L21:
        if (this.mDisplayContent.mFixedRotationTransitionListener.shouldDeferRotation() == false) goto L25;
        this.mLastOrientation = -2;
        return false;
    L25:
        if (this.mService.mDisplayEnabled == false) goto L27;
        int oldRotation = this.mRotation;
        int lastOrientation = this.mLastOrientation;
        int rotation = rotationForOrientation(lastOrientation, oldRotation);
        if (this.mFoldController == null) goto L38;
        if (this.mFoldController.shouldRevertOverriddenRotation() == false) goto L38;
        rotation = this.mFoldController.revertOverriddenRotation();
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ORIENTATION_enabled[1] == false) goto L38;
        String protoLogParam0 = String.valueOf(Surface.rotationToString(rotation));
        String protoLogParam1 = String.valueOf(Surface.rotationToString(oldRotation));
        String protoLogParam2 = String.valueOf(Surface.rotationToString(rotation));
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ORIENTATION, 662988298513100908L, 0, new Object[]{protoLogParam0, protoLogParam1, protoLogParam2});
    L38:
        if (DisplayRotationCoordinator.isSecondaryInternalDisplay(this.mDisplayContent) == false) goto L43;
        if (this.mDeviceStateController.shouldMatchBuiltInDisplayOrientationToReverseDefaultDisplay() == false) goto L43;
        rotation = RotationUtils.reverseRotationDirectionAroundZAxis(this.mDisplayRotationCoordinator.getDefaultDisplayCurrentRotation());
    L43:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ORIENTATION_enabled[1] == false) goto L46;
        String protoLogParam3 = String.valueOf(Surface.rotationToString(rotation));
        long protoLogParam4 = rotation;
        long protoLogParam5 = displayId;
        String protoLogParam6 = String.valueOf(ActivityInfo.screenOrientationToString(lastOrientation));
        long protoLogParam7 = lastOrientation;
        String protoLogParam8 = String.valueOf(Surface.rotationToString(oldRotation));
        long protoLogParam9 = oldRotation;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ORIENTATION, -7113483678655694375L, 4372, new Object[]{protoLogParam3, Long.valueOf(protoLogParam4), Long.valueOf(protoLogParam5), protoLogParam6, Long.valueOf(protoLogParam7), protoLogParam8, Long.valueOf(protoLogParam9)});
    L46:
        if (oldRotation != rotation) goto L49;
        return 0;
    L49:
        if (this.mExt.updateRotationUnchecked(this.mContext, oldRotation, rotation) == false) goto L52;
        return r4;
    L52:
        if (this.isDefaultDisplay == false) goto L55;
        this.mDisplayRotationCoordinator.onDefaultDisplayRotationChanged(rotation);
    L55:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ORIENTATION_CHANGE_enabled[2] == false) goto L58;
        long protoLogParam10 = displayId;
        long protoLogParam11 = rotation;
        long protoLogParam12 = oldRotation;
        long protoLogParam13 = lastOrientation;
        long protoLogParam14 = this.mUserRotationMode;
        long protoLogParam15 = this.mUserRotation;
        long protoLogParam16 = this.mLastSensorRotation;
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_ORIENTATION_CHANGE, -1708746390953837506L, 5461, new Object[]{Long.valueOf(protoLogParam10), Long.valueOf(protoLogParam11), Long.valueOf(protoLogParam12), Long.valueOf(protoLogParam13), Long.valueOf(protoLogParam14), Long.valueOf(protoLogParam15), Long.valueOf(protoLogParam16)});
    L58:
        this.mRotation = rotation;
        this.mDisplayContent.applyFixedRotationForNonTopVisibleActivityIfNeeded();
        SysOptBridge.getFactory().getSmartScenes().updateDisplayRotation(rotation);
        this.mDisplayContent.setLayoutNeeded();
        this.mDisplayContent.mWaitingForConfig = true;
        if (this.mDisplayContent.mTransitionController.isShellTransitionsEnabled() == false) goto L68;
        boolean wasCollecting = this.mDisplayContent.mTransitionController.isCollecting();
        if (wasCollecting == false) goto L63;
        this.mDisplayContent.collectDisplayChange(this.mDisplayContent.mTransitionController.getCollectingTransition());
        startRemoteRotation(oldRotation, this.mRotation);
        return true;
    L63:
        if (this.mDisplayContent.getLastHasContent() == false) goto L70;
        TransitionRequestInfo.DisplayChange change = new TransitionRequestInfo.DisplayChange(this.mDisplayContent.getDisplayId(), oldRotation, this.mRotation);
        this.mDisplayContent.requestChangeTransition(536870912, change);
        return true;
    L70:
        return true;
    L68:
        startRemoteRotation(oldRotation, this.mRotation);
        return true;
    L27:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ORIENTATION_enabled[1] == false) goto L29;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ORIENTATION, -2222079183499215612L, 0, null);
    L29:
        return false;
    }

    private void startRemoteRotation(int fromRotation, final int toRotation) {
        this.mDisplayContent.mRemoteDisplayChangeController.performRemoteDisplayChange(fromRotation, toRotation, null, new DisplayRotation$$ExternalSyntheticLambda1(this, toRotation));
    }

    private /* synthetic */ void lambda$startRemoteRotation$0(int toRotation, WindowContainerTransaction transaction) {
        continueRotation(toRotation, transaction);
    }

    private void continueRotation(int targetRotation, WindowContainerTransaction t) {
        if (targetRotation == this.mRotation) goto L6;
        return;
    L6:
        if (this.mDisplayContent.mTransitionController.isShellTransitionsEnabled() == true) goto L8;
    L11:
        this.mService.mAtmService.deferWindowLayout();
        this.mDisplayContent.sendNewConfiguration();     // Catch: Throwable -> L16
        if (t == null) goto L18;
        this.mService.mAtmService.mWindowOrganizerController.applyTransaction(t);     // Catch: Throwable -> L16
    L18:
        this.mService.mAtmService.continueWindowLayout();
        return;
    L16:
        th = move-exception;
        this.mService.mAtmService.continueWindowLayout();
        throw th;
    L8:
        if (this.mDisplayContent.mTransitionController.isCollecting() == true) goto L10;
        Slog.e(TAG, "Trying to continue rotation outside a transition");
    L10:
        this.mDisplayContent.mTransitionController.collect(this.mDisplayContent);
        goto L11
    }

    boolean shouldRotateSeamlessly(int oldRotation, int newRotation, boolean forceUpdate) {
        if (this.mDisplayContent.hasTopFixedRotationLaunchingApp() == false) goto L5;
        return true;
    L5:
        WindowState w = this.mDisplayPolicy.getTopFullscreenOpaqueWindow();
        if (w != null) goto L8;
    L33:
        return false;
    L8:
        if (w != this.mDisplayContent.mCurrentFocus) goto L33;
        if (w.mAttrs.rotationAnimation == 3) goto L13;
    L32:
        return false;
    L13:
        if (w.inMultiWindowMode() == true) goto L32;
        if (w.isAnimatingLw() == true) goto L32;
        if (canRotateSeamlessly(oldRotation, newRotation) == true) goto L21;
        return false;
    L21:
        if (w.mActivityRecord == null) goto L26;
        if (w.mActivityRecord.matchParentBounds() == true) goto L26;
        return false;
    L26:
        if (this.mDisplayContent.getDefaultTaskDisplayArea().hasPinnedTask() == false) goto L28;
    L31:
        return false;
    L28:
        if (this.mDisplayContent.hasAlertWindowSurfaces() == true) goto L31;
        return true;
    }

    boolean canRotateSeamlessly(int oldRotation, int newRotation) {
        if (this.mAllowSeamlessRotationDespiteNavBarMoving == false) goto L5;
    L13:
        return true;
    L5:
        if (this.mDisplayPolicy.navigationBarCanMove() == true) goto L13;
        if (oldRotation == 2) goto L11;
        if (newRotation == 2) goto L11;
        return true;
    L11:
        return false;
    }

    void restoreSettings(int userRotationMode, int userRotation, int fixedToUserRotation) {
        this.mFixedToUserRotation = fixedToUserRotation;
        if (this.isDefaultDisplay == false) goto L6;
        return;
    L6:
        if (userRotationMode != 0) goto L8;
    L10:
        if (userRotation >= 0) goto L12;
    L13:
        Slog.w(TAG, "Trying to restore an invalid user rotation " + userRotation + " for " + this.mDisplayContent);
        userRotation = 0;
    L14:
        int userRotationOverride = getUserRotationOverride();
        if (userRotationOverride == 0) goto L17;
        userRotationMode = 1;
        userRotation = userRotationOverride;
    L17:
        this.mUserRotationMode = userRotationMode;
        this.mUserRotation = userRotation;
        return;
    L12:
        if (userRotation <= 3) goto L14;
    L8:
        if (userRotationMode == 1) goto L10;
        Slog.w(TAG, "Trying to restore an invalid user rotation mode " + userRotationMode + " for " + this.mDisplayContent);
        userRotationMode = 0;
        goto L10
    }

    void setFixedToUserRotation(int fixedToUserRotation) {
        if (this.mFixedToUserRotation != fixedToUserRotation) goto L5;
        return;
    L5:
        this.mFixedToUserRotation = fixedToUserRotation;
        this.mDisplayWindowSettings.setFixedToUserRotation(this.mDisplayContent, fixedToUserRotation);
        if (this.mDisplayContent.mFocusedApp == null) goto L8;
        this.mDisplayContent.onLastFocusedTaskDisplayAreaChanged(this.mDisplayContent.mFocusedApp.getDisplayArea());
    L8:
        this.mDisplayContent.updateOrientation();
    }

    void setUserRotation(int userRotationMode, int userRotation, String caller) {
        this.mRotationLockHistory.addRecord(userRotationMode, userRotation, caller);
        this.mRotationChoiceShownToUserForConfirmation = -1;
        int accelerometerRotation = 0;
        if (useDefaultSettingsProvider() == false) goto L10;
        ContentResolver res = this.mContext.getContentResolver();
        if (userRotationMode == 1) goto L8;
        accelerometerRotation = 1;
    L8:
        Settings.System.putIntForUser(res, "accelerometer_rotation", accelerometerRotation, -2);
        Settings.System.putIntForUser(res, "user_rotation", userRotation, -2);
        return;
    L10:
        boolean changed = false;
        if (this.mUserRotationMode == userRotationMode) goto L14;
        this.mUserRotationMode = userRotationMode;
        changed = true;
    L14:
        if (this.mUserRotation == userRotation) goto L16;
        this.mUserRotation = userRotation;
        changed = true;
    L16:
        this.mDisplayWindowSettings.setUserRotation(this.mDisplayContent, userRotationMode, userRotation);
        if (changed == false) goto L20;
        this.mService.updateRotation(false, false);
        this.mDisplayContent.onMirrorOutputSurfaceOrientationChanged();
        return;
    }

    void freezeRotation(int rotation, String caller) {
        if (this.mDeviceStateController.shouldReverseRotationDirectionAroundZAxis(this.mDisplayContent) == false) goto L6;
        rotation = RotationUtils.reverseRotationDirectionAroundZAxis(rotation);
    L6:
        if (rotation != (-1)) goto L8;
        int rotation2 = this.mRotation;
    L9:
        setUserRotation(1, rotation2, caller);
        return;
    L8:
        rotation2 = rotation;
        goto L9
    }

    void thawRotation(String caller) {
        setUserRotation(0, this.mUserRotation, caller);
    }

    boolean isRotationFrozen() {
        if (this.isDefaultDisplay == true) goto L9;
        if (this.mUserRotationMode == 1) goto L7;
        return false;
    L7:
        return true;
    L9:
        if (Settings.System.getIntForUser(this.mContext.getContentResolver(), "accelerometer_rotation", 0, -2) == 0) goto L11;
        return false;
    L11:
        return true;
    }

    boolean isFixedToUserRotation() {
        switch(this.mFixedToUserRotation) {
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L6;
            default: goto L5;
        };
    L6:
        return false;
    L7:
        return true;
    L9:
        return false;
    L5:
        return this.mDefaultFixedToUserRotation;
    }

    int getFixedToUserRotationMode() {
        return this.mFixedToUserRotation;
    }

    public int getLandscapeRotation() {
        return this.mLandscapeRotation;
    }

    public int getSeascapeRotation() {
        return this.mSeascapeRotation;
    }

    public int getPortraitRotation() {
        return this.mPortraitRotation;
    }

    public int getUpsideDownRotation() {
        return this.mUpsideDownRotation;
    }

    public int getCurrentAppOrientation() {
        return this.mCurrentAppOrientation;
    }

    public DisplayPolicy getDisplayPolicy() {
        return this.mDisplayPolicy;
    }

    public WindowOrientationListener getOrientationListener() {
        return this.mOrientationListener;
    }

    public int getUserRotation() {
        return this.mUserRotation;
    }

    public int getUserRotationMode() {
        return this.mUserRotationMode;
    }

    public void updateOrientationListener() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        updateOrientationListenerLw();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void pause() {
        this.mDeferredRotationPauseCount++;
    }

    void resume() {
        if (this.mDeferredRotationPauseCount > 0) goto L5;
        return;
    L5:
        this.mDeferredRotationPauseCount--;
        if (this.mDeferredRotationPauseCount != 0) goto L9;
        updateRotationAndSendNewConfigIfChanged();
        return;
    }

    private void updateOrientationListenerLw() {
        if (this.mOrientationListener != null) goto L5;
        return;
    L5:
        if (this.mOrientationListener.canDetectOrientation() == false) goto L28;
        boolean screenOnEarly = this.mDisplayPolicy.isScreenOnEarly();
        boolean awake = this.mDisplayPolicy.isAwake();
        boolean keyguardDrawComplete = this.mDisplayPolicy.isKeyguardDrawComplete();
        boolean windowManagerDrawComplete = this.mDisplayPolicy.isWindowManagerDrawComplete();
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ORIENTATION_enabled[1] == false) goto L11;
        long protoLogParam2 = this.mCurrentAppOrientation;
        boolean protoLogParam3 = this.mOrientationListener.mEnabled;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ORIENTATION, -2426404033822048710L, 4063, new Object[]{Boolean.valueOf(screenOnEarly), Boolean.valueOf(awake), Long.valueOf(protoLogParam2), Boolean.valueOf(protoLogParam3), Boolean.valueOf(keyguardDrawComplete), Boolean.valueOf(windowManagerDrawComplete)});
    L11:
        boolean disable = true;
        if (screenOnEarly == false) goto L23;
        if (awake == false) goto L15;
    L16:
        if (keyguardDrawComplete == false) goto L23;
        if (windowManagerDrawComplete == false) goto L23;
        if (needSensorRunning() == false) goto L23;
        disable = false;
        if (this.mOrientationListener.mEnabled == true) goto L23;
        this.mOrientationListener.enable();
        goto L23
    L15:
        if (this.mOrientationListener.shouldStayEnabledWhileDreaming() == true) goto L16;
    L23:
        if (disable == false) goto L27;
        this.mOrientationListener.disable();
        return;
    L27:
        return;
    }

    private boolean needSensorRunning() {
        if (isFixedToUserRotation() == false) goto L6;
        return false;
    L6:
        if (this.mFoldController == null) goto L11;
        if (this.mFoldController.shouldDisableRotationSensor() == false) goto L11;
        return false;
    L11:
        if (this.mSupportAutoRotation == true) goto L13;
    L21:
        int dockMode = this.mDisplayPolicy.getDockMode();
        if (this.mDisplayPolicy.isCarDockEnablesAccelerometer() == false) goto L26;
        if (dockMode != 2) goto L26;
    L31:
        return true;
    L26:
        if (this.mDisplayPolicy.isDeskDockEnablesAccelerometer() == false) goto L33;
        if (dockMode == 1) goto L31;
        if (dockMode == 3) goto L31;
        if (dockMode == 4) goto L31;
    L33:
        if (this.mUserRotationMode != 1) goto L41;
        if (this.mSupportAutoRotation == true) goto L37;
        return false;
    L37:
        if (this.mShowRotationSuggestions == 1) goto L39;
        return false;
    L39:
        return true;
    L41:
        return this.mSupportAutoRotation;
    L13:
        if (this.mCurrentAppOrientation != 4) goto L15;
    L20:
        return true;
    L15:
        if (this.mCurrentAppOrientation == 10) goto L20;
        if (this.mCurrentAppOrientation == 7) goto L20;
        if (this.mCurrentAppOrientation != 6) goto L21;
        goto L20
    }

    boolean needsUpdate() {
        int oldRotation = this.mRotation;
        int rotation = rotationForOrientation(this.mLastOrientation, oldRotation);
        if (oldRotation == rotation) goto L5;
        return true;
    L5:
        return false;
    }

    void resetAllowAllRotations() {
        this.mAllowAllRotations = -1;
    }

    int rotationForOrientation(int orientation, int lastRotation) {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ORIENTATION_enabled[1] == false) goto L10;
        String protoLogParam0 = String.valueOf(ActivityInfo.screenOrientationToString(orientation));
        long protoLogParam1 = orientation;
        String protoLogParam2 = String.valueOf(Surface.rotationToString(lastRotation));
        long protoLogParam3 = lastRotation;
        String protoLogParam4 = String.valueOf(Surface.rotationToString(this.mUserRotation));
        long protoLogParam5 = this.mUserRotation;
        if (this.mUserRotationMode != 1) goto L7;
        String r3 = "USER_ROTATION_LOCKED";
    L8:
        String protoLogParam6 = String.valueOf(r3);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ORIENTATION, 7339471241580327852L, 1092, new Object[]{protoLogParam0, Long.valueOf(protoLogParam1), protoLogParam2, Long.valueOf(protoLogParam3), protoLogParam4, Long.valueOf(protoLogParam5), protoLogParam6});
        goto L10
    L7:
        r3 = "";
    L10:
        if (isFixedToUserRotation() == false) goto L14;
        return this.mUserRotation;
    L14:
        if (this.mOrientationListener == null) goto L16;
        int sensorRotation = this.mOrientationListener.getProposedRotation();
    L18:
        if (this.mFoldController == null) goto L23;
        if (this.mFoldController.shouldIgnoreSensorRotation() == false) goto L23;
        sensorRotation = -1;
    L23:
        if (this.mDeviceStateController.shouldReverseRotationDirectionAroundZAxis(this.mDisplayContent) == false) goto L25;
        sensorRotation = RotationUtils.reverseRotationDirectionAroundZAxis(sensorRotation);
    L25:
        this.mLastSensorRotation = sensorRotation;
        if (sensorRotation >= 0) goto L28;
        sensorRotation = lastRotation;
    L28:
        int lidState = this.mDisplayPolicy.getLidState();
        int dockMode = this.mDisplayPolicy.getDockMode();
        boolean hdmiPlugged = this.mDisplayPolicy.isHdmiPlugged();
        boolean carDockEnablesAccelerometer = this.mDisplayPolicy.isCarDockEnablesAccelerometer();
        boolean deskDockEnablesAccelerometer = this.mDisplayPolicy.isDeskDockEnablesAccelerometer();
        if (this.overrideMirroring == false) goto L33;
        if (this.isBuiltin == false) goto L33;
    L36:
        if (lidState != 1) goto L41;
        if (this.mLidOpenRotation < 0) goto L41;
        int preferredRotation = this.mLidOpenRotation;
    L129:
        switch(orientation) {
            case 0: goto L166;
            case 1: goto L161;
            case 2: goto L130;
            case 3: goto L130;
            case 4: goto L130;
            case 5: goto L130;
            case 6: goto L153;
            case 7: goto L145;
            case 8: goto L140;
            case 9: goto L135;
            case 10: goto L130;
            case 11: goto L153;
            case 12: goto L145;
            default: goto L130;
        };
    L130:
        if (preferredRotation < 0) goto L132;
        return preferredRotation;
    L132:
        return 0;
    L135:
        if (isAnyPortrait(preferredRotation) == false) goto L138;
        return preferredRotation;
    L138:
        return this.mUpsideDownRotation;
    L140:
        if (isLandscapeOrSeascape(preferredRotation) == false) goto L143;
        return preferredRotation;
    L143:
        return this.mSeascapeRotation;
    L145:
        if (isAnyPortrait(preferredRotation) == false) goto L148;
        return preferredRotation;
    L148:
        if (isAnyPortrait(lastRotation) == false) goto L151;
        return lastRotation;
    L151:
        return this.mPortraitRotation;
    L153:
        if (isLandscapeOrSeascape(preferredRotation) == false) goto L156;
        return preferredRotation;
    L156:
        if (isLandscapeOrSeascape(lastRotation) == false) goto L159;
        return lastRotation;
    L159:
        return this.mLandscapeRotation;
    L161:
        if (isAnyPortrait(preferredRotation) == false) goto L164;
        return preferredRotation;
    L164:
        return this.mPortraitRotation;
    L166:
        if (isLandscapeOrSeascape(preferredRotation) == false) goto L169;
        return preferredRotation;
    L169:
        return this.mLandscapeRotation;
    L41:
        if (dockMode != 2) goto L50;
        if (carDockEnablesAccelerometer == false) goto L44;
    L45:
        if (carDockEnablesAccelerometer == false) goto L47;
        preferredRotation = sensorRotation;
        goto L129
    L47:
        preferredRotation = this.mCarDockRotation;
        goto L129
    L44:
        if (this.mCarDockRotation >= 0) goto L45;
    L50:
        if (dockMode == 1) goto L53;
        if (dockMode == 3) goto L53;
        if (dockMode == 4) goto L53;
    L62:
        if (hdmiPlugged == true) goto L66;
        if (this.mWifiDisplayConnected == true) goto L66;
    L69:
        if (this.mWifiDisplayConnected == true) goto L71;
    L73:
        if (hdmiPlugged == false) goto L79;
        if (dockMode != 0) goto L79;
        if (this.mUndockedHdmiRotation < 0) goto L79;
        preferredRotation = this.mUndockedHdmiRotation;
    L79:
        if (this.mDemoRotationLock == false) goto L82;
        preferredRotation = this.mDemoRotation;
        goto L129
    L82:
        if (this.mDisplayPolicy.isPersistentVrModeEnabled() == false) goto L84;
        preferredRotation = this.mPortraitRotation;
        goto L129
    L84:
        if (orientation != 14) goto L87;
        preferredRotation = lastRotation;
        goto L129
    L87:
        if (this.mSupportAutoRotation == true) goto L93;
        if (this.mFixedToUserRotation != 3) goto L91;
        preferredRotation = this.mUserRotation;
        goto L129
    L91:
        preferredRotation = -1;
        goto L129
    L93:
        if (this.mUserRotationMode != 0) goto L95;
    L96:
        if (orientation == 2) goto L121;
        if (orientation == (-1)) goto L121;
        if (orientation == 11) goto L121;
        if (orientation == 12) goto L121;
        if (orientation == 13) goto L121;
    L103:
        if (orientation == 4) goto L121;
        if (orientation == 10) goto L121;
        if (orientation == 6) goto L121;
        if (orientation == 7) goto L121;
        if (this.mUserRotationMode != 1) goto L120;
        if (orientation == 5) goto L120;
        if (orientation == 0) goto L120;
        if (orientation == 1) goto L120;
        if (orientation == 8) goto L120;
        if (orientation == 9) goto L120;
        preferredRotation = this.mUserRotation;
    L120:
        preferredRotation = -1;
    L121:
        if (sensorRotation == 2) goto L123;
    L128:
        preferredRotation = sensorRotation;
        goto L129
    L123:
        if (getAllowAllRotations() == 1) goto L128;
        if (orientation == 10) goto L128;
        if (orientation == 13) goto L128;
        preferredRotation = lastRotation;
        goto L129
    L95:
        if (isTabletopAutoRotateOverrideEnabled() == false) goto L103;
    L71:
        if (this.mWifiDisplayRotation <= (-1)) goto L73;
        preferredRotation = this.mWifiDisplayRotation;
    L66:
        if (this.mDemoHdmiRotationLock == false) goto L69;
        preferredRotation = this.mDemoHdmiRotation;
    L53:
        if (deskDockEnablesAccelerometer == false) goto L55;
    L56:
        if (orientation == 14) goto L62;
        if (orientation == 5) goto L62;
        if (deskDockEnablesAccelerometer == false) goto L60;
        preferredRotation = sensorRotation;
        goto L129
    L60:
        preferredRotation = this.mDeskDockRotation;
        goto L129
    L55:
        if (this.mDeskDockRotation < 0) goto L62;
    L33:
        if (this.isDefaultDisplay == true) goto L36;
        preferredRotation = this.mUserRotation;
        goto L129
    L16:
        sensorRotation = -1;
        goto L18
    }

    private int getAllowAllRotations() {
        if (this.mAllowAllRotations != (-1)) goto L10;
        if (this.mContext.getResources().getBoolean(R.bool.config_allowAllRotations) == false) goto L7;
        int r0 = 1;
    L8:
        this.mAllowAllRotations = r0;
        goto L10
    L7:
        r0 = 0;
    L10:
        return this.mAllowAllRotations;
    }

    boolean isLandscapeOrSeascape(int rotation) {
        if (rotation != this.mLandscapeRotation) goto L5;
    L8:
        return true;
    L5:
        if (rotation == this.mSeascapeRotation) goto L8;
        return false;
    }

    boolean isAnyPortrait(int rotation) {
        if (rotation != this.mPortraitRotation) goto L5;
    L8:
        return true;
    L5:
        if (rotation == this.mUpsideDownRotation) goto L8;
        return false;
    }

    private boolean isValidRotationChoice(int preferredRotation) {
        switch(this.mCurrentAppOrientation) {
            case -1: goto L17;
            case 2: goto L17;
            case 11: goto L15;
            case 12: goto L10;
            case 13: goto L5;
            default: goto L4;
        };
    L4:
        return false;
    L5:
        if (preferredRotation < 0) goto L8;
        return true;
    L8:
        return false;
    L10:
        if (preferredRotation != this.mPortraitRotation) goto L13;
        return true;
    L13:
        return false;
    L15:
        return isLandscapeOrSeascape(preferredRotation);
    L17:
        if (getAllowAllRotations() != 1) goto L22;
        if (preferredRotation < 0) goto L21;
        return true;
    L21:
        return false;
    L22:
        if (preferredRotation < 0) goto L27;
        if (preferredRotation == 2) goto L27;
        return true;
    L27:
        return false;
    }

    private boolean isTabletopAutoRotateOverrideEnabled() {
        if (this.mFoldController != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mFoldController.overrideFrozenRotation() == false) goto L7;
        return true;
    }

    private boolean isRotationChoiceAllowed(int proposedRotation) {
        if (this.mCompatPolicyForImmersiveApps != null) goto L5;
    L7:
        boolean isRotationLockEnforced = false;
    L9:
        if (isRotationLockEnforced == true) goto L14;
        if (this.mUserRotationMode == 1) goto L14;
        return false;
    L14:
        if (isTabletopAutoRotateOverrideEnabled() == false) goto L17;
        return false;
    L17:
        if (isFixedToUserRotation() == false) goto L19;
        return false;
    L19:
        int lidState = this.mDisplayPolicy.getLidState();
        if (lidState == 1) goto L22;
    L24:
        int dockMode = this.mDisplayPolicy.getDockMode();
        if (dockMode != 2) goto L27;
        return false;
    L27:
        boolean deskDockEnablesAccelerometer = this.mDisplayPolicy.isDeskDockEnablesAccelerometer();
        if (dockMode != 1) goto L30;
    L33:
        if (deskDockEnablesAccelerometer == true) goto L35;
        return false;
    L35:
        boolean hdmiPlugged = this.mDisplayPolicy.isHdmiPlugged();
        if (hdmiPlugged == true) goto L38;
    L40:
        if (hdmiPlugged == false) goto L46;
        if (dockMode != 0) goto L46;
        if (this.mUndockedHdmiRotation < 0) goto L46;
        return false;
    L46:
        if (this.mDemoRotationLock == false) goto L49;
        return false;
    L49:
        if (this.mDisplayPolicy.isPersistentVrModeEnabled() == false) goto L52;
        return false;
    L52:
        if (this.mSupportAutoRotation == true) goto L55;
        return false;
    L55:
        switch(this.mCurrentAppOrientation) {
            case -1: goto L57;
            case 2: goto L57;
            case 11: goto L57;
            case 12: goto L57;
            case 13: goto L57;
            default: goto L56;
        };
    L56:
        return false;
    L57:
        return true;
    L38:
        if (this.mDemoHdmiRotationLock == false) goto L40;
        return false;
    L30:
        if (dockMode == 3) goto L33;
        if (dockMode != 4) goto L35;
    L22:
        if (this.mLidOpenRotation < 0) goto L24;
        return false;
    L5:
        if (this.mCompatPolicyForImmersiveApps.isRotationLockEnforced(proposedRotation) == false) goto L7;
        isRotationLockEnforced = true;
        goto L9
    }

    private void sendProposedRotationChangeToStatusBarInternal(int rotation, boolean isValid) {
        StatusBarManagerInternal bar = this.mDisplayPolicy.getStatusBarManagerInternal();
        if (bar == null) goto L6;
        bar.onProposedRotationChanged(this.mDisplayContent.getDisplayId(), rotation, isValid);
        return;
    }

    void dispatchProposedRotation(int rotation) {
        if (this.mService.mRotationWatcherController.hasProposedRotationListeners() == false) goto L12;
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mService.mRotationWatcherController.dispatchProposedRotation(this.mDisplayContent, rotation);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private static String allowAllRotationsToString(int allowAll) {
        switch(allowAll) {
            case -1: goto L9;
            case 0: goto L7;
            case 1: goto L5;
            default: goto L4;
        };
    L5:
        return "true";
    L7:
        return "false";
    L9:
        return "unknown";
    L4:
        return Integer.toString(allowAll);
    }

    public void onUserSwitch() {
        if (this.mSettingsObserver == null) goto L6;
        this.mSettingsObserver.onChange(false);
        return;
    }

    void onDisplayRemoved() {
        removeDefaultDisplayRotationChangedCallback();
        if (this.mFoldController == null) goto L6;
        this.mFoldController.onDisplayRemoved();
        return;
    }

    private boolean updateSettings() {
        ContentResolver resolver = this.mContext.getContentResolver();
        boolean shouldUpdateRotation = false;
        Object r2 = this.mLock;
        monitor-enter(r2);
        boolean shouldUpdateOrientationListener = false;
        int userRotationMode = 1;
        if (ActivityManager.isLowRamDeviceStatic() == false) goto L8;
        int showRotationSuggestions = 0;
    L10:
        if (this.mShowRotationSuggestions == showRotationSuggestions) goto L14;
        this.mShowRotationSuggestions = showRotationSuggestions;     // Catch: Throwable -> L12
        shouldUpdateOrientationListener = true;
    L14:
        int userRotation = Settings.System.getIntForUser(resolver, "user_rotation", 0, -2);     // Catch: Throwable -> L12
        if (this.mUserRotation == userRotation) goto L18;
        this.mUserRotation = userRotation;     // Catch: Throwable -> L12
        shouldUpdateRotation = true;
    L18:
        if (Settings.System.getIntForUser(resolver, "accelerometer_rotation", 0, -2) == 0) goto L22;
        userRotationMode = 0;
    L22:
        if (this.mUserRotationMode == userRotationMode) goto L24;
        this.mUserRotationMode = userRotationMode;     // Catch: Throwable -> L12
        shouldUpdateOrientationListener = true;
        shouldUpdateRotation = true;
    L24:
        if (shouldUpdateOrientationListener == false) goto L26;
        updateOrientationListenerLw();     // Catch: Throwable -> L12
    L26:
        int cameraRotationMode = Settings.Secure.getIntForUser(resolver, "camera_autorotate", 0, -2);     // Catch: Throwable -> L12
        if (this.mCameraRotationMode == cameraRotationMode) goto L29;
        this.mCameraRotationMode = cameraRotationMode;     // Catch: Throwable -> L12
        shouldUpdateRotation = true;
    L29:
        monitor-exit(r2);     // Catch: Throwable -> L12
        return shouldUpdateRotation;
    L8:
        showRotationSuggestions = Settings.Secure.getIntForUser(resolver, "show_rotation_suggestions", 1, -2);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    void removeDefaultDisplayRotationChangedCallback() {
        if (DisplayRotationCoordinator.isSecondaryInternalDisplay(this.mDisplayContent) == false) goto L6;
        this.mDisplayRotationCoordinator.removeDefaultDisplayRotationChangedCallback(this.mDefaultDisplayRotationChangedCallback);
        return;
    }

    void onSetRequestedOrientation() {
        if (this.mCompatPolicyForImmersiveApps != null) goto L5;
        return;
    L5:
        if (this.mRotationChoiceShownToUserForConfirmation == (-1)) goto L10;
        this.mOrientationListener.onProposedRotationChanged(this.mRotationChoiceShownToUserForConfirmation);
        return;
    }

    void dump(String prefix, PrintWriter pw) {
        pw.println(prefix + "DisplayRotation");
        pw.println(prefix + "  mCurrentAppOrientation=" + ActivityInfo.screenOrientationToString(this.mCurrentAppOrientation));
        pw.println(prefix + "  mLastOrientation=" + this.mLastOrientation);
        pw.print(prefix + "  mRotation=" + this.mRotation);
        StringBuilder r0 = new StringBuilder();
        r0.append(" mDeferredRotationPauseCount=");
        r0.append(this.mDeferredRotationPauseCount);
        pw.println(r0.toString());
        pw.print(prefix + "  mLandscapeRotation=" + Surface.rotationToString(this.mLandscapeRotation));
        StringBuilder r1 = new StringBuilder();
        r1.append(" mSeascapeRotation=");
        r1.append(Surface.rotationToString(this.mSeascapeRotation));
        pw.println(r1.toString());
        pw.print(prefix + "  mPortraitRotation=" + Surface.rotationToString(this.mPortraitRotation));
        StringBuilder r2 = new StringBuilder();
        r2.append(" mUpsideDownRotation=");
        r2.append(Surface.rotationToString(this.mUpsideDownRotation));
        pw.println(r2.toString());
        pw.println(prefix + "  mSupportAutoRotation=" + this.mSupportAutoRotation);
        if (this.mOrientationListener == null) goto L5;
        this.mOrientationListener.dump(pw, prefix + "  ");
    L5:
        pw.println();
        pw.print(prefix + "  mCarDockRotation=" + Surface.rotationToString(this.mCarDockRotation));
        StringBuilder r3 = new StringBuilder();
        r3.append(" mDeskDockRotation=");
        r3.append(Surface.rotationToString(this.mDeskDockRotation));
        pw.println(r3.toString());
        pw.print(prefix + "  mUserRotationMode=" + WindowManagerPolicy.userRotationModeToString(this.mUserRotationMode));
        StringBuilder r4 = new StringBuilder();
        r4.append(" mUserRotation=");
        r4.append(Surface.rotationToString(this.mUserRotation));
        pw.print(r4.toString());
        pw.print(" mCameraRotationMode=" + this.mCameraRotationMode);
        pw.println(" mAllowAllRotations=" + allowAllRotationsToString(this.mAllowAllRotations));
        pw.print(prefix + "  mDemoHdmiRotation=" + Surface.rotationToString(this.mDemoHdmiRotation));
        StringBuilder r5 = new StringBuilder();
        r5.append(" mDemoHdmiRotationLock=");
        r5.append(this.mDemoHdmiRotationLock);
        pw.print(r5.toString());
        pw.println(" mUndockedHdmiRotation=" + Surface.rotationToString(this.mUndockedHdmiRotation));
        pw.println(prefix + "  mLidOpenRotation=" + Surface.rotationToString(this.mLidOpenRotation));
        pw.println(prefix + "  mFixedToUserRotation=" + isFixedToUserRotation());
        if (this.mFoldController == null) goto L9;
        pw.println(prefix + "FoldController");
        pw.println(prefix + "  mPauseAutorotationDuringUnfolding=" + FoldController.m9975$$Nest$fgetmPauseAutorotationDuringUnfolding(this.mFoldController));
        pw.println(prefix + "  mShouldDisableRotationSensor=" + FoldController.m9976$$Nest$fgetmShouldDisableRotationSensor(this.mFoldController));
        pw.println(prefix + "  mShouldIgnoreSensorRotation=" + FoldController.m9977$$Nest$fgetmShouldIgnoreSensorRotation(this.mFoldController));
        pw.println(prefix + "  mLastDisplaySwitchTime=" + FoldController.m9973$$Nest$fgetmLastDisplaySwitchTime(this.mFoldController));
        pw.println(prefix + "  mLastHingeAngleEventTime=" + FoldController.m9974$$Nest$fgetmLastHingeAngleEventTime(this.mFoldController));
        pw.println(prefix + "  mDeviceState=" + FoldController.m9970$$Nest$fgetmDeviceState(this.mFoldController));
    L9:
        if (this.mRotationHistory.mRecords.isEmpty() == true) goto L15;
        pw.println();
        pw.println(prefix + "  RotationHistory");
        prefix = "    " + prefix;
        Iterator<RotationHistory.Record> r6 = this.mRotationHistory.mRecords.iterator();
    L12:
        if (r6.hasNext() == false) goto L15;
        RotationHistory.Record r = r6.next();
        r.dump(prefix, pw);
    L15:
        if (RotationLockHistory.m9979$$Nest$fgetmRecords(this.mRotationLockHistory).isEmpty() == true) goto L20;
        pw.println();
        pw.println(prefix + "  RotationLockHistory");
        String prefix2 = "    " + prefix;
        Iterator r7 = RotationLockHistory.m9979$$Nest$fgetmRecords(this.mRotationLockHistory).iterator();
    L18:
        if (r7.hasNext() == false) goto L23;
        RotationLockHistory.Record r8 = (RotationLockHistory.Record) r7.next();
        r8.dump(prefix2, pw);
        goto L18
    L23:
        return;
    }

    void dumpDebug(ProtoOutputStream proto, long fieldId) {
        long token = proto.start(fieldId);
        proto.write(1120986464257L, getRotation());
        proto.write(1133871366146L, isRotationFrozen());
        proto.write(1120986464259L, getUserRotation());
        proto.write(1120986464260L, this.mFixedToUserRotation);
        proto.write(1120986464261L, this.mLastOrientation);
        proto.write(1133871366150L, isFixedToUserRotation());
        proto.end(token);
    }

    boolean isDeviceInPosture(DeviceStateController.DeviceState state, boolean isTabletop) {
        if (this.mFoldController != null) goto L7;
        return false;
    L7:
        return this.mFoldController.isDeviceInPosture(state, isTabletop);
    }

    boolean isDisplaySeparatingHinge() {
        if (this.mFoldController != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mFoldController.isSeparatingHinge() == false) goto L7;
        return true;
    }

    void foldStateChanged(DeviceStateController.DeviceState deviceState) {
        if (this.mFoldController == null) goto L15;
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mFoldController.foldStateChanged(deviceState);     // Catch: Throwable -> L9
        if (this.mDeviceStateAutoRotateSettingController == null) goto L11;
        this.mDeviceStateAutoRotateSettingController.onDeviceStateChange(deviceState);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    void physicalDisplayChanged() {
        if (this.mFoldController == null) goto L6;
        this.mFoldController.onPhysicalDisplayChanged();
        return;
    }

    int getDemoUserRotationOverride() {
        return SystemProperties.getInt("persist.demo.userrotation", 0);
    }

    String getDemoUserRotationPackage() {
        return SystemProperties.get("persist.demo.userrotation.package_name");
    }

    private int getUserRotationOverride() {
        int userRotationOverride = getDemoUserRotationOverride();
        if (userRotationOverride != 0) goto L5;
        return userRotationOverride;
    L5:
        Display display = this.mDisplayContent.getDisplay();
        if (display.getType() != 2) goto L8;
    L19:
        return userRotationOverride;
    L8:
        if (display.getType() == 4) goto L19;
        if (display.getType() != 5) goto L17;
        String packageName = getDemoUserRotationPackage();
        if (packageName.isEmpty() == false) goto L15;
        return 0;
    L15:
        if (packageName.equals(display.getOwnerPackageName()) == false) goto L21;
        return userRotationOverride;
    L21:
        return 0;
    L17:
        return 0;
    }

    long uptimeMillis() {
        return SystemClock.uptimeMillis();
    }

    Handler getHandler() {
        return this.mService.mH;
    }
}
