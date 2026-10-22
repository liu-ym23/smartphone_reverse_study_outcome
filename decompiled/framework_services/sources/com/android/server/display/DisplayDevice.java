package com.android.server.display;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.display.DisplayViewport;
import android.os.IBinder;
import android.util.ArraySet;
import android.util.Slog;
import android.view.Display;
import android.view.DisplayAddress;
import android.view.Surface;
import android.view.SurfaceControl;
import com.android.server.display.mode.DisplayModeDirector;
import java.io.PrintWriter;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
abstract class DisplayDevice {
    private static final Display.Mode EMPTY_DISPLAY_MODE = null;
    static final float MAX_ANISOTROPY = 1.025f;
    private static final String TAG = "DisplayDevice";
    private final Context mContext;
    private Rect mCurrentDisplayRect;
    private int mCurrentFlags;
    private int mCurrentLayerStack;
    private Rect mCurrentLayerStackRect;
    private int mCurrentOrientation;
    private Surface mCurrentSurface;
    DisplayDeviceInfo mDebugLastLoggedDeviceInfo;
    private final DisplayAdapter mDisplayAdapter;
    protected DisplayDeviceConfig mDisplayDeviceConfig;
    private final IBinder mDisplayToken;
    private final boolean mIsAnisotropyCorrectionEnabled;
    private int mLastDisplayHeight;
    private int mLastDisplayWidth;
    private final String mUniqueId;

    public static /* synthetic */ int $r8$lambda$icCjAt3NvD1wZvC7Pld2_13VD74(Point r0, Point r1) {
        return lambda$getSupportedResolutionsLocked$0(r0, r1);
    }

    public abstract DisplayDeviceInfo getDisplayDeviceInfoLocked();

    public abstract boolean hasStableUniqueId();

    static {
        EMPTY_DISPLAY_MODE = new Display.Mode.Builder().build();
    }

    DisplayDevice(DisplayAdapter displayAdapter, IBinder displayToken, String uniqueId, Context context) {
        this(displayAdapter, displayToken, uniqueId, context, false);
    }

    DisplayDevice(DisplayAdapter displayAdapter, IBinder displayToken, String uniqueId, Context context, boolean isAnisotropyCorrectionEnabled) {
        this.mCurrentLayerStack = -1;
        this.mCurrentFlags = 0;
        this.mCurrentOrientation = -1;
        this.mDisplayAdapter = displayAdapter;
        this.mDisplayToken = displayToken;
        this.mUniqueId = uniqueId;
        this.mDisplayDeviceConfig = null;
        this.mContext = context;
        this.mIsAnisotropyCorrectionEnabled = isAnisotropyCorrectionEnabled;
    }

    public final DisplayAdapter getAdapterLocked() {
        return this.mDisplayAdapter;
    }

    public DisplayDeviceConfig getDisplayDeviceConfig() {
        if (this.mDisplayDeviceConfig != null) goto L6;
        this.mDisplayDeviceConfig = loadDisplayDeviceConfig();
    L6:
        return this.mDisplayDeviceConfig;
    }

    public final IBinder getDisplayTokenLocked() {
        return this.mDisplayToken;
    }

    public int getDisplayIdToMirrorLocked() {
        return 0;
    }

    public boolean isWindowManagerMirroringLocked() {
        return false;
    }

    public void setWindowManagerMirroringLocked(boolean isMirroring) {
    }

    public Point getDisplaySurfaceDefaultSizeLocked() {
        DisplayDeviceInfo displayDeviceInfo = getDisplayDeviceInfoLocked();
        int width = displayDeviceInfo.width;
        int height = displayDeviceInfo.height;
        if (this.mIsAnisotropyCorrectionEnabled == false) goto L17;
        if (displayDeviceInfo.type != 2) goto L17;
        if (displayDeviceInfo.yDpi <= 0.0f) goto L17;
        if (displayDeviceInfo.xDpi <= 0.0f) goto L17;
        if (displayDeviceInfo.xDpi <= (displayDeviceInfo.yDpi * MAX_ANISOTROPY)) goto L14;
        height = (int) (((double) ((height * displayDeviceInfo.xDpi) / displayDeviceInfo.yDpi)) + 0.5d);
        goto L17
    L14:
        if ((displayDeviceInfo.xDpi * MAX_ANISOTROPY) >= displayDeviceInfo.yDpi) goto L17;
        width = (int) (((double) ((width * displayDeviceInfo.yDpi) / displayDeviceInfo.xDpi)) + 0.5d);
    L17:
        if (isRotatedLocked() == false) goto L20;
        return new Point(height, width);
    L20:
        return new Point(width, height);
    }

