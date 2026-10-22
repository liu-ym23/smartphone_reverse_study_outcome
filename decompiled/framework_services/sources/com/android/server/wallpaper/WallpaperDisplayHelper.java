package com.android.server.wallpaper;

import android.app.WallpaperManager;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.display.DisplayManager;
import android.os.Binder;
import android.os.Debug;
import android.util.Slog;
import android.util.SparseArray;
import android.view.Display;
import android.view.DisplayInfo;
import android.view.WindowManager;
import com.android.server.wm.WindowManagerInternal;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes3.dex */
class WallpaperDisplayHelper {
    private static final String TAG = null;
    private final WallpaperDefaultDisplayInfo mDefaultDisplayInfo;
    private final SparseArray<DisplayData> mDisplayDatas;
    private final DisplayManager mDisplayManager;
    private final WindowManagerInternal mWindowManagerInternal;

    static final class DisplayData {
        final int mDisplayId;
        int mHeight;
        final Rect mPadding;
        int mWidth;

        DisplayData(int displayId) {
            this.mWidth = -1;
            this.mHeight = -1;
            this.mPadding = new Rect(0, 0, 0, 0);
            this.mDisplayId = displayId;
        }
    }

    static {
        TAG = WallpaperDisplayHelper.class.getSimpleName();
    }

    WallpaperDisplayHelper(DisplayManager displayManager, WindowManager windowManager, WindowManagerInternal windowManagerInternal, Resources resources) {
        this.mDisplayDatas = new SparseArray();
        this.mDisplayManager = displayManager;
        this.mWindowManagerInternal = windowManagerInternal;
        this.mDefaultDisplayInfo = new WallpaperDefaultDisplayInfo(windowManager, resources);
    }

    DisplayData getDisplayDataOrCreate(int displayId) {
        DisplayData wpdData = this.mDisplayDatas.get(displayId);
        if (wpdData != null) goto L6;
        DisplayData wpdData2 = new DisplayData(displayId);
        ensureSaneWallpaperDisplaySize(wpdData2, displayId);
        this.mDisplayDatas.append(displayId, wpdData2);
        return wpdData2;
    L6:
        return wpdData;
    }

    int getDefaultDisplayCurrentOrientation() {
        Point displaySize = new Point();
        this.mDisplayManager.getDisplay(0).getSize(displaySize);
        return WallpaperManager.getOrientation(displaySize);
    }

    void removeDisplayData(int displayId) {
        this.mDisplayDatas.remove(displayId);
    }

    void ensureSaneWallpaperDisplaySize(DisplayData wpdData, int displayId) {
        int baseSize = getMaximumSizeDimension(displayId);
        if (wpdData.mWidth >= baseSize) goto L6;
        wpdData.mWidth = baseSize;
    L6:
        if (wpdData.mHeight >= baseSize) goto L9;
        wpdData.mHeight = baseSize;
        return;
    }

    int getMaximumSizeDimension(int displayId) {
        Display display = this.mDisplayManager.getDisplay(displayId);
        if (display != null) goto L6;
        Slog.w(TAG, "Invalid displayId=" + displayId + " " + Debug.getCallers(4));
        display = this.mDisplayManager.getDisplay(0);
    L6:
        return display.getMaximumSizeDimension();
    }

    void forEachDisplayData(Consumer<DisplayData> action) {
        int i = this.mDisplayDatas.size() - 1;
    L3:
        if (i < 0) goto L6;
        DisplayData wpdData = this.mDisplayDatas.valueAt(i);
        action.accept(wpdData);
        i = i - 1;
        goto L3
    }

    Display[] getDisplays() {
        return this.mDisplayManager.getDisplays();
    }

    DisplayInfo getDisplayInfo(int displayId) {
        DisplayInfo displayInfo = new DisplayInfo();
        this.mDisplayManager.getDisplay(displayId).getDisplayInfo(displayInfo);
        return displayInfo;
    }

    boolean isUsableDisplay(int displayId, int clientUid) {
        return isUsableDisplay(this.mDisplayManager.getDisplay(displayId), clientUid);
    }

    boolean isUsableDisplay(Display display, int clientUid) {
        if (display != null) goto L4;
        return false;
    L4:
        if (display.hasAccess(clientUid) == false) goto L21;
        int displayId = display.getDisplayId();
        if (displayId != 0) goto L10;
        return true;
    L10:
        long ident = Binder.clearCallingIdentity();
        boolean r3 = this.mWindowManagerInternal.isHomeSupportedOnDisplay(displayId);     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(ident);
        return r3;
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L21:
        return false;
    }

    boolean isValidDisplay(int displayId) {
        if (this.mDisplayManager.getDisplay(displayId) == null) goto L5;
        return true;
    L5:
        return false;
    }

    SparseArray<Point> getDefaultDisplaySizes() {
        return this.mDefaultDisplayInfo.defaultDisplaySizes;
    }

    int getDefaultDisplayLargestDimension() {
        SparseArray<Point> defaultDisplaySizes = this.mDefaultDisplayInfo.defaultDisplaySizes;
        int result = -1;
        int i = 0;
    L4:
        if (i >= defaultDisplaySizes.size()) goto L7;
        Point size = defaultDisplaySizes.valueAt(i);
        result = Math.max(result, Math.max(size.x, size.y));
        i = i + 1;
        goto L4
    L7:
        return result;
    }

    public WallpaperDefaultDisplayInfo getDefaultDisplayInfo() {
        return this.mDefaultDisplayInfo;
    }
}
