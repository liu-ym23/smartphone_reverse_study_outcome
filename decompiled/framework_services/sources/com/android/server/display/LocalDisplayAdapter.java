package com.android.server.display;

import android.R;
import android.app.ActivityThread;
import android.content.Context;
import android.content.res.Resources;
import android.hardware.sidekick.SidekickInternal;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemProperties;
import android.os.Trace;
import android.pico.utils.ExtImplFactory;
import android.util.DisplayUtils;
import android.util.LongSparseArray;
import android.util.Slog;
import android.util.SparseArray;
import android.util.Spline;
import android.view.Display;
import android.view.DisplayAddress;
import android.view.DisplayCutout;
import android.view.DisplayEventReceiver;
import android.view.DisplayShape;
import android.view.FrameRateCategoryRate;
import android.view.RoundedCorners;
import android.view.SurfaceControl;
import com.android.internal.display.BrightnessSynchronizer;
import com.android.internal.util.function.pooled.PooledLambda;
import com.android.server.LocalServices;
import com.android.server.display.color.ColorDisplayService;
import com.android.server.display.feature.DisplayManagerFlags;
import com.android.server.display.mode.DisplayModeDirector;
import com.android.server.display.notifications.DisplayNotificationManager;
import com.android.server.lights.LightsManager;
import com.android.server.lights.LogicalLight;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class LocalDisplayAdapter extends DisplayAdapter {
    private static final double BASE_TOUCH_TARGET_SIZE_DP = 48.0d;
    private static final boolean DEBUG = false;
    private static final double DEFAULT_DISPLAY_SIZE = 24.0d;
    private static final double EXTERNAL_DISPLAY_BASE_TOUCH_TARGET_SIZE_IN_INCHES = 0.40944881889763785d;
    private static final String PROPERTY_EMULATOR_CIRCULAR = "ro.boot.emulator.circular";
    private static final String TAG = "LocalDisplayAdapter";
    private static final String UNIQUE_ID_PREFIX = "local:";
    private ColorDisplayService.ColorDisplayServiceInternal mCdsi;
    private final LongSparseArray<LocalDisplayDevice> mDevices;
    private final DisplayNotificationManager mDisplayNotificationManager;
    private boolean mEvenDimmerEnabled;
    private int mEvenDimmerStrength;
    private IExtLocalDisplayAdapter mExt;
    private final Injector mInjector;
    private final boolean mIsBootDisplayModeSupported;
    private Spline mNitsToEvenDimmerStrength;
    private Context mOverlayContext;
    private final SurfaceControlProxy mSurfaceControlProxy;

    static class BacklightAdapter {
        private final LogicalLight mBacklight;
        private final IBinder mDisplayToken;
        private boolean mForceSurfaceControl;
        private final SurfaceControlProxy mSurfaceControlProxy;
        private final boolean mUseSurfaceControlBrightness;

        /* JADX INFO: renamed from: -$$Nest$fgetmForceSurfaceControl, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m3838$$Nest$fgetmForceSurfaceControl(BacklightAdapter r0) {
            return r0.mForceSurfaceControl;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmUseSurfaceControlBrightness, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m3839$$Nest$fgetmUseSurfaceControlBrightness(BacklightAdapter r0) {
            return r0.mUseSurfaceControlBrightness;
        }

        BacklightAdapter(IBinder displayToken, boolean isFirstDisplay, SurfaceControlProxy surfaceControlProxy) {
            this.mForceSurfaceControl = false;
            this.mDisplayToken = displayToken;
            this.mSurfaceControlProxy = surfaceControlProxy;
            this.mUseSurfaceControlBrightness = this.mSurfaceControlProxy.getDisplayBrightnessSupport(this.mDisplayToken);
            if (this.mUseSurfaceControlBrightness == true) goto L6;
            if (isFirstDisplay == false) goto L6;
            LightsManager lights = (LightsManager) LocalServices.getService(LightsManager.class);
            this.mBacklight = lights.getLight(0);
            return;
        L6:
            this.mBacklight = null;
        }

        void setBacklight(float sdrBacklight, float sdrNits, float backlight, float nits) {
            if (this.mUseSurfaceControlBrightness == true) goto L12;
            if (this.mForceSurfaceControl == true) goto L12;
            if (this.mBacklight == null) goto L17;
            this.mBacklight.setBrightness(backlight);
            return;
        L17:
            return;
        L12:
            if (BrightnessSynchronizer.floatEquals(sdrBacklight, Float.NaN) == false) goto L14;
            this.mSurfaceControlProxy.setDisplayBrightness(this.mDisplayToken, backlight);
            return;
        L14:
            this.mSurfaceControlProxy.setDisplayBrightness(this.mDisplayToken, sdrBacklight, sdrNits, backlight, nits);
        }

        void setForceSurfaceControl(boolean forceSurfaceControl) {
            this.mForceSurfaceControl = forceSurfaceControl;
        }

        public String toString() {
            return "BacklightAdapter [useSurfaceControl=" + this.mUseSurfaceControlBrightness + " (force_anyway? " + this.mForceSurfaceControl + "), backlight=" + this.mBacklight + "]";
        }
    }

    public interface DisplayEventListener {
        void onFrameRateOverridesChanged(long r1, long r3, DisplayEventReceiver.FrameRateOverride[] r5);

        void onHdcpLevelsChanged(long r1, int r3, int r4);

        void onHotplug(long r1, long r3, boolean r5);

        void onHotplugConnectionError(long r1, int r3);

        void onModeChanged(long r1, long r3, int r5, long r6);
    }

    private static final class DisplayModeRecord {
        public final Display.Mode mMode;

        DisplayModeRecord(SurfaceControl.DisplayMode mode, float[] alternativeRefreshRates) {
            this.mMode = DisplayAdapter.createMode(mode.width, mode.height, mode.peakRefreshRate, mode.vsyncRate, alternativeRefreshRates, mode.supportedHdrTypes);
        }

        public boolean hasMatchingMode(SurfaceControl.DisplayMode mode) {
            if (this.mMode.getPhysicalWidth() == mode.width) goto L5;
        L11:
            return false;
        L5:
            if (this.mMode.getPhysicalHeight() != mode.height) goto L11;
            if (Float.floatToIntBits(this.mMode.getRefreshRate()) != Float.floatToIntBits(mode.peakRefreshRate)) goto L11;
            if (Float.floatToIntBits(this.mMode.getVsyncRate()) != Float.floatToIntBits(mode.vsyncRate)) goto L11;
            return true;
        }

        public String toString() {
            return "DisplayModeRecord{mMode=" + this.mMode + "}";
        }
    }

    public static class Injector {
        private ProxyDisplayEventReceiver mReceiver;

        public Injector() {
        }

        public void setDisplayEventListenerLocked(Looper looper, DisplayEventListener listener) {
            this.mReceiver = new ProxyDisplayEventReceiver(looper, listener);
        }

        public SurfaceControlProxy getSurfaceControlProxy() {
            return new SurfaceControlProxy();
        }

        public DisplayDeviceConfig createDisplayDeviceConfig(Context context, long physicalDisplayId, boolean isFirstDisplay, DisplayManagerFlags flags) {
            return DisplayDeviceConfig.create(context, physicalDisplayId, isFirstDisplay, flags);
        }

        public BacklightAdapter getBacklightAdapter(IBinder displayToken, boolean isFirstDisplay, SurfaceControlProxy surfaceControlProxy) {
            return new BacklightAdapter(displayToken, isFirstDisplay, surfaceControlProxy);
        }
    }

    protected final class LocalDisplayDevice extends DisplayDevice {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private int mActiveColorMode;
        private int mActiveModeId;
        private float mActiveRenderFrameRate;
        private SurfaceControl.DisplayMode mActiveSfDisplayMode;
        private int mActiveSfDisplayModeAtStartId;
        private boolean mAllmRequested;
        private boolean mAllmSupported;
        private final BacklightAdapter mBacklightAdapter;
        private float mBrightnessState;
        private int mCommittedState;
        private int mConnectedHdcpLevel;
        private float mCurrentHdrSdrRatio;
        private int mDefaultModeGroup;
        private int mDefaultModeId;
        final DisplayModeDirector.DesiredDisplayModeSpecs mDisplayModeSpecs;
        private boolean mDisplayModeSpecsInvalid;
        private FrameRateCategoryRate mFrameRateCategoryRate;
        private DisplayEventReceiver.FrameRateOverride[] mFrameRateOverrides;
        private boolean mGameContentTypeRequested;
        private boolean mGameContentTypeSupported;
        private boolean mHasArrSupport;
        private boolean mHavePendingChanges;
        private Display.HdrCapabilities mHdrCapabilities;
        private DisplayDeviceInfo mInfo;
        private final boolean mIsFirstDisplay;
        private final long mPhysicalDisplayId;
        private float mSdrBrightnessState;
        SurfaceControl.DesiredDisplayModeSpecs mSfDisplayModeSpecs;
        private SurfaceControl.DisplayMode[] mSfDisplayModes;
        private boolean mSidekickActive;
        private final SidekickInternal mSidekickInternal;
        private int mState;
        private SurfaceControl.StaticDisplayInfo mStaticDisplayInfo;
        private final ArrayList<Integer> mSupportedColorModes;
        private final SparseArray<DisplayModeRecord> mSupportedModes;
        private float[] mSupportedRefreshRates;
        private int mSystemPreferredModeId;
        private Display.Mode mUserPreferredMode;
        private int mUserPreferredModeId;
        final /* synthetic */ LocalDisplayAdapter this$0;

        public static /* synthetic */ void $r8$lambda$NzC1iSMVu_tgB5rNAKv1CHyLmPA(LocalDisplayDevice r0, IBinder r1, int r2) {
            r0.requestColorModeAsync(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmBacklightAdapter, reason: not valid java name */
        static /* bridge */ /* synthetic */ BacklightAdapter m3840$$Nest$fgetmBacklightAdapter(LocalDisplayDevice r0) {
            return r0.mBacklightAdapter;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmCurrentHdrSdrRatio, reason: not valid java name */
        static /* bridge */ /* synthetic */ float m3841$$Nest$fgetmCurrentHdrSdrRatio(LocalDisplayDevice r0) {
            return r0.mCurrentHdrSdrRatio;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmSidekickActive, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m3842$$Nest$fgetmSidekickActive(LocalDisplayDevice r0) {
            return r0.mSidekickActive;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmSidekickInternal, reason: not valid java name */
        static /* bridge */ /* synthetic */ SidekickInternal m3843$$Nest$fgetmSidekickInternal(LocalDisplayDevice r0) {
            return r0.mSidekickInternal;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmBrightnessState, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m3844$$Nest$fputmBrightnessState(LocalDisplayDevice r0, float r1) {
            r0.mBrightnessState = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmCommittedState, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m3845$$Nest$fputmCommittedState(LocalDisplayDevice r0, int r1) {
            r0.mCommittedState = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmCurrentHdrSdrRatio, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m3846$$Nest$fputmCurrentHdrSdrRatio(LocalDisplayDevice r0, float r1) {
            r0.mCurrentHdrSdrRatio = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmSdrBrightnessState, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m3847$$Nest$fputmSdrBrightnessState(LocalDisplayDevice r0, float r1) {
            r0.mSdrBrightnessState = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmSidekickActive, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m3848$$Nest$fputmSidekickActive(LocalDisplayDevice r0, boolean r1) {
            r0.mSidekickActive = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$mupdateDeviceInfoLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m3849$$Nest$mupdateDeviceInfoLocked(LocalDisplayDevice r0) {
            r0.updateDeviceInfoLocked();
        }

        static {
        }

        LocalDisplayDevice(LocalDisplayAdapter this$0, IBinder displayToken, long physicalDisplayId, SurfaceControl.StaticDisplayInfo staticDisplayInfo, SurfaceControl.DynamicDisplayInfo dynamicInfo, SurfaceControl.DesiredDisplayModeSpecs modeSpecs, boolean isFirstDisplay) {
            this.this$0 = this$0;
            super(this$0, displayToken, LocalDisplayAdapter.UNIQUE_ID_PREFIX + physicalDisplayId, this$0.getContext(), this$0.getFeatureFlags().isPixelAnisotropyCorrectionInLogicalDisplayEnabled());
            this.mSupportedModes = new SparseArray();
            this.mSupportedColorModes = new ArrayList();
            this.mDisplayModeSpecs = new DisplayModeDirector.DesiredDisplayModeSpecs();
            this.mState = 0;
            this.mCommittedState = 0;
            this.mBrightnessState = Float.NaN;
            this.mSdrBrightnessState = Float.NaN;
            this.mCurrentHdrSdrRatio = Float.NaN;
            this.mDefaultModeId = -1;
            this.mSystemPreferredModeId = -1;
            this.mUserPreferredModeId = -1;
            this.mActiveSfDisplayModeAtStartId = -1;
            this.mActiveModeId = -1;
            this.mSupportedRefreshRates = new float[0];
            this.mFrameRateOverrides = new DisplayEventReceiver.FrameRateOverride[0];
            this.mPhysicalDisplayId = physicalDisplayId;
            this.mIsFirstDisplay = isFirstDisplay;
            updateDisplayPropertiesLocked(staticDisplayInfo, dynamicInfo, modeSpecs);
            this.mSidekickInternal = (SidekickInternal) LocalServices.getService(SidekickInternal.class);
            this.mBacklightAdapter = LocalDisplayAdapter.m3827$$Nest$fgetmInjector(this$0).getBacklightAdapter(displayToken, isFirstDisplay, LocalDisplayAdapter.m3830$$Nest$fgetmSurfaceControlProxy(this$0));
            this.mActiveSfDisplayModeAtStartId = dynamicInfo.activeDisplayModeId;
        }

        @Override // com.android.server.display.DisplayDevice
        public boolean hasStableUniqueId() {
            return true;
        }

        @Override // com.android.server.display.DisplayDevice
        public Display.Mode getActiveDisplayModeAtStartLocked() {
            return findMode(findMatchingModeIdLocked(this.mActiveSfDisplayModeAtStartId));
        }

        public boolean updateDisplayPropertiesLocked(SurfaceControl.StaticDisplayInfo staticInfo, SurfaceControl.DynamicDisplayInfo dynamicInfo, SurfaceControl.DesiredDisplayModeSpecs modeSpecs) {
            boolean changed = updateDisplayModesLocked(dynamicInfo.supportedDisplayModes, dynamicInfo.preferredBootDisplayMode, dynamicInfo.activeDisplayModeId, dynamicInfo.renderFrameRate, modeSpecs);
            boolean changed2 = (((((((changed | updateStaticInfo(staticInfo)) | updateColorModesLocked(dynamicInfo.supportedColorModes, dynamicInfo.activeColorMode)) | updateHdrCapabilitiesLocked(dynamicInfo.hdrCapabilities)) | updateAllmSupport(dynamicInfo.autoLowLatencyModeSupported)) | updateGameContentTypeSupport(dynamicInfo.gameContentTypeSupported)) | updateHasArrSupportLocked(dynamicInfo.hasArrSupport)) | updateFrameRateCategoryRatesLocked(dynamicInfo.frameRateCategoryRate)) | updateSupportedRefreshatesLocked(dynamicInfo.supportedRefreshRates);
            if (changed2 == false) goto L5;
            this.mHavePendingChanges = true;
        L5:
            return changed2;
        }

        public boolean updateDisplayModesLocked(SurfaceControl.DisplayMode[] displayModes, int preferredSfDisplayModeId, int activeSfDisplayModeId, float renderFrameRate, SurfaceControl.DesiredDisplayModeSpecs modeSpecs) {
            this.mSfDisplayModes = (SurfaceControl.DisplayMode[]) Arrays.copyOf(displayModes, displayModes.length);
            this.mActiveSfDisplayMode = getModeById(displayModes, activeSfDisplayModeId);
            this.mSfDisplayModeSpecs = new SurfaceControl.DesiredDisplayModeSpecs(modeSpecs);
            SurfaceControl.DisplayMode preferredSfDisplayMode = getModeById(displayModes, preferredSfDisplayModeId);
            ArrayList<DisplayModeRecord> records = new ArrayList();
            boolean modesAdded = false;
            int i = 0;
        L4:
            if (i >= displayModes.length) goto L43;
            SurfaceControl.DisplayMode mode = displayModes[i];
            List<Float> alternativeRefreshRates = new ArrayList();
            int j = 0;
        L7:
            if (j >= displayModes.length) goto L23;
            SurfaceControl.DisplayMode other = displayModes[j];
            if (j != i) goto L11;
        L19:
            boolean isAlternative = false;
        L20:
            if (isAlternative == false) goto L22;
            alternativeRefreshRates.add(Float.valueOf(displayModes[j].peakRefreshRate));
        L22:
            j = j + 1;
            goto L7
        L11:
            if (other.width != mode.width) goto L19;
            if (other.height != mode.height) goto L19;
            if (other.peakRefreshRate == mode.peakRefreshRate) goto L19;
            if (other.group != mode.group) goto L19;
            isAlternative = true;
            goto L20
        L23:
            Collections.sort(alternativeRefreshRates);
            boolean existingMode = false;
            Iterator<DisplayModeRecord> r11 = records.iterator();
        L25:
            if (r11.hasNext() == false) goto L32;
            DisplayModeRecord record = r11.next();
            if (record.hasMatchingMode(mode) == false) goto L25;
            if (refreshRatesEquals(alternativeRefreshRates, record.mMode.getAlternativeRefreshRates()) == false) goto L25;
            existingMode = true;
        L32:
            if (existingMode == true) goto L42;
            DisplayModeRecord record2 = findDisplayModeRecord(mode, alternativeRefreshRates);
            if (record2 != null) goto L41;
            float[] alternativeRates = new float[alternativeRefreshRates.size()];
            int j2 = 0;
        L38:
            if (j2 >= alternativeRates.length) goto L40;
            alternativeRates[j2] = alternativeRefreshRates.get(j2).floatValue();
            j2 = j2 + 1;
            goto L38
        L40:
            record2 = new DisplayModeRecord(mode, alternativeRates);
            modesAdded = true;
        L41:
            records.add(record2);
        L42:
            i = i + 1;
            goto L4
        L43:
            DisplayModeRecord activeRecord = null;
            Iterator<DisplayModeRecord> r9 = records.iterator();
        L45:
            if (r9.hasNext() == false) goto L50;
            DisplayModeRecord record3 = r9.next();
            if (record3.hasMatchingMode(this.mActiveSfDisplayMode) == false) goto L45;
            activeRecord = record3;
        L50:
            boolean preferredModeChanged = false;
            if (preferredSfDisplayModeId == (-1)) goto L66;
            if (preferredSfDisplayMode == null) goto L66;
            DisplayModeRecord preferredRecord = null;
            Iterator<DisplayModeRecord> r14 = records.iterator();
        L55:
            if (r14.hasNext() == false) goto L60;
            DisplayModeRecord record4 = r14.next();
            if (record4.hasMatchingMode(preferredSfDisplayMode) == false) goto L55;
            preferredRecord = record4;
        L60:
            if (preferredRecord == null) goto L66;
            int preferredModeId = preferredRecord.mMode.getModeId();
            if (LocalDisplayAdapter.m3828$$Nest$fgetmIsBootDisplayModeSupported(this.this$0) == false) goto L66;
            if (this.mSystemPreferredModeId == preferredModeId) goto L66;
            this.mSystemPreferredModeId = preferredModeId;
            preferredModeChanged = true;
        L66:
            boolean activeModeChanged = false;
            if (this.mActiveModeId != (-1)) goto L69;
        L71:
            boolean renderFrameRateChanged = false;
            if (this.mActiveRenderFrameRate <= 0.0f) goto L77;
            if (this.mActiveRenderFrameRate == renderFrameRate) goto L77;
            Slog.d(LocalDisplayAdapter.TAG, "The render frame rate was changed from SurfaceFlinger or the display device to " + renderFrameRate);
            this.mActiveRenderFrameRate = renderFrameRate;
            renderFrameRateChanged = true;
            this.this$0.sendTraversalRequestLocked();
        L77:
            if (this.mDisplayModeSpecs.baseModeId == (-1)) goto L88;
            int activeBaseMode = findMatchingModeIdLocked(modeSpecs.defaultMode);
            if (activeBaseMode != (-1)) goto L81;
        L86:
            this.mDisplayModeSpecsInvalid = true;
            this.this$0.sendTraversalRequestLocked();
            goto L88
        L81:
            if (this.mDisplayModeSpecs.baseModeId != activeBaseMode) goto L86;
            if (this.mDisplayModeSpecs.primary.equals(modeSpecs.primaryRanges) == false) goto L86;
            if (this.mDisplayModeSpecs.appRequest.equals(modeSpecs.appRequestRanges) == false) goto L86;
        L88:
            if (records.size() != this.mSupportedModes.size()) goto L92;
            if (modesAdded == true) goto L92;
            boolean recordsChanged = false;
        L93:
            if (recordsChanged == true) goto L101;
            if (activeModeChanged == true) goto L99;
            if (preferredModeChanged == true) goto L99;
            if (renderFrameRateChanged == true) goto L99;
            return false;
        L99:
            return true;
        L101:
            this.mSupportedModes.clear();
            Iterator<DisplayModeRecord> r10 = records.iterator();
        L103:
            if (r10.hasNext() == false) goto L106;
            DisplayModeRecord record5 = r10.next();
            this.mSupportedModes.put(record5.mMode.getModeId(), record5);
            recordsChanged = recordsChanged;
            goto L103
        L106:
            if (this.mDefaultModeId != (-1)) goto L108;
            this.mDefaultModeId = activeRecord.mMode.getModeId();
            this.mDefaultModeGroup = this.mActiveSfDisplayMode.group;
            this.mActiveRenderFrameRate = renderFrameRate;
        L115:
            if (this.mSupportedModes.indexOfKey(this.mDisplayModeSpecs.baseModeId) >= 0) goto L121;
            if (this.mDisplayModeSpecs.baseModeId == (-1)) goto L119;
            Slog.w(LocalDisplayAdapter.TAG, "DisplayModeSpecs base mode no longer available, using currently active mode.");
        L119:
            this.mDisplayModeSpecs.baseModeId = activeRecord.mMode.getModeId();
            this.mDisplayModeSpecsInvalid = true;
        L121:
            if (this.mUserPreferredMode == null) goto L124;
            this.mUserPreferredModeId = findUserPreferredModeIdLocked(this.mUserPreferredMode);
        L124:
            if (this.mSupportedModes.indexOfKey(this.mActiveModeId) < 0) goto L126;
        L129:
            this.this$0.sendTraversalRequestLocked();
            return true;
        L126:
            if (this.mActiveModeId == (-1)) goto L128;
            Slog.w(LocalDisplayAdapter.TAG, "Active display mode no longer available, reverting to default mode.");
        L128:
            this.mActiveModeId = getPreferredModeId();
            goto L129
        L108:
            if (modesAdded == false) goto L112;
            if (activeModeChanged == false) goto L112;
            Slog.d(LocalDisplayAdapter.TAG, "New display modes are added and the active mode has changed, use active mode as default mode.");
            this.mDefaultModeId = activeRecord.mMode.getModeId();
            this.mDefaultModeGroup = this.mActiveSfDisplayMode.group;
            this.mActiveRenderFrameRate = renderFrameRate;
        L112:
            if (findSfDisplayModeIdLocked(this.mDefaultModeId, this.mDefaultModeGroup) >= 0) goto L115;
            Slog.w(LocalDisplayAdapter.TAG, "Default display mode no longer available, using currently active mode as default.");
            this.mDefaultModeId = activeRecord.mMode.getModeId();
            this.mDefaultModeGroup = this.mActiveSfDisplayMode.group;
            this.mActiveRenderFrameRate = renderFrameRate;
        L92:
            recordsChanged = true;
            goto L93
        L69:
            if (this.mActiveModeId == activeRecord.mMode.getModeId()) goto L71;
            Slog.d(LocalDisplayAdapter.TAG, "The active mode was changed from SurfaceFlinger or the display device to " + activeRecord.mMode);
            this.mActiveModeId = activeRecord.mMode.getModeId();
            activeModeChanged = true;
            this.this$0.sendTraversalRequestLocked();
            goto L71
        }

        @Override // com.android.server.display.DisplayDevice
        public DisplayDeviceConfig getDisplayDeviceConfig() {
            if (this.mDisplayDeviceConfig != null) goto L6;
            loadDisplayDeviceConfig();
        L6:
            return this.mDisplayDeviceConfig;
        }

        private int getPreferredModeId() {
            if (this.mUserPreferredModeId == (-1)) goto L6;
            return this.mUserPreferredModeId;
        L6:
            return this.mDefaultModeId;
        }

        private int getLogicalDensity() {
            DensityMapping densityMapping = getDisplayDeviceConfig().getDensityMapping();
            if (densityMapping != null) goto L19;
            if (this.this$0.getFeatureFlags().isBaseDensityForExternalDisplaysEnabled() == false) goto L17;
            if (this.mStaticDisplayInfo.isInternal == true) goto L17;
            if (this.mActiveSfDisplayMode.xDpi > 0.0f) goto L11;
        L13:
            double ppi = Math.sqrt(Math.pow(this.mInfo.width, 2.0d) + Math.pow(this.mInfo.height, 2.0d)) / LocalDisplayAdapter.DEFAULT_DISPLAY_SIZE;
        L14:
            double pixels = LocalDisplayAdapter.EXTERNAL_DISPLAY_BASE_TOUCH_TARGET_SIZE_IN_INCHES * ppi;
            double dpi = (160.0d * pixels) / LocalDisplayAdapter.BASE_TOUCH_TARGET_SIZE_DP;
            return (int) (0.5d + dpi);
        L11:
            if (this.mActiveSfDisplayMode.yDpi <= 0.0f) goto L13;
            ppi = Math.sqrt((Math.pow(this.mActiveSfDisplayMode.xDpi, 2.0d) + Math.pow(this.mActiveSfDisplayMode.yDpi, 2.0d)) / 2.0d);
        L17:
            return (int) (((double) (this.mStaticDisplayInfo.density * 160.0f)) + 0.5d);
        L19:
            return densityMapping.getDensityForResolution(this.mInfo.width, this.mInfo.height);
        }

        private void loadDisplayDeviceConfig() {
            Context context = this.this$0.getOverlayContext();
            this.mDisplayDeviceConfig = LocalDisplayAdapter.m3827$$Nest$fgetmInjector(this.this$0).createDisplayDeviceConfig(context, this.mPhysicalDisplayId, this.mIsFirstDisplay, this.this$0.getFeatureFlags());
            this.mBacklightAdapter.setForceSurfaceControl(this.mDisplayDeviceConfig.hasQuirk(DisplayDeviceConfig.QUIRK_CAN_SET_BRIGHTNESS_VIA_HWC));
        }

        private boolean updateStaticInfo(SurfaceControl.StaticDisplayInfo info) {
            if (Objects.equals(this.mStaticDisplayInfo, info) == false) goto L6;
            return false;
        L6:
            this.mStaticDisplayInfo = info;
            return true;
        }

        private boolean updateColorModesLocked(int[] colorModes, int activeColorMode) {
            if (colorModes != null) goto L5;
            return false;
        L5:
            List<Integer> pendingColorModes = new ArrayList();
            boolean colorModesAdded = false;
            int r3 = colorModes.length;
            int r4 = 0;
        L6:
            if (r4 >= r3) goto L12;
            int colorMode = colorModes[r4];
            if (this.mSupportedColorModes.contains(Integer.valueOf(colorMode)) == true) goto L10;
            colorModesAdded = true;
        L10:
            pendingColorModes.add(Integer.valueOf(colorMode));
            r4 = r4 + 1;
            goto L6
        L12:
            if (pendingColorModes.size() != this.mSupportedColorModes.size()) goto L16;
            if (colorModesAdded == true) goto L16;
            boolean colorModesChanged = false;
        L17:
            if (colorModesChanged == true) goto L19;
            return false;
        L19:
            this.mSupportedColorModes.clear();
            this.mSupportedColorModes.addAll(pendingColorModes);
            Collections.sort(this.mSupportedColorModes);
            if (this.mSupportedColorModes.contains(Integer.valueOf(this.mActiveColorMode)) == false) goto L22;
        L28:
            return true;
        L22:
            if (this.mActiveColorMode == 0) goto L25;
            Slog.w(LocalDisplayAdapter.TAG, "Active color mode no longer available, reverting to default mode.");
            this.mActiveColorMode = 0;
            goto L28
        L25:
            if (this.mSupportedColorModes.isEmpty() == true) goto L27;
            Slog.e(LocalDisplayAdapter.TAG, "Default and active color mode is no longer available! Reverting to first available mode.");
            this.mActiveColorMode = this.mSupportedColorModes.get(0).intValue();
            goto L28
        L27:
            Slog.e(LocalDisplayAdapter.TAG, "No color modes available!");
        L16:
            colorModesChanged = true;
            goto L17
        }

        private boolean updateHdrCapabilitiesLocked(Display.HdrCapabilities newHdrCapabilities) {
            if (Objects.equals(this.mHdrCapabilities, newHdrCapabilities) == false) goto L6;
            return false;
        L6:
            this.mHdrCapabilities = newHdrCapabilities;
            return true;
        }

        private boolean updateFrameRateCategoryRatesLocked(FrameRateCategoryRate newFrameRateCategoryRate) {
            if (Objects.equals(this.mFrameRateCategoryRate, newFrameRateCategoryRate) == false) goto L6;
            return false;
        L6:
            this.mFrameRateCategoryRate = newFrameRateCategoryRate;
            return true;
        }

        private boolean updateHasArrSupportLocked(boolean newHasArrSupport) {
            if (this.mHasArrSupport != newHasArrSupport) goto L6;
            return false;
        L6:
            this.mHasArrSupport = newHasArrSupport;
            return true;
        }

        private boolean updateSupportedRefreshatesLocked(float[] supportedRefreshRates) {
            if (this.this$0.getFeatureFlags().enableGetSupportedRefreshRates() == true) goto L5;
            return false;
        L5:
            if (supportedRefreshRates != null) goto L8;
            return false;
        L8:
            if (Arrays.equals(this.mSupportedRefreshRates, supportedRefreshRates) == false) goto L10;
            return false;
        L10:
            this.mSupportedRefreshRates = supportedRefreshRates;
            return true;
        }

        private boolean updateAllmSupport(boolean supported) {
            if (this.mAllmSupported != supported) goto L6;
            return false;
        L6:
            this.mAllmSupported = supported;
            return true;
        }

        private boolean updateGameContentTypeSupport(boolean supported) {
            if (this.mGameContentTypeSupported != supported) goto L6;
            return false;
        L6:
            this.mGameContentTypeSupported = supported;
            return true;
        }

        private SurfaceControl.DisplayMode getModeById(SurfaceControl.DisplayMode[] supportedModes, int modeId) {
            int r0 = supportedModes.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L8;
            SurfaceControl.DisplayMode mode = supportedModes[r1];
            if (mode.id == modeId) goto L6;
            r1 = r1 + 1;
            goto L3
        L6:
            return mode;
        L8:
            Slog.e(LocalDisplayAdapter.TAG, "Can't find display mode with id " + modeId);
            return null;
        }

        private DisplayModeRecord findDisplayModeRecord(SurfaceControl.DisplayMode mode, List<Float> alternativeRefreshRates) {
            int i = 0;
        L4:
            if (i >= this.mSupportedModes.size()) goto L13;
            DisplayModeRecord record = this.mSupportedModes.valueAt(i);
            if (record.hasMatchingMode(mode) == false) goto L12;
            if (refreshRatesEquals(alternativeRefreshRates, record.mMode.getAlternativeRefreshRates()) == false) goto L12;
            if (LocalDisplayAdapter.m3835$$Nest$mhdrTypesEqual(this.this$0, mode.supportedHdrTypes, record.mMode.getSupportedHdrTypes()) == false) goto L12;
            return record;
        L12:
            i = i + 1;
            goto L4
        L13:
            return null;
        }

        private boolean refreshRatesEquals(List<Float> list, float[] array) {
            if (list.size() == array.length) goto L5;
            return false;
        L5:
            int i = 0;
        L7:
            if (i >= list.size()) goto L12;
            if (Float.floatToIntBits(list.get(i).floatValue()) != Float.floatToIntBits(array[i])) goto L10;
            i = i + 1;
            goto L7
        L10:
            return false;
        L12:
            return true;
        }

        @Override // com.android.server.display.DisplayDevice
        public void applyPendingDisplayDeviceInfoChangesLocked() {
            if (this.mHavePendingChanges == false) goto L6;
            this.mInfo = null;
            this.mHavePendingChanges = false;
            return;
        }

        @Override // com.android.server.display.DisplayDevice
        public DisplayDeviceInfo getDisplayDeviceInfoLocked() {
            if (this.mInfo != null) goto L85;
            this.mInfo = new DisplayDeviceInfo();
            this.mInfo.width = this.mActiveSfDisplayMode.width;
            this.mInfo.height = this.mActiveSfDisplayMode.height;
            this.mInfo.modeId = this.mActiveModeId;
            this.mInfo.renderFrameRate = this.mActiveRenderFrameRate;
            this.mInfo.defaultModeId = getPreferredModeId();
            this.mInfo.userPreferredModeId = this.mUserPreferredModeId;
            this.mInfo.supportedModes = getDisplayModes(this.mSupportedModes);
            this.mInfo.colorMode = this.mActiveColorMode;
            this.mInfo.allmSupported = this.mAllmSupported;
            this.mInfo.gameContentTypeSupported = this.mGameContentTypeSupported;
            this.mInfo.supportedColorModes = new int[this.mSupportedColorModes.size()];
            int i = 0;
        L6:
            if (i >= this.mSupportedColorModes.size()) goto L8;
            this.mInfo.supportedColorModes[i] = this.mSupportedColorModes.get(i).intValue();
            i = i + 1;
            goto L6
        L8:
            this.mInfo.hdrCapabilities = this.mHdrCapabilities;
            this.mInfo.hasArrSupport = this.mHasArrSupport;
            this.mInfo.frameRateCategoryRate = this.mFrameRateCategoryRate;
            this.mInfo.supportedRefreshRates = this.mSupportedRefreshRates;
            this.mInfo.appVsyncOffsetNanos = this.mActiveSfDisplayMode.appVsyncOffsetNanos;
            this.mInfo.presentationDeadlineNanos = this.mActiveSfDisplayMode.presentationDeadlineNanos;
            this.mInfo.state = this.mState;
            this.mInfo.committedState = this.mCommittedState;
            this.mInfo.uniqueId = getUniqueId();
            DisplayAddress.Physical physicalAddress = DisplayAddress.fromPhysicalDisplayId(this.mPhysicalDisplayId);
            this.mInfo.address = physicalAddress;
            this.mInfo.densityDpi = getLogicalDensity();
            this.mInfo.xDpi = this.mActiveSfDisplayMode.xDpi;
            this.mInfo.yDpi = this.mActiveSfDisplayMode.yDpi;
            this.mInfo.deviceProductInfo = this.mStaticDisplayInfo.deviceProductInfo;
            if (this.mConnectedHdcpLevel == 0) goto L16;
            SurfaceControl.StaticDisplayInfo r1 = this.mStaticDisplayInfo;
            if (this.mConnectedHdcpLevel < 2) goto L13;
            boolean r5 = true;
        L14:
            r1.secure = r5;
            goto L16
        L13:
            r5 = false;
        L16:
            if (this.mStaticDisplayInfo.secure == false) goto L18;
            this.mInfo.flags = 12;
        L18:
            Resources res = this.this$0.getOverlayContext().getResources();
            if (this.mInfo.address != null) goto L21;
        L23:
            boolean isBuiltIn = false;
        L24:
            this.mInfo.flags |= 1;
            if (this.mIsFirstDisplay == true) goto L27;
            if (isBuiltIn == false) goto L43;
            this.mInfo.type = 1;
            this.mInfo.touch = 1;
            this.mInfo.name = this.this$0.getContext().getResources().getString(R.string.etws_primary_default_message_others);
            this.mInfo.flags |= 2;
            if (SystemProperties.getBoolean("vendor.display.builtin_presentation", false) == false) goto L37;
            this.mInfo.flags |= 64;
        L39:
            if (SystemProperties.getBoolean("vendor.display.builtin_mirroring", false) == true) goto L41;
            DisplayDeviceInfo r3 = this.mInfo;
            r3.flags = 128 | r3.flags;
        L41:
            this.mInfo.setAssumedDensityForExternalDisplay(this.mActiveSfDisplayMode.width, this.mActiveSfDisplayMode.height);
        L52:
            if (this.this$0.getFeatureFlags().isDisplayContentModeManagementEnabled() == false) goto L61;
            if (this.mIsFirstDisplay == false) goto L56;
        L59:
            this.mInfo.flags |= 1048576;
            goto L61
        L56:
            if (isDisplayPrivate(physicalAddress) == true) goto L61;
            if (shouldOwnContentOnly() == false) goto L59;
        L61:
            if (DisplayCutout.getMaskBuiltInDisplayCutout(res, this.mInfo.uniqueId) == false) goto L63;
            this.mInfo.flags |= 2048;
        L63:
            Display.Mode maxDisplayMode = DisplayUtils.getMaximumResolutionDisplayMode(this.mInfo.supportedModes);
            if (maxDisplayMode != null) goto L67;
            int r6 = this.mInfo.width;
        L66:
            int maxWidth = r6;
            if (maxDisplayMode != null) goto L71;
            int r7 = this.mInfo.height;
        L70:
            int maxHeight = r7;
            if (this.mStaticDisplayInfo.isInternal == false) goto L75;
            this.mInfo.displayCutout = DisplayCutout.fromResourcesRectApproximation(res, this.mInfo.uniqueId, maxWidth, maxHeight, this.mInfo.width, this.mInfo.height);
            this.mInfo.roundedCorners = RoundedCorners.fromResources(res, this.mInfo.uniqueId, maxWidth, maxHeight, this.mInfo.width, this.mInfo.height);
        L75:
            this.mInfo.installOrientation = this.mStaticDisplayInfo.installOrientation;
            this.mInfo.displayShape = DisplayShape.fromResources(res, this.mInfo.uniqueId, maxWidth, maxHeight, this.mInfo.width, this.mInfo.height);
            this.mInfo.name = getDisplayDeviceConfig().getName();
            if (this.mStaticDisplayInfo.isInternal == false) goto L80;
            this.mInfo.type = 1;
            this.mInfo.touch = 1;
            DisplayDeviceInfo r4 = this.mInfo;
            r4.flags = 2 | r4.flags;
            if (this.mInfo.name != null) goto L83;
            this.mInfo.name = res.getString(R.string.etws_primary_default_message_others);
        L83:
            this.mInfo.frameRateOverrides = this.mFrameRateOverrides;
            this.mInfo.flags |= 8192;
            this.mInfo.brightnessMinimum = getDisplayDeviceConfig().getBrightnessMinimum();
            this.mInfo.brightnessMaximum = getDisplayDeviceConfig().getBrightnessMaximum();
            this.mInfo.brightnessDefault = getDisplayDeviceConfig().getBrightnessDefault();
            this.mInfo.brightnessDim = getDisplayDeviceConfig().getBrightnessDim();
            this.mInfo.hdrSdrRatio = this.mCurrentHdrSdrRatio;
            goto L85
        L80:
            this.mInfo.type = 2;
            this.mInfo.touch = 2;
            this.mInfo.flags |= 64;
            if (this.mInfo.name != null) goto L83;
            this.mInfo.name = this.this$0.getContext().getResources().getString(R.string.etws_primary_default_message_test);
            goto L83
        L71:
            r7 = maxDisplayMode.getPhysicalHeight();
            goto L70
        L67:
            r6 = maxDisplayMode.getPhysicalWidth();
            goto L66
        L37:
            this.mInfo.flags |= 16;
            goto L39
        L43:
            if (shouldOwnContentOnly() == false) goto L46;
            DisplayDeviceInfo r8 = this.mInfo;
            r8.flags = 128 | r8.flags;
        L46:
            if (isDisplayPrivate(physicalAddress) == false) goto L49;
            this.mInfo.flags |= 16;
        L49:
            if (isDisplayStealTopFocusDisabled(physicalAddress) == false) goto L52;
            this.mInfo.flags |= 131072;
            this.mInfo.flags |= 524288;
            goto L52
        L27:
            if (res.getBoolean(R.bool.config_multiuserVisibleBackgroundUsers) == false) goto L29;
        L32:
            this.mInfo.flags |= 256;
            goto L52
        L29:
            if (Build.IS_EMULATOR == false) goto L52;
            if (SystemProperties.getBoolean(LocalDisplayAdapter.PROPERTY_EMULATOR_CIRCULAR, false) == false) goto L52;
        L21:
            if ((this.mInfo.address.getPort() & 128) != 128) goto L23;
            isBuiltIn = true;
        L85:
            return this.mInfo;
        }

        @Override // com.android.server.display.DisplayDevice
        public Runnable requestDisplayStateLocked(final int state, final float brightnessState, final float sdrBrightnessState, final DisplayOffloadSessionImpl displayOffloadSession) {
            if (this.mState == state) goto L5;
            boolean r0 = true;
        L6:
            boolean stateChanged = r0;
            if (this.mBrightnessState == brightnessState) goto L9;
        L12:
            final boolean brightnessChanged = true;
        L13:
            if (stateChanged == true) goto L18;
            if (brightnessChanged == true) goto L18;
            return null;
        L18:
            final long physicalDisplayId = this.mPhysicalDisplayId;
            final IBinder token = getDisplayTokenLocked();
            final int oldState = this.mState;
            if (stateChanged == false) goto L22;
            this.mState = state;
            updateDeviceInfoLocked();
        L22:
            return new AnonymousClass1(this, oldState, state, physicalDisplayId, brightnessChanged, brightnessState, sdrBrightnessState, displayOffloadSession, token);
        L9:
            if (this.mSdrBrightnessState != sdrBrightnessState) goto L12;
            brightnessChanged = false;
            goto L13
        L5:
            r0 = false;
            goto L6
        }

        @Override // com.android.server.display.DisplayDevice
        public void setUserPreferredDisplayModeLocked(Display.Mode mode) {
            int oldModeId = getPreferredModeId();
            this.mUserPreferredMode = mode;
            if (mode == null) goto L5;
        L7:
            if (mode != null) goto L9;
        L15:
            this.mUserPreferredModeId = findUserPreferredModeIdLocked(this.mUserPreferredMode);
            if (oldModeId != getPreferredModeId()) goto L18;
            return;
        L18:
            updateDeviceInfoLocked();
            if (LocalDisplayAdapter.m3828$$Nest$fgetmIsBootDisplayModeSupported(this.this$0) == true) goto L22;
            return;
        L22:
            if (this.mUserPreferredModeId != (-1)) goto L24;
            LocalDisplayAdapter.m3830$$Nest$fgetmSurfaceControlProxy(this.this$0).clearBootDisplayMode(getDisplayTokenLocked());
            return;
        L24:
            int preferredSfDisplayModeId = findSfDisplayModeIdLocked(this.mUserPreferredMode.getModeId(), this.mDefaultModeGroup);
            LocalDisplayAdapter.m3830$$Nest$fgetmSurfaceControlProxy(this.this$0).setBootDisplayMode(getDisplayTokenLocked(), preferredSfDisplayModeId);
            return;
        L9:
            if (mode.isRefreshRateSet() == false) goto L11;
        L12:
            Display.Mode matchingSupportedMode = findMode(mode.getPhysicalWidth(), mode.getPhysicalHeight(), mode.getRefreshRate());
            if (matchingSupportedMode == null) goto L15;
            this.mUserPreferredMode = matchingSupportedMode;
            goto L15
        L11:
            if (mode.isResolutionSet() == false) goto L15;
        L5:
            if (this.mSystemPreferredModeId == (-1)) goto L7;
            this.mDefaultModeId = this.mSystemPreferredModeId;
            goto L7
        }

        @Override // com.android.server.display.DisplayDevice
        public Display.Mode getUserPreferredDisplayModeLocked() {
            return this.mUserPreferredMode;
        }

        @Override // com.android.server.display.DisplayDevice
        public Display.Mode getSystemPreferredDisplayModeLocked() {
            return findMode(this.mSystemPreferredModeId);
        }

        @Override // com.android.server.display.DisplayDevice
        public void setRequestedColorModeLocked(int colorMode) {
            requestColorModeLocked(colorMode);
        }

        @Override // com.android.server.display.DisplayDevice
        public void setDesiredDisplayModeSpecsLocked(DisplayModeDirector.DesiredDisplayModeSpecs displayModeSpecs) {
            if (displayModeSpecs.baseModeId != 0) goto L6;
            return;
        L6:
            if (displayModeSpecs.allowGroupSwitching == false) goto L8;
            int baseSfModeId = findSfDisplayModeIdLocked(displayModeSpecs.baseModeId, -1);
            int baseSfModeId2 = baseSfModeId;
        L10:
            if (baseSfModeId2 >= 0) goto L14;
            Slog.w(LocalDisplayAdapter.TAG, "Ignoring request for invalid base mode id " + displayModeSpecs.baseModeId);
            updateDeviceInfoLocked();
            return;
        L14:
            if (this.mDisplayModeSpecsInvalid == false) goto L16;
        L17:
            this.mDisplayModeSpecsInvalid = false;
            this.mDisplayModeSpecs.copyFrom(displayModeSpecs);
            Slog.w(LocalDisplayAdapter.TAG, "setDesiredDisplayModeSpecsLocked base mode id " + displayModeSpecs.baseModeId);
            this.this$0.getHandler().sendMessage(PooledLambda.obtainMessage(new LocalDisplayAdapter$LocalDisplayDevice$$ExternalSyntheticLambda0(), this, getDisplayTokenLocked(), new SurfaceControl.DesiredDisplayModeSpecs(baseSfModeId2, this.mDisplayModeSpecs.allowGroupSwitching, this.mDisplayModeSpecs.primary, this.mDisplayModeSpecs.appRequest, this.mDisplayModeSpecs.mIdleScreenRefreshRateConfig)));
            return;
        L16:
            if (displayModeSpecs.equals(this.mDisplayModeSpecs) == false) goto L17;
            return;
        L8:
            int baseSfModeId3 = findSfDisplayModeIdLocked(displayModeSpecs.baseModeId, this.mDefaultModeGroup);
            baseSfModeId2 = baseSfModeId3;
            goto L10
        }

        public void setDesiredDisplayModeSpecsAsync(IBinder displayToken, SurfaceControl.DesiredDisplayModeSpecs modeSpecs) {
            LocalDisplayAdapter.m3830$$Nest$fgetmSurfaceControlProxy(this.this$0).setDesiredDisplayModeSpecs(displayToken, modeSpecs);
        }

        public void updateDesiredDisplayModeSpecsLocked(DisplayModeDirector.DesiredDisplayModeSpecs modeSpecs) {
            this.mDisplayModeSpecsInvalid = false;
            this.mDisplayModeSpecs.copyFrom(modeSpecs);
        }

        @Override // com.android.server.display.DisplayDevice
        public void onOverlayChangedLocked() {
            updateDeviceInfoLocked();
        }

        public void onActiveDisplayModeChangedLocked(int sfModeId, float renderFrameRate) {
            if (updateActiveModeLocked(sfModeId, renderFrameRate) == false) goto L6;
            updateDeviceInfoLocked();
            return;
        }

        public void onFrameRateOverridesChanged(DisplayEventReceiver.FrameRateOverride[] overrides) {
            if (updateFrameRateOverridesLocked(overrides) == false) goto L6;
            updateDeviceInfoLocked();
            return;
        }

        public void onHdcpLevelsChangedLocked(int connectedLevel, int maxLevel) {
            if (updateHdcpLevelsLocked(connectedLevel, maxLevel) == false) goto L6;
            updateDeviceInfoLocked();
            return;
        }

        public boolean updateActiveModeLocked(int activeSfModeId, float renderFrameRate) {
            if (this.mActiveSfDisplayMode.id == activeSfModeId) goto L5;
        L8:
            this.mActiveSfDisplayMode = getModeById(this.mSfDisplayModes, activeSfModeId);
            this.mActiveModeId = findMatchingModeIdLocked(activeSfModeId);
            if (this.mActiveModeId != (-1)) goto L11;
            Slog.w(LocalDisplayAdapter.TAG, "In unknown mode after setting allowed modes, activeModeId=" + activeSfModeId);
        L11:
            this.mActiveRenderFrameRate = renderFrameRate;
            return true;
        L5:
            if (this.mActiveRenderFrameRate != renderFrameRate) goto L8;
            return false;
        }

        public boolean updateFrameRateOverridesLocked(DisplayEventReceiver.FrameRateOverride[] overrides) {
            if (Arrays.equals(overrides, this.mFrameRateOverrides) == false) goto L6;
            return false;
        L6:
            this.mFrameRateOverrides = overrides;
            return true;
        }

        public boolean updateHdcpLevelsLocked(int connectedLevel, int maxLevel) {
            if (connectedLevel <= maxLevel) goto L7;
            Slog.w(LocalDisplayAdapter.TAG, "HDCP connected level: " + connectedLevel + " is larger than max level: " + maxLevel + ", ignoring request.");
            return false;
        L7:
            if (this.mConnectedHdcpLevel != connectedLevel) goto L9;
            return false;
        L9:
            this.mConnectedHdcpLevel = connectedLevel;
            return true;
        }

        public void requestColorModeLocked(int colorMode) {
            if (this.mActiveColorMode != colorMode) goto L6;
            return;
        L6:
            if (this.mSupportedColorModes.contains(Integer.valueOf(colorMode)) == true) goto L9;
            Slog.w(LocalDisplayAdapter.TAG, "Unable to find color mode " + colorMode + ", ignoring request.");
            return;
        L9:
            this.mActiveColorMode = colorMode;
            this.this$0.getHandler().sendMessage(PooledLambda.obtainMessage(new LocalDisplayAdapter$LocalDisplayDevice$$ExternalSyntheticLambda1(), this, getDisplayTokenLocked(), Integer.valueOf(colorMode)));
        }

        private void requestColorModeAsync(IBinder displayToken, int colorMode) {
            LocalDisplayAdapter.m3830$$Nest$fgetmSurfaceControlProxy(this.this$0).setActiveColorMode(displayToken, colorMode);
            DisplayManagerService.SyncRoot r0 = this.this$0.getSyncRoot();
            monitor-enter(r0);
            updateDeviceInfoLocked();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.display.DisplayDevice
        public void setAutoLowLatencyModeLocked(boolean on) {
            if (this.mAllmRequested != on) goto L5;
            return;
        L5:
            this.mAllmRequested = on;
            if (this.mAllmSupported == true) goto L9;
            Slog.d(LocalDisplayAdapter.TAG, "Unable to set ALLM because the connected display does not support ALLM.");
            return;
        L9:
            LocalDisplayAdapter.m3830$$Nest$fgetmSurfaceControlProxy(this.this$0).setAutoLowLatencyMode(getDisplayTokenLocked(), on);
        }

        @Override // com.android.server.display.DisplayDevice
        public void setGameContentTypeLocked(boolean on) {
            if (this.mGameContentTypeRequested != on) goto L5;
            return;
        L5:
            this.mGameContentTypeRequested = on;
            LocalDisplayAdapter.m3830$$Nest$fgetmSurfaceControlProxy(this.this$0).setGameContentType(getDisplayTokenLocked(), on);
        }

        @Override // com.android.server.display.DisplayDevice
        public void dumpLocked(PrintWriter pw) {
            super.dumpLocked(pw);
            pw.println("mPhysicalDisplayId=" + this.mPhysicalDisplayId);
            pw.println("mDisplayModeSpecs={" + this.mDisplayModeSpecs + "}");
            StringBuilder r0 = new StringBuilder();
            r0.append("mDisplayModeSpecsInvalid=");
            r0.append(this.mDisplayModeSpecsInvalid);
            pw.println(r0.toString());
            pw.println("mActiveModeId=" + this.mActiveModeId);
            pw.println("mActiveColorMode=" + this.mActiveColorMode);
            pw.println("mDefaultModeId=" + this.mDefaultModeId);
            pw.println("mUserPreferredModeId=" + this.mUserPreferredModeId);
            pw.println("mHasArrSupport=" + this.mHasArrSupport);
            pw.println("mSupportedRefreshRates=" + Arrays.toString(this.mSupportedRefreshRates));
            pw.println("mState=" + Display.stateToString(this.mState));
            pw.println("mCommittedState=" + Display.stateToString(this.mCommittedState));
            pw.println("mBrightnessState=" + this.mBrightnessState);
            pw.println("mBacklightAdapter=" + this.mBacklightAdapter);
            pw.println("mAllmSupported=" + this.mAllmSupported);
            pw.println("mAllmRequested=" + this.mAllmRequested);
            pw.println("mGameContentTypeSupported=" + this.mGameContentTypeSupported);
            pw.println("mGameContentTypeRequested=" + this.mGameContentTypeRequested);
            pw.println("mStaticDisplayInfo=" + this.mStaticDisplayInfo);
            pw.println("mSfDisplayModes=");
            SurfaceControl.DisplayMode[] r1 = this.mSfDisplayModes;
            int r2 = r1.length;
            int r3 = 0;
        L4:
            if (r3 >= r2) goto L6;
            SurfaceControl.DisplayMode sfDisplayMode = r1[r3];
            pw.println("  " + sfDisplayMode);
            r3 = r3 + 1;
            goto L4
        L6:
            pw.println("mActiveSfDisplayMode=" + this.mActiveSfDisplayMode);
            pw.println("mActiveRenderFrameRate=" + this.mActiveRenderFrameRate);
            pw.println("mSupportedModes=");
            int i = 0;
        L8:
            if (i >= this.mSupportedModes.size()) goto L10;
            pw.println("  " + this.mSupportedModes.valueAt(i));
            i = i + 1;
            goto L8
        L10:
            pw.println("mSupportedColorModes=" + this.mSupportedColorModes);
            pw.println("");
            pw.println("DisplayDeviceConfig: ");
            pw.println("---------------------");
            pw.println(this.mDisplayDeviceConfig);
            pw.println("mEvenDimmerEnabled=" + LocalDisplayAdapter.m3824$$Nest$fgetmEvenDimmerEnabled(this.this$0));
            pw.println("mEvenDimmerStrength=" + LocalDisplayAdapter.m3825$$Nest$fgetmEvenDimmerStrength(this.this$0));
            pw.println("mNitsToEvenDimmerStrength=" + LocalDisplayAdapter.m3829$$Nest$fgetmNitsToEvenDimmerStrength(this.this$0));
        }

        private int findSfDisplayModeIdLocked(int displayModeId, int modeGroup) {
            int matchingSfDisplayModeId = -1;
            DisplayModeRecord record = this.mSupportedModes.get(displayModeId);
            if (record == null) goto L17;
            SurfaceControl.DisplayMode[] r2 = this.mSfDisplayModes;
            int r3 = r2.length;
            int r4 = 0;
        L6:
            if (r4 >= r3) goto L17;
            SurfaceControl.DisplayMode mode = r2[r4];
            if (record.hasMatchingMode(mode) == false) goto L16;
            if (matchingSfDisplayModeId != (-1)) goto L13;
            matchingSfDisplayModeId = mode.id;
        L13:
            if (mode.group != modeGroup) goto L16;
            return mode.id;
        L16:
            r4 = r4 + 1;
        L17:
            return matchingSfDisplayModeId;
        }

        private Display.Mode findMode(int modeId) {
            int i = 0;
        L4:
            if (i >= this.mSupportedModes.size()) goto L9;
            Display.Mode supportedMode = this.mSupportedModes.valueAt(i).mMode;
            if (supportedMode.getModeId() == modeId) goto L7;
            i = i + 1;
            goto L4
        L7:
            return supportedMode;
        L9:
            return null;
        }

        Display.Mode findMode(int width, int height, float refreshRate) {
            int i = 0;
        L4:
            if (i >= this.mSupportedModes.size()) goto L9;
            Display.Mode supportedMode = this.mSupportedModes.valueAt(i).mMode;
            if (supportedMode.matchesIfValid(width, height, refreshRate) == true) goto L7;
            i = i + 1;
            goto L4
        L7:
            return supportedMode;
        L9:
            return null;
        }

        private int findUserPreferredModeIdLocked(Display.Mode userPreferredMode) {
            if (userPreferredMode == null) goto L11;
            int i = 0;
        L5:
            if (i >= this.mSupportedModes.size()) goto L15;
            Display.Mode supportedMode = this.mSupportedModes.valueAt(i).mMode;
            if (userPreferredMode.matches(supportedMode.getPhysicalWidth(), supportedMode.getPhysicalHeight(), supportedMode.getRefreshRate()) == true) goto L9;
            i = i + 1;
            goto L5
        L9:
            return supportedMode.getModeId();
        L15:
            return -1;
        L11:
            return -1;
        }

        private int findMatchingModeIdLocked(int sfModeId) {
            SurfaceControl.DisplayMode mode = getModeById(this.mSfDisplayModes, sfModeId);
            if (mode != null) goto L6;
            Slog.e(LocalDisplayAdapter.TAG, "Invalid display mode ID " + sfModeId);
            return -1;
        L6:
            int i = 0;
        L8:
            if (i >= this.mSupportedModes.size()) goto L15;
            DisplayModeRecord record = this.mSupportedModes.valueAt(i);
            if (record.hasMatchingMode(mode) == true) goto L12;
            i = i + 1;
            goto L8
        L12:
            return record.mMode.getModeId();
        L15:
            return -1;
        }

        private void updateDeviceInfoLocked() {
            this.mInfo = null;
            this.this$0.sendDisplayDeviceEventLocked(this, 2);
        }

        private Display.Mode[] getDisplayModes(SparseArray<DisplayModeRecord> records) {
            int size = records.size();
            Display.Mode[] modes = new Display.Mode[size];
            int i = 0;
        L3:
            if (i >= size) goto L6;
            DisplayModeRecord record = records.valueAt(i);
            modes[i] = record.mMode;
            i = i + 1;
            goto L3
        L6:
            return modes;
        }

        private boolean isDisplayPrivate(DisplayAddress.Physical physicalAddress) {
            if (physicalAddress != null) goto L5;
            return false;
        L5:
            Resources res = this.this$0.getOverlayContext().getResources();
            int[] ports = res.getIntArray(R.array.config_nonPreemptibleInputMethods);
            if (ports == null) goto L15;
            int port = physicalAddress.getPort();
            int r4 = ports.length;
            int r5 = 0;
        L9:
            if (r5 >= r4) goto L15;
            int p = ports[r5];
            if (p == port) goto L12;
            r5 = r5 + 1;
            goto L9
        L12:
            return true;
        L15:
            return false;
        }

        private boolean shouldOwnContentOnly() {
            Resources res = this.this$0.getOverlayContext().getResources();
            return !res.getBoolean(R.bool.config_magnification_area);
        }

        private boolean isDisplayStealTopFocusDisabled(DisplayAddress.Physical physicalAddress) {
            if (physicalAddress != null) goto L5;
            return false;
        L5:
            Resources res = this.this$0.getOverlayContext().getResources();
            int[] ports = res.getIntArray(R.array.config_nightDisplayColorTemperatureCoefficientsNative);
            if (ports == null) goto L15;
            int port = physicalAddress.getPort();
            int r4 = ports.length;
            int r5 = 0;
        L9:
            if (r5 >= r4) goto L15;
            int p = ports[r5];
            if (p == port) goto L12;
            r5 = r5 + 1;
            goto L9
        L12:
            return true;
        L15:
            return false;
        }
    }

    private final class LocalDisplayEventListener implements DisplayEventListener {
        final /* synthetic */ LocalDisplayAdapter this$0;

        /* synthetic */ LocalDisplayEventListener(LocalDisplayAdapter r1, LocalDisplayAdapterIA r2) {
            this(r1);
        }

        private LocalDisplayEventListener(LocalDisplayAdapter r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.display.LocalDisplayAdapter.DisplayEventListener
        public void onHotplug(long timestampNanos, long physicalDisplayId, boolean connected) {
            DisplayManagerService.SyncRoot r0 = this.this$0.getSyncRoot();
            monitor-enter(r0);
            if (connected == false) goto L8;
            LocalDisplayAdapter.m3836$$Nest$mtryConnectDisplayLocked(this.this$0, physicalDisplayId);     // Catch: Throwable -> L6
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L6
            return;
        L8:
            LocalDisplayAdapter.m3837$$Nest$mtryDisconnectDisplayLocked(this.this$0, physicalDisplayId);     // Catch: Throwable -> L6
        L6:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.display.LocalDisplayAdapter.DisplayEventListener
        public void onHotplugConnectionError(long timestampNanos, int connectionError) {
            LocalDisplayAdapter.m3823$$Nest$fgetmDisplayNotificationManager(this.this$0).onHotplugConnectionError();
        }

        @Override // com.android.server.display.LocalDisplayAdapter.DisplayEventListener
        public void onModeChanged(long timestampNanos, long physicalDisplayId, int modeId, long renderPeriod) {
            DisplayManagerService.SyncRoot r0 = this.this$0.getSyncRoot();
            monitor-enter(r0);
            LocalDisplayDevice device = (LocalDisplayDevice) LocalDisplayAdapter.m3822$$Nest$fgetmDevices(this.this$0).get(physicalDisplayId);     // Catch: Throwable -> L8
            if (device != null) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            float renderFrameRate = 1.0E9f / renderPeriod;     // Catch: Throwable -> L8
            device.onActiveDisplayModeChangedLocked(modeId, renderFrameRate);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.display.LocalDisplayAdapter.DisplayEventListener
        public void onFrameRateOverridesChanged(long timestampNanos, long physicalDisplayId, DisplayEventReceiver.FrameRateOverride[] overrides) {
            DisplayManagerService.SyncRoot r0 = this.this$0.getSyncRoot();
            monitor-enter(r0);
            LocalDisplayDevice device = (LocalDisplayDevice) LocalDisplayAdapter.m3822$$Nest$fgetmDevices(this.this$0).get(physicalDisplayId);     // Catch: Throwable -> L8
            if (device != null) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            device.onFrameRateOverridesChanged(overrides);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.display.LocalDisplayAdapter.DisplayEventListener
        public void onHdcpLevelsChanged(long physicalDisplayId, int connectedLevel, int maxLevel) {
            DisplayManagerService.SyncRoot r0 = this.this$0.getSyncRoot();
            monitor-enter(r0);
            LocalDisplayDevice device = (LocalDisplayDevice) LocalDisplayAdapter.m3822$$Nest$fgetmDevices(this.this$0).get(physicalDisplayId);     // Catch: Throwable -> L8
            if (device != null) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            device.onHdcpLevelsChangedLocked(connectedLevel, maxLevel);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    public static final class ProxyDisplayEventReceiver extends DisplayEventReceiver {
        private final DisplayEventListener mListener;

        ProxyDisplayEventReceiver(Looper looper, DisplayEventListener listener) {
            super(looper, 0, 3);
            this.mListener = listener;
        }

        public void onHotplug(long timestampNanos, long physicalDisplayId, boolean connected) {
            this.mListener.onHotplug(timestampNanos, physicalDisplayId, connected);
        }

        public void onHotplugConnectionError(long timestampNanos, int errorCode) {
            this.mListener.onHotplugConnectionError(timestampNanos, errorCode);
        }

        public void onModeChanged(long timestampNanos, long physicalDisplayId, int modeId, long renderPeriod) {
            this.mListener.onModeChanged(timestampNanos, physicalDisplayId, modeId, renderPeriod);
        }

        public void onFrameRateOverridesChanged(long timestampNanos, long physicalDisplayId, DisplayEventReceiver.FrameRateOverride[] overrides) {
            this.mListener.onFrameRateOverridesChanged(timestampNanos, physicalDisplayId, overrides);
        }

        public void onHdcpLevelsChanged(long physicalDisplayId, int connectedLevel, int maxLevel) {
            this.mListener.onHdcpLevelsChanged(physicalDisplayId, connectedLevel, maxLevel);
        }
    }

    public static class SurfaceControlProxy {
        public SurfaceControlProxy() {
        }

        public SurfaceControl.DynamicDisplayInfo getDynamicDisplayInfo(long displayId) {
            return SurfaceControl.getDynamicDisplayInfo(displayId);
        }

        public long[] getPhysicalDisplayIds() {
            return DisplayControl.getPhysicalDisplayIds();
        }

        public IBinder getPhysicalDisplayToken(long physicalDisplayId) {
            return DisplayControl.getPhysicalDisplayToken(physicalDisplayId);
        }

        public SurfaceControl.StaticDisplayInfo getStaticDisplayInfo(long displayId) {
            return SurfaceControl.getStaticDisplayInfo(displayId);
        }

        public SurfaceControl.DesiredDisplayModeSpecs getDesiredDisplayModeSpecs(IBinder displayToken) {
            return SurfaceControl.getDesiredDisplayModeSpecs(displayToken);
        }

        public boolean setDesiredDisplayModeSpecs(IBinder token, SurfaceControl.DesiredDisplayModeSpecs specs) {
            return SurfaceControl.setDesiredDisplayModeSpecs(token, specs);
        }

        public void setDisplayPowerMode(IBinder displayToken, int mode) {
            SurfaceControl.setDisplayPowerMode(displayToken, mode);
        }

        public boolean setActiveColorMode(IBinder displayToken, int colorMode) {
            return SurfaceControl.setActiveColorMode(displayToken, colorMode);
        }

        public boolean getBootDisplayModeSupport() {
            Trace.traceBegin(32, "getBootDisplayModeSupport");
            boolean r0 = SurfaceControl.getBootDisplayModeSupport();     // Catch: Throwable -> L6
            Trace.traceEnd(32);
            return r0;
        L6:
            th = move-exception;
            Trace.traceEnd(32);
            throw th;
        }

        public void setBootDisplayMode(IBinder displayToken, int modeId) {
            SurfaceControl.setBootDisplayMode(displayToken, modeId);
        }

        public void clearBootDisplayMode(IBinder displayToken) {
            SurfaceControl.clearBootDisplayMode(displayToken);
        }

        public void setAutoLowLatencyMode(IBinder displayToken, boolean on) {
            SurfaceControl.setAutoLowLatencyMode(displayToken, on);
        }

        public void setGameContentType(IBinder displayToken, boolean on) {
            SurfaceControl.setGameContentType(displayToken, on);
        }

        public boolean getDisplayBrightnessSupport(IBinder displayToken) {
            return SurfaceControl.getDisplayBrightnessSupport(displayToken);
        }

        public boolean setDisplayBrightness(IBinder displayToken, float brightness) {
            return SurfaceControl.setDisplayBrightness(displayToken, brightness);
        }

        public boolean setDisplayBrightness(IBinder displayToken, float sdrBacklight, float sdrNits, float displayBacklight, float displayNits) {
            return SurfaceControl.setDisplayBrightness(displayToken, sdrBacklight, sdrNits, displayBacklight, displayNits);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCdsi, reason: not valid java name */
    static /* bridge */ /* synthetic */ ColorDisplayService.ColorDisplayServiceInternal m3821$$Nest$fgetmCdsi(LocalDisplayAdapter r0) {
        return r0.mCdsi;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDevices, reason: not valid java name */
    static /* bridge */ /* synthetic */ LongSparseArray m3822$$Nest$fgetmDevices(LocalDisplayAdapter r0) {
        return r0.mDevices;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDisplayNotificationManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ DisplayNotificationManager m3823$$Nest$fgetmDisplayNotificationManager(LocalDisplayAdapter r0) {
        return r0.mDisplayNotificationManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEvenDimmerEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3824$$Nest$fgetmEvenDimmerEnabled(LocalDisplayAdapter r0) {
        return r0.mEvenDimmerEnabled;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEvenDimmerStrength, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m3825$$Nest$fgetmEvenDimmerStrength(LocalDisplayAdapter r0) {
        return r0.mEvenDimmerStrength;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmExt, reason: not valid java name */
    static /* bridge */ /* synthetic */ IExtLocalDisplayAdapter m3826$$Nest$fgetmExt(LocalDisplayAdapter r0) {
        return r0.mExt;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInjector, reason: not valid java name */
    static /* bridge */ /* synthetic */ Injector m3827$$Nest$fgetmInjector(LocalDisplayAdapter r0) {
        return r0.mInjector;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsBootDisplayModeSupported, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3828$$Nest$fgetmIsBootDisplayModeSupported(LocalDisplayAdapter r0) {
        return r0.mIsBootDisplayModeSupported;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNitsToEvenDimmerStrength, reason: not valid java name */
    static /* bridge */ /* synthetic */ Spline m3829$$Nest$fgetmNitsToEvenDimmerStrength(LocalDisplayAdapter r0) {
        return r0.mNitsToEvenDimmerStrength;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSurfaceControlProxy, reason: not valid java name */
    static /* bridge */ /* synthetic */ SurfaceControlProxy m3830$$Nest$fgetmSurfaceControlProxy(LocalDisplayAdapter r0) {
        return r0.mSurfaceControlProxy;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmCdsi, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3831$$Nest$fputmCdsi(LocalDisplayAdapter r0, ColorDisplayService.ColorDisplayServiceInternal r1) {
        r0.mCdsi = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmEvenDimmerEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3832$$Nest$fputmEvenDimmerEnabled(LocalDisplayAdapter r0, boolean r1) {
        r0.mEvenDimmerEnabled = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmEvenDimmerStrength, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3833$$Nest$fputmEvenDimmerStrength(LocalDisplayAdapter r0, int r1) {
        r0.mEvenDimmerStrength = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmNitsToEvenDimmerStrength, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3834$$Nest$fputmNitsToEvenDimmerStrength(LocalDisplayAdapter r0, Spline r1) {
        r0.mNitsToEvenDimmerStrength = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mhdrTypesEqual, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3835$$Nest$mhdrTypesEqual(LocalDisplayAdapter r0, int[] r1, int[] r2) {
        return r0.hdrTypesEqual(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mtryConnectDisplayLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3836$$Nest$mtryConnectDisplayLocked(LocalDisplayAdapter r0, long r1) {
        r0.tryConnectDisplayLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mtryDisconnectDisplayLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3837$$Nest$mtryDisconnectDisplayLocked(LocalDisplayAdapter r0, long r1) {
        r0.tryDisconnectDisplayLocked(r1);
    }

    LocalDisplayAdapter(DisplayManagerService.SyncRoot syncRoot, Context context, Handler handler, DisplayAdapter.Listener listener, DisplayManagerFlags flags, DisplayNotificationManager displayNotificationManager) {
        this(syncRoot, context, handler, listener, flags, displayNotificationManager, new Injector());
    }

    LocalDisplayAdapter(DisplayManagerService.SyncRoot syncRoot, Context context, Handler handler, DisplayAdapter.Listener listener, DisplayManagerFlags flags, DisplayNotificationManager displayNotificationManager, Injector injector) {
        super(syncRoot, context, handler, listener, TAG, flags);
        this.mDevices = new LongSparseArray();
        this.mEvenDimmerStrength = -1;
        this.mEvenDimmerEnabled = false;
        this.mExt = (IExtLocalDisplayAdapter) ExtImplFactory.getImpl(IExtLocalDisplayAdapter.class, new Object[]{this});
        this.mDisplayNotificationManager = displayNotificationManager;
        this.mInjector = injector;
        this.mSurfaceControlProxy = this.mInjector.getSurfaceControlProxy();
        this.mIsBootDisplayModeSupported = this.mSurfaceControlProxy.getBootDisplayModeSupport();
    }

    @Override // com.android.server.display.DisplayAdapter
    public void registerLocked() {
        super.registerLocked();
        this.mInjector.setDisplayEventListenerLocked(getHandler().getLooper(), new LocalDisplayEventListener(this, null));
        long[] r0 = this.mSurfaceControlProxy.getPhysicalDisplayIds();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        long physicalDisplayId = r0[r2];
        tryConnectDisplayLocked(physicalDisplayId);
        r2 = r2 + 1;
        goto L3
    }

    private void tryConnectDisplayLocked(long physicalDisplayId) {
        IBinder displayToken = this.mSurfaceControlProxy.getPhysicalDisplayToken(physicalDisplayId);
        if (displayToken == null) goto L38;
        SurfaceControl.StaticDisplayInfo staticInfo = this.mSurfaceControlProxy.getStaticDisplayInfo(physicalDisplayId);
        if (staticInfo != null) goto L8;
        Slog.w(TAG, "No valid static info found for display device " + physicalDisplayId);
        return;
    L8:
        SurfaceControl.DynamicDisplayInfo dynamicInfo = this.mSurfaceControlProxy.getDynamicDisplayInfo(physicalDisplayId);
        if (dynamicInfo != null) goto L13;
        Slog.w(TAG, "No valid dynamic info found for display device " + physicalDisplayId);
        return;
    L13:
        if (dynamicInfo.supportedDisplayModes != null) goto L17;
        Slog.w(TAG, "No valid modes found for display device " + physicalDisplayId);
        return;
    L17:
        if (dynamicInfo.activeDisplayModeId >= 0) goto L21;
        Slog.w(TAG, "No valid active mode found for display device " + physicalDisplayId);
        return;
    L21:
        if (dynamicInfo.activeColorMode >= 0) goto L23;
        Slog.w(TAG, "No valid active color mode for display device " + physicalDisplayId);
        dynamicInfo.activeColorMode = -1;
    L23:
        SurfaceControl.DesiredDisplayModeSpecs modeSpecs = this.mSurfaceControlProxy.getDesiredDisplayModeSpecs(displayToken);
        if (modeSpecs != null) goto L27;
        Slog.w(TAG, "Desired display mode specs from SurfaceFlinger are null");
        return;
    L27:
        LocalDisplayDevice device = this.mDevices.get(physicalDisplayId);
        if (device != null) goto L35;
        if (this.mDevices.size() != 0) goto L32;
        boolean isFirstDisplay = true;
    L33:
        LocalDisplayDevice device2 = new LocalDisplayDevice(this, displayToken, physicalDisplayId, staticInfo, dynamicInfo, modeSpecs, isFirstDisplay);
        this.mDevices.put(physicalDisplayId, device2);
        sendDisplayDeviceEventLocked(device2, 1);
        return;
    L32:
        isFirstDisplay = false;
        goto L33
    L35:
        if (device.updateDisplayPropertiesLocked(staticInfo, dynamicInfo, modeSpecs) == false) goto L40;
        sendDisplayDeviceEventLocked(device, 2);
        return;
    L40:
        return;
    }

    private void tryDisconnectDisplayLocked(long physicalDisplayId) {
        LocalDisplayDevice device = this.mDevices.get(physicalDisplayId);
        if (device == null) goto L6;
        this.mDevices.remove(physicalDisplayId);
        sendDisplayDeviceEventLocked(device, 3);
        return;
    }

    private boolean hdrTypesEqual(int[] modeHdrTypes, int[] recordHdrTypes) {
        int[] modeHdrTypesCopy = Arrays.copyOf(modeHdrTypes, modeHdrTypes.length);
        Arrays.sort(modeHdrTypesCopy);
        return Arrays.equals(modeHdrTypesCopy, recordHdrTypes);
    }

    Context getOverlayContext() {
        if (this.mOverlayContext != null) goto L6;
        this.mOverlayContext = ActivityThread.currentActivityThread().getSystemUiContext();
    L6:
        return this.mOverlayContext;
    }

    public IExtLocalDisplayAdapter getExt() {
        return this.mExt;
    }
}
