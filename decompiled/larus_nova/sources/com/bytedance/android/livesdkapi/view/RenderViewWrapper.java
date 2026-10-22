package com.bytedance.android.livesdkapi.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.util.Pair;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.android.livesdkapi.model.DisplayRatio;
import com.bytedance.android.livesdkapi.model.StrictMeasureData;
import com.bytedance.android.livesdkapi.roomplayer.IPlayerLogger;

/* JADX INFO: loaded from: classes12.dex */
public class RenderViewWrapper implements IRenderView {
    private TextureView mTextureView;

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public void addRenderViewMeasureListener(IRenderView.MeasureListener r100) {
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public long getNotVisibleTime() {
        return 0;
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public SurfaceHolder getSurfaceHolder() {
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public void removeRenderViewMeasureListener(IRenderView.MeasureListener r100) {
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public void setPlayerLogger(IPlayerLogger r100) {
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public Bitmap getBitmap() {
        TextureView r100 = this.mTextureView;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getBitmap();
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public Context getContext() {
        return this.mTextureView.getContext();
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public DisplayRatio getDisplayRatio() {
        TextureView r100 = this.mTextureView;
        if ((r100 instanceof TextureRenderView) == true) goto L5;
        return null;
    L5:
        return ((TextureRenderView) r100).getDisplayRatio();
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public int getHeight() {
        return this.mTextureView.getHeight();
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public ViewGroup.LayoutParams getLayoutParams() {
        return this.mTextureView.getLayoutParams();
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public Pair<Integer, Integer> getMeasuredSize() {
        TextureView r100 = this.mTextureView;
        if ((r100 instanceof TextureRenderView) == true) goto L5;
        return null;
    L5:
        return ((TextureRenderView) r100).getMeasuredSize();
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public ViewParent getParent() {
        return this.mTextureView.getParent();
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public int getScaleType() {
        TextureView r100 = this.mTextureView;
        if ((r100 instanceof TextureRenderView) == true) goto L5;
        return 0;
    L5:
        return ((TextureRenderView) r100).getScaleType();
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public SurfaceTexture getSurfaceTexture() {
        return this.mTextureView.getSurfaceTexture();
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public int getVisibility() {
        return this.mTextureView.getVisibility();
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public int getWidth() {
        return this.mTextureView.getWidth();
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public boolean isLayoutVideoSizeValid() {
        TextureView r100 = this.mTextureView;
        if ((r100 instanceof TextureRenderView) == true) goto L5;
        return true;
    L5:
        return ((TextureRenderView) r100).isLayoutVideoSizeValid();
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public void reset() {
        TextureView r100 = this.mTextureView;
        if ((r100 instanceof TextureRenderView) == false) goto L6;
        ((TextureRenderView) r100).reset();
        return;
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public View getSelfView() {
        return this.mTextureView;
    }

    public RenderViewWrapper(TextureView r100) {
        this.mTextureView = r100;
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public void addRenderViewLayoutListener(IRenderView.LayoutListener r100) {
        TextureView r101 = this.mTextureView;
        if ((r101 instanceof TextureRenderView) == false) goto L6;
        ((TextureRenderView) r101).addRenderViewLayoutListener(r100);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public void addTranslationAndScaleListener(IRenderView.TranslationAndScaleListener r100) {
        TextureView r101 = this.mTextureView;
        if ((r101 instanceof TextureRenderView) == false) goto L6;
        ((TextureRenderView) r101).addTranslationAndScaleListener(r100);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public void removeRenderViewLayoutListener(IRenderView.LayoutListener r100) {
        TextureView r101 = this.mTextureView;
        if ((r101 instanceof TextureRenderView) == false) goto L6;
        ((TextureRenderView) r101).removeRenderViewLayoutListener(r100);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public void removeTranslationAndScaleListener(IRenderView.TranslationAndScaleListener r100) {
        TextureView r101 = this.mTextureView;
        if ((r101 instanceof TextureRenderView) == false) goto L6;
        ((TextureRenderView) r101).removeTranslationAndScaleListener(r100);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public void setCurrentLandscape(boolean r100) {
        TextureView r101 = this.mTextureView;
        if ((r101 instanceof TextureRenderView) == false) goto L6;
        ((TextureRenderView) r101).setCurrentLandscape(r100);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public void setDisplayRatio(DisplayRatio r100) {
        TextureView r101 = this.mTextureView;
        if ((r101 instanceof TextureRenderView) == false) goto L6;
        ((TextureRenderView) r101).setDisplayRatio(r100);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public void setLayoutParams(ViewGroup.LayoutParams r100) {
        this.mTextureView.setLayoutParams(r100);
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public void setScaleType(int r100) {
        TextureView r101 = this.mTextureView;
        if ((r101 instanceof TextureRenderView) == false) goto L6;
        ((TextureRenderView) r101).setScaleType(r100);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public void setStrictMeasureData(StrictMeasureData r100) {
        TextureView r101 = this.mTextureView;
        if ((r101 instanceof TextureRenderView) == false) goto L6;
        ((TextureRenderView) r101).setStrictMeasureData(r100);
        return;
    }

    public void setSurfaceTextureListener(TextureView.SurfaceTextureListener r100) {
        this.mTextureView.setSurfaceTextureListener(r100);
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public void setVisibility(int r100) {
        this.mTextureView.setVisibility(r100);
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public void setVrMode(boolean r100) {
        TextureView r101 = this.mTextureView;
        if ((r101 instanceof TextureRenderView) == false) goto L6;
        ((TextureRenderView) r101).setVrMode(r100);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public void setVrStyle(int r100) {
        TextureView r101 = this.mTextureView;
        if ((r101 instanceof TextureRenderView) == false) goto L6;
        ((TextureRenderView) r101).setVrStyle(r100);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView
    public void setVideoSize(int r100, int r101) {
        TextureView r102 = this.mTextureView;
        if ((r102 instanceof TextureRenderView) == false) goto L6;
        ((TextureRenderView) r102).setVideoSize(r100, r101);
        return;
    }
}
