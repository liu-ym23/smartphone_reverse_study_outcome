package com.android.server.input;

import android.os.IBinder;
import android.os.InputConstants;
import android.view.InputApplicationHandle;
import android.view.InputChannel;
import android.view.InputWindowHandle;
import android.view.SurfaceControl;

/* JADX INFO: loaded from: classes2.dex */
class GestureMonitorSpyWindow {
    final InputApplicationHandle mApplicationHandle;
    final InputChannel mClientChannel;
    final SurfaceControl mInputSurface;
    final IBinder mMonitorToken;
    final InputWindowHandle mWindowHandle;

    GestureMonitorSpyWindow(IBinder token, String name, int displayId, int pid, int uid, SurfaceControl sc, InputChannel inputChannel) {
        this.mMonitorToken = token;
        this.mClientChannel = inputChannel;
        this.mInputSurface = sc;
        this.mApplicationHandle = new InputApplicationHandle(null, name, InputConstants.DEFAULT_DISPATCHING_TIMEOUT_MILLIS);
        this.mWindowHandle = new InputWindowHandle(this.mApplicationHandle, displayId);
        this.mWindowHandle.name = name;
        this.mWindowHandle.token = this.mClientChannel.getToken();
        this.mWindowHandle.layoutParamsType = 2015;
        this.mWindowHandle.dispatchingTimeoutMillis = InputConstants.DEFAULT_DISPATCHING_TIMEOUT_MILLIS;
        this.mWindowHandle.ownerPid = pid;
        this.mWindowHandle.ownerUid = uid;
        this.mWindowHandle.scaleFactor = 1.0f;
        this.mWindowHandle.replaceTouchableRegionWithCrop(null);
        this.mWindowHandle.inputConfig = 16388;
        SurfaceControl.Transaction t = new SurfaceControl.Transaction();
        this.mWindowHandle.setTrustedOverlay(t, this.mInputSurface, true);
        t.setInputWindowInfo(this.mInputSurface, this.mWindowHandle);
        t.setLayer(this.mInputSurface, 1);
        t.setPosition(this.mInputSurface, 0.0f, 0.0f);
        t.setCrop(this.mInputSurface, null);
        t.show(this.mInputSurface);
        t.apply();
    }

    void remove() {
        SurfaceControl.Transaction t = new SurfaceControl.Transaction();
        t.hide(this.mInputSurface);
        t.remove(this.mInputSurface);
        t.apply();
        this.mClientChannel.dispose();
    }

    String dump() {
        return "name='" + this.mWindowHandle.name + "', inputChannelToken=" + this.mClientChannel.getToken() + " displayId=" + this.mWindowHandle.displayId;
    }
}
