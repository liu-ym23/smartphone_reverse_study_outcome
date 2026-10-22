package com.android.server.wm;

import android.graphics.BLASTBufferQueue;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.Surface;
import android.view.SurfaceControl;

/* JADX INFO: loaded from: classes3.dex */
class StrictModeFlash {
    private static final String TAG = "WindowManager";
    private static final String TITLE = "StrictModeFlash";
    private final BLASTBufferQueue mBlastBufferQueue;
    private boolean mDrawNeeded;
    private int mLastDH;
    private int mLastDW;
    private final Surface mSurface;
    private final SurfaceControl mSurfaceControl;
    private final int mThickness;

    StrictModeFlash(DisplayContent dc, SurfaceControl.Transaction t) {
        this.mThickness = 20;
        SurfaceControl ctrl = null;
        ctrl = dc.makeOverlay().setName(TITLE).setBLASTLayer().setFormat(-3).setCallsite(TITLE).build();     // Catch: Surface.OutOfResourcesException -> L5
        t.setLayer(ctrl, 1010000);     // Catch: Surface.OutOfResourcesException -> L5
        t.setPosition(ctrl, 0.0f, 0.0f);     // Catch: Surface.OutOfResourcesException -> L5
        t.show(ctrl);     // Catch: Surface.OutOfResourcesException -> L5
        InputMonitor.setTrustedOverlayInputInfo(ctrl, t, dc.getDisplayId(), TITLE);     // Catch: Surface.OutOfResourcesException -> L5
    L6:
        this.mSurfaceControl = ctrl;
        this.mDrawNeeded = true;
        this.mBlastBufferQueue = new BLASTBufferQueue(TITLE, true);
        this.mBlastBufferQueue.update(this.mSurfaceControl, 1, 1, 1);
        this.mSurface = this.mBlastBufferQueue.createSurface();
    }

    private void drawIfNeeded() {
        if (this.mDrawNeeded == true) goto L5;
        return;
    L5:
        this.mDrawNeeded = false;
        int dw = this.mLastDW;
        int dh = this.mLastDH;
        this.mBlastBufferQueue.update(this.mSurfaceControl, dw, dh, 1);
        Canvas c = null;
        c = this.mSurface.lockCanvas(null);     // Catch: Throwable -> L8
    L9:
        if (c != null) goto L11;
        return;
    L11:
        c.save();
        c.clipRect(new Rect(0, 0, dw, 20));
        c.drawColor(-65536);
        c.restore();
        c.save();
        c.clipRect(new Rect(0, 0, 20, dh));
        c.drawColor(-65536);
        c.restore();
        c.save();
        c.clipRect(new Rect(dw - 20, 0, dw, dh));
        c.drawColor(-65536);
        c.restore();
        c.save();
        c.clipRect(new Rect(0, dh - 20, dw, dh));
        c.drawColor(-65536);
        c.restore();
        this.mSurface.unlockCanvasAndPost(c);
    }

    public void setVisibility(boolean on, SurfaceControl.Transaction t) {
        if (this.mSurfaceControl != null) goto L5;
        return;
    L5:
        drawIfNeeded();
        if (on == false) goto L8;
        t.show(this.mSurfaceControl);
        return;
    L8:
        t.hide(this.mSurfaceControl);
    }

    void positionSurface(int dw, int dh, SurfaceControl.Transaction t) {
        if (this.mLastDW == dw) goto L5;
    L7:
        this.mLastDW = dw;
        this.mLastDH = dh;
        t.setBufferSize(this.mSurfaceControl, dw, dh);
        this.mDrawNeeded = true;
        return;
    L5:
        if (this.mLastDH != dh) goto L7;
    }
}
