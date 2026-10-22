package com.baidu.platform.comapi.map;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.baidu.platform.comapi.map.s;

/* loaded from: classes.dex */
class t extends SurfaceView implements SurfaceHolder.Callback2 {

    /* renamed from: a, reason: collision with root package name */
    protected r f9253a;

    public t(Context context) {
        super(context);
        a(context, s.a.OPENGL_ES, true);
    }

    public void a(Context context, s.a aVar, boolean z4) {
        if (this.f9253a != null) {
            return;
        }
        this.f9253a = a(aVar, z4, context);
        getHolder().addCallback(this);
    }

    public Bitmap captureImageFromSurface(int i4, int i5, int i6, int i7, Object obj, Bitmap.Config config) {
        return this.f9253a.captureImageFromSurface(i4, i5, i6, i7, obj, config);
    }

    public int getDebugFlags() {
        return this.f9253a.getDebugFlags();
    }

    public r getRenderControl() {
        return this.f9253a;
    }

    public int getRenderMode() {
        return this.f9253a.getRenderMode();
    }

    public s.a getViewType() {
        r rVar = this.f9253a;
        return rVar != null ? rVar.getViewType() : s.a.AUTO;
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f9253a.onAttachedToWindow();
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        this.f9253a.onDetachedFromWindow();
        super.onDetachedFromWindow();
    }

    public void onPause() {
        this.f9253a.onPause();
    }

    public void onResume() {
        this.f9253a.onResume();
    }

    public void queueEvent(Runnable runnable) {
        this.f9253a.queueEvent(runnable);
    }

    public void requestRender() {
        this.f9253a.requestRender();
    }

    public void setDebugFlags(int i4) {
        this.f9253a.setDebugFlags(i4);
    }

    public void setRenderMode(int i4) {
        this.f9253a.setRenderMode(i4);
    }

    public void setRenderer(SurfaceRenderer surfaceRenderer) {
        this.f9253a.setRenderer(surfaceRenderer);
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i4, int i5, int i6) {
        this.f9253a.surfaceChanged(surfaceHolder, i4, i5, i6);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f9253a.surfaceCreated(surfaceHolder);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f9253a.surfaceDestroyed(surfaceHolder);
    }

    @Deprecated
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
    }

    @TargetApi(26)
    public void surfaceRedrawNeededAsync(SurfaceHolder surfaceHolder, Runnable runnable) {
        this.f9253a.surfaceRedrawNeededAsync(surfaceHolder, runnable);
    }

    public t(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, s.a.OPENGL_ES, true);
    }

    public t(Context context, s.a aVar) {
        super(context);
        a(context, aVar, true);
    }

    public r a(s.a aVar, boolean z4, Context context) {
        return s.a(this, aVar, z4, context);
    }

    public t(Context context, s.a aVar, boolean z4) {
        super(context);
        a(context, aVar, z4);
    }

    public t(Context context, boolean z4) {
        super(context);
        a(context, s.a.OPENGL_ES, z4);
    }
}
