package com.android.server.wm;

import android.graphics.Point;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Slog;
import android.view.DisplayInfo;
import android.view.IWindow;
import android.view.SurfaceControl;
import android.view.animation.Animation;
import com.android.server.job.controllers.JobStatus;

/* JADX INFO: loaded from: classes3.dex */
public class ShellRoot {
    private static final String TAG = "ShellRoot";
    private IWindow mAccessibilityWindow;
    private IBinder.DeathRecipient mAccessibilityWindowDeath;
    private IWindow mClient;
    private final IBinder.DeathRecipient mDeathRecipient;
    private final DisplayContent mDisplayContent;
    private final int mShellRootLayer;
    private SurfaceControl mSurfaceControl;
    private WindowToken mToken;
    private int mWindowType;

    public static /* synthetic */ void $r8$lambda$L2dx9mPsIUHgcC1vLwzdtiGIa4g(ShellRoot r0) {
        r0.lambda$setAccessibilityWindow$1();
    }

    public static /* synthetic */ void $r8$lambda$aRcc5NXYaAKQgWwxRszxrGvFTRM(ShellRoot r0, int r1) {
        r0.lambda$new$0(r1);
    }

    ShellRoot(IWindow client, DisplayContent dc, final int shellRootLayer) {
        this.mSurfaceControl = null;
        this.mDisplayContent = dc;
        this.mShellRootLayer = shellRootLayer;
        this.mDeathRecipient = new ShellRoot$$ExternalSyntheticLambda0(this, shellRootLayer);
        client.asBinder().linkToDeath(this.mDeathRecipient, 0);     // Catch: RemoteException -> L12
        this.mClient = client;
        switch(shellRootLayer) {
            case 0: goto L9;
            case 1: goto L8;
            default: goto L7;
        };
    L8:
        this.mWindowType = 2038;
    L10:
        this.mToken = new WindowToken.Builder(dc.mWmService, client.asBinder(), this.mWindowType).setDisplayContent(dc).setPersistOnEmpty(true).setOwnerCanManageAppTokens(true).build();
        this.mSurfaceControl = this.mToken.makeChildSurface(null).setContainerLayer().setName("Shell Root Leash " + dc.getDisplayId()).setCallsite(TAG).build();
        this.mToken.getPendingTransaction().show(this.mSurfaceControl);
        return;
    L9:
        this.mWindowType = 2034;
        goto L10
    L7:
        throw new IllegalArgumentException(shellRootLayer + " is not an acceptable shell root layer.");
    L12:
        e = move-exception;
        Slog.e(TAG, "Unable to add shell root layer " + shellRootLayer + " on display " + dc.getDisplayId(), e);
    }

    private /* synthetic */ void lambda$new$0(int shellRootLayer) {
        this.mDisplayContent.removeShellRoot(shellRootLayer);
    }

    int getWindowType() {
        return this.mWindowType;
    }

    void clear() {
        if (this.mClient == null) goto L6;
        this.mClient.asBinder().unlinkToDeath(this.mDeathRecipient, 0);
        this.mClient = null;
    L6:
        if (this.mToken == null) goto L9;
        this.mToken.removeImmediately();
        this.mToken = null;
        return;
    }

    SurfaceControl getSurfaceControl() {
        return this.mSurfaceControl;
    }

    IWindow getClient() {
        return this.mClient;
    }

    void startAnimation(Animation anim) {
        if (this.mToken.windowType == 2034) goto L5;
        return;
    L5:
        DisplayInfo displayInfo = this.mToken.getFixedRotationTransformDisplayInfo();
        if (displayInfo != null) goto L8;
        displayInfo = this.mDisplayContent.getDisplayInfo();
    L8:
        anim.initialize(displayInfo.logicalWidth, displayInfo.logicalHeight, displayInfo.appWidth, displayInfo.appHeight);
        anim.restrictDuration(JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY);
        anim.scaleCurrentDuration(this.mDisplayContent.mWmService.getWindowAnimationScaleLocked());
        AnimationAdapter adapter = new LocalAnimationAdapter(new WindowAnimationSpec(anim, new Point(0, 0), false, 0.0f), this.mDisplayContent.mWmService.mSurfaceAnimationRunner);
        this.mToken.startAnimation(this.mToken.getPendingTransaction(), adapter, false, 16);
    }

    IBinder getAccessibilityWindowToken() {
        if (this.mAccessibilityWindow != null) goto L5;
        return null;
    L5:
        return this.mAccessibilityWindow.asBinder();
    }

    void setAccessibilityWindow(IWindow window) {
        if (this.mAccessibilityWindow == null) goto L5;
        this.mAccessibilityWindow.asBinder().unlinkToDeath(this.mAccessibilityWindowDeath, 0);
    L5:
        this.mAccessibilityWindow = window;
        if (this.mAccessibilityWindow == null) goto L14;
        this.mAccessibilityWindowDeath = new ShellRoot$$ExternalSyntheticLambda1(this);     // Catch: RemoteException -> L9
        this.mAccessibilityWindow.asBinder().linkToDeath(this.mAccessibilityWindowDeath, 0);     // Catch: RemoteException -> L9
        return;
    L10:
        this.mAccessibilityWindow = null;
        return;
    }

    private /* synthetic */ void lambda$setAccessibilityWindow$1() {
        WindowManagerGlobalLock r0 = this.mDisplayContent.mWmService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mAccessibilityWindow = null;     // Catch: Throwable -> L9
        setAccessibilityWindow(null);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }
}
