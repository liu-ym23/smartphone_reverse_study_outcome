package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.manager.FontAssetManager;
import com.airbnb.lottie.manager.ImageAssetManager;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.CompositionLayer;
import com.airbnb.lottie.parser.LayerParser;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.LottieThreadFactory;
import com.airbnb.lottie.utils.LottieValueAnimator;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import com.bytedance.librarian.LibrarianImpl;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class LottieDrawable extends Drawable implements Drawable.Callback, Animatable {
    public static final int INFINITE = -1;
    private static final float MAX_DELTA_MS_ASYNC_SET_PROGRESS = 50.0f;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;
    private static final Executor setProgressExecutor = null;
    private int alpha;
    private final LottieValueAnimator animator;
    private AsyncUpdates asyncUpdates;
    private Rect canvasClipBounds;
    private RectF canvasClipBoundsRectF;
    private boolean clipToCompositionBounds;
    private LottieComposition composition;
    private CompositionLayer compositionLayer;
    String defaultFontFileExtension;
    private boolean enableMergePaths;
    FontAssetDelegate fontAssetDelegate;
    private FontAssetManager fontAssetManager;
    private Map<String, Typeface> fontMap;
    private boolean ignoreSystemAnimationsDisabled;
    private ImageAssetDelegate imageAssetDelegate;
    private ImageAssetManager imageAssetManager;
    private String imageAssetsFolder;
    private boolean isApplyingOpacityToLayersEnabled;
    private boolean isDirty;
    private float lastDrawnProgress;
    private final ArrayList<LazyCompositionTask> lazyCompositionTasks;
    private boolean maintainOriginalImageBounds;
    private OnVisibleAction onVisibleAction;
    private boolean outlineMasksAndMattes;
    private boolean performanceTrackingEnabled;
    private final ValueAnimator.AnimatorUpdateListener progressUpdateListener;
    private RenderMode renderMode;
    private final Matrix renderingMatrix;
    private boolean safeMode;
    private final Semaphore setProgressDrawLock;
    private Bitmap softwareRenderingBitmap;
    private Canvas softwareRenderingCanvas;
    private Rect softwareRenderingDstBoundsRect;
    private RectF softwareRenderingDstBoundsRectF;
    private Matrix softwareRenderingOriginalCanvasMatrix;
    private Matrix softwareRenderingOriginalCanvasMatrixInverse;
    private Paint softwareRenderingPaint;
    private Rect softwareRenderingSrcBoundsRect;
    private RectF softwareRenderingTransformedBounds;
    private boolean systemAnimationsEnabled;
    TextDelegate textDelegate;
    private final Runnable updateProgressRunnable;
    private boolean useSoftwareRendering;

    private interface LazyCompositionTask {
        void run(LottieComposition r1);
    }

    private static final enum OnVisibleAction extends Enum<OnVisibleAction> {
        private static final /* synthetic */ OnVisibleAction[] $VALUES = null;
        public static final OnVisibleAction NONE = null;
        public static final OnVisibleAction PLAY = null;
        public static final OnVisibleAction RESUME = null;

        private static /* synthetic */ OnVisibleAction[] $values() {
            return new OnVisibleAction[]{NONE, PLAY, RESUME};
        }

        private OnVisibleAction(String r1, int r2) {
            super(r1, r2);
        }

        public static OnVisibleAction valueOf(String r1) {
            return (OnVisibleAction) Enum.valueOf(OnVisibleAction.class, r1);
        }

        public static OnVisibleAction[] values() {
            return (OnVisibleAction[]) $VALUES.clone();
        }

        static {
            NONE = new OnVisibleAction("NONE", 0);
            PLAY = new OnVisibleAction("PLAY", 1);
            RESUME = new OnVisibleAction("RESUME", 2);
            $VALUES = $values();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RepeatMode {
    }

    @Deprecated
    public void disableExtraScaleModeInFitXY() {
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    /* JADX INFO: renamed from: lambda$new$0$com-airbnb-lottie-LottieDrawable, reason: not valid java name */
    /* synthetic */ void m103lambda$new$0$comairbnblottieLottieDrawable(ValueAnimator r1) {
        if (getAsyncUpdatesEnabled() == false) goto L5;
        invalidateSelf();
        return;
    L5:
        CompositionLayer r2 = this.compositionLayer;
        if (r2 == null) goto L10;
        r2.setProgress(this.animator.getAnimatedValueAbsolute());
        return;
    }

    static {
        setProgressExecutor = new ThreadPoolExecutor(0, 2, 35, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new LottieThreadFactory());
    }

    /* JADX INFO: renamed from: lambda$new$1$com-airbnb-lottie-LottieDrawable, reason: not valid java name */
    /* synthetic */ void m104lambda$new$1$comairbnblottieLottieDrawable() {
        CompositionLayer r0 = this.compositionLayer;
        if (r0 != null) goto L13;
        return;
    L13:
        this.setProgressDrawLock.acquire();     // Catch: Throwable -> L7 InterruptedException -> L12
        r0.setProgress(this.animator.getAnimatedValueAbsolute());     // Catch: Throwable -> L7 InterruptedException -> L12
    L7:
        th = move-exception;
        this.setProgressDrawLock.release();
        throw th;
    L10:
        this.setProgressDrawLock.release();
    }

    public LottieDrawable() {
        LottieValueAnimator r0 = new LottieValueAnimator();
        this.animator = r0;
        this.systemAnimationsEnabled = true;
        this.ignoreSystemAnimationsDisabled = false;
        this.safeMode = false;
        this.onVisibleAction = OnVisibleAction.NONE;
        this.lazyCompositionTasks = new ArrayList();
        this.maintainOriginalImageBounds = false;
        this.clipToCompositionBounds = true;
        this.alpha = 255;
        this.renderMode = RenderMode.AUTOMATIC;
        this.useSoftwareRendering = false;
        this.renderingMatrix = new Matrix();
        this.asyncUpdates = AsyncUpdates.AUTOMATIC;
        ValueAnimator.AnimatorUpdateListener r3 = new LottieDrawable$$ExternalSyntheticLambda0(this);
        this.progressUpdateListener = r3;
        this.setProgressDrawLock = new Semaphore(1);
        this.updateProgressRunnable = new LottieDrawable$$ExternalSyntheticLambda8(this);
        this.lastDrawnProgress = -3.4028235E38f;
        this.isDirty = false;
        r0.addUpdateListener(r3);
    }

    public boolean hasMasks() {
        CompositionLayer r0 = this.compositionLayer;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.hasMasks() == false) goto L7;
        return true;
    }

    public boolean hasMatte() {
        CompositionLayer r0 = this.compositionLayer;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.hasMatte() == false) goto L7;
        return true;
    }

    public boolean enableMergePathsForKitKatAndAbove() {
        return this.enableMergePaths;
    }

    public void enableMergePathsForKitKatAndAbove(boolean r2) {
        if (this.enableMergePaths != r2) goto L5;
        return;
    L5:
        this.enableMergePaths = r2;
        if (this.composition == null) goto L9;
        buildCompositionLayer();
        return;
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.enableMergePaths;
    }

    public void setClipToCompositionBounds(boolean r2) {
        if (r2 == this.clipToCompositionBounds) goto L9;
        this.clipToCompositionBounds = r2;
        CompositionLayer r0 = this.compositionLayer;
        if (r0 == null) goto L7;
        r0.setClipToCompositionBounds(r2);
    L7:
        invalidateSelf();
        return;
    }

    public boolean getClipToCompositionBounds() {
        return this.clipToCompositionBounds;
    }

    public void setImagesAssetsFolder(String r1) {
        this.imageAssetsFolder = r1;
    }

    public String getImageAssetsFolder() {
        return this.imageAssetsFolder;
    }

    public void setMaintainOriginalImageBounds(boolean r1) {
        this.maintainOriginalImageBounds = r1;
    }

    public boolean getMaintainOriginalImageBounds() {
        return this.maintainOriginalImageBounds;
    }

    public boolean setComposition(LottieComposition r4) {
        if (this.composition != r4) goto L6;
        return false;
    L6:
        this.isDirty = true;
        clearComposition();
        this.composition = r4;
        buildCompositionLayer();
        this.animator.setComposition(r4);
        setProgress(this.animator.getAnimatedFraction());
        Iterator r1 = new ArrayList(this.lazyCompositionTasks).iterator();
    L8:
        if (r1.hasNext() == false) goto L13;
        LazyCompositionTask r2 = (LazyCompositionTask) r1.next();
        if (r2 == null) goto L12;
        r2.run(r4);
    L12:
        r1.remove();
        goto L8
    L13:
        this.lazyCompositionTasks.clear();
        r4.setPerformanceTrackingEnabled(this.performanceTrackingEnabled);
        computeRenderMode();
        Drawable.Callback r5 = getCallback();
        if ((r5 instanceof ImageView) == false) goto L16;
        ImageView r6 = (ImageView) r5;
        r6.setImageDrawable(null);
        r6.setImageDrawable(this);
    L16:
        return true;
    }

    public void setRenderMode(RenderMode r1) {
        this.renderMode = r1;
        computeRenderMode();
    }

    public AsyncUpdates getAsyncUpdates() {
        return this.asyncUpdates;
    }

    public boolean getAsyncUpdatesEnabled() {
        if (this.asyncUpdates != AsyncUpdates.ENABLED) goto L5;
        return true;
    L5:
        return false;
    }

    public void setAsyncUpdates(AsyncUpdates r1) {
        this.asyncUpdates = r1;
    }

    public RenderMode getRenderMode() {
        if (this.useSoftwareRendering == false) goto L6;
        return RenderMode.SOFTWARE;
    L6:
        return RenderMode.HARDWARE;
    }

    private void computeRenderMode() {
        LottieComposition r0 = this.composition;
        if (r0 != null) goto L5;
        return;
    L5:
        this.useSoftwareRendering = this.renderMode.useSoftwareRendering(Build.VERSION.SDK_INT, r0.hasDashPattern(), r0.getMaskAndMatteCount());
    }

    public void setPerformanceTrackingEnabled(boolean r1) {
        this.performanceTrackingEnabled = r1;
        LottieComposition r0 = this.composition;
        if (r0 == null) goto L6;
        r0.setPerformanceTrackingEnabled(r1);
        return;
    }

    public void setOutlineMasksAndMattes(boolean r2) {
        if (this.outlineMasksAndMattes != r2) goto L5;
        return;
    L5:
        this.outlineMasksAndMattes = r2;
        CompositionLayer r1 = this.compositionLayer;
        if (r1 == null) goto L9;
        r1.setOutlineMasksAndMattes(r2);
        return;
    }

    public PerformanceTracker getPerformanceTracker() {
        LottieComposition r0 = this.composition;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getPerformanceTracker();
    }

    public void setApplyingOpacityToLayersEnabled(boolean r1) {
        this.isApplyingOpacityToLayersEnabled = r1;
    }

    public boolean isApplyingOpacityToLayersEnabled() {
        return this.isApplyingOpacityToLayersEnabled;
    }

    private void buildCompositionLayer() {
        LottieComposition r0 = this.composition;
        if (r0 != null) goto L5;
        return;
    L5:
        CompositionLayer r1 = new CompositionLayer(this, LayerParser.parse(r0), r0.getLayers(), r0);
        this.compositionLayer = r1;
        if (this.outlineMasksAndMattes == false) goto L8;
        r1.setOutlineMasksAndMattes(true);
    L8:
        this.compositionLayer.setClipToCompositionBounds(this.clipToCompositionBounds);
    }

    public void clearComposition() {
        if (this.animator.isRunning() == false) goto L7;
        this.animator.cancel();
        if (isVisible() == true) goto L7;
        this.onVisibleAction = OnVisibleAction.NONE;
    L7:
        this.composition = null;
        this.compositionLayer = null;
        this.imageAssetManager = null;
        this.lastDrawnProgress = -3.4028235E38f;
        this.animator.clearComposition();
        invalidateSelf();
    }

    public void setSafeMode(boolean r1) {
        this.safeMode = r1;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.isDirty == false) goto L5;
        return;
    L5:
        this.isDirty = true;
        Drawable.Callback r0 = getCallback();
        if (r0 == null) goto L9;
        r0.invalidateDrawable(this);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r1) {
        this.alpha = r1;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.alpha;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r1) {
        Logger.warning("Use addColorFilter instead.");
    }

    private boolean shouldSetProgressBeforeDrawing() {
        LottieComposition r0 = this.composition;
        if (r0 != null) goto L5;
        return false;
    L5:
        float r2 = this.lastDrawnProgress;
        float r3 = this.animator.getAnimatedValueAbsolute();
        this.lastDrawnProgress = r3;
        float r4 = r0.getDuration();
        if ((Math.abs(r3 - r2) * r4) < 50.0f) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r5) {
        CompositionLayer r0 = this.compositionLayer;
        if (r0 != null) goto L5;
        return;
    L5:
        boolean r1 = getAsyncUpdatesEnabled();
        if (r1 == true) goto L49;
    L10:
        L.beginSection("Drawable#draw");     // Catch: Throwable -> L8 InterruptedException -> L40
        if (r1 == false) goto L16;
        if (shouldSetProgressBeforeDrawing() == false) goto L16;
        setProgress(this.animator.getAnimatedValueAbsolute());     // Catch: Throwable -> L8 InterruptedException -> L40
    L16:
        if (this.safeMode == false) goto L25;
    L22:
        th = move-exception;
        Logger.error("Lottie crashed in draw!", th);     // Catch: Throwable -> L8 InterruptedException -> L40
    L28:
        this.isDirty = false;     // Catch: Throwable -> L8 InterruptedException -> L40
        L.endSection("Drawable#draw");
        if (r1 == false) goto L51;
        this.setProgressDrawLock.release();
        if (r0.getProgress() == this.animator.getAnimatedValueAbsolute()) goto L52;
    L44:
        setProgressExecutor.execute(this.updateProgressRunnable);
        return;
    L52:
        return;
    L51:
        return;
    L40:
        L.endSection("Drawable#draw");
        if (r1 == false) goto L53;
        this.setProgressDrawLock.release();
        if (r0.getProgress() != this.animator.getAnimatedValueAbsolute()) goto L44;
        return;
    L53:
        return;
    L8:
        th = move-exception;
        L.endSection("Drawable#draw");
        if (r1 == false) goto L39;
        this.setProgressDrawLock.release();
        if (r0.getProgress() == this.animator.getAnimatedValueAbsolute()) goto L39;
        setProgressExecutor.execute(this.updateProgressRunnable);
    L39:
        throw th;
    L18:
        if (this.useSoftwareRendering == false) goto L20;
        renderAndDrawAsBitmap(r5, r0);     // Catch: Throwable -> L22
    L46:
    L20:
        drawDirectlyToCanvas(r5);     // Catch: Throwable -> L22
        goto L46
    L25:
        if (this.useSoftwareRendering == false) goto L27;
        renderAndDrawAsBitmap(r5, r0);     // Catch: Throwable -> L8 InterruptedException -> L40
        goto L28
    L27:
        drawDirectlyToCanvas(r5);     // Catch: Throwable -> L8 InterruptedException -> L40
        goto L28
    L49:
        this.setProgressDrawLock.acquire();     // Catch: Throwable -> L8 InterruptedException -> L40
        goto L10
    }

    public void draw(Canvas r4, Matrix r5) {
        CompositionLayer r0 = this.compositionLayer;
        LottieComposition r1 = this.composition;
        if (r0 == null) goto L33;
        if (r1 == null) goto L38;
        boolean r2 = getAsyncUpdatesEnabled();
        if (r2 == false) goto L12;
        this.setProgressDrawLock.acquire();     // Catch: Throwable -> L20 InterruptedException -> L26
        if (shouldSetProgressBeforeDrawing() == false) goto L12;
        setProgress(this.animator.getAnimatedValueAbsolute());     // Catch: Throwable -> L20 InterruptedException -> L26
    L26:
        if (r2 == false) goto L36;
        this.setProgressDrawLock.release();
        if (r0.getProgress() == this.animator.getAnimatedValueAbsolute()) goto L37;
    L29:
        setProgressExecutor.execute(this.updateProgressRunnable);
        return;
    L37:
        return;
    L36:
        return;
    L20:
        th = move-exception;
        if (r2 == false) goto L25;
        this.setProgressDrawLock.release();
        if (r0.getProgress() == this.animator.getAnimatedValueAbsolute()) goto L25;
        setProgressExecutor.execute(this.updateProgressRunnable);
    L25:
        throw th;
    L12:
        if (this.useSoftwareRendering == false) goto L14;
        r4.save();     // Catch: Throwable -> L20 InterruptedException -> L26
        r4.concat(r5);     // Catch: Throwable -> L20 InterruptedException -> L26
        renderAndDrawAsBitmap(r4, r0);     // Catch: Throwable -> L20 InterruptedException -> L26
        r4.restore();     // Catch: Throwable -> L20 InterruptedException -> L26
    L15:
        this.isDirty = false;     // Catch: Throwable -> L20 InterruptedException -> L26
        if (r2 == false) goto L34;
        this.setProgressDrawLock.release();
        if (r0.getProgress() != this.animator.getAnimatedValueAbsolute()) goto L29;
        return;
    L34:
        return;
    L14:
        r0.draw(r4, r5, this.alpha);     // Catch: Throwable -> L20 InterruptedException -> L26
        goto L15
    L38:
        return;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable.Callback r0 = getCallback();
        if ((r0 instanceof View) == true) goto L5;
    L7:
        playAnimation();
        return;
    L5:
        if (((View) r0).isInEditMode() == false) goto L7;
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        endAnimation();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return isAnimating();
    }

    public void playAnimation() {
        if (this.compositionLayer != null) goto L6;
        this.lazyCompositionTasks.add(new LottieDrawable$$ExternalSyntheticLambda4(this));
        return;
    L6:
        computeRenderMode();
        if (animationsEnabled() == true) goto L11;
        if (getRepeatCount() == 0) goto L11;
    L15:
        if (animationsEnabled() == false) goto L17;
        return;
    L17:
        if (getSpeed() >= 0.0f) goto L19;
        float r0 = getMinFrame();
    L20:
        setFrame((int) r0);
        this.animator.endAnimation();
        if (isVisible() == true) goto L25;
        this.onVisibleAction = OnVisibleAction.NONE;
        return;
    L25:
        return;
    L19:
        r0 = getMaxFrame();
    L11:
        if (isVisible() == false) goto L13;
        this.animator.playAnimation();
        this.onVisibleAction = OnVisibleAction.NONE;
        goto L15
    L13:
        this.onVisibleAction = OnVisibleAction.PLAY;
        goto L15
    }

    /* JADX INFO: renamed from: lambda$playAnimation$2$com-airbnb-lottie-LottieDrawable, reason: not valid java name */
    /* synthetic */ void m105lambda$playAnimation$2$comairbnblottieLottieDrawable(LottieComposition r1) {
        playAnimation();
    }

    public void endAnimation() {
        this.lazyCompositionTasks.clear();
        this.animator.endAnimation();
        if (isVisible() == true) goto L6;
        this.onVisibleAction = OnVisibleAction.NONE;
        return;
    }

    public void resumeAnimation() {
        if (this.compositionLayer != null) goto L6;
        this.lazyCompositionTasks.add(new LottieDrawable$$ExternalSyntheticLambda14(this));
        return;
    L6:
        computeRenderMode();
        if (animationsEnabled() == true) goto L11;
        if (getRepeatCount() == 0) goto L11;
    L15:
        if (animationsEnabled() == false) goto L17;
        return;
    L17:
        if (getSpeed() >= 0.0f) goto L19;
        float r0 = getMinFrame();
    L20:
        setFrame((int) r0);
        this.animator.endAnimation();
        if (isVisible() == true) goto L25;
        this.onVisibleAction = OnVisibleAction.NONE;
        return;
    L25:
        return;
    L19:
        r0 = getMaxFrame();
    L11:
        if (isVisible() == false) goto L13;
        this.animator.resumeAnimation();
        this.onVisibleAction = OnVisibleAction.NONE;
        goto L15
    L13:
        this.onVisibleAction = OnVisibleAction.RESUME;
        goto L15
    }

    /* JADX INFO: renamed from: lambda$resumeAnimation$3$com-airbnb-lottie-LottieDrawable, reason: not valid java name */
    /* synthetic */ void m106lambda$resumeAnimation$3$comairbnblottieLottieDrawable(LottieComposition r1) {
        resumeAnimation();
    }

    public void setMinFrame(final int r3) {
        if (this.composition != null) goto L6;
        this.lazyCompositionTasks.add(new LottieDrawable$$ExternalSyntheticLambda11(this, r3));
        return;
    L6:
        this.animator.setMinFrame(r3);
    }

    /* JADX INFO: renamed from: lambda$setMinFrame$4$com-airbnb-lottie-LottieDrawable, reason: not valid java name */
    /* synthetic */ void m115lambda$setMinFrame$4$comairbnblottieLottieDrawable(int r1, LottieComposition r2) {
        setMinFrame(r1);
    }

    public float getMinFrame() {
        return this.animator.getMinFrame();
    }

    public void setMinProgress(final float r3) {
        LottieComposition r0 = this.composition;
        if (r0 != null) goto L6;
        this.lazyCompositionTasks.add(new LottieDrawable$$ExternalSyntheticLambda12(this, r3));
        return;
    L6:
        setMinFrame((int) MiscUtils.lerp(r0.getStartFrame(), this.composition.getEndFrame(), r3));
    }

    /* JADX INFO: renamed from: lambda$setMinProgress$5$com-airbnb-lottie-LottieDrawable, reason: not valid java name */
    /* synthetic */ void m117lambda$setMinProgress$5$comairbnblottieLottieDrawable(float r1, LottieComposition r2) {
        setMinProgress(r1);
    }

    public void setMaxFrame(final int r3) {
        if (this.composition != null) goto L6;
        this.lazyCompositionTasks.add(new LottieDrawable$$ExternalSyntheticLambda13(this, r3));
        return;
    L6:
        this.animator.setMaxFrame(r3 + 0.99f);
    }

    /* JADX INFO: renamed from: lambda$setMaxFrame$6$com-airbnb-lottie-LottieDrawable, reason: not valid java name */
    /* synthetic */ void m108lambda$setMaxFrame$6$comairbnblottieLottieDrawable(int r1, LottieComposition r2) {
        setMaxFrame(r1);
    }

    public float getMaxFrame() {
        return this.animator.getMaxFrame();
    }

    public void setMaxProgress(final float r3) {
        LottieComposition r0 = this.composition;
        if (r0 != null) goto L6;
        this.lazyCompositionTasks.add(new LottieDrawable$$ExternalSyntheticLambda3(this, r3));
        return;
    L6:
        this.animator.setMaxFrame(MiscUtils.lerp(r0.getStartFrame(), this.composition.getEndFrame(), r3));
    }

    /* JADX INFO: renamed from: lambda$setMaxProgress$7$com-airbnb-lottie-LottieDrawable, reason: not valid java name */
    /* synthetic */ void m110lambda$setMaxProgress$7$comairbnblottieLottieDrawable(float r1, LottieComposition r2) {
        setMaxProgress(r1);
    }

    public void setMinFrame(final String r3) {
        LottieComposition r0 = this.composition;
        if (r0 != null) goto L6;
        this.lazyCompositionTasks.add(new LottieDrawable$$ExternalSyntheticLambda1(this, r3));
        return;
    L6:
        Marker r1 = r0.getMarker(r3);
        if (r1 == null) goto L11;
        setMinFrame((int) r1.startFrame);
        return;
    L11:
        throw new IllegalArgumentException("Cannot find marker with name " + r3 + LibrarianImpl.Constants.DOT);
    }

    /* JADX INFO: renamed from: lambda$setMinFrame$8$com-airbnb-lottie-LottieDrawable, reason: not valid java name */
    /* synthetic */ void m116lambda$setMinFrame$8$comairbnblottieLottieDrawable(String r1, LottieComposition r2) {
        setMinFrame(r1);
    }

    public void setMaxFrame(final String r3) {
        LottieComposition r0 = this.composition;
        if (r0 != null) goto L6;
        this.lazyCompositionTasks.add(new LottieDrawable$$ExternalSyntheticLambda15(this, r3));
        return;
    L6:
        Marker r1 = r0.getMarker(r3);
        if (r1 == null) goto L11;
        setMaxFrame((int) (r1.startFrame + r1.durationFrames));
        return;
    L11:
        throw new IllegalArgumentException("Cannot find marker with name " + r3 + LibrarianImpl.Constants.DOT);
    }

    /* JADX INFO: renamed from: lambda$setMaxFrame$9$com-airbnb-lottie-LottieDrawable, reason: not valid java name */
    /* synthetic */ void m109lambda$setMaxFrame$9$comairbnblottieLottieDrawable(String r1, LottieComposition r2) {
        setMaxFrame(r1);
    }

    public void setMinAndMaxFrame(final String r3) {
        LottieComposition r0 = this.composition;
        if (r0 != null) goto L6;
        this.lazyCompositionTasks.add(new LottieDrawable$$ExternalSyntheticLambda7(this, r3));
        return;
    L6:
        Marker r1 = r0.getMarker(r3);
        if (r1 == null) goto L11;
        int r4 = (int) r1.startFrame;
        setMinAndMaxFrame(r4, ((int) r1.durationFrames) + r4);
        return;
    L11:
        throw new IllegalArgumentException("Cannot find marker with name " + r3 + LibrarianImpl.Constants.DOT);
    }

    /* JADX INFO: renamed from: lambda$setMinAndMaxFrame$10$com-airbnb-lottie-LottieDrawable, reason: not valid java name */
    /* synthetic */ void m111lambda$setMinAndMaxFrame$10$comairbnblottieLottieDrawable(String r1, LottieComposition r2) {
        setMinAndMaxFrame(r1);
    }

    public void setMinAndMaxFrame(final String r4, final String r5, final boolean r6) {
        LottieComposition r0 = this.composition;
        if (r0 != null) goto L6;
        this.lazyCompositionTasks.add(new LottieDrawable$$ExternalSyntheticLambda16(this, r4, r5, r6));
        return;
    L6:
        Marker r1 = r0.getMarker(r4);
        if (r1 == null) goto L19;
        int r7 = (int) r1.startFrame;
        Marker r2 = this.composition.getMarker(r5);
        if (r2 == null) goto L17;
        float r8 = r2.startFrame;
        if (r6 == false) goto L13;
        float r9 = 1.0f;
    L14:
        setMinAndMaxFrame(r7, (int) (r8 + r9));
        return;
    L13:
        r9 = 0.0f;
        goto L14
    L17:
        throw new IllegalArgumentException("Cannot find marker with name " + r5 + LibrarianImpl.Constants.DOT);
    L19:
        throw new IllegalArgumentException("Cannot find marker with name " + r4 + LibrarianImpl.Constants.DOT);
    }

    /* JADX INFO: renamed from: lambda$setMinAndMaxFrame$11$com-airbnb-lottie-LottieDrawable, reason: not valid java name */
    /* synthetic */ void m112lambda$setMinAndMaxFrame$11$comairbnblottieLottieDrawable(String r1, String r2, boolean r3, LottieComposition r4) {
        setMinAndMaxFrame(r1, r2, r3);
    }

    public void setMinAndMaxFrame(final int r3, final int r4) {
        if (this.composition != null) goto L6;
        this.lazyCompositionTasks.add(new LottieDrawable$$ExternalSyntheticLambda6(this, r3, r4));
        return;
    L6:
        this.animator.setMinAndMaxFrames(r3, r4 + 0.99f);
    }

    /* JADX INFO: renamed from: lambda$setMinAndMaxFrame$12$com-airbnb-lottie-LottieDrawable, reason: not valid java name */
    /* synthetic */ void m113lambda$setMinAndMaxFrame$12$comairbnblottieLottieDrawable(int r1, int r2, LottieComposition r3) {
        setMinAndMaxFrame(r1, r2);
    }

    public void setMinAndMaxProgress(final float r3, final float r4) {
        LottieComposition r0 = this.composition;
        if (r0 != null) goto L6;
        this.lazyCompositionTasks.add(new LottieDrawable$$ExternalSyntheticLambda10(this, r3, r4));
        return;
    L6:
        setMinAndMaxFrame((int) MiscUtils.lerp(r0.getStartFrame(), this.composition.getEndFrame(), r3), (int) MiscUtils.lerp(this.composition.getStartFrame(), this.composition.getEndFrame(), r4));
    }

    /* JADX INFO: renamed from: lambda$setMinAndMaxProgress$13$com-airbnb-lottie-LottieDrawable, reason: not valid java name */
    /* synthetic */ void m114lambda$setMinAndMaxProgress$13$comairbnblottieLottieDrawable(float r1, float r2, LottieComposition r3) {
        setMinAndMaxProgress(r1, r2);
    }

    public void reverseAnimationSpeed() {
        this.animator.reverseAnimationSpeed();
    }

    public void setSpeed(float r1) {
        this.animator.setSpeed(r1);
    }

    public float getSpeed() {
        return this.animator.getSpeed();
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener r1) {
        this.animator.addUpdateListener(r1);
    }

    public void removeAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener r1) {
        this.animator.removeUpdateListener(r1);
    }

    public void removeAllUpdateListeners() {
        this.animator.removeAllUpdateListeners();
        this.animator.addUpdateListener(this.progressUpdateListener);
    }

    public void addAnimatorListener(Animator.AnimatorListener r1) {
        this.animator.addListener(r1);
    }

    public void removeAnimatorListener(Animator.AnimatorListener r1) {
        this.animator.removeListener(r1);
    }

    public void removeAllAnimatorListeners() {
        this.animator.removeAllListeners();
    }

    public void addAnimatorPauseListener(Animator.AnimatorPauseListener r1) {
        this.animator.addPauseListener(r1);
    }

    public void removeAnimatorPauseListener(Animator.AnimatorPauseListener r1) {
        this.animator.removePauseListener(r1);
    }

    public void setFrame(final int r3) {
        if (this.composition != null) goto L6;
        this.lazyCompositionTasks.add(new LottieDrawable$$ExternalSyntheticLambda5(this, r3));
        return;
    L6:
        this.animator.setFrame(r3);
    }

    /* JADX INFO: renamed from: lambda$setFrame$14$com-airbnb-lottie-LottieDrawable, reason: not valid java name */
    /* synthetic */ void m107lambda$setFrame$14$comairbnblottieLottieDrawable(int r1, LottieComposition r2) {
        setFrame(r1);
    }

    public int getFrame() {
        return (int) this.animator.getFrame();
    }

    public void setProgress(final float r3) {
        if (this.composition != null) goto L6;
        this.lazyCompositionTasks.add(new LottieDrawable$$ExternalSyntheticLambda9(this, r3));
        return;
    L6:
        L.beginSection("Drawable#setProgress");
        this.animator.setFrame(this.composition.getFrameForProgress(r3));
        L.endSection("Drawable#setProgress");
    }

    /* JADX INFO: renamed from: lambda$setProgress$15$com-airbnb-lottie-LottieDrawable, reason: not valid java name */
    /* synthetic */ void m118lambda$setProgress$15$comairbnblottieLottieDrawable(float r1, LottieComposition r2) {
        setProgress(r1);
    }

    @Deprecated
    public void loop(boolean r1) {
        LottieValueAnimator r0 = this.animator;
        if (r1 == false) goto L5;
        int r2 = -1;
    L6:
        r0.setRepeatCount(r2);
        return;
    L5:
        r2 = 0;
        goto L6
    }

    public void setRepeatMode(int r1) {
        this.animator.setRepeatMode(r1);
    }

    public int getRepeatMode() {
        return this.animator.getRepeatMode();
    }

    public void setRepeatCount(int r1) {
        this.animator.setRepeatCount(r1);
    }

    public int getRepeatCount() {
        return this.animator.getRepeatCount();
    }

    public boolean isLooping() {
        if (this.animator.getRepeatCount() != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isAnimating() {
        LottieValueAnimator r0 = this.animator;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isRunning();
    }

    boolean isAnimatingOrWillAnimateOnVisible() {
        if (isVisible() == false) goto L7;
        return this.animator.isRunning();
    L7:
        if (this.onVisibleAction != OnVisibleAction.PLAY) goto L9;
    L12:
        return true;
    L9:
        if (this.onVisibleAction == OnVisibleAction.RESUME) goto L12;
        return false;
    }

    private boolean animationsEnabled() {
        if (this.systemAnimationsEnabled == false) goto L5;
    L8:
        return true;
    L5:
        if (this.ignoreSystemAnimationsDisabled == true) goto L8;
        return false;
    }

    public void setSystemAnimationsAreEnabled(Boolean r1) {
        this.systemAnimationsEnabled = r1.booleanValue();
    }

    public void setIgnoreDisabledSystemAnimations(boolean r1) {
        this.ignoreSystemAnimationsDisabled = r1;
    }

    public void setUseCompositionFrameRate(boolean r1) {
        this.animator.setUseCompositionFrameRate(r1);
    }

    public void setImageAssetDelegate(ImageAssetDelegate r1) {
        this.imageAssetDelegate = r1;
        ImageAssetManager r0 = this.imageAssetManager;
        if (r0 == null) goto L6;
        r0.setDelegate(r1);
        return;
    }

    public void setFontAssetDelegate(FontAssetDelegate r1) {
        this.fontAssetDelegate = r1;
        FontAssetManager r0 = this.fontAssetManager;
        if (r0 == null) goto L6;
        r0.setDelegate(r1);
        return;
    }

    public void setFontMap(Map<String, Typeface> r2) {
        if (r2 != this.fontMap) goto L5;
        return;
    L5:
        this.fontMap = r2;
        invalidateSelf();
    }

    public void setTextDelegate(TextDelegate r1) {
        this.textDelegate = r1;
    }

    public TextDelegate getTextDelegate() {
        return this.textDelegate;
    }

    public boolean useTextGlyphs() {
        if (this.fontMap == null) goto L5;
    L9:
        return false;
    L5:
        if (this.textDelegate != null) goto L9;
        if (this.composition.getCharacters().size() <= 0) goto L9;
        return true;
    }

    public LottieComposition getComposition() {
        return this.composition;
    }

    public void cancelAnimation() {
        this.lazyCompositionTasks.clear();
        this.animator.cancel();
        if (isVisible() == true) goto L6;
        this.onVisibleAction = OnVisibleAction.NONE;
        return;
    }

    public void pauseAnimation() {
        this.lazyCompositionTasks.clear();
        this.animator.pauseAnimation();
        if (isVisible() == true) goto L6;
        this.onVisibleAction = OnVisibleAction.NONE;
        return;
    }

    public float getProgress() {
        return this.animator.getAnimatedValueAbsolute();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        LottieComposition r0 = this.composition;
        if (r0 != null) goto L6;
        return -1;
    L6:
        return r0.getBounds().width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        LottieComposition r0 = this.composition;
        if (r0 != null) goto L6;
        return -1;
    L6:
        return r0.getBounds().height();
    }

    public List<KeyPath> resolveKeyPath(KeyPath r5) {
        if (this.compositionLayer != null) goto L6;
        Logger.warning("Cannot resolve KeyPath. Composition is not set yet.");
        return Collections.emptyList();
    L6:
        ArrayList r0 = new ArrayList();
        this.compositionLayer.resolveKeyPath(r5, 0, r0, new KeyPath(new String[0]));
        return r0;
    }

    public <T> void addValueCallback(final KeyPath r4, final T r5, final LottieValueCallback<T> r6) {
        if (this.compositionLayer != null) goto L6;
        this.lazyCompositionTasks.add(new LottieDrawable$$ExternalSyntheticLambda2(this, r4, r5, r6));
        return;
    L6:
        boolean r1 = true;
        if (r4 != KeyPath.COMPOSITION) goto L10;
        this.compositionLayer.addValueCallback(r5, r6);
    L17:
        if (r1 == false) goto L23;
        invalidateSelf();
        if (r5 != LottieProperty.TIME_REMAP) goto L24;
        setProgress(getProgress());
        return;
    L24:
        return;
    L23:
        return;
    L10:
        if (r4.getResolvedElement() == null) goto L12;
        r4.getResolvedElement().addValueCallback(r5, r6);
        goto L17
    L12:
        List<KeyPath> r7 = resolveKeyPath(r4);
        int r0 = 0;
    L14:
        if (r0 >= r7.size()) goto L16;
        r7.get(r0).getResolvedElement().addValueCallback(r5, r6);
        r0 = r0 + 1;
        goto L14
    L16:
        r1 = true ^ r7.isEmpty();
        goto L17
    }

    /* JADX INFO: renamed from: lambda$addValueCallback$16$com-airbnb-lottie-LottieDrawable, reason: not valid java name */
    /* synthetic */ void m102lambda$addValueCallback$16$comairbnblottieLottieDrawable(KeyPath r1, Object r2, LottieValueCallback r3, LottieComposition r4) {
        addValueCallback(r1, r2, r3);
    }

    public <T> void addValueCallback(KeyPath r2, T r3, final SimpleLottieValueCallback<T> r4) {
        addValueCallback(r2, r3, new AnonymousClass1(this, r4));
    }

    public Bitmap updateBitmap(String r2, Bitmap r3) {
        ImageAssetManager r0 = getImageAssetManager();
        if (r0 != null) goto L6;
        Logger.warning("Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
        return null;
    L6:
        Bitmap r4 = r0.updateBitmap(r2, r3);
        invalidateSelf();
        return r4;
    }

    @Deprecated
    public Bitmap getImageAsset(String r2) {
        ImageAssetManager r0 = getImageAssetManager();
        if (r0 != null) goto L5;
        LottieComposition r1 = this.composition;
        if (r1 != null) goto L9;
        LottieImageAsset r3 = null;
    L10:
        if (r3 != null) goto L12;
        return null;
    L12:
        return r3.getBitmap();
    L9:
        r3 = r1.getImages().get(r2);
        goto L10
    L5:
        return r0.bitmapForId(r2);
    }

    public Bitmap getBitmapForId(String r1) {
        ImageAssetManager r0 = getImageAssetManager();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.bitmapForId(r1);
    }

    public LottieImageAsset getLottieImageAssetForId(String r1) {
        LottieComposition r0 = this.composition;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getImages().get(r1);
    }

    private ImageAssetManager getImageAssetManager() {
        ImageAssetManager r0 = this.imageAssetManager;
        if (r0 == null) goto L8;
        if (r0.hasSameContext(getContext()) == true) goto L8;
        this.imageAssetManager = null;
    L8:
        if (this.imageAssetManager != null) goto L11;
        this.imageAssetManager = new ImageAssetManager(getCallback(), this.imageAssetsFolder, this.imageAssetDelegate, this.composition.getImages());
    L11:
        return this.imageAssetManager;
    }

    public Typeface getTypeface(Font r4) {
        Map<String, Typeface> r0 = this.fontMap;
        if (r0 == null) goto L16;
        String r1 = r4.getFamily();
        if (r0.containsKey(r1) == true) goto L7;
        String r2 = r4.getName();
        if (r0.containsKey(r2) == true) goto L11;
        String r3 = r4.getFamily() + "-" + r4.getStyle();
        if (r0.containsKey(r3) == false) goto L16;
        return r0.get(r3);
    L11:
        return r0.get(r2);
    L7:
        return r0.get(r1);
    L16:
        FontAssetManager r5 = getFontAssetManager();
        if (r5 != null) goto L19;
        return null;
    L19:
        return r5.getTypeface(r4);
    }

    private FontAssetManager getFontAssetManager() {
        if (getCallback() != null) goto L7;
        return null;
    L7:
        if (this.fontAssetManager != null) goto L12;
        FontAssetManager r0 = new FontAssetManager(getCallback(), this.fontAssetDelegate);
        this.fontAssetManager = r0;
        String r1 = this.defaultFontFileExtension;
        if (r1 == null) goto L12;
        r0.setDefaultFontFileExtension(r1);
    L12:
        return this.fontAssetManager;
    }

    public void setDefaultFontFileExtension(String r1) {
        this.defaultFontFileExtension = r1;
        FontAssetManager r0 = getFontAssetManager();
        if (r0 == null) goto L6;
        r0.setDefaultFontFileExtension(r1);
        return;
    }

    private Context getContext() {
        Drawable.Callback r2 = getCallback();
        if (r2 != null) goto L6;
        return null;
    L6:
        if ((r2 instanceof View) == true) goto L8;
        return null;
    L8:
        return ((View) r2).getContext();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r2, boolean r3) {
        boolean r0 = !isVisible();
        boolean r4 = super.setVisible(r2, r3);
        if (r2 == false) goto L11;
        if (this.onVisibleAction != OnVisibleAction.PLAY) goto L8;
        playAnimation();
    L15:
        return r4;
    L8:
        if (this.onVisibleAction != OnVisibleAction.RESUME) goto L15;
        resumeAnimation();
        goto L15
    L11:
        if (this.animator.isRunning() == false) goto L13;
        pauseAnimation();
        this.onVisibleAction = OnVisibleAction.RESUME;
        goto L15
    L13:
        if (r0 == true) goto L15;
        this.onVisibleAction = OnVisibleAction.NONE;
        goto L15
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable r1) {
        Drawable.Callback r2 = getCallback();
        if (r2 != null) goto L5;
        return;
    L5:
        r2.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable r1, Runnable r2, long r3) {
        Drawable.Callback r4 = getCallback();
        if (r4 != null) goto L5;
        return;
    L5:
        r4.scheduleDrawable(this, r2, r3);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable r1, Runnable r2) {
        Drawable.Callback r3 = getCallback();
        if (r3 != null) goto L5;
        return;
    L5:
        r3.unscheduleDrawable(this, r2);
    }

    private void drawDirectlyToCanvas(Canvas r6) {
        CompositionLayer r0 = this.compositionLayer;
        LottieComposition r1 = this.composition;
        if (r0 == null) goto L11;
        if (r1 == null) goto L12;
        this.renderingMatrix.reset();
        Rect r2 = getBounds();
        if (r2.isEmpty() == true) goto L9;
        this.renderingMatrix.preScale(r2.width() / r1.getBounds().width(), r2.height() / r1.getBounds().height());
        this.renderingMatrix.preTranslate(r2.left, r2.top);
    L9:
        r0.draw(r6, this.renderingMatrix, this.alpha);
        return;
    L12:
        return;
    }

    private void renderAndDrawAsBitmap(Canvas r9, CompositionLayer r10) {
        if (this.composition == null) goto L22;
        if (r10 == null) goto L24;
        ensureSoftwareRenderingObjectsInitialized();
        r9.getMatrix(this.softwareRenderingOriginalCanvasMatrix);
        r9.getClipBounds(this.canvasClipBounds);
        convertRect(this.canvasClipBounds, this.canvasClipBoundsRectF);
        this.softwareRenderingOriginalCanvasMatrix.mapRect(this.canvasClipBoundsRectF);
        convertRect(this.canvasClipBoundsRectF, this.canvasClipBounds);
        if (this.clipToCompositionBounds == false) goto L9;
        this.softwareRenderingTransformedBounds.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
    L10:
        this.softwareRenderingOriginalCanvasMatrix.mapRect(this.softwareRenderingTransformedBounds);
        Rect r0 = getBounds();
        float r2 = r0.width() / getIntrinsicWidth();
        float r1 = r0.height() / getIntrinsicHeight();
        scaleRect(this.softwareRenderingTransformedBounds, r2, r1);
        if (ignoreCanvasClipBounds() == true) goto L13;
        this.softwareRenderingTransformedBounds.intersect(this.canvasClipBounds.left, this.canvasClipBounds.top, this.canvasClipBounds.right, this.canvasClipBounds.bottom);
    L13:
        int r3 = (int) Math.ceil(this.softwareRenderingTransformedBounds.width());
        int r4 = (int) Math.ceil(this.softwareRenderingTransformedBounds.height());
        if (r3 == 0) goto L23;
        if (r4 == 0) goto L25;
        ensureSoftwareRenderingBitmap(r3, r4);
        if (this.isDirty == false) goto L20;
        this.renderingMatrix.set(this.softwareRenderingOriginalCanvasMatrix);
        this.renderingMatrix.preScale(r2, r1);
        this.renderingMatrix.postTranslate(-this.softwareRenderingTransformedBounds.left, -this.softwareRenderingTransformedBounds.top);
        this.softwareRenderingBitmap.eraseColor(0);
        r10.draw(this.softwareRenderingCanvas, this.renderingMatrix, this.alpha);
        this.softwareRenderingOriginalCanvasMatrix.invert(this.softwareRenderingOriginalCanvasMatrixInverse);
        this.softwareRenderingOriginalCanvasMatrixInverse.mapRect(this.softwareRenderingDstBoundsRectF, this.softwareRenderingTransformedBounds);
        convertRect(this.softwareRenderingDstBoundsRectF, this.softwareRenderingDstBoundsRect);
    L20:
        this.softwareRenderingSrcBoundsRect.set(0, 0, r3, r4);
        r9.drawBitmap(this.softwareRenderingBitmap, this.softwareRenderingSrcBoundsRect, this.softwareRenderingDstBoundsRect, this.softwareRenderingPaint);
        return;
    L25:
        return;
    L23:
        return;
    L9:
        r10.getBounds(this.softwareRenderingTransformedBounds, null, false);
        goto L10
    L24:
        return;
    }

    private void ensureSoftwareRenderingObjectsInitialized() {
        if (this.softwareRenderingCanvas == null) goto L5;
        return;
    L5:
        this.softwareRenderingCanvas = new Canvas();
        this.softwareRenderingTransformedBounds = new RectF();
        this.softwareRenderingOriginalCanvasMatrix = new Matrix();
        this.softwareRenderingOriginalCanvasMatrixInverse = new Matrix();
        this.canvasClipBounds = new Rect();
        this.canvasClipBoundsRectF = new RectF();
        this.softwareRenderingPaint = new LPaint();
        this.softwareRenderingSrcBoundsRect = new Rect();
        this.softwareRenderingDstBoundsRect = new Rect();
        this.softwareRenderingDstBoundsRectF = new RectF();
    }

    private void ensureSoftwareRenderingBitmap(int r4, int r5) {
        Bitmap r0 = this.softwareRenderingBitmap;
        if (r0 != null) goto L5;
    L14:
        Bitmap r6 = Bitmap.createBitmap(r4, r5, Bitmap.Config.ARGB_8888);
        this.softwareRenderingBitmap = r6;
        this.softwareRenderingCanvas.setBitmap(r6);
        this.isDirty = true;
        return;
    L5:
        if (r0.getWidth() < r4) goto L14;
        if (this.softwareRenderingBitmap.getHeight() < r5) goto L14;
        if (this.softwareRenderingBitmap.getWidth() <= r4) goto L12;
    L13:
        Bitmap r7 = Bitmap.createBitmap(this.softwareRenderingBitmap, 0, 0, r4, r5);
        this.softwareRenderingBitmap = r7;
        this.softwareRenderingCanvas.setBitmap(r7);
        this.isDirty = true;
        return;
    L12:
        if (this.softwareRenderingBitmap.getHeight() > r5) goto L13;
    }

    private void convertRect(RectF r5, Rect r6) {
        r6.set((int) Math.floor(r5.left), (int) Math.floor(r5.top), (int) Math.ceil(r5.right), (int) Math.ceil(r5.bottom));
    }

    private void convertRect(Rect r3, RectF r4) {
        r4.set(r3.left, r3.top, r3.right, r3.bottom);
    }

    private void scaleRect(RectF r3, float r4, float r5) {
        r3.set(r3.left * r4, r3.top * r5, r3.right * r4, r3.bottom * r5);
    }

    private boolean ignoreCanvasClipBounds() {
        Drawable.Callback r2 = getCallback();
        if ((r2 instanceof View) == true) goto L5;
        return false;
    L5:
        ViewParent r3 = ((View) r2).getParent();
        if ((r3 instanceof ViewGroup) == true) goto L8;
        return false;
    L8:
        return !((ViewGroup) r3).getClipChildren();
    }
}
