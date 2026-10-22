package com.android.server.inputmethod;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.InputConstants;
import android.os.Process;
import android.view.InputApplicationHandle;
import android.view.InputChannel;
import android.view.InputWindowHandle;
import android.view.SurfaceControl;
import android.view.WindowManager;
import android.view.WindowMetrics;

/* JADX INFO: loaded from: classes2.dex */
final class HandwritingEventReceiverSurface {
    static final boolean DEBUG = false;
    public static final String TAG = null;
    private final InputChannel mClientChannel;
    private final SurfaceControl mInputSurface;
    private boolean mIsIntercepting;
    private final InputWindowHandle mWindowHandle;

    static {
        TAG = HandwritingEventReceiverSurface.class.getSimpleName();
    }

    HandwritingEventReceiverSurface(Context context, String name, int displayId, SurfaceControl sc, InputChannel inputChannel) {
        this.mClientChannel = inputChannel;
        this.mInputSurface = sc;
        this.mWindowHandle = new InputWindowHandle(new InputApplicationHandle(null, name, InputConstants.DEFAULT_DISPATCHING_TIMEOUT_MILLIS), displayId);
        this.mWindowHandle.name = name;
        this.mWindowHandle.token = this.mClientChannel.getToken();
        this.mWindowHandle.layoutParamsType = 2015;
        this.mWindowHandle.dispatchingTimeoutMillis = InputConstants.DEFAULT_DISPATCHING_TIMEOUT_MILLIS;
        this.mWindowHandle.ownerPid = Process.myPid();
        this.mWindowHandle.ownerUid = Process.myUid();
        this.mWindowHandle.scaleFactor = 1.0f;
        this.mWindowHandle.inputConfig = 49164;
        this.mWindowHandle.setTouchableRegionCrop(this.mInputSurface);
        WindowMetrics windowMetrics = ((WindowManager) context.getSystemService(WindowManager.class)).getMaximumWindowMetrics();
        Rect bounds = windowMetrics.getBounds();
        this.mWindowHandle.setTouchableRegion(windowMetrics.getBounds());
        SurfaceControl.Transaction t = new SurfaceControl.Transaction();
        this.mWindowHandle.setTrustedOverlay(t, this.mInputSurface, true);
        t.setInputWindowInfo(this.mInputSurface, this.mWindowHandle);
        t.setLayer(this.mInputSurface, 2);
        t.setPosition(this.mInputSurface, 0.0f, 0.0f);
        t.setCrop(this.mInputSurface, bounds);
        t.show(this.mInputSurface);
        t.apply();
        this.mIsIntercepting = false;
    }

    void startIntercepting(int imePid, int imeUid) {
        this.mWindowHandle.ownerPid = imePid;
        this.mWindowHandle.ownerUid = imeUid;
        this.mWindowHandle.inputConfig &= -16385;
        this.mWindowHandle.inputConfig |= 512;
        new SurfaceControl.Transaction().setInputWindowInfo(this.mInputSurface, this.mWindowHandle).apply();
        this.mIsIntercepting = true;
    }

    void setTouchableRegion(Region touchableRegion) {
        this.mWindowHandle.touchableRegion.set(touchableRegion);
        new SurfaceControl.Transaction().setInputWindowInfo(this.mInputSurface, this.mWindowHandle).apply();
    }

    void setNotTouchable(boolean notTouchable) {
        if (notTouchable == false) goto L4;
        this.mWindowHandle.inputConfig |= 8;
    L5:
        new SurfaceControl.Transaction().setInputWindowInfo(this.mInputSurface, this.mWindowHandle).apply();
        return;
    L4:
        this.mWindowHandle.inputConfig &= -9;
        goto L5
    }

    boolean isIntercepting() {
        return this.mIsIntercepting;
    }

    void remove() {
        SurfaceControl.Transaction t = new SurfaceControl.Transaction();
        t.remove(this.mInputSurface);
        t.apply();
    }

    InputChannel getInputChannel() {
        return this.mClientChannel;
    }

    SurfaceControl getSurface() {
        return this.mInputSurface;
    }

    InputWindowHandle getInputWindowHandle() {
        return this.mWindowHandle;
    }
}
