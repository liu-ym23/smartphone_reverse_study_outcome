package com.android.server.wm;

import android.R;
import android.content.Context;
import android.graphics.BLASTBufferQueue;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.Display;
import android.view.Surface;
import android.view.SurfaceControl;

/* JADX INFO: loaded from: classes3.dex */
class EmulatorDisplayOverlay {
    private static final String TAG = "WindowManager";
    private static final String TITLE = "EmulatorDisplayOverlay";
    private final BLASTBufferQueue mBlastBufferQueue;
    private boolean mDrawNeeded;
    private int mLastDH;
    private int mLastDW;
    private final Drawable mOverlay;
    private int mRotation;
    private Point mScreenSize;
    private final Surface mSurface;
    private final SurfaceControl mSurfaceControl;
    private boolean mVisible;

    EmulatorDisplayOverlay(Context context, DisplayContent dc, int zOrder, SurfaceControl.Transaction t) {
        Display display = dc.getDisplay();
        this.mScreenSize = new Point();
        display.getSize(this.mScreenSize);
        SurfaceControl ctrl = null;
        ctrl = dc.makeOverlay().setName(TITLE).setBLASTLayer().setFormat(-3).setCallsite(TITLE).build();     // Catch: Surface.OutOfResourcesException -> L5
        t.setLayer(ctrl, zOrder);     // Catch: Surface.OutOfResourcesException -> L5
        t.setPosition(ctrl, 0.0f, 0.0f);     // Catch: Surface.OutOfResourcesException -> L5
        t.show(ctrl);     // Catch: Surface.OutOfResourcesException -> L5
        InputMonitor.setTrustedOverlayInputInfo(ctrl, t, dc.getDisplayId(), TITLE);     // Catch: Surface.OutOfResourcesException -> L5
    L6:
        this.mSurfaceControl = ctrl;
        this.mDrawNeeded = true;
        this.mOverlay = context.getDrawable(R.drawable.ic_media_route_connecting_dark_17_mtrl);
        this.mBlastBufferQueue = new BLASTBufferQueue(TITLE, true);
        this.mBlastBufferQueue.update(this.mSurfaceControl, this.mScreenSize.x, this.mScreenSize.y, 1);
        this.mSurface = this.mBlastBufferQueue.createSurface();
    }

    private void drawIfNeeded(SurfaceControl.Transaction t) {
        if (this.mDrawNeeded == true) goto L5;
        return;
    L5:
        if (this.mVisible == false) goto L18;
        this.mDrawNeeded = false;
        Canvas c = null;
        c = this.mSurface.lockCanvas(null);     // Catch: Throwable -> L10
    L11:
        if (c != null) goto L13;
        return;
    L13:
        c.drawColor(0, PorterDuff.Mode.SRC);
        t.setPosition(this.mSurfaceControl, 0.0f, 0.0f);
        int size = Math.max(this.mScreenSize.x, this.mScreenSize.y);
        this.mOverlay.setBounds(0, 0, size, size);
        this.mOverlay.draw(c);
        this.mSurface.unlockCanvasAndPost(c);
        return;
    }

    public void setVisibility(boolean on, SurfaceControl.Transaction t) {
        if (this.mSurfaceControl != null) goto L5;
        return;
    L5:
        this.mVisible = on;
        drawIfNeeded(t);
        if (on == false) goto L8;
        t.show(this.mSurfaceControl);
        return;
    L8:
        t.hide(this.mSurfaceControl);
    }

    void positionSurface(int dw, int dh, int rotation, SurfaceControl.Transaction t) {
        if (this.mLastDW == dw) goto L5;
    L9:
        this.mLastDW = dw;
        this.mLastDH = dh;
        this.mDrawNeeded = true;
        this.mRotation = rotation;
        drawIfNeeded(t);
        return;
    L5:
        if (this.mLastDH != dh) goto L9;
        if (this.mRotation != rotation) goto L9;
    }
}
