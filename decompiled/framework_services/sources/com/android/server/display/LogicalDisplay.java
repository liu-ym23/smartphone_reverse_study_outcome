package com.android.server.display;

import android.graphics.Point;
import android.graphics.Rect;
import android.pico.utils.ExtImplFactory;
import android.util.ArraySet;
import android.util.SparseArray;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.DisplayEventReceiver;
import android.view.DisplayInfo;
import android.view.SurfaceControl;
import com.android.server.display.mode.DisplayModeDirector;
import com.android.server.display.mode.SyntheticModeManager;
import com.android.server.wm.utils.DisplayInfoOverrides;
import com.android.server.wm.utils.InsetUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class LogicalDisplay {
    private static final int BLANK_LAYER_STACK = -1;
    private static final DisplayInfo EMPTY_DISPLAY_INFO = null;
    private static final String TAG = "LogicalDisplay";
    private boolean mAlwaysRotateDisplayDeviceEnabled;
    private final DisplayInfo mBaseDisplayInfo;
    private boolean mCanHostTasks;
    private DisplayModeDirector.DesiredDisplayModeSpecs mDesiredDisplayModeSpecs;
    private int mDevicePosition;
    private boolean mDirty;
    private int mDisplayGroupId;
    private String mDisplayGroupName;
    private final int mDisplayId;
    private DisplayOffloadSessionImpl mDisplayOffloadSession;
    private int mDisplayOffsetX;
    private int mDisplayOffsetY;
    private final Point mDisplayPosition;
    private boolean mDisplayScalingDisabled;
    private IExtLogicalDisplay mExt;
    private DisplayEventReceiver.FrameRateOverride[] mFrameRateOverrides;
    private boolean mHasContent;
    private final DisplayInfoProxy mInfo;
    private final boolean mIsAnisotropyCorrectionEnabled;
    private boolean mIsEnabled;
    private boolean mIsInTransition;
    private final int mLayerStack;
    private SurfaceControl.RefreshRateRange mLayoutLimitedRefreshRate;
    private int mLeadDisplayId;
    private DisplayInfo mOverrideDisplayInfo;
    private ArraySet<Integer> mPendingFrameRateOverrideUids;
    private String mPowerThrottlingDataId;
    private DisplayDevice mPrimaryDisplayDevice;
    private DisplayDeviceInfo mPrimaryDisplayDeviceInfo;
    private int mRequestedColorMode;
    private boolean mRequestedMinimalPostProcessing;
    private final boolean mSyncedResolutionSwitchEnabled;
    private final Rect mTempDisplayRect;
    private final SparseArray<Float> mTempFrameRateOverride;
    private final Rect mTempLayerStackRect;
    private String mThermalBrightnessThrottlingDataId;
    private SparseArray<SurfaceControl.RefreshRateRange> mThermalRefreshRateThrottling;
    private int[] mUserDisabledHdrTypes;

    static {
        EMPTY_DISPLAY_INFO = new DisplayInfo();
    }

    LogicalDisplay(int displayId, int layerStack, DisplayDevice primaryDisplayDevice) {
        this(displayId, layerStack, primaryDisplayDevice, false, false, false);
    }

    LogicalDisplay(int displayId, int layerStack, DisplayDevice primaryDisplayDevice, boolean isAnisotropyCorrectionEnabled, boolean isAlwaysRotateDisplayDeviceEnabled, boolean isSyncedResolutionSwitchEnabled) {
        this.mBaseDisplayInfo = new DisplayInfo();
        this.mLeadDisplayId = -1;
        this.mDisplayGroupId = -1;
        this.mInfo = new DisplayInfoProxy(null);
        boolean r1 = false;
        this.mUserDisabledHdrTypes = new int[0];
        this.mDesiredDisplayModeSpecs = new DisplayModeDirector.DesiredDisplayModeSpecs();
        this.mDisplayPosition = new Point();
        this.mTempLayerStackRect = new Rect();
        this.mTempDisplayRect = new Rect();
        this.mDevicePosition = -1;
        this.mDirty = false;
        this.mThermalRefreshRateThrottling = new SparseArray();
        this.mExt = (IExtLogicalDisplay) ExtImplFactory.getImpl(IExtLogicalDisplay.class, new Object[]{this});
        this.mDisplayId = displayId;
        this.mLayerStack = layerStack;
        this.mPrimaryDisplayDevice = primaryDisplayDevice;
        this.mPendingFrameRateOverrideUids = new ArraySet();
        this.mTempFrameRateOverride = new SparseArray();
        this.mIsEnabled = true;
        this.mIsInTransition = false;
        this.mThermalBrightnessThrottlingDataId = "default";
        this.mPowerThrottlingDataId = "default";
        this.mBaseDisplayInfo.thermalBrightnessThrottlingDataId = this.mThermalBrightnessThrottlingDataId;
        this.mIsAnisotropyCorrectionEnabled = isAnisotropyCorrectionEnabled;
        this.mAlwaysRotateDisplayDeviceEnabled = isAlwaysRotateDisplayDeviceEnabled;
        this.mSyncedResolutionSwitchEnabled = isSyncedResolutionSwitchEnabled;
        if (this.mDisplayId != 0) goto L5;
        r1 = true;
    L5:
        this.mCanHostTasks = r1;
    }

    public void setDevicePositionLocked(int position) {
        if (this.mDevicePosition == position) goto L6;
        this.mDevicePosition = position;
        this.mDirty = true;
        return;
    }

    public int getDevicePositionLocked() {
        return this.mDevicePosition;
    }

    public int getDisplayIdLocked() {
        return this.mDisplayId;
    }

    public DisplayDevice getPrimaryDisplayDeviceLocked() {
        return this.mPrimaryDisplayDevice;
    }

    public DisplayInfo getDisplayInfoLocked() {
        if (this.mInfo.get() != null) goto L6;
        DisplayInfo info = new DisplayInfo();
        DisplayInfoOverrides.copyDisplayInfoFields(info, this.mBaseDisplayInfo, this.mOverrideDisplayInfo, DisplayInfoOverrides.WM_OVERRIDE_FIELDS);
        this.mInfo.set(info);
    L6:
        return this.mInfo.get();
    }

    public DisplayEventReceiver.FrameRateOverride[] getFrameRateOverrides() {
        return this.mFrameRateOverrides;
    }

    public ArraySet<Integer> getPendingFrameRateOverrideUids() {
        return this.mPendingFrameRateOverrideUids;
    }

    public void clearPendingFrameRateOverrideUids() {
        this.mPendingFrameRateOverrideUids = new ArraySet();
    }

    void getNonOverrideDisplayInfoLocked(DisplayInfo outInfo) {
        outInfo.copyFrom(this.mBaseDisplayInfo);
    }

    public boolean setDisplayInfoOverrideFromWindowManagerLocked(DisplayInfo info) {
        if (info == null) goto L13;
        if (this.mOverrideDisplayInfo != null) goto L9;
        this.mOverrideDisplayInfo = new DisplayInfo(info);
        this.mInfo.set(null);
        return true;
    L9:
        if (this.mOverrideDisplayInfo.equals(info) == true) goto L16;
        this.mOverrideDisplayInfo.copyFrom(info);
        this.mInfo.set(null);
        return true;
    L16:
        return false;
    L13:
        if (this.mOverrideDisplayInfo == null) goto L18;
        this.mOverrideDisplayInfo = null;
        this.mInfo.set(null);
        return true;
    L18:
        return false;
    }

    public boolean isValidLocked() {
        if (this.mPrimaryDisplayDevice == null) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isDirtyLocked() {
        return this.mDirty;
    }

    public void updateDisplayGroupIdLocked(int groupId) {
        if (groupId == this.mDisplayGroupId) goto L6;
        this.mDisplayGroupId = groupId;
        this.mDirty = true;
        return;
    }

    public void updateLayoutLimitedRefreshRateLocked(SurfaceControl.RefreshRateRange layoutLimitedRefreshRate) {
        if (Objects.equals(layoutLimitedRefreshRate, this.mLayoutLimitedRefreshRate) == true) goto L6;
        this.mLayoutLimitedRefreshRate = layoutLimitedRefreshRate;
        this.mDirty = true;
        return;
    }

    public void updateThermalRefreshRateThrottling(SparseArray<SurfaceControl.RefreshRateRange> refreshRanges) {
        if (refreshRanges != null) goto L5;
        refreshRanges = new SparseArray();
    L5:
        if (this.mThermalRefreshRateThrottling.contentEquals(refreshRanges) == true) goto L8;
        this.mThermalRefreshRateThrottling = refreshRanges;
        this.mDirty = true;
        return;
    }

    public void updateLocked(DisplayDeviceRepository deviceRepo, SyntheticModeManager syntheticModeManager) {
        if (this.mPrimaryDisplayDevice != null) goto L6;
        return;
    L6:
        if (deviceRepo.containsLocked(this.mPrimaryDisplayDevice) == true) goto L9;
        setPrimaryDisplayDeviceLocked(null);
        return;
    L9:
        DisplayDeviceInfo deviceInfo = this.mPrimaryDisplayDevice.getDisplayDeviceInfoLocked();
        DisplayDeviceConfig config = this.mPrimaryDisplayDevice.getDisplayDeviceConfig();
        if (Objects.equals(this.mPrimaryDisplayDeviceInfo, deviceInfo) == true) goto L12;
    L13:
        this.mBaseDisplayInfo.layerStack = this.mLayerStack;
        this.mBaseDisplayInfo.flags = 0;
        this.mBaseDisplayInfo.removeMode = 0;
        if ((deviceInfo.flags & 8) == 0) goto L17;
        this.mBaseDisplayInfo.flags |= 1;
    L17:
        if ((deviceInfo.flags & 4) == 0) goto L20;
        this.mBaseDisplayInfo.flags |= 2;
    L20:
        if ((deviceInfo.flags & 16) == 0) goto L23;
        this.mBaseDisplayInfo.flags |= 4;
        this.mBaseDisplayInfo.removeMode = 1;
    L23:
        if ((deviceInfo.flags & 1024) == 0) goto L26;
        this.mBaseDisplayInfo.removeMode = 1;
    L26:
        if ((deviceInfo.flags & 64) == 0) goto L29;
        this.mBaseDisplayInfo.flags |= 8;
    L29:
        if ((deviceInfo.flags & 256) == 0) goto L32;
        this.mBaseDisplayInfo.flags |= 16;
    L32:
        if ((deviceInfo.flags & 512) == 0) goto L35;
        this.mBaseDisplayInfo.flags |= 32;
    L35:
        if ((deviceInfo.flags & 4096) == 0) goto L38;
        this.mBaseDisplayInfo.flags |= 64;
    L38:
        if ((deviceInfo.flags & 8192) == 0) goto L41;
        this.mBaseDisplayInfo.flags |= 128;
    L41:
        if ((deviceInfo.flags & 16384) == 0) goto L44;
        this.mBaseDisplayInfo.flags |= 256;
    L44:
        if ((deviceInfo.flags & 32768) == 0) goto L47;
        this.mBaseDisplayInfo.flags |= 512;
    L47:
        if ((deviceInfo.flags & 2) == 0) goto L50;
        this.mBaseDisplayInfo.flags |= 16384;
    L50:
        if ((deviceInfo.flags & 65536) == 0) goto L53;
        this.mBaseDisplayInfo.flags |= 1024;
    L53:
        if ((deviceInfo.flags & 131072) == 0) goto L56;
        this.mBaseDisplayInfo.flags |= 2048;
    L56:
        if ((deviceInfo.flags & 524288) == 0) goto L59;
        this.mBaseDisplayInfo.flags |= 4096;
    L59:
        if ((deviceInfo.flags & 1048576) != 0) goto L61;
    L63:
        Rect maskingInsets = getMaskingInsets(deviceInfo);
        int maskedWidth = (deviceInfo.width - maskingInsets.left) - maskingInsets.right;
        int maskedHeight = (deviceInfo.height - maskingInsets.top) - maskingInsets.bottom;
        if (this.mIsAnisotropyCorrectionEnabled == true) goto L66;
    L77:
        this.mBaseDisplayInfo.type = deviceInfo.type;
        this.mBaseDisplayInfo.address = deviceInfo.address;
        this.mBaseDisplayInfo.deviceProductInfo = deviceInfo.deviceProductInfo;
        this.mBaseDisplayInfo.name = deviceInfo.name;
        this.mBaseDisplayInfo.uniqueId = deviceInfo.uniqueId;
        this.mBaseDisplayInfo.appWidth = maskedWidth;
        this.mBaseDisplayInfo.appHeight = maskedHeight;
        this.mBaseDisplayInfo.logicalWidth = maskedWidth;
        this.mBaseDisplayInfo.logicalHeight = maskedHeight;
        this.mBaseDisplayInfo.rotation = 0;
        this.mBaseDisplayInfo.modeId = deviceInfo.modeId;
        this.mBaseDisplayInfo.renderFrameRate = deviceInfo.renderFrameRate;
        this.mBaseDisplayInfo.hasArrSupport = deviceInfo.hasArrSupport;
        this.mBaseDisplayInfo.frameRateCategoryRate = deviceInfo.frameRateCategoryRate;
        this.mBaseDisplayInfo.supportedRefreshRates = Arrays.copyOf(deviceInfo.supportedRefreshRates, deviceInfo.supportedRefreshRates.length);
        this.mBaseDisplayInfo.defaultModeId = deviceInfo.defaultModeId;
        this.mBaseDisplayInfo.userPreferredModeId = deviceInfo.userPreferredModeId;
        this.mBaseDisplayInfo.supportedModes = (Display.Mode[]) Arrays.copyOf(deviceInfo.supportedModes, deviceInfo.supportedModes.length);
        this.mBaseDisplayInfo.appsSupportedModes = syntheticModeManager.createAppSupportedModes(config, this.mBaseDisplayInfo.supportedModes, this.mBaseDisplayInfo.hasArrSupport);
        this.mBaseDisplayInfo.colorMode = deviceInfo.colorMode;
        this.mBaseDisplayInfo.supportedColorModes = Arrays.copyOf(deviceInfo.supportedColorModes, deviceInfo.supportedColorModes.length);
        this.mBaseDisplayInfo.hdrCapabilities = deviceInfo.hdrCapabilities;
        this.mBaseDisplayInfo.isForceSdr = deviceInfo.isForceSdr;
        this.mBaseDisplayInfo.userDisabledHdrTypes = this.mUserDisabledHdrTypes;
        DisplayInfo r6 = this.mBaseDisplayInfo;
        if (deviceInfo.allmSupported == false) goto L80;
    L83:
        boolean r9 = true;
    L84:
        r6.minimalPostProcessingSupported = r9;
        this.mBaseDisplayInfo.logicalDensityDpi = deviceInfo.densityDpi;
        this.mBaseDisplayInfo.physicalXDpi = deviceInfo.xDpi;
        this.mBaseDisplayInfo.physicalYDpi = deviceInfo.yDpi;
        this.mBaseDisplayInfo.appVsyncOffsetNanos = deviceInfo.appVsyncOffsetNanos;
        this.mBaseDisplayInfo.presentationDeadlineNanos = deviceInfo.presentationDeadlineNanos;
        this.mBaseDisplayInfo.state = deviceInfo.state;
        this.mBaseDisplayInfo.committedState = deviceInfo.committedState;
        this.mBaseDisplayInfo.smallestNominalAppWidth = maskedWidth;
        this.mBaseDisplayInfo.smallestNominalAppHeight = maskedHeight;
        this.mBaseDisplayInfo.largestNominalAppWidth = maskedWidth;
        this.mBaseDisplayInfo.largestNominalAppHeight = maskedHeight;
        this.mBaseDisplayInfo.ownerUid = deviceInfo.ownerUid;
        this.mBaseDisplayInfo.ownerPackageName = deviceInfo.ownerPackageName;
        if ((deviceInfo.flags & 2048) == 0) goto L87;
        boolean maskCutout = true;
    L88:
        DisplayInfo r10 = this.mBaseDisplayInfo;
        if (maskCutout == false) goto L91;
        DisplayCutout r11 = null;
    L92:
        r10.displayCutout = r11;
        this.mBaseDisplayInfo.displayId = this.mDisplayId;
        this.mBaseDisplayInfo.displayGroupId = this.mDisplayGroupId;
        updateFrameRateOverrides(deviceInfo);
        this.mBaseDisplayInfo.brightnessMinimum = deviceInfo.brightnessMinimum;
        this.mBaseDisplayInfo.brightnessMaximum = deviceInfo.brightnessMaximum;
        this.mBaseDisplayInfo.brightnessDefault = deviceInfo.brightnessDefault;
        this.mBaseDisplayInfo.brightnessDim = deviceInfo.brightnessDim;
        this.mBaseDisplayInfo.hdrSdrRatio = deviceInfo.hdrSdrRatio;
        this.mBaseDisplayInfo.roundedCorners = deviceInfo.roundedCorners;
        this.mBaseDisplayInfo.installOrientation = deviceInfo.installOrientation;
        this.mBaseDisplayInfo.displayShape = deviceInfo.displayShape;
        if (this.mDevicePosition != 1) goto L95;
        this.mBaseDisplayInfo.flags |= 8192;
        this.mBaseDisplayInfo.flags |= 8;
        this.mBaseDisplayInfo.removeMode = 1;
    L95:
        this.mBaseDisplayInfo.layoutLimitedRefreshRate = this.mLayoutLimitedRefreshRate;
        this.mBaseDisplayInfo.thermalRefreshRateThrottling = this.mThermalRefreshRateThrottling;
        this.mBaseDisplayInfo.thermalBrightnessThrottlingDataId = this.mThermalBrightnessThrottlingDataId;
        this.mBaseDisplayInfo.canHostTasks = this.mCanHostTasks;
        this.mPrimaryDisplayDeviceInfo = deviceInfo;
        this.mInfo.set(null);
        this.mDirty = false;
        return;
    L91:
        r11 = deviceInfo.displayCutout;
        goto L92
    L87:
        maskCutout = false;
        goto L88
    L80:
        if (deviceInfo.gameContentTypeSupported == true) goto L83;
        r9 = false;
        goto L84
    L66:
        if (deviceInfo.type != 2) goto L77;
        if (deviceInfo.xDpi <= 0.0f) goto L77;
        if (deviceInfo.yDpi <= 0.0f) goto L77;
        if (deviceInfo.xDpi <= (deviceInfo.yDpi * 1.025f)) goto L75;
        maskedHeight = (int) (((double) ((maskedHeight * deviceInfo.xDpi) / deviceInfo.yDpi)) + 0.5d);
        goto L77
    L75:
        if ((deviceInfo.xDpi * 1.025f) >= deviceInfo.yDpi) goto L77;
        maskedWidth = (int) (((double) ((maskedWidth * deviceInfo.yDpi) / deviceInfo.xDpi)) + 0.5d);
        goto L77
    L61:
        if (this.mDevicePosition == 1) goto L63;
        DisplayInfo r3 = this.mBaseDisplayInfo;
        r3.flags = 32768 | r3.flags;
        goto L63
    L12:
        if (this.mDirty == true) goto L13;
    }

    private void updateFrameRateOverrides(DisplayDeviceInfo deviceInfo) {
        this.mTempFrameRateOverride.clear();
        int r1 = 0;
        if (this.mFrameRateOverrides == null) goto L8;
        DisplayEventReceiver.FrameRateOverride[] r0 = this.mFrameRateOverrides;
        int r2 = r0.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L8;
        DisplayEventReceiver.FrameRateOverride frameRateOverride = r0[r3];
        this.mTempFrameRateOverride.put(frameRateOverride.uid, Float.valueOf(frameRateOverride.frameRateHz));
        r3 = r3 + 1;
    L8:
        this.mFrameRateOverrides = deviceInfo.frameRateOverrides;
        if (this.mFrameRateOverrides == null) goto L21;
        DisplayEventReceiver.FrameRateOverride[] r4 = this.mFrameRateOverrides;
        int r5 = r4.length;
    L12:
        if (r1 >= r5) goto L21;
        DisplayEventReceiver.FrameRateOverride frameRateOverride2 = r4[r1];
        float refreshRate = this.mTempFrameRateOverride.get(frameRateOverride2.uid, Float.valueOf(0.0f)).floatValue();
        if (refreshRate != 0.0f) goto L16;
    L19:
        this.mTempFrameRateOverride.put(frameRateOverride2.uid, Float.valueOf(frameRateOverride2.frameRateHz));
    L20:
        r1 = r1 + 1;
        goto L12
    L16:
        if (frameRateOverride2.frameRateHz != refreshRate) goto L19;
        this.mTempFrameRateOverride.delete(frameRateOverride2.uid);
    L21:
        int i = 0;
    L23:
        if (i >= this.mTempFrameRateOverride.size()) goto L26;
        this.mPendingFrameRateOverrideUids.add(Integer.valueOf(this.mTempFrameRateOverride.keyAt(i)));
        i = i + 1;
        goto L23
    }

    public Rect getInsets() {
        return getMaskingInsets(this.mPrimaryDisplayDeviceInfo);
    }

    private static Rect getMaskingInsets(DisplayDeviceInfo deviceInfo) {
        if ((deviceInfo.flags & 2048) == 0) goto L5;
        boolean maskCutout = true;
    L6:
        if (maskCutout == false) goto L12;
        if (deviceInfo.displayCutout == null) goto L12;
        return deviceInfo.displayCutout.getSafeInsets();
    L12:
        return new Rect();
    L5:
        maskCutout = false;
        goto L6
    }

    Point getDisplayPosition() {
        return new Point(this.mDisplayPosition);
    }

    public void configureDisplayLocked(SurfaceControl.Transaction t, DisplayDevice device, boolean isBlanked) {
        if (isBlanked == false) goto L5;
        int r3 = -1;
    L6:
        device.setLayerStackLocked(t, r3, this.mDisplayId);
        this.mExt.setDisplayFlagsLocked(t, device);
        boolean rotated = false;
        if (device != this.mPrimaryDisplayDevice) goto L9;
        device.setDesiredDisplayModeSpecsLocked(this.mDesiredDisplayModeSpecs);
        device.setRequestedColorModeLocked(this.mRequestedColorMode);
    L10:
        device.setAutoLowLatencyModeLocked(this.mRequestedMinimalPostProcessing);
        device.setGameContentTypeLocked(this.mRequestedMinimalPostProcessing);
        DisplayInfo displayInfo = getDisplayInfoLocked();
        DisplayDeviceInfo displayDeviceInfo = device.getDisplayDeviceInfoLocked();
        this.mTempLayerStackRect.set(0, 0, displayInfo.logicalWidth, displayInfo.logicalHeight);
        int orientation = 0;
        if ((displayDeviceInfo.flags & 2) == 0) goto L13;
    L14:
        orientation = displayInfo.rotation;
    L15:
        int orientation2 = (displayDeviceInfo.rotation + orientation) % 4;
        if (orientation2 != 1) goto L18;
    L19:
        rotated = true;
    L20:
        if (rotated == false) goto L22;
        int physWidth = displayDeviceInfo.height;
    L23:
        if (rotated == false) goto L25;
        int physHeight = displayDeviceInfo.width;
    L26:
        Rect maskingInsets = getMaskingInsets(displayDeviceInfo);
        InsetUtils.rotateInsets(maskingInsets, orientation2);
        int physWidth2 = physWidth - (maskingInsets.left + maskingInsets.right);
        int physHeight2 = physHeight - (maskingInsets.top + maskingInsets.bottom);
        int displayLogicalWidth = displayInfo.logicalWidth;
        int displayLogicalHeight = displayInfo.logicalHeight;
        if (this.mIsAnisotropyCorrectionEnabled == true) goto L29;
    L47:
        int r19 = 2;
        int physWidth3 = physWidth2;
    L49:
        if ((displayInfo.flags & 1073741824) == 0) goto L51;
    L57:
        int displayRectWidth = displayLogicalWidth;
        int displayRectHeight = displayLogicalHeight;
    L58:
        int displayRectTop = (physHeight2 - displayRectHeight) / 2;
        int displayRectLeft = (physWidth3 - displayRectWidth) / 2;
        this.mTempDisplayRect.set(displayRectLeft, displayRectTop, displayRectLeft + displayRectWidth, displayRectTop + displayRectHeight);
        this.mTempDisplayRect.offset(maskingInsets.left, maskingInsets.top);
        if (orientation2 != 0) goto L62;
        this.mTempDisplayRect.offset(this.mDisplayOffsetX, this.mDisplayOffsetY);
    L68:
        this.mDisplayPosition.set(this.mTempDisplayRect.left, this.mTempDisplayRect.top);
        if (this.mSyncedResolutionSwitchEnabled == false) goto L71;
    L72:
        device.configureDisplaySizeLocked(t);
    L73:
        device.setProjectionLocked(t, orientation2, this.mTempLayerStackRect, this.mTempDisplayRect);
        device.configureSurfaceLocked(t);
        return;
    L71:
        if (displayDeviceInfo.type != 5) goto L73;
    L62:
        if (orientation2 != 1) goto L65;
        this.mTempDisplayRect.offset(this.mDisplayOffsetY, -this.mDisplayOffsetX);
        goto L68
    L65:
        if (orientation2 != r19) goto L67;
        this.mTempDisplayRect.offset(-this.mDisplayOffsetX, -this.mDisplayOffsetY);
        goto L68
    L67:
        this.mTempDisplayRect.offset(-this.mDisplayOffsetY, this.mDisplayOffsetX);
        goto L68
    L51:
        if (this.mDisplayScalingDisabled == true) goto L57;
        if ((physWidth3 * displayLogicalHeight) >= (physHeight2 * displayLogicalWidth)) goto L56;
        displayRectWidth = physWidth3;
        displayRectHeight = (displayLogicalHeight * physWidth3) / displayLogicalWidth;
        goto L58
    L56:
        int displayRectWidth2 = displayLogicalWidth * physHeight2;
        displayRectWidth = displayRectWidth2 / displayLogicalHeight;
        displayRectHeight = physHeight2;
        goto L58
    L29:
        if (displayDeviceInfo.type != 2) goto L47;
        if (displayDeviceInfo.xDpi <= 0.0f) goto L47;
        if (displayDeviceInfo.yDpi <= 0.0f) goto L47;
        if (displayDeviceInfo.xDpi <= (displayDeviceInfo.yDpi * 1.025f)) goto L41;
        float scalingFactor = displayDeviceInfo.yDpi / displayDeviceInfo.xDpi;
        if (rotated == false) goto L39;
        r19 = 2;
        physWidth3 = physWidth2;
        displayLogicalWidth = (int) (((double) (displayLogicalWidth * scalingFactor)) + 0.5d);
        goto L49
    L39:
        r19 = 2;
        physWidth3 = physWidth2;
        displayLogicalHeight = (int) (((double) (displayLogicalHeight * scalingFactor)) + 0.5d);
        goto L49
    L41:
        r19 = 2;
        physWidth3 = physWidth2;
        if ((displayDeviceInfo.xDpi * 1.025f) >= displayDeviceInfo.yDpi) goto L49;
        float scalingFactor2 = displayDeviceInfo.xDpi / displayDeviceInfo.yDpi;
        if (rotated == false) goto L46;
        displayLogicalHeight = (int) (((double) (displayLogicalHeight * scalingFactor2)) + 0.5d);
        goto L49
    L46:
        displayLogicalWidth = (int) (((double) (displayLogicalWidth * scalingFactor2)) + 0.5d);
        goto L49
    L25:
        physHeight = displayDeviceInfo.height;
        goto L26
    L22:
        physWidth = displayDeviceInfo.width;
        goto L23
    L18:
        if (orientation2 != 3) goto L20;
    L13:
        if (this.mAlwaysRotateDisplayDeviceEnabled == false) goto L15;
    L9:
        device.setDesiredDisplayModeSpecsLocked(new DisplayModeDirector.DesiredDisplayModeSpecs());
        device.setRequestedColorModeLocked(0);
        goto L10
    L5:
        r3 = this.mLayerStack;
        goto L6
    }

    public boolean hasContentLocked() {
        return this.mHasContent;
    }

    public void setHasContentLocked(boolean hasContent) {
        this.mHasContent = hasContent;
    }

    public void setDesiredDisplayModeSpecsLocked(DisplayModeDirector.DesiredDisplayModeSpecs specs) {
        this.mDesiredDisplayModeSpecs = specs;
    }

    public DisplayModeDirector.DesiredDisplayModeSpecs getDesiredDisplayModeSpecsLocked() {
        return this.mDesiredDisplayModeSpecs;
    }

    public void setRequestedColorModeLocked(int colorMode) {
        this.mRequestedColorMode = colorMode;
    }

    public boolean getRequestedMinimalPostProcessingLocked() {
        return this.mRequestedMinimalPostProcessing;
    }

    public void setRequestedMinimalPostProcessingLocked(boolean on) {
        this.mRequestedMinimalPostProcessing = on;
    }

    public int getRequestedColorModeLocked() {
        return this.mRequestedColorMode;
    }

    public int getDisplayOffsetXLocked() {
        return this.mDisplayOffsetX;
    }

    public int getDisplayOffsetYLocked() {
        return this.mDisplayOffsetY;
    }

    public void setDisplayOffsetsLocked(int x, int y) {
        this.mDisplayOffsetX = x;
        this.mDisplayOffsetY = y;
    }

    public boolean isDisplayScalingDisabled() {
        return this.mDisplayScalingDisabled;
    }

    public void setDisplayScalingDisabledLocked(boolean disableScaling) {
        this.mDisplayScalingDisabled = disableScaling;
    }

    public void setUserDisabledHdrTypes(int[] userDisabledHdrTypes) {
        if (this.mUserDisabledHdrTypes == userDisabledHdrTypes) goto L6;
        this.mUserDisabledHdrTypes = userDisabledHdrTypes;
        this.mBaseDisplayInfo.userDisabledHdrTypes = userDisabledHdrTypes;
        this.mInfo.set(null);
        return;
    }

    public boolean setIsForceSdr(boolean isForceSdr) {
        int displayType = getDisplayInfoLocked().type;
        boolean isTargetDisplayType = true;
        if (displayType == 1) goto L11;
        if (displayType == 2) goto L11;
        if (displayType == 4) goto L11;
        isTargetDisplayType = false;
    L11:
        if (isTargetDisplayType == true) goto L13;
        return false;
    L13:
        if (this.mBaseDisplayInfo.isForceSdr == isForceSdr) goto L17;
        this.mBaseDisplayInfo.isForceSdr = isForceSdr;
        this.mInfo.set(null);
        return true;
    L17:
        return false;
    }

    boolean canHostTasksLocked() {
        return this.mCanHostTasks;
    }

    boolean setCanHostTasksLocked(boolean canHostTasks) {
        boolean canHostTasks2 = validateCanHostTasksLocked(canHostTasks);
        if (this.mBaseDisplayInfo.canHostTasks != canHostTasks2) goto L6;
        return false;
    L6:
        this.mCanHostTasks = canHostTasks2;
        this.mBaseDisplayInfo.canHostTasks = canHostTasks2;
        this.mInfo.set(null);
        return true;
    }

    private boolean validateCanHostTasksLocked(boolean canHostTasks) {
        if (getDisplayIdLocked() != 0) goto L5;
        return true;
    L5:
        boolean ownContent = false;
        if (this.mPrimaryDisplayDevice.shouldOnlyMirror() == false) goto L9;
        return false;
    L9:
        if (getDevicePositionLocked() != 1) goto L11;
        boolean isRearDisplay = true;
    L13:
        if ((this.mPrimaryDisplayDevice.getDisplayDeviceInfoLocked().flags & 128) != 0) goto L15;
        if (isRearDisplay == true) goto L15;
    L16:
        if (ownContent == false) goto L18;
        return true;
    L18:
        return canHostTasks;
    L15:
        ownContent = true;
        goto L16
    L11:
        isRearDisplay = false;
        goto L13
    }

    public void swapDisplaysLocked(LogicalDisplay targetDisplay) {
        DisplayDevice oldTargetDevice = targetDisplay.setPrimaryDisplayDeviceLocked(this.mPrimaryDisplayDevice);
        setPrimaryDisplayDeviceLocked(oldTargetDevice);
    }

    public DisplayDevice setPrimaryDisplayDeviceLocked(DisplayDevice device) {
        DisplayDevice old = this.mPrimaryDisplayDevice;
        this.mPrimaryDisplayDevice = device;
        this.mPrimaryDisplayDeviceInfo = null;
        this.mBaseDisplayInfo.copyFrom(EMPTY_DISPLAY_INFO);
        this.mInfo.set(null);
        return old;
    }

    public boolean isEnabledLocked() {
        return this.mIsEnabled;
    }

    public void setEnabledLocked(boolean enabled) {
        if (enabled == this.mIsEnabled) goto L6;
        this.mDirty = true;
        this.mIsEnabled = enabled;
        return;
    }

    public boolean isInTransitionLocked() {
        return this.mIsInTransition;
    }

    public void setIsInTransitionLocked(boolean isInTransition) {
        this.mIsInTransition = isInTransition;
    }

    public void setThermalBrightnessThrottlingDataIdLocked(String brightnessThrottlingDataId) {
        if (Objects.equals(brightnessThrottlingDataId, this.mThermalBrightnessThrottlingDataId) == true) goto L6;
        this.mThermalBrightnessThrottlingDataId = brightnessThrottlingDataId;
        this.mDirty = true;
        return;
    }

    public void setPowerThrottlingDataIdLocked(String powerThrottlingDataId) {
        if (Objects.equals(powerThrottlingDataId, this.mPowerThrottlingDataId) == true) goto L6;
        this.mPowerThrottlingDataId = powerThrottlingDataId;
        this.mDirty = true;
        return;
    }

    public String getPowerThrottlingDataIdLocked() {
        return this.mPowerThrottlingDataId;
    }

    public void setLeadDisplayLocked(int displayId) {
        if (this.mDisplayId != this.mLeadDisplayId) goto L5;
        return;
    L5:
        if (this.mDisplayId == displayId) goto L9;
        this.mLeadDisplayId = displayId;
        return;
    }

    public int getLeadDisplayIdLocked() {
        return this.mLeadDisplayId;
    }

    public void setDisplayGroupNameLocked(String displayGroupName) {
        this.mDisplayGroupName = displayGroupName;
    }

    public String getDisplayGroupNameLocked() {
        return this.mDisplayGroupName;
    }

    public void setDisplayOffloadSessionLocked(DisplayOffloadSessionImpl session) {
        this.mDisplayOffloadSession = session;
    }

    public DisplayOffloadSessionImpl getDisplayOffloadSessionLocked() {
        return this.mDisplayOffloadSession;
    }

    public void dumpLocked(PrintWriter pw) {
        pw.println("mDisplayId=" + this.mDisplayId);
        StringBuilder r0 = new StringBuilder();
        r0.append("mPrimaryDisplayDevice=");
        if (this.mPrimaryDisplayDevice == null) goto L5;
        String r1 = this.mPrimaryDisplayDevice.getNameLocked() + "(" + this.mPrimaryDisplayDevice.getUniqueId() + ")";
    L6:
        r0.append(r1);
        pw.println(r0.toString());
        pw.println("mIsEnabled=" + this.mIsEnabled);
        pw.println("mIsInTransition=" + this.mIsInTransition);
        pw.println("mLayerStack=" + this.mLayerStack);
        pw.println("mPosition=" + this.mDevicePosition);
        pw.println("mHasContent=" + this.mHasContent);
        pw.println("mDesiredDisplayModeSpecs={" + this.mDesiredDisplayModeSpecs + "}");
        StringBuilder r2 = new StringBuilder();
        r2.append("mRequestedColorMode=");
        r2.append(this.mRequestedColorMode);
        pw.println(r2.toString());
        pw.println("mDisplayOffset=(" + this.mDisplayOffsetX + ", " + this.mDisplayOffsetY + ")");
        StringBuilder r3 = new StringBuilder();
        r3.append("mDisplayScalingDisabled=");
        r3.append(this.mDisplayScalingDisabled);
        pw.println(r3.toString());
        pw.println("mBaseDisplayInfo=" + this.mBaseDisplayInfo);
        pw.println("mOverrideDisplayInfo=" + this.mOverrideDisplayInfo);
        pw.println("mRequestedMinimalPostProcessing=" + this.mRequestedMinimalPostProcessing);
        pw.println("mFrameRateOverrides=" + Arrays.toString(this.mFrameRateOverrides));
        pw.println("mPendingFrameRateOverrideUids=" + this.mPendingFrameRateOverrideUids);
        pw.println("mDisplayGroupId=" + this.mDisplayGroupId);
        pw.println("mDisplayGroupName=" + this.mDisplayGroupName);
        pw.println("mThermalBrightnessThrottlingDataId=" + this.mThermalBrightnessThrottlingDataId);
        pw.println("mLeadDisplayId=" + this.mLeadDisplayId);
        pw.println("mLayoutLimitedRefreshRate=" + this.mLayoutLimitedRefreshRate);
        pw.println("mThermalRefreshRateThrottling=" + this.mThermalRefreshRateThrottling);
        pw.println("mPowerThrottlingDataId=" + this.mPowerThrottlingDataId);
        return;
    L5:
        r1 = "null";
        goto L6
    }

    public String toString() {
        StringWriter sw = new StringWriter();
        dumpLocked(new PrintWriter(sw));
        return sw.toString();
    }
}
