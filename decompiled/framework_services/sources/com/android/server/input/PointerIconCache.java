package com.android.server.input;

import android.content.Context;
import android.content.res.Resources;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseDoubleArray;
import android.util.SparseIntArray;
import android.view.ContextThemeWrapper;
import android.view.Display;
import android.view.DisplayInfo;
import android.view.PointerIcon;
import com.android.server.UiThread;

/* JADX INFO: loaded from: classes2.dex */
final class PointerIconCache {
    private static final String TAG = null;
    private final SparseDoubleArray mAccessibilityScaleFactorPerDisplay;
    private final Context mContext;
    private final SparseArray<Context> mDisplayContexts;
    private final SparseIntArray mDisplayDensities;
    private final DisplayManager.DisplayListener mDisplayListener;
    private final SparseArray<SparseArray<PointerIcon>> mLoadedPointerIconsByDisplayAndType;
    private final NativeInputManagerService mNative;
    private int mPointerIconFillStyle;
    private float mPointerIconScale;
    private int mPointerIconStrokeStyle;
    private final Handler mUiThreadHandler;
    private boolean mUseLargePointerIcons;

    /* JADX INFO: renamed from: $r8$lambda$2YggVB1gczKFYVmfopZRS-vDzlE, reason: not valid java name */
    public static /* synthetic */ void m4595$r8$lambda$2YggVB1gczKFYVmfopZRSvDzlE(PointerIconCache r0, int r1, float r2) {
        r0.lambda$setAccessibilityScaleFactor$4(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$7dN69jtffxl50qDVew3T2LrxdDs(PointerIconCache r0, float r1) {
        r0.lambda$setPointerScale$3(r1);
    }

    public static /* synthetic */ void $r8$lambda$DPcCnkkmK1pCTBxywm2Yo23R20Q(PointerIconCache r0, boolean r1) {
        r0.lambda$setUseLargePointerIcons$0(r1);
    }

    public static /* synthetic */ void $r8$lambda$Y3IzVQEd4YNHZUe4PF8CewYw1h8(PointerIconCache r0, int r1) {
        r0.lambda$setPointerFillStyle$1(r1);
    }

    public static /* synthetic */ void $r8$lambda$j9J3glSzYprX7nOwuvy5tXVUMS8(PointerIconCache r0, int r1) {
        r0.lambda$setPointerStrokeStyle$2(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAccessibilityScaleFactorPerDisplay, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseDoubleArray m4596$$Nest$fgetmAccessibilityScaleFactorPerDisplay(PointerIconCache r0) {
        return r0.mAccessibilityScaleFactorPerDisplay;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDisplayContexts, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m4597$$Nest$fgetmDisplayContexts(PointerIconCache r0) {
        return r0.mDisplayContexts;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDisplayDensities, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseIntArray m4598$$Nest$fgetmDisplayDensities(PointerIconCache r0) {
        return r0.mDisplayDensities;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLoadedPointerIconsByDisplayAndType, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m4599$$Nest$fgetmLoadedPointerIconsByDisplayAndType(PointerIconCache r0) {
        return r0.mLoadedPointerIconsByDisplayAndType;
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleDisplayChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4600$$Nest$mhandleDisplayChanged(PointerIconCache r0, int r1) {
        r0.handleDisplayChanged(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateDisplayDensityLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4601$$Nest$mupdateDisplayDensityLocked(PointerIconCache r0, int r1) {
        return r0.updateDisplayDensityLocked(r1);
    }

    static {
        TAG = PointerIconCache.class.getSimpleName();
    }

    PointerIconCache(Context context, NativeInputManagerService nativeService) {
        this(context, nativeService, UiThread.getHandler());
    }

    PointerIconCache(Context context, NativeInputManagerService nativeService, Handler handler) {
        this.mLoadedPointerIconsByDisplayAndType = new SparseArray();
        this.mUseLargePointerIcons = false;
        this.mDisplayContexts = new SparseArray();
        this.mDisplayDensities = new SparseIntArray();
        this.mPointerIconFillStyle = 0;
        this.mPointerIconStrokeStyle = 0;
        this.mPointerIconScale = 1.0f;
        this.mAccessibilityScaleFactorPerDisplay = new SparseDoubleArray();
        this.mDisplayListener = new AnonymousClass1(this);
        this.mContext = context;
        this.mNative = nativeService;
        this.mUiThreadHandler = handler;
    }

    public void systemRunning() {
        DisplayManager displayManager = (DisplayManager) this.mContext.getSystemService(DisplayManager.class);
        displayManager.getClass();
        displayManager.registerDisplayListener(this.mDisplayListener, this.mUiThreadHandler);
        Display[] displays = displayManager.getDisplays();
        int i = 0;
    L4:
        if (i >= displays.length) goto L7;
        this.mDisplayListener.onDisplayAdded(displays[i].getDisplayId());
        i = i + 1;
        goto L4
    }

    public void monitor() {
        SparseArray<SparseArray<PointerIcon>> r0 = this.mLoadedPointerIconsByDisplayAndType;
        monitor-enter(r0);
        monitor-exit(r0);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$setUseLargePointerIcons$0(boolean useLargeIcons) {
        handleSetUseLargePointerIcons(useLargeIcons);
    }

    public void setUseLargePointerIcons(final boolean useLargeIcons) {
        this.mUiThreadHandler.post(new PointerIconCache$$ExternalSyntheticLambda4(this, useLargeIcons));
    }

    private /* synthetic */ void lambda$setPointerFillStyle$1(int fillStyle) {
        handleSetPointerFillStyle(fillStyle);
    }

    public void setPointerFillStyle(final int fillStyle) {
        this.mUiThreadHandler.post(new PointerIconCache$$ExternalSyntheticLambda0(this, fillStyle));
    }

    private /* synthetic */ void lambda$setPointerStrokeStyle$2(int strokeStyle) {
        handleSetPointerStrokeStyle(strokeStyle);
    }

    public void setPointerStrokeStyle(final int strokeStyle) {
        this.mUiThreadHandler.post(new PointerIconCache$$ExternalSyntheticLambda3(this, strokeStyle));
    }

    private /* synthetic */ void lambda$setPointerScale$3(float scale) {
        handleSetPointerScale(scale);
    }

    public void setPointerScale(final float scale) {
        this.mUiThreadHandler.post(new PointerIconCache$$ExternalSyntheticLambda2(this, scale));
    }

    private /* synthetic */ void lambda$setAccessibilityScaleFactor$4(int displayId, float scaleFactor) {
        handleAccessibilityScaleFactor(displayId, scaleFactor);
    }

    public void setAccessibilityScaleFactor(final int displayId, final float scaleFactor) {
        this.mUiThreadHandler.post(new PointerIconCache$$ExternalSyntheticLambda1(this, displayId, scaleFactor));
    }

    public PointerIcon getLoadedPointerIcon(int displayId, int type) {
        SparseArray<SparseArray<PointerIcon>> r0 = this.mLoadedPointerIconsByDisplayAndType;
        monitor-enter(r0);
        SparseArray<PointerIcon> iconsByType = this.mLoadedPointerIconsByDisplayAndType.get(displayId);     // Catch: Throwable -> L7
        if (iconsByType != null) goto L9;
        iconsByType = new SparseArray();     // Catch: Throwable -> L7
        this.mLoadedPointerIconsByDisplayAndType.put(displayId, iconsByType);     // Catch: Throwable -> L7
    L9:
        PointerIcon icon = iconsByType.get(type);     // Catch: Throwable -> L7
        if (icon != null) goto L12;
        Context context = getContextForDisplayLocked(displayId);     // Catch: Throwable -> L7
        Resources.Theme theme = context.getResources().newTheme();     // Catch: Throwable -> L7
        theme.setTo(context.getTheme());     // Catch: Throwable -> L7
        theme.applyStyle(PointerIcon.vectorFillStyleToResource(this.mPointerIconFillStyle), true);     // Catch: Throwable -> L7
        theme.applyStyle(PointerIcon.vectorStrokeStyleToResource(this.mPointerIconStrokeStyle), true);     // Catch: Throwable -> L7
        float scale = this.mPointerIconScale * ((float) this.mAccessibilityScaleFactorPerDisplay.get(displayId, 1.0d));     // Catch: Throwable -> L7
        icon = PointerIcon.getLoadedSystemIcon(new ContextThemeWrapper(context, theme), type, this.mUseLargePointerIcons, scale);     // Catch: Throwable -> L7
        iconsByType.put(type, icon);     // Catch: Throwable -> L7
    L12:
        icon.getClass();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return icon;
    L7:
        th = move-exception;
        throw th;
    }

    private Context getContextForDisplayLocked(int displayId) {
        if (displayId != (-1)) goto L7;
        return this.mContext;
    L7:
        if (displayId == this.mContext.getDisplay().getDisplayId()) goto L9;
        Context displayContext = this.mDisplayContexts.get(displayId);
        if (displayContext != null) goto L18;
        DisplayManager displayManager = (DisplayManager) this.mContext.getSystemService(DisplayManager.class);
        displayManager.getClass();
        Display display = displayManager.getDisplay(displayId);
        if (display == null) goto L15;
        Context displayContext2 = this.mContext.createDisplayContext(display);
        this.mDisplayContexts.put(displayId, displayContext2);
        return displayContext2;
    L15:
        return this.mContext;
    L18:
        return displayContext;
    L9:
        return this.mContext;
    }

    private void handleDisplayChanged(int displayId) {
        SparseArray<SparseArray<PointerIcon>> r0 = this.mLoadedPointerIconsByDisplayAndType;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (updateDisplayDensityLocked(displayId) == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        Slog.i(TAG, "Reloading pointer icons due to density change on display: " + displayId);     // Catch: Throwable -> L8
        SparseArray<PointerIcon> iconsByType = this.mLoadedPointerIconsByDisplayAndType.get(displayId);     // Catch: Throwable -> L8
        if (iconsByType != null) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L14:
        iconsByType.clear();     // Catch: Throwable -> L8
        this.mDisplayContexts.remove(displayId);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mNative.reloadPointerIcons();
    }

    private void handleSetUseLargePointerIcons(boolean useLargeIcons) {
        SparseArray<SparseArray<PointerIcon>> r0 = this.mLoadedPointerIconsByDisplayAndType;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mUseLargePointerIcons != useLargeIcons) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mUseLargePointerIcons = useLargeIcons;     // Catch: Throwable -> L8
        this.mLoadedPointerIconsByDisplayAndType.clear();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mNative.reloadPointerIcons();
    }

    private void handleSetPointerFillStyle(int fillStyle) {
        SparseArray<SparseArray<PointerIcon>> r0 = this.mLoadedPointerIconsByDisplayAndType;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mPointerIconFillStyle != fillStyle) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mPointerIconFillStyle = fillStyle;     // Catch: Throwable -> L8
        this.mLoadedPointerIconsByDisplayAndType.clear();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mNative.reloadPointerIcons();
    }

    private void handleSetPointerStrokeStyle(int strokeStyle) {
        SparseArray<SparseArray<PointerIcon>> r0 = this.mLoadedPointerIconsByDisplayAndType;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mPointerIconStrokeStyle != strokeStyle) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mPointerIconStrokeStyle = strokeStyle;     // Catch: Throwable -> L8
        this.mLoadedPointerIconsByDisplayAndType.clear();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mNative.reloadPointerIcons();
    }

    private void handleSetPointerScale(float scale) {
        SparseArray<SparseArray<PointerIcon>> r0 = this.mLoadedPointerIconsByDisplayAndType;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mPointerIconScale != scale) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mPointerIconScale = scale;     // Catch: Throwable -> L8
        this.mLoadedPointerIconsByDisplayAndType.clear();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mNative.reloadPointerIcons();
    }

    private void handleAccessibilityScaleFactor(int displayId, float scale) {
        SparseArray<SparseArray<PointerIcon>> r0 = this.mLoadedPointerIconsByDisplayAndType;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mAccessibilityScaleFactorPerDisplay.get(displayId, 1.0d) != scale) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mAccessibilityScaleFactorPerDisplay.put(displayId, scale);     // Catch: Throwable -> L8
        this.mLoadedPointerIconsByDisplayAndType.remove(displayId);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mNative.reloadPointerIcons();
    }

    private boolean updateDisplayDensityLocked(int displayId) {
        DisplayManager displayManager = (DisplayManager) this.mContext.getSystemService(DisplayManager.class);
        displayManager.getClass();
        Display display = displayManager.getDisplay(displayId);
        if (display != null) goto L5;
        return false;
    L5:
        DisplayInfo info = new DisplayInfo();
        display.getDisplayInfo(info);
        int oldDensity = this.mDisplayDensities.get(displayId, 0);
        if (oldDensity != info.logicalDensityDpi) goto L8;
        return false;
    L8:
        this.mDisplayDensities.put(displayId, info.logicalDensityDpi);
        return true;
    }
}
