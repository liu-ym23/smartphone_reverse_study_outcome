package com.android.server.wm;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Binder;
import android.os.IBinder;
import android.os.InputConstants;
import android.os.RemoteException;
import android.os.UserHandle;
import android.view.InputApplicationHandle;
import android.view.InputChannel;
import android.view.InputWindowHandle;
import android.view.SurfaceControl;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes3.dex */
class InputConsumerImpl implements IBinder.DeathRecipient {
    final InputApplicationHandle mApplicationHandle;
    final InputChannel mClientChannel;
    final int mClientPid;
    final UserHandle mClientUser;
    final SurfaceControl mInputSurface;
    final String mName;
    private final Point mOldPosition;
    private final Rect mOldWindowCrop;
    final WindowManagerService mService;
    Rect mTmpClipRect;
    private final Rect mTmpRect;
    final IBinder mToken;
    final InputWindowHandle mWindowHandle;

    InputConsumerImpl(WindowManagerService service, IBinder token, String name, InputChannel inputChannel, int clientPid, UserHandle clientUser, int displayId, SurfaceControl.Transaction t) {
        this.mTmpClipRect = new Rect();
        this.mTmpRect = new Rect();
        this.mOldPosition = new Point();
        this.mOldWindowCrop = new Rect();
        this.mService = service;
        this.mToken = token;
        this.mName = name;
        this.mClientPid = clientPid;
        this.mClientUser = clientUser;
        this.mClientChannel = this.mService.mInputManager.createInputChannel(name);
        if (inputChannel == null) goto L5;
        this.mClientChannel.copyTo(inputChannel);
    L5:
        this.mApplicationHandle = new InputApplicationHandle(new Binder(), name, InputConstants.DEFAULT_DISPATCHING_TIMEOUT_MILLIS);
        this.mWindowHandle = new InputWindowHandle(this.mApplicationHandle, displayId);
        this.mWindowHandle.name = name;
        this.mWindowHandle.token = this.mClientChannel.getToken();
        this.mWindowHandle.layoutParamsType = 2022;
        this.mWindowHandle.dispatchingTimeoutMillis = InputConstants.DEFAULT_DISPATCHING_TIMEOUT_MILLIS;
        this.mWindowHandle.ownerPid = WindowManagerService.MY_PID;
        this.mWindowHandle.ownerUid = WindowManagerService.MY_UID;
        this.mWindowHandle.scaleFactor = 1.0f;
        this.mWindowHandle.inputConfig = 4;
        this.mInputSurface = this.mService.makeSurfaceBuilder().setContainerLayer().setName("Input Consumer " + name).setCallsite("InputConsumerImpl").build();
        this.mWindowHandle.setTrustedOverlay(t, this.mInputSurface, true);
    }

    void linkToDeathRecipient() {
        if (this.mToken != null) goto L9;
        return;
    L9:
        this.mToken.linkToDeath(this, 0);     // Catch: RemoteException -> L7
        return;
    }

    void unlinkFromDeathRecipient() {
        if (this.mToken != null) goto L5;
        return;
    L5:
        this.mToken.unlinkToDeath(this, 0);
    }

    void layout(SurfaceControl.Transaction t, int dw, int dh) {
        this.mTmpRect.set(0, 0, dw, dh);
        layout(t, this.mTmpRect);
    }

    void layout(SurfaceControl.Transaction t, Rect r) {
        this.mTmpClipRect.set(0, 0, r.width(), r.height());
        if (this.mOldPosition.equals(r.left, r.top) == true) goto L5;
    L7:
        t.setPosition(this.mInputSurface, r.left, r.top);
        t.setWindowCrop(this.mInputSurface, this.mTmpClipRect);
        this.mOldPosition.set(r.left, r.top);
        this.mOldWindowCrop.set(this.mTmpClipRect);
        return;
    L5:
        if (this.mOldWindowCrop.equals(this.mTmpClipRect) == false) goto L7;
    }

    void hide(SurfaceControl.Transaction t) {
        t.hide(this.mInputSurface);
    }

    void show(SurfaceControl.Transaction t, WindowContainer w) {
        t.show(this.mInputSurface);
        t.setInputWindowInfo(this.mInputSurface, this.mWindowHandle);
        t.setRelativeLayer(this.mInputSurface, w.getSurfaceControl(), w.getChildCount() + 1);
    }

    void show(SurfaceControl.Transaction t, int layer) {
        t.show(this.mInputSurface);
        t.setInputWindowInfo(this.mInputSurface, this.mWindowHandle);
        t.setLayer(this.mInputSurface, layer);
    }

    void reparent(SurfaceControl.Transaction t, WindowContainer wc) {
        t.reparent(this.mInputSurface, wc.getSurfaceControl());
    }

    void disposeChannelsLw(SurfaceControl.Transaction t) {
        this.mService.mInputManager.removeInputChannel(this.mClientChannel.getToken());
        this.mClientChannel.dispose();
        t.remove(this.mInputSurface);
        unlinkFromDeathRecipient();
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        Object r0 = this.mService.getWindowManagerLock();
        monitor-enter(r0);
        DisplayContent dc = this.mService.mRoot.getDisplayContent(this.mWindowHandle.displayId);     // Catch: Throwable -> L8
        if (dc != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        dc.getInputMonitor().destroyInputConsumer(this.mToken);     // Catch: Throwable -> L8
        unlinkFromDeathRecipient();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void dump(PrintWriter pw, String name, String prefix) {
        pw.println(prefix + "  name=" + name + " pid=" + this.mClientPid + " user=" + this.mClientUser);
    }
}
