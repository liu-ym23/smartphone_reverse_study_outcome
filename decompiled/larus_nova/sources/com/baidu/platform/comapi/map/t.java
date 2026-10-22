package com.baidu.platform.comapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/* JADX INFO: loaded from: classes39.dex */
class t extends SurfaceView implements SurfaceHolder.Callback2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected r f33361a;

    public void surfaceRedrawNeeded(SurfaceHolder r100) {
    }

    public int getDebugFlags() {
        return this.f33361a.getDebugFlags();
    }

    public int getRenderMode() {
        return this.f33361a.getRenderMode();
    }

    public s.a getViewType() {
        r r100 = this.f33361a;
        if (r100 == null) goto L7;
        return r100.getViewType();
    L7:
        return s.a.f33359c;
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        this.f33361a.onDetachedFromWindow();
        super.onDetachedFromWindow();
    }

    public void onPause() {
        this.f33361a.onPause();
    }

    public void onResume() {
        this.f33361a.onResume();
    }

    public void requestRender() {
        this.f33361a.requestRender();
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f33361a.onAttachedToWindow();
    }

    public r getRenderControl() {
        return this.f33361a;
    }

    public t(Context r100) {
        super(r100);
        a(r100, s.a.f33357a, true);
    }

    public void queueEvent(Runnable r100) {
        this.f33361a.queueEvent(r100);
    }

    public void setDebugFlags(int r100) {
        this.f33361a.setDebugFlags(r100);
    }

    public void setRenderMode(int r100) {
        this.f33361a.setRenderMode(r100);
    }

    public void setRenderer(SurfaceRenderer r100) {
        this.f33361a.setRenderer(r100);
    }

    public void surfaceCreated(SurfaceHolder r100) {
        this.f33361a.surfaceCreated(r100);
    }

    public void surfaceDestroyed(SurfaceHolder r100) {
        this.f33361a.surfaceDestroyed(r100);
    }

    public t(Context r100, AttributeSet r101) {
        super(r100, r101);
        a(r100, s.a.f33357a, true);
    }

    public void surfaceRedrawNeededAsync(SurfaceHolder r100, Runnable r101) {
        this.f33361a.surfaceRedrawNeededAsync(r100, r101);
    }

    public t(Context r100, boolean r101) {
        super(r100);
        a(r100, s.a.f33357a, r101);
    }

    public t(Context r100, s.a r101) {
        super(r100);
        a(r100, r101, true);
    }

    public t(Context r100, s.a r101, boolean r102) {
        super(r100);
        a(r100, r101, r102);
    }

    public void a(Context r100, s.a r101, boolean r102) {
        if (this.f33361a == null) goto L5;
        return;
    L5:
        this.f33361a = a(r101, r102, r100);
        getHolder().addCallback(this);
    }

    public r a(s.a r100, boolean r101, Context r102) {
        return s.a(this, r100, r101, r102);
    }

    public void surfaceChanged(SurfaceHolder r100, int r101, int r102, int r103) {
        this.f33361a.surfaceChanged(r100, r101, r102, r103);
    }

    public Bitmap captureImageFromSurface(int r100, int r101, int r110, int r111, Object r112, Bitmap.Config r113) {
        return this.f33361a.captureImageFromSurface(r100, r101, r110, r111, r112, r113);
    }
}
