package com.android.server.wm;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.SparseArray;
import android.view.WmTrace;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes3.dex */
class WallpaperWindowToken extends WindowToken {
    private static final String TAG = "WindowManager";
    private SparseArray<Rect> mCropHints;
    private boolean mLastSurfaceShowing;
    private boolean mShowWhenLocked;
    int mWallpaperDisplayOffsetX;
    int mWallpaperDisplayOffsetY;
    float mWallpaperX;
    float mWallpaperXStep;
    float mWallpaperY;
    float mWallpaperYStep;

    WallpaperWindowToken(WindowManagerService service, IBinder token, boolean explicit, DisplayContent dc, boolean ownerCanManageAppTokens) {
        this(service, token, explicit, dc, ownerCanManageAppTokens, null);
    }

    WallpaperWindowToken(WindowManagerService service, IBinder token, boolean explicit, DisplayContent dc, boolean ownerCanManageAppTokens, Bundle options) {
        super(service, token, 2013, explicit, dc, ownerCanManageAppTokens, false, false, options);
        this.mShowWhenLocked = false;
        this.mWallpaperX = -1.0f;
        this.mWallpaperY = -1.0f;
        this.mWallpaperXStep = -1.0f;
        this.mWallpaperYStep = -1.0f;
        this.mWallpaperDisplayOffsetX = Integer.MIN_VALUE;
        this.mWallpaperDisplayOffsetY = Integer.MIN_VALUE;
        this.mLastSurfaceShowing = false;
        this.mCropHints = new SparseArray();
        dc.mWallpaperController.addWallpaperToken(this);
        setWindowingMode(1);
    }

    @Override // com.android.server.wm.WindowContainer
    WallpaperWindowToken asWallpaperToken() {
        return this;
    }

    @Override // com.android.server.wm.WindowToken
    void setExiting(boolean animateExit) {
        super.setExiting(animateExit);
        this.mDisplayContent.mWallpaperController.removeWallpaperToken(this);
    }

    @Override // com.android.server.wm.WindowContainer
    public void prepareSurfaces() {
        super.prepareSurfaces();
        if (this.mWmService.mFlags.mEnsureWallpaperInTransitions == true) goto L5;
        return;
    L5:
        if (this.mTransitionController.isCollecting(this) == false) goto L7;
        return;
    L7:
        if (this.mTransitionController.isPlayingTarget(this) == false) goto L9;
        return;
    L9:
        if (isVisible() == this.mLastSurfaceShowing) goto L11;
        getPendingTransaction().startTrace("prepareSurfaces");
    L11:
        getPendingTransaction().setVisibility(this.mSurfaceControl, isVisible());
        getPendingTransaction().endTrace();
        this.mLastSurfaceShowing = isVisible();
    }

    void setShowWhenLocked(boolean showWhenLocked) {
        if (showWhenLocked != this.mShowWhenLocked) goto L5;
        return;
    L5:
        this.mShowWhenLocked = showWhenLocked;
        this.stringName = null;
        if (showWhenLocked == false) goto L8;
        int position = Integer.MIN_VALUE;
    L9:
        getParent().positionChildAt(position, this, false);
        this.mDisplayContent.mWallpaperController.onWallpaperTokenReordered();
        return;
    L8:
        position = Integer.MAX_VALUE;
        goto L9
    }

    boolean canShowWhenLocked() {
        return this.mShowWhenLocked;
    }

    void setCropHints(SparseArray<Rect> cropHints) {
        this.mCropHints = cropHints.clone();
    }

    SparseArray<Rect> getCropHints() {
        return this.mCropHints;
    }

    void sendWindowWallpaperCommand(String action, int x, int y, int z, Bundle extras, boolean sync) {
        boolean sync2 = sync;
        int wallpaperNdx = this.mChildren.size() - 1;
    L3:
        if (wallpaperNdx < 0) goto L15;
        WindowState wallpaper = (WindowState) this.mChildren.get(wallpaperNdx);
        String action2 = action;
        int x2 = x;
        int y2 = y;
        int z2 = z;
        Bundle extras2 = extras;
        wallpaper.mClient.dispatchWallpaperCommand(action2, x2, y2, z2, extras2, sync2);     // Catch: RemoteException -> L9
        sync2 = false;
    L13:
        wallpaperNdx = wallpaperNdx - 1;
        action = action2;
        x = x2;
        y = y2;
        z = z2;
        extras = extras2;
    L12:
        action2 = action;
        x2 = x;
        y2 = y;
        z2 = z;
        extras2 = extras;
        goto L13
    }

