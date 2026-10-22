package com.byted.cast.sdk.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.byted.cast.common.CastLogger;
import com.byted.cast.common.ContextManager;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes43.dex */
public class SurfaceRenderView extends SurfaceView implements IRenderView {
    private static final String TAG = "SurfaceRenderView";
    private ContextManager.CastContext mCastContext;
    private CastLogger mLogger;
    private MeasureHelper mMeasureHelper;
    private SurfaceCallback mSurfaceCallback;

    public static final class InternalSurfaceHolder implements IRenderView.ISurfaceHolder {
        private SurfaceHolder mSurfaceHolder;
        private SurfaceRenderView mSurfaceView;

        @Override // com.byted.cast.sdk.view.IRenderView.ISurfaceHolder
        public SurfaceTexture getSurfaceTexture() {
            return null;
        }

        @Override // com.byted.cast.sdk.view.IRenderView.ISurfaceHolder
        public Surface openSurface() {
            SurfaceHolder r100 = this.mSurfaceHolder;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.getSurface();
        }

        @Override // com.byted.cast.sdk.view.IRenderView.ISurfaceHolder
        public IRenderView getRenderView() {
            return this.mSurfaceView;
        }

        @Override // com.byted.cast.sdk.view.IRenderView.ISurfaceHolder
        public SurfaceHolder getSurfaceHolder() {
            return this.mSurfaceHolder;
        }

        public InternalSurfaceHolder(SurfaceRenderView r100, SurfaceHolder r101) {
            this.mSurfaceView = r100;
            this.mSurfaceHolder = r101;
        }
    }

    public static final class SurfaceCallback implements SurfaceHolder.Callback {
        private ContextManager.CastContext mCastContext;
        private int mFormat;
        private int mHeight;
        private boolean mIsFormatChanged;
        private CastLogger mLogger;
        private Map<IRenderView.IRenderCallback, Object> mRenderCallbackMap;
        private SurfaceHolder mSurfaceHolder;
        private WeakReference<SurfaceRenderView> mWeakSurfaceView;
        private int mWidth;

        public void addRenderCallback(IRenderView.IRenderCallback r100) {
            this.mLogger.i(SurfaceRenderView.TAG, "addRenderCallback:" + this.mSurfaceHolder);
            this.mRenderCallbackMap.put(r100, r100);
            if (this.mSurfaceHolder == null) goto L5;
            InternalSurfaceHolder r101 = new InternalSurfaceHolder(this.mWeakSurfaceView.get(), this.mSurfaceHolder);
            r100.onSurfaceCreated(r101, this.mWidth, this.mHeight);
            this.mLogger.i(SurfaceRenderView.TAG, "onSurfaceCreated:" + this.mSurfaceHolder);
        L7:
            if (this.mIsFormatChanged == false) goto L12;
            if (r101 != null) goto L10;
            r101 = new InternalSurfaceHolder(this.mWeakSurfaceView.get(), this.mSurfaceHolder);
        L10:
            r100.onSurfaceChanged(r101, this.mFormat, this.mWidth, this.mHeight);
            return;
        L12:
            return;
        L5:
            r101 = null;
            goto L7
        }

        public void removeRenderCallback(IRenderView.IRenderCallback r100) {
            this.mLogger.i(SurfaceRenderView.TAG, "removeRenderCallback:" + r100);
            this.mRenderCallbackMap.remove(r100);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder r100) {
            this.mLogger.i(SurfaceRenderView.TAG, "surfaceCreated:" + r100);
            this.mSurfaceHolder = r100;
            this.mIsFormatChanged = false;
            this.mFormat = 0;
            this.mWidth = 0;
            this.mHeight = 0;
            InternalSurfaceHolder r101 = new InternalSurfaceHolder(this.mWeakSurfaceView.get(), this.mSurfaceHolder);
            Iterator<IRenderView.IRenderCallback> r102 = this.mRenderCallbackMap.keySet().iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            r102.next().onSurfaceCreated(r101, 0, 0);
            goto L4
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder r100) {
            this.mLogger.i(SurfaceRenderView.TAG, "surfaceDestroyed:" + r100);
            this.mSurfaceHolder = null;
            this.mIsFormatChanged = false;
            this.mFormat = 0;
            this.mWidth = 0;
            this.mHeight = 0;
            InternalSurfaceHolder r101 = new InternalSurfaceHolder(this.mWeakSurfaceView.get(), this.mSurfaceHolder);
            Iterator<IRenderView.IRenderCallback> r102 = this.mRenderCallbackMap.keySet().iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            r102.next().onSurfaceDestroyed(r101);
            goto L4
        }

        public SurfaceCallback(SurfaceRenderView r100, ContextManager.CastContext r101) {
            this.mRenderCallbackMap = new ConcurrentHashMap();
            this.mCastContext = r101;
            this.mLogger = ContextManager.getLogger(r101);
            this.mWeakSurfaceView = new WeakReference(r100);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder r100, int r101, int r102, int r103) {
            this.mLogger.i(SurfaceRenderView.TAG, "surfaceChanged:" + r100);
            this.mSurfaceHolder = r100;
            this.mIsFormatChanged = true;
            this.mFormat = r101;
            this.mWidth = r102;
            this.mHeight = r103;
            InternalSurfaceHolder r104 = new InternalSurfaceHolder(this.mWeakSurfaceView.get(), this.mSurfaceHolder);
            Iterator<IRenderView.IRenderCallback> r105 = this.mRenderCallbackMap.keySet().iterator();
        L4:
            if (r105.hasNext() == false) goto L6;
            r105.next().onSurfaceChanged(r104, r101, r102, r103);
            goto L4
        }
    }

    @Override // com.byted.cast.sdk.view.IRenderView
    public View getView() {
        return this;
    }

    @Override // com.byted.cast.sdk.view.IRenderView
    public void setVideoRotation(int r100) {
    }

    private void initView(Context r100) {
        this.mMeasureHelper = new MeasureHelper(this);
        this.mSurfaceCallback = new SurfaceCallback(this, this.mCastContext);
        getHolder().addCallback(this.mSurfaceCallback);
        getHolder().setType(0);
    }

    @Override // com.byted.cast.sdk.view.IRenderView
    public void addRenderCallback(IRenderView.IRenderCallback r100) {
        this.mSurfaceCallback.addRenderCallback(r100);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent r100) {
        super.onInitializeAccessibilityEvent(r100);
        r100.setClassName(SurfaceRenderView.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r100) {
        super.onInitializeAccessibilityNodeInfo(r100);
        r100.setClassName(SurfaceRenderView.class.getName());
    }

    @Override // com.byted.cast.sdk.view.IRenderView
    public void removeRenderCallback(IRenderView.IRenderCallback r100) {
        this.mSurfaceCallback.removeRenderCallback(r100);
    }

    @Override // com.byted.cast.sdk.view.IRenderView
    public void setAspectRatio(int r100) {
        this.mMeasureHelper.setAspectRatio(r100);
        requestLayout();
    }

    public SurfaceRenderView(Context r100, ContextManager.CastContext r101) {
        super(r100);
        this.mCastContext = r101;
        this.mLogger = ContextManager.getLogger(r101);
        initView(r100);
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

    public SurfaceRenderView(Context r100, AttributeSet r101) {
        super(r100, r101);
        initView(r100);
    }

    public SurfaceRenderView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        initView(r100);
    }

    public SurfaceRenderView(Context r100, AttributeSet r101, int r102, int r103) {
        super(r100, r101, r102, r103);
        initView(r100);
    }
}
