package com.android.server.vr;

import android.app.ActivityManagerInternal;
import android.app.Vr2dDisplayProperties;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.hardware.display.VirtualDisplayConfig;
import android.media.ImageReader;
import android.os.Handler;
import android.os.RemoteException;
import android.service.vr.IPersistentVrStateCallbacks;
import android.service.vr.IVrManager;
import android.util.Log;
import android.view.Surface;
import com.android.server.ISmtResourceControl;
import com.android.server.LocalServices;
import com.android.server.wm.ActivityTaskManagerInternal;
import com.android.server.wm.WindowManagerInternal;

/* JADX INFO: loaded from: classes3.dex */
class Vr2dDisplay {
    private static final boolean DEBUG = false;
    private static final String DEBUG_ACTION_SET_MODE = "com.android.server.vr.Vr2dDisplay.SET_MODE";
    private static final String DEBUG_ACTION_SET_SURFACE = "com.android.server.vr.Vr2dDisplay.SET_SURFACE";
    private static final String DEBUG_EXTRA_MODE_ON = "com.android.server.vr.Vr2dDisplay.EXTRA_MODE_ON";
    private static final String DEBUG_EXTRA_SURFACE = "com.android.server.vr.Vr2dDisplay.EXTRA_SURFACE";
    public static final int DEFAULT_VIRTUAL_DISPLAY_DPI = 320;
    public static final int DEFAULT_VIRTUAL_DISPLAY_HEIGHT = 1800;
    public static final int DEFAULT_VIRTUAL_DISPLAY_WIDTH = 1400;
    private static final String DISPLAY_NAME = "VR 2D Display";
    public static final int MIN_VR_DISPLAY_DPI = 1;
    public static final int MIN_VR_DISPLAY_HEIGHT = 1;
    public static final int MIN_VR_DISPLAY_WIDTH = 1;
    private static final int STOP_VIRTUAL_DISPLAY_DELAY_MILLIS = 2000;
    private static final String TAG = "Vr2dDisplay";
    private static final String UNIQUE_DISPLAY_ID = "277f1a09-b88d-4d1e-8716-796f114d080b";
    private final ActivityManagerInternal mActivityManagerInternal;
    private boolean mBootsToVr;
    private final DisplayManager mDisplayManager;
    private final Handler mHandler;
    private ImageReader mImageReader;
    private boolean mIsPersistentVrModeEnabled;
    private boolean mIsVirtualDisplayAllowed;
    private boolean mIsVrModeOverrideEnabled;
    private Runnable mStopVDRunnable;
    private Surface mSurface;
    private final Object mVdLock;
    private VirtualDisplay mVirtualDisplay;
    private int mVirtualDisplayDpi;
    private int mVirtualDisplayHeight;
    private int mVirtualDisplayWidth;
    private final IVrManager mVrManager;
    private final IPersistentVrStateCallbacks mVrStateCallbacks;
    private final WindowManagerInternal mWindowManagerInternal;

