package com.android.server.wm;

import android.graphics.Region;
import android.os.IBinder;
import android.view.InputApplicationHandle;
import android.view.InputWindowHandle;
import android.view.SurfaceControl;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
class InputWindowHandleWrapper {
    private boolean mChanged;
    public final InputWindowHandle mHandle;

    InputWindowHandleWrapper(InputWindowHandle handle) {
        this.mChanged = true;
        this.mHandle = handle;
    }

    boolean isChanged() {
        return this.mChanged;
    }

    void forceChange() {
        this.mChanged = true;
    }

    void applyChangesToSurface(SurfaceControl.Transaction t, SurfaceControl sc) {
        t.setInputWindowInfo(sc, this.mHandle);
        this.mChanged = false;
    }

    int getDisplayId() {
        return this.mHandle.displayId;
    }

    boolean isFocusable() {
        if ((this.mHandle.inputConfig & 4) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isPaused() {
        if ((this.mHandle.inputConfig & 128) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isTrustedOverlay() {
        if ((this.mHandle.inputConfig & 256) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean hasWallpaper() {
        if ((this.mHandle.inputConfig & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    InputApplicationHandle getInputApplicationHandle() {
        return this.mHandle.inputApplicationHandle;
    }

    void setInputApplicationHandle(InputApplicationHandle handle) {
        if (this.mHandle.inputApplicationHandle != handle) goto L5;
        return;
    L5:
        this.mHandle.inputApplicationHandle = handle;
        this.mChanged = true;
    }

    void setToken(IBinder token) {
        if (this.mHandle.token != token) goto L5;
        return;
    L5:
        this.mHandle.token = token;
        this.mChanged = true;
    }

    void setName(String name) {
        if (Objects.equals(this.mHandle.name, name) == false) goto L5;
        return;
    L5:
        this.mHandle.name = name;
        this.mChanged = true;
    }

    void setLayoutParamsFlags(int flags) {
        if (this.mHandle.layoutParamsFlags != flags) goto L5;
        return;
    L5:
        this.mHandle.layoutParamsFlags = flags;
        this.mChanged = true;
    }

    void setLayoutParamsType(int type) {
        if (this.mHandle.layoutParamsType != type) goto L5;
        return;
    L5:
        this.mHandle.layoutParamsType = type;
        this.mChanged = true;
    }

    void setDispatchingTimeoutMillis(long timeout) {
        if (this.mHandle.dispatchingTimeoutMillis != timeout) goto L5;
        return;
    L5:
        this.mHandle.dispatchingTimeoutMillis = timeout;
        this.mChanged = true;
    }

    void setTouchableRegion(Region region) {
        if (this.mHandle.touchableRegion.equals(region) == false) goto L5;
        return;
    L5:
        this.mHandle.touchableRegion.set(region);
        this.mChanged = true;
    }

    void clearTouchableRegion() {
        if (this.mHandle.touchableRegion.isEmpty() == false) goto L5;
        return;
    L5:
        this.mHandle.touchableRegion.setEmpty();
        this.mChanged = true;
    }

    void setFocusable(boolean focusable) {
        if (isFocusable() != focusable) goto L5;
        return;
    L5:
        this.mHandle.setInputConfig(4, !focusable);
        this.mChanged = true;
    }

    void setTouchOcclusionMode(int mode) {
        if (this.mHandle.touchOcclusionMode != mode) goto L5;
        return;
    L5:
        this.mHandle.touchOcclusionMode = mode;
        this.mChanged = true;
    }

    void setHasWallpaper(boolean hasWallpaper) {
        if (hasWallpaper() != hasWallpaper) goto L5;
        return;
    L5:
        this.mHandle.setInputConfig(32, hasWallpaper);
        this.mChanged = true;
    }

    void setPaused(boolean paused) {
        if (isPaused() != paused) goto L5;
        return;
    L5:
        this.mHandle.setInputConfig(128, paused);
        this.mChanged = true;
    }

    void setTrustedOverlay(boolean trustedOverlay) {
        if (isTrustedOverlay() != trustedOverlay) goto L5;
        return;
    L5:
        this.mHandle.setInputConfig(256, trustedOverlay);
        this.mChanged = true;
    }

    void setTrustedOverlay(SurfaceControl.Transaction t, SurfaceControl sc, boolean trustedOverlay) {
        this.mHandle.setTrustedOverlay(t, sc, trustedOverlay);
    }

    void setOwnerPid(int pid) {
        if (this.mHandle.ownerPid != pid) goto L5;
        return;
    L5:
        this.mHandle.ownerPid = pid;
        this.mChanged = true;
    }

    void setOwnerUid(int uid) {
        if (this.mHandle.ownerUid != uid) goto L5;
        return;
    L5:
        this.mHandle.ownerUid = uid;
        this.mChanged = true;
    }

    void setPackageName(String packageName) {
        if (Objects.equals(this.mHandle.packageName, packageName) == false) goto L5;
        return;
    L5:
        this.mHandle.packageName = packageName;
        this.mChanged = true;
    }

    void setReverseDropCacheLevel(int level) {
        if (this.mHandle.reverseDropCacheLevel != level) goto L5;
        return;
    L5:
        this.mHandle.reverseDropCacheLevel = level;
        this.mChanged = true;
    }

    void setGameApp(boolean isGameApp) {
        if (this.mHandle.isGameApp != isGameApp) goto L5;
        return;
    L5:
        this.mHandle.isGameApp = isGameApp;
        this.mChanged = true;
    }

    void setDisplayId(int displayId) {
        if (this.mHandle.displayId != displayId) goto L5;
        return;
    L5:
        this.mHandle.displayId = displayId;
        this.mChanged = true;
    }

    void setSurfaceInset(int inset) {
        if (this.mHandle.surfaceInset != inset) goto L5;
        return;
    L5:
        this.mHandle.surfaceInset = inset;
        this.mChanged = true;
    }

    void setScaleFactor(float scale) {
        if (this.mHandle.scaleFactor != scale) goto L5;
        return;
    L5:
        this.mHandle.scaleFactor = scale;
        this.mChanged = true;
    }

    void setTouchableRegionCrop(SurfaceControl bounds) {
        if (this.mHandle.touchableRegionSurfaceControl.get() != bounds) goto L5;
        return;
    L5:
        this.mHandle.setTouchableRegionCrop(bounds);
        this.mChanged = true;
    }

    void setReplaceTouchableRegionWithCrop(boolean replace) {
        if (this.mHandle.replaceTouchableRegionWithCrop != replace) goto L5;
        return;
    L5:
        this.mHandle.replaceTouchableRegionWithCrop = replace;
        this.mChanged = true;
    }

    void setWindowToken(IBinder windowToken) {
        if (this.mHandle.getWindowToken() != windowToken) goto L5;
        return;
    L5:
        this.mHandle.setWindowToken(windowToken);
        this.mChanged = true;
    }

    void setInputConfigMasked(int inputConfig, int mask) {
        int inputConfigMasked = inputConfig & mask;
        if (inputConfigMasked != (this.mHandle.inputConfig & mask)) goto L5;
        return;
    L5:
        this.mHandle.inputConfig &= ~mask;
        this.mHandle.inputConfig |= inputConfigMasked;
        this.mChanged = true;
    }

    void setFocusTransferTarget(IBinder toToken) {
        if (this.mHandle.focusTransferTarget != toToken) goto L5;
        return;
    L5:
        this.mHandle.focusTransferTarget = toToken;
        this.mChanged = true;
    }

    public String toString() {
        return this.mHandle + ", changed=" + this.mChanged;
    }
}