    void updateWallpaperOffset(boolean sync) {
        WallpaperController wallpaperController = this.mDisplayContent.mWallpaperController;
        int wallpaperNdx = this.mChildren.size() - 1;
    L3:
        if (wallpaperNdx < 0) goto L15;
        WindowState wallpaper = (WindowState) this.mChildren.get(wallpaperNdx);
        if (sync == true) goto L7;
    L9:
        boolean r4 = false;
    L11:
        if (wallpaperController.updateWallpaperOffset(wallpaper, r4) == false) goto L13;
        sync = false;
    L13:
        wallpaperNdx = wallpaperNdx - 1;
        goto L3
    L7:
        if (this.mWmService.mFlags.mWallpaperOffsetAsync == true) goto L9;
        r4 = true;
        goto L11
    }

    void updateWallpaperWindows(boolean visible) {
        if (this.mVisibleRequested != visible) goto L5;
    L8:
        WindowState wallpaperTarget = this.mDisplayContent.mWallpaperController.getWallpaperTarget();
        if (visible == false) goto L19;
        if (wallpaperTarget == null) goto L19;
        if (wallpaperTarget.mActivityRecord == null) goto L16;
        if (wallpaperTarget.mActivityRecord.isVisibleRequested() == false) goto L19;
    L16:
        if (wallpaperTarget.mToken.hasFixedRotationTransform() == false) goto L19;
        linkFixedRotationTransform(wallpaperTarget.mToken);
    L19:
        if (this.mTransitionController.inTransition(this) == false) goto L21;
        return;
    L21:
        setVisible(visible);
        return;
    L5:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WALLPAPER_enabled[0] == false) goto L7;
        String protoLogParam0 = String.valueOf(this.token);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_WALLPAPER, -7936547457136708587L, 12, new Object[]{protoLogParam0, Boolean.valueOf(visible)});
    L7:
        setVisibility(visible);
        goto L8
    }

    private void setVisible(boolean visible) {
        boolean wasClientVisible = isClientVisible();
        setClientVisible(visible);
        if (visible == false) goto L17;
        if (wasClientVisible == true) goto L18;
        int i = this.mChildren.size() - 1;
    L6:
        if (i < 0) goto L9;
        WindowState wallpaper = (WindowState) this.mChildren.get(i);
        wallpaper.requestUpdateWallpaperIfNeeded();
        i = i - 1;
        goto L6
    L9:
        if (WmTrace.isEnable() == false) goto L19;
        StringBuilder sb = WmTrace.getLocalStringBuilder();
        sb.setLength(0);
        sb.append("Wallpaper token ");
        sb.append(this.token);
        sb.append(" setVisible: ");
        if (visible == false) goto L13;
        String r2 = "true";
    L14:
        sb.append(r2);
        WmTrace.traceInfo(16, System.currentTimeMillis(), sb.toString());
        return;
    L13:
        r2 = "false";
        goto L14
    L19:
        return;
    L18:
        return;
    }

    void setVisibility(boolean visible) {
        if (this.mVisibleRequested == visible) goto L32;
        WindowState wpTarget = this.mDisplayContent.mWallpaperController.getWallpaperTarget();
        boolean r1 = true;
        if (wpTarget != null) goto L7;
    L12:
        boolean isTargetNotCollectedActivity = true;
    L13:
        Transition collecting = this.mTransitionController.getCollectingTransition();
        if (isTargetNotCollectedActivity == false) goto L16;
        if (visible == true) goto L16;
    L20:
        boolean shouldCollect = false;
    L22:
        if (shouldCollect == true) goto L29;
        if (collecting != null) goto L25;
    L27:
        r1 = false;
    L28:
        shouldCollect = r1;
        goto L29
    L25:
        if ((collecting.getFlags() & 2048) == 0) goto L27;
    L29:
        if (shouldCollect == false) goto L31;
        this.mTransitionController.collect(this);
    L31:
        setVisibleRequested(visible);
    L16:
        if (collecting == null) goto L20;
        if (collecting.getExt().isSyncFinished() == true) goto L20;
        shouldCollect = true;
        goto L22
    L7:
        if (wpTarget.mActivityRecord != null) goto L9;
    L11:
        isTargetNotCollectedActivity = false;
        goto L13
    L9:
        if (this.mTransitionController.isCollecting(wpTarget.mActivityRecord) == true) goto L11;
    L32:
        if (visible == false) goto L34;
    L36:
        commitVisibility(visible);
        return;
    L34:
        if (this.mTransitionController.inTransition() == false) goto L36;
    }

    void commitVisibility(boolean visible) {
        if (visible != isVisible()) goto L6;
        return;
    L6:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_APP_TRANSITIONS_enabled[1] == false) goto L8;
        String protoLogParam0 = String.valueOf(this);
        boolean protoLogParam1 = isVisible();
        boolean protoLogParam2 = this.mVisibleRequested;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_APP_TRANSITIONS, 7214407534407465113L, 60, new Object[]{protoLogParam0, Boolean.valueOf(protoLogParam1), Boolean.valueOf(protoLogParam2)});
    L8:
        setVisibleRequested(visible);
        setVisible(visible);
    }

    boolean hasVisibleNotDrawnWallpaper() {
        if (isVisible() == true) goto L5;
        return false;
    L5:
        int j = this.mChildren.size() - 1;
    L6:
        if (j < 0) goto L14;
        WindowState wallpaper = (WindowState) this.mChildren.get(j);
        if (wallpaper.isDrawn() == true) goto L12;
        if (wallpaper.isVisible() == false) goto L12;
        return true;
    L12:
        j = j - 1;
        goto L6
    L14:
        return false;
    }

    @Override // com.android.server.wm.WindowContainer
    boolean fillsParent() {
        return true;
    }

    @Override // com.android.server.wm.WindowContainer
    boolean showWallpaper() {
        return false;
    }

    @Override // com.android.server.wm.WindowContainer
    protected boolean setVisibleRequested(boolean visible) {
        if (super.setVisibleRequested(visible) == true) goto L5;
        return false;
    L5:
        setInsetsFrozen(!visible);
        if (WmTrace.isEnable() == false) goto L14;
        StringBuilder sb = WmTrace.getLocalStringBuilder();
        sb.setLength(0);
        sb.append("Wallpaper token ");
        sb.append(this.token);
        sb.append(" setVisibleRequested: ");
        if (visible == false) goto L10;
        String r1 = "true";
    L11:
        sb.append(r1);
        WmTrace.traceInfo(16, System.currentTimeMillis(), sb.toString());
        return true;
    L10:
        r1 = "false";
        goto L11
    L14:
        return true;
    }

    @Override // com.android.server.wm.WindowContainer
    protected boolean onChildVisibleRequestedChanged(WindowContainer child) {
        return false;
    }

    @Override // com.android.server.wm.WindowContainer
    boolean isVisible() {
        return isClientVisible();
    }

    @Override // com.android.server.wm.WindowContainer
    boolean isSyncFinished(BLASTSyncEngine.SyncGroup group) {
        if (this.mVisibleRequested == true) goto L5;
    L8:
        return true;
    L5:
        if (hasVisibleNotDrawnWallpaper() == false) goto L8;
        return false;
    }

    @Override // com.android.server.wm.WindowToken, com.android.server.wm.WindowContainer
    void dump(PrintWriter pw, String prefix, boolean dumpAll) {
        super.dump(pw, prefix, dumpAll);
        pw.print(prefix);
        pw.print("visibleRequested=");
        pw.print(this.mVisibleRequested);
        pw.print(" visible=");
        pw.println(isVisible());
    }

    @Override // com.android.server.wm.WindowToken
    public String toString() {
        if (this.stringName != null) goto L6;
        this.stringName = "WallpaperWindowToken{" + Integer.toHexString(System.identityHashCode(this)) + " showWhenLocked=" + this.mShowWhenLocked + " token:" + this.token + '}';
    L6:
        return this.stringName;
    }
}
