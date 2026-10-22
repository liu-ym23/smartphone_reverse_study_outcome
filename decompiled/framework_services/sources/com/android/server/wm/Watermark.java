package com.android.server.wm;

import android.graphics.BLASTBufferQueue;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.view.Surface;
import android.view.SurfaceControl;

/* JADX INFO: loaded from: classes3.dex */
class Watermark {
    private static final String TITLE = "WatermarkSurface";
    private final BLASTBufferQueue mBlastBufferQueue;
    private final int mDeltaX;
    private final int mDeltaY;
    private boolean mDrawNeeded;
    private int mLastDH;
    private int mLastDW;
    private final Surface mSurface;
    private final SurfaceControl mSurfaceControl;
    private final String mText;
    private final int mTextHeight;
    private final Paint mTextPaint;
    private final int mTextWidth;

    Watermark(DisplayContent dc, DisplayMetrics dm, String[] tokens, SurfaceControl.Transaction t) {
        StringBuilder builder = new StringBuilder(32);
        int len = tokens[0].length();
        int len2 = len & (-2);
        int i = 0;
    L3:
        if (i >= len2) goto L20;
        int c1 = tokens[0].charAt(i);
        int c2 = tokens[0].charAt(i + 1);
        if (c1 < 97) goto L8;
        if (c1 > 102) goto L8;
        int c3 = (c1 - 97) + 10;
    L12:
        if (c2 < 97) goto L15;
        if (c2 > 102) goto L15;
        int c4 = (c2 - 97) + 10;
    L19:
        builder.append((char) (255 - ((c3 * 16) + c4)));
        i = i + 2;
    L15:
        if (c2 < 65) goto L18;
        if (c2 > 70) goto L18;
        c4 = (c2 - 65) + 10;
    L18:
        c4 = c2 - 48;
    L8:
        if (c1 < 65) goto L11;
        if (c1 > 70) goto L11;
        c3 = (c1 - 65) + 10;
    L11:
        c3 = c1 - 48;
        goto L12
    L20:
        this.mText = builder.toString();
        int fontSize = WindowManagerService.getPropertyInt(tokens, 1, 1, 20, dm);
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setTextSize(fontSize);
        this.mTextPaint.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
        Paint.FontMetricsInt fm = this.mTextPaint.getFontMetricsInt();
        this.mTextWidth = (int) this.mTextPaint.measureText(this.mText);
        this.mTextHeight = fm.descent - fm.ascent;
        this.mDeltaX = WindowManagerService.getPropertyInt(tokens, 2, 0, this.mTextWidth * 2, dm);
        this.mDeltaY = WindowManagerService.getPropertyInt(tokens, 3, 0, this.mTextHeight * 3, dm);
        int shadowColor = WindowManagerService.getPropertyInt(tokens, 4, 0, -1342177280, dm);
        int color = WindowManagerService.getPropertyInt(tokens, 5, 0, 1627389951, dm);
        int shadowRadius = WindowManagerService.getPropertyInt(tokens, 6, 0, 7, dm);
        int shadowDx = WindowManagerService.getPropertyInt(tokens, 8, 0, 0, dm);
        int shadowDy = WindowManagerService.getPropertyInt(tokens, 9, 0, 0, dm);
        this.mTextPaint.setColor(color);
        this.mTextPaint.setShadowLayer(shadowRadius, shadowDx, shadowDy, shadowColor);
        SurfaceControl ctrl = null;
        ctrl = dc.makeOverlay().setName(TITLE).setBLASTLayer().setFormat(-3).setCallsite(TITLE).build();     // Catch: Surface.OutOfResourcesException -> L23
        t.setLayer(ctrl, 1000000).setPosition(ctrl, 0.0f, 0.0f).show(ctrl);     // Catch: Surface.OutOfResourcesException -> L23
        InputMonitor.setTrustedOverlayInputInfo(ctrl, t, dc.getDisplayId(), TITLE);     // Catch: Surface.OutOfResourcesException -> L23
    L24:
        this.mSurfaceControl = ctrl;
        this.mBlastBufferQueue = new BLASTBufferQueue(TITLE, true);
        this.mBlastBufferQueue.update(this.mSurfaceControl, 1, 1, 1);
        this.mSurface = this.mBlastBufferQueue.createSurface();
    }

    void positionSurface(int dw, int dh, SurfaceControl.Transaction t) {
        if (this.mLastDW == dw) goto L5;
    L6:
        this.mLastDW = dw;
        this.mLastDH = dh;
        t.setBufferSize(this.mSurfaceControl, dw, dh);
        this.mDrawNeeded = true;
        return;
    L5:
        if (this.mLastDH != dh) goto L6;
    }

    void drawIfNeeded() {
        if (this.mDrawNeeded == true) goto L5;
        return;
    L5:
        int dw = this.mLastDW;
        int dh = this.mLastDH;
        this.mDrawNeeded = false;
        this.mBlastBufferQueue.update(this.mSurfaceControl, dw, dh, 1);
        Canvas c = null;
        c = this.mSurface.lockCanvas(null);     // Catch: Throwable -> L8
    L9:
        if (c == null) goto L30;
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        int deltaX = this.mDeltaX;
        int deltaY = this.mDeltaY;
        int div = (this.mTextWidth + dw) / deltaX;
        int rem = (this.mTextWidth + dw) - (div * deltaX);
        int qdelta = deltaX / 4;
        if (rem >= qdelta) goto L13;
    L14:
        deltaX = deltaX + (deltaX / 3);
    L15:
        int y = -this.mTextHeight;
        int x = -this.mTextWidth;
    L17:
        if (y >= (this.mTextHeight + dh)) goto L21;
        c.drawText(this.mText, x, y, this.mTextPaint);
        x = x + deltaX;
        if (x < dw) goto L17;
        x = x - (this.mTextWidth + dw);
        y = y + deltaY;
        goto L17
    L21:
        this.mSurface.unlockCanvasAndPost(c);
        return;
    L13:
        if (rem <= (deltaX - qdelta)) goto L15;
    }
}
