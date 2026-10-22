package obric.app;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import obric.widget.R;

/* JADX INFO: loaded from: classes5.dex */
public class IndicatorView extends View {
    private static final int MAX_NUM_DOT = 25;
    private int mAll;
    private int mCur;
    private ArrayList<IconIndicator> mIconIndicators;
    private final Paint mPaintFill;
    private final Paint mPaintPageFill;
    private final Paint mPaintRect;
    private float mRadius;

    /* JADX INFO: renamed from: obric.app.IndicatorView$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class IconIndicator {
        Drawable normalDrawable;
        Drawable selectedDrawable;

        public IconIndicator(Drawable normal, Drawable selected) {
            this.normalDrawable = normal;
            this.selectedDrawable = selected;
        }
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        int currentPage;

        /* synthetic */ SavedState(Parcel r1, AnonymousClass1 r2) {
            this(r1);
        }

        public SavedState(Parcelable superState) {
            super(superState);
        }

        private SavedState(Parcel in) {
            super(in);
            this.currentPage = in.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(this.currentPage);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    public IndicatorView(Context context) {
        this(context, null);
    }

    public IndicatorView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public IndicatorView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mAll = 0;
        this.mCur = 0;
        Paint r1 = new Paint(1);
        this.mPaintPageFill = r1;
        Paint r3 = new Paint(1);
        this.mPaintFill = r3;
        Paint r4 = new Paint(1);
        this.mPaintRect = r4;
        Resources r2 = getResources();
        int r5 = r2.getColor(R.color.default_circle_indicator_page_color);
        int r6 = r2.getColor(R.color.default_circle_indicator_fill_color);
        float r7 = r2.getDimension(R.dimen.default_circle_indicator_radius);
        TypedArray r9 = context.obtainStyledAttributes(attrs, R.styleable.IndicatorView, defStyle, 0);
        r1.setStyle(Paint.Style.FILL);
        r1.setColor(r9.getColor(R.styleable.IndicatorView_pageColor, r5));
        r3.setStyle(Paint.Style.FILL);
        r3.setColor(r9.getColor(R.styleable.IndicatorView_fillColor, r6));
        r4.setColor(0);
        this.mRadius = r9.getDimension(R.styleable.IndicatorView_radius, r7);
        r9.recycle();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int r0 = this.mAll;
        if (r0 >= 0) goto L6;
        return;
    L6:
        if (r0 <= 25) goto L8;
        this.mAll = 25;
    L8:
        int r1 = 0;
        if (this.mCur >= 0) goto L11;
        this.mCur = 0;
    L11:
        int r2 = this.mCur;
        int r3 = this.mAll;
        if (r2 < r3) goto L15;
        this.mCur = r3 - 1;
    L15:
        if (r3 > 1) goto L17;
        return;
    L17:
        int r4 = getWidth();
        int r5 = getPaddingLeft();
        int r6 = getPaddingRight();
        int r7 = getPaddingTop();
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.mPaintRect);
        float r8 = this.mRadius;
        float r9 = 4.0f * r8;
        float r10 = r7 + (r8 * 2.0f);
        float r11 = (r5 + r8) + ((((r4 - r5) - r6) / 2.0f) - (((r9 / 2.0f) * ((this.mAll * 2) - 1)) / 2.0f));
        ArrayList<IconIndicator> r12 = this.mIconIndicators;
        if (r12 == null) goto L27;
        int r13 = r12.size();
        int r14 = 0;
    L20:
        if (r1 >= r13) goto L26;
        IconIndicator r15 = this.mIconIndicators.get(r1);
        if (this.mCur != r1) goto L24;
        Drawable r16 = r15.selectedDrawable;
    L25:
        int r17 = r16.getIntrinsicWidth();
        int r18 = r16.getIntrinsicHeight();
        int r19 = (int) ((r11 - (r17 / 2)) + r14);
        int r110 = (int) (r10 - (r18 / 2));
        r14 = r14 + r17;
        r16.setBounds(r19, r110, r19 + r17, r18 + r110);
        r16.draw(canvas);
        r1 = r1 + 1;
        goto L20
    L24:
        r16 = r15.normalDrawable;
        goto L25
    L26:
        r1 = r13;
    L27:
        int r20 = r1;
    L29:
        if (r20 >= this.mAll) goto L31;
        canvas.drawCircle((r20 * r9) + r11, r10, this.mRadius, this.mPaintPageFill);
        r20 = r20 + 1;
        goto L29
    L31:
        int r21 = this.mCur;
        if (r21 < r1) goto L39;
        canvas.drawCircle(r11 + (r21 * r9), r10, this.mRadius, this.mPaintFill);
        return;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureLong(widthMeasureSpec), measureShort(heightMeasureSpec));
    }

    private int measureLong(int measureSpec) {
        int r0 = View.MeasureSpec.getMode(measureSpec);
        int r5 = View.MeasureSpec.getSize(measureSpec);
        if (r0 == 1073741824) goto L11;
        int r1 = this.mAll;
        float r2 = getPaddingLeft() + getPaddingRight();
        float r4 = this.mRadius;
        int r6 = (int) (((r2 + ((r1 * 2) * r4)) + (((r1 - 1) * 2) * r4)) + 1.0f);
        if (r0 != Integer.MIN_VALUE) goto L9;
        return Math.min(r6, r5);
    L9:
        return r6;
    L11:
        return r5;
    }

    private int measureShort(int measureSpec) {
        int r0 = View.MeasureSpec.getMode(measureSpec);
        int r4 = View.MeasureSpec.getSize(measureSpec);
        if (r0 == 1073741824) goto L11;
        int r3 = (int) ((((this.mRadius * 4.0f) + getPaddingTop()) + getPaddingBottom()) + 1.0f);
        if (r0 != Integer.MIN_VALUE) goto L9;
        return Math.min(r3, r4);
    L9:
        return r3;
    L11:
        return r4;
    }

    public void setState(int all, int cur) {
        this.mAll = all;
        this.mCur = cur;
        setContentDescription(getContext().getResources().getString(R.string.indicator_content_des, new Object[]{Integer.valueOf(this.mCur + 1), Integer.valueOf(this.mAll)}));
        invalidate();
    }

    public void setState(int all) {
        this.mAll = all;
        setContentDescription(getContext().getResources().getString(R.string.indicator_content_des, new Object[]{Integer.valueOf(this.mCur + 1), Integer.valueOf(this.mAll)}));
        invalidate();
    }

    public void setPageColor(int color) {
        this.mPaintPageFill.setColor(color);
        invalidate();
    }

    public void setFillColor(int color) {
        this.mPaintFill.setColor(color);
        invalidate();
    }

    public void setRadius(float radius) {
        this.mRadius = radius;
        invalidate();
    }

    public void addIconIndicator(IconIndicator indicator) {
        if (this.mIconIndicators != null) goto L5;
        this.mIconIndicators = new ArrayList(2);
    L5:
        this.mIconIndicators.add(indicator);
        invalidate();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        SavedState r2 = (SavedState) state;
        super.onRestoreInstanceState(r2.getSuperState());
        this.mCur = r2.currentPage;
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        r1.currentPage = this.mCur;
        return r1;
    }
}
