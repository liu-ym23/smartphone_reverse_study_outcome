package com.bytedance.android.livesdkapi.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;

/* JADX INFO: loaded from: classes12.dex */
public class KeepSurfaceTextureRenderView extends TextureRenderView {
    private static final String TAG = null;
    private Surface mSurface;
    private SurfaceTexture mSurfaceTexture;
    private TextureView.SurfaceTextureListener mSurfaceTextureListener;
    private boolean mTextureAvailable;

    private void releaseSurface() {
        releaseSurface(true);
    }

    private boolean shouldForceToKeepSurface() {
        return false;
    }

    static {
        TAG = "KeepSurfaceTextureRenderView";
    }

    private void init() {
        super.setSurfaceTextureListener(new AnonymousClass1(this));
    }

    public void resume() {
        if (this.mSurfaceTexture == null) goto L20;
        Surface r100 = this.mSurface;
        if (r100 == null) goto L20;
        if (r100.isValid() == false) goto L20;
        if (this.mTextureAvailable == false) goto L11;
        return;
    L11:
        if (this.mSurfaceTexture != getSurfaceTexture()) goto L22;
        releaseSurface(!shouldForceToKeepSurface());
        return;
    L22:
        setSurfaceTexture(this.mSurfaceTexture);     // Catch: Exception -> L14
    L16:
        this.mTextureAvailable = true;
        TextureView.SurfaceTextureListener r101 = this.mSurfaceTextureListener;
        if (r101 == null) goto L25;
        r101.onSurfaceTextureAvailable(this.mSurfaceTexture, getWidth(), getHeight());
        return;
    L25:
        return;
    L14:
        e = move-exception;
        e.printStackTrace();
    L20:
        releaseSurface(!shouldForceToKeepSurface());
    }

    @Override // com.bytedance.android.livesdkapi.view.TextureRenderView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (shouldForceToKeepSurface() == false) goto L6;
        releaseSurface();
        return;
    }

    public Surface getSurface() {
        return this.mSurface;
    }

    public KeepSurfaceTextureRenderView(Context r100) {
        this(r100, null);
    }

    public static /* synthetic */ void access$000(KeepSurfaceTextureRenderView r100) {
        r100.releaseSurface();
    }

    public static /* synthetic */ SurfaceTexture access$100(KeepSurfaceTextureRenderView r100) {
        return r100.mSurfaceTexture;
    }

    public static /* synthetic */ TextureView.SurfaceTextureListener access$400(KeepSurfaceTextureRenderView r100) {
        return r100.mSurfaceTextureListener;
    }

    public static /* synthetic */ boolean access$500(KeepSurfaceTextureRenderView r100) {
        return r100.shouldForceToKeepSurface();
    }

    private void releaseSurface(boolean r100) {
        SurfaceTexture r101 = this.mSurfaceTexture;
        if (r101 == null) goto L6;
        if (r100 == false) goto L6;
        r101.release();
        this.mSurfaceTexture = null;
    L6:
        Surface r102 = this.mSurface;
        if (r102 == null) goto L10;
        r102.release();
        this.mSurface = null;
        return;
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int r100) {
        super.onWindowVisibilityChanged(r100);
        if (r100 != 0) goto L6;
        resume();
        return;
    }

    @Override // android.view.TextureView
    public void setSurfaceTextureListener(TextureView.SurfaceTextureListener r100) {
        this.mSurfaceTextureListener = r100;
    }

    public KeepSurfaceTextureRenderView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public static /* synthetic */ SurfaceTexture access$102(KeepSurfaceTextureRenderView r100, SurfaceTexture r101) {
        r100.mSurfaceTexture = r101;
        return r101;
    }

    public static /* synthetic */ Surface access$202(KeepSurfaceTextureRenderView r100, Surface r101) {
        r100.mSurface = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$302(KeepSurfaceTextureRenderView r100, boolean r101) {
        r100.mTextureAvailable = r101;
        return r101;
    }

    public KeepSurfaceTextureRenderView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        init();
    }
}