    public final String getNameLocked() {
        return getDisplayDeviceInfoLocked().name;
    }

    public final String getUniqueId() {
        return this.mUniqueId;
    }

    public void applyPendingDisplayDeviceInfoChangesLocked() {
    }

    public void configureSurfaceLocked(SurfaceControl.Transaction t) {
    }

    public Runnable requestDisplayStateLocked(int state, float brightnessState, float sdrBrightnessState, DisplayOffloadSessionImpl displayOffloadSession) {
        return null;
    }

    public void setDesiredDisplayModeSpecsLocked(DisplayModeDirector.DesiredDisplayModeSpecs displayModeSpecs) {
    }

    public void setUserPreferredDisplayModeLocked(Display.Mode mode) {
    }

    public Display.Mode getUserPreferredDisplayModeLocked() {
        return EMPTY_DISPLAY_MODE;
    }

    public Display.Mode getSystemPreferredDisplayModeLocked() {
        return EMPTY_DISPLAY_MODE;
    }

    public Display.Mode getActiveDisplayModeAtStartLocked() {
        return EMPTY_DISPLAY_MODE;
    }

    public void setRequestedColorModeLocked(int colorMode) {
    }

    public void setAutoLowLatencyModeLocked(boolean on) {
    }

    public void setGameContentTypeLocked(boolean on) {
    }

    public void onOverlayChangedLocked() {
    }

    public boolean shouldOnlyMirror() {
        return false;
    }

    public final void setLayerStackLocked(SurfaceControl.Transaction t, int layerStack, int layerStackTag) {
        if (this.mCurrentLayerStack == layerStack) goto L6;
        this.mCurrentLayerStack = layerStack;
        t.setDisplayLayerStack(this.mDisplayToken, layerStack);
        Slog.i(TAG, "[" + layerStackTag + "] Layerstack set to " + layerStack + " for " + this.mUniqueId);
        return;
    }

    public final void setDisplayFlagsLocked(SurfaceControl.Transaction t, int flags) {
        if (this.mCurrentFlags == flags) goto L6;
        this.mCurrentFlags = flags;
        t.setDisplayFlags(this.mDisplayToken, flags);
        return;
    }

    public final void setProjectionLocked(SurfaceControl.Transaction t, int orientation, Rect layerStackRect, Rect displayRect) {
        if (this.mCurrentOrientation == orientation) goto L5;
    L12:
        this.mCurrentOrientation = orientation;
        if (this.mCurrentLayerStackRect != null) goto L15;
        this.mCurrentLayerStackRect = new Rect();
    L15:
        this.mCurrentLayerStackRect.set(layerStackRect);
        if (this.mCurrentDisplayRect != null) goto L18;
        this.mCurrentDisplayRect = new Rect();
    L18:
        this.mCurrentDisplayRect.set(displayRect);
        t.setDisplayProjection(this.mDisplayToken, orientation, layerStackRect, displayRect);
        return;
    L5:
        if (this.mCurrentLayerStackRect == null) goto L12;
        if (this.mCurrentLayerStackRect.equals(layerStackRect) == false) goto L12;
        if (this.mCurrentDisplayRect == null) goto L12;
        if (this.mCurrentDisplayRect.equals(displayRect) == false) goto L12;
    }

    public void configureDisplaySizeLocked(SurfaceControl.Transaction t) {
        DisplayDeviceInfo info = getDisplayDeviceInfoLocked();
        boolean isInstalledRotated = true;
        if (info.installOrientation != 1) goto L5;
    L8:
        if (isInstalledRotated == false) goto L10;
        int displayWidth = info.height;
    L11:
        if (isInstalledRotated == false) goto L13;
        int displayHeight = info.width;
    L14:
        setDisplaySizeLocked(t, displayWidth, displayHeight);
        return;
    L13:
        displayHeight = info.height;
        goto L14
    L10:
        displayWidth = info.width;
        goto L11
    L5:
        if (info.installOrientation == 3) goto L8;
        isInstalledRotated = false;
        goto L8
    }

