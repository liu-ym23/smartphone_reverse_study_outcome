package com.android.server.accessibility.magnification;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class MagnificationThumbnail {
    private static final float ASPECT_RATIO = 14.0f;
    private static final float BG_ASPECT_RATIO = 7.0f;
    private static final boolean DEBUG = false;
    private static final int FADE_IN_ANIMATION_DURATION_MS = 200;
    private static final int FADE_OUT_ANIMATION_DURATION_MS = 1000;
    private static final int LINGER_DURATION_MS = 500;
    private static final String LOG_TAG = "MagnificationThumbnail";
    private final WindowManager.LayoutParams mBackgroundParams;
    private final Context mContext;
    private final Handler mHandler;
    private boolean mIsFadingIn;
    private ObjectAnimator mThumbnailAnimator;
    private int mThumbnailHeight;
    public FrameLayout mThumbnailLayout;
    private View mThumbnailView;
    private int mThumbnailWidth;
    private boolean mVisible;
    private Rect mWindowBounds;
    private final WindowManager mWindowManager;

    /* JADX INFO: renamed from: $r8$lambda$1nWNX5bVLPaEfrFIFFmnm-_LZNY, reason: not valid java name */
    public static /* synthetic */ void m858$r8$lambda$1nWNX5bVLPaEfrFIFFmnm_LZNY(MagnificationThumbnail r0) {
        r0.hideThumbnailMainThread();
    }

    /* JADX INFO: renamed from: $r8$lambda$I-4gBgrQ0cM2UVSC7KLnPPkal38, reason: not valid java name */
    public static /* synthetic */ void m859$r8$lambda$I4gBgrQ0cM2UVSC7KLnPPkal38(MagnificationThumbnail r0) {
        r0.createThumbnailLayout();
    }

    /* JADX INFO: renamed from: $r8$lambda$L2CEXki1l_vjX--KmHCsZbLoBH8, reason: not valid java name */
    public static /* synthetic */ void m860$r8$lambda$L2CEXki1l_vjXKmHCsZbLoBH8(MagnificationThumbnail r0, float r1, float r2, float r3) {
        r0.lambda$updateThumbnail$1(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$vF66b_YC5QttXZZCbw93bIkfI4A(MagnificationThumbnail r0, Rect r1, float r2, float r3, float r4) {
        r0.lambda$setThumbnailBounds$0(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVisible, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m861$$Nest$fgetmVisible(MagnificationThumbnail r0) {
        return r0.mVisible;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWindowManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ WindowManager m862$$Nest$fgetmWindowManager(MagnificationThumbnail r0) {
        return r0.mWindowManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmVisible, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m863$$Nest$fputmVisible(MagnificationThumbnail r0, boolean r1) {
        r0.mVisible = r1;
    }

    public MagnificationThumbnail(Context context, WindowManager windowManager, Handler handler) {
        this.mVisible = false;
        this.mContext = context;
        this.mWindowManager = windowManager;
        this.mHandler = handler;
        this.mWindowBounds = this.mWindowManager.getCurrentWindowMetrics().getBounds();
        this.mBackgroundParams = createLayoutParams();
        this.mThumbnailWidth = 0;
        this.mThumbnailHeight = 0;
        this.mHandler.post(new MagnificationThumbnail$$ExternalSyntheticLambda2(this));
    }

    private void createThumbnailLayout() {
        this.mThumbnailLayout = (FrameLayout) LayoutInflater.from(this.mContext).inflate(17367509, null);
        this.mThumbnailView = this.mThumbnailLayout.findViewById(R.id.accessibility_magnification_thumbnail_view);
    }

    public void setThumbnailBounds(final Rect currentBounds, final float scale, final float centerX, final float centerY) {
        this.mHandler.post(new MagnificationThumbnail$$ExternalSyntheticLambda1(this, currentBounds, scale, centerX, centerY));
    }

    private /* synthetic */ void lambda$setThumbnailBounds$0(Rect currentBounds, float scale, float centerX, float centerY) {
        refreshBackgroundBounds(currentBounds);
        if (this.mVisible == false) goto L6;
        updateThumbnailMainThread(scale, centerX, centerY);
        return;
    }

    private void refreshBackgroundBounds(Rect currentBounds) {
        this.mWindowBounds = currentBounds;
        Point magnificationBoundary = getMagnificationThumbnailPadding(this.mContext);
        this.mThumbnailWidth = (int) (this.mWindowBounds.width() / BG_ASPECT_RATIO);
        this.mThumbnailHeight = (int) (this.mWindowBounds.height() / BG_ASPECT_RATIO);
        int initX = magnificationBoundary.x;
        int initY = magnificationBoundary.y;
        this.mBackgroundParams.width = this.mThumbnailWidth;
        this.mBackgroundParams.height = this.mThumbnailHeight;
        this.mBackgroundParams.x = initX;
        this.mBackgroundParams.y = initY;
        if (this.mVisible == false) goto L6;
        this.mWindowManager.updateViewLayout(this.mThumbnailLayout, this.mBackgroundParams);
        return;
    }

    private void showThumbnail() {
        animateThumbnail(true);
    }

    public void hideThumbnail() {
        this.mHandler.post(new MagnificationThumbnail$$ExternalSyntheticLambda0(this));
    }

    private void hideThumbnailMainThread() {
        if (this.mVisible == false) goto L6;
        animateThumbnail(false);
        return;
    }

    private void animateThumbnail(final boolean fadeIn) {
        this.mHandler.removeCallbacks(new MagnificationThumbnail$$ExternalSyntheticLambda0(this));
        if (fadeIn == false) goto L6;
        this.mHandler.postDelayed(new MagnificationThumbnail$$ExternalSyntheticLambda0(this), 500);
    L6:
        if (fadeIn != this.mIsFadingIn) goto L8;
        return;
    L8:
        this.mIsFadingIn = fadeIn;
        if (fadeIn == false) goto L14;
        if (this.mVisible == true) goto L14;
        this.mWindowManager.addView(this.mThumbnailLayout, this.mBackgroundParams);
        this.mVisible = true;
    L14:
        if (this.mThumbnailAnimator == null) goto L16;
        this.mThumbnailAnimator.cancel();
    L16:
        FrameLayout r1 = this.mThumbnailLayout;
        if (fadeIn == false) goto L19;
        float r2 = 1.0f;
    L20:
        this.mThumbnailAnimator = ObjectAnimator.ofFloat(r1, "alpha", new float[]{r2});
        ObjectAnimator r0 = this.mThumbnailAnimator;
        if (fadeIn == false) goto L23;
        long r3 = 200;
    L24:
        r0.setDuration(r3);
        this.mThumbnailAnimator.addListener(new AnonymousClass1(this, fadeIn));
        this.mThumbnailAnimator.start();
        return;
    L23:
        r3 = 1000;
        goto L24
    L19:
        r2 = 0.0f;
        goto L20
    }

    private /* synthetic */ void lambda$updateThumbnail$1(float scale, float centerX, float centerY) {
        updateThumbnailMainThread(scale, centerX, centerY);
    }

    public void updateThumbnail(final float scale, final float centerX, final float centerY) {
        this.mHandler.post(new MagnificationThumbnail$$ExternalSyntheticLambda3(this, scale, centerX, centerY));
    }

    private void updateThumbnailMainThread(float scale, float centerX, float centerY) {
        showThumbnail();
        if (Float.isNaN(scale) == false) goto L5;
        float scaleDown = this.mThumbnailView.getScaleX();
    L7:
        if (Float.isNaN(scale) == true) goto L10;
        this.mThumbnailView.setScaleX(scaleDown);
        this.mThumbnailView.setScaleY(scaleDown);
    L10:
        if (Float.isNaN(centerX) == false) goto L12;
        return;
    L12:
        if (Float.isNaN(centerY) == false) goto L14;
        return;
    L14:
        if (this.mThumbnailWidth > 0) goto L16;
        return;
    L16:
        if (this.mThumbnailHeight <= 0) goto L22;
        int padding = this.mThumbnailView.getPaddingTop();
        float centerXScaled = (centerX * 0.14285715f) - ((this.mThumbnailWidth / 2.0f) + padding);
        float centerYScaled = (centerY * 0.14285715f) - ((this.mThumbnailHeight / 2.0f) + padding);
        this.mThumbnailView.setTranslationX(centerXScaled);
        this.mThumbnailView.setTranslationY(centerYScaled);
        return;
    L22:
        return;
    L5:
        scaleDown = 1.0f / scale;
        goto L7
    }

    private WindowManager.LayoutParams createLayoutParams() {
        WindowManager.LayoutParams params = new WindowManager.LayoutParams(-2, -2, 2027, 24, -2);
        params.inputFeatures = 1;
        params.gravity = 83;
        params.setFitInsetsTypes(WindowInsets.Type.ime() | WindowInsets.Type.navigationBars());
        return params;
    }

    private Point getMagnificationThumbnailPadding(Context context) {
        Point thumbnailPaddings = new Point(0, 0);
        int defaultPadding = this.mContext.getResources().getDimensionPixelSize(R.dimen.accessibility_magnification_thumbnail_padding);
        thumbnailPaddings.x = defaultPadding;
        thumbnailPaddings.y = defaultPadding;
        return thumbnailPaddings;
    }
}
