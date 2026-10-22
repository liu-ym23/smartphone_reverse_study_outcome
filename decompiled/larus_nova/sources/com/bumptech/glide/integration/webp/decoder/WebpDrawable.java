package com.bumptech.glide.integration.webp.decoder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.log.Log;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class WebpDrawable extends Drawable implements WebpFrameLoader.FrameCallback, Animatable, Animatable2Compat {
    private static final int GRAVITY = 119;
    public static final int LOOP_FOREVER = -1;
    public static final int LOOP_INTRINSIC = 0;
    private static final String TAG = "WebpDrawable";
    private List<Animatable2Compat.AnimationCallback> animationCallbacks;
    private boolean applyGravity;
    private Rect destRect;
    private boolean isRecycled;
    private boolean isRunning;
    private boolean isStarted;
    private boolean isVisible;
    private int loopCount;
    private int maxLoopCount;
    private Paint paint;
    private final WebpState state;

    public static class WebpState extends Drawable.ConstantState {
        final BitmapPool bitmapPool;
        final WebpFrameLoader frameLoader;

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new WebpDrawable(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r100) {
            return newDrawable();
        }

        public WebpState(BitmapPool r100, WebpFrameLoader r101) {
            this.bitmapPool = r100;
            this.frameLoader = r101;
        }
    }

    private void resetLoopCount() {
        this.loopCount = 0;
    }

    private void stopRunning() {
        this.isRunning = false;
        this.state.frameLoader.unsubscribe(this);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public void recycle() {
        this.isRecycled = true;
        this.state.frameLoader.clear();
    }

    public void setIsRunning(boolean r100) {
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.isStarted = true;
        resetLoopCount();
        if (this.isVisible == false) goto L6;
        startRunning();
        return;
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.isStarted = false;
        stopRunning();
    }

    private Rect getDestRect() {
        if (this.destRect != null) goto L6;
        this.destRect = new Rect();
    L6:
        return this.destRect;
    }

    private Paint getPaint() {
        if (this.paint != null) goto L6;
        this.paint = new Paint(2);
    L6:
        return this.paint;
    }

    private void notifyAnimationEndToListeners() {
        List<Animatable2Compat.AnimationCallback> r100 = this.animationCallbacks;
        if (r100 == null) goto L7;
        int r101 = r100.size();
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L9;
        ((Animatable2Compat.AnimationCallback) ListProtector.get(this.animationCallbacks, r102)).onAnimationEnd(this);
        r102 = r102 + 1;
        goto L5
    L9:
        return;
    }

    private void startRunning() {
        Preconditions.checkArgument(!this.isRecycled, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.state.frameLoader.getFrameCount() != 1) goto L6;
        invalidateSelf();
        return;
    L6:
        if (this.isRunning == true) goto L10;
        this.isRunning = true;
        this.state.frameLoader.subscribe(this);
        invalidateSelf();
        return;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        List<Animatable2Compat.AnimationCallback> r100 = this.animationCallbacks;
        if (r100 == null) goto L6;
        r100.clear();
        return;
    }

    public ByteBuffer getBuffer() {
        return this.state.frameLoader.getBuffer();
    }

    public Bitmap getFirstFrame() {
        return this.state.frameLoader.getFirstFrame();
    }

    public int getFrameCount() {
        return this.state.frameLoader.getFrameCount();
    }

    public int getFrameIndex() {
        return this.state.frameLoader.getCurrentIndex();
    }

    public Transformation<Bitmap> getFrameTransformation() {
        return this.state.frameLoader.getFrameTransformation();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.state.frameLoader.getHeight();
    }

    public int getIntrinsicLoopCount() {
        return this.state.frameLoader.getLoopCount();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.state.frameLoader.getWidth();
    }

    public int getSize() {
        return this.state.frameLoader.getSize();
    }

    public void startFromFirstFrame() {
        Preconditions.checkArgument(!this.isRunning, "You cannot restart a currently running animation.");
        this.state.frameLoader.setNextStartFromFirstFrame();
        start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Drawable.Callback findCallback() {
        Drawable.Callback r100 = getCallback();
    L4:
        if ((r100 instanceof Drawable) == false) goto L6;
        r100 = ((Drawable) r100).getCallback();
        goto L4
    L6:
        return r100;
    }

    @Override // com.bumptech.glide.integration.webp.decoder.WebpFrameLoader.FrameCallback
    public void onFrameReady() {
        if (findCallback() != null) goto L6;
        stop();
        invalidateSelf();
        return;
    L6:
        invalidateSelf();
        if (getFrameIndex() != (getFrameCount() - 1)) goto L9;
        this.loopCount++;
    L9:
        int r100 = this.maxLoopCount;
        if (r100 != (-1)) goto L12;
        return;
    L12:
        if (this.loopCount < r100) goto L16;
        stop();
        notifyAnimationEndToListeners();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.state;
    }

    public int getLoopCount() {
        return this.maxLoopCount;
    }

    public boolean isRecycled() {
        return this.isRecycled;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.isRunning;
    }

    public WebpDrawable(WebpState r100) {
        this.maxLoopCount = -1;
        this.isVisible = true;
        this.state = (WebpState) Preconditions.checkNotNull(r100);
        setLoopCount(0);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r100) {
        if (isRecycled() == false) goto L6;
        return;
    L6:
        if (this.applyGravity == false) goto L8;
        Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), getDestRect());
        this.applyGravity = false;
    L8:
        Bitmap r101 = this.state.frameLoader.getCurrentFrame();
        if (r101 != null) goto L11;
    L15:
        Log.e(TAG, "currentFrame is null or recycled");
        return;
    L11:
        if (r101.isRecycled() == true) goto L15;
        r100.drawBitmap(r101, null, getDestRect(), getPaint());
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r100) {
        super.onBoundsChange(r100);
        this.applyGravity = true;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(Animatable2Compat.AnimationCallback r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.animationCallbacks != null) goto L7;
        this.animationCallbacks = new ArrayList();
    L7:
        this.animationCallbacks.add(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r100) {
        getPaint().setAlpha(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r100) {
        getPaint().setColorFilter(r100);
    }

    public void setLoopCount(int r100) {
        int r101 = -1;
        if (r100 > 0) goto L9;
        if (r100 == (-1)) goto L9;
        if (r100 == 0) goto L9;
        throw new IllegalArgumentException("Loop count must be greater than 0, or equal to LOOP_FOREVER, or equal to LOOP_INTRINSIC");
    L9:
        if (r100 != 0) goto L15;
        int r102 = this.state.frameLoader.getLoopCount();
        if (r102 == 0) goto L14;
        r101 = r102;
    L14:
        this.maxLoopCount = r101;
        return;
    L15:
        this.maxLoopCount = r100;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(Animatable2Compat.AnimationCallback r100) {
        List<Animatable2Compat.AnimationCallback> r101 = this.animationCallbacks;
        if (r101 == null) goto L8;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r101.remove(r100);
    L8:
        return false;
    }

    public void setFrameTransformation(Transformation<Bitmap> r100, Bitmap r101) {
        this.state.frameLoader.setFrameTransformation(r100, r101);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r100, boolean r101) {
        Preconditions.checkArgument(!this.isRecycled, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.isVisible = r100;
        if (r100 == true) goto L6;
        stopRunning();
    L9:
        return super.setVisible(r100, r101);
    L6:
        if (this.isStarted == false) goto L9;
        startRunning();
        goto L9
    }

    public WebpDrawable(WebpFrameLoader r100, BitmapPool r101, Paint r102) {
        this(new WebpState(r101, r100));
        this.paint = r102;
    }

    public WebpDrawable(Context r110, WebpDecoder r111, BitmapPool r112, Transformation<Bitmap> r113, int r114, int r115, Bitmap r116) {
        this(new WebpState(r112, new WebpFrameLoader(Glide.get(r110), r111, r114, r115, r113, r116)));
    }
}
