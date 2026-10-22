package com.android.internal.graphics.backdrop;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.TextureLayer;
import android.os.Handler;
import android.os.Looper;
import android.os.Trace;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceControl;
import android.view.ThreadedRenderer;
import android.view.ViewRootImpl;
import android.view.ViewTreeObserver;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class BackdropLayer {
    private static final float CAPTURE_BUFFER_SCALE = 0.25f;
    private static final String LOG_TAG = "BackdropLayer";
    private static final long PAUSE_CAPTURE_DELAY_MS = 300;
    private TextureLayer mLayer;
    private SurfaceTextureListener mListener;
    private boolean mMatrixChanged;
    private SurfaceTexture mSurface;
    private final ThreadedRenderer mThreadedRenderer;
    private final Handler mUiHandler;
    private boolean mUpdateLayer;
    private final ViewRootImpl mViewRootImpl;
    private boolean mOpaque = true;
    private final Matrix mMatrix = new Matrix();
    private final Object[] mLock = new Object[0];
    private int mWidth = 0;
    private int mHeight = 0;
    private final SurfaceControl mSurfaceControl = new SurfaceControl();
    private boolean mSurfaceControlRegistered = false;
    private final Runnable mPauseCaptureRunnable = new Runnable() { // from class: com.android.internal.graphics.backdrop.BackdropLayer$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.pauseBackdropCapture();
        }
    };
    private final SurfaceTexture.OnFrameAvailableListener mUpdateListener = new SurfaceTexture.OnFrameAvailableListener() { // from class: com.android.internal.graphics.backdrop.BackdropLayer$$ExternalSyntheticLambda1
        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
            this.f$0.lambda$new$1(surfaceTexture);
        }
    };
    private Set<BackdropLayerListener> mBackdropLayerListeners = new HashSet();

    public interface BackdropLayerListener {
        void onBackdropLayerCreated(TextureLayer textureLayer);

        void onBackdropLayerDestroyed();

        void onBackdropLayerUpdated();
    }

    public interface SurfaceTextureListener {
        void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2);

        boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture);

        void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2);

        void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture);
    }

    private static native void nativeRegister(long j, long j2);

    private static native void nativeUnregister(long j);

    public BackdropLayer(ViewRootImpl viewRootImpl, ThreadedRenderer renderer, ViewTreeObserver viewTreeObserver) {
        this.mViewRootImpl = viewRootImpl;
        this.mThreadedRenderer = renderer;
        Looper looper = Looper.myLooper();
        this.mUiHandler = new Handler(looper != null ? looper : Looper.getMainLooper());
        viewTreeObserver.addOnWindowAttachListener(new ViewTreeObserver.OnWindowAttachListener() { // from class: com.android.internal.graphics.backdrop.BackdropLayer.1
            @Override // android.view.ViewTreeObserver.OnWindowAttachListener
            public void onWindowAttached() {
                BackdropLayer.this.onAttachedToWindow();
            }

            @Override // android.view.ViewTreeObserver.OnWindowAttachListener
            public void onWindowDetached() {
                BackdropLayer.this.onDetachedFromWindow();
            }
        });
        viewTreeObserver.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.android.internal.graphics.backdrop.BackdropLayer$$ExternalSyntheticLambda2
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                return this.f$0.lambda$new$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$0() {
        draw();
        return true;
    }

    public void requestBackdropCapture(BackdropLayerListener listener) {
        this.mUiHandler.removeCallbacks(this.mPauseCaptureRunnable);
        if (this.mBackdropLayerListeners.contains(listener)) {
            return;
        }
        boolean wasEmpty = this.mBackdropLayerListeners.isEmpty();
        this.mBackdropLayerListeners.add(listener);
        if (wasEmpty) {
            updateSurfaceControl(this.mViewRootImpl.getSurfaceControl());
        }
        if (this.mLayer != null) {
            listener.onBackdropLayerCreated(this.mLayer);
        } else {
            invalidate();
        }
    }

    public void removeBackdropCapture(BackdropLayerListener listener) {
        if (!this.mBackdropLayerListeners.contains(listener)) {
            return;
        }
        this.mBackdropLayerListeners.remove(listener);
        if (this.mLayer != null) {
            listener.onBackdropLayerDestroyed();
        }
        if (this.mBackdropLayerListeners.isEmpty()) {
            this.mUiHandler.removeCallbacks(this.mPauseCaptureRunnable);
            this.mUiHandler.postDelayed(this.mPauseCaptureRunnable, PAUSE_CAPTURE_DELAY_MS);
        }
    }

    public void updateSurfaceControl(SurfaceControl surfaceControl) {
        if (this.mBackdropLayerListeners.isEmpty()) {
            releaseSurfaceControlRef();
            return;
        }
        if (surfaceControl != null && this.mSurfaceControl.isSameSurface(surfaceControl)) {
            return;
        }
        releaseSurfaceControlRef();
        if (surfaceControl != null && surfaceControl.isValid()) {
            this.mSurfaceControl.copyFrom(surfaceControl, LOG_TAG);
            registerBackdropCapture();
            invalidate();
        }
    }

    private void registerBackdropCapture() {
        if (!this.mSurfaceControl.isValid() || this.mSurface == null) {
            return;
        }
        register(this.mSurfaceControl, new Surface(this.mSurface));
        this.mSurfaceControlRegistered = true;
    }

    public void setSurfaceTextureListener(SurfaceTextureListener listener) {
        this.mListener = listener;
    }

    public void setOpaque(boolean opaque) {
        if (opaque != this.mOpaque) {
            this.mOpaque = opaque;
            if (this.mLayer != null) {
                updateLayer();
                invalidate();
            }
        }
    }

    public void setTransform(Matrix transform) {
        this.mMatrix.set(transform);
        this.mMatrixChanged = true;
        invalidate();
    }

    public void onAttachedToWindow() {
        invalidate();
    }

    public void onDetachedFromWindow() {
        this.mUiHandler.removeCallbacks(this.mPauseCaptureRunnable);
        releaseSurfaceControlRef();
        destroyHardwareLayer();
        releaseSurfaceTexture();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pauseBackdropCapture() {
        if (!this.mBackdropLayerListeners.isEmpty()) {
            return;
        }
        releaseSurfaceControlRef();
        destroyHardwareLayer();
    }

    private void releaseSurfaceControlRef() {
        if (this.mSurfaceControl.isValid()) {
            if (this.mSurfaceControlRegistered) {
                unregister(this.mSurfaceControl);
                this.mSurfaceControlRegistered = false;
            }
            this.mSurfaceControl.release();
        }
    }

    public void destroyHardwareResources() {
        destroyHardwareLayer();
    }

    private void destroyHardwareLayer() {
        if (this.mLayer != null) {
            for (BackdropLayerListener listener : this.mBackdropLayerListeners) {
                listener.onBackdropLayerDestroyed();
            }
            this.mLayer.detachSurfaceTexture();
            this.mLayer.close();
            this.mLayer = null;
            this.mMatrixChanged = true;
        }
    }

    private void releaseSurfaceTexture() {
        if (this.mSurface != null) {
            boolean shouldRelease = true;
            if (this.mListener != null) {
                shouldRelease = this.mListener.onSurfaceTextureDestroyed(this.mSurface);
            }
            if (shouldRelease) {
                this.mSurface.release();
            }
            this.mSurface = null;
        }
    }

    public void onSizeChanged(int w, int h) {
        if (w != this.mWidth || h != this.mHeight) {
            this.mWidth = w;
            this.mHeight = h;
        }
        if (this.mSurface != null) {
            this.mSurface.setDefaultBufferSize(Math.max(1, (int) (this.mWidth * CAPTURE_BUFFER_SCALE)), Math.max(1, (int) (this.mHeight * CAPTURE_BUFFER_SCALE)));
            updateLayer();
            invalidate();
            if (this.mListener != null) {
                this.mListener.onSurfaceTextureSizeChanged(this.mSurface, this.mWidth, this.mHeight);
            }
        }
    }

    private void invalidate() {
        this.mViewRootImpl.invalidateChildInParent((int[]) null, new Rect(0, 0, this.mWidth, this.mHeight));
    }

    private void updateLayer() {
        synchronized (this.mLock) {
            this.mUpdateLayer = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(SurfaceTexture surfaceTexture) {
        updateLayer();
        for (BackdropLayerListener listener : this.mBackdropLayerListeners) {
            listener.onBackdropLayerUpdated();
        }
    }

    private TextureLayer getTextureLayer() {
        if (this.mThreadedRenderer == null || this.mBackdropLayerListeners.isEmpty()) {
            return null;
        }
        if (this.mLayer != null) {
            return this.mLayer;
        }
        this.mLayer = this.mThreadedRenderer.createTextureLayer();
        for (BackdropLayerListener listener : this.mBackdropLayerListeners) {
            listener.onBackdropLayerCreated(this.mLayer);
        }
        boolean createNewSurface = this.mSurface == null;
        if (createNewSurface) {
            this.mSurface = new SurfaceTexture(false);
            registerBackdropCapture();
        }
        this.mLayer.setSurfaceTexture(this.mSurface);
        this.mSurface.setDefaultBufferSize(Math.max(1, (int) (this.mWidth * CAPTURE_BUFFER_SCALE)), Math.max(1, (int) (this.mHeight * CAPTURE_BUFFER_SCALE)));
        this.mSurface.setOnFrameAvailableListener(this.mUpdateListener, null);
        if (this.mListener != null && createNewSurface) {
            this.mListener.onSurfaceTextureAvailable(this.mSurface, this.mWidth, this.mHeight);
        }
        return this.mLayer;
    }

    private void draw() {
        TextureLayer layer = getTextureLayer();
        if (layer != null) {
            Trace.traceBegin(2L, "BackdropLayer#updateBackdropLayer");
            applyUpdate();
            applyTransformMatrix();
            Trace.traceEnd(2L);
        }
    }

    private void applyUpdate() {
        if (this.mLayer == null) {
            return;
        }
        synchronized (this.mLock) {
            if (this.mUpdateLayer) {
                this.mUpdateLayer = false;
                this.mLayer.prepare(this.mWidth, this.mHeight, this.mOpaque);
                this.mLayer.updateSurfaceTexture();
                if (this.mListener != null) {
                    this.mListener.onSurfaceTextureUpdated(this.mSurface);
                }
            }
        }
    }

    private void applyTransformMatrix() {
        if (this.mMatrixChanged && this.mLayer != null) {
            this.mLayer.setTransform(this.mMatrix);
            this.mMatrixChanged = false;
        }
    }

    public static void register(SurfaceControl surfaceControl, Surface surface) {
        Trace.traceCounter(2L, "BackdropLayer for " + surfaceControl.toString(), 1);
        Log.d(LOG_TAG, "register backdrop capture for: " + surfaceControl);
        nativeRegister(surfaceControl.mNativeObject, surface.getNativeObject());
    }

    public static void unregister(SurfaceControl surfaceControl) {
        Trace.traceCounter(2L, "BackdropLayer for " + surfaceControl.toString(), 0);
        Log.d(LOG_TAG, "unregister backdrop capture for: " + surfaceControl);
        nativeUnregister(surfaceControl.mNativeObject);
    }
}