    public final void setDisplaySizeLocked(SurfaceControl.Transaction t, int width, int height) {
        if (width != this.mLastDisplayWidth) goto L5;
        return;
    L5:
        if (height == this.mLastDisplayHeight) goto L9;
        this.mLastDisplayWidth = width;
        this.mLastDisplayHeight = height;
        t.setDisplaySize(this.mDisplayToken, width, height);
        return;
    }

    public final void setSurfaceLocked(SurfaceControl.Transaction t, Surface surface) {
        if (this.mCurrentSurface == surface) goto L6;
        this.mCurrentSurface = surface;
        t.setDisplaySurface(this.mDisplayToken, surface);
        return;
    }

    public final void populateViewportLocked(DisplayViewport viewport) {
        viewport.orientation = this.mCurrentOrientation;
        if (this.mCurrentLayerStackRect == null) goto L5;
        viewport.logicalFrame.set(this.mCurrentLayerStackRect);
    L7:
        if (this.mCurrentDisplayRect == null) goto L9;
        viewport.physicalFrame.set(this.mCurrentDisplayRect);
    L10:
        boolean isRotated = isRotatedLocked();
        DisplayDeviceInfo info = getDisplayDeviceInfoLocked();
        if (isRotated == false) goto L13;
        int r2 = info.height;
    L14:
        viewport.deviceWidth = r2;
        if (isRotated == false) goto L17;
        int r3 = info.width;
    L18:
        viewport.deviceHeight = r3;
        viewport.uniqueId = info.uniqueId;
        if ((info.address instanceof DisplayAddress.Physical) == false) goto L21;
        viewport.physicalPort = Integer.valueOf(info.address.getPort());
        return;
    L21:
        viewport.physicalPort = null;
        return;
    L17:
        r3 = info.height;
        goto L18
    L13:
        r2 = info.width;
        goto L14
    L9:
        viewport.physicalFrame.setEmpty();
        goto L10
    L5:
        viewport.logicalFrame.setEmpty();
        goto L7
    }

    public void dumpLocked(PrintWriter pw) {
        pw.println("mAdapter=" + this.mDisplayAdapter.getName());
        pw.println("mUniqueId=" + this.mUniqueId);
        pw.println("mDisplayToken=" + this.mDisplayToken);
        pw.println("mCurrentLayerStack=" + this.mCurrentLayerStack);
        pw.println("mCurrentFlags=" + this.mCurrentFlags);
        pw.println("mCurrentOrientation=" + this.mCurrentOrientation);
        pw.println("mCurrentLayerStackRect=" + this.mCurrentLayerStackRect);
        pw.println("mCurrentDisplayRect=" + this.mCurrentDisplayRect);
        pw.println("mCurrentSurface=" + this.mCurrentSurface);
    }

    boolean isRotatedLocked() {
        if (this.mCurrentOrientation != 1) goto L5;
        return true;
    L5:
        if (this.mCurrentOrientation == 3) goto L10;
        return false;
    L10:
        return true;
    }

    Point[] getSupportedResolutionsLocked() {
        ArraySet<Point> resolutions = new ArraySet(2);
        Display.Mode[] supportedModes = getDisplayDeviceInfoLocked().supportedModes;
        int r2 = supportedModes.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        Display.Mode mode = supportedModes[r3];
        resolutions.add(new Point(mode.getPhysicalWidth(), mode.getPhysicalHeight()));
        r3 = r3 + 1;
        goto L3
    L5:
        Point[] sortedArray = new Point[resolutions.size()];
        resolutions.toArray(sortedArray);
        Arrays.sort(sortedArray, new DisplayDevice$$ExternalSyntheticLambda0());
        return sortedArray;
    }

    private static /* synthetic */ int lambda$getSupportedResolutionsLocked$0(Point p1, Point p2) {
        return (p1.x * p1.y) - (p2.x * p2.y);
    }

    private DisplayDeviceConfig loadDisplayDeviceConfig() {
        return DisplayDeviceConfig.create(this.mContext, false, this.mDisplayAdapter.getFeatureFlags());
    }
}
