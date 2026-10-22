package com.android.internal.graphics.backdrop;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RecordingCanvas;
import android.graphics.Rect;
import android.graphics.RenderNode;
import android.graphics.TextureLayer;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.android.internal.graphics.backdrop.BackdropLayer;

/* loaded from: classes.dex */
public class BackdropLayerView extends View {
    private static final String TAG = "BackdropBlendBlurContainer";
    private final BackdropLayer.BackdropLayerListener mBackdropLayerListener;
    private final Handler mHandler;
    private final RenderNode.PositionUpdateListener mPositionUpdateListener;
    private final Rect mRect;
    private final RenderNode mRenderNode;
    private TextureLayer mTextureLayer;

    public BackdropLayerView(Context context) {
        this(context, null);
    }

    public BackdropLayerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BackdropLayerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mRect = new Rect();
        this.mBackdropLayerListener = new BackdropLayer.BackdropLayerListener() { // from class: com.android.internal.graphics.backdrop.BackdropLayerView.1
            @Override // com.android.internal.graphics.backdrop.BackdropLayer.BackdropLayerListener
            public void onBackdropLayerCreated(TextureLayer layer) {
                BackdropLayerView.this.mTextureLayer = layer;
                BackdropLayerView.this.invalidate();
            }

            @Override // com.android.internal.graphics.backdrop.BackdropLayer.BackdropLayerListener
            public void onBackdropLayerUpdated() {
                BackdropLayerView.this.invalidate();
            }

            @Override // com.android.internal.graphics.backdrop.BackdropLayer.BackdropLayerListener
            public void onBackdropLayerDestroyed() {
                BackdropLayerView.this.mTextureLayer = null;
                BackdropLayerView.this.invalidate();
            }
        };
        this.mPositionUpdateListener = new RenderNode.PositionUpdateListener() { // from class: com.android.internal.graphics.backdrop.BackdropLayerView.2
            public void positionChanged(long frameNumber, int left, int top, int right, int bottom) {
                if (BackdropLayerView.this.mRect.left == left && BackdropLayerView.this.mRect.top == top && BackdropLayerView.this.mRect.right == right && BackdropLayerView.this.mRect.bottom == bottom) {
                    return;
                }
                BackdropLayerView.this.mRect.set(left, top, right, bottom);
                BackdropLayerView.this.invalidate();
            }

            public void positionLost(long frameNumber) {
                if (BackdropLayerView.this.mRect.isEmpty()) {
                    return;
                }
                BackdropLayerView.this.mRect.setEmpty();
                BackdropLayerView.this.invalidate();
            }
        };
        Looper looper = Looper.myLooper();
        this.mHandler = new Handler(looper == null ? Looper.getMainLooper() : looper);
        this.mRenderNode = new RenderNode(TAG);
        this.mRenderNode.addPositionUpdateListener(this.mPositionUpdateListener);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewRootImpl().requestBackdropCapture(this.mBackdropLayerListener);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewRootImpl().removeBackdropCapture(this.mBackdropLayerListener);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.mRenderNode.setPosition(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public void invalidate() {
        if (Thread.currentThread() == this.mHandler.getLooper().getThread()) {
            super.invalidate();
        } else {
            super.postInvalidate();
        }
    }

    protected void drawBackdropEffect(Canvas canvas, TextureLayer textureLayer, int offsetX, int offsetY) {
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!(canvas instanceof RecordingCanvas)) {
            Log.e(TAG, "Skip drawRenderNode for software rendering");
            return;
        }
        canvas.drawRenderNode(this.mRenderNode);
        if (this.mTextureLayer != null) {
            drawBackdropEffect(canvas, this.mTextureLayer, this.mRect.left, this.mRect.top);
        }
    }
}
