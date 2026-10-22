package com.byted.cast.sdk.view;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.byted.cast.sdk.RTCMediaKind;
import com.byted.cast.sdk.RTCVideoRender;

/* JADX INFO: loaded from: classes43.dex */
public class RTCSurfaceView extends GLSurfaceView implements IRenderView {
    private GestureDetector mGestureDetector;
    private MeasureHelper mMeasureHelper;
    private String mMirrorId;
    private RTCVideoRender mVideoRender;

    @Override // com.byted.cast.sdk.view.IRenderView
    public void addRenderCallback(IRenderView.IRenderCallback r100) {
    }

    @Override // com.byted.cast.sdk.view.IRenderView
    public View getView() {
        return this;
    }

    @Override // com.byted.cast.sdk.view.IRenderView
    public void removeRenderCallback(IRenderView.IRenderCallback r100) {
    }

    @Override // com.byted.cast.sdk.view.IRenderView
    public void setVideoRotation(int r100) {
    }

    private void init() {
        this.mVideoRender = new RTCVideoRender(this, this.mMirrorId);
        this.mMeasureHelper = new MeasureHelper(this);
        setRenderer(this.mVideoRender);
        setRenderMode(0);
    }

    public boolean clearSource() {
        return this.mVideoRender.clearSource();
    }

    public RTCMediaKind getMediaKind() {
        return this.mVideoRender.getMediaKind();
    }

    public String getUserId() {
        return this.mVideoRender.getUserId();
    }

    public boolean isSetSource() {
        return this.mVideoRender.isSetSource();
    }

    public boolean isSubscribed() {
        return this.mVideoRender.isSubscribed();
    }

    public boolean subscribe() {
        return this.mVideoRender.subscribe();
    }

    public boolean unsubscribe() {
        return this.mVideoRender.unsubscribe();
    }

    @Override // android.view.View
    public boolean performClick() {
        super.performClick();
        return true;
    }

    public RTCVideoRender getRender() {
        return this.mVideoRender;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        GestureDetector r101 = this.mGestureDetector;
        if (r101 == null) goto L6;
        r101.onTouchEvent(r100);
    L6:
        if (r100.getAction() != 1) goto L9;
        performClick();
    L9:
        return super.onTouchEvent(r100);
    }

    @Override // com.byted.cast.sdk.view.IRenderView
    public void setAspectRatio(int r100) {
        this.mMeasureHelper.setAspectRatio(r100);
        requestLayout();
    }

    public void setOnGestureListener(GestureDetector.OnGestureListener r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.mGestureDetector = new GestureDetector(getContext(), r100);
    }

    public RTCSurfaceView(Context r100, String r101) {
        super(r100);
        this.mMirrorId = r101;
        init();
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int r100, int r101) {
        this.mMeasureHelper.doMeasure(r100, r101);
        setMeasuredDimension(this.mMeasureHelper.getMeasuredWidth(), this.mMeasureHelper.getMeasuredHeight());
    }

    @Override // com.byted.cast.sdk.view.IRenderView
    public void setVideoSampleAspectRatio(int r100, int r101) {
        if (r100 <= 0) goto L6;
        if (r101 <= 0) goto L7;
        this.mMeasureHelper.setVideoSampleAspectRatio(r100, r101);
        requestLayout();
        return;
    L7:
        return;
    }

    @Override // com.byted.cast.sdk.view.IRenderView
    public void setVideoSize(int r100, int r101) {
        if (r100 <= 0) goto L6;
        if (r101 <= 0) goto L7;
        this.mMeasureHelper.setVideoSize(r100, r101);
        getHolder().setFixedSize(r100, r101);
        requestLayout();
        return;
    L7:
        return;
    }

    public RTCSurfaceView(Context r100, AttributeSet r101) {
        super(r100, r101);
        init();
    }

    public boolean setSource(String r100, RTCMediaKind r101, RTCVideoRender.StatusListener r102) {
        return this.mVideoRender.setSource(r100, r101, r102);
    }
}