    /* JADX INFO: renamed from: -$$Nest$fgetmIsPersistentVrModeEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9450$$Nest$fgetmIsPersistentVrModeEnabled(Vr2dDisplay r0) {
        return r0.mIsPersistentVrModeEnabled;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVdLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m9451$$Nest$fgetmVdLock(Vr2dDisplay r0) {
        return r0.mVdLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVirtualDisplay, reason: not valid java name */
    static /* bridge */ /* synthetic */ VirtualDisplay m9452$$Nest$fgetmVirtualDisplay(Vr2dDisplay r0) {
        return r0.mVirtualDisplay;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsPersistentVrModeEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9453$$Nest$fputmIsPersistentVrModeEnabled(Vr2dDisplay r0, boolean r1) {
        r0.mIsPersistentVrModeEnabled = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmVirtualDisplay, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9454$$Nest$fputmVirtualDisplay(Vr2dDisplay r0, VirtualDisplay r1) {
        r0.mVirtualDisplay = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$msetSurfaceLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9455$$Nest$msetSurfaceLocked(Vr2dDisplay r0, Surface r1) {
        r0.setSurfaceLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mshouldRunVirtualDisplay, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9456$$Nest$mshouldRunVirtualDisplay(Vr2dDisplay r0) {
        return r0.shouldRunVirtualDisplay();
    }

    /* JADX INFO: renamed from: -$$Nest$mstopImageReader, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9457$$Nest$mstopImageReader(Vr2dDisplay r0) {
        r0.stopImageReader();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateDisplayId, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9458$$Nest$mupdateDisplayId(Vr2dDisplay r0, int r1) {
        r0.updateDisplayId(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateVirtualDisplay, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9459$$Nest$mupdateVirtualDisplay(Vr2dDisplay r0) {
        r0.updateVirtualDisplay();
    }

    public Vr2dDisplay(DisplayManager displayManager, ActivityManagerInternal activityManagerInternal, WindowManagerInternal windowManagerInternal, IVrManager vrManager) {
        this.mVdLock = new Object();
        this.mHandler = new Handler();
        this.mVrStateCallbacks = new AnonymousClass1(this);
        this.mIsVirtualDisplayAllowed = true;
        this.mBootsToVr = false;
        this.mDisplayManager = displayManager;
        this.mActivityManagerInternal = activityManagerInternal;
        this.mWindowManagerInternal = windowManagerInternal;
        this.mVrManager = vrManager;
        this.mVirtualDisplayWidth = DEFAULT_VIRTUAL_DISPLAY_WIDTH;
        this.mVirtualDisplayHeight = 1800;
        this.mVirtualDisplayDpi = 320;
    }

    public void init(Context context, boolean bootsToVr) {
        startVrModeListener();
        startDebugOnlyBroadcastReceiver(context);
        this.mBootsToVr = bootsToVr;
        if (this.mBootsToVr == false) goto L6;
        updateVirtualDisplay();
        return;
    }

    private void updateVirtualDisplay() {
        if (shouldRunVirtualDisplay() == false) goto L5;
        Log.i(TAG, "Attempting to start virtual display");
        startVirtualDisplay();
        return;
    L5:
        stopVirtualDisplay();
    }

    private void startDebugOnlyBroadcastReceiver(Context context) {
    }

    private void startVrModeListener() {
        if (this.mVrManager == null) goto L11;
        this.mVrManager.registerPersistentVrStateListener(this.mVrStateCallbacks);     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        Log.e(TAG, "Could not register VR State listener.", e);
        return;
    }

    public void setVirtualDisplayProperties(Vr2dDisplayProperties displayProperties) {
        Object r0 = this.mVdLock;
        monitor-enter(r0);
        int width = displayProperties.getWidth();     // Catch: Throwable -> L10
        int height = displayProperties.getHeight();     // Catch: Throwable -> L10
        int dpi = displayProperties.getDpi();     // Catch: Throwable -> L10
        boolean resized = false;
        if (width < 1) goto L12;
        if (height < 1) goto L12;
        if (dpi < 1) goto L12;
        Log.i(TAG, "Setting width/height/dpi to " + width + "," + height + "," + dpi);     // Catch: Throwable -> L10
        this.mVirtualDisplayWidth = width;     // Catch: Throwable -> L10
        this.mVirtualDisplayHeight = height;     // Catch: Throwable -> L10
        this.mVirtualDisplayDpi = dpi;     // Catch: Throwable -> L10
        resized = true;
    L14:
        if ((displayProperties.getAddedFlags() & 1) != 1) goto L17;
        this.mIsVirtualDisplayAllowed = true;     // Catch: Throwable -> L10
    L20:
        if (this.mVirtualDisplay == null) goto L25;
        if (resized == false) goto L25;
        if (this.mIsVirtualDisplayAllowed == false) goto L25;
        this.mVirtualDisplay.resize(this.mVirtualDisplayWidth, this.mVirtualDisplayHeight, this.mVirtualDisplayDpi);     // Catch: Throwable -> L10
        ImageReader oldImageReader = this.mImageReader;     // Catch: Throwable -> L10
        this.mImageReader = null;     // Catch: Throwable -> L10
        startImageReader();     // Catch: Throwable -> L10
        oldImageReader.close();     // Catch: Throwable -> L10
    L25:
        updateVirtualDisplay();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L17:
        if ((displayProperties.getRemovedFlags() & 1) != 1) goto L20;
        this.mIsVirtualDisplayAllowed = false;     // Catch: Throwable -> L10
    L12:
        Log.i(TAG, "Ignoring Width/Height/Dpi values of " + width + "," + height + "," + dpi);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public int getVirtualDisplayId() {
        Object r0 = this.mVdLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mVirtualDisplay == null) goto L11;
        int virtualDisplayId = this.mVirtualDisplay.getDisplay().getDisplayId();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return virtualDisplayId;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return -1;
    }

    private void startVirtualDisplay() {
        if (this.mDisplayManager != null) goto L6;
        Log.w(TAG, "Cannot create virtual display because mDisplayManager == null");
        return;
    L6:
        Object r0 = this.mVdLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (this.mVirtualDisplay == null) goto L15;
        Log.i(TAG, "VD already exists, ignoring request");     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L15:
        int flags = 64 | 128;     // Catch: Throwable -> L13
        VirtualDisplayConfig.Builder builder = new VirtualDisplayConfig.Builder(DISPLAY_NAME, this.mVirtualDisplayWidth, this.mVirtualDisplayHeight, this.mVirtualDisplayDpi);     // Catch: Throwable -> L13
        builder.setUniqueId(UNIQUE_DISPLAY_ID);     // Catch: Throwable -> L13
        builder.setFlags(((((flags | 1) | 8) | 256) | 4) | 1024);     // Catch: Throwable -> L13
        this.mVirtualDisplay = this.mDisplayManager.createVirtualDisplay(null, builder.build(), null, null);     // Catch: Throwable -> L13
        if (this.mVirtualDisplay == null) goto L21;
        updateDisplayId(this.mVirtualDisplay.getDisplay().getDisplayId());     // Catch: Throwable -> L13
        startImageReader();     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        Log.i(TAG, "VD created: " + this.mVirtualDisplay);
        return;
    L21:
        Log.w(TAG, "Virtual display id is null after createVirtualDisplay");     // Catch: Throwable -> L13
        updateDisplayId(-1);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
    }

    private void updateDisplayId(int displayId) {
        ((ActivityTaskManagerInternal) LocalServices.getService(ActivityTaskManagerInternal.class)).setVr2dDisplayId(displayId);
        this.mWindowManagerInternal.setVr2dDisplayId(displayId);
    }

    private void stopVirtualDisplay() {
        if (this.mStopVDRunnable != null) goto L5;
        this.mStopVDRunnable = new AnonymousClass3(this);
    L5:
        this.mHandler.removeCallbacks(this.mStopVDRunnable);
        this.mHandler.postDelayed(this.mStopVDRunnable, ISmtResourceControl.LAUNCH_CPUSET_EFFECTIVE_TIME);
    }

    private void setSurfaceLocked(Surface surface) {
        if (this.mSurface == surface) goto L15;
        if (surface != null) goto L6;
    L7:
        Log.i(TAG, "Setting the new surface from " + this.mSurface + " to " + surface);
        if (this.mVirtualDisplay == null) goto L11;
        this.mVirtualDisplay.setSurface(surface);
    L11:
        if (this.mSurface == null) goto L13;
        this.mSurface.release();
    L13:
        this.mSurface = surface;
        return;
    L6:
        if (surface.isValid() == true) goto L7;
        return;
    }

    private void startImageReader() {
        if (this.mImageReader != null) goto L5;
        this.mImageReader = ImageReader.newInstance(this.mVirtualDisplayWidth, this.mVirtualDisplayHeight, 1, 2);
        Log.i(TAG, "VD startImageReader: res = " + this.mVirtualDisplayWidth + "X" + this.mVirtualDisplayHeight + ", dpi = " + this.mVirtualDisplayDpi);
    L5:
        Object r0 = this.mVdLock;
        monitor-enter(r0);
        setSurfaceLocked(this.mImageReader.getSurface());     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void stopImageReader() {
        if (this.mImageReader == null) goto L6;
        this.mImageReader.close();
        this.mImageReader = null;
        return;
    }

    private boolean shouldRunVirtualDisplay() {
        if (this.mIsVirtualDisplayAllowed == true) goto L5;
    L11:
        return false;
    L5:
        if (this.mBootsToVr == false) goto L7;
    L10:
        return true;
    L7:
        if (this.mIsPersistentVrModeEnabled == true) goto L10;
        if (this.mIsVrModeOverrideEnabled == false) goto L11;
        goto L10
    }
}
