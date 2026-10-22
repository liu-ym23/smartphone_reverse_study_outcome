package com.bumptech.glide.load.resource.gif;

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
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class GifDrawable extends Drawable implements GifFrameLoader.FrameCallback, Animatable, Animatable2Compat {
    private static final int GRAVITY = 119;
    public static final int LOOP_FOREVER = -1;
    public static final int LOOP_INTRINSIC = 0;
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
    private final GifState state;

    public static final class GifState extends Drawable.ConstantState {

        @VisibleForTesting
        final GifFrameLoader frameLoader;

        public GifState(GifFrameLoader r10) {
            this.frameLoader = r10;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources r10) {
            return newDrawable();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new GifDrawable(this);
        }
    }

    @Deprecated
    public GifDrawable(Context r10, GifDecoder r11, BitmapPool r12, Transformation<Bitmap> r13, int r14, int r15, Bitmap r16) {
        this(r10, r11, r13, r14, r15, r16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Drawable.Callback findCallback() {
        Drawable.Callback r10 = getCallback();
    L4:
        if ((r10 instanceof Drawable) == false) goto L6;
        r10 = ((Drawable) r10).getCallback();
        goto L4
    L6:
        return r10;
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
        List<Animatable2Compat.AnimationCallback> r10 = this.animationCallbacks;
        if (r10 == null) goto L7;
        int r11 = r10.size();
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L9;
        this.animationCallbacks.get(r12).onAnimationEnd(this);
        r12 = r12 + 1;
        goto L5
    L9:
        return;
    }

    private void resetLoopCount() {
        this.loopCount = 0;
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

    private void stopRunning() {
        this.isRunning = false;
        this.state.frameLoader.unsubscribe(this);
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        List<Animatable2Compat.AnimationCallback> r10 = this.animationCallbacks;
        if (r10 == null) goto L6;
        r10.clear();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas r10) {
        if (this.isRecycled == false) goto L6;
        return;
    L6:
        if (this.applyGravity == false) goto L8;
        Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), getDestRect());
        this.applyGravity = false;
    L8:
        r10.drawBitmap(this.state.frameLoader.getCurrentFrame(), null, getDestRect(), getPaint());
    }

    public ByteBuffer getBuffer() {
        return this.state.frameLoader.getBuffer();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.state;
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

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.state.frameLoader.getWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public int getSize() {
        return this.state.frameLoader.getSize();
    }

    public boolean isRecycled() {
        return this.isRecycled;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.isRunning;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r10) {
        super.onBoundsChange(r10);
        this.applyGravity = true;
    }

    @Override // com.bumptech.glide.load.resource.gif.GifFrameLoader.FrameCallback
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
        int r10 = this.maxLoopCount;
        if (r10 != (-1)) goto L12;
        return;
    L12:
        if (this.loopCount < r10) goto L16;
        notifyAnimationEndToListeners();
        stop();
        return;
    }

    public void recycle() {
        this.isRecycled = true;
        this.state.frameLoader.clear();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.animationCallbacks != null) goto L7;
        this.animationCallbacks = new ArrayList();
    L7:
        this.animationCallbacks.add(r10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r10) {
        getPaint().setAlpha(r10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r10) {
        getPaint().setColorFilter(r10);
    }

    public void setFrameTransformation(Transformation<Bitmap> r10, Bitmap r11) {
        this.state.frameLoader.setFrameTransformation(r10, r11);
    }

    public void setIsRunning(boolean r10) {
        this.isRunning = r10;
    }

    public void setLoopCount(int r10) {
        int r11 = -1;
        if (r10 > 0) goto L9;
        if (r10 == (-1)) goto L9;
        if (r10 == 0) goto L9;
        throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
    L9:
        if (r10 != 0) goto L15;
        int r12 = this.state.frameLoader.getLoopCount();
        if (r12 == 0) goto L14;
        r11 = r12;
    L14:
        this.maxLoopCount = r11;
        return;
    L15:
        this.maxLoopCount = r10;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r10, boolean r11) {
        Preconditions.checkArgument(!this.isRecycled, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.isVisible = r10;
        if (r10 == true) goto L6;
        stopRunning();
    L9:
        return super.setVisible(r10, r11);
    L6:
        if (this.isStarted == false) goto L9;
        startRunning();
        goto L9
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.isStarted = true;
        resetLoopCount();
        if (this.isVisible == false) goto L6;
        startRunning();
        return;
    }

    public void startFromFirstFrame() {
        Preconditions.checkArgument(!this.isRunning, "You cannot restart a currently running animation.");
        this.state.frameLoader.setNextStartFromFirstFrame();
        start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.isStarted = false;
        stopRunning();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback r10) {
        List<Animatable2Compat.AnimationCallback> r11 = this.animationCallbacks;
        if (r11 == null) goto L8;
        if (r10 != null) goto L7;
        return false;
    L7:
        return r11.remove(r10);
    L8:
        return false;
    }

    public GifDrawable(Context r10, GifDecoder r11, Transformation<Bitmap> r12, int r13, int r14, Bitmap r15) {
        this(new GifState(new GifFrameLoader(Glide.get(r10), r11, r13, r14, r12, r15)));
    }

    public GifDrawable(GifState r10) {
        this.isVisible = true;
        this.maxLoopCount = -1;
        this.state = (GifState) Preconditions.checkNotNull(r10);
    }

    @VisibleForTesting
    public GifDrawable(GifFrameLoader r10, Paint r11) {
        this(new GifState(r10));
        this.paint = r11;
    }
}
