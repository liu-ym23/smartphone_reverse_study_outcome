package com.obric.oui.progress;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.a;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public class OProgressView extends View {
    private int mBackgroundColor;
    private int mBackgroundColorRes;
    private RectF mBackgroundRectF;
    private Path mClipPath;
    private float mColorHeight;
    private Paint mPaint;
    private int mProgress;
    private int mProgressColor;
    private int mProgressColorRes;
    private RectF mProgressRectF;

    /* JADX INFO: renamed from: com.obric.oui.progress.OProgressView$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        int backgroundColor;
        int backgroundColorRes;
        int progress;
        int progressColor;
        int progressColorRes;

        /* synthetic */ SavedState(Parcel r1, AnonymousClass1 r2) {
            this(r1);
        }

        SavedState(Parcelable r3) {
            super((Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin"));
        }

        private SavedState(Parcel r2) {
            super(r2);
            this.progress = r2.readInt();
            this.progressColorRes = r2.readInt();
            this.backgroundColorRes = r2.readInt();
            this.progressColor = r2.readInt();
            this.backgroundColor = r2.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.progress);
            r1.writeInt(this.progressColorRes);
            r1.writeInt(this.backgroundColorRes);
            r1.writeInt(this.progressColor);
            r1.writeInt(this.backgroundColor);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    public OProgressView(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public OProgressView(Context r3, AttributeSet r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), 0);
    }

    public OProgressView(Context r3, AttributeSet r4, int r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), r5, 0);
    }

    public int getProgressColor() {
        return this.mProgressColor;
    }

    public void setProgressColor(int r2) {
        this.mProgressColorRes = 0;
        this.mProgressColor = r2;
        invalidate();
    }

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    @Override // android.view.View
    public void setBackgroundColor(int r2) {
        this.mBackgroundColorRes = 0;
        this.mBackgroundColor = r2;
        invalidate();
    }

    public OProgressView(Context r3, AttributeSet r4, int r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r7, r8, r5, r6);
        this.mClipPath = new Path();
        this.mProgressColorRes = 0;
        this.mBackgroundColorRes = 0;
        TypedArray r9 = r7.obtainStyledAttributes(r8, R.styleable.OProgressView, r5, r6);
        this.mProgress = r9.getInt(ZeusTransformUtils.mapRes(R.styleable.OProgressView_oui_progress, "styleable", "OProgressView_oui_progress"), 0);
        this.mProgressColorRes = r9.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OProgressView_oui_progress_color, "styleable", "OProgressView_oui_progress_color"), ZeusTransformUtils.mapRes(R.color.oui_fill_highlighted, "color", "oui_fill_highlighted"));
        this.mBackgroundColorRes = r9.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OProgressView_oui_background_color, "styleable", "OProgressView_oui_background_color"), ZeusTransformUtils.mapRes(R.color.oui_line_2, "color", "oui_line_2"));
        setProgressBackgroundHeight(r9.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OProgressView_oui_background_height, "styleable", "OProgressView_oui_background_height"), dp2px(6.0f)));
        updateColors();
        r9.recycle();
    }

    private int dp2px(float r1) {
        return (int) (r1 * Resources.getSystem().getDisplayMetrics().density);
    }

    private void updateColors() {
        if (this.mProgressColorRes == 0) goto L6;
        this.mProgressColor = a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this.mProgressColorRes);
    L6:
        if (this.mBackgroundColorRes == 0) goto L8;
        this.mBackgroundColor = a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this.mBackgroundColorRes);
    L8:
        invalidate();
    }

    public void setProgressBackgroundHeight(float r1) {
        this.mColorHeight = r1;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void setProgress(int r2) {
        if (this.mProgress != r2) goto L6;
        return;
    L6:
        if (r2 > 0) goto L8;
        r2 = 0;
    L10:
        this.mProgress = r2;
        invalidate();
        return;
    L8:
        if (r2 < 100) goto L10;
        r2 = 100;
        goto L10
    }

    @Override // android.view.View
    public void onDraw(Canvas r6) {
        super.onDraw(r6);
        if (this.mPaint != null) goto L5;
        this.mPaint = new Paint();
    L5:
        this.mPaint.reset();
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setAntiAlias(true);
        float r0 = getHeight();
        float r1 = (r0 - this.mColorHeight) / 2.0f;
        if (this.mBackgroundRectF != null) goto L8;
        this.mBackgroundRectF = new RectF();
    L8:
        float r2 = r0 - r1;
        this.mBackgroundRectF.set(0.0f, r1, getWidth(), r2);
        if (this.mProgressRectF != null) goto L11;
        this.mProgressRectF = new RectF();
    L11:
        this.mProgressRectF.set(0.0f, r1, (getWidth() * getProgress()) / 100.0f, r2);
        r6.save();
        this.mClipPath.reset();
        Path r3 = this.mClipPath;
        RectF r4 = this.mBackgroundRectF;
        float r5 = this.mColorHeight;
        r3.addRoundRect(r4, r5, r5, Path.Direction.CW);
        r6.clipPath(this.mClipPath);
        this.mPaint.setColor(this.mBackgroundColor);
        r6.drawRect(this.mBackgroundRectF, this.mPaint);
        this.mPaint.setColor(this.mProgressColor);
        r6.drawRect(this.mProgressRectF, this.mPaint);
        r6.restore();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        r1.progress = this.mProgress;
        r1.progressColorRes = this.mProgressColorRes;
        r1.backgroundColorRes = this.mBackgroundColorRes;
        r1.progressColor = this.mProgressColor;
        r1.backgroundColor = this.mBackgroundColor;
        return r1;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r3) {
        SavedState r4 = (SavedState) ZeusTransformUtils.preCheckCast((Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin"), SavedState.class, "com.obric.aiagent.plugin");
        super.onRestoreInstanceState(r4.getSuperState());
        setProgress(r4.progress);
        this.mProgressColorRes = r4.progressColorRes;
        this.mBackgroundColorRes = r4.backgroundColorRes;
        this.mProgressColor = r4.progressColor;
        this.mBackgroundColor = r4.backgroundColor;
        updateColors();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        updateColors();
    }

    @Override // android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }
}
