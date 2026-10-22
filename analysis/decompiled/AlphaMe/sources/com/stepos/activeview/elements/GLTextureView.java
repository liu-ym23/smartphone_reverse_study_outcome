package com.stepos.activeview.elements;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.animation.LinearInterpolator;
import com.stepos.activeview.texture.GLBaseRender;
import com.stepos.activeview.texture.GLDrawThread;
import com.stepos.activeview.utils.LogUtil;
import com.stepos.alphame.bluetooth.VehicleBluetoothManager;
import com.stepos.alphame.utils.Property;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class GLTextureView extends TextureView implements ActiveAnimation {
    private static boolean DEBUG_FLAG = false;
    private static final String TAG = "com.stepos.activeview.elements.GLTextureView";
    private static ValueAnimator TimeAnimator;
    private Context mContext;
    private InnerListener mListener;

    public class InnerListener implements TextureView.SurfaceTextureListener {
        private GLBaseRender mRender;
        public SurfaceTexture mTexture;
        private GLDrawThread mThread;
        boolean IsSurfaceViewDestory = false;
        boolean isSurfaceViewAvailable = false;
        private AtomicBoolean mStopRender = new AtomicBoolean(false);

        public InnerListener(GLTextureView gLTextureView, GLBaseRender gLBaseRender) {
            this.mRender = gLBaseRender;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i4, int i5) {
            this.mRender.setWidthAndHeight(i4, i5);
            this.mTexture = surfaceTexture;
            GLDrawThread gLDrawThread = new GLDrawThread(surfaceTexture, this.mRender, this.mStopRender);
            this.mThread = gLDrawThread;
            gLDrawThread.start();
            this.IsSurfaceViewDestory = false;
            this.isSurfaceViewAvailable = true;
            if (GLTextureView.DEBUG_FLAG) {
                LogUtil.d(GLTextureView.TAG, "SurfaceTextureAvailable");
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.mThread = null;
            this.isSurfaceViewAvailable = false;
            this.IsSurfaceViewDestory = true;
            if (GLTextureView.DEBUG_FLAG) {
                LogUtil.d(GLTextureView.TAG, "SurfaceTextureDestroyed");
            }
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i4, int i5) {
            this.mRender.renderChanged(i4, i5);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        public void setNewThread() {
            this.mThread = new GLDrawThread(this.mTexture, this.mRender, this.mStopRender);
            this.mStopRender.set(false);
            this.mThread.start();
        }
    }

    public GLTextureView(Context context) {
        this(context, null);
    }

    private void initTimeAnimator() {
        new ValueAnimator();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(Property.DEFAULT_FLOAT_VALUE, 1.0f);
        TimeAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(VehicleBluetoothManager.FAIL_RETRY_TIMEOUT);
        TimeAnimator.setInterpolator(new LinearInterpolator());
        TimeAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.stepos.activeview.elements.GLTextureView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                GLDrawThread.TIME = ((Float) valueAnimator.getAnimatedValue()).floatValue() * 360.0f;
            }
        });
        TimeAnimator.setRepeatCount(-1);
    }

    public int getThreadSleepTime(int i4) {
        return GLDrawThread.getSleepTime();
    }

    @Override // com.stepos.activeview.elements.ActiveAnimation
    public void pauseAnimation() {
        setThreadPause();
    }

    @Override // com.stepos.activeview.elements.ActiveAnimation
    public void resumeAnimation() {
        setThreadResume();
    }

    public void setDebug(boolean z4) {
        DEBUG_FLAG = z4;
    }

    public void setInnnerSurfaceChangedListener(GLBaseRender gLBaseRender) {
        InnerListener innerListener = new InnerListener(this, gLBaseRender);
        this.mListener = innerListener;
        setSurfaceTextureListener(innerListener);
    }

    public void setThreadPause() {
        if (this.mListener == null || !TimeAnimator.isRunning()) {
            return;
        }
        TimeAnimator.pause();
    }

    public void setThreadResume() {
        if (this.mListener == null || TimeAnimator == null || !TimeAnimator.isPaused()) {
            return;
        }
        TimeAnimator.resume();
    }

    public void setThreadSleepTime(int i4) {
        GLDrawThread.setSleepTime(i4);
    }

    public void setThreadStart() {
        if (!this.mListener.mStopRender.get()) {
            TimeAnimator.start();
            return;
        }
        TimeAnimator.cancel();
        this.mListener.setNewThread();
        TimeAnimator.start();
    }

    public void setThreadStop() {
        InnerListener innerListener = this.mListener;
        if (innerListener != null) {
            innerListener.mStopRender.set(true);
            TimeAnimator.cancel();
        }
    }

    @Override // com.stepos.activeview.elements.ActiveAnimation
    public void startAnimation() {
        setThreadStart();
    }

    @Override // com.stepos.activeview.elements.ActiveAnimation
    public void stopAnimation() {
        setThreadStop();
    }

    public GLTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GLTextureView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.mContext = context;
        setAlpha(1.0f);
        initTimeAnimator();
    }
}
