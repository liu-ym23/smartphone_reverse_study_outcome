package com.stepos.activeview.elements;

import B0.g;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import com.stepos.activeview.utils.LogUtil;

/* loaded from: classes.dex */
public class GifMovieView extends View implements ActiveAnimation {
    private static final int DEFAULT_MOVIEW_DURATION = 1000;
    private String LOG_TAG;
    private int mCurrentAnimationTime;
    private float mHeightScale;
    private float mLeft;
    private int mMeasuredMovieHeight;
    private int mMeasuredMovieWidth;
    private Movie mMovie;
    private int mMovieResourceId;
    private String mMovieResourcePath;
    private long mMovieStart;
    private volatile boolean mPaused;
    private float mTop;
    private boolean mVisible;
    private float mWidthScale;

    public GifMovieView(Context context) {
        this(context, null);
    }

    private void drawMovieFrame(Canvas canvas) {
        this.mMovie.setTime(this.mCurrentAnimationTime);
        canvas.save();
        canvas.scale(this.mWidthScale, this.mHeightScale);
        this.mMovie.draw(canvas, this.mLeft / this.mWidthScale, this.mTop / this.mHeightScale);
        canvas.restore();
    }

    private void invalidateView() {
        if (this.mVisible) {
            postInvalidateOnAnimation();
        }
    }

    private void setViewAttributes(Context context, AttributeSet attributeSet, int i4) {
        setLayerType(1, null);
        this.mPaused = false;
        if (this.mMovieResourceId != -1) {
            this.mMovie = Movie.decodeStream(getResources().openRawResource(this.mMovieResourceId));
        }
    }

    private void updateAnimationTime() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.mMovieStart == 0) {
            this.mMovieStart = jUptimeMillis;
        }
        int iDuration = this.mMovie.duration();
        if (iDuration == 0) {
            iDuration = 1000;
        }
        this.mCurrentAnimationTime = (int) ((jUptimeMillis - this.mMovieStart) % iDuration);
    }

    public Movie getMovie() {
        return this.mMovie;
    }

    public boolean isPaused() {
        return this.mPaused;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.mMovie != null) {
            if (this.mPaused) {
                drawMovieFrame(canvas);
                return;
            }
            updateAnimationTime();
            drawMovieFrame(canvas);
            invalidateView();
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
        this.mLeft = (getWidth() - this.mMeasuredMovieWidth) / 2.0f;
        this.mTop = (getHeight() - this.mMeasuredMovieHeight) / 2.0f;
        this.mVisible = getVisibility() == 0;
    }

    @Override // android.view.View
    public void onMeasure(int i4, int i5) {
        Movie movie = this.mMovie;
        if (movie == null) {
            setMeasuredDimension(getSuggestedMinimumWidth(), getSuggestedMinimumHeight());
            return;
        }
        int iWidth = movie.width();
        int iHeight = this.mMovie.height();
        if (View.MeasureSpec.getMode(i4) != 0) {
            this.mWidthScale = View.MeasureSpec.getSize(i4) / iWidth;
        }
        if (View.MeasureSpec.getMode(i5) != 0) {
            this.mHeightScale = View.MeasureSpec.getSize(i5) / iHeight;
        }
        this.mMeasuredMovieWidth = View.MeasureSpec.getSize(i4);
        int size = View.MeasureSpec.getSize(i5);
        this.mMeasuredMovieHeight = size;
        setMeasuredDimension(this.mMeasuredMovieWidth, size);
    }

    @Override // android.view.View
    public void onScreenStateChanged(int i4) {
        super.onScreenStateChanged(i4);
        this.mVisible = i4 == 1;
        invalidateView();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i4) {
        super.onVisibilityChanged(view, i4);
        this.mVisible = i4 == 0;
        invalidateView();
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i4) {
        super.onWindowVisibilityChanged(i4);
        this.mVisible = i4 == 0;
        invalidateView();
    }

    public void pause() {
        setPaused(true);
    }

    @Override // com.stepos.activeview.elements.ActiveAnimation
    public void pauseAnimation() {
        pause();
    }

    public void resume() {
        setPaused(false);
    }

    @Override // com.stepos.activeview.elements.ActiveAnimation
    public void resumeAnimation() {
        resume();
    }

    public void setMovie(Movie movie) {
        this.mMovie = movie;
        requestLayout();
    }

    public void setMovieResource(int i4) {
        this.mMovieResourceId = i4;
        this.mMovie = Movie.decodeStream(getResources().openRawResource(this.mMovieResourceId));
        requestLayout();
    }

    public void setMovieTime(int i4) {
        this.mCurrentAnimationTime = i4;
        invalidate();
    }

    public void setPaused(boolean z4) {
        this.mPaused = z4;
        if (!z4) {
            this.mMovieStart = SystemClock.uptimeMillis() - this.mCurrentAnimationTime;
        }
        invalidate();
    }

    public void start() {
        setPaused(false);
    }

    @Override // com.stepos.activeview.elements.ActiveAnimation
    public void startAnimation() {
        start();
    }

    public void stop() {
        setPaused(true);
    }

    @Override // com.stepos.activeview.elements.ActiveAnimation
    public void stopAnimation() {
        stop();
    }

    public GifMovieView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public GifMovieView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.LOG_TAG = "GifMovieView";
        this.mMovieResourceId = -1;
        this.mCurrentAnimationTime = 0;
        this.mWidthScale = 1.0f;
        this.mHeightScale = 1.0f;
        this.mPaused = false;
        this.mVisible = true;
        setViewAttributes(context, attributeSet, i4);
    }

    public void setMovieResource(String str) {
        this.mMovieResourcePath = str;
        long jCurrentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        this.mMovie = Movie.decodeFile(str);
        long jCurrentThreadTimeMillis2 = SystemClock.currentThreadTimeMillis();
        String str2 = this.LOG_TAG;
        StringBuilder sbW = g.w("Decord Gif file: ", str, ", UseTime =");
        sbW.append(String.valueOf(jCurrentThreadTimeMillis2 - jCurrentThreadTimeMillis));
        LogUtil.i(str2, sbW.toString());
        requestLayout();
    }
}
